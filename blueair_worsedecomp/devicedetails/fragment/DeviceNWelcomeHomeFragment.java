package com.blueair.devicedetails.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.core.os.BundleKt;
import androidx.core.text.HtmlCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.blueair.core.model.Device;
import com.blueair.core.model.HasWelcomeHome;
import com.blueair.core.model.WelcomeHomeLocation;
import com.blueair.devicedetails.activity.WelcomeHomeConfigActivity;
import com.blueair.devicedetails.databinding.FragmentDeviceNWelcomeHomeBinding;
import com.blueair.devicedetails.util.WelcomeHomePermissionManager;
import com.blueair.devicedetails.viewmodel.DeviceWelcomeHomeViewModel;
import com.blueair.viewcore.R;
import com.blueair.viewcore.fragment.BaseFragment;
import com.blueair.viewcore.view.SwitchCompat;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u001d2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J$\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u001a\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0019\u001a\u00020\u0017H\u0002J\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001cH\u0016R\u001a\u0010\u0005\u001a\u00020\u0002X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/blueair/devicedetails/fragment/DeviceNWelcomeHomeFragment;", "Lcom/blueair/viewcore/fragment/BaseFragment;", "Lcom/blueair/devicedetails/viewmodel/DeviceWelcomeHomeViewModel;", "<init>", "()V", "viewModel", "getViewModel", "()Lcom/blueair/devicedetails/viewmodel/DeviceWelcomeHomeViewModel;", "setViewModel", "(Lcom/blueair/devicedetails/viewmodel/DeviceWelcomeHomeViewModel;)V", "binding", "Lcom/blueair/devicedetails/databinding/FragmentDeviceNWelcomeHomeBinding;", "locationPermissionManager", "Lcom/blueair/devicedetails/util/WelcomeHomePermissionManager;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "openCreateUpdateWelcomeHome", "showProgress", "shouldShowProgress", "", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceNWelcomeHomeFragment.kt */
public final class DeviceNWelcomeHomeFragment extends BaseFragment<DeviceWelcomeHomeViewModel> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private FragmentDeviceNWelcomeHomeBinding binding;
    private final WelcomeHomePermissionManager locationPermissionManager = new WelcomeHomePermissionManager(this);
    public DeviceWelcomeHomeViewModel viewModel;

    public void showProgress(boolean z) {
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/blueair/devicedetails/fragment/DeviceNWelcomeHomeFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/fragment/DeviceNWelcomeHomeFragment;", "device", "Lcom/blueair/core/model/Device;", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceNWelcomeHomeFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DeviceNWelcomeHomeFragment newInstance(Device device) {
            Intrinsics.checkNotNullParameter(device, "device");
            DeviceNWelcomeHomeFragment deviceNWelcomeHomeFragment = new DeviceNWelcomeHomeFragment();
            deviceNWelcomeHomeFragment.setArguments(BundleKt.bundleOf(TuplesKt.to("device", device)));
            return deviceNWelcomeHomeFragment;
        }
    }

    public DeviceWelcomeHomeViewModel getViewModel() {
        DeviceWelcomeHomeViewModel deviceWelcomeHomeViewModel = this.viewModel;
        if (deviceWelcomeHomeViewModel != null) {
            return deviceWelcomeHomeViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        return null;
    }

    public void setViewModel(DeviceWelcomeHomeViewModel deviceWelcomeHomeViewModel) {
        Intrinsics.checkNotNullParameter(deviceWelcomeHomeViewModel, "<set-?>");
        this.viewModel = deviceWelcomeHomeViewModel;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Bundle arguments = getArguments();
        FragmentDeviceNWelcomeHomeBinding fragmentDeviceNWelcomeHomeBinding = null;
        Parcelable parcelable = arguments != null ? arguments.getParcelable("device") : null;
        if (parcelable != null) {
            setViewModel((DeviceWelcomeHomeViewModel) ((BaseViewModel) new ViewModelProvider((ViewModelStoreOwner) this).get(DeviceWelcomeHomeViewModel.class)));
            DeviceWelcomeHomeViewModel viewModel2 = getViewModel();
            Intrinsics.checkNotNull(parcelable, "null cannot be cast to non-null type com.blueair.core.model.HasWelcomeHome");
            viewModel2.setDevice((HasWelcomeHome) parcelable);
            FragmentDeviceNWelcomeHomeBinding inflate = FragmentDeviceNWelcomeHomeBinding.inflate(layoutInflater, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            this.binding = inflate;
            if (inflate == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                inflate = null;
            }
            inflate.setVm(getViewModel());
            FragmentDeviceNWelcomeHomeBinding fragmentDeviceNWelcomeHomeBinding2 = this.binding;
            if (fragmentDeviceNWelcomeHomeBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentDeviceNWelcomeHomeBinding2 = null;
            }
            fragmentDeviceNWelcomeHomeBinding2.setLifecycleOwner(getViewLifecycleOwner());
            FragmentDeviceNWelcomeHomeBinding fragmentDeviceNWelcomeHomeBinding3 = this.binding;
            if (fragmentDeviceNWelcomeHomeBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentDeviceNWelcomeHomeBinding = fragmentDeviceNWelcomeHomeBinding3;
            }
            View root = fragmentDeviceNWelcomeHomeBinding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
            return root;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        super.onViewCreated(view, bundle);
        FragmentDeviceNWelcomeHomeBinding fragmentDeviceNWelcomeHomeBinding = this.binding;
        if (fragmentDeviceNWelcomeHomeBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentDeviceNWelcomeHomeBinding = null;
        }
        fragmentDeviceNWelcomeHomeBinding.addBtn.setOnClickListener(new DeviceNWelcomeHomeFragment$$ExternalSyntheticLambda0(this));
        fragmentDeviceNWelcomeHomeBinding.switchBtn.setOnCheckedChangeListener(new DeviceNWelcomeHomeFragment$$ExternalSyntheticLambda1(this, fragmentDeviceNWelcomeHomeBinding));
        fragmentDeviceNWelcomeHomeBinding.addressContainer.setOnClickListener(new DeviceNWelcomeHomeFragment$$ExternalSyntheticLambda2(this));
        getViewModel().getRadius().observe(getViewLifecycleOwner(), new DeviceNWelcomeHomeFragment$sam$androidx_lifecycle_Observer$0(new DeviceNWelcomeHomeFragment$$ExternalSyntheticLambda3(fragmentDeviceNWelcomeHomeBinding, this)));
        getViewModel().getWelcomeHomeEnabled().observe(getViewLifecycleOwner(), new DeviceNWelcomeHomeFragment$sam$androidx_lifecycle_Observer$0(new DeviceNWelcomeHomeFragment$$ExternalSyntheticLambda4(this)));
        getViewModel().getLiveDeviceWelcomeHome(getViewModel().getDevice().getUid()).observe(getViewLifecycleOwner(), new DeviceNWelcomeHomeFragment$sam$androidx_lifecycle_Observer$0(new DeviceNWelcomeHomeFragment$$ExternalSyntheticLambda5(this)));
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$8$lambda$1(DeviceNWelcomeHomeFragment deviceNWelcomeHomeFragment, View view) {
        WelcomeHomePermissionManager.checkAndRequest$default(deviceNWelcomeHomeFragment.locationPermissionManager, (Function0) null, new DeviceNWelcomeHomeFragment$$ExternalSyntheticLambda9(deviceNWelcomeHomeFragment), 1, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$8$lambda$1$lambda$0(DeviceNWelcomeHomeFragment deviceNWelcomeHomeFragment) {
        deviceNWelcomeHomeFragment.openCreateUpdateWelcomeHome();
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$8$lambda$4(DeviceNWelcomeHomeFragment deviceNWelcomeHomeFragment, FragmentDeviceNWelcomeHomeBinding fragmentDeviceNWelcomeHomeBinding, CompoundButton compoundButton, boolean z) {
        if (z) {
            deviceNWelcomeHomeFragment.locationPermissionManager.checkAndRequest(new DeviceNWelcomeHomeFragment$$ExternalSyntheticLambda7(fragmentDeviceNWelcomeHomeBinding), new DeviceNWelcomeHomeFragment$$ExternalSyntheticLambda8(fragmentDeviceNWelcomeHomeBinding, deviceNWelcomeHomeFragment));
        } else {
            deviceNWelcomeHomeFragment.getViewModel().setWelcomeHomeEnabled(false);
        }
    }

    /* access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$8$lambda$4$lambda$3(FragmentDeviceNWelcomeHomeBinding fragmentDeviceNWelcomeHomeBinding, DeviceNWelcomeHomeFragment deviceNWelcomeHomeFragment) {
        fragmentDeviceNWelcomeHomeBinding.switchBtn.setCheckedSilence(true);
        deviceNWelcomeHomeFragment.getViewModel().setWelcomeHomeEnabled(true);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$8$lambda$4$lambda$2(FragmentDeviceNWelcomeHomeBinding fragmentDeviceNWelcomeHomeBinding) {
        fragmentDeviceNWelcomeHomeBinding.switchBtn.setCheckedSilence(false);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$8$lambda$6(DeviceNWelcomeHomeFragment deviceNWelcomeHomeFragment, View view) {
        WelcomeHomePermissionManager.checkAndRequest$default(deviceNWelcomeHomeFragment.locationPermissionManager, (Function0) null, new DeviceNWelcomeHomeFragment$$ExternalSyntheticLambda6(deviceNWelcomeHomeFragment), 1, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$8$lambda$6$lambda$5(DeviceNWelcomeHomeFragment deviceNWelcomeHomeFragment) {
        deviceNWelcomeHomeFragment.openCreateUpdateWelcomeHome();
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$8$lambda$7(FragmentDeviceNWelcomeHomeBinding fragmentDeviceNWelcomeHomeBinding, DeviceNWelcomeHomeFragment deviceNWelcomeHomeFragment, String str) {
        TextView textView = fragmentDeviceNWelcomeHomeBinding.radiusText;
        textView.setText(HtmlCompat.fromHtml(deviceNWelcomeHomeFragment.getString(R.string.welcome_home_radius) + " <b>" + str + "</b>", 0));
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$9(DeviceNWelcomeHomeFragment deviceNWelcomeHomeFragment, Boolean bool) {
        FragmentDeviceNWelcomeHomeBinding fragmentDeviceNWelcomeHomeBinding = deviceNWelcomeHomeFragment.binding;
        if (fragmentDeviceNWelcomeHomeBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentDeviceNWelcomeHomeBinding = null;
        }
        SwitchCompat switchCompat = fragmentDeviceNWelcomeHomeBinding.switchBtn;
        Intrinsics.checkNotNull(bool);
        switchCompat.setCheckedSilence(bool.booleanValue());
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$10(DeviceNWelcomeHomeFragment deviceNWelcomeHomeFragment, WelcomeHomeLocation welcomeHomeLocation) {
        deviceNWelcomeHomeFragment.getViewModel().loadHomeLocation(welcomeHomeLocation);
        return Unit.INSTANCE;
    }

    private final void openCreateUpdateWelcomeHome() {
        Context context = getContext();
        if (context != null) {
            startActivity(WelcomeHomeConfigActivity.Companion.getLaunchIntent(context, getViewModel().getDevice()));
        }
    }
}
