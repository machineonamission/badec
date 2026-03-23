package com.blueair.core.model;

import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BS\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r¢\u0006\u0004\b\u000f\u0010\u0010J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010#\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rHÆ\u0003Jc\u0010$\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rHÆ\u0001J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020)HÖ\u0001J\t\u0010*\u001a\u00020\u000eHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0019\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006+"}, d2 = {"Lcom/blueair/core/model/DeviceConfig;", "", "type", "Lcom/blueair/core/model/DeviceType;", "modelName", "Lcom/blueair/core/model/I18nConfig;", "familyName", "image", "Lcom/blueair/core/model/DeviceImage;", "filter", "Lcom/blueair/core/model/FilterConfig;", "manual", "market", "", "", "<init>", "(Lcom/blueair/core/model/DeviceType;Lcom/blueair/core/model/I18nConfig;Lcom/blueair/core/model/I18nConfig;Lcom/blueair/core/model/DeviceImage;Lcom/blueair/core/model/FilterConfig;Lcom/blueair/core/model/I18nConfig;Ljava/util/Set;)V", "getType", "()Lcom/blueair/core/model/DeviceType;", "getModelName", "()Lcom/blueair/core/model/I18nConfig;", "getFamilyName", "getImage", "()Lcom/blueair/core/model/DeviceImage;", "getFilter", "()Lcom/blueair/core/model/FilterConfig;", "getManual", "getMarket", "()Ljava/util/Set;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: SkuConfiguration.kt */
public final class DeviceConfig {
    private final I18nConfig familyName;
    private final FilterConfig filter;
    private final DeviceImage image;
    private final I18nConfig manual;
    private final Set<String> market;
    private final I18nConfig modelName;
    private final DeviceType type;

    public static /* synthetic */ DeviceConfig copy$default(DeviceConfig deviceConfig, DeviceType deviceType, I18nConfig i18nConfig, I18nConfig i18nConfig2, DeviceImage deviceImage, FilterConfig filterConfig, I18nConfig i18nConfig3, Set<String> set, int i, Object obj) {
        if ((i & 1) != 0) {
            deviceType = deviceConfig.type;
        }
        if ((i & 2) != 0) {
            i18nConfig = deviceConfig.modelName;
        }
        if ((i & 4) != 0) {
            i18nConfig2 = deviceConfig.familyName;
        }
        if ((i & 8) != 0) {
            deviceImage = deviceConfig.image;
        }
        if ((i & 16) != 0) {
            filterConfig = deviceConfig.filter;
        }
        if ((i & 32) != 0) {
            i18nConfig3 = deviceConfig.manual;
        }
        if ((i & 64) != 0) {
            set = deviceConfig.market;
        }
        I18nConfig i18nConfig4 = i18nConfig3;
        Set<String> set2 = set;
        DeviceImage deviceImage2 = deviceImage;
        FilterConfig filterConfig2 = filterConfig;
        return deviceConfig.copy(deviceType, i18nConfig, i18nConfig2, deviceImage2, filterConfig2, i18nConfig4, set2);
    }

    public final DeviceType component1() {
        return this.type;
    }

    public final I18nConfig component2() {
        return this.modelName;
    }

    public final I18nConfig component3() {
        return this.familyName;
    }

    public final DeviceImage component4() {
        return this.image;
    }

    public final FilterConfig component5() {
        return this.filter;
    }

    public final I18nConfig component6() {
        return this.manual;
    }

    public final Set<String> component7() {
        return this.market;
    }

    public final DeviceConfig copy(DeviceType deviceType, I18nConfig i18nConfig, I18nConfig i18nConfig2, DeviceImage deviceImage, FilterConfig filterConfig, I18nConfig i18nConfig3, Set<String> set) {
        return new DeviceConfig(deviceType, i18nConfig, i18nConfig2, deviceImage, filterConfig, i18nConfig3, set);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceConfig)) {
            return false;
        }
        DeviceConfig deviceConfig = (DeviceConfig) obj;
        return Intrinsics.areEqual((Object) this.type, (Object) deviceConfig.type) && Intrinsics.areEqual((Object) this.modelName, (Object) deviceConfig.modelName) && Intrinsics.areEqual((Object) this.familyName, (Object) deviceConfig.familyName) && this.image == deviceConfig.image && Intrinsics.areEqual((Object) this.filter, (Object) deviceConfig.filter) && Intrinsics.areEqual((Object) this.manual, (Object) deviceConfig.manual) && Intrinsics.areEqual((Object) this.market, (Object) deviceConfig.market);
    }

    public int hashCode() {
        DeviceType deviceType = this.type;
        int i = 0;
        int hashCode = (deviceType == null ? 0 : deviceType.hashCode()) * 31;
        I18nConfig i18nConfig = this.modelName;
        int hashCode2 = (hashCode + (i18nConfig == null ? 0 : i18nConfig.hashCode())) * 31;
        I18nConfig i18nConfig2 = this.familyName;
        int hashCode3 = (hashCode2 + (i18nConfig2 == null ? 0 : i18nConfig2.hashCode())) * 31;
        DeviceImage deviceImage = this.image;
        int hashCode4 = (hashCode3 + (deviceImage == null ? 0 : deviceImage.hashCode())) * 31;
        FilterConfig filterConfig = this.filter;
        int hashCode5 = (hashCode4 + (filterConfig == null ? 0 : filterConfig.hashCode())) * 31;
        I18nConfig i18nConfig3 = this.manual;
        int hashCode6 = (hashCode5 + (i18nConfig3 == null ? 0 : i18nConfig3.hashCode())) * 31;
        Set<String> set = this.market;
        if (set != null) {
            i = set.hashCode();
        }
        return hashCode6 + i;
    }

    public String toString() {
        return "DeviceConfig(type=" + this.type + ", modelName=" + this.modelName + ", familyName=" + this.familyName + ", image=" + this.image + ", filter=" + this.filter + ", manual=" + this.manual + ", market=" + this.market + ')';
    }

    public DeviceConfig(DeviceType deviceType, I18nConfig i18nConfig, I18nConfig i18nConfig2, DeviceImage deviceImage, FilterConfig filterConfig, I18nConfig i18nConfig3, Set<String> set) {
        this.type = deviceType;
        this.modelName = i18nConfig;
        this.familyName = i18nConfig2;
        this.image = deviceImage;
        this.filter = filterConfig;
        this.manual = i18nConfig3;
        this.market = set;
    }

    public final DeviceType getType() {
        return this.type;
    }

    public final I18nConfig getModelName() {
        return this.modelName;
    }

    public final I18nConfig getFamilyName() {
        return this.familyName;
    }

    public final DeviceImage getImage() {
        return this.image;
    }

    public final FilterConfig getFilter() {
        return this.filter;
    }

    public final I18nConfig getManual() {
        return this.manual;
    }

    public final Set<String> getMarket() {
        return this.market;
    }
}
