package io.flatcircle.ble;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\r\u001a\u00020\u0004HÆ\u0003J\u0010\u0010\u000e\u001a\u0004\u0018\u00018\u0000HÆ\u0003¢\u0006\u0002\u0010\u000bJ*\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00018\u0000HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0004HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0005\u001a\u0004\u0018\u00018\u0000¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lio/flatcircle/ble/BleEvent;", "T", "", "uuid", "", "content", "<init>", "(Ljava/lang/String;Ljava/lang/Object;)V", "getUuid", "()Ljava/lang/String;", "getContent", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Object;)Lio/flatcircle/ble/BleEvent;", "equals", "", "other", "hashCode", "", "toString", "ble_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: BleService.kt */
public final class BleEvent<T> {
    private final T content;
    private final String uuid;

    public static /* synthetic */ BleEvent copy$default(BleEvent bleEvent, String str, T t, int i, Object obj) {
        if ((i & 1) != 0) {
            str = bleEvent.uuid;
        }
        if ((i & 2) != 0) {
            t = bleEvent.content;
        }
        return bleEvent.copy(str, t);
    }

    public final String component1() {
        return this.uuid;
    }

    public final T component2() {
        return this.content;
    }

    public final BleEvent<T> copy(String str, T t) {
        Intrinsics.checkNotNullParameter(str, "uuid");
        return new BleEvent<>(str, t);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleEvent)) {
            return false;
        }
        BleEvent bleEvent = (BleEvent) obj;
        return Intrinsics.areEqual((Object) this.uuid, (Object) bleEvent.uuid) && Intrinsics.areEqual((Object) this.content, (Object) bleEvent.content);
    }

    public int hashCode() {
        int hashCode = this.uuid.hashCode() * 31;
        T t = this.content;
        return hashCode + (t == null ? 0 : t.hashCode());
    }

    public String toString() {
        return "BleEvent(uuid=" + this.uuid + ", content=" + this.content + ')';
    }

    public BleEvent(String str, T t) {
        Intrinsics.checkNotNullParameter(str, "uuid");
        this.uuid = str;
        this.content = t;
    }

    public final T getContent() {
        return this.content;
    }

    public final String getUuid() {
        return this.uuid;
    }
}
