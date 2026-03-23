package com.blueair.viewcore.dialog;

import android.view.View;
import androidx.fragment.app.DialogFragment;
import com.blueair.core.model.DeviceType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/blueair/viewcore/dialog/MacAddressInfoDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "deviceType", "Lcom/blueair/core/model/DeviceType;", "<init>", "(Lcom/blueair/core/model/DeviceType;)V", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: MacAddressInfoDialogFragment.kt */
public final class MacAddressInfoDialogFragment extends DialogFragment {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private DeviceType deviceType;

    public MacAddressInfoDialogFragment() {
        this((DeviceType) null, 1, (DefaultConstructorMarker) null);
    }

    public MacAddressInfoDialogFragment(DeviceType deviceType2) {
        this.deviceType = deviceType2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MacAddressInfoDialogFragment(DeviceType deviceType2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : deviceType2);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¨\u0006\b"}, d2 = {"Lcom/blueair/viewcore/dialog/MacAddressInfoDialogFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/viewcore/dialog/MacAddressInfoDialogFragment;", "deviceType", "Lcom/blueair/core/model/DeviceType;", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: MacAddressInfoDialogFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ MacAddressInfoDialogFragment newInstance$default(Companion companion, DeviceType deviceType, int i, Object obj) {
            if ((i & 1) != 0) {
                deviceType = null;
            }
            return companion.newInstance(deviceType);
        }

        public final MacAddressInfoDialogFragment newInstance(DeviceType deviceType) {
            return new MacAddressInfoDialogFragment(deviceType);
        }
    }

    /* JADX WARNING: type inference failed for: r6v5, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.app.Dialog onCreateDialog(android.os.Bundle r6) {
        /*
            r5 = this;
            androidx.fragment.app.FragmentActivity r6 = r5.getActivity()
            r0 = 0
            if (r6 == 0) goto L_0x000c
            android.view.LayoutInflater r6 = r6.getLayoutInflater()
            goto L_0x000d
        L_0x000c:
            r6 = r0
        L_0x000d:
            if (r6 == 0) goto L_0x0016
            int r1 = com.blueair.viewcore.R.layout.dialog_mac_address_info
            android.view.View r6 = r6.inflate(r1, r0)
            goto L_0x0017
        L_0x0016:
            r6 = r0
        L_0x0017:
            if (r6 == 0) goto L_0x0040
            int r1 = com.blueair.viewcore.R.id.dialog_msg
            android.view.View r1 = r6.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            if (r1 == 0) goto L_0x0040
            com.blueair.core.model.DeviceType r2 = r5.deviceType
            boolean r3 = r2 instanceof com.blueair.core.model.DeviceType.B4
            if (r3 != 0) goto L_0x0035
            boolean r2 = r2 instanceof com.blueair.core.model.DeviceType.B4sp
            if (r2 == 0) goto L_0x002e
            goto L_0x0035
        L_0x002e:
            int r2 = com.blueair.viewcore.R.string.mac_address_info
            java.lang.String r2 = r5.getString(r2)
            goto L_0x003b
        L_0x0035:
            int r2 = com.blueair.viewcore.R.string.mac_address_info_b4
            java.lang.String r2 = r5.getString(r2)
        L_0x003b:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r1.setText(r2)
        L_0x0040:
            android.app.Dialog r1 = new android.app.Dialog
            android.content.Context r2 = r5.requireContext()
            r1.<init>(r2)
            if (r6 == 0) goto L_0x004e
            r1.setContentView(r6)
        L_0x004e:
            androidx.fragment.app.FragmentActivity r2 = r5.getActivity()
            if (r2 == 0) goto L_0x0065
            android.view.Window r3 = r1.getWindow()
            if (r3 == 0) goto L_0x0065
            android.content.Context r2 = (android.content.Context) r2
            int r4 = com.blueair.viewcore.R.drawable.rounded_rectangle_white
            android.graphics.drawable.Drawable r2 = androidx.core.content.ContextCompat.getDrawable(r2, r4)
            r3.setBackgroundDrawable(r2)
        L_0x0065:
            if (r6 == 0) goto L_0x0070
            int r0 = com.blueair.viewcore.R.id.buttonClose
            android.view.View r6 = r6.findViewById(r0)
            r0 = r6
            com.google.android.material.button.MaterialButton r0 = (com.google.android.material.button.MaterialButton) r0
        L_0x0070:
            if (r0 == 0) goto L_0x007a
            com.blueair.viewcore.dialog.MacAddressInfoDialogFragment$$ExternalSyntheticLambda0 r6 = new com.blueair.viewcore.dialog.MacAddressInfoDialogFragment$$ExternalSyntheticLambda0
            r6.<init>(r5)
            r0.setOnClickListener(r6)
        L_0x007a:
            r1.show()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.viewcore.dialog.MacAddressInfoDialogFragment.onCreateDialog(android.os.Bundle):android.app.Dialog");
    }

    /* access modifiers changed from: private */
    public static final void onCreateDialog$lambda$3(MacAddressInfoDialogFragment macAddressInfoDialogFragment, View view) {
        macAddressInfoDialogFragment.dismiss();
    }
}
