package com.blueair.auth;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/blueair/auth/OptInOptOut;", "", "BRAND_XX_BH8488_EML", "Lcom/blueair/auth/BrandXxBh8488Eml;", "unilever", "Lcom/blueair/auth/Unilever;", "<init>", "(Lcom/blueair/auth/BrandXxBh8488Eml;Lcom/blueair/auth/Unilever;)V", "getBRAND_XX_BH8488_EML", "()Lcom/blueair/auth/BrandXxBh8488Eml;", "getUnilever", "()Lcom/blueair/auth/Unilever;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "auth_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: GigyaService.kt */
public final class OptInOptOut {
    private final BrandXxBh8488Eml BRAND_XX_BH8488_EML;
    private final Unilever unilever;

    public static /* synthetic */ OptInOptOut copy$default(OptInOptOut optInOptOut, BrandXxBh8488Eml brandXxBh8488Eml, Unilever unilever2, int i, Object obj) {
        if ((i & 1) != 0) {
            brandXxBh8488Eml = optInOptOut.BRAND_XX_BH8488_EML;
        }
        if ((i & 2) != 0) {
            unilever2 = optInOptOut.unilever;
        }
        return optInOptOut.copy(brandXxBh8488Eml, unilever2);
    }

    public final BrandXxBh8488Eml component1() {
        return this.BRAND_XX_BH8488_EML;
    }

    public final Unilever component2() {
        return this.unilever;
    }

    public final OptInOptOut copy(BrandXxBh8488Eml brandXxBh8488Eml, Unilever unilever2) {
        Intrinsics.checkNotNullParameter(brandXxBh8488Eml, "BRAND_XX_BH8488_EML");
        Intrinsics.checkNotNullParameter(unilever2, "unilever");
        return new OptInOptOut(brandXxBh8488Eml, unilever2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OptInOptOut)) {
            return false;
        }
        OptInOptOut optInOptOut = (OptInOptOut) obj;
        return Intrinsics.areEqual((Object) this.BRAND_XX_BH8488_EML, (Object) optInOptOut.BRAND_XX_BH8488_EML) && Intrinsics.areEqual((Object) this.unilever, (Object) optInOptOut.unilever);
    }

    public int hashCode() {
        return (this.BRAND_XX_BH8488_EML.hashCode() * 31) + this.unilever.hashCode();
    }

    public String toString() {
        return "OptInOptOut(BRAND_XX_BH8488_EML=" + this.BRAND_XX_BH8488_EML + ", unilever=" + this.unilever + ')';
    }

    public OptInOptOut(BrandXxBh8488Eml brandXxBh8488Eml, Unilever unilever2) {
        Intrinsics.checkNotNullParameter(brandXxBh8488Eml, "BRAND_XX_BH8488_EML");
        Intrinsics.checkNotNullParameter(unilever2, "unilever");
        this.BRAND_XX_BH8488_EML = brandXxBh8488Eml;
        this.unilever = unilever2;
    }

    public final BrandXxBh8488Eml getBRAND_XX_BH8488_EML() {
        return this.BRAND_XX_BH8488_EML;
    }

    public final Unilever getUnilever() {
        return this.unilever;
    }
}
