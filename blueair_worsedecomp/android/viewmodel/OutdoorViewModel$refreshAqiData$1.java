package com.blueair.android.viewmodel;

import com.blueair.core.model.TrackedLocation;
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
@DebugMetadata(c = "com.blueair.android.viewmodel.OutdoorViewModel$refreshAqiData$1", f = "OutdoorViewModel.kt", i = {}, l = {65}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: OutdoorViewModel.kt */
final class OutdoorViewModel$refreshAqiData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ TrackedLocation $location;
    int label;
    final /* synthetic */ OutdoorViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OutdoorViewModel$refreshAqiData$1(OutdoorViewModel outdoorViewModel, TrackedLocation trackedLocation, Continuation<? super OutdoorViewModel$refreshAqiData$1> continuation) {
        super(2, continuation);
        this.this$0 = outdoorViewModel;
        this.$location = trackedLocation;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OutdoorViewModel$refreshAqiData$1(this.this$0, this.$location, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((OutdoorViewModel$refreshAqiData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (this.this$0.getOutdoorService().fetchAqiData(this.$location, true, this) == coroutine_suspended) {
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
