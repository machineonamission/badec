package com.blueair.auth.retrofit;

import com.blueair.adddevice.model.AddDeviceState$$ExternalSyntheticBackport0;
import com.squareup.moshi.Json;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0003\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/blueair/auth/retrofit/SetPushTokenRequest;", "", "token", "", "enabled", "", "osType", "<init>", "(Ljava/lang/String;ZLjava/lang/String;)V", "getToken", "()Ljava/lang/String;", "getEnabled", "()Z", "getOsType", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "auth_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: CloudAuthApi.kt */
public final class SetPushTokenRequest {
    private final boolean enabled;
    private final String osType;
    private final String token;

    public static /* synthetic */ SetPushTokenRequest copy$default(SetPushTokenRequest setPushTokenRequest, String str, boolean z, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = setPushTokenRequest.token;
        }
        if ((i & 2) != 0) {
            z = setPushTokenRequest.enabled;
        }
        if ((i & 4) != 0) {
            str2 = setPushTokenRequest.osType;
        }
        return setPushTokenRequest.copy(str, z, str2);
    }

    public final String component1() {
        return this.token;
    }

    public final boolean component2() {
        return this.enabled;
    }

    public final String component3() {
        return this.osType;
    }

    public final SetPushTokenRequest copy(String str, @Json(name = "is_enable") boolean z, @Json(name = "os_type") String str2) {
        Intrinsics.checkNotNullParameter(str, "token");
        Intrinsics.checkNotNullParameter(str2, "osType");
        return new SetPushTokenRequest(str, z, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SetPushTokenRequest)) {
            return false;
        }
        SetPushTokenRequest setPushTokenRequest = (SetPushTokenRequest) obj;
        return Intrinsics.areEqual((Object) this.token, (Object) setPushTokenRequest.token) && this.enabled == setPushTokenRequest.enabled && Intrinsics.areEqual((Object) this.osType, (Object) setPushTokenRequest.osType);
    }

    public int hashCode() {
        return (((this.token.hashCode() * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.enabled)) * 31) + this.osType.hashCode();
    }

    public String toString() {
        return "SetPushTokenRequest(token=" + this.token + ", enabled=" + this.enabled + ", osType=" + this.osType + ')';
    }

    public SetPushTokenRequest(String str, @Json(name = "is_enable") boolean z, @Json(name = "os_type") String str2) {
        Intrinsics.checkNotNullParameter(str, "token");
        Intrinsics.checkNotNullParameter(str2, "osType");
        this.token = str;
        this.enabled = z;
        this.osType = str2;
    }

    public final String getToken() {
        return this.token;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SetPushTokenRequest(String str, boolean z, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, z, (i & 4) != 0 ? "android" : str2);
    }

    public final String getOsType() {
        return this.osType;
    }
}
