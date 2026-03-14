package com.blueair.core.model;

import android.content.Context;
import java.util.List;
import java.util.TimeZone;
import kotlin.Metadata;

@Metadata(
   d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u001a\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007À\u0006\u0003"},
   d2 = {"Lcom/blueair/core/model/HasAlarm;", "Lcom/blueair/core/model/Device;", "alarms", "", "Lcom/blueair/core/model/DeviceAlarm;", "getAlarms", "()Ljava/util/List;", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public interface HasAlarm extends Device {
   List getAlarms();

   @Metadata(
      k = 3,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class DefaultImpls {
      @Deprecated
      public static ConnectivityStatus getConnectivityStatus(HasAlarm var0) {
         return HasAlarm$_CC.access$getConnectivityStatus$jd(var0);
      }

      @Deprecated
      public static TimeZone getTimezone(HasAlarm var0, Context var1) {
         return HasAlarm$_CC.access$getTimezone$jd(var0, var1);
      }

      @Deprecated
      public static DeviceType getType(HasAlarm var0) {
         return HasAlarm$_CC.access$getType$jd(var0);
      }

      @Deprecated
      public static boolean isCnDevice(HasAlarm var0) {
         return HasAlarm$_CC.access$isCnDevice$jd(var0);
      }

      @Deprecated
      public static boolean isOnline(HasAlarm var0) {
         return HasAlarm$_CC.access$isOnline$jd(var0);
      }

      @Deprecated
      public static boolean isUsDevice(HasAlarm var0) {
         return HasAlarm$_CC.access$isUsDevice$jd(var0);
      }

      @Deprecated
      public static boolean supportResetFilterOnline(HasAlarm var0) {
         return HasAlarm$_CC.access$supportResetFilterOnline$jd(var0);
      }
   }
}
