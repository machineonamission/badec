package com.blueair.devicedetails.util;

import com.blueair.core.BuildEnvironment;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceB4;
import com.blueair.core.model.DeviceB4sp;
import com.blueair.core.model.DeviceBlue;
import com.blueair.core.model.DeviceBlue40;
import com.blueair.core.model.DeviceClassic;
import com.blueair.core.model.DeviceG4;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.DeviceNewClassic;
import com.blueair.core.model.Filter;
import com.blueair.core.model.HasBlueCloudFunctions;
import com.blueair.core.model.HasHourFormat;
import com.blueair.core.model.HasLinkingCapability;
import com.blueair.core.model.HasRemoveYellowWater;
import com.blueair.core.model.HasTemperatureUnit;
import com.blueair.core.model.HasWick;
import com.blueair.core.model.HasWickDryDuration;
import com.blueair.core.model.McuFirmwareVersions;
import com.blueair.core.util.SkuConfigurationManager;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"},
   d2 = {"supportSetting", "", "Lcom/blueair/core/model/Device;", "setting", "Lcom/blueair/devicedetails/util/DeviceSetting;", "devicedetails_otherRelease"},
   k = 2,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceSettingKt {
   public static final boolean supportSetting(Device var0, DeviceSetting var1) {
      Intrinsics.checkNotNullParameter(var0, "<this>");
      Intrinsics.checkNotNullParameter(var1, "setting");
      if (!Intrinsics.areEqual(var1, DeviceSetting.CUSTOM_NAME.INSTANCE) && !Intrinsics.areEqual(var1, DeviceSetting.PRODUCT_INFO.INSTANCE)) {
         if (Intrinsics.areEqual(var1, DeviceSetting.HOUR_FORMAT.INSTANCE)) {
            return var0 instanceof HasHourFormat && McuFirmwareVersions.Companion.compare(var0.getMcuFirmware(), SkuConfigurationManager.INSTANCE.getMcuFirmwareVersions().getMrestHourFormatV2()) >= 0;
         } else if (Intrinsics.areEqual(var1, DeviceSetting.TIMEZONE.INSTANCE)) {
            return var0 instanceof HasBlueCloudFunctions;
         } else if (Intrinsics.areEqual(var1, DeviceSetting.ERROR_REPORT.INSTANCE)) {
            return !BuildEnvironment.INSTANCE.isRelease();
         } else if (Intrinsics.areEqual(var1, DeviceSetting.USER_MANUAL.INSTANCE)) {
            return true;
         } else if (Intrinsics.areEqual(var1, DeviceSetting.WELCOME_HOME.INSTANCE)) {
            return DeviceKt.useV2UI(var0);
         } else if (Intrinsics.areEqual(var1, DeviceSetting.WICK_DRY.INSTANCE)) {
            return var0 instanceof HasWickDryDuration;
         } else if (Intrinsics.areEqual(var1, DeviceSetting.WATER_REFRESHER.INSTANCE)) {
            boolean var2 = var0 instanceof HasRemoveYellowWater;
            Boolean var3 = null;
            HasRemoveYellowWater var6;
            if (var2) {
               var6 = (HasRemoveYellowWater)var0;
            } else {
               var6 = null;
            }

            if (var6 != null) {
               var3 = var6.getYwrmEnabled();
            }

            return var3 != null && !var0.isCnDevice();
         } else if (var0 instanceof DeviceBlue40) {
            if (!Intrinsics.areEqual(var1, DeviceSetting.AUTO_REFRESH.INSTANCE) && !Intrinsics.areEqual(var1, DeviceSetting.DISPLAY_MODE.INSTANCE)) {
               return Intrinsics.areEqual(var1, DeviceSetting.TVOC.INSTANCE) && !((DeviceBlue40)var0).isLargeSize();
            } else {
               return true;
            }
         } else if (var0 instanceof DeviceG4) {
            if (Intrinsics.areEqual(var1, DeviceSetting.AUTO_MODE_TRIGGERS.INSTANCE)) {
               return !((DeviceG4)var0).isPlus();
            } else if (!Intrinsics.areEqual(var1, DeviceSetting.GERM_SHIELD_MODE.INSTANCE) && !Intrinsics.areEqual(var1, DeviceSetting.STANDBY_MODE.INSTANCE)) {
               return Intrinsics.areEqual(var1, DeviceSetting.GERM_SHIELD_IN_NIGHT_MODE.INSTANCE) ? ((DeviceG4)var0).getHasGermShieldNightMode() : false;
            } else {
               return true;
            }
         } else if (!(var0 instanceof DeviceB4) && !(var0 instanceof DeviceBlue)) {
            if (var0 instanceof DeviceB4sp) {
               return Intrinsics.areEqual(var1, DeviceSetting.STANDBY_MODE.INSTANCE) || Intrinsics.areEqual(var1, DeviceSetting.AUTO_MODE_TRIGGERS.INSTANCE);
            } else if (var0 instanceof DeviceClassic) {
               Filter var5 = ((DeviceClassic)var0).getFilter();
               if (Intrinsics.areEqual(var5, Filter.SmokeStopFilter.INSTANCE)) {
                  return Intrinsics.areEqual(var1, DeviceSetting.CHILD_LOCK_MODE.INSTANCE) || Intrinsics.areEqual(var1, DeviceSetting.AUTO_MODE_TRIGGERS.INSTANCE);
               } else if (!Intrinsics.areEqual(var5, Filter.ParticleFilter.INSTANCE) && !Intrinsics.areEqual(var5, Filter.UnknownFilter.INSTANCE)) {
                  throw new NoWhenBranchMatchedException();
               } else {
                  return Intrinsics.areEqual(var1, DeviceSetting.CHILD_LOCK_MODE.INSTANCE);
               }
            } else if (var0 instanceof HasLinkingCapability) {
               Filter var4 = ((HasLinkingCapability)var0).getFilter();
               if (Intrinsics.areEqual(var4, Filter.SmokeStopFilter.INSTANCE)) {
                  return Intrinsics.areEqual(var1, DeviceSetting.LINKED_DEVICE.INSTANCE) || Intrinsics.areEqual(var1, DeviceSetting.CHILD_LOCK_MODE.INSTANCE) || Intrinsics.areEqual(var1, DeviceSetting.AUTO_MODE_TRIGGERS.INSTANCE);
               } else if (!Intrinsics.areEqual(var4, Filter.ParticleFilter.INSTANCE) && !Intrinsics.areEqual(var4, Filter.UnknownFilter.INSTANCE)) {
                  throw new NoWhenBranchMatchedException();
               } else {
                  return Intrinsics.areEqual(var1, DeviceSetting.LINKED_DEVICE.INSTANCE) || Intrinsics.areEqual(var1, DeviceSetting.CHILD_LOCK_MODE.INSTANCE);
               }
            } else if (var0 instanceof DeviceNewClassic) {
               return false;
            } else {
               if (DeviceKt.isAfterG4(var0)) {
                  if (Intrinsics.areEqual(var1, DeviceSetting.TEMPERATURE.INSTANCE)) {
                     return var0 instanceof HasTemperatureUnit;
                  }

                  if (Intrinsics.areEqual(var1, DeviceSetting.DRY_MODE.INSTANCE) && var0 instanceof HasWick && !(var0 instanceof HasWickDryDuration)) {
                     return true;
                  }
               }

               return false;
            }
         } else {
            return Intrinsics.areEqual(var1, DeviceSetting.STANDBY_MODE.INSTANCE);
         }
      } else {
         return true;
      }
   }
}
