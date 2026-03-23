package com.blueair.core.model;

import android.content.Context;
import com.blueair.core.model.Device;
import java.util.TimeZone;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/blueair/core/model/HasAutoRh;", "Lcom/blueair/core/model/Device;", "autoRh", "", "getAutoRh", "()I", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: Device.kt */
public interface HasAutoRh extends Device {

    /* renamed from: com.blueair.core.model.HasAutoRh$-CC  reason: invalid class name */
    /* compiled from: Device.kt */
    public final /* synthetic */ class CC {
    }

    int getAutoRh();

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: Device.kt */
    public static final class DefaultImpls {
        @Deprecated
        public static ConnectivityStatus getConnectivityStatus(HasAutoRh hasAutoRh) {
            return Device.CC.$default$getConnectivityStatus(hasAutoRh);
        }

        @Deprecated
        public static TimeZone getTimezone(HasAutoRh hasAutoRh, Context context) {
            return Device.CC.$default$getTimezone(hasAutoRh, context);
        }

        @Deprecated
        public static DeviceType getType(HasAutoRh hasAutoRh) {
            return Device.CC.$default$getType(hasAutoRh);
        }

        @Deprecated
        public static boolean isOnline(HasAutoRh hasAutoRh) {
            return Device.CC.$default$isOnline(hasAutoRh);
        }

        @Deprecated
        public static boolean isUsDevice(HasAutoRh hasAutoRh) {
            return Device.CC.$default$isUsDevice(hasAutoRh);
        }
    }
}
