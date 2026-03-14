package com.blueair.core.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(
   d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0010B!\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0011"},
   d2 = {"Lcom/blueair/core/model/FilterLifeLevel;", "", "level", "", "minValue", "maxValue", "<init>", "(Ljava/lang/String;IIII)V", "getLevel", "()I", "getMinValue", "getMaxValue", "NORMAL", "SERIOUS", "GRAVE", "URGENT", "Companion", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public enum FilterLifeLevel {
   private static final EnumEntries $ENTRIES;
   private static final FilterLifeLevel[] $VALUES;
   public static final Companion Companion;
   GRAVE(1, 1, 5),
   NORMAL(3, 11, 100),
   SERIOUS(2, 6, 10),
   URGENT(0, 0, 0);

   private final int level;
   private final int maxValue;
   private final int minValue;

   // $FF: synthetic method
   private static final FilterLifeLevel[] $values() {
      return new FilterLifeLevel[]{NORMAL, SERIOUS, GRAVE, URGENT};
   }

   static {
      FilterLifeLevel[] var0 = $values();
      $VALUES = var0;
      $ENTRIES = EnumEntriesKt.enumEntries(var0);
      Companion = new Companion((DefaultConstructorMarker)null);
   }

   private FilterLifeLevel(int var3, int var4, int var5) {
      this.level = var3;
      this.minValue = var4;
      this.maxValue = var5;
   }

   public static EnumEntries getEntries() {
      return $ENTRIES;
   }

   public final int getLevel() {
      return this.level;
   }

   public final int getMaxValue() {
      return this.maxValue;
   }

   public final int getMinValue() {
      return this.minValue;
   }

   @Metadata(
      d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0007¨\u0006\n"},
      d2 = {"Lcom/blueair/core/model/FilterLifeLevel$Companion;", "", "<init>", "()V", "fromFliterLeftLife", "Lcom/blueair/core/model/FilterLifeLevel;", "leftLife", "", "fromLevel", "level", "core_otherRelease"},
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

      public final FilterLifeLevel fromFliterLeftLife(int var1) {
         for(FilterLifeLevel var4 : FilterLifeLevel.getEntries()) {
            int var2 = var4.getMinValue();
            if (var1 <= var4.getMaxValue() && var2 <= var1) {
               return var4;
            }
         }

         return FilterLifeLevel.NORMAL;
      }

      public final FilterLifeLevel fromLevel(int var1) {
         if (var1 == FilterLifeLevel.URGENT.getLevel()) {
            return FilterLifeLevel.URGENT;
         } else if (var1 == FilterLifeLevel.GRAVE.getLevel()) {
            return FilterLifeLevel.GRAVE;
         } else {
            return var1 == FilterLifeLevel.SERIOUS.getLevel() ? FilterLifeLevel.SERIOUS : FilterLifeLevel.NORMAL;
         }
      }
   }
}
