package com.blueair.livestream;

import com.blueair.api.model.SensorDataKt;
import com.blueair.core.model.AutoMode;
import com.blueair.core.model.ConnectedState;
import com.blueair.core.model.ConnectivityStatus;
import com.blueair.core.model.DeviceAlarm;
import com.blueair.core.model.DeviceData;
import com.blueair.core.model.DeviceEvent;
import com.blueair.core.model.DeviceState;
import com.blueair.core.model.DeviceStreamAttribute;
import com.blueair.core.model.IndoorDatapoint;
import com.blueair.core.util.MoshiSerializer;
import com.blueair.database.entity.DeviceDataEntity;
import io.flatcircle.ble.BleEvent;
import io.flatcircle.mqtt.MqttEvent;
import io.flatcircle.stomp.StompEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import timber.log.Timber;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u0000 \u001c*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u001cB#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0011\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\u0010\u0010\u0013\u001a\u0004\u0018\u00018\u0000HÆ\u0003¢\u0006\u0002\u0010\u000fJ4\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00018\u0000HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0007\u001a\u0004\u0018\u00018\u0000¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001d"}, d2 = {"Lcom/blueair/livestream/StreamEvent;", "T", "", "eventType", "Lcom/blueair/livestream/StreamEventType;", "deviceId", "", "content", "<init>", "(Lcom/blueair/livestream/StreamEventType;Ljava/lang/String;Ljava/lang/Object;)V", "getEventType", "()Lcom/blueair/livestream/StreamEventType;", "getDeviceId", "()Ljava/lang/String;", "getContent", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "component2", "component3", "copy", "(Lcom/blueair/livestream/StreamEventType;Ljava/lang/String;Ljava/lang/Object;)Lcom/blueair/livestream/StreamEvent;", "equals", "", "other", "hashCode", "", "toString", "Companion", "livestream_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: StreamEvent.kt */
public final class StreamEvent<T> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Lazy<MoshiSerializer<DeviceAlarm>> alarmSerializer$delegate = LazyKt.lazy(new StreamEvent$$ExternalSyntheticLambda0());
    /* access modifiers changed from: private */
    public static Map<String, Integer> updateProgress = new LinkedHashMap();
    private final T content;
    private final String deviceId;
    private final StreamEventType eventType;

    public static /* synthetic */ StreamEvent copy$default(StreamEvent streamEvent, StreamEventType streamEventType, String str, T t, int i, Object obj) {
        if ((i & 1) != 0) {
            streamEventType = streamEvent.eventType;
        }
        if ((i & 2) != 0) {
            str = streamEvent.deviceId;
        }
        if ((i & 4) != 0) {
            t = streamEvent.content;
        }
        return streamEvent.copy(streamEventType, str, t);
    }

    public final StreamEventType component1() {
        return this.eventType;
    }

    public final String component2() {
        return this.deviceId;
    }

    public final T component3() {
        return this.content;
    }

    public final StreamEvent<T> copy(StreamEventType streamEventType, String str, T t) {
        Intrinsics.checkNotNullParameter(streamEventType, "eventType");
        Intrinsics.checkNotNullParameter(str, DeviceDataEntity.DEVICE_ID);
        return new StreamEvent<>(streamEventType, str, t);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StreamEvent)) {
            return false;
        }
        StreamEvent streamEvent = (StreamEvent) obj;
        return this.eventType == streamEvent.eventType && Intrinsics.areEqual((Object) this.deviceId, (Object) streamEvent.deviceId) && Intrinsics.areEqual((Object) this.content, (Object) streamEvent.content);
    }

    public int hashCode() {
        int hashCode = ((this.eventType.hashCode() * 31) + this.deviceId.hashCode()) * 31;
        T t = this.content;
        return hashCode + (t == null ? 0 : t.hashCode());
    }

    public String toString() {
        return "StreamEvent(eventType=" + this.eventType + ", deviceId=" + this.deviceId + ", content=" + this.content + ')';
    }

    public StreamEvent(StreamEventType streamEventType, String str, T t) {
        Intrinsics.checkNotNullParameter(streamEventType, "eventType");
        Intrinsics.checkNotNullParameter(str, DeviceDataEntity.DEVICE_ID);
        this.eventType = streamEventType;
        this.deviceId = str;
        this.content = t;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ StreamEvent(StreamEventType streamEventType, String str, Object obj, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(streamEventType, str, (i & 4) != 0 ? null : obj);
    }

    public final StreamEventType getEventType() {
        return this.eventType;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final T getContent() {
        return this.content;
    }

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u000f\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00110\u00102\u0006\u0010\u0012\u001a\u00020\u0013J \u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00150\u0011\"\u0004\b\u0001\u0010\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00150\u0017J \u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00150\u0011\"\u0004\b\u0001\u0010\u00152\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00150\u001aR\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u000e¢\u0006\u0002\n\u0000R!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006\u001b"}, d2 = {"Lcom/blueair/livestream/StreamEvent$Companion;", "", "<init>", "()V", "updateProgress", "", "", "", "alarmSerializer", "Lcom/blueair/core/util/MoshiSerializer;", "Lcom/blueair/core/model/DeviceAlarm;", "getAlarmSerializer", "()Lcom/blueair/core/util/MoshiSerializer;", "alarmSerializer$delegate", "Lkotlin/Lazy;", "fromMqtt", "", "Lcom/blueair/livestream/StreamEvent;", "mqttEvent", "Lio/flatcircle/mqtt/MqttEvent;", "fromStomp", "T", "stompEvent", "Lio/flatcircle/stomp/StompEvent;", "fromBle", "bleEvent", "Lio/flatcircle/ble/BleEvent;", "livestream_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: StreamEvent.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        private final MoshiSerializer<DeviceAlarm> getAlarmSerializer() {
            return (MoshiSerializer) StreamEvent.alarmSerializer$delegate.getValue();
        }

        public final List<StreamEvent<?>> fromMqtt(MqttEvent mqttEvent) {
            Integer sensormode;
            Boolean waterinfill;
            Boolean hourformat;
            Integer humsubmode;
            Integer nlstepless;
            Integer ywrmusage;
            Boolean wickdrydone;
            Integer wickdrydur;
            Integer nlbrightness;
            Integer roomtype;
            Integer endts;
            Integer startts;
            Integer arts;
            Integer ardur;
            Integer arstate;
            Boolean airrefresh;
            Boolean hover;
            Integer displaymode;
            Integer aireta;
            Boolean bodymounted;
            Boolean detectcat;
            Integer smartsubmode;
            Boolean wtankfail;
            Boolean watertankfailure;
            Integer dehsubmode;
            Integer wlevel;
            Boolean hummode;
            Integer mode;
            Integer coolecotag;
            Integer coolautotag;
            Integer coolfs;
            Integer coolsubmode;
            Integer ecoheattemp;
            Integer heattemp;
            Integer heatfs;
            Integer heatsubmode;
            Integer fsp0;
            Integer apsubmode;
            Integer mainmode;
            Integer oscfs;
            Integer oscdir;
            Integer osc;
            Integer oscstate;
            Integer tu;
            Integer timl;
            Integer timdur;
            Integer timstate;
            Integer autorh;
            Boolean wshortage;
            Integer wickusage;
            Integer wickdryl;
            Boolean wickdrys;
            Boolean wickdrye;
            Integer disinftime;
            Boolean disinfection;
            Integer filterusage;
            Boolean safetyswitch;
            Boolean nmhins;
            Boolean hins;
            Boolean eco;
            Boolean standby;
            Boolean nightmode;
            Boolean gsnm;
            Boolean germshield;
            Integer brightness;
            Integer fanspeed;
            Boolean childlock;
            Boolean automode;
            ConnectivityStatus connectivityStatus;
            int i;
            Intrinsics.checkNotNullParameter(mqttEvent, "mqttEvent");
            if (mqttEvent instanceof MqttEvent.MqttDeviceEvent) {
                DeviceEvent deviceEvent = ((MqttEvent.MqttDeviceEvent) mqttEvent).getDeviceEvent();
                List<StreamEvent<?>> arrayList = new ArrayList<>();
                ConnectivityStatus connectivityStatus2 = null;
                String str = "";
                if (StringsKt.contains$default((CharSequence) deviceEvent.getConnectionEvent(), (CharSequence) "ImageProvision", false, 2, (Object) null)) {
                    Timber.Forest.v("fromMqtt: DEVICE_OTA StreamEvent", new Object[0]);
                    StreamEventType streamEventType = StreamEventType.DEVICE_OTA;
                    String origin = deviceEvent.getOrigin();
                    if (origin == null) {
                        origin = str;
                    }
                    String origin2 = deviceEvent.getOrigin();
                    if (origin2 != null) {
                        Map access$getUpdateProgress$cp = StreamEvent.updateProgress;
                        Integer num = (Integer) StreamEvent.updateProgress.get(origin2);
                        access$getUpdateProgress$cp.put(origin2, Integer.valueOf((num != null ? num.intValue() : 0) + 3));
                        Integer num2 = (Integer) StreamEvent.updateProgress.get(origin2);
                        if (num2 != null) {
                            i = num2.intValue();
                            arrayList.add(new StreamEvent(streamEventType, origin, Integer.valueOf(Math.min(99, i))));
                        }
                    }
                    i = 0;
                    arrayList.add(new StreamEvent(streamEventType, origin, Integer.valueOf(Math.min(99, i))));
                }
                ConnectedState fromName = ConnectedState.Companion.fromName(deviceEvent.getConnectionEvent());
                if (Intrinsics.areEqual((Object) fromName, (Object) ConnectedState.Connected.INSTANCE)) {
                    connectivityStatus2 = ConnectivityStatus.ONLINE;
                } else if (Intrinsics.areEqual((Object) fromName, (Object) ConnectedState.NotConnected.INSTANCE)) {
                    connectivityStatus2 = ConnectivityStatus.OFFLINE;
                }
                if (connectivityStatus2 != null) {
                    String originDeviceId = deviceEvent.getOriginDeviceId();
                    if (originDeviceId != null) {
                        StreamEvent.updateProgress.put(originDeviceId, 0);
                        Unit unit = Unit.INSTANCE;
                        Unit unit2 = Unit.INSTANCE;
                    }
                    Timber.Forest.v("fromMqtt: ConnectivityStatus event with connectivityStatus " + connectivityStatus2, new Object[0]);
                    StreamEventType streamEventType2 = StreamEventType.DEVICE_ATTRIBUTE;
                    String originDeviceId2 = deviceEvent.getOriginDeviceId();
                    if (originDeviceId2 != null) {
                        str = originDeviceId2;
                    }
                    Boolean.valueOf(arrayList.add(new StreamEvent(streamEventType2, str, new DeviceStreamAttribute.ConnectivityStatus(connectivityStatus2.ordinal()))));
                }
                return arrayList;
            } else if (mqttEvent instanceof MqttEvent.MqttSensorEvent) {
                MqttEvent.MqttSensorEvent mqttSensorEvent = (MqttEvent.MqttSensorEvent) mqttEvent;
                IndoorDatapoint indoorDatapoint = SensorDataKt.toIndoorDatapoint(mqttSensorEvent.getSensorEvents());
                if (indoorDatapoint == null) {
                    return CollectionsKt.emptyList();
                }
                return CollectionsKt.listOf(new StreamEvent(StreamEventType.DEVICE_ATTRIBUTE, mqttSensorEvent.getDeviceId(), new DeviceStreamAttribute.LatestSensorDataPoint(indoorDatapoint)));
            } else if (mqttEvent instanceof MqttEvent.MqttConnectivityEvent) {
                MqttEvent.MqttConnectivityEvent mqttConnectivityEvent = (MqttEvent.MqttConnectivityEvent) mqttEvent;
                if (mqttConnectivityEvent.isOnline()) {
                    connectivityStatus = ConnectivityStatus.ONLINE;
                } else {
                    connectivityStatus = ConnectivityStatus.OFFLINE;
                }
                return CollectionsKt.listOf(new StreamEvent(StreamEventType.DEVICE_ATTRIBUTE, mqttConnectivityEvent.getDeviceId(), new DeviceStreamAttribute.ConnectivityStatus(connectivityStatus.ordinal())));
            } else if (mqttEvent instanceof MqttEvent.MqttStateEvent) {
                List<StreamEvent<?>> arrayList2 = new ArrayList<>();
                MqttEvent.MqttStateEvent mqttStateEvent = (MqttEvent.MqttStateEvent) mqttEvent;
                DeviceState reported = mqttStateEvent.getSensorStateBundle().getCurrent().getState().getReported();
                DeviceState reported2 = mqttStateEvent.getSensorStateBundle().getPrevious().getState().getReported();
                Timber.Forest.d("fromMqtt: curReported =  " + reported + "  & prevReported = " + reported2, new Object[0]);
                if (!Intrinsics.areEqual((Object) reported.getAutomode(), (Object) reported2.getAutomode()) && (automode = reported.getAutomode()) != null) {
                    fromMqtt$addDeviceStreamAttributeEvent(arrayList2, mqttEvent, new DeviceStreamAttribute.AutoMode(AutoMode.Companion.fromBoolean(automode.booleanValue()).toText()));
                    Unit unit3 = Unit.INSTANCE;
                    Unit unit4 = Unit.INSTANCE;
                }
                if (!Intrinsics.areEqual((Object) reported.getChildlock(), (Object) reported2.getChildlock()) && (childlock = reported.getChildlock()) != null) {
                    fromMqtt$addDeviceStreamAttributeEvent(arrayList2, mqttEvent, new DeviceStreamAttribute.ChildLock(childlock.booleanValue()));
                    Unit unit5 = Unit.INSTANCE;
                    Unit unit6 = Unit.INSTANCE;
                }
                if (!Intrinsics.areEqual((Object) reported.getFanspeed(), (Object) reported2.getFanspeed()) && (fanspeed = reported.getFanspeed()) != null) {
                    fromMqtt$addDeviceStreamAttributeEvent(arrayList2, mqttEvent, new DeviceStreamAttribute.FanSpeedManualOrAuto(fanspeed.intValue()));
                    Unit unit7 = Unit.INSTANCE;
                    Unit unit8 = Unit.INSTANCE;
                }
                if (!Intrinsics.areEqual((Object) reported.getBrightness(), (Object) reported2.getBrightness()) && (brightness = reported.getBrightness()) != null) {
                    fromMqtt$addDeviceStreamAttributeEvent(arrayList2, mqttEvent, new DeviceStreamAttribute.Brightness(brightness.intValue()));
                    Unit unit9 = Unit.INSTANCE;
                    Unit unit10 = Unit.INSTANCE;
                }
                if (!Intrinsics.areEqual((Object) reported.getGermshield(), (Object) reported2.getGermshield()) && (germshield = reported.getGermshield()) != null) {
                    fromMqtt$addDeviceStreamAttributeEvent(arrayList2, mqttEvent, new DeviceStreamAttribute.GermShield(germshield.booleanValue()));
                    Unit unit11 = Unit.INSTANCE;
                    Unit unit12 = Unit.INSTANCE;
                }
                if (!Intrinsics.areEqual((Object) reported.getGsnm(), (Object) reported2.getGsnm()) && (gsnm = reported.getGsnm()) != null) {
                    fromMqtt$addDeviceStreamAttributeEvent(arrayList2, mqttEvent, new DeviceStreamAttribute.GermShieldNight(gsnm.booleanValue()));
                    Unit unit13 = Unit.INSTANCE;
                    Unit unit14 = Unit.INSTANCE;
                }
                if (!Intrinsics.areEqual((Object) reported.getNightmode(), (Object) reported2.getNightmode()) && (nightmode = reported.getNightmode()) != null) {
                    fromMqtt$addDeviceStreamAttributeEvent(arrayList2, mqttEvent, new DeviceStreamAttribute.G4NightMode(nightmode.booleanValue()));
                    Unit unit15 = Unit.INSTANCE;
                    Unit unit16 = Unit.INSTANCE;
                }
                if (!Intrinsics.areEqual((Object) reported.getStandby(), (Object) reported2.getStandby()) && (standby = reported.getStandby()) != null) {
                    fromMqtt$addDeviceStreamAttributeEvent(arrayList2, mqttEvent, new DeviceStreamAttribute.StandByMode(standby.booleanValue()));
                    Unit unit17 = Unit.INSTANCE;
                    Unit unit18 = Unit.INSTANCE;
                }
                if (!Intrinsics.areEqual((Object) reported.getEco(), (Object) reported2.getEco()) && (eco = reported.getEco()) != null) {
                    fromMqtt$addDeviceStreamAttributeEvent(arrayList2, mqttEvent, new DeviceStreamAttribute.EcoMode(eco.booleanValue()));
                    Unit unit19 = Unit.INSTANCE;
                    Unit unit20 = Unit.INSTANCE;
                }
                if (!Intrinsics.areEqual((Object) reported.getHins(), (Object) reported2.getHins()) && (hins = reported.getHins()) != null) {
                    fromMqtt$addDeviceStreamAttributeEvent(arrayList2, mqttEvent, new DeviceStreamAttribute.HinsMode(hins.booleanValue()));
                    Unit unit21 = Unit.INSTANCE;
                    Unit unit22 = Unit.INSTANCE;
                }
                if (!Intrinsics.areEqual((Object) reported.getNmhins(), (Object) reported2.getNmhins()) && (nmhins = reported.getNmhins()) != null) {
                    fromMqtt$addDeviceStreamAttributeEvent(arrayList2, mqttEvent, new DeviceStreamAttribute.HinsNightMode(nmhins.booleanValue()));
                    Unit unit23 = Unit.INSTANCE;
                    Unit unit24 = Unit.INSTANCE;
                }
                if (!Intrinsics.areEqual((Object) reported.getSafetyswitch(), (Object) reported2.getSafetyswitch()) && (safetyswitch = reported.getSafetyswitch()) != null) {
                    fromMqtt$addDeviceStreamAttributeEvent(arrayList2, mqttEvent, new DeviceStreamAttribute.SafetySwitch(safetyswitch.booleanValue()));
                    Unit unit25 = Unit.INSTANCE;
                    Unit unit26 = Unit.INSTANCE;
                }
                if (!Intrinsics.areEqual((Object) reported.getFilterusage(), (Object) reported2.getFilterusage()) && (filterusage = reported.getFilterusage()) != null) {
                    fromMqtt$addDeviceStreamAttributeEvent(arrayList2, mqttEvent, new DeviceStreamAttribute.FilterUsage(filterusage.intValue()));
                    Unit unit27 = Unit.INSTANCE;
                    Unit unit28 = Unit.INSTANCE;
                }
                if (!Intrinsics.areEqual((Object) reported.getDisinfection(), (Object) reported2.getDisinfection()) && (disinfection = reported.getDisinfection()) != null) {
                    fromMqtt$addDeviceStreamAttributeEvent(arrayList2, mqttEvent, new DeviceStreamAttribute.Disinfection(disinfection.booleanValue()));
                    Unit unit29 = Unit.INSTANCE;
                    Unit unit30 = Unit.INSTANCE;
                }
                if (!Intrinsics.areEqual((Object) reported.getDisinftime(), (Object) reported2.getDisinftime()) && (disinftime = reported.getDisinftime()) != null) {
                    fromMqtt$addDeviceStreamAttributeEvent(arrayList2, mqttEvent, new DeviceStreamAttribute.DisinfectLeftTime(new Pair(Integer.valueOf(disinftime.intValue()), Long.valueOf(mqttStateEvent.getSensorStateBundle().getTimestamp()))));
                    Unit unit31 = Unit.INSTANCE;
                    Unit unit32 = Unit.INSTANCE;
                }
                if (!Intrinsics.areEqual((Object) reported.getWickdrye(), (Object) reported2.getWickdrye()) && (wickdrye = reported.getWickdrye()) != null) {
                    fromMqtt$addDeviceStreamAttributeEvent(arrayList2, mqttEvent, new DeviceStreamAttribute.WickdryEnabled(wickdrye.booleanValue()));
                    Unit unit33 = Unit.INSTANCE;
                    Unit unit34 = Unit.INSTANCE;
                }
                if (!Intrinsics.areEqual((Object) reported.getWickdrys(), (Object) reported2.getWickdrys()) && (wickdrys = reported.getWickdrys()) != null) {
                    fromMqtt$addDeviceStreamAttributeEvent(arrayList2, mqttEvent, new DeviceStreamAttribute.WickdryOn(wickdrys.booleanValue()));
                    Unit unit35 = Unit.INSTANCE;
                    Unit unit36 = Unit.INSTANCE;
                }
                if ((!Intrinsics.areEqual((Object) reported.getWickdryl(), (Object) reported2.getWickdryl()) || !Intrinsics.areEqual((Object) reported.getWickdryts(), (Object) reported2.getWickdryts())) && (wickdryl = reported.getWickdryl()) != null) {
                    int intValue = wickdryl.intValue();
                    Integer wickdryts = reported.getWickdryts();
                    fromMqtt$addDeviceStreamAttributeEvent(arrayList2, mqttEvent, new DeviceStreamAttribute.WickdryLeftTime(new Pair(Integer.valueOf(intValue), Long.valueOf(wickdryts != null ? (long) wickdryts.intValue() : mqttStateEvent.getSensorStateBundle().getTimestamp()))));
                    Unit unit37 = Unit.INSTANCE;
                    Unit unit38 = Unit.INSTANCE;
                }
                if (!Intrinsics.areEqual((Object) reported.getWickusage(), (Object) reported2.getWickusage()) && (wickusage = reported.getWickusage()) != null) {
                    fromMqtt$addDeviceStreamAttributeEvent(arrayList2, mqttEvent, new DeviceStreamAttribute.WickUsage(wickusage.intValue()));
                    Unit unit39 = Unit.INSTANCE;
                    Unit unit40 = Unit.INSTANCE;
                }
                if (!Intrinsics.areEqual((Object) reported.getWshortage(), (Object) reported2.getWshortage()) && (wshortage = reported.getWshortage()) != null) {
                    fromMqtt$addDeviceStreamAttributeEvent(arrayList2, mqttEvent, new DeviceStreamAttribute.WaterShortage(wshortage.booleanValue()));
                    Unit unit41 = Unit.INSTANCE;
                    Unit unit42 = Unit.INSTANCE;
                }
                if (!Intrinsics.areEqual((Object) reported.getAutorh(), (Object) reported2.getAutorh()) && (autorh = reported.getAutorh()) != null) {
                    fromMqtt$addDeviceStreamAttributeEvent(arrayList2, mqttEvent, new DeviceStreamAttribute.AutoRh(autorh.intValue()));
                    Unit unit43 = Unit.INSTANCE;
                    Unit unit44 = Unit.INSTANCE;
                }
                if (!Intrinsics.areEqual((Object) reported.getTimstate(), (Object) reported2.getTimstate()) && (timstate = reported.getTimstate()) != null) {
                    fromMqtt$addDeviceStreamAttributeEvent(arrayList2, mqttEvent, new DeviceStreamAttribute.TimerStatus(timstate.intValue()));
                    Unit unit45 = Unit.INSTANCE;
                    Unit unit46 = Unit.INSTANCE;
                }
                if (!Intrinsics.areEqual((Object) reported.getTimdur(), (Object) reported2.getTimdur()) && (timdur = reported.getTimdur()) != null) {
                    fromMqtt$addDeviceStreamAttributeEvent(arrayList2, mqttEvent, new DeviceStreamAttribute.TimerDuration(timdur.intValue()));
                    Unit unit47 = Unit.INSTANCE;
                    Unit unit48 = Unit.INSTANCE;
                }
                if ((!Intrinsics.areEqual((Object) reported.getTiml(), (Object) reported2.getTiml()) || !Intrinsics.areEqual((Object) reported.getTimts(), (Object) reported2.getTimts())) && (timl = reported.getTiml()) != null) {
                    int intValue2 = timl.intValue();
                    Integer timts = reported.getTimts();
                    fromMqtt$addDeviceStreamAttributeEvent(arrayList2, mqttEvent, new DeviceStreamAttribute.TimerLeftTime(new Pair(Integer.valueOf(intValue2), Long.valueOf(timts != null ? (long) timts.intValue() : mqttStateEvent.getSensorStateBundle().getTimestamp()))));
                    Unit unit49 = Unit.INSTANCE;
                    Unit unit50 = Unit.INSTANCE;
                }
                if (!Intrinsics.areEqual((Object) reported.getTu(), (Object) reported2.getTu()) && (tu = reported.getTu()) != null) {
                    fromMqtt$addDeviceStreamAttributeEvent(arrayList2, mqttEvent, new DeviceStreamAttribute.TemperatureUnit(tu.intValue()));
                    Unit unit51 = Unit.INSTANCE;
                    Unit unit52 = Unit.INSTANCE;
                }
                if (!Intrinsics.areEqual((Object) reported.getOscstate(), (Object) reported2.getOscstate()) && (oscstate = reported.getOscstate()) != null) {
                    fromMqtt$addDeviceStreamAttributeEvent(arrayList2, mqttEvent, new DeviceStreamAttribute.OscillationState(oscstate.intValue()));
                    Unit unit53 = Unit.INSTANCE;
                    Unit unit54 = Unit.INSTANCE;
                }
                if (!Intrinsics.areEqual((Object) reported.getOsc(), (Object) reported2.getOsc()) && (osc = reported.getOsc()) != null) {
                    fromMqtt$addDeviceStreamAttributeEvent(arrayList2, mqttEvent, new DeviceStreamAttribute.OscillationAngle(osc.intValue()));
                    Unit unit55 = Unit.INSTANCE;
                    Unit unit56 = Unit.INSTANCE;
                }
                if (!Intrinsics.areEqual((Object) reported.getOscdir(), (Object) reported2.getOscdir()) && (oscdir = reported.getOscdir()) != null) {
                    fromMqtt$addDeviceStreamAttributeEvent(arrayList2, mqttEvent, new DeviceStreamAttribute.OscillationDirection(oscdir.intValue()));
                    Unit unit57 = Unit.INSTANCE;
                    Unit unit58 = Unit.INSTANCE;
                }
                if (!Intrinsics.areEqual((Object) reported.getOscfs(), (Object) reported2.getOscfs()) && (oscfs = reported.getOscfs()) != null) {
                    fromMqtt$addDeviceStreamAttributeEvent(arrayList2, mqttEvent, new DeviceStreamAttribute.OscillationFanSpeed(oscfs.intValue()));
                    Unit unit59 = Unit.INSTANCE;
                    Unit unit60 = Unit.INSTANCE;
                }
                if (!Intrinsics.areEqual((Object) reported.getMainmode(), (Object) reported2.getMainmode()) && (mainmode = reported.getMainmode()) != null) {
                    fromMqtt$addDeviceStreamAttributeEvent(arrayList2, mqttEvent, new DeviceStreamAttribute.MainMode(mainmode.intValue()));
                    Unit unit61 = Unit.INSTANCE;
                    Unit unit62 = Unit.INSTANCE;
                }
                if (!Intrinsics.areEqual((Object) reported.getApsubmode(), (Object) reported2.getApsubmode()) && (apsubmode = reported.getApsubmode()) != null) {
                    fromMqtt$addDeviceStreamAttributeEvent(arrayList2, mqttEvent, new DeviceStreamAttribute.ApSubMode(apsubmode.intValue()));
                    Unit unit63 = Unit.INSTANCE;
                    Unit unit64 = Unit.INSTANCE;
                }
                if (!Intrinsics.areEqual((Object) reported.getFsp0(), (Object) reported2.getFsp0()) && (fsp0 = reported.getFsp0()) != null) {
                    fromMqtt$addDeviceStreamAttributeEvent(arrayList2, mqttEvent, new DeviceStreamAttribute.ApFanSpeed(fsp0.intValue()));
                    Unit unit65 = Unit.INSTANCE;
                    Unit unit66 = Unit.INSTANCE;
                }
                if (!Intrinsics.areEqual((Object) reported.getHeatsubmode(), (Object) reported2.getHeatsubmode()) && (heatsubmode = reported.getHeatsubmode()) != null) {
                    fromMqtt$addDeviceStreamAttributeEvent(arrayList2, mqttEvent, new DeviceStreamAttribute.HeatSubMode(heatsubmode.intValue()));
                    Unit unit67 = Unit.INSTANCE;
                    Unit unit68 = Unit.INSTANCE;
                }
                if (!Intrinsics.areEqual((Object) reported.getHeatfs(), (Object) reported2.getHeatfs()) && (heatfs = reported.getHeatfs()) != null) {
                    fromMqtt$addDeviceStreamAttributeEvent(arrayList2, mqttEvent, new DeviceStreamAttribute.HeatFanSpeed(heatfs.intValue()));
                    Unit unit69 = Unit.INSTANCE;
                    Unit unit70 = Unit.INSTANCE;
                }
                if (!Intrinsics.areEqual((Object) reported.getHeattemp(), (Object) reported2.getHeattemp()) && (heattemp = reported.getHeattemp()) != null) {
                    fromMqtt$addDeviceStreamAttributeEvent(arrayList2, mqttEvent, new DeviceStreamAttribute.HeatAutoTmp(DeviceData.Companion.fromServerValue(heattemp.intValue())));
                    Unit unit71 = Unit.INSTANCE;
                    Unit unit72 = Unit.INSTANCE;
                }
                if (!Intrinsics.areEqual((Object) reported.getEcoheattemp(), (Object) reported2.getEcoheattemp()) && (ecoheattemp = reported.getEcoheattemp()) != null) {
                    fromMqtt$addDeviceStreamAttributeEvent(arrayList2, mqttEvent, new DeviceStreamAttribute.HeatEcoTmp(DeviceData.Companion.fromServerValue(ecoheattemp.intValue())));
                    Unit unit73 = Unit.INSTANCE;
                    Unit unit74 = Unit.INSTANCE;
                }
                if (!Intrinsics.areEqual((Object) reported.getCoolsubmode(), (Object) reported2.getCoolsubmode()) && (coolsubmode = reported.getCoolsubmode()) != null) {
                    fromMqtt$addDeviceStreamAttributeEvent(arrayList2, mqttEvent, new DeviceStreamAttribute.CoolSubMode(coolsubmode.intValue()));
                    Unit unit75 = Unit.INSTANCE;
                    Unit unit76 = Unit.INSTANCE;
                }
                if (!Intrinsics.areEqual((Object) reported.getCoolfs(), (Object) reported2.getCoolfs()) && (coolfs = reported.getCoolfs()) != null) {
                    fromMqtt$addDeviceStreamAttributeEvent(arrayList2, mqttEvent, new DeviceStreamAttribute.CoolFanSpeed(coolfs.intValue()));
                    Unit unit77 = Unit.INSTANCE;
                    Unit unit78 = Unit.INSTANCE;
                }
                if (!Intrinsics.areEqual((Object) reported.getCoolautotag(), (Object) reported2.getCoolautotag()) && (coolautotag = reported.getCoolautotag()) != null) {
                    fromMqtt$addDeviceStreamAttributeEvent(arrayList2, mqttEvent, new DeviceStreamAttribute.CoolAutoTag(coolautotag.intValue()));
                    Unit unit79 = Unit.INSTANCE;
                    Unit unit80 = Unit.INSTANCE;
                }
                if (!Intrinsics.areEqual((Object) reported.getCoolautofs1(), (Object) reported2.getCoolautofs1()) || !Intrinsics.areEqual((Object) reported.getCoolautofs2(), (Object) reported2.getCoolautofs2()) || !Intrinsics.areEqual((Object) reported.getCoolautofs3(), (Object) reported2.getCoolautofs3())) {
                    Iterable<Number> listOfNotNull = CollectionsKt.listOfNotNull((T[]) new Integer[]{reported.getCoolautofs1(), reported.getCoolautofs2(), reported.getCoolautofs3()});
                    Collection arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listOfNotNull, 10));
                    for (Number intValue3 : listOfNotNull) {
                        arrayList3.add(Double.valueOf(DeviceData.Companion.fromServerValue(intValue3.intValue())));
                    }
                    fromMqtt$addDeviceStreamAttributeEvent(arrayList2, mqttEvent, new DeviceStreamAttribute.CoolAutoPresets(CollectionsKt.toDoubleArray((List) arrayList3)));
                    Unit unit81 = Unit.INSTANCE;
                }
                if (!Intrinsics.areEqual((Object) reported.getCoolecotag(), (Object) reported2.getCoolecotag()) && (coolecotag = reported.getCoolecotag()) != null) {
                    fromMqtt$addDeviceStreamAttributeEvent(arrayList2, mqttEvent, new DeviceStreamAttribute.CoolEcoTag(coolecotag.intValue()));
                    Unit unit82 = Unit.INSTANCE;
                    Unit unit83 = Unit.INSTANCE;
                }
                if (!Intrinsics.areEqual((Object) reported.getCoolecofs1(), (Object) reported2.getCoolecofs1()) || !Intrinsics.areEqual((Object) reported.getCoolecofs2(), (Object) reported2.getCoolecofs2())) {
                    Iterable<Number> listOfNotNull2 = CollectionsKt.listOfNotNull((T[]) new Integer[]{reported.getCoolecofs1(), reported.getCoolecofs2()});
                    Collection arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listOfNotNull2, 10));
                    for (Number intValue4 : listOfNotNull2) {
                        arrayList4.add(Double.valueOf(DeviceData.Companion.fromServerValue(intValue4.intValue())));
                    }
                    fromMqtt$addDeviceStreamAttributeEvent(arrayList2, mqttEvent, new DeviceStreamAttribute.CoolEcoPresets(CollectionsKt.toDoubleArray((List) arrayList4)));
                    Unit unit84 = Unit.INSTANCE;
                }
                if (!Intrinsics.areEqual((Object) reported.getMode(), (Object) reported2.getMode()) && (mode = reported.getMode()) != null) {
                    fromMqtt$addDeviceStreamAttributeEvent(arrayList2, mqttEvent, new DeviceStreamAttribute.Mode(mode.intValue()));
                    Unit unit85 = Unit.INSTANCE;
                    Unit unit86 = Unit.INSTANCE;
                }
                if (!Intrinsics.areEqual((Object) reported.getHummode(), (Object) reported2.getHummode()) && (hummode = reported.getHummode()) != null) {
                    fromMqtt$addDeviceStreamAttributeEvent(arrayList2, mqttEvent, new DeviceStreamAttribute.HumMode(hummode.booleanValue()));
                    Unit unit87 = Unit.INSTANCE;
                    Unit unit88 = Unit.INSTANCE;
                }
                if (!Intrinsics.areEqual((Object) reported.getWlevel(), (Object) reported2.getWlevel()) && (wlevel = reported.getWlevel()) != null) {
                    fromMqtt$addDeviceStreamAttributeEvent(arrayList2, mqttEvent, new DeviceStreamAttribute.WaterLevel(wlevel.intValue()));
                    Unit unit89 = Unit.INSTANCE;
                    Unit unit90 = Unit.INSTANCE;
                }
                if (!Intrinsics.areEqual((Object) reported.getDehsubmode(), (Object) reported2.getDehsubmode()) && (dehsubmode = reported.getDehsubmode()) != null) {
                    fromMqtt$addDeviceStreamAttributeEvent(arrayList2, mqttEvent, new DeviceStreamAttribute.DehSubMode(dehsubmode.intValue()));
                    Unit unit91 = Unit.INSTANCE;
                    Unit unit92 = Unit.INSTANCE;
                }
                if (!Intrinsics.areEqual((Object) reported.getWatertankfailure(), (Object) reported2.getWatertankfailure()) && (watertankfailure = reported.getWatertankfailure()) != null) {
                    fromMqtt$addDeviceStreamAttributeEvent(arrayList2, mqttEvent, new DeviceStreamAttribute.WaterTankFailure(watertankfailure.booleanValue()));
                    Unit unit93 = Unit.INSTANCE;
                    Unit unit94 = Unit.INSTANCE;
                }
                if (!Intrinsics.areEqual((Object) reported.getWtankfail(), (Object) reported2.getWtankfail()) && (wtankfail = reported.getWtankfail()) != null) {
                    fromMqtt$addDeviceStreamAttributeEvent(arrayList2, mqttEvent, new DeviceStreamAttribute.WaterTankFailure(wtankfail.booleanValue()));
                    Unit unit95 = Unit.INSTANCE;
                    Unit unit96 = Unit.INSTANCE;
                }
                if (!Intrinsics.areEqual((Object) reported.getSmartsubmode(), (Object) reported2.getSmartsubmode()) && (smartsubmode = reported.getSmartsubmode()) != null) {
                    fromMqtt$addDeviceStreamAttributeEvent(arrayList2, mqttEvent, new DeviceStreamAttribute.SmartSubMode(smartsubmode.intValue()));
                    Unit unit97 = Unit.INSTANCE;
                    Unit unit98 = Unit.INSTANCE;
                }
                if (!Intrinsics.areEqual((Object) reported.getDetectcat(), (Object) reported2.getDetectcat()) && (detectcat = reported.getDetectcat()) != null) {
                    fromMqtt$addDeviceStreamAttributeEvent(arrayList2, mqttEvent, new DeviceStreamAttribute.DetectCat(detectcat.booleanValue()));
                    Unit unit99 = Unit.INSTANCE;
                    Unit unit100 = Unit.INSTANCE;
                }
                if (!Intrinsics.areEqual((Object) reported.getBodymounted(), (Object) reported2.getBodymounted()) && (bodymounted = reported.getBodymounted()) != null) {
                    fromMqtt$addDeviceStreamAttributeEvent(arrayList2, mqttEvent, new DeviceStreamAttribute.BodyMounted(bodymounted.booleanValue()));
                    Unit unit101 = Unit.INSTANCE;
                    Unit unit102 = Unit.INSTANCE;
                }
                if (!Intrinsics.areEqual((Object) reported.getAireta(), (Object) reported2.getAireta()) && (aireta = reported.getAireta()) != null) {
                    fromMqtt$addDeviceStreamAttributeEvent(arrayList2, mqttEvent, new DeviceStreamAttribute.CleanAirEta(aireta.intValue()));
                    Unit unit103 = Unit.INSTANCE;
                    Unit unit104 = Unit.INSTANCE;
                }
                if (!Intrinsics.areEqual((Object) reported.getDisplaymode(), (Object) reported2.getDisplaymode()) && (displaymode = reported.getDisplaymode()) != null) {
                    fromMqtt$addDeviceStreamAttributeEvent(arrayList2, mqttEvent, new DeviceStreamAttribute.PanelDisplayMode(displaymode.intValue()));
                    Unit unit105 = Unit.INSTANCE;
                    Unit unit106 = Unit.INSTANCE;
                }
                if (!Intrinsics.areEqual((Object) reported.getHover(), (Object) reported2.getHover()) && (hover = reported.getHover()) != null) {
                    fromMqtt$addDeviceStreamAttributeEvent(arrayList2, mqttEvent, new DeviceStreamAttribute.HoverEnabled(hover.booleanValue()));
                    Unit unit107 = Unit.INSTANCE;
                    Unit unit108 = Unit.INSTANCE;
                }
                if (!Intrinsics.areEqual((Object) reported.getAirrefresh(), (Object) reported2.getAirrefresh()) && (airrefresh = reported.getAirrefresh()) != null) {
                    fromMqtt$addDeviceStreamAttributeEvent(arrayList2, mqttEvent, new DeviceStreamAttribute.AirRefreshEnabled(airrefresh.booleanValue()));
                    Unit unit109 = Unit.INSTANCE;
                    Unit unit110 = Unit.INSTANCE;
                }
                if (!Intrinsics.areEqual((Object) reported.getArstate(), (Object) reported2.getArstate()) && (arstate = reported.getArstate()) != null) {
                    fromMqtt$addDeviceStreamAttributeEvent(arrayList2, mqttEvent, new DeviceStreamAttribute.AirRefreshStatus(arstate.intValue()));
                    Unit unit111 = Unit.INSTANCE;
                    Unit unit112 = Unit.INSTANCE;
                }
                if (!Intrinsics.areEqual((Object) reported.getArdur(), (Object) reported2.getArdur()) && (ardur = reported.getArdur()) != null) {
                    fromMqtt$addDeviceStreamAttributeEvent(arrayList2, mqttEvent, new DeviceStreamAttribute.AirRefreshDuration(ardur.intValue()));
                    Unit unit113 = Unit.INSTANCE;
                    Unit unit114 = Unit.INSTANCE;
                }
                if (!Intrinsics.areEqual((Object) reported.getArts(), (Object) reported2.getArts()) && (arts = reported.getArts()) != null) {
                    fromMqtt$addDeviceStreamAttributeEvent(arrayList2, mqttEvent, new DeviceStreamAttribute.AirRefreshTimeStamp(arts.intValue()));
                    Unit unit115 = Unit.INSTANCE;
                    Unit unit116 = Unit.INSTANCE;
                }
                if (!Intrinsics.areEqual((Object) reported.getStartts(), (Object) reported2.getStartts()) && (startts = reported.getStartts()) != null) {
                    fromMqtt$addDeviceStreamAttributeEvent(arrayList2, mqttEvent, new DeviceStreamAttribute.AirRefreshStartTimeStamp(startts.intValue()));
                    Unit unit117 = Unit.INSTANCE;
                    Unit unit118 = Unit.INSTANCE;
                }
                if (!Intrinsics.areEqual((Object) reported.getEndts(), (Object) reported2.getEndts()) && (endts = reported.getEndts()) != null) {
                    fromMqtt$addDeviceStreamAttributeEvent(arrayList2, mqttEvent, new DeviceStreamAttribute.AirRefreshEndTimeStamp(endts.intValue()));
                    Unit unit119 = Unit.INSTANCE;
                    Unit unit120 = Unit.INSTANCE;
                }
                if (!Intrinsics.areEqual((Object) reported.getRoomtype(), (Object) reported2.getRoomtype()) && (roomtype = reported.getRoomtype()) != null) {
                    fromMqtt$addDeviceStreamAttributeEvent(arrayList2, mqttEvent, new DeviceStreamAttribute.RoomType(roomtype.intValue()));
                    Unit unit121 = Unit.INSTANCE;
                    Unit unit122 = Unit.INSTANCE;
                }
                if (!Intrinsics.areEqual((Object) reported.getNlbrightness(), (Object) reported2.getNlbrightness()) && (nlbrightness = reported.getNlbrightness()) != null) {
                    fromMqtt$addDeviceStreamAttributeEvent(arrayList2, mqttEvent, new DeviceStreamAttribute.NightLampBrightness(nlbrightness.intValue()));
                    Unit unit123 = Unit.INSTANCE;
                    Unit unit124 = Unit.INSTANCE;
                }
                if (!Intrinsics.areEqual((Object) reported.getWickdrydur(), (Object) reported2.getWickdrydur()) && (wickdrydur = reported.getWickdrydur()) != null) {
                    fromMqtt$addDeviceStreamAttributeEvent(arrayList2, mqttEvent, new DeviceStreamAttribute.WickdryDuration(wickdrydur.intValue()));
                    Unit unit125 = Unit.INSTANCE;
                    Unit unit126 = Unit.INSTANCE;
                }
                if (!Intrinsics.areEqual((Object) reported.getWickdrydone(), (Object) reported2.getWickdrydone()) && (wickdrydone = reported.getWickdrydone()) != null) {
                    fromMqtt$addDeviceStreamAttributeEvent(arrayList2, mqttEvent, new DeviceStreamAttribute.WickdryDone(wickdrydone.booleanValue()));
                    Unit unit127 = Unit.INSTANCE;
                    Unit unit128 = Unit.INSTANCE;
                }
                if (!Intrinsics.areEqual((Object) reported.getYwrme(), (Object) reported2.getYwrme())) {
                    fromMqtt$addDeviceStreamAttributeEvent(arrayList2, mqttEvent, new DeviceStreamAttribute.YwrmEnabled(reported.getYwrme()));
                }
                if (!Intrinsics.areEqual((Object) reported.getYwrmusage(), (Object) reported2.getYwrmusage()) && (ywrmusage = reported.getYwrmusage()) != null) {
                    fromMqtt$addDeviceStreamAttributeEvent(arrayList2, mqttEvent, new DeviceStreamAttribute.YwrmUsage(ywrmusage.intValue()));
                    Unit unit129 = Unit.INSTANCE;
                    Unit unit130 = Unit.INSTANCE;
                }
                if (!Intrinsics.areEqual((Object) reported.getNlstepless(), (Object) reported2.getNlstepless()) && (nlstepless = reported.getNlstepless()) != null) {
                    fromMqtt$addDeviceStreamAttributeEvent(arrayList2, mqttEvent, new DeviceStreamAttribute.NightLampSteplessBrightness(nlstepless.intValue()));
                    Unit unit131 = Unit.INSTANCE;
                    Unit unit132 = Unit.INSTANCE;
                }
                if (!Intrinsics.areEqual(reported.getAlarm1(), reported2.getAlarm1()) || !Intrinsics.areEqual(reported.getAlarm2(), reported2.getAlarm2()) || !Intrinsics.areEqual(reported.getAlarm3(), reported2.getAlarm3()) || !Intrinsics.areEqual(reported.getAlarm4(), reported2.getAlarm4()) || !Intrinsics.areEqual(reported.getAlarm5(), reported2.getAlarm5()) || !Intrinsics.areEqual(reported.getAlarm6(), reported2.getAlarm6())) {
                    fromMqtt$addDeviceStreamAttributeEvent(arrayList2, mqttEvent, new DeviceStreamAttribute.Alarms(CollectionsKt.listOf(fromMqtt$toAlarm(reported.getAlarm1()), fromMqtt$toAlarm(reported.getAlarm2()), fromMqtt$toAlarm(reported.getAlarm3()), fromMqtt$toAlarm(reported.getAlarm4()), fromMqtt$toAlarm(reported.getAlarm5()), fromMqtt$toAlarm(reported.getAlarm6()))));
                }
                if (!Intrinsics.areEqual((Object) reported.getHumsubmode(), (Object) reported2.getHumsubmode()) && (humsubmode = reported.getHumsubmode()) != null) {
                    fromMqtt$addDeviceStreamAttributeEvent(arrayList2, mqttEvent, new DeviceStreamAttribute.HumSubMode(humsubmode.intValue()));
                    Unit unit133 = Unit.INSTANCE;
                    Unit unit134 = Unit.INSTANCE;
                }
                if (!Intrinsics.areEqual((Object) reported.getHourformat(), (Object) reported2.getHourformat()) && (hourformat = reported.getHourformat()) != null) {
                    fromMqtt$addDeviceStreamAttributeEvent(arrayList2, mqttEvent, new DeviceStreamAttribute.Use24Hour(hourformat.booleanValue()));
                    Unit unit135 = Unit.INSTANCE;
                    Unit unit136 = Unit.INSTANCE;
                }
                if (!Intrinsics.areEqual((Object) reported.getWaterinfill(), (Object) reported2.getWaterinfill()) && (waterinfill = reported.getWaterinfill()) != null) {
                    fromMqtt$addDeviceStreamAttributeEvent(arrayList2, mqttEvent, new DeviceStreamAttribute.WaterInfill(waterinfill.booleanValue()));
                    Unit unit137 = Unit.INSTANCE;
                    Unit unit138 = Unit.INSTANCE;
                }
                if (!Intrinsics.areEqual((Object) reported.getSensormode(), (Object) reported2.getSensormode()) && (sensormode = reported.getSensormode()) != null) {
                    fromMqtt$addDeviceStreamAttributeEvent(arrayList2, mqttEvent, new DeviceStreamAttribute.SensorMode(sensormode.intValue()));
                    Unit unit139 = Unit.INSTANCE;
                    Unit unit140 = Unit.INSTANCE;
                }
                return arrayList2;
            } else if (mqttEvent instanceof MqttEvent.LogoutEvent) {
                return CollectionsKt.emptyList();
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }

        private static final void fromMqtt$addDeviceStreamAttributeEvent(List<StreamEvent<?>> list, MqttEvent mqttEvent, DeviceStreamAttribute<?> deviceStreamAttribute) {
            list.add(new StreamEvent(StreamEventType.DEVICE_ATTRIBUTE, ((MqttEvent.MqttStateEvent) mqttEvent).getDeviceId(), deviceStreamAttribute));
        }

        private static final DeviceAlarm fromMqtt$toAlarm(Object obj) {
            Object obj2;
            DeviceAlarm deviceAlarm = null;
            if (obj == null) {
                return null;
            }
            try {
                Result.Companion companion = Result.Companion;
                obj2 = Result.m9366constructorimpl(obj instanceof Map ? StreamEvent.Companion.getAlarmSerializer().fromMap((Map) obj) : null);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj2 = Result.m9366constructorimpl(ResultKt.createFailure(th));
            }
            if (!Result.m9372isFailureimpl(obj2)) {
                deviceAlarm = obj2;
            }
            return deviceAlarm;
        }

        public final <T> StreamEvent<T> fromStomp(StompEvent<T> stompEvent) {
            Pair pair;
            Intrinsics.checkNotNullParameter(stompEvent, "stompEvent");
            T content = stompEvent.getContent();
            Object obj = null;
            if (content instanceof ConnectivityStatus) {
                StreamEventType streamEventType = StreamEventType.DEVICE_ATTRIBUTE;
                T content2 = stompEvent.getContent();
                Intrinsics.checkNotNull(content2, "null cannot be cast to non-null type com.blueair.core.model.ConnectivityStatus");
                pair = TuplesKt.to(streamEventType, new DeviceStreamAttribute.ConnectivityStatus(((ConnectivityStatus) content2).ordinal()));
            } else if (content instanceof IndoorDatapoint) {
                StreamEventType streamEventType2 = StreamEventType.DEVICE_ATTRIBUTE;
                T content3 = stompEvent.getContent();
                Intrinsics.checkNotNull(content3, "null cannot be cast to non-null type com.blueair.core.model.IndoorDatapoint");
                pair = TuplesKt.to(streamEventType2, new DeviceStreamAttribute.LatestSensorDataPoint((IndoorDatapoint) content3));
            } else if (content instanceof DeviceStreamAttribute) {
                StreamEventType streamEventType3 = StreamEventType.DEVICE_ATTRIBUTE;
                T content4 = stompEvent.getContent();
                Intrinsics.checkNotNull(content4, "null cannot be cast to non-null type com.blueair.core.model.DeviceStreamAttribute<*>");
                pair = TuplesKt.to(streamEventType3, (DeviceStreamAttribute) content4);
            } else {
                pair = TuplesKt.to(StreamEventType.UNKNOWN, new DeviceStreamAttribute.Unknown(false, 1, (DefaultConstructorMarker) null));
            }
            StreamEventType streamEventType4 = (StreamEventType) pair.getFirst();
            String uuid = stompEvent.getUuid();
            Object second = pair.getSecond();
            if (second != null) {
                obj = second;
            }
            return new StreamEvent<>(streamEventType4, uuid, obj);
        }

        public final <T> StreamEvent<T> fromBle(BleEvent<T> bleEvent) {
            Pair pair;
            Intrinsics.checkNotNullParameter(bleEvent, "bleEvent");
            T content = bleEvent.getContent();
            Object obj = null;
            if (content instanceof ConnectivityStatus) {
                StreamEventType streamEventType = StreamEventType.DEVICE_ATTRIBUTE;
                T content2 = bleEvent.getContent();
                Intrinsics.checkNotNull(content2, "null cannot be cast to non-null type com.blueair.core.model.ConnectivityStatus");
                pair = TuplesKt.to(streamEventType, new DeviceStreamAttribute.ConnectivityStatus(((ConnectivityStatus) content2).ordinal()));
            } else if (content instanceof IndoorDatapoint) {
                StreamEventType streamEventType2 = StreamEventType.DEVICE_ATTRIBUTE;
                T content3 = bleEvent.getContent();
                Intrinsics.checkNotNull(content3, "null cannot be cast to non-null type com.blueair.core.model.IndoorDatapoint");
                pair = TuplesKt.to(streamEventType2, new DeviceStreamAttribute.LatestSensorDataPoint((IndoorDatapoint) content3));
            } else if (content instanceof DeviceStreamAttribute) {
                StreamEventType streamEventType3 = StreamEventType.DEVICE_ATTRIBUTE;
                T content4 = bleEvent.getContent();
                Intrinsics.checkNotNull(content4, "null cannot be cast to non-null type com.blueair.core.model.DeviceStreamAttribute<*>");
                pair = TuplesKt.to(streamEventType3, (DeviceStreamAttribute) content4);
            } else {
                pair = TuplesKt.to(StreamEventType.UNKNOWN, new DeviceStreamAttribute.Unknown(false, 1, (DefaultConstructorMarker) null));
            }
            StreamEventType streamEventType4 = (StreamEventType) pair.getFirst();
            String uuid = bleEvent.getUuid();
            Object second = pair.getSecond();
            if (second != null) {
                obj = second;
            }
            return new StreamEvent<>(streamEventType4, uuid, obj);
        }
    }

    /* access modifiers changed from: private */
    public static final MoshiSerializer alarmSerializer_delegate$lambda$0() {
        return new MoshiSerializer(DeviceAlarm.class, new Object[0]);
    }
}
