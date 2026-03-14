package com.blueair.api.restapi;

import kotlinx.coroutines.Deferred;

// $FF: synthetic class
public final class BlueCloudRestApi$_CC {
   static {
      BlueCloudRestApi.Companion var0 = BlueCloudRestApi.Companion;
   }

   // $FF: synthetic method
   public static Deferred setActuator$default(BlueCloudRestApi var0, String var1, ActuatorWrapper var2, String var3, int var4, Object var5) {
      if (var5 == null) {
         if ((var4 & 4) != 0) {
            var3 = var2.getN();
         }

         return var0.setActuator(var1, var2, var3);
      } else {
         throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setActuator");
      }
   }
}
