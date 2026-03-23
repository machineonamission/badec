package com.blueair.core.model;

import android.content.Context;
import com.blueair.core.model.Device;
import com.blueair.core.model.HasFanSpeed;
import java.util.TimeZone;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0012\u0010\t\u001a\u00020\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000e8VX\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013À\u0006\u0003"}, d2 = {"Lcom/blueair/core/model/HasG4NightMode;", "Lcom/blueair/core/model/HasFanSpeed;", "isG4NightModeOn", "", "()Z", "uiG4NightMode", "Lcom/blueair/core/model/UiG4NightMode;", "getUiG4NightMode", "()Lcom/blueair/core/model/UiG4NightMode;", "g4NightModeFilterTrigger", "", "getG4NightModeFilterTrigger", "()Ljava/lang/String;", "g4NightModeTrigger", "Lcom/blueair/core/model/FilterTrigger;", "getG4NightModeTrigger$annotations", "()V", "getG4NightModeTrigger", "()Lcom/blueair/core/model/FilterTrigger;", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: Device.kt */
public interface HasG4NightMode extends HasFanSpeed {
    String getG4NightModeFilterTrigger();

    FilterTrigger getG4NightModeTrigger();

    UiG4NightMode getUiG4NightMode();

    boolean isG4NightModeOn();

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: Device.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ void getG4NightModeTrigger$annotations() {
        }

        @Deprecated
        public static AutoMode getAutoMode(HasG4NightMode hasG4NightMode) {
            return HasFanSpeed.CC.$default$getAutoMode(hasG4NightMode);
        }

        @Deprecated
        public static ConnectivityStatus getConnectivityStatus(HasG4NightMode hasG4NightMode) {
            return Device.CC.$default$getConnectivityStatus(hasG4NightMode);
        }

        @Deprecated
        public static FanSpeedEnum getFanSpeedEnum(HasG4NightMode hasG4NightMode) {
            return HasFanSpeed.CC.$default$getFanSpeedEnum(hasG4NightMode);
        }

        @Deprecated
        public static Filter getFilter(HasG4NightMode hasG4NightMode) {
            return HasFanSpeed.CC.$default$getFilter(hasG4NightMode);
        }

        @Deprecated
        public static boolean getHasGear0(HasG4NightMode hasG4NightMode) {
            return HasFanSpeed.CC.$default$getHasGear0(hasG4NightMode);
        }

        @Deprecated
        public static boolean getHasGear4(HasG4NightMode hasG4NightMode) {
            return HasFanSpeed.CC.$default$getHasGear4(hasG4NightMode);
        }

        @Deprecated
        public static TimeZone getTimezone(HasG4NightMode hasG4NightMode, Context context) {
            return Device.CC.$default$getTimezone(hasG4NightMode, context);
        }

        @Deprecated
        public static FilterTrigger getTrigger(HasG4NightMode hasG4NightMode) {
            return HasFanSpeed.CC.$default$getTrigger(hasG4NightMode);
        }

        @Deprecated
        public static DeviceType getType(HasG4NightMode hasG4NightMode) {
            return Device.CC.$default$getType(hasG4NightMode);
        }

        @Deprecated
        public static UiAutoMode getUiAutoMode(HasG4NightMode hasG4NightMode) {
            return HasFanSpeed.CC.$default$getUiAutoMode(hasG4NightMode);
        }

        @Deprecated
        public static boolean isOnline(HasG4NightMode hasG4NightMode) {
            return Device.CC.$default$isOnline(hasG4NightMode);
        }

        @Deprecated
        public static boolean isUsDevice(HasG4NightMode hasG4NightMode) {
            return Device.CC.$default$isUsDevice(hasG4NightMode);
        }

        @Deprecated
        public static UiG4NightMode getUiG4NightMode(HasG4NightMode hasG4NightMode) {
            return CC.$default$getUiG4NightMode(hasG4NightMode);
        }

        @Deprecated
        public static FilterTrigger getG4NightModeTrigger(HasG4NightMode hasG4NightMode) {
            return CC.$default$getG4NightModeTrigger(hasG4NightMode);
        }
    }

    /* renamed from: com.blueair.core.model.HasG4NightMode$-CC  reason: invalid class name */
    /* compiled from: Device.kt */
    public final /* synthetic */ class CC {
        public static UiG4NightMode $default$getUiG4NightMode(HasG4NightMode _this) {
            return UiG4NightMode.Companion.from(_this);
        }

        public static FilterTrigger $default$getG4NightModeTrigger(HasG4NightMode _this) {
            return FilterTrigger.Companion.fromServerValue(_this.getG4NightModeFilterTrigger());
        }
    }
}
