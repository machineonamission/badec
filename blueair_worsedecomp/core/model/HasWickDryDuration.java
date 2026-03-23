package com.blueair.core.model;

import android.content.Context;
import com.blueair.core.model.Device;
import java.util.TimeZone;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lcom/blueair/core/model/HasWickDryDuration;", "Lcom/blueair/core/model/Device;", "wickdryDuration", "", "getWickdryDuration", "()I", "wickdryDone", "", "getWickdryDone", "()Z", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: Device.kt */
public interface HasWickDryDuration extends Device {

    /* renamed from: com.blueair.core.model.HasWickDryDuration$-CC  reason: invalid class name */
    /* compiled from: Device.kt */
    public final /* synthetic */ class CC {
    }

    boolean getWickdryDone();

    int getWickdryDuration();

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: Device.kt */
    public static final class DefaultImpls {
        @Deprecated
        public static ConnectivityStatus getConnectivityStatus(HasWickDryDuration hasWickDryDuration) {
            return Device.CC.$default$getConnectivityStatus(hasWickDryDuration);
        }

        @Deprecated
        public static TimeZone getTimezone(HasWickDryDuration hasWickDryDuration, Context context) {
            return Device.CC.$default$getTimezone(hasWickDryDuration, context);
        }

        @Deprecated
        public static DeviceType getType(HasWickDryDuration hasWickDryDuration) {
            return Device.CC.$default$getType(hasWickDryDuration);
        }

        @Deprecated
        public static boolean isOnline(HasWickDryDuration hasWickDryDuration) {
            return Device.CC.$default$isOnline(hasWickDryDuration);
        }

        @Deprecated
        public static boolean isUsDevice(HasWickDryDuration hasWickDryDuration) {
            return Device.CC.$default$isUsDevice(hasWickDryDuration);
        }
    }
}
