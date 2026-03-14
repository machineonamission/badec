package com.blueair.database;

import com.blueair.core.model.DeviceStreamAttribute;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000¤\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\bi\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 k*\u0004\b\u0000\u0010\u00012\u00020\u0002:g\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijkB\t\b\u0004¢\u0006\u0004\b\u0003\u0010\u0004\u0082\u0001¶\u0001lmnopqrstuvwxyz{|}~\u007f\u0080\u0001\u0081\u0001\u0082\u0001\u0083\u0001\u0084\u0001\u0085\u0001\u0086\u0001\u0087\u0001\u0088\u0001\u0089\u0001\u008a\u0001\u008b\u0001\u008c\u0001\u008d\u0001\u008e\u0001\u008f\u0001\u0090\u0001\u0091\u0001\u0092\u0001\u0093\u0001\u0094\u0001\u0095\u0001\u0096\u0001\u0097\u0001\u0098\u0001\u0099\u0001\u009a\u0001\u009b\u0001\u009c\u0001\u009d\u0001\u009e\u0001\u009f\u0001 \u0001¡\u0001¢\u0001£\u0001¤\u0001¥\u0001¦\u0001§\u0001¨\u0001©\u0001ª\u0001«\u0001¬\u0001\u00ad\u0001®\u0001¯\u0001°\u0001±\u0001²\u0001³\u0001´\u0001µ\u0001¶\u0001·\u0001¸\u0001¹\u0001º\u0001»\u0001¼\u0001½\u0001¾\u0001¿\u0001À\u0001Á\u0001Â\u0001Ã\u0001Ä\u0001Å\u0001Æ\u0001Ç\u0001È\u0001É\u0001Ê\u0001Ë\u0001Ì\u0001Í\u0001Î\u0001Ï\u0001Ð\u0001¨\u0006Ñ\u0001"},
   d2 = {"Lcom/blueair/database/DeviceField;", "T", "", "<init>", "()V", "Name", "LatestSensorDataPoint", "SelectedSensor", "FanSpeed", "FanSpeedAndAutoMode", "AutoMode", "Brightness", "ChildLock", "LinkedDeviceUid", "ConnectivityStatus", "UpdateProgress", "FilterLife", "SensorRange", "WifiFirmware", "McuFirmware", "Unknown", "StandbyMode", "G4NightMode", "GermShieldMode", "SerialNumber", "FilterTrigger", "G4NightModeFilterTrigger", "SafetySwitch", "MacAddress", "ModelName", "FilterType", "DeviceType", "DeviceSKU", "DeviceCompatibility", "DeviceWelcomeHome", "Disinfection", "DisinfectLeftTime", "GermShieldNightMode", "DeviceTimezone", "EcoMode", "HinsMode", "HinsNightMode", "WickdryEnabled", "WickdryOn", "WickdryLeftTime", "WickUsage", "WaterShortage", "AutoRh", "TimerStatus", "TimerDuration", "TimerLeftTime", "TemperatureUnit", "OscillationState", "OscillationAngle", "OscillationDirection", "OscillationFanSpeed", "MainMode", "ApSubMode", "ApFanSpeed", "HeatSubMode", "HeatFanSpeed", "HeatAutoTmp", "HeatEcoTmp", "CoolSubMode", "CoolFanSpeed", "CoolAutoTag", "CoolAutoPresets", "CoolEcoTag", "CoolEcoPresets", "LocationId", "Mode", "HumMode", "WaterLevel", "Hardware", "DehSubMode", "WaterTankFailure", "SmartSubMode", "DetectCat", "CleanAirEta", "PanelDisplayMode", "HoverEnabled", "AirRefreshEnabled", "AirRefreshStatus", "AirRefreshDuration", "AirRefreshTimeStamp", "AirRefreshStartTimeStamp", "AirRefreshEndTimeStamp", "RoomType", "BodyMounted", "NightLampBrightness", "WickdryDuration", "WickdryDone", "YwrmEnabled", "YwrmUsage", "NightLampSteplessBrightness", "Alarms", "HumSubMode", "Use24Hour", "WaterInfill", "SensorMode", "CoolFanSpeedLevel", "CoolAutoLevel", "NightModeStartTime", "DualOscillationConfig", "Rpm", "NightPeriods", "SensorRanges", "Companion", "Lcom/blueair/database/DeviceField$AirRefreshDuration;", "Lcom/blueair/database/DeviceField$AirRefreshEnabled;", "Lcom/blueair/database/DeviceField$AirRefreshEndTimeStamp;", "Lcom/blueair/database/DeviceField$AirRefreshStartTimeStamp;", "Lcom/blueair/database/DeviceField$AirRefreshStatus;", "Lcom/blueair/database/DeviceField$AirRefreshTimeStamp;", "Lcom/blueair/database/DeviceField$Alarms;", "Lcom/blueair/database/DeviceField$ApFanSpeed;", "Lcom/blueair/database/DeviceField$ApSubMode;", "Lcom/blueair/database/DeviceField$AutoMode;", "Lcom/blueair/database/DeviceField$AutoRh;", "Lcom/blueair/database/DeviceField$BodyMounted;", "Lcom/blueair/database/DeviceField$Brightness;", "Lcom/blueair/database/DeviceField$ChildLock;", "Lcom/blueair/database/DeviceField$CleanAirEta;", "Lcom/blueair/database/DeviceField$ConnectivityStatus;", "Lcom/blueair/database/DeviceField$CoolAutoLevel;", "Lcom/blueair/database/DeviceField$CoolAutoPresets;", "Lcom/blueair/database/DeviceField$CoolAutoTag;", "Lcom/blueair/database/DeviceField$CoolEcoPresets;", "Lcom/blueair/database/DeviceField$CoolEcoTag;", "Lcom/blueair/database/DeviceField$CoolFanSpeed;", "Lcom/blueair/database/DeviceField$CoolFanSpeedLevel;", "Lcom/blueair/database/DeviceField$CoolSubMode;", "Lcom/blueair/database/DeviceField$DehSubMode;", "Lcom/blueair/database/DeviceField$DetectCat;", "Lcom/blueair/database/DeviceField$DeviceCompatibility;", "Lcom/blueair/database/DeviceField$DeviceSKU;", "Lcom/blueair/database/DeviceField$DeviceTimezone;", "Lcom/blueair/database/DeviceField$DeviceType;", "Lcom/blueair/database/DeviceField$DeviceWelcomeHome;", "Lcom/blueair/database/DeviceField$DisinfectLeftTime;", "Lcom/blueair/database/DeviceField$Disinfection;", "Lcom/blueair/database/DeviceField$DualOscillationConfig;", "Lcom/blueair/database/DeviceField$EcoMode;", "Lcom/blueair/database/DeviceField$FanSpeed;", "Lcom/blueair/database/DeviceField$FanSpeedAndAutoMode;", "Lcom/blueair/database/DeviceField$FilterLife;", "Lcom/blueair/database/DeviceField$FilterTrigger;", "Lcom/blueair/database/DeviceField$FilterType;", "Lcom/blueair/database/DeviceField$G4NightMode;", "Lcom/blueair/database/DeviceField$G4NightModeFilterTrigger;", "Lcom/blueair/database/DeviceField$GermShieldMode;", "Lcom/blueair/database/DeviceField$GermShieldNightMode;", "Lcom/blueair/database/DeviceField$Hardware;", "Lcom/blueair/database/DeviceField$HeatAutoTmp;", "Lcom/blueair/database/DeviceField$HeatEcoTmp;", "Lcom/blueair/database/DeviceField$HeatFanSpeed;", "Lcom/blueair/database/DeviceField$HeatSubMode;", "Lcom/blueair/database/DeviceField$HinsMode;", "Lcom/blueair/database/DeviceField$HinsNightMode;", "Lcom/blueair/database/DeviceField$HoverEnabled;", "Lcom/blueair/database/DeviceField$HumMode;", "Lcom/blueair/database/DeviceField$HumSubMode;", "Lcom/blueair/database/DeviceField$LatestSensorDataPoint;", "Lcom/blueair/database/DeviceField$LinkedDeviceUid;", "Lcom/blueair/database/DeviceField$LocationId;", "Lcom/blueair/database/DeviceField$MacAddress;", "Lcom/blueair/database/DeviceField$MainMode;", "Lcom/blueair/database/DeviceField$McuFirmware;", "Lcom/blueair/database/DeviceField$Mode;", "Lcom/blueair/database/DeviceField$ModelName;", "Lcom/blueair/database/DeviceField$Name;", "Lcom/blueair/database/DeviceField$NightLampBrightness;", "Lcom/blueair/database/DeviceField$NightLampSteplessBrightness;", "Lcom/blueair/database/DeviceField$NightModeStartTime;", "Lcom/blueair/database/DeviceField$NightPeriods;", "Lcom/blueair/database/DeviceField$OscillationAngle;", "Lcom/blueair/database/DeviceField$OscillationDirection;", "Lcom/blueair/database/DeviceField$OscillationFanSpeed;", "Lcom/blueair/database/DeviceField$OscillationState;", "Lcom/blueair/database/DeviceField$PanelDisplayMode;", "Lcom/blueair/database/DeviceField$RoomType;", "Lcom/blueair/database/DeviceField$Rpm;", "Lcom/blueair/database/DeviceField$SafetySwitch;", "Lcom/blueair/database/DeviceField$SelectedSensor;", "Lcom/blueair/database/DeviceField$SensorMode;", "Lcom/blueair/database/DeviceField$SensorRange;", "Lcom/blueair/database/DeviceField$SerialNumber;", "Lcom/blueair/database/DeviceField$SmartSubMode;", "Lcom/blueair/database/DeviceField$StandbyMode;", "Lcom/blueair/database/DeviceField$TemperatureUnit;", "Lcom/blueair/database/DeviceField$TimerDuration;", "Lcom/blueair/database/DeviceField$TimerLeftTime;", "Lcom/blueair/database/DeviceField$TimerStatus;", "Lcom/blueair/database/DeviceField$Unknown;", "Lcom/blueair/database/DeviceField$UpdateProgress;", "Lcom/blueair/database/DeviceField$Use24Hour;", "Lcom/blueair/database/DeviceField$WaterInfill;", "Lcom/blueair/database/DeviceField$WaterLevel;", "Lcom/blueair/database/DeviceField$WaterShortage;", "Lcom/blueair/database/DeviceField$WaterTankFailure;", "Lcom/blueair/database/DeviceField$WickUsage;", "Lcom/blueair/database/DeviceField$WickdryDone;", "Lcom/blueair/database/DeviceField$WickdryDuration;", "Lcom/blueair/database/DeviceField$WickdryEnabled;", "Lcom/blueair/database/DeviceField$WickdryLeftTime;", "Lcom/blueair/database/DeviceField$WickdryOn;", "Lcom/blueair/database/DeviceField$WifiFirmware;", "Lcom/blueair/database/DeviceField$YwrmEnabled;", "Lcom/blueair/database/DeviceField$YwrmUsage;", "database_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public abstract class DeviceField {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);

   private DeviceField() {
   }

   // $FF: synthetic method
   public DeviceField(DefaultConstructorMarker var1) {
      this();
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/database/DeviceField$AirRefreshDuration;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class AirRefreshDuration extends DeviceField {
      public static final AirRefreshDuration INSTANCE = new AirRefreshDuration();

      private AirRefreshDuration() {
         super((DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/database/DeviceField$AirRefreshEnabled;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class AirRefreshEnabled extends DeviceField {
      public static final AirRefreshEnabled INSTANCE = new AirRefreshEnabled();

      private AirRefreshEnabled() {
         super((DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/database/DeviceField$AirRefreshEndTimeStamp;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class AirRefreshEndTimeStamp extends DeviceField {
      public static final AirRefreshEndTimeStamp INSTANCE = new AirRefreshEndTimeStamp();

      private AirRefreshEndTimeStamp() {
         super((DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/database/DeviceField$AirRefreshStartTimeStamp;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class AirRefreshStartTimeStamp extends DeviceField {
      public static final AirRefreshStartTimeStamp INSTANCE = new AirRefreshStartTimeStamp();

      private AirRefreshStartTimeStamp() {
         super((DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/database/DeviceField$AirRefreshStatus;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class AirRefreshStatus extends DeviceField {
      public static final AirRefreshStatus INSTANCE = new AirRefreshStatus();

      private AirRefreshStatus() {
         super((DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/database/DeviceField$AirRefreshTimeStamp;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class AirRefreshTimeStamp extends DeviceField {
      public static final AirRefreshTimeStamp INSTANCE = new AirRefreshTimeStamp();

      private AirRefreshTimeStamp() {
         super((DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
      d2 = {"Lcom/blueair/database/DeviceField$Alarms;", "Lcom/blueair/database/DeviceField;", "", "Lcom/blueair/core/model/DeviceAlarm;", "<init>", "()V", "database_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Alarms extends DeviceField {
      public static final Alarms INSTANCE = new Alarms();

      private Alarms() {
         super((DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/database/DeviceField$ApFanSpeed;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class ApFanSpeed extends DeviceField {
      public static final ApFanSpeed INSTANCE = new ApFanSpeed();

      private ApFanSpeed() {
         super((DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/database/DeviceField$ApSubMode;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class ApSubMode extends DeviceField {
      public static final ApSubMode INSTANCE = new ApSubMode();

      private ApSubMode() {
         super((DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/database/DeviceField$AutoMode;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class AutoMode extends DeviceField {
      public static final AutoMode INSTANCE = new AutoMode();

      private AutoMode() {
         super((DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/database/DeviceField$AutoRh;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class AutoRh extends DeviceField {
      public static final AutoRh INSTANCE = new AutoRh();

      private AutoRh() {
         super((DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/database/DeviceField$BodyMounted;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class BodyMounted extends DeviceField {
      public static final BodyMounted INSTANCE = new BodyMounted();

      private BodyMounted() {
         super((DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/database/DeviceField$Brightness;", "Lcom/blueair/database/DeviceField;", "Lcom/blueair/core/model/Brightness;", "<init>", "()V", "database_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Brightness extends DeviceField {
      public static final Brightness INSTANCE = new Brightness();

      private Brightness() {
         super((DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/database/DeviceField$ChildLock;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class ChildLock extends DeviceField {
      public static final ChildLock INSTANCE = new ChildLock();

      private ChildLock() {
         super((DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/database/DeviceField$CleanAirEta;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class CleanAirEta extends DeviceField {
      public static final CleanAirEta INSTANCE = new CleanAirEta();

      private CleanAirEta() {
         super((DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00052\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007¨\u0006\b"},
      d2 = {"Lcom/blueair/database/DeviceField$Companion;", "", "<init>", "()V", "fromStreamField", "Lcom/blueair/database/DeviceField;", "streamAttribute", "Lcom/blueair/core/model/DeviceStreamAttribute;", "database_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Companion {
      private Companion() {
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker var1) {
         this();
      }

      public final DeviceField fromStreamField(DeviceStreamAttribute var1) {
         Intrinsics.checkNotNullParameter(var1, "streamAttribute");
         if (var1 instanceof DeviceStreamAttribute.ConnectivityStatus) {
            return DeviceField.ConnectivityStatus.INSTANCE;
         } else if (var1 instanceof DeviceStreamAttribute.LatestSensorDataPoint) {
            return DeviceField.LatestSensorDataPoint.INSTANCE;
         } else if (var1 instanceof DeviceStreamAttribute.AutoMode) {
            return DeviceField.AutoMode.INSTANCE;
         } else if (var1 instanceof DeviceStreamAttribute.Brightness) {
            return DeviceField.Brightness.INSTANCE;
         } else if (var1 instanceof DeviceStreamAttribute.ChildLock) {
            return DeviceField.ChildLock.INSTANCE;
         } else if (var1 instanceof DeviceStreamAttribute.FanSpeed) {
            return DeviceField.FanSpeed.INSTANCE;
         } else if (var1 instanceof DeviceStreamAttribute.FanSpeedManualOrAuto) {
            return DeviceField.FanSpeed.INSTANCE;
         } else if (var1 instanceof DeviceStreamAttribute.GermShield) {
            return DeviceField.GermShieldMode.INSTANCE;
         } else if (var1 instanceof DeviceStreamAttribute.G4NightMode) {
            return DeviceField.G4NightMode.INSTANCE;
         } else if (var1 instanceof DeviceStreamAttribute.SafetySwitch) {
            return DeviceField.SafetySwitch.INSTANCE;
         } else if (var1 instanceof DeviceStreamAttribute.StandByMode) {
            return DeviceField.StandbyMode.INSTANCE;
         } else if (var1 instanceof DeviceStreamAttribute.EcoMode) {
            return DeviceField.EcoMode.INSTANCE;
         } else if (var1 instanceof DeviceStreamAttribute.HinsMode) {
            return DeviceField.HinsMode.INSTANCE;
         } else if (var1 instanceof DeviceStreamAttribute.HinsNightMode) {
            return DeviceField.HinsNightMode.INSTANCE;
         } else if (var1 instanceof DeviceStreamAttribute.FilterUsage) {
            return DeviceField.FilterLife.INSTANCE;
         } else if (var1 instanceof DeviceStreamAttribute.Disinfection) {
            return DeviceField.Disinfection.INSTANCE;
         } else if (var1 instanceof DeviceStreamAttribute.DisinfectLeftTime) {
            return DeviceField.DisinfectLeftTime.INSTANCE;
         } else if (var1 instanceof DeviceStreamAttribute.GermShieldNight) {
            return DeviceField.GermShieldNightMode.INSTANCE;
         } else if (var1 instanceof DeviceStreamAttribute.WickdryEnabled) {
            return DeviceField.WickdryEnabled.INSTANCE;
         } else if (var1 instanceof DeviceStreamAttribute.WickdryOn) {
            return DeviceField.WickdryOn.INSTANCE;
         } else if (var1 instanceof DeviceStreamAttribute.WickdryLeftTime) {
            return DeviceField.WickdryLeftTime.INSTANCE;
         } else if (var1 instanceof DeviceStreamAttribute.WickUsage) {
            return DeviceField.WickUsage.INSTANCE;
         } else if (var1 instanceof DeviceStreamAttribute.WaterShortage) {
            return DeviceField.WaterShortage.INSTANCE;
         } else if (var1 instanceof DeviceStreamAttribute.AutoRh) {
            return DeviceField.AutoRh.INSTANCE;
         } else if (var1 instanceof DeviceStreamAttribute.TimerStatus) {
            return DeviceField.TimerStatus.INSTANCE;
         } else if (var1 instanceof DeviceStreamAttribute.TimerDuration) {
            return DeviceField.TimerDuration.INSTANCE;
         } else if (var1 instanceof DeviceStreamAttribute.TimerLeftTime) {
            return DeviceField.TimerLeftTime.INSTANCE;
         } else if (var1 instanceof DeviceStreamAttribute.TemperatureUnit) {
            return DeviceField.TemperatureUnit.INSTANCE;
         } else if (var1 instanceof DeviceStreamAttribute.OscillationState) {
            return DeviceField.OscillationState.INSTANCE;
         } else if (var1 instanceof DeviceStreamAttribute.OscillationAngle) {
            return DeviceField.OscillationAngle.INSTANCE;
         } else if (var1 instanceof DeviceStreamAttribute.OscillationDirection) {
            return DeviceField.OscillationDirection.INSTANCE;
         } else if (var1 instanceof DeviceStreamAttribute.OscillationFanSpeed) {
            return DeviceField.OscillationFanSpeed.INSTANCE;
         } else if (var1 instanceof DeviceStreamAttribute.MainMode) {
            return DeviceField.MainMode.INSTANCE;
         } else if (var1 instanceof DeviceStreamAttribute.ApSubMode) {
            return DeviceField.ApSubMode.INSTANCE;
         } else if (var1 instanceof DeviceStreamAttribute.ApFanSpeed) {
            return DeviceField.ApFanSpeed.INSTANCE;
         } else if (var1 instanceof DeviceStreamAttribute.HeatSubMode) {
            return DeviceField.HeatSubMode.INSTANCE;
         } else if (var1 instanceof DeviceStreamAttribute.HeatFanSpeed) {
            return DeviceField.HeatFanSpeed.INSTANCE;
         } else if (var1 instanceof DeviceStreamAttribute.HeatAutoTmp) {
            return DeviceField.HeatAutoTmp.INSTANCE;
         } else if (var1 instanceof DeviceStreamAttribute.HeatEcoTmp) {
            return DeviceField.HeatEcoTmp.INSTANCE;
         } else if (var1 instanceof DeviceStreamAttribute.CoolSubMode) {
            return DeviceField.CoolSubMode.INSTANCE;
         } else if (var1 instanceof DeviceStreamAttribute.CoolFanSpeed) {
            return DeviceField.CoolFanSpeed.INSTANCE;
         } else if (var1 instanceof DeviceStreamAttribute.CoolAutoTag) {
            return DeviceField.CoolAutoTag.INSTANCE;
         } else if (var1 instanceof DeviceStreamAttribute.CoolAutoPresets) {
            return DeviceField.CoolAutoPresets.INSTANCE;
         } else if (var1 instanceof DeviceStreamAttribute.CoolEcoTag) {
            return DeviceField.CoolEcoTag.INSTANCE;
         } else if (var1 instanceof DeviceStreamAttribute.CoolEcoPresets) {
            return DeviceField.CoolEcoPresets.INSTANCE;
         } else if (var1 instanceof DeviceStreamAttribute.Mode) {
            return DeviceField.Mode.INSTANCE;
         } else if (var1 instanceof DeviceStreamAttribute.HumMode) {
            return DeviceField.HumMode.INSTANCE;
         } else if (var1 instanceof DeviceStreamAttribute.WaterLevel) {
            return DeviceField.WaterLevel.INSTANCE;
         } else if (var1 instanceof DeviceStreamAttribute.DehSubMode) {
            return DeviceField.DehSubMode.INSTANCE;
         } else if (var1 instanceof DeviceStreamAttribute.WaterTankFailure) {
            return DeviceField.WaterTankFailure.INSTANCE;
         } else if (var1 instanceof DeviceStreamAttribute.SmartSubMode) {
            return DeviceField.SmartSubMode.INSTANCE;
         } else if (var1 instanceof DeviceStreamAttribute.DetectCat) {
            return DeviceField.DetectCat.INSTANCE;
         } else if (var1 instanceof DeviceStreamAttribute.BodyMounted) {
            return DeviceField.BodyMounted.INSTANCE;
         } else if (var1 instanceof DeviceStreamAttribute.CleanAirEta) {
            return DeviceField.CleanAirEta.INSTANCE;
         } else if (var1 instanceof DeviceStreamAttribute.PanelDisplayMode) {
            return DeviceField.PanelDisplayMode.INSTANCE;
         } else if (var1 instanceof DeviceStreamAttribute.HoverEnabled) {
            return DeviceField.HoverEnabled.INSTANCE;
         } else if (var1 instanceof DeviceStreamAttribute.AirRefreshEnabled) {
            return DeviceField.AirRefreshEnabled.INSTANCE;
         } else if (var1 instanceof DeviceStreamAttribute.AirRefreshStatus) {
            return DeviceField.AirRefreshStatus.INSTANCE;
         } else if (var1 instanceof DeviceStreamAttribute.AirRefreshDuration) {
            return DeviceField.AirRefreshDuration.INSTANCE;
         } else if (var1 instanceof DeviceStreamAttribute.AirRefreshTimeStamp) {
            return DeviceField.AirRefreshTimeStamp.INSTANCE;
         } else if (var1 instanceof DeviceStreamAttribute.AirRefreshStartTimeStamp) {
            return DeviceField.AirRefreshStartTimeStamp.INSTANCE;
         } else if (var1 instanceof DeviceStreamAttribute.AirRefreshEndTimeStamp) {
            return DeviceField.AirRefreshEndTimeStamp.INSTANCE;
         } else if (var1 instanceof DeviceStreamAttribute.RoomType) {
            return DeviceField.RoomType.INSTANCE;
         } else if (var1 instanceof DeviceStreamAttribute.NightLampBrightness) {
            return DeviceField.NightLampBrightness.INSTANCE;
         } else if (var1 instanceof DeviceStreamAttribute.WickdryDuration) {
            return DeviceField.WickdryDuration.INSTANCE;
         } else if (var1 instanceof DeviceStreamAttribute.WickdryDone) {
            return DeviceField.WickdryDone.INSTANCE;
         } else if (var1 instanceof DeviceStreamAttribute.YwrmEnabled) {
            return DeviceField.YwrmEnabled.INSTANCE;
         } else if (var1 instanceof DeviceStreamAttribute.YwrmUsage) {
            return DeviceField.YwrmUsage.INSTANCE;
         } else if (var1 instanceof DeviceStreamAttribute.NightLampSteplessBrightness) {
            return DeviceField.NightLampSteplessBrightness.INSTANCE;
         } else if (var1 instanceof DeviceStreamAttribute.Alarms) {
            return DeviceField.Alarms.INSTANCE;
         } else if (var1 instanceof DeviceStreamAttribute.HumSubMode) {
            return DeviceField.HumSubMode.INSTANCE;
         } else if (var1 instanceof DeviceStreamAttribute.Use24Hour) {
            return DeviceField.Use24Hour.INSTANCE;
         } else if (var1 instanceof DeviceStreamAttribute.WaterInfill) {
            return DeviceField.WaterInfill.INSTANCE;
         } else if (var1 instanceof DeviceStreamAttribute.SensorMode) {
            return DeviceField.SensorMode.INSTANCE;
         } else if (var1 instanceof DeviceStreamAttribute.NightModeStartTime) {
            return DeviceField.NightModeStartTime.INSTANCE;
         } else if (var1 instanceof DeviceStreamAttribute.CoolFanSpeedLevel) {
            return DeviceField.CoolFanSpeedLevel.INSTANCE;
         } else if (var1 instanceof DeviceStreamAttribute.CoolAutoLevel) {
            return DeviceField.CoolAutoLevel.INSTANCE;
         } else if (var1 instanceof DeviceStreamAttribute.DualOscillationConfig) {
            return DeviceField.DualOscillationConfig.INSTANCE;
         } else if (var1 instanceof DeviceStreamAttribute.Rpm) {
            return DeviceField.Rpm.INSTANCE;
         } else if (var1 instanceof DeviceStreamAttribute.Unknown) {
            return DeviceField.Unknown.INSTANCE;
         } else {
            throw new NoWhenBranchMatchedException();
         }
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/database/DeviceField$ConnectivityStatus;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class ConnectivityStatus extends DeviceField {
      public static final ConnectivityStatus INSTANCE = new ConnectivityStatus();

      private ConnectivityStatus() {
         super((DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/database/DeviceField$CoolAutoLevel;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class CoolAutoLevel extends DeviceField {
      public static final CoolAutoLevel INSTANCE = new CoolAutoLevel();

      private CoolAutoLevel() {
         super((DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0013\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/database/DeviceField$CoolAutoPresets;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class CoolAutoPresets extends DeviceField {
      public static final CoolAutoPresets INSTANCE = new CoolAutoPresets();

      private CoolAutoPresets() {
         super((DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/database/DeviceField$CoolAutoTag;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class CoolAutoTag extends DeviceField {
      public static final CoolAutoTag INSTANCE = new CoolAutoTag();

      private CoolAutoTag() {
         super((DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0013\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/database/DeviceField$CoolEcoPresets;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class CoolEcoPresets extends DeviceField {
      public static final CoolEcoPresets INSTANCE = new CoolEcoPresets();

      private CoolEcoPresets() {
         super((DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/database/DeviceField$CoolEcoTag;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class CoolEcoTag extends DeviceField {
      public static final CoolEcoTag INSTANCE = new CoolEcoTag();

      private CoolEcoTag() {
         super((DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/database/DeviceField$CoolFanSpeed;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class CoolFanSpeed extends DeviceField {
      public static final CoolFanSpeed INSTANCE = new CoolFanSpeed();

      private CoolFanSpeed() {
         super((DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/database/DeviceField$CoolFanSpeedLevel;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class CoolFanSpeedLevel extends DeviceField {
      public static final CoolFanSpeedLevel INSTANCE = new CoolFanSpeedLevel();

      private CoolFanSpeedLevel() {
         super((DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/database/DeviceField$CoolSubMode;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class CoolSubMode extends DeviceField {
      public static final CoolSubMode INSTANCE = new CoolSubMode();

      private CoolSubMode() {
         super((DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/database/DeviceField$DehSubMode;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class DehSubMode extends DeviceField {
      public static final DehSubMode INSTANCE = new DehSubMode();

      private DehSubMode() {
         super((DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/database/DeviceField$DetectCat;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class DetectCat extends DeviceField {
      public static final DetectCat INSTANCE = new DetectCat();

      private DetectCat() {
         super((DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/database/DeviceField$DeviceCompatibility;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class DeviceCompatibility extends DeviceField {
      public static final DeviceCompatibility INSTANCE = new DeviceCompatibility();

      private DeviceCompatibility() {
         super((DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/database/DeviceField$DeviceSKU;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class DeviceSKU extends DeviceField {
      public static final DeviceSKU INSTANCE = new DeviceSKU();

      private DeviceSKU() {
         super((DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/database/DeviceField$DeviceTimezone;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class DeviceTimezone extends DeviceField {
      public static final DeviceTimezone INSTANCE = new DeviceTimezone();

      private DeviceTimezone() {
         super((DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/database/DeviceField$DeviceType;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class DeviceType extends DeviceField {
      public static final DeviceType INSTANCE = new DeviceType();

      private DeviceType() {
         super((DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/database/DeviceField$DeviceWelcomeHome;", "Lcom/blueair/database/DeviceField;", "Lcom/blueair/core/model/WelcomeHomeLocation;", "<init>", "()V", "database_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class DeviceWelcomeHome extends DeviceField {
      public static final DeviceWelcomeHome INSTANCE = new DeviceWelcomeHome();

      private DeviceWelcomeHome() {
         super((DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"},
      d2 = {"Lcom/blueair/database/DeviceField$DisinfectLeftTime;", "Lcom/blueair/database/DeviceField;", "Lkotlin/Pair;", "", "", "<init>", "()V", "database_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class DisinfectLeftTime extends DeviceField {
      public static final DisinfectLeftTime INSTANCE = new DisinfectLeftTime();

      private DisinfectLeftTime() {
         super((DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/database/DeviceField$Disinfection;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Disinfection extends DeviceField {
      public static final Disinfection INSTANCE = new Disinfection();

      private Disinfection() {
         super((DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/database/DeviceField$DualOscillationConfig;", "Lcom/blueair/database/DeviceField;", "<init>", "()V", "database_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class DualOscillationConfig extends DeviceField {
      public static final DualOscillationConfig INSTANCE = new DualOscillationConfig();

      private DualOscillationConfig() {
         super((DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/database/DeviceField$EcoMode;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class EcoMode extends DeviceField {
      public static final EcoMode INSTANCE = new EcoMode();

      private EcoMode() {
         super((DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/database/DeviceField$FanSpeed;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class FanSpeed extends DeviceField {
      public static final FanSpeed INSTANCE = new FanSpeed();

      private FanSpeed() {
         super((DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/database/DeviceField$FanSpeedAndAutoMode;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class FanSpeedAndAutoMode extends DeviceField {
      public static final FanSpeedAndAutoMode INSTANCE = new FanSpeedAndAutoMode();

      private FanSpeedAndAutoMode() {
         super((DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/database/DeviceField$FilterLife;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class FilterLife extends DeviceField {
      public static final FilterLife INSTANCE = new FilterLife();

      private FilterLife() {
         super((DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/database/DeviceField$FilterTrigger;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class FilterTrigger extends DeviceField {
      public static final FilterTrigger INSTANCE = new FilterTrigger();

      private FilterTrigger() {
         super((DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/database/DeviceField$FilterType;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class FilterType extends DeviceField {
      public static final FilterType INSTANCE = new FilterType();

      private FilterType() {
         super((DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/database/DeviceField$G4NightMode;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class G4NightMode extends DeviceField {
      public static final G4NightMode INSTANCE = new G4NightMode();

      private G4NightMode() {
         super((DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/database/DeviceField$G4NightModeFilterTrigger;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class G4NightModeFilterTrigger extends DeviceField {
      public static final G4NightModeFilterTrigger INSTANCE = new G4NightModeFilterTrigger();

      private G4NightModeFilterTrigger() {
         super((DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/database/DeviceField$GermShieldMode;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class GermShieldMode extends DeviceField {
      public static final GermShieldMode INSTANCE = new GermShieldMode();

      private GermShieldMode() {
         super((DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/database/DeviceField$GermShieldNightMode;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class GermShieldNightMode extends DeviceField {
      public static final GermShieldNightMode INSTANCE = new GermShieldNightMode();

      private GermShieldNightMode() {
         super((DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/database/DeviceField$Hardware;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Hardware extends DeviceField {
      public static final Hardware INSTANCE = new Hardware();

      private Hardware() {
         super((DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/database/DeviceField$HeatAutoTmp;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class HeatAutoTmp extends DeviceField {
      public static final HeatAutoTmp INSTANCE = new HeatAutoTmp();

      private HeatAutoTmp() {
         super((DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/database/DeviceField$HeatEcoTmp;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class HeatEcoTmp extends DeviceField {
      public static final HeatEcoTmp INSTANCE = new HeatEcoTmp();

      private HeatEcoTmp() {
         super((DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/database/DeviceField$HeatFanSpeed;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class HeatFanSpeed extends DeviceField {
      public static final HeatFanSpeed INSTANCE = new HeatFanSpeed();

      private HeatFanSpeed() {
         super((DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/database/DeviceField$HeatSubMode;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class HeatSubMode extends DeviceField {
      public static final HeatSubMode INSTANCE = new HeatSubMode();

      private HeatSubMode() {
         super((DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/database/DeviceField$HinsMode;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class HinsMode extends DeviceField {
      public static final HinsMode INSTANCE = new HinsMode();

      private HinsMode() {
         super((DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/database/DeviceField$HinsNightMode;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class HinsNightMode extends DeviceField {
      public static final HinsNightMode INSTANCE = new HinsNightMode();

      private HinsNightMode() {
         super((DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/database/DeviceField$HoverEnabled;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class HoverEnabled extends DeviceField {
      public static final HoverEnabled INSTANCE = new HoverEnabled();

      private HoverEnabled() {
         super((DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/database/DeviceField$HumMode;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class HumMode extends DeviceField {
      public static final HumMode INSTANCE = new HumMode();

      private HumMode() {
         super((DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/database/DeviceField$HumSubMode;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class HumSubMode extends DeviceField {
      public static final HumSubMode INSTANCE = new HumSubMode();

      private HumSubMode() {
         super((DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/database/DeviceField$LatestSensorDataPoint;", "Lcom/blueair/database/DeviceField;", "Lcom/blueair/core/model/IndoorDatapoint;", "<init>", "()V", "database_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class LatestSensorDataPoint extends DeviceField {
      public static final LatestSensorDataPoint INSTANCE = new LatestSensorDataPoint();

      private LatestSensorDataPoint() {
         super((DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/database/DeviceField$LinkedDeviceUid;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class LinkedDeviceUid extends DeviceField {
      public static final LinkedDeviceUid INSTANCE = new LinkedDeviceUid();

      private LinkedDeviceUid() {
         super((DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0013\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/database/DeviceField$LocationId;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class LocationId extends DeviceField {
      public static final LocationId INSTANCE = new LocationId();

      private LocationId() {
         super((DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/database/DeviceField$MacAddress;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class MacAddress extends DeviceField {
      public static final MacAddress INSTANCE = new MacAddress();

      private MacAddress() {
         super((DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/database/DeviceField$MainMode;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class MainMode extends DeviceField {
      public static final MainMode INSTANCE = new MainMode();

      private MainMode() {
         super((DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/database/DeviceField$McuFirmware;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class McuFirmware extends DeviceField {
      public static final McuFirmware INSTANCE = new McuFirmware();

      private McuFirmware() {
         super((DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/database/DeviceField$Mode;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Mode extends DeviceField {
      public static final Mode INSTANCE = new Mode();

      private Mode() {
         super((DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/database/DeviceField$ModelName;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class ModelName extends DeviceField {
      public static final ModelName INSTANCE = new ModelName();

      private ModelName() {
         super((DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/database/DeviceField$Name;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Name extends DeviceField {
      public static final Name INSTANCE = new Name();

      private Name() {
         super((DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/database/DeviceField$NightLampBrightness;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class NightLampBrightness extends DeviceField {
      public static final NightLampBrightness INSTANCE = new NightLampBrightness();

      private NightLampBrightness() {
         super((DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/database/DeviceField$NightLampSteplessBrightness;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class NightLampSteplessBrightness extends DeviceField {
      public static final NightLampSteplessBrightness INSTANCE = new NightLampSteplessBrightness();

      private NightLampSteplessBrightness() {
         super((DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/database/DeviceField$NightModeStartTime;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class NightModeStartTime extends DeviceField {
      public static final NightModeStartTime INSTANCE = new NightModeStartTime();

      private NightModeStartTime() {
         super((DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0013\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/database/DeviceField$NightPeriods;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class NightPeriods extends DeviceField {
      public static final NightPeriods INSTANCE = new NightPeriods();

      private NightPeriods() {
         super((DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/database/DeviceField$OscillationAngle;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class OscillationAngle extends DeviceField {
      public static final OscillationAngle INSTANCE = new OscillationAngle();

      private OscillationAngle() {
         super((DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/database/DeviceField$OscillationDirection;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class OscillationDirection extends DeviceField {
      public static final OscillationDirection INSTANCE = new OscillationDirection();

      private OscillationDirection() {
         super((DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/database/DeviceField$OscillationFanSpeed;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class OscillationFanSpeed extends DeviceField {
      public static final OscillationFanSpeed INSTANCE = new OscillationFanSpeed();

      private OscillationFanSpeed() {
         super((DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/database/DeviceField$OscillationState;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class OscillationState extends DeviceField {
      public static final OscillationState INSTANCE = new OscillationState();

      private OscillationState() {
         super((DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/database/DeviceField$PanelDisplayMode;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class PanelDisplayMode extends DeviceField {
      public static final PanelDisplayMode INSTANCE = new PanelDisplayMode();

      private PanelDisplayMode() {
         super((DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/database/DeviceField$RoomType;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class RoomType extends DeviceField {
      public static final RoomType INSTANCE = new RoomType();

      private RoomType() {
         super((DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/database/DeviceField$Rpm;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Rpm extends DeviceField {
      public static final Rpm INSTANCE = new Rpm();

      private Rpm() {
         super((DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/database/DeviceField$SafetySwitch;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class SafetySwitch extends DeviceField {
      public static final SafetySwitch INSTANCE = new SafetySwitch();

      private SafetySwitch() {
         super((DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/database/DeviceField$SelectedSensor;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class SelectedSensor extends DeviceField {
      public static final SelectedSensor INSTANCE = new SelectedSensor();

      private SelectedSensor() {
         super((DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/database/DeviceField$SensorMode;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class SensorMode extends DeviceField {
      public static final SensorMode INSTANCE = new SensorMode();

      private SensorMode() {
         super((DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/database/DeviceField$SensorRange;", "Lcom/blueair/database/DeviceField;", "Lcom/blueair/database/DeviceField$SensorRanges;", "<init>", "()V", "database_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class SensorRange extends DeviceField {
      public static final SensorRange INSTANCE = new SensorRange();

      private SensorRange() {
         super((DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0013\n\u0002\b\r\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u0010"},
      d2 = {"Lcom/blueair/database/DeviceField$SensorRanges;", "", "pm1Ranges", "", "pm10Ranges", "pm25Ranges", "vocRanges", "hchoRanges", "<init>", "([D[D[D[D[D)V", "getPm1Ranges", "()[D", "getPm10Ranges", "getPm25Ranges", "getVocRanges", "getHchoRanges", "database_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class SensorRanges {
      private final double[] hchoRanges;
      private final double[] pm10Ranges;
      private final double[] pm1Ranges;
      private final double[] pm25Ranges;
      private final double[] vocRanges;

      public SensorRanges(double[] var1, double[] var2, double[] var3, double[] var4, double[] var5) {
         Intrinsics.checkNotNullParameter(var1, "pm1Ranges");
         Intrinsics.checkNotNullParameter(var2, "pm10Ranges");
         Intrinsics.checkNotNullParameter(var3, "pm25Ranges");
         Intrinsics.checkNotNullParameter(var4, "vocRanges");
         Intrinsics.checkNotNullParameter(var5, "hchoRanges");
         super();
         this.pm1Ranges = var1;
         this.pm10Ranges = var2;
         this.pm25Ranges = var3;
         this.vocRanges = var4;
         this.hchoRanges = var5;
      }

      public final double[] getHchoRanges() {
         return this.hchoRanges;
      }

      public final double[] getPm10Ranges() {
         return this.pm10Ranges;
      }

      public final double[] getPm1Ranges() {
         return this.pm1Ranges;
      }

      public final double[] getPm25Ranges() {
         return this.pm25Ranges;
      }

      public final double[] getVocRanges() {
         return this.vocRanges;
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/database/DeviceField$SerialNumber;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class SerialNumber extends DeviceField {
      public static final SerialNumber INSTANCE = new SerialNumber();

      private SerialNumber() {
         super((DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/database/DeviceField$SmartSubMode;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class SmartSubMode extends DeviceField {
      public static final SmartSubMode INSTANCE = new SmartSubMode();

      private SmartSubMode() {
         super((DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/database/DeviceField$StandbyMode;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class StandbyMode extends DeviceField {
      public static final StandbyMode INSTANCE = new StandbyMode();

      private StandbyMode() {
         super((DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/database/DeviceField$TemperatureUnit;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class TemperatureUnit extends DeviceField {
      public static final TemperatureUnit INSTANCE = new TemperatureUnit();

      private TemperatureUnit() {
         super((DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/database/DeviceField$TimerDuration;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class TimerDuration extends DeviceField {
      public static final TimerDuration INSTANCE = new TimerDuration();

      private TimerDuration() {
         super((DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"},
      d2 = {"Lcom/blueair/database/DeviceField$TimerLeftTime;", "Lcom/blueair/database/DeviceField;", "Lkotlin/Pair;", "", "", "<init>", "()V", "database_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class TimerLeftTime extends DeviceField {
      public static final TimerLeftTime INSTANCE = new TimerLeftTime();

      private TimerLeftTime() {
         super((DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/database/DeviceField$TimerStatus;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class TimerStatus extends DeviceField {
      public static final TimerStatus INSTANCE = new TimerStatus();

      private TimerStatus() {
         super((DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/database/DeviceField$Unknown;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Unknown extends DeviceField {
      public static final Unknown INSTANCE = new Unknown();

      private Unknown() {
         super((DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/database/DeviceField$UpdateProgress;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class UpdateProgress extends DeviceField {
      public static final UpdateProgress INSTANCE = new UpdateProgress();

      private UpdateProgress() {
         super((DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/database/DeviceField$Use24Hour;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Use24Hour extends DeviceField {
      public static final Use24Hour INSTANCE = new Use24Hour();

      private Use24Hour() {
         super((DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/database/DeviceField$WaterInfill;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class WaterInfill extends DeviceField {
      public static final WaterInfill INSTANCE = new WaterInfill();

      private WaterInfill() {
         super((DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/database/DeviceField$WaterLevel;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class WaterLevel extends DeviceField {
      public static final WaterLevel INSTANCE = new WaterLevel();

      private WaterLevel() {
         super((DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/database/DeviceField$WaterShortage;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class WaterShortage extends DeviceField {
      public static final WaterShortage INSTANCE = new WaterShortage();

      private WaterShortage() {
         super((DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/database/DeviceField$WaterTankFailure;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class WaterTankFailure extends DeviceField {
      public static final WaterTankFailure INSTANCE = new WaterTankFailure();

      private WaterTankFailure() {
         super((DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/database/DeviceField$WickUsage;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class WickUsage extends DeviceField {
      public static final WickUsage INSTANCE = new WickUsage();

      private WickUsage() {
         super((DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/database/DeviceField$WickdryDone;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class WickdryDone extends DeviceField {
      public static final WickdryDone INSTANCE = new WickdryDone();

      private WickdryDone() {
         super((DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/database/DeviceField$WickdryDuration;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class WickdryDuration extends DeviceField {
      public static final WickdryDuration INSTANCE = new WickdryDuration();

      private WickdryDuration() {
         super((DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/database/DeviceField$WickdryEnabled;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class WickdryEnabled extends DeviceField {
      public static final WickdryEnabled INSTANCE = new WickdryEnabled();

      private WickdryEnabled() {
         super((DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"},
      d2 = {"Lcom/blueair/database/DeviceField$WickdryLeftTime;", "Lcom/blueair/database/DeviceField;", "Lkotlin/Pair;", "", "", "<init>", "()V", "database_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class WickdryLeftTime extends DeviceField {
      public static final WickdryLeftTime INSTANCE = new WickdryLeftTime();

      private WickdryLeftTime() {
         super((DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/database/DeviceField$WickdryOn;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class WickdryOn extends DeviceField {
      public static final WickdryOn INSTANCE = new WickdryOn();

      private WickdryOn() {
         super((DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/database/DeviceField$WifiFirmware;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class WifiFirmware extends DeviceField {
      public static final WifiFirmware INSTANCE = new WifiFirmware();

      private WifiFirmware() {
         super((DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/database/DeviceField$YwrmEnabled;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class YwrmEnabled extends DeviceField {
      public static final YwrmEnabled INSTANCE = new YwrmEnabled();

      private YwrmEnabled() {
         super((DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/database/DeviceField$YwrmUsage;", "Lcom/blueair/database/DeviceField;", "", "<init>", "()V", "database_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class YwrmUsage extends DeviceField {
      public static final YwrmUsage INSTANCE = new YwrmUsage();

      private YwrmUsage() {
         super((DefaultConstructorMarker)null);
      }
   }
}
