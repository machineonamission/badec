package com.blueair.core.model;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J-\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/blueair/core/model/UserInfoCollectionGroup;", "", "id", "", "name", "Lcom/blueair/core/model/I18nConfig;", "items", "", "Lcom/blueair/core/model/UserInfoCollectionItem;", "<init>", "(Ljava/lang/String;Lcom/blueair/core/model/I18nConfig;Ljava/util/List;)V", "getId", "()Ljava/lang/String;", "getName", "()Lcom/blueair/core/model/I18nConfig;", "getItems", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: UserInfoCollections.kt */
public final class UserInfoCollectionGroup {
    private final String id;
    private final List<UserInfoCollectionItem> items;
    private final I18nConfig name;

    public static /* synthetic */ UserInfoCollectionGroup copy$default(UserInfoCollectionGroup userInfoCollectionGroup, String str, I18nConfig i18nConfig, List<UserInfoCollectionItem> list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = userInfoCollectionGroup.id;
        }
        if ((i & 2) != 0) {
            i18nConfig = userInfoCollectionGroup.name;
        }
        if ((i & 4) != 0) {
            list = userInfoCollectionGroup.items;
        }
        return userInfoCollectionGroup.copy(str, i18nConfig, list);
    }

    public final String component1() {
        return this.id;
    }

    public final I18nConfig component2() {
        return this.name;
    }

    public final List<UserInfoCollectionItem> component3() {
        return this.items;
    }

    public final UserInfoCollectionGroup copy(String str, I18nConfig i18nConfig, List<UserInfoCollectionItem> list) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(i18nConfig, "name");
        Intrinsics.checkNotNullParameter(list, FirebaseAnalytics.Param.ITEMS);
        return new UserInfoCollectionGroup(str, i18nConfig, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserInfoCollectionGroup)) {
            return false;
        }
        UserInfoCollectionGroup userInfoCollectionGroup = (UserInfoCollectionGroup) obj;
        return Intrinsics.areEqual((Object) this.id, (Object) userInfoCollectionGroup.id) && Intrinsics.areEqual((Object) this.name, (Object) userInfoCollectionGroup.name) && Intrinsics.areEqual((Object) this.items, (Object) userInfoCollectionGroup.items);
    }

    public int hashCode() {
        return (((this.id.hashCode() * 31) + this.name.hashCode()) * 31) + this.items.hashCode();
    }

    public String toString() {
        return "UserInfoCollectionGroup(id=" + this.id + ", name=" + this.name + ", items=" + this.items + ')';
    }

    public UserInfoCollectionGroup(String str, I18nConfig i18nConfig, List<UserInfoCollectionItem> list) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(i18nConfig, "name");
        Intrinsics.checkNotNullParameter(list, FirebaseAnalytics.Param.ITEMS);
        this.id = str;
        this.name = i18nConfig;
        this.items = list;
    }

    public final String getId() {
        return this.id;
    }

    public final I18nConfig getName() {
        return this.name;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UserInfoCollectionGroup(String str, I18nConfig i18nConfig, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i18nConfig, (i & 4) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final List<UserInfoCollectionItem> getItems() {
        return this.items;
    }
}
