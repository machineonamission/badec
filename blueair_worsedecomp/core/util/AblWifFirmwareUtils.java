package com.blueair.core.util;

import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceDetailsOnAblServer;
import com.blueair.core.model.DeviceType;
import io.github.g00fy2.versioncompare.Version;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/blueair/core/util/AblWifFirmwareUtils;", "", "<init>", "()V", "DEVICE_CLASSIC_MINIMUM_FIRMWARE_VERSION", "", "DEVICE_CLASSIC_WITHOUT_SENSORS_MINIMUM_FIRMWARE_VERSION", "DEVICE_AWARE_MINIMUM_FIRMWARE_VERSION", "DEVICE_SENSE_MINIMUM_FIRMWARE_VERSION", "hasAtLeastMinimumWifiFirmwareVersion", "", "device", "Lcom/blueair/core/model/Device;", "minVersion", "deviceInfo", "Lcom/blueair/core/model/DeviceDetailsOnAblServer;", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: AblWifFirmwareUtils.kt */
public final class AblWifFirmwareUtils {
    public static final String DEVICE_AWARE_MINIMUM_FIRMWARE_VERSION = "1.4.0";
    public static final String DEVICE_CLASSIC_MINIMUM_FIRMWARE_VERSION = "1.1.38";
    public static final String DEVICE_CLASSIC_WITHOUT_SENSORS_MINIMUM_FIRMWARE_VERSION = "1.4.0";
    public static final String DEVICE_SENSE_MINIMUM_FIRMWARE_VERSION = "1.4.0";
    public static final AblWifFirmwareUtils INSTANCE = new AblWifFirmwareUtils();

    private AblWifFirmwareUtils() {
    }

    public final boolean hasAtLeastMinimumWifiFirmwareVersion(Device device, String str) {
        Intrinsics.checkNotNullParameter(device, "device");
        Intrinsics.checkNotNullParameter(str, "minVersion");
        return new Version(device.getWifiFirmware()).isAtLeast(str);
    }

    public final boolean hasAtLeastMinimumWifiFirmwareVersion(DeviceDetailsOnAblServer deviceDetailsOnAblServer) {
        Intrinsics.checkNotNullParameter(deviceDetailsOnAblServer, "deviceInfo");
        DeviceType fromSkuCompat = DeviceType.Companion.fromSkuCompat(deviceDetailsOnAblServer.getCompatibility());
        if (Intrinsics.areEqual((Object) fromSkuCompat, (Object) DeviceType.Classic.INSTANCE)) {
            return new Version(deviceDetailsOnAblServer.getFirmware()).isAtLeast(DEVICE_CLASSIC_MINIMUM_FIRMWARE_VERSION);
        }
        if (Intrinsics.areEqual((Object) fromSkuCompat, (Object) DeviceType.Aware.INSTANCE)) {
            return new Version(deviceDetailsOnAblServer.getFirmware()).isAtLeast("1.4.0");
        }
        if (Intrinsics.areEqual((Object) fromSkuCompat, (Object) DeviceType.Sense.INSTANCE)) {
            return new Version(deviceDetailsOnAblServer.getFirmware()).isAtLeast("1.4.0");
        }
        if (Intrinsics.areEqual((Object) fromSkuCompat, (Object) DeviceType.ClassicWithoutSensor.INSTANCE)) {
            return new Version(deviceDetailsOnAblServer.getFirmware()).isAtLeast("1.4.0");
        }
        return true;
    }
}
