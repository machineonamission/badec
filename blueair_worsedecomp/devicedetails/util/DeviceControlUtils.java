package com.blueair.devicedetails.util;

import com.blueair.core.model.ApSubMode;
import com.blueair.core.model.AutoMode;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceB4;
import com.blueair.core.model.DeviceB4sp;
import com.blueair.core.model.DeviceBlue40;
import com.blueair.core.model.DeviceCombo2in120;
import com.blueair.core.model.DeviceDehumidifier;
import com.blueair.core.model.DeviceG4;
import com.blueair.core.model.DeviceHumidifier;
import com.blueair.core.model.DeviceHumidifier20;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.HasBody;
import com.blueair.core.model.HasFanSpeed;
import com.blueair.core.model.HasG4NightMode;
import com.blueair.core.model.HasHumMainMode;
import com.blueair.core.model.HasMainMode;
import com.blueair.core.model.HasMode;
import com.blueair.core.model.HasPetMainMode;
import com.blueair.core.model.HasTimer;
import com.blueair.core.model.HumSubMode;
import com.blueair.core.model.MainMode;
import com.blueair.core.model.Mode;
import com.blueair.core.model.WaterLevel;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\b\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u001c\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\u0010\f\u001a\u00020\r\"\u00020\u000eH\u0002J\u000e\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002¨\u0006\u0011"}, d2 = {"Lcom/blueair/devicedetails/util/DeviceControlUtils;", "", "<init>", "()V", "shouldHideFanSpeed", "", "device", "Lcom/blueair/core/model/Device;", "shouldShowTimer", "shouldShowBrightness", "isFanMode", "checkAirPurifySubMode", "subModes", "", "", "checkAutoMode", "checkNightMode", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceControl.kt */
public final class DeviceControlUtils {
    public static final DeviceControlUtils INSTANCE = new DeviceControlUtils();

    private DeviceControlUtils() {
    }

    public final boolean shouldHideFanSpeed(Device device) {
        Intrinsics.checkNotNullParameter(device, "device");
        if (device instanceof DeviceHumidifier20) {
            DeviceHumidifier20 deviceHumidifier20 = (DeviceHumidifier20) device;
            return deviceHumidifier20.getWickdryOn() || deviceHumidifier20.isInWaterLevel(WaterLevel.SHORTAGE);
        } else if (!(device instanceof DeviceCombo2in120)) {
            return (device instanceof HasBody) && !((HasBody) device).getBodyMounted();
        } else {
            DeviceCombo2in120 deviceCombo2in120 = (DeviceCombo2in120) device;
            return deviceCombo2in120.getWickdryOn() || (deviceCombo2in120.isInMainMode(MainMode.Humidification) && (deviceCombo2in120.isInWaterLevel(WaterLevel.SHORTAGE) || deviceCombo2in120.getWaterTankFailure()));
        }
    }

    public final boolean shouldShowTimer(Device device) {
        return (device instanceof HasTimer) && !(device instanceof DeviceBlue40);
    }

    public final boolean shouldShowBrightness(Device device) {
        Intrinsics.checkNotNullParameter(device, "device");
        if (device instanceof DeviceCombo2in120) {
            DeviceCombo2in120 deviceCombo2in120 = (DeviceCombo2in120) device;
            if (deviceCombo2in120.getWickdryOn()) {
                return true;
            }
            return DeviceKt.isHumidifyModeOn(device) ? !deviceCombo2in120.isInHumSubMode(HumSubMode.NIGHT) : !deviceCombo2in120.isInApSubMode(ApSubMode.NIGHT);
        } else if (checkAirPurifySubMode(device, ApSubMode.FAN.getValue(), ApSubMode.AUTO.getValue())) {
            return true;
        } else {
            if (device instanceof DeviceDehumidifier) {
                return ((DeviceDehumidifier) device).isInMainMode(MainMode.Dehumidification);
            }
            if (device instanceof DeviceHumidifier20) {
                return ((DeviceHumidifier20) device).getWickdryOn() || !checkNightMode(device);
            }
            if (device instanceof HasMode) {
                return !((HasMode) device).isInMode(Mode.NIGHT);
            }
            if (device instanceof HasPetMainMode) {
                return ((HasPetMainMode) device).isInMainMode(MainMode.SMART);
            }
            return (DeviceKt.isNewBlue(device) || (device instanceof DeviceHumidifier) || (device instanceof DeviceB4) || (device instanceof DeviceB4sp) || (device instanceof DeviceG4)) && !checkNightMode(device);
        }
    }

    public final boolean isFanMode(Device device) {
        Intrinsics.checkNotNullParameter(device, "device");
        if (checkAirPurifySubMode(device, ApSubMode.FAN.getValue())) {
            return true;
        }
        if (device instanceof HasMode) {
            return ((HasMode) device).isInMode(Mode.FAN);
        }
        if (device instanceof HasHumMainMode) {
            if (!DeviceKt.isHumidifyModeOn(device) || !((HasHumMainMode) device).isInHumSubMode(HumSubMode.FAN)) {
                return false;
            }
            return true;
        } else if ((DeviceKt.isNewBlue(device) || (device instanceof DeviceHumidifier20) || (device instanceof DeviceHumidifier) || (device instanceof DeviceB4) || (device instanceof DeviceG4)) && !checkAutoMode(device) && !checkNightMode(device)) {
            return true;
        } else {
            return false;
        }
    }

    private final boolean checkAirPurifySubMode(Device device, int... iArr) {
        if (!(device instanceof HasMainMode)) {
            return false;
        }
        HasMainMode hasMainMode = (HasMainMode) device;
        return hasMainMode.isInMainMode(MainMode.AirPurify) && ArraysKt.contains(iArr, hasMainMode.getApSubMode());
    }

    public final boolean checkAutoMode(Device device) {
        Intrinsics.checkNotNullParameter(device, "device");
        HasMode hasMode = null;
        HasFanSpeed hasFanSpeed = device instanceof HasFanSpeed ? (HasFanSpeed) device : null;
        if ((hasFanSpeed != null ? hasFanSpeed.getAutoMode() : null) != AutoMode.ON) {
            if (device instanceof HasMode) {
                hasMode = (HasMode) device;
            }
            if (hasMode == null || !hasMode.isInMode(Mode.AUTO)) {
                return false;
            }
        }
        return true;
    }

    private final boolean checkNightMode(Device device) {
        HasG4NightMode hasG4NightMode = device instanceof HasG4NightMode ? (HasG4NightMode) device : null;
        return hasG4NightMode != null && hasG4NightMode.isG4NightModeOn();
    }
}
