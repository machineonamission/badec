package com.blueair.devicedetails.fragment;

import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceScheduleMerged;
import com.blueair.core.model.HasBlueCloudFunctions;
import com.blueair.devicedetails.adapter.DeviceNScheduleAdapter;
import com.blueair.devicedetails.databinding.FragmentDeviceNSchedulesBinding;
import com.blueair.devicedetails.dialog.DeviceCreateEditScheduleDialogFragment;
import com.blueair.devicedetails.dialog.DeviceNCreateEditScheduleDialogFragment;
import com.blueair.devicedetails.viewmodel.DeviceSchedulesViewModel;
import com.blueair.viewcore.fragment.BaseFragment;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u001b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J$\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001aH\u0016R\u001a\u0010\u0005\u001a\u00020\u0002X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/blueair/devicedetails/fragment/DeviceNSchedulesFragment;", "Lcom/blueair/viewcore/fragment/BaseFragment;", "Lcom/blueair/devicedetails/viewmodel/DeviceSchedulesViewModel;", "<init>", "()V", "viewModel", "getViewModel", "()Lcom/blueair/devicedetails/viewmodel/DeviceSchedulesViewModel;", "setViewModel", "(Lcom/blueair/devicedetails/viewmodel/DeviceSchedulesViewModel;)V", "binding", "Lcom/blueair/devicedetails/databinding/FragmentDeviceNSchedulesBinding;", "scheduleAdapter", "Lcom/blueair/devicedetails/adapter/DeviceNScheduleAdapter;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "configure", "", "showProgress", "shouldShowProgress", "", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceNSchedulesFragment.kt */
public final class DeviceNSchedulesFragment extends BaseFragment<DeviceSchedulesViewModel> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private FragmentDeviceNSchedulesBinding binding;
    private DeviceNScheduleAdapter scheduleAdapter;
    public DeviceSchedulesViewModel viewModel;

    public void showProgress(boolean z) {
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/blueair/devicedetails/fragment/DeviceNSchedulesFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/fragment/DeviceNSchedulesFragment;", "device", "Lcom/blueair/core/model/Device;", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceNSchedulesFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DeviceNSchedulesFragment newInstance(Device device) {
            Intrinsics.checkNotNullParameter(device, "device");
            DeviceNSchedulesFragment deviceNSchedulesFragment = new DeviceNSchedulesFragment();
            deviceNSchedulesFragment.setArguments(BundleKt.bundleOf(TuplesKt.to("device", device)));
            return deviceNSchedulesFragment;
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

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Bundle arguments = getArguments();
        FragmentDeviceNSchedulesBinding fragmentDeviceNSchedulesBinding = null;
        Device device = arguments != null ? (Device) arguments.getParcelable("device") : null;
        if (!(device instanceof Device)) {
            device = null;
        }
        if (device != null) {
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
            setViewModel((DeviceSchedulesViewModel) ((BaseViewModel) new ViewModelProvider((ViewModelStoreOwner) requireActivity).get(DeviceSchedulesViewModel.class)));
            getViewModel().setDevice(device);
            getViewModel().refreshDeviceSchedule(false);
            FragmentDeviceNSchedulesBinding inflate = FragmentDeviceNSchedulesBinding.inflate(layoutInflater, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            this.binding = inflate;
            configure();
            FragmentDeviceNSchedulesBinding fragmentDeviceNSchedulesBinding2 = this.binding;
            if (fragmentDeviceNSchedulesBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentDeviceNSchedulesBinding = fragmentDeviceNSchedulesBinding2;
            }
            FrameLayout root = fragmentDeviceNSchedulesBinding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
            return root;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    private final void configure() {
        FragmentDeviceNSchedulesBinding fragmentDeviceNSchedulesBinding = this.binding;
        FragmentDeviceNSchedulesBinding fragmentDeviceNSchedulesBinding2 = null;
        if (fragmentDeviceNSchedulesBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentDeviceNSchedulesBinding = null;
        }
        fragmentDeviceNSchedulesBinding.addSchedule.setOnClickListener(new DeviceNSchedulesFragment$$ExternalSyntheticLambda1(this));
        FragmentDeviceNSchedulesBinding fragmentDeviceNSchedulesBinding3 = this.binding;
        if (fragmentDeviceNSchedulesBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentDeviceNSchedulesBinding2 = fragmentDeviceNSchedulesBinding3;
        }
        RecyclerView recyclerView = fragmentDeviceNSchedulesBinding2.scheduleList;
        DeviceNScheduleAdapter deviceNScheduleAdapter = new DeviceNScheduleAdapter(getViewModel().getDevice() instanceof HasBlueCloudFunctions, DateFormat.is24HourFormat(requireContext()), getViewModel().getDevice(), new DeviceNSchedulesFragment$$ExternalSyntheticLambda2(this));
        this.scheduleAdapter = deviceNScheduleAdapter;
        recyclerView.setAdapter(deviceNScheduleAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 1, false));
        getViewModel().getSchedules().observe(getViewLifecycleOwner(), new DeviceNSchedulesFragment$sam$androidx_lifecycle_Observer$0(new DeviceNSchedulesFragment$$ExternalSyntheticLambda3(this)));
    }

    /* access modifiers changed from: private */
    public static final void configure$lambda$3(DeviceNSchedulesFragment deviceNSchedulesFragment, View view) {
        FragmentManager childFragmentManager = deviceNSchedulesFragment.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        Class<DeviceNCreateEditScheduleDialogFragment> cls = DeviceNCreateEditScheduleDialogFragment.class;
        Intrinsics.checkNotNullExpressionValue("DeviceNCreateEditScheduleDialogFragment", "getSimpleName(...)");
        if (!(childFragmentManager.findFragmentByTag("DeviceNCreateEditScheduleDialogFragment") instanceof DeviceNCreateEditScheduleDialogFragment)) {
            deviceNSchedulesFragment.getViewModel().getLatestDevice(new DeviceNSchedulesFragment$$ExternalSyntheticLambda4(deviceNSchedulesFragment));
        }
    }

    /* access modifiers changed from: private */
    public static final Unit configure$lambda$3$lambda$2(DeviceNSchedulesFragment deviceNSchedulesFragment, Device device) {
        Intrinsics.checkNotNullParameter(device, "device");
        FragmentManager childFragmentManager = deviceNSchedulesFragment.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        Class<DeviceNCreateEditScheduleDialogFragment> cls = DeviceNCreateEditScheduleDialogFragment.class;
        Intrinsics.checkNotNullExpressionValue("DeviceNCreateEditScheduleDialogFragment", "getSimpleName(...)");
        if (!(childFragmentManager.findFragmentByTag("DeviceNCreateEditScheduleDialogFragment") instanceof DeviceNCreateEditScheduleDialogFragment) && !childFragmentManager.isStateSaved()) {
            DeviceNCreateEditScheduleDialogFragment.Companion.newInstance$default(DeviceNCreateEditScheduleDialogFragment.Companion, device, (DeviceScheduleMerged) null, new DeviceNSchedulesFragment$$ExternalSyntheticLambda0(deviceNSchedulesFragment), 2, (Object) null).show(childFragmentManager, "DeviceNCreateEditScheduleDialogFragment");
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit configure$lambda$3$lambda$2$lambda$1$lambda$0(DeviceNSchedulesFragment deviceNSchedulesFragment, boolean z) {
        deviceNSchedulesFragment.getViewModel().refreshDeviceSchedule(z);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit configure$lambda$8$lambda$7(DeviceNSchedulesFragment deviceNSchedulesFragment, DeviceScheduleMerged deviceScheduleMerged) {
        Intrinsics.checkNotNullParameter(deviceScheduleMerged, "tappedSchedule");
        FragmentManager childFragmentManager = deviceNSchedulesFragment.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        Class<DeviceCreateEditScheduleDialogFragment> cls = DeviceCreateEditScheduleDialogFragment.class;
        Intrinsics.checkNotNullExpressionValue("DeviceCreateEditScheduleDialogFragment", "getSimpleName(...)");
        if (!(childFragmentManager.findFragmentByTag("DeviceCreateEditScheduleDialogFragment") instanceof DeviceCreateEditScheduleDialogFragment)) {
            deviceNSchedulesFragment.getViewModel().getLatestDevice(new DeviceNSchedulesFragment$$ExternalSyntheticLambda5(deviceNSchedulesFragment, deviceScheduleMerged));
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit configure$lambda$8$lambda$7$lambda$6(DeviceNSchedulesFragment deviceNSchedulesFragment, DeviceScheduleMerged deviceScheduleMerged, Device device) {
        Intrinsics.checkNotNullParameter(device, "device");
        FragmentManager childFragmentManager = deviceNSchedulesFragment.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        Class<DeviceNCreateEditScheduleDialogFragment> cls = DeviceNCreateEditScheduleDialogFragment.class;
        Intrinsics.checkNotNullExpressionValue("DeviceNCreateEditScheduleDialogFragment", "getSimpleName(...)");
        if (!(childFragmentManager.findFragmentByTag("DeviceNCreateEditScheduleDialogFragment") instanceof DeviceNCreateEditScheduleDialogFragment) && !childFragmentManager.isStateSaved()) {
            DeviceNCreateEditScheduleDialogFragment.Companion.newInstance(device, deviceScheduleMerged, new DeviceNSchedulesFragment$$ExternalSyntheticLambda6(deviceNSchedulesFragment)).show(childFragmentManager, "DeviceNCreateEditScheduleDialogFragment");
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit configure$lambda$8$lambda$7$lambda$6$lambda$5$lambda$4(DeviceNSchedulesFragment deviceNSchedulesFragment, boolean z) {
        deviceNSchedulesFragment.getViewModel().refreshDeviceSchedule(z);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit configure$lambda$9(DeviceNSchedulesFragment deviceNSchedulesFragment, List list) {
        DeviceNScheduleAdapter deviceNScheduleAdapter = deviceNSchedulesFragment.scheduleAdapter;
        if (deviceNScheduleAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scheduleAdapter");
            deviceNScheduleAdapter = null;
        }
        Intrinsics.checkNotNull(list);
        deviceNScheduleAdapter.setItems(list);
        return Unit.INSTANCE;
    }
}
