package com.blueair.api.restapi;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÆ\u0003J+\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0001HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/blueair/api/restapi/UpdateWrapper;", "", "uuid", "", "da", "di", "<init>", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V", "getUuid", "()Ljava/lang/String;", "getDa", "()Ljava/lang/Object;", "getDi", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "api_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: BlueCloudRestApi.kt */
public final class UpdateWrapper {
    private final Object da;
    private final Object di;
    private final String uuid;

    public static /* synthetic */ UpdateWrapper copy$default(UpdateWrapper updateWrapper, String str, Object obj, Object obj2, int i, Object obj3) {
        if ((i & 1) != 0) {
            str = updateWrapper.uuid;
        }
        if ((i & 2) != 0) {
            obj = updateWrapper.da;
        }
        if ((i & 4) != 0) {
            obj2 = updateWrapper.di;
        }
        return updateWrapper.copy(str, obj, obj2);
    }

    public final String component1() {
        return this.uuid;
    }

    public final Object component2() {
        return this.da;
    }

    public final Object component3() {
        return this.di;
    }

    public final UpdateWrapper copy(String str, Object obj, Object obj2) {
        Intrinsics.checkNotNullParameter(str, "uuid");
        return new UpdateWrapper(str, obj, obj2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UpdateWrapper)) {
            return false;
        }
        UpdateWrapper updateWrapper = (UpdateWrapper) obj;
        return Intrinsics.areEqual((Object) this.uuid, (Object) updateWrapper.uuid) && Intrinsics.areEqual(this.da, updateWrapper.da) && Intrinsics.areEqual(this.di, updateWrapper.di);
    }

    public int hashCode() {
        int hashCode = this.uuid.hashCode() * 31;
        Object obj = this.da;
        int i = 0;
        int hashCode2 = (hashCode + (obj == null ? 0 : obj.hashCode())) * 31;
        Object obj2 = this.di;
        if (obj2 != null) {
            i = obj2.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "UpdateWrapper(uuid=" + this.uuid + ", da=" + this.da + ", di=" + this.di + ')';
    }

    public UpdateWrapper(String str, Object obj, Object obj2) {
        Intrinsics.checkNotNullParameter(str, "uuid");
        this.uuid = str;
        this.da = obj;
        this.di = obj2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UpdateWrapper(String str, Object obj, Object obj2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : obj, (i & 4) != 0 ? null : obj2);
    }

    public final Object getDa() {
        return this.da;
    }

    public final Object getDi() {
        return this.di;
    }

    public final String getUuid() {
        return this.uuid;
    }
}
