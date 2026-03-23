package com.blueair.adddevice.viewmodel;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.adddevice.viewmodel.FinalizeViewModel", f = "FinalizeViewModel.kt", i = {0, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5}, l = {53, 58, 62, 65, 67, 68}, m = "ensureInitialOnline", n = {"deviceUuid", "deviceUuid", "checkCount", "result", "deviceUuid", "checkCount", "result", "deviceUuid", "checkCount", "result", "deviceUuid", "checkCount", "result", "deviceUuid", "checkCount", "result"}, s = {"L$0", "L$0", "I$0", "I$1", "L$0", "I$0", "I$1", "L$0", "I$0", "I$1", "L$0", "I$0", "I$1", "L$0", "I$0", "I$1"})
/* compiled from: FinalizeViewModel.kt */
final class FinalizeViewModel$ensureInitialOnline$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FinalizeViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FinalizeViewModel$ensureInitialOnline$1(FinalizeViewModel finalizeViewModel, Continuation<? super FinalizeViewModel$ensureInitialOnline$1> continuation) {
        super(continuation);
        this.this$0 = finalizeViewModel;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.ensureInitialOnline((String) null, this);
    }
}
