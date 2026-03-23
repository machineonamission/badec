package com.blueair.devicedetails.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.blueair.core.model.Device;
import com.blueair.core.model.HasSensorData;
import com.blueair.core.model.HasWeight;
import com.blueair.core.model.IndoorDatapoint;
import com.blueair.devicedetails.databinding.HolderDeviceWeightBinding;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001a\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceWeightHolder;", "Lcom/blueair/devicedetails/viewholder/DeviceAttributeHolder;", "binding", "Lcom/blueair/devicedetails/databinding/HolderDeviceWeightBinding;", "device", "Lcom/blueair/core/model/Device;", "onTareListener", "Lkotlin/Function0;", "", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceWeightBinding;Lcom/blueair/core/model/Device;Lkotlin/jvm/functions/Function0;)V", "getBinding", "()Lcom/blueair/devicedetails/databinding/HolderDeviceWeightBinding;", "getDevice", "()Lcom/blueair/core/model/Device;", "unitG", "", "update", "datapoint", "Lcom/blueair/core/model/IndoorDatapoint;", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceWeightHolder.kt */
public final class DeviceWeightHolder extends DeviceAttributeHolder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final HolderDeviceWeightBinding binding;
    private final Device device;
    private final Function0<Unit> onTareListener;
    private final String unitG;

    public final HolderDeviceWeightBinding getBinding() {
        return this.binding;
    }

    public final Device getDevice() {
        return this.device;
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¨\u0006\r"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceWeightHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceWeightHolder;", "parentView", "Landroid/view/ViewGroup;", "device", "Lcom/blueair/core/model/Device;", "onTareListener", "Lkotlin/Function0;", "", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceWeightHolder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DeviceWeightHolder newInstance(ViewGroup viewGroup, Device device, Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(viewGroup, "parentView");
            Intrinsics.checkNotNullParameter(function0, "onTareListener");
            HolderDeviceWeightBinding inflate = HolderDeviceWeightBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            return new DeviceWeightHolder(inflate, device, function0);
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DeviceWeightHolder(com.blueair.devicedetails.databinding.HolderDeviceWeightBinding r3, com.blueair.core.model.Device r4, kotlin.jvm.functions.Function0<kotlin.Unit> r5) {
        /*
            r2 = this;
            java.lang.String r0 = "binding"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "onTareListener"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            android.widget.FrameLayout r0 = r3.getRoot()
            java.lang.String r1 = "getRoot(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            android.view.View r0 = (android.view.View) r0
            r2.<init>(r0)
            r2.binding = r3
            r2.device = r4
            r2.onTareListener = r5
            android.view.View r4 = r2.itemView
            android.content.Context r4 = r4.getContext()
            int r5 = com.blueair.viewcore.R.string.unit_g
            java.lang.String r4 = r4.getString(r5)
            java.lang.String r5 = "getString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            r2.unitG = r4
            android.widget.TextView r5 = r3.weightValue
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "--"
            r0.<init>(r1)
            r0.append(r4)
            java.lang.String r4 = r0.toString()
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r5.setText(r4)
            com.google.android.material.button.MaterialButton r3 = r3.tareBtn
            com.blueair.devicedetails.viewholder.DeviceWeightHolder$$ExternalSyntheticLambda0 r4 = new com.blueair.devicedetails.viewholder.DeviceWeightHolder$$ExternalSyntheticLambda0
            r4.<init>(r2)
            r3.setOnClickListener(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.viewholder.DeviceWeightHolder.<init>(com.blueair.devicedetails.databinding.HolderDeviceWeightBinding, com.blueair.core.model.Device, kotlin.jvm.functions.Function0):void");
    }

    /* access modifiers changed from: private */
    public static final void _init_$lambda$0(DeviceWeightHolder deviceWeightHolder, View view) {
        deviceWeightHolder.onTareListener.invoke();
    }

    public void update(Device device2) {
        Intrinsics.checkNotNullParameter(device2, "device");
        if (device2 instanceof HasWeight) {
            IndoorDatapoint indoorDatapoint = null;
            HasSensorData hasSensorData = device2 instanceof HasSensorData ? (HasSensorData) device2 : null;
            if (hasSensorData != null) {
                indoorDatapoint = hasSensorData.getLatestSensorDatapoint();
            }
            update(device2, indoorDatapoint);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000b, code lost:
        r2 = r3.getWeight();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void update(com.blueair.core.model.Device r2, com.blueair.core.model.IndoorDatapoint r3) {
        /*
            r1 = this;
            java.lang.String r0 = "device"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            boolean r2 = r2 instanceof com.blueair.core.model.HasWeight
            if (r2 == 0) goto L_0x0043
            if (r3 == 0) goto L_0x001e
            java.lang.Float r2 = r3.getWeight()
            if (r2 == 0) goto L_0x001e
            float r2 = r2.floatValue()
            int r2 = kotlin.math.MathKt.roundToInt((float) r2)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x001f
        L_0x001e:
            r2 = 0
        L_0x001f:
            com.blueair.devicedetails.databinding.HolderDeviceWeightBinding r3 = r1.binding
            android.widget.TextView r3 = r3.weightValue
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            if (r2 == 0) goto L_0x0030
            java.lang.String r2 = r2.toString()
            if (r2 != 0) goto L_0x0032
        L_0x0030:
            java.lang.String r2 = "--"
        L_0x0032:
            r0.append(r2)
            java.lang.String r2 = r1.unitG
            r0.append(r2)
            java.lang.String r2 = r0.toString()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r3.setText(r2)
        L_0x0043:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.viewholder.DeviceWeightHolder.update(com.blueair.core.model.Device, com.blueair.core.model.IndoorDatapoint):void");
    }
}
