package com.blueair.auth;

import com.blueair.adddevice.model.AddDeviceState$$ExternalSyntheticBackport0;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0006\"\u0004\b\u0007\u0010\u0005¨\u0006\u0010"}, d2 = {"Lcom/blueair/auth/Email;", "", "isSubscribed", "", "<init>", "(Z)V", "()Z", "setSubscribed", "component1", "copy", "equals", "other", "hashCode", "", "toString", "", "auth_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: GigyaService.kt */
public final class Email {
    private boolean isSubscribed;

    public static /* synthetic */ Email copy$default(Email email, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = email.isSubscribed;
        }
        return email.copy(z);
    }

    public final boolean component1() {
        return this.isSubscribed;
    }

    public final Email copy(boolean z) {
        return new Email(z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Email) && this.isSubscribed == ((Email) obj).isSubscribed;
    }

    public int hashCode() {
        return AddDeviceState$$ExternalSyntheticBackport0.m(this.isSubscribed);
    }

    public String toString() {
        return "Email(isSubscribed=" + this.isSubscribed + ')';
    }

    public Email(boolean z) {
        this.isSubscribed = z;
    }

    public final boolean isSubscribed() {
        return this.isSubscribed;
    }

    public final void setSubscribed(boolean z) {
        this.isSubscribed = z;
    }
}
