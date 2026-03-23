package com.blueair.core.model;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0007J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006HÆ\u0003J3\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/blueair/core/model/SkuConfiguration;", "", "version", "", "series", "map", "", "", "Lcom/blueair/core/model/DeviceConfig;", "<init>", "(IILjava/util/Map;)V", "getVersion", "()I", "getSeries", "getMap", "()Ljava/util/Map;", "getDeviceConfig", "sku", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: SkuConfiguration.kt */
public final class SkuConfiguration {
    private final Map<String, DeviceConfig> map;
    private final int series;
    private final int version;

    public static /* synthetic */ SkuConfiguration copy$default(SkuConfiguration skuConfiguration, int i, int i2, Map<String, DeviceConfig> map2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = skuConfiguration.version;
        }
        if ((i3 & 2) != 0) {
            i2 = skuConfiguration.series;
        }
        if ((i3 & 4) != 0) {
            map2 = skuConfiguration.map;
        }
        return skuConfiguration.copy(i, i2, map2);
    }

    public final int component1() {
        return this.version;
    }

    public final int component2() {
        return this.series;
    }

    public final Map<String, DeviceConfig> component3() {
        return this.map;
    }

    public final SkuConfiguration copy(int i, int i2, Map<String, DeviceConfig> map2) {
        Intrinsics.checkNotNullParameter(map2, "map");
        return new SkuConfiguration(i, i2, map2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SkuConfiguration)) {
            return false;
        }
        SkuConfiguration skuConfiguration = (SkuConfiguration) obj;
        return this.version == skuConfiguration.version && this.series == skuConfiguration.series && Intrinsics.areEqual((Object) this.map, (Object) skuConfiguration.map);
    }

    public int hashCode() {
        return (((this.version * 31) + this.series) * 31) + this.map.hashCode();
    }

    public String toString() {
        return "SkuConfiguration(version=" + this.version + ", series=" + this.series + ", map=" + this.map + ')';
    }

    public SkuConfiguration(int i, int i2, Map<String, DeviceConfig> map2) {
        Intrinsics.checkNotNullParameter(map2, "map");
        this.version = i;
        this.series = i2;
        this.map = map2;
    }

    public final int getVersion() {
        return this.version;
    }

    public final int getSeries() {
        return this.series;
    }

    public final Map<String, DeviceConfig> getMap() {
        return this.map;
    }

    public final DeviceConfig getDeviceConfig(String str) {
        Map<String, DeviceConfig> map2 = this.map;
        if (str == null) {
            return null;
        }
        return map2.get(str);
    }
}
