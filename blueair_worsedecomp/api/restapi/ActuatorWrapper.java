package com.blueair.api.restapi;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u001b\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\t\u0010\nB\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\u000bB\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\fB\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0001¢\u0006\u0004\b\t\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0014J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÆ\u0003J<\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0001HÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0007HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\""}, d2 = {"Lcom/blueair/api/restapi/ActuatorWrapper;", "", "n", "", "vb", "", "v", "", "vj", "<init>", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Object;)V", "(Ljava/lang/String;I)V", "(Ljava/lang/String;Z)V", "(Ljava/lang/String;Ljava/lang/Object;)V", "getN", "()Ljava/lang/String;", "getVb", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getV", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getVj", "()Ljava/lang/Object;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Object;)Lcom/blueair/api/restapi/ActuatorWrapper;", "equals", "other", "hashCode", "toString", "api_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: BlueCloudRestApi.kt */
public final class ActuatorWrapper {
    private final String n;
    private final Integer v;
    private final Boolean vb;
    private final Object vj;

    public static /* synthetic */ ActuatorWrapper copy$default(ActuatorWrapper actuatorWrapper, String str, Boolean bool, Integer num, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            str = actuatorWrapper.n;
        }
        if ((i & 2) != 0) {
            bool = actuatorWrapper.vb;
        }
        if ((i & 4) != 0) {
            num = actuatorWrapper.v;
        }
        if ((i & 8) != 0) {
            obj = actuatorWrapper.vj;
        }
        return actuatorWrapper.copy(str, bool, num, obj);
    }

    public final String component1() {
        return this.n;
    }

    public final Boolean component2() {
        return this.vb;
    }

    public final Integer component3() {
        return this.v;
    }

    public final Object component4() {
        return this.vj;
    }

    public final ActuatorWrapper copy(String str, Boolean bool, Integer num, Object obj) {
        Intrinsics.checkNotNullParameter(str, "n");
        return new ActuatorWrapper(str, bool, num, obj);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActuatorWrapper)) {
            return false;
        }
        ActuatorWrapper actuatorWrapper = (ActuatorWrapper) obj;
        return Intrinsics.areEqual((Object) this.n, (Object) actuatorWrapper.n) && Intrinsics.areEqual((Object) this.vb, (Object) actuatorWrapper.vb) && Intrinsics.areEqual((Object) this.v, (Object) actuatorWrapper.v) && Intrinsics.areEqual(this.vj, actuatorWrapper.vj);
    }

    public int hashCode() {
        int hashCode = this.n.hashCode() * 31;
        Boolean bool = this.vb;
        int i = 0;
        int hashCode2 = (hashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        Integer num = this.v;
        int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        Object obj = this.vj;
        if (obj != null) {
            i = obj.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "ActuatorWrapper(n=" + this.n + ", vb=" + this.vb + ", v=" + this.v + ", vj=" + this.vj + ')';
    }

    public ActuatorWrapper(String str, Boolean bool, Integer num, Object obj) {
        Intrinsics.checkNotNullParameter(str, "n");
        this.n = str;
        this.vb = bool;
        this.v = num;
        this.vj = obj;
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

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ActuatorWrapper(String str, int i) {
        this(str, (Boolean) null, Integer.valueOf(i), (Object) null);
        Intrinsics.checkNotNullParameter(str, "n");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ActuatorWrapper(String str, boolean z) {
        this(str, Boolean.valueOf(z), (Integer) null, (Object) null);
        Intrinsics.checkNotNullParameter(str, "n");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ActuatorWrapper(String str, Object obj) {
        this(str, (Boolean) null, (Integer) null, obj);
        Intrinsics.checkNotNullParameter(str, "n");
        Intrinsics.checkNotNullParameter(obj, "vj");
    }
}
