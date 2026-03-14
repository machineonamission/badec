package com.blueair.core.model;

import android.content.Context;
import java.util.TimeZone;
import kotlin.Metadata;

@Metadata(
   d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\n\u001a\u00020\u0007H\u0016R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u000bÀ\u0006\u0003"},
   d2 = {"Lcom/blueair/core/model/HasRemoveYellowWater;", "Lcom/blueair/core/model/Device;", "ywrmEnabled", "", "getYwrmEnabled", "()Ljava/lang/Boolean;", "ywrmUsage", "", "getYwrmUsage", "()I", "getRefresherLifeLeft", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public interface HasRemoveYellowWater extends Device {
   int getRefresherLifeLeft();

   Boolean getYwrmEnabled();

   int getYwrmUsage();

   @Metadata(
      k = 3,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class DefaultImpls {
      @Deprecated
      public static ConnectivityStatus getConnectivityStatus(HasRemoveYellowWater var0) {
         return HasRemoveYellowWater$_CC.access$getConnectivityStatus$jd(var0);
      }

      @Deprecated
      public static int getRefresherLifeLeft(HasRemoveYellowWater var0) {
         return HasRemoveYellowWater$_CC.access$getRefresherLifeLeft$jd(var0);
      }

      @Deprecated
      public static TimeZone getTimezone(HasRemoveYellowWater var0, Context var1) {
         return HasRemoveYellowWater$_CC.access$getTimezone$jd(var0, var1);
      }

      @Deprecated
      public static DeviceType getType(HasRemoveYellowWater var0) {
         return HasRemoveYellowWater$_CC.access$getType$jd(var0);
      }

      @Deprecated
      public static boolean isCnDevice(HasRemoveYellowWater var0) {
         return HasRemoveYellowWater$_CC.access$isCnDevice$jd(var0);
      }

      @Deprecated
      public static boolean isOnline(HasRemoveYellowWater var0) {
         return HasRemoveYellowWater$_CC.access$isOnline$jd(var0);
      }

      @Deprecated
      public static boolean isUsDevice(HasRemoveYellowWater var0) {
         return HasRemoveYellowWater$_CC.access$isUsDevice$jd(var0);
      }

      @Deprecated
      public static boolean supportResetFilterOnline(HasRemoveYellowWater var0) {
         return HasRemoveYellowWater$_CC.access$supportResetFilterOnline$jd(var0);
      }
   }
}
