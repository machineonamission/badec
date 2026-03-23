package com.blueair.core.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.blueair.core.util.CoordinateTransformUtils;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 :2\u00020\u0001:\u0001:B[\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0006\u0010\u001a\u001a\u00020\u001bJ\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u001dJ\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u001dJ\r\u0010\u001f\u001a\u0004\u0018\u00010\u001b¢\u0006\u0002\u0010 J\u0006\u0010!\u001a\u00020\u001bJ\u0006\u0010\"\u001a\u00020\u001bJ\u0006\u0010#\u001a\u00020\u001bJ\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jo\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0006\u0010.\u001a\u00020/J\u0013\u00100\u001a\u00020\u001b2\b\u00101\u001a\u0004\u0018\u000102HÖ\u0003J\t\u00103\u001a\u00020/HÖ\u0001J\t\u00104\u001a\u00020\u0003HÖ\u0001J\u0016\u00105\u001a\u0002062\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020/R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010¨\u0006;"}, d2 = {"Lcom/blueair/core/model/TrackedLocation;", "Landroid/os/Parcelable;", "id", "", "lat", "", "lon", "locationName", "cityName", "stateName", "countryName", "countryCode", "mapType", "<init>", "(Ljava/lang/String;DDLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getLat", "()D", "getLon", "getLocationName", "getCityName", "getStateName", "getCountryName", "getCountryCode", "getMapType", "isCurrentLocation", "", "getLatLngInGCJ", "Lkotlin/Pair;", "getLatLngInWGS", "isInMainlandChina", "()Ljava/lang/Boolean;", "isLocalMapType", "useWGS", "useGCJ", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: TrackedLocation.kt */
public final class TrackedLocation implements Parcelable {
    public static final Parcelable.Creator<TrackedLocation> CREATOR = new Creator();
    public static final String CURRENT_LOCATION_ID = "current";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String MAP_TYPE_GCJ = "GCJ";
    public static final String MAP_TYPE_GCJ_LOCAL = "GCJ_LOCAL";
    public static final String MAP_TYPE_WGS = "WGS";
    public static final String MAP_TYPE_WGS_LOCAL = "WGS_LOCAL";
    private final String cityName;
    private final String countryCode;
    private final String countryName;
    private final String id;
    private final double lat;
    private final String locationName;
    private final double lon;
    private final String mapType;
    private final String stateName;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: TrackedLocation.kt */
    public static final class Creator implements Parcelable.Creator<TrackedLocation> {
        public final TrackedLocation createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new TrackedLocation(parcel.readString(), parcel.readDouble(), parcel.readDouble(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        public final TrackedLocation[] newArray(int i) {
            return new TrackedLocation[i];
        }
    }

    public static /* synthetic */ TrackedLocation copy$default(TrackedLocation trackedLocation, String str, double d, double d2, String str2, String str3, String str4, String str5, String str6, String str7, int i, Object obj) {
        if ((i & 1) != 0) {
            str = trackedLocation.id;
        }
        if ((i & 2) != 0) {
            d = trackedLocation.lat;
        }
        if ((i & 4) != 0) {
            d2 = trackedLocation.lon;
        }
        if ((i & 8) != 0) {
            str2 = trackedLocation.locationName;
        }
        if ((i & 16) != 0) {
            str3 = trackedLocation.cityName;
        }
        if ((i & 32) != 0) {
            str4 = trackedLocation.stateName;
        }
        if ((i & 64) != 0) {
            str5 = trackedLocation.countryName;
        }
        if ((i & 128) != 0) {
            str6 = trackedLocation.countryCode;
        }
        if ((i & 256) != 0) {
            str7 = trackedLocation.mapType;
        }
        String str8 = str6;
        String str9 = str7;
        double d3 = d2;
        double d4 = d;
        return trackedLocation.copy(str, d4, d3, str2, str3, str4, str5, str8, str9);
    }

    public final String component1() {
        return this.id;
    }

    public final double component2() {
        return this.lat;
    }

    public final double component3() {
        return this.lon;
    }

    public final String component4() {
        return this.locationName;
    }

    public final String component5() {
        return this.cityName;
    }

    public final String component6() {
        return this.stateName;
    }

    public final String component7() {
        return this.countryName;
    }

    public final String component8() {
        return this.countryCode;
    }

    public final String component9() {
        return this.mapType;
    }

    public final TrackedLocation copy(String str, double d, double d2, String str2, String str3, String str4, String str5, String str6, String str7) {
        Intrinsics.checkNotNullParameter(str, "id");
        return new TrackedLocation(str, d, d2, str2, str3, str4, str5, str6, str7);
    }

    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TrackedLocation)) {
            return false;
        }
        TrackedLocation trackedLocation = (TrackedLocation) obj;
        return Intrinsics.areEqual((Object) this.id, (Object) trackedLocation.id) && Double.compare(this.lat, trackedLocation.lat) == 0 && Double.compare(this.lon, trackedLocation.lon) == 0 && Intrinsics.areEqual((Object) this.locationName, (Object) trackedLocation.locationName) && Intrinsics.areEqual((Object) this.cityName, (Object) trackedLocation.cityName) && Intrinsics.areEqual((Object) this.stateName, (Object) trackedLocation.stateName) && Intrinsics.areEqual((Object) this.countryName, (Object) trackedLocation.countryName) && Intrinsics.areEqual((Object) this.countryCode, (Object) trackedLocation.countryCode) && Intrinsics.areEqual((Object) this.mapType, (Object) trackedLocation.mapType);
    }

    public int hashCode() {
        int hashCode = ((((this.id.hashCode() * 31) + Double.doubleToLongBits(this.lat)) * 31) + Double.doubleToLongBits(this.lon)) * 31;
        String str = this.locationName;
        int i = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.cityName;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.stateName;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.countryName;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.countryCode;
        int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.mapType;
        if (str6 != null) {
            i = str6.hashCode();
        }
        return hashCode6 + i;
    }

    public String toString() {
        return "TrackedLocation(id=" + this.id + ", lat=" + this.lat + ", lon=" + this.lon + ", locationName=" + this.locationName + ", cityName=" + this.cityName + ", stateName=" + this.stateName + ", countryName=" + this.countryName + ", countryCode=" + this.countryCode + ", mapType=" + this.mapType + ')';
    }

    public final void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeString(this.id);
        parcel.writeDouble(this.lat);
        parcel.writeDouble(this.lon);
        parcel.writeString(this.locationName);
        parcel.writeString(this.cityName);
        parcel.writeString(this.stateName);
        parcel.writeString(this.countryName);
        parcel.writeString(this.countryCode);
        parcel.writeString(this.mapType);
    }

    public TrackedLocation(String str, double d, double d2, String str2, String str3, String str4, String str5, String str6, String str7) {
        Intrinsics.checkNotNullParameter(str, "id");
        this.id = str;
        this.lat = d;
        this.lon = d2;
        this.locationName = str2;
        this.cityName = str3;
        this.stateName = str4;
        this.countryName = str5;
        this.countryCode = str6;
        this.mapType = str7;
    }

    public final String getId() {
        return this.id;
    }

    public final double getLat() {
        return this.lat;
    }

    public final double getLon() {
        return this.lon;
    }

    public final String getLocationName() {
        return this.locationName;
    }

    public final String getCityName() {
        return this.cityName;
    }

    public final String getStateName() {
        return this.stateName;
    }

    public final String getCountryName() {
        return this.countryName;
    }

    public final String getCountryCode() {
        return this.countryCode;
    }

    public final String getMapType() {
        return this.mapType;
    }

    public final boolean isCurrentLocation() {
        return Intrinsics.areEqual((Object) this.id, (Object) "current");
    }

    public final Pair<Double, Double> getLatLngInGCJ() {
        if (!Intrinsics.areEqual((Object) this.mapType, (Object) MAP_TYPE_WGS)) {
            return new Pair<>(Double.valueOf(this.lat), Double.valueOf(this.lon));
        }
        double[] wgs84togcj02 = CoordinateTransformUtils.INSTANCE.wgs84togcj02(this.lon, this.lat, isInMainlandChina());
        return new Pair<>(Double.valueOf(wgs84togcj02[1]), Double.valueOf(wgs84togcj02[0]));
    }

    public final Pair<Double, Double> getLatLngInWGS() {
        if (!Intrinsics.areEqual((Object) this.mapType, (Object) MAP_TYPE_GCJ)) {
            return new Pair<>(Double.valueOf(this.lat), Double.valueOf(this.lon));
        }
        double[] gcj02towgs84 = CoordinateTransformUtils.INSTANCE.gcj02towgs84(this.lon, this.lat, isInMainlandChina());
        return new Pair<>(Double.valueOf(gcj02towgs84[1]), Double.valueOf(gcj02towgs84[0]));
    }

    public final Boolean isInMainlandChina() {
        String str = this.countryCode;
        if (str != null) {
            return Boolean.valueOf(StringsKt.equals(str, "CN", true));
        }
        return null;
    }

    public final boolean isLocalMapType() {
        String str = this.mapType;
        if (str != null) {
            return StringsKt.endsWith$default(str, "LOCAL", false, 2, (Object) null);
        }
        return false;
    }

    public final boolean useWGS() {
        String str = this.mapType;
        if (str != null) {
            return StringsKt.startsWith$default(str, MAP_TYPE_WGS, false, 2, (Object) null);
        }
        return false;
    }

    public final boolean useGCJ() {
        String str = this.mapType;
        if (str != null) {
            return StringsKt.startsWith$default(str, MAP_TYPE_GCJ, false, 2, (Object) null);
        }
        return false;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/blueair/core/model/TrackedLocation$Companion;", "", "<init>", "()V", "MAP_TYPE_WGS", "", "MAP_TYPE_GCJ", "MAP_TYPE_WGS_LOCAL", "MAP_TYPE_GCJ_LOCAL", "CURRENT_LOCATION_ID", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: TrackedLocation.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
