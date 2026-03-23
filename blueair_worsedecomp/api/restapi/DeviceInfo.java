package com.blueair.api.restapi;

import com.blueair.api.model.SensorData;
import com.blueair.core.model.BlueCloudHomeLocationReceive;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\n0\u0007HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003Ja\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020(HÖ\u0001J\t\u0010)\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0012¨\u0006*"}, d2 = {"Lcom/blueair/api/restapi/DeviceInfo;", "", "id", "", "configuration", "Lcom/blueair/api/restapi/Configuration;", "sensordata", "", "Lcom/blueair/api/model/SensorData;", "states", "Lcom/blueair/api/restapi/State;", "welcomehome", "Lcom/blueair/core/model/BlueCloudHomeLocationReceive;", "location_id", "timezone", "<init>", "(Ljava/lang/String;Lcom/blueair/api/restapi/Configuration;Ljava/util/List;Ljava/util/List;Lcom/blueair/core/model/BlueCloudHomeLocationReceive;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getConfiguration", "()Lcom/blueair/api/restapi/Configuration;", "getSensordata", "()Ljava/util/List;", "getStates", "getWelcomehome", "()Lcom/blueair/core/model/BlueCloudHomeLocationReceive;", "getLocation_id", "getTimezone", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "api_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: UserDevicesBlueRestApi.kt */
public final class DeviceInfo {
    private final Configuration configuration;
    private final String id;
    private final String location_id;
    private final List<SensorData> sensordata;
    private final List<State> states;
    private final String timezone;
    private final BlueCloudHomeLocationReceive welcomehome;

    public static /* synthetic */ DeviceInfo copy$default(DeviceInfo deviceInfo, String str, Configuration configuration2, List<SensorData> list, List<State> list2, BlueCloudHomeLocationReceive blueCloudHomeLocationReceive, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = deviceInfo.id;
        }
        if ((i & 2) != 0) {
            configuration2 = deviceInfo.configuration;
        }
        if ((i & 4) != 0) {
            list = deviceInfo.sensordata;
        }
        if ((i & 8) != 0) {
            list2 = deviceInfo.states;
        }
        if ((i & 16) != 0) {
            blueCloudHomeLocationReceive = deviceInfo.welcomehome;
        }
        if ((i & 32) != 0) {
            str2 = deviceInfo.location_id;
        }
        if ((i & 64) != 0) {
            str3 = deviceInfo.timezone;
        }
        String str4 = str2;
        String str5 = str3;
        List<State> list3 = list2;
        BlueCloudHomeLocationReceive blueCloudHomeLocationReceive2 = blueCloudHomeLocationReceive;
        return deviceInfo.copy(str, configuration2, list, list3, blueCloudHomeLocationReceive2, str4, str5);
    }

    public final String component1() {
        return this.id;
    }

    public final Configuration component2() {
        return this.configuration;
    }

    public final List<SensorData> component3() {
        return this.sensordata;
    }

    public final List<State> component4() {
        return this.states;
    }

    public final BlueCloudHomeLocationReceive component5() {
        return this.welcomehome;
    }

    public final String component6() {
        return this.location_id;
    }

    public final String component7() {
        return this.timezone;
    }

    public final DeviceInfo copy(String str, Configuration configuration2, List<SensorData> list, List<State> list2, BlueCloudHomeLocationReceive blueCloudHomeLocationReceive, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(configuration2, "configuration");
        Intrinsics.checkNotNullParameter(list, "sensordata");
        Intrinsics.checkNotNullParameter(list2, "states");
        return new DeviceInfo(str, configuration2, list, list2, blueCloudHomeLocationReceive, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceInfo)) {
            return false;
        }
        DeviceInfo deviceInfo = (DeviceInfo) obj;
        return Intrinsics.areEqual((Object) this.id, (Object) deviceInfo.id) && Intrinsics.areEqual((Object) this.configuration, (Object) deviceInfo.configuration) && Intrinsics.areEqual((Object) this.sensordata, (Object) deviceInfo.sensordata) && Intrinsics.areEqual((Object) this.states, (Object) deviceInfo.states) && Intrinsics.areEqual((Object) this.welcomehome, (Object) deviceInfo.welcomehome) && Intrinsics.areEqual((Object) this.location_id, (Object) deviceInfo.location_id) && Intrinsics.areEqual((Object) this.timezone, (Object) deviceInfo.timezone);
    }

    public int hashCode() {
        int hashCode = ((((((this.id.hashCode() * 31) + this.configuration.hashCode()) * 31) + this.sensordata.hashCode()) * 31) + this.states.hashCode()) * 31;
        BlueCloudHomeLocationReceive blueCloudHomeLocationReceive = this.welcomehome;
        int i = 0;
        int hashCode2 = (hashCode + (blueCloudHomeLocationReceive == null ? 0 : blueCloudHomeLocationReceive.hashCode())) * 31;
        String str = this.location_id;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.timezone;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "DeviceInfo(id=" + this.id + ", configuration=" + this.configuration + ", sensordata=" + this.sensordata + ", states=" + this.states + ", welcomehome=" + this.welcomehome + ", location_id=" + this.location_id + ", timezone=" + this.timezone + ')';
    }

    public DeviceInfo(String str, Configuration configuration2, List<SensorData> list, List<State> list2, BlueCloudHomeLocationReceive blueCloudHomeLocationReceive, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(configuration2, "configuration");
        Intrinsics.checkNotNullParameter(list, "sensordata");
        Intrinsics.checkNotNullParameter(list2, "states");
        this.id = str;
        this.configuration = configuration2;
        this.sensordata = list;
        this.states = list2;
        this.welcomehome = blueCloudHomeLocationReceive;
        this.location_id = str2;
        this.timezone = str3;
    }

    public final String getId() {
        return this.id;
    }

    public final Configuration getConfiguration() {
        return this.configuration;
    }

    public final List<SensorData> getSensordata() {
        return this.sensordata;
    }

    public final List<State> getStates() {
        return this.states;
    }

    public final BlueCloudHomeLocationReceive getWelcomehome() {
        return this.welcomehome;
    }

    public final String getLocation_id() {
        return this.location_id;
    }

    public final String getTimezone() {
        return this.timezone;
    }
}
