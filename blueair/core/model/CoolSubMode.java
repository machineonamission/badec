package com.blueair.core.model;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(
   d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u000b\u001a\u00020\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\r"},
   d2 = {"Lcom/blueair/core/model/CoolSubMode;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "FAN", "AUTO", "NIGHT", "toMode", "Lcom/blueair/core/model/Mode;", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public enum CoolSubMode {
   private static final EnumEntries $ENTRIES;
   private static final CoolSubMode[] $VALUES;
   AUTO(2),
   FAN(1),
   NIGHT(3);

   private final int value;

   // $FF: synthetic method
   private static final CoolSubMode[] $values() {
      return new CoolSubMode[]{FAN, AUTO, NIGHT};
   }

   static {
      CoolSubMode[] var0 = $values();
      $VALUES = var0;
      $ENTRIES = EnumEntriesKt.enumEntries(var0);
   }

   private CoolSubMode(int var3) {
      this.value = var3;
   }

   public static EnumEntries getEntries() {
      return $ENTRIES;
   }

   public final int getValue() {
      return this.value;
   }

   public final Mode toMode() {
      int var1 = CoolSubMode.WhenMappings.$EnumSwitchMapping$0[this.ordinal()];
      if (var1 != 1) {
         if (var1 != 2) {
            if (var1 == 3) {
               return Mode.NIGHT;
            } else {
               throw new NoWhenBranchMatchedException();
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
         int[] var0 = new int[CoolSubMode.values().length];

         try {
            var0[CoolSubMode.FAN.ordinal()] = 1;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[CoolSubMode.AUTO.ordinal()] = 2;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[CoolSubMode.NIGHT.ordinal()] = 3;
         } catch (NoSuchFieldError var2) {
         }

         $EnumSwitchMapping$0 = var0;
      }
   }
}
