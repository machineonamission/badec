package com.blueair.core.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.blueair.adddevice.model.AddDeviceState$$ExternalSyntheticBackport0;
import com.blueair.core.util.SkuConfigurationManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(
   d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020\u00042\u0006\u0010E\u001a\u00020\u0004J\u0011\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020\u0000H\u0096\u0002J\t\u0010I\u001a\u00020\u0004HÆ\u0003J\t\u0010J\u001a\u00020\u0004HÆ\u0003J\t\u0010K\u001a\u00020\u0007HÆ\u0003J\u0010\u0010L\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0010J8\u0010M\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010NJ\u0006\u0010O\u001a\u00020GJ\u0013\u0010P\u001a\u00020\u00072\b\u0010H\u001a\u0004\u0018\u00010QHÖ\u0003J\t\u0010R\u001a\u00020GHÖ\u0001J\t\u0010S\u001a\u00020\u0004HÖ\u0001J\u0016\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020GR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\b\u0010\u0010\"\u0004\b\u0011\u0010\u0012R!\u0010\u0014\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\fR!\u0010\u001a\u001a\u00020\u00078FX\u0086\u0084\u0002¢\u0006\u0012\n\u0004\b\u001c\u0010\u0019\u0012\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u001a\u0010\u000fR!\u0010\u001d\u001a\u00020\u001e8FX\u0086\u0084\u0002¢\u0006\u0012\n\u0004\b\"\u0010\u0019\u0012\u0004\b\u001f\u0010\u0016\u001a\u0004\b \u0010!R!\u0010#\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\u0012\n\u0004\b&\u0010\u0019\u0012\u0004\b$\u0010\u0016\u001a\u0004\b%\u0010\fR!\u0010'\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\u0012\n\u0004\b*\u0010\u0019\u0012\u0004\b(\u0010\u0016\u001a\u0004\b)\u0010\fR!\u0010+\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\u0012\n\u0004\b.\u0010\u0019\u0012\u0004\b,\u0010\u0016\u001a\u0004\b-\u0010\fR!\u0010/\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\u0012\n\u0004\b2\u0010\u0019\u0012\u0004\b0\u0010\u0016\u001a\u0004\b1\u0010\fR!\u00103\u001a\u00020\u00078FX\u0086\u0084\u0002¢\u0006\u0012\n\u0004\b5\u0010\u0019\u0012\u0004\b4\u0010\u0016\u001a\u0004\b3\u0010\u000fR!\u00106\u001a\u00020\u00078FX\u0086\u0084\u0002¢\u0006\u0012\n\u0004\b9\u0010\u0019\u0012\u0004\b7\u0010\u0016\u001a\u0004\b8\u0010\u000fR!\u0010:\u001a\u00020\u00078FX\u0086\u0084\u0002¢\u0006\u0012\n\u0004\b=\u0010\u0019\u0012\u0004\b;\u0010\u0016\u001a\u0004\b<\u0010\u000fR!\u0010>\u001a\u00020\u00078FX\u0086\u0084\u0002¢\u0006\u0012\n\u0004\bA\u0010\u0019\u0012\u0004\b?\u0010\u0016\u001a\u0004\b@\u0010\u000f¨\u0006Y"},
   d2 = {"Lcom/blueair/core/model/BluetoothDevice;", "Landroid/os/Parcelable;", "", "bluetoothName", "", "mac", "connectable", "", "isOnline", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Boolean;)V", "getBluetoothName", "()Ljava/lang/String;", "getMac", "getConnectable", "()Z", "()Ljava/lang/Boolean;", "setOnline", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "sku", "getSku$annotations", "()V", "getSku", "sku$delegate", "Lkotlin/Lazy;", "isUnknownSku", "isUnknownSku$annotations", "isUnknownSku$delegate", "deviceType", "Lcom/blueair/core/model/DeviceType;", "getDeviceType$annotations", "getDeviceType", "()Lcom/blueair/core/model/DeviceType;", "deviceType$delegate", "modelName", "getModelName$annotations", "getModelName", "modelName$delegate", "familyName", "getFamilyName$annotations", "getFamilyName", "familyName$delegate", "wifiMac", "getWifiMac$annotations", "getWifiMac", "wifiMac$delegate", "shortMac", "getShortMac$annotations", "getShortMac", "shortMac$delegate", "isG4Plus", "isG4Plus$annotations", "isG4Plus$delegate", "buttonPressNeeded", "getButtonPressNeeded$annotations", "getButtonPressNeeded", "buttonPressNeeded$delegate", "hasNoAutoButton", "getHasNoAutoButton$annotations", "getHasNoAutoButton", "hasNoAutoButton$delegate", "useWaterdropAuto", "getUseWaterdropAuto$annotations", "getUseWaterdropAuto", "useWaterdropAuto$delegate", "toDevice", "Lcom/blueair/core/model/HasSKU;", "uid", "name", "compareTo", "", "other", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Boolean;)Lcom/blueair/core/model/BluetoothDevice;", "describeContents", "equals", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class BluetoothDevice implements Parcelable, Comparable {
   public static final Parcelable.Creator CREATOR = new Creator();
   private final String bluetoothName;
   private final Lazy buttonPressNeeded$delegate;
   private final boolean connectable;
   private final Lazy deviceType$delegate;
   private final Lazy familyName$delegate;
   private final Lazy hasNoAutoButton$delegate;
   private final Lazy isG4Plus$delegate;
   private Boolean isOnline;
   private final Lazy isUnknownSku$delegate;
   private final String mac;
   private final Lazy modelName$delegate;
   private final Lazy shortMac$delegate;
   private final Lazy sku$delegate;
   private final Lazy useWaterdropAuto$delegate;
   private final Lazy wifiMac$delegate;

   // $FF: synthetic method
   public static String $r8$lambda$_mloSAoUyXUkn1ftiYwe1USOxrI/* $FF was: $r8$lambda$-mloSAoUyXUkn1ftiYwe1USOxrI*/(BluetoothDevice var0) {
      return familyName_delegate$lambda$4(var0);
   }

   // $FF: synthetic method
   public static boolean $r8$lambda$AfN0QzyRtEBf0XymyITplqnLWWo(BluetoothDevice var0) {
      return hasNoAutoButton_delegate$lambda$9(var0);
   }

   // $FF: synthetic method
   public static String $r8$lambda$Frq9lKZBtkEB4wHbU43bgGvknR0(BluetoothDevice var0) {
      return shortMac_delegate$lambda$6(var0);
   }

   // $FF: synthetic method
   public static boolean $r8$lambda$ISK52jDd8LVmYWHpuxLsr7wq2GM(BluetoothDevice var0) {
      return buttonPressNeeded_delegate$lambda$8(var0);
   }

   // $FF: synthetic method
   public static boolean $r8$lambda$J6RVlOdGwtYDZnj4qonjhaEbMgs(BluetoothDevice var0) {
      return isG4Plus_delegate$lambda$7(var0);
   }

   // $FF: synthetic method
   public static DeviceType $r8$lambda$M3MNMt8E9Dk1kn0qCRqtgkW25mA(BluetoothDevice var0) {
      return deviceType_delegate$lambda$2(var0);
   }

   // $FF: synthetic method
   public static String $r8$lambda$Tx66FCC9u7AtzMQVtewjFEkhR3A(BluetoothDevice var0) {
      return modelName_delegate$lambda$3(var0);
   }

   // $FF: synthetic method
   public static String $r8$lambda$VuyPLD6AuDVy3JYl4lGWDajnyGk(BluetoothDevice var0) {
      return sku_delegate$lambda$0(var0);
   }

   // $FF: synthetic method
   public static boolean $r8$lambda$YkDiDJEm5ObjhlisGK6jrkeSANQ(BluetoothDevice var0) {
      return isUnknownSku_delegate$lambda$1(var0);
   }

   // $FF: synthetic method
   public static String $r8$lambda$dYySK1ylXHzPXJhC9Aol_9Zb480/* $FF was: $r8$lambda$dYySK1ylXHzPXJhC9Aol-9Zb480*/(BluetoothDevice var0) {
      return wifiMac_delegate$lambda$5(var0);
   }

   // $FF: synthetic method
   public static boolean $r8$lambda$rK7F3_QUq9hqWNDoncRoaMWSMXQ/* $FF was: $r8$lambda$rK7F3-QUq9hqWNDoncRoaMWSMXQ*/(BluetoothDevice var0) {
      return useWaterdropAuto_delegate$lambda$10(var0);
   }

   public BluetoothDevice(String var1, String var2, boolean var3, Boolean var4) {
      Intrinsics.checkNotNullParameter(var1, "bluetoothName");
      Intrinsics.checkNotNullParameter(var2, "mac");
      super();
      this.bluetoothName = var1;
      this.mac = var2;
      this.connectable = var3;
      this.isOnline = var4;
      this.sku$delegate = LazyKt.lazy(new BluetoothDevice$$ExternalSyntheticLambda2(this));
      this.isUnknownSku$delegate = LazyKt.lazy(new BluetoothDevice$$ExternalSyntheticLambda4(this));
      this.deviceType$delegate = LazyKt.lazy(new BluetoothDevice$$ExternalSyntheticLambda5(this));
      this.modelName$delegate = LazyKt.lazy(new BluetoothDevice$$ExternalSyntheticLambda6(this));
      this.familyName$delegate = LazyKt.lazy(new BluetoothDevice$$ExternalSyntheticLambda7(this));
      this.wifiMac$delegate = LazyKt.lazy(new BluetoothDevice$$ExternalSyntheticLambda8(this));
      this.shortMac$delegate = LazyKt.lazy(new BluetoothDevice$$ExternalSyntheticLambda9(this));
      this.isG4Plus$delegate = LazyKt.lazy(new BluetoothDevice$$ExternalSyntheticLambda10(this));
      this.buttonPressNeeded$delegate = LazyKt.lazy(new BluetoothDevice$$ExternalSyntheticLambda0(this));
      this.hasNoAutoButton$delegate = LazyKt.lazy(new BluetoothDevice$$ExternalSyntheticLambda1(this));
      this.useWaterdropAuto$delegate = LazyKt.lazy(new BluetoothDevice$$ExternalSyntheticLambda3(this));
   }

   // $FF: synthetic method
   public BluetoothDevice(String var1, String var2, boolean var3, Boolean var4, int var5, DefaultConstructorMarker var6) {
      if ((var5 & 4) != 0) {
         var3 = false;
      }

      if ((var5 & 8) != 0) {
         var4 = null;
      }

      this(var1, var2, var3, var4);
   }

   private static final boolean buttonPressNeeded_delegate$lambda$8(BluetoothDevice var0) {
      return var0.isG4Plus() || var0.getDeviceType().getIndex() >= DeviceType.NewClassic.INSTANCE.getIndex() || SkuConfigurationManager.INSTANCE.getConfig().skuIsBlueNewOnboarding(var0.getSku()) && var0.getShortMac().length() > 4;
   }

   private static final int compareTo$orderByOnline(Boolean var0) {
      if (Intrinsics.areEqual(var0, true)) {
         return 2;
      } else {
         return Intrinsics.areEqual(var0, false) ? 1 : 0;
      }
   }

   // $FF: synthetic method
   public static BluetoothDevice copy$default(BluetoothDevice var0, String var1, String var2, boolean var3, Boolean var4, int var5, Object var6) {
      if ((var5 & 1) != 0) {
         var1 = var0.bluetoothName;
      }

      if ((var5 & 2) != 0) {
         var2 = var0.mac;
      }

      if ((var5 & 4) != 0) {
         var3 = var0.connectable;
      }

      if ((var5 & 8) != 0) {
         var4 = var0.isOnline;
      }

      return var0.copy(var1, var2, var3, var4);
   }

   private static final DeviceType deviceType_delegate$lambda$2(BluetoothDevice var0) {
      return DeviceType.Companion.fromSkuCompat(var0.getSku());
   }

   private static final String familyName_delegate$lambda$4(BluetoothDevice var0) {
      return DeviceType.Companion.familyNameFromSku(var0.getSku());
   }

   // $FF: synthetic method
   public static void getButtonPressNeeded$annotations() {
   }

   // $FF: synthetic method
   public static void getDeviceType$annotations() {
   }

   // $FF: synthetic method
   public static void getFamilyName$annotations() {
   }

   // $FF: synthetic method
   public static void getHasNoAutoButton$annotations() {
   }

   // $FF: synthetic method
   public static void getModelName$annotations() {
   }

   // $FF: synthetic method
   public static void getShortMac$annotations() {
   }

   // $FF: synthetic method
   public static void getSku$annotations() {
   }

   // $FF: synthetic method
   public static void getUseWaterdropAuto$annotations() {
   }

   // $FF: synthetic method
   public static void getWifiMac$annotations() {
   }

   private static final boolean hasNoAutoButton_delegate$lambda$9(BluetoothDevice var0) {
      return SetsKt.setOf(new DeviceType[]{DeviceType.Pet20.INSTANCE, DeviceType.MiniRestful.INSTANCE}).contains(var0.getDeviceType()) || SkuConfigurationManager.INSTANCE.getConfig().skuIsBlueNewOnboarding(var0.getSku()) && var0.getShortMac().length() > 4;
   }

   // $FF: synthetic method
   public static void isG4Plus$annotations() {
   }

   private static final boolean isG4Plus_delegate$lambda$7(BluetoothDevice var0) {
      return SkuConfigurationManager.INSTANCE.getConfig().skuIsG4Plus(var0.getSku());
   }

   // $FF: synthetic method
   public static void isUnknownSku$annotations() {
   }

   private static final boolean isUnknownSku_delegate$lambda$1(BluetoothDevice var0) {
      return Intrinsics.areEqual(var0.getDeviceType(), DeviceType.Unknown.INSTANCE);
   }

   private static final String modelName_delegate$lambda$3(BluetoothDevice var0) {
      return DeviceType.Companion.modelNameFromSkuCompat(var0.getSku());
   }

   private static final String shortMac_delegate$lambda$6(BluetoothDevice var0) {
      String var1 = (String)CollectionsKt.getOrNull(StringsKt.split$default((CharSequence)var0.bluetoothName, new String[]{"_"}, false, 0, 6, (Object)null), 1);
      String var2 = var1;
      if (var1 == null) {
         var2 = "";
      }

      return var2;
   }

   private static final String sku_delegate$lambda$0(BluetoothDevice var0) {
      return (String)CollectionsKt.first(StringsKt.split$default((CharSequence)var0.bluetoothName, new String[]{"_"}, false, 0, 6, (Object)null));
   }

   private static final boolean useWaterdropAuto_delegate$lambda$10(BluetoothDevice var0) {
      return var0.getDeviceType() instanceof DeviceType.Humidifier20;
   }

   private static final String wifiMac_delegate$lambda$5(BluetoothDevice var0) {
      String var1;
      if (var0.bluetoothName.length() >= 2) {
         var1 = StringsKt.takeLast(var0.bluetoothName, 2);
      } else {
         var1 = null;
      }

      if (var1 != null && var0.mac.length() >= 2) {
         StringBuilder var2 = new StringBuilder();
         var2.append(StringsKt.dropLast(var0.mac, 2));
         var2.append(var1);
         return var2.toString();
      } else {
         return var0.mac;
      }
   }

   public int compareTo(BluetoothDevice var1) {
      Intrinsics.checkNotNullParameter(var1, "other");
      return compareTo$orderByOnline(this.isOnline) - compareTo$orderByOnline(var1.isOnline);
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

   public final BluetoothDevice copy(String var1, String var2, boolean var3, Boolean var4) {
      Intrinsics.checkNotNullParameter(var1, "bluetoothName");
      Intrinsics.checkNotNullParameter(var2, "mac");
      return new BluetoothDevice(var1, var2, var3, var4);
   }

   public final int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof BluetoothDevice)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.bluetoothName, var1.bluetoothName)) {
            return false;
         } else if (!Intrinsics.areEqual(this.mac, var1.mac)) {
            return false;
         } else if (this.connectable != var1.connectable) {
            return false;
         } else {
            return Intrinsics.areEqual(this.isOnline, var1.isOnline);
         }
      }
   }

   public final String getBluetoothName() {
      return this.bluetoothName;
   }

   public final boolean getButtonPressNeeded() {
      return (Boolean)this.buttonPressNeeded$delegate.getValue();
   }

   public final boolean getConnectable() {
      return this.connectable;
   }

   public final DeviceType getDeviceType() {
      return (DeviceType)this.deviceType$delegate.getValue();
   }

   public final String getFamilyName() {
      return (String)this.familyName$delegate.getValue();
   }

   public final boolean getHasNoAutoButton() {
      return (Boolean)this.hasNoAutoButton$delegate.getValue();
   }

   public final String getMac() {
      return this.mac;
   }

   public final String getModelName() {
      return (String)this.modelName$delegate.getValue();
   }

   public final String getShortMac() {
      return (String)this.shortMac$delegate.getValue();
   }

   public final String getSku() {
      return (String)this.sku$delegate.getValue();
   }

   public final boolean getUseWaterdropAuto() {
      return (Boolean)this.useWaterdropAuto$delegate.getValue();
   }

   public final String getWifiMac() {
      return (String)this.wifiMac$delegate.getValue();
   }

   public int hashCode() {
      int var4 = this.bluetoothName.hashCode();
      int var3 = this.mac.hashCode();
      int var2 = AddDeviceState$$ExternalSyntheticBackport0.m(this.connectable);
      Boolean var5 = this.isOnline;
      int var1;
      if (var5 == null) {
         var1 = 0;
      } else {
         var1 = var5.hashCode();
      }

      return ((var4 * 31 + var3) * 31 + var2) * 31 + var1;
   }

   public final boolean isG4Plus() {
      return (Boolean)this.isG4Plus$delegate.getValue();
   }

   public final Boolean isOnline() {
      return this.isOnline;
   }

   public final boolean isUnknownSku() {
      return (Boolean)this.isUnknownSku$delegate.getValue();
   }

   public final void setOnline(Boolean var1) {
      this.isOnline = var1;
   }

   public final HasSKU toDevice(String var1, String var2) {
      Intrinsics.checkNotNullParameter(var1, "uid");
      Intrinsics.checkNotNullParameter(var2, "name");
      String var4 = this.getSku();
      int var3 = this.getDeviceType().getIndex();
      return new DeviceUnknown(var4, var1, var2, DeviceType.Companion.displayNameFromSkuCompat(this.getSku()), var3, 0, 0L, this.getWifiMac(), (String)null, (String)null, (String)null, (String)null, (String)null, (String)null, (String)null, (String)null, 0, 130912, (DefaultConstructorMarker)null);
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("BluetoothDevice(bluetoothName=");
      var1.append(this.bluetoothName);
      var1.append(", mac=");
      var1.append(this.mac);
      var1.append(", connectable=");
      var1.append(this.connectable);
      var1.append(", isOnline=");
      var1.append(this.isOnline);
      var1.append(')');
      return var1.toString();
   }

   public final void writeToParcel(Parcel var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "dest");
      var1.writeString(this.bluetoothName);
      var1.writeString(this.mac);
      var1.writeInt(this.connectable);
      Boolean var3 = this.isOnline;
      if (var3 == null) {
         var2 = 0;
      } else {
         var1.writeInt(1);
         var2 = var3;
      }

      var1.writeInt(var2);
   }

   @Metadata(
      k = 3,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Creator implements Parcelable.Creator {
      public final BluetoothDevice createFromParcel(Parcel var1) {
         Intrinsics.checkNotNullParameter(var1, "parcel");
         String var6 = var1.readString();
         String var5 = var1.readString();
         int var2 = var1.readInt();
         boolean var4 = true;
         boolean var3;
         if (var2 != 0) {
            var3 = true;
         } else {
            var3 = false;
         }

         Boolean var7;
         if (var1.readInt() == 0) {
            var7 = null;
         } else {
            if (var1.readInt() == 0) {
               var4 = false;
            }

            var7 = var4;
         }

         return new BluetoothDevice(var6, var5, var3, var7);
      }

      public final BluetoothDevice[] newArray(int var1) {
         return new BluetoothDevice[var1];
      }
   }
}
