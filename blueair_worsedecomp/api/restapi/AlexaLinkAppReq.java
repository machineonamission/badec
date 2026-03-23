package com.blueair.api.restapi;

import com.blueair.adddevice.model.AddDeviceState$$ExternalSyntheticBackport0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\tHÆ\u0003JE\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2 = {"Lcom/blueair/api/restapi/AlexaLinkAppReq;", "", "clientId", "", "responseType", "state", "scope", "redirectUri", "userAccepted", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getClientId", "()Ljava/lang/String;", "getResponseType", "getState", "getScope", "getRedirectUri", "getUserAccepted", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "api_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: UserDevicesBlueRestApi.kt */
public final class AlexaLinkAppReq {
    private final String clientId;
    private final String redirectUri;
    private final String responseType;
    private final String scope;
    private final String state;
    private final boolean userAccepted;

    public static /* synthetic */ AlexaLinkAppReq copy$default(AlexaLinkAppReq alexaLinkAppReq, String str, String str2, String str3, String str4, String str5, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = alexaLinkAppReq.clientId;
        }
        if ((i & 2) != 0) {
            str2 = alexaLinkAppReq.responseType;
        }
        if ((i & 4) != 0) {
            str3 = alexaLinkAppReq.state;
        }
        if ((i & 8) != 0) {
            str4 = alexaLinkAppReq.scope;
        }
        if ((i & 16) != 0) {
            str5 = alexaLinkAppReq.redirectUri;
        }
        if ((i & 32) != 0) {
            z = alexaLinkAppReq.userAccepted;
        }
        String str6 = str5;
        boolean z2 = z;
        String str7 = str4;
        String str8 = str2;
        return alexaLinkAppReq.copy(str, str8, str3, str7, str6, z2);
    }

    public final String component1() {
        return this.clientId;
    }

    public final String component2() {
        return this.responseType;
    }

    public final String component3() {
        return this.state;
    }

    public final String component4() {
        return this.scope;
    }

    public final String component5() {
        return this.redirectUri;
    }

    public final boolean component6() {
        return this.userAccepted;
    }

    public final AlexaLinkAppReq copy(String str, String str2, String str3, String str4, String str5, boolean z) {
        Intrinsics.checkNotNullParameter(str, "clientId");
        Intrinsics.checkNotNullParameter(str2, "responseType");
        Intrinsics.checkNotNullParameter(str3, "state");
        Intrinsics.checkNotNullParameter(str4, "scope");
        Intrinsics.checkNotNullParameter(str5, "redirectUri");
        return new AlexaLinkAppReq(str, str2, str3, str4, str5, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AlexaLinkAppReq)) {
            return false;
        }
        AlexaLinkAppReq alexaLinkAppReq = (AlexaLinkAppReq) obj;
        return Intrinsics.areEqual((Object) this.clientId, (Object) alexaLinkAppReq.clientId) && Intrinsics.areEqual((Object) this.responseType, (Object) alexaLinkAppReq.responseType) && Intrinsics.areEqual((Object) this.state, (Object) alexaLinkAppReq.state) && Intrinsics.areEqual((Object) this.scope, (Object) alexaLinkAppReq.scope) && Intrinsics.areEqual((Object) this.redirectUri, (Object) alexaLinkAppReq.redirectUri) && this.userAccepted == alexaLinkAppReq.userAccepted;
    }

    public int hashCode() {
        return (((((((((this.clientId.hashCode() * 31) + this.responseType.hashCode()) * 31) + this.state.hashCode()) * 31) + this.scope.hashCode()) * 31) + this.redirectUri.hashCode()) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.userAccepted);
    }

    public String toString() {
        return "AlexaLinkAppReq(clientId=" + this.clientId + ", responseType=" + this.responseType + ", state=" + this.state + ", scope=" + this.scope + ", redirectUri=" + this.redirectUri + ", userAccepted=" + this.userAccepted + ')';
    }

    public AlexaLinkAppReq(String str, String str2, String str3, String str4, String str5, boolean z) {
        Intrinsics.checkNotNullParameter(str, "clientId");
        Intrinsics.checkNotNullParameter(str2, "responseType");
        Intrinsics.checkNotNullParameter(str3, "state");
        Intrinsics.checkNotNullParameter(str4, "scope");
        Intrinsics.checkNotNullParameter(str5, "redirectUri");
        this.clientId = str;
        this.responseType = str2;
        this.state = str3;
        this.scope = str4;
        this.redirectUri = str5;
        this.userAccepted = z;
    }

    public final String getClientId() {
        return this.clientId;
    }

    public final String getResponseType() {
        return this.responseType;
    }

    public final String getState() {
        return this.state;
    }

    public final String getScope() {
        return this.scope;
    }

    public final String getRedirectUri() {
        return this.redirectUri;
    }

    public final boolean getUserAccepted() {
        return this.userAccepted;
    }
}
