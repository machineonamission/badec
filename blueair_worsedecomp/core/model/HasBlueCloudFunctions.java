package com.blueair.core.model;

import android.content.Context;
import com.blueair.core.model.Device;
import java.util.TimeZone;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002À\u0006\u0003"}, d2 = {"Lcom/blueair/core/model/HasBlueCloudFunctions;", "Lcom/blueair/core/model/Device;", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: Device.kt */
public interface HasBlueCloudFunctions extends Device {

    /* renamed from: com.blueair.core.model.HasBlueCloudFunctions$-CC  reason: invalid class name */
    /* compiled from: Device.kt */
    public final /* synthetic */ class CC {
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: Device.kt */
    public static final class DefaultImpls {
        @Deprecated
        public static ConnectivityStatus getConnectivityStatus(HasBlueCloudFunctions hasBlueCloudFunctions) {
            return Device.CC.$default$getConnectivityStatus(hasBlueCloudFunctions);
        }

        @Deprecated
        public static TimeZone getTimezone(HasBlueCloudFunctions hasBlueCloudFunctions, Context context) {
            return Device.CC.$default$getTimezone(hasBlueCloudFunctions, context);
        }

        @Deprecated
        public static DeviceType getType(HasBlueCloudFunctions hasBlueCloudFunctions) {
            return Device.CC.$default$getType(hasBlueCloudFunctions);
        }

        @Deprecated
        public static boolean isOnline(HasBlueCloudFunctions hasBlueCloudFunctions) {
            return Device.CC.$default$isOnline(hasBlueCloudFunctions);
        }

        @Deprecated
        public static boolean isUsDevice(HasBlueCloudFunctions hasBlueCloudFunctions) {
            return Device.CC.$default$isUsDevice(hasBlueCloudFunctions);
        }
    }
}
