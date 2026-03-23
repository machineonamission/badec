package com.blueair.devicedetails.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.Group;
import androidx.core.os.BundleKt;
import androidx.core.util.TypedValueCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelLazy;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.android.activity.AccountLinkingActivity;
import com.blueair.android.activity.InfoActivity;
import com.blueair.core.model.AnalyticEvent;
import com.blueair.core.model.ConnectivityStatus;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceFilterType;
import com.blueair.core.model.DeviceHumidifier;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.DeviceMiniRestful;
import com.blueair.core.model.DeviceType;
import com.blueair.core.model.FilterConfig;
import com.blueair.core.model.FilterInfo;
import com.blueair.core.model.HasRemoveYellowWater;
import com.blueair.core.model.HasSKU;
import com.blueair.core.model.HasWick;
import com.blueair.core.model.I18nConfig;
import com.blueair.devicedetails.R;
import com.blueair.devicedetails.activity.ReplaceFilterActivity;
import com.blueair.devicedetails.databinding.ActivityDeviceFilterDetailBinding;
import com.blueair.devicedetails.dialog.BuyFilterV2DialogFragment;
import com.blueair.devicedetails.viewmodel.DeviceDetailsState;
import com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel;
import com.blueair.devicedetails.viewmodel.FilterLifeResetResult;
import com.blueair.push.NotificationService;
import com.blueair.viewcore.activity.Actions;
import com.blueair.viewcore.activity.BaseActivity;
import com.blueair.viewcore.adapter.FilterTypeAdapter;
import com.blueair.viewcore.dialog.ConfirmationDialogLeftAligned;
import com.blueair.viewcore.utils.DeviceConfigProvider;
import com.blueair.viewcore.utils.ToastUtils;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.dd.ShadowLayout;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.imageview.ShapeableImageView;
import io.flatcircle.livedatahelper.LiveDataExtensionsKt;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.Regex;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\f\u0018\u0000 52\u00020\u0001:\u00015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0014J\b\u0010&\u001a\u00020#H\u0002J\b\u0010'\u001a\u00020#H\u0002J\b\u0010(\u001a\u00020#H\u0002J\b\u0010)\u001a\u00020*H\u0002J\u0010\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020*H\u0002J\b\u0010-\u001a\u00020#H\u0002J\u0010\u0010.\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\u0005H\u0002J\b\u00100\u001a\u00020#H\u0002J\u0010\u00101\u001a\u00020#2\u0006\u0010,\u001a\u00020*H\u0002J\b\u00102\u001a\u00020#H\u0002J\u000e\u00103\u001a\u00020#2\u0006\u00104\u001a\u00020\u001eR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00058TX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X.¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\u00020\u00058BX\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0007R\u000e\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u001eX\u000e¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/blueair/devicedetails/activity/DeviceFilterDetailActivity;", "Lcom/blueair/viewcore/activity/BaseActivity;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "_screenName", "viewModel", "Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;", "getViewModel", "()Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "binding", "Lcom/blueair/devicedetails/databinding/ActivityDeviceFilterDetailBinding;", "filterAdapter", "Lcom/blueair/viewcore/adapter/FilterTypeAdapter;", "replaceFilterLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "device", "Lcom/blueair/core/model/Device;", "deviceSku", "sku", "getSku", "type", "Lcom/blueair/core/model/DeviceFilterType;", "fromNotification", "", "filterConfig", "Lcom/blueair/core/model/FilterConfig;", "hasBuyFilterLink", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "configureView", "observeViewModel", "hydrateFilterLife", "getResetTitleRes", "", "getResetMsgRes", "leftLifePercentage", "hydrateDeviceFilters", "replaceNewline", "source", "hydrateResetFilterCard", "hydrateFilterInfo", "showDeviceOfflinePrompt", "showProgress", "shouldShowProgress", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceFilterDetailActivity.kt */
public final class DeviceFilterDetailActivity extends BaseActivity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String EXTRA_FROM_NOTIFICATION = "extra_from_notification";
    private static final String EXTRA_TYPE = "EXTRA_TYPE";
    private String _screenName;
    private ActivityDeviceFilterDetailBinding binding;
    private Device device;
    private String deviceSku;
    private FilterTypeAdapter filterAdapter;
    private FilterConfig filterConfig;
    private boolean fromNotification;
    private boolean hasBuyFilterLink;
    private ActivityResultLauncher<Intent> replaceFilterLauncher;
    private DeviceFilterType type = DeviceFilterType.FILTER;
    private final Lazy viewModel$delegate;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceFilterDetailActivity.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|16|(2:17|18)|19|21) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0033 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x003b */
        static {
            /*
                com.blueair.devicedetails.viewmodel.FilterLifeResetResult[] r0 = com.blueair.devicedetails.viewmodel.FilterLifeResetResult.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                r1 = 1
                com.blueair.devicedetails.viewmodel.FilterLifeResetResult r2 = com.blueair.devicedetails.viewmodel.FilterLifeResetResult.SUCCESS     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                r2 = 2
                com.blueair.devicedetails.viewmodel.FilterLifeResetResult r3 = com.blueair.devicedetails.viewmodel.FilterLifeResetResult.FAILED     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                r3 = 3
                com.blueair.devicedetails.viewmodel.FilterLifeResetResult r4 = com.blueair.devicedetails.viewmodel.FilterLifeResetResult.DEVICE_OFFLINE     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r0[r4] = r3     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                $EnumSwitchMapping$0 = r0
                com.blueair.core.model.DeviceFilterType[] r0 = com.blueair.core.model.DeviceFilterType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.blueair.core.model.DeviceFilterType r4 = com.blueair.core.model.DeviceFilterType.FILTER     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r0[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                com.blueair.core.model.DeviceFilterType r1 = com.blueair.core.model.DeviceFilterType.WICK     // Catch:{ NoSuchFieldError -> 0x003b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003b }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003b }
            L_0x003b:
                com.blueair.core.model.DeviceFilterType r1 = com.blueair.core.model.DeviceFilterType.REFRESHER     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                $EnumSwitchMapping$1 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.activity.DeviceFilterDetailActivity.WhenMappings.<clinit>():void");
        }
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$1(ActivityResult activityResult) {
    }

    public DeviceFilterDetailActivity() {
        ComponentActivity componentActivity = this;
        this.viewModel$delegate = new ViewModelLazy(Reflection.getOrCreateKotlinClass(DeviceDetailsViewModel.class), new DeviceFilterDetailActivity$special$$inlined$viewModels$default$2(componentActivity), new DeviceFilterDetailActivity$special$$inlined$viewModels$default$1(componentActivity), new DeviceFilterDetailActivity$special$$inlined$viewModels$default$3((Function0) null, componentActivity));
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J4\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011J4\u0010\u0012\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/blueair/devicedetails/activity/DeviceFilterDetailActivity$Companion;", "", "<init>", "()V", "EXTRA_TYPE", "", "EXTRA_FROM_NOTIFICATION", "getLaunchIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "device", "Lcom/blueair/core/model/Device;", "deviceSku", "type", "Lcom/blueair/core/model/DeviceFilterType;", "fromNotification", "", "launch", "", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceFilterDetailActivity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ Intent getLaunchIntent$default(Companion companion, Context context, Device device, String str, DeviceFilterType deviceFilterType, boolean z, int i, Object obj) {
            if ((i & 16) != 0) {
                z = false;
            }
            return companion.getLaunchIntent(context, device, str, deviceFilterType, z);
        }

        public final Intent getLaunchIntent(Context context, Device device, String str, DeviceFilterType deviceFilterType, boolean z) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(deviceFilterType, "type");
            Intent intent = new Intent(context, DeviceFilterDetailActivity.class);
            intent.putExtras(BundleKt.bundleOf(TuplesKt.to("screen_name", z ? AnalyticEvent.ScreenViewEvent.NOTIFICATIONS_FILTER : AnalyticEvent.ScreenViewEvent.DEVICE_DETAILS_FILTER), TuplesKt.to("device", device), TuplesKt.to(Actions.EXTRA_DEVICE_SKU, str), TuplesKt.to(DeviceFilterDetailActivity.EXTRA_TYPE, deviceFilterType.name()), TuplesKt.to(DeviceFilterDetailActivity.EXTRA_FROM_NOTIFICATION, Boolean.valueOf(z))));
            return intent;
        }

        public static /* synthetic */ void launch$default(Companion companion, Context context, Device device, String str, DeviceFilterType deviceFilterType, boolean z, int i, Object obj) {
            if ((i & 16) != 0) {
                z = false;
            }
            companion.launch(context, device, str, deviceFilterType, z);
        }

        public final void launch(Context context, Device device, String str, DeviceFilterType deviceFilterType, boolean z) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(deviceFilterType, "type");
            context.startActivity(getLaunchIntent(context, device, str, deviceFilterType, z));
        }
    }

    /* access modifiers changed from: protected */
    public String getScreenName() {
        return this._screenName;
    }

    private final DeviceDetailsViewModel getViewModel() {
        return (DeviceDetailsViewModel) this.viewModel$delegate.getValue();
    }

    private final String getSku() {
        String sku;
        Device device2 = this.device;
        HasSKU hasSKU = device2 instanceof HasSKU ? (HasSKU) device2 : null;
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
            this._screenName = extras.getString("screen_name");
            this.device = (Device) extras.getParcelable("device");
            this.deviceSku = extras.getString(Actions.EXTRA_DEVICE_SKU);
            String string = extras.getString(EXTRA_TYPE, "FILTER");
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            this.type = DeviceFilterType.valueOf(string);
            this.fromNotification = extras.getBoolean(EXTRA_FROM_NOTIFICATION, false);
        }
        ViewDataBinding contentView = DataBindingUtil.setContentView(this, R.layout.activity_device_filter_detail);
        Intrinsics.checkNotNullExpressionValue(contentView, "setContentView(...)");
        this.binding = (ActivityDeviceFilterDetailBinding) contentView;
        ActivityResultLauncher<Intent> registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new DeviceFilterDetailActivity$$ExternalSyntheticLambda13());
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "registerForActivityResult(...)");
        this.replaceFilterLauncher = registerForActivityResult;
        configureView();
        observeViewModel();
    }

    private final void configureView() {
        ActivityDeviceFilterDetailBinding activityDeviceFilterDetailBinding = this.binding;
        ActivityDeviceFilterDetailBinding activityDeviceFilterDetailBinding2 = null;
        if (activityDeviceFilterDetailBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityDeviceFilterDetailBinding = null;
        }
        activityDeviceFilterDetailBinding.closeBtn.setOnClickListener(new DeviceFilterDetailActivity$$ExternalSyntheticLambda1(this));
        ActivityDeviceFilterDetailBinding activityDeviceFilterDetailBinding3 = this.binding;
        if (activityDeviceFilterDetailBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityDeviceFilterDetailBinding3 = null;
        }
        activityDeviceFilterDetailBinding3.btnBack.setOnClickListener(new DeviceFilterDetailActivity$$ExternalSyntheticLambda2(this));
        ActivityDeviceFilterDetailBinding activityDeviceFilterDetailBinding4 = this.binding;
        if (activityDeviceFilterDetailBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityDeviceFilterDetailBinding4 = null;
        }
        activityDeviceFilterDetailBinding4.btnGetInstructions.setOnClickListener(new DeviceFilterDetailActivity$$ExternalSyntheticLambda3(this));
        ActivityDeviceFilterDetailBinding activityDeviceFilterDetailBinding5 = this.binding;
        if (activityDeviceFilterDetailBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityDeviceFilterDetailBinding5 = null;
        }
        activityDeviceFilterDetailBinding5.btnBuy.setOnClickListener(new DeviceFilterDetailActivity$$ExternalSyntheticLambda4(this));
        DeviceConfigProvider deviceConfigProvider = DeviceConfigProvider.INSTANCE;
        String sku = getSku();
        Device device2 = this.device;
        this.filterConfig = deviceConfigProvider.getFilterConfig(sku, (device2 == null || !DeviceKt.shouldMergeFilter(device2)) ? this.type : null);
        this.hasBuyFilterLink = DeviceConfigProvider.INSTANCE.hasBuyFilterLink(this.filterConfig);
        ActivityDeviceFilterDetailBinding activityDeviceFilterDetailBinding6 = this.binding;
        if (activityDeviceFilterDetailBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityDeviceFilterDetailBinding6 = null;
        }
        MaterialButton materialButton = activityDeviceFilterDetailBinding6.btnBuy;
        Intrinsics.checkNotNullExpressionValue(materialButton, "btnBuy");
        materialButton.setVisibility(DeviceConfigProvider.INSTANCE.hasBuyFilterLink(DeviceConfigProvider.INSTANCE.getFilterConfig(getSku(), this.type)) ? 0 : 8);
        hydrateFilterLife();
        hydrateDeviceFilters();
        hydrateResetFilterCard();
        ActivityDeviceFilterDetailBinding activityDeviceFilterDetailBinding7 = this.binding;
        if (activityDeviceFilterDetailBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityDeviceFilterDetailBinding2 = activityDeviceFilterDetailBinding7;
        }
        activityDeviceFilterDetailBinding2.ivInfo.setOnClickListener(new DeviceFilterDetailActivity$$ExternalSyntheticLambda5(this));
    }

    /* access modifiers changed from: private */
    public static final void configureView$lambda$2(DeviceFilterDetailActivity deviceFilterDetailActivity, View view) {
        deviceFilterDetailActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final void configureView$lambda$3(DeviceFilterDetailActivity deviceFilterDetailActivity, View view) {
        deviceFilterDetailActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final void configureView$lambda$4(DeviceFilterDetailActivity deviceFilterDetailActivity, View view) {
        ActivityResultLauncher<Intent> activityResultLauncher = deviceFilterDetailActivity.replaceFilterLauncher;
        if (activityResultLauncher == null) {
            Intrinsics.throwUninitializedPropertyAccessException("replaceFilterLauncher");
            activityResultLauncher = null;
        }
        ReplaceFilterActivity.Companion companion = ReplaceFilterActivity.Companion;
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        activityResultLauncher.launch(companion.getLaunchIntent(context, deviceFilterDetailActivity.device, deviceFilterDetailActivity.deviceSku, deviceFilterDetailActivity.type));
    }

    /* access modifiers changed from: private */
    public static final void configureView$lambda$6(DeviceFilterDetailActivity deviceFilterDetailActivity, View view) {
        FragmentManager supportFragmentManager = deviceFilterDetailActivity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        Class<BuyFilterV2DialogFragment> cls = BuyFilterV2DialogFragment.class;
        Intrinsics.checkNotNullExpressionValue("BuyFilterV2DialogFragment", "getSimpleName(...)");
        if (!(supportFragmentManager.findFragmentByTag("BuyFilterV2DialogFragment") instanceof BuyFilterV2DialogFragment) && !supportFragmentManager.isStateSaved()) {
            BuyFilterV2DialogFragment.Companion.newInstance$default(BuyFilterV2DialogFragment.Companion, deviceFilterDetailActivity.device, deviceFilterDetailActivity.deviceSku, deviceFilterDetailActivity.type, deviceFilterDetailActivity.fromNotification, (String) null, 16, (Object) null).show(supportFragmentManager, "BuyFilterV2DialogFragment");
        }
    }

    /* access modifiers changed from: private */
    public static final void configureView$lambda$8(DeviceFilterDetailActivity deviceFilterDetailActivity, View view) {
        FragmentManager supportFragmentManager = deviceFilterDetailActivity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        Class<ConfirmationDialogLeftAligned> cls = ConfirmationDialogLeftAligned.class;
        Intrinsics.checkNotNullExpressionValue("ConfirmationDialogLeftAligned", "getSimpleName(...)");
        if (!(supportFragmentManager.findFragmentByTag("ConfirmationDialogLeftAligned") instanceof ConfirmationDialogLeftAligned) && !supportFragmentManager.isStateSaved()) {
            ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, com.blueair.viewcore.R.string.label_real_track_tech, (Integer) null, com.blueair.viewcore.R.string.real_track_instruction, Integer.valueOf(com.blueair.viewcore.R.string.confirmation_positive_default), (Integer) null, false, false, false, false, (String[]) null, (String) null, (Function1) null, 3936, (Object) null).show(supportFragmentManager, "ConfirmationDialogLeftAligned");
        }
    }

    private final void observeViewModel() {
        Device device2 = this.device;
        if (device2 != null) {
            getViewModel().setDeviceId(device2.getUid());
            LifecycleOwner lifecycleOwner = this;
            LiveDataExtensionsKt.observeNonNull(getViewModel().getLiveDevice(), lifecycleOwner, new DeviceFilterDetailActivity$$ExternalSyntheticLambda8(this));
            LiveDataExtensionsKt.observeNonNull(getViewModel().getDeviceDetailsState(), lifecycleOwner, new DeviceFilterDetailActivity$$ExternalSyntheticLambda9(this));
            getViewModel().getResetFilterLifeResult().observe(lifecycleOwner, new DeviceFilterDetailActivity$sam$androidx_lifecycle_Observer$0(new DeviceFilterDetailActivity$$ExternalSyntheticLambda10(this)));
        }
    }

    /* access modifiers changed from: private */
    public static final Unit observeViewModel$lambda$13$lambda$9(DeviceFilterDetailActivity deviceFilterDetailActivity, Device device2) {
        deviceFilterDetailActivity.getViewModel().setDevice(device2);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit observeViewModel$lambda$13$lambda$10(DeviceFilterDetailActivity deviceFilterDetailActivity, DeviceDetailsState deviceDetailsState) {
        Intrinsics.checkNotNullParameter(deviceDetailsState, "state");
        deviceFilterDetailActivity.device = deviceDetailsState.getDevice();
        deviceFilterDetailActivity.hydrateFilterLife();
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit observeViewModel$lambda$13$lambda$12(DeviceFilterDetailActivity deviceFilterDetailActivity, FilterLifeResetResult filterLifeResetResult) {
        DeviceFilterDetailActivity deviceFilterDetailActivity2 = deviceFilterDetailActivity;
        if (filterLifeResetResult != null) {
            deviceFilterDetailActivity2.showProgress(false);
            int i = WhenMappings.$EnumSwitchMapping$0[filterLifeResetResult.ordinal()];
            if (i == 1) {
                ToastUtils.INSTANCE.showCenterToast(deviceFilterDetailActivity2, com.blueair.viewcore.R.string.reset_successful, 1);
            } else if (i == 2) {
                FragmentManager supportFragmentManager = deviceFilterDetailActivity2.getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
                if (!(supportFragmentManager.findFragmentByTag(AccountLinkingActivity.STATE_FAILED) instanceof ConfirmationDialogLeftAligned) && !supportFragmentManager.isStateSaved()) {
                    ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, com.blueair.viewcore.R.string.reset_failed, (Integer) null, com.blueair.viewcore.R.string.troubleshotting_reset_filter_internal_error, Integer.valueOf(com.blueair.viewcore.R.string.snackbar_ok), (Integer) null, false, false, false, true, (String[]) null, (String) null, (Function1) null, 3808, (Object) null).show(supportFragmentManager, AccountLinkingActivity.STATE_FAILED);
                }
            } else if (i == 3) {
                deviceFilterDetailActivity2.showDeviceOfflinePrompt();
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
        return Unit.INSTANCE;
    }

    private final void hydrateFilterLife() {
        Integer num;
        Device device2;
        Device device3;
        boolean z;
        int i = WhenMappings.$EnumSwitchMapping$1[this.type.ordinal()];
        ActivityDeviceFilterDetailBinding activityDeviceFilterDetailBinding = null;
        boolean z2 = true;
        if (i != 1) {
            if (i == 2) {
                ActivityDeviceFilterDetailBinding activityDeviceFilterDetailBinding2 = this.binding;
                if (activityDeviceFilterDetailBinding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    activityDeviceFilterDetailBinding2 = null;
                }
                activityDeviceFilterDetailBinding2.title.setText(com.blueair.viewcore.R.string.wick_filter);
                ActivityDeviceFilterDetailBinding activityDeviceFilterDetailBinding3 = this.binding;
                if (activityDeviceFilterDetailBinding3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    activityDeviceFilterDetailBinding3 = null;
                }
                activityDeviceFilterDetailBinding3.tvFilterLife.setText(com.blueair.viewcore.R.string.wick_filter_life);
                ActivityDeviceFilterDetailBinding activityDeviceFilterDetailBinding4 = this.binding;
                if (activityDeviceFilterDetailBinding4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    activityDeviceFilterDetailBinding4 = null;
                }
                activityDeviceFilterDetailBinding4.btnBuy.setText(com.blueair.viewcore.R.string.action_buy_wick_filter);
                ActivityDeviceFilterDetailBinding activityDeviceFilterDetailBinding5 = this.binding;
                if (activityDeviceFilterDetailBinding5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    activityDeviceFilterDetailBinding5 = null;
                }
                activityDeviceFilterDetailBinding5.leadingIcon.setImageResource(com.blueair.viewcore.R.drawable.ic_humidity_wick);
                Device device4 = this.device;
                HasWick hasWick = device4 instanceof HasWick ? (HasWick) device4 : null;
                if (hasWick != null) {
                    num = Integer.valueOf(hasWick.getWickLifeLeft());
                }
            } else if (i == 3) {
                ActivityDeviceFilterDetailBinding activityDeviceFilterDetailBinding6 = this.binding;
                if (activityDeviceFilterDetailBinding6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    activityDeviceFilterDetailBinding6 = null;
                }
                activityDeviceFilterDetailBinding6.title.setText(com.blueair.viewcore.R.string.label_water_refresher);
                ActivityDeviceFilterDetailBinding activityDeviceFilterDetailBinding7 = this.binding;
                if (activityDeviceFilterDetailBinding7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    activityDeviceFilterDetailBinding7 = null;
                }
                activityDeviceFilterDetailBinding7.tvFilterLife.setText(com.blueair.viewcore.R.string.label_water_refresher);
                ActivityDeviceFilterDetailBinding activityDeviceFilterDetailBinding8 = this.binding;
                if (activityDeviceFilterDetailBinding8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    activityDeviceFilterDetailBinding8 = null;
                }
                activityDeviceFilterDetailBinding8.leadingIcon.setImageResource(com.blueair.viewcore.R.drawable.ic_water_refresher);
                ActivityDeviceFilterDetailBinding activityDeviceFilterDetailBinding9 = this.binding;
                if (activityDeviceFilterDetailBinding9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    activityDeviceFilterDetailBinding9 = null;
                }
                activityDeviceFilterDetailBinding9.btnBuy.setText(com.blueair.viewcore.R.string.action_buy_refresher);
                ActivityDeviceFilterDetailBinding activityDeviceFilterDetailBinding10 = this.binding;
                if (activityDeviceFilterDetailBinding10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    activityDeviceFilterDetailBinding10 = null;
                }
                activityDeviceFilterDetailBinding10.btnResetFilter.setText(com.blueair.viewcore.R.string.action_reset_refresher);
                ActivityDeviceFilterDetailBinding activityDeviceFilterDetailBinding11 = this.binding;
                if (activityDeviceFilterDetailBinding11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    activityDeviceFilterDetailBinding11 = null;
                }
                activityDeviceFilterDetailBinding11.tvChangeFilter.setText(com.blueair.viewcore.R.string.label_change_your_refresher);
                Device device5 = this.device;
                HasRemoveYellowWater hasRemoveYellowWater = device5 instanceof HasRemoveYellowWater ? (HasRemoveYellowWater) device5 : null;
                if (hasRemoveYellowWater != null) {
                    num = Integer.valueOf(hasRemoveYellowWater.getRefresherLifeLeft());
                }
            } else {
                throw new NoWhenBranchMatchedException();
            }
            num = null;
        } else {
            ActivityDeviceFilterDetailBinding activityDeviceFilterDetailBinding12 = this.binding;
            if (activityDeviceFilterDetailBinding12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityDeviceFilterDetailBinding12 = null;
            }
            activityDeviceFilterDetailBinding12.title.setText(com.blueair.viewcore.R.string.label_air_filter);
            ActivityDeviceFilterDetailBinding activityDeviceFilterDetailBinding13 = this.binding;
            if (activityDeviceFilterDetailBinding13 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityDeviceFilterDetailBinding13 = null;
            }
            activityDeviceFilterDetailBinding13.tvFilterLife.setText(com.blueair.viewcore.R.string.filter_life);
            ActivityDeviceFilterDetailBinding activityDeviceFilterDetailBinding14 = this.binding;
            if (activityDeviceFilterDetailBinding14 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityDeviceFilterDetailBinding14 = null;
            }
            activityDeviceFilterDetailBinding14.btnBuy.setText(com.blueair.viewcore.R.string.action_buy_air_filter);
            ActivityDeviceFilterDetailBinding activityDeviceFilterDetailBinding15 = this.binding;
            if (activityDeviceFilterDetailBinding15 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityDeviceFilterDetailBinding15 = null;
            }
            activityDeviceFilterDetailBinding15.leadingIcon.setImageResource(com.blueair.viewcore.R.drawable.ic_filter_status);
            ActivityDeviceFilterDetailBinding activityDeviceFilterDetailBinding16 = this.binding;
            if (activityDeviceFilterDetailBinding16 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityDeviceFilterDetailBinding16 = null;
            }
            ImageView imageView = activityDeviceFilterDetailBinding16.ivInfo;
            Intrinsics.checkNotNullExpressionValue(imageView, "ivInfo");
            View view = imageView;
            if (!(this.device instanceof DeviceMiniRestful)) {
                DeviceType.Companion companion = DeviceType.Companion;
                Device device6 = this.device;
                if (!companion.isNb411iMax(device6 != null ? DeviceKt.getSkuCompat(device6) : null)) {
                    z = true;
                    ViewExtensionsKt.show(view, z);
                    num = DeviceConfigProvider.INSTANCE.getFilterLifeLeftPercentage(this.device);
                }
            }
            z = false;
            ViewExtensionsKt.show(view, z);
            num = DeviceConfigProvider.INSTANCE.getFilterLifeLeftPercentage(this.device);
        }
        Device device7 = this.device;
        if (device7 != null) {
            ActivityDeviceFilterDetailBinding activityDeviceFilterDetailBinding17 = this.binding;
            if (activityDeviceFilterDetailBinding17 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityDeviceFilterDetailBinding17 = null;
            }
            activityDeviceFilterDetailBinding17.tvSubtitle.setText(device7.getName());
            ActivityDeviceFilterDetailBinding activityDeviceFilterDetailBinding18 = this.binding;
            if (activityDeviceFilterDetailBinding18 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityDeviceFilterDetailBinding18 = null;
            }
            AppCompatTextView appCompatTextView = activityDeviceFilterDetailBinding18.tvSubtitle;
            Intrinsics.checkNotNullExpressionValue(appCompatTextView, "tvSubtitle");
            ViewExtensionsKt.show$default(appCompatTextView, false, 1, (Object) null);
            if (num == null) {
                ActivityDeviceFilterDetailBinding activityDeviceFilterDetailBinding19 = this.binding;
                if (activityDeviceFilterDetailBinding19 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    activityDeviceFilterDetailBinding = activityDeviceFilterDetailBinding19;
                }
                ShadowLayout shadowLayout = activityDeviceFilterDetailBinding.cvFilterLife;
                Intrinsics.checkNotNullExpressionValue(shadowLayout, "cvFilterLife");
                ViewExtensionsKt.hide(shadowLayout);
                return;
            }
            ActivityDeviceFilterDetailBinding activityDeviceFilterDetailBinding20 = this.binding;
            if (activityDeviceFilterDetailBinding20 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityDeviceFilterDetailBinding20 = null;
            }
            boolean deviceSupportAntiFake = getViewModel().deviceSupportAntiFake(this.device);
            MaterialButton materialButton = activityDeviceFilterDetailBinding20.btnResetFilter;
            Intrinsics.checkNotNullExpressionValue(materialButton, "btnResetFilter");
            View view2 = materialButton;
            if (!deviceSupportAntiFake && ((device2 = this.device) == null || DeviceKt.isNewBlue(device2) || (device3 = this.device) == null || !DeviceKt.useNewFilterConfig(device3))) {
                z2 = false;
            }
            ViewExtensionsKt.show(view2, z2);
            if (deviceSupportAntiFake) {
                activityDeviceFilterDetailBinding20.btnResetFilter.setIconResource(com.blueair.viewcore.R.drawable.ic_scan_flat);
            }
            activityDeviceFilterDetailBinding20.btnResetFilter.setOnClickListener(new DeviceFilterDetailActivity$$ExternalSyntheticLambda11(deviceSupportAntiFake, this, num));
            Device device8 = this.device;
            if ((device8 != null ? device8.getConnectivityStatus() : null) == ConnectivityStatus.ONLINE) {
                hydrateFilterInfo(num.intValue());
                return;
            }
            ActivityDeviceFilterDetailBinding activityDeviceFilterDetailBinding21 = this.binding;
            if (activityDeviceFilterDetailBinding21 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityDeviceFilterDetailBinding21 = null;
            }
            activityDeviceFilterDetailBinding21.tvProgress.setText(getString(com.blueair.viewcore.R.string.offline_label));
            ActivityDeviceFilterDetailBinding activityDeviceFilterDetailBinding22 = this.binding;
            if (activityDeviceFilterDetailBinding22 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityDeviceFilterDetailBinding22 = null;
            }
            activityDeviceFilterDetailBinding22.progressIndicator.setProgress(0);
            ActivityDeviceFilterDetailBinding activityDeviceFilterDetailBinding23 = this.binding;
            if (activityDeviceFilterDetailBinding23 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityDeviceFilterDetailBinding23 = null;
            }
            AppCompatTextView appCompatTextView2 = activityDeviceFilterDetailBinding23.tvFilterInfo;
            Intrinsics.checkNotNullExpressionValue(appCompatTextView2, "tvFilterInfo");
            ViewExtensionsKt.hide(appCompatTextView2);
            ActivityDeviceFilterDetailBinding activityDeviceFilterDetailBinding24 = this.binding;
            if (activityDeviceFilterDetailBinding24 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityDeviceFilterDetailBinding24 = null;
            }
            View view3 = activityDeviceFilterDetailBinding24.bgFilterInfo;
            Intrinsics.checkNotNullExpressionValue(view3, "bgFilterInfo");
            ViewExtensionsKt.hide(view3);
            ActivityDeviceFilterDetailBinding activityDeviceFilterDetailBinding25 = this.binding;
            if (activityDeviceFilterDetailBinding25 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityDeviceFilterDetailBinding25 = null;
            }
            AppCompatTextView appCompatTextView3 = activityDeviceFilterDetailBinding25.tvChangeFilter;
            Intrinsics.checkNotNullExpressionValue(appCompatTextView3, "tvChangeFilter");
            ViewExtensionsKt.hide(appCompatTextView3);
            ActivityDeviceFilterDetailBinding activityDeviceFilterDetailBinding26 = this.binding;
            if (activityDeviceFilterDetailBinding26 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityDeviceFilterDetailBinding26 = null;
            }
            activityDeviceFilterDetailBinding26.tvProgress.setPadding(0, 0, 0, 0);
            ActivityDeviceFilterDetailBinding activityDeviceFilterDetailBinding27 = this.binding;
            if (activityDeviceFilterDetailBinding27 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityDeviceFilterDetailBinding27 = null;
            }
            activityDeviceFilterDetailBinding27.tvProgress.setBackground((Drawable) null);
            ActivityDeviceFilterDetailBinding activityDeviceFilterDetailBinding28 = this.binding;
            if (activityDeviceFilterDetailBinding28 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                activityDeviceFilterDetailBinding = activityDeviceFilterDetailBinding28;
            }
            activityDeviceFilterDetailBinding.tvProgress.setTextSize(14.0f);
        }
    }

    /* access modifiers changed from: private */
    public static final void hydrateFilterLife$lambda$19$lambda$18$lambda$17(boolean z, DeviceFilterDetailActivity deviceFilterDetailActivity, Integer num, View view) {
        DeviceFilterDetailActivity deviceFilterDetailActivity2 = deviceFilterDetailActivity;
        if (z) {
            Device device2 = deviceFilterDetailActivity2.device;
            Intrinsics.checkNotNull(device2, "null cannot be cast to non-null type com.blueair.core.model.HasSKU");
            deviceFilterDetailActivity2.startActivity(Actions.INSTANCE.openAntiFakeScanIntent(deviceFilterDetailActivity2, (HasSKU) device2, deviceFilterDetailActivity2.type));
            return;
        }
        Device device3 = deviceFilterDetailActivity2.device;
        if ((device3 != null ? device3.getConnectivityStatus() : null) == ConnectivityStatus.ONLINE) {
            FragmentManager supportFragmentManager = deviceFilterDetailActivity2.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
            Class<ConfirmationDialogLeftAligned> cls = ConfirmationDialogLeftAligned.class;
            Intrinsics.checkNotNullExpressionValue("ConfirmationDialogLeftAligned", "getSimpleName(...)");
            if (!(supportFragmentManager.findFragmentByTag("ConfirmationDialogLeftAligned") instanceof ConfirmationDialogLeftAligned) && !supportFragmentManager.isStateSaved()) {
                ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, deviceFilterDetailActivity2.getResetTitleRes(), (Integer) null, deviceFilterDetailActivity2.getResetMsgRes(num.intValue()), Integer.valueOf(com.blueair.viewcore.R.string.confirm), Integer.valueOf(com.blueair.viewcore.R.string.btn_cancel), false, false, false, false, (String[]) null, (String) null, new DeviceFilterDetailActivity$$ExternalSyntheticLambda12(deviceFilterDetailActivity2), 1888, (Object) null).show(supportFragmentManager, "ConfirmationDialogLeftAligned");
                return;
            }
            return;
        }
        deviceFilterDetailActivity2.showDeviceOfflinePrompt();
    }

    /* access modifiers changed from: private */
    public static final Unit hydrateFilterLife$lambda$19$lambda$18$lambda$17$lambda$16$lambda$15(DeviceFilterDetailActivity deviceFilterDetailActivity, boolean z) {
        if (z && deviceFilterDetailActivity.device != null) {
            deviceFilterDetailActivity.showProgress(true);
            DeviceDetailsViewModel viewModel = deviceFilterDetailActivity.getViewModel();
            Device device2 = deviceFilterDetailActivity.device;
            Intrinsics.checkNotNull(device2);
            viewModel.resetFilterLife(device2, deviceFilterDetailActivity.type);
        }
        return Unit.INSTANCE;
    }

    private final int getResetTitleRes() {
        int i = WhenMappings.$EnumSwitchMapping$1[this.type.ordinal()];
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
        int i2 = WhenMappings.$EnumSwitchMapping$1[this.type.ordinal()];
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

    private final void hydrateDeviceFilters() {
        List<FilterInfo> list;
        this.filterAdapter = new FilterTypeAdapter(new DeviceFilterDetailActivity$$ExternalSyntheticLambda0(this), new DeviceFilterDetailActivity$$ExternalSyntheticLambda6(this));
        if (this.device != null) {
            FilterConfig filterConfig2 = this.filterConfig;
            if (filterConfig2 == null || (list = filterConfig2.getFilters()) == null) {
                list = CollectionsKt.emptyList();
            }
            if (!list.isEmpty()) {
                FilterTypeAdapter filterTypeAdapter = this.filterAdapter;
                if (filterTypeAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("filterAdapter");
                    filterTypeAdapter = null;
                }
                filterTypeAdapter.setFilters(list);
                ActivityDeviceFilterDetailBinding activityDeviceFilterDetailBinding = this.binding;
                if (activityDeviceFilterDetailBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    activityDeviceFilterDetailBinding = null;
                }
                MaterialButton materialButton = activityDeviceFilterDetailBinding.btnVisit;
                Intrinsics.checkNotNullExpressionValue(materialButton, "btnVisit");
                ViewExtensionsKt.show(materialButton, !this.hasBuyFilterLink);
                activityDeviceFilterDetailBinding.btnVisit.setOnClickListener(new DeviceFilterDetailActivity$$ExternalSyntheticLambda7(this));
                RecyclerView recyclerView = activityDeviceFilterDetailBinding.filterList;
                FilterTypeAdapter filterTypeAdapter2 = this.filterAdapter;
                if (filterTypeAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("filterAdapter");
                    filterTypeAdapter2 = null;
                }
                recyclerView.setAdapter(filterTypeAdapter2);
                TextView textView = activityDeviceFilterDetailBinding.availableFilters;
                Intrinsics.checkNotNullExpressionValue(textView, "availableFilters");
                ViewExtensionsKt.show$default(textView, false, 1, (Object) null);
                RecyclerView recyclerView2 = activityDeviceFilterDetailBinding.filterList;
                Intrinsics.checkNotNullExpressionValue(recyclerView2, "filterList");
                ViewExtensionsKt.show$default(recyclerView2, false, 1, (Object) null);
            }
        }
    }

    /* access modifiers changed from: private */
    public static final Unit hydrateDeviceFilters$lambda$21(DeviceFilterDetailActivity deviceFilterDetailActivity, FilterInfo filterInfo) {
        FilterInfo filterInfo2 = filterInfo;
        Intrinsics.checkNotNullParameter(filterInfo2, NotificationService.ACTION_TYPE_FILTER);
        FragmentManager supportFragmentManager = deviceFilterDetailActivity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        Class<ConfirmationDialogLeftAligned> cls = ConfirmationDialogLeftAligned.class;
        Intrinsics.checkNotNullExpressionValue("ConfirmationDialogLeftAligned", "getSimpleName(...)");
        if (!(supportFragmentManager.findFragmentByTag("ConfirmationDialogLeftAligned") instanceof ConfirmationDialogLeftAligned) && !supportFragmentManager.isStateSaved()) {
            ConfirmationDialogLeftAligned.Companion companion = ConfirmationDialogLeftAligned.Companion;
            int summary = filterInfo2.getSummary();
            Integer valueOf = Integer.valueOf(com.blueair.viewcore.R.string.confirmation_positive_default);
            String value$default = I18nConfig.getValue$default(filterInfo2.getName(), (Locale) null, 1, (Object) null);
            if (value$default == null) {
                value$default = "";
            }
            ConfirmationDialogLeftAligned.Companion.newInstance$default(companion, 0, (Integer) null, summary, valueOf, (Integer) null, false, false, false, false, (String[]) null, deviceFilterDetailActivity.replaceNewline(value$default), (Function1) null, 2912, (Object) null).show(supportFragmentManager, "ConfirmationDialogLeftAligned");
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit hydrateDeviceFilters$lambda$23(DeviceFilterDetailActivity deviceFilterDetailActivity, int i, FilterInfo filterInfo) {
        Intrinsics.checkNotNullParameter(filterInfo, NotificationService.ACTION_TYPE_FILTER);
        if (deviceFilterDetailActivity.hasBuyFilterLink) {
            FragmentManager supportFragmentManager = deviceFilterDetailActivity.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
            Class<BuyFilterV2DialogFragment> cls = BuyFilterV2DialogFragment.class;
            Intrinsics.checkNotNullExpressionValue("BuyFilterV2DialogFragment", "getSimpleName(...)");
            if (!(supportFragmentManager.findFragmentByTag("BuyFilterV2DialogFragment") instanceof BuyFilterV2DialogFragment) && !supportFragmentManager.isStateSaved()) {
                BuyFilterV2DialogFragment.Companion.newInstance(deviceFilterDetailActivity.device, deviceFilterDetailActivity.deviceSku, deviceFilterDetailActivity.type, deviceFilterDetailActivity.fromNotification, I18nConfig.getValue$default(filterInfo.getName(), (Locale) null, 1, (Object) null)).show(supportFragmentManager, "BuyFilterV2DialogFragment");
            }
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final void hydrateDeviceFilters$lambda$26$lambda$25$lambda$24(DeviceFilterDetailActivity deviceFilterDetailActivity, View view) {
        Intent putExtra = new Intent("blueair.action.info").putExtra(InfoActivity.DISPLAY_KEY, 9).putExtra(InfoActivity.TOOLBAR_TITLE_KEY, deviceFilterDetailActivity.getString(com.blueair.viewcore.R.string.app_name));
        Intrinsics.checkNotNullExpressionValue(putExtra, "putExtra(...)");
        deviceFilterDetailActivity.startActivity(putExtra);
    }

    private final String replaceNewline(String str) {
        return new Regex("\\s*\\R\\s*").replace((CharSequence) str, " ");
    }

    private final void hydrateResetFilterCard() {
        boolean z;
        DeviceConfigProvider deviceConfigProvider = DeviceConfigProvider.INSTANCE;
        FilterConfig filterConfig2 = this.filterConfig;
        ActivityDeviceFilterDetailBinding activityDeviceFilterDetailBinding = null;
        String awsLinkValue = deviceConfigProvider.getAwsLinkValue(filterConfig2 != null ? filterConfig2.getVideo() : null);
        FilterConfig filterConfig3 = this.filterConfig;
        Integer valueOf = filterConfig3 != null ? Integer.valueOf(filterConfig3.getVideoThumbnail()) : null;
        boolean z2 = false;
        if (awsLinkValue == null || valueOf == null) {
            ActivityDeviceFilterDetailBinding activityDeviceFilterDetailBinding2 = this.binding;
            if (activityDeviceFilterDetailBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityDeviceFilterDetailBinding2 = null;
            }
            ShapeableImageView shapeableImageView = activityDeviceFilterDetailBinding2.videoThumbnail;
            Intrinsics.checkNotNullExpressionValue(shapeableImageView, "videoThumbnail");
            ViewExtensionsKt.hide(shapeableImageView);
            ActivityDeviceFilterDetailBinding activityDeviceFilterDetailBinding3 = this.binding;
            if (activityDeviceFilterDetailBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityDeviceFilterDetailBinding3 = null;
            }
            ImageView imageView = activityDeviceFilterDetailBinding3.iconPlay;
            Intrinsics.checkNotNullExpressionValue(imageView, "iconPlay");
            ViewExtensionsKt.hide(imageView);
            z = true;
        } else {
            ActivityDeviceFilterDetailBinding activityDeviceFilterDetailBinding4 = this.binding;
            if (activityDeviceFilterDetailBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityDeviceFilterDetailBinding4 = null;
            }
            activityDeviceFilterDetailBinding4.videoThumbnail.setImageResource(valueOf.intValue());
            ActivityDeviceFilterDetailBinding activityDeviceFilterDetailBinding5 = this.binding;
            if (activityDeviceFilterDetailBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityDeviceFilterDetailBinding5 = null;
            }
            activityDeviceFilterDetailBinding5.videoThumbnail.setOnClickListener(new DeviceFilterDetailActivity$$ExternalSyntheticLambda14(this, awsLinkValue));
            z = false;
        }
        if (DeviceConfigProvider.INSTANCE.getUserManual(getSku()) != null || !z) {
            ActivityDeviceFilterDetailBinding activityDeviceFilterDetailBinding6 = this.binding;
            if (activityDeviceFilterDetailBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityDeviceFilterDetailBinding6 = null;
            }
            Group group = activityDeviceFilterDetailBinding6.groupUserManual;
            Intrinsics.checkNotNullExpressionValue(group, "groupUserManual");
            ViewExtensionsKt.show$default(group, false, 1, (Object) null);
        } else {
            ActivityDeviceFilterDetailBinding activityDeviceFilterDetailBinding7 = this.binding;
            if (activityDeviceFilterDetailBinding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityDeviceFilterDetailBinding7 = null;
            }
            Group group2 = activityDeviceFilterDetailBinding7.groupUserManual;
            Intrinsics.checkNotNullExpressionValue(group2, "groupUserManual");
            ViewExtensionsKt.hide(group2);
            z2 = z;
        }
        if (z2) {
            ActivityDeviceFilterDetailBinding activityDeviceFilterDetailBinding8 = this.binding;
            if (activityDeviceFilterDetailBinding8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityDeviceFilterDetailBinding8 = null;
            }
            ShadowLayout shadowLayout = activityDeviceFilterDetailBinding8.cvReplaceFilter;
            Intrinsics.checkNotNullExpressionValue(shadowLayout, "cvReplaceFilter");
            ViewExtensionsKt.hide(shadowLayout);
        }
        int i = WhenMappings.$EnumSwitchMapping$1[this.type.ordinal()];
        if (i == 2) {
            ActivityDeviceFilterDetailBinding activityDeviceFilterDetailBinding9 = this.binding;
            if (activityDeviceFilterDetailBinding9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                activityDeviceFilterDetailBinding = activityDeviceFilterDetailBinding9;
            }
            activityDeviceFilterDetailBinding.tvHowReplace.setText(com.blueair.viewcore.R.string.how_to_replace_your_wick_filter);
        } else if (i != 3) {
            ActivityDeviceFilterDetailBinding activityDeviceFilterDetailBinding10 = this.binding;
            if (activityDeviceFilterDetailBinding10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                activityDeviceFilterDetailBinding = activityDeviceFilterDetailBinding10;
            }
            activityDeviceFilterDetailBinding.tvHowReplace.setText(com.blueair.viewcore.R.string.how_to_replace_your_filter);
        } else {
            ActivityDeviceFilterDetailBinding activityDeviceFilterDetailBinding11 = this.binding;
            if (activityDeviceFilterDetailBinding11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                activityDeviceFilterDetailBinding = activityDeviceFilterDetailBinding11;
            }
            activityDeviceFilterDetailBinding.tvHowReplace.setText(com.blueair.viewcore.R.string.how_to_replace_your_refresher);
        }
    }

    /* access modifiers changed from: private */
    public static final void hydrateResetFilterCard$lambda$27(DeviceFilterDetailActivity deviceFilterDetailActivity, String str, View view) {
        FilterVideoActivity.Companion.launch(deviceFilterDetailActivity, str);
    }

    private final void hydrateFilterInfo(int i) {
        String str;
        String str2;
        int i2;
        int i3;
        ActivityDeviceFilterDetailBinding activityDeviceFilterDetailBinding = this.binding;
        if (activityDeviceFilterDetailBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityDeviceFilterDetailBinding = null;
        }
        activityDeviceFilterDetailBinding.tvProgress.setText(getString(com.blueair.viewcore.R.string.percentage_left, new Object[]{Integer.valueOf(i)}));
        ActivityDeviceFilterDetailBinding activityDeviceFilterDetailBinding2 = this.binding;
        if (activityDeviceFilterDetailBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityDeviceFilterDetailBinding2 = null;
        }
        activityDeviceFilterDetailBinding2.progressIndicator.setProgress(i);
        if (i > 10) {
            ActivityDeviceFilterDetailBinding activityDeviceFilterDetailBinding3 = this.binding;
            if (activityDeviceFilterDetailBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityDeviceFilterDetailBinding3 = null;
            }
            activityDeviceFilterDetailBinding3.tvProgress.setPadding(0, 0, 0, 0);
            ActivityDeviceFilterDetailBinding activityDeviceFilterDetailBinding4 = this.binding;
            if (activityDeviceFilterDetailBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityDeviceFilterDetailBinding4 = null;
            }
            activityDeviceFilterDetailBinding4.tvProgress.setBackground((Drawable) null);
            ActivityDeviceFilterDetailBinding activityDeviceFilterDetailBinding5 = this.binding;
            if (activityDeviceFilterDetailBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityDeviceFilterDetailBinding5 = null;
            }
            activityDeviceFilterDetailBinding5.tvProgress.setTextSize(14.0f);
            ActivityDeviceFilterDetailBinding activityDeviceFilterDetailBinding6 = this.binding;
            if (activityDeviceFilterDetailBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityDeviceFilterDetailBinding6 = null;
            }
            activityDeviceFilterDetailBinding6.bgFilterInfo.setBackgroundResource(com.blueair.viewcore.R.drawable.rounded_rectangle_dark_5_r16);
            ActivityDeviceFilterDetailBinding activityDeviceFilterDetailBinding7 = this.binding;
            if (activityDeviceFilterDetailBinding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityDeviceFilterDetailBinding7 = null;
            }
            activityDeviceFilterDetailBinding7.progressIndicator.setIndicatorColor(getColor(com.blueair.viewcore.R.color.colorPrimary));
            ActivityDeviceFilterDetailBinding activityDeviceFilterDetailBinding8 = this.binding;
            if (activityDeviceFilterDetailBinding8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityDeviceFilterDetailBinding8 = null;
            }
            AppCompatTextView appCompatTextView = activityDeviceFilterDetailBinding8.tvChangeFilter;
            Intrinsics.checkNotNullExpressionValue(appCompatTextView, "tvChangeFilter");
            ViewExtensionsKt.hide(appCompatTextView);
            Set of = SetsKt.setOf(DeviceType.Blue40.INSTANCE, DeviceType.Dehumidifier.INSTANCE, DeviceType.MiniRestful.INSTANCE, DeviceType.Combo2in120.INSTANCE, DeviceType.Pet20.INSTANCE);
            ActivityDeviceFilterDetailBinding activityDeviceFilterDetailBinding9 = this.binding;
            if (activityDeviceFilterDetailBinding9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityDeviceFilterDetailBinding9 = null;
            }
            AppCompatTextView appCompatTextView2 = activityDeviceFilterDetailBinding9.tvFilterInfo;
            int i4 = WhenMappings.$EnumSwitchMapping$1[this.type.ordinal()];
            if (i4 == 1) {
                if (of.contains(DeviceType.Companion.fromSkuCompat(getSku()))) {
                    i2 = com.blueair.viewcore.R.string.change_filter_recommend_v2;
                } else {
                    i2 = com.blueair.viewcore.R.string.change_filter_recommend;
                }
                str2 = getString(i2);
            } else if (i4 == 2) {
                if (this.device instanceof DeviceHumidifier) {
                    i3 = com.blueair.viewcore.R.string.change_wick_filter_recommend_v2;
                } else {
                    i3 = com.blueair.viewcore.R.string.change_wick_filter_recommend;
                }
                str2 = getString(i3);
            } else if (i4 == 3) {
                str2 = getString(com.blueair.viewcore.R.string.change_refresher_recommend);
            } else {
                throw new NoWhenBranchMatchedException();
            }
            appCompatTextView2.setText(str2);
        } else {
            int dpToPx = (int) TypedValueCompat.dpToPx(8.0f, getResources().getDisplayMetrics());
            ActivityDeviceFilterDetailBinding activityDeviceFilterDetailBinding10 = this.binding;
            if (activityDeviceFilterDetailBinding10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityDeviceFilterDetailBinding10 = null;
            }
            int i5 = dpToPx / 2;
            activityDeviceFilterDetailBinding10.tvProgress.setPadding(dpToPx, i5, dpToPx, i5);
            ActivityDeviceFilterDetailBinding activityDeviceFilterDetailBinding11 = this.binding;
            if (activityDeviceFilterDetailBinding11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityDeviceFilterDetailBinding11 = null;
            }
            activityDeviceFilterDetailBinding11.tvProgress.setBackgroundResource(com.blueair.viewcore.R.drawable.rounded_rectangle_warning_r8);
            ActivityDeviceFilterDetailBinding activityDeviceFilterDetailBinding12 = this.binding;
            if (activityDeviceFilterDetailBinding12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityDeviceFilterDetailBinding12 = null;
            }
            activityDeviceFilterDetailBinding12.tvProgress.setTextSize(12.0f);
            ActivityDeviceFilterDetailBinding activityDeviceFilterDetailBinding13 = this.binding;
            if (activityDeviceFilterDetailBinding13 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityDeviceFilterDetailBinding13 = null;
            }
            activityDeviceFilterDetailBinding13.bgFilterInfo.setBackgroundResource(com.blueair.viewcore.R.drawable.rounded_rectangle_warning_r16);
            ActivityDeviceFilterDetailBinding activityDeviceFilterDetailBinding14 = this.binding;
            if (activityDeviceFilterDetailBinding14 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityDeviceFilterDetailBinding14 = null;
            }
            activityDeviceFilterDetailBinding14.progressIndicator.setIndicatorColor(getColor(com.blueair.viewcore.R.color.fill_warning));
            ActivityDeviceFilterDetailBinding activityDeviceFilterDetailBinding15 = this.binding;
            if (activityDeviceFilterDetailBinding15 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityDeviceFilterDetailBinding15 = null;
            }
            AppCompatTextView appCompatTextView3 = activityDeviceFilterDetailBinding15.tvChangeFilter;
            Intrinsics.checkNotNullExpressionValue(appCompatTextView3, "tvChangeFilter");
            ViewExtensionsKt.show$default(appCompatTextView3, false, 1, (Object) null);
            ActivityDeviceFilterDetailBinding activityDeviceFilterDetailBinding16 = this.binding;
            if (activityDeviceFilterDetailBinding16 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityDeviceFilterDetailBinding16 = null;
            }
            AppCompatTextView appCompatTextView4 = activityDeviceFilterDetailBinding16.tvFilterInfo;
            int i6 = WhenMappings.$EnumSwitchMapping$1[this.type.ordinal()];
            if (i6 != 1) {
                if (i6 != 2) {
                    if (i6 == 3) {
                        str = i > 0 ? getString(com.blueair.viewcore.R.string.change_refresher_warning, new Object[]{Integer.valueOf(i)}) : getString(com.blueair.viewcore.R.string.change_refresher_expired);
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                } else if (i > 0) {
                    str = getString(com.blueair.viewcore.R.string.change_wick_filter_warning, new Object[]{Integer.valueOf(i)});
                } else {
                    str = getString(com.blueair.viewcore.R.string.change_wick_filter_expired);
                }
            } else if (i > 0) {
                str = getString(com.blueair.viewcore.R.string.change_filter_warning, new Object[]{Integer.valueOf(i)});
            } else {
                Device device2 = this.device;
                str = getString((device2 == null || !DeviceKt.isAfterG4(device2)) ? com.blueair.viewcore.R.string.change_filter_expired_v2 : com.blueair.viewcore.R.string.change_filter_expired);
            }
            appCompatTextView4.setText(str);
        }
        ActivityDeviceFilterDetailBinding activityDeviceFilterDetailBinding17 = this.binding;
        if (activityDeviceFilterDetailBinding17 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityDeviceFilterDetailBinding17 = null;
        }
        AppCompatTextView appCompatTextView5 = activityDeviceFilterDetailBinding17.tvFilterInfo;
        Intrinsics.checkNotNullExpressionValue(appCompatTextView5, "tvFilterInfo");
        ViewExtensionsKt.show$default(appCompatTextView5, false, 1, (Object) null);
        ActivityDeviceFilterDetailBinding activityDeviceFilterDetailBinding18 = this.binding;
        if (activityDeviceFilterDetailBinding18 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityDeviceFilterDetailBinding18 = null;
        }
        View view = activityDeviceFilterDetailBinding18.bgFilterInfo;
        Intrinsics.checkNotNullExpressionValue(view, "bgFilterInfo");
        ViewExtensionsKt.show$default(view, false, 1, (Object) null);
    }

    private final void showDeviceOfflinePrompt() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        if (!(supportFragmentManager.findFragmentByTag("DEVICE_OFFLINE") instanceof ConfirmationDialogLeftAligned) && !supportFragmentManager.isStateSaved()) {
            ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, com.blueair.viewcore.R.string.offline_title_device, (Integer) null, com.blueair.viewcore.R.string.offline_subtitle, Integer.valueOf(com.blueair.viewcore.R.string.snackbar_ok), (Integer) null, false, false, false, false, (String[]) null, (String) null, (Function1) null, 4064, (Object) null).show(supportFragmentManager, "DEVICE_OFFLINE");
        }
    }

    public final void showProgress(boolean z) {
        ActivityDeviceFilterDetailBinding activityDeviceFilterDetailBinding = this.binding;
        if (activityDeviceFilterDetailBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityDeviceFilterDetailBinding = null;
        }
        ProgressBlockerView progressBlockerView = activityDeviceFilterDetailBinding.progressView;
        Intrinsics.checkNotNullExpressionValue(progressBlockerView, "progressView");
        ViewExtensionsKt.show(progressBlockerView, z);
    }
}
