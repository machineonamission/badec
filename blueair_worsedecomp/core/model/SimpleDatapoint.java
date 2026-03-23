package com.blueair.core.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.blueair.adddevice.model.AddDeviceState$$ExternalSyntheticBackport0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0006\u0010\u0013\u001a\u00020\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0014HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\u0016\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\u00020\u00038F¢\u0006\f\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\t¨\u0006!"}, d2 = {"Lcom/blueair/core/model/SimpleDatapoint;", "Landroid/os/Parcelable;", "timeInSeconds", "", "value", "", "<init>", "(JF)V", "getTimeInSeconds", "()J", "getValue", "()F", "timeInMillis", "getTimeInMillis$annotations", "()V", "getTimeInMillis", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: SimpleDatapoint.kt */
public final class SimpleDatapoint implements Parcelable {
    public static final Parcelable.Creator<SimpleDatapoint> CREATOR = new Creator();
    private final long timeInSeconds;
    private final float value;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: SimpleDatapoint.kt */
    public static final class Creator implements Parcelable.Creator<SimpleDatapoint> {
        public final SimpleDatapoint createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new SimpleDatapoint(parcel.readLong(), parcel.readFloat());
        }

        public final SimpleDatapoint[] newArray(int i) {
            return new SimpleDatapoint[i];
        }
    }

    public static /* synthetic */ SimpleDatapoint copy$default(SimpleDatapoint simpleDatapoint, long j, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            j = simpleDatapoint.timeInSeconds;
        }
        if ((i & 2) != 0) {
            f = simpleDatapoint.value;
        }
        return simpleDatapoint.copy(j, f);
    }

    public static /* synthetic */ void getTimeInMillis$annotations() {
    }

    public final long component1() {
        return this.timeInSeconds;
    }

    public final float component2() {
        return this.value;
    }

    public final SimpleDatapoint copy(long j, float f) {
        return new SimpleDatapoint(j, f);
    }

    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SimpleDatapoint)) {
            return false;
        }
        SimpleDatapoint simpleDatapoint = (SimpleDatapoint) obj;
        return this.timeInSeconds == simpleDatapoint.timeInSeconds && Float.compare(this.value, simpleDatapoint.value) == 0;
    }

    public int hashCode() {
        return (AddDeviceState$$ExternalSyntheticBackport0.m(this.timeInSeconds) * 31) + Float.floatToIntBits(this.value);
    }

    public String toString() {
        return "SimpleDatapoint(timeInSeconds=" + this.timeInSeconds + ", value=" + this.value + ')';
    }

    public final void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeLong(this.timeInSeconds);
        parcel.writeFloat(this.value);
    }

    public SimpleDatapoint(long j, float f) {
        this.timeInSeconds = j;
        this.value = f;
    }

    public final long getTimeInSeconds() {
        return this.timeInSeconds;
    }

    public final float getValue() {
        return this.value;
    }

    public final long getTimeInMillis() {
        return this.timeInSeconds * ((long) 1000);
    }
}
