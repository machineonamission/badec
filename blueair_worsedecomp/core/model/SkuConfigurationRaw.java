package com.blueair.core.model;

import com.amplitude.api.Constants;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0001\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0003\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\u0003\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\u0003\u0012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\r0\u0003\u0012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000f0\u0003\u0012\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00110\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0003J\u0015\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0003HÆ\u0003J\u0015\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\u0003HÆ\u0003J\u0015\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\u0003HÆ\u0003J\u0015\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\r0\u0003HÆ\u0003J\u0015\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000f0\u0003HÆ\u0003J\u001b\u0010\"\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00110\u0003HÆ\u0003J©\u0001\u0010#\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u00032\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\u00032\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\u00032\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\r0\u00032\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000f0\u00032\u001a\b\u0002\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00110\u0003HÆ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020(HÖ\u0001J\t\u0010)\u001a\u00020\u0004HÖ\u0001R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u001d\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u001d\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\r0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u001d\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000f0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R#\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00110\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015¨\u0006*"}, d2 = {"Lcom/blueair/core/model/SkuConfigurationRaw;", "", "s3_links", "", "", "Lcom/blueair/core/model/AwsLinkConfig;", "user_manual", "Lcom/blueair/core/model/I18nConfig;", "filter_info", "Lcom/blueair/core/model/FilterInfoRaw;", "filter_config", "Lcom/blueair/core/model/FilterConfigRaw;", "device_model", "Lcom/blueair/core/model/DeviceModelRaw;", "device_config", "Lcom/blueair/core/model/DeviceConfigRaw;", "device_sku_mapping", "", "<init>", "(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)V", "getS3_links", "()Ljava/util/Map;", "getUser_manual", "getFilter_info", "getFilter_config", "getDevice_model", "getDevice_config", "getDevice_sku_mapping", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: SkuConfiguration.kt */
public final class SkuConfigurationRaw {
    private final Map<String, DeviceConfigRaw> device_config;
    private final Map<String, DeviceModelRaw> device_model;
    private final Map<String, List<String>> device_sku_mapping;
    private final Map<String, FilterConfigRaw> filter_config;
    private final Map<String, FilterInfoRaw> filter_info;
    private final Map<String, AwsLinkConfig> s3_links;
    private final Map<String, I18nConfig> user_manual;

    public static /* synthetic */ SkuConfigurationRaw copy$default(SkuConfigurationRaw skuConfigurationRaw, Map<String, AwsLinkConfig> map, Map<String, I18nConfig> map2, Map<String, FilterInfoRaw> map3, Map<String, FilterConfigRaw> map4, Map<String, DeviceModelRaw> map5, Map<String, DeviceConfigRaw> map6, Map<String, List<String>> map7, int i, Object obj) {
        if ((i & 1) != 0) {
            map = skuConfigurationRaw.s3_links;
        }
        if ((i & 2) != 0) {
            map2 = skuConfigurationRaw.user_manual;
        }
        if ((i & 4) != 0) {
            map3 = skuConfigurationRaw.filter_info;
        }
        if ((i & 8) != 0) {
            map4 = skuConfigurationRaw.filter_config;
        }
        if ((i & 16) != 0) {
            map5 = skuConfigurationRaw.device_model;
        }
        if ((i & 32) != 0) {
            map6 = skuConfigurationRaw.device_config;
        }
        if ((i & 64) != 0) {
            map7 = skuConfigurationRaw.device_sku_mapping;
        }
        Map<String, DeviceConfigRaw> map8 = map6;
        Map<String, List<String>> map9 = map7;
        Map<String, FilterConfigRaw> map10 = map4;
        Map<String, DeviceModelRaw> map11 = map5;
        return skuConfigurationRaw.copy(map, map2, map3, map10, map11, map8, map9);
    }

    public final Map<String, AwsLinkConfig> component1() {
        return this.s3_links;
    }

    public final Map<String, I18nConfig> component2() {
        return this.user_manual;
    }

    public final Map<String, FilterInfoRaw> component3() {
        return this.filter_info;
    }

    public final Map<String, FilterConfigRaw> component4() {
        return this.filter_config;
    }

    public final Map<String, DeviceModelRaw> component5() {
        return this.device_model;
    }

    public final Map<String, DeviceConfigRaw> component6() {
        return this.device_config;
    }

    public final Map<String, List<String>> component7() {
        return this.device_sku_mapping;
    }

    public final SkuConfigurationRaw copy(Map<String, AwsLinkConfig> map, Map<String, I18nConfig> map2, Map<String, FilterInfoRaw> map3, Map<String, FilterConfigRaw> map4, Map<String, DeviceModelRaw> map5, Map<String, DeviceConfigRaw> map6, Map<String, ? extends List<String>> map7) {
        Intrinsics.checkNotNullParameter(map, "s3_links");
        Intrinsics.checkNotNullParameter(map2, "user_manual");
        Intrinsics.checkNotNullParameter(map3, "filter_info");
        Intrinsics.checkNotNullParameter(map4, "filter_config");
        Intrinsics.checkNotNullParameter(map5, Constants.AMP_TRACKING_OPTION_DEVICE_MODEL);
        Intrinsics.checkNotNullParameter(map6, "device_config");
        Map<String, ? extends List<String>> map8 = map7;
        Intrinsics.checkNotNullParameter(map8, "device_sku_mapping");
        return new SkuConfigurationRaw(map, map2, map3, map4, map5, map6, map8);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SkuConfigurationRaw)) {
            return false;
        }
        SkuConfigurationRaw skuConfigurationRaw = (SkuConfigurationRaw) obj;
        return Intrinsics.areEqual((Object) this.s3_links, (Object) skuConfigurationRaw.s3_links) && Intrinsics.areEqual((Object) this.user_manual, (Object) skuConfigurationRaw.user_manual) && Intrinsics.areEqual((Object) this.filter_info, (Object) skuConfigurationRaw.filter_info) && Intrinsics.areEqual((Object) this.filter_config, (Object) skuConfigurationRaw.filter_config) && Intrinsics.areEqual((Object) this.device_model, (Object) skuConfigurationRaw.device_model) && Intrinsics.areEqual((Object) this.device_config, (Object) skuConfigurationRaw.device_config) && Intrinsics.areEqual((Object) this.device_sku_mapping, (Object) skuConfigurationRaw.device_sku_mapping);
    }

    public int hashCode() {
        return (((((((((((this.s3_links.hashCode() * 31) + this.user_manual.hashCode()) * 31) + this.filter_info.hashCode()) * 31) + this.filter_config.hashCode()) * 31) + this.device_model.hashCode()) * 31) + this.device_config.hashCode()) * 31) + this.device_sku_mapping.hashCode();
    }

    public String toString() {
        return "SkuConfigurationRaw(s3_links=" + this.s3_links + ", user_manual=" + this.user_manual + ", filter_info=" + this.filter_info + ", filter_config=" + this.filter_config + ", device_model=" + this.device_model + ", device_config=" + this.device_config + ", device_sku_mapping=" + this.device_sku_mapping + ')';
    }

    public SkuConfigurationRaw(Map<String, AwsLinkConfig> map, Map<String, I18nConfig> map2, Map<String, FilterInfoRaw> map3, Map<String, FilterConfigRaw> map4, Map<String, DeviceModelRaw> map5, Map<String, DeviceConfigRaw> map6, Map<String, ? extends List<String>> map7) {
        Intrinsics.checkNotNullParameter(map, "s3_links");
        Intrinsics.checkNotNullParameter(map2, "user_manual");
        Intrinsics.checkNotNullParameter(map3, "filter_info");
        Intrinsics.checkNotNullParameter(map4, "filter_config");
        Intrinsics.checkNotNullParameter(map5, Constants.AMP_TRACKING_OPTION_DEVICE_MODEL);
        Intrinsics.checkNotNullParameter(map6, "device_config");
        Intrinsics.checkNotNullParameter(map7, "device_sku_mapping");
        this.s3_links = map;
        this.user_manual = map2;
        this.filter_info = map3;
        this.filter_config = map4;
        this.device_model = map5;
        this.device_config = map6;
        this.device_sku_mapping = map7;
    }

    public final Map<String, AwsLinkConfig> getS3_links() {
        return this.s3_links;
    }

    public final Map<String, I18nConfig> getUser_manual() {
        return this.user_manual;
    }

    public final Map<String, FilterInfoRaw> getFilter_info() {
        return this.filter_info;
    }

    public final Map<String, FilterConfigRaw> getFilter_config() {
        return this.filter_config;
    }

    public final Map<String, DeviceModelRaw> getDevice_model() {
        return this.device_model;
    }

    public final Map<String, DeviceConfigRaw> getDevice_config() {
        return this.device_config;
    }

    public final Map<String, List<String>> getDevice_sku_mapping() {
        return this.device_sku_mapping;
    }
}
