package com.blueair.database.entity;

import com.blueair.adddevice.model.AddDeviceState$$ExternalSyntheticBackport0;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b#\b\b\u0018\u0000 -2\u00020\u0001:\u0001-BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0007HÆ\u0003J\t\u0010%\u001a\u00020\tHÆ\u0003J\t\u0010&\u001a\u00020\u000bHÆ\u0003J\t\u0010'\u001a\u00020\u000bHÆ\u0003JO\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000bHÆ\u0001J\u0013\u0010)\u001a\u00020\t2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020\u0007HÖ\u0001J\t\u0010,\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\f\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001c\"\u0004\b \u0010\u001e¨\u0006."}, d2 = {"Lcom/blueair/database/entity/NotificationEntity;", "", "deviceId", "", "type", "subType", "subLevel", "", "dismissed", "", "dismissTime", "", "datetime", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZJJ)V", "getDeviceId", "()Ljava/lang/String;", "getType", "getSubType", "getSubLevel", "()I", "setSubLevel", "(I)V", "getDismissed", "()Z", "setDismissed", "(Z)V", "getDismissTime", "()J", "setDismissTime", "(J)V", "getDatetime", "setDatetime", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "Companion", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: NotificationEntity.kt */
public final class NotificationEntity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String NOTIFICATION_TABLE = "notification_table";
    private long datetime;
    private final String deviceId;
    private long dismissTime;
    private boolean dismissed;
    private int subLevel;
    private final String subType;
    private final String type;

    public static /* synthetic */ NotificationEntity copy$default(NotificationEntity notificationEntity, String str, String str2, String str3, int i, boolean z, long j, long j2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = notificationEntity.deviceId;
        }
        if ((i2 & 2) != 0) {
            str2 = notificationEntity.type;
        }
        if ((i2 & 4) != 0) {
            str3 = notificationEntity.subType;
        }
        if ((i2 & 8) != 0) {
            i = notificationEntity.subLevel;
        }
        if ((i2 & 16) != 0) {
            z = notificationEntity.dismissed;
        }
        if ((i2 & 32) != 0) {
            j = notificationEntity.dismissTime;
        }
        if ((i2 & 64) != 0) {
            j2 = notificationEntity.datetime;
        }
        long j3 = j2;
        long j4 = j;
        int i3 = i;
        boolean z2 = z;
        return notificationEntity.copy(str, str2, str3, i3, z2, j4, j3);
    }

    public final String component1() {
        return this.deviceId;
    }

    public final String component2() {
        return this.type;
    }

    public final String component3() {
        return this.subType;
    }

    public final int component4() {
        return this.subLevel;
    }

    public final boolean component5() {
        return this.dismissed;
    }

    public final long component6() {
        return this.dismissTime;
    }

    public final long component7() {
        return this.datetime;
    }

    public final NotificationEntity copy(String str, String str2, String str3, int i, boolean z, long j, long j2) {
        Intrinsics.checkNotNullParameter(str, DeviceDataEntity.DEVICE_ID);
        Intrinsics.checkNotNullParameter(str2, "type");
        Intrinsics.checkNotNullParameter(str3, "subType");
        return new NotificationEntity(str, str2, str3, i, z, j, j2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NotificationEntity)) {
            return false;
        }
        NotificationEntity notificationEntity = (NotificationEntity) obj;
        return Intrinsics.areEqual((Object) this.deviceId, (Object) notificationEntity.deviceId) && Intrinsics.areEqual((Object) this.type, (Object) notificationEntity.type) && Intrinsics.areEqual((Object) this.subType, (Object) notificationEntity.subType) && this.subLevel == notificationEntity.subLevel && this.dismissed == notificationEntity.dismissed && this.dismissTime == notificationEntity.dismissTime && this.datetime == notificationEntity.datetime;
    }

    public int hashCode() {
        return (((((((((((this.deviceId.hashCode() * 31) + this.type.hashCode()) * 31) + this.subType.hashCode()) * 31) + this.subLevel) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.dismissed)) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.dismissTime)) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.datetime);
    }

    public String toString() {
        return "NotificationEntity(deviceId=" + this.deviceId + ", type=" + this.type + ", subType=" + this.subType + ", subLevel=" + this.subLevel + ", dismissed=" + this.dismissed + ", dismissTime=" + this.dismissTime + ", datetime=" + this.datetime + ')';
    }

    public NotificationEntity(String str, String str2, String str3, int i, boolean z, long j, long j2) {
        Intrinsics.checkNotNullParameter(str, DeviceDataEntity.DEVICE_ID);
        Intrinsics.checkNotNullParameter(str2, "type");
        Intrinsics.checkNotNullParameter(str3, "subType");
        this.deviceId = str;
        this.type = str2;
        this.subType = str3;
        this.subLevel = i;
        this.dismissed = z;
        this.dismissTime = j;
        this.datetime = j2;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final String getType() {
        return this.type;
    }

    public final String getSubType() {
        return this.subType;
    }

    public final int getSubLevel() {
        return this.subLevel;
    }

    public final void setSubLevel(int i) {
        this.subLevel = i;
    }

    public final boolean getDismissed() {
        return this.dismissed;
    }

    public final void setDismissed(boolean z) {
        this.dismissed = z;
    }

    public final long getDismissTime() {
        return this.dismissTime;
    }

    public final void setDismissTime(long j) {
        this.dismissTime = j;
    }

    public /* synthetic */ NotificationEntity(String str, String str2, String str3, int i, boolean z, long j, long j2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        long j3;
        int i3;
        String str4;
        String str5;
        String str6;
        NotificationEntity notificationEntity;
        boolean z2 = (i2 & 16) != 0 ? false : z;
        long j4 = (i2 & 32) != 0 ? 0 : j;
        if ((i2 & 64) != 0) {
            j3 = System.currentTimeMillis();
            str6 = str;
            str5 = str2;
            str4 = str3;
            i3 = i;
            notificationEntity = this;
        } else {
            j3 = j2;
            notificationEntity = this;
            str6 = str;
            str5 = str2;
            str4 = str3;
            i3 = i;
        }
        new NotificationEntity(str6, str5, str4, i3, z2, j4, j3);
    }

    public final long getDatetime() {
        return this.datetime;
    }

    public final void setDatetime(long j) {
        this.datetime = j;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/blueair/database/entity/NotificationEntity$Companion;", "", "<init>", "()V", "NOTIFICATION_TABLE", "", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: NotificationEntity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
