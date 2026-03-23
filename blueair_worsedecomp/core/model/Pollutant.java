package com.blueair.core.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J\u001a\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/blueair/core/model/Pollutant;", "", "concentration", "", "<init>", "(Ljava/lang/Double;)V", "getConcentration", "()Ljava/lang/Double;", "Ljava/lang/Double;", "component1", "copy", "(Ljava/lang/Double;)Lcom/blueair/core/model/Pollutant;", "equals", "", "other", "hashCode", "", "toString", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: AqiData.kt */
public final class Pollutant {
    private final Double concentration;

    public static /* synthetic */ Pollutant copy$default(Pollutant pollutant, Double d, int i, Object obj) {
        if ((i & 1) != 0) {
            d = pollutant.concentration;
        }
        return pollutant.copy(d);
    }

    public final Double component1() {
        return this.concentration;
    }

    public final Pollutant copy(Double d) {
        return new Pollutant(d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Pollutant) && Intrinsics.areEqual((Object) this.concentration, (Object) ((Pollutant) obj).concentration);
    }

    public int hashCode() {
        Double d = this.concentration;
        if (d == null) {
            return 0;
        }
        return d.hashCode();
    }

    public String toString() {
        return "Pollutant(concentration=" + this.concentration + ')';
    }

    public Pollutant(Double d) {
        this.concentration = d;
    }

    public final Double getConcentration() {
        return this.concentration;
    }
}
