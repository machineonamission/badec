package com.blueair.adddevice.viewmodel;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.adddevice.viewmodel.FinalizeViewModel", f = "FinalizeViewModel.kt", i = {}, l = {27}, m = "setPushToken", n = {}, s = {})
/* compiled from: FinalizeViewModel.kt */
final class FinalizeViewModel$setPushToken$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FinalizeViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FinalizeViewModel$setPushToken$1(FinalizeViewModel finalizeViewModel, Continuation<? super FinalizeViewModel$setPushToken$1> continuation) {
        super(continuation);
        this.this$0 = finalizeViewModel;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.setPushToken(this);
    }
}
