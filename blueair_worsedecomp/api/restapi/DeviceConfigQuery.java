package com.blueair.api.restapi;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/blueair/api/restapi/DeviceConfigQuery;", "", "id", "", "r", "Lcom/blueair/api/restapi/Ree;", "<init>", "(Ljava/lang/String;Lcom/blueair/api/restapi/Ree;)V", "getId", "()Ljava/lang/String;", "getR", "()Lcom/blueair/api/restapi/Ree;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "api_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: UserDevicesBlueRestApi.kt */
public final class DeviceConfigQuery {
    private final String id;
    private final Ree r;

    public static /* synthetic */ DeviceConfigQuery copy$default(DeviceConfigQuery deviceConfigQuery, String str, Ree ree, int i, Object obj) {
        if ((i & 1) != 0) {
            str = deviceConfigQuery.id;
        }
        if ((i & 2) != 0) {
            ree = deviceConfigQuery.r;
        }
        return deviceConfigQuery.copy(str, ree);
    }

    public final String component1() {
        return this.id;
    }

    public final Ree component2() {
        return this.r;
    }

    public final DeviceConfigQuery copy(String str, Ree ree) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(ree, "r");
        return new DeviceConfigQuery(str, ree);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceConfigQuery)) {
            return false;
        }
        DeviceConfigQuery deviceConfigQuery = (DeviceConfigQuery) obj;
        return Intrinsics.areEqual((Object) this.id, (Object) deviceConfigQuery.id) && Intrinsics.areEqual((Object) this.r, (Object) deviceConfigQuery.r);
    }

    public int hashCode() {
        return (this.id.hashCode() * 31) + this.r.hashCode();
    }

    public String toString() {
        return "DeviceConfigQuery(id=" + this.id + ", r=" + this.r + ')';
    }

    public DeviceConfigQuery(String str, Ree ree) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(ree, "r");
        this.id = str;
        this.r = ree;
    }

    public final String getId() {
        return this.id;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DeviceConfigQuery(String str, Ree ree, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? new Ree((List) null, 1, (DefaultConstructorMarker) null) : ree);
    }

    public final Ree getR() {
        return this.r;
    }
}
