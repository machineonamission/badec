package com.blueair.devicedetails.util;

import android.content.Context;
import com.blueair.core.model.ApSubMode;
import com.blueair.core.model.AutoMode;
import com.blueair.core.model.ConnectivityStatus;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceAware;
import com.blueair.core.model.DeviceB4;
import com.blueair.core.model.DeviceB4sp;
import com.blueair.core.model.DeviceBlue;
import com.blueair.core.model.DeviceBluePremium;
import com.blueair.core.model.DeviceClassic;
import com.blueair.core.model.DeviceCombo2in1;
import com.blueair.core.model.DeviceCombo3in1;
import com.blueair.core.model.DeviceG4;
import com.blueair.core.model.DeviceHumidifier;
import com.blueair.core.model.DeviceIcp;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.DeviceNewClassic;
import com.blueair.core.model.DevicePet20;
import com.blueair.core.model.HasBlueCloudFunctions;
import com.blueair.core.model.HasBrightness;
import com.blueair.core.model.HasFanSpeed;
import com.blueair.core.model.HasG4NightMode;
import com.blueair.core.model.HasGermShieldMode;
import com.blueair.core.model.HasLinkingCapability;
import com.blueair.core.model.HasStandBy;
import com.blueair.core.model.MainMode;
import com.blueair.core.model.Mode;
import com.blueair.devicedetails.util.DeviceAttribute;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0001H\u0002¨\u0006\u0006"}, d2 = {"supportAttribute", "", "Lcom/blueair/core/model/Device;", "attribute", "Lcom/blueair/devicedetails/util/DeviceAttribute;", "forceOffline", "devicedetails_otherRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceAttribute.kt */
public final class DeviceAttributeKt {

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceAttribute.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(54:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|(2:51|52)|53|55) */
        /* JADX WARNING: Can't wrap try/catch for region: R(55:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|55) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0034 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x003d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0046 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0050 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x005a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0064 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x006e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0082 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x008c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0096 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00a0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00aa */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x00b4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x00be */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x00c8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x00d2 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x00dc */
        /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x00e6 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x00f0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x00fa */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                com.blueair.devicedetails.util.DeviceAttribute[] r0 = com.blueair.devicedetails.util.DeviceAttribute.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.blueair.devicedetails.util.DeviceAttribute r1 = com.blueair.devicedetails.util.DeviceAttribute.N_ON_OFF     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.blueair.devicedetails.util.DeviceAttribute r1 = com.blueair.devicedetails.util.DeviceAttribute.N_MODE_BUTTONS     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.blueair.devicedetails.util.DeviceAttribute r1 = com.blueair.devicedetails.util.DeviceAttribute.N_FILTER_STATUS     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.blueair.devicedetails.util.DeviceAttribute r1 = com.blueair.devicedetails.util.DeviceAttribute.N_FAN_SPEED     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                com.blueair.devicedetails.util.DeviceAttribute r1 = com.blueair.devicedetails.util.DeviceAttribute.N_BRIGHTNESS     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                com.blueair.devicedetails.util.DeviceAttribute r1 = com.blueair.devicedetails.util.DeviceAttribute.TIMER     // Catch:{ NoSuchFieldError -> 0x003d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                com.blueair.devicedetails.util.DeviceAttribute r1 = com.blueair.devicedetails.util.DeviceAttribute.N_CHILD_LOCK     // Catch:{ NoSuchFieldError -> 0x0046 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0046 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0046 }
            L_0x0046:
                com.blueair.devicedetails.util.DeviceAttribute r1 = com.blueair.devicedetails.util.DeviceAttribute.DETECT_CAT     // Catch:{ NoSuchFieldError -> 0x0050 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0050 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0050 }
            L_0x0050:
                com.blueair.devicedetails.util.DeviceAttribute r1 = com.blueair.devicedetails.util.DeviceAttribute.HUM_ON_OFF     // Catch:{ NoSuchFieldError -> 0x005a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x005a }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x005a }
            L_0x005a:
                com.blueair.devicedetails.util.DeviceAttribute r1 = com.blueair.devicedetails.util.DeviceAttribute.WICK_STATUS     // Catch:{ NoSuchFieldError -> 0x0064 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0064 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0064 }
            L_0x0064:
                com.blueair.devicedetails.util.DeviceAttribute r1 = com.blueair.devicedetails.util.DeviceAttribute.DRY_MODE     // Catch:{ NoSuchFieldError -> 0x006e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006e }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006e }
            L_0x006e:
                com.blueair.devicedetails.util.DeviceAttribute r1 = com.blueair.devicedetails.util.DeviceAttribute.AUTO_RH     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                com.blueair.devicedetails.util.DeviceAttribute r1 = com.blueair.devicedetails.util.DeviceAttribute.FAN_PRESET     // Catch:{ NoSuchFieldError -> 0x0082 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0082 }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0082 }
            L_0x0082:
                com.blueair.devicedetails.util.DeviceAttribute r1 = com.blueair.devicedetails.util.DeviceAttribute.TARGET_TEMPERATURE     // Catch:{ NoSuchFieldError -> 0x008c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x008c }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x008c }
            L_0x008c:
                com.blueair.devicedetails.util.DeviceAttribute r1 = com.blueair.devicedetails.util.DeviceAttribute.OSCILLATION     // Catch:{ NoSuchFieldError -> 0x0096 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0096 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0096 }
            L_0x0096:
                com.blueair.devicedetails.util.DeviceAttribute r1 = com.blueair.devicedetails.util.DeviceAttribute.N_HINS     // Catch:{ NoSuchFieldError -> 0x00a0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a0 }
            L_0x00a0:
                com.blueair.devicedetails.util.DeviceAttribute r1 = com.blueair.devicedetails.util.DeviceAttribute.N_OFFLINE     // Catch:{ NoSuchFieldError -> 0x00aa }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00aa }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00aa }
            L_0x00aa:
                com.blueair.devicedetails.util.DeviceAttribute r1 = com.blueair.devicedetails.util.DeviceAttribute.MANUAL_MODE     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 18
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                com.blueair.devicedetails.util.DeviceAttribute r1 = com.blueair.devicedetails.util.DeviceAttribute.CLEAN_AIR_ETA     // Catch:{ NoSuchFieldError -> 0x00be }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00be }
                r2 = 19
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00be }
            L_0x00be:
                com.blueair.devicedetails.util.DeviceAttribute r1 = com.blueair.devicedetails.util.DeviceAttribute.MODE_BUTTONS     // Catch:{ NoSuchFieldError -> 0x00c8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c8 }
                r2 = 20
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c8 }
            L_0x00c8:
                com.blueair.devicedetails.util.DeviceAttribute r1 = com.blueair.devicedetails.util.DeviceAttribute.GERMSHIELD_STATUS     // Catch:{ NoSuchFieldError -> 0x00d2 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d2 }
                r2 = 21
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00d2 }
            L_0x00d2:
                com.blueair.devicedetails.util.DeviceAttribute r1 = com.blueair.devicedetails.util.DeviceAttribute.AUTO_MODE     // Catch:{ NoSuchFieldError -> 0x00dc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00dc }
                r2 = 22
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00dc }
            L_0x00dc:
                com.blueair.devicedetails.util.DeviceAttribute r1 = com.blueair.devicedetails.util.DeviceAttribute.BRIGHTNESS     // Catch:{ NoSuchFieldError -> 0x00e6 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00e6 }
                r2 = 23
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00e6 }
            L_0x00e6:
                com.blueair.devicedetails.util.DeviceAttribute r1 = com.blueair.devicedetails.util.DeviceAttribute.TIMEZONE     // Catch:{ NoSuchFieldError -> 0x00f0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00f0 }
                r2 = 24
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00f0 }
            L_0x00f0:
                com.blueair.devicedetails.util.DeviceAttribute r1 = com.blueair.devicedetails.util.DeviceAttribute.FILTER_STATUS     // Catch:{ NoSuchFieldError -> 0x00fa }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00fa }
                r2 = 25
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00fa }
            L_0x00fa:
                com.blueair.devicedetails.util.DeviceAttribute r1 = com.blueair.devicedetails.util.DeviceAttribute.OFFLINE     // Catch:{ NoSuchFieldError -> 0x0104 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0104 }
                r2 = 26
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0104 }
            L_0x0104:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.util.DeviceAttributeKt.WhenMappings.<clinit>():void");
        }
    }

    /* access modifiers changed from: private */
    public static final boolean supportAttribute(Device device, DeviceAttribute deviceAttribute, boolean z) {
        boolean z2 = device.getConnectivityStatus() == ConnectivityStatus.ONLINE && !z;
        if (device instanceof DevicePet20) {
            if (z2) {
                switch (WhenMappings.$EnumSwitchMapping$0[deviceAttribute.ordinal()]) {
                    case 1:
                    case 2:
                    case 3:
                        return true;
                    case 4:
                        DevicePet20 devicePet20 = (DevicePet20) device;
                        return !devicePet20.isStandByOn() && devicePet20.isInMainMode(MainMode.AirPurify) && devicePet20.isInApSubMode(ApSubMode.FAN);
                    case 5:
                        DevicePet20 devicePet202 = (DevicePet20) device;
                        return !devicePet202.isStandByOn() && (!devicePet202.isInMainMode(MainMode.AirPurify) || !devicePet202.isInApSubMode(ApSubMode.NIGHT));
                    case 6:
                    case 7:
                        return !((DevicePet20) device).isStandByOn();
                    case 8:
                        return DeviceAttribute.Companion.getShowDetectCat();
                    default:
                        return false;
                }
            } else {
                return SetsKt.setOf(DeviceAttribute.N_OFFLINE, DeviceAttribute.N_FILTER_STATUS).contains(deviceAttribute);
            }
        } else if (device instanceof DeviceCombo2in1) {
            if (z2) {
                switch (WhenMappings.$EnumSwitchMapping$0[deviceAttribute.ordinal()]) {
                    case 1:
                    case 2:
                    case 3:
                    case 9:
                    case 10:
                        return true;
                    case 4:
                        DeviceCombo2in1 deviceCombo2in1 = (DeviceCombo2in1) device;
                        return !deviceCombo2in1.isStandByOn() && deviceCombo2in1.isInMode(Mode.FAN);
                    case 5:
                        DeviceCombo2in1 deviceCombo2in12 = (DeviceCombo2in1) device;
                        return !deviceCombo2in12.isStandByOn() && !deviceCombo2in12.isInMode(Mode.NIGHT);
                    case 6:
                    case 7:
                        return !((DeviceCombo2in1) device).isStandByOn();
                    case 11:
                        return ((DeviceCombo2in1) device).getWickdryOn();
                    case 12:
                        DeviceCombo2in1 deviceCombo2in13 = (DeviceCombo2in1) device;
                        return !deviceCombo2in13.isStandByOn() && deviceCombo2in13.isInMode(Mode.AUTO) && deviceCombo2in13.getHumMode();
                    default:
                        return false;
                }
            } else {
                return SetsKt.setOf(DeviceAttribute.N_OFFLINE, DeviceAttribute.N_FILTER_STATUS, DeviceAttribute.WICK_STATUS).contains(deviceAttribute);
            }
        } else if (device instanceof DeviceCombo3in1) {
            if (z2) {
                int i = WhenMappings.$EnumSwitchMapping$0[deviceAttribute.ordinal()];
                switch (i) {
                    case 1:
                    case 2:
                    case 3:
                        return true;
                    case 4:
                        DeviceCombo3in1 deviceCombo3in1 = (DeviceCombo3in1) device;
                        return !deviceCombo3in1.isStandByOn() && deviceCombo3in1.isInSubMode(ApSubMode.FAN);
                    case 5:
                        DeviceCombo3in1 deviceCombo3in12 = (DeviceCombo3in1) device;
                        if (!deviceCombo3in12.isStandByOn()) {
                            if (!SetsKt.setOf(ApSubMode.NIGHT, ApSubMode.ECO).contains(deviceCombo3in12.currentSubMode())) {
                                return true;
                            }
                        }
                        return false;
                    case 6:
                    case 7:
                        break;
                    default:
                        switch (i) {
                            case 13:
                                DeviceCombo3in1 deviceCombo3in13 = (DeviceCombo3in1) device;
                                if (!deviceCombo3in13.isStandByOn() && deviceCombo3in13.getMainMode() == MainMode.COOL.getValue()) {
                                    if (SetsKt.setOf(ApSubMode.AUTO, ApSubMode.ECO).contains(deviceCombo3in13.currentSubMode())) {
                                        return true;
                                    }
                                }
                                return false;
                            case 14:
                                DeviceCombo3in1 deviceCombo3in14 = (DeviceCombo3in1) device;
                                if (!deviceCombo3in14.isStandByOn() && deviceCombo3in14.getMainMode() == MainMode.HEAT.getValue()) {
                                    if (SetsKt.setOf(ApSubMode.AUTO, ApSubMode.ECO).contains(deviceCombo3in14.currentSubMode())) {
                                        return true;
                                    }
                                }
                                return false;
                            case 15:
                                break;
                            default:
                                return false;
                        }
                }
                return !((DeviceCombo3in1) device).isStandByOn();
            }
            return SetsKt.setOf(DeviceAttribute.N_OFFLINE, DeviceAttribute.N_FILTER_STATUS).contains(deviceAttribute);
        } else if (device instanceof DeviceHumidifier) {
            if (z2) {
                switch (WhenMappings.$EnumSwitchMapping$0[deviceAttribute.ordinal()]) {
                    case 2:
                    case 10:
                        return true;
                    case 4:
                        DeviceHumidifier deviceHumidifier = (DeviceHumidifier) device;
                        return !deviceHumidifier.isStandByOn() && deviceHumidifier.getAutoMode() != AutoMode.ON && !deviceHumidifier.isG4NightModeOn();
                    case 5:
                        DeviceHumidifier deviceHumidifier2 = (DeviceHumidifier) device;
                        return !deviceHumidifier2.isStandByOn() && !deviceHumidifier2.isG4NightModeOn();
                    case 6:
                    case 7:
                        return !((DeviceHumidifier) device).isStandByOn();
                    case 11:
                        DeviceHumidifier deviceHumidifier3 = (DeviceHumidifier) device;
                        return deviceHumidifier3.isStandByOn() || deviceHumidifier3.getWaterShortage() || deviceHumidifier3.getWickdryOn();
                    case 12:
                        DeviceHumidifier deviceHumidifier4 = (DeviceHumidifier) device;
                        return !deviceHumidifier4.isStandByOn() && deviceHumidifier4.getAutoMode() == AutoMode.ON;
                    default:
                        return false;
                }
            } else {
                return SetsKt.setOf(DeviceAttribute.N_OFFLINE, DeviceAttribute.WICK_STATUS).contains(deviceAttribute);
            }
        } else if (device instanceof DeviceNewClassic) {
            if (SetsKt.setOf(DeviceAttribute.N_FILTER_STATUS).contains(deviceAttribute)) {
                return true;
            }
            if (z2) {
                int i2 = WhenMappings.$EnumSwitchMapping$0[deviceAttribute.ordinal()];
                if (!(i2 == 2 || i2 == 3)) {
                    if (i2 == 4) {
                        DeviceNewClassic deviceNewClassic = (DeviceNewClassic) device;
                        return !deviceNewClassic.isStandByOn() && deviceNewClassic.getAutoMode() != AutoMode.ON && !deviceNewClassic.isG4NightModeOn() && !deviceNewClassic.isEcoModeOn();
                    } else if (i2 == 5) {
                        DeviceNewClassic deviceNewClassic2 = (DeviceNewClassic) device;
                        return !deviceNewClassic2.isStandByOn() && !deviceNewClassic2.isG4NightModeOn() && !deviceNewClassic2.isEcoModeOn();
                    } else if (i2 == 7) {
                        return !((DeviceNewClassic) device).isStandByOn();
                    } else {
                        if (i2 != 16) {
                            return false;
                        }
                    }
                }
                return true;
            }
            return SetsKt.setOf(DeviceAttribute.N_OFFLINE, DeviceAttribute.N_FILTER_STATUS).contains(deviceAttribute);
        } else if (z2) {
            switch (WhenMappings.$EnumSwitchMapping$0[deviceAttribute.ordinal()]) {
                case 23:
                    return device instanceof HasBrightness;
                case 24:
                    return (device instanceof HasBlueCloudFunctions) && Device.CC.getTimezone$default(device, (Context) null, 1, (Object) null).useDaylightTime();
                case 25:
                    return !(device instanceof DeviceIcp) && !(device instanceof DeviceAware);
                default:
                    if ((device instanceof DeviceG4) || (device instanceof DeviceB4) || (device instanceof DeviceB4sp) || (device instanceof DeviceBlue) || (device instanceof DeviceBluePremium)) {
                        Device device2 = device;
                        DeviceAttribute deviceAttribute2 = deviceAttribute;
                        return DeviceAttribute.Companion.checkConnectivityStatus$default(DeviceAttribute.Companion, device2, deviceAttribute2, new DeviceAttributeKt$$ExternalSyntheticLambda0(deviceAttribute2, device2), (Function0) null, 8, (Object) null);
                    } else if (device instanceof DeviceClassic) {
                        return DeviceAttribute.Companion.checkConnectivityStatus$default(DeviceAttribute.Companion, device, deviceAttribute, new DeviceAttributeKt$$ExternalSyntheticLambda1(device, deviceAttribute), (Function0) null, 8, (Object) null);
                    } else {
                        Device device3 = device;
                        DeviceAttribute deviceAttribute3 = deviceAttribute;
                        if (device3 instanceof DeviceIcp) {
                            return DeviceAttribute.Companion.checkConnectivityStatus$default(DeviceAttribute.Companion, device3, deviceAttribute3, new DeviceAttributeKt$$ExternalSyntheticLambda2(device3, deviceAttribute3), (Function0) null, 8, (Object) null);
                        } else if (!(device3 instanceof HasLinkingCapability)) {
                            return false;
                        } else {
                            return DeviceAttribute.Companion.checkConnectivityStatus$default(DeviceAttribute.Companion, device3, deviceAttribute3, new DeviceAttributeKt$$ExternalSyntheticLambda3(device3, deviceAttribute3), (Function0) null, 8, (Object) null);
                        }
                    }
            }
        } else {
            Device device4 = device;
            int i3 = WhenMappings.$EnumSwitchMapping$0[deviceAttribute.ordinal()];
            return i3 != 25 ? i3 == 26 : !(device4 instanceof DeviceIcp);
        }
    }

    /* access modifiers changed from: private */
    public static final boolean supportAttribute$lambda$0(DeviceAttribute deviceAttribute, Device device) {
        int i = WhenMappings.$EnumSwitchMapping$0[deviceAttribute.ordinal()];
        if (i == 20) {
            return true;
        }
        if (i == 21) {
            return DeviceKt.isGermShieldPlus(device);
        }
        Intrinsics.checkNotNull(device, "null cannot be cast to non-null type com.blueair.core.model.HasStandBy");
        if (((HasStandBy) device).isStandByOn()) {
            if (deviceAttribute == DeviceAttribute.STANDBY_MODE) {
                return true;
            }
            return false;
        } else if (DeviceKt.isDisinfectionOn(device)) {
            if (deviceAttribute == DeviceAttribute.DISINFECTION_STATUS) {
                return true;
            }
            return false;
        } else if (deviceAttribute == DeviceAttribute.GERMSHIELD_NM) {
            if (!(device instanceof HasGermShieldMode) || !((HasGermShieldMode) device).getHasGermShieldNightMode() || !((HasG4NightMode) device).isG4NightModeOn()) {
                return false;
            }
            return true;
        } else if (((HasFanSpeed) device).getAutoMode() != AutoMode.ON && !((HasG4NightMode) device).isG4NightModeOn()) {
            int i2 = WhenMappings.$EnumSwitchMapping$0[deviceAttribute.ordinal()];
            if (i2 == 18 || i2 == 19) {
                return true;
            }
            return false;
        } else if (deviceAttribute == DeviceAttribute.AUTO_MODE) {
            return true;
        } else {
            return false;
        }
    }

    /* access modifiers changed from: private */
    public static final boolean supportAttribute$lambda$1(Device device, DeviceAttribute deviceAttribute) {
        return DeviceAttribute.Companion.legacyWithSensorsAttributeCheck(((DeviceClassic) device).getAutoMode(), deviceAttribute);
    }

    /* access modifiers changed from: private */
    public static final boolean supportAttribute$lambda$2(Device device, DeviceAttribute deviceAttribute) {
        if (((DeviceIcp) device).getAutoMode() == AutoMode.ON) {
            int i = WhenMappings.$EnumSwitchMapping$0[deviceAttribute.ordinal()];
            return i == 20 || i == 22;
        }
        int i2 = WhenMappings.$EnumSwitchMapping$0[deviceAttribute.ordinal()];
        return i2 == 18 || i2 == 20;
    }

    /* access modifiers changed from: private */
    public static final boolean supportAttribute$lambda$3(Device device, DeviceAttribute deviceAttribute) {
        HasLinkingCapability hasLinkingCapability = (HasLinkingCapability) device;
        if (hasLinkingCapability.isLinked()) {
            return DeviceAttribute.Companion.legacyWithSensorsAttributeCheck(hasLinkingCapability.getAutoMode(), deviceAttribute);
        }
        return WhenMappings.$EnumSwitchMapping$0[deviceAttribute.ordinal()] == 18;
    }
}
