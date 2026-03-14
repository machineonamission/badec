package com.blueair.viewcore.extensions;

import android.content.Context;
import com.blueair.core.model.DayOfWeek;
import com.blueair.viewcore.R;
import java.util.Collection;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000,\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\n\u0010\u0000\u001a\u00020\u0005*\u00020\u0002\u001a\u0012\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\n\u0010\u0006\u001a\u00020\u0005*\u00020\u0002\u001a\u0012\u0010\u0007\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\n\u0010\u0007\u001a\u00020\u0005*\u00020\u0002\u001a\u0018\u0010\u0011\u001a\u00020\u0012*\u00020\n2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\t\u001a\u0018\u0010\u0014\u001a\u00020\u0012*\u00020\n2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\t\u001a\u0018\u0010\u0015\u001a\u00020\u0012*\u00020\n2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\t\u001a\u0018\u0010\u0016\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0004\"\u001b\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\t*\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f\"\u001b\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\t*\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\f\"\u001b\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\t*\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\f¨\u0006\u0017"},
   d2 = {"displayValueShort", "", "Lcom/blueair/core/model/DayOfWeek;", "context", "Landroid/content/Context;", "", "displayValueLong", "displayValueEveryLong", "everydaySet", "", "Lcom/blueair/core/model/DayOfWeek$Companion;", "getEverydaySet", "(Lcom/blueair/core/model/DayOfWeek$Companion;)Ljava/util/Set;", "weekdaySet", "getWeekdaySet", "weekendSet", "getWeekendSet", "isWeekdaysOnly", "", "values", "isWeekendOnly", "isEveryDay", "toString", "viewcore_otherRelease"},
   k = 2,
   mv = {2, 2, 0},
   xi = 48
)
public final class DayOfWeekExtensionKt {
   // $FF: synthetic method
   public static CharSequence $r8$lambda$zta9auwFijoy3elCInI_e9vHIG4/* $FF was: $r8$lambda$zta9auwFijoy3elCInI-e9vHIG4*/(Context var0, DayOfWeek var1) {
      return toString$lambda$0(var0, var1);
   }

   public static final int displayValueEveryLong(DayOfWeek var0) {
      Intrinsics.checkNotNullParameter(var0, "<this>");
      switch (DayOfWeekExtensionKt.WhenMappings.$EnumSwitchMapping$0[var0.ordinal()]) {
         case 1:
            return R.string.weekday_every_sunday_long;
         case 2:
            return R.string.weekday_every_monday_long;
         case 3:
            return R.string.weekday_every_tuesday_long;
         case 4:
            return R.string.weekday_every_wednesday_long;
         case 5:
            return R.string.weekday_every_thursday_long;
         case 6:
            return R.string.weekday_every_friday_long;
         case 7:
            return R.string.weekday_every_saturday_long;
         default:
            throw new NoWhenBranchMatchedException();
      }
   }

   public static final String displayValueEveryLong(DayOfWeek var0, Context var1) {
      Intrinsics.checkNotNullParameter(var0, "<this>");
      Intrinsics.checkNotNullParameter(var1, "context");
      String var2 = var1.getString(displayValueEveryLong(var0));
      Intrinsics.checkNotNullExpressionValue(var2, "getString(...)");
      return var2;
   }

   public static final int displayValueLong(DayOfWeek var0) {
      Intrinsics.checkNotNullParameter(var0, "<this>");
      switch (DayOfWeekExtensionKt.WhenMappings.$EnumSwitchMapping$0[var0.ordinal()]) {
         case 1:
            return R.string.weekday_sunday_long;
         case 2:
            return R.string.weekday_monday_long;
         case 3:
            return R.string.weekday_tuesday_long;
         case 4:
            return R.string.weekday_wednesday_long;
         case 5:
            return R.string.weekday_thursday_long;
         case 6:
            return R.string.weekday_friday_long;
         case 7:
            return R.string.weekday_saturday_long;
         default:
            throw new NoWhenBranchMatchedException();
      }
   }

   public static final String displayValueLong(DayOfWeek var0, Context var1) {
      Intrinsics.checkNotNullParameter(var0, "<this>");
      Intrinsics.checkNotNullParameter(var1, "context");
      String var2 = var1.getString(displayValueLong(var0));
      Intrinsics.checkNotNullExpressionValue(var2, "getString(...)");
      return var2;
   }

   public static final int displayValueShort(DayOfWeek var0) {
      Intrinsics.checkNotNullParameter(var0, "<this>");
      switch (DayOfWeekExtensionKt.WhenMappings.$EnumSwitchMapping$0[var0.ordinal()]) {
         case 1:
            return R.string.weekday_sunday_short;
         case 2:
            return R.string.weekday_monday_short;
         case 3:
            return R.string.weekday_tuesday_short;
         case 4:
            return R.string.weekday_wednesday_short;
         case 5:
            return R.string.weekday_thursday_short;
         case 6:
            return R.string.weekday_friday_short;
         case 7:
            return R.string.weekday_saturday_short;
         default:
            throw new NoWhenBranchMatchedException();
      }
   }

