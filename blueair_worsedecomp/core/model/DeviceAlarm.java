package com.blueair.core.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.blueair.adddevice.model.AddDeviceState$$ExternalSyntheticBackport0;
import com.squareup.moshi.Json;
import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BW\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\u0005\u0012\b\b\u0001\u0010\t\u001a\u00020\u0007\u0012\b\b\u0001\u0010\n\u001a\u00020\u0007\u0012\b\b\u0001\u0010\u000b\u001a\u00020\u0007\u0012\b\b\u0001\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\t\u0010#\u001a\u00020\u0007HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\t\u0010%\u001a\u00020\u0007HÆ\u0003J\t\u0010&\u001a\u00020\u0007HÆ\u0003J\t\u0010'\u001a\u00020\u0007HÆ\u0003J\t\u0010(\u001a\u00020\u0007HÆ\u0003JY\u0010)\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00072\b\b\u0003\u0010\b\u001a\u00020\u00052\b\b\u0003\u0010\t\u001a\u00020\u00072\b\b\u0003\u0010\n\u001a\u00020\u00072\b\b\u0003\u0010\u000b\u001a\u00020\u00072\b\b\u0003\u0010\f\u001a\u00020\u0007HÆ\u0001J\u0006\u0010*\u001a\u00020\u0007J\u0013\u0010+\u001a\u00020\u00052\b\u0010,\u001a\u0004\u0018\u00010-HÖ\u0003J\t\u0010.\u001a\u00020\u0007HÖ\u0001J\t\u0010/\u001a\u00020\u0003HÖ\u0001J\u0016\u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0011\u0010\f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u001d\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b¢\u0006\u000e\n\u0000\u0012\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u00065"}, d2 = {"Lcom/blueair/core/model/DeviceAlarm;", "Landroid/os/Parcelable;", "name", "", "enabled", "", "secondsInDay", "", "lightEnabled", "lightDuration", "sound", "volume", "repeats", "<init>", "(Ljava/lang/String;ZIZIIII)V", "getName", "()Ljava/lang/String;", "getEnabled", "()Z", "getSecondsInDay", "()I", "getLightEnabled", "getLightDuration", "getSound", "getVolume", "getRepeats", "daysOfWeek", "", "Lcom/blueair/core/model/DayOfWeek;", "getDaysOfWeek$annotations", "()V", "getDaysOfWeek", "()Ljava/util/Set;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceAlarm.kt */
public final class DeviceAlarm implements Parcelable {
    public static final Parcelable.Creator<DeviceAlarm> CREATOR = new Creator();
    private final Set<DayOfWeek> daysOfWeek;
    private final boolean enabled;
    private final int lightDuration;
    private final boolean lightEnabled;
    private final String name;
    private final int repeats;
    private final int secondsInDay;
    private final int sound;
    private final int volume;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceAlarm.kt */
    public static final class Creator implements Parcelable.Creator<DeviceAlarm> {
        public final DeviceAlarm createFromParcel(Parcel parcel) {
            boolean z;
            boolean z2;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String readString = parcel.readString();
            boolean z3 = true;
            if (parcel.readInt() != 0) {
                z2 = true;
                z = false;
            } else {
                z2 = true;
                z3 = false;
                z = false;
            }
            int readInt = parcel.readInt();
            if (parcel.readInt() != 0) {
                z = z2;
            }
            return new DeviceAlarm(readString, z3, readInt, z, parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
        }

        public final DeviceAlarm[] newArray(int i) {
            return new DeviceAlarm[i];
        }
    }

    public static /* synthetic */ DeviceAlarm copy$default(DeviceAlarm deviceAlarm, String str, boolean z, int i, boolean z2, int i2, int i3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            str = deviceAlarm.name;
        }
        if ((i6 & 2) != 0) {
            z = deviceAlarm.enabled;
        }
        if ((i6 & 4) != 0) {
            i = deviceAlarm.secondsInDay;
        }
        if ((i6 & 8) != 0) {
            z2 = deviceAlarm.lightEnabled;
        }
        if ((i6 & 16) != 0) {
            i2 = deviceAlarm.lightDuration;
        }
        if ((i6 & 32) != 0) {
            i3 = deviceAlarm.sound;
        }
        if ((i6 & 64) != 0) {
            i4 = deviceAlarm.volume;
        }
        if ((i6 & 128) != 0) {
            i5 = deviceAlarm.repeats;
        }
        int i7 = i4;
        int i8 = i5;
        int i9 = i2;
        int i10 = i3;
        boolean z3 = z2;
        boolean z4 = z;
        return deviceAlarm.copy(str, z4, i, z3, i9, i10, i7, i8);
    }

