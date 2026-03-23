package io.flatcircle.coroutinehelper;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\"\u0010\u0004\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00052\u0012\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00030\u0007HDø\u0001\u0000"}, d2 = {"onFail", "", "T", "Lio/flatcircle/coroutinehelper/ApiResult;", "function", "Lkotlin/Function2;", "", "Lkotlin/coroutines/Continuation;", "", "continuation"}, k = 3, mv = {1, 1, 15})
@DebugMetadata(c = "io.flatcircle.coroutinehelper.ApiResultKt", f = "ApiResult.kt", i = {0, 0}, l = {139}, m = "onFail", n = {"$this$onFail", "function"}, s = {"L$0", "L$1"})
/* compiled from: ApiResult.kt */
final class ApiResultKt$onFail$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    ApiResultKt$onFail$1(Continuation continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ApiResultKt.onFail((ApiResult) null, (Function2<? super Throwable, ? super Continuation<? super Unit>, ? extends Object>) null, this);
    }
}
