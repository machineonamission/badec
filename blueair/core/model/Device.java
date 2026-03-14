package com.blueair.core.model;

import android.content.Context;
import android.os.Parcelable;
import java.util.TimeZone;
import kotlin.Metadata;

@Metadata(
   d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0014\u00106\u001a\u0002072\n\b\u0002\u00108\u001a\u0004\u0018\u000109H\u0016J\b\u0010:\u001a\u00020/H\u0016J\b\u0010;\u001a\u00020/H\u0016J\b\u0010<\u001a\u00020/H\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0012\u0010\b\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0005R\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0012\u0010\u0010\u001a\u00020\u0011X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0012\u0010\u0014\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0005R\u0012\u0010\u0016\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0005R\u0012\u0010\u0018\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0005R\u0012\u0010\u001a\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0005R\u0012\u0010\u001c\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0005R\u0012\u0010\u001e\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0005R\u0012\u0010 \u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u0005R\u0012\u0010\"\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u0005R\u0012\u0010$\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\u0005R\u0012\u0010&\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b'\u0010\rR\u001a\u0010(\u001a\u00020)8VX\u0096\u0004¢\u0006\f\u0012\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u0014\u0010.\u001a\u00020/8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b.\u00100R\u001a\u00101\u001a\u0002028VX\u0096\u0004¢\u0006\f\u0012\u0004\b3\u0010+\u001a\u0004\b4\u00105¨\u0006=À\u0006\u0003"},
   d2 = {"Lcom/blueair/core/model/Device;", "Landroid/os/Parcelable;", "uid", "", "getUid", "()Ljava/lang/String;", "name", "getName", "modelName", "getModelName", "typeIndex", "", "getTypeIndex", "()I", "connectivityStatusIndex", "getConnectivityStatusIndex", "lastConnectivityInMillis", "", "getLastConnectivityInMillis", "()J", "mac", "getMac", "mcuFirmware", "getMcuFirmware", "wifiFirmware", "getWifiFirmware", "hardware", "getHardware", "timeZone", "getTimeZone", "serial", "getSerial", "purchaseDate", "getPurchaseDate", "dealerName", "getDealerName", "dealerCountry", "getDealerCountry", "updateProgress", "getUpdateProgress", "connectivityStatus", "Lcom/blueair/core/model/ConnectivityStatus;", "getConnectivityStatus$annotations", "()V", "getConnectivityStatus", "()Lcom/blueair/core/model/ConnectivityStatus;", "isOnline", "", "()Z", "type", "Lcom/blueair/core/model/DeviceType;", "getType$annotations", "getType", "()Lcom/blueair/core/model/DeviceType;", "getTimezone", "Ljava/util/TimeZone;", "context", "Landroid/content/Context;", "isUsDevice", "isCnDevice", "supportResetFilterOnline", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public interface Device extends Parcelable {
   ConnectivityStatus getConnectivityStatus();

   int getConnectivityStatusIndex();

   String getDealerCountry();

   String getDealerName();

   String getHardware();

   long getLastConnectivityInMillis();

   String getMac();

   String getMcuFirmware();

   String getModelName();

   String getName();

   String getPurchaseDate();

   String getSerial();

   String getTimeZone();

   TimeZone getTimezone(Context var1);

   DeviceType getType();

   int getTypeIndex();

   String getUid();

   int getUpdateProgress();

   String getWifiFirmware();

   boolean isCnDevice();

   boolean isOnline();

   boolean isUsDevice();

   boolean supportResetFilterOnline();

   @Metadata(
      k = 3,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class DefaultImpls {
      @Deprecated
      public static ConnectivityStatus getConnectivityStatus(Device var0) {
         return Device$_CC.access$getConnectivityStatus$jd(var0);
      }

      // $FF: synthetic method
      public static void getConnectivityStatus$annotations() {
      }

      @Deprecated
      public static TimeZone getTimezone(Device var0, Context var1) {
         return Device$_CC.access$getTimezone$jd(var0, var1);
      }

      // $FF: synthetic method
      public static TimeZone getTimezone$default(Device var0, Context var1, int var2, Object var3) {
         return Device$_CC.getTimezone$default(var0, var1, var2, var3);
      }

      @Deprecated
      public static DeviceType getType(Device var0) {
         return Device$_CC.access$getType$jd(var0);
      }

      // $FF: synthetic method
      public static void getType$annotations() {
      }

      @Deprecated
      public static boolean isCnDevice(Device var0) {
         return Device$_CC.access$isCnDevice$jd(var0);
      }

      @Deprecated
      public static boolean isOnline(Device var0) {
         return Device$_CC.access$isOnline$jd(var0);
      }

      @Deprecated
      public static boolean isUsDevice(Device var0) {
         return Device$_CC.access$isUsDevice$jd(var0);
      }

      @Deprecated
      public static boolean supportResetFilterOnline(Device var0) {
         return Device$_CC.access$supportResetFilterOnline$jd(var0);
      }
   }
}
