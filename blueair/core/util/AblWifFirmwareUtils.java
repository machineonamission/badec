package com.blueair.core.util;

import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceDetailsOnAblServer;
import com.blueair.core.model.DeviceType;
import io.github.g00fy2.versioncompare.Version;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0010"},
   d2 = {"Lcom/blueair/core/util/AblWifFirmwareUtils;", "", "<init>", "()V", "DEVICE_CLASSIC_MINIMUM_FIRMWARE_VERSION", "", "DEVICE_CLASSIC_WITHOUT_SENSORS_MINIMUM_FIRMWARE_VERSION", "DEVICE_AWARE_MINIMUM_FIRMWARE_VERSION", "DEVICE_SENSE_MINIMUM_FIRMWARE_VERSION", "hasAtLeastMinimumWifiFirmwareVersion", "", "device", "Lcom/blueair/core/model/Device;", "minVersion", "deviceInfo", "Lcom/blueair/core/model/DeviceDetailsOnAblServer;", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class AblWifFirmwareUtils {
   public static final String DEVICE_AWARE_MINIMUM_FIRMWARE_VERSION = "1.4.0";
   public static final String DEVICE_CLASSIC_MINIMUM_FIRMWARE_VERSION = "1.1.38";
   public static final String DEVICE_CLASSIC_WITHOUT_SENSORS_MINIMUM_FIRMWARE_VERSION = "1.4.0";
   public static final String DEVICE_SENSE_MINIMUM_FIRMWARE_VERSION = "1.4.0";
   public static final AblWifFirmwareUtils INSTANCE = new AblWifFirmwareUtils();

   private AblWifFirmwareUtils() {
   }

   public final boolean hasAtLeastMinimumWifiFirmwareVersion(Device var1, String var2) {
      Intrinsics.checkNotNullParameter(var1, "device");
      Intrinsics.checkNotNullParameter(var2, "minVersion");
      return (new Version(var1.getWifiFirmware())).isAtLeast(var2);
   }

   public final boolean hasAtLeastMinimumWifiFirmwareVersion(DeviceDetailsOnAblServer var1) {
      Intrinsics.checkNotNullParameter(var1, "deviceInfo");
      DeviceType var2 = DeviceType.Companion.fromSkuCompat(var1.getCompatibility());
      if (Intrinsics.areEqual(var2, DeviceType.Classic.INSTANCE)) {
         return (new Version(var1.getFirmware())).isAtLeast("1.1.38");
      } else if (Intrinsics.areEqual(var2, DeviceType.Aware.INSTANCE)) {
         return (new Version(var1.getFirmware())).isAtLeast("1.4.0");
      } else if (Intrinsics.areEqual(var2, DeviceType.Sense.INSTANCE)) {
         return (new Version(var1.getFirmware())).isAtLeast("1.4.0");
      } else {
         return Intrinsics.areEqual(var2, DeviceType.ClassicWithoutSensor.INSTANCE) ? (new Version(var1.getFirmware())).isAtLeast("1.4.0") : true;
      }
   }
}
