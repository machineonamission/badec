package com.blueair.core.model;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(
   d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\f\u001a\u00020\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\u000e"},
   d2 = {"Lcom/blueair/core/model/HumSubMode;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "FAN", "AUTO", "NIGHT", "SKIN", "toMode", "Lcom/blueair/core/model/Mode;", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public enum HumSubMode {
   private static final EnumEntries $ENTRIES;
   private static final HumSubMode[] $VALUES;
   AUTO(2),
   FAN(1),
   NIGHT(3),
   SKIN(5);

   private final int value;

   // $FF: synthetic method
   private static final HumSubMode[] $values() {
      return new HumSubMode[]{FAN, AUTO, NIGHT, SKIN};
   }

   static {
      HumSubMode[] var0 = $values();
      $VALUES = var0;
      $ENTRIES = EnumEntriesKt.enumEntries(var0);
   }

   private HumSubMode(int var3) {
      this.value = var3;
   }

   public static EnumEntries getEntries() {
      return $ENTRIES;
   }

   public final int getValue() {
      return this.value;
   }

   public final Mode toMode() {
      int var1 = HumSubMode.WhenMappings.$EnumSwitchMapping$0[this.ordinal()];
      if (var1 != 1) {
         if (var1 != 2) {
            if (var1 != 3) {
               if (var1 == 4) {
                  return Mode.SKIN;
               } else {
                  throw new NoWhenBranchMatchedException();
               }
            } else {
               return Mode.NIGHT;
            }
         } else {
            return Mode.AUTO;
         }
      } else {
         return Mode.FAN;
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
         int[] var0 = new int[HumSubMode.values().length];

         try {
            var0[HumSubMode.FAN.ordinal()] = 1;
         } catch (NoSuchFieldError var5) {
         }

         try {
            var0[HumSubMode.AUTO.ordinal()] = 2;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[HumSubMode.NIGHT.ordinal()] = 3;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[HumSubMode.SKIN.ordinal()] = 4;
         } catch (NoSuchFieldError var2) {
         }

         $EnumSwitchMapping$0 = var0;
      }
   }
}
