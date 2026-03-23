package com.blueair.core.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.blueair.adddevice.model.AddDeviceState$$ExternalSyntheticBackport0;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001Bi\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010&\u001a\u0004\u0018\u00010\u00052\u0006\u0010'\u001a\u00020(¢\u0006\u0002\u0010)J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\u0010\u00100\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u00101\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u00102\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u00103\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u00104\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u00105\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u00106\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u00107\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u00108\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0001\u00109\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010:J\u0006\u0010;\u001a\u00020\u001eJ\u0013\u0010<\u001a\u00020+2\b\u0010=\u001a\u0004\u0018\u00010>HÖ\u0003J\t\u0010?\u001a\u00020\u001eHÖ\u0001J\t\u0010@\u001a\u00020AHÖ\u0001J\u0016\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020\u001eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0015\u0010\u0013R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0016\u0010\u0013R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0017\u0010\u0013R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0018\u0010\u0013R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0019\u0010\u0013R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u001a\u0010\u0013R\u0015\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u001b\u0010\u0013R\u0015\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u001c\u0010\u0013R\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0010\n\u0002\u0010#\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0011\u0010$\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b%\u0010\u0011R\u001b\u0010*\u001a\u00020+8FX\u0002¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b*\u0010,¨\u0006G"}, d2 = {"Lcom/blueair/core/model/IndoorDatapoint;", "Landroid/os/Parcelable;", "timeInSeconds", "", "pm1", "", "pm10", "pm25", "voc", "hcho", "tmp", "hum", "fan", "weight", "<init>", "(JLjava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;)V", "getTimeInSeconds", "()J", "getPm1", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getPm10", "getPm25", "getVoc", "getHcho", "getTmp", "getHum", "getFan", "getWeight", "disinftime", "", "getDisinftime", "()Ljava/lang/Integer;", "setDisinftime", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "timeInMillis", "getTimeInMillis", "valueFor", "sensorType", "Lcom/blueair/core/model/SensorType;", "(Lcom/blueair/core/model/SensorType;)Ljava/lang/Float;", "isEmpty", "", "()Z", "isEmpty$delegate", "Lkotlin/Lazy;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "(JLjava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;)Lcom/blueair/core/model/IndoorDatapoint;", "describeContents", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: IndoorData.kt */
public final class IndoorDatapoint implements Parcelable {
    public static final Parcelable.Creator<IndoorDatapoint> CREATOR = new Creator();
    private transient Integer disinftime;
    private final Float fan;
    private final Float hcho;
    private final Float hum;
    private final Lazy isEmpty$delegate = LazyKt.lazy(new IndoorDatapoint$$ExternalSyntheticLambda0(this));
    private final Float pm1;
    private final Float pm10;
    private final Float pm25;
    private final long timeInSeconds;
    private final Float tmp;
    private final Float voc;
    private final Float weight;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: IndoorData.kt */
    public static final class Creator implements Parcelable.Creator<IndoorDatapoint> {
        public final IndoorDatapoint createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            long readLong = parcel.readLong();
            Float f = null;
            Float valueOf = parcel.readInt() == 0 ? null : Float.valueOf(parcel.readFloat());
            Float valueOf2 = parcel.readInt() == 0 ? null : Float.valueOf(parcel.readFloat());
            Float valueOf3 = parcel.readInt() == 0 ? null : Float.valueOf(parcel.readFloat());
            Float valueOf4 = parcel.readInt() == 0 ? null : Float.valueOf(parcel.readFloat());
            Float valueOf5 = parcel.readInt() == 0 ? null : Float.valueOf(parcel.readFloat());
            Float valueOf6 = parcel.readInt() == 0 ? null : Float.valueOf(parcel.readFloat());
            Float valueOf7 = parcel.readInt() == 0 ? null : Float.valueOf(parcel.readFloat());
            Float valueOf8 = parcel.readInt() == 0 ? null : Float.valueOf(parcel.readFloat());
            if (parcel.readInt() != 0) {
                f = Float.valueOf(parcel.readFloat());
            }
            return new IndoorDatapoint(readLong, valueOf, valueOf2, valueOf3, valueOf4, valueOf5, valueOf6, valueOf7, valueOf8, f);
        }

