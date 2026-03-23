package com.blueair.antifake.viewmodel;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.antifake.viewmodel.AntiFakeViewModel", f = "AntiFakeViewModel.kt", i = {0, 1, 2}, l = {283, 285, 288}, m = "resetFilterByBluetooth", n = {"cipherText", "cipherText", "cipherText"}, s = {"L$0", "L$0", "L$0"})
/* compiled from: AntiFakeViewModel.kt */
final class AntiFakeViewModel$resetFilterByBluetooth$2 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AntiFakeViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AntiFakeViewModel$resetFilterByBluetooth$2(AntiFakeViewModel antiFakeViewModel, Continuation<? super AntiFakeViewModel$resetFilterByBluetooth$2> continuation) {
        super(continuation);
        this.this$0 = antiFakeViewModel;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.resetFilterByBluetooth((String) null, this);
    }
}
