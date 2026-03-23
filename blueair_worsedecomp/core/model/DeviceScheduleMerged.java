package com.blueair.core.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.blueair.core.model.DeviceScheduleInstruction;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.security.CertificateUtil;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b(\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 n2\u00020\u0001:\u0001nB\u0017\b\u0002\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010Y\u001a\u0002032\u0006\u0010Z\u001a\u00020\u0000J\u0010\u0010[\u001a\u0004\u0018\u00010\\2\u0006\u0010]\u001a\u00020\nJ\u000e\u0010^\u001a\u00020_2\u0006\u0010`\u001a\u00020aJ\u000f\u0010b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010c\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0006\u0010d\u001a\u00020_J\u0013\u0010e\u001a\u0002032\b\u0010Z\u001a\u0004\u0018\u00010fHÖ\u0003J\t\u0010g\u001a\u00020_HÖ\u0001J\t\u0010h\u001a\u00020\nHÖ\u0001J\u0016\u0010i\u001a\u00020j2\u0006\u0010k\u001a\u00020l2\u0006\u0010m\u001a\u00020_R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR \u0010\t\u001a\u00020\nX\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R \u0010\u0011\u001a\u00020\nX\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0012\u0010\f\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010R \u0010\u0015\u001a\u00020\nX\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0016\u0010\f\u001a\u0004\b\u0017\u0010\u000e\"\u0004\b\u0018\u0010\u0010R&\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001c\u0010\f\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R \u0010!\u001a\u00020\nX\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\"\u0010\f\u001a\u0004\b#\u0010\u000e\"\u0004\b$\u0010\u0010R&\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u0003X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b'\u0010\f\u001a\u0004\b(\u0010\b\"\u0004\b)\u0010\u0006R&\u0010*\u001a\b\u0012\u0004\u0012\u00020&0\u0003X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b+\u0010\f\u001a\u0004\b,\u0010\b\"\u0004\b-\u0010\u0006R\"\u0010.\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b/\u0010\f\u001a\u0004\b0\u0010\u000e\"\u0004\b1\u0010\u0010R \u00102\u001a\u000203X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b4\u0010\f\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u0017\u00109\u001a\u0002038F¢\u0006\f\u0012\u0004\b:\u0010\f\u001a\u0004\b9\u00106R\u0017\u0010;\u001a\u0002038F¢\u0006\f\u0012\u0004\b<\u0010\f\u001a\u0004\b;\u00106R\u0017\u0010=\u001a\u0002038F¢\u0006\f\u0012\u0004\b>\u0010\f\u001a\u0004\b=\u00106R\u0017\u0010?\u001a\u0002038F¢\u0006\f\u0012\u0004\b@\u0010\f\u001a\u0004\b?\u00106R\u0017\u0010A\u001a\u0002038F¢\u0006\f\u0012\u0004\bB\u0010\f\u001a\u0004\bA\u00106R\u0017\u0010C\u001a\u0002038F¢\u0006\f\u0012\u0004\bD\u0010\f\u001a\u0004\bC\u00106R\u0017\u0010E\u001a\u0002038F¢\u0006\f\u0012\u0004\bF\u0010\f\u001a\u0004\bE\u00106R\u0017\u0010G\u001a\u0002038F¢\u0006\f\u0012\u0004\bH\u0010\f\u001a\u0004\bG\u00106R\u0017\u0010I\u001a\u0002038F¢\u0006\f\u0012\u0004\bJ\u0010\f\u001a\u0004\bI\u00106R\u0017\u0010K\u001a\u0002038F¢\u0006\f\u0012\u0004\bL\u0010\f\u001a\u0004\bK\u00106R\u0017\u0010M\u001a\u0002038F¢\u0006\f\u0012\u0004\bN\u0010\f\u001a\u0004\bM\u00106R\u0017\u0010O\u001a\u0002038F¢\u0006\f\u0012\u0004\bP\u0010\f\u001a\u0004\bO\u00106R\u0017\u0010Q\u001a\u0002038F¢\u0006\f\u0012\u0004\bR\u0010\f\u001a\u0004\bQ\u00106R\u0017\u0010S\u001a\u0002038F¢\u0006\f\u0012\u0004\bT\u0010\f\u001a\u0004\bS\u00106R\u0017\u0010U\u001a\u0002038F¢\u0006\f\u0012\u0004\bV\u0010\f\u001a\u0004\bU\u00106R\u0017\u0010W\u001a\u0002038F¢\u0006\f\u0012\u0004\bX\u0010\f\u001a\u0004\bW\u00106¨\u0006o"}, d2 = {"Lcom/blueair/core/model/DeviceScheduleMerged;", "Landroid/os/Parcelable;", "schedule", "", "Lcom/blueair/core/model/DeviceSchedule;", "<init>", "(Ljava/util/List;)V", "getSchedule", "()Ljava/util/List;", "name", "", "getName$annotations", "()V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "startTime", "getStartTime$annotations", "getStartTime", "setStartTime", "endTime", "getEndTime$annotations", "getEndTime", "setEndTime", "daysOfWeek", "", "Lcom/blueair/core/model/DayOfWeek;", "getDaysOfWeek$annotations", "getDaysOfWeek", "()Ljava/util/Set;", "setDaysOfWeek", "(Ljava/util/Set;)V", "timeZone", "getTimeZone$annotations", "getTimeZone", "setTimeZone", "instructions", "Lcom/blueair/core/model/DeviceScheduleInstruction;", "getInstructions$annotations", "getInstructions", "setInstructions", "endInstructions", "getEndInstructions$annotations", "getEndInstructions", "setEndInstructions", "endScheduleMode", "getEndScheduleMode$annotations", "getEndScheduleMode", "setEndScheduleMode", "paused", "", "getPaused$annotations", "getPaused", "()Z", "setPaused", "(Z)V", "isManual", "isManual$annotations", "isAutoMode", "isAutoMode$annotations", "isNightMode", "isNightMode$annotations", "isStandbyMode", "isStandbyMode$annotations", "isDisinfectionMode", "isDisinfectionMode$annotations", "isEcoMode", "isEcoMode$annotations", "isSkinMode", "isSkinMode$annotations", "isCoolMainMode", "isCoolMainMode$annotations", "isAirPurifyMainMode", "isAirPurifyMainMode$annotations", "isHeatMainMode", "isHeatMainMode$annotations", "isSmartMainMode", "isSmartMainMode$annotations", "isDehMainMode", "isDehMainMode$annotations", "isHumMainMode", "isHumMainMode$annotations", "isHumMode", "isHumMode$annotations", "isDryingMode", "isDryingMode$annotations", "isContinuousMode", "isContinuousMode$annotations", "isSameMergedSchedules", "other", "timeToCalendar", "Ljava/util/Calendar;", "time", "fetchFanSpeed", "", "device", "Lcom/blueair/core/model/Device;", "component1", "copy", "describeContents", "equals", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceSchedule.kt */
public final class DeviceScheduleMerged implements Parcelable {
    public static final Parcelable.Creator<DeviceScheduleMerged> CREATOR = new Creator();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private Set<? extends DayOfWeek> daysOfWeek;
    private List<DeviceScheduleInstruction> endInstructions;
    private String endScheduleMode;
    private String endTime;
    private List<DeviceScheduleInstruction> instructions;
    private String name;
    private boolean paused;
    private final List<DeviceSchedule> schedule;
    private String startTime;
    private String timeZone;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceSchedule.kt */
    public static final class Creator implements Parcelable.Creator<DeviceScheduleMerged> {
        public final DeviceScheduleMerged createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            for (int i = 0; i != readInt; i++) {
                arrayList.add(DeviceSchedule.CREATOR.createFromParcel(parcel));
            }
            return new DeviceScheduleMerged(arrayList, (DefaultConstructorMarker) null);
        }

        public final DeviceScheduleMerged[] newArray(int i) {
            return new DeviceScheduleMerged[i];
        }
    }

    public /* synthetic */ DeviceScheduleMerged(List list, DefaultConstructorMarker defaultConstructorMarker) {
        this(list);
    }

    public static /* synthetic */ DeviceScheduleMerged copy$default(DeviceScheduleMerged deviceScheduleMerged, List<DeviceSchedule> list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = deviceScheduleMerged.schedule;
        }
        return deviceScheduleMerged.copy(list);
    }

    public static /* synthetic */ void getDaysOfWeek$annotations() {
    }

    public static /* synthetic */ void getEndInstructions$annotations() {
    }

    public static /* synthetic */ void getEndScheduleMode$annotations() {
    }

    public static /* synthetic */ void getEndTime$annotations() {
    }

    public static /* synthetic */ void getInstructions$annotations() {
    }

    public static /* synthetic */ void getName$annotations() {
    }

    public static /* synthetic */ void getPaused$annotations() {
    }

    public static /* synthetic */ void getStartTime$annotations() {
    }

    public static /* synthetic */ void getTimeZone$annotations() {
    }

    public static /* synthetic */ void isAirPurifyMainMode$annotations() {
    }

    public static /* synthetic */ void isAutoMode$annotations() {
    }

    public static /* synthetic */ void isContinuousMode$annotations() {
    }

    public static /* synthetic */ void isCoolMainMode$annotations() {
    }

    public static /* synthetic */ void isDehMainMode$annotations() {
    }

    public static /* synthetic */ void isDisinfectionMode$annotations() {
    }

    public static /* synthetic */ void isDryingMode$annotations() {
    }

    public static /* synthetic */ void isEcoMode$annotations() {
    }

    public static /* synthetic */ void isHeatMainMode$annotations() {
    }

    public static /* synthetic */ void isHumMainMode$annotations() {
    }

    public static /* synthetic */ void isHumMode$annotations() {
    }

    public static /* synthetic */ void isManual$annotations() {
    }

    public static /* synthetic */ void isNightMode$annotations() {
    }

    public static /* synthetic */ void isSkinMode$annotations() {
    }

    public static /* synthetic */ void isSmartMainMode$annotations() {
    }

    public static /* synthetic */ void isStandbyMode$annotations() {
    }

    public final List<DeviceSchedule> component1() {
        return this.schedule;
    }

    public final DeviceScheduleMerged copy(List<DeviceSchedule> list) {
        Intrinsics.checkNotNullParameter(list, "schedule");
        return new DeviceScheduleMerged(list);
    }

    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof DeviceScheduleMerged) && Intrinsics.areEqual((Object) this.schedule, (Object) ((DeviceScheduleMerged) obj).schedule);
    }

    public int hashCode() {
        return this.schedule.hashCode();
    }

    public String toString() {
        return "DeviceScheduleMerged(schedule=" + this.schedule + ')';
    }

    public final void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        List<DeviceSchedule> list = this.schedule;
        parcel.writeInt(list.size());
        for (DeviceSchedule writeToParcel : list) {
            writeToParcel.writeToParcel(parcel, i);
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¨\u0006\t"}, d2 = {"Lcom/blueair/core/model/DeviceScheduleMerged$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/core/model/DeviceScheduleMerged;", "deviceSchedules", "", "Lcom/blueair/core/model/DeviceSchedule;", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceSchedule.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DeviceScheduleMerged newInstance(List<DeviceSchedule> list) {
            Intrinsics.checkNotNullParameter(list, "deviceSchedules");
            if (list.isEmpty()) {
                return null;
            }
            Collection collection = list;
            int size = collection.size();
            int i = 0;
            while (i < size) {
                list.get(i).isSameTimeSchedule(list.get(i >= collection.size() + -1 ? 0 : i + 1));
                i++;
            }
            return new DeviceScheduleMerged(list, (DefaultConstructorMarker) null);
        }
    }

    private DeviceScheduleMerged(List<DeviceSchedule> list) {
        this.schedule = list;
        DeviceSchedule deviceSchedule = (DeviceSchedule) CollectionsKt.first(list);
        String scheduleName = deviceSchedule.getScheduleName();
        if (scheduleName == null) {
            scheduleName = deviceSchedule.getStartTime() + TokenParser.SP + deviceSchedule.getEndTime();
        }
        this.name = scheduleName;
        this.startTime = deviceSchedule.getStartTime();
        this.endTime = deviceSchedule.getEndTime();
        this.daysOfWeek = deviceSchedule.getDaysOfWeek();
        this.timeZone = deviceSchedule.getTimeZone();
        Collection arrayList = new ArrayList();
        for (DeviceSchedule instructions2 : list) {
            CollectionsKt.addAll(arrayList, instructions2.getInstructions());
        }
        this.instructions = (List) arrayList;
        Collection arrayList2 = new ArrayList();
        for (DeviceSchedule endInstructions2 : this.schedule) {
            List<DeviceScheduleInstruction> endInstructions3 = endInstructions2.getEndInstructions();
            if (endInstructions3 == null) {
                endInstructions3 = CollectionsKt.emptyList();
            }
            CollectionsKt.addAll(arrayList2, endInstructions3);
        }
        this.endInstructions = (List) arrayList2;
        this.endScheduleMode = deviceSchedule.getScheduleEndType();
        this.paused = deviceSchedule.getPaused();
    }

    public final List<DeviceSchedule> getSchedule() {
        return this.schedule;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    public final String getStartTime() {
        return this.startTime;
    }

    public final void setStartTime(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.startTime = str;
    }

    public final String getEndTime() {
        return this.endTime;
    }

    public final void setEndTime(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.endTime = str;
    }

    public final Set<DayOfWeek> getDaysOfWeek() {
        return this.daysOfWeek;
    }

    public final void setDaysOfWeek(Set<? extends DayOfWeek> set) {
        Intrinsics.checkNotNullParameter(set, "<set-?>");
        this.daysOfWeek = set;
    }

    public final String getTimeZone() {
        return this.timeZone;
    }

    public final void setTimeZone(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.timeZone = str;
    }

    public final List<DeviceScheduleInstruction> getInstructions() {
        return this.instructions;
    }

    public final void setInstructions(List<DeviceScheduleInstruction> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.instructions = list;
    }

    public final List<DeviceScheduleInstruction> getEndInstructions() {
        return this.endInstructions;
    }

    public final void setEndInstructions(List<DeviceScheduleInstruction> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.endInstructions = list;
    }

    public final String getEndScheduleMode() {
        return this.endScheduleMode;
    }

    public final void setEndScheduleMode(String str) {
        this.endScheduleMode = str;
    }

    public final boolean getPaused() {
        return this.paused;
    }

    public final void setPaused(boolean z) {
        this.paused = z;
    }

    public final boolean isManual() {
        return !isAutoMode() && !isNightMode() && !isEcoMode();
    }

    public final boolean isAutoMode() {
        Iterable<DeviceSchedule> iterable = this.schedule;
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return false;
        }
        for (DeviceSchedule instructions2 : iterable) {
            Iterable<DeviceScheduleInstruction> instructions3 = instructions2.getInstructions();
            if (!(instructions3 instanceof Collection) || !((Collection) instructions3).isEmpty()) {
                for (DeviceScheduleInstruction deviceScheduleInstruction : instructions3) {
                    if (Intrinsics.areEqual((Object) deviceScheduleInstruction.getName(), (Object) DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.LEGACY_MODE.getInstructionName()) && Intrinsics.areEqual((Object) deviceScheduleInstruction.getValue(), (Object) DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.LEGACY_MODE.getDefaultValue())) {
                        return true;
                    }
                    if (Intrinsics.areEqual((Object) deviceScheduleInstruction.getName(), (Object) DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.AUTO_MODE.getInstructionName()) && Intrinsics.areEqual((Object) deviceScheduleInstruction.getValue(), (Object) DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.AUTO_MODE.getDefaultValue())) {
                        return true;
                    }
                    if (new Regex("(ap|heat|cool|hum)submode").matches(deviceScheduleInstruction.getName()) && Intrinsics.areEqual((Object) deviceScheduleInstruction.getValue(), (Object) String.valueOf(ApSubMode.AUTO.getValue()))) {
                        return true;
                    }
                    if (Intrinsics.areEqual((Object) deviceScheduleInstruction.getName(), (Object) "dehsubmode") && Intrinsics.areEqual((Object) deviceScheduleInstruction.getValue(), (Object) String.valueOf(DehSubMode.AUTO.getValue()))) {
                        return true;
                    }
                    if (Intrinsics.areEqual((Object) deviceScheduleInstruction.getName(), (Object) "humsubmode") && Intrinsics.areEqual((Object) deviceScheduleInstruction.getValue(), (Object) String.valueOf(HumSubMode.AUTO.getValue()))) {
                        return true;
                    }
                    if (Intrinsics.areEqual((Object) deviceScheduleInstruction.getName(), (Object) DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.MODE.getInstructionName()) && Intrinsics.areEqual((Object) deviceScheduleInstruction.getValue(), (Object) String.valueOf(Mode.AUTO.getValue()))) {
                        return true;
                    }
                }
                continue;
            }
        }
        return false;
    }

    public final boolean isNightMode() {
        Iterable<DeviceSchedule> iterable = this.schedule;
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return false;
        }
        for (DeviceSchedule instructions2 : iterable) {
            Iterable<DeviceScheduleInstruction> instructions3 = instructions2.getInstructions();
            if (!(instructions3 instanceof Collection) || !((Collection) instructions3).isEmpty()) {
                for (DeviceScheduleInstruction deviceScheduleInstruction : instructions3) {
                    if (Intrinsics.areEqual((Object) deviceScheduleInstruction.getName(), (Object) DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.NIGHTMODE.getInstructionName()) && Intrinsics.areEqual((Object) deviceScheduleInstruction.getValue(), (Object) DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.NIGHTMODE.getDefaultValue())) {
                        return true;
                    }
                    if (new Regex("(ap|heat|cool|hum)submode").matches(deviceScheduleInstruction.getName()) && Intrinsics.areEqual((Object) deviceScheduleInstruction.getValue(), (Object) String.valueOf(ApSubMode.NIGHT.getValue()))) {
                        return true;
                    }
                    if (Intrinsics.areEqual((Object) deviceScheduleInstruction.getName(), (Object) DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.MODE.getInstructionName()) && Intrinsics.areEqual((Object) deviceScheduleInstruction.getValue(), (Object) String.valueOf(Mode.NIGHT.getValue()))) {
                        return true;
                    }
                }
                continue;
            }
        }
        return false;
    }

    public final boolean isStandbyMode() {
        Iterable<DeviceSchedule> iterable = this.schedule;
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return false;
        }
        for (DeviceSchedule instructions2 : iterable) {
            Iterable<DeviceScheduleInstruction> instructions3 = instructions2.getInstructions();
            if (!(instructions3 instanceof Collection) || !((Collection) instructions3).isEmpty()) {
                for (DeviceScheduleInstruction deviceScheduleInstruction : instructions3) {
                    if (Intrinsics.areEqual((Object) deviceScheduleInstruction.getName(), (Object) DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.STANDBY.getInstructionName()) && Intrinsics.areEqual((Object) deviceScheduleInstruction.getValue(), (Object) DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.STANDBY.getDefaultValue())) {
                        return true;
                    }
                }
                continue;
            }
        }
        return false;
    }

    public final boolean isDisinfectionMode() {
        Iterable<DeviceSchedule> iterable = this.schedule;
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return false;
        }
        for (DeviceSchedule instructions2 : iterable) {
            Iterable<DeviceScheduleInstruction> instructions3 = instructions2.getInstructions();
            if (!(instructions3 instanceof Collection) || !((Collection) instructions3).isEmpty()) {
                for (DeviceScheduleInstruction deviceScheduleInstruction : instructions3) {
                    if (Intrinsics.areEqual((Object) deviceScheduleInstruction.getName(), (Object) DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.DISINFECTION.getInstructionName()) && Intrinsics.areEqual((Object) deviceScheduleInstruction.getValue(), (Object) DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.DISINFECTION.getDefaultValue())) {
                        return true;
                    }
                }
                continue;
            }
        }
        return false;
    }

    public final boolean isEcoMode() {
        Iterable<DeviceSchedule> iterable = this.schedule;
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return false;
        }
        for (DeviceSchedule instructions2 : iterable) {
            Iterable<DeviceScheduleInstruction> instructions3 = instructions2.getInstructions();
            if (!(instructions3 instanceof Collection) || !((Collection) instructions3).isEmpty()) {
                for (DeviceScheduleInstruction deviceScheduleInstruction : instructions3) {
                    if (Intrinsics.areEqual((Object) deviceScheduleInstruction.getName(), (Object) DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.ECO.getInstructionName()) && Intrinsics.areEqual((Object) deviceScheduleInstruction.getValue(), (Object) DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.ECO.getDefaultValue())) {
                        return true;
                    }
                    if (new Regex("(ap|heat|cool)submode").matches(deviceScheduleInstruction.getName()) && Intrinsics.areEqual((Object) deviceScheduleInstruction.getValue(), (Object) String.valueOf(ApSubMode.ECO.getValue()))) {
                        return true;
                    }
                }
                continue;
            }
        }
        return false;
    }

    public final boolean isSkinMode() {
        Iterable<DeviceSchedule> iterable = this.schedule;
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return false;
        }
        for (DeviceSchedule instructions2 : iterable) {
            Iterable<DeviceScheduleInstruction> instructions3 = instructions2.getInstructions();
            if (!(instructions3 instanceof Collection) || !((Collection) instructions3).isEmpty()) {
                for (DeviceScheduleInstruction deviceScheduleInstruction : instructions3) {
                    if (Intrinsics.areEqual((Object) deviceScheduleInstruction.getName(), (Object) DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.HUM_SUB_MODE.getInstructionName()) && Intrinsics.areEqual((Object) deviceScheduleInstruction.getValue(), (Object) String.valueOf(HumSubMode.SKIN.getValue()))) {
                        return true;
                    }
                }
                continue;
            }
        }
        return false;
    }

    public final boolean isCoolMainMode() {
        Iterable<DeviceSchedule> iterable = this.schedule;
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return false;
        }
        for (DeviceSchedule instructions2 : iterable) {
            Iterable<DeviceScheduleInstruction> instructions3 = instructions2.getInstructions();
            if (!(instructions3 instanceof Collection) || !((Collection) instructions3).isEmpty()) {
                for (DeviceScheduleInstruction deviceScheduleInstruction : instructions3) {
                    if (Intrinsics.areEqual((Object) deviceScheduleInstruction.getName(), (Object) DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.MAIN_MODE.getInstructionName()) && Intrinsics.areEqual((Object) deviceScheduleInstruction.getValue(), (Object) String.valueOf(MainMode.COOL.getValue()))) {
                        return true;
                    }
                }
                continue;
            }
        }
        return false;
    }

    public final boolean isAirPurifyMainMode() {
        Iterable<DeviceSchedule> iterable = this.schedule;
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return false;
        }
        for (DeviceSchedule instructions2 : iterable) {
            Iterable<DeviceScheduleInstruction> instructions3 = instructions2.getInstructions();
            if (!(instructions3 instanceof Collection) || !((Collection) instructions3).isEmpty()) {
                for (DeviceScheduleInstruction deviceScheduleInstruction : instructions3) {
                    if (Intrinsics.areEqual((Object) deviceScheduleInstruction.getName(), (Object) DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.MAIN_MODE.getInstructionName()) && Intrinsics.areEqual((Object) deviceScheduleInstruction.getValue(), (Object) String.valueOf(MainMode.AirPurify.getValue()))) {
                        return true;
                    }
                }
                continue;
            }
        }
        return false;
    }

    public final boolean isHeatMainMode() {
        Iterable<DeviceSchedule> iterable = this.schedule;
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return false;
        }
        for (DeviceSchedule instructions2 : iterable) {
            Iterable<DeviceScheduleInstruction> instructions3 = instructions2.getInstructions();
            if (!(instructions3 instanceof Collection) || !((Collection) instructions3).isEmpty()) {
                for (DeviceScheduleInstruction deviceScheduleInstruction : instructions3) {
                    if (Intrinsics.areEqual((Object) deviceScheduleInstruction.getName(), (Object) DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.MAIN_MODE.getInstructionName()) && Intrinsics.areEqual((Object) deviceScheduleInstruction.getValue(), (Object) String.valueOf(MainMode.HEAT.getValue()))) {
                        return true;
                    }
                }
                continue;
            }
        }
        return false;
    }

    public final boolean isSmartMainMode() {
        Iterable<DeviceSchedule> iterable = this.schedule;
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return false;
        }
        for (DeviceSchedule instructions2 : iterable) {
            Iterable<DeviceScheduleInstruction> instructions3 = instructions2.getInstructions();
            if (!(instructions3 instanceof Collection) || !((Collection) instructions3).isEmpty()) {
                for (DeviceScheduleInstruction deviceScheduleInstruction : instructions3) {
                    if (Intrinsics.areEqual((Object) deviceScheduleInstruction.getName(), (Object) DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.MAIN_MODE.getInstructionName()) && Intrinsics.areEqual((Object) deviceScheduleInstruction.getValue(), (Object) String.valueOf(MainMode.SMART.getValue()))) {
                        return true;
                    }
                }
                continue;
            }
        }
        return false;
    }

    public final boolean isDehMainMode() {
        Iterable<DeviceSchedule> iterable = this.schedule;
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return false;
        }
        for (DeviceSchedule instructions2 : iterable) {
            Iterable<DeviceScheduleInstruction> instructions3 = instructions2.getInstructions();
            if (!(instructions3 instanceof Collection) || !((Collection) instructions3).isEmpty()) {
                for (DeviceScheduleInstruction deviceScheduleInstruction : instructions3) {
                    if (Intrinsics.areEqual((Object) deviceScheduleInstruction.getName(), (Object) DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.MAIN_MODE.getInstructionName()) && Intrinsics.areEqual((Object) deviceScheduleInstruction.getValue(), (Object) String.valueOf(MainMode.Dehumidification.getValue()))) {
                        return true;
                    }
                }
                continue;
            }
        }
        return false;
    }

    public final boolean isHumMainMode() {
        Iterable<DeviceSchedule> iterable = this.schedule;
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return false;
        }
        for (DeviceSchedule instructions2 : iterable) {
            Iterable<DeviceScheduleInstruction> instructions3 = instructions2.getInstructions();
            if (!(instructions3 instanceof Collection) || !((Collection) instructions3).isEmpty()) {
                for (DeviceScheduleInstruction deviceScheduleInstruction : instructions3) {
                    if (Intrinsics.areEqual((Object) deviceScheduleInstruction.getName(), (Object) DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.MAIN_MODE.getInstructionName()) && Intrinsics.areEqual((Object) deviceScheduleInstruction.getValue(), (Object) String.valueOf(MainMode.Humidification.getValue()))) {
                        return true;
                    }
                }
                continue;
            }
        }
        return false;
    }

    public final boolean isHumMode() {
        Iterable<DeviceSchedule> iterable = this.schedule;
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return false;
        }
        for (DeviceSchedule instructions2 : iterable) {
            Iterable<DeviceScheduleInstruction> instructions3 = instructions2.getInstructions();
            if (!(instructions3 instanceof Collection) || !((Collection) instructions3).isEmpty()) {
                for (DeviceScheduleInstruction deviceScheduleInstruction : instructions3) {
                    if (Intrinsics.areEqual((Object) deviceScheduleInstruction.getName(), (Object) DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.HUM_MODE.getInstructionName()) && Intrinsics.areEqual((Object) deviceScheduleInstruction.getValue(), (Object) ServerProtocol.DIALOG_RETURN_SCOPES_TRUE)) {
                        return true;
                    }
                }
                continue;
            }
        }
        return false;
    }

    public final boolean isDryingMode() {
        Iterable<DeviceSchedule> iterable = this.schedule;
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return false;
        }
        for (DeviceSchedule instructions2 : iterable) {
            Iterable<DeviceScheduleInstruction> instructions3 = instructions2.getInstructions();
            if (!(instructions3 instanceof Collection) || !((Collection) instructions3).isEmpty()) {
                for (DeviceScheduleInstruction deviceScheduleInstruction : instructions3) {
                    if (Intrinsics.areEqual((Object) deviceScheduleInstruction.getName(), (Object) DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.DEH_SUB_MODE.getInstructionName()) && Intrinsics.areEqual((Object) deviceScheduleInstruction.getValue(), (Object) String.valueOf(DehSubMode.DRYING.getValue()))) {
                        return true;
                    }
                }
                continue;
            }
        }
        return false;
    }

    public final boolean isContinuousMode() {
        Iterable<DeviceSchedule> iterable = this.schedule;
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return false;
        }
        for (DeviceSchedule instructions2 : iterable) {
            Iterable<DeviceScheduleInstruction> instructions3 = instructions2.getInstructions();
            if (!(instructions3 instanceof Collection) || !((Collection) instructions3).isEmpty()) {
                for (DeviceScheduleInstruction deviceScheduleInstruction : instructions3) {
                    if (Intrinsics.areEqual((Object) deviceScheduleInstruction.getName(), (Object) DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.DEH_SUB_MODE.getInstructionName()) && Intrinsics.areEqual((Object) deviceScheduleInstruction.getValue(), (Object) String.valueOf(DehSubMode.CONTINUOUS.getValue()))) {
                        return true;
                    }
                }
                continue;
            }
        }
        return false;
    }

    public final boolean isSameMergedSchedules(DeviceScheduleMerged deviceScheduleMerged) {
        Intrinsics.checkNotNullParameter(deviceScheduleMerged, "other");
        Iterable<DeviceSchedule> iterable = deviceScheduleMerged.schedule;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (DeviceSchedule scheduleId : iterable) {
            arrayList.add(scheduleId.getScheduleId());
        }
        List list = (List) arrayList;
        Iterable<DeviceSchedule> iterable2 = this.schedule;
        Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable2, 10));
        for (DeviceSchedule scheduleId2 : iterable2) {
            arrayList2.add(scheduleId2.getScheduleId());
        }
        List<String> list2 = (List) arrayList2;
        if (list.size() != list2.size()) {
            return false;
        }
        for (String contains : list2) {
            if (!list.contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public final Calendar timeToCalendar(String str) {
        Intrinsics.checkNotNullParameter(str, "time");
        List split$default = StringsKt.split$default((CharSequence) str, new String[]{CertificateUtil.DELIMITER}, false, 0, 6, (Object) null);
        if (split$default.size() != 2) {
            return null;
        }
        Calendar instance = Calendar.getInstance();
        instance.set(11, Integer.parseInt((String) split$default.get(0)));
        instance.set(12, Integer.parseInt((String) split$default.get(1)));
        return instance;
    }

    public final int fetchFanSpeed(Device device) {
        FanSpeedEnum fanSpeedEnum;
        Intrinsics.checkNotNullParameter(device, "device");
        Set of = SetsKt.setOf(DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.FAN_SPEED.getInstructionName(), DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.LEGACY_FAN_SPEED.getInstructionName(), DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.AP_FAN_SPEED.getInstructionName(), DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.COOL_FAN_SPEED.getInstructionName(), DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.HEAT_FAN_SPEED.getInstructionName());
        HasFanSpeed hasFanSpeed = null;
        Integer num = null;
        for (DeviceSchedule instructions2 : this.schedule) {
            Iterator<DeviceScheduleInstruction> it = instructions2.getInstructions().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                DeviceScheduleInstruction next = it.next();
                if (of.contains(next.getName())) {
                    num = StringsKt.toIntOrNull(next.getValue());
                    break;
                }
            }
        }
        if (num == null || (fanSpeedEnum = FanSpeedEnum.Companion.fromServerValue(device, num.intValue())) == null) {
            fanSpeedEnum = FanSpeedEnum.OFF;
        }
        if (fanSpeedEnum.compareTo(FanSpeedEnum.ELEVEN) < 0) {
            if (device instanceof HasFanSpeed) {
                hasFanSpeed = (HasFanSpeed) device;
            }
            return (hasFanSpeed == null || !hasFanSpeed.getHasGear0()) ? 1 : 0;
        } else if (fanSpeedEnum.compareTo(FanSpeedEnum.THIRTY_SEVEN) < 0) {
            return 1;
        } else {
            if (fanSpeedEnum.compareTo(FanSpeedEnum.SIXTY_FOUR) < 0) {
                return 2;
            }
            if (fanSpeedEnum.compareTo(FanSpeedEnum.NINETY_ONE) < 0) {
                return 3;
            }
            if (device instanceof HasFanSpeed) {
                hasFanSpeed = (HasFanSpeed) device;
            }
            if (hasFanSpeed == null || !hasFanSpeed.getHasGear4()) {
                return 3;
            }
            return 4;
        }
    }
}
