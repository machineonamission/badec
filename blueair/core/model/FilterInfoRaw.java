package com.blueair.core.model;

import com.blueair.core.R;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0018\u001a\u00020\u00192\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u001bJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\nHÆ\u0003JW\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020(HÖ\u0001J\t\u0010)\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016¨\u0006*"},
   d2 = {"Lcom/blueair/core/model/FilterInfoRaw;", "", "type", "", "name", "Lcom/blueair/core/model/I18nConfig;", "image", "summary", "manual", "linkSubscribe", "Lcom/blueair/core/model/IpConfig;", "linkPurchase", "<init>", "(Ljava/lang/String;Lcom/blueair/core/model/I18nConfig;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/blueair/core/model/IpConfig;Lcom/blueair/core/model/IpConfig;)V", "getType", "()Ljava/lang/String;", "getName", "()Lcom/blueair/core/model/I18nConfig;", "getImage", "getSummary", "getManual", "getLinkSubscribe", "()Lcom/blueair/core/model/IpConfig;", "getLinkPurchase", "toFilterInfo", "Lcom/blueair/core/model/FilterInfo;", "manualMap", "", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class FilterInfoRaw {
   private final String image;
   private final IpConfig linkPurchase;
   private final IpConfig linkSubscribe;
   private final String manual;
   private final I18nConfig name;
   private final String summary;
   private final String type;

   public FilterInfoRaw(String var1, I18nConfig var2, String var3, String var4, String var5, IpConfig var6, IpConfig var7) {
      Intrinsics.checkNotNullParameter(var1, "type");
      Intrinsics.checkNotNullParameter(var2, "name");
      Intrinsics.checkNotNullParameter(var3, "image");
      super();
      this.type = var1;
      this.name = var2;
      this.image = var3;
      this.summary = var4;
      this.manual = var5;
      this.linkSubscribe = var6;
      this.linkPurchase = var7;
   }

   // $FF: synthetic method
   public static FilterInfoRaw copy$default(FilterInfoRaw var0, String var1, I18nConfig var2, String var3, String var4, String var5, IpConfig var6, IpConfig var7, int var8, Object var9) {
      if ((var8 & 1) != 0) {
         var1 = var0.type;
      }

      if ((var8 & 2) != 0) {
         var2 = var0.name;
      }

      if ((var8 & 4) != 0) {
         var3 = var0.image;
      }

      if ((var8 & 8) != 0) {
         var4 = var0.summary;
      }

      if ((var8 & 16) != 0) {
         var5 = var0.manual;
      }

      if ((var8 & 32) != 0) {
         var6 = var0.linkSubscribe;
      }

      if ((var8 & 64) != 0) {
         var7 = var0.linkPurchase;
      }

      return var0.copy(var1, var2, var3, var4, var5, var6, var7);
   }

   public final String component1() {
      return this.type;
   }

   public final I18nConfig component2() {
      return this.name;
   }

   public final String component3() {
      return this.image;
   }

   public final String component4() {
      return this.summary;
   }

   public final String component5() {
      return this.manual;
   }

   public final IpConfig component6() {
      return this.linkSubscribe;
   }

   public final IpConfig component7() {
      return this.linkPurchase;
   }

   public final FilterInfoRaw copy(String var1, I18nConfig var2, String var3, String var4, String var5, IpConfig var6, IpConfig var7) {
      Intrinsics.checkNotNullParameter(var1, "type");
      Intrinsics.checkNotNullParameter(var2, "name");
      Intrinsics.checkNotNullParameter(var3, "image");
      return new FilterInfoRaw(var1, var2, var3, var4, var5, var6, var7);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof FilterInfoRaw)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.type, var1.type)) {
            return false;
         } else if (!Intrinsics.areEqual(this.name, var1.name)) {
            return false;
         } else if (!Intrinsics.areEqual(this.image, var1.image)) {
            return false;
         } else if (!Intrinsics.areEqual(this.summary, var1.summary)) {
            return false;
         } else if (!Intrinsics.areEqual(this.manual, var1.manual)) {
            return false;
         } else if (!Intrinsics.areEqual(this.linkSubscribe, var1.linkSubscribe)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.linkPurchase, var1.linkPurchase);
         }
      }
   }

   public final String getImage() {
      return this.image;
   }

   public final IpConfig getLinkPurchase() {
      return this.linkPurchase;
   }

   public final IpConfig getLinkSubscribe() {
      return this.linkSubscribe;
   }

   public final String getManual() {
      return this.manual;
   }

   public final I18nConfig getName() {
      return this.name;
   }

   public final String getSummary() {
      return this.summary;
   }

   public final String getType() {
      return this.type;
   }

   public int hashCode() {
      int var7 = this.type.hashCode();
      int var6 = this.name.hashCode();
      int var5 = this.image.hashCode();
      String var8 = this.summary;
      int var4 = 0;
      int var1;
      if (var8 == null) {
         var1 = 0;
      } else {
         var1 = var8.hashCode();
      }

      var8 = this.manual;
      int var2;
      if (var8 == null) {
         var2 = 0;
      } else {
         var2 = var8.hashCode();
      }

      IpConfig var10 = this.linkSubscribe;
      int var3;
      if (var10 == null) {
         var3 = 0;
      } else {
         var3 = var10.hashCode();
      }

      var10 = this.linkPurchase;
      if (var10 != null) {
         var4 = var10.hashCode();
      }

      return (((((var7 * 31 + var6) * 31 + var5) * 31 + var1) * 31 + var2) * 31 + var3) * 31 + var4;
   }

   public final FilterInfo toFilterInfo(Map var1) {
      DeviceFilterType var10;
      label251: {
         Intrinsics.checkNotNullParameter(var1, "manualMap");
         String var5 = this.type;
         int var2 = var5.hashCode();
         if (var2 != -1274492040) {
            if (var2 != -564570936) {
               if (var2 == 3649210 && var5.equals("wick")) {
                  var10 = DeviceFilterType.WICK;
                  break label251;
               }
            } else if (var5.equals("refresher")) {
               var10 = DeviceFilterType.REFRESHER;
               break label251;
            }
         } else if (var5.equals("filter")) {
            var10 = DeviceFilterType.FILTER;
            break label251;
         }

         var10 = DeviceFilterType.FILTER;
      }

      byte var4;
      int var9;
      label242: {
         label241: {
            String var6 = this.image;
            var9 = var6.hashCode();
            var4 = 0;
            switch (var9) {
               case -2052521520:
                  if (var6.equals("311i+_particle")) {
                     var9 = R.drawable.filter_311ip_particle;
                     break label242;
                  }
                  break;
               case -2052016370:
                  if (var6.equals("g4p_smart_8400")) {
                     var9 = R.drawable.filter_g4p_smart_8400;
                     break label242;
                  }
                  break;
               case -2052014448:
                  if (var6.equals("g4p_smart_8600")) {
                     var9 = R.drawable.filter_g4p_smart_8600;
                     break label242;
                  }
                  break;
               case -2052012526:
                  if (var6.equals("g4p_smart_8800")) {
                     var9 = R.drawable.filter_g4p_smart_8800;
                     break label242;
                  }
                  break;
               case -1680800543:
                  if (var6.equals("r_hum2.0")) {
                     break label241;
                  }
                  break;
               case -1556683460:
                  if (var6.equals("w_hum2.0")) {
                     var9 = R.drawable.wick_humidifier20;
                     break label242;
                  }
                  break;
               case -1437622836:
                  if (var6.equals("311i+_allergen")) {
                     var9 = R.drawable.filter_311ip_allergen;
                     break label242;
                  }
                  break;
               case -1385985962:
                  if (var6.equals("blue40")) {
                     var9 = R.drawable.filter_blue40;
                     break label242;
                  }
                  break;
               case -1165530794:
                  if (var6.equals("w_cmb2in120_pro")) {
                     var9 = R.drawable.wick_cmb2in120_pro;
                     break label242;
                  }
                  break;
               case -798769918:
                  if (var6.equals("w_2in1")) {
                     var9 = R.drawable.wick_combo2in1;
                     break label242;
                  }
                  break;
               case -666354575:
                  if (var6.equals("511i_particle")) {
                     var9 = R.drawable.filter_511i_particle;
                     break label242;
                  }
                  break;
               case -473765892:
                  if (var6.equals("blue40_sp3i")) {
                     var9 = R.drawable.filter_blue40_sp3i;
                     break label242;
                  }
                  break;
               case -372951568:
                  if (var6.equals("411i_particle")) {
                     var9 = R.drawable.filter_411i_particle;
                     break label242;
                  }
                  break;
               case -211613083:
                  if (var6.equals("311i+_smoke")) {
                     var9 = R.drawable.filter_311ip_smoke;
                     break label242;
                  }
                  break;
               case -138706560:
                  if (var6.equals("classic_pro")) {
                     var9 = R.drawable.filter_nc;
                     break label242;
                  }
                  break;
               case -113355247:
                  if (var6.equals("r_cmb2in120_pro")) {
                     break label241;
                  }
                  break;
               case -79548561:
                  if (var6.equals("311i_particle")) {
                     var9 = R.drawable.filter_311i_particle;
                     break label242;
                  }
                  break;
               case -51455891:
                  if (var6.equals("511i_allergen")) {
                     var9 = R.drawable.filter_511i_allergen;
                     break label242;
                  }
                  break;
               case 3090:
                  if (var6.equals("b4")) {
                     var9 = R.drawable.filter_b4;
                     break label242;
                  }
                  break;
               case 1593914:
                  if (var6.equals("2in1")) {
                     var9 = R.drawable.filter_combo2in1;
                     break label242;
                  }
                  break;
               case 1623705:
                  if (var6.equals("3in1")) {
                     var9 = R.drawable.filter_combo3in1;
                     break label242;
                  }
                  break;
               case 3028929:
                  if (var6.equals("d26i")) {
                     var9 = R.drawable.filter_dehumidifier;
                     break label242;
                  }
                  break;
               case 104160705:
                  if (var6.equals("mrest")) {
                     var9 = R.drawable.filter_mrest;
                     break label242;
                  }
                  break;
               case 106556317:
                  if (var6.equals("pet20")) {
                     var9 = R.drawable.filter_pet20;
                     break label242;
                  }
                  break;
               case 213854446:
                  if (var6.equals("211i_particle")) {
                     var9 = R.drawable.filter_211i_particle;
                     break label242;
                  }
                  break;
               case 241947116:
                  if (var6.equals("411i_allergen")) {
                     var9 = R.drawable.filter_411i_allergen;
                     break label242;
                  }
                  break;
               case 535350123:
                  if (var6.equals("311i_allergen")) {
                     var9 = R.drawable.filter_311i_allergen;
                     break label242;
                  }
                  break;
               case 607859486:
                  if (var6.equals("cmb2in120_pro")) {
                     var9 = R.drawable.filter_cmb2in120_pro;
                     break label242;
                  }
                  break;
               case 621684004:
                  if (var6.equals("g4_smart_ultra")) {
                     var9 = R.drawable.filter_g4_smart_ultra;
                     break label242;
                  }
                  break;
               case 689277381:
                  if (var6.equals("g4_smart_ultra_fp")) {
                     var9 = R.drawable.filter_g4_smart_ultra_fp;
                     break label242;
                  }
                  break;
               case 828753130:
                  if (var6.equals("211i_allergen")) {
                     var9 = R.drawable.filter_211i_allergen;
                     break label242;
                  }
                  break;
               case 830061412:
                  if (var6.equals("511i_smoke")) {
                     var9 = R.drawable.filter_511i_smoke;
                     break label242;
                  }
                  break;
               case 855707575:
                  if (var6.equals("g4_smart")) {
                     var9 = R.drawable.filter_g4_smart;
                     break label242;
                  }
                  break;
               case 1026574917:
                  if (var6.equals("411i_smoke")) {
                     var9 = R.drawable.filter_411i_smoke;
                     break label242;
                  }
                  break;
               case 1223088422:
                  if (var6.equals("311i_smoke")) {
                     var9 = R.drawable.filter_311i_smoke;
                     break label242;
                  }
                  break;
               case 1419601927:
                  if (var6.equals("211i_smoke")) {
                     var9 = R.drawable.filter_211i_smoke;
                     break label242;
                  }
                  break;
               case 1937343526:
                  if (var6.equals("w_humidifier")) {
                     var9 = R.drawable.wick_humidifier;
                     break label242;
                  }
            }

            var9 = 0;
            break label242;
         }

         var9 = R.drawable.refresher_default;
      }

      SkuConfigurationKt.access$logNotFoundError("filter_info.image", this.image, var9);
      String var11 = this.summary;
      int var3 = var4;
      if (var11 != null) {
         label196: {
            switch (var11.hashCode()) {
               case -1901876243:
                  if (!var11.equals("g4p_smart")) {
                     var3 = var4;
                  } else {
                     var3 = R.string.filter_summary_g4p_smart;
                  }
                  break label196;
               case -1779796760:
                  if (!var11.equals("pet20_particle")) {
                     var3 = var4;
                  } else {
                     var3 = R.string.filter_summary_pet;
                  }
                  break label196;
               case -1680800543:
                  if (!var11.equals("r_hum2.0")) {
                     var3 = var4;
                     break label196;
                  }
                  break;
               case -1626910882:
                  if (!var11.equals("humidifier")) {
                     var3 = var4;
                  } else {
                     var3 = R.string.wick_summary_replacement_h35i;
                  }
                  break label196;
               case -1556683460:
                  if (!var11.equals("w_hum2.0")) {
                     var3 = var4;
                  } else {
                     var3 = R.string.wick_summary_replacement_h38i;
                  }
                  break label196;
               case -1165530794:
                  if (!var11.equals("w_cmb2in120_pro")) {
                     var3 = var4;
                  } else {
                     var3 = R.string.wick_summary_2in120_pro;
                  }
                  break label196;
               case -113355247:
                  if (!var11.equals("r_cmb2in120_pro")) {
                     var3 = var4;
                     break label196;
                  }
                  break;
               case 308228426:
                  if (!var11.equals("blue_smoke")) {
                     var3 = var4;
                  } else {
                     var3 = R.string.filter_summary_blue_smoke;
                  }
                  break label196;
               case 318969935:
                  if (!var11.equals("blue40_particle")) {
                     var3 = var4;
                  } else {
                     var3 = R.string.filter_summary_blue40;
                  }
                  break label196;
               case 607859486:
                  if (!var11.equals("cmb2in120_pro")) {
                     var3 = var4;
                  } else {
                     var3 = R.string.filter_summary_2in120_pro;
                  }
                  break label196;
               case 716884769:
                  if (!var11.equals("b4_combo")) {
                     var3 = var4;
                  } else {
                     var3 = R.string.filter_summary_b4_combo;
                  }
                  break label196;
               case 1188771019:
                  if (!var11.equals("blue_particle")) {
                     var3 = var4;
                  } else {
                     var3 = R.string.filter_summary_blue_particle;
                  }
                  break label196;
               case 1351889958:
                  if (!var11.equals("dehumidifier_particle")) {
                     var3 = var4;
                  } else {
                     var3 = R.string.filter_summary_dehumidifier;
                  }
                  break label196;
               case 1803669703:
                  if (!var11.equals("blue_allergen")) {
                     var3 = var4;
                  } else {
                     var3 = R.string.filter_summary_blue_allergen;
                  }
                  break label196;
               case 1937343526:
                  if (!var11.equals("w_humidifier")) {
                     var3 = var4;
                  } else {
                     var3 = R.string.wick_summary_replacement_h35i;
                  }
                  break label196;
               default:
                  var3 = var4;
                  break label196;
            }

            var3 = R.string.refresher_summary_default;
         }
      }

      SkuConfigurationKt.access$logNotFoundError("filter_info.summary", this.summary, var3);
      I18nConfig var7 = (I18nConfig)var1.get(this.manual);
      SkuConfigurationKt.access$logNotFoundError("filter_info.manual", this.manual, var7);
      return new FilterInfo(var10, this.name, var9, var3, var7, this.linkSubscribe, this.linkPurchase);
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("FilterInfoRaw(type=");
      var1.append(this.type);
      var1.append(", name=");
      var1.append(this.name);
      var1.append(", image=");
      var1.append(this.image);
      var1.append(", summary=");
      var1.append(this.summary);
      var1.append(", manual=");
      var1.append(this.manual);
      var1.append(", linkSubscribe=");
      var1.append(this.linkSubscribe);
      var1.append(", linkPurchase=");
      var1.append(this.linkPurchase);
      var1.append(')');
      return var1.toString();
   }
}
