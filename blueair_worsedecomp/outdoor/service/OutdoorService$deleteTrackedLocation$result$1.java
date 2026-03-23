package com.blueair.outdoor.service;

import com.blueair.core.model.TrackedLocation;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import okhttp3.ResponseBody;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lokhttp3/ResponseBody;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.outdoor.service.OutdoorService$deleteTrackedLocation$result$1", f = "OutdoorService.kt", i = {}, l = {125}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: OutdoorService.kt */
final class OutdoorService$deleteTrackedLocation$result$1 extends SuspendLambda implements Function2<ResponseBody, Continuation<? super Unit>, Object> {
    final /* synthetic */ TrackedLocation $trackedLocation;
    int label;
    final /* synthetic */ OutdoorService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OutdoorService$deleteTrackedLocation$result$1(OutdoorService outdoorService, TrackedLocation trackedLocation, Continuation<? super OutdoorService$deleteTrackedLocation$result$1> continuation) {
        super(2, continuation);
        this.this$0 = outdoorService;
        this.$trackedLocation = trackedLocation;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OutdoorService$deleteTrackedLocation$result$1(this.this$0, this.$trackedLocation, continuation);
    }

    public final Object invoke(ResponseBody responseBody, Continuation<? super Unit> continuation) {
        return ((OutdoorService$deleteTrackedLocation$result$1) create(responseBody, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (this.this$0.trackedLocationRepository.deleteTrackedLocation(this.$trackedLocation, this) == coroutine_suspended) {
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
