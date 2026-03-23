package com.blueair.auth;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003JE\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\r¨\u0006\""}, d2 = {"Lcom/blueair/auth/GigyaAccountAddress;", "", "stateCode", "", "addressLine1", "city", "country", "postCode", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getStateCode", "()Ljava/lang/String;", "setStateCode", "(Ljava/lang/String;)V", "getAddressLine1", "setAddressLine1", "getCity", "setCity", "getCountry", "setCountry", "getPostCode", "setPostCode", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "auth_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: GigyaService.kt */
public final class GigyaAccountAddress {
    private String addressLine1;
    private String city;
    private String country;
    private String postCode;
    private String stateCode;

    public GigyaAccountAddress() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, 31, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ GigyaAccountAddress copy$default(GigyaAccountAddress gigyaAccountAddress, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = gigyaAccountAddress.stateCode;
        }
        if ((i & 2) != 0) {
            str2 = gigyaAccountAddress.addressLine1;
        }
        if ((i & 4) != 0) {
            str3 = gigyaAccountAddress.city;
        }
        if ((i & 8) != 0) {
            str4 = gigyaAccountAddress.country;
        }
        if ((i & 16) != 0) {
            str5 = gigyaAccountAddress.postCode;
        }
        String str6 = str4;
        String str7 = str5;
        return gigyaAccountAddress.copy(str, str2, str3, str6, str7);
    }

    public final String component1() {
        return this.stateCode;
    }

    public final String component2() {
        return this.addressLine1;
    }

    public final String component3() {
        return this.city;
    }

    public final String component4() {
        return this.country;
    }

    public final String component5() {
        return this.postCode;
    }

    public final GigyaAccountAddress copy(String str, String str2, String str3, String str4, String str5) {
        return new GigyaAccountAddress(str, str2, str3, str4, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GigyaAccountAddress)) {
            return false;
        }
        GigyaAccountAddress gigyaAccountAddress = (GigyaAccountAddress) obj;
        return Intrinsics.areEqual((Object) this.stateCode, (Object) gigyaAccountAddress.stateCode) && Intrinsics.areEqual((Object) this.addressLine1, (Object) gigyaAccountAddress.addressLine1) && Intrinsics.areEqual((Object) this.city, (Object) gigyaAccountAddress.city) && Intrinsics.areEqual((Object) this.country, (Object) gigyaAccountAddress.country) && Intrinsics.areEqual((Object) this.postCode, (Object) gigyaAccountAddress.postCode);
    }

    public int hashCode() {
        String str = this.stateCode;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.addressLine1;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.city;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.country;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.postCode;
        if (str5 != null) {
            i = str5.hashCode();
        }
        return hashCode4 + i;
    }

    public String toString() {
        return "GigyaAccountAddress(stateCode=" + this.stateCode + ", addressLine1=" + this.addressLine1 + ", city=" + this.city + ", country=" + this.country + ", postCode=" + this.postCode + ')';
    }

    public GigyaAccountAddress(String str, String str2, String str3, String str4, String str5) {
        this.stateCode = str;
        this.addressLine1 = str2;
        this.city = str3;
        this.country = str4;
        this.postCode = str5;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ GigyaAccountAddress(java.lang.String r2, java.lang.String r3, java.lang.String r4, java.lang.String r5, java.lang.String r6, int r7, kotlin.jvm.internal.DefaultConstructorMarker r8) {
        /*
            r1 = this;
            r8 = r7 & 1
            r0 = 0
            if (r8 == 0) goto L_0x0006
            r2 = r0
        L_0x0006:
            r8 = r7 & 2
            if (r8 == 0) goto L_0x000b
            r3 = r0
        L_0x000b:
            r8 = r7 & 4
            if (r8 == 0) goto L_0x0010
            r4 = r0
        L_0x0010:
            r8 = r7 & 8
            if (r8 == 0) goto L_0x0015
            r5 = r0
        L_0x0015:
            r7 = r7 & 16
            if (r7 == 0) goto L_0x001b
            r7 = r0
            goto L_0x001c
        L_0x001b:
            r7 = r6
        L_0x001c:
            r6 = r5
            r5 = r4
            r4 = r3
            r3 = r2
            r2 = r1
            r2.<init>(r3, r4, r5, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.auth.GigyaAccountAddress.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getStateCode() {
        return this.stateCode;
    }

    public final void setStateCode(String str) {
        this.stateCode = str;
    }

    public final String getAddressLine1() {
        return this.addressLine1;
    }

    public final void setAddressLine1(String str) {
        this.addressLine1 = str;
    }

    public final String getCity() {
        return this.city;
    }

    public final void setCity(String str) {
        this.city = str;
    }

    public final String getCountry() {
        return this.country;
    }

    public final void setCountry(String str) {
        this.country = str;
    }

    public final String getPostCode() {
        return this.postCode;
    }

    public final void setPostCode(String str) {
        this.postCode = str;
    }
}
