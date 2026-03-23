package com.blueair.database.entity;

import com.blueair.adddevice.model.AddDeviceState$$ExternalSyntheticBackport0;
import com.blueair.core.model.AqiData;
import com.blueair.core.model.OutdoorPollutants;
import com.blueair.core.model.Pollutant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u0000 02\u00020\u0001:\u00010Bk\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0006\u0010\u001d\u001a\u00020\u001eJ\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\u0010\u0010!\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010#\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010$\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010%\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010&\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010'\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0015Jv\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010)J\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010-\u001a\u00020.HÖ\u0001J\t\u0010/\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0017\u0010\u0015R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0018\u0010\u0015R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0019\u0010\u0015R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u001a\u0010\u0015R\u0015\u0010\f\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u001b\u0010\u0015R\u0015\u0010\r\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u001c\u0010\u0015¨\u00061"}, d2 = {"Lcom/blueair/database/entity/AqiDataEntity;", "", "trackedLocationId", "", "datetime", "", "co", "", "no2", "o3", "pm10", "pm25", "so2", "aqi", "<init>", "(Ljava/lang/String;JLjava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;)V", "getTrackedLocationId", "()Ljava/lang/String;", "getDatetime", "()J", "getCo", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getNo2", "getO3", "getPm10", "getPm25", "getSo2", "getAqi", "toAqiData", "Lcom/blueair/core/model/AqiData;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;JLjava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;)Lcom/blueair/database/entity/AqiDataEntity;", "equals", "", "other", "hashCode", "", "toString", "Companion", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: AqiDataEntity.kt */
public final class AqiDataEntity {
    public static final String AQI_DATA_TABLE = "aqi_data_table";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final Double aqi;
    private final Double co;
    private final long datetime;
    private final Double no2;
    private final Double o3;
    private final Double pm10;
    private final Double pm25;
    private final Double so2;
    private final String trackedLocationId;

    public static /* synthetic */ AqiDataEntity copy$default(AqiDataEntity aqiDataEntity, String str, long j, Double d, Double d2, Double d3, Double d4, Double d5, Double d6, Double d7, int i, Object obj) {
        if ((i & 1) != 0) {
            str = aqiDataEntity.trackedLocationId;
        }
        if ((i & 2) != 0) {
            j = aqiDataEntity.datetime;
        }
        if ((i & 4) != 0) {
            d = aqiDataEntity.co;
        }
        if ((i & 8) != 0) {
            d2 = aqiDataEntity.no2;
        }
        if ((i & 16) != 0) {
            d3 = aqiDataEntity.o3;
        }
        if ((i & 32) != 0) {
            d4 = aqiDataEntity.pm10;
        }
        if ((i & 64) != 0) {
            d5 = aqiDataEntity.pm25;
        }
        if ((i & 128) != 0) {
            d6 = aqiDataEntity.so2;
        }
        if ((i & 256) != 0) {
            d7 = aqiDataEntity.aqi;
        }
        Double d8 = d6;
        Double d9 = d7;
        Double d10 = d5;
        Double d11 = d3;
        Double d12 = d;
        long j2 = j;
        return aqiDataEntity.copy(str, j2, d12, d2, d11, d4, d10, d8, d9);
    }

    public final String component1() {
        return this.trackedLocationId;
    }

    public final long component2() {
        return this.datetime;
    }

    public final Double component3() {
        return this.co;
    }

    public final Double component4() {
        return this.no2;
    }

    public final Double component5() {
        return this.o3;
    }

    public final Double component6() {
        return this.pm10;
    }

    public final Double component7() {
        return this.pm25;
    }

    public final Double component8() {
        return this.so2;
    }

    public final Double component9() {
        return this.aqi;
    }

