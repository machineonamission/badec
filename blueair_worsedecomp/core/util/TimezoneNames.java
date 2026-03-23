package com.blueair.core.util;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/blueair/core/util/TimezoneNames;", "", "version", "", "timezoneNames", "", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "getVersion", "()Ljava/lang/String;", "getTimezoneNames", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: TimezoneUtils.kt */
public final class TimezoneNames {
    private final List<String> timezoneNames;
    private final String version;

    public static /* synthetic */ TimezoneNames copy$default(TimezoneNames timezoneNames2, String str, List<String> list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = timezoneNames2.version;
        }
        if ((i & 2) != 0) {
            list = timezoneNames2.timezoneNames;
        }
        return timezoneNames2.copy(str, list);
    }

    public final String component1() {
        return this.version;
    }

    public final List<String> component2() {
        return this.timezoneNames;
    }

    public final TimezoneNames copy(String str, List<String> list) {
        Intrinsics.checkNotNullParameter(str, "version");
        Intrinsics.checkNotNullParameter(list, "timezoneNames");
        return new TimezoneNames(str, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TimezoneNames)) {
            return false;
        }
        TimezoneNames timezoneNames2 = (TimezoneNames) obj;
        return Intrinsics.areEqual((Object) this.version, (Object) timezoneNames2.version) && Intrinsics.areEqual((Object) this.timezoneNames, (Object) timezoneNames2.timezoneNames);
    }

    public int hashCode() {
        return (this.version.hashCode() * 31) + this.timezoneNames.hashCode();
    }

    public String toString() {
        return "TimezoneNames(version=" + this.version + ", timezoneNames=" + this.timezoneNames + ')';
    }

    public TimezoneNames(String str, List<String> list) {
        Intrinsics.checkNotNullParameter(str, "version");
        Intrinsics.checkNotNullParameter(list, "timezoneNames");
        this.version = str;
        this.timezoneNames = list;
    }

    public final String getVersion() {
        return this.version;
    }

    public final List<String> getTimezoneNames() {
        return this.timezoneNames;
    }
}
