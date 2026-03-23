package com.blueair.core.model;

import android.content.Context;
import com.blueair.core.model.Device;
import java.util.TimeZone;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/blueair/core/model/HasDetectCat;", "Lcom/blueair/core/model/HasSKU;", "detectCat", "", "getDetectCat", "()Z", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: Device.kt */
public interface HasDetectCat extends HasSKU {

    /* renamed from: com.blueair.core.model.HasDetectCat$-CC  reason: invalid class name */
    /* compiled from: Device.kt */
    public final /* synthetic */ class CC {
    }

    boolean getDetectCat();

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: Device.kt */
    public static final class DefaultImpls {
        @Deprecated
        public static ConnectivityStatus getConnectivityStatus(HasDetectCat hasDetectCat) {
            return Device.CC.$default$getConnectivityStatus(hasDetectCat);
        }

        @Deprecated
        public static TimeZone getTimezone(HasDetectCat hasDetectCat, Context context) {
            return Device.CC.$default$getTimezone(hasDetectCat, context);
        }

        @Deprecated
        public static DeviceType getType(HasDetectCat hasDetectCat) {
            return Device.CC.$default$getType(hasDetectCat);
        }

        @Deprecated
        public static boolean isOnline(HasDetectCat hasDetectCat) {
            return Device.CC.$default$isOnline(hasDetectCat);
        }

        @Deprecated
        public static boolean isUsDevice(HasDetectCat hasDetectCat) {
            return Device.CC.$default$isUsDevice(hasDetectCat);
        }
    }
}
