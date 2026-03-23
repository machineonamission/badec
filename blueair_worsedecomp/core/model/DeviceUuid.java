package com.blueair.core.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.Json;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\tHÆ\u0003JC\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0006\u0010\u001a\u001a\u00020\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u001bHÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u001bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006'"}, d2 = {"Lcom/blueair/core/model/DeviceUuid;", "Landroid/os/Parcelable;", "uuid", "", "ssid", "bssid", "ipv4", "Lcom/blueair/core/model/Ipv4;", "ipv6", "Lcom/blueair/core/model/Ipv6;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/blueair/core/model/Ipv4;Lcom/blueair/core/model/Ipv6;)V", "getUuid", "()Ljava/lang/String;", "getSsid", "getBssid", "getIpv4", "()Lcom/blueair/core/model/Ipv4;", "getIpv6", "()Lcom/blueair/core/model/Ipv6;", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Json(name = "uuid")
/* compiled from: DeviceUuid.kt */
public final class DeviceUuid implements Parcelable {
    public static final Parcelable.Creator<DeviceUuid> CREATOR = new Creator();
    private final String bssid;
    private final Ipv4 ipv4;
    private final Ipv6 ipv6;
    private final String ssid;
    private final String uuid;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceUuid.kt */
    public static final class Creator implements Parcelable.Creator<DeviceUuid> {
        public final DeviceUuid createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            Ipv6 ipv6 = null;
            Ipv4 createFromParcel = parcel.readInt() == 0 ? null : Ipv4.CREATOR.createFromParcel(parcel);
            if (parcel.readInt() != 0) {
                ipv6 = Ipv6.CREATOR.createFromParcel(parcel);
            }
            return new DeviceUuid(readString, readString2, readString3, createFromParcel, ipv6);
        }

        public final DeviceUuid[] newArray(int i) {
            return new DeviceUuid[i];
        }
    }

    public static /* synthetic */ DeviceUuid copy$default(DeviceUuid deviceUuid, String str, String str2, String str3, Ipv4 ipv42, Ipv6 ipv62, int i, Object obj) {
        if ((i & 1) != 0) {
            str = deviceUuid.uuid;
        }
        if ((i & 2) != 0) {
            str2 = deviceUuid.ssid;
        }
        if ((i & 4) != 0) {
            str3 = deviceUuid.bssid;
        }
        if ((i & 8) != 0) {
            ipv42 = deviceUuid.ipv4;
        }
        if ((i & 16) != 0) {
            ipv62 = deviceUuid.ipv6;
        }
        Ipv4 ipv43 = ipv42;
        Ipv6 ipv63 = ipv62;
        return deviceUuid.copy(str, str2, str3, ipv43, ipv63);
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

    public final Ipv4 component4() {
        return this.ipv4;
    }

    public final Ipv6 component5() {
        return this.ipv6;
    }

    public final DeviceUuid copy(String str, String str2, String str3, Ipv4 ipv42, Ipv6 ipv62) {
        Intrinsics.checkNotNullParameter(str, "uuid");
        return new DeviceUuid(str, str2, str3, ipv42, ipv62);
    }

    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceUuid)) {
            return false;
        }
        DeviceUuid deviceUuid = (DeviceUuid) obj;
        return Intrinsics.areEqual((Object) this.uuid, (Object) deviceUuid.uuid) && Intrinsics.areEqual((Object) this.ssid, (Object) deviceUuid.ssid) && Intrinsics.areEqual((Object) this.bssid, (Object) deviceUuid.bssid) && Intrinsics.areEqual((Object) this.ipv4, (Object) deviceUuid.ipv4) && Intrinsics.areEqual((Object) this.ipv6, (Object) deviceUuid.ipv6);
    }

    public int hashCode() {
        int hashCode = this.uuid.hashCode() * 31;
        String str = this.ssid;
        int i = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.bssid;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Ipv4 ipv42 = this.ipv4;
        int hashCode4 = (hashCode3 + (ipv42 == null ? 0 : ipv42.hashCode())) * 31;
        Ipv6 ipv62 = this.ipv6;
        if (ipv62 != null) {
            i = ipv62.hashCode();
        }
        return hashCode4 + i;
    }

    public String toString() {
        return "DeviceUuid(uuid=" + this.uuid + ", ssid=" + this.ssid + ", bssid=" + this.bssid + ", ipv4=" + this.ipv4 + ", ipv6=" + this.ipv6 + ')';
    }

    public final void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeString(this.uuid);
        parcel.writeString(this.ssid);
        parcel.writeString(this.bssid);
        Ipv4 ipv42 = this.ipv4;
        if (ipv42 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            ipv42.writeToParcel(parcel, i);
        }
        Ipv6 ipv62 = this.ipv6;
        if (ipv62 == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        ipv62.writeToParcel(parcel, i);
    }

    public DeviceUuid(String str, String str2, String str3, Ipv4 ipv42, Ipv6 ipv62) {
        Intrinsics.checkNotNullParameter(str, "uuid");
        this.uuid = str;
        this.ssid = str2;
        this.bssid = str3;
        this.ipv4 = ipv42;
        this.ipv6 = ipv62;
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

    public final Ipv4 getIpv4() {
        return this.ipv4;
    }

    public final Ipv6 getIpv6() {
        return this.ipv6;
    }
}
