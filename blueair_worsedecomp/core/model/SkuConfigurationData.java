package com.blueair.core.model;

import com.squareup.moshi.Json;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0001\u0010\u0007\u001a\u00020\b\u0012\b\b\u0001\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010\u0016\u001a\u00020\u0017J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001b\u001a\u00020\bHÆ\u0003J\t\u0010\u001c\u001a\u00020\nHÆ\u0003J;\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\b2\b\b\u0003\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\t\u0010\"\u001a\u00020#HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006$"}, d2 = {"Lcom/blueair/core/model/SkuConfigurationData;", "", "version", "", "series", "chinaPrivacy", "Lcom/blueair/core/model/ChinaPrivacy;", "mcuFirmwareVersions", "Lcom/blueair/core/model/McuFirmwareVersions;", "skuConfigurations", "Lcom/blueair/core/model/SkuConfigurationRaw;", "<init>", "(IILcom/blueair/core/model/ChinaPrivacy;Lcom/blueair/core/model/McuFirmwareVersions;Lcom/blueair/core/model/SkuConfigurationRaw;)V", "getVersion", "()I", "getSeries", "getChinaPrivacy", "()Lcom/blueair/core/model/ChinaPrivacy;", "getMcuFirmwareVersions", "()Lcom/blueair/core/model/McuFirmwareVersions;", "getSkuConfigurations", "()Lcom/blueair/core/model/SkuConfigurationRaw;", "getSkuConfiguration", "Lcom/blueair/core/model/SkuConfiguration;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: SkuConfiguration.kt */
public final class SkuConfigurationData {
    private final ChinaPrivacy chinaPrivacy;
    private final McuFirmwareVersions mcuFirmwareVersions;
    private final int series;
    private final SkuConfigurationRaw skuConfigurations;
    private final int version;

    public static /* synthetic */ SkuConfigurationData copy$default(SkuConfigurationData skuConfigurationData, int i, int i2, ChinaPrivacy chinaPrivacy2, McuFirmwareVersions mcuFirmwareVersions2, SkuConfigurationRaw skuConfigurationRaw, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = skuConfigurationData.version;
        }
        if ((i3 & 2) != 0) {
            i2 = skuConfigurationData.series;
        }
        if ((i3 & 4) != 0) {
            chinaPrivacy2 = skuConfigurationData.chinaPrivacy;
        }
        if ((i3 & 8) != 0) {
            mcuFirmwareVersions2 = skuConfigurationData.mcuFirmwareVersions;
        }
        if ((i3 & 16) != 0) {
            skuConfigurationRaw = skuConfigurationData.skuConfigurations;
        }
        McuFirmwareVersions mcuFirmwareVersions3 = mcuFirmwareVersions2;
        SkuConfigurationRaw skuConfigurationRaw2 = skuConfigurationRaw;
        return skuConfigurationData.copy(i, i2, chinaPrivacy2, mcuFirmwareVersions3, skuConfigurationRaw2);
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

    public final McuFirmwareVersions component4() {
        return this.mcuFirmwareVersions;
    }

    public final SkuConfigurationRaw component5() {
        return this.skuConfigurations;
    }

    public final SkuConfigurationData copy(int i, int i2, @Json(name = "china_privacy") ChinaPrivacy chinaPrivacy2, @Json(name = "mcu_firmware_versions") McuFirmwareVersions mcuFirmwareVersions2, @Json(name = "sku_configurations") SkuConfigurationRaw skuConfigurationRaw) {
        Intrinsics.checkNotNullParameter(chinaPrivacy2, "chinaPrivacy");
        Intrinsics.checkNotNullParameter(mcuFirmwareVersions2, "mcuFirmwareVersions");
        Intrinsics.checkNotNullParameter(skuConfigurationRaw, "skuConfigurations");
        return new SkuConfigurationData(i, i2, chinaPrivacy2, mcuFirmwareVersions2, skuConfigurationRaw);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SkuConfigurationData)) {
            return false;
        }
        SkuConfigurationData skuConfigurationData = (SkuConfigurationData) obj;
        return this.version == skuConfigurationData.version && this.series == skuConfigurationData.series && Intrinsics.areEqual((Object) this.chinaPrivacy, (Object) skuConfigurationData.chinaPrivacy) && Intrinsics.areEqual((Object) this.mcuFirmwareVersions, (Object) skuConfigurationData.mcuFirmwareVersions) && Intrinsics.areEqual((Object) this.skuConfigurations, (Object) skuConfigurationData.skuConfigurations);
    }

    public int hashCode() {
        return (((((((this.version * 31) + this.series) * 31) + this.chinaPrivacy.hashCode()) * 31) + this.mcuFirmwareVersions.hashCode()) * 31) + this.skuConfigurations.hashCode();
    }

    public String toString() {
        return "SkuConfigurationData(version=" + this.version + ", series=" + this.series + ", chinaPrivacy=" + this.chinaPrivacy + ", mcuFirmwareVersions=" + this.mcuFirmwareVersions + ", skuConfigurations=" + this.skuConfigurations + ')';
    }

    public SkuConfigurationData(int i, int i2, @Json(name = "china_privacy") ChinaPrivacy chinaPrivacy2, @Json(name = "mcu_firmware_versions") McuFirmwareVersions mcuFirmwareVersions2, @Json(name = "sku_configurations") SkuConfigurationRaw skuConfigurationRaw) {
        Intrinsics.checkNotNullParameter(chinaPrivacy2, "chinaPrivacy");
        Intrinsics.checkNotNullParameter(mcuFirmwareVersions2, "mcuFirmwareVersions");
        Intrinsics.checkNotNullParameter(skuConfigurationRaw, "skuConfigurations");
        this.version = i;
        this.series = i2;
        this.chinaPrivacy = chinaPrivacy2;
        this.mcuFirmwareVersions = mcuFirmwareVersions2;
        this.skuConfigurations = skuConfigurationRaw;
    }

    public final int getVersion() {
        return this.version;
    }

    public final int getSeries() {
        return this.series;
    }

    public final ChinaPrivacy getChinaPrivacy() {
        return this.chinaPrivacy;
    }

    public final McuFirmwareVersions getMcuFirmwareVersions() {
        return this.mcuFirmwareVersions;
    }

    public final SkuConfigurationRaw getSkuConfigurations() {
        return this.skuConfigurations;
    }

    public final SkuConfiguration getSkuConfiguration() {
        Map<String, AwsLinkConfig> s3_links = this.skuConfigurations.getS3_links();
        Map<String, I18nConfig> user_manual = this.skuConfigurations.getUser_manual();
        Map<String, FilterInfoRaw> filter_info = this.skuConfigurations.getFilter_info();
        Map linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(filter_info.size()));
        for (Map.Entry entry : filter_info.entrySet()) {
            linkedHashMap.put(entry.getKey(), ((FilterInfoRaw) entry.getValue()).toFilterInfo(user_manual));
        }
        Map<String, FilterConfigRaw> filter_config = this.skuConfigurations.getFilter_config();
        Map linkedHashMap2 = new LinkedHashMap(MapsKt.mapCapacity(filter_config.size()));
        for (Map.Entry entry2 : filter_config.entrySet()) {
            linkedHashMap2.put(entry2.getKey(), ((FilterConfigRaw) entry2.getValue()).toFilterConfig(s3_links, linkedHashMap));
        }
        Map<String, DeviceModelRaw> device_model = this.skuConfigurations.getDevice_model();
        Map linkedHashMap3 = new LinkedHashMap(MapsKt.mapCapacity(device_model.size()));
        for (Map.Entry entry3 : device_model.entrySet()) {
            linkedHashMap3.put(entry3.getKey(), ((DeviceModelRaw) entry3.getValue()).toDeviceModel(user_manual));
        }
        Map<String, DeviceConfigRaw> device_config = this.skuConfigurations.getDevice_config();
        Map linkedHashMap4 = new LinkedHashMap(MapsKt.mapCapacity(device_config.size()));
        for (Map.Entry entry4 : device_config.entrySet()) {
            linkedHashMap4.put(entry4.getKey(), ((DeviceConfigRaw) entry4.getValue()).toDeviceConfig(linkedHashMap2, linkedHashMap3));
        }
        Map linkedHashMap5 = new LinkedHashMap();
        for (Map.Entry next : this.skuConfigurations.getDevice_sku_mapping().entrySet()) {
            DeviceConfig deviceConfig = (DeviceConfig) linkedHashMap4.get(next.getKey());
            if (deviceConfig != null) {
                for (String put : (Iterable) next.getValue()) {
                    linkedHashMap5.put(put, deviceConfig);
                }
            }
        }
        return new SkuConfiguration(this.version, this.series, linkedHashMap5);
    }
}
