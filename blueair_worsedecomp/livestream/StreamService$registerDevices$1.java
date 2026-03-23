package com.blueair.livestream;

import com.blueair.core.model.Device;
import com.blueair.core.model.HasBlueCloudFunctions;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.sync.Mutex;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.livestream.StreamService$registerDevices$1", f = "StreamService.kt", i = {0, 0}, l = {150}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "$i$f$withLock"}, s = {"L$0", "I$0"})
/* compiled from: StreamService.kt */
final class StreamService$registerDevices$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<Device> $devices;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ StreamService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StreamService$registerDevices$1(StreamService streamService, List<? extends Device> list, Continuation<? super StreamService$registerDevices$1> continuation) {
        super(2, continuation);
        this.this$0 = streamService;
        this.$devices = list;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new StreamService$registerDevices$1(this.this$0, this.$devices, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((StreamService$registerDevices$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: finally extract failed */
    public final Object invokeSuspend(Object obj) {
        Mutex mutex;
        List<Device> list;
        StreamService streamService;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Mutex access$getMqttMutex$p = this.this$0.mqttMutex;
            list = this.$devices;
            StreamService streamService2 = this.this$0;
            this.L$0 = access$getMqttMutex$p;
            this.L$1 = list;
            this.L$2 = streamService2;
            this.I$0 = 0;
            this.label = 1;
            if (access$getMqttMutex$p.lock((Object) null, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            mutex = access$getMqttMutex$p;
            streamService = streamService2;
        } else if (i == 1) {
            streamService = (StreamService) this.L$2;
            list = (List) this.L$1;
            mutex = (Mutex) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        try {
            Collection arrayList = new ArrayList();
            for (Object next : list) {
                if (next instanceof HasBlueCloudFunctions) {
                    arrayList.add(next);
                }
            }
            List list2 = (List) arrayList;
            if (!list2.isEmpty()) {
                streamService.mqttService.registerDevices(list2);
            }
            Unit unit = Unit.INSTANCE;
            mutex.unlock((Object) null);
            return Unit.INSTANCE;
        } catch (Throwable th) {
            mutex.unlock((Object) null);
            throw th;
        }
    }
}
