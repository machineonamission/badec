package com.blueair.devicemanager;

import com.blueair.api.restapi.SimpleResponse;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/blueair/api/restapi/SimpleResponse;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.devicemanager.DeviceManager$queueApiCall$2$1", f = "DeviceManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: DeviceManager.kt */
final class DeviceManager$queueApiCall$2$1 extends SuspendLambda implements Function2<SimpleResponse, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DeviceManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeviceManager$queueApiCall$2$1(DeviceManager deviceManager, Continuation<? super DeviceManager$queueApiCall$2$1> continuation) {
        super(2, continuation);
        this.this$0 = deviceManager;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DeviceManager$queueApiCall$2$1(this.this$0, continuation);
    }

    public final Object invoke(SimpleResponse simpleResponse, Continuation<? super Unit> continuation) {
        return ((DeviceManager$queueApiCall$2$1) create(simpleResponse, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.lastApiCallTime = System.currentTimeMillis();
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
