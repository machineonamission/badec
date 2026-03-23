package com.blueair.devicedetails.adapter;

import com.blueair.core.model.DeviceAware;
import com.blueair.core.model.HasLinkingCapability;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/blueair/devicedetails/adapter/LinkedDeviceSelectionAction;", "", "parentDevice", "Lcom/blueair/core/model/HasLinkingCapability;", "linkedDevice", "Lcom/blueair/core/model/DeviceAware;", "<init>", "(Lcom/blueair/core/model/HasLinkingCapability;Lcom/blueair/core/model/DeviceAware;)V", "getParentDevice", "()Lcom/blueair/core/model/HasLinkingCapability;", "getLinkedDevice", "()Lcom/blueair/core/model/DeviceAware;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: LinkedDevicesAdapter.kt */
public final class LinkedDeviceSelectionAction {
    private final DeviceAware linkedDevice;
    private final HasLinkingCapability parentDevice;

    public static /* synthetic */ LinkedDeviceSelectionAction copy$default(LinkedDeviceSelectionAction linkedDeviceSelectionAction, HasLinkingCapability hasLinkingCapability, DeviceAware deviceAware, int i, Object obj) {
        if ((i & 1) != 0) {
            hasLinkingCapability = linkedDeviceSelectionAction.parentDevice;
        }
        if ((i & 2) != 0) {
            deviceAware = linkedDeviceSelectionAction.linkedDevice;
        }
        return linkedDeviceSelectionAction.copy(hasLinkingCapability, deviceAware);
    }

    public final HasLinkingCapability component1() {
        return this.parentDevice;
    }

    public final DeviceAware component2() {
        return this.linkedDevice;
    }

    public final LinkedDeviceSelectionAction copy(HasLinkingCapability hasLinkingCapability, DeviceAware deviceAware) {
        Intrinsics.checkNotNullParameter(hasLinkingCapability, "parentDevice");
        return new LinkedDeviceSelectionAction(hasLinkingCapability, deviceAware);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LinkedDeviceSelectionAction)) {
            return false;
        }
        LinkedDeviceSelectionAction linkedDeviceSelectionAction = (LinkedDeviceSelectionAction) obj;
        return Intrinsics.areEqual((Object) this.parentDevice, (Object) linkedDeviceSelectionAction.parentDevice) && Intrinsics.areEqual((Object) this.linkedDevice, (Object) linkedDeviceSelectionAction.linkedDevice);
    }

    public int hashCode() {
        int hashCode = this.parentDevice.hashCode() * 31;
        DeviceAware deviceAware = this.linkedDevice;
        return hashCode + (deviceAware == null ? 0 : deviceAware.hashCode());
    }

    public String toString() {
        return "LinkedDeviceSelectionAction(parentDevice=" + this.parentDevice + ", linkedDevice=" + this.linkedDevice + ')';
    }

    public LinkedDeviceSelectionAction(HasLinkingCapability hasLinkingCapability, DeviceAware deviceAware) {
        Intrinsics.checkNotNullParameter(hasLinkingCapability, "parentDevice");
        this.parentDevice = hasLinkingCapability;
        this.linkedDevice = deviceAware;
    }

    public final HasLinkingCapability getParentDevice() {
        return this.parentDevice;
    }

    public final DeviceAware getLinkedDevice() {
        return this.linkedDevice;
    }
}
