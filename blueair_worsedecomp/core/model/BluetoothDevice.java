package com.blueair.core.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.blueair.adddevice.model.AddDeviceState$$ExternalSyntheticBackport0;
import com.blueair.core.model.DeviceType;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020\u00042\u0006\u0010A\u001a\u00020\u0004J\u0011\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020\u0000H\u0002J\t\u0010E\u001a\u00020\u0004HÆ\u0003J\t\u0010F\u001a\u00020\u0004HÆ\u0003J\t\u0010G\u001a\u00020\u0007HÆ\u0003J\u0010\u0010H\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0010J8\u0010I\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010JJ\u0006\u0010K\u001a\u00020CJ\u0013\u0010L\u001a\u00020\u00072\b\u0010D\u001a\u0004\u0018\u00010MHÖ\u0003J\t\u0010N\u001a\u00020CHÖ\u0001J\t\u0010O\u001a\u00020\u0004HÖ\u0001J\u0016\u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u00020S2\u0006\u0010T\u001a\u00020CR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\b\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\b\u0010\u0010\"\u0004\b\u0011\u0010\u0012R!\u0010\u0014\u001a\u00020\u00048FX\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\fR!\u0010\u001a\u001a\u00020\u00078FX\u0002¢\u0006\u0012\n\u0004\b\u001c\u0010\u0019\u0012\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u001a\u0010\u000fR!\u0010\u001d\u001a\u00020\u001e8FX\u0002¢\u0006\u0012\n\u0004\b\"\u0010\u0019\u0012\u0004\b\u001f\u0010\u0016\u001a\u0004\b \u0010!R!\u0010#\u001a\u00020\u00048FX\u0002¢\u0006\u0012\n\u0004\b&\u0010\u0019\u0012\u0004\b$\u0010\u0016\u001a\u0004\b%\u0010\fR!\u0010'\u001a\u00020\u00048FX\u0002¢\u0006\u0012\n\u0004\b*\u0010\u0019\u0012\u0004\b(\u0010\u0016\u001a\u0004\b)\u0010\fR!\u0010+\u001a\u00020\u00048FX\u0002¢\u0006\u0012\n\u0004\b.\u0010\u0019\u0012\u0004\b,\u0010\u0016\u001a\u0004\b-\u0010\fR!\u0010/\u001a\u00020\u00078FX\u0002¢\u0006\u0012\n\u0004\b1\u0010\u0019\u0012\u0004\b0\u0010\u0016\u001a\u0004\b/\u0010\u000fR!\u00102\u001a\u00020\u00078FX\u0002¢\u0006\u0012\n\u0004\b5\u0010\u0019\u0012\u0004\b3\u0010\u0016\u001a\u0004\b4\u0010\u000fR!\u00106\u001a\u00020\u00078FX\u0002¢\u0006\u0012\n\u0004\b9\u0010\u0019\u0012\u0004\b7\u0010\u0016\u001a\u0004\b8\u0010\u000fR!\u0010:\u001a\u00020\u00078FX\u0002¢\u0006\u0012\n\u0004\b=\u0010\u0019\u0012\u0004\b;\u0010\u0016\u001a\u0004\b<\u0010\u000f¨\u0006U"}, d2 = {"Lcom/blueair/core/model/BluetoothDevice;", "Landroid/os/Parcelable;", "", "bluetoothName", "", "mac", "connectable", "", "isOnline", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Boolean;)V", "getBluetoothName", "()Ljava/lang/String;", "getMac", "getConnectable", "()Z", "()Ljava/lang/Boolean;", "setOnline", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "sku", "getSku$annotations", "()V", "getSku", "sku$delegate", "Lkotlin/Lazy;", "isUnknownSku", "isUnknownSku$annotations", "isUnknownSku$delegate", "deviceType", "Lcom/blueair/core/model/DeviceType;", "getDeviceType$annotations", "getDeviceType", "()Lcom/blueair/core/model/DeviceType;", "deviceType$delegate", "modelName", "getModelName$annotations", "getModelName", "modelName$delegate", "familyName", "getFamilyName$annotations", "getFamilyName", "familyName$delegate", "wifiMac", "getWifiMac$annotations", "getWifiMac", "wifiMac$delegate", "isG4Plus", "isG4Plus$annotations", "isG4Plus$delegate", "autoButtonPressNeeded", "getAutoButtonPressNeeded$annotations", "getAutoButtonPressNeeded", "autoButtonPressNeeded$delegate", "hasNoAutoButton", "getHasNoAutoButton$annotations", "getHasNoAutoButton", "hasNoAutoButton$delegate", "useWaterdropAuto", "getUseWaterdropAuto$annotations", "getUseWaterdropAuto", "useWaterdropAuto$delegate", "toDevice", "Lcom/blueair/core/model/HasSKU;", "uid", "name", "compareTo", "", "other", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Boolean;)Lcom/blueair/core/model/BluetoothDevice;", "describeContents", "equals", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: BluetoothDevice.kt */
public final class BluetoothDevice implements Parcelable, Comparable<BluetoothDevice> {
    public static final Parcelable.Creator<BluetoothDevice> CREATOR = new Creator();
    private final Lazy autoButtonPressNeeded$delegate;
    private final String bluetoothName;
    private final boolean connectable;
    private final Lazy deviceType$delegate;
    private final Lazy familyName$delegate;
    private final Lazy hasNoAutoButton$delegate;
    private final Lazy isG4Plus$delegate;
    private Boolean isOnline;
    private final Lazy isUnknownSku$delegate;
    private final String mac;
    private final Lazy modelName$delegate;
    private final Lazy sku$delegate;
    private final Lazy useWaterdropAuto$delegate;
    private final Lazy wifiMac$delegate;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: BluetoothDevice.kt */
    public static final class Creator implements Parcelable.Creator<BluetoothDevice> {
        public final BluetoothDevice createFromParcel(Parcel parcel) {
            Boolean bool;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            boolean z = true;
            boolean z2 = parcel.readInt() != 0;
            if (parcel.readInt() == 0) {
                bool = null;
            } else {
                if (parcel.readInt() == 0) {
                    z = false;
                }
                bool = Boolean.valueOf(z);
            }
            return new BluetoothDevice(readString, readString2, z2, bool);
        }

