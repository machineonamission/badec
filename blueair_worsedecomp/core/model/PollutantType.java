package com.blueair.core.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \b2\u00020\u0001:\b\b\t\n\u000b\f\r\u000e\u000fB\u0011\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0001\u0007\u0010\u0011\u0012\u0013\u0014\u0015\u0016¨\u0006\u0017"}, d2 = {"Lcom/blueair/core/model/PollutantType;", "", "code", "", "<init>", "(I)V", "getCode", "()I", "Companion", "CO", "NO2", "O3", "PM10", "PM25", "SO2", "AQI", "Lcom/blueair/core/model/PollutantType$AQI;", "Lcom/blueair/core/model/PollutantType$CO;", "Lcom/blueair/core/model/PollutantType$NO2;", "Lcom/blueair/core/model/PollutantType$O3;", "Lcom/blueair/core/model/PollutantType$PM10;", "Lcom/blueair/core/model/PollutantType$PM25;", "Lcom/blueair/core/model/PollutantType$SO2;", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: PollutantType.kt */
public abstract class PollutantType {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final int code;

    public /* synthetic */ PollutantType(int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(i);
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\u0005¨\u0006\r"}, d2 = {"Lcom/blueair/core/model/PollutantType$Companion;", "", "<init>", "()V", "fromCode", "Lcom/blueair/core/model/PollutantType;", "code", "", "fromSensorType", "sensorType", "Lcom/blueair/core/model/SensorType;", "toSensorType", "pollutantType", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: PollutantType.kt */
    public static final class Companion {

        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        /* compiled from: PollutantType.kt */
        public static final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            /* JADX WARNING: Failed to process nested try/catch */
            /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
            static {
                /*
                    com.blueair.core.model.SensorType[] r0 = com.blueair.core.model.SensorType.values()
                    int r0 = r0.length
                    int[] r0 = new int[r0]
                    com.blueair.core.model.SensorType r1 = com.blueair.core.model.SensorType.PM25     // Catch:{ NoSuchFieldError -> 0x0010 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                    r2 = 1
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
                L_0x0010:
                    com.blueair.core.model.SensorType r1 = com.blueair.core.model.SensorType.PM10     // Catch:{ NoSuchFieldError -> 0x0019 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                    r2 = 2
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
                L_0x0019:
                    $EnumSwitchMapping$0 = r0
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blueair.core.model.PollutantType.Companion.WhenMappings.<clinit>():void");
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final PollutantType fromCode(int i) {
            if (i == CO.INSTANCE.getCode()) {
                return CO.INSTANCE;
            }
            if (i == NO2.INSTANCE.getCode()) {
                return NO2.INSTANCE;
            }
            if (i == O3.INSTANCE.getCode()) {
                return O3.INSTANCE;
            }
            if (i == PM10.INSTANCE.getCode()) {
                return PM10.INSTANCE;
            }
            if (i == PM25.INSTANCE.getCode()) {
                return PM25.INSTANCE;
            }
            if (i == SO2.INSTANCE.getCode()) {
                return SO2.INSTANCE;
            }
            return AQI.INSTANCE;
        }

        public final PollutantType fromSensorType(SensorType sensorType) {
            Intrinsics.checkNotNullParameter(sensorType, "sensorType");
            int i = WhenMappings.$EnumSwitchMapping$0[sensorType.ordinal()];
            if (i == 1) {
                return PM25.INSTANCE;
            }
            if (i != 2) {
                return null;
            }
            return PM10.INSTANCE;
        }

        public final SensorType toSensorType(PollutantType pollutantType) {
            Intrinsics.checkNotNullParameter(pollutantType, "pollutantType");
            if (Intrinsics.areEqual((Object) pollutantType, (Object) PM25.INSTANCE)) {
                return SensorType.PM25;
            }
            if (Intrinsics.areEqual((Object) pollutantType, (Object) PM10.INSTANCE)) {
                return SensorType.PM10;
            }
            return null;
        }
    }

    private PollutantType(int i) {
        this.code = i;
    }

    public final int getCode() {
        return this.code;
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/core/model/PollutantType$CO;", "Lcom/blueair/core/model/PollutantType;", "<init>", "()V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: PollutantType.kt */
    public static final class CO extends PollutantType {
        public static final CO INSTANCE = new CO();

        private CO() {
            super(0, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/core/model/PollutantType$NO2;", "Lcom/blueair/core/model/PollutantType;", "<init>", "()V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: PollutantType.kt */
    public static final class NO2 extends PollutantType {
        public static final NO2 INSTANCE = new NO2();

        private NO2() {
            super(1, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/core/model/PollutantType$O3;", "Lcom/blueair/core/model/PollutantType;", "<init>", "()V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: PollutantType.kt */
    public static final class O3 extends PollutantType {
        public static final O3 INSTANCE = new O3();

        private O3() {
            super(2, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/core/model/PollutantType$PM10;", "Lcom/blueair/core/model/PollutantType;", "<init>", "()V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: PollutantType.kt */
    public static final class PM10 extends PollutantType {
        public static final PM10 INSTANCE = new PM10();

        private PM10() {
            super(3, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/core/model/PollutantType$PM25;", "Lcom/blueair/core/model/PollutantType;", "<init>", "()V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: PollutantType.kt */
    public static final class PM25 extends PollutantType {
        public static final PM25 INSTANCE = new PM25();

        private PM25() {
            super(4, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/core/model/PollutantType$SO2;", "Lcom/blueair/core/model/PollutantType;", "<init>", "()V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: PollutantType.kt */
    public static final class SO2 extends PollutantType {
        public static final SO2 INSTANCE = new SO2();

        private SO2() {
            super(5, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/core/model/PollutantType$AQI;", "Lcom/blueair/core/model/PollutantType;", "<init>", "()V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: PollutantType.kt */
    public static final class AQI extends PollutantType {
        public static final AQI INSTANCE = new AQI();

        private AQI() {
            super(6, (DefaultConstructorMarker) null);
        }
    }
}
