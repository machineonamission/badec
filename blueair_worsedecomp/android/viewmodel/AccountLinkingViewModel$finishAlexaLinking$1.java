package com.blueair.android.viewmodel;

import com.blueair.android.viewmodel.LinkingState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.android.viewmodel.AccountLinkingViewModel$finishAlexaLinking$1", f = "AccountLinkingViewModel.kt", i = {}, l = {118}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: AccountLinkingViewModel.kt */
final class AccountLinkingViewModel$finishAlexaLinking$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $code;
    Object L$0;
    int label;
    final /* synthetic */ AccountLinkingViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AccountLinkingViewModel$finishAlexaLinking$1(AccountLinkingViewModel accountLinkingViewModel, String str, Continuation<? super AccountLinkingViewModel$finishAlexaLinking$1> continuation) {
        super(2, continuation);
        this.this$0 = accountLinkingViewModel;
        this.$code = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AccountLinkingViewModel$finishAlexaLinking$1(this.this$0, this.$code, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AccountLinkingViewModel$finishAlexaLinking$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        MutableStateFlow mutableStateFlow;
        LinkingState linkingState;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0._state.setValue(LinkingState.Loading.INSTANCE);
            MutableStateFlow access$get_state$p = this.this$0._state;
            this.L$0 = access$get_state$p;
            this.label = 1;
            Object alexaLinkAccount = this.this$0.getDeviceManager().alexaLinkAccount(this.$code, this);
            if (alexaLinkAccount == coroutine_suspended) {
                return coroutine_suspended;
            }
            mutableStateFlow = access$get_state$p;
            obj = alexaLinkAccount;
        } else if (i == 1) {
            mutableStateFlow = (MutableStateFlow) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (((Boolean) obj).booleanValue()) {
            linkingState = LinkingState.Success.INSTANCE;
        } else {
            linkingState = LinkingState.Failed.INSTANCE;
        }
        mutableStateFlow.setValue(linkingState);
        return Unit.INSTANCE;
    }
}
