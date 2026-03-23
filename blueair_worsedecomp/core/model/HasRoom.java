package com.blueair.core.model;

import android.content.Context;
import com.blueair.core.model.Device;
import java.util.TimeZone;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/blueair/core/model/HasRoom;", "Lcom/blueair/core/model/Device;", "roomType", "", "getRoomType", "()I", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: Device.kt */
public interface HasRoom extends Device {

    /* renamed from: com.blueair.core.model.HasRoom$-CC  reason: invalid class name */
    /* compiled from: Device.kt */
    public final /* synthetic */ class CC {
    }

    int getRoomType();

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: Device.kt */
    public static final class DefaultImpls {
        @Deprecated
        public static ConnectivityStatus getConnectivityStatus(HasRoom hasRoom) {
            return Device.CC.$default$getConnectivityStatus(hasRoom);
        }

        @Deprecated
        public static TimeZone getTimezone(HasRoom hasRoom, Context context) {
            return Device.CC.$default$getTimezone(hasRoom, context);
        }

        @Deprecated
        public static DeviceType getType(HasRoom hasRoom) {
            return Device.CC.$default$getType(hasRoom);
        }

        @Deprecated
        public static boolean isOnline(HasRoom hasRoom) {
            return Device.CC.$default$isOnline(hasRoom);
        }

        @Deprecated
        public static boolean isUsDevice(HasRoom hasRoom) {
            return Device.CC.$default$isUsDevice(hasRoom);
        }
    }
}
