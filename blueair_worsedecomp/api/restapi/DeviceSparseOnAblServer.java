package com.blueair.api.restapi;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B+\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J5\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001a"}, d2 = {"Lcom/blueair/api/restapi/DeviceSparseOnAblServer;", "", "name", "", "userId", "", "uuid", "mac", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getUserId", "()I", "getUuid", "getMac", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "api_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: UserDevicesAblRestApi.kt */
public final class DeviceSparseOnAblServer {
    private final String mac;
    private final String name;
    private final int userId;
    private final String uuid;

    public static /* synthetic */ DeviceSparseOnAblServer copy$default(DeviceSparseOnAblServer deviceSparseOnAblServer, String str, int i, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = deviceSparseOnAblServer.name;
        }
        if ((i2 & 2) != 0) {
            i = deviceSparseOnAblServer.userId;
        }
        if ((i2 & 4) != 0) {
            str2 = deviceSparseOnAblServer.uuid;
        }
        if ((i2 & 8) != 0) {
            str3 = deviceSparseOnAblServer.mac;
        }
        return deviceSparseOnAblServer.copy(str, i, str2, str3);
    }

    public final String component1() {
        return this.name;
    }

    public final int component2() {
        return this.userId;
    }

    public final String component3() {
        return this.uuid;
    }

    public final String component4() {
        return this.mac;
    }

    public final DeviceSparseOnAblServer copy(String str, int i, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str2, "uuid");
        return new DeviceSparseOnAblServer(str, i, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceSparseOnAblServer)) {
            return false;
        }
        DeviceSparseOnAblServer deviceSparseOnAblServer = (DeviceSparseOnAblServer) obj;
        return Intrinsics.areEqual((Object) this.name, (Object) deviceSparseOnAblServer.name) && this.userId == deviceSparseOnAblServer.userId && Intrinsics.areEqual((Object) this.uuid, (Object) deviceSparseOnAblServer.uuid) && Intrinsics.areEqual((Object) this.mac, (Object) deviceSparseOnAblServer.mac);
    }

    public int hashCode() {
        String str = this.name;
        int i = 0;
        int hashCode = (((((str == null ? 0 : str.hashCode()) * 31) + this.userId) * 31) + this.uuid.hashCode()) * 31;
        String str2 = this.mac;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "DeviceSparseOnAblServer(name=" + this.name + ", userId=" + this.userId + ", uuid=" + this.uuid + ", mac=" + this.mac + ')';
    }

    public DeviceSparseOnAblServer(String str, int i, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str2, "uuid");
        this.name = str;
        this.userId = i;
        this.uuid = str2;
        this.mac = str3;
    }

    public final String getName() {
        return this.name;
    }

    public final int getUserId() {
        return this.userId;
    }

    public final String getUuid() {
        return this.uuid;
    }

    public final String getMac() {
        return this.mac;
    }
}
