package com.blueair.core.model;

import android.content.Context;
import com.blueair.core.model.Device;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.text.Regex;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00038VX\u0004¢\u0006\f\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0007\u0010\u0004R\u001a\u0010\n\u001a\u00020\u00038VX\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\t\u001a\u0004\b\f\u0010\u0004¨\u0006\rÀ\u0006\u0003"}, d2 = {"Lcom/blueair/core/model/HasGermShieldMode;", "Lcom/blueair/core/model/Device;", "isGermShieldModeOn", "", "()Z", "isGermShieldNightModeOn", "()Ljava/lang/Boolean;", "isGermShieldPlus", "isGermShieldPlus$annotations", "()V", "hasGermShieldNightMode", "getHasGermShieldNightMode$annotations", "getHasGermShieldNightMode", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: Device.kt */
public interface HasGermShieldMode extends Device {
    boolean getHasGermShieldNightMode();

    boolean isGermShieldModeOn();

    Boolean isGermShieldNightModeOn();

    boolean isGermShieldPlus();

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: Device.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ void getHasGermShieldNightMode$annotations() {
        }

        public static /* synthetic */ void isGermShieldPlus$annotations() {
        }

        @Deprecated
        public static ConnectivityStatus getConnectivityStatus(HasGermShieldMode hasGermShieldMode) {
            return Device.CC.$default$getConnectivityStatus(hasGermShieldMode);
        }

        @Deprecated
        public static TimeZone getTimezone(HasGermShieldMode hasGermShieldMode, Context context) {
            return Device.CC.$default$getTimezone(hasGermShieldMode, context);
        }

        @Deprecated
        public static DeviceType getType(HasGermShieldMode hasGermShieldMode) {
            return Device.CC.$default$getType(hasGermShieldMode);
        }

        @Deprecated
        public static boolean isOnline(HasGermShieldMode hasGermShieldMode) {
            return Device.CC.$default$isOnline(hasGermShieldMode);
        }

        @Deprecated
        public static boolean isUsDevice(HasGermShieldMode hasGermShieldMode) {
            return Device.CC.$default$isUsDevice(hasGermShieldMode);
        }

        @Deprecated
        public static boolean isGermShieldPlus(HasGermShieldMode hasGermShieldMode) {
            return CC.$default$isGermShieldPlus(hasGermShieldMode);
        }

        @Deprecated
        public static boolean getHasGermShieldNightMode(HasGermShieldMode hasGermShieldMode) {
            return CC.$default$getHasGermShieldNightMode(hasGermShieldMode);
        }
    }

    /* renamed from: com.blueair.core.model.HasGermShieldMode$-CC  reason: invalid class name */
    /* compiled from: Device.kt */
    public final /* synthetic */ class CC {
        public static boolean $default$isGermShieldPlus(HasGermShieldMode _this) {
            if (!(_this instanceof DeviceG4)) {
                return false;
            }
            DeviceG4 deviceG4 = (DeviceG4) _this;
            if (!deviceG4.isPlus()) {
                return false;
            }
            return new Regex("8[0-9][68]0").matches(deviceG4.getModelNumber());
        }

        public static boolean $default$getHasGermShieldNightMode(HasGermShieldMode _this) {
            return _this.isGermShieldNightModeOn() != null;
        }
    }
}