   public static final String displayValueShort(DayOfWeek var0, Context var1) {
      Intrinsics.checkNotNullParameter(var0, "<this>");
      Intrinsics.checkNotNullParameter(var1, "context");
      String var2 = var1.getString(displayValueShort(var0));
      Intrinsics.checkNotNullExpressionValue(var2, "getString(...)");
      return var2;
   }

   public static final Set getEverydaySet(DayOfWeek.Companion var0) {
      Intrinsics.checkNotNullParameter(var0, "<this>");
      return SetsKt.setOf(new DayOfWeek[]{DayOfWeek.SUN, DayOfWeek.MON, DayOfWeek.TUE, DayOfWeek.WED, DayOfWeek.THU, DayOfWeek.FRI, DayOfWeek.SAT});
   }

   public static final Set getWeekdaySet(DayOfWeek.Companion var0) {
      Intrinsics.checkNotNullParameter(var0, "<this>");
      return SetsKt.setOf(new DayOfWeek[]{DayOfWeek.MON, DayOfWeek.TUE, DayOfWeek.WED, DayOfWeek.THU, DayOfWeek.FRI});
   }

   public static final Set getWeekendSet(DayOfWeek.Companion var0) {
      Intrinsics.checkNotNullParameter(var0, "<this>");
      return SetsKt.setOf(new DayOfWeek[]{DayOfWeek.SAT, DayOfWeek.SUN});
   }

   public static final boolean isEveryDay(DayOfWeek.Companion var0, Set var1) {
      Intrinsics.checkNotNullParameter(var0, "<this>");
      Intrinsics.checkNotNullParameter(var1, "values");
      return ((Collection)var1).size() == 7 && var1.containsAll((Collection)getEverydaySet(var0));
   }

   public static final boolean isWeekdaysOnly(DayOfWeek.Companion var0, Set var1) {
      Intrinsics.checkNotNullParameter(var0, "<this>");
      Intrinsics.checkNotNullParameter(var1, "values");
      return ((Collection)var1).size() == 5 && var1.containsAll((Collection)getWeekdaySet(var0));
   }

   public static final boolean isWeekendOnly(DayOfWeek.Companion var0, Set var1) {
      Intrinsics.checkNotNullParameter(var0, "<this>");
      Intrinsics.checkNotNullParameter(var1, "values");
      return ((Collection)var1).size() == 2 && var1.containsAll((Collection)getWeekendSet(var0));
   }

   public static final String toString(Set var0, Context var1) {
      Intrinsics.checkNotNullParameter(var0, "<this>");
      Intrinsics.checkNotNullParameter(var1, "context");
      if (isWeekdaysOnly(DayOfWeek.Companion, var0)) {
         String var4 = var1.getString(R.string.weekdays);
         Intrinsics.checkNotNull(var4);
         return var4;
      } else if (isWeekendOnly(DayOfWeek.Companion, var0)) {
         String var3 = var1.getString(R.string.weekend);
         Intrinsics.checkNotNull(var3);
         return var3;
      } else if (isEveryDay(DayOfWeek.Companion, var0)) {
         String var2 = var1.getString(R.string.everyday);
         Intrinsics.checkNotNull(var2);
         return var2;
      } else {
         return CollectionsKt.joinToString$default((Iterable)var0, (CharSequence)", ", (CharSequence)null, (CharSequence)null, 0, (CharSequence)null, new DayOfWeekExtensionKt$$ExternalSyntheticLambda0(var1), 30, (Object)null);
      }
   }

   private static final CharSequence toString$lambda$0(Context var0, DayOfWeek var1) {
      Intrinsics.checkNotNullParameter(var1, "it");
      return (CharSequence)displayValueShort(var1, var0);
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
         } catch (NoSuchFieldError var8) {
         }

         try {
            var0[DayOfWeek.MON.ordinal()] = 2;
         } catch (NoSuchFieldError var7) {
         }

         try {
            var0[DayOfWeek.TUE.ordinal()] = 3;
         } catch (NoSuchFieldError var6) {
         }

         try {
            var0[DayOfWeek.WED.ordinal()] = 4;
         } catch (NoSuchFieldError var5) {
         }

         try {
            var0[DayOfWeek.THU.ordinal()] = 5;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[DayOfWeek.FRI.ordinal()] = 6;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[DayOfWeek.SAT.ordinal()] = 7;
         } catch (NoSuchFieldError var2) {
         }

         $EnumSwitchMapping$0 = var0;
      }
   }
}
