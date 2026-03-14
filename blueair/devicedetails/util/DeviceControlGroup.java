package com.blueair.devicedetails.util;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(
   d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"},
   d2 = {"Lcom/blueair/devicedetails/util/DeviceControlGroup;", "", "<init>", "(Ljava/lang/String;I)V", "MESSAGE", "MODE", "CONTROL", "LIGHT", "SCHEDULE", "FILTER", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public enum DeviceControlGroup {
   private static final EnumEntries $ENTRIES;
   private static final DeviceControlGroup[] $VALUES;
   CONTROL,
   FILTER,
   LIGHT,
   MESSAGE,
   MODE,
   SCHEDULE;

   // $FF: synthetic method
   private static final DeviceControlGroup[] $values() {
      return new DeviceControlGroup[]{MESSAGE, MODE, CONTROL, LIGHT, SCHEDULE, FILTER};
   }

   static {
      DeviceControlGroup[] var0 = $values();
      $VALUES = var0;
      $ENTRIES = EnumEntriesKt.enumEntries(var0);
   }

   public static EnumEntries getEntries() {
      return $ENTRIES;
   }
}
