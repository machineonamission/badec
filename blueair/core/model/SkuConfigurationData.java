package com.blueair.core.model;

import com.squareup.moshi.Json;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Bg\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006\u0012\u0014\b\u0001\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b\u0012\b\b\u0001\u0010\u000b\u001a\u00020\f\u0012\u001a\b\u0001\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u000e0\b\u0012\b\b\u0001\u0010\u000f\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u0006\u0010\u001f\u001a\u00020 J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0006HÆ\u0003J\u0015\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bHÆ\u0003J\t\u0010%\u001a\u00020\fHÆ\u0003J\u001b\u0010&\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u000e0\bHÆ\u0003J\t\u0010'\u001a\u00020\u0010HÆ\u0003Jm\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\u0014\b\u0003\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\b\b\u0003\u0010\u000b\u001a\u00020\f2\u001a\b\u0003\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u000e0\b2\b\b\u0003\u0010\u000f\u001a\u00020\u0010HÆ\u0001J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020\u0003HÖ\u0001J\t\u0010-\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR#\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u000e0\b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006."},
   d2 = {"Lcom/blueair/core/model/SkuConfigurationData;", "", "version", "", "series", "chinaPrivacy", "Lcom/blueair/core/model/ChinaPrivacy;", "webLinks", "", "", "Lcom/blueair/core/model/IpConfig;", "mcuFirmwareVersions", "Lcom/blueair/core/model/McuFirmwareVersions;", "specialHardwareSets", "", "skuConfigurations", "Lcom/blueair/core/model/SkuConfigurationRaw;", "<init>", "(IILcom/blueair/core/model/ChinaPrivacy;Ljava/util/Map;Lcom/blueair/core/model/McuFirmwareVersions;Ljava/util/Map;Lcom/blueair/core/model/SkuConfigurationRaw;)V", "getVersion", "()I", "getSeries", "getChinaPrivacy", "()Lcom/blueair/core/model/ChinaPrivacy;", "getWebLinks", "()Ljava/util/Map;", "getMcuFirmwareVersions", "()Lcom/blueair/core/model/McuFirmwareVersions;", "getSpecialHardwareSets", "getSkuConfigurations", "()Lcom/blueair/core/model/SkuConfigurationRaw;", "getSkuConfiguration", "Lcom/blueair/core/model/SkuConfiguration;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class SkuConfigurationData {
   private final ChinaPrivacy chinaPrivacy;
   private final McuFirmwareVersions mcuFirmwareVersions;
   private final int series;
   private final SkuConfigurationRaw skuConfigurations;
   private final Map specialHardwareSets;
   private final int version;
   private final Map webLinks;

   public SkuConfigurationData(int var1, int var2, @Json(name = "china_privacy") ChinaPrivacy var3, @Json(name = "web_links") Map var4, @Json(name = "mcu_firmware_versions") McuFirmwareVersions var5, @Json(name = "special_hardware_sets") Map var6, @Json(name = "sku_configurations") SkuConfigurationRaw var7) {
      Intrinsics.checkNotNullParameter(var3, "chinaPrivacy");
      Intrinsics.checkNotNullParameter(var4, "webLinks");
      Intrinsics.checkNotNullParameter(var5, "mcuFirmwareVersions");
      Intrinsics.checkNotNullParameter(var6, "specialHardwareSets");
      Intrinsics.checkNotNullParameter(var7, "skuConfigurations");
      super();
      this.version = var1;
      this.series = var2;
      this.chinaPrivacy = var3;
      this.webLinks = var4;
      this.mcuFirmwareVersions = var5;
      this.specialHardwareSets = var6;
      this.skuConfigurations = var7;
   }

   // $FF: synthetic method
   public static SkuConfigurationData copy$default(SkuConfigurationData var0, int var1, int var2, ChinaPrivacy var3, Map var4, McuFirmwareVersions var5, Map var6, SkuConfigurationRaw var7, int var8, Object var9) {
      if ((var8 & 1) != 0) {
         var1 = var0.version;
      }

      if ((var8 & 2) != 0) {
         var2 = var0.series;
      }

      if ((var8 & 4) != 0) {
         var3 = var0.chinaPrivacy;
      }

      if ((var8 & 8) != 0) {
         var4 = var0.webLinks;
      }

      if ((var8 & 16) != 0) {
         var5 = var0.mcuFirmwareVersions;
      }

      if ((var8 & 32) != 0) {
         var6 = var0.specialHardwareSets;
      }

      if ((var8 & 64) != 0) {
         var7 = var0.skuConfigurations;
      }

      return var0.copy(var1, var2, var3, var4, var5, var6, var7);
   }

   public final int component1() {
      return this.version;
   }

   public final int component2() {
      return this.series;
   }

   public final ChinaPrivacy component3() {
      return this.chinaPrivacy;
   }

   public final Map component4() {
      return this.webLinks;
   }

   public final McuFirmwareVersions component5() {
      return this.mcuFirmwareVersions;
   }

   public final Map component6() {
      return this.specialHardwareSets;
   }

   public final SkuConfigurationRaw component7() {
      return this.skuConfigurations;
   }

   public final SkuConfigurationData copy(int var1, int var2, @Json(name = "china_privacy") ChinaPrivacy var3, @Json(name = "web_links") Map var4, @Json(name = "mcu_firmware_versions") McuFirmwareVersions var5, @Json(name = "special_hardware_sets") Map var6, @Json(name = "sku_configurations") SkuConfigurationRaw var7) {
      Intrinsics.checkNotNullParameter(var3, "chinaPrivacy");
      Intrinsics.checkNotNullParameter(var4, "webLinks");
      Intrinsics.checkNotNullParameter(var5, "mcuFirmwareVersions");
      Intrinsics.checkNotNullParameter(var6, "specialHardwareSets");
      Intrinsics.checkNotNullParameter(var7, "skuConfigurations");
      return new SkuConfigurationData(var1, var2, var3, var4, var5, var6, var7);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof SkuConfigurationData)) {
         return false;
      } else {
         var1 = var1;
         if (this.version != var1.version) {
            return false;
         } else if (this.series != var1.series) {
            return false;
         } else if (!Intrinsics.areEqual(this.chinaPrivacy, var1.chinaPrivacy)) {
            return false;
         } else if (!Intrinsics.areEqual(this.webLinks, var1.webLinks)) {
            return false;
         } else if (!Intrinsics.areEqual(this.mcuFirmwareVersions, var1.mcuFirmwareVersions)) {
            return false;
         } else if (!Intrinsics.areEqual(this.specialHardwareSets, var1.specialHardwareSets)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.skuConfigurations, var1.skuConfigurations);
         }
      }
   }

   public final ChinaPrivacy getChinaPrivacy() {
      return this.chinaPrivacy;
   }

   public final McuFirmwareVersions getMcuFirmwareVersions() {
      return this.mcuFirmwareVersions;
   }

   public final int getSeries() {
      return this.series;
   }

   public final SkuConfiguration getSkuConfiguration() {
      Map var4 = this.skuConfigurations.getS3_links();
      Map var2 = this.skuConfigurations.getUser_manual();
      Map var1 = this.skuConfigurations.getFilter_info();
      Map var3 = (Map)(new LinkedHashMap(MapsKt.mapCapacity(var1.size())));

      for(Map.Entry var7 : (Iterable)var1.entrySet()) {
         var3.put(var7.getKey(), ((FilterInfoRaw)var7.getValue()).toFilterInfo(var2));
      }

      Map var18 = this.skuConfigurations.getFilter_config();
      var1 = (Map)(new LinkedHashMap(MapsKt.mapCapacity(var18.size())));

      for(Map.Entry var19 : (Iterable)var18.entrySet()) {
         var1.put(var19.getKey(), ((FilterConfigRaw)var19.getValue()).toFilterConfig(var4, var3));
      }

      var4 = this.skuConfigurations.getDevice_model();
      var3 = (Map)(new LinkedHashMap(MapsKt.mapCapacity(var4.size())));

      for(Map.Entry var20 : (Iterable)var4.entrySet()) {
         var3.put(var20.getKey(), ((DeviceModelRaw)var20.getValue()).toDeviceModel(var2));
      }

      var4 = this.skuConfigurations.getDevice_config();
      var2 = (Map)(new LinkedHashMap(MapsKt.mapCapacity(var4.size())));

      for(Map.Entry var16 : (Iterable)var4.entrySet()) {
         var2.put(var16.getKey(), ((DeviceConfigRaw)var16.getValue()).toDeviceConfig(var1, var3));
      }

      var3 = (Map)(new LinkedHashMap());

      for(Map.Entry var22 : this.skuConfigurations.getDevice_sku_mapping().entrySet()) {
         DeviceConfig var17 = (DeviceConfig)var2.get(var22.getKey());
         SkuConfigurationKt.access$logNotFoundError("device_sku_mapping", (String)var22.getKey(), var17);
         if (var17 != null) {
            Iterator var23 = ((Iterable)var22.getValue()).iterator();

            while(var23.hasNext()) {
               var3.put((String)var23.next(), var17);
            }
         }
      }

      return new SkuConfiguration(this.version, this.series, var3, this.skuConfigurations.getSpecial_sku_sets());
   }

   public final SkuConfigurationRaw getSkuConfigurations() {
      return this.skuConfigurations;
   }

   public final Map getSpecialHardwareSets() {
      return this.specialHardwareSets;
   }

   public final int getVersion() {
      return this.version;
   }

   public final Map getWebLinks() {
      return this.webLinks;
   }

   public int hashCode() {
      return (((((this.version * 31 + this.series) * 31 + this.chinaPrivacy.hashCode()) * 31 + this.webLinks.hashCode()) * 31 + this.mcuFirmwareVersions.hashCode()) * 31 + this.specialHardwareSets.hashCode()) * 31 + this.skuConfigurations.hashCode();
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("SkuConfigurationData(version=");
      var1.append(this.version);
      var1.append(", series=");
      var1.append(this.series);
      var1.append(", chinaPrivacy=");
      var1.append(this.chinaPrivacy);
      var1.append(", webLinks=");
      var1.append(this.webLinks);
      var1.append(", mcuFirmwareVersions=");
      var1.append(this.mcuFirmwareVersions);
      var1.append(", specialHardwareSets=");
      var1.append(this.specialHardwareSets);
      var1.append(", skuConfigurations=");
      var1.append(this.skuConfigurations);
      var1.append(')');
      return var1.toString();
   }
}
