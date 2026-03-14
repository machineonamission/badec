package com.blueair.core.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(
   d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"},
   d2 = {"Lcom/blueair/core/model/Mode;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "FAN", "AUTO", "NIGHT", "ECO", "SKIN", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public enum Mode {
   private static final EnumEntries $ENTRIES;
   private static final Mode[] $VALUES;
   AUTO(2),
   ECO(4),
   FAN(1),
   NIGHT(3),
   SKIN(5);

   private final int value;

   // $FF: synthetic method
   private static final Mode[] $values() {
      return new Mode[]{FAN, AUTO, NIGHT, ECO, SKIN};
   }

   static {
      Mode[] var0 = $values();
      $VALUES = var0;
      $ENTRIES = EnumEntriesKt.enumEntries(var0);
   }

   private Mode(int var3) {
      this.value = var3;
   }

   public static EnumEntries getEntries() {
      return $ENTRIES;
   }

   public final int getValue() {
      return this.value;
   }
}
