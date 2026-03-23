package com.blueair.devicedetails.viewholder;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.viewbinding.ViewBinding;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceNewClassic;
import com.blueair.core.model.HasChildLock;
import com.blueair.viewcore.view.SwitchCompat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceNChildLockHolder;", "Lcom/blueair/devicedetails/viewholder/DeviceAttributeHolder;", "binding", "Landroidx/viewbinding/ViewBinding;", "device", "Lcom/blueair/core/model/Device;", "onChildLockSetListener", "Lkotlin/Function1;", "", "", "<init>", "(Landroidx/viewbinding/ViewBinding;Lcom/blueair/core/model/Device;Lkotlin/jvm/functions/Function1;)V", "getBinding", "()Landroidx/viewbinding/ViewBinding;", "getDevice", "()Lcom/blueair/core/model/Device;", "switchBtn", "Lcom/blueair/viewcore/view/SwitchCompat;", "update", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceNChildLockHolder.kt */
public final class DeviceNChildLockHolder extends DeviceAttributeHolder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final ViewBinding binding;
    private final Device device;
    private final Function1<Boolean, Unit> onChildLockSetListener;
    private final SwitchCompat switchBtn;

    public final ViewBinding getBinding() {
        return this.binding;
    }

    public final Device getDevice() {
        return this.device;
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¨\u0006\u000e"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceNChildLockHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceNChildLockHolder;", "parentView", "Landroid/view/ViewGroup;", "device", "Lcom/blueair/core/model/Device;", "onChildLockSetListener", "Lkotlin/Function1;", "", "", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceNChildLockHolder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DeviceNChildLockHolder newInstance(ViewGroup viewGroup, Device device, Function1<? super Boolean, Unit> function1) {
            Function3 function3;
            Intrinsics.checkNotNullParameter(viewGroup, "parentView");
            Intrinsics.checkNotNullParameter(function1, "onChildLockSetListener");
            if (device instanceof DeviceNewClassic) {
                function3 = DeviceNChildLockHolder$Companion$newInstance$inflate$1.INSTANCE;
            } else {
                function3 = DeviceNChildLockHolder$Companion$newInstance$inflate$2.INSTANCE;
            }
            LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
            Intrinsics.checkNotNullExpressionValue(from, "from(...)");
            return new DeviceNChildLockHolder((ViewBinding) function3.invoke(from, viewGroup, false), device, function1);
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DeviceNChildLockHolder(androidx.viewbinding.ViewBinding r3, com.blueair.core.model.Device r4, kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r5) {
        /*
            r2 = this;
            java.lang.String r0 = "binding"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "onChildLockSetListener"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            android.view.View r0 = r3.getRoot()
            java.lang.String r1 = "getRoot(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r2.<init>(r0)
            r2.binding = r3
            r2.device = r4
            r2.onChildLockSetListener = r5
            boolean r5 = r3 instanceof com.blueair.devicedetails.databinding.HolderDeviceHChildLockBinding
            java.lang.String r0 = "switchBtn"
            if (r5 == 0) goto L_0x003a
            r5 = r3
            com.blueair.devicedetails.databinding.HolderDeviceHChildLockBinding r5 = (com.blueair.devicedetails.databinding.HolderDeviceHChildLockBinding) r5
            com.blueair.viewcore.view.SwitchCompat r5 = r5.switchBtn
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r0)
            r2.switchBtn = r5
            boolean r4 = r4 instanceof com.blueair.core.model.DevicePet20
            if (r4 == 0) goto L_0x004b
            com.blueair.devicedetails.databinding.HolderDeviceHChildLockBinding r3 = (com.blueair.devicedetails.databinding.HolderDeviceHChildLockBinding) r3
            android.widget.TextView r3 = r3.title
            int r4 = com.blueair.viewcore.R.string.display_lock_pet20
            r3.setText(r4)
            goto L_0x004b
        L_0x003a:
            java.lang.String r4 = "null cannot be cast to non-null type com.blueair.devicedetails.databinding.HolderDeviceNChildLockBinding"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3, r4)
            r4 = r3
            com.blueair.devicedetails.databinding.HolderDeviceNChildLockBinding r4 = (com.blueair.devicedetails.databinding.HolderDeviceNChildLockBinding) r4
            com.blueair.devicedetails.databinding.HolderDeviceNChildLockBinding r3 = (com.blueair.devicedetails.databinding.HolderDeviceNChildLockBinding) r3
            com.blueair.viewcore.view.SwitchCompat r3 = r3.switchBtn
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r0)
            r2.switchBtn = r3
        L_0x004b:
            com.blueair.viewcore.view.SwitchCompat r3 = r2.switchBtn
            com.blueair.devicedetails.viewholder.DeviceNChildLockHolder$$ExternalSyntheticLambda0 r4 = new com.blueair.devicedetails.viewholder.DeviceNChildLockHolder$$ExternalSyntheticLambda0
            r4.<init>(r2)
            r3.setOnCheckedChangeListener(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.viewholder.DeviceNChildLockHolder.<init>(androidx.viewbinding.ViewBinding, com.blueair.core.model.Device, kotlin.jvm.functions.Function1):void");
    }

    /* access modifiers changed from: private */
    public static final void _init_$lambda$0(DeviceNChildLockHolder deviceNChildLockHolder, CompoundButton compoundButton, boolean z) {
        deviceNChildLockHolder.onChildLockSetListener.invoke(Boolean.valueOf(z));
    }

    public void update(Device device2) {
        Intrinsics.checkNotNullParameter(device2, "device");
        if (device2 instanceof HasChildLock) {
            this.switchBtn.setCheckedSilence(((HasChildLock) device2).isChildLockOn());
        }
    }
}
