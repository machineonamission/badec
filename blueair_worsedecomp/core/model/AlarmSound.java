package com.blueair.core.model;

import com.blueair.core.R;
import com.blueair.core.util.SkuConfigurationManager;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0002\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0017B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0018"}, d2 = {"Lcom/blueair/core/model/AlarmSound;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "Mute", "Birds", "Waves", "Ting", "NordicFlow", "BlueAwakening", "HappyRise", "MorningChime", "SkylightDance", "MidnightRain", "HarmonicLight", "GentleGlow", "getName", "mcuFirmware", "", "Companion", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceAlarm.kt */
public enum AlarmSound {
    Mute(0),
    Birds(1),
    Waves(2),
    Ting(3),
    NordicFlow(4),
    BlueAwakening(5),
    HappyRise(6),
    MorningChime(7),
    SkylightDance(8),
    MidnightRain(9),
    HarmonicLight(10),
    GentleGlow(11);
    
    public static final Companion Companion = null;
    private final int value;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceAlarm.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        /* JADX WARNING: Can't wrap try/catch for region: R(25:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|25) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0034 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x003d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0046 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0050 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x005a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0064 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                com.blueair.core.model.AlarmSound[] r0 = com.blueair.core.model.AlarmSound.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.blueair.core.model.AlarmSound r1 = com.blueair.core.model.AlarmSound.Birds     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.blueair.core.model.AlarmSound r1 = com.blueair.core.model.AlarmSound.Waves     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.blueair.core.model.AlarmSound r1 = com.blueair.core.model.AlarmSound.Ting     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.blueair.core.model.AlarmSound r1 = com.blueair.core.model.AlarmSound.NordicFlow     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                com.blueair.core.model.AlarmSound r1 = com.blueair.core.model.AlarmSound.BlueAwakening     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                com.blueair.core.model.AlarmSound r1 = com.blueair.core.model.AlarmSound.HappyRise     // Catch:{ NoSuchFieldError -> 0x003d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                com.blueair.core.model.AlarmSound r1 = com.blueair.core.model.AlarmSound.MorningChime     // Catch:{ NoSuchFieldError -> 0x0046 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0046 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0046 }
            L_0x0046:
                com.blueair.core.model.AlarmSound r1 = com.blueair.core.model.AlarmSound.SkylightDance     // Catch:{ NoSuchFieldError -> 0x0050 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0050 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0050 }
            L_0x0050:
                com.blueair.core.model.AlarmSound r1 = com.blueair.core.model.AlarmSound.MidnightRain     // Catch:{ NoSuchFieldError -> 0x005a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x005a }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x005a }
            L_0x005a:
                com.blueair.core.model.AlarmSound r1 = com.blueair.core.model.AlarmSound.HarmonicLight     // Catch:{ NoSuchFieldError -> 0x0064 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0064 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0064 }
            L_0x0064:
                com.blueair.core.model.AlarmSound r1 = com.blueair.core.model.AlarmSound.GentleGlow     // Catch:{ NoSuchFieldError -> 0x006e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006e }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006e }
            L_0x006e:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.core.model.AlarmSound.WhenMappings.<clinit>():void");
        }
    }

    public static EnumEntries<AlarmSound> getEntries() {
        return $ENTRIES;
    }

    private AlarmSound(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }

    static {
        AlarmSound[] $values;
        $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t2\u0006\u0010\n\u001a\u00020\u000b¨\u0006\f"}, d2 = {"Lcom/blueair/core/model/AlarmSound$Companion;", "", "<init>", "()V", "fromValue", "Lcom/blueair/core/model/AlarmSound;", "value", "", "entries", "", "mcuFirmware", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceAlarm.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AlarmSound fromValue(int i) {
            Object obj;
            Iterator it = AlarmSound.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (((AlarmSound) obj).getValue() == i) {
                    break;
                }
            }
            AlarmSound alarmSound = (AlarmSound) obj;
            return alarmSound == null ? AlarmSound.Birds : alarmSound;
        }

        public final List<AlarmSound> entries(String str) {
            Intrinsics.checkNotNullParameter(str, "mcuFirmware");
            if (McuFirmwareVersions.Companion.compare(str, SkuConfigurationManager.INSTANCE.getMcuFirmwareVersions().getMrestAlarmSoundV2()) >= 0) {
                return CollectionsKt.drop(AlarmSound.getEntries(), 1);
            }
            return CollectionsKt.take(CollectionsKt.drop(AlarmSound.getEntries(), 1), 3);
        }
    }

    public final int getName(String str) {
        Intrinsics.checkNotNullParameter(str, "mcuFirmware");
        if (McuFirmwareVersions.Companion.compare(str, SkuConfigurationManager.INSTANCE.getMcuFirmwareVersions().getMrestAlarmSoundV2()) >= 0) {
            switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
                case 1:
                    return R.string.sound_brid_song;
                case 2:
                    return R.string.sound_mantra_breeze;
                case 3:
                    return R.string.sound_meadow_notes;
                case 4:
                    return R.string.sound_nordic_flow;
                case 5:
                    return R.string.sound_blue_awakening;
                case 6:
                    return R.string.sound_happy_rise;
                case 7:
                    return R.string.sound_morning_chime;
                case 8:
                    return R.string.sound_skylight_dance;
                case 9:
                    return R.string.sound_midnight_rain;
                case 10:
                    return R.string.sound_harmonic_light;
                case 11:
                    return R.string.sound_gentle_glow;
                default:
                    return R.string.sound_brid_song;
            }
        } else {
            int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
            if (i == 1) {
                return R.string.sound_birds;
            }
            if (i == 2) {
                return R.string.sound_waves;
            }
            if (i != 3) {
                return R.string.sound_birds;
            }
            return R.string.sound_ting;
        }
    }
}
