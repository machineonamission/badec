package com.blueair.bluetooth.service;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/blueair/bluetooth/service/BleDeviceError;", "", "stateOccurred", "Lcom/blueair/bluetooth/service/BleDeviceState;", "message", "", "<init>", "(Lcom/blueair/bluetooth/service/BleDeviceState;Ljava/lang/String;)V", "getStateOccurred", "()Lcom/blueair/bluetooth/service/BleDeviceState;", "getMessage", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "bluetooth_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: BleDeviceService.kt */
public final class BleDeviceError {
    private final String message;
    private final BleDeviceState stateOccurred;

    public static /* synthetic */ BleDeviceError copy$default(BleDeviceError bleDeviceError, BleDeviceState bleDeviceState, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            bleDeviceState = bleDeviceError.stateOccurred;
        }
        if ((i & 2) != 0) {
            str = bleDeviceError.message;
        }
        return bleDeviceError.copy(bleDeviceState, str);
    }

    public final BleDeviceState component1() {
        return this.stateOccurred;
    }

    public final String component2() {
        return this.message;
    }

    public final BleDeviceError copy(BleDeviceState bleDeviceState, String str) {
        Intrinsics.checkNotNullParameter(bleDeviceState, "stateOccurred");
        return new BleDeviceError(bleDeviceState, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleDeviceError)) {
            return false;
        }
        BleDeviceError bleDeviceError = (BleDeviceError) obj;
        return Intrinsics.areEqual((Object) this.stateOccurred, (Object) bleDeviceError.stateOccurred) && Intrinsics.areEqual((Object) this.message, (Object) bleDeviceError.message);
    }

    public int hashCode() {
        int hashCode = this.stateOccurred.hashCode() * 31;
        String str = this.message;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "BleDeviceError(stateOccurred=" + this.stateOccurred + ", message=" + this.message + ')';
    }

    public BleDeviceError(BleDeviceState bleDeviceState, String str) {
        Intrinsics.checkNotNullParameter(bleDeviceState, "stateOccurred");
        this.stateOccurred = bleDeviceState;
        this.message = str;
    }

    public final String getMessage() {
        return this.message;
    }

    public final BleDeviceState getStateOccurred() {
        return this.stateOccurred;
    }
}
