package com.blueair.core.model;

import android.content.Context;
import com.blueair.core.model.Device;
import java.util.TimeZone;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002À\u0006\u0003"}, d2 = {"Lcom/blueair/core/model/HasBleFunctions;", "Lcom/blueair/core/model/Device;", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: Device.kt */
public interface HasBleFunctions extends Device {

    /* renamed from: com.blueair.core.model.HasBleFunctions$-CC  reason: invalid class name */
    /* compiled from: Device.kt */
    public final /* synthetic */ class CC {
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: Device.kt */
    public static final class DefaultImpls {
        @Deprecated
        public static ConnectivityStatus getConnectivityStatus(HasBleFunctions hasBleFunctions) {
            return Device.CC.$default$getConnectivityStatus(hasBleFunctions);
        }

        @Deprecated
        public static TimeZone getTimezone(HasBleFunctions hasBleFunctions, Context context) {
            return Device.CC.$default$getTimezone(hasBleFunctions, context);
        }

        @Deprecated
        public static DeviceType getType(HasBleFunctions hasBleFunctions) {
            return Device.CC.$default$getType(hasBleFunctions);
        }

        @Deprecated
        public static boolean isOnline(HasBleFunctions hasBleFunctions) {
            return Device.CC.$default$isOnline(hasBleFunctions);
        }

        @Deprecated
        public static boolean isUsDevice(HasBleFunctions hasBleFunctions) {
            return Device.CC.$default$isUsDevice(hasBleFunctions);
        }
    }
}
