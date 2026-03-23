package com.blueair.login;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.login.RegisterViewModel", f = "RegisterViewModel.kt", i = {}, l = {61}, m = "updateGigyaDataCenter", n = {}, s = {})
/* compiled from: RegisterViewModel.kt */
final class RegisterViewModel$updateGigyaDataCenter$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RegisterViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RegisterViewModel$updateGigyaDataCenter$1(RegisterViewModel registerViewModel, Continuation<? super RegisterViewModel$updateGigyaDataCenter$1> continuation) {
        super(continuation);
        this.this$0 = registerViewModel;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.updateGigyaDataCenter(this);
    }
}
