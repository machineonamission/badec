package com.blueair.android.viewmodel;

import com.blueair.core.model.TrackedLocation;
import com.blueair.outdoor.service.OutdoorService;
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
@DebugMetadata(c = "com.blueair.android.viewmodel.OutdoorLocationViewModel$refreshAqiData$1", f = "OutdoorLocationViewModel.kt", i = {0, 0}, l = {88}, m = "invokeSuspend", n = {"it", "$i$a$-let-OutdoorLocationViewModel$refreshAqiData$1$1"}, s = {"L$0", "I$0"})
/* compiled from: OutdoorLocationViewModel.kt */
final class OutdoorLocationViewModel$refreshAqiData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int I$0;
    Object L$0;
    int label;
    final /* synthetic */ OutdoorLocationViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OutdoorLocationViewModel$refreshAqiData$1(OutdoorLocationViewModel outdoorLocationViewModel, Continuation<? super OutdoorLocationViewModel$refreshAqiData$1> continuation) {
        super(2, continuation);
        this.this$0 = outdoorLocationViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OutdoorLocationViewModel$refreshAqiData$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((OutdoorLocationViewModel$refreshAqiData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            TrackedLocation location = this.this$0.getLocation();
            if (location != null) {
                OutdoorService access$getOutdoorService = this.this$0.getOutdoorService();
                this.L$0 = SpillingKt.nullOutSpilledVariable(location);
                this.I$0 = 0;
                this.label = 1;
                if (OutdoorService.fetchAqiData$default(access$getOutdoorService, location, false, this, 2, (Object) null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else if (i == 1) {
            TrackedLocation trackedLocation = (TrackedLocation) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
