package com.blueair.devicedetails.dialog;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.blueair.core.model.AnalyticEvent;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceKt;
import com.blueair.devicedetails.databinding.DialogfragmentDeviceC3TemperatureBinding;
import com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel;
import com.blueair.viewcore.R;
import com.blueair.viewcore.dialog.BaseDialogFragment;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u001d2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J$\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001cH\u0016R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0002X.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/blueair/devicedetails/dialog/DeviceC3TemperatureDialogFragment;", "Lcom/blueair/viewcore/dialog/BaseDialogFragment;", "Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "viewModel", "getViewModel", "()Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;", "setViewModel", "(Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;)V", "binding", "Lcom/blueair/devicedetails/databinding/DialogfragmentDeviceC3TemperatureBinding;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "", "showProgress", "shouldShowProgress", "", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceC3TemperatureDialogFragment.kt */
public final class DeviceC3TemperatureDialogFragment extends BaseDialogFragment<DeviceDetailsViewModel> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private DialogfragmentDeviceC3TemperatureBinding binding;
    private final String screenName = AnalyticEvent.ScreenViewEvent.DEVICE_SETTINGS_TEMPERATURE;
    public DeviceDetailsViewModel viewModel;

    public void showProgress(boolean z) {
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/devicedetails/dialog/DeviceC3TemperatureDialogFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/dialog/DeviceC3TemperatureDialogFragment;", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceC3TemperatureDialogFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DeviceC3TemperatureDialogFragment newInstance() {
            return new DeviceC3TemperatureDialogFragment();
        }
    }

    /* access modifiers changed from: protected */
    public String getScreenName() {
        return this.screenName;
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
        Window window;
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        DialogfragmentDeviceC3TemperatureBinding inflate = DialogfragmentDeviceC3TemperatureBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        setStyle(0, R.style.DialogTheme);
        Dialog dialog = getDialog();
        if (!(dialog == null || (window = dialog.getWindow()) == null)) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setWindowAnimations(R.style.dialog_animation);
            window.setGravity(80);
        }
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        setViewModel((DeviceDetailsViewModel) ((BaseViewModel) new ViewModelProvider((ViewModelStoreOwner) requireActivity).get(DeviceDetailsViewModel.class)));
        DialogfragmentDeviceC3TemperatureBinding dialogfragmentDeviceC3TemperatureBinding = this.binding;
        DialogfragmentDeviceC3TemperatureBinding dialogfragmentDeviceC3TemperatureBinding2 = null;
        if (dialogfragmentDeviceC3TemperatureBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogfragmentDeviceC3TemperatureBinding = null;
        }
        dialogfragmentDeviceC3TemperatureBinding.contentBack.setOnClickListener(new DeviceC3TemperatureDialogFragment$$ExternalSyntheticLambda0(this));
        dialogfragmentDeviceC3TemperatureBinding.titleTempF.setOnClickListener(new DeviceC3TemperatureDialogFragment$$ExternalSyntheticLambda1(this));
        dialogfragmentDeviceC3TemperatureBinding.titleTempC.setOnClickListener(new DeviceC3TemperatureDialogFragment$$ExternalSyntheticLambda2(this));
        getViewModel().getLiveDevice().observe(this, new DeviceC3TemperatureDialogFragment$sam$androidx_lifecycle_Observer$0(new DeviceC3TemperatureDialogFragment$$ExternalSyntheticLambda3(this)));
        DialogfragmentDeviceC3TemperatureBinding dialogfragmentDeviceC3TemperatureBinding3 = this.binding;
        if (dialogfragmentDeviceC3TemperatureBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            dialogfragmentDeviceC3TemperatureBinding2 = dialogfragmentDeviceC3TemperatureBinding3;
        }
        FrameLayout root = dialogfragmentDeviceC3TemperatureBinding2.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    /* access modifiers changed from: private */
    public static final void onCreateView$lambda$6$lambda$1(DeviceC3TemperatureDialogFragment deviceC3TemperatureDialogFragment, View view) {
        deviceC3TemperatureDialogFragment.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void onCreateView$lambda$6$lambda$3(DeviceC3TemperatureDialogFragment deviceC3TemperatureDialogFragment, View view) {
        Device device = deviceC3TemperatureDialogFragment.getViewModel().getDevice();
        if (device != null && DeviceKt.isCelsiusUnit(device)) {
            deviceC3TemperatureDialogFragment.getViewModel().temperatureUnitChanged(device);
        }
    }

    /* access modifiers changed from: private */
    public static final void onCreateView$lambda$6$lambda$5(DeviceC3TemperatureDialogFragment deviceC3TemperatureDialogFragment, View view) {
        Device device = deviceC3TemperatureDialogFragment.getViewModel().getDevice();
        if (device != null && !DeviceKt.isCelsiusUnit(device)) {
            deviceC3TemperatureDialogFragment.getViewModel().temperatureUnitChanged(device);
        }
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateView$lambda$7(DeviceC3TemperatureDialogFragment deviceC3TemperatureDialogFragment, Device device) {
        boolean isCelsiusUnit = DeviceKt.isCelsiusUnit(device);
        DialogfragmentDeviceC3TemperatureBinding dialogfragmentDeviceC3TemperatureBinding = deviceC3TemperatureDialogFragment.binding;
        DialogfragmentDeviceC3TemperatureBinding dialogfragmentDeviceC3TemperatureBinding2 = null;
        if (dialogfragmentDeviceC3TemperatureBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogfragmentDeviceC3TemperatureBinding = null;
        }
        AppCompatImageView appCompatImageView = dialogfragmentDeviceC3TemperatureBinding.selectC;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "selectC");
        int i = 0;
        appCompatImageView.setVisibility(isCelsiusUnit ? 0 : 8);
        DialogfragmentDeviceC3TemperatureBinding dialogfragmentDeviceC3TemperatureBinding3 = deviceC3TemperatureDialogFragment.binding;
        if (dialogfragmentDeviceC3TemperatureBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            dialogfragmentDeviceC3TemperatureBinding2 = dialogfragmentDeviceC3TemperatureBinding3;
        }
        AppCompatImageView appCompatImageView2 = dialogfragmentDeviceC3TemperatureBinding2.selectF;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView2, "selectF");
        View view = appCompatImageView2;
        if (isCelsiusUnit) {
            i = 8;
        }
        view.setVisibility(i);
        return Unit.INSTANCE;
    }

    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setLayout(-1, -1);
        }
    }
}
