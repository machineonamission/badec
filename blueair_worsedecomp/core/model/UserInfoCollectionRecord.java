package com.blueair.core.model;

import com.blueair.adddevice.model.AddDeviceState$$ExternalSyntheticBackport0;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/blueair/core/model/UserInfoCollectionRecord;", "", "value", "", "time", "", "<init>", "(Ljava/lang/String;J)V", "getValue", "()Ljava/lang/String;", "getTime", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: UserInfoCollections.kt */
public final class UserInfoCollectionRecord {
    private final long time;
    private final String value;

    public static /* synthetic */ UserInfoCollectionRecord copy$default(UserInfoCollectionRecord userInfoCollectionRecord, String str, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            str = userInfoCollectionRecord.value;
        }
        if ((i & 2) != 0) {
            j = userInfoCollectionRecord.time;
        }
        return userInfoCollectionRecord.copy(str, j);
    }

    public final String component1() {
        return this.value;
    }

    public final long component2() {
        return this.time;
    }

    public final UserInfoCollectionRecord copy(String str, long j) {
        Intrinsics.checkNotNullParameter(str, "value");
        return new UserInfoCollectionRecord(str, j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserInfoCollectionRecord)) {
            return false;
        }
        UserInfoCollectionRecord userInfoCollectionRecord = (UserInfoCollectionRecord) obj;
        return Intrinsics.areEqual((Object) this.value, (Object) userInfoCollectionRecord.value) && this.time == userInfoCollectionRecord.time;
    }

    public int hashCode() {
        return (this.value.hashCode() * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.time);
    }

    public String toString() {
        return "UserInfoCollectionRecord(value=" + this.value + ", time=" + this.time + ')';
    }

    public UserInfoCollectionRecord(String str, long j) {
        Intrinsics.checkNotNullParameter(str, "value");
        this.value = str;
        this.time = j;
    }

    public final String getValue() {
        return this.value;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UserInfoCollectionRecord(String str, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? System.currentTimeMillis() : j);
    }

    public final long getTime() {
        return this.time;
    }
}
