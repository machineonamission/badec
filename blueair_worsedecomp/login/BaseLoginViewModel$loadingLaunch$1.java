package com.blueair.login;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.login.BaseLoginViewModel$loadingLaunch$1", f = "BaseLoginViewModel.kt", i = {}, l = {139}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: BaseLoginViewModel.kt */
final class BaseLoginViewModel$loadingLaunch$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Continuation<? super Unit>, Object> $bloc;
    int label;
    final /* synthetic */ BaseLoginViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BaseLoginViewModel$loadingLaunch$1(BaseLoginViewModel baseLoginViewModel, Function1<? super Continuation<? super Unit>, ? extends Object> function1, Continuation<? super BaseLoginViewModel$loadingLaunch$1> continuation) {
        super(2, continuation);
        this.this$0 = baseLoginViewModel;
        this.$bloc = function1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BaseLoginViewModel$loadingLaunch$1(this.this$0, this.$bloc, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BaseLoginViewModel$loadingLaunch$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.get_loading().setValue(Boxing.boxBoolean(true));
            Function1<Continuation<? super Unit>, Object> function1 = this.$bloc;
            this.label = 1;
            if (function1.invoke(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.this$0.get_loading().setValue(Boxing.boxBoolean(false));
        return Unit.INSTANCE;
    }
}
