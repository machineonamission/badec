package com.blueair.core.model;

import com.foobot.liblabclient.domain.JobInstruction;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/blueair/core/model/LegacyDeviceScheduleInstruction;", "", "attrName", "", "attrValue", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getAttrName", "()Ljava/lang/String;", "getAttrValue", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: LegacyDeviceScheduleInstruction.kt */
public final class LegacyDeviceScheduleInstruction {
    private final String attrName;
    private final String attrValue;

    public static /* synthetic */ LegacyDeviceScheduleInstruction copy$default(LegacyDeviceScheduleInstruction legacyDeviceScheduleInstruction, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = legacyDeviceScheduleInstruction.attrName;
        }
        if ((i & 2) != 0) {
            str2 = legacyDeviceScheduleInstruction.attrValue;
        }
        return legacyDeviceScheduleInstruction.copy(str, str2);
    }

    public final String component1() {
        return this.attrName;
    }

    public final String component2() {
        return this.attrValue;
    }

    public final LegacyDeviceScheduleInstruction copy(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, JobInstruction.PARAM_ATTR_NAME);
        Intrinsics.checkNotNullParameter(str2, JobInstruction.PARAM_ATTR_VALUE);
        return new LegacyDeviceScheduleInstruction(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LegacyDeviceScheduleInstruction)) {
            return false;
        }
        LegacyDeviceScheduleInstruction legacyDeviceScheduleInstruction = (LegacyDeviceScheduleInstruction) obj;
        return Intrinsics.areEqual((Object) this.attrName, (Object) legacyDeviceScheduleInstruction.attrName) && Intrinsics.areEqual((Object) this.attrValue, (Object) legacyDeviceScheduleInstruction.attrValue);
    }

    public int hashCode() {
        return (this.attrName.hashCode() * 31) + this.attrValue.hashCode();
    }

    public String toString() {
        return "LegacyDeviceScheduleInstruction(attrName=" + this.attrName + ", attrValue=" + this.attrValue + ')';
    }

    public LegacyDeviceScheduleInstruction(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, JobInstruction.PARAM_ATTR_NAME);
        Intrinsics.checkNotNullParameter(str2, JobInstruction.PARAM_ATTR_VALUE);
        this.attrName = str;
        this.attrValue = str2;
    }

    public final String getAttrName() {
        return this.attrName;
    }

    public final String getAttrValue() {
        return this.attrValue;
    }
}
