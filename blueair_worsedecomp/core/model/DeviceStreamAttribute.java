package com.blueair.core.model;

import com.blueair.adddevice.model.AddDeviceState$$ExternalSyntheticBackport0;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000¼\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\bQ\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:K\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSB\u0013\b\u0004\u0012\b\u0010\u0003\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0004\u0010\u0005R\u0018\u0010\u0003\u001a\u0004\u0018\u00018\u0000X\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007\u0001jTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001¨\u0006\u0001"}, d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute;", "T", "", "value", "<init>", "(Ljava/lang/Object;)V", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "ConnectivityStatus", "LatestSensorDataPoint", "FanSpeed", "FanSpeedManualOrAuto", "AutoMode", "Brightness", "ChildLock", "GermShield", "GermShieldNight", "G4NightMode", "SafetySwitch", "Unknown", "StandByMode", "EcoMode", "HinsMode", "HinsNightMode", "FilterUsage", "Disinfection", "DisinfectLeftTime", "WickdryEnabled", "WickdryOn", "WickdryLeftTime", "WickUsage", "WaterShortage", "AutoRh", "TimerStatus", "TimerDuration", "TimerLeftTime", "TemperatureUnit", "OscillationState", "OscillationAngle", "OscillationDirection", "OscillationFanSpeed", "MainMode", "ApSubMode", "ApFanSpeed", "HeatSubMode", "HeatFanSpeed", "HeatAutoTmp", "HeatEcoTmp", "CoolSubMode", "CoolFanSpeed", "CoolAutoTag", "CoolAutoPresets", "CoolEcoTag", "CoolEcoPresets", "Mode", "HumMode", "WaterLevel", "DehSubMode", "WaterTankFailure", "SmartSubMode", "DetectCat", "BodyMounted", "CleanAirEta", "PanelDisplayMode", "HoverEnabled", "AirRefreshEnabled", "AirRefreshStatus", "AirRefreshDuration", "AirRefreshTimeStamp", "AirRefreshStartTimeStamp", "AirRefreshEndTimeStamp", "RoomType", "NightLampBrightness", "NightLampSteplessBrightness", "WickdryDuration", "WickdryDone", "YwrmEnabled", "YwrmUsage", "Alarms", "HumSubMode", "Use24Hour", "WaterInfill", "SensorMode", "Lcom/blueair/core/model/DeviceStreamAttribute$AirRefreshDuration;", "Lcom/blueair/core/model/DeviceStreamAttribute$AirRefreshEnabled;", "Lcom/blueair/core/model/DeviceStreamAttribute$AirRefreshEndTimeStamp;", "Lcom/blueair/core/model/DeviceStreamAttribute$AirRefreshStartTimeStamp;", "Lcom/blueair/core/model/DeviceStreamAttribute$AirRefreshStatus;", "Lcom/blueair/core/model/DeviceStreamAttribute$AirRefreshTimeStamp;", "Lcom/blueair/core/model/DeviceStreamAttribute$Alarms;", "Lcom/blueair/core/model/DeviceStreamAttribute$ApFanSpeed;", "Lcom/blueair/core/model/DeviceStreamAttribute$ApSubMode;", "Lcom/blueair/core/model/DeviceStreamAttribute$AutoMode;", "Lcom/blueair/core/model/DeviceStreamAttribute$AutoRh;", "Lcom/blueair/core/model/DeviceStreamAttribute$BodyMounted;", "Lcom/blueair/core/model/DeviceStreamAttribute$Brightness;", "Lcom/blueair/core/model/DeviceStreamAttribute$ChildLock;", "Lcom/blueair/core/model/DeviceStreamAttribute$CleanAirEta;", "Lcom/blueair/core/model/DeviceStreamAttribute$ConnectivityStatus;", "Lcom/blueair/core/model/DeviceStreamAttribute$CoolAutoPresets;", "Lcom/blueair/core/model/DeviceStreamAttribute$CoolAutoTag;", "Lcom/blueair/core/model/DeviceStreamAttribute$CoolEcoPresets;", "Lcom/blueair/core/model/DeviceStreamAttribute$CoolEcoTag;", "Lcom/blueair/core/model/DeviceStreamAttribute$CoolFanSpeed;", "Lcom/blueair/core/model/DeviceStreamAttribute$CoolSubMode;", "Lcom/blueair/core/model/DeviceStreamAttribute$DehSubMode;", "Lcom/blueair/core/model/DeviceStreamAttribute$DetectCat;", "Lcom/blueair/core/model/DeviceStreamAttribute$DisinfectLeftTime;", "Lcom/blueair/core/model/DeviceStreamAttribute$Disinfection;", "Lcom/blueair/core/model/DeviceStreamAttribute$EcoMode;", "Lcom/blueair/core/model/DeviceStreamAttribute$FanSpeed;", "Lcom/blueair/core/model/DeviceStreamAttribute$FanSpeedManualOrAuto;", "Lcom/blueair/core/model/DeviceStreamAttribute$FilterUsage;", "Lcom/blueair/core/model/DeviceStreamAttribute$G4NightMode;", "Lcom/blueair/core/model/DeviceStreamAttribute$GermShield;", "Lcom/blueair/core/model/DeviceStreamAttribute$GermShieldNight;", "Lcom/blueair/core/model/DeviceStreamAttribute$HeatAutoTmp;", "Lcom/blueair/core/model/DeviceStreamAttribute$HeatEcoTmp;", "Lcom/blueair/core/model/DeviceStreamAttribute$HeatFanSpeed;", "Lcom/blueair/core/model/DeviceStreamAttribute$HeatSubMode;", "Lcom/blueair/core/model/DeviceStreamAttribute$HinsMode;", "Lcom/blueair/core/model/DeviceStreamAttribute$HinsNightMode;", "Lcom/blueair/core/model/DeviceStreamAttribute$HoverEnabled;", "Lcom/blueair/core/model/DeviceStreamAttribute$HumMode;", "Lcom/blueair/core/model/DeviceStreamAttribute$HumSubMode;", "Lcom/blueair/core/model/DeviceStreamAttribute$LatestSensorDataPoint;", "Lcom/blueair/core/model/DeviceStreamAttribute$MainMode;", "Lcom/blueair/core/model/DeviceStreamAttribute$Mode;", "Lcom/blueair/core/model/DeviceStreamAttribute$NightLampBrightness;", "Lcom/blueair/core/model/DeviceStreamAttribute$NightLampSteplessBrightness;", "Lcom/blueair/core/model/DeviceStreamAttribute$OscillationAngle;", "Lcom/blueair/core/model/DeviceStreamAttribute$OscillationDirection;", "Lcom/blueair/core/model/DeviceStreamAttribute$OscillationFanSpeed;", "Lcom/blueair/core/model/DeviceStreamAttribute$OscillationState;", "Lcom/blueair/core/model/DeviceStreamAttribute$PanelDisplayMode;", "Lcom/blueair/core/model/DeviceStreamAttribute$RoomType;", "Lcom/blueair/core/model/DeviceStreamAttribute$SafetySwitch;", "Lcom/blueair/core/model/DeviceStreamAttribute$SensorMode;", "Lcom/blueair/core/model/DeviceStreamAttribute$SmartSubMode;", "Lcom/blueair/core/model/DeviceStreamAttribute$StandByMode;", "Lcom/blueair/core/model/DeviceStreamAttribute$TemperatureUnit;", "Lcom/blueair/core/model/DeviceStreamAttribute$TimerDuration;", "Lcom/blueair/core/model/DeviceStreamAttribute$TimerLeftTime;", "Lcom/blueair/core/model/DeviceStreamAttribute$TimerStatus;", "Lcom/blueair/core/model/DeviceStreamAttribute$Unknown;", "Lcom/blueair/core/model/DeviceStreamAttribute$Use24Hour;", "Lcom/blueair/core/model/DeviceStreamAttribute$WaterInfill;", "Lcom/blueair/core/model/DeviceStreamAttribute$WaterLevel;", "Lcom/blueair/core/model/DeviceStreamAttribute$WaterShortage;", "Lcom/blueair/core/model/DeviceStreamAttribute$WaterTankFailure;", "Lcom/blueair/core/model/DeviceStreamAttribute$WickUsage;", "Lcom/blueair/core/model/DeviceStreamAttribute$WickdryDone;", "Lcom/blueair/core/model/DeviceStreamAttribute$WickdryDuration;", "Lcom/blueair/core/model/DeviceStreamAttribute$WickdryEnabled;", "Lcom/blueair/core/model/DeviceStreamAttribute$WickdryLeftTime;", "Lcom/blueair/core/model/DeviceStreamAttribute$WickdryOn;", "Lcom/blueair/core/model/DeviceStreamAttribute$YwrmEnabled;", "Lcom/blueair/core/model/DeviceStreamAttribute$YwrmUsage;", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceStreamAttribute.kt */
public abstract class DeviceStreamAttribute<T> {
    private final T value;

    public /* synthetic */ DeviceStreamAttribute(Object obj, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj);
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$ConnectivityStatus;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(I)V", "getValue", "()Ljava/lang/Integer;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceStreamAttribute.kt */
    public static final class ConnectivityStatus extends DeviceStreamAttribute<Integer> {
        private final int value;

        public static /* synthetic */ ConnectivityStatus copy$default(ConnectivityStatus connectivityStatus, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = connectivityStatus.value;
            }
            return connectivityStatus.copy(i);
        }

        public final int component1() {
            return this.value;
        }

        public final ConnectivityStatus copy(int i) {
            return new ConnectivityStatus(i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ConnectivityStatus) && this.value == ((ConnectivityStatus) obj).value;
        }

        public int hashCode() {
            return this.value;
        }

        public String toString() {
            return "ConnectivityStatus(value=" + this.value + ')';
        }

        public ConnectivityStatus(int i) {
            super(Integer.valueOf(i), (DefaultConstructorMarker) null);
            this.value = i;
        }

