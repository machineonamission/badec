package com.blueair.core.model;

import com.blueair.core.model.DeviceType;
import com.blueair.core.model.FilterLifeTime;
import com.blueair.core.util.SkuConfigurationManager;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0006\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002\u001a\n\u0010\u0006\u001a\u00020\u0004*\u00020\u0002\u001a\n\u0010\u0007\u001a\u00020\u0004*\u00020\u0002\u001a\n\u0010\b\u001a\u00020\u0004*\u00020\u0002\u001a\n\u0010\t\u001a\u00020\u0004*\u00020\u0002\u001a\f\u0010\n\u001a\u00020\u0004*\u0004\u0018\u00010\u0002\u001a\n\u0010\u000b\u001a\u00020\f*\u00020\u0002\u001a\n\u0010\r\u001a\u00020\u0004*\u00020\u0002\u001a\n\u0010\u000e\u001a\u00020\u0004*\u00020\u0002\u001a\n\u0010\u000f\u001a\u00020\u0004*\u00020\u0002\u001a\n\u0010\u0010\u001a\u00020\u0004*\u00020\u0002\u001a\n\u0010\u0011\u001a\u00020\u0004*\u00020\u0002\u001a\n\u0010\u0012\u001a\u00020\u0004*\u00020\u0002\u001a\n\u0010\u001f\u001a\u00020\u0004*\u00020\u0002\u001a\n\u0010 \u001a\u00020\u0004*\u00020\u0002\"\u0015\u0010\u0013\u001a\u00020\u0004*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014\"\u0015\u0010\u0015\u001a\u00020\u0004*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0014\"\u0015\u0010\u0016\u001a\u00020\u0004*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0014\"\u0015\u0010\u0017\u001a\u00020\u0004*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0014\"\u0015\u0010\u0018\u001a\u00020\u0004*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0014\"\u0015\u0010\u0019\u001a\u00020\u0004*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0014\"\u0017\u0010\u001a\u001a\u0004\u0018\u00010\u001b*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d\"\u0015\u0010\u001e\u001a\u00020\u0004*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0014¨\u0006!"}, d2 = {"getFilterLifeTime", "Lcom/blueair/core/model/FilterLifeTime;", "Lcom/blueair/core/model/Device;", "isG4orB4orNB", "", "device", "isDisinfectionOn", "supportDisinfection", "isGermShieldOn", "isGermShieldPlus", "isCelsiusUnit", "fanSpeedValue", "", "useNewFilterConfig", "useV2UI", "hasAirFilter", "useWatetdropAuto", "supportSkinMode", "shouldMergeFilter", "isStandByOn", "(Lcom/blueair/core/model/Device;)Z", "isSafetySwitchOn", "isAfterG4", "isNewBlue", "isNoncancelable", "isCancellable", "skuCompat", "", "getSkuCompat", "(Lcom/blueair/core/model/Device;)Ljava/lang/String;", "isHumidifyModeOn", "hasFrontPanel", "useNewBrightnessRange", "core_otherRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* compiled from: Device.kt */
public final class DeviceKt {
    public static final FilterLifeTime getFilterLifeTime(Device device) {
        int i;
        Intrinsics.checkNotNullParameter(device, "<this>");
        Timber.Forest forest = Timber.Forest;
        int i2 = 0;
        forest.v("Calculating Filter Days Left for Device " + device, new Object[0]);
        if ((device instanceof DeviceHumidifier20) || (device instanceof DeviceHumidifier)) {
            return new FilterLifeTime.NoFilterInfo();
        }
        if (!(device instanceof HasFanSpeed)) {
            return new FilterLifeTime.NoFilterInfo();
        }
        Integer filterLife = ((HasFanSpeed) device).getFilterLife();
        if (filterLife == null) {
            return new FilterLifeTime.NoFilterInfo();
        }
        int intValue = filterLife.intValue();
        if (isG4orB4orNB(device)) {
            return new FilterLifeTime.FilterPercentageLeft(Math.max(0, 100 - intValue));
        }
        if (device.getType() instanceof DeviceType.Icp) {
            if (intValue > 0) {
                i = Double.valueOf((((double) intValue) * 100.0d) / ((double) 21600));
            } else {
                i = 0;
            }
            return new FilterLifeTime.FilterPercentageLeft(i.intValue());
        }
        int max = Math.max(0, (int) Math.floor((double) ((intValue * 5) / 1444)));
        if (max <= 180) {
            i2 = max;
        }
        return new FilterLifeTime.FilterDaysLeft(180 - i2, Integer.valueOf((int) Math.max(0.0d, ((double) 99) - (((double) (i2 * 100)) / ((double) 180)))));
    }

    public static final boolean isG4orB4orNB(Device device) {
        Intrinsics.checkNotNullParameter(device, "device");
        return (device instanceof DeviceG4) || (device instanceof DeviceB4) || (device instanceof DeviceB4sp) || (device instanceof DeviceBlue) || (device instanceof DeviceBluePremium) || isAfterG4(device);
    }

    public static final boolean isDisinfectionOn(Device device) {
        Intrinsics.checkNotNullParameter(device, "<this>");
        return (device instanceof HasDisinfection) && Intrinsics.areEqual((Object) ((HasDisinfection) device).getDisinfection(), (Object) true);
    }

    public static final boolean supportDisinfection(Device device) {
        Intrinsics.checkNotNullParameter(device, "<this>");
        return (device instanceof HasDisinfection) && ((HasDisinfection) device).getDisinfection() != null;
    }

    public static final boolean isGermShieldOn(Device device) {
        boolean z;
        Intrinsics.checkNotNullParameter(device, "<this>");
        if (device instanceof HasGermShieldMode) {
            boolean z2 = !(device instanceof HasStandBy) || !((HasStandBy) device).isStandByOn();
            boolean isG4NightModeOn = device instanceof HasG4NightMode ? ((HasG4NightMode) device).isG4NightModeOn() : false;
            if (z2) {
                HasGermShieldMode hasGermShieldMode = (HasGermShieldMode) device;
                if (!hasGermShieldMode.getHasGermShieldNightMode() || !isG4NightModeOn) {
                    z = hasGermShieldMode.isGermShieldModeOn();
                } else {
                    Boolean isGermShieldNightModeOn = hasGermShieldMode.isGermShieldNightModeOn();
                    z = isGermShieldNightModeOn != null ? isGermShieldNightModeOn.booleanValue() : true;
                }
                if (z) {
                    return true;
                }
            }
        }
        return false;
    }

    public static final boolean isGermShieldPlus(Device device) {
        Intrinsics.checkNotNullParameter(device, "<this>");
        return (device instanceof HasGermShieldMode) && ((HasGermShieldMode) device).isGermShieldPlus();
    }

    public static final boolean isCelsiusUnit(Device device) {
        return !(device instanceof HasTemperatureUnit) || ((HasTemperatureUnit) device).getTemperatureUnit() != TemperatureUnit.Fahrenheit.getValue();
    }

    public static final int fanSpeedValue(Device device) {
        Intrinsics.checkNotNullParameter(device, "<this>");
        if (device instanceof HasCombo3in1MainMode) {
            return ((HasCombo3in1MainMode) device).currentFanSpeed();
        }
        HasFanSpeed hasFanSpeed = device instanceof HasFanSpeed ? (HasFanSpeed) device : null;
        if (hasFanSpeed != null) {
            return hasFanSpeed.getFanSpeed();
        }
        return 0;
    }

    public static final boolean useNewFilterConfig(Device device) {
        Intrinsics.checkNotNullParameter(device, "<this>");
        return isAfterG4(device) || isNewBlue(device);
    }

    public static final boolean useV2UI(Device device) {
        Intrinsics.checkNotNullParameter(device, "<this>");
        return device.getTypeIndex() >= DeviceType.Dehumidifier.INSTANCE.getIndex() || isNewBlue(device) || (device instanceof DeviceHumidifier) || (device instanceof DeviceB4) || (device instanceof DeviceB4sp);
    }

    public static final boolean hasAirFilter(Device device) {
        Intrinsics.checkNotNullParameter(device, "<this>");
        return !(device instanceof DeviceHumidifier) && !(device instanceof DeviceHumidifier20);
    }

    public static final boolean useWatetdropAuto(Device device) {
        Intrinsics.checkNotNullParameter(device, "<this>");
        return device instanceof DeviceHumidifier20;
    }

    public static final boolean supportSkinMode(Device device) {
        Intrinsics.checkNotNullParameter(device, "<this>");
        return device instanceof DeviceCombo2in120;
    }

    public static final boolean shouldMergeFilter(Device device) {
        Intrinsics.checkNotNullParameter(device, "<this>");
        return (device instanceof DeviceCombo2in120) || (device instanceof DeviceHumidifier20);
    }

    public static final boolean isStandByOn(Device device) {
        Intrinsics.checkNotNullParameter(device, "<this>");
        if (device instanceof HasStandBy) {
            return ((HasStandBy) device).isStandByOn();
        }
        return false;
    }

    public static final boolean isSafetySwitchOn(Device device) {
        Intrinsics.checkNotNullParameter(device, "<this>");
        if (device instanceof HasSafetySwitch) {
            return ((HasSafetySwitch) device).isSafetySwitchOn();
        }
        return true;
    }

    public static final boolean isAfterG4(Device device) {
        Intrinsics.checkNotNullParameter(device, "<this>");
        return device.getTypeIndex() > DeviceType.Blue.INSTANCE.getIndex();
    }

    public static final boolean isNewBlue(Device device) {
        Intrinsics.checkNotNullParameter(device, "<this>");
        return (device instanceof DeviceBlue) || (device instanceof DeviceBluePremium);
    }

    public static final boolean isNoncancelable(Device device) {
        Intrinsics.checkNotNullParameter(device, "<this>");
        if (!(device instanceof DeviceHumidifier20)) {
            return (device instanceof HasHumMainMode) && ((HasHumMainMode) device).isInMainMode(MainMode.AirPurify);
        }
        return true;
    }

    public static final boolean isCancellable(Device device) {
        Intrinsics.checkNotNullParameter(device, "<this>");
        return !isNoncancelable(device);
    }

    public static final String getSkuCompat(Device device) {
        String compatibility;
        Intrinsics.checkNotNullParameter(device, "<this>");
        if (device instanceof HasSKU) {
            return ((HasSKU) device).getSku();
        }
        if (!(device instanceof HasCompatibility) || (compatibility = ((HasCompatibility) device).getCompatibility()) == null) {
            return null;
        }
        String lowerCase = compatibility.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    public static final boolean isHumidifyModeOn(Device device) {
        Intrinsics.checkNotNullParameter(device, "<this>");
        HasHumMainMode hasHumMainMode = null;
        HasHumMode hasHumMode = device instanceof HasHumMode ? (HasHumMode) device : null;
        if (hasHumMode == null || !hasHumMode.getHumMode()) {
            if (device instanceof HasHumMainMode) {
                hasHumMainMode = (HasHumMainMode) device;
            }
            if (hasHumMainMode == null || !hasHumMainMode.isInMainMode(MainMode.Humidification)) {
                return false;
            }
        }
        return true;
    }

    public static final boolean hasFrontPanel(Device device) {
        Intrinsics.checkNotNullParameter(device, "<this>");
        return device instanceof DeviceCombo2in120;
    }

    public static final boolean useNewBrightnessRange(Device device) {
        String str;
        Intrinsics.checkNotNullParameter(device, "<this>");
        McuFirmwareVersions mcuFirmwareVersions = SkuConfigurationManager.INSTANCE.getMcuFirmwareVersions();
        DeviceType type = device.getType();
        if (Intrinsics.areEqual((Object) type, (Object) DeviceType.MiniRestful.INSTANCE)) {
            str = mcuFirmwareVersions.getMrestBrightnessV2();
        } else if (Intrinsics.areEqual((Object) type, (Object) DeviceType.Humidifier20.INSTANCE)) {
            str = mcuFirmwareVersions.getHum20BrightnessV2();
        } else if (Intrinsics.areEqual((Object) type, (Object) DeviceType.Dehumidifier.INSTANCE)) {
            str = mcuFirmwareVersions.getDehumidifierBrightnessV2();
        } else if (Intrinsics.areEqual((Object) type, (Object) DeviceType.Combo2in120.INSTANCE)) {
            str = mcuFirmwareVersions.getCombo2in120BrightnessV2();
        } else if (Intrinsics.areEqual((Object) type, (Object) DeviceType.Blue40.INSTANCE)) {
            str = mcuFirmwareVersions.getBlue40BrightnessV2();
        } else {
            if (Intrinsics.areEqual((Object) type, (Object) DeviceType.Pet20.INSTANCE)) {
                str = mcuFirmwareVersions.getPet20BrightnessV2();
            }
            return false;
        }
        if (McuFirmwareVersions.Companion.compare(device.getMcuFirmware(), str) < 0) {
            return true;
        }
        return false;
    }
}
