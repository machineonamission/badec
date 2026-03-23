package com.blueair.adddevice.viewmodel;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.adddevice.viewmodel.FinalizeViewModel", f = "FinalizeViewModel.kt", i = {0, 0}, l = {36}, m = "commitDeviceName", n = {"deviceUuid", "deviceName"}, s = {"L$0", "L$1"})
/* compiled from: FinalizeViewModel.kt */
final class FinalizeViewModel$commitDeviceName$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FinalizeViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FinalizeViewModel$commitDeviceName$1(FinalizeViewModel finalizeViewModel, Continuation<? super FinalizeViewModel$commitDeviceName$1> continuation) {
        super(continuation);
        this.this$0 = finalizeViewModel;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.commitDeviceName((String) null, (String) null, this);
    }
}
