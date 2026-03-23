package com.blueair.api.restapi;

import com.blueair.push.NotificationService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/blueair/api/restapi/Include;", "", "filter", "Lcom/blueair/api/restapi/Filter;", "<init>", "(Lcom/blueair/api/restapi/Filter;)V", "getFilter", "()Lcom/blueair/api/restapi/Filter;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "api_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: UserDevicesBlueRestApi.kt */
public final class Include {
    private final Filter filter;

    public static /* synthetic */ Include copy$default(Include include, Filter filter2, int i, Object obj) {
        if ((i & 1) != 0) {
            filter2 = include.filter;
        }
        return include.copy(filter2);
    }

    public final Filter component1() {
        return this.filter;
    }

    public final Include copy(Filter filter2) {
        Intrinsics.checkNotNullParameter(filter2, NotificationService.ACTION_TYPE_FILTER);
        return new Include(filter2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Include) && Intrinsics.areEqual((Object) this.filter, (Object) ((Include) obj).filter);
    }

    public int hashCode() {
        return this.filter.hashCode();
    }

    public String toString() {
        return "Include(filter=" + this.filter + ')';
    }

    public Include(Filter filter2) {
        Intrinsics.checkNotNullParameter(filter2, NotificationService.ACTION_TYPE_FILTER);
        this.filter = filter2;
    }

    public final Filter getFilter() {
        return this.filter;
    }
}
