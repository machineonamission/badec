package com.blueair.core.model;

import android.content.Context;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0006\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J\u0012\u0010\u0015\u001a\u00020\u00072\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0012\u0010\f\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\tR\u0012\u0010\u000e\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\tR\u0012\u0010\u0010\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\t¨\u0006\u0018À\u0006\u0003"},
   d2 = {"Lcom/blueair/core/model/HasAirRefresh;", "Lcom/blueair/core/model/Device;", "airRefreshEnabled", "", "getAirRefreshEnabled", "()Z", "airRefreshStatus", "", "getAirRefreshStatus", "()I", "airRefreshDuration", "getAirRefreshDuration", "airRefreshTimeStamp", "getAirRefreshTimeStamp", "airRefreshStartTimeStamp", "getAirRefreshStartTimeStamp", "airRefreshEndTimeStamp", "getAirRefreshEndTimeStamp", "Lcom/blueair/core/model/AirRefreshState;", "isInAirRefreshStatus", "status", "getAirRefreshLeftSeconds", "nowInMills", "", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public interface HasAirRefresh extends Device {
   AirRefreshState airRefreshStatus();

   int getAirRefreshDuration();

   boolean getAirRefreshEnabled();

   int getAirRefreshEndTimeStamp();

   int getAirRefreshLeftSeconds(long var1);

   int getAirRefreshStartTimeStamp();

   int getAirRefreshStatus();

   int getAirRefreshTimeStamp();

   boolean isInAirRefreshStatus(AirRefreshState var1);

   @Metadata(
      k = 3,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class DefaultImpls {
      @Deprecated
      public static AirRefreshState airRefreshStatus(HasAirRefresh var0) {
         return HasAirRefresh$_CC.access$airRefreshStatus$jd(var0);
      }

      @Deprecated
      public static int getAirRefreshLeftSeconds(HasAirRefresh var0, long var1) {
         return HasAirRefresh$_CC.access$getAirRefreshLeftSeconds$jd(var0, var1);
      }

      // $FF: synthetic method
      public static int getAirRefreshLeftSeconds$default(HasAirRefresh var0, long var1, int var3, Object var4) {
         return HasAirRefresh$_CC.getAirRefreshLeftSeconds$default(var0, var1, var3, var4);
      }

      @Deprecated
      public static ConnectivityStatus getConnectivityStatus(HasAirRefresh var0) {
         return HasAirRefresh$_CC.access$getConnectivityStatus$jd(var0);
      }

      @Deprecated
      public static TimeZone getTimezone(HasAirRefresh var0, Context var1) {
         return HasAirRefresh$_CC.access$getTimezone$jd(var0, var1);
      }

      @Deprecated
      public static DeviceType getType(HasAirRefresh var0) {
         return HasAirRefresh$_CC.access$getType$jd(var0);
      }

      @Deprecated
      public static boolean isCnDevice(HasAirRefresh var0) {
         return HasAirRefresh$_CC.access$isCnDevice$jd(var0);
      }

      @Deprecated
      public static boolean isInAirRefreshStatus(HasAirRefresh var0, AirRefreshState var1) {
         Intrinsics.checkNotNullParameter(var1, "status");
         return HasAirRefresh$_CC.access$isInAirRefreshStatus$jd(var0, var1);
      }

      @Deprecated
      public static boolean isOnline(HasAirRefresh var0) {
         return HasAirRefresh$_CC.access$isOnline$jd(var0);
      }

      @Deprecated
      public static boolean isUsDevice(HasAirRefresh var0) {
         return HasAirRefresh$_CC.access$isUsDevice$jd(var0);
      }

      @Deprecated
      public static boolean supportResetFilterOnline(HasAirRefresh var0) {
         return HasAirRefresh$_CC.access$supportResetFilterOnline$jd(var0);
      }
   }
}
