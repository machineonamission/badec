package com.blueair.devicedetails.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.blueair.core.model.Device;
import com.blueair.devicedetails.adapter.DeviceBannerAdapter;
import com.blueair.devicedetails.databinding.FragmentDeviceBannersBinding;
import com.blueair.devicedetails.viewmodel.DeviceDetailsState;
import com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel;
import com.blueair.viewcore.fragment.BaseFragment;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J$\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\u0002X.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001d"}, d2 = {"Lcom/blueair/devicedetails/fragment/DeviceBannersFragment;", "Lcom/blueair/viewcore/fragment/BaseFragment;", "Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;", "<init>", "()V", "binding", "Lcom/blueair/devicedetails/databinding/FragmentDeviceBannersBinding;", "device", "Lcom/blueair/core/model/Device;", "adapter", "Lcom/blueair/devicedetails/adapter/DeviceBannerAdapter;", "viewModel", "getViewModel", "()Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;", "setViewModel", "(Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;)V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "showProgress", "", "shouldShowProgress", "", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceBannersFragment.kt */
public final class DeviceBannersFragment extends BaseFragment<DeviceDetailsViewModel> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TAG = "DeviceBannersFragment";
    private final DeviceBannerAdapter adapter = new DeviceBannerAdapter();
    private FragmentDeviceBannersBinding binding;
    private Device device;
    public DeviceDetailsViewModel viewModel;

    public void showProgress(boolean z) {
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/blueair/devicedetails/fragment/DeviceBannersFragment$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Lcom/blueair/devicedetails/fragment/DeviceBannersFragment;", "device", "Lcom/blueair/core/model/Device;", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceBannersFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DeviceBannersFragment newInstance(Device device) {
            Intrinsics.checkNotNullParameter(device, "device");
            DeviceBannersFragment deviceBannersFragment = new DeviceBannersFragment();
            deviceBannersFragment.setArguments(BundleKt.bundleOf(TuplesKt.to("device", device)));
            return deviceBannersFragment;
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

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        BaseFragment baseFragment = this;
        Fragment requireParentFragment = requireParentFragment();
        Intrinsics.checkNotNullExpressionValue(requireParentFragment, "requireParentFragment(...)");
        setViewModel((DeviceDetailsViewModel) ((BaseViewModel) new ViewModelProvider((ViewModelStoreOwner) requireParentFragment).get(DeviceDetailsViewModel.class)));
        Bundle arguments = getArguments();
        FragmentDeviceBannersBinding fragmentDeviceBannersBinding = null;
        Device device2 = arguments != null ? (Device) arguments.getParcelable("device") : null;
        if (device2 != null) {
            this.device = device2;
            FragmentDeviceBannersBinding inflate = FragmentDeviceBannersBinding.inflate(layoutInflater, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            this.binding = inflate;
            if (inflate == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                inflate = null;
            }
            inflate.bannerList.setLayoutManager(new LinearLayoutManager(requireContext()));
            this.adapter.setViewModel(getViewModel());
            DeviceBannerAdapter deviceBannerAdapter = this.adapter;
            Device device3 = this.device;
            if (device3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("device");
                device3 = null;
            }
            deviceBannerAdapter.setDevice(device3);
            FragmentDeviceBannersBinding fragmentDeviceBannersBinding2 = this.binding;
            if (fragmentDeviceBannersBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentDeviceBannersBinding2 = null;
            }
            fragmentDeviceBannersBinding2.bannerList.setAdapter(this.adapter);
            getViewModel().getDeviceDetailsState().observe(this, new DeviceBannersFragment$sam$androidx_lifecycle_Observer$0(new DeviceBannersFragment$$ExternalSyntheticLambda0(this)));
            FragmentDeviceBannersBinding fragmentDeviceBannersBinding3 = this.binding;
            if (fragmentDeviceBannersBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentDeviceBannersBinding = fragmentDeviceBannersBinding3;
            }
            FrameLayout root = fragmentDeviceBannersBinding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
            return root;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateView$lambda$0(DeviceBannersFragment deviceBannersFragment, DeviceDetailsState deviceDetailsState) {
        deviceBannersFragment.adapter.setDevice(deviceDetailsState.getDevice());
        return Unit.INSTANCE;
    }
}
