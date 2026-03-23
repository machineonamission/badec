package com.blueair.core.model;

import androidx.constraintlayout.widget.ConstraintLayout;
import at.favre.lib.crypto.bcrypt.BCrypt;
import com.blueair.devicedetails.util.EtaUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u001f\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000 &2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001&B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#J\u0010\u0010$\u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010%j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001f¨\u0006'"}, d2 = {"Lcom/blueair/core/model/FanSpeedEnum;", "", "<init>", "(Ljava/lang/String;I)V", "OFF", "ONE", "TWO", "THREE", "ELEVEN", "FIFTEEN", "NINETEEN", "TWENTY_THREE", "TWENTY_SEVEN", "THIRTY_ONE", "THIRTY_FIVE", "THIRTY_SEVEN", "THIRTY_NINE", "FORTY_THREE", "FORTY_SEVEN", "FIFTY_ONE", "FIFTY_FIVE", "FIFTY_NINE", "SIXTY_THREE", "SIXTY_FOUR", "SIXTY_SEVEN", "SEVENTY_ONE", "SEVENTY_FIVE", "SEVENTY_NINE", "EIGHTY_THREE", "EIGHTY_SEVEN", "NINETY_ONE", "SNAP_STEP", "toServerValue", "", "device", "Lcom/blueair/core/model/HasFanSpeed;", "toStep", "Lcom/blueair/core/model/Device;", "Companion", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: FanSpeedEnum.kt */
public enum FanSpeedEnum {
    OFF,
    ONE,
    TWO,
    THREE,
    ELEVEN,
    FIFTEEN,
    NINETEEN,
    TWENTY_THREE,
    TWENTY_SEVEN,
    THIRTY_ONE,
    THIRTY_FIVE,
    THIRTY_SEVEN,
    THIRTY_NINE,
    FORTY_THREE,
    FORTY_SEVEN,
    FIFTY_ONE,
    FIFTY_FIVE,
    FIFTY_NINE,
    SIXTY_THREE,
    SIXTY_FOUR,
    SIXTY_SEVEN,
    SEVENTY_ONE,
    SEVENTY_FIVE,
    SEVENTY_NINE,
    EIGHTY_THREE,
    EIGHTY_SEVEN,
    NINETY_ONE,
    SNAP_STEP;
    
