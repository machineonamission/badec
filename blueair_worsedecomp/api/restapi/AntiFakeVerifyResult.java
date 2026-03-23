package com.blueair.api.restapi;

import com.squareup.moshi.Json;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0001\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\bHÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0010\b\u0003\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/blueair/api/restapi/AntiFakeVerifyResult;", "", "status", "", "message", "", "type", "supportedDeviceSku", "", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getStatus", "()I", "getMessage", "()Ljava/lang/String;", "getType", "getSupportedDeviceSku", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "api_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: UserDevicesBlueRestApi.kt */
public final class AntiFakeVerifyResult {
    private final String message;
    private final int status;
    private final List<String> supportedDeviceSku;
    private final String type;

    public static /* synthetic */ AntiFakeVerifyResult copy$default(AntiFakeVerifyResult antiFakeVerifyResult, int i, String str, String str2, List<String> list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = antiFakeVerifyResult.status;
        }
        if ((i2 & 2) != 0) {
            str = antiFakeVerifyResult.message;
        }
        if ((i2 & 4) != 0) {
            str2 = antiFakeVerifyResult.type;
        }
        if ((i2 & 8) != 0) {
            list = antiFakeVerifyResult.supportedDeviceSku;
        }
        return antiFakeVerifyResult.copy(i, str, str2, list);
    }

    public final int component1() {
        return this.status;
    }

    public final String component2() {
        return this.message;
    }

    public final String component3() {
        return this.type;
    }

    public final List<String> component4() {
        return this.supportedDeviceSku;
    }

    public final AntiFakeVerifyResult copy(int i, String str, @Json(name = "ctype") String str2, @Json(name = "deviceskus") List<String> list) {
        Intrinsics.checkNotNullParameter(str, "message");
        return new AntiFakeVerifyResult(i, str, str2, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AntiFakeVerifyResult)) {
            return false;
        }
        AntiFakeVerifyResult antiFakeVerifyResult = (AntiFakeVerifyResult) obj;
        return this.status == antiFakeVerifyResult.status && Intrinsics.areEqual((Object) this.message, (Object) antiFakeVerifyResult.message) && Intrinsics.areEqual((Object) this.type, (Object) antiFakeVerifyResult.type) && Intrinsics.areEqual((Object) this.supportedDeviceSku, (Object) antiFakeVerifyResult.supportedDeviceSku);
    }

    public int hashCode() {
        int hashCode = ((this.status * 31) + this.message.hashCode()) * 31;
        String str = this.type;
        int i = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        List<String> list = this.supportedDeviceSku;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "AntiFakeVerifyResult(status=" + this.status + ", message=" + this.message + ", type=" + this.type + ", supportedDeviceSku=" + this.supportedDeviceSku + ')';
    }

    public AntiFakeVerifyResult(int i, String str, @Json(name = "ctype") String str2, @Json(name = "deviceskus") List<String> list) {
        Intrinsics.checkNotNullParameter(str, "message");
        this.status = i;
        this.message = str;
        this.type = str2;
        this.supportedDeviceSku = list;
    }

    public final int getStatus() {
        return this.status;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getType() {
        return this.type;
    }

    public final List<String> getSupportedDeviceSku() {
        return this.supportedDeviceSku;
    }
}
