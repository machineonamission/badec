package com.blueair.core.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(
   d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"},
   d2 = {"Lcom/blueair/core/model/ConnectivityStatus;", "", "<init>", "(Ljava/lang/String;I)V", "OFFLINE", "ONLINE", "CONNECTING", "UPDATING", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public enum ConnectivityStatus {
   private static final EnumEntries $ENTRIES;
   private static final ConnectivityStatus[] $VALUES;
   CONNECTING,
   OFFLINE,
   ONLINE,
   UPDATING;

   // $FF: synthetic method
   private static final ConnectivityStatus[] $values() {
      return new ConnectivityStatus[]{OFFLINE, ONLINE, CONNECTING, UPDATING};
   }

   static {
      ConnectivityStatus[] var0 = $values();
      $VALUES = var0;
      $ENTRIES = EnumEntriesKt.enumEntries(var0);
   }

   public static EnumEntries getEntries() {
      return $ENTRIES;
   }
}
