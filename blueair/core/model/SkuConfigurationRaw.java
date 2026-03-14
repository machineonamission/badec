package com.blueair.core.model;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B³\u0001\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0003\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\u0003\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\u0003\u0012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\r0\u0003\u0012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000f0\u0003\u0012\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00110\u0003\u0012\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00110\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0003J\u0015\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0003HÆ\u0003J\u0015\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\u0003HÆ\u0003J\u0015\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\u0003HÆ\u0003J\u0015\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\r0\u0003HÆ\u0003J\u0015\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000f0\u0003HÆ\u0003J\u001b\u0010$\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00110\u0003HÆ\u0003J\u001b\u0010%\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00110\u0003HÆ\u0003JÅ\u0001\u0010&\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u00032\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\u00032\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\u00032\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\r0\u00032\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000f0\u00032\u001a\b\u0002\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00110\u00032\u001a\b\u0002\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00110\u0003HÆ\u0001J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020+HÖ\u0001J\t\u0010,\u001a\u00020\u0004HÖ\u0001R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u001d\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u001d\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\r0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u001d\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000f0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R#\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00110\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R#\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00110\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016¨\u0006-"},
   d2 = {"Lcom/blueair/core/model/SkuConfigurationRaw;", "", "s3_links", "", "", "Lcom/blueair/core/model/AwsLinkConfig;", "user_manual", "Lcom/blueair/core/model/I18nConfig;", "filter_info", "Lcom/blueair/core/model/FilterInfoRaw;", "filter_config", "Lcom/blueair/core/model/FilterConfigRaw;", "device_model", "Lcom/blueair/core/model/DeviceModelRaw;", "device_config", "Lcom/blueair/core/model/DeviceConfigRaw;", "device_sku_mapping", "", "special_sku_sets", "<init>", "(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)V", "getS3_links", "()Ljava/util/Map;", "getUser_manual", "getFilter_info", "getFilter_config", "getDevice_model", "getDevice_config", "getDevice_sku_mapping", "getSpecial_sku_sets", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toString", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class SkuConfigurationRaw {
   private final Map device_config;
   private final Map device_model;
   private final Map device_sku_mapping;
   private final Map filter_config;
   private final Map filter_info;
   private final Map s3_links;
   private final Map special_sku_sets;
   private final Map user_manual;

   public SkuConfigurationRaw(Map var1, Map var2, Map var3, Map var4, Map var5, Map var6, Map var7, Map var8) {
      Intrinsics.checkNotNullParameter(var1, "s3_links");
      Intrinsics.checkNotNullParameter(var2, "user_manual");
      Intrinsics.checkNotNullParameter(var3, "filter_info");
      Intrinsics.checkNotNullParameter(var4, "filter_config");
      Intrinsics.checkNotNullParameter(var5, "device_model");
      Intrinsics.checkNotNullParameter(var6, "device_config");
      Intrinsics.checkNotNullParameter(var7, "device_sku_mapping");
      Intrinsics.checkNotNullParameter(var8, "special_sku_sets");
      super();
      this.s3_links = var1;
      this.user_manual = var2;
      this.filter_info = var3;
      this.filter_config = var4;
      this.device_model = var5;
      this.device_config = var6;
      this.device_sku_mapping = var7;
      this.special_sku_sets = var8;
   }

   // $FF: synthetic method
   public static SkuConfigurationRaw copy$default(SkuConfigurationRaw var0, Map var1, Map var2, Map var3, Map var4, Map var5, Map var6, Map var7, Map var8, int var9, Object var10) {
      if ((var9 & 1) != 0) {
         var1 = var0.s3_links;
      }

      if ((var9 & 2) != 0) {
         var2 = var0.user_manual;
      }

      if ((var9 & 4) != 0) {
         var3 = var0.filter_info;
      }

      if ((var9 & 8) != 0) {
         var4 = var0.filter_config;
      }

      if ((var9 & 16) != 0) {
         var5 = var0.device_model;
      }

      if ((var9 & 32) != 0) {
         var6 = var0.device_config;
      }

      if ((var9 & 64) != 0) {
         var7 = var0.device_sku_mapping;
      }

      if ((var9 & 128) != 0) {
         var8 = var0.special_sku_sets;
      }

      return var0.copy(var1, var2, var3, var4, var5, var6, var7, var8);
   }

   public final Map component1() {
      return this.s3_links;
   }

   public final Map component2() {
      return this.user_manual;
   }

   public final Map component3() {
      return this.filter_info;
   }

   public final Map component4() {
      return this.filter_config;
   }

   public final Map component5() {
      return this.device_model;
   }

   public final Map component6() {
      return this.device_config;
   }

   public final Map component7() {
      return this.device_sku_mapping;
   }

   public final Map component8() {
      return this.special_sku_sets;
   }

   public final SkuConfigurationRaw copy(Map var1, Map var2, Map var3, Map var4, Map var5, Map var6, Map var7, Map var8) {
      Intrinsics.checkNotNullParameter(var1, "s3_links");
      Intrinsics.checkNotNullParameter(var2, "user_manual");
      Intrinsics.checkNotNullParameter(var3, "filter_info");
      Intrinsics.checkNotNullParameter(var4, "filter_config");
      Intrinsics.checkNotNullParameter(var5, "device_model");
      Intrinsics.checkNotNullParameter(var6, "device_config");
      Intrinsics.checkNotNullParameter(var7, "device_sku_mapping");
      Intrinsics.checkNotNullParameter(var8, "special_sku_sets");
      return new SkuConfigurationRaw(var1, var2, var3, var4, var5, var6, var7, var8);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof SkuConfigurationRaw)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.s3_links, var1.s3_links)) {
            return false;
         } else if (!Intrinsics.areEqual(this.user_manual, var1.user_manual)) {
            return false;
         } else if (!Intrinsics.areEqual(this.filter_info, var1.filter_info)) {
            return false;
         } else if (!Intrinsics.areEqual(this.filter_config, var1.filter_config)) {
            return false;
         } else if (!Intrinsics.areEqual(this.device_model, var1.device_model)) {
            return false;
         } else if (!Intrinsics.areEqual(this.device_config, var1.device_config)) {
            return false;
         } else if (!Intrinsics.areEqual(this.device_sku_mapping, var1.device_sku_mapping)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.special_sku_sets, var1.special_sku_sets);
         }
      }
   }

   public final Map getDevice_config() {
      return this.device_config;
   }

   public final Map getDevice_model() {
      return this.device_model;
   }

   public final Map getDevice_sku_mapping() {
      return this.device_sku_mapping;
   }

   public final Map getFilter_config() {
      return this.filter_config;
   }

   public final Map getFilter_info() {
      return this.filter_info;
   }

   public final Map getS3_links() {
      return this.s3_links;
   }

   public final Map getSpecial_sku_sets() {
      return this.special_sku_sets;
   }

   public final Map getUser_manual() {
      return this.user_manual;
   }

   public int hashCode() {
      return ((((((this.s3_links.hashCode() * 31 + this.user_manual.hashCode()) * 31 + this.filter_info.hashCode()) * 31 + this.filter_config.hashCode()) * 31 + this.device_model.hashCode()) * 31 + this.device_config.hashCode()) * 31 + this.device_sku_mapping.hashCode()) * 31 + this.special_sku_sets.hashCode();
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("SkuConfigurationRaw(s3_links=");
      var1.append(this.s3_links);
      var1.append(", user_manual=");
      var1.append(this.user_manual);
      var1.append(", filter_info=");
      var1.append(this.filter_info);
      var1.append(", filter_config=");
      var1.append(this.filter_config);
      var1.append(", device_model=");
      var1.append(this.device_model);
      var1.append(", device_config=");
      var1.append(this.device_config);
      var1.append(", device_sku_mapping=");
      var1.append(this.device_sku_mapping);
      var1.append(", special_sku_sets=");
      var1.append(this.special_sku_sets);
      var1.append(')');
      return var1.toString();
   }
}
