package com.blueair.core.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/blueair/core/model/DeviceStateBundleState;", "", "state", "Lcom/blueair/core/model/DeviceStateDelta;", "<init>", "(Lcom/blueair/core/model/DeviceStateDelta;)V", "getState", "()Lcom/blueair/core/model/DeviceStateDelta;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceStateBundle.kt */
public final class DeviceStateBundleState {
    private final DeviceStateDelta state;

    public DeviceStateBundleState() {
        this((DeviceStateDelta) null, 1, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ DeviceStateBundleState copy$default(DeviceStateBundleState deviceStateBundleState, DeviceStateDelta deviceStateDelta, int i, Object obj) {
        if ((i & 1) != 0) {
            deviceStateDelta = deviceStateBundleState.state;
        }
        return deviceStateBundleState.copy(deviceStateDelta);
    }

    public final DeviceStateDelta component1() {
        return this.state;
    }

    public final DeviceStateBundleState copy(DeviceStateDelta deviceStateDelta) {
        Intrinsics.checkNotNullParameter(deviceStateDelta, "state");
        return new DeviceStateBundleState(deviceStateDelta);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof DeviceStateBundleState) && Intrinsics.areEqual((Object) this.state, (Object) ((DeviceStateBundleState) obj).state);
    }

    public int hashCode() {
        return this.state.hashCode();
    }

    public String toString() {
        return "DeviceStateBundleState(state=" + this.state + ')';
    }

    public DeviceStateBundleState(DeviceStateDelta deviceStateDelta) {
        Intrinsics.checkNotNullParameter(deviceStateDelta, "state");
        this.state = deviceStateDelta;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DeviceStateBundleState(DeviceStateDelta deviceStateDelta, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new DeviceStateDelta((DeviceState) null, (DeviceState) null, 3, (DefaultConstructorMarker) null) : deviceStateDelta);
    }

    public final DeviceStateDelta getState() {
        return this.state;
    }
}
