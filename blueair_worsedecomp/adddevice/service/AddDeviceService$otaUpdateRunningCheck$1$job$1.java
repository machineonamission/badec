package com.blueair.adddevice.service;

import com.blueair.adddevice.model.AddDeviceState;
import io.flatcircle.coroutinehelper.ApiResult;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lio/flatcircle/coroutinehelper/ApiResult;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.adddevice.service.AddDeviceService$otaUpdateRunningCheck$1$job$1", f = "AddDeviceService.kt", i = {}, l = {872}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: AddDeviceService.kt */
final class AddDeviceService$otaUpdateRunningCheck$1$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ApiResult<Boolean>>, Object> {
    final /* synthetic */ AddDeviceState $currentState;
    int label;
    final /* synthetic */ AddDeviceService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AddDeviceService$otaUpdateRunningCheck$1$job$1(AddDeviceService addDeviceService, AddDeviceState addDeviceState, Continuation<? super AddDeviceService$otaUpdateRunningCheck$1$job$1> continuation) {
        super(2, continuation);
        this.this$0 = addDeviceService;
        this.$currentState = addDeviceState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AddDeviceService$otaUpdateRunningCheck$1$job$1(this.this$0, this.$currentState, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ApiResult<Boolean>> continuation) {
        return ((AddDeviceService$otaUpdateRunningCheck$1$job$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            Object legacyOnBoardingOTAUpdateRunningCheck = this.this$0.deviceManager.legacyOnBoardingOTAUpdateRunningCheck(this.$currentState.getDeviceInfo().getId(), this);
            return legacyOnBoardingOTAUpdateRunningCheck == coroutine_suspended ? coroutine_suspended : legacyOnBoardingOTAUpdateRunningCheck;
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
            return obj;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
