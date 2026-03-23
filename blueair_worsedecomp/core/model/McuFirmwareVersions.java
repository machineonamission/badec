package com.blueair.core.model;

import com.blueair.core.util.StringUtils;
import com.squareup.moshi.Json;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\"\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u0000 +2\u00020\u0001:\u0001+Bk\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0003\u0010\b\u001a\u00020\u0003\u0012\b\b\u0003\u0010\t\u001a\u00020\u0003\u0012\b\b\u0003\u0010\n\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0003\u0010\f\u001a\u00020\u0003¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003Jm\u0010$\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00032\b\b\u0003\u0010\u0006\u001a\u00020\u00032\b\b\u0003\u0010\u0007\u001a\u00020\u00032\b\b\u0003\u0010\b\u001a\u00020\u00032\b\b\u0003\u0010\t\u001a\u00020\u00032\b\b\u0003\u0010\n\u001a\u00020\u00032\b\b\u0003\u0010\u000b\u001a\u00020\u00032\b\b\u0003\u0010\f\u001a\u00020\u0003HÆ\u0001J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020)HÖ\u0001J\t\u0010*\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010¨\u0006,"}, d2 = {"Lcom/blueair/core/model/McuFirmwareVersions;", "", "mrestNightModeV2", "", "mrestAlarmSoundV2", "mrestHourFormatV2", "mrestBrightnessV2", "hum20BrightnessV2", "dehumidifierBrightnessV2", "combo2in120NightModeV2", "combo2in120BrightnessV2", "blue40BrightnessV2", "pet20BrightnessV2", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getMrestNightModeV2", "()Ljava/lang/String;", "getMrestAlarmSoundV2", "getMrestHourFormatV2", "getMrestBrightnessV2", "getHum20BrightnessV2", "getDehumidifierBrightnessV2", "getCombo2in120NightModeV2", "getCombo2in120BrightnessV2", "getBlue40BrightnessV2", "getPet20BrightnessV2", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: SkuConfiguration.kt */
public final class McuFirmwareVersions {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final String blue40BrightnessV2;
    private final String combo2in120BrightnessV2;
    private final String combo2in120NightModeV2;
    private final String dehumidifierBrightnessV2;
    private final String hum20BrightnessV2;
    private final String mrestAlarmSoundV2;
    private final String mrestBrightnessV2;
    private final String mrestHourFormatV2;
    private final String mrestNightModeV2;
    private final String pet20BrightnessV2;

    public McuFirmwareVersions() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 1023, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ McuFirmwareVersions copy$default(McuFirmwareVersions mcuFirmwareVersions, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mcuFirmwareVersions.mrestNightModeV2;
        }
        if ((i & 2) != 0) {
            str2 = mcuFirmwareVersions.mrestAlarmSoundV2;
        }
        if ((i & 4) != 0) {
            str3 = mcuFirmwareVersions.mrestHourFormatV2;
        }
        if ((i & 8) != 0) {
            str4 = mcuFirmwareVersions.mrestBrightnessV2;
        }
        if ((i & 16) != 0) {
            str5 = mcuFirmwareVersions.hum20BrightnessV2;
        }
        if ((i & 32) != 0) {
            str6 = mcuFirmwareVersions.dehumidifierBrightnessV2;
        }
        if ((i & 64) != 0) {
            str7 = mcuFirmwareVersions.combo2in120NightModeV2;
        }
        if ((i & 128) != 0) {
            str8 = mcuFirmwareVersions.combo2in120BrightnessV2;
        }
        if ((i & 256) != 0) {
            str9 = mcuFirmwareVersions.blue40BrightnessV2;
        }
        if ((i & 512) != 0) {
            str10 = mcuFirmwareVersions.pet20BrightnessV2;
        }
        String str11 = str9;
        String str12 = str10;
        String str13 = str7;
        String str14 = str8;
        String str15 = str5;
        String str16 = str6;
        String str17 = str4;
        String str18 = str2;
        return mcuFirmwareVersions.copy(str, str18, str3, str17, str15, str16, str13, str14, str11, str12);
    }

    public final String component1() {
        return this.mrestNightModeV2;
    }

    public final String component10() {
        return this.pet20BrightnessV2;
    }

    public final String component2() {
        return this.mrestAlarmSoundV2;
    }

    public final String component3() {
        return this.mrestHourFormatV2;
    }

    public final String component4() {
        return this.mrestBrightnessV2;
    }

    public final String component5() {
        return this.hum20BrightnessV2;
    }

    public final String component6() {
        return this.dehumidifierBrightnessV2;
    }

    public final String component7() {
        return this.combo2in120NightModeV2;
    }

    public final String component8() {
        return this.combo2in120BrightnessV2;
    }

    public final String component9() {
        return this.blue40BrightnessV2;
    }

    public final McuFirmwareVersions copy(@Json(name = "mrest_night_mode_v2") String str, @Json(name = "mrest_alarm_sound_v2") String str2, @Json(name = "mrest_hour_format_v2") String str3, @Json(name = "mrest_brightness_v2") String str4, @Json(name = "hum20_brightness_v2") String str5, @Json(name = "dehumidifier_brightness_v2") String str6, @Json(name = "combo2in120_night_mode_v2") String str7, @Json(name = "combo2in120_brightness_v2") String str8, @Json(name = "blue40_brightness_v2") String str9, @Json(name = "pet20_brightness_v2") String str10) {
        Intrinsics.checkNotNullParameter(str, "mrestNightModeV2");
        Intrinsics.checkNotNullParameter(str2, "mrestAlarmSoundV2");
        Intrinsics.checkNotNullParameter(str3, "mrestHourFormatV2");
        String str11 = str4;
        Intrinsics.checkNotNullParameter(str11, "mrestBrightnessV2");
        String str12 = str5;
        Intrinsics.checkNotNullParameter(str12, "hum20BrightnessV2");
        String str13 = str6;
        Intrinsics.checkNotNullParameter(str13, "dehumidifierBrightnessV2");
        String str14 = str7;
        Intrinsics.checkNotNullParameter(str14, "combo2in120NightModeV2");
        String str15 = str8;
        Intrinsics.checkNotNullParameter(str15, "combo2in120BrightnessV2");
        String str16 = str9;
        Intrinsics.checkNotNullParameter(str16, "blue40BrightnessV2");
        String str17 = str10;
        Intrinsics.checkNotNullParameter(str17, "pet20BrightnessV2");
        return new McuFirmwareVersions(str, str2, str3, str11, str12, str13, str14, str15, str16, str17);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof McuFirmwareVersions)) {
            return false;
        }
        McuFirmwareVersions mcuFirmwareVersions = (McuFirmwareVersions) obj;
        return Intrinsics.areEqual((Object) this.mrestNightModeV2, (Object) mcuFirmwareVersions.mrestNightModeV2) && Intrinsics.areEqual((Object) this.mrestAlarmSoundV2, (Object) mcuFirmwareVersions.mrestAlarmSoundV2) && Intrinsics.areEqual((Object) this.mrestHourFormatV2, (Object) mcuFirmwareVersions.mrestHourFormatV2) && Intrinsics.areEqual((Object) this.mrestBrightnessV2, (Object) mcuFirmwareVersions.mrestBrightnessV2) && Intrinsics.areEqual((Object) this.hum20BrightnessV2, (Object) mcuFirmwareVersions.hum20BrightnessV2) && Intrinsics.areEqual((Object) this.dehumidifierBrightnessV2, (Object) mcuFirmwareVersions.dehumidifierBrightnessV2) && Intrinsics.areEqual((Object) this.combo2in120NightModeV2, (Object) mcuFirmwareVersions.combo2in120NightModeV2) && Intrinsics.areEqual((Object) this.combo2in120BrightnessV2, (Object) mcuFirmwareVersions.combo2in120BrightnessV2) && Intrinsics.areEqual((Object) this.blue40BrightnessV2, (Object) mcuFirmwareVersions.blue40BrightnessV2) && Intrinsics.areEqual((Object) this.pet20BrightnessV2, (Object) mcuFirmwareVersions.pet20BrightnessV2);
    }

    public int hashCode() {
        return (((((((((((((((((this.mrestNightModeV2.hashCode() * 31) + this.mrestAlarmSoundV2.hashCode()) * 31) + this.mrestHourFormatV2.hashCode()) * 31) + this.mrestBrightnessV2.hashCode()) * 31) + this.hum20BrightnessV2.hashCode()) * 31) + this.dehumidifierBrightnessV2.hashCode()) * 31) + this.combo2in120NightModeV2.hashCode()) * 31) + this.combo2in120BrightnessV2.hashCode()) * 31) + this.blue40BrightnessV2.hashCode()) * 31) + this.pet20BrightnessV2.hashCode();
    }

    public String toString() {
        return "McuFirmwareVersions(mrestNightModeV2=" + this.mrestNightModeV2 + ", mrestAlarmSoundV2=" + this.mrestAlarmSoundV2 + ", mrestHourFormatV2=" + this.mrestHourFormatV2 + ", mrestBrightnessV2=" + this.mrestBrightnessV2 + ", hum20BrightnessV2=" + this.hum20BrightnessV2 + ", dehumidifierBrightnessV2=" + this.dehumidifierBrightnessV2 + ", combo2in120NightModeV2=" + this.combo2in120NightModeV2 + ", combo2in120BrightnessV2=" + this.combo2in120BrightnessV2 + ", blue40BrightnessV2=" + this.blue40BrightnessV2 + ", pet20BrightnessV2=" + this.pet20BrightnessV2 + ')';
    }

    public McuFirmwareVersions(@Json(name = "mrest_night_mode_v2") String str, @Json(name = "mrest_alarm_sound_v2") String str2, @Json(name = "mrest_hour_format_v2") String str3, @Json(name = "mrest_brightness_v2") String str4, @Json(name = "hum20_brightness_v2") String str5, @Json(name = "dehumidifier_brightness_v2") String str6, @Json(name = "combo2in120_night_mode_v2") String str7, @Json(name = "combo2in120_brightness_v2") String str8, @Json(name = "blue40_brightness_v2") String str9, @Json(name = "pet20_brightness_v2") String str10) {
        Intrinsics.checkNotNullParameter(str, "mrestNightModeV2");
        Intrinsics.checkNotNullParameter(str2, "mrestAlarmSoundV2");
        Intrinsics.checkNotNullParameter(str3, "mrestHourFormatV2");
        Intrinsics.checkNotNullParameter(str4, "mrestBrightnessV2");
        Intrinsics.checkNotNullParameter(str5, "hum20BrightnessV2");
        Intrinsics.checkNotNullParameter(str6, "dehumidifierBrightnessV2");
        Intrinsics.checkNotNullParameter(str7, "combo2in120NightModeV2");
        Intrinsics.checkNotNullParameter(str8, "combo2in120BrightnessV2");
        Intrinsics.checkNotNullParameter(str9, "blue40BrightnessV2");
        Intrinsics.checkNotNullParameter(str10, "pet20BrightnessV2");
        this.mrestNightModeV2 = str;
        this.mrestAlarmSoundV2 = str2;
        this.mrestHourFormatV2 = str3;
        this.mrestBrightnessV2 = str4;
        this.hum20BrightnessV2 = str5;
        this.dehumidifierBrightnessV2 = str6;
        this.combo2in120NightModeV2 = str7;
        this.combo2in120BrightnessV2 = str8;
        this.blue40BrightnessV2 = str9;
        this.pet20BrightnessV2 = str10;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ McuFirmwareVersions(java.lang.String r2, java.lang.String r3, java.lang.String r4, java.lang.String r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, int r12, kotlin.jvm.internal.DefaultConstructorMarker r13) {
        /*
            r1 = this;
            r13 = r12 & 1
            java.lang.String r0 = "1.2.3"
            if (r13 == 0) goto L_0x0007
            r2 = r0
        L_0x0007:
            r13 = r12 & 2
            if (r13 == 0) goto L_0x000d
            java.lang.String r3 = "1.0.6"
        L_0x000d:
            r13 = r12 & 4
            if (r13 == 0) goto L_0x0013
            java.lang.String r4 = "1.1.0"
        L_0x0013:
            r13 = r12 & 8
            if (r13 == 0) goto L_0x0018
            r5 = r0
        L_0x0018:
            r13 = r12 & 16
            if (r13 == 0) goto L_0x001e
            java.lang.String r6 = "1.0.3"
        L_0x001e:
            r13 = r12 & 32
            java.lang.String r0 = "0.0.0"
            if (r13 == 0) goto L_0x0025
            r7 = r0
        L_0x0025:
            r13 = r12 & 64
            if (r13 == 0) goto L_0x002b
            java.lang.String r8 = "2.0.0"
        L_0x002b:
            r13 = r12 & 128(0x80, float:1.794E-43)
            if (r13 == 0) goto L_0x0030
            r9 = r0
        L_0x0030:
            r13 = r12 & 256(0x100, float:3.59E-43)
            if (r13 == 0) goto L_0x0035
            r10 = r0
        L_0x0035:
            r12 = r12 & 512(0x200, float:7.175E-43)
            if (r12 == 0) goto L_0x003b
            r12 = r0
            goto L_0x003c
        L_0x003b:
            r12 = r11
        L_0x003c:
            r11 = r10
            r10 = r9
            r9 = r8
            r8 = r7
            r7 = r6
            r6 = r5
            r5 = r4
            r4 = r3
            r3 = r2
            r2 = r1
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.core.model.McuFirmwareVersions.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getMrestNightModeV2() {
        return this.mrestNightModeV2;
    }

    public final String getMrestAlarmSoundV2() {
        return this.mrestAlarmSoundV2;
    }

    public final String getMrestHourFormatV2() {
        return this.mrestHourFormatV2;
    }

    public final String getMrestBrightnessV2() {
        return this.mrestBrightnessV2;
    }

    public final String getHum20BrightnessV2() {
        return this.hum20BrightnessV2;
    }

    public final String getDehumidifierBrightnessV2() {
        return this.dehumidifierBrightnessV2;
    }

    public final String getCombo2in120NightModeV2() {
        return this.combo2in120NightModeV2;
    }

    public final String getCombo2in120BrightnessV2() {
        return this.combo2in120BrightnessV2;
    }

    public final String getBlue40BrightnessV2() {
        return this.blue40BrightnessV2;
    }

    public final String getPet20BrightnessV2() {
        return this.pet20BrightnessV2;
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007¨\u0006\t"}, d2 = {"Lcom/blueair/core/model/McuFirmwareVersions$Companion;", "", "<init>", "()V", "compare", "", "new", "", "old", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: SkuConfiguration.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final int compare(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "new");
            Intrinsics.checkNotNullParameter(str2, "old");
            return StringUtils.INSTANCE.compareVersion(str, str2);
        }
    }
}
