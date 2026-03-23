package com.blueair.auth;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0011J>\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\bHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u001e\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2 = {"Lcom/blueair/auth/GigyaAccountData;", "", "address", "Lcom/blueair/auth/GigyaAccountAddress;", "accountstatus", "", "appRegion", "china_privacy_version", "", "<init>", "(Lcom/blueair/auth/GigyaAccountAddress;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getAddress", "()Lcom/blueair/auth/GigyaAccountAddress;", "getAccountstatus", "()Ljava/lang/String;", "getAppRegion", "getChina_privacy_version", "()Ljava/lang/Integer;", "setChina_privacy_version", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "copy", "(Lcom/blueair/auth/GigyaAccountAddress;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/blueair/auth/GigyaAccountData;", "equals", "", "other", "hashCode", "toString", "auth_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: GigyaService.kt */
public final class GigyaAccountData {
    private final String accountstatus;
    private final GigyaAccountAddress address;
    private final String appRegion;
    private Integer china_privacy_version;

    public static /* synthetic */ GigyaAccountData copy$default(GigyaAccountData gigyaAccountData, GigyaAccountAddress gigyaAccountAddress, String str, String str2, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            gigyaAccountAddress = gigyaAccountData.address;
        }
        if ((i & 2) != 0) {
            str = gigyaAccountData.accountstatus;
        }
        if ((i & 4) != 0) {
            str2 = gigyaAccountData.appRegion;
        }
        if ((i & 8) != 0) {
            num = gigyaAccountData.china_privacy_version;
        }
        return gigyaAccountData.copy(gigyaAccountAddress, str, str2, num);
    }

    public final GigyaAccountAddress component1() {
        return this.address;
    }

    public final String component2() {
        return this.accountstatus;
    }

    public final String component3() {
        return this.appRegion;
    }

    public final Integer component4() {
        return this.china_privacy_version;
    }

    public final GigyaAccountData copy(GigyaAccountAddress gigyaAccountAddress, String str, String str2, Integer num) {
        return new GigyaAccountData(gigyaAccountAddress, str, str2, num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GigyaAccountData)) {
            return false;
        }
        GigyaAccountData gigyaAccountData = (GigyaAccountData) obj;
        return Intrinsics.areEqual((Object) this.address, (Object) gigyaAccountData.address) && Intrinsics.areEqual((Object) this.accountstatus, (Object) gigyaAccountData.accountstatus) && Intrinsics.areEqual((Object) this.appRegion, (Object) gigyaAccountData.appRegion) && Intrinsics.areEqual((Object) this.china_privacy_version, (Object) gigyaAccountData.china_privacy_version);
    }

    public int hashCode() {
        GigyaAccountAddress gigyaAccountAddress = this.address;
        int i = 0;
        int hashCode = (gigyaAccountAddress == null ? 0 : gigyaAccountAddress.hashCode()) * 31;
        String str = this.accountstatus;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.appRegion;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.china_privacy_version;
        if (num != null) {
            i = num.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "GigyaAccountData(address=" + this.address + ", accountstatus=" + this.accountstatus + ", appRegion=" + this.appRegion + ", china_privacy_version=" + this.china_privacy_version + ')';
    }

    public GigyaAccountData(GigyaAccountAddress gigyaAccountAddress, String str, String str2, Integer num) {
        this.address = gigyaAccountAddress;
        this.accountstatus = str;
        this.appRegion = str2;
        this.china_privacy_version = num;
    }

    public final String getAccountstatus() {
        return this.accountstatus;
    }

    public final GigyaAccountAddress getAddress() {
        return this.address;
    }

    public final String getAppRegion() {
        return this.appRegion;
    }

    public final Integer getChina_privacy_version() {
        return this.china_privacy_version;
    }

    public final void setChina_privacy_version(Integer num) {
        this.china_privacy_version = num;
    }
}
