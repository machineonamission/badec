package com.blueair.devicedetails.util;

import com.blueair.core.model.AutoMode;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceCombo2in1;
import com.blueair.core.model.DeviceCombo3in1;
import com.blueair.core.model.DeviceHumidifier;
import com.blueair.core.model.DevicePet20;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b'\b\u0002\u0018\u0000 '2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001'B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&¨\u0006("}, d2 = {"Lcom/blueair/devicedetails/util/DeviceAttribute;", "", "<init>", "(Ljava/lang/String;I)V", "SEPARATOR", "GERMSHIELD_STATUS", "STANDBY_MODE", "DISINFECTION_STATUS", "AUTO_MODE", "MANUAL_MODE", "CLEAN_AIR_ETA", "OFFLINE", "MODE_BUTTONS", "GERMSHIELD_NM", "BRIGHTNESS", "FILTER_STATUS", "TIMEZONE", "OTA", "N_HINS", "N_OFFLINE", "N_ON_OFF", "N_MODE_BUTTONS", "DRY_MODE", "AUTO_RH", "TIMER", "WICK_STATUS", "N_CLEAN_AIR_ETA", "N_FAN_SPEED", "N_BRIGHTNESS", "N_FILTER_STATUS", "N_CHILD_LOCK", "FAN_PRESET", "TARGET_TEMPERATURE", "OSCILLATION", "WATER_LEVEL", "HUM_ON_OFF", "WEIGHT", "SUB_AUTO", "DETECT_CAT", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceAttribute.kt */
public enum DeviceAttribute {
    SEPARATOR,
    GERMSHIELD_STATUS,
    STANDBY_MODE,
    DISINFECTION_STATUS,
    AUTO_MODE,
    MANUAL_MODE,
    CLEAN_AIR_ETA,
    OFFLINE,
    MODE_BUTTONS,
    GERMSHIELD_NM,
    BRIGHTNESS,
    FILTER_STATUS,
    TIMEZONE,
    OTA,
    N_HINS,
    N_OFFLINE,
    N_ON_OFF,
    N_MODE_BUTTONS,
    DRY_MODE,
    AUTO_RH,
    TIMER,
    WICK_STATUS,
    N_CLEAN_AIR_ETA,
    N_FAN_SPEED,
    N_BRIGHTNESS,
    N_FILTER_STATUS,
    N_CHILD_LOCK,
    FAN_PRESET,
    TARGET_TEMPERATURE,
    OSCILLATION,
    WATER_LEVEL,
    HUM_ON_OFF,
    WEIGHT,
    SUB_AUTO,
    DETECT_CAT;
    
    /* access modifiers changed from: private */
    public static final DeviceAttribute[] ATTRIBUTES = null;
    public static final Companion Companion = null;
    /* access modifiers changed from: private */
    public static boolean showDetectCat;

    public static EnumEntries<DeviceAttribute> getEntries() {
        return $ENTRIES;
    }

