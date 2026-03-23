package com.blueair.devicedetails.fragment;

import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceScheduleMerged;
import com.blueair.core.model.HasBlueCloudFunctions;
import com.blueair.devicedetails.adapter.DeviceScheduleAdapter;
import com.blueair.devicedetails.databinding.FragmentDeviceSchedulesBinding;
import com.blueair.devicedetails.dialog.DeviceCreateEditScheduleDialogFragment;
import com.blueair.devicedetails.viewmodel.DeviceSchedulesViewModel;
import com.blueair.viewcore.fragment.BaseFragment;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import com.google.android.material.button.MaterialButton;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \"2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J$\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u001dH\u0002J\u0010\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020!H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\u0002X.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006#"}, d2 = {"Lcom/blueair/devicedetails/fragment/DeviceSchedulesFragment;", "Lcom/blueair/viewcore/fragment/BaseFragment;", "Lcom/blueair/devicedetails/viewmodel/DeviceSchedulesViewModel;", "<init>", "()V", "deviceSchedulesBinding", "Lcom/blueair/devicedetails/databinding/FragmentDeviceSchedulesBinding;", "viewModel", "getViewModel", "()Lcom/blueair/devicedetails/viewmodel/DeviceSchedulesViewModel;", "setViewModel", "(Lcom/blueair/devicedetails/viewmodel/DeviceSchedulesViewModel;)V", "scheduleAdapter", "Lcom/blueair/devicedetails/adapter/DeviceScheduleAdapter;", "device", "Lcom/blueair/core/model/Device;", "getDevice", "()Lcom/blueair/core/model/Device;", "setDevice", "(Lcom/blueair/core/model/Device;)V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "configure", "", "onAddClicked", "showProgress", "shouldShowProgress", "", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceSchedulesFragment.kt */
public final class DeviceSchedulesFragment extends BaseFragment<DeviceSchedulesViewModel> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public Device device;
    private FragmentDeviceSchedulesBinding deviceSchedulesBinding;
    private DeviceScheduleAdapter scheduleAdapter;
    public DeviceSchedulesViewModel viewModel;

    public void showProgress(boolean z) {
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/blueair/devicedetails/fragment/DeviceSchedulesFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/fragment/DeviceSchedulesFragment;", "device", "Lcom/blueair/core/model/Device;", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceSchedulesFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DeviceSchedulesFragment newInstance(Device device) {
            Intrinsics.checkNotNullParameter(device, "device");
            DeviceSchedulesFragment deviceSchedulesFragment = new DeviceSchedulesFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("device", device);
            deviceSchedulesFragment.setArguments(bundle);
            return deviceSchedulesFragment;
        }
    }

    public DeviceSchedulesViewModel getViewModel() {
        DeviceSchedulesViewModel deviceSchedulesViewModel = this.viewModel;
        if (deviceSchedulesViewModel != null) {
            return deviceSchedulesViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        return null;
    }

    public void setViewModel(DeviceSchedulesViewModel deviceSchedulesViewModel) {
        Intrinsics.checkNotNullParameter(deviceSchedulesViewModel, "<set-?>");
        this.viewModel = deviceSchedulesViewModel;
    }

    public final Device getDevice() {
        Device device2 = this.device;
        if (device2 != null) {
            return device2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("device");
        return null;
    }

    public final void setDevice(Device device2) {
        Intrinsics.checkNotNullParameter(device2, "<set-?>");
        this.device = device2;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Bundle arguments = getArguments();
        FragmentDeviceSchedulesBinding fragmentDeviceSchedulesBinding = null;
        Device device2 = arguments != null ? (Device) arguments.getParcelable("device") : null;
        if (device2 != null) {
            setDevice(device2);
            FragmentDeviceSchedulesBinding inflate = FragmentDeviceSchedulesBinding.inflate(layoutInflater, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
            setViewModel((DeviceSchedulesViewModel) ((BaseViewModel) new ViewModelProvider((ViewModelStoreOwner) requireActivity).get(DeviceSchedulesViewModel.class)));
            inflate.setDeviceSchedulesViewModel(getViewModel());
            this.deviceSchedulesBinding = inflate;
            getViewModel().setDevice(getDevice());
            getViewModel().refreshDeviceSchedule(false);
            configure();
            FragmentDeviceSchedulesBinding fragmentDeviceSchedulesBinding2 = this.deviceSchedulesBinding;
            if (fragmentDeviceSchedulesBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("deviceSchedulesBinding");
            } else {
                fragmentDeviceSchedulesBinding = fragmentDeviceSchedulesBinding2;
            }
            View root = fragmentDeviceSchedulesBinding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
            return root;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    private final void configure() {
        FragmentDeviceSchedulesBinding fragmentDeviceSchedulesBinding = this.deviceSchedulesBinding;
        FragmentDeviceSchedulesBinding fragmentDeviceSchedulesBinding2 = null;
        if (fragmentDeviceSchedulesBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deviceSchedulesBinding");
            fragmentDeviceSchedulesBinding = null;
        }
        fragmentDeviceSchedulesBinding.addSchedule.setOnClickListener(new DeviceSchedulesFragment$$ExternalSyntheticLambda2(this));
        FragmentDeviceSchedulesBinding fragmentDeviceSchedulesBinding3 = this.deviceSchedulesBinding;
        if (fragmentDeviceSchedulesBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deviceSchedulesBinding");
        } else {
            fragmentDeviceSchedulesBinding2 = fragmentDeviceSchedulesBinding3;
        }
        RecyclerView recyclerView = fragmentDeviceSchedulesBinding2.recyclerViewDeviceSchedules;
        DeviceScheduleAdapter deviceScheduleAdapter = new DeviceScheduleAdapter(getDevice() instanceof HasBlueCloudFunctions, DateFormat.is24HourFormat(requireContext()), getDevice(), new DeviceSchedulesFragment$$ExternalSyntheticLambda3(this), new DeviceSchedulesFragment$$ExternalSyntheticLambda4(this));
        this.scheduleAdapter = deviceScheduleAdapter;
        recyclerView.setAdapter(deviceScheduleAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 1, false));
        getViewModel().getSchedules().observe(getViewLifecycleOwner(), new DeviceSchedulesFragment$sam$androidx_lifecycle_Observer$0(new DeviceSchedulesFragment$$ExternalSyntheticLambda5(this)));
    }

    /* access modifiers changed from: private */
    public static final void configure$lambda$1(DeviceSchedulesFragment deviceSchedulesFragment, View view) {
        deviceSchedulesFragment.onAddClicked();
    }

    /* access modifiers changed from: private */
    public static final Unit configure$lambda$7$lambda$2(DeviceSchedulesFragment deviceSchedulesFragment) {
        deviceSchedulesFragment.onAddClicked();
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit configure$lambda$7$lambda$6(DeviceSchedulesFragment deviceSchedulesFragment, DeviceScheduleMerged deviceScheduleMerged) {
        Intrinsics.checkNotNullParameter(deviceScheduleMerged, "tappedSchedule");
        FragmentManager childFragmentManager = deviceSchedulesFragment.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        Class<DeviceCreateEditScheduleDialogFragment> cls = DeviceCreateEditScheduleDialogFragment.class;
        Intrinsics.checkNotNullExpressionValue("DeviceCreateEditScheduleDialogFragment", "getSimpleName(...)");
        if (!(childFragmentManager.findFragmentByTag("DeviceCreateEditScheduleDialogFragment") instanceof DeviceCreateEditScheduleDialogFragment) && !childFragmentManager.isStateSaved()) {
            DeviceCreateEditScheduleDialogFragment newInstance = DeviceCreateEditScheduleDialogFragment.Companion.newInstance(deviceSchedulesFragment.getDevice(), deviceScheduleMerged);
            newInstance.setOnDismiss(new DeviceSchedulesFragment$$ExternalSyntheticLambda0(deviceSchedulesFragment));
            newInstance.show(childFragmentManager, "DeviceCreateEditScheduleDialogFragment");
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit configure$lambda$7$lambda$6$lambda$5$lambda$4$lambda$3(DeviceSchedulesFragment deviceSchedulesFragment, boolean z) {
        deviceSchedulesFragment.getViewModel().refreshDeviceSchedule(z);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit configure$lambda$8(DeviceSchedulesFragment deviceSchedulesFragment, List list) {
        FragmentDeviceSchedulesBinding fragmentDeviceSchedulesBinding = deviceSchedulesFragment.deviceSchedulesBinding;
        DeviceScheduleAdapter deviceScheduleAdapter = null;
        if (fragmentDeviceSchedulesBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deviceSchedulesBinding");
            fragmentDeviceSchedulesBinding = null;
        }
        MaterialButton materialButton = fragmentDeviceSchedulesBinding.addSchedule;
        Intrinsics.checkNotNull(list);
        materialButton.setVisibility(!list.isEmpty() ? 0 : 4);
        DeviceScheduleAdapter deviceScheduleAdapter2 = deviceSchedulesFragment.scheduleAdapter;
        if (deviceScheduleAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scheduleAdapter");
        } else {
            deviceScheduleAdapter = deviceScheduleAdapter2;
        }
        deviceScheduleAdapter.setItems(list);
        return Unit.INSTANCE;
    }

    private final void onAddClicked() {
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        Class<DeviceCreateEditScheduleDialogFragment> cls = DeviceCreateEditScheduleDialogFragment.class;
        Intrinsics.checkNotNullExpressionValue("DeviceCreateEditScheduleDialogFragment", "getSimpleName(...)");
        if (!(childFragmentManager.findFragmentByTag("DeviceCreateEditScheduleDialogFragment") instanceof DeviceCreateEditScheduleDialogFragment) && !childFragmentManager.isStateSaved()) {
            DeviceCreateEditScheduleDialogFragment newInstance$default = DeviceCreateEditScheduleDialogFragment.Companion.newInstance$default(DeviceCreateEditScheduleDialogFragment.Companion, getDevice(), (DeviceScheduleMerged) null, 2, (Object) null);
            newInstance$default.setOnDismiss(new DeviceSchedulesFragment$$ExternalSyntheticLambda1(this));
            newInstance$default.show(childFragmentManager, "DeviceCreateEditScheduleDialogFragment");
        }
    }

    /* access modifiers changed from: private */
    public static final Unit onAddClicked$lambda$11$lambda$10$lambda$9(DeviceSchedulesFragment deviceSchedulesFragment, boolean z) {
        deviceSchedulesFragment.getViewModel().refreshDeviceSchedule(z);
        return Unit.INSTANCE;
    }
}
