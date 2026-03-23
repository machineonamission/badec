package com.blueair.devicemanager;

import com.blueair.core.model.AqiHumLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.devicemanager.DeviceManager", f = "DeviceManager.kt", i = {0, 0, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3}, l = {2462, 2466, 2472, 2484}, m = "executeHumForNotification", n = {"deviceId", "aqiHumLevel", "deviceId", "aqiHumLevel", "entity", "deviceId", "aqiHumLevel", "entity", "localAqiHumLevel", "deviceId", "aqiHumLevel", "entity", "localAqiHumLevel", "curTimeMillis"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "J$0"})
/* compiled from: DeviceManager.kt */
final class DeviceManager$executeHumForNotification$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DeviceManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeviceManager$executeHumForNotification$1(DeviceManager deviceManager, Continuation<? super DeviceManager$executeHumForNotification$1> continuation) {
        super(continuation);
        this.this$0 = deviceManager;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.executeHumForNotification((String) null, (AqiHumLevel) null, this);
    }
}
