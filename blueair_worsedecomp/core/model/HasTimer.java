package com.blueair.core.model;

import android.content.Context;
import com.blueair.core.model.Device;
import java.util.Iterator;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u000eH\u0016J\u0012\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u000bH\u0016J\b\u0010\u0011\u001a\u00020\u0003H\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0012\u0010\b\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0005R\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0012À\u0006\u0003"}, d2 = {"Lcom/blueair/core/model/HasTimer;", "Lcom/blueair/core/model/Device;", "timerStatus", "", "getTimerStatus", "()I", "timerDuration", "getTimerDuration", "timerLeftTime", "getTimerLeftTime", "timerLeftTimeUpdateTime", "", "getTimerLeftTimeUpdateTime", "()J", "Lcom/blueair/core/model/TimerState;", "getRealTimerLeftTime", "nowInMills", "getLeftSeconds", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: Device.kt */
public interface HasTimer extends Device {

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: Device.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                com.blueair.core.model.TimerState[] r0 = com.blueair.core.model.TimerState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.blueair.core.model.TimerState r1 = com.blueair.core.model.TimerState.START     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.blueair.core.model.TimerState r1 = com.blueair.core.model.TimerState.RESUME     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.blueair.core.model.TimerState r1 = com.blueair.core.model.TimerState.STOP     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.core.model.HasTimer.WhenMappings.<clinit>():void");
        }
    }

    int getLeftSeconds();

    int getRealTimerLeftTime(long j);

    int getTimerDuration();

    int getTimerLeftTime();

    long getTimerLeftTimeUpdateTime();

    int getTimerStatus();

    TimerState timerStatus();

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: Device.kt */
    public static final class DefaultImpls {
        @Deprecated
        public static ConnectivityStatus getConnectivityStatus(HasTimer hasTimer) {
            return Device.CC.$default$getConnectivityStatus(hasTimer);
        }

        @Deprecated
        public static TimeZone getTimezone(HasTimer hasTimer, Context context) {
            return Device.CC.$default$getTimezone(hasTimer, context);
        }

        @Deprecated
        public static DeviceType getType(HasTimer hasTimer) {
            return Device.CC.$default$getType(hasTimer);
        }

        @Deprecated
        public static boolean isOnline(HasTimer hasTimer) {
            return Device.CC.$default$isOnline(hasTimer);
        }

        @Deprecated
        public static boolean isUsDevice(HasTimer hasTimer) {
            return Device.CC.$default$isUsDevice(hasTimer);
        }

        @Deprecated
        public static TimerState timerStatus(HasTimer hasTimer) {
            return CC.$default$timerStatus(hasTimer);
        }

        @Deprecated
        public static int getRealTimerLeftTime(HasTimer hasTimer, long j) {
            return CC.$default$getRealTimerLeftTime(hasTimer, j);
        }

        @Deprecated
        public static int getLeftSeconds(HasTimer hasTimer) {
            return CC.$default$getLeftSeconds(hasTimer);
        }
    }

    /* renamed from: com.blueair.core.model.HasTimer$-CC  reason: invalid class name */
    /* compiled from: Device.kt */
    public final /* synthetic */ class CC {
        public static TimerState $default$timerStatus(HasTimer _this) {
            Object obj;
            Iterator it = TimerState.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (((TimerState) obj).getValue() == _this.getTimerStatus()) {
                    break;
                }
            }
            TimerState timerState = (TimerState) obj;
            return timerState == null ? TimerState.COMPLETED : timerState;
        }

        public static int $default$getRealTimerLeftTime(HasTimer _this, long j) {
            return RangesKt.coerceIn((int) (((long) _this.getTimerLeftTime()) - ((j / ((long) 1000)) - _this.getTimerLeftTimeUpdateTime())), 0, _this.getTimerDuration());
        }

        public static /* synthetic */ int getRealTimerLeftTime$default(HasTimer hasTimer, long j, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    j = System.currentTimeMillis();
                }
                return hasTimer.getRealTimerLeftTime(j);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getRealTimerLeftTime");
        }

        public static int $default$getLeftSeconds(HasTimer _this) {
            int coerceAtLeast = RangesKt.coerceAtLeast(_this.getTimerDuration(), 1);
            int i = WhenMappings.$EnumSwitchMapping$0[_this.timerStatus().ordinal()];
            if (i == 1 || i == 2) {
                return getRealTimerLeftTime$default(_this, 0, 1, (Object) null);
            }
            if (i != 3) {
                return 0;
            }
            return RangesKt.coerceIn(_this.getTimerLeftTime(), 0, coerceAtLeast);
        }
    }
}
