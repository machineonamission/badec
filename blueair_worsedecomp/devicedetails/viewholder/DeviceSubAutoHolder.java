package com.blueair.devicedetails.viewholder;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.blueair.core.model.Device;
import com.blueair.core.model.HasPetMainMode;
import com.blueair.core.model.SmartSubMode;
import com.blueair.devicedetails.databinding.HolderDeviceSubAutoBinding;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u000e\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0011R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceSubAutoHolder;", "Lcom/blueair/devicedetails/viewholder/DeviceAttributeHolder;", "binding", "Lcom/blueair/devicedetails/databinding/HolderDeviceSubAutoBinding;", "device", "Lcom/blueair/core/model/Device;", "isInSchedule", "", "onSubAutoSetListener", "Lkotlin/Function1;", "", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceSubAutoBinding;Lcom/blueair/core/model/Device;ZLkotlin/jvm/functions/Function1;)V", "getBinding", "()Lcom/blueair/devicedetails/databinding/HolderDeviceSubAutoBinding;", "getDevice", "()Lcom/blueair/core/model/Device;", "()Z", "update", "smartSubMode", "Lcom/blueair/core/model/SmartSubMode;", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceSubAutoHolder.kt */
public final class DeviceSubAutoHolder extends DeviceAttributeHolder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final HolderDeviceSubAutoBinding binding;
    private final Device device;
    private final boolean isInSchedule;
    private final Function1<Boolean, Unit> onSubAutoSetListener;

    public final HolderDeviceSubAutoBinding getBinding() {
        return this.binding;
    }

    public final Device getDevice() {
        return this.device;
    }

    public final boolean isInSchedule() {
        return this.isInSchedule;
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J4\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000e0\r¨\u0006\u000f"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceSubAutoHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceSubAutoHolder;", "parentView", "Landroid/view/ViewGroup;", "device", "Lcom/blueair/core/model/Device;", "isInSchedule", "", "onSubAutoSetListener", "Lkotlin/Function1;", "", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceSubAutoHolder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DeviceSubAutoHolder newInstance(ViewGroup viewGroup, Device device, boolean z, Function1<? super Boolean, Unit> function1) {
            Intrinsics.checkNotNullParameter(viewGroup, "parentView");
            Intrinsics.checkNotNullParameter(function1, "onSubAutoSetListener");
            HolderDeviceSubAutoBinding inflate = HolderDeviceSubAutoBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            return new DeviceSubAutoHolder(inflate, device, z, function1);
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DeviceSubAutoHolder(com.blueair.devicedetails.databinding.HolderDeviceSubAutoBinding r3, com.blueair.core.model.Device r4, boolean r5, kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r6) {
        /*
            r2 = this;
            java.lang.String r0 = "binding"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "onSubAutoSetListener"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            android.widget.FrameLayout r0 = r3.getRoot()
            java.lang.String r1 = "getRoot(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            android.view.View r0 = (android.view.View) r0
            r2.<init>(r0)
            r2.binding = r3
            r2.device = r4
            r2.isInSchedule = r5
            r2.onSubAutoSetListener = r6
            com.blueair.viewcore.view.SwitchCompat r4 = r3.switchBtn
            com.blueair.devicedetails.viewholder.DeviceSubAutoHolder$$ExternalSyntheticLambda0 r6 = new com.blueair.devicedetails.viewholder.DeviceSubAutoHolder$$ExternalSyntheticLambda0
            r6.<init>(r2)
            r4.setOnCheckedChangeListener(r6)
            if (r5 == 0) goto L_0x003d
            androidx.constraintlayout.widget.ConstraintLayout r3 = r3.contentContainer
            android.view.View r4 = r2.itemView
            android.content.Context r4 = r4.getContext()
            int r5 = com.blueair.viewcore.R.drawable.rounded_square_anti_flash_blue_r8
            android.graphics.drawable.Drawable r4 = androidx.appcompat.content.res.AppCompatResources.getDrawable(r4, r5)
            r3.setBackground(r4)
        L_0x003d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.viewholder.DeviceSubAutoHolder.<init>(com.blueair.devicedetails.databinding.HolderDeviceSubAutoBinding, com.blueair.core.model.Device, boolean, kotlin.jvm.functions.Function1):void");
    }

    /* access modifiers changed from: private */
    public static final void _init_$lambda$0(DeviceSubAutoHolder deviceSubAutoHolder, CompoundButton compoundButton, boolean z) {
        deviceSubAutoHolder.onSubAutoSetListener.invoke(Boolean.valueOf(z));
    }

    public void update(Device device2) {
        Intrinsics.checkNotNullParameter(device2, "device");
        if (device2 instanceof HasPetMainMode) {
            update(((HasPetMainMode) device2).smartSubMode());
        }
    }

    public final void update(SmartSubMode smartSubMode) {
        Intrinsics.checkNotNullParameter(smartSubMode, "smartSubMode");
        this.binding.switchBtn.setCheckedSilence(smartSubMode == SmartSubMode.AUTO_ON);
    }
}
