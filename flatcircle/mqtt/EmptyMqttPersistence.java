package io.flatcircle.mqtt;

import java.util.Enumeration;
import java.util.Vector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.paho.client.mqttv3.MqttClientPersistence;
import org.eclipse.paho.client.mqttv3.MqttPersistable;
import org.eclipse.paho.client.mqttv3.internal.MqttPersistentData;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u001c\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u001c\u0010\u000b\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\b2\b\u0010\r\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\u000e\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0013\u0010\u000f\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u0012\u001a\u00020\u0005H\u0016J\f\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u0014H\u0016¨\u0006\u0015"}, d2 = {"Lio/flatcircle/mqtt/EmptyMqttPersistence;", "Lorg/eclipse/paho/client/mqttv3/MqttClientPersistence;", "<init>", "()V", "clear", "", "put", "key", "", "persistable", "Lorg/eclipse/paho/client/mqttv3/MqttPersistable;", "open", "clientId", "serverURI", "remove", "get", "containsKey", "", "close", "keys", "Ljava/util/Enumeration;", "mqtt_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: EmptyMqttPersistence.kt */
public final class EmptyMqttPersistence implements MqttClientPersistence {
    public void clear() {
    }

    public void close() {
    }

    public boolean containsKey(String str) {
        return false;
    }

    public void open(String str, String str2) {
    }

    public void put(String str, MqttPersistable mqttPersistable) {
    }

    public void remove(String str) {
    }

    public MqttPersistable get(String str) {
        return new MqttPersistentData("key", new byte[0], 0, 0, (byte[]) null, 0, 0);
    }

    public Enumeration<?> keys() {
        Enumeration<?> elements = new Vector().elements();
        Intrinsics.checkNotNullExpressionValue(elements, "elements(...)");
        return elements;
    }
}
