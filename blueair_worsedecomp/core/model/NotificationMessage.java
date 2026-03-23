package com.blueair.core.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\t\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0017\u001a\u00020\tH\u0016J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001b\u001a\u00020\tHÆ\u0003J1\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\t\u0010\u001d\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001e"}, d2 = {"Lcom/blueair/core/model/NotificationMessage;", "", "device", "Lcom/blueair/core/model/Device;", "type", "Lcom/blueair/core/model/NotificationMsgType;", "subType", "", "subLevel", "", "<init>", "(Lcom/blueair/core/model/Device;Lcom/blueair/core/model/NotificationMsgType;Ljava/lang/String;I)V", "getDevice", "()Lcom/blueair/core/model/Device;", "getType", "()Lcom/blueair/core/model/NotificationMsgType;", "getSubType", "()Ljava/lang/String;", "getSubLevel", "()I", "equals", "", "other", "hashCode", "component1", "component2", "component3", "component4", "copy", "toString", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: NotificationMessage.kt */
public final class NotificationMessage {
    private final Device device;
    private final int subLevel;
    private final String subType;
    private final NotificationMsgType type;

    public static /* synthetic */ NotificationMessage copy$default(NotificationMessage notificationMessage, Device device2, NotificationMsgType notificationMsgType, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            device2 = notificationMessage.device;
        }
        if ((i2 & 2) != 0) {
            notificationMsgType = notificationMessage.type;
        }
        if ((i2 & 4) != 0) {
            str = notificationMessage.subType;
        }
        if ((i2 & 8) != 0) {
            i = notificationMessage.subLevel;
        }
        return notificationMessage.copy(device2, notificationMsgType, str, i);
    }

    public final Device component1() {
        return this.device;
    }

    public final NotificationMsgType component2() {
        return this.type;
    }

    public final String component3() {
        return this.subType;
    }

    public final int component4() {
        return this.subLevel;
    }

    public final NotificationMessage copy(Device device2, NotificationMsgType notificationMsgType, String str, int i) {
        Intrinsics.checkNotNullParameter(device2, "device");
        Intrinsics.checkNotNullParameter(notificationMsgType, "type");
        Intrinsics.checkNotNullParameter(str, "subType");
        return new NotificationMessage(device2, notificationMsgType, str, i);
    }

    public String toString() {
        return "NotificationMessage(device=" + this.device + ", type=" + this.type + ", subType=" + this.subType + ", subLevel=" + this.subLevel + ')';
    }

    public NotificationMessage(Device device2, NotificationMsgType notificationMsgType, String str, int i) {
        Intrinsics.checkNotNullParameter(device2, "device");
        Intrinsics.checkNotNullParameter(notificationMsgType, "type");
        Intrinsics.checkNotNullParameter(str, "subType");
        this.device = device2;
        this.type = notificationMsgType;
        this.subType = str;
        this.subLevel = i;
    }

    public final Device getDevice() {
        return this.device;
    }

    public final NotificationMsgType getType() {
        return this.type;
    }

    public final String getSubType() {
        return this.subType;
    }

    public final int getSubLevel() {
        return this.subLevel;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NotificationMessage)) {
            return false;
        }
        NotificationMessage notificationMessage = (NotificationMessage) obj;
        if (!Intrinsics.areEqual((Object) this.device.getUid(), (Object) notificationMessage.device.getUid()) || !Intrinsics.areEqual((Object) this.device.getName(), (Object) notificationMessage.device.getName())) {
            return false;
        }
        Device device2 = this.device;
        return (!(device2 instanceof HasSKU) || !(notificationMessage.device instanceof HasSKU) || Intrinsics.areEqual((Object) ((HasSKU) device2).getSku(), (Object) ((HasSKU) notificationMessage.device).getSku())) && this.type == notificationMessage.type && Intrinsics.areEqual((Object) this.subType, (Object) notificationMessage.subType) && this.subLevel == notificationMessage.subLevel;
    }

    public int hashCode() {
        return (((((this.device.getUid().hashCode() * 31) + this.type.hashCode()) * 31) + this.subType.hashCode()) * 31) + this.subLevel;
    }
}
