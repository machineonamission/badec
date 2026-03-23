package com.blueair.core.model;

import android.content.Context;
import com.blueair.core.model.Device;
import java.util.TimeZone;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/blueair/core/model/HasLocation;", "Lcom/blueair/core/model/Device;", "locationId", "", "getLocationId", "()Ljava/lang/String;", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: Device.kt */
public interface HasLocation extends Device {

    /* renamed from: com.blueair.core.model.HasLocation$-CC  reason: invalid class name */
    /* compiled from: Device.kt */
    public final /* synthetic */ class CC {
    }

    String getLocationId();

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: Device.kt */
    public static final class DefaultImpls {
        @Deprecated
        public static ConnectivityStatus getConnectivityStatus(HasLocation hasLocation) {
            return Device.CC.$default$getConnectivityStatus(hasLocation);
        }

        @Deprecated
        public static TimeZone getTimezone(HasLocation hasLocation, Context context) {
            return Device.CC.$default$getTimezone(hasLocation, context);
        }

        @Deprecated
        public static DeviceType getType(HasLocation hasLocation) {
            return Device.CC.$default$getType(hasLocation);
        }

        @Deprecated
        public static boolean isOnline(HasLocation hasLocation) {
            return Device.CC.$default$isOnline(hasLocation);
        }

        @Deprecated
        public static boolean isUsDevice(HasLocation hasLocation) {
            return Device.CC.$default$isUsDevice(hasLocation);
        }
    }
}
