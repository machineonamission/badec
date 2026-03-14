package com.blueair.antifake.adapter;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(
   d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"},
   d2 = {"Lcom/blueair/antifake/adapter/ScanType;", "", "<init>", "(Ljava/lang/String;I)V", "Verification", "Result", "antifake_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public enum ScanType {
   private static final EnumEntries $ENTRIES;
   private static final ScanType[] $VALUES;
   Result,
   Verification;

   // $FF: synthetic method
   private static final ScanType[] $values() {
      return new ScanType[]{Verification, Result};
   }

   static {
      ScanType[] var0 = $values();
      $VALUES = var0;
      $ENTRIES = EnumEntriesKt.enumEntries(var0);
   }

   public static EnumEntries getEntries() {
      return $ENTRIES;
   }
}
