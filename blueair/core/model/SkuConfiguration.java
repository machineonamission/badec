package com.blueair.core.model;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006\u0012\u001a\b\u0002\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\n0\u0006¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\u0013\u001a\u0004\u0018\u00010\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0007J\u001a\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u0010\u0018\u001a\u00020\u00162\b\u0010\u0014\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\u0019\u001a\u00020\u00162\b\u0010\u0014\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\u001a\u001a\u00020\u00162\b\u0010\u0014\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\u001b\u001a\u00020\u00162\b\u0010\u0014\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\u001c\u001a\u00020\u00162\b\u0010\u0014\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\u001d\u001a\u00020\u00162\b\u0010\u0014\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\u001e\u001a\u00020\u00162\b\u0010\u0014\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\u001f\u001a\u00020\u00162\b\u0010\u0014\u001a\u0004\u0018\u00010\u0007J\u0010\u0010 \u001a\u00020\u00162\b\u0010\u0014\u001a\u0004\u0018\u00010\u0007J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\u0015\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006HÆ\u0003J\u001b\u0010$\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\n0\u0006HÆ\u0003JO\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u001a\b\u0002\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\n0\u0006HÆ\u0001J\u0013\u0010&\u001a\u00020\u00162\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020\u0003HÖ\u0001J\t\u0010)\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R#\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\n0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011¨\u0006*"},
   d2 = {"Lcom/blueair/core/model/SkuConfiguration;", "", "version", "", "series", "map", "", "", "Lcom/blueair/core/model/DeviceConfig;", "specialSkuSets", "", "<init>", "(IILjava/util/Map;Ljava/util/Map;)V", "getVersion", "()I", "getSeries", "getMap", "()Ljava/util/Map;", "getSpecialSkuSets", "getDeviceConfig", "sku", "skuSetContains", "", "set", "skuSupportAntiFake", "skuIsBluePremium", "skuIsG4Plus", "skuSupportHcho", "skuSupportGermShieldPlus", "skuSupportGermShieldNightMode", "skuSupportDisinfection", "skuFilterLifeIs9To12", "skuIsBlueNewOnboarding", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class SkuConfiguration {
   private final Map map;
   private final int series;
   private final Map specialSkuSets;
   private final int version;

   public SkuConfiguration() {
      this(0, 0, (Map)null, (Map)null, 15, (DefaultConstructorMarker)null);
   }

   public SkuConfiguration(int var1, int var2, Map var3, Map var4) {
      Intrinsics.checkNotNullParameter(var3, "map");
      Intrinsics.checkNotNullParameter(var4, "specialSkuSets");
      super();
      this.version = var1;
      this.series = var2;
      this.map = var3;
      this.specialSkuSets = var4;
   }

   // $FF: synthetic method
   public SkuConfiguration(int var1, int var2, Map var3, Map var4, int var5, DefaultConstructorMarker var6) {
      if ((var5 & 1) != 0) {
         var1 = 0;
      }

      if ((var5 & 2) != 0) {
         var2 = 0;
      }

      if ((var5 & 4) != 0) {
         var3 = MapsKt.emptyMap();
      }

      if ((var5 & 8) != 0) {
         var4 = MapsKt.emptyMap();
      }

      this(var1, var2, var3, var4);
   }

   // $FF: synthetic method
   public static SkuConfiguration copy$default(SkuConfiguration var0, int var1, int var2, Map var3, Map var4, int var5, Object var6) {
      if ((var5 & 1) != 0) {
         var1 = var0.version;
      }

      if ((var5 & 2) != 0) {
         var2 = var0.series;
      }

      if ((var5 & 4) != 0) {
         var3 = var0.map;
      }

      if ((var5 & 8) != 0) {
         var4 = var0.specialSkuSets;
      }

      return var0.copy(var1, var2, var3, var4);
   }

   private final boolean skuSetContains(String var1, String var2) {
      List var3 = (List)this.specialSkuSets.get(var1);
      if (var3 != null) {
         return var2 == null ? false : var3.contains(var2);
      } else {
         return false;
      }
   }

   public final int component1() {
      return this.version;
   }

   public final int component2() {
      return this.series;
   }

   public final Map component3() {
      return this.map;
   }

   public final Map component4() {
      return this.specialSkuSets;
   }

   public final SkuConfiguration copy(int var1, int var2, Map var3, Map var4) {
      Intrinsics.checkNotNullParameter(var3, "map");
      Intrinsics.checkNotNullParameter(var4, "specialSkuSets");
      return new SkuConfiguration(var1, var2, var3, var4);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof SkuConfiguration)) {
         return false;
      } else {
         var1 = var1;
         if (this.version != var1.version) {
            return false;
         } else if (this.series != var1.series) {
            return false;
         } else if (!Intrinsics.areEqual(this.map, var1.map)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.specialSkuSets, var1.specialSkuSets);
         }
      }
   }

   public final DeviceConfig getDeviceConfig(String var1) {
      Map var2 = this.map;
      return var1 == null ? null : (DeviceConfig)var2.get(var1);
   }

   public final Map getMap() {
      return this.map;
   }

   public final int getSeries() {
      return this.series;
   }

   public final Map getSpecialSkuSets() {
      return this.specialSkuSets;
   }

   public final int getVersion() {
      return this.version;
   }

   public int hashCode() {
      return ((this.version * 31 + this.series) * 31 + this.map.hashCode()) * 31 + this.specialSkuSets.hashCode();
   }

   public final boolean skuFilterLifeIs9To12(String var1) {
      return this.skuSetContains("filter_life_9-12", var1);
   }

   public final boolean skuIsBlueNewOnboarding(String var1) {
      return this.skuSetContains("nb_new_onboarding", var1);
   }

   public final boolean skuIsBluePremium(String var1) {
      return this.skuSetContains("blue_premium", var1);
   }

   public final boolean skuIsG4Plus(String var1) {
      return this.skuSetContains("g4+", var1);
   }

   public final boolean skuSupportAntiFake(String var1) {
      return this.skuSetContains("antifake_supported", var1);
   }

   public final boolean skuSupportDisinfection(String var1) {
      return this.skuSetContains("g4+_disinfection_supported", var1);
   }

   public final boolean skuSupportGermShieldNightMode(String var1) {
      return this.skuSetContains("g4+_gsnm_supported", var1);
   }

   public final boolean skuSupportGermShieldPlus(String var1) {
      return this.skuSetContains("g4+_germshield+_supported", var1);
   }

   public final boolean skuSupportHcho(String var1) {
      return this.skuSetContains("g4+_hcho_supported", var1);
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("SkuConfiguration(version=");
      var1.append(this.version);
      var1.append(", series=");
      var1.append(this.series);
      var1.append(", map=");
      var1.append(this.map);
      var1.append(", specialSkuSets=");
      var1.append(this.specialSkuSets);
      var1.append(')');
      return var1.toString();
   }
}
