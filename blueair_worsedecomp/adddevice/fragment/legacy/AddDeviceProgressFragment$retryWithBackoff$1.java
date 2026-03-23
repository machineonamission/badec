package com.blueair.adddevice.fragment.legacy;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.adddevice.fragment.legacy.AddDeviceProgressFragment", f = "AddDeviceProgressFragment.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2}, l = {171, 174, 177}, m = "retryWithBackoff", n = {"block", "currentDelay", "times", "initialDelay", "maxDelay", "factor", "it", "$i$a$-repeat-AddDeviceProgressFragment$retryWithBackoff$2", "block", "currentDelay", "times", "initialDelay", "maxDelay", "factor", "it", "$i$a$-repeat-AddDeviceProgressFragment$retryWithBackoff$2", "block", "currentDelay", "times", "initialDelay", "maxDelay", "factor"}, s = {"L$0", "L$1", "I$0", "J$0", "J$1", "D$0", "I$3", "I$4", "L$0", "L$1", "I$0", "J$0", "J$1", "D$0", "I$3", "I$4", "L$0", "L$1", "I$0", "J$0", "J$1", "D$0"})
/* compiled from: AddDeviceProgressFragment.kt */
final class AddDeviceProgressFragment$retryWithBackoff$1<T> extends ContinuationImpl {
    double D$0;
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    int I$4;
    long J$0;
    long J$1;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AddDeviceProgressFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AddDeviceProgressFragment$retryWithBackoff$1(AddDeviceProgressFragment addDeviceProgressFragment, Continuation<? super AddDeviceProgressFragment$retryWithBackoff$1> continuation) {
        super(continuation);
        this.this$0 = addDeviceProgressFragment;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.retryWithBackoff(0, 0, 0, 0.0d, (Function1) null, this);
    }
}
