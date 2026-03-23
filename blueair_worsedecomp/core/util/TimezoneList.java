package com.blueair.core.util;

import com.blueair.adddevice.model.AddDeviceState$$ExternalSyntheticBackport0;
import com.blueair.core.FileNames;
import java.util.List;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J-\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/blueair/core/util/TimezoneList;", "", "version", "", "time", "", "timezones", "", "Ljava/util/TimeZone;", "<init>", "(Ljava/lang/String;JLjava/util/List;)V", "getVersion", "()Ljava/lang/String;", "getTime", "()J", "getTimezones", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: TimezoneUtils.kt */
public final class TimezoneList {
    private final long time;
    private final List<TimeZone> timezones;
    private final String version;

    public static /* synthetic */ TimezoneList copy$default(TimezoneList timezoneList, String str, long j, List<TimeZone> list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = timezoneList.version;
        }
        if ((i & 2) != 0) {
            j = timezoneList.time;
        }
        if ((i & 4) != 0) {
            list = timezoneList.timezones;
        }
        return timezoneList.copy(str, j, list);
    }

    public final String component1() {
        return this.version;
    }

    public final long component2() {
        return this.time;
    }

    public final List<TimeZone> component3() {
        return this.timezones;
    }

    public final TimezoneList copy(String str, long j, List<? extends TimeZone> list) {
        Intrinsics.checkNotNullParameter(str, "version");
        Intrinsics.checkNotNullParameter(list, FileNames.TIMEZONE_LIST);
        return new TimezoneList(str, j, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TimezoneList)) {
            return false;
        }
        TimezoneList timezoneList = (TimezoneList) obj;
        return Intrinsics.areEqual((Object) this.version, (Object) timezoneList.version) && this.time == timezoneList.time && Intrinsics.areEqual((Object) this.timezones, (Object) timezoneList.timezones);
    }

    public int hashCode() {
        return (((this.version.hashCode() * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.time)) * 31) + this.timezones.hashCode();
    }

    public String toString() {
        return "TimezoneList(version=" + this.version + ", time=" + this.time + ", timezones=" + this.timezones + ')';
    }

    public TimezoneList(String str, long j, List<? extends TimeZone> list) {
        Intrinsics.checkNotNullParameter(str, "version");
        Intrinsics.checkNotNullParameter(list, FileNames.TIMEZONE_LIST);
        this.version = str;
        this.time = j;
        this.timezones = list;
    }

    public final String getVersion() {
        return this.version;
    }

    public final long getTime() {
        return this.time;
    }

    public final List<TimeZone> getTimezones() {
        return this.timezones;
    }
}
