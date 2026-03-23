package com.blueair.core.model;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B[\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\f\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\nHÆ\u0003J\u000f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00050\fHÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u000fHÆ\u0003Jm\u0010)\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\f2\b\b\u0002\u0010\r\u001a\u00020\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÆ\u0001J\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010-\u001a\u00020\u0005HÖ\u0001J\t\u0010.\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\f¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u0006/"}, d2 = {"Lcom/blueair/core/model/LegacyDeviceSchedule;", "", "id", "", "userId", "", "uuid", "startTime", "endTime", "instructions", "Lcom/blueair/core/model/LegacyDeviceScheduleInstruction;", "daysOfWeek", "", "timeZone", "doOnEndInstructions", "Lcom/blueair/core/model/LegacyDeviceEndInstruction;", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/blueair/core/model/LegacyDeviceScheduleInstruction;Ljava/util/List;Ljava/lang/String;Lcom/blueair/core/model/LegacyDeviceEndInstruction;)V", "getId", "()Ljava/lang/String;", "getUserId", "()I", "getUuid", "getStartTime", "getEndTime", "getInstructions", "()Lcom/blueair/core/model/LegacyDeviceScheduleInstruction;", "getDaysOfWeek", "()Ljava/util/List;", "getTimeZone", "getDoOnEndInstructions", "()Lcom/blueair/core/model/LegacyDeviceEndInstruction;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: LegacyDeviceSchedule.kt */
public final class LegacyDeviceSchedule {
    private final List<Integer> daysOfWeek;
    private final LegacyDeviceEndInstruction doOnEndInstructions;
    private final String endTime;
    private final String id;
    private final LegacyDeviceScheduleInstruction instructions;
    private final String startTime;
    private final String timeZone;
    private final int userId;
    private final String uuid;

