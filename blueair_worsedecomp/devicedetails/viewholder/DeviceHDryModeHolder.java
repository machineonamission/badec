package com.blueair.devicedetails.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.blueair.core.model.Device;
import com.blueair.core.model.HasWick;
import com.blueair.devicedetails.databinding.HolderDeviceHDryModeBinding;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.joda.time.DateTimeConstants;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceHDryModeHolder;", "Lcom/blueair/devicedetails/viewholder/DeviceAttributeHolder;", "binding", "Lcom/blueair/devicedetails/databinding/HolderDeviceHDryModeBinding;", "device", "Lcom/blueair/core/model/Device;", "onOpenInfoListener", "Lkotlin/Function0;", "", "onDryModeCancelListener", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceHDryModeBinding;Lcom/blueair/core/model/Device;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "getBinding", "()Lcom/blueair/devicedetails/databinding/HolderDeviceHDryModeBinding;", "getDevice", "()Lcom/blueair/core/model/Device;", "liveDevice", "update", "getDryModeCountdownText", "", "Lcom/blueair/core/model/HasWick;", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceHDryModeHolder.kt */
public final class DeviceHDryModeHolder extends DeviceAttributeHolder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final HolderDeviceHDryModeBinding binding;
    private final Device device;
    private Device liveDevice;
    private final Function0<Unit> onDryModeCancelListener;
    private final Function0<Unit> onOpenInfoListener;

    public final HolderDeviceHDryModeBinding getBinding() {
        return this.binding;
    }

    public final Device getDevice() {
        return this.device;
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J4\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¨\u0006\u000e"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceHDryModeHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceHDryModeHolder;", "parentView", "Landroid/view/ViewGroup;", "device", "Lcom/blueair/core/model/Device;", "onOpenInfoListener", "Lkotlin/Function0;", "", "onDryModeCancelListener", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceHDryModeHolder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DeviceHDryModeHolder newInstance(ViewGroup viewGroup, Device device, Function0<Unit> function0, Function0<Unit> function02) {
            Intrinsics.checkNotNullParameter(viewGroup, "parentView");
            Intrinsics.checkNotNullParameter(function0, "onOpenInfoListener");
            Intrinsics.checkNotNullParameter(function02, "onDryModeCancelListener");
            HolderDeviceHDryModeBinding inflate = HolderDeviceHDryModeBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            return new DeviceHDryModeHolder(inflate, device, function0, function02);
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DeviceHDryModeHolder(com.blueair.devicedetails.databinding.HolderDeviceHDryModeBinding r3, com.blueair.core.model.Device r4, kotlin.jvm.functions.Function0<kotlin.Unit> r5, kotlin.jvm.functions.Function0<kotlin.Unit> r6) {
        /*
            r2 = this;
            java.lang.String r0 = "binding"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "onOpenInfoListener"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "onDryModeCancelListener"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            androidx.constraintlayout.widget.ConstraintLayout r0 = r3.getRoot()
            java.lang.String r1 = "getRoot(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            android.view.View r0 = (android.view.View) r0
            r2.<init>(r0)
            r2.binding = r3
            r2.device = r4
            r2.onOpenInfoListener = r5
            r2.onDryModeCancelListener = r6
            r2.liveDevice = r4
            android.widget.TextView r4 = r3.dryModeTitle
            com.blueair.devicedetails.viewholder.DeviceHDryModeHolder$$ExternalSyntheticLambda0 r5 = new com.blueair.devicedetails.viewholder.DeviceHDryModeHolder$$ExternalSyntheticLambda0
            r5.<init>(r2)
            r4.setOnClickListener(r5)
            android.widget.TextView r3 = r3.cancelDryMode
            com.blueair.devicedetails.viewholder.DeviceHDryModeHolder$$ExternalSyntheticLambda1 r4 = new com.blueair.devicedetails.viewholder.DeviceHDryModeHolder$$ExternalSyntheticLambda1
            r4.<init>(r2)
            r3.setOnClickListener(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.viewholder.DeviceHDryModeHolder.<init>(com.blueair.devicedetails.databinding.HolderDeviceHDryModeBinding, com.blueair.core.model.Device, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0):void");
    }

    /* access modifiers changed from: private */
    public static final void _init_$lambda$0(DeviceHDryModeHolder deviceHDryModeHolder, View view) {
        deviceHDryModeHolder.onOpenInfoListener.invoke();
    }

    /* access modifiers changed from: private */
    public static final void _init_$lambda$1(DeviceHDryModeHolder deviceHDryModeHolder, View view) {
        deviceHDryModeHolder.onDryModeCancelListener.invoke();
    }

    public void update(Device device2) {
        Intrinsics.checkNotNullParameter(device2, "device");
        if (device2 instanceof HasWick) {
            this.liveDevice = device2;
            HasWick hasWick = (HasWick) device2;
            if (hasWick.getWickdryOn()) {
                TextView textView = this.binding.cancelDryMode;
                Intrinsics.checkNotNullExpressionValue(textView, "cancelDryMode");
                ViewExtensionsKt.show$default(textView, false, 1, (Object) null);
                this.binding.countdownNumber.setText(getDryModeCountdownText(hasWick));
                return;
            }
            TextView textView2 = this.binding.cancelDryMode;
            Intrinsics.checkNotNullExpressionValue(textView2, "cancelDryMode");
            ViewExtensionsKt.hide(textView2);
            this.binding.countdownNumber.setText("--:--:--");
        }
    }

    public final String getDryModeCountdownText(HasWick hasWick) {
        Intrinsics.checkNotNullParameter(hasWick, "device");
        int wickDryLeftSeconds = hasWick.getWickDryLeftSeconds();
        int i = wickDryLeftSeconds / DateTimeConstants.SECONDS_PER_HOUR;
        int i2 = wickDryLeftSeconds - (i * DateTimeConstants.SECONDS_PER_HOUR);
        int i3 = i2 / 60;
        String format = String.format("%02d:%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(i), Integer.valueOf(i3), Integer.valueOf(i2 - (i3 * 60))}, 3));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }
}
