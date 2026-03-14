package com.blueair.core.model;

import com.blueair.core.R;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(
   d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b0\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B?\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3j\u0002\b4j\u0002\b5j\u0002\b6j\u0002\b7¨\u00068"},
   d2 = {"Lcom/blueair/core/model/DeviceImage;", "", "device", "", "bgDetails", "bgOnboarding", "bgDetailsNight", "btnX", "", "btnY", "<init>", "(Ljava/lang/String;IIIIIFF)V", "getDevice", "()I", "getBgDetails", "getBgOnboarding", "getBgDetailsNight", "getBtnX", "()F", "getBtnY", "SENSE", "ICP", "AWARE", "CLASSIC", "B4", "BLUE_211I", "BLUE_311I", "BLUE_311I_PLUS", "BLUE_411I", "BLUE_511I", "G4", "G4_PLUS", "CLASSIC_CP7I", "CLASSIC_CP9I", "HUMIDIFIER", "COMBO3IN1", "COMBO3IN1_DARK", "COMBO3IN1_LARGE", "COMBO2IN1", "DEHUMIDIFIER", "PET20_SAND", "PET20_GREEN", "PET20_GREEN_US", "BLUE40_LIGHT", "BLUE40_DARK", "BLUE40_MEDIUM_LIGHT", "BLUE40_MEDIUM_DARK", "HUMIDIFIER20", "HUMIDIFIER20_BLUE", "HUMIDIFIER20_LARGE", "HUMIDIFIER20_LARGE_BLUE", "MREST", "MREST_DARK", "MREST_GREEN", "CMB2IN120", "FANTABLE", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public enum DeviceImage {
   private static final EnumEntries $ENTRIES;
   private static final DeviceImage[] $VALUES;
   AWARE(R.drawable.device_image_aware, 0, 0, 0, 0.0F, 0.0F, 56, (DefaultConstructorMarker)null),
   B4(R.drawable.device_image_b4, R.drawable.detail_header_b4, R.drawable.device_bg_b4, 0, 0.63F, 0.165F, 8, (DefaultConstructorMarker)null),
   BLUE40_DARK(R.drawable.device_image_blue40_dark, R.drawable.detail_header_blue40_dark, R.drawable.device_bg_blue40_dark, 0, 0.0F, 0.145F, 24, (DefaultConstructorMarker)null),
   BLUE40_LIGHT(R.drawable.device_image_blue40_light, R.drawable.detail_header_blue40_light, R.drawable.device_bg_blue40_light, 0, 0.0F, 0.145F, 24, (DefaultConstructorMarker)null),
   BLUE40_MEDIUM_DARK(R.drawable.device_image_blue40_medium_dark, R.drawable.detail_header_blue40_medium_dark, R.drawable.device_bg_blue40_medium_dark, 0, 0.0F, 0.145F, 24, (DefaultConstructorMarker)null),
   BLUE40_MEDIUM_LIGHT(R.drawable.device_image_blue40_medium_light, R.drawable.detail_header_blue40_medium_light, R.drawable.device_bg_blue40_medium_light, 0, 0.0F, 0.145F, 24, (DefaultConstructorMarker)null),
   BLUE_211I(R.drawable.device_image_211i, R.drawable.detail_header_211i, R.drawable.device_bg_211i, 0, 0.0F, 0.05F, 24, (DefaultConstructorMarker)null),
   BLUE_311I(R.drawable.device_image_311i, R.drawable.detail_header_311i, R.drawable.device_bg_311i, 0, 0.0F, 0.055F, 24, (DefaultConstructorMarker)null),
   BLUE_311I_PLUS(R.drawable.device_image_311i_plus, R.drawable.detail_header_311i_plus, R.drawable.device_bg_311i_plus, 0, 0.0F, 0.055F, 24, (DefaultConstructorMarker)null),
   BLUE_411I(R.drawable.device_image_411i, R.drawable.detail_header_411i, R.drawable.device_bg_411i, 0, 0.0F, 0.055F, 24, (DefaultConstructorMarker)null),
   BLUE_511I(R.drawable.device_image_511i, R.drawable.detail_header_511i, R.drawable.device_bg_511i, 0, 0.0F, 0.157F, 24, (DefaultConstructorMarker)null),
   CLASSIC(R.drawable.device_image_classic_480i, 0, 0, 0, 0.0F, 0.0F, 56, (DefaultConstructorMarker)null),
   CLASSIC_CP7I(R.drawable.device_image_classic_cp7i, R.drawable.detail_header_classic_cp7i, R.drawable.device_bg_classic_cp7i, 0, 0.0F, 0.19F, 24, (DefaultConstructorMarker)null),
   CLASSIC_CP9I(R.drawable.device_image_classic_cp9i, R.drawable.detail_header_classic_cp9i, R.drawable.device_bg_classic_cp9i, 0, 0.0F, 0.07F, 24, (DefaultConstructorMarker)null),
   CMB2IN120(R.drawable.device_image_cmb2in120, R.drawable.detail_header_cmb2in120, R.drawable.device_bg_cmb2in120, 0, 0.0F, 0.08F, 24, (DefaultConstructorMarker)null),
   COMBO2IN1(R.drawable.device_image_combo2in1, R.drawable.detail_header_combo2in1, R.drawable.device_bg_combo2in1, 0, 0.0F, 0.11F, 24, (DefaultConstructorMarker)null),
   COMBO3IN1(R.drawable.device_image_combo3in1_medium, R.drawable.detail_header_combo3in1_medium, R.drawable.device_bg_combo3in1_medium, 0, 0.0F, 0.07F, 24, (DefaultConstructorMarker)null),
   COMBO3IN1_DARK(R.drawable.device_image_combo3in1_dark, R.drawable.detail_header_combo3in1_dark, R.drawable.device_bg_combo3in1_dark, 0, 0.0F, 0.03F, 24, (DefaultConstructorMarker)null),
   COMBO3IN1_LARGE(R.drawable.device_image_combo3in1_large, R.drawable.detail_header_combo3in1_large, R.drawable.device_bg_combo3in1_large, 0, 0.0F, 0.035F, 24, (DefaultConstructorMarker)null),
   DEHUMIDIFIER(R.drawable.device_image_dehumidifier, R.drawable.detail_header_dehumidifier, R.drawable.device_bg_dehumidifier, 0, 0.0F, 0.06F, 24, (DefaultConstructorMarker)null),
   FANTABLE(R.drawable.device_image_fantable, R.drawable.detail_header_fantable, R.drawable.device_bg_fantable, R.drawable.detail_header_fantable_night, 0.0F, 0.08F, 16, (DefaultConstructorMarker)null),
   G4(R.drawable.device_image_g4, R.drawable.detail_header_g4, R.drawable.device_bg_g4, 0, 0.0F, 0.045F, 24, (DefaultConstructorMarker)null),
   G4_PLUS(R.drawable.device_image_g4p, R.drawable.detail_header_g4p, R.drawable.device_bg_g4p, 0, 0.0F, 0.035F, 24, (DefaultConstructorMarker)null),
   HUMIDIFIER(R.drawable.device_image_humidifier, R.drawable.detail_header_humidifier, R.drawable.device_bg_humidifier, 0, 0.0F, 0.18F, 24, (DefaultConstructorMarker)null),
   HUMIDIFIER20(R.drawable.device_image_humidifier20, R.drawable.detail_header_humidifier20, R.drawable.device_bg_humidifier20, 0, 0.0F, 0.12F, 24, (DefaultConstructorMarker)null),
   HUMIDIFIER20_BLUE(R.drawable.device_image_humidifier20_blue, R.drawable.detail_header_humidifier20_blue, R.drawable.device_bg_humidifier20_blue, 0, 0.0F, 0.12F, 24, (DefaultConstructorMarker)null),
   HUMIDIFIER20_LARGE(R.drawable.device_image_humidifier20_large, R.drawable.detail_header_humidifier20_large, R.drawable.device_bg_humidifier20_large, 0, 0.0F, 0.09F, 24, (DefaultConstructorMarker)null),
   HUMIDIFIER20_LARGE_BLUE(R.drawable.device_image_humidifier20_large_blue, R.drawable.detail_header_humidifier20_large_blue, R.drawable.device_bg_humidifier20_large_blue, 0, 0.0F, 0.09F, 24, (DefaultConstructorMarker)null),
   ICP(R.drawable.device_image_icp, 0, 0, 0, 0.0F, 0.0F, 56, (DefaultConstructorMarker)null),
   MREST(R.drawable.device_image_mrest, R.drawable.detail_header_mrest, R.drawable.device_bg_mrest, 0, 0.0F, 0.08F, 24, (DefaultConstructorMarker)null),
   MREST_DARK(R.drawable.device_image_mrest_dark, R.drawable.detail_header_mrest_dark, R.drawable.device_bg_mrest_dark, 0, 0.0F, 0.08F, 24, (DefaultConstructorMarker)null),
   MREST_GREEN(R.drawable.device_image_mrest_green, R.drawable.detail_header_mrest_green, R.drawable.device_bg_mrest_green, 0, 0.0F, 0.08F, 24, (DefaultConstructorMarker)null),
   PET20_GREEN(R.drawable.device_image_pet20_green, R.drawable.detail_header_pet20_green, R.drawable.device_bg_pet20_green, 0, 0.913F, 0.38F, 8, (DefaultConstructorMarker)null),
   PET20_GREEN_US(R.drawable.device_image_pet20_us_green, R.drawable.detail_header_pet20_us_green, R.drawable.device_bg_pet20_us_green, 0, 0.913F, 0.39F, 8, (DefaultConstructorMarker)null),
   PET20_SAND(R.drawable.device_image_pet20_sand, R.drawable.detail_header_pet20_sand, R.drawable.device_bg_pet20_sand, 0, 0.913F, 0.4F, 8, (DefaultConstructorMarker)null),
   SENSE(R.drawable.device_image_sense, 0, 0, 0, 0.0F, 0.0F, 56, (DefaultConstructorMarker)null);

   private final int bgDetails;
   private final int bgDetailsNight;
   private final int bgOnboarding;
   private final float btnX;
   private final float btnY;
   private final int device;

   // $FF: synthetic method
   private static final DeviceImage[] $values() {
      return new DeviceImage[]{SENSE, ICP, AWARE, CLASSIC, B4, BLUE_211I, BLUE_311I, BLUE_311I_PLUS, BLUE_411I, BLUE_511I, G4, G4_PLUS, CLASSIC_CP7I, CLASSIC_CP9I, HUMIDIFIER, COMBO3IN1, COMBO3IN1_DARK, COMBO3IN1_LARGE, COMBO2IN1, DEHUMIDIFIER, PET20_SAND, PET20_GREEN, PET20_GREEN_US, BLUE40_LIGHT, BLUE40_DARK, BLUE40_MEDIUM_LIGHT, BLUE40_MEDIUM_DARK, HUMIDIFIER20, HUMIDIFIER20_BLUE, HUMIDIFIER20_LARGE, HUMIDIFIER20_LARGE_BLUE, MREST, MREST_DARK, MREST_GREEN, CMB2IN120, FANTABLE};
   }

   static {
      DeviceImage[] var0 = $values();
      $VALUES = var0;
      $ENTRIES = EnumEntriesKt.enumEntries(var0);
   }

   private DeviceImage(int var3, int var4, int var5, int var6, float var7, float var8) {
      this.device = var3;
      this.bgDetails = var4;
      this.bgOnboarding = var5;
      this.bgDetailsNight = var6;
      this.btnX = var7;
      this.btnY = var8;
   }

   // $FF: synthetic method
   DeviceImage(int var3, int var4, int var5, int var6, float var7, float var8, int var9, DefaultConstructorMarker var10) {
      if ((var9 & 8) != 0) {
         var6 = var4;
      }

      if ((var9 & 16) != 0) {
         var7 = 0.5F;
      }

      if ((var9 & 32) != 0) {
         var8 = 0.0F;
      }

      this(var3, var4, var5, var6, var7, var8);
   }

   public static EnumEntries getEntries() {
      return $ENTRIES;
   }

   public final int getBgDetails() {
      return this.bgDetails;
   }

   public final int getBgDetailsNight() {
      return this.bgDetailsNight;
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

   public final int getDevice() {
      return this.device;
   }
}
