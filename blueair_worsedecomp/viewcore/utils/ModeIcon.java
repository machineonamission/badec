package com.blueair.viewcore.utils;

import com.blueair.core.model.ApSubMode;
import com.blueair.core.model.DehSubMode;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.HumSubMode;
import com.blueair.core.model.MainMode;
import com.blueair.core.model.Mode;
import com.blueair.viewcore.R;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001Ba\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010+\u001a\u0004\u0018\u00010,J\b\u0010-\u001a\u0004\u0018\u00010.J\b\u0010/\u001a\u0004\u0018\u000100J\b\u00101\u001a\u0004\u0018\u000102J\b\u00103\u001a\u0004\u0018\u000104J\u0010\u00105\u001a\u00020\u00002\b\u00106\u001a\u0004\u0018\u000107R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*¨\u00068"}, d2 = {"Lcom/blueair/viewcore/utils/ModeIcon;", "", "text", "", "onIcon", "onIconDisabled", "offIcon", "offIconDisabled", "flatIcon", "textShort", "onIconV2", "offIconV2", "disabledIconV2", "<init>", "(Ljava/lang/String;IIIIIIIIIII)V", "getText", "()I", "getOnIcon", "getOnIconDisabled", "getOffIcon", "getOffIconDisabled", "getFlatIcon", "getTextShort", "getOnIconV2", "getOffIconV2", "getDisabledIconV2", "AIR_PURIFY", "HEAT", "COOL", "HUM", "SMART", "PREVIOUS", "STANDBY", "FAN_SPEED", "AUTO", "WATERDROP_AUTO", "NIGHT", "ECO", "SKIN", "CHILD_LOCK", "DISINFECTION", "DRYING", "CONTINUOUS", "toMainMode", "Lcom/blueair/core/model/MainMode;", "toApSubMode", "Lcom/blueair/core/model/ApSubMode;", "toDehSubMode", "Lcom/blueair/core/model/DehSubMode;", "toHumSubMode", "Lcom/blueair/core/model/HumSubMode;", "toMode", "Lcom/blueair/core/model/Mode;", "proofread", "device", "Lcom/blueair/core/model/Device;", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: ModeIcon.kt */
public enum ModeIcon {
    AIR_PURIFY(R.string.main_mode_ap, R.drawable.mode_icon_purify_on, R.drawable.mode_icon_purify_on_disabled, R.drawable.mode_icon_purify_off, R.drawable.mode_icon_purify_off_disabled, R.drawable.mode_icon_purify_flat, R.string.main_mode_ap_short, 0, 0, 0, 896, (int) null),
    HEAT(R.string.main_mode_heat, R.drawable.mode_icon_heat_on, R.drawable.mode_icon_heat_on_disabled, R.drawable.mode_icon_heat_off, R.drawable.mode_icon_heat_off_disabled, R.drawable.mode_icon_heat_flat, R.string.main_mode_heat_short, 0, 0, 0, 896, (int) null),
    COOL(R.string.main_mode_cool, R.drawable.mode_icon_cool_on, R.drawable.mode_icon_cool_on_disabled, R.drawable.mode_icon_cool_off, R.drawable.mode_icon_cool_off_disabled, R.drawable.mode_icon_cool_flat, R.string.main_mode_cool_short, 0, 0, 0, 896, (int) null),
    HUM(R.string.purification_and_humidification, R.drawable.mode_icon_hum_on, R.drawable.mode_icon_hum_on_disabled, R.drawable.mode_icon_hum_off, R.drawable.mode_icon_hum_off_disabled, R.drawable.mode_icon_hum_flat, 0, 0, 0, 0, 960, (int) null),
    SMART(R.string.main_mode_smart, R.drawable.mode_icon_smart_on, R.drawable.mode_icon_smart_on_disabled, R.drawable.mode_icon_smart_off, R.drawable.mode_icon_smart_off_disabled, R.drawable.mode_icon_smart_flat, 0, R.drawable.mode_icon_v2_smart_on, R.drawable.mode_icon_v2_smart_off, R.drawable.mode_icon_v2_smart_disabled, 64, (int) null),
    PREVIOUS(R.string.schedule_previous, R.drawable.mode_icon_previous_on, R.drawable.mode_icon_previous_on_disabled, R.drawable.mode_icon_previous_off, R.drawable.mode_icon_previous_off_disabled, R.drawable.mode_icon_previous_flat, 0, 0, 0, 0, 960, (int) null),
    STANDBY(R.string.stand_by, R.drawable.mode_icon_standby_on, R.drawable.mode_icon_standby_on_disabled, R.drawable.mode_icon_standby_off, R.drawable.mode_icon_standby_off_disabled, R.drawable.mode_icon_standby_flat, 0, R.drawable.mode_icon_v2_standby_on, R.drawable.mode_icon_v2_standby_off, R.drawable.mode_icon_v2_standby_disabled, 64, (int) null),
    FAN_SPEED(R.string.fan_speed, R.drawable.mode_icon_fanspeed_on, R.drawable.mode_icon_fanspeed_on_disabled, R.drawable.mode_icon_fanspeed_off, R.drawable.mode_icon_fanspeed_off_disabled, R.drawable.mode_icon_fanspeed_flat, R.string.fan, R.drawable.mode_icon_v2_fanspeed_on, R.drawable.mode_icon_v2_fanspeed_off, R.drawable.mode_icon_v2_fanspeed_disabled),
    AUTO(R.string.auto, R.drawable.mode_icon_auto_on, R.drawable.mode_icon_auto_on_disabled, R.drawable.mode_icon_auto_off, R.drawable.mode_icon_auto_off_disabled, R.drawable.mode_icon_auto_flat, 0, R.drawable.mode_icon_v2_auto_on, R.drawable.mode_icon_v2_auto_off, R.drawable.mode_icon_v2_auto_disabled, 64, (int) null),
    WATERDROP_AUTO(R.string.auto, R.drawable.mode_icon_auto_on, R.drawable.mode_icon_auto_on_disabled, R.drawable.mode_icon_auto_off, R.drawable.mode_icon_auto_off_disabled, R.drawable.mode_icon_waterdrop_auto_flat, 0, R.drawable.mode_icon_waterdrop_auto_on, R.drawable.mode_icon_waterdrop_auto_off, R.drawable.mode_icon_waterdrop_auto_disabled, 64, (int) null),
    NIGHT(R.string.night, R.drawable.mode_icon_night_on, R.drawable.mode_icon_night_on_disabled, R.drawable.mode_icon_night_off, R.drawable.mode_icon_night_off_disabled, R.drawable.mode_icon_night_flat, 0, R.drawable.mode_icon_v2_night_on, R.drawable.mode_icon_v2_night_off, R.drawable.mode_icon_v2_night_disabled, 64, (int) null),
    ECO(R.string.eco, R.drawable.mode_icon_eco_on, R.drawable.mode_icon_eco_on_disabled, R.drawable.mode_icon_eco_off, R.drawable.mode_icon_eco_off_disabled, R.drawable.mode_icon_eco_flat, 0, R.drawable.mode_icon_v2_eco_on, R.drawable.mode_icon_v2_eco_off, R.drawable.mode_icon_v2_eco_disabled, 64, (int) null),
    SKIN(R.string.skin, R.drawable.mode_icon_skin_on, R.drawable.mode_icon_skin_disabled, R.drawable.mode_icon_skin_off, R.drawable.mode_icon_skin_disabled, R.drawable.mode_icon_skin_flat, 0, 0, 0, 0, 960, (int) null),
    CHILD_LOCK(R.string.childlock_title, R.drawable.mode_icon_childlock_on, R.drawable.mode_icon_childlock_on_disabled, R.drawable.mode_icon_childlock_off, R.drawable.mode_icon_childlock_off_disabled, R.drawable.mode_icon_childlock_flat, 0, 0, 0, 0, 960, (int) null),
    DISINFECTION(R.string.disinfection, R.drawable.mode_icon_disinfection_on, R.drawable.mode_icon_disinfection_on_disabled, R.drawable.mode_icon_disinfection_off, R.drawable.mode_icon_disinfection_off_disabled, R.drawable.mode_icon_disinfection_flat, 0, 0, 0, 0, 960, (int) null),
    DRYING(R.string.main_mode_drying, R.drawable.mode_icon_clothes_on, R.drawable.mode_icon_clothes_on_disabled, R.drawable.mode_icon_clothes_off, R.drawable.mode_icon_clothes_off_disabled, R.drawable.mode_icon_clothes_flat, 0, R.drawable.mode_icon_v2_drying_on, R.drawable.mode_icon_v2_drying_off, R.drawable.mode_icon_v2_drying_disabled, 64, (int) null),
    CONTINUOUS(R.string.main_mode_continuous, R.drawable.mode_icon_cycle_on, R.drawable.mode_icon_cycle_on_disabled, R.drawable.mode_icon_cycle_off, R.drawable.mode_icon_cycle_off_disabled, R.drawable.mode_icon_cycle_flat, 0, R.drawable.mode_icon_v2_continuous_on, R.drawable.mode_icon_v2_continuous_off, R.drawable.mode_icon_v2_continuous_disabled, 64, (int) null);
    
