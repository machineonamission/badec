package io.flatcircle.coroutinehelper;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0004\"\u0004\b\u0003\u0010\u0005\"\u0004\b\u0004\u0010\u00062\u0006\u0010\u0007\u001a\u0002H\u00042\u0006\u0010\b\u001a\u0002H\u00052\u0006\u0010\t\u001a\u0002H\u0006H\n¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"<anonymous>", "", "Input1", "Input2", "Output1", "Output2", "Output3", "output1", "output2", "output3", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V"}, k = 3, mv = {1, 1, 15})
/* compiled from: CallbackFlattening.kt */
final class CallbackFlatteningKt$suspendAsyncTripleResult$4$1 extends Lambda implements Function3<Output1, Output2, Output3, Unit> {
    final /* synthetic */ Continuation $continuation;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CallbackFlatteningKt$suspendAsyncTripleResult$4$1(Continuation continuation) {
        super(3);
        this.$continuation = continuation;
    }

    public final void invoke(Output1 output1, Output2 output2, Output3 output3) {
        Continuation continuation = this.$continuation;
        Triple triple = new Triple(output1, output2, output3);
        Result.Companion companion = Result.Companion;
        continuation.resumeWith(Result.m9366constructorimpl(triple));
    }
}
