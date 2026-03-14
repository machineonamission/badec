package com.blueair.core.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(
   d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"},
   d2 = {"Lcom/blueair/core/model/NotificationType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "ALL", "LEGACY_PRODUCT_ALERT", "WATER_LEVEL", "FILTER_REPLACEMENT", "QUICK_ALARM_STOP", "FILTER_CLEANING", "MARKETING", "TRANSACTIONAL", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public enum NotificationType {
   private static final EnumEntries $ENTRIES;
   private static final NotificationType[] $VALUES;
   ALL("all_alert"),
   FILTER_CLEANING("cleaning_reminders"),
   FILTER_REPLACEMENT("filter_replacement"),
   LEGACY_PRODUCT_ALERT("product_alert"),
   MARKETING("marketing_notifications"),
   QUICK_ALARM_STOP("quick_alarm_stop"),
   TRANSACTIONAL("transactional_notifications"),
   WATER_LEVEL("water_level");

   private final String value;

   // $FF: synthetic method
   private static final NotificationType[] $values() {
      return new NotificationType[]{ALL, LEGACY_PRODUCT_ALERT, WATER_LEVEL, FILTER_REPLACEMENT, QUICK_ALARM_STOP, FILTER_CLEANING, MARKETING, TRANSACTIONAL};
   }

   static {
      NotificationType[] var0 = $values();
      $VALUES = var0;
      $ENTRIES = EnumEntriesKt.enumEntries(var0);
   }

   private NotificationType(String var3) {
      this.value = var3;
   }

   public static EnumEntries getEntries() {
      return $ENTRIES;
   }

   public final String getValue() {
      return this.value;
   }
}
