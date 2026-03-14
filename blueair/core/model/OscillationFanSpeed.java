package com.blueair.core.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(
   d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001b\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"},
   d2 = {"Lcom/blueair/core/model/OscillationFanSpeed;", "", "value", "", "displayValue", "<init>", "(Ljava/lang/String;III)V", "getValue", "()I", "getDisplayValue", "SPEED_1", "SPEED_2", "SPEED_3", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public enum OscillationFanSpeed {
   private static final EnumEntries $ENTRIES;
   private static final OscillationFanSpeed[] $VALUES;
   SPEED_1(0, 0, 2, (DefaultConstructorMarker)null),
   SPEED_2(1, 0, 2, (DefaultConstructorMarker)null),
   SPEED_3(2, 0, 2, (DefaultConstructorMarker)null);

   private final int displayValue;
   private final int value;

   // $FF: synthetic method
   private static final OscillationFanSpeed[] $values() {
      return new OscillationFanSpeed[]{SPEED_1, SPEED_2, SPEED_3};
   }

   static {
      OscillationFanSpeed[] var0 = $values();
      $VALUES = var0;
      $ENTRIES = EnumEntriesKt.enumEntries(var0);
   }

   private OscillationFanSpeed(int var3, int var4) {
      this.value = var3;
      this.displayValue = var4;
   }

   // $FF: synthetic method
   OscillationFanSpeed(int var3, int var4, int var5, DefaultConstructorMarker var6) {
      if ((var5 & 2) != 0) {
         var4 = var3 + 1;
      }

      this(var3, var4);
   }

   public static EnumEntries getEntries() {
      return $ENTRIES;
   }

   public final int getDisplayValue() {
      return this.displayValue;
   }

   public final int getValue() {
      return this.value;
   }
}
