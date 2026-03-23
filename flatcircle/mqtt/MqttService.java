package io.flatcircle.mqtt;

import com.blueair.auth.AuthService;
import com.blueair.core.model.HasBlueCloudFunctions;
import com.blueair.database.entity.DeviceDataEntity;
import io.flatcircle.coroutinehelper.DefaultCoroutineScope;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.eclipse.paho.client.mqttv3.MqttClient;
import timber.log.Timber;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\u001c\u001a\u00020\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fJ\b\u0010!\u001a\u00020\u001dH\u0002J\u000e\u0010\"\u001a\u00020\u0015H@¢\u0006\u0002\u0010#J\u000e\u0010$\u001a\u00020\u001dH@¢\u0006\u0002\u0010#J\b\u0010%\u001a\u00020\u001dH\u0002J\u000e\u0010&\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020\u0011JZ\u0010(\u001a\u0002H)\"\u0004\b\u0000\u0010)2\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u0010,\u001a\u00020-2\b\b\u0002\u0010.\u001a\u00020-2\b\b\u0002\u0010/\u001a\u0002002\u001c\u00101\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H)03\u0012\u0006\u0012\u0004\u0018\u00010402H@¢\u0006\u0002\u00105J\u0006\u00106\u001a\u00020\u001dR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0017X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0012\u00107\u001a\u000208X\u0005¢\u0006\u0006\u001a\u0004\b9\u0010:¨\u0006;"}, d2 = {"Lio/flatcircle/mqtt/MqttService;", "Lkotlinx/coroutines/CoroutineScope;", "authService", "Lcom/blueair/auth/AuthService;", "<init>", "(Lcom/blueair/auth/AuthService;)V", "_eventObservable", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lio/flatcircle/mqtt/MqttEvent;", "eventObservable", "Lkotlinx/coroutines/flow/SharedFlow;", "getEventObservable", "()Lkotlinx/coroutines/flow/SharedFlow;", "client", "Lorg/eclipse/paho/client/mqttv3/MqttClient;", "registeredDeviceIds", "", "", "oneSubscribeMutex", "Lkotlinx/coroutines/sync/Mutex;", "hasLost", "", "_mqttReconnected", "Lkotlinx/coroutines/flow/MutableStateFlow;", "mqttReconnected", "Lkotlinx/coroutines/flow/StateFlow;", "getMqttReconnected", "()Lkotlinx/coroutines/flow/StateFlow;", "registerDevices", "", "mqttDevices", "", "Lcom/blueair/core/model/HasBlueCloudFunctions;", "startConnection", "subscribeWithExponentialBackoff", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "connectAndSubscribe", "subscribe", "resubscribeRt5s", "deviceId", "retryWithBackoff", "T", "times", "", "initialDelay", "", "maxDelay", "factor", "", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(IJJDLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clear", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "mqtt_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: MqttService.kt */
public final class MqttService implements CoroutineScope {
    private final /* synthetic */ DefaultCoroutineScope $$delegate_0 = new DefaultCoroutineScope();
    /* access modifiers changed from: private */
    public final MutableSharedFlow<MqttEvent> _eventObservable;
    /* access modifiers changed from: private */
    public final MutableStateFlow<Boolean> _mqttReconnected;
    private final AuthService authService;
    private MqttClient client;
    private final SharedFlow<MqttEvent> eventObservable;
    /* access modifiers changed from: private */
    public boolean hasLost;
    private final StateFlow<Boolean> mqttReconnected;
    private final Mutex oneSubscribeMutex;
    private final List<String> registeredDeviceIds;

    public CoroutineContext getCoroutineContext() {
        return this.$$delegate_0.getCoroutineContext();
    }

    public MqttService(AuthService authService2) {
        Intrinsics.checkNotNullParameter(authService2, "authService");
        this.authService = authService2;
        MutableSharedFlow<MqttEvent> MutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 64, (BufferOverflow) null, 5, (Object) null);
        this._eventObservable = MutableSharedFlow$default;
        this.eventObservable = MutableSharedFlow$default;
        this.registeredDeviceIds = new ArrayList();
        this.oneSubscribeMutex = MutexKt.Mutex$default(false, 1, (Object) null);
        MutableStateFlow<Boolean> MutableStateFlow = StateFlowKt.MutableStateFlow(false);
        this._mqttReconnected = MutableStateFlow;
        this.mqttReconnected = MutableStateFlow;
    }

    public final SharedFlow<MqttEvent> getEventObservable() {
        return this.eventObservable;
    }

    public final StateFlow<Boolean> getMqttReconnected() {
        return this.mqttReconnected;
    }

    public final void registerDevices(List<? extends HasBlueCloudFunctions> list) {
        Intrinsics.checkNotNullParameter(list, "mqttDevices");
        Iterable<HasBlueCloudFunctions> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (HasBlueCloudFunctions uid : iterable) {
            arrayList.add(uid.getUid());
        }
        List list2 = (List) arrayList;
        if (!Intrinsics.areEqual((Object) this.registeredDeviceIds, (Object) list2)) {
            this.registeredDeviceIds.clear();
            if (list.isEmpty()) {
                MqttClient mqttClient = this.client;
                if (mqttClient != null) {
                    mqttClient.disconnect();
                    return;
                }
                return;
            }
            this.registeredDeviceIds.addAll(list2);
            startConnection();
        }
    }

    private final void startConnection() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(this, (CoroutineContext) null, (CoroutineStart) null, new MqttService$startConnection$1(this, (Continuation<? super MqttService$startConnection$1>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:52:0x00d2 */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object subscribeWithExponentialBackoff(kotlin.coroutines.Continuation<? super java.lang.Boolean> r18) {
        /*
            r17 = this;
            r1 = r17
            r0 = r18
            boolean r2 = r0 instanceof io.flatcircle.mqtt.MqttService$subscribeWithExponentialBackoff$1
            if (r2 == 0) goto L_0x0018
            r2 = r0
            io.flatcircle.mqtt.MqttService$subscribeWithExponentialBackoff$1 r2 = (io.flatcircle.mqtt.MqttService$subscribeWithExponentialBackoff$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r0 = r2.label
            int r0 = r0 - r4
            r2.label = r0
            goto L_0x001d
        L_0x0018:
            io.flatcircle.mqtt.MqttService$subscribeWithExponentialBackoff$1 r2 = new io.flatcircle.mqtt.MqttService$subscribeWithExponentialBackoff$1
            r2.<init>(r1, r0)
        L_0x001d:
            r10 = r2
            java.lang.Object r0 = r10.result
            java.lang.Object r13 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r10.label
            r3 = 2
            r4 = 1
            r14 = 0
            r15 = 0
            if (r2 == 0) goto L_0x0054
            if (r2 == r4) goto L_0x0048
            if (r2 != r3) goto L_0x0040
            int r2 = r10.I$1
            int r2 = r10.I$0
            java.lang.Object r2 = r10.L$0
            kotlinx.coroutines.sync.Mutex r2 = (kotlinx.coroutines.sync.Mutex) r2
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ Exception -> 0x00d2 }
            goto L_0x00be
        L_0x003d:
            r0 = move-exception
            goto L_0x00da
        L_0x0040:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0048:
            int r2 = r10.I$0
            java.lang.Object r4 = r10.L$0
            kotlinx.coroutines.sync.Mutex r4 = (kotlinx.coroutines.sync.Mutex) r4
            kotlin.ResultKt.throwOnFailure(r0)
            r0 = r2
            r2 = r4
            goto L_0x0094
        L_0x0054:
            kotlin.ResultKt.throwOnFailure(r0)
            java.util.List<java.lang.String> r0 = r1.registeredDeviceIds
            int r0 = r0.size()
            if (r0 >= r4) goto L_0x0076
            org.eclipse.paho.client.mqttv3.MqttClient r0 = r1.client     // Catch:{ all -> 0x0067 }
            if (r0 == 0) goto L_0x0071
            r0.disconnect()     // Catch:{ all -> 0x0067 }
            goto L_0x0071
        L_0x0067:
            r0 = move-exception
            timber.log.Timber$Forest r2 = timber.log.Timber.Forest
            java.lang.String r3 = "client.disconnect() error"
            java.lang.Object[] r4 = new java.lang.Object[r15]
            r2.e(r0, r3, r4)
        L_0x0071:
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r15)
            return r0
        L_0x0076:
            kotlinx.coroutines.sync.Mutex r0 = r1.oneSubscribeMutex
            boolean r0 = r0.isLocked()
            if (r0 == 0) goto L_0x0083
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r15)
            return r0
        L_0x0083:
            kotlinx.coroutines.sync.Mutex r0 = r1.oneSubscribeMutex
            r10.L$0 = r0
            r10.I$0 = r15
            r10.label = r4
            java.lang.Object r2 = r0.lock(r14, r10)
            if (r2 != r13) goto L_0x0092
            goto L_0x00bb
        L_0x0092:
            r2 = r0
            r0 = r15
        L_0x0094:
            io.flatcircle.mqtt.MqttService$subscribeWithExponentialBackoff$2$1 r4 = new io.flatcircle.mqtt.MqttService$subscribeWithExponentialBackoff$2$1     // Catch:{ Exception -> 0x00d0, all -> 0x00cc }
            r4.<init>(r1, r14)     // Catch:{ Exception -> 0x00d0, all -> 0x00cc }
            r9 = r4
            kotlin.jvm.functions.Function1 r9 = (kotlin.jvm.functions.Function1) r9     // Catch:{ Exception -> 0x00d0, all -> 0x00cc }
            r10.L$0 = r2     // Catch:{ Exception -> 0x00d0, all -> 0x00cc }
            r10.I$0 = r0     // Catch:{ Exception -> 0x00d0, all -> 0x00cc }
            r10.I$1 = r15     // Catch:{ Exception -> 0x00d0, all -> 0x00cc }
            r10.label = r3     // Catch:{ Exception -> 0x00d0, all -> 0x00cc }
            r4 = r2
            r2 = 0
            r5 = r4
            r3 = 1000(0x3e8, double:4.94E-321)
            r7 = r5
            r5 = 0
            r11 = r7
            r7 = 0
            r12 = r11
            r11 = 13
            r16 = r12
            r12 = 0
            java.lang.Object r0 = retryWithBackoff$default(r1, r2, r3, r5, r7, r9, r10, r11, r12)     // Catch:{ Exception -> 0x00c9, all -> 0x00c5 }
            if (r0 != r13) goto L_0x00bc
        L_0x00bb:
            return r13
        L_0x00bc:
            r2 = r16
        L_0x00be:
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ Exception -> 0x00d2 }
            boolean r15 = r0.booleanValue()     // Catch:{ Exception -> 0x00d2 }
            goto L_0x00d2
        L_0x00c5:
            r0 = move-exception
            r2 = r16
            goto L_0x00da
        L_0x00c9:
            r2 = r16
            goto L_0x00d2
        L_0x00cc:
            r0 = move-exception
            r16 = r2
            goto L_0x00da
        L_0x00d0:
            r16 = r2
        L_0x00d2:
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r15)     // Catch:{ all -> 0x003d }
            r2.unlock(r14)
            return r0
        L_0x00da:
            r2.unlock(r14)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flatcircle.mqtt.MqttService.subscribeWithExponentialBackoff(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00fb A[Catch:{ Exception -> 0x0042 }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0110 A[Catch:{ Exception -> 0x0042 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object connectAndSubscribe(kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r9 = this;
            java.lang.String r0 = "Attempting to Mqtt subscribe with serverURI: "
            java.lang.String r1 = "wss://"
            java.lang.String r2 = "Attempting to Mqtt subscribe with clientId: "
            boolean r3 = r10 instanceof io.flatcircle.mqtt.MqttService$connectAndSubscribe$1
            if (r3 == 0) goto L_0x001a
            r3 = r10
            io.flatcircle.mqtt.MqttService$connectAndSubscribe$1 r3 = (io.flatcircle.mqtt.MqttService$connectAndSubscribe$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r4 & r5
            if (r4 == 0) goto L_0x001a
            int r10 = r3.label
            int r10 = r10 - r5
            r3.label = r10
            goto L_0x001f
        L_0x001a:
            io.flatcircle.mqtt.MqttService$connectAndSubscribe$1 r3 = new io.flatcircle.mqtt.MqttService$connectAndSubscribe$1
            r3.<init>(r9, r10)
        L_0x001f:
            java.lang.Object r10 = r3.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r3.label
            r6 = 0
            r7 = 1
            if (r5 == 0) goto L_0x004d
            if (r5 != r7) goto L_0x0045
            java.lang.Object r0 = r3.L$3
            java.util.Properties r0 = (java.util.Properties) r0
            java.lang.Object r1 = r3.L$2
            org.eclipse.paho.client.mqttv3.MqttConnectOptions r1 = (org.eclipse.paho.client.mqttv3.MqttConnectOptions) r1
            java.lang.Object r2 = r3.L$1
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r2 = r3.L$0
            java.lang.String r2 = (java.lang.String) r2
            kotlin.ResultKt.throwOnFailure(r10)     // Catch:{ Exception -> 0x0042 }
            goto L_0x00d3
        L_0x0042:
            r10 = move-exception
            goto L_0x0119
        L_0x0045:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L_0x004d:
            kotlin.ResultKt.throwOnFailure(r10)
            org.eclipse.paho.client.mqttv3.MqttClient r10 = r9.client
            if (r10 == 0) goto L_0x0060
            boolean r10 = r10.isConnected()
            if (r10 != r7) goto L_0x0060
            r9.subscribe()
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        L_0x0060:
            com.blueair.auth.AuthService r10 = r9.authService
            java.lang.String r10 = r10.getAppIdForMqtt()
            timber.log.Timber$Forest r5 = timber.log.Timber.Forest     // Catch:{ Exception -> 0x0042 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0042 }
            r8.<init>(r2)     // Catch:{ Exception -> 0x0042 }
            r8.append(r10)     // Catch:{ Exception -> 0x0042 }
            java.lang.String r2 = r8.toString()     // Catch:{ Exception -> 0x0042 }
            java.lang.Object[] r8 = new java.lang.Object[r6]     // Catch:{ Exception -> 0x0042 }
            r5.d(r2, r8)     // Catch:{ Exception -> 0x0042 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0042 }
            r2.<init>(r1)     // Catch:{ Exception -> 0x0042 }
            com.blueair.auth.AuthService r1 = r9.authService     // Catch:{ Exception -> 0x0042 }
            java.lang.String r1 = r1.getBlueBrokerURL()     // Catch:{ Exception -> 0x0042 }
            r2.append(r1)     // Catch:{ Exception -> 0x0042 }
            java.lang.String r1 = r2.toString()     // Catch:{ Exception -> 0x0042 }
            timber.log.Timber$Forest r2 = timber.log.Timber.Forest     // Catch:{ Exception -> 0x0042 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0042 }
            r5.<init>(r0)     // Catch:{ Exception -> 0x0042 }
            r5.append(r1)     // Catch:{ Exception -> 0x0042 }
            java.lang.String r0 = r5.toString()     // Catch:{ Exception -> 0x0042 }
            java.lang.Object[] r5 = new java.lang.Object[r6]     // Catch:{ Exception -> 0x0042 }
            r2.d(r0, r5)     // Catch:{ Exception -> 0x0042 }
            org.eclipse.paho.client.mqttv3.MqttClient r0 = new org.eclipse.paho.client.mqttv3.MqttClient     // Catch:{ Exception -> 0x0042 }
            io.flatcircle.mqtt.EmptyMqttPersistence r2 = new io.flatcircle.mqtt.EmptyMqttPersistence     // Catch:{ Exception -> 0x0042 }
            r2.<init>()     // Catch:{ Exception -> 0x0042 }
            org.eclipse.paho.client.mqttv3.MqttClientPersistence r2 = (org.eclipse.paho.client.mqttv3.MqttClientPersistence) r2     // Catch:{ Exception -> 0x0042 }
            r0.<init>(r1, r10, r2)     // Catch:{ Exception -> 0x0042 }
            r9.client = r0     // Catch:{ Exception -> 0x0042 }
            org.eclipse.paho.client.mqttv3.MqttConnectOptions r0 = new org.eclipse.paho.client.mqttv3.MqttConnectOptions     // Catch:{ Exception -> 0x0042 }
            r0.<init>()     // Catch:{ Exception -> 0x0042 }
            java.util.Properties r2 = new java.util.Properties     // Catch:{ Exception -> 0x0042 }
            r2.<init>()     // Catch:{ Exception -> 0x0042 }
            com.blueair.auth.AuthService r5 = r9.authService     // Catch:{ Exception -> 0x0042 }
            java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r10)     // Catch:{ Exception -> 0x0042 }
            r3.L$0 = r10     // Catch:{ Exception -> 0x0042 }
            java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)     // Catch:{ Exception -> 0x0042 }
            r3.L$1 = r10     // Catch:{ Exception -> 0x0042 }
            r3.L$2 = r0     // Catch:{ Exception -> 0x0042 }
            r3.L$3 = r2     // Catch:{ Exception -> 0x0042 }
            r3.label = r7     // Catch:{ Exception -> 0x0042 }
            java.lang.Object r10 = r5.getCloudJwt(r3)     // Catch:{ Exception -> 0x0042 }
            if (r10 != r4) goto L_0x00d1
            return r4
        L_0x00d1:
            r1 = r0
            r0 = r2
        L_0x00d3:
            java.lang.String r10 = "X-Amz-CustomAuthorizer-Name"
            com.blueair.auth.AuthService r2 = r9.authService     // Catch:{ Exception -> 0x0042 }
            java.lang.String r2 = r2.getAuthNameForMqtt()     // Catch:{ Exception -> 0x0042 }
            r0.setProperty(r10, r2)     // Catch:{ Exception -> 0x0042 }
            java.lang.String r10 = "X-Amz-CustomAuthorizer-Signature"
            com.blueair.auth.AuthService r2 = r9.authService     // Catch:{ Exception -> 0x0042 }
            java.lang.String r2 = r2.getSignatureForMqtt()     // Catch:{ Exception -> 0x0042 }
            r0.setProperty(r10, r2)     // Catch:{ Exception -> 0x0042 }
            java.lang.String r10 = "X-Amz-CustomAuthorizer-Token"
            com.blueair.auth.AuthService r2 = r9.authService     // Catch:{ Exception -> 0x0042 }
            java.lang.String r2 = r2.getTokenForMqtt()     // Catch:{ Exception -> 0x0042 }
            r0.setProperty(r10, r2)     // Catch:{ Exception -> 0x0042 }
            r1.setCustomWebSocketHeaders(r0)     // Catch:{ Exception -> 0x0042 }
            org.eclipse.paho.client.mqttv3.MqttClient r10 = r9.client     // Catch:{ Exception -> 0x0042 }
            if (r10 == 0) goto L_0x010c
            io.flatcircle.mqtt.SimpleMqttCallBack r0 = new io.flatcircle.mqtt.SimpleMqttCallBack     // Catch:{ Exception -> 0x0042 }
            kotlinx.coroutines.flow.MutableSharedFlow<io.flatcircle.mqtt.MqttEvent> r2 = r9._eventObservable     // Catch:{ Exception -> 0x0042 }
            io.flatcircle.mqtt.MqttService$$ExternalSyntheticLambda0 r3 = new io.flatcircle.mqtt.MqttService$$ExternalSyntheticLambda0     // Catch:{ Exception -> 0x0042 }
            r3.<init>(r9)     // Catch:{ Exception -> 0x0042 }
            r0.<init>(r9, r2, r3)     // Catch:{ Exception -> 0x0042 }
            org.eclipse.paho.client.mqttv3.MqttCallback r0 = (org.eclipse.paho.client.mqttv3.MqttCallback) r0     // Catch:{ Exception -> 0x0042 }
            r10.setCallback(r0)     // Catch:{ Exception -> 0x0042 }
        L_0x010c:
            org.eclipse.paho.client.mqttv3.MqttClient r10 = r9.client     // Catch:{ Exception -> 0x0042 }
            if (r10 == 0) goto L_0x0113
            r10.connect(r1)     // Catch:{ Exception -> 0x0042 }
        L_0x0113:
            r9.subscribe()     // Catch:{ Exception -> 0x0042 }
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        L_0x0119:
            timber.log.Timber$Forest r0 = timber.log.Timber.Forest
            r1 = r10
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            java.lang.String r2 = "subscribe failed"
            java.lang.Object[] r3 = new java.lang.Object[r6]
            r0.w(r1, r2, r3)
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r10 = r10.getLocalizedMessage()
            r0.<init>(r10)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flatcircle.mqtt.MqttService.connectAndSubscribe(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public static final Unit connectAndSubscribe$lambda$1(MqttService mqttService) {
        mqttService.hasLost = true;
        mqttService._mqttReconnected.tryEmit(false);
        mqttService.startConnection();
        return Unit.INSTANCE;
    }

    private final void subscribe() {
        MqttClient mqttClient = this.client;
        if (mqttClient != null) {
            mqttClient.subscribe("c/" + this.authService.getUserIdForBlueCloud() + "/s/event");
        }
        for (String str : this.registeredDeviceIds) {
            Timber.Forest.d("Attempting to Mqtt subscribe with deviceId: " + str, new Object[0]);
            String[] strArr = {"d/" + str + "/s/5s", "$aws/things/" + str + "/shadow/update/documents"};
            MqttClient mqttClient2 = this.client;
            if (mqttClient2 != null) {
                mqttClient2.subscribe(strArr);
            }
            Timber.Forest.d("subscribe device topics : " + ArraysKt.toList((T[]) strArr), new Object[0]);
        }
    }

    public final void resubscribeRt5s(String str) {
        Unit unit;
        Intrinsics.checkNotNullParameter(str, DeviceDataEntity.DEVICE_ID);
        Timber.Forest.d("Attempting to Mqtt resubscribe with deviceId: " + str, new Object[0]);
        try {
            Result.Companion companion = Result.Companion;
            MqttService mqttService = this;
            String str2 = "d/" + str + "/s/5s";
            MqttClient mqttClient = this.client;
            if (mqttClient != null) {
                mqttClient.unsubscribe(str2);
            }
            MqttClient mqttClient2 = this.client;
            if (mqttClient2 != null) {
                mqttClient2.subscribe(str2);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            Result.m9366constructorimpl(unit);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.m9366constructorimpl(ResultKt.createFailure(th));
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00c1 A[SYNTHETIC, Splitter:B:25:0x00c1] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x013d  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x015a A[PHI: r3 
      PHI: (r3v1 ? extends java.lang.Object) = (r3v2 ? extends java.lang.Object), (r3v3 ? extends java.lang.Object), (r3v3 ? extends java.lang.Object) binds: [B:37:0x0114, B:41:0x0158, B:30:0x00dd] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <T> java.lang.Object retryWithBackoff(int r22, long r23, long r25, double r27, kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super T>, ? extends java.lang.Object> r29, kotlin.coroutines.Continuation<? super T> r30) {
        /*
            r21 = this;
            r0 = r30
            boolean r1 = r0 instanceof io.flatcircle.mqtt.MqttService$retryWithBackoff$1
            if (r1 == 0) goto L_0x0018
            r1 = r0
            io.flatcircle.mqtt.MqttService$retryWithBackoff$1 r1 = (io.flatcircle.mqtt.MqttService$retryWithBackoff$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0018
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            r2 = r21
            goto L_0x001f
        L_0x0018:
            io.flatcircle.mqtt.MqttService$retryWithBackoff$1 r1 = new io.flatcircle.mqtt.MqttService$retryWithBackoff$1
            r2 = r21
            r1.<init>(r2, r0)
        L_0x001f:
            java.lang.Object r0 = r1.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r1.label
            r6 = 3
            r7 = 2
            r8 = 1
            if (r4 == 0) goto L_0x00a3
            if (r4 == r8) goto L_0x0076
            if (r4 == r7) goto L_0x004e
            if (r4 != r6) goto L_0x0046
            double r3 = r1.D$0
            long r3 = r1.J$1
            long r3 = r1.J$0
            int r3 = r1.I$0
            java.lang.Object r3 = r1.L$1
            kotlin.jvm.internal.Ref$LongRef r3 = (kotlin.jvm.internal.Ref.LongRef) r3
            java.lang.Object r1 = r1.L$0
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            kotlin.ResultKt.throwOnFailure(r0)
            return r0
        L_0x0046:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x004e:
            int r4 = r1.I$4
            int r4 = r1.I$3
            int r4 = r1.I$2
            int r9 = r1.I$1
            double r10 = r1.D$0
            long r12 = r1.J$1
            long r14 = r1.J$0
            int r6 = r1.I$0
            java.lang.Object r7 = r1.L$1
            kotlin.jvm.internal.Ref$LongRef r7 = (kotlin.jvm.internal.Ref.LongRef) r7
            java.lang.Object r8 = r1.L$0
            kotlin.jvm.functions.Function1 r8 = (kotlin.jvm.functions.Function1) r8
            kotlin.ResultKt.throwOnFailure(r0)
            r0 = r6
            r22 = r12
            r13 = r9
            r19 = r10
            r11 = r1
            r1 = r8
            r8 = r19
        L_0x0073:
            r10 = r7
            goto L_0x011f
        L_0x0076:
            int r4 = r1.I$4
            int r6 = r1.I$3
            int r7 = r1.I$2
            int r8 = r1.I$1
            double r9 = r1.D$0
            long r11 = r1.J$1
            long r13 = r1.J$0
            int r15 = r1.I$0
            java.lang.Object r5 = r1.L$1
            kotlin.jvm.internal.Ref$LongRef r5 = (kotlin.jvm.internal.Ref.LongRef) r5
            r18 = r0
            java.lang.Object r0 = r1.L$0
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            kotlin.ResultKt.throwOnFailure(r18)     // Catch:{ IOException -> 0x0094 }
            return r18
        L_0x0094:
            r18 = r5
            r5 = r4
            r4 = r7
            r7 = r18
            r19 = r13
            r13 = r8
            r8 = r15
            r14 = r19
            r18 = r3
            goto L_0x00f5
        L_0x00a3:
            r18 = r0
            kotlin.ResultKt.throwOnFailure(r18)
            kotlin.jvm.internal.Ref$LongRef r0 = new kotlin.jvm.internal.Ref$LongRef
            r0.<init>()
            r4 = r23
            r0.element = r4
            int r6 = r22 + -1
            r8 = r27
            r10 = r0
            r11 = r1
            r13 = r6
            r12 = 0
            r0 = r22
            r6 = r25
            r1 = r29
        L_0x00bf:
            if (r12 >= r13) goto L_0x013d
            r11.L$0 = r1     // Catch:{ IOException -> 0x00e2 }
            r11.L$1 = r10     // Catch:{ IOException -> 0x00e2 }
            r11.I$0 = r0     // Catch:{ IOException -> 0x00e2 }
            r11.J$0 = r4     // Catch:{ IOException -> 0x00e2 }
            r11.J$1 = r6     // Catch:{ IOException -> 0x00e2 }
            r11.D$0 = r8     // Catch:{ IOException -> 0x00e2 }
            r11.I$1 = r13     // Catch:{ IOException -> 0x00e2 }
            r11.I$2 = r12     // Catch:{ IOException -> 0x00e2 }
            r11.I$3 = r12     // Catch:{ IOException -> 0x00e2 }
            r14 = 0
            r11.I$4 = r14     // Catch:{ IOException -> 0x00e3 }
            r15 = 1
            r11.label = r15     // Catch:{ IOException -> 0x00e3 }
            java.lang.Object r0 = r1.invoke(r11)     // Catch:{ IOException -> 0x00e3 }
            if (r0 != r3) goto L_0x00e1
            goto L_0x015a
        L_0x00e1:
            return r0
        L_0x00e2:
            r14 = 0
        L_0x00e3:
            r19 = r4
            r5 = r14
            r14 = r19
            r18 = r3
            r4 = r12
            r19 = r8
            r8 = r0
            r0 = r1
            r1 = r11
            r11 = r6
            r7 = r10
            r6 = r4
            r9 = r19
        L_0x00f5:
            long r2 = r7.element
            r1.L$0 = r0
            r1.L$1 = r7
            r1.I$0 = r8
            r1.J$0 = r14
            r1.J$1 = r11
            r1.D$0 = r9
            r1.I$1 = r13
            r1.I$2 = r4
            r1.I$3 = r6
            r1.I$4 = r5
            r5 = 2
            r1.label = r5
            java.lang.Object r2 = kotlinx.coroutines.DelayKt.delay(r2, r1)
            r3 = r18
            if (r2 != r3) goto L_0x0117
            goto L_0x015a
        L_0x0117:
            r22 = r11
            r11 = r1
            r1 = r0
            r0 = r8
            r8 = r9
            goto L_0x0073
        L_0x011f:
            long r5 = r10.element
            double r5 = (double) r5
            double r5 = r5 * r8
            long r5 = (long) r5
            r24 = r0
            r25 = r1
            r0 = r22
            long r5 = kotlin.ranges.RangesKt.coerceAtMost((long) r5, (long) r0)
            r10.element = r5
            r17 = 1
            int r12 = r4 + 1
            r2 = r21
            r6 = r0
            r4 = r14
            r0 = r24
            r1 = r25
            goto L_0x00bf
        L_0x013d:
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r11.L$0 = r2
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r10)
            r11.L$1 = r2
            r11.I$0 = r0
            r11.J$0 = r4
            r11.J$1 = r6
            r11.D$0 = r8
            r0 = 3
            r11.label = r0
            java.lang.Object r0 = r1.invoke(r11)
            if (r0 != r3) goto L_0x015b
        L_0x015a:
            return r3
        L_0x015b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flatcircle.mqtt.MqttService.retryWithBackoff(int, long, long, double, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object retryWithBackoff$default(MqttService mqttService, int i, long j, long j2, double d, Function1 function1, Continuation continuation, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = Integer.MAX_VALUE;
        }
        if ((i2 & 2) != 0) {
            j = 100;
        }
        if ((i2 & 4) != 0) {
            j2 = 30000;
        }
        if ((i2 & 8) != 0) {
            d = 2.0d;
        }
        double d2 = d;
        long j3 = j2;
        long j4 = j;
        return mqttService.retryWithBackoff(i, j4, j3, d2, function1, continuation);
    }

    public final void clear() {
        try {
            MqttClient mqttClient = this.client;
            if (mqttClient != null) {
                mqttClient.close();
            }
        } catch (Throwable th) {
            Timber.Forest.e(th, "client.close() failed", new Object[0]);
        }
        this.client = null;
        Job unused = BuildersKt__Builders_commonKt.launch$default(this, (CoroutineContext) null, (CoroutineStart) null, new MqttService$clear$1(this, (Continuation<? super MqttService$clear$1>) null), 3, (Object) null);
    }
}