        public final BluetoothDevice[] newArray(int i) {
            return new BluetoothDevice[i];
        }
    }

    public static /* synthetic */ BluetoothDevice copy$default(BluetoothDevice bluetoothDevice, String str, String str2, boolean z, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            str = bluetoothDevice.bluetoothName;
        }
        if ((i & 2) != 0) {
            str2 = bluetoothDevice.mac;
        }
        if ((i & 4) != 0) {
            z = bluetoothDevice.connectable;
        }
        if ((i & 8) != 0) {
            bool = bluetoothDevice.isOnline;
        }
        return bluetoothDevice.copy(str, str2, z, bool);
    }

    public static /* synthetic */ void getAutoButtonPressNeeded$annotations() {
    }

    public static /* synthetic */ void getDeviceType$annotations() {
    }

    public static /* synthetic */ void getFamilyName$annotations() {
    }

    public static /* synthetic */ void getHasNoAutoButton$annotations() {
    }

    public static /* synthetic */ void getModelName$annotations() {
    }

    public static /* synthetic */ void getSku$annotations() {
    }

    public static /* synthetic */ void getUseWaterdropAuto$annotations() {
    }

    public static /* synthetic */ void getWifiMac$annotations() {
    }

    public static /* synthetic */ void isG4Plus$annotations() {
    }

    public static /* synthetic */ void isUnknownSku$annotations() {
    }

    public final String component1() {
        return this.bluetoothName;
    }

    public final String component2() {
        return this.mac;
    }

    public final boolean component3() {
        return this.connectable;
    }

    public final Boolean component4() {
        return this.isOnline;
    }

    public final BluetoothDevice copy(String str, String str2, boolean z, Boolean bool) {
        Intrinsics.checkNotNullParameter(str, "bluetoothName");
        Intrinsics.checkNotNullParameter(str2, AnalyticEvent.KEY_MAC);
        return new BluetoothDevice(str, str2, z, bool);
    }

    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BluetoothDevice)) {
            return false;
        }
        BluetoothDevice bluetoothDevice = (BluetoothDevice) obj;
        return Intrinsics.areEqual((Object) this.bluetoothName, (Object) bluetoothDevice.bluetoothName) && Intrinsics.areEqual((Object) this.mac, (Object) bluetoothDevice.mac) && this.connectable == bluetoothDevice.connectable && Intrinsics.areEqual((Object) this.isOnline, (Object) bluetoothDevice.isOnline);
    }

    public int hashCode() {
        int hashCode = ((((this.bluetoothName.hashCode() * 31) + this.mac.hashCode()) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.connectable)) * 31;
        Boolean bool = this.isOnline;
        return hashCode + (bool == null ? 0 : bool.hashCode());
    }

    public String toString() {
        return "BluetoothDevice(bluetoothName=" + this.bluetoothName + ", mac=" + this.mac + ", connectable=" + this.connectable + ", isOnline=" + this.isOnline + ')';
    }

    public final void writeToParcel(Parcel parcel, int i) {
        boolean booleanValue;
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeString(this.bluetoothName);
        parcel.writeString(this.mac);
        parcel.writeInt(this.connectable ? 1 : 0);
        Boolean bool = this.isOnline;
        if (bool == null) {
            booleanValue = false;
        } else {
            parcel.writeInt(1);
            booleanValue = bool.booleanValue();
        }
        parcel.writeInt(booleanValue ? 1 : 0);
    }

    public BluetoothDevice(String str, String str2, boolean z, Boolean bool) {
        Intrinsics.checkNotNullParameter(str, "bluetoothName");
        Intrinsics.checkNotNullParameter(str2, AnalyticEvent.KEY_MAC);
        this.bluetoothName = str;
        this.mac = str2;
        this.connectable = z;
        this.isOnline = bool;
        this.sku$delegate = LazyKt.lazy(new BluetoothDevice$$ExternalSyntheticLambda1(this));
        this.isUnknownSku$delegate = LazyKt.lazy(new BluetoothDevice$$ExternalSyntheticLambda2(this));
        this.deviceType$delegate = LazyKt.lazy(new BluetoothDevice$$ExternalSyntheticLambda3(this));
        this.modelName$delegate = LazyKt.lazy(new BluetoothDevice$$ExternalSyntheticLambda4(this));
        this.familyName$delegate = LazyKt.lazy(new BluetoothDevice$$ExternalSyntheticLambda5(this));
        this.wifiMac$delegate = LazyKt.lazy(new BluetoothDevice$$ExternalSyntheticLambda6(this));
        this.isG4Plus$delegate = LazyKt.lazy(new BluetoothDevice$$ExternalSyntheticLambda7(this));
        this.autoButtonPressNeeded$delegate = LazyKt.lazy(new BluetoothDevice$$ExternalSyntheticLambda8(this));
        this.hasNoAutoButton$delegate = LazyKt.lazy(new BluetoothDevice$$ExternalSyntheticLambda9(this));
        this.useWaterdropAuto$delegate = LazyKt.lazy(new BluetoothDevice$$ExternalSyntheticLambda0(this));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BluetoothDevice(String str, String str2, boolean z, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? false : z, (i & 8) != 0 ? null : bool);
    }

    public final String getBluetoothName() {
        return this.bluetoothName;
    }

    public final String getMac() {
        return this.mac;
    }

    public final boolean getConnectable() {
        return this.connectable;
    }

    public final Boolean isOnline() {
        return this.isOnline;
    }

    public final void setOnline(Boolean bool) {
        this.isOnline = bool;
    }

    public final String getSku() {
        return (String) this.sku$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final String sku_delegate$lambda$0(BluetoothDevice bluetoothDevice) {
        return (String) CollectionsKt.first(StringsKt.split$default((CharSequence) bluetoothDevice.bluetoothName, new String[]{"_"}, false, 0, 6, (Object) null));
    }

    /* access modifiers changed from: private */
    public static final boolean isUnknownSku_delegate$lambda$1(BluetoothDevice bluetoothDevice) {
        return Intrinsics.areEqual((Object) bluetoothDevice.getDeviceType(), (Object) DeviceType.Unknown.INSTANCE);
    }

    public final boolean isUnknownSku() {
        return ((Boolean) this.isUnknownSku$delegate.getValue()).booleanValue();
    }

    /* access modifiers changed from: private */
    public static final DeviceType deviceType_delegate$lambda$2(BluetoothDevice bluetoothDevice) {
        return DeviceType.Companion.fromSkuCompat(bluetoothDevice.getSku());
    }

    public final DeviceType getDeviceType() {
        return (DeviceType) this.deviceType$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final String modelName_delegate$lambda$3(BluetoothDevice bluetoothDevice) {
        return DeviceType.Companion.modelNameFromSkuCompat(bluetoothDevice.getSku());
    }

    public final String getModelName() {
        return (String) this.modelName$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final String familyName_delegate$lambda$4(BluetoothDevice bluetoothDevice) {
        return DeviceType.Companion.familyNameFromSku(bluetoothDevice.getSku());
    }

    public final String getFamilyName() {
        return (String) this.familyName$delegate.getValue();
    }

    public final String getWifiMac() {
        return (String) this.wifiMac$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final String wifiMac_delegate$lambda$5(BluetoothDevice bluetoothDevice) {
        String takeLast = bluetoothDevice.bluetoothName.length() >= 2 ? StringsKt.takeLast(bluetoothDevice.bluetoothName, 2) : null;
        if (takeLast == null || bluetoothDevice.mac.length() < 2) {
            return bluetoothDevice.mac;
        }
        StringBuilder sb = new StringBuilder();
        String str = bluetoothDevice.mac;
        String substring = str.substring(0, str.length() - 2);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        sb.append(substring);
        sb.append(takeLast);
        return sb.toString();
    }

    public final boolean isG4Plus() {
        return ((Boolean) this.isG4Plus$delegate.getValue()).booleanValue();
    }

    /* access modifiers changed from: private */
    public static final boolean isG4Plus_delegate$lambda$6(BluetoothDevice bluetoothDevice) {
        return DeviceType.Companion.getG4Plus_SKU().contains(bluetoothDevice.getSku());
    }

    public final boolean getAutoButtonPressNeeded() {
        return ((Boolean) this.autoButtonPressNeeded$delegate.getValue()).booleanValue();
    }

    /* access modifiers changed from: private */
    public static final boolean autoButtonPressNeeded_delegate$lambda$7(BluetoothDevice bluetoothDevice) {
        return bluetoothDevice.isG4Plus() || bluetoothDevice.getDeviceType().getIndex() >= DeviceType.NewClassic.INSTANCE.getIndex();
    }

    public final boolean getHasNoAutoButton() {
        return ((Boolean) this.hasNoAutoButton$delegate.getValue()).booleanValue();
    }

    /* access modifiers changed from: private */
    public static final boolean hasNoAutoButton_delegate$lambda$8(BluetoothDevice bluetoothDevice) {
        return SetsKt.setOf(DeviceType.Pet20.INSTANCE, DeviceType.MiniRestful.INSTANCE).contains(bluetoothDevice.getDeviceType());
    }

    public final boolean getUseWaterdropAuto() {
        return ((Boolean) this.useWaterdropAuto$delegate.getValue()).booleanValue();
    }

    /* access modifiers changed from: private */
    public static final boolean useWaterdropAuto_delegate$lambda$9(BluetoothDevice bluetoothDevice) {
        return bluetoothDevice.getDeviceType() instanceof DeviceType.Humidifier20;
    }

    public final HasSKU toDevice(String str, String str2) {
        String str3 = str;
        Intrinsics.checkNotNullParameter(str3, "uid");
        String str4 = str2;
        Intrinsics.checkNotNullParameter(str4, "name");
        return new DeviceUnknown(getSku(), str3, str4, DeviceType.Companion.displayNameFromSkuCompat(getSku()), getDeviceType().getIndex(), 0, 0, getWifiMac(), (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 0, 130912, (DefaultConstructorMarker) null);
    }

    private static final int compareTo$orderByOnline(Boolean bool) {
        if (Intrinsics.areEqual((Object) bool, (Object) true)) {
            return 2;
        }
        return Intrinsics.areEqual((Object) bool, (Object) false) ? 1 : 0;
    }

    public int compareTo(BluetoothDevice bluetoothDevice) {
        Intrinsics.checkNotNullParameter(bluetoothDevice, "other");
        return compareTo$orderByOnline(this.isOnline) - compareTo$orderByOnline(bluetoothDevice.isOnline);
    }
}
