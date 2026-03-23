package com.blueair.auth.retrofit;

import com.squareup.moshi.Json;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u000e\b\b\u0018\u00002\u00020\u0001BW\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0003\u0010\t\u001a\u00020\u0003\u0012\b\b\u0003\u0010\n\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u000b\u001a\u00020\u0003¢\u0006\u0004\b\f\u0010\rJ\u0006\u0010\u0018\u001a\u00020\u0019J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003JY\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0003\u0010\t\u001a\u00020\u00032\b\b\u0003\u0010\n\u001a\u00020\u00032\b\b\u0003\u0010\u000b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010#\u001a\u00020\u00192\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\u0006HÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000f¨\u0006'"}, d2 = {"Lcom/blueair/auth/retrofit/BlueLoginDetails;", "", "access_token", "", "token_type", "expires_in", "", "refresh_token", "id_token", "custom_auth_name", "custom_auth_signature", "custom_auth_token", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAccess_token", "()Ljava/lang/String;", "getToken_type", "getExpires_in", "()I", "getRefresh_token", "getId_token", "getCustom_auth_name", "getCustom_auth_signature", "getCustom_auth_token", "isEmpty", "", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "toString", "auth_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: CloudAuthApi.kt */
public final class BlueLoginDetails {
    private final String access_token;
    private final String custom_auth_name;
    private final String custom_auth_signature;
    private final String custom_auth_token;
    private final int expires_in;
    private final String id_token;
    private final String refresh_token;
    private final String token_type;

    public BlueLoginDetails() {
        this((String) null, (String) null, 0, (String) null, (String) null, (String) null, (String) null, (String) null, 255, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ BlueLoginDetails copy$default(BlueLoginDetails blueLoginDetails, String str, String str2, int i, String str3, String str4, String str5, String str6, String str7, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = blueLoginDetails.access_token;
        }
        if ((i2 & 2) != 0) {
            str2 = blueLoginDetails.token_type;
        }
        if ((i2 & 4) != 0) {
            i = blueLoginDetails.expires_in;
        }
        if ((i2 & 8) != 0) {
            str3 = blueLoginDetails.refresh_token;
        }
        if ((i2 & 16) != 0) {
            str4 = blueLoginDetails.id_token;
        }
        if ((i2 & 32) != 0) {
            str5 = blueLoginDetails.custom_auth_name;
        }
        if ((i2 & 64) != 0) {
            str6 = blueLoginDetails.custom_auth_signature;
        }
        if ((i2 & 128) != 0) {
            str7 = blueLoginDetails.custom_auth_token;
        }
        String str8 = str6;
        String str9 = str7;
        String str10 = str4;
        String str11 = str5;
        String str12 = str3;
        String str13 = str2;
        return blueLoginDetails.copy(str, str13, i, str12, str10, str11, str8, str9);
    }

    public final String component1() {
        return this.access_token;
    }

    public final String component2() {
        return this.token_type;
    }

    public final int component3() {
        return this.expires_in;
    }

    public final String component4() {
        return this.refresh_token;
    }

    public final String component5() {
        return this.id_token;
    }

    public final String component6() {
        return this.custom_auth_name;
    }

    public final String component7() {
        return this.custom_auth_signature;
    }

    public final String component8() {
        return this.custom_auth_token;
    }

    public final BlueLoginDetails copy(String str, String str2, int i, String str3, String str4, @Json(name = "ba_X-Amz-CustomAuthorizer-Name") String str5, @Json(name = "ba_X-Amz-CustomAuthorizer-Signature") String str6, @Json(name = "ba_X-Amz-CustomAuthorizer-Token") String str7) {
        Intrinsics.checkNotNullParameter(str, "access_token");
        Intrinsics.checkNotNullParameter(str2, "token_type");
        Intrinsics.checkNotNullParameter(str3, "refresh_token");
        Intrinsics.checkNotNullParameter(str4, "id_token");
        String str8 = str5;
        Intrinsics.checkNotNullParameter(str8, "custom_auth_name");
        String str9 = str6;
        Intrinsics.checkNotNullParameter(str9, "custom_auth_signature");
        String str10 = str7;
        Intrinsics.checkNotNullParameter(str10, "custom_auth_token");
        return new BlueLoginDetails(str, str2, i, str3, str4, str8, str9, str10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BlueLoginDetails)) {
            return false;
        }
        BlueLoginDetails blueLoginDetails = (BlueLoginDetails) obj;
        return Intrinsics.areEqual((Object) this.access_token, (Object) blueLoginDetails.access_token) && Intrinsics.areEqual((Object) this.token_type, (Object) blueLoginDetails.token_type) && this.expires_in == blueLoginDetails.expires_in && Intrinsics.areEqual((Object) this.refresh_token, (Object) blueLoginDetails.refresh_token) && Intrinsics.areEqual((Object) this.id_token, (Object) blueLoginDetails.id_token) && Intrinsics.areEqual((Object) this.custom_auth_name, (Object) blueLoginDetails.custom_auth_name) && Intrinsics.areEqual((Object) this.custom_auth_signature, (Object) blueLoginDetails.custom_auth_signature) && Intrinsics.areEqual((Object) this.custom_auth_token, (Object) blueLoginDetails.custom_auth_token);
    }

