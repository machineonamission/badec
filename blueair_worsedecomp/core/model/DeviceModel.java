package com.blueair.core.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J9\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u001c"}, d2 = {"Lcom/blueair/core/model/DeviceModel;", "", "type", "Lcom/blueair/core/model/DeviceType;", "modelName", "Lcom/blueair/core/model/I18nConfig;", "familyName", "userManual", "<init>", "(Lcom/blueair/core/model/DeviceType;Lcom/blueair/core/model/I18nConfig;Lcom/blueair/core/model/I18nConfig;Lcom/blueair/core/model/I18nConfig;)V", "getType", "()Lcom/blueair/core/model/DeviceType;", "getModelName", "()Lcom/blueair/core/model/I18nConfig;", "getFamilyName", "getUserManual", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: SkuConfiguration.kt */
public final class DeviceModel {
    private final I18nConfig familyName;
    private final I18nConfig modelName;
    private final DeviceType type;
    private final I18nConfig userManual;

    public static /* synthetic */ DeviceModel copy$default(DeviceModel deviceModel, DeviceType deviceType, I18nConfig i18nConfig, I18nConfig i18nConfig2, I18nConfig i18nConfig3, int i, Object obj) {
        if ((i & 1) != 0) {
            deviceType = deviceModel.type;
        }
        if ((i & 2) != 0) {
            i18nConfig = deviceModel.modelName;
        }
        if ((i & 4) != 0) {
            i18nConfig2 = deviceModel.familyName;
        }
        if ((i & 8) != 0) {
            i18nConfig3 = deviceModel.userManual;
        }
        return deviceModel.copy(deviceType, i18nConfig, i18nConfig2, i18nConfig3);
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

    public final I18nConfig component4() {
        return this.userManual;
    }

    public final DeviceModel copy(DeviceType deviceType, I18nConfig i18nConfig, I18nConfig i18nConfig2, I18nConfig i18nConfig3) {
        return new DeviceModel(deviceType, i18nConfig, i18nConfig2, i18nConfig3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceModel)) {
            return false;
        }
        DeviceModel deviceModel = (DeviceModel) obj;
        return Intrinsics.areEqual((Object) this.type, (Object) deviceModel.type) && Intrinsics.areEqual((Object) this.modelName, (Object) deviceModel.modelName) && Intrinsics.areEqual((Object) this.familyName, (Object) deviceModel.familyName) && Intrinsics.areEqual((Object) this.userManual, (Object) deviceModel.userManual);
    }

    public int hashCode() {
        DeviceType deviceType = this.type;
        int i = 0;
        int hashCode = (deviceType == null ? 0 : deviceType.hashCode()) * 31;
        I18nConfig i18nConfig = this.modelName;
        int hashCode2 = (hashCode + (i18nConfig == null ? 0 : i18nConfig.hashCode())) * 31;
        I18nConfig i18nConfig2 = this.familyName;
        int hashCode3 = (hashCode2 + (i18nConfig2 == null ? 0 : i18nConfig2.hashCode())) * 31;
        I18nConfig i18nConfig3 = this.userManual;
        if (i18nConfig3 != null) {
            i = i18nConfig3.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "DeviceModel(type=" + this.type + ", modelName=" + this.modelName + ", familyName=" + this.familyName + ", userManual=" + this.userManual + ')';
    }

    public DeviceModel(DeviceType deviceType, I18nConfig i18nConfig, I18nConfig i18nConfig2, I18nConfig i18nConfig3) {
        this.type = deviceType;
        this.modelName = i18nConfig;
        this.familyName = i18nConfig2;
        this.userManual = i18nConfig3;
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

    public final I18nConfig getUserManual() {
        return this.userManual;
    }
}
