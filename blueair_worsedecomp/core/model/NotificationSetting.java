package com.blueair.core.model;

import com.squareup.moshi.Json;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\n\b\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u0010\u001a\u00020\u0011J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ.\u0010\u0015\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00112\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/blueair/core/model/NotificationSetting;", "", "type", "", "enabled", "", "limit", "<init>", "(Ljava/lang/String;ILjava/lang/Integer;)V", "getType", "()Ljava/lang/String;", "getEnabled", "()I", "getLimit", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "isEnabled", "", "component1", "component2", "component3", "copy", "(Ljava/lang/String;ILjava/lang/Integer;)Lcom/blueair/core/model/NotificationSetting;", "equals", "other", "hashCode", "toString", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: NotificationSetting.kt */
public final class NotificationSetting {
    private final int enabled;
    private final Integer limit;
    private final String type;

    public static /* synthetic */ NotificationSetting copy$default(NotificationSetting notificationSetting, String str, int i, Integer num, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = notificationSetting.type;
        }
        if ((i2 & 2) != 0) {
            i = notificationSetting.enabled;
        }
        if ((i2 & 4) != 0) {
            num = notificationSetting.limit;
        }
        return notificationSetting.copy(str, i, num);
    }

    public final String component1() {
        return this.type;
    }

    public final int component2() {
        return this.enabled;
    }

    public final Integer component3() {
        return this.limit;
    }

    public final NotificationSetting copy(@Json(name = "message_type") String str, @Json(name = "to_receive_notifications") int i, @Json(name = "message_limit_count") Integer num) {
        Intrinsics.checkNotNullParameter(str, "type");
        return new NotificationSetting(str, i, num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NotificationSetting)) {
            return false;
        }
        NotificationSetting notificationSetting = (NotificationSetting) obj;
        return Intrinsics.areEqual((Object) this.type, (Object) notificationSetting.type) && this.enabled == notificationSetting.enabled && Intrinsics.areEqual((Object) this.limit, (Object) notificationSetting.limit);
    }

    public int hashCode() {
        int hashCode = ((this.type.hashCode() * 31) + this.enabled) * 31;
        Integer num = this.limit;
        return hashCode + (num == null ? 0 : num.hashCode());
    }

    public String toString() {
        return "NotificationSetting(type=" + this.type + ", enabled=" + this.enabled + ", limit=" + this.limit + ')';
    }

    public NotificationSetting(@Json(name = "message_type") String str, @Json(name = "to_receive_notifications") int i, @Json(name = "message_limit_count") Integer num) {
        Intrinsics.checkNotNullParameter(str, "type");
        this.type = str;
        this.enabled = i;
        this.limit = num;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NotificationSetting(String str, int i, Integer num, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i2 & 2) != 0 ? 0 : i, (i2 & 4) != 0 ? null : num);
    }

    public final String getType() {
        return this.type;
    }

    public final int getEnabled() {
        return this.enabled;
    }

    public final Integer getLimit() {
        return this.limit;
    }

    public final boolean isEnabled() {
        return this.enabled != 0;
    }
}
