package com.blueair.devicedetails.util;

import com.blueair.core.model.MoodLampEnum;
import com.blueair.viewcore.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0015\u0010\u0004\u001a\u00020\u0005*\u00020\u00068G¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"},
   d2 = {"Lcom/blueair/devicedetails/util/NightLampUtils;", "", "<init>", "()V", "titleRes", "", "Lcom/blueair/core/model/MoodLampEnum;", "getTitleRes", "(Lcom/blueair/core/model/MoodLampEnum;)I", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class NightLampUtils {
   public static final NightLampUtils INSTANCE = new NightLampUtils();

   private NightLampUtils() {
   }

   public final int getTitleRes(MoodLampEnum var1) {
      Intrinsics.checkNotNullParameter(var1, "<this>");
      int var2 = NightLampUtils.WhenMappings.$EnumSwitchMapping$0[var1.ordinal()];
      if (var2 != 1) {
         if (var2 != 2) {
            return var2 != 3 ? R.string.light_gear_off : R.string.light_gear_bright;
         } else {
            return R.string.light_gear_normal;
         }
      } else {
         return R.string.light_gear_warm;
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
         int[] var0 = new int[MoodLampEnum.values().length];

         try {
            var0[MoodLampEnum.WARM.ordinal()] = 1;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[MoodLampEnum.NORMAL.ordinal()] = 2;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[MoodLampEnum.BRIGHT.ordinal()] = 3;
         } catch (NoSuchFieldError var2) {
         }

         $EnumSwitchMapping$0 = var0;
      }
   }
}
