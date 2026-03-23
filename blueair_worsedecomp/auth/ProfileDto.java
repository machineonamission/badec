package com.blueair.auth;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J/\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/blueair/auth/ProfileDto;", "", "firstName", "", "lastName", "phones", "", "Lcom/blueair/auth/Phone;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getFirstName", "()Ljava/lang/String;", "getLastName", "getPhones", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "auth_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: GigyaService.kt */
final class ProfileDto {
    private final String firstName;
    private final String lastName;
    private final List<Phone> phones;

    public static /* synthetic */ ProfileDto copy$default(ProfileDto profileDto, String str, String str2, List<Phone> list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = profileDto.firstName;
        }
        if ((i & 2) != 0) {
            str2 = profileDto.lastName;
        }
        if ((i & 4) != 0) {
            list = profileDto.phones;
        }
        return profileDto.copy(str, str2, list);
    }

    public final String component1() {
        return this.firstName;
    }

    public final String component2() {
        return this.lastName;
    }

    public final List<Phone> component3() {
        return this.phones;
    }

    public final ProfileDto copy(String str, String str2, List<Phone> list) {
        Intrinsics.checkNotNullParameter(str, "firstName");
        Intrinsics.checkNotNullParameter(str2, "lastName");
        return new ProfileDto(str, str2, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProfileDto)) {
            return false;
        }
        ProfileDto profileDto = (ProfileDto) obj;
        return Intrinsics.areEqual((Object) this.firstName, (Object) profileDto.firstName) && Intrinsics.areEqual((Object) this.lastName, (Object) profileDto.lastName) && Intrinsics.areEqual((Object) this.phones, (Object) profileDto.phones);
    }

    public int hashCode() {
        int hashCode = ((this.firstName.hashCode() * 31) + this.lastName.hashCode()) * 31;
        List<Phone> list = this.phones;
        return hashCode + (list == null ? 0 : list.hashCode());
    }

    public String toString() {
        return "ProfileDto(firstName=" + this.firstName + ", lastName=" + this.lastName + ", phones=" + this.phones + ')';
    }

    public ProfileDto(String str, String str2, List<Phone> list) {
        Intrinsics.checkNotNullParameter(str, "firstName");
        Intrinsics.checkNotNullParameter(str2, "lastName");
        this.firstName = str;
        this.lastName = str2;
        this.phones = list;
    }

    public final String getFirstName() {
        return this.firstName;
    }

    public final String getLastName() {
        return this.lastName;
    }

    public final List<Phone> getPhones() {
        return this.phones;
    }
}
