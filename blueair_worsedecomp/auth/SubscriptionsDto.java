package com.blueair.auth;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/blueair/auth/SubscriptionsDto;", "", "optInOptOut", "Lcom/blueair/auth/OptInOptOut;", "<init>", "(Lcom/blueair/auth/OptInOptOut;)V", "getOptInOptOut", "()Lcom/blueair/auth/OptInOptOut;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "auth_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: GigyaService.kt */
public final class SubscriptionsDto {
    private final OptInOptOut optInOptOut;

    public SubscriptionsDto() {
        this((OptInOptOut) null, 1, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ SubscriptionsDto copy$default(SubscriptionsDto subscriptionsDto, OptInOptOut optInOptOut2, int i, Object obj) {
        if ((i & 1) != 0) {
            optInOptOut2 = subscriptionsDto.optInOptOut;
        }
        return subscriptionsDto.copy(optInOptOut2);
    }

    public final OptInOptOut component1() {
        return this.optInOptOut;
    }

    public final SubscriptionsDto copy(OptInOptOut optInOptOut2) {
        return new SubscriptionsDto(optInOptOut2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof SubscriptionsDto) && Intrinsics.areEqual((Object) this.optInOptOut, (Object) ((SubscriptionsDto) obj).optInOptOut);
    }

    public int hashCode() {
        OptInOptOut optInOptOut2 = this.optInOptOut;
        if (optInOptOut2 == null) {
            return 0;
        }
        return optInOptOut2.hashCode();
    }

    public String toString() {
        return "SubscriptionsDto(optInOptOut=" + this.optInOptOut + ')';
    }

    public SubscriptionsDto(OptInOptOut optInOptOut2) {
        this.optInOptOut = optInOptOut2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SubscriptionsDto(OptInOptOut optInOptOut2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new OptInOptOut(new BrandXxBh8488Eml(new Email(false)), new Unilever(new Email(false))) : optInOptOut2);
    }

    public final OptInOptOut getOptInOptOut() {
        return this.optInOptOut;
    }
}
