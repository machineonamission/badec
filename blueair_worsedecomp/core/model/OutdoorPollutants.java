package com.blueair.core.model;

import com.blueair.core.model.IOutdoorPollutants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001BM\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J]\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020%HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0016\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\r¨\u0006&"}, d2 = {"Lcom/blueair/core/model/OutdoorPollutants;", "Lcom/blueair/core/model/IOutdoorPollutants;", "co", "Lcom/blueair/core/model/Pollutant;", "no2", "o3", "pm10", "pm25", "so2", "aqi", "<init>", "(Lcom/blueair/core/model/Pollutant;Lcom/blueair/core/model/Pollutant;Lcom/blueair/core/model/Pollutant;Lcom/blueair/core/model/Pollutant;Lcom/blueair/core/model/Pollutant;Lcom/blueair/core/model/Pollutant;Lcom/blueair/core/model/Pollutant;)V", "getCo", "()Lcom/blueair/core/model/Pollutant;", "getNo2", "getO3", "getPm10", "getPm25", "getSo2", "getAqi", "co_ppb", "getCo_ppb", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: AqiData.kt */
public final class OutdoorPollutants implements IOutdoorPollutants {
    private final Pollutant aqi;
    private final Pollutant co;
    private final Pollutant no2;
    private final Pollutant o3;
    private final Pollutant pm10;
    private final Pollutant pm25;
    private final Pollutant so2;

    public static /* synthetic */ OutdoorPollutants copy$default(OutdoorPollutants outdoorPollutants, Pollutant pollutant, Pollutant pollutant2, Pollutant pollutant3, Pollutant pollutant4, Pollutant pollutant5, Pollutant pollutant6, Pollutant pollutant7, int i, Object obj) {
        if ((i & 1) != 0) {
            pollutant = outdoorPollutants.co;
        }
        if ((i & 2) != 0) {
            pollutant2 = outdoorPollutants.no2;
        }
        if ((i & 4) != 0) {
            pollutant3 = outdoorPollutants.o3;
        }
        if ((i & 8) != 0) {
            pollutant4 = outdoorPollutants.pm10;
        }
        if ((i & 16) != 0) {
            pollutant5 = outdoorPollutants.pm25;
        }
        if ((i & 32) != 0) {
            pollutant6 = outdoorPollutants.so2;
        }
        if ((i & 64) != 0) {
            pollutant7 = outdoorPollutants.aqi;
        }
        Pollutant pollutant8 = pollutant6;
        Pollutant pollutant9 = pollutant7;
        Pollutant pollutant10 = pollutant4;
        Pollutant pollutant11 = pollutant5;
        return outdoorPollutants.copy(pollutant, pollutant2, pollutant3, pollutant10, pollutant11, pollutant8, pollutant9);
    }

    public final Pollutant component1() {
        return this.co;
    }

    public final Pollutant component2() {
        return this.no2;
    }

    public final Pollutant component3() {
        return this.o3;
    }

    public final Pollutant component4() {
        return this.pm10;
    }

    public final Pollutant component5() {
        return this.pm25;
    }

    public final Pollutant component6() {
        return this.so2;
    }

    public final Pollutant component7() {
        return this.aqi;
    }

    public final OutdoorPollutants copy(Pollutant pollutant, Pollutant pollutant2, Pollutant pollutant3, Pollutant pollutant4, Pollutant pollutant5, Pollutant pollutant6, Pollutant pollutant7) {
        return new OutdoorPollutants(pollutant, pollutant2, pollutant3, pollutant4, pollutant5, pollutant6, pollutant7);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OutdoorPollutants)) {
            return false;
        }
        OutdoorPollutants outdoorPollutants = (OutdoorPollutants) obj;
        return Intrinsics.areEqual((Object) this.co, (Object) outdoorPollutants.co) && Intrinsics.areEqual((Object) this.no2, (Object) outdoorPollutants.no2) && Intrinsics.areEqual((Object) this.o3, (Object) outdoorPollutants.o3) && Intrinsics.areEqual((Object) this.pm10, (Object) outdoorPollutants.pm10) && Intrinsics.areEqual((Object) this.pm25, (Object) outdoorPollutants.pm25) && Intrinsics.areEqual((Object) this.so2, (Object) outdoorPollutants.so2) && Intrinsics.areEqual((Object) this.aqi, (Object) outdoorPollutants.aqi);
    }

    public int hashCode() {
        Pollutant pollutant = this.co;
        int i = 0;
        int hashCode = (pollutant == null ? 0 : pollutant.hashCode()) * 31;
        Pollutant pollutant2 = this.no2;
        int hashCode2 = (hashCode + (pollutant2 == null ? 0 : pollutant2.hashCode())) * 31;
        Pollutant pollutant3 = this.o3;
        int hashCode3 = (hashCode2 + (pollutant3 == null ? 0 : pollutant3.hashCode())) * 31;
        Pollutant pollutant4 = this.pm10;
        int hashCode4 = (hashCode3 + (pollutant4 == null ? 0 : pollutant4.hashCode())) * 31;
        Pollutant pollutant5 = this.pm25;
        int hashCode5 = (hashCode4 + (pollutant5 == null ? 0 : pollutant5.hashCode())) * 31;
        Pollutant pollutant6 = this.so2;
        int hashCode6 = (hashCode5 + (pollutant6 == null ? 0 : pollutant6.hashCode())) * 31;
        Pollutant pollutant7 = this.aqi;
        if (pollutant7 != null) {
            i = pollutant7.hashCode();
        }
        return hashCode6 + i;
    }

    public String toString() {
        return "OutdoorPollutants(co=" + this.co + ", no2=" + this.no2 + ", o3=" + this.o3 + ", pm10=" + this.pm10 + ", pm25=" + this.pm25 + ", so2=" + this.so2 + ", aqi=" + this.aqi + ')';
    }

    public Double getCalculatedAQI() {
        return IOutdoorPollutants.CC.$default$getCalculatedAQI(this);
    }

    public int getCoAQI() {
        return IOutdoorPollutants.CC.$default$getCoAQI(this);
    }

    public int getNo2AQI() {
        return IOutdoorPollutants.CC.$default$getNo2AQI(this);
    }

    public int getO3AQI() {
        return IOutdoorPollutants.CC.$default$getO3AQI(this);
    }

    public int getPm10AQI() {
        return IOutdoorPollutants.CC.$default$getPm10AQI(this);
    }

    public int getPm25AQI() {
        return IOutdoorPollutants.CC.$default$getPm25AQI(this);
    }

    public int getSo2AQI() {
        return IOutdoorPollutants.CC.$default$getSo2AQI(this);
    }

    public OutdoorPollutants(Pollutant pollutant, Pollutant pollutant2, Pollutant pollutant3, Pollutant pollutant4, Pollutant pollutant5, Pollutant pollutant6, Pollutant pollutant7) {
        this.co = pollutant;
        this.no2 = pollutant2;
        this.o3 = pollutant3;
        this.pm10 = pollutant4;
        this.pm25 = pollutant5;
        this.so2 = pollutant6;
        this.aqi = pollutant7;
    }

    public final Pollutant getCo() {
        return this.co;
    }

    public Pollutant getNo2() {
        return this.no2;
    }

    public Pollutant getO3() {
        return this.o3;
    }

    public Pollutant getPm10() {
        return this.pm10;
    }

    public Pollutant getPm25() {
        return this.pm25;
    }

    public Pollutant getSo2() {
        return this.so2;
    }

    public final Pollutant getAqi() {
        return this.aqi;
    }

    public Pollutant getCo_ppb() {
        return this.co;
    }
}
