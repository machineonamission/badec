package com.blueair.devicedetails.viewmodel;

import com.blueair.api.restapi.SimpleResponse;
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

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel$setAlarm$1$1$1$1", f = "DeviceDetailsViewModel.kt", i = {}, l = {459}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: DeviceDetailsViewModel.kt */
final class DeviceDetailsViewModel$setAlarm$1$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<ApiResult<SimpleResponse>, Continuation<? super Unit>, Object> $it;
    final /* synthetic */ ApiResult<SimpleResponse> $result;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeviceDetailsViewModel$setAlarm$1$1$1$1(Function2<? super ApiResult<SimpleResponse>, ? super Continuation<? super Unit>, ? extends Object> function2, ApiResult<SimpleResponse> apiResult, Continuation<? super DeviceDetailsViewModel$setAlarm$1$1$1$1> continuation) {
        super(2, continuation);
        this.$it = function2;
        this.$result = apiResult;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DeviceDetailsViewModel$setAlarm$1$1$1$1(this.$it, this.$result, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DeviceDetailsViewModel$setAlarm$1$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Function2<ApiResult<SimpleResponse>, Continuation<? super Unit>, Object> function2 = this.$it;
            ApiResult<SimpleResponse> apiResult = this.$result;
            this.label = 1;
            if (function2.invoke(apiResult, this) == coroutine_suspended) {
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
