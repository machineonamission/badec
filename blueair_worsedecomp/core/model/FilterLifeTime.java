package com.blueair.core.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\b\t\nB\u0011\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0001\u0003\u000b\f\r¨\u0006\u000e"}, d2 = {"Lcom/blueair/core/model/FilterLifeTime;", "", "filterLife", "", "<init>", "(I)V", "getFilterLife", "()I", "NoFilterInfo", "FilterDaysLeft", "FilterPercentageLeft", "Lcom/blueair/core/model/FilterLifeTime$FilterDaysLeft;", "Lcom/blueair/core/model/FilterLifeTime$FilterPercentageLeft;", "Lcom/blueair/core/model/FilterLifeTime$NoFilterInfo;", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: Device.kt */
public abstract class FilterLifeTime {
    private final int filterLife;

    public /* synthetic */ FilterLifeTime(int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(i);
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/core/model/FilterLifeTime$NoFilterInfo;", "Lcom/blueair/core/model/FilterLifeTime;", "<init>", "()V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: Device.kt */
    public static final class NoFilterInfo extends FilterLifeTime {
        public NoFilterInfo() {
            super(100, (DefaultConstructorMarker) null);
        }
    }

    private FilterLifeTime(int i) {
        this.filterLife = i;
    }

    public int getFilterLife() {
        return this.filterLife;
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ$\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/blueair/core/model/FilterLifeTime$FilterDaysLeft;", "Lcom/blueair/core/model/FilterLifeTime;", "filterLife", "", "filterLifePercentage", "<init>", "(ILjava/lang/Integer;)V", "getFilterLife", "()I", "getFilterLifePercentage", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(ILjava/lang/Integer;)Lcom/blueair/core/model/FilterLifeTime$FilterDaysLeft;", "equals", "", "other", "", "hashCode", "toString", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: Device.kt */
    public static final class FilterDaysLeft extends FilterLifeTime {
        private final int filterLife;
        private final Integer filterLifePercentage;

        public static /* synthetic */ FilterDaysLeft copy$default(FilterDaysLeft filterDaysLeft, int i, Integer num, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = filterDaysLeft.filterLife;
            }
            if ((i2 & 2) != 0) {
                num = filterDaysLeft.filterLifePercentage;
            }
            return filterDaysLeft.copy(i, num);
        }

        public final int component1() {
            return this.filterLife;
        }

        public final Integer component2() {
            return this.filterLifePercentage;
        }

        public final FilterDaysLeft copy(int i, Integer num) {
            return new FilterDaysLeft(i, num);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof FilterDaysLeft)) {
                return false;
            }
            FilterDaysLeft filterDaysLeft = (FilterDaysLeft) obj;
            return this.filterLife == filterDaysLeft.filterLife && Intrinsics.areEqual((Object) this.filterLifePercentage, (Object) filterDaysLeft.filterLifePercentage);
        }

        public int hashCode() {
            int i = this.filterLife * 31;
            Integer num = this.filterLifePercentage;
            return i + (num == null ? 0 : num.hashCode());
        }

        public String toString() {
            return "FilterDaysLeft(filterLife=" + this.filterLife + ", filterLifePercentage=" + this.filterLifePercentage + ')';
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ FilterDaysLeft(int i, Integer num, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, (i2 & 2) != 0 ? null : num);
        }

        public int getFilterLife() {
            return this.filterLife;
        }

        public final Integer getFilterLifePercentage() {
            return this.filterLifePercentage;
        }

        public FilterDaysLeft(int i, Integer num) {
            super(i, (DefaultConstructorMarker) null);
            this.filterLife = i;
            this.filterLifePercentage = num;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/blueair/core/model/FilterLifeTime$FilterPercentageLeft;", "Lcom/blueair/core/model/FilterLifeTime;", "filterLife", "", "<init>", "(I)V", "getFilterLife", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: Device.kt */
    public static final class FilterPercentageLeft extends FilterLifeTime {
        private final int filterLife;

        public static /* synthetic */ FilterPercentageLeft copy$default(FilterPercentageLeft filterPercentageLeft, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = filterPercentageLeft.filterLife;
            }
            return filterPercentageLeft.copy(i);
        }

        public final int component1() {
            return this.filterLife;
        }

        public final FilterPercentageLeft copy(int i) {
            return new FilterPercentageLeft(i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof FilterPercentageLeft) && this.filterLife == ((FilterPercentageLeft) obj).filterLife;
        }

        public int hashCode() {
            return this.filterLife;
        }

        public String toString() {
            return "FilterPercentageLeft(filterLife=" + this.filterLife + ')';
        }

        public FilterPercentageLeft(int i) {
            super(i, (DefaultConstructorMarker) null);
            this.filterLife = i;
        }

        public int getFilterLife() {
            return this.filterLife;
        }
    }
}
