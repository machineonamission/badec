package com.blueair.login;

import com.blueair.auth.AuthService;
import com.blueair.auth.LogoutReason;
import com.blueair.login.DeleteAccountState;
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
@DebugMetadata(c = "com.blueair.login.DeleteAccountConfirmViewModel$deleteAccount$1", f = "DeleteAccountConfirmViewModel.kt", i = {0, 0, 0}, l = {35}, m = "invokeSuspend", n = {"$this$launch", "$this$invokeSuspend_u24lambda_u240", "$i$a$-runCatching-DeleteAccountConfirmViewModel$deleteAccount$1$1"}, s = {"L$0", "L$2", "I$0"})
/* compiled from: DeleteAccountConfirmViewModel.kt */
final class DeleteAccountConfirmViewModel$deleteAccount$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ DeleteAccountConfirmViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeleteAccountConfirmViewModel$deleteAccount$1(DeleteAccountConfirmViewModel deleteAccountConfirmViewModel, Continuation<? super DeleteAccountConfirmViewModel$deleteAccount$1> continuation) {
        super(2, continuation);
        this.this$0 = deleteAccountConfirmViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DeleteAccountConfirmViewModel$deleteAccount$1 deleteAccountConfirmViewModel$deleteAccount$1 = new DeleteAccountConfirmViewModel$deleteAccount$1(this.this$0, continuation);
        deleteAccountConfirmViewModel$deleteAccount$1.L$0 = obj;
        return deleteAccountConfirmViewModel$deleteAccount$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DeleteAccountConfirmViewModel$deleteAccount$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object obj2;
        DeleteAccountConfirmViewModel deleteAccountConfirmViewModel;
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Timber.Forest.d("Deleting account", new Object[0]);
            this.this$0._state.setValue(DeleteAccountState.Deleting.INSTANCE);
            DeleteAccountConfirmViewModel deleteAccountConfirmViewModel2 = this.this$0;
            Result.Companion companion = Result.Companion;
            AuthService access$getAuthService = deleteAccountConfirmViewModel2.getAuthService();
            this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
            this.L$1 = deleteAccountConfirmViewModel2;
            this.L$2 = SpillingKt.nullOutSpilledVariable(coroutineScope);
            this.I$0 = 0;
            this.label = 1;
            if (access$getAuthService.deleteAccount(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            deleteAccountConfirmViewModel = deleteAccountConfirmViewModel2;
        } else if (i == 1) {
            CoroutineScope coroutineScope2 = (CoroutineScope) this.L$2;
            deleteAccountConfirmViewModel = (DeleteAccountConfirmViewModel) this.L$1;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj2 = Result.m9366constructorimpl(ResultKt.createFailure(th));
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        deleteAccountConfirmViewModel.getLogoutService().logOutRegistered(LogoutReason.ACCOUNT_DELETED);
        obj2 = Result.m9366constructorimpl(Unit.INSTANCE);
        DeleteAccountConfirmViewModel deleteAccountConfirmViewModel3 = this.this$0;
        if (Result.m9373isSuccessimpl(obj2)) {
            Unit unit = (Unit) obj2;
            Timber.Forest.d("Account deleted", new Object[0]);
            deleteAccountConfirmViewModel3._state.setValue(DeleteAccountState.Deleted.INSTANCE);
        }
        DeleteAccountConfirmViewModel deleteAccountConfirmViewModel4 = this.this$0;
        Throwable r7 = Result.m9369exceptionOrNullimpl(obj2);
        if (r7 != null) {
            Timber.Forest.w(r7, "Delete account failed", new Object[0]);
            deleteAccountConfirmViewModel4._state.setValue(DeleteAccountState.Failed.INSTANCE);
        }
        return Unit.INSTANCE;
    }
}