        public Integer getValue() {
            return Integer.valueOf(this.value);
        }
    }

    private DeviceStreamAttribute(T t) {
        this.value = t;
    }

    public T getValue() {
        return this.value;
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$LatestSensorDataPoint;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "Lcom/blueair/core/model/IndoorDatapoint;", "value", "<init>", "(Lcom/blueair/core/model/IndoorDatapoint;)V", "getValue", "()Lcom/blueair/core/model/IndoorDatapoint;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceStreamAttribute.kt */
    public static final class LatestSensorDataPoint extends DeviceStreamAttribute<IndoorDatapoint> {
        private final IndoorDatapoint value;

        public static /* synthetic */ LatestSensorDataPoint copy$default(LatestSensorDataPoint latestSensorDataPoint, IndoorDatapoint indoorDatapoint, int i, Object obj) {
            if ((i & 1) != 0) {
                indoorDatapoint = latestSensorDataPoint.value;
            }
            return latestSensorDataPoint.copy(indoorDatapoint);
        }

        public final IndoorDatapoint component1() {
            return this.value;
        }

        public final LatestSensorDataPoint copy(IndoorDatapoint indoorDatapoint) {
            return new LatestSensorDataPoint(indoorDatapoint);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof LatestSensorDataPoint) && Intrinsics.areEqual((Object) this.value, (Object) ((LatestSensorDataPoint) obj).value);
        }

        public int hashCode() {
            IndoorDatapoint indoorDatapoint = this.value;
            if (indoorDatapoint == null) {
                return 0;
            }
            return indoorDatapoint.hashCode();
        }

        public String toString() {
            return "LatestSensorDataPoint(value=" + this.value + ')';
        }

        public LatestSensorDataPoint(IndoorDatapoint indoorDatapoint) {
            super(indoorDatapoint, (DefaultConstructorMarker) null);
            this.value = indoorDatapoint;
        }

        public IndoorDatapoint getValue() {
            return this.value;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$FanSpeed;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(I)V", "getValue", "()Ljava/lang/Integer;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceStreamAttribute.kt */
    public static final class FanSpeed extends DeviceStreamAttribute<Integer> {
        private final int value;

        public static /* synthetic */ FanSpeed copy$default(FanSpeed fanSpeed, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = fanSpeed.value;
            }
            return fanSpeed.copy(i);
        }

        public final int component1() {
            return this.value;
        }

        public final FanSpeed copy(int i) {
            return new FanSpeed(i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof FanSpeed) && this.value == ((FanSpeed) obj).value;
        }

        public int hashCode() {
            return this.value;
        }

        public String toString() {
            return "FanSpeed(value=" + this.value + ')';
        }

        public FanSpeed(int i) {
            super(Integer.valueOf(i), (DefaultConstructorMarker) null);
            this.value = i;
        }

        public Integer getValue() {
            return Integer.valueOf(this.value);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$FanSpeedManualOrAuto;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(I)V", "getValue", "()Ljava/lang/Integer;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceStreamAttribute.kt */
    public static final class FanSpeedManualOrAuto extends DeviceStreamAttribute<Integer> {
        private final int value;

        public static /* synthetic */ FanSpeedManualOrAuto copy$default(FanSpeedManualOrAuto fanSpeedManualOrAuto, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = fanSpeedManualOrAuto.value;
            }
            return fanSpeedManualOrAuto.copy(i);
        }

        public final int component1() {
            return this.value;
        }

        public final FanSpeedManualOrAuto copy(int i) {
            return new FanSpeedManualOrAuto(i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof FanSpeedManualOrAuto) && this.value == ((FanSpeedManualOrAuto) obj).value;
        }

        public int hashCode() {
            return this.value;
        }

        public String toString() {
            return "FanSpeedManualOrAuto(value=" + this.value + ')';
        }

        public FanSpeedManualOrAuto(int i) {
            super(Integer.valueOf(i), (DefaultConstructorMarker) null);
            this.value = i;
        }

        public Integer getValue() {
            return Integer.valueOf(this.value);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$AutoMode;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceStreamAttribute.kt */
    public static final class AutoMode extends DeviceStreamAttribute<String> {
        private final String value;

        public static /* synthetic */ AutoMode copy$default(AutoMode autoMode, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = autoMode.value;
            }
            return autoMode.copy(str);
        }

        public final String component1() {
            return this.value;
        }

        public final AutoMode copy(String str) {
            Intrinsics.checkNotNullParameter(str, "value");
            return new AutoMode(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof AutoMode) && Intrinsics.areEqual((Object) this.value, (Object) ((AutoMode) obj).value);
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        public String toString() {
            return "AutoMode(value=" + this.value + ')';
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public AutoMode(String str) {
            super(str, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "value");
            this.value = str;
        }

        public String getValue() {
            return this.value;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$Brightness;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(I)V", "getValue", "()Ljava/lang/Integer;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceStreamAttribute.kt */
    public static final class Brightness extends DeviceStreamAttribute<Integer> {
        private final int value;

        public static /* synthetic */ Brightness copy$default(Brightness brightness, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = brightness.value;
            }
            return brightness.copy(i);
        }

        public final int component1() {
            return this.value;
        }

        public final Brightness copy(int i) {
            return new Brightness(i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Brightness) && this.value == ((Brightness) obj).value;
        }

        public int hashCode() {
            return this.value;
        }

        public String toString() {
            return "Brightness(value=" + this.value + ')';
        }

        public Brightness(int i) {
            super(Integer.valueOf(i), (DefaultConstructorMarker) null);
            this.value = i;
        }

        public Integer getValue() {
            return Integer.valueOf(this.value);
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$ChildLock;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(Z)V", "getValue", "()Ljava/lang/Boolean;", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceStreamAttribute.kt */
    public static final class ChildLock extends DeviceStreamAttribute<Boolean> {
        private final boolean value;

        public static /* synthetic */ ChildLock copy$default(ChildLock childLock, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = childLock.value;
            }
            return childLock.copy(z);
        }

        public final boolean component1() {
            return this.value;
        }

        public final ChildLock copy(boolean z) {
            return new ChildLock(z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ChildLock) && this.value == ((ChildLock) obj).value;
        }

        public int hashCode() {
            return AddDeviceState$$ExternalSyntheticBackport0.m(this.value);
        }

        public String toString() {
            return "ChildLock(value=" + this.value + ')';
        }

        public ChildLock(boolean z) {
            super(Boolean.valueOf(z), (DefaultConstructorMarker) null);
            this.value = z;
        }

        public Boolean getValue() {
            return Boolean.valueOf(this.value);
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$GermShield;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(Z)V", "getValue", "()Ljava/lang/Boolean;", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceStreamAttribute.kt */
    public static final class GermShield extends DeviceStreamAttribute<Boolean> {
        private final boolean value;

        public static /* synthetic */ GermShield copy$default(GermShield germShield, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = germShield.value;
            }
            return germShield.copy(z);
        }

        public final boolean component1() {
            return this.value;
        }

        public final GermShield copy(boolean z) {
            return new GermShield(z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof GermShield) && this.value == ((GermShield) obj).value;
        }

        public int hashCode() {
            return AddDeviceState$$ExternalSyntheticBackport0.m(this.value);
        }

        public String toString() {
            return "GermShield(value=" + this.value + ')';
        }

        public GermShield(boolean z) {
            super(Boolean.valueOf(z), (DefaultConstructorMarker) null);
            this.value = z;
        }

        public Boolean getValue() {
            return Boolean.valueOf(this.value);
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$GermShieldNight;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(Z)V", "getValue", "()Ljava/lang/Boolean;", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceStreamAttribute.kt */
    public static final class GermShieldNight extends DeviceStreamAttribute<Boolean> {
        private final boolean value;

        public static /* synthetic */ GermShieldNight copy$default(GermShieldNight germShieldNight, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = germShieldNight.value;
            }
            return germShieldNight.copy(z);
        }

        public final boolean component1() {
            return this.value;
        }

        public final GermShieldNight copy(boolean z) {
            return new GermShieldNight(z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof GermShieldNight) && this.value == ((GermShieldNight) obj).value;
        }

        public int hashCode() {
            return AddDeviceState$$ExternalSyntheticBackport0.m(this.value);
        }

        public String toString() {
            return "GermShieldNight(value=" + this.value + ')';
        }

        public GermShieldNight(boolean z) {
            super(Boolean.valueOf(z), (DefaultConstructorMarker) null);
            this.value = z;
        }

        public Boolean getValue() {
            return Boolean.valueOf(this.value);
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$G4NightMode;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(Z)V", "getValue", "()Ljava/lang/Boolean;", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceStreamAttribute.kt */
    public static final class G4NightMode extends DeviceStreamAttribute<Boolean> {
        private final boolean value;

        public static /* synthetic */ G4NightMode copy$default(G4NightMode g4NightMode, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = g4NightMode.value;
            }
            return g4NightMode.copy(z);
        }

        public final boolean component1() {
            return this.value;
        }

        public final G4NightMode copy(boolean z) {
            return new G4NightMode(z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof G4NightMode) && this.value == ((G4NightMode) obj).value;
        }

        public int hashCode() {
            return AddDeviceState$$ExternalSyntheticBackport0.m(this.value);
        }

        public String toString() {
            return "G4NightMode(value=" + this.value + ')';
        }

        public G4NightMode(boolean z) {
            super(Boolean.valueOf(z), (DefaultConstructorMarker) null);
            this.value = z;
        }

        public Boolean getValue() {
            return Boolean.valueOf(this.value);
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$SafetySwitch;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(Z)V", "getValue", "()Ljava/lang/Boolean;", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceStreamAttribute.kt */
    public static final class SafetySwitch extends DeviceStreamAttribute<Boolean> {
        private final boolean value;

        public static /* synthetic */ SafetySwitch copy$default(SafetySwitch safetySwitch, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = safetySwitch.value;
            }
            return safetySwitch.copy(z);
        }

        public final boolean component1() {
            return this.value;
        }

        public final SafetySwitch copy(boolean z) {
            return new SafetySwitch(z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof SafetySwitch) && this.value == ((SafetySwitch) obj).value;
        }

        public int hashCode() {
            return AddDeviceState$$ExternalSyntheticBackport0.m(this.value);
        }

        public String toString() {
            return "SafetySwitch(value=" + this.value + ')';
        }

        public SafetySwitch(boolean z) {
            super(Boolean.valueOf(z), (DefaultConstructorMarker) null);
            this.value = z;
        }

        public Boolean getValue() {
            return Boolean.valueOf(this.value);
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$Unknown;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(Z)V", "getValue", "()Ljava/lang/Boolean;", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceStreamAttribute.kt */
    public static final class Unknown extends DeviceStreamAttribute<Boolean> {
        private final boolean value;

        public Unknown() {
            this(false, 1, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ Unknown copy$default(Unknown unknown, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = unknown.value;
            }
            return unknown.copy(z);
        }

        public final boolean component1() {
            return this.value;
        }

        public final Unknown copy(boolean z) {
            return new Unknown(z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Unknown) && this.value == ((Unknown) obj).value;
        }

        public int hashCode() {
            return AddDeviceState$$ExternalSyntheticBackport0.m(this.value);
        }

        public String toString() {
            return "Unknown(value=" + this.value + ')';
        }

        public Unknown(boolean z) {
            super(Boolean.valueOf(z), (DefaultConstructorMarker) null);
            this.value = z;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Unknown(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? false : z);
        }

        public Boolean getValue() {
            return Boolean.valueOf(this.value);
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$StandByMode;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(Z)V", "getValue", "()Ljava/lang/Boolean;", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceStreamAttribute.kt */
    public static final class StandByMode extends DeviceStreamAttribute<Boolean> {
        private final boolean value;

        public static /* synthetic */ StandByMode copy$default(StandByMode standByMode, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = standByMode.value;
            }
            return standByMode.copy(z);
        }

        public final boolean component1() {
            return this.value;
        }

        public final StandByMode copy(boolean z) {
            return new StandByMode(z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof StandByMode) && this.value == ((StandByMode) obj).value;
        }

        public int hashCode() {
            return AddDeviceState$$ExternalSyntheticBackport0.m(this.value);
        }

        public String toString() {
            return "StandByMode(value=" + this.value + ')';
        }

        public StandByMode(boolean z) {
            super(Boolean.valueOf(z), (DefaultConstructorMarker) null);
            this.value = z;
        }

        public Boolean getValue() {
            return Boolean.valueOf(this.value);
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$EcoMode;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(Z)V", "getValue", "()Ljava/lang/Boolean;", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceStreamAttribute.kt */
    public static final class EcoMode extends DeviceStreamAttribute<Boolean> {
        private final boolean value;

        public static /* synthetic */ EcoMode copy$default(EcoMode ecoMode, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = ecoMode.value;
            }
            return ecoMode.copy(z);
        }

        public final boolean component1() {
            return this.value;
        }

        public final EcoMode copy(boolean z) {
            return new EcoMode(z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof EcoMode) && this.value == ((EcoMode) obj).value;
        }

        public int hashCode() {
            return AddDeviceState$$ExternalSyntheticBackport0.m(this.value);
        }

        public String toString() {
            return "EcoMode(value=" + this.value + ')';
        }

        public EcoMode(boolean z) {
            super(Boolean.valueOf(z), (DefaultConstructorMarker) null);
            this.value = z;
        }

        public Boolean getValue() {
            return Boolean.valueOf(this.value);
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$HinsMode;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(Z)V", "getValue", "()Ljava/lang/Boolean;", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceStreamAttribute.kt */
    public static final class HinsMode extends DeviceStreamAttribute<Boolean> {
        private final boolean value;

        public static /* synthetic */ HinsMode copy$default(HinsMode hinsMode, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = hinsMode.value;
            }
            return hinsMode.copy(z);
        }

        public final boolean component1() {
            return this.value;
        }

        public final HinsMode copy(boolean z) {
            return new HinsMode(z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof HinsMode) && this.value == ((HinsMode) obj).value;
        }

        public int hashCode() {
            return AddDeviceState$$ExternalSyntheticBackport0.m(this.value);
        }

        public String toString() {
            return "HinsMode(value=" + this.value + ')';
        }

        public HinsMode(boolean z) {
            super(Boolean.valueOf(z), (DefaultConstructorMarker) null);
            this.value = z;
        }

        public Boolean getValue() {
            return Boolean.valueOf(this.value);
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$HinsNightMode;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(Z)V", "getValue", "()Ljava/lang/Boolean;", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceStreamAttribute.kt */
    public static final class HinsNightMode extends DeviceStreamAttribute<Boolean> {
        private final boolean value;

        public static /* synthetic */ HinsNightMode copy$default(HinsNightMode hinsNightMode, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = hinsNightMode.value;
            }
            return hinsNightMode.copy(z);
        }

        public final boolean component1() {
            return this.value;
        }

        public final HinsNightMode copy(boolean z) {
            return new HinsNightMode(z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof HinsNightMode) && this.value == ((HinsNightMode) obj).value;
        }

        public int hashCode() {
            return AddDeviceState$$ExternalSyntheticBackport0.m(this.value);
        }

        public String toString() {
            return "HinsNightMode(value=" + this.value + ')';
        }

        public HinsNightMode(boolean z) {
            super(Boolean.valueOf(z), (DefaultConstructorMarker) null);
            this.value = z;
        }

        public Boolean getValue() {
            return Boolean.valueOf(this.value);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$FilterUsage;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(I)V", "getValue", "()Ljava/lang/Integer;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceStreamAttribute.kt */
    public static final class FilterUsage extends DeviceStreamAttribute<Integer> {
        private final int value;

        public static /* synthetic */ FilterUsage copy$default(FilterUsage filterUsage, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = filterUsage.value;
            }
            return filterUsage.copy(i);
        }

        public final int component1() {
            return this.value;
        }

        public final FilterUsage copy(int i) {
            return new FilterUsage(i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof FilterUsage) && this.value == ((FilterUsage) obj).value;
        }

        public int hashCode() {
            return this.value;
        }

        public String toString() {
            return "FilterUsage(value=" + this.value + ')';
        }

        public FilterUsage(int i) {
            super(Integer.valueOf(i), (DefaultConstructorMarker) null);
            this.value = i;
        }

        public Integer getValue() {
            return Integer.valueOf(this.value);
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$Disinfection;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(Z)V", "getValue", "()Ljava/lang/Boolean;", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceStreamAttribute.kt */
    public static final class Disinfection extends DeviceStreamAttribute<Boolean> {
        private final boolean value;

        public static /* synthetic */ Disinfection copy$default(Disinfection disinfection, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = disinfection.value;
            }
            return disinfection.copy(z);
        }

        public final boolean component1() {
            return this.value;
        }

        public final Disinfection copy(boolean z) {
            return new Disinfection(z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Disinfection) && this.value == ((Disinfection) obj).value;
        }

        public int hashCode() {
            return AddDeviceState$$ExternalSyntheticBackport0.m(this.value);
        }

        public String toString() {
            return "Disinfection(value=" + this.value + ')';
        }

        public Disinfection(boolean z) {
            super(Boolean.valueOf(z), (DefaultConstructorMarker) null);
            this.value = z;
        }

        public Boolean getValue() {
            return Boolean.valueOf(this.value);
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001B\u001b\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002HÆ\u0003J\u001f\u0010\u000b\u001a\u00020\u00002\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R \u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$DisinfectLeftTime;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "Lkotlin/Pair;", "", "", "value", "<init>", "(Lkotlin/Pair;)V", "getValue", "()Lkotlin/Pair;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceStreamAttribute.kt */
    public static final class DisinfectLeftTime extends DeviceStreamAttribute<Pair<? extends Integer, ? extends Long>> {
        private final Pair<Integer, Long> value;

        public static /* synthetic */ DisinfectLeftTime copy$default(DisinfectLeftTime disinfectLeftTime, Pair<Integer, Long> pair, int i, Object obj) {
            if ((i & 1) != 0) {
                pair = disinfectLeftTime.value;
            }
            return disinfectLeftTime.copy(pair);
        }

        public final Pair<Integer, Long> component1() {
            return this.value;
        }

        public final DisinfectLeftTime copy(Pair<Integer, Long> pair) {
            Intrinsics.checkNotNullParameter(pair, "value");
            return new DisinfectLeftTime(pair);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof DisinfectLeftTime) && Intrinsics.areEqual((Object) this.value, (Object) ((DisinfectLeftTime) obj).value);
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        public String toString() {
            return "DisinfectLeftTime(value=" + this.value + ')';
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DisinfectLeftTime(Pair<Integer, Long> pair) {
            super(pair, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(pair, "value");
            this.value = pair;
        }

        public Pair<Integer, Long> getValue() {
            return this.value;
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$WickdryEnabled;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(Z)V", "getValue", "()Ljava/lang/Boolean;", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceStreamAttribute.kt */
    public static final class WickdryEnabled extends DeviceStreamAttribute<Boolean> {
        private final boolean value;

        public static /* synthetic */ WickdryEnabled copy$default(WickdryEnabled wickdryEnabled, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = wickdryEnabled.value;
            }
            return wickdryEnabled.copy(z);
        }

        public final boolean component1() {
            return this.value;
        }

        public final WickdryEnabled copy(boolean z) {
            return new WickdryEnabled(z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof WickdryEnabled) && this.value == ((WickdryEnabled) obj).value;
        }

        public int hashCode() {
            return AddDeviceState$$ExternalSyntheticBackport0.m(this.value);
        }

        public String toString() {
            return "WickdryEnabled(value=" + this.value + ')';
        }

        public WickdryEnabled(boolean z) {
            super(Boolean.valueOf(z), (DefaultConstructorMarker) null);
            this.value = z;
        }

        public Boolean getValue() {
            return Boolean.valueOf(this.value);
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$WickdryOn;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(Z)V", "getValue", "()Ljava/lang/Boolean;", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceStreamAttribute.kt */
    public static final class WickdryOn extends DeviceStreamAttribute<Boolean> {
        private final boolean value;

        public static /* synthetic */ WickdryOn copy$default(WickdryOn wickdryOn, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = wickdryOn.value;
            }
            return wickdryOn.copy(z);
        }

        public final boolean component1() {
            return this.value;
        }

        public final WickdryOn copy(boolean z) {
            return new WickdryOn(z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof WickdryOn) && this.value == ((WickdryOn) obj).value;
        }

        public int hashCode() {
            return AddDeviceState$$ExternalSyntheticBackport0.m(this.value);
        }

        public String toString() {
            return "WickdryOn(value=" + this.value + ')';
        }

        public WickdryOn(boolean z) {
            super(Boolean.valueOf(z), (DefaultConstructorMarker) null);
            this.value = z;
        }

        public Boolean getValue() {
            return Boolean.valueOf(this.value);
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001B\u001b\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002HÆ\u0003J\u001f\u0010\u000b\u001a\u00020\u00002\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R \u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$WickdryLeftTime;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "Lkotlin/Pair;", "", "", "value", "<init>", "(Lkotlin/Pair;)V", "getValue", "()Lkotlin/Pair;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceStreamAttribute.kt */
    public static final class WickdryLeftTime extends DeviceStreamAttribute<Pair<? extends Integer, ? extends Long>> {
        private final Pair<Integer, Long> value;

        public static /* synthetic */ WickdryLeftTime copy$default(WickdryLeftTime wickdryLeftTime, Pair<Integer, Long> pair, int i, Object obj) {
            if ((i & 1) != 0) {
                pair = wickdryLeftTime.value;
            }
            return wickdryLeftTime.copy(pair);
        }

        public final Pair<Integer, Long> component1() {
            return this.value;
        }

        public final WickdryLeftTime copy(Pair<Integer, Long> pair) {
            Intrinsics.checkNotNullParameter(pair, "value");
            return new WickdryLeftTime(pair);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof WickdryLeftTime) && Intrinsics.areEqual((Object) this.value, (Object) ((WickdryLeftTime) obj).value);
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        public String toString() {
            return "WickdryLeftTime(value=" + this.value + ')';
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public WickdryLeftTime(Pair<Integer, Long> pair) {
            super(pair, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(pair, "value");
            this.value = pair;
        }

        public Pair<Integer, Long> getValue() {
            return this.value;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$WickUsage;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(I)V", "getValue", "()Ljava/lang/Integer;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceStreamAttribute.kt */
    public static final class WickUsage extends DeviceStreamAttribute<Integer> {
        private final int value;

        public static /* synthetic */ WickUsage copy$default(WickUsage wickUsage, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = wickUsage.value;
            }
            return wickUsage.copy(i);
        }

        public final int component1() {
            return this.value;
        }

        public final WickUsage copy(int i) {
            return new WickUsage(i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof WickUsage) && this.value == ((WickUsage) obj).value;
        }

        public int hashCode() {
            return this.value;
        }

        public String toString() {
            return "WickUsage(value=" + this.value + ')';
        }

        public WickUsage(int i) {
            super(Integer.valueOf(i), (DefaultConstructorMarker) null);
            this.value = i;
        }

        public Integer getValue() {
            return Integer.valueOf(this.value);
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$WaterShortage;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(Z)V", "getValue", "()Ljava/lang/Boolean;", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceStreamAttribute.kt */
    public static final class WaterShortage extends DeviceStreamAttribute<Boolean> {
        private final boolean value;

        public static /* synthetic */ WaterShortage copy$default(WaterShortage waterShortage, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = waterShortage.value;
            }
            return waterShortage.copy(z);
        }

        public final boolean component1() {
            return this.value;
        }

        public final WaterShortage copy(boolean z) {
            return new WaterShortage(z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof WaterShortage) && this.value == ((WaterShortage) obj).value;
        }

        public int hashCode() {
            return AddDeviceState$$ExternalSyntheticBackport0.m(this.value);
        }

        public String toString() {
            return "WaterShortage(value=" + this.value + ')';
        }

        public WaterShortage(boolean z) {
            super(Boolean.valueOf(z), (DefaultConstructorMarker) null);
            this.value = z;
        }

        public Boolean getValue() {
            return Boolean.valueOf(this.value);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$AutoRh;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(I)V", "getValue", "()Ljava/lang/Integer;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceStreamAttribute.kt */
    public static final class AutoRh extends DeviceStreamAttribute<Integer> {
        private final int value;

        public static /* synthetic */ AutoRh copy$default(AutoRh autoRh, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = autoRh.value;
            }
            return autoRh.copy(i);
        }

        public final int component1() {
            return this.value;
        }

        public final AutoRh copy(int i) {
            return new AutoRh(i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof AutoRh) && this.value == ((AutoRh) obj).value;
        }

        public int hashCode() {
            return this.value;
        }

        public String toString() {
            return "AutoRh(value=" + this.value + ')';
        }

        public AutoRh(int i) {
            super(Integer.valueOf(i), (DefaultConstructorMarker) null);
            this.value = i;
        }

        public Integer getValue() {
            return Integer.valueOf(this.value);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$TimerStatus;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(I)V", "getValue", "()Ljava/lang/Integer;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceStreamAttribute.kt */
    public static final class TimerStatus extends DeviceStreamAttribute<Integer> {
        private final int value;

        public static /* synthetic */ TimerStatus copy$default(TimerStatus timerStatus, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = timerStatus.value;
            }
            return timerStatus.copy(i);
        }

        public final int component1() {
            return this.value;
        }

        public final TimerStatus copy(int i) {
            return new TimerStatus(i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof TimerStatus) && this.value == ((TimerStatus) obj).value;
        }

        public int hashCode() {
            return this.value;
        }

        public String toString() {
            return "TimerStatus(value=" + this.value + ')';
        }

        public TimerStatus(int i) {
            super(Integer.valueOf(i), (DefaultConstructorMarker) null);
            this.value = i;
        }

        public Integer getValue() {
            return Integer.valueOf(this.value);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$TimerDuration;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(I)V", "getValue", "()Ljava/lang/Integer;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceStreamAttribute.kt */
    public static final class TimerDuration extends DeviceStreamAttribute<Integer> {
        private final int value;

        public static /* synthetic */ TimerDuration copy$default(TimerDuration timerDuration, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = timerDuration.value;
            }
            return timerDuration.copy(i);
        }

        public final int component1() {
            return this.value;
        }

        public final TimerDuration copy(int i) {
            return new TimerDuration(i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof TimerDuration) && this.value == ((TimerDuration) obj).value;
        }

        public int hashCode() {
            return this.value;
        }

        public String toString() {
            return "TimerDuration(value=" + this.value + ')';
        }

        public TimerDuration(int i) {
            super(Integer.valueOf(i), (DefaultConstructorMarker) null);
            this.value = i;
        }

        public Integer getValue() {
            return Integer.valueOf(this.value);
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001B\u001b\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002HÆ\u0003J\u001f\u0010\u000b\u001a\u00020\u00002\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R \u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$TimerLeftTime;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "Lkotlin/Pair;", "", "", "value", "<init>", "(Lkotlin/Pair;)V", "getValue", "()Lkotlin/Pair;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceStreamAttribute.kt */
    public static final class TimerLeftTime extends DeviceStreamAttribute<Pair<? extends Integer, ? extends Long>> {
        private final Pair<Integer, Long> value;

        public static /* synthetic */ TimerLeftTime copy$default(TimerLeftTime timerLeftTime, Pair<Integer, Long> pair, int i, Object obj) {
            if ((i & 1) != 0) {
                pair = timerLeftTime.value;
            }
            return timerLeftTime.copy(pair);
        }

        public final Pair<Integer, Long> component1() {
            return this.value;
        }

        public final TimerLeftTime copy(Pair<Integer, Long> pair) {
            Intrinsics.checkNotNullParameter(pair, "value");
            return new TimerLeftTime(pair);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof TimerLeftTime) && Intrinsics.areEqual((Object) this.value, (Object) ((TimerLeftTime) obj).value);
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        public String toString() {
            return "TimerLeftTime(value=" + this.value + ')';
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public TimerLeftTime(Pair<Integer, Long> pair) {
            super(pair, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(pair, "value");
            this.value = pair;
        }

        public Pair<Integer, Long> getValue() {
            return this.value;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$TemperatureUnit;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(I)V", "getValue", "()Ljava/lang/Integer;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceStreamAttribute.kt */
    public static final class TemperatureUnit extends DeviceStreamAttribute<Integer> {
        private final int value;

        public static /* synthetic */ TemperatureUnit copy$default(TemperatureUnit temperatureUnit, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = temperatureUnit.value;
            }
            return temperatureUnit.copy(i);
        }

        public final int component1() {
            return this.value;
        }

        public final TemperatureUnit copy(int i) {
            return new TemperatureUnit(i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof TemperatureUnit) && this.value == ((TemperatureUnit) obj).value;
        }

        public int hashCode() {
            return this.value;
        }

        public String toString() {
            return "TemperatureUnit(value=" + this.value + ')';
        }

        public TemperatureUnit(int i) {
            super(Integer.valueOf(i), (DefaultConstructorMarker) null);
            this.value = i;
        }

        public Integer getValue() {
            return Integer.valueOf(this.value);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$OscillationState;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(I)V", "getValue", "()Ljava/lang/Integer;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceStreamAttribute.kt */
    public static final class OscillationState extends DeviceStreamAttribute<Integer> {
        private final int value;

        public static /* synthetic */ OscillationState copy$default(OscillationState oscillationState, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = oscillationState.value;
            }
            return oscillationState.copy(i);
        }

        public final int component1() {
            return this.value;
        }

        public final OscillationState copy(int i) {
            return new OscillationState(i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OscillationState) && this.value == ((OscillationState) obj).value;
        }

        public int hashCode() {
            return this.value;
        }

        public String toString() {
            return "OscillationState(value=" + this.value + ')';
        }

        public OscillationState(int i) {
            super(Integer.valueOf(i), (DefaultConstructorMarker) null);
            this.value = i;
        }

        public Integer getValue() {
            return Integer.valueOf(this.value);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$OscillationAngle;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(I)V", "getValue", "()Ljava/lang/Integer;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceStreamAttribute.kt */
    public static final class OscillationAngle extends DeviceStreamAttribute<Integer> {
        private final int value;

        public static /* synthetic */ OscillationAngle copy$default(OscillationAngle oscillationAngle, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = oscillationAngle.value;
            }
            return oscillationAngle.copy(i);
        }

        public final int component1() {
            return this.value;
        }

        public final OscillationAngle copy(int i) {
            return new OscillationAngle(i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OscillationAngle) && this.value == ((OscillationAngle) obj).value;
        }

        public int hashCode() {
            return this.value;
        }

        public String toString() {
            return "OscillationAngle(value=" + this.value + ')';
        }

        public OscillationAngle(int i) {
            super(Integer.valueOf(i), (DefaultConstructorMarker) null);
            this.value = i;
        }

        public Integer getValue() {
            return Integer.valueOf(this.value);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$OscillationDirection;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(I)V", "getValue", "()Ljava/lang/Integer;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceStreamAttribute.kt */
    public static final class OscillationDirection extends DeviceStreamAttribute<Integer> {
        private final int value;

        public static /* synthetic */ OscillationDirection copy$default(OscillationDirection oscillationDirection, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = oscillationDirection.value;
            }
            return oscillationDirection.copy(i);
        }

        public final int component1() {
            return this.value;
        }

        public final OscillationDirection copy(int i) {
            return new OscillationDirection(i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OscillationDirection) && this.value == ((OscillationDirection) obj).value;
        }

        public int hashCode() {
            return this.value;
        }

        public String toString() {
            return "OscillationDirection(value=" + this.value + ')';
        }

        public OscillationDirection(int i) {
            super(Integer.valueOf(i), (DefaultConstructorMarker) null);
            this.value = i;
        }

        public Integer getValue() {
            return Integer.valueOf(this.value);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$OscillationFanSpeed;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(I)V", "getValue", "()Ljava/lang/Integer;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceStreamAttribute.kt */
    public static final class OscillationFanSpeed extends DeviceStreamAttribute<Integer> {
        private final int value;

        public static /* synthetic */ OscillationFanSpeed copy$default(OscillationFanSpeed oscillationFanSpeed, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = oscillationFanSpeed.value;
            }
            return oscillationFanSpeed.copy(i);
        }

        public final int component1() {
            return this.value;
        }

        public final OscillationFanSpeed copy(int i) {
            return new OscillationFanSpeed(i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OscillationFanSpeed) && this.value == ((OscillationFanSpeed) obj).value;
        }

        public int hashCode() {
            return this.value;
        }

        public String toString() {
            return "OscillationFanSpeed(value=" + this.value + ')';
        }

        public OscillationFanSpeed(int i) {
            super(Integer.valueOf(i), (DefaultConstructorMarker) null);
            this.value = i;
        }

        public Integer getValue() {
            return Integer.valueOf(this.value);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$MainMode;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(I)V", "getValue", "()Ljava/lang/Integer;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceStreamAttribute.kt */
    public static final class MainMode extends DeviceStreamAttribute<Integer> {
        private final int value;

        public static /* synthetic */ MainMode copy$default(MainMode mainMode, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = mainMode.value;
            }
            return mainMode.copy(i);
        }

        public final int component1() {
            return this.value;
        }

        public final MainMode copy(int i) {
            return new MainMode(i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof MainMode) && this.value == ((MainMode) obj).value;
        }

        public int hashCode() {
            return this.value;
        }

        public String toString() {
            return "MainMode(value=" + this.value + ')';
        }

        public MainMode(int i) {
            super(Integer.valueOf(i), (DefaultConstructorMarker) null);
            this.value = i;
        }

        public Integer getValue() {
            return Integer.valueOf(this.value);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$ApSubMode;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(I)V", "getValue", "()Ljava/lang/Integer;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceStreamAttribute.kt */
    public static final class ApSubMode extends DeviceStreamAttribute<Integer> {
        private final int value;

        public static /* synthetic */ ApSubMode copy$default(ApSubMode apSubMode, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = apSubMode.value;
            }
            return apSubMode.copy(i);
        }

        public final int component1() {
            return this.value;
        }

        public final ApSubMode copy(int i) {
            return new ApSubMode(i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ApSubMode) && this.value == ((ApSubMode) obj).value;
        }

        public int hashCode() {
            return this.value;
        }

        public String toString() {
            return "ApSubMode(value=" + this.value + ')';
        }

        public ApSubMode(int i) {
            super(Integer.valueOf(i), (DefaultConstructorMarker) null);
            this.value = i;
        }

        public Integer getValue() {
            return Integer.valueOf(this.value);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$ApFanSpeed;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(I)V", "getValue", "()Ljava/lang/Integer;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceStreamAttribute.kt */
    public static final class ApFanSpeed extends DeviceStreamAttribute<Integer> {
        private final int value;

        public static /* synthetic */ ApFanSpeed copy$default(ApFanSpeed apFanSpeed, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = apFanSpeed.value;
            }
            return apFanSpeed.copy(i);
        }

        public final int component1() {
            return this.value;
        }

        public final ApFanSpeed copy(int i) {
            return new ApFanSpeed(i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ApFanSpeed) && this.value == ((ApFanSpeed) obj).value;
        }

        public int hashCode() {
            return this.value;
        }

        public String toString() {
            return "ApFanSpeed(value=" + this.value + ')';
        }

        public ApFanSpeed(int i) {
            super(Integer.valueOf(i), (DefaultConstructorMarker) null);
            this.value = i;
        }

        public Integer getValue() {
            return Integer.valueOf(this.value);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$HeatSubMode;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(I)V", "getValue", "()Ljava/lang/Integer;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceStreamAttribute.kt */
    public static final class HeatSubMode extends DeviceStreamAttribute<Integer> {
        private final int value;

        public static /* synthetic */ HeatSubMode copy$default(HeatSubMode heatSubMode, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = heatSubMode.value;
            }
            return heatSubMode.copy(i);
        }

        public final int component1() {
            return this.value;
        }

        public final HeatSubMode copy(int i) {
            return new HeatSubMode(i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof HeatSubMode) && this.value == ((HeatSubMode) obj).value;
        }

        public int hashCode() {
            return this.value;
        }

        public String toString() {
            return "HeatSubMode(value=" + this.value + ')';
        }

        public HeatSubMode(int i) {
            super(Integer.valueOf(i), (DefaultConstructorMarker) null);
            this.value = i;
        }

        public Integer getValue() {
            return Integer.valueOf(this.value);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$HeatFanSpeed;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(I)V", "getValue", "()Ljava/lang/Integer;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceStreamAttribute.kt */
    public static final class HeatFanSpeed extends DeviceStreamAttribute<Integer> {
        private final int value;

        public static /* synthetic */ HeatFanSpeed copy$default(HeatFanSpeed heatFanSpeed, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = heatFanSpeed.value;
            }
            return heatFanSpeed.copy(i);
        }

        public final int component1() {
            return this.value;
        }

        public final HeatFanSpeed copy(int i) {
            return new HeatFanSpeed(i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof HeatFanSpeed) && this.value == ((HeatFanSpeed) obj).value;
        }

        public int hashCode() {
            return this.value;
        }

        public String toString() {
            return "HeatFanSpeed(value=" + this.value + ')';
        }

        public HeatFanSpeed(int i) {
            super(Integer.valueOf(i), (DefaultConstructorMarker) null);
            this.value = i;
        }

        public Integer getValue() {
            return Integer.valueOf(this.value);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$HeatAutoTmp;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(D)V", "getValue", "()Ljava/lang/Double;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceStreamAttribute.kt */
    public static final class HeatAutoTmp extends DeviceStreamAttribute<Double> {
        private final double value;

        public static /* synthetic */ HeatAutoTmp copy$default(HeatAutoTmp heatAutoTmp, double d, int i, Object obj) {
            if ((i & 1) != 0) {
                d = heatAutoTmp.value;
            }
            return heatAutoTmp.copy(d);
        }

        public final double component1() {
            return this.value;
        }

        public final HeatAutoTmp copy(double d) {
            return new HeatAutoTmp(d);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof HeatAutoTmp) && Double.compare(this.value, ((HeatAutoTmp) obj).value) == 0;
        }

        public int hashCode() {
            return Double.doubleToLongBits(this.value);
        }

        public String toString() {
            return "HeatAutoTmp(value=" + this.value + ')';
        }

        public HeatAutoTmp(double d) {
            super(Double.valueOf(d), (DefaultConstructorMarker) null);
            this.value = d;
        }

        public Double getValue() {
            return Double.valueOf(this.value);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$HeatEcoTmp;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(D)V", "getValue", "()Ljava/lang/Double;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceStreamAttribute.kt */
    public static final class HeatEcoTmp extends DeviceStreamAttribute<Double> {
        private final double value;

        public static /* synthetic */ HeatEcoTmp copy$default(HeatEcoTmp heatEcoTmp, double d, int i, Object obj) {
            if ((i & 1) != 0) {
                d = heatEcoTmp.value;
            }
            return heatEcoTmp.copy(d);
        }

        public final double component1() {
            return this.value;
        }

        public final HeatEcoTmp copy(double d) {
            return new HeatEcoTmp(d);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof HeatEcoTmp) && Double.compare(this.value, ((HeatEcoTmp) obj).value) == 0;
        }

        public int hashCode() {
            return Double.doubleToLongBits(this.value);
        }

        public String toString() {
            return "HeatEcoTmp(value=" + this.value + ')';
        }

        public HeatEcoTmp(double d) {
            super(Double.valueOf(d), (DefaultConstructorMarker) null);
            this.value = d;
        }

        public Double getValue() {
            return Double.valueOf(this.value);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$CoolSubMode;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(I)V", "getValue", "()Ljava/lang/Integer;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceStreamAttribute.kt */
    public static final class CoolSubMode extends DeviceStreamAttribute<Integer> {
        private final int value;

        public static /* synthetic */ CoolSubMode copy$default(CoolSubMode coolSubMode, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = coolSubMode.value;
            }
            return coolSubMode.copy(i);
        }

        public final int component1() {
            return this.value;
        }

        public final CoolSubMode copy(int i) {
            return new CoolSubMode(i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof CoolSubMode) && this.value == ((CoolSubMode) obj).value;
        }

        public int hashCode() {
            return this.value;
        }

        public String toString() {
            return "CoolSubMode(value=" + this.value + ')';
        }

        public CoolSubMode(int i) {
            super(Integer.valueOf(i), (DefaultConstructorMarker) null);
            this.value = i;
        }

        public Integer getValue() {
            return Integer.valueOf(this.value);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$CoolFanSpeed;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(I)V", "getValue", "()Ljava/lang/Integer;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceStreamAttribute.kt */
    public static final class CoolFanSpeed extends DeviceStreamAttribute<Integer> {
        private final int value;

        public static /* synthetic */ CoolFanSpeed copy$default(CoolFanSpeed coolFanSpeed, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = coolFanSpeed.value;
            }
            return coolFanSpeed.copy(i);
        }

        public final int component1() {
            return this.value;
        }

        public final CoolFanSpeed copy(int i) {
            return new CoolFanSpeed(i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof CoolFanSpeed) && this.value == ((CoolFanSpeed) obj).value;
        }

        public int hashCode() {
            return this.value;
        }

        public String toString() {
            return "CoolFanSpeed(value=" + this.value + ')';
        }

        public CoolFanSpeed(int i) {
            super(Integer.valueOf(i), (DefaultConstructorMarker) null);
            this.value = i;
        }

        public Integer getValue() {
            return Integer.valueOf(this.value);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$CoolAutoTag;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(I)V", "getValue", "()Ljava/lang/Integer;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceStreamAttribute.kt */
    public static final class CoolAutoTag extends DeviceStreamAttribute<Integer> {
        private final int value;

        public static /* synthetic */ CoolAutoTag copy$default(CoolAutoTag coolAutoTag, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = coolAutoTag.value;
            }
            return coolAutoTag.copy(i);
        }

        public final int component1() {
            return this.value;
        }

        public final CoolAutoTag copy(int i) {
            return new CoolAutoTag(i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof CoolAutoTag) && this.value == ((CoolAutoTag) obj).value;
        }

        public int hashCode() {
            return this.value;
        }

        public String toString() {
            return "CoolAutoTag(value=" + this.value + ')';
        }

        public CoolAutoTag(int i) {
            super(Integer.valueOf(i), (DefaultConstructorMarker) null);
            this.value = i;
        }

        public Integer getValue() {
            return Integer.valueOf(this.value);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0013\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$CoolAutoPresets;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "([D)V", "getValue", "()[D", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceStreamAttribute.kt */
    public static final class CoolAutoPresets extends DeviceStreamAttribute<double[]> {
        private final double[] value;

        public static /* synthetic */ CoolAutoPresets copy$default(CoolAutoPresets coolAutoPresets, double[] dArr, int i, Object obj) {
            if ((i & 1) != 0) {
                dArr = coolAutoPresets.value;
            }
            return coolAutoPresets.copy(dArr);
        }

        public final double[] component1() {
            return this.value;
        }

        public final CoolAutoPresets copy(double[] dArr) {
            Intrinsics.checkNotNullParameter(dArr, "value");
            return new CoolAutoPresets(dArr);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof CoolAutoPresets) && Intrinsics.areEqual((Object) this.value, (Object) ((CoolAutoPresets) obj).value);
        }

        public int hashCode() {
            return Arrays.hashCode(this.value);
        }

        public String toString() {
            return "CoolAutoPresets(value=" + Arrays.toString(this.value) + ')';
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public CoolAutoPresets(double[] dArr) {
            super(dArr, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(dArr, "value");
            this.value = dArr;
        }

        public double[] getValue() {
            return this.value;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$CoolEcoTag;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(I)V", "getValue", "()Ljava/lang/Integer;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceStreamAttribute.kt */
    public static final class CoolEcoTag extends DeviceStreamAttribute<Integer> {
        private final int value;

        public static /* synthetic */ CoolEcoTag copy$default(CoolEcoTag coolEcoTag, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = coolEcoTag.value;
            }
            return coolEcoTag.copy(i);
        }

        public final int component1() {
            return this.value;
        }

        public final CoolEcoTag copy(int i) {
            return new CoolEcoTag(i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof CoolEcoTag) && this.value == ((CoolEcoTag) obj).value;
        }

        public int hashCode() {
            return this.value;
        }

        public String toString() {
            return "CoolEcoTag(value=" + this.value + ')';
        }

        public CoolEcoTag(int i) {
            super(Integer.valueOf(i), (DefaultConstructorMarker) null);
            this.value = i;
        }

        public Integer getValue() {
            return Integer.valueOf(this.value);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0013\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$CoolEcoPresets;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "([D)V", "getValue", "()[D", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceStreamAttribute.kt */
    public static final class CoolEcoPresets extends DeviceStreamAttribute<double[]> {
        private final double[] value;

        public static /* synthetic */ CoolEcoPresets copy$default(CoolEcoPresets coolEcoPresets, double[] dArr, int i, Object obj) {
            if ((i & 1) != 0) {
                dArr = coolEcoPresets.value;
            }
            return coolEcoPresets.copy(dArr);
        }

        public final double[] component1() {
            return this.value;
        }

        public final CoolEcoPresets copy(double[] dArr) {
            Intrinsics.checkNotNullParameter(dArr, "value");
            return new CoolEcoPresets(dArr);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof CoolEcoPresets) && Intrinsics.areEqual((Object) this.value, (Object) ((CoolEcoPresets) obj).value);
        }

        public int hashCode() {
            return Arrays.hashCode(this.value);
        }

        public String toString() {
            return "CoolEcoPresets(value=" + Arrays.toString(this.value) + ')';
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public CoolEcoPresets(double[] dArr) {
            super(dArr, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(dArr, "value");
            this.value = dArr;
        }

        public double[] getValue() {
            return this.value;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$Mode;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(I)V", "getValue", "()Ljava/lang/Integer;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceStreamAttribute.kt */
    public static final class Mode extends DeviceStreamAttribute<Integer> {
        private final int value;

        public static /* synthetic */ Mode copy$default(Mode mode, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = mode.value;
            }
            return mode.copy(i);
        }

        public final int component1() {
            return this.value;
        }

        public final Mode copy(int i) {
            return new Mode(i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Mode) && this.value == ((Mode) obj).value;
        }

        public int hashCode() {
            return this.value;
        }

        public String toString() {
            return "Mode(value=" + this.value + ')';
        }

        public Mode(int i) {
            super(Integer.valueOf(i), (DefaultConstructorMarker) null);
            this.value = i;
        }

        public Integer getValue() {
            return Integer.valueOf(this.value);
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$HumMode;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(Z)V", "getValue", "()Ljava/lang/Boolean;", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceStreamAttribute.kt */
    public static final class HumMode extends DeviceStreamAttribute<Boolean> {
        private final boolean value;

        public static /* synthetic */ HumMode copy$default(HumMode humMode, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = humMode.value;
            }
            return humMode.copy(z);
        }

        public final boolean component1() {
            return this.value;
        }

        public final HumMode copy(boolean z) {
            return new HumMode(z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof HumMode) && this.value == ((HumMode) obj).value;
        }

        public int hashCode() {
            return AddDeviceState$$ExternalSyntheticBackport0.m(this.value);
        }

        public String toString() {
            return "HumMode(value=" + this.value + ')';
        }

        public HumMode(boolean z) {
            super(Boolean.valueOf(z), (DefaultConstructorMarker) null);
            this.value = z;
        }

        public Boolean getValue() {
            return Boolean.valueOf(this.value);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$WaterLevel;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(I)V", "getValue", "()Ljava/lang/Integer;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceStreamAttribute.kt */
    public static final class WaterLevel extends DeviceStreamAttribute<Integer> {
        private final int value;

        public static /* synthetic */ WaterLevel copy$default(WaterLevel waterLevel, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = waterLevel.value;
            }
            return waterLevel.copy(i);
        }

        public final int component1() {
            return this.value;
        }

        public final WaterLevel copy(int i) {
            return new WaterLevel(i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof WaterLevel) && this.value == ((WaterLevel) obj).value;
        }

        public int hashCode() {
            return this.value;
        }

        public String toString() {
            return "WaterLevel(value=" + this.value + ')';
        }

        public WaterLevel(int i) {
            super(Integer.valueOf(i), (DefaultConstructorMarker) null);
            this.value = i;
        }

        public Integer getValue() {
            return Integer.valueOf(this.value);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$DehSubMode;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(I)V", "getValue", "()Ljava/lang/Integer;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceStreamAttribute.kt */
    public static final class DehSubMode extends DeviceStreamAttribute<Integer> {
        private final int value;

        public static /* synthetic */ DehSubMode copy$default(DehSubMode dehSubMode, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = dehSubMode.value;
            }
            return dehSubMode.copy(i);
        }

        public final int component1() {
            return this.value;
        }

        public final DehSubMode copy(int i) {
            return new DehSubMode(i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof DehSubMode) && this.value == ((DehSubMode) obj).value;
        }

        public int hashCode() {
            return this.value;
        }

        public String toString() {
            return "DehSubMode(value=" + this.value + ')';
        }

        public DehSubMode(int i) {
            super(Integer.valueOf(i), (DefaultConstructorMarker) null);
            this.value = i;
        }

        public Integer getValue() {
            return Integer.valueOf(this.value);
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$WaterTankFailure;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(Z)V", "getValue", "()Ljava/lang/Boolean;", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceStreamAttribute.kt */
    public static final class WaterTankFailure extends DeviceStreamAttribute<Boolean> {
        private final boolean value;

        public static /* synthetic */ WaterTankFailure copy$default(WaterTankFailure waterTankFailure, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = waterTankFailure.value;
            }
            return waterTankFailure.copy(z);
        }

        public final boolean component1() {
            return this.value;
        }

        public final WaterTankFailure copy(boolean z) {
            return new WaterTankFailure(z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof WaterTankFailure) && this.value == ((WaterTankFailure) obj).value;
        }

        public int hashCode() {
            return AddDeviceState$$ExternalSyntheticBackport0.m(this.value);
        }

        public String toString() {
            return "WaterTankFailure(value=" + this.value + ')';
        }

        public WaterTankFailure(boolean z) {
            super(Boolean.valueOf(z), (DefaultConstructorMarker) null);
            this.value = z;
        }

        public Boolean getValue() {
            return Boolean.valueOf(this.value);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$SmartSubMode;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(I)V", "getValue", "()Ljava/lang/Integer;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceStreamAttribute.kt */
    public static final class SmartSubMode extends DeviceStreamAttribute<Integer> {
        private final int value;

        public static /* synthetic */ SmartSubMode copy$default(SmartSubMode smartSubMode, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = smartSubMode.value;
            }
            return smartSubMode.copy(i);
        }

        public final int component1() {
            return this.value;
        }

        public final SmartSubMode copy(int i) {
            return new SmartSubMode(i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof SmartSubMode) && this.value == ((SmartSubMode) obj).value;
        }

        public int hashCode() {
            return this.value;
        }

        public String toString() {
            return "SmartSubMode(value=" + this.value + ')';
        }

        public SmartSubMode(int i) {
            super(Integer.valueOf(i), (DefaultConstructorMarker) null);
            this.value = i;
        }

        public Integer getValue() {
            return Integer.valueOf(this.value);
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$DetectCat;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(Z)V", "getValue", "()Ljava/lang/Boolean;", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceStreamAttribute.kt */
    public static final class DetectCat extends DeviceStreamAttribute<Boolean> {
        private final boolean value;

        public static /* synthetic */ DetectCat copy$default(DetectCat detectCat, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = detectCat.value;
            }
            return detectCat.copy(z);
        }

        public final boolean component1() {
            return this.value;
        }

        public final DetectCat copy(boolean z) {
            return new DetectCat(z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof DetectCat) && this.value == ((DetectCat) obj).value;
        }

        public int hashCode() {
            return AddDeviceState$$ExternalSyntheticBackport0.m(this.value);
        }

        public String toString() {
            return "DetectCat(value=" + this.value + ')';
        }

        public DetectCat(boolean z) {
            super(Boolean.valueOf(z), (DefaultConstructorMarker) null);
            this.value = z;
        }

        public Boolean getValue() {
            return Boolean.valueOf(this.value);
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$BodyMounted;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(Z)V", "getValue", "()Ljava/lang/Boolean;", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceStreamAttribute.kt */
    public static final class BodyMounted extends DeviceStreamAttribute<Boolean> {
        private final boolean value;

        public static /* synthetic */ BodyMounted copy$default(BodyMounted bodyMounted, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = bodyMounted.value;
            }
            return bodyMounted.copy(z);
        }

        public final boolean component1() {
            return this.value;
        }

        public final BodyMounted copy(boolean z) {
            return new BodyMounted(z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof BodyMounted) && this.value == ((BodyMounted) obj).value;
        }

        public int hashCode() {
            return AddDeviceState$$ExternalSyntheticBackport0.m(this.value);
        }

        public String toString() {
            return "BodyMounted(value=" + this.value + ')';
        }

        public BodyMounted(boolean z) {
            super(Boolean.valueOf(z), (DefaultConstructorMarker) null);
            this.value = z;
        }

        public Boolean getValue() {
            return Boolean.valueOf(this.value);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$CleanAirEta;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(I)V", "getValue", "()Ljava/lang/Integer;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceStreamAttribute.kt */
    public static final class CleanAirEta extends DeviceStreamAttribute<Integer> {
        private final int value;

        public static /* synthetic */ CleanAirEta copy$default(CleanAirEta cleanAirEta, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = cleanAirEta.value;
            }
            return cleanAirEta.copy(i);
        }

        public final int component1() {
            return this.value;
        }

        public final CleanAirEta copy(int i) {
            return new CleanAirEta(i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof CleanAirEta) && this.value == ((CleanAirEta) obj).value;
        }

        public int hashCode() {
            return this.value;
        }

        public String toString() {
            return "CleanAirEta(value=" + this.value + ')';
        }

        public CleanAirEta(int i) {
            super(Integer.valueOf(i), (DefaultConstructorMarker) null);
            this.value = i;
        }

        public Integer getValue() {
            return Integer.valueOf(this.value);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$PanelDisplayMode;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(I)V", "getValue", "()Ljava/lang/Integer;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceStreamAttribute.kt */
    public static final class PanelDisplayMode extends DeviceStreamAttribute<Integer> {
        private final int value;

        public static /* synthetic */ PanelDisplayMode copy$default(PanelDisplayMode panelDisplayMode, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = panelDisplayMode.value;
            }
            return panelDisplayMode.copy(i);
        }

        public final int component1() {
            return this.value;
        }

        public final PanelDisplayMode copy(int i) {
            return new PanelDisplayMode(i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof PanelDisplayMode) && this.value == ((PanelDisplayMode) obj).value;
        }

        public int hashCode() {
            return this.value;
        }

        public String toString() {
            return "PanelDisplayMode(value=" + this.value + ')';
        }

        public PanelDisplayMode(int i) {
            super(Integer.valueOf(i), (DefaultConstructorMarker) null);
            this.value = i;
        }

        public Integer getValue() {
            return Integer.valueOf(this.value);
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$HoverEnabled;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(Z)V", "getValue", "()Ljava/lang/Boolean;", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceStreamAttribute.kt */
    public static final class HoverEnabled extends DeviceStreamAttribute<Boolean> {
        private final boolean value;

        public static /* synthetic */ HoverEnabled copy$default(HoverEnabled hoverEnabled, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = hoverEnabled.value;
            }
            return hoverEnabled.copy(z);
        }

        public final boolean component1() {
            return this.value;
        }

        public final HoverEnabled copy(boolean z) {
            return new HoverEnabled(z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof HoverEnabled) && this.value == ((HoverEnabled) obj).value;
        }

        public int hashCode() {
            return AddDeviceState$$ExternalSyntheticBackport0.m(this.value);
        }

        public String toString() {
            return "HoverEnabled(value=" + this.value + ')';
        }

        public HoverEnabled(boolean z) {
            super(Boolean.valueOf(z), (DefaultConstructorMarker) null);
            this.value = z;
        }

        public Boolean getValue() {
            return Boolean.valueOf(this.value);
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$AirRefreshEnabled;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(Z)V", "getValue", "()Ljava/lang/Boolean;", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceStreamAttribute.kt */
    public static final class AirRefreshEnabled extends DeviceStreamAttribute<Boolean> {
        private final boolean value;

        public static /* synthetic */ AirRefreshEnabled copy$default(AirRefreshEnabled airRefreshEnabled, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = airRefreshEnabled.value;
            }
            return airRefreshEnabled.copy(z);
        }

        public final boolean component1() {
            return this.value;
        }

        public final AirRefreshEnabled copy(boolean z) {
            return new AirRefreshEnabled(z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof AirRefreshEnabled) && this.value == ((AirRefreshEnabled) obj).value;
        }

        public int hashCode() {
            return AddDeviceState$$ExternalSyntheticBackport0.m(this.value);
        }

        public String toString() {
            return "AirRefreshEnabled(value=" + this.value + ')';
        }

        public AirRefreshEnabled(boolean z) {
            super(Boolean.valueOf(z), (DefaultConstructorMarker) null);
            this.value = z;
        }

        public Boolean getValue() {
            return Boolean.valueOf(this.value);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$AirRefreshStatus;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(I)V", "getValue", "()Ljava/lang/Integer;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceStreamAttribute.kt */
    public static final class AirRefreshStatus extends DeviceStreamAttribute<Integer> {
        private final int value;

        public static /* synthetic */ AirRefreshStatus copy$default(AirRefreshStatus airRefreshStatus, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = airRefreshStatus.value;
            }
            return airRefreshStatus.copy(i);
        }

        public final int component1() {
            return this.value;
        }

        public final AirRefreshStatus copy(int i) {
            return new AirRefreshStatus(i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof AirRefreshStatus) && this.value == ((AirRefreshStatus) obj).value;
        }

        public int hashCode() {
            return this.value;
        }

        public String toString() {
            return "AirRefreshStatus(value=" + this.value + ')';
        }

        public AirRefreshStatus(int i) {
            super(Integer.valueOf(i), (DefaultConstructorMarker) null);
            this.value = i;
        }

        public Integer getValue() {
            return Integer.valueOf(this.value);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$AirRefreshDuration;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(I)V", "getValue", "()Ljava/lang/Integer;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceStreamAttribute.kt */
    public static final class AirRefreshDuration extends DeviceStreamAttribute<Integer> {
        private final int value;

        public static /* synthetic */ AirRefreshDuration copy$default(AirRefreshDuration airRefreshDuration, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = airRefreshDuration.value;
            }
            return airRefreshDuration.copy(i);
        }

        public final int component1() {
            return this.value;
        }

        public final AirRefreshDuration copy(int i) {
            return new AirRefreshDuration(i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof AirRefreshDuration) && this.value == ((AirRefreshDuration) obj).value;
        }

        public int hashCode() {
            return this.value;
        }

        public String toString() {
            return "AirRefreshDuration(value=" + this.value + ')';
        }

        public AirRefreshDuration(int i) {
            super(Integer.valueOf(i), (DefaultConstructorMarker) null);
            this.value = i;
        }

        public Integer getValue() {
            return Integer.valueOf(this.value);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$AirRefreshTimeStamp;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(I)V", "getValue", "()Ljava/lang/Integer;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceStreamAttribute.kt */
    public static final class AirRefreshTimeStamp extends DeviceStreamAttribute<Integer> {
        private final int value;

        public static /* synthetic */ AirRefreshTimeStamp copy$default(AirRefreshTimeStamp airRefreshTimeStamp, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = airRefreshTimeStamp.value;
            }
            return airRefreshTimeStamp.copy(i);
        }

        public final int component1() {
            return this.value;
        }

        public final AirRefreshTimeStamp copy(int i) {
            return new AirRefreshTimeStamp(i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof AirRefreshTimeStamp) && this.value == ((AirRefreshTimeStamp) obj).value;
        }

        public int hashCode() {
            return this.value;
        }

        public String toString() {
            return "AirRefreshTimeStamp(value=" + this.value + ')';
        }

        public AirRefreshTimeStamp(int i) {
            super(Integer.valueOf(i), (DefaultConstructorMarker) null);
            this.value = i;
        }

        public Integer getValue() {
            return Integer.valueOf(this.value);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$AirRefreshStartTimeStamp;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(I)V", "getValue", "()Ljava/lang/Integer;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceStreamAttribute.kt */
    public static final class AirRefreshStartTimeStamp extends DeviceStreamAttribute<Integer> {
        private final int value;

        public static /* synthetic */ AirRefreshStartTimeStamp copy$default(AirRefreshStartTimeStamp airRefreshStartTimeStamp, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = airRefreshStartTimeStamp.value;
            }
            return airRefreshStartTimeStamp.copy(i);
        }

        public final int component1() {
            return this.value;
        }

        public final AirRefreshStartTimeStamp copy(int i) {
            return new AirRefreshStartTimeStamp(i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof AirRefreshStartTimeStamp) && this.value == ((AirRefreshStartTimeStamp) obj).value;
        }

        public int hashCode() {
            return this.value;
        }

        public String toString() {
            return "AirRefreshStartTimeStamp(value=" + this.value + ')';
        }

        public AirRefreshStartTimeStamp(int i) {
            super(Integer.valueOf(i), (DefaultConstructorMarker) null);
            this.value = i;
        }

        public Integer getValue() {
            return Integer.valueOf(this.value);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$AirRefreshEndTimeStamp;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(I)V", "getValue", "()Ljava/lang/Integer;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceStreamAttribute.kt */
    public static final class AirRefreshEndTimeStamp extends DeviceStreamAttribute<Integer> {
        private final int value;

        public static /* synthetic */ AirRefreshEndTimeStamp copy$default(AirRefreshEndTimeStamp airRefreshEndTimeStamp, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = airRefreshEndTimeStamp.value;
            }
            return airRefreshEndTimeStamp.copy(i);
        }

        public final int component1() {
            return this.value;
        }

        public final AirRefreshEndTimeStamp copy(int i) {
            return new AirRefreshEndTimeStamp(i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof AirRefreshEndTimeStamp) && this.value == ((AirRefreshEndTimeStamp) obj).value;
        }

        public int hashCode() {
            return this.value;
        }

        public String toString() {
            return "AirRefreshEndTimeStamp(value=" + this.value + ')';
        }

        public AirRefreshEndTimeStamp(int i) {
            super(Integer.valueOf(i), (DefaultConstructorMarker) null);
            this.value = i;
        }

        public Integer getValue() {
            return Integer.valueOf(this.value);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$RoomType;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(I)V", "getValue", "()Ljava/lang/Integer;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceStreamAttribute.kt */
    public static final class RoomType extends DeviceStreamAttribute<Integer> {
        private final int value;

        public static /* synthetic */ RoomType copy$default(RoomType roomType, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = roomType.value;
            }
            return roomType.copy(i);
        }

        public final int component1() {
            return this.value;
        }

        public final RoomType copy(int i) {
            return new RoomType(i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof RoomType) && this.value == ((RoomType) obj).value;
        }

        public int hashCode() {
            return this.value;
        }

        public String toString() {
            return "RoomType(value=" + this.value + ')';
        }

        public RoomType(int i) {
            super(Integer.valueOf(i), (DefaultConstructorMarker) null);
            this.value = i;
        }

        public Integer getValue() {
            return Integer.valueOf(this.value);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$NightLampBrightness;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(I)V", "getValue", "()Ljava/lang/Integer;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceStreamAttribute.kt */
    public static final class NightLampBrightness extends DeviceStreamAttribute<Integer> {
        private final int value;

        public static /* synthetic */ NightLampBrightness copy$default(NightLampBrightness nightLampBrightness, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = nightLampBrightness.value;
            }
            return nightLampBrightness.copy(i);
        }

        public final int component1() {
            return this.value;
        }

        public final NightLampBrightness copy(int i) {
            return new NightLampBrightness(i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof NightLampBrightness) && this.value == ((NightLampBrightness) obj).value;
        }

        public int hashCode() {
            return this.value;
        }

        public String toString() {
            return "NightLampBrightness(value=" + this.value + ')';
        }

        public NightLampBrightness(int i) {
            super(Integer.valueOf(i), (DefaultConstructorMarker) null);
            this.value = i;
        }

        public Integer getValue() {
            return Integer.valueOf(this.value);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$NightLampSteplessBrightness;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(I)V", "getValue", "()Ljava/lang/Integer;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceStreamAttribute.kt */
    public static final class NightLampSteplessBrightness extends DeviceStreamAttribute<Integer> {
        private final int value;

        public static /* synthetic */ NightLampSteplessBrightness copy$default(NightLampSteplessBrightness nightLampSteplessBrightness, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = nightLampSteplessBrightness.value;
            }
            return nightLampSteplessBrightness.copy(i);
        }

        public final int component1() {
            return this.value;
        }

        public final NightLampSteplessBrightness copy(int i) {
            return new NightLampSteplessBrightness(i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof NightLampSteplessBrightness) && this.value == ((NightLampSteplessBrightness) obj).value;
        }

        public int hashCode() {
            return this.value;
        }

        public String toString() {
            return "NightLampSteplessBrightness(value=" + this.value + ')';
        }

        public NightLampSteplessBrightness(int i) {
            super(Integer.valueOf(i), (DefaultConstructorMarker) null);
            this.value = i;
        }

        public Integer getValue() {
            return Integer.valueOf(this.value);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$WickdryDuration;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(I)V", "getValue", "()Ljava/lang/Integer;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceStreamAttribute.kt */
    public static final class WickdryDuration extends DeviceStreamAttribute<Integer> {
        private final int value;

        public static /* synthetic */ WickdryDuration copy$default(WickdryDuration wickdryDuration, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = wickdryDuration.value;
            }
            return wickdryDuration.copy(i);
        }

        public final int component1() {
            return this.value;
        }

        public final WickdryDuration copy(int i) {
            return new WickdryDuration(i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof WickdryDuration) && this.value == ((WickdryDuration) obj).value;
        }

        public int hashCode() {
            return this.value;
        }

        public String toString() {
            return "WickdryDuration(value=" + this.value + ')';
        }

        public WickdryDuration(int i) {
            super(Integer.valueOf(i), (DefaultConstructorMarker) null);
            this.value = i;
        }

        public Integer getValue() {
            return Integer.valueOf(this.value);
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$WickdryDone;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(Z)V", "getValue", "()Ljava/lang/Boolean;", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceStreamAttribute.kt */
    public static final class WickdryDone extends DeviceStreamAttribute<Boolean> {
        private final boolean value;

        public static /* synthetic */ WickdryDone copy$default(WickdryDone wickdryDone, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = wickdryDone.value;
            }
            return wickdryDone.copy(z);
        }

        public final boolean component1() {
            return this.value;
        }

        public final WickdryDone copy(boolean z) {
            return new WickdryDone(z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof WickdryDone) && this.value == ((WickdryDone) obj).value;
        }

        public int hashCode() {
            return AddDeviceState$$ExternalSyntheticBackport0.m(this.value);
        }

        public String toString() {
            return "WickdryDone(value=" + this.value + ')';
        }

        public WickdryDone(boolean z) {
            super(Boolean.valueOf(z), (DefaultConstructorMarker) null);
            this.value = z;
        }

        public Boolean getValue() {
            return Boolean.valueOf(this.value);
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0002\u0010\u0007J\u001a\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0002\u0010\u000bJ\u0013\u0010\f\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u0002X\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$YwrmEnabled;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(Ljava/lang/Boolean;)V", "getValue", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "copy", "(Ljava/lang/Boolean;)Lcom/blueair/core/model/DeviceStreamAttribute$YwrmEnabled;", "equals", "other", "", "hashCode", "", "toString", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceStreamAttribute.kt */
    public static final class YwrmEnabled extends DeviceStreamAttribute<Boolean> {
        private final Boolean value;

        public static /* synthetic */ YwrmEnabled copy$default(YwrmEnabled ywrmEnabled, Boolean bool, int i, Object obj) {
            if ((i & 1) != 0) {
                bool = ywrmEnabled.value;
            }
            return ywrmEnabled.copy(bool);
        }

        public final Boolean component1() {
            return this.value;
        }

        public final YwrmEnabled copy(Boolean bool) {
            return new YwrmEnabled(bool);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof YwrmEnabled) && Intrinsics.areEqual((Object) this.value, (Object) ((YwrmEnabled) obj).value);
        }

        public int hashCode() {
            Boolean bool = this.value;
            if (bool == null) {
                return 0;
            }
            return bool.hashCode();
        }

        public String toString() {
            return "YwrmEnabled(value=" + this.value + ')';
        }

        public YwrmEnabled(Boolean bool) {
            super(bool, (DefaultConstructorMarker) null);
            this.value = bool;
        }

        public Boolean getValue() {
            return this.value;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$YwrmUsage;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(I)V", "getValue", "()Ljava/lang/Integer;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceStreamAttribute.kt */
    public static final class YwrmUsage extends DeviceStreamAttribute<Integer> {
        private final int value;

        public static /* synthetic */ YwrmUsage copy$default(YwrmUsage ywrmUsage, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = ywrmUsage.value;
            }
            return ywrmUsage.copy(i);
        }

        public final int component1() {
            return this.value;
        }

        public final YwrmUsage copy(int i) {
            return new YwrmUsage(i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof YwrmUsage) && this.value == ((YwrmUsage) obj).value;
        }

        public int hashCode() {
            return this.value;
        }

        public String toString() {
            return "YwrmUsage(value=" + this.value + ')';
        }

        public YwrmUsage(int i) {
            super(Integer.valueOf(i), (DefaultConstructorMarker) null);
            this.value = i;
        }

        public Integer getValue() {
            return Integer.valueOf(this.value);
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00020\u0001B\u0017\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002HÆ\u0003J\u001b\u0010\n\u001a\u00020\u00002\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u001c\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$Alarms;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "Lcom/blueair/core/model/DeviceAlarm;", "value", "<init>", "(Ljava/util/List;)V", "getValue", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceStreamAttribute.kt */
    public static final class Alarms extends DeviceStreamAttribute<List<? extends DeviceAlarm>> {
        private final List<DeviceAlarm> value;

        public static /* synthetic */ Alarms copy$default(Alarms alarms, List<DeviceAlarm> list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = alarms.value;
            }
            return alarms.copy(list);
        }

        public final List<DeviceAlarm> component1() {
            return this.value;
        }

        public final Alarms copy(List<DeviceAlarm> list) {
            Intrinsics.checkNotNullParameter(list, "value");
            return new Alarms(list);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Alarms) && Intrinsics.areEqual((Object) this.value, (Object) ((Alarms) obj).value);
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        public String toString() {
            return "Alarms(value=" + this.value + ')';
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Alarms(List<DeviceAlarm> list) {
            super(list, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(list, "value");
            this.value = list;
        }

        public List<DeviceAlarm> getValue() {
            return this.value;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$HumSubMode;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(I)V", "getValue", "()Ljava/lang/Integer;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceStreamAttribute.kt */
    public static final class HumSubMode extends DeviceStreamAttribute<Integer> {
        private final int value;

        public static /* synthetic */ HumSubMode copy$default(HumSubMode humSubMode, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = humSubMode.value;
            }
            return humSubMode.copy(i);
        }

        public final int component1() {
            return this.value;
        }

        public final HumSubMode copy(int i) {
            return new HumSubMode(i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof HumSubMode) && this.value == ((HumSubMode) obj).value;
        }

        public int hashCode() {
            return this.value;
        }

        public String toString() {
            return "HumSubMode(value=" + this.value + ')';
        }

        public HumSubMode(int i) {
            super(Integer.valueOf(i), (DefaultConstructorMarker) null);
            this.value = i;
        }

        public Integer getValue() {
            return Integer.valueOf(this.value);
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$Use24Hour;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(Z)V", "getValue", "()Ljava/lang/Boolean;", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceStreamAttribute.kt */
    public static final class Use24Hour extends DeviceStreamAttribute<Boolean> {
        private final boolean value;

        public static /* synthetic */ Use24Hour copy$default(Use24Hour use24Hour, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = use24Hour.value;
            }
            return use24Hour.copy(z);
        }

        public final boolean component1() {
            return this.value;
        }

        public final Use24Hour copy(boolean z) {
            return new Use24Hour(z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Use24Hour) && this.value == ((Use24Hour) obj).value;
        }

        public int hashCode() {
            return AddDeviceState$$ExternalSyntheticBackport0.m(this.value);
        }

        public String toString() {
            return "Use24Hour(value=" + this.value + ')';
        }

        public Use24Hour(boolean z) {
            super(Boolean.valueOf(z), (DefaultConstructorMarker) null);
            this.value = z;
        }

        public Boolean getValue() {
            return Boolean.valueOf(this.value);
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$WaterInfill;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(Z)V", "getValue", "()Ljava/lang/Boolean;", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceStreamAttribute.kt */
    public static final class WaterInfill extends DeviceStreamAttribute<Boolean> {
        private final boolean value;

        public static /* synthetic */ WaterInfill copy$default(WaterInfill waterInfill, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = waterInfill.value;
            }
            return waterInfill.copy(z);
        }

        public final boolean component1() {
            return this.value;
        }

        public final WaterInfill copy(boolean z) {
            return new WaterInfill(z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof WaterInfill) && this.value == ((WaterInfill) obj).value;
        }

        public int hashCode() {
            return AddDeviceState$$ExternalSyntheticBackport0.m(this.value);
        }

        public String toString() {
            return "WaterInfill(value=" + this.value + ')';
        }

        public WaterInfill(boolean z) {
            super(Boolean.valueOf(z), (DefaultConstructorMarker) null);
            this.value = z;
        }

        public Boolean getValue() {
            return Boolean.valueOf(this.value);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$SensorMode;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(I)V", "getValue", "()Ljava/lang/Integer;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceStreamAttribute.kt */
    public static final class SensorMode extends DeviceStreamAttribute<Integer> {
        private final int value;

        public static /* synthetic */ SensorMode copy$default(SensorMode sensorMode, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = sensorMode.value;
            }
            return sensorMode.copy(i);
        }

        public final int component1() {
            return this.value;
        }

        public final SensorMode copy(int i) {
            return new SensorMode(i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof SensorMode) && this.value == ((SensorMode) obj).value;
        }

        public int hashCode() {
            return this.value;
        }

        public String toString() {
            return "SensorMode(value=" + this.value + ')';
        }

        public SensorMode(int i) {
            super(Integer.valueOf(i), (DefaultConstructorMarker) null);
            this.value = i;
        }

        public Integer getValue() {
            return Integer.valueOf(this.value);
        }
    }
}
