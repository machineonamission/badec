package com.blueair.api.model;

import com.amplitude.api.Constants;
import com.blueair.auth.AuthKodeinModule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003Jc\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\t\u0010'\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000f¨\u0006("}, d2 = {"Lcom/blueair/api/model/ProvisionRequestBody;", "", "ssid", "", "bssid", "password", "api", "auth", "broker", "region", "text", "rand", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getSsid", "()Ljava/lang/String;", "getBssid", "getPassword", "getApi", "getAuth", "getBroker", "getRegion", "getText", "getRand", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "api_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: ProvisionRequestBody.kt */
public final class ProvisionRequestBody {
    private final String api;
    private final String auth;
    private final String broker;
    private final String bssid;
    private final String password;
    private final String rand;
    private final String region;
    private final String ssid;
    private final String text;

    public static /* synthetic */ ProvisionRequestBody copy$default(ProvisionRequestBody provisionRequestBody, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i, Object obj) {
        if ((i & 1) != 0) {
            str = provisionRequestBody.ssid;
        }
        if ((i & 2) != 0) {
            str2 = provisionRequestBody.bssid;
        }
        if ((i & 4) != 0) {
            str3 = provisionRequestBody.password;
        }
        if ((i & 8) != 0) {
            str4 = provisionRequestBody.api;
        }
        if ((i & 16) != 0) {
            str5 = provisionRequestBody.auth;
        }
        if ((i & 32) != 0) {
            str6 = provisionRequestBody.broker;
        }
        if ((i & 64) != 0) {
            str7 = provisionRequestBody.region;
        }
        if ((i & 128) != 0) {
            str8 = provisionRequestBody.text;
        }
        if ((i & 256) != 0) {
            str9 = provisionRequestBody.rand;
        }
        String str10 = str8;
        String str11 = str9;
        String str12 = str6;
        String str13 = str7;
        String str14 = str4;
        String str15 = str5;
        return provisionRequestBody.copy(str, str2, str3, str14, str15, str12, str13, str10, str11);
    }

    public final String component1() {
        return this.ssid;
    }

    public final String component2() {
        return this.bssid;
    }

    public final String component3() {
        return this.password;
    }

    public final String component4() {
        return this.api;
    }

    public final String component5() {
        return this.auth;
    }

    public final String component6() {
        return this.broker;
    }

    public final String component7() {
        return this.region;
    }

    public final String component8() {
        return this.text;
    }

    public final String component9() {
        return this.rand;
    }

    public final ProvisionRequestBody copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        Intrinsics.checkNotNullParameter(str, "ssid");
        Intrinsics.checkNotNullParameter(str2, "bssid");
        Intrinsics.checkNotNullParameter(str3, "password");
        Intrinsics.checkNotNullParameter(str4, "api");
        String str10 = str5;
        Intrinsics.checkNotNullParameter(str10, AuthKodeinModule.moduleName);
        String str11 = str6;
        Intrinsics.checkNotNullParameter(str11, "broker");
        String str12 = str7;
        Intrinsics.checkNotNullParameter(str12, Constants.AMP_TRACKING_OPTION_REGION);
        String str13 = str8;
        Intrinsics.checkNotNullParameter(str13, "text");
        String str14 = str9;
        Intrinsics.checkNotNullParameter(str14, "rand");
        return new ProvisionRequestBody(str, str2, str3, str4, str10, str11, str12, str13, str14);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProvisionRequestBody)) {
            return false;
        }
        ProvisionRequestBody provisionRequestBody = (ProvisionRequestBody) obj;
        return Intrinsics.areEqual((Object) this.ssid, (Object) provisionRequestBody.ssid) && Intrinsics.areEqual((Object) this.bssid, (Object) provisionRequestBody.bssid) && Intrinsics.areEqual((Object) this.password, (Object) provisionRequestBody.password) && Intrinsics.areEqual((Object) this.api, (Object) provisionRequestBody.api) && Intrinsics.areEqual((Object) this.auth, (Object) provisionRequestBody.auth) && Intrinsics.areEqual((Object) this.broker, (Object) provisionRequestBody.broker) && Intrinsics.areEqual((Object) this.region, (Object) provisionRequestBody.region) && Intrinsics.areEqual((Object) this.text, (Object) provisionRequestBody.text) && Intrinsics.areEqual((Object) this.rand, (Object) provisionRequestBody.rand);
    }

    public int hashCode() {
        return (((((((((((((((this.ssid.hashCode() * 31) + this.bssid.hashCode()) * 31) + this.password.hashCode()) * 31) + this.api.hashCode()) * 31) + this.auth.hashCode()) * 31) + this.broker.hashCode()) * 31) + this.region.hashCode()) * 31) + this.text.hashCode()) * 31) + this.rand.hashCode();
    }

    public String toString() {
        return "ProvisionRequestBody(ssid=" + this.ssid + ", bssid=" + this.bssid + ", password=" + this.password + ", api=" + this.api + ", auth=" + this.auth + ", broker=" + this.broker + ", region=" + this.region + ", text=" + this.text + ", rand=" + this.rand + ')';
    }

    public ProvisionRequestBody(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        Intrinsics.checkNotNullParameter(str, "ssid");
        Intrinsics.checkNotNullParameter(str2, "bssid");
        Intrinsics.checkNotNullParameter(str3, "password");
        Intrinsics.checkNotNullParameter(str4, "api");
        Intrinsics.checkNotNullParameter(str5, AuthKodeinModule.moduleName);
        Intrinsics.checkNotNullParameter(str6, "broker");
        Intrinsics.checkNotNullParameter(str7, Constants.AMP_TRACKING_OPTION_REGION);
        Intrinsics.checkNotNullParameter(str8, "text");
        Intrinsics.checkNotNullParameter(str9, "rand");
        this.ssid = str;
        this.bssid = str2;
        this.password = str3;
        this.api = str4;
        this.auth = str5;
        this.broker = str6;
        this.region = str7;
        this.text = str8;
        this.rand = str9;
    }

    public final String getSsid() {
        return this.ssid;
    }

    public final String getBssid() {
        return this.bssid;
    }

    public final String getPassword() {
        return this.password;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ProvisionRequestBody(java.lang.String r11, java.lang.String r12, java.lang.String r13, java.lang.String r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, int r20, kotlin.jvm.internal.DefaultConstructorMarker r21) {
        /*
            r10 = this;
            r0 = r20 & 8
            if (r0 == 0) goto L_0x0006
            java.lang.String r14 = "https://de-fr.api.blueair.io"
        L_0x0006:
            r4 = r14
            r14 = r20 & 32
            if (r14 == 0) goto L_0x000f
            java.lang.String r14 = "https://de-fr.broker.blueair.io"
            r6 = r14
            goto L_0x0011
        L_0x000f:
            r6 = r16
        L_0x0011:
            r14 = r20 & 64
            if (r14 == 0) goto L_0x0019
            java.lang.String r14 = "EU-SE"
            r7 = r14
            goto L_0x001b
        L_0x0019:
            r7 = r17
        L_0x001b:
            r0 = r10
            r1 = r11
            r2 = r12
            r3 = r13
            r5 = r15
            r8 = r18
            r9 = r19
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.model.ProvisionRequestBody.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getApi() {
        return this.api;
    }

    public final String getAuth() {
        return this.auth;
    }

    public final String getBroker() {
        return this.broker;
    }

    public final String getRegion() {
        return this.region;
    }

    public final String getText() {
        return this.text;
    }

    public final String getRand() {
        return this.rand;
    }
}
