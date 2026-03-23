package com.blueair.adddevice.activity;

import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModelLazy;
import com.blueair.adddevice.databinding.ActivityAddDeviceBinding;
import com.blueair.adddevice.databinding.ViewcoreAppbarBinding;
import com.blueair.adddevice.viewmodel.AddDeviceAction;
import com.blueair.adddevice.viewmodel.AddDeviceScreen;
import com.blueair.adddevice.viewmodel.AddDeviceViewModel;
import com.blueair.bluetooth.service.BluetoothConnectivityService;
import com.blueair.bluetooth.utils.BluetoothConnectivityBroadcastReceiver;
import com.blueair.bluetooth.utils.BluetoothUtils;
import com.blueair.core.model.AmplitudeEvent;
import com.blueair.core.model.AnalyticEvent;
import com.blueair.core.model.BluetoothDevice;
import com.blueair.core.model.Device;
import com.blueair.core.model.StartOnboardingHelpGuideEvent;
import com.blueair.viewcore.Header;
import com.blueair.viewcore.R;
import com.blueair.viewcore.ViewCoreAppbar;
import com.blueair.viewcore.activity.Actions;
import com.blueair.viewcore.activity.BaseActivity;
import com.blueair.viewcore.activity.BaseLokaliseActivity;
import com.blueair.viewcore.dialog.ConfirmationDialogLeftAligned;
import com.blueair.viewcore.dialog.TroubleshootingDialog;
import com.blueair.viewcore.extensions.FragmentExtensionsKt;
import com.google.android.material.progressindicator.LinearProgressIndicator;
import com.jacquessmuts.rxextensions.RxExtensionsKt;
import io.flatcircle.livedatahelper.LiveDataExtensionsKt;
import io.flatcircle.viewhelper.ViewHelperUtil;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.kodein.di.DIAwareKt;
import org.kodein.type.GenericJVMTypeTokenDelegate;
import org.kodein.type.JVMTypeToken;
import org.kodein.type.TypeTokensJVMKt;
import timber.log.Timber;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001NB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u000105H\u0014J\u0010\u00106\u001a\u0002032\u0006\u00107\u001a\u000205H\u0014J\b\u00108\u001a\u000203H\u0002J\b\u00109\u001a\u000203H\u0002J\b\u0010:\u001a\u000203H\u0002J\b\u0010;\u001a\u000203H\u0002J\b\u0010<\u001a\u000203H\u0014J\b\u0010=\u001a\u000203H\u0014J\b\u0010>\u001a\u000203H\u0014J\b\u0010?\u001a\u000203H\u0016J\b\u0010@\u001a\u000203H\u0017J\u0010\u0010A\u001a\u0002032\u0006\u0010B\u001a\u00020,H\u0002J\b\u0010C\u001a\u000203H\u0002J\b\u0010D\u001a\u000203H\u0002J\b\u0010E\u001a\u000203H\u0002J \u0010F\u001a\u0002032\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020H2\u0006\u0010J\u001a\u00020HH\u0002J\u0010\u0010K\u001a\u00020\"2\u0006\u0010L\u001a\u00020MH\u0002R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\u00148VX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00148VX\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u001a8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u001e8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u001b\u0010!\u001a\u00020\"8BX\u0002¢\u0006\f\n\u0004\b%\u0010\u0010\u001a\u0004\b#\u0010$R\u001b\u0010&\u001a\u00020'8BX\u0002¢\u0006\f\n\u0004\b*\u0010\u0010\u001a\u0004\b(\u0010)R\u000e\u0010+\u001a\u00020,X\u000e¢\u0006\u0002\n\u0000R!\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00140.8VX\u0002¢\u0006\f\n\u0004\b1\u0010\u0010\u001a\u0004\b/\u00100¨\u0006O²\u0006\n\u0010P\u001a\u00020QX\u0002"}, d2 = {"Lcom/blueair/adddevice/activity/AddBluetoothDeviceActivity;", "Lcom/blueair/viewcore/activity/BaseActivity;", "Lcom/blueair/viewcore/ViewCoreAppbar;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "addDeviceBinding", "Lcom/blueair/adddevice/databinding/ActivityAddDeviceBinding;", "viewModel", "Lcom/blueair/adddevice/viewmodel/AddDeviceViewModel;", "getViewModel", "()Lcom/blueair/adddevice/viewmodel/AddDeviceViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "helpButtonsState", "Lcom/blueair/adddevice/activity/AddBluetoothDeviceActivity$HelpButtonsState;", "headerTitle", "Landroid/widget/TextView;", "getHeaderTitle", "()Landroid/widget/TextView;", "headerMsg", "getHeaderMsg", "progressIndicator", "Lcom/google/android/material/progressindicator/LinearProgressIndicator;", "getProgressIndicator", "()Lcom/google/android/material/progressindicator/LinearProgressIndicator;", "actionBar", "Landroidx/appcompat/app/ActionBar;", "getActionBar", "()Landroidx/appcompat/app/ActionBar;", "bluetoothScanHeader", "Lcom/blueair/viewcore/Header;", "getBluetoothScanHeader", "()Lcom/blueair/viewcore/Header;", "bluetoothScanHeader$delegate", "networkBroadcastReceiver", "Lcom/blueair/bluetooth/utils/BluetoothConnectivityBroadcastReceiver;", "getNetworkBroadcastReceiver", "()Lcom/blueair/bluetooth/utils/BluetoothConnectivityBroadcastReceiver;", "networkBroadcastReceiver$delegate", "currentScreen", "Lcom/blueair/adddevice/viewmodel/AddDeviceScreen;", "onboardingSteps", "", "getOnboardingSteps", "()Ljava/util/List;", "onboardingSteps$delegate", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onSaveInstanceState", "outState", "setupEndButton", "bindViewModel", "observeViewModel", "setBluetoothScanHeader", "onResume", "onPause", "onDestroy", "finish", "onBackPressed", "goForwardToScreen", "nextScreen", "goBackOneScreen", "restartScreens", "showConnectionLost", "setHelpButtonsVisibility", "isHelpVisible", "", "isCustomerSupportVisible", "isTroubleshootingVisible", "deviceSetupHeader", "stepOrdinal", "", "HelpButtonsState", "adddevice_otherRelease", "connectionService", "Lcom/blueair/bluetooth/service/BluetoothConnectivityService;"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: AddBluetoothDeviceActivity.kt */
public final class AddBluetoothDeviceActivity extends BaseActivity implements ViewCoreAppbar {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property0(new PropertyReference0Impl(AddBluetoothDeviceActivity.class, "connectionService", "<v#0>", 0))};
    private ActivityAddDeviceBinding addDeviceBinding;
    private final Lazy bluetoothScanHeader$delegate;
    private AddDeviceScreen currentScreen;
    private HelpButtonsState helpButtonsState;
    private final Lazy networkBroadcastReceiver$delegate;
    private final Lazy onboardingSteps$delegate;
    private final String screenName = AnalyticEvent.ScreenViewEvent.ADD_DEVICE;
    private final Lazy viewModel$delegate;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AddBluetoothDeviceActivity.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        /* JADX WARNING: Can't wrap try/catch for region: R(17:0|(2:1|2)|3|5|6|7|8|9|10|(2:11|12)|13|15|16|17|18|19|21) */
        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|(2:1|2)|3|5|6|7|8|9|10|11|12|13|15|16|17|18|19|21) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0045 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0022 */
        static {
            /*
                com.blueair.adddevice.viewmodel.AddDeviceScreen[] r0 = com.blueair.adddevice.viewmodel.AddDeviceScreen.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                r1 = 1
                com.blueair.adddevice.viewmodel.AddDeviceScreen r2 = com.blueair.adddevice.viewmodel.AddDeviceScreen.ChooseDevice     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                r2 = 2
                com.blueair.adddevice.viewmodel.AddDeviceScreen r3 = com.blueair.adddevice.viewmodel.AddDeviceScreen.Success     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.blueair.adddevice.viewmodel.AddDeviceScreen r3 = com.blueair.adddevice.viewmodel.AddDeviceScreen.WifiList     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r4 = 3
                r0[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.blueair.adddevice.viewmodel.AddDeviceScreen r3 = com.blueair.adddevice.viewmodel.AddDeviceScreen.WifiPassword     // Catch:{ NoSuchFieldError -> 0x002b }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r4 = 4
                r0[r3] = r4     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                com.blueair.adddevice.viewmodel.AddDeviceScreen r3 = com.blueair.adddevice.viewmodel.AddDeviceScreen.EnterDeviceName     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r4 = 5
                r0[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                $EnumSwitchMapping$0 = r0
                com.blueair.adddevice.viewmodel.AddDeviceAction[] r0 = com.blueair.adddevice.viewmodel.AddDeviceAction.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.blueair.adddevice.viewmodel.AddDeviceAction r3 = com.blueair.adddevice.viewmodel.AddDeviceAction.Restart     // Catch:{ NoSuchFieldError -> 0x0045 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0045 }
                r0[r3] = r1     // Catch:{ NoSuchFieldError -> 0x0045 }
            L_0x0045:
                com.blueair.adddevice.viewmodel.AddDeviceAction r1 = com.blueair.adddevice.viewmodel.AddDeviceAction.ShowConnectionLost     // Catch:{ NoSuchFieldError -> 0x004d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004d }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004d }
            L_0x004d:
                $EnumSwitchMapping$1 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.adddevice.activity.AddBluetoothDeviceActivity.WhenMappings.<clinit>():void");
        }
    }

    public AddBluetoothDeviceActivity() {
        ComponentActivity componentActivity = this;
        this.viewModel$delegate = new ViewModelLazy(Reflection.getOrCreateKotlinClass(AddDeviceViewModel.class), new AddBluetoothDeviceActivity$special$$inlined$viewModels$default$2(componentActivity), new AddBluetoothDeviceActivity$special$$inlined$viewModels$default$1(componentActivity), new AddBluetoothDeviceActivity$special$$inlined$viewModels$default$3((Function0) null, componentActivity));
        this.helpButtonsState = HelpButtonsState.Irrelevant;
        this.bluetoothScanHeader$delegate = LazyKt.lazy(new AddBluetoothDeviceActivity$$ExternalSyntheticLambda13(this));
        this.networkBroadcastReceiver$delegate = LazyKt.lazy(new AddBluetoothDeviceActivity$$ExternalSyntheticLambda1(this));
        this.currentScreen = AddDeviceScreen.ChooseDevice;
        this.onboardingSteps$delegate = LazyKt.lazy(new AddBluetoothDeviceActivity$$ExternalSyntheticLambda2(this));
    }

    public void setHeader(Header header) {
        ViewCoreAppbar.CC.$default$setHeader(this, header);
    }

    /* access modifiers changed from: protected */
    public String getScreenName() {
        return this.screenName;
    }

    private final AddDeviceViewModel getViewModel() {
        return (AddDeviceViewModel) this.viewModel$delegate.getValue();
    }

    public TextView getHeaderTitle() {
        ActivityAddDeviceBinding activityAddDeviceBinding = this.addDeviceBinding;
        if (activityAddDeviceBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addDeviceBinding");
            activityAddDeviceBinding = null;
        }
        AppCompatTextView appCompatTextView = activityAddDeviceBinding.viewcoreAppbar.headerTitle;
        Intrinsics.checkNotNullExpressionValue(appCompatTextView, "headerTitle");
        return appCompatTextView;
    }

    public TextView getHeaderMsg() {
        ActivityAddDeviceBinding activityAddDeviceBinding = this.addDeviceBinding;
        if (activityAddDeviceBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addDeviceBinding");
            activityAddDeviceBinding = null;
        }
        AppCompatTextView appCompatTextView = activityAddDeviceBinding.viewcoreAppbar.headerMsg;
        Intrinsics.checkNotNullExpressionValue(appCompatTextView, "headerMsg");
        return appCompatTextView;
    }

    public LinearProgressIndicator getProgressIndicator() {
        ActivityAddDeviceBinding activityAddDeviceBinding = this.addDeviceBinding;
        if (activityAddDeviceBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addDeviceBinding");
            activityAddDeviceBinding = null;
        }
        LinearProgressIndicator linearProgressIndicator = activityAddDeviceBinding.viewcoreAppbar.progressIndicator;
        Intrinsics.checkNotNullExpressionValue(linearProgressIndicator, "progressIndicator");
        return linearProgressIndicator;
    }

    public ActionBar getActionBar() {
        return getSupportActionBar();
    }

    private final Header getBluetoothScanHeader() {
        return (Header) this.bluetoothScanHeader$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final Header bluetoothScanHeader_delegate$lambda$0(AddBluetoothDeviceActivity addBluetoothDeviceActivity) {
        String string = addBluetoothDeviceActivity.getResources().getString(R.string.your_devices_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = addBluetoothDeviceActivity.getResources().getString(R.string.get_started_subtitle);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        return new Header(string, string2, Integer.valueOf(R.drawable.ic_arrow_back_white), 1);
    }

    private final BluetoothConnectivityBroadcastReceiver getNetworkBroadcastReceiver() {
        return (BluetoothConnectivityBroadcastReceiver) this.networkBroadcastReceiver$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final BluetoothConnectivityBroadcastReceiver networkBroadcastReceiver_delegate$lambda$2(AddBluetoothDeviceActivity addBluetoothDeviceActivity) {
        JVMTypeToken<?> typeToken = TypeTokensJVMKt.typeToken(new AddBluetoothDeviceActivity$networkBroadcastReceiver_delegate$lambda$2$$inlined$instance$default$1().getSuperType());
        Intrinsics.checkNotNull(typeToken, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        Lazy<Object> provideDelegate = DIAwareKt.Instance(addBluetoothDeviceActivity, new GenericJVMTypeTokenDelegate(typeToken, BluetoothConnectivityService.class), (Object) null).provideDelegate((Object) null, $$delegatedProperties[0]);
        networkBroadcastReceiver_delegate$lambda$2$lambda$1(provideDelegate).updateBluetoothConnectivityState(BluetoothUtils.INSTANCE.isBluetoothEnabled(addBluetoothDeviceActivity));
        return new BluetoothConnectivityBroadcastReceiver(networkBroadcastReceiver_delegate$lambda$2$lambda$1(provideDelegate));
    }

    private static final BluetoothConnectivityService networkBroadcastReceiver_delegate$lambda$2$lambda$1(Lazy<BluetoothConnectivityService> lazy) {
        return lazy.getValue();
    }

    public List<TextView> getOnboardingSteps() {
        return (List) this.onboardingSteps$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final List onboardingSteps_delegate$lambda$4(AddBluetoothDeviceActivity addBluetoothDeviceActivity) {
        ActivityAddDeviceBinding activityAddDeviceBinding = addBluetoothDeviceActivity.addDeviceBinding;
        if (activityAddDeviceBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addDeviceBinding");
            activityAddDeviceBinding = null;
        }
        ViewcoreAppbarBinding viewcoreAppbarBinding = activityAddDeviceBinding.viewcoreAppbar;
        return CollectionsKt.emptyList();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        int i;
        super.onCreate(bundle);
        ViewDataBinding contentView = DataBindingUtil.setContentView(this, com.blueair.adddevice.R.layout.activity_add_device);
        Intrinsics.checkNotNullExpressionValue(contentView, "setContentView(...)");
        this.addDeviceBinding = (ActivityAddDeviceBinding) contentView;
        boolean z = false;
        ActivityAddDeviceBinding activityAddDeviceBinding = null;
        BaseLokaliseActivity.immersiveStatusBar$default(this, false, 1, (Object) null);
        setStatusMode(true);
        HelpButtonsState[] values = HelpButtonsState.values();
        if (bundle != null) {
            i = bundle.getInt("KEY_HELP_BUTTONS_STATE", HelpButtonsState.Irrelevant.ordinal());
        } else {
            i = HelpButtonsState.Irrelevant.ordinal();
        }
        HelpButtonsState helpButtonsState2 = values[i];
        this.helpButtonsState = helpButtonsState2;
        if (helpButtonsState2 != HelpButtonsState.Irrelevant) {
            boolean z2 = this.helpButtonsState == HelpButtonsState.HelpVisible;
            boolean z3 = this.helpButtonsState == HelpButtonsState.TroubleshootingAndCustomerSupportVisible;
            if (this.helpButtonsState == HelpButtonsState.TroubleshootingAndCustomerSupportVisible) {
                z = true;
            }
            setHelpButtonsVisibility(z2, z3, z);
        }
        bindViewModel();
        setHeader(getBluetoothScanHeader());
        observeViewModel();
        setupEndButton();
        ActivityAddDeviceBinding activityAddDeviceBinding2 = this.addDeviceBinding;
        if (activityAddDeviceBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addDeviceBinding");
            activityAddDeviceBinding2 = null;
        }
        activityAddDeviceBinding2.viewcoreAppbar.btnBack.setOnClickListener(new AddBluetoothDeviceActivity$$ExternalSyntheticLambda8(this));
        ActivityAddDeviceBinding activityAddDeviceBinding3 = this.addDeviceBinding;
        if (activityAddDeviceBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addDeviceBinding");
            activityAddDeviceBinding3 = null;
        }
        activityAddDeviceBinding3.viewcoreAppbar.btnClose.setOnClickListener(new AddBluetoothDeviceActivity$$ExternalSyntheticLambda9(this));
        ActivityAddDeviceBinding activityAddDeviceBinding4 = this.addDeviceBinding;
        if (activityAddDeviceBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addDeviceBinding");
        } else {
            activityAddDeviceBinding = activityAddDeviceBinding4;
        }
        activityAddDeviceBinding.helpButton.setOnClickListener(new AddBluetoothDeviceActivity$$ExternalSyntheticLambda10(this));
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$5(AddBluetoothDeviceActivity addBluetoothDeviceActivity, View view) {
        addBluetoothDeviceActivity.onBackPressed();
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$8(AddBluetoothDeviceActivity addBluetoothDeviceActivity, View view) {
        AddBluetoothDeviceActivity addBluetoothDeviceActivity2 = addBluetoothDeviceActivity;
        if (addBluetoothDeviceActivity2.currentScreen == AddDeviceScreen.ChooseDevice) {
            addBluetoothDeviceActivity2.startActivity(Actions.INSTANCE.openHomeIntent(addBluetoothDeviceActivity2));
            addBluetoothDeviceActivity2.finish();
            return;
        }
        FragmentManager supportFragmentManager = addBluetoothDeviceActivity2.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        Class<ConfirmationDialogLeftAligned> cls = ConfirmationDialogLeftAligned.class;
        Intrinsics.checkNotNullExpressionValue("ConfirmationDialogLeftAligned", "getSimpleName(...)");
        if (!(supportFragmentManager.findFragmentByTag("ConfirmationDialogLeftAligned") instanceof ConfirmationDialogLeftAligned) && !supportFragmentManager.isStateSaved()) {
            ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, R.string.label_ensure_leave, (Integer) null, R.string.quit_device_setup_confirmation, Integer.valueOf(R.string.action_continue), Integer.valueOf(R.string.action_leave), false, false, false, false, (String[]) null, (String) null, new AddBluetoothDeviceActivity$$ExternalSyntheticLambda4(addBluetoothDeviceActivity2), 1888, (Object) null).show(supportFragmentManager, "ConfirmationDialogLeftAligned");
        }
    }

    /* access modifiers changed from: private */
    public static final Unit onCreate$lambda$8$lambda$7$lambda$6(AddBluetoothDeviceActivity addBluetoothDeviceActivity, boolean z) {
        if (!z) {
            addBluetoothDeviceActivity.startActivity(Actions.INSTANCE.openHomeIntent(addBluetoothDeviceActivity));
            addBluetoothDeviceActivity.finish();
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$11(AddBluetoothDeviceActivity addBluetoothDeviceActivity, View view) {
        addBluetoothDeviceActivity.getAnalytics().amplitudeLog((AmplitudeEvent) StartOnboardingHelpGuideEvent.INSTANCE);
        FragmentManager supportFragmentManager = addBluetoothDeviceActivity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        Class<TroubleshootingDialog> cls = TroubleshootingDialog.class;
        Intrinsics.checkNotNullExpressionValue(TroubleshootingDialog.REQUEST_KEY, "getSimpleName(...)");
        DialogFragment dialogFragment = null;
        if (!(supportFragmentManager.findFragmentByTag(TroubleshootingDialog.REQUEST_KEY) instanceof TroubleshootingDialog) && !supportFragmentManager.isStateSaved()) {
            dialogFragment = TroubleshootingDialog.Companion.newInstance$default(TroubleshootingDialog.Companion, TroubleshootingDialog.ACTION_TYPE_WIFI_GUIDE, (Device) null, 2, (Object) null);
            dialogFragment.show(supportFragmentManager, TroubleshootingDialog.REQUEST_KEY);
        }
        TroubleshootingDialog troubleshootingDialog = (TroubleshootingDialog) dialogFragment;
        if (troubleshootingDialog != null) {
            FragmentExtensionsKt.setFragmentResultListenerWithClear(troubleshootingDialog, TroubleshootingDialog.REQUEST_KEY, new AddBluetoothDeviceActivity$$ExternalSyntheticLambda0(addBluetoothDeviceActivity));
        }
    }

    /* access modifiers changed from: private */
    public static final Unit onCreate$lambda$11$lambda$10(AddBluetoothDeviceActivity addBluetoothDeviceActivity, String str, Bundle bundle) {
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        Intrinsics.checkNotNullParameter(bundle, "result");
        if (bundle.getBoolean(TroubleshootingDialog.ACTION_RETRY) && addBluetoothDeviceActivity.currentScreen == AddDeviceScreen.WifiList) {
            addBluetoothDeviceActivity.getViewModel().refreshSsidsList();
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        bundle.putInt("KEY_HELP_BUTTONS_STATE", this.helpButtonsState.ordinal());
        super.onSaveInstanceState(bundle);
    }

    private final void setupEndButton() {
        ActivityAddDeviceBinding activityAddDeviceBinding = this.addDeviceBinding;
        if (activityAddDeviceBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addDeviceBinding");
            activityAddDeviceBinding = null;
        }
        activityAddDeviceBinding.helpButton.setText(getString(R.string.support_need_help));
    }

    private final void bindViewModel() {
        ActivityAddDeviceBinding activityAddDeviceBinding = this.addDeviceBinding;
        if (activityAddDeviceBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addDeviceBinding");
            activityAddDeviceBinding = null;
        }
        activityAddDeviceBinding.setAddDeviceViewModel(getViewModel());
        activityAddDeviceBinding.setLifecycleOwner(this);
    }

    private final void observeViewModel() {
        LifecycleOwner lifecycleOwner = this;
        LiveDataExtensionsKt.observeNonNull(getViewModel().getCurrentScreen(), lifecycleOwner, new AddBluetoothDeviceActivity$$ExternalSyntheticLambda5(this));
        getViewModel().getLvBlockNavigation().observe(lifecycleOwner, new AddBluetoothDeviceActivityKt$sam$androidx_lifecycle_Observer$0(new AddBluetoothDeviceActivity$$ExternalSyntheticLambda6(this)));
        Transformations.distinctUntilChanged(getViewModel().getLvDeviceScanned()).observe(lifecycleOwner, new AddBluetoothDeviceActivityKt$sam$androidx_lifecycle_Observer$0(new AddBluetoothDeviceActivity$$ExternalSyntheticLambda7(this)));
    }

    /* access modifiers changed from: private */
    public static final Unit observeViewModel$lambda$13(AddBluetoothDeviceActivity addBluetoothDeviceActivity, AddDeviceScreen addDeviceScreen) {
        Intrinsics.checkNotNullParameter(addDeviceScreen, "nextScreen");
        Timber.Forest forest = Timber.Forest;
        forest.d("changing screen to " + addDeviceScreen, new Object[0]);
        int i = WhenMappings.$EnumSwitchMapping$0[addDeviceScreen.ordinal()];
        if (i == 1) {
            addBluetoothDeviceActivity.getViewModel().unbindNetwork(addBluetoothDeviceActivity);
            addBluetoothDeviceActivity.setHeader(addBluetoothDeviceActivity.getBluetoothScanHeader());
        } else if (i == 2) {
            addBluetoothDeviceActivity.getViewModel().unbindNetwork(addBluetoothDeviceActivity);
            addBluetoothDeviceActivity.setHeader(addBluetoothDeviceActivity.deviceSetupHeader(3));
        } else if (i == 3) {
            addBluetoothDeviceActivity.setHeader(addBluetoothDeviceActivity.deviceSetupHeader(2));
        } else if (i == 4) {
            addBluetoothDeviceActivity.setHeader(addBluetoothDeviceActivity.deviceSetupHeader(2));
        } else if (i == 5) {
            addBluetoothDeviceActivity.setHeader(addBluetoothDeviceActivity.deviceSetupHeader(4));
        } else {
            throw new NoWhenBranchMatchedException();
        }
        addBluetoothDeviceActivity.goForwardToScreen(addDeviceScreen);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit observeViewModel$lambda$14(AddBluetoothDeviceActivity addBluetoothDeviceActivity, Boolean bool) {
        ActivityAddDeviceBinding activityAddDeviceBinding = addBluetoothDeviceActivity.addDeviceBinding;
        ActivityAddDeviceBinding activityAddDeviceBinding2 = null;
        if (activityAddDeviceBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addDeviceBinding");
            activityAddDeviceBinding = null;
        }
        activityAddDeviceBinding.viewcoreAppbar.btnBack.setEnabled(!bool.booleanValue());
        ActivityAddDeviceBinding activityAddDeviceBinding3 = addBluetoothDeviceActivity.addDeviceBinding;
        if (activityAddDeviceBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addDeviceBinding");
        } else {
            activityAddDeviceBinding2 = activityAddDeviceBinding3;
        }
        activityAddDeviceBinding2.viewcoreAppbar.btnClose.setEnabled(!bool.booleanValue());
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit observeViewModel$lambda$15(AddBluetoothDeviceActivity addBluetoothDeviceActivity, Boolean bool) {
        if (addBluetoothDeviceActivity.currentScreen == AddDeviceScreen.ChooseDevice) {
            addBluetoothDeviceActivity.setBluetoothScanHeader();
        }
        return Unit.INSTANCE;
    }

    private final void setBluetoothScanHeader() {
        if (Intrinsics.areEqual((Object) getViewModel().getLvDeviceScanned().getValue(), (Object) true)) {
            setHeader(getBluetoothScanHeader());
            return;
        }
        Header bluetoothScanHeader = getBluetoothScanHeader();
        String string = getString(R.string.add_device);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        setHeader(Header.copy$default(bluetoothScanHeader, string, "", (Integer) null, (Integer) null, 12, (Object) null));
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        registerReceiver(getNetworkBroadcastReceiver(), new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED"));
        if (!getViewModel().isUserLoggedIn()) {
            finish();
        }
        CompositeDisposable rxSubs = getRxSubs();
        Observable filterRapidClicks = RxExtensionsKt.filterRapidClicks(getViewModel().getActionPublisher());
        Intrinsics.checkNotNullExpressionValue(filterRapidClicks, "filterRapidClicks(...)");
        rxSubs.add(RxExtensionsKt.subscribeAndLogE(filterRapidClicks, new AddBluetoothDeviceActivity$$ExternalSyntheticLambda3(this)));
    }

    /* access modifiers changed from: private */
    public static final Unit onResume$lambda$16(AddBluetoothDeviceActivity addBluetoothDeviceActivity, AddDeviceAction addDeviceAction) {
        Intrinsics.checkNotNullParameter(addDeviceAction, "action");
        int i = WhenMappings.$EnumSwitchMapping$1[addDeviceAction.ordinal()];
        if (i == 1) {
            addBluetoothDeviceActivity.restartScreens();
        } else if (i == 2) {
            addBluetoothDeviceActivity.showConnectionLost();
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        unregisterReceiver(getNetworkBroadcastReceiver());
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        getViewModel().unbindNetwork(this);
        super.onDestroy();
    }

    public void finish() {
        if (WhenMappings.$EnumSwitchMapping$0[this.currentScreen.ordinal()] != 2) {
            getViewModel().disableSoftAp();
        }
        super.finish();
    }

    @Deprecated(message = "Deprecated in Java")
    public void onBackPressed() {
        if (!Intrinsics.areEqual((Object) getViewModel().getLvBlockNavigation().getValue(), (Object) true)) {
            goBackOneScreen();
        }
    }

    private final void goForwardToScreen(AddDeviceScreen addDeviceScreen) {
        AddDeviceScreen addDeviceScreen2 = this.currentScreen;
        Timber.Forest.d("goForwardToScreen: nextScreen = " + addDeviceScreen + ", currentScreen = " + addDeviceScreen2, new Object[0]);
        if (addDeviceScreen2 == AddDeviceScreen.ChooseDevice || addDeviceScreen2 != addDeviceScreen) {
            Fragment fragment = addDeviceScreen.fragment();
            Timber.Forest.d("goForwardToScreen: new Fragment = " + fragment, new Object[0]);
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            Intrinsics.checkNotNullExpressionValue(beginTransaction, "beginTransaction(...)");
            this.currentScreen = addDeviceScreen;
            ViewHelperUtil viewHelperUtil = ViewHelperUtil.INSTANCE;
            ActivityAddDeviceBinding activityAddDeviceBinding = this.addDeviceBinding;
            ActivityAddDeviceBinding activityAddDeviceBinding2 = null;
            if (activityAddDeviceBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("addDeviceBinding");
                activityAddDeviceBinding = null;
            }
            viewHelperUtil.hideSoftKeyboard(activityAddDeviceBinding.contentFragment);
            Timber.Forest.d("goForwardToScreen: add old fragment to backstack " + addDeviceScreen2, new Object[0]);
            ActivityAddDeviceBinding activityAddDeviceBinding3 = this.addDeviceBinding;
            if (activityAddDeviceBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("addDeviceBinding");
                activityAddDeviceBinding3 = null;
            }
            activityAddDeviceBinding3.contentFragment.removeAllViews();
            beginTransaction.replace(com.blueair.adddevice.R.id.content_fragment, fragment, addDeviceScreen.toString());
            if (addDeviceScreen != AddDeviceScreen.ChooseDevice) {
                beginTransaction.addToBackStack(addDeviceScreen.toString());
            }
            beginTransaction.commitAllowingStateLoss();
            ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.setDisplayHomeAsUpEnabled(true);
            }
            int i = WhenMappings.$EnumSwitchMapping$0[addDeviceScreen.ordinal()];
            if (i == 3) {
                this.helpButtonsState = HelpButtonsState.Irrelevant;
                setHelpButtonsVisibility(true, false, false);
            } else if (i != 4) {
                this.helpButtonsState = HelpButtonsState.Irrelevant;
                setHelpButtonsVisibility(false, false, false);
            } else {
                ActivityAddDeviceBinding activityAddDeviceBinding4 = this.addDeviceBinding;
                if (activityAddDeviceBinding4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("addDeviceBinding");
                } else {
                    activityAddDeviceBinding2 = activityAddDeviceBinding4;
                }
                AppCompatTextView appCompatTextView = activityAddDeviceBinding2.helpButton;
                Intrinsics.checkNotNullExpressionValue(appCompatTextView, "helpButton");
                this.helpButtonsState = appCompatTextView.getVisibility() == 0 ? HelpButtonsState.HelpVisible : HelpButtonsState.TroubleshootingAndCustomerSupportVisible;
                setHelpButtonsVisibility(true, false, false);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00b2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void goBackOneScreen() {
        /*
            r9 = this;
            timber.log.Timber$Forest r0 = timber.log.Timber.Forest
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "goBackOneScreen: currentScreen = "
            r1.<init>(r2)
            com.blueair.adddevice.viewmodel.AddDeviceScreen r2 = r9.currentScreen
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r2 = 0
            java.lang.Object[] r3 = new java.lang.Object[r2]
            r0.d(r1, r3)
            com.blueair.adddevice.viewmodel.AddDeviceScreen r0 = r9.currentScreen
            int[] r1 = com.blueair.adddevice.activity.AddBluetoothDeviceActivity.WhenMappings.$EnumSwitchMapping$0
            int r0 = r0.ordinal()
            r0 = r1[r0]
            r1 = 1
            if (r0 == r1) goto L_0x00d9
            r3 = 5
            r4 = 4
            r5 = 3
            r6 = 2
            if (r0 == r6) goto L_0x003b
            if (r0 == r5) goto L_0x003b
            if (r0 == r4) goto L_0x0038
            if (r0 != r3) goto L_0x0032
            goto L_0x003b
        L_0x0032:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L_0x0038:
            com.blueair.adddevice.viewmodel.AddDeviceScreen r0 = com.blueair.adddevice.viewmodel.AddDeviceScreen.WifiList
            goto L_0x003d
        L_0x003b:
            com.blueair.adddevice.viewmodel.AddDeviceScreen r0 = com.blueair.adddevice.viewmodel.AddDeviceScreen.ChooseDevice
        L_0x003d:
            r9.currentScreen = r0
            com.blueair.adddevice.viewmodel.AddDeviceScreen r7 = com.blueair.adddevice.viewmodel.AddDeviceScreen.ChooseDevice
            if (r0 != r7) goto L_0x004c
            androidx.fragment.app.FragmentManager r0 = r9.getSupportFragmentManager()
            r7 = 0
            r0.popBackStackImmediate((java.lang.String) r7, (int) r1)
            goto L_0x0059
        L_0x004c:
            androidx.fragment.app.FragmentManager r0 = r9.getSupportFragmentManager()
            com.blueair.adddevice.viewmodel.AddDeviceScreen r7 = r9.currentScreen
            java.lang.String r7 = r7.toString()
            r0.popBackStackImmediate((java.lang.String) r7, (int) r2)
        L_0x0059:
            timber.log.Timber$Forest r0 = timber.log.Timber.Forest
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "goBackOneScreen: new screen = "
            r7.<init>(r8)
            com.blueair.adddevice.viewmodel.AddDeviceScreen r8 = r9.currentScreen
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.Object[] r8 = new java.lang.Object[r2]
            r0.d(r7, r8)
            com.blueair.adddevice.viewmodel.AddDeviceScreen r0 = r9.currentScreen
            int[] r7 = com.blueair.adddevice.activity.AddBluetoothDeviceActivity.WhenMappings.$EnumSwitchMapping$0
            int r0 = r0.ordinal()
            r0 = r7[r0]
            if (r0 == r1) goto L_0x00a1
            if (r0 == r6) goto L_0x009c
            if (r0 == r5) goto L_0x0097
            if (r0 == r4) goto L_0x0092
            if (r0 == r3) goto L_0x008a
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L_0x008a:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Could not go back to a final step"
            r0.<init>(r1)
            throw r0
        L_0x0092:
            com.blueair.viewcore.Header r0 = r9.deviceSetupHeader(r6)
            goto L_0x00a5
        L_0x0097:
            com.blueair.viewcore.Header r0 = r9.deviceSetupHeader(r6)
            goto L_0x00a5
        L_0x009c:
            com.blueair.viewcore.Header r0 = r9.deviceSetupHeader(r5)
            goto L_0x00a5
        L_0x00a1:
            com.blueair.viewcore.Header r0 = r9.getBluetoothScanHeader()
        L_0x00a5:
            r9.setHeader(r0)
            com.blueair.adddevice.viewmodel.AddDeviceScreen r0 = r9.currentScreen
            com.blueair.adddevice.viewmodel.AddDeviceScreen r3 = com.blueair.adddevice.viewmodel.AddDeviceScreen.ChooseDevice
            if (r0 != r3) goto L_0x00b2
            r9.setHelpButtonsVisibility(r2, r2, r2)
            return
        L_0x00b2:
            com.blueair.adddevice.viewmodel.AddDeviceScreen r0 = r9.currentScreen
            com.blueair.adddevice.viewmodel.AddDeviceScreen r3 = com.blueair.adddevice.viewmodel.AddDeviceScreen.WifiList
            if (r0 != r3) goto L_0x00d8
            com.blueair.adddevice.activity.AddBluetoothDeviceActivity$HelpButtonsState r0 = r9.helpButtonsState
            com.blueair.adddevice.activity.AddBluetoothDeviceActivity$HelpButtonsState r3 = com.blueair.adddevice.activity.AddBluetoothDeviceActivity.HelpButtonsState.HelpVisible
            if (r0 != r3) goto L_0x00c0
            r0 = r1
            goto L_0x00c1
        L_0x00c0:
            r0 = r2
        L_0x00c1:
            com.blueair.adddevice.activity.AddBluetoothDeviceActivity$HelpButtonsState r3 = r9.helpButtonsState
            com.blueair.adddevice.activity.AddBluetoothDeviceActivity$HelpButtonsState r4 = com.blueair.adddevice.activity.AddBluetoothDeviceActivity.HelpButtonsState.TroubleshootingAndCustomerSupportVisible
            if (r3 != r4) goto L_0x00c9
            r3 = r1
            goto L_0x00ca
        L_0x00c9:
            r3 = r2
        L_0x00ca:
            com.blueair.adddevice.activity.AddBluetoothDeviceActivity$HelpButtonsState r4 = r9.helpButtonsState
            com.blueair.adddevice.activity.AddBluetoothDeviceActivity$HelpButtonsState r5 = com.blueair.adddevice.activity.AddBluetoothDeviceActivity.HelpButtonsState.TroubleshootingAndCustomerSupportVisible
            if (r4 != r5) goto L_0x00d1
            r2 = r1
        L_0x00d1:
            r9.setHelpButtonsVisibility(r0, r3, r2)
            com.blueair.adddevice.activity.AddBluetoothDeviceActivity$HelpButtonsState r0 = com.blueair.adddevice.activity.AddBluetoothDeviceActivity.HelpButtonsState.Irrelevant
            r9.helpButtonsState = r0
        L_0x00d8:
            return
        L_0x00d9:
            r9.finish()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.adddevice.activity.AddBluetoothDeviceActivity.goBackOneScreen():void");
    }

    private final void restartScreens() {
        this.currentScreen = AddDeviceScreen.ChooseDevice;
        while (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStackImmediate();
        }
        setBluetoothScanHeader();
        setHelpButtonsVisibility(false, false, false);
    }

    private final void showConnectionLost() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        Class<ConfirmationDialogLeftAligned> cls = ConfirmationDialogLeftAligned.class;
        Intrinsics.checkNotNullExpressionValue("ConfirmationDialogLeftAligned", "getSimpleName(...)");
        if ((supportFragmentManager.findFragmentByTag("ConfirmationDialogLeftAligned") instanceof ConfirmationDialogLeftAligned) || supportFragmentManager.isStateSaved()) {
        } else {
            ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, R.string.connection_to_purifier_lost, (Integer) null, R.string.connection_to_purifier_hint, Integer.valueOf(R.string.connection_to_purifier_try_again), Integer.valueOf(R.string.action_read_tips), false, false, false, false, (String[]) null, (String) null, new AddBluetoothDeviceActivity$$ExternalSyntheticLambda12(this), 1888, (Object) null).show(supportFragmentManager, "ConfirmationDialogLeftAligned");
        }
    }

    /* access modifiers changed from: private */
    public static final Unit showConnectionLost$lambda$20$lambda$19(AddBluetoothDeviceActivity addBluetoothDeviceActivity, boolean z) {
        DialogFragment dialogFragment;
        if (z) {
            addBluetoothDeviceActivity.getViewModel().restart();
        } else {
            FragmentManager supportFragmentManager = addBluetoothDeviceActivity.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
            Class<TroubleshootingDialog> cls = TroubleshootingDialog.class;
            Intrinsics.checkNotNullExpressionValue(TroubleshootingDialog.REQUEST_KEY, "getSimpleName(...)");
            if ((supportFragmentManager.findFragmentByTag(TroubleshootingDialog.REQUEST_KEY) instanceof TroubleshootingDialog) || supportFragmentManager.isStateSaved()) {
                dialogFragment = null;
            } else {
                dialogFragment = TroubleshootingDialog.Companion.newInstanceForBluetooth(addBluetoothDeviceActivity.getViewModel().getSelectedUiDevice());
                dialogFragment.show(supportFragmentManager, TroubleshootingDialog.REQUEST_KEY);
                supportFragmentManager.executePendingTransactions();
            }
            TroubleshootingDialog troubleshootingDialog = (TroubleshootingDialog) dialogFragment;
            if (troubleshootingDialog != null) {
                FragmentExtensionsKt.setFragmentResultListenerWithClear(troubleshootingDialog, TroubleshootingDialog.REQUEST_KEY, new AddBluetoothDeviceActivity$$ExternalSyntheticLambda11(addBluetoothDeviceActivity));
            }
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit showConnectionLost$lambda$20$lambda$19$lambda$18(AddBluetoothDeviceActivity addBluetoothDeviceActivity, String str, Bundle bundle) {
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        Intrinsics.checkNotNullParameter(bundle, "result");
        if (bundle.getBoolean(TroubleshootingDialog.ACTION_RETRY)) {
            addBluetoothDeviceActivity.getViewModel().restart();
        }
        return Unit.INSTANCE;
    }

    private final void setHelpButtonsVisibility(boolean z, boolean z2, boolean z3) {
        ActivityAddDeviceBinding activityAddDeviceBinding = this.addDeviceBinding;
        if (activityAddDeviceBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addDeviceBinding");
            activityAddDeviceBinding = null;
        }
        AppCompatTextView appCompatTextView = activityAddDeviceBinding.helpButton;
        Intrinsics.checkNotNullExpressionValue(appCompatTextView, "helpButton");
        appCompatTextView.setVisibility(z ? 0 : 8);
    }

    private final Header deviceSetupHeader(int i) {
        String str;
        BluetoothDevice selectedUiDevice = getViewModel().getSelectedUiDevice();
        if (selectedUiDevice == null || (str = selectedUiDevice.getFamilyName()) == null) {
            str = "";
        }
        String string = getString(R.string.add_device);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return new Header(string, str, Integer.valueOf(R.drawable.ic_arrow_back_white), Integer.valueOf(i));
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/blueair/adddevice/activity/AddBluetoothDeviceActivity$HelpButtonsState;", "", "<init>", "(Ljava/lang/String;I)V", "HelpVisible", "TroubleshootingAndCustomerSupportVisible", "Irrelevant", "adddevice_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AddBluetoothDeviceActivity.kt */
    private enum HelpButtonsState {
        HelpVisible,
        TroubleshootingAndCustomerSupportVisible,
        Irrelevant;

        public static EnumEntries<HelpButtonsState> getEntries() {
            return $ENTRIES;
        }

        static {
            HelpButtonsState[] $values;
            $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
        }
    }
}
