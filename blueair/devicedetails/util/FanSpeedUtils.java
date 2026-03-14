package com.blueair.devicedetails.util;

import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceFanTable;
import com.blueair.core.model.DeviceG4;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.FanSpeedEnum;
import com.blueair.core.model.HasBlueCloudFunctions;
import com.blueair.core.model.HasFanSpeed;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006J\u000e\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006J\u000e\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006J\u000e\u0010\u0012\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006J\u000e\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006J\u001e\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0006J\u0016\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u0006J\u000e\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020 J\u0018\u0010\u001e\u001a\u00020\u00062\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010\u000f\u001a\u00020\u0010J\u0018\u0010\u001e\u001a\u00020\u00062\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\u0006R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\b¨\u0006\""},
   d2 = {"Lcom/blueair/devicedetails/util/FanSpeedUtils;", "", "<init>", "()V", "G4_FAN_PROGRESS_SNAP", "", "", "getG4_FAN_PROGRESS_SNAP", "()Ljava/util/List;", "getG4FanSpeedFromSeekBarProgress", "progress", "BLUE_PREMIUM_FAN_PROGRESS_SNAP", "getBLUE_PREMIUM_FAN_PROGRESS_SNAP", "getBluePremiumFromSeekBarProgress", "getProgressFromFanSpeedBluePremium", "fanSpeedEnum", "Lcom/blueair/core/model/FanSpeedEnum;", "getLegacySpeedFromSeekBarProgress", "getIcpSpeedFromSeekBarProgress", "getProgressFromFanSpeedLegacy", "getProgressFromFanSpeedG4", "getProgressFromFanSpeedIcp", "getG4AutoModeProgress", "fanSpeed", "relativeProgress", "input", "min", "max", "actualProgress", "maxProgress", "getFanSpeedLevel", "device", "Lcom/blueair/core/model/Device;", "fanSpeedValue", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class FanSpeedUtils {
   private static final List BLUE_PREMIUM_FAN_PROGRESS_SNAP;
   private static final List G4_FAN_PROGRESS_SNAP;
   public static final FanSpeedUtils INSTANCE = new FanSpeedUtils();

   static {
      Integer var0 = 0;
      Integer var1 = 77;
      Integer var3 = 80;
      Integer var2 = 84;
      Integer var4 = 96;
      G4_FAN_PROGRESS_SNAP = CollectionsKt.listOf(new Integer[]{var0, 33, 37, 41, 44, 47, 51, 53, 57, 60, 64, 66, 70, 74, var1, var3, var2, 87, 90, 93, var4, 99});
      BLUE_PREMIUM_FAN_PROGRESS_SNAP = CollectionsKt.listOf(new Integer[]{var0, 25, 27, 30, 34, 38, 42, 46, 50, 52, 55, 59, 63, 67, 71, 75, var1, var3, var2, 88, 92, var4, 100});
   }

   private FanSpeedUtils() {
   }

   public final int actualProgress(int var1, int var2) {
      return var1 * var2 / 100;
   }

   public final List getBLUE_PREMIUM_FAN_PROGRESS_SNAP() {
      return BLUE_PREMIUM_FAN_PROGRESS_SNAP;
   }

   public final int getBluePremiumFromSeekBarProgress(int var1) {
      if (var1 == 0) {
         return 0;
      } else if (1 <= var1 && var1 < 25) {
         return -1;
      } else if (25 <= var1 && var1 < 27) {
         return 11;
      } else if (27 <= var1 && var1 < 30) {
         return 15;
      } else if (30 <= var1 && var1 < 34) {
         return 19;
      } else if (34 <= var1 && var1 < 38) {
         return 23;
      } else if (38 <= var1 && var1 < 42) {
         return 27;
      } else if (42 <= var1 && var1 < 46) {
         return 31;
      } else if (46 <= var1 && var1 < 50) {
         return 35;
      } else if (50 <= var1 && var1 < 52) {
         return 37;
      } else if (52 <= var1 && var1 < 55) {
         return 39;
      } else if (55 <= var1 && var1 < 59) {
         return 43;
      } else if (59 <= var1 && var1 < 63) {
         return 47;
      } else if (63 <= var1 && var1 < 67) {
         return 51;
      } else if (67 <= var1 && var1 < 71) {
         return 55;
      } else if (71 <= var1 && var1 < 75) {
         return 59;
      } else if (75 <= var1 && var1 < 77) {
         return 64;
      } else if (77 <= var1 && var1 < 80) {
         return 67;
      } else if (80 <= var1 && var1 < 84) {
         return 71;
      } else if (84 <= var1 && var1 < 88) {
         return 75;
      } else if (88 <= var1 && var1 < 92) {
         return 79;
      } else if (92 <= var1 && var1 < 96) {
         return 83;
      } else if (96 <= var1 && var1 < 99) {
         return 87;
      } else {
         return 99 <= var1 && var1 < 101 ? 91 : 0;
      }
   }

   public final int getFanSpeedLevel(Device var1) {
      Intrinsics.checkNotNullParameter(var1, "device");
      return this.getFanSpeedLevel(var1, DeviceKt.fanSpeedValue(var1));
   }

   public final int getFanSpeedLevel(Device var1, int var2) {
      HasFanSpeed var3;
      if (var1 instanceof HasFanSpeed) {
         var3 = (HasFanSpeed)var1;
      } else {
         var3 = null;
      }

      if ((var3 == null || !var3.getHasGear4()) && !FanSpeedEnum.Companion.isUsingFourGearConfig(var1)) {
         if (var1 instanceof DeviceG4) {
            if (var2 >= 0 && var2 < 2) {
               return 0;
            } else if (2 <= var2 && var2 < 26) {
               return 1;
            } else if (26 <= var2 && var2 < 71) {
               return 2;
            } else {
               return 71 <= var2 && var2 < 92 ? 3 : 0;
            }
         } else if (var1 instanceof HasBlueCloudFunctions && !(var1 instanceof DeviceFanTable)) {
            if (var2 >= 0 && var2 < 2) {
               return 0;
            } else if (2 <= var2 && var2 < 31) {
               return 1;
            } else if (31 <= var2 && var2 < 71) {
               return 2;
            } else {
               return 71 <= var2 && var2 < 92 ? 3 : 0;
            }
         } else {
            return var2;
         }
      } else if (var2 >= 0 && var2 < 2) {
         return 0;
      } else if (2 <= var2 && var2 < 25) {
         return 1;
      } else if (25 <= var2 && var2 < 51) {
         return 2;
      } else if (51 <= var2 && var2 < 78) {
         return 3;
      } else {
         return 78 <= var2 && var2 < 92 ? 4 : 0;
      }
   }

   public final int getFanSpeedLevel(Device var1, FanSpeedEnum var2) {
      Intrinsics.checkNotNullParameter(var2, "fanSpeedEnum");
      return var1 == null ? 0 : this.getFanSpeedLevel(var1, var2.toServerValue(var1));
   }

   public final int getG4AutoModeProgress(int var1) {
      if (var1 >= 0 && var1 < 12) {
         return this.actualProgress(this.relativeProgress(var1, 0, 11), 33);
      } else if (12 <= var1 && var1 < 52) {
         return this.actualProgress(this.relativeProgress(var1, 11, 51), 33) + 33;
      } else {
         return 52 <= var1 && var1 <= Integer.MAX_VALUE ? this.actualProgress(this.relativeProgress(var1, 51, 91), 33) + 66 : 0;
      }
   }

   public final int getG4FanSpeedFromSeekBarProgress(int var1) {
      if (var1 == 0) {
         return 0;
      } else if (1 <= var1 && var1 < 33) {
         return -1;
      } else if (33 <= var1 && var1 < 37) {
         return 11;
      } else if (37 <= var1 && var1 < 41) {
         return 15;
      } else if (41 <= var1 && var1 < 44) {
         return 19;
      } else if (44 <= var1 && var1 < 47) {
         return 23;
      } else if (47 <= var1 && var1 < 51) {
         return 27;
      } else if (51 <= var1 && var1 < 53) {
         return 31;
      } else if (53 <= var1 && var1 < 57) {
         return 35;
      } else if (57 <= var1 && var1 < 60) {
         return 39;
      } else if (60 <= var1 && var1 < 64) {
         return 43;
      } else if (64 <= var1 && var1 < 66) {
         return 47;
      } else if (66 <= var1 && var1 < 70) {
         return 51;
      } else if (70 <= var1 && var1 < 74) {
         return 55;
      } else if (74 <= var1 && var1 < 77) {
         return 59;
      } else if (77 <= var1 && var1 < 80) {
         return 63;
      } else if (80 <= var1 && var1 < 84) {
         return 67;
      } else if (84 <= var1 && var1 < 87) {
         return 71;
      } else if (87 <= var1 && var1 < 90) {
         return 75;
      } else if (90 <= var1 && var1 < 93) {
         return 79;
      } else if (93 <= var1 && var1 < 96) {
         return 83;
      } else if (96 <= var1 && var1 < 99) {
         return 87;
      } else {
         return 99 <= var1 && var1 < 101 ? 91 : 0;
      }
   }

   public final List getG4_FAN_PROGRESS_SNAP() {
      return G4_FAN_PROGRESS_SNAP;
   }

   public final int getIcpSpeedFromSeekBarProgress(int var1) {
      if (var1 == 0) {
         return 1;
      } else if (1 <= var1 && var1 < 50) {
         return -1;
      } else if (var1 == 50) {
         return 2;
      } else {
         return 51 <= var1 && var1 < 100 ? -1 : 3;
      }
   }

   public final int getLegacySpeedFromSeekBarProgress(int var1) {
      if (var1 == 0) {
         return 0;
      } else if (1 <= var1 && var1 < 33) {
         return -1;
      } else if (var1 == 33) {
         return 1;
      } else if (34 <= var1 && var1 < 66) {
         return -1;
      } else if (var1 == 66) {
         return 2;
      } else if (67 <= var1 && var1 < 99) {
         return -1;
      } else if (99 <= var1 && var1 <= Integer.MAX_VALUE) {
         return 3;
      } else {
         Timber.Forest var3 = Timber.Forest;
         StringBuilder var2 = new StringBuilder("Unknown value: ");
         var2.append(var1);
         var3.d(var2.toString(), new Object[0]);
         return 0;
      }
   }

   public final int getProgressFromFanSpeedBluePremium(FanSpeedEnum var1) {
      Intrinsics.checkNotNullParameter(var1, "fanSpeedEnum");
      switch (FanSpeedUtils.WhenMappings.$EnumSwitchMapping$0[var1.ordinal()]) {
         case 1:
            return 0;
         case 2:
            return 25;
         case 3:
            return 27;
         case 4:
            return 30;
         case 5:
            return 34;
         case 6:
            return 38;
         case 7:
            return 42;
         case 8:
            return 46;
         case 9:
            return 50;
         case 10:
            return 52;
         case 11:
            return 55;
         case 12:
            return 59;
         case 13:
            return 63;
         case 14:
            return 67;
         case 15:
            return 71;
         case 16:
            return 75;
         case 17:
            return 77;
         case 18:
            return 80;
         case 19:
            return 84;
         case 20:
            return 88;
         case 21:
            return 92;
         case 22:
            return 96;
         case 23:
            return 100;
         default:
            return 0;
      }
   }

   public final int getProgressFromFanSpeedG4(FanSpeedEnum var1) {
      Intrinsics.checkNotNullParameter(var1, "fanSpeedEnum");
      switch (FanSpeedUtils.WhenMappings.$EnumSwitchMapping$0[var1.ordinal()]) {
         case 1:
            return 0;
         case 2:
            return 33;
         case 3:
            return 37;
         case 4:
            return 41;
         case 5:
            return 44;
         case 6:
            return 47;
         case 7:
            return 51;
         case 8:
            return 53;
         case 9:
         case 16:
         case 24:
         case 25:
         case 26:
         default:
            return 0;
         case 10:
            return 57;
         case 11:
            return 60;
         case 12:
            return 64;
         case 13:
            return 66;
         case 14:
            return 70;
         case 15:
            return 74;
         case 17:
            return 80;
         case 18:
            return 84;
         case 19:
            return 87;
         case 20:
            return 90;
         case 21:
            return 93;
         case 22:
            return 96;
         case 23:
            return 99;
         case 27:
            return 77;
      }
   }

   public final int getProgressFromFanSpeedIcp(FanSpeedEnum var1) {
      Intrinsics.checkNotNullParameter(var1, "fanSpeedEnum");
      switch (FanSpeedUtils.WhenMappings.$EnumSwitchMapping$0[var1.ordinal()]) {
         case 24:
            return 0;
         case 25:
            return 50;
         case 26:
            return 100;
         default:
            return 0;
      }
   }

   public final int getProgressFromFanSpeedLegacy(FanSpeedEnum var1) {
      Intrinsics.checkNotNullParameter(var1, "fanSpeedEnum");
      int var2 = FanSpeedUtils.WhenMappings.$EnumSwitchMapping$0[var1.ordinal()];
      if (var2 != 1) {
         switch (var2) {
            case 24:
               return 33;
            case 25:
               return 66;
            case 26:
               return 99;
            default:
               return 0;
         }
      } else {
         return 0;
      }
   }

   public final int relativeProgress(int var1, int var2, int var3) {
      if (var1 >= var2 && var3 > var2) {
         return (var1 - var2) * 100 / (var3 - var2);
      } else {
         Timber.Forest var4 = Timber.Forest;
         StringBuilder var5 = new StringBuilder("relativeProgress method checks not met: input = ");
         var5.append(var1);
         var5.append(", min = ");
         var5.append(var2);
         var5.append(", max = ");
         var5.append(var3);
         var4.w(var5.toString(), new Object[0]);
         return 0;
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
         int[] var0 = new int[FanSpeedEnum.values().length];

         try {
            var0[FanSpeedEnum.OFF.ordinal()] = 1;
         } catch (NoSuchFieldError var28) {
         }

         try {
            var0[FanSpeedEnum.ELEVEN.ordinal()] = 2;
         } catch (NoSuchFieldError var27) {
         }

         try {
            var0[FanSpeedEnum.FIFTEEN.ordinal()] = 3;
         } catch (NoSuchFieldError var26) {
         }

         try {
            var0[FanSpeedEnum.NINETEEN.ordinal()] = 4;
         } catch (NoSuchFieldError var25) {
         }

         try {
            var0[FanSpeedEnum.TWENTY_THREE.ordinal()] = 5;
         } catch (NoSuchFieldError var24) {
         }

         try {
            var0[FanSpeedEnum.TWENTY_SEVEN.ordinal()] = 6;
         } catch (NoSuchFieldError var23) {
         }

         try {
            var0[FanSpeedEnum.THIRTY_ONE.ordinal()] = 7;
         } catch (NoSuchFieldError var22) {
         }

         try {
            var0[FanSpeedEnum.THIRTY_FIVE.ordinal()] = 8;
         } catch (NoSuchFieldError var21) {
         }

         try {
            var0[FanSpeedEnum.THIRTY_SEVEN.ordinal()] = 9;
         } catch (NoSuchFieldError var20) {
         }

         try {
            var0[FanSpeedEnum.THIRTY_NINE.ordinal()] = 10;
         } catch (NoSuchFieldError var19) {
         }

         try {
            var0[FanSpeedEnum.FORTY_THREE.ordinal()] = 11;
         } catch (NoSuchFieldError var18) {
         }

         try {
            var0[FanSpeedEnum.FORTY_SEVEN.ordinal()] = 12;
         } catch (NoSuchFieldError var17) {
         }

         try {
            var0[FanSpeedEnum.FIFTY_ONE.ordinal()] = 13;
         } catch (NoSuchFieldError var16) {
         }

         try {
            var0[FanSpeedEnum.FIFTY_FIVE.ordinal()] = 14;
         } catch (NoSuchFieldError var15) {
         }

         try {
            var0[FanSpeedEnum.FIFTY_NINE.ordinal()] = 15;
         } catch (NoSuchFieldError var14) {
         }

         try {
            var0[FanSpeedEnum.SIXTY_FOUR.ordinal()] = 16;
         } catch (NoSuchFieldError var13) {
         }

         try {
            var0[FanSpeedEnum.SIXTY_SEVEN.ordinal()] = 17;
         } catch (NoSuchFieldError var12) {
         }

         try {
            var0[FanSpeedEnum.SEVENTY_ONE.ordinal()] = 18;
         } catch (NoSuchFieldError var11) {
         }

         try {
            var0[FanSpeedEnum.SEVENTY_FIVE.ordinal()] = 19;
         } catch (NoSuchFieldError var10) {
         }

         try {
            var0[FanSpeedEnum.SEVENTY_NINE.ordinal()] = 20;
         } catch (NoSuchFieldError var9) {
         }

         try {
            var0[FanSpeedEnum.EIGHTY_THREE.ordinal()] = 21;
         } catch (NoSuchFieldError var8) {
         }

         try {
            var0[FanSpeedEnum.EIGHTY_SEVEN.ordinal()] = 22;
         } catch (NoSuchFieldError var7) {
         }

         try {
            var0[FanSpeedEnum.NINETY_ONE.ordinal()] = 23;
         } catch (NoSuchFieldError var6) {
         }

         try {
            var0[FanSpeedEnum.ONE.ordinal()] = 24;
         } catch (NoSuchFieldError var5) {
         }

         try {
            var0[FanSpeedEnum.TWO.ordinal()] = 25;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[FanSpeedEnum.THREE.ordinal()] = 26;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[FanSpeedEnum.SIXTY_THREE.ordinal()] = 27;
         } catch (NoSuchFieldError var2) {
         }

         $EnumSwitchMapping$0 = var0;
      }
   }
}
