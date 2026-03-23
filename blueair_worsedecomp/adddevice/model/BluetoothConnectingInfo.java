package com.blueair.adddevice.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/blueair/adddevice/model/BluetoothConnectingInfo;", "", "deviceMac", "", "connectionState", "Lcom/blueair/adddevice/model/BluetoothConnectingState;", "<init>", "(Ljava/lang/String;Lcom/blueair/adddevice/model/BluetoothConnectingState;)V", "getDeviceMac", "()Ljava/lang/String;", "getConnectionState", "()Lcom/blueair/adddevice/model/BluetoothConnectingState;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "adddevice_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: BluetoothConnectingInfo.kt */
public final class BluetoothConnectingInfo {
    private final BluetoothConnectingState connectionState;
    private final String deviceMac;

    public static /* synthetic */ BluetoothConnectingInfo copy$default(BluetoothConnectingInfo bluetoothConnectingInfo, String str, BluetoothConnectingState bluetoothConnectingState, int i, Object obj) {
        if ((i & 1) != 0) {
            str = bluetoothConnectingInfo.deviceMac;
        }
        if ((i & 2) != 0) {
            bluetoothConnectingState = bluetoothConnectingInfo.connectionState;
        }
        return bluetoothConnectingInfo.copy(str, bluetoothConnectingState);
    }

    public final String component1() {
        return this.deviceMac;
    }

    public final BluetoothConnectingState component2() {
        return this.connectionState;
    }

    public final BluetoothConnectingInfo copy(String str, BluetoothConnectingState bluetoothConnectingState) {
        Intrinsics.checkNotNullParameter(str, "deviceMac");
        Intrinsics.checkNotNullParameter(bluetoothConnectingState, "connectionState");
        return new BluetoothConnectingInfo(str, bluetoothConnectingState);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BluetoothConnectingInfo)) {
            return false;
        }
        BluetoothConnectingInfo bluetoothConnectingInfo = (BluetoothConnectingInfo) obj;
        return Intrinsics.areEqual((Object) this.deviceMac, (Object) bluetoothConnectingInfo.deviceMac) && Intrinsics.areEqual((Object) this.connectionState, (Object) bluetoothConnectingInfo.connectionState);
    }

    public int hashCode() {
        return (this.deviceMac.hashCode() * 31) + this.connectionState.hashCode();
    }

    public String toString() {
        return "BluetoothConnectingInfo(deviceMac=" + this.deviceMac + ", connectionState=" + this.connectionState + ')';
    }

    public BluetoothConnectingInfo(String str, BluetoothConnectingState bluetoothConnectingState) {
        Intrinsics.checkNotNullParameter(str, "deviceMac");
        Intrinsics.checkNotNullParameter(bluetoothConnectingState, "connectionState");
        this.deviceMac = str;
        this.connectionState = bluetoothConnectingState;
    }

    public final String getDeviceMac() {
        return this.deviceMac;
    }

    public final BluetoothConnectingState getConnectionState() {
        return this.connectionState;
    }
}
