package com.blueair.core.util;

import com.blueair.core.model.Interval;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u000b2\b\b\u0002\u0010 \u001a\u00020\u0010J\u000e\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#J\u0018\u0010$\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\u000b2\b\b\u0002\u0010&\u001a\u00020\u0005J\u0018\u0010'\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u000b2\b\b\u0002\u0010&\u001a\u00020\u0005J\u0016\u0010(\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020\u000bJ\u0016\u0010*\u001a\u00020+2\u0006\u0010%\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020\u000bJ\u000e\u0010,\u001a\u00020+2\u0006\u0010%\u001a\u00020\u000bJ\u0018\u0010-\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u000b2\b\b\u0002\u0010.\u001a\u00020\u0010J\u0018\u0010/\u001a\u00020\u000b2\u0006\u00100\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020\u0010H\u0002J\u000e\u00101\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\u000bJ\u0016\u00102\u001a\u00020+2\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u000204R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082D¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\u0015\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0012R\u0011\u0010\u0017\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0012R\u0011\u0010\u0019\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0012R\u0011\u0010\u001b\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0012¨\u00066"},
   d2 = {"Lcom/blueair/core/util/TimeUtils;", "", "<init>", "()V", "utcTimezone", "Ljava/util/TimeZone;", "getUtcTimezone", "()Ljava/util/TimeZone;", "utcTimezone$delegate", "Lkotlin/Lazy;", "SCHEME", "", "SCHEME_BREEZOMETER", "HOUR_MINUTES_SCHEME", "SCHEDULE_SCHEME", "UTC_FORMATTER", "Ljava/text/SimpleDateFormat;", "getUTC_FORMATTER", "()Ljava/text/SimpleDateFormat;", "DATE_FORMAT_BREEZOMETER", "getDATE_FORMAT_BREEZOMETER", "DATE_FORMAT_WY", "getDATE_FORMAT_WY", "BLUE_CLOUD_SCHEDULE_UTC_FORMATTER", "getBLUE_CLOUD_SCHEDULE_UTC_FORMATTER", "BLUE_CLOUD_SCHEDULE_DEFAULT_FORMATTER", "getBLUE_CLOUD_SCHEDULE_DEFAULT_FORMATTER", "HOUR_MINUTE_DEFAULT_FORMATTER", "getHOUR_MINUTE_DEFAULT_FORMATTER", "unixTimeFromBreezometerDate", "", "date", "dateFormatterBreezo", "getIntervalStartTimestamp", "interval", "Lcom/blueair/core/model/Interval;", "convertUTCTimeToLocalTime", "time", "timeZone", "convertUTCDateToLocalTime", "convertLocalTimeToUTC", "timezone", "getLocalToUTCDateOffset", "", "getUTCtoLocalDateOffset", "convertLocalDateToUTC", "formatter", "getHourAndMinuteFormat", "formattedDate", "convert24HourTo12Hour", "getDayOffset", "start", "Ljava/util/Calendar;", "end", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class TimeUtils {
   private static final String HOUR_MINUTES_SCHEME = "HH:mm";
   public static final TimeUtils INSTANCE = new TimeUtils();
   private static final String SCHEDULE_SCHEME = "yyyy-MM-dd'T'kk:mm";
   private static final String SCHEME = "yyyy-MM-dd kk:mm:ss Z";
   private static final String SCHEME_BREEZOMETER = "yyyy-MM-dd'T'kk:mm:ss";
   private static final Lazy utcTimezone$delegate = LazyKt.lazy(new TimeUtils$$ExternalSyntheticLambda0());

   // $FF: synthetic method
   public static TimeZone $r8$lambda$SVeGXmi4O9zOZ5RG6AdV91yW0QQ() {
      return utcTimezone_delegate$lambda$0();
   }

   private TimeUtils() {
   }

   // $FF: synthetic method
   public static String convertLocalDateToUTC$default(TimeUtils var0, String var1, SimpleDateFormat var2, int var3, Object var4) {
      if ((var3 & 2) != 0) {
         var2 = var0.getBLUE_CLOUD_SCHEDULE_DEFAULT_FORMATTER();
      }

      return var0.convertLocalDateToUTC(var1, var2);
   }

   // $FF: synthetic method
   public static String convertUTCDateToLocalTime$default(TimeUtils var0, String var1, TimeZone var2, int var3, Object var4) {
      if ((var3 & 2) != 0) {
         var2 = TimeZone.getDefault();
         Intrinsics.checkNotNullExpressionValue(var2, "getDefault(...)");
      }

      return var0.convertUTCDateToLocalTime(var1, var2);
   }

   // $FF: synthetic method
   public static String convertUTCTimeToLocalTime$default(TimeUtils var0, String var1, TimeZone var2, int var3, Object var4) {
      if ((var3 & 2) != 0) {
         var2 = TimeZone.getDefault();
         Intrinsics.checkNotNullExpressionValue(var2, "getDefault(...)");
      }

      return var0.convertUTCTimeToLocalTime(var1, var2);
   }

   private final String getHourAndMinuteFormat(String var1, SimpleDateFormat var2) {
      Date var3 = var2.parse(var1);
      String var4 = this.getHOUR_MINUTE_DEFAULT_FORMATTER().format(var3);
      Intrinsics.checkNotNullExpressionValue(var4, "format(...)");
      return var4;
   }

   private final TimeZone getUtcTimezone() {
      Object var1 = utcTimezone$delegate.getValue();
      Intrinsics.checkNotNullExpressionValue(var1, "getValue(...)");
      return (TimeZone)var1;
   }

   // $FF: synthetic method
   public static long unixTimeFromBreezometerDate$default(TimeUtils var0, String var1, SimpleDateFormat var2, int var3, Object var4) {
      if ((var3 & 2) != 0) {
         var2 = var0.getDATE_FORMAT_BREEZOMETER();
      }

      return var0.unixTimeFromBreezometerDate(var1, var2);
   }

   private static final TimeZone utcTimezone_delegate$lambda$0() {
      return TimeZone.getTimeZone("UTC");
   }

   public final String convert24HourTo12Hour(String var1) {
      Intrinsics.checkNotNullParameter(var1, "time");

      Throwable var10000;
      label80: {
         int var3;
         int var4;
         try {
            List var5 = StringsKt.split$default((CharSequence)var1, new String[]{":"}, false, 0, 6, (Object)null);
            var3 = Integer.parseInt((String)CollectionsKt.first(var5));
            var4 = Integer.parseInt((String)CollectionsKt.last(var5));
         } catch (Throwable var13) {
            var10000 = var13;
            boolean var10001 = false;
            break label80;
         }

         int var2 = var3;
         if (var3 > 12) {
            var2 = var3 - 12;
         }

         label71:
         try {
            String var15 = String.format("%02d:%02d", Arrays.copyOf(new Object[]{var2, var4}, 2));
            Intrinsics.checkNotNullExpressionValue(var15, "format(...)");
            return var15;
         } catch (Throwable var12) {
            var10000 = var12;
            boolean var16 = false;
            break label71;
         }
      }

      Throwable var14 = var10000;
      Timber.Forest var7 = Timber.Forest;
      StringBuilder var6 = new StringBuilder("failed to convert 24Hour to 12Hour: ");
      var6.append(var1);
      var7.e(var14, var6.toString(), new Object[0]);
      return var1;
   }

   public final String convertLocalDateToUTC(String var1, SimpleDateFormat var2) {
      Intrinsics.checkNotNullParameter(var1, "date");
      Intrinsics.checkNotNullParameter(var2, "formatter");
      Date var3 = var2.parse(var1);
      var2.setTimeZone(this.getUtcTimezone());
      String var4 = var2.format(var3);
      Intrinsics.checkNotNullExpressionValue(var4, "format(...)");
      return this.getHourAndMinuteFormat(var4, this.getBLUE_CLOUD_SCHEDULE_DEFAULT_FORMATTER());
   }

   public final String convertLocalTimeToUTC(String var1, String var2) {
      Intrinsics.checkNotNullParameter(var1, "time");
      Intrinsics.checkNotNullParameter(var2, "timezone");
      SimpleDateFormat var3 = new SimpleDateFormat("HH:mm");
      var3.setTimeZone(this.getUtcTimezone());
      Calendar var6 = Calendar.getInstance(TimeZone.getTimeZone(var2));
      List var4 = StringsKt.split$default((CharSequence)var1, new String[]{":"}, false, 0, 6, (Object)null);
      var6.set(11, Integer.parseInt((String)CollectionsKt.first(var4)));
      var6.set(12, Integer.parseInt((String)CollectionsKt.last(var4)));
      String var5 = var3.format(var6.getTime());
      Intrinsics.checkNotNullExpressionValue(var5, "format(...)");
      return var5;
   }

   public final String convertUTCDateToLocalTime(String var1, TimeZone var2) {
      Intrinsics.checkNotNullParameter(var1, "date");
      Intrinsics.checkNotNullParameter(var2, "timeZone");
      SimpleDateFormat var3 = this.getBLUE_CLOUD_SCHEDULE_UTC_FORMATTER();
      Date var4 = var3.parse(var1);
      var3.setTimeZone(var2);
      String var5 = var3.format(var4);
      Intrinsics.checkNotNullExpressionValue(var5, "format(...)");
      return this.getHourAndMinuteFormat(var5, this.getBLUE_CLOUD_SCHEDULE_DEFAULT_FORMATTER());
   }

   public final String convertUTCTimeToLocalTime(String var1, TimeZone var2) {
      Intrinsics.checkNotNullParameter(var1, "time");
      Intrinsics.checkNotNullParameter(var2, "timeZone");
      SimpleDateFormat var3 = new SimpleDateFormat("HH:mm");
      var3.setTimeZone(var2);
      Calendar var6 = Calendar.getInstance();
      List var4 = StringsKt.split$default((CharSequence)var1, new String[]{":"}, false, 0, 6, (Object)null);
      var6.setTimeZone(INSTANCE.getUtcTimezone());
      var6.set(11, Integer.parseInt((String)CollectionsKt.first(var4)));
      var6.set(12, Integer.parseInt((String)CollectionsKt.last(var4)));
      String var5 = var3.format(var6.getTime());
      Intrinsics.checkNotNullExpressionValue(var5, "format(...)");
      return var5;
   }

   public final SimpleDateFormat getBLUE_CLOUD_SCHEDULE_DEFAULT_FORMATTER() {
      SimpleDateFormat var1 = new SimpleDateFormat(SCHEDULE_SCHEME);
      var1.setTimeZone(TimeZone.getDefault());
      return var1;
   }

   public final SimpleDateFormat getBLUE_CLOUD_SCHEDULE_UTC_FORMATTER() {
      SimpleDateFormat var1 = new SimpleDateFormat(SCHEDULE_SCHEME);
      var1.setTimeZone(this.getUtcTimezone());
      return var1;
   }

   public final SimpleDateFormat getDATE_FORMAT_BREEZOMETER() {
      SimpleDateFormat var1 = new SimpleDateFormat(SCHEME_BREEZOMETER);
      var1.setTimeZone(this.getUtcTimezone());
      return var1;
   }

   public final SimpleDateFormat getDATE_FORMAT_WY() {
      SimpleDateFormat var1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
      var1.setTimeZone(this.getUtcTimezone());
      return var1;
   }

   public final int getDayOffset(Calendar var1, Calendar var2) {
      Intrinsics.checkNotNullParameter(var1, "start");
      Intrinsics.checkNotNullParameter(var2, "end");
      Calendar.getInstance().set(5, 1);
      Calendar.getInstance();
      int var5 = var1.get(1);
      int var4 = var2.get(1);
      int var6 = var1.get(6);
      int var3 = var2.get(6);
      if (var5 == var4) {
         return var3 - var6;
      } else {
         int var7 = (int)((var2.getTimeInMillis() - var1.getTimeInMillis()) / (long)86400000);
         var1.add(5, var7);
         var6 = var1.get(1);
         var5 = var1.get(6);
         return var6 == var4 ? var3 - var5 + var7 : var7 + 1;
      }
   }

   public final SimpleDateFormat getHOUR_MINUTE_DEFAULT_FORMATTER() {
      SimpleDateFormat var1 = new SimpleDateFormat(HOUR_MINUTES_SCHEME);
      var1.setTimeZone(TimeZone.getDefault());
      return var1;
   }

   public final long getIntervalStartTimestamp(Interval var1) {
      Intrinsics.checkNotNullParameter(var1, "interval");
      long var3 = System.currentTimeMillis();
      int var2 = TimeUtils.WhenMappings.$EnumSwitchMapping$0[var1.ordinal()];
      if (var2 != 1) {
         if (var2 != 2) {
            return var2 != 3 ? var3 - TimeUnit.DAYS.toMillis(30L) : var3 - TimeUnit.DAYS.toMillis(7L);
         } else {
            Calendar var5 = Calendar.getInstance();
            var5.add(5, -1);
            return var5.getTimeInMillis();
         }
      } else {
         return var3 - TimeUnit.DAYS.toMillis(1L);
      }
   }

   public final int getLocalToUTCDateOffset(String var1, String var2) {
      Intrinsics.checkNotNullParameter(var1, "time");
      Intrinsics.checkNotNullParameter(var2, "timezone");
      Calendar var5 = Calendar.getInstance(TimeZone.getTimeZone(var2));
      List var4 = StringsKt.split$default((CharSequence)var1, new String[]{":"}, false, 0, 6, (Object)null);
      var5.set(11, Integer.parseInt((String)CollectionsKt.first(var4)));
      var5.set(12, Integer.parseInt((String)CollectionsKt.last(var4)));
      int var3 = var5.get(7);
      var5.setTimeZone(INSTANCE.getUtcTimezone());
      return var5.get(7) - var3;
   }

   public final SimpleDateFormat getUTC_FORMATTER() {
      SimpleDateFormat var1 = new SimpleDateFormat(SCHEME);
      var1.setTimeZone(this.getUtcTimezone());
      return var1;
   }

   public final int getUTCtoLocalDateOffset(String var1) {
      Intrinsics.checkNotNullParameter(var1, "time");
      Calendar var3 = Calendar.getInstance(this.getUtcTimezone());
      List var4 = StringsKt.split$default((CharSequence)var1, new String[]{":"}, false, 0, 6, (Object)null);
      var3.set(11, Integer.parseInt((String)CollectionsKt.first(var4)));
      var3.set(12, Integer.parseInt((String)CollectionsKt.last(var4)));
      int var2 = var3.get(7);
      var3.setTimeZone(TimeZone.getDefault());
      return var3.get(7) - var2;
   }

   public final long unixTimeFromBreezometerDate(String var1, SimpleDateFormat var2) {
      Intrinsics.checkNotNullParameter(var1, "date");
      Intrinsics.checkNotNullParameter(var2, "dateFormatterBreezo");

      try {
         long var3 = var2.parse(var1).getTime();
         return var3;
      } catch (ParseException var6) {
         Timber.Forest var7 = Timber.Forest;
         StringBuilder var5 = new StringBuilder("unixTimeFromDate failed ");
         var5.append(var6);
         var7.e(var5.toString(), new Object[0]);
         return 0L;
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
         int[] var0 = new int[Interval.values().length];

         try {
            var0[Interval.H24.ordinal()] = 1;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[Interval.DAY.ordinal()] = 2;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[Interval.WEEK.ordinal()] = 3;
         } catch (NoSuchFieldError var2) {
         }

         $EnumSwitchMapping$0 = var0;
      }
   }
}
