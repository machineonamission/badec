package com.blueair.sdk;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001BQ\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÆ\u0003J\t\u0010 \u001a\u00020\u0007HÆ\u0003J\t\u0010!\u001a\u00020\u0007HÆ\u0003J\t\u0010\"\u001a\u00020\u0007HÆ\u0003Je\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u0007HÆ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020\u0007HÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0011\u0010\f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014¨\u0006)"}, d2 = {"Lcom/blueair/sdk/KlaviyoProfileData;", "", "gigyaUid", "", "email", "language", "filterReplacement", "", "quickAlarmStop", "cleaningReminders", "waterLevel", "marketingNotifications", "transactionalNotifications", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIIIII)V", "getGigyaUid", "()Ljava/lang/String;", "getEmail", "getLanguage", "getFilterReplacement", "()I", "getQuickAlarmStop", "getCleaningReminders", "getWaterLevel", "getMarketingNotifications", "getTransactionalNotifications", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "sdk_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: KlaviyoProfileData.kt */
public final class KlaviyoProfileData {
    private final int cleaningReminders;
    private final String email;
    private final int filterReplacement;
    private final String gigyaUid;
    private final String language;
    private final int marketingNotifications;
    private final int quickAlarmStop;
    private final int transactionalNotifications;
    private final int waterLevel;

    public static /* synthetic */ KlaviyoProfileData copy$default(KlaviyoProfileData klaviyoProfileData, String str, String str2, String str3, int i, int i2, int i3, int i4, int i5, int i6, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            str = klaviyoProfileData.gigyaUid;
        }
        if ((i7 & 2) != 0) {
            str2 = klaviyoProfileData.email;
        }
        if ((i7 & 4) != 0) {
            str3 = klaviyoProfileData.language;
        }
        if ((i7 & 8) != 0) {
            i = klaviyoProfileData.filterReplacement;
        }
        if ((i7 & 16) != 0) {
            i2 = klaviyoProfileData.quickAlarmStop;
        }
        if ((i7 & 32) != 0) {
            i3 = klaviyoProfileData.cleaningReminders;
        }
        if ((i7 & 64) != 0) {
            i4 = klaviyoProfileData.waterLevel;
        }
        if ((i7 & 128) != 0) {
            i5 = klaviyoProfileData.marketingNotifications;
        }
        if ((i7 & 256) != 0) {
            i6 = klaviyoProfileData.transactionalNotifications;
        }
        int i8 = i5;
        int i9 = i6;
        int i10 = i3;
        int i11 = i4;
        int i12 = i;
        int i13 = i2;
        return klaviyoProfileData.copy(str, str2, str3, i12, i13, i10, i11, i8, i9);
    }

    public final String component1() {
        return this.gigyaUid;
    }

    public final String component2() {
        return this.email;
    }

    public final String component3() {
        return this.language;
    }

    public final int component4() {
        return this.filterReplacement;
    }

    public final int component5() {
        return this.quickAlarmStop;
    }

    public final int component6() {
        return this.cleaningReminders;
    }

    public final int component7() {
        return this.waterLevel;
    }

    public final int component8() {
        return this.marketingNotifications;
    }

    public final int component9() {
        return this.transactionalNotifications;
    }

    public final KlaviyoProfileData copy(String str, String str2, String str3, int i, int i2, int i3, int i4, int i5, int i6) {
        Intrinsics.checkNotNullParameter(str2, "email");
        Intrinsics.checkNotNullParameter(str3, "language");
        return new KlaviyoProfileData(str, str2, str3, i, i2, i3, i4, i5, i6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KlaviyoProfileData)) {
            return false;
        }
        KlaviyoProfileData klaviyoProfileData = (KlaviyoProfileData) obj;
        return Intrinsics.areEqual((Object) this.gigyaUid, (Object) klaviyoProfileData.gigyaUid) && Intrinsics.areEqual((Object) this.email, (Object) klaviyoProfileData.email) && Intrinsics.areEqual((Object) this.language, (Object) klaviyoProfileData.language) && this.filterReplacement == klaviyoProfileData.filterReplacement && this.quickAlarmStop == klaviyoProfileData.quickAlarmStop && this.cleaningReminders == klaviyoProfileData.cleaningReminders && this.waterLevel == klaviyoProfileData.waterLevel && this.marketingNotifications == klaviyoProfileData.marketingNotifications && this.transactionalNotifications == klaviyoProfileData.transactionalNotifications;
    }

    public int hashCode() {
        String str = this.gigyaUid;
        return ((((((((((((((((str == null ? 0 : str.hashCode()) * 31) + this.email.hashCode()) * 31) + this.language.hashCode()) * 31) + this.filterReplacement) * 31) + this.quickAlarmStop) * 31) + this.cleaningReminders) * 31) + this.waterLevel) * 31) + this.marketingNotifications) * 31) + this.transactionalNotifications;
    }

    public String toString() {
        return "KlaviyoProfileData(gigyaUid=" + this.gigyaUid + ", email=" + this.email + ", language=" + this.language + ", filterReplacement=" + this.filterReplacement + ", quickAlarmStop=" + this.quickAlarmStop + ", cleaningReminders=" + this.cleaningReminders + ", waterLevel=" + this.waterLevel + ", marketingNotifications=" + this.marketingNotifications + ", transactionalNotifications=" + this.transactionalNotifications + ')';
    }

    public KlaviyoProfileData(String str, String str2, String str3, int i, int i2, int i3, int i4, int i5, int i6) {
        Intrinsics.checkNotNullParameter(str2, "email");
        Intrinsics.checkNotNullParameter(str3, "language");
        this.gigyaUid = str;
        this.email = str2;
        this.language = str3;
        this.filterReplacement = i;
        this.quickAlarmStop = i2;
        this.cleaningReminders = i3;
        this.waterLevel = i4;
        this.marketingNotifications = i5;
        this.transactionalNotifications = i6;
    }

    public final String getGigyaUid() {
        return this.gigyaUid;
    }

    public final String getEmail() {
        return this.email;
    }

    public final String getLanguage() {
        return this.language;
    }

    public final int getFilterReplacement() {
        return this.filterReplacement;
    }

    public final int getQuickAlarmStop() {
        return this.quickAlarmStop;
    }

    public final int getCleaningReminders() {
        return this.cleaningReminders;
    }

    public final int getWaterLevel() {
        return this.waterLevel;
    }

    public final int getMarketingNotifications() {
        return this.marketingNotifications;
    }

    public final int getTransactionalNotifications() {
        return this.transactionalNotifications;
    }
}
