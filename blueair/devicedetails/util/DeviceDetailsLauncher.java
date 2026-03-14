package com.blueair.devicedetails.util;

import com.blueair.core.model.Device;
import kotlin.Metadata;

@Metadata(
   d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\bÀ\u0006\u0003"},
   d2 = {"Lcom/blueair/devicedetails/util/DeviceDetailsLauncher;", "", "openDeviceDetails", "", "device", "Lcom/blueair/core/model/Device;", "actionType", "", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public interface DeviceDetailsLauncher {
   void openDeviceDetails(Device var1, String var2);

   @Metadata(
      k = 3,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class DefaultImpls {
      // $FF: synthetic method
      public static void openDeviceDetails$default(DeviceDetailsLauncher var0, Device var1, String var2, int var3, Object var4) {
         DeviceDetailsLauncher$_CC.openDeviceDetails$default(var0, var1, var2, var3, var4);
      }
   }
}
