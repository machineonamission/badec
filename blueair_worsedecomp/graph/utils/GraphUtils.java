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
import org.apache.commons.io.IOUtils;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001aH\u0007R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u00058BX\u0002¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\u000b\u0010\u0007R\u001b\u0010\r\u001a\u00020\u00058BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\t\u001a\u0004\b\u000e\u0010\u0007R\u001b\u0010\u0010\u001a\u00020\u00058BX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\t\u001a\u0004\b\u0011\u0010\u0007¨\u0006\u001b"}, d2 = {"Lcom/blueair/graph/utils/GraphUtils;", "", "<init>", "()V", "timeFormatter24", "Ljava/text/SimpleDateFormat;", "getTimeFormatter24", "()Ljava/text/SimpleDateFormat;", "timeFormatter24$delegate", "Lkotlin/Lazy;", "timeFormatter12", "getTimeFormatter12", "timeFormatter12$delegate", "dateFormatter", "getDateFormatter", "dateFormatter$delegate", "dateFormatterMultiLine", "getDateFormatterMultiLine", "dateFormatterMultiLine$delegate", "getStringDate", "", "timeInMillis", "", "context", "Landroid/content/Context;", "multiLine", "", "graph_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: GraphUtils.kt */
public final class GraphUtils {
    public static final GraphUtils INSTANCE = new GraphUtils();
    private static final Lazy dateFormatter$delegate = LazyKt.lazy(new GraphUtils$$ExternalSyntheticLambda2());
    private static final Lazy dateFormatterMultiLine$delegate = LazyKt.lazy(new GraphUtils$$ExternalSyntheticLambda3());
    private static final Lazy timeFormatter12$delegate = LazyKt.lazy(new GraphUtils$$ExternalSyntheticLambda1());
    private static final Lazy timeFormatter24$delegate = LazyKt.lazy(new GraphUtils$$ExternalSyntheticLambda0());

    private GraphUtils() {
    }

    private final SimpleDateFormat getTimeFormatter24() {
        return (SimpleDateFormat) timeFormatter24$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final SimpleDateFormat timeFormatter24_delegate$lambda$0() {
        return new SimpleDateFormat("HH:mm");
    }

    private final SimpleDateFormat getTimeFormatter12() {
        return (SimpleDateFormat) timeFormatter12$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final SimpleDateFormat timeFormatter12_delegate$lambda$1() {
        return new SimpleDateFormat("hh:mm a");
    }

    private final SimpleDateFormat getDateFormatter() {
        return (SimpleDateFormat) dateFormatter$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final SimpleDateFormat dateFormatter_delegate$lambda$2() {
        return new SimpleDateFormat("MMM dd HH:mm");
    }

    private final SimpleDateFormat getDateFormatterMultiLine() {
        return (SimpleDateFormat) dateFormatterMultiLine$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final SimpleDateFormat dateFormatterMultiLine_delegate$lambda$3() {
        return new SimpleDateFormat("MMM dd\nHH:mm");
    }

    public static /* synthetic */ String getStringDate$default(GraphUtils graphUtils, long j, Context context, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return graphUtils.getStringDate(j, context, z);
    }

    public final String getStringDate(long j, Context context, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        Calendar instance = Calendar.getInstance();
        Calendar instance2 = Calendar.getInstance();
        instance2.setTimeInMillis(j);
        Object clone = instance.clone();
        Intrinsics.checkNotNull(clone, "null cannot be cast to non-null type java.util.Calendar");
        Calendar calendar = (Calendar) clone;
        calendar.set(instance2.get(1), instance2.get(2), instance2.get(5));
        int timeInMillis = (int) ((instance.getTimeInMillis() - calendar.getTimeInMillis()) / 86400000);
        SimpleDateFormat timeFormatter24 = DateFormat.is24HourFormat(context) ? getTimeFormatter24() : getTimeFormatter12();
        String str = z ? IOUtils.LINE_SEPARATOR_UNIX : " ";
        if (timeInMillis < 1) {
            return context.getString(R.string.today) + str + timeFormatter24.format(Long.valueOf(j));
        } else if (timeInMillis == 1) {
            return context.getString(R.string.yesterday) + str + timeFormatter24.format(Long.valueOf(j));
        } else if (2 > timeInMillis || timeInMillis >= 7) {
            String format = (z ? getDateFormatterMultiLine() : getDateFormatter()).format(Long.valueOf(j));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            return format;
        } else {
            return timeInMillis + TokenParser.SP + context.getString(R.string.days_ago) + str + timeFormatter24.format(Long.valueOf(j));
        }
    }
}
