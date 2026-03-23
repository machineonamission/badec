package com.blueair.core.model;

import android.content.Context;
import com.blueair.core.model.Device;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\n\u001a\u00020\u0007H\u0016R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lcom/blueair/core/model/HasRemoveYellowWater;", "Lcom/blueair/core/model/Device;", "ywrmEnabled", "", "getYwrmEnabled", "()Ljava/lang/Boolean;", "ywrmUsage", "", "getYwrmUsage", "()I", "getRefresherLifeLeft", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: Device.kt */
public interface HasRemoveYellowWater extends Device {
    int getRefresherLifeLeft();

    Boolean getYwrmEnabled();

    int getYwrmUsage();

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: Device.kt */
    public static final class DefaultImpls {
        @Deprecated
        public static ConnectivityStatus getConnectivityStatus(HasRemoveYellowWater hasRemoveYellowWater) {
            return Device.CC.$default$getConnectivityStatus(hasRemoveYellowWater);
        }

        @Deprecated
        public static TimeZone getTimezone(HasRemoveYellowWater hasRemoveYellowWater, Context context) {
            return Device.CC.$default$getTimezone(hasRemoveYellowWater, context);
        }

        @Deprecated
        public static DeviceType getType(HasRemoveYellowWater hasRemoveYellowWater) {
            return Device.CC.$default$getType(hasRemoveYellowWater);
        }

        @Deprecated
        public static boolean isOnline(HasRemoveYellowWater hasRemoveYellowWater) {
            return Device.CC.$default$isOnline(hasRemoveYellowWater);
        }

        @Deprecated
        public static boolean isUsDevice(HasRemoveYellowWater hasRemoveYellowWater) {
            return Device.CC.$default$isUsDevice(hasRemoveYellowWater);
        }

        @Deprecated
        public static int getRefresherLifeLeft(HasRemoveYellowWater hasRemoveYellowWater) {
            return CC.$default$getRefresherLifeLeft(hasRemoveYellowWater);
        }
    }

    /* renamed from: com.blueair.core.model.HasRemoveYellowWater$-CC  reason: invalid class name */
    /* compiled from: Device.kt */
    public final /* synthetic */ class CC {
        public static int $default$getRefresherLifeLeft(HasRemoveYellowWater _this) {
            return RangesKt.coerceIn(100 - _this.getYwrmUsage(), 0, 100);
        }
    }
}
