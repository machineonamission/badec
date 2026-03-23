package com.blueair.login;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.login.RegisterViewModel$loadDataCenter$1", f = "RegisterViewModel.kt", i = {}, l = {58}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: RegisterViewModel.kt */
final class RegisterViewModel$loadDataCenter$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ RegisterViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RegisterViewModel$loadDataCenter$1(RegisterViewModel registerViewModel, Continuation<? super RegisterViewModel$loadDataCenter$1> continuation) {
        super(1, continuation);
        this.this$0 = registerViewModel;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new RegisterViewModel$loadDataCenter$1(this.this$0, continuation);
    }

    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((RegisterViewModel$loadDataCenter$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (this.this$0.updateGigyaDataCenter(this) == coroutine_suspended) {
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
