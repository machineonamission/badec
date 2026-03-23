package com.blueair.devicedetails.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentKt;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.blueair.android.activity.AccountLinkingActivity;
import com.blueair.core.model.AnalyticEvent;
import com.blueair.core.model.ConnectivityStatus;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceFilterType;
import com.blueair.core.model.FilterInfo;
import com.blueair.core.model.HasSKU;
import com.blueair.core.model.I18nConfig;
import com.blueair.devicedetails.activity.FilterVideoActivity;
import com.blueair.devicedetails.databinding.DialogfragmentDeviceNFilterBinding;
import com.blueair.devicedetails.dialog.DeviceDetailsDialogFragment;
import com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel;
import com.blueair.devicedetails.viewmodel.FilterLifeResetResult;
import com.blueair.push.NotificationService;
import com.blueair.viewcore.R;
import com.blueair.viewcore.activity.Actions;
import com.blueair.viewcore.adapter.DeviceFilterAdapter;
import com.blueair.viewcore.dialog.BaseDialogFragment;
import com.blueair.viewcore.dialog.ConfirmationDialogLeftAligned;
import com.blueair.viewcore.dialog.SelectDeviceFilterDialogFragment;
import com.blueair.viewcore.utils.DeviceConfigProvider;
import com.blueair.viewcore.utils.ToastUtils;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u0000 /2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001/B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J$\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u001a\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u001e2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\b\u0010(\u001a\u00020&H\u0002J\b\u0010)\u001a\u00020&H\u0002J\b\u0010*\u001a\u00020&H\u0016J\u0010\u0010+\u001a\u00020&2\u0006\u0010,\u001a\u00020\u001bH\u0016J\b\u0010-\u001a\u00020&H\u0016J\b\u0010.\u001a\u00020&H\u0016R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00068TX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u0002X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\u00068BX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\bR\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/blueair/devicedetails/dialog/DeviceNFilterDialogFragment;", "Lcom/blueair/viewcore/dialog/BaseDialogFragment;", "Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "_screenName", "viewModel", "getViewModel", "()Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;", "setViewModel", "(Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;)V", "binding", "Lcom/blueair/devicedetails/databinding/DialogfragmentDeviceNFilterBinding;", "filterAdapter", "Lcom/blueair/viewcore/adapter/DeviceFilterAdapter;", "device", "Lcom/blueair/core/model/HasSKU;", "deviceSku", "sku", "getSku", "type", "Lcom/blueair/core/model/DeviceFilterType;", "fromNotification", "", "onlyBuy", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "showDeviceOfflinePrompt", "refreshFilterScrollIndicators", "onStart", "showProgress", "shouldShowProgress", "onResume", "onPause", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceNFilterDialogFragment.kt */
public final class DeviceNFilterDialogFragment extends BaseDialogFragment<DeviceDetailsViewModel> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String EXTRA_FROM_NOTIFICATION = "extra_from_notification";
    private static final String EXTRA_ONLY_BUY = "EXTRA_ONLY_BUY";
    private static final String EXTRA_TYPE = "EXTRA_TYPE";
    /* access modifiers changed from: private */
    public static boolean shouldDismiss;
    private String _screenName;
    private DialogfragmentDeviceNFilterBinding binding;
    private HasSKU device;
    private String deviceSku;
    private final DeviceFilterAdapter filterAdapter = new DeviceFilterAdapter((Function1<? super FilterInfo, Unit>) null);
    private boolean fromNotification;
    private boolean onlyBuy;
    private DeviceFilterType type = DeviceFilterType.FILTER;
    public DeviceDetailsViewModel viewModel;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceNFilterDialogFragment.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|16|(2:17|18)|19|21) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0033 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x003b */
        static {
            /*
                com.blueair.core.model.DeviceFilterType[] r0 = com.blueair.core.model.DeviceFilterType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                r1 = 1
                com.blueair.core.model.DeviceFilterType r2 = com.blueair.core.model.DeviceFilterType.FILTER     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                r2 = 2
                com.blueair.core.model.DeviceFilterType r3 = com.blueair.core.model.DeviceFilterType.WICK     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                r3 = 3
                com.blueair.core.model.DeviceFilterType r4 = com.blueair.core.model.DeviceFilterType.REFRESHER     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r0[r4] = r3     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                $EnumSwitchMapping$0 = r0
                com.blueair.devicedetails.viewmodel.FilterLifeResetResult[] r0 = com.blueair.devicedetails.viewmodel.FilterLifeResetResult.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.blueair.devicedetails.viewmodel.FilterLifeResetResult r4 = com.blueair.devicedetails.viewmodel.FilterLifeResetResult.SUCCESS     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r0[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                com.blueair.devicedetails.viewmodel.FilterLifeResetResult r1 = com.blueair.devicedetails.viewmodel.FilterLifeResetResult.FAILED     // Catch:{ NoSuchFieldError -> 0x003b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003b }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003b }
            L_0x003b:
                com.blueair.devicedetails.viewmodel.FilterLifeResetResult r1 = com.blueair.devicedetails.viewmodel.FilterLifeResetResult.DEVICE_OFFLINE     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                $EnumSwitchMapping$1 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.dialog.DeviceNFilterDialogFragment.WhenMappings.<clinit>():void");
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J4\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\t2\b\b\u0002\u0010\u0016\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/blueair/devicedetails/dialog/DeviceNFilterDialogFragment$Companion;", "", "<init>", "()V", "EXTRA_ONLY_BUY", "", "EXTRA_TYPE", "EXTRA_FROM_NOTIFICATION", "shouldDismiss", "", "getShouldDismiss", "()Z", "setShouldDismiss", "(Z)V", "newInstance", "Lcom/blueair/devicedetails/dialog/DeviceNFilterDialogFragment;", "device", "Lcom/blueair/core/model/Device;", "deviceSku", "type", "Lcom/blueair/core/model/DeviceFilterType;", "onlyBuy", "fromNotification", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceNFilterDialogFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean getShouldDismiss() {
            return DeviceNFilterDialogFragment.shouldDismiss;
        }

        public final void setShouldDismiss(boolean z) {
            DeviceNFilterDialogFragment.shouldDismiss = z;
        }

        public static /* synthetic */ DeviceNFilterDialogFragment newInstance$default(Companion companion, Device device, String str, DeviceFilterType deviceFilterType, boolean z, boolean z2, int i, Object obj) {
            if ((i & 16) != 0) {
                z2 = false;
            }
            return companion.newInstance(device, str, deviceFilterType, z, z2);
        }

        public final DeviceNFilterDialogFragment newInstance(Device device, String str, DeviceFilterType deviceFilterType, boolean z, boolean z2) {
            Intrinsics.checkNotNullParameter(deviceFilterType, "type");
            String str2 = z2 ? AnalyticEvent.ScreenViewEvent.NOTIFICATIONS_FILTER : AnalyticEvent.ScreenViewEvent.DEVICE_DETAILS_FILTER;
            DeviceNFilterDialogFragment deviceNFilterDialogFragment = new DeviceNFilterDialogFragment();
            deviceNFilterDialogFragment.setArguments(BundleKt.bundleOf(TuplesKt.to("screen_name", str2), TuplesKt.to("device", device), TuplesKt.to(Actions.EXTRA_DEVICE_SKU, str), TuplesKt.to(DeviceNFilterDialogFragment.EXTRA_TYPE, deviceFilterType.name()), TuplesKt.to(DeviceNFilterDialogFragment.EXTRA_ONLY_BUY, Boolean.valueOf(z)), TuplesKt.to(DeviceNFilterDialogFragment.EXTRA_FROM_NOTIFICATION, Boolean.valueOf(z2))));
            return deviceNFilterDialogFragment;
        }
    }

    /* access modifiers changed from: protected */
    public String getScreenName() {
        return this._screenName;
    }

    public DeviceDetailsViewModel getViewModel() {
        DeviceDetailsViewModel deviceDetailsViewModel = this.viewModel;
        if (deviceDetailsViewModel != null) {
            return deviceDetailsViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        return null;
    }

    public void setViewModel(DeviceDetailsViewModel deviceDetailsViewModel) {
        Intrinsics.checkNotNullParameter(deviceDetailsViewModel, "<set-?>");
        this.viewModel = deviceDetailsViewModel;
    }

    private final String getSku() {
        String sku;
        HasSKU hasSKU = this.device;
        if (hasSKU != null && (sku = hasSKU.getSku()) != null) {
            return sku;
        }
        String str = this.deviceSku;
        return str == null ? "" : str;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Window window;
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        shouldDismiss = false;
        setStyle(0, R.style.DialogTheme);
        Dialog dialog = getDialog();
        if (!(dialog == null || (window = dialog.getWindow()) == null)) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setWindowAnimations(R.style.dialog_animation);
            window.setGravity(80);
        }
        Bundle requireArguments = requireArguments();
        this._screenName = requireArguments.getString("screen_name");
        this.device = (HasSKU) requireArguments.getParcelable("device");
        this.deviceSku = requireArguments.getString(Actions.EXTRA_DEVICE_SKU);
        String string = requireArguments.getString(EXTRA_TYPE, "FILTER");
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        this.type = DeviceFilterType.valueOf(string);
        this.onlyBuy = requireArguments.getBoolean(EXTRA_ONLY_BUY, false);
        this.fromNotification = requireArguments.getBoolean(EXTRA_FROM_NOTIFICATION, false);
        DialogfragmentDeviceNFilterBinding inflate = DialogfragmentDeviceNFilterBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        setViewModel((DeviceDetailsViewModel) ((BaseViewModel) new ViewModelProvider((ViewModelStoreOwner) this).get(DeviceDetailsViewModel.class)));
        DialogfragmentDeviceNFilterBinding dialogfragmentDeviceNFilterBinding = this.binding;
        if (dialogfragmentDeviceNFilterBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogfragmentDeviceNFilterBinding = null;
        }
        View root = dialogfragmentDeviceNFilterBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    /* JADX WARNING: Removed duplicated region for block: B:148:0x02e3  */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x02ed  */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x0364  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onViewCreated(android.view.View r23, android.os.Bundle r24) {
        /*
            r22 = this;
            r0 = r22
            java.lang.String r1 = "view"
            r2 = r23
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r1)
            super.onViewCreated(r23, r24)
            com.blueair.devicedetails.databinding.DialogfragmentDeviceNFilterBinding r1 = r0.binding
            java.lang.String r2 = "binding"
            if (r1 != 0) goto L_0x0016
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r1 = 0
        L_0x0016:
            android.widget.ImageButton r1 = r1.closeBtn
            com.blueair.devicedetails.dialog.DeviceNFilterDialogFragment$$ExternalSyntheticLambda0 r4 = new com.blueair.devicedetails.dialog.DeviceNFilterDialogFragment$$ExternalSyntheticLambda0
            r4.<init>(r0)
            r1.setOnClickListener(r4)
            com.blueair.viewcore.utils.DeviceConfigProvider r1 = com.blueair.viewcore.utils.DeviceConfigProvider.INSTANCE
            java.lang.String r4 = r0.getSku()
            com.blueair.core.model.DeviceFilterType r5 = r0.type
            com.blueair.core.model.FilterConfig r1 = r1.getFilterConfig((java.lang.String) r4, (com.blueair.core.model.DeviceFilterType) r5)
            com.blueair.core.model.DeviceFilterType r4 = r0.type
            int[] r5 = com.blueair.devicedetails.dialog.DeviceNFilterDialogFragment.WhenMappings.$EnumSwitchMapping$0
            int r4 = r4.ordinal()
            r4 = r5[r4]
            r5 = 3
            r6 = 2
            java.lang.String r7 = "getString(...)"
            r8 = 1
            if (r4 == r8) goto L_0x0171
            if (r4 == r6) goto L_0x00dc
            if (r4 != r5) goto L_0x00d6
            com.blueair.devicedetails.databinding.DialogfragmentDeviceNFilterBinding r4 = r0.binding
            if (r4 != 0) goto L_0x0049
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r4 = 0
        L_0x0049:
            android.widget.TextView r4 = r4.title
            boolean r9 = r0.onlyBuy
            if (r9 == 0) goto L_0x0052
            int r9 = com.blueair.viewcore.R.string.action_buy_refresher
            goto L_0x0054
        L_0x0052:
            int r9 = com.blueair.viewcore.R.string.how_to_replace_your_refresher
        L_0x0054:
            r4.setText(r9)
            com.blueair.devicedetails.databinding.DialogfragmentDeviceNFilterBinding r4 = r0.binding
            if (r4 != 0) goto L_0x005f
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r4 = 0
        L_0x005f:
            android.widget.TextView r4 = r4.whyIsThisImportant
            int r9 = com.blueair.viewcore.R.string.why_is_this_important_wick
            r4.setText(r9)
            com.blueair.devicedetails.databinding.DialogfragmentDeviceNFilterBinding r4 = r0.binding
            if (r4 != 0) goto L_0x006e
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r4 = 0
        L_0x006e:
            android.widget.TextView r4 = r4.videoSummary
            int r9 = com.blueair.viewcore.R.string.video_summary_refresher
            r4.setText(r9)
            com.blueair.devicedetails.databinding.DialogfragmentDeviceNFilterBinding r4 = r0.binding
            if (r4 != 0) goto L_0x007d
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r4 = 0
        L_0x007d:
            android.widget.TextView r4 = r4.availableFilters
            int r9 = com.blueair.viewcore.R.string.available_refreshers
            r4.setText(r9)
            com.blueair.devicedetails.databinding.DialogfragmentDeviceNFilterBinding r4 = r0.binding
            if (r4 != 0) goto L_0x008c
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r4 = 0
        L_0x008c:
            com.google.android.material.button.MaterialButton r4 = r4.btnAntiFake
            int r9 = com.blueair.viewcore.R.string.replace_water_refresher
            r4.setText(r9)
            com.blueair.devicedetails.databinding.DialogfragmentDeviceNFilterBinding r4 = r0.binding
            if (r4 != 0) goto L_0x009b
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r4 = 0
        L_0x009b:
            com.google.android.material.button.MaterialButton r4 = r4.btnResetFilter
            int r9 = com.blueair.viewcore.R.string.action_reset_refresher
            r4.setText(r9)
            com.blueair.devicedetails.databinding.DialogfragmentDeviceNFilterBinding r4 = r0.binding
            if (r4 != 0) goto L_0x00aa
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r4 = 0
        L_0x00aa:
            android.widget.TextView r4 = r4.buyNewFilter
            int r9 = com.blueair.viewcore.R.string.action_buy_refresher
            r4.setText(r9)
            com.blueair.devicedetails.databinding.DialogfragmentDeviceNFilterBinding r4 = r0.binding
            if (r4 != 0) goto L_0x00b9
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r4 = 0
        L_0x00b9:
            com.google.android.material.button.MaterialButton r4 = r4.btnSubscribe
            int r9 = com.blueair.viewcore.R.string.action_goto_subscription
            r4.setText(r9)
            int r4 = com.blueair.viewcore.R.string.select_refresher
            java.lang.String r4 = r0.getString(r4)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r7)
            int r9 = com.blueair.viewcore.R.string.order_refresher
            java.lang.String r9 = r0.getString(r9)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r7)
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            goto L_0x0204
        L_0x00d6:
            kotlin.NoWhenBranchMatchedException r1 = new kotlin.NoWhenBranchMatchedException
            r1.<init>()
            throw r1
        L_0x00dc:
            com.blueair.devicedetails.databinding.DialogfragmentDeviceNFilterBinding r4 = r0.binding
            if (r4 != 0) goto L_0x00e4
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r4 = 0
        L_0x00e4:
            android.widget.TextView r4 = r4.title
            boolean r9 = r0.onlyBuy
            if (r9 == 0) goto L_0x00ed
            int r9 = com.blueair.viewcore.R.string.buy_new_wick_filter
            goto L_0x00ef
        L_0x00ed:
            int r9 = com.blueair.viewcore.R.string.how_to_replace_wick_filter
        L_0x00ef:
            r4.setText(r9)
            com.blueair.devicedetails.databinding.DialogfragmentDeviceNFilterBinding r4 = r0.binding
            if (r4 != 0) goto L_0x00fa
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r4 = 0
        L_0x00fa:
            android.widget.TextView r4 = r4.whyIsThisImportant
            int r9 = com.blueair.viewcore.R.string.why_is_this_important_wick
            r4.setText(r9)
            com.blueair.devicedetails.databinding.DialogfragmentDeviceNFilterBinding r4 = r0.binding
            if (r4 != 0) goto L_0x0109
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r4 = 0
        L_0x0109:
            android.widget.TextView r4 = r4.videoSummary
            int r9 = com.blueair.viewcore.R.string.video_summary_wick
            r4.setText(r9)
            com.blueair.devicedetails.databinding.DialogfragmentDeviceNFilterBinding r4 = r0.binding
            if (r4 != 0) goto L_0x0118
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r4 = 0
        L_0x0118:
            android.widget.TextView r4 = r4.availableFilters
            int r9 = com.blueair.viewcore.R.string.available_wicks
            r4.setText(r9)
            com.blueair.devicedetails.databinding.DialogfragmentDeviceNFilterBinding r4 = r0.binding
            if (r4 != 0) goto L_0x0127
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r4 = 0
        L_0x0127:
            com.google.android.material.button.MaterialButton r4 = r4.btnAntiFake
            int r9 = com.blueair.viewcore.R.string.replace_wick_filter
            r4.setText(r9)
            com.blueair.devicedetails.databinding.DialogfragmentDeviceNFilterBinding r4 = r0.binding
            if (r4 != 0) goto L_0x0136
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r4 = 0
        L_0x0136:
            com.google.android.material.button.MaterialButton r4 = r4.btnResetFilter
            int r9 = com.blueair.viewcore.R.string.reset_wick_life
            r4.setText(r9)
            com.blueair.devicedetails.databinding.DialogfragmentDeviceNFilterBinding r4 = r0.binding
            if (r4 != 0) goto L_0x0145
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r4 = 0
        L_0x0145:
            android.widget.TextView r4 = r4.buyNewFilter
            int r9 = com.blueair.viewcore.R.string.buy_new_wick_filter
            r4.setText(r9)
            com.blueair.devicedetails.databinding.DialogfragmentDeviceNFilterBinding r4 = r0.binding
            if (r4 != 0) goto L_0x0154
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r4 = 0
        L_0x0154:
            com.google.android.material.button.MaterialButton r4 = r4.btnSubscribe
            int r9 = com.blueair.viewcore.R.string.wick_start_subscription
            r4.setText(r9)
            int r4 = com.blueair.viewcore.R.string.select_wick
            java.lang.String r4 = r0.getString(r4)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r7)
            int r9 = com.blueair.viewcore.R.string.order_wick
            java.lang.String r9 = r0.getString(r9)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r7)
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            goto L_0x0204
        L_0x0171:
            com.blueair.devicedetails.databinding.DialogfragmentDeviceNFilterBinding r4 = r0.binding
            if (r4 != 0) goto L_0x0179
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r4 = 0
        L_0x0179:
            android.widget.TextView r4 = r4.title
            boolean r9 = r0.onlyBuy
            if (r9 == 0) goto L_0x0182
            int r9 = com.blueair.viewcore.R.string.buy_new_filter
            goto L_0x0184
        L_0x0182:
            int r9 = com.blueair.viewcore.R.string.how_to_replace_filter
        L_0x0184:
            r4.setText(r9)
            com.blueair.devicedetails.databinding.DialogfragmentDeviceNFilterBinding r4 = r0.binding
            if (r4 != 0) goto L_0x018f
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r4 = 0
        L_0x018f:
            android.widget.TextView r4 = r4.whyIsThisImportant
            int r9 = com.blueair.viewcore.R.string.why_is_this_important
            r4.setText(r9)
            com.blueair.devicedetails.databinding.DialogfragmentDeviceNFilterBinding r4 = r0.binding
            if (r4 != 0) goto L_0x019e
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r4 = 0
        L_0x019e:
            android.widget.TextView r4 = r4.videoSummary
            int r9 = com.blueair.viewcore.R.string.video_summary
            r4.setText(r9)
            com.blueair.devicedetails.databinding.DialogfragmentDeviceNFilterBinding r4 = r0.binding
            if (r4 != 0) goto L_0x01ad
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r4 = 0
        L_0x01ad:
            android.widget.TextView r4 = r4.availableFilters
            int r9 = com.blueair.viewcore.R.string.available_filters
            r4.setText(r9)
            com.blueair.devicedetails.databinding.DialogfragmentDeviceNFilterBinding r4 = r0.binding
            if (r4 != 0) goto L_0x01bc
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r4 = 0
        L_0x01bc:
            com.google.android.material.button.MaterialButton r4 = r4.btnAntiFake
            int r9 = com.blueair.viewcore.R.string.replace_filter
            r4.setText(r9)
            com.blueair.devicedetails.databinding.DialogfragmentDeviceNFilterBinding r4 = r0.binding
            if (r4 != 0) goto L_0x01cb
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r4 = 0
        L_0x01cb:
            com.google.android.material.button.MaterialButton r4 = r4.btnResetFilter
            int r9 = com.blueair.viewcore.R.string.reset_filter_life
            r4.setText(r9)
            com.blueair.devicedetails.databinding.DialogfragmentDeviceNFilterBinding r4 = r0.binding
            if (r4 != 0) goto L_0x01da
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r4 = 0
        L_0x01da:
            android.widget.TextView r4 = r4.buyNewFilter
            int r9 = com.blueair.viewcore.R.string.buy_new_filter
            r4.setText(r9)
            com.blueair.devicedetails.databinding.DialogfragmentDeviceNFilterBinding r4 = r0.binding
            if (r4 != 0) goto L_0x01e9
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r4 = 0
        L_0x01e9:
            com.google.android.material.button.MaterialButton r4 = r4.btnSubscribe
            int r9 = com.blueair.viewcore.R.string.filter_start_subscription
            r4.setText(r9)
            int r4 = com.blueair.viewcore.R.string.select_filter
            java.lang.String r4 = r0.getString(r4)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r7)
            int r9 = com.blueair.viewcore.R.string.order_filter
            java.lang.String r9 = r0.getString(r9)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r7)
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
        L_0x0204:
            com.blueair.viewcore.utils.DeviceConfigProvider r7 = com.blueair.viewcore.utils.DeviceConfigProvider.INSTANCE
            if (r1 == 0) goto L_0x020d
            com.blueair.core.model.AwsLinkConfig r10 = r1.getVideo()
            goto L_0x020e
        L_0x020d:
            r10 = 0
        L_0x020e:
            java.lang.String r7 = r7.getAwsLinkValue(r10)
            r10 = r7
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            java.lang.String r11 = "replaceGroup"
            if (r10 == 0) goto L_0x021f
            int r12 = r10.length()
            if (r12 != 0) goto L_0x0231
        L_0x021f:
            com.blueair.devicedetails.databinding.DialogfragmentDeviceNFilterBinding r12 = r0.binding
            if (r12 != 0) goto L_0x0227
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r12 = 0
        L_0x0227:
            androidx.constraintlayout.widget.Group r12 = r12.replaceGroup
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r11)
            android.view.View r12 = (android.view.View) r12
            io.flatcircle.viewhelper.ViewExtensionsKt.hide(r12)
        L_0x0231:
            java.lang.String r12 = "discountHint"
            java.lang.String r13 = "btnSubscribe"
            java.lang.String r14 = "btnPurchase"
            java.lang.String r15 = "filterList"
            java.lang.String r3 = "availableFilters"
            java.lang.String r5 = "buyNewFilter"
            java.lang.String r6 = "btnAntiFake"
            if (r1 == 0) goto L_0x03a0
            java.util.List r17 = r1.getFilters()
            boolean r17 = r17.isEmpty()
            if (r17 == 0) goto L_0x024d
            goto L_0x03a0
        L_0x024d:
            java.util.List r17 = r1.getFilters()
            r8 = r17
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            r17 = r1
            boolean r1 = r8 instanceof java.util.Collection
            if (r1 == 0) goto L_0x0266
            r1 = r8
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x0266
        L_0x0264:
            r1 = 0
            goto L_0x0297
        L_0x0266:
            java.util.Iterator r1 = r8.iterator()
        L_0x026a:
            boolean r8 = r1.hasNext()
            if (r8 == 0) goto L_0x0264
            java.lang.Object r8 = r1.next()
            com.blueair.core.model.FilterInfo r8 = (com.blueair.core.model.FilterInfo) r8
            r18 = r1
            com.blueair.viewcore.utils.DeviceConfigProvider r1 = com.blueair.viewcore.utils.DeviceConfigProvider.INSTANCE
            com.blueair.core.model.IpConfig r8 = r8.getLinkPurchase()
            java.lang.String r1 = r1.getIpConfigValue(r8)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            if (r1 == 0) goto L_0x028f
            int r1 = r1.length()
            if (r1 != 0) goto L_0x028d
            goto L_0x028f
        L_0x028d:
            r1 = 0
            goto L_0x0290
        L_0x028f:
            r1 = 1
        L_0x0290:
            if (r1 != 0) goto L_0x0294
            r1 = 1
            goto L_0x0297
        L_0x0294:
            r1 = r18
            goto L_0x026a
        L_0x0297:
            java.util.List r8 = r17.getFilters()
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            r18 = r2
            boolean r2 = r8 instanceof java.util.Collection
            if (r2 == 0) goto L_0x02ae
            r2 = r8
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x02ae
        L_0x02ac:
            r2 = 0
            goto L_0x02df
        L_0x02ae:
            java.util.Iterator r2 = r8.iterator()
        L_0x02b2:
            boolean r8 = r2.hasNext()
            if (r8 == 0) goto L_0x02ac
            java.lang.Object r8 = r2.next()
            com.blueair.core.model.FilterInfo r8 = (com.blueair.core.model.FilterInfo) r8
            r19 = r2
            com.blueair.viewcore.utils.DeviceConfigProvider r2 = com.blueair.viewcore.utils.DeviceConfigProvider.INSTANCE
            com.blueair.core.model.IpConfig r8 = r8.getLinkSubscribe()
            java.lang.String r2 = r2.getIpConfigValue(r8)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            if (r2 == 0) goto L_0x02d7
            int r2 = r2.length()
            if (r2 != 0) goto L_0x02d5
            goto L_0x02d7
        L_0x02d5:
            r2 = 0
            goto L_0x02d8
        L_0x02d7:
            r2 = 1
        L_0x02d8:
            if (r2 != 0) goto L_0x02dc
            r2 = 1
            goto L_0x02df
        L_0x02dc:
            r2 = r19
            goto L_0x02b2
        L_0x02df:
            com.blueair.devicedetails.databinding.DialogfragmentDeviceNFilterBinding r8 = r0.binding
            if (r8 != 0) goto L_0x02e7
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r18)
            r8 = 0
        L_0x02e7:
            r19 = r10
            boolean r10 = r0.onlyBuy
            if (r10 != 0) goto L_0x0364
            com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel r10 = r0.getViewModel()
            r20 = r11
            com.blueair.core.model.HasSKU r11 = r0.device
            com.blueair.core.model.Device r11 = (com.blueair.core.model.Device) r11
            boolean r10 = r10.deviceSupportAntiFake(r11)
            com.google.android.material.button.MaterialButton r11 = r8.btnAntiFake
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r6)
            android.view.View r11 = (android.view.View) r11
            io.flatcircle.viewhelper.ViewExtensionsKt.show(r11, r10)
            com.google.android.material.button.MaterialButton r11 = r8.btnResetFilter
            r21 = r10
            java.lang.String r10 = "btnResetFilter"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r10)
            android.view.View r11 = (android.view.View) r11
            if (r21 != 0) goto L_0x031a
            com.blueair.core.model.HasSKU r10 = r0.device
            boolean r10 = r10 instanceof com.blueair.core.model.DeviceBlue
            if (r10 != 0) goto L_0x031a
            r10 = 1
            goto L_0x031b
        L_0x031a:
            r10 = 0
        L_0x031b:
            io.flatcircle.viewhelper.ViewExtensionsKt.show(r11, r10)
            com.blueair.core.model.DeviceFilterType r10 = r0.type
            int[] r11 = com.blueair.devicedetails.dialog.DeviceNFilterDialogFragment.WhenMappings.$EnumSwitchMapping$0
            int r10 = r10.ordinal()
            r10 = r11[r10]
            r11 = 1
            if (r10 == r11) goto L_0x0345
            r11 = 2
            if (r10 == r11) goto L_0x033e
            r11 = 3
            if (r10 != r11) goto L_0x0338
            int r10 = com.blueair.viewcore.R.string.action_reset_refresher
            int r11 = com.blueair.viewcore.R.string.reset_refresher_msg_lower
            kotlin.Unit r16 = kotlin.Unit.INSTANCE
            goto L_0x034b
        L_0x0338:
            kotlin.NoWhenBranchMatchedException r1 = new kotlin.NoWhenBranchMatchedException
            r1.<init>()
            throw r1
        L_0x033e:
            int r10 = com.blueair.viewcore.R.string.reset_wick_life
            int r11 = com.blueair.viewcore.R.string.reset_wick_life_confirm_msg
            kotlin.Unit r16 = kotlin.Unit.INSTANCE
            goto L_0x034b
        L_0x0345:
            int r10 = com.blueair.viewcore.R.string.reset_filter_life
            int r11 = com.blueair.viewcore.R.string.reset_filter_life_confirm_msg
            kotlin.Unit r16 = kotlin.Unit.INSTANCE
        L_0x034b:
            r16 = r4
            com.google.android.material.button.MaterialButton r4 = r8.btnAntiFake
            r21 = r9
            com.blueair.devicedetails.dialog.DeviceNFilterDialogFragment$$ExternalSyntheticLambda3 r9 = new com.blueair.devicedetails.dialog.DeviceNFilterDialogFragment$$ExternalSyntheticLambda3
            r9.<init>(r0)
            r4.setOnClickListener(r9)
            com.google.android.material.button.MaterialButton r4 = r8.btnResetFilter
            com.blueair.devicedetails.dialog.DeviceNFilterDialogFragment$$ExternalSyntheticLambda4 r9 = new com.blueair.devicedetails.dialog.DeviceNFilterDialogFragment$$ExternalSyntheticLambda4
            r9.<init>(r0, r10, r11)
            r4.setOnClickListener(r9)
            goto L_0x036a
        L_0x0364:
            r16 = r4
            r21 = r9
            r20 = r11
        L_0x036a:
            android.widget.TextView r4 = r8.buyNewFilter
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            android.view.View r4 = (android.view.View) r4
            boolean r9 = r0.onlyBuy
            if (r9 != 0) goto L_0x037b
            if (r1 != 0) goto L_0x0379
            if (r2 == 0) goto L_0x037b
        L_0x0379:
            r9 = 1
            goto L_0x037c
        L_0x037b:
            r9 = 0
        L_0x037c:
            io.flatcircle.viewhelper.ViewExtensionsKt.show(r4, r9)
            com.google.android.material.button.MaterialButton r4 = r8.btnPurchase
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r14)
            android.view.View r4 = (android.view.View) r4
            io.flatcircle.viewhelper.ViewExtensionsKt.show(r4, r1)
            com.google.android.material.button.MaterialButton r1 = r8.btnSubscribe
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r13)
            android.view.View r1 = (android.view.View) r1
            io.flatcircle.viewhelper.ViewExtensionsKt.show(r1, r2)
            android.widget.TextView r1 = r8.discountHint
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r12)
            android.view.View r1 = (android.view.View) r1
            io.flatcircle.viewhelper.ViewExtensionsKt.show(r1, r2)
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            goto L_0x03fc
        L_0x03a0:
            r17 = r1
            r18 = r2
            r16 = r4
            r21 = r9
            r19 = r10
            r20 = r11
            com.blueair.devicedetails.databinding.DialogfragmentDeviceNFilterBinding r1 = r0.binding
            if (r1 != 0) goto L_0x03b4
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r18)
            r1 = 0
        L_0x03b4:
            android.widget.TextView r2 = r1.availableFilters
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            android.view.View r2 = (android.view.View) r2
            io.flatcircle.viewhelper.ViewExtensionsKt.hide(r2)
            androidx.recyclerview.widget.RecyclerView r2 = r1.filterList
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r15)
            android.view.View r2 = (android.view.View) r2
            io.flatcircle.viewhelper.ViewExtensionsKt.hide(r2)
            com.google.android.material.button.MaterialButton r2 = r1.btnAntiFake
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r6)
            android.view.View r2 = (android.view.View) r2
            io.flatcircle.viewhelper.ViewExtensionsKt.hide(r2)
            android.widget.TextView r2 = r1.buyNewFilter
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r5)
            android.view.View r2 = (android.view.View) r2
            io.flatcircle.viewhelper.ViewExtensionsKt.hide(r2)
            com.google.android.material.button.MaterialButton r2 = r1.btnPurchase
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r14)
            android.view.View r2 = (android.view.View) r2
            io.flatcircle.viewhelper.ViewExtensionsKt.hide(r2)
            com.google.android.material.button.MaterialButton r2 = r1.btnSubscribe
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r13)
            android.view.View r2 = (android.view.View) r2
            io.flatcircle.viewhelper.ViewExtensionsKt.hide(r2)
            android.widget.TextView r1 = r1.discountHint
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r12)
            android.view.View r1 = (android.view.View) r1
            io.flatcircle.viewhelper.ViewExtensionsKt.hide(r1)
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
        L_0x03fc:
            if (r19 == 0) goto L_0x04d2
            int r1 = r19.length()
            if (r1 != 0) goto L_0x0406
            goto L_0x04d2
        L_0x0406:
            com.blueair.devicedetails.databinding.DialogfragmentDeviceNFilterBinding r1 = r0.binding
            if (r1 != 0) goto L_0x040e
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r18)
            r1 = 0
        L_0x040e:
            androidx.appcompat.widget.AppCompatImageView r1 = r1.videoThumbnail
            kotlin.jvm.internal.Intrinsics.checkNotNull(r17)
            int r2 = r17.getVideoThumbnail()
            r1.setImageResource(r2)
            com.blueair.devicedetails.databinding.DialogfragmentDeviceNFilterBinding r1 = r0.binding
            if (r1 != 0) goto L_0x0422
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r18)
            r1 = 0
        L_0x0422:
            androidx.appcompat.widget.AppCompatImageButton r1 = r1.iconPlay
            com.blueair.devicedetails.dialog.DeviceNFilterDialogFragment$$ExternalSyntheticLambda5 r2 = new com.blueair.devicedetails.dialog.DeviceNFilterDialogFragment$$ExternalSyntheticLambda5
            r2.<init>(r0, r7)
            r1.setOnClickListener(r2)
            com.blueair.devicedetails.databinding.DialogfragmentDeviceNFilterBinding r1 = r0.binding
            if (r1 != 0) goto L_0x0434
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r18)
            r1 = 0
        L_0x0434:
            androidx.recyclerview.widget.RecyclerView r1 = r1.filterList
            androidx.recyclerview.widget.LinearLayoutManager r2 = new androidx.recyclerview.widget.LinearLayoutManager
            android.content.Context r4 = r0.requireContext()
            r7 = 0
            r2.<init>(r4, r7, r7)
            androidx.recyclerview.widget.RecyclerView$LayoutManager r2 = (androidx.recyclerview.widget.RecyclerView.LayoutManager) r2
            r1.setLayoutManager(r2)
            com.blueair.devicedetails.databinding.DialogfragmentDeviceNFilterBinding r1 = r0.binding
            if (r1 != 0) goto L_0x044d
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r18)
            r1 = 0
        L_0x044d:
            androidx.recyclerview.widget.RecyclerView r1 = r1.filterList
            com.blueair.devicedetails.dialog.DeviceNFilterDialogFragment$onViewCreated$5 r2 = new com.blueair.devicedetails.dialog.DeviceNFilterDialogFragment$onViewCreated$5
            r2.<init>(r0)
            androidx.recyclerview.widget.RecyclerView$OnScrollListener r2 = (androidx.recyclerview.widget.RecyclerView.OnScrollListener) r2
            r1.addOnScrollListener(r2)
            com.blueair.devicedetails.databinding.DialogfragmentDeviceNFilterBinding r1 = r0.binding
            if (r1 != 0) goto L_0x0461
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r18)
            r1 = 0
        L_0x0461:
            androidx.recyclerview.widget.RecyclerView r1 = r1.filterList
            com.blueair.viewcore.adapter.DeviceFilterAdapter r2 = r0.filterAdapter
            androidx.recyclerview.widget.RecyclerView$Adapter r2 = (androidx.recyclerview.widget.RecyclerView.Adapter) r2
            r1.setAdapter(r2)
            java.util.List r1 = r17.getFilters()
            com.blueair.viewcore.adapter.DeviceFilterAdapter r2 = r0.filterAdapter
            r2.setFilters(r1)
            r2 = r1
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = r2.isEmpty()
            if (r2 != 0) goto L_0x04d2
            int r2 = r1.size()
            r11 = 1
            if (r2 != r11) goto L_0x04aa
            com.blueair.devicedetails.databinding.DialogfragmentDeviceNFilterBinding r2 = r0.binding
            if (r2 != 0) goto L_0x048b
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r18)
            r2 = 0
        L_0x048b:
            com.google.android.material.button.MaterialButton r2 = r2.btnSubscribe
            com.blueair.devicedetails.dialog.DeviceNFilterDialogFragment$$ExternalSyntheticLambda6 r4 = new com.blueair.devicedetails.dialog.DeviceNFilterDialogFragment$$ExternalSyntheticLambda6
            r9 = r21
            r4.<init>(r0, r1, r9)
            r2.setOnClickListener(r4)
            com.blueair.devicedetails.databinding.DialogfragmentDeviceNFilterBinding r2 = r0.binding
            if (r2 != 0) goto L_0x049f
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r18)
            r2 = 0
        L_0x049f:
            com.google.android.material.button.MaterialButton r2 = r2.btnPurchase
            com.blueair.devicedetails.dialog.DeviceNFilterDialogFragment$$ExternalSyntheticLambda7 r4 = new com.blueair.devicedetails.dialog.DeviceNFilterDialogFragment$$ExternalSyntheticLambda7
            r4.<init>(r0, r1, r9)
            r2.setOnClickListener(r4)
            goto L_0x04d2
        L_0x04aa:
            r9 = r21
            com.blueair.devicedetails.databinding.DialogfragmentDeviceNFilterBinding r2 = r0.binding
            if (r2 != 0) goto L_0x04b4
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r18)
            r2 = 0
        L_0x04b4:
            com.google.android.material.button.MaterialButton r2 = r2.btnSubscribe
            com.blueair.devicedetails.dialog.DeviceNFilterDialogFragment$$ExternalSyntheticLambda8 r4 = new com.blueair.devicedetails.dialog.DeviceNFilterDialogFragment$$ExternalSyntheticLambda8
            r7 = r16
            r4.<init>(r0, r7, r1, r9)
            r2.setOnClickListener(r4)
            com.blueair.devicedetails.databinding.DialogfragmentDeviceNFilterBinding r2 = r0.binding
            if (r2 != 0) goto L_0x04c8
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r18)
            r2 = 0
        L_0x04c8:
            com.google.android.material.button.MaterialButton r2 = r2.btnPurchase
            com.blueair.devicedetails.dialog.DeviceNFilterDialogFragment$$ExternalSyntheticLambda9 r4 = new com.blueair.devicedetails.dialog.DeviceNFilterDialogFragment$$ExternalSyntheticLambda9
            r4.<init>(r0, r7, r1, r9)
            r2.setOnClickListener(r4)
        L_0x04d2:
            com.blueair.core.model.HasSKU r1 = r0.device
            if (r1 != 0) goto L_0x0536
            com.blueair.devicedetails.databinding.DialogfragmentDeviceNFilterBinding r1 = r0.binding
            if (r1 != 0) goto L_0x04de
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r18)
            r1 = 0
        L_0x04de:
            androidx.constraintlayout.widget.Group r2 = r1.replaceGroup
            r4 = r20
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r4)
            android.view.View r2 = (android.view.View) r2
            r7 = 0
            r8 = 0
            r11 = 1
            io.flatcircle.viewhelper.ViewExtensionsKt.show$default(r2, r7, r11, r8)
            android.widget.TextView r2 = r1.availableFilters
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            android.view.View r2 = (android.view.View) r2
            io.flatcircle.viewhelper.ViewExtensionsKt.hide(r2)
            androidx.recyclerview.widget.RecyclerView r2 = r1.filterList
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r15)
            android.view.View r2 = (android.view.View) r2
            io.flatcircle.viewhelper.ViewExtensionsKt.hide(r2)
            com.google.android.material.button.MaterialButton r2 = r1.btnAntiFake
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r6)
            android.view.View r2 = (android.view.View) r2
            io.flatcircle.viewhelper.ViewExtensionsKt.hide(r2)
            android.widget.TextView r2 = r1.buyNewFilter
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r5)
            android.view.View r2 = (android.view.View) r2
            io.flatcircle.viewhelper.ViewExtensionsKt.hide(r2)
            com.google.android.material.button.MaterialButton r2 = r1.btnSubscribe
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r13)
            android.view.View r2 = (android.view.View) r2
            io.flatcircle.viewhelper.ViewExtensionsKt.hide(r2)
            com.google.android.material.button.MaterialButton r2 = r1.btnPurchase
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r14)
            android.view.View r2 = (android.view.View) r2
            io.flatcircle.viewhelper.ViewExtensionsKt.hide(r2)
            android.widget.TextView r1 = r1.discountHint
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r12)
            android.view.View r1 = (android.view.View) r1
            io.flatcircle.viewhelper.ViewExtensionsKt.hide(r1)
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            goto L_0x0579
        L_0x0536:
            r4 = r20
            r8 = 0
            boolean r1 = r0.onlyBuy
            if (r1 == 0) goto L_0x0579
            com.blueair.devicedetails.databinding.DialogfragmentDeviceNFilterBinding r1 = r0.binding
            if (r1 != 0) goto L_0x0545
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r18)
            r1 = r8
        L_0x0545:
            androidx.constraintlayout.widget.Group r2 = r1.replaceGroup
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r4)
            android.view.View r2 = (android.view.View) r2
            io.flatcircle.viewhelper.ViewExtensionsKt.hide(r2)
            android.widget.TextView r2 = r1.availableFilters
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            android.view.View r2 = (android.view.View) r2
            io.flatcircle.viewhelper.ViewExtensionsKt.hide(r2)
            androidx.recyclerview.widget.RecyclerView r2 = r1.filterList
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r15)
            android.view.View r2 = (android.view.View) r2
            io.flatcircle.viewhelper.ViewExtensionsKt.hide(r2)
            com.google.android.material.button.MaterialButton r2 = r1.btnAntiFake
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r6)
            android.view.View r2 = (android.view.View) r2
            io.flatcircle.viewhelper.ViewExtensionsKt.hide(r2)
            android.widget.TextView r1 = r1.buyNewFilter
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r5)
            android.view.View r1 = (android.view.View) r1
            io.flatcircle.viewhelper.ViewExtensionsKt.hide(r1)
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
        L_0x0579:
            com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel r1 = r0.getViewModel()
            androidx.lifecycle.LiveData r1 = r1.getResetFilterLifeResult()
            androidx.lifecycle.LifecycleOwner r2 = r0.getViewLifecycleOwner()
            com.blueair.devicedetails.dialog.DeviceNFilterDialogFragment$$ExternalSyntheticLambda10 r3 = new com.blueair.devicedetails.dialog.DeviceNFilterDialogFragment$$ExternalSyntheticLambda10
            r3.<init>(r0)
            com.blueair.devicedetails.dialog.DeviceNFilterDialogFragment$sam$androidx_lifecycle_Observer$0 r4 = new com.blueair.devicedetails.dialog.DeviceNFilterDialogFragment$sam$androidx_lifecycle_Observer$0
            r4.<init>(r3)
            androidx.lifecycle.Observer r4 = (androidx.lifecycle.Observer) r4
            r1.observe(r2, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.dialog.DeviceNFilterDialogFragment.onViewCreated(android.view.View, android.os.Bundle):void");
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$2(DeviceNFilterDialogFragment deviceNFilterDialogFragment, View view) {
        deviceNFilterDialogFragment.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$11$lambda$6(DeviceNFilterDialogFragment deviceNFilterDialogFragment, View view) {
        Actions actions = Actions.INSTANCE;
        Context requireContext = deviceNFilterDialogFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        deviceNFilterDialogFragment.startActivity(actions.openAntiFakeScanIntent(requireContext, deviceNFilterDialogFragment.device, deviceNFilterDialogFragment.type));
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$11$lambda$10(DeviceNFilterDialogFragment deviceNFilterDialogFragment, int i, int i2, View view) {
        DeviceNFilterDialogFragment deviceNFilterDialogFragment2 = deviceNFilterDialogFragment;
        HasSKU hasSKU = deviceNFilterDialogFragment2.device;
        if ((hasSKU != null ? hasSKU.getConnectivityStatus() : null) == ConnectivityStatus.ONLINE) {
            FragmentManager childFragmentManager = deviceNFilterDialogFragment2.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
            Class<ConfirmationDialogLeftAligned> cls = ConfirmationDialogLeftAligned.class;
            Intrinsics.checkNotNullExpressionValue("ConfirmationDialogLeftAligned", "getSimpleName(...)");
            if (!(childFragmentManager.findFragmentByTag("ConfirmationDialogLeftAligned") instanceof ConfirmationDialogLeftAligned) && !childFragmentManager.isStateSaved()) {
                ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, i, (Integer) null, i2, Integer.valueOf(R.string.confirm), Integer.valueOf(R.string.btn_cancel), false, false, false, true, (String[]) null, (String) null, new DeviceNFilterDialogFragment$$ExternalSyntheticLambda2(deviceNFilterDialogFragment2), 1632, (Object) null).show(childFragmentManager, "ConfirmationDialogLeftAligned");
                return;
            }
            return;
        }
        deviceNFilterDialogFragment2.showDeviceOfflinePrompt();
    }

    /* access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$11$lambda$10$lambda$9$lambda$8(DeviceNFilterDialogFragment deviceNFilterDialogFragment, boolean z) {
        HasSKU hasSKU;
        if (z && (hasSKU = deviceNFilterDialogFragment.device) != null) {
            deviceNFilterDialogFragment.showProgress(true);
            deviceNFilterDialogFragment.getViewModel().resetFilterLife(hasSKU, deviceNFilterDialogFragment.type);
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$12(DeviceNFilterDialogFragment deviceNFilterDialogFragment, String str, View view) {
        FilterVideoActivity.Companion companion = FilterVideoActivity.Companion;
        Context requireContext = deviceNFilterDialogFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        companion.launch(requireContext, str);
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$15(DeviceNFilterDialogFragment deviceNFilterDialogFragment, List list, String str, View view) {
        HasSKU hasSKU = deviceNFilterDialogFragment.device;
        if (hasSKU != null) {
            DeviceDetailsViewModel viewModel2 = deviceNFilterDialogFragment.getViewModel();
            Device device2 = hasSKU;
            DeviceFilterType deviceFilterType = deviceNFilterDialogFragment.type;
            String value$default = I18nConfig.getValue$default(((FilterInfo) CollectionsKt.first(list)).getName(), (Locale) null, 1, (Object) null);
            if (value$default == null) {
                value$default = "";
            }
            viewModel2.analyticsLogFilterClickEvent(device2, false, false, deviceFilterType, value$default, deviceNFilterDialogFragment.fromNotification);
        }
        String ipConfigValue = DeviceConfigProvider.INSTANCE.getIpConfigValue(((FilterInfo) CollectionsKt.first(list)).getLinkSubscribe());
        if (ipConfigValue != null) {
            DeviceDetailsViewModel viewModel3 = deviceNFilterDialogFragment.getViewModel();
            Context requireContext = deviceNFilterDialogFragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
            viewModel3.openFilterUrl(requireContext, ipConfigValue, str);
        }
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$18(DeviceNFilterDialogFragment deviceNFilterDialogFragment, List list, String str, View view) {
        HasSKU hasSKU = deviceNFilterDialogFragment.device;
        if (hasSKU != null) {
            DeviceDetailsViewModel viewModel2 = deviceNFilterDialogFragment.getViewModel();
            Device device2 = hasSKU;
            DeviceFilterType deviceFilterType = deviceNFilterDialogFragment.type;
            String value$default = I18nConfig.getValue$default(((FilterInfo) CollectionsKt.first(list)).getName(), (Locale) null, 1, (Object) null);
            if (value$default == null) {
                value$default = "";
            }
            viewModel2.analyticsLogFilterClickEvent(device2, true, false, deviceFilterType, value$default, deviceNFilterDialogFragment.fromNotification);
        }
        String ipConfigValue = DeviceConfigProvider.INSTANCE.getIpConfigValue(((FilterInfo) CollectionsKt.first(list)).getLinkPurchase());
        if (ipConfigValue != null) {
            DeviceDetailsViewModel viewModel3 = deviceNFilterDialogFragment.getViewModel();
            Context requireContext = deviceNFilterDialogFragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
            viewModel3.openFilterUrl(requireContext, ipConfigValue, str);
        }
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$24(DeviceNFilterDialogFragment deviceNFilterDialogFragment, String str, List list, String str2, View view) {
        FragmentManager childFragmentManager = deviceNFilterDialogFragment.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        Class<SelectDeviceFilterDialogFragment> cls = SelectDeviceFilterDialogFragment.class;
        Intrinsics.checkNotNullExpressionValue("SelectDeviceFilterDialogFragment", "getSimpleName(...)");
        if (!(childFragmentManager.findFragmentByTag("SelectDeviceFilterDialogFragment") instanceof SelectDeviceFilterDialogFragment) && !childFragmentManager.isStateSaved()) {
            HasSKU hasSKU = deviceNFilterDialogFragment.device;
            if (hasSKU != null) {
                deviceNFilterDialogFragment.getViewModel().analyticsLogFilterClickEvent(hasSKU, false, false, deviceNFilterDialogFragment.type, "", deviceNFilterDialogFragment.fromNotification);
            }
            SelectDeviceFilterDialogFragment.Companion.newInstance(str, list, new DeviceNFilterDialogFragment$$ExternalSyntheticLambda11(deviceNFilterDialogFragment, list, str2)).show(childFragmentManager, "SelectDeviceFilterDialogFragment");
        }
    }

    /* access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$24$lambda$23$lambda$22(DeviceNFilterDialogFragment deviceNFilterDialogFragment, List list, String str, FilterInfo filterInfo) {
        Intrinsics.checkNotNullParameter(filterInfo, NotificationService.ACTION_TYPE_FILTER);
        HasSKU hasSKU = deviceNFilterDialogFragment.device;
        if (hasSKU != null) {
            DeviceDetailsViewModel viewModel2 = deviceNFilterDialogFragment.getViewModel();
            Device device2 = hasSKU;
            DeviceFilterType deviceFilterType = deviceNFilterDialogFragment.type;
            String value$default = I18nConfig.getValue$default(filterInfo.getName(), (Locale) null, 1, (Object) null);
            if (value$default == null) {
                value$default = "";
            }
            viewModel2.analyticsLogFilterClickEvent(device2, false, true, deviceFilterType, value$default, deviceNFilterDialogFragment.fromNotification);
        }
        String ipConfigValue = DeviceConfigProvider.INSTANCE.getIpConfigValue(((FilterInfo) CollectionsKt.first(list)).getLinkSubscribe());
        if (ipConfigValue != null) {
            DeviceDetailsViewModel viewModel3 = deviceNFilterDialogFragment.getViewModel();
            Context requireContext = deviceNFilterDialogFragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
            viewModel3.openFilterUrl(requireContext, ipConfigValue, str);
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$30(DeviceNFilterDialogFragment deviceNFilterDialogFragment, String str, List list, String str2, View view) {
        FragmentManager childFragmentManager = deviceNFilterDialogFragment.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        Class<SelectDeviceFilterDialogFragment> cls = SelectDeviceFilterDialogFragment.class;
        Intrinsics.checkNotNullExpressionValue("SelectDeviceFilterDialogFragment", "getSimpleName(...)");
        if (!(childFragmentManager.findFragmentByTag("SelectDeviceFilterDialogFragment") instanceof SelectDeviceFilterDialogFragment) && !childFragmentManager.isStateSaved()) {
            HasSKU hasSKU = deviceNFilterDialogFragment.device;
            if (hasSKU != null) {
                deviceNFilterDialogFragment.getViewModel().analyticsLogFilterClickEvent(hasSKU, true, false, deviceNFilterDialogFragment.type, "", deviceNFilterDialogFragment.fromNotification);
            }
            SelectDeviceFilterDialogFragment.Companion.newInstance(str, list, new DeviceNFilterDialogFragment$$ExternalSyntheticLambda1(deviceNFilterDialogFragment, list, str2)).show(childFragmentManager, "SelectDeviceFilterDialogFragment");
        }
    }

    /* access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$30$lambda$29$lambda$28(DeviceNFilterDialogFragment deviceNFilterDialogFragment, List list, String str, FilterInfo filterInfo) {
        Intrinsics.checkNotNullParameter(filterInfo, NotificationService.ACTION_TYPE_FILTER);
        HasSKU hasSKU = deviceNFilterDialogFragment.device;
        if (hasSKU != null) {
            DeviceDetailsViewModel viewModel2 = deviceNFilterDialogFragment.getViewModel();
            Device device2 = hasSKU;
            DeviceFilterType deviceFilterType = deviceNFilterDialogFragment.type;
            String value$default = I18nConfig.getValue$default(filterInfo.getName(), (Locale) null, 1, (Object) null);
            if (value$default == null) {
                value$default = "";
            }
            viewModel2.analyticsLogFilterClickEvent(device2, true, true, deviceFilterType, value$default, deviceNFilterDialogFragment.fromNotification);
        }
        String ipConfigValue = DeviceConfigProvider.INSTANCE.getIpConfigValue(((FilterInfo) CollectionsKt.first(list)).getLinkPurchase());
        if (ipConfigValue != null) {
            DeviceDetailsViewModel viewModel3 = deviceNFilterDialogFragment.getViewModel();
            Context requireContext = deviceNFilterDialogFragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
            viewModel3.openFilterUrl(requireContext, ipConfigValue, str);
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$34(DeviceNFilterDialogFragment deviceNFilterDialogFragment, FilterLifeResetResult filterLifeResetResult) {
        String str;
        DeviceNFilterDialogFragment deviceNFilterDialogFragment2 = deviceNFilterDialogFragment;
        if (filterLifeResetResult != null) {
            deviceNFilterDialogFragment2.showProgress(false);
            int i = WhenMappings.$EnumSwitchMapping$1[filterLifeResetResult.ordinal()];
            if (i == 1) {
                DeviceDetailsDialogFragment.Companion companion = DeviceDetailsDialogFragment.Companion;
                int i2 = WhenMappings.$EnumSwitchMapping$0[deviceNFilterDialogFragment2.type.ordinal()];
                if (i2 == 1) {
                    str = NotificationService.ACTION_TYPE_FILTER_STATUS;
                } else if (i2 == 2) {
                    str = NotificationService.ACTION_TYPE_WICK_STATUS;
                } else if (i2 == 3) {
                    str = NotificationService.ACTION_TYPE_REFRESHER_STATUS;
                } else {
                    throw new NoWhenBranchMatchedException();
                }
                companion.setJumpToAction(str);
                ToastUtils toastUtils = ToastUtils.INSTANCE;
                Context requireContext = deviceNFilterDialogFragment2.requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
                toastUtils.showCenterToast(requireContext, R.string.reset_successful, 1);
                FragmentKt.setFragmentResult(deviceNFilterDialogFragment2, "REQUEST_KEY_HANDLE_ACTION", BundleKt.bundleOf());
                deviceNFilterDialogFragment2.dismiss();
            } else if (i == 2) {
                FragmentManager childFragmentManager = deviceNFilterDialogFragment2.getChildFragmentManager();
                Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
                if (!(childFragmentManager.findFragmentByTag(AccountLinkingActivity.STATE_FAILED) instanceof ConfirmationDialogLeftAligned) && !childFragmentManager.isStateSaved()) {
                    ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, R.string.reset_failed, (Integer) null, R.string.troubleshotting_reset_filter_internal_error, Integer.valueOf(R.string.snackbar_ok), (Integer) null, false, false, false, true, (String[]) null, (String) null, (Function1) null, 3808, (Object) null).show(childFragmentManager, AccountLinkingActivity.STATE_FAILED);
                }
            } else if (i == 3) {
                deviceNFilterDialogFragment2.showDeviceOfflinePrompt();
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
        return Unit.INSTANCE;
    }

    private final void showDeviceOfflinePrompt() {
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        if (!(childFragmentManager.findFragmentByTag("DEVICE_OFFLINE") instanceof ConfirmationDialogLeftAligned) && !childFragmentManager.isStateSaved()) {
            ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, R.string.prompt, (Integer) null, R.string.device_offline_retry_prompt, Integer.valueOf(R.string.snackbar_ok), (Integer) null, false, false, false, true, (String[]) null, (String) null, (Function1) null, 3808, (Object) null).show(childFragmentManager, "DEVICE_OFFLINE");
        }
    }

    /* access modifiers changed from: private */
    public final void refreshFilterScrollIndicators() {
        DialogfragmentDeviceNFilterBinding dialogfragmentDeviceNFilterBinding = this.binding;
        DialogfragmentDeviceNFilterBinding dialogfragmentDeviceNFilterBinding2 = null;
        if (dialogfragmentDeviceNFilterBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogfragmentDeviceNFilterBinding = null;
        }
        ImageView imageView = dialogfragmentDeviceNFilterBinding.filterScrollLeft;
        DialogfragmentDeviceNFilterBinding dialogfragmentDeviceNFilterBinding3 = this.binding;
        if (dialogfragmentDeviceNFilterBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogfragmentDeviceNFilterBinding3 = null;
        }
        int i = 0;
        imageView.setVisibility(dialogfragmentDeviceNFilterBinding3.filterList.canScrollHorizontally(-1) ? 0 : 4);
        DialogfragmentDeviceNFilterBinding dialogfragmentDeviceNFilterBinding4 = this.binding;
        if (dialogfragmentDeviceNFilterBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogfragmentDeviceNFilterBinding4 = null;
        }
        ImageView imageView2 = dialogfragmentDeviceNFilterBinding4.filterScrollRight;
        DialogfragmentDeviceNFilterBinding dialogfragmentDeviceNFilterBinding5 = this.binding;
        if (dialogfragmentDeviceNFilterBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            dialogfragmentDeviceNFilterBinding2 = dialogfragmentDeviceNFilterBinding5;
        }
        if (!dialogfragmentDeviceNFilterBinding2.filterList.canScrollHorizontally(1)) {
            i = 4;
        }
        imageView2.setVisibility(i);
    }

    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setLayout(-1, -2);
        }
    }

    public void showProgress(boolean z) {
        DialogfragmentDeviceNFilterBinding dialogfragmentDeviceNFilterBinding = this.binding;
        if (dialogfragmentDeviceNFilterBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogfragmentDeviceNFilterBinding = null;
        }
        ProgressBlockerView progressBlockerView = dialogfragmentDeviceNFilterBinding.progressView;
        Intrinsics.checkNotNullExpressionValue(progressBlockerView, "progressView");
        ViewExtensionsKt.show(progressBlockerView, z);
    }

    public void onResume() {
        super.onResume();
        if (shouldDismiss) {
            shouldDismiss = false;
            dismiss();
            return;
        }
        refreshFilterScrollIndicators();
    }

    public void onPause() {
        Window window;
        WindowManager.LayoutParams attributes;
        Dialog dialog = getDialog();
        if (!(dialog == null || (window = dialog.getWindow()) == null || (attributes = window.getAttributes()) == null)) {
            attributes.windowAnimations = R.style.dialog_animation_exit_only;
        }
        super.onPause();
    }
}
