package com.blueair.core.util;

import com.blueair.core.model.Interval;
import com.facebook.internal.security.CertificateUtil;
import com.foobot.liblabclient.core.WsDefinition;
import com.gigya.android.sdk.GigyaDefinitions;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.mapbox.common.HttpHeaders;
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

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u000b2\b\b\u0002\u0010 \u001a\u00020\u0010J\u000e\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#J\u0018\u0010$\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\u000b2\b\b\u0002\u0010&\u001a\u00020\u0005J\u0018\u0010'\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u000b2\b\b\u0002\u0010&\u001a\u00020\u0005J\u0016\u0010(\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020\u000bJ\u0016\u0010*\u001a\u00020+2\u0006\u0010%\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020\u000bJ\u000e\u0010,\u001a\u00020+2\u0006\u0010%\u001a\u00020\u000bJ\u0018\u0010-\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u000b2\b\b\u0002\u0010.\u001a\u00020\u0010J\u0018\u0010/\u001a\u00020\u000b2\u0006\u00100\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020\u0010H\u0002J\u000e\u00101\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\u000bJ\u0016\u00102\u001a\u00020+2\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u000204R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\n\u001a\u00020\u000bXD¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bXD¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bXD¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\u0015\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0012R\u0011\u0010\u0017\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0012R\u0011\u0010\u0019\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0012R\u0011\u0010\u001b\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0012¨\u00066"}, d2 = {"Lcom/blueair/core/util/TimeUtils;", "", "<init>", "()V", "utcTimezone", "Ljava/util/TimeZone;", "getUtcTimezone", "()Ljava/util/TimeZone;", "utcTimezone$delegate", "Lkotlin/Lazy;", "SCHEME", "", "SCHEME_BREEZOMETER", "HOUR_MINUTES_SCHEME", "SCHEDULE_SCHEME", "UTC_FORMATTER", "Ljava/text/SimpleDateFormat;", "getUTC_FORMATTER", "()Ljava/text/SimpleDateFormat;", "DATE_FORMAT_BREEZOMETER", "getDATE_FORMAT_BREEZOMETER", "DATE_FORMAT_WY", "getDATE_FORMAT_WY", "BLUE_CLOUD_SCHEDULE_UTC_FORMATTER", "getBLUE_CLOUD_SCHEDULE_UTC_FORMATTER", "BLUE_CLOUD_SCHEDULE_DEFAULT_FORMATTER", "getBLUE_CLOUD_SCHEDULE_DEFAULT_FORMATTER", "HOUR_MINUTE_DEFAULT_FORMATTER", "getHOUR_MINUTE_DEFAULT_FORMATTER", "unixTimeFromBreezometerDate", "", "date", "dateFormatterBreezo", "getIntervalStartTimestamp", "interval", "Lcom/blueair/core/model/Interval;", "convertUTCTimeToLocalTime", "time", "timeZone", "convertUTCDateToLocalTime", "convertLocalTimeToUTC", "timezone", "getLocalToUTCDateOffset", "", "getUTCtoLocalDateOffset", "convertLocalDateToUTC", "formatter", "getHourAndMinuteFormat", "formattedDate", "convert24HourTo12Hour", "getDayOffset", "start", "Ljava/util/Calendar;", "end", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: TimeUtils.kt */
public final class TimeUtils {
    private static final String HOUR_MINUTES_SCHEME = "HH:mm";
    public static final TimeUtils INSTANCE = new TimeUtils();
    private static final String SCHEDULE_SCHEME = "yyyy-MM-dd'T'kk:mm";
    private static final String SCHEME = "yyyy-MM-dd kk:mm:ss Z";
    private static final String SCHEME_BREEZOMETER = "yyyy-MM-dd'T'kk:mm:ss";
    private static final Lazy utcTimezone$delegate = LazyKt.lazy(new TimeUtils$$ExternalSyntheticLambda0());

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: TimeUtils.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                com.blueair.core.model.Interval[] r0 = com.blueair.core.model.Interval.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.blueair.core.model.Interval r1 = com.blueair.core.model.Interval.H24     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.blueair.core.model.Interval r1 = com.blueair.core.model.Interval.DAY     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.blueair.core.model.Interval r1 = com.blueair.core.model.Interval.WEEK     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.core.util.TimeUtils.WhenMappings.<clinit>():void");
        }
    }

    private TimeUtils() {
    }

    private final TimeZone getUtcTimezone() {
        Object value = utcTimezone$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (TimeZone) value;
    }

    /* access modifiers changed from: private */
    public static final TimeZone utcTimezone_delegate$lambda$0() {
        return TimeZone.getTimeZone("UTC");
    }

    public final SimpleDateFormat getUTC_FORMATTER() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(SCHEME);
        simpleDateFormat.setTimeZone(getUtcTimezone());
        return simpleDateFormat;
    }

    public final SimpleDateFormat getDATE_FORMAT_BREEZOMETER() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(SCHEME_BREEZOMETER);
        simpleDateFormat.setTimeZone(getUtcTimezone());
        return simpleDateFormat;
    }

    public final SimpleDateFormat getDATE_FORMAT_WY() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        simpleDateFormat.setTimeZone(getUtcTimezone());
        return simpleDateFormat;
    }

    public final SimpleDateFormat getBLUE_CLOUD_SCHEDULE_UTC_FORMATTER() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(SCHEDULE_SCHEME);
        simpleDateFormat.setTimeZone(getUtcTimezone());
        return simpleDateFormat;
    }

    public final SimpleDateFormat getBLUE_CLOUD_SCHEDULE_DEFAULT_FORMATTER() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(SCHEDULE_SCHEME);
        simpleDateFormat.setTimeZone(TimeZone.getDefault());
        return simpleDateFormat;
    }

    public final SimpleDateFormat getHOUR_MINUTE_DEFAULT_FORMATTER() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(HOUR_MINUTES_SCHEME);
        simpleDateFormat.setTimeZone(TimeZone.getDefault());
        return simpleDateFormat;
    }

    public static /* synthetic */ long unixTimeFromBreezometerDate$default(TimeUtils timeUtils, String str, SimpleDateFormat simpleDateFormat, int i, Object obj) {
        if ((i & 2) != 0) {
            simpleDateFormat = timeUtils.getDATE_FORMAT_BREEZOMETER();
        }
        return timeUtils.unixTimeFromBreezometerDate(str, simpleDateFormat);
    }

    public final long unixTimeFromBreezometerDate(String str, SimpleDateFormat simpleDateFormat) {
        Intrinsics.checkNotNullParameter(str, HttpHeaders.DATE);
        Intrinsics.checkNotNullParameter(simpleDateFormat, "dateFormatterBreezo");
        try {
            return simpleDateFormat.parse(str).getTime();
        } catch (ParseException e) {
            Timber.Forest forest = Timber.Forest;
            forest.e("unixTimeFromDate failed " + e, new Object[0]);
            return 0;
        }
    }

    public final long getIntervalStartTimestamp(Interval interval) {
        Intrinsics.checkNotNullParameter(interval, WsDefinition.INTERVAL);
        long currentTimeMillis = System.currentTimeMillis();
        int i = WhenMappings.$EnumSwitchMapping$0[interval.ordinal()];
        if (i == 1) {
            return currentTimeMillis - TimeUnit.DAYS.toMillis(1);
        }
        if (i == 2) {
            Calendar instance = Calendar.getInstance();
            instance.add(5, -1);
            return instance.getTimeInMillis();
        } else if (i != 3) {
            return currentTimeMillis - TimeUnit.DAYS.toMillis(30);
        } else {
            return currentTimeMillis - TimeUnit.DAYS.toMillis(7);
        }
    }

    public static /* synthetic */ String convertUTCTimeToLocalTime$default(TimeUtils timeUtils, String str, TimeZone timeZone, int i, Object obj) {
        if ((i & 2) != 0) {
            timeZone = TimeZone.getDefault();
            Intrinsics.checkNotNullExpressionValue(timeZone, "getDefault(...)");
        }
        return timeUtils.convertUTCTimeToLocalTime(str, timeZone);
    }

    public final String convertUTCTimeToLocalTime(String str, TimeZone timeZone) {
        Intrinsics.checkNotNullParameter(str, "time");
        Intrinsics.checkNotNullParameter(timeZone, RemoteConfigConstants.RequestFieldKey.TIME_ZONE);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
        simpleDateFormat.setTimeZone(timeZone);
        Calendar instance = Calendar.getInstance();
        List split$default = StringsKt.split$default((CharSequence) str, new String[]{CertificateUtil.DELIMITER}, false, 0, 6, (Object) null);
        instance.setTimeZone(INSTANCE.getUtcTimezone());
        instance.set(11, Integer.parseInt((String) CollectionsKt.first(split$default)));
        instance.set(12, Integer.parseInt((String) CollectionsKt.last(split$default)));
        String format = simpleDateFormat.format(instance.getTime());
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    public static /* synthetic */ String convertUTCDateToLocalTime$default(TimeUtils timeUtils, String str, TimeZone timeZone, int i, Object obj) {
        if ((i & 2) != 0) {
            timeZone = TimeZone.getDefault();
            Intrinsics.checkNotNullExpressionValue(timeZone, "getDefault(...)");
        }
        return timeUtils.convertUTCDateToLocalTime(str, timeZone);
    }

    public final String convertUTCDateToLocalTime(String str, TimeZone timeZone) {
        Intrinsics.checkNotNullParameter(str, HttpHeaders.DATE);
        Intrinsics.checkNotNullParameter(timeZone, RemoteConfigConstants.RequestFieldKey.TIME_ZONE);
        SimpleDateFormat blue_cloud_schedule_utc_formatter = getBLUE_CLOUD_SCHEDULE_UTC_FORMATTER();
        Date parse = blue_cloud_schedule_utc_formatter.parse(str);
        blue_cloud_schedule_utc_formatter.setTimeZone(timeZone);
        String format = blue_cloud_schedule_utc_formatter.format(parse);
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return getHourAndMinuteFormat(format, getBLUE_CLOUD_SCHEDULE_DEFAULT_FORMATTER());
    }

    public final String convertLocalTimeToUTC(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "time");
        Intrinsics.checkNotNullParameter(str2, GigyaDefinitions.AccountProfileExtraFields.TIMEZONE);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
        simpleDateFormat.setTimeZone(getUtcTimezone());
        Calendar instance = Calendar.getInstance(TimeZone.getTimeZone(str2));
        List split$default = StringsKt.split$default((CharSequence) str, new String[]{CertificateUtil.DELIMITER}, false, 0, 6, (Object) null);
        instance.set(11, Integer.parseInt((String) CollectionsKt.first(split$default)));
        instance.set(12, Integer.parseInt((String) CollectionsKt.last(split$default)));
        String format = simpleDateFormat.format(instance.getTime());
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    public final int getLocalToUTCDateOffset(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "time");
        Intrinsics.checkNotNullParameter(str2, GigyaDefinitions.AccountProfileExtraFields.TIMEZONE);
        Calendar instance = Calendar.getInstance(TimeZone.getTimeZone(str2));
        List split$default = StringsKt.split$default((CharSequence) str, new String[]{CertificateUtil.DELIMITER}, false, 0, 6, (Object) null);
        instance.set(11, Integer.parseInt((String) CollectionsKt.first(split$default)));
        instance.set(12, Integer.parseInt((String) CollectionsKt.last(split$default)));
        int i = instance.get(7);
        instance.setTimeZone(INSTANCE.getUtcTimezone());
        return instance.get(7) - i;
    }

    public final int getUTCtoLocalDateOffset(String str) {
        Intrinsics.checkNotNullParameter(str, "time");
        Calendar instance = Calendar.getInstance(getUtcTimezone());
        List split$default = StringsKt.split$default((CharSequence) str, new String[]{CertificateUtil.DELIMITER}, false, 0, 6, (Object) null);
        instance.set(11, Integer.parseInt((String) CollectionsKt.first(split$default)));
        instance.set(12, Integer.parseInt((String) CollectionsKt.last(split$default)));
        int i = instance.get(7);
        instance.setTimeZone(TimeZone.getDefault());
        return instance.get(7) - i;
    }

    public static /* synthetic */ String convertLocalDateToUTC$default(TimeUtils timeUtils, String str, SimpleDateFormat simpleDateFormat, int i, Object obj) {
        if ((i & 2) != 0) {
            simpleDateFormat = timeUtils.getBLUE_CLOUD_SCHEDULE_DEFAULT_FORMATTER();
        }
        return timeUtils.convertLocalDateToUTC(str, simpleDateFormat);
    }

    public final String convertLocalDateToUTC(String str, SimpleDateFormat simpleDateFormat) {
        Intrinsics.checkNotNullParameter(str, HttpHeaders.DATE);
        Intrinsics.checkNotNullParameter(simpleDateFormat, "formatter");
        Date parse = simpleDateFormat.parse(str);
        simpleDateFormat.setTimeZone(getUtcTimezone());
        String format = simpleDateFormat.format(parse);
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return getHourAndMinuteFormat(format, getBLUE_CLOUD_SCHEDULE_DEFAULT_FORMATTER());
    }

    private final String getHourAndMinuteFormat(String str, SimpleDateFormat simpleDateFormat) {
        String format = getHOUR_MINUTE_DEFAULT_FORMATTER().format(simpleDateFormat.parse(str));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    public final String convert24HourTo12Hour(String str) {
        Intrinsics.checkNotNullParameter(str, "time");
        try {
            List split$default = StringsKt.split$default((CharSequence) str, new String[]{CertificateUtil.DELIMITER}, false, 0, 6, (Object) null);
            int parseInt = Integer.parseInt((String) CollectionsKt.first(split$default));
            int parseInt2 = Integer.parseInt((String) CollectionsKt.last(split$default));
            if (parseInt > 12) {
                parseInt -= 12;
            }
            String format = String.format("%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(parseInt), Integer.valueOf(parseInt2)}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            return format;
        } catch (Throwable th) {
            Timber.Forest.e(th, "failed to convert 24Hour to 12Hour: " + str, new Object[0]);
            return str;
        }
    }

    public final int getDayOffset(Calendar calendar, Calendar calendar2) {
        Intrinsics.checkNotNullParameter(calendar, WsDefinition.START);
        Intrinsics.checkNotNullParameter(calendar2, WsDefinition.END);
        Calendar.getInstance().set(5, 1);
        Calendar.getInstance();
        int i = calendar.get(1);
        int i2 = calendar2.get(1);
        int i3 = calendar.get(6);
        int i4 = calendar2.get(6);
        if (i == i2) {
            return i4 - i3;
        }
        int timeInMillis = (int) ((calendar2.getTimeInMillis() - calendar.getTimeInMillis()) / ((long) 86400000));
        calendar.add(5, timeInMillis);
        return calendar.get(1) == i2 ? (i4 - calendar.get(6)) + timeInMillis : timeInMillis + 1;
    }
}
