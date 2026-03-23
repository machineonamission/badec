package com.blueair.core.model;

import android.content.Context;
import com.blueair.core.model.Device;
import com.blueair.core.model.HasMainMode;
import java.util.Iterator;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0002\b\u000b\n\u0002\u0010\u0013\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u001fH\u0016J\b\u0010#\u001a\u00020\u0003H\u0016J\b\u0010$\u001a\u00020%H\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0012\u0010\b\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0005R\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0012\u0010\u0010\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0005R\u0012\u0010\u0012\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0005R\u0012\u0010\u0014\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0005R\u0012\u0010\u0016\u001a\u00020\u0017X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0012\u0010\u001a\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0005R\u0012\u0010\u001c\u001a\u00020\u0017X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0019¨\u0006&À\u0006\u0003"}, d2 = {"Lcom/blueair/core/model/HasCombo3in1MainMode;", "Lcom/blueair/core/model/HasMainMode;", "apFanSpeed", "", "getApFanSpeed", "()I", "heatSubMode", "getHeatSubMode", "heatFanSpeed", "getHeatFanSpeed", "heatAutoTmp", "", "getHeatAutoTmp", "()D", "heatEcoTmp", "getHeatEcoTmp", "coolSubMode", "getCoolSubMode", "coolFanSpeed", "getCoolFanSpeed", "coolAutoTag", "getCoolAutoTag", "coolAutoPresets", "", "getCoolAutoPresets", "()[D", "coolEcoTag", "getCoolEcoTag", "coolEcoPresets", "getCoolEcoPresets", "currentSubMode", "Lcom/blueair/core/model/ApSubMode;", "isInSubMode", "", "subMode", "currentFanSpeed", "currentFanSpeedEnum", "Lcom/blueair/core/model/FanSpeedEnum;", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: Device.kt */
public interface HasCombo3in1MainMode extends HasMainMode {

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: Device.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                com.blueair.core.model.MainMode[] r0 = com.blueair.core.model.MainMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.blueair.core.model.MainMode r1 = com.blueair.core.model.MainMode.AirPurify     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.blueair.core.model.MainMode r1 = com.blueair.core.model.MainMode.HEAT     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.blueair.core.model.MainMode r1 = com.blueair.core.model.MainMode.COOL     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.core.model.HasCombo3in1MainMode.WhenMappings.<clinit>():void");
        }
    }

    int currentFanSpeed();

    FanSpeedEnum currentFanSpeedEnum();

    ApSubMode currentSubMode();

    int getApFanSpeed();

    double[] getCoolAutoPresets();

    int getCoolAutoTag();

    double[] getCoolEcoPresets();

    int getCoolEcoTag();

    int getCoolFanSpeed();

    int getCoolSubMode();

    double getHeatAutoTmp();

    double getHeatEcoTmp();

    int getHeatFanSpeed();

    int getHeatSubMode();

    boolean isInSubMode(ApSubMode apSubMode);

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: Device.kt */
    public static final class DefaultImpls {
        @Deprecated
        public static ApSubMode apSubMode(HasCombo3in1MainMode hasCombo3in1MainMode) {
            return HasMainMode.CC.$default$apSubMode(hasCombo3in1MainMode);
        }

        @Deprecated
        public static ConnectivityStatus getConnectivityStatus(HasCombo3in1MainMode hasCombo3in1MainMode) {
            return Device.CC.$default$getConnectivityStatus(hasCombo3in1MainMode);
        }

        @Deprecated
        public static TimeZone getTimezone(HasCombo3in1MainMode hasCombo3in1MainMode, Context context) {
            return Device.CC.$default$getTimezone(hasCombo3in1MainMode, context);
        }

        @Deprecated
        public static DeviceType getType(HasCombo3in1MainMode hasCombo3in1MainMode) {
            return Device.CC.$default$getType(hasCombo3in1MainMode);
        }

        @Deprecated
        public static boolean isInApSubMode(HasCombo3in1MainMode hasCombo3in1MainMode, ApSubMode apSubMode) {
            Intrinsics.checkNotNullParameter(apSubMode, "subMode");
            return HasMainMode.CC.$default$isInApSubMode(hasCombo3in1MainMode, apSubMode);
        }

        @Deprecated
        public static boolean isInMainMode(HasCombo3in1MainMode hasCombo3in1MainMode, MainMode mainMode) {
            Intrinsics.checkNotNullParameter(mainMode, "mainMode");
            return HasMainMode.CC.$default$isInMainMode(hasCombo3in1MainMode, mainMode);
        }

        @Deprecated
        public static boolean isOnline(HasCombo3in1MainMode hasCombo3in1MainMode) {
            return Device.CC.$default$isOnline(hasCombo3in1MainMode);
        }

        @Deprecated
        public static boolean isUsDevice(HasCombo3in1MainMode hasCombo3in1MainMode) {
            return Device.CC.$default$isUsDevice(hasCombo3in1MainMode);
        }

        @Deprecated
        public static MainMode mainMode(HasCombo3in1MainMode hasCombo3in1MainMode) {
            return HasMainMode.CC.$default$mainMode(hasCombo3in1MainMode);
        }

        @Deprecated
        public static ApSubMode currentSubMode(HasCombo3in1MainMode hasCombo3in1MainMode) {
            return CC.$default$currentSubMode(hasCombo3in1MainMode);
        }

        @Deprecated
        public static boolean isInSubMode(HasCombo3in1MainMode hasCombo3in1MainMode, ApSubMode apSubMode) {
            Intrinsics.checkNotNullParameter(apSubMode, "subMode");
            return CC.$default$isInSubMode(hasCombo3in1MainMode, apSubMode);
        }

        @Deprecated
        public static int currentFanSpeed(HasCombo3in1MainMode hasCombo3in1MainMode) {
            return CC.$default$currentFanSpeed(hasCombo3in1MainMode);
        }

        @Deprecated
        public static FanSpeedEnum currentFanSpeedEnum(HasCombo3in1MainMode hasCombo3in1MainMode) {
            return CC.$default$currentFanSpeedEnum(hasCombo3in1MainMode);
        }
    }

    /* renamed from: com.blueair.core.model.HasCombo3in1MainMode$-CC  reason: invalid class name */
    /* compiled from: Device.kt */
    public final /* synthetic */ class CC {
        public static ApSubMode $default$currentSubMode(HasCombo3in1MainMode _this) {
            int i;
            Object obj;
            int i2 = WhenMappings.$EnumSwitchMapping$0[_this.mainMode().ordinal()];
            if (i2 == 1) {
                i = _this.getApSubMode();
            } else if (i2 == 2) {
                i = _this.getHeatSubMode();
            } else if (i2 != 3) {
                i = _this.getApSubMode();
            } else {
                i = _this.getCoolSubMode();
            }
            Iterator it = ApSubMode.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (((ApSubMode) obj).getValue() == i) {
                    break;
                }
            }
            ApSubMode apSubMode = (ApSubMode) obj;
            return apSubMode == null ? ApSubMode.FAN : apSubMode;
        }

        public static boolean $default$isInSubMode(HasCombo3in1MainMode _this, ApSubMode apSubMode) {
            Intrinsics.checkNotNullParameter(apSubMode, "subMode");
            return _this.currentSubMode() == apSubMode;
        }

        public static int $default$currentFanSpeed(HasCombo3in1MainMode _this) {
            int i = WhenMappings.$EnumSwitchMapping$0[_this.mainMode().ordinal()];
            if (i == 1) {
                return _this.getApFanSpeed();
            }
            if (i == 2) {
                return _this.getHeatFanSpeed();
            }
            if (i != 3) {
                return _this.getApFanSpeed();
            }
            return _this.getCoolFanSpeed();
        }

        public static FanSpeedEnum $default$currentFanSpeedEnum(HasCombo3in1MainMode _this) {
            return FanSpeedEnum.Companion.fromServerValue(_this, _this.currentFanSpeed());
        }
    }
}
