package com.blueair.core.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(
   d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"},
   d2 = {"Lcom/blueair/core/model/TemperatureUnit;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "Celsius", "Fahrenheit", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public enum TemperatureUnit {
   private static final EnumEntries $ENTRIES;
   private static final TemperatureUnit[] $VALUES;
   Celsius(0),
   Fahrenheit(1);

   private final int value;

   // $FF: synthetic method
   private static final TemperatureUnit[] $values() {
      return new TemperatureUnit[]{Celsius, Fahrenheit};
   }

   static {
      TemperatureUnit[] var0 = $values();
      $VALUES = var0;
      $ENTRIES = EnumEntriesKt.enumEntries(var0);
   }

   private TemperatureUnit(int var3) {
      this.value = var3;
   }

   public static EnumEntries getEntries() {
      return $ENTRIES;
   }

   public final int getValue() {
      return this.value;
   }
}
