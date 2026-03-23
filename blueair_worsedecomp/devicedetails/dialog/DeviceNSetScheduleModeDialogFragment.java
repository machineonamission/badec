package com.blueair.devicedetails.dialog;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.AnalyticEvent;
import com.blueair.core.model.BlueDeviceScheduleEndType;
import com.blueair.core.model.Device;
import com.blueair.devicedetails.adapter.DeviceNScheduleModeAdapter;
import com.blueair.devicedetails.databinding.DialogfragmentDeviceNSetScheduleModeBinding;
import com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel;
import com.blueair.viewcore.R;
import com.blueair.viewcore.dialog.BaseDialogFragment;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \"2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J$\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u001a\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001f\u001a\u00020\u001dH\u0016J\u0010\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u0011H\u0016R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\u0002X.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X.¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/blueair/devicedetails/dialog/DeviceNSetScheduleModeDialogFragment;", "Lcom/blueair/viewcore/dialog/BaseDialogFragment;", "Lcom/blueair/devicedetails/viewmodel/DeviceCreateEditScheduleViewModel;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "binding", "Lcom/blueair/devicedetails/databinding/DialogfragmentDeviceNSetScheduleModeBinding;", "viewModel", "getViewModel", "()Lcom/blueair/devicedetails/viewmodel/DeviceCreateEditScheduleViewModel;", "setViewModel", "(Lcom/blueair/devicedetails/viewmodel/DeviceCreateEditScheduleViewModel;)V", "isStartMode", "", "adapter", "Lcom/blueair/devicedetails/adapter/DeviceNScheduleModeAdapter;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onStart", "showProgress", "shouldShowProgress", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceNSetScheduleModeDialogFragment.kt */
public final class DeviceNSetScheduleModeDialogFragment extends BaseDialogFragment<DeviceCreateEditScheduleViewModel> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String EXTRA_IS_START_MODE = "EXTRA_IS_START_MODE";
    private DeviceNScheduleModeAdapter adapter;
    private DialogfragmentDeviceNSetScheduleModeBinding binding;
    private boolean isStartMode = true;
    private final String screenName = AnalyticEvent.ScreenViewEvent.DEVICE_DETAILS_SCHEDULE_MODE;
    public DeviceCreateEditScheduleViewModel viewModel;

    public void showProgress(boolean z) {
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/blueair/devicedetails/dialog/DeviceNSetScheduleModeDialogFragment$Companion;", "", "<init>", "()V", "EXTRA_IS_START_MODE", "", "newInstance", "Lcom/blueair/devicedetails/dialog/DeviceNSetScheduleModeDialogFragment;", "isStartMode", "", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceNSetScheduleModeDialogFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DeviceNSetScheduleModeDialogFragment newInstance(boolean z) {
            DeviceNSetScheduleModeDialogFragment deviceNSetScheduleModeDialogFragment = new DeviceNSetScheduleModeDialogFragment();
            deviceNSetScheduleModeDialogFragment.setArguments(BundleKt.bundleOf(TuplesKt.to(DeviceNSetScheduleModeDialogFragment.EXTRA_IS_START_MODE, Boolean.valueOf(z))));
            return deviceNSetScheduleModeDialogFragment;
        }
    }

    /* access modifiers changed from: protected */
    public String getScreenName() {
        return this.screenName;
    }

    public DeviceCreateEditScheduleViewModel getViewModel() {
        DeviceCreateEditScheduleViewModel deviceCreateEditScheduleViewModel = this.viewModel;
        if (deviceCreateEditScheduleViewModel != null) {
            return deviceCreateEditScheduleViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        return null;
    }

    public void setViewModel(DeviceCreateEditScheduleViewModel deviceCreateEditScheduleViewModel) {
        Intrinsics.checkNotNullParameter(deviceCreateEditScheduleViewModel, "<set-?>");
        this.viewModel = deviceCreateEditScheduleViewModel;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        DeviceCreateEditScheduleViewModel deviceCreateEditScheduleViewModel;
        Window window;
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        setStyle(0, R.style.DialogTheme);
        Dialog dialog = getDialog();
        if (!(dialog == null || (window = dialog.getWindow()) == null)) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setWindowAnimations(R.style.dialog_animation);
            window.setGravity(80);
        }
        this.isStartMode = requireArguments().getBoolean(EXTRA_IS_START_MODE, true);
        if (getParentFragment() == null) {
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
            deviceCreateEditScheduleViewModel = (DeviceCreateEditScheduleViewModel) ((BaseViewModel) new ViewModelProvider((ViewModelStoreOwner) requireActivity).get(DeviceCreateEditScheduleViewModel.class));
        } else {
            BaseDialogFragment baseDialogFragment = this;
            Fragment requireParentFragment = requireParentFragment();
            Intrinsics.checkNotNullExpressionValue(requireParentFragment, "requireParentFragment(...)");
            deviceCreateEditScheduleViewModel = (DeviceCreateEditScheduleViewModel) ((BaseViewModel) new ViewModelProvider((ViewModelStoreOwner) requireParentFragment).get(DeviceCreateEditScheduleViewModel.class));
        }
        setViewModel(deviceCreateEditScheduleViewModel);
        DialogfragmentDeviceNSetScheduleModeBinding inflate = DialogfragmentDeviceNSetScheduleModeBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        View root = inflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    public void onViewCreated(View view, Bundle bundle) {
        DeviceNScheduleModeAdapter deviceNScheduleModeAdapter;
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        super.onViewCreated(view, bundle);
        DialogfragmentDeviceNSetScheduleModeBinding dialogfragmentDeviceNSetScheduleModeBinding = this.binding;
        DeviceNScheduleModeAdapter deviceNScheduleModeAdapter2 = null;
        if (dialogfragmentDeviceNSetScheduleModeBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogfragmentDeviceNSetScheduleModeBinding = null;
        }
        dialogfragmentDeviceNSetScheduleModeBinding.title.setText(this.isStartMode ? R.string.schedule_set_start_mode : R.string.schedule_set_end_mode);
        dialogfragmentDeviceNSetScheduleModeBinding.backBtn.setOnClickListener(new DeviceNSetScheduleModeDialogFragment$$ExternalSyntheticLambda0(this));
        dialogfragmentDeviceNSetScheduleModeBinding.saveBtn.setOnClickListener(new DeviceNSetScheduleModeDialogFragment$$ExternalSyntheticLambda1(this));
        dialogfragmentDeviceNSetScheduleModeBinding.modeControls.setLayoutManager(new LinearLayoutManager(requireContext()));
        String value = getViewModel().getScheduleEndType().getValue();
        if (value == null) {
            value = BlueDeviceScheduleEndType.PREVIOUS;
        }
        String str = value;
        if (this.isStartMode) {
            Device device = getViewModel().getDevice();
            Intrinsics.checkNotNull(device);
            deviceNScheduleModeAdapter = new DeviceNScheduleModeAdapter(device, true, str, getViewModel().getPurifierMode(), getViewModel().getStartFanSpeed(), getViewModel().getStartBrightness(), getViewModel().getStartAutoRh(), getViewModel().getStartMainMode(), getViewModel().getStartApSubMode(), getViewModel().getStartSmartSubMode(), getViewModel().getStartHeatAutoTemp(), getViewModel().getStartHeatEcoTemp(), getViewModel().getStartOscillationEnabled(), getViewModel().getStartHumMode());
        } else {
            Device device2 = getViewModel().getDevice();
            Intrinsics.checkNotNull(device2);
            deviceNScheduleModeAdapter = new DeviceNScheduleModeAdapter(device2, false, str, getViewModel().getScheduleEndCustomMode(), getViewModel().getScheduleEndCustomFanSpeed(), getViewModel().getScheduleEndCustomBrightness(), getViewModel().getScheduleEndCustomAutoRh(), getViewModel().getScheduleEndCustomMainMode(), getViewModel().getScheduleEndCustomApSubMode(), getViewModel().getScheduleEndCustomSmartSubMode(), getViewModel().getScheduleEndCustomHeatAutoTemp(), getViewModel().getScheduleEndCustomHeatEcoTemp(), getViewModel().getScheduleEndCustomOscillationEnabled(), getViewModel().getScheduleEndCustomHumMode());
        }
        this.adapter = deviceNScheduleModeAdapter;
        RecyclerView recyclerView = dialogfragmentDeviceNSetScheduleModeBinding.modeControls;
        DeviceNScheduleModeAdapter deviceNScheduleModeAdapter3 = this.adapter;
        if (deviceNScheduleModeAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        } else {
            deviceNScheduleModeAdapter2 = deviceNScheduleModeAdapter3;
        }
        recyclerView.setAdapter(deviceNScheduleModeAdapter2);
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$3$lambda$1(DeviceNSetScheduleModeDialogFragment deviceNSetScheduleModeDialogFragment, View view) {
        deviceNSetScheduleModeDialogFragment.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$3$lambda$2(DeviceNSetScheduleModeDialogFragment deviceNSetScheduleModeDialogFragment, View view) {
        DeviceNScheduleModeAdapter deviceNScheduleModeAdapter = null;
        if (deviceNSetScheduleModeDialogFragment.isStartMode) {
            DeviceCreateEditScheduleViewModel viewModel2 = deviceNSetScheduleModeDialogFragment.getViewModel();
            DeviceNScheduleModeAdapter deviceNScheduleModeAdapter2 = deviceNSetScheduleModeDialogFragment.adapter;
            if (deviceNScheduleModeAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                deviceNScheduleModeAdapter2 = null;
            }
            viewModel2.setStartFanSpeed(deviceNScheduleModeAdapter2.getFanSpeed());
            DeviceCreateEditScheduleViewModel viewModel3 = deviceNSetScheduleModeDialogFragment.getViewModel();
            DeviceNScheduleModeAdapter deviceNScheduleModeAdapter3 = deviceNSetScheduleModeDialogFragment.adapter;
            if (deviceNScheduleModeAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                deviceNScheduleModeAdapter3 = null;
            }
            viewModel3.setPurifierMode(deviceNScheduleModeAdapter3.getMode());
            DeviceCreateEditScheduleViewModel viewModel4 = deviceNSetScheduleModeDialogFragment.getViewModel();
            DeviceNScheduleModeAdapter deviceNScheduleModeAdapter4 = deviceNSetScheduleModeDialogFragment.adapter;
            if (deviceNScheduleModeAdapter4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                deviceNScheduleModeAdapter4 = null;
            }
            viewModel4.setStartBrightness(deviceNScheduleModeAdapter4.getBrightness());
            DeviceCreateEditScheduleViewModel viewModel5 = deviceNSetScheduleModeDialogFragment.getViewModel();
            DeviceNScheduleModeAdapter deviceNScheduleModeAdapter5 = deviceNSetScheduleModeDialogFragment.adapter;
            if (deviceNScheduleModeAdapter5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                deviceNScheduleModeAdapter5 = null;
            }
            viewModel5.setStartAutoRh(deviceNScheduleModeAdapter5.getAutoRh());
            DeviceCreateEditScheduleViewModel viewModel6 = deviceNSetScheduleModeDialogFragment.getViewModel();
            DeviceNScheduleModeAdapter deviceNScheduleModeAdapter6 = deviceNSetScheduleModeDialogFragment.adapter;
            if (deviceNScheduleModeAdapter6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                deviceNScheduleModeAdapter6 = null;
            }
            viewModel6.setStartMainMode(deviceNScheduleModeAdapter6.getMainMode());
            DeviceCreateEditScheduleViewModel viewModel7 = deviceNSetScheduleModeDialogFragment.getViewModel();
            DeviceNScheduleModeAdapter deviceNScheduleModeAdapter7 = deviceNSetScheduleModeDialogFragment.adapter;
            if (deviceNScheduleModeAdapter7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                deviceNScheduleModeAdapter7 = null;
            }
            viewModel7.setStartApSubMode(deviceNScheduleModeAdapter7.getApSubMode());
            DeviceCreateEditScheduleViewModel viewModel8 = deviceNSetScheduleModeDialogFragment.getViewModel();
            DeviceNScheduleModeAdapter deviceNScheduleModeAdapter8 = deviceNSetScheduleModeDialogFragment.adapter;
            if (deviceNScheduleModeAdapter8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                deviceNScheduleModeAdapter8 = null;
            }
            viewModel8.setStartSmartSubMode(deviceNScheduleModeAdapter8.getSmartSubMode());
            DeviceCreateEditScheduleViewModel viewModel9 = deviceNSetScheduleModeDialogFragment.getViewModel();
            DeviceNScheduleModeAdapter deviceNScheduleModeAdapter9 = deviceNSetScheduleModeDialogFragment.adapter;
            if (deviceNScheduleModeAdapter9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                deviceNScheduleModeAdapter9 = null;
            }
            viewModel9.setStartHeatAutoTemp(deviceNScheduleModeAdapter9.getHeatAutoTemp());
            DeviceCreateEditScheduleViewModel viewModel10 = deviceNSetScheduleModeDialogFragment.getViewModel();
            DeviceNScheduleModeAdapter deviceNScheduleModeAdapter10 = deviceNSetScheduleModeDialogFragment.adapter;
            if (deviceNScheduleModeAdapter10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                deviceNScheduleModeAdapter10 = null;
            }
            viewModel10.setStartHeatEcoTemp(deviceNScheduleModeAdapter10.getHeatEcoTmp());
            DeviceCreateEditScheduleViewModel viewModel11 = deviceNSetScheduleModeDialogFragment.getViewModel();
            DeviceNScheduleModeAdapter deviceNScheduleModeAdapter11 = deviceNSetScheduleModeDialogFragment.adapter;
            if (deviceNScheduleModeAdapter11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                deviceNScheduleModeAdapter11 = null;
            }
            viewModel11.setStartOscillationEnabled(deviceNScheduleModeAdapter11.getOscillationEnabled());
            DeviceCreateEditScheduleViewModel viewModel12 = deviceNSetScheduleModeDialogFragment.getViewModel();
            DeviceNScheduleModeAdapter deviceNScheduleModeAdapter12 = deviceNSetScheduleModeDialogFragment.adapter;
            if (deviceNScheduleModeAdapter12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
            } else {
                deviceNScheduleModeAdapter = deviceNScheduleModeAdapter12;
            }
            viewModel12.setStartHumMode(deviceNScheduleModeAdapter.getHumMode());
        } else {
            MutableLiveData<String> scheduleEndType = deviceNSetScheduleModeDialogFragment.getViewModel().getScheduleEndType();
            DeviceNScheduleModeAdapter deviceNScheduleModeAdapter13 = deviceNSetScheduleModeDialogFragment.adapter;
            if (deviceNScheduleModeAdapter13 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                deviceNScheduleModeAdapter13 = null;
            }
            scheduleEndType.setValue(deviceNScheduleModeAdapter13.getCustomType());
            DeviceCreateEditScheduleViewModel viewModel13 = deviceNSetScheduleModeDialogFragment.getViewModel();
            DeviceNScheduleModeAdapter deviceNScheduleModeAdapter14 = deviceNSetScheduleModeDialogFragment.adapter;
            if (deviceNScheduleModeAdapter14 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                deviceNScheduleModeAdapter14 = null;
            }
            viewModel13.setScheduleEndCustomFanSpeed(deviceNScheduleModeAdapter14.getFanSpeed());
            DeviceCreateEditScheduleViewModel viewModel14 = deviceNSetScheduleModeDialogFragment.getViewModel();
            DeviceNScheduleModeAdapter deviceNScheduleModeAdapter15 = deviceNSetScheduleModeDialogFragment.adapter;
            if (deviceNScheduleModeAdapter15 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                deviceNScheduleModeAdapter15 = null;
            }
            viewModel14.setScheduleEndCustomMode(deviceNScheduleModeAdapter15.getMode());
            DeviceCreateEditScheduleViewModel viewModel15 = deviceNSetScheduleModeDialogFragment.getViewModel();
            DeviceNScheduleModeAdapter deviceNScheduleModeAdapter16 = deviceNSetScheduleModeDialogFragment.adapter;
            if (deviceNScheduleModeAdapter16 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                deviceNScheduleModeAdapter16 = null;
            }
            viewModel15.setScheduleEndCustomBrightness(deviceNScheduleModeAdapter16.getBrightness());
            DeviceCreateEditScheduleViewModel viewModel16 = deviceNSetScheduleModeDialogFragment.getViewModel();
            DeviceNScheduleModeAdapter deviceNScheduleModeAdapter17 = deviceNSetScheduleModeDialogFragment.adapter;
            if (deviceNScheduleModeAdapter17 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                deviceNScheduleModeAdapter17 = null;
            }
            viewModel16.setScheduleEndCustomAutoRh(deviceNScheduleModeAdapter17.getAutoRh());
            DeviceCreateEditScheduleViewModel viewModel17 = deviceNSetScheduleModeDialogFragment.getViewModel();
            DeviceNScheduleModeAdapter deviceNScheduleModeAdapter18 = deviceNSetScheduleModeDialogFragment.adapter;
            if (deviceNScheduleModeAdapter18 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                deviceNScheduleModeAdapter18 = null;
            }
            viewModel17.setScheduleEndCustomMainMode(deviceNScheduleModeAdapter18.getMainMode());
            DeviceCreateEditScheduleViewModel viewModel18 = deviceNSetScheduleModeDialogFragment.getViewModel();
            DeviceNScheduleModeAdapter deviceNScheduleModeAdapter19 = deviceNSetScheduleModeDialogFragment.adapter;
            if (deviceNScheduleModeAdapter19 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                deviceNScheduleModeAdapter19 = null;
            }
            viewModel18.setScheduleEndCustomApSubMode(deviceNScheduleModeAdapter19.getApSubMode());
            DeviceCreateEditScheduleViewModel viewModel19 = deviceNSetScheduleModeDialogFragment.getViewModel();
            DeviceNScheduleModeAdapter deviceNScheduleModeAdapter20 = deviceNSetScheduleModeDialogFragment.adapter;
            if (deviceNScheduleModeAdapter20 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                deviceNScheduleModeAdapter20 = null;
            }
            viewModel19.setScheduleEndCustomSmartSubMode(deviceNScheduleModeAdapter20.getSmartSubMode());
            DeviceCreateEditScheduleViewModel viewModel20 = deviceNSetScheduleModeDialogFragment.getViewModel();
            DeviceNScheduleModeAdapter deviceNScheduleModeAdapter21 = deviceNSetScheduleModeDialogFragment.adapter;
            if (deviceNScheduleModeAdapter21 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                deviceNScheduleModeAdapter21 = null;
            }
            viewModel20.setScheduleEndCustomHeatAutoTemp(deviceNScheduleModeAdapter21.getHeatAutoTemp());
            DeviceCreateEditScheduleViewModel viewModel21 = deviceNSetScheduleModeDialogFragment.getViewModel();
            DeviceNScheduleModeAdapter deviceNScheduleModeAdapter22 = deviceNSetScheduleModeDialogFragment.adapter;
            if (deviceNScheduleModeAdapter22 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                deviceNScheduleModeAdapter22 = null;
            }
            viewModel21.setScheduleEndCustomHeatEcoTemp(deviceNScheduleModeAdapter22.getHeatEcoTmp());
            DeviceCreateEditScheduleViewModel viewModel22 = deviceNSetScheduleModeDialogFragment.getViewModel();
            DeviceNScheduleModeAdapter deviceNScheduleModeAdapter23 = deviceNSetScheduleModeDialogFragment.adapter;
            if (deviceNScheduleModeAdapter23 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                deviceNScheduleModeAdapter23 = null;
            }
            viewModel22.setScheduleEndCustomOscillationEnabled(deviceNScheduleModeAdapter23.getOscillationEnabled());
            DeviceCreateEditScheduleViewModel viewModel23 = deviceNSetScheduleModeDialogFragment.getViewModel();
            DeviceNScheduleModeAdapter deviceNScheduleModeAdapter24 = deviceNSetScheduleModeDialogFragment.adapter;
            if (deviceNScheduleModeAdapter24 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
            } else {
                deviceNScheduleModeAdapter = deviceNScheduleModeAdapter24;
            }
            viewModel23.setScheduleEndCustomHumMode(deviceNScheduleModeAdapter.getHumMode());
        }
        deviceNSetScheduleModeDialogFragment.dismiss();
    }

    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setLayout(-1, -2);
        }
    }
}
