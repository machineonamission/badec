package com.blueair.database.entity;

import com.blueair.adddevice.model.AddDeviceState$$ExternalSyntheticBackport0;
import com.blueair.core.model.DayOfWeek;
import com.blueair.core.model.DeviceSchedule;
import com.blueair.core.model.DeviceScheduleInstruction;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\"\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\b\b\u0018\u0000 82\u00020\u0001:\u00018Bu\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0006\u0010$\u001a\u00020%J\f\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\u000eJ\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\u000f\u0010-\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J\t\u0010.\u001a\u00020\fHÆ\u0003J\u000f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eHÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\u0011\u00101\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0001\u00103\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00032\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u00104\u001a\u00020\f2\b\u00105\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00106\u001a\u00020\u000fHÖ\u0001J\t\u00107\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0016R\u0019\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001cR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0016¨\u00069"}, d2 = {"Lcom/blueair/database/entity/DeviceScheduleEntity;", "", "deviceId", "", "scheduleId", "scheduleName", "startTime", "endTime", "instructions", "", "Lcom/blueair/database/entity/DeviceScheduleInstructionEntity;", "paused", "", "daysOfWeek", "", "", "timeZone", "endInstructions", "scheduleEndType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;ZLjava/util/Set;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getDeviceId", "()Ljava/lang/String;", "getScheduleId", "getScheduleName", "getStartTime", "getEndTime", "getInstructions", "()Ljava/util/List;", "getPaused", "()Z", "getDaysOfWeek", "()Ljava/util/Set;", "getTimeZone", "getEndInstructions", "getScheduleEndType", "toDeviceSchedule", "Lcom/blueair/core/model/DeviceSchedule;", "toDaysOfWeek", "Lcom/blueair/core/model/DayOfWeek;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", "other", "hashCode", "toString", "Companion", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceScheduleEntity.kt */
public final class DeviceScheduleEntity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String DEVICE_SCHEDULE_TABLE = "device_schedule_table";
    private final Set<Integer> daysOfWeek;
    private final String deviceId;
    private final List<DeviceScheduleInstructionEntity> endInstructions;
    private final String endTime;
    private final List<DeviceScheduleInstructionEntity> instructions;
    private final boolean paused;
    private final String scheduleEndType;
    private final String scheduleId;
    private final String scheduleName;
    private final String startTime;
    private final String timeZone;

    public static /* synthetic */ DeviceScheduleEntity copy$default(DeviceScheduleEntity deviceScheduleEntity, String str, String str2, String str3, String str4, String str5, List<DeviceScheduleInstructionEntity> list, boolean z, Set<Integer> set, String str6, List<DeviceScheduleInstructionEntity> list2, String str7, int i, Object obj) {
        if ((i & 1) != 0) {
            str = deviceScheduleEntity.deviceId;
        }
        if ((i & 2) != 0) {
            str2 = deviceScheduleEntity.scheduleId;
        }
        if ((i & 4) != 0) {
            str3 = deviceScheduleEntity.scheduleName;
        }
        if ((i & 8) != 0) {
            str4 = deviceScheduleEntity.startTime;
        }
        if ((i & 16) != 0) {
            str5 = deviceScheduleEntity.endTime;
        }
        if ((i & 32) != 0) {
            list = deviceScheduleEntity.instructions;
        }
        if ((i & 64) != 0) {
            z = deviceScheduleEntity.paused;
        }
        if ((i & 128) != 0) {
            set = deviceScheduleEntity.daysOfWeek;
        }
        if ((i & 256) != 0) {
            str6 = deviceScheduleEntity.timeZone;
        }
        if ((i & 512) != 0) {
            list2 = deviceScheduleEntity.endInstructions;
        }
        if ((i & 1024) != 0) {
            str7 = deviceScheduleEntity.scheduleEndType;
        }
        List<DeviceScheduleInstructionEntity> list3 = list2;
        String str8 = str7;
        Set<Integer> set2 = set;
        String str9 = str6;
        List<DeviceScheduleInstructionEntity> list4 = list;
        boolean z2 = z;
        String str10 = str4;
        String str11 = str5;
        return deviceScheduleEntity.copy(str, str2, str3, str10, str11, list4, z2, set2, str9, list3, str8);
    }

    public final String component1() {
        return this.deviceId;
    }

    public final List<DeviceScheduleInstructionEntity> component10() {
        return this.endInstructions;
    }

    public final String component11() {
        return this.scheduleEndType;
    }

    public final String component2() {
        return this.scheduleId;
    }

    public final String component3() {
        return this.scheduleName;
    }

    public final String component4() {
        return this.startTime;
    }

    public final String component5() {
        return this.endTime;
    }

    public final List<DeviceScheduleInstructionEntity> component6() {
        return this.instructions;
    }

    public final boolean component7() {
        return this.paused;
    }

    public final Set<Integer> component8() {
        return this.daysOfWeek;
    }

    public final String component9() {
        return this.timeZone;
    }

    public final DeviceScheduleEntity copy(String str, String str2, String str3, String str4, String str5, List<DeviceScheduleInstructionEntity> list, boolean z, Set<Integer> set, String str6, List<DeviceScheduleInstructionEntity> list2, String str7) {
        Intrinsics.checkNotNullParameter(str, DeviceDataEntity.DEVICE_ID);
        Intrinsics.checkNotNullParameter(str2, "scheduleId");
        String str8 = str3;
        Intrinsics.checkNotNullParameter(str8, "scheduleName");
        String str9 = str4;
        Intrinsics.checkNotNullParameter(str9, "startTime");
        String str10 = str5;
        Intrinsics.checkNotNullParameter(str10, SDKConstants.PARAM_END_TIME);
        List<DeviceScheduleInstructionEntity> list3 = list;
        Intrinsics.checkNotNullParameter(list3, "instructions");
        Set<Integer> set2 = set;
        Intrinsics.checkNotNullParameter(set2, "daysOfWeek");
        String str11 = str6;
        Intrinsics.checkNotNullParameter(str11, RemoteConfigConstants.RequestFieldKey.TIME_ZONE);
        return new DeviceScheduleEntity(str, str2, str8, str9, str10, list3, z, set2, str11, list2, str7);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceScheduleEntity)) {
            return false;
        }
        DeviceScheduleEntity deviceScheduleEntity = (DeviceScheduleEntity) obj;
        return Intrinsics.areEqual((Object) this.deviceId, (Object) deviceScheduleEntity.deviceId) && Intrinsics.areEqual((Object) this.scheduleId, (Object) deviceScheduleEntity.scheduleId) && Intrinsics.areEqual((Object) this.scheduleName, (Object) deviceScheduleEntity.scheduleName) && Intrinsics.areEqual((Object) this.startTime, (Object) deviceScheduleEntity.startTime) && Intrinsics.areEqual((Object) this.endTime, (Object) deviceScheduleEntity.endTime) && Intrinsics.areEqual((Object) this.instructions, (Object) deviceScheduleEntity.instructions) && this.paused == deviceScheduleEntity.paused && Intrinsics.areEqual((Object) this.daysOfWeek, (Object) deviceScheduleEntity.daysOfWeek) && Intrinsics.areEqual((Object) this.timeZone, (Object) deviceScheduleEntity.timeZone) && Intrinsics.areEqual((Object) this.endInstructions, (Object) deviceScheduleEntity.endInstructions) && Intrinsics.areEqual((Object) this.scheduleEndType, (Object) deviceScheduleEntity.scheduleEndType);
    }

    public int hashCode() {
        int hashCode = ((((((((((((((((this.deviceId.hashCode() * 31) + this.scheduleId.hashCode()) * 31) + this.scheduleName.hashCode()) * 31) + this.startTime.hashCode()) * 31) + this.endTime.hashCode()) * 31) + this.instructions.hashCode()) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.paused)) * 31) + this.daysOfWeek.hashCode()) * 31) + this.timeZone.hashCode()) * 31;
        List<DeviceScheduleInstructionEntity> list = this.endInstructions;
        int i = 0;
        int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
        String str = this.scheduleEndType;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "DeviceScheduleEntity(deviceId=" + this.deviceId + ", scheduleId=" + this.scheduleId + ", scheduleName=" + this.scheduleName + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", instructions=" + this.instructions + ", paused=" + this.paused + ", daysOfWeek=" + this.daysOfWeek + ", timeZone=" + this.timeZone + ", endInstructions=" + this.endInstructions + ", scheduleEndType=" + this.scheduleEndType + ')';
    }

    public DeviceScheduleEntity(String str, String str2, String str3, String str4, String str5, List<DeviceScheduleInstructionEntity> list, boolean z, Set<Integer> set, String str6, List<DeviceScheduleInstructionEntity> list2, String str7) {
        Intrinsics.checkNotNullParameter(str, DeviceDataEntity.DEVICE_ID);
        Intrinsics.checkNotNullParameter(str2, "scheduleId");
        Intrinsics.checkNotNullParameter(str3, "scheduleName");
        Intrinsics.checkNotNullParameter(str4, "startTime");
        Intrinsics.checkNotNullParameter(str5, SDKConstants.PARAM_END_TIME);
        Intrinsics.checkNotNullParameter(list, "instructions");
        Intrinsics.checkNotNullParameter(set, "daysOfWeek");
        Intrinsics.checkNotNullParameter(str6, RemoteConfigConstants.RequestFieldKey.TIME_ZONE);
        this.deviceId = str;
        this.scheduleId = str2;
        this.scheduleName = str3;
        this.startTime = str4;
        this.endTime = str5;
        this.instructions = list;
        this.paused = z;
        this.daysOfWeek = set;
        this.timeZone = str6;
        this.endInstructions = list2;
        this.scheduleEndType = str7;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final String getScheduleId() {
        return this.scheduleId;
    }

    public final String getScheduleName() {
        return this.scheduleName;
    }

    public final String getStartTime() {
        return this.startTime;
    }

    public final String getEndTime() {
        return this.endTime;
    }

    public final List<DeviceScheduleInstructionEntity> getInstructions() {
        return this.instructions;
    }

    public final boolean getPaused() {
        return this.paused;
    }

    public final Set<Integer> getDaysOfWeek() {
        return this.daysOfWeek;
    }

    public final String getTimeZone() {
        return this.timeZone;
    }

    public final List<DeviceScheduleInstructionEntity> getEndInstructions() {
        return this.endInstructions;
    }

    public final String getScheduleEndType() {
        return this.scheduleEndType;
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tJ\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000bR\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/blueair/database/entity/DeviceScheduleEntity$Companion;", "", "<init>", "()V", "DEVICE_SCHEDULE_TABLE", "", "fromDeviceSchedule", "Lcom/blueair/database/entity/DeviceScheduleEntity;", "deviceSchedule", "Lcom/blueair/core/model/DeviceSchedule;", "fromDaysOfWeek", "", "", "daysOfWeek", "Lcom/blueair/core/model/DayOfWeek;", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceScheduleEntity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DeviceScheduleEntity fromDeviceSchedule(DeviceSchedule deviceSchedule) {
            List list;
            Intrinsics.checkNotNullParameter(deviceSchedule, "deviceSchedule");
            String scheduleId = deviceSchedule.getScheduleId();
            String scheduleName = deviceSchedule.getScheduleName();
            if (scheduleId == null || scheduleName == null) {
                return null;
            }
            List<DeviceScheduleInstruction> endInstructions = deviceSchedule.getEndInstructions();
            if (endInstructions != null) {
                Iterable<DeviceScheduleInstruction> iterable = endInstructions;
                Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
                for (DeviceScheduleInstruction fromDeviceScheduleInstruction : iterable) {
                    arrayList.add(DeviceScheduleInstructionEntity.Companion.fromDeviceScheduleInstruction(fromDeviceScheduleInstruction));
                }
                list = (List) arrayList;
            } else {
                list = null;
            }
            String deviceId = deviceSchedule.getDeviceId();
            List list2 = list;
            String startTime = deviceSchedule.getStartTime();
            List list3 = list2;
            String endTime = deviceSchedule.getEndTime();
            Iterable<DeviceScheduleInstruction> instructions = deviceSchedule.getInstructions();
            Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(instructions, 10));
            for (DeviceScheduleInstruction fromDeviceScheduleInstruction2 : instructions) {
                arrayList2.add(DeviceScheduleInstructionEntity.Companion.fromDeviceScheduleInstruction(fromDeviceScheduleInstruction2));
            }
            return new DeviceScheduleEntity(deviceId, scheduleId, scheduleName, startTime, endTime, (List) arrayList2, deviceSchedule.getPaused(), fromDaysOfWeek(deviceSchedule.getDaysOfWeek()), deviceSchedule.getTimeZone(), (list3 == null || list3.size() != 0) ? list3 : null, deviceSchedule.getScheduleEndType());
        }

        public final Set<Integer> fromDaysOfWeek(Set<? extends DayOfWeek> set) {
            Intrinsics.checkNotNullParameter(set, "daysOfWeek");
            Set linkedHashSet = new LinkedHashSet();
            for (DayOfWeek dbValue : set) {
                linkedHashSet.add(Integer.valueOf(dbValue.getDbValue()));
            }
            return CollectionsKt.toSet(linkedHashSet);
        }
    }

    public final DeviceSchedule toDeviceSchedule() {
        List list;
        String str = this.scheduleId;
        String str2 = this.deviceId;
        String str3 = this.scheduleName;
        String str4 = this.startTime;
        String str5 = this.endTime;
        Iterable<DeviceScheduleInstructionEntity> iterable = this.instructions;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (DeviceScheduleInstructionEntity deviceScheduleInstruction : iterable) {
            arrayList.add(deviceScheduleInstruction.toDeviceScheduleInstruction());
        }
        List list2 = (List) arrayList;
        boolean z = this.paused;
        Set<DayOfWeek> daysOfWeek2 = toDaysOfWeek();
        String str6 = this.timeZone;
        List<DeviceScheduleInstructionEntity> list3 = this.endInstructions;
        if (list3 != null) {
            Iterable<DeviceScheduleInstructionEntity> iterable2 = list3;
            Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable2, 10));
            for (DeviceScheduleInstructionEntity deviceScheduleInstruction2 : iterable2) {
                arrayList2.add(deviceScheduleInstruction2.toDeviceScheduleInstruction());
            }
            list = (List) arrayList2;
        } else {
            list = null;
        }
        return new DeviceSchedule(str, str2, str3, str4, str5, list2, z, daysOfWeek2, str6, list, this.scheduleEndType);
    }

    public final Set<DayOfWeek> toDaysOfWeek() {
        Set linkedHashSet = new LinkedHashSet();
        for (Integer intValue : this.daysOfWeek) {
            linkedHashSet.add(DayOfWeek.Companion.getByDBValue(intValue.intValue()));
        }
        return CollectionsKt.toSet(CollectionsKt.filterNotNull(linkedHashSet));
    }
}
