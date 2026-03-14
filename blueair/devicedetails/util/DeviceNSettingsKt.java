package com.blueair.devicedetails.util;

import com.blueair.core.BuildEnvironment;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.DeviceNewClassic;
import com.blueair.core.model.HasTemperatureUnit;
import com.blueair.core.model.HasWick;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"},
   d2 = {"supportSetting", "", "Lcom/blueair/core/model/Device;", "setting", "Lcom/blueair/devicedetails/util/DeviceNSettings;", "devicedetails_otherRelease"},
   k = 2,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceNSettingsKt {
   public static final boolean supportSetting(Device var0, DeviceNSettings var1) {
      Intrinsics.checkNotNullParameter(var0, "<this>");
      Intrinsics.checkNotNullParameter(var1, "setting");
      if (var0 instanceof DeviceNewClassic) {
         int var3 = DeviceNSettingsKt.WhenMappings.$EnumSwitchMapping$0[var1.ordinal()];
         if (var3 != 1 && var3 != 2 && var3 != 3 && var3 != 4) {
            if (var3 != 5) {
               return true;
            }

            if (!BuildEnvironment.INSTANCE.isRelease()) {
               return true;
            }
         }

         return false;
      } else if (DeviceKt.isAfterG4(var0)) {
         int var2 = DeviceNSettingsKt.WhenMappings.$EnumSwitchMapping$0[var1.ordinal()];
         if (var2 != 1) {
            if (var2 != 2) {
               if (var2 != 3 && var2 != 4) {
                  if (var2 != 5) {
                     return true;
                  }

                  if (!BuildEnvironment.INSTANCE.isRelease()) {
                     return true;
                  }
               }

               return false;
            } else {
               return var0 instanceof HasWick;
            }
         } else {
            return var0 instanceof HasTemperatureUnit;
         }
      } else {
         return false;
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
         int[] var0 = new int[DeviceNSettings.values().length];

         try {
            var0[DeviceNSettings.TEMPERATURE.ordinal()] = 1;
         } catch (NoSuchFieldError var6) {
         }

         try {
            var0[DeviceNSettings.DRY_MODE.ordinal()] = 2;
         } catch (NoSuchFieldError var5) {
         }

         try {
            var0[DeviceNSettings.TRIGGER_AUTO.ordinal()] = 3;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[DeviceNSettings.TRIGGER_NIGHT.ordinal()] = 4;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[DeviceNSettings.SYSTEM_INFO.ordinal()] = 5;
         } catch (NoSuchFieldError var2) {
         }

         $EnumSwitchMapping$0 = var0;
      }
   }
}
