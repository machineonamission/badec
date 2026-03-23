package com.blueair.api.restapi;

import com.blueair.adddevice.model.AddDeviceState$$ExternalSyntheticBackport0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u001a\b\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\t\u0010\u001d\u001a\u00020\nHÆ\u0003JF\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020\u00072\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\u0005HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006$"}, d2 = {"Lcom/blueair/api/restapi/State;", "", "n", "", "v", "", "vb", "", "vj", "t", "", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Object;J)V", "getN", "()Ljava/lang/String;", "getV", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getVb", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getVj", "()Ljava/lang/Object;", "getT", "()J", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Object;J)Lcom/blueair/api/restapi/State;", "equals", "other", "hashCode", "toString", "api_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: UserDevicesBlueRestApi.kt */
public final class State {
    private final String n;
    private final long t;
    private final Integer v;
    private final Boolean vb;
    private final Object vj;

    public static /* synthetic */ State copy$default(State state, String str, Integer num, Boolean bool, Object obj, long j, int i, Object obj2) {
        if ((i & 1) != 0) {
            str = state.n;
        }
        if ((i & 2) != 0) {
            num = state.v;
        }
        if ((i & 4) != 0) {
            bool = state.vb;
        }
        if ((i & 8) != 0) {
            obj = state.vj;
        }
        if ((i & 16) != 0) {
            j = state.t;
        }
        long j2 = j;
        Object obj3 = obj;
        Integer num2 = num;
        return state.copy(str, num2, bool, obj3, j2);
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

    public final Object component4() {
        return this.vj;
    }

    public final long component5() {
        return this.t;
    }

    public final State copy(String str, Integer num, Boolean bool, Object obj, long j) {
        Intrinsics.checkNotNullParameter(str, "n");
        return new State(str, num, bool, obj, j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof State)) {
            return false;
        }
        State state = (State) obj;
        return Intrinsics.areEqual((Object) this.n, (Object) state.n) && Intrinsics.areEqual((Object) this.v, (Object) state.v) && Intrinsics.areEqual((Object) this.vb, (Object) state.vb) && Intrinsics.areEqual(this.vj, state.vj) && this.t == state.t;
    }

    public int hashCode() {
        int hashCode = this.n.hashCode() * 31;
        Integer num = this.v;
        int i = 0;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        Boolean bool = this.vb;
        int hashCode3 = (hashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
        Object obj = this.vj;
        if (obj != null) {
            i = obj.hashCode();
        }
        return ((hashCode3 + i) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.t);
    }

    public String toString() {
        return "State(n=" + this.n + ", v=" + this.v + ", vb=" + this.vb + ", vj=" + this.vj + ", t=" + this.t + ')';
    }

    public State(String str, Integer num, Boolean bool, Object obj, long j) {
        Intrinsics.checkNotNullParameter(str, "n");
        this.n = str;
        this.v = num;
        this.vb = bool;
        this.vj = obj;
        this.t = j;
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

    public final Object getVj() {
        return this.vj;
    }

    public final long getT() {
        return this.t;
    }
}
