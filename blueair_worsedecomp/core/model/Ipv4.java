package com.blueair.core.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006HÆ\u0003J3\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006HÆ\u0001J\u0006\u0010\u0012\u001a\u00020\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0013R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001f"}, d2 = {"Lcom/blueair/core/model/Ipv4;", "Landroid/os/Parcelable;", "ip", "", "gw", "dns", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getIp", "()Ljava/lang/String;", "getGw", "getDns", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceUuid.kt */
public final class Ipv4 implements Parcelable {
    public static final Parcelable.Creator<Ipv4> CREATOR = new Creator();
    private final List<String> dns;
    private final String gw;
    private final String ip;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceUuid.kt */
    public static final class Creator implements Parcelable.Creator<Ipv4> {
        public final Ipv4 createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new Ipv4(parcel.readString(), parcel.readString(), parcel.createStringArrayList());
        }

        public final Ipv4[] newArray(int i) {
            return new Ipv4[i];
        }
    }

    public static /* synthetic */ Ipv4 copy$default(Ipv4 ipv4, String str, String str2, List<String> list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = ipv4.ip;
        }
        if ((i & 2) != 0) {
            str2 = ipv4.gw;
        }
        if ((i & 4) != 0) {
            list = ipv4.dns;
        }
        return ipv4.copy(str, str2, list);
    }

    public final String component1() {
        return this.ip;
    }

    public final String component2() {
        return this.gw;
    }

    public final List<String> component3() {
        return this.dns;
    }

    public final Ipv4 copy(String str, String str2, List<String> list) {
        return new Ipv4(str, str2, list);
    }

    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Ipv4)) {
            return false;
        }
        Ipv4 ipv4 = (Ipv4) obj;
        return Intrinsics.areEqual((Object) this.ip, (Object) ipv4.ip) && Intrinsics.areEqual((Object) this.gw, (Object) ipv4.gw) && Intrinsics.areEqual((Object) this.dns, (Object) ipv4.dns);
    }

    public int hashCode() {
        String str = this.ip;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.gw;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        List<String> list = this.dns;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "Ipv4(ip=" + this.ip + ", gw=" + this.gw + ", dns=" + this.dns + ')';
    }

    public final void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeString(this.ip);
        parcel.writeString(this.gw);
        parcel.writeStringList(this.dns);
    }

    public Ipv4(String str, String str2, List<String> list) {
        this.ip = str;
        this.gw = str2;
        this.dns = list;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Ipv4(String str, String str2, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : list);
    }

    public final String getIp() {
        return this.ip;
    }

    public final String getGw() {
        return this.gw;
    }

    public final List<String> getDns() {
        return this.dns;
    }
}
