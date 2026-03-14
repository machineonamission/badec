package com.blueair.api.restapi;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.Deferred;

// $FF: synthetic class
public final class ProvisioningWifiRestApi$_CC {
   static {
      ProvisioningWifiRestApi.Companion var0 = ProvisioningWifiRestApi.Companion;
   }

   // $FF: synthetic method
   public static Deferred switchOffSoftAp$default(ProvisioningWifiRestApi var0, String var1, ProvisioningWifiRestApi.SwitchOffSoftApBody var2, int var3, Object var4) {
      if (var4 == null) {
         if ((var3 & 2) != 0) {
            var2 = new ProvisioningWifiRestApi.SwitchOffSoftApBody(false, 1, (DefaultConstructorMarker)null);
         }

         return var0.switchOffSoftAp(var1, var2);
      } else {
         throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: switchOffSoftAp");
      }
   }
}
