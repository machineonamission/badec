package com.blueair.core.model;

import com.blueair.adddevice.model.AddDeviceState$$ExternalSyntheticBackport0;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000Ð\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\bV\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:P\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXB\u0013\b\u0004\u0012\b\u0010\u0003\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0004\u0010\u0005R\u0018\u0010\u0003\u001a\u0004\u0018\u00018\u0000X\u0096\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001yYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~\u007f\u0080\u0001\u0081\u0001\u0082\u0001\u0083\u0001\u0084\u0001\u0085\u0001\u0086\u0001\u0087\u0001\u0088\u0001\u0089\u0001\u008a\u0001\u008b\u0001\u008c\u0001\u008d\u0001\u008e\u0001\u008f\u0001\u0090\u0001\u0091\u0001\u0092\u0001\u0093\u0001\u0094\u0001\u0095\u0001\u0096\u0001\u0097\u0001\u0098\u0001\u0099\u0001\u009a\u0001\u009b\u0001\u009c\u0001\u009d\u0001\u009e\u0001\u009f\u0001 \u0001¡\u0001¢\u0001£\u0001¤\u0001¥\u0001¦\u0001§\u0001¨\u0001¨\u0006©\u0001"},
   d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute;", "T", "", "value", "<init>", "(Ljava/lang/Object;)V", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "ConnectivityStatus", "LatestSensorDataPoint", "FanSpeed", "FanSpeedManualOrAuto", "AutoMode", "Brightness", "ChildLock", "GermShield", "GermShieldNight", "G4NightMode", "SafetySwitch", "Unknown", "StandByMode", "EcoMode", "HinsMode", "HinsNightMode", "FilterUsage", "Disinfection", "DisinfectLeftTime", "WickdryEnabled", "WickdryOn", "WickdryLeftTime", "WickUsage", "WaterShortage", "AutoRh", "TimerStatus", "TimerDuration", "TimerLeftTime", "TemperatureUnit", "OscillationState", "OscillationAngle", "OscillationDirection", "OscillationFanSpeed", "MainMode", "ApSubMode", "ApFanSpeed", "HeatSubMode", "HeatFanSpeed", "HeatAutoTmp", "HeatEcoTmp", "CoolSubMode", "CoolFanSpeed", "CoolAutoTag", "CoolAutoPresets", "CoolEcoTag", "CoolEcoPresets", "Mode", "HumMode", "WaterLevel", "DehSubMode", "WaterTankFailure", "SmartSubMode", "DetectCat", "BodyMounted", "CleanAirEta", "PanelDisplayMode", "HoverEnabled", "AirRefreshEnabled", "AirRefreshStatus", "AirRefreshDuration", "AirRefreshTimeStamp", "AirRefreshStartTimeStamp", "AirRefreshEndTimeStamp", "RoomType", "NightLampBrightness", "NightLampSteplessBrightness", "WickdryDuration", "WickdryDone", "YwrmEnabled", "YwrmUsage", "Alarms", "HumSubMode", "Use24Hour", "WaterInfill", "SensorMode", "NightModeStartTime", "CoolFanSpeedLevel", "CoolAutoLevel", "DualOscillationConfig", "Rpm", "Lcom/blueair/core/model/DeviceStreamAttribute$AirRefreshDuration;", "Lcom/blueair/core/model/DeviceStreamAttribute$AirRefreshEnabled;", "Lcom/blueair/core/model/DeviceStreamAttribute$AirRefreshEndTimeStamp;", "Lcom/blueair/core/model/DeviceStreamAttribute$AirRefreshStartTimeStamp;", "Lcom/blueair/core/model/DeviceStreamAttribute$AirRefreshStatus;", "Lcom/blueair/core/model/DeviceStreamAttribute$AirRefreshTimeStamp;", "Lcom/blueair/core/model/DeviceStreamAttribute$Alarms;", "Lcom/blueair/core/model/DeviceStreamAttribute$ApFanSpeed;", "Lcom/blueair/core/model/DeviceStreamAttribute$ApSubMode;", "Lcom/blueair/core/model/DeviceStreamAttribute$AutoMode;", "Lcom/blueair/core/model/DeviceStreamAttribute$AutoRh;", "Lcom/blueair/core/model/DeviceStreamAttribute$BodyMounted;", "Lcom/blueair/core/model/DeviceStreamAttribute$Brightness;", "Lcom/blueair/core/model/DeviceStreamAttribute$ChildLock;", "Lcom/blueair/core/model/DeviceStreamAttribute$CleanAirEta;", "Lcom/blueair/core/model/DeviceStreamAttribute$ConnectivityStatus;", "Lcom/blueair/core/model/DeviceStreamAttribute$CoolAutoLevel;", "Lcom/blueair/core/model/DeviceStreamAttribute$CoolAutoPresets;", "Lcom/blueair/core/model/DeviceStreamAttribute$CoolAutoTag;", "Lcom/blueair/core/model/DeviceStreamAttribute$CoolEcoPresets;", "Lcom/blueair/core/model/DeviceStreamAttribute$CoolEcoTag;", "Lcom/blueair/core/model/DeviceStreamAttribute$CoolFanSpeed;", "Lcom/blueair/core/model/DeviceStreamAttribute$CoolFanSpeedLevel;", "Lcom/blueair/core/model/DeviceStreamAttribute$CoolSubMode;", "Lcom/blueair/core/model/DeviceStreamAttribute$DehSubMode;", "Lcom/blueair/core/model/DeviceStreamAttribute$DetectCat;", "Lcom/blueair/core/model/DeviceStreamAttribute$DisinfectLeftTime;", "Lcom/blueair/core/model/DeviceStreamAttribute$Disinfection;", "Lcom/blueair/core/model/DeviceStreamAttribute$DualOscillationConfig;", "Lcom/blueair/core/model/DeviceStreamAttribute$EcoMode;", "Lcom/blueair/core/model/DeviceStreamAttribute$FanSpeed;", "Lcom/blueair/core/model/DeviceStreamAttribute$FanSpeedManualOrAuto;", "Lcom/blueair/core/model/DeviceStreamAttribute$FilterUsage;", "Lcom/blueair/core/model/DeviceStreamAttribute$G4NightMode;", "Lcom/blueair/core/model/DeviceStreamAttribute$GermShield;", "Lcom/blueair/core/model/DeviceStreamAttribute$GermShieldNight;", "Lcom/blueair/core/model/DeviceStreamAttribute$HeatAutoTmp;", "Lcom/blueair/core/model/DeviceStreamAttribute$HeatEcoTmp;", "Lcom/blueair/core/model/DeviceStreamAttribute$HeatFanSpeed;", "Lcom/blueair/core/model/DeviceStreamAttribute$HeatSubMode;", "Lcom/blueair/core/model/DeviceStreamAttribute$HinsMode;", "Lcom/blueair/core/model/DeviceStreamAttribute$HinsNightMode;", "Lcom/blueair/core/model/DeviceStreamAttribute$HoverEnabled;", "Lcom/blueair/core/model/DeviceStreamAttribute$HumMode;", "Lcom/blueair/core/model/DeviceStreamAttribute$HumSubMode;", "Lcom/blueair/core/model/DeviceStreamAttribute$LatestSensorDataPoint;", "Lcom/blueair/core/model/DeviceStreamAttribute$MainMode;", "Lcom/blueair/core/model/DeviceStreamAttribute$Mode;", "Lcom/blueair/core/model/DeviceStreamAttribute$NightLampBrightness;", "Lcom/blueair/core/model/DeviceStreamAttribute$NightLampSteplessBrightness;", "Lcom/blueair/core/model/DeviceStreamAttribute$NightModeStartTime;", "Lcom/blueair/core/model/DeviceStreamAttribute$OscillationAngle;", "Lcom/blueair/core/model/DeviceStreamAttribute$OscillationDirection;", "Lcom/blueair/core/model/DeviceStreamAttribute$OscillationFanSpeed;", "Lcom/blueair/core/model/DeviceStreamAttribute$OscillationState;", "Lcom/blueair/core/model/DeviceStreamAttribute$PanelDisplayMode;", "Lcom/blueair/core/model/DeviceStreamAttribute$RoomType;", "Lcom/blueair/core/model/DeviceStreamAttribute$Rpm;", "Lcom/blueair/core/model/DeviceStreamAttribute$SafetySwitch;", "Lcom/blueair/core/model/DeviceStreamAttribute$SensorMode;", "Lcom/blueair/core/model/DeviceStreamAttribute$SmartSubMode;", "Lcom/blueair/core/model/DeviceStreamAttribute$StandByMode;", "Lcom/blueair/core/model/DeviceStreamAttribute$TemperatureUnit;", "Lcom/blueair/core/model/DeviceStreamAttribute$TimerDuration;", "Lcom/blueair/core/model/DeviceStreamAttribute$TimerLeftTime;", "Lcom/blueair/core/model/DeviceStreamAttribute$TimerStatus;", "Lcom/blueair/core/model/DeviceStreamAttribute$Unknown;", "Lcom/blueair/core/model/DeviceStreamAttribute$Use24Hour;", "Lcom/blueair/core/model/DeviceStreamAttribute$WaterInfill;", "Lcom/blueair/core/model/DeviceStreamAttribute$WaterLevel;", "Lcom/blueair/core/model/DeviceStreamAttribute$WaterShortage;", "Lcom/blueair/core/model/DeviceStreamAttribute$WaterTankFailure;", "Lcom/blueair/core/model/DeviceStreamAttribute$WickUsage;", "Lcom/blueair/core/model/DeviceStreamAttribute$WickdryDone;", "Lcom/blueair/core/model/DeviceStreamAttribute$WickdryDuration;", "Lcom/blueair/core/model/DeviceStreamAttribute$WickdryEnabled;", "Lcom/blueair/core/model/DeviceStreamAttribute$WickdryLeftTime;", "Lcom/blueair/core/model/DeviceStreamAttribute$WickdryOn;", "Lcom/blueair/core/model/DeviceStreamAttribute$YwrmEnabled;", "Lcom/blueair/core/model/DeviceStreamAttribute$YwrmUsage;", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public abstract class DeviceStreamAttribute {
   private final Object value;

   private DeviceStreamAttribute(Object var1) {
      this.value = var1;
   }

   // $FF: synthetic method
   public DeviceStreamAttribute(Object var1, DefaultConstructorMarker var2) {
      this(var1);
   }

   public Object getValue() {
      return this.value;
   }

   @Metadata(
      d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"},
      d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$AirRefreshDuration;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(I)V", "getValue", "()Ljava/lang/Integer;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class AirRefreshDuration extends DeviceStreamAttribute {
      private final int value;

      public AirRefreshDuration(int var1) {
         super(var1, (DefaultConstructorMarker)null);
         this.value = var1;
      }

      // $FF: synthetic method
      public static AirRefreshDuration copy$default(AirRefreshDuration var0, int var1, int var2, Object var3) {
         if ((var2 & 1) != 0) {
            var1 = var0.value;
         }

         return var0.copy(var1);
      }

      public final int component1() {
         return this.value;
      }

      public final AirRefreshDuration copy(int var1) {
         return new AirRefreshDuration(var1);
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof AirRefreshDuration)) {
            return false;
         } else {
            var1 = var1;
            return this.value == var1.value;
         }
      }

      public Integer getValue() {
         return this.value;
      }

      public int hashCode() {
         return this.value;
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder("AirRefreshDuration(value=");
         var1.append(this.value);
         var1.append(')');
         return var1.toString();
      }
   }

   @Metadata(
      d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"},
      d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$AirRefreshEnabled;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(Z)V", "getValue", "()Ljava/lang/Boolean;", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class AirRefreshEnabled extends DeviceStreamAttribute {
      private final boolean value;

      public AirRefreshEnabled(boolean var1) {
         super(var1, (DefaultConstructorMarker)null);
         this.value = var1;
      }

      // $FF: synthetic method
      public static AirRefreshEnabled copy$default(AirRefreshEnabled var0, boolean var1, int var2, Object var3) {
         if ((var2 & 1) != 0) {
            var1 = var0.value;
         }

         return var0.copy(var1);
      }

      public final boolean component1() {
         return this.value;
      }

      public final AirRefreshEnabled copy(boolean var1) {
         return new AirRefreshEnabled(var1);
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof AirRefreshEnabled)) {
            return false;
         } else {
            var1 = var1;
            return this.value == var1.value;
         }
      }

      public Boolean getValue() {
         return this.value;
      }

      public int hashCode() {
         return AddDeviceState$$ExternalSyntheticBackport0.m(this.value);
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder("AirRefreshEnabled(value=");
         var1.append(this.value);
         var1.append(')');
         return var1.toString();
      }
   }

   @Metadata(
      d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"},
      d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$AirRefreshEndTimeStamp;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(I)V", "getValue", "()Ljava/lang/Integer;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class AirRefreshEndTimeStamp extends DeviceStreamAttribute {
      private final int value;

      public AirRefreshEndTimeStamp(int var1) {
         super(var1, (DefaultConstructorMarker)null);
         this.value = var1;
      }

      // $FF: synthetic method
      public static AirRefreshEndTimeStamp copy$default(AirRefreshEndTimeStamp var0, int var1, int var2, Object var3) {
         if ((var2 & 1) != 0) {
            var1 = var0.value;
         }

         return var0.copy(var1);
      }

      public final int component1() {
         return this.value;
      }

      public final AirRefreshEndTimeStamp copy(int var1) {
         return new AirRefreshEndTimeStamp(var1);
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof AirRefreshEndTimeStamp)) {
            return false;
         } else {
            var1 = var1;
            return this.value == var1.value;
         }
      }

      public Integer getValue() {
         return this.value;
      }

      public int hashCode() {
         return this.value;
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder("AirRefreshEndTimeStamp(value=");
         var1.append(this.value);
         var1.append(')');
         return var1.toString();
      }
   }

   @Metadata(
      d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"},
      d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$AirRefreshStartTimeStamp;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(I)V", "getValue", "()Ljava/lang/Integer;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class AirRefreshStartTimeStamp extends DeviceStreamAttribute {
      private final int value;

      public AirRefreshStartTimeStamp(int var1) {
         super(var1, (DefaultConstructorMarker)null);
         this.value = var1;
      }

      // $FF: synthetic method
      public static AirRefreshStartTimeStamp copy$default(AirRefreshStartTimeStamp var0, int var1, int var2, Object var3) {
         if ((var2 & 1) != 0) {
            var1 = var0.value;
         }

         return var0.copy(var1);
      }

      public final int component1() {
         return this.value;
      }

      public final AirRefreshStartTimeStamp copy(int var1) {
         return new AirRefreshStartTimeStamp(var1);
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof AirRefreshStartTimeStamp)) {
            return false;
         } else {
            var1 = var1;
            return this.value == var1.value;
         }
      }

      public Integer getValue() {
         return this.value;
      }

      public int hashCode() {
         return this.value;
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder("AirRefreshStartTimeStamp(value=");
         var1.append(this.value);
         var1.append(')');
         return var1.toString();
      }
   }

   @Metadata(
      d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"},
      d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$AirRefreshStatus;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(I)V", "getValue", "()Ljava/lang/Integer;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class AirRefreshStatus extends DeviceStreamAttribute {
      private final int value;

      public AirRefreshStatus(int var1) {
         super(var1, (DefaultConstructorMarker)null);
         this.value = var1;
      }

      // $FF: synthetic method
      public static AirRefreshStatus copy$default(AirRefreshStatus var0, int var1, int var2, Object var3) {
         if ((var2 & 1) != 0) {
            var1 = var0.value;
         }

         return var0.copy(var1);
      }

      public final int component1() {
         return this.value;
      }

      public final AirRefreshStatus copy(int var1) {
         return new AirRefreshStatus(var1);
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof AirRefreshStatus)) {
            return false;
         } else {
            var1 = var1;
            return this.value == var1.value;
         }
      }

      public Integer getValue() {
         return this.value;
      }

      public int hashCode() {
         return this.value;
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder("AirRefreshStatus(value=");
         var1.append(this.value);
         var1.append(')');
         return var1.toString();
      }
   }

   @Metadata(
      d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"},
      d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$AirRefreshTimeStamp;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(I)V", "getValue", "()Ljava/lang/Integer;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class AirRefreshTimeStamp extends DeviceStreamAttribute {
      private final int value;

      public AirRefreshTimeStamp(int var1) {
         super(var1, (DefaultConstructorMarker)null);
         this.value = var1;
      }

      // $FF: synthetic method
      public static AirRefreshTimeStamp copy$default(AirRefreshTimeStamp var0, int var1, int var2, Object var3) {
         if ((var2 & 1) != 0) {
            var1 = var0.value;
         }

         return var0.copy(var1);
      }

      public final int component1() {
         return this.value;
      }

      public final AirRefreshTimeStamp copy(int var1) {
         return new AirRefreshTimeStamp(var1);
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof AirRefreshTimeStamp)) {
            return false;
         } else {
            var1 = var1;
            return this.value == var1.value;
         }
      }

      public Integer getValue() {
         return this.value;
      }

      public int hashCode() {
         return this.value;
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder("AirRefreshTimeStamp(value=");
         var1.append(this.value);
         var1.append(')');
         return var1.toString();
      }
   }

   @Metadata(
      d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00020\u0001B\u0017\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002HÆ\u0003J\u001b\u0010\n\u001a\u00020\u00002\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u001c\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"},
      d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$Alarms;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "Lcom/blueair/core/model/DeviceAlarm;", "value", "<init>", "(Ljava/util/List;)V", "getValue", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Alarms extends DeviceStreamAttribute {
      private final List value;

      public Alarms(List var1) {
         Intrinsics.checkNotNullParameter(var1, "value");
         super(var1, (DefaultConstructorMarker)null);
         this.value = var1;
      }

      // $FF: synthetic method
      public static Alarms copy$default(Alarms var0, List var1, int var2, Object var3) {
         if ((var2 & 1) != 0) {
            var1 = var0.value;
         }

         return var0.copy(var1);
      }

      public final List component1() {
         return this.value;
      }

      public final Alarms copy(List var1) {
         Intrinsics.checkNotNullParameter(var1, "value");
         return new Alarms(var1);
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof Alarms)) {
            return false;
         } else {
            var1 = var1;
            return Intrinsics.areEqual(this.value, var1.value);
         }
      }

      public List getValue() {
         return this.value;
      }

      public int hashCode() {
         return this.value.hashCode();
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder("Alarms(value=");
         var1.append(this.value);
         var1.append(')');
         return var1.toString();
      }
   }

   @Metadata(
      d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"},
      d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$ApFanSpeed;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(I)V", "getValue", "()Ljava/lang/Integer;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class ApFanSpeed extends DeviceStreamAttribute {
      private final int value;

      public ApFanSpeed(int var1) {
         super(var1, (DefaultConstructorMarker)null);
         this.value = var1;
      }

      // $FF: synthetic method
      public static ApFanSpeed copy$default(ApFanSpeed var0, int var1, int var2, Object var3) {
         if ((var2 & 1) != 0) {
            var1 = var0.value;
         }

         return var0.copy(var1);
      }

      public final int component1() {
         return this.value;
      }

      public final ApFanSpeed copy(int var1) {
         return new ApFanSpeed(var1);
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof ApFanSpeed)) {
            return false;
         } else {
            var1 = var1;
            return this.value == var1.value;
         }
      }

      public Integer getValue() {
         return this.value;
      }

      public int hashCode() {
         return this.value;
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder("ApFanSpeed(value=");
         var1.append(this.value);
         var1.append(')');
         return var1.toString();
      }
   }

   @Metadata(
      d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"},
      d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$ApSubMode;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(I)V", "getValue", "()Ljava/lang/Integer;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class ApSubMode extends DeviceStreamAttribute {
      private final int value;

      public ApSubMode(int var1) {
         super(var1, (DefaultConstructorMarker)null);
         this.value = var1;
      }

      // $FF: synthetic method
      public static ApSubMode copy$default(ApSubMode var0, int var1, int var2, Object var3) {
         if ((var2 & 1) != 0) {
            var1 = var0.value;
         }

         return var0.copy(var1);
      }

      public final int component1() {
         return this.value;
      }

      public final ApSubMode copy(int var1) {
         return new ApSubMode(var1);
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof ApSubMode)) {
            return false;
         } else {
            var1 = var1;
            return this.value == var1.value;
         }
      }

      public Integer getValue() {
         return this.value;
      }

      public int hashCode() {
         return this.value;
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder("ApSubMode(value=");
         var1.append(this.value);
         var1.append(')');
         return var1.toString();
      }
   }

   @Metadata(
      d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"},
      d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$AutoMode;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class AutoMode extends DeviceStreamAttribute {
      private final String value;

      public AutoMode(String var1) {
         Intrinsics.checkNotNullParameter(var1, "value");
         super(var1, (DefaultConstructorMarker)null);
         this.value = var1;
      }

      // $FF: synthetic method
      public static AutoMode copy$default(AutoMode var0, String var1, int var2, Object var3) {
         if ((var2 & 1) != 0) {
            var1 = var0.value;
         }

         return var0.copy(var1);
      }

      public final String component1() {
         return this.value;
      }

      public final AutoMode copy(String var1) {
         Intrinsics.checkNotNullParameter(var1, "value");
         return new AutoMode(var1);
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof AutoMode)) {
            return false;
         } else {
            var1 = var1;
            return Intrinsics.areEqual(this.value, var1.value);
         }
      }

      public String getValue() {
         return this.value;
      }

      public int hashCode() {
         return this.value.hashCode();
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder("AutoMode(value=");
         var1.append(this.value);
         var1.append(')');
         return var1.toString();
      }
   }

   @Metadata(
      d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"},
      d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$AutoRh;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(I)V", "getValue", "()Ljava/lang/Integer;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class AutoRh extends DeviceStreamAttribute {
      private final int value;

      public AutoRh(int var1) {
         super(var1, (DefaultConstructorMarker)null);
         this.value = var1;
      }

      // $FF: synthetic method
      public static AutoRh copy$default(AutoRh var0, int var1, int var2, Object var3) {
         if ((var2 & 1) != 0) {
            var1 = var0.value;
         }

         return var0.copy(var1);
      }

      public final int component1() {
         return this.value;
      }

      public final AutoRh copy(int var1) {
         return new AutoRh(var1);
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof AutoRh)) {
            return false;
         } else {
            var1 = var1;
            return this.value == var1.value;
         }
      }

      public Integer getValue() {
         return this.value;
      }

      public int hashCode() {
         return this.value;
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder("AutoRh(value=");
         var1.append(this.value);
         var1.append(')');
         return var1.toString();
      }
   }

   @Metadata(
      d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"},
      d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$BodyMounted;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(Z)V", "getValue", "()Ljava/lang/Boolean;", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class BodyMounted extends DeviceStreamAttribute {
      private final boolean value;

      public BodyMounted(boolean var1) {
         super(var1, (DefaultConstructorMarker)null);
         this.value = var1;
      }

      // $FF: synthetic method
      public static BodyMounted copy$default(BodyMounted var0, boolean var1, int var2, Object var3) {
         if ((var2 & 1) != 0) {
            var1 = var0.value;
         }

         return var0.copy(var1);
      }

      public final boolean component1() {
         return this.value;
      }

      public final BodyMounted copy(boolean var1) {
         return new BodyMounted(var1);
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof BodyMounted)) {
            return false;
         } else {
            var1 = var1;
            return this.value == var1.value;
         }
      }

      public Boolean getValue() {
         return this.value;
      }

      public int hashCode() {
         return AddDeviceState$$ExternalSyntheticBackport0.m(this.value);
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder("BodyMounted(value=");
         var1.append(this.value);
         var1.append(')');
         return var1.toString();
      }
   }

   @Metadata(
      d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"},
      d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$Brightness;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(I)V", "getValue", "()Ljava/lang/Integer;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Brightness extends DeviceStreamAttribute {
      private final int value;

      public Brightness(int var1) {
         super(var1, (DefaultConstructorMarker)null);
         this.value = var1;
      }

      // $FF: synthetic method
      public static Brightness copy$default(Brightness var0, int var1, int var2, Object var3) {
         if ((var2 & 1) != 0) {
            var1 = var0.value;
         }

         return var0.copy(var1);
      }

      public final int component1() {
         return this.value;
      }

      public final Brightness copy(int var1) {
         return new Brightness(var1);
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof Brightness)) {
            return false;
         } else {
            var1 = var1;
            return this.value == var1.value;
         }
      }

      public Integer getValue() {
         return this.value;
      }

      public int hashCode() {
         return this.value;
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder("Brightness(value=");
         var1.append(this.value);
         var1.append(')');
         return var1.toString();
      }
   }

   @Metadata(
      d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"},
      d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$ChildLock;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(Z)V", "getValue", "()Ljava/lang/Boolean;", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class ChildLock extends DeviceStreamAttribute {
      private final boolean value;

      public ChildLock(boolean var1) {
         super(var1, (DefaultConstructorMarker)null);
         this.value = var1;
      }

      // $FF: synthetic method
      public static ChildLock copy$default(ChildLock var0, boolean var1, int var2, Object var3) {
         if ((var2 & 1) != 0) {
            var1 = var0.value;
         }

         return var0.copy(var1);
      }

      public final boolean component1() {
         return this.value;
      }

      public final ChildLock copy(boolean var1) {
         return new ChildLock(var1);
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof ChildLock)) {
            return false;
         } else {
            var1 = var1;
            return this.value == var1.value;
         }
      }

      public Boolean getValue() {
         return this.value;
      }

      public int hashCode() {
         return AddDeviceState$$ExternalSyntheticBackport0.m(this.value);
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder("ChildLock(value=");
         var1.append(this.value);
         var1.append(')');
         return var1.toString();
      }
   }

   @Metadata(
      d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"},
      d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$CleanAirEta;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(I)V", "getValue", "()Ljava/lang/Integer;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class CleanAirEta extends DeviceStreamAttribute {
      private final int value;

      public CleanAirEta(int var1) {
         super(var1, (DefaultConstructorMarker)null);
         this.value = var1;
      }

      // $FF: synthetic method
      public static CleanAirEta copy$default(CleanAirEta var0, int var1, int var2, Object var3) {
         if ((var2 & 1) != 0) {
            var1 = var0.value;
         }

         return var0.copy(var1);
      }

      public final int component1() {
         return this.value;
      }

      public final CleanAirEta copy(int var1) {
         return new CleanAirEta(var1);
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof CleanAirEta)) {
            return false;
         } else {
            var1 = var1;
            return this.value == var1.value;
         }
      }

      public Integer getValue() {
         return this.value;
      }

      public int hashCode() {
         return this.value;
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder("CleanAirEta(value=");
         var1.append(this.value);
         var1.append(')');
         return var1.toString();
      }
   }

   @Metadata(
      d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"},
      d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$ConnectivityStatus;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(I)V", "getValue", "()Ljava/lang/Integer;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class ConnectivityStatus extends DeviceStreamAttribute {
      private final int value;

      public ConnectivityStatus(int var1) {
         super(var1, (DefaultConstructorMarker)null);
         this.value = var1;
      }

      // $FF: synthetic method
      public static ConnectivityStatus copy$default(ConnectivityStatus var0, int var1, int var2, Object var3) {
         if ((var2 & 1) != 0) {
            var1 = var0.value;
         }

         return var0.copy(var1);
      }

      public final int component1() {
         return this.value;
      }

      public final ConnectivityStatus copy(int var1) {
         return new ConnectivityStatus(var1);
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof ConnectivityStatus)) {
            return false;
         } else {
            var1 = var1;
            return this.value == var1.value;
         }
      }

      public Integer getValue() {
         return this.value;
      }

      public int hashCode() {
         return this.value;
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder("ConnectivityStatus(value=");
         var1.append(this.value);
         var1.append(')');
         return var1.toString();
      }
   }

   @Metadata(
      d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"},
      d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$CoolAutoLevel;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(I)V", "getValue", "()Ljava/lang/Integer;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class CoolAutoLevel extends DeviceStreamAttribute {
      private final int value;

      public CoolAutoLevel(int var1) {
         super(var1, (DefaultConstructorMarker)null);
         this.value = var1;
      }

      // $FF: synthetic method
      public static CoolAutoLevel copy$default(CoolAutoLevel var0, int var1, int var2, Object var3) {
         if ((var2 & 1) != 0) {
            var1 = var0.value;
         }

         return var0.copy(var1);
      }

      public final int component1() {
         return this.value;
      }

      public final CoolAutoLevel copy(int var1) {
         return new CoolAutoLevel(var1);
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof CoolAutoLevel)) {
            return false;
         } else {
            var1 = var1;
            return this.value == var1.value;
         }
      }

      public Integer getValue() {
         return this.value;
      }

      public int hashCode() {
         return this.value;
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder("CoolAutoLevel(value=");
         var1.append(this.value);
         var1.append(')');
         return var1.toString();
      }
   }

   @Metadata(
      d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0013\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"},
      d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$CoolAutoPresets;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "([D)V", "getValue", "()[D", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class CoolAutoPresets extends DeviceStreamAttribute {
      private final double[] value;

      public CoolAutoPresets(double[] var1) {
         Intrinsics.checkNotNullParameter(var1, "value");
         super(var1, (DefaultConstructorMarker)null);
         this.value = var1;
      }

      // $FF: synthetic method
      public static CoolAutoPresets copy$default(CoolAutoPresets var0, double[] var1, int var2, Object var3) {
         if ((var2 & 1) != 0) {
            var1 = var0.value;
         }

         return var0.copy(var1);
      }

      public final double[] component1() {
         return this.value;
      }

      public final CoolAutoPresets copy(double[] var1) {
         Intrinsics.checkNotNullParameter(var1, "value");
         return new CoolAutoPresets(var1);
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof CoolAutoPresets)) {
            return false;
         } else {
            var1 = var1;
            return Intrinsics.areEqual(this.value, var1.value);
         }
      }

      public double[] getValue() {
         return this.value;
      }

      public int hashCode() {
         return Arrays.hashCode(this.value);
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder("CoolAutoPresets(value=");
         var1.append(Arrays.toString(this.value));
         var1.append(')');
         return var1.toString();
      }
   }

   @Metadata(
      d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"},
      d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$CoolAutoTag;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(I)V", "getValue", "()Ljava/lang/Integer;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class CoolAutoTag extends DeviceStreamAttribute {
      private final int value;

      public CoolAutoTag(int var1) {
         super(var1, (DefaultConstructorMarker)null);
         this.value = var1;
      }

      // $FF: synthetic method
      public static CoolAutoTag copy$default(CoolAutoTag var0, int var1, int var2, Object var3) {
         if ((var2 & 1) != 0) {
            var1 = var0.value;
         }

         return var0.copy(var1);
      }

      public final int component1() {
         return this.value;
      }

      public final CoolAutoTag copy(int var1) {
         return new CoolAutoTag(var1);
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof CoolAutoTag)) {
            return false;
         } else {
            var1 = var1;
            return this.value == var1.value;
         }
      }

      public Integer getValue() {
         return this.value;
      }

      public int hashCode() {
         return this.value;
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder("CoolAutoTag(value=");
         var1.append(this.value);
         var1.append(')');
         return var1.toString();
      }
   }

   @Metadata(
      d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0013\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"},
      d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$CoolEcoPresets;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "([D)V", "getValue", "()[D", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class CoolEcoPresets extends DeviceStreamAttribute {
      private final double[] value;

      public CoolEcoPresets(double[] var1) {
         Intrinsics.checkNotNullParameter(var1, "value");
         super(var1, (DefaultConstructorMarker)null);
         this.value = var1;
      }

      // $FF: synthetic method
      public static CoolEcoPresets copy$default(CoolEcoPresets var0, double[] var1, int var2, Object var3) {
         if ((var2 & 1) != 0) {
            var1 = var0.value;
         }

         return var0.copy(var1);
      }

      public final double[] component1() {
         return this.value;
      }

      public final CoolEcoPresets copy(double[] var1) {
         Intrinsics.checkNotNullParameter(var1, "value");
         return new CoolEcoPresets(var1);
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof CoolEcoPresets)) {
            return false;
         } else {
            var1 = var1;
            return Intrinsics.areEqual(this.value, var1.value);
         }
      }

      public double[] getValue() {
         return this.value;
      }

      public int hashCode() {
         return Arrays.hashCode(this.value);
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder("CoolEcoPresets(value=");
         var1.append(Arrays.toString(this.value));
         var1.append(')');
         return var1.toString();
      }
   }

   @Metadata(
      d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"},
      d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$CoolEcoTag;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(I)V", "getValue", "()Ljava/lang/Integer;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class CoolEcoTag extends DeviceStreamAttribute {
      private final int value;

      public CoolEcoTag(int var1) {
         super(var1, (DefaultConstructorMarker)null);
         this.value = var1;
      }

      // $FF: synthetic method
      public static CoolEcoTag copy$default(CoolEcoTag var0, int var1, int var2, Object var3) {
         if ((var2 & 1) != 0) {
            var1 = var0.value;
         }

         return var0.copy(var1);
      }

      public final int component1() {
         return this.value;
      }

      public final CoolEcoTag copy(int var1) {
         return new CoolEcoTag(var1);
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof CoolEcoTag)) {
            return false;
         } else {
            var1 = var1;
            return this.value == var1.value;
         }
      }

      public Integer getValue() {
         return this.value;
      }

      public int hashCode() {
         return this.value;
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder("CoolEcoTag(value=");
         var1.append(this.value);
         var1.append(')');
         return var1.toString();
      }
   }

   @Metadata(
      d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"},
      d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$CoolFanSpeed;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(I)V", "getValue", "()Ljava/lang/Integer;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class CoolFanSpeed extends DeviceStreamAttribute {
      private final int value;

      public CoolFanSpeed(int var1) {
         super(var1, (DefaultConstructorMarker)null);
         this.value = var1;
      }

      // $FF: synthetic method
      public static CoolFanSpeed copy$default(CoolFanSpeed var0, int var1, int var2, Object var3) {
         if ((var2 & 1) != 0) {
            var1 = var0.value;
         }

         return var0.copy(var1);
      }

      public final int component1() {
         return this.value;
      }

      public final CoolFanSpeed copy(int var1) {
         return new CoolFanSpeed(var1);
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof CoolFanSpeed)) {
            return false;
         } else {
            var1 = var1;
            return this.value == var1.value;
         }
      }

      public Integer getValue() {
         return this.value;
      }

      public int hashCode() {
         return this.value;
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder("CoolFanSpeed(value=");
         var1.append(this.value);
         var1.append(')');
         return var1.toString();
      }
   }

   @Metadata(
      d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"},
      d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$CoolFanSpeedLevel;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(I)V", "getValue", "()Ljava/lang/Integer;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class CoolFanSpeedLevel extends DeviceStreamAttribute {
      private final int value;

      public CoolFanSpeedLevel(int var1) {
         super(var1, (DefaultConstructorMarker)null);
         this.value = var1;
      }

      // $FF: synthetic method
      public static CoolFanSpeedLevel copy$default(CoolFanSpeedLevel var0, int var1, int var2, Object var3) {
         if ((var2 & 1) != 0) {
            var1 = var0.value;
         }

         return var0.copy(var1);
      }

      public final int component1() {
         return this.value;
      }

      public final CoolFanSpeedLevel copy(int var1) {
         return new CoolFanSpeedLevel(var1);
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof CoolFanSpeedLevel)) {
            return false;
         } else {
            var1 = var1;
            return this.value == var1.value;
         }
      }

      public Integer getValue() {
         return this.value;
      }

      public int hashCode() {
         return this.value;
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder("CoolFanSpeedLevel(value=");
         var1.append(this.value);
         var1.append(')');
         return var1.toString();
      }
   }

   @Metadata(
      d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"},
      d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$CoolSubMode;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(I)V", "getValue", "()Ljava/lang/Integer;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class CoolSubMode extends DeviceStreamAttribute {
      private final int value;

      public CoolSubMode(int var1) {
         super(var1, (DefaultConstructorMarker)null);
         this.value = var1;
      }

      // $FF: synthetic method
      public static CoolSubMode copy$default(CoolSubMode var0, int var1, int var2, Object var3) {
         if ((var2 & 1) != 0) {
            var1 = var0.value;
         }

         return var0.copy(var1);
      }

      public final int component1() {
         return this.value;
      }

      public final CoolSubMode copy(int var1) {
         return new CoolSubMode(var1);
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof CoolSubMode)) {
            return false;
         } else {
            var1 = var1;
            return this.value == var1.value;
         }
      }

      public Integer getValue() {
         return this.value;
      }

      public int hashCode() {
         return this.value;
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder("CoolSubMode(value=");
         var1.append(this.value);
         var1.append(')');
         return var1.toString();
      }
   }

   @Metadata(
      d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"},
      d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$DehSubMode;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(I)V", "getValue", "()Ljava/lang/Integer;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class DehSubMode extends DeviceStreamAttribute {
      private final int value;

      public DehSubMode(int var1) {
         super(var1, (DefaultConstructorMarker)null);
         this.value = var1;
      }

      // $FF: synthetic method
      public static DehSubMode copy$default(DehSubMode var0, int var1, int var2, Object var3) {
         if ((var2 & 1) != 0) {
            var1 = var0.value;
         }

         return var0.copy(var1);
      }

      public final int component1() {
         return this.value;
      }

      public final DehSubMode copy(int var1) {
         return new DehSubMode(var1);
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof DehSubMode)) {
            return false;
         } else {
            var1 = var1;
            return this.value == var1.value;
         }
      }

      public Integer getValue() {
         return this.value;
      }

      public int hashCode() {
         return this.value;
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder("DehSubMode(value=");
         var1.append(this.value);
         var1.append(')');
         return var1.toString();
      }
   }

   @Metadata(
      d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"},
      d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$DetectCat;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(Z)V", "getValue", "()Ljava/lang/Boolean;", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class DetectCat extends DeviceStreamAttribute {
      private final boolean value;

      public DetectCat(boolean var1) {
         super(var1, (DefaultConstructorMarker)null);
         this.value = var1;
      }

      // $FF: synthetic method
      public static DetectCat copy$default(DetectCat var0, boolean var1, int var2, Object var3) {
         if ((var2 & 1) != 0) {
            var1 = var0.value;
         }

         return var0.copy(var1);
      }

      public final boolean component1() {
         return this.value;
      }

      public final DetectCat copy(boolean var1) {
         return new DetectCat(var1);
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof DetectCat)) {
            return false;
         } else {
            var1 = var1;
            return this.value == var1.value;
         }
      }

      public Boolean getValue() {
         return this.value;
      }

      public int hashCode() {
         return AddDeviceState$$ExternalSyntheticBackport0.m(this.value);
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder("DetectCat(value=");
         var1.append(this.value);
         var1.append(')');
         return var1.toString();
      }
   }

   @Metadata(
      d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001B\u001b\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002HÆ\u0003J\u001f\u0010\u000b\u001a\u00020\u00002\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R \u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0013"},
      d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$DisinfectLeftTime;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "Lkotlin/Pair;", "", "", "value", "<init>", "(Lkotlin/Pair;)V", "getValue", "()Lkotlin/Pair;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class DisinfectLeftTime extends DeviceStreamAttribute {
      private final Pair value;

      public DisinfectLeftTime(Pair var1) {
         Intrinsics.checkNotNullParameter(var1, "value");
         super(var1, (DefaultConstructorMarker)null);
         this.value = var1;
      }

      // $FF: synthetic method
      public static DisinfectLeftTime copy$default(DisinfectLeftTime var0, Pair var1, int var2, Object var3) {
         if ((var2 & 1) != 0) {
            var1 = var0.value;
         }

         return var0.copy(var1);
      }

      public final Pair component1() {
         return this.value;
      }

      public final DisinfectLeftTime copy(Pair var1) {
         Intrinsics.checkNotNullParameter(var1, "value");
         return new DisinfectLeftTime(var1);
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof DisinfectLeftTime)) {
            return false;
         } else {
            var1 = var1;
            return Intrinsics.areEqual(this.value, var1.value);
         }
      }

      public Pair getValue() {
         return this.value;
      }

      public int hashCode() {
         return this.value.hashCode();
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder("DisinfectLeftTime(value=");
         var1.append(this.value);
         var1.append(')');
         return var1.toString();
      }
   }

   @Metadata(
      d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"},
      d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$Disinfection;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(Z)V", "getValue", "()Ljava/lang/Boolean;", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Disinfection extends DeviceStreamAttribute {
      private final boolean value;

      public Disinfection(boolean var1) {
         super(var1, (DefaultConstructorMarker)null);
         this.value = var1;
      }

      // $FF: synthetic method
      public static Disinfection copy$default(Disinfection var0, boolean var1, int var2, Object var3) {
         if ((var2 & 1) != 0) {
            var1 = var0.value;
         }

         return var0.copy(var1);
      }

      public final boolean component1() {
         return this.value;
      }

      public final Disinfection copy(boolean var1) {
         return new Disinfection(var1);
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof Disinfection)) {
            return false;
         } else {
            var1 = var1;
            return this.value == var1.value;
         }
      }

      public Boolean getValue() {
         return this.value;
      }

      public int hashCode() {
         return AddDeviceState$$ExternalSyntheticBackport0.m(this.value);
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder("Disinfection(value=");
         var1.append(this.value);
         var1.append(')');
         return var1.toString();
      }
   }

   @Metadata(
      d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"},
      d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$DualOscillationConfig;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "Lcom/blueair/core/model/DualOscillationConfig;", "value", "<init>", "(Lcom/blueair/core/model/DualOscillationConfig;)V", "getValue", "()Lcom/blueair/core/model/DualOscillationConfig;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class DualOscillationConfig extends DeviceStreamAttribute {
      private final com.blueair.core.model.DualOscillationConfig value;

      public DualOscillationConfig(com.blueair.core.model.DualOscillationConfig var1) {
         Intrinsics.checkNotNullParameter(var1, "value");
         super(var1, (DefaultConstructorMarker)null);
         this.value = var1;
      }

      // $FF: synthetic method
      public static DualOscillationConfig copy$default(DualOscillationConfig var0, com.blueair.core.model.DualOscillationConfig var1, int var2, Object var3) {
         if ((var2 & 1) != 0) {
            var1 = var0.value;
         }

         return var0.copy(var1);
      }

      public final com.blueair.core.model.DualOscillationConfig component1() {
         return this.value;
      }

      public final DualOscillationConfig copy(com.blueair.core.model.DualOscillationConfig var1) {
         Intrinsics.checkNotNullParameter(var1, "value");
         return new DualOscillationConfig(var1);
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof DualOscillationConfig)) {
            return false;
         } else {
            var1 = var1;
            return Intrinsics.areEqual(this.value, var1.value);
         }
      }

      public com.blueair.core.model.DualOscillationConfig getValue() {
         return this.value;
      }

      public int hashCode() {
         return this.value.hashCode();
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder("DualOscillationConfig(value=");
         var1.append(this.value);
         var1.append(')');
         return var1.toString();
      }
   }

   @Metadata(
      d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"},
      d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$EcoMode;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(Z)V", "getValue", "()Ljava/lang/Boolean;", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class EcoMode extends DeviceStreamAttribute {
      private final boolean value;

      public EcoMode(boolean var1) {
         super(var1, (DefaultConstructorMarker)null);
         this.value = var1;
      }

      // $FF: synthetic method
      public static EcoMode copy$default(EcoMode var0, boolean var1, int var2, Object var3) {
         if ((var2 & 1) != 0) {
            var1 = var0.value;
         }

         return var0.copy(var1);
      }

      public final boolean component1() {
         return this.value;
      }

      public final EcoMode copy(boolean var1) {
         return new EcoMode(var1);
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof EcoMode)) {
            return false;
         } else {
            var1 = var1;
            return this.value == var1.value;
         }
      }

      public Boolean getValue() {
         return this.value;
      }

      public int hashCode() {
         return AddDeviceState$$ExternalSyntheticBackport0.m(this.value);
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder("EcoMode(value=");
         var1.append(this.value);
         var1.append(')');
         return var1.toString();
      }
   }

   @Metadata(
      d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"},
      d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$FanSpeed;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(I)V", "getValue", "()Ljava/lang/Integer;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class FanSpeed extends DeviceStreamAttribute {
      private final int value;

      public FanSpeed(int var1) {
         super(var1, (DefaultConstructorMarker)null);
         this.value = var1;
      }

      // $FF: synthetic method
      public static FanSpeed copy$default(FanSpeed var0, int var1, int var2, Object var3) {
         if ((var2 & 1) != 0) {
            var1 = var0.value;
         }

         return var0.copy(var1);
      }

      public final int component1() {
         return this.value;
      }

      public final FanSpeed copy(int var1) {
         return new FanSpeed(var1);
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof FanSpeed)) {
            return false;
         } else {
            var1 = var1;
            return this.value == var1.value;
         }
      }

      public Integer getValue() {
         return this.value;
      }

      public int hashCode() {
         return this.value;
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder("FanSpeed(value=");
         var1.append(this.value);
         var1.append(')');
         return var1.toString();
      }
   }

   @Metadata(
      d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"},
      d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$FanSpeedManualOrAuto;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(I)V", "getValue", "()Ljava/lang/Integer;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class FanSpeedManualOrAuto extends DeviceStreamAttribute {
      private final int value;

      public FanSpeedManualOrAuto(int var1) {
         super(var1, (DefaultConstructorMarker)null);
         this.value = var1;
      }

      // $FF: synthetic method
      public static FanSpeedManualOrAuto copy$default(FanSpeedManualOrAuto var0, int var1, int var2, Object var3) {
         if ((var2 & 1) != 0) {
            var1 = var0.value;
         }

         return var0.copy(var1);
      }

      public final int component1() {
         return this.value;
      }

      public final FanSpeedManualOrAuto copy(int var1) {
         return new FanSpeedManualOrAuto(var1);
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof FanSpeedManualOrAuto)) {
            return false;
         } else {
            var1 = var1;
            return this.value == var1.value;
         }
      }

      public Integer getValue() {
         return this.value;
      }

      public int hashCode() {
         return this.value;
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder("FanSpeedManualOrAuto(value=");
         var1.append(this.value);
         var1.append(')');
         return var1.toString();
      }
   }

   @Metadata(
      d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"},
      d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$FilterUsage;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(I)V", "getValue", "()Ljava/lang/Integer;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class FilterUsage extends DeviceStreamAttribute {
      private final int value;

      public FilterUsage(int var1) {
         super(var1, (DefaultConstructorMarker)null);
         this.value = var1;
      }

      // $FF: synthetic method
      public static FilterUsage copy$default(FilterUsage var0, int var1, int var2, Object var3) {
         if ((var2 & 1) != 0) {
            var1 = var0.value;
         }

         return var0.copy(var1);
      }

      public final int component1() {
         return this.value;
      }

      public final FilterUsage copy(int var1) {
         return new FilterUsage(var1);
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof FilterUsage)) {
            return false;
         } else {
            var1 = var1;
            return this.value == var1.value;
         }
      }

      public Integer getValue() {
         return this.value;
      }

      public int hashCode() {
         return this.value;
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder("FilterUsage(value=");
         var1.append(this.value);
         var1.append(')');
         return var1.toString();
      }
   }

   @Metadata(
      d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"},
      d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$G4NightMode;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(Z)V", "getValue", "()Ljava/lang/Boolean;", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class G4NightMode extends DeviceStreamAttribute {
      private final boolean value;

      public G4NightMode(boolean var1) {
         super(var1, (DefaultConstructorMarker)null);
         this.value = var1;
      }

      // $FF: synthetic method
      public static G4NightMode copy$default(G4NightMode var0, boolean var1, int var2, Object var3) {
         if ((var2 & 1) != 0) {
            var1 = var0.value;
         }

         return var0.copy(var1);
      }

      public final boolean component1() {
         return this.value;
      }

      public final G4NightMode copy(boolean var1) {
         return new G4NightMode(var1);
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof G4NightMode)) {
            return false;
         } else {
            var1 = var1;
            return this.value == var1.value;
         }
      }

      public Boolean getValue() {
         return this.value;
      }

      public int hashCode() {
         return AddDeviceState$$ExternalSyntheticBackport0.m(this.value);
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder("G4NightMode(value=");
         var1.append(this.value);
         var1.append(')');
         return var1.toString();
      }
   }

   @Metadata(
      d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"},
      d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$GermShield;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(Z)V", "getValue", "()Ljava/lang/Boolean;", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class GermShield extends DeviceStreamAttribute {
      private final boolean value;

      public GermShield(boolean var1) {
         super(var1, (DefaultConstructorMarker)null);
         this.value = var1;
      }

      // $FF: synthetic method
      public static GermShield copy$default(GermShield var0, boolean var1, int var2, Object var3) {
         if ((var2 & 1) != 0) {
            var1 = var0.value;
         }

         return var0.copy(var1);
      }

      public final boolean component1() {
         return this.value;
      }

      public final GermShield copy(boolean var1) {
         return new GermShield(var1);
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof GermShield)) {
            return false;
         } else {
            var1 = var1;
            return this.value == var1.value;
         }
      }

      public Boolean getValue() {
         return this.value;
      }

      public int hashCode() {
         return AddDeviceState$$ExternalSyntheticBackport0.m(this.value);
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder("GermShield(value=");
         var1.append(this.value);
         var1.append(')');
         return var1.toString();
      }
   }

   @Metadata(
      d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"},
      d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$GermShieldNight;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(Z)V", "getValue", "()Ljava/lang/Boolean;", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class GermShieldNight extends DeviceStreamAttribute {
      private final boolean value;

      public GermShieldNight(boolean var1) {
         super(var1, (DefaultConstructorMarker)null);
         this.value = var1;
      }

      // $FF: synthetic method
      public static GermShieldNight copy$default(GermShieldNight var0, boolean var1, int var2, Object var3) {
         if ((var2 & 1) != 0) {
            var1 = var0.value;
         }

         return var0.copy(var1);
      }

      public final boolean component1() {
         return this.value;
      }

      public final GermShieldNight copy(boolean var1) {
         return new GermShieldNight(var1);
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof GermShieldNight)) {
            return false;
         } else {
            var1 = var1;
            return this.value == var1.value;
         }
      }

      public Boolean getValue() {
         return this.value;
      }

      public int hashCode() {
         return AddDeviceState$$ExternalSyntheticBackport0.m(this.value);
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder("GermShieldNight(value=");
         var1.append(this.value);
         var1.append(')');
         return var1.toString();
      }
   }

   @Metadata(
      d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"},
      d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$HeatAutoTmp;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(D)V", "getValue", "()Ljava/lang/Double;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class HeatAutoTmp extends DeviceStreamAttribute {
      private final double value;

      public HeatAutoTmp(double var1) {
         super(var1, (DefaultConstructorMarker)null);
         this.value = var1;
      }

      // $FF: synthetic method
      public static HeatAutoTmp copy$default(HeatAutoTmp var0, double var1, int var3, Object var4) {
         if ((var3 & 1) != 0) {
            var1 = var0.value;
         }

         return var0.copy(var1);
      }

      public final double component1() {
         return this.value;
      }

      public final HeatAutoTmp copy(double var1) {
         return new HeatAutoTmp(var1);
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof HeatAutoTmp)) {
            return false;
         } else {
            var1 = var1;
            return Double.compare(this.value, var1.value) == 0;
         }
      }

      public Double getValue() {
         return this.value;
      }

      public int hashCode() {
         return AddDeviceState$$ExternalSyntheticBackport0.m(this.value);
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder("HeatAutoTmp(value=");
         var1.append(this.value);
         var1.append(')');
         return var1.toString();
      }
   }

   @Metadata(
      d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"},
      d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$HeatEcoTmp;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(D)V", "getValue", "()Ljava/lang/Double;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class HeatEcoTmp extends DeviceStreamAttribute {
      private final double value;

      public HeatEcoTmp(double var1) {
         super(var1, (DefaultConstructorMarker)null);
         this.value = var1;
      }

      // $FF: synthetic method
      public static HeatEcoTmp copy$default(HeatEcoTmp var0, double var1, int var3, Object var4) {
         if ((var3 & 1) != 0) {
            var1 = var0.value;
         }

         return var0.copy(var1);
      }

      public final double component1() {
         return this.value;
      }

      public final HeatEcoTmp copy(double var1) {
         return new HeatEcoTmp(var1);
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof HeatEcoTmp)) {
            return false;
         } else {
            var1 = var1;
            return Double.compare(this.value, var1.value) == 0;
         }
      }

      public Double getValue() {
         return this.value;
      }

      public int hashCode() {
         return AddDeviceState$$ExternalSyntheticBackport0.m(this.value);
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder("HeatEcoTmp(value=");
         var1.append(this.value);
         var1.append(')');
         return var1.toString();
      }
   }

   @Metadata(
      d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"},
      d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$HeatFanSpeed;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(I)V", "getValue", "()Ljava/lang/Integer;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class HeatFanSpeed extends DeviceStreamAttribute {
      private final int value;

      public HeatFanSpeed(int var1) {
         super(var1, (DefaultConstructorMarker)null);
         this.value = var1;
      }

      // $FF: synthetic method
      public static HeatFanSpeed copy$default(HeatFanSpeed var0, int var1, int var2, Object var3) {
         if ((var2 & 1) != 0) {
            var1 = var0.value;
         }

         return var0.copy(var1);
      }

      public final int component1() {
         return this.value;
      }

      public final HeatFanSpeed copy(int var1) {
         return new HeatFanSpeed(var1);
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof HeatFanSpeed)) {
            return false;
         } else {
            var1 = var1;
            return this.value == var1.value;
         }
      }

      public Integer getValue() {
         return this.value;
      }

      public int hashCode() {
         return this.value;
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder("HeatFanSpeed(value=");
         var1.append(this.value);
         var1.append(')');
         return var1.toString();
      }
   }

   @Metadata(
      d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"},
      d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$HeatSubMode;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(I)V", "getValue", "()Ljava/lang/Integer;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class HeatSubMode extends DeviceStreamAttribute {
      private final int value;

      public HeatSubMode(int var1) {
         super(var1, (DefaultConstructorMarker)null);
         this.value = var1;
      }

      // $FF: synthetic method
      public static HeatSubMode copy$default(HeatSubMode var0, int var1, int var2, Object var3) {
         if ((var2 & 1) != 0) {
            var1 = var0.value;
         }

         return var0.copy(var1);
      }

      public final int component1() {
         return this.value;
      }

      public final HeatSubMode copy(int var1) {
         return new HeatSubMode(var1);
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof HeatSubMode)) {
            return false;
         } else {
            var1 = var1;
            return this.value == var1.value;
         }
      }

      public Integer getValue() {
         return this.value;
      }

      public int hashCode() {
         return this.value;
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder("HeatSubMode(value=");
         var1.append(this.value);
         var1.append(')');
         return var1.toString();
      }
   }

   @Metadata(
      d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"},
      d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$HinsMode;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(Z)V", "getValue", "()Ljava/lang/Boolean;", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class HinsMode extends DeviceStreamAttribute {
      private final boolean value;

      public HinsMode(boolean var1) {
         super(var1, (DefaultConstructorMarker)null);
         this.value = var1;
      }

      // $FF: synthetic method
      public static HinsMode copy$default(HinsMode var0, boolean var1, int var2, Object var3) {
         if ((var2 & 1) != 0) {
            var1 = var0.value;
         }

         return var0.copy(var1);
      }

      public final boolean component1() {
         return this.value;
      }

      public final HinsMode copy(boolean var1) {
         return new HinsMode(var1);
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof HinsMode)) {
            return false;
         } else {
            var1 = var1;
            return this.value == var1.value;
         }
      }

      public Boolean getValue() {
         return this.value;
      }

      public int hashCode() {
         return AddDeviceState$$ExternalSyntheticBackport0.m(this.value);
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder("HinsMode(value=");
         var1.append(this.value);
         var1.append(')');
         return var1.toString();
      }
   }

   @Metadata(
      d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"},
      d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$HinsNightMode;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(Z)V", "getValue", "()Ljava/lang/Boolean;", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class HinsNightMode extends DeviceStreamAttribute {
      private final boolean value;

      public HinsNightMode(boolean var1) {
         super(var1, (DefaultConstructorMarker)null);
         this.value = var1;
      }

      // $FF: synthetic method
      public static HinsNightMode copy$default(HinsNightMode var0, boolean var1, int var2, Object var3) {
         if ((var2 & 1) != 0) {
            var1 = var0.value;
         }

         return var0.copy(var1);
      }

      public final boolean component1() {
         return this.value;
      }

      public final HinsNightMode copy(boolean var1) {
         return new HinsNightMode(var1);
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof HinsNightMode)) {
            return false;
         } else {
            var1 = var1;
            return this.value == var1.value;
         }
      }

      public Boolean getValue() {
         return this.value;
      }

      public int hashCode() {
         return AddDeviceState$$ExternalSyntheticBackport0.m(this.value);
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder("HinsNightMode(value=");
         var1.append(this.value);
         var1.append(')');
         return var1.toString();
      }
   }

   @Metadata(
      d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"},
      d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$HoverEnabled;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(Z)V", "getValue", "()Ljava/lang/Boolean;", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class HoverEnabled extends DeviceStreamAttribute {
      private final boolean value;

      public HoverEnabled(boolean var1) {
         super(var1, (DefaultConstructorMarker)null);
         this.value = var1;
      }

      // $FF: synthetic method
      public static HoverEnabled copy$default(HoverEnabled var0, boolean var1, int var2, Object var3) {
         if ((var2 & 1) != 0) {
            var1 = var0.value;
         }

         return var0.copy(var1);
      }

      public final boolean component1() {
         return this.value;
      }

      public final HoverEnabled copy(boolean var1) {
         return new HoverEnabled(var1);
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof HoverEnabled)) {
            return false;
         } else {
            var1 = var1;
            return this.value == var1.value;
         }
      }

      public Boolean getValue() {
         return this.value;
      }

      public int hashCode() {
         return AddDeviceState$$ExternalSyntheticBackport0.m(this.value);
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder("HoverEnabled(value=");
         var1.append(this.value);
         var1.append(')');
         return var1.toString();
      }
   }

   @Metadata(
      d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"},
      d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$HumMode;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(Z)V", "getValue", "()Ljava/lang/Boolean;", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class HumMode extends DeviceStreamAttribute {
      private final boolean value;

      public HumMode(boolean var1) {
         super(var1, (DefaultConstructorMarker)null);
         this.value = var1;
      }

      // $FF: synthetic method
      public static HumMode copy$default(HumMode var0, boolean var1, int var2, Object var3) {
         if ((var2 & 1) != 0) {
            var1 = var0.value;
         }

         return var0.copy(var1);
      }

      public final boolean component1() {
         return this.value;
      }

      public final HumMode copy(boolean var1) {
         return new HumMode(var1);
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof HumMode)) {
            return false;
         } else {
            var1 = var1;
            return this.value == var1.value;
         }
      }

      public Boolean getValue() {
         return this.value;
      }

      public int hashCode() {
         return AddDeviceState$$ExternalSyntheticBackport0.m(this.value);
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder("HumMode(value=");
         var1.append(this.value);
         var1.append(')');
         return var1.toString();
      }
   }

   @Metadata(
      d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"},
      d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$HumSubMode;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(I)V", "getValue", "()Ljava/lang/Integer;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class HumSubMode extends DeviceStreamAttribute {
      private final int value;

      public HumSubMode(int var1) {
         super(var1, (DefaultConstructorMarker)null);
         this.value = var1;
      }

      // $FF: synthetic method
      public static HumSubMode copy$default(HumSubMode var0, int var1, int var2, Object var3) {
         if ((var2 & 1) != 0) {
            var1 = var0.value;
         }

         return var0.copy(var1);
      }

      public final int component1() {
         return this.value;
      }

      public final HumSubMode copy(int var1) {
         return new HumSubMode(var1);
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof HumSubMode)) {
            return false;
         } else {
            var1 = var1;
            return this.value == var1.value;
         }
      }

      public Integer getValue() {
         return this.value;
      }

      public int hashCode() {
         return this.value;
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder("HumSubMode(value=");
         var1.append(this.value);
         var1.append(')');
         return var1.toString();
      }
   }

   @Metadata(
      d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"},
      d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$LatestSensorDataPoint;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "Lcom/blueair/core/model/IndoorDatapoint;", "value", "<init>", "(Lcom/blueair/core/model/IndoorDatapoint;)V", "getValue", "()Lcom/blueair/core/model/IndoorDatapoint;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class LatestSensorDataPoint extends DeviceStreamAttribute {
      private final IndoorDatapoint value;

      public LatestSensorDataPoint(IndoorDatapoint var1) {
         super(var1, (DefaultConstructorMarker)null);
         this.value = var1;
      }

      // $FF: synthetic method
      public static LatestSensorDataPoint copy$default(LatestSensorDataPoint var0, IndoorDatapoint var1, int var2, Object var3) {
         if ((var2 & 1) != 0) {
            var1 = var0.value;
         }

         return var0.copy(var1);
      }

      public final IndoorDatapoint component1() {
         return this.value;
      }

      public final LatestSensorDataPoint copy(IndoorDatapoint var1) {
         return new LatestSensorDataPoint(var1);
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof LatestSensorDataPoint)) {
            return false;
         } else {
            var1 = var1;
            return Intrinsics.areEqual(this.value, var1.value);
         }
      }

      public IndoorDatapoint getValue() {
         return this.value;
      }

      public int hashCode() {
         IndoorDatapoint var1 = this.value;
         return var1 == null ? 0 : var1.hashCode();
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder("LatestSensorDataPoint(value=");
         var1.append(this.value);
         var1.append(')');
         return var1.toString();
      }
   }

   @Metadata(
      d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"},
      d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$MainMode;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(I)V", "getValue", "()Ljava/lang/Integer;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class MainMode extends DeviceStreamAttribute {
      private final int value;

      public MainMode(int var1) {
         super(var1, (DefaultConstructorMarker)null);
         this.value = var1;
      }

      // $FF: synthetic method
      public static MainMode copy$default(MainMode var0, int var1, int var2, Object var3) {
         if ((var2 & 1) != 0) {
            var1 = var0.value;
         }

         return var0.copy(var1);
      }

      public final int component1() {
         return this.value;
      }

      public final MainMode copy(int var1) {
         return new MainMode(var1);
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof MainMode)) {
            return false;
         } else {
            var1 = var1;
            return this.value == var1.value;
         }
      }

      public Integer getValue() {
         return this.value;
      }

      public int hashCode() {
         return this.value;
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder("MainMode(value=");
         var1.append(this.value);
         var1.append(')');
         return var1.toString();
      }
   }

   @Metadata(
      d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"},
      d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$Mode;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(I)V", "getValue", "()Ljava/lang/Integer;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Mode extends DeviceStreamAttribute {
      private final int value;

      public Mode(int var1) {
         super(var1, (DefaultConstructorMarker)null);
         this.value = var1;
      }

      // $FF: synthetic method
      public static Mode copy$default(Mode var0, int var1, int var2, Object var3) {
         if ((var2 & 1) != 0) {
            var1 = var0.value;
         }

         return var0.copy(var1);
      }

      public final int component1() {
         return this.value;
      }

      public final Mode copy(int var1) {
         return new Mode(var1);
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof Mode)) {
            return false;
         } else {
            var1 = var1;
            return this.value == var1.value;
         }
      }

      public Integer getValue() {
         return this.value;
      }

      public int hashCode() {
         return this.value;
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder("Mode(value=");
         var1.append(this.value);
         var1.append(')');
         return var1.toString();
      }
   }

   @Metadata(
      d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"},
      d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$NightLampBrightness;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(I)V", "getValue", "()Ljava/lang/Integer;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class NightLampBrightness extends DeviceStreamAttribute {
      private final int value;

      public NightLampBrightness(int var1) {
         super(var1, (DefaultConstructorMarker)null);
         this.value = var1;
      }

      // $FF: synthetic method
      public static NightLampBrightness copy$default(NightLampBrightness var0, int var1, int var2, Object var3) {
         if ((var2 & 1) != 0) {
            var1 = var0.value;
         }

         return var0.copy(var1);
      }

      public final int component1() {
         return this.value;
      }

      public final NightLampBrightness copy(int var1) {
         return new NightLampBrightness(var1);
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof NightLampBrightness)) {
            return false;
         } else {
            var1 = var1;
            return this.value == var1.value;
         }
      }

      public Integer getValue() {
         return this.value;
      }

      public int hashCode() {
         return this.value;
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder("NightLampBrightness(value=");
         var1.append(this.value);
         var1.append(')');
         return var1.toString();
      }
   }

   @Metadata(
      d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"},
      d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$NightLampSteplessBrightness;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(I)V", "getValue", "()Ljava/lang/Integer;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class NightLampSteplessBrightness extends DeviceStreamAttribute {
      private final int value;

      public NightLampSteplessBrightness(int var1) {
         super(var1, (DefaultConstructorMarker)null);
         this.value = var1;
      }

      // $FF: synthetic method
      public static NightLampSteplessBrightness copy$default(NightLampSteplessBrightness var0, int var1, int var2, Object var3) {
         if ((var2 & 1) != 0) {
            var1 = var0.value;
         }

         return var0.copy(var1);
      }

      public final int component1() {
         return this.value;
      }

      public final NightLampSteplessBrightness copy(int var1) {
         return new NightLampSteplessBrightness(var1);
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof NightLampSteplessBrightness)) {
            return false;
         } else {
            var1 = var1;
            return this.value == var1.value;
         }
      }

      public Integer getValue() {
         return this.value;
      }

      public int hashCode() {
         return this.value;
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder("NightLampSteplessBrightness(value=");
         var1.append(this.value);
         var1.append(')');
         return var1.toString();
      }
   }

   @Metadata(
      d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"},
      d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$NightModeStartTime;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(J)V", "getValue", "()Ljava/lang/Long;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class NightModeStartTime extends DeviceStreamAttribute {
      private final long value;

      public NightModeStartTime(long var1) {
         super(var1, (DefaultConstructorMarker)null);
         this.value = var1;
      }

      // $FF: synthetic method
      public static NightModeStartTime copy$default(NightModeStartTime var0, long var1, int var3, Object var4) {
         if ((var3 & 1) != 0) {
            var1 = var0.value;
         }

         return var0.copy(var1);
      }

      public final long component1() {
         return this.value;
      }

      public final NightModeStartTime copy(long var1) {
         return new NightModeStartTime(var1);
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof NightModeStartTime)) {
            return false;
         } else {
            var1 = var1;
            return this.value == var1.value;
         }
      }

      public Long getValue() {
         return this.value;
      }

      public int hashCode() {
         return AddDeviceState$$ExternalSyntheticBackport0.m(this.value);
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder("NightModeStartTime(value=");
         var1.append(this.value);
         var1.append(')');
         return var1.toString();
      }
   }

   @Metadata(
      d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"},
      d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$OscillationAngle;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(I)V", "getValue", "()Ljava/lang/Integer;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class OscillationAngle extends DeviceStreamAttribute {
      private final int value;

      public OscillationAngle(int var1) {
         super(var1, (DefaultConstructorMarker)null);
         this.value = var1;
      }

      // $FF: synthetic method
      public static OscillationAngle copy$default(OscillationAngle var0, int var1, int var2, Object var3) {
         if ((var2 & 1) != 0) {
            var1 = var0.value;
         }

         return var0.copy(var1);
      }

      public final int component1() {
         return this.value;
      }

      public final OscillationAngle copy(int var1) {
         return new OscillationAngle(var1);
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof OscillationAngle)) {
            return false;
         } else {
            var1 = var1;
            return this.value == var1.value;
         }
      }

      public Integer getValue() {
         return this.value;
      }

      public int hashCode() {
         return this.value;
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder("OscillationAngle(value=");
         var1.append(this.value);
         var1.append(')');
         return var1.toString();
      }
   }

   @Metadata(
      d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"},
      d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$OscillationDirection;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(I)V", "getValue", "()Ljava/lang/Integer;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class OscillationDirection extends DeviceStreamAttribute {
      private final int value;

      public OscillationDirection(int var1) {
         super(var1, (DefaultConstructorMarker)null);
         this.value = var1;
      }

      // $FF: synthetic method
      public static OscillationDirection copy$default(OscillationDirection var0, int var1, int var2, Object var3) {
         if ((var2 & 1) != 0) {
            var1 = var0.value;
         }

         return var0.copy(var1);
      }

      public final int component1() {
         return this.value;
      }

      public final OscillationDirection copy(int var1) {
         return new OscillationDirection(var1);
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof OscillationDirection)) {
            return false;
         } else {
            var1 = var1;
            return this.value == var1.value;
         }
      }

      public Integer getValue() {
         return this.value;
      }

      public int hashCode() {
         return this.value;
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder("OscillationDirection(value=");
         var1.append(this.value);
         var1.append(')');
         return var1.toString();
      }
   }

   @Metadata(
      d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"},
      d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$OscillationFanSpeed;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(I)V", "getValue", "()Ljava/lang/Integer;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class OscillationFanSpeed extends DeviceStreamAttribute {
      private final int value;

      public OscillationFanSpeed(int var1) {
         super(var1, (DefaultConstructorMarker)null);
         this.value = var1;
      }

      // $FF: synthetic method
      public static OscillationFanSpeed copy$default(OscillationFanSpeed var0, int var1, int var2, Object var3) {
         if ((var2 & 1) != 0) {
            var1 = var0.value;
         }

         return var0.copy(var1);
      }

      public final int component1() {
         return this.value;
      }

      public final OscillationFanSpeed copy(int var1) {
         return new OscillationFanSpeed(var1);
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof OscillationFanSpeed)) {
            return false;
         } else {
            var1 = var1;
            return this.value == var1.value;
         }
      }

      public Integer getValue() {
         return this.value;
      }

      public int hashCode() {
         return this.value;
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder("OscillationFanSpeed(value=");
         var1.append(this.value);
         var1.append(')');
         return var1.toString();
      }
   }

   @Metadata(
      d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"},
      d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$OscillationState;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(I)V", "getValue", "()Ljava/lang/Integer;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class OscillationState extends DeviceStreamAttribute {
      private final int value;

      public OscillationState(int var1) {
         super(var1, (DefaultConstructorMarker)null);
         this.value = var1;
      }

      // $FF: synthetic method
      public static OscillationState copy$default(OscillationState var0, int var1, int var2, Object var3) {
         if ((var2 & 1) != 0) {
            var1 = var0.value;
         }

         return var0.copy(var1);
      }

      public final int component1() {
         return this.value;
      }

      public final OscillationState copy(int var1) {
         return new OscillationState(var1);
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof OscillationState)) {
            return false;
         } else {
            var1 = var1;
            return this.value == var1.value;
         }
      }

      public Integer getValue() {
         return this.value;
      }

      public int hashCode() {
         return this.value;
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder("OscillationState(value=");
         var1.append(this.value);
         var1.append(')');
         return var1.toString();
      }
   }

   @Metadata(
      d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"},
      d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$PanelDisplayMode;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(I)V", "getValue", "()Ljava/lang/Integer;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class PanelDisplayMode extends DeviceStreamAttribute {
      private final int value;

      public PanelDisplayMode(int var1) {
         super(var1, (DefaultConstructorMarker)null);
         this.value = var1;
      }

      // $FF: synthetic method
      public static PanelDisplayMode copy$default(PanelDisplayMode var0, int var1, int var2, Object var3) {
         if ((var2 & 1) != 0) {
            var1 = var0.value;
         }

         return var0.copy(var1);
      }

      public final int component1() {
         return this.value;
      }

      public final PanelDisplayMode copy(int var1) {
         return new PanelDisplayMode(var1);
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof PanelDisplayMode)) {
            return false;
         } else {
            var1 = var1;
            return this.value == var1.value;
         }
      }

      public Integer getValue() {
         return this.value;
      }

      public int hashCode() {
         return this.value;
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder("PanelDisplayMode(value=");
         var1.append(this.value);
         var1.append(')');
         return var1.toString();
      }
   }

   @Metadata(
      d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"},
      d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$RoomType;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(I)V", "getValue", "()Ljava/lang/Integer;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class RoomType extends DeviceStreamAttribute {
      private final int value;

      public RoomType(int var1) {
         super(var1, (DefaultConstructorMarker)null);
         this.value = var1;
      }

      // $FF: synthetic method
      public static RoomType copy$default(RoomType var0, int var1, int var2, Object var3) {
         if ((var2 & 1) != 0) {
            var1 = var0.value;
         }

         return var0.copy(var1);
      }

      public final int component1() {
         return this.value;
      }

      public final RoomType copy(int var1) {
         return new RoomType(var1);
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof RoomType)) {
            return false;
         } else {
            var1 = var1;
            return this.value == var1.value;
         }
      }

      public Integer getValue() {
         return this.value;
      }

      public int hashCode() {
         return this.value;
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder("RoomType(value=");
         var1.append(this.value);
         var1.append(')');
         return var1.toString();
      }
   }

   @Metadata(
      d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"},
      d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$Rpm;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(I)V", "getValue", "()Ljava/lang/Integer;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Rpm extends DeviceStreamAttribute {
      private final int value;

      public Rpm(int var1) {
         super(var1, (DefaultConstructorMarker)null);
         this.value = var1;
      }

      // $FF: synthetic method
      public static Rpm copy$default(Rpm var0, int var1, int var2, Object var3) {
         if ((var2 & 1) != 0) {
            var1 = var0.value;
         }

         return var0.copy(var1);
      }

      public final int component1() {
         return this.value;
      }

      public final Rpm copy(int var1) {
         return new Rpm(var1);
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof Rpm)) {
            return false;
         } else {
            var1 = var1;
            return this.value == var1.value;
         }
      }

      public Integer getValue() {
         return this.value;
      }

      public int hashCode() {
         return this.value;
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder("Rpm(value=");
         var1.append(this.value);
         var1.append(')');
         return var1.toString();
      }
   }

   @Metadata(
      d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"},
      d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$SafetySwitch;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(Z)V", "getValue", "()Ljava/lang/Boolean;", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class SafetySwitch extends DeviceStreamAttribute {
      private final boolean value;

      public SafetySwitch(boolean var1) {
         super(var1, (DefaultConstructorMarker)null);
         this.value = var1;
      }

      // $FF: synthetic method
      public static SafetySwitch copy$default(SafetySwitch var0, boolean var1, int var2, Object var3) {
         if ((var2 & 1) != 0) {
            var1 = var0.value;
         }

         return var0.copy(var1);
      }

      public final boolean component1() {
         return this.value;
      }

      public final SafetySwitch copy(boolean var1) {
         return new SafetySwitch(var1);
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof SafetySwitch)) {
            return false;
         } else {
            var1 = var1;
            return this.value == var1.value;
         }
      }

      public Boolean getValue() {
         return this.value;
      }

      public int hashCode() {
         return AddDeviceState$$ExternalSyntheticBackport0.m(this.value);
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder("SafetySwitch(value=");
         var1.append(this.value);
         var1.append(')');
         return var1.toString();
      }
   }

   @Metadata(
      d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"},
      d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$SensorMode;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(I)V", "getValue", "()Ljava/lang/Integer;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class SensorMode extends DeviceStreamAttribute {
      private final int value;

      public SensorMode(int var1) {
         super(var1, (DefaultConstructorMarker)null);
         this.value = var1;
      }

      // $FF: synthetic method
      public static SensorMode copy$default(SensorMode var0, int var1, int var2, Object var3) {
         if ((var2 & 1) != 0) {
            var1 = var0.value;
         }

         return var0.copy(var1);
      }

      public final int component1() {
         return this.value;
      }

      public final SensorMode copy(int var1) {
         return new SensorMode(var1);
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof SensorMode)) {
            return false;
         } else {
            var1 = var1;
            return this.value == var1.value;
         }
      }

      public Integer getValue() {
         return this.value;
      }

      public int hashCode() {
         return this.value;
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder("SensorMode(value=");
         var1.append(this.value);
         var1.append(')');
         return var1.toString();
      }
   }

   @Metadata(
      d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"},
      d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$SmartSubMode;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(I)V", "getValue", "()Ljava/lang/Integer;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class SmartSubMode extends DeviceStreamAttribute {
      private final int value;

      public SmartSubMode(int var1) {
         super(var1, (DefaultConstructorMarker)null);
         this.value = var1;
      }

      // $FF: synthetic method
      public static SmartSubMode copy$default(SmartSubMode var0, int var1, int var2, Object var3) {
         if ((var2 & 1) != 0) {
            var1 = var0.value;
         }

         return var0.copy(var1);
      }

      public final int component1() {
         return this.value;
      }

      public final SmartSubMode copy(int var1) {
         return new SmartSubMode(var1);
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof SmartSubMode)) {
            return false;
         } else {
            var1 = var1;
            return this.value == var1.value;
         }
      }

      public Integer getValue() {
         return this.value;
      }

      public int hashCode() {
         return this.value;
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder("SmartSubMode(value=");
         var1.append(this.value);
         var1.append(')');
         return var1.toString();
      }
   }

   @Metadata(
      d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"},
      d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$StandByMode;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(Z)V", "getValue", "()Ljava/lang/Boolean;", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class StandByMode extends DeviceStreamAttribute {
      private final boolean value;

      public StandByMode(boolean var1) {
         super(var1, (DefaultConstructorMarker)null);
         this.value = var1;
      }

      // $FF: synthetic method
      public static StandByMode copy$default(StandByMode var0, boolean var1, int var2, Object var3) {
         if ((var2 & 1) != 0) {
            var1 = var0.value;
         }

         return var0.copy(var1);
      }

      public final boolean component1() {
         return this.value;
      }

      public final StandByMode copy(boolean var1) {
         return new StandByMode(var1);
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof StandByMode)) {
            return false;
         } else {
            var1 = var1;
            return this.value == var1.value;
         }
      }

      public Boolean getValue() {
         return this.value;
      }

      public int hashCode() {
         return AddDeviceState$$ExternalSyntheticBackport0.m(this.value);
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder("StandByMode(value=");
         var1.append(this.value);
         var1.append(')');
         return var1.toString();
      }
   }

   @Metadata(
      d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"},
      d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$TemperatureUnit;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(I)V", "getValue", "()Ljava/lang/Integer;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class TemperatureUnit extends DeviceStreamAttribute {
      private final int value;

      public TemperatureUnit(int var1) {
         super(var1, (DefaultConstructorMarker)null);
         this.value = var1;
      }

      // $FF: synthetic method
      public static TemperatureUnit copy$default(TemperatureUnit var0, int var1, int var2, Object var3) {
         if ((var2 & 1) != 0) {
            var1 = var0.value;
         }

         return var0.copy(var1);
      }

      public final int component1() {
         return this.value;
      }

      public final TemperatureUnit copy(int var1) {
         return new TemperatureUnit(var1);
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof TemperatureUnit)) {
            return false;
         } else {
            var1 = var1;
            return this.value == var1.value;
         }
      }

      public Integer getValue() {
         return this.value;
      }

      public int hashCode() {
         return this.value;
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder("TemperatureUnit(value=");
         var1.append(this.value);
         var1.append(')');
         return var1.toString();
      }
   }

   @Metadata(
      d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"},
      d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$TimerDuration;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(I)V", "getValue", "()Ljava/lang/Integer;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class TimerDuration extends DeviceStreamAttribute {
      private final int value;

      public TimerDuration(int var1) {
         super(var1, (DefaultConstructorMarker)null);
         this.value = var1;
      }

      // $FF: synthetic method
      public static TimerDuration copy$default(TimerDuration var0, int var1, int var2, Object var3) {
         if ((var2 & 1) != 0) {
            var1 = var0.value;
         }

         return var0.copy(var1);
      }

      public final int component1() {
         return this.value;
      }

      public final TimerDuration copy(int var1) {
         return new TimerDuration(var1);
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof TimerDuration)) {
            return false;
         } else {
            var1 = var1;
            return this.value == var1.value;
         }
      }

      public Integer getValue() {
         return this.value;
      }

      public int hashCode() {
         return this.value;
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder("TimerDuration(value=");
         var1.append(this.value);
         var1.append(')');
         return var1.toString();
      }
   }

   @Metadata(
      d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001B\u001b\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002HÆ\u0003J\u001f\u0010\u000b\u001a\u00020\u00002\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R \u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0013"},
      d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$TimerLeftTime;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "Lkotlin/Pair;", "", "", "value", "<init>", "(Lkotlin/Pair;)V", "getValue", "()Lkotlin/Pair;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class TimerLeftTime extends DeviceStreamAttribute {
      private final Pair value;

      public TimerLeftTime(Pair var1) {
         Intrinsics.checkNotNullParameter(var1, "value");
         super(var1, (DefaultConstructorMarker)null);
         this.value = var1;
      }

      // $FF: synthetic method
      public static TimerLeftTime copy$default(TimerLeftTime var0, Pair var1, int var2, Object var3) {
         if ((var2 & 1) != 0) {
            var1 = var0.value;
         }

         return var0.copy(var1);
      }

      public final Pair component1() {
         return this.value;
      }

      public final TimerLeftTime copy(Pair var1) {
         Intrinsics.checkNotNullParameter(var1, "value");
         return new TimerLeftTime(var1);
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof TimerLeftTime)) {
            return false;
         } else {
            var1 = var1;
            return Intrinsics.areEqual(this.value, var1.value);
         }
      }

      public Pair getValue() {
         return this.value;
      }

      public int hashCode() {
         return this.value.hashCode();
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder("TimerLeftTime(value=");
         var1.append(this.value);
         var1.append(')');
         return var1.toString();
      }
   }

   @Metadata(
      d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"},
      d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$TimerStatus;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(I)V", "getValue", "()Ljava/lang/Integer;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class TimerStatus extends DeviceStreamAttribute {
      private final int value;

      public TimerStatus(int var1) {
         super(var1, (DefaultConstructorMarker)null);
         this.value = var1;
      }

      // $FF: synthetic method
      public static TimerStatus copy$default(TimerStatus var0, int var1, int var2, Object var3) {
         if ((var2 & 1) != 0) {
            var1 = var0.value;
         }

         return var0.copy(var1);
      }

      public final int component1() {
         return this.value;
      }

      public final TimerStatus copy(int var1) {
         return new TimerStatus(var1);
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof TimerStatus)) {
            return false;
         } else {
            var1 = var1;
            return this.value == var1.value;
         }
      }

      public Integer getValue() {
         return this.value;
      }

      public int hashCode() {
         return this.value;
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder("TimerStatus(value=");
         var1.append(this.value);
         var1.append(')');
         return var1.toString();
      }
   }

   @Metadata(
      d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"},
      d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$Unknown;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(Z)V", "getValue", "()Ljava/lang/Boolean;", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Unknown extends DeviceStreamAttribute {
      private final boolean value;

      public Unknown() {
         this(false, 1, (DefaultConstructorMarker)null);
      }

      public Unknown(boolean var1) {
         super(var1, (DefaultConstructorMarker)null);
         this.value = var1;
      }

      // $FF: synthetic method
      public Unknown(boolean var1, int var2, DefaultConstructorMarker var3) {
         if ((var2 & 1) != 0) {
            var1 = false;
         }

         this(var1);
      }

      // $FF: synthetic method
      public static Unknown copy$default(Unknown var0, boolean var1, int var2, Object var3) {
         if ((var2 & 1) != 0) {
            var1 = var0.value;
         }

         return var0.copy(var1);
      }

      public final boolean component1() {
         return this.value;
      }

      public final Unknown copy(boolean var1) {
         return new Unknown(var1);
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof Unknown)) {
            return false;
         } else {
            var1 = var1;
            return this.value == var1.value;
         }
      }

      public Boolean getValue() {
         return this.value;
      }

      public int hashCode() {
         return AddDeviceState$$ExternalSyntheticBackport0.m(this.value);
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder("Unknown(value=");
         var1.append(this.value);
         var1.append(')');
         return var1.toString();
      }
   }

   @Metadata(
      d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"},
      d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$Use24Hour;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(Z)V", "getValue", "()Ljava/lang/Boolean;", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Use24Hour extends DeviceStreamAttribute {
      private final boolean value;

      public Use24Hour(boolean var1) {
         super(var1, (DefaultConstructorMarker)null);
         this.value = var1;
      }

      // $FF: synthetic method
      public static Use24Hour copy$default(Use24Hour var0, boolean var1, int var2, Object var3) {
         if ((var2 & 1) != 0) {
            var1 = var0.value;
         }

         return var0.copy(var1);
      }

      public final boolean component1() {
         return this.value;
      }

      public final Use24Hour copy(boolean var1) {
         return new Use24Hour(var1);
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof Use24Hour)) {
            return false;
         } else {
            var1 = var1;
            return this.value == var1.value;
         }
      }

      public Boolean getValue() {
         return this.value;
      }

      public int hashCode() {
         return AddDeviceState$$ExternalSyntheticBackport0.m(this.value);
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder("Use24Hour(value=");
         var1.append(this.value);
         var1.append(')');
         return var1.toString();
      }
   }

   @Metadata(
      d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"},
      d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$WaterInfill;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(Z)V", "getValue", "()Ljava/lang/Boolean;", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class WaterInfill extends DeviceStreamAttribute {
      private final boolean value;

      public WaterInfill(boolean var1) {
         super(var1, (DefaultConstructorMarker)null);
         this.value = var1;
      }

      // $FF: synthetic method
      public static WaterInfill copy$default(WaterInfill var0, boolean var1, int var2, Object var3) {
         if ((var2 & 1) != 0) {
            var1 = var0.value;
         }

         return var0.copy(var1);
      }

      public final boolean component1() {
         return this.value;
      }

      public final WaterInfill copy(boolean var1) {
         return new WaterInfill(var1);
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof WaterInfill)) {
            return false;
         } else {
            var1 = var1;
            return this.value == var1.value;
         }
      }

      public Boolean getValue() {
         return this.value;
      }

      public int hashCode() {
         return AddDeviceState$$ExternalSyntheticBackport0.m(this.value);
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder("WaterInfill(value=");
         var1.append(this.value);
         var1.append(')');
         return var1.toString();
      }
   }

   @Metadata(
      d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"},
      d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$WaterLevel;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(I)V", "getValue", "()Ljava/lang/Integer;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class WaterLevel extends DeviceStreamAttribute {
      private final int value;

      public WaterLevel(int var1) {
         super(var1, (DefaultConstructorMarker)null);
         this.value = var1;
      }

      // $FF: synthetic method
      public static WaterLevel copy$default(WaterLevel var0, int var1, int var2, Object var3) {
         if ((var2 & 1) != 0) {
            var1 = var0.value;
         }

         return var0.copy(var1);
      }

      public final int component1() {
         return this.value;
      }

      public final WaterLevel copy(int var1) {
         return new WaterLevel(var1);
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof WaterLevel)) {
            return false;
         } else {
            var1 = var1;
            return this.value == var1.value;
         }
      }

      public Integer getValue() {
         return this.value;
      }

      public int hashCode() {
         return this.value;
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder("WaterLevel(value=");
         var1.append(this.value);
         var1.append(')');
         return var1.toString();
      }
   }

   @Metadata(
      d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"},
      d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$WaterShortage;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(Z)V", "getValue", "()Ljava/lang/Boolean;", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class WaterShortage extends DeviceStreamAttribute {
      private final boolean value;

      public WaterShortage(boolean var1) {
         super(var1, (DefaultConstructorMarker)null);
         this.value = var1;
      }

      // $FF: synthetic method
      public static WaterShortage copy$default(WaterShortage var0, boolean var1, int var2, Object var3) {
         if ((var2 & 1) != 0) {
            var1 = var0.value;
         }

         return var0.copy(var1);
      }

      public final boolean component1() {
         return this.value;
      }

      public final WaterShortage copy(boolean var1) {
         return new WaterShortage(var1);
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof WaterShortage)) {
            return false;
         } else {
            var1 = var1;
            return this.value == var1.value;
         }
      }

      public Boolean getValue() {
         return this.value;
      }

      public int hashCode() {
         return AddDeviceState$$ExternalSyntheticBackport0.m(this.value);
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder("WaterShortage(value=");
         var1.append(this.value);
         var1.append(')');
         return var1.toString();
      }
   }

   @Metadata(
      d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"},
      d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$WaterTankFailure;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(Z)V", "getValue", "()Ljava/lang/Boolean;", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class WaterTankFailure extends DeviceStreamAttribute {
      private final boolean value;

      public WaterTankFailure(boolean var1) {
         super(var1, (DefaultConstructorMarker)null);
         this.value = var1;
      }

      // $FF: synthetic method
      public static WaterTankFailure copy$default(WaterTankFailure var0, boolean var1, int var2, Object var3) {
         if ((var2 & 1) != 0) {
            var1 = var0.value;
         }

         return var0.copy(var1);
      }

      public final boolean component1() {
         return this.value;
      }

      public final WaterTankFailure copy(boolean var1) {
         return new WaterTankFailure(var1);
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof WaterTankFailure)) {
            return false;
         } else {
            var1 = var1;
            return this.value == var1.value;
         }
      }

      public Boolean getValue() {
         return this.value;
      }

      public int hashCode() {
         return AddDeviceState$$ExternalSyntheticBackport0.m(this.value);
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder("WaterTankFailure(value=");
         var1.append(this.value);
         var1.append(')');
         return var1.toString();
      }
   }

   @Metadata(
      d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"},
      d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$WickUsage;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(I)V", "getValue", "()Ljava/lang/Integer;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class WickUsage extends DeviceStreamAttribute {
      private final int value;

      public WickUsage(int var1) {
         super(var1, (DefaultConstructorMarker)null);
         this.value = var1;
      }

      // $FF: synthetic method
      public static WickUsage copy$default(WickUsage var0, int var1, int var2, Object var3) {
         if ((var2 & 1) != 0) {
            var1 = var0.value;
         }

         return var0.copy(var1);
      }

      public final int component1() {
         return this.value;
      }

      public final WickUsage copy(int var1) {
         return new WickUsage(var1);
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof WickUsage)) {
            return false;
         } else {
            var1 = var1;
            return this.value == var1.value;
         }
      }

      public Integer getValue() {
         return this.value;
      }

      public int hashCode() {
         return this.value;
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder("WickUsage(value=");
         var1.append(this.value);
         var1.append(')');
         return var1.toString();
      }
   }

   @Metadata(
      d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"},
      d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$WickdryDone;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(Z)V", "getValue", "()Ljava/lang/Boolean;", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class WickdryDone extends DeviceStreamAttribute {
      private final boolean value;

      public WickdryDone(boolean var1) {
         super(var1, (DefaultConstructorMarker)null);
         this.value = var1;
      }

      // $FF: synthetic method
      public static WickdryDone copy$default(WickdryDone var0, boolean var1, int var2, Object var3) {
         if ((var2 & 1) != 0) {
            var1 = var0.value;
         }

         return var0.copy(var1);
      }

      public final boolean component1() {
         return this.value;
      }

      public final WickdryDone copy(boolean var1) {
         return new WickdryDone(var1);
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof WickdryDone)) {
            return false;
         } else {
            var1 = var1;
            return this.value == var1.value;
         }
      }

      public Boolean getValue() {
         return this.value;
      }

      public int hashCode() {
         return AddDeviceState$$ExternalSyntheticBackport0.m(this.value);
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder("WickdryDone(value=");
         var1.append(this.value);
         var1.append(')');
         return var1.toString();
      }
   }

   @Metadata(
      d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"},
      d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$WickdryDuration;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(I)V", "getValue", "()Ljava/lang/Integer;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class WickdryDuration extends DeviceStreamAttribute {
      private final int value;

      public WickdryDuration(int var1) {
         super(var1, (DefaultConstructorMarker)null);
         this.value = var1;
      }

      // $FF: synthetic method
      public static WickdryDuration copy$default(WickdryDuration var0, int var1, int var2, Object var3) {
         if ((var2 & 1) != 0) {
            var1 = var0.value;
         }

         return var0.copy(var1);
      }

      public final int component1() {
         return this.value;
      }

      public final WickdryDuration copy(int var1) {
         return new WickdryDuration(var1);
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof WickdryDuration)) {
            return false;
         } else {
            var1 = var1;
            return this.value == var1.value;
         }
      }

      public Integer getValue() {
         return this.value;
      }

      public int hashCode() {
         return this.value;
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder("WickdryDuration(value=");
         var1.append(this.value);
         var1.append(')');
         return var1.toString();
      }
   }

   @Metadata(
      d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"},
      d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$WickdryEnabled;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(Z)V", "getValue", "()Ljava/lang/Boolean;", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class WickdryEnabled extends DeviceStreamAttribute {
      private final boolean value;

      public WickdryEnabled(boolean var1) {
         super(var1, (DefaultConstructorMarker)null);
         this.value = var1;
      }

      // $FF: synthetic method
      public static WickdryEnabled copy$default(WickdryEnabled var0, boolean var1, int var2, Object var3) {
         if ((var2 & 1) != 0) {
            var1 = var0.value;
         }

         return var0.copy(var1);
      }

      public final boolean component1() {
         return this.value;
      }

      public final WickdryEnabled copy(boolean var1) {
         return new WickdryEnabled(var1);
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof WickdryEnabled)) {
            return false;
         } else {
            var1 = var1;
            return this.value == var1.value;
         }
      }

      public Boolean getValue() {
         return this.value;
      }

      public int hashCode() {
         return AddDeviceState$$ExternalSyntheticBackport0.m(this.value);
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder("WickdryEnabled(value=");
         var1.append(this.value);
         var1.append(')');
         return var1.toString();
      }
   }

   @Metadata(
      d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001B\u001b\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002HÆ\u0003J\u001f\u0010\u000b\u001a\u00020\u00002\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R \u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0013"},
      d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$WickdryLeftTime;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "Lkotlin/Pair;", "", "", "value", "<init>", "(Lkotlin/Pair;)V", "getValue", "()Lkotlin/Pair;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class WickdryLeftTime extends DeviceStreamAttribute {
      private final Pair value;

      public WickdryLeftTime(Pair var1) {
         Intrinsics.checkNotNullParameter(var1, "value");
         super(var1, (DefaultConstructorMarker)null);
         this.value = var1;
      }

      // $FF: synthetic method
      public static WickdryLeftTime copy$default(WickdryLeftTime var0, Pair var1, int var2, Object var3) {
         if ((var2 & 1) != 0) {
            var1 = var0.value;
         }

         return var0.copy(var1);
      }

      public final Pair component1() {
         return this.value;
      }

      public final WickdryLeftTime copy(Pair var1) {
         Intrinsics.checkNotNullParameter(var1, "value");
         return new WickdryLeftTime(var1);
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof WickdryLeftTime)) {
            return false;
         } else {
            var1 = var1;
            return Intrinsics.areEqual(this.value, var1.value);
         }
      }

      public Pair getValue() {
         return this.value;
      }

      public int hashCode() {
         return this.value.hashCode();
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder("WickdryLeftTime(value=");
         var1.append(this.value);
         var1.append(')');
         return var1.toString();
      }
   }

   @Metadata(
      d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"},
      d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$WickdryOn;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(Z)V", "getValue", "()Ljava/lang/Boolean;", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class WickdryOn extends DeviceStreamAttribute {
      private final boolean value;

      public WickdryOn(boolean var1) {
         super(var1, (DefaultConstructorMarker)null);
         this.value = var1;
      }

      // $FF: synthetic method
      public static WickdryOn copy$default(WickdryOn var0, boolean var1, int var2, Object var3) {
         if ((var2 & 1) != 0) {
            var1 = var0.value;
         }

         return var0.copy(var1);
      }

      public final boolean component1() {
         return this.value;
      }

      public final WickdryOn copy(boolean var1) {
         return new WickdryOn(var1);
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof WickdryOn)) {
            return false;
         } else {
            var1 = var1;
            return this.value == var1.value;
         }
      }

      public Boolean getValue() {
         return this.value;
      }

      public int hashCode() {
         return AddDeviceState$$ExternalSyntheticBackport0.m(this.value);
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder("WickdryOn(value=");
         var1.append(this.value);
         var1.append(')');
         return var1.toString();
      }
   }

   @Metadata(
      d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0002\u0010\u0007J\u001a\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0002\u0010\u000bJ\u0013\u0010\f\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u0002X\u0096\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"},
      d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$YwrmEnabled;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(Ljava/lang/Boolean;)V", "getValue", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "copy", "(Ljava/lang/Boolean;)Lcom/blueair/core/model/DeviceStreamAttribute$YwrmEnabled;", "equals", "other", "", "hashCode", "", "toString", "", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class YwrmEnabled extends DeviceStreamAttribute {
      private final Boolean value;

      public YwrmEnabled(Boolean var1) {
         super(var1, (DefaultConstructorMarker)null);
         this.value = var1;
      }

      // $FF: synthetic method
      public static YwrmEnabled copy$default(YwrmEnabled var0, Boolean var1, int var2, Object var3) {
         if ((var2 & 1) != 0) {
            var1 = var0.value;
         }

         return var0.copy(var1);
      }

      public final Boolean component1() {
         return this.value;
      }

      public final YwrmEnabled copy(Boolean var1) {
         return new YwrmEnabled(var1);
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof YwrmEnabled)) {
            return false;
         } else {
            var1 = var1;
            return Intrinsics.areEqual(this.value, var1.value);
         }
      }

      public Boolean getValue() {
         return this.value;
      }

      public int hashCode() {
         Boolean var1 = this.value;
         return var1 == null ? 0 : var1.hashCode();
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder("YwrmEnabled(value=");
         var1.append(this.value);
         var1.append(')');
         return var1.toString();
      }
   }

   @Metadata(
      d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"},
      d2 = {"Lcom/blueair/core/model/DeviceStreamAttribute$YwrmUsage;", "Lcom/blueair/core/model/DeviceStreamAttribute;", "", "value", "<init>", "(I)V", "getValue", "()Ljava/lang/Integer;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class YwrmUsage extends DeviceStreamAttribute {
      private final int value;

      public YwrmUsage(int var1) {
         super(var1, (DefaultConstructorMarker)null);
         this.value = var1;
      }

      // $FF: synthetic method
      public static YwrmUsage copy$default(YwrmUsage var0, int var1, int var2, Object var3) {
         if ((var2 & 1) != 0) {
            var1 = var0.value;
         }

         return var0.copy(var1);
      }

      public final int component1() {
         return this.value;
      }

      public final YwrmUsage copy(int var1) {
         return new YwrmUsage(var1);
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof YwrmUsage)) {
            return false;
         } else {
            var1 = var1;
            return this.value == var1.value;
         }
      }

      public Integer getValue() {
         return this.value;
      }

      public int hashCode() {
         return this.value;
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder("YwrmUsage(value=");
         var1.append(this.value);
         var1.append(')');
         return var1.toString();
      }
   }
}
