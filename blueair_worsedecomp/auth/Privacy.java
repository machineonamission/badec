package com.blueair.auth;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/blueair/auth/Privacy;", "", "generic", "Lcom/blueair/auth/Generic;", "<init>", "(Lcom/blueair/auth/Generic;)V", "getGeneric", "()Lcom/blueair/auth/Generic;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "auth_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: GigyaService.kt */
final class Privacy {
    private final Generic generic;

    public static /* synthetic */ Privacy copy$default(Privacy privacy, Generic generic2, int i, Object obj) {
        if ((i & 1) != 0) {
            generic2 = privacy.generic;
        }
        return privacy.copy(generic2);
    }

    public final Generic component1() {
        return this.generic;
    }

    public final Privacy copy(Generic generic2) {
        Intrinsics.checkNotNullParameter(generic2, "generic");
        return new Privacy(generic2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Privacy) && Intrinsics.areEqual((Object) this.generic, (Object) ((Privacy) obj).generic);
    }

    public int hashCode() {
        return this.generic.hashCode();
    }

    public String toString() {
        return "Privacy(generic=" + this.generic + ')';
    }

    public Privacy(Generic generic2) {
        Intrinsics.checkNotNullParameter(generic2, "generic");
        this.generic = generic2;
    }

    public final Generic getGeneric() {
        return this.generic;
    }
}
