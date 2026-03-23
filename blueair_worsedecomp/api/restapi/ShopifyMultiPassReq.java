package com.blueair.api.restapi;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/blueair/api/restapi/ShopifyMultiPassReq;", "", "email", "", "return_to", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getEmail", "()Ljava/lang/String;", "getReturn_to", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "api_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: UserDevicesBlueRestApi.kt */
public final class ShopifyMultiPassReq {
    private final String email;
    private final String return_to;

    public static /* synthetic */ ShopifyMultiPassReq copy$default(ShopifyMultiPassReq shopifyMultiPassReq, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = shopifyMultiPassReq.email;
        }
        if ((i & 2) != 0) {
            str2 = shopifyMultiPassReq.return_to;
        }
        return shopifyMultiPassReq.copy(str, str2);
    }

    public final String component1() {
        return this.email;
    }

    public final String component2() {
        return this.return_to;
    }

    public final ShopifyMultiPassReq copy(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "email");
        Intrinsics.checkNotNullParameter(str2, "return_to");
        return new ShopifyMultiPassReq(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShopifyMultiPassReq)) {
            return false;
        }
        ShopifyMultiPassReq shopifyMultiPassReq = (ShopifyMultiPassReq) obj;
        return Intrinsics.areEqual((Object) this.email, (Object) shopifyMultiPassReq.email) && Intrinsics.areEqual((Object) this.return_to, (Object) shopifyMultiPassReq.return_to);
    }

    public int hashCode() {
        return (this.email.hashCode() * 31) + this.return_to.hashCode();
    }

    public String toString() {
        return "ShopifyMultiPassReq(email=" + this.email + ", return_to=" + this.return_to + ')';
    }

    public ShopifyMultiPassReq(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "email");
        Intrinsics.checkNotNullParameter(str2, "return_to");
        this.email = str;
        this.return_to = str2;
    }

    public final String getEmail() {
        return this.email;
    }

    public final String getReturn_to() {
        return this.return_to;
    }
}
