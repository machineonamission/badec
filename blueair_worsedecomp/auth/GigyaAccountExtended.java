package com.blueair.auth;

import com.gigya.android.sdk.GigyaDefinitions;
import com.gigya.android.sdk.account.models.GigyaAccount;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/blueair/auth/GigyaAccountExtended;", "Lcom/gigya/android/sdk/account/models/GigyaAccount;", "data", "Lcom/blueair/auth/GigyaAccountData;", "subscriptions", "Lcom/blueair/auth/SubscriptionsDto;", "<init>", "(Lcom/blueair/auth/GigyaAccountData;Lcom/blueair/auth/SubscriptionsDto;)V", "getData", "()Lcom/blueair/auth/GigyaAccountData;", "setData", "(Lcom/blueair/auth/GigyaAccountData;)V", "getSubscriptions", "()Lcom/blueair/auth/SubscriptionsDto;", "disabled", "", "getDisabled", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "auth_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: GigyaService.kt */
public final class GigyaAccountExtended extends GigyaAccount {
    private GigyaAccountData data;
    private final SubscriptionsDto subscriptions;

    public static /* synthetic */ GigyaAccountExtended copy$default(GigyaAccountExtended gigyaAccountExtended, GigyaAccountData gigyaAccountData, SubscriptionsDto subscriptionsDto, int i, Object obj) {
        if ((i & 1) != 0) {
            gigyaAccountData = gigyaAccountExtended.data;
        }
        if ((i & 2) != 0) {
            subscriptionsDto = gigyaAccountExtended.subscriptions;
        }
        return gigyaAccountExtended.copy(gigyaAccountData, subscriptionsDto);
    }

    public final GigyaAccountData component1() {
        return this.data;
    }

    public final SubscriptionsDto component2() {
        return this.subscriptions;
    }

    public final GigyaAccountExtended copy(GigyaAccountData gigyaAccountData, SubscriptionsDto subscriptionsDto) {
        Intrinsics.checkNotNullParameter(gigyaAccountData, "data");
        Intrinsics.checkNotNullParameter(subscriptionsDto, GigyaDefinitions.AccountIncludes.SUBSCRIPTIONS);
        return new GigyaAccountExtended(gigyaAccountData, subscriptionsDto);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GigyaAccountExtended)) {
            return false;
        }
        GigyaAccountExtended gigyaAccountExtended = (GigyaAccountExtended) obj;
        return Intrinsics.areEqual((Object) this.data, (Object) gigyaAccountExtended.data) && Intrinsics.areEqual((Object) this.subscriptions, (Object) gigyaAccountExtended.subscriptions);
    }

    public int hashCode() {
        return (this.data.hashCode() * 31) + this.subscriptions.hashCode();
    }

    public String toString() {
        return "GigyaAccountExtended(data=" + this.data + ", subscriptions=" + this.subscriptions + ')';
    }

    public final GigyaAccountData getData() {
        return this.data;
    }

    public final SubscriptionsDto getSubscriptions() {
        return this.subscriptions;
    }

    public final void setData(GigyaAccountData gigyaAccountData) {
        Intrinsics.checkNotNullParameter(gigyaAccountData, "<set-?>");
        this.data = gigyaAccountData;
    }

    public GigyaAccountExtended(GigyaAccountData gigyaAccountData, SubscriptionsDto subscriptionsDto) {
        Intrinsics.checkNotNullParameter(gigyaAccountData, "data");
        Intrinsics.checkNotNullParameter(subscriptionsDto, GigyaDefinitions.AccountIncludes.SUBSCRIPTIONS);
        this.data = gigyaAccountData;
        this.subscriptions = subscriptionsDto;
    }

    public final boolean getDisabled() {
        return Intrinsics.areEqual((Object) this.data.getAccountstatus(), (Object) "disable");
    }
}
