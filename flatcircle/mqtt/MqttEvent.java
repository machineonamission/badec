package io.flatcircle.mqtt;

import com.blueair.adddevice.model.AddDeviceState$$ExternalSyntheticBackport0;
import com.blueair.api.model.SensorData;
import com.blueair.core.model.DeviceEvent;
import com.blueair.core.model.DeviceStateBundle;
import com.blueair.database.entity.DeviceDataEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0004\u0005\u0006\u0007\bB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0005\t\n\u000b\f\r¨\u0006\u000e"}, d2 = {"Lio/flatcircle/mqtt/MqttEvent;", "", "<init>", "()V", "MqttDeviceEvent", "MqttSensorEvent", "MqttStateEvent", "MqttConnectivityEvent", "LogoutEvent", "Lio/flatcircle/mqtt/MqttEvent$LogoutEvent;", "Lio/flatcircle/mqtt/MqttEvent$MqttConnectivityEvent;", "Lio/flatcircle/mqtt/MqttEvent$MqttDeviceEvent;", "Lio/flatcircle/mqtt/MqttEvent$MqttSensorEvent;", "Lio/flatcircle/mqtt/MqttEvent$MqttStateEvent;", "mqtt_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: MqttService.kt */
public abstract class MqttEvent {
    public /* synthetic */ MqttEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private MqttEvent() {
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lio/flatcircle/mqtt/MqttEvent$MqttDeviceEvent;", "Lio/flatcircle/mqtt/MqttEvent;", "deviceEvent", "Lcom/blueair/core/model/DeviceEvent;", "<init>", "(Lcom/blueair/core/model/DeviceEvent;)V", "getDeviceEvent", "()Lcom/blueair/core/model/DeviceEvent;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "mqtt_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: MqttService.kt */
    public static final class MqttDeviceEvent extends MqttEvent {
        private final DeviceEvent deviceEvent;

        public static /* synthetic */ MqttDeviceEvent copy$default(MqttDeviceEvent mqttDeviceEvent, DeviceEvent deviceEvent2, int i, Object obj) {
            if ((i & 1) != 0) {
                deviceEvent2 = mqttDeviceEvent.deviceEvent;
            }
            return mqttDeviceEvent.copy(deviceEvent2);
        }

        public final DeviceEvent component1() {
            return this.deviceEvent;
        }

        public final MqttDeviceEvent copy(DeviceEvent deviceEvent2) {
            Intrinsics.checkNotNullParameter(deviceEvent2, "deviceEvent");
            return new MqttDeviceEvent(deviceEvent2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof MqttDeviceEvent) && Intrinsics.areEqual((Object) this.deviceEvent, (Object) ((MqttDeviceEvent) obj).deviceEvent);
        }

        public int hashCode() {
            return this.deviceEvent.hashCode();
        }

        public String toString() {
            return "MqttDeviceEvent(deviceEvent=" + this.deviceEvent + ')';
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public MqttDeviceEvent(DeviceEvent deviceEvent2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(deviceEvent2, "deviceEvent");
            this.deviceEvent = deviceEvent2;
        }

        public final DeviceEvent getDeviceEvent() {
            return this.deviceEvent;
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lio/flatcircle/mqtt/MqttEvent$MqttSensorEvent;", "Lio/flatcircle/mqtt/MqttEvent;", "deviceId", "", "sensorEvents", "", "Lcom/blueair/api/model/SensorData;", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "getDeviceId", "()Ljava/lang/String;", "getSensorEvents", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "mqtt_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: MqttService.kt */
    public static final class MqttSensorEvent extends MqttEvent {
        private final String deviceId;
        private final List<SensorData> sensorEvents;

        public static /* synthetic */ MqttSensorEvent copy$default(MqttSensorEvent mqttSensorEvent, String str, List<SensorData> list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = mqttSensorEvent.deviceId;
            }
            if ((i & 2) != 0) {
                list = mqttSensorEvent.sensorEvents;
            }
            return mqttSensorEvent.copy(str, list);
        }

        public final String component1() {
            return this.deviceId;
        }

        public final List<SensorData> component2() {
            return this.sensorEvents;
        }

        public final MqttSensorEvent copy(String str, List<SensorData> list) {
            Intrinsics.checkNotNullParameter(str, DeviceDataEntity.DEVICE_ID);
            Intrinsics.checkNotNullParameter(list, "sensorEvents");
            return new MqttSensorEvent(str, list);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MqttSensorEvent)) {
                return false;
            }
            MqttSensorEvent mqttSensorEvent = (MqttSensorEvent) obj;
            return Intrinsics.areEqual((Object) this.deviceId, (Object) mqttSensorEvent.deviceId) && Intrinsics.areEqual((Object) this.sensorEvents, (Object) mqttSensorEvent.sensorEvents);
        }

        public int hashCode() {
            return (this.deviceId.hashCode() * 31) + this.sensorEvents.hashCode();
        }

        public String toString() {
            return "MqttSensorEvent(deviceId=" + this.deviceId + ", sensorEvents=" + this.sensorEvents + ')';
        }

        public final String getDeviceId() {
            return this.deviceId;
        }

        public final List<SensorData> getSensorEvents() {
            return this.sensorEvents;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public MqttSensorEvent(String str, List<SensorData> list) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, DeviceDataEntity.DEVICE_ID);
            Intrinsics.checkNotNullParameter(list, "sensorEvents");
            this.deviceId = str;
            this.sensorEvents = list;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lio/flatcircle/mqtt/MqttEvent$MqttStateEvent;", "Lio/flatcircle/mqtt/MqttEvent;", "deviceId", "", "sensorStateBundle", "Lcom/blueair/core/model/DeviceStateBundle;", "<init>", "(Ljava/lang/String;Lcom/blueair/core/model/DeviceStateBundle;)V", "getDeviceId", "()Ljava/lang/String;", "getSensorStateBundle", "()Lcom/blueair/core/model/DeviceStateBundle;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "mqtt_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: MqttService.kt */
    public static final class MqttStateEvent extends MqttEvent {
        private final String deviceId;
        private final DeviceStateBundle sensorStateBundle;

        public static /* synthetic */ MqttStateEvent copy$default(MqttStateEvent mqttStateEvent, String str, DeviceStateBundle deviceStateBundle, int i, Object obj) {
            if ((i & 1) != 0) {
                str = mqttStateEvent.deviceId;
            }
            if ((i & 2) != 0) {
                deviceStateBundle = mqttStateEvent.sensorStateBundle;
            }
            return mqttStateEvent.copy(str, deviceStateBundle);
        }

        public final String component1() {
            return this.deviceId;
        }

        public final DeviceStateBundle component2() {
            return this.sensorStateBundle;
        }

        public final MqttStateEvent copy(String str, DeviceStateBundle deviceStateBundle) {
            Intrinsics.checkNotNullParameter(str, DeviceDataEntity.DEVICE_ID);
            Intrinsics.checkNotNullParameter(deviceStateBundle, "sensorStateBundle");
            return new MqttStateEvent(str, deviceStateBundle);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MqttStateEvent)) {
                return false;
            }
            MqttStateEvent mqttStateEvent = (MqttStateEvent) obj;
            return Intrinsics.areEqual((Object) this.deviceId, (Object) mqttStateEvent.deviceId) && Intrinsics.areEqual((Object) this.sensorStateBundle, (Object) mqttStateEvent.sensorStateBundle);
        }

        public int hashCode() {
            return (this.deviceId.hashCode() * 31) + this.sensorStateBundle.hashCode();
        }

        public String toString() {
            return "MqttStateEvent(deviceId=" + this.deviceId + ", sensorStateBundle=" + this.sensorStateBundle + ')';
        }

        public final String getDeviceId() {
            return this.deviceId;
        }

        public final DeviceStateBundle getSensorStateBundle() {
            return this.sensorStateBundle;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public MqttStateEvent(String str, DeviceStateBundle deviceStateBundle) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, DeviceDataEntity.DEVICE_ID);
            Intrinsics.checkNotNullParameter(deviceStateBundle, "sensorStateBundle");
            this.deviceId = str;
            this.sensorStateBundle = deviceStateBundle;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\n¨\u0006\u0014"}, d2 = {"Lio/flatcircle/mqtt/MqttEvent$MqttConnectivityEvent;", "Lio/flatcircle/mqtt/MqttEvent;", "deviceId", "", "isOnline", "", "<init>", "(Ljava/lang/String;Z)V", "getDeviceId", "()Ljava/lang/String;", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "mqtt_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: MqttService.kt */
    public static final class MqttConnectivityEvent extends MqttEvent {
        private final String deviceId;
        private final boolean isOnline;

        public static /* synthetic */ MqttConnectivityEvent copy$default(MqttConnectivityEvent mqttConnectivityEvent, String str, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                str = mqttConnectivityEvent.deviceId;
            }
            if ((i & 2) != 0) {
                z = mqttConnectivityEvent.isOnline;
            }
            return mqttConnectivityEvent.copy(str, z);
        }

        public final String component1() {
            return this.deviceId;
        }

        public final boolean component2() {
            return this.isOnline;
        }

        public final MqttConnectivityEvent copy(String str, boolean z) {
            Intrinsics.checkNotNullParameter(str, DeviceDataEntity.DEVICE_ID);
            return new MqttConnectivityEvent(str, z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MqttConnectivityEvent)) {
                return false;
            }
            MqttConnectivityEvent mqttConnectivityEvent = (MqttConnectivityEvent) obj;
            return Intrinsics.areEqual((Object) this.deviceId, (Object) mqttConnectivityEvent.deviceId) && this.isOnline == mqttConnectivityEvent.isOnline;
        }

        public int hashCode() {
            return (this.deviceId.hashCode() * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.isOnline);
        }

        public String toString() {
            return "MqttConnectivityEvent(deviceId=" + this.deviceId + ", isOnline=" + this.isOnline + ')';
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public MqttConnectivityEvent(String str, boolean z) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, DeviceDataEntity.DEVICE_ID);
            this.deviceId = str;
            this.isOnline = z;
        }

        public final String getDeviceId() {
            return this.deviceId;
        }

        public final boolean isOnline() {
            return this.isOnline;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lio/flatcircle/mqtt/MqttEvent$LogoutEvent;", "Lio/flatcircle/mqtt/MqttEvent;", "<init>", "()V", "mqtt_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: MqttService.kt */
    public static final class LogoutEvent extends MqttEvent {
        public static final LogoutEvent INSTANCE = new LogoutEvent();

        private LogoutEvent() {
            super((DefaultConstructorMarker) null);
        }
    }
}
