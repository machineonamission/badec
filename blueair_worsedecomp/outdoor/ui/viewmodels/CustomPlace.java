package com.blueair.outdoor.ui.viewmodels;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\b\u0018\u0000 $2\u00020\u0001:\u0001$B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tB\u0011\b\u0016\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\b\u0010\fJ\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0006HÆ\u0003J5\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\u0017HÖ\u0001J\t\u0010#\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011¨\u0006%"}, d2 = {"Lcom/blueair/outdoor/ui/viewmodels/CustomPlace;", "Landroid/os/Parcelable;", "lat", "", "lng", "address", "", "shortAddress", "<init>", "(DDLjava/lang/String;Ljava/lang/String;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getLat", "()D", "getLng", "getAddress", "()Ljava/lang/String;", "getShortAddress", "writeToParcel", "", "dest", "flags", "", "describeContents", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "CREATOR", "outdoor_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: SearchViewModel.kt */
public final class CustomPlace implements Parcelable {
    public static final CREATOR CREATOR = new CREATOR((DefaultConstructorMarker) null);
    private final String address;
    private final double lat;
    private final double lng;
    private final String shortAddress;

    public static /* synthetic */ CustomPlace copy$default(CustomPlace customPlace, double d, double d2, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            d = customPlace.lat;
        }
        double d3 = d;
        if ((i & 2) != 0) {
            d2 = customPlace.lng;
        }
        double d4 = d2;
        if ((i & 4) != 0) {
            str = customPlace.address;
        }
        String str3 = str;
        if ((i & 8) != 0) {
            str2 = customPlace.shortAddress;
        }
        return customPlace.copy(d3, d4, str3, str2);
    }

    public final double component1() {
        return this.lat;
    }

    public final double component2() {
        return this.lng;
    }

    public final String component3() {
        return this.address;
    }

    public final String component4() {
        return this.shortAddress;
    }

    public final CustomPlace copy(double d, double d2, String str, String str2) {
        return new CustomPlace(d, d2, str, str2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CustomPlace)) {
            return false;
        }
        CustomPlace customPlace = (CustomPlace) obj;
        return Double.compare(this.lat, customPlace.lat) == 0 && Double.compare(this.lng, customPlace.lng) == 0 && Intrinsics.areEqual((Object) this.address, (Object) customPlace.address) && Intrinsics.areEqual((Object) this.shortAddress, (Object) customPlace.shortAddress);
    }

    public int hashCode() {
        int m = ((Double.doubleToLongBits(this.lat) * 31) + Double.doubleToLongBits(this.lng)) * 31;
        String str = this.address;
        int i = 0;
        int hashCode = (m + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.shortAddress;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "CustomPlace(lat=" + this.lat + ", lng=" + this.lng + ", address=" + this.address + ", shortAddress=" + this.shortAddress + ')';
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001d\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Lcom/blueair/outdoor/ui/viewmodels/CustomPlace$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/blueair/outdoor/ui/viewmodels/CustomPlace;", "<init>", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/blueair/outdoor/ui/viewmodels/CustomPlace;", "outdoor_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: SearchViewModel.kt */
    public static final class CREATOR implements Parcelable.Creator<CustomPlace> {
        public /* synthetic */ CREATOR(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private CREATOR() {
        }

        public CustomPlace createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new CustomPlace(parcel);
        }

        public CustomPlace[] newArray(int i) {
            return new CustomPlace[i];
        }
    }

    public CustomPlace(double d, double d2, String str, String str2) {
        this.lat = d;
        this.lng = d2;
        this.address = str;
        this.shortAddress = str2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CustomPlace(double r8, double r10, java.lang.String r12, java.lang.String r13, int r14, kotlin.jvm.internal.DefaultConstructorMarker r15) {
        /*
            r7 = this;
            r14 = r14 & 8
            r5 = r12
            if (r14 == 0) goto L_0x0007
            r6 = r5
            goto L_0x0008
        L_0x0007:
            r6 = r13
        L_0x0008:
            r0 = r7
            r1 = r8
            r3 = r10
            r0.<init>(r1, r3, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.outdoor.ui.viewmodels.CustomPlace.<init>(double, double, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getAddress() {
        return this.address;
    }

    public final double getLat() {
        return this.lat;
    }

    public final double getLng() {
        return this.lng;
    }

    public final String getShortAddress() {
        return this.shortAddress;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CustomPlace(Parcel parcel) {
        this(parcel.readDouble(), parcel.readDouble(), parcel.readString(), parcel.readString());
        Intrinsics.checkNotNullParameter(parcel, "parcel");
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeDouble(this.lat);
        parcel.writeDouble(this.lng);
        parcel.writeString(this.address);
        parcel.writeString(this.shortAddress);
    }
}
