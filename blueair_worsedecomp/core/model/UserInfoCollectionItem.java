package com.blueair.core.model;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\tHÆ\u0003J\u000f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003JK\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020\tHÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0016¨\u0006)"}, d2 = {"Lcom/blueair/core/model/UserInfoCollectionItem;", "", "id", "", "name", "Lcom/blueair/core/model/I18nConfig;", "scenario", "usage", "omitted", "", "records", "", "Lcom/blueair/core/model/UserInfoCollectionRecord;", "<init>", "(Ljava/lang/String;Lcom/blueair/core/model/I18nConfig;Lcom/blueair/core/model/I18nConfig;Lcom/blueair/core/model/I18nConfig;ILjava/util/List;)V", "getId", "()Ljava/lang/String;", "getName", "()Lcom/blueair/core/model/I18nConfig;", "getScenario", "getUsage", "getOmitted", "()I", "setOmitted", "(I)V", "getRecords", "()Ljava/util/List;", "recordsCount", "getRecordsCount", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: UserInfoCollections.kt */
public final class UserInfoCollectionItem {
    private final String id;
    private final I18nConfig name;
    private int omitted;
    private final List<UserInfoCollectionRecord> records;
    private final I18nConfig scenario;
    private final I18nConfig usage;

    public static /* synthetic */ UserInfoCollectionItem copy$default(UserInfoCollectionItem userInfoCollectionItem, String str, I18nConfig i18nConfig, I18nConfig i18nConfig2, I18nConfig i18nConfig3, int i, List<UserInfoCollectionRecord> list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = userInfoCollectionItem.id;
        }
        if ((i2 & 2) != 0) {
            i18nConfig = userInfoCollectionItem.name;
        }
        if ((i2 & 4) != 0) {
            i18nConfig2 = userInfoCollectionItem.scenario;
        }
        if ((i2 & 8) != 0) {
            i18nConfig3 = userInfoCollectionItem.usage;
        }
        if ((i2 & 16) != 0) {
            i = userInfoCollectionItem.omitted;
        }
        if ((i2 & 32) != 0) {
            list = userInfoCollectionItem.records;
        }
        int i3 = i;
        List<UserInfoCollectionRecord> list2 = list;
        I18nConfig i18nConfig4 = i18nConfig3;
        I18nConfig i18nConfig5 = i18nConfig;
        return userInfoCollectionItem.copy(str, i18nConfig5, i18nConfig2, i18nConfig4, i3, list2);
    }

    public final String component1() {
        return this.id;
    }

    public final I18nConfig component2() {
        return this.name;
    }

    public final I18nConfig component3() {
        return this.scenario;
    }

    public final I18nConfig component4() {
        return this.usage;
    }

    public final int component5() {
        return this.omitted;
    }

    public final List<UserInfoCollectionRecord> component6() {
        return this.records;
    }

    public final UserInfoCollectionItem copy(String str, I18nConfig i18nConfig, I18nConfig i18nConfig2, I18nConfig i18nConfig3, int i, List<UserInfoCollectionRecord> list) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(i18nConfig, "name");
        Intrinsics.checkNotNullParameter(i18nConfig2, "scenario");
        Intrinsics.checkNotNullParameter(i18nConfig3, "usage");
        Intrinsics.checkNotNullParameter(list, "records");
        return new UserInfoCollectionItem(str, i18nConfig, i18nConfig2, i18nConfig3, i, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserInfoCollectionItem)) {
            return false;
        }
        UserInfoCollectionItem userInfoCollectionItem = (UserInfoCollectionItem) obj;
        return Intrinsics.areEqual((Object) this.id, (Object) userInfoCollectionItem.id) && Intrinsics.areEqual((Object) this.name, (Object) userInfoCollectionItem.name) && Intrinsics.areEqual((Object) this.scenario, (Object) userInfoCollectionItem.scenario) && Intrinsics.areEqual((Object) this.usage, (Object) userInfoCollectionItem.usage) && this.omitted == userInfoCollectionItem.omitted && Intrinsics.areEqual((Object) this.records, (Object) userInfoCollectionItem.records);
    }

    public int hashCode() {
        return (((((((((this.id.hashCode() * 31) + this.name.hashCode()) * 31) + this.scenario.hashCode()) * 31) + this.usage.hashCode()) * 31) + this.omitted) * 31) + this.records.hashCode();
    }

    public String toString() {
        return "UserInfoCollectionItem(id=" + this.id + ", name=" + this.name + ", scenario=" + this.scenario + ", usage=" + this.usage + ", omitted=" + this.omitted + ", records=" + this.records + ')';
    }

    public UserInfoCollectionItem(String str, I18nConfig i18nConfig, I18nConfig i18nConfig2, I18nConfig i18nConfig3, int i, List<UserInfoCollectionRecord> list) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(i18nConfig, "name");
        Intrinsics.checkNotNullParameter(i18nConfig2, "scenario");
        Intrinsics.checkNotNullParameter(i18nConfig3, "usage");
        Intrinsics.checkNotNullParameter(list, "records");
        this.id = str;
        this.name = i18nConfig;
        this.scenario = i18nConfig2;
        this.usage = i18nConfig3;
        this.omitted = i;
        this.records = list;
    }

    public final String getId() {
        return this.id;
    }

    public final I18nConfig getName() {
        return this.name;
    }

    public final I18nConfig getScenario() {
        return this.scenario;
    }

    public final I18nConfig getUsage() {
        return this.usage;
    }

    public final int getOmitted() {
        return this.omitted;
    }

    public final void setOmitted(int i) {
        this.omitted = i;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UserInfoCollectionItem(String str, I18nConfig i18nConfig, I18nConfig i18nConfig2, I18nConfig i18nConfig3, int i, List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i18nConfig, i18nConfig2, i18nConfig3, (i2 & 16) != 0 ? 0 : i, (i2 & 32) != 0 ? new ArrayList() : list);
    }

    public final List<UserInfoCollectionRecord> getRecords() {
        return this.records;
    }

    public final int getRecordsCount() {
        return this.omitted + this.records.size();
    }
}
