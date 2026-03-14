package com.blueair.devicedetails.util;

import com.blueair.core.model.ApSubMode;
import com.blueair.core.model.AutoMode;
import com.blueair.core.model.CoolSubMode;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceB4;
import com.blueair.core.model.DeviceB4sp;
import com.blueair.core.model.DeviceBlue;
import com.blueair.core.model.DeviceBlue40;
import com.blueair.core.model.DeviceCombo2in1;
import com.blueair.core.model.DeviceCombo2in120;
import com.blueair.core.model.DeviceDehumidifier;
import com.blueair.core.model.DeviceFanTable;
import com.blueair.core.model.DeviceG4;
import com.blueair.core.model.DeviceHumidifier;
import com.blueair.core.model.DeviceHumidifier20;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.DeviceNewClassic;
import com.blueair.core.model.HasBody;
import com.blueair.core.model.HasCombo3in1MainMode;
import com.blueair.core.model.HasCoolMainMode;
import com.blueair.core.model.HasDisinfection;
import com.blueair.core.model.HasEcoMode;
import com.blueair.core.model.HasFanSpeed;
import com.blueair.core.model.HasG4NightMode;
import com.blueair.core.model.HasHumMainMode;
import com.blueair.core.model.HasMainMode;
import com.blueair.core.model.HasMode;
import com.blueair.core.model.HasPetMainMode;
import com.blueair.core.model.HasTimer;
import com.blueair.core.model.HumSubMode;
import com.blueair.core.model.MainMode;
import com.blueair.core.model.Mode;
import com.blueair.core.model.WaterLevel;
import com.blueair.viewcore.R;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\b\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J)\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\r\"\u00020\u000eH\u0002¢\u0006\u0002\u0010\u000fJ\u000e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0010\u0010\u0013\u001a\u00020\u00142\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¨\u0006\u0015"},
   d2 = {"Lcom/blueair/devicedetails/util/DeviceControlUtils;", "", "<init>", "()V", "shouldHideFanSpeed", "", "device", "Lcom/blueair/core/model/Device;", "shouldShowTimer", "shouldShowBrightness", "isFanMode", "checkAirPurifySubMode", "subModes", "", "Lcom/blueair/core/model/ApSubMode;", "(Lcom/blueair/core/model/Device;[Lcom/blueair/core/model/ApSubMode;)Z", "checkAutoMode", "checkNightMode", "checkEcoMode", "obtainTargetHumidityInfoRes", "", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceControlUtils {
   public static final DeviceControlUtils INSTANCE = new DeviceControlUtils();

   private DeviceControlUtils() {
   }

   private final boolean checkAirPurifySubMode(Device var1, ApSubMode... var2) {
      if (var1 instanceof HasCombo3in1MainMode) {
         return ArraysKt.contains(var2, ((HasCombo3in1MainMode)var1).currentSubMode());
      } else {
         if (var1 instanceof HasMainMode) {
            var1 = var1;
            if (var1.isInMainMode(MainMode.AirPurify) && ArraysKt.contains(var2, var1.apSubMode())) {
               return true;
            }
         }

         return false;
      }
   }

   private final boolean checkEcoMode(Device var1) {
      if (var1 instanceof HasEcoMode) {
         var1 = var1;
      } else {
         var1 = null;
      }

      return var1 != null && var1.isEcoModeOn();
   }

   private final boolean checkNightMode(Device var1) {
      if (var1 instanceof HasG4NightMode) {
         var1 = var1;
      } else {
         var1 = null;
      }

      return var1 != null && var1.isG4NightModeOn();
   }

   public final boolean checkAutoMode(Device var1) {
      Intrinsics.checkNotNullParameter(var1, "device");
      boolean var2 = var1 instanceof HasFanSpeed;
      Object var4 = null;
      HasFanSpeed var3;
      if (var2) {
         var3 = (HasFanSpeed)var1;
      } else {
         var3 = null;
      }

      AutoMode var5;
      if (var3 != null) {
         var5 = var3.getAutoMode();
      } else {
         var5 = null;
      }

      if (var5 != AutoMode.ON) {
         HasMode var6 = (HasMode)var4;
         if (var1 instanceof HasMode) {
            var6 = (HasMode)var1;
         }

         if (var6 == null || !var6.isInMode(Mode.AUTO)) {
            return false;
         }
      }

      return true;
   }

   public final boolean isFanMode(Device var1) {
      Intrinsics.checkNotNullParameter(var1, "device");
      if (var1 instanceof HasCoolMainMode) {
         return ((HasCoolMainMode)var1).isInSubMode(CoolSubMode.FAN);
      } else if (this.checkAirPurifySubMode(var1, ApSubMode.FAN)) {
         return true;
      } else if (var1 instanceof HasMode) {
         return ((HasMode)var1).isInMode(Mode.FAN);
      } else if (var1 instanceof HasHumMainMode) {
         return DeviceKt.isHumidifyModeOn(var1) && ((HasHumMainMode)var1).isInHumSubMode(HumSubMode.FAN);
      } else if (!(var1 instanceof DeviceBlue) && !(var1 instanceof DeviceHumidifier20) && !(var1 instanceof DeviceHumidifier) && !(var1 instanceof DeviceB4) && !(var1 instanceof DeviceG4) && !(var1 instanceof DeviceNewClassic)) {
         return false;
      } else {
         return !this.checkAutoMode(var1) && !this.checkNightMode(var1) && !this.checkEcoMode(var1);
      }
   }

   public final int obtainTargetHumidityInfoRes(Device var1) {
      if (var1 instanceof DeviceCombo2in1) {
         return R.string.target_humidity_info_v3;
      } else {
         return var1 instanceof DeviceCombo2in120 ? R.string.target_humidity_info_2in120 : R.string.target_humidity_info_v2;
      }
   }

   public final boolean shouldHideFanSpeed(Device var1) {
      Intrinsics.checkNotNullParameter(var1, "device");
      if (var1 instanceof DeviceHumidifier20) {
         var1 = (DeviceHumidifier20)var1;
         return var1.getWickdryOn() || var1.isInWaterLevel(WaterLevel.SHORTAGE);
      } else if (!(var1 instanceof DeviceCombo2in120)) {
         if (var1 instanceof HasBody) {
            return !((HasBody)var1).getBodyMounted();
         } else {
            return var1 instanceof HasDisinfection ? DeviceKt.isDisinfectionOn(var1) : false;
         }
      } else {
         var1 = var1;
         return var1.getWickdryOn() || var1.isInMainMode(MainMode.Humidification) && (var1.isInWaterLevel(WaterLevel.SHORTAGE) || var1.getWaterTankFailure());
      }
   }

   public final boolean shouldShowBrightness(Device var1) {
      Intrinsics.checkNotNullParameter(var1, "device");
      if (var1 instanceof DeviceCombo2in120) {
         DeviceCombo2in120 var2 = (DeviceCombo2in120)var1;
         if (var2.getWickdryOn()) {
            return true;
         } else if (DeviceKt.isHumidifyModeOn(var1)) {
            return !var2.isInHumSubMode(HumSubMode.NIGHT);
         } else {
            return !var2.isInApSubMode(ApSubMode.NIGHT);
         }
      } else if (this.checkAirPurifySubMode(var1, ApSubMode.FAN, ApSubMode.AUTO)) {
         return true;
      } else if (var1 instanceof DeviceFanTable) {
         return true;
      } else if (var1 instanceof DeviceDehumidifier) {
         return ((DeviceDehumidifier)var1).isInMainMode(MainMode.Dehumidification);
      } else if (var1 instanceof DeviceHumidifier20) {
         return ((DeviceHumidifier20)var1).getWickdryOn() || !this.checkNightMode(var1);
      } else if (var1 instanceof DeviceNewClassic) {
         var1 = var1;
         return !var1.isG4NightModeOn() && !var1.isEcoModeOn();
      } else if (var1 instanceof HasMode) {
         return !((HasMode)var1).isInMode(Mode.NIGHT);
      } else if (var1 instanceof HasPetMainMode) {
         return ((HasPetMainMode)var1).isInMainMode(MainMode.SMART);
      } else if (!(var1 instanceof DeviceBlue) && !(var1 instanceof DeviceHumidifier) && !(var1 instanceof DeviceB4) && !(var1 instanceof DeviceB4sp) && !(var1 instanceof DeviceG4)) {
         return false;
      } else {
         return !this.checkNightMode(var1);
      }
   }

   public final boolean shouldShowTimer(Device var1) {
      return var1 instanceof HasTimer && !(var1 instanceof DeviceBlue40);
   }
}
