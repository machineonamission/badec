package com.blueair.devicedetails.util;

import android.content.Context;
import android.text.Spanned;
import androidx.core.text.HtmlCompat;
import com.blueair.core.model.HasDisinfection;
import com.blueair.viewcore.R;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.joda.time.DateTimeConstants;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0002¨\u0006\u000f"}, d2 = {"Lcom/blueair/devicedetails/util/DisinfectionUtils;", "", "<init>", "()V", "getCountdownStatus", "Lkotlin/Pair;", "", "Landroid/text/Spanned;", "device", "Lcom/blueair/core/model/HasDisinfection;", "context", "Landroid/content/Context;", "getCountdownText", "", "getLeftSeconds", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DisinfectionUtils.kt */
public final class DisinfectionUtils {
    public static final DisinfectionUtils INSTANCE = new DisinfectionUtils();

    private DisinfectionUtils() {
    }

    public final Pair<Integer, Spanned> getCountdownStatus(HasDisinfection hasDisinfection, Context context) {
        Intrinsics.checkNotNullParameter(hasDisinfection, "device");
        Intrinsics.checkNotNullParameter(context, "context");
        int leftSeconds = getLeftSeconds(hasDisinfection);
        int ceil = (int) Math.ceil(((double) leftSeconds) / 60.0d);
        String string = context.getString(ceil <= 1 ? R.string.disinfection_left_time_1min : R.string.disinfection_left_time);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String format = String.format(string, Arrays.copyOf(new Object[]{"<b>" + ceil + "</b>"}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        Spanned fromHtml = HtmlCompat.fromHtml(format, 0);
        Intrinsics.checkNotNullExpressionValue(fromHtml, "fromHtml(...)");
        return new Pair<>(Integer.valueOf(leftSeconds), fromHtml);
    }

    public final String getCountdownText(HasDisinfection hasDisinfection) {
        Intrinsics.checkNotNullParameter(hasDisinfection, "device");
        int leftSeconds = getLeftSeconds(hasDisinfection);
        int i = leftSeconds / DateTimeConstants.SECONDS_PER_HOUR;
        int ceil = (int) Math.ceil(((double) (leftSeconds - (i * DateTimeConstants.SECONDS_PER_HOUR))) / 60.0d);
        if (ceil > 59) {
            i++;
            ceil = 0;
        }
        String format = String.format("%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(i), Integer.valueOf(ceil)}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    private final int getLeftSeconds(HasDisinfection hasDisinfection) {
        Integer disinfectLeftTime = hasDisinfection.getDisinfectLeftTime();
        Long disinfectLeftTimeUpdateTime = hasDisinfection.getDisinfectLeftTimeUpdateTime();
        return RangesKt.coerceAtMost(RangesKt.coerceAtLeast((disinfectLeftTime == null || disinfectLeftTimeUpdateTime == null) ? 7200 : RangesKt.coerceAtLeast((int) (((long) disinfectLeftTime.intValue()) - ((System.currentTimeMillis() / ((long) 1000)) - disinfectLeftTimeUpdateTime.longValue())), 0), 0), 7200);
    }
}
