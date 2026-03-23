package com.blueair.core.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.blueair.adddevice.model.AddDeviceState$$ExternalSyntheticBackport0;
import com.blueair.core.util.TimeUtils;
import com.blueair.database.entity.DeviceDataEntity;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 ?2\u00020\u0001:\u0001?B\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u000e\u0010$\u001a\u00020\f2\u0006\u0010%\u001a\u00020\u0000J\u0006\u0010&\u001a\u00020'J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\u000f\u0010-\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J\t\u0010.\u001a\u00020\fHÆ\u0003J\u000f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eHÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\u0011\u00101\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0001\u00103\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00032\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0006\u00104\u001a\u000205J\u0013\u00106\u001a\u00020\f2\b\u0010%\u001a\u0004\u0018\u000107HÖ\u0003J\t\u00108\u001a\u000205HÖ\u0001J\t\u00109\u001a\u00020\u0003HÖ\u0001J\u0016\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u000205R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0016R\u0019\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001cR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0016¨\u0006@"}, d2 = {"Lcom/blueair/core/model/DeviceSchedule;", "Landroid/os/Parcelable;", "scheduleId", "", "deviceId", "scheduleName", "startTime", "endTime", "instructions", "", "Lcom/blueair/core/model/DeviceScheduleInstruction;", "paused", "", "daysOfWeek", "", "Lcom/blueair/core/model/DayOfWeek;", "timeZone", "endInstructions", "scheduleEndType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;ZLjava/util/Set;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getScheduleId", "()Ljava/lang/String;", "getDeviceId", "getScheduleName", "getStartTime", "getEndTime", "getInstructions", "()Ljava/util/List;", "getPaused", "()Z", "getDaysOfWeek", "()Ljava/util/Set;", "getTimeZone", "getEndInstructions", "getScheduleEndType", "isSameTimeSchedule", "other", "toBlueDeviceSchedule", "Lcom/blueair/core/model/BlueDeviceSchedule;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "describeContents", "", "equals", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceSchedule.kt */
public final class DeviceSchedule implements Parcelable {
    public static final Parcelable.Creator<DeviceSchedule> CREATOR = new Creator();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final Set<DayOfWeek> daysOfWeek;
    private final String deviceId;
    private final List<DeviceScheduleInstruction> endInstructions;
    private final String endTime;
    private final List<DeviceScheduleInstruction> instructions;
    private final boolean paused;
    private final String scheduleEndType;
    private final String scheduleId;
    private final String scheduleName;
    private final String startTime;
    private final String timeZone;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceSchedule.kt */
    public static final class Creator implements Parcelable.Creator<DeviceSchedule> {
        public final DeviceSchedule createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            String readString5 = parcel.readString();
            int readInt = parcel.readInt();
            ArrayList arrayList2 = new ArrayList(readInt);
            for (int i = 0; i != readInt; i++) {
                arrayList2.add(DeviceScheduleInstruction.CREATOR.createFromParcel(parcel));
            }
            List list = arrayList2;
            boolean z = parcel.readInt() != 0;
            int readInt2 = parcel.readInt();
            LinkedHashSet linkedHashSet = new LinkedHashSet(readInt2);
            for (int i2 = 0; i2 != readInt2; i2++) {
                linkedHashSet.add(DayOfWeek.valueOf(parcel.readString()));
            }
            Set set = linkedHashSet;
            String readString6 = parcel.readString();
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int readInt3 = parcel.readInt();
                ArrayList arrayList3 = new ArrayList(readInt3);
                for (int i3 = 0; i3 != readInt3; i3++) {
                    arrayList3.add(DeviceScheduleInstruction.CREATOR.createFromParcel(parcel));
                }
                arrayList = arrayList3;
            }
            return new DeviceSchedule(readString, readString2, readString3, readString4, readString5, list, z, set, readString6, arrayList, parcel.readString());
        }

        public final DeviceSchedule[] newArray(int i) {
            return new DeviceSchedule[i];
        }
    }

    public static /* synthetic */ DeviceSchedule copy$default(DeviceSchedule deviceSchedule, String str, String str2, String str3, String str4, String str5, List<DeviceScheduleInstruction> list, boolean z, Set<DayOfWeek> set, String str6, List<DeviceScheduleInstruction> list2, String str7, int i, Object obj) {
        if ((i & 1) != 0) {
            str = deviceSchedule.scheduleId;
        }
        if ((i & 2) != 0) {
            str2 = deviceSchedule.deviceId;
        }
        if ((i & 4) != 0) {
            str3 = deviceSchedule.scheduleName;
        }
        if ((i & 8) != 0) {
            str4 = deviceSchedule.startTime;
        }
        if ((i & 16) != 0) {
            str5 = deviceSchedule.endTime;
        }
        if ((i & 32) != 0) {
            list = deviceSchedule.instructions;
        }
        if ((i & 64) != 0) {
            z = deviceSchedule.paused;
        }
        if ((i & 128) != 0) {
            set = deviceSchedule.daysOfWeek;
        }
        if ((i & 256) != 0) {
            str6 = deviceSchedule.timeZone;
        }
        if ((i & 512) != 0) {
            list2 = deviceSchedule.endInstructions;
        }
        if ((i & 1024) != 0) {
            str7 = deviceSchedule.scheduleEndType;
        }
        List<DeviceScheduleInstruction> list3 = list2;
        String str8 = str7;
        Set<DayOfWeek> set2 = set;
        String str9 = str6;
        List<DeviceScheduleInstruction> list4 = list;
        boolean z2 = z;
        String str10 = str4;
        String str11 = str5;
        return deviceSchedule.copy(str, str2, str3, str10, str11, list4, z2, set2, str9, list3, str8);
    }

    public final String component1() {
        return this.scheduleId;
    }

    public final List<DeviceScheduleInstruction> component10() {
        return this.endInstructions;
    }

    public final String component11() {
        return this.scheduleEndType;
    }

    public final String component2() {
        return this.deviceId;
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

    public final List<DeviceScheduleInstruction> component6() {
        return this.instructions;
    }

    public final boolean component7() {
        return this.paused;
    }

    public final Set<DayOfWeek> component8() {
        return this.daysOfWeek;
    }

    public final String component9() {
        return this.timeZone;
    }

    public final DeviceSchedule copy(String str, String str2, String str3, String str4, String str5, List<DeviceScheduleInstruction> list, boolean z, Set<? extends DayOfWeek> set, String str6, List<DeviceScheduleInstruction> list2, String str7) {
        Intrinsics.checkNotNullParameter(str2, DeviceDataEntity.DEVICE_ID);
        String str8 = str4;
        Intrinsics.checkNotNullParameter(str8, "startTime");
        String str9 = str5;
        Intrinsics.checkNotNullParameter(str9, SDKConstants.PARAM_END_TIME);
        List<DeviceScheduleInstruction> list3 = list;
        Intrinsics.checkNotNullParameter(list3, "instructions");
        Set<? extends DayOfWeek> set2 = set;
        Intrinsics.checkNotNullParameter(set2, "daysOfWeek");
        String str10 = str6;
        Intrinsics.checkNotNullParameter(str10, RemoteConfigConstants.RequestFieldKey.TIME_ZONE);
        return new DeviceSchedule(str, str2, str3, str8, str9, list3, z, set2, str10, list2, str7);
    }

    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceSchedule)) {
            return false;
        }
        DeviceSchedule deviceSchedule = (DeviceSchedule) obj;
        return Intrinsics.areEqual((Object) this.scheduleId, (Object) deviceSchedule.scheduleId) && Intrinsics.areEqual((Object) this.deviceId, (Object) deviceSchedule.deviceId) && Intrinsics.areEqual((Object) this.scheduleName, (Object) deviceSchedule.scheduleName) && Intrinsics.areEqual((Object) this.startTime, (Object) deviceSchedule.startTime) && Intrinsics.areEqual((Object) this.endTime, (Object) deviceSchedule.endTime) && Intrinsics.areEqual((Object) this.instructions, (Object) deviceSchedule.instructions) && this.paused == deviceSchedule.paused && Intrinsics.areEqual((Object) this.daysOfWeek, (Object) deviceSchedule.daysOfWeek) && Intrinsics.areEqual((Object) this.timeZone, (Object) deviceSchedule.timeZone) && Intrinsics.areEqual((Object) this.endInstructions, (Object) deviceSchedule.endInstructions) && Intrinsics.areEqual((Object) this.scheduleEndType, (Object) deviceSchedule.scheduleEndType);
    }

    public int hashCode() {
        String str = this.scheduleId;
        int i = 0;
        int hashCode = (((str == null ? 0 : str.hashCode()) * 31) + this.deviceId.hashCode()) * 31;
        String str2 = this.scheduleName;
        int hashCode2 = (((((((((((((hashCode + (str2 == null ? 0 : str2.hashCode())) * 31) + this.startTime.hashCode()) * 31) + this.endTime.hashCode()) * 31) + this.instructions.hashCode()) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.paused)) * 31) + this.daysOfWeek.hashCode()) * 31) + this.timeZone.hashCode()) * 31;
        List<DeviceScheduleInstruction> list = this.endInstructions;
        int hashCode3 = (hashCode2 + (list == null ? 0 : list.hashCode())) * 31;
        String str3 = this.scheduleEndType;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "DeviceSchedule(scheduleId=" + this.scheduleId + ", deviceId=" + this.deviceId + ", scheduleName=" + this.scheduleName + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", instructions=" + this.instructions + ", paused=" + this.paused + ", daysOfWeek=" + this.daysOfWeek + ", timeZone=" + this.timeZone + ", endInstructions=" + this.endInstructions + ", scheduleEndType=" + this.scheduleEndType + ')';
    }

    public final void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeString(this.scheduleId);
        parcel.writeString(this.deviceId);
        parcel.writeString(this.scheduleName);
        parcel.writeString(this.startTime);
        parcel.writeString(this.endTime);
        List<DeviceScheduleInstruction> list = this.instructions;
        parcel.writeInt(list.size());
        for (DeviceScheduleInstruction writeToParcel : list) {
            writeToParcel.writeToParcel(parcel, i);
        }
        parcel.writeInt(this.paused ? 1 : 0);
        Set<DayOfWeek> set = this.daysOfWeek;
        parcel.writeInt(set.size());
        for (DayOfWeek name : set) {
            parcel.writeString(name.name());
        }
        parcel.writeString(this.timeZone);
        List<DeviceScheduleInstruction> list2 = this.endInstructions;
        if (list2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(list2.size());
            for (DeviceScheduleInstruction writeToParcel2 : list2) {
                writeToParcel2.writeToParcel(parcel, i);
            }
        }
        parcel.writeString(this.scheduleEndType);
    }

    public DeviceSchedule(String str, String str2, String str3, String str4, String str5, List<DeviceScheduleInstruction> list, boolean z, Set<? extends DayOfWeek> set, String str6, List<DeviceScheduleInstruction> list2, String str7) {
        Intrinsics.checkNotNullParameter(str2, DeviceDataEntity.DEVICE_ID);
        Intrinsics.checkNotNullParameter(str4, "startTime");
        Intrinsics.checkNotNullParameter(str5, SDKConstants.PARAM_END_TIME);
        Intrinsics.checkNotNullParameter(list, "instructions");
        Intrinsics.checkNotNullParameter(set, "daysOfWeek");
        Intrinsics.checkNotNullParameter(str6, RemoteConfigConstants.RequestFieldKey.TIME_ZONE);
        this.scheduleId = str;
        this.deviceId = str2;
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

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ DeviceSchedule(java.lang.String r2, java.lang.String r3, java.lang.String r4, java.lang.String r5, java.lang.String r6, java.util.List r7, boolean r8, java.util.Set r9, java.lang.String r10, java.util.List r11, java.lang.String r12, int r13, kotlin.jvm.internal.DefaultConstructorMarker r14) {
        /*
            r1 = this;
            r14 = r13 & 1
            r0 = 0
            if (r14 == 0) goto L_0x0006
            r2 = r0
        L_0x0006:
            r14 = r13 & 4
            if (r14 == 0) goto L_0x000b
            r4 = r0
        L_0x000b:
            r13 = r13 & 1024(0x400, float:1.435E-42)
            if (r13 == 0) goto L_0x0011
            r13 = r0
            goto L_0x0012
        L_0x0011:
            r13 = r12
        L_0x0012:
            r12 = r11
            r11 = r10
            r10 = r9
            r9 = r8
            r8 = r7
            r7 = r6
            r6 = r5
            r5 = r4
            r4 = r3
            r3 = r2
            r2 = r1
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.core.model.DeviceSchedule.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.List, boolean, java.util.Set, java.lang.String, java.util.List, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getScheduleId() {
        return this.scheduleId;
    }

    public final String getDeviceId() {
        return this.deviceId;
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

    public final List<DeviceScheduleInstruction> getInstructions() {
        return this.instructions;
    }

    public final boolean getPaused() {
        return this.paused;
    }

    public final Set<DayOfWeek> getDaysOfWeek() {
        return this.daysOfWeek;
    }

    public final String getTimeZone() {
        return this.timeZone;
    }

    public final List<DeviceScheduleInstruction> getEndInstructions() {
        return this.endInstructions;
    }

    public final String getScheduleEndType() {
        return this.scheduleEndType;
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\r\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u000e¨\u0006\u000f"}, d2 = {"Lcom/blueair/core/model/DeviceSchedule$Companion;", "", "<init>", "()V", "toLegacy", "", "Lcom/blueair/core/model/LegacyDeviceSchedule;", "schedule", "Lcom/blueair/core/model/DeviceSchedule;", "userId", "", "(Lcom/blueair/core/model/DeviceSchedule;Ljava/lang/Integer;)Ljava/util/List;", "fromLegacy", "fromBlueDeviceSchedule", "Lcom/blueair/core/model/BlueDeviceSchedule;", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceSchedule.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ List toLegacy$default(Companion companion, DeviceSchedule deviceSchedule, Integer num, int i, Object obj) {
            if ((i & 2) != 0) {
                num = null;
            }
            return companion.toLegacy(deviceSchedule, num);
        }

        public final List<LegacyDeviceSchedule> toLegacy(DeviceSchedule deviceSchedule, Integer num) {
            DeviceSchedule deviceSchedule2 = deviceSchedule;
            Intrinsics.checkNotNullParameter(deviceSchedule2, "schedule");
            List<LegacyDeviceSchedule> arrayList = new ArrayList<>();
            int size = deviceSchedule2.getInstructions().size();
            for (int i = 0; i < size; i++) {
                DeviceScheduleInstruction deviceScheduleInstruction = deviceSchedule2.getInstructions().get(i);
                List<DeviceScheduleInstruction> endInstructions = deviceSchedule2.getEndInstructions();
                LegacyDeviceEndInstruction legacyDeviceEndInstruction = null;
                DeviceScheduleInstruction deviceScheduleInstruction2 = endInstructions != null ? endInstructions.get(i) : null;
                if (deviceScheduleInstruction2 != null) {
                    legacyDeviceEndInstruction = LegacyDeviceEndInstruction.Companion.newInstance(deviceScheduleInstruction2);
                }
                LegacyDeviceEndInstruction legacyDeviceEndInstruction2 = legacyDeviceEndInstruction;
                String scheduleId = deviceSchedule2.getScheduleId();
                int intValue = num != null ? num.intValue() : 0;
                String deviceId = deviceSchedule2.getDeviceId();
                String startTime = deviceSchedule2.getStartTime();
                String endTime = deviceSchedule2.getEndTime();
                LegacyDeviceScheduleInstruction legacyDeviceScheduleInstruction = new LegacyDeviceScheduleInstruction(deviceScheduleInstruction.getName(), deviceScheduleInstruction.getValue());
                Iterable<DayOfWeek> daysOfWeek = deviceSchedule2.getDaysOfWeek();
                Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(daysOfWeek, 10));
                for (DayOfWeek ablValue : daysOfWeek) {
                    arrayList2.add(Integer.valueOf(ablValue.getAblValue()));
                }
                arrayList.add(new LegacyDeviceSchedule(scheduleId, intValue, deviceId, startTime, endTime, legacyDeviceScheduleInstruction, (List) arrayList2, deviceSchedule2.getTimeZone(), legacyDeviceEndInstruction2));
            }
            return arrayList;
        }

        public final DeviceSchedule fromLegacy(LegacyDeviceSchedule legacyDeviceSchedule) {
            LegacyDeviceSchedule legacyDeviceSchedule2 = legacyDeviceSchedule;
            Intrinsics.checkNotNullParameter(legacyDeviceSchedule2, "schedule");
            List listOf = CollectionsKt.listOf(DeviceScheduleInstruction.Companion.fromLegacy(legacyDeviceSchedule2.getInstructions()));
            List<DeviceScheduleInstruction> emptyList = CollectionsKt.emptyList();
            if (legacyDeviceSchedule2.getDoOnEndInstructions() != null) {
                emptyList = DeviceScheduleInstruction.Companion.fromLegacyToEndInstruction(legacyDeviceSchedule2.getDoOnEndInstructions());
            }
            List<DeviceScheduleInstruction> list = emptyList;
            String id = legacyDeviceSchedule2.getId();
            String uuid = legacyDeviceSchedule2.getUuid();
            String str = legacyDeviceSchedule2.getStartTime() + " - " + legacyDeviceSchedule2.getEndTime();
            String startTime = legacyDeviceSchedule2.getStartTime();
            String endTime = legacyDeviceSchedule2.getEndTime();
            Collection arrayList = new ArrayList();
            for (Number intValue : legacyDeviceSchedule2.getDaysOfWeek()) {
                DayOfWeek byAblValue = DayOfWeek.Companion.getByAblValue(intValue.intValue());
                if (byAblValue != null) {
                    arrayList.add(byAblValue);
                }
            }
            return new DeviceSchedule(id, uuid, str, startTime, endTime, listOf, false, CollectionsKt.toSet((List) arrayList), legacyDeviceSchedule2.getTimeZone(), list, (String) null, 1024, (DefaultConstructorMarker) null);
        }

        public final DeviceSchedule fromBlueDeviceSchedule(BlueDeviceSchedule blueDeviceSchedule) {
            List list;
            String str;
            String str2;
            Regex regex;
            BlueDeviceSchedule blueDeviceSchedule2 = blueDeviceSchedule;
            Intrinsics.checkNotNullParameter(blueDeviceSchedule2, "schedule");
            Collection arrayList = new ArrayList();
            for (ScheduleMode fromBlueDeviceSchedule : blueDeviceSchedule2.getScheduleMode()) {
                DeviceScheduleInstruction fromBlueDeviceSchedule2 = DeviceScheduleInstruction.Companion.fromBlueDeviceSchedule(fromBlueDeviceSchedule);
                if (fromBlueDeviceSchedule2 != null) {
                    arrayList.add(fromBlueDeviceSchedule2);
                }
            }
            List list2 = (List) arrayList;
            Collection arrayList2 = new ArrayList();
            for (ScheduleMode fromBlueDeviceSchedule3 : blueDeviceSchedule2.getScheduleEndCustomMode()) {
                DeviceScheduleInstruction fromBlueDeviceSchedule4 = DeviceScheduleInstruction.Companion.fromBlueDeviceSchedule(fromBlueDeviceSchedule3);
                if (fromBlueDeviceSchedule4 != null) {
                    arrayList2.add(fromBlueDeviceSchedule4);
                }
            }
            List list3 = (List) arrayList2;
            if (blueDeviceSchedule2.getScheduleStartTimeLocal() == null || blueDeviceSchedule2.getScheduleEndTimeLocal() == null || blueDeviceSchedule2.getScheduleRepeatOnLocal() == null) {
                str2 = TimeUtils.convertUTCTimeToLocalTime$default(TimeUtils.INSTANCE, blueDeviceSchedule2.getScheduleStartTime(), (TimeZone) null, 2, (Object) null);
                str = TimeUtils.convertUTCTimeToLocalTime$default(TimeUtils.INSTANCE, blueDeviceSchedule2.getScheduleEndTime(), (TimeZone) null, 2, (Object) null);
                int uTCtoLocalDateOffset = TimeUtils.INSTANCE.getUTCtoLocalDateOffset(blueDeviceSchedule2.getScheduleStartTime());
                Collection arrayList3 = new ArrayList();
                for (String byBlueValue : blueDeviceSchedule2.getScheduleRepeatOn()) {
                    DayOfWeek byBlueValue2 = DayOfWeek.Companion.getByBlueValue(byBlueValue);
                    DayOfWeek plusDays = byBlueValue2 != null ? byBlueValue2.plusDays(uTCtoLocalDateOffset) : null;
                    if (plusDays != null) {
                        arrayList3.add(plusDays);
                    }
                }
                list = (List) arrayList3;
            } else {
                str2 = blueDeviceSchedule2.getScheduleStartTimeLocal();
                str = blueDeviceSchedule2.getScheduleEndTimeLocal();
                Collection arrayList4 = new ArrayList();
                for (String byBlueValue3 : blueDeviceSchedule2.getScheduleRepeatOnLocal()) {
                    DayOfWeek byBlueValue4 = DayOfWeek.Companion.getByBlueValue(byBlueValue3);
                    if (byBlueValue4 != null) {
                        arrayList4.add(byBlueValue4);
                    }
                }
                list = (List) arrayList4;
            }
            String str3 = str2;
            String str4 = str;
            String str5 = "";
            if (blueDeviceSchedule2.getScheduleName() != null) {
                if (blueDeviceSchedule2.isNewScheduleName()) {
                    str5 = blueDeviceSchedule2.getScheduleName();
                } else {
                    if (blueDeviceSchedule2.getScheduleName().length() == 13) {
                        regex = new Regex(str3 + " - " + str4);
                    } else {
                        regex = new Regex(TimeUtils.INSTANCE.convert24HourTo12Hour(str3) + "( .+) - " + TimeUtils.INSTANCE.convert24HourTo12Hour(str4) + "( .+)");
                    }
                    if (!regex.matches(blueDeviceSchedule2.getScheduleName())) {
                        str5 = blueDeviceSchedule2.getScheduleName();
                    }
                }
            }
            String str6 = str5;
            List list4 = list;
            String scheduleid = blueDeviceSchedule2.getScheduleid();
            String deviceid = blueDeviceSchedule2.getDeviceid();
            boolean z = true;
            if (blueDeviceSchedule2.getScheduleActive() == 1) {
                z = false;
            }
            return new DeviceSchedule(scheduleid, deviceid, str6, str3, str4, list2, z, CollectionsKt.toSet(list4), "", list3, blueDeviceSchedule2.getScheduleEndType());
        }
    }

    public final boolean isSameTimeSchedule(DeviceSchedule deviceSchedule) {
        Intrinsics.checkNotNullParameter(deviceSchedule, "other");
        return Intrinsics.areEqual((Object) this.startTime, (Object) deviceSchedule.startTime) && Intrinsics.areEqual((Object) this.endTime, (Object) deviceSchedule.endTime) && Intrinsics.areEqual((Object) this.daysOfWeek, (Object) deviceSchedule.daysOfWeek) && Intrinsics.areEqual((Object) this.deviceId, (Object) deviceSchedule.deviceId);
    }

    public final BlueDeviceSchedule toBlueDeviceSchedule() {
        List list;
        int localToUTCDateOffset = TimeUtils.INSTANCE.getLocalToUTCDateOffset(this.startTime, this.timeZone);
        String str = this.deviceId;
        String str2 = this.scheduleId;
        String str3 = this.scheduleName;
        if (str3 == null) {
            str3 = this.startTime + " - " + this.endTime;
        }
        String str4 = str3;
        String convertLocalTimeToUTC = TimeUtils.INSTANCE.convertLocalTimeToUTC(this.startTime, this.timeZone);
        String convertLocalTimeToUTC2 = TimeUtils.INSTANCE.convertLocalTimeToUTC(this.endTime, this.timeZone);
        Iterable<DeviceScheduleInstruction> iterable = this.instructions;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (DeviceScheduleInstruction blueScheduleInstruction : iterable) {
            arrayList.add(blueScheduleInstruction.toBlueScheduleInstruction());
        }
        List list2 = (List) arrayList;
        boolean z = !this.paused;
        Iterable<DayOfWeek> iterable2 = this.daysOfWeek;
        Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable2, 10));
        for (DayOfWeek plusDays : iterable2) {
            arrayList2.add(plusDays.plusDays(localToUTCDateOffset).getBlueValue());
        }
        List list3 = (List) arrayList2;
        String str5 = this.scheduleEndType;
        if (str5 == null) {
            str5 = BlueDeviceScheduleEndType.PREVIOUS;
        }
        String str6 = str5;
        List<DeviceScheduleInstruction> list4 = this.endInstructions;
        if (list4 != null) {
            Iterable<DeviceScheduleInstruction> iterable3 = list4;
            Collection arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable3, 10));
            for (DeviceScheduleInstruction blueScheduleInstruction2 : iterable3) {
                arrayList3.add(blueScheduleInstruction2.toBlueScheduleInstruction());
            }
            list = (List) arrayList3;
        } else {
            list = CollectionsKt.emptyList();
        }
        return new BlueDeviceSchedule(str, str2, str4, convertLocalTimeToUTC, convertLocalTimeToUTC2, list2, z ? 1 : 0, list3, str6, list, true, (String) null, (String) null, (List<String>) null);
    }
}
