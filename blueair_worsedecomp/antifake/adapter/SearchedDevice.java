package com.blueair.antifake.adapter;

import com.blueair.core.model.BluetoothDevice;
import com.blueair.core.model.ConnectivityStatus;
import com.blueair.core.model.Device;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\r2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0013HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\f\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0010\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0012\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001e"}, d2 = {"Lcom/blueair/antifake/adapter/SearchedDevice;", "", "device", "Lcom/blueair/core/model/Device;", "bluetoothDevice", "Lcom/blueair/core/model/BluetoothDevice;", "<init>", "(Lcom/blueair/core/model/Device;Lcom/blueair/core/model/BluetoothDevice;)V", "getDevice", "()Lcom/blueair/core/model/Device;", "getBluetoothDevice", "()Lcom/blueair/core/model/BluetoothDevice;", "isOnboarded", "", "()Z", "isOnline", "bluetoothAvailable", "getBluetoothAvailable", "wifiMac", "", "getWifiMac", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "antifake_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: SearchedDeviceAdapter.kt */
public final class SearchedDevice {
    private final BluetoothDevice bluetoothDevice;
    private final Device device;

    public SearchedDevice() {
        this((Device) null, (BluetoothDevice) null, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ SearchedDevice copy$default(SearchedDevice searchedDevice, Device device2, BluetoothDevice bluetoothDevice2, int i, Object obj) {
        if ((i & 1) != 0) {
            device2 = searchedDevice.device;
        }
        if ((i & 2) != 0) {
            bluetoothDevice2 = searchedDevice.bluetoothDevice;
        }
        return searchedDevice.copy(device2, bluetoothDevice2);
    }

    public final Device component1() {
        return this.device;
    }

    public final BluetoothDevice component2() {
        return this.bluetoothDevice;
    }

    public final SearchedDevice copy(Device device2, BluetoothDevice bluetoothDevice2) {
        return new SearchedDevice(device2, bluetoothDevice2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SearchedDevice)) {
            return false;
        }
        SearchedDevice searchedDevice = (SearchedDevice) obj;
        return Intrinsics.areEqual((Object) this.device, (Object) searchedDevice.device) && Intrinsics.areEqual((Object) this.bluetoothDevice, (Object) searchedDevice.bluetoothDevice);
    }

    public int hashCode() {
        Device device2 = this.device;
        int i = 0;
        int hashCode = (device2 == null ? 0 : device2.hashCode()) * 31;
        BluetoothDevice bluetoothDevice2 = this.bluetoothDevice;
        if (bluetoothDevice2 != null) {
            i = bluetoothDevice2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "SearchedDevice(device=" + this.device + ", bluetoothDevice=" + this.bluetoothDevice + ')';
    }

    public SearchedDevice(Device device2, BluetoothDevice bluetoothDevice2) {
        this.device = device2;
        this.bluetoothDevice = bluetoothDevice2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SearchedDevice(Device device2, BluetoothDevice bluetoothDevice2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : device2, (i & 2) != 0 ? null : bluetoothDevice2);
    }

    public final Device getDevice() {
        return this.device;
    }

    public final BluetoothDevice getBluetoothDevice() {
        return this.bluetoothDevice;
    }

    public final boolean isOnboarded() {
        return this.device != null;
    }

    public final boolean isOnline() {
        Device device2 = this.device;
        return (device2 != null ? device2.getConnectivityStatus() : null) == ConnectivityStatus.ONLINE;
    }

    public final boolean getBluetoothAvailable() {
        return this.bluetoothDevice != null;
    }

    public final String getWifiMac() {
        String wifiMac;
        String mac;
        Device device2 = this.device;
        if (device2 != null && (mac = device2.getMac()) != null) {
            return mac;
        }
        BluetoothDevice bluetoothDevice2 = this.bluetoothDevice;
        if (bluetoothDevice2 == null || (wifiMac = bluetoothDevice2.getWifiMac()) == null) {
            return "";
        }
        String lowerCase = wifiMac.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }
}
