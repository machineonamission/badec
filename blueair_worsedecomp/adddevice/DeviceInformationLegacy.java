package com.blueair.adddevice;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.http.client.config.CookieSpecs;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b!\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BG\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003JW\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0006\u0010$\u001a\u00020%J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)HÖ\u0003J\t\u0010*\u001a\u00020%HÖ\u0001J\t\u0010+\u001a\u00020\u0003HÖ\u0001J\u0016\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020%R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u000fR\u001a\u0010\b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\r\"\u0004\b\u0019\u0010\u000fR\u001a\u0010\t\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000f¨\u00061"}, d2 = {"Lcom/blueair/adddevice/DeviceInformationLegacy;", "Landroid/os/Parcelable;", "ipAddress", "", "macAddress", "id", "name", "model", "compatibility", "timeZone", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getIpAddress", "()Ljava/lang/String;", "setIpAddress", "(Ljava/lang/String;)V", "getMacAddress", "setMacAddress", "getId", "setId", "getName", "setName", "getModel", "setModel", "getCompatibility", "setCompatibility", "getTimeZone", "setTimeZone", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "adddevice_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceInformationLegacy.kt */
public final class DeviceInformationLegacy implements Parcelable {
    public static final Parcelable.Creator<DeviceInformationLegacy> CREATOR = new Creator();
    private String compatibility;
    private String id;
    private String ipAddress;
    private String macAddress;
    private String model;
    private String name;
    private String timeZone;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceInformationLegacy.kt */
    public static final class Creator implements Parcelable.Creator<DeviceInformationLegacy> {
        public final DeviceInformationLegacy createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new DeviceInformationLegacy(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        public final DeviceInformationLegacy[] newArray(int i) {
            return new DeviceInformationLegacy[i];
        }
    }

    public static /* synthetic */ DeviceInformationLegacy copy$default(DeviceInformationLegacy deviceInformationLegacy, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, Object obj) {
        if ((i & 1) != 0) {
            str = deviceInformationLegacy.ipAddress;
        }
        if ((i & 2) != 0) {
            str2 = deviceInformationLegacy.macAddress;
        }
        if ((i & 4) != 0) {
            str3 = deviceInformationLegacy.id;
        }
        if ((i & 8) != 0) {
            str4 = deviceInformationLegacy.name;
        }
        if ((i & 16) != 0) {
            str5 = deviceInformationLegacy.model;
        }
        if ((i & 32) != 0) {
            str6 = deviceInformationLegacy.compatibility;
        }
        if ((i & 64) != 0) {
            str7 = deviceInformationLegacy.timeZone;
        }
        String str8 = str6;
        String str9 = str7;
        String str10 = str4;
        String str11 = str5;
        return deviceInformationLegacy.copy(str, str2, str3, str10, str11, str8, str9);
    }

    public final String component1() {
        return this.ipAddress;
    }

    public final String component2() {
        return this.macAddress;
    }

    public final String component3() {
        return this.id;
    }

    public final String component4() {
        return this.name;
    }

    public final String component5() {
        return this.model;
    }

    public final String component6() {
        return this.compatibility;
    }

    public final String component7() {
        return this.timeZone;
    }

    public final DeviceInformationLegacy copy(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        Intrinsics.checkNotNullParameter(str3, "id");
        Intrinsics.checkNotNullParameter(str6, CookieSpecs.BROWSER_COMPATIBILITY);
        String str8 = str7;
        Intrinsics.checkNotNullParameter(str8, RemoteConfigConstants.RequestFieldKey.TIME_ZONE);
        return new DeviceInformationLegacy(str, str2, str3, str4, str5, str6, str8);
    }

    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceInformationLegacy)) {
            return false;
        }
        DeviceInformationLegacy deviceInformationLegacy = (DeviceInformationLegacy) obj;
        return Intrinsics.areEqual((Object) this.ipAddress, (Object) deviceInformationLegacy.ipAddress) && Intrinsics.areEqual((Object) this.macAddress, (Object) deviceInformationLegacy.macAddress) && Intrinsics.areEqual((Object) this.id, (Object) deviceInformationLegacy.id) && Intrinsics.areEqual((Object) this.name, (Object) deviceInformationLegacy.name) && Intrinsics.areEqual((Object) this.model, (Object) deviceInformationLegacy.model) && Intrinsics.areEqual((Object) this.compatibility, (Object) deviceInformationLegacy.compatibility) && Intrinsics.areEqual((Object) this.timeZone, (Object) deviceInformationLegacy.timeZone);
    }

    public int hashCode() {
        String str = this.ipAddress;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.macAddress;
        int hashCode2 = (((hashCode + (str2 == null ? 0 : str2.hashCode())) * 31) + this.id.hashCode()) * 31;
        String str3 = this.name;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.model;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return ((((hashCode3 + i) * 31) + this.compatibility.hashCode()) * 31) + this.timeZone.hashCode();
    }

    public String toString() {
        return "DeviceInformationLegacy(ipAddress=" + this.ipAddress + ", macAddress=" + this.macAddress + ", id=" + this.id + ", name=" + this.name + ", model=" + this.model + ", compatibility=" + this.compatibility + ", timeZone=" + this.timeZone + ')';
    }

    public final void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeString(this.ipAddress);
        parcel.writeString(this.macAddress);
        parcel.writeString(this.id);
        parcel.writeString(this.name);
        parcel.writeString(this.model);
        parcel.writeString(this.compatibility);
        parcel.writeString(this.timeZone);
    }

    public DeviceInformationLegacy(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        Intrinsics.checkNotNullParameter(str3, "id");
        Intrinsics.checkNotNullParameter(str6, CookieSpecs.BROWSER_COMPATIBILITY);
        Intrinsics.checkNotNullParameter(str7, RemoteConfigConstants.RequestFieldKey.TIME_ZONE);
        this.ipAddress = str;
        this.macAddress = str2;
        this.id = str3;
        this.name = str4;
        this.model = str5;
        this.compatibility = str6;
        this.timeZone = str7;
    }

    public final String getIpAddress() {
        return this.ipAddress;
    }

    public final void setIpAddress(String str) {
        this.ipAddress = str;
    }

    public final String getMacAddress() {
        return this.macAddress;
    }

    public final void setMacAddress(String str) {
        this.macAddress = str;
    }

    public final String getId() {
        return this.id;
    }

    public final void setId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.id = str;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final String getModel() {
        return this.model;
    }

    public final void setModel(String str) {
        this.model = str;
    }

    public final String getCompatibility() {
        return this.compatibility;
    }

    public final void setCompatibility(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.compatibility = str;
    }

    public final String getTimeZone() {
        return this.timeZone;
    }

    public final void setTimeZone(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.timeZone = str;
    }
}
