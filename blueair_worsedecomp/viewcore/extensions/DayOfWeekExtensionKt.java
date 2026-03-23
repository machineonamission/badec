package com.blueair.viewcore.extensions;

import android.content.Context;
import com.blueair.core.model.DayOfWeek;
import com.blueair.viewcore.R;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\n\u0010\u0000\u001a\u00020\u0005*\u00020\u0002\u001a\u0012\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\n\u0010\u0006\u001a\u00020\u0005*\u00020\u0002\u001a\u0012\u0010\u0007\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\n\u0010\u0007\u001a\u00020\u0005*\u00020\u0002\u001a\u0018\u0010\u0011\u001a\u00020\u0012*\u00020\n2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\t\u001a\u0018\u0010\u0014\u001a\u00020\u0012*\u00020\n2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\t\u001a\u0018\u0010\u0015\u001a\u00020\u0012*\u00020\n2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\t\u001a\u0018\u0010\u0016\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0004\"\u001b\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\t*\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f\"\u001b\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\t*\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\f\"\u001b\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\t*\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\f¨\u0006\u0017"}, d2 = {"displayValueShort", "", "Lcom/blueair/core/model/DayOfWeek;", "context", "Landroid/content/Context;", "", "displayValueLong", "displayValueEveryLong", "everydaySet", "", "Lcom/blueair/core/model/DayOfWeek$Companion;", "getEverydaySet", "(Lcom/blueair/core/model/DayOfWeek$Companion;)Ljava/util/Set;", "weekdaySet", "getWeekdaySet", "weekendSet", "getWeekendSet", "isWeekdaysOnly", "", "values", "isWeekendOnly", "isEveryDay", "toString", "viewcore_otherRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* compiled from: DayOfWeekExtension.kt */
public final class DayOfWeekExtensionKt {

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DayOfWeekExtension.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(17:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|17) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0034 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x003d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                com.blueair.core.model.DayOfWeek[] r0 = com.blueair.core.model.DayOfWeek.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.blueair.core.model.DayOfWeek r1 = com.blueair.core.model.DayOfWeek.SUN     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.blueair.core.model.DayOfWeek r1 = com.blueair.core.model.DayOfWeek.MON     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.blueair.core.model.DayOfWeek r1 = com.blueair.core.model.DayOfWeek.TUE     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.blueair.core.model.DayOfWeek r1 = com.blueair.core.model.DayOfWeek.WED     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                com.blueair.core.model.DayOfWeek r1 = com.blueair.core.model.DayOfWeek.THU     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                com.blueair.core.model.DayOfWeek r1 = com.blueair.core.model.DayOfWeek.FRI     // Catch:{ NoSuchFieldError -> 0x003d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                com.blueair.core.model.DayOfWeek r1 = com.blueair.core.model.DayOfWeek.SAT     // Catch:{ NoSuchFieldError -> 0x0046 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0046 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0046 }
            L_0x0046:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.viewcore.extensions.DayOfWeekExtensionKt.WhenMappings.<clinit>():void");
        }
    }

    public static final String displayValueShort(DayOfWeek dayOfWeek, Context context) {
        Intrinsics.checkNotNullParameter(dayOfWeek, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        String string = context.getString(displayValueShort(dayOfWeek));
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    public static final int displayValueShort(DayOfWeek dayOfWeek) {
        Intrinsics.checkNotNullParameter(dayOfWeek, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$0[dayOfWeek.ordinal()]) {
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

    public static final String displayValueLong(DayOfWeek dayOfWeek, Context context) {
        Intrinsics.checkNotNullParameter(dayOfWeek, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        String string = context.getString(displayValueLong(dayOfWeek));
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    public static final int displayValueLong(DayOfWeek dayOfWeek) {
        Intrinsics.checkNotNullParameter(dayOfWeek, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$0[dayOfWeek.ordinal()]) {
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

    public static final String displayValueEveryLong(DayOfWeek dayOfWeek, Context context) {
        Intrinsics.checkNotNullParameter(dayOfWeek, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        String string = context.getString(displayValueEveryLong(dayOfWeek));
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    public static final int displayValueEveryLong(DayOfWeek dayOfWeek) {
        Intrinsics.checkNotNullParameter(dayOfWeek, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$0[dayOfWeek.ordinal()]) {
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

    public static final Set<DayOfWeek> getEverydaySet(DayOfWeek.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return SetsKt.setOf(DayOfWeek.SUN, DayOfWeek.MON, DayOfWeek.TUE, DayOfWeek.WED, DayOfWeek.THU, DayOfWeek.FRI, DayOfWeek.SAT);
    }

    public static final Set<DayOfWeek> getWeekdaySet(DayOfWeek.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return SetsKt.setOf(DayOfWeek.MON, DayOfWeek.TUE, DayOfWeek.WED, DayOfWeek.THU, DayOfWeek.FRI);
    }

    public static final Set<DayOfWeek> getWeekendSet(DayOfWeek.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return SetsKt.setOf(DayOfWeek.SAT, DayOfWeek.SUN);
    }

    public static final boolean isWeekdaysOnly(DayOfWeek.Companion companion, Set<? extends DayOfWeek> set) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(set, "values");
        return set.size() == 5 && set.containsAll(getWeekdaySet(companion));
    }

    public static final boolean isWeekendOnly(DayOfWeek.Companion companion, Set<? extends DayOfWeek> set) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(set, "values");
        return set.size() == 2 && set.containsAll(getWeekendSet(companion));
    }

    public static final boolean isEveryDay(DayOfWeek.Companion companion, Set<? extends DayOfWeek> set) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(set, "values");
        return set.size() == 7 && set.containsAll(getEverydaySet(companion));
    }

    public static final String toString(Set<? extends DayOfWeek> set, Context context) {
        Intrinsics.checkNotNullParameter(set, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        if (isWeekdaysOnly(DayOfWeek.Companion, set)) {
            String string = context.getString(R.string.weekdays);
            Intrinsics.checkNotNull(string);
            return string;
        } else if (isWeekendOnly(DayOfWeek.Companion, set)) {
            String string2 = context.getString(R.string.weekend);
            Intrinsics.checkNotNull(string2);
            return string2;
        } else if (!isEveryDay(DayOfWeek.Companion, set)) {
            return CollectionsKt.joinToString$default(set, ", ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new DayOfWeekExtensionKt$$ExternalSyntheticLambda0(context), 30, (Object) null);
        } else {
            String string3 = context.getString(R.string.everyday);
            Intrinsics.checkNotNull(string3);
            return string3;
        }
    }

    /* access modifiers changed from: private */
    public static final CharSequence toString$lambda$0(Context context, DayOfWeek dayOfWeek) {
        Intrinsics.checkNotNullParameter(dayOfWeek, "it");
        return displayValueShort(dayOfWeek, context);
    }
}
