package com.blueair.devicedetails.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.Group;
import androidx.core.os.BundleKt;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelLazy;
import com.blueair.android.activity.AccountLinkingActivity;
import com.blueair.core.model.AnalyticEvent;
import com.blueair.core.model.ConnectivityStatus;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceFilterType;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.FilterConfig;
import com.blueair.core.model.HasRemoveYellowWater;
import com.blueair.core.model.HasSKU;
import com.blueair.core.model.HasWick;
import com.blueair.core.model.UserManual;
import com.blueair.devicedetails.R;
import com.blueair.devicedetails.databinding.ActivityDeviceReplaceFilterBinding;
import com.blueair.devicedetails.dialog.DeviceDetailsDialogFragment;
import com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel;
import com.blueair.devicedetails.viewmodel.FilterLifeResetResult;
import com.blueair.push.NotificationService;
import com.blueair.viewcore.activity.Actions;
import com.blueair.viewcore.activity.BaseActivity;
import com.blueair.viewcore.dialog.ConfirmationDialogLeftAligned;
import com.blueair.viewcore.utils.DeviceConfigProvider;
import com.blueair.viewcore.utils.ToastUtils;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.dd.ShadowLayout;
import com.google.android.material.button.MaterialButton;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 $2\u00020\u0001:\u0001$B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0014J\b\u0010\u001b\u001a\u00020\u0018H\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001dH\u0002J\b\u0010 \u001a\u00020\u0018H\u0002J\u000e\u0010!\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020#R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\b\u001a\u00020\t8BX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\u00058BX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0007R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/blueair/devicedetails/activity/ReplaceFilterActivity;", "Lcom/blueair/viewcore/activity/BaseActivity;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "viewModel", "Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;", "getViewModel", "()Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "binding", "Lcom/blueair/devicedetails/databinding/ActivityDeviceReplaceFilterBinding;", "device", "Lcom/blueair/core/model/HasSKU;", "deviceSku", "sku", "getSku", "type", "Lcom/blueair/core/model/DeviceFilterType;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "configure", "getResetTitleRes", "", "getResetMsgRes", "leftLifePercentage", "showDeviceOfflinePrompt", "showProgress", "shouldShowProgress", "", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: ReplaceFilterActivity.kt */
public final class ReplaceFilterActivity extends BaseActivity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String EXTRA_TYPE = "EXTRA_TYPE";
    private ActivityDeviceReplaceFilterBinding binding;
    private HasSKU device;
    private String deviceSku;
    private final String screenName = AnalyticEvent.ScreenViewEvent.DEVICE_FILTER_REPLACE;
    private DeviceFilterType type;
    private final Lazy viewModel$delegate;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: ReplaceFilterActivity.kt */
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
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.activity.ReplaceFilterActivity.WhenMappings.<clinit>():void");
        }
    }

    public ReplaceFilterActivity() {
        ComponentActivity componentActivity = this;
        this.viewModel$delegate = new ViewModelLazy(Reflection.getOrCreateKotlinClass(DeviceDetailsViewModel.class), new ReplaceFilterActivity$special$$inlined$viewModels$default$2(componentActivity), new ReplaceFilterActivity$special$$inlined$viewModels$default$1(componentActivity), new ReplaceFilterActivity$special$$inlined$viewModels$default$3((Function0) null, componentActivity));
        this.type = DeviceFilterType.FILTER;
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\r\u001a\u00020\u000eJ*\u0010\u000f\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/blueair/devicedetails/activity/ReplaceFilterActivity$Companion;", "", "<init>", "()V", "EXTRA_TYPE", "", "getLaunchIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "device", "Lcom/blueair/core/model/Device;", "deviceSku", "type", "Lcom/blueair/core/model/DeviceFilterType;", "launch", "", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: ReplaceFilterActivity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Intent getLaunchIntent(Context context, Device device, String str, DeviceFilterType deviceFilterType) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(deviceFilterType, "type");
            Intent intent = new Intent(context, ReplaceFilterActivity.class);
            intent.putExtras(BundleKt.bundleOf(TuplesKt.to("device", device), TuplesKt.to(Actions.EXTRA_DEVICE_SKU, str), TuplesKt.to(ReplaceFilterActivity.EXTRA_TYPE, deviceFilterType.name())));
            return intent;
        }

        public final void launch(Context context, Device device, String str, DeviceFilterType deviceFilterType) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(deviceFilterType, "type");
            context.startActivity(getLaunchIntent(context, device, str, deviceFilterType));
        }
    }

    /* access modifiers changed from: protected */
    public String getScreenName() {
        return this.screenName;
    }

    private final DeviceDetailsViewModel getViewModel() {
        return (DeviceDetailsViewModel) this.viewModel$delegate.getValue();
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

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.device = (HasSKU) extras.getParcelable("device");
            this.deviceSku = extras.getString(Actions.EXTRA_DEVICE_SKU);
            String string = extras.getString(EXTRA_TYPE, "FILTER");
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            this.type = DeviceFilterType.valueOf(string);
        }
        ViewDataBinding contentView = DataBindingUtil.setContentView(this, R.layout.activity_device_replace_filter);
        Intrinsics.checkNotNullExpressionValue(contentView, "setContentView(...)");
        this.binding = (ActivityDeviceReplaceFilterBinding) contentView;
        configure();
    }

    private final void configure() {
        UserManual userManual;
        HasSKU hasSKU;
        HasSKU hasSKU2;
        ActivityDeviceReplaceFilterBinding activityDeviceReplaceFilterBinding = this.binding;
        Integer num = null;
        if (activityDeviceReplaceFilterBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityDeviceReplaceFilterBinding = null;
        }
        activityDeviceReplaceFilterBinding.closeBtn.setOnClickListener(new ReplaceFilterActivity$$ExternalSyntheticLambda1(this));
        ActivityDeviceReplaceFilterBinding activityDeviceReplaceFilterBinding2 = this.binding;
        if (activityDeviceReplaceFilterBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityDeviceReplaceFilterBinding2 = null;
        }
        activityDeviceReplaceFilterBinding2.btnBack.setOnClickListener(new ReplaceFilterActivity$$ExternalSyntheticLambda2(this));
        if (this.type == DeviceFilterType.REFRESHER) {
            userManual = DeviceConfigProvider.INSTANCE.getRefresherManual(getSku());
        } else {
            userManual = DeviceConfigProvider.INSTANCE.getUserManual(getSku());
        }
        String link = userManual != null ? userManual.getLink() : null;
        CharSequence charSequence = link;
        boolean z = false;
        if (!(charSequence == null || charSequence.length() == 0)) {
            ActivityDeviceReplaceFilterBinding activityDeviceReplaceFilterBinding3 = this.binding;
            if (activityDeviceReplaceFilterBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityDeviceReplaceFilterBinding3 = null;
            }
            Group group = activityDeviceReplaceFilterBinding3.groupUserManual;
            Intrinsics.checkNotNullExpressionValue(group, "groupUserManual");
            ViewExtensionsKt.show$default(group, false, 1, (Object) null);
            ActivityDeviceReplaceFilterBinding activityDeviceReplaceFilterBinding4 = this.binding;
            if (activityDeviceReplaceFilterBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityDeviceReplaceFilterBinding4 = null;
            }
            activityDeviceReplaceFilterBinding4.slUserManual.setOnClickListener(new ReplaceFilterActivity$$ExternalSyntheticLambda3(this, userManual, link));
        }
        FilterConfig filterConfig = DeviceConfigProvider.INSTANCE.getFilterConfig(getSku(), this.type);
        int i = WhenMappings.$EnumSwitchMapping$0[this.type.ordinal()];
        if (i == 1) {
            ActivityDeviceReplaceFilterBinding activityDeviceReplaceFilterBinding5 = this.binding;
            if (activityDeviceReplaceFilterBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityDeviceReplaceFilterBinding5 = null;
            }
            activityDeviceReplaceFilterBinding5.title.setText(com.blueair.viewcore.R.string.replace_filter);
            ActivityDeviceReplaceFilterBinding activityDeviceReplaceFilterBinding6 = this.binding;
            if (activityDeviceReplaceFilterBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityDeviceReplaceFilterBinding6 = null;
            }
            activityDeviceReplaceFilterBinding6.whyIsThisImportant.setText(com.blueair.viewcore.R.string.why_is_this_important);
            ActivityDeviceReplaceFilterBinding activityDeviceReplaceFilterBinding7 = this.binding;
            if (activityDeviceReplaceFilterBinding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityDeviceReplaceFilterBinding7 = null;
            }
            activityDeviceReplaceFilterBinding7.videoSummary.setText(com.blueair.viewcore.R.string.video_summary);
            ActivityDeviceReplaceFilterBinding activityDeviceReplaceFilterBinding8 = this.binding;
            if (activityDeviceReplaceFilterBinding8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityDeviceReplaceFilterBinding8 = null;
            }
            activityDeviceReplaceFilterBinding8.tvManualInfo.setText(com.blueair.viewcore.R.string.how_to_replace_your_filter);
        } else if (i == 2) {
            ActivityDeviceReplaceFilterBinding activityDeviceReplaceFilterBinding9 = this.binding;
            if (activityDeviceReplaceFilterBinding9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityDeviceReplaceFilterBinding9 = null;
            }
            activityDeviceReplaceFilterBinding9.title.setText(com.blueair.viewcore.R.string.replace_wick_filter);
            ActivityDeviceReplaceFilterBinding activityDeviceReplaceFilterBinding10 = this.binding;
            if (activityDeviceReplaceFilterBinding10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityDeviceReplaceFilterBinding10 = null;
            }
            activityDeviceReplaceFilterBinding10.whyIsThisImportant.setText(com.blueair.viewcore.R.string.why_is_this_important_wick);
            ActivityDeviceReplaceFilterBinding activityDeviceReplaceFilterBinding11 = this.binding;
            if (activityDeviceReplaceFilterBinding11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityDeviceReplaceFilterBinding11 = null;
            }
            activityDeviceReplaceFilterBinding11.videoSummary.setText(com.blueair.viewcore.R.string.video_summary_wick_v2);
            ActivityDeviceReplaceFilterBinding activityDeviceReplaceFilterBinding12 = this.binding;
            if (activityDeviceReplaceFilterBinding12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityDeviceReplaceFilterBinding12 = null;
            }
            activityDeviceReplaceFilterBinding12.tvManualInfo.setText(com.blueair.viewcore.R.string.how_to_replace_your_wick_filter);
        } else if (i == 3) {
            ActivityDeviceReplaceFilterBinding activityDeviceReplaceFilterBinding13 = this.binding;
            if (activityDeviceReplaceFilterBinding13 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityDeviceReplaceFilterBinding13 = null;
            }
            activityDeviceReplaceFilterBinding13.title.setText(com.blueair.viewcore.R.string.replace_water_refresher);
            ActivityDeviceReplaceFilterBinding activityDeviceReplaceFilterBinding14 = this.binding;
            if (activityDeviceReplaceFilterBinding14 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityDeviceReplaceFilterBinding14 = null;
            }
            activityDeviceReplaceFilterBinding14.whyIsThisImportant.setText(com.blueair.viewcore.R.string.why_is_this_important);
            ActivityDeviceReplaceFilterBinding activityDeviceReplaceFilterBinding15 = this.binding;
            if (activityDeviceReplaceFilterBinding15 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityDeviceReplaceFilterBinding15 = null;
            }
            activityDeviceReplaceFilterBinding15.videoSummary.setText(com.blueair.viewcore.R.string.video_summary_refresher);
            ActivityDeviceReplaceFilterBinding activityDeviceReplaceFilterBinding16 = this.binding;
            if (activityDeviceReplaceFilterBinding16 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityDeviceReplaceFilterBinding16 = null;
            }
            activityDeviceReplaceFilterBinding16.tvManualInfo.setText(com.blueair.viewcore.R.string.how_to_replace_your_refresher);
            ActivityDeviceReplaceFilterBinding activityDeviceReplaceFilterBinding17 = this.binding;
            if (activityDeviceReplaceFilterBinding17 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityDeviceReplaceFilterBinding17 = null;
            }
            activityDeviceReplaceFilterBinding17.btnResetFilter.setText(com.blueair.viewcore.R.string.reset_refresher_life);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        HasSKU hasSKU3 = this.device;
        if (hasSKU3 != null) {
            ActivityDeviceReplaceFilterBinding activityDeviceReplaceFilterBinding18 = this.binding;
            if (activityDeviceReplaceFilterBinding18 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityDeviceReplaceFilterBinding18 = null;
            }
            activityDeviceReplaceFilterBinding18.tvSubtitle.setText(hasSKU3.getName());
            ActivityDeviceReplaceFilterBinding activityDeviceReplaceFilterBinding19 = this.binding;
            if (activityDeviceReplaceFilterBinding19 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityDeviceReplaceFilterBinding19 = null;
            }
            AppCompatTextView appCompatTextView = activityDeviceReplaceFilterBinding19.tvSubtitle;
            Intrinsics.checkNotNullExpressionValue(appCompatTextView, "tvSubtitle");
            ViewExtensionsKt.show$default(appCompatTextView, false, 1, (Object) null);
        }
        String awsLinkValue = DeviceConfigProvider.INSTANCE.getAwsLinkValue(filterConfig != null ? filterConfig.getVideo() : null);
        Integer valueOf = filterConfig != null ? Integer.valueOf(filterConfig.getVideoThumbnail()) : null;
        if (awsLinkValue == null || valueOf == null) {
            ActivityDeviceReplaceFilterBinding activityDeviceReplaceFilterBinding20 = this.binding;
            if (activityDeviceReplaceFilterBinding20 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityDeviceReplaceFilterBinding20 = null;
            }
            ShadowLayout shadowLayout = activityDeviceReplaceFilterBinding20.slReplaceFilter;
            Intrinsics.checkNotNullExpressionValue(shadowLayout, "slReplaceFilter");
            ViewExtensionsKt.hide(shadowLayout);
            ActivityDeviceReplaceFilterBinding activityDeviceReplaceFilterBinding21 = this.binding;
            if (activityDeviceReplaceFilterBinding21 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityDeviceReplaceFilterBinding21 = null;
            }
            TextView textView = activityDeviceReplaceFilterBinding21.tvWatchVideo;
            Intrinsics.checkNotNullExpressionValue(textView, "tvWatchVideo");
            ViewExtensionsKt.hide(textView);
        } else {
            ActivityDeviceReplaceFilterBinding activityDeviceReplaceFilterBinding22 = this.binding;
            if (activityDeviceReplaceFilterBinding22 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityDeviceReplaceFilterBinding22 = null;
            }
            activityDeviceReplaceFilterBinding22.videoThumbnail.setImageResource(valueOf.intValue());
            ActivityDeviceReplaceFilterBinding activityDeviceReplaceFilterBinding23 = this.binding;
            if (activityDeviceReplaceFilterBinding23 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityDeviceReplaceFilterBinding23 = null;
            }
            activityDeviceReplaceFilterBinding23.iconPlay.setOnClickListener(new ReplaceFilterActivity$$ExternalSyntheticLambda4(this, awsLinkValue));
        }
        ActivityDeviceReplaceFilterBinding activityDeviceReplaceFilterBinding24 = this.binding;
        if (activityDeviceReplaceFilterBinding24 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityDeviceReplaceFilterBinding24 = null;
        }
        boolean deviceSupportAntiFake = getViewModel().deviceSupportAntiFake(this.device);
        MaterialButton materialButton = activityDeviceReplaceFilterBinding24.btnResetFilter;
        Intrinsics.checkNotNullExpressionValue(materialButton, "btnResetFilter");
        View view = materialButton;
        if (deviceSupportAntiFake || ((hasSKU = this.device) != null && !DeviceKt.isNewBlue(hasSKU) && (hasSKU2 = this.device) != null && DeviceKt.useNewFilterConfig(hasSKU2))) {
            z = true;
        }
        ViewExtensionsKt.show(view, z);
        if (deviceSupportAntiFake) {
            activityDeviceReplaceFilterBinding24.btnResetFilter.setIconResource(com.blueair.viewcore.R.drawable.ic_scan_flat);
        }
        int i2 = WhenMappings.$EnumSwitchMapping$0[this.type.ordinal()];
        if (i2 == 1) {
            num = DeviceConfigProvider.INSTANCE.getFilterLifeLeftPercentage(this.device);
        } else if (i2 == 2) {
            HasSKU hasSKU4 = this.device;
            HasWick hasWick = hasSKU4 instanceof HasWick ? (HasWick) hasSKU4 : null;
            if (hasWick != null) {
                num = Integer.valueOf(hasWick.getWickLifeLeft());
            }
        } else if (i2 == 3) {
            HasSKU hasSKU5 = this.device;
            HasRemoveYellowWater hasRemoveYellowWater = hasSKU5 instanceof HasRemoveYellowWater ? (HasRemoveYellowWater) hasSKU5 : null;
            if (hasRemoveYellowWater != null) {
                num = Integer.valueOf(hasRemoveYellowWater.getRefresherLifeLeft());
            }
        } else {
            throw new NoWhenBranchMatchedException();
        }
        if (num != null) {
            num.intValue();
            activityDeviceReplaceFilterBinding24.btnResetFilter.setOnClickListener(new ReplaceFilterActivity$$ExternalSyntheticLambda5(this, num));
        }
        getViewModel().getResetFilterLifeResult().observe(this, new ReplaceFilterActivity$sam$androidx_lifecycle_Observer$0(new ReplaceFilterActivity$$ExternalSyntheticLambda6(this)));
    }

    /* access modifiers changed from: private */
    public static final void configure$lambda$1(ReplaceFilterActivity replaceFilterActivity, View view) {
        replaceFilterActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final void configure$lambda$2(ReplaceFilterActivity replaceFilterActivity, View view) {
        replaceFilterActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final void configure$lambda$3(ReplaceFilterActivity replaceFilterActivity, UserManual userManual, String str, View view) {
        int i;
        int i2 = WhenMappings.$EnumSwitchMapping$0[replaceFilterActivity.type.ordinal()];
        if (i2 == 1) {
            i = userManual.getFilterIndex();
        } else if (i2 == 2) {
            i = userManual.getWickIndex();
        } else if (i2 == 3) {
            i = userManual.getRefresherIndex();
        } else {
            throw new NoWhenBranchMatchedException();
        }
        UserManualActivity.Companion.launch(replaceFilterActivity, AnalyticEvent.ScreenViewEvent.DEVICE_FILTER_MANUAL, str, i);
    }

    /* access modifiers changed from: private */
    public static final void configure$lambda$5(ReplaceFilterActivity replaceFilterActivity, String str, View view) {
        FilterVideoActivity.Companion.launch(replaceFilterActivity, str);
    }

    /* access modifiers changed from: private */
    public static final void configure$lambda$11$lambda$10$lambda$9(ReplaceFilterActivity replaceFilterActivity, Integer num, View view) {
        ReplaceFilterActivity replaceFilterActivity2 = replaceFilterActivity;
        if (replaceFilterActivity2.device == null || !replaceFilterActivity2.getViewModel().deviceSupportAntiFake(replaceFilterActivity2.device)) {
            HasSKU hasSKU = replaceFilterActivity2.device;
            if ((hasSKU != null ? hasSKU.getConnectivityStatus() : null) == ConnectivityStatus.ONLINE) {
                FragmentManager supportFragmentManager = replaceFilterActivity2.getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
                Class<ConfirmationDialogLeftAligned> cls = ConfirmationDialogLeftAligned.class;
                Intrinsics.checkNotNullExpressionValue("ConfirmationDialogLeftAligned", "getSimpleName(...)");
                if (!(supportFragmentManager.findFragmentByTag("ConfirmationDialogLeftAligned") instanceof ConfirmationDialogLeftAligned) && !supportFragmentManager.isStateSaved()) {
                    ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, replaceFilterActivity2.getResetTitleRes(), (Integer) null, replaceFilterActivity2.getResetMsgRes(num.intValue()), Integer.valueOf(com.blueair.viewcore.R.string.confirm), Integer.valueOf(com.blueair.viewcore.R.string.btn_cancel), false, false, false, true, (String[]) null, (String) null, new ReplaceFilterActivity$$ExternalSyntheticLambda0(replaceFilterActivity2), 1632, (Object) null).show(supportFragmentManager, "ConfirmationDialogLeftAligned");
                    return;
                }
                return;
            }
            replaceFilterActivity2.showDeviceOfflinePrompt();
            return;
        }
        HasSKU hasSKU2 = replaceFilterActivity2.device;
        Intrinsics.checkNotNull(hasSKU2, "null cannot be cast to non-null type com.blueair.core.model.HasSKU");
        replaceFilterActivity2.startActivity(Actions.INSTANCE.openAntiFakeScanIntent(replaceFilterActivity2, hasSKU2, replaceFilterActivity2.type));
    }

    /* access modifiers changed from: private */
    public static final Unit configure$lambda$11$lambda$10$lambda$9$lambda$8$lambda$7(ReplaceFilterActivity replaceFilterActivity, boolean z) {
        HasSKU hasSKU;
        if (z && (hasSKU = replaceFilterActivity.device) != null) {
            replaceFilterActivity.showProgress(true);
            replaceFilterActivity.getViewModel().resetFilterLife(hasSKU, replaceFilterActivity.type);
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit configure$lambda$13(ReplaceFilterActivity replaceFilterActivity, FilterLifeResetResult filterLifeResetResult) {
        String str;
        ReplaceFilterActivity replaceFilterActivity2 = replaceFilterActivity;
        if (filterLifeResetResult != null) {
            replaceFilterActivity2.showProgress(false);
            int i = WhenMappings.$EnumSwitchMapping$1[filterLifeResetResult.ordinal()];
            if (i == 1) {
                DeviceDetailsDialogFragment.Companion companion = DeviceDetailsDialogFragment.Companion;
                int i2 = WhenMappings.$EnumSwitchMapping$0[replaceFilterActivity2.type.ordinal()];
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
                ToastUtils.INSTANCE.showCenterToast(replaceFilterActivity2, com.blueair.viewcore.R.string.reset_successful, 1);
                replaceFilterActivity2.finish();
            } else if (i == 2) {
                FragmentManager supportFragmentManager = replaceFilterActivity2.getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
                if (!(supportFragmentManager.findFragmentByTag(AccountLinkingActivity.STATE_FAILED) instanceof ConfirmationDialogLeftAligned) && !supportFragmentManager.isStateSaved()) {
                    ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, com.blueair.viewcore.R.string.reset_failed, (Integer) null, com.blueair.viewcore.R.string.troubleshotting_reset_filter_internal_error, Integer.valueOf(com.blueair.viewcore.R.string.snackbar_ok), (Integer) null, false, false, false, true, (String[]) null, (String) null, (Function1) null, 3808, (Object) null).show(supportFragmentManager, AccountLinkingActivity.STATE_FAILED);
                }
            } else if (i == 3) {
                replaceFilterActivity2.showDeviceOfflinePrompt();
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
        return Unit.INSTANCE;
    }

    private final int getResetTitleRes() {
        int i = WhenMappings.$EnumSwitchMapping$0[this.type.ordinal()];
        if (i == 1) {
            return com.blueair.viewcore.R.string.confirm_reset;
        }
        if (i == 2) {
            return com.blueair.viewcore.R.string.confirm_reset_wick_filter;
        }
        if (i == 3) {
            return com.blueair.viewcore.R.string.confirm_refresher_reset;
        }
        throw new NoWhenBranchMatchedException();
    }

    private final int getResetMsgRes(int i) {
        int i2 = WhenMappings.$EnumSwitchMapping$0[this.type.ordinal()];
        if (i2 == 1) {
            return i > 10 ? com.blueair.viewcore.R.string.reset_filter_life_msg_normal : com.blueair.viewcore.R.string.reset_filter_life_msg_lower;
        }
        if (i2 == 2) {
            return i > 10 ? com.blueair.viewcore.R.string.reset_wick_filter_life_msg_normal : com.blueair.viewcore.R.string.reset_wick_filter_life_msg_lower;
        }
        if (i2 != 3) {
            throw new NoWhenBranchMatchedException();
        } else if (i > 10) {
            return com.blueair.viewcore.R.string.reset_refresher_msg_normal;
        } else {
            return com.blueair.viewcore.R.string.reset_refresher_msg_lower;
        }
    }

    private final void showDeviceOfflinePrompt() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        if (!(supportFragmentManager.findFragmentByTag("DEVICE_OFFLINE") instanceof ConfirmationDialogLeftAligned) && !supportFragmentManager.isStateSaved()) {
            ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, com.blueair.viewcore.R.string.offline_title_device, (Integer) null, com.blueair.viewcore.R.string.offline_subtitle, Integer.valueOf(com.blueair.viewcore.R.string.snackbar_ok), (Integer) null, false, false, false, true, (String[]) null, (String) null, (Function1) null, 3808, (Object) null).show(supportFragmentManager, "DEVICE_OFFLINE");
        }
    }

    public final void showProgress(boolean z) {
        ActivityDeviceReplaceFilterBinding activityDeviceReplaceFilterBinding = this.binding;
        if (activityDeviceReplaceFilterBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityDeviceReplaceFilterBinding = null;
        }
        ProgressBlockerView progressBlockerView = activityDeviceReplaceFilterBinding.progressView;
        Intrinsics.checkNotNullExpressionValue(progressBlockerView, "progressView");
        ViewExtensionsKt.show(progressBlockerView, z);
    }
}
