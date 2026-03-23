package com.blueair.core.util;

import android.os.Parcel;
import android.os.Parcelable;
import com.blueair.core.model.DeviceBlue40;
import com.blueair.core.model.DeviceIcp;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.DevicePet20;
import com.blueair.core.model.HasSensorData;
import com.blueair.core.model.IndoorDatapoint;
import com.blueair.core.model.SensorType;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0013\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 ,2\u00020\u0001:\u0002,-B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0014\u001a\u00020\u0015J\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\u0015J\u0016\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\u001c2\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0015J\u0016\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0019\u001a\u00020\u001c2\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010 \u001a\u00020\u001f2\u0006\u0010\u0014\u001a\u00020\u0015J*\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u001f0\"2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00150$2\b\u0010%\u001a\u0004\u0018\u00010\u0018J\u0006\u0010&\u001a\u00020\u001fJ\u0016\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u001fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006."}, d2 = {"Lcom/blueair/core/util/IndoorAirRatingRanges;", "Landroid/os/Parcelable;", "pm1Ranges", "", "pm10Ranges", "pm25Ranges", "vocRanges", "hchoRanges", "<init>", "([D[D[D[D[D)V", "getPm1Ranges", "()[D", "getPm10Ranges", "getPm25Ranges", "getVocRanges", "getHchoRanges", "rating", "Lcom/blueair/core/util/IndoorAirRatingRanges$IndoorAirRating;", "device", "Lcom/blueair/core/model/HasSensorData;", "sensorType", "Lcom/blueair/core/model/SensorType;", "ratingFromDatapoint", "dataPoint", "Lcom/blueair/core/model/IndoorDatapoint;", "value", "", "ratingValue", "", "airRatingsFor", "getRangePosition", "", "numberOfRangesFor", "voteWorstRating", "Lkotlin/Pair;", "sensorTypes", "", "indoorDatapoint", "describeContents", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "IndoorAirRating", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: IndoorAirRatingRanges.kt */
public final class IndoorAirRatingRanges implements Parcelable {
    public static final Parcelable.Creator<IndoorAirRatingRanges> CREATOR = new Creator();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final double[] HCHO_RANGES_DEFAULT = {399.0d, 799.0d, 1499.0d, 1999.0d, 9999.0d};
    /* access modifiers changed from: private */
    public static final double[] PM10_RANGES_DEFAULT = {20.0d, 50.0d, 70.0d, 100.0d, 999.0d};
    /* access modifiers changed from: private */
    public static final double[] PM1_RANGES_DEFAULT = {8.0d, 20.0d, 28.0d, 40.0d, 999.0d};
    /* access modifiers changed from: private */
    public static final double[] PM25_RANGES_G4 = {10.0d, 25.0d, 35.0d, 50.0d, 999.0d};
    /* access modifiers changed from: private */
    public static final double[] PM25_RANGES_ICP = {15.0d, 30.0d, 40.0d, 79.0d, 999.0d};
    /* access modifiers changed from: private */
    public static final double[] PM25_RANGES_LEGACY = {9.0d, 35.0d, 150.0d, 300.0d, 999.0d};
    /* access modifiers changed from: private */
    public static final double[] VOC_RANGES_G4 = {150.0d, 275.0d, 375.0d, 450.0d, 999.0d};
    /* access modifiers changed from: private */
    public static final double[] VOC_RANGES_LEGACY = {220.0d, 450.0d, 702.0d, 900.0d, 999.0d};
    private final double[] hchoRanges;
    private final double[] pm10Ranges;
    private final double[] pm1Ranges;
    private final double[] pm25Ranges;
    private final double[] vocRanges;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: IndoorAirRatingRanges.kt */
    public static final class Creator implements Parcelable.Creator<IndoorAirRatingRanges> {
        public final IndoorAirRatingRanges createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new IndoorAirRatingRanges(parcel.createDoubleArray(), parcel.createDoubleArray(), parcel.createDoubleArray(), parcel.createDoubleArray(), parcel.createDoubleArray());
        }

        public final IndoorAirRatingRanges[] newArray(int i) {
            return new IndoorAirRatingRanges[i];
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: IndoorAirRatingRanges.kt */
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
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.core.util.IndoorAirRatingRanges.WhenMappings.<clinit>():void");
        }
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeDoubleArray(this.pm1Ranges);
        parcel.writeDoubleArray(this.pm10Ranges);
        parcel.writeDoubleArray(this.pm25Ranges);
        parcel.writeDoubleArray(this.vocRanges);
        parcel.writeDoubleArray(this.hchoRanges);
    }

    public IndoorAirRatingRanges(double[] dArr, double[] dArr2, double[] dArr3, double[] dArr4, double[] dArr5) {
        Intrinsics.checkNotNullParameter(dArr, "pm1Ranges");
        Intrinsics.checkNotNullParameter(dArr2, "pm10Ranges");
        Intrinsics.checkNotNullParameter(dArr3, "pm25Ranges");
        Intrinsics.checkNotNullParameter(dArr4, "vocRanges");
        Intrinsics.checkNotNullParameter(dArr5, "hchoRanges");
        this.pm1Ranges = dArr;
        this.pm10Ranges = dArr2;
        this.pm25Ranges = dArr3;
        this.vocRanges = dArr4;
        this.hchoRanges = dArr5;
    }

    public final double[] getPm1Ranges() {
        return this.pm1Ranges;
    }

    public final double[] getPm10Ranges() {
        return this.pm10Ranges;
    }

    public final double[] getPm25Ranges() {
        return this.pm25Ranges;
    }

    public final double[] getVocRanges() {
        return this.vocRanges;
    }

    public final double[] getHchoRanges() {
        return this.hchoRanges;
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0013\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010\u0018\u001a\u00020\u0019R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007R\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0007R\u0011\u0010\u0010\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0007R\u0011\u0010\u0012\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0007R\u0011\u0010\u0014\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0007¨\u0006\u001d"}, d2 = {"Lcom/blueair/core/util/IndoorAirRatingRanges$Companion;", "", "<init>", "()V", "PM1_RANGES_DEFAULT", "", "getPM1_RANGES_DEFAULT", "()[D", "PM25_RANGES_G4", "getPM25_RANGES_G4", "PM25_RANGES_LEGACY", "getPM25_RANGES_LEGACY", "PM25_RANGES_ICP", "getPM25_RANGES_ICP", "PM10_RANGES_DEFAULT", "getPM10_RANGES_DEFAULT", "VOC_RANGES_G4", "getVOC_RANGES_G4", "VOC_RANGES_LEGACY", "getVOC_RANGES_LEGACY", "HCHO_RANGES_DEFAULT", "getHCHO_RANGES_DEFAULT", "instance", "Lcom/blueair/core/util/IndoorAirRatingRanges;", "device", "Lcom/blueair/core/model/HasSensorData;", "getAirRatingSensors", "", "Lcom/blueair/core/model/SensorType;", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: IndoorAirRatingRanges.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final double[] getPM1_RANGES_DEFAULT() {
            return IndoorAirRatingRanges.PM1_RANGES_DEFAULT;
        }

        public final double[] getPM25_RANGES_G4() {
            return IndoorAirRatingRanges.PM25_RANGES_G4;
        }

        public final double[] getPM25_RANGES_LEGACY() {
            return IndoorAirRatingRanges.PM25_RANGES_LEGACY;
        }

        public final double[] getPM25_RANGES_ICP() {
            return IndoorAirRatingRanges.PM25_RANGES_ICP;
        }

        public final double[] getPM10_RANGES_DEFAULT() {
            return IndoorAirRatingRanges.PM10_RANGES_DEFAULT;
        }

        public final double[] getVOC_RANGES_G4() {
            return IndoorAirRatingRanges.VOC_RANGES_G4;
        }

        public final double[] getVOC_RANGES_LEGACY() {
            return IndoorAirRatingRanges.VOC_RANGES_LEGACY;
        }

        public final double[] getHCHO_RANGES_DEFAULT() {
            return IndoorAirRatingRanges.HCHO_RANGES_DEFAULT;
        }

        public final IndoorAirRatingRanges instance(HasSensorData hasSensorData) {
            double[] dArr;
            double[] dArr2;
            double[] pm25_ranges_legacy;
            double[] voc_ranges_legacy;
            Intrinsics.checkNotNullParameter(hasSensorData, "device");
            boolean isG4orB4orNB = DeviceKt.isG4orB4orNB(hasSensorData);
            boolean z = true;
            if (!(hasSensorData.getPm1Ranges().length == 0)) {
                dArr = hasSensorData.getPm1Ranges();
            } else {
                dArr = getPM1_RANGES_DEFAULT();
            }
            double[] dArr3 = dArr;
            if (!(hasSensorData.getPm10Ranges().length == 0)) {
                dArr2 = hasSensorData.getPm10Ranges();
            } else {
                dArr2 = getPM10_RANGES_DEFAULT();
            }
            double[] dArr4 = dArr2;
            if (!(hasSensorData.getPm25Ranges().length == 0)) {
                pm25_ranges_legacy = hasSensorData.getPm25Ranges();
            } else if (isG4orB4orNB) {
                pm25_ranges_legacy = getPM25_RANGES_G4();
            } else if (hasSensorData instanceof DeviceIcp) {
                pm25_ranges_legacy = getPM25_RANGES_ICP();
            } else {
                pm25_ranges_legacy = getPM25_RANGES_LEGACY();
            }
            double[] dArr5 = pm25_ranges_legacy;
            Timber.Forest.d("IndoorAirRatingRanges: pm25Ranges = " + ArraysKt.toList(dArr5), new Object[0]);
            if (!(hasSensorData.getVocRanges().length == 0)) {
                voc_ranges_legacy = hasSensorData.getVocRanges();
            } else if (isG4orB4orNB) {
                voc_ranges_legacy = getVOC_RANGES_G4();
            } else {
                voc_ranges_legacy = getVOC_RANGES_LEGACY();
            }
            double[] dArr6 = voc_ranges_legacy;
            if (hasSensorData.getHchoRanges().length != 0) {
                z = false;
            }
            return new IndoorAirRatingRanges(dArr3, dArr4, dArr5, dArr6, !z ? hasSensorData.getHchoRanges() : getHCHO_RANGES_DEFAULT());
        }

        public final List<SensorType> getAirRatingSensors(HasSensorData hasSensorData) {
            Intrinsics.checkNotNullParameter(hasSensorData, "device");
            if (hasSensorData instanceof DevicePet20) {
                return CollectionsKt.listOf(SensorType.PM25, SensorType.PM1, SensorType.PM10, SensorType.VOC);
            } else if (!(hasSensorData instanceof DeviceBlue40) || !((DeviceBlue40) hasSensorData).useTVOCForAqi()) {
                return CollectionsKt.listOf(SensorType.PM25);
            } else {
                return CollectionsKt.listOf(SensorType.PM25, SensorType.VOC);
            }
        }
    }

    public final IndoorAirRating rating(HasSensorData hasSensorData, SensorType sensorType) {
        Float valueFor;
        Intrinsics.checkNotNullParameter(hasSensorData, "device");
        Intrinsics.checkNotNullParameter(sensorType, "sensorType");
        IndoorDatapoint latestSensorDatapoint = hasSensorData.getLatestSensorDatapoint();
        if (latestSensorDatapoint == null || (valueFor = latestSensorDatapoint.valueFor(sensorType)) == null) {
            return null;
        }
        return rating((double) valueFor.floatValue(), sensorType);
    }

    public final IndoorAirRating ratingFromDatapoint(IndoorDatapoint indoorDatapoint, SensorType sensorType) {
        Intrinsics.checkNotNullParameter(indoorDatapoint, "dataPoint");
        Intrinsics.checkNotNullParameter(sensorType, "sensorType");
        Float valueFor = indoorDatapoint.valueFor(sensorType);
        if (valueFor != null) {
            return rating((double) valueFor.floatValue(), sensorType);
        }
        return null;
    }

    public final IndoorAirRating rating(double d, SensorType sensorType) {
        double[] dArr;
        Intrinsics.checkNotNullParameter(sensorType, "sensorType");
        if (sensorType != SensorType.HUM) {
            int i = WhenMappings.$EnumSwitchMapping$0[sensorType.ordinal()];
            if (i == 1) {
                dArr = this.pm1Ranges;
            } else if (i == 2) {
                dArr = this.pm10Ranges;
            } else if (i == 3) {
                dArr = this.pm25Ranges;
            } else if (i == 4) {
                dArr = this.vocRanges;
            } else if (i != 5) {
                return null;
            } else {
                dArr = this.hchoRanges;
            }
            int i2 = 0;
            for (double d2 : dArr) {
                if (d > d2) {
                    i2++;
                }
            }
            Timber.Forest.v("Rating for " + sensorType + ", " + d + " is index " + i2, new Object[0]);
            IndoorAirRating fromIndex = IndoorAirRating.Companion.fromIndex(i2);
            return fromIndex == null ? IndoorAirRating.VERY_POLLUTED.INSTANCE : fromIndex;
        } else if (d <= 10.0d) {
            return IndoorAirRating.POLLUTED.INSTANCE;
        } else {
            if (11.0d <= d && d <= 29.0d) {
                return IndoorAirRating.MODERATE.INSTANCE;
            }
            if (30.0d <= d && d <= 50.0d) {
                return IndoorAirRating.EXCELLENT.INSTANCE;
            }
            if (51.0d <= d && d <= 70.0d) {
                return IndoorAirRating.MODERATE.INSTANCE;
            }
            if (71.0d > d || d > 100.0d) {
                return null;
            }
            return IndoorAirRating.POLLUTED.INSTANCE;
        }
    }

    public final float ratingValue(float f, SensorType sensorType) {
        double[] dArr;
        Intrinsics.checkNotNullParameter(sensorType, "sensorType");
        if (sensorType != SensorType.HUM) {
            int i = WhenMappings.$EnumSwitchMapping$0[sensorType.ordinal()];
            if (i == 1) {
                dArr = this.pm1Ranges;
            } else if (i == 2) {
                dArr = this.pm10Ranges;
            } else if (i == 3) {
                dArr = this.pm25Ranges;
            } else if (i == 4) {
                dArr = this.vocRanges;
            } else if (i != 5) {
                return 50.0f;
            } else {
                dArr = this.hchoRanges;
            }
            int length = dArr.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    i2 = -1;
                    break;
                }
                if (((double) f) <= dArr[i2]) {
                    break;
                }
                i2++;
            }
            if (i2 == 0) {
                return 0.0f;
            }
            if (i2 == 1) {
                return ratingValue$calculateScaledValue(dArr, f, i2, 25.0f, 0.0f);
            }
            if (i2 == 2) {
                return ratingValue$calculateScaledValue(dArr, f, i2, 25.0f, 25.0f);
            }
            if (i2 == 3) {
                return ratingValue$calculateScaledValue(dArr, f, i2, 25.0f, 50.0f);
            }
            if (i2 != 4) {
                return 100.0f;
            }
            return ratingValue$calculateScaledValue(dArr, f, i2, 25.0f, 75.0f);
        } else if (f <= 10.0f) {
            float f2 = (float) 10;
            return (((f2 - f) / f2) * ((float) 25)) + ((float) 50);
        } else if (f < 30.0f) {
            float f3 = (float) 20;
            float f4 = (f3 - (f - ((float) 10))) / f3;
            float f5 = (float) 25;
            return (f4 * f5) + f5;
        } else if (f <= 50.0f) {
            return (Math.abs(f - ((float) 40)) / ((float) 10)) * ((float) 25);
        } else {
            if (f > 70.0f) {
                return (((f - ((float) 70)) / ((float) 30)) * ((float) 25)) + ((float) 50);
            }
            float f6 = (float) 25;
            return (((f - ((float) 50)) / ((float) 20)) * f6) + f6;
        }
    }

    private static final float ratingValue$calculateScaledValue(double[] dArr, float f, int i, float f2, float f3) {
        double d = dArr[i];
        double d2 = dArr[i - 1];
        return (float) ((((((double) f) - d2) / (d - d2)) * ((double) f2)) + ((double) f3));
    }

    public final double[] airRatingsFor(SensorType sensorType) {
        Intrinsics.checkNotNullParameter(sensorType, "sensorType");
        switch (WhenMappings.$EnumSwitchMapping$0[sensorType.ordinal()]) {
            case 1:
                return this.pm1Ranges;
            case 2:
                return this.pm10Ranges;
            case 3:
                return this.pm25Ranges;
            case 4:
                return this.vocRanges;
            case 5:
                return this.hchoRanges;
            case 6:
                return new double[0];
            case 7:
                return new double[0];
            case 8:
                return new double[0];
            case 9:
                return new double[0];
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final int getRangePosition(float f, SensorType sensorType) {
        Intrinsics.checkNotNullParameter(sensorType, "sensorType");
        double[] airRatingsFor = airRatingsFor(sensorType);
        int length = airRatingsFor.length;
        for (int i = 0; i < length; i++) {
            if (((double) f) <= airRatingsFor[i]) {
                return i;
            }
        }
        return -1;
    }

    public final int numberOfRangesFor(SensorType sensorType) {
        Intrinsics.checkNotNullParameter(sensorType, "sensorType");
        return airRatingsFor(sensorType).length;
    }

    public final Pair<SensorType, Integer> voteWorstRating(List<? extends SensorType> list, IndoorDatapoint indoorDatapoint) {
        int i;
        IndoorAirRating rating;
        Intrinsics.checkNotNullParameter(list, "sensorTypes");
        Pair<SensorType, Integer> pair = new Pair<>(SensorType.PM25, -1);
        for (SensorType sensorType : list) {
            Float valueFor = indoorDatapoint != null ? indoorDatapoint.valueFor(sensorType) : null;
            if (valueFor == null || (rating = rating((double) valueFor.floatValue(), sensorType)) == null) {
                i = -1;
            } else {
                i = rating.getRating();
            }
            if (pair.getSecond().intValue() <= i) {
                pair = new Pair<>(sensorType, Integer.valueOf(i));
            }
        }
        return pair;
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \b2\u00020\u0001:\u0006\b\t\n\u000b\f\rB\u0011\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0001\u0005\u000e\u000f\u0010\u0011\u0012¨\u0006\u0013"}, d2 = {"Lcom/blueair/core/util/IndoorAirRatingRanges$IndoorAirRating;", "", "rating", "", "<init>", "(I)V", "getRating", "()I", "Companion", "EXCELLENT", "GOOD", "MODERATE", "POLLUTED", "VERY_POLLUTED", "Lcom/blueair/core/util/IndoorAirRatingRanges$IndoorAirRating$EXCELLENT;", "Lcom/blueair/core/util/IndoorAirRatingRanges$IndoorAirRating$GOOD;", "Lcom/blueair/core/util/IndoorAirRatingRanges$IndoorAirRating$MODERATE;", "Lcom/blueair/core/util/IndoorAirRatingRanges$IndoorAirRating$POLLUTED;", "Lcom/blueair/core/util/IndoorAirRatingRanges$IndoorAirRating$VERY_POLLUTED;", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: IndoorAirRatingRanges.kt */
    public static abstract class IndoorAirRating {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final int rating;

        public /* synthetic */ IndoorAirRating(int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(i);
        }

        private IndoorAirRating(int i) {
            this.rating = i;
        }

        public final int getRating() {
            return this.rating;
        }

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\u0007H\u0002¨\u0006\n"}, d2 = {"Lcom/blueair/core/util/IndoorAirRatingRanges$IndoorAirRating$Companion;", "", "<init>", "()V", "fromIndex", "Lcom/blueair/core/util/IndoorAirRatingRanges$IndoorAirRating;", "index", "", "fromRating", "rating", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* compiled from: IndoorAirRatingRanges.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final IndoorAirRating fromIndex(int i) {
                return fromRating(i);
            }

            private final IndoorAirRating fromRating(int i) {
                if (i == EXCELLENT.INSTANCE.getRating()) {
                    return EXCELLENT.INSTANCE;
                }
                if (i == GOOD.INSTANCE.getRating()) {
                    return GOOD.INSTANCE;
                }
                if (i == MODERATE.INSTANCE.getRating()) {
                    return MODERATE.INSTANCE;
                }
                if (i == POLLUTED.INSTANCE.getRating()) {
                    return POLLUTED.INSTANCE;
                }
                if (i == VERY_POLLUTED.INSTANCE.getRating()) {
                    return VERY_POLLUTED.INSTANCE;
                }
                return null;
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/core/util/IndoorAirRatingRanges$IndoorAirRating$EXCELLENT;", "Lcom/blueair/core/util/IndoorAirRatingRanges$IndoorAirRating;", "<init>", "()V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* compiled from: IndoorAirRatingRanges.kt */
        public static final class EXCELLENT extends IndoorAirRating {
            public static final EXCELLENT INSTANCE = new EXCELLENT();

            private EXCELLENT() {
                super(0, (DefaultConstructorMarker) null);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/core/util/IndoorAirRatingRanges$IndoorAirRating$GOOD;", "Lcom/blueair/core/util/IndoorAirRatingRanges$IndoorAirRating;", "<init>", "()V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* compiled from: IndoorAirRatingRanges.kt */
        public static final class GOOD extends IndoorAirRating {
            public static final GOOD INSTANCE = new GOOD();

            private GOOD() {
                super(1, (DefaultConstructorMarker) null);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/core/util/IndoorAirRatingRanges$IndoorAirRating$MODERATE;", "Lcom/blueair/core/util/IndoorAirRatingRanges$IndoorAirRating;", "<init>", "()V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* compiled from: IndoorAirRatingRanges.kt */
        public static final class MODERATE extends IndoorAirRating {
            public static final MODERATE INSTANCE = new MODERATE();

            private MODERATE() {
                super(2, (DefaultConstructorMarker) null);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/core/util/IndoorAirRatingRanges$IndoorAirRating$POLLUTED;", "Lcom/blueair/core/util/IndoorAirRatingRanges$IndoorAirRating;", "<init>", "()V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* compiled from: IndoorAirRatingRanges.kt */
        public static final class POLLUTED extends IndoorAirRating {
            public static final POLLUTED INSTANCE = new POLLUTED();

            private POLLUTED() {
                super(3, (DefaultConstructorMarker) null);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/core/util/IndoorAirRatingRanges$IndoorAirRating$VERY_POLLUTED;", "Lcom/blueair/core/util/IndoorAirRatingRanges$IndoorAirRating;", "<init>", "()V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* compiled from: IndoorAirRatingRanges.kt */
        public static final class VERY_POLLUTED extends IndoorAirRating {
            public static final VERY_POLLUTED INSTANCE = new VERY_POLLUTED();

            private VERY_POLLUTED() {
                super(4, (DefaultConstructorMarker) null);
            }
        }
    }
}
