package com.blueair.devicedetails.util;

import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceB4;
import com.blueair.core.model.DeviceB4sp;
import com.blueair.core.model.DeviceBlue;
import com.blueair.core.model.DeviceG4;
import com.blueair.core.model.DeviceIcp;
import com.blueair.viewcore.R;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"},
   d2 = {"deriveInfo", "Lcom/blueair/devicedetails/util/DeviceInfo;", "Lcom/blueair/core/model/Device;", "infoType", "Lcom/blueair/devicedetails/util/DeviceInfoType;", "devicedetails_otherRelease"},
   k = 2,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceInfoKt {
   public static final DeviceInfo deriveInfo(Device var0, DeviceInfoType var1) {
      Intrinsics.checkNotNullParameter(var0, "<this>");
      Intrinsics.checkNotNullParameter(var1, "infoType");
      if (!(var0 instanceof DeviceG4) && !(var0 instanceof DeviceB4) && !(var0 instanceof DeviceB4sp) && !(var0 instanceof DeviceBlue)) {
         if (var0 instanceof DeviceIcp) {
            int var3 = DeviceInfoKt.WhenMappings.$EnumSwitchMapping$0[var1.ordinal()];
            if (var3 != 1 && var3 != 2 && var3 != 4) {
               return null;
            }
         } else {
            int var4 = DeviceInfoKt.WhenMappings.$EnumSwitchMapping$0[var1.ordinal()];
            if (var4 != 1 && var4 != 2 && var4 != 4 && var4 != 5) {
               return null;
            }
         }
      } else {
         int var2 = DeviceInfoKt.WhenMappings.$EnumSwitchMapping$0[var1.ordinal()];
         if (var2 != 1 && var2 != 2 && var2 != 3 && var2 != 4 && var2 != 5) {
            throw new NoWhenBranchMatchedException();
         }
      }

      int var5 = DeviceInfoKt.WhenMappings.$EnumSwitchMapping$0[var1.ordinal()];
      if (var5 != 1) {
         if (var5 != 2) {
            if (var5 != 3) {
               if (var5 != 4) {
                  if (var5 == 5) {
                     if (((CharSequence)var0.getMcuFirmware()).length() == 0) {
                        return null;
                     } else {
                        return new DeviceInfo(var1, R.string.mcu_firmware, var0.getMcuFirmware());
                     }
                  } else {
                     throw new NoWhenBranchMatchedException();
                  }
               } else if (((CharSequence)var0.getWifiFirmware()).length() == 0) {
                  return null;
               } else {
                  if (var0 instanceof DeviceIcp) {
                     var5 = R.string.bt_firmware;
                  } else {
                     var5 = R.string.wifi_firmware;
                  }

                  return new DeviceInfo(var1, var5, var0.getWifiFirmware());
               }
            } else if (Intrinsics.areEqual(var0.getSerial(), "123456-123-123-1-12-1-1234567")) {
               return null;
            } else {
               return new DeviceInfo(var1, R.string.serial_number, var0.getSerial());
            }
         } else if (Intrinsics.areEqual(var0.getMac(), "ff:ff:ff:ff:ff:ff")) {
            return null;
         } else {
            return new DeviceInfo(var1, R.string.device_mac, var0.getMac());
         }
      } else {
         return new DeviceInfo(var1, R.string.product_type, var0.getModelName());
      }
   }

   // $FF: synthetic class
   @Metadata(
      k = 3,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class WhenMappings {
      public static final int[] $EnumSwitchMapping$0;

      static {
         int[] var0 = new int[DeviceInfoType.values().length];

         try {
            var0[DeviceInfoType.PRODUCT_TYPE.ordinal()] = 1;
         } catch (NoSuchFieldError var6) {
         }

         try {
            var0[DeviceInfoType.MAC_ADDRESS.ordinal()] = 2;
         } catch (NoSuchFieldError var5) {
         }

         try {
            var0[DeviceInfoType.SERIAL_NUMBER.ordinal()] = 3;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[DeviceInfoType.WIFI_FIRMWARE.ordinal()] = 4;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[DeviceInfoType.MCU_FIRMWARE.ordinal()] = 5;
         } catch (NoSuchFieldError var2) {
         }

         $EnumSwitchMapping$0 = var0;
      }
   }
}
