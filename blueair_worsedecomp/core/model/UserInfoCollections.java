package com.blueair.core.model;

import com.squareup.moshi.Json;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u000e\b\u0001\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J9\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u000e\b\u0003\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/blueair/core/model/UserInfoCollections;", "", "version", "", "series", "extras", "Lcom/blueair/core/model/UserInfoExtras;", "collections", "", "Lcom/blueair/core/model/UserInfoCollectionGroup;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/blueair/core/model/UserInfoExtras;Ljava/util/List;)V", "getVersion", "()Ljava/lang/String;", "getSeries", "getExtras", "()Lcom/blueair/core/model/UserInfoExtras;", "getCollections", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: UserInfoCollections.kt */
public final class UserInfoCollections {
    private final List<UserInfoCollectionGroup> collections;
    private final UserInfoExtras extras;
    private final String series;
    private final String version;

    public static /* synthetic */ UserInfoCollections copy$default(UserInfoCollections userInfoCollections, String str, String str2, UserInfoExtras userInfoExtras, List<UserInfoCollectionGroup> list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = userInfoCollections.version;
        }
        if ((i & 2) != 0) {
            str2 = userInfoCollections.series;
        }
        if ((i & 4) != 0) {
            userInfoExtras = userInfoCollections.extras;
        }
        if ((i & 8) != 0) {
            list = userInfoCollections.collections;
        }
        return userInfoCollections.copy(str, str2, userInfoExtras, list);
    }

    public final String component1() {
        return this.version;
    }

    public final String component2() {
        return this.series;
    }

    public final UserInfoExtras component3() {
        return this.extras;
    }

    public final List<UserInfoCollectionGroup> component4() {
        return this.collections;
    }

    public final UserInfoCollections copy(String str, String str2, UserInfoExtras userInfoExtras, @Json(name = "user_info_collection") List<UserInfoCollectionGroup> list) {
        Intrinsics.checkNotNullParameter(str, "version");
        Intrinsics.checkNotNullParameter(str2, "series");
        Intrinsics.checkNotNullParameter(list, "collections");
        return new UserInfoCollections(str, str2, userInfoExtras, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserInfoCollections)) {
            return false;
        }
        UserInfoCollections userInfoCollections = (UserInfoCollections) obj;
        return Intrinsics.areEqual((Object) this.version, (Object) userInfoCollections.version) && Intrinsics.areEqual((Object) this.series, (Object) userInfoCollections.series) && Intrinsics.areEqual((Object) this.extras, (Object) userInfoCollections.extras) && Intrinsics.areEqual((Object) this.collections, (Object) userInfoCollections.collections);
    }

    public int hashCode() {
        int hashCode = ((this.version.hashCode() * 31) + this.series.hashCode()) * 31;
        UserInfoExtras userInfoExtras = this.extras;
        return ((hashCode + (userInfoExtras == null ? 0 : userInfoExtras.hashCode())) * 31) + this.collections.hashCode();
    }

    public String toString() {
        return "UserInfoCollections(version=" + this.version + ", series=" + this.series + ", extras=" + this.extras + ", collections=" + this.collections + ')';
    }

    public UserInfoCollections(String str, String str2, UserInfoExtras userInfoExtras, @Json(name = "user_info_collection") List<UserInfoCollectionGroup> list) {
        Intrinsics.checkNotNullParameter(str, "version");
        Intrinsics.checkNotNullParameter(str2, "series");
        Intrinsics.checkNotNullParameter(list, "collections");
        this.version = str;
        this.series = str2;
        this.extras = userInfoExtras;
        this.collections = list;
    }

    public final String getVersion() {
        return this.version;
    }

    public final String getSeries() {
        return this.series;
    }

    public final UserInfoExtras getExtras() {
        return this.extras;
    }

    public final List<UserInfoCollectionGroup> getCollections() {
        return this.collections;
    }
}
