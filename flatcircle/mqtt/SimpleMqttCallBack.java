package io.flatcircle.mqtt;

import com.blueair.api.model.SensorData;
import com.blueair.core.model.ConnectedState;
import com.blueair.core.model.DeviceEvent;
import com.blueair.core.model.DeviceStateBundle;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory;
import io.flatcircle.mqtt.MqttEvent;
import java.lang.reflect.Type;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import timber.log.Timber;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lio/flatcircle/mqtt/SimpleMqttCallBack;", "Lorg/eclipse/paho/client/mqttv3/MqttCallback;", "mqttService", "Lio/flatcircle/mqtt/MqttService;", "messagePublisher", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lio/flatcircle/mqtt/MqttEvent;", "connectionLostListener", "Lkotlin/Function0;", "", "<init>", "(Lio/flatcircle/mqtt/MqttService;Lkotlinx/coroutines/flow/MutableSharedFlow;Lkotlin/jvm/functions/Function0;)V", "datedEventFilter", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "connectionLost", "throwable", "", "messageArrived", "topic", "mqttMessage", "Lorg/eclipse/paho/client/mqttv3/MqttMessage;", "deliveryComplete", "iMqttDeliveryToken", "Lorg/eclipse/paho/client/mqttv3/IMqttDeliveryToken;", "mqtt_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: MqttService.kt */
public final class SimpleMqttCallBack implements MqttCallback {
    private final Function0<Unit> connectionLostListener;
    private final ConcurrentHashMap<String, Long> datedEventFilter = new ConcurrentHashMap<>();
    private final MutableSharedFlow<MqttEvent> messagePublisher;
    private final MqttService mqttService;

    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
        Intrinsics.checkNotNullParameter(iMqttDeliveryToken, "iMqttDeliveryToken");
    }

    public SimpleMqttCallBack(MqttService mqttService2, MutableSharedFlow<MqttEvent> mutableSharedFlow, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(mqttService2, "mqttService");
        Intrinsics.checkNotNullParameter(mutableSharedFlow, "messagePublisher");
        Intrinsics.checkNotNullParameter(function0, "connectionLostListener");
        this.mqttService = mqttService2;
        this.messagePublisher = mutableSharedFlow;
        this.connectionLostListener = function0;
    }

    public void connectionLost(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "throwable");
        Timber.Forest forest = Timber.Forest;
        forest.w("Connection to MQTT broker lost, because of " + th, new Object[0]);
        this.connectionLostListener.invoke();
    }

    public void messageArrived(String str, MqttMessage mqttMessage) throws Exception {
        Object obj;
        Object obj2;
        List list;
        String value;
        String str2 = str;
        MqttMessage mqttMessage2 = mqttMessage;
        Intrinsics.checkNotNullParameter(str2, "topic");
        Intrinsics.checkNotNullParameter(mqttMessage2, "mqttMessage");
        Timber.Forest forest = Timber.Forest;
        int i = StringsKt.startsWith$default(str2, "$aws", false, 2, (Object) null) ? 3 : 2;
        forest.log(i, "topic=" + str2 + " ,messageArrived: json =\n" + mqttMessage2, new Object[0]);
        String str3 = "";
        if (StringsKt.startsWith$default(str2, "d", false, 2, (Object) null)) {
            MatchResult find$default = Regex.find$default(new Regex("(?<=/)(.*?)(?=/)"), str2, 0, 2, (Object) null);
            if (!(find$default == null || (value = find$default.getValue()) == null)) {
                str3 = value;
            }
            String mqttMessage3 = mqttMessage2.toString();
            Intrinsics.checkNotNullExpressionValue(mqttMessage3, "toString(...)");
            if (mqttMessage3.length() == 0) {
                list = CollectionsKt.emptyList();
            } else {
                JsonAdapter lenient = new Moshi.Builder().add((JsonAdapter.Factory) new KotlinJsonAdapterFactory()).build().adapter((Type) Types.newParameterizedType(List.class, SensorData.class)).lenient();
                Intrinsics.checkNotNullExpressionValue(lenient, "lenient(...)");
                list = (List) lenient.fromJson(mqttMessage3);
                if (list == null) {
                    list = CollectionsKt.emptyList();
                }
            }
            Timber.Forest forest2 = Timber.Forest;
            forest2.v("messageArrived: sensorEvents = \n\t" + list, new Object[0]);
            this.messagePublisher.tryEmit(new MqttEvent.MqttSensorEvent(str3, list));
        } else if (StringsKt.startsWith$default(str2, "$aws", false, 2, (Object) null)) {
            String str4 = (String) CollectionsKt.getOrNull(StringsKt.split$default((CharSequence) str2, new String[]{"/"}, false, 0, 6, (Object) null), 2);
            if (str4 != null) {
                str3 = str4;
            }
            String mqttMessage4 = mqttMessage2.toString();
            Intrinsics.checkNotNullExpressionValue(mqttMessage4, "toString(...)");
            if (mqttMessage4.length() == 0) {
                obj2 = Reflection.getOrCreateKotlinClass(DeviceStateBundle.class).getObjectInstance();
                Intrinsics.checkNotNull(obj2);
            } else {
                JsonAdapter lenient2 = new Moshi.Builder().add((JsonAdapter.Factory) new KotlinJsonAdapterFactory()).build().adapter(DeviceStateBundle.class).lenient();
                Intrinsics.checkNotNullExpressionValue(lenient2, "lenient(...)");
                obj2 = lenient2.fromJson(mqttMessage4);
                if (obj2 == null) {
                    obj2 = Reflection.getOrCreateKotlinClass(DeviceStateBundle.class).getObjectInstance();
                    Intrinsics.checkNotNull(obj2);
                }
            }
            DeviceStateBundle deviceStateBundle = (DeviceStateBundle) obj2;
            Timber.Forest forest3 = Timber.Forest;
            forest3.v("messageArrived: " + str3 + " stateEvent = \n\t" + deviceStateBundle, new Object[0]);
            this.messagePublisher.tryEmit(new MqttEvent.MqttStateEvent(str3, deviceStateBundle));
        } else if (StringsKt.endsWith$default(str2, "event", false, 2, (Object) null)) {
            String mqttMessage5 = mqttMessage2.toString();
            Intrinsics.checkNotNullExpressionValue(mqttMessage5, "toString(...)");
            if (mqttMessage5.length() == 0) {
                obj = Reflection.getOrCreateKotlinClass(DeviceEvent.class).getObjectInstance();
                Intrinsics.checkNotNull(obj);
            } else {
                JsonAdapter lenient3 = new Moshi.Builder().add((JsonAdapter.Factory) new KotlinJsonAdapterFactory()).build().adapter(DeviceEvent.class).lenient();
                Intrinsics.checkNotNullExpressionValue(lenient3, "lenient(...)");
                obj = lenient3.fromJson(mqttMessage5);
                if (obj == null) {
                    obj = Reflection.getOrCreateKotlinClass(DeviceEvent.class).getObjectInstance();
                    Intrinsics.checkNotNull(obj);
                }
            }
            DeviceEvent deviceEvent = (DeviceEvent) obj;
            String originDeviceId = deviceEvent.getOriginDeviceId();
            if (originDeviceId != null) {
                str3 = originDeviceId;
            }
            long j = this.datedEventFilter.get(str3);
            if (j == null) {
                j = 0L;
            }
            long longValue = ((Number) j).longValue();
            ConnectedState fromName = ConnectedState.Companion.fromName(deviceEvent.getConnectionEvent());
            Timber.Forest forest4 = Timber.Forest;
            forest4.v("messageArrived: lastEvent = " + longValue + ", deviceEvent = \n\t" + deviceEvent + " ,ConnectedState=" + fromName, new Object[0]);
            if (Intrinsics.areEqual((Object) fromName, (Object) ConnectedState.CMSynchronization.INSTANCE) || deviceEvent.getTimeStamp() <= longValue) {
                Timber.Forest.v("Ignore dated event", new Object[0]);
                return;
            }
            this.datedEventFilter.put(str3, Long.valueOf(deviceEvent.getTimeStamp()));
            this.messagePublisher.tryEmit(new MqttEvent.MqttDeviceEvent(deviceEvent));
            if (Intrinsics.areEqual((Object) fromName, (Object) ConnectedState.Connected.INSTANCE)) {
                this.mqttService.resubscribeRt5s(str3);
            }
        }
    }
}
