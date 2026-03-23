package com.blueair.core.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000 '2\u00020\u0001:\u0002&'B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0013\u0010\u0015\u001a\u00020\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0006H\u0016J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001c\u001a\u00020\bHÆ\u0003J\t\u0010\u001d\u001a\u00020\nHÆ\u0003J;\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0006\u0010\u001f\u001a\u00020\u0006J\t\u0010 \u001a\u00020\bHÖ\u0001J\u0016\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0014¨\u0006("}, d2 = {"Lcom/blueair/core/model/WelcomeHomeLocation;", "Landroid/os/Parcelable;", "lat", "", "lng", "radius", "", "textValue", "", "isEnabled", "", "<init>", "(DDILjava/lang/String;Z)V", "getLat", "()D", "getLng", "getRadius", "()I", "getTextValue", "()Ljava/lang/String;", "()Z", "equals", "other", "", "hashCode", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "WelcomeHomeRadius", "Companion", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: WelcomeHomeLocation.kt */
public final class WelcomeHomeLocation implements Parcelable {
    public static final Parcelable.Creator<WelcomeHomeLocation> CREATOR = new Creator();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final boolean isEnabled;
    private final double lat;
    private final double lng;
    private final int radius;
    private final String textValue;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: WelcomeHomeLocation.kt */
    public static final class Creator implements Parcelable.Creator<WelcomeHomeLocation> {
        public final WelcomeHomeLocation createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new WelcomeHomeLocation(parcel.readDouble(), parcel.readDouble(), parcel.readInt(), parcel.readString(), parcel.readInt() != 0);
        }

        public final WelcomeHomeLocation[] newArray(int i) {
            return new WelcomeHomeLocation[i];
        }
    }

    public static /* synthetic */ WelcomeHomeLocation copy$default(WelcomeHomeLocation welcomeHomeLocation, double d, double d2, int i, String str, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            d = welcomeHomeLocation.lat;
        }
        double d3 = d;
        if ((i2 & 2) != 0) {
            d2 = welcomeHomeLocation.lng;
        }
        double d4 = d2;
        if ((i2 & 4) != 0) {
            i = welcomeHomeLocation.radius;
        }
        int i3 = i;
        if ((i2 & 8) != 0) {
            str = welcomeHomeLocation.textValue;
        }
        String str2 = str;
        if ((i2 & 16) != 0) {
            z = welcomeHomeLocation.isEnabled;
        }
        return welcomeHomeLocation.copy(d3, d4, i3, str2, z);
    }

    public final double component1() {
        return this.lat;
    }

    public final double component2() {
        return this.lng;
    }

    public final int component3() {
        return this.radius;
    }

    public final String component4() {
        return this.textValue;
    }

    public final boolean component5() {
        return this.isEnabled;
    }

    public final WelcomeHomeLocation copy(double d, double d2, int i, String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "textValue");
        return new WelcomeHomeLocation(d, d2, i, str, z);
    }

    public final int describeContents() {
        return 0;
    }

    public String toString() {
        return "WelcomeHomeLocation(lat=" + this.lat + ", lng=" + this.lng + ", radius=" + this.radius + ", textValue=" + this.textValue + ", isEnabled=" + this.isEnabled + ')';
    }

    public final void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeDouble(this.lat);
        parcel.writeDouble(this.lng);
        parcel.writeInt(this.radius);
        parcel.writeString(this.textValue);
        parcel.writeInt(this.isEnabled ? 1 : 0);
    }

    public WelcomeHomeLocation(double d, double d2, int i, String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "textValue");
        this.lat = d;
        this.lng = d2;
        this.radius = i;
        this.textValue = str;
        this.isEnabled = z;
    }

    public final double getLat() {
        return this.lat;
    }

    public final double getLng() {
        return this.lng;
    }

    public final int getRadius() {
        return this.radius;
    }

    public final String getTextValue() {
        return this.textValue;
    }

    public final boolean isEnabled() {
        return this.isEnabled;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\f\b\u0002\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0010B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0011"}, d2 = {"Lcom/blueair/core/model/WelcomeHomeLocation$WelcomeHomeRadius;", "", "textValue", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;F)V", "getTextValue", "()Ljava/lang/String;", "getValue", "()F", "CAR", "BICYCLE", "WALK", "COMMUTE", "Companion", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: WelcomeHomeLocation.kt */
    public enum WelcomeHomeRadius {
        CAR("3 km", 3000.0f),
        BICYCLE("2 km", 2000.0f),
        WALK("1 km", 1000.0f),
        COMMUTE("2.5 km", 2500.0f);
        
        public static final Companion Companion = null;
        private final String textValue;
        private final float value;

        public static EnumEntries<WelcomeHomeRadius> getEntries() {
            return $ENTRIES;
        }

        private WelcomeHomeRadius(String str, float f) {
            this.textValue = str;
            this.value = f;
        }

        public final String getTextValue() {
            return this.textValue;
        }

        public final float getValue() {
            return this.value;
        }

        static {
            WelcomeHomeRadius[] $values;
            $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
            Companion = new Companion((DefaultConstructorMarker) null);
        }

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lcom/blueair/core/model/WelcomeHomeLocation$WelcomeHomeRadius$Companion;", "", "<init>", "()V", "fromValue", "Lcom/blueair/core/model/WelcomeHomeLocation$WelcomeHomeRadius;", "value", "", "(Ljava/lang/Float;)Lcom/blueair/core/model/WelcomeHomeLocation$WelcomeHomeRadius;", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* compiled from: WelcomeHomeLocation.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final WelcomeHomeRadius fromValue(Float f) {
                for (WelcomeHomeRadius welcomeHomeRadius : WelcomeHomeRadius.values()) {
                    if (Intrinsics.areEqual(welcomeHomeRadius.getValue(), f)) {
                        return welcomeHomeRadius;
                    }
                }
                return null;
            }
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof WelcomeHomeLocation)) {
            return false;
        }
        WelcomeHomeLocation welcomeHomeLocation = (WelcomeHomeLocation) obj;
        return this.lat == welcomeHomeLocation.lat && this.lng == welcomeHomeLocation.lng && this.radius == welcomeHomeLocation.radius;
    }

    public int hashCode() {
        return (((Double.doubleToLongBits(this.lat) * 31) + Double.doubleToLongBits(this.lng)) * 31) + this.radius;
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0004\u001a\u00020\u0005*\u00020\u0006J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\t¨\u0006\n"}, d2 = {"Lcom/blueair/core/model/WelcomeHomeLocation$Companion;", "", "<init>", "()V", "toBlueWelcomeHomeLocation", "Lcom/blueair/core/model/BlueWelcomeHomeLocation;", "Lcom/blueair/core/model/WelcomeHomeLocation;", "fromBlueWelcomeHomeLocation", "location", "Lcom/blueair/core/model/BlueCloudHomeLocationReceive;", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: WelcomeHomeLocation.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final BlueWelcomeHomeLocation toBlueWelcomeHomeLocation(WelcomeHomeLocation welcomeHomeLocation) {
            Intrinsics.checkNotNullParameter(welcomeHomeLocation, "<this>");
            return new BlueWelcomeHomeLocation(welcomeHomeLocation.getLat(), welcomeHomeLocation.getLng(), welcomeHomeLocation.getRadius(), welcomeHomeLocation.getTextValue());
        }

        public final WelcomeHomeLocation fromBlueWelcomeHomeLocation(BlueCloudHomeLocationReceive blueCloudHomeLocationReceive) {
            if (blueCloudHomeLocationReceive != null) {
                return new WelcomeHomeLocation(blueCloudHomeLocationReceive.getSetting().getLat(), blueCloudHomeLocationReceive.getSetting().getLng(), blueCloudHomeLocationReceive.getSetting().getRadius(), blueCloudHomeLocationReceive.getSetting().getTextValue(), false);
            }
            return null;
        }
    }
}
