package com.blueair.devicedetails.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.util.TypedValueCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.AirRefreshState;
import com.blueair.core.model.ApSubMode;
import com.blueair.core.model.DehSubMode;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceB4;
import com.blueair.core.model.DeviceB4sp;
import com.blueair.core.model.DeviceBlue40;
import com.blueair.core.model.DeviceCombo2in1;
import com.blueair.core.model.DeviceCombo2in120;
import com.blueair.core.model.DeviceCombo3in1;
import com.blueair.core.model.DeviceDehumidifier;
import com.blueair.core.model.DeviceFilterType;
import com.blueair.core.model.DeviceHumidifier;
import com.blueair.core.model.DeviceHumidifier20;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.DeviceMiniRestful;
import com.blueair.core.model.DevicePet20;
import com.blueair.core.model.FanSpeedEnum;
import com.blueair.core.model.HasAirRefresh;
import com.blueair.core.model.HasChildLock;
import com.blueair.core.model.HasG4NightMode;
import com.blueair.core.model.HasHumMainMode;
import com.blueair.core.model.HasTimer;
import com.blueair.core.model.HasWick;
import com.blueair.core.model.HumSubMode;
import com.blueair.core.model.MainMode;
import com.blueair.core.model.Mode;
import com.blueair.core.model.MoodLampEnum;
import com.blueair.core.model.TimerState;
import com.blueair.core.model.WickDryingGear;
import com.blueair.devicedetails.activity.AlarmListActivity;
import com.blueair.devicedetails.activity.DeviceFilterDetailActivity;
import com.blueair.devicedetails.activity.DeviceSettingsActivity;
import com.blueair.devicedetails.activity.ScheduleListActivity;
import com.blueair.devicedetails.adapter.DeviceControlsAdapter;
import com.blueair.devicedetails.databinding.FragmentDeviceControlsBinding;
import com.blueair.devicedetails.dialog.BuyFilterV2DialogFragment;
import com.blueair.devicedetails.dialog.DeviceTimerPickerV2DialogFragment;
import com.blueair.devicedetails.util.AttributeAction;
import com.blueair.devicedetails.util.DeviceControlGroup;
import com.blueair.devicedetails.util.DeviceControlUtils;
import com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel;
import com.blueair.devicedetails.viewmodel.DeviceSchedulesViewModel;
import com.blueair.viewcore.R;
import com.blueair.viewcore.dialog.ConfirmationDialogLeftAligned;
import com.blueair.viewcore.fragment.BaseFragment;
import com.blueair.viewcore.utils.SimpleSpacingDecoration;
import com.blueair.viewcore.view.ShadowedRecyclerViewLayout;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import com.blueair.viewcore.viewmodel.CustomViewModelStoreOwner;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.jacquessmuts.rxextensions.LazyPublishSubject;
import io.flatcircle.livedatahelper.LiveDataExtensionsKt;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import io.reactivex.subjects.PublishSubject;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import timber.log.Timber;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 K2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001KB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J$\u00104\u001a\u0002052\u0006\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u0001092\b\u0010:\u001a\u0004\u0018\u00010;H\u0016J\u001a\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u0002052\b\u0010:\u001a\u0004\u0018\u00010;H\u0016J\b\u0010?\u001a\u00020=H\u0016J\b\u0010@\u001a\u00020=H\u0002J*\u0010A\u001a\u00020=2\u0006\u0010B\u001a\u00020C2\n\u0010D\u001a\u0006\u0012\u0002\b\u00030\u00172\f\u0010E\u001a\b\u0012\u0004\u0012\u00020=0FH\u0002J\u0010\u0010G\u001a\u00020=2\u0006\u0010B\u001a\u00020CH\u0002J\u0010\u0010H\u001a\u00020=2\u0006\u0010I\u001a\u00020JH\u0016R\u001a\u0010\u0005\u001a\u00020\u0002X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0004¢\u0006\u0002\n\u0000R%\u0010\u0015\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00170\u00168BX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001c\u001a\u0010\u0012\f\u0012\n \u001d*\u0004\u0018\u00010\u00140\u00140\u0013X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u001e\u001a\u00020\u001f8BX\u0002¢\u0006\f\n\u0004\b\"\u0010\u000f\u001a\u0004\b \u0010!R\u001b\u0010#\u001a\u00020\u001f8BX\u0002¢\u0006\f\n\u0004\b%\u0010\u000f\u001a\u0004\b$\u0010!R\u001b\u0010&\u001a\u00020\u001f8BX\u0002¢\u0006\f\n\u0004\b(\u0010\u000f\u001a\u0004\b'\u0010!R\u001b\u0010)\u001a\u00020\u001f8BX\u0002¢\u0006\f\n\u0004\b+\u0010\u000f\u001a\u0004\b*\u0010!R\u001b\u0010,\u001a\u00020\u001f8BX\u0002¢\u0006\f\n\u0004\b.\u0010\u000f\u001a\u0004\b-\u0010!R!\u0010/\u001a\b\u0012\u0004\u0012\u00020\u001f008BX\u0002¢\u0006\f\n\u0004\b3\u0010\u000f\u001a\u0004\b1\u00102¨\u0006L"}, d2 = {"Lcom/blueair/devicedetails/fragment/DeviceControlsFragment;", "Lcom/blueair/viewcore/fragment/BaseFragment;", "Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;", "<init>", "()V", "viewModel", "getViewModel", "()Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;", "setViewModel", "(Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;)V", "schedulesViewModel", "Lcom/blueair/devicedetails/viewmodel/DeviceSchedulesViewModel;", "getSchedulesViewModel", "()Lcom/blueair/devicedetails/viewmodel/DeviceSchedulesViewModel;", "schedulesViewModel$delegate", "Lkotlin/Lazy;", "binding", "Lcom/blueair/devicedetails/databinding/FragmentDeviceControlsBinding;", "schedulePageLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "controlActionPublisher", "Lio/reactivex/subjects/PublishSubject;", "Lcom/blueair/devicedetails/util/AttributeAction;", "getControlActionPublisher", "()Lio/reactivex/subjects/PublishSubject;", "controlActionPublisher$delegate", "Lcom/jacquessmuts/rxextensions/LazyPublishSubject;", "filterDetailLauncher", "kotlin.jvm.PlatformType", "adapterMode", "Lcom/blueair/devicedetails/adapter/DeviceControlsAdapter;", "getAdapterMode", "()Lcom/blueair/devicedetails/adapter/DeviceControlsAdapter;", "adapterMode$delegate", "adapterControl", "getAdapterControl", "adapterControl$delegate", "adapterLight", "getAdapterLight", "adapterLight$delegate", "adapterSchedule", "getAdapterSchedule", "adapterSchedule$delegate", "adapterFilter", "getAdapterFilter", "adapterFilter$delegate", "adapters", "", "getAdapters", "()Ljava/util/List;", "adapters$delegate", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onResume", "showTimePickerDialog", "shouldDoDbAndApiCall", "device", "Lcom/blueair/core/model/Device;", "action", "call", "Lkotlin/Function0;", "checkWickDryingAndCancel", "showProgress", "shouldShowProgress", "", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceControlsFragment.kt */
public final class DeviceControlsFragment extends BaseFragment<DeviceDetailsViewModel> {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(DeviceControlsFragment.class, "controlActionPublisher", "getControlActionPublisher()Lio/reactivex/subjects/PublishSubject;", 0))};
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final Lazy adapterControl$delegate;
    private final Lazy adapterFilter$delegate;
    private final Lazy adapterLight$delegate;
    private final Lazy adapterMode$delegate;
    private final Lazy adapterSchedule$delegate;
    private final Lazy adapters$delegate;
    /* access modifiers changed from: private */
    public FragmentDeviceControlsBinding binding;
    private final LazyPublishSubject controlActionPublisher$delegate = new LazyPublishSubject();
    private final ActivityResultLauncher<Intent> filterDetailLauncher;
    private final ActivityResultLauncher<Intent> schedulePageLauncher;
    private final Lazy schedulesViewModel$delegate;
    public DeviceDetailsViewModel viewModel;

    /* access modifiers changed from: private */
    public static final void filterDetailLauncher$lambda$1(ActivityResult activityResult) {
    }

    public void showProgress(boolean z) {
    }

    public DeviceControlsFragment() {
        Fragment fragment = this;
        Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, new DeviceControlsFragment$special$$inlined$viewModels$default$2(new DeviceControlsFragment$special$$inlined$viewModels$default$1(fragment)));
        this.schedulesViewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(fragment, Reflection.getOrCreateKotlinClass(DeviceSchedulesViewModel.class), new DeviceControlsFragment$special$$inlined$viewModels$default$3(lazy), new DeviceControlsFragment$special$$inlined$viewModels$default$4((Function0) null, lazy), new DeviceControlsFragment$special$$inlined$viewModels$default$5(fragment, lazy));
        ActivityResultLauncher<Intent> registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new DeviceControlsFragment$$ExternalSyntheticLambda15(this));
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "registerForActivityResult(...)");
        this.schedulePageLauncher = registerForActivityResult;
        ActivityResultLauncher<Intent> registerForActivityResult2 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new DeviceControlsFragment$$ExternalSyntheticLambda16());
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult2, "registerForActivityResult(...)");
        this.filterDetailLauncher = registerForActivityResult2;
        this.adapterMode$delegate = LazyKt.lazy(new DeviceControlsFragment$$ExternalSyntheticLambda17(this));
        this.adapterControl$delegate = LazyKt.lazy(new DeviceControlsFragment$$ExternalSyntheticLambda18(this));
        this.adapterLight$delegate = LazyKt.lazy(new DeviceControlsFragment$$ExternalSyntheticLambda19(this));
        this.adapterSchedule$delegate = LazyKt.lazy(new DeviceControlsFragment$$ExternalSyntheticLambda20(this));
        this.adapterFilter$delegate = LazyKt.lazy(new DeviceControlsFragment$$ExternalSyntheticLambda21(this));
        this.adapters$delegate = LazyKt.lazy(new DeviceControlsFragment$$ExternalSyntheticLambda1(this));
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/devicedetails/fragment/DeviceControlsFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/fragment/DeviceControlsFragment;", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceControlsFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DeviceControlsFragment newInstance() {
            return new DeviceControlsFragment();
        }
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

    private final DeviceSchedulesViewModel getSchedulesViewModel() {
        return (DeviceSchedulesViewModel) this.schedulesViewModel$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final void schedulePageLauncher$lambda$0(DeviceControlsFragment deviceControlsFragment, ActivityResult activityResult) {
        deviceControlsFragment.getSchedulesViewModel().refreshDeviceSchedule(true);
    }

    private final PublishSubject<AttributeAction<?>> getControlActionPublisher() {
        return this.controlActionPublisher$delegate.getValue((Object) this, (KProperty<?>) $$delegatedProperties[0]);
    }

    /* access modifiers changed from: private */
    public static final DeviceControlsAdapter adapterMode_delegate$lambda$2(DeviceControlsFragment deviceControlsFragment) {
        return new DeviceControlsAdapter(DeviceControlGroup.MODE, deviceControlsFragment.getControlActionPublisher());
    }

    private final DeviceControlsAdapter getAdapterMode() {
        return (DeviceControlsAdapter) this.adapterMode$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final DeviceControlsAdapter adapterControl_delegate$lambda$3(DeviceControlsFragment deviceControlsFragment) {
        return new DeviceControlsAdapter(DeviceControlGroup.CONTROL, deviceControlsFragment.getControlActionPublisher());
    }

    private final DeviceControlsAdapter getAdapterControl() {
        return (DeviceControlsAdapter) this.adapterControl$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final DeviceControlsAdapter adapterLight_delegate$lambda$4(DeviceControlsFragment deviceControlsFragment) {
        return new DeviceControlsAdapter(DeviceControlGroup.LIGHT, deviceControlsFragment.getControlActionPublisher());
    }

    /* access modifiers changed from: private */
    public final DeviceControlsAdapter getAdapterLight() {
        return (DeviceControlsAdapter) this.adapterLight$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final DeviceControlsAdapter adapterSchedule_delegate$lambda$5(DeviceControlsFragment deviceControlsFragment) {
        return new DeviceControlsAdapter(DeviceControlGroup.SCHEDULE, deviceControlsFragment.getControlActionPublisher());
    }

    /* access modifiers changed from: private */
    public final DeviceControlsAdapter getAdapterSchedule() {
        return (DeviceControlsAdapter) this.adapterSchedule$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final DeviceControlsAdapter adapterFilter_delegate$lambda$6(DeviceControlsFragment deviceControlsFragment) {
        return new DeviceControlsAdapter(DeviceControlGroup.FILTER, deviceControlsFragment.getControlActionPublisher());
    }

    /* access modifiers changed from: private */
    public final DeviceControlsAdapter getAdapterFilter() {
        return (DeviceControlsAdapter) this.adapterFilter$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final List adapters_delegate$lambda$7(DeviceControlsFragment deviceControlsFragment) {
        return CollectionsKt.listOf(deviceControlsFragment.getAdapterMode(), deviceControlsFragment.getAdapterControl(), deviceControlsFragment.getAdapterLight(), deviceControlsFragment.getAdapterSchedule(), deviceControlsFragment.getAdapterFilter());
    }

    private final List<DeviceControlsAdapter> getAdapters() {
        return (List) this.adapters$delegate.getValue();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentDeviceControlsBinding inflate = FragmentDeviceControlsBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        BaseFragment baseFragment = this;
        setViewModel((DeviceDetailsViewModel) ((BaseViewModel) new ViewModelProvider((ViewModelStoreOwner) CustomViewModelStoreOwner.Companion.getDEVICE_DETAILS()).get(DeviceDetailsViewModel.class)));
        Device device = getViewModel().getDevice();
        if (device != null) {
            getSchedulesViewModel().setDevice(device);
            getSchedulesViewModel().refreshDeviceSchedule(false);
        }
        FragmentDeviceControlsBinding fragmentDeviceControlsBinding = this.binding;
        FragmentDeviceControlsBinding fragmentDeviceControlsBinding2 = null;
        if (fragmentDeviceControlsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentDeviceControlsBinding = null;
        }
        fragmentDeviceControlsBinding.rvModeButtons.setAdapter(getAdapterMode());
        FragmentDeviceControlsBinding fragmentDeviceControlsBinding3 = this.binding;
        if (fragmentDeviceControlsBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentDeviceControlsBinding3 = null;
        }
        fragmentDeviceControlsBinding3.rvModeButtons.setItemAnimator((RecyclerView.ItemAnimator) null);
        FragmentDeviceControlsBinding fragmentDeviceControlsBinding4 = this.binding;
        if (fragmentDeviceControlsBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentDeviceControlsBinding4 = null;
        }
        fragmentDeviceControlsBinding4.rvControlGroup.getRecyclerView().setAdapter(getAdapterControl());
        FragmentDeviceControlsBinding fragmentDeviceControlsBinding5 = this.binding;
        if (fragmentDeviceControlsBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentDeviceControlsBinding5 = null;
        }
        RecyclerView recyclerView = fragmentDeviceControlsBinding5.rvLightGroup;
        recyclerView.addItemDecoration(new SimpleSpacingDecoration(0, (int) TypedValueCompat.dpToPx(24.0f, recyclerView.getResources().getDisplayMetrics()), false, 4, (DefaultConstructorMarker) null));
        recyclerView.setAdapter(getAdapterLight());
        recyclerView.setItemAnimator((RecyclerView.ItemAnimator) null);
        FragmentDeviceControlsBinding fragmentDeviceControlsBinding6 = this.binding;
        if (fragmentDeviceControlsBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentDeviceControlsBinding6 = null;
        }
        fragmentDeviceControlsBinding6.rvScheduleGroup.setAdapter(getAdapterSchedule());
        FragmentDeviceControlsBinding fragmentDeviceControlsBinding7 = this.binding;
        if (fragmentDeviceControlsBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentDeviceControlsBinding7 = null;
        }
        fragmentDeviceControlsBinding7.rvScheduleGroup.setItemAnimator((RecyclerView.ItemAnimator) null);
        FragmentDeviceControlsBinding fragmentDeviceControlsBinding8 = this.binding;
        if (fragmentDeviceControlsBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentDeviceControlsBinding8 = null;
        }
        fragmentDeviceControlsBinding8.rvFilterGroup.getRecyclerView().setAdapter(getAdapterFilter());
        getAdapterControl().setOnItemCountChangedListener(new DeviceControlsFragment$$ExternalSyntheticLambda5(this));
        getAdapterFilter().setOnItemCountChangedListener(new DeviceControlsFragment$$ExternalSyntheticLambda6(this));
        getAdapterLight().setOnItemCountChangedListener(new DeviceControlsFragment$$ExternalSyntheticLambda7(this));
        FragmentDeviceControlsBinding fragmentDeviceControlsBinding9 = this.binding;
        if (fragmentDeviceControlsBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentDeviceControlsBinding9 = null;
        }
        fragmentDeviceControlsBinding9.btnCloseControlsHint.setOnClickListener(new DeviceControlsFragment$$ExternalSyntheticLambda8(this));
        FragmentDeviceControlsBinding fragmentDeviceControlsBinding10 = this.binding;
        if (fragmentDeviceControlsBinding10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentDeviceControlsBinding2 = fragmentDeviceControlsBinding10;
        }
        ConstraintLayout root = fragmentDeviceControlsBinding2.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateView$lambda$10(DeviceControlsFragment deviceControlsFragment) {
        FragmentDeviceControlsBinding fragmentDeviceControlsBinding = deviceControlsFragment.binding;
        if (fragmentDeviceControlsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentDeviceControlsBinding = null;
        }
        ShadowedRecyclerViewLayout shadowedRecyclerViewLayout = fragmentDeviceControlsBinding.rvControlGroup;
        Intrinsics.checkNotNullExpressionValue(shadowedRecyclerViewLayout, "rvControlGroup");
        ViewExtensionsKt.show(shadowedRecyclerViewLayout, deviceControlsFragment.getAdapterControl().getItemCount() > 0);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateView$lambda$11(DeviceControlsFragment deviceControlsFragment) {
        FragmentDeviceControlsBinding fragmentDeviceControlsBinding = deviceControlsFragment.binding;
        if (fragmentDeviceControlsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentDeviceControlsBinding = null;
        }
        ShadowedRecyclerViewLayout shadowedRecyclerViewLayout = fragmentDeviceControlsBinding.rvFilterGroup;
        Intrinsics.checkNotNullExpressionValue(shadowedRecyclerViewLayout, "rvFilterGroup");
        ViewExtensionsKt.show(shadowedRecyclerViewLayout, deviceControlsFragment.getAdapterFilter().getItemCount() > 0);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateView$lambda$12(DeviceControlsFragment deviceControlsFragment) {
        FragmentDeviceControlsBinding fragmentDeviceControlsBinding = deviceControlsFragment.binding;
        if (fragmentDeviceControlsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentDeviceControlsBinding = null;
        }
        RecyclerView recyclerView = fragmentDeviceControlsBinding.rvLightGroup;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "rvLightGroup");
        ViewExtensionsKt.show(recyclerView, deviceControlsFragment.getAdapterLight().getItemCount() > 0);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final void onCreateView$lambda$13(DeviceControlsFragment deviceControlsFragment, View view) {
        FragmentDeviceControlsBinding fragmentDeviceControlsBinding = deviceControlsFragment.binding;
        if (fragmentDeviceControlsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentDeviceControlsBinding = null;
        }
        ConstraintLayout constraintLayout = fragmentDeviceControlsBinding.controlsHintContainer;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "controlsHintContainer");
        ViewExtensionsKt.show(constraintLayout, false);
        deviceControlsFragment.getViewModel().setControlsHintClosedBefore(true);
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        super.onViewCreated(view, bundle);
        LiveData<Device> liveDevice = getViewModel().getLiveDevice();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        LiveDataExtensionsKt.observeNonNull(liveDevice, viewLifecycleOwner, new DeviceControlsFragment$$ExternalSyntheticLambda9(this));
        LiveData<Boolean> networkAvailable = getViewModel().getNetworkAvailable();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        LiveDataExtensionsKt.observeNonNull(networkAvailable, viewLifecycleOwner2, new DeviceControlsFragment$$ExternalSyntheticLambda10(this));
        getSchedulesViewModel().getSchedules().observe(getViewLifecycleOwner(), new DeviceControlsFragment$sam$androidx_lifecycle_Observer$0(new DeviceControlsFragment$$ExternalSyntheticLambda12(this)));
        if (DeviceControlUtils.INSTANCE.shouldShowTimer(getViewModel().getDevice()) || (getViewModel().getDevice() instanceof HasAirRefresh) || (getViewModel().getDevice() instanceof HasWick)) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), (CoroutineContext) null, (CoroutineStart) null, new DeviceControlsFragment$onViewCreated$4(this, (Continuation<? super DeviceControlsFragment$onViewCreated$4>) null), 3, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$15(DeviceControlsFragment deviceControlsFragment, Device device) {
        for (DeviceControlsAdapter device2 : deviceControlsFragment.getAdapters()) {
            device2.setDevice(device);
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$17(DeviceControlsFragment deviceControlsFragment, boolean z) {
        for (DeviceControlsAdapter forceOffline : deviceControlsFragment.getAdapters()) {
            forceOffline.setForceOffline(!z);
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$18(DeviceControlsFragment deviceControlsFragment, List list) {
        DeviceControlsAdapter adapterSchedule = deviceControlsFragment.getAdapterSchedule();
        Intrinsics.checkNotNull(list);
        adapterSchedule.notifySchedulesUpdate(list);
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x00b5, code lost:
        if (r0.equals(com.blueair.push.NotificationService.ACTION_TYPE_FILTER) == false) goto L_0x00cc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00be, code lost:
        if (r0.equals(com.blueair.push.NotificationService.ACTION_TYPE_FILTER_PURCHASE) != false) goto L_0x00c0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onResume() {
        /*
            r5 = this;
            super.onResume()
            com.blueair.devicedetails.adapter.DeviceControlsAdapter r0 = r5.getAdapterSchedule()
            com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel r1 = r5.getViewModel()
            boolean r1 = r1.getAutoRefreshHintClosedBefore()
            r0.setAutoRefreshHintClosedBefore(r1)
            com.blueair.devicedetails.adapter.DeviceControlsAdapter r0 = r5.getAdapterMode()
            com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel r1 = r5.getViewModel()
            boolean r1 = r1.getHumHintClosedBefore()
            r0.setHumHintClosedBefore(r1)
            com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel r0 = r5.getViewModel()
            boolean r0 = r0.getSkinHintClosedBefore()
            if (r0 == 0) goto L_0x0032
            com.blueair.devicedetails.adapter.DeviceControlsAdapter r0 = r5.getAdapterMode()
            r0.markSkinHintClosedBefore()
        L_0x0032:
            com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel r0 = r5.getViewModel()
            boolean r0 = r0.getSmartHintClosedBefore()
            if (r0 == 0) goto L_0x0043
            com.blueair.devicedetails.adapter.DeviceControlsAdapter r0 = r5.getAdapterMode()
            r0.markSmartHintClosedBefore()
        L_0x0043:
            io.reactivex.disposables.CompositeDisposable r0 = r5.getRxSubs()
            io.reactivex.subjects.PublishSubject r1 = r5.getControlActionPublisher()
            io.reactivex.Observable r1 = (io.reactivex.Observable) r1
            com.blueair.devicedetails.fragment.DeviceControlsFragment$$ExternalSyntheticLambda0 r2 = new com.blueair.devicedetails.fragment.DeviceControlsFragment$$ExternalSyntheticLambda0
            r2.<init>(r5)
            io.reactivex.disposables.Disposable r1 = com.jacquessmuts.rxextensions.RxExtensionsKt.subscribeAndLogE(r1, r2)
            r0.add(r1)
            io.reactivex.disposables.CompositeDisposable r0 = r5.getRxSubs()
            io.reactivex.subjects.PublishSubject r1 = r5.getControlActionPublisher()
            r2 = 300(0x12c, double:1.48E-321)
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.MILLISECONDS
            io.reactivex.Observable r1 = r1.throttleLatest(r2, r4)
            java.lang.String r2 = "throttleLatest(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            com.blueair.devicedetails.fragment.DeviceControlsFragment$$ExternalSyntheticLambda11 r2 = new com.blueair.devicedetails.fragment.DeviceControlsFragment$$ExternalSyntheticLambda11
            r2.<init>(r5)
            io.reactivex.disposables.Disposable r1 = com.jacquessmuts.rxextensions.RxExtensionsKt.subscribeAndLogE(r1, r2)
            r0.add(r1)
            com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel r0 = r5.getViewModel()
            java.lang.String r0 = r0.getActionType()
            if (r0 == 0) goto L_0x00cc
            int r1 = r0.hashCode()
            r2 = -2123968024(0xffffffff8166d1e8, float:-4.2394929E-38)
            r3 = 0
            if (r1 == r2) goto L_0x00b8
            r2 = -1274492040(0xffffffffb408cb78, float:-1.2740009E-7)
            if (r1 == r2) goto L_0x00af
            r2 = 590772454(0x233678e6, float:9.891841E-18)
            if (r1 == r2) goto L_0x0099
            goto L_0x00cc
        L_0x0099:
            java.lang.String r1 = "wick_purchase"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00a2
            goto L_0x00cc
        L_0x00a2:
            io.reactivex.subjects.PublishSubject r0 = r5.getControlActionPublisher()
            com.blueair.devicedetails.util.AttributeAction$OpenWickPageAction r1 = new com.blueair.devicedetails.util.AttributeAction$OpenWickPageAction
            r1.<init>(r3)
            r0.onNext(r1)
            goto L_0x00cc
        L_0x00af:
            java.lang.String r1 = "filter"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00c0
            goto L_0x00cc
        L_0x00b8:
            java.lang.String r1 = "filter_purchase"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x00cc
        L_0x00c0:
            io.reactivex.subjects.PublishSubject r0 = r5.getControlActionPublisher()
            com.blueair.devicedetails.util.AttributeAction$OpenFilterPageAction r1 = new com.blueair.devicedetails.util.AttributeAction$OpenFilterPageAction
            r1.<init>(r3)
            r0.onNext(r1)
        L_0x00cc:
            com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel r0 = r5.getViewModel()
            r1 = 0
            r0.setActionType(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.fragment.DeviceControlsFragment.onResume():void");
    }

    /* access modifiers changed from: private */
    public static final Unit onResume$lambda$19(DeviceControlsFragment deviceControlsFragment, AttributeAction attributeAction) {
        if (attributeAction instanceof AttributeAction.AutoRhShowHintAction) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(deviceControlsFragment, Dispatchers.getMain(), (CoroutineStart) null, new DeviceControlsFragment$onResume$1$1(attributeAction, deviceControlsFragment, (Continuation<? super DeviceControlsFragment$onResume$1$1>) null), 2, (Object) null);
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onResume$lambda$39(DeviceControlsFragment deviceControlsFragment, AttributeAction attributeAction) {
        Timber.Forest forest = Timber.Forest;
        forest.v("throttleLatest action: " + attributeAction, new Object[0]);
        Device device = deviceControlsFragment.getViewModel().getDevice();
        if (device != null) {
            Intrinsics.checkNotNull(attributeAction);
            deviceControlsFragment.shouldDoDbAndApiCall(device, attributeAction, new DeviceControlsFragment$$ExternalSyntheticLambda14(attributeAction, deviceControlsFragment, device));
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onResume$lambda$39$lambda$38$lambda$37(AttributeAction attributeAction, DeviceControlsFragment deviceControlsFragment, Device device) {
        int i;
        AttributeAction attributeAction2 = attributeAction;
        DeviceControlsFragment deviceControlsFragment2 = deviceControlsFragment;
        Device device2 = device;
        if (attributeAction2 instanceof AttributeAction.MainModeAction) {
            deviceControlsFragment2.getViewModel().setMainMode(device2, ((MainMode) ((AttributeAction.MainModeAction) attributeAction2).getValue()).getValue());
        } else if (attributeAction2 instanceof AttributeAction.ApSubModeAction) {
            deviceControlsFragment2.getViewModel().setApSubMode(device2, ((ApSubMode) ((AttributeAction.ApSubModeAction) attributeAction2).getValue()).getValue(), device2 instanceof DevicePet20);
        } else if (attributeAction2 instanceof AttributeAction.DehSubModeAction) {
            deviceControlsFragment2.getViewModel().setDehSubMode(device2, ((DehSubMode) ((AttributeAction.DehSubModeAction) attributeAction2).getValue()).getValue());
        } else if (attributeAction2 instanceof AttributeAction.ModeAction) {
            deviceControlsFragment2.getViewModel().setMode(device2, ((Mode) ((AttributeAction.ModeAction) attributeAction2).getValue()).getValue());
        } else if (attributeAction2 instanceof AttributeAction.FanSpeedAction) {
            deviceControlsFragment2.getViewModel().fanspeedSliderChanged(device2, (FanSpeedEnum) ((AttributeAction.FanSpeedAction) attributeAction2).getValue());
        } else if (attributeAction2 instanceof AttributeAction.BrightnessPercentageAction) {
            deviceControlsFragment2.getViewModel().brightnessChanged(device2, ((Number) ((AttributeAction.BrightnessPercentageAction) attributeAction2).getValue()).intValue());
        } else if (attributeAction2 instanceof AttributeAction.AutoRefreshInfoAction) {
            FragmentManager childFragmentManager = deviceControlsFragment2.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
            Class<ConfirmationDialogLeftAligned> cls = ConfirmationDialogLeftAligned.class;
            Intrinsics.checkNotNullExpressionValue("ConfirmationDialogLeftAligned", "getSimpleName(...)");
            if (!(childFragmentManager.findFragmentByTag("ConfirmationDialogLeftAligned") instanceof ConfirmationDialogLeftAligned) && !childFragmentManager.isStateSaved()) {
                ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, R.string.auto_refresh, (Integer) null, R.string.auto_refresh_info, Integer.valueOf(R.string.btn_goto_settings), (Integer) null, false, true, false, false, (String[]) null, (String) null, new DeviceControlsFragment$$ExternalSyntheticLambda2(deviceControlsFragment2), 1824, (Object) null).show(childFragmentManager, "ConfirmationDialogLeftAligned");
            }
        } else if (attributeAction2 instanceof AttributeAction.AutoRefreshCancelAction) {
            deviceControlsFragment2.getViewModel().setAutoRefreshStatus(device2, AirRefreshState.CANCEL.getValue());
        } else if (attributeAction2 instanceof AttributeAction.AutoRefreshHintClosedAction) {
            deviceControlsFragment2.getViewModel().setAutoRefreshHintClosedBefore(true);
            deviceControlsFragment2.getAdapterSchedule().setAutoRefreshHintClosedBefore(true);
            Unit unit = Unit.INSTANCE;
        } else if (attributeAction2 instanceof AttributeAction.AutoRhInfoAction) {
            int i2 = device2 instanceof DeviceCombo2in120 ? R.string.target_humidity_info_2in120 : R.string.target_humidity_info_v2;
            FragmentManager childFragmentManager2 = deviceControlsFragment2.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager2, "getChildFragmentManager(...)");
            Class<ConfirmationDialogLeftAligned> cls2 = ConfirmationDialogLeftAligned.class;
            Intrinsics.checkNotNullExpressionValue("ConfirmationDialogLeftAligned", "getSimpleName(...)");
            if (!(childFragmentManager2.findFragmentByTag("ConfirmationDialogLeftAligned") instanceof ConfirmationDialogLeftAligned) && !childFragmentManager2.isStateSaved()) {
                ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, R.string.target_humidity, (Integer) null, i2, Integer.valueOf(R.string.snackbar_ok), (Integer) null, false, false, false, false, (String[]) null, (String) null, (Function1) null, 3936, (Object) null).show(childFragmentManager2, "ConfirmationDialogLeftAligned");
            }
        } else if (attributeAction2 instanceof AttributeAction.AutoRhAction) {
            deviceControlsFragment2.getViewModel().autorhChanged(device2, ((Number) ((AttributeAction.AutoRhAction) attributeAction2).getValue()).intValue());
        } else if (attributeAction2 instanceof AttributeAction.ChildLockAction) {
            if ((device2 instanceof HasChildLock ? (HasChildLock) device2 : null) != null) {
                HasChildLock hasChildLock = (HasChildLock) device2;
                if (hasChildLock.isChildLockOn()) {
                    deviceControlsFragment2.getViewModel().childLockChanged(device2);
                } else {
                    if (hasChildLock instanceof DeviceMiniRestful) {
                        i = R.string.display_lock_instructions_mini;
                    } else if ((hasChildLock instanceof DeviceBlue40) || (hasChildLock instanceof DevicePet20) || (hasChildLock instanceof DeviceHumidifier20)) {
                        i = R.string.display_lock_instructions_v2;
                    } else if ((hasChildLock instanceof DeviceHumidifier) || (hasChildLock instanceof DeviceCombo2in120)) {
                        i = R.string.display_lock_instructions_v3;
                    } else if ((hasChildLock instanceof DeviceB4) || (hasChildLock instanceof DeviceB4sp)) {
                        i = R.string.display_lock_instructions_v4;
                    } else {
                        i = R.string.display_lock_instructions;
                    }
                    int i3 = i;
                    FragmentManager childFragmentManager3 = deviceControlsFragment2.getChildFragmentManager();
                    Intrinsics.checkNotNullExpressionValue(childFragmentManager3, "getChildFragmentManager(...)");
                    Class<ConfirmationDialogLeftAligned> cls3 = ConfirmationDialogLeftAligned.class;
                    Intrinsics.checkNotNullExpressionValue("ConfirmationDialogLeftAligned", "getSimpleName(...)");
                    if (!(childFragmentManager3.findFragmentByTag("ConfirmationDialogLeftAligned") instanceof ConfirmationDialogLeftAligned) && !childFragmentManager3.isStateSaved()) {
                        ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, R.string.lock_device_ui, (Integer) null, i3, Integer.valueOf(R.string.confirm), Integer.valueOf(R.string.btn_cancel), false, false, false, false, (String[]) null, (String) null, new DeviceControlsFragment$$ExternalSyntheticLambda3(deviceControlsFragment2, device2), 1888, (Object) null).show(childFragmentManager3, "ConfirmationDialogLeftAligned");
                    }
                }
                Unit unit2 = Unit.INSTANCE;
                Unit unit3 = Unit.INSTANCE;
            }
        } else if (attributeAction2 instanceof AttributeAction.OpenDeviceSchedulesAction) {
            Context context = deviceControlsFragment2.getContext();
            if (context != null) {
                deviceControlsFragment2.schedulePageLauncher.launch(ScheduleListActivity.Companion.intent(context, device2));
                Unit unit4 = Unit.INSTANCE;
                Unit unit5 = Unit.INSTANCE;
            }
        } else if (attributeAction2 instanceof AttributeAction.OpenDeviceSettingsAction) {
            Context context2 = deviceControlsFragment2.getContext();
            if (context2 != null) {
                Intent intent = new Intent(context2, DeviceSettingsActivity.class);
                intent.putExtra("device", device2);
                deviceControlsFragment2.startActivity(intent);
                Unit unit6 = Unit.INSTANCE;
                Unit unit7 = Unit.INSTANCE;
            }
        } else if (attributeAction2 instanceof AttributeAction.OpenFilterInfoAction) {
            FragmentManager childFragmentManager4 = deviceControlsFragment2.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager4, "getChildFragmentManager(...)");
            Class<ConfirmationDialogLeftAligned> cls4 = ConfirmationDialogLeftAligned.class;
            Intrinsics.checkNotNullExpressionValue("ConfirmationDialogLeftAligned", "getSimpleName(...)");
            if (!(childFragmentManager4.findFragmentByTag("ConfirmationDialogLeftAligned") instanceof ConfirmationDialogLeftAligned) && !childFragmentManager4.isStateSaved()) {
                ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, R.string.label_real_track_tech, (Integer) null, R.string.real_track_instruction, Integer.valueOf(R.string.confirmation_positive_default), (Integer) null, false, false, false, false, (String[]) null, (String) null, (Function1) null, 3936, (Object) null).show(childFragmentManager4, "ConfirmationDialogLeftAligned");
            }
        } else if (attributeAction2 instanceof AttributeAction.OpenWickInfoAction) {
            FragmentManager childFragmentManager5 = deviceControlsFragment2.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager5, "getChildFragmentManager(...)");
            Class<ConfirmationDialogLeftAligned> cls5 = ConfirmationDialogLeftAligned.class;
            Intrinsics.checkNotNullExpressionValue("ConfirmationDialogLeftAligned", "getSimpleName(...)");
            if (!(childFragmentManager5.findFragmentByTag("ConfirmationDialogLeftAligned") instanceof ConfirmationDialogLeftAligned) && !childFragmentManager5.isStateSaved()) {
                ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, R.string.wick_maintenance, (Integer) null, R.string.wick_maintenance_description, Integer.valueOf(R.string.confirmation_positive_default), (Integer) null, false, false, false, false, (String[]) null, (String) null, (Function1) null, 3936, (Object) null).show(childFragmentManager5, "ConfirmationDialogLeftAligned");
            }
        } else if (attributeAction2 instanceof AttributeAction.OpenCubeInfoAction) {
            FragmentManager childFragmentManager6 = deviceControlsFragment2.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager6, "getChildFragmentManager(...)");
            Class<ConfirmationDialogLeftAligned> cls6 = ConfirmationDialogLeftAligned.class;
            Intrinsics.checkNotNullExpressionValue("ConfirmationDialogLeftAligned", "getSimpleName(...)");
            if (!(childFragmentManager6.findFragmentByTag("ConfirmationDialogLeftAligned") instanceof ConfirmationDialogLeftAligned) && !childFragmentManager6.isStateSaved()) {
                ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, R.string.label_water_refresher, (Integer) null, R.string.water_refresher_instructions, (Integer) null, (Integer) null, false, false, false, false, (String[]) null, (String) null, (Function1) null, 3936, (Object) null).show(childFragmentManager6, "ConfirmationDialogLeftAligned");
            }
        } else if (attributeAction2 instanceof AttributeAction.OpenFilterPageAction) {
            if (((Boolean) ((AttributeAction.OpenFilterPageAction) attributeAction2).getValue()).booleanValue()) {
                FragmentManager childFragmentManager7 = deviceControlsFragment2.getChildFragmentManager();
                Intrinsics.checkNotNullExpressionValue(childFragmentManager7, "getChildFragmentManager(...)");
                Class<BuyFilterV2DialogFragment> cls7 = BuyFilterV2DialogFragment.class;
                Intrinsics.checkNotNullExpressionValue("BuyFilterV2DialogFragment", "getSimpleName(...)");
                if (!(childFragmentManager7.findFragmentByTag("BuyFilterV2DialogFragment") instanceof BuyFilterV2DialogFragment) && !childFragmentManager7.isStateSaved()) {
                    BuyFilterV2DialogFragment.Companion.newInstance$default(BuyFilterV2DialogFragment.Companion, device, (String) null, DeviceFilterType.FILTER, false, (String) null, 24, (Object) null).show(childFragmentManager7, "BuyFilterV2DialogFragment");
                }
            } else {
                ActivityResultLauncher<Intent> activityResultLauncher = deviceControlsFragment2.filterDetailLauncher;
                DeviceFilterDetailActivity.Companion companion = DeviceFilterDetailActivity.Companion;
                Context requireContext = deviceControlsFragment2.requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
                activityResultLauncher.launch(DeviceFilterDetailActivity.Companion.getLaunchIntent$default(companion, requireContext, device, (String) null, DeviceFilterType.FILTER, false, 16, (Object) null));
                Unit unit8 = Unit.INSTANCE;
            }
        } else if (attributeAction2 instanceof AttributeAction.OpenWickPageAction) {
            if (((Boolean) ((AttributeAction.OpenWickPageAction) attributeAction2).getValue()).booleanValue()) {
                FragmentManager childFragmentManager8 = deviceControlsFragment2.getChildFragmentManager();
                Intrinsics.checkNotNullExpressionValue(childFragmentManager8, "getChildFragmentManager(...)");
                Class<BuyFilterV2DialogFragment> cls8 = BuyFilterV2DialogFragment.class;
                Intrinsics.checkNotNullExpressionValue("BuyFilterV2DialogFragment", "getSimpleName(...)");
                if (!(childFragmentManager8.findFragmentByTag("BuyFilterV2DialogFragment") instanceof BuyFilterV2DialogFragment) && !childFragmentManager8.isStateSaved()) {
                    BuyFilterV2DialogFragment.Companion.newInstance$default(BuyFilterV2DialogFragment.Companion, device, (String) null, DeviceFilterType.WICK, false, (String) null, 24, (Object) null).show(childFragmentManager8, "BuyFilterV2DialogFragment");
                }
            } else {
                ActivityResultLauncher<Intent> activityResultLauncher2 = deviceControlsFragment2.filterDetailLauncher;
                DeviceFilterDetailActivity.Companion companion2 = DeviceFilterDetailActivity.Companion;
                Context requireContext2 = deviceControlsFragment2.requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext(...)");
                activityResultLauncher2.launch(DeviceFilterDetailActivity.Companion.getLaunchIntent$default(companion2, requireContext2, device, (String) null, DeviceFilterType.WICK, false, 16, (Object) null));
                Unit unit9 = Unit.INSTANCE;
            }
        } else if (!(attributeAction2 instanceof AttributeAction.OpenCubePageAction)) {
            Device device3 = device;
            if (attributeAction2 instanceof AttributeAction.DisinfectionModeAction) {
                deviceControlsFragment2.getViewModel().disinfectionChanged(device3);
            } else if (attributeAction2 instanceof AttributeAction.AutoModeAction) {
                deviceControlsFragment.checkWickDryingAndCancel(device);
                if (DeviceKt.isCancellable(device3) || ((Boolean) ((AttributeAction.AutoModeAction) attributeAction2).getValue()).booleanValue()) {
                    deviceControlsFragment2.getViewModel().autoModeChanged(device3, ((Boolean) ((AttributeAction.AutoModeAction) attributeAction2).getValue()).booleanValue());
                }
                Unit unit10 = Unit.INSTANCE;
            } else if (attributeAction2 instanceof AttributeAction.EcoModeAction) {
                deviceControlsFragment2.getViewModel().ecoModeChanged(device3);
            } else if (attributeAction2 instanceof AttributeAction.ManualModeAction) {
                deviceControlsFragment.checkWickDryingAndCancel(device);
                deviceControlsFragment2.getViewModel().setManualMode(device3);
            } else if (attributeAction2 instanceof AttributeAction.NightModeAction) {
                deviceControlsFragment.checkWickDryingAndCancel(device);
                if ((device3 instanceof HasG4NightMode) && (DeviceKt.isCancellable(device3) || !((HasG4NightMode) device3).isG4NightModeOn())) {
                    deviceControlsFragment2.getViewModel().g4NightModeChanged(device3);
                }
                Unit unit11 = Unit.INSTANCE;
            } else if (attributeAction2 instanceof AttributeAction.TimerStateAction) {
                deviceControlsFragment2.getViewModel().timerStatusChanged(device3, ((TimerState) ((AttributeAction.TimerStateAction) attributeAction2).getValue()).getValue());
            } else if (attributeAction2 instanceof AttributeAction.SelectTimerDurationAction) {
                deviceControlsFragment2.showTimePickerDialog();
                Unit unit12 = Unit.INSTANCE;
            } else if (attributeAction2 instanceof AttributeAction.MoodLampAction) {
                deviceControlsFragment2.getViewModel().setNightLampBrightness(device3, ((MoodLampEnum) ((AttributeAction.MoodLampAction) attributeAction2).getValue()).toServerValue());
            } else if (attributeAction2 instanceof AttributeAction.NightLampAction) {
                deviceControlsFragment2.getViewModel().setNightLampSteplessBrightness(device3, ((Number) ((AttributeAction.NightLampAction) attributeAction2).getValue()).intValue());
            } else if (attributeAction2 instanceof AttributeAction.WickDryingInfoAction) {
                int i4 = device3 instanceof DeviceCombo2in120 ? R.string.wick_drying_info_2in120 : R.string.wick_drying_info;
                FragmentManager childFragmentManager9 = deviceControlsFragment2.getChildFragmentManager();
                Intrinsics.checkNotNullExpressionValue(childFragmentManager9, "getChildFragmentManager(...)");
                Class<ConfirmationDialogLeftAligned> cls9 = ConfirmationDialogLeftAligned.class;
                Intrinsics.checkNotNullExpressionValue("ConfirmationDialogLeftAligned", "getSimpleName(...)");
                if (!(childFragmentManager9.findFragmentByTag("ConfirmationDialogLeftAligned") instanceof ConfirmationDialogLeftAligned) && !childFragmentManager9.isStateSaved()) {
                    ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, R.string.label_wick_drying, (Integer) null, i4, Integer.valueOf(R.string.snackbar_ok), (Integer) null, false, false, false, false, (String[]) null, (String) null, (Function1) null, 3936, (Object) null).show(childFragmentManager9, "ConfirmationDialogLeftAligned");
                }
            } else if (attributeAction2 instanceof AttributeAction.WickDryingAction) {
                AttributeAction.WickDryingAction wickDryingAction = (AttributeAction.WickDryingAction) attributeAction2;
                if (wickDryingAction.getValue() == WickDryingGear.OFF) {
                    deviceControlsFragment2.getViewModel().wickDryCanceled(device3);
                } else {
                    deviceControlsFragment2.getViewModel().updateWickDryDurationAndRestart(device3, ((WickDryingGear) wickDryingAction.getValue()).getDuration());
                }
            } else if (attributeAction2 instanceof AttributeAction.OpenDeviceAlarmsAction) {
                AlarmListActivity.Companion companion3 = AlarmListActivity.Companion;
                Context requireContext3 = deviceControlsFragment2.requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext3, "requireContext(...)");
                companion3.launch(requireContext3);
                Unit unit13 = Unit.INSTANCE;
            } else if (attributeAction2 instanceof AttributeAction.OpenDryModeInfoAction) {
                FragmentManager childFragmentManager10 = deviceControlsFragment2.getChildFragmentManager();
                Intrinsics.checkNotNullExpressionValue(childFragmentManager10, "getChildFragmentManager(...)");
                Class<ConfirmationDialogLeftAligned> cls10 = ConfirmationDialogLeftAligned.class;
                Intrinsics.checkNotNullExpressionValue("ConfirmationDialogLeftAligned", "getSimpleName(...)");
                if (!(childFragmentManager10.findFragmentByTag("ConfirmationDialogLeftAligned") instanceof ConfirmationDialogLeftAligned) && !childFragmentManager10.isStateSaved()) {
                    ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, R.string.label_auto_dry, (Integer) null, R.string.auto_dry_instructions, Integer.valueOf(R.string.btn_goto_settings), (Integer) null, false, true, false, false, (String[]) null, (String) null, new DeviceControlsFragment$$ExternalSyntheticLambda4(deviceControlsFragment2), 1824, (Object) null).show(childFragmentManager10, "ConfirmationDialogLeftAligned");
                }
            } else if (attributeAction2 instanceof AttributeAction.DryModeCancelAction) {
                deviceControlsFragment2.getViewModel().wickDryCanceled(device3);
            } else if (attributeAction2 instanceof AttributeAction.HumModeAction) {
                if (!(device3 instanceof HasHumMainMode)) {
                    deviceControlsFragment2.getViewModel().humModeChanged(device3);
                } else if (((HasHumMainMode) device3).isInMainMode(MainMode.Humidification)) {
                    deviceControlsFragment2.getViewModel().setMainMode(device3, MainMode.AirPurify.getValue());
                } else {
                    deviceControlsFragment2.getViewModel().setMainMode(device3, MainMode.Humidification.getValue());
                }
            } else if (attributeAction2 instanceof AttributeAction.CloseHumHintAction) {
                deviceControlsFragment2.getViewModel().setHumHintClosedBefore(true);
                deviceControlsFragment2.getAdapterMode().setHumHintClosedBefore(true);
                Unit unit14 = Unit.INSTANCE;
            } else if (attributeAction2 instanceof AttributeAction.CloseSkinHintAction) {
                deviceControlsFragment2.getViewModel().setSkinHintClosedBefore(true);
                Unit unit15 = Unit.INSTANCE;
            } else if (attributeAction2 instanceof AttributeAction.CloseSmartHintAction) {
                deviceControlsFragment2.getViewModel().setSmartHintClosedBefore(true);
                Unit unit16 = Unit.INSTANCE;
            } else if (attributeAction2 instanceof AttributeAction.HumSubModeAction) {
                AttributeAction.HumSubModeAction humSubModeAction = (AttributeAction.HumSubModeAction) attributeAction2;
                if (humSubModeAction.getValue() == HumSubMode.AUTO) {
                    DeviceDetailsViewModel.setApSubMode$default(deviceControlsFragment2.getViewModel(), device3, ApSubMode.AUTO.getValue(), false, 4, (Object) null);
                } else {
                    deviceControlsFragment2.getViewModel().setHumSubMode(device3, ((HumSubMode) humSubModeAction.getValue()).getValue());
                }
            } else {
                Unit unit17 = Unit.INSTANCE;
            }
        } else if (((Boolean) ((AttributeAction.OpenCubePageAction) attributeAction2).getValue()).booleanValue()) {
            FragmentManager childFragmentManager11 = deviceControlsFragment2.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager11, "getChildFragmentManager(...)");
            Class<BuyFilterV2DialogFragment> cls11 = BuyFilterV2DialogFragment.class;
            Intrinsics.checkNotNullExpressionValue("BuyFilterV2DialogFragment", "getSimpleName(...)");
            if (!(childFragmentManager11.findFragmentByTag("BuyFilterV2DialogFragment") instanceof BuyFilterV2DialogFragment) && !childFragmentManager11.isStateSaved()) {
                BuyFilterV2DialogFragment.Companion.newInstance$default(BuyFilterV2DialogFragment.Companion, device, (String) null, DeviceFilterType.REFRESHER, false, (String) null, 24, (Object) null).show(childFragmentManager11, "BuyFilterV2DialogFragment");
            }
        } else {
            ActivityResultLauncher<Intent> activityResultLauncher3 = deviceControlsFragment2.filterDetailLauncher;
            DeviceFilterDetailActivity.Companion companion4 = DeviceFilterDetailActivity.Companion;
            Context requireContext4 = deviceControlsFragment2.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext4, "requireContext(...)");
            activityResultLauncher3.launch(DeviceFilterDetailActivity.Companion.getLaunchIntent$default(companion4, requireContext4, device, (String) null, DeviceFilterType.REFRESHER, false, 16, (Object) null));
            Unit unit18 = Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onResume$lambda$39$lambda$38$lambda$37$lambda$21$lambda$20(DeviceControlsFragment deviceControlsFragment, boolean z) {
        if (z) {
            deviceControlsFragment.getControlActionPublisher().onNext(AttributeAction.OpenDeviceSettingsAction.INSTANCE);
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onResume$lambda$39$lambda$38$lambda$37$lambda$25$lambda$24$lambda$23(DeviceControlsFragment deviceControlsFragment, Device device, boolean z) {
        if (z) {
            deviceControlsFragment.getViewModel().childLockChanged(device);
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onResume$lambda$39$lambda$38$lambda$37$lambda$36$lambda$35(DeviceControlsFragment deviceControlsFragment, boolean z) {
        if (z) {
            deviceControlsFragment.getControlActionPublisher().onNext(AttributeAction.OpenDeviceSettingsAction.INSTANCE);
        }
        return Unit.INSTANCE;
    }

    private final void showTimePickerDialog() {
        Context context;
        Device device = getViewModel().getDevice();
        DialogFragment dialogFragment = null;
        HasTimer hasTimer = device instanceof HasTimer ? (HasTimer) device : null;
        if (hasTimer != null && (context = getContext()) != null) {
            String string = context.getString(R.string.label_stay_on_for);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            int i = 24;
            if (!(hasTimer instanceof DeviceDehumidifier) && !(hasTimer instanceof DevicePet20) && !(hasTimer instanceof DeviceCombo2in1) && !(hasTimer instanceof DeviceCombo3in1) && !DeviceKt.useV2UI(hasTimer)) {
                i = 12;
            }
            FragmentManager childFragmentManager = getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
            Class<DeviceTimerPickerV2DialogFragment> cls = DeviceTimerPickerV2DialogFragment.class;
            Intrinsics.checkNotNullExpressionValue("DeviceTimerPickerV2DialogFragment", "getSimpleName(...)");
            if (!(childFragmentManager.findFragmentByTag("DeviceTimerPickerV2DialogFragment") instanceof DeviceTimerPickerV2DialogFragment) && !childFragmentManager.isStateSaved()) {
                DeviceTimerPickerV2DialogFragment newInstance = DeviceTimerPickerV2DialogFragment.Companion.newInstance(string, i, hasTimer.getTimerDuration(), true);
                newInstance.setOnPickResult(new DeviceControlsFragment$$ExternalSyntheticLambda13(this, hasTimer));
                dialogFragment = newInstance;
                dialogFragment.show(childFragmentManager, "DeviceTimerPickerV2DialogFragment");
            }
            DeviceTimerPickerV2DialogFragment deviceTimerPickerV2DialogFragment = (DeviceTimerPickerV2DialogFragment) dialogFragment;
        }
    }

    /* access modifiers changed from: private */
    public static final Unit showTimePickerDialog$lambda$43$lambda$42$lambda$41$lambda$40(DeviceControlsFragment deviceControlsFragment, HasTimer hasTimer, int i) {
        deviceControlsFragment.getViewModel().updateTimerDurationAndRestart(hasTimer, i);
        return Unit.INSTANCE;
    }

    private final void shouldDoDbAndApiCall(Device device, AttributeAction<?> attributeAction, Function0<Unit> function0) {
        function0.invoke();
    }

    private final void checkWickDryingAndCancel(Device device) {
        if ((device instanceof DeviceHumidifier20) && ((DeviceHumidifier20) device).getWickdryOn()) {
            getViewModel().wickDryCanceled(device);
        }
    }
}
