package com.blueair.adddevice.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.os.BundleKt;
import androidx.core.util.TypedValueCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.airbnb.lottie.LottieAnimationView;
import com.blueair.adddevice.databinding.DialogConnectInstructionsBinding;
import com.blueair.adddevice.viewmodel.AddDeviceViewModel;
import com.blueair.core.model.AnalyticEvent;
import com.blueair.core.model.BluetoothDevice;
import com.blueair.core.model.DeviceImage;
import com.blueair.viewcore.R;
import com.blueair.viewcore.dialog.BaseDialogFragment;
import com.blueair.viewcore.utils.DeviceConfigProvider;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 .2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001.B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J$\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u001a\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u00182\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0010\u0010!\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020#H\u0002J\b\u0010$\u001a\u00020\u0012H\u0016J\b\u0010%\u001a\u00020\u0012H\u0016J\u0010\u0010&\u001a\u00020\u00122\u0006\u0010'\u001a\u00020(H\u0016J\u0006\u0010)\u001a\u00020\u0012J\b\u0010*\u001a\u00020\u0012H\u0002J\u0010\u0010+\u001a\u00020\u00122\u0006\u0010,\u001a\u00020-H\u0016R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\u0002X.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006/"}, d2 = {"Lcom/blueair/adddevice/dialog/ConnectInstructionsDialog;", "Lcom/blueair/viewcore/dialog/BaseDialogFragment;", "Lcom/blueair/adddevice/viewmodel/AddDeviceViewModel;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "binding", "Lcom/blueair/adddevice/databinding/DialogConnectInstructionsBinding;", "viewModel", "getViewModel", "()Lcom/blueair/adddevice/viewmodel/AddDeviceViewModel;", "setViewModel", "(Lcom/blueair/adddevice/viewmodel/AddDeviceViewModel;)V", "onCountdown", "Lkotlin/Function0;", "", "getOnCountdown", "()Lkotlin/jvm/functions/Function0;", "setOnCountdown", "(Lkotlin/jvm/functions/Function0;)V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "setImageAndAnim", "bluetoothDevice", "Lcom/blueair/core/model/BluetoothDevice;", "onStart", "onResume", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "switchConnecting", "hydrateConnecting", "showProgress", "shouldShowProgress", "", "Companion", "adddevice_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: ConnectInstructionsDialog.kt */
public final class ConnectInstructionsDialog extends BaseDialogFragment<AddDeviceViewModel> {
    public static final String ACTION_AUTO = "action_auto";
    public static final String ACTION_FAN_SPEED = "action_fan_speed";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String EXTRA_BLUETOOTH_DEVICE = "extra_bluetooth_device";
    private static final String EXTRA_DEVICE_CONNECTABLE = "extra_device_connectable";
    public static final String REQUEST_KEY = "ConnectInstructionsDialog";
    private DialogConnectInstructionsBinding binding;
    private Function0<Unit> onCountdown;
    private final String screenName = AnalyticEvent.ScreenViewEvent.ADD_DEVICE_PAIRING;
    public AddDeviceViewModel viewModel;

