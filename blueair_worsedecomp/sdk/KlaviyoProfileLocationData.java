package com.blueair.sdk;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J7\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/blueair/sdk/KlaviyoProfileLocationData;", "", "email", "", "countryCode", "state", "city", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getEmail", "()Ljava/lang/String;", "getCountryCode", "getState", "getCity", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "sdk_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: KlaviyoProfileData.kt */
public final class KlaviyoProfileLocationData {
    private final String city;
    private final String countryCode;
    private final String email;
    private final String state;

    public static /* synthetic */ KlaviyoProfileLocationData copy$default(KlaviyoProfileLocationData klaviyoProfileLocationData, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = klaviyoProfileLocationData.email;
        }
        if ((i & 2) != 0) {
            str2 = klaviyoProfileLocationData.countryCode;
        }
        if ((i & 4) != 0) {
            str3 = klaviyoProfileLocationData.state;
        }
        if ((i & 8) != 0) {
            str4 = klaviyoProfileLocationData.city;
        }
        return klaviyoProfileLocationData.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.email;
    }

    public final String component2() {
        return this.countryCode;
    }

    public final String component3() {
        return this.state;
    }

    public final String component4() {
        return this.city;
    }

    public final KlaviyoProfileLocationData copy(String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, "email");
        return new KlaviyoProfileLocationData(str, str2, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KlaviyoProfileLocationData)) {
            return false;
        }
        KlaviyoProfileLocationData klaviyoProfileLocationData = (KlaviyoProfileLocationData) obj;
        return Intrinsics.areEqual((Object) this.email, (Object) klaviyoProfileLocationData.email) && Intrinsics.areEqual((Object) this.countryCode, (Object) klaviyoProfileLocationData.countryCode) && Intrinsics.areEqual((Object) this.state, (Object) klaviyoProfileLocationData.state) && Intrinsics.areEqual((Object) this.city, (Object) klaviyoProfileLocationData.city);
    }

    public int hashCode() {
        int hashCode = this.email.hashCode() * 31;
        String str = this.countryCode;
        int i = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.state;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.city;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "KlaviyoProfileLocationData(email=" + this.email + ", countryCode=" + this.countryCode + ", state=" + this.state + ", city=" + this.city + ')';
    }

    public KlaviyoProfileLocationData(String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, "email");
        this.email = str;
        this.countryCode = str2;
        this.state = str3;
        this.city = str4;
    }

    public final String getEmail() {
        return this.email;
    }

    public final String getCountryCode() {
        return this.countryCode;
    }

    public final String getState() {
        return this.state;
    }

    public final String getCity() {
        return this.city;
    }
}
