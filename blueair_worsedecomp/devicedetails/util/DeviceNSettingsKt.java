package com.blueair.devicedetails.util;

import com.blueair.core.BuildEnvironment;
import com.blueair.core.model.AnalyticEvent;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.DeviceNewClassic;
import com.blueair.core.model.HasTemperatureUnit;
import com.blueair.core.model.HasWick;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"supportSetting", "", "Lcom/blueair/core/model/Device;", "setting", "Lcom/blueair/devicedetails/util/DeviceNSettings;", "devicedetails_otherRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceNSettings.kt */
public final class DeviceNSettingsKt {

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceNSettings.kt */
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
                com.blueair.devicedetails.util.DeviceNSettings[] r0 = com.blueair.devicedetails.util.DeviceNSettings.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.blueair.devicedetails.util.DeviceNSettings r1 = com.blueair.devicedetails.util.DeviceNSettings.TEMPERATURE     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.blueair.devicedetails.util.DeviceNSettings r1 = com.blueair.devicedetails.util.DeviceNSettings.DRY_MODE     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.blueair.devicedetails.util.DeviceNSettings r1 = com.blueair.devicedetails.util.DeviceNSettings.TRIGGER_AUTO     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.blueair.devicedetails.util.DeviceNSettings r1 = com.blueair.devicedetails.util.DeviceNSettings.TRIGGER_NIGHT     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                com.blueair.devicedetails.util.DeviceNSettings r1 = com.blueair.devicedetails.util.DeviceNSettings.SYSTEM_INFO     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.util.DeviceNSettingsKt.WhenMappings.<clinit>():void");
        }
    }

    public static final boolean supportSetting(Device device, DeviceNSettings deviceNSettings) {
        Intrinsics.checkNotNullParameter(device, "<this>");
        Intrinsics.checkNotNullParameter(deviceNSettings, AnalyticEvent.KEY_SETTING);
        if (device instanceof DeviceNewClassic) {
            int i = WhenMappings.$EnumSwitchMapping$0[deviceNSettings.ordinal()];
            return (i == 1 || i == 2 || i == 3 || i == 4 || (i == 5 && BuildEnvironment.INSTANCE.isRelease())) ? false : true;
        } else if (!DeviceKt.isAfterG4(device)) {
            return false;
        } else {
            int i2 = WhenMappings.$EnumSwitchMapping$0[deviceNSettings.ordinal()];
            if (i2 == 1) {
                return device instanceof HasTemperatureUnit;
            }
            if (i2 != 2) {
                return (i2 == 3 || i2 == 4 || (i2 == 5 && BuildEnvironment.INSTANCE.isRelease())) ? false : true;
            }
            return device instanceof HasWick;
        }
    }
}
