package com.blueair.core.model;

import java.util.Calendar;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001a\b\u0086\u0081\u0002\u0018\u0000 \u001f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u001fB1\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\u0019\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\fR\u0011\u0010\u001b\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\fj\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018¨\u0006 "},
   d2 = {"Lcom/blueair/core/model/DayOfWeek;", "", "compareValue", "", "ablValue", "blueValue", "", "monFirstOrder", "satFirstOrder", "<init>", "(Ljava/lang/String;IIILjava/lang/String;II)V", "getCompareValue", "()I", "getAblValue", "getBlueValue", "()Ljava/lang/String;", "getMonFirstOrder", "getSatFirstOrder", "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT", "dbValue", "getDbValue", "weekDayCompareValue", "getWeekDayCompareValue", "plusDays", "offset", "Companion", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public enum DayOfWeek {
   private static final EnumEntries $ENTRIES;
   private static final DayOfWeek[] $VALUES;
   public static final Companion Companion;
   FRI,
   MON,
   SAT,
   SUN,
   THU,
   TUE,
   WED;

   private static final DayOfWeek firstDayOfWeek;
   private static final DayOfWeek[] values;
   private final int ablValue;
   private final String blueValue;
   private final int compareValue;
   private final int monFirstOrder;
   private final int satFirstOrder;

   // $FF: synthetic method
   private static final DayOfWeek[] $values() {
      return new DayOfWeek[]{SUN, MON, TUE, WED, THU, FRI, SAT};
   }

   static {
      DayOfWeek var1 = new DayOfWeek("SUN", 0, 0, 1, "SUN", 6, 1);
      SUN = var1;
      DayOfWeek var3 = new DayOfWeek("MON", 1, 1, 2, "MON", 0, 2);
      MON = var3;
      TUE = new DayOfWeek("TUE", 2, 2, 3, "TUE", 1, 3);
      WED = new DayOfWeek("WED", 3, 3, 4, "WED", 2, 4);
      THU = new DayOfWeek("THU", 4, 4, 5, "THU", 3, 5);
      FRI = new DayOfWeek("FRI", 5, 5, 6, "FRI", 4, 6);
      DayOfWeek var2 = new DayOfWeek("SAT", 6, 6, 7, "SAT", 5, 0);
      SAT = var2;
      DayOfWeek[] var4 = $values();
      $VALUES = var4;
      $ENTRIES = EnumEntriesKt.enumEntries(var4);
      Companion = new Companion((DefaultConstructorMarker)null);
      int var0 = Calendar.getInstance().getFirstDayOfWeek();
      if (var0 != 1) {
         if (var0 != 2) {
            var1 = var2;
         } else {
            var1 = var3;
         }
      }

      firstDayOfWeek = var1;
      values = values();
   }

   private DayOfWeek(int var3, int var4, String var5, int var6, int var7) {
      this.compareValue = var3;
      this.ablValue = var4;
      this.blueValue = var5;
      this.monFirstOrder = var6;
      this.satFirstOrder = var7;
   }

   public static EnumEntries getEntries() {
      return $ENTRIES;
   }

   public final int getAblValue() {
      return this.ablValue;
   }

   public final String getBlueValue() {
      return this.blueValue;
   }

   public final int getCompareValue() {
      return this.compareValue;
   }

   public final int getDbValue() {
      return this.ablValue;
   }

   public final int getMonFirstOrder() {
      return this.monFirstOrder;
   }

   public final int getSatFirstOrder() {
      return this.satFirstOrder;
   }

   public final int getWeekDayCompareValue() {
      DayOfWeek var2 = firstDayOfWeek;
      int var1 = DayOfWeek.WhenMappings.$EnumSwitchMapping$0[var2.ordinal()];
      if (var1 != 1) {
         return var1 != 2 ? this.satFirstOrder : this.monFirstOrder;
      } else {
         return this.compareValue;
      }
   }

   public final DayOfWeek plusDays(int var1) {
      byte var2 = 7;
      if (var1 <= 0) {
         if (var1 >= 0) {
            return this;
         }

         var1 = var1 % 7 + 7;
      }

      var1 = (this.ablValue + var1) % 7;
      if (var1 == 0) {
         var1 = var2;
      }

      DayOfWeek var3 = Companion.getByAblValue(var1);
      Intrinsics.checkNotNull(var3);
      return var3;
   }

   @Metadata(
      d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\rJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\rJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\n¨\u0006\u0011"},
      d2 = {"Lcom/blueair/core/model/DayOfWeek$Companion;", "", "<init>", "()V", "firstDayOfWeek", "Lcom/blueair/core/model/DayOfWeek;", "getFirstDayOfWeek", "()Lcom/blueair/core/model/DayOfWeek;", "values", "", "[Lcom/blueair/core/model/DayOfWeek;", "getByDBValue", "value", "", "getByAblValue", "getByBlueValue", "", "core_otherRelease"},
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

      public final DayOfWeek getByAblValue(int var1) {
         return this.getByDBValue(var1);
      }

      public final DayOfWeek getByBlueValue(String var1) {
         Intrinsics.checkNotNullParameter(var1, "value");

         for(DayOfWeek var4 : DayOfWeek.values) {
            if (Intrinsics.areEqual(var4.getBlueValue(), var1)) {
               return var4;
            }
         }

         return null;
      }

      public final DayOfWeek getByDBValue(int var1) {
         for(DayOfWeek var5 : DayOfWeek.values) {
            if (var5.getAblValue() == var1) {
               return var5;
            }
         }

         return null;
      }

      public final DayOfWeek getFirstDayOfWeek() {
         return DayOfWeek.firstDayOfWeek;
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
         int[] var0 = new int[DayOfWeek.values().length];

         try {
            var0[DayOfWeek.SUN.ordinal()] = 1;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[DayOfWeek.MON.ordinal()] = 2;
         } catch (NoSuchFieldError var2) {
         }

         $EnumSwitchMapping$0 = var0;
      }
   }
}