        public final IndoorDatapoint[] newArray(int i) {
            return new IndoorDatapoint[i];
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: IndoorData.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(20:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|(2:17|18)|19|21) */
        /* JADX WARNING: Can't wrap try/catch for region: R(21:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|21) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0034 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x003d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0046 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0050 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                com.blueair.core.model.SensorType[] r0 = com.blueair.core.model.SensorType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.blueair.core.model.SensorType r1 = com.blueair.core.model.SensorType.PM1     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.blueair.core.model.SensorType r1 = com.blueair.core.model.SensorType.PM10     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.blueair.core.model.SensorType r1 = com.blueair.core.model.SensorType.PM25     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.blueair.core.model.SensorType r1 = com.blueair.core.model.SensorType.VOC     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                com.blueair.core.model.SensorType r1 = com.blueair.core.model.SensorType.HCHO     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                com.blueair.core.model.SensorType r1 = com.blueair.core.model.SensorType.HUM     // Catch:{ NoSuchFieldError -> 0x003d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                com.blueair.core.model.SensorType r1 = com.blueair.core.model.SensorType.TMP     // Catch:{ NoSuchFieldError -> 0x0046 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0046 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0046 }
            L_0x0046:
                com.blueair.core.model.SensorType r1 = com.blueair.core.model.SensorType.FAN     // Catch:{ NoSuchFieldError -> 0x0050 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0050 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0050 }
            L_0x0050:
                com.blueair.core.model.SensorType r1 = com.blueair.core.model.SensorType.WEIGHT     // Catch:{ NoSuchFieldError -> 0x005a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x005a }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x005a }
            L_0x005a:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.core.model.IndoorDatapoint.WhenMappings.<clinit>():void");
        }
    }

    public static /* synthetic */ IndoorDatapoint copy$default(IndoorDatapoint indoorDatapoint, long j, Float f, Float f2, Float f3, Float f4, Float f5, Float f6, Float f7, Float f8, Float f9, int i, Object obj) {
        int i2 = i;
        if ((i2 & 1) != 0) {
            j = indoorDatapoint.timeInSeconds;
        }
        long j2 = j;
        if ((i2 & 2) != 0) {
            f = indoorDatapoint.pm1;
        }
        return indoorDatapoint.copy(j2, f, (i2 & 4) != 0 ? indoorDatapoint.pm10 : f2, (i2 & 8) != 0 ? indoorDatapoint.pm25 : f3, (i2 & 16) != 0 ? indoorDatapoint.voc : f4, (i2 & 32) != 0 ? indoorDatapoint.hcho : f5, (i2 & 64) != 0 ? indoorDatapoint.tmp : f6, (i2 & 128) != 0 ? indoorDatapoint.hum : f7, (i2 & 256) != 0 ? indoorDatapoint.fan : f8, (i2 & 512) != 0 ? indoorDatapoint.weight : f9);
    }

    public final long component1() {
        return this.timeInSeconds;
    }

    public final Float component10() {
        return this.weight;
    }

    public final Float component2() {
        return this.pm1;
    }

    public final Float component3() {
        return this.pm10;
    }

    public final Float component4() {
        return this.pm25;
    }

    public final Float component5() {
        return this.voc;
    }

    public final Float component6() {
        return this.hcho;
    }

    public final Float component7() {
        return this.tmp;
    }

    public final Float component8() {
        return this.hum;
    }

    public final Float component9() {
        return this.fan;
    }

    public final IndoorDatapoint copy(long j, Float f, Float f2, Float f3, Float f4, Float f5, Float f6, Float f7, Float f8, Float f9) {
        return new IndoorDatapoint(j, f, f2, f3, f4, f5, f6, f7, f8, f9);
    }

    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IndoorDatapoint)) {
            return false;
        }
        IndoorDatapoint indoorDatapoint = (IndoorDatapoint) obj;
        return this.timeInSeconds == indoorDatapoint.timeInSeconds && Intrinsics.areEqual((Object) this.pm1, (Object) indoorDatapoint.pm1) && Intrinsics.areEqual((Object) this.pm10, (Object) indoorDatapoint.pm10) && Intrinsics.areEqual((Object) this.pm25, (Object) indoorDatapoint.pm25) && Intrinsics.areEqual((Object) this.voc, (Object) indoorDatapoint.voc) && Intrinsics.areEqual((Object) this.hcho, (Object) indoorDatapoint.hcho) && Intrinsics.areEqual((Object) this.tmp, (Object) indoorDatapoint.tmp) && Intrinsics.areEqual((Object) this.hum, (Object) indoorDatapoint.hum) && Intrinsics.areEqual((Object) this.fan, (Object) indoorDatapoint.fan) && Intrinsics.areEqual((Object) this.weight, (Object) indoorDatapoint.weight);
    }

    public int hashCode() {
        int m = AddDeviceState$$ExternalSyntheticBackport0.m(this.timeInSeconds) * 31;
        Float f = this.pm1;
        int i = 0;
        int hashCode = (m + (f == null ? 0 : f.hashCode())) * 31;
        Float f2 = this.pm10;
        int hashCode2 = (hashCode + (f2 == null ? 0 : f2.hashCode())) * 31;
        Float f3 = this.pm25;
        int hashCode3 = (hashCode2 + (f3 == null ? 0 : f3.hashCode())) * 31;
        Float f4 = this.voc;
        int hashCode4 = (hashCode3 + (f4 == null ? 0 : f4.hashCode())) * 31;
        Float f5 = this.hcho;
        int hashCode5 = (hashCode4 + (f5 == null ? 0 : f5.hashCode())) * 31;
        Float f6 = this.tmp;
        int hashCode6 = (hashCode5 + (f6 == null ? 0 : f6.hashCode())) * 31;
        Float f7 = this.hum;
        int hashCode7 = (hashCode6 + (f7 == null ? 0 : f7.hashCode())) * 31;
        Float f8 = this.fan;
        int hashCode8 = (hashCode7 + (f8 == null ? 0 : f8.hashCode())) * 31;
        Float f9 = this.weight;
        if (f9 != null) {
            i = f9.hashCode();
        }
        return hashCode8 + i;
    }

    public String toString() {
        return "IndoorDatapoint(timeInSeconds=" + this.timeInSeconds + ", pm1=" + this.pm1 + ", pm10=" + this.pm10 + ", pm25=" + this.pm25 + ", voc=" + this.voc + ", hcho=" + this.hcho + ", tmp=" + this.tmp + ", hum=" + this.hum + ", fan=" + this.fan + ", weight=" + this.weight + ')';
    }

    public final void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeLong(this.timeInSeconds);
        Float f = this.pm1;
        if (f == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeFloat(f.floatValue());
        }
        Float f2 = this.pm10;
        if (f2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeFloat(f2.floatValue());
        }
        Float f3 = this.pm25;
        if (f3 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeFloat(f3.floatValue());
        }
        Float f4 = this.voc;
        if (f4 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeFloat(f4.floatValue());
        }
        Float f5 = this.hcho;
        if (f5 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeFloat(f5.floatValue());
        }
        Float f6 = this.tmp;
        if (f6 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeFloat(f6.floatValue());
        }
        Float f7 = this.hum;
        if (f7 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeFloat(f7.floatValue());
        }
        Float f8 = this.fan;
        if (f8 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeFloat(f8.floatValue());
        }
        Float f9 = this.weight;
        if (f9 == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcel.writeFloat(f9.floatValue());
    }

    public IndoorDatapoint(long j, Float f, Float f2, Float f3, Float f4, Float f5, Float f6, Float f7, Float f8, Float f9) {
        this.timeInSeconds = j;
        this.pm1 = f;
        this.pm10 = f2;
        this.pm25 = f3;
        this.voc = f4;
        this.hcho = f5;
        this.tmp = f6;
        this.hum = f7;
        this.fan = f8;
        this.weight = f9;
    }

    public final long getTimeInSeconds() {
        return this.timeInSeconds;
    }

    public final Float getPm1() {
        return this.pm1;
    }

    public final Float getPm10() {
        return this.pm10;
    }

    public final Float getPm25() {
        return this.pm25;
    }

    public final Float getVoc() {
        return this.voc;
    }

    public final Float getHcho() {
        return this.hcho;
    }

    public final Float getTmp() {
        return this.tmp;
    }

    public final Float getHum() {
        return this.hum;
    }

    public final Float getFan() {
        return this.fan;
    }

    public final Float getWeight() {
        return this.weight;
    }

    public final Integer getDisinftime() {
        return this.disinftime;
    }

    public final void setDisinftime(Integer num) {
        this.disinftime = num;
    }

    public final long getTimeInMillis() {
        return this.timeInSeconds * ((long) 1000);
    }

    public final Float valueFor(SensorType sensorType) {
        Intrinsics.checkNotNullParameter(sensorType, "sensorType");
        switch (WhenMappings.$EnumSwitchMapping$0[sensorType.ordinal()]) {
            case 1:
                return this.pm1;
            case 2:
                return this.pm10;
            case 3:
                return this.pm25;
            case 4:
                return this.voc;
            case 5:
                return this.hcho;
            case 6:
                return this.hum;
            case 7:
                return this.tmp;
            case 8:
                return this.fan;
            case 9:
                return this.weight;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final boolean isEmpty() {
        return ((Boolean) this.isEmpty$delegate.getValue()).booleanValue();
    }

    /* access modifiers changed from: private */
    public static final boolean isEmpty_delegate$lambda$0(IndoorDatapoint indoorDatapoint) {
        return indoorDatapoint.pm1 == null && indoorDatapoint.pm10 == null && indoorDatapoint.pm25 == null && indoorDatapoint.voc == null && indoorDatapoint.hcho == null && indoorDatapoint.tmp == null && indoorDatapoint.hum == null && indoorDatapoint.fan == null && indoorDatapoint.weight == null && indoorDatapoint.disinftime == null;
    }
}
