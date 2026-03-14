package com.blueair.graph.utils;

import android.content.Context;
import android.text.format.DateFormat;
import com.blueair.viewcore.R;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001aH\u0007R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\u000b\u0010\u0007R\u001b\u0010\r\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\t\u001a\u0004\b\u000e\u0010\u0007R\u001b\u0010\u0010\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\t\u001a\u0004\b\u0011\u0010\u0007¨\u0006\u001b"},
   d2 = {"Lcom/blueair/graph/utils/GraphUtils;", "", "<init>", "()V", "timeFormatter24", "Ljava/text/SimpleDateFormat;", "getTimeFormatter24", "()Ljava/text/SimpleDateFormat;", "timeFormatter24$delegate", "Lkotlin/Lazy;", "timeFormatter12", "getTimeFormatter12", "timeFormatter12$delegate", "dateFormatter", "getDateFormatter", "dateFormatter$delegate", "dateFormatterMultiLine", "getDateFormatterMultiLine", "dateFormatterMultiLine$delegate", "getStringDate", "", "timeInMillis", "", "context", "Landroid/content/Context;", "multiLine", "", "graph_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class GraphUtils {
   public static final GraphUtils INSTANCE = new GraphUtils();
   private static final Lazy dateFormatter$delegate = LazyKt.lazy(new GraphUtils$$ExternalSyntheticLambda2());
   private static final Lazy dateFormatterMultiLine$delegate = LazyKt.lazy(new GraphUtils$$ExternalSyntheticLambda3());
   private static final Lazy timeFormatter12$delegate = LazyKt.lazy(new GraphUtils$$ExternalSyntheticLambda1());
   private static final Lazy timeFormatter24$delegate = LazyKt.lazy(new GraphUtils$$ExternalSyntheticLambda0());

   // $FF: synthetic method
   public static SimpleDateFormat $r8$lambda$CmmH86JLSJYPHYHnomz5KnwO5Zc() {
      return dateFormatter_delegate$lambda$2();
   }

   // $FF: synthetic method
   public static SimpleDateFormat $r8$lambda$GHy55EeklUaG3qN6_vG0O8NLrso/* $FF was: $r8$lambda$GHy55EeklUaG3qN6-vG0O8NLrso*/() {
      return timeFormatter24_delegate$lambda$0();
   }

   // $FF: synthetic method
   public static SimpleDateFormat $r8$lambda$L4twBR3FuaQGlMUAK7IcXgRdqQ0() {
      return timeFormatter12_delegate$lambda$1();
   }

   // $FF: synthetic method
   public static SimpleDateFormat $r8$lambda$vw0Qqg8PBGVMjKwddMgPL7Oy0uo() {
      return dateFormatterMultiLine_delegate$lambda$3();
   }

   private GraphUtils() {
   }

   private static final SimpleDateFormat dateFormatterMultiLine_delegate$lambda$3() {
      return new SimpleDateFormat("MMM dd\nHH:mm");
   }

   private static final SimpleDateFormat dateFormatter_delegate$lambda$2() {
      return new SimpleDateFormat("MMM dd HH:mm");
   }

   private final SimpleDateFormat getDateFormatter() {
      return (SimpleDateFormat)dateFormatter$delegate.getValue();
   }

   private final SimpleDateFormat getDateFormatterMultiLine() {
      return (SimpleDateFormat)dateFormatterMultiLine$delegate.getValue();
   }

   // $FF: synthetic method
   public static String getStringDate$default(GraphUtils var0, long var1, Context var3, boolean var4, int var5, Object var6) {
      if ((var5 & 4) != 0) {
         var4 = false;
      }

      return var0.getStringDate(var1, var3, var4);
   }

   private final SimpleDateFormat getTimeFormatter12() {
      return (SimpleDateFormat)timeFormatter12$delegate.getValue();
   }

   private final SimpleDateFormat getTimeFormatter24() {
      return (SimpleDateFormat)timeFormatter24$delegate.getValue();
   }

   private static final SimpleDateFormat timeFormatter12_delegate$lambda$1() {
      return new SimpleDateFormat("hh:mm a");
   }

   private static final SimpleDateFormat timeFormatter24_delegate$lambda$0() {
      return new SimpleDateFormat("HH:mm");
   }

   public final String getStringDate(long var1, Context var3, boolean var4) {
      Intrinsics.checkNotNullParameter(var3, "context");
      Calendar var7 = Calendar.getInstance();
      Calendar var6 = Calendar.getInstance();
      var6.setTimeInMillis(var1);
      Object var8 = var7.clone();
      Intrinsics.checkNotNull(var8, "null cannot be cast to non-null type java.util.Calendar");
      Calendar var13 = (Calendar)var8;
      var13.set(var6.get(1), var6.get(2), var6.get(5));
      int var5 = (int)((var7.getTimeInMillis() - var13.getTimeInMillis()) / 86400000L);
      SimpleDateFormat var11;
      if (DateFormat.is24HourFormat(var3)) {
         var11 = this.getTimeFormatter24();
      } else {
         var11 = this.getTimeFormatter12();
      }

      String var12;
      if (var4) {
         var12 = "\n";
      } else {
         var12 = " ";
      }

      if (var5 < 1) {
         StringBuilder var16 = new StringBuilder();
         var16.append(var3.getString(R.string.today));
         var16.append(var12);
         var16.append(var11.format(var1));
         return var16.toString();
      } else if (var5 == 1) {
         StringBuilder var15 = new StringBuilder();
         var15.append(var3.getString(R.string.yesterday));
         var15.append(var12);
         var15.append(var11.format(var1));
         return var15.toString();
      } else if (2 <= var5 && var5 < 7) {
         StringBuilder var14 = new StringBuilder();
         var14.append(var5);
         var14.append(' ');
         var14.append(var3.getString(R.string.days_ago));
         var14.append(var12);
         var14.append(var11.format(var1));
         return var14.toString();
      } else {
         SimpleDateFormat var9;
         if (var4) {
            var9 = this.getDateFormatterMultiLine();
         } else {
            var9 = this.getDateFormatter();
         }

         String var10 = var9.format(var1);
         Intrinsics.checkNotNullExpressionValue(var10, "format(...)");
         return var10;
      }
   }
}
