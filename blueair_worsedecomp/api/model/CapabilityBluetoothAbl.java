package com.blueair.api.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0004HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0004HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/blueair/api/model/CapabilityBluetoothAbl;", "Lcom/blueair/api/model/UsesBluetooth;", "Lcom/blueair/api/model/UsesAblCloud;", "uid", "", "<init>", "(Ljava/lang/String;)V", "getUid", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "api_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: ConnectionCapability.kt */
public final class CapabilityBluetoothAbl implements UsesBluetooth, UsesAblCloud {
    private final String uid;

    public static /* synthetic */ CapabilityBluetoothAbl copy$default(CapabilityBluetoothAbl capabilityBluetoothAbl, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = capabilityBluetoothAbl.uid;
        }
        return capabilityBluetoothAbl.copy(str);
    }

    public final String component1() {
        return this.uid;
    }

    public final CapabilityBluetoothAbl copy(String str) {
        Intrinsics.checkNotNullParameter(str, "uid");
        return new CapabilityBluetoothAbl(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof CapabilityBluetoothAbl) && Intrinsics.areEqual((Object) this.uid, (Object) ((CapabilityBluetoothAbl) obj).uid);
    }

    public int hashCode() {
        return this.uid.hashCode();
    }

    public String toString() {
        return "CapabilityBluetoothAbl(uid=" + this.uid + ')';
    }

    public CapabilityBluetoothAbl(String str) {
        Intrinsics.checkNotNullParameter(str, "uid");
        this.uid = str;
    }

    public String getUid() {
        return this.uid;
    }
}
