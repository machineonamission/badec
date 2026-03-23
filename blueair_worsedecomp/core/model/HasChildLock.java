package com.blueair.core.model;

import android.content.Context;
import com.blueair.core.model.Device;
import java.util.TimeZone;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004¨\u0006\u0005À\u0006\u0003"}, d2 = {"Lcom/blueair/core/model/HasChildLock;", "Lcom/blueair/core/model/Device;", "isChildLockOn", "", "()Z", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: Device.kt */
public interface HasChildLock extends Device {

    /* renamed from: com.blueair.core.model.HasChildLock$-CC  reason: invalid class name */
    /* compiled from: Device.kt */
    public final /* synthetic */ class CC {
    }

    boolean isChildLockOn();

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: Device.kt */
    public static final class DefaultImpls {
        @Deprecated
        public static ConnectivityStatus getConnectivityStatus(HasChildLock hasChildLock) {
            return Device.CC.$default$getConnectivityStatus(hasChildLock);
        }

        @Deprecated
        public static TimeZone getTimezone(HasChildLock hasChildLock, Context context) {
            return Device.CC.$default$getTimezone(hasChildLock, context);
        }

        @Deprecated
        public static DeviceType getType(HasChildLock hasChildLock) {
            return Device.CC.$default$getType(hasChildLock);
        }

        @Deprecated
        public static boolean isOnline(HasChildLock hasChildLock) {
            return Device.CC.$default$isOnline(hasChildLock);
        }

        @Deprecated
        public static boolean isUsDevice(HasChildLock hasChildLock) {
            return Device.CC.$default$isUsDevice(hasChildLock);
        }
    }
}
