package com.blueair.login;

import com.blueair.auth.AuthService;
import com.blueair.auth.LogoutReason;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import timber.log.Timber;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.login.DisableIoTConfirmViewModel$disableIoT$1", f = "DisableIoTConfirmViewModel.kt", i = {0, 0, 0}, l = {31}, m = "invokeSuspend", n = {"$this$launch", "$this$invokeSuspend_u24lambda_u240", "$i$a$-runCatching-DisableIoTConfirmViewModel$disableIoT$1$1"}, s = {"L$0", "L$2", "I$0"})
/* compiled from: DisableIoTConfirmViewModel.kt */
final class DisableIoTConfirmViewModel$disableIoT$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ DisableIoTConfirmViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DisableIoTConfirmViewModel$disableIoT$1(DisableIoTConfirmViewModel disableIoTConfirmViewModel, Continuation<? super DisableIoTConfirmViewModel$disableIoT$1> continuation) {
        super(2, continuation);
        this.this$0 = disableIoTConfirmViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DisableIoTConfirmViewModel$disableIoT$1 disableIoTConfirmViewModel$disableIoT$1 = new DisableIoTConfirmViewModel$disableIoT$1(this.this$0, continuation);
        disableIoTConfirmViewModel$disableIoT$1.L$0 = obj;
        return disableIoTConfirmViewModel$disableIoT$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DisableIoTConfirmViewModel$disableIoT$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object obj2;
        DisableIoTConfirmViewModel disableIoTConfirmViewModel;
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Timber.Forest.d("Disabling IoT", new Object[0]);
            this.this$0._state.setValue(DisableIoTState.Disabling);
            DisableIoTConfirmViewModel disableIoTConfirmViewModel2 = this.this$0;
            Result.Companion companion = Result.Companion;
            AuthService access$getAuthService = disableIoTConfirmViewModel2.getAuthService();
            this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
            this.L$1 = disableIoTConfirmViewModel2;
            this.L$2 = SpillingKt.nullOutSpilledVariable(coroutineScope);
            this.I$0 = 0;
            this.label = 1;
            if (access$getAuthService.disableUserAccount(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            disableIoTConfirmViewModel = disableIoTConfirmViewModel2;
        } else if (i == 1) {
            CoroutineScope coroutineScope2 = (CoroutineScope) this.L$2;
            disableIoTConfirmViewModel = (DisableIoTConfirmViewModel) this.L$1;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj2 = Result.m9366constructorimpl(ResultKt.createFailure(th));
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        disableIoTConfirmViewModel.getLogoutService().logOutRegistered(LogoutReason.ACCOUNT_DISABLED);
        obj2 = Result.m9366constructorimpl(Unit.INSTANCE);
        DisableIoTConfirmViewModel disableIoTConfirmViewModel3 = this.this$0;
        if (Result.m9373isSuccessimpl(obj2)) {
            Unit unit = (Unit) obj2;
            Timber.Forest.d("IoT disabled", new Object[0]);
            disableIoTConfirmViewModel3._state.setValue(DisableIoTState.Disabled);
        }
        DisableIoTConfirmViewModel disableIoTConfirmViewModel4 = this.this$0;
        Throwable r7 = Result.m9369exceptionOrNullimpl(obj2);
        if (r7 != null) {
            Timber.Forest.w(r7, "Disabling IoT failed", new Object[0]);
            disableIoTConfirmViewModel4._state.setValue(DisableIoTState.Failed);
        }
        return Unit.INSTANCE;
    }
}
