package com.blueair.api.restapi;

import com.squareup.moshi.Json;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B'\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/blueair/api/restapi/Configuration;", "", "id", "", "deviceInfo", "Lcom/blueair/api/restapi/ConfigurationDeviceInfo;", "da", "Lcom/blueair/api/restapi/Da;", "<init>", "(Ljava/lang/String;Lcom/blueair/api/restapi/ConfigurationDeviceInfo;Lcom/blueair/api/restapi/Da;)V", "getId", "()Ljava/lang/String;", "getDeviceInfo", "()Lcom/blueair/api/restapi/ConfigurationDeviceInfo;", "getDa", "()Lcom/blueair/api/restapi/Da;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "api_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: UserDevicesBlueRestApi.kt */
public final class Configuration {
    private final Da da;
    private final ConfigurationDeviceInfo deviceInfo;
    private final String id;

    public static /* synthetic */ Configuration copy$default(Configuration configuration, String str, ConfigurationDeviceInfo configurationDeviceInfo, Da da2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = configuration.id;
        }
        if ((i & 2) != 0) {
            configurationDeviceInfo = configuration.deviceInfo;
        }
        if ((i & 4) != 0) {
            da2 = configuration.da;
        }
        return configuration.copy(str, configurationDeviceInfo, da2);
    }

    public final String component1() {
        return this.id;
    }

    public final ConfigurationDeviceInfo component2() {
        return this.deviceInfo;
    }

    public final Da component3() {
        return this.da;
    }

    public final Configuration copy(String str, @Json(name = "di") ConfigurationDeviceInfo configurationDeviceInfo, Da da2) {
        return new Configuration(str, configurationDeviceInfo, da2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Configuration)) {
            return false;
        }
        Configuration configuration = (Configuration) obj;
        return Intrinsics.areEqual((Object) this.id, (Object) configuration.id) && Intrinsics.areEqual((Object) this.deviceInfo, (Object) configuration.deviceInfo) && Intrinsics.areEqual((Object) this.da, (Object) configuration.da);
    }

    public int hashCode() {
        String str = this.id;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        ConfigurationDeviceInfo configurationDeviceInfo = this.deviceInfo;
        int hashCode2 = (hashCode + (configurationDeviceInfo == null ? 0 : configurationDeviceInfo.hashCode())) * 31;
        Da da2 = this.da;
        if (da2 != null) {
            i = da2.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "Configuration(id=" + this.id + ", deviceInfo=" + this.deviceInfo + ", da=" + this.da + ')';
    }

    public Configuration(String str, @Json(name = "di") ConfigurationDeviceInfo configurationDeviceInfo, Da da2) {
        this.id = str;
        this.deviceInfo = configurationDeviceInfo;
        this.da = da2;
    }

    public final String getId() {
        return this.id;
    }

    public final ConfigurationDeviceInfo getDeviceInfo() {
        return this.deviceInfo;
    }

    public final Da getDa() {
        return this.da;
    }
}
