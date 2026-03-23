package com.blueair.livestream;

import com.blueair.core.model.Device;
import com.blueair.core.util.NetworkMonitor;
import com.blueair.database.entity.DeviceDataEntity;
import io.flatcircle.ble.BleService;
import io.flatcircle.coroutinehelper.DefaultCoroutineScope;
import io.flatcircle.mqtt.MqttService;
import io.flatcircle.stomp.StompService;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import timber.log.Timber;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u001c\u001a\u00020\u001dH\u0002J\u000e\u0010\u001e\u001a\u00020\u001dH@¢\u0006\u0002\u0010\u001fJ\u000e\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\"J\u0014\u0010*\u001a\u00020\u001d2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020%0$J\u000e\u0010,\u001a\u00020\u001d2\u0006\u0010-\u001a\u00020\"J\u000e\u0010.\u001a\u00020\u001dH@¢\u0006\u0002\u0010\u001fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000fX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\"\u0010#\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010$X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0012\u0010/\u001a\u000200X\u0005¢\u0006\u0006\u001a\u0004\b1\u00102¨\u00063"}, d2 = {"Lcom/blueair/livestream/StreamService;", "Lkotlinx/coroutines/CoroutineScope;", "mqttService", "Lio/flatcircle/mqtt/MqttService;", "stompService", "Lio/flatcircle/stomp/StompService;", "bleService", "Lio/flatcircle/ble/BleService;", "networkMonitor", "Lcom/blueair/core/util/NetworkMonitor;", "<init>", "(Lio/flatcircle/mqtt/MqttService;Lio/flatcircle/stomp/StompService;Lio/flatcircle/ble/BleService;Lcom/blueair/core/util/NetworkMonitor;)V", "getBleService", "()Lio/flatcircle/ble/BleService;", "_mainObservable", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/blueair/livestream/StreamEvent;", "mainObservable", "Lkotlinx/coroutines/flow/SharedFlow;", "getMainObservable", "()Lkotlinx/coroutines/flow/SharedFlow;", "mqttReconnected", "Lkotlinx/coroutines/flow/StateFlow;", "", "getMqttReconnected", "()Lkotlinx/coroutines/flow/StateFlow;", "mqttMutex", "Lkotlinx/coroutines/sync/Mutex;", "setAllListeners", "", "restartStomp", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resubscribeMqttRt5s", "deviceId", "", "lastRegisteredDevices", "", "Lcom/blueair/core/model/Device;", "getLastRegisteredDevices", "()Ljava/util/List;", "setLastRegisteredDevices", "(Ljava/util/List;)V", "registerDevices", "devices", "unregisterBleDevice", "uuid", "clear", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "livestream_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: StreamService.kt */
public final class StreamService implements CoroutineScope {
    private final /* synthetic */ DefaultCoroutineScope $$delegate_0 = new DefaultCoroutineScope();
    /* access modifiers changed from: private */
    public final MutableSharedFlow<StreamEvent<?>> _mainObservable;
    private final BleService bleService;
    private List<? extends Device> lastRegisteredDevices;
    private final SharedFlow<StreamEvent<?>> mainObservable;
    /* access modifiers changed from: private */
    public final Mutex mqttMutex;
    private final StateFlow<Boolean> mqttReconnected;
    /* access modifiers changed from: private */
    public final MqttService mqttService;
    /* access modifiers changed from: private */
    public final StompService stompService;

    public CoroutineContext getCoroutineContext() {
        return this.$$delegate_0.getCoroutineContext();
    }

    public StreamService(MqttService mqttService2, StompService stompService2, BleService bleService2, final NetworkMonitor networkMonitor) {
        Intrinsics.checkNotNullParameter(mqttService2, "mqttService");
        Intrinsics.checkNotNullParameter(stompService2, "stompService");
        Intrinsics.checkNotNullParameter(bleService2, "bleService");
        Intrinsics.checkNotNullParameter(networkMonitor, "networkMonitor");
        this.mqttService = mqttService2;
        this.stompService = stompService2;
        this.bleService = bleService2;
        MutableSharedFlow<StreamEvent<?>> MutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 64, (BufferOverflow) null, 5, (Object) null);
        this._mainObservable = MutableSharedFlow$default;
        this.mainObservable = MutableSharedFlow$default;
        this.mqttReconnected = mqttService2.getMqttReconnected();
        this.mqttMutex = MutexKt.Mutex$default(false, 1, (Object) null);
        setAllListeners();
        Job unused = BuildersKt__Builders_commonKt.launch$default(this, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), 3, (Object) null);
    }

    public final BleService getBleService() {
        return this.bleService;
    }

    public final SharedFlow<StreamEvent<?>> getMainObservable() {
        return this.mainObservable;
    }

    public final StateFlow<Boolean> getMqttReconnected() {
        return this.mqttReconnected;
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.blueair.livestream.StreamService$1", f = "StreamService.kt", i = {}, l = {50}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.blueair.livestream.StreamService$1  reason: invalid class name */
    /* compiled from: StreamService.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(networkMonitor, this, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Flow<Boolean> connectivityStatus = networkMonitor.getConnectivityStatus();
                final StreamService streamService = this;
                this.label = 1;
                if (connectivityStatus.collect(new FlowCollector() {
                    public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                        return emit(((Boolean) obj).booleanValue(), (Continuation<? super Unit>) continuation);
                    }

                    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0065, code lost:
                        if (r11.goOnline(r0) == r1) goto L_0x00fb;
                     */
                    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00e5, code lost:
                        if (r2.registerDevices(r3, r0) == r1) goto L_0x00fb;
                     */
                    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00f9, code lost:
                        if (r11.goOffline(r0) == r1) goto L_0x00fb;
                     */
                    /* JADX WARNING: Removed duplicated region for block: B:16:0x0052  */
                    /* JADX WARNING: Removed duplicated region for block: B:22:0x0071  */
                    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public final java.lang.Object emit(boolean r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
                        /*
                            r9 = this;
                            boolean r0 = r11 instanceof com.blueair.livestream.StreamService$1$1$emit$1
                            if (r0 == 0) goto L_0x0014
                            r0 = r11
                            com.blueair.livestream.StreamService$1$1$emit$1 r0 = (com.blueair.livestream.StreamService$1$1$emit$1) r0
                            int r1 = r0.label
                            r2 = -2147483648(0xffffffff80000000, float:-0.0)
                            r1 = r1 & r2
                            if (r1 == 0) goto L_0x0014
                            int r11 = r0.label
                            int r11 = r11 - r2
                            r0.label = r11
                            goto L_0x0019
                        L_0x0014:
                            com.blueair.livestream.StreamService$1$1$emit$1 r0 = new com.blueair.livestream.StreamService$1$1$emit$1
                            r0.<init>(r9, r11)
                        L_0x0019:
                            java.lang.Object r11 = r0.result
                            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                            int r2 = r0.label
                            r3 = 3
                            r4 = 2
                            r5 = 1
                            if (r2 == 0) goto L_0x0052
                            if (r2 == r5) goto L_0x004c
                            if (r2 == r4) goto L_0x003b
                            if (r2 != r3) goto L_0x0033
                            boolean r10 = r0.Z$0
                            kotlin.ResultKt.throwOnFailure(r11)
                            goto L_0x00fc
                        L_0x0033:
                            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
                            r10.<init>(r11)
                            throw r10
                        L_0x003b:
                            int r10 = r0.I$0
                            boolean r10 = r0.Z$0
                            java.lang.Object r10 = r0.L$1
                            java.util.List r10 = (java.util.List) r10
                            java.lang.Object r10 = r0.L$0
                            java.util.List r10 = (java.util.List) r10
                            kotlin.ResultKt.throwOnFailure(r11)
                            goto L_0x00e8
                        L_0x004c:
                            boolean r10 = r0.Z$0
                            kotlin.ResultKt.throwOnFailure(r11)
                            goto L_0x0069
                        L_0x0052:
                            kotlin.ResultKt.throwOnFailure(r11)
                            if (r10 == 0) goto L_0x00eb
                            com.blueair.livestream.StreamService r11 = r3
                            io.flatcircle.stomp.StompService r11 = r11.stompService
                            r0.Z$0 = r10
                            r0.label = r5
                            java.lang.Object r11 = r11.goOnline(r0)
                            if (r11 != r1) goto L_0x0069
                            goto L_0x00fb
                        L_0x0069:
                            com.blueair.livestream.StreamService r11 = r3
                            java.util.List r11 = r11.getLastRegisteredDevices()
                            if (r11 == 0) goto L_0x00e8
                            com.blueair.livestream.StreamService r2 = r3
                            r3 = r11
                            java.lang.Iterable r3 = (java.lang.Iterable) r3
                            java.util.ArrayList r5 = new java.util.ArrayList
                            r5.<init>()
                            java.util.Collection r5 = (java.util.Collection) r5
                            java.util.Iterator r3 = r3.iterator()
                        L_0x0081:
                            boolean r6 = r3.hasNext()
                            if (r6 == 0) goto L_0x0093
                            java.lang.Object r6 = r3.next()
                            boolean r7 = r6 instanceof com.blueair.core.model.HasAblCloudFunctions
                            if (r7 == 0) goto L_0x0081
                            r5.add(r6)
                            goto L_0x0081
                        L_0x0093:
                            java.util.List r5 = (java.util.List) r5
                            java.lang.Iterable r5 = (java.lang.Iterable) r5
                            java.util.ArrayList r3 = new java.util.ArrayList
                            r3.<init>()
                            java.util.Collection r3 = (java.util.Collection) r3
                            java.util.Iterator r5 = r5.iterator()
                        L_0x00a2:
                            boolean r6 = r5.hasNext()
                            if (r6 == 0) goto L_0x00bf
                            java.lang.Object r6 = r5.next()
                            r7 = r6
                            com.blueair.core.model.HasAblCloudFunctions r7 = (com.blueair.core.model.HasAblCloudFunctions) r7
                            int r7 = r7.getTypeIndex()
                            com.blueair.core.model.DeviceType$Icp r8 = com.blueair.core.model.DeviceType.Icp.INSTANCE
                            int r8 = r8.getIndex()
                            if (r7 == r8) goto L_0x00a2
                            r3.add(r6)
                            goto L_0x00a2
                        L_0x00bf:
                            java.util.List r3 = (java.util.List) r3
                            r5 = r3
                            java.util.Collection r5 = (java.util.Collection) r5
                            boolean r5 = r5.isEmpty()
                            if (r5 != 0) goto L_0x00e8
                            io.flatcircle.stomp.StompService r2 = r2.stompService
                            java.lang.Object r11 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r11)
                            r0.L$0 = r11
                            java.lang.Object r11 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r3)
                            r0.L$1 = r11
                            r0.Z$0 = r10
                            r10 = 0
                            r0.I$0 = r10
                            r0.label = r4
                            java.lang.Object r10 = r2.registerDevices(r3, r0)
                            if (r10 != r1) goto L_0x00e8
                            goto L_0x00fb
                        L_0x00e8:
                            kotlin.Unit r10 = kotlin.Unit.INSTANCE
                            return r10
                        L_0x00eb:
                            com.blueair.livestream.StreamService r11 = r3
                            io.flatcircle.stomp.StompService r11 = r11.stompService
                            r0.Z$0 = r10
                            r0.label = r3
                            java.lang.Object r10 = r11.goOffline(r0)
                            if (r10 != r1) goto L_0x00fc
                        L_0x00fb:
                            return r1
                        L_0x00fc:
                            kotlin.Unit r10 = kotlin.Unit.INSTANCE
                            return r10
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.blueair.livestream.StreamService.AnonymousClass1.AnonymousClass1.emit(boolean, kotlin.coroutines.Continuation):java.lang.Object");
                    }
                }, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    private final void setAllListeners() {
        CoroutineScope coroutineScope = this;
        Job unused = BuildersKt__Builders_commonKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new StreamService$setAllListeners$1(this, (Continuation<? super StreamService$setAllListeners$1>) null), 3, (Object) null);
        Job unused2 = BuildersKt__Builders_commonKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new StreamService$setAllListeners$2(this, (Continuation<? super StreamService$setAllListeners$2>) null), 3, (Object) null);
        Job unused3 = BuildersKt__Builders_commonKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new StreamService$setAllListeners$3(this, (Continuation<? super StreamService$setAllListeners$3>) null), 3, (Object) null);
    }

    public final Object restartStomp(Continuation<? super Unit> continuation) {
        Object restart = this.stompService.restart(continuation);
        return restart == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? restart : Unit.INSTANCE;
    }

    public final void resubscribeMqttRt5s(String str) {
        Intrinsics.checkNotNullParameter(str, DeviceDataEntity.DEVICE_ID);
        this.mqttService.resubscribeRt5s(str);
    }

    public final List<Device> getLastRegisteredDevices() {
        return this.lastRegisteredDevices;
    }

    public final void setLastRegisteredDevices(List<? extends Device> list) {
        this.lastRegisteredDevices = list;
    }

    public final void registerDevices(List<? extends Device> list) {
        Intrinsics.checkNotNullParameter(list, "devices");
        Timber.Forest forest = Timber.Forest;
        forest.v("Registering devices for StreamService, devices = " + list, new Object[0]);
        this.lastRegisteredDevices = list;
        CoroutineScope coroutineScope = this;
        Job unused = BuildersKt__Builders_commonKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new StreamService$registerDevices$1(this, list, (Continuation<? super StreamService$registerDevices$1>) null), 3, (Object) null);
        Job unused2 = BuildersKt__Builders_commonKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new StreamService$registerDevices$2(list, this, (Continuation<? super StreamService$registerDevices$2>) null), 3, (Object) null);
        Job unused3 = BuildersKt__Builders_commonKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new StreamService$registerDevices$3(list, this, (Continuation<? super StreamService$registerDevices$3>) null), 3, (Object) null);
    }

    public final void unregisterBleDevice(String str) {
        Intrinsics.checkNotNullParameter(str, "uuid");
        this.bleService.unregister(str);
    }

    public final Object clear(Continuation<? super Unit> continuation) {
        this.lastRegisteredDevices = CollectionsKt.emptyList();
        this.mqttService.clear();
        Object clear = this.stompService.clear(continuation);
        return clear == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? clear : Unit.INSTANCE;
    }
}
