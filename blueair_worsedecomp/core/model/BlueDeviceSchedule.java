package com.blueair.core.model;

import com.blueair.adddevice.model.AddDeviceState$$ExternalSyntheticBackport0;
import com.squareup.moshi.Json;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b*\b\b\u0018\u00002\u00020\u0001B·\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0003\u0012\u0010\b\u0001\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t\u0012\b\b\u0001\u0010\u000b\u001a\u00020\f\u0012\u000e\b\u0001\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\t\u0012\b\b\u0003\u0010\u000e\u001a\u00020\u0003\u0012\u0010\b\u0003\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t\u0012\b\b\u0003\u0010\u0010\u001a\u00020\u0011\u0012\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0003\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t¢\u0006\u0004\b\u0015\u0010\u0016J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\u0011\u0010-\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tHÆ\u0003J\t\u0010.\u001a\u00020\fHÆ\u0003J\u000f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00030\tHÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\u0011\u00101\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tHÆ\u0003J\t\u00102\u001a\u00020\u0011HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u00105\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tHÆ\u0003J»\u0001\u00106\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0003\u0010\u0006\u001a\u00020\u00032\b\b\u0003\u0010\u0007\u001a\u00020\u00032\u0010\b\u0003\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t2\b\b\u0003\u0010\u000b\u001a\u00020\f2\u000e\b\u0003\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\b\b\u0003\u0010\u000e\u001a\u00020\u00032\u0010\b\u0003\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t2\b\b\u0003\u0010\u0010\u001a\u00020\u00112\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u00032\u0010\b\u0003\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tHÆ\u0001J\u0013\u00107\u001a\u00020\u00112\b\u00108\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00109\u001a\u00020\fHÖ\u0001J\t\u0010:\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0019\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\t¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001eR\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0018R\u0019\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001eR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010$R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0018R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0018R\u0019\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001e¨\u0006;"}, d2 = {"Lcom/blueair/core/model/BlueDeviceSchedule;", "", "deviceid", "", "scheduleid", "scheduleName", "scheduleStartTime", "scheduleEndTime", "scheduleMode", "", "Lcom/blueair/core/model/ScheduleMode;", "scheduleActive", "", "scheduleRepeatOn", "scheduleEndType", "scheduleEndCustomMode", "isNewScheduleName", "", "scheduleStartTimeLocal", "scheduleEndTimeLocal", "scheduleRepeatOnLocal", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;ILjava/util/List;Ljava/lang/String;Ljava/util/List;ZLjava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getDeviceid", "()Ljava/lang/String;", "getScheduleid", "getScheduleName", "getScheduleStartTime", "getScheduleEndTime", "getScheduleMode", "()Ljava/util/List;", "getScheduleActive", "()I", "getScheduleRepeatOn", "getScheduleEndType", "getScheduleEndCustomMode", "()Z", "getScheduleStartTimeLocal", "getScheduleEndTimeLocal", "getScheduleRepeatOnLocal", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "copy", "equals", "other", "hashCode", "toString", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: BlueDeviceSchedule.kt */
public final class BlueDeviceSchedule {
    private final String deviceid;
    private final boolean isNewScheduleName;
    private final int scheduleActive;
    private final List<ScheduleMode> scheduleEndCustomMode;
    private final String scheduleEndTime;
    private final String scheduleEndTimeLocal;
    private final String scheduleEndType;
    private final List<ScheduleMode> scheduleMode;
    private final String scheduleName;
    private final List<String> scheduleRepeatOn;
    private final List<String> scheduleRepeatOnLocal;
    private final String scheduleStartTime;
    private final String scheduleStartTimeLocal;
    private final String scheduleid;

