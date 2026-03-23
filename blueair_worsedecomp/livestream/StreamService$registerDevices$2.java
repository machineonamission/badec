package com.blueair.livestream;

import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceType;
import com.blueair.core.model.HasAblCloudFunctions;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.livestream.StreamService$registerDevices$2", f = "StreamService.kt", i = {0}, l = {120}, m = "invokeSuspend", n = {"stompDevices"}, s = {"L$0"})
/* compiled from: StreamService.kt */
final class StreamService$registerDevices$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<Device> $devices;
    Object L$0;
    int label;
    final /* synthetic */ StreamService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StreamService$registerDevices$2(List<? extends Device> list, StreamService streamService, Continuation<? super StreamService$registerDevices$2> continuation) {
        super(2, continuation);
        this.$devices = list;
        this.this$0 = streamService;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new StreamService$registerDevices$2(this.$devices, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((StreamService$registerDevices$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Collection arrayList = new ArrayList();
            for (Object next : this.$devices) {
                if (next instanceof HasAblCloudFunctions) {
                    arrayList.add(next);
                }
            }
            Collection arrayList2 = new ArrayList();
            for (Object next2 : (List) arrayList) {
                if (((HasAblCloudFunctions) next2).getTypeIndex() != DeviceType.Icp.INSTANCE.getIndex()) {
                    arrayList2.add(next2);
                }
            }
            List list = (List) arrayList2;
            if (!list.isEmpty()) {
                this.L$0 = SpillingKt.nullOutSpilledVariable(list);
                this.label = 1;
                if (this.this$0.stompService.registerDevices(list, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else if (i == 1) {
            List list2 = (List) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
