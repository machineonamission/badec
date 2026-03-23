package com.blueair.database;

import com.blueair.core.model.DeviceUuid;
import com.blueair.core.model.Ipv4;
import com.blueair.core.model.Ipv6;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0010\u001a\u00020\u0011J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003JC\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001f"}, d2 = {"Lcom/blueair/database/DeviceUuidEntity;", "", "uuid", "", "ssid", "bssid", "ipv4", "ipv6", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getUuid", "()Ljava/lang/String;", "getSsid", "getBssid", "getIpv4", "getIpv6", "toDeviceUuid", "Lcom/blueair/core/model/DeviceUuid;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceUuidEntity.kt */
public final class DeviceUuidEntity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final String bssid;
    private final String ipv4;
    private final String ipv6;
    private final String ssid;
    private final String uuid;

    public static /* synthetic */ DeviceUuidEntity copy$default(DeviceUuidEntity deviceUuidEntity, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = deviceUuidEntity.uuid;
        }
        if ((i & 2) != 0) {
            str2 = deviceUuidEntity.ssid;
        }
        if ((i & 4) != 0) {
            str3 = deviceUuidEntity.bssid;
        }
        if ((i & 8) != 0) {
            str4 = deviceUuidEntity.ipv4;
        }
        if ((i & 16) != 0) {
            str5 = deviceUuidEntity.ipv6;
        }
        String str6 = str4;
        String str7 = str5;
        return deviceUuidEntity.copy(str, str2, str3, str6, str7);
    }

    public final String component1() {
        return this.uuid;
    }

    public final String component2() {
        return this.ssid;
    }

    public final String component3() {
        return this.bssid;
    }

    public final String component4() {
        return this.ipv4;
    }

    public final String component5() {
        return this.ipv6;
    }

    public final DeviceUuidEntity copy(String str, String str2, String str3, String str4, String str5) {
        Intrinsics.checkNotNullParameter(str, "uuid");
        return new DeviceUuidEntity(str, str2, str3, str4, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceUuidEntity)) {
            return false;
        }
        DeviceUuidEntity deviceUuidEntity = (DeviceUuidEntity) obj;
        return Intrinsics.areEqual((Object) this.uuid, (Object) deviceUuidEntity.uuid) && Intrinsics.areEqual((Object) this.ssid, (Object) deviceUuidEntity.ssid) && Intrinsics.areEqual((Object) this.bssid, (Object) deviceUuidEntity.bssid) && Intrinsics.areEqual((Object) this.ipv4, (Object) deviceUuidEntity.ipv4) && Intrinsics.areEqual((Object) this.ipv6, (Object) deviceUuidEntity.ipv6);
    }

    public int hashCode() {
        int hashCode = this.uuid.hashCode() * 31;
        String str = this.ssid;
        int i = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.bssid;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.ipv4;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.ipv6;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return hashCode4 + i;
    }

    public String toString() {
        return "DeviceUuidEntity(uuid=" + this.uuid + ", ssid=" + this.ssid + ", bssid=" + this.bssid + ", ipv4=" + this.ipv4 + ", ipv6=" + this.ipv6 + ')';
    }

    public DeviceUuidEntity(String str, String str2, String str3, String str4, String str5) {
        Intrinsics.checkNotNullParameter(str, "uuid");
        this.uuid = str;
        this.ssid = str2;
        this.bssid = str3;
        this.ipv4 = str4;
        this.ipv6 = str5;
    }

    public final String getUuid() {
        return this.uuid;
    }

    public final String getSsid() {
        return this.ssid;
    }

    public final String getBssid() {
        return this.bssid;
    }

    public final String getIpv4() {
        return this.ipv4;
    }

    public final String getIpv6() {
        return this.ipv6;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/blueair/database/DeviceUuidEntity$Companion;", "", "<init>", "()V", "from", "Lcom/blueair/database/DeviceUuidEntity;", "uid", "Lcom/blueair/core/model/DeviceUuid;", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceUuidEntity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DeviceUuidEntity from(DeviceUuid deviceUuid) {
            Intrinsics.checkNotNullParameter(deviceUuid, "uid");
            String uuid = deviceUuid.getUuid();
            String ssid = deviceUuid.getSsid();
            String bssid = deviceUuid.getBssid();
            Ipv4 ipv4 = deviceUuid.getIpv4();
            String str = null;
            String ip = ipv4 != null ? ipv4.getIp() : null;
            Ipv6 ipv6 = deviceUuid.getIpv6();
            if (ipv6 != null) {
                str = ipv6.getIpv6();
            }
            return new DeviceUuidEntity(uuid, ssid, bssid, ip, str);
        }
    }

    public final DeviceUuid toDeviceUuid() {
        return new DeviceUuid(this.uuid, this.ssid, this.bssid, new Ipv4(this.ipv4, (String) null, (List) null, 6, (DefaultConstructorMarker) null), new Ipv6(this.ipv6, (String) null, (List) null, 6, (DefaultConstructorMarker) null));
    }
}