    public static final Companion Companion = null;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: FanSpeedEnum.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

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
                com.blueair.core.model.FanSpeedEnum r1 = com.blueair.core.model.FanSpeedEnum.FIFTY_ONE     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.blueair.core.model.FanSpeedEnum r1 = com.blueair.core.model.FanSpeedEnum.NINETY_ONE     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                com.blueair.core.model.FanSpeedEnum r1 = com.blueair.core.model.FanSpeedEnum.THIRTY_SEVEN     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                com.blueair.core.model.FanSpeedEnum r1 = com.blueair.core.model.FanSpeedEnum.SIXTY_FOUR     // Catch:{ NoSuchFieldError -> 0x003d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                com.blueair.core.model.FanSpeedEnum r1 = com.blueair.core.model.FanSpeedEnum.FIFTEEN     // Catch:{ NoSuchFieldError -> 0x0046 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0046 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0046 }
            L_0x0046:
                com.blueair.core.model.FanSpeedEnum r1 = com.blueair.core.model.FanSpeedEnum.NINETEEN     // Catch:{ NoSuchFieldError -> 0x0050 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0050 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0050 }
            L_0x0050:
                com.blueair.core.model.FanSpeedEnum r1 = com.blueair.core.model.FanSpeedEnum.TWENTY_THREE     // Catch:{ NoSuchFieldError -> 0x005a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x005a }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x005a }
            L_0x005a:
                com.blueair.core.model.FanSpeedEnum r1 = com.blueair.core.model.FanSpeedEnum.TWENTY_SEVEN     // Catch:{ NoSuchFieldError -> 0x0064 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0064 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0064 }
            L_0x0064:
                com.blueair.core.model.FanSpeedEnum r1 = com.blueair.core.model.FanSpeedEnum.THIRTY_ONE     // Catch:{ NoSuchFieldError -> 0x006e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006e }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006e }
            L_0x006e:
                com.blueair.core.model.FanSpeedEnum r1 = com.blueair.core.model.FanSpeedEnum.THIRTY_FIVE     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                com.blueair.core.model.FanSpeedEnum r1 = com.blueair.core.model.FanSpeedEnum.THIRTY_NINE     // Catch:{ NoSuchFieldError -> 0x0082 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0082 }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0082 }
            L_0x0082:
                com.blueair.core.model.FanSpeedEnum r1 = com.blueair.core.model.FanSpeedEnum.FORTY_THREE     // Catch:{ NoSuchFieldError -> 0x008c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x008c }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x008c }
            L_0x008c:
                com.blueair.core.model.FanSpeedEnum r1 = com.blueair.core.model.FanSpeedEnum.FORTY_SEVEN     // Catch:{ NoSuchFieldError -> 0x0096 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0096 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0096 }
            L_0x0096:
                com.blueair.core.model.FanSpeedEnum r1 = com.blueair.core.model.FanSpeedEnum.FIFTY_FIVE     // Catch:{ NoSuchFieldError -> 0x00a0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a0 }
            L_0x00a0:
                com.blueair.core.model.FanSpeedEnum r1 = com.blueair.core.model.FanSpeedEnum.FIFTY_NINE     // Catch:{ NoSuchFieldError -> 0x00aa }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00aa }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00aa }
            L_0x00aa:
                com.blueair.core.model.FanSpeedEnum r1 = com.blueair.core.model.FanSpeedEnum.SIXTY_SEVEN     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 18
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                com.blueair.core.model.FanSpeedEnum r1 = com.blueair.core.model.FanSpeedEnum.SEVENTY_ONE     // Catch:{ NoSuchFieldError -> 0x00be }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00be }
                r2 = 19
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00be }
            L_0x00be:
                com.blueair.core.model.FanSpeedEnum r1 = com.blueair.core.model.FanSpeedEnum.SEVENTY_FIVE     // Catch:{ NoSuchFieldError -> 0x00c8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c8 }
                r2 = 20
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c8 }
            L_0x00c8:
                com.blueair.core.model.FanSpeedEnum r1 = com.blueair.core.model.FanSpeedEnum.SEVENTY_NINE     // Catch:{ NoSuchFieldError -> 0x00d2 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d2 }
                r2 = 21
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00d2 }
            L_0x00d2:
                com.blueair.core.model.FanSpeedEnum r1 = com.blueair.core.model.FanSpeedEnum.EIGHTY_THREE     // Catch:{ NoSuchFieldError -> 0x00dc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00dc }
                r2 = 22
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00dc }
            L_0x00dc:
                com.blueair.core.model.FanSpeedEnum r1 = com.blueair.core.model.FanSpeedEnum.EIGHTY_SEVEN     // Catch:{ NoSuchFieldError -> 0x00e6 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00e6 }
                r2 = 23
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00e6 }
            L_0x00e6:
                com.blueair.core.model.FanSpeedEnum r1 = com.blueair.core.model.FanSpeedEnum.SIXTY_THREE     // Catch:{ NoSuchFieldError -> 0x00f0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00f0 }
                r2 = 24
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00f0 }
            L_0x00f0:
                com.blueair.core.model.FanSpeedEnum r1 = com.blueair.core.model.FanSpeedEnum.ONE     // Catch:{ NoSuchFieldError -> 0x00fa }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00fa }
                r2 = 25
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00fa }
            L_0x00fa:
                com.blueair.core.model.FanSpeedEnum r1 = com.blueair.core.model.FanSpeedEnum.TWO     // Catch:{ NoSuchFieldError -> 0x0104 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0104 }
                r2 = 26
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0104 }
            L_0x0104:
                com.blueair.core.model.FanSpeedEnum r1 = com.blueair.core.model.FanSpeedEnum.THREE     // Catch:{ NoSuchFieldError -> 0x010e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x010e }
                r2 = 27
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x010e }
            L_0x010e:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.core.model.FanSpeedEnum.WhenMappings.<clinit>():void");
        }
    }

    public static EnumEntries<FanSpeedEnum> getEntries() {
        return $ENTRIES;
    }

    static {
        FanSpeedEnum[] $values;
        $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\n\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\f\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u000e\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\tJ\u000e\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\tJ\u000e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\tJ\u000e\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\tJ\u0018\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¨\u0006\u0014"}, d2 = {"Lcom/blueair/core/model/FanSpeedEnum$Companion;", "", "<init>", "()V", "fromServerValue", "Lcom/blueair/core/model/FanSpeedEnum;", "device", "Lcom/blueair/core/model/Device;", "speed", "", "isUsingFourGearConfig", "", "isUsingTypicallyConfig", "fanSpeedEnumFromProgressG4", "progress", "fanSpeedEnumFromProgressBluePremium", "fanSpeedEnumFromProgressLegacy", "fanSpeedEnumFromProgressIcp", "fromStep", "step", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: FanSpeedEnum.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final FanSpeedEnum fromServerValue(Device device, int i) {
            int i2;
            int i3;
            int i4;
            int i5;
            int i6;
            int i7;
            int i8;
            int i9;
            int i10;
            int i11;
            int i12;
            int i13;
            int i14;
            Device device2 = device;
            int i15 = i;
            Intrinsics.checkNotNullParameter(device2, "device");
            if (!(device2 instanceof HasFanSpeed)) {
                return FanSpeedEnum.OFF;
            }
            if (isUsingTypicallyConfig(device)) {
                if (i15 >= 0 && i15 < 11) {
                    return ((HasFanSpeed) device2).getHasGear0() ? FanSpeedEnum.OFF : FanSpeedEnum.ELEVEN;
                }
                if (11 <= i15 && i15 < 51) {
                    return FanSpeedEnum.ELEVEN;
                }
                if (51 <= i15 && i15 < 91) {
                    return FanSpeedEnum.FIFTY_ONE;
                }
                if (91 > i15 || i15 >= 101) {
                    return FanSpeedEnum.OFF;
                }
                return FanSpeedEnum.NINETY_ONE;
            } else if (isUsingFourGearConfig(device)) {
                if (i15 >= 0 && i15 < 11) {
                    return FanSpeedEnum.OFF;
                }
                if (11 <= i15 && i15 < 37) {
                    return FanSpeedEnum.ELEVEN;
                }
                if (37 <= i15 && i15 < 64) {
                    return FanSpeedEnum.THIRTY_SEVEN;
                }
                if (64 <= i15 && i15 < 91) {
                    return FanSpeedEnum.SIXTY_FOUR;
                }
                if (91 > i15 || i15 >= 101) {
                    return FanSpeedEnum.OFF;
                }
                return FanSpeedEnum.NINETY_ONE;
            } else if (((HasFanSpeed) device2).getHasGear4()) {
                if (i15 >= 0 && i15 < 11) {
                    return FanSpeedEnum.OFF;
                }
                if (11 <= i15 && i15 < 15) {
                    return FanSpeedEnum.ELEVEN;
                }
                if (15 <= i15 && i15 < 19) {
                    return FanSpeedEnum.FIFTEEN;
                }
                if (19 <= i15 && i15 < 23) {
                    return FanSpeedEnum.NINETEEN;
                }
                if (23 <= i15 && i15 < 27) {
                    return FanSpeedEnum.TWENTY_THREE;
                }
                if (27 <= i15 && i15 < 31) {
                    return FanSpeedEnum.TWENTY_SEVEN;
                }
                if (31 <= i15 && i15 < 35) {
                    return FanSpeedEnum.THIRTY_ONE;
                }
                if (35 <= i15 && i15 < 37) {
                    return FanSpeedEnum.THIRTY_FIVE;
                }
                if (37 <= i15 && i15 < 39) {
                    return FanSpeedEnum.THIRTY_SEVEN;
                }
                if (39 <= i15 && i15 < 43) {
                    return FanSpeedEnum.THIRTY_NINE;
                }
                if (43 <= i15 && i15 < 47) {
                    return FanSpeedEnum.FORTY_THREE;
                }
                if (47 <= i15 && i15 < 51) {
                    return FanSpeedEnum.FORTY_SEVEN;
                }
                if (51 <= i15 && i15 < 55) {
                    return FanSpeedEnum.FIFTY_ONE;
                }
                if (55 <= i15 && i15 < 59) {
                    return FanSpeedEnum.FIFTY_FIVE;
                }
                if (59 <= i15) {
                    i8 = 64;
                    if (i15 < 64) {
                        return FanSpeedEnum.FIFTY_NINE;
                    }
                } else {
                    i8 = 64;
                }
                if (i8 <= i15) {
                    i9 = 67;
                    if (i15 < 67) {
                        return FanSpeedEnum.SIXTY_FOUR;
                    }
                } else {
                    i9 = 67;
                }
                if (i9 <= i15) {
                    i10 = 71;
                    if (i15 < 71) {
                        return FanSpeedEnum.SIXTY_SEVEN;
                    }
                } else {
                    i10 = 71;
                }
                if (i10 <= i15) {
                    i11 = 75;
                    if (i15 < 75) {
                        return FanSpeedEnum.SEVENTY_ONE;
                    }
                } else {
                    i11 = 75;
                }
                if (i11 <= i15) {
                    i12 = 79;
                    if (i15 < 79) {
                        return FanSpeedEnum.SEVENTY_FIVE;
                    }
                } else {
                    i12 = 79;
                }
                if (i12 <= i15) {
                    i13 = 83;
                    if (i15 < 83) {
                        return FanSpeedEnum.SEVENTY_NINE;
                    }
                } else {
                    i13 = 83;
                }
                if (i13 <= i15 && i15 < 87) {
                    return FanSpeedEnum.EIGHTY_THREE;
                }
                if (87 <= i15) {
                    i14 = 91;
                    if (i15 < 91) {
                        return FanSpeedEnum.EIGHTY_SEVEN;
                    }
                } else {
                    i14 = 91;
                }
                if (i14 > i15 || i15 >= 101) {
                    return FanSpeedEnum.OFF;
                }
                return FanSpeedEnum.NINETY_ONE;
            } else if (DeviceKt.isG4orB4orNB(device2)) {
                if (i15 >= 0 && i15 < 11) {
                    return FanSpeedEnum.OFF;
                }
                if (11 <= i15 && i15 < 15) {
                    return FanSpeedEnum.ELEVEN;
                }
                if (15 <= i15 && i15 < 19) {
                    return FanSpeedEnum.FIFTEEN;
                }
                if (19 <= i15 && i15 < 23) {
                    return FanSpeedEnum.NINETEEN;
                }
                if (23 <= i15 && i15 < 27) {
                    return FanSpeedEnum.TWENTY_THREE;
                }
                if (27 <= i15 && i15 < 31) {
                    return FanSpeedEnum.TWENTY_SEVEN;
                }
                if (31 <= i15 && i15 < 35) {
                    return FanSpeedEnum.THIRTY_ONE;
                }
                if (35 <= i15 && i15 < 39) {
                    return FanSpeedEnum.THIRTY_FIVE;
                }
                if (39 <= i15 && i15 < 43) {
                    return FanSpeedEnum.THIRTY_NINE;
                }
                if (43 <= i15 && i15 < 47) {
                    return FanSpeedEnum.FORTY_THREE;
                }
                if (47 <= i15 && i15 < 51) {
                    return FanSpeedEnum.FORTY_SEVEN;
                }
                if (51 <= i15 && i15 < 55) {
                    return FanSpeedEnum.FIFTY_ONE;
                }
                if (55 <= i15 && i15 < 59) {
                    return FanSpeedEnum.FIFTY_FIVE;
                }
                if (59 <= i15 && i15 < 63) {
                    return FanSpeedEnum.FIFTY_NINE;
                }
                if (63 <= i15) {
                    i2 = 67;
                    if (i15 < 67) {
                        return FanSpeedEnum.SIXTY_THREE;
                    }
                } else {
                    i2 = 67;
                }
                if (i2 <= i15) {
                    i3 = 71;
                    if (i15 < 71) {
                        return FanSpeedEnum.SIXTY_SEVEN;
                    }
                } else {
                    i3 = 71;
                }
                if (i3 <= i15) {
                    i4 = 75;
                    if (i15 < 75) {
                        return FanSpeedEnum.SEVENTY_ONE;
                    }
                } else {
                    i4 = 75;
                }
                if (i4 <= i15) {
                    i5 = 79;
                    if (i15 < 79) {
                        return FanSpeedEnum.SEVENTY_FIVE;
                    }
                } else {
                    i5 = 79;
                }
                if (i5 <= i15) {
                    i6 = 83;
                    if (i15 < 83) {
                        return FanSpeedEnum.SEVENTY_NINE;
                    }
                } else {
                    i6 = 83;
                }
                if (i6 <= i15 && i15 < 87) {
                    return FanSpeedEnum.EIGHTY_THREE;
                }
                if (87 <= i15) {
                    i7 = 91;
                    if (i15 < 91) {
                        return FanSpeedEnum.EIGHTY_SEVEN;
                    }
                } else {
                    i7 = 91;
                }
                if (i7 > i15 || i15 >= 101) {
                    return FanSpeedEnum.OFF;
                }
                return FanSpeedEnum.NINETY_ONE;
            } else if (3 <= i15 && i15 <= Integer.MAX_VALUE) {
                return FanSpeedEnum.THREE;
            } else {
                if (i15 == 2) {
                    return FanSpeedEnum.TWO;
                }
                if (i15 == 1) {
                    return FanSpeedEnum.ONE;
                }
                return FanSpeedEnum.OFF;
            }
        }

        public final boolean isUsingFourGearConfig(Device device) {
            return (device instanceof DeviceBlue40) || (device instanceof DeviceHumidifier20) || (device instanceof DeviceHumidifier);
        }

        public final boolean isUsingTypicallyConfig(Device device) {
            return (device instanceof DeviceDehumidifier) || (device instanceof DeviceMiniRestful) || (device instanceof DevicePet20);
        }

        public final FanSpeedEnum fanSpeedEnumFromProgressG4(int i) {
            if (i == -1) {
                return FanSpeedEnum.SNAP_STEP;
            }
            if (i == 0) {
                return FanSpeedEnum.OFF;
            }
            switch (i) {
                case 11:
                    return FanSpeedEnum.ELEVEN;
                case 15:
                    return FanSpeedEnum.FIFTEEN;
                case 19:
                    return FanSpeedEnum.NINETEEN;
                case 23:
                    return FanSpeedEnum.TWENTY_THREE;
                case 27:
                    return FanSpeedEnum.TWENTY_SEVEN;
                case 31:
                    return FanSpeedEnum.THIRTY_ONE;
                case 35:
                    return FanSpeedEnum.THIRTY_FIVE;
                case 39:
                    return FanSpeedEnum.THIRTY_NINE;
                case 43:
                    return FanSpeedEnum.FORTY_THREE;
                case 47:
                    return FanSpeedEnum.FORTY_SEVEN;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG:
                    return FanSpeedEnum.FIFTY_ONE;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE:
                    return FanSpeedEnum.FIFTY_FIVE;
                case 59:
                    return FanSpeedEnum.FIFTY_NINE;
                case 63:
                    return FanSpeedEnum.SIXTY_THREE;
                case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL:
                    return FanSpeedEnum.SIXTY_SEVEN;
                case BCrypt.Version.DEFAULT_MAX_PW_LENGTH_BYTE:
                    return FanSpeedEnum.SEVENTY_ONE;
                case 75:
                    return FanSpeedEnum.SEVENTY_FIVE;
                case 79:
                    return FanSpeedEnum.SEVENTY_NINE;
                case 83:
                    return FanSpeedEnum.EIGHTY_THREE;
                case 87:
                    return FanSpeedEnum.EIGHTY_SEVEN;
                case EtaUtils.FAN_KEY_MAX /*91*/:
                    return FanSpeedEnum.NINETY_ONE;
                default:
                    return FanSpeedEnum.OFF;
            }
        }

        public final FanSpeedEnum fanSpeedEnumFromProgressBluePremium(int i) {
            if (i == -1) {
                return FanSpeedEnum.SNAP_STEP;
            }
            if (i == 0) {
                return FanSpeedEnum.OFF;
            }
            switch (i) {
                case 11:
                    return FanSpeedEnum.ELEVEN;
                case 15:
                    return FanSpeedEnum.FIFTEEN;
                case 19:
                    return FanSpeedEnum.NINETEEN;
                case 23:
                    return FanSpeedEnum.TWENTY_THREE;
                case 27:
                    return FanSpeedEnum.TWENTY_SEVEN;
                case 31:
                    return FanSpeedEnum.THIRTY_ONE;
                case 35:
                    return FanSpeedEnum.THIRTY_FIVE;
                case 37:
                    return FanSpeedEnum.THIRTY_SEVEN;
                case 39:
                    return FanSpeedEnum.THIRTY_NINE;
                case 43:
                    return FanSpeedEnum.FORTY_THREE;
                case 47:
                    return FanSpeedEnum.FORTY_SEVEN;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG:
                    return FanSpeedEnum.FIFTY_ONE;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE:
                    return FanSpeedEnum.FIFTY_FIVE;
                case 59:
                    return FanSpeedEnum.FIFTY_NINE;
                case 64:
                    return FanSpeedEnum.SIXTY_FOUR;
                case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL:
                    return FanSpeedEnum.SIXTY_SEVEN;
                case BCrypt.Version.DEFAULT_MAX_PW_LENGTH_BYTE:
                    return FanSpeedEnum.SEVENTY_ONE;
                case 75:
                    return FanSpeedEnum.SEVENTY_FIVE;
                case 79:
                    return FanSpeedEnum.SEVENTY_NINE;
                case 83:
                    return FanSpeedEnum.EIGHTY_THREE;
                case 87:
                    return FanSpeedEnum.EIGHTY_SEVEN;
                case EtaUtils.FAN_KEY_MAX /*91*/:
                    return FanSpeedEnum.NINETY_ONE;
                default:
                    return FanSpeedEnum.OFF;
            }
        }

        public final FanSpeedEnum fanSpeedEnumFromProgressLegacy(int i) {
            if (i == -1) {
                return FanSpeedEnum.SNAP_STEP;
            }
            if (i == 0) {
                return FanSpeedEnum.OFF;
            }
            if (i == 1) {
                return FanSpeedEnum.ONE;
            }
            if (i == 2) {
                return FanSpeedEnum.TWO;
            }
            if (i != 3) {
                return FanSpeedEnum.OFF;
            }
            return FanSpeedEnum.THREE;
        }

        public final FanSpeedEnum fanSpeedEnumFromProgressIcp(int i) {
            if (i == -1) {
                return FanSpeedEnum.SNAP_STEP;
            }
            if (i == 1) {
                return FanSpeedEnum.ONE;
            }
            if (i == 2) {
                return FanSpeedEnum.TWO;
            }
            if (i != 3) {
                return FanSpeedEnum.ONE;
            }
            return FanSpeedEnum.THREE;
        }

        public final FanSpeedEnum fromStep(int i, Device device) {
            if (isUsingTypicallyConfig(device)) {
                if (i == 0) {
                    return FanSpeedEnum.OFF;
                }
                if (i == 1) {
                    return FanSpeedEnum.ELEVEN;
                }
                if (i == 2) {
                    return FanSpeedEnum.FIFTY_ONE;
                }
                if (i != 3) {
                    return FanSpeedEnum.OFF;
                }
                return FanSpeedEnum.NINETY_ONE;
            } else if (i == 0) {
                return FanSpeedEnum.OFF;
            } else {
                if (i == 1) {
                    return FanSpeedEnum.ELEVEN;
                }
                if (i == 2) {
                    return FanSpeedEnum.THIRTY_SEVEN;
                }
                if (i == 3) {
                    return FanSpeedEnum.SIXTY_FOUR;
                }
                if (i != 4) {
                    return FanSpeedEnum.OFF;
                }
                return FanSpeedEnum.NINETY_ONE;
            }
        }
    }

    public final int toServerValue(HasFanSpeed hasFanSpeed) {
        HasFanSpeed hasFanSpeed2 = hasFanSpeed;
        Intrinsics.checkNotNullParameter(hasFanSpeed2, "device");
        Companion companion = Companion;
        Device device = hasFanSpeed2;
        if (companion.isUsingTypicallyConfig(device)) {
            int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
            if (i == 1) {
                return 0;
            }
            if (i == 2) {
                return 11;
            }
            if (i != 3) {
                return i != 4 ? 0 : 91;
            }
            return 51;
        } else if (companion.isUsingFourGearConfig(device)) {
            int i2 = WhenMappings.$EnumSwitchMapping$0[ordinal()];
            if (i2 == 1) {
                return 0;
            }
            if (i2 == 2) {
                return 11;
            }
            if (i2 == 4) {
                return 91;
            }
            if (i2 == 5) {
                return 37;
            }
            if (i2 != 6) {
                return 0;
            }
            return 64;
        } else if (hasFanSpeed2.getHasGear4()) {
            switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
                case 1:
                    return 0;
                case 2:
                    return 11;
                case 3:
                    return 51;
                case 4:
                    return 91;
                case 5:
                    return 37;
                case 6:
                    return 64;
                case 7:
                    return 15;
                case 8:
                    return 19;
                case 9:
                    return 23;
                case 10:
                    return 27;
                case 11:
                    return 31;
                case 12:
                    return 35;
                case 13:
                    return 39;
                case 14:
                    return 43;
                case 15:
                    return 47;
                case 16:
                    return 55;
                case 17:
                    return 59;
                case 18:
                    return 67;
                case 19:
                    return 71;
                case 20:
                    return 75;
                case 21:
                    return 79;
                case 22:
                    return 83;
                case 23:
                    return 87;
                default:
                    return 0;
            }
        } else if (DeviceKt.isG4orB4orNB(device)) {
            switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
                case 1:
                    return 0;
                case 2:
                    return 11;
                case 3:
                    return 51;
                case 4:
                    return 91;
                case 5:
                    return 37;
                case 6:
                    return 64;
                case 7:
                    return 15;
                case 8:
                    return 19;
                case 9:
                    return 23;
                case 10:
                    return 27;
                case 11:
                    return 31;
                case 12:
                    return 35;
                case 13:
                    return 39;
                case 14:
                    return 43;
                case 15:
                    return 47;
                case 16:
                    return 55;
                case 17:
                    return 59;
                case 18:
                    return 67;
                case 19:
                    return 71;
                case 20:
                    return 75;
                case 21:
                    return 79;
                case 22:
                    return 83;
                case 23:
                    return 87;
                case 24:
                    return 63;
                default:
                    return 0;
            }
        } else {
            int i3 = WhenMappings.$EnumSwitchMapping$0[ordinal()];
            if (i3 == 1) {
                return 0;
            }
            switch (i3) {
                case 25:
                    return 1;
                case 26:
                    return 2;
                case 27:
                    return 3;
                default:
                    return 0;
            }
        }
    }

    public final int toStep(Device device) {
        if (Companion.isUsingTypicallyConfig(device)) {
            if (compareTo(ELEVEN) < 0) {
                return 0;
            }
            if (compareTo(FIFTY_ONE) < 0) {
                return 1;
            }
            return compareTo(NINETY_ONE) < 0 ? 2 : 3;
        } else if (compareTo(ELEVEN) < 0) {
            return 0;
        } else {
            if (compareTo(THIRTY_SEVEN) < 0) {
                return 1;
            }
            if (compareTo(SIXTY_FOUR) < 0) {
                return 2;
            }
            if (compareTo(NINETY_ONE) < 0) {
                return 3;
            }
            HasFanSpeed hasFanSpeed = device instanceof HasFanSpeed ? (HasFanSpeed) device : null;
            if (hasFanSpeed == null || !hasFanSpeed.getHasGear4()) {
                return 3;
            }
            return 4;
        }
    }
}