    public final AqiDataEntity copy(String str, long j, Double d, Double d2, Double d3, Double d4, Double d5, Double d6, Double d7) {
        Intrinsics.checkNotNullParameter(str, "trackedLocationId");
        return new AqiDataEntity(str, j, d, d2, d3, d4, d5, d6, d7);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AqiDataEntity)) {
            return false;
        }
        AqiDataEntity aqiDataEntity = (AqiDataEntity) obj;
        return Intrinsics.areEqual((Object) this.trackedLocationId, (Object) aqiDataEntity.trackedLocationId) && this.datetime == aqiDataEntity.datetime && Intrinsics.areEqual((Object) this.co, (Object) aqiDataEntity.co) && Intrinsics.areEqual((Object) this.no2, (Object) aqiDataEntity.no2) && Intrinsics.areEqual((Object) this.o3, (Object) aqiDataEntity.o3) && Intrinsics.areEqual((Object) this.pm10, (Object) aqiDataEntity.pm10) && Intrinsics.areEqual((Object) this.pm25, (Object) aqiDataEntity.pm25) && Intrinsics.areEqual((Object) this.so2, (Object) aqiDataEntity.so2) && Intrinsics.areEqual((Object) this.aqi, (Object) aqiDataEntity.aqi);
    }

    public int hashCode() {
        int hashCode = ((this.trackedLocationId.hashCode() * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.datetime)) * 31;
        Double d = this.co;
        int i = 0;
        int hashCode2 = (hashCode + (d == null ? 0 : d.hashCode())) * 31;
        Double d2 = this.no2;
        int hashCode3 = (hashCode2 + (d2 == null ? 0 : d2.hashCode())) * 31;
        Double d3 = this.o3;
        int hashCode4 = (hashCode3 + (d3 == null ? 0 : d3.hashCode())) * 31;
        Double d4 = this.pm10;
        int hashCode5 = (hashCode4 + (d4 == null ? 0 : d4.hashCode())) * 31;
        Double d5 = this.pm25;
        int hashCode6 = (hashCode5 + (d5 == null ? 0 : d5.hashCode())) * 31;
        Double d6 = this.so2;
        int hashCode7 = (hashCode6 + (d6 == null ? 0 : d6.hashCode())) * 31;
        Double d7 = this.aqi;
        if (d7 != null) {
            i = d7.hashCode();
        }
        return hashCode7 + i;
    }

    public String toString() {
        return "AqiDataEntity(trackedLocationId=" + this.trackedLocationId + ", datetime=" + this.datetime + ", co=" + this.co + ", no2=" + this.no2 + ", o3=" + this.o3 + ", pm10=" + this.pm10 + ", pm25=" + this.pm25 + ", so2=" + this.so2 + ", aqi=" + this.aqi + ')';
    }

    public AqiDataEntity(String str, long j, Double d, Double d2, Double d3, Double d4, Double d5, Double d6, Double d7) {
        Intrinsics.checkNotNullParameter(str, "trackedLocationId");
        this.trackedLocationId = str;
        this.datetime = j;
        this.co = d;
        this.no2 = d2;
        this.o3 = d3;
        this.pm10 = d4;
        this.pm25 = d5;
        this.so2 = d6;
        this.aqi = d7;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ AqiDataEntity(java.lang.String r2, long r3, java.lang.Double r5, java.lang.Double r6, java.lang.Double r7, java.lang.Double r8, java.lang.Double r9, java.lang.Double r10, java.lang.Double r11, int r12, kotlin.jvm.internal.DefaultConstructorMarker r13) {
        /*
            r1 = this;
            r13 = r12 & 4
            r0 = 0
            if (r13 == 0) goto L_0x0006
            r5 = r0
        L_0x0006:
            r13 = r12 & 8
            if (r13 == 0) goto L_0x000b
            r6 = r0
        L_0x000b:
            r13 = r12 & 16
            if (r13 == 0) goto L_0x0010
            r7 = r0
        L_0x0010:
            r13 = r12 & 32
            if (r13 == 0) goto L_0x0015
            r8 = r0
        L_0x0015:
            r13 = r12 & 64
            if (r13 == 0) goto L_0x001a
            r9 = r0
        L_0x001a:
            r13 = r12 & 128(0x80, float:1.794E-43)
            if (r13 == 0) goto L_0x001f
            r10 = r0
        L_0x001f:
            r12 = r12 & 256(0x100, float:3.59E-43)
            if (r12 == 0) goto L_0x0025
            r12 = r0
            goto L_0x0026
        L_0x0025:
            r12 = r11
        L_0x0026:
            r11 = r10
            r10 = r9
            r9 = r8
            r8 = r7
            r7 = r6
            r6 = r5
            r4 = r3
            r3 = r2
            r2 = r1
            r2.<init>(r3, r4, r6, r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.database.entity.AqiDataEntity.<init>(java.lang.String, long, java.lang.Double, java.lang.Double, java.lang.Double, java.lang.Double, java.lang.Double, java.lang.Double, java.lang.Double, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getTrackedLocationId() {
        return this.trackedLocationId;
    }

    public final long getDatetime() {
        return this.datetime;
    }

    public final Double getCo() {
        return this.co;
    }

    public final Double getNo2() {
        return this.no2;
    }

    public final Double getO3() {
        return this.o3;
    }

    public final Double getPm10() {
        return this.pm10;
    }

    public final Double getPm25() {
        return this.pm25;
    }

    public final Double getSo2() {
        return this.so2;
    }

    public final Double getAqi() {
        return this.aqi;
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/blueair/database/entity/AqiDataEntity$Companion;", "", "<init>", "()V", "AQI_DATA_TABLE", "", "fromTrackedLocationData", "Lcom/blueair/database/entity/AqiDataEntity;", "aqiData", "Lcom/blueair/core/model/AqiData;", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AqiDataEntity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0016, code lost:
            r0 = r0.getCo();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final com.blueair.database.entity.AqiDataEntity fromTrackedLocationData(com.blueair.core.model.AqiData r13) {
            /*
                r12 = this;
                java.lang.String r0 = "aqiData"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
                com.blueair.database.entity.AqiDataEntity r1 = new com.blueair.database.entity.AqiDataEntity
                java.lang.String r2 = r13.getLocationId()
                long r3 = r13.getDatetime()
                com.blueair.core.model.OutdoorPollutants r0 = r13.getPollutants()
                r5 = 0
                if (r0 == 0) goto L_0x0021
                com.blueair.core.model.Pollutant r0 = r0.getCo()
                if (r0 == 0) goto L_0x0021
                java.lang.Double r0 = r0.getConcentration()
                goto L_0x0022
            L_0x0021:
                r0 = r5
            L_0x0022:
                com.blueair.core.model.OutdoorPollutants r6 = r13.getPollutants()
                if (r6 == 0) goto L_0x0033
                com.blueair.core.model.Pollutant r6 = r6.getNo2()
                if (r6 == 0) goto L_0x0033
                java.lang.Double r6 = r6.getConcentration()
                goto L_0x0034
            L_0x0033:
                r6 = r5
            L_0x0034:
                com.blueair.core.model.OutdoorPollutants r7 = r13.getPollutants()
                if (r7 == 0) goto L_0x0045
                com.blueair.core.model.Pollutant r7 = r7.getO3()
                if (r7 == 0) goto L_0x0045
                java.lang.Double r7 = r7.getConcentration()
                goto L_0x0046
            L_0x0045:
                r7 = r5
            L_0x0046:
                com.blueair.core.model.OutdoorPollutants r8 = r13.getPollutants()
                if (r8 == 0) goto L_0x0057
                com.blueair.core.model.Pollutant r8 = r8.getPm10()
                if (r8 == 0) goto L_0x0057
                java.lang.Double r8 = r8.getConcentration()
                goto L_0x0058
            L_0x0057:
                r8 = r5
            L_0x0058:
                com.blueair.core.model.OutdoorPollutants r9 = r13.getPollutants()
                if (r9 == 0) goto L_0x0069
                com.blueair.core.model.Pollutant r9 = r9.getPm25()
                if (r9 == 0) goto L_0x0069
                java.lang.Double r9 = r9.getConcentration()
                goto L_0x006a
            L_0x0069:
                r9 = r5
            L_0x006a:
                com.blueair.core.model.OutdoorPollutants r10 = r13.getPollutants()
                if (r10 == 0) goto L_0x007b
                com.blueair.core.model.Pollutant r10 = r10.getSo2()
                if (r10 == 0) goto L_0x007b
                java.lang.Double r10 = r10.getConcentration()
                goto L_0x007c
            L_0x007b:
                r10 = r5
            L_0x007c:
                com.blueair.core.model.OutdoorPollutants r13 = r13.getPollutants()
                if (r13 == 0) goto L_0x008c
                com.blueair.core.model.Pollutant r13 = r13.getAqi()
                if (r13 == 0) goto L_0x008c
                java.lang.Double r5 = r13.getConcentration()
            L_0x008c:
                r11 = r5
                r5 = r0
                r1.<init>(r2, r3, r5, r6, r7, r8, r9, r10, r11)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.database.entity.AqiDataEntity.Companion.fromTrackedLocationData(com.blueair.core.model.AqiData):com.blueair.database.entity.AqiDataEntity");
        }
    }

    public final AqiData toAqiData() {
        return new AqiData(this.trackedLocationId, this.datetime, new OutdoorPollutants(new Pollutant(this.co), new Pollutant(this.no2), new Pollutant(this.o3), new Pollutant(this.pm10), new Pollutant(this.pm25), new Pollutant(this.so2), new Pollutant(this.aqi)));
    }
}
