package com.blueair.auth;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/blueair/auth/Unilever;", "", "email", "Lcom/blueair/auth/Email;", "<init>", "(Lcom/blueair/auth/Email;)V", "getEmail", "()Lcom/blueair/auth/Email;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "auth_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: GigyaService.kt */
public final class Unilever {
    private final Email email;

    public static /* synthetic */ Unilever copy$default(Unilever unilever, Email email2, int i, Object obj) {
        if ((i & 1) != 0) {
            email2 = unilever.email;
        }
        return unilever.copy(email2);
    }

    public final Email component1() {
        return this.email;
    }

    public final Unilever copy(Email email2) {
        Intrinsics.checkNotNullParameter(email2, "email");
        return new Unilever(email2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Unilever) && Intrinsics.areEqual((Object) this.email, (Object) ((Unilever) obj).email);
    }

    public int hashCode() {
        return this.email.hashCode();
    }

    public String toString() {
        return "Unilever(email=" + this.email + ')';
    }

    public Unilever(Email email2) {
        Intrinsics.checkNotNullParameter(email2, "email");
        this.email = email2;
    }

    public final Email getEmail() {
        return this.email;
    }
}
