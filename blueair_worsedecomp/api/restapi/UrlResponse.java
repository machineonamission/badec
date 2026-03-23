package com.blueair.api.restapi;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/blueair/api/restapi/UrlResponse;", "", "url", "", "<init>", "(Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "api_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: UserDevicesBlueRestApi.kt */
public final class UrlResponse {
    private final String url;

    public static /* synthetic */ UrlResponse copy$default(UrlResponse urlResponse, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = urlResponse.url;
        }
        return urlResponse.copy(str);
    }

    public final String component1() {
        return this.url;
    }

    public final UrlResponse copy(String str) {
        Intrinsics.checkNotNullParameter(str, "url");
        return new UrlResponse(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof UrlResponse) && Intrinsics.areEqual((Object) this.url, (Object) ((UrlResponse) obj).url);
    }

    public int hashCode() {
        return this.url.hashCode();
    }

    public String toString() {
        return "UrlResponse(url=" + this.url + ')';
    }

    public UrlResponse(String str) {
        Intrinsics.checkNotNullParameter(str, "url");
        this.url = str;
    }

    public final String getUrl() {
        return this.url;
    }
}
