package com.blueair.core.model;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\u0010\u001a\u00020\u00112\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u0013J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001f"}, d2 = {"Lcom/blueair/core/model/DeviceModelRaw;", "", "type", "", "model_name", "Lcom/blueair/core/model/I18nConfig;", "family_name", "user_manual", "<init>", "(Ljava/lang/String;Lcom/blueair/core/model/I18nConfig;Lcom/blueair/core/model/I18nConfig;Ljava/lang/String;)V", "getType", "()Ljava/lang/String;", "getModel_name", "()Lcom/blueair/core/model/I18nConfig;", "getFamily_name", "getUser_manual", "toDeviceModel", "Lcom/blueair/core/model/DeviceModel;", "manualMap", "", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: SkuConfiguration.kt */
public final class DeviceModelRaw {
    private final I18nConfig family_name;
    private final I18nConfig model_name;
    private final String type;
    private final String user_manual;

    public static /* synthetic */ DeviceModelRaw copy$default(DeviceModelRaw deviceModelRaw, String str, I18nConfig i18nConfig, I18nConfig i18nConfig2, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = deviceModelRaw.type;
        }
        if ((i & 2) != 0) {
            i18nConfig = deviceModelRaw.model_name;
        }
        if ((i & 4) != 0) {
            i18nConfig2 = deviceModelRaw.family_name;
        }
        if ((i & 8) != 0) {
            str2 = deviceModelRaw.user_manual;
        }
        return deviceModelRaw.copy(str, i18nConfig, i18nConfig2, str2);
    }

    public final String component1() {
        return this.type;
    }

    public final I18nConfig component2() {
        return this.model_name;
    }

    public final I18nConfig component3() {
        return this.family_name;
    }

    public final String component4() {
        return this.user_manual;
    }

    public final DeviceModelRaw copy(String str, I18nConfig i18nConfig, I18nConfig i18nConfig2, String str2) {
        return new DeviceModelRaw(str, i18nConfig, i18nConfig2, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceModelRaw)) {
            return false;
        }
        DeviceModelRaw deviceModelRaw = (DeviceModelRaw) obj;
        return Intrinsics.areEqual((Object) this.type, (Object) deviceModelRaw.type) && Intrinsics.areEqual((Object) this.model_name, (Object) deviceModelRaw.model_name) && Intrinsics.areEqual((Object) this.family_name, (Object) deviceModelRaw.family_name) && Intrinsics.areEqual((Object) this.user_manual, (Object) deviceModelRaw.user_manual);
    }

    public int hashCode() {
        String str = this.type;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        I18nConfig i18nConfig = this.model_name;
        int hashCode2 = (hashCode + (i18nConfig == null ? 0 : i18nConfig.hashCode())) * 31;
        I18nConfig i18nConfig2 = this.family_name;
        int hashCode3 = (hashCode2 + (i18nConfig2 == null ? 0 : i18nConfig2.hashCode())) * 31;
        String str2 = this.user_manual;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "DeviceModelRaw(type=" + this.type + ", model_name=" + this.model_name + ", family_name=" + this.family_name + ", user_manual=" + this.user_manual + ')';
    }

    public DeviceModelRaw(String str, I18nConfig i18nConfig, I18nConfig i18nConfig2, String str2) {
        this.type = str;
        this.model_name = i18nConfig;
        this.family_name = i18nConfig2;
        this.user_manual = str2;
    }

    public final String getType() {
        return this.type;
    }

    public final I18nConfig getModel_name() {
        return this.model_name;
    }

    public final I18nConfig getFamily_name() {
        return this.family_name;
    }

    public final String getUser_manual() {
        return this.user_manual;
    }

    public final DeviceModel toDeviceModel(Map<String, I18nConfig> map) {
        Intrinsics.checkNotNullParameter(map, "manualMap");
        String str = this.type;
        return new DeviceModel(str != null ? DeviceType.Companion.fromName(str) : null, this.model_name, this.family_name, map.get(this.user_manual));
    }
}
