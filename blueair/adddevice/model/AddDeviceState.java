package com.blueair.adddevice.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Build.VERSION;
import com.blueair.adddevice.DeviceInformationLegacy;
import com.blueair.android.BlueairApp$$ExternalSyntheticApiModelOutline0;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u0002\n\u0002\b\u0019\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000 \\2\u00020\u0001:\u0001\\BÓ\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0005¢\u0006\u0004\b\u001a\u0010\u001bB\u0011\b\u0016\u0012\u0006\u0010\u001c\u001a\u00020\u001d¢\u0006\u0004\b\u001a\u0010\u001eJ\u0006\u00107\u001a\u00020\u0003J\u0006\u00108\u001a\u00020\u0005J\u0006\u00109\u001a\u00020\u0005J\u0006\u0010:\u001a\u00020\u0005J\u0006\u0010;\u001a\u00020\u0005J\u0006\u0010<\u001a\u00020\u0005J\b\u0010=\u001a\u00020\u0003H\u0016J\u0018\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020\u001d2\u0006\u0010A\u001a\u00020\u0003H\u0016J\t\u0010B\u001a\u00020\u0003HÆ\u0003J\t\u0010C\u001a\u00020\u0005HÆ\u0003J\t\u0010D\u001a\u00020\u0003HÆ\u0003J\t\u0010E\u001a\u00020\u0005HÆ\u0003J\t\u0010F\u001a\u00020\u0003HÆ\u0003J\t\u0010G\u001a\u00020\u0003HÆ\u0003J\t\u0010H\u001a\u00020\u0005HÆ\u0003J\t\u0010I\u001a\u00020\u0005HÆ\u0003J\t\u0010J\u001a\u00020\u0005HÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\t\u0010M\u001a\u00020\u0005HÆ\u0003J\t\u0010N\u001a\u00020\u0003HÆ\u0003J\t\u0010O\u001a\u00020\u0005HÆ\u0003J\t\u0010P\u001a\u00020\u0005HÆ\u0003J\t\u0010Q\u001a\u00020\u0005HÆ\u0003J\t\u0010R\u001a\u00020\u0005HÆ\u0003J\t\u0010S\u001a\u00020\u0003HÆ\u0003J\t\u0010T\u001a\u00020\u0005HÆ\u0003J\t\u0010U\u001a\u00020\u0005HÆ\u0003JÕ\u0001\u0010V\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u00052\b\b\u0002\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00052\b\b\u0002\u0010\u0019\u001a\u00020\u0005HÆ\u0001J\u0013\u0010W\u001a\u00020\u00052\b\u0010X\u001a\u0004\u0018\u00010YHÖ\u0003J\t\u0010Z\u001a\u00020\u0003HÖ\u0001J\t\u0010[\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010 R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\"R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010 R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010 R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\"R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\"R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\"R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010\u0011\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\"R\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010 R\u0011\u0010\u0013\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\"R\u0011\u0010\u0014\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\"R\u0011\u0010\u0015\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\"R\u0011\u0010\u0016\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\"R\u0011\u0010\u0017\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b4\u0010 R\u0011\u0010\u0018\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\"R\u0011\u0010\u0019\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\"¨\u0006]"},
   d2 = {"Lcom/blueair/adddevice/model/AddDeviceState;", "Landroid/os/Parcelable;", "deviceType", "", "autoMode", "", "autoStepsCompleted", "autoFailed", "autoFailStepsCompleted", "manualStepsCompleted", "manualValidated", "manualFailed", "networkInfoSet", "deviceInfo", "Lcom/blueair/adddevice/DeviceInformationLegacy;", "deviceName", "", "backendSuccess", "otaCheckAttempt", "otaCheckCompleted", "resetDevice", "initialTextSeen", "successScreen", "icpStepsCompleted", "migrationOtaCheckCompleted", "troubleshoot", "<init>", "(IZIZIIZZZLcom/blueair/adddevice/DeviceInformationLegacy;Ljava/lang/String;ZIZZZZIZZ)V", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getDeviceType", "()I", "getAutoMode", "()Z", "getAutoStepsCompleted", "getAutoFailed", "getAutoFailStepsCompleted", "getManualStepsCompleted", "getManualValidated", "getManualFailed", "getNetworkInfoSet", "getDeviceInfo", "()Lcom/blueair/adddevice/DeviceInformationLegacy;", "getDeviceName", "()Ljava/lang/String;", "getBackendSuccess", "getOtaCheckAttempt", "getOtaCheckCompleted", "getResetDevice", "getInitialTextSeen", "getSuccessScreen", "getIcpStepsCompleted", "getMigrationOtaCheckCompleted", "getTroubleshoot", "getCurrentConfigMode", "isReadyForBackendAdding", "isReadyForOta", "isSuccess", "isReadyForNaming", "isReadyForMigrationOta", "describeContents", "writeToParcel", "", "dest", "flags", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "copy", "equals", "other", "", "hashCode", "toString", "Companion", "adddevice_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class AddDeviceState implements Parcelable {
   public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
      public AddDeviceState createFromParcel(Parcel var1) {
         Intrinsics.checkNotNullParameter(var1, "source");
         return new AddDeviceState(var1);
      }

      public AddDeviceState[] newArray(int var1) {
         return new AddDeviceState[var1];
      }
   };
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
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
      this(0, false, 0, false, 0, 0, false, false, false, (DeviceInformationLegacy)null, (String)null, false, 0, false, false, false, false, 0, false, false, 1048575, (DefaultConstructorMarker)null);
   }

   public AddDeviceState(int var1, boolean var2, int var3, boolean var4, int var5, int var6, boolean var7, boolean var8, boolean var9, DeviceInformationLegacy var10, String var11, boolean var12, int var13, boolean var14, boolean var15, boolean var16, boolean var17, int var18, boolean var19, boolean var20) {
      this.deviceType = var1;
      this.autoMode = var2;
      this.autoStepsCompleted = var3;
      this.autoFailed = var4;
      this.autoFailStepsCompleted = var5;
      this.manualStepsCompleted = var6;
      this.manualValidated = var7;
      this.manualFailed = var8;
      this.networkInfoSet = var9;
      this.deviceInfo = var10;
      this.deviceName = var11;
      this.backendSuccess = var12;
      this.otaCheckAttempt = var13;
      this.otaCheckCompleted = var14;
      this.resetDevice = var15;
      this.initialTextSeen = var16;
      this.successScreen = var17;
      this.icpStepsCompleted = var18;
      this.migrationOtaCheckCompleted = var19;
      this.troubleshoot = var20;
   }

   // $FF: synthetic method
   public AddDeviceState(int var1, boolean var2, int var3, boolean var4, int var5, int var6, boolean var7, boolean var8, boolean var9, DeviceInformationLegacy var10, String var11, boolean var12, int var13, boolean var14, boolean var15, boolean var16, boolean var17, int var18, boolean var19, boolean var20, int var21, DefaultConstructorMarker var22) {
      if ((var21 & 1) != 0) {
         var1 = 0;
      }

      if ((var21 & 2) != 0) {
         var2 = true;
      }

      if ((var21 & 4) != 0) {
         var3 = 0;
      }

      if ((var21 & 8) != 0) {
         var4 = false;
      }

      if ((var21 & 16) != 0) {
         var5 = 0;
      }

      if ((var21 & 32) != 0) {
         var6 = 0;
      }

      if ((var21 & 64) != 0) {
         var7 = false;
      }

      if ((var21 & 128) != 0) {
         var8 = false;
      }

      if ((var21 & 256) != 0) {
         var9 = false;
      }

      Object var23 = null;
      if ((var21 & 512) != 0) {
         var10 = null;
      }

      if ((var21 & 1024) != 0) {
         var11 = (String)var23;
      }

      if ((var21 & 2048) != 0) {
         var12 = false;
      }

      if ((var21 & 4096) != 0) {
         var13 = 0;
      }

      if ((var21 & 8192) != 0) {
         var14 = false;
      }

      if ((var21 & 16384) != 0) {
         var15 = false;
      }

      if ((var21 & '耀') != 0) {
         var16 = false;
      }

      if ((var21 & 65536) != 0) {
         var17 = false;
      }

      if ((var21 & 131072) != 0) {
         var18 = -1;
      }

      if ((var21 & 262144) != 0) {
         var19 = false;
      }

      if ((var21 & 524288) != 0) {
         var20 = false;
      }

      this(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15, var16, var17, var18, var19, var20);
   }

   public AddDeviceState(Parcel var1) {
      Intrinsics.checkNotNullParameter(var1, "source");
      int var6 = var1.readInt();
      boolean var7;
      if (1 == var1.readInt()) {
         var7 = true;
      } else {
         var7 = false;
      }

      int var4 = var1.readInt();
      boolean var8;
      if (1 == var1.readInt()) {
         var8 = true;
      } else {
         var8 = false;
      }

      int var3 = var1.readInt();
      int var2 = var1.readInt();
      boolean var9;
      if (1 == var1.readInt()) {
         var9 = true;
      } else {
         var9 = false;
      }

      boolean var10;
      if (1 == var1.readInt()) {
         var10 = true;
      } else {
         var10 = false;
      }

      boolean var11;
      if (1 == var1.readInt()) {
         var11 = true;
      } else {
         var11 = false;
      }

      DeviceInformationLegacy var18 = Companion.readDeviceInformationLegacy(var1);
      String var17 = var1.readString();
      boolean var12;
      if (1 == var1.readInt()) {
         var12 = true;
      } else {
         var12 = false;
      }

      int var5 = var1.readInt();
      boolean var13;
      if (1 == var1.readInt()) {
         var13 = true;
      } else {
         var13 = false;
      }

      boolean var14;
      if (1 == var1.readInt()) {
         var14 = true;
      } else {
         var14 = false;
      }

      boolean var15;
      if (1 == var1.readInt()) {
         var15 = true;
      } else {
         var15 = false;
      }

      boolean var16;
      if (1 == var1.readInt()) {
         var16 = true;
      } else {
         var16 = false;
      }

      this(var6, var7, var4, var8, var3, var2, var9, var10, var11, var18, var17, var12, var5, var13, var14, var15, var16, var1.readInt(), false, false, 786432, (DefaultConstructorMarker)null);
   }

   // $FF: synthetic method
   public static AddDeviceState copy$default(AddDeviceState var0, int var1, boolean var2, int var3, boolean var4, int var5, int var6, boolean var7, boolean var8, boolean var9, DeviceInformationLegacy var10, String var11, boolean var12, int var13, boolean var14, boolean var15, boolean var16, boolean var17, int var18, boolean var19, boolean var20, int var21, Object var22) {
      if ((var21 & 1) != 0) {
         var1 = var0.deviceType;
      }

      if ((var21 & 2) != 0) {
         var2 = var0.autoMode;
      }

      if ((var21 & 4) != 0) {
         var3 = var0.autoStepsCompleted;
      }

      if ((var21 & 8) != 0) {
         var4 = var0.autoFailed;
      }

      if ((var21 & 16) != 0) {
         var5 = var0.autoFailStepsCompleted;
      }

      if ((var21 & 32) != 0) {
         var6 = var0.manualStepsCompleted;
      }

      if ((var21 & 64) != 0) {
         var7 = var0.manualValidated;
      }

      if ((var21 & 128) != 0) {
         var8 = var0.manualFailed;
      }

      if ((var21 & 256) != 0) {
         var9 = var0.networkInfoSet;
      }

      if ((var21 & 512) != 0) {
         var10 = var0.deviceInfo;
      }

      if ((var21 & 1024) != 0) {
         var11 = var0.deviceName;
      }

      if ((var21 & 2048) != 0) {
         var12 = var0.backendSuccess;
      }

      if ((var21 & 4096) != 0) {
         var13 = var0.otaCheckAttempt;
      }

      if ((var21 & 8192) != 0) {
         var14 = var0.otaCheckCompleted;
      }

      if ((var21 & 16384) != 0) {
         var15 = var0.resetDevice;
      }

      if ((var21 & '耀') != 0) {
         var16 = var0.initialTextSeen;
      }

      if ((var21 & 65536) != 0) {
         var17 = var0.successScreen;
      }

      if ((var21 & 131072) != 0) {
         var18 = var0.icpStepsCompleted;
      }

      if ((var21 & 262144) != 0) {
         var19 = var0.migrationOtaCheckCompleted;
      }

      if ((var21 & 524288) != 0) {
         var20 = var0.troubleshoot;
      }

      return var0.copy(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15, var16, var17, var18, var19, var20);
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

   public final AddDeviceState copy(int var1, boolean var2, int var3, boolean var4, int var5, int var6, boolean var7, boolean var8, boolean var9, DeviceInformationLegacy var10, String var11, boolean var12, int var13, boolean var14, boolean var15, boolean var16, boolean var17, int var18, boolean var19, boolean var20) {
      return new AddDeviceState(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15, var16, var17, var18, var19, var20);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof AddDeviceState)) {
         return false;
      } else {
         var1 = var1;
         if (this.deviceType != var1.deviceType) {
            return false;
         } else if (this.autoMode != var1.autoMode) {
            return false;
         } else if (this.autoStepsCompleted != var1.autoStepsCompleted) {
            return false;
         } else if (this.autoFailed != var1.autoFailed) {
            return false;
         } else if (this.autoFailStepsCompleted != var1.autoFailStepsCompleted) {
            return false;
         } else if (this.manualStepsCompleted != var1.manualStepsCompleted) {
            return false;
         } else if (this.manualValidated != var1.manualValidated) {
            return false;
         } else if (this.manualFailed != var1.manualFailed) {
            return false;
         } else if (this.networkInfoSet != var1.networkInfoSet) {
            return false;
         } else if (!Intrinsics.areEqual(this.deviceInfo, var1.deviceInfo)) {
            return false;
         } else if (!Intrinsics.areEqual(this.deviceName, var1.deviceName)) {
            return false;
         } else if (this.backendSuccess != var1.backendSuccess) {
            return false;
         } else if (this.otaCheckAttempt != var1.otaCheckAttempt) {
            return false;
         } else if (this.otaCheckCompleted != var1.otaCheckCompleted) {
            return false;
         } else if (this.resetDevice != var1.resetDevice) {
            return false;
         } else if (this.initialTextSeen != var1.initialTextSeen) {
            return false;
         } else if (this.successScreen != var1.successScreen) {
            return false;
         } else if (this.icpStepsCompleted != var1.icpStepsCompleted) {
            return false;
         } else if (this.migrationOtaCheckCompleted != var1.migrationOtaCheckCompleted) {
            return false;
         } else {
            return this.troubleshoot == var1.troubleshoot;
         }
      }
   }

   public final int getAutoFailStepsCompleted() {
      return this.autoFailStepsCompleted;
   }

   public final boolean getAutoFailed() {
      return this.autoFailed;
   }

   public final boolean getAutoMode() {
      return this.autoMode;
   }

   public final int getAutoStepsCompleted() {
      return this.autoStepsCompleted;
   }

   public final boolean getBackendSuccess() {
      return this.backendSuccess;
   }

   public final int getCurrentConfigMode() {
      return this.autoMode ^ 1;
   }

   public final DeviceInformationLegacy getDeviceInfo() {
      return this.deviceInfo;
   }

   public final String getDeviceName() {
      return this.deviceName;
   }

   public final int getDeviceType() {
      return this.deviceType;
   }

   public final int getIcpStepsCompleted() {
      return this.icpStepsCompleted;
   }

   public final boolean getInitialTextSeen() {
      return this.initialTextSeen;
   }

   public final boolean getManualFailed() {
      return this.manualFailed;
   }

   public final int getManualStepsCompleted() {
      return this.manualStepsCompleted;
   }

   public final boolean getManualValidated() {
      return this.manualValidated;
   }

   public final boolean getMigrationOtaCheckCompleted() {
      return this.migrationOtaCheckCompleted;
   }

   public final boolean getNetworkInfoSet() {
      return this.networkInfoSet;
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

   public final boolean getSuccessScreen() {
      return this.successScreen;
   }

   public final boolean getTroubleshoot() {
      return this.troubleshoot;
   }

   public int hashCode() {
      int var3 = this.deviceType;
      int var7 = AddDeviceState$$ExternalSyntheticBackport0.m(this.autoMode);
      int var10 = this.autoStepsCompleted;
      int var6 = AddDeviceState$$ExternalSyntheticBackport0.m(this.autoFailed);
      int var4 = this.autoFailStepsCompleted;
      int var8 = this.manualStepsCompleted;
      int var9 = AddDeviceState$$ExternalSyntheticBackport0.m(this.manualValidated);
      int var5 = AddDeviceState$$ExternalSyntheticBackport0.m(this.manualFailed);
      int var11 = AddDeviceState$$ExternalSyntheticBackport0.m(this.networkInfoSet);
      DeviceInformationLegacy var12 = this.deviceInfo;
      int var2 = 0;
      int var1;
      if (var12 == null) {
         var1 = 0;
      } else {
         var1 = var12.hashCode();
      }

      String var13 = this.deviceName;
      if (var13 != null) {
         var2 = var13.hashCode();
      }

      return ((((((((((((((((((var3 * 31 + var7) * 31 + var10) * 31 + var6) * 31 + var4) * 31 + var8) * 31 + var9) * 31 + var5) * 31 + var11) * 31 + var1) * 31 + var2) * 31 + AddDeviceState$$ExternalSyntheticBackport0.m(this.backendSuccess)) * 31 + this.otaCheckAttempt) * 31 + AddDeviceState$$ExternalSyntheticBackport0.m(this.otaCheckCompleted)) * 31 + AddDeviceState$$ExternalSyntheticBackport0.m(this.resetDevice)) * 31 + AddDeviceState$$ExternalSyntheticBackport0.m(this.initialTextSeen)) * 31 + AddDeviceState$$ExternalSyntheticBackport0.m(this.successScreen)) * 31 + this.icpStepsCompleted) * 31 + AddDeviceState$$ExternalSyntheticBackport0.m(this.migrationOtaCheckCompleted)) * 31 + AddDeviceState$$ExternalSyntheticBackport0.m(this.troubleshoot);
   }

   public final boolean isReadyForBackendAdding() {
      if (!this.backendSuccess && this.deviceInfo != null) {
         boolean var1 = this.autoMode;
         if (var1 && !this.autoFailed || !var1 && !this.manualFailed) {
            return true;
         }
      }

      return false;
   }

   public final boolean isReadyForMigrationOta() {
      return this.backendSuccess && this.deviceName != null && !this.migrationOtaCheckCompleted;
   }

   public final boolean isReadyForNaming() {
      return this.backendSuccess && this.otaCheckCompleted;
   }

   public final boolean isReadyForOta() {
      return this.backendSuccess && !this.otaCheckCompleted;
   }

   public final boolean isSuccess() {
      return this.backendSuccess && this.deviceName != null && this.migrationOtaCheckCompleted;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("AddDeviceState(deviceType=");
      var1.append(this.deviceType);
      var1.append(", autoMode=");
      var1.append(this.autoMode);
      var1.append(", autoStepsCompleted=");
      var1.append(this.autoStepsCompleted);
      var1.append(", autoFailed=");
      var1.append(this.autoFailed);
      var1.append(", autoFailStepsCompleted=");
      var1.append(this.autoFailStepsCompleted);
      var1.append(", manualStepsCompleted=");
      var1.append(this.manualStepsCompleted);
      var1.append(", manualValidated=");
      var1.append(this.manualValidated);
      var1.append(", manualFailed=");
      var1.append(this.manualFailed);
      var1.append(", networkInfoSet=");
      var1.append(this.networkInfoSet);
      var1.append(", deviceInfo=");
      var1.append(this.deviceInfo);
      var1.append(", deviceName=");
      var1.append(this.deviceName);
      var1.append(", backendSuccess=");
      var1.append(this.backendSuccess);
      var1.append(", otaCheckAttempt=");
      var1.append(this.otaCheckAttempt);
      var1.append(", otaCheckCompleted=");
      var1.append(this.otaCheckCompleted);
      var1.append(", resetDevice=");
      var1.append(this.resetDevice);
      var1.append(", initialTextSeen=");
      var1.append(this.initialTextSeen);
      var1.append(", successScreen=");
      var1.append(this.successScreen);
      var1.append(", icpStepsCompleted=");
      var1.append(this.icpStepsCompleted);
      var1.append(", migrationOtaCheckCompleted=");
      var1.append(this.migrationOtaCheckCompleted);
      var1.append(", troubleshoot=");
      var1.append(this.troubleshoot);
      var1.append(')');
      return var1.toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "dest");
      var1.writeInt(this.deviceType);
      var1.writeInt(this.autoMode);
      var1.writeInt(this.autoStepsCompleted);
      var1.writeInt(this.autoFailed);
      var1.writeInt(this.autoFailStepsCompleted);
      var1.writeInt(this.manualStepsCompleted);
      var1.writeInt(this.manualValidated);
      var1.writeInt(this.manualFailed);
      var1.writeInt(this.networkInfoSet);
      var1.writeParcelable(this.deviceInfo, 0);
      var1.writeString(this.deviceName);
      var1.writeInt(this.backendSuccess);
      var1.writeInt(this.otaCheckAttempt);
      var1.writeInt(this.otaCheckCompleted);
      var1.writeInt(this.resetDevice);
      var1.writeInt(this.initialTextSeen);
      var1.writeInt(this.successScreen);
      var1.writeInt(this.icpStepsCompleted);
   }

   @Metadata(
      d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000e"},
      d2 = {"Lcom/blueair/adddevice/model/AddDeviceState$Companion;", "", "<init>", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/blueair/adddevice/model/AddDeviceState;", "DEVICE_CONFIG_MODE_AUTO", "", "DEVICE_CONFIG_MODE_MANUAL", "readDeviceInformationLegacy", "Lcom/blueair/adddevice/DeviceInformationLegacy;", "source", "Landroid/os/Parcel;", "adddevice_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Companion {
      private Companion() {
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker var1) {
         this();
      }

      private final DeviceInformationLegacy readDeviceInformationLegacy(Parcel var1) {
         return VERSION.SDK_INT >= 33 ? (DeviceInformationLegacy)BlueairApp$$ExternalSyntheticApiModelOutline0.m(var1, DeviceInformationLegacy.class.getClassLoader(), DeviceInformationLegacy.class) : (DeviceInformationLegacy)var1.readParcelable(DeviceInformationLegacy.class.getClassLoader());
      }
   }
}
