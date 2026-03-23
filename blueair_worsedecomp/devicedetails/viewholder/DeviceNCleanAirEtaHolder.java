package com.blueair.devicedetails.viewholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.blueair.core.model.Device;
import com.blueair.core.model.HasFanSpeed;
import com.blueair.core.model.HasSensorData;
import com.blueair.core.model.IndoorDatapoint;
import com.blueair.devicedetails.databinding.HolderDeviceNCleanAirEtaBinding;
import com.blueair.devicedetails.util.EtaUtils;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceNCleanAirEtaHolder;", "Lcom/blueair/devicedetails/viewholder/DeviceAttributeHolder;", "binding", "Lcom/blueair/devicedetails/databinding/HolderDeviceNCleanAirEtaBinding;", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceNCleanAirEtaBinding;)V", "getBinding", "()Lcom/blueair/devicedetails/databinding/HolderDeviceNCleanAirEtaBinding;", "update", "", "device", "Lcom/blueair/core/model/Device;", "dataPoint", "Lcom/blueair/core/model/IndoorDatapoint;", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceNCleanAirEtaHolder.kt */
public final class DeviceNCleanAirEtaHolder extends DeviceAttributeHolder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final HolderDeviceNCleanAirEtaBinding binding;

    public void update(Device device) {
        Intrinsics.checkNotNullParameter(device, "device");
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceNCleanAirEtaHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceNCleanAirEtaHolder;", "parentView", "Landroid/view/ViewGroup;", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceNCleanAirEtaHolder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DeviceNCleanAirEtaHolder newInstance(ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(viewGroup, "parentView");
            HolderDeviceNCleanAirEtaBinding inflate = HolderDeviceNCleanAirEtaBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            return new DeviceNCleanAirEtaHolder(inflate);
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DeviceNCleanAirEtaHolder(com.blueair.devicedetails.databinding.HolderDeviceNCleanAirEtaBinding r3) {
        /*
            r2 = this;
            java.lang.String r0 = "binding"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            android.view.View r0 = r3.getRoot()
            java.lang.String r1 = "getRoot(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r2.<init>(r0)
            r2.binding = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.viewholder.DeviceNCleanAirEtaHolder.<init>(com.blueair.devicedetails.databinding.HolderDeviceNCleanAirEtaBinding):void");
    }

    public final HolderDeviceNCleanAirEtaBinding getBinding() {
        return this.binding;
    }

    public final void update(Device device, IndoorDatapoint indoorDatapoint) {
        IndoorDatapoint indoorDatapoint2;
        Intrinsics.checkNotNullParameter(device, "device");
        Float f = null;
        HasFanSpeed hasFanSpeed = device instanceof HasFanSpeed ? (HasFanSpeed) device : null;
        if (indoorDatapoint == null) {
            HasSensorData hasSensorData = hasFanSpeed instanceof HasSensorData ? (HasSensorData) hasFanSpeed : null;
            indoorDatapoint2 = hasSensorData != null ? hasSensorData.getLatestSensorDatapoint() : null;
        } else {
            indoorDatapoint2 = indoorDatapoint;
        }
        if (hasFanSpeed != null) {
            if ((indoorDatapoint2 != null ? indoorDatapoint2.getPm25() : null) != null) {
                TextView textView = this.binding.cleanAirEta;
                EtaUtils etaUtils = EtaUtils.INSTANCE;
                Context context = this.itemView.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                int fanSpeed = ((HasFanSpeed) device).getFanSpeed();
                if (indoorDatapoint != null) {
                    f = indoorDatapoint.getPm25();
                }
                textView.setText(etaUtils.etaString(context, fanSpeed, f));
                return;
            }
        }
        TextView textView2 = this.binding.cleanAirEta;
        Intrinsics.checkNotNullExpressionValue(textView2, "cleanAirEta");
        ViewExtensionsKt.show(textView2, false);
    }
}
