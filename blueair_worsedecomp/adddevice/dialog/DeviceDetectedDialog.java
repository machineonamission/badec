package com.blueair.adddevice.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import androidx.core.os.BundleKt;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentKt;
import androidx.fragment.app.FragmentManager;
import com.blueair.adddevice.databinding.DialogDeviceDetectedBinding;
import com.blueair.core.model.BluetoothDevice;
import com.blueair.core.model.DeviceImage;
import com.blueair.viewcore.R;
import com.blueair.viewcore.dialog.MacAddressInfoDialogFragment;
import com.blueair.viewcore.utils.DeviceConfigProvider;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/blueair/adddevice/dialog/DeviceDetectedDialog;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "connectClicked", "", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onDismiss", "", "dialog", "Landroid/content/DialogInterface;", "Companion", "adddevice_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceDetectedDialog.kt */
public final class DeviceDetectedDialog extends DialogFragment {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String DATA_CONNECT_CLICKED = "DATA_CONNECT_CLICKED";
    public static final String REQUEST_KEY = "DeviceDetectedDialog";
    private boolean connectClicked;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/blueair/adddevice/dialog/DeviceDetectedDialog$Companion;", "", "<init>", "()V", "REQUEST_KEY", "", "DATA_CONNECT_CLICKED", "newInstance", "Lcom/blueair/adddevice/dialog/DeviceDetectedDialog;", "device", "Lcom/blueair/core/model/BluetoothDevice;", "adddevice_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceDetectedDialog.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DeviceDetectedDialog newInstance(BluetoothDevice bluetoothDevice) {
            Intrinsics.checkNotNullParameter(bluetoothDevice, "device");
            DeviceDetectedDialog deviceDetectedDialog = new DeviceDetectedDialog();
            deviceDetectedDialog.setArguments(BundleKt.bundleOf(TuplesKt.to("device", bluetoothDevice)));
            return deviceDetectedDialog;
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        int i = 0;
        DialogDeviceDetectedBinding inflate = DialogDeviceDetectedBinding.inflate(getLayoutInflater(), (ViewGroup) null, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        Dialog dialog = new Dialog(requireContext());
        dialog.setContentView(inflate.getRoot());
        Window window = dialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.rounded_rectangle_white));
        }
        BluetoothDevice bluetoothDevice = (BluetoothDevice) requireArguments().getParcelable("device");
        if (bluetoothDevice == null) {
            dismiss();
            return dialog;
        }
        inflate.title.setText(bluetoothDevice.getModelName());
        ImageView imageView = inflate.deviceImg;
        DeviceImage deviceImage = DeviceConfigProvider.INSTANCE.getDeviceImage(bluetoothDevice);
        if (deviceImage != null) {
            i = deviceImage.getDevice();
        }
        imageView.setImageResource(i);
        inflate.macNumberValue.setText(bluetoothDevice.getWifiMac());
        inflate.macNumberTitle.setOnClickListener(new DeviceDetectedDialog$$ExternalSyntheticLambda0(this, bluetoothDevice));
        inflate.closeButton.setOnClickListener(new DeviceDetectedDialog$$ExternalSyntheticLambda1(this));
        inflate.connectButton.setOnClickListener(new DeviceDetectedDialog$$ExternalSyntheticLambda2(this));
        return dialog;
    }

    /* access modifiers changed from: private */
    public static final void onCreateDialog$lambda$5$lambda$2(DeviceDetectedDialog deviceDetectedDialog, BluetoothDevice bluetoothDevice, View view) {
        FragmentManager childFragmentManager = deviceDetectedDialog.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        Class<MacAddressInfoDialogFragment> cls = MacAddressInfoDialogFragment.class;
        Intrinsics.checkNotNullExpressionValue("MacAddressInfoDialogFragment", "getSimpleName(...)");
        if (!(childFragmentManager.findFragmentByTag("MacAddressInfoDialogFragment") instanceof MacAddressInfoDialogFragment) && !childFragmentManager.isStateSaved()) {
            MacAddressInfoDialogFragment.Companion.newInstance(bluetoothDevice.getDeviceType()).show(childFragmentManager, "MacAddressInfoDialogFragment");
        }
    }

    /* access modifiers changed from: private */
    public static final void onCreateDialog$lambda$5$lambda$3(DeviceDetectedDialog deviceDetectedDialog, View view) {
        deviceDetectedDialog.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void onCreateDialog$lambda$5$lambda$4(DeviceDetectedDialog deviceDetectedDialog, View view) {
        deviceDetectedDialog.connectClicked = true;
        deviceDetectedDialog.dismiss();
    }

    public void onDismiss(DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(dialogInterface, "dialog");
        super.onDismiss(dialogInterface);
        FragmentKt.setFragmentResult(this, REQUEST_KEY, BundleKt.bundleOf(TuplesKt.to(DATA_CONNECT_CLICKED, Boolean.valueOf(this.connectClicked))));
    }
}
