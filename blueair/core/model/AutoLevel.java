package com.blueair.core.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(
   d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u000b\u001a\u00020\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000e"},
   d2 = {"Lcom/blueair/core/model/AutoLevel;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "LOW", "MEDIUM", "HIGH", "obtainFanSpeedRange", "", "Companion", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public enum AutoLevel {
   private static final EnumEntries $ENTRIES;
   private static final AutoLevel[] $VALUES;
   public static final Companion Companion;
   HIGH(2),
   LOW(0),
   MEDIUM(1);

   private final int value;

   // $FF: synthetic method
   private static final AutoLevel[] $values() {
      return new AutoLevel[]{LOW, MEDIUM, HIGH};
   }

   static {
      AutoLevel[] var0 = $values();
      $VALUES = var0;
      $ENTRIES = EnumEntriesKt.enumEntries(var0);
      Companion = new Companion((DefaultConstructorMarker)null);
   }

   private AutoLevel(int var3) {
      this.value = var3;
   }

   public static EnumEntries getEntries() {
      return $ENTRIES;
   }

   public final int getValue() {
      return this.value;
   }

   public final String obtainFanSpeedRange() {
      int var1 = AutoLevel.WhenMappings.$EnumSwitchMapping$0[this.ordinal()];
      if (var1 != 1) {
         return var1 != 2 ? "1 - 2" : "5 - 6";
      } else {
         return "3 - 4";
      }
   }

   @Metadata(
      d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"},
      d2 = {"Lcom/blueair/core/model/AutoLevel$Companion;", "", "<init>", "()V", "fromValue", "Lcom/blueair/core/model/AutoLevel;", "level", "", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Companion {
      private Companion() {
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker var1) {
         this();
      }

      public final AutoLevel fromValue(int var1) {
         if (var1 == AutoLevel.MEDIUM.getValue()) {
            return AutoLevel.MEDIUM;
         } else {
            return var1 == AutoLevel.HIGH.getValue() ? AutoLevel.HIGH : AutoLevel.LOW;
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
         int[] var0 = new int[AutoLevel.values().length];

         try {
            var0[AutoLevel.MEDIUM.ordinal()] = 1;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[AutoLevel.HIGH.ordinal()] = 2;
         } catch (NoSuchFieldError var2) {
         }

         $EnumSwitchMapping$0 = var0;
      }
   }
}