    public int hashCode() {
        return (((((((((((((this.access_token.hashCode() * 31) + this.token_type.hashCode()) * 31) + this.expires_in) * 31) + this.refresh_token.hashCode()) * 31) + this.id_token.hashCode()) * 31) + this.custom_auth_name.hashCode()) * 31) + this.custom_auth_signature.hashCode()) * 31) + this.custom_auth_token.hashCode();
    }

    public String toString() {
        return "BlueLoginDetails(access_token=" + this.access_token + ", token_type=" + this.token_type + ", expires_in=" + this.expires_in + ", refresh_token=" + this.refresh_token + ", id_token=" + this.id_token + ", custom_auth_name=" + this.custom_auth_name + ", custom_auth_signature=" + this.custom_auth_signature + ", custom_auth_token=" + this.custom_auth_token + ')';
    }

    public BlueLoginDetails(String str, String str2, int i, String str3, String str4, @Json(name = "ba_X-Amz-CustomAuthorizer-Name") String str5, @Json(name = "ba_X-Amz-CustomAuthorizer-Signature") String str6, @Json(name = "ba_X-Amz-CustomAuthorizer-Token") String str7) {
        Intrinsics.checkNotNullParameter(str, "access_token");
        Intrinsics.checkNotNullParameter(str2, "token_type");
        Intrinsics.checkNotNullParameter(str3, "refresh_token");
        Intrinsics.checkNotNullParameter(str4, "id_token");
        Intrinsics.checkNotNullParameter(str5, "custom_auth_name");
        Intrinsics.checkNotNullParameter(str6, "custom_auth_signature");
        Intrinsics.checkNotNullParameter(str7, "custom_auth_token");
        this.access_token = str;
        this.token_type = str2;
        this.expires_in = i;
        this.refresh_token = str3;
        this.id_token = str4;
        this.custom_auth_name = str5;
        this.custom_auth_signature = str6;
        this.custom_auth_token = str7;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ BlueLoginDetails(java.lang.String r2, java.lang.String r3, int r4, java.lang.String r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, int r10, kotlin.jvm.internal.DefaultConstructorMarker r11) {
        /*
            r1 = this;
            r11 = r10 & 1
            java.lang.String r0 = ""
            if (r11 == 0) goto L_0x0007
            r2 = r0
        L_0x0007:
            r11 = r10 & 2
            if (r11 == 0) goto L_0x000c
            r3 = r0
        L_0x000c:
            r11 = r10 & 4
            if (r11 == 0) goto L_0x0011
            r4 = 0
        L_0x0011:
            r11 = r10 & 8
            if (r11 == 0) goto L_0x0016
            r5 = r0
        L_0x0016:
            r11 = r10 & 16
            if (r11 == 0) goto L_0x001b
            r6 = r0
        L_0x001b:
            r11 = r10 & 32
            if (r11 == 0) goto L_0x0020
            r7 = r0
        L_0x0020:
            r11 = r10 & 64
            if (r11 == 0) goto L_0x0025
            r8 = r0
        L_0x0025:
            r10 = r10 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x002b
            r10 = r0
            goto L_0x002c
        L_0x002b:
            r10 = r9
        L_0x002c:
            r9 = r8
            r8 = r7
            r7 = r6
            r6 = r5
            r5 = r4
            r4 = r3
            r3 = r2
            r2 = r1
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.auth.retrofit.BlueLoginDetails.<init>(java.lang.String, java.lang.String, int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getAccess_token() {
        return this.access_token;
    }

    public final String getToken_type() {
        return this.token_type;
    }

    public final int getExpires_in() {
        return this.expires_in;
    }

    public final String getRefresh_token() {
        return this.refresh_token;
    }

    public final String getId_token() {
        return this.id_token;
    }

    public final String getCustom_auth_name() {
        return this.custom_auth_name;
    }

    public final String getCustom_auth_signature() {
        return this.custom_auth_signature;
    }

    public final String getCustom_auth_token() {
        return this.custom_auth_token;
    }

    public final boolean isEmpty() {
        return this.id_token.length() == 0 && this.access_token.length() == 0 && this.custom_auth_name.length() == 0;
    }
}
