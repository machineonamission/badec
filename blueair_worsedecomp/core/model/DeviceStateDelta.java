package com.blueair.core.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/blueair/core/model/DeviceStateDelta;", "", "desired", "Lcom/blueair/core/model/DeviceState;", "reported", "<init>", "(Lcom/blueair/core/model/DeviceState;Lcom/blueair/core/model/DeviceState;)V", "getDesired", "()Lcom/blueair/core/model/DeviceState;", "getReported", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceStateBundle.kt */
public final class DeviceStateDelta {
    private final DeviceState desired;
    private final DeviceState reported;

    public DeviceStateDelta() {
        this((DeviceState) null, (DeviceState) null, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ DeviceStateDelta copy$default(DeviceStateDelta deviceStateDelta, DeviceState deviceState, DeviceState deviceState2, int i, Object obj) {
        if ((i & 1) != 0) {
            deviceState = deviceStateDelta.desired;
        }
        if ((i & 2) != 0) {
            deviceState2 = deviceStateDelta.reported;
        }
        return deviceStateDelta.copy(deviceState, deviceState2);
    }

    public final DeviceState component1() {
        return this.desired;
    }

    public final DeviceState component2() {
        return this.reported;
    }

    public final DeviceStateDelta copy(DeviceState deviceState, DeviceState deviceState2) {
        Intrinsics.checkNotNullParameter(deviceState, "desired");
        Intrinsics.checkNotNullParameter(deviceState2, "reported");
        return new DeviceStateDelta(deviceState, deviceState2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceStateDelta)) {
            return false;
        }
        DeviceStateDelta deviceStateDelta = (DeviceStateDelta) obj;
        return Intrinsics.areEqual((Object) this.desired, (Object) deviceStateDelta.desired) && Intrinsics.areEqual((Object) this.reported, (Object) deviceStateDelta.reported);
    }

    public int hashCode() {
        return (this.desired.hashCode() * 31) + this.reported.hashCode();
    }

    public String toString() {
        return "DeviceStateDelta(desired=" + this.desired + ", reported=" + this.reported + ')';
    }

    public DeviceStateDelta(DeviceState deviceState, DeviceState deviceState2) {
        Intrinsics.checkNotNullParameter(deviceState, "desired");
        Intrinsics.checkNotNullParameter(deviceState2, "reported");
        this.desired = deviceState;
        this.reported = deviceState2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DeviceStateDelta(DeviceState deviceState, DeviceState deviceState2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new DeviceState((String) null, (Boolean) null, (Boolean) null, (Boolean) null, (Boolean) null, (Boolean) null, (Boolean) null, (Integer) null, (Boolean) null, (Boolean) null, (String) null, (Boolean) null, (String) null, (Integer) null, (Boolean) null, (Integer) null, (Boolean) null, (Integer) null, (Boolean) null, (Boolean) null, (Integer) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Boolean) null, (Boolean) null, (Integer) null, (Integer) null, (Boolean) null, (Boolean) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Boolean) null, (Boolean) null, (Integer) null, (Integer) null, (Object) null, (Object) null, (Object) null, (Object) null, (Object) null, (Object) null, (Integer) null, (Boolean) null, (Boolean) null, (Boolean) null, (Integer) null, -1, -1, 2097151, (DefaultConstructorMarker) null) : deviceState, (i & 2) != 0 ? new DeviceState((String) null, (Boolean) null, (Boolean) null, (Boolean) null, (Boolean) null, (Boolean) null, (Boolean) null, (Integer) null, (Boolean) null, (Boolean) null, (String) null, (Boolean) null, (String) null, (Integer) null, (Boolean) null, (Integer) null, (Boolean) null, (Integer) null, (Boolean) null, (Boolean) null, (Integer) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Boolean) null, (Boolean) null, (Integer) null, (Integer) null, (Boolean) null, (Boolean) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Boolean) null, (Boolean) null, (Integer) null, (Integer) null, (Object) null, (Object) null, (Object) null, (Object) null, (Object) null, (Object) null, (Integer) null, (Boolean) null, (Boolean) null, (Boolean) null, (Integer) null, -1, -1, 2097151, (DefaultConstructorMarker) null) : deviceState2);
    }

    public final DeviceState getDesired() {
        return this.desired;
    }

    public final DeviceState getReported() {
        return this.reported;
    }
}
