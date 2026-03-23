package com.blueair.auth;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/blueair/auth/LogoutReason;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "USER_LOGOUT", "ACCOUNT_DISABLED", "ACCOUNT_DELETED", "REGION_MISMATCH", "GIGYA_SESSION_INVALID", "auth_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: LogOutService.kt */
public enum LogoutReason {
    USER_LOGOUT("user_logout"),
    ACCOUNT_DISABLED("account_disabled"),
    ACCOUNT_DELETED("account_deleted"),
    REGION_MISMATCH("region_mismatch"),
    GIGYA_SESSION_INVALID("gigya_session_invalid");
    
    private final String value;

    public static EnumEntries<LogoutReason> getEntries() {
        return $ENTRIES;
    }

    private LogoutReason(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }

    static {
        LogoutReason[] $values;
        $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
    }
}
