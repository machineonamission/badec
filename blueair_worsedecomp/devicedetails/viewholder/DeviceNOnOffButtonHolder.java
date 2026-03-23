package com.blueair.devicedetails.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.blueair.core.model.Device;
import com.blueair.core.model.HasStandBy;
import com.blueair.devicedetails.databinding.HolderDeviceNOnOffButtonBinding;
import com.blueair.viewcore.R;
import com.blueair.viewcore.ViewExtensionsKt;
import com.blueair.viewcore.utils.ModeIcon;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u000e\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceNOnOffButtonHolder;", "Lcom/blueair/devicedetails/viewholder/DeviceAttributeHolder;", "binding", "Lcom/blueair/devicedetails/databinding/HolderDeviceNOnOffButtonBinding;", "device", "Lcom/blueair/core/model/Device;", "onStandBySetListener", "Lkotlin/Function0;", "", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceNOnOffButtonBinding;Lcom/blueair/core/model/Device;Lkotlin/jvm/functions/Function0;)V", "getBinding", "()Lcom/blueair/devicedetails/databinding/HolderDeviceNOnOffButtonBinding;", "getDevice", "()Lcom/blueair/core/model/Device;", "update", "isStandByOn", "", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceNOnOffButtonHolder.kt */
public final class DeviceNOnOffButtonHolder extends DeviceAttributeHolder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final HolderDeviceNOnOffButtonBinding binding;
    private final Device device;
    private final Function0<Unit> onStandBySetListener;

    public final HolderDeviceNOnOffButtonBinding getBinding() {
        return this.binding;
    }

    public final Device getDevice() {
        return this.device;
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¨\u0006\r"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceNOnOffButtonHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceNOnOffButtonHolder;", "parentView", "Landroid/view/ViewGroup;", "device", "Lcom/blueair/core/model/Device;", "onStandBySetListener", "Lkotlin/Function0;", "", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceNOnOffButtonHolder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DeviceNOnOffButtonHolder newInstance(ViewGroup viewGroup, Device device, Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(viewGroup, "parentView");
            Intrinsics.checkNotNullParameter(function0, "onStandBySetListener");
            HolderDeviceNOnOffButtonBinding inflate = HolderDeviceNOnOffButtonBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            TextView textView = inflate.modeRoot.modeText;
            Intrinsics.checkNotNullExpressionValue(textView, "modeText");
            ViewExtensionsKt.bold(textView);
            return new DeviceNOnOffButtonHolder(inflate, device, function0);
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DeviceNOnOffButtonHolder(com.blueair.devicedetails.databinding.HolderDeviceNOnOffButtonBinding r3, com.blueair.core.model.Device r4, kotlin.jvm.functions.Function0<kotlin.Unit> r5) {
        /*
            r2 = this;
            java.lang.String r0 = "binding"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "onStandBySetListener"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            android.view.View r0 = r3.getRoot()
            java.lang.String r1 = "getRoot(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r2.<init>(r0)
            r2.binding = r3
            r2.device = r4
            r2.onStandBySetListener = r5
            com.blueair.devicedetails.databinding.HolderDeviceNModeButtonBinding r3 = r3.modeRoot
            android.widget.LinearLayout r3 = r3.modeRoot
            com.blueair.devicedetails.viewholder.DeviceNOnOffButtonHolder$$ExternalSyntheticLambda0 r4 = new com.blueair.devicedetails.viewholder.DeviceNOnOffButtonHolder$$ExternalSyntheticLambda0
            r4.<init>(r2)
            r3.setOnClickListener(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.viewholder.DeviceNOnOffButtonHolder.<init>(com.blueair.devicedetails.databinding.HolderDeviceNOnOffButtonBinding, com.blueair.core.model.Device, kotlin.jvm.functions.Function0):void");
    }

    /* access modifiers changed from: private */
    public static final void _init_$lambda$0(DeviceNOnOffButtonHolder deviceNOnOffButtonHolder, View view) {
        deviceNOnOffButtonHolder.onStandBySetListener.invoke();
    }

    public void update(Device device2) {
        Intrinsics.checkNotNullParameter(device2, "device");
        if (device2 instanceof HasStandBy) {
            update(((HasStandBy) device2).isStandByOn());
        }
    }

    public final void update(boolean z) {
        if (z) {
            HolderDeviceNOnOffButtonBinding holderDeviceNOnOffButtonBinding = this.binding;
            holderDeviceNOnOffButtonBinding.modeRoot.modeIcon.setImageResource(ModeIcon.STANDBY.getOnIcon());
            holderDeviceNOnOffButtonBinding.modeRoot.modeText.setText(R.string.turn_on);
            TextView textView = holderDeviceNOnOffButtonBinding.offHint;
            Intrinsics.checkNotNullExpressionValue(textView, "offHint");
            io.flatcircle.viewhelper.ViewExtensionsKt.show(textView, true);
            return;
        }
        HolderDeviceNOnOffButtonBinding holderDeviceNOnOffButtonBinding2 = this.binding;
        holderDeviceNOnOffButtonBinding2.modeRoot.modeIcon.setImageResource(ModeIcon.STANDBY.getOffIcon());
        holderDeviceNOnOffButtonBinding2.modeRoot.modeText.setText(R.string.on);
        TextView textView2 = holderDeviceNOnOffButtonBinding2.offHint;
        Intrinsics.checkNotNullExpressionValue(textView2, "offHint");
        io.flatcircle.viewhelper.ViewExtensionsKt.show(textView2, false);
    }
}
