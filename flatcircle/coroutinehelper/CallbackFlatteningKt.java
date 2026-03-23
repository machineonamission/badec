package io.flatcircle.coroutinehelper;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u001aK\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00012$\u0010\u0003\u001a \u0012\u0004\u0012\u0002H\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010\u0007\u001a\u0002H\u0002H@ø\u0001\u0000¢\u0006\u0002\u0010\b\u001a_\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\n\"\u0004\b\u0002\u0010\u00012*\u0010\u0003\u001a&\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\n\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u00060\u000b2\u0006\u0010\f\u001a\u0002H\t2\u0006\u0010\r\u001a\u0002H\nH@ø\u0001\u0000¢\u0006\u0002\u0010\u000e\u001as\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\n\"\u0004\b\u0002\u0010\u000f\"\u0004\b\u0003\u0010\u000120\u0010\u0003\u001a,\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u000f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u00060\u00102\u0006\u0010\f\u001a\u0002H\t2\u0006\u0010\r\u001a\u0002H\n2\u0006\u0010\u0011\u001a\u0002H\u000fH@ø\u0001\u0000¢\u0006\u0002\u0010\u0012\u001ac\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u00160\u0014\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0015\"\u0004\b\u0002\u0010\u00162*\u0010\u0003\u001a&\u0012\u0004\u0012\u0002H\u0002\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u00020\u00060\u0004\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010\u0007\u001a\u0002H\u0002H@ø\u0001\u0000¢\u0006\u0002\u0010\b\u001aw\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u00160\u0014\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\n\"\u0004\b\u0002\u0010\u0015\"\u0004\b\u0003\u0010\u001620\u0010\u0003\u001a,\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\n\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u00020\u00060\u0004\u0012\u0004\u0012\u00020\u00060\u000b2\u0006\u0010\u0017\u001a\u0002H\t2\u0006\u0010\u0018\u001a\u0002H\nH@ø\u0001\u0000¢\u0006\u0002\u0010\u000e\u001a\u0001\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u00160\u0014\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\n\"\u0004\b\u0002\u0010\u000f\"\u0004\b\u0003\u0010\u0015\"\u0004\b\u0004\u0010\u001626\u0010\u0003\u001a2\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u000f\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u00020\u00060\u0004\u0012\u0004\u0012\u00020\u00060\u00102\u0006\u0010\f\u001a\u0002H\t2\u0006\u0010\r\u001a\u0002H\n2\u0006\u0010\u0011\u001a\u0002H\u000fH@ø\u0001\u0000¢\u0006\u0002\u0010\u0012\u001au\u0010\u0019\u001a\u0014\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u0002H\u001b0\u001a\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0015\"\u0004\b\u0002\u0010\u0016\"\u0004\b\u0003\u0010\u001b20\u0010\u0003\u001a,\u0012\u0004\u0012\u0002H\u0002\u0012\u001c\u0012\u001a\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u00020\u00060\u000b\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010\u0007\u001a\u0002H\u0002H@ø\u0001\u0000¢\u0006\u0002\u0010\b\u001a\u0001\u0010\u0019\u001a\u0014\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u0002H\u001b0\u001a\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\n\"\u0004\b\u0002\u0010\u0015\"\u0004\b\u0003\u0010\u0016\"\u0004\b\u0004\u0010\u001b26\u0010\u0003\u001a2\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\n\u0012\u001c\u0012\u001a\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u00020\u00060\u000b\u0012\u0004\u0012\u00020\u00060\u000b2\u0006\u0010\u0017\u001a\u0002H\t2\u0006\u0010\u0018\u001a\u0002H\nH@ø\u0001\u0000¢\u0006\u0002\u0010\u000e\u001a\u0001\u0010\u0019\u001a\u0014\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u0002H\u001b0\u001a\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\n\"\u0004\b\u0002\u0010\u000f\"\u0004\b\u0003\u0010\u0015\"\u0004\b\u0004\u0010\u0016\"\u0004\b\u0005\u0010\u001b2<\u0010\u0003\u001a8\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u000f\u0012\u001c\u0012\u001a\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u00020\u00060\u000b\u0012\u0004\u0012\u00020\u00060\u00102\u0006\u0010\f\u001a\u0002H\t2\u0006\u0010\r\u001a\u0002H\n2\u0006\u0010\u0011\u001a\u0002H\u000fH@ø\u0001\u0000¢\u0006\u0002\u0010\u0012\u001aG\u0010\u001c\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0001* \u0012\u0004\u0012\u0002H\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010\u0007\u001a\u0002H\u0002HDø\u0001\u0000¢\u0006\u0002\u0010\b\u001a_\u0010\u001c\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\n\"\u0004\b\u0002\u0010\u0001*&\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\n\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u00060\u000b2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\n0\u0014HDø\u0001\u0000¢\u0006\u0002\u0010\u001e\u001aq\u0010\u001c\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\n\"\u0004\b\u0002\u0010\u000f\"\u0004\b\u0003\u0010\u0001*,\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u000f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u00060\u00102\u0018\u0010\u001f\u001a\u0014\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u000f0\u001aHDø\u0001\u0000¢\u0006\u0002\u0010 \u001a_\u0010!\u001a\u000e\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u00160\u0014\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0015\"\u0004\b\u0002\u0010\u0016*&\u0012\u0004\u0012\u0002H\u0002\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u00020\u00060\u0004\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010\u0007\u001a\u0002H\u0002HDø\u0001\u0000¢\u0006\u0002\u0010\b\u001aw\u0010!\u001a\u000e\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u00160\u0014\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\n\"\u0004\b\u0002\u0010\u0015\"\u0004\b\u0003\u0010\u0016*,\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\n\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u00020\u00060\u0004\u0012\u0004\u0012\u00020\u00060\u000b2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\n0\u0014HDø\u0001\u0000¢\u0006\u0002\u0010\u001e\u001a\u0001\u0010!\u001a\u000e\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u00160\u0014\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\n\"\u0004\b\u0002\u0010\u000f\"\u0004\b\u0003\u0010\u0015\"\u0004\b\u0004\u0010\u0016*2\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u000f\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u00020\u00060\u0004\u0012\u0004\u0012\u00020\u00060\u00102\u0018\u0010\u001f\u001a\u0014\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u000f0\u001aHDø\u0001\u0000¢\u0006\u0002\u0010 \u001aq\u0010\"\u001a\u0014\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u0002H\u001b0\u001a\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0015\"\u0004\b\u0002\u0010\u0016\"\u0004\b\u0003\u0010\u001b*,\u0012\u0004\u0012\u0002H\u0002\u0012\u001c\u0012\u001a\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u00020\u00060\u000b\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010\u0007\u001a\u0002H\u0002HDø\u0001\u0000¢\u0006\u0002\u0010\b\u001a\u0001\u0010\"\u001a\u0014\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u0002H\u001b0\u001a\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\n\"\u0004\b\u0002\u0010\u0015\"\u0004\b\u0003\u0010\u0016\"\u0004\b\u0004\u0010\u001b*2\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\n\u0012\u001c\u0012\u001a\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u00020\u00060\u000b\u0012\u0004\u0012\u00020\u00060\u000b2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\n0\u0014HDø\u0001\u0000¢\u0006\u0002\u0010\u001e\u001a\u0001\u0010\"\u001a\u0014\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u0002H\u001b0\u001a\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\n\"\u0004\b\u0002\u0010\u000f\"\u0004\b\u0003\u0010\u0015\"\u0004\b\u0004\u0010\u0016\"\u0004\b\u0005\u0010\u001b*8\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u000f\u0012\u001c\u0012\u001a\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u00020\u00060\u000b\u0012\u0004\u0012\u00020\u00060\u00102\u0018\u0010\u001f\u001a\u0014\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u000f0\u001aHDø\u0001\u0000¢\u0006\u0002\u0010 \u0002\u0004\n\u0002\b\u0019¨\u0006#"}, d2 = {"suspendAsync", "Output", "Input", "function", "Lkotlin/Function2;", "Lkotlin/Function1;", "", "input", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Input1", "Input2", "Lkotlin/Function3;", "input1", "input2", "(Lkotlin/jvm/functions/Function3;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Input3", "Lkotlin/Function4;", "input3", "(Lkotlin/jvm/functions/Function4;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "suspendAsyncPairResult", "Lkotlin/Pair;", "Output1", "Output2", "inputOne", "inputTwo", "suspendAsyncTripleResult", "Lkotlin/Triple;", "Output3", "suspendAndInvokeWith", "pair", "(Lkotlin/jvm/functions/Function3;Lkotlin/Pair;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "triple", "(Lkotlin/jvm/functions/Function4;Lkotlin/Triple;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "suspendAndInvokeWith2", "suspendAndInvokeWith3", "coroutinehelper_release"}, k = 2, mv = {1, 1, 15})
/* compiled from: CallbackFlattening.kt */
public final class CallbackFlatteningKt {
    public static final <Input, Output> Object suspendAsync(Function2<? super Input, ? super Function1<? super Output, Unit>, Unit> function2, Input input, Continuation<? super Output> continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        function2.invoke(input, new CallbackFlatteningKt$suspendAsync$2$1(safeContinuation));
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    public static final <Input1, Input2, Output> Object suspendAsync(Function3<? super Input1, ? super Input2, ? super Function1<? super Output, Unit>, Unit> function3, Input1 input1, Input2 input2, Continuation<? super Output> continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        function3.invoke(input1, input2, new CallbackFlatteningKt$suspendAsync$4$1(safeContinuation));
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    public static final <Input1, Input2, Input3, Output> Object suspendAsync(Function4<? super Input1, ? super Input2, ? super Input3, ? super Function1<? super Output, Unit>, Unit> function4, Input1 input1, Input2 input2, Input3 input3, Continuation<? super Output> continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        function4.invoke(input1, input2, input3, new CallbackFlatteningKt$suspendAsync$6$1(safeContinuation));
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    public static final <Input, Output1, Output2> Object suspendAsyncPairResult(Function2<? super Input, ? super Function2<? super Output1, ? super Output2, Unit>, Unit> function2, Input input, Continuation<? super Pair<? extends Output1, ? extends Output2>> continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        function2.invoke(input, new CallbackFlatteningKt$suspendAsyncPairResult$2$1(safeContinuation));
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    public static final <Input1, Input2, Output1, Output2> Object suspendAsyncPairResult(Function3<? super Input1, ? super Input2, ? super Function2<? super Output1, ? super Output2, Unit>, Unit> function3, Input1 input1, Input2 input2, Continuation<? super Pair<? extends Output1, ? extends Output2>> continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        function3.invoke(input1, input2, new CallbackFlatteningKt$suspendAsyncPairResult$4$1(safeContinuation));
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    public static final <Input1, Input2, Input3, Output1, Output2> Object suspendAsyncPairResult(Function4<? super Input1, ? super Input2, ? super Input3, ? super Function2<? super Output1, ? super Output2, Unit>, Unit> function4, Input1 input1, Input2 input2, Input3 input3, Continuation<? super Pair<? extends Output1, ? extends Output2>> continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        function4.invoke(input1, input2, input3, new CallbackFlatteningKt$suspendAsyncPairResult$6$1(safeContinuation));
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    public static final <Input, Output1, Output2, Output3> Object suspendAsyncTripleResult(Function2<? super Input, ? super Function3<? super Output1, ? super Output2, ? super Output3, Unit>, Unit> function2, Input input, Continuation<? super Triple<? extends Output1, ? extends Output2, ? extends Output3>> continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        function2.invoke(input, new CallbackFlatteningKt$suspendAsyncTripleResult$2$1(safeContinuation));
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    public static final <Input1, Input2, Output1, Output2, Output3> Object suspendAsyncTripleResult(Function3<? super Input1, ? super Input2, ? super Function3<? super Output1, ? super Output2, ? super Output3, Unit>, Unit> function3, Input1 input1, Input2 input2, Continuation<? super Triple<? extends Output1, ? extends Output2, ? extends Output3>> continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        function3.invoke(input1, input2, new CallbackFlatteningKt$suspendAsyncTripleResult$4$1(safeContinuation));
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    public static final <Input1, Input2, Input3, Output1, Output2, Output3> Object suspendAsyncTripleResult(Function4<? super Input1, ? super Input2, ? super Input3, ? super Function3<? super Output1, ? super Output2, ? super Output3, Unit>, Unit> function4, Input1 input1, Input2 input2, Input3 input3, Continuation<? super Triple<? extends Output1, ? extends Output2, ? extends Output3>> continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        function4.invoke(input1, input2, input3, new CallbackFlatteningKt$suspendAsyncTripleResult$6$1(safeContinuation));
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }
}
