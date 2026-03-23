package com.blueair.core.model;

import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/blueair/core/model/UserInfoGroup;", "", "id", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getId", "()Ljava/lang/String;", "USER_PROFILE", "USER_BEHAVIOR", "DEVICE_INFO", "NETWORK_INFO", "PURIFIER_INFO", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: UserInfoCollections.kt */
public enum UserInfoGroup {
    USER_PROFILE("user_profile"),
    USER_BEHAVIOR("user_behavior"),
    DEVICE_INFO(DeviceRequestsHelper.DEVICE_INFO_PARAM),
    NETWORK_INFO("network_info"),
    PURIFIER_INFO("purifier_info");
    
    private final String id;

    public static EnumEntries<UserInfoGroup> getEntries() {
        return $ENTRIES;
    }

    private UserInfoGroup(String str) {
        this.id = str;
    }

    public final String getId() {
        return this.id;
    }

    static {
        UserInfoGroup[] $values;
        $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
    }
}
