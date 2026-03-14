package com.blueair.core.model;

import android.content.Context;
import java.util.TimeZone;
import kotlin.Metadata;

@Metadata(
   d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\nÀ\u0006\u0003"},
   d2 = {"Lcom/blueair/core/model/HasBlueProvisionCalls;", "Lcom/blueair/core/model/HasBlueCloudFunctions;", "deviceUuid", "Lcom/blueair/core/model/DeviceUuid;", "getDeviceUuid", "()Lcom/blueair/core/model/DeviceUuid;", "hasFinishedOnboarding", "", "getHasFinishedOnboarding", "()Z", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public interface HasBlueProvisionCalls extends HasBlueCloudFunctions {
   DeviceUuid getDeviceUuid();

   boolean getHasFinishedOnboarding();

   @Metadata(
      k = 3,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class DefaultImpls {
      @Deprecated
      public static ConnectivityStatus getConnectivityStatus(HasBlueProvisionCalls var0) {
         return HasBlueProvisionCalls$_CC.access$getConnectivityStatus$jd(var0);
      }

      @Deprecated
      public static TimeZone getTimezone(HasBlueProvisionCalls var0, Context var1) {
         return HasBlueProvisionCalls$_CC.access$getTimezone$jd(var0, var1);
      }

      @Deprecated
      public static DeviceType getType(HasBlueProvisionCalls var0) {
         return HasBlueProvisionCalls$_CC.access$getType$jd(var0);
      }

      @Deprecated
      public static boolean isCnDevice(HasBlueProvisionCalls var0) {
         return HasBlueProvisionCalls$_CC.access$isCnDevice$jd(var0);
      }

      @Deprecated
      public static boolean isOnline(HasBlueProvisionCalls var0) {
         return HasBlueProvisionCalls$_CC.access$isOnline$jd(var0);
      }

      @Deprecated
      public static boolean isUsDevice(HasBlueProvisionCalls var0) {
         return HasBlueProvisionCalls$_CC.access$isUsDevice$jd(var0);
      }

      @Deprecated
      public static boolean supportResetFilterOnline(HasBlueProvisionCalls var0) {
         return HasBlueProvisionCalls$_CC.access$supportResetFilterOnline$jd(var0);
      }
   }
}
