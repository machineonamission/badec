package com.blueair.adddevice;

import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.Retention;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b*\n\u0002\u0010\u000b\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001:\u00039:;B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010)\u001a\u00020\u00072\b\u0010*\u001a\u0004\u0018\u00010\u0005H\u0007J\u0010\u0010+\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u0007H\u0007J\u0010\u0010-\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u0007H\u0007J\u0010\u0010/\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u0007H\u0007J\u0010\u00101\u001a\u0002022\u0006\u0010.\u001a\u00020\u0007H\u0007J\u0010\u00103\u001a\u0002022\u0006\u0010.\u001a\u00020\u0007H\u0007J\u0010\u00104\u001a\u0002022\u0006\u0010.\u001a\u00020\u0007H\u0007J\u000e\u00105\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u0007J\u0010\u00106\u001a\u0002022\u0006\u0010.\u001a\u00020\u0007H\u0007J\u000e\u00107\u001a\u0002022\u0006\u00108\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lcom/blueair/adddevice/DeviceUtilsLegacy;", "", "<init>", "()V", "UNKNOWN", "", "DEVICE_COMPATIBILITY_UNKNOWN", "", "DEVICE_COMPATIBILITY_AWARE", "DEVICE_COMPATIBILITY_SENSE", "DEVICE_COMPATIBILITY_CLASSIC", "DEVICE_COMPATIBILITY_CLASSIC_205", "DEVICE_COMPATIBILITY_CLASSIC_205S", "DEVICE_COMPATIBILITY_CLASSIC_305", "DEVICE_COMPATIBILITY_CLASSIC_405", "DEVICE_COMPATIBILITY_CLASSIC_405S", "DEVICE_COMPATIBILITY_CLASSIC_505", "DEVICE_COMPATIBILITY_CLASSIC_605", "DEVICE_COMPATIBILITY_CLASSIC_605S", "DEVICE_COMPATIBILITY_CLASSIC_260", "DEVICE_COMPATIBILITY_CLASSIC_260i", "DEVICE_COMPATIBILITY_CLASSIC_280i", "DEVICE_COMPATIBILITY_CLASSIC_290i", "DEVICE_COMPATIBILITY_CLASSIC_460", "DEVICE_COMPATIBILITY_CLASSIC_460i", "DEVICE_COMPATIBILITY_CLASSIC_480i", "DEVICE_COMPATIBILITY_CLASSIC_490i", "DEVICE_COMPATIBILITY_CLASSIC_560", "DEVICE_COMPATIBILITY_CLASSIC_580i", "DEVICE_COMPATIBILITY_CLASSIC_660", "DEVICE_COMPATIBILITY_CLASSIC_680i", "DEVICE_COMPATIBILITY_CLASSIC_690i", "DEVICE_COMPATIBILITY_CLASSIC_380i", "DEVICE_COMPATIBILITY_ICP", "DEVICE_COMPATIBILITY_STRING_ICP", "AWARE_CONFIG_SSID", "SENSE_CONFIG_SSID", "CLASSIC_CONFIG_SSID", "EMUALTOR_SSID", "DEVICE_CONFIG_MODE_AUTO", "DEVICE_CONFIG_MODE_MANUAL", "getDeviceCompatibilityFromModel", "model", "castDeviceCompatibility", "code", "getDeviceModelNameForDisplay", "deviceCompatibilityType", "getDeviceCompatibilityForBackend", "deviceCompatilityType", "isClassicWithoutSensorBoard", "", "isClassicWithSensorBoard", "isClassic", "getManualModeWiFiSSID", "isUnknown", "isManualDeviceNetwork", "ssid", "CompatibilityType", "ConfigurationMode", "AddDeviceBackendException", "adddevice_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceUtilsLegacy.kt */
public final class DeviceUtilsLegacy {
    public static final String AWARE_CONFIG_SSID = "aware-config";
    public static final String CLASSIC_CONFIG_SSID = "classic-config";
    public static final int DEVICE_COMPATIBILITY_AWARE = 1;
    public static final int DEVICE_COMPATIBILITY_CLASSIC = 3;
    public static final int DEVICE_COMPATIBILITY_CLASSIC_205 = 4;
    public static final int DEVICE_COMPATIBILITY_CLASSIC_205S = 5;
    public static final int DEVICE_COMPATIBILITY_CLASSIC_260 = 12;
    public static final int DEVICE_COMPATIBILITY_CLASSIC_260i = 13;
    public static final int DEVICE_COMPATIBILITY_CLASSIC_280i = 14;
    public static final int DEVICE_COMPATIBILITY_CLASSIC_290i = 15;
    public static final int DEVICE_COMPATIBILITY_CLASSIC_305 = 6;
    public static final int DEVICE_COMPATIBILITY_CLASSIC_380i = 25;
    public static final int DEVICE_COMPATIBILITY_CLASSIC_405 = 7;
    public static final int DEVICE_COMPATIBILITY_CLASSIC_405S = 8;
    public static final int DEVICE_COMPATIBILITY_CLASSIC_460 = 16;
    public static final int DEVICE_COMPATIBILITY_CLASSIC_460i = 17;
    public static final int DEVICE_COMPATIBILITY_CLASSIC_480i = 18;
    public static final int DEVICE_COMPATIBILITY_CLASSIC_490i = 19;
    public static final int DEVICE_COMPATIBILITY_CLASSIC_505 = 9;
    public static final int DEVICE_COMPATIBILITY_CLASSIC_560 = 20;
    public static final int DEVICE_COMPATIBILITY_CLASSIC_580i = 21;
    public static final int DEVICE_COMPATIBILITY_CLASSIC_605 = 10;
    public static final int DEVICE_COMPATIBILITY_CLASSIC_605S = 11;
    public static final int DEVICE_COMPATIBILITY_CLASSIC_660 = 22;
    public static final int DEVICE_COMPATIBILITY_CLASSIC_680i = 23;
    public static final int DEVICE_COMPATIBILITY_CLASSIC_690i = 24;
    public static final int DEVICE_COMPATIBILITY_ICP = 40;
    public static final int DEVICE_COMPATIBILITY_SENSE = 2;
    public static final String DEVICE_COMPATIBILITY_STRING_ICP = "icp_p2i";
    public static final int DEVICE_COMPATIBILITY_UNKNOWN = 0;
    public static final int DEVICE_CONFIG_MODE_AUTO = 0;
    public static final int DEVICE_CONFIG_MODE_MANUAL = 1;
    public static final String EMUALTOR_SSID = "WiredSSID";
    public static final DeviceUtilsLegacy INSTANCE = new DeviceUtilsLegacy();
    public static final String SENSE_CONFIG_SSID = "sense-config";
    public static final String UNKNOWN = "Unknown";

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/blueair/adddevice/DeviceUtilsLegacy$CompatibilityType;", "", "adddevice_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @Retention(AnnotationRetention.SOURCE)
    @java.lang.annotation.Retention(RetentionPolicy.SOURCE)
    /* compiled from: DeviceUtilsLegacy.kt */
    public @interface CompatibilityType {
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/blueair/adddevice/DeviceUtilsLegacy$ConfigurationMode;", "", "adddevice_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @Retention(AnnotationRetention.SOURCE)
    @java.lang.annotation.Retention(RetentionPolicy.SOURCE)
    /* compiled from: DeviceUtilsLegacy.kt */
    public @interface ConfigurationMode {
    }

