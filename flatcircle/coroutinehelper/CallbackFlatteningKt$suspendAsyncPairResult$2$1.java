package io.flatcircle.coroutinehelper;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u00042\u0006\u0010\u0005\u001a\u0002H\u00032\u0006\u0010\u0006\u001a\u0002H\u0004H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "", "Input", "Output1", "Output2", "output1", "output2", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)V"}, k = 3, mv = {1, 1, 15})
/* compiled from: CallbackFlattening.kt */
final class CallbackFlatteningKt$suspendAsyncPairResult$2$1 extends Lambda implements Function2<Output1, Output2, Unit> {
    final /* synthetic */ Continuation $continuation;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CallbackFlatteningKt$suspendAsyncPairResult$2$1(Continuation continuation) {
        super(2);
        this.$continuation = continuation;
    }

    public final void invoke(Output1 output1, Output2 output2) {
        Continuation continuation = this.$continuation;
        Pair pair = new Pair(output1, output2);
        Result.Companion companion = Result.Companion;
        continuation.resumeWith(Result.m9366constructorimpl(pair));
    }
}
