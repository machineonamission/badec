package com.blueair.devicemanager;

import com.blueair.devicemanager.IcpDeviceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/blueair/devicemanager/IcpDeviceConnection;", "", "connectionState", "Lcom/blueair/devicemanager/IcpDeviceManager$IcpDeviceConnectionState;", "device", "Lcom/blueair/devicemanager/IcpDevice;", "<init>", "(Lcom/blueair/devicemanager/IcpDeviceManager$IcpDeviceConnectionState;Lcom/blueair/devicemanager/IcpDevice;)V", "getConnectionState", "()Lcom/blueair/devicemanager/IcpDeviceManager$IcpDeviceConnectionState;", "getDevice", "()Lcom/blueair/devicemanager/IcpDevice;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "devicemanager_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: IcpDeviceManager.kt */
public final class IcpDeviceConnection {
    private final IcpDeviceManager.IcpDeviceConnectionState connectionState;
    private final IcpDevice device;

    public static /* synthetic */ IcpDeviceConnection copy$default(IcpDeviceConnection icpDeviceConnection, IcpDeviceManager.IcpDeviceConnectionState icpDeviceConnectionState, IcpDevice icpDevice, int i, Object obj) {
        if ((i & 1) != 0) {
            icpDeviceConnectionState = icpDeviceConnection.connectionState;
        }
        if ((i & 2) != 0) {
            icpDevice = icpDeviceConnection.device;
        }
        return icpDeviceConnection.copy(icpDeviceConnectionState, icpDevice);
    }

    public final IcpDeviceManager.IcpDeviceConnectionState component1() {
        return this.connectionState;
    }

    public final IcpDevice component2() {
        return this.device;
    }

    public final IcpDeviceConnection copy(IcpDeviceManager.IcpDeviceConnectionState icpDeviceConnectionState, IcpDevice icpDevice) {
        Intrinsics.checkNotNullParameter(icpDeviceConnectionState, "connectionState");
        return new IcpDeviceConnection(icpDeviceConnectionState, icpDevice);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IcpDeviceConnection)) {
            return false;
        }
        IcpDeviceConnection icpDeviceConnection = (IcpDeviceConnection) obj;
        return this.connectionState == icpDeviceConnection.connectionState && Intrinsics.areEqual((Object) this.device, (Object) icpDeviceConnection.device);
    }

    public int hashCode() {
        int hashCode = this.connectionState.hashCode() * 31;
        IcpDevice icpDevice = this.device;
        return hashCode + (icpDevice == null ? 0 : icpDevice.hashCode());
    }

    public String toString() {
        return "IcpDeviceConnection(connectionState=" + this.connectionState + ", device=" + this.device + ')';
    }

    public IcpDeviceConnection(IcpDeviceManager.IcpDeviceConnectionState icpDeviceConnectionState, IcpDevice icpDevice) {
        Intrinsics.checkNotNullParameter(icpDeviceConnectionState, "connectionState");
        this.connectionState = icpDeviceConnectionState;
        this.device = icpDevice;
    }

    public final IcpDeviceManager.IcpDeviceConnectionState getConnectionState() {
        return this.connectionState;
    }

    public final IcpDevice getDevice() {
        return this.device;
    }
}
