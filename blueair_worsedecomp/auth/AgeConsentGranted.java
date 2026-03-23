package com.blueair.auth;

import com.blueair.adddevice.model.AddDeviceState$$ExternalSyntheticBackport0;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/blueair/auth/AgeConsentGranted;", "", "isConsentGranted", "", "<init>", "(Z)V", "()Z", "component1", "copy", "equals", "other", "hashCode", "", "toString", "", "auth_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: GigyaService.kt */
final class AgeConsentGranted {
    private final boolean isConsentGranted;

    public static /* synthetic */ AgeConsentGranted copy$default(AgeConsentGranted ageConsentGranted, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = ageConsentGranted.isConsentGranted;
        }
        return ageConsentGranted.copy(z);
    }

    public final boolean component1() {
        return this.isConsentGranted;
    }

    public final AgeConsentGranted copy(boolean z) {
        return new AgeConsentGranted(z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AgeConsentGranted) && this.isConsentGranted == ((AgeConsentGranted) obj).isConsentGranted;
    }

    public int hashCode() {
        return AddDeviceState$$ExternalSyntheticBackport0.m(this.isConsentGranted);
    }

    public String toString() {
        return "AgeConsentGranted(isConsentGranted=" + this.isConsentGranted + ')';
    }

    public AgeConsentGranted(boolean z) {
        this.isConsentGranted = z;
    }

    public final boolean isConsentGranted() {
        return this.isConsentGranted;
    }
}
