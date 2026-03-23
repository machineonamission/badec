package com.blueair.push;

import com.blueair.auth.AuthService;
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
@DebugMetadata(c = "com.blueair.push.NotificationService$setNotificationToken$1$1", f = "NotificationService.kt", i = {}, l = {96}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: NotificationService.kt */
final class NotificationService$setNotificationToken$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AuthService $this_run;
    final /* synthetic */ String $token;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NotificationService$setNotificationToken$1$1(AuthService authService, String str, Continuation<? super NotificationService$setNotificationToken$1$1> continuation) {
        super(2, continuation);
        this.$this_run = authService;
        this.$token = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NotificationService$setNotificationToken$1$1(this.$this_run, this.$token, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((NotificationService$setNotificationToken$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (this.$this_run.setPushToken(this.$token, this) == coroutine_suspended) {
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
