package com.blueair.core.model;

import com.squareup.moshi.Json;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u0011"}, d2 = {"Lcom/blueair/core/model/UserInfoExtras;", "", "chinaPrivacyConsentVersion", "", "<init>", "(I)V", "getChinaPrivacyConsentVersion", "()I", "setChinaPrivacyConsentVersion", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: UserInfoCollections.kt */
public final class UserInfoExtras {
    private int chinaPrivacyConsentVersion;

    public UserInfoExtras() {
        this(0, 1, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ UserInfoExtras copy$default(UserInfoExtras userInfoExtras, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = userInfoExtras.chinaPrivacyConsentVersion;
        }
        return userInfoExtras.copy(i);
    }

    public final int component1() {
        return this.chinaPrivacyConsentVersion;
    }

    public final UserInfoExtras copy(@Json(name = "china_privacy_consent_version") int i) {
        return new UserInfoExtras(i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof UserInfoExtras) && this.chinaPrivacyConsentVersion == ((UserInfoExtras) obj).chinaPrivacyConsentVersion;
    }

    public int hashCode() {
        return this.chinaPrivacyConsentVersion;
    }

    public String toString() {
        return "UserInfoExtras(chinaPrivacyConsentVersion=" + this.chinaPrivacyConsentVersion + ')';
    }

    public UserInfoExtras(@Json(name = "china_privacy_consent_version") int i) {
        this.chinaPrivacyConsentVersion = i;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UserInfoExtras(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i);
    }

    public final int getChinaPrivacyConsentVersion() {
        return this.chinaPrivacyConsentVersion;
    }

    public final void setChinaPrivacyConsentVersion(int i) {
        this.chinaPrivacyConsentVersion = i;
    }
}
