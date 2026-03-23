package com.blueair.devicemanager;

import com.blueair.core.model.Device;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\b\tB\u0011\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0001\u0002\n\u000b¨\u0006\f"}, d2 = {"Lcom/blueair/devicemanager/DeviceInternalEvent;", "", "device", "Lcom/blueair/core/model/Device;", "<init>", "(Lcom/blueair/core/model/Device;)V", "getDevice", "()Lcom/blueair/core/model/Device;", "OtaStartEvent", "OtaEndEvent", "Lcom/blueair/devicemanager/DeviceInternalEvent$OtaEndEvent;", "Lcom/blueair/devicemanager/DeviceInternalEvent$OtaStartEvent;", "devicemanager_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceInternalEvent.kt */
public abstract class DeviceInternalEvent {
    private final Device device;

    public /* synthetic */ DeviceInternalEvent(Device device2, DefaultConstructorMarker defaultConstructorMarker) {
        this(device2);
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/devicemanager/DeviceInternalEvent$OtaStartEvent;", "Lcom/blueair/devicemanager/DeviceInternalEvent;", "nuDevice", "Lcom/blueair/core/model/Device;", "<init>", "(Lcom/blueair/core/model/Device;)V", "devicemanager_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceInternalEvent.kt */
    public static final class OtaStartEvent extends DeviceInternalEvent {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public OtaStartEvent(Device device) {
            super(device, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(device, "nuDevice");
        }
    }

    private DeviceInternalEvent(Device device2) {
        this.device = device2;
    }

    public final Device getDevice() {
        return this.device;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/devicemanager/DeviceInternalEvent$OtaEndEvent;", "Lcom/blueair/devicemanager/DeviceInternalEvent;", "nuDevice", "Lcom/blueair/core/model/Device;", "<init>", "(Lcom/blueair/core/model/Device;)V", "devicemanager_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceInternalEvent.kt */
    public static final class OtaEndEvent extends DeviceInternalEvent {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public OtaEndEvent(Device device) {
            super(device, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(device, "nuDevice");
        }
    }
}
