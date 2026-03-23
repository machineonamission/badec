package com.blueair.core.model;

import com.blueair.core.R;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b,\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B5\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2¨\u00063"}, d2 = {"Lcom/blueair/core/model/DeviceImage;", "", "device", "", "bgDetails", "bgOnboarding", "btnX", "", "btnY", "<init>", "(Ljava/lang/String;IIIIFF)V", "getDevice", "()I", "getBgDetails", "getBgOnboarding", "getBtnX", "()F", "getBtnY", "SENSE", "ICP", "AWARE", "CLASSIC", "B4", "BLUE_211I", "BLUE_311I", "BLUE_311I_PLUS", "BLUE_411I", "BLUE_511I", "G4", "G4_PLUS", "CLASSIC_CP7I", "CLASSIC_CP9I", "HUMIDIFIER", "COMBO3IN1", "COMBO3IN1_DARK", "COMBO3IN1_LARGE", "COMBO2IN1", "DEHUMIDIFIER", "PET20_SAND", "PET20_GREEN", "PET20_GREEN_US", "BLUE40_LIGHT", "BLUE40_DARK", "HUMIDIFIER20", "HUMIDIFIER20_BLUE", "HUMIDIFIER20_LARGE", "HUMIDIFIER20_LARGE_BLUE", "MREST", "MREST_DARK", "MREST_GREEN", "CMB2IN120", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceImage.kt */
public enum DeviceImage {
    SENSE(R.drawable.device_image_sense, 0, 0, 0.0f, 0.0f, 24, (float) null),
    ICP(R.drawable.device_image_icp, 0, 0, 0.0f, 0.0f, 24, (float) null),
    AWARE(R.drawable.device_image_aware, 0, 0, 0.0f, 0.0f, 24, (float) null),
    CLASSIC(R.drawable.device_image_classic_480i, 0, 0, 0.0f, 0.0f, 24, (float) null),
    B4(R.drawable.device_image_b4, R.drawable.detail_header_b4, R.drawable.device_bg_b4, 0.63f, 0.165f),
    BLUE_211I(R.drawable.device_image_211i, R.drawable.detail_header_211i, R.drawable.device_bg_211i, 0.0f, 0.05f, 8, (float) null),
    BLUE_311I(R.drawable.device_image_311i, R.drawable.detail_header_311i, R.drawable.device_bg_311i, 0.0f, 0.055f, 8, (float) null),
    BLUE_311I_PLUS(R.drawable.device_image_311i_plus, R.drawable.detail_header_311i_plus, R.drawable.device_bg_311i_plus, 0.0f, 0.055f, 8, (float) null),
    BLUE_411I(R.drawable.device_image_411i, R.drawable.detail_header_411i, R.drawable.device_bg_411i, 0.0f, 0.055f, 8, (float) null),
    BLUE_511I(R.drawable.device_image_511i, R.drawable.detail_header_511i, R.drawable.device_bg_511i, 0.0f, 0.157f, 8, (float) null),
    G4(R.drawable.device_image_g4, R.drawable.detail_header_g4, R.drawable.device_bg_g4, 0.0f, 0.045f, 8, (float) null),
    G4_PLUS(R.drawable.device_image_g4p, R.drawable.detail_header_g4p, R.drawable.device_bg_g4p, 0.0f, 0.035f, 8, (float) null),
    CLASSIC_CP7I(R.drawable.device_image_classic_cp7i, R.drawable.detail_header_classic_cp7i, R.drawable.device_bg_classic_cp7i, 0.0f, 0.19f, 8, (float) null),
    CLASSIC_CP9I(R.drawable.device_image_classic_cp9i, R.drawable.detail_header_classic_cp9i, R.drawable.device_bg_classic_cp9i, 0.0f, 0.07f, 8, (float) null),
    HUMIDIFIER(R.drawable.device_image_humidifier, R.drawable.detail_header_humidifier, R.drawable.device_bg_humidifier, 0.0f, 0.18f, 8, (float) null),
    COMBO3IN1(R.drawable.device_image_combo3in1_medium, R.drawable.detail_header_combo3in1_medium, R.drawable.device_bg_combo3in1_medium, 0.0f, 0.07f, 8, (float) null),
    COMBO3IN1_DARK(R.drawable.device_image_combo3in1_dark, R.drawable.detail_header_combo3in1_dark, R.drawable.device_bg_combo3in1_dark, 0.0f, 0.03f, 8, (float) null),
    COMBO3IN1_LARGE(R.drawable.device_image_combo3in1_large, R.drawable.detail_header_combo3in1_large, R.drawable.device_bg_combo3in1_large, 0.0f, 0.035f, 8, (float) null),
    COMBO2IN1(R.drawable.device_image_combo2in1, R.drawable.detail_header_combo2in1, R.drawable.device_bg_combo2in1, 0.0f, 0.11f, 8, (float) null),
    DEHUMIDIFIER(R.drawable.device_image_dehumidifier, R.drawable.detail_header_dehumidifier, R.drawable.device_bg_dehumidifier, 0.0f, 0.06f, 8, (float) null),
    PET20_SAND(R.drawable.device_image_pet20_sand, R.drawable.detail_header_pet20_sand, R.drawable.device_bg_pet20_sand, 0.913f, 0.4f),
    PET20_GREEN(R.drawable.device_image_pet20_green, R.drawable.detail_header_pet20_green, R.drawable.device_bg_pet20_green, 0.913f, 0.38f),
    PET20_GREEN_US(R.drawable.device_image_pet20_us_green, R.drawable.detail_header_pet20_us_green, R.drawable.device_bg_pet20_us_green, 0.913f, 0.39f),
    BLUE40_LIGHT(R.drawable.device_image_blue40_light, R.drawable.detail_header_blue40_light, R.drawable.device_bg_blue40_light, 0.0f, 0.145f, 8, (float) null),
    BLUE40_DARK(R.drawable.device_image_blue40_dark, R.drawable.detail_header_blue40_dark, R.drawable.device_bg_blue40_dark, 0.0f, 0.145f, 8, (float) null),
    HUMIDIFIER20(R.drawable.device_image_humidifier20, R.drawable.detail_header_humidifier20, R.drawable.device_bg_humidifier20, 0.0f, 0.12f, 8, (float) null),
    HUMIDIFIER20_BLUE(R.drawable.device_image_humidifier20_blue, R.drawable.detail_header_humidifier20_blue, R.drawable.device_bg_humidifier20_blue, 0.0f, 0.12f, 8, (float) null),
    HUMIDIFIER20_LARGE(R.drawable.device_image_humidifier20_large, R.drawable.detail_header_humidifier20_large, R.drawable.device_bg_humidifier20_large, 0.0f, 0.09f, 8, (float) null),
    HUMIDIFIER20_LARGE_BLUE(R.drawable.device_image_humidifier20_large_blue, R.drawable.detail_header_humidifier20_large_blue, R.drawable.device_bg_humidifier20_large_blue, 0.0f, 0.09f, 8, (float) null),
    MREST(R.drawable.device_image_mrest, R.drawable.detail_header_mrest, R.drawable.device_bg_mrest, 0.0f, 0.08f, 8, (float) null),
    MREST_DARK(R.drawable.device_image_mrest_dark, R.drawable.detail_header_mrest_dark, R.drawable.device_bg_mrest_dark, 0.0f, 0.08f, 8, (float) null),
    MREST_GREEN(R.drawable.device_image_mrest_green, R.drawable.detail_header_mrest_green, R.drawable.device_bg_mrest_green, 0.0f, 0.08f, 8, (float) null),
    CMB2IN120(R.drawable.device_image_cmb2in120, R.drawable.detail_header_cmb2in120, R.drawable.device_bg_cmb2in120, 0.0f, 0.08f, 8, (float) null);
    
    private final int bgDetails;
    private final int bgOnboarding;
    private final float btnX;
    private final float btnY;
    private final int device;

    public static EnumEntries<DeviceImage> getEntries() {
        return $ENTRIES;
    }

    private DeviceImage(int i, int i2, int i3, float f, float f2) {
        this.device = i;
        this.bgDetails = i2;
        this.bgOnboarding = i3;
        this.btnX = f;
        this.btnY = f2;
    }

    public final int getDevice() {
        return this.device;
    }

    public final int getBgDetails() {
        return this.bgDetails;
    }

    public final int getBgOnboarding() {
        return this.bgOnboarding;
    }

    public final float getBtnX() {
        return this.btnX;
    }

    public final float getBtnY() {
        return this.btnY;
    }

    static {
        DeviceImage[] $values;
        $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
    }
}
