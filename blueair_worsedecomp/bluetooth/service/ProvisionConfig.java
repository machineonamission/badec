package com.blueair.bluetooth.service;

import com.amplitude.api.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003JE\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/blueair/bluetooth/service/ProvisionConfig;", "", "apiUrl", "", "authUrl", "brokerUrl", "region", "randomText", "secureRandom", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getApiUrl", "()Ljava/lang/String;", "getAuthUrl", "getBrokerUrl", "getRegion", "getRandomText", "getSecureRandom", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "bluetooth_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: BleDeviceService.kt */
public final class ProvisionConfig {
    private final String apiUrl;
    private final String authUrl;
    private final String brokerUrl;
    private final String randomText;
    private final String region;
    private final String secureRandom;

    public static /* synthetic */ ProvisionConfig copy$default(ProvisionConfig provisionConfig, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = provisionConfig.apiUrl;
        }
        if ((i & 2) != 0) {
            str2 = provisionConfig.authUrl;
        }
        if ((i & 4) != 0) {
            str3 = provisionConfig.brokerUrl;
        }
        if ((i & 8) != 0) {
            str4 = provisionConfig.region;
        }
        if ((i & 16) != 0) {
            str5 = provisionConfig.randomText;
        }
        if ((i & 32) != 0) {
            str6 = provisionConfig.secureRandom;
        }
        String str7 = str5;
        String str8 = str6;
        String str9 = str4;
        String str10 = str2;
        return provisionConfig.copy(str, str10, str3, str9, str7, str8);
    }

    public final String component1() {
        return this.apiUrl;
    }

    public final String component2() {
        return this.authUrl;
    }

    public final String component3() {
        return this.brokerUrl;
    }

    public final String component4() {
        return this.region;
    }

    public final String component5() {
        return this.randomText;
    }

    public final String component6() {
        return this.secureRandom;
    }

    public final ProvisionConfig copy(String str, String str2, String str3, String str4, String str5, String str6) {
        Intrinsics.checkNotNullParameter(str, "apiUrl");
        Intrinsics.checkNotNullParameter(str2, "authUrl");
        Intrinsics.checkNotNullParameter(str3, "brokerUrl");
        Intrinsics.checkNotNullParameter(str4, Constants.AMP_TRACKING_OPTION_REGION);
        Intrinsics.checkNotNullParameter(str5, "randomText");
        Intrinsics.checkNotNullParameter(str6, "secureRandom");
        return new ProvisionConfig(str, str2, str3, str4, str5, str6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProvisionConfig)) {
            return false;
        }
        ProvisionConfig provisionConfig = (ProvisionConfig) obj;
        return Intrinsics.areEqual((Object) this.apiUrl, (Object) provisionConfig.apiUrl) && Intrinsics.areEqual((Object) this.authUrl, (Object) provisionConfig.authUrl) && Intrinsics.areEqual((Object) this.brokerUrl, (Object) provisionConfig.brokerUrl) && Intrinsics.areEqual((Object) this.region, (Object) provisionConfig.region) && Intrinsics.areEqual((Object) this.randomText, (Object) provisionConfig.randomText) && Intrinsics.areEqual((Object) this.secureRandom, (Object) provisionConfig.secureRandom);
    }

    public int hashCode() {
        return (((((((((this.apiUrl.hashCode() * 31) + this.authUrl.hashCode()) * 31) + this.brokerUrl.hashCode()) * 31) + this.region.hashCode()) * 31) + this.randomText.hashCode()) * 31) + this.secureRandom.hashCode();
    }

    public String toString() {
        return "ProvisionConfig(apiUrl=" + this.apiUrl + ", authUrl=" + this.authUrl + ", brokerUrl=" + this.brokerUrl + ", region=" + this.region + ", randomText=" + this.randomText + ", secureRandom=" + this.secureRandom + ')';
    }

    public ProvisionConfig(String str, String str2, String str3, String str4, String str5, String str6) {
        Intrinsics.checkNotNullParameter(str, "apiUrl");
        Intrinsics.checkNotNullParameter(str2, "authUrl");
        Intrinsics.checkNotNullParameter(str3, "brokerUrl");
        Intrinsics.checkNotNullParameter(str4, Constants.AMP_TRACKING_OPTION_REGION);
        Intrinsics.checkNotNullParameter(str5, "randomText");
        Intrinsics.checkNotNullParameter(str6, "secureRandom");
        this.apiUrl = str;
        this.authUrl = str2;
        this.brokerUrl = str3;
        this.region = str4;
        this.randomText = str5;
        this.secureRandom = str6;
    }

    public final String getApiUrl() {
        return this.apiUrl;
    }

    public final String getAuthUrl() {
        return this.authUrl;
    }

    public final String getBrokerUrl() {
        return this.brokerUrl;
    }

    public final String getRegion() {
        return this.region;
    }

    public final String getRandomText() {
        return this.randomText;
    }

    public final String getSecureRandom() {
        return this.secureRandom;
    }
}
