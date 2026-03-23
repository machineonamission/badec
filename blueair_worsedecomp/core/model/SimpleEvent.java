package com.blueair.core.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B\u0017\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\u0006\u0010\u0005\u001a\u00028\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\f\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\tJ\u000e\u0010\r\u001a\u00028\u0001HÆ\u0003¢\u0006\u0002\u0010\tJ.\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u0004\u001a\u00028\u00002\b\b\u0002\u0010\u0005\u001a\u00028\u0001HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0013\u0010\u0004\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0005\u001a\u00028\u0001¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u000b\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/blueair/core/model/SimpleEvent;", "T", "R", "", "eventType", "data", "<init>", "(Ljava/lang/Object;Ljava/lang/Object;)V", "getEventType", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getData", "component1", "component2", "copy", "(Ljava/lang/Object;Ljava/lang/Object;)Lcom/blueair/core/model/SimpleEvent;", "equals", "", "other", "hashCode", "", "toString", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: SimpleEvent.kt */
public final class SimpleEvent<T, R> {
    private final R data;
    private final T eventType;

    public static /* synthetic */ SimpleEvent copy$default(SimpleEvent simpleEvent, T t, R r, int i, Object obj) {
        if ((i & 1) != 0) {
            t = simpleEvent.eventType;
        }
        if ((i & 2) != 0) {
            r = simpleEvent.data;
        }
        return simpleEvent.copy(t, r);
    }

    public final T component1() {
        return this.eventType;
    }

    public final R component2() {
        return this.data;
    }

    public final SimpleEvent<T, R> copy(T t, R r) {
        return new SimpleEvent<>(t, r);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SimpleEvent)) {
            return false;
        }
        SimpleEvent simpleEvent = (SimpleEvent) obj;
        return Intrinsics.areEqual((Object) this.eventType, (Object) simpleEvent.eventType) && Intrinsics.areEqual((Object) this.data, (Object) simpleEvent.data);
    }

    public int hashCode() {
        T t = this.eventType;
        int i = 0;
        int hashCode = (t == null ? 0 : t.hashCode()) * 31;
        R r = this.data;
        if (r != null) {
            i = r.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "SimpleEvent(eventType=" + this.eventType + ", data=" + this.data + ')';
    }

    public SimpleEvent(T t, R r) {
        this.eventType = t;
        this.data = r;
    }

    public final R getData() {
        return this.data;
    }

    public final T getEventType() {
        return this.eventType;
    }
}
