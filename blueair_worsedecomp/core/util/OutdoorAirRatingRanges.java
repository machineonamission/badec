package com.blueair.core.util;

import com.blueair.core.model.PollutantType;
import com.blueair.core.util.OutdoorRanges;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0013\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%J\u0016\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010$\u001a\u00020%J\u000e\u0010*\u001a\u00020'2\u0006\u0010$\u001a\u00020%R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007R\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0007R\u0011\u0010\u0010\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0007R\u0011\u0010\u0012\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0007R\u0011\u0010\u0014\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0007R\u0011\u0010\u0016\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0007R\u0011\u0010\u0018\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0007R\u0011\u0010\u001a\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0007R\u0011\u0010\u001c\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0007R\u0011\u0010\u001e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0007R\u0011\u0010 \u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0007¨\u0006+"}, d2 = {"Lcom/blueair/core/util/OutdoorAirRatingRanges;", "", "<init>", "()V", "PM25_LOW", "", "getPM25_LOW", "()[D", "PM25_HIGH", "getPM25_HIGH", "PM10_LOW", "getPM10_LOW", "PM10_HIGH", "getPM10_HIGH", "O3_LOW", "getO3_LOW", "O3_HIGH", "getO3_HIGH", "SO2_LOW", "getSO2_LOW", "SO2_HIGH", "getSO2_HIGH", "CO_LOW", "getCO_LOW", "CO_HIGH", "getCO_HIGH", "NO2_LOW", "getNO2_LOW", "NO2_HIGH", "getNO2_HIGH", "AQI_LOW", "getAQI_LOW", "AQI_HIGH", "getAQI_HIGH", "airRatingsFor", "Lcom/blueair/core/util/OutdoorRanges;", "pollutantType", "Lcom/blueair/core/model/PollutantType;", "getPollutantRangePosition", "", "value", "", "getMaxPollutantRangePosition", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: OutdoorRangeUtils.kt */
public final class OutdoorAirRatingRanges {
    private static final double[] AQI_HIGH = {50.0d, 100.0d, 150.0d, 200.0d, 500.0d};
    private static final double[] AQI_LOW = {0.0d, 51.0d, 101.0d, 151.0d, 201.0d};
    private static final double[] CO_HIGH = {4.4d, 9.4d, 12.4d, 15.4d, 30.4d, 50.4d};
    private static final double[] CO_LOW = {0.0d, 4.5d, 9.5d, 12.5d, 15.5d, 30.5d};
    public static final OutdoorAirRatingRanges INSTANCE = new OutdoorAirRatingRanges();
    private static final double[] NO2_HIGH = {53.0d, 100.0d, 360.0d, 649.0d, 1249.0d, 2049.0d};
    private static final double[] NO2_LOW = {0.0d, 54.0d, 101.0d, 361.0d, 650.0d, 1250.0d};
    private static final double[] O3_HIGH = {59.0d, 75.0d, 95.0d, 115.0d, 374.0d, 604.0d};
    private static final double[] O3_LOW = {0.0d, 60.0d, 76.0d, 96.0d, 116.0d, 375.0d};
    private static final double[] PM10_HIGH = {20.0d, 50.0d, 70.0d, 100.0d, 400.0d, 600.0d};
    private static final double[] PM10_LOW = {0.0d, 21.0d, 51.0d, 71.0d, 101.0d, 401.0d};
    private static final double[] PM25_HIGH = {12.0d, 35.4d, 55.4d, 150.4d, 250.4d, 500.4d};
    private static final double[] PM25_LOW = {0.0d, 12.1d, 35.5d, 55.5d, 150.5d, 250.5d};
    private static final double[] SO2_HIGH = {35.0d, 75.0d, 185.0d, 304.0d, 604.0d, 1004.0d};
    private static final double[] SO2_LOW = {0.0d, 36.0d, 76.0d, 186.0d, 305.0d, 605.0d};

    private OutdoorAirRatingRanges() {
    }

    public final double[] getPM25_LOW() {
        return PM25_LOW;
    }

    public final double[] getPM25_HIGH() {
        return PM25_HIGH;
    }

    public final double[] getPM10_LOW() {
        return PM10_LOW;
    }

    public final double[] getPM10_HIGH() {
        return PM10_HIGH;
    }

    public final double[] getO3_LOW() {
        return O3_LOW;
    }

    public final double[] getO3_HIGH() {
        return O3_HIGH;
    }

    public final double[] getSO2_LOW() {
        return SO2_LOW;
    }

    public final double[] getSO2_HIGH() {
        return SO2_HIGH;
    }

    public final double[] getCO_LOW() {
        return CO_LOW;
    }

    public final double[] getCO_HIGH() {
        return CO_HIGH;
    }

    public final double[] getNO2_LOW() {
        return NO2_LOW;
    }

    public final double[] getNO2_HIGH() {
        return NO2_HIGH;
    }

    public final double[] getAQI_LOW() {
        return AQI_LOW;
    }

    public final double[] getAQI_HIGH() {
        return AQI_HIGH;
    }

    public final OutdoorRanges airRatingsFor(PollutantType pollutantType) {
        Intrinsics.checkNotNullParameter(pollutantType, "pollutantType");
        if (Intrinsics.areEqual((Object) pollutantType, (Object) PollutantType.AQI.INSTANCE)) {
            return OutdoorRanges.AQI.INSTANCE;
        }
        if (Intrinsics.areEqual((Object) pollutantType, (Object) PollutantType.CO.INSTANCE)) {
            return OutdoorRanges.CO.INSTANCE;
        }
        if (Intrinsics.areEqual((Object) pollutantType, (Object) PollutantType.NO2.INSTANCE)) {
            return OutdoorRanges.NO2.INSTANCE;
        }
        if (Intrinsics.areEqual((Object) pollutantType, (Object) PollutantType.O3.INSTANCE)) {
            return OutdoorRanges.O3.INSTANCE;
        }
        if (Intrinsics.areEqual((Object) pollutantType, (Object) PollutantType.PM10.INSTANCE)) {
            return OutdoorRanges.PM10.INSTANCE;
        }
        if (Intrinsics.areEqual((Object) pollutantType, (Object) PollutantType.PM25.INSTANCE)) {
            return OutdoorRanges.PM25.INSTANCE;
        }
        if (Intrinsics.areEqual((Object) pollutantType, (Object) PollutantType.SO2.INSTANCE)) {
            return OutdoorRanges.SO2.INSTANCE;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final int getPollutantRangePosition(float f, PollutantType pollutantType) {
        Intrinsics.checkNotNullParameter(pollutantType, "pollutantType");
        double[] high = airRatingsFor(pollutantType).getHigh();
        int length = high.length;
        for (int i = 0; i < length; i++) {
            if (((double) f) <= high[i]) {
                return i;
            }
        }
        return -1;
    }

    public final int getMaxPollutantRangePosition(PollutantType pollutantType) {
        Intrinsics.checkNotNullParameter(pollutantType, "pollutantType");
        return airRatingsFor(pollutantType).getHigh().length - 1;
    }
}
