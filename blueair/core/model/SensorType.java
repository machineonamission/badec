package com.blueair.core.model;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;

@Metadata(
   d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\r\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010\u0012j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u0013"},
   d2 = {"Lcom/blueair/core/model/SensorType;", "", "<init>", "(Ljava/lang/String;I)V", "PM1", "PM25", "PM10", "VOC", "HCHO", "HUM", "TMP", "FAN", "WEIGHT", "RPM", "formatValue", "", "value", "", "(Ljava/lang/Float;)Ljava/lang/String;", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public enum SensorType {
   private static final EnumEntries $ENTRIES;
   private static final SensorType[] $VALUES;
   FAN,
   HCHO,
   HUM,
   PM1,
   PM10,
   PM25,
   RPM,
   TMP,
   VOC,
   WEIGHT;

   // $FF: synthetic method
   private static final SensorType[] $values() {
      return new SensorType[]{PM1, PM25, PM10, VOC, HCHO, HUM, TMP, FAN, WEIGHT, RPM};
   }

   static {
      SensorType[] var0 = $values();
      $VALUES = var0;
      $ENTRIES = EnumEntriesKt.enumEntries(var0);
   }

   public static EnumEntries getEntries() {
      return $ENTRIES;
   }

   public final String formatValue(Float var1) {
      if (var1 == null) {
         return StringsKt.padStart$default("-", 3, '\u0000', 2, (Object)null);
      } else {
         int var2 = SensorType.WhenMappings.$EnumSwitchMapping$0[this.ordinal()];
         if (var2 != 1) {
            if (var2 != 2) {
               return StringsKt.padStart$default(String.valueOf(MathKt.roundToInt(var1)), 3, '\u0000', 2, (Object)null);
            } else {
               String var3 = String.format("%.4f", Arrays.copyOf(new Object[]{var1 / (float)10000}, 1));
               Intrinsics.checkNotNullExpressionValue(var3, "format(...)");
               return var3;
            }
         } else {
            return "";
         }
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
         int[] var0 = new int[SensorType.values().length];

         try {
            var0[SensorType.VOC.ordinal()] = 1;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[SensorType.HCHO.ordinal()] = 2;
         } catch (NoSuchFieldError var2) {
         }

         $EnumSwitchMapping$0 = var0;
      }
   }
}
