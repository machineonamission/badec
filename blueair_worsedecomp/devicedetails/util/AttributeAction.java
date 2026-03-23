package com.blueair.devicedetails.util;

import com.blueair.core.model.ApSubMode;
import com.blueair.core.model.Brightness;
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

@Metadata(d1 = {"\u0000ô\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b?\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:9\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&'()*+,-./0123456789:;<=>?@AB\u0011\b\u0004\u0012\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0004\b\u0004\u0010\u0005R\u0013\u0010\u0003\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007\u00019BCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz¨\u0006{"}, d2 = {"Lcom/blueair/devicedetails/util/AttributeAction;", "T", "", "value", "<init>", "(Ljava/lang/Object;)V", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "FanSpeedAction", "AutoModeAction", "StandbyModeAction", "EcoModeAction", "NightModeAction", "BrightnessAction", "BrightnessPercentageAction", "TroubleShootAction", "ManualModeAction", "OpenFilterInfoAction", "OpenFilterPageAction", "OpenGermShieldInfoAction", "GsnmSwitchAction", "OpenDisinfectionInfoAction", "DisinfectionModeAction", "TimeZoneAction", "ChildLockAction", "AutoRhInfoAction", "AutoRhAction", "AutoRhShowHintAction", "OpenWickInfoAction", "OpenWickPageAction", "OpenTimerInfoAction", "TimerStateAction", "TimerDurationAction", "OpenDryModeInfoAction", "DryModeCancelAction", "OscillationEnableAction", "OscillationSettingAction", "MainModeAction", "ApSubModeAction", "SmartSubModeAction", "DehSubModeAction", "PeelingAction", "TargetTemperatureAction", "OpenFanPresetPageAction", "OpenHinsInfoAction", "HinsLockAction", "ModeAction", "HumModeAction", "OpenDeviceSettingsAction", "OpenDeviceSchedulesAction", "AutoRefreshInfoAction", "AutoRefreshCancelAction", "AutoRefreshHintClosedAction", "SelectTimerDurationAction", "WickDryingInfoAction", "MoodLampAction", "NightLampAction", "WickDryingAction", "OpenDeviceAlarmsAction", "CloseHumHintAction", "CloseSkinHintAction", "CloseSmartHintAction", "OpenCubeInfoAction", "OpenCubePageAction", "HumSubModeAction", "Lcom/blueair/devicedetails/util/AttributeAction$ApSubModeAction;", "Lcom/blueair/devicedetails/util/AttributeAction$AutoModeAction;", "Lcom/blueair/devicedetails/util/AttributeAction$AutoRefreshCancelAction;", "Lcom/blueair/devicedetails/util/AttributeAction$AutoRefreshHintClosedAction;", "Lcom/blueair/devicedetails/util/AttributeAction$AutoRefreshInfoAction;", "Lcom/blueair/devicedetails/util/AttributeAction$AutoRhAction;", "Lcom/blueair/devicedetails/util/AttributeAction$AutoRhInfoAction;", "Lcom/blueair/devicedetails/util/AttributeAction$AutoRhShowHintAction;", "Lcom/blueair/devicedetails/util/AttributeAction$BrightnessAction;", "Lcom/blueair/devicedetails/util/AttributeAction$BrightnessPercentageAction;", "Lcom/blueair/devicedetails/util/AttributeAction$ChildLockAction;", "Lcom/blueair/devicedetails/util/AttributeAction$CloseHumHintAction;", "Lcom/blueair/devicedetails/util/AttributeAction$CloseSkinHintAction;", "Lcom/blueair/devicedetails/util/AttributeAction$CloseSmartHintAction;", "Lcom/blueair/devicedetails/util/AttributeAction$DehSubModeAction;", "Lcom/blueair/devicedetails/util/AttributeAction$DisinfectionModeAction;", "Lcom/blueair/devicedetails/util/AttributeAction$DryModeCancelAction;", "Lcom/blueair/devicedetails/util/AttributeAction$EcoModeAction;", "Lcom/blueair/devicedetails/util/AttributeAction$FanSpeedAction;", "Lcom/blueair/devicedetails/util/AttributeAction$GsnmSwitchAction;", "Lcom/blueair/devicedetails/util/AttributeAction$HinsLockAction;", "Lcom/blueair/devicedetails/util/AttributeAction$HumModeAction;", "Lcom/blueair/devicedetails/util/AttributeAction$HumSubModeAction;", "Lcom/blueair/devicedetails/util/AttributeAction$MainModeAction;", "Lcom/blueair/devicedetails/util/AttributeAction$ManualModeAction;", "Lcom/blueair/devicedetails/util/AttributeAction$ModeAction;", "Lcom/blueair/devicedetails/util/AttributeAction$MoodLampAction;", "Lcom/blueair/devicedetails/util/AttributeAction$NightLampAction;", "Lcom/blueair/devicedetails/util/AttributeAction$NightModeAction;", "Lcom/blueair/devicedetails/util/AttributeAction$OpenCubeInfoAction;", "Lcom/blueair/devicedetails/util/AttributeAction$OpenCubePageAction;", "Lcom/blueair/devicedetails/util/AttributeAction$OpenDeviceAlarmsAction;", "Lcom/blueair/devicedetails/util/AttributeAction$OpenDeviceSchedulesAction;", "Lcom/blueair/devicedetails/util/AttributeAction$OpenDeviceSettingsAction;", "Lcom/blueair/devicedetails/util/AttributeAction$OpenDisinfectionInfoAction;", "Lcom/blueair/devicedetails/util/AttributeAction$OpenDryModeInfoAction;", "Lcom/blueair/devicedetails/util/AttributeAction$OpenFanPresetPageAction;", "Lcom/blueair/devicedetails/util/AttributeAction$OpenFilterInfoAction;", "Lcom/blueair/devicedetails/util/AttributeAction$OpenFilterPageAction;", "Lcom/blueair/devicedetails/util/AttributeAction$OpenGermShieldInfoAction;", "Lcom/blueair/devicedetails/util/AttributeAction$OpenHinsInfoAction;", "Lcom/blueair/devicedetails/util/AttributeAction$OpenTimerInfoAction;", "Lcom/blueair/devicedetails/util/AttributeAction$OpenWickInfoAction;", "Lcom/blueair/devicedetails/util/AttributeAction$OpenWickPageAction;", "Lcom/blueair/devicedetails/util/AttributeAction$OscillationEnableAction;", "Lcom/blueair/devicedetails/util/AttributeAction$OscillationSettingAction;", "Lcom/blueair/devicedetails/util/AttributeAction$PeelingAction;", "Lcom/blueair/devicedetails/util/AttributeAction$SelectTimerDurationAction;", "Lcom/blueair/devicedetails/util/AttributeAction$SmartSubModeAction;", "Lcom/blueair/devicedetails/util/AttributeAction$StandbyModeAction;", "Lcom/blueair/devicedetails/util/AttributeAction$TargetTemperatureAction;", "Lcom/blueair/devicedetails/util/AttributeAction$TimeZoneAction;", "Lcom/blueair/devicedetails/util/AttributeAction$TimerDurationAction;", "Lcom/blueair/devicedetails/util/AttributeAction$TimerStateAction;", "Lcom/blueair/devicedetails/util/AttributeAction$TroubleShootAction;", "Lcom/blueair/devicedetails/util/AttributeAction$WickDryingAction;", "Lcom/blueair/devicedetails/util/AttributeAction$WickDryingInfoAction;", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceAttribute.kt */
public abstract class AttributeAction<T> {
    private final T value;

    public /* synthetic */ AttributeAction(Object obj, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj);
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$FanSpeedAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "Lcom/blueair/core/model/FanSpeedEnum;", "value", "<init>", "(Lcom/blueair/core/model/FanSpeedEnum;)V", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceAttribute.kt */
    public static final class FanSpeedAction extends AttributeAction<FanSpeedEnum> {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public FanSpeedAction(FanSpeedEnum fanSpeedEnum) {
            super(fanSpeedEnum, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(fanSpeedEnum, "value");
        }
    }

    private AttributeAction(T t) {
        this.value = t;
    }

    public final T getValue() {
        return this.value;
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$AutoModeAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "", "value", "<init>", "(Z)V", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceAttribute.kt */
    public static final class AutoModeAction extends AttributeAction<Boolean> {
        public AutoModeAction(boolean z) {
            super(Boolean.valueOf(z), (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$StandbyModeAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "", "<init>", "()V", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceAttribute.kt */
    public static final class StandbyModeAction extends AttributeAction<Unit> {
        public static final StandbyModeAction INSTANCE = new StandbyModeAction();

        private StandbyModeAction() {
            super(Unit.INSTANCE, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$EcoModeAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "", "<init>", "()V", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceAttribute.kt */
    public static final class EcoModeAction extends AttributeAction<Unit> {
        public static final EcoModeAction INSTANCE = new EcoModeAction();

        private EcoModeAction() {
            super(Unit.INSTANCE, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$NightModeAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "", "<init>", "()V", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceAttribute.kt */
    public static final class NightModeAction extends AttributeAction<Unit> {
        public static final NightModeAction INSTANCE = new NightModeAction();

        private NightModeAction() {
            super(Unit.INSTANCE, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$BrightnessAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "Lcom/blueair/core/model/Brightness;", "value", "<init>", "(Lcom/blueair/core/model/Brightness;)V", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceAttribute.kt */
    public static final class BrightnessAction extends AttributeAction<Brightness> {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public BrightnessAction(Brightness brightness) {
            super(brightness, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(brightness, "value");
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$BrightnessPercentageAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "", "value", "<init>", "(I)V", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceAttribute.kt */
    public static final class BrightnessPercentageAction extends AttributeAction<Integer> {
        public BrightnessPercentageAction(int i) {
            super(Integer.valueOf(i), (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$TroubleShootAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "", "<init>", "()V", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceAttribute.kt */
    public static final class TroubleShootAction extends AttributeAction<Unit> {
        public static final TroubleShootAction INSTANCE = new TroubleShootAction();

        private TroubleShootAction() {
            super(Unit.INSTANCE, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$ManualModeAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "", "<init>", "()V", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceAttribute.kt */
    public static final class ManualModeAction extends AttributeAction<Unit> {
        public static final ManualModeAction INSTANCE = new ManualModeAction();

        private ManualModeAction() {
            super(Unit.INSTANCE, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$OpenFilterInfoAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "", "<init>", "()V", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceAttribute.kt */
    public static final class OpenFilterInfoAction extends AttributeAction<Unit> {
        public static final OpenFilterInfoAction INSTANCE = new OpenFilterInfoAction();

        private OpenFilterInfoAction() {
            super(Unit.INSTANCE, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$OpenFilterPageAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "", "onlyBuy", "<init>", "(Z)V", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceAttribute.kt */
    public static final class OpenFilterPageAction extends AttributeAction<Boolean> {
        public OpenFilterPageAction(boolean z) {
            super(Boolean.valueOf(z), (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$OpenGermShieldInfoAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "", "<init>", "()V", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceAttribute.kt */
    public static final class OpenGermShieldInfoAction extends AttributeAction<Unit> {
        public static final OpenGermShieldInfoAction INSTANCE = new OpenGermShieldInfoAction();

        private OpenGermShieldInfoAction() {
            super(Unit.INSTANCE, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$GsnmSwitchAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "", "<init>", "()V", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceAttribute.kt */
    public static final class GsnmSwitchAction extends AttributeAction<Unit> {
        public static final GsnmSwitchAction INSTANCE = new GsnmSwitchAction();

        private GsnmSwitchAction() {
            super(Unit.INSTANCE, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$OpenDisinfectionInfoAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "", "<init>", "()V", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceAttribute.kt */
    public static final class OpenDisinfectionInfoAction extends AttributeAction<Unit> {
        public static final OpenDisinfectionInfoAction INSTANCE = new OpenDisinfectionInfoAction();

        private OpenDisinfectionInfoAction() {
            super(Unit.INSTANCE, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$DisinfectionModeAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "", "<init>", "()V", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceAttribute.kt */
    public static final class DisinfectionModeAction extends AttributeAction<Unit> {
        public static final DisinfectionModeAction INSTANCE = new DisinfectionModeAction();

        private DisinfectionModeAction() {
            super(Unit.INSTANCE, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$TimeZoneAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "", "<init>", "()V", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceAttribute.kt */
    public static final class TimeZoneAction extends AttributeAction<Unit> {
        public static final TimeZoneAction INSTANCE = new TimeZoneAction();

        private TimeZoneAction() {
            super(Unit.INSTANCE, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$ChildLockAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "", "<init>", "()V", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceAttribute.kt */
    public static final class ChildLockAction extends AttributeAction<Unit> {
        public static final ChildLockAction INSTANCE = new ChildLockAction();

        private ChildLockAction() {
            super(Unit.INSTANCE, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$AutoRhInfoAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "", "<init>", "()V", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceAttribute.kt */
    public static final class AutoRhInfoAction extends AttributeAction<Unit> {
        public static final AutoRhInfoAction INSTANCE = new AutoRhInfoAction();

        private AutoRhInfoAction() {
            super(Unit.INSTANCE, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$AutoRhAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "", "value", "<init>", "(I)V", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceAttribute.kt */
    public static final class AutoRhAction extends AttributeAction<Integer> {
        public AutoRhAction(int i) {
            super(Integer.valueOf(i), (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$AutoRhShowHintAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "", "value", "<init>", "(Z)V", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceAttribute.kt */
    public static final class AutoRhShowHintAction extends AttributeAction<Boolean> {
        public AutoRhShowHintAction(boolean z) {
            super(Boolean.valueOf(z), (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$OpenWickInfoAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "", "<init>", "()V", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceAttribute.kt */
    public static final class OpenWickInfoAction extends AttributeAction<Unit> {
        public static final OpenWickInfoAction INSTANCE = new OpenWickInfoAction();

        private OpenWickInfoAction() {
            super(Unit.INSTANCE, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$OpenWickPageAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "", "onlyBuy", "<init>", "(Z)V", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceAttribute.kt */
    public static final class OpenWickPageAction extends AttributeAction<Boolean> {
        public OpenWickPageAction(boolean z) {
            super(Boolean.valueOf(z), (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$OpenTimerInfoAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "", "<init>", "()V", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceAttribute.kt */
    public static final class OpenTimerInfoAction extends AttributeAction<Unit> {
        public static final OpenTimerInfoAction INSTANCE = new OpenTimerInfoAction();

        private OpenTimerInfoAction() {
            super(Unit.INSTANCE, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$TimerStateAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "Lcom/blueair/core/model/TimerState;", "value", "<init>", "(Lcom/blueair/core/model/TimerState;)V", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceAttribute.kt */
    public static final class TimerStateAction extends AttributeAction<TimerState> {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public TimerStateAction(TimerState timerState) {
            super(timerState, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(timerState, "value");
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$TimerDurationAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "", "value", "<init>", "(I)V", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceAttribute.kt */
    public static final class TimerDurationAction extends AttributeAction<Integer> {
        public TimerDurationAction(int i) {
            super(Integer.valueOf(i), (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$OpenDryModeInfoAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "", "<init>", "()V", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceAttribute.kt */
    public static final class OpenDryModeInfoAction extends AttributeAction<Unit> {
        public static final OpenDryModeInfoAction INSTANCE = new OpenDryModeInfoAction();

        private OpenDryModeInfoAction() {
            super(Unit.INSTANCE, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$DryModeCancelAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "", "<init>", "()V", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceAttribute.kt */
    public static final class DryModeCancelAction extends AttributeAction<Unit> {
        public static final DryModeCancelAction INSTANCE = new DryModeCancelAction();

        private DryModeCancelAction() {
            super(Unit.INSTANCE, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$OscillationEnableAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "", "<init>", "()V", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceAttribute.kt */
    public static final class OscillationEnableAction extends AttributeAction<Unit> {
        public static final OscillationEnableAction INSTANCE = new OscillationEnableAction();

        private OscillationEnableAction() {
            super(Unit.INSTANCE, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$OscillationSettingAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "", "<init>", "()V", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceAttribute.kt */
    public static final class OscillationSettingAction extends AttributeAction<Unit> {
        public static final OscillationSettingAction INSTANCE = new OscillationSettingAction();

        private OscillationSettingAction() {
            super(Unit.INSTANCE, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$MainModeAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "Lcom/blueair/core/model/MainMode;", "value", "<init>", "(Lcom/blueair/core/model/MainMode;)V", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceAttribute.kt */
    public static final class MainModeAction extends AttributeAction<MainMode> {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public MainModeAction(MainMode mainMode) {
            super(mainMode, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(mainMode, "value");
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$ApSubModeAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "Lcom/blueair/core/model/ApSubMode;", "value", "<init>", "(Lcom/blueair/core/model/ApSubMode;)V", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceAttribute.kt */
    public static final class ApSubModeAction extends AttributeAction<ApSubMode> {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ApSubModeAction(ApSubMode apSubMode) {
            super(apSubMode, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(apSubMode, "value");
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$SmartSubModeAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "Lcom/blueair/core/model/SmartSubMode;", "value", "<init>", "(Lcom/blueair/core/model/SmartSubMode;)V", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceAttribute.kt */
    public static final class SmartSubModeAction extends AttributeAction<SmartSubMode> {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SmartSubModeAction(SmartSubMode smartSubMode) {
            super(smartSubMode, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(smartSubMode, "value");
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$DehSubModeAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "Lcom/blueair/core/model/DehSubMode;", "value", "<init>", "(Lcom/blueair/core/model/DehSubMode;)V", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceAttribute.kt */
    public static final class DehSubModeAction extends AttributeAction<DehSubMode> {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DehSubModeAction(DehSubMode dehSubMode) {
            super(dehSubMode, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(dehSubMode, "value");
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$PeelingAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "", "<init>", "()V", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceAttribute.kt */
    public static final class PeelingAction extends AttributeAction<Unit> {
        public static final PeelingAction INSTANCE = new PeelingAction();

        private PeelingAction() {
            super(Unit.INSTANCE, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$TargetTemperatureAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "", "value", "<init>", "(D)V", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceAttribute.kt */
    public static final class TargetTemperatureAction extends AttributeAction<Double> {
        public TargetTemperatureAction(double d) {
            super(Double.valueOf(d), (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$OpenFanPresetPageAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "", "<init>", "()V", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceAttribute.kt */
    public static final class OpenFanPresetPageAction extends AttributeAction<Unit> {
        public static final OpenFanPresetPageAction INSTANCE = new OpenFanPresetPageAction();

        private OpenFanPresetPageAction() {
            super(Unit.INSTANCE, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$OpenHinsInfoAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "", "isNightMode", "<init>", "(Z)V", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceAttribute.kt */
    public static final class OpenHinsInfoAction extends AttributeAction<Boolean> {
        public OpenHinsInfoAction(boolean z) {
            super(Boolean.valueOf(z), (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$HinsLockAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "", "isNightMode", "<init>", "(Z)V", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceAttribute.kt */
    public static final class HinsLockAction extends AttributeAction<Boolean> {
        public HinsLockAction(boolean z) {
            super(Boolean.valueOf(z), (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$ModeAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "Lcom/blueair/core/model/Mode;", "value", "<init>", "(Lcom/blueair/core/model/Mode;)V", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceAttribute.kt */
    public static final class ModeAction extends AttributeAction<Mode> {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ModeAction(Mode mode) {
            super(mode, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(mode, "value");
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$HumModeAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "", "<init>", "()V", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceAttribute.kt */
    public static final class HumModeAction extends AttributeAction<Unit> {
        public static final HumModeAction INSTANCE = new HumModeAction();

        private HumModeAction() {
            super(Unit.INSTANCE, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$OpenDeviceSettingsAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "", "<init>", "()V", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceAttribute.kt */
    public static final class OpenDeviceSettingsAction extends AttributeAction<Unit> {
        public static final OpenDeviceSettingsAction INSTANCE = new OpenDeviceSettingsAction();

        private OpenDeviceSettingsAction() {
            super(Unit.INSTANCE, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$OpenDeviceSchedulesAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "", "<init>", "()V", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceAttribute.kt */
    public static final class OpenDeviceSchedulesAction extends AttributeAction<Unit> {
        public static final OpenDeviceSchedulesAction INSTANCE = new OpenDeviceSchedulesAction();

        private OpenDeviceSchedulesAction() {
            super(Unit.INSTANCE, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$AutoRefreshInfoAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "", "<init>", "()V", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceAttribute.kt */
    public static final class AutoRefreshInfoAction extends AttributeAction<Unit> {
        public static final AutoRefreshInfoAction INSTANCE = new AutoRefreshInfoAction();

        private AutoRefreshInfoAction() {
            super(Unit.INSTANCE, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$AutoRefreshCancelAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "", "<init>", "()V", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceAttribute.kt */
    public static final class AutoRefreshCancelAction extends AttributeAction<Unit> {
        public static final AutoRefreshCancelAction INSTANCE = new AutoRefreshCancelAction();

        private AutoRefreshCancelAction() {
            super(Unit.INSTANCE, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$AutoRefreshHintClosedAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "", "<init>", "()V", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceAttribute.kt */
    public static final class AutoRefreshHintClosedAction extends AttributeAction<Unit> {
        public static final AutoRefreshHintClosedAction INSTANCE = new AutoRefreshHintClosedAction();

        private AutoRefreshHintClosedAction() {
            super(Unit.INSTANCE, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$SelectTimerDurationAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "", "<init>", "()V", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceAttribute.kt */
    public static final class SelectTimerDurationAction extends AttributeAction<Unit> {
        public static final SelectTimerDurationAction INSTANCE = new SelectTimerDurationAction();

        private SelectTimerDurationAction() {
            super(Unit.INSTANCE, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$WickDryingInfoAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "", "<init>", "()V", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceAttribute.kt */
    public static final class WickDryingInfoAction extends AttributeAction<Unit> {
        public static final WickDryingInfoAction INSTANCE = new WickDryingInfoAction();

        private WickDryingInfoAction() {
            super(Unit.INSTANCE, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$MoodLampAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "Lcom/blueair/core/model/MoodLampEnum;", "value", "<init>", "(Lcom/blueair/core/model/MoodLampEnum;)V", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceAttribute.kt */
    public static final class MoodLampAction extends AttributeAction<MoodLampEnum> {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public MoodLampAction(MoodLampEnum moodLampEnum) {
            super(moodLampEnum, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(moodLampEnum, "value");
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$NightLampAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "", "value", "<init>", "(I)V", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceAttribute.kt */
    public static final class NightLampAction extends AttributeAction<Integer> {
        public NightLampAction(int i) {
            super(Integer.valueOf(i), (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$WickDryingAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "Lcom/blueair/core/model/WickDryingGear;", "value", "<init>", "(Lcom/blueair/core/model/WickDryingGear;)V", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceAttribute.kt */
    public static final class WickDryingAction extends AttributeAction<WickDryingGear> {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public WickDryingAction(WickDryingGear wickDryingGear) {
            super(wickDryingGear, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(wickDryingGear, "value");
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$OpenDeviceAlarmsAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "", "<init>", "()V", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceAttribute.kt */
    public static final class OpenDeviceAlarmsAction extends AttributeAction<Unit> {
        public static final OpenDeviceAlarmsAction INSTANCE = new OpenDeviceAlarmsAction();

        private OpenDeviceAlarmsAction() {
            super(Unit.INSTANCE, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$CloseHumHintAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "", "<init>", "()V", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceAttribute.kt */
    public static final class CloseHumHintAction extends AttributeAction<Unit> {
        public static final CloseHumHintAction INSTANCE = new CloseHumHintAction();

        private CloseHumHintAction() {
            super(Unit.INSTANCE, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$CloseSkinHintAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "", "<init>", "()V", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceAttribute.kt */
    public static final class CloseSkinHintAction extends AttributeAction<Unit> {
        public static final CloseSkinHintAction INSTANCE = new CloseSkinHintAction();

        private CloseSkinHintAction() {
            super(Unit.INSTANCE, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$CloseSmartHintAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "", "<init>", "()V", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceAttribute.kt */
    public static final class CloseSmartHintAction extends AttributeAction<Unit> {
        public static final CloseSmartHintAction INSTANCE = new CloseSmartHintAction();

        private CloseSmartHintAction() {
            super(Unit.INSTANCE, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$OpenCubeInfoAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "", "<init>", "()V", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceAttribute.kt */
    public static final class OpenCubeInfoAction extends AttributeAction<Unit> {
        public static final OpenCubeInfoAction INSTANCE = new OpenCubeInfoAction();

        private OpenCubeInfoAction() {
            super(Unit.INSTANCE, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$OpenCubePageAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "", "onlyBuy", "<init>", "(Z)V", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceAttribute.kt */
    public static final class OpenCubePageAction extends AttributeAction<Boolean> {
        public OpenCubePageAction(boolean z) {
            super(Boolean.valueOf(z), (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/devicedetails/util/AttributeAction$HumSubModeAction;", "Lcom/blueair/devicedetails/util/AttributeAction;", "Lcom/blueair/core/model/HumSubMode;", "value", "<init>", "(Lcom/blueair/core/model/HumSubMode;)V", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceAttribute.kt */
    public static final class HumSubModeAction extends AttributeAction<HumSubMode> {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public HumSubModeAction(HumSubMode humSubMode) {
            super(humSubMode, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(humSubMode, "value");
        }
    }
}
