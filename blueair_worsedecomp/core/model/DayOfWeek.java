package com.blueair.core.model;

import java.util.Calendar;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001a\b\u0002\u0018\u0000 \u001f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u001fB1\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\u0019\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\fR\u0011\u0010\u001b\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\fj\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018¨\u0006 "}, d2 = {"Lcom/blueair/core/model/DayOfWeek;", "", "compareValue", "", "ablValue", "blueValue", "", "monFirstOrder", "satFirstOrder", "<init>", "(Ljava/lang/String;IIILjava/lang/String;II)V", "getCompareValue", "()I", "getAblValue", "getBlueValue", "()Ljava/lang/String;", "getMonFirstOrder", "getSatFirstOrder", "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT", "dbValue", "getDbValue", "weekDayCompareValue", "getWeekDayCompareValue", "plusDays", "offset", "Companion", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceSchedule.kt */
public enum DayOfWeek {
    SUN(0, 1, "SUN", 6, 1),
    MON(1, 2, "MON", 0, 2),
    TUE(2, 3, "TUE", 1, 3),
    WED(3, 4, "WED", 2, 4),
    THU(4, 5, "THU", 3, 5),
    FRI(5, 6, "FRI", 4, 6),
    SAT(6, 7, "SAT", 5, 0);
    
    public static final Companion Companion = null;
    /* access modifiers changed from: private */
    public static final DayOfWeek firstDayOfWeek = null;
    /* access modifiers changed from: private */
    public static final DayOfWeek[] values = null;
    private final int ablValue;
    private final String blueValue;
    private final int compareValue;
    private final int monFirstOrder;
    private final int satFirstOrder;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceSchedule.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
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
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.core.model.DayOfWeek.WhenMappings.<clinit>():void");
        }
    }

    public static EnumEntries<DayOfWeek> getEntries() {
        return $ENTRIES;
    }

    private DayOfWeek(int i, int i2, String str, int i3, int i4) {
        this.compareValue = i;
        this.ablValue = i2;
        this.blueValue = str;
        this.monFirstOrder = i3;
        this.satFirstOrder = i4;
    }

    public final int getCompareValue() {
        return this.compareValue;
    }

    public final int getAblValue() {
        return this.ablValue;
    }

    public final String getBlueValue() {
        return this.blueValue;
    }

    public final int getMonFirstOrder() {
        return this.monFirstOrder;
    }

    public final int getSatFirstOrder() {
        return this.satFirstOrder;
    }

    static {
        DayOfWeek dayOfWeek;
        DayOfWeek dayOfWeek2;
        DayOfWeek dayOfWeek3;
        DayOfWeek[] $values;
        $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
        Companion = new Companion((DefaultConstructorMarker) null);
        int firstDayOfWeek2 = Calendar.getInstance().getFirstDayOfWeek();
        if (firstDayOfWeek2 != 1) {
            dayOfWeek = firstDayOfWeek2 != 2 ? dayOfWeek3 : dayOfWeek2;
        }
        firstDayOfWeek = dayOfWeek;
        values = values();
    }

    public final int getDbValue() {
        return this.ablValue;
    }

    public final int getWeekDayCompareValue() {
        int i = WhenMappings.$EnumSwitchMapping$0[firstDayOfWeek.ordinal()];
        if (i == 1) {
            return this.compareValue;
        }
        if (i != 2) {
            return this.satFirstOrder;
        }
        return this.monFirstOrder;
    }

    public final DayOfWeek plusDays(int i) {
        int i2 = 7;
        if (i <= 0) {
            if (i >= 0) {
                return this;
            }
            i = (i % 7) + 7;
        }
        int i3 = (this.ablValue + i) % 7;
        if (i3 != 0) {
            i2 = i3;
        }
        DayOfWeek byAblValue = Companion.getByAblValue(i2);
        Intrinsics.checkNotNull(byAblValue);
        return byAblValue;
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\rJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\rJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tX\u0004¢\u0006\u0004\n\u0002\u0010\n¨\u0006\u0011"}, d2 = {"Lcom/blueair/core/model/DayOfWeek$Companion;", "", "<init>", "()V", "firstDayOfWeek", "Lcom/blueair/core/model/DayOfWeek;", "getFirstDayOfWeek", "()Lcom/blueair/core/model/DayOfWeek;", "values", "", "[Lcom/blueair/core/model/DayOfWeek;", "getByDBValue", "value", "", "getByAblValue", "getByBlueValue", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceSchedule.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DayOfWeek getFirstDayOfWeek() {
            return DayOfWeek.firstDayOfWeek;
        }

        public final DayOfWeek getByDBValue(int i) {
            for (DayOfWeek dayOfWeek : DayOfWeek.values) {
                if (dayOfWeek.getAblValue() == i) {
                    return dayOfWeek;
                }
            }
            return null;
        }

        public final DayOfWeek getByAblValue(int i) {
            return getByDBValue(i);
        }

        public final DayOfWeek getByBlueValue(String str) {
            Intrinsics.checkNotNullParameter(str, "value");
            for (DayOfWeek dayOfWeek : DayOfWeek.values) {
                if (Intrinsics.areEqual((Object) dayOfWeek.getBlueValue(), (Object) str)) {
                    return dayOfWeek;
                }
            }
            return null;
        }
    }
}
