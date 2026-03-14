package com.blueair.devicedetails.util;

import com.blueair.core.model.ApSubMode;
import com.blueair.core.model.AutoLevel;
import com.blueair.core.model.Brightness;
import com.blueair.core.model.CoolSubMode;
import com.blueair.core.model.DehSubMode;
import com.blueair.core.model.FanSpeedEnum;
import com.blueair.core.model.HumSubMode;
import com.blueair.core.model.MainMode;
import com.blueair.core.model.Mode;
import com.blueair.core.model.MoodLampEnum;
import com.blueair.core.model.SmartSubMode;
import com.blueair.core.model.TimerState;
import com.blueair.core.model.WickDryingGear;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000°\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\bN\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:H\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPB\u0011\b\u0004\u0012\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0004\b\u0004\u0010\u0005R\u0013\u0010\u0003\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001aQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~\u007f\u0080\u0001\u0081\u0001\u0082\u0001\u0083\u0001\u0084\u0001\u0085\u0001\u0086\u0001\u0087\u0001\u0088\u0001\u0089\u0001\u008a\u0001\u008b\u0001\u008c\u0001\u008d\u0001\u008e\u0001\u008f\u0001\u0090\u0001\u0091\u0001\u0092\u0001\u0093\u0001\u0094\u0001\u0095\u0001\u0096\u0001\u0097\u0001\u0098\u0001¨\u0006\u0099\u0001"},
   d2 = {"Lcom/blueair/devicedetails/util/AttributeAction;", "T", "", "value", "<init>", "(Ljava/lang/Object;)V", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "FanSpeedAction", "AutoModeAction", "StandbyModeAction", "EcoModeAction", "NightModeAction", "BrightnessAction", "BrightnessPercentageAction", "TroubleShootAction", "ManualModeAction", "OpenFilterInfoAction", "OpenFilterPageAction", "OpenGermShieldInfoAction", "GermShieldSwitchAction", "OpenGsnmInfoAction", "GsnmSwitchAction", "OpenDisinfectionInfoAction", "DisinfectionModeAction", "TimeZoneAction", "ChildLockAction", "AutoRhInfoAction", "AutoRhAction", "AutoRhShowHintAction", "OpenWickInfoAction", "OpenWickPageAction", "OpenTimerInfoAction", "TimerStateAction", "TimerDurationAction", "OpenDryModeInfoAction", "DryModeCancelAction", "OscillationEnableAction", "OscillationSettingAction", "MainModeAction", "ApSubModeAction", "SmartSubModeAction", "DehSubModeAction", "PeelingAction", "TargetTemperatureAction", "OpenFanPresetPageAction", "OpenHinsInfoAction", "HinsLockAction", "ModeAction", "HumModeAction", "OpenDeviceSettingsAction", "OpenDeviceSchedulesAction", "AutoRefreshInfoAction", "AutoRefreshCancelAction", "AutoRefreshHintClosedAction", "SelectTimerDurationAction", "WickDryingInfoAction", "MoodLampAction", "NightLampAction", "WickDryingAction", "OpenDeviceAlarmsAction", "CloseHumHintAction", "CloseSkinHintAction", "CloseSmartHintAction", "CloseHeatingHintAction", "CloseCantHeatHintAction", "OpenCubeInfoAction", "OpenCubePageAction", "HumSubModeAction", "CoolSubModeAction", "OpenTargetTmpInfoAction", "DualOscillationSettingAction", "DualOscillationStateAction", "AutoLevelInfoAction", "AutoLevelAction", "OscillationLoopInfoAction", "OscillationLoopHintClosedAction", "OscillationLoopStateAction", "NightSleepInfoAction", "NightSleepHintClosedAction", "Lcom/blueair/devicedetails/util/AttributeAction$ApSubModeAction;", "Lcom/blueair/devicedetails/util/AttributeAction$AutoLevelAction;", "Lcom/blueair/devicedetails/util/AttributeAction$AutoLevelInfoAction;", "Lcom/blueair/devicedetails/util/AttributeAction$AutoModeAction;", "Lcom/blueair/devicedetails/util/AttributeAction$AutoRefreshCancelAction;", "Lcom/blueair/devicedetails/util/AttributeAction$AutoRefreshHintClosedAction;", "Lcom/blueair/devicedetails/util/AttributeAction$AutoRefreshInfoAction;", "Lcom/blueair/devicedetails/util/AttributeAction$AutoRhAction;", "Lcom/blueair/devicedetails/util/AttributeAction$AutoRhInfoAction;", "Lcom/blueair/devicedetails/util/AttributeAction$AutoRhShowHintAction;", "Lcom/blueair/devicedetails/util/AttributeAction$BrightnessAction;", "Lcom/blueair/devicedetails/util/AttributeAction$BrightnessPercentageAction;", "Lcom/blueair/devicedetails/util/AttributeAction$ChildLockAction;", "Lcom/blueair/devicedetails/util/AttributeAction$CloseCantHeatHintAction;", "Lcom/blueair/devicedetails/util/AttributeAction$CloseHeatingHintAction;", "Lcom/blueair/devicedetails/util/AttributeAction$CloseHumHintAction;", "Lcom/blueair/devicedetails/util/AttributeAction$CloseSkinHintAction;", "Lcom/blueair/devicedetails/util/AttributeAction$CloseSmartHintAction;", "Lcom/blueair/devicedetails/util/AttributeAction$CoolSubModeAction;", "Lcom/blueair/devicedetails/util/AttributeAction$DehSubModeAction;", "Lcom/blueair/devicedetails/util/AttributeAction$DisinfectionModeAction;", "Lcom/blueair/devicedetails/util/AttributeAction$DryModeCancelAction;", "Lcom/blueair/devicedetails/util/AttributeAction$DualOscillationSettingAction;", "Lcom/blueair/devicedetails/util/AttributeAction$DualOscillationStateAction;", "Lcom/blueair/devicedetails/util/AttributeAction$EcoModeAction;", "Lcom/blueair/devicedetails/util/AttributeAction$FanSpeedAction;", "Lcom/blueair/devicedetails/util/AttributeAction$GermShieldSwitchAction;", "Lcom/blueair/devicedetails/util/AttributeAction$GsnmSwitchAction;", "Lcom/blueair/devicedetails/util/AttributeAction$HinsLockAction;", "Lcom/blueair/devicedetails/util/AttributeAction$HumModeAction;", "Lcom/blueair/devicedetails/util/AttributeAction$HumSubModeAction;", "Lcom/blueair/devicedetails/util/AttributeAction$MainModeAction;", "Lcom/blueair/devicedetails/util/AttributeAction$ManualModeAction;", "Lcom/blueair/devicedetails/util/AttributeAction$ModeAction;", "Lcom/blueair/devicedetails/util/AttributeAction$MoodLampAction;", "Lcom/blueair/devicedetails/util/AttributeAction$NightLampAction;", "Lcom/blueair/devicedetails/util/AttributeAction$NightModeAction;", "Lcom/blueair/devicedetails/util/AttributeAction$NightSleepHintClosedAction;", "Lcom/blueair/devicedetails/util/AttributeAction$NightSleepInfoAction;", "Lcom/blueair/devicedetails/util/AttributeAction$OpenCubeInfoAction;", "Lcom/blueair/devicedetails/util/AttributeAction$OpenCubePageAction;", "Lcom/blueair/devicedetails/util/AttributeAction$OpenDeviceAlarmsAction;", "Lcom/blueair/devicedetails/util/AttributeAction$OpenDeviceSchedulesAction;", "Lcom/blueair/devicedetails/util/AttributeAction$OpenDeviceSettingsAction;", "Lcom/blueair/devicedetails/util/AttributeAction$OpenDisinfectionInfoAction;", "Lcom/blueair/devicedetails/util/AttributeAction$OpenDryModeInfoAction;", "Lcom/blueair/devicedetails/util/AttributeAction$OpenFanPresetPageAction;", "Lcom/blueair/devicedetails/util/AttributeAction$OpenFilterInfoAction;", "Lcom/blueair/devicedetails/util/AttributeAction$OpenFilterPageAction;", "Lcom/blueair/devicedetails/util/AttributeAction$OpenGermShieldInfoAction;", "Lcom/blueair/devicedetails/util/AttributeAction$OpenGsnmInfoAction;", "Lcom/blueair/devicedetails/util/AttributeAction$OpenHinsInfoAction;", "Lcom/blueair/devicedetails/util/AttributeAction$OpenTargetTmpInfoAction;", "Lcom/blueair/devicedetails/util/AttributeAction$OpenTimerInfoAction;", "Lcom/blueair/devicedetails/util/AttributeAction$OpenWickInfoAction;", "Lcom/blueair/devicedetails/util/AttributeAction$OpenWickPageAction;", "Lcom/blueair/devicedetails/util/AttributeAction$OscillationEnableAction;", "Lcom/blueair/devicedetails/util/AttributeAction$OscillationLoopHintClosedAction;", "Lcom/blueair/devicedetails/util/AttributeAction$OscillationLoopInfoAction;", "Lcom/blueair/devicedetails/util/AttributeAction$OscillationLoopStateAction;", "Lcom/blueair/devicedetails/util/AttributeAction$OscillationSettingAction;", "Lcom/blueair/devicedetails/util/AttributeAction$PeelingAction;", "Lcom/blueair/devicedetails/util/AttributeAction$SelectTimerDurationAction;", "Lcom/blueair/devicedetails/util/AttributeAction$SmartSubModeAction;", "Lcom/blueair/devicedetails/util/AttributeAction$StandbyModeAction;", "Lcom/blueair/devicedetails/util/AttributeAction$TargetTemperatureAction;", "Lcom/blueair/devicedetails/util/AttributeAction$TimeZoneAction;", "Lcom/blueair/devicedetails/util/AttributeAction$TimerDurationAction;", "Lcom/blueair/devicedetails/util/AttributeAction$TimerStateAction;", "Lcom/blueair/devicedetails/util/AttributeAction$TroubleShootAction;", "Lcom/blueair/devicedetails/util/AttributeAction$WickDryingAction;", "Lcom/blueair/devicedetails/util/AttributeAction$WickDryingInfoAction;", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public abstract class AttributeAction {
   private final Object value;

   private AttributeAction(Object var1) {
      this.value = var1;
   }

   // $FF: synthetic method
   public AttributeAction(Object var1, DefaultConstructorMarker var2) {
      this(var1);
   }

   public final Object getValue() {
      return this.value;
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
      d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$ApSubModeAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "Lcom/blueair/core/model/ApSubMode;", "value", "<init>", "(Lcom/blueair/core/model/ApSubMode;)V", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class ApSubModeAction extends AttributeAction {
      public ApSubModeAction(ApSubMode var1) {
         Intrinsics.checkNotNullParameter(var1, "value");
         super(var1, (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
      d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$AutoLevelAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "Lcom/blueair/core/model/AutoLevel;", "level", "<init>", "(Lcom/blueair/core/model/AutoLevel;)V", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class AutoLevelAction extends AttributeAction {
      public AutoLevelAction(AutoLevel var1) {
         Intrinsics.checkNotNullParameter(var1, "level");
         super(var1, (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$AutoLevelInfoAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "", "<init>", "()V", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class AutoLevelInfoAction extends AttributeAction {
      public static final AutoLevelInfoAction INSTANCE = new AutoLevelInfoAction();

      private AutoLevelInfoAction() {
         super(Unit.INSTANCE, (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
      d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$AutoModeAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "", "value", "<init>", "(Z)V", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class AutoModeAction extends AttributeAction {
      public AutoModeAction(boolean var1) {
         super(var1, (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$AutoRefreshCancelAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "", "<init>", "()V", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class AutoRefreshCancelAction extends AttributeAction {
      public static final AutoRefreshCancelAction INSTANCE = new AutoRefreshCancelAction();

      private AutoRefreshCancelAction() {
         super(Unit.INSTANCE, (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$AutoRefreshHintClosedAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "", "<init>", "()V", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class AutoRefreshHintClosedAction extends AttributeAction {
      public static final AutoRefreshHintClosedAction INSTANCE = new AutoRefreshHintClosedAction();

      private AutoRefreshHintClosedAction() {
         super(Unit.INSTANCE, (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$AutoRefreshInfoAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "", "<init>", "()V", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class AutoRefreshInfoAction extends AttributeAction {
      public static final AutoRefreshInfoAction INSTANCE = new AutoRefreshInfoAction();

      private AutoRefreshInfoAction() {
         super(Unit.INSTANCE, (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
      d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$AutoRhAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "", "value", "<init>", "(I)V", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class AutoRhAction extends AttributeAction {
      public AutoRhAction(int var1) {
         super(var1, (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$AutoRhInfoAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "", "<init>", "()V", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class AutoRhInfoAction extends AttributeAction {
      public static final AutoRhInfoAction INSTANCE = new AutoRhInfoAction();

      private AutoRhInfoAction() {
         super(Unit.INSTANCE, (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
      d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$AutoRhShowHintAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "", "value", "<init>", "(Z)V", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class AutoRhShowHintAction extends AttributeAction {
      public AutoRhShowHintAction(boolean var1) {
         super(var1, (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
      d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$BrightnessAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "Lcom/blueair/core/model/Brightness;", "value", "<init>", "(Lcom/blueair/core/model/Brightness;)V", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class BrightnessAction extends AttributeAction {
      public BrightnessAction(Brightness var1) {
         Intrinsics.checkNotNullParameter(var1, "value");
         super(var1, (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
      d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$BrightnessPercentageAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "", "value", "<init>", "(I)V", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class BrightnessPercentageAction extends AttributeAction {
      public BrightnessPercentageAction(int var1) {
         super(var1, (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$ChildLockAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "", "<init>", "()V", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class ChildLockAction extends AttributeAction {
      public static final ChildLockAction INSTANCE = new ChildLockAction();

      private ChildLockAction() {
         super(Unit.INSTANCE, (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$CloseCantHeatHintAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "", "<init>", "()V", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class CloseCantHeatHintAction extends AttributeAction {
      public static final CloseCantHeatHintAction INSTANCE = new CloseCantHeatHintAction();

      private CloseCantHeatHintAction() {
         super(Unit.INSTANCE, (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$CloseHeatingHintAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "", "<init>", "()V", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class CloseHeatingHintAction extends AttributeAction {
      public static final CloseHeatingHintAction INSTANCE = new CloseHeatingHintAction();

      private CloseHeatingHintAction() {
         super(Unit.INSTANCE, (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$CloseHumHintAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "", "<init>", "()V", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class CloseHumHintAction extends AttributeAction {
      public static final CloseHumHintAction INSTANCE = new CloseHumHintAction();

      private CloseHumHintAction() {
         super(Unit.INSTANCE, (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$CloseSkinHintAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "", "<init>", "()V", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class CloseSkinHintAction extends AttributeAction {
      public static final CloseSkinHintAction INSTANCE = new CloseSkinHintAction();

      private CloseSkinHintAction() {
         super(Unit.INSTANCE, (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$CloseSmartHintAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "", "<init>", "()V", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class CloseSmartHintAction extends AttributeAction {
      public static final CloseSmartHintAction INSTANCE = new CloseSmartHintAction();

      private CloseSmartHintAction() {
         super(Unit.INSTANCE, (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
      d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$CoolSubModeAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "Lcom/blueair/core/model/CoolSubMode;", "value", "<init>", "(Lcom/blueair/core/model/CoolSubMode;)V", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class CoolSubModeAction extends AttributeAction {
      public CoolSubModeAction(CoolSubMode var1) {
         Intrinsics.checkNotNullParameter(var1, "value");
         super(var1, (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
      d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$DehSubModeAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "Lcom/blueair/core/model/DehSubMode;", "value", "<init>", "(Lcom/blueair/core/model/DehSubMode;)V", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class DehSubModeAction extends AttributeAction {
      public DehSubModeAction(DehSubMode var1) {
         Intrinsics.checkNotNullParameter(var1, "value");
         super(var1, (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$DisinfectionModeAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "", "<init>", "()V", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class DisinfectionModeAction extends AttributeAction {
      public static final DisinfectionModeAction INSTANCE = new DisinfectionModeAction();

      private DisinfectionModeAction() {
         super(Unit.INSTANCE, (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$DryModeCancelAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "", "<init>", "()V", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class DryModeCancelAction extends AttributeAction {
      public static final DryModeCancelAction INSTANCE = new DryModeCancelAction();

      private DryModeCancelAction() {
         super(Unit.INSTANCE, (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
      d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$DualOscillationSettingAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "", "horizontal", "<init>", "(Z)V", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class DualOscillationSettingAction extends AttributeAction {
      public DualOscillationSettingAction(boolean var1) {
         super(var1, (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
      d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$DualOscillationStateAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "", "horizontal", "<init>", "(Z)V", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class DualOscillationStateAction extends AttributeAction {
      public DualOscillationStateAction(boolean var1) {
         super(var1, (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$EcoModeAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "", "<init>", "()V", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class EcoModeAction extends AttributeAction {
      public static final EcoModeAction INSTANCE = new EcoModeAction();

      private EcoModeAction() {
         super(Unit.INSTANCE, (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
      d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$FanSpeedAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "Lcom/blueair/core/model/FanSpeedEnum;", "value", "<init>", "(Lcom/blueair/core/model/FanSpeedEnum;)V", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class FanSpeedAction extends AttributeAction {
      public FanSpeedAction(FanSpeedEnum var1) {
         Intrinsics.checkNotNullParameter(var1, "value");
         super(var1, (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$GermShieldSwitchAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "", "<init>", "()V", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class GermShieldSwitchAction extends AttributeAction {
      public static final GermShieldSwitchAction INSTANCE = new GermShieldSwitchAction();

      private GermShieldSwitchAction() {
         super(Unit.INSTANCE, (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$GsnmSwitchAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "", "<init>", "()V", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class GsnmSwitchAction extends AttributeAction {
      public static final GsnmSwitchAction INSTANCE = new GsnmSwitchAction();

      private GsnmSwitchAction() {
         super(Unit.INSTANCE, (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
      d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$HinsLockAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "", "isNightMode", "<init>", "(Z)V", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class HinsLockAction extends AttributeAction {
      public HinsLockAction(boolean var1) {
         super(var1, (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$HumModeAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "", "<init>", "()V", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class HumModeAction extends AttributeAction {
      public static final HumModeAction INSTANCE = new HumModeAction();

      private HumModeAction() {
         super(Unit.INSTANCE, (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
      d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$HumSubModeAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "Lcom/blueair/core/model/HumSubMode;", "value", "<init>", "(Lcom/blueair/core/model/HumSubMode;)V", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class HumSubModeAction extends AttributeAction {
      public HumSubModeAction(HumSubMode var1) {
         Intrinsics.checkNotNullParameter(var1, "value");
         super(var1, (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
      d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$MainModeAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "Lcom/blueair/core/model/MainMode;", "value", "<init>", "(Lcom/blueair/core/model/MainMode;)V", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class MainModeAction extends AttributeAction {
      public MainModeAction(MainMode var1) {
         Intrinsics.checkNotNullParameter(var1, "value");
         super(var1, (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$ManualModeAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "", "<init>", "()V", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class ManualModeAction extends AttributeAction {
      public static final ManualModeAction INSTANCE = new ManualModeAction();

      private ManualModeAction() {
         super(Unit.INSTANCE, (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
      d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$ModeAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "Lcom/blueair/core/model/Mode;", "value", "<init>", "(Lcom/blueair/core/model/Mode;)V", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class ModeAction extends AttributeAction {
      public ModeAction(Mode var1) {
         Intrinsics.checkNotNullParameter(var1, "value");
         super(var1, (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
      d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$MoodLampAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "Lcom/blueair/core/model/MoodLampEnum;", "value", "<init>", "(Lcom/blueair/core/model/MoodLampEnum;)V", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class MoodLampAction extends AttributeAction {
      public MoodLampAction(MoodLampEnum var1) {
         Intrinsics.checkNotNullParameter(var1, "value");
         super(var1, (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
      d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$NightLampAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "", "value", "<init>", "(I)V", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class NightLampAction extends AttributeAction {
      public NightLampAction(int var1) {
         super(var1, (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$NightModeAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "", "<init>", "()V", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class NightModeAction extends AttributeAction {
      public static final NightModeAction INSTANCE = new NightModeAction();

      private NightModeAction() {
         super(Unit.INSTANCE, (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$NightSleepHintClosedAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "", "<init>", "()V", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class NightSleepHintClosedAction extends AttributeAction {
      public static final NightSleepHintClosedAction INSTANCE = new NightSleepHintClosedAction();

      private NightSleepHintClosedAction() {
         super(Unit.INSTANCE, (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$NightSleepInfoAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "", "<init>", "()V", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class NightSleepInfoAction extends AttributeAction {
      public static final NightSleepInfoAction INSTANCE = new NightSleepInfoAction();

      private NightSleepInfoAction() {
         super(Unit.INSTANCE, (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$OpenCubeInfoAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "", "<init>", "()V", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class OpenCubeInfoAction extends AttributeAction {
      public static final OpenCubeInfoAction INSTANCE = new OpenCubeInfoAction();

      private OpenCubeInfoAction() {
         super(Unit.INSTANCE, (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
      d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$OpenCubePageAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "", "onlyBuy", "<init>", "(Z)V", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class OpenCubePageAction extends AttributeAction {
      public OpenCubePageAction(boolean var1) {
         super(var1, (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$OpenDeviceAlarmsAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "", "<init>", "()V", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class OpenDeviceAlarmsAction extends AttributeAction {
      public static final OpenDeviceAlarmsAction INSTANCE = new OpenDeviceAlarmsAction();

      private OpenDeviceAlarmsAction() {
         super(Unit.INSTANCE, (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$OpenDeviceSchedulesAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "", "<init>", "()V", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class OpenDeviceSchedulesAction extends AttributeAction {
      public static final OpenDeviceSchedulesAction INSTANCE = new OpenDeviceSchedulesAction();

      private OpenDeviceSchedulesAction() {
         super(Unit.INSTANCE, (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$OpenDeviceSettingsAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "", "<init>", "()V", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class OpenDeviceSettingsAction extends AttributeAction {
      public static final OpenDeviceSettingsAction INSTANCE = new OpenDeviceSettingsAction();

      private OpenDeviceSettingsAction() {
         super(Unit.INSTANCE, (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$OpenDisinfectionInfoAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "", "<init>", "()V", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class OpenDisinfectionInfoAction extends AttributeAction {
      public static final OpenDisinfectionInfoAction INSTANCE = new OpenDisinfectionInfoAction();

      private OpenDisinfectionInfoAction() {
         super(Unit.INSTANCE, (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$OpenDryModeInfoAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "", "<init>", "()V", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class OpenDryModeInfoAction extends AttributeAction {
      public static final OpenDryModeInfoAction INSTANCE = new OpenDryModeInfoAction();

      private OpenDryModeInfoAction() {
         super(Unit.INSTANCE, (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$OpenFanPresetPageAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "", "<init>", "()V", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class OpenFanPresetPageAction extends AttributeAction {
      public static final OpenFanPresetPageAction INSTANCE = new OpenFanPresetPageAction();

      private OpenFanPresetPageAction() {
         super(Unit.INSTANCE, (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$OpenFilterInfoAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "", "<init>", "()V", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class OpenFilterInfoAction extends AttributeAction {
      public static final OpenFilterInfoAction INSTANCE = new OpenFilterInfoAction();

      private OpenFilterInfoAction() {
         super(Unit.INSTANCE, (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
      d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$OpenFilterPageAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "", "onlyBuy", "<init>", "(Z)V", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class OpenFilterPageAction extends AttributeAction {
      public OpenFilterPageAction(boolean var1) {
         super(var1, (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$OpenGermShieldInfoAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "", "<init>", "()V", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class OpenGermShieldInfoAction extends AttributeAction {
      public static final OpenGermShieldInfoAction INSTANCE = new OpenGermShieldInfoAction();

      private OpenGermShieldInfoAction() {
         super(Unit.INSTANCE, (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$OpenGsnmInfoAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "", "<init>", "()V", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class OpenGsnmInfoAction extends AttributeAction {
      public static final OpenGsnmInfoAction INSTANCE = new OpenGsnmInfoAction();

      private OpenGsnmInfoAction() {
         super(Unit.INSTANCE, (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
      d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$OpenHinsInfoAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "", "isNightMode", "<init>", "(Z)V", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class OpenHinsInfoAction extends AttributeAction {
      public OpenHinsInfoAction(boolean var1) {
         super(var1, (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$OpenTargetTmpInfoAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "", "<init>", "()V", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class OpenTargetTmpInfoAction extends AttributeAction {
      public static final OpenTargetTmpInfoAction INSTANCE = new OpenTargetTmpInfoAction();

      private OpenTargetTmpInfoAction() {
         super(Unit.INSTANCE, (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$OpenTimerInfoAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "", "<init>", "()V", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class OpenTimerInfoAction extends AttributeAction {
      public static final OpenTimerInfoAction INSTANCE = new OpenTimerInfoAction();

      private OpenTimerInfoAction() {
         super(Unit.INSTANCE, (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$OpenWickInfoAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "", "<init>", "()V", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class OpenWickInfoAction extends AttributeAction {
      public static final OpenWickInfoAction INSTANCE = new OpenWickInfoAction();

      private OpenWickInfoAction() {
         super(Unit.INSTANCE, (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
      d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$OpenWickPageAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "", "onlyBuy", "<init>", "(Z)V", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class OpenWickPageAction extends AttributeAction {
      public OpenWickPageAction(boolean var1) {
         super(var1, (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$OscillationEnableAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "", "<init>", "()V", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class OscillationEnableAction extends AttributeAction {
      public static final OscillationEnableAction INSTANCE = new OscillationEnableAction();

      private OscillationEnableAction() {
         super(Unit.INSTANCE, (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$OscillationLoopHintClosedAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "", "<init>", "()V", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class OscillationLoopHintClosedAction extends AttributeAction {
      public static final OscillationLoopHintClosedAction INSTANCE = new OscillationLoopHintClosedAction();

      private OscillationLoopHintClosedAction() {
         super(Unit.INSTANCE, (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$OscillationLoopInfoAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "", "<init>", "()V", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class OscillationLoopInfoAction extends AttributeAction {
      public static final OscillationLoopInfoAction INSTANCE = new OscillationLoopInfoAction();

      private OscillationLoopInfoAction() {
         super(Unit.INSTANCE, (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$OscillationLoopStateAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "", "<init>", "()V", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class OscillationLoopStateAction extends AttributeAction {
      public static final OscillationLoopStateAction INSTANCE = new OscillationLoopStateAction();

      private OscillationLoopStateAction() {
         super(Unit.INSTANCE, (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$OscillationSettingAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "", "<init>", "()V", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class OscillationSettingAction extends AttributeAction {
      public static final OscillationSettingAction INSTANCE = new OscillationSettingAction();

      private OscillationSettingAction() {
         super(Unit.INSTANCE, (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$PeelingAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "", "<init>", "()V", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class PeelingAction extends AttributeAction {
      public static final PeelingAction INSTANCE = new PeelingAction();

      private PeelingAction() {
         super(Unit.INSTANCE, (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$SelectTimerDurationAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "", "<init>", "()V", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class SelectTimerDurationAction extends AttributeAction {
      public static final SelectTimerDurationAction INSTANCE = new SelectTimerDurationAction();

      private SelectTimerDurationAction() {
         super(Unit.INSTANCE, (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
      d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$SmartSubModeAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "Lcom/blueair/core/model/SmartSubMode;", "value", "<init>", "(Lcom/blueair/core/model/SmartSubMode;)V", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class SmartSubModeAction extends AttributeAction {
      public SmartSubModeAction(SmartSubMode var1) {
         Intrinsics.checkNotNullParameter(var1, "value");
         super(var1, (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$StandbyModeAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "", "<init>", "()V", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class StandbyModeAction extends AttributeAction {
      public static final StandbyModeAction INSTANCE = new StandbyModeAction();

      private StandbyModeAction() {
         super(Unit.INSTANCE, (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
      d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$TargetTemperatureAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "", "value", "<init>", "(D)V", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class TargetTemperatureAction extends AttributeAction {
      public TargetTemperatureAction(double var1) {
         super(var1, (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$TimeZoneAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "", "<init>", "()V", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class TimeZoneAction extends AttributeAction {
      public static final TimeZoneAction INSTANCE = new TimeZoneAction();

      private TimeZoneAction() {
         super(Unit.INSTANCE, (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
      d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$TimerDurationAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "", "value", "<init>", "(I)V", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class TimerDurationAction extends AttributeAction {
      public TimerDurationAction(int var1) {
         super(var1, (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
      d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$TimerStateAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "Lcom/blueair/core/model/TimerState;", "value", "<init>", "(Lcom/blueair/core/model/TimerState;)V", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class TimerStateAction extends AttributeAction {
      public TimerStateAction(TimerState var1) {
         Intrinsics.checkNotNullParameter(var1, "value");
         super(var1, (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$TroubleShootAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "", "<init>", "()V", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class TroubleShootAction extends AttributeAction {
      public static final TroubleShootAction INSTANCE = new TroubleShootAction();

      private TroubleShootAction() {
         super(Unit.INSTANCE, (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
      d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$WickDryingAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "Lcom/blueair/core/model/WickDryingGear;", "value", "<init>", "(Lcom/blueair/core/model/WickDryingGear;)V", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class WickDryingAction extends AttributeAction {
      public WickDryingAction(WickDryingGear var1) {
         Intrinsics.checkNotNullParameter(var1, "value");
         super(var1, (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$WickDryingInfoAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "", "<init>", "()V", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class WickDryingInfoAction extends AttributeAction {
      public static final WickDryingInfoAction INSTANCE = new WickDryingInfoAction();

      private WickDryingInfoAction() {
         super(Unit.INSTANCE, (DefaultConstructorMarker)null);
      }
   }
}
