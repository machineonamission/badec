package com.blueair.devicedetails.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelLazy;
import com.blueair.core.model.AnalyticEvent;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceAware;
import com.blueair.core.model.FilterTrigger;
import com.blueair.core.model.HasFanSpeed;
import com.blueair.core.model.HasG4NightMode;
import com.blueair.core.model.HasLinkingCapability;
import com.blueair.core.model.HasRemoveYellowWater;
import com.blueair.core.model.HasWelcomeHome;
import com.blueair.core.model.PanelDisplayMode;
import com.blueair.core.model.SimpleEvent;
import com.blueair.core.model.UserManual;
import com.blueair.core.model.WelcomeHomeLocation;
import com.blueair.devicedetails.adapter.DeviceSettingsAdapter;
import com.blueair.devicedetails.databinding.ActivityDeviceSettingsBinding;
import com.blueair.devicedetails.dialog.DeleteDeviceDialogFragment;
import com.blueair.devicedetails.dialog.DeviceC3TemperatureDialogFragment;
import com.blueair.devicedetails.dialog.DeviceErrorReportDialogFragment;
import com.blueair.devicedetails.dialog.DeviceHDryModeDialogFragment;
import com.blueair.devicedetails.dialog.DeviceLinkDialogFragment;
import com.blueair.devicedetails.dialog.DeviceSetTimezoneDialogFragment;
import com.blueair.devicedetails.dialog.DeviceSettingInfoDialogFragment;
import com.blueair.devicedetails.fragment.EmptyFragment;
import com.blueair.devicedetails.util.DeviceSetting;
import com.blueair.devicedetails.util.WelcomeHomePermissionManager;
import com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel;
import com.blueair.devicedetails.viewmodel.DeviceWelcomeHomeViewModel;
import com.blueair.viewcore.R;
import com.blueair.viewcore.activity.BaseActivity;
import com.blueair.viewcore.activity.BaseLokaliseActivity;
import com.blueair.viewcore.activity.WebViewActivity;
import com.blueair.viewcore.utils.DeviceConfigProvider;
import com.google.android.material.button.MaterialButton;
import com.jacquessmuts.rxextensions.LazyPublishSubject;
import com.jacquessmuts.rxextensions.RxExtensionsKt;
import io.flatcircle.livedatahelper.LiveDataExtensionsKt;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KFunction;
import kotlin.reflect.KProperty;
import timber.log.Timber;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 Z2\u00020\u0001:\u0001ZB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010M\u001a\u00020:2\b\u0010N\u001a\u0004\u0018\u00010OH\u0014J\b\u0010P\u001a\u00020:H\u0014J\u0016\u0010Q\u001a\u00020:2\f\u0010R\u001a\b\u0012\u0004\u0012\u00020:0SH\u0002J\b\u0010T\u001a\u00020:H\u0002J\b\u0010U\u001a\u00020:H\u0002J\b\u0010V\u001a\u00020:H\u0002J\b\u0010W\u001a\u00020:H\u0002J\b\u0010X\u001a\u00020:H\u0002J\b\u0010Y\u001a\u00020:H\u0002R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0012\u0010\u0013R!\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168BX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019R!\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00168BX\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u001b\u001a\u0004\b\u001e\u0010\u0019R!\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001d0\u00168BX\u0002¢\u0006\f\n\u0004\b\"\u0010\u001b\u001a\u0004\b!\u0010\u0019R!\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00168BX\u0002¢\u0006\f\n\u0004\b%\u0010\u001b\u001a\u0004\b$\u0010\u0019R-\u0010&\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001d0'0\u00168BX\u0002¢\u0006\f\n\u0004\b)\u0010\u001b\u001a\u0004\b(\u0010\u0019R!\u0010*\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00168BX\u0002¢\u0006\f\n\u0004\b,\u0010\u001b\u001a\u0004\b+\u0010\u0019R!\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168BX\u0002¢\u0006\f\n\u0004\b/\u0010\u001b\u001a\u0004\b.\u0010\u0019R!\u00100\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168BX\u0002¢\u0006\f\n\u0004\b2\u0010\u001b\u001a\u0004\b1\u0010\u0019R!\u00103\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00168BX\u0002¢\u0006\f\n\u0004\b5\u0010\u001b\u001a\u0004\b4\u0010\u0019R!\u00106\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00168BX\u0002¢\u0006\f\n\u0004\b8\u0010\u001b\u001a\u0004\b7\u0010\u0019R!\u00109\u001a\b\u0012\u0004\u0012\u00020:0\u00168BX\u0002¢\u0006\f\n\u0004\b<\u0010\u001b\u001a\u0004\b;\u0010\u0019R\u0014\u0010=\u001a\b\u0012\u0004\u0012\u00020:0>X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010?\u001a\b\u0012\u0004\u0012\u00020:0>X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010@\u001a\b\u0012\u0004\u0012\u00020B0AX.¢\u0006\u0002\n\u0000R\u0014\u0010C\u001a\b\u0012\u0004\u0012\u00020B0AX.¢\u0006\u0002\n\u0000R\u0010\u0010D\u001a\u0004\u0018\u00010EX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010F\u001a\u0004\u0018\u00010GX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010H\u001a\u00020I8BX\u0002¢\u0006\f\n\u0004\bL\u0010\u000f\u001a\u0004\bJ\u0010K¨\u0006["}, d2 = {"Lcom/blueair/devicedetails/activity/DeviceSettingsActivity;", "Lcom/blueair/viewcore/activity/BaseActivity;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "binding", "Lcom/blueair/devicedetails/databinding/ActivityDeviceSettingsBinding;", "viewModel", "Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;", "getViewModel", "()Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "welcomeHomeViewModel", "Lcom/blueair/devicedetails/viewmodel/DeviceWelcomeHomeViewModel;", "getWelcomeHomeViewModel", "()Lcom/blueair/devicedetails/viewmodel/DeviceWelcomeHomeViewModel;", "welcomeHomeViewModel$delegate", "deviceInfoPublisher", "Lio/reactivex/subjects/PublishSubject;", "", "getDeviceInfoPublisher", "()Lio/reactivex/subjects/PublishSubject;", "deviceInfoPublisher$delegate", "Lcom/jacquessmuts/rxextensions/LazyPublishSubject;", "childLockPublisher", "Lcom/blueair/core/model/Device;", "getChildLockPublisher", "childLockPublisher$delegate", "standbyPublisher", "getStandbyPublisher", "standbyPublisher$delegate", "germShieldPublisher", "getGermShieldPublisher", "germShieldPublisher$delegate", "eventPublisher", "Lcom/blueair/core/model/SimpleEvent;", "getEventPublisher", "eventPublisher$delegate", "autoRefreshPublisher", "getAutoRefreshPublisher", "autoRefreshPublisher$delegate", "hourFormatPublisher", "getHourFormatPublisher", "hourFormatPublisher$delegate", "displayModePublisher", "getDisplayModePublisher", "displayModePublisher$delegate", "linkedDevicePublisher", "getLinkedDevicePublisher", "linkedDevicePublisher$delegate", "deviceNameClickPublisher", "getDeviceNameClickPublisher", "deviceNameClickPublisher$delegate", "timezonePublisher", "", "getTimezonePublisher", "timezonePublisher$delegate", "triggerChangedListener", "Lkotlin/reflect/KFunction0;", "errorReportListener", "inputLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "welcomeHomeLauncher", "locationPermissionManager", "Lcom/blueair/devicedetails/util/WelcomeHomePermissionManager;", "userManual", "Lcom/blueair/core/model/UserManual;", "adapter", "Lcom/blueair/devicedetails/adapter/DeviceSettingsAdapter;", "getAdapter", "()Lcom/blueair/devicedetails/adapter/DeviceSettingsAdapter;", "adapter$delegate", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "prepareLocationPermissionManager", "onDone", "Lkotlin/Function0;", "addOrEditHomeLocation", "bindViewModel", "excludeCertainSettings", "updateWelcomeHome", "checkForAutoModeTriggerUpdate", "onErrorReportClicked", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceSettingsActivity.kt */
public final class DeviceSettingsActivity extends BaseActivity {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final Lazy adapter$delegate;
    private final LazyPublishSubject autoRefreshPublisher$delegate;
    /* access modifiers changed from: private */
    public ActivityDeviceSettingsBinding binding;
    private final LazyPublishSubject childLockPublisher$delegate;
    private final LazyPublishSubject deviceInfoPublisher$delegate;
    private final LazyPublishSubject deviceNameClickPublisher$delegate;
    private final LazyPublishSubject displayModePublisher$delegate;
    private final KFunction<Unit> errorReportListener;
    private final LazyPublishSubject eventPublisher$delegate;
    private final LazyPublishSubject germShieldPublisher$delegate;
    private final LazyPublishSubject hourFormatPublisher$delegate;
    private ActivityResultLauncher<Intent> inputLauncher;
    private final LazyPublishSubject linkedDevicePublisher$delegate;
    private WelcomeHomePermissionManager locationPermissionManager;
    private final String screenName = AnalyticEvent.ScreenViewEvent.DEVICE_SETTINGS;
    private final LazyPublishSubject standbyPublisher$delegate;
    private final LazyPublishSubject timezonePublisher$delegate;
    private final KFunction<Unit> triggerChangedListener;
    private UserManual userManual;
    private final Lazy viewModel$delegate;
    private ActivityResultLauncher<Intent> welcomeHomeLauncher;
    private final Lazy welcomeHomeViewModel$delegate;

    static {
        Class<DeviceSettingsActivity> cls = DeviceSettingsActivity.class;
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(cls, "deviceInfoPublisher", "getDeviceInfoPublisher()Lio/reactivex/subjects/PublishSubject;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "childLockPublisher", "getChildLockPublisher()Lio/reactivex/subjects/PublishSubject;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "standbyPublisher", "getStandbyPublisher()Lio/reactivex/subjects/PublishSubject;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "germShieldPublisher", "getGermShieldPublisher()Lio/reactivex/subjects/PublishSubject;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "eventPublisher", "getEventPublisher()Lio/reactivex/subjects/PublishSubject;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "autoRefreshPublisher", "getAutoRefreshPublisher()Lio/reactivex/subjects/PublishSubject;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "hourFormatPublisher", "getHourFormatPublisher()Lio/reactivex/subjects/PublishSubject;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "displayModePublisher", "getDisplayModePublisher()Lio/reactivex/subjects/PublishSubject;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "linkedDevicePublisher", "getLinkedDevicePublisher()Lio/reactivex/subjects/PublishSubject;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "deviceNameClickPublisher", "getDeviceNameClickPublisher()Lio/reactivex/subjects/PublishSubject;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "timezonePublisher", "getTimezonePublisher()Lio/reactivex/subjects/PublishSubject;", 0))};
    }

    public DeviceSettingsActivity() {
        ComponentActivity componentActivity = this;
        this.viewModel$delegate = new ViewModelLazy(Reflection.getOrCreateKotlinClass(DeviceDetailsViewModel.class), new DeviceSettingsActivity$special$$inlined$viewModels$default$2(componentActivity), new DeviceSettingsActivity$special$$inlined$viewModels$default$1(componentActivity), new DeviceSettingsActivity$special$$inlined$viewModels$default$3((Function0) null, componentActivity));
        this.welcomeHomeViewModel$delegate = new ViewModelLazy(Reflection.getOrCreateKotlinClass(DeviceWelcomeHomeViewModel.class), new DeviceSettingsActivity$special$$inlined$viewModels$default$5(componentActivity), new DeviceSettingsActivity$special$$inlined$viewModels$default$4(componentActivity), new DeviceSettingsActivity$special$$inlined$viewModels$default$6((Function0) null, componentActivity));
        this.deviceInfoPublisher$delegate = new LazyPublishSubject();
        this.childLockPublisher$delegate = new LazyPublishSubject();
        this.standbyPublisher$delegate = new LazyPublishSubject();
        this.germShieldPublisher$delegate = new LazyPublishSubject();
        this.eventPublisher$delegate = new LazyPublishSubject();
        this.autoRefreshPublisher$delegate = new LazyPublishSubject();
        this.hourFormatPublisher$delegate = new LazyPublishSubject();
        this.displayModePublisher$delegate = new LazyPublishSubject();
        this.linkedDevicePublisher$delegate = new LazyPublishSubject();
        this.deviceNameClickPublisher$delegate = new LazyPublishSubject();
        this.timezonePublisher$delegate = new LazyPublishSubject();
        this.triggerChangedListener = new DeviceSettingsActivity$triggerChangedListener$1(this);
        this.errorReportListener = new DeviceSettingsActivity$errorReportListener$1(this);
        this.adapter$delegate = LazyKt.lazy(new DeviceSettingsActivity$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: protected */
    public String getScreenName() {
        return this.screenName;
    }

    private final DeviceDetailsViewModel getViewModel() {
        return (DeviceDetailsViewModel) this.viewModel$delegate.getValue();
    }

    private final DeviceWelcomeHomeViewModel getWelcomeHomeViewModel() {
        return (DeviceWelcomeHomeViewModel) this.welcomeHomeViewModel$delegate.getValue();
    }

    private final PublishSubject<Boolean> getDeviceInfoPublisher() {
        return this.deviceInfoPublisher$delegate.getValue((Object) this, (KProperty<?>) $$delegatedProperties[0]);
    }

    private final PublishSubject<Device> getChildLockPublisher() {
        return this.childLockPublisher$delegate.getValue((Object) this, (KProperty<?>) $$delegatedProperties[1]);
    }

    private final PublishSubject<Device> getStandbyPublisher() {
        return this.standbyPublisher$delegate.getValue((Object) this, (KProperty<?>) $$delegatedProperties[2]);
    }

    private final PublishSubject<Device> getGermShieldPublisher() {
        return this.germShieldPublisher$delegate.getValue((Object) this, (KProperty<?>) $$delegatedProperties[3]);
    }

    private final PublishSubject<SimpleEvent<String, Device>> getEventPublisher() {
        return this.eventPublisher$delegate.getValue((Object) this, (KProperty<?>) $$delegatedProperties[4]);
    }

    private final PublishSubject<Device> getAutoRefreshPublisher() {
        return this.autoRefreshPublisher$delegate.getValue((Object) this, (KProperty<?>) $$delegatedProperties[5]);
    }

    private final PublishSubject<Boolean> getHourFormatPublisher() {
        return this.hourFormatPublisher$delegate.getValue((Object) this, (KProperty<?>) $$delegatedProperties[6]);
    }

    private final PublishSubject<Boolean> getDisplayModePublisher() {
        return this.displayModePublisher$delegate.getValue((Object) this, (KProperty<?>) $$delegatedProperties[7]);
    }

    private final PublishSubject<Device> getLinkedDevicePublisher() {
        return this.linkedDevicePublisher$delegate.getValue((Object) this, (KProperty<?>) $$delegatedProperties[8]);
    }

    private final PublishSubject<Device> getDeviceNameClickPublisher() {
        return this.deviceNameClickPublisher$delegate.getValue((Object) this, (KProperty<?>) $$delegatedProperties[9]);
    }

    private final PublishSubject<Unit> getTimezonePublisher() {
        return this.timezonePublisher$delegate.getValue((Object) this, (KProperty<?>) $$delegatedProperties[10]);
    }

    private final DeviceSettingsAdapter getAdapter() {
        return (DeviceSettingsAdapter) this.adapter$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final DeviceSettingsAdapter adapter_delegate$lambda$0(DeviceSettingsActivity deviceSettingsActivity) {
        return new DeviceSettingsAdapter(deviceSettingsActivity.getDeviceInfoPublisher(), deviceSettingsActivity.getChildLockPublisher(), deviceSettingsActivity.getStandbyPublisher(), deviceSettingsActivity.getGermShieldPublisher(), deviceSettingsActivity.getLinkedDevicePublisher(), deviceSettingsActivity.getDeviceNameClickPublisher(), deviceSettingsActivity.getAutoRefreshPublisher(), deviceSettingsActivity.getHourFormatPublisher(), deviceSettingsActivity.getDisplayModePublisher(), deviceSettingsActivity.getTimezonePublisher(), deviceSettingsActivity.getEventPublisher(), (Function0) deviceSettingsActivity.triggerChangedListener, (Function0) deviceSettingsActivity.errorReportListener);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        DeviceDetailsViewModel viewModel = getViewModel();
        Parcelable parcelableExtra = getIntent().getParcelableExtra("device");
        if (parcelableExtra != null) {
            viewModel.setDevice((Device) parcelableExtra);
            super.onCreate(bundle);
            ActivityDeviceSettingsBinding activityDeviceSettingsBinding = null;
            BaseLokaliseActivity.immersiveStatusBar$default(this, false, 1, (Object) null);
            setStatusMode(true);
            bindViewModel();
            ActivityDeviceSettingsBinding activityDeviceSettingsBinding2 = this.binding;
            if (activityDeviceSettingsBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityDeviceSettingsBinding2 = null;
            }
            activityDeviceSettingsBinding2.recyclerViewSettingsContainer.getRecyclerView().setAdapter(getAdapter());
            ActivityDeviceSettingsBinding activityDeviceSettingsBinding3 = this.binding;
            if (activityDeviceSettingsBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityDeviceSettingsBinding3 = null;
            }
            MaterialButton materialButton = activityDeviceSettingsBinding3.buttonWarranty;
            Intrinsics.checkNotNullExpressionValue(materialButton, "buttonWarranty");
            ViewExtensionsKt.show(materialButton, false);
            ActivityDeviceSettingsBinding activityDeviceSettingsBinding4 = this.binding;
            if (activityDeviceSettingsBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityDeviceSettingsBinding4 = null;
            }
            activityDeviceSettingsBinding4.buttonWarranty.setOnClickListener(new DeviceSettingsActivity$$ExternalSyntheticLambda25(this));
            ActivityDeviceSettingsBinding activityDeviceSettingsBinding5 = this.binding;
            if (activityDeviceSettingsBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityDeviceSettingsBinding5 = null;
            }
            activityDeviceSettingsBinding5.buttonDeleteProduct.setOnClickListener(new DeviceSettingsActivity$$ExternalSyntheticLambda26(this));
            ActivityDeviceSettingsBinding activityDeviceSettingsBinding6 = this.binding;
            if (activityDeviceSettingsBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityDeviceSettingsBinding6 = null;
            }
            activityDeviceSettingsBinding6.btnBack.setOnClickListener(new DeviceSettingsActivity$$ExternalSyntheticLambda27(this));
            ActivityResultLauncher<Intent> registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new DeviceSettingsActivity$$ExternalSyntheticLambda28(this));
            Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "registerForActivityResult(...)");
            this.inputLauncher = registerForActivityResult;
            ActivityResultLauncher<Intent> registerForActivityResult2 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new DeviceSettingsActivity$$ExternalSyntheticLambda29(this));
            Intrinsics.checkNotNullExpressionValue(registerForActivityResult2, "registerForActivityResult(...)");
            this.welcomeHomeLauncher = registerForActivityResult2;
            ActivityDeviceSettingsBinding activityDeviceSettingsBinding7 = this.binding;
            if (activityDeviceSettingsBinding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                activityDeviceSettingsBinding = activityDeviceSettingsBinding7;
            }
            activityDeviceSettingsBinding.recyclerViewContainer.setOnScrollChangeListener(new DeviceSettingsActivity$onCreate$6(this));
            return;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$1(DeviceSettingsActivity deviceSettingsActivity, View view) {
        String string = deviceSettingsActivity.getString(R.string.action_warranty);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        WebViewActivity.Companion.launch(deviceSettingsActivity, (String) null, string, deviceSettingsActivity.getViewModel().getWarrantyLink());
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$3(DeviceSettingsActivity deviceSettingsActivity, View view) {
        FragmentManager supportFragmentManager = deviceSettingsActivity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        Class<DeleteDeviceDialogFragment> cls = DeleteDeviceDialogFragment.class;
        Intrinsics.checkNotNullExpressionValue("DeleteDeviceDialogFragment", "getSimpleName(...)");
        if (!(supportFragmentManager.findFragmentByTag("DeleteDeviceDialogFragment") instanceof DeleteDeviceDialogFragment) && !supportFragmentManager.isStateSaved()) {
            DeleteDeviceDialogFragment.Companion companion = DeleteDeviceDialogFragment.Companion;
            Device device = deviceSettingsActivity.getViewModel().getDevice();
            Intrinsics.checkNotNull(device);
            companion.newInstance(device, true).show(supportFragmentManager, "DeleteDeviceDialogFragment");
        }
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$4(DeviceSettingsActivity deviceSettingsActivity, View view) {
        deviceSettingsActivity.onBackPressed();
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$6(DeviceSettingsActivity deviceSettingsActivity, ActivityResult activityResult) {
        Intent data;
        String stringExtra;
        if (activityResult.getResultCode() == -1 && (data = activityResult.getData()) != null && (stringExtra = data.getStringExtra(CustomInputActivity.EXTRA_INPUT)) != null) {
            DeviceDetailsViewModel viewModel = deviceSettingsActivity.getViewModel();
            Device device = deviceSettingsActivity.getViewModel().getDevice();
            Intrinsics.checkNotNull(device);
            viewModel.setDeviceName(device, stringExtra);
        }
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$7(DeviceSettingsActivity deviceSettingsActivity, ActivityResult activityResult) {
        deviceSettingsActivity.updateWelcomeHome();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        CompositeDisposable rxSubs = getRxSubs();
        Observable filterRapidClicks = RxExtensionsKt.filterRapidClicks(getDeviceInfoPublisher());
        Intrinsics.checkNotNullExpressionValue(filterRapidClicks, "filterRapidClicks(...)");
        rxSubs.add(RxExtensionsKt.subscribeAndLogE(filterRapidClicks, new DeviceSettingsActivity$$ExternalSyntheticLambda7(this)));
        CompositeDisposable rxSubs2 = getRxSubs();
        Observable filterRapidClicks2 = RxExtensionsKt.filterRapidClicks(getChildLockPublisher());
        Intrinsics.checkNotNullExpressionValue(filterRapidClicks2, "filterRapidClicks(...)");
        rxSubs2.add(RxExtensionsKt.subscribeAndLogE(filterRapidClicks2, new DeviceSettingsActivity$$ExternalSyntheticLambda9(this)));
        CompositeDisposable rxSubs3 = getRxSubs();
        Observable filterRapidClicks3 = RxExtensionsKt.filterRapidClicks(getStandbyPublisher());
        Intrinsics.checkNotNullExpressionValue(filterRapidClicks3, "filterRapidClicks(...)");
        rxSubs3.add(RxExtensionsKt.subscribeAndLogE(filterRapidClicks3, new DeviceSettingsActivity$$ExternalSyntheticLambda10(this)));
        CompositeDisposable rxSubs4 = getRxSubs();
        Observable filterRapidClicks4 = RxExtensionsKt.filterRapidClicks(getGermShieldPublisher());
        Intrinsics.checkNotNullExpressionValue(filterRapidClicks4, "filterRapidClicks(...)");
        rxSubs4.add(RxExtensionsKt.subscribeAndLogE(filterRapidClicks4, new DeviceSettingsActivity$$ExternalSyntheticLambda12(this)));
        CompositeDisposable rxSubs5 = getRxSubs();
        Observable filterRapidClicks5 = RxExtensionsKt.filterRapidClicks(getAutoRefreshPublisher());
        Intrinsics.checkNotNullExpressionValue(filterRapidClicks5, "filterRapidClicks(...)");
        rxSubs5.add(RxExtensionsKt.subscribeAndLogE(filterRapidClicks5, new DeviceSettingsActivity$$ExternalSyntheticLambda13(this)));
        CompositeDisposable rxSubs6 = getRxSubs();
        Observable filterRapidClicks6 = RxExtensionsKt.filterRapidClicks(getHourFormatPublisher());
        Intrinsics.checkNotNullExpressionValue(filterRapidClicks6, "filterRapidClicks(...)");
        rxSubs6.add(RxExtensionsKt.subscribeAndLogE(filterRapidClicks6, new DeviceSettingsActivity$$ExternalSyntheticLambda14(this)));
        CompositeDisposable rxSubs7 = getRxSubs();
        Observable filterRapidClicks7 = RxExtensionsKt.filterRapidClicks(getDisplayModePublisher());
        Intrinsics.checkNotNullExpressionValue(filterRapidClicks7, "filterRapidClicks(...)");
        rxSubs7.add(RxExtensionsKt.subscribeAndLogE(filterRapidClicks7, new DeviceSettingsActivity$$ExternalSyntheticLambda15(this)));
        CompositeDisposable rxSubs8 = getRxSubs();
        Observable filterRapidClicks8 = RxExtensionsKt.filterRapidClicks(getLinkedDevicePublisher());
        Intrinsics.checkNotNullExpressionValue(filterRapidClicks8, "filterRapidClicks(...)");
        rxSubs8.add(RxExtensionsKt.subscribeAndLogE(filterRapidClicks8, new DeviceSettingsActivity$$ExternalSyntheticLambda16(this)));
        CompositeDisposable rxSubs9 = getRxSubs();
        Observable filterRapidClicks9 = RxExtensionsKt.filterRapidClicks(getDeviceNameClickPublisher());
        Intrinsics.checkNotNullExpressionValue(filterRapidClicks9, "filterRapidClicks(...)");
        rxSubs9.add(RxExtensionsKt.subscribeAndLogE(filterRapidClicks9, new DeviceSettingsActivity$$ExternalSyntheticLambda17(this)));
        CompositeDisposable rxSubs10 = getRxSubs();
        Observable filterRapidClicks10 = RxExtensionsKt.filterRapidClicks(getTimezonePublisher());
        Intrinsics.checkNotNullExpressionValue(filterRapidClicks10, "filterRapidClicks(...)");
        rxSubs10.add(RxExtensionsKt.subscribeAndLogE(filterRapidClicks10, new DeviceSettingsActivity$$ExternalSyntheticLambda18(this)));
        CompositeDisposable rxSubs11 = getRxSubs();
        Observable filterRapidClicks11 = RxExtensionsKt.filterRapidClicks(getEventPublisher());
        Intrinsics.checkNotNullExpressionValue(filterRapidClicks11, "filterRapidClicks(...)");
        rxSubs11.add(RxExtensionsKt.subscribeAndLogE(filterRapidClicks11, new DeviceSettingsActivity$$ExternalSyntheticLambda8(this)));
    }

    /* access modifiers changed from: private */
    public static final Unit onResume$lambda$10(DeviceSettingsActivity deviceSettingsActivity, Boolean bool) {
        Device device = deviceSettingsActivity.getViewModel().getDevice();
        if (device != null) {
            deviceSettingsActivity.getViewModel().ensureUseProtectRegion();
            FragmentManager supportFragmentManager = deviceSettingsActivity.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
            Class<DeviceSettingInfoDialogFragment> cls = DeviceSettingInfoDialogFragment.class;
            Intrinsics.checkNotNullExpressionValue("DeviceSettingInfoDialogFragment", "getSimpleName(...)");
            if (!(supportFragmentManager.findFragmentByTag("DeviceSettingInfoDialogFragment") instanceof DeviceSettingInfoDialogFragment) && !supportFragmentManager.isStateSaved()) {
                DeviceSettingInfoDialogFragment.Companion.newInstance(device).show(supportFragmentManager, "DeviceSettingInfoDialogFragment");
            }
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onResume$lambda$11(DeviceSettingsActivity deviceSettingsActivity, Device device) {
        DeviceDetailsViewModel viewModel = deviceSettingsActivity.getViewModel();
        Intrinsics.checkNotNull(device);
        viewModel.childLockChanged(device);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onResume$lambda$12(DeviceSettingsActivity deviceSettingsActivity, Device device) {
        DeviceDetailsViewModel viewModel = deviceSettingsActivity.getViewModel();
        Intrinsics.checkNotNull(device);
        viewModel.standByChanged(device);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onResume$lambda$13(DeviceSettingsActivity deviceSettingsActivity, Device device) {
        DeviceDetailsViewModel viewModel = deviceSettingsActivity.getViewModel();
        Intrinsics.checkNotNull(device);
        viewModel.germShieldChanged(device);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onResume$lambda$14(DeviceSettingsActivity deviceSettingsActivity, Device device) {
        DeviceDetailsViewModel viewModel = deviceSettingsActivity.getViewModel();
        Intrinsics.checkNotNull(device);
        viewModel.autoRefreshEnabledChanged(device);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onResume$lambda$15(DeviceSettingsActivity deviceSettingsActivity, Boolean bool) {
        DeviceDetailsViewModel viewModel = deviceSettingsActivity.getViewModel();
        Device device = deviceSettingsActivity.getViewModel().getDevice();
        Intrinsics.checkNotNull(device);
        Intrinsics.checkNotNull(bool);
        viewModel.setUse24Hour(device, bool.booleanValue());
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onResume$lambda$16(DeviceSettingsActivity deviceSettingsActivity, Boolean bool) {
        DeviceDetailsViewModel viewModel = deviceSettingsActivity.getViewModel();
        Device device = deviceSettingsActivity.getViewModel().getDevice();
        Intrinsics.checkNotNull(device);
        viewModel.setPanelDisplayMode(device, (bool.booleanValue() ? PanelDisplayMode.ON : PanelDisplayMode.OFF).getValue());
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onResume$lambda$18(DeviceSettingsActivity deviceSettingsActivity, Device device) {
        if (device instanceof HasLinkingCapability) {
            FragmentManager supportFragmentManager = deviceSettingsActivity.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
            Class<DeviceLinkDialogFragment> cls = DeviceLinkDialogFragment.class;
            Intrinsics.checkNotNullExpressionValue("DeviceLinkDialogFragment", "getSimpleName(...)");
            if (!(supportFragmentManager.findFragmentByTag("DeviceLinkDialogFragment") instanceof DeviceLinkDialogFragment) && !supportFragmentManager.isStateSaved()) {
                DeviceLinkDialogFragment.Companion.newInstance((HasLinkingCapability) device).show(supportFragmentManager, "DeviceLinkDialogFragment");
            }
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onResume$lambda$19(DeviceSettingsActivity deviceSettingsActivity, Device device) {
        ActivityResultLauncher<Intent> activityResultLauncher = deviceSettingsActivity.inputLauncher;
        if (activityResultLauncher == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inputLauncher");
            activityResultLauncher = null;
        }
        String string = deviceSettingsActivity.getString(R.string.custom_name);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = deviceSettingsActivity.getString(R.string.device_name);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        activityResultLauncher.launch(CustomInputActivity.Companion.getLaunchIntent(deviceSettingsActivity, AnalyticEvent.ScreenViewEvent.DEVICE_SETTINGS_SET_NAME, string, string2, device.getName(), 30));
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onResume$lambda$21(DeviceSettingsActivity deviceSettingsActivity, Unit unit) {
        FragmentManager supportFragmentManager = deviceSettingsActivity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        Class<DeviceSetTimezoneDialogFragment> cls = DeviceSetTimezoneDialogFragment.class;
        Intrinsics.checkNotNullExpressionValue("DeviceSetTimezoneDialogFragment", "getSimpleName(...)");
        if (!(supportFragmentManager.findFragmentByTag("DeviceSetTimezoneDialogFragment") instanceof DeviceSetTimezoneDialogFragment) && !supportFragmentManager.isStateSaved()) {
            DeviceSetTimezoneDialogFragment.Companion companion = DeviceSetTimezoneDialogFragment.Companion;
            Device device = deviceSettingsActivity.getViewModel().getDevice();
            Intrinsics.checkNotNull(device);
            companion.newInstance(device).show(supportFragmentManager, "DeviceSetTimezoneDialogFragment");
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onResume$lambda$28(DeviceSettingsActivity deviceSettingsActivity, SimpleEvent simpleEvent) {
        UserManual userManual2;
        String str = (String) simpleEvent.getEventType();
        switch (str.hashCode()) {
            case -1917869422:
                if (str.equals(DeviceSettingsAdapter.EVENT_DRYMODE_CLICK)) {
                    FragmentManager supportFragmentManager = deviceSettingsActivity.getSupportFragmentManager();
                    Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
                    Class<DeviceHDryModeDialogFragment> cls = DeviceHDryModeDialogFragment.class;
                    Intrinsics.checkNotNullExpressionValue("DeviceHDryModeDialogFragment", "getSimpleName(...)");
                    if (!(supportFragmentManager.findFragmentByTag("DeviceHDryModeDialogFragment") instanceof DeviceHDryModeDialogFragment) && !supportFragmentManager.isStateSaved()) {
                        DeviceHDryModeDialogFragment.Companion.newInstance().show(supportFragmentManager, "DeviceHDryModeDialogFragment");
                        break;
                    }
                }
                break;
            case -1770736584:
                if (str.equals(DeviceSettingsAdapter.EVENT_TEMPERATURE_CLICK)) {
                    FragmentManager supportFragmentManager2 = deviceSettingsActivity.getSupportFragmentManager();
                    Intrinsics.checkNotNullExpressionValue(supportFragmentManager2, "getSupportFragmentManager(...)");
                    Class<DeviceC3TemperatureDialogFragment> cls2 = DeviceC3TemperatureDialogFragment.class;
                    Intrinsics.checkNotNullExpressionValue("DeviceC3TemperatureDialogFragment", "getSimpleName(...)");
                    if (!(supportFragmentManager2.findFragmentByTag("DeviceC3TemperatureDialogFragment") instanceof DeviceC3TemperatureDialogFragment) && !supportFragmentManager2.isStateSaved()) {
                        DeviceC3TemperatureDialogFragment.Companion.newInstance().show(supportFragmentManager2, "DeviceC3TemperatureDialogFragment");
                        break;
                    }
                }
                break;
            case -1380896052:
                if (str.equals(DeviceSettingsAdapter.EVENT_REFRESHER_CHECK)) {
                    Object data = simpleEvent.getData();
                    Intrinsics.checkNotNull(data, "null cannot be cast to non-null type com.blueair.core.model.HasRemoveYellowWater");
                    HasRemoveYellowWater hasRemoveYellowWater = (HasRemoveYellowWater) data;
                    deviceSettingsActivity.getViewModel().setYwrmEnabled(hasRemoveYellowWater, Intrinsics.areEqual((Object) hasRemoveYellowWater.getYwrmEnabled(), (Object) false));
                    break;
                }
                break;
            case -744128988:
                if (str.equals(DeviceSettingsAdapter.EVENT_TVOC_CHECK)) {
                    deviceSettingsActivity.getViewModel().sensorModeChange((Device) simpleEvent.getData());
                    break;
                }
                break;
            case -717285857:
                if (str.equals(DeviceSettingsAdapter.EVENT_USERMANUAL_CLICK) && (userManual2 = deviceSettingsActivity.userManual) != null) {
                    UserManualActivity.Companion.launch(deviceSettingsActivity, AnalyticEvent.ScreenViewEvent.DEVICE_SETTINGS_MANUAL, userManual2.getLink(), userManual2.getStartIndex());
                    break;
                }
            case -39867248:
                if (str.equals(DeviceSettingsAdapter.EVENT_WELCOME_ENABLED_CHANGE)) {
                    if (deviceSettingsActivity.getWelcomeHomeViewModel().isEnabled()) {
                        deviceSettingsActivity.getWelcomeHomeViewModel().setWelcomeHomeEnabled(false);
                        break;
                    } else {
                        deviceSettingsActivity.prepareLocationPermissionManager(new DeviceSettingsActivity$$ExternalSyntheticLambda20(deviceSettingsActivity));
                        break;
                    }
                }
                break;
            case 28488313:
                if (str.equals(DeviceSettingsAdapter.EVENT_HOME_LOCATION_CLICK)) {
                    deviceSettingsActivity.addOrEditHomeLocation();
                    break;
                }
                break;
            case 1253135200:
                if (str.equals(DeviceSettingsAdapter.EVENT_AUTODRY_CHECK)) {
                    deviceSettingsActivity.getViewModel().wickDryEnabledChanged((Device) simpleEvent.getData());
                    break;
                }
                break;
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onResume$lambda$28$lambda$24(DeviceSettingsActivity deviceSettingsActivity) {
        WelcomeHomePermissionManager welcomeHomePermissionManager = deviceSettingsActivity.locationPermissionManager;
        if (welcomeHomePermissionManager != null) {
            welcomeHomePermissionManager.checkAndRequest(new DeviceSettingsActivity$$ExternalSyntheticLambda11(deviceSettingsActivity), new DeviceSettingsActivity$$ExternalSyntheticLambda22(deviceSettingsActivity));
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onResume$lambda$28$lambda$24$lambda$23(DeviceSettingsActivity deviceSettingsActivity) {
        if (Intrinsics.areEqual((Object) deviceSettingsActivity.getWelcomeHomeViewModel().getWelcomeHomeExist().getValue(), (Object) false)) {
            deviceSettingsActivity.addOrEditHomeLocation();
        } else {
            deviceSettingsActivity.getWelcomeHomeViewModel().setWelcomeHomeEnabled(true);
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onResume$lambda$28$lambda$24$lambda$22(DeviceSettingsActivity deviceSettingsActivity) {
        deviceSettingsActivity.updateWelcomeHome();
        return Unit.INSTANCE;
    }

    private final void prepareLocationPermissionManager(Function0<Unit> function0) {
        if (this.locationPermissionManager == null) {
            EmptyFragment.Companion companion = EmptyFragment.Companion;
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
            companion.buildIn(supportFragmentManager, new DeviceSettingsActivity$$ExternalSyntheticLambda21(this, function0));
            return;
        }
        function0.invoke();
    }

    /* access modifiers changed from: private */
    public static final Unit prepareLocationPermissionManager$lambda$29(DeviceSettingsActivity deviceSettingsActivity, Function0 function0, Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "it");
        deviceSettingsActivity.locationPermissionManager = new WelcomeHomePermissionManager(fragment);
        function0.invoke();
        return Unit.INSTANCE;
    }

    private final void addOrEditHomeLocation() {
        Device device = getViewModel().getDevice();
        Intrinsics.checkNotNull(device);
        if (device instanceof HasWelcomeHome) {
            prepareLocationPermissionManager(new DeviceSettingsActivity$$ExternalSyntheticLambda23(this));
        }
    }

    /* access modifiers changed from: private */
    public static final Unit addOrEditHomeLocation$lambda$31(DeviceSettingsActivity deviceSettingsActivity) {
        WelcomeHomePermissionManager welcomeHomePermissionManager = deviceSettingsActivity.locationPermissionManager;
        if (welcomeHomePermissionManager != null) {
            WelcomeHomePermissionManager.checkAndRequest$default(welcomeHomePermissionManager, (Function0) null, new DeviceSettingsActivity$$ExternalSyntheticLambda19(deviceSettingsActivity), 1, (Object) null);
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit addOrEditHomeLocation$lambda$31$lambda$30(DeviceSettingsActivity deviceSettingsActivity) {
        ActivityResultLauncher<Intent> activityResultLauncher = deviceSettingsActivity.welcomeHomeLauncher;
        if (activityResultLauncher == null) {
            Intrinsics.throwUninitializedPropertyAccessException("welcomeHomeLauncher");
            activityResultLauncher = null;
        }
        Device device = deviceSettingsActivity.getViewModel().getDevice();
        Intrinsics.checkNotNull(device);
        activityResultLauncher.launch(WelcomeHomeConfigActivity.Companion.getLaunchIntent(deviceSettingsActivity, (HasWelcomeHome) device));
        return Unit.INSTANCE;
    }

    private final void bindViewModel() {
        ActivityDeviceSettingsBinding inflate = ActivityDeviceSettingsBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        setContentView((View) inflate.getRoot());
        DeviceDetailsViewModel viewModel = getViewModel();
        Device device = getViewModel().getDevice();
        Intrinsics.checkNotNull(device);
        viewModel.setDeviceId(device.getUid());
        DeviceConfigProvider deviceConfigProvider = DeviceConfigProvider.INSTANCE;
        Device device2 = getViewModel().getDevice();
        Intrinsics.checkNotNull(device2);
        this.userManual = deviceConfigProvider.getUserManual(device2);
        excludeCertainSettings();
        LifecycleOwner lifecycleOwner = this;
        LiveDataExtensionsKt.observeNonNull(getViewModel().getLiveDevices(), lifecycleOwner, new DeviceSettingsActivity$$ExternalSyntheticLambda30(this));
        LiveDataExtensionsKt.observeNonNull(getViewModel().getLiveDevice(), lifecycleOwner, new DeviceSettingsActivity$$ExternalSyntheticLambda1(this));
        getViewModel().getDeviceOffline().observe(lifecycleOwner, new DeviceSettingsActivityKt$sam$androidx_lifecycle_Observer$0(new DeviceSettingsActivity$$ExternalSyntheticLambda2(this)));
        Device device3 = getViewModel().getDevice();
        Intrinsics.checkNotNull(device3);
        if (device3 instanceof HasWelcomeHome) {
            DeviceWelcomeHomeViewModel welcomeHomeViewModel = getWelcomeHomeViewModel();
            Device device4 = getViewModel().getDevice();
            Intrinsics.checkNotNull(device4);
            welcomeHomeViewModel.setDevice((HasWelcomeHome) device4);
            getAdapter().setDeviceWelcomeHomeProvider(getWelcomeHomeViewModel());
            DeviceWelcomeHomeViewModel welcomeHomeViewModel2 = getWelcomeHomeViewModel();
            Device device5 = getViewModel().getDevice();
            Intrinsics.checkNotNull(device5);
            welcomeHomeViewModel2.getLiveDeviceWelcomeHome(device5.getUid()).observe(lifecycleOwner, new DeviceSettingsActivityKt$sam$androidx_lifecycle_Observer$0(new DeviceSettingsActivity$$ExternalSyntheticLambda3(this)));
            getWelcomeHomeViewModel().getWelcomeHomeExist().observe(lifecycleOwner, new DeviceSettingsActivityKt$sam$androidx_lifecycle_Observer$0(new DeviceSettingsActivity$$ExternalSyntheticLambda4(this)));
            getWelcomeHomeViewModel().getWelcomeHomeEnabled().observe(lifecycleOwner, new DeviceSettingsActivityKt$sam$androidx_lifecycle_Observer$0(new DeviceSettingsActivity$$ExternalSyntheticLambda5(this)));
            getWelcomeHomeViewModel().getRadius().observe(lifecycleOwner, new DeviceSettingsActivityKt$sam$androidx_lifecycle_Observer$0(new DeviceSettingsActivity$$ExternalSyntheticLambda6(this)));
        }
    }

    /* access modifiers changed from: private */
    public static final Unit bindViewModel$lambda$32(DeviceSettingsActivity deviceSettingsActivity, List list) {
        Intrinsics.checkNotNullParameter(list, "deviceList");
        DeviceSettingsAdapter adapter = deviceSettingsActivity.getAdapter();
        Collection arrayList = new ArrayList();
        for (Object next : list) {
            if (next instanceof DeviceAware) {
                arrayList.add(next);
            }
        }
        adapter.setAwares((List) arrayList);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit bindViewModel$lambda$33(DeviceSettingsActivity deviceSettingsActivity, Device device) {
        Timber.Forest forest = Timber.Forest;
        forest.d("liveDevice = " + device, new Object[0]);
        deviceSettingsActivity.getViewModel().setDevice(device);
        deviceSettingsActivity.getAdapter().setDevice(device);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit bindViewModel$lambda$34(DeviceSettingsActivity deviceSettingsActivity, Boolean bool) {
        DeviceSettingsAdapter adapter = deviceSettingsActivity.getAdapter();
        Intrinsics.checkNotNull(bool);
        adapter.setDeviceOffline(bool.booleanValue());
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit bindViewModel$lambda$35(DeviceSettingsActivity deviceSettingsActivity, WelcomeHomeLocation welcomeHomeLocation) {
        deviceSettingsActivity.getWelcomeHomeViewModel().loadHomeLocation(welcomeHomeLocation);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit bindViewModel$lambda$36(DeviceSettingsActivity deviceSettingsActivity, Boolean bool) {
        deviceSettingsActivity.updateWelcomeHome();
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit bindViewModel$lambda$37(DeviceSettingsActivity deviceSettingsActivity, Boolean bool) {
        deviceSettingsActivity.updateWelcomeHome();
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit bindViewModel$lambda$38(DeviceSettingsActivity deviceSettingsActivity, String str) {
        deviceSettingsActivity.updateWelcomeHome();
        return Unit.INSTANCE;
    }

    private final void excludeCertainSettings() {
        UserManual userManual2 = this.userManual;
        CharSequence link = userManual2 != null ? userManual2.getLink() : null;
        if (link == null || link.length() == 0) {
            getAdapter().addExcluedeSetting(DeviceSetting.USER_MANUAL.INSTANCE);
        }
        Device device = getViewModel().getDevice();
        Intrinsics.checkNotNull(device);
        if (!(device instanceof HasWelcomeHome) || !getViewModel().isInWelcomeHomeRegion()) {
            getAdapter().addExcluedeSetting(DeviceSetting.WELCOME_HOME.INSTANCE);
        }
    }

    private final void updateWelcomeHome() {
        ActivityDeviceSettingsBinding activityDeviceSettingsBinding = this.binding;
        if (activityDeviceSettingsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityDeviceSettingsBinding = null;
        }
        activityDeviceSettingsBinding.recyclerViewSettingsContainer.post(new DeviceSettingsActivity$$ExternalSyntheticLambda24(this));
    }

    /* access modifiers changed from: private */
    public static final void updateWelcomeHome$lambda$39(DeviceSettingsActivity deviceSettingsActivity) {
        deviceSettingsActivity.getAdapter().notifyItemChanged(DeviceSetting.WELCOME_HOME.INSTANCE);
    }

    /* access modifiers changed from: private */
    public final void checkForAutoModeTriggerUpdate() {
        Timber.Forest forest = Timber.Forest;
        forest.d("Setting onBackPressed called: auto selected = " + getAdapter().getAutoModeTriggerSelected() + " & g4 night mode selected = " + getAdapter().getG4NightModeTriggerSelected(), new Object[0]);
        Device device = getAdapter().getDevice();
        FilterTrigger autoModeTriggerSelected = getAdapter().getAutoModeTriggerSelected();
        FilterTrigger g4NightModeTriggerSelected = getAdapter().getG4NightModeTriggerSelected();
        if (device instanceof HasG4NightMode) {
            if (autoModeTriggerSelected != null || g4NightModeTriggerSelected != null) {
                if (autoModeTriggerSelected == null) {
                    autoModeTriggerSelected = ((HasG4NightMode) device).getTrigger();
                }
                if (g4NightModeTriggerSelected == null) {
                    g4NightModeTriggerSelected = ((HasG4NightMode) device).getG4NightModeTrigger();
                }
                Timber.Forest forest2 = Timber.Forest;
                forest2.d("Setting onBackPressed called: send auto selected = " + autoModeTriggerSelected + " & g4 night mode selected = " + g4NightModeTriggerSelected, new Object[0]);
                getViewModel().autoModeFilterTriggerChanged(autoModeTriggerSelected, g4NightModeTriggerSelected);
            }
        } else if ((device instanceof HasFanSpeed) && autoModeTriggerSelected != null) {
            getViewModel().autoModeFilterTriggerChanged(autoModeTriggerSelected);
        }
    }

    /* access modifiers changed from: private */
    public final void onErrorReportClicked() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        Class<DeviceErrorReportDialogFragment> cls = DeviceErrorReportDialogFragment.class;
        Intrinsics.checkNotNullExpressionValue("DeviceErrorReportDialogFragment", "getSimpleName(...)");
        if (!(supportFragmentManager.findFragmentByTag("DeviceErrorReportDialogFragment") instanceof DeviceErrorReportDialogFragment) && !supportFragmentManager.isStateSaved()) {
            DeviceErrorReportDialogFragment.Companion companion = DeviceErrorReportDialogFragment.Companion;
            Device device = getViewModel().getDevice();
            Intrinsics.checkNotNull(device);
            companion.newInstance(device).show(supportFragmentManager, "DeviceErrorReportDialogFragment");
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"Lcom/blueair/devicedetails/activity/DeviceSettingsActivity$Companion;", "", "<init>", "()V", "launch", "", "context", "Landroid/content/Context;", "device", "Lcom/blueair/core/model/Device;", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceSettingsActivity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void launch(Context context, Device device) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(device, "device");
            Intent intent = new Intent(context, DeviceSettingsActivity.class);
            intent.putExtra("device", device);
            context.startActivity(intent);
        }
    }
}
