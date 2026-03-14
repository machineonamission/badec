package com.blueair.core.model;

import com.blueair.core.util.SkuConfigurationManager;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0007\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002\u001a\n\u0010\u0006\u001a\u00020\u0004*\u00020\u0002\u001a\n\u0010\u0007\u001a\u00020\u0004*\u00020\u0002\u001a\n\u0010\b\u001a\u00020\u0004*\u00020\u0002\u001a\n\u0010\t\u001a\u00020\u0004*\u00020\u0002\u001a\f\u0010\n\u001a\u00020\u0004*\u0004\u0018\u00010\u0002\u001a\n\u0010\u000b\u001a\u00020\f*\u00020\u0002\u001a\n\u0010\r\u001a\u00020\u0004*\u00020\u0002\u001a\n\u0010\u000e\u001a\u00020\u0004*\u00020\u0002\u001a\n\u0010\u000f\u001a\u00020\u0004*\u00020\u0002\u001a\n\u0010\u0010\u001a\u00020\u0004*\u00020\u0002\u001a\n\u0010\u0011\u001a\u00020\u0004*\u00020\u0002\u001a\n\u0010\u0012\u001a\u00020\u0004*\u00020\u0002\u001a\n\u0010\u001e\u001a\u00020\u0004*\u00020\u0002\u001a\n\u0010\u001f\u001a\u00020\u0004*\u00020\u0002\u001a\n\u0010 \u001a\u00020\u0004*\u00020\u0002\"\u0015\u0010\u0013\u001a\u00020\u0004*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014\"\u0015\u0010\u0015\u001a\u00020\u0004*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0014\"\u0015\u0010\u0016\u001a\u00020\u0004*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0014\"\u0015\u0010\u0017\u001a\u00020\u0004*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0014\"\u0015\u0010\u0018\u001a\u00020\u0004*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0014\"\u0017\u0010\u0019\u001a\u0004\u0018\u00010\u001a*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c\"\u0015\u0010\u001d\u001a\u00020\u0004*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0014¨\u0006!"},
   d2 = {"getFilterLifeTime", "Lcom/blueair/core/model/FilterLifeTime;", "Lcom/blueair/core/model/Device;", "isG4orB4orNB", "", "device", "isDisinfectionOn", "supportDisinfection", "isGermShieldOn", "isGermShieldPlus", "isCelsiusUnit", "fanSpeedValue", "", "useNewFilterConfig", "useV2UI", "hasAirFilter", "useWatetdropAuto", "supportSkinMode", "shouldMergeFilter", "isStandByOn", "(Lcom/blueair/core/model/Device;)Z", "isSafetySwitchOn", "isAfterG4", "isNoncancelable", "isCancellable", "skuCompat", "", "getSkuCompat", "(Lcom/blueair/core/model/Device;)Ljava/lang/String;", "isHumidifyModeOn", "hasFrontPanel", "useNewBrightnessRange", "supportRealTrack", "core_otherRelease"},
   k = 2,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceKt {
   public static final int fanSpeedValue(Device var0) {
      Intrinsics.checkNotNullParameter(var0, "<this>");
      if (var0 instanceof HasCoolMainMode) {
         return ((HasCoolMainMode)var0).getCoolFanSpeedLevel();
      } else if (var0 instanceof HasCombo3in1MainMode) {
         return ((HasCombo3in1MainMode)var0).currentFanSpeed();
      } else {
         if (var0 instanceof HasFanSpeed) {
            var0 = var0;
         } else {
            var0 = null;
         }

         return var0 != null ? var0.getFanSpeed() : 0;
      }
   }

   public static final FilterLifeTime getFilterLifeTime(Device var0) {
      Intrinsics.checkNotNullParameter(var0, "<this>");
      Timber.Forest var5 = Timber.Forest;
      StringBuilder var6 = new StringBuilder("Calculating Filter Days Left for Device ");
      var6.append(var0);
      String var10 = var6.toString();
      int var3 = 0;
      var5.v(var10, new Object[0]);
      if (!(var0 instanceof DeviceHumidifier20) && !(var0 instanceof DeviceHumidifier)) {
         if (var0 instanceof HasFanSpeed) {
            Integer var9 = ((HasFanSpeed)var0).getFilterLife();
            if (var9 != null) {
               int var4 = var9;
               if (isG4orB4orNB(var0)) {
                  return new FilterLifeTime.FilterPercentageLeft(Math.max(0, 100 - var4));
               } else if (var0.getType() instanceof DeviceType.Icp) {
                  Object var7;
                  if (var4 > 0) {
                     var7 = (double)var4 * (double)100.0F / (double)21600;
                  } else {
                     var7 = 0;
                  }

                  return new FilterLifeTime.FilterPercentageLeft(((Number)var7).intValue());
               } else {
                  var4 = Math.max(0, (int)Math.floor((double)(var4 * 5 / 1444)));
                  if (var4 <= 180) {
                     var3 = var4;
                  }

                  double var1 = (double)(var3 * 100) / (double)180;
                  return new FilterLifeTime.FilterDaysLeft(180 - var3, (int)Math.max((double)0.0F, (double)99 - var1));
               }
            } else {
               return new FilterLifeTime.NoFilterInfo();
            }
         } else {
            return new FilterLifeTime.NoFilterInfo();
         }
      } else {
         return new FilterLifeTime.NoFilterInfo();
      }
   }

   public static final String getSkuCompat(Device var0) {
      Intrinsics.checkNotNullParameter(var0, "<this>");
      if (var0 instanceof HasSKU) {
         return ((HasSKU)var0).getSku();
      } else {
         if (var0 instanceof HasCompatibility) {
            String var1 = ((HasCompatibility)var0).getCompatibility();
            if (var1 != null) {
               var1 = var1.toLowerCase(Locale.ROOT);
               Intrinsics.checkNotNullExpressionValue(var1, "toLowerCase(...)");
               return var1;
            }
         }

         return null;
      }
   }

   public static final boolean hasAirFilter(Device var0) {
      Intrinsics.checkNotNullParameter(var0, "<this>");
      return !(var0 instanceof DeviceHumidifier) && !(var0 instanceof DeviceHumidifier20) && !(var0 instanceof DeviceFanTable);
   }

   public static final boolean hasFrontPanel(Device var0) {
      Intrinsics.checkNotNullParameter(var0, "<this>");
      return var0 instanceof DeviceCombo2in120;
   }

   public static final boolean isAfterG4(Device var0) {
      Intrinsics.checkNotNullParameter(var0, "<this>");
      return var0.getTypeIndex() > DeviceType.Blue.INSTANCE.getIndex();
   }

   public static final boolean isCancellable(Device var0) {
      Intrinsics.checkNotNullParameter(var0, "<this>");
      return isNoncancelable(var0) ^ true;
   }

   public static final boolean isCelsiusUnit(Device var0) {
      return !(var0 instanceof HasTemperatureUnit) || ((HasTemperatureUnit)var0).getTemperatureUnit() != TemperatureUnit.Fahrenheit.getValue();
   }

   public static final boolean isDisinfectionOn(Device var0) {
      Intrinsics.checkNotNullParameter(var0, "<this>");
      return var0 instanceof HasDisinfection && Intrinsics.areEqual(((HasDisinfection)var0).getDisinfection(), true);
   }

   public static final boolean isG4orB4orNB(Device var0) {
      Intrinsics.checkNotNullParameter(var0, "device");
      return var0 instanceof DeviceG4 || var0 instanceof DeviceB4 || var0 instanceof DeviceB4sp || var0 instanceof DeviceBlue || isAfterG4(var0);
   }

   public static final boolean isGermShieldOn(Device var0) {
      Intrinsics.checkNotNullParameter(var0, "<this>");
      boolean var2 = var0 instanceof HasGermShieldMode;
      boolean var1 = false;
      if (var2) {
         if (var0 instanceof HasG4NightMode) {
            var1 = ((HasG4NightMode)var0).isG4NightModeOn();
         }

         HasGermShieldMode var3 = (HasGermShieldMode)var0;
         if (var3.getHasGermShieldNightMode() && var1 && !isDisinfectionOn(var0)) {
            Boolean var4 = var3.isGermShieldNightModeOn();
            return var4 != null ? var4 : true;
         } else {
            return var3.isGermShieldModeOn();
         }
      } else {
         return false;
      }
   }

   public static final boolean isGermShieldPlus(Device var0) {
      Intrinsics.checkNotNullParameter(var0, "<this>");
      return var0 instanceof HasGermShieldMode && ((HasGermShieldMode)var0).isGermShieldPlus();
   }

   public static final boolean isHumidifyModeOn(Device var0) {
      Intrinsics.checkNotNullParameter(var0, "<this>");
      boolean var1 = var0 instanceof HasHumMode;
      Object var3 = null;
      HasHumMode var2;
      if (var1) {
         var2 = (HasHumMode)var0;
      } else {
         var2 = null;
      }

      if (var2 == null || !var2.getHumMode()) {
         HasHumMainMode var4 = (HasHumMainMode)var3;
         if (var0 instanceof HasHumMainMode) {
            var4 = (HasHumMainMode)var0;
         }

         if (var4 == null || !var4.isInMainMode(MainMode.Humidification)) {
            return false;
         }
      }

      return true;
   }

   public static final boolean isNoncancelable(Device var0) {
      Intrinsics.checkNotNullParameter(var0, "<this>");
      return var0 instanceof DeviceHumidifier20 || var0 instanceof HasHumMainMode;
   }

   public static final boolean isSafetySwitchOn(Device var0) {
      Intrinsics.checkNotNullParameter(var0, "<this>");
      return var0 instanceof HasSafetySwitch ? ((HasSafetySwitch)var0).isSafetySwitchOn() : true;
   }

   public static final boolean isStandByOn(Device var0) {
      Intrinsics.checkNotNullParameter(var0, "<this>");
      return var0 instanceof HasStandBy ? ((HasStandBy)var0).isStandByOn() : false;
   }

   public static final boolean shouldMergeFilter(Device var0) {
      Intrinsics.checkNotNullParameter(var0, "<this>");
      return var0 instanceof DeviceCombo2in120 || var0 instanceof DeviceHumidifier20 && !var0.isCnDevice();
   }

   public static final boolean supportDisinfection(Device var0) {
      Intrinsics.checkNotNullParameter(var0, "<this>");
      return var0 instanceof HasDisinfection && SkuConfigurationManager.INSTANCE.getConfig().skuSupportDisinfection(getSkuCompat(var0));
   }

   public static final boolean supportRealTrack(Device var0) {
      Intrinsics.checkNotNullParameter(var0, "<this>");
      return var0 instanceof DeviceBlue && !StringsKt.contains$default((CharSequence)((DeviceBlue)var0).getModelName(), (CharSequence)"411", false, 2, (Object)null) || var0 instanceof DeviceBlue40 || var0 instanceof DeviceCombo2in120 || var0 instanceof DeviceDehumidifier || var0 instanceof DevicePet20 || var0 instanceof DeviceCombo2in1;
   }

   public static final boolean supportSkinMode(Device var0) {
      Intrinsics.checkNotNullParameter(var0, "<this>");
      return var0 instanceof DeviceCombo2in120;
   }

   public static final boolean useNewBrightnessRange(Device var0) {
      Intrinsics.checkNotNullParameter(var0, "<this>");
      McuFirmwareVersions var1 = SkuConfigurationManager.INSTANCE.getMcuFirmwareVersions();
      DeviceType var2 = var0.getType();
      String var3;
      if (Intrinsics.areEqual(var2, DeviceType.MiniRestful.INSTANCE)) {
         var3 = var1.getMrestBrightnessV2();
      } else if (Intrinsics.areEqual(var2, DeviceType.Humidifier20.INSTANCE)) {
         var3 = var1.getHum20BrightnessV2();
      } else if (Intrinsics.areEqual(var2, DeviceType.Dehumidifier.INSTANCE)) {
         var3 = var1.getDehumidifierBrightnessV2();
      } else if (Intrinsics.areEqual(var2, DeviceType.Combo2in120.INSTANCE)) {
         var3 = var1.getCombo2in120BrightnessV2();
      } else if (Intrinsics.areEqual(var2, DeviceType.Blue40.INSTANCE)) {
         var3 = var1.getBlue40BrightnessV2();
      } else {
         if (!Intrinsics.areEqual(var2, DeviceType.Pet20.INSTANCE)) {
            return false;
         }

         var3 = var1.getPet20BrightnessV2();
      }

      if (McuFirmwareVersions.Companion.compare(var0.getMcuFirmware(), var3) < 0) {
         return true;
      } else {
         return false;
      }
   }

   public static final boolean useNewFilterConfig(Device var0) {
      Intrinsics.checkNotNullParameter(var0, "<this>");
      return isAfterG4(var0) || var0 instanceof DeviceBlue;
   }

   public static final boolean useV2UI(Device var0) {
      Intrinsics.checkNotNullParameter(var0, "<this>");
      return var0.getTypeIndex() >= DeviceType.B4.INSTANCE.getIndex() || var0 instanceof DeviceG4;
   }

   public static final boolean useWatetdropAuto(Device var0) {
      Intrinsics.checkNotNullParameter(var0, "<this>");
      return var0 instanceof DeviceHumidifier20;
   }
}
