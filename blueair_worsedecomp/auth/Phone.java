package com.blueair.auth;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/blueair/auth/Phone;", "", "number", "", "type", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getNumber", "()Ljava/lang/String;", "getType", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "auth_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: GigyaService.kt */
final class Phone {
    private final String number;
    private final String type;

    public static /* synthetic */ Phone copy$default(Phone phone, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = phone.number;
        }
        if ((i & 2) != 0) {
            str2 = phone.type;
        }
        return phone.copy(str, str2);
    }

    public final String component1() {
        return this.number;
    }

    public final String component2() {
        return this.type;
    }

    public final Phone copy(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "number");
        Intrinsics.checkNotNullParameter(str2, "type");
        return new Phone(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Phone)) {
            return false;
        }
        Phone phone = (Phone) obj;
        return Intrinsics.areEqual((Object) this.number, (Object) phone.number) && Intrinsics.areEqual((Object) this.type, (Object) phone.type);
    }

    public int hashCode() {
        return (this.number.hashCode() * 31) + this.type.hashCode();
    }

    public String toString() {
        return "Phone(number=" + this.number + ", type=" + this.type + ')';
    }

    public Phone(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "number");
        Intrinsics.checkNotNullParameter(str2, "type");
        this.number = str;
        this.type = str2;
    }

    public final String getNumber() {
        return this.number;
    }

    public final String getType() {
        return this.type;
    }
}
