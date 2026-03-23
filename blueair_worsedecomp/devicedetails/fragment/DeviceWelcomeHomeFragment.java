package com.blueair.devicedetails.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.HasWelcomeHome;
import com.blueair.core.model.WelcomeHomeLocation;
import com.blueair.devicedetails.activity.WelcomeHomeConfigActivity;
import com.blueair.devicedetails.databinding.FragmentDeviceHWelcomeHomeBinding;
import com.blueair.devicedetails.databinding.FragmentDeviceWelcomeHomeBinding;
import com.blueair.devicedetails.dialog.WelcomeHomePermissionsDialogFragment;
import com.blueair.devicedetails.util.WelcomeHomePermissionManager;
import com.blueair.devicedetails.viewmodel.DeviceWelcomeHomeViewModel;
import com.blueair.viewcore.ViewUtilsKt;
import com.blueair.viewcore.fragment.BaseFragment;
import com.blueair.viewcore.view.SwitchCompat;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.material.button.MaterialButton;
import com.mapbox.maps.plugin.locationcomponent.LocationComponentConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 .2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001.B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J$\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u001a\u0010&\u001a\u00020\u001b2\u0006\u0010'\u001a\u00020\u001f2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010(\u001a\u00020\u001bH\u0002J\b\u0010)\u001a\u00020\u001bH\u0002J\b\u0010*\u001a\u00020\u001bH\u0002J\b\u0010+\u001a\u00020\u001bH\u0002J\b\u0010,\u001a\u00020\u001bH\u0002J\b\u0010-\u001a\u00020\u001bH\u0002R\u001a\u0010\u0005\u001a\u00020\u0002X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\u0013X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/blueair/devicedetails/fragment/DeviceWelcomeHomeFragment;", "Lcom/blueair/viewcore/fragment/BaseFragment;", "Lcom/blueair/devicedetails/viewmodel/DeviceWelcomeHomeViewModel;", "<init>", "()V", "viewModel", "getViewModel", "()Lcom/blueair/devicedetails/viewmodel/DeviceWelcomeHomeViewModel;", "setViewModel", "(Lcom/blueair/devicedetails/viewmodel/DeviceWelcomeHomeViewModel;)V", "btnAddHome", "Lcom/google/android/material/button/MaterialButton;", "welcomeHomeTitle", "Landroid/widget/TextView;", "welcomeHomeSwitch", "Lcom/blueair/viewcore/view/SwitchCompat;", "layoutAddress", "Landroidx/constraintlayout/widget/ConstraintLayout;", "device", "Lcom/blueair/core/model/Device;", "getDevice", "()Lcom/blueair/core/model/Device;", "setDevice", "(Lcom/blueair/core/model/Device;)V", "locationPermissionManager", "Lcom/blueair/devicedetails/util/WelcomeHomePermissionManager;", "showProgress", "", "shouldShowProgress", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "initViews", "initAddHomeBtn", "showWHPermissions", "initWelcomeHomeSwitch", "initAddressLayout", "openCreateUpdateWelcomeHome", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceWelcomeHomeFragment.kt */
public final class DeviceWelcomeHomeFragment extends BaseFragment<DeviceWelcomeHomeViewModel> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private MaterialButton btnAddHome;
    public Device device;
    private ConstraintLayout layoutAddress;
    private final WelcomeHomePermissionManager locationPermissionManager = new WelcomeHomePermissionManager(this);
    public DeviceWelcomeHomeViewModel viewModel;
    private SwitchCompat welcomeHomeSwitch;
    private TextView welcomeHomeTitle;

    public void showProgress(boolean z) {
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/blueair/devicedetails/fragment/DeviceWelcomeHomeFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/fragment/DeviceWelcomeHomeFragment;", "device", "Lcom/blueair/core/model/Device;", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceWelcomeHomeFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DeviceWelcomeHomeFragment newInstance(Device device) {
            Intrinsics.checkNotNullParameter(device, "device");
            DeviceWelcomeHomeFragment deviceWelcomeHomeFragment = new DeviceWelcomeHomeFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("device", device);
            deviceWelcomeHomeFragment.setArguments(bundle);
            return deviceWelcomeHomeFragment;
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
        ViewDataBinding viewDataBinding;
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Bundle arguments = getArguments();
        Device device2 = arguments != null ? (Device) arguments.getParcelable("device") : null;
        if (device2 != null) {
            setDevice(device2);
            setViewModel((DeviceWelcomeHomeViewModel) ((BaseViewModel) new ViewModelProvider((ViewModelStoreOwner) this).get(DeviceWelcomeHomeViewModel.class)));
            if (DeviceKt.isAfterG4(getDevice())) {
                FragmentDeviceHWelcomeHomeBinding inflate = FragmentDeviceHWelcomeHomeBinding.inflate(layoutInflater, viewGroup, false);
                inflate.setVm(getViewModel());
                Intrinsics.checkNotNullExpressionValue(inflate, "apply(...)");
                viewDataBinding = inflate;
                FragmentDeviceHWelcomeHomeBinding fragmentDeviceHWelcomeHomeBinding = (FragmentDeviceHWelcomeHomeBinding) viewDataBinding;
                MaterialButton materialButton = fragmentDeviceHWelcomeHomeBinding.btnAddHome;
                Intrinsics.checkNotNullExpressionValue(materialButton, "btnAddHome");
                this.btnAddHome = materialButton;
                TextView textView = fragmentDeviceHWelcomeHomeBinding.welcomeHomeTitle;
                Intrinsics.checkNotNullExpressionValue(textView, "welcomeHomeTitle");
                this.welcomeHomeTitle = textView;
                SwitchCompat switchCompat = fragmentDeviceHWelcomeHomeBinding.welcomeHomeSwitch;
                Intrinsics.checkNotNullExpressionValue(switchCompat, "welcomeHomeSwitch");
                this.welcomeHomeSwitch = switchCompat;
                ConstraintLayout constraintLayout = fragmentDeviceHWelcomeHomeBinding.layoutAddress;
                Intrinsics.checkNotNullExpressionValue(constraintLayout, "layoutAddress");
                this.layoutAddress = constraintLayout;
            } else {
                FragmentDeviceWelcomeHomeBinding inflate2 = FragmentDeviceWelcomeHomeBinding.inflate(layoutInflater, viewGroup, false);
                inflate2.setVm(getViewModel());
                Intrinsics.checkNotNullExpressionValue(inflate2, "apply(...)");
                viewDataBinding = inflate2;
                FragmentDeviceWelcomeHomeBinding fragmentDeviceWelcomeHomeBinding = (FragmentDeviceWelcomeHomeBinding) viewDataBinding;
                MaterialButton materialButton2 = fragmentDeviceWelcomeHomeBinding.btnAddHome;
                Intrinsics.checkNotNullExpressionValue(materialButton2, "btnAddHome");
                this.btnAddHome = materialButton2;
                TextView textView2 = fragmentDeviceWelcomeHomeBinding.welcomeHomeTitle;
                Intrinsics.checkNotNullExpressionValue(textView2, "welcomeHomeTitle");
                this.welcomeHomeTitle = textView2;
                SwitchCompat switchCompat2 = fragmentDeviceWelcomeHomeBinding.welcomeHomeSwitch;
                Intrinsics.checkNotNullExpressionValue(switchCompat2, "welcomeHomeSwitch");
                this.welcomeHomeSwitch = switchCompat2;
                ConstraintLayout constraintLayout2 = fragmentDeviceWelcomeHomeBinding.layoutAddress;
                Intrinsics.checkNotNullExpressionValue(constraintLayout2, "layoutAddress");
                this.layoutAddress = constraintLayout2;
            }
            viewDataBinding.setLifecycleOwner(this);
            DeviceWelcomeHomeViewModel viewModel2 = getViewModel();
            Device device3 = getDevice();
            Intrinsics.checkNotNull(device3, "null cannot be cast to non-null type com.blueair.core.model.HasWelcomeHome");
            viewModel2.setDevice((HasWelcomeHome) device3);
            View root = viewDataBinding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
            return root;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        super.onViewCreated(view, bundle);
        initViews();
        getViewModel().getLiveDeviceWelcomeHome(getDevice().getUid()).observe(getViewLifecycleOwner(), new DeviceWelcomeHomeFragment$sam$androidx_lifecycle_Observer$0(new DeviceWelcomeHomeFragment$$ExternalSyntheticLambda5(this)));
    }

    /* access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$2(DeviceWelcomeHomeFragment deviceWelcomeHomeFragment, WelcomeHomeLocation welcomeHomeLocation) {
        deviceWelcomeHomeFragment.getViewModel().loadHomeLocation(welcomeHomeLocation);
        return Unit.INSTANCE;
    }

    private final void initViews() {
        initAddHomeBtn();
        initWelcomeHomeSwitch();
        initAddressLayout();
    }

    private final void initAddHomeBtn() {
        MaterialButton materialButton = this.btnAddHome;
        TextView textView = null;
        if (materialButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnAddHome");
            materialButton = null;
        }
        ViewUtilsKt.setOnClickListener(materialButton, LocationComponentConstants.MAX_ANIMATION_DURATION_MS, new DeviceWelcomeHomeFragment$$ExternalSyntheticLambda3(this));
        TextView textView2 = this.welcomeHomeTitle;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("welcomeHomeTitle");
        } else {
            textView = textView2;
        }
        ViewUtilsKt.setOnClickListener(textView, LocationComponentConstants.MAX_ANIMATION_DURATION_MS, new DeviceWelcomeHomeFragment$$ExternalSyntheticLambda4(this));
    }

    /* access modifiers changed from: private */
    public static final Unit initAddHomeBtn$lambda$4(DeviceWelcomeHomeFragment deviceWelcomeHomeFragment, View view) {
        Intrinsics.checkNotNullParameter(view, "it");
        WelcomeHomePermissionManager.checkAndRequest$default(deviceWelcomeHomeFragment.locationPermissionManager, (Function0) null, new DeviceWelcomeHomeFragment$$ExternalSyntheticLambda2(deviceWelcomeHomeFragment), 1, (Object) null);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit initAddHomeBtn$lambda$4$lambda$3(DeviceWelcomeHomeFragment deviceWelcomeHomeFragment) {
        deviceWelcomeHomeFragment.openCreateUpdateWelcomeHome();
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit initAddHomeBtn$lambda$5(DeviceWelcomeHomeFragment deviceWelcomeHomeFragment, View view) {
        Intrinsics.checkNotNullParameter(view, "it");
        deviceWelcomeHomeFragment.showWHPermissions();
        return Unit.INSTANCE;
    }

    private final void showWHPermissions() {
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        Class<WelcomeHomePermissionsDialogFragment> cls = WelcomeHomePermissionsDialogFragment.class;
        Intrinsics.checkNotNullExpressionValue("WelcomeHomePermissionsDialogFragment", "getSimpleName(...)");
        if (!(childFragmentManager.findFragmentByTag("WelcomeHomePermissionsDialogFragment") instanceof WelcomeHomePermissionsDialogFragment) && !childFragmentManager.isStateSaved()) {
            new WelcomeHomePermissionsDialogFragment().show(childFragmentManager, "WelcomeHomePermissionsDialogFragment");
        }
    }

    private final void initWelcomeHomeSwitch() {
        getViewModel().getWelcomeHomeEnabled().observe(getViewLifecycleOwner(), new DeviceWelcomeHomeFragment$sam$androidx_lifecycle_Observer$0(new DeviceWelcomeHomeFragment$$ExternalSyntheticLambda8(this)));
        SwitchCompat switchCompat = this.welcomeHomeSwitch;
        if (switchCompat == null) {
            Intrinsics.throwUninitializedPropertyAccessException("welcomeHomeSwitch");
            switchCompat = null;
        }
        switchCompat.setOnCheckedChangeListener(new DeviceWelcomeHomeFragment$$ExternalSyntheticLambda9(this));
    }

    /* access modifiers changed from: private */
    public static final Unit initWelcomeHomeSwitch$lambda$7(DeviceWelcomeHomeFragment deviceWelcomeHomeFragment, Boolean bool) {
        SwitchCompat switchCompat = deviceWelcomeHomeFragment.welcomeHomeSwitch;
        if (switchCompat == null) {
            Intrinsics.throwUninitializedPropertyAccessException("welcomeHomeSwitch");
            switchCompat = null;
        }
        Intrinsics.checkNotNull(bool);
        switchCompat.setCheckedSilence(bool.booleanValue());
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final void initWelcomeHomeSwitch$lambda$10(DeviceWelcomeHomeFragment deviceWelcomeHomeFragment, CompoundButton compoundButton, boolean z) {
        if (z) {
            deviceWelcomeHomeFragment.locationPermissionManager.checkAndRequest(new DeviceWelcomeHomeFragment$$ExternalSyntheticLambda0(deviceWelcomeHomeFragment), new DeviceWelcomeHomeFragment$$ExternalSyntheticLambda1(deviceWelcomeHomeFragment));
        } else {
            deviceWelcomeHomeFragment.getViewModel().setWelcomeHomeEnabled(false);
        }
    }

    /* access modifiers changed from: private */
    public static final Unit initWelcomeHomeSwitch$lambda$10$lambda$9(DeviceWelcomeHomeFragment deviceWelcomeHomeFragment) {
        SwitchCompat switchCompat = deviceWelcomeHomeFragment.welcomeHomeSwitch;
        if (switchCompat == null) {
            Intrinsics.throwUninitializedPropertyAccessException("welcomeHomeSwitch");
            switchCompat = null;
        }
        switchCompat.setCheckedSilence(true);
        deviceWelcomeHomeFragment.getViewModel().setWelcomeHomeEnabled(true);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit initWelcomeHomeSwitch$lambda$10$lambda$8(DeviceWelcomeHomeFragment deviceWelcomeHomeFragment) {
        SwitchCompat switchCompat = deviceWelcomeHomeFragment.welcomeHomeSwitch;
        if (switchCompat == null) {
            Intrinsics.throwUninitializedPropertyAccessException("welcomeHomeSwitch");
            switchCompat = null;
        }
        switchCompat.setCheckedSilence(false);
        return Unit.INSTANCE;
    }

    private final void initAddressLayout() {
        ConstraintLayout constraintLayout = this.layoutAddress;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutAddress");
            constraintLayout = null;
        }
        ViewUtilsKt.setOnClickListener(constraintLayout, LocationComponentConstants.MAX_ANIMATION_DURATION_MS, new DeviceWelcomeHomeFragment$$ExternalSyntheticLambda7(this));
    }

    /* access modifiers changed from: private */
    public static final Unit initAddressLayout$lambda$12(DeviceWelcomeHomeFragment deviceWelcomeHomeFragment, View view) {
        Intrinsics.checkNotNullParameter(view, "it");
        WelcomeHomePermissionManager.checkAndRequest$default(deviceWelcomeHomeFragment.locationPermissionManager, (Function0) null, new DeviceWelcomeHomeFragment$$ExternalSyntheticLambda6(deviceWelcomeHomeFragment), 1, (Object) null);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit initAddressLayout$lambda$12$lambda$11(DeviceWelcomeHomeFragment deviceWelcomeHomeFragment) {
        deviceWelcomeHomeFragment.openCreateUpdateWelcomeHome();
        return Unit.INSTANCE;
    }

    private final void openCreateUpdateWelcomeHome() {
        Context context = getContext();
        if (context != null) {
            startActivity(WelcomeHomeConfigActivity.Companion.getLaunchIntent(context, getViewModel().getDevice()));
        }
    }
}
