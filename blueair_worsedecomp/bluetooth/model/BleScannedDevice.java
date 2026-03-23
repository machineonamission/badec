package com.blueair.bluetooth.model;

import android.bluetooth.BluetoothDevice;
import com.blueair.adddevice.model.AddDeviceState$$ExternalSyntheticBackport0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/blueair/bluetooth/model/BleScannedDevice;", "", "device", "Landroid/bluetooth/BluetoothDevice;", "serviceUuid", "", "connectable", "", "<init>", "(Landroid/bluetooth/BluetoothDevice;Ljava/lang/String;Z)V", "getDevice", "()Landroid/bluetooth/BluetoothDevice;", "getServiceUuid", "()Ljava/lang/String;", "getConnectable", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "bluetooth_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: BleScannedDevice.kt */
public final class BleScannedDevice {
    private final boolean connectable;
    private final BluetoothDevice device;
    private final String serviceUuid;

    public static /* synthetic */ BleScannedDevice copy$default(BleScannedDevice bleScannedDevice, BluetoothDevice bluetoothDevice, String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            bluetoothDevice = bleScannedDevice.device;
        }
        if ((i & 2) != 0) {
            str = bleScannedDevice.serviceUuid;
        }
        if ((i & 4) != 0) {
            z = bleScannedDevice.connectable;
        }
        return bleScannedDevice.copy(bluetoothDevice, str, z);
    }

    public final BluetoothDevice component1() {
        return this.device;
    }

    public final String component2() {
        return this.serviceUuid;
    }

    public final boolean component3() {
        return this.connectable;
    }

    public final BleScannedDevice copy(BluetoothDevice bluetoothDevice, String str, boolean z) {
        Intrinsics.checkNotNullParameter(bluetoothDevice, "device");
        Intrinsics.checkNotNullParameter(str, "serviceUuid");
        return new BleScannedDevice(bluetoothDevice, str, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleScannedDevice)) {
            return false;
        }
        BleScannedDevice bleScannedDevice = (BleScannedDevice) obj;
        return Intrinsics.areEqual((Object) this.device, (Object) bleScannedDevice.device) && Intrinsics.areEqual((Object) this.serviceUuid, (Object) bleScannedDevice.serviceUuid) && this.connectable == bleScannedDevice.connectable;
    }

    public int hashCode() {
        return (((this.device.hashCode() * 31) + this.serviceUuid.hashCode()) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.connectable);
    }

    public String toString() {
        return "BleScannedDevice(device=" + this.device + ", serviceUuid=" + this.serviceUuid + ", connectable=" + this.connectable + ')';
    }

    public BleScannedDevice(BluetoothDevice bluetoothDevice, String str, boolean z) {
        Intrinsics.checkNotNullParameter(bluetoothDevice, "device");
        Intrinsics.checkNotNullParameter(str, "serviceUuid");
        this.device = bluetoothDevice;
        this.serviceUuid = str;
        this.connectable = z;
    }

    public final boolean getConnectable() {
        return this.connectable;
    }

    public final BluetoothDevice getDevice() {
        return this.device;
    }

    public final String getServiceUuid() {
        return this.serviceUuid;
    }
}
