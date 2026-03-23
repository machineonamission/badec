package com.blueair.antifake.viewmodel;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/blueair/antifake/viewmodel/ResetResult;", "", "<init>", "(Ljava/lang/String;I)V", "SUCCESS", "INVALID_CODE", "DEVICE_MISMATCH", "DEVICE_OFFLINE", "INTERNAL_ERROR", "BLUETOOTH_FAILED", "Companion", "antifake_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: AntiFakeViewModel.kt */
public enum ResetResult {
    SUCCESS,
    INVALID_CODE,
    DEVICE_MISMATCH,
    DEVICE_OFFLINE,
    INTERNAL_ERROR,
    BLUETOOTH_FAILED;
    
    public static final Companion Companion = null;

    public static EnumEntries<ResetResult> getEntries() {
        return $ENTRIES;
    }

    static {
        ResetResult[] $values;
        $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/blueair/antifake/viewmodel/ResetResult$Companion;", "", "<init>", "()V", "fromStatusCode", "Lcom/blueair/antifake/viewmodel/ResetResult;", "code", "", "antifake_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AntiFakeViewModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ResetResult fromStatusCode(int i) {
            if (i == 0) {
                return ResetResult.SUCCESS;
            }
            if (i == 1) {
                return ResetResult.INVALID_CODE;
            }
            if (i == 2) {
                return ResetResult.DEVICE_MISMATCH;
            }
            if (i != 3) {
                return ResetResult.INTERNAL_ERROR;
            }
            return ResetResult.DEVICE_OFFLINE;
        }
    }
}
