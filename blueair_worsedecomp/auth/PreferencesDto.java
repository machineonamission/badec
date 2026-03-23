package com.blueair.auth;

import com.facebook.share.internal.ShareConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/blueair/auth/PreferencesDto;", "", "cookies", "Lcom/blueair/auth/Cookies;", "privacy", "Lcom/blueair/auth/Privacy;", "ageConsentGranted", "Lcom/blueair/auth/AgeConsentGranted;", "<init>", "(Lcom/blueair/auth/Cookies;Lcom/blueair/auth/Privacy;Lcom/blueair/auth/AgeConsentGranted;)V", "getCookies", "()Lcom/blueair/auth/Cookies;", "getPrivacy", "()Lcom/blueair/auth/Privacy;", "getAgeConsentGranted", "()Lcom/blueair/auth/AgeConsentGranted;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "auth_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: GigyaService.kt */
final class PreferencesDto {
    private final AgeConsentGranted ageConsentGranted;
    private final Cookies cookies;
    private final Privacy privacy;

    public static /* synthetic */ PreferencesDto copy$default(PreferencesDto preferencesDto, Cookies cookies2, Privacy privacy2, AgeConsentGranted ageConsentGranted2, int i, Object obj) {
        if ((i & 1) != 0) {
            cookies2 = preferencesDto.cookies;
        }
        if ((i & 2) != 0) {
            privacy2 = preferencesDto.privacy;
        }
        if ((i & 4) != 0) {
            ageConsentGranted2 = preferencesDto.ageConsentGranted;
        }
        return preferencesDto.copy(cookies2, privacy2, ageConsentGranted2);
    }

    public final Cookies component1() {
        return this.cookies;
    }

    public final Privacy component2() {
        return this.privacy;
    }

    public final AgeConsentGranted component3() {
        return this.ageConsentGranted;
    }

    public final PreferencesDto copy(Cookies cookies2, Privacy privacy2, AgeConsentGranted ageConsentGranted2) {
        Intrinsics.checkNotNullParameter(cookies2, "cookies");
        Intrinsics.checkNotNullParameter(privacy2, ShareConstants.WEB_DIALOG_PARAM_PRIVACY);
        Intrinsics.checkNotNullParameter(ageConsentGranted2, "ageConsentGranted");
        return new PreferencesDto(cookies2, privacy2, ageConsentGranted2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PreferencesDto)) {
            return false;
        }
        PreferencesDto preferencesDto = (PreferencesDto) obj;
        return Intrinsics.areEqual((Object) this.cookies, (Object) preferencesDto.cookies) && Intrinsics.areEqual((Object) this.privacy, (Object) preferencesDto.privacy) && Intrinsics.areEqual((Object) this.ageConsentGranted, (Object) preferencesDto.ageConsentGranted);
    }

    public int hashCode() {
        return (((this.cookies.hashCode() * 31) + this.privacy.hashCode()) * 31) + this.ageConsentGranted.hashCode();
    }

    public String toString() {
        return "PreferencesDto(cookies=" + this.cookies + ", privacy=" + this.privacy + ", ageConsentGranted=" + this.ageConsentGranted + ')';
    }

    public PreferencesDto(Cookies cookies2, Privacy privacy2, AgeConsentGranted ageConsentGranted2) {
        Intrinsics.checkNotNullParameter(cookies2, "cookies");
        Intrinsics.checkNotNullParameter(privacy2, ShareConstants.WEB_DIALOG_PARAM_PRIVACY);
        Intrinsics.checkNotNullParameter(ageConsentGranted2, "ageConsentGranted");
        this.cookies = cookies2;
        this.privacy = privacy2;
        this.ageConsentGranted = ageConsentGranted2;
    }

    public final Cookies getCookies() {
        return this.cookies;
    }

    public final Privacy getPrivacy() {
        return this.privacy;
    }

    public final AgeConsentGranted getAgeConsentGranted() {
        return this.ageConsentGranted;
    }
}
