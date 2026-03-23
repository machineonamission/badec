package com.blueair.android.adapter;

import com.blueair.adddevice.model.AddDeviceState$$ExternalSyntheticBackport0;
import com.blueair.core.model.FilterInfo;
import com.blueair.core.model.NotificationMessage;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0015\u001a\u00020\bJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J/\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006 "}, d2 = {"Lcom/blueair/android/adapter/NotificationItem;", "", "message", "Lcom/blueair/core/model/NotificationMessage;", "deviceFilters", "", "Lcom/blueair/core/model/FilterInfo;", "hasVideo", "", "<init>", "(Lcom/blueair/core/model/NotificationMessage;Ljava/util/List;Z)V", "getMessage", "()Lcom/blueair/core/model/NotificationMessage;", "getDeviceFilters", "()Ljava/util/List;", "setDeviceFilters", "(Ljava/util/List;)V", "getHasVideo", "()Z", "setHasVideo", "(Z)V", "canBuy", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "app_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: NotificationMsgAdapter.kt */
public final class NotificationItem {
    public static final int $stable = 8;
    private List<FilterInfo> deviceFilters;
    private boolean hasVideo;
    private final NotificationMessage message;

    public static /* synthetic */ NotificationItem copy$default(NotificationItem notificationItem, NotificationMessage notificationMessage, List<FilterInfo> list, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            notificationMessage = notificationItem.message;
        }
        if ((i & 2) != 0) {
            list = notificationItem.deviceFilters;
        }
        if ((i & 4) != 0) {
            z = notificationItem.hasVideo;
        }
        return notificationItem.copy(notificationMessage, list, z);
    }

    public final NotificationMessage component1() {
        return this.message;
    }

    public final List<FilterInfo> component2() {
        return this.deviceFilters;
    }

    public final boolean component3() {
        return this.hasVideo;
    }

    public final NotificationItem copy(NotificationMessage notificationMessage, List<FilterInfo> list, boolean z) {
        Intrinsics.checkNotNullParameter(notificationMessage, "message");
        return new NotificationItem(notificationMessage, list, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NotificationItem)) {
            return false;
        }
        NotificationItem notificationItem = (NotificationItem) obj;
        return Intrinsics.areEqual((Object) this.message, (Object) notificationItem.message) && Intrinsics.areEqual((Object) this.deviceFilters, (Object) notificationItem.deviceFilters) && this.hasVideo == notificationItem.hasVideo;
    }

    public int hashCode() {
        int hashCode = this.message.hashCode() * 31;
        List<FilterInfo> list = this.deviceFilters;
        return ((hashCode + (list == null ? 0 : list.hashCode())) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.hasVideo);
    }

    public String toString() {
        return "NotificationItem(message=" + this.message + ", deviceFilters=" + this.deviceFilters + ", hasVideo=" + this.hasVideo + ')';
    }

    public NotificationItem(NotificationMessage notificationMessage, List<FilterInfo> list, boolean z) {
        Intrinsics.checkNotNullParameter(notificationMessage, "message");
        this.message = notificationMessage;
        this.deviceFilters = list;
        this.hasVideo = z;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NotificationItem(NotificationMessage notificationMessage, List list, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(notificationMessage, list, (i & 4) != 0 ? false : z);
    }

    public final NotificationMessage getMessage() {
        return this.message;
    }

    public final List<FilterInfo> getDeviceFilters() {
        return this.deviceFilters;
    }

    public final void setDeviceFilters(List<FilterInfo> list) {
        this.deviceFilters = list;
    }

    public final boolean getHasVideo() {
        return this.hasVideo;
    }

    public final void setHasVideo(boolean z) {
        this.hasVideo = z;
    }

    public final boolean canBuy() {
        List<FilterInfo> list = this.deviceFilters;
        return list != null && (list.isEmpty() ^ true);
    }
}
