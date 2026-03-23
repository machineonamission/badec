package com.blueair.devicedetails.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.os.BundleKt;
import androidx.core.util.TypedValueCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentKt;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceData;
import com.blueair.core.model.DeviceImage;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.HasSensorData;
import com.blueair.core.model.SensorType;
import com.blueair.devicedetails.adapter.DeviceSensorCardsAdapter;
import com.blueair.devicedetails.databinding.DialogfragmentDeviceDetailsV2Binding;
import com.blueair.devicedetails.fragment.DeviceControlsFragment;
import com.blueair.devicedetails.fragment.DeviceMessagesFragment;
import com.blueair.devicedetails.fragment.DeviceSensorsGraphFragment;
import com.blueair.devicedetails.util.DeviceDetailsLauncher;
import com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel;
import com.blueair.devicedetails.viewmodel.DeviceSensorsViewModel;
import com.blueair.viewcore.R;
import com.blueair.viewcore.dialog.BaseDialogFragment;
import com.blueair.viewcore.dialog.DialogUtils;
import com.blueair.viewcore.utils.DeviceConfigProvider;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import com.blueair.viewcore.viewmodel.CustomViewModelStoreOwner;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import timber.log.Timber;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 62\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00016B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010\u0019\u001a\u00020\u0017H\u0016J$\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u001a\u0010\"\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\u001b2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010$\u001a\u00020\u0017H\u0002J\b\u0010%\u001a\u00020\u0017H\u0002J\b\u0010&\u001a\u00020\u0017H\u0002J\b\u0010'\u001a\u00020\u0017H\u0002J\b\u0010(\u001a\u00020\u0017H\u0002J\u0010\u0010)\u001a\u00020\u00172\u0006\u0010*\u001a\u00020\u0006H\u0002J\b\u0010+\u001a\u00020\u0017H\u0002J\b\u0010,\u001a\u00020\u0017H\u0002J\b\u0010-\u001a\u00020\u0017H\u0002J\b\u0010.\u001a\u00020\u0017H\u0002J\u0010\u0010/\u001a\u00020\u00172\u0006\u00100\u001a\u000201H\u0016J\b\u00102\u001a\u00020\u0017H\u0016J\u0010\u00103\u001a\u00020\u00172\u0006\u00104\u001a\u000205H\u0016R\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\u0002X.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lcom/blueair/devicedetails/dialog/DeviceDetailsV2DialogFragment;", "Lcom/blueair/viewcore/dialog/BaseDialogFragment;", "Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "binding", "Lcom/blueair/devicedetails/databinding/DialogfragmentDeviceDetailsV2Binding;", "viewModel", "getViewModel", "()Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;", "setViewModel", "(Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;)V", "sensorsViewModel", "Lcom/blueair/devicedetails/viewmodel/DeviceSensorsViewModel;", "statusBarHeight", "", "sensorCardsAdapter", "Lcom/blueair/devicedetails/adapter/DeviceSensorCardsAdapter;", "onStart", "", "onResume", "onPause", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "blurTitleBar", "bindViewModel", "showDeviceMessages", "showDeviceSensorsGraph", "showDeviceControls", "scrollToView", "tag", "scrollToFilterStatus", "scrollToWickStatus", "scrollToRefresherStatus", "handleActions", "showProgress", "shouldShowProgress", "", "dismiss", "onCancel", "dialog", "Landroid/content/DialogInterface;", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceDetailsV2DialogFragment.kt */
public final class DeviceDetailsV2DialogFragment extends BaseDialogFragment<DeviceDetailsViewModel> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String REQUEST_KEY_DEVICE_DETAILS_CLOSED = "REQUEST_KEY_DEVICE_DETAILS_CLOSED";
    public static final String REQUEST_KEY_HANDLE_ACTION = "REQUEST_KEY_HANDLE_ACTION";
    /* access modifiers changed from: private */
    public static String jumpToAction;
    private DialogfragmentDeviceDetailsV2Binding binding;
    private final String screenName = "device_details";
    private final DeviceSensorCardsAdapter sensorCardsAdapter = new DeviceSensorCardsAdapter();
    private DeviceSensorsViewModel sensorsViewModel;
    private int statusBarHeight = 70;
    public DeviceDetailsViewModel viewModel;

    /* access modifiers changed from: private */
    public static final void bindViewModel$lambda$15(Object obj) {
    }

    /* access modifiers changed from: private */
    public static final void bindViewModel$lambda$16(Object obj) {
    }

    public void showProgress(boolean z) {
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcom/blueair/devicedetails/dialog/DeviceDetailsV2DialogFragment$Companion;", "", "<init>", "()V", "REQUEST_KEY_HANDLE_ACTION", "", "REQUEST_KEY_DEVICE_DETAILS_CLOSED", "jumpToAction", "getJumpToAction", "()Ljava/lang/String;", "setJumpToAction", "(Ljava/lang/String;)V", "newInstance", "Lcom/blueair/devicedetails/dialog/DeviceDetailsV2DialogFragment;", "device", "Lcom/blueair/core/model/Device;", "actionType", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceDetailsV2DialogFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getJumpToAction() {
            return DeviceDetailsV2DialogFragment.jumpToAction;
        }

        public final void setJumpToAction(String str) {
            DeviceDetailsV2DialogFragment.jumpToAction = str;
        }

        public static /* synthetic */ DeviceDetailsV2DialogFragment newInstance$default(Companion companion, Device device, String str, int i, Object obj) {
            if ((i & 2) != 0) {
                str = null;
            }
            return companion.newInstance(device, str);
        }

        public final DeviceDetailsV2DialogFragment newInstance(Device device, String str) {
            Intrinsics.checkNotNullParameter(device, "device");
            DeviceDetailsV2DialogFragment deviceDetailsV2DialogFragment = new DeviceDetailsV2DialogFragment();
            deviceDetailsV2DialogFragment.setArguments(BundleKt.bundleOf(TuplesKt.to("device", device), TuplesKt.to("action_type", str)));
            return deviceDetailsV2DialogFragment;
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

    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (!(dialog == null || (window = dialog.getWindow()) == null)) {
            window.setLayout(-1, -1);
        }
        DialogUtils.INSTANCE.immersiveStatusBar(getDialog(), true, true);
    }

    public void onResume() {
        super.onResume();
        handleActions();
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
        DialogfragmentDeviceDetailsV2Binding inflate = DialogfragmentDeviceDetailsV2Binding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        BaseDialogFragment baseDialogFragment = this;
        setViewModel((DeviceDetailsViewModel) ((BaseViewModel) new ViewModelProvider((ViewModelStoreOwner) CustomViewModelStoreOwner.Companion.getDEVICE_DETAILS()).get(DeviceDetailsViewModel.class)));
        this.sensorsViewModel = (DeviceSensorsViewModel) ((BaseViewModel) new ViewModelProvider((ViewModelStoreOwner) CustomViewModelStoreOwner.Companion.getDEVICE_DETAILS()).get(DeviceSensorsViewModel.class));
        DialogfragmentDeviceDetailsV2Binding dialogfragmentDeviceDetailsV2Binding = this.binding;
        if (dialogfragmentDeviceDetailsV2Binding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogfragmentDeviceDetailsV2Binding = null;
        }
        ConstraintLayout root = dialogfragmentDeviceDetailsV2Binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        DeviceSensorsViewModel deviceSensorsViewModel = null;
        Device device = arguments != null ? (Device) arguments.getParcelable("device") : null;
        if (device != null) {
            DeviceDetailsViewModel viewModel2 = getViewModel();
            Bundle arguments2 = getArguments();
            viewModel2.setActionType(arguments2 != null ? arguments2.getString("action_type") : null);
            jumpToAction = null;
            Timber.Forest forest = Timber.Forest;
            forest.d("onViewCreated: viewModel = " + getViewModel() + ",  device = " + device + ", actionType = " + getViewModel().getActionType(), new Object[0]);
            getViewModel().setAttachedToDeviceDetailsDialogFragment(true);
            getViewModel().setDeviceId(device.getUid());
            getViewModel().setDevice(device);
            if ((device instanceof HasSensorData ? (HasSensorData) device : null) != null) {
                DeviceSensorsViewModel deviceSensorsViewModel2 = this.sensorsViewModel;
                if (deviceSensorsViewModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("sensorsViewModel");
                } else {
                    deviceSensorsViewModel = deviceSensorsViewModel2;
                }
                deviceSensorsViewModel.init((HasSensorData) device, true);
            }
            bindViewModel();
            getChildFragmentManager().setFragmentResultListener("REQUEST_KEY_HANDLE_ACTION", this, new DeviceDetailsV2DialogFragment$$ExternalSyntheticLambda3(this));
            blurTitleBar();
            return;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$2(DeviceDetailsV2DialogFragment deviceDetailsV2DialogFragment, String str, Bundle bundle) {
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        Intrinsics.checkNotNullParameter(bundle, "<unused var>");
        deviceDetailsV2DialogFragment.handleActions();
    }

    private final void blurTitleBar() {
        DialogfragmentDeviceDetailsV2Binding dialogfragmentDeviceDetailsV2Binding = this.binding;
        DialogfragmentDeviceDetailsV2Binding dialogfragmentDeviceDetailsV2Binding2 = null;
        if (dialogfragmentDeviceDetailsV2Binding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogfragmentDeviceDetailsV2Binding = null;
        }
        ConstraintLayout constraintLayout = dialogfragmentDeviceDetailsV2Binding.rootLayout;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "rootLayout");
        DialogUtils dialogUtils = DialogUtils.INSTANCE;
        Context context = constraintLayout.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        this.statusBarHeight = dialogUtils.getStatusBarHeight(context);
        DialogfragmentDeviceDetailsV2Binding dialogfragmentDeviceDetailsV2Binding3 = this.binding;
        if (dialogfragmentDeviceDetailsV2Binding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogfragmentDeviceDetailsV2Binding3 = null;
        }
        dialogfragmentDeviceDetailsV2Binding3.bvTitle.setupWith(constraintLayout).setBlurRadius(25.0f).setBlurEnabled(false);
        DialogfragmentDeviceDetailsV2Binding dialogfragmentDeviceDetailsV2Binding4 = this.binding;
        if (dialogfragmentDeviceDetailsV2Binding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            dialogfragmentDeviceDetailsV2Binding2 = dialogfragmentDeviceDetailsV2Binding4;
        }
        dialogfragmentDeviceDetailsV2Binding2.scrollable.setOnScrollChangeListener(new DeviceDetailsV2DialogFragment$$ExternalSyntheticLambda5(this));
    }

    /* access modifiers changed from: private */
    public static final void blurTitleBar$lambda$3(DeviceDetailsV2DialogFragment deviceDetailsV2DialogFragment, View view, int i, int i2, int i3, int i4) {
        boolean z = true;
        int i5 = 0;
        boolean z2 = i2 > deviceDetailsV2DialogFragment.statusBarHeight;
        DialogfragmentDeviceDetailsV2Binding dialogfragmentDeviceDetailsV2Binding = deviceDetailsV2DialogFragment.binding;
        DialogfragmentDeviceDetailsV2Binding dialogfragmentDeviceDetailsV2Binding2 = null;
        if (dialogfragmentDeviceDetailsV2Binding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogfragmentDeviceDetailsV2Binding = null;
        }
        View view2 = dialogfragmentDeviceDetailsV2Binding.vBottomDivider;
        Intrinsics.checkNotNullExpressionValue(view2, "vBottomDivider");
        if (view2.getVisibility() != 0) {
            z = false;
        }
        if (z != z2) {
            DialogfragmentDeviceDetailsV2Binding dialogfragmentDeviceDetailsV2Binding3 = deviceDetailsV2DialogFragment.binding;
            if (dialogfragmentDeviceDetailsV2Binding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dialogfragmentDeviceDetailsV2Binding3 = null;
            }
            View view3 = dialogfragmentDeviceDetailsV2Binding3.vBottomDivider;
            Intrinsics.checkNotNullExpressionValue(view3, "vBottomDivider");
            if (!z2) {
                i5 = 8;
            }
            view3.setVisibility(i5);
            DialogfragmentDeviceDetailsV2Binding dialogfragmentDeviceDetailsV2Binding4 = deviceDetailsV2DialogFragment.binding;
            if (dialogfragmentDeviceDetailsV2Binding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                dialogfragmentDeviceDetailsV2Binding2 = dialogfragmentDeviceDetailsV2Binding4;
            }
            dialogfragmentDeviceDetailsV2Binding2.bvTitle.setBlurEnabled(z2);
        }
    }

    private final void bindViewModel() {
        DialogfragmentDeviceDetailsV2Binding dialogfragmentDeviceDetailsV2Binding = this.binding;
        DeviceSensorsViewModel deviceSensorsViewModel = null;
        if (dialogfragmentDeviceDetailsV2Binding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogfragmentDeviceDetailsV2Binding = null;
        }
        dialogfragmentDeviceDetailsV2Binding.btnBack.setOnClickListener(new DeviceDetailsV2DialogFragment$$ExternalSyntheticLambda7(this));
        DialogfragmentDeviceDetailsV2Binding dialogfragmentDeviceDetailsV2Binding2 = this.binding;
        if (dialogfragmentDeviceDetailsV2Binding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogfragmentDeviceDetailsV2Binding2 = null;
        }
        dialogfragmentDeviceDetailsV2Binding2.btnStandby.setOnCheckedChangeListener(new DeviceDetailsV2DialogFragment$$ExternalSyntheticLambda9(this));
        DialogfragmentDeviceDetailsV2Binding dialogfragmentDeviceDetailsV2Binding3 = this.binding;
        if (dialogfragmentDeviceDetailsV2Binding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogfragmentDeviceDetailsV2Binding3 = null;
        }
        dialogfragmentDeviceDetailsV2Binding3.deviceName.setOnClickListener(new DeviceDetailsV2DialogFragment$$ExternalSyntheticLambda10(this));
        Device device = getViewModel().getDevice();
        if (device != null) {
            DialogfragmentDeviceDetailsV2Binding dialogfragmentDeviceDetailsV2Binding4 = this.binding;
            if (dialogfragmentDeviceDetailsV2Binding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dialogfragmentDeviceDetailsV2Binding4 = null;
            }
            ImageView imageView = dialogfragmentDeviceDetailsV2Binding4.deviceImage;
            DeviceImage deviceImage = DeviceConfigProvider.INSTANCE.getDeviceImage(device);
            imageView.setImageResource(deviceImage != null ? deviceImage.getBgDetails() : 0);
        }
        showDeviceMessages();
        if (getViewModel().getDevice() instanceof HasSensorData) {
            DialogfragmentDeviceDetailsV2Binding dialogfragmentDeviceDetailsV2Binding5 = this.binding;
            if (dialogfragmentDeviceDetailsV2Binding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dialogfragmentDeviceDetailsV2Binding5 = null;
            }
            dialogfragmentDeviceDetailsV2Binding5.sensorCardList.setLayoutManager(new LinearLayoutManager(requireContext(), 0, false));
            DialogfragmentDeviceDetailsV2Binding dialogfragmentDeviceDetailsV2Binding6 = this.binding;
            if (dialogfragmentDeviceDetailsV2Binding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dialogfragmentDeviceDetailsV2Binding6 = null;
            }
            RecyclerView.ItemAnimator itemAnimator = dialogfragmentDeviceDetailsV2Binding6.sensorCardList.getItemAnimator();
            SimpleItemAnimator simpleItemAnimator = itemAnimator instanceof SimpleItemAnimator ? (SimpleItemAnimator) itemAnimator : null;
            if (simpleItemAnimator != null) {
                simpleItemAnimator.setSupportsChangeAnimations(false);
            }
            DeviceSensorCardsAdapter deviceSensorCardsAdapter = this.sensorCardsAdapter;
            Device device2 = getViewModel().getDevice();
            Intrinsics.checkNotNull(device2, "null cannot be cast to non-null type com.blueair.core.model.HasSensorData");
            deviceSensorCardsAdapter.setDevice((HasSensorData) device2);
            DeviceSensorCardsAdapter deviceSensorCardsAdapter2 = this.sensorCardsAdapter;
            DeviceSensorsViewModel deviceSensorsViewModel2 = this.sensorsViewModel;
            if (deviceSensorsViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sensorsViewModel");
                deviceSensorsViewModel2 = null;
            }
            deviceSensorCardsAdapter2.setCelsius(deviceSensorsViewModel2.isTempCelsius());
            this.sensorCardsAdapter.setNormalTintColor(ContextCompat.getColor(requireContext(), R.color.powder_blue));
            DeviceSensorCardsAdapter deviceSensorCardsAdapter3 = this.sensorCardsAdapter;
            DeviceSensorsViewModel deviceSensorsViewModel3 = this.sensorsViewModel;
            if (deviceSensorsViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sensorsViewModel");
                deviceSensorsViewModel3 = null;
            }
            deviceSensorCardsAdapter3.setSensors(deviceSensorsViewModel3.getSupportedSensors());
            Timber.Forest.d("sensors: " + this.sensorCardsAdapter.getSensors(), new Object[0]);
            this.sensorCardsAdapter.getLiveSelectedIndex().observe(getViewLifecycleOwner(), new DeviceDetailsV2DialogFragment$sam$androidx_lifecycle_Observer$0(new DeviceDetailsV2DialogFragment$$ExternalSyntheticLambda11(this)));
            DeviceSensorsViewModel deviceSensorsViewModel4 = this.sensorsViewModel;
            if (deviceSensorsViewModel4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sensorsViewModel");
                deviceSensorsViewModel4 = null;
            }
            deviceSensorsViewModel4.getGraphExpended().observe(getViewLifecycleOwner(), new DeviceDetailsV2DialogFragment$sam$androidx_lifecycle_Observer$0(new DeviceDetailsV2DialogFragment$$ExternalSyntheticLambda12(this)));
            DialogfragmentDeviceDetailsV2Binding dialogfragmentDeviceDetailsV2Binding7 = this.binding;
            if (dialogfragmentDeviceDetailsV2Binding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dialogfragmentDeviceDetailsV2Binding7 = null;
            }
            dialogfragmentDeviceDetailsV2Binding7.sensorCardList.setAdapter(this.sensorCardsAdapter);
            DeviceSensorsViewModel deviceSensorsViewModel5 = this.sensorsViewModel;
            if (deviceSensorsViewModel5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sensorsViewModel");
                deviceSensorsViewModel5 = null;
            }
            deviceSensorsViewModel5.getLiveSelectedSensor().observe(getViewLifecycleOwner(), new DeviceDetailsV2DialogFragment$sam$androidx_lifecycle_Observer$0(new DeviceDetailsV2DialogFragment$$ExternalSyntheticLambda13(this)));
            DeviceSensorsViewModel deviceSensorsViewModel6 = this.sensorsViewModel;
            if (deviceSensorsViewModel6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sensorsViewModel");
                deviceSensorsViewModel6 = null;
            }
            deviceSensorsViewModel6.getRealTimeDataListener().observe(getViewLifecycleOwner(), new DeviceDetailsV2DialogFragment$$ExternalSyntheticLambda14());
            DeviceSensorsViewModel deviceSensorsViewModel7 = this.sensorsViewModel;
            if (deviceSensorsViewModel7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sensorsViewModel");
                deviceSensorsViewModel7 = null;
            }
            deviceSensorsViewModel7.getHistoricalDataListener().observe(getViewLifecycleOwner(), new DeviceDetailsV2DialogFragment$$ExternalSyntheticLambda15());
            DeviceSensorsViewModel deviceSensorsViewModel8 = this.sensorsViewModel;
            if (deviceSensorsViewModel8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sensorsViewModel");
                deviceSensorsViewModel8 = null;
            }
            deviceSensorsViewModel8.getLiveDeviceRealTimeData().observe(getViewLifecycleOwner(), new DeviceDetailsV2DialogFragment$sam$androidx_lifecycle_Observer$0(new DeviceDetailsV2DialogFragment$$ExternalSyntheticLambda1(this)));
            DeviceSensorsViewModel deviceSensorsViewModel9 = this.sensorsViewModel;
            if (deviceSensorsViewModel9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sensorsViewModel");
                deviceSensorsViewModel9 = null;
            }
            DeviceSensorsViewModel deviceSensorsViewModel10 = this.sensorsViewModel;
            if (deviceSensorsViewModel10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sensorsViewModel");
                deviceSensorsViewModel10 = null;
            }
            SensorType lastSelectedSensor = deviceSensorsViewModel10.getLastSelectedSensor();
            if (lastSelectedSensor == null) {
                DeviceSensorsViewModel deviceSensorsViewModel11 = this.sensorsViewModel;
                if (deviceSensorsViewModel11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("sensorsViewModel");
                    deviceSensorsViewModel11 = null;
                }
                lastSelectedSensor = deviceSensorsViewModel11.getDefaultSelectedSensor();
            }
            DeviceSensorsViewModel deviceSensorsViewModel12 = this.sensorsViewModel;
            if (deviceSensorsViewModel12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sensorsViewModel");
            } else {
                deviceSensorsViewModel = deviceSensorsViewModel12;
            }
            deviceSensorsViewModel9.selectSensor(lastSelectedSensor, deviceSensorsViewModel.getLastGraphExpended());
            showDeviceSensorsGraph();
        }
        showDeviceControls();
        getViewModel().getLiveDevice().observe(getViewLifecycleOwner(), new DeviceDetailsV2DialogFragment$sam$androidx_lifecycle_Observer$0(new DeviceDetailsV2DialogFragment$$ExternalSyntheticLambda2(this)));
        getViewModel().getDeviceOffline().observe(getViewLifecycleOwner(), new DeviceDetailsV2DialogFragment$sam$androidx_lifecycle_Observer$0(new DeviceDetailsV2DialogFragment$$ExternalSyntheticLambda8(this)));
    }

    /* access modifiers changed from: private */
    public static final void bindViewModel$lambda$4(DeviceDetailsV2DialogFragment deviceDetailsV2DialogFragment, View view) {
        deviceDetailsV2DialogFragment.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void bindViewModel$lambda$5(DeviceDetailsV2DialogFragment deviceDetailsV2DialogFragment, CompoundButton compoundButton, boolean z) {
        DeviceDetailsViewModel viewModel2 = deviceDetailsV2DialogFragment.getViewModel();
        Device device = deviceDetailsV2DialogFragment.getViewModel().getDevice();
        Intrinsics.checkNotNull(device);
        viewModel2.standByChanged(device);
    }

    /* access modifiers changed from: private */
    public static final void bindViewModel$lambda$10(DeviceDetailsV2DialogFragment deviceDetailsV2DialogFragment, View view) {
        deviceDetailsV2DialogFragment.getViewModel().getDevices(new DeviceDetailsV2DialogFragment$$ExternalSyntheticLambda4(deviceDetailsV2DialogFragment));
    }

    /* access modifiers changed from: private */
    public static final Unit bindViewModel$lambda$10$lambda$9(DeviceDetailsV2DialogFragment deviceDetailsV2DialogFragment, List list) {
        Intrinsics.checkNotNullParameter(list, "devices");
        Device device = deviceDetailsV2DialogFragment.getViewModel().getDevice();
        Intrinsics.checkNotNull(device);
        Collection arrayList = new ArrayList();
        for (Object next : list) {
            if (!Intrinsics.areEqual((Object) ((Device) next).getUid(), (Object) device.getUid())) {
                arrayList.add(next);
            }
        }
        List list2 = (List) arrayList;
        Collection listOf = CollectionsKt.listOf(device.getName());
        Iterable<Device> iterable = list2;
        Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (Device name : iterable) {
            arrayList2.add(name.getName());
        }
        List plus = CollectionsKt.plus(listOf, (List) arrayList2);
        float dpToPx = TypedValueCompat.dpToPx(1.0f, deviceDetailsV2DialogFragment.getResources().getDisplayMetrics());
        DialogfragmentDeviceDetailsV2Binding dialogfragmentDeviceDetailsV2Binding = deviceDetailsV2DialogFragment.binding;
        DialogfragmentDeviceDetailsV2Binding dialogfragmentDeviceDetailsV2Binding2 = null;
        if (dialogfragmentDeviceDetailsV2Binding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogfragmentDeviceDetailsV2Binding = null;
        }
        int width = dialogfragmentDeviceDetailsV2Binding.deviceNameMaxWidth.getWidth();
        DialogfragmentDeviceDetailsV2Binding dialogfragmentDeviceDetailsV2Binding3 = deviceDetailsV2DialogFragment.binding;
        if (dialogfragmentDeviceDetailsV2Binding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogfragmentDeviceDetailsV2Binding3 = null;
        }
        int width2 = (dialogfragmentDeviceDetailsV2Binding3.deviceName.getWidth() - width) / 2;
        String str = "binding";
        DialogUtils dialogUtils = DialogUtils.INSTANCE;
        DialogfragmentDeviceDetailsV2Binding dialogfragmentDeviceDetailsV2Binding4 = deviceDetailsV2DialogFragment.binding;
        if (dialogfragmentDeviceDetailsV2Binding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
            dialogfragmentDeviceDetailsV2Binding4 = null;
        }
        TextView textView = dialogfragmentDeviceDetailsV2Binding4.deviceName;
        Intrinsics.checkNotNullExpressionValue(textView, "deviceName");
        DialogfragmentDeviceDetailsV2Binding dialogfragmentDeviceDetailsV2Binding5 = deviceDetailsV2DialogFragment.binding;
        if (dialogfragmentDeviceDetailsV2Binding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        } else {
            dialogfragmentDeviceDetailsV2Binding2 = dialogfragmentDeviceDetailsV2Binding5;
        }
        dialogUtils.showDropDownList(textView, plus, width, width2, (-dialogfragmentDeviceDetailsV2Binding2.deviceName.getHeight()) - MathKt.roundToInt(((float) 10) * dpToPx), 10, true, new DeviceDetailsV2DialogFragment$$ExternalSyntheticLambda6(deviceDetailsV2DialogFragment, list2));
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit bindViewModel$lambda$10$lambda$9$lambda$8(DeviceDetailsV2DialogFragment deviceDetailsV2DialogFragment, List list, int i, String str) {
        Intrinsics.checkNotNullParameter(str, "s");
        if (i > 0) {
            Fragment parentFragment = deviceDetailsV2DialogFragment.getParentFragment();
            DeviceDetailsLauncher deviceDetailsLauncher = parentFragment instanceof DeviceDetailsLauncher ? (DeviceDetailsLauncher) parentFragment : null;
            if (deviceDetailsLauncher != null) {
                DeviceDetailsLauncher.CC.openDeviceDetails$default(deviceDetailsLauncher, (Device) list.get(i - 1), (String) null, 2, (Object) null);
            }
            deviceDetailsV2DialogFragment.dismiss();
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit bindViewModel$lambda$12(DeviceDetailsV2DialogFragment deviceDetailsV2DialogFragment, Integer num) {
        if (num.intValue() >= 0) {
            DeviceSensorsViewModel deviceSensorsViewModel = deviceDetailsV2DialogFragment.sensorsViewModel;
            if (deviceSensorsViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sensorsViewModel");
                deviceSensorsViewModel = null;
            }
            List<SensorType> sensors = deviceDetailsV2DialogFragment.sensorCardsAdapter.getSensors();
            Intrinsics.checkNotNull(num);
            deviceSensorsViewModel.selectSensor(sensors.get(num.intValue()), true);
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit bindViewModel$lambda$13(DeviceDetailsV2DialogFragment deviceDetailsV2DialogFragment, Boolean bool) {
        DeviceSensorsViewModel deviceSensorsViewModel = deviceDetailsV2DialogFragment.sensorsViewModel;
        DeviceSensorsViewModel deviceSensorsViewModel2 = null;
        if (deviceSensorsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sensorsViewModel");
            deviceSensorsViewModel = null;
        }
        Intrinsics.checkNotNull(bool);
        deviceSensorsViewModel.setLastGraphExpended(bool.booleanValue());
        if (bool.booleanValue()) {
            DeviceSensorCardsAdapter deviceSensorCardsAdapter = deviceDetailsV2DialogFragment.sensorCardsAdapter;
            List<SensorType> sensors = deviceSensorCardsAdapter.getSensors();
            DeviceSensorsViewModel deviceSensorsViewModel3 = deviceDetailsV2DialogFragment.sensorsViewModel;
            if (deviceSensorsViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sensorsViewModel");
            } else {
                deviceSensorsViewModel2 = deviceSensorsViewModel3;
            }
            deviceSensorCardsAdapter.setSelectedIndex(sensors.indexOf(deviceSensorsViewModel2.getSelectedSensor()));
        } else {
            deviceDetailsV2DialogFragment.sensorCardsAdapter.setSelectedIndex(-1);
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit bindViewModel$lambda$14(DeviceDetailsV2DialogFragment deviceDetailsV2DialogFragment, SensorType sensorType) {
        DeviceSensorsViewModel deviceSensorsViewModel = deviceDetailsV2DialogFragment.sensorsViewModel;
        DeviceSensorsViewModel deviceSensorsViewModel2 = null;
        if (deviceSensorsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sensorsViewModel");
            deviceSensorsViewModel = null;
        }
        deviceSensorsViewModel.setLastSelectedSensor(sensorType);
        DeviceSensorsViewModel deviceSensorsViewModel3 = deviceDetailsV2DialogFragment.sensorsViewModel;
        if (deviceSensorsViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sensorsViewModel");
        } else {
            deviceSensorsViewModel2 = deviceSensorsViewModel3;
        }
        if (Intrinsics.areEqual((Object) deviceSensorsViewModel2.getGraphExpended().getValue(), (Object) true)) {
            DeviceSensorCardsAdapter deviceSensorCardsAdapter = deviceDetailsV2DialogFragment.sensorCardsAdapter;
            deviceSensorCardsAdapter.setSelectedIndex(deviceSensorCardsAdapter.getSensors().indexOf(sensorType));
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit bindViewModel$lambda$17(DeviceDetailsV2DialogFragment deviceDetailsV2DialogFragment, DeviceData deviceData) {
        DeviceSensorCardsAdapter deviceSensorCardsAdapter = deviceDetailsV2DialogFragment.sensorCardsAdapter;
        Intrinsics.checkNotNull(deviceData);
        deviceSensorCardsAdapter.updateSensorData(deviceData);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit bindViewModel$lambda$18(DeviceDetailsV2DialogFragment deviceDetailsV2DialogFragment, Device device) {
        Timber.Forest.v("liveDevice = " + device, new Object[0]);
        if (device == null) {
            deviceDetailsV2DialogFragment.dismiss();
        } else {
            DialogfragmentDeviceDetailsV2Binding dialogfragmentDeviceDetailsV2Binding = deviceDetailsV2DialogFragment.binding;
            DialogfragmentDeviceDetailsV2Binding dialogfragmentDeviceDetailsV2Binding2 = null;
            if (dialogfragmentDeviceDetailsV2Binding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dialogfragmentDeviceDetailsV2Binding = null;
            }
            dialogfragmentDeviceDetailsV2Binding.deviceName.setText(device.getName());
            DialogfragmentDeviceDetailsV2Binding dialogfragmentDeviceDetailsV2Binding3 = deviceDetailsV2DialogFragment.binding;
            if (dialogfragmentDeviceDetailsV2Binding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                dialogfragmentDeviceDetailsV2Binding2 = dialogfragmentDeviceDetailsV2Binding3;
            }
            dialogfragmentDeviceDetailsV2Binding2.btnStandby.setCheckedSilence(DeviceKt.isStandByOn(device));
            deviceDetailsV2DialogFragment.sensorCardsAdapter.setStandBy(DeviceKt.isStandByOn(device));
            deviceDetailsV2DialogFragment.getViewModel().setDevice(device);
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0021, code lost:
        if (com.blueair.core.model.DeviceKt.isSafetySwitchOn(r1) == true) goto L_0x0025;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final kotlin.Unit bindViewModel$lambda$19(com.blueair.devicedetails.dialog.DeviceDetailsV2DialogFragment r3, java.lang.Boolean r4) {
        /*
            com.blueair.devicedetails.databinding.DialogfragmentDeviceDetailsV2Binding r0 = r3.binding
            if (r0 != 0) goto L_0x000a
            java.lang.String r0 = "binding"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            r0 = 0
        L_0x000a:
            com.blueair.viewcore.view.SwitchCompat r0 = r0.btnStandby
            boolean r1 = r4.booleanValue()
            if (r1 != 0) goto L_0x0024
            com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel r1 = r3.getViewModel()
            com.blueair.core.model.Device r1 = r1.getDevice()
            if (r1 == 0) goto L_0x0024
            boolean r1 = com.blueair.core.model.DeviceKt.isSafetySwitchOn(r1)
            r2 = 1
            if (r1 != r2) goto L_0x0024
            goto L_0x0025
        L_0x0024:
            r2 = 0
        L_0x0025:
            r0.setEnabled(r2)
            com.blueair.devicedetails.adapter.DeviceSensorCardsAdapter r3 = r3.sensorCardsAdapter
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            boolean r4 = r4.booleanValue()
            r3.setOffline(r4)
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.dialog.DeviceDetailsV2DialogFragment.bindViewModel$lambda$19(com.blueair.devicedetails.dialog.DeviceDetailsV2DialogFragment, java.lang.Boolean):kotlin.Unit");
    }

    private final void showDeviceMessages() {
        FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "beginTransaction(...)");
        DeviceMessagesFragment newInstance = DeviceMessagesFragment.Companion.newInstance();
        DialogfragmentDeviceDetailsV2Binding dialogfragmentDeviceDetailsV2Binding = this.binding;
        if (dialogfragmentDeviceDetailsV2Binding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogfragmentDeviceDetailsV2Binding = null;
        }
        beginTransaction.replace(dialogfragmentDeviceDetailsV2Binding.messagesContainer.getId(), newInstance);
        beginTransaction.commitAllowingStateLoss();
    }

    private final void showDeviceSensorsGraph() {
        FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "beginTransaction(...)");
        DeviceSensorsGraphFragment newInstance = DeviceSensorsGraphFragment.Companion.newInstance();
        DialogfragmentDeviceDetailsV2Binding dialogfragmentDeviceDetailsV2Binding = this.binding;
        if (dialogfragmentDeviceDetailsV2Binding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogfragmentDeviceDetailsV2Binding = null;
        }
        beginTransaction.replace(dialogfragmentDeviceDetailsV2Binding.graphContainer.getId(), newInstance);
        beginTransaction.commitAllowingStateLoss();
    }

    private final void showDeviceControls() {
        FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "beginTransaction(...)");
        DeviceControlsFragment newInstance = DeviceControlsFragment.Companion.newInstance();
        DialogfragmentDeviceDetailsV2Binding dialogfragmentDeviceDetailsV2Binding = this.binding;
        if (dialogfragmentDeviceDetailsV2Binding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogfragmentDeviceDetailsV2Binding = null;
        }
        beginTransaction.replace(dialogfragmentDeviceDetailsV2Binding.devicesControlsContainer.getId(), newInstance);
        beginTransaction.commitAllowingStateLoss();
    }

    private final void scrollToView(String str) {
        DialogfragmentDeviceDetailsV2Binding dialogfragmentDeviceDetailsV2Binding = this.binding;
        if (dialogfragmentDeviceDetailsV2Binding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogfragmentDeviceDetailsV2Binding = null;
        }
        NestedScrollView nestedScrollView = dialogfragmentDeviceDetailsV2Binding.scrollable;
        Intrinsics.checkNotNullExpressionValue(nestedScrollView, "scrollable");
        nestedScrollView.postDelayed(new DeviceDetailsV2DialogFragment$$ExternalSyntheticLambda0(nestedScrollView, str), 500);
    }

    /* access modifiers changed from: private */
    public static final void scrollToView$lambda$21(NestedScrollView nestedScrollView, String str) {
        if (nestedScrollView.findViewWithTag(str) != null) {
            nestedScrollView.fullScroll(130);
        }
    }

    private final void scrollToFilterStatus() {
        scrollToView("FILTER");
    }

    private final void scrollToWickStatus() {
        scrollToView("WICK");
    }

    private final void scrollToRefresherStatus() {
        scrollToView("REFRESHER");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0036, code lost:
        if (r0.equals(com.blueair.push.NotificationService.ACTION_TYPE_FILTER_STATUS) == false) goto L_0x0073;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0045, code lost:
        if (r0.equals(com.blueair.push.NotificationService.ACTION_TYPE_FILTER) == false) goto L_0x0073;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0048, code lost:
        scrollToFilterStatus();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void handleActions() {
        /*
            r2 = this;
            com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel r0 = r2.getViewModel()
            java.lang.String r0 = r0.getActionType()
            if (r0 != 0) goto L_0x000c
            java.lang.String r0 = jumpToAction
        L_0x000c:
            if (r0 == 0) goto L_0x0073
            int r1 = r0.hashCode()
            switch(r1) {
                case -2123968024: goto L_0x0066;
                case -1785478504: goto L_0x0059;
                case -1774126825: goto L_0x004c;
                case -1274492040: goto L_0x003f;
                case -757923495: goto L_0x0039;
                case -547902823: goto L_0x0030;
                case 590772454: goto L_0x0023;
                case 1919485769: goto L_0x0016;
                default: goto L_0x0015;
            }
        L_0x0015:
            goto L_0x0073
        L_0x0016:
            java.lang.String r1 = "refresher_status"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x001f
            goto L_0x0073
        L_0x001f:
            r2.scrollToRefresherStatus()
            goto L_0x0073
        L_0x0023:
            java.lang.String r1 = "wick_purchase"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x002c
            goto L_0x0073
        L_0x002c:
            r2.scrollToWickStatus()
            return
        L_0x0030:
            java.lang.String r1 = "filter_status"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0048
            goto L_0x0073
        L_0x0039:
            java.lang.String r1 = "device_details"
            r0.equals(r1)
            goto L_0x0073
        L_0x003f:
            java.lang.String r1 = "filter"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0048
            goto L_0x0073
        L_0x0048:
            r2.scrollToFilterStatus()
            goto L_0x0073
        L_0x004c:
            java.lang.String r1 = "wick_status"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0055
            goto L_0x0073
        L_0x0055:
            r2.scrollToWickStatus()
            goto L_0x0073
        L_0x0059:
            java.lang.String r1 = "refresher_purchase"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0062
            goto L_0x0073
        L_0x0062:
            r2.scrollToRefresherStatus()
            return
        L_0x0066:
            java.lang.String r1 = "filter_purchase"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x006f
            goto L_0x0073
        L_0x006f:
            r2.scrollToFilterStatus()
            return
        L_0x0073:
            com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel r0 = r2.getViewModel()
            r1 = 0
            r0.setActionType(r1)
            jumpToAction = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.dialog.DeviceDetailsV2DialogFragment.handleActions():void");
    }

    public void dismiss() {
        FragmentKt.setFragmentResult(this, REQUEST_KEY_DEVICE_DETAILS_CLOSED, BundleKt.bundleOf());
        super.dismiss();
    }

    public void onCancel(DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(dialogInterface, "dialog");
        FragmentKt.setFragmentResult(this, REQUEST_KEY_DEVICE_DETAILS_CLOSED, BundleKt.bundleOf());
        super.onCancel(dialogInterface);
    }
}
