package com.blueair.core.util;

import android.content.Context;
import android.icu.text.TimeZoneNames;
import android.os.Build;
import com.blueair.core.R;
import com.gigya.android.sdk.GigyaDefinitions;
import java.util.Arrays;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0016\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u0007J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010¨\u0006\u0011"}, d2 = {"Lcom/blueair/core/util/TimezoneUtils;", "", "<init>", "()V", "getDisplayName", "", "context", "Landroid/content/Context;", "timezone", "Ljava/util/TimeZone;", "ensureValidTimezone", "getTimezoneList", "Lcom/blueair/core/util/TimezoneList;", "updateTimezoneList", "", "timezoneList", "Lcom/blueair/core/util/TimezoneNames;", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: TimezoneUtils.kt */
public final class TimezoneUtils {
    public static final TimezoneUtils INSTANCE = new TimezoneUtils();

    public final TimeZone ensureValidTimezone(Context context, TimeZone timeZone) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(timeZone, GigyaDefinitions.AccountProfileExtraFields.TIMEZONE);
        return timeZone;
    }

    private TimezoneUtils() {
    }

    public final String getDisplayName(Context context, TimeZone timeZone) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(timeZone, GigyaDefinitions.AccountProfileExtraFields.TIMEZONE);
        if (Build.VERSION.SDK_INT >= 24) {
            String string = context.getString(R.string.timezone_display_name);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            String format = String.format(string, Arrays.copyOf(new Object[]{TimeZoneNames.getInstance(Locale.getDefault()).getExemplarLocationName(timeZone.getID())}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            return format;
        }
        String displayName = timeZone.getDisplayName();
        Intrinsics.checkNotNullExpressionValue(displayName, "getDisplayName(...)");
        return displayName;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004b, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r5, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004f, code lost:
        throw r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x010a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x010b, code lost:
        kotlin.io.CloseableKt.closeFinally(r4, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x010e, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.blueair.core.util.TimezoneList getTimezoneList(android.content.Context r8) {
        /*
            r7 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String[] r0 = java.util.TimeZone.getAvailableIDs()
            java.lang.String r1 = "getAvailableIDs(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.lang.Object[] r0 = (java.lang.Object[]) r0
            java.util.List r0 = kotlin.collections.ArraysKt.asList((T[]) r0)
            r1 = 0
            r2 = 8192(0x2000, float:1.14794E-41)
            java.lang.String r3 = "timezones"
            java.io.FileInputStream r3 = r8.openFileInput(r3)     // Catch:{ all -> 0x0050 }
            java.lang.String r4 = "openFileInput(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)     // Catch:{ all -> 0x0050 }
            java.io.InputStream r3 = (java.io.InputStream) r3     // Catch:{ all -> 0x0050 }
            java.nio.charset.Charset r4 = kotlin.text.Charsets.UTF_8     // Catch:{ all -> 0x0050 }
            java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch:{ all -> 0x0050 }
            r5.<init>(r3, r4)     // Catch:{ all -> 0x0050 }
            java.io.Reader r5 = (java.io.Reader) r5     // Catch:{ all -> 0x0050 }
            boolean r3 = r5 instanceof java.io.BufferedReader     // Catch:{ all -> 0x0050 }
            if (r3 == 0) goto L_0x0034
            java.io.BufferedReader r5 = (java.io.BufferedReader) r5     // Catch:{ all -> 0x0050 }
            goto L_0x003a
        L_0x0034:
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ all -> 0x0050 }
            r3.<init>(r5, r2)     // Catch:{ all -> 0x0050 }
            r5 = r3
        L_0x003a:
            java.io.Closeable r5 = (java.io.Closeable) r5     // Catch:{ all -> 0x0050 }
            r3 = r5
            java.io.BufferedReader r3 = (java.io.BufferedReader) r3     // Catch:{ all -> 0x0049 }
            java.io.Reader r3 = (java.io.Reader) r3     // Catch:{ all -> 0x0049 }
            java.util.List r3 = kotlin.io.TextStreamsKt.readLines(r3)     // Catch:{ all -> 0x0049 }
            kotlin.io.CloseableKt.closeFinally(r5, r1)     // Catch:{ all -> 0x0050 }
            goto L_0x0083
        L_0x0049:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x004b }
        L_0x004b:
            r4 = move-exception
            kotlin.io.CloseableKt.closeFinally(r5, r3)     // Catch:{ all -> 0x0050 }
            throw r4     // Catch:{ all -> 0x0050 }
        L_0x0050:
            android.content.res.Resources r8 = r8.getResources()
            int r3 = com.blueair.core.R.raw.timezones
            java.io.InputStream r8 = r8.openRawResource(r3)
            java.lang.String r3 = "openRawResource(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r3)
            java.nio.charset.Charset r3 = kotlin.text.Charsets.UTF_8
            java.io.InputStreamReader r4 = new java.io.InputStreamReader
            r4.<init>(r8, r3)
            java.io.Reader r4 = (java.io.Reader) r4
            boolean r8 = r4 instanceof java.io.BufferedReader
            if (r8 == 0) goto L_0x006f
            java.io.BufferedReader r4 = (java.io.BufferedReader) r4
            goto L_0x0075
        L_0x006f:
            java.io.BufferedReader r8 = new java.io.BufferedReader
            r8.<init>(r4, r2)
            r4 = r8
        L_0x0075:
            java.io.Closeable r4 = (java.io.Closeable) r4
            r8 = r4
            java.io.BufferedReader r8 = (java.io.BufferedReader) r8     // Catch:{ all -> 0x0108 }
            java.io.Reader r8 = (java.io.Reader) r8     // Catch:{ all -> 0x0108 }
            java.util.List r3 = kotlin.io.TextStreamsKt.readLines(r8)     // Catch:{ all -> 0x0108 }
            kotlin.io.CloseableKt.closeFinally(r4, r1)
        L_0x0083:
            java.lang.String r8 = "0"
            r1 = 0
            if (r3 == 0) goto L_0x00d9
            r0 = 0
            java.lang.Object r4 = kotlin.collections.CollectionsKt.getOrNull(r3, r0)
            java.lang.String r4 = (java.lang.String) r4
            if (r4 == 0) goto L_0x0093
            r8 = r4
        L_0x0093:
            r4 = 1
            java.lang.Object r4 = kotlin.collections.CollectionsKt.getOrNull(r3, r4)
            java.lang.String r4 = (java.lang.String) r4
            if (r4 == 0) goto L_0x00a8
            java.lang.Long r4 = kotlin.text.StringsKt.toLongOrNull(r4)
            if (r4 == 0) goto L_0x00a8
            java.lang.Number r4 = (java.lang.Number) r4
            long r1 = r4.longValue()
        L_0x00a8:
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            r4 = 2
            java.util.List r3 = kotlin.collections.CollectionsKt.drop(r3, r4)
            timber.log.Timber$Forest r4 = timber.log.Timber.Forest
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "timezone list version: "
            r5.<init>(r6)
            r5.append(r8)
            java.lang.String r6 = ", time: "
            r5.append(r6)
            r5.append(r1)
            java.lang.String r6 = ", count: "
            r5.append(r6)
            int r6 = r3.size()
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r4.d(r5, r0)
            r0 = r3
        L_0x00d9:
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r3 = new java.util.ArrayList
            r4 = 10
            int r4 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r0, r4)
            r3.<init>(r4)
            java.util.Collection r3 = (java.util.Collection) r3
            java.util.Iterator r0 = r0.iterator()
        L_0x00ec:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L_0x0100
            java.lang.Object r4 = r0.next()
            java.lang.String r4 = (java.lang.String) r4
            java.util.TimeZone r4 = java.util.TimeZone.getTimeZone(r4)
            r3.add(r4)
            goto L_0x00ec
        L_0x0100:
            java.util.List r3 = (java.util.List) r3
            com.blueair.core.util.TimezoneList r0 = new com.blueair.core.util.TimezoneList
            r0.<init>(r8, r1, r3)
            return r0
        L_0x0108:
            r8 = move-exception
            throw r8     // Catch:{ all -> 0x010a }
        L_0x010a:
            r0 = move-exception
            kotlin.io.CloseableKt.closeFinally(r4, r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.core.util.TimezoneUtils.getTimezoneList(android.content.Context):com.blueair.core.util.TimezoneList");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00ac, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r1, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00b0, code lost:
        throw r7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void updateTimezoneList(android.content.Context r6, com.blueair.core.util.TimezoneNames r7) {
        /*
            r5 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "timezoneList"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.util.List r0 = r7.getTimezoneNames()
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x00bb
            timber.log.Timber$Forest r0 = timber.log.Timber.Forest
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "update timezone list:"
            r1.<init>(r2)
            java.lang.String r2 = r7.getVersion()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r2 = 0
            java.lang.Object[] r3 = new java.lang.Object[r2]
            r0.d(r1, r3)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = r7.getVersion()
            r0.append(r1)
            r1 = 10
            r0.append(r1)
            long r3 = java.lang.System.currentTimeMillis()
            r0.append(r3)
            java.lang.String r3 = "append(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)
            r0.append(r1)
            java.util.List r7 = r7.getTimezoneNames()
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.Iterator r7 = r7.iterator()
        L_0x005a:
            boolean r3 = r7.hasNext()
            if (r3 == 0) goto L_0x006d
            java.lang.Object r3 = r7.next()
            java.lang.String r3 = (java.lang.String) r3
            r0.append(r3)
            r0.append(r1)
            goto L_0x005a
        L_0x006d:
            java.lang.String r7 = r0.toString()
            java.lang.String r0 = "toString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r0)
            java.lang.String r0 = "timezones"
            java.io.FileOutputStream r6 = r6.openFileOutput(r0, r2)     // Catch:{ all -> 0x00b1 }
            java.lang.String r0 = "openFileOutput(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r0)     // Catch:{ all -> 0x00b1 }
            java.io.OutputStream r6 = (java.io.OutputStream) r6     // Catch:{ all -> 0x00b1 }
            java.nio.charset.Charset r0 = kotlin.text.Charsets.UTF_8     // Catch:{ all -> 0x00b1 }
            java.io.OutputStreamWriter r1 = new java.io.OutputStreamWriter     // Catch:{ all -> 0x00b1 }
            r1.<init>(r6, r0)     // Catch:{ all -> 0x00b1 }
            java.io.Writer r1 = (java.io.Writer) r1     // Catch:{ all -> 0x00b1 }
            boolean r6 = r1 instanceof java.io.BufferedWriter     // Catch:{ all -> 0x00b1 }
            if (r6 == 0) goto L_0x0093
            java.io.BufferedWriter r1 = (java.io.BufferedWriter) r1     // Catch:{ all -> 0x00b1 }
            goto L_0x009b
        L_0x0093:
            java.io.BufferedWriter r6 = new java.io.BufferedWriter     // Catch:{ all -> 0x00b1 }
            r0 = 8192(0x2000, float:1.14794E-41)
            r6.<init>(r1, r0)     // Catch:{ all -> 0x00b1 }
            r1 = r6
        L_0x009b:
            java.io.Closeable r1 = (java.io.Closeable) r1     // Catch:{ all -> 0x00b1 }
            r6 = r1
            java.io.BufferedWriter r6 = (java.io.BufferedWriter) r6     // Catch:{ all -> 0x00aa }
            r6.write(r7)     // Catch:{ all -> 0x00aa }
            kotlin.Unit r6 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00aa }
            r6 = 0
            kotlin.io.CloseableKt.closeFinally(r1, r6)     // Catch:{ all -> 0x00b1 }
            return
        L_0x00aa:
            r6 = move-exception
            throw r6     // Catch:{ all -> 0x00ac }
        L_0x00ac:
            r7 = move-exception
            kotlin.io.CloseableKt.closeFinally(r1, r6)     // Catch:{ all -> 0x00b1 }
            throw r7     // Catch:{ all -> 0x00b1 }
        L_0x00b1:
            r6 = move-exception
            timber.log.Timber$Forest r7 = timber.log.Timber.Forest
            java.lang.String r0 = "error writing internal file: timezones"
            java.lang.Object[] r1 = new java.lang.Object[r2]
            r7.e(r6, r0, r1)
        L_0x00bb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.core.util.TimezoneUtils.updateTimezoneList(android.content.Context, com.blueair.core.util.TimezoneNames):void");
    }
}
