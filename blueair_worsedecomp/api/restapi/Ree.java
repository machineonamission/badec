package com.blueair.api.restapi;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0004HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/blueair/api/restapi/Ree;", "", "r", "", "", "<init>", "(Ljava/util/List;)V", "getR", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "api_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: UserDevicesBlueRestApi.kt */
public final class Ree {
    private final List<String> r;

    public Ree() {
        this((List) null, 1, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ Ree copy$default(Ree ree, List<String> list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = ree.r;
        }
        return ree.copy(list);
    }

    public final List<String> component1() {
        return this.r;
    }

    public final Ree copy(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "r");
        return new Ree(list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Ree) && Intrinsics.areEqual((Object) this.r, (Object) ((Ree) obj).r);
    }

    public int hashCode() {
        return this.r.hashCode();
    }

    public String toString() {
        return "Ree(r=" + this.r + ')';
    }

    public Ree(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "r");
        this.r = list;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Ree(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.listOf("sensors") : list);
    }

    public final List<String> getR() {
        return this.r;
    }
}
