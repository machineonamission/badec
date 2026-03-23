package com.blueair.core.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0010J0\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/blueair/core/model/ScheduleMode;", "", "n", "", "v", "", "vb", "", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;)V", "getN", "()Ljava/lang/String;", "getV", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getVb", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;)Lcom/blueair/core/model/ScheduleMode;", "equals", "other", "hashCode", "toString", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: BlueDeviceSchedule.kt */
public final class ScheduleMode {
    private final String n;
    private final Integer v;
    private final Boolean vb;

    public static /* synthetic */ ScheduleMode copy$default(ScheduleMode scheduleMode, String str, Integer num, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            str = scheduleMode.n;
        }
        if ((i & 2) != 0) {
            num = scheduleMode.v;
        }
        if ((i & 4) != 0) {
            bool = scheduleMode.vb;
        }
        return scheduleMode.copy(str, num, bool);
    }

    public final String component1() {
        return this.n;
    }

    public final Integer component2() {
        return this.v;
    }

    public final Boolean component3() {
        return this.vb;
    }

    public final ScheduleMode copy(String str, Integer num, Boolean bool) {
        Intrinsics.checkNotNullParameter(str, "n");
        return new ScheduleMode(str, num, bool);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ScheduleMode)) {
            return false;
        }
        ScheduleMode scheduleMode = (ScheduleMode) obj;
        return Intrinsics.areEqual((Object) this.n, (Object) scheduleMode.n) && Intrinsics.areEqual((Object) this.v, (Object) scheduleMode.v) && Intrinsics.areEqual((Object) this.vb, (Object) scheduleMode.vb);
    }

    public int hashCode() {
        int hashCode = this.n.hashCode() * 31;
        Integer num = this.v;
        int i = 0;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        Boolean bool = this.vb;
        if (bool != null) {
            i = bool.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "ScheduleMode(n=" + this.n + ", v=" + this.v + ", vb=" + this.vb + ')';
    }

    public ScheduleMode(String str, Integer num, Boolean bool) {
        Intrinsics.checkNotNullParameter(str, "n");
        this.n = str;
        this.v = num;
        this.vb = bool;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ScheduleMode(String str, Integer num, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : bool);
    }

    public final String getN() {
        return this.n;
    }

    public final Integer getV() {
        return this.v;
    }

    public final Boolean getVb() {
        return this.vb;
    }
}
