package com.blueair.devicedetails.util;

import android.content.Context;
import com.blueair.core.model.ApSubMode;
import com.blueair.core.model.AutoMode;
import com.blueair.core.model.ConnectivityStatus;
import com.blueair.core.model.Device;
import com.blueair.core.model.Device$_CC;
import com.blueair.core.model.DeviceAware;
import com.blueair.core.model.DeviceB4;
import com.blueair.core.model.DeviceB4sp;
import com.blueair.core.model.DeviceBlue;
import com.blueair.core.model.DeviceClassic;
import com.blueair.core.model.DeviceCombo2in1;
import com.blueair.core.model.DeviceCombo3in1;
import com.blueair.core.model.DeviceG4;
import com.blueair.core.model.DeviceHumidifier;
import com.blueair.core.model.DeviceIcp;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.DeviceNewClassic;
import com.blueair.core.model.DevicePet20;
import com.blueair.core.model.HasBlueCloudFunctions;
import com.blueair.core.model.HasBrightness;
import com.blueair.core.model.HasFanSpeed;
import com.blueair.core.model.HasG4NightMode;
import com.blueair.core.model.HasGermShieldMode;
import com.blueair.core.model.HasLinkingCapability;
import com.blueair.core.model.HasStandBy;
import com.blueair.core.model.MainMode;
import com.blueair.core.model.Mode;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0001H\u0002¨\u0006\u0006"},
   d2 = {"supportAttribute", "", "Lcom/blueair/core/model/Device;", "attribute", "Lcom/blueair/devicedetails/util/DeviceAttribute;", "forceOffline", "devicedetails_otherRelease"},
   k = 2,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceAttributeKt {
   // $FF: synthetic method
   public static boolean $r8$lambda$3_IOKHtQKZbahNTcjQNcvfvJcTI/* $FF was: $r8$lambda$3-IOKHtQKZbahNTcjQNcvfvJcTI*/(Device var0, DeviceAttribute var1) {
      return supportAttribute$lambda$2(var0, var1);
   }

   // $FF: synthetic method
   public static boolean $r8$lambda$8OvXMH7cLKGAiulw5UNU6V7uFsA(DeviceAttribute var0, Device var1) {
      return supportAttribute$lambda$0(var0, var1);
   }

   // $FF: synthetic method
   public static boolean $r8$lambda$SWhLsrTHwnccAnrMyBNMJM8E4to(Device var0, DeviceAttribute var1) {
      return supportAttribute$lambda$3(var0, var1);
   }

   // $FF: synthetic method
   public static boolean $r8$lambda$sr2OKXCBXOPOhwRp_CKqbkLFQtE(Device var0, DeviceAttribute var1) {
      return supportAttribute$lambda$1(var0, var1);
   }

   // $FF: synthetic method
   public static final boolean access$supportAttribute(Device var0, DeviceAttribute var1, boolean var2) {
      return supportAttribute(var0, var1, var2);
   }

   private static final boolean supportAttribute(Device var0, DeviceAttribute var1, boolean var2) {
      boolean var3;
      if (var0.getConnectivityStatus() == ConnectivityStatus.ONLINE && !var2) {
         var3 = 1;
      } else {
         var3 = 0;
      }

      if (!(var0 instanceof DevicePet20)) {
         if (var0 instanceof DeviceCombo2in1) {
            if (var3) {
               switch (DeviceAttributeKt.WhenMappings.$EnumSwitchMapping$0[var1.ordinal()]) {
                  case 1:
                  case 2:
                  case 3:
                  case 9:
                  case 10:
                     return true;
                  case 4:
                     var0 = (DeviceCombo2in1)var0;
                     if (!var0.isStandByOn() && var0.isInMode(Mode.FAN)) {
                        return true;
                     }

                     return false;
                  case 5:
                     var0 = (DeviceCombo2in1)var0;
                     if (!var0.isStandByOn() && !var0.isInMode(Mode.NIGHT)) {
                        return true;
                     }

                     return false;
                  case 6:
                  case 7:
                     if (!((DeviceCombo2in1)var0).isStandByOn()) {
                        return true;
                     }

                     return false;
                  case 8:
                  default:
                     return false;
                  case 11:
                     return ((DeviceCombo2in1)var0).getWickdryOn();
                  case 12:
                     var0 = (DeviceCombo2in1)var0;
                     return !var0.isStandByOn() && var0.isInMode(Mode.AUTO) && var0.getHumMode();
               }
            } else {
               return SetsKt.setOf(new DeviceAttribute[]{DeviceAttribute.N_OFFLINE, DeviceAttribute.N_FILTER_STATUS, DeviceAttribute.WICK_STATUS}).contains(var1);
            }
         } else if (var0 instanceof DeviceCombo3in1) {
            if (var3) {
               var3 = DeviceAttributeKt.WhenMappings.$EnumSwitchMapping$0[var1.ordinal()];
               switch (var3) {
                  case 1:
                  case 2:
                  case 3:
                     return true;
                  case 4:
                     var0 = (DeviceCombo3in1)var0;
                     if (!var0.isStandByOn() && var0.isInSubMode(ApSubMode.FAN)) {
                        return true;
                     }

                     return false;
                  case 5:
                     var0 = (DeviceCombo3in1)var0;
                     if (!var0.isStandByOn() && !SetsKt.setOf(new ApSubMode[]{ApSubMode.NIGHT, ApSubMode.ECO}).contains(var0.currentSubMode())) {
                        return true;
                     }

                     return false;
                  default:
                     switch (var3) {
                        case 13:
                           var0 = (DeviceCombo3in1)var0;
                           if (!var0.isStandByOn() && var0.getMainMode() == MainMode.COOL.getValue() && SetsKt.setOf(new ApSubMode[]{ApSubMode.AUTO, ApSubMode.ECO}).contains(var0.currentSubMode())) {
                              return true;
                           }

                           return false;
                        case 14:
                           var0 = (DeviceCombo3in1)var0;
                           if (!var0.isStandByOn() && var0.getMainMode() == MainMode.HEAT.getValue() && SetsKt.setOf(new ApSubMode[]{ApSubMode.AUTO, ApSubMode.ECO}).contains(var0.currentSubMode())) {
                              return true;
                           }

                           return false;
                        case 15:
                           break;
                        default:
                           return false;
                     }
                  case 6:
                  case 7:
                     return !((DeviceCombo3in1)var0).isStandByOn();
               }
            } else {
               return SetsKt.setOf(new DeviceAttribute[]{DeviceAttribute.N_OFFLINE, DeviceAttribute.N_FILTER_STATUS}).contains(var1);
            }
         } else if (var0 instanceof DeviceHumidifier) {
            if (var3) {
               switch (DeviceAttributeKt.WhenMappings.$EnumSwitchMapping$0[var1.ordinal()]) {
                  case 2:
                  case 10:
                     return true;
                  case 3:
                  case 8:
                  case 9:
                  default:
                     return false;
                  case 4:
                     var0 = (DeviceHumidifier)var0;
                     if (!var0.isStandByOn() && var0.getAutoMode() != AutoMode.ON && !var0.isG4NightModeOn()) {
                        return true;
                     }

                     return false;
                  case 5:
                     var0 = (DeviceHumidifier)var0;
                     if (!var0.isStandByOn() && !var0.isG4NightModeOn()) {
                        return true;
                     }

                     return false;
                  case 6:
                  case 7:
                     if (!((DeviceHumidifier)var0).isStandByOn()) {
                        return true;
                     }

                     return false;
                  case 11:
                     var0 = (DeviceHumidifier)var0;
                     if (!var0.isStandByOn() && !var0.getWaterShortage() && !var0.getWickdryOn()) {
                        return false;
                     }

                     return true;
                  case 12:
                     var0 = (DeviceHumidifier)var0;
                     return !var0.isStandByOn() && var0.getAutoMode() == AutoMode.ON;
               }
            } else {
               return SetsKt.setOf(new DeviceAttribute[]{DeviceAttribute.N_OFFLINE, DeviceAttribute.WICK_STATUS}).contains(var1);
            }
         } else if (var0 instanceof DeviceNewClassic) {
            if (SetsKt.setOf(DeviceAttribute.N_FILTER_STATUS).contains(var1)) {
               return true;
            } else if (var3) {
               var3 = DeviceAttributeKt.WhenMappings.$EnumSwitchMapping$0[var1.ordinal()];
               if (var3 != 2 && var3 != 3) {
                  if (var3 == 4) {
                     var0 = (DeviceNewClassic)var0;
                     if (!var0.isStandByOn() && var0.getAutoMode() != AutoMode.ON && !var0.isG4NightModeOn() && !var0.isEcoModeOn()) {
                        return true;
                     }

                     return false;
                  }

                  if (var3 == 5) {
                     var0 = (DeviceNewClassic)var0;
                     if (!var0.isStandByOn() && !var0.isG4NightModeOn() && !var0.isEcoModeOn()) {
                        return true;
                     }

                     return false;
                  }

                  if (var3 == 7) {
                     if (!((DeviceNewClassic)var0).isStandByOn()) {
                        return true;
                     }

                     return false;
                  }

                  if (var3 != 16) {
                     return false;
                  }
               }

               return true;
            } else {
               return SetsKt.setOf(new DeviceAttribute[]{DeviceAttribute.N_OFFLINE, DeviceAttribute.N_FILTER_STATUS}).contains(var1);
            }
         } else if (var3) {
            switch (DeviceAttributeKt.WhenMappings.$EnumSwitchMapping$0[var1.ordinal()]) {
               case 23:
                  return var0 instanceof HasBrightness;
               case 24:
                  if (var0 instanceof HasBlueCloudFunctions && Device$_CC.getTimezone$default(var0, (Context)null, 1, (Object)null).useDaylightTime()) {
                     return true;
                  }

                  return false;
               case 25:
                  if (!(var0 instanceof DeviceIcp) && !(var0 instanceof DeviceAware)) {
                     return true;
                  }

                  return false;
               default:
                  if (!(var0 instanceof DeviceG4) && !(var0 instanceof DeviceB4) && !(var0 instanceof DeviceB4sp) && !(var0 instanceof DeviceBlue)) {
                     if (var0 instanceof DeviceClassic) {
                        return DeviceAttribute.Companion.checkConnectivityStatus$default(DeviceAttribute.Companion, var0, var1, new DeviceAttributeKt$$ExternalSyntheticLambda1(var0, var1), (Function0)null, 8, (Object)null);
                     } else if (var0 instanceof DeviceIcp) {
                        return DeviceAttribute.Companion.checkConnectivityStatus$default(DeviceAttribute.Companion, var0, var1, new DeviceAttributeKt$$ExternalSyntheticLambda2(var0, var1), (Function0)null, 8, (Object)null);
                     } else {
                        return var0 instanceof HasLinkingCapability ? DeviceAttribute.Companion.checkConnectivityStatus$default(DeviceAttribute.Companion, var0, var1, new DeviceAttributeKt$$ExternalSyntheticLambda3(var0, var1), (Function0)null, 8, (Object)null) : false;
                     }
                  } else {
                     return DeviceAttribute.Companion.checkConnectivityStatus$default(DeviceAttribute.Companion, var0, var1, new DeviceAttributeKt$$ExternalSyntheticLambda0(var1, var0), (Function0)null, 8, (Object)null);
                  }
            }
         } else {
            var3 = DeviceAttributeKt.WhenMappings.$EnumSwitchMapping$0[var1.ordinal()];
            if (var3 != 25) {
               return var3 == 26;
            } else {
               return !(var0 instanceof DeviceIcp);
            }
         }
      } else if (var3) {
         switch (DeviceAttributeKt.WhenMappings.$EnumSwitchMapping$0[var1.ordinal()]) {
            case 1:
            case 2:
            case 3:
               return true;
            case 4:
               var0 = var0;
               if (!var0.isStandByOn() && var0.isInMainMode(MainMode.AirPurify) && var0.isInApSubMode(ApSubMode.FAN)) {
                  return true;
               }

               return false;
            case 5:
               var0 = var0;
               return !var0.isStandByOn() && (!var0.isInMainMode(MainMode.AirPurify) || !var0.isInApSubMode(ApSubMode.NIGHT));
            case 6:
            case 7:
               if (!((DevicePet20)var0).isStandByOn()) {
                  return true;
               }

               return false;
            case 8:
               return DeviceAttribute.Companion.getShowDetectCat();
            default:
               return false;
         }
      } else {
         return SetsKt.setOf(new DeviceAttribute[]{DeviceAttribute.N_OFFLINE, DeviceAttribute.N_FILTER_STATUS}).contains(var1);
      }
   }

   private static final boolean supportAttribute$lambda$0(DeviceAttribute var0, Device var1) {
      int var2 = DeviceAttributeKt.WhenMappings.$EnumSwitchMapping$0[var0.ordinal()];
      if (var2 != 20) {
         if (var2 != 21) {
            Intrinsics.checkNotNull(var1, "null cannot be cast to non-null type com.blueair.core.model.HasStandBy");
            if (((HasStandBy)var1).isStandByOn()) {
               return var0 == DeviceAttribute.STANDBY_MODE;
            } else if (DeviceKt.isDisinfectionOn(var1)) {
               return var0 == DeviceAttribute.DISINFECTION_STATUS;
            } else if (var0 == DeviceAttribute.GERMSHIELD_NM) {
               return var1 instanceof HasGermShieldMode && ((HasGermShieldMode)var1).getHasGermShieldNightMode() && ((HasG4NightMode)var1).isG4NightModeOn();
            } else if (((HasFanSpeed)var1).getAutoMode() != AutoMode.ON && !((HasG4NightMode)var1).isG4NightModeOn()) {
               var2 = DeviceAttributeKt.WhenMappings.$EnumSwitchMapping$0[var0.ordinal()];
               return var2 == 18 || var2 == 19;
            } else {
               return var0 == DeviceAttribute.AUTO_MODE;
            }
         } else {
            return DeviceKt.isGermShieldPlus(var1);
         }
      } else {
         return true;
      }
   }

   private static final boolean supportAttribute$lambda$1(Device var0, DeviceAttribute var1) {
      return DeviceAttribute.Companion.legacyWithSensorsAttributeCheck(((DeviceClassic)var0).getAutoMode(), var1);
   }

   private static final boolean supportAttribute$lambda$2(Device var0, DeviceAttribute var1) {
      if (((DeviceIcp)var0).getAutoMode() == AutoMode.ON) {
         int var3 = DeviceAttributeKt.WhenMappings.$EnumSwitchMapping$0[var1.ordinal()];
         return var3 == 20 || var3 == 22;
      } else {
         int var2 = DeviceAttributeKt.WhenMappings.$EnumSwitchMapping$0[var1.ordinal()];
         return var2 == 18 || var2 == 20;
      }
   }

   private static final boolean supportAttribute$lambda$3(Device var0, DeviceAttribute var1) {
      var0 = var0;
      if (var0.isLinked()) {
         return DeviceAttribute.Companion.legacyWithSensorsAttributeCheck(var0.getAutoMode(), var1);
      } else {
         return DeviceAttributeKt.WhenMappings.$EnumSwitchMapping$0[var1.ordinal()] == 18;
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
         int[] var0 = new int[DeviceAttribute.values().length];

         try {
            var0[DeviceAttribute.N_ON_OFF.ordinal()] = 1;
         } catch (NoSuchFieldError var27) {
         }

         try {
            var0[DeviceAttribute.N_MODE_BUTTONS.ordinal()] = 2;
         } catch (NoSuchFieldError var26) {
         }

         try {
            var0[DeviceAttribute.N_FILTER_STATUS.ordinal()] = 3;
         } catch (NoSuchFieldError var25) {
         }

         try {
            var0[DeviceAttribute.N_FAN_SPEED.ordinal()] = 4;
         } catch (NoSuchFieldError var24) {
         }

         try {
            var0[DeviceAttribute.N_BRIGHTNESS.ordinal()] = 5;
         } catch (NoSuchFieldError var23) {
         }

         try {
            var0[DeviceAttribute.TIMER.ordinal()] = 6;
         } catch (NoSuchFieldError var22) {
         }

         try {
            var0[DeviceAttribute.N_CHILD_LOCK.ordinal()] = 7;
         } catch (NoSuchFieldError var21) {
         }

         try {
            var0[DeviceAttribute.DETECT_CAT.ordinal()] = 8;
         } catch (NoSuchFieldError var20) {
         }

         try {
            var0[DeviceAttribute.HUM_ON_OFF.ordinal()] = 9;
         } catch (NoSuchFieldError var19) {
         }

         try {
            var0[DeviceAttribute.WICK_STATUS.ordinal()] = 10;
         } catch (NoSuchFieldError var18) {
         }

         try {
            var0[DeviceAttribute.DRY_MODE.ordinal()] = 11;
         } catch (NoSuchFieldError var17) {
         }

         try {
            var0[DeviceAttribute.AUTO_RH.ordinal()] = 12;
         } catch (NoSuchFieldError var16) {
         }

         try {
            var0[DeviceAttribute.FAN_PRESET.ordinal()] = 13;
         } catch (NoSuchFieldError var15) {
         }

         try {
            var0[DeviceAttribute.TARGET_TEMPERATURE.ordinal()] = 14;
         } catch (NoSuchFieldError var14) {
         }

         try {
            var0[DeviceAttribute.OSCILLATION.ordinal()] = 15;
         } catch (NoSuchFieldError var13) {
         }

         try {
            var0[DeviceAttribute.N_HINS.ordinal()] = 16;
         } catch (NoSuchFieldError var12) {
         }

         try {
            var0[DeviceAttribute.N_OFFLINE.ordinal()] = 17;
         } catch (NoSuchFieldError var11) {
         }

         try {
            var0[DeviceAttribute.MANUAL_MODE.ordinal()] = 18;
         } catch (NoSuchFieldError var10) {
         }

         try {
            var0[DeviceAttribute.CLEAN_AIR_ETA.ordinal()] = 19;
         } catch (NoSuchFieldError var9) {
         }

         try {
            var0[DeviceAttribute.MODE_BUTTONS.ordinal()] = 20;
         } catch (NoSuchFieldError var8) {
         }

         try {
            var0[DeviceAttribute.GERMSHIELD_STATUS.ordinal()] = 21;
         } catch (NoSuchFieldError var7) {
         }

         try {
            var0[DeviceAttribute.AUTO_MODE.ordinal()] = 22;
         } catch (NoSuchFieldError var6) {
         }

         try {
            var0[DeviceAttribute.BRIGHTNESS.ordinal()] = 23;
         } catch (NoSuchFieldError var5) {
         }

         try {
            var0[DeviceAttribute.TIMEZONE.ordinal()] = 24;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[DeviceAttribute.FILTER_STATUS.ordinal()] = 25;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[DeviceAttribute.OFFLINE.ordinal()] = 26;
         } catch (NoSuchFieldError var2) {
         }

         $EnumSwitchMapping$0 = var0;
      }
   }
}
