package com.blueair.core.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\b\u0002\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0010B!\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0011"}, d2 = {"Lcom/blueair/core/model/FilterLifeLevel;", "", "level", "", "minValue", "maxValue", "<init>", "(Ljava/lang/String;IIII)V", "getLevel", "()I", "getMinValue", "getMaxValue", "NORMAL", "SERIOUS", "GRAVE", "URGENT", "Companion", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: FilterLifeLevel.kt */
public enum FilterLifeLevel {
    NORMAL(3, 11, 100),
    SERIOUS(2, 6, 10),
    GRAVE(1, 1, 5),
    URGENT(0, 0, 0);
    
    public static final Companion Companion = null;
    private final int level;
    private final int maxValue;
    private final int minValue;

    public static EnumEntries<FilterLifeLevel> getEntries() {
        return $ENTRIES;
    }

    private FilterLifeLevel(int i, int i2, int i3) {
        this.level = i;
        this.minValue = i2;
        this.maxValue = i3;
    }

    public final int getLevel() {
        return this.level;
    }

    public final int getMaxValue() {
        return this.maxValue;
    }

    public final int getMinValue() {
        return this.minValue;
    }

    static {
        FilterLifeLevel[] $values;
        $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0007¨\u0006\n"}, d2 = {"Lcom/blueair/core/model/FilterLifeLevel$Companion;", "", "<init>", "()V", "fromFliterLeftLife", "Lcom/blueair/core/model/FilterLifeLevel;", "leftLife", "", "fromLevel", "level", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: FilterLifeLevel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final FilterLifeLevel fromFliterLeftLife(int i) {
            for (FilterLifeLevel filterLifeLevel : FilterLifeLevel.getEntries()) {
                int minValue = filterLifeLevel.getMinValue();
                if (i <= filterLifeLevel.getMaxValue() && minValue <= i) {
                    return filterLifeLevel;
                }
            }
            return FilterLifeLevel.NORMAL;
        }

        public final FilterLifeLevel fromLevel(int i) {
            if (i == FilterLifeLevel.URGENT.getLevel()) {
                return FilterLifeLevel.URGENT;
            }
            if (i == FilterLifeLevel.GRAVE.getLevel()) {
                return FilterLifeLevel.GRAVE;
            }
            if (i == FilterLifeLevel.SERIOUS.getLevel()) {
                return FilterLifeLevel.SERIOUS;
            }
            return FilterLifeLevel.NORMAL;
        }
    }
}
