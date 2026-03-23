package com.blueair.api.restapi;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/blueair/api/restapi/G4NightModeTrigger;", "", "nmt", "", "n", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getNmt", "()Ljava/lang/String;", "getN", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "api_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: BlueCloudRestApi.kt */
public final class G4NightModeTrigger {
    private final String n;
    private final String nmt;

    public static /* synthetic */ G4NightModeTrigger copy$default(G4NightModeTrigger g4NightModeTrigger, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = g4NightModeTrigger.nmt;
        }
        if ((i & 2) != 0) {
            str2 = g4NightModeTrigger.n;
        }
        return g4NightModeTrigger.copy(str, str2);
    }

    public final String component1() {
        return this.nmt;
    }

    public final String component2() {
        return this.n;
    }

    public final G4NightModeTrigger copy(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "nmt");
        Intrinsics.checkNotNullParameter(str2, "n");
        return new G4NightModeTrigger(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof G4NightModeTrigger)) {
            return false;
        }
        G4NightModeTrigger g4NightModeTrigger = (G4NightModeTrigger) obj;
        return Intrinsics.areEqual((Object) this.nmt, (Object) g4NightModeTrigger.nmt) && Intrinsics.areEqual((Object) this.n, (Object) g4NightModeTrigger.n);
    }

    public int hashCode() {
        return (this.nmt.hashCode() * 31) + this.n.hashCode();
    }

    public String toString() {
        return "G4NightModeTrigger(nmt=" + this.nmt + ", n=" + this.n + ')';
    }

    public G4NightModeTrigger(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "nmt");
        Intrinsics.checkNotNullParameter(str2, "n");
        this.nmt = str;
        this.n = str2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ G4NightModeTrigger(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? "nm" : str2);
    }

    public final String getN() {
        return this.n;
    }

    public final String getNmt() {
        return this.nmt;
    }
}
