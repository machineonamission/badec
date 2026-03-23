package com.blueair.api.restapi;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J)\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/blueair/api/restapi/AntiFakeResetResp;", "", "status", "", "message", "", "ciphertext", "<init>", "(ILjava/lang/String;Ljava/lang/String;)V", "getStatus", "()I", "getMessage", "()Ljava/lang/String;", "getCiphertext", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "api_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: UserDevicesBlueRestApi.kt */
public final class AntiFakeResetResp {
    private final String ciphertext;
    private final String message;
    private final int status;

    public static /* synthetic */ AntiFakeResetResp copy$default(AntiFakeResetResp antiFakeResetResp, int i, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = antiFakeResetResp.status;
        }
        if ((i2 & 2) != 0) {
            str = antiFakeResetResp.message;
        }
        if ((i2 & 4) != 0) {
            str2 = antiFakeResetResp.ciphertext;
        }
        return antiFakeResetResp.copy(i, str, str2);
    }

    public final int component1() {
        return this.status;
    }

    public final String component2() {
        return this.message;
    }

    public final String component3() {
        return this.ciphertext;
    }

    public final AntiFakeResetResp copy(int i, String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "message");
        return new AntiFakeResetResp(i, str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AntiFakeResetResp)) {
            return false;
        }
        AntiFakeResetResp antiFakeResetResp = (AntiFakeResetResp) obj;
        return this.status == antiFakeResetResp.status && Intrinsics.areEqual((Object) this.message, (Object) antiFakeResetResp.message) && Intrinsics.areEqual((Object) this.ciphertext, (Object) antiFakeResetResp.ciphertext);
    }

    public int hashCode() {
        int hashCode = ((this.status * 31) + this.message.hashCode()) * 31;
        String str = this.ciphertext;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "AntiFakeResetResp(status=" + this.status + ", message=" + this.message + ", ciphertext=" + this.ciphertext + ')';
    }

    public AntiFakeResetResp(int i, String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "message");
        this.status = i;
        this.message = str;
        this.ciphertext = str2;
    }

    public final int getStatus() {
        return this.status;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getCiphertext() {
        return this.ciphertext;
    }
}
