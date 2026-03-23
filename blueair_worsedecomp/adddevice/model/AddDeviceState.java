package com.blueair.adddevice.model;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import com.blueair.adddevice.DeviceInformationLegacy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u0002\n\u0002\b\u0019\n\u0002\u0010\u0000\n\u0002\b\u0004\b\b\u0018\u0000 \\2\u00020\u0001:\u0001\\BÓ\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0005¢\u0006\u0004\b\u001a\u0010\u001bB\u0011\b\u0016\u0012\u0006\u0010\u001c\u001a\u00020\u001d¢\u0006\u0004\b\u001a\u0010\u001eJ\u0006\u00107\u001a\u00020\u0003J\u0006\u00108\u001a\u00020\u0005J\u0006\u00109\u001a\u00020\u0005J\u0006\u0010:\u001a\u00020\u0005J\u0006\u0010;\u001a\u00020\u0005J\u0006\u0010<\u001a\u00020\u0005J\b\u0010=\u001a\u00020\u0003H\u0016J\u0018\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020\u001d2\u0006\u0010A\u001a\u00020\u0003H\u0016J\t\u0010B\u001a\u00020\u0003HÆ\u0003J\t\u0010C\u001a\u00020\u0005HÆ\u0003J\t\u0010D\u001a\u00020\u0003HÆ\u0003J\t\u0010E\u001a\u00020\u0005HÆ\u0003J\t\u0010F\u001a\u00020\u0003HÆ\u0003J\t\u0010G\u001a\u00020\u0003HÆ\u0003J\t\u0010H\u001a\u00020\u0005HÆ\u0003J\t\u0010I\u001a\u00020\u0005HÆ\u0003J\t\u0010J\u001a\u00020\u0005HÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\t\u0010M\u001a\u00020\u0005HÆ\u0003J\t\u0010N\u001a\u00020\u0003HÆ\u0003J\t\u0010O\u001a\u00020\u0005HÆ\u0003J\t\u0010P\u001a\u00020\u0005HÆ\u0003J\t\u0010Q\u001a\u00020\u0005HÆ\u0003J\t\u0010R\u001a\u00020\u0005HÆ\u0003J\t\u0010S\u001a\u00020\u0003HÆ\u0003J\t\u0010T\u001a\u00020\u0005HÆ\u0003J\t\u0010U\u001a\u00020\u0005HÆ\u0003JÕ\u0001\u0010V\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u00052\b\b\u0002\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00052\b\b\u0002\u0010\u0019\u001a\u00020\u0005HÆ\u0001J\u0013\u0010W\u001a\u00020\u00052\b\u0010X\u001a\u0004\u0018\u00010YHÖ\u0003J\t\u0010Z\u001a\u00020\u0003HÖ\u0001J\t\u0010[\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010 R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\"R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010 R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010 R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\"R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\"R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\"R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010\u0011\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\"R\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010 R\u0011\u0010\u0013\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\"R\u0011\u0010\u0014\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\"R\u0011\u0010\u0015\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\"R\u0011\u0010\u0016\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\"R\u0011\u0010\u0017\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b4\u0010 R\u0011\u0010\u0018\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\"R\u0011\u0010\u0019\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\"¨\u0006]"}, d2 = {"Lcom/blueair/adddevice/model/AddDeviceState;", "Landroid/os/Parcelable;", "deviceType", "", "autoMode", "", "autoStepsCompleted", "autoFailed", "autoFailStepsCompleted", "manualStepsCompleted", "manualValidated", "manualFailed", "networkInfoSet", "deviceInfo", "Lcom/blueair/adddevice/DeviceInformationLegacy;", "deviceName", "", "backendSuccess", "otaCheckAttempt", "otaCheckCompleted", "resetDevice", "initialTextSeen", "successScreen", "icpStepsCompleted", "migrationOtaCheckCompleted", "troubleshoot", "<init>", "(IZIZIIZZZLcom/blueair/adddevice/DeviceInformationLegacy;Ljava/lang/String;ZIZZZZIZZ)V", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getDeviceType", "()I", "getAutoMode", "()Z", "getAutoStepsCompleted", "getAutoFailed", "getAutoFailStepsCompleted", "getManualStepsCompleted", "getManualValidated", "getManualFailed", "getNetworkInfoSet", "getDeviceInfo", "()Lcom/blueair/adddevice/DeviceInformationLegacy;", "getDeviceName", "()Ljava/lang/String;", "getBackendSuccess", "getOtaCheckAttempt", "getOtaCheckCompleted", "getResetDevice", "getInitialTextSeen", "getSuccessScreen", "getIcpStepsCompleted", "getMigrationOtaCheckCompleted", "getTroubleshoot", "getCurrentConfigMode", "isReadyForBackendAdding", "isReadyForOta", "isSuccess", "isReadyForNaming", "isReadyForMigrationOta", "describeContents", "writeToParcel", "", "dest", "flags", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "copy", "equals", "other", "", "hashCode", "toString", "Companion", "adddevice_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: AddDeviceState.kt */
public final class AddDeviceState implements Parcelable {
    public static final Parcelable.Creator<AddDeviceState> CREATOR = new AddDeviceState$Companion$CREATOR$1();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int DEVICE_CONFIG_MODE_AUTO = 0;
    public static final int DEVICE_CONFIG_MODE_MANUAL = 1;
    private final int autoFailStepsCompleted;
    private final boolean autoFailed;
    private final boolean autoMode;
    private final int autoStepsCompleted;
    private final boolean backendSuccess;
    private final DeviceInformationLegacy deviceInfo;
    private final String deviceName;
    private final int deviceType;
    private final int icpStepsCompleted;
    private final boolean initialTextSeen;
    private final boolean manualFailed;
    private final int manualStepsCompleted;
    private final boolean manualValidated;
    private final boolean migrationOtaCheckCompleted;
    private final boolean networkInfoSet;
    private final int otaCheckAttempt;
    private final boolean otaCheckCompleted;
    private final boolean resetDevice;
    private final boolean successScreen;
    private final boolean troubleshoot;

    public AddDeviceState() {
        this(0, false, 0, false, 0, 0, false, false, false, (DeviceInformationLegacy) null, (String) null, false, 0, false, false, false, false, 0, false, false, 1048575, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ AddDeviceState copy$default(AddDeviceState addDeviceState, int i, boolean z, int i2, boolean z2, int i3, int i4, boolean z3, boolean z4, boolean z5, DeviceInformationLegacy deviceInformationLegacy, String str, boolean z6, int i5, boolean z7, boolean z8, boolean z9, boolean z10, int i6, boolean z11, boolean z12, int i7, Object obj) {
        boolean z13;
        boolean z14;
        AddDeviceState addDeviceState2 = addDeviceState;
        int i8 = i7;
        int i9 = (i8 & 1) != 0 ? addDeviceState2.deviceType : i;
        boolean z15 = (i8 & 2) != 0 ? addDeviceState2.autoMode : z;
        int i10 = (i8 & 4) != 0 ? addDeviceState2.autoStepsCompleted : i2;
        boolean z16 = (i8 & 8) != 0 ? addDeviceState2.autoFailed : z2;
        int i11 = (i8 & 16) != 0 ? addDeviceState2.autoFailStepsCompleted : i3;
        int i12 = (i8 & 32) != 0 ? addDeviceState2.manualStepsCompleted : i4;
        boolean z17 = (i8 & 64) != 0 ? addDeviceState2.manualValidated : z3;
        boolean z18 = (i8 & 128) != 0 ? addDeviceState2.manualFailed : z4;
        boolean z19 = (i8 & 256) != 0 ? addDeviceState2.networkInfoSet : z5;
        DeviceInformationLegacy deviceInformationLegacy2 = (i8 & 512) != 0 ? addDeviceState2.deviceInfo : deviceInformationLegacy;
        String str2 = (i8 & 1024) != 0 ? addDeviceState2.deviceName : str;
        boolean z20 = (i8 & 2048) != 0 ? addDeviceState2.backendSuccess : z6;
        int i13 = (i8 & 4096) != 0 ? addDeviceState2.otaCheckAttempt : i5;
        boolean z21 = (i8 & 8192) != 0 ? addDeviceState2.otaCheckCompleted : z7;
        int i14 = i9;
        boolean z22 = (i8 & 16384) != 0 ? addDeviceState2.resetDevice : z8;
        boolean z23 = (i8 & 32768) != 0 ? addDeviceState2.initialTextSeen : z9;
        boolean z24 = (i7 & 65536) != 0 ? addDeviceState2.successScreen : z10;
        int i15 = (i7 & 131072) != 0 ? addDeviceState2.icpStepsCompleted : i6;
        boolean z25 = (i7 & 262144) != 0 ? addDeviceState2.migrationOtaCheckCompleted : z11;
        if ((i7 & 524288) != 0) {
            z14 = z25;
            z13 = addDeviceState2.troubleshoot;
        } else {
            z13 = z12;
            z14 = z25;
        }
        return addDeviceState2.copy(i14, z15, i10, z16, i11, i12, z17, z18, z19, deviceInformationLegacy2, str2, z20, i13, z21, z22, z23, z24, i15, z14, z13);
    }

    public final int component1() {
        return this.deviceType;
    }

    public final DeviceInformationLegacy component10() {
        return this.deviceInfo;
    }

    public final String component11() {
        return this.deviceName;
    }

    public final boolean component12() {
        return this.backendSuccess;
    }

    public final int component13() {
        return this.otaCheckAttempt;
    }

    public final boolean component14() {
        return this.otaCheckCompleted;
    }

    public final boolean component15() {
        return this.resetDevice;
    }

    public final boolean component16() {
        return this.initialTextSeen;
    }

    public final boolean component17() {
        return this.successScreen;
    }

    public final int component18() {
        return this.icpStepsCompleted;
    }

    public final boolean component19() {
        return this.migrationOtaCheckCompleted;
    }

    public final boolean component2() {
        return this.autoMode;
    }

    public final boolean component20() {
        return this.troubleshoot;
    }

    public final int component3() {
        return this.autoStepsCompleted;
    }

    public final boolean component4() {
        return this.autoFailed;
    }

    public final int component5() {
        return this.autoFailStepsCompleted;
    }

    public final int component6() {
        return this.manualStepsCompleted;
    }

    public final boolean component7() {
        return this.manualValidated;
    }

    public final boolean component8() {
        return this.manualFailed;
    }

    public final boolean component9() {
        return this.networkInfoSet;
    }

    public final AddDeviceState copy(int i, boolean z, int i2, boolean z2, int i3, int i4, boolean z3, boolean z4, boolean z5, DeviceInformationLegacy deviceInformationLegacy, String str, boolean z6, int i5, boolean z7, boolean z8, boolean z9, boolean z10, int i6, boolean z11, boolean z12) {
        return new AddDeviceState(i, z, i2, z2, i3, i4, z3, z4, z5, deviceInformationLegacy, str, z6, i5, z7, z8, z9, z10, i6, z11, z12);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AddDeviceState)) {
            return false;
        }
        AddDeviceState addDeviceState = (AddDeviceState) obj;
        return this.deviceType == addDeviceState.deviceType && this.autoMode == addDeviceState.autoMode && this.autoStepsCompleted == addDeviceState.autoStepsCompleted && this.autoFailed == addDeviceState.autoFailed && this.autoFailStepsCompleted == addDeviceState.autoFailStepsCompleted && this.manualStepsCompleted == addDeviceState.manualStepsCompleted && this.manualValidated == addDeviceState.manualValidated && this.manualFailed == addDeviceState.manualFailed && this.networkInfoSet == addDeviceState.networkInfoSet && Intrinsics.areEqual((Object) this.deviceInfo, (Object) addDeviceState.deviceInfo) && Intrinsics.areEqual((Object) this.deviceName, (Object) addDeviceState.deviceName) && this.backendSuccess == addDeviceState.backendSuccess && this.otaCheckAttempt == addDeviceState.otaCheckAttempt && this.otaCheckCompleted == addDeviceState.otaCheckCompleted && this.resetDevice == addDeviceState.resetDevice && this.initialTextSeen == addDeviceState.initialTextSeen && this.successScreen == addDeviceState.successScreen && this.icpStepsCompleted == addDeviceState.icpStepsCompleted && this.migrationOtaCheckCompleted == addDeviceState.migrationOtaCheckCompleted && this.troubleshoot == addDeviceState.troubleshoot;
    }

    public int hashCode() {
        int m = ((((((((((((((((this.deviceType * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.autoMode)) * 31) + this.autoStepsCompleted) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.autoFailed)) * 31) + this.autoFailStepsCompleted) * 31) + this.manualStepsCompleted) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.manualValidated)) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.manualFailed)) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.networkInfoSet)) * 31;
        DeviceInformationLegacy deviceInformationLegacy = this.deviceInfo;
        int i = 0;
        int hashCode = (m + (deviceInformationLegacy == null ? 0 : deviceInformationLegacy.hashCode())) * 31;
        String str = this.deviceName;
        if (str != null) {
            i = str.hashCode();
        }
        return ((((((((((((((((((hashCode + i) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.backendSuccess)) * 31) + this.otaCheckAttempt) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.otaCheckCompleted)) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.resetDevice)) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.initialTextSeen)) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.successScreen)) * 31) + this.icpStepsCompleted) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.migrationOtaCheckCompleted)) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.troubleshoot);
    }

    public String toString() {
        return "AddDeviceState(deviceType=" + this.deviceType + ", autoMode=" + this.autoMode + ", autoStepsCompleted=" + this.autoStepsCompleted + ", autoFailed=" + this.autoFailed + ", autoFailStepsCompleted=" + this.autoFailStepsCompleted + ", manualStepsCompleted=" + this.manualStepsCompleted + ", manualValidated=" + this.manualValidated + ", manualFailed=" + this.manualFailed + ", networkInfoSet=" + this.networkInfoSet + ", deviceInfo=" + this.deviceInfo + ", deviceName=" + this.deviceName + ", backendSuccess=" + this.backendSuccess + ", otaCheckAttempt=" + this.otaCheckAttempt + ", otaCheckCompleted=" + this.otaCheckCompleted + ", resetDevice=" + this.resetDevice + ", initialTextSeen=" + this.initialTextSeen + ", successScreen=" + this.successScreen + ", icpStepsCompleted=" + this.icpStepsCompleted + ", migrationOtaCheckCompleted=" + this.migrationOtaCheckCompleted + ", troubleshoot=" + this.troubleshoot + ')';
    }

    public AddDeviceState(int i, boolean z, int i2, boolean z2, int i3, int i4, boolean z3, boolean z4, boolean z5, DeviceInformationLegacy deviceInformationLegacy, String str, boolean z6, int i5, boolean z7, boolean z8, boolean z9, boolean z10, int i6, boolean z11, boolean z12) {
        this.deviceType = i;
        this.autoMode = z;
        this.autoStepsCompleted = i2;
        this.autoFailed = z2;
        this.autoFailStepsCompleted = i3;
        this.manualStepsCompleted = i4;
        this.manualValidated = z3;
        this.manualFailed = z4;
        this.networkInfoSet = z5;
        this.deviceInfo = deviceInformationLegacy;
        this.deviceName = str;
        this.backendSuccess = z6;
        this.otaCheckAttempt = i5;
        this.otaCheckCompleted = z7;
        this.resetDevice = z8;
        this.initialTextSeen = z9;
        this.successScreen = z10;
        this.icpStepsCompleted = i6;
        this.migrationOtaCheckCompleted = z11;
        this.troubleshoot = z12;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ AddDeviceState(int r22, boolean r23, int r24, boolean r25, int r26, int r27, boolean r28, boolean r29, boolean r30, com.blueair.adddevice.DeviceInformationLegacy r31, java.lang.String r32, boolean r33, int r34, boolean r35, boolean r36, boolean r37, boolean r38, int r39, boolean r40, boolean r41, int r42, kotlin.jvm.internal.DefaultConstructorMarker r43) {
        /*
            r21 = this;
            r0 = r42
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0008
            r1 = 0
            goto L_0x000a
        L_0x0008:
            r1 = r22
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = 1
            goto L_0x0012
        L_0x0010:
            r3 = r23
        L_0x0012:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0018
            r4 = 0
            goto L_0x001a
        L_0x0018:
            r4 = r24
        L_0x001a:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0020
            r5 = 0
            goto L_0x0022
        L_0x0020:
            r5 = r25
        L_0x0022:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0028
            r6 = 0
            goto L_0x002a
        L_0x0028:
            r6 = r26
        L_0x002a:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0030
            r7 = 0
            goto L_0x0032
        L_0x0030:
            r7 = r27
        L_0x0032:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0038
            r8 = 0
            goto L_0x003a
        L_0x0038:
            r8 = r28
        L_0x003a:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x0040
            r9 = 0
            goto L_0x0042
        L_0x0040:
            r9 = r29
        L_0x0042:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0048
            r10 = 0
            goto L_0x004a
        L_0x0048:
            r10 = r30
        L_0x004a:
            r11 = r0 & 512(0x200, float:7.175E-43)
            r12 = 0
            if (r11 == 0) goto L_0x0051
            r11 = r12
            goto L_0x0053
        L_0x0051:
            r11 = r31
        L_0x0053:
            r13 = r0 & 1024(0x400, float:1.435E-42)
            if (r13 == 0) goto L_0x0058
            goto L_0x005a
        L_0x0058:
            r12 = r32
        L_0x005a:
            r13 = r0 & 2048(0x800, float:2.87E-42)
            if (r13 == 0) goto L_0x0060
            r13 = 0
            goto L_0x0062
        L_0x0060:
            r13 = r33
        L_0x0062:
            r14 = r0 & 4096(0x1000, float:5.74E-42)
            if (r14 == 0) goto L_0x0068
            r14 = 0
            goto L_0x006a
        L_0x0068:
            r14 = r34
        L_0x006a:
            r15 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r15 == 0) goto L_0x0070
            r15 = 0
            goto L_0x0072
        L_0x0070:
            r15 = r35
        L_0x0072:
            r2 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r2 == 0) goto L_0x0078
            r2 = 0
            goto L_0x007a
        L_0x0078:
            r2 = r36
        L_0x007a:
            r16 = 32768(0x8000, float:4.5918E-41)
            r16 = r0 & r16
            if (r16 == 0) goto L_0x0084
            r16 = 0
            goto L_0x0086
        L_0x0084:
            r16 = r37
        L_0x0086:
            r17 = 65536(0x10000, float:9.18355E-41)
            r17 = r0 & r17
            if (r17 == 0) goto L_0x008f
            r17 = 0
            goto L_0x0091
        L_0x008f:
            r17 = r38
        L_0x0091:
            r18 = 131072(0x20000, float:1.83671E-40)
            r18 = r0 & r18
            if (r18 == 0) goto L_0x009a
            r18 = -1
            goto L_0x009c
        L_0x009a:
            r18 = r39
        L_0x009c:
            r19 = 262144(0x40000, float:3.67342E-40)
            r19 = r0 & r19
            if (r19 == 0) goto L_0x00a5
            r19 = 0
            goto L_0x00a7
        L_0x00a5:
            r19 = r40
        L_0x00a7:
            r20 = 524288(0x80000, float:7.34684E-40)
            r0 = r0 & r20
            if (r0 == 0) goto L_0x00b0
            r42 = 0
            goto L_0x00b2
        L_0x00b0:
            r42 = r41
        L_0x00b2:
            r22 = r21
            r23 = r1
            r37 = r2
            r24 = r3
            r25 = r4
            r26 = r5
            r27 = r6
            r28 = r7
            r29 = r8
            r30 = r9
            r31 = r10
            r32 = r11
            r33 = r12
            r34 = r13
            r35 = r14
            r36 = r15
            r38 = r16
            r39 = r17
            r40 = r18
            r41 = r19
            r22.<init>(r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.adddevice.model.AddDeviceState.<init>(int, boolean, int, boolean, int, int, boolean, boolean, boolean, com.blueair.adddevice.DeviceInformationLegacy, java.lang.String, boolean, int, boolean, boolean, boolean, boolean, int, boolean, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final int getDeviceType() {
        return this.deviceType;
    }

    public final boolean getAutoMode() {
        return this.autoMode;
    }

    public final int getAutoStepsCompleted() {
        return this.autoStepsCompleted;
    }

    public final boolean getAutoFailed() {
        return this.autoFailed;
    }

    public final int getAutoFailStepsCompleted() {
        return this.autoFailStepsCompleted;
    }

    public final int getManualStepsCompleted() {
        return this.manualStepsCompleted;
    }

    public final boolean getManualValidated() {
        return this.manualValidated;
    }

    public final boolean getManualFailed() {
        return this.manualFailed;
    }

    public final boolean getNetworkInfoSet() {
        return this.networkInfoSet;
    }

    public final DeviceInformationLegacy getDeviceInfo() {
        return this.deviceInfo;
    }

    public final String getDeviceName() {
        return this.deviceName;
    }

    public final boolean getBackendSuccess() {
        return this.backendSuccess;
    }

    public final int getOtaCheckAttempt() {
        return this.otaCheckAttempt;
    }

    public final boolean getOtaCheckCompleted() {
        return this.otaCheckCompleted;
    }

    public final boolean getResetDevice() {
        return this.resetDevice;
    }

    public final boolean getInitialTextSeen() {
        return this.initialTextSeen;
    }

    public final boolean getSuccessScreen() {
        return this.successScreen;
    }

    public final int getIcpStepsCompleted() {
        return this.icpStepsCompleted;
    }

    public final boolean getMigrationOtaCheckCompleted() {
        return this.migrationOtaCheckCompleted;
    }

    public final boolean getTroubleshoot() {
        return this.troubleshoot;
    }

    public final int getCurrentConfigMode() {
        return this.autoMode ^ true ? 1 : 0;
    }

    public final boolean isReadyForBackendAdding() {
        if (this.backendSuccess || this.deviceInfo == null) {
            return false;
        }
        boolean z = this.autoMode;
        if (!z || this.autoFailed) {
            return !z && !this.manualFailed;
        }
        return true;
    }

    public final boolean isReadyForOta() {
        return this.backendSuccess && !this.otaCheckCompleted;
    }

    public final boolean isSuccess() {
        return this.backendSuccess && this.deviceName != null && this.migrationOtaCheckCompleted;
    }

    public final boolean isReadyForNaming() {
        return this.backendSuccess && this.otaCheckCompleted;
    }

    public final boolean isReadyForMigrationOta() {
        return this.backendSuccess && this.deviceName != null && !this.migrationOtaCheckCompleted;
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/blueair/adddevice/model/AddDeviceState$Companion;", "", "<init>", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/blueair/adddevice/model/AddDeviceState;", "DEVICE_CONFIG_MODE_AUTO", "", "DEVICE_CONFIG_MODE_MANUAL", "readDeviceInformationLegacy", "Lcom/blueair/adddevice/DeviceInformationLegacy;", "source", "Landroid/os/Parcel;", "adddevice_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AddDeviceState.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* access modifiers changed from: private */
        public final DeviceInformationLegacy readDeviceInformationLegacy(Parcel parcel) {
            if (Build.VERSION.SDK_INT >= 33) {
                return (DeviceInformationLegacy) parcel.readParcelable(DeviceInformationLegacy.class.getClassLoader(), DeviceInformationLegacy.class);
            }
            return (DeviceInformationLegacy) parcel.readParcelable(DeviceInformationLegacy.class.getClassLoader());
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AddDeviceState(android.os.Parcel r26) {
        /*
            r25 = this;
            r0 = r26
            java.lang.String r1 = "source"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            int r3 = r0.readInt()
            int r1 = r0.readInt()
            r4 = 1
            if (r4 != r1) goto L_0x0014
            r1 = r4
            goto L_0x0015
        L_0x0014:
            r1 = 0
        L_0x0015:
            int r5 = r0.readInt()
            int r6 = r0.readInt()
            if (r4 != r6) goto L_0x0021
            r6 = r4
            goto L_0x0022
        L_0x0021:
            r6 = 0
        L_0x0022:
            int r7 = r0.readInt()
            int r8 = r0.readInt()
            int r9 = r0.readInt()
            if (r4 != r9) goto L_0x0032
            r9 = r4
            goto L_0x0033
        L_0x0032:
            r9 = 0
        L_0x0033:
            int r10 = r0.readInt()
            if (r4 != r10) goto L_0x003b
            r10 = r4
            goto L_0x003c
        L_0x003b:
            r10 = 0
        L_0x003c:
            int r11 = r0.readInt()
            if (r4 != r11) goto L_0x0044
            r11 = r4
            goto L_0x0045
        L_0x0044:
            r11 = 0
        L_0x0045:
            com.blueair.adddevice.model.AddDeviceState$Companion r12 = Companion
            com.blueair.adddevice.DeviceInformationLegacy r12 = r12.readDeviceInformationLegacy(r0)
            java.lang.String r13 = r0.readString()
            int r14 = r0.readInt()
            if (r4 != r14) goto L_0x0057
            r14 = r4
            goto L_0x0058
        L_0x0057:
            r14 = 0
        L_0x0058:
            int r15 = r0.readInt()
            int r2 = r0.readInt()
            if (r4 != r2) goto L_0x0065
            r16 = r4
            goto L_0x0067
        L_0x0065:
            r16 = 0
        L_0x0067:
            int r2 = r0.readInt()
            if (r4 != r2) goto L_0x0070
            r17 = r4
            goto L_0x0072
        L_0x0070:
            r17 = 0
        L_0x0072:
            int r2 = r0.readInt()
            if (r4 != r2) goto L_0x007b
            r18 = r4
            goto L_0x007d
        L_0x007b:
            r18 = 0
        L_0x007d:
            int r2 = r0.readInt()
            if (r4 != r2) goto L_0x0086
            r19 = r4
            goto L_0x0088
        L_0x0086:
            r19 = 0
        L_0x0088:
            int r20 = r0.readInt()
            r23 = 786432(0xc0000, float:1.102026E-39)
            r24 = 0
            r21 = 0
            r22 = 0
            r2 = r25
            r4 = r1
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.adddevice.model.AddDeviceState.<init>(android.os.Parcel):void");
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeInt(this.deviceType);
        parcel.writeInt(this.autoMode ? 1 : 0);
        parcel.writeInt(this.autoStepsCompleted);
        parcel.writeInt(this.autoFailed ? 1 : 0);
        parcel.writeInt(this.autoFailStepsCompleted);
        parcel.writeInt(this.manualStepsCompleted);
        parcel.writeInt(this.manualValidated ? 1 : 0);
        parcel.writeInt(this.manualFailed ? 1 : 0);
        parcel.writeInt(this.networkInfoSet ? 1 : 0);
        parcel.writeParcelable(this.deviceInfo, 0);
        parcel.writeString(this.deviceName);
        parcel.writeInt(this.backendSuccess ? 1 : 0);
        parcel.writeInt(this.otaCheckAttempt);
        parcel.writeInt(this.otaCheckCompleted ? 1 : 0);
        parcel.writeInt(this.resetDevice ? 1 : 0);
        parcel.writeInt(this.initialTextSeen ? 1 : 0);
        parcel.writeInt(this.successScreen ? 1 : 0);
        parcel.writeInt(this.icpStepsCompleted);
    }
}
