package com.blueair.core.model;

import com.squareup.moshi.Json;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00052\b\b\u0003\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u001b"}, d2 = {"Lcom/blueair/core/model/ChinaPrivacy;", "", "version", "", "text", "Lcom/blueair/core/model/I18nConfig;", "linkTerms", "linkPrivacy", "<init>", "(ILcom/blueair/core/model/I18nConfig;Lcom/blueair/core/model/I18nConfig;Lcom/blueair/core/model/I18nConfig;)V", "getVersion", "()I", "getText", "()Lcom/blueair/core/model/I18nConfig;", "getLinkTerms", "getLinkPrivacy", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: SkuConfiguration.kt */
public final class ChinaPrivacy {
    private final I18nConfig linkPrivacy;
    private final I18nConfig linkTerms;
    private final I18nConfig text;
    private final int version;

    public static /* synthetic */ ChinaPrivacy copy$default(ChinaPrivacy chinaPrivacy, int i, I18nConfig i18nConfig, I18nConfig i18nConfig2, I18nConfig i18nConfig3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = chinaPrivacy.version;
        }
        if ((i2 & 2) != 0) {
            i18nConfig = chinaPrivacy.text;
        }
        if ((i2 & 4) != 0) {
            i18nConfig2 = chinaPrivacy.linkTerms;
        }
        if ((i2 & 8) != 0) {
            i18nConfig3 = chinaPrivacy.linkPrivacy;
        }
        return chinaPrivacy.copy(i, i18nConfig, i18nConfig2, i18nConfig3);
    }

    public final int component1() {
        return this.version;
    }

    public final I18nConfig component2() {
        return this.text;
    }

    public final I18nConfig component3() {
        return this.linkTerms;
    }

    public final I18nConfig component4() {
        return this.linkPrivacy;
    }

    public final ChinaPrivacy copy(int i, I18nConfig i18nConfig, @Json(name = "link_terms") I18nConfig i18nConfig2, @Json(name = "link_privacy") I18nConfig i18nConfig3) {
        Intrinsics.checkNotNullParameter(i18nConfig, "text");
        Intrinsics.checkNotNullParameter(i18nConfig2, "linkTerms");
        Intrinsics.checkNotNullParameter(i18nConfig3, "linkPrivacy");
        return new ChinaPrivacy(i, i18nConfig, i18nConfig2, i18nConfig3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChinaPrivacy)) {
            return false;
        }
        ChinaPrivacy chinaPrivacy = (ChinaPrivacy) obj;
        return this.version == chinaPrivacy.version && Intrinsics.areEqual((Object) this.text, (Object) chinaPrivacy.text) && Intrinsics.areEqual((Object) this.linkTerms, (Object) chinaPrivacy.linkTerms) && Intrinsics.areEqual((Object) this.linkPrivacy, (Object) chinaPrivacy.linkPrivacy);
    }

    public int hashCode() {
        return (((((this.version * 31) + this.text.hashCode()) * 31) + this.linkTerms.hashCode()) * 31) + this.linkPrivacy.hashCode();
    }

    public String toString() {
        return "ChinaPrivacy(version=" + this.version + ", text=" + this.text + ", linkTerms=" + this.linkTerms + ", linkPrivacy=" + this.linkPrivacy + ')';
    }

    public ChinaPrivacy(int i, I18nConfig i18nConfig, @Json(name = "link_terms") I18nConfig i18nConfig2, @Json(name = "link_privacy") I18nConfig i18nConfig3) {
        Intrinsics.checkNotNullParameter(i18nConfig, "text");
        Intrinsics.checkNotNullParameter(i18nConfig2, "linkTerms");
        Intrinsics.checkNotNullParameter(i18nConfig3, "linkPrivacy");
        this.version = i;
        this.text = i18nConfig;
        this.linkTerms = i18nConfig2;
        this.linkPrivacy = i18nConfig3;
    }

    public final int getVersion() {
        return this.version;
    }

    public final I18nConfig getText() {
        return this.text;
    }

    public final I18nConfig getLinkTerms() {
        return this.linkTerms;
    }

    public final I18nConfig getLinkPrivacy() {
        return this.linkPrivacy;
    }
}
