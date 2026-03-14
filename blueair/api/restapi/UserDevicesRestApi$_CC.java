package com.blueair.api.restapi;

import kotlinx.coroutines.Deferred;

// $FF: synthetic class
public final class UserDevicesRestApi$_CC {
   static {
      UserDevicesRestApi.Companion var0 = UserDevicesRestApi.Companion;
   }

   // $FF: synthetic method
   public static Deferred getGoogleLinkStatus$default(UserDevicesRestApi var0, String var1, String var2, int var3, Object var4) {
      if (var4 == null) {
         if ((var3 & 2) != 0) {
            var2 = "google";
         }

         return var0.getGoogleLinkStatus(var1, var2);
      } else {
         throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getGoogleLinkStatus");
      }
   }
}
