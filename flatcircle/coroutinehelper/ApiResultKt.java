package io.flatcircle.coroutinehelper;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aQ\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012(\u0010\u0003\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004HDø\u0001\u0000¢\u0006\u0002\u0010\b\u001a9\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0018\u0010\u0003\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0001\u0012\u0004\u0012\u00020\u00060\nH\u0004\u001aK\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\"\u0010\u0003\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004HDø\u0001\u0000¢\u0006\u0002\u0010\b\u001a3\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00060\nH\u0004\u001aK\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\"\u0010\u0003\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004HDø\u0001\u0000¢\u0006\u0002\u0010\b\u001a3\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00060\nH\u0004\u001aW\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012.\u0010\u0003\u001a*\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0011\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004HDø\u0001\u0000¢\u0006\u0002\u0010\b\u001a?\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u001e\u0010\u0003\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\nH\u0004\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"finally", "Lio/flatcircle/coroutinehelper/ApiResult;", "T", "function", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "", "(Lio/flatcircle/coroutinehelper/ApiResult;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "finallyBlocking", "Lkotlin/Function1;", "onFail", "", "onFailBlocking", "onSuccess", "onSuccessBlocking", "then", "Lio/flatcircle/coroutinehelper/Success;", "thenBlocking", "coroutinehelper_release"}, k = 2, mv = {1, 1, 15})
/* compiled from: ApiResult.kt */
public final class ApiResultKt {
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> java.lang.Object then(io.flatcircle.coroutinehelper.ApiResult<T> r4, kotlin.jvm.functions.Function2<? super io.flatcircle.coroutinehelper.Success<T>, ? super kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<T>>, ? extends java.lang.Object> r5, kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<T>> r6) {
        /*
            boolean r0 = r6 instanceof io.flatcircle.coroutinehelper.ApiResultKt$then$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            io.flatcircle.coroutinehelper.ApiResultKt$then$1 r0 = (io.flatcircle.coroutinehelper.ApiResultKt$then$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            io.flatcircle.coroutinehelper.ApiResultKt$then$1 r0 = new io.flatcircle.coroutinehelper.ApiResultKt$then$1
            r0.<init>(r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003a
            if (r2 != r3) goto L_0x0032
            java.lang.Object r4 = r0.L$1
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            java.lang.Object r4 = r0.L$0
            io.flatcircle.coroutinehelper.ApiResult r4 = (io.flatcircle.coroutinehelper.ApiResult) r4
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x004e
        L_0x0032:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x003a:
            kotlin.ResultKt.throwOnFailure(r6)
            boolean r6 = r4 instanceof io.flatcircle.coroutinehelper.Success
            if (r6 == 0) goto L_0x0051
            r0.L$0 = r4
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r6 = r5.invoke(r4, r0)
            if (r6 != r1) goto L_0x004e
            return r1
        L_0x004e:
            io.flatcircle.coroutinehelper.ApiResult r6 = (io.flatcircle.coroutinehelper.ApiResult) r6
            return r6
        L_0x0051:
            boolean r5 = r4 instanceof io.flatcircle.coroutinehelper.Failure
            if (r5 == 0) goto L_0x0056
            return r4
        L_0x0056:
            kotlin.NoWhenBranchMatchedException r4 = new kotlin.NoWhenBranchMatchedException
            r4.<init>()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flatcircle.coroutinehelper.ApiResultKt.then(io.flatcircle.coroutinehelper.ApiResult, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final <T> ApiResult<T> thenBlocking(ApiResult<T> apiResult, Function1<? super Success<T>, ? extends ApiResult<T>> function1) {
        Intrinsics.checkParameterIsNotNull(apiResult, "$this$thenBlocking");
        Intrinsics.checkParameterIsNotNull(function1, "function");
        if (apiResult instanceof Success) {
            return (ApiResult) function1.invoke(apiResult);
        }
        if (apiResult instanceof Failure) {
            return apiResult;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> java.lang.Object onSuccess(io.flatcircle.coroutinehelper.ApiResult<T> r4, kotlin.jvm.functions.Function2<? super T, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> r5, kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<T>> r6) {
        /*
            boolean r0 = r6 instanceof io.flatcircle.coroutinehelper.ApiResultKt$onSuccess$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            io.flatcircle.coroutinehelper.ApiResultKt$onSuccess$1 r0 = (io.flatcircle.coroutinehelper.ApiResultKt$onSuccess$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            io.flatcircle.coroutinehelper.ApiResultKt$onSuccess$1 r0 = new io.flatcircle.coroutinehelper.ApiResultKt$onSuccess$1
            r0.<init>(r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003a
            if (r2 != r3) goto L_0x0032
            java.lang.Object r4 = r0.L$1
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            java.lang.Object r4 = r0.L$0
            io.flatcircle.coroutinehelper.ApiResult r4 = (io.flatcircle.coroutinehelper.ApiResult) r4
            kotlin.ResultKt.throwOnFailure(r6)
            return r4
        L_0x0032:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x003a:
            kotlin.ResultKt.throwOnFailure(r6)
            boolean r6 = r4 instanceof io.flatcircle.coroutinehelper.Success
            if (r6 == 0) goto L_0x0055
            r6 = r4
            io.flatcircle.coroutinehelper.Success r6 = (io.flatcircle.coroutinehelper.Success) r6
            java.lang.Object r6 = r6.getValue()
            r0.L$0 = r4
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r5 = r5.invoke(r6, r0)
            if (r5 != r1) goto L_0x0059
            return r1
        L_0x0055:
            boolean r5 = r4 instanceof io.flatcircle.coroutinehelper.Failure
            if (r5 == 0) goto L_0x005a
        L_0x0059:
            return r4
        L_0x005a:
            kotlin.NoWhenBranchMatchedException r4 = new kotlin.NoWhenBranchMatchedException
            r4.<init>()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flatcircle.coroutinehelper.ApiResultKt.onSuccess(io.flatcircle.coroutinehelper.ApiResult, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final <T> ApiResult<T> onSuccessBlocking(ApiResult<T> apiResult, Function1<? super T, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(apiResult, "$this$onSuccessBlocking");
        Intrinsics.checkParameterIsNotNull(function1, "function");
        if (apiResult instanceof Success) {
            function1.invoke(((Success) apiResult).getValue());
            return apiResult;
        } else if (apiResult instanceof Failure) {
            return apiResult;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> java.lang.Object onFail(io.flatcircle.coroutinehelper.ApiResult<T> r4, kotlin.jvm.functions.Function2<? super java.lang.Throwable, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> r5, kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<T>> r6) {
        /*
            boolean r0 = r6 instanceof io.flatcircle.coroutinehelper.ApiResultKt$onFail$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            io.flatcircle.coroutinehelper.ApiResultKt$onFail$1 r0 = (io.flatcircle.coroutinehelper.ApiResultKt$onFail$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            io.flatcircle.coroutinehelper.ApiResultKt$onFail$1 r0 = new io.flatcircle.coroutinehelper.ApiResultKt$onFail$1
            r0.<init>(r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003a
            if (r2 != r3) goto L_0x0032
            java.lang.Object r4 = r0.L$1
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            java.lang.Object r4 = r0.L$0
            io.flatcircle.coroutinehelper.ApiResult r4 = (io.flatcircle.coroutinehelper.ApiResult) r4
            kotlin.ResultKt.throwOnFailure(r6)
            return r4
        L_0x0032:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x003a:
            kotlin.ResultKt.throwOnFailure(r6)
            boolean r6 = r4 instanceof io.flatcircle.coroutinehelper.Success
            if (r6 == 0) goto L_0x0042
            goto L_0x005a
        L_0x0042:
            boolean r6 = r4 instanceof io.flatcircle.coroutinehelper.Failure
            if (r6 == 0) goto L_0x005b
            r6 = r4
            io.flatcircle.coroutinehelper.Failure r6 = (io.flatcircle.coroutinehelper.Failure) r6
            java.lang.Throwable r6 = r6.getError()
            r0.L$0 = r4
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r5 = r5.invoke(r6, r0)
            if (r5 != r1) goto L_0x005a
            return r1
        L_0x005a:
            return r4
        L_0x005b:
            kotlin.NoWhenBranchMatchedException r4 = new kotlin.NoWhenBranchMatchedException
            r4.<init>()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flatcircle.coroutinehelper.ApiResultKt.onFail(io.flatcircle.coroutinehelper.ApiResult, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final <T> ApiResult<T> onFailBlocking(ApiResult<T> apiResult, Function1<? super Throwable, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(apiResult, "$this$onFailBlocking");
        Intrinsics.checkParameterIsNotNull(function1, "function");
        if (apiResult instanceof Success) {
            return apiResult;
        }
        if (apiResult instanceof Failure) {
            function1.invoke(((Failure) apiResult).getError());
            return apiResult;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* renamed from: finally  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> java.lang.Object m9342finally(io.flatcircle.coroutinehelper.ApiResult<T> r4, kotlin.jvm.functions.Function2<? super io.flatcircle.coroutinehelper.ApiResult<T>, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> r5, kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<T>> r6) {
        /*
            boolean r0 = r6 instanceof io.flatcircle.coroutinehelper.ApiResultKt$finally$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            io.flatcircle.coroutinehelper.ApiResultKt$finally$1 r0 = (io.flatcircle.coroutinehelper.ApiResultKt$finally$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            io.flatcircle.coroutinehelper.ApiResultKt$finally$1 r0 = new io.flatcircle.coroutinehelper.ApiResultKt$finally$1
            r0.<init>(r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003a
            if (r2 != r3) goto L_0x0032
            java.lang.Object r4 = r0.L$1
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            java.lang.Object r4 = r0.L$0
            io.flatcircle.coroutinehelper.ApiResult r4 = (io.flatcircle.coroutinehelper.ApiResult) r4
            kotlin.ResultKt.throwOnFailure(r6)
            return r4
        L_0x0032:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x003a:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.L$0 = r4
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r5 = r5.invoke(r4, r0)
            if (r5 != r1) goto L_0x004a
            return r1
        L_0x004a:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flatcircle.coroutinehelper.ApiResultKt.m9342finally(io.flatcircle.coroutinehelper.ApiResult, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final <T> ApiResult<T> finallyBlocking(ApiResult<T> apiResult, Function1<? super ApiResult<T>, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(apiResult, "$this$finallyBlocking");
        Intrinsics.checkParameterIsNotNull(function1, "function");
        function1.invoke(apiResult);
        return apiResult;
    }
}
