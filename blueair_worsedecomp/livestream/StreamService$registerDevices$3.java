package com.blueair.livestream;

import com.blueair.core.model.Device;
import com.blueair.core.model.HasBleFunctions;
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

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.livestream.StreamService$registerDevices$3", f = "StreamService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: StreamService.kt */
final class StreamService$registerDevices$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<Device> $devices;
    int label;
    final /* synthetic */ StreamService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StreamService$registerDevices$3(List<? extends Device> list, StreamService streamService, Continuation<? super StreamService$registerDevices$3> continuation) {
        super(2, continuation);
        this.$devices = list;
        this.this$0 = streamService;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new StreamService$registerDevices$3(this.$devices, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((StreamService$registerDevices$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Collection arrayList = new ArrayList();
            for (Object next : this.$devices) {
                if (next instanceof HasBleFunctions) {
                    arrayList.add(next);
                }
            }
            List<HasBleFunctions> list = (List) arrayList;
            if (!list.isEmpty()) {
                for (HasBleFunctions hasBleFunctions : list) {
                    this.this$0.getBleService().register(hasBleFunctions.getUid(), hasBleFunctions.getMac());
                }
                this.this$0.getBleService().onResume();
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
