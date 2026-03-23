package com.blueair.core.model;

import android.content.Context;
import com.blueair.core.model.Device;
import java.util.Iterator;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0006\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J\u0012\u0010\u0015\u001a\u00020\u00072\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0012\u0010\f\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\tR\u0012\u0010\u000e\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\tR\u0012\u0010\u0010\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\t¨\u0006\u0018À\u0006\u0003"}, d2 = {"Lcom/blueair/core/model/HasAirRefresh;", "Lcom/blueair/core/model/Device;", "airRefreshEnabled", "", "getAirRefreshEnabled", "()Z", "airRefreshStatus", "", "getAirRefreshStatus", "()I", "airRefreshDuration", "getAirRefreshDuration", "airRefreshTimeStamp", "getAirRefreshTimeStamp", "airRefreshStartTimeStamp", "getAirRefreshStartTimeStamp", "airRefreshEndTimeStamp", "getAirRefreshEndTimeStamp", "Lcom/blueair/core/model/AirRefreshState;", "isInAirRefreshStatus", "status", "getAirRefreshLeftSeconds", "nowInMills", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: Device.kt */
public interface HasAirRefresh extends Device {
    AirRefreshState airRefreshStatus();

    int getAirRefreshDuration();

    boolean getAirRefreshEnabled();

    int getAirRefreshEndTimeStamp();

    int getAirRefreshLeftSeconds(long j);

    int getAirRefreshStartTimeStamp();

    int getAirRefreshStatus();

    int getAirRefreshTimeStamp();

    boolean isInAirRefreshStatus(AirRefreshState airRefreshState);

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: Device.kt */
    public static final class DefaultImpls {
        @Deprecated
        public static ConnectivityStatus getConnectivityStatus(HasAirRefresh hasAirRefresh) {
            return Device.CC.$default$getConnectivityStatus(hasAirRefresh);
        }

        @Deprecated
        public static TimeZone getTimezone(HasAirRefresh hasAirRefresh, Context context) {
            return Device.CC.$default$getTimezone(hasAirRefresh, context);
        }

        @Deprecated
        public static DeviceType getType(HasAirRefresh hasAirRefresh) {
            return Device.CC.$default$getType(hasAirRefresh);
        }

        @Deprecated
        public static boolean isOnline(HasAirRefresh hasAirRefresh) {
            return Device.CC.$default$isOnline(hasAirRefresh);
        }

        @Deprecated
        public static boolean isUsDevice(HasAirRefresh hasAirRefresh) {
            return Device.CC.$default$isUsDevice(hasAirRefresh);
        }

        @Deprecated
        public static AirRefreshState airRefreshStatus(HasAirRefresh hasAirRefresh) {
            return CC.$default$airRefreshStatus(hasAirRefresh);
        }

        @Deprecated
        public static boolean isInAirRefreshStatus(HasAirRefresh hasAirRefresh, AirRefreshState airRefreshState) {
            Intrinsics.checkNotNullParameter(airRefreshState, "status");
            return CC.$default$isInAirRefreshStatus(hasAirRefresh, airRefreshState);
        }

        @Deprecated
        public static int getAirRefreshLeftSeconds(HasAirRefresh hasAirRefresh, long j) {
            return CC.$default$getAirRefreshLeftSeconds(hasAirRefresh, j);
        }
    }

    /* renamed from: com.blueair.core.model.HasAirRefresh$-CC  reason: invalid class name */
    /* compiled from: Device.kt */
    public final /* synthetic */ class CC {
        public static AirRefreshState $default$airRefreshStatus(HasAirRefresh _this) {
            Object obj;
            Iterator it = AirRefreshState.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (((AirRefreshState) obj).getValue() == _this.getAirRefreshStatus()) {
                    break;
                }
            }
            AirRefreshState airRefreshState = (AirRefreshState) obj;
            return airRefreshState == null ? AirRefreshState.COMPLETED : airRefreshState;
        }

        public static boolean $default$isInAirRefreshStatus(HasAirRefresh _this, AirRefreshState airRefreshState) {
            Intrinsics.checkNotNullParameter(airRefreshState, "status");
            return _this.getAirRefreshStatus() == airRefreshState.getValue();
        }

        public static int $default$getAirRefreshLeftSeconds(HasAirRefresh _this, long j) {
            return RangesKt.coerceIn((int) (((long) _this.getAirRefreshDuration()) - ((j / ((long) 1000)) - ((long) _this.getAirRefreshTimeStamp()))), 0, _this.getAirRefreshDuration());
        }

        public static /* synthetic */ int getAirRefreshLeftSeconds$default(HasAirRefresh hasAirRefresh, long j, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    j = System.currentTimeMillis();
                }
                return hasAirRefresh.getAirRefreshLeftSeconds(j);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getAirRefreshLeftSeconds");
        }
    }
}
