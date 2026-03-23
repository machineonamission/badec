package io.flatcircle.coroutinehelper;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0004\"\u0004\b\u0003\u0010\u00052\u0006\u0010\u0006\u001a\u0002H\u0005H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "", "Input1", "Input2", "Input3", "Output", "output", "invoke", "(Ljava/lang/Object;)V"}, k = 3, mv = {1, 1, 15})
/* compiled from: CallbackFlattening.kt */
final class CallbackFlatteningKt$suspendAsync$6$1 extends Lambda implements Function1<Output, Unit> {
    final /* synthetic */ Continuation $continuation;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CallbackFlatteningKt$suspendAsync$6$1(Continuation continuation) {
        super(1);
        this.$continuation = continuation;
    }

    public final void invoke(Output output) {
        Continuation continuation = this.$continuation;
        Result.Companion companion = Result.Companion;
        continuation.resumeWith(Result.m9366constructorimpl(output));
    }
}
