package com.blueair.core.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(
   d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\b"},
   d2 = {"Lcom/blueair/core/model/WaterLevel;", "", "<init>", "(Ljava/lang/String;I)V", "SHORTAGE", "NORMAL", "FULL", "Companion", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public enum WaterLevel {
   private static final EnumEntries $ENTRIES;
   private static final WaterLevel[] $VALUES;
   public static final Companion Companion;
   FULL,
   NORMAL,
   SHORTAGE;

   // $FF: synthetic method
   private static final WaterLevel[] $values() {
      return new WaterLevel[]{SHORTAGE, NORMAL, FULL};
   }

   static {
      WaterLevel[] var0 = $values();
      $VALUES = var0;
      $ENTRIES = EnumEntriesKt.enumEntries(var0);
      Companion = new Companion((DefaultConstructorMarker)null);
   }

   public static EnumEntries getEntries() {
      return $ENTRIES;
   }

   @Metadata(
      d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"},
      d2 = {"Lcom/blueair/core/model/WaterLevel$Companion;", "", "<init>", "()V", "fromValue", "Lcom/blueair/core/model/WaterLevel;", "value", "", "core_otherRelease"},
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

      public final WaterLevel fromValue(int var1) {
         if (var1 == 0) {
            return WaterLevel.SHORTAGE;
         } else {
            if (var1 != 1) {
               if (var1 == 2) {
                  return WaterLevel.FULL;
               }

               if (var1 != 25 && var1 != 50 && var1 != 75) {
                  if (var1 != 100) {
                     return WaterLevel.NORMAL;
                  }

                  return WaterLevel.FULL;
               }
            }

            return WaterLevel.NORMAL;
         }
      }
   }
}
