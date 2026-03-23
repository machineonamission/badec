package com.blueair.core.model;

import android.content.Context;
import com.blueair.core.model.Device;
import java.util.TimeZone;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lcom/blueair/core/model/HasBlueProvisionCalls;", "Lcom/blueair/core/model/HasBlueCloudFunctions;", "deviceUuid", "Lcom/blueair/core/model/DeviceUuid;", "getDeviceUuid", "()Lcom/blueair/core/model/DeviceUuid;", "hasFinishedOnboarding", "", "getHasFinishedOnboarding", "()Z", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: Device.kt */
public interface HasBlueProvisionCalls extends HasBlueCloudFunctions {

    /* renamed from: com.blueair.core.model.HasBlueProvisionCalls$-CC  reason: invalid class name */
    /* compiled from: Device.kt */
    public final /* synthetic */ class CC {
    }

    DeviceUuid getDeviceUuid();

    boolean getHasFinishedOnboarding();

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: Device.kt */
    public static final class DefaultImpls {
        @Deprecated
        public static ConnectivityStatus getConnectivityStatus(HasBlueProvisionCalls hasBlueProvisionCalls) {
            return Device.CC.$default$getConnectivityStatus(hasBlueProvisionCalls);
        }

        @Deprecated
        public static TimeZone getTimezone(HasBlueProvisionCalls hasBlueProvisionCalls, Context context) {
            return Device.CC.$default$getTimezone(hasBlueProvisionCalls, context);
        }

        @Deprecated
        public static DeviceType getType(HasBlueProvisionCalls hasBlueProvisionCalls) {
            return Device.CC.$default$getType(hasBlueProvisionCalls);
        }

        @Deprecated
        public static boolean isOnline(HasBlueProvisionCalls hasBlueProvisionCalls) {
            return Device.CC.$default$isOnline(hasBlueProvisionCalls);
        }

        @Deprecated
        public static boolean isUsDevice(HasBlueProvisionCalls hasBlueProvisionCalls) {
            return Device.CC.$default$isUsDevice(hasBlueProvisionCalls);
        }
    }
}
