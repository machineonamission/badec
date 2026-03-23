package com.blueair.devicedetails.util;

import com.blueair.core.model.DayOfWeek;
import com.blueair.core.model.DeviceScheduleMerged;
import com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.Calendar;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.joda.time.DateTimeConstants;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JF\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0011J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0007¨\u0006\u0015"}, d2 = {"Lcom/blueair/devicedetails/util/DeviceScheduleUtils;", "", "<init>", "()V", "testOverlapOfSchedules", "", "startTime", "Ljava/util/Calendar;", "endTime", "repeat", "", "Lcom/blueair/core/model/DayOfWeek;", "state", "Lcom/blueair/devicedetails/viewmodel/DeviceCreateEditScheduleViewModel$State;", "editingSchedule", "Lcom/blueair/core/model/DeviceScheduleMerged;", "allSchedules", "", "convertCalendarTimeToMinutes", "", "time", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceScheduleUtils.kt */
public final class DeviceScheduleUtils {
    public static final DeviceScheduleUtils INSTANCE = new DeviceScheduleUtils();

    private DeviceScheduleUtils() {
    }

    public static /* synthetic */ boolean testOverlapOfSchedules$default(DeviceScheduleUtils deviceScheduleUtils, Calendar calendar, Calendar calendar2, Set set, DeviceCreateEditScheduleViewModel.State state, DeviceScheduleMerged deviceScheduleMerged, List list, int i, Object obj) {
        if ((i & 16) != 0) {
            deviceScheduleMerged = null;
        }
        return deviceScheduleUtils.testOverlapOfSchedules(calendar, calendar2, set, state, deviceScheduleMerged, list);
    }

    public final boolean testOverlapOfSchedules(Calendar calendar, Calendar calendar2, Set<? extends DayOfWeek> set, DeviceCreateEditScheduleViewModel.State state, DeviceScheduleMerged deviceScheduleMerged, List<DeviceScheduleMerged> list) {
        Calendar calendar3 = calendar;
        Calendar calendar4 = calendar2;
        Set<? extends DayOfWeek> set2 = set;
        DeviceCreateEditScheduleViewModel.State state2 = state;
        DeviceScheduleMerged deviceScheduleMerged2 = deviceScheduleMerged;
        Intrinsics.checkNotNullParameter(calendar3, "startTime");
        Intrinsics.checkNotNullParameter(calendar4, SDKConstants.PARAM_END_TIME);
        Intrinsics.checkNotNullParameter(set2, "repeat");
        Intrinsics.checkNotNullParameter(state2, "state");
        List<DeviceScheduleMerged> list2 = list;
        Intrinsics.checkNotNullParameter(list2, "allSchedules");
        for (DayOfWeek dayOfWeek : set2) {
            int compareValue = dayOfWeek.getCompareValue();
            int i = DateTimeConstants.MINUTES_PER_DAY;
            int i2 = compareValue * DateTimeConstants.MINUTES_PER_DAY;
            int i3 = 11;
            int i4 = (calendar3.get(11) * 60) + calendar3.get(12);
            int i5 = (calendar4.get(11) * 60) + calendar4.get(12);
            int i6 = i4 + i2;
            int i7 = i2 + i5 + (i5 < i4 ? 1440 : 0);
            for (DeviceScheduleMerged next : list2) {
                if (state2 != DeviceCreateEditScheduleViewModel.State.MODIFY || deviceScheduleMerged2 == null || !next.isSameMergedSchedules(deviceScheduleMerged2)) {
                    Calendar timeToCalendar = next.timeToCalendar(next.getStartTime());
                    Calendar timeToCalendar2 = next.timeToCalendar(next.getEndTime());
                    if (!(timeToCalendar == null || timeToCalendar2 == null)) {
                        for (DayOfWeek next2 : next.getDaysOfWeek()) {
                            int compareValue2 = next2.getCompareValue() * i;
                            int i8 = (timeToCalendar.get(i3) * 60) + timeToCalendar.get(12);
                            int i9 = (timeToCalendar2.get(i3) * 60) + timeToCalendar2.get(12);
                            int i10 = compareValue2;
                            int i11 = i8 + i10;
                            int i12 = i9 + i10 + (i9 < i8 ? DateTimeConstants.MINUTES_PER_DAY : 0);
                            if ((i6 <= i12 && i12 <= i7) || ((i6 <= i11 && i11 <= i7) || ((i11 <= i7 && i7 <= i12) || (i11 <= i6 && i6 <= i12)))) {
                                return true;
                            }
                            if (dayOfWeek == DayOfWeek.SAT && next2 == DayOfWeek.SUN) {
                                int i13 = i11 + DateTimeConstants.MINUTES_PER_WEEK;
                                int i14 = i12 + DateTimeConstants.MINUTES_PER_WEEK;
                                if ((i6 <= i14 && i14 <= i7) || ((i6 <= i13 && i13 <= i7) || ((i13 <= i7 && i7 <= i14) || (i13 <= i6 && i6 <= i14)))) {
                                    return true;
                                }
                            }
                            if (dayOfWeek == DayOfWeek.SUN && next2 == DayOfWeek.SAT) {
                                int i15 = i6 + DateTimeConstants.MINUTES_PER_WEEK;
                                int i16 = i7 + DateTimeConstants.MINUTES_PER_WEEK;
                                if ((i15 <= i12 && i12 <= i16) || ((i15 <= i11 && i11 <= i16) || ((i11 <= i16 && i16 <= i12) || (i11 <= i15 && i15 <= i12)))) {
                                    return true;
                                }
                            }
                            Calendar calendar5 = calendar;
                            Calendar calendar6 = calendar2;
                            i = DateTimeConstants.MINUTES_PER_DAY;
                            i3 = 11;
                        }
                    }
                    Calendar calendar7 = calendar;
                    Calendar calendar8 = calendar2;
                }
            }
            calendar3 = calendar;
            calendar4 = calendar2;
        }
        return false;
    }

    public final int convertCalendarTimeToMinutes(Calendar calendar) {
        Intrinsics.checkNotNullParameter(calendar, "time");
        return (calendar.get(11) * 60) + calendar.get(12);
    }
}
