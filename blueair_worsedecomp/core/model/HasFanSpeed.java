package com.blueair.core.model;

import android.content.Context;
import com.blueair.core.model.Device;
import java.util.TimeZone;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0012\u0010\t\u001a\u00020\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000e8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0012\u0010\u0011\u001a\u00020\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\fR\u0012\u0010\u0013\u001a\u00020\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\fR\u0014\u0010\u0015\u001a\u00020\u00168VX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u001a8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u001e8VX\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020$8VX\u0004¢\u0006\f\u0012\u0004\b%\u0010 \u001a\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020)8VX\u0004¢\u0006\f\u0012\u0004\b*\u0010 \u001a\u0004\b+\u0010,R\u001a\u0010-\u001a\u00020)8VX\u0004¢\u0006\f\u0012\u0004\b.\u0010 \u001a\u0004\b/\u0010,¨\u00060À\u0006\u0003"}, d2 = {"Lcom/blueair/core/model/HasFanSpeed;", "Lcom/blueair/core/model/Device;", "fanSpeed", "", "getFanSpeed", "()I", "filterLife", "getFilterLife", "()Ljava/lang/Integer;", "autoModeText", "", "getAutoModeText", "()Ljava/lang/String;", "autoMode", "Lcom/blueair/core/model/AutoMode;", "getAutoMode", "()Lcom/blueair/core/model/AutoMode;", "filterType", "getFilterType", "filterTrigger", "getFilterTrigger", "uiAutoMode", "Lcom/blueair/core/model/UiAutoMode;", "getUiAutoMode", "()Lcom/blueair/core/model/UiAutoMode;", "fanSpeedEnum", "Lcom/blueair/core/model/FanSpeedEnum;", "getFanSpeedEnum", "()Lcom/blueair/core/model/FanSpeedEnum;", "filter", "Lcom/blueair/core/model/Filter;", "getFilter$annotations", "()V", "getFilter", "()Lcom/blueair/core/model/Filter;", "trigger", "Lcom/blueair/core/model/FilterTrigger;", "getTrigger$annotations", "getTrigger", "()Lcom/blueair/core/model/FilterTrigger;", "hasGear0", "", "getHasGear0$annotations", "getHasGear0", "()Z", "hasGear4", "getHasGear4$annotations", "getHasGear4", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: Device.kt */
public interface HasFanSpeed extends Device {
    AutoMode getAutoMode();

    String getAutoModeText();

    int getFanSpeed();

    FanSpeedEnum getFanSpeedEnum();

    Filter getFilter();

    Integer getFilterLife();

    String getFilterTrigger();

    String getFilterType();

    boolean getHasGear0();

    boolean getHasGear4();

    FilterTrigger getTrigger();

    UiAutoMode getUiAutoMode();

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: Device.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ void getFilter$annotations() {
        }

        public static /* synthetic */ void getHasGear0$annotations() {
        }

        public static /* synthetic */ void getHasGear4$annotations() {
        }

        public static /* synthetic */ void getTrigger$annotations() {
        }

        @Deprecated
        public static ConnectivityStatus getConnectivityStatus(HasFanSpeed hasFanSpeed) {
            return Device.CC.$default$getConnectivityStatus(hasFanSpeed);
        }

        @Deprecated
        public static TimeZone getTimezone(HasFanSpeed hasFanSpeed, Context context) {
            return Device.CC.$default$getTimezone(hasFanSpeed, context);
        }

        @Deprecated
        public static DeviceType getType(HasFanSpeed hasFanSpeed) {
            return Device.CC.$default$getType(hasFanSpeed);
        }

        @Deprecated
        public static boolean isOnline(HasFanSpeed hasFanSpeed) {
            return Device.CC.$default$isOnline(hasFanSpeed);
        }

        @Deprecated
        public static boolean isUsDevice(HasFanSpeed hasFanSpeed) {
            return Device.CC.$default$isUsDevice(hasFanSpeed);
        }

        @Deprecated
        public static AutoMode getAutoMode(HasFanSpeed hasFanSpeed) {
            return CC.$default$getAutoMode(hasFanSpeed);
        }

        @Deprecated
        public static UiAutoMode getUiAutoMode(HasFanSpeed hasFanSpeed) {
            return CC.$default$getUiAutoMode(hasFanSpeed);
        }

        @Deprecated
        public static FanSpeedEnum getFanSpeedEnum(HasFanSpeed hasFanSpeed) {
            return CC.$default$getFanSpeedEnum(hasFanSpeed);
        }

        @Deprecated
        public static Filter getFilter(HasFanSpeed hasFanSpeed) {
            return CC.$default$getFilter(hasFanSpeed);
        }

        @Deprecated
        public static FilterTrigger getTrigger(HasFanSpeed hasFanSpeed) {
            return CC.$default$getTrigger(hasFanSpeed);
        }

        @Deprecated
        public static boolean getHasGear0(HasFanSpeed hasFanSpeed) {
            return CC.$default$getHasGear0(hasFanSpeed);
        }

        @Deprecated
        public static boolean getHasGear4(HasFanSpeed hasFanSpeed) {
            return CC.$default$getHasGear4(hasFanSpeed);
        }
    }

    /* renamed from: com.blueair.core.model.HasFanSpeed$-CC  reason: invalid class name */
    /* compiled from: Device.kt */
    public final /* synthetic */ class CC {
        public static AutoMode $default$getAutoMode(HasFanSpeed _this) {
            return AutoMode.Companion.from(_this, _this.getAutoModeText());
        }

        public static UiAutoMode $default$getUiAutoMode(HasFanSpeed _this) {
            return UiAutoMode.Companion.from(_this, _this.getAutoModeText());
        }

        public static FanSpeedEnum $default$getFanSpeedEnum(HasFanSpeed _this) {
            return FanSpeedEnum.Companion.fromServerValue(_this, _this.getFanSpeed());
        }

        public static Filter $default$getFilter(HasFanSpeed _this) {
            return Filter.Companion.fromServerValue(_this.getFilterType());
        }

        public static FilterTrigger $default$getTrigger(HasFanSpeed _this) {
            return FilterTrigger.Companion.fromServerValue(_this.getFilterTrigger());
        }

        public static boolean $default$getHasGear0(HasFanSpeed _this) {
            if ((_this instanceof DeviceHumidifier20) || (_this instanceof DeviceCombo2in120) || (_this instanceof DevicePet20)) {
                return false;
            }
            return !(_this instanceof DeviceMiniRestful) || !((DeviceMiniRestful) _this).hasNightMode();
        }

        public static boolean $default$getHasGear4(HasFanSpeed _this) {
            if (!(_this instanceof DeviceBluePremium)) {
                return ((_this instanceof DeviceG4) && ((DeviceG4) _this).isPlus()) || (_this instanceof DeviceNewClassic) || (_this instanceof DeviceCombo3in1) || (_this instanceof DeviceCombo2in1) || (_this instanceof DeviceBlue40) || (_this instanceof DeviceCombo2in120);
            }
            return true;
        }
    }
}
