package com.blueair.devicedetails.util;

import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceHumidifier;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.FanSpeedEnum;
import com.blueair.core.model.HasBlueCloudFunctions;
import com.blueair.core.model.HasFanSpeed;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import timber.log.Timber;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006J\u000e\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006J\u000e\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006J\u000e\u0010\u0012\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006J\u000e\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006J\u001e\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0006J\u0016\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u0006J\u0018\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0006H\u0002J\u000e\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020!J\u000e\u0010\"\u001a\u00020\u00062\u0006\u0010 \u001a\u00020!J\u0018\u0010\"\u001a\u00020\u00062\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\u000f\u001a\u00020\u0010J\u001a\u0010\"\u001a\u00020\u00062\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\u0017\u001a\u00020\u0006H\u0002R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\b¨\u0006#"}, d2 = {"Lcom/blueair/devicedetails/util/FanSpeedUtils;", "", "<init>", "()V", "G4_FAN_PROGRESS_SNAP", "", "", "getG4_FAN_PROGRESS_SNAP", "()Ljava/util/List;", "getG4FanSpeedFromSeekBarProgress", "progress", "BLUE_PREMIUM_FAN_PROGRESS_SNAP", "getBLUE_PREMIUM_FAN_PROGRESS_SNAP", "getBluePremiumFromSeekBarProgress", "getProgressFromFanSpeedBluePremium", "fanSpeedEnum", "Lcom/blueair/core/model/FanSpeedEnum;", "getLegacySpeedFromSeekBarProgress", "getIcpSpeedFromSeekBarProgress", "getProgressFromFanSpeedLegacy", "getProgressFromFanSpeedG4", "getProgressFromFanSpeedIcp", "getG4AutoModeProgress", "fanSpeed", "relativeProgress", "input", "min", "max", "actualProgress", "maxProgress", "getPercent", "getFanSpeedPercent", "device", "Lcom/blueair/core/model/Device;", "getFanSpeedLevel", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: FanSpeedUtils.kt */
public final class FanSpeedUtils {
    private static final List<Integer> BLUE_PREMIUM_FAN_PROGRESS_SNAP = CollectionsKt.listOf(null, 25, 27, 30, 34, 38, 42, 46, 50, 52, 55, 59, 63, 67, 71, 75, 77, 80, 84, 88, 92, 96, 100);
    private static final List<Integer> G4_FAN_PROGRESS_SNAP = CollectionsKt.listOf(null, 33, 37, 41, 44, 47, 51, 53, 57, 60, 64, 66, 70, 74, 77, 80, 84, 87, 90, 93, 96, 99);
    public static final FanSpeedUtils INSTANCE = new FanSpeedUtils();

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: FanSpeedUtils.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(56:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|(2:53|54)|55|57) */
        /* JADX WARNING: Can't wrap try/catch for region: R(57:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|57) */
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
        /* JADX WARNING: Missing exception handler attribute for start block: B:53:0x0104 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                com.blueair.core.model.FanSpeedEnum[] r0 = com.blueair.core.model.FanSpeedEnum.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.blueair.core.model.FanSpeedEnum r1 = com.blueair.core.model.FanSpeedEnum.OFF     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.blueair.core.model.FanSpeedEnum r1 = com.blueair.core.model.FanSpeedEnum.ELEVEN     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.blueair.core.model.FanSpeedEnum r1 = com.blueair.core.model.FanSpeedEnum.FIFTEEN     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.blueair.core.model.FanSpeedEnum r1 = com.blueair.core.model.FanSpeedEnum.NINETEEN     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                com.blueair.core.model.FanSpeedEnum r1 = com.blueair.core.model.FanSpeedEnum.TWENTY_THREE     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                com.blueair.core.model.FanSpeedEnum r1 = com.blueair.core.model.FanSpeedEnum.TWENTY_SEVEN     // Catch:{ NoSuchFieldError -> 0x003d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                com.blueair.core.model.FanSpeedEnum r1 = com.blueair.core.model.FanSpeedEnum.THIRTY_ONE     // Catch:{ NoSuchFieldError -> 0x0046 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0046 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0046 }
            L_0x0046:
                com.blueair.core.model.FanSpeedEnum r1 = com.blueair.core.model.FanSpeedEnum.THIRTY_FIVE     // Catch:{ NoSuchFieldError -> 0x0050 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0050 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0050 }
            L_0x0050:
                com.blueair.core.model.FanSpeedEnum r1 = com.blueair.core.model.FanSpeedEnum.THIRTY_SEVEN     // Catch:{ NoSuchFieldError -> 0x005a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x005a }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x005a }
            L_0x005a:
                com.blueair.core.model.FanSpeedEnum r1 = com.blueair.core.model.FanSpeedEnum.THIRTY_NINE     // Catch:{ NoSuchFieldError -> 0x0064 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0064 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0064 }
            L_0x0064:
                com.blueair.core.model.FanSpeedEnum r1 = com.blueair.core.model.FanSpeedEnum.FORTY_THREE     // Catch:{ NoSuchFieldError -> 0x006e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006e }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006e }
            L_0x006e:
                com.blueair.core.model.FanSpeedEnum r1 = com.blueair.core.model.FanSpeedEnum.FORTY_SEVEN     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                com.blueair.core.model.FanSpeedEnum r1 = com.blueair.core.model.FanSpeedEnum.FIFTY_ONE     // Catch:{ NoSuchFieldError -> 0x0082 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0082 }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0082 }
            L_0x0082:
                com.blueair.core.model.FanSpeedEnum r1 = com.blueair.core.model.FanSpeedEnum.FIFTY_FIVE     // Catch:{ NoSuchFieldError -> 0x008c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x008c }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x008c }
            L_0x008c:
                com.blueair.core.model.FanSpeedEnum r1 = com.blueair.core.model.FanSpeedEnum.FIFTY_NINE     // Catch:{ NoSuchFieldError -> 0x0096 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0096 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0096 }
            L_0x0096:
                com.blueair.core.model.FanSpeedEnum r1 = com.blueair.core.model.FanSpeedEnum.SIXTY_FOUR     // Catch:{ NoSuchFieldError -> 0x00a0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a0 }
            L_0x00a0:
                com.blueair.core.model.FanSpeedEnum r1 = com.blueair.core.model.FanSpeedEnum.SIXTY_SEVEN     // Catch:{ NoSuchFieldError -> 0x00aa }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00aa }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00aa }
            L_0x00aa:
                com.blueair.core.model.FanSpeedEnum r1 = com.blueair.core.model.FanSpeedEnum.SEVENTY_ONE     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 18
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                com.blueair.core.model.FanSpeedEnum r1 = com.blueair.core.model.FanSpeedEnum.SEVENTY_FIVE     // Catch:{ NoSuchFieldError -> 0x00be }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00be }
                r2 = 19
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00be }
            L_0x00be:
                com.blueair.core.model.FanSpeedEnum r1 = com.blueair.core.model.FanSpeedEnum.SEVENTY_NINE     // Catch:{ NoSuchFieldError -> 0x00c8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c8 }
                r2 = 20
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c8 }
            L_0x00c8:
                com.blueair.core.model.FanSpeedEnum r1 = com.blueair.core.model.FanSpeedEnum.EIGHTY_THREE     // Catch:{ NoSuchFieldError -> 0x00d2 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d2 }
                r2 = 21
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00d2 }
            L_0x00d2:
                com.blueair.core.model.FanSpeedEnum r1 = com.blueair.core.model.FanSpeedEnum.EIGHTY_SEVEN     // Catch:{ NoSuchFieldError -> 0x00dc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00dc }
                r2 = 22
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00dc }
            L_0x00dc:
                com.blueair.core.model.FanSpeedEnum r1 = com.blueair.core.model.FanSpeedEnum.NINETY_ONE     // Catch:{ NoSuchFieldError -> 0x00e6 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00e6 }
                r2 = 23
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00e6 }
            L_0x00e6:
                com.blueair.core.model.FanSpeedEnum r1 = com.blueair.core.model.FanSpeedEnum.ONE     // Catch:{ NoSuchFieldError -> 0x00f0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00f0 }
                r2 = 24
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00f0 }
            L_0x00f0:
                com.blueair.core.model.FanSpeedEnum r1 = com.blueair.core.model.FanSpeedEnum.TWO     // Catch:{ NoSuchFieldError -> 0x00fa }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00fa }
                r2 = 25
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00fa }
            L_0x00fa:
                com.blueair.core.model.FanSpeedEnum r1 = com.blueair.core.model.FanSpeedEnum.THREE     // Catch:{ NoSuchFieldError -> 0x0104 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0104 }
                r2 = 26
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0104 }
            L_0x0104:
                com.blueair.core.model.FanSpeedEnum r1 = com.blueair.core.model.FanSpeedEnum.SIXTY_THREE     // Catch:{ NoSuchFieldError -> 0x010e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x010e }
                r2 = 27
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x010e }
            L_0x010e:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.util.FanSpeedUtils.WhenMappings.<clinit>():void");
        }
    }

    public final int getBluePremiumFromSeekBarProgress(int i) {
        if (i == 0) {
            return 0;
        }
        if (1 <= i && i < 25) {
            return -1;
        }
        if (25 <= i && i < 27) {
            return 11;
        }
        if (27 <= i && i < 30) {
            return 15;
        }
        if (30 <= i && i < 34) {
            return 19;
        }
        if (34 <= i && i < 38) {
            return 23;
        }
        if (38 <= i && i < 42) {
            return 27;
        }
        if (42 <= i && i < 46) {
            return 31;
        }
        if (46 <= i && i < 50) {
            return 35;
        }
        if (50 <= i && i < 52) {
            return 37;
        }
        if (52 <= i && i < 55) {
            return 39;
        }
        if (55 <= i && i < 59) {
            return 43;
        }
        if (59 <= i && i < 63) {
            return 47;
        }
        if (63 <= i && i < 67) {
            return 51;
        }
        if (67 <= i && i < 71) {
            return 55;
        }
        if (71 <= i && i < 75) {
            return 59;
        }
        if (75 <= i && i < 77) {
            return 64;
        }
        if (77 <= i && i < 80) {
            return 67;
        }
        if (80 <= i && i < 84) {
            return 71;
        }
        if (84 <= i && i < 88) {
            return 75;
        }
        if (88 <= i && i < 92) {
            return 79;
        }
        if (92 <= i && i < 96) {
            return 83;
        }
        if (96 > i || i >= 99) {
            return (99 > i || i >= 101) ? 0 : 91;
        }
        return 87;
    }

    public final int getG4FanSpeedFromSeekBarProgress(int i) {
        if (i == 0) {
            return 0;
        }
        if (1 <= i && i < 33) {
            return -1;
        }
        if (33 <= i && i < 37) {
            return 11;
        }
        if (37 <= i && i < 41) {
            return 15;
        }
        if (41 <= i && i < 44) {
            return 19;
        }
        if (44 <= i && i < 47) {
            return 23;
        }
        if (47 <= i && i < 51) {
            return 27;
        }
        if (51 <= i && i < 53) {
            return 31;
        }
        if (53 <= i && i < 57) {
            return 35;
        }
        if (57 <= i && i < 60) {
            return 39;
        }
        if (60 <= i && i < 64) {
            return 43;
        }
        if (64 <= i && i < 66) {
            return 47;
        }
        if (66 <= i && i < 70) {
            return 51;
        }
        if (70 <= i && i < 74) {
            return 55;
        }
        if (74 <= i && i < 77) {
            return 59;
        }
        if (77 <= i && i < 80) {
            return 63;
        }
        if (80 <= i && i < 84) {
            return 67;
        }
        if (84 <= i && i < 87) {
            return 71;
        }
        if (87 <= i && i < 90) {
            return 75;
        }
        if (90 <= i && i < 93) {
            return 79;
        }
        if (93 <= i && i < 96) {
            return 83;
        }
        if (96 > i || i >= 99) {
            return (99 > i || i >= 101) ? 0 : 91;
        }
        return 87;
    }

    public final int getIcpSpeedFromSeekBarProgress(int i) {
        if (i == 0) {
            return 1;
        }
        if (1 <= i && i < 50) {
            return -1;
        }
        if (i == 50) {
            return 2;
        }
        return (51 > i || i >= 100) ? 3 : -1;
    }

    private FanSpeedUtils() {
    }

    public final List<Integer> getG4_FAN_PROGRESS_SNAP() {
        return G4_FAN_PROGRESS_SNAP;
    }

    public final List<Integer> getBLUE_PREMIUM_FAN_PROGRESS_SNAP() {
        return BLUE_PREMIUM_FAN_PROGRESS_SNAP;
    }

    public final int getProgressFromFanSpeedBluePremium(FanSpeedEnum fanSpeedEnum) {
        Intrinsics.checkNotNullParameter(fanSpeedEnum, "fanSpeedEnum");
        switch (WhenMappings.$EnumSwitchMapping$0[fanSpeedEnum.ordinal()]) {
            case 1:
                return 0;
            case 2:
                return 25;
            case 3:
                return 27;
            case 4:
                return 30;
            case 5:
                return 34;
            case 6:
                return 38;
            case 7:
                return 42;
            case 8:
                return 46;
            case 9:
                return 50;
            case 10:
                return 52;
            case 11:
                return 55;
            case 12:
                return 59;
            case 13:
                return 63;
            case 14:
                return 67;
            case 15:
                return 71;
            case 16:
                return 75;
            case 17:
                return 77;
            case 18:
                return 80;
            case 19:
                return 84;
            case 20:
                return 88;
            case 21:
                return 92;
            case 22:
                return 96;
            case 23:
                return 100;
            default:
                return 0;
        }
    }

    public final int getLegacySpeedFromSeekBarProgress(int i) {
        if (i == 0) {
            return 0;
        }
        if (1 <= i && i < 33) {
            return -1;
        }
        if (i == 33) {
            return 1;
        }
        if (34 <= i && i < 66) {
            return -1;
        }
        if (i == 66) {
            return 2;
        }
        if (67 <= i && i < 99) {
            return -1;
        }
        if (99 <= i && i <= Integer.MAX_VALUE) {
            return 3;
        }
        Timber.Forest forest = Timber.Forest;
        forest.d("Unknown value: " + i, new Object[0]);
        return 0;
    }

    public final int getProgressFromFanSpeedLegacy(FanSpeedEnum fanSpeedEnum) {
        Intrinsics.checkNotNullParameter(fanSpeedEnum, "fanSpeedEnum");
        int i = WhenMappings.$EnumSwitchMapping$0[fanSpeedEnum.ordinal()];
        if (i == 1) {
            return 0;
        }
        switch (i) {
            case 24:
                return 33;
            case 25:
                return 66;
            case 26:
                return 99;
            default:
                return 0;
        }
    }

    public final int getProgressFromFanSpeedG4(FanSpeedEnum fanSpeedEnum) {
        Intrinsics.checkNotNullParameter(fanSpeedEnum, "fanSpeedEnum");
        switch (WhenMappings.$EnumSwitchMapping$0[fanSpeedEnum.ordinal()]) {
            case 1:
                return 0;
            case 2:
                return 33;
            case 3:
                return 37;
            case 4:
                return 41;
            case 5:
                return 44;
            case 6:
                return 47;
            case 7:
                return 51;
            case 8:
                return 53;
            case 10:
                return 57;
            case 11:
                return 60;
            case 12:
                return 64;
            case 13:
                return 66;
            case 14:
                return 70;
            case 15:
                return 74;
            case 17:
                return 80;
            case 18:
                return 84;
            case 19:
                return 87;
            case 20:
                return 90;
            case 21:
                return 93;
            case 22:
                return 96;
            case 23:
                return 99;
            case 27:
                return 77;
            default:
                return 0;
        }
    }

    public final int getProgressFromFanSpeedIcp(FanSpeedEnum fanSpeedEnum) {
        Intrinsics.checkNotNullParameter(fanSpeedEnum, "fanSpeedEnum");
        switch (WhenMappings.$EnumSwitchMapping$0[fanSpeedEnum.ordinal()]) {
            case 24:
                return 0;
            case 25:
                return 50;
            case 26:
                return 100;
            default:
                return 0;
        }
    }

    public final int getG4AutoModeProgress(int i) {
        if (i >= 0 && i < 12) {
            return actualProgress(relativeProgress(i, 0, 11), 33);
        }
        if (12 <= i && i < 52) {
            return actualProgress(relativeProgress(i, 11, 51), 33) + 33;
        }
        if (52 > i || i > Integer.MAX_VALUE) {
            return 0;
        }
        return actualProgress(relativeProgress(i, 51, 91), 33) + 66;
    }

    public final int relativeProgress(int i, int i2, int i3) {
        if (i >= i2 && i3 > i2 && i3 != i2) {
            return ((i - i2) * 100) / (i3 - i2);
        }
        Timber.Forest forest = Timber.Forest;
        forest.w("relativeProgress method checks not met: input = " + i + ", min = " + i2 + ", max = " + i3, new Object[0]);
        return 0;
    }

    public final int actualProgress(int i, int i2) {
        return (i * i2) / 100;
    }

    private final int getPercent(int i, int i2) {
        if (i2 != 0 && i2 > 0) {
            return MathKt.roundToInt((((double) i) * 100.0d) / ((double) i2));
        }
        Timber.Forest forest = Timber.Forest;
        forest.w("getPercent method checks not met: input = " + i, new Object[0]);
        return 0;
    }

    public final int getFanSpeedPercent(Device device) {
        int i;
        Intrinsics.checkNotNullParameter(device, "device");
        if (device instanceof DeviceHumidifier) {
            i = 64;
        } else {
            i = DeviceKt.isG4orB4orNB(device) ? 91 : 3;
        }
        return getPercent(DeviceKt.fanSpeedValue(device), i);
    }

    public final int getFanSpeedLevel(Device device) {
        Intrinsics.checkNotNullParameter(device, "device");
        return getFanSpeedLevel(device, DeviceKt.fanSpeedValue(device));
    }

    public final int getFanSpeedLevel(Device device, FanSpeedEnum fanSpeedEnum) {
        Intrinsics.checkNotNullParameter(fanSpeedEnum, "fanSpeedEnum");
        if (!(device instanceof HasFanSpeed)) {
            return 0;
        }
        return getFanSpeedLevel(device, fanSpeedEnum.toServerValue((HasFanSpeed) device));
    }

    private final int getFanSpeedLevel(Device device, int i) {
        HasFanSpeed hasFanSpeed = device instanceof HasFanSpeed ? (HasFanSpeed) device : null;
        if ((hasFanSpeed == null || !hasFanSpeed.getHasGear4()) && !FanSpeedEnum.Companion.isUsingFourGearConfig(device)) {
            if (!(device instanceof HasBlueCloudFunctions)) {
                return i;
            }
            if (i >= 0 && i < 2) {
                return 0;
            }
            if (2 <= i && i < 31) {
                return 1;
            }
            if (31 > i || i >= 71) {
                return (71 > i || i >= 92) ? 0 : 3;
            }
            return 2;
        } else if (i >= 0 && i < 2) {
            return 0;
        } else {
            if (2 <= i && i < 25) {
                return 1;
            }
            if (25 <= i && i < 51) {
                return 2;
            }
            if (51 > i || i >= 78) {
                return (78 > i || i >= 92) ? 0 : 4;
            }
            return 3;
        }
    }
}