    @JvmStatic
    public static final int castDeviceCompatibility(int i) {
        if (i == 40) {
            return 40;
        }
        switch (i) {
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 4;
            case 5:
                return 5;
            case 6:
                return 6;
            case 7:
                return 7;
            case 8:
                return 8;
            case 9:
                return 9;
            case 10:
                return 10;
            case 11:
                return 11;
            case 12:
                return 12;
            case 13:
                return 13;
            case 14:
                return 14;
            case 15:
                return 15;
            case 16:
                return 16;
            case 17:
                return 17;
            case 18:
                return 18;
            case 19:
                return 19;
            case 20:
                return 20;
            case 21:
                return 21;
            case 22:
                return 22;
            case 23:
                return 23;
            case 24:
                return 24;
            case 25:
                return 25;
            default:
                return 0;
        }
    }

    @JvmStatic
    public static final boolean isClassicWithSensorBoard(int i) {
        return i == 13 || i == 14 || i == 15 || i == 17 || i == 18 || i == 19 || i == 21 || i == 23 || i == 24 || i == 5 || i == 8 || i == 11 || i == 25;
    }

    @JvmStatic
    public static final boolean isClassicWithoutSensorBoard(int i) {
        return i == 3 || i == 4 || i == 6 || i == 7 || i == 9 || i == 10 || i == 12 || i == 16 || i == 20 || i == 22;
    }