    public static /* synthetic */ void getDaysOfWeek$annotations() {
    }

    public final String component1() {
        return this.name;
    }

    public final boolean component2() {
        return this.enabled;
    }

    public final int component3() {
        return this.secondsInDay;
    }

    public final boolean component4() {
        return this.lightEnabled;
    }

    public final int component5() {
        return this.lightDuration;
    }

    public final int component6() {
        return this.sound;
    }

    public final int component7() {
        return this.volume;
    }

    public final int component8() {
        return this.repeats;
    }

    public final DeviceAlarm copy(@Json(name = "n") String str, @Json(name = "e") boolean z, @Json(name = "t") int i, @Json(name = "l") boolean z2, @Json(name = "ld") int i2, @Json(name = "s") int i3, @Json(name = "v") int i4, @Json(name = "r") int i5) {
        Intrinsics.checkNotNullParameter(str, "name");
        return new DeviceAlarm(str, z, i, z2, i2, i3, i4, i5);
    }

    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceAlarm)) {
            return false;
        }
        DeviceAlarm deviceAlarm = (DeviceAlarm) obj;
        return Intrinsics.areEqual((Object) this.name, (Object) deviceAlarm.name) && this.enabled == deviceAlarm.enabled && this.secondsInDay == deviceAlarm.secondsInDay && this.lightEnabled == deviceAlarm.lightEnabled && this.lightDuration == deviceAlarm.lightDuration && this.sound == deviceAlarm.sound && this.volume == deviceAlarm.volume && this.repeats == deviceAlarm.repeats;
    }

    public int hashCode() {
        return (((((((((((((this.name.hashCode() * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.enabled)) * 31) + this.secondsInDay) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.lightEnabled)) * 31) + this.lightDuration) * 31) + this.sound) * 31) + this.volume) * 31) + this.repeats;
    }

    public String toString() {
        return "DeviceAlarm(name=" + this.name + ", enabled=" + this.enabled + ", secondsInDay=" + this.secondsInDay + ", lightEnabled=" + this.lightEnabled + ", lightDuration=" + this.lightDuration + ", sound=" + this.sound + ", volume=" + this.volume + ", repeats=" + this.repeats + ')';
    }

    public final void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeString(this.name);
        parcel.writeInt(this.enabled ? 1 : 0);
        parcel.writeInt(this.secondsInDay);
        parcel.writeInt(this.lightEnabled ? 1 : 0);
        parcel.writeInt(this.lightDuration);
        parcel.writeInt(this.sound);
        parcel.writeInt(this.volume);
        parcel.writeInt(this.repeats);
    }

    public DeviceAlarm(@Json(name = "n") String str, @Json(name = "e") boolean z, @Json(name = "t") int i, @Json(name = "l") boolean z2, @Json(name = "ld") int i2, @Json(name = "s") int i3, @Json(name = "v") int i4, @Json(name = "r") int i5) {
        Intrinsics.checkNotNullParameter(str, "name");
        this.name = str;
        this.enabled = z;
        this.secondsInDay = i;
        this.lightEnabled = z2;
        this.lightDuration = i2;
        this.sound = i3;
        this.volume = i4;
        this.repeats = i5;
        HashSet hashSet = new HashSet();
        BitSet valueOf = BitSet.valueOf(new long[]{(long) i5});
        for (DayOfWeek dayOfWeek : CollectionsKt.sortedWith(DayOfWeek.getEntries(), new DeviceAlarm$special$$inlined$sortedBy$1())) {
            if (valueOf.get(dayOfWeek.getMonFirstOrder())) {
                hashSet.add(dayOfWeek);
            }
        }
        this.daysOfWeek = hashSet;
    }

    public final String getName() {
        return this.name;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final int getSecondsInDay() {
        return this.secondsInDay;
    }

    public final boolean getLightEnabled() {
        return this.lightEnabled;
    }

    public final int getLightDuration() {
        return this.lightDuration;
    }

    public final int getSound() {
        return this.sound;
    }

    public final int getVolume() {
        return this.volume;
    }

    public final int getRepeats() {
        return this.repeats;
    }

    public final Set<DayOfWeek> getDaysOfWeek() {
        return this.daysOfWeek;
    }
}
