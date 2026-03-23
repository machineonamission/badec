package com.blueair.core.model;

import android.content.Context;
import com.blueair.core.model.Device;
import java.util.TimeZone;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/blueair/core/model/HasTemperatureUnit;", "Lcom/blueair/core/model/Device;", "temperatureUnit", "", "getTemperatureUnit", "()I", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: Device.kt */
public interface HasTemperatureUnit extends Device {

    /* renamed from: com.blueair.core.model.HasTemperatureUnit$-CC  reason: invalid class name */
    /* compiled from: Device.kt */
    public final /* synthetic */ class CC {
    }

    int getTemperatureUnit();

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: Device.kt */
    public static final class DefaultImpls {
        @Deprecated
        public static ConnectivityStatus getConnectivityStatus(HasTemperatureUnit hasTemperatureUnit) {
            return Device.CC.$default$getConnectivityStatus(hasTemperatureUnit);
        }

        @Deprecated
        public static TimeZone getTimezone(HasTemperatureUnit hasTemperatureUnit, Context context) {
            return Device.CC.$default$getTimezone(hasTemperatureUnit, context);
        }

        @Deprecated
        public static DeviceType getType(HasTemperatureUnit hasTemperatureUnit) {
            return Device.CC.$default$getType(hasTemperatureUnit);
        }

        @Deprecated
        public static boolean isOnline(HasTemperatureUnit hasTemperatureUnit) {
            return Device.CC.$default$isOnline(hasTemperatureUnit);
        }

        @Deprecated
        public static boolean isUsDevice(HasTemperatureUnit hasTemperatureUnit) {
            return Device.CC.$default$isUsDevice(hasTemperatureUnit);
        }
    }
}
