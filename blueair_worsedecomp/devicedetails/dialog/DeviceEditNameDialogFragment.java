package com.blueair.devicedetails.dialog;

import android.os.Bundle;
import com.blueair.core.model.Device;
import com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel;
import com.blueair.viewcore.dialog.BaseEditDeviceNameDialogFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u0006H\u0014R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0002X.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001d"}, d2 = {"Lcom/blueair/devicedetails/dialog/DeviceEditNameDialogFragment;", "Lcom/blueair/viewcore/dialog/BaseEditDeviceNameDialogFragment;", "Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "viewModel", "getViewModel", "()Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;", "setViewModel", "(Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;)V", "device", "Lcom/blueair/core/model/Device;", "getDevice", "()Lcom/blueair/core/model/Device;", "setDevice", "(Lcom/blueair/core/model/Device;)V", "onViewCreated", "", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "onSaveBtnClicked", "text", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceEditNameDialogFragment.kt */
public final class DeviceEditNameDialogFragment extends BaseEditDeviceNameDialogFragment<DeviceDetailsViewModel> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public Device device;
    private final String screenName;
    public DeviceDetailsViewModel viewModel;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/blueair/devicedetails/dialog/DeviceEditNameDialogFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/dialog/DeviceEditNameDialogFragment;", "device", "Lcom/blueair/core/model/Device;", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceEditNameDialogFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DeviceEditNameDialogFragment newInstance(Device device) {
            Intrinsics.checkNotNullParameter(device, "device");
            DeviceEditNameDialogFragment deviceEditNameDialogFragment = new DeviceEditNameDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("device", device);
            deviceEditNameDialogFragment.setArguments(bundle);
            return deviceEditNameDialogFragment;
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

    /* JADX WARNING: type inference failed for: r3v17, types: [android.os.Parcelable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onViewCreated(android.view.View r3, android.os.Bundle r4) {
        /*
            r2 = this;
            java.lang.String r0 = "view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            super.onViewCreated(r3, r4)
            android.widget.TextView r3 = r2.getDialogTitle()
            r4 = 0
            if (r3 == 0) goto L_0x0020
            android.content.Context r0 = r2.getContext()
            if (r0 == 0) goto L_0x001c
            int r1 = com.blueair.viewcore.R.string.edit_purifier_name_title
            java.lang.CharSequence r0 = r0.getText(r1)
            goto L_0x001d
        L_0x001c:
            r0 = r4
        L_0x001d:
            r3.setText(r0)
        L_0x0020:
            android.widget.TextView r3 = r2.getDialogMsg()
            if (r3 == 0) goto L_0x0037
            android.content.Context r0 = r2.getContext()
            if (r0 == 0) goto L_0x0033
            int r1 = com.blueair.viewcore.R.string.edit_purifier_name_msg
            java.lang.CharSequence r0 = r0.getText(r1)
            goto L_0x0034
        L_0x0033:
            r0 = r4
        L_0x0034:
            r3.setText(r0)
        L_0x0037:
            android.os.Bundle r3 = r2.getArguments()
            if (r3 == 0) goto L_0x0046
            java.lang.String r4 = "device"
            android.os.Parcelable r3 = r3.getParcelable(r4)
            r4 = r3
            com.blueair.core.model.Device r4 = (com.blueair.core.model.Device) r4
        L_0x0046:
            if (r4 == 0) goto L_0x0098
            r2.setDevice(r4)
            r3 = r2
            com.blueair.viewcore.dialog.BaseDialogFragment r3 = (com.blueair.viewcore.dialog.BaseDialogFragment) r3
            androidx.fragment.app.FragmentActivity r3 = r3.requireActivity()
            java.lang.String r4 = "requireActivity(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            androidx.lifecycle.ViewModelStoreOwner r3 = (androidx.lifecycle.ViewModelStoreOwner) r3
            androidx.lifecycle.ViewModelProvider r4 = new androidx.lifecycle.ViewModelProvider
            r4.<init>((androidx.lifecycle.ViewModelStoreOwner) r3)
            java.lang.Class<com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel> r3 = com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel.class
            androidx.lifecycle.ViewModel r3 = r4.get(r3)
            com.blueair.viewcore.viewmodel.BaseViewModel r3 = (com.blueair.viewcore.viewmodel.BaseViewModel) r3
            com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel r3 = (com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel) r3
            r2.setViewModel((com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel) r3)
            android.widget.EditText r3 = r2.getEditText()
            if (r3 == 0) goto L_0x007e
            com.blueair.core.model.Device r4 = r2.getDevice()
            java.lang.String r4 = r4.getName()
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r3.setText(r4)
        L_0x007e:
            android.widget.EditText r3 = r2.getEditText()
            if (r3 == 0) goto L_0x0097
            android.text.Editable r3 = r3.getText()
            if (r3 == 0) goto L_0x0097
            int r3 = r3.length()
            android.widget.EditText r4 = r2.getEditText()
            if (r4 == 0) goto L_0x0097
            r4.setSelection(r3)
        L_0x0097:
            return
        L_0x0098:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.String r4 = "Required value was null."
            java.lang.String r4 = r4.toString()
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.dialog.DeviceEditNameDialogFragment.onViewCreated(android.view.View, android.os.Bundle):void");
    }

    /* access modifiers changed from: protected */
    public void onSaveBtnClicked(String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        getViewModel().setDeviceName(getDevice(), str);
        super.onSaveBtnClicked(str);
    }
}
