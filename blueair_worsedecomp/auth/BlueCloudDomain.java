package com.blueair.auth;

import com.blueair.core.BuildEnvironment;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.projectodd.stilts.stomp.protocol.StompFrame;
import timber.log.Timber;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0010\u001a\u00020\u0003J\u0006\u0010\u0011\u001a\u00020\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001f"}, d2 = {"Lcom/blueair/auth/BlueCloudDomain;", "", "host", "", "clientId", "clientSecret", "mqttBroker", "regionCode", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getHost", "()Ljava/lang/String;", "getClientId", "getClientSecret", "getMqttBroker", "getRegionCode", "regionCodeShort", "tag", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "auth_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: BlueCloudDomain.kt */
public final class BlueCloudDomain {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final BlueCloudDomain INVALID = new BlueCloudDomain("", "", "", "", "");
    public static final String PROVISION_CHINA = "cn-north-1";
    public static final String PROVISION_EUROPE = "eu-west-1";
    public static final String PROVISION_USA = "us-east-2";
    private final String clientId;
    private final String clientSecret;
    private final String host;
    private final String mqttBroker;
    private final String regionCode;

    public static /* synthetic */ BlueCloudDomain copy$default(BlueCloudDomain blueCloudDomain, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = blueCloudDomain.host;
        }
        if ((i & 2) != 0) {
            str2 = blueCloudDomain.clientId;
        }
        if ((i & 4) != 0) {
            str3 = blueCloudDomain.clientSecret;
        }
        if ((i & 8) != 0) {
            str4 = blueCloudDomain.mqttBroker;
        }
        if ((i & 16) != 0) {
            str5 = blueCloudDomain.regionCode;
        }
        String str6 = str4;
        String str7 = str5;
        return blueCloudDomain.copy(str, str2, str3, str6, str7);
    }

    public final String component1() {
        return this.host;
    }

    public final String component2() {
        return this.clientId;
    }

    public final String component3() {
        return this.clientSecret;
    }

    public final String component4() {
        return this.mqttBroker;
    }

    public final String component5() {
        return this.regionCode;
    }

    public final BlueCloudDomain copy(String str, String str2, String str3, String str4, String str5) {
        Intrinsics.checkNotNullParameter(str, StompFrame.Header.HOST);
        Intrinsics.checkNotNullParameter(str2, "clientId");
        Intrinsics.checkNotNullParameter(str3, "clientSecret");
        Intrinsics.checkNotNullParameter(str4, "mqttBroker");
        Intrinsics.checkNotNullParameter(str5, "regionCode");
        return new BlueCloudDomain(str, str2, str3, str4, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BlueCloudDomain)) {
            return false;
        }
        BlueCloudDomain blueCloudDomain = (BlueCloudDomain) obj;
        return Intrinsics.areEqual((Object) this.host, (Object) blueCloudDomain.host) && Intrinsics.areEqual((Object) this.clientId, (Object) blueCloudDomain.clientId) && Intrinsics.areEqual((Object) this.clientSecret, (Object) blueCloudDomain.clientSecret) && Intrinsics.areEqual((Object) this.mqttBroker, (Object) blueCloudDomain.mqttBroker) && Intrinsics.areEqual((Object) this.regionCode, (Object) blueCloudDomain.regionCode);
    }

    public int hashCode() {
        return (((((((this.host.hashCode() * 31) + this.clientId.hashCode()) * 31) + this.clientSecret.hashCode()) * 31) + this.mqttBroker.hashCode()) * 31) + this.regionCode.hashCode();
    }

    public String toString() {
        return "BlueCloudDomain(host=" + this.host + ", clientId=" + this.clientId + ", clientSecret=" + this.clientSecret + ", mqttBroker=" + this.mqttBroker + ", regionCode=" + this.regionCode + ')';
    }

    public BlueCloudDomain(String str, String str2, String str3, String str4, String str5) {
        Intrinsics.checkNotNullParameter(str, StompFrame.Header.HOST);
        Intrinsics.checkNotNullParameter(str2, "clientId");
        Intrinsics.checkNotNullParameter(str3, "clientSecret");
        Intrinsics.checkNotNullParameter(str4, "mqttBroker");
        Intrinsics.checkNotNullParameter(str5, "regionCode");
        this.host = str;
        this.clientId = str2;
        this.clientSecret = str3;
        this.mqttBroker = str4;
        this.regionCode = str5;
    }

    public final String getHost() {
        return this.host;
    }

    public final String getClientId() {
        return this.clientId;
    }

    public final String getClientSecret() {
        return this.clientSecret;
    }

    public final String getMqttBroker() {
        return this.mqttBroker;
    }

    public final String getRegionCode() {
        return this.regionCode;
    }

    public final String regionCodeShort() {
        return StringsKt.take(this.regionCode, 2);
    }

    public final String tag() {
        String str = StringsKt.endsWith$default(this.host, "prod/", false, 2, (Object) null) ? "prod" : "qa";
        String str2 = this.regionCode;
        int hashCode = str2.hashCode();
        if (hashCode != -281577977) {
            if (hashCode != 372748112) {
                if (hashCode == 1808575601 && str2.equals(PROVISION_USA)) {
                    return "us_".concat(str);
                }
                return "";
            } else if (!str2.equals(PROVISION_EUROPE)) {
                return "";
            } else {
                return "eu_".concat(str);
            }
        } else if (!str2.equals("cn-north-1")) {
            return "";
        } else {
            return "cn_".concat(str);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010J\u001f\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0013"}, d2 = {"Lcom/blueair/auth/BlueCloudDomain$Companion;", "", "<init>", "()V", "PROVISION_CHINA", "", "PROVISION_USA", "PROVISION_EUROPE", "INVALID", "Lcom/blueair/auth/BlueCloudDomain;", "getINVALID", "()Lcom/blueair/auth/BlueCloudDomain;", "fromProvisionRegionCode", "provisionRegionCode", "overrideIsRelease", "", "(Ljava/lang/String;Ljava/lang/Boolean;)Lcom/blueair/auth/BlueCloudDomain;", "getDomainForRegion", "regionCode", "auth_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: BlueCloudDomain.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final BlueCloudDomain getINVALID() {
            return BlueCloudDomain.INVALID;
        }

        public static /* synthetic */ BlueCloudDomain fromProvisionRegionCode$default(Companion companion, String str, Boolean bool, int i, Object obj) {
            if ((i & 2) != 0) {
                bool = null;
            }
            return companion.fromProvisionRegionCode(str, bool);
        }

        public final BlueCloudDomain fromProvisionRegionCode(String str, Boolean bool) {
            Intrinsics.checkNotNullParameter(str, "provisionRegionCode");
            if (Intrinsics.areEqual((Object) str, (Object) "cn-north-1")) {
                return getDomainForRegion("cn", bool);
            }
            if (Intrinsics.areEqual((Object) str, (Object) BlueCloudDomain.PROVISION_USA)) {
                return getDomainForRegion("us", bool);
            }
            return getDomainForRegion(GigyaService.EUROPE, bool);
        }

        public static /* synthetic */ BlueCloudDomain getDomainForRegion$default(Companion companion, String str, Boolean bool, int i, Object obj) {
            if ((i & 2) != 0) {
                bool = null;
            }
            return companion.getDomainForRegion(str, bool);
        }

        public final BlueCloudDomain getDomainForRegion(String str, Boolean bool) {
            Intrinsics.checkNotNullParameter(str, "regionCode");
            boolean booleanValue = bool != null ? bool.booleanValue() : BuildEnvironment.INSTANCE.isRelease();
            Timber.Forest forest = Timber.Forest;
            forest.d("getDomainForRegion: " + str, new Object[0]);
            if (Intrinsics.areEqual((Object) str, (Object) "cn")) {
                return new BlueCloudDomain(booleanValue ? "https://ftbkyp79si.execute-api.cn-north-1.amazonaws.com.cn/prod/" : "https://817rqonyaj.execute-api.cn-northwest-1.amazonaws.com.cn/qa/", "2m1pfaga6vdd557fnl7lbn1ljq", "1r152pm64c1ojfdi9acnqpjlop0kl8kocl3kij3qj988p6cem4t8", booleanValue ? "a2du5f95w7oz2a.ats.iot.cn-north-1.amazonaws.com.cn" : "a2du5f95w7oz2a-ats.iot.cn-northwest-1.amazonaws.com.cn", "cn-north-1");
            } else if (Intrinsics.areEqual((Object) str, (Object) "us")) {
                return new BlueCloudDomain(booleanValue ? "https://on1keymlmh.execute-api.us-east-2.amazonaws.com/prod/" : "https://ychmmhbbi1.execute-api.us-east-2.amazonaws.com/qa/", "2m1pfaga6vdd557fnl7lbn1ljq", "1r152pm64c1ojfdi9acnqpjlop0kl8kocl3kij3qj988p6cem4t8", booleanValue ? "a3tpdpjvxk6yog-ats.iot.us-east-2.amazonaws.com" : "a169psisgz8280-ats.iot.us-east-2.amazonaws.com", BlueCloudDomain.PROVISION_USA);
            } else {
                return new BlueCloudDomain(booleanValue ? "https://hkgmr8v960.execute-api.eu-west-1.amazonaws.com/prod/" : "https://7474fty4v3.execute-api.eu-west-1.amazonaws.com/qa/", "2m1pfaga6vdd557fnl7lbn1ljq", "1r152pm64c1ojfdi9acnqpjlop0kl8kocl3kij3qj988p6cem4t8", booleanValue ? "a3tpdpjvxk6yog-ats.iot.eu-west-1.amazonaws.com" : "a169psisgz8280-ats.iot.eu-west-1.amazonaws.com", BlueCloudDomain.PROVISION_EUROPE);
            }
        }
    }
}
