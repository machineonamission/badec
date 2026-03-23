package com.blueair.adddevice.service;

import io.flatcircle.coroutinehelper.ApiResult;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.adddevice.service.AddDeviceService$otaUpdateRunningCheck$1$1", f = "AddDeviceService.kt", i = {}, l = {876}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: AddDeviceService.kt */
final class AddDeviceService$otaUpdateRunningCheck$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.BooleanRef $isRunning;
    final /* synthetic */ Deferred<ApiResult<Boolean>> $job;
    Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AddDeviceService$otaUpdateRunningCheck$1$1(Ref.BooleanRef booleanRef, Deferred<? extends ApiResult<Boolean>> deferred, Continuation<? super AddDeviceService$otaUpdateRunningCheck$1$1> continuation) {
        super(2, continuation);
        this.$isRunning = booleanRef;
        this.$job = deferred;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AddDeviceService$otaUpdateRunningCheck$1$1(this.$isRunning, this.$job, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AddDeviceService$otaUpdateRunningCheck$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Ref.BooleanRef booleanRef;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        boolean z = true;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Ref.BooleanRef booleanRef2 = this.$isRunning;
            this.L$0 = booleanRef2;
            this.label = 1;
            Object await = this.$job.await(this);
            if (await == coroutine_suspended) {
                return coroutine_suspended;
            }
            booleanRef = booleanRef2;
            obj = await;
        } else if (i == 1) {
            booleanRef = (Ref.BooleanRef) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Boolean bool = (Boolean) ((ApiResult) obj).getOrNull();
        if (bool != null) {
            z = bool.booleanValue();
        }
        booleanRef.element = z;
        return Unit.INSTANCE;
    }
}
