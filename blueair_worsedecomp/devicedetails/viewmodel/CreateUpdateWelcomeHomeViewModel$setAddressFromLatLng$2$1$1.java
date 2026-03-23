package com.blueair.devicedetails.viewmodel;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.devicedetails.viewmodel.CreateUpdateWelcomeHomeViewModel$setAddressFromLatLng$2$1$1", f = "CreateUpdateWelcomeHomeViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: CreateUpdateWelcomeHomeViewModel.kt */
final class CreateUpdateWelcomeHomeViewModel$setAddressFromLatLng$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $onAddressFetch;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CreateUpdateWelcomeHomeViewModel$setAddressFromLatLng$2$1$1(Function0<Unit> function0, Continuation<? super CreateUpdateWelcomeHomeViewModel$setAddressFromLatLng$2$1$1> continuation) {
        super(2, continuation);
        this.$onAddressFetch = function0;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CreateUpdateWelcomeHomeViewModel$setAddressFromLatLng$2$1$1(this.$onAddressFetch, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CreateUpdateWelcomeHomeViewModel$setAddressFromLatLng$2$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.$onAddressFetch.invoke();
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
