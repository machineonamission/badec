package com.blueair.devicedetails.util;

import com.blueair.core.model.Device;

// $FF: synthetic class
public final class DeviceDetailsLauncher$_CC {
   // $FF: synthetic method
   public static void openDeviceDetails$default(DeviceDetailsLauncher var0, Device var1, String var2, int var3, Object var4) {
      if (var4 == null) {
         if ((var3 & 2) != 0) {
            var2 = null;
         }

         var0.openDeviceDetails(var1, var2);
      } else {
         throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openDeviceDetails");
      }
   }
}