    private final int disabledIconV2;
    private final int flatIcon;
    private final int offIcon;
    private final int offIconDisabled;
    private final int offIconV2;
    private final int onIcon;
    private final int onIconDisabled;
    private final int onIconV2;
    private final int text;
    private final int textShort;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: ModeIcon.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        /* JADX WARNING: Can't wrap try/catch for region: R(27:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|27) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0034 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x003d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0046 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0050 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x005a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0064 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x006e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                com.blueair.viewcore.utils.ModeIcon[] r0 = com.blueair.viewcore.utils.ModeIcon.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.blueair.viewcore.utils.ModeIcon r1 = com.blueair.viewcore.utils.ModeIcon.AIR_PURIFY     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.blueair.viewcore.utils.ModeIcon r1 = com.blueair.viewcore.utils.ModeIcon.HEAT     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.blueair.viewcore.utils.ModeIcon r1 = com.blueair.viewcore.utils.ModeIcon.COOL     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.blueair.viewcore.utils.ModeIcon r1 = com.blueair.viewcore.utils.ModeIcon.SMART     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                com.blueair.viewcore.utils.ModeIcon r1 = com.blueair.viewcore.utils.ModeIcon.FAN_SPEED     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                com.blueair.viewcore.utils.ModeIcon r1 = com.blueair.viewcore.utils.ModeIcon.AUTO     // Catch:{ NoSuchFieldError -> 0x003d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                com.blueair.viewcore.utils.ModeIcon r1 = com.blueair.viewcore.utils.ModeIcon.WATERDROP_AUTO     // Catch:{ NoSuchFieldError -> 0x0046 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0046 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0046 }
            L_0x0046:
                com.blueair.viewcore.utils.ModeIcon r1 = com.blueair.viewcore.utils.ModeIcon.NIGHT     // Catch:{ NoSuchFieldError -> 0x0050 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0050 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0050 }
            L_0x0050:
                com.blueair.viewcore.utils.ModeIcon r1 = com.blueair.viewcore.utils.ModeIcon.ECO     // Catch:{ NoSuchFieldError -> 0x005a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x005a }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x005a }
            L_0x005a:
                com.blueair.viewcore.utils.ModeIcon r1 = com.blueair.viewcore.utils.ModeIcon.DRYING     // Catch:{ NoSuchFieldError -> 0x0064 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0064 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0064 }
            L_0x0064:
                com.blueair.viewcore.utils.ModeIcon r1 = com.blueair.viewcore.utils.ModeIcon.CONTINUOUS     // Catch:{ NoSuchFieldError -> 0x006e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006e }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006e }
            L_0x006e:
                com.blueair.viewcore.utils.ModeIcon r1 = com.blueair.viewcore.utils.ModeIcon.SKIN     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.viewcore.utils.ModeIcon.WhenMappings.<clinit>():void");
        }
    }

    public static EnumEntries<ModeIcon> getEntries() {
        return $ENTRIES;
    }

    private ModeIcon(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        this.text = i;
        this.onIcon = i2;
        this.onIconDisabled = i3;
        this.offIcon = i4;
        this.offIconDisabled = i5;
        this.flatIcon = i6;
        this.textShort = i7;
        this.onIconV2 = i8;
        this.offIconV2 = i9;
        this.disabledIconV2 = i10;
    }

    public final int getText() {
        return this.text;
    }

    public final int getOnIcon() {
        return this.onIcon;
    }

    public final int getOnIconDisabled() {
        return this.onIconDisabled;
    }

    public final int getOffIcon() {
        return this.offIcon;
    }

    public final int getOffIconDisabled() {
        return this.offIconDisabled;
    }

    public final int getFlatIcon() {
        return this.flatIcon;
    }

    public final int getTextShort() {
        return this.textShort;
    }

    public final int getOnIconV2() {
        return this.onIconV2;
    }

    public final int getOffIconV2() {
        return this.offIconV2;
    }

    public final int getDisabledIconV2() {
        return this.disabledIconV2;
    }

    static {
        ModeIcon[] $values;
        $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
    }

    public final MainMode toMainMode() {
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i == 1) {
            return MainMode.AirPurify;
        }
        if (i == 2) {
            return MainMode.HEAT;
        }
        if (i == 3) {
            return MainMode.COOL;
        }
        if (i != 4) {
            return null;
        }
        return MainMode.SMART;
    }

    public final ApSubMode toApSubMode() {
        switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
            case 5:
                return ApSubMode.FAN;
            case 6:
            case 7:
                return ApSubMode.AUTO;
            case 8:
                return ApSubMode.NIGHT;
            case 9:
                return ApSubMode.ECO;
            default:
                return null;
        }
    }

    public final DehSubMode toDehSubMode() {
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i == 6 || i == 7) {
            return DehSubMode.AUTO;
        }
        if (i == 10) {
            return DehSubMode.DRYING;
        }
        if (i != 11) {
            return null;
        }
        return DehSubMode.CONTINUOUS;
    }

    public final HumSubMode toHumSubMode() {
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i == 5) {
            return HumSubMode.FAN;
        }
        if (i == 6 || i == 7) {
            return HumSubMode.AUTO;
        }
        if (i == 8) {
            return HumSubMode.NIGHT;
        }
        if (i != 12) {
            return null;
        }
        return HumSubMode.SKIN;
    }

    public final Mode toMode() {
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i == 12) {
            return Mode.SKIN;
        }
        switch (i) {
            case 5:
                return Mode.FAN;
            case 6:
            case 7:
                return Mode.AUTO;
            case 8:
                return Mode.NIGHT;
            case 9:
                return Mode.ECO;
            default:
                return null;
        }
    }

    public final ModeIcon proofread(Device device) {
        return (device != null && DeviceKt.useWatetdropAuto(device) && this == AUTO) ? WATERDROP_AUTO : this;
    }
}
