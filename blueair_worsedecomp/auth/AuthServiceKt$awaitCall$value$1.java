package com.blueair.auth;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;

@Metadata(d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.auth.AuthServiceKt$awaitCall$value$1", f = "AuthService.kt", i = {}, l = {807}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: AuthService.kt */
final class AuthServiceKt$awaitCall$value$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super T>, Object> {
    final /* synthetic */ Deferred<T> $job;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AuthServiceKt$awaitCall$value$1(Deferred<? extends T> deferred, Continuation<? super AuthServiceKt$awaitCall$value$1> continuation) {
        super(2, continuation);
        this.$job = deferred;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AuthServiceKt$awaitCall$value$1(this.$job, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super T> continuation) {
        return ((AuthServiceKt$awaitCall$value$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            Object await = this.$job.await(this);
            return await == coroutine_suspended ? coroutine_suspended : await;
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
            return obj;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
