package com.blueair.devicedetails.util;

import com.blueair.core.BuildEnvironment;
import com.blueair.core.model.AnalyticEvent;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceB4;
import com.blueair.core.model.DeviceB4sp;
import com.blueair.core.model.DeviceBlue;
import com.blueair.core.model.DeviceBlue40;
import com.blueair.core.model.DeviceBluePremium;
import com.blueair.core.model.DeviceClassic;
import com.blueair.core.model.DeviceG4;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.DeviceNewClassic;
import com.blueair.core.model.Filter;
import com.blueair.core.model.HasBlueCloudFunctions;
import com.blueair.core.model.HasHourFormat;
import com.blueair.core.model.HasLinkingCapability;
import com.blueair.core.model.HasRemoveYellowWater;
import com.blueair.core.model.HasTemperatureUnit;
import com.blueair.core.model.HasWick;
import com.blueair.core.model.HasWickDryDuration;
import com.blueair.core.model.McuFirmwareVersions;
import com.blueair.core.util.SkuConfigurationManager;
import com.blueair.devicedetails.util.DeviceSetting;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"supportSetting", "", "Lcom/blueair/core/model/Device;", "setting", "Lcom/blueair/devicedetails/util/DeviceSetting;", "devicedetails_otherRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceSetting.kt */
public final class DeviceSettingKt {
    public static final boolean supportSetting(Device device, DeviceSetting deviceSetting) {
        Intrinsics.checkNotNullParameter(device, "<this>");
        Intrinsics.checkNotNullParameter(deviceSetting, AnalyticEvent.KEY_SETTING);
        if (Intrinsics.areEqual((Object) deviceSetting, (Object) DeviceSetting.CUSTOM_NAME.INSTANCE) || Intrinsics.areEqual((Object) deviceSetting, (Object) DeviceSetting.PRODUCT_INFO.INSTANCE)) {
            return true;
        }
        if (Intrinsics.areEqual((Object) deviceSetting, (Object) DeviceSetting.HOUR_FORMAT.INSTANCE)) {
            if (!(device instanceof HasHourFormat) || McuFirmwareVersions.Companion.compare(device.getMcuFirmware(), SkuConfigurationManager.INSTANCE.getMcuFirmwareVersions().getMrestHourFormatV2()) < 0) {
                return false;
            }
            return true;
        } else if (Intrinsics.areEqual((Object) deviceSetting, (Object) DeviceSetting.TIMEZONE.INSTANCE)) {
            return device instanceof HasBlueCloudFunctions;
        } else {
            if (Intrinsics.areEqual((Object) deviceSetting, (Object) DeviceSetting.ERROR_REPORT.INSTANCE)) {
                if (!BuildEnvironment.INSTANCE.isRelease()) {
                    return true;
                }
                return false;
            } else if (Intrinsics.areEqual((Object) deviceSetting, (Object) DeviceSetting.USER_MANUAL.INSTANCE)) {
                return true;
            } else {
                if (Intrinsics.areEqual((Object) deviceSetting, (Object) DeviceSetting.WELCOME_HOME.INSTANCE)) {
                    return DeviceKt.useV2UI(device);
                }
                if (Intrinsics.areEqual((Object) deviceSetting, (Object) DeviceSetting.WICK_DRY.INSTANCE)) {
                    return device instanceof HasWickDryDuration;
                }
                if (Intrinsics.areEqual((Object) deviceSetting, (Object) DeviceSetting.WATER_REFRESHER.INSTANCE)) {
                    Boolean bool = null;
                    HasRemoveYellowWater hasRemoveYellowWater = device instanceof HasRemoveYellowWater ? (HasRemoveYellowWater) device : null;
                    if (hasRemoveYellowWater != null) {
                        bool = hasRemoveYellowWater.getYwrmEnabled();
                    }
                    if (bool != null) {
                        return true;
                    }
                    return false;
                } else if (device instanceof DeviceBlue40) {
                    if (Intrinsics.areEqual((Object) deviceSetting, (Object) DeviceSetting.AUTO_REFRESH.INSTANCE) || Intrinsics.areEqual((Object) deviceSetting, (Object) DeviceSetting.DISPLAY_MODE.INSTANCE)) {
                        return true;
                    }
                    if (Intrinsics.areEqual((Object) deviceSetting, (Object) DeviceSetting.TVOC.INSTANCE)) {
                        return ((DeviceBlue40) device).isMediumSize();
                    }
                    return false;
                } else if (device instanceof DeviceG4) {
                    if (Intrinsics.areEqual((Object) deviceSetting, (Object) DeviceSetting.AUTO_MODE_TRIGGERS.INSTANCE)) {
                        if (!((DeviceG4) device).isPlus()) {
                            return true;
                        }
                        return false;
                    } else if (Intrinsics.areEqual((Object) deviceSetting, (Object) DeviceSetting.GERM_SHIELD_MODE.INSTANCE) || Intrinsics.areEqual((Object) deviceSetting, (Object) DeviceSetting.STANDBY_MODE.INSTANCE)) {
                        return true;
                    } else {
                        return false;
                    }
                } else if ((device instanceof DeviceB4) || (device instanceof DeviceBlue) || (device instanceof DeviceBluePremium)) {
                    if (Intrinsics.areEqual((Object) deviceSetting, (Object) DeviceSetting.STANDBY_MODE.INSTANCE)) {
                        return true;
                    }
                    return false;
                } else if (device instanceof DeviceB4sp) {
                    if (Intrinsics.areEqual((Object) deviceSetting, (Object) DeviceSetting.STANDBY_MODE.INSTANCE) || Intrinsics.areEqual((Object) deviceSetting, (Object) DeviceSetting.AUTO_MODE_TRIGGERS.INSTANCE)) {
                        return true;
                    }
                    return false;
                } else if (device instanceof DeviceClassic) {
                    Filter filter = ((DeviceClassic) device).getFilter();
                    if (Intrinsics.areEqual((Object) filter, (Object) Filter.SmokeStopFilter.INSTANCE)) {
                        if (Intrinsics.areEqual((Object) deviceSetting, (Object) DeviceSetting.CHILD_LOCK_MODE.INSTANCE) || Intrinsics.areEqual((Object) deviceSetting, (Object) DeviceSetting.AUTO_MODE_TRIGGERS.INSTANCE)) {
                            return true;
                        }
                        return false;
                    } else if (!Intrinsics.areEqual((Object) filter, (Object) Filter.ParticleFilter.INSTANCE) && !Intrinsics.areEqual((Object) filter, (Object) Filter.UnknownFilter.INSTANCE)) {
                        throw new NoWhenBranchMatchedException();
                    } else if (Intrinsics.areEqual((Object) deviceSetting, (Object) DeviceSetting.CHILD_LOCK_MODE.INSTANCE)) {
                        return true;
                    } else {
                        return false;
                    }
                } else if (device instanceof HasLinkingCapability) {
                    Filter filter2 = ((HasLinkingCapability) device).getFilter();
                    if (Intrinsics.areEqual((Object) filter2, (Object) Filter.SmokeStopFilter.INSTANCE)) {
                        if (Intrinsics.areEqual((Object) deviceSetting, (Object) DeviceSetting.LINKED_DEVICE.INSTANCE) || Intrinsics.areEqual((Object) deviceSetting, (Object) DeviceSetting.CHILD_LOCK_MODE.INSTANCE) || Intrinsics.areEqual((Object) deviceSetting, (Object) DeviceSetting.AUTO_MODE_TRIGGERS.INSTANCE)) {
                            return true;
                        }
                        return false;
                    } else if (!Intrinsics.areEqual((Object) filter2, (Object) Filter.ParticleFilter.INSTANCE) && !Intrinsics.areEqual((Object) filter2, (Object) Filter.UnknownFilter.INSTANCE)) {
                        throw new NoWhenBranchMatchedException();
                    } else if (Intrinsics.areEqual((Object) deviceSetting, (Object) DeviceSetting.LINKED_DEVICE.INSTANCE) || Intrinsics.areEqual((Object) deviceSetting, (Object) DeviceSetting.CHILD_LOCK_MODE.INSTANCE)) {
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    if (!(device instanceof DeviceNewClassic) && DeviceKt.isAfterG4(device)) {
                        if (Intrinsics.areEqual((Object) deviceSetting, (Object) DeviceSetting.TEMPERATURE.INSTANCE)) {
                            return device instanceof HasTemperatureUnit;
                        }
                        if (!Intrinsics.areEqual((Object) deviceSetting, (Object) DeviceSetting.DRY_MODE.INSTANCE) || !(device instanceof HasWick) || (device instanceof HasWickDryDuration)) {
                            return false;
                        }
                        return true;
                    }
                    return false;
                }
            }
        }
    }
}
