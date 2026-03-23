package com.blueair.devicedetails.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.AnalyticEvent;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceNewClassic;
import com.blueair.core.model.FilterTrigger;
import com.blueair.core.model.HasG4NightMode;
import com.blueair.devicedetails.adapter.DeviceNSettingsAdapter;
import com.blueair.devicedetails.databinding.DialogfragmentDeviceNProductSettingsBinding;
import com.blueair.devicedetails.util.DeviceNSettings;
import com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel;
import com.blueair.viewcore.R;
import com.blueair.viewcore.dialog.BaseDialogFragment;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 !2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J$\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u001a\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001d\u001a\u00020\u001bH\u0016J\u0010\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020 H\u0016R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\u0002X.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/blueair/devicedetails/dialog/DeviceNProductSettingsDialogFragment;", "Lcom/blueair/viewcore/dialog/BaseDialogFragment;", "Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "binding", "Lcom/blueair/devicedetails/databinding/DialogfragmentDeviceNProductSettingsBinding;", "viewModel", "getViewModel", "()Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;", "setViewModel", "(Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;)V", "adapter", "Lcom/blueair/devicedetails/adapter/DeviceNSettingsAdapter;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onStart", "showProgress", "shouldShowProgress", "", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceNProductSettingsDialogFragment.kt */
public final class DeviceNProductSettingsDialogFragment extends BaseDialogFragment<DeviceDetailsViewModel> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private DeviceNSettingsAdapter adapter;
    private DialogfragmentDeviceNProductSettingsBinding binding;
    private final String screenName = AnalyticEvent.ScreenViewEvent.DEVICE_SETTINGS;
    public DeviceDetailsViewModel viewModel;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceNProductSettingsDialogFragment.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(20:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|(2:17|18)|19|21) */
        /* JADX WARNING: Can't wrap try/catch for region: R(21:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|21) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0034 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x003d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0046 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0050 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                com.blueair.devicedetails.util.DeviceNSettings[] r0 = com.blueair.devicedetails.util.DeviceNSettings.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.blueair.devicedetails.util.DeviceNSettings r1 = com.blueair.devicedetails.util.DeviceNSettings.CUSTOM_NAME     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.blueair.devicedetails.util.DeviceNSettings r1 = com.blueair.devicedetails.util.DeviceNSettings.TIME_ZONE     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.blueair.devicedetails.util.DeviceNSettings r1 = com.blueair.devicedetails.util.DeviceNSettings.TRIGGER_AUTO     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.blueair.devicedetails.util.DeviceNSettings r1 = com.blueair.devicedetails.util.DeviceNSettings.TRIGGER_NIGHT     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                com.blueair.devicedetails.util.DeviceNSettings r1 = com.blueair.devicedetails.util.DeviceNSettings.PRODUCT_INFO     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                com.blueair.devicedetails.util.DeviceNSettings r1 = com.blueair.devicedetails.util.DeviceNSettings.SYSTEM_INFO     // Catch:{ NoSuchFieldError -> 0x003d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                com.blueair.devicedetails.util.DeviceNSettings r1 = com.blueair.devicedetails.util.DeviceNSettings.DELETE     // Catch:{ NoSuchFieldError -> 0x0046 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0046 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0046 }
            L_0x0046:
                com.blueair.devicedetails.util.DeviceNSettings r1 = com.blueair.devicedetails.util.DeviceNSettings.TEMPERATURE     // Catch:{ NoSuchFieldError -> 0x0050 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0050 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0050 }
            L_0x0050:
                com.blueair.devicedetails.util.DeviceNSettings r1 = com.blueair.devicedetails.util.DeviceNSettings.DRY_MODE     // Catch:{ NoSuchFieldError -> 0x005a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x005a }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x005a }
            L_0x005a:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.dialog.DeviceNProductSettingsDialogFragment.WhenMappings.<clinit>():void");
        }
    }

    public void showProgress(boolean z) {
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/blueair/devicedetails/dialog/DeviceNProductSettingsDialogFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/dialog/DeviceNProductSettingsDialogFragment;", "device", "Lcom/blueair/core/model/Device;", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceNProductSettingsDialogFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DeviceNProductSettingsDialogFragment newInstance(Device device) {
            Intrinsics.checkNotNullParameter(device, "device");
            DeviceNProductSettingsDialogFragment deviceNProductSettingsDialogFragment = new DeviceNProductSettingsDialogFragment();
            deviceNProductSettingsDialogFragment.setArguments(BundleKt.bundleOf(TuplesKt.to("device", device)));
            return deviceNProductSettingsDialogFragment;
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
        setStyle(0, R.style.DialogTheme);
        Dialog dialog = getDialog();
        if (!(dialog == null || (window = dialog.getWindow()) == null)) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setWindowAnimations(R.style.dialog_animation);
            window.setGravity(80);
        }
        Parcelable parcelable = requireArguments().getParcelable("device");
        if (parcelable != null) {
            Device device = (Device) parcelable;
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
            setViewModel((DeviceDetailsViewModel) ((BaseViewModel) new ViewModelProvider((ViewModelStoreOwner) requireActivity).get(DeviceDetailsViewModel.class)));
            getViewModel().setDeviceId(device.getUid());
            getViewModel().setDevice(device);
            DialogfragmentDeviceNProductSettingsBinding inflate = DialogfragmentDeviceNProductSettingsBinding.inflate(layoutInflater, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            if (!(device instanceof DeviceNewClassic)) {
                inflate.closeBtn.setVisibility(4);
                inflate.doneBtn.setVisibility(0);
                inflate.contentContainer.setBackgroundTintList(ColorStateList.valueOf(requireContext().getColor(R.color.anti_flash_blue)));
            }
            this.binding = inflate;
            if (inflate == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                inflate = null;
            }
            View root = inflate.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
            return root;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        super.onViewCreated(view, bundle);
        DialogfragmentDeviceNProductSettingsBinding dialogfragmentDeviceNProductSettingsBinding = this.binding;
        DeviceNSettingsAdapter deviceNSettingsAdapter = null;
        if (dialogfragmentDeviceNProductSettingsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogfragmentDeviceNProductSettingsBinding = null;
        }
        dialogfragmentDeviceNProductSettingsBinding.closeBtn.setOnClickListener(new DeviceNProductSettingsDialogFragment$$ExternalSyntheticLambda0(this));
        dialogfragmentDeviceNProductSettingsBinding.doneBtn.setOnClickListener(new DeviceNProductSettingsDialogFragment$$ExternalSyntheticLambda1(this));
        dialogfragmentDeviceNProductSettingsBinding.settingsList.setLayoutManager(new LinearLayoutManager(requireContext()));
        DeviceNSettingsAdapter deviceNSettingsAdapter2 = new DeviceNSettingsAdapter();
        this.adapter = deviceNSettingsAdapter2;
        deviceNSettingsAdapter2.setOnSettingActionListener(new DeviceNProductSettingsDialogFragment$$ExternalSyntheticLambda2(this));
        RecyclerView recyclerView = dialogfragmentDeviceNProductSettingsBinding.settingsList;
        DeviceNSettingsAdapter deviceNSettingsAdapter3 = this.adapter;
        if (deviceNSettingsAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        } else {
            deviceNSettingsAdapter = deviceNSettingsAdapter3;
        }
        recyclerView.setAdapter(deviceNSettingsAdapter);
        getViewModel().getLiveDevice().observe(getViewLifecycleOwner(), new DeviceNProductSettingsDialogFragment$sam$androidx_lifecycle_Observer$0(new DeviceNProductSettingsDialogFragment$$ExternalSyntheticLambda3(this)));
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$15$lambda$2(DeviceNProductSettingsDialogFragment deviceNProductSettingsDialogFragment, View view) {
        deviceNProductSettingsDialogFragment.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$15$lambda$3(DeviceNProductSettingsDialogFragment deviceNProductSettingsDialogFragment, View view) {
        deviceNProductSettingsDialogFragment.dismiss();
    }

    /* access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$15$lambda$13(DeviceNProductSettingsDialogFragment deviceNProductSettingsDialogFragment, DeviceNSettings deviceNSettings, Device device, Object obj) {
        Intrinsics.checkNotNullParameter(deviceNSettings, "type");
        Intrinsics.checkNotNullParameter(device, "device");
        Intrinsics.checkNotNullParameter(obj, "data");
        switch (WhenMappings.$EnumSwitchMapping$0[deviceNSettings.ordinal()]) {
            case 1:
                FragmentManager childFragmentManager = deviceNProductSettingsDialogFragment.getChildFragmentManager();
                Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
                Class<DeviceEditNameDialogFragment> cls = DeviceEditNameDialogFragment.class;
                Intrinsics.checkNotNullExpressionValue("DeviceEditNameDialogFragment", "getSimpleName(...)");
                if (!(childFragmentManager.findFragmentByTag("DeviceEditNameDialogFragment") instanceof DeviceEditNameDialogFragment) && !childFragmentManager.isStateSaved()) {
                    DeviceEditNameDialogFragment.Companion.newInstance(device).show(childFragmentManager, "DeviceEditNameDialogFragment");
                    break;
                }
            case 2:
                FragmentManager childFragmentManager2 = deviceNProductSettingsDialogFragment.getChildFragmentManager();
                Intrinsics.checkNotNullExpressionValue(childFragmentManager2, "getChildFragmentManager(...)");
                Class<DeviceSetTimezoneDialogFragment> cls2 = DeviceSetTimezoneDialogFragment.class;
                Intrinsics.checkNotNullExpressionValue("DeviceSetTimezoneDialogFragment", "getSimpleName(...)");
                if (!(childFragmentManager2.findFragmentByTag("DeviceSetTimezoneDialogFragment") instanceof DeviceSetTimezoneDialogFragment) && !childFragmentManager2.isStateSaved()) {
                    DeviceSetTimezoneDialogFragment.Companion.newInstance(device).show(childFragmentManager2, "DeviceSetTimezoneDialogFragment");
                    break;
                }
            case 3:
                deviceNProductSettingsDialogFragment.getViewModel().autoModeFilterTriggerChanged((FilterTrigger) obj, ((HasG4NightMode) device).getG4NightModeTrigger());
                break;
            case 4:
                deviceNProductSettingsDialogFragment.getViewModel().autoModeFilterTriggerChanged(((HasG4NightMode) device).getTrigger(), (FilterTrigger) obj);
                break;
            case 5:
                FragmentManager childFragmentManager3 = deviceNProductSettingsDialogFragment.getChildFragmentManager();
                Intrinsics.checkNotNullExpressionValue(childFragmentManager3, "getChildFragmentManager(...)");
                Class<DeviceSettingInfoDialogFragment> cls3 = DeviceSettingInfoDialogFragment.class;
                Intrinsics.checkNotNullExpressionValue("DeviceSettingInfoDialogFragment", "getSimpleName(...)");
                if (!(childFragmentManager3.findFragmentByTag("DeviceSettingInfoDialogFragment") instanceof DeviceSettingInfoDialogFragment) && !childFragmentManager3.isStateSaved()) {
                    DeviceSettingInfoDialogFragment.Companion.newInstance(device).show(childFragmentManager3, "DeviceSettingInfoDialogFragment");
                    break;
                }
            case 6:
                new AlertDialog.Builder(deviceNProductSettingsDialogFragment.requireContext()).setMessage(R.string.error_report_open_confirmation).setPositiveButton(17039370, new DeviceNProductSettingsDialogFragment$$ExternalSyntheticLambda4(deviceNProductSettingsDialogFragment, device)).setNegativeButton(17039360, new DeviceNProductSettingsDialogFragment$$ExternalSyntheticLambda5()).show();
                break;
            case 7:
                FragmentManager childFragmentManager4 = deviceNProductSettingsDialogFragment.getChildFragmentManager();
                Intrinsics.checkNotNullExpressionValue(childFragmentManager4, "getChildFragmentManager(...)");
                Class<DeleteDeviceDialogFragment> cls4 = DeleteDeviceDialogFragment.class;
                Intrinsics.checkNotNullExpressionValue("DeleteDeviceDialogFragment", "getSimpleName(...)");
                if (!(childFragmentManager4.findFragmentByTag("DeleteDeviceDialogFragment") instanceof DeleteDeviceDialogFragment) && !childFragmentManager4.isStateSaved()) {
                    DeleteDeviceDialogFragment.Companion.newInstance(device, false).show(childFragmentManager4, "DeleteDeviceDialogFragment");
                    break;
                }
            case 8:
                FragmentManager childFragmentManager5 = deviceNProductSettingsDialogFragment.getChildFragmentManager();
                Intrinsics.checkNotNullExpressionValue(childFragmentManager5, "getChildFragmentManager(...)");
                Class<DeviceC3TemperatureDialogFragment> cls5 = DeviceC3TemperatureDialogFragment.class;
                Intrinsics.checkNotNullExpressionValue("DeviceC3TemperatureDialogFragment", "getSimpleName(...)");
                if (!(childFragmentManager5.findFragmentByTag("DeviceC3TemperatureDialogFragment") instanceof DeviceC3TemperatureDialogFragment) && !childFragmentManager5.isStateSaved()) {
                    DeviceC3TemperatureDialogFragment.Companion.newInstance().show(childFragmentManager5, "DeviceC3TemperatureDialogFragment");
                    break;
                }
            case 9:
                FragmentManager childFragmentManager6 = deviceNProductSettingsDialogFragment.getChildFragmentManager();
                Intrinsics.checkNotNullExpressionValue(childFragmentManager6, "getChildFragmentManager(...)");
                Class<DeviceHDryModeDialogFragment> cls6 = DeviceHDryModeDialogFragment.class;
                Intrinsics.checkNotNullExpressionValue("DeviceHDryModeDialogFragment", "getSimpleName(...)");
                if (!(childFragmentManager6.findFragmentByTag("DeviceHDryModeDialogFragment") instanceof DeviceHDryModeDialogFragment) && !childFragmentManager6.isStateSaved()) {
                    DeviceHDryModeDialogFragment.Companion.newInstance().show(childFragmentManager6, "DeviceHDryModeDialogFragment");
                    break;
                }
            default:
                throw new NoWhenBranchMatchedException();
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$15$lambda$13$lambda$8(DeviceNProductSettingsDialogFragment deviceNProductSettingsDialogFragment, Device device, DialogInterface dialogInterface, int i) {
        FragmentManager childFragmentManager = deviceNProductSettingsDialogFragment.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        Class<DeviceErrorReportDialogFragment> cls = DeviceErrorReportDialogFragment.class;
        Intrinsics.checkNotNullExpressionValue("DeviceErrorReportDialogFragment", "getSimpleName(...)");
        if (!(childFragmentManager.findFragmentByTag("DeviceErrorReportDialogFragment") instanceof DeviceErrorReportDialogFragment) && !childFragmentManager.isStateSaved()) {
            DeviceErrorReportDialogFragment.Companion.newInstance(device).show(childFragmentManager, "DeviceErrorReportDialogFragment");
        }
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$15$lambda$13$lambda$9(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
    }

    /* access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$15$lambda$14(DeviceNProductSettingsDialogFragment deviceNProductSettingsDialogFragment, Device device) {
        if (device == null) {
            deviceNProductSettingsDialogFragment.dismiss();
        } else {
            deviceNProductSettingsDialogFragment.getViewModel().setDevice(device);
            DeviceNSettingsAdapter deviceNSettingsAdapter = deviceNProductSettingsDialogFragment.adapter;
            if (deviceNSettingsAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                deviceNSettingsAdapter = null;
            }
            deviceNSettingsAdapter.setDevice(device);
        }
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
