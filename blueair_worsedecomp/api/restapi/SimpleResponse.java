package com.blueair.api.restapi;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/blueair/api/restapi/SimpleResponse;", "", "state", "", "message", "", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;)V", "getState", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMessage", "()Ljava/lang/String;", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/String;)Lcom/blueair/api/restapi/SimpleResponse;", "equals", "", "other", "hashCode", "toString", "api_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceAblRestApi.kt */
public final class SimpleResponse {
    private final String message;
    private final Integer state;

    public static /* synthetic */ SimpleResponse copy$default(SimpleResponse simpleResponse, Integer num, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            num = simpleResponse.state;
        }
        if ((i & 2) != 0) {
            str = simpleResponse.message;
        }
        return simpleResponse.copy(num, str);
    }

    public final Integer component1() {
        return this.state;
    }

    public final String component2() {
        return this.message;
    }

    public final SimpleResponse copy(Integer num, String str) {
        return new SimpleResponse(num, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SimpleResponse)) {
            return false;
        }
        SimpleResponse simpleResponse = (SimpleResponse) obj;
        return Intrinsics.areEqual((Object) this.state, (Object) simpleResponse.state) && Intrinsics.areEqual((Object) this.message, (Object) simpleResponse.message);
    }

    public int hashCode() {
        Integer num = this.state;
        int i = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.message;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "SimpleResponse(state=" + this.state + ", message=" + this.message + ')';
    }

    public SimpleResponse(Integer num, String str) {
        this.state = num;
        this.message = str;
    }

    public final String getMessage() {
        return this.message;
    }

    public final Integer getState() {
        return this.state;
    }
}
