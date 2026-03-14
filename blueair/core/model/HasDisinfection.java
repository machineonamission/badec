package com.blueair.core.model;

import android.content.Context;
import java.util.TimeZone;
import kotlin.Metadata;

@Metadata(
   d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\bf\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eR\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u000fÀ\u0006\u0003"},
   d2 = {"Lcom/blueair/core/model/HasDisinfection;", "Lcom/blueair/core/model/Device;", "disinfection", "", "getDisinfection", "()Ljava/lang/Boolean;", "disinfectLeftTime", "", "getDisinfectLeftTime", "()Ljava/lang/Integer;", "disinfectLeftTimeUpdateTime", "", "getDisinfectLeftTimeUpdateTime", "()Ljava/lang/Long;", "Companion", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public interface HasDisinfection extends Device {
   Companion Companion = HasDisinfection.Companion.$$INSTANCE;
   int DISINFECTION_TIME = 7200;

   Integer getDisinfectLeftTime();

   Long getDisinfectLeftTimeUpdateTime();

   Boolean getDisinfection();

   @Metadata(
      d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"},
      d2 = {"Lcom/blueair/core/model/HasDisinfection$Companion;", "", "<init>", "()V", "DISINFECTION_TIME", "", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Companion {
      static final Companion $$INSTANCE = new Companion();
      public static final int DISINFECTION_TIME = 7200;

      private Companion() {
      }
   }

   @Metadata(
      k = 3,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class DefaultImpls {
      @Deprecated
      public static ConnectivityStatus getConnectivityStatus(HasDisinfection var0) {
         return HasDisinfection$_CC.access$getConnectivityStatus$jd(var0);
      }

      @Deprecated
      public static TimeZone getTimezone(HasDisinfection var0, Context var1) {
         return HasDisinfection$_CC.access$getTimezone$jd(var0, var1);
      }

      @Deprecated
      public static DeviceType getType(HasDisinfection var0) {
         return HasDisinfection$_CC.access$getType$jd(var0);
      }

      @Deprecated
      public static boolean isCnDevice(HasDisinfection var0) {
         return HasDisinfection$_CC.access$isCnDevice$jd(var0);
      }

      @Deprecated
      public static boolean isOnline(HasDisinfection var0) {
         return HasDisinfection$_CC.access$isOnline$jd(var0);
      }

      @Deprecated
      public static boolean isUsDevice(HasDisinfection var0) {
         return HasDisinfection$_CC.access$isUsDevice$jd(var0);
      }

      @Deprecated
      public static boolean supportResetFilterOnline(HasDisinfection var0) {
         return HasDisinfection$_CC.access$supportResetFilterOnline$jd(var0);
      }
   }
}