    public static /* synthetic */ BlueDeviceSchedule copy$default(BlueDeviceSchedule blueDeviceSchedule, String str, String str2, String str3, String str4, String str5, List list, int i, List list2, String str6, List list3, boolean z, String str7, String str8, List list4, int i2, Object obj) {
        int i3 = i2;
        return blueDeviceSchedule.copy((i3 & 1) != 0 ? blueDeviceSchedule.deviceid : str, (i3 & 2) != 0 ? blueDeviceSchedule.scheduleid : str2, (i3 & 4) != 0 ? blueDeviceSchedule.scheduleName : str3, (i3 & 8) != 0 ? blueDeviceSchedule.scheduleStartTime : str4, (i3 & 16) != 0 ? blueDeviceSchedule.scheduleEndTime : str5, (i3 & 32) != 0 ? blueDeviceSchedule.scheduleMode : list, (i3 & 64) != 0 ? blueDeviceSchedule.scheduleActive : i, (i3 & 128) != 0 ? blueDeviceSchedule.scheduleRepeatOn : list2, (i3 & 256) != 0 ? blueDeviceSchedule.scheduleEndType : str6, (i3 & 512) != 0 ? blueDeviceSchedule.scheduleEndCustomMode : list3, (i3 & 1024) != 0 ? blueDeviceSchedule.isNewScheduleName : z, (i3 & 2048) != 0 ? blueDeviceSchedule.scheduleStartTimeLocal : str7, (i3 & 4096) != 0 ? blueDeviceSchedule.scheduleEndTimeLocal : str8, (i3 & 8192) != 0 ? blueDeviceSchedule.scheduleRepeatOnLocal : list4);
    }

    public final String component1() {
        return this.deviceid;
    }

    public final List<ScheduleMode> component10() {
        return this.scheduleEndCustomMode;
    }

    public final boolean component11() {
        return this.isNewScheduleName;
    }

    public final String component12() {
        return this.scheduleStartTimeLocal;
    }

    public final String component13() {
        return this.scheduleEndTimeLocal;
    }

    public final List<String> component14() {
        return this.scheduleRepeatOnLocal;
    }

    public final String component2() {
        return this.scheduleid;
    }

    public final String component3() {
        return this.scheduleName;
    }

    public final String component4() {
        return this.scheduleStartTime;
    }

    public final String component5() {
        return this.scheduleEndTime;
    }

    public final List<ScheduleMode> component6() {
        return this.scheduleMode;
    }

    public final int component7() {
        return this.scheduleActive;
    }

    public final List<String> component8() {
        return this.scheduleRepeatOn;
    }

    public final String component9() {
        return this.scheduleEndType;
    }

