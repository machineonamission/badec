package com.blueair.core.model;

import com.blueair.core.model.IOutdoorPollutants;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001BC\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003JQ\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020$HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0016\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u001d\u0010\u0012\u001a\u0004\u0018\u00010\u00038VX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0013\u0010\f¨\u0006%"}, d2 = {"Lcom/blueair/core/model/BreezoMeterOutdoorPollutants;", "Lcom/blueair/core/model/IOutdoorPollutants;", "co", "Lcom/blueair/core/model/Pollutant;", "no2", "o3", "pm10", "pm25", "so2", "<init>", "(Lcom/blueair/core/model/Pollutant;Lcom/blueair/core/model/Pollutant;Lcom/blueair/core/model/Pollutant;Lcom/blueair/core/model/Pollutant;Lcom/blueair/core/model/Pollutant;Lcom/blueair/core/model/Pollutant;)V", "getCo", "()Lcom/blueair/core/model/Pollutant;", "getNo2", "getO3", "getPm10", "getPm25", "getSo2", "co_ppb", "getCo_ppb", "co_ppb$delegate", "Lkotlin/Lazy;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: AqiData.kt */
public final class BreezoMeterOutdoorPollutants implements IOutdoorPollutants {
    private final Pollutant co;
    private final Lazy co_ppb$delegate = LazyKt.lazy(new BreezoMeterOutdoorPollutants$$ExternalSyntheticLambda0(this));
    private final Pollutant no2;
    private final Pollutant o3;
    private final Pollutant pm10;
    private final Pollutant pm25;
    private final Pollutant so2;

    public static /* synthetic */ BreezoMeterOutdoorPollutants copy$default(BreezoMeterOutdoorPollutants breezoMeterOutdoorPollutants, Pollutant pollutant, Pollutant pollutant2, Pollutant pollutant3, Pollutant pollutant4, Pollutant pollutant5, Pollutant pollutant6, int i, Object obj) {
        if ((i & 1) != 0) {
            pollutant = breezoMeterOutdoorPollutants.co;
        }
        if ((i & 2) != 0) {
            pollutant2 = breezoMeterOutdoorPollutants.no2;
        }
        if ((i & 4) != 0) {
            pollutant3 = breezoMeterOutdoorPollutants.o3;
        }
        if ((i & 8) != 0) {
            pollutant4 = breezoMeterOutdoorPollutants.pm10;
        }
        if ((i & 16) != 0) {
            pollutant5 = breezoMeterOutdoorPollutants.pm25;
        }
        if ((i & 32) != 0) {
            pollutant6 = breezoMeterOutdoorPollutants.so2;
        }
        Pollutant pollutant7 = pollutant5;
        Pollutant pollutant8 = pollutant6;
        Pollutant pollutant9 = pollutant4;
        Pollutant pollutant10 = pollutant2;
        return breezoMeterOutdoorPollutants.copy(pollutant, pollutant10, pollutant3, pollutant9, pollutant7, pollutant8);
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

    public final BreezoMeterOutdoorPollutants copy(Pollutant pollutant, Pollutant pollutant2, Pollutant pollutant3, Pollutant pollutant4, Pollutant pollutant5, Pollutant pollutant6) {
        return new BreezoMeterOutdoorPollutants(pollutant, pollutant2, pollutant3, pollutant4, pollutant5, pollutant6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BreezoMeterOutdoorPollutants)) {
            return false;
        }
        BreezoMeterOutdoorPollutants breezoMeterOutdoorPollutants = (BreezoMeterOutdoorPollutants) obj;
        return Intrinsics.areEqual((Object) this.co, (Object) breezoMeterOutdoorPollutants.co) && Intrinsics.areEqual((Object) this.no2, (Object) breezoMeterOutdoorPollutants.no2) && Intrinsics.areEqual((Object) this.o3, (Object) breezoMeterOutdoorPollutants.o3) && Intrinsics.areEqual((Object) this.pm10, (Object) breezoMeterOutdoorPollutants.pm10) && Intrinsics.areEqual((Object) this.pm25, (Object) breezoMeterOutdoorPollutants.pm25) && Intrinsics.areEqual((Object) this.so2, (Object) breezoMeterOutdoorPollutants.so2);
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
        if (pollutant6 != null) {
            i = pollutant6.hashCode();
        }
        return hashCode5 + i;
    }

    public String toString() {
        return "BreezoMeterOutdoorPollutants(co=" + this.co + ", no2=" + this.no2 + ", o3=" + this.o3 + ", pm10=" + this.pm10 + ", pm25=" + this.pm25 + ", so2=" + this.so2 + ')';
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

    public BreezoMeterOutdoorPollutants(Pollutant pollutant, Pollutant pollutant2, Pollutant pollutant3, Pollutant pollutant4, Pollutant pollutant5, Pollutant pollutant6) {
        this.co = pollutant;
        this.no2 = pollutant2;
        this.o3 = pollutant3;
        this.pm10 = pollutant4;
        this.pm25 = pollutant5;
        this.so2 = pollutant6;
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

    public Pollutant getCo_ppb() {
        return (Pollutant) this.co_ppb$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final Pollutant co_ppb_delegate$lambda$1(BreezoMeterOutdoorPollutants breezoMeterOutdoorPollutants) {
        Double concentration;
        Pollutant pollutant = breezoMeterOutdoorPollutants.co;
        if (pollutant == null || (concentration = pollutant.getConcentration()) == null) {
            return null;
        }
        return breezoMeterOutdoorPollutants.co.copy(Double.valueOf(concentration.doubleValue() / ((double) 1000)));
    }
}
