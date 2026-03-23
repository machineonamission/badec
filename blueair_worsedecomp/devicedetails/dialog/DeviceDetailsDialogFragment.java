package com.blueair.devicedetails.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.os.BundleKt;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.blueair.auth.LocationService;
import com.blueair.core.model.ConnectivityStatus;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceFilterType;
import com.blueair.core.model.DeviceImage;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.DeviceNewClassic;
import com.blueair.core.model.HasLocation;
import com.blueair.core.model.HasSafetySwitch;
import com.blueair.core.model.HasScheduling;
import com.blueair.core.model.HasSensorData;
import com.blueair.core.model.HasWelcomeHome;
import com.blueair.core.model.TrackedLocation;
import com.blueair.devicedetails.databinding.DialogfragmentDeviceDetailsBinding;
import com.blueair.devicedetails.fragment.DeviceAttributesFragment;
import com.blueair.devicedetails.fragment.DeviceHSensorsFragment;
import com.blueair.devicedetails.fragment.DeviceNSchedulesFragment;
import com.blueair.devicedetails.fragment.DeviceNWelcomeHomeFragment;
import com.blueair.devicedetails.fragment.DeviceSchedulesFragment;
import com.blueair.devicedetails.fragment.DeviceSensorsFragment;
import com.blueair.devicedetails.fragment.DeviceSettingsFragment;
import com.blueair.devicedetails.fragment.DeviceWelcomeHomeFragment;
import com.blueair.devicedetails.viewmodel.DeviceDetailsState;
import com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel;
import com.blueair.push.NotificationService;
import com.blueair.viewcore.R;
import com.blueair.viewcore.ViewUtils;
import com.blueair.viewcore.activity.Actions;
import com.blueair.viewcore.dialog.BaseDialogFragment;
import com.blueair.viewcore.dialog.ConfirmationDialogCentered;
import com.blueair.viewcore.fragment.BaseFragment;
import com.blueair.viewcore.utils.DeviceConfigProvider;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import io.flatcircle.connectivityhelper.NetUtil;
import io.flatcircle.livedatahelper.LiveDataExtensionsKt;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import timber.log.Timber;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 =2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001=B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016J$\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u001a\u0010\"\u001a\u00020\u00182\u0006\u0010#\u001a\u00020\u001b2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0010\u0010$\u001a\u00020\u00182\u0006\u0010\u0010\u001a\u00020%H\u0002J\b\u0010&\u001a\u00020\u0018H\u0002J\b\u0010'\u001a\u00020\u0018H\u0002J\b\u0010(\u001a\u00020\u0018H\u0002J\b\u0010)\u001a\u00020\u0018H\u0016J\u0010\u0010*\u001a\u00020\u00182\u0006\u0010+\u001a\u00020,H\u0002J\b\u0010-\u001a\u00020\u0018H\u0002J\b\u0010.\u001a\u00020\u0018H\u0002J\b\u0010/\u001a\u00020\u0018H\u0002J\b\u00100\u001a\u00020\u0018H\u0002J\b\u00101\u001a\u00020\u0018H\u0002J\u0010\u00102\u001a\u00020\u00182\u0006\u00103\u001a\u000204H\u0002J\u0010\u00105\u001a\u00020\u00182\u0006\u00103\u001a\u000204H\u0002J\u0010\u00106\u001a\u00020\u00182\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u00107\u001a\u00020\u00182\u0006\u00108\u001a\u00020,H\u0016J\b\u00109\u001a\u00020\u0018H\u0016J\u0010\u0010:\u001a\u00020\u00182\u0006\u0010;\u001a\u00020<H\u0016R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\u0002X.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"Lcom/blueair/devicedetails/dialog/DeviceDetailsDialogFragment;", "Lcom/blueair/viewcore/dialog/BaseDialogFragment;", "Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "viewDataBinding", "Lcom/blueair/devicedetails/databinding/DialogfragmentDeviceDetailsBinding;", "viewModel", "getViewModel", "()Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;", "setViewModel", "(Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;)V", "device", "Lcom/blueair/core/model/Device;", "getDevice", "()Lcom/blueair/core/model/Device;", "setDevice", "(Lcom/blueair/core/model/Device;)V", "actionType", "onStart", "", "onPause", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "showSensorLayout", "Lcom/blueair/core/model/HasSensorData;", "hideSensorLayout", "scrollToFilterStatus", "scrollToWickStatus", "onResume", "handleActions", "refreshDeviceAttributes", "", "bindViewModel", "showDeviceAttributes", "showDeviceSchedules", "showDeviceWelcomeHome", "showDeviceSettingsButton", "shouldShowStartWarningDialog", "state", "Lcom/blueair/devicedetails/viewmodel/DeviceDetailsState;", "shouldShowFilterDoorOpenDialog", "showBanners", "showProgress", "shouldShowProgress", "dismiss", "onCancel", "dialog", "Landroid/content/DialogInterface;", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceDetailsDialogFragment.kt */
public final class DeviceDetailsDialogFragment extends BaseDialogFragment<DeviceDetailsViewModel> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String REQUEST_KEY_HANDLE_ACTION = "REQUEST_KEY_HANDLE_ACTION";
    public static final String TAG = "Device_Details_Dialog";
    /* access modifiers changed from: private */
    public static String jumpToAction;
    private String actionType;
    public Device device;
    private final String screenName = "device_details";
    private DialogfragmentDeviceDetailsBinding viewDataBinding;
    public DeviceDetailsViewModel viewModel;

    public void showProgress(boolean z) {
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcom/blueair/devicedetails/dialog/DeviceDetailsDialogFragment$Companion;", "", "<init>", "()V", "TAG", "", "REQUEST_KEY_HANDLE_ACTION", "jumpToAction", "getJumpToAction", "()Ljava/lang/String;", "setJumpToAction", "(Ljava/lang/String;)V", "newInstance", "Lcom/blueair/devicedetails/dialog/DeviceDetailsDialogFragment;", "device", "Lcom/blueair/core/model/Device;", "actionType", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceDetailsDialogFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getJumpToAction() {
            return DeviceDetailsDialogFragment.jumpToAction;
        }

        public final void setJumpToAction(String str) {
            DeviceDetailsDialogFragment.jumpToAction = str;
        }

        public static /* synthetic */ DeviceDetailsDialogFragment newInstance$default(Companion companion, Device device, String str, int i, Object obj) {
            if ((i & 2) != 0) {
                str = null;
            }
            return companion.newInstance(device, str);
        }

        public final DeviceDetailsDialogFragment newInstance(Device device, String str) {
            Intrinsics.checkNotNullParameter(device, "device");
            DeviceDetailsDialogFragment deviceDetailsDialogFragment = new DeviceDetailsDialogFragment();
            deviceDetailsDialogFragment.setArguments(BundleKt.bundleOf(TuplesKt.to("device", device), TuplesKt.to("action_type", str)));
            return deviceDetailsDialogFragment;
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

    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setLayout(-1, -1);
        }
    }

    public void onPause() {
        Window window;
        WindowManager.LayoutParams attributes;
        Dialog dialog = getDialog();
        if (!(dialog == null || (window = dialog.getWindow()) == null || (attributes = window.getAttributes()) == null)) {
            attributes.windowAnimations = R.style.dialog_animation_exit_only;
        }
        super.onPause();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Window window;
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Dialog dialog = getDialog();
        if (dialog != null) {
            setStyle(0, R.style.DialogTheme);
            Window window2 = dialog.getWindow();
            if (window2 != null) {
                window2.setBackgroundDrawable(new ColorDrawable(0));
            }
            Dialog dialog2 = getDialog();
            if (!(dialog2 == null || (window = dialog2.getWindow()) == null)) {
                window.setWindowAnimations(R.style.dialog_animation);
            }
        }
        DialogfragmentDeviceDetailsBinding inflate = DialogfragmentDeviceDetailsBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        inflate.setDeviceDetailViewModel((DeviceDetailsViewModel) ((BaseViewModel) new ViewModelProvider((ViewModelStoreOwner) this).get(DeviceDetailsViewModel.class)));
        inflate.setLifecycleOwner(this);
        this.viewDataBinding = inflate;
        DialogfragmentDeviceDetailsBinding dialogfragmentDeviceDetailsBinding = null;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            inflate = null;
        }
        DeviceDetailsViewModel deviceDetailViewModel = inflate.getDeviceDetailViewModel();
        if (deviceDetailViewModel != null) {
            setViewModel(deviceDetailViewModel);
            DialogfragmentDeviceDetailsBinding dialogfragmentDeviceDetailsBinding2 = this.viewDataBinding;
            if (dialogfragmentDeviceDetailsBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
                dialogfragmentDeviceDetailsBinding2 = null;
            }
            dialogfragmentDeviceDetailsBinding2.closeBtn.setOnClickListener(new DeviceDetailsDialogFragment$$ExternalSyntheticLambda10(this));
            DialogfragmentDeviceDetailsBinding dialogfragmentDeviceDetailsBinding3 = this.viewDataBinding;
            if (dialogfragmentDeviceDetailsBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            } else {
                dialogfragmentDeviceDetailsBinding = dialogfragmentDeviceDetailsBinding3;
            }
            View root = dialogfragmentDeviceDetailsBinding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
            return root;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    /* access modifiers changed from: private */
    public static final void onCreateView$lambda$2(DeviceDetailsDialogFragment deviceDetailsDialogFragment, View view) {
        deviceDetailsDialogFragment.dismiss();
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        Device device2 = arguments != null ? (Device) arguments.getParcelable("device") : null;
        if (device2 != null) {
            setDevice(device2);
            Bundle arguments2 = getArguments();
            this.actionType = arguments2 != null ? arguments2.getString("action_type") : null;
            jumpToAction = null;
            Timber.Forest forest = Timber.Forest;
            forest.d("onViewCreated: viewModel = " + getViewModel() + ",  device = " + getDevice() + ", actionType = " + this.actionType, new Object[0]);
            getViewModel().setAttachedToDeviceDetailsDialogFragment(true);
            getViewModel().setDeviceId(getDevice().getUid());
            bindViewModel();
            getChildFragmentManager().setFragmentResultListener("REQUEST_KEY_HANDLE_ACTION", this, new DeviceDetailsDialogFragment$$ExternalSyntheticLambda9(this));
            return;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$3(DeviceDetailsDialogFragment deviceDetailsDialogFragment, String str, Bundle bundle) {
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        Intrinsics.checkNotNullParameter(bundle, "<unused var>");
        deviceDetailsDialogFragment.handleActions(false);
    }

    private final void showSensorLayout(HasSensorData hasSensorData) {
        Pair pair;
        if (!DeviceKt.isAfterG4(hasSensorData) || (hasSensorData instanceof DeviceNewClassic)) {
            pair = new Pair(new DeviceDetailsDialogFragment$$ExternalSyntheticLambda2(hasSensorData), DeviceSensorsFragment.Companion.getTAG());
        } else {
            pair = new Pair(new DeviceDetailsDialogFragment$$ExternalSyntheticLambda0(hasSensorData), DeviceHSensorsFragment.Companion.getTAG());
        }
        Function0 function0 = (Function0) pair.component1();
        String str = (String) pair.component2();
        if (getChildFragmentManager().findFragmentByTag(str) == null) {
            DialogfragmentDeviceDetailsBinding dialogfragmentDeviceDetailsBinding = this.viewDataBinding;
            if (dialogfragmentDeviceDetailsBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
                dialogfragmentDeviceDetailsBinding = null;
            }
            dialogfragmentDeviceDetailsBinding.graphContainer.setVisibility(0);
            getChildFragmentManager().beginTransaction().replace(com.blueair.devicedetails.R.id.graph_container, (Fragment) function0.invoke(), str).commitAllowingStateLoss();
        }
    }

    /* access modifiers changed from: private */
    public static final DeviceHSensorsFragment showSensorLayout$lambda$4(HasSensorData hasSensorData) {
        return DeviceHSensorsFragment.Companion.newInstance(hasSensorData);
    }

    /* access modifiers changed from: private */
    public static final DeviceSensorsFragment showSensorLayout$lambda$5(HasSensorData hasSensorData) {
        return DeviceSensorsFragment.Companion.newInstance(hasSensorData);
    }

    private final void hideSensorLayout() {
        DialogfragmentDeviceDetailsBinding dialogfragmentDeviceDetailsBinding = this.viewDataBinding;
        if (dialogfragmentDeviceDetailsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            dialogfragmentDeviceDetailsBinding = null;
        }
        dialogfragmentDeviceDetailsBinding.graphContainer.setVisibility(8);
        Fragment findFragmentByTag = getChildFragmentManager().findFragmentByTag(DeviceSensorsFragment.Companion.getTAG());
        if (findFragmentByTag != null) {
            getChildFragmentManager().beginTransaction().remove(findFragmentByTag).commitAllowingStateLoss();
        }
    }

    private final void scrollToFilterStatus() {
        int i = DeviceKt.isAfterG4(getDevice()) ? com.blueair.devicedetails.R.id.holder_device_n_filter_status : com.blueair.devicedetails.R.id.holder_device_filter_status;
        DialogfragmentDeviceDetailsBinding dialogfragmentDeviceDetailsBinding = this.viewDataBinding;
        if (dialogfragmentDeviceDetailsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            dialogfragmentDeviceDetailsBinding = null;
        }
        NestedScrollView nestedScrollView = dialogfragmentDeviceDetailsBinding.scrollable;
        Intrinsics.checkNotNullExpressionValue(nestedScrollView, "scrollable");
        nestedScrollView.postDelayed(new DeviceDetailsDialogFragment$$ExternalSyntheticLambda3(nestedScrollView, i), 500);
    }

    /* access modifiers changed from: private */
    public static final void scrollToFilterStatus$lambda$8(NestedScrollView nestedScrollView, int i) {
        View findViewById = nestedScrollView.findViewById(i);
        if (findViewById != null) {
            nestedScrollView.smoothScrollTo(0, (((int) findViewById.getY()) - (findViewById.getHeight() / 2)) + (nestedScrollView.getHeight() / 2));
        }
    }

    private final void scrollToWickStatus() {
        DialogfragmentDeviceDetailsBinding dialogfragmentDeviceDetailsBinding = this.viewDataBinding;
        if (dialogfragmentDeviceDetailsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            dialogfragmentDeviceDetailsBinding = null;
        }
        NestedScrollView nestedScrollView = dialogfragmentDeviceDetailsBinding.scrollable;
        Intrinsics.checkNotNullExpressionValue(nestedScrollView, "scrollable");
        nestedScrollView.postDelayed(new DeviceDetailsDialogFragment$$ExternalSyntheticLambda1(nestedScrollView), 500);
    }

    /* access modifiers changed from: private */
    public static final void scrollToWickStatus$lambda$10(NestedScrollView nestedScrollView) {
        View findViewById = nestedScrollView.findViewById(com.blueair.devicedetails.R.id.holder_device_h_wick_status);
        if (findViewById != null) {
            nestedScrollView.smoothScrollTo(0, (((int) findViewById.getY()) - (findViewById.getHeight() / 2)) + (nestedScrollView.getHeight() / 2));
        }
    }

    public void onResume() {
        super.onResume();
        handleActions(true);
    }

    private final void handleActions(boolean z) {
        String str = this.actionType;
        if (str == null) {
            str = jumpToAction;
        }
        if (str != null) {
            switch (str.hashCode()) {
                case -2123968024:
                    if (str.equals(NotificationService.ACTION_TYPE_FILTER_PURCHASE) && DeviceKt.useNewFilterConfig(getDevice()) && DeviceConfigProvider.getFilterConfig$default(DeviceConfigProvider.INSTANCE, getDevice(), (DeviceFilterType) null, 2, (Object) null) == null) {
                        scrollToFilterStatus();
                        this.actionType = null;
                        jumpToAction = null;
                        break;
                    }
                case -1774126825:
                    if (str.equals(NotificationService.ACTION_TYPE_WICK_STATUS)) {
                        scrollToWickStatus();
                        break;
                    }
                    break;
                case -1274492040:
                    if (str.equals(NotificationService.ACTION_TYPE_FILTER) && (DeviceKt.isAfterG4(getDevice()) || StringsKt.contains$default((CharSequence) getDevice().getModelName(), (CharSequence) "511i", false, 2, (Object) null))) {
                        scrollToFilterStatus();
                        this.actionType = null;
                        break;
                    }
                case -757923495:
                    str.equals("device_details");
                    break;
                case -547902823:
                    if (str.equals(NotificationService.ACTION_TYPE_FILTER_STATUS)) {
                        scrollToFilterStatus();
                        break;
                    }
                    break;
                case 590772454:
                    if (str.equals(NotificationService.ACTION_TYPE_WICK_PURCHASE) && DeviceKt.useNewFilterConfig(getDevice()) && DeviceConfigProvider.getFilterConfig$default(DeviceConfigProvider.INSTANCE, getDevice(), (DeviceFilterType) null, 2, (Object) null) == null) {
                        scrollToWickStatus();
                        this.actionType = null;
                        jumpToAction = null;
                        break;
                    }
            }
        }
        if (z) {
            showDeviceAttributes();
        }
        this.actionType = null;
        jumpToAction = null;
    }

    private final void bindViewModel() {
        DialogfragmentDeviceDetailsBinding dialogfragmentDeviceDetailsBinding = null;
        if (!DeviceKt.isAfterG4(getDevice())) {
            DialogfragmentDeviceDetailsBinding dialogfragmentDeviceDetailsBinding2 = this.viewDataBinding;
            if (dialogfragmentDeviceDetailsBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
                dialogfragmentDeviceDetailsBinding2 = null;
            }
            dialogfragmentDeviceDetailsBinding2.scrollable.setBackground(new ColorDrawable(-1));
        }
        LiveData<DeviceDetailsState> deviceDetailsState = getViewModel().getDeviceDetailsState();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        LiveDataExtensionsKt.observeNonNull(deviceDetailsState, viewLifecycleOwner, new DeviceDetailsDialogFragment$$ExternalSyntheticLambda4(this));
        getViewModel().getLiveDevice().observe(getViewLifecycleOwner(), new DeviceDetailsDialogFragment$sam$androidx_lifecycle_Observer$0(new DeviceDetailsDialogFragment$$ExternalSyntheticLambda5(this)));
        if (getDevice() instanceof HasLocation) {
            DialogfragmentDeviceDetailsBinding dialogfragmentDeviceDetailsBinding3 = this.viewDataBinding;
            if (dialogfragmentDeviceDetailsBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
                dialogfragmentDeviceDetailsBinding3 = null;
            }
            TextView textView = dialogfragmentDeviceDetailsBinding3.location;
            Intrinsics.checkNotNullExpressionValue(textView, "location");
            ViewExtensionsKt.show(textView, true);
            DialogfragmentDeviceDetailsBinding dialogfragmentDeviceDetailsBinding4 = this.viewDataBinding;
            if (dialogfragmentDeviceDetailsBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            } else {
                dialogfragmentDeviceDetailsBinding = dialogfragmentDeviceDetailsBinding4;
            }
            dialogfragmentDeviceDetailsBinding.location.setOnClickListener(new DeviceDetailsDialogFragment$$ExternalSyntheticLambda6(this));
            getViewModel().getLiveLocation().observe(getViewLifecycleOwner(), new DeviceDetailsDialogFragment$sam$androidx_lifecycle_Observer$0(new DeviceDetailsDialogFragment$$ExternalSyntheticLambda7(this)));
        }
        LiveData<Boolean> networkAvailable = getViewModel().getNetworkAvailable();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        LiveDataExtensionsKt.observeNonNull(networkAvailable, viewLifecycleOwner2, new DeviceDetailsDialogFragment$$ExternalSyntheticLambda8(this));
        if (getDevice() instanceof HasScheduling) {
            showDeviceSchedules();
        }
        if ((getDevice() instanceof HasWelcomeHome) && getViewModel().isInWelcomeHomeRegion()) {
            showDeviceWelcomeHome();
        }
        showDeviceSettingsButton();
    }

    /* access modifiers changed from: private */
    public static final Unit bindViewModel$lambda$11(DeviceDetailsDialogFragment deviceDetailsDialogFragment, DeviceDetailsState deviceDetailsState) {
        Intrinsics.checkNotNullParameter(deviceDetailsState, "state");
        Timber.Forest forest = Timber.Forest;
        int i = 0;
        forest.d("device state: " + deviceDetailsState, new Object[0]);
        DialogfragmentDeviceDetailsBinding dialogfragmentDeviceDetailsBinding = deviceDetailsDialogFragment.viewDataBinding;
        if (dialogfragmentDeviceDetailsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            dialogfragmentDeviceDetailsBinding = null;
        }
        AppCompatImageView appCompatImageView = dialogfragmentDeviceDetailsBinding.deviceIcon;
        DeviceImage deviceImage = DeviceConfigProvider.INSTANCE.getDeviceImage(deviceDetailsState.getDevice());
        if (deviceImage != null) {
            i = deviceImage.getDevice();
        }
        appCompatImageView.setImageResource(i);
        deviceDetailsDialogFragment.setDevice(deviceDetailsState.getDevice());
        deviceDetailsDialogFragment.shouldShowStartWarningDialog(deviceDetailsState);
        if (deviceDetailsState.getDevice() instanceof HasSensorData) {
            deviceDetailsDialogFragment.showSensorLayout((HasSensorData) deviceDetailsState.getDevice());
        } else {
            deviceDetailsDialogFragment.hideSensorLayout();
        }
        deviceDetailsDialogFragment.showBanners(deviceDetailsState.getDevice());
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit bindViewModel$lambda$12(DeviceDetailsDialogFragment deviceDetailsDialogFragment, Device device2) {
        boolean z = false;
        Timber.Forest.v("liveDevice = " + device2, new Object[0]);
        if (device2 == null) {
            deviceDetailsDialogFragment.dismiss();
        } else {
            DialogfragmentDeviceDetailsBinding dialogfragmentDeviceDetailsBinding = deviceDetailsDialogFragment.viewDataBinding;
            DialogfragmentDeviceDetailsBinding dialogfragmentDeviceDetailsBinding2 = null;
            if (dialogfragmentDeviceDetailsBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
                dialogfragmentDeviceDetailsBinding = null;
            }
            dialogfragmentDeviceDetailsBinding.deviceName.setText(device2.getName());
            deviceDetailsDialogFragment.getViewModel().setDevice(device2);
            if (device2.getConnectivityStatus() == ConnectivityStatus.UPDATING) {
                z = true;
            }
            DialogfragmentDeviceDetailsBinding dialogfragmentDeviceDetailsBinding3 = deviceDetailsDialogFragment.viewDataBinding;
            if (dialogfragmentDeviceDetailsBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
                dialogfragmentDeviceDetailsBinding3 = null;
            }
            FrameLayout frameLayout = dialogfragmentDeviceDetailsBinding3.deviceSchedulesContainer;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "deviceSchedulesContainer");
            ViewExtensionsKt.show(frameLayout, !z);
            DialogfragmentDeviceDetailsBinding dialogfragmentDeviceDetailsBinding4 = deviceDetailsDialogFragment.viewDataBinding;
            if (dialogfragmentDeviceDetailsBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            } else {
                dialogfragmentDeviceDetailsBinding2 = dialogfragmentDeviceDetailsBinding4;
            }
            FrameLayout frameLayout2 = dialogfragmentDeviceDetailsBinding2.welcomeHomeContainer;
            Intrinsics.checkNotNullExpressionValue(frameLayout2, "welcomeHomeContainer");
            ViewExtensionsKt.show(frameLayout2, !z);
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final void bindViewModel$lambda$13(DeviceDetailsDialogFragment deviceDetailsDialogFragment, View view) {
        TrackedLocation value = deviceDetailsDialogFragment.getViewModel().getLiveLocation().getValue();
        String id = value != null ? value.getId() : null;
        Actions actions = Actions.INSTANCE;
        Context requireContext = deviceDetailsDialogFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        LocationService.MapType mapType = deviceDetailsDialogFragment.getViewModel().getMapType();
        CharSequence charSequence = id;
        boolean z = charSequence == null || charSequence.length() == 0;
        if (id == null) {
            id = "";
        }
        deviceDetailsDialogFragment.startActivity(Actions.openMapIntent$default(actions, requireContext, mapType, id, z, false, deviceDetailsDialogFragment.getDevice().getUid(), 16, (Object) null));
    }

    /* access modifiers changed from: private */
    public static final Unit bindViewModel$lambda$14(DeviceDetailsDialogFragment deviceDetailsDialogFragment, TrackedLocation trackedLocation) {
        CharSequence charSequence;
        String locationName;
        DialogfragmentDeviceDetailsBinding dialogfragmentDeviceDetailsBinding = deviceDetailsDialogFragment.viewDataBinding;
        if (dialogfragmentDeviceDetailsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            dialogfragmentDeviceDetailsBinding = null;
        }
        TextView textView = dialogfragmentDeviceDetailsBinding.location;
        if (trackedLocation == null || (locationName = trackedLocation.getLocationName()) == null) {
            String string = deviceDetailsDialogFragment.getString(R.string.assign_location);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            charSequence = string;
        } else {
            charSequence = locationName;
        }
        textView.setText(charSequence);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit bindViewModel$lambda$15(DeviceDetailsDialogFragment deviceDetailsDialogFragment, boolean z) {
        Device device2 = deviceDetailsDialogFragment.getViewModel().getDevice();
        if (device2 == null) {
            device2 = deviceDetailsDialogFragment.getDevice();
        }
        deviceDetailsDialogFragment.showBanners(device2);
        return Unit.INSTANCE;
    }

    private final void showDeviceAttributes() {
        FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "beginTransaction(...)");
        Timber.Forest forest = Timber.Forest;
        forest.d("showDeviceAttributes device: " + getViewModel().getDevice(), new Object[0]);
        DeviceAttributesFragment newInstance = DeviceAttributesFragment.Companion.newInstance(getDevice(), this.actionType);
        DialogfragmentDeviceDetailsBinding dialogfragmentDeviceDetailsBinding = this.viewDataBinding;
        if (dialogfragmentDeviceDetailsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            dialogfragmentDeviceDetailsBinding = null;
        }
        beginTransaction.replace(dialogfragmentDeviceDetailsBinding.devicesAttributesContainer.getId(), newInstance);
        beginTransaction.commitAllowingStateLoss();
    }

    private final void showDeviceSchedules() {
        BaseFragment baseFragment;
        FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "beginTransaction(...)");
        Timber.Forest forest = Timber.Forest;
        forest.d("showDeviceSchedules device: " + getViewModel().getDevice(), new Object[0]);
        if (DeviceKt.isAfterG4(getDevice())) {
            baseFragment = DeviceNSchedulesFragment.Companion.newInstance(getDevice());
        } else {
            baseFragment = DeviceSchedulesFragment.Companion.newInstance(getDevice());
        }
        DialogfragmentDeviceDetailsBinding dialogfragmentDeviceDetailsBinding = this.viewDataBinding;
        if (dialogfragmentDeviceDetailsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            dialogfragmentDeviceDetailsBinding = null;
        }
        beginTransaction.replace(dialogfragmentDeviceDetailsBinding.deviceSchedulesContainer.getId(), baseFragment);
        beginTransaction.commitAllowingStateLoss();
    }

    private final void showDeviceWelcomeHome() {
        BaseFragment baseFragment;
        FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "beginTransaction(...)");
        if (getDevice() instanceof DeviceNewClassic) {
            baseFragment = DeviceNWelcomeHomeFragment.Companion.newInstance(getDevice());
        } else {
            baseFragment = DeviceWelcomeHomeFragment.Companion.newInstance(getDevice());
        }
        DialogfragmentDeviceDetailsBinding dialogfragmentDeviceDetailsBinding = this.viewDataBinding;
        if (dialogfragmentDeviceDetailsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            dialogfragmentDeviceDetailsBinding = null;
        }
        beginTransaction.replace(dialogfragmentDeviceDetailsBinding.welcomeHomeContainer.getId(), baseFragment);
        beginTransaction.commitAllowingStateLoss();
    }

    private final void showDeviceSettingsButton() {
        FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "beginTransaction(...)");
        Timber.Forest forest = Timber.Forest;
        forest.d("showDeviceSettings device: " + getViewModel().getDevice(), new Object[0]);
        DeviceSettingsFragment newInstance = DeviceSettingsFragment.Companion.newInstance(getDevice());
        DialogfragmentDeviceDetailsBinding dialogfragmentDeviceDetailsBinding = this.viewDataBinding;
        if (dialogfragmentDeviceDetailsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            dialogfragmentDeviceDetailsBinding = null;
        }
        beginTransaction.replace(dialogfragmentDeviceDetailsBinding.deviceSettingsContainer.getId(), newInstance);
        beginTransaction.commitAllowingStateLoss();
    }

    private final void shouldShowStartWarningDialog(DeviceDetailsState deviceDetailsState) {
        Context context = getContext();
        if (context == null || NetUtil.INSTANCE.isProbablyOnline(context)) {
            ConfirmationDialogCentered.Companion companion = ConfirmationDialogCentered.Companion;
            FragmentManager childFragmentManager = getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
            companion.dismissOfflineDialog(childFragmentManager);
            shouldShowFilterDoorOpenDialog(deviceDetailsState);
        }
    }

    private final void shouldShowFilterDoorOpenDialog(DeviceDetailsState deviceDetailsState) {
        if (!(deviceDetailsState.getDevice() instanceof HasSafetySwitch)) {
            return;
        }
        if (ViewUtils.INSTANCE.shouldShowFilterDoorPopup((HasSafetySwitch) deviceDetailsState.getDevice())) {
            ConfirmationDialogCentered.Companion companion = ConfirmationDialogCentered.Companion;
            FragmentManager childFragmentManager = getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
            companion.showFilterDoorOpenDialog(childFragmentManager);
        } else if (((HasSafetySwitch) deviceDetailsState.getDevice()).isSafetySwitchOn()) {
            ConfirmationDialogCentered.Companion companion2 = ConfirmationDialogCentered.Companion;
            FragmentManager childFragmentManager2 = getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager2, "getChildFragmentManager(...)");
            companion2.dismissFilterDoorOpenDialog(childFragmentManager2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001d, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) getViewModel().getDeviceOffline().getValue(), (java.lang.Object) true) == false) goto L_0x0021;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void showBanners(com.blueair.core.model.Device r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.blueair.core.model.HasWick
            if (r0 != 0) goto L_0x0008
            boolean r0 = r6 instanceof com.blueair.core.model.DevicePet20
            if (r0 == 0) goto L_0x0020
        L_0x0008:
            com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel r0 = r5.getViewModel()
            androidx.lifecycle.LiveData r0 = r0.getDeviceOffline()
            java.lang.Object r0 = r0.getValue()
            r1 = 1
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r1)
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r2)
            if (r0 != 0) goto L_0x0020
            goto L_0x0021
        L_0x0020:
            r1 = 0
        L_0x0021:
            com.blueair.devicedetails.databinding.DialogfragmentDeviceDetailsBinding r0 = r5.viewDataBinding
            r2 = 0
            java.lang.String r3 = "viewDataBinding"
            if (r0 != 0) goto L_0x002c
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            r0 = r2
        L_0x002c:
            android.widget.FrameLayout r0 = r0.bannersContainer
            java.lang.String r4 = "bannersContainer"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r4)
            android.view.View r0 = (android.view.View) r0
            io.flatcircle.viewhelper.ViewExtensionsKt.show(r0, r1)
            if (r1 == 0) goto L_0x0070
            androidx.fragment.app.FragmentManager r0 = r5.getChildFragmentManager()
            java.lang.String r1 = "DeviceBannersFragment"
            androidx.fragment.app.Fragment r0 = r0.findFragmentByTag(r1)
            if (r0 != 0) goto L_0x0070
            androidx.fragment.app.FragmentManager r0 = r5.getChildFragmentManager()
            androidx.fragment.app.FragmentTransaction r0 = r0.beginTransaction()
            java.lang.String r4 = "beginTransaction(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r4)
            com.blueair.devicedetails.fragment.DeviceBannersFragment$Companion r4 = com.blueair.devicedetails.fragment.DeviceBannersFragment.Companion
            com.blueair.devicedetails.fragment.DeviceBannersFragment r6 = r4.newInstance(r6)
            com.blueair.devicedetails.databinding.DialogfragmentDeviceDetailsBinding r4 = r5.viewDataBinding
            if (r4 != 0) goto L_0x0061
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            goto L_0x0062
        L_0x0061:
            r2 = r4
        L_0x0062:
            android.widget.FrameLayout r2 = r2.bannersContainer
            int r2 = r2.getId()
            androidx.fragment.app.Fragment r6 = (androidx.fragment.app.Fragment) r6
            r0.replace((int) r2, (androidx.fragment.app.Fragment) r6, (java.lang.String) r1)
            r0.commitAllowingStateLoss()
        L_0x0070:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.dialog.DeviceDetailsDialogFragment.showBanners(com.blueair.core.model.Device):void");
    }

    public void dismiss() {
        Fragment targetFragment = getTargetFragment();
        if (targetFragment != null) {
            targetFragment.onActivityResult(getTargetRequestCode(), -1, (Intent) null);
        }
        super.dismiss();
    }

    public void onCancel(DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(dialogInterface, "dialog");
        Fragment targetFragment = getTargetFragment();
        if (targetFragment != null) {
            targetFragment.onActivityResult(getTargetRequestCode(), -1, (Intent) null);
        }
        super.onCancel(dialogInterface);
    }
}