    public static /* synthetic */ LegacyDeviceSchedule copy$default(LegacyDeviceSchedule legacyDeviceSchedule, String str, int i, String str2, String str3, String str4, LegacyDeviceScheduleInstruction legacyDeviceScheduleInstruction, List<Integer> list, String str5, LegacyDeviceEndInstruction legacyDeviceEndInstruction, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = legacyDeviceSchedule.id;
        }
        if ((i2 & 2) != 0) {
            i = legacyDeviceSchedule.userId;
        }
        if ((i2 & 4) != 0) {
            str2 = legacyDeviceSchedule.uuid;
        }
        if ((i2 & 8) != 0) {
            str3 = legacyDeviceSchedule.startTime;
        }
        if ((i2 & 16) != 0) {
            str4 = legacyDeviceSchedule.endTime;
        }
        if ((i2 & 32) != 0) {
            legacyDeviceScheduleInstruction = legacyDeviceSchedule.instructions;
        }
        if ((i2 & 64) != 0) {
            list = legacyDeviceSchedule.daysOfWeek;
        }
        if ((i2 & 128) != 0) {
            str5 = legacyDeviceSchedule.timeZone;
        }
        if ((i2 & 256) != 0) {
            legacyDeviceEndInstruction = legacyDeviceSchedule.doOnEndInstructions;
        }
        String str6 = str5;
        LegacyDeviceEndInstruction legacyDeviceEndInstruction2 = legacyDeviceEndInstruction;
        LegacyDeviceScheduleInstruction legacyDeviceScheduleInstruction2 = legacyDeviceScheduleInstruction;
        List<Integer> list2 = list;
        String str7 = str3;
        String str8 = str4;
        return legacyDeviceSchedule.copy(str, i, str2, str7, str8, legacyDeviceScheduleInstruction2, list2, str6, legacyDeviceEndInstruction2);
    }

    public final String component1() {
        return this.id;
    }

    public final int component2() {
        return this.userId;
    }

    public final String component3() {
        return this.uuid;
    }

    public final String component4() {
        return this.startTime;
    }

    public final String component5() {
        return this.endTime;
    }

    public final LegacyDeviceScheduleInstruction component6() {
        return this.instructions;
    }

    public final List<Integer> component7() {
        return this.daysOfWeek;
    }

    public final String component8() {
        return this.timeZone;
    }

    public final LegacyDeviceEndInstruction component9() {
        return this.doOnEndInstructions;
    }

    public final LegacyDeviceSchedule copy(String str, int i, String str2, String str3, String str4, LegacyDeviceScheduleInstruction legacyDeviceScheduleInstruction, List<Integer> list, String str5, LegacyDeviceEndInstruction legacyDeviceEndInstruction) {
        Intrinsics.checkNotNullParameter(str2, "uuid");
        Intrinsics.checkNotNullParameter(str3, "startTime");
        String str6 = str4;
        Intrinsics.checkNotNullParameter(str6, SDKConstants.PARAM_END_TIME);
        LegacyDeviceScheduleInstruction legacyDeviceScheduleInstruction2 = legacyDeviceScheduleInstruction;
        Intrinsics.checkNotNullParameter(legacyDeviceScheduleInstruction2, "instructions");
        List<Integer> list2 = list;
        Intrinsics.checkNotNullParameter(list2, "daysOfWeek");
        String str7 = str5;
        Intrinsics.checkNotNullParameter(str7, RemoteConfigConstants.RequestFieldKey.TIME_ZONE);
        return new LegacyDeviceSchedule(str, i, str2, str3, str6, legacyDeviceScheduleInstruction2, list2, str7, legacyDeviceEndInstruction);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LegacyDeviceSchedule)) {
            return false;
        }
        LegacyDeviceSchedule legacyDeviceSchedule = (LegacyDeviceSchedule) obj;
        return Intrinsics.areEqual((Object) this.id, (Object) legacyDeviceSchedule.id) && this.userId == legacyDeviceSchedule.userId && Intrinsics.areEqual((Object) this.uuid, (Object) legacyDeviceSchedule.uuid) && Intrinsics.areEqual((Object) this.startTime, (Object) legacyDeviceSchedule.startTime) && Intrinsics.areEqual((Object) this.endTime, (Object) legacyDeviceSchedule.endTime) && Intrinsics.areEqual((Object) this.instructions, (Object) legacyDeviceSchedule.instructions) && Intrinsics.areEqual((Object) this.daysOfWeek, (Object) legacyDeviceSchedule.daysOfWeek) && Intrinsics.areEqual((Object) this.timeZone, (Object) legacyDeviceSchedule.timeZone) && Intrinsics.areEqual((Object) this.doOnEndInstructions, (Object) legacyDeviceSchedule.doOnEndInstructions);
    }

    public int hashCode() {
        String str = this.id;
        int i = 0;
        int hashCode = (((((((((((((((str == null ? 0 : str.hashCode()) * 31) + this.userId) * 31) + this.uuid.hashCode()) * 31) + this.startTime.hashCode()) * 31) + this.endTime.hashCode()) * 31) + this.instructions.hashCode()) * 31) + this.daysOfWeek.hashCode()) * 31) + this.timeZone.hashCode()) * 31;
        LegacyDeviceEndInstruction legacyDeviceEndInstruction = this.doOnEndInstructions;
        if (legacyDeviceEndInstruction != null) {
            i = legacyDeviceEndInstruction.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "LegacyDeviceSchedule(id=" + this.id + ", userId=" + this.userId + ", uuid=" + this.uuid + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", instructions=" + this.instructions + ", daysOfWeek=" + this.daysOfWeek + ", timeZone=" + this.timeZone + ", doOnEndInstructions=" + this.doOnEndInstructions + ')';
    }

    public LegacyDeviceSchedule(String str, int i, String str2, String str3, String str4, LegacyDeviceScheduleInstruction legacyDeviceScheduleInstruction, List<Integer> list, String str5, LegacyDeviceEndInstruction legacyDeviceEndInstruction) {
        Intrinsics.checkNotNullParameter(str2, "uuid");
        Intrinsics.checkNotNullParameter(str3, "startTime");
        Intrinsics.checkNotNullParameter(str4, SDKConstants.PARAM_END_TIME);
        Intrinsics.checkNotNullParameter(legacyDeviceScheduleInstruction, "instructions");
        Intrinsics.checkNotNullParameter(list, "daysOfWeek");
        Intrinsics.checkNotNullParameter(str5, RemoteConfigConstants.RequestFieldKey.TIME_ZONE);
        this.id = str;
        this.userId = i;
        this.uuid = str2;
        this.startTime = str3;
        this.endTime = str4;
        this.instructions = legacyDeviceScheduleInstruction;
        this.daysOfWeek = list;
        this.timeZone = str5;
        this.doOnEndInstructions = legacyDeviceEndInstruction;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LegacyDeviceSchedule(String str, int i, String str2, String str3, String str4, LegacyDeviceScheduleInstruction legacyDeviceScheduleInstruction, List list, String str5, LegacyDeviceEndInstruction legacyDeviceEndInstruction, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, str2, str3, str4, legacyDeviceScheduleInstruction, list, str5, (i2 & 256) != 0 ? null : legacyDeviceEndInstruction);
    }

    public final String getId() {
        return this.id;
    }

    public final int getUserId() {
        return this.userId;
    }

    public final String getUuid() {
        return this.uuid;
    }

    public final String getStartTime() {
        return this.startTime;
    }

    public final String getEndTime() {
        return this.endTime;
    }

    public final LegacyDeviceScheduleInstruction getInstructions() {
        return this.instructions;
    }

    public final List<Integer> getDaysOfWeek() {
        return this.daysOfWeek;
    }

    public final String getTimeZone() {
        return this.timeZone;
    }

    public final LegacyDeviceEndInstruction getDoOnEndInstructions() {
        return this.doOnEndInstructions;
    }
}
