package com.blueair.database;

import com.blueair.core.model.DeviceAlarm;
import com.blueair.core.model.DeviceStreamAttribute;
import com.blueair.core.model.IndoorDatapoint;
import com.blueair.core.model.WelcomeHomeLocation;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\bc\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 e*\u0004\b\u0000\u0010\u00012\u00020\u0002:a\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdeB\t\b\u0004¢\u0006\u0004\b\u0003\u0010\u0004\u0001¤\u0001fghijklmnopqrstuvwxyz{|}~\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001 \u0001¡\u0001¢\u0001£\u0001¤\u0001¥\u0001¦\u0001§\u0001¨\u0001©\u0001ª\u0001«\u0001¬\u0001­\u0001®\u0001¯\u0001°\u0001±\u0001²\u0001³\u0001´\u0001µ\u0001¶\u0001·\u0001¸\u0001¹\u0001º\u0001»\u0001¼\u0001½\u0001¾\u0001¿\u0001À\u0001Á\u0001Â\u0001Ã\u0001Ä\u0001¨\u0006Å\u0001"}, d2 = {"Lcom/blueair/database/DeviceField;", "T", "", "<init>", "()V", "Name", "LatestSensorDataPoint", "SelectedSensor", "FanSpeed", "FanSpeedAndAutoMode", "AutoMode", "Brightness", "ChildLock", "LinkedDeviceUid", "ConnectivityStatus", "UpdateProgress", "FilterLife", "SensorRange", "WifiFirmware", "McuFirmware", "Unknown", "StandbyMode", "G4NightMode", "GermShieldMode", "SerialNumber", "FilterTrigger", "G4NightModeFilterTrigger", "SafetySwitch", "MacAddress", "ModelName", "FilterType", "DeviceType", "DeviceSKU", "DeviceCompatibility", "DeviceWelcomeHome", "Disinfection", "DisinfectLeftTime", "GermShieldNightMode", "DeviceTimezone", "EcoMode", "HinsMode", "HinsNightMode", "WickdryEnabled", "WickdryOn", "WickdryLeftTime", "WickUsage", "WaterShortage", "AutoRh", "TimerStatus", "TimerDuration", "TimerLeftTime", "TemperatureUnit", "OscillationState", "OscillationAngle", "OscillationDirection", "OscillationFanSpeed", "MainMode", "ApSubMode", "ApFanSpeed", "HeatSubMode", "HeatFanSpeed", "HeatAutoTmp", "HeatEcoTmp", "CoolSubMode", "CoolFanSpeed", "CoolAutoTag", "CoolAutoPresets", "CoolEcoTag", "CoolEcoPresets", "LocationId", "Mode", "HumMode", "WaterLevel", "Hardware", "DehSubMode", "WaterTankFailure", "SmartSubMode", "DetectCat", "CleanAirEta", "PanelDisplayMode", "HoverEnabled", "AirRefreshEnabled", "AirRefreshStatus", "AirRefreshDuration", "AirRefreshTimeStamp", "AirRefreshStartTimeStamp", "AirRefreshEndTimeStamp", "RoomType", "BodyMounted", "NightLampBrightness", "WickdryDuration", "WickdryDone", "YwrmEnabled", "YwrmUsage", "NightLampSteplessBrightness", "Alarms", "HumSubMode", "Use24Hour", "WaterInfill", "SensorMode", "SensorRanges", "Companion", "Lcom/blueair/database/DeviceField$AirRefreshDuration;", "Lcom/blueair/database/DeviceField$AirRefreshEnabled;", "Lcom/blueair/database/DeviceField$AirRefreshEndTimeStamp;", "Lcom/blueair/database/DeviceField$AirRefreshStartTimeStamp;", "Lcom/blueair/database/DeviceField$AirRefreshStatus;", "Lcom/blueair/database/DeviceField$AirRefreshTimeStamp;", "Lcom/blueair/database/DeviceField$Alarms;", "Lcom/blueair/database/DeviceField$ApFanSpeed;", "Lcom/blueair/database/DeviceField$ApSubMode;", "Lcom/blueair/database/DeviceField$AutoMode;", "Lcom/blueair/database/DeviceField$AutoRh;", "Lcom/blueair/database/DeviceField$BodyMounted;", "Lcom/blueair/database/DeviceField$Brightness;", "Lcom/blueair/database/DeviceField$ChildLock;", "Lcom/blueair/database/DeviceField$CleanAirEta;", "Lcom/blueair/database/DeviceField$ConnectivityStatus;", "Lcom/blueair/database/DeviceField$CoolAutoPresets;", "Lcom/blueair/database/DeviceField$CoolAutoTag;", "Lcom/blueair/database/DeviceField$CoolEcoPresets;", "Lcom/blueair/database/DeviceField$CoolEcoTag;", "Lcom/blueair/database/DeviceField$CoolFanSpeed;", "Lcom/blueair/database/DeviceField$CoolSubMode;", "Lcom/blueair/database/DeviceField$DehSubMode;", "Lcom/blueair/database/DeviceField$DetectCat;", "Lcom/blueair/database/DeviceField$DeviceCompatibility;", "Lcom/blueair/database/DeviceField$DeviceSKU;", "Lcom/blueair/database/DeviceField$DeviceTimezone;", "Lcom/blueair/database/DeviceField$DeviceType;", "Lcom/blueair/database/DeviceField$DeviceWelcomeHome;", "Lcom/blueair/database/DeviceField$DisinfectLeftTime;", "Lcom/blueair/database/DeviceField$Disinfection;", "Lcom/blueair/database/DeviceField$EcoMode;", "Lcom/blueair/database/DeviceField$FanSpeed;", "Lcom/blueair/database/DeviceField$FanSpeedAndAutoMode;", "Lcom/blueair/database/DeviceField$FilterLife;", "Lcom/blueair/database/DeviceField$FilterTrigger;", "Lcom/blueair/database/DeviceField$FilterType;", "Lcom/blueair/database/DeviceField$G4NightMode;", "Lcom/blueair/database/DeviceField$G4NightModeFilterTrigger;", "Lcom/blueair/database/DeviceField$GermShieldMode;", "Lcom/blueair/database/DeviceField$GermShieldNightMode;", "Lcom/blueair/database/DeviceField$Hardware;", "Lcom/blueair/database/DeviceField$HeatAutoTmp;", "Lcom/blueair/database/DeviceField$HeatEcoTmp;", "Lcom/blueair/database/DeviceField$HeatFanSpeed;", "Lcom/blueair/database/DeviceField$HeatSubMode;", "Lcom/blueair/database/DeviceField$HinsMode;", "Lcom/blueair/database/DeviceField$HinsNightMode;", "Lcom/blueair/database/DeviceField$HoverEnabled;", "Lcom/blueair/database/DeviceField$HumMode;", "Lcom/blueair/database/DeviceField$HumSubMode;", "Lcom/blueair/database/DeviceField$LatestSensorDataPoint;", "Lcom/blueair/database/DeviceField$LinkedDeviceUid;", "Lcom/blueair/database/DeviceField$LocationId;", "Lcom/blueair/database/DeviceField$MacAddress;", "Lcom/blueair/database/DeviceField$MainMode;", "Lcom/blueair/database/DeviceField$McuFirmware;", "Lcom/blueair/database/DeviceField$Mode;", "Lcom/blueair/database/DeviceField$ModelName;", "Lcom/blueair/database/DeviceField$Name;", "Lcom/blueair/database/DeviceField$NightLampBrightness;", "Lcom/blueair/database/DeviceField$NightLampSteplessBrightness;", "Lcom/blueair/database/DeviceField$OscillationAngle;", "Lcom/blueair/database/DeviceField$OscillationDirection;", "Lcom/blueair/database/DeviceField$OscillationFanSpeed;", "Lcom/blueair/database/DeviceField$OscillationState;", "Lcom/blueair/database/DeviceField$PanelDisplayMode;", "Lcom/blueair/database/DeviceField$RoomType;", "Lcom/blueair/database/DeviceField$SafetySwitch;", "Lcom/blueair/database/DeviceField$SelectedSensor;", "Lcom/blueair/database/DeviceField$SensorMode;", "Lcom/blueair/database/DeviceField$SensorRange;", "Lcom/blueair/database/DeviceField$SerialNumber;", "Lcom/blueair/database/DeviceField$SmartSubMode;", "Lcom/blueair/database/DeviceField$StandbyMode;", "Lcom/blueair/database/DeviceField$TemperatureUnit;", "Lcom/blueair/database/DeviceField$TimerDuration;", "Lcom/blueair/database/DeviceField$TimerLeftTime;", "Lcom/blueair/database/DeviceField$TimerStatus;", "Lcom/blueair/database/DeviceField$Unknown;", "Lcom/blueair/database/DeviceField$UpdateProgress;", "Lcom/blueair/database/DeviceField$Use24Hour;", "Lcom/blueair/database/DeviceField$WaterInfill;", "Lcom/blueair/database/DeviceField$WaterLevel;", "Lcom/blueair/database/DeviceField$WaterShortage;", "Lcom/blueair/database/DeviceField$WaterTankFailure;", "Lcom/blueair/database/DeviceField$WickUsage;", "Lcom/blueair/database/DeviceField$WickdryDone;", "Lcom/blueair/database/DeviceField$WickdryDuration;", "Lcom/blueair/database/DeviceField$WickdryEnabled;", "Lcom/blueair/database/DeviceField$WickdryLeftTime;", "Lcom/blueair/database/DeviceField$WickdryOn;", "Lcom/blueair/database/DeviceField$WifiFirmware;", "Lcom/blueair/database/DeviceField$YwrmEnabled;", "Lcom/blueair/database/DeviceField$YwrmUsage;", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceField.kt */
public abstract class DeviceField<T> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    public /* synthetic */ DeviceField(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private DeviceField() {
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/database/DeviceField$Name;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceField.kt */
    public static final class Name extends DeviceField<String> {
        public static final Name INSTANCE = new Name();

        private Name() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/database/DeviceField$LatestSensorDataPoint;", "Lcom/blueair/database/DeviceField;", "Lcom/blueair/core/model/IndoorDatapoint;", "<init>", "()V", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceField.kt */
    public static final class LatestSensorDataPoint extends DeviceField<IndoorDatapoint> {
        public static final LatestSensorDataPoint INSTANCE = new LatestSensorDataPoint();

        private LatestSensorDataPoint() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/database/DeviceField$SelectedSensor;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceField.kt */
    public static final class SelectedSensor extends DeviceField<Integer> {
        public static final SelectedSensor INSTANCE = new SelectedSensor();

        private SelectedSensor() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/database/DeviceField$FanSpeed;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceField.kt */
    public static final class FanSpeed extends DeviceField<Integer> {
        public static final FanSpeed INSTANCE = new FanSpeed();

        private FanSpeed() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/database/DeviceField$FanSpeedAndAutoMode;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceField.kt */
    public static final class FanSpeedAndAutoMode extends DeviceField<Integer> {
        public static final FanSpeedAndAutoMode INSTANCE = new FanSpeedAndAutoMode();

        private FanSpeedAndAutoMode() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/database/DeviceField$AutoMode;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceField.kt */
    public static final class AutoMode extends DeviceField<Object> {
        public static final AutoMode INSTANCE = new AutoMode();

        private AutoMode() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/database/DeviceField$Brightness;", "Lcom/blueair/database/DeviceField;", "Lcom/blueair/core/model/Brightness;", "<init>", "()V", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceField.kt */
    public static final class Brightness extends DeviceField<com.blueair.core.model.Brightness> {
        public static final Brightness INSTANCE = new Brightness();

        private Brightness() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/database/DeviceField$ChildLock;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceField.kt */
    public static final class ChildLock extends DeviceField<Boolean> {
        public static final ChildLock INSTANCE = new ChildLock();

        private ChildLock() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/database/DeviceField$LinkedDeviceUid;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceField.kt */
    public static final class LinkedDeviceUid extends DeviceField<String> {
        public static final LinkedDeviceUid INSTANCE = new LinkedDeviceUid();

        private LinkedDeviceUid() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/database/DeviceField$ConnectivityStatus;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceField.kt */
    public static final class ConnectivityStatus extends DeviceField<Integer> {
        public static final ConnectivityStatus INSTANCE = new ConnectivityStatus();

        private ConnectivityStatus() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/database/DeviceField$UpdateProgress;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceField.kt */
    public static final class UpdateProgress extends DeviceField<Integer> {
        public static final UpdateProgress INSTANCE = new UpdateProgress();

        private UpdateProgress() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/database/DeviceField$FilterLife;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceField.kt */
    public static final class FilterLife extends DeviceField<Integer> {
        public static final FilterLife INSTANCE = new FilterLife();

        private FilterLife() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/database/DeviceField$SensorRange;", "Lcom/blueair/database/DeviceField;", "Lcom/blueair/database/DeviceField$SensorRanges;", "<init>", "()V", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceField.kt */
    public static final class SensorRange extends DeviceField<SensorRanges> {
        public static final SensorRange INSTANCE = new SensorRange();

        private SensorRange() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/database/DeviceField$WifiFirmware;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceField.kt */
    public static final class WifiFirmware extends DeviceField<String> {
        public static final WifiFirmware INSTANCE = new WifiFirmware();

        private WifiFirmware() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/database/DeviceField$McuFirmware;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceField.kt */
    public static final class McuFirmware extends DeviceField<String> {
        public static final McuFirmware INSTANCE = new McuFirmware();

        private McuFirmware() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/database/DeviceField$Unknown;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceField.kt */
    public static final class Unknown extends DeviceField<Boolean> {
        public static final Unknown INSTANCE = new Unknown();

        private Unknown() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/database/DeviceField$StandbyMode;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceField.kt */
    public static final class StandbyMode extends DeviceField<Boolean> {
        public static final StandbyMode INSTANCE = new StandbyMode();

        private StandbyMode() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/database/DeviceField$G4NightMode;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceField.kt */
    public static final class G4NightMode extends DeviceField<Boolean> {
        public static final G4NightMode INSTANCE = new G4NightMode();

        private G4NightMode() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/database/DeviceField$GermShieldMode;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceField.kt */
    public static final class GermShieldMode extends DeviceField<Boolean> {
        public static final GermShieldMode INSTANCE = new GermShieldMode();

        private GermShieldMode() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/database/DeviceField$SerialNumber;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceField.kt */
    public static final class SerialNumber extends DeviceField<String> {
        public static final SerialNumber INSTANCE = new SerialNumber();

        private SerialNumber() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/database/DeviceField$FilterTrigger;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceField.kt */
    public static final class FilterTrigger extends DeviceField<String> {
        public static final FilterTrigger INSTANCE = new FilterTrigger();

        private FilterTrigger() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/database/DeviceField$G4NightModeFilterTrigger;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceField.kt */
    public static final class G4NightModeFilterTrigger extends DeviceField<String> {
        public static final G4NightModeFilterTrigger INSTANCE = new G4NightModeFilterTrigger();

        private G4NightModeFilterTrigger() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/database/DeviceField$SafetySwitch;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceField.kt */
    public static final class SafetySwitch extends DeviceField<Boolean> {
        public static final SafetySwitch INSTANCE = new SafetySwitch();

        private SafetySwitch() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/database/DeviceField$MacAddress;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceField.kt */
    public static final class MacAddress extends DeviceField<String> {
        public static final MacAddress INSTANCE = new MacAddress();

        private MacAddress() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/database/DeviceField$ModelName;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceField.kt */
    public static final class ModelName extends DeviceField<String> {
        public static final ModelName INSTANCE = new ModelName();

        private ModelName() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/database/DeviceField$FilterType;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceField.kt */
    public static final class FilterType extends DeviceField<String> {
        public static final FilterType INSTANCE = new FilterType();

        private FilterType() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/database/DeviceField$DeviceType;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceField.kt */
    public static final class DeviceType extends DeviceField<Integer> {
        public static final DeviceType INSTANCE = new DeviceType();

        private DeviceType() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/database/DeviceField$DeviceSKU;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceField.kt */
    public static final class DeviceSKU extends DeviceField<String> {
        public static final DeviceSKU INSTANCE = new DeviceSKU();

        private DeviceSKU() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/database/DeviceField$DeviceCompatibility;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceField.kt */
    public static final class DeviceCompatibility extends DeviceField<String> {
        public static final DeviceCompatibility INSTANCE = new DeviceCompatibility();

        private DeviceCompatibility() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/database/DeviceField$DeviceWelcomeHome;", "Lcom/blueair/database/DeviceField;", "Lcom/blueair/core/model/WelcomeHomeLocation;", "<init>", "()V", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceField.kt */
    public static final class DeviceWelcomeHome extends DeviceField<WelcomeHomeLocation> {
        public static final DeviceWelcomeHome INSTANCE = new DeviceWelcomeHome();

        private DeviceWelcomeHome() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/database/DeviceField$Disinfection;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceField.kt */
    public static final class Disinfection extends DeviceField<Boolean> {
        public static final Disinfection INSTANCE = new Disinfection();

        private Disinfection() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/blueair/database/DeviceField$DisinfectLeftTime;", "Lcom/blueair/database/DeviceField;", "Lkotlin/Pair;", "", "", "<init>", "()V", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceField.kt */
    public static final class DisinfectLeftTime extends DeviceField<Pair<? extends Integer, ? extends Long>> {
        public static final DisinfectLeftTime INSTANCE = new DisinfectLeftTime();

        private DisinfectLeftTime() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/database/DeviceField$GermShieldNightMode;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceField.kt */
    public static final class GermShieldNightMode extends DeviceField<Boolean> {
        public static final GermShieldNightMode INSTANCE = new GermShieldNightMode();

        private GermShieldNightMode() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/database/DeviceField$DeviceTimezone;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceField.kt */
    public static final class DeviceTimezone extends DeviceField<String> {
        public static final DeviceTimezone INSTANCE = new DeviceTimezone();

        private DeviceTimezone() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/database/DeviceField$EcoMode;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceField.kt */
    public static final class EcoMode extends DeviceField<Boolean> {
        public static final EcoMode INSTANCE = new EcoMode();

        private EcoMode() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/database/DeviceField$HinsMode;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceField.kt */
    public static final class HinsMode extends DeviceField<Boolean> {
        public static final HinsMode INSTANCE = new HinsMode();

        private HinsMode() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/database/DeviceField$HinsNightMode;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceField.kt */
    public static final class HinsNightMode extends DeviceField<Boolean> {
        public static final HinsNightMode INSTANCE = new HinsNightMode();

        private HinsNightMode() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/database/DeviceField$WickdryEnabled;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceField.kt */
    public static final class WickdryEnabled extends DeviceField<Boolean> {
        public static final WickdryEnabled INSTANCE = new WickdryEnabled();

        private WickdryEnabled() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/database/DeviceField$WickdryOn;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceField.kt */
    public static final class WickdryOn extends DeviceField<Boolean> {
        public static final WickdryOn INSTANCE = new WickdryOn();

        private WickdryOn() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/blueair/database/DeviceField$WickdryLeftTime;", "Lcom/blueair/database/DeviceField;", "Lkotlin/Pair;", "", "", "<init>", "()V", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceField.kt */
    public static final class WickdryLeftTime extends DeviceField<Pair<? extends Integer, ? extends Long>> {
        public static final WickdryLeftTime INSTANCE = new WickdryLeftTime();

        private WickdryLeftTime() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/database/DeviceField$WickUsage;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceField.kt */
    public static final class WickUsage extends DeviceField<Integer> {
        public static final WickUsage INSTANCE = new WickUsage();

        private WickUsage() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/database/DeviceField$WaterShortage;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceField.kt */
    public static final class WaterShortage extends DeviceField<Boolean> {
        public static final WaterShortage INSTANCE = new WaterShortage();

        private WaterShortage() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/database/DeviceField$AutoRh;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceField.kt */
    public static final class AutoRh extends DeviceField<Integer> {
        public static final AutoRh INSTANCE = new AutoRh();

        private AutoRh() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/database/DeviceField$TimerStatus;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceField.kt */
    public static final class TimerStatus extends DeviceField<Integer> {
        public static final TimerStatus INSTANCE = new TimerStatus();

        private TimerStatus() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/database/DeviceField$TimerDuration;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceField.kt */
    public static final class TimerDuration extends DeviceField<Integer> {
        public static final TimerDuration INSTANCE = new TimerDuration();

        private TimerDuration() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/blueair/database/DeviceField$TimerLeftTime;", "Lcom/blueair/database/DeviceField;", "Lkotlin/Pair;", "", "", "<init>", "()V", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceField.kt */
    public static final class TimerLeftTime extends DeviceField<Pair<? extends Integer, ? extends Long>> {
        public static final TimerLeftTime INSTANCE = new TimerLeftTime();

        private TimerLeftTime() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/database/DeviceField$TemperatureUnit;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceField.kt */
    public static final class TemperatureUnit extends DeviceField<Integer> {
        public static final TemperatureUnit INSTANCE = new TemperatureUnit();

        private TemperatureUnit() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/database/DeviceField$OscillationState;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceField.kt */
    public static final class OscillationState extends DeviceField<Integer> {
        public static final OscillationState INSTANCE = new OscillationState();

        private OscillationState() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/database/DeviceField$OscillationAngle;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceField.kt */
    public static final class OscillationAngle extends DeviceField<Integer> {
        public static final OscillationAngle INSTANCE = new OscillationAngle();

        private OscillationAngle() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/database/DeviceField$OscillationDirection;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceField.kt */
    public static final class OscillationDirection extends DeviceField<Integer> {
        public static final OscillationDirection INSTANCE = new OscillationDirection();

        private OscillationDirection() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/database/DeviceField$OscillationFanSpeed;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceField.kt */
    public static final class OscillationFanSpeed extends DeviceField<Integer> {
        public static final OscillationFanSpeed INSTANCE = new OscillationFanSpeed();

        private OscillationFanSpeed() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/database/DeviceField$MainMode;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceField.kt */
    public static final class MainMode extends DeviceField<Integer> {
        public static final MainMode INSTANCE = new MainMode();

        private MainMode() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/database/DeviceField$ApSubMode;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceField.kt */
    public static final class ApSubMode extends DeviceField<Integer> {
        public static final ApSubMode INSTANCE = new ApSubMode();

        private ApSubMode() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/database/DeviceField$ApFanSpeed;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceField.kt */
    public static final class ApFanSpeed extends DeviceField<Integer> {
        public static final ApFanSpeed INSTANCE = new ApFanSpeed();

        private ApFanSpeed() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/database/DeviceField$HeatSubMode;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceField.kt */
    public static final class HeatSubMode extends DeviceField<Integer> {
        public static final HeatSubMode INSTANCE = new HeatSubMode();

        private HeatSubMode() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/database/DeviceField$HeatFanSpeed;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceField.kt */
    public static final class HeatFanSpeed extends DeviceField<Integer> {
        public static final HeatFanSpeed INSTANCE = new HeatFanSpeed();

        private HeatFanSpeed() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/database/DeviceField$HeatAutoTmp;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceField.kt */
    public static final class HeatAutoTmp extends DeviceField<Double> {
        public static final HeatAutoTmp INSTANCE = new HeatAutoTmp();

        private HeatAutoTmp() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/database/DeviceField$HeatEcoTmp;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceField.kt */
    public static final class HeatEcoTmp extends DeviceField<Double> {
        public static final HeatEcoTmp INSTANCE = new HeatEcoTmp();

        private HeatEcoTmp() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/database/DeviceField$CoolSubMode;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceField.kt */
    public static final class CoolSubMode extends DeviceField<Integer> {
        public static final CoolSubMode INSTANCE = new CoolSubMode();

        private CoolSubMode() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/database/DeviceField$CoolFanSpeed;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceField.kt */
    public static final class CoolFanSpeed extends DeviceField<Integer> {
        public static final CoolFanSpeed INSTANCE = new CoolFanSpeed();

        private CoolFanSpeed() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/database/DeviceField$CoolAutoTag;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceField.kt */
    public static final class CoolAutoTag extends DeviceField<Integer> {
        public static final CoolAutoTag INSTANCE = new CoolAutoTag();

        private CoolAutoTag() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0013\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/database/DeviceField$CoolAutoPresets;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceField.kt */
    public static final class CoolAutoPresets extends DeviceField<double[]> {
        public static final CoolAutoPresets INSTANCE = new CoolAutoPresets();

        private CoolAutoPresets() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/database/DeviceField$CoolEcoTag;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceField.kt */
    public static final class CoolEcoTag extends DeviceField<Integer> {
        public static final CoolEcoTag INSTANCE = new CoolEcoTag();

        private CoolEcoTag() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0013\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/database/DeviceField$CoolEcoPresets;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceField.kt */
    public static final class CoolEcoPresets extends DeviceField<double[]> {
        public static final CoolEcoPresets INSTANCE = new CoolEcoPresets();

        private CoolEcoPresets() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0013\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/database/DeviceField$LocationId;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceField.kt */
    public static final class LocationId extends DeviceField<double[]> {
        public static final LocationId INSTANCE = new LocationId();

        private LocationId() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/database/DeviceField$Mode;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceField.kt */
    public static final class Mode extends DeviceField<Integer> {
        public static final Mode INSTANCE = new Mode();

        private Mode() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/database/DeviceField$HumMode;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceField.kt */
    public static final class HumMode extends DeviceField<Boolean> {
        public static final HumMode INSTANCE = new HumMode();

        private HumMode() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/database/DeviceField$WaterLevel;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceField.kt */
    public static final class WaterLevel extends DeviceField<Integer> {
        public static final WaterLevel INSTANCE = new WaterLevel();

        private WaterLevel() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/database/DeviceField$Hardware;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceField.kt */
    public static final class Hardware extends DeviceField<String> {
        public static final Hardware INSTANCE = new Hardware();

        private Hardware() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/database/DeviceField$DehSubMode;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceField.kt */
    public static final class DehSubMode extends DeviceField<Integer> {
        public static final DehSubMode INSTANCE = new DehSubMode();

        private DehSubMode() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/database/DeviceField$WaterTankFailure;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceField.kt */
    public static final class WaterTankFailure extends DeviceField<Boolean> {
        public static final WaterTankFailure INSTANCE = new WaterTankFailure();

        private WaterTankFailure() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/database/DeviceField$SmartSubMode;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceField.kt */
    public static final class SmartSubMode extends DeviceField<Integer> {
        public static final SmartSubMode INSTANCE = new SmartSubMode();

        private SmartSubMode() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/database/DeviceField$DetectCat;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceField.kt */
    public static final class DetectCat extends DeviceField<Boolean> {
        public static final DetectCat INSTANCE = new DetectCat();

        private DetectCat() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/database/DeviceField$CleanAirEta;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceField.kt */
    public static final class CleanAirEta extends DeviceField<Integer> {
        public static final CleanAirEta INSTANCE = new CleanAirEta();

        private CleanAirEta() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/database/DeviceField$PanelDisplayMode;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceField.kt */
    public static final class PanelDisplayMode extends DeviceField<Integer> {
        public static final PanelDisplayMode INSTANCE = new PanelDisplayMode();

        private PanelDisplayMode() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/database/DeviceField$HoverEnabled;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceField.kt */
    public static final class HoverEnabled extends DeviceField<Boolean> {
        public static final HoverEnabled INSTANCE = new HoverEnabled();

        private HoverEnabled() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/database/DeviceField$AirRefreshEnabled;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceField.kt */
    public static final class AirRefreshEnabled extends DeviceField<Boolean> {
        public static final AirRefreshEnabled INSTANCE = new AirRefreshEnabled();

        private AirRefreshEnabled() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/database/DeviceField$AirRefreshStatus;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceField.kt */
    public static final class AirRefreshStatus extends DeviceField<Integer> {
        public static final AirRefreshStatus INSTANCE = new AirRefreshStatus();

        private AirRefreshStatus() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/database/DeviceField$AirRefreshDuration;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceField.kt */
    public static final class AirRefreshDuration extends DeviceField<Integer> {
        public static final AirRefreshDuration INSTANCE = new AirRefreshDuration();

        private AirRefreshDuration() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/database/DeviceField$AirRefreshTimeStamp;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceField.kt */
    public static final class AirRefreshTimeStamp extends DeviceField<Integer> {
        public static final AirRefreshTimeStamp INSTANCE = new AirRefreshTimeStamp();

        private AirRefreshTimeStamp() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/database/DeviceField$AirRefreshStartTimeStamp;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceField.kt */
    public static final class AirRefreshStartTimeStamp extends DeviceField<Integer> {
        public static final AirRefreshStartTimeStamp INSTANCE = new AirRefreshStartTimeStamp();

        private AirRefreshStartTimeStamp() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/database/DeviceField$AirRefreshEndTimeStamp;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceField.kt */
    public static final class AirRefreshEndTimeStamp extends DeviceField<Integer> {
        public static final AirRefreshEndTimeStamp INSTANCE = new AirRefreshEndTimeStamp();

        private AirRefreshEndTimeStamp() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/database/DeviceField$RoomType;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceField.kt */
    public static final class RoomType extends DeviceField<Integer> {
        public static final RoomType INSTANCE = new RoomType();

        private RoomType() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/database/DeviceField$BodyMounted;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceField.kt */
    public static final class BodyMounted extends DeviceField<Boolean> {
        public static final BodyMounted INSTANCE = new BodyMounted();

        private BodyMounted() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/database/DeviceField$NightLampBrightness;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceField.kt */
    public static final class NightLampBrightness extends DeviceField<Integer> {
        public static final NightLampBrightness INSTANCE = new NightLampBrightness();

        private NightLampBrightness() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/database/DeviceField$WickdryDuration;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceField.kt */
    public static final class WickdryDuration extends DeviceField<Integer> {
        public static final WickdryDuration INSTANCE = new WickdryDuration();

        private WickdryDuration() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/database/DeviceField$WickdryDone;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceField.kt */
    public static final class WickdryDone extends DeviceField<Boolean> {
        public static final WickdryDone INSTANCE = new WickdryDone();

        private WickdryDone() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/database/DeviceField$YwrmEnabled;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceField.kt */
    public static final class YwrmEnabled extends DeviceField<Boolean> {
        public static final YwrmEnabled INSTANCE = new YwrmEnabled();

        private YwrmEnabled() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/database/DeviceField$YwrmUsage;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceField.kt */
    public static final class YwrmUsage extends DeviceField<Integer> {
        public static final YwrmUsage INSTANCE = new YwrmUsage();

        private YwrmUsage() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/database/DeviceField$NightLampSteplessBrightness;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceField.kt */
    public static final class NightLampSteplessBrightness extends DeviceField<Integer> {
        public static final NightLampSteplessBrightness INSTANCE = new NightLampSteplessBrightness();

        private NightLampSteplessBrightness() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/database/DeviceField$Alarms;", "Lcom/blueair/database/DeviceField;", "", "Lcom/blueair/core/model/DeviceAlarm;", "<init>", "()V", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceField.kt */
    public static final class Alarms extends DeviceField<List<? extends DeviceAlarm>> {
        public static final Alarms INSTANCE = new Alarms();

        private Alarms() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/database/DeviceField$HumSubMode;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceField.kt */
    public static final class HumSubMode extends DeviceField<Integer> {
        public static final HumSubMode INSTANCE = new HumSubMode();

        private HumSubMode() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/database/DeviceField$Use24Hour;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceField.kt */
    public static final class Use24Hour extends DeviceField<Boolean> {
        public static final Use24Hour INSTANCE = new Use24Hour();

        private Use24Hour() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/database/DeviceField$WaterInfill;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceField.kt */
    public static final class WaterInfill extends DeviceField<Boolean> {
        public static final WaterInfill INSTANCE = new WaterInfill();

        private WaterInfill() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/database/DeviceField$SensorMode;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceField.kt */
    public static final class SensorMode extends DeviceField<Integer> {
        public static final SensorMode INSTANCE = new SensorMode();

        private SensorMode() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0013\n\u0002\b\r\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/blueair/database/DeviceField$SensorRanges;", "", "pm1Ranges", "", "pm10Ranges", "pm25Ranges", "vocRanges", "hchoRanges", "<init>", "([D[D[D[D[D)V", "getPm1Ranges", "()[D", "getPm10Ranges", "getPm25Ranges", "getVocRanges", "getHchoRanges", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceField.kt */
    public static final class SensorRanges {
        private final double[] hchoRanges;
        private final double[] pm10Ranges;
        private final double[] pm1Ranges;
        private final double[] pm25Ranges;
        private final double[] vocRanges;

        public SensorRanges(double[] dArr, double[] dArr2, double[] dArr3, double[] dArr4, double[] dArr5) {
            Intrinsics.checkNotNullParameter(dArr, "pm1Ranges");
            Intrinsics.checkNotNullParameter(dArr2, "pm10Ranges");
            Intrinsics.checkNotNullParameter(dArr3, "pm25Ranges");
            Intrinsics.checkNotNullParameter(dArr4, "vocRanges");
            Intrinsics.checkNotNullParameter(dArr5, "hchoRanges");
            this.pm1Ranges = dArr;
            this.pm10Ranges = dArr2;
            this.pm25Ranges = dArr3;
            this.vocRanges = dArr4;
            this.hchoRanges = dArr5;
        }

        public final double[] getPm1Ranges() {
            return this.pm1Ranges;
        }

        public final double[] getPm10Ranges() {
            return this.pm10Ranges;
        }

        public final double[] getPm25Ranges() {
            return this.pm25Ranges;
        }

        public final double[] getVocRanges() {
            return this.vocRanges;
        }

        public final double[] getHchoRanges() {
            return this.hchoRanges;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00052\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007¨\u0006\b"}, d2 = {"Lcom/blueair/database/DeviceField$Companion;", "", "<init>", "()V", "fromStreamField", "Lcom/blueair/database/DeviceField;", "streamAttribute", "Lcom/blueair/core/model/DeviceStreamAttribute;", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceField.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DeviceField<?> fromStreamField(DeviceStreamAttribute<?> deviceStreamAttribute) {
            Intrinsics.checkNotNullParameter(deviceStreamAttribute, "streamAttribute");
            if (deviceStreamAttribute instanceof DeviceStreamAttribute.ConnectivityStatus) {
                return ConnectivityStatus.INSTANCE;
            }
            if (deviceStreamAttribute instanceof DeviceStreamAttribute.LatestSensorDataPoint) {
                return LatestSensorDataPoint.INSTANCE;
            }
            if (deviceStreamAttribute instanceof DeviceStreamAttribute.AutoMode) {
                return AutoMode.INSTANCE;
            }
            if (deviceStreamAttribute instanceof DeviceStreamAttribute.Brightness) {
                return Brightness.INSTANCE;
            }
            if (deviceStreamAttribute instanceof DeviceStreamAttribute.ChildLock) {
                return ChildLock.INSTANCE;
            }
            if (deviceStreamAttribute instanceof DeviceStreamAttribute.FanSpeed) {
                return FanSpeed.INSTANCE;
            }
            if (deviceStreamAttribute instanceof DeviceStreamAttribute.FanSpeedManualOrAuto) {
                return FanSpeed.INSTANCE;
            }
            if (deviceStreamAttribute instanceof DeviceStreamAttribute.GermShield) {
                return GermShieldMode.INSTANCE;
            }
            if (deviceStreamAttribute instanceof DeviceStreamAttribute.G4NightMode) {
                return G4NightMode.INSTANCE;
            }
            if (deviceStreamAttribute instanceof DeviceStreamAttribute.SafetySwitch) {
                return SafetySwitch.INSTANCE;
            }
            if (deviceStreamAttribute instanceof DeviceStreamAttribute.StandByMode) {
                return StandbyMode.INSTANCE;
            }
            if (deviceStreamAttribute instanceof DeviceStreamAttribute.EcoMode) {
                return EcoMode.INSTANCE;
            }
            if (deviceStreamAttribute instanceof DeviceStreamAttribute.HinsMode) {
                return HinsMode.INSTANCE;
            }
            if (deviceStreamAttribute instanceof DeviceStreamAttribute.HinsNightMode) {
                return HinsNightMode.INSTANCE;
            }
            if (deviceStreamAttribute instanceof DeviceStreamAttribute.FilterUsage) {
                return FilterLife.INSTANCE;
            }
            if (deviceStreamAttribute instanceof DeviceStreamAttribute.Disinfection) {
                return Disinfection.INSTANCE;
            }
            if (deviceStreamAttribute instanceof DeviceStreamAttribute.DisinfectLeftTime) {
                return DisinfectLeftTime.INSTANCE;
            }
            if (deviceStreamAttribute instanceof DeviceStreamAttribute.GermShieldNight) {
                return GermShieldNightMode.INSTANCE;
            }
            if (deviceStreamAttribute instanceof DeviceStreamAttribute.WickdryEnabled) {
                return WickdryEnabled.INSTANCE;
            }
            if (deviceStreamAttribute instanceof DeviceStreamAttribute.WickdryOn) {
                return WickdryOn.INSTANCE;
            }
            if (deviceStreamAttribute instanceof DeviceStreamAttribute.WickdryLeftTime) {
                return WickdryLeftTime.INSTANCE;
            }
            if (deviceStreamAttribute instanceof DeviceStreamAttribute.WickUsage) {
                return WickUsage.INSTANCE;
            }
            if (deviceStreamAttribute instanceof DeviceStreamAttribute.WaterShortage) {
                return WaterShortage.INSTANCE;
            }
            if (deviceStreamAttribute instanceof DeviceStreamAttribute.AutoRh) {
                return AutoRh.INSTANCE;
            }
            if (deviceStreamAttribute instanceof DeviceStreamAttribute.TimerStatus) {
                return TimerStatus.INSTANCE;
            }
            if (deviceStreamAttribute instanceof DeviceStreamAttribute.TimerDuration) {
                return TimerDuration.INSTANCE;
            }
            if (deviceStreamAttribute instanceof DeviceStreamAttribute.TimerLeftTime) {
                return TimerLeftTime.INSTANCE;
            }
            if (deviceStreamAttribute instanceof DeviceStreamAttribute.TemperatureUnit) {
                return TemperatureUnit.INSTANCE;
            }
            if (deviceStreamAttribute instanceof DeviceStreamAttribute.OscillationState) {
                return OscillationState.INSTANCE;
            }
            if (deviceStreamAttribute instanceof DeviceStreamAttribute.OscillationAngle) {
                return OscillationAngle.INSTANCE;
            }
            if (deviceStreamAttribute instanceof DeviceStreamAttribute.OscillationDirection) {
                return OscillationDirection.INSTANCE;
            }
            if (deviceStreamAttribute instanceof DeviceStreamAttribute.OscillationFanSpeed) {
                return OscillationFanSpeed.INSTANCE;
            }
            if (deviceStreamAttribute instanceof DeviceStreamAttribute.MainMode) {
                return MainMode.INSTANCE;
            }
            if (deviceStreamAttribute instanceof DeviceStreamAttribute.ApSubMode) {
                return ApSubMode.INSTANCE;
            }
            if (deviceStreamAttribute instanceof DeviceStreamAttribute.ApFanSpeed) {
                return ApFanSpeed.INSTANCE;
            }
            if (deviceStreamAttribute instanceof DeviceStreamAttribute.HeatSubMode) {
                return HeatSubMode.INSTANCE;
            }
            if (deviceStreamAttribute instanceof DeviceStreamAttribute.HeatFanSpeed) {
                return HeatFanSpeed.INSTANCE;
            }
            if (deviceStreamAttribute instanceof DeviceStreamAttribute.HeatAutoTmp) {
                return HeatAutoTmp.INSTANCE;
            }
            if (deviceStreamAttribute instanceof DeviceStreamAttribute.HeatEcoTmp) {
                return HeatEcoTmp.INSTANCE;
            }
            if (deviceStreamAttribute instanceof DeviceStreamAttribute.CoolSubMode) {
                return CoolSubMode.INSTANCE;
            }
            if (deviceStreamAttribute instanceof DeviceStreamAttribute.CoolFanSpeed) {
                return CoolFanSpeed.INSTANCE;
            }
            if (deviceStreamAttribute instanceof DeviceStreamAttribute.CoolAutoTag) {
                return CoolAutoTag.INSTANCE;
            }
            if (deviceStreamAttribute instanceof DeviceStreamAttribute.CoolAutoPresets) {
                return CoolAutoPresets.INSTANCE;
            }
            if (deviceStreamAttribute instanceof DeviceStreamAttribute.CoolEcoTag) {
                return CoolEcoTag.INSTANCE;
            }
            if (deviceStreamAttribute instanceof DeviceStreamAttribute.CoolEcoPresets) {
                return CoolEcoPresets.INSTANCE;
            }
            if (deviceStreamAttribute instanceof DeviceStreamAttribute.Mode) {
                return Mode.INSTANCE;
            }
            if (deviceStreamAttribute instanceof DeviceStreamAttribute.HumMode) {
                return HumMode.INSTANCE;
            }
            if (deviceStreamAttribute instanceof DeviceStreamAttribute.WaterLevel) {
                return WaterLevel.INSTANCE;
            }
            if (deviceStreamAttribute instanceof DeviceStreamAttribute.DehSubMode) {
                return DehSubMode.INSTANCE;
            }
            if (deviceStreamAttribute instanceof DeviceStreamAttribute.WaterTankFailure) {
                return WaterTankFailure.INSTANCE;
            }
            if (deviceStreamAttribute instanceof DeviceStreamAttribute.SmartSubMode) {
                return SmartSubMode.INSTANCE;
            }
            if (deviceStreamAttribute instanceof DeviceStreamAttribute.DetectCat) {
                return DetectCat.INSTANCE;
            }
            if (deviceStreamAttribute instanceof DeviceStreamAttribute.BodyMounted) {
                return BodyMounted.INSTANCE;
            }
            if (deviceStreamAttribute instanceof DeviceStreamAttribute.CleanAirEta) {
                return CleanAirEta.INSTANCE;
            }
            if (deviceStreamAttribute instanceof DeviceStreamAttribute.PanelDisplayMode) {
                return PanelDisplayMode.INSTANCE;
            }
            if (deviceStreamAttribute instanceof DeviceStreamAttribute.HoverEnabled) {
                return HoverEnabled.INSTANCE;
            }
            if (deviceStreamAttribute instanceof DeviceStreamAttribute.AirRefreshEnabled) {
                return AirRefreshEnabled.INSTANCE;
            }
            if (deviceStreamAttribute instanceof DeviceStreamAttribute.AirRefreshStatus) {
                return AirRefreshStatus.INSTANCE;
            }
            if (deviceStreamAttribute instanceof DeviceStreamAttribute.AirRefreshDuration) {
                return AirRefreshDuration.INSTANCE;
            }
            if (deviceStreamAttribute instanceof DeviceStreamAttribute.AirRefreshTimeStamp) {
                return AirRefreshTimeStamp.INSTANCE;
            }
            if (deviceStreamAttribute instanceof DeviceStreamAttribute.AirRefreshStartTimeStamp) {
                return AirRefreshStartTimeStamp.INSTANCE;
            }
            if (deviceStreamAttribute instanceof DeviceStreamAttribute.AirRefreshEndTimeStamp) {
                return AirRefreshEndTimeStamp.INSTANCE;
            }
            if (deviceStreamAttribute instanceof DeviceStreamAttribute.RoomType) {
                return RoomType.INSTANCE;
            }
            if (deviceStreamAttribute instanceof DeviceStreamAttribute.NightLampBrightness) {
                return NightLampBrightness.INSTANCE;
            }
            if (deviceStreamAttribute instanceof DeviceStreamAttribute.WickdryDuration) {
                return WickdryDuration.INSTANCE;
            }
            if (deviceStreamAttribute instanceof DeviceStreamAttribute.WickdryDone) {
                return WickdryDone.INSTANCE;
            }
            if (deviceStreamAttribute instanceof DeviceStreamAttribute.YwrmEnabled) {
                return YwrmEnabled.INSTANCE;
            }
            if (deviceStreamAttribute instanceof DeviceStreamAttribute.YwrmUsage) {
                return YwrmUsage.INSTANCE;
            }
            if (deviceStreamAttribute instanceof DeviceStreamAttribute.NightLampSteplessBrightness) {
                return NightLampSteplessBrightness.INSTANCE;
            }
            if (deviceStreamAttribute instanceof DeviceStreamAttribute.Alarms) {
                return Alarms.INSTANCE;
            }
            if (deviceStreamAttribute instanceof DeviceStreamAttribute.HumSubMode) {
                return HumSubMode.INSTANCE;
            }
            if (deviceStreamAttribute instanceof DeviceStreamAttribute.Use24Hour) {
                return Use24Hour.INSTANCE;
            }
            if (deviceStreamAttribute instanceof DeviceStreamAttribute.WaterInfill) {
                return WaterInfill.INSTANCE;
            }
            if (deviceStreamAttribute instanceof DeviceStreamAttribute.SensorMode) {
                return SensorMode.INSTANCE;
            }
            if (deviceStreamAttribute instanceof DeviceStreamAttribute.Unknown) {
                return Unknown.INSTANCE;
            }
            throw new NoWhenBranchMatchedException();
        }
    }
}
