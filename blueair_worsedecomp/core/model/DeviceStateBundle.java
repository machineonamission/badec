package com.blueair.core.model;

import com.blueair.adddevice.model.AddDeviceState$$ExternalSyntheticBackport0;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/blueair/core/model/DeviceStateBundle;", "", "timestamp", "", "previous", "Lcom/blueair/core/model/DeviceStateBundleState;", "current", "<init>", "(JLcom/blueair/core/model/DeviceStateBundleState;Lcom/blueair/core/model/DeviceStateBundleState;)V", "getTimestamp", "()J", "getPrevious", "()Lcom/blueair/core/model/DeviceStateBundleState;", "getCurrent", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceStateBundle.kt */
public final class DeviceStateBundle {
    private final DeviceStateBundleState current;
    private final DeviceStateBundleState previous;
    private final long timestamp;

    public static /* synthetic */ DeviceStateBundle copy$default(DeviceStateBundle deviceStateBundle, long j, DeviceStateBundleState deviceStateBundleState, DeviceStateBundleState deviceStateBundleState2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = deviceStateBundle.timestamp;
        }
        if ((i & 2) != 0) {
            deviceStateBundleState = deviceStateBundle.previous;
        }
        if ((i & 4) != 0) {
            deviceStateBundleState2 = deviceStateBundle.current;
        }
        return deviceStateBundle.copy(j, deviceStateBundleState, deviceStateBundleState2);
    }

    public final long component1() {
        return this.timestamp;
    }

    public final DeviceStateBundleState component2() {
        return this.previous;
    }

    public final DeviceStateBundleState component3() {
        return this.current;
    }

    public final DeviceStateBundle copy(long j, DeviceStateBundleState deviceStateBundleState, DeviceStateBundleState deviceStateBundleState2) {
        Intrinsics.checkNotNullParameter(deviceStateBundleState, BlueDeviceScheduleEndType.PREVIOUS);
        Intrinsics.checkNotNullParameter(deviceStateBundleState2, "current");
        return new DeviceStateBundle(j, deviceStateBundleState, deviceStateBundleState2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceStateBundle)) {
            return false;
        }
        DeviceStateBundle deviceStateBundle = (DeviceStateBundle) obj;
        return this.timestamp == deviceStateBundle.timestamp && Intrinsics.areEqual((Object) this.previous, (Object) deviceStateBundle.previous) && Intrinsics.areEqual((Object) this.current, (Object) deviceStateBundle.current);
    }

    public int hashCode() {
        return (((AddDeviceState$$ExternalSyntheticBackport0.m(this.timestamp) * 31) + this.previous.hashCode()) * 31) + this.current.hashCode();
    }

    public String toString() {
        return "DeviceStateBundle(timestamp=" + this.timestamp + ", previous=" + this.previous + ", current=" + this.current + ')';
    }

    public DeviceStateBundle(long j, DeviceStateBundleState deviceStateBundleState, DeviceStateBundleState deviceStateBundleState2) {
        Intrinsics.checkNotNullParameter(deviceStateBundleState, BlueDeviceScheduleEndType.PREVIOUS);
        Intrinsics.checkNotNullParameter(deviceStateBundleState2, "current");
        this.timestamp = j;
        this.previous = deviceStateBundleState;
        this.current = deviceStateBundleState2;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DeviceStateBundle(long j, DeviceStateBundleState deviceStateBundleState, DeviceStateBundleState deviceStateBundleState2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, (i & 2) != 0 ? new DeviceStateBundleState((DeviceStateDelta) null, 1, (DefaultConstructorMarker) null) : deviceStateBundleState, (i & 4) != 0 ? new DeviceStateBundleState((DeviceStateDelta) null, 1, (DefaultConstructorMarker) null) : deviceStateBundleState2);
    }

    public final DeviceStateBundleState getPrevious() {
        return this.previous;
    }

    public final DeviceStateBundleState getCurrent() {
        return this.current;
    }
}
