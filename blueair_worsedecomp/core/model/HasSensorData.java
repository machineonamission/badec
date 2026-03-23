package com.blueair.core.model;

import android.content.Context;
import com.blueair.core.model.Device;
import com.blueair.core.util.IndoorAirRatingRanges;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0013\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u0017H\u0016J\u0012\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010\"\u001a\u00020\u0017H\u0016J\u001a\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020&2\u0006\u0010\"\u001a\u00020\u0017H\u0016J\u0010\u0010'\u001a\u00020(2\u0006\u0010\"\u001a\u00020\u0017H\u0016R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0012\u0010\u0010\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\rR\u0012\u0010\u0012\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\rR\u0012\u0010\u0014\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\rR\u001a\u0010\u0016\u001a\u00020\u00178VX\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001d8VX\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\u0019\u001a\u0004\b\u001f\u0010 ¨\u0006)À\u0006\u0003"}, d2 = {"Lcom/blueair/core/model/HasSensorData;", "Lcom/blueair/core/model/Device;", "latestSensorDatapoint", "Lcom/blueair/core/model/IndoorDatapoint;", "getLatestSensorDatapoint", "()Lcom/blueair/core/model/IndoorDatapoint;", "lastSelectedSensorTypeIndex", "", "getLastSelectedSensorTypeIndex", "()I", "pm1Ranges", "", "getPm1Ranges", "()[D", "pm10Ranges", "getPm10Ranges", "pm25Ranges", "getPm25Ranges", "vocRanges", "getVocRanges", "hchoRanges", "getHchoRanges", "lastSelectedSensorType", "Lcom/blueair/core/model/SensorType;", "getLastSelectedSensorType$annotations", "()V", "getLastSelectedSensorType", "()Lcom/blueair/core/model/SensorType;", "airRatingRanges", "Lcom/blueair/core/util/IndoorAirRatingRanges;", "getAirRatingRanges$annotations", "getAirRatingRanges", "()Lcom/blueair/core/util/IndoorAirRatingRanges;", "airRatingsFor", "sensorType", "aqiFor", "Lcom/blueair/core/util/IndoorAirRatingRanges$IndoorAirRating;", "sensorValue", "", "supports", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: Device.kt */
public interface HasSensorData extends Device {

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: Device.kt */
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
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.core.model.HasSensorData.WhenMappings.<clinit>():void");
        }
    }

    double[] airRatingsFor(SensorType sensorType);

    IndoorAirRatingRanges.IndoorAirRating aqiFor(double d, SensorType sensorType);

    IndoorAirRatingRanges.IndoorAirRating aqiFor(SensorType sensorType);

    IndoorAirRatingRanges getAirRatingRanges();

    double[] getHchoRanges();

    SensorType getLastSelectedSensorType();

    int getLastSelectedSensorTypeIndex();

    IndoorDatapoint getLatestSensorDatapoint();

    double[] getPm10Ranges();

    double[] getPm1Ranges();

    double[] getPm25Ranges();

    double[] getVocRanges();

    boolean supports(SensorType sensorType);

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: Device.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ void getAirRatingRanges$annotations() {
        }

        public static /* synthetic */ void getLastSelectedSensorType$annotations() {
        }

        @Deprecated
        public static ConnectivityStatus getConnectivityStatus(HasSensorData hasSensorData) {
            return Device.CC.$default$getConnectivityStatus(hasSensorData);
        }

        @Deprecated
        public static TimeZone getTimezone(HasSensorData hasSensorData, Context context) {
            return Device.CC.$default$getTimezone(hasSensorData, context);
        }

        @Deprecated
        public static DeviceType getType(HasSensorData hasSensorData) {
            return Device.CC.$default$getType(hasSensorData);
        }

        @Deprecated
        public static boolean isOnline(HasSensorData hasSensorData) {
            return Device.CC.$default$isOnline(hasSensorData);
        }

        @Deprecated
        public static boolean isUsDevice(HasSensorData hasSensorData) {
            return Device.CC.$default$isUsDevice(hasSensorData);
        }

        @Deprecated
        public static SensorType getLastSelectedSensorType(HasSensorData hasSensorData) {
            return CC.$default$getLastSelectedSensorType(hasSensorData);
        }

        @Deprecated
        public static IndoorAirRatingRanges getAirRatingRanges(HasSensorData hasSensorData) {
            return CC.$default$getAirRatingRanges(hasSensorData);
        }

        @Deprecated
        public static double[] airRatingsFor(HasSensorData hasSensorData, SensorType sensorType) {
            Intrinsics.checkNotNullParameter(sensorType, "sensorType");
            return CC.$default$airRatingsFor(hasSensorData, sensorType);
        }

        @Deprecated
        public static IndoorAirRatingRanges.IndoorAirRating aqiFor(HasSensorData hasSensorData, SensorType sensorType) {
            Intrinsics.checkNotNullParameter(sensorType, "sensorType");
            return CC.$default$aqiFor(hasSensorData, sensorType);
        }

        @Deprecated
        public static IndoorAirRatingRanges.IndoorAirRating aqiFor(HasSensorData hasSensorData, double d, SensorType sensorType) {
            Intrinsics.checkNotNullParameter(sensorType, "sensorType");
            return CC.$default$aqiFor(hasSensorData, d, sensorType);
        }

        @Deprecated
        public static boolean supports(HasSensorData hasSensorData, SensorType sensorType) {
            Intrinsics.checkNotNullParameter(sensorType, "sensorType");
            return CC.$default$supports(hasSensorData, sensorType);
        }
    }

    /* renamed from: com.blueair.core.model.HasSensorData$-CC  reason: invalid class name */
    /* compiled from: Device.kt */
    public final /* synthetic */ class CC {
        public static SensorType $default$getLastSelectedSensorType(HasSensorData _this) {
            SensorType sensorType = SensorType.values()[_this.getLastSelectedSensorTypeIndex()];
            if (_this.supports(sensorType)) {
                return sensorType;
            }
            return SensorType.PM25;
        }

        public static IndoorAirRatingRanges $default$getAirRatingRanges(HasSensorData _this) {
            return IndoorAirRatingRanges.Companion.instance(_this);
        }

        public static double[] $default$airRatingsFor(HasSensorData _this, SensorType sensorType) {
            Intrinsics.checkNotNullParameter(sensorType, "sensorType");
            switch (WhenMappings.$EnumSwitchMapping$0[sensorType.ordinal()]) {
                case 1:
                    return _this.getAirRatingRanges().getPm1Ranges();
                case 2:
                    return _this.getAirRatingRanges().getPm10Ranges();
                case 3:
                    return _this.getAirRatingRanges().getPm25Ranges();
                case 4:
                    return _this.getAirRatingRanges().getVocRanges();
                case 5:
                    return _this.getAirRatingRanges().getHchoRanges();
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

        public static IndoorAirRatingRanges.IndoorAirRating $default$aqiFor(HasSensorData _this, SensorType sensorType) {
            Intrinsics.checkNotNullParameter(sensorType, "sensorType");
            return _this.getAirRatingRanges().rating(_this, sensorType);
        }

        public static IndoorAirRatingRanges.IndoorAirRating $default$aqiFor(HasSensorData _this, double d, SensorType sensorType) {
            Intrinsics.checkNotNullParameter(sensorType, "sensorType");
            return _this.getAirRatingRanges().rating(d, sensorType);
        }

        public static boolean $default$supports(HasSensorData _this, SensorType sensorType) {
            Intrinsics.checkNotNullParameter(sensorType, "sensorType");
            switch (WhenMappings.$EnumSwitchMapping$0[sensorType.ordinal()]) {
                case 1:
                    return ((_this instanceof DeviceClassic) && ((DeviceClassic) _this).getHasNewSensors()) || (_this instanceof DeviceG4) || (_this instanceof DeviceB4sp) || (_this instanceof DeviceBluePremium) || (_this instanceof DeviceNewClassic) || (_this instanceof DevicePet20) || ((_this instanceof DeviceBlue40) && !((DeviceBlue40) _this).isMediumSize());
                case 2:
                    return ((_this instanceof DeviceClassic) && ((DeviceClassic) _this).getHasNewSensors()) || (_this instanceof DeviceG4) || (_this instanceof DeviceB4sp) || (_this instanceof DeviceBluePremium) || (_this instanceof DeviceNewClassic) || (_this instanceof DevicePet20) || ((_this instanceof DeviceBlue40) && !((DeviceBlue40) _this).isMediumSize());
                case 3:
                    return DeviceKt.hasAirFilter(_this);
                case 4:
                    if (_this instanceof DeviceBlue40) {
                        return ((DeviceBlue40) _this).isMediumSize();
                    }
                    if (_this instanceof DeviceG4) {
                        DeviceG4 deviceG4 = (DeviceG4) _this;
                        if (deviceG4.isPlus()) {
                            return CollectionsKt.contains(DeviceType.Companion.getG4Plus_tVOC_SKU(), deviceG4.getSku());
                        }
                        return true;
                    } else if (_this instanceof DeviceNewClassic) {
                        return StringsKt.endsWith$default(((DeviceNewClassic) _this).getModelName(), "CP9i", false, 2, (Object) null);
                    } else {
                        return !(_this instanceof DeviceHumidifier20) && !(_this instanceof DeviceCombo2in1) && !(_this instanceof DeviceIcp) && !(_this instanceof DeviceB4) && !(_this instanceof DeviceBlue) && !(_this instanceof DeviceBluePremium) && !(_this instanceof DeviceHumidifier) && !(_this instanceof DeviceDehumidifier);
                    }
                case 5:
                    if (_this instanceof DeviceG4) {
                        DeviceG4 deviceG42 = (DeviceG4) _this;
                        return deviceG42.isPlus() && CollectionsKt.contains(DeviceType.Companion.getG4Plus_HCHO_SKU(), deviceG42.getSku());
                    }
                case 6:
                    return !(_this instanceof DeviceIcp) && !(_this instanceof DeviceB4) && !(_this instanceof DeviceBlue) && !(_this instanceof DeviceBluePremium) && !(_this instanceof DeviceNewClassic) && !(_this instanceof DeviceBlue40) && !(_this instanceof DevicePet20);
                case 7:
                    return !(_this instanceof DeviceIcp) && !(_this instanceof DeviceB4) && !(_this instanceof DeviceBlue) && !(_this instanceof DeviceBluePremium) && !(_this instanceof DeviceNewClassic) && !(_this instanceof DeviceBlue40) && !(_this instanceof DevicePet20);
                case 8:
                    return false;
                case 9:
                    return _this instanceof DevicePet20;
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }
    }
}
