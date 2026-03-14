package com.blueair.core.model;

import android.content.Context;
import com.blueair.core.util.SkuConfigurationManager;
import com.blueair.core.util.TimezoneUtils;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TimeZone;
import kotlin.jvm.internal.Intrinsics;

// $FF: synthetic class
public final class Device$_CC {
   public static ConnectivityStatus $default$getConnectivityStatus(Device var0) {
      return ConnectivityStatus.values()[var0.getConnectivityStatusIndex()];
   }

   public static TimeZone $default$getTimezone(Device var0, Context var1) {
      TimeZone var2 = TimeZone.getTimeZone(var0.getTimeZone());
      TimeZone var3 = var2;
      if (Intrinsics.areEqual(var2.getID(), "GMT")) {
         var3 = TimeZone.getDefault();
      }

      if (var1 != null) {
         TimezoneUtils var5 = TimezoneUtils.INSTANCE;
         Intrinsics.checkNotNull(var3);
         TimeZone var4 = var5.ensureValidTimezone(var1, var3);
         if (var4 != null) {
            return var4;
         }
      }

      Intrinsics.checkNotNull(var3);
      return var3;
   }

   public static DeviceType $default$getType(Device var0) {
      return DeviceType.Companion.fromIndex(var0.getTypeIndex());
   }

   public static boolean $default$isCnDevice(Device var0) {
      DeviceConfig var1 = SkuConfigurationManager.INSTANCE.getConfig().getDeviceConfig(DeviceKt.getSkuCompat(var0));
      if (var1 != null) {
         Set var2 = var1.getMarket();
         if (var2 != null && var2.contains("cn")) {
            return true;
         }
      }

      return false;
   }

   public static boolean $default$isOnline(Device var0) {
      return var0.getConnectivityStatusIndex() == ConnectivityStatus.ONLINE.ordinal();
   }

   public static boolean $default$isUsDevice(Device var0) {
      DeviceConfig var1 = SkuConfigurationManager.INSTANCE.getConfig().getDeviceConfig(DeviceKt.getSkuCompat(var0));
      if (var1 != null) {
         Set var2 = var1.getMarket();
         if (var2 != null && var2.contains("us")) {
            return true;
         }
      }

      return false;
   }

   public static boolean $default$supportResetFilterOnline(Device var0) {
      if (!DeviceKt.isAfterG4(var0)) {
         List var1 = (List)SkuConfigurationManager.INSTANCE.getSpecialHardwareSets().get("reset_filter_online");
         if (var1 == null) {
            return false;
         }

         String var2 = var0.getHardware().toLowerCase(Locale.ROOT);
         Intrinsics.checkNotNullExpressionValue(var2, "toLowerCase(...)");
         if (!var1.contains(var2)) {
            return false;
         }
      }

      return true;
   }

   // $FF: synthetic method
   public static ConnectivityStatus access$getConnectivityStatus$jd(Device var0) {
      return $default$getConnectivityStatus(var0);
   }

   // $FF: synthetic method
   public static TimeZone access$getTimezone$jd(Device var0, Context var1) {
      return $default$getTimezone(var0, var1);
   }

   // $FF: synthetic method
   public static DeviceType access$getType$jd(Device var0) {
      return $default$getType(var0);
   }

   // $FF: synthetic method
   public static boolean access$isCnDevice$jd(Device var0) {
      return $default$isCnDevice(var0);
   }

   // $FF: synthetic method
   public static boolean access$isOnline$jd(Device var0) {
      return $default$isOnline(var0);
   }

   // $FF: synthetic method
   public static boolean access$isUsDevice$jd(Device var0) {
      return $default$isUsDevice(var0);
   }

   // $FF: synthetic method
   public static boolean access$supportResetFilterOnline$jd(Device var0) {
      return $default$supportResetFilterOnline(var0);
   }

   // $FF: synthetic method
   public static TimeZone getTimezone$default(Device var0, Context var1, int var2, Object var3) {
      if (var3 == null) {
         if ((var2 & 1) != 0) {
            var1 = null;
         }

         return var0.getTimezone(var1);
      } else {
         throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getTimezone");
      }
   }
}
