package com.blueair.core.model;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001c\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000f\u001a\u00020\u0010J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\rHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u001b"}, d2 = {"Lcom/blueair/core/model/AwsLinkConfig;", "", "cn", "Lcom/blueair/core/model/I18nConfig;", "eu", "us", "<init>", "(Lcom/blueair/core/model/I18nConfig;Lcom/blueair/core/model/I18nConfig;Lcom/blueair/core/model/I18nConfig;)V", "getCn", "()Lcom/blueair/core/model/I18nConfig;", "getEu", "getUs", "getValue", "", "region", "locale", "Ljava/util/Locale;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: BaseJsonTypes.kt */
public final class AwsLinkConfig {
    private final I18nConfig cn;
    private final I18nConfig eu;
    private final I18nConfig us;

    public static /* synthetic */ AwsLinkConfig copy$default(AwsLinkConfig awsLinkConfig, I18nConfig i18nConfig, I18nConfig i18nConfig2, I18nConfig i18nConfig3, int i, Object obj) {
        if ((i & 1) != 0) {
            i18nConfig = awsLinkConfig.cn;
        }
        if ((i & 2) != 0) {
            i18nConfig2 = awsLinkConfig.eu;
        }
        if ((i & 4) != 0) {
            i18nConfig3 = awsLinkConfig.us;
        }
        return awsLinkConfig.copy(i18nConfig, i18nConfig2, i18nConfig3);
    }

    public final I18nConfig component1() {
        return this.cn;
    }

    public final I18nConfig component2() {
        return this.eu;
    }

    public final I18nConfig component3() {
        return this.us;
    }

    public final AwsLinkConfig copy(I18nConfig i18nConfig, I18nConfig i18nConfig2, I18nConfig i18nConfig3) {
        return new AwsLinkConfig(i18nConfig, i18nConfig2, i18nConfig3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AwsLinkConfig)) {
            return false;
        }
        AwsLinkConfig awsLinkConfig = (AwsLinkConfig) obj;
        return Intrinsics.areEqual((Object) this.cn, (Object) awsLinkConfig.cn) && Intrinsics.areEqual((Object) this.eu, (Object) awsLinkConfig.eu) && Intrinsics.areEqual((Object) this.us, (Object) awsLinkConfig.us);
    }

    public int hashCode() {
        I18nConfig i18nConfig = this.cn;
        int i = 0;
        int hashCode = (i18nConfig == null ? 0 : i18nConfig.hashCode()) * 31;
        I18nConfig i18nConfig2 = this.eu;
        int hashCode2 = (hashCode + (i18nConfig2 == null ? 0 : i18nConfig2.hashCode())) * 31;
        I18nConfig i18nConfig3 = this.us;
        if (i18nConfig3 != null) {
            i = i18nConfig3.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "AwsLinkConfig(cn=" + this.cn + ", eu=" + this.eu + ", us=" + this.us + ')';
    }

    public AwsLinkConfig(I18nConfig i18nConfig, I18nConfig i18nConfig2, I18nConfig i18nConfig3) {
        this.cn = i18nConfig;
        this.eu = i18nConfig2;
        this.us = i18nConfig3;
    }

    public final I18nConfig getCn() {
        return this.cn;
    }

    public final I18nConfig getEu() {
        return this.eu;
    }

    public final I18nConfig getUs() {
        return this.us;
    }

    public static /* synthetic */ String getValue$default(AwsLinkConfig awsLinkConfig, String str, Locale locale, int i, Object obj) {
        if ((i & 2) != 0) {
            locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
        }
        return awsLinkConfig.getValue(str, locale);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0049 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String getValue(java.lang.String r3, java.util.Locale r4) {
        /*
            r2 = this;
            java.lang.String r0 = "locale"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            if (r3 == 0) goto L_0x0040
            int r0 = r3.hashCode()
            r1 = 3179(0xc6b, float:4.455E-42)
            if (r0 == r1) goto L_0x0034
            r1 = 3248(0xcb0, float:4.551E-42)
            if (r0 == r1) goto L_0x0028
            r1 = 3742(0xe9e, float:5.244E-42)
            if (r0 == r1) goto L_0x0018
            goto L_0x0040
        L_0x0018:
            java.lang.String r0 = "us"
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L_0x0021
            goto L_0x0040
        L_0x0021:
            com.blueair.core.model.I18nConfig r3 = r2.us
            if (r3 != 0) goto L_0x0042
            com.blueair.core.model.I18nConfig r3 = r2.eu
            goto L_0x0042
        L_0x0028:
            java.lang.String r0 = "eu"
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L_0x0031
            goto L_0x0040
        L_0x0031:
            com.blueair.core.model.I18nConfig r3 = r2.eu
            goto L_0x0042
        L_0x0034:
            java.lang.String r0 = "cn"
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L_0x003d
            goto L_0x0040
        L_0x003d:
            com.blueair.core.model.I18nConfig r3 = r2.cn
            goto L_0x0042
        L_0x0040:
            com.blueair.core.model.I18nConfig r3 = r2.eu
        L_0x0042:
            if (r3 == 0) goto L_0x0049
            java.lang.String r3 = r3.getValue(r4)
            return r3
        L_0x0049:
            r3 = 0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.core.model.AwsLinkConfig.getValue(java.lang.String, java.util.Locale):java.lang.String");
    }
}