    public void showProgress(boolean z) {
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/blueair/adddevice/dialog/ConnectInstructionsDialog$Companion;", "", "<init>", "()V", "REQUEST_KEY", "", "ACTION_AUTO", "ACTION_FAN_SPEED", "EXTRA_DEVICE_CONNECTABLE", "EXTRA_BLUETOOTH_DEVICE", "newInstance", "Lcom/blueair/adddevice/dialog/ConnectInstructionsDialog;", "deviceName", "actionType", "bluetoothDevice", "Lcom/blueair/core/model/BluetoothDevice;", "connectable", "", "adddevice_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: ConnectInstructionsDialog.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ ConnectInstructionsDialog newInstance$default(Companion companion, String str, String str2, BluetoothDevice bluetoothDevice, boolean z, int i, Object obj) {
            if ((i & 8) != 0) {
                z = false;
            }
            return companion.newInstance(str, str2, bluetoothDevice, z);
        }

        public final ConnectInstructionsDialog newInstance(String str, String str2, BluetoothDevice bluetoothDevice, boolean z) {
            Intrinsics.checkNotNullParameter(str, "deviceName");
            Intrinsics.checkNotNullParameter(str2, SDKConstants.PARAM_GAME_REQUESTS_ACTION_TYPE);
            Intrinsics.checkNotNullParameter(bluetoothDevice, "bluetoothDevice");
            ConnectInstructionsDialog connectInstructionsDialog = new ConnectInstructionsDialog();
            Bundle bundle = new Bundle();
            bundle.putString("device", str);
            bundle.putString("action_type", str2);
            bundle.putBoolean(ConnectInstructionsDialog.EXTRA_DEVICE_CONNECTABLE, z);
            bundle.putParcelable(ConnectInstructionsDialog.EXTRA_BLUETOOTH_DEVICE, bluetoothDevice);
            connectInstructionsDialog.setArguments(bundle);
            return connectInstructionsDialog;
        }
    }

    /* access modifiers changed from: protected */
    public String getScreenName() {
        return this.screenName;
    }

