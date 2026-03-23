package io.flatcircle.coroutinehelper;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032(\u0010\u0004\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00052\u0012\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00030\u0006HDø\u0001\u0000"}, d2 = {"finally", "", "T", "Lio/flatcircle/coroutinehelper/ApiResult;", "function", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "continuation"}, k = 3, mv = {1, 1, 15})
@DebugMetadata(c = "io.flatcircle.coroutinehelper.ApiResultKt", f = "ApiResult.kt", i = {0, 0}, l = {160}, m = "finally", n = {"$this$finally", "function"}, s = {"L$0", "L$1"})
/* compiled from: ApiResult.kt */
final class ApiResultKt$finally$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    ApiResultKt$finally$1(Continuation continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ApiResultKt.m9342finally((ApiResult) null, (Function2) null, this);
    }
}
