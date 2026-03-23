package com.blueair.devicedetails.util;

import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceB4;
import com.blueair.core.model.DeviceB4sp;
import com.blueair.core.model.DeviceBlue;
import com.blueair.core.model.DeviceBluePremium;
import com.blueair.core.model.DeviceG4;
import com.blueair.core.model.DeviceIcp;
import com.blueair.viewcore.R;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"deriveInfo", "Lcom/blueair/devicedetails/util/DeviceInfo;", "Lcom/blueair/core/model/Device;", "infoType", "Lcom/blueair/devicedetails/util/DeviceInfoType;", "devicedetails_otherRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceInfo.kt */
public final class DeviceInfoKt {

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceInfo.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(13:0|1|2|3|4|5|6|7|8|9|10|11|13) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                com.blueair.devicedetails.util.DeviceInfoType[] r0 = com.blueair.devicedetails.util.DeviceInfoType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.blueair.devicedetails.util.DeviceInfoType r1 = com.blueair.devicedetails.util.DeviceInfoType.PRODUCT_TYPE     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.blueair.devicedetails.util.DeviceInfoType r1 = com.blueair.devicedetails.util.DeviceInfoType.MAC_ADDRESS     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.blueair.devicedetails.util.DeviceInfoType r1 = com.blueair.devicedetails.util.DeviceInfoType.SERIAL_NUMBER     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.blueair.devicedetails.util.DeviceInfoType r1 = com.blueair.devicedetails.util.DeviceInfoType.WIFI_FIRMWARE     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                com.blueair.devicedetails.util.DeviceInfoType r1 = com.blueair.devicedetails.util.DeviceInfoType.MCU_FIRMWARE     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.util.DeviceInfoKt.WhenMappings.<clinit>():void");
        }
    }

    public static final DeviceInfo deriveInfo(Device device, DeviceInfoType deviceInfoType) {
        Intrinsics.checkNotNullParameter(device, "<this>");
        Intrinsics.checkNotNullParameter(deviceInfoType, "infoType");
        if ((device instanceof DeviceG4) || (device instanceof DeviceB4) || (device instanceof DeviceB4sp) || (device instanceof DeviceBlue) || (device instanceof DeviceBluePremium)) {
            int i = WhenMappings.$EnumSwitchMapping$0[deviceInfoType.ordinal()];
            if (!(i == 1 || i == 2 || i == 3 || i == 4 || i == 5)) {
                throw new NoWhenBranchMatchedException();
            }
        } else {
            if (device instanceof DeviceIcp) {
            }
            return null;
        }
        int i2 = WhenMappings.$EnumSwitchMapping$0[deviceInfoType.ordinal()];
        if (i2 == 1) {
            return new DeviceInfo(deviceInfoType, R.string.product_type, device.getModelName());
        }
        if (i2 != 2) {
            if (i2 != 3) {
                if (i2 != 4) {
                    if (i2 != 5) {
                        throw new NoWhenBranchMatchedException();
                    } else if (device.getMcuFirmware().length() == 0) {
                        return null;
                    } else {
                        return new DeviceInfo(deviceInfoType, R.string.mcu_firmware, device.getMcuFirmware());
                    }
                } else if (device.getWifiFirmware().length() == 0) {
                    return null;
                } else {
                    return new DeviceInfo(deviceInfoType, device instanceof DeviceIcp ? R.string.bt_firmware : R.string.wifi_firmware, device.getWifiFirmware());
                }
            } else if (Intrinsics.areEqual((Object) device.getSerial(), (Object) "123456-123-123-1-12-1-1234567")) {
                return null;
            } else {
                return new DeviceInfo(deviceInfoType, R.string.serial_number, device.getSerial());
            }
        } else if (Intrinsics.areEqual((Object) device.getMac(), (Object) "ff:ff:ff:ff:ff:ff")) {
            return null;
        } else {
            return new DeviceInfo(deviceInfoType, R.string.device_mac, device.getMac());
        }
    }
}
