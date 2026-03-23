package com.blueair.core.util;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0013\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0007\n\u000b\f\r\u000e\u000f\u0010B\u0019\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b\u0001\u0007\u0011\u0012\u0013\u0014\u0015\u0016\u0017¨\u0006\u0018"}, d2 = {"Lcom/blueair/core/util/OutdoorRanges;", "", "low", "", "high", "<init>", "([D[D)V", "getLow", "()[D", "getHigh", "AQI", "CO", "NO2", "O3", "PM10", "PM25", "SO2", "Lcom/blueair/core/util/OutdoorRanges$AQI;", "Lcom/blueair/core/util/OutdoorRanges$CO;", "Lcom/blueair/core/util/OutdoorRanges$NO2;", "Lcom/blueair/core/util/OutdoorRanges$O3;", "Lcom/blueair/core/util/OutdoorRanges$PM10;", "Lcom/blueair/core/util/OutdoorRanges$PM25;", "Lcom/blueair/core/util/OutdoorRanges$SO2;", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: OutdoorRangeUtils.kt */
public abstract class OutdoorRanges {
    private final double[] high;
    private final double[] low;

    public /* synthetic */ OutdoorRanges(double[] dArr, double[] dArr2, DefaultConstructorMarker defaultConstructorMarker) {
        this(dArr, dArr2);
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/core/util/OutdoorRanges$AQI;", "Lcom/blueair/core/util/OutdoorRanges;", "<init>", "()V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: OutdoorRangeUtils.kt */
    public static final class AQI extends OutdoorRanges {
        public static final AQI INSTANCE = new AQI();

        private AQI() {
            super(OutdoorAirRatingRanges.INSTANCE.getAQI_LOW(), OutdoorAirRatingRanges.INSTANCE.getAQI_HIGH(), (DefaultConstructorMarker) null);
        }
    }

    private OutdoorRanges(double[] dArr, double[] dArr2) {
        this.low = dArr;
        this.high = dArr2;
    }

    public final double[] getHigh() {
        return this.high;
    }

    public final double[] getLow() {
        return this.low;
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/core/util/OutdoorRanges$CO;", "Lcom/blueair/core/util/OutdoorRanges;", "<init>", "()V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: OutdoorRangeUtils.kt */
    public static final class CO extends OutdoorRanges {
        public static final CO INSTANCE = new CO();

        private CO() {
            super(OutdoorAirRatingRanges.INSTANCE.getCO_LOW(), OutdoorAirRatingRanges.INSTANCE.getCO_HIGH(), (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/core/util/OutdoorRanges$NO2;", "Lcom/blueair/core/util/OutdoorRanges;", "<init>", "()V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: OutdoorRangeUtils.kt */
    public static final class NO2 extends OutdoorRanges {
        public static final NO2 INSTANCE = new NO2();

        private NO2() {
            super(OutdoorAirRatingRanges.INSTANCE.getNO2_LOW(), OutdoorAirRatingRanges.INSTANCE.getNO2_HIGH(), (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/core/util/OutdoorRanges$O3;", "Lcom/blueair/core/util/OutdoorRanges;", "<init>", "()V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: OutdoorRangeUtils.kt */
    public static final class O3 extends OutdoorRanges {
        public static final O3 INSTANCE = new O3();

        private O3() {
            super(OutdoorAirRatingRanges.INSTANCE.getO3_LOW(), OutdoorAirRatingRanges.INSTANCE.getO3_HIGH(), (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/core/util/OutdoorRanges$PM10;", "Lcom/blueair/core/util/OutdoorRanges;", "<init>", "()V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: OutdoorRangeUtils.kt */
    public static final class PM10 extends OutdoorRanges {
        public static final PM10 INSTANCE = new PM10();

        private PM10() {
            super(OutdoorAirRatingRanges.INSTANCE.getPM10_LOW(), OutdoorAirRatingRanges.INSTANCE.getPM10_HIGH(), (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/core/util/OutdoorRanges$PM25;", "Lcom/blueair/core/util/OutdoorRanges;", "<init>", "()V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: OutdoorRangeUtils.kt */
    public static final class PM25 extends OutdoorRanges {
        public static final PM25 INSTANCE = new PM25();

        private PM25() {
            super(OutdoorAirRatingRanges.INSTANCE.getPM25_LOW(), OutdoorAirRatingRanges.INSTANCE.getPM25_HIGH(), (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/core/util/OutdoorRanges$SO2;", "Lcom/blueair/core/util/OutdoorRanges;", "<init>", "()V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: OutdoorRangeUtils.kt */
    public static final class SO2 extends OutdoorRanges {
        public static final SO2 INSTANCE = new SO2();

        private SO2() {
            super(OutdoorAirRatingRanges.INSTANCE.getSO2_LOW(), OutdoorAirRatingRanges.INSTANCE.getSO2_HIGH(), (DefaultConstructorMarker) null);
        }
    }
}
