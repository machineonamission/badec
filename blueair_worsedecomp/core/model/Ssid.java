package com.blueair.core.model;

import com.squareup.moshi.Json;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J7\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001a"}, d2 = {"Lcom/blueair/core/model/Ssid;", "", "ssid", "", "bssid", "rssi", "", "auth", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "getSsid", "()Ljava/lang/String;", "getBssid", "getRssi", "()I", "getAuth", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Json(name = "network")
/* compiled from: Ssid.kt */
public final class Ssid {
    private final String auth;
    private final String bssid;
    private final int rssi;
    private final String ssid;

    public static /* synthetic */ Ssid copy$default(Ssid ssid2, String str, String str2, int i, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = ssid2.ssid;
        }
        if ((i2 & 2) != 0) {
            str2 = ssid2.bssid;
        }
        if ((i2 & 4) != 0) {
            i = ssid2.rssi;
        }
        if ((i2 & 8) != 0) {
            str3 = ssid2.auth;
        }
        return ssid2.copy(str, str2, i, str3);
    }

    public final String component1() {
        return this.ssid;
    }

    public final String component2() {
        return this.bssid;
    }

    public final int component3() {
        return this.rssi;
    }

    public final String component4() {
        return this.auth;
    }

    public final Ssid copy(String str, String str2, int i, String str3) {
        return new Ssid(str, str2, i, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Ssid)) {
            return false;
        }
        Ssid ssid2 = (Ssid) obj;
        return Intrinsics.areEqual((Object) this.ssid, (Object) ssid2.ssid) && Intrinsics.areEqual((Object) this.bssid, (Object) ssid2.bssid) && this.rssi == ssid2.rssi && Intrinsics.areEqual((Object) this.auth, (Object) ssid2.auth);
    }

    public int hashCode() {
        String str = this.ssid;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.bssid;
        int hashCode2 = (((hashCode + (str2 == null ? 0 : str2.hashCode())) * 31) + this.rssi) * 31;
        String str3 = this.auth;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "Ssid(ssid=" + this.ssid + ", bssid=" + this.bssid + ", rssi=" + this.rssi + ", auth=" + this.auth + ')';
    }

    public Ssid(String str, String str2, int i, String str3) {
        this.ssid = str;
        this.bssid = str2;
        this.rssi = i;
        this.auth = str3;
    }

    public final String getSsid() {
        return this.ssid;
    }

    public final String getBssid() {
        return this.bssid;
    }

    public final int getRssi() {
        return this.rssi;
    }

    public final String getAuth() {
        return this.auth;
    }
}
