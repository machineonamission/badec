package com.blueair.devicedetails.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.os.BundleKt;
import androidx.core.util.TypedValueCompat;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.AnalyticEvent;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceFilterType;
import com.blueair.core.model.FilterInfo;
import com.blueair.core.model.HasSKU;
import com.blueair.core.model.I18nConfig;
import com.blueair.devicedetails.databinding.DialogfragmentBuyFilterV2Binding;
import com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel;
import com.blueair.push.NotificationService;
import com.blueair.viewcore.R;
import com.blueair.viewcore.activity.Actions;
import com.blueair.viewcore.adapter.FilterTypeAdapter;
import com.blueair.viewcore.dialog.BaseDialogFragment;
import com.blueair.viewcore.dialog.ConfirmationDialogLeftAligned;
import com.blueair.viewcore.utils.DeviceConfigProvider;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import com.google.android.material.button.MaterialButton;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Regex;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 52\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00015B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J$\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u001a\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u001d2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u0010\u0010'\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u0006H\u0002J\u0010\u0010)\u001a\u00020%2\u0006\u0010*\u001a\u00020+H\u0002J\u0012\u0010,\u001a\u00020%2\b\u0010*\u001a\u0004\u0018\u00010+H\u0002J\u0012\u0010-\u001a\u00020%2\b\u0010*\u001a\u0004\u0018\u00010+H\u0002J\u0010\u0010.\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u0019H\u0002J\b\u00100\u001a\u00020%H\u0016J\u0010\u00101\u001a\u00020%2\u0006\u00102\u001a\u00020\u001bH\u0016J\b\u00103\u001a\u00020%H\u0016J\b\u00104\u001a\u00020%H\u0016R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0002X.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\u00068BX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\bR\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/blueair/devicedetails/dialog/BuyFilterV2DialogFragment;", "Lcom/blueair/viewcore/dialog/BaseDialogFragment;", "Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "viewModel", "getViewModel", "()Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;", "setViewModel", "(Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;)V", "binding", "Lcom/blueair/devicedetails/databinding/DialogfragmentBuyFilterV2Binding;", "filterAdapter", "Lcom/blueair/viewcore/adapter/FilterTypeAdapter;", "device", "Lcom/blueair/core/model/HasSKU;", "deviceSku", "preferFilterName", "sku", "getSku", "type", "Lcom/blueair/core/model/DeviceFilterType;", "fromNotification", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "replaceNewline", "source", "updateButtonVisibility", "filter", "Lcom/blueair/core/model/FilterInfo;", "subscribeFor", "purchase", "getOrderFilterTitle", "filterType", "onStart", "showProgress", "shouldShowProgress", "onResume", "onPause", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: BuyFilterV2DialogFragment.kt */
public final class BuyFilterV2DialogFragment extends BaseDialogFragment<DeviceDetailsViewModel> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String EXTRA_FILTER_NAME = "EXTRA_FILTER_NAME";
    private static final String EXTRA_FROM_NOTIFICATION = "extra_from_notification";
    private static final String EXTRA_TYPE = "EXTRA_TYPE";
    /* access modifiers changed from: private */
    public static boolean shouldDismiss;
    private DialogfragmentBuyFilterV2Binding binding;
    private HasSKU device;
    private String deviceSku;
    private FilterTypeAdapter filterAdapter;
    private boolean fromNotification;
    private String preferFilterName;
    private final String screenName = AnalyticEvent.ScreenViewEvent.DEVICE_FILTER_BUY;
    private DeviceFilterType type = DeviceFilterType.FILTER;
    public DeviceDetailsViewModel viewModel;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: BuyFilterV2DialogFragment.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                com.blueair.core.model.DeviceFilterType[] r0 = com.blueair.core.model.DeviceFilterType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.blueair.core.model.DeviceFilterType r1 = com.blueair.core.model.DeviceFilterType.FILTER     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.blueair.core.model.DeviceFilterType r1 = com.blueair.core.model.DeviceFilterType.WICK     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.blueair.core.model.DeviceFilterType r1 = com.blueair.core.model.DeviceFilterType.REFRESHER     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.dialog.BuyFilterV2DialogFragment.WhenMappings.<clinit>():void");
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J8\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\t2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0005R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/blueair/devicedetails/dialog/BuyFilterV2DialogFragment$Companion;", "", "<init>", "()V", "EXTRA_TYPE", "", "EXTRA_FILTER_NAME", "EXTRA_FROM_NOTIFICATION", "shouldDismiss", "", "getShouldDismiss", "()Z", "setShouldDismiss", "(Z)V", "newInstance", "Lcom/blueair/devicedetails/dialog/BuyFilterV2DialogFragment;", "device", "Lcom/blueair/core/model/Device;", "deviceSku", "type", "Lcom/blueair/core/model/DeviceFilterType;", "fromNotification", "preferFilterName", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: BuyFilterV2DialogFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean getShouldDismiss() {
            return BuyFilterV2DialogFragment.shouldDismiss;
        }

        public final void setShouldDismiss(boolean z) {
            BuyFilterV2DialogFragment.shouldDismiss = z;
        }

        public static /* synthetic */ BuyFilterV2DialogFragment newInstance$default(Companion companion, Device device, String str, DeviceFilterType deviceFilterType, boolean z, String str2, int i, Object obj) {
            if ((i & 8) != 0) {
                z = false;
            }
            boolean z2 = z;
            if ((i & 16) != 0) {
                str2 = null;
            }
            return companion.newInstance(device, str, deviceFilterType, z2, str2);
        }

        public final BuyFilterV2DialogFragment newInstance(Device device, String str, DeviceFilterType deviceFilterType, boolean z, String str2) {
            Intrinsics.checkNotNullParameter(deviceFilterType, "type");
            BuyFilterV2DialogFragment buyFilterV2DialogFragment = new BuyFilterV2DialogFragment();
            buyFilterV2DialogFragment.setArguments(BundleKt.bundleOf(TuplesKt.to("device", device), TuplesKt.to(Actions.EXTRA_DEVICE_SKU, str), TuplesKt.to(BuyFilterV2DialogFragment.EXTRA_TYPE, deviceFilterType.name()), TuplesKt.to(BuyFilterV2DialogFragment.EXTRA_FROM_NOTIFICATION, Boolean.valueOf(z)), TuplesKt.to(BuyFilterV2DialogFragment.EXTRA_FILTER_NAME, str2)));
            return buyFilterV2DialogFragment;
        }
    }

    /* access modifiers changed from: protected */
    public String getScreenName() {
        return this.screenName;
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
        this.device = (HasSKU) requireArguments.getParcelable("device");
        this.deviceSku = requireArguments.getString(Actions.EXTRA_DEVICE_SKU);
        this.preferFilterName = requireArguments.getString(EXTRA_FILTER_NAME);
        String string = requireArguments.getString(EXTRA_TYPE, "FILTER");
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        this.type = DeviceFilterType.valueOf(string);
        this.fromNotification = requireArguments.getBoolean(EXTRA_FROM_NOTIFICATION, false);
        DialogfragmentBuyFilterV2Binding inflate = DialogfragmentBuyFilterV2Binding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        setViewModel((DeviceDetailsViewModel) ((BaseViewModel) new ViewModelProvider((ViewModelStoreOwner) this).get(DeviceDetailsViewModel.class)));
        DialogfragmentBuyFilterV2Binding dialogfragmentBuyFilterV2Binding = this.binding;
        if (dialogfragmentBuyFilterV2Binding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogfragmentBuyFilterV2Binding = null;
        }
        View root = dialogfragmentBuyFilterV2Binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: com.blueair.viewcore.adapter.FilterTypeAdapter} */
    /* JADX WARNING: type inference failed for: r0v1 */
    /* JADX WARNING: type inference failed for: r0v4 */
    /* JADX WARNING: type inference failed for: r0v5, types: [com.blueair.devicedetails.databinding.DialogfragmentBuyFilterV2Binding] */
    /* JADX WARNING: type inference failed for: r0v6 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onViewCreated(android.view.View r11, android.os.Bundle r12) {
        /*
            r10 = this;
            java.lang.String r0 = "view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            super.onViewCreated(r11, r12)
            com.blueair.devicedetails.databinding.DialogfragmentBuyFilterV2Binding r11 = r10.binding
            java.lang.String r12 = "binding"
            r0 = 0
            if (r11 != 0) goto L_0x0013
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r12)
            r11 = r0
        L_0x0013:
            androidx.appcompat.widget.AppCompatImageButton r11 = r11.closeBtn
            com.blueair.devicedetails.dialog.BuyFilterV2DialogFragment$$ExternalSyntheticLambda0 r1 = new com.blueair.devicedetails.dialog.BuyFilterV2DialogFragment$$ExternalSyntheticLambda0
            r1.<init>(r10)
            r11.setOnClickListener(r1)
            com.blueair.core.model.DeviceFilterType r11 = r10.type
            int[] r1 = com.blueair.devicedetails.dialog.BuyFilterV2DialogFragment.WhenMappings.$EnumSwitchMapping$0
            int r11 = r11.ordinal()
            r11 = r1[r11]
            r1 = 1
            if (r11 == r1) goto L_0x0056
            r2 = 2
            if (r11 == r2) goto L_0x0046
            r2 = 3
            if (r11 != r2) goto L_0x0040
            com.blueair.devicedetails.databinding.DialogfragmentBuyFilterV2Binding r11 = r10.binding
            if (r11 != 0) goto L_0x0038
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r12)
            r11 = r0
        L_0x0038:
            androidx.appcompat.widget.AppCompatTextView r11 = r11.title
            int r2 = com.blueair.viewcore.R.string.select_refresher_type
            r11.setText(r2)
            goto L_0x0065
        L_0x0040:
            kotlin.NoWhenBranchMatchedException r11 = new kotlin.NoWhenBranchMatchedException
            r11.<init>()
            throw r11
        L_0x0046:
            com.blueair.devicedetails.databinding.DialogfragmentBuyFilterV2Binding r11 = r10.binding
            if (r11 != 0) goto L_0x004e
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r12)
            r11 = r0
        L_0x004e:
            androidx.appcompat.widget.AppCompatTextView r11 = r11.title
            int r2 = com.blueair.viewcore.R.string.select_wick_filter_type
            r11.setText(r2)
            goto L_0x0065
        L_0x0056:
            com.blueair.devicedetails.databinding.DialogfragmentBuyFilterV2Binding r11 = r10.binding
            if (r11 != 0) goto L_0x005e
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r12)
            r11 = r0
        L_0x005e:
            androidx.appcompat.widget.AppCompatTextView r11 = r11.title
            int r2 = com.blueair.viewcore.R.string.select_air_filter_type
            r11.setText(r2)
        L_0x0065:
            com.blueair.core.model.HasSKU r11 = r10.device
            r2 = 0
            if (r11 == 0) goto L_0x0074
            com.blueair.core.model.Device r11 = (com.blueair.core.model.Device) r11
            boolean r11 = com.blueair.core.model.DeviceKt.shouldMergeFilter(r11)
            if (r11 != r1) goto L_0x0074
            r11 = r1
            goto L_0x0075
        L_0x0074:
            r11 = r2
        L_0x0075:
            com.blueair.viewcore.utils.DeviceConfigProvider r3 = com.blueair.viewcore.utils.DeviceConfigProvider.INSTANCE
            java.lang.String r4 = r10.getSku()
            if (r11 == 0) goto L_0x007f
            r11 = r0
            goto L_0x0081
        L_0x007f:
            com.blueair.core.model.DeviceFilterType r11 = r10.type
        L_0x0081:
            com.blueair.core.model.FilterConfig r11 = r3.getFilterConfig((java.lang.String) r4, (com.blueair.core.model.DeviceFilterType) r11)
            if (r11 == 0) goto L_0x008e
            java.util.List r11 = r11.getFilters()
            if (r11 == 0) goto L_0x008e
            goto L_0x0092
        L_0x008e:
            java.util.List r11 = kotlin.collections.CollectionsKt.emptyList()
        L_0x0092:
            boolean r3 = r11.isEmpty()
            if (r3 == 0) goto L_0x00d2
            com.blueair.devicedetails.databinding.DialogfragmentBuyFilterV2Binding r11 = r10.binding
            if (r11 != 0) goto L_0x00a0
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r12)
            goto L_0x00a1
        L_0x00a0:
            r0 = r11
        L_0x00a1:
            androidx.recyclerview.widget.RecyclerView r11 = r0.filterList
            java.lang.String r12 = "filterList"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r12)
            android.view.View r11 = (android.view.View) r11
            io.flatcircle.viewhelper.ViewExtensionsKt.hide(r11)
            com.google.android.material.button.MaterialButton r11 = r0.btnPurchase
            java.lang.String r12 = "btnPurchase"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r12)
            android.view.View r11 = (android.view.View) r11
            io.flatcircle.viewhelper.ViewExtensionsKt.hide(r11)
            com.google.android.material.button.MaterialButton r11 = r0.btnSubscribe
            java.lang.String r12 = "btnSubscribe"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r12)
            android.view.View r11 = (android.view.View) r11
            io.flatcircle.viewhelper.ViewExtensionsKt.hide(r11)
            android.widget.TextView r11 = r0.discountHint
            java.lang.String r12 = "discountHint"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r12)
            android.view.View r11 = (android.view.View) r11
            io.flatcircle.viewhelper.ViewExtensionsKt.hide(r11)
            return
        L_0x00d2:
            com.blueair.viewcore.adapter.FilterTypeAdapter r3 = new com.blueair.viewcore.adapter.FilterTypeAdapter
            com.blueair.devicedetails.dialog.BuyFilterV2DialogFragment$$ExternalSyntheticLambda1 r4 = new com.blueair.devicedetails.dialog.BuyFilterV2DialogFragment$$ExternalSyntheticLambda1
            r4.<init>(r10)
            com.blueair.devicedetails.dialog.BuyFilterV2DialogFragment$$ExternalSyntheticLambda2 r5 = new com.blueair.devicedetails.dialog.BuyFilterV2DialogFragment$$ExternalSyntheticLambda2
            r5.<init>(r10)
            r3.<init>(r4, r5)
            r10.filterAdapter = r3
            com.blueair.devicedetails.databinding.DialogfragmentBuyFilterV2Binding r3 = r10.binding
            if (r3 != 0) goto L_0x00eb
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r12)
            r3 = r0
        L_0x00eb:
            androidx.recyclerview.widget.RecyclerView r3 = r3.filterList
            com.blueair.viewcore.adapter.FilterTypeAdapter r4 = r10.filterAdapter
            java.lang.String r5 = "filterAdapter"
            if (r4 != 0) goto L_0x00f7
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)
            r4 = r0
        L_0x00f7:
            androidx.recyclerview.widget.RecyclerView$Adapter r4 = (androidx.recyclerview.widget.RecyclerView.Adapter) r4
            r3.setAdapter(r4)
            com.blueair.viewcore.adapter.FilterTypeAdapter r3 = r10.filterAdapter
            if (r3 != 0) goto L_0x0104
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)
            r3 = r0
        L_0x0104:
            r3.setFilters(r11)
            com.blueair.devicedetails.databinding.DialogfragmentBuyFilterV2Binding r3 = r10.binding
            if (r3 != 0) goto L_0x010f
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r12)
            r3 = r0
        L_0x010f:
            com.google.android.material.button.MaterialButton r3 = r3.btnSubscribe
            com.blueair.devicedetails.dialog.BuyFilterV2DialogFragment$$ExternalSyntheticLambda3 r4 = new com.blueair.devicedetails.dialog.BuyFilterV2DialogFragment$$ExternalSyntheticLambda3
            r4.<init>(r10)
            r3.setOnClickListener(r4)
            com.blueair.devicedetails.databinding.DialogfragmentBuyFilterV2Binding r3 = r10.binding
            if (r3 != 0) goto L_0x0121
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r12)
            r3 = r0
        L_0x0121:
            com.google.android.material.button.MaterialButton r3 = r3.btnPurchase
            com.blueair.devicedetails.dialog.BuyFilterV2DialogFragment$$ExternalSyntheticLambda4 r4 = new com.blueair.devicedetails.dialog.BuyFilterV2DialogFragment$$ExternalSyntheticLambda4
            r4.<init>(r10)
            r3.setOnClickListener(r4)
            kotlin.jvm.internal.Ref$IntRef r3 = new kotlin.jvm.internal.Ref$IntRef
            r3.<init>()
            java.util.Iterator r4 = r11.iterator()
            r6 = r2
        L_0x0135:
            boolean r7 = r4.hasNext()
            r8 = -1
            if (r7 == 0) goto L_0x0156
            java.lang.Object r7 = r4.next()
            com.blueair.core.model.FilterInfo r7 = (com.blueair.core.model.FilterInfo) r7
            com.blueair.core.model.I18nConfig r7 = r7.getName()
            java.lang.String r7 = com.blueair.core.model.I18nConfig.getValue$default(r7, r0, r1, r0)
            java.lang.String r9 = r10.preferFilterName
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r9)
            if (r7 == 0) goto L_0x0153
            goto L_0x0157
        L_0x0153:
            int r6 = r6 + 1
            goto L_0x0135
        L_0x0156:
            r6 = r8
        L_0x0157:
            r3.element = r6
            com.blueair.devicedetails.databinding.DialogfragmentBuyFilterV2Binding r1 = r10.binding
            if (r1 != 0) goto L_0x0161
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r12)
            r1 = r0
        L_0x0161:
            androidx.recyclerview.widget.RecyclerView r12 = r1.filterList
            int r1 = r3.element
            if (r1 != r8) goto L_0x0169
            r3.element = r2
        L_0x0169:
            com.blueair.viewcore.adapter.FilterTypeAdapter r1 = r10.filterAdapter
            if (r1 != 0) goto L_0x0171
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)
            goto L_0x0172
        L_0x0171:
            r0 = r1
        L_0x0172:
            int r1 = r3.element
            kotlin.jvm.internal.Intrinsics.checkNotNull(r12)
            r0.selectFilter(r1, r12)
            int r0 = r3.element
            java.lang.Object r11 = r11.get(r0)
            com.blueair.core.model.FilterInfo r11 = (com.blueair.core.model.FilterInfo) r11
            r10.updateButtonVisibility(r11)
            int r11 = r3.element
            if (r11 <= 0) goto L_0x0191
            com.blueair.devicedetails.dialog.BuyFilterV2DialogFragment$$ExternalSyntheticLambda5 r11 = new com.blueair.devicedetails.dialog.BuyFilterV2DialogFragment$$ExternalSyntheticLambda5
            r11.<init>(r12, r3)
            r12.post(r11)
        L_0x0191:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.dialog.BuyFilterV2DialogFragment.onViewCreated(android.view.View, android.os.Bundle):void");
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$2(BuyFilterV2DialogFragment buyFilterV2DialogFragment, View view) {
        buyFilterV2DialogFragment.dismiss();
    }

    /* access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$5(BuyFilterV2DialogFragment buyFilterV2DialogFragment, FilterInfo filterInfo) {
        FilterInfo filterInfo2 = filterInfo;
        Intrinsics.checkNotNullParameter(filterInfo2, NotificationService.ACTION_TYPE_FILTER);
        FragmentManager childFragmentManager = buyFilterV2DialogFragment.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        Class<ConfirmationDialogLeftAligned> cls = ConfirmationDialogLeftAligned.class;
        Intrinsics.checkNotNullExpressionValue("ConfirmationDialogLeftAligned", "getSimpleName(...)");
        if (!(childFragmentManager.findFragmentByTag("ConfirmationDialogLeftAligned") instanceof ConfirmationDialogLeftAligned) && !childFragmentManager.isStateSaved()) {
            ConfirmationDialogLeftAligned.Companion companion = ConfirmationDialogLeftAligned.Companion;
            int summary = filterInfo2.getSummary();
            Integer valueOf = Integer.valueOf(R.string.confirmation_positive_default);
            String value$default = I18nConfig.getValue$default(filterInfo2.getName(), (Locale) null, 1, (Object) null);
            if (value$default == null) {
                value$default = "";
            }
            ConfirmationDialogLeftAligned.Companion.newInstance$default(companion, 0, (Integer) null, summary, valueOf, (Integer) null, false, false, false, false, (String[]) null, buyFilterV2DialogFragment.replaceNewline(value$default), (Function1) null, 2912, (Object) null).show(childFragmentManager, "ConfirmationDialogLeftAligned");
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$6(BuyFilterV2DialogFragment buyFilterV2DialogFragment, int i, FilterInfo filterInfo) {
        Intrinsics.checkNotNullParameter(filterInfo, NotificationService.ACTION_TYPE_FILTER);
        FilterTypeAdapter filterTypeAdapter = buyFilterV2DialogFragment.filterAdapter;
        DialogfragmentBuyFilterV2Binding dialogfragmentBuyFilterV2Binding = null;
        if (filterTypeAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filterAdapter");
            filterTypeAdapter = null;
        }
        DialogfragmentBuyFilterV2Binding dialogfragmentBuyFilterV2Binding2 = buyFilterV2DialogFragment.binding;
        if (dialogfragmentBuyFilterV2Binding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            dialogfragmentBuyFilterV2Binding = dialogfragmentBuyFilterV2Binding2;
        }
        RecyclerView recyclerView = dialogfragmentBuyFilterV2Binding.filterList;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "filterList");
        filterTypeAdapter.selectFilter(i, recyclerView);
        buyFilterV2DialogFragment.updateButtonVisibility(filterInfo);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$7(BuyFilterV2DialogFragment buyFilterV2DialogFragment, View view) {
        FilterTypeAdapter filterTypeAdapter = buyFilterV2DialogFragment.filterAdapter;
        if (filterTypeAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filterAdapter");
            filterTypeAdapter = null;
        }
        buyFilterV2DialogFragment.subscribeFor(filterTypeAdapter.getSelectedFilter());
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$8(BuyFilterV2DialogFragment buyFilterV2DialogFragment, View view) {
        FilterTypeAdapter filterTypeAdapter = buyFilterV2DialogFragment.filterAdapter;
        if (filterTypeAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filterAdapter");
            filterTypeAdapter = null;
        }
        buyFilterV2DialogFragment.purchase(filterTypeAdapter.getSelectedFilter());
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$11$lambda$10(RecyclerView recyclerView, Ref.IntRef intRef) {
        recyclerView.smoothScrollToPosition(intRef.element);
    }

    private final String replaceNewline(String str) {
        return new Regex("\\s*\\R\\s*").replace((CharSequence) str, " ");
    }

    private final void updateButtonVisibility(FilterInfo filterInfo) {
        CharSequence ipConfigValue = DeviceConfigProvider.INSTANCE.getIpConfigValue(filterInfo.getLinkSubscribe());
        boolean z = true;
        boolean z2 = ipConfigValue == null || ipConfigValue.length() == 0;
        CharSequence ipConfigValue2 = DeviceConfigProvider.INSTANCE.getIpConfigValue(filterInfo.getLinkPurchase());
        if (!(ipConfigValue2 == null || ipConfigValue2.length() == 0)) {
            z = false;
        }
        DialogfragmentBuyFilterV2Binding dialogfragmentBuyFilterV2Binding = this.binding;
        DialogfragmentBuyFilterV2Binding dialogfragmentBuyFilterV2Binding2 = null;
        if (dialogfragmentBuyFilterV2Binding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogfragmentBuyFilterV2Binding = null;
        }
        MaterialButton materialButton = dialogfragmentBuyFilterV2Binding.btnSubscribe;
        Intrinsics.checkNotNullExpressionValue(materialButton, "btnSubscribe");
        int i = 8;
        materialButton.setVisibility(!z2 ? 0 : 8);
        DialogfragmentBuyFilterV2Binding dialogfragmentBuyFilterV2Binding3 = this.binding;
        if (dialogfragmentBuyFilterV2Binding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogfragmentBuyFilterV2Binding3 = null;
        }
        TextView textView = dialogfragmentBuyFilterV2Binding3.discountHint;
        Intrinsics.checkNotNullExpressionValue(textView, "discountHint");
        textView.setVisibility(!z2 ? 0 : 8);
        DialogfragmentBuyFilterV2Binding dialogfragmentBuyFilterV2Binding4 = this.binding;
        if (dialogfragmentBuyFilterV2Binding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogfragmentBuyFilterV2Binding4 = null;
        }
        MaterialButton materialButton2 = dialogfragmentBuyFilterV2Binding4.btnPurchase;
        Intrinsics.checkNotNullExpressionValue(materialButton2, "btnPurchase");
        View view = materialButton2;
        if (!z) {
            i = 0;
        }
        view.setVisibility(i);
        if (!z) {
            DialogfragmentBuyFilterV2Binding dialogfragmentBuyFilterV2Binding5 = this.binding;
            if (dialogfragmentBuyFilterV2Binding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                dialogfragmentBuyFilterV2Binding2 = dialogfragmentBuyFilterV2Binding5;
            }
            MaterialButton materialButton3 = dialogfragmentBuyFilterV2Binding2.btnPurchase;
            if (!z2) {
                materialButton3.setStrokeColor(AppCompatResources.getColorStateList(materialButton3.getContext(), R.color.timberwolf));
                materialButton3.setRippleColor(AppCompatResources.getColorStateList(materialButton3.getContext(), R.color.lightbluegrey));
                materialButton3.setBackgroundTintList(AppCompatResources.getColorStateList(materialButton3.getContext(), R.color.button_secondary));
                materialButton3.setTextColor(AppCompatResources.getColorStateList(materialButton3.getContext(), R.color.button_secondary_text));
                return;
            }
            materialButton3.setStrokeColor(ColorStateList.valueOf(0));
            materialButton3.setRippleColor(AppCompatResources.getColorStateList(materialButton3.getContext(), com.google.android.material.R.color.mtrl_btn_ripple_color));
            materialButton3.setBackgroundTintList(AppCompatResources.getColorStateList(materialButton3.getContext(), R.color.button_primary));
            materialButton3.setTextColor(AppCompatResources.getColorStateList(materialButton3.getContext(), R.color.white));
        }
    }

    private final void subscribeFor(FilterInfo filterInfo) {
        if (filterInfo != null) {
            HasSKU hasSKU = this.device;
            if (hasSKU != null) {
                DeviceDetailsViewModel viewModel2 = getViewModel();
                Device device2 = hasSKU;
                DeviceFilterType type2 = filterInfo.getType();
                String value$default = I18nConfig.getValue$default(filterInfo.getName(), (Locale) null, 1, (Object) null);
                if (value$default == null) {
                    value$default = "";
                }
                viewModel2.analyticsLogFilterClickEvent(device2, false, false, type2, value$default, this.fromNotification);
            }
            String ipConfigValue = DeviceConfigProvider.INSTANCE.getIpConfigValue(filterInfo.getLinkSubscribe());
            if (ipConfigValue != null) {
                DeviceConfigProvider deviceConfigProvider = DeviceConfigProvider.INSTANCE;
                Context requireContext = requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
                deviceConfigProvider.openFilterUrl(requireContext, ipConfigValue, getOrderFilterTitle(filterInfo.getType()));
            }
        }
    }

    private final void purchase(FilterInfo filterInfo) {
        if (filterInfo != null) {
            HasSKU hasSKU = this.device;
            if (hasSKU != null) {
                DeviceDetailsViewModel viewModel2 = getViewModel();
                Device device2 = hasSKU;
                DeviceFilterType type2 = filterInfo.getType();
                String value$default = I18nConfig.getValue$default(filterInfo.getName(), (Locale) null, 1, (Object) null);
                if (value$default == null) {
                    value$default = "";
                }
                viewModel2.analyticsLogFilterClickEvent(device2, true, false, type2, value$default, this.fromNotification);
            }
            String ipConfigValue = DeviceConfigProvider.INSTANCE.getIpConfigValue(filterInfo.getLinkPurchase());
            if (ipConfigValue != null) {
                DeviceConfigProvider deviceConfigProvider = DeviceConfigProvider.INSTANCE;
                Context requireContext = requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
                deviceConfigProvider.openFilterUrl(requireContext, ipConfigValue, getOrderFilterTitle(filterInfo.getType()));
            }
        }
    }

    private final String getOrderFilterTitle(DeviceFilterType deviceFilterType) {
        int i = WhenMappings.$EnumSwitchMapping$0[deviceFilterType.ordinal()];
        if (i == 1) {
            String string = getString(R.string.order_filter);
            Intrinsics.checkNotNull(string);
            return string;
        } else if (i == 2) {
            String string2 = getString(R.string.order_wick);
            Intrinsics.checkNotNull(string2);
            return string2;
        } else if (i == 3) {
            String string3 = getString(R.string.order_refresher);
            Intrinsics.checkNotNull(string3);
            return string3;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    public void onStart() {
        Window window;
        super.onStart();
        int dpToPx = (int) TypedValueCompat.dpToPx(468.0f, getResources().getDisplayMetrics());
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setLayout(-1, dpToPx);
        }
    }

    public void showProgress(boolean z) {
        DialogfragmentBuyFilterV2Binding dialogfragmentBuyFilterV2Binding = this.binding;
        if (dialogfragmentBuyFilterV2Binding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogfragmentBuyFilterV2Binding = null;
        }
        ProgressBlockerView progressBlockerView = dialogfragmentBuyFilterV2Binding.progressView;
        Intrinsics.checkNotNullExpressionValue(progressBlockerView, "progressView");
        ViewExtensionsKt.show(progressBlockerView, z);
    }

    public void onResume() {
        super.onResume();
        if (shouldDismiss) {
            shouldDismiss = false;
            dismiss();
        }
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
