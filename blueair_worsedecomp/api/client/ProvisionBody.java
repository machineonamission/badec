package com.blueair.api.client;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J;\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/blueair/api/client/ProvisionBody;", "", "ssid", "", "bssid", "password", "rand", "text", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getSsid", "()Ljava/lang/String;", "getBssid", "getPassword", "getRand", "getText", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "api_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceClient.kt */
public final class ProvisionBody {
    private final String bssid;
    private final String password;
    private final String rand;
    private final String ssid;
    private final String text;

    public static /* synthetic */ ProvisionBody copy$default(ProvisionBody provisionBody, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = provisionBody.ssid;
        }
        if ((i & 2) != 0) {
            str2 = provisionBody.bssid;
        }
        if ((i & 4) != 0) {
            str3 = provisionBody.password;
        }
        if ((i & 8) != 0) {
            str4 = provisionBody.rand;
        }
        if ((i & 16) != 0) {
            str5 = provisionBody.text;
        }
        String str6 = str4;
        String str7 = str5;
        return provisionBody.copy(str, str2, str3, str6, str7);
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
        return this.rand;
    }

    public final String component5() {
        return this.text;
    }

    public final ProvisionBody copy(String str, String str2, String str3, String str4, String str5) {
        Intrinsics.checkNotNullParameter(str, "ssid");
        Intrinsics.checkNotNullParameter(str2, "bssid");
        Intrinsics.checkNotNullParameter(str3, "password");
        Intrinsics.checkNotNullParameter(str4, "rand");
        Intrinsics.checkNotNullParameter(str5, "text");
        return new ProvisionBody(str, str2, str3, str4, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProvisionBody)) {
            return false;
        }
        ProvisionBody provisionBody = (ProvisionBody) obj;
        return Intrinsics.areEqual((Object) this.ssid, (Object) provisionBody.ssid) && Intrinsics.areEqual((Object) this.bssid, (Object) provisionBody.bssid) && Intrinsics.areEqual((Object) this.password, (Object) provisionBody.password) && Intrinsics.areEqual((Object) this.rand, (Object) provisionBody.rand) && Intrinsics.areEqual((Object) this.text, (Object) provisionBody.text);
    }

    public int hashCode() {
        return (((((((this.ssid.hashCode() * 31) + this.bssid.hashCode()) * 31) + this.password.hashCode()) * 31) + this.rand.hashCode()) * 31) + this.text.hashCode();
    }

    public String toString() {
        return "ProvisionBody(ssid=" + this.ssid + ", bssid=" + this.bssid + ", password=" + this.password + ", rand=" + this.rand + ", text=" + this.text + ')';
    }

    public ProvisionBody(String str, String str2, String str3, String str4, String str5) {
        Intrinsics.checkNotNullParameter(str, "ssid");
        Intrinsics.checkNotNullParameter(str2, "bssid");
        Intrinsics.checkNotNullParameter(str3, "password");
        Intrinsics.checkNotNullParameter(str4, "rand");
        Intrinsics.checkNotNullParameter(str5, "text");
        this.ssid = str;
        this.bssid = str2;
        this.password = str3;
        this.rand = str4;
        this.text = str5;
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

    public final String getRand() {
        return this.rand;
    }

    public final String getText() {
        return this.text;
    }
}
