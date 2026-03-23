package com.blueair.database.entity;

import com.blueair.core.model.TrackedLocation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u0000 ,2\u00020\u0001:\u0001,B[\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0006\u0010\u001a\u001a\u00020\u001bJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jo\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020*HÖ\u0001J\t\u0010+\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010¨\u0006-"}, d2 = {"Lcom/blueair/database/entity/TrackedLocationEntity;", "", "id", "", "latitude", "", "longitude", "locationName", "cityName", "stateName", "countryName", "countryCode", "mapType", "<init>", "(Ljava/lang/String;DDLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getLatitude", "()D", "getLongitude", "getLocationName", "getCityName", "getStateName", "getCountryName", "getCountryCode", "getMapType", "toTrackedLocation", "Lcom/blueair/core/model/TrackedLocation;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: TrackedLocationEntity.kt */
public final class TrackedLocationEntity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TRACKED_LOCATION_TABLE = "tracked_location_table";
    private final String cityName;
    private final String countryCode;
    private final String countryName;
    private final String id;
    private final double latitude;
    private final String locationName;
    private final double longitude;
    private final String mapType;
    private final String stateName;

    public static /* synthetic */ TrackedLocationEntity copy$default(TrackedLocationEntity trackedLocationEntity, String str, double d, double d2, String str2, String str3, String str4, String str5, String str6, String str7, int i, Object obj) {
        if ((i & 1) != 0) {
            str = trackedLocationEntity.id;
        }
        if ((i & 2) != 0) {
            d = trackedLocationEntity.latitude;
        }
        if ((i & 4) != 0) {
            d2 = trackedLocationEntity.longitude;
        }
        if ((i & 8) != 0) {
            str2 = trackedLocationEntity.locationName;
        }
        if ((i & 16) != 0) {
            str3 = trackedLocationEntity.cityName;
        }
        if ((i & 32) != 0) {
            str4 = trackedLocationEntity.stateName;
        }
        if ((i & 64) != 0) {
            str5 = trackedLocationEntity.countryName;
        }
        if ((i & 128) != 0) {
            str6 = trackedLocationEntity.countryCode;
        }
        if ((i & 256) != 0) {
            str7 = trackedLocationEntity.mapType;
        }
        String str8 = str6;
        String str9 = str7;
        double d3 = d2;
        double d4 = d;
        return trackedLocationEntity.copy(str, d4, d3, str2, str3, str4, str5, str8, str9);
    }

    public final String component1() {
        return this.id;
    }

    public final double component2() {
        return this.latitude;
    }

    public final double component3() {
        return this.longitude;
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

    public final TrackedLocationEntity copy(String str, double d, double d2, String str2, String str3, String str4, String str5, String str6, String str7) {
        Intrinsics.checkNotNullParameter(str, "id");
        return new TrackedLocationEntity(str, d, d2, str2, str3, str4, str5, str6, str7);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TrackedLocationEntity)) {
            return false;
        }
        TrackedLocationEntity trackedLocationEntity = (TrackedLocationEntity) obj;
        return Intrinsics.areEqual((Object) this.id, (Object) trackedLocationEntity.id) && Double.compare(this.latitude, trackedLocationEntity.latitude) == 0 && Double.compare(this.longitude, trackedLocationEntity.longitude) == 0 && Intrinsics.areEqual((Object) this.locationName, (Object) trackedLocationEntity.locationName) && Intrinsics.areEqual((Object) this.cityName, (Object) trackedLocationEntity.cityName) && Intrinsics.areEqual((Object) this.stateName, (Object) trackedLocationEntity.stateName) && Intrinsics.areEqual((Object) this.countryName, (Object) trackedLocationEntity.countryName) && Intrinsics.areEqual((Object) this.countryCode, (Object) trackedLocationEntity.countryCode) && Intrinsics.areEqual((Object) this.mapType, (Object) trackedLocationEntity.mapType);
    }

    public int hashCode() {
        int hashCode = ((((this.id.hashCode() * 31) + Double.doubleToLongBits(this.latitude)) * 31) + Double.doubleToLongBits(this.longitude)) * 31;
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
        return "TrackedLocationEntity(id=" + this.id + ", latitude=" + this.latitude + ", longitude=" + this.longitude + ", locationName=" + this.locationName + ", cityName=" + this.cityName + ", stateName=" + this.stateName + ", countryName=" + this.countryName + ", countryCode=" + this.countryCode + ", mapType=" + this.mapType + ')';
    }

    public TrackedLocationEntity(String str, double d, double d2, String str2, String str3, String str4, String str5, String str6, String str7) {
        Intrinsics.checkNotNullParameter(str, "id");
        this.id = str;
        this.latitude = d;
        this.longitude = d2;
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

    public final double getLatitude() {
        return this.latitude;
    }

    public final double getLongitude() {
        return this.longitude;
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

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007J\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\nR\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/blueair/database/entity/TrackedLocationEntity$Companion;", "", "<init>", "()V", "TRACKED_LOCATION_TABLE", "", "fromTrackedLocations", "", "Lcom/blueair/database/entity/TrackedLocationEntity;", "trackedLocations", "Lcom/blueair/core/model/TrackedLocation;", "fromTrackedLocation", "trackedLocation", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: TrackedLocationEntity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final List<TrackedLocationEntity> fromTrackedLocations(List<TrackedLocation> list) {
            Intrinsics.checkNotNullParameter(list, "trackedLocations");
            Iterable<TrackedLocation> iterable = list;
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            for (TrackedLocation fromTrackedLocation : iterable) {
                arrayList.add(TrackedLocationEntity.Companion.fromTrackedLocation(fromTrackedLocation));
            }
            return (List) arrayList;
        }

        public final TrackedLocationEntity fromTrackedLocation(TrackedLocation trackedLocation) {
            Intrinsics.checkNotNullParameter(trackedLocation, "trackedLocation");
            return new TrackedLocationEntity(trackedLocation.getId(), trackedLocation.getLat(), trackedLocation.getLon(), trackedLocation.getLocationName(), trackedLocation.getCityName(), trackedLocation.getStateName(), trackedLocation.getCountryName(), trackedLocation.getCountryCode(), trackedLocation.getMapType());
        }
    }

    public final TrackedLocation toTrackedLocation() {
        return new TrackedLocation(this.id, this.latitude, this.longitude, this.locationName, this.cityName, this.stateName, this.countryName, this.countryCode, this.mapType);
    }
}
