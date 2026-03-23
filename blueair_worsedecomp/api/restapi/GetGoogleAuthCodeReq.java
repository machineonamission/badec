package com.blueair.api.restapi;

import com.gigya.android.sdk.GigyaDefinitions;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/blueair/api/restapi/GetGoogleAuthCodeReq;", "", "clientId", "", "idToken", "type", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getClientId", "()Ljava/lang/String;", "getIdToken", "getType", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "api_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: UserDevicesBlueRestApi.kt */
public final class GetGoogleAuthCodeReq {
    private final String clientId;
    private final String idToken;
    private final String type;

    public static /* synthetic */ GetGoogleAuthCodeReq copy$default(GetGoogleAuthCodeReq getGoogleAuthCodeReq, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = getGoogleAuthCodeReq.clientId;
        }
        if ((i & 2) != 0) {
            str2 = getGoogleAuthCodeReq.idToken;
        }
        if ((i & 4) != 0) {
            str3 = getGoogleAuthCodeReq.type;
        }
        return getGoogleAuthCodeReq.copy(str, str2, str3);
    }

    public final String component1() {
        return this.clientId;
    }

    public final String component2() {
        return this.idToken;
    }

    public final String component3() {
        return this.type;
    }

    public final GetGoogleAuthCodeReq copy(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "clientId");
        Intrinsics.checkNotNullParameter(str2, "idToken");
        Intrinsics.checkNotNullParameter(str3, "type");
        return new GetGoogleAuthCodeReq(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetGoogleAuthCodeReq)) {
            return false;
        }
        GetGoogleAuthCodeReq getGoogleAuthCodeReq = (GetGoogleAuthCodeReq) obj;
        return Intrinsics.areEqual((Object) this.clientId, (Object) getGoogleAuthCodeReq.clientId) && Intrinsics.areEqual((Object) this.idToken, (Object) getGoogleAuthCodeReq.idToken) && Intrinsics.areEqual((Object) this.type, (Object) getGoogleAuthCodeReq.type);
    }

    public int hashCode() {
        return (((this.clientId.hashCode() * 31) + this.idToken.hashCode()) * 31) + this.type.hashCode();
    }

    public String toString() {
        return "GetGoogleAuthCodeReq(clientId=" + this.clientId + ", idToken=" + this.idToken + ", type=" + this.type + ')';
    }

    public GetGoogleAuthCodeReq(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "clientId");
        Intrinsics.checkNotNullParameter(str2, "idToken");
        Intrinsics.checkNotNullParameter(str3, "type");
        this.clientId = str;
        this.idToken = str2;
        this.type = str3;
    }

    public final String getClientId() {
        return this.clientId;
    }

    public final String getIdToken() {
        return this.idToken;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GetGoogleAuthCodeReq(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? GigyaDefinitions.Providers.GOOGLE : str3);
    }

    public final String getType() {
        return this.type;
    }
}
