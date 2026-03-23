package com.blueair.core.model;

import com.blueair.core.util.OutdoorRangeUtils;
import com.blueair.core.util.OutdoorRanges;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0013\u001a\u00020\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0011H\u0016J\b\u0010\u0015\u001a\u00020\u0011H\u0016J\b\u0010\u0016\u001a\u00020\u0011H\u0016J\u000f\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0002\u0010\u0019R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0014\u0010\b\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0005R\u0014\u0010\n\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0005R\u0014\u0010\f\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0005R\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0005¨\u0006\u001aÀ\u0006\u0003"}, d2 = {"Lcom/blueair/core/model/IOutdoorPollutants;", "", "co_ppb", "Lcom/blueair/core/model/Pollutant;", "getCo_ppb", "()Lcom/blueair/core/model/Pollutant;", "no2", "getNo2", "o3", "getO3", "pm10", "getPm10", "pm25", "getPm25", "so2", "getSo2", "getNo2AQI", "", "getPm10AQI", "getPm25AQI", "getSo2AQI", "getCoAQI", "getO3AQI", "getCalculatedAQI", "", "()Ljava/lang/Double;", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: AqiData.kt */
public interface IOutdoorPollutants {
    Double getCalculatedAQI();

    int getCoAQI();

    Pollutant getCo_ppb();

    Pollutant getNo2();

    int getNo2AQI();

    Pollutant getO3();

    int getO3AQI();

    Pollutant getPm10();

    int getPm10AQI();

    Pollutant getPm25();

    int getPm25AQI();

    Pollutant getSo2();

    int getSo2AQI();

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AqiData.kt */
    public static final class DefaultImpls {
        @Deprecated
        public static int getNo2AQI(IOutdoorPollutants iOutdoorPollutants) {
            return CC.$default$getNo2AQI(iOutdoorPollutants);
        }

        @Deprecated
        public static int getPm10AQI(IOutdoorPollutants iOutdoorPollutants) {
            return CC.$default$getPm10AQI(iOutdoorPollutants);
        }

        @Deprecated
        public static int getPm25AQI(IOutdoorPollutants iOutdoorPollutants) {
            return CC.$default$getPm25AQI(iOutdoorPollutants);
        }

        @Deprecated
        public static int getSo2AQI(IOutdoorPollutants iOutdoorPollutants) {
            return CC.$default$getSo2AQI(iOutdoorPollutants);
        }

        @Deprecated
        public static int getCoAQI(IOutdoorPollutants iOutdoorPollutants) {
            return CC.$default$getCoAQI(iOutdoorPollutants);
        }

        @Deprecated
        public static int getO3AQI(IOutdoorPollutants iOutdoorPollutants) {
            return CC.$default$getO3AQI(iOutdoorPollutants);
        }

        @Deprecated
        public static Double getCalculatedAQI(IOutdoorPollutants iOutdoorPollutants) {
            return CC.$default$getCalculatedAQI(iOutdoorPollutants);
        }
    }

    /* renamed from: com.blueair.core.model.IOutdoorPollutants$-CC  reason: invalid class name */
    /* compiled from: AqiData.kt */
    public final /* synthetic */ class CC {
        public static int $default$getNo2AQI(IOutdoorPollutants _this) {
            OutdoorRangeUtils outdoorRangeUtils = OutdoorRangeUtils.INSTANCE;
            Pollutant no2 = _this.getNo2();
            return outdoorRangeUtils.convertMeasurementToiAQI(no2 != null ? no2.getConcentration() : null, OutdoorRanges.NO2.INSTANCE.getLow(), OutdoorRanges.NO2.INSTANCE.getHigh());
        }

        public static int $default$getPm10AQI(IOutdoorPollutants _this) {
            OutdoorRangeUtils outdoorRangeUtils = OutdoorRangeUtils.INSTANCE;
            Pollutant pm10 = _this.getPm10();
            return outdoorRangeUtils.convertMeasurementToiAQI(pm10 != null ? pm10.getConcentration() : null, OutdoorRanges.PM10.INSTANCE.getLow(), OutdoorRanges.PM10.INSTANCE.getHigh());
        }

        public static int $default$getPm25AQI(IOutdoorPollutants _this) {
            OutdoorRangeUtils outdoorRangeUtils = OutdoorRangeUtils.INSTANCE;
            Pollutant pm25 = _this.getPm25();
            return outdoorRangeUtils.convertMeasurementToiAQI(pm25 != null ? pm25.getConcentration() : null, OutdoorRanges.PM25.INSTANCE.getLow(), OutdoorRanges.PM25.INSTANCE.getHigh());
        }

        public static int $default$getSo2AQI(IOutdoorPollutants _this) {
            OutdoorRangeUtils outdoorRangeUtils = OutdoorRangeUtils.INSTANCE;
            Pollutant so2 = _this.getSo2();
            return outdoorRangeUtils.convertMeasurementToiAQI(so2 != null ? so2.getConcentration() : null, OutdoorRanges.SO2.INSTANCE.getLow(), OutdoorRanges.SO2.INSTANCE.getHigh());
        }

        public static int $default$getCoAQI(IOutdoorPollutants _this) {
            OutdoorRangeUtils outdoorRangeUtils = OutdoorRangeUtils.INSTANCE;
            Pollutant co_ppb = _this.getCo_ppb();
            return outdoorRangeUtils.convertMeasurementToiAQI(co_ppb != null ? co_ppb.getConcentration() : null, OutdoorRanges.CO.INSTANCE.getLow(), OutdoorRanges.CO.INSTANCE.getHigh());
        }

        public static int $default$getO3AQI(IOutdoorPollutants _this) {
            OutdoorRangeUtils outdoorRangeUtils = OutdoorRangeUtils.INSTANCE;
            Pollutant o3 = _this.getO3();
            return outdoorRangeUtils.convertMeasurementToiAQI(o3 != null ? o3.getConcentration() : null, OutdoorRanges.O3.INSTANCE.getLow(), OutdoorRanges.O3.INSTANCE.getHigh());
        }

        public static Double $default$getCalculatedAQI(IOutdoorPollutants _this) {
            return Double.valueOf((double) OutdoorRangeUtils.INSTANCE.getAQIFromIndividualAQI(new int[]{_this.getNo2AQI(), _this.getPm10AQI(), _this.getPm25AQI(), _this.getSo2AQI(), _this.getCoAQI(), _this.getO3AQI()}));
        }
    }
}