    @JvmStatic
    public static final boolean isUnknown(int i) {
        return i == 0;
    }

    private DeviceUtilsLegacy() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:83:0x014f A[RETURN] */
    @kotlin.jvm.JvmStatic
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final int getDeviceCompatibilityFromModel(java.lang.String r2) {
        /*
            r0 = 0
            if (r2 != 0) goto L_0x0004
            return r0
        L_0x0004:
            int r1 = r2.hashCode()
            switch(r1) {
                case -905948611: goto L_0x0144;
                case -138768246: goto L_0x0139;
                case -138768065: goto L_0x012d;
                case -138767285: goto L_0x0122;
                case -138766324: goto L_0x0117;
                case -138766143: goto L_0x010b;
                case -138765363: goto L_0x00ff;
                case -138765182: goto L_0x00f3;
                case -138764402: goto L_0x00e7;
                case -138764221: goto L_0x00da;
                case -6848247: goto L_0x00ce;
                case -6842614: goto L_0x00c1;
                case -6840692: goto L_0x00b4;
                case -6839731: goto L_0x00a7;
                case -6810901: goto L_0x009a;
                case -6788665: goto L_0x008d;
                case -6783032: goto L_0x0080;
                case -6781110: goto L_0x0073;
                case -6780149: goto L_0x0066;
                case -6751319: goto L_0x0059;
                case -6729083: goto L_0x004c;
                case -6721528: goto L_0x003f;
                case -6720567: goto L_0x0032;
                case 93223518: goto L_0x0026;
                case 853620882: goto L_0x001a;
                case 1639265726: goto L_0x000d;
                default: goto L_0x000b;
            }
        L_0x000b:
            goto L_0x014f
        L_0x000d:
            java.lang.String r1 = "icp_p2i"
            boolean r2 = r2.equals(r1)
            if (r2 != 0) goto L_0x0017
            goto L_0x014f
        L_0x0017:
            r2 = 40
            return r2
        L_0x001a:
            java.lang.String r1 = "classic"
            boolean r2 = r2.equals(r1)
            if (r2 != 0) goto L_0x0024
            goto L_0x014f
        L_0x0024:
            r2 = 3
            return r2
        L_0x0026:
            java.lang.String r1 = "aware"
            boolean r2 = r2.equals(r1)
            if (r2 != 0) goto L_0x0030
            goto L_0x014f
        L_0x0030:
            r2 = 1
            return r2
        L_0x0032:
            java.lang.String r1 = "classic_690i"
            boolean r2 = r2.equals(r1)
            if (r2 != 0) goto L_0x003c
            goto L_0x014f
        L_0x003c:
            r2 = 24
            return r2
        L_0x003f:
            java.lang.String r1 = "classic_680i"
            boolean r2 = r2.equals(r1)
            if (r2 != 0) goto L_0x0049
            goto L_0x014f
        L_0x0049:
            r2 = 23
            return r2
        L_0x004c:
            java.lang.String r1 = "classic_605S"
            boolean r2 = r2.equals(r1)
            if (r2 != 0) goto L_0x0056
            goto L_0x014f
        L_0x0056:
            r2 = 11
            return r2
        L_0x0059:
            java.lang.String r1 = "classic_580i"
            boolean r2 = r2.equals(r1)
            if (r2 != 0) goto L_0x0063
            goto L_0x014f
        L_0x0063:
            r2 = 21
            return r2
        L_0x0066:
            java.lang.String r1 = "classic_490i"
            boolean r2 = r2.equals(r1)
            if (r2 != 0) goto L_0x0070
            goto L_0x014f
        L_0x0070:
            r2 = 19
            return r2
        L_0x0073:
            java.lang.String r1 = "classic_480i"
            boolean r2 = r2.equals(r1)
            if (r2 != 0) goto L_0x007d
            goto L_0x014f
        L_0x007d:
            r2 = 18
            return r2
        L_0x0080:
            java.lang.String r1 = "classic_460i"
            boolean r2 = r2.equals(r1)
            if (r2 != 0) goto L_0x008a
            goto L_0x014f
        L_0x008a:
            r2 = 17
            return r2
        L_0x008d:
            java.lang.String r1 = "classic_405S"
            boolean r2 = r2.equals(r1)
            if (r2 != 0) goto L_0x0097
            goto L_0x014f
        L_0x0097:
            r2 = 8
            return r2
        L_0x009a:
            java.lang.String r1 = "classic_380i"
            boolean r2 = r2.equals(r1)
            if (r2 != 0) goto L_0x00a4
            goto L_0x014f
        L_0x00a4:
            r2 = 25
            return r2
        L_0x00a7:
            java.lang.String r1 = "classic_290i"
            boolean r2 = r2.equals(r1)
            if (r2 != 0) goto L_0x00b1
            goto L_0x014f
        L_0x00b1:
            r2 = 15
            return r2
        L_0x00b4:
            java.lang.String r1 = "classic_280i"
            boolean r2 = r2.equals(r1)
            if (r2 != 0) goto L_0x00be
            goto L_0x014f
        L_0x00be:
            r2 = 14
            return r2
        L_0x00c1:
            java.lang.String r1 = "classic_260i"
            boolean r2 = r2.equals(r1)
            if (r2 != 0) goto L_0x00cb
            goto L_0x014f
        L_0x00cb:
            r2 = 13
            return r2
        L_0x00ce:
            java.lang.String r1 = "classic_205S"
            boolean r2 = r2.equals(r1)
            if (r2 != 0) goto L_0x00d8
            goto L_0x014f
        L_0x00d8:
            r2 = 5
            return r2
        L_0x00da:
            java.lang.String r1 = "classic_660"
            boolean r2 = r2.equals(r1)
            if (r2 != 0) goto L_0x00e4
            goto L_0x014f
        L_0x00e4:
            r2 = 22
            return r2
        L_0x00e7:
            java.lang.String r1 = "classic_605"
            boolean r2 = r2.equals(r1)
            if (r2 != 0) goto L_0x00f0
            goto L_0x014f
        L_0x00f0:
            r2 = 10
            return r2
        L_0x00f3:
            java.lang.String r1 = "classic_560"
            boolean r2 = r2.equals(r1)
            if (r2 != 0) goto L_0x00fc
            goto L_0x014f
        L_0x00fc:
            r2 = 20
            return r2
        L_0x00ff:
            java.lang.String r1 = "classic_505"
            boolean r2 = r2.equals(r1)
            if (r2 != 0) goto L_0x0108
            goto L_0x014f
        L_0x0108:
            r2 = 9
            return r2
        L_0x010b:
            java.lang.String r1 = "classic_460"
            boolean r2 = r2.equals(r1)
            if (r2 != 0) goto L_0x0114
            goto L_0x014f
        L_0x0114:
            r2 = 16
            return r2
        L_0x0117:
            java.lang.String r1 = "classic_405"
            boolean r2 = r2.equals(r1)
            if (r2 != 0) goto L_0x0120
            goto L_0x014f
        L_0x0120:
            r2 = 7
            return r2
        L_0x0122:
            java.lang.String r1 = "classic_305"
            boolean r2 = r2.equals(r1)
            if (r2 != 0) goto L_0x012b
            goto L_0x014f
        L_0x012b:
            r2 = 6
            return r2
        L_0x012d:
            java.lang.String r1 = "classic_260"
            boolean r2 = r2.equals(r1)
            if (r2 != 0) goto L_0x0136
            goto L_0x014f
        L_0x0136:
            r2 = 12
            return r2
        L_0x0139:
            java.lang.String r1 = "classic_205"
            boolean r2 = r2.equals(r1)
            if (r2 != 0) goto L_0x0142
            goto L_0x014f
        L_0x0142:
            r2 = 4
            return r2
        L_0x0144:
            java.lang.String r1 = "sense+"
            boolean r2 = r2.equals(r1)
            if (r2 != 0) goto L_0x014d
            goto L_0x014f
        L_0x014d:
            r2 = 2
            return r2
        L_0x014f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.adddevice.DeviceUtilsLegacy.getDeviceCompatibilityFromModel(java.lang.String):int");
    }

    @JvmStatic
    public static final String getDeviceModelNameForDisplay(int i) {
        switch (i) {
            case 1:
                return "Aware";
            case 2:
                return "Sense+";
            case 3:
                return "Classic";
            case 4:
                return "Classic 205";
            case 5:
                return "Classic 205S";
            case 6:
                return "Classic 305";
            case 7:
                return "Classic 405";
            case 8:
                return "Classic 405S";
            case 9:
                return "Classic 505";
            case 10:
                return "Classic 605";
            case 11:
                return "Classic 605S";
            case 12:
                return "Classic 260";
            case 13:
                return "Classic 260i";
            case 14:
                return "Classic 280i";
            case 15:
                return "Classic 290i";
            case 16:
                return "Classic 460";
            case 17:
                return "Classic 460i";
            case 18:
                return "Classic 480i";
            case 19:
                return "Classic 490i";
            case 20:
                return "Classic 560";
            case 21:
                return "Classic 580i";
            case 22:
                return "Classic 660";
            case 23:
                return "Classic 680i";
            case 24:
                return "Classic 690i";
            case 25:
                return "Classic 380i";
            default:
                return "Unknown";
        }
    }

    @JvmStatic
    public static final String getDeviceCompatibilityForBackend(int i) {
        if (i == 40) {
            return DEVICE_COMPATIBILITY_STRING_ICP;
        }
        switch (i) {
            case 1:
                return "aware";
            case 2:
                return "sense+";
            case 3:
                return "classic";
            case 4:
                return "classic_205";
            case 5:
                return "classic_205S";
            case 6:
                return "classic_305";
            case 7:
                return "classic_405";
            case 8:
                return "classic_405S";
            case 9:
                return "classic_505";
            case 10:
                return "classic_605";
            case 11:
                return "classic_605S";
            case 12:
                return "classic_260";
            case 13:
                return "classic_260i";
            case 14:
                return "classic_280i";
            case 15:
                return "classic_290i";
            case 16:
                return "classic_460";
            case 17:
                return "classic_460i";
            case 18:
                return "classic_480i";
            case 19:
                return "classic_490i";
            case 20:
                return "classic_560";
            case 21:
                return "classic_580i";
            case 22:
                return "classic_660";
            case 23:
                return "classic_680i";
            case 24:
                return "classic_690i";
            case 25:
                return "classic_380i";
            default:
                return "unknown";
        }
    }

    @JvmStatic
    public static final boolean isClassic(int i) {
        return isClassicWithoutSensorBoard(i) || isClassicWithSensorBoard(i);
    }

    public final String getManualModeWiFiSSID(int i) {
        if (i == 1) {
            return AWARE_CONFIG_SSID;
        }
        if (i == 2) {
            return SENSE_CONFIG_SSID;
        }
        if (isClassic(i)) {
            return CLASSIC_CONFIG_SSID;
        }
        return "";
    }

    public final boolean isManualDeviceNetwork(String str) {
        Intrinsics.checkNotNullParameter(str, "ssid");
        return Intrinsics.areEqual((Object) str, (Object) AWARE_CONFIG_SSID) || Intrinsics.areEqual((Object) str, (Object) SENSE_CONFIG_SSID) || Intrinsics.areEqual((Object) str, (Object) CLASSIC_CONFIG_SSID);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/blueair/adddevice/DeviceUtilsLegacy$AddDeviceBackendException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "uiMessage", "", "<init>", "(Ljava/lang/String;)V", "getUiMessage", "()Ljava/lang/String;", "adddevice_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceUtilsLegacy.kt */
    public static final class AddDeviceBackendException extends RuntimeException {
        private final String uiMessage;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public AddDeviceBackendException(String str) {
            super(str);
            Intrinsics.checkNotNullParameter(str, "uiMessage");
            this.uiMessage = str;
        }

        public final String getUiMessage() {
            return this.uiMessage;
        }
    }
}