    public AddDeviceViewModel getViewModel() {
        AddDeviceViewModel addDeviceViewModel = this.viewModel;
        if (addDeviceViewModel != null) {
            return addDeviceViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        return null;
    }

    public void setViewModel(AddDeviceViewModel addDeviceViewModel) {
        Intrinsics.checkNotNullParameter(addDeviceViewModel, "<set-?>");
        this.viewModel = addDeviceViewModel;
    }

    public final Function0<Unit> getOnCountdown() {
        return this.onCountdown;
    }

    public final void setOnCountdown(Function0<Unit> function0) {
        this.onCountdown = function0;
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
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        setViewModel((AddDeviceViewModel) ((BaseViewModel) new ViewModelProvider((ViewModelStoreOwner) requireActivity).get(AddDeviceViewModel.class)));
        DialogConnectInstructionsBinding inflate = DialogConnectInstructionsBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        DialogConnectInstructionsBinding dialogConnectInstructionsBinding = null;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        inflate.closeButton.setOnClickListener(new ConnectInstructionsDialog$$ExternalSyntheticLambda0(this));
        DialogConnectInstructionsBinding dialogConnectInstructionsBinding2 = this.binding;
        if (dialogConnectInstructionsBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogConnectInstructionsBinding2 = null;
        }
        dialogConnectInstructionsBinding2.btnBack.setOnClickListener(new ConnectInstructionsDialog$$ExternalSyntheticLambda1(this));
        Bundle arguments = getArguments();
        if (arguments != null) {
            String string = arguments.getString("device", "");
            Intrinsics.checkNotNull(string);
            CharSequence charSequence = string;
            if (charSequence.length() > 0) {
                DialogConnectInstructionsBinding dialogConnectInstructionsBinding3 = this.binding;
                if (dialogConnectInstructionsBinding3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    dialogConnectInstructionsBinding3 = null;
                }
                dialogConnectInstructionsBinding3.tvSubtitle.setText(charSequence);
                DialogConnectInstructionsBinding dialogConnectInstructionsBinding4 = this.binding;
                if (dialogConnectInstructionsBinding4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    dialogConnectInstructionsBinding4 = null;
                }
                AppCompatTextView appCompatTextView = dialogConnectInstructionsBinding4.tvSubtitle;
                Intrinsics.checkNotNullExpressionValue(appCompatTextView, "tvSubtitle");
                ViewExtensionsKt.show$default(appCompatTextView, false, 1, (Object) null);
            }
            BluetoothDevice bluetoothDevice = (BluetoothDevice) arguments.getParcelable(EXTRA_BLUETOOTH_DEVICE);
            if (bluetoothDevice != null) {
                setImageAndAnim(bluetoothDevice);
            }
            if (arguments.getBoolean(EXTRA_DEVICE_CONNECTABLE)) {
                hydrateConnecting();
            } else {
                if (Intrinsics.areEqual((Object) arguments.getString("action_type", ACTION_AUTO), (Object) ACTION_FAN_SPEED)) {
                    DialogConnectInstructionsBinding dialogConnectInstructionsBinding5 = this.binding;
                    if (dialogConnectInstructionsBinding5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        dialogConnectInstructionsBinding5 = null;
                    }
                    dialogConnectInstructionsBinding5.ivIndicator.setImageResource(R.drawable.ic_fanspeed);
                    DialogConnectInstructionsBinding dialogConnectInstructionsBinding6 = this.binding;
                    if (dialogConnectInstructionsBinding6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        dialogConnectInstructionsBinding6 = null;
                    }
                    dialogConnectInstructionsBinding6.contentTextview.setText(R.string.wifi_start_connecting_fan);
                } else if (bluetoothDevice != null && bluetoothDevice.getUseWaterdropAuto()) {
                    int dpToPx = (int) TypedValueCompat.dpToPx(8.0f, getResources().getDisplayMetrics());
                    DialogConnectInstructionsBinding dialogConnectInstructionsBinding7 = this.binding;
                    if (dialogConnectInstructionsBinding7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        dialogConnectInstructionsBinding7 = null;
                    }
                    AppCompatImageView appCompatImageView = dialogConnectInstructionsBinding7.ivIndicator;
                    Intrinsics.checkNotNullExpressionValue(appCompatImageView, "ivIndicator");
                    appCompatImageView.setPadding(dpToPx, dpToPx, dpToPx, dpToPx);
                    DialogConnectInstructionsBinding dialogConnectInstructionsBinding8 = this.binding;
                    if (dialogConnectInstructionsBinding8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        dialogConnectInstructionsBinding8 = null;
                    }
                    dialogConnectInstructionsBinding8.ivIndicator.setImageResource(R.drawable.ic_waterdrop_auto_flat);
                    DialogConnectInstructionsBinding dialogConnectInstructionsBinding9 = this.binding;
                    if (dialogConnectInstructionsBinding9 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        dialogConnectInstructionsBinding9 = null;
                    }
                    dialogConnectInstructionsBinding9.contentTextview.setText(R.string.wifi_connect_instruction_auto_humidity);
                }
                LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
                Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
                Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new ConnectInstructionsDialog$onCreateView$4$2(this, (Continuation<? super ConnectInstructionsDialog$onCreateView$4$2>) null), 3, (Object) null);
            }
        }
        DialogConnectInstructionsBinding dialogConnectInstructionsBinding10 = this.binding;
        if (dialogConnectInstructionsBinding10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            dialogConnectInstructionsBinding = dialogConnectInstructionsBinding10;
        }
        LinearLayout root = dialogConnectInstructionsBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    /* access modifiers changed from: private */
    public static final void onCreateView$lambda$1(ConnectInstructionsDialog connectInstructionsDialog, View view) {
        connectInstructionsDialog.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void onCreateView$lambda$2(ConnectInstructionsDialog connectInstructionsDialog, View view) {
        connectInstructionsDialog.dismiss();
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        super.onViewCreated(view, bundle);
    }

    private final void setImageAndAnim(BluetoothDevice bluetoothDevice) {
        DeviceImage deviceImage = DeviceConfigProvider.INSTANCE.getDeviceImage(bluetoothDevice);
        if (deviceImage != null) {
            DialogConnectInstructionsBinding dialogConnectInstructionsBinding = this.binding;
            if (dialogConnectInstructionsBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dialogConnectInstructionsBinding = null;
            }
            dialogConnectInstructionsBinding.ivDevice.setImageResource(deviceImage.getDevice());
            DialogConnectInstructionsBinding dialogConnectInstructionsBinding2 = this.binding;
            if (dialogConnectInstructionsBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dialogConnectInstructionsBinding2 = null;
            }
            LottieAnimationView lottieAnimationView = dialogConnectInstructionsBinding2.lavAnim;
            Intrinsics.checkNotNullExpressionValue(lottieAnimationView, "lavAnim");
            View view = lottieAnimationView;
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams != null) {
                ViewGroup.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
                ConstraintLayout.LayoutParams layoutParams3 = (ConstraintLayout.LayoutParams) layoutParams2;
                layoutParams3.horizontalBias = deviceImage.getBtnX();
                layoutParams3.verticalBias = deviceImage.getBtnY();
                view.setLayoutParams(layoutParams2);
                DialogConnectInstructionsBinding dialogConnectInstructionsBinding3 = this.binding;
                if (dialogConnectInstructionsBinding3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    dialogConnectInstructionsBinding3 = null;
                }
                LottieAnimationView lottieAnimationView2 = dialogConnectInstructionsBinding3.lavAnim;
                Intrinsics.checkNotNullExpressionValue(lottieAnimationView2, "lavAnim");
                ViewExtensionsKt.show$default(lottieAnimationView2, false, 1, (Object) null);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
    }

    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.addFlags(Integer.MIN_VALUE);
            window.getDecorView().setSystemUiVisibility(8448);
            window.setStatusBarColor(0);
            window.setLayout(-1, -1);
        }
    }

    public void onResume() {
        super.onResume();
        Bundle arguments = getArguments();
        getViewModel().recordResume((arguments == null || !arguments.getBoolean(EXTRA_DEVICE_CONNECTABLE, false)) ? "connect_instructions" : "connecting");
    }

    public void onDismiss(DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(dialogInterface, "dialog");
        super.onDismiss(dialogInterface);
        FragmentKt.setFragmentResult(this, REQUEST_KEY, BundleKt.bundleOf());
        this.onCountdown = null;
    }

    public final void switchConnecting() {
        DialogConnectInstructionsBinding dialogConnectInstructionsBinding = null;
        this.onCountdown = null;
        Bundle arguments = getArguments();
        if (arguments != null) {
            arguments.putBoolean(EXTRA_DEVICE_CONNECTABLE, true);
        }
        DialogConnectInstructionsBinding dialogConnectInstructionsBinding2 = this.binding;
        if (dialogConnectInstructionsBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            dialogConnectInstructionsBinding = dialogConnectInstructionsBinding2;
        }
        dialogConnectInstructionsBinding.getRoot().post(new ConnectInstructionsDialog$$ExternalSyntheticLambda2(this));
    }

    /* access modifiers changed from: private */
    public static final void switchConnecting$lambda$7(ConnectInstructionsDialog connectInstructionsDialog) {
        connectInstructionsDialog.hydrateConnecting();
    }

    private final void hydrateConnecting() {
        DialogConnectInstructionsBinding dialogConnectInstructionsBinding = this.binding;
        DialogConnectInstructionsBinding dialogConnectInstructionsBinding2 = null;
        if (dialogConnectInstructionsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogConnectInstructionsBinding = null;
        }
        int dpToPx = (int) TypedValueCompat.dpToPx(14.0f, getResources().getDisplayMetrics());
        DialogConnectInstructionsBinding dialogConnectInstructionsBinding3 = this.binding;
        if (dialogConnectInstructionsBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            dialogConnectInstructionsBinding2 = dialogConnectInstructionsBinding3;
        }
        AppCompatImageView appCompatImageView = dialogConnectInstructionsBinding2.ivIndicator;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "ivIndicator");
        appCompatImageView.setPadding(dpToPx, dpToPx, dpToPx, dpToPx);
        dialogConnectInstructionsBinding.ivIndicator.setImageResource(R.drawable.icon_bluetooth_on);
        dialogConnectInstructionsBinding.contentTitleTextview.setText(R.string.connecting);
        dialogConnectInstructionsBinding.contentTextview.setText(R.string.msg_connecting_to_bluetooth);
        dialogConnectInstructionsBinding.lavAnim.cancelAnimation();
        LottieAnimationView lottieAnimationView = dialogConnectInstructionsBinding.lavAnim;
        Intrinsics.checkNotNullExpressionValue(lottieAnimationView, "lavAnim");
        ViewExtensionsKt.hide(lottieAnimationView);
    }
}
