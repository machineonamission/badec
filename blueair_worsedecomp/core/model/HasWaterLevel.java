package com.blueair.core.model;

import android.content.Context;
import com.blueair.core.model.Device;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u0006H\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lcom/blueair/core/model/HasWaterLevel;", "Lcom/blueair/core/model/Device;", "waterLevel", "", "getWaterLevel", "()I", "Lcom/blueair/core/model/WaterLevel;", "isInWaterLevel", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: Device.kt */
public interface HasWaterLevel extends Device {
    int getWaterLevel();

    boolean isInWaterLevel(WaterLevel waterLevel);

    WaterLevel waterLevel();

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: Device.kt */
    public static final class DefaultImpls {
        @Deprecated
        public static ConnectivityStatus getConnectivityStatus(HasWaterLevel hasWaterLevel) {
            return Device.CC.$default$getConnectivityStatus(hasWaterLevel);
        }

        @Deprecated
        public static TimeZone getTimezone(HasWaterLevel hasWaterLevel, Context context) {
            return Device.CC.$default$getTimezone(hasWaterLevel, context);
        }

        @Deprecated
        public static DeviceType getType(HasWaterLevel hasWaterLevel) {
            return Device.CC.$default$getType(hasWaterLevel);
        }

        @Deprecated
        public static boolean isOnline(HasWaterLevel hasWaterLevel) {
            return Device.CC.$default$isOnline(hasWaterLevel);
        }

        @Deprecated
        public static boolean isUsDevice(HasWaterLevel hasWaterLevel) {
            return Device.CC.$default$isUsDevice(hasWaterLevel);
        }

        @Deprecated
        public static WaterLevel waterLevel(HasWaterLevel hasWaterLevel) {
            return CC.$default$waterLevel(hasWaterLevel);
        }

        @Deprecated
        public static boolean isInWaterLevel(HasWaterLevel hasWaterLevel, WaterLevel waterLevel) {
            Intrinsics.checkNotNullParameter(waterLevel, "waterLevel");
            return CC.$default$isInWaterLevel(hasWaterLevel, waterLevel);
        }
    }

    /* renamed from: com.blueair.core.model.HasWaterLevel$-CC  reason: invalid class name */
    /* compiled from: Device.kt */
    public final /* synthetic */ class CC {
        public static WaterLevel $default$waterLevel(HasWaterLevel _this) {
            return WaterLevel.Companion.fromValue(_this.getWaterLevel());
        }

        public static boolean $default$isInWaterLevel(HasWaterLevel _this, WaterLevel waterLevel) {
            Intrinsics.checkNotNullParameter(waterLevel, "waterLevel");
            return waterLevel == _this.waterLevel();
        }
    }
}
