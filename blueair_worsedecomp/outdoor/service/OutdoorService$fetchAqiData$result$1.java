package com.blueair.outdoor.service;

import com.blueair.core.model.AqiData;
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

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n"}, d2 = {"<anonymous>", "", "it", "", "Lcom/blueair/core/model/AqiData;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.outdoor.service.OutdoorService$fetchAqiData$result$1", f = "OutdoorService.kt", i = {0}, l = {164}, m = "invokeSuspend", n = {"it"}, s = {"L$0"})
/* compiled from: OutdoorService.kt */
final class OutdoorService$fetchAqiData$result$1 extends SuspendLambda implements Function2<List<? extends AqiData>, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ OutdoorService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OutdoorService$fetchAqiData$result$1(OutdoorService outdoorService, Continuation<? super OutdoorService$fetchAqiData$result$1> continuation) {
        super(2, continuation);
        this.this$0 = outdoorService;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        OutdoorService$fetchAqiData$result$1 outdoorService$fetchAqiData$result$1 = new OutdoorService$fetchAqiData$result$1(this.this$0, continuation);
        outdoorService$fetchAqiData$result$1.L$0 = obj;
        return outdoorService$fetchAqiData$result$1;
    }

    public final Object invoke(List<AqiData> list, Continuation<? super Unit> continuation) {
        return ((OutdoorService$fetchAqiData$result$1) create(list, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        List list = (List) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.L$0 = SpillingKt.nullOutSpilledVariable(list);
            this.label = 1;
            if (this.this$0.trackedLocationRepository.insertAqiData((List<AqiData>) list, (Continuation<? super Unit>) this) == coroutine_suspended) {
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
