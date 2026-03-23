package com.blueair.api.restapi;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/blueair/api/restapi/AutoModeTrigger;", "", "amt", "", "n", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getAmt", "()Ljava/lang/String;", "getN", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "api_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: BlueCloudRestApi.kt */
public final class AutoModeTrigger {
    private final String amt;
    private final String n;

    public static /* synthetic */ AutoModeTrigger copy$default(AutoModeTrigger autoModeTrigger, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = autoModeTrigger.amt;
        }
        if ((i & 2) != 0) {
            str2 = autoModeTrigger.n;
        }
        return autoModeTrigger.copy(str, str2);
    }

    public final String component1() {
        return this.amt;
    }

    public final String component2() {
        return this.n;
    }

    public final AutoModeTrigger copy(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "amt");
        Intrinsics.checkNotNullParameter(str2, "n");
        return new AutoModeTrigger(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AutoModeTrigger)) {
            return false;
        }
        AutoModeTrigger autoModeTrigger = (AutoModeTrigger) obj;
        return Intrinsics.areEqual((Object) this.amt, (Object) autoModeTrigger.amt) && Intrinsics.areEqual((Object) this.n, (Object) autoModeTrigger.n);
    }

    public int hashCode() {
        return (this.amt.hashCode() * 31) + this.n.hashCode();
    }

    public String toString() {
        return "AutoModeTrigger(amt=" + this.amt + ", n=" + this.n + ')';
    }

    public AutoModeTrigger(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "amt");
        Intrinsics.checkNotNullParameter(str2, "n");
        this.amt = str;
        this.n = str2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AutoModeTrigger(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? "am" : str2);
    }

    public final String getAmt() {
        return this.amt;
    }

    public final String getN() {
        return this.n;
    }
}
