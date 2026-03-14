package com.blueair.core.model;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(
   d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ.\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00120\u00112\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00140\u0011J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006 "},
   d2 = {"Lcom/blueair/core/model/DeviceConfigRaw;", "", "model", "", "image", "filter", "market", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getModel", "()Ljava/lang/String;", "getImage", "getFilter", "getMarket", "toDeviceConfig", "Lcom/blueair/core/model/DeviceConfig;", "filterConfigMap", "", "Lcom/blueair/core/model/FilterConfig;", "modelMap", "Lcom/blueair/core/model/DeviceModel;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceConfigRaw {
   private final String filter;
   private final String image;
   private final String market;
   private final String model;

   public DeviceConfigRaw(String var1, String var2, String var3, String var4) {
      this.model = var1;
      this.image = var2;
      this.filter = var3;
      this.market = var4;
   }

   // $FF: synthetic method
   public static DeviceConfigRaw copy$default(DeviceConfigRaw var0, String var1, String var2, String var3, String var4, int var5, Object var6) {
      if ((var5 & 1) != 0) {
         var1 = var0.model;
      }

      if ((var5 & 2) != 0) {
         var2 = var0.image;
      }

      if ((var5 & 4) != 0) {
         var3 = var0.filter;
      }

      if ((var5 & 8) != 0) {
         var4 = var0.market;
      }

      return var0.copy(var1, var2, var3, var4);
   }

   public final String component1() {
      return this.model;
   }

   public final String component2() {
      return this.image;
   }

   public final String component3() {
      return this.filter;
   }

   public final String component4() {
      return this.market;
   }

   public final DeviceConfigRaw copy(String var1, String var2, String var3, String var4) {
      return new DeviceConfigRaw(var1, var2, var3, var4);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof DeviceConfigRaw)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.model, var1.model)) {
            return false;
         } else if (!Intrinsics.areEqual(this.image, var1.image)) {
            return false;
         } else if (!Intrinsics.areEqual(this.filter, var1.filter)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.market, var1.market);
         }
      }
   }

   public final String getFilter() {
      return this.filter;
   }

   public final String getImage() {
      return this.image;
   }

   public final String getMarket() {
      return this.market;
   }

   public final String getModel() {
      return this.model;
   }

   public int hashCode() {
      String var5 = this.model;
      int var4 = 0;
      int var1;
      if (var5 == null) {
         var1 = 0;
      } else {
         var1 = var5.hashCode();
      }

      var5 = this.image;
      int var2;
      if (var5 == null) {
         var2 = 0;
      } else {
         var2 = var5.hashCode();
      }

      var5 = this.filter;
      int var3;
      if (var5 == null) {
         var3 = 0;
      } else {
         var3 = var5.hashCode();
      }

      var5 = this.market;
      if (var5 != null) {
         var4 = var5.hashCode();
      }

      return ((var1 * 31 + var2) * 31 + var3) * 31 + var4;
   }

   public final DeviceConfig toDeviceConfig(Map var1, Map var2) {
      DeviceModel var5;
      Object var7;
      label203: {
         Intrinsics.checkNotNullParameter(var1, "filterConfigMap");
         Intrinsics.checkNotNullParameter(var2, "modelMap");
         var5 = (DeviceModel)var2.get(this.model);
         SkuConfigurationKt.access$logNotFoundError("device_config.model", this.model, var5);
         var7 = null;
         if (var11 != null) {
            switch (var11) {
               case "nb_311i+":
                  var12 = DeviceImage.BLUE_311I_PLUS;
                  break label203;
               case "pet20_green":
                  var12 = DeviceImage.PET20_GREEN;
                  break label203;
               case "blue40_light":
                  var12 = DeviceImage.BLUE40_LIGHT;
                  break label203;
               case "mrest_dark":
                  var12 = DeviceImage.MREST_DARK;
                  break label203;
               case "combo2in1":
                  var12 = DeviceImage.COMBO2IN1;
                  break label203;
               case "combo3in1":
                  var12 = DeviceImage.COMBO3IN1;
                  break label203;
               case "humidifier20_yellow":
                  var12 = DeviceImage.HUMIDIFIER20;
                  break label203;
               case "blue40_sp1i_dark":
                  var12 = DeviceImage.BLUE40_DARK;
                  break label203;
               case "humidifier":
                  var12 = DeviceImage.HUMIDIFIER;
                  break label203;
               case "combo3in1_large":
                  var12 = DeviceImage.COMBO3IN1_LARGE;
                  break label203;
               case "sense+":
                  var12 = DeviceImage.SENSE;
                  break label203;
               case "blue40_dark":
                  var12 = DeviceImage.BLUE40_DARK;
                  break label203;
               case "mrest_green":
                  var12 = DeviceImage.MREST_GREEN;
                  break label203;
               case "humidifier20":
                  var12 = DeviceImage.HUMIDIFIER20;
                  break label203;
               case "b4":
                  var12 = DeviceImage.B4;
                  break label203;
               case "g4":
                  var12 = DeviceImage.G4;
                  break label203;
               case "g4+":
                  var12 = DeviceImage.G4_PLUS;
                  break label203;
               case "icp":
                  var12 = DeviceImage.ICP;
                  break label203;
               case "blue40_sp3i_light":
                  var12 = DeviceImage.BLUE40_MEDIUM_LIGHT;
                  break label203;
               case "aware":
                  var12 = DeviceImage.AWARE;
                  break label203;
               case "mrest":
                  var12 = DeviceImage.MREST;
                  break label203;
               case "blue40_sp3i_dark":
                  var12 = DeviceImage.BLUE40_MEDIUM_DARK;
                  break label203;
               case "humidifier20_blue":
                  var12 = DeviceImage.HUMIDIFIER20_BLUE;
                  break label203;
               case "mrest_purple":
                  var12 = DeviceImage.MREST_GREEN;
                  break label203;
               case "humidifier20_large":
                  var12 = DeviceImage.HUMIDIFIER20_LARGE;
                  break label203;
               case "pet20_sand":
                  var12 = DeviceImage.PET20_SAND;
                  break label203;
               case "cmb2in120":
                  var12 = DeviceImage.CMB2IN120;
                  break label203;
               case "combo3in1_dark":
                  var12 = DeviceImage.COMBO3IN1_DARK;
                  break label203;
               case "fantable":
                  var12 = DeviceImage.FANTABLE;
                  break label203;
               case "classic":
                  var12 = DeviceImage.CLASSIC;
                  break label203;
               case "blue40_sp1i_light":
                  var12 = DeviceImage.BLUE40_LIGHT;
                  break label203;
               case "pet20_green_us":
                  var12 = DeviceImage.PET20_GREEN_US;
                  break label203;
               case "dehumidifier":
                  var12 = DeviceImage.DEHUMIDIFIER;
                  break label203;
               case "humidifier20_large_blue":
                  var12 = DeviceImage.HUMIDIFIER20_LARGE_BLUE;
                  break label203;
               case "nb_211i":
                  var12 = DeviceImage.BLUE_211I;
                  break label203;
               case "nb_311i":
                  var12 = DeviceImage.BLUE_311I;
                  break label203;
               case "nb_411i":
                  var12 = DeviceImage.BLUE_411I;
                  break label203;
               case "nb_511i":
                  var12 = DeviceImage.BLUE_511I;
                  break label203;
               case "nc_cp7i":
                  var12 = DeviceImage.CLASSIC_CP7I;
                  break label203;
               case "nc_cp9i":
                  var12 = DeviceImage.CLASSIC_CP9I;
                  break label203;
            }
         }

         var12 = null;
      }

      SkuConfigurationKt.access$logNotFoundError("device_config.image", this.image, var12);
      FilterConfig var8 = (FilterConfig)var1.get(this.filter);
      SkuConfigurationKt.access$logNotFoundError("device_config.filter", this.filter, var8);
      DeviceType var10;
      if (var5 != null) {
         var10 = var5.getType();
      } else {
         var10 = null;
      }

      I18nConfig var3;
      if (var5 != null) {
         var3 = var5.getModelName();
      } else {
         var3 = null;
      }

      I18nConfig var4;
      if (var5 != null) {
         var4 = var5.getFamilyName();
      } else {
         var4 = null;
      }

      I18nConfig var13;
      if (var5 != null) {
         var13 = var5.getUserManual();
      } else {
         var13 = null;
      }

      String var9 = this.market;
      Set var6 = (Set)var7;
      if (var9 != null) {
         var9 = var9.toLowerCase(Locale.ROOT);
         Intrinsics.checkNotNullExpressionValue(var9, "toLowerCase(...)");
         var6 = (Set)var7;
         if (var9 != null) {
            List var15 = StringsKt.split$default((CharSequence)var9, new char[]{'/'}, false, 0, 6, (Object)null);
            var6 = (Set)var7;
            if (var15 != null) {
               var6 = CollectionsKt.toSet((Iterable)var15);
            }
         }
      }

      return new DeviceConfig(var10, var3, var4, var12, var8, var13, var6);
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("DeviceConfigRaw(model=");
      var1.append(this.model);
      var1.append(", image=");
      var1.append(this.image);
      var1.append(", filter=");
      var1.append(this.filter);
      var1.append(", market=");
      var1.append(this.market);
      var1.append(')');
      return var1.toString();
   }
}