    static {
        DeviceAttribute[] $values;
        $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
        Companion = new Companion((DefaultConstructorMarker) null);
        ATTRIBUTES = values();
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0005J\u0016\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\fJ\u0010\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\fH\u0002J\u0010\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\fH\u0002J6\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\f2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\u001d2\u0010\b\u0002\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001dR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0019\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000e¨\u0006\u001f"}, d2 = {"Lcom/blueair/devicedetails/util/DeviceAttribute$Companion;", "", "<init>", "()V", "showDetectCat", "", "getShowDetectCat", "()Z", "setShowDetectCat", "(Z)V", "ATTRIBUTES", "", "Lcom/blueair/devicedetails/util/DeviceAttribute;", "getATTRIBUTES", "()[Lcom/blueair/devicedetails/util/DeviceAttribute;", "[Lcom/blueair/devicedetails/util/DeviceAttribute;", "getSupportedAttributes", "", "device", "Lcom/blueair/core/model/Device;", "forceOffline", "legacyWithSensorsAttributeCheck", "autoMode", "Lcom/blueair/core/model/AutoMode;", "attribute", "offlineAttributeCheck", "otaAttributeCheck", "checkConnectivityStatus", "setOnline", "Lkotlin/Function0;", "setOta", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceAttribute.kt */
    public static final class Companion {

        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        /* compiled from: DeviceAttribute.kt */
        public static final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;
            public static final /* synthetic */ int[] $EnumSwitchMapping$1 = null;

            /* JADX WARNING: Can't wrap try/catch for region: R(17:0|(2:1|2)|3|5|6|7|8|9|10|(2:11|12)|13|15|16|17|18|19|21) */
            /* JADX WARNING: Can't wrap try/catch for region: R(18:0|(2:1|2)|3|5|6|7|8|9|10|11|12|13|15|16|17|18|19|21) */
            /* JADX WARNING: Failed to process nested try/catch */
            /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002b */
            /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0045 */
            /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0019 */
            /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0022 */
            static {
                /*
                    com.blueair.devicedetails.util.DeviceAttribute[] r0 = com.blueair.devicedetails.util.DeviceAttribute.values()
                    int r0 = r0.length
                    int[] r0 = new int[r0]
                    r1 = 1
                    com.blueair.devicedetails.util.DeviceAttribute r2 = com.blueair.devicedetails.util.DeviceAttribute.AUTO_MODE     // Catch:{ NoSuchFieldError -> 0x0010 }
                    int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                    r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0010 }
                L_0x0010:
                    r2 = 2
                    com.blueair.devicedetails.util.DeviceAttribute r3 = com.blueair.devicedetails.util.DeviceAttribute.MODE_BUTTONS     // Catch:{ NoSuchFieldError -> 0x0019 }
                    int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                    r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
                L_0x0019:
                    com.blueair.devicedetails.util.DeviceAttribute r3 = com.blueair.devicedetails.util.DeviceAttribute.MANUAL_MODE     // Catch:{ NoSuchFieldError -> 0x0022 }
                    int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                    r4 = 3
                    r0[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0022 }
                L_0x0022:
                    com.blueair.devicedetails.util.DeviceAttribute r3 = com.blueair.devicedetails.util.DeviceAttribute.OFFLINE     // Catch:{ NoSuchFieldError -> 0x002b }
                    int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                    r4 = 4
                    r0[r3] = r4     // Catch:{ NoSuchFieldError -> 0x002b }
                L_0x002b:
                    com.blueair.devicedetails.util.DeviceAttribute r3 = com.blueair.devicedetails.util.DeviceAttribute.OTA     // Catch:{ NoSuchFieldError -> 0x0034 }
                    int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                    r4 = 5
                    r0[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0034 }
                L_0x0034:
                    $EnumSwitchMapping$0 = r0
                    com.blueair.core.model.ConnectivityStatus[] r0 = com.blueair.core.model.ConnectivityStatus.values()
                    int r0 = r0.length
                    int[] r0 = new int[r0]
                    com.blueair.core.model.ConnectivityStatus r3 = com.blueair.core.model.ConnectivityStatus.ONLINE     // Catch:{ NoSuchFieldError -> 0x0045 }
                    int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0045 }
                    r0[r3] = r1     // Catch:{ NoSuchFieldError -> 0x0045 }
                L_0x0045:
                    com.blueair.core.model.ConnectivityStatus r1 = com.blueair.core.model.ConnectivityStatus.UPDATING     // Catch:{ NoSuchFieldError -> 0x004d }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004d }
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004d }
                L_0x004d:
                    $EnumSwitchMapping$1 = r0
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.util.DeviceAttribute.Companion.WhenMappings.<clinit>():void");
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean getShowDetectCat() {
            return DeviceAttribute.showDetectCat;
        }

        public final void setShowDetectCat(boolean z) {
            DeviceAttribute.showDetectCat = z;
        }

        public final DeviceAttribute[] getATTRIBUTES() {
            return DeviceAttribute.ATTRIBUTES;
        }

        public static /* synthetic */ List getSupportedAttributes$default(Companion companion, Device device, boolean z, int i, Object obj) {
            if ((i & 2) != 0) {
                z = false;
            }
            return companion.getSupportedAttributes(device, z);
        }

        public final List<DeviceAttribute> getSupportedAttributes(Device device, boolean z) {
            boolean z2;
            DeviceAttribute[] attributes = getATTRIBUTES();
            Collection arrayList = new ArrayList();
            for (DeviceAttribute deviceAttribute : attributes) {
                if (device != null) {
                    z2 = DeviceAttributeKt.supportAttribute(device, deviceAttribute, z);
                } else {
                    z2 = false;
                }
                if (z2) {
                    arrayList.add(deviceAttribute);
                }
            }
            List<DeviceAttribute> list = (List) arrayList;
            if (device instanceof DevicePet20) {
                DeviceAttribute[] deviceAttributeArr = {DeviceAttribute.N_OFFLINE, DeviceAttribute.N_ON_OFF, DeviceAttribute.N_MODE_BUTTONS, DeviceAttribute.N_FAN_SPEED, DeviceAttribute.TIMER, DeviceAttribute.DETECT_CAT, DeviceAttribute.N_BRIGHTNESS, DeviceAttribute.N_CHILD_LOCK, DeviceAttribute.N_FILTER_STATUS};
                Collection arrayList2 = new ArrayList();
                for (Object next : CollectionsKt.listOf(deviceAttributeArr)) {
                    if (list.contains((DeviceAttribute) next)) {
                        arrayList2.add(next);
                    }
                }
                return (List) arrayList2;
            } else if (device instanceof DeviceCombo2in1) {
                DeviceAttribute[] deviceAttributeArr2 = {DeviceAttribute.N_OFFLINE, DeviceAttribute.N_ON_OFF, DeviceAttribute.HUM_ON_OFF, DeviceAttribute.N_MODE_BUTTONS, DeviceAttribute.DRY_MODE, DeviceAttribute.N_FAN_SPEED, DeviceAttribute.AUTO_RH, DeviceAttribute.TIMER, DeviceAttribute.WATER_LEVEL, DeviceAttribute.N_BRIGHTNESS, DeviceAttribute.N_CHILD_LOCK, DeviceAttribute.N_FILTER_STATUS, DeviceAttribute.WICK_STATUS};
                Collection arrayList3 = new ArrayList();
                for (Object next2 : CollectionsKt.listOf(deviceAttributeArr2)) {
                    if (list.contains((DeviceAttribute) next2)) {
                        arrayList3.add(next2);
                    }
                }
                return (List) arrayList3;
            } else if (device instanceof DeviceCombo3in1) {
                DeviceAttribute[] deviceAttributeArr3 = {DeviceAttribute.N_OFFLINE, DeviceAttribute.N_ON_OFF, DeviceAttribute.N_MODE_BUTTONS, DeviceAttribute.N_FAN_SPEED, DeviceAttribute.FAN_PRESET, DeviceAttribute.TARGET_TEMPERATURE, DeviceAttribute.OSCILLATION, DeviceAttribute.TIMER, DeviceAttribute.N_BRIGHTNESS, DeviceAttribute.N_CHILD_LOCK, DeviceAttribute.N_FILTER_STATUS};
                Collection arrayList4 = new ArrayList();
                for (Object next3 : CollectionsKt.listOf(deviceAttributeArr3)) {
                    if (list.contains((DeviceAttribute) next3)) {
                        arrayList4.add(next3);
                    }
                }
                return (List) arrayList4;
            } else if (!(device instanceof DeviceHumidifier)) {
                return list;
            } else {
                DeviceAttribute[] deviceAttributeArr4 = {DeviceAttribute.N_OFFLINE, DeviceAttribute.N_MODE_BUTTONS, DeviceAttribute.DRY_MODE, DeviceAttribute.N_FAN_SPEED, DeviceAttribute.AUTO_RH, DeviceAttribute.TIMER, DeviceAttribute.N_BRIGHTNESS, DeviceAttribute.N_CHILD_LOCK, DeviceAttribute.WICK_STATUS};
                Collection arrayList5 = new ArrayList();
                for (Object next4 : CollectionsKt.listOf(deviceAttributeArr4)) {
                    if (list.contains((DeviceAttribute) next4)) {
                        arrayList5.add(next4);
                    }
                }
                return (List) arrayList5;
            }
        }

        public final boolean legacyWithSensorsAttributeCheck(AutoMode autoMode, DeviceAttribute deviceAttribute) {
            Intrinsics.checkNotNullParameter(autoMode, "autoMode");
            Intrinsics.checkNotNullParameter(deviceAttribute, "attribute");
            if (autoMode == AutoMode.ON) {
                int i = WhenMappings.$EnumSwitchMapping$0[deviceAttribute.ordinal()];
                return i == 1 || i == 2;
            }
            int i2 = WhenMappings.$EnumSwitchMapping$0[deviceAttribute.ordinal()];
            return i2 == 2 || i2 == 3;
        }

        private final boolean offlineAttributeCheck(DeviceAttribute deviceAttribute) {
            return WhenMappings.$EnumSwitchMapping$0[deviceAttribute.ordinal()] == 4;
        }

        private final boolean otaAttributeCheck(DeviceAttribute deviceAttribute) {
            return WhenMappings.$EnumSwitchMapping$0[deviceAttribute.ordinal()] == 5;
        }

        public static /* synthetic */ boolean checkConnectivityStatus$default(Companion companion, Device device, DeviceAttribute deviceAttribute, Function0 function0, Function0 function02, int i, Object obj) {
            if ((i & 8) != 0) {
                function02 = null;
            }
            return companion.checkConnectivityStatus(device, deviceAttribute, function0, function02);
        }

        public final boolean checkConnectivityStatus(Device device, DeviceAttribute deviceAttribute, Function0<Boolean> function0, Function0<Boolean> function02) {
            Intrinsics.checkNotNullParameter(device, "device");
            Intrinsics.checkNotNullParameter(deviceAttribute, "attribute");
            Intrinsics.checkNotNullParameter(function0, "setOnline");
            int i = WhenMappings.$EnumSwitchMapping$1[device.getConnectivityStatus().ordinal()];
            if (i == 1) {
                return function0.invoke().booleanValue();
            }
            if (i != 2) {
                return offlineAttributeCheck(deviceAttribute);
            }
            return function02 != null ? function02.invoke().booleanValue() : otaAttributeCheck(deviceAttribute);
        }
    }
}