    public final BlueDeviceSchedule copy(String str, String str2, @Json(name = "schedule-name") String str3, @Json(name = "schedule-start-time") String str4, @Json(name = "schedule-end-time") String str5, @Json(name = "schedule-mode") List<ScheduleMode> list, @Json(name = "schedule-active") int i, @Json(name = "schedule-repeat-on") List<String> list2, @Json(name = "schedule-type") String str6, @Json(name = "schedule-custom-setting") List<ScheduleMode> list3, @Json(name = "schedule-name-is-new") boolean z, @Json(name = "schedule-start-time-local") String str7, @Json(name = "schedule-end-time-local") String str8, @Json(name = "schedule-repeat-on-local") List<String> list4) {
        String str9 = str;
        Intrinsics.checkNotNullParameter(str9, "deviceid");
        String str10 = str4;
        Intrinsics.checkNotNullParameter(str10, "scheduleStartTime");
        String str11 = str5;
        Intrinsics.checkNotNullParameter(str11, "scheduleEndTime");
        List<ScheduleMode> list5 = list;
        Intrinsics.checkNotNullParameter(list5, "scheduleMode");
        List<String> list6 = list2;
        Intrinsics.checkNotNullParameter(list6, "scheduleRepeatOn");
        String str12 = str6;
        Intrinsics.checkNotNullParameter(str12, "scheduleEndType");
        List<ScheduleMode> list7 = list3;
        Intrinsics.checkNotNullParameter(list7, "scheduleEndCustomMode");
        return new BlueDeviceSchedule(str9, str2, str3, str10, str11, list5, i, list6, str12, list7, z, str7, str8, list4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BlueDeviceSchedule)) {
            return false;
        }
        BlueDeviceSchedule blueDeviceSchedule = (BlueDeviceSchedule) obj;
        return Intrinsics.areEqual((Object) this.deviceid, (Object) blueDeviceSchedule.deviceid) && Intrinsics.areEqual((Object) this.scheduleid, (Object) blueDeviceSchedule.scheduleid) && Intrinsics.areEqual((Object) this.scheduleName, (Object) blueDeviceSchedule.scheduleName) && Intrinsics.areEqual((Object) this.scheduleStartTime, (Object) blueDeviceSchedule.scheduleStartTime) && Intrinsics.areEqual((Object) this.scheduleEndTime, (Object) blueDeviceSchedule.scheduleEndTime) && Intrinsics.areEqual((Object) this.scheduleMode, (Object) blueDeviceSchedule.scheduleMode) && this.scheduleActive == blueDeviceSchedule.scheduleActive && Intrinsics.areEqual((Object) this.scheduleRepeatOn, (Object) blueDeviceSchedule.scheduleRepeatOn) && Intrinsics.areEqual((Object) this.scheduleEndType, (Object) blueDeviceSchedule.scheduleEndType) && Intrinsics.areEqual((Object) this.scheduleEndCustomMode, (Object) blueDeviceSchedule.scheduleEndCustomMode) && this.isNewScheduleName == blueDeviceSchedule.isNewScheduleName && Intrinsics.areEqual((Object) this.scheduleStartTimeLocal, (Object) blueDeviceSchedule.scheduleStartTimeLocal) && Intrinsics.areEqual((Object) this.scheduleEndTimeLocal, (Object) blueDeviceSchedule.scheduleEndTimeLocal) && Intrinsics.areEqual((Object) this.scheduleRepeatOnLocal, (Object) blueDeviceSchedule.scheduleRepeatOnLocal);
    }

    public int hashCode() {
        int hashCode = this.deviceid.hashCode() * 31;
        String str = this.scheduleid;
        int i = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.scheduleName;
        int hashCode3 = (((((((((((((((((hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.scheduleStartTime.hashCode()) * 31) + this.scheduleEndTime.hashCode()) * 31) + this.scheduleMode.hashCode()) * 31) + this.scheduleActive) * 31) + this.scheduleRepeatOn.hashCode()) * 31) + this.scheduleEndType.hashCode()) * 31) + this.scheduleEndCustomMode.hashCode()) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.isNewScheduleName)) * 31;
        String str3 = this.scheduleStartTimeLocal;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.scheduleEndTimeLocal;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        List<String> list = this.scheduleRepeatOnLocal;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode5 + i;
    }

    public String toString() {
        return "BlueDeviceSchedule(deviceid=" + this.deviceid + ", scheduleid=" + this.scheduleid + ", scheduleName=" + this.scheduleName + ", scheduleStartTime=" + this.scheduleStartTime + ", scheduleEndTime=" + this.scheduleEndTime + ", scheduleMode=" + this.scheduleMode + ", scheduleActive=" + this.scheduleActive + ", scheduleRepeatOn=" + this.scheduleRepeatOn + ", scheduleEndType=" + this.scheduleEndType + ", scheduleEndCustomMode=" + this.scheduleEndCustomMode + ", isNewScheduleName=" + this.isNewScheduleName + ", scheduleStartTimeLocal=" + this.scheduleStartTimeLocal + ", scheduleEndTimeLocal=" + this.scheduleEndTimeLocal + ", scheduleRepeatOnLocal=" + this.scheduleRepeatOnLocal + ')';
    }

    public BlueDeviceSchedule(String str, String str2, @Json(name = "schedule-name") String str3, @Json(name = "schedule-start-time") String str4, @Json(name = "schedule-end-time") String str5, @Json(name = "schedule-mode") List<ScheduleMode> list, @Json(name = "schedule-active") int i, @Json(name = "schedule-repeat-on") List<String> list2, @Json(name = "schedule-type") String str6, @Json(name = "schedule-custom-setting") List<ScheduleMode> list3, @Json(name = "schedule-name-is-new") boolean z, @Json(name = "schedule-start-time-local") String str7, @Json(name = "schedule-end-time-local") String str8, @Json(name = "schedule-repeat-on-local") List<String> list4) {
        Intrinsics.checkNotNullParameter(str, "deviceid");
        Intrinsics.checkNotNullParameter(str4, "scheduleStartTime");
        Intrinsics.checkNotNullParameter(str5, "scheduleEndTime");
        Intrinsics.checkNotNullParameter(list, "scheduleMode");
        Intrinsics.checkNotNullParameter(list2, "scheduleRepeatOn");
        Intrinsics.checkNotNullParameter(str6, "scheduleEndType");
        Intrinsics.checkNotNullParameter(list3, "scheduleEndCustomMode");
        this.deviceid = str;
        this.scheduleid = str2;
        this.scheduleName = str3;
        this.scheduleStartTime = str4;
        this.scheduleEndTime = str5;
        this.scheduleMode = list;
        this.scheduleActive = i;
        this.scheduleRepeatOn = list2;
        this.scheduleEndType = str6;
        this.scheduleEndCustomMode = list3;
        this.isNewScheduleName = z;
        this.scheduleStartTimeLocal = str7;
        this.scheduleEndTimeLocal = str8;
        this.scheduleRepeatOnLocal = list4;
    }

    public final String getDeviceid() {
        return this.deviceid;
    }

    public final String getScheduleid() {
        return this.scheduleid;
    }

    public final String getScheduleName() {
        return this.scheduleName;
    }

    public final String getScheduleStartTime() {
        return this.scheduleStartTime;
    }

    public final String getScheduleEndTime() {
        return this.scheduleEndTime;
    }

    public final List<ScheduleMode> getScheduleMode() {
        return this.scheduleMode;
    }

    public final int getScheduleActive() {
        return this.scheduleActive;
    }

    public final List<String> getScheduleRepeatOn() {
        return this.scheduleRepeatOn;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ BlueDeviceSchedule(java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, java.util.List r24, int r25, java.util.List r26, java.lang.String r27, java.util.List r28, boolean r29, java.lang.String r30, java.lang.String r31, java.util.List r32, int r33, kotlin.jvm.internal.DefaultConstructorMarker r34) {
        /*
            r18 = this;
            r0 = r33
            r1 = r0 & 2
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r5 = r2
            goto L_0x000b
        L_0x0009:
            r5 = r20
        L_0x000b:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0013
            java.lang.String r1 = "previous"
            r12 = r1
            goto L_0x0015
        L_0x0013:
            r12 = r27
        L_0x0015:
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x001f
            java.util.List r1 = kotlin.collections.CollectionsKt.emptyList()
            r13 = r1
            goto L_0x0021
        L_0x001f:
            r13 = r28
        L_0x0021:
            r1 = r0 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x0028
            r1 = 0
            r14 = r1
            goto L_0x002a
        L_0x0028:
            r14 = r29
        L_0x002a:
            r1 = r0 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x0030
            r15 = r2
            goto L_0x0032
        L_0x0030:
            r15 = r30
        L_0x0032:
            r1 = r0 & 4096(0x1000, float:5.74E-42)
            if (r1 == 0) goto L_0x0039
            r16 = r2
            goto L_0x003b
        L_0x0039:
            r16 = r31
        L_0x003b:
            r0 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r0 == 0) goto L_0x0042
            r17 = r2
            goto L_0x0044
        L_0x0042:
            r17 = r32
        L_0x0044:
            r3 = r18
            r4 = r19
            r6 = r21
            r7 = r22
            r8 = r23
            r9 = r24
            r10 = r25
            r11 = r26
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.core.model.BlueDeviceSchedule.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.List, int, java.util.List, java.lang.String, java.util.List, boolean, java.lang.String, java.lang.String, java.util.List, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getScheduleEndType() {
        return this.scheduleEndType;
    }

    public final List<ScheduleMode> getScheduleEndCustomMode() {
        return this.scheduleEndCustomMode;
    }

    public final boolean isNewScheduleName() {
        return this.isNewScheduleName;
    }

    public final String getScheduleStartTimeLocal() {
        return this.scheduleStartTimeLocal;
    }

    public final String getScheduleEndTimeLocal() {
        return this.scheduleEndTimeLocal;
    }

    public final List<String> getScheduleRepeatOnLocal() {
        return this.scheduleRepeatOnLocal;
    }
}
