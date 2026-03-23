package com.blueair.core.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001b\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/blueair/core/model/BlueWelcomeHomeLocation;", "", "lat", "", "lng", "radius", "", "textValue", "", "<init>", "(DDILjava/lang/String;)V", "getLat", "()D", "getLng", "getRadius", "()I", "getTextValue", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: BlueWelcomeHomeLocation.kt */
public final class BlueWelcomeHomeLocation {
    private final double lat;
    private final double lng;
    private final int radius;
    private final String textValue;

    public static /* synthetic */ BlueWelcomeHomeLocation copy$default(BlueWelcomeHomeLocation blueWelcomeHomeLocation, double d, double d2, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            d = blueWelcomeHomeLocation.lat;
        }
        double d3 = d;
        if ((i2 & 2) != 0) {
            d2 = blueWelcomeHomeLocation.lng;
        }
        double d4 = d2;
        if ((i2 & 4) != 0) {
            i = blueWelcomeHomeLocation.radius;
        }
        int i3 = i;
        if ((i2 & 8) != 0) {
            str = blueWelcomeHomeLocation.textValue;
        }
        return blueWelcomeHomeLocation.copy(d3, d4, i3, str);
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

    public final BlueWelcomeHomeLocation copy(double d, double d2, int i, String str) {
        Intrinsics.checkNotNullParameter(str, "textValue");
        return new BlueWelcomeHomeLocation(d, d2, i, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BlueWelcomeHomeLocation)) {
            return false;
        }
        BlueWelcomeHomeLocation blueWelcomeHomeLocation = (BlueWelcomeHomeLocation) obj;
        return Double.compare(this.lat, blueWelcomeHomeLocation.lat) == 0 && Double.compare(this.lng, blueWelcomeHomeLocation.lng) == 0 && this.radius == blueWelcomeHomeLocation.radius && Intrinsics.areEqual((Object) this.textValue, (Object) blueWelcomeHomeLocation.textValue);
    }

    public int hashCode() {
        return (((((Double.doubleToLongBits(this.lat) * 31) + Double.doubleToLongBits(this.lng)) * 31) + this.radius) * 31) + this.textValue.hashCode();
    }

    public String toString() {
        return "BlueWelcomeHomeLocation(lat=" + this.lat + ", lng=" + this.lng + ", radius=" + this.radius + ", textValue=" + this.textValue + ')';
    }

    public BlueWelcomeHomeLocation(double d, double d2, int i, String str) {
        Intrinsics.checkNotNullParameter(str, "textValue");
        this.lat = d;
        this.lng = d2;
        this.radius = i;
        this.textValue = str;
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
}
