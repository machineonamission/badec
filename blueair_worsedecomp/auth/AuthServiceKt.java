package com.blueair.auth;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a(\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H@¢\u0006\u0002\u0010\u0005\u001a>\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0001\"\u0004\b\u0000\u0010\u00072\"\u0010\b\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00070\u000b0\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\tH@¢\u0006\u0002\u0010\r\u001aa\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0001\"\u0004\b\u0000\u0010\u000e\"\u0004\b\u0001\u0010\u000727\u0010\b\u001a3\b\u0001\u0012\u0013\u0012\u0011H\u000e¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00070\u000b0\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000f2\u0006\u0010\u0012\u001a\u0002H\u000eH@¢\u0006\u0002\u0010\u0013\u001a\u0001\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0001\"\u0004\b\u0000\u0010\u0014\"\u0004\b\u0001\u0010\u0015\"\u0004\b\u0002\u0010\u00072L\u0010\b\u001aH\b\u0001\u0012\u0013\u0012\u0011H\u0014¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u0011H\u0015¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0018\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00070\u000b0\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u00162\u0006\u0010\u0017\u001a\u0002H\u00142\u0006\u0010\u0018\u001a\u0002H\u0015H@¢\u0006\u0002\u0010\u0019¨\u0006\u001a"}, d2 = {"awaitCall", "Lio/flatcircle/coroutinehelper/ApiResult;", "T", "job", "Lkotlinx/coroutines/Deferred;", "(Lkotlinx/coroutines/Deferred;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "doSuspendedApiCall", "Output", "apiCall", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "Lretrofit2/Response;", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Input", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "input", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Input1", "Input2", "Lkotlin/Function3;", "input1", "input2", "(Lkotlin/jvm/functions/Function3;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "auth_otherRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* compiled from: AuthService.kt */
public final class AuthServiceKt {
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> java.lang.Object awaitCall(kotlinx.coroutines.Deferred<? extends T> r5, kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<T>> r6) {
        /*
            boolean r0 = r6 instanceof com.blueair.auth.AuthServiceKt$awaitCall$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            com.blueair.auth.AuthServiceKt$awaitCall$1 r0 = (com.blueair.auth.AuthServiceKt$awaitCall$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            com.blueair.auth.AuthServiceKt$awaitCall$1 r0 = new com.blueair.auth.AuthServiceKt$awaitCall$1
            r0.<init>(r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r5 = r0.L$0
            kotlinx.coroutines.Deferred r5 = (kotlinx.coroutines.Deferred) r5
            kotlin.ResultKt.throwOnFailure(r6)     // Catch:{ Exception -> 0x005d }
            goto L_0x0056
        L_0x002e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r6)
            kotlinx.coroutines.CoroutineDispatcher r6 = kotlinx.coroutines.Dispatchers.getIO()     // Catch:{ Exception -> 0x005d }
            kotlin.coroutines.CoroutineContext r6 = (kotlin.coroutines.CoroutineContext) r6     // Catch:{ Exception -> 0x005d }
            com.blueair.auth.AuthServiceKt$awaitCall$value$1 r2 = new com.blueair.auth.AuthServiceKt$awaitCall$value$1     // Catch:{ Exception -> 0x005d }
            r4 = 0
            r2.<init>(r5, r4)     // Catch:{ Exception -> 0x005d }
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2     // Catch:{ Exception -> 0x005d }
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r5)     // Catch:{ Exception -> 0x005d }
            r0.L$0 = r5     // Catch:{ Exception -> 0x005d }
            r0.label = r3     // Catch:{ Exception -> 0x005d }
            java.lang.Object r6 = kotlinx.coroutines.BuildersKt.withContext(r6, r2, r0)     // Catch:{ Exception -> 0x005d }
            if (r6 != r1) goto L_0x0056
            return r1
        L_0x0056:
            io.flatcircle.coroutinehelper.ApiResult$Companion r5 = io.flatcircle.coroutinehelper.ApiResult.Companion     // Catch:{ Exception -> 0x005d }
            io.flatcircle.coroutinehelper.ApiResult r5 = r5.success(r6)     // Catch:{ Exception -> 0x005d }
            return r5
        L_0x005d:
            r5 = move-exception
            io.flatcircle.coroutinehelper.ApiResult$Companion r6 = io.flatcircle.coroutinehelper.ApiResult.Companion
            java.lang.Throwable r5 = (java.lang.Throwable) r5
            io.flatcircle.coroutinehelper.ApiResult r5 = r6.fail(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.auth.AuthServiceKt.awaitCall(kotlinx.coroutines.Deferred, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0074 A[Catch:{ Exception -> 0x00aa }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0095 A[Catch:{ Exception -> 0x00aa }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <Output> java.lang.Object doSuspendedApiCall(kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super retrofit2.Response<Output>>, ? extends java.lang.Object> r6, kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<Output>> r7) {
        /*
            java.lang.String r0 = "doSuspendedApiCall: response = "
            boolean r1 = r7 instanceof com.blueair.auth.AuthServiceKt$doSuspendedApiCall$1
            if (r1 == 0) goto L_0x0016
            r1 = r7
            com.blueair.auth.AuthServiceKt$doSuspendedApiCall$1 r1 = (com.blueair.auth.AuthServiceKt$doSuspendedApiCall$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0016
            int r7 = r1.label
            int r7 = r7 - r3
            r1.label = r7
            goto L_0x001b
        L_0x0016:
            com.blueair.auth.AuthServiceKt$doSuspendedApiCall$1 r1 = new com.blueair.auth.AuthServiceKt$doSuspendedApiCall$1
            r1.<init>(r7)
        L_0x001b:
            java.lang.Object r7 = r1.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r1.label
            r4 = 1
            if (r3 == 0) goto L_0x0038
            if (r3 != r4) goto L_0x0030
            java.lang.Object r6 = r1.L$0
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            kotlin.ResultKt.throwOnFailure(r7)     // Catch:{ Exception -> 0x00aa }
            goto L_0x0058
        L_0x0030:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0038:
            kotlin.ResultKt.throwOnFailure(r7)
            kotlinx.coroutines.CoroutineDispatcher r7 = kotlinx.coroutines.Dispatchers.getIO()     // Catch:{ Exception -> 0x00aa }
            kotlin.coroutines.CoroutineContext r7 = (kotlin.coroutines.CoroutineContext) r7     // Catch:{ Exception -> 0x00aa }
            com.blueair.auth.AuthServiceKt$doSuspendedApiCall$response$1 r3 = new com.blueair.auth.AuthServiceKt$doSuspendedApiCall$response$1     // Catch:{ Exception -> 0x00aa }
            r5 = 0
            r3.<init>(r6, r5)     // Catch:{ Exception -> 0x00aa }
            kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3     // Catch:{ Exception -> 0x00aa }
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)     // Catch:{ Exception -> 0x00aa }
            r1.L$0 = r6     // Catch:{ Exception -> 0x00aa }
            r1.label = r4     // Catch:{ Exception -> 0x00aa }
            java.lang.Object r7 = kotlinx.coroutines.BuildersKt.withContext(r7, r3, r1)     // Catch:{ Exception -> 0x00aa }
            if (r7 != r2) goto L_0x0058
            return r2
        L_0x0058:
            retrofit2.Response r7 = (retrofit2.Response) r7     // Catch:{ Exception -> 0x00aa }
            timber.log.Timber$Forest r6 = timber.log.Timber.Forest     // Catch:{ Exception -> 0x00aa }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00aa }
            r1.<init>(r0)     // Catch:{ Exception -> 0x00aa }
            r1.append(r7)     // Catch:{ Exception -> 0x00aa }
            java.lang.String r0 = r1.toString()     // Catch:{ Exception -> 0x00aa }
            r1 = 0
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x00aa }
            r6.d(r0, r1)     // Catch:{ Exception -> 0x00aa }
            boolean r6 = r7.isSuccessful()     // Catch:{ Exception -> 0x00aa }
            if (r6 == 0) goto L_0x0095
            java.lang.Object r6 = r7.body()     // Catch:{ Exception -> 0x00aa }
            if (r6 == 0) goto L_0x0080
            io.flatcircle.coroutinehelper.Success r7 = new io.flatcircle.coroutinehelper.Success     // Catch:{ Exception -> 0x00aa }
            r7.<init>(r6)     // Catch:{ Exception -> 0x00aa }
            return r7
        L_0x0080:
            io.flatcircle.coroutinehelper.Failure r6 = new io.flatcircle.coroutinehelper.Failure     // Catch:{ Exception -> 0x00aa }
            java.lang.Exception r0 = new java.lang.Exception     // Catch:{ Exception -> 0x00aa }
            okhttp3.ResponseBody r7 = r7.errorBody()     // Catch:{ Exception -> 0x00aa }
            java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch:{ Exception -> 0x00aa }
            r0.<init>(r7)     // Catch:{ Exception -> 0x00aa }
            java.lang.Throwable r0 = (java.lang.Throwable) r0     // Catch:{ Exception -> 0x00aa }
            r6.<init>(r0)     // Catch:{ Exception -> 0x00aa }
            return r6
        L_0x0095:
            io.flatcircle.coroutinehelper.Failure r6 = new io.flatcircle.coroutinehelper.Failure     // Catch:{ Exception -> 0x00aa }
            java.lang.Exception r0 = new java.lang.Exception     // Catch:{ Exception -> 0x00aa }
            okhttp3.ResponseBody r7 = r7.errorBody()     // Catch:{ Exception -> 0x00aa }
            java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch:{ Exception -> 0x00aa }
            r0.<init>(r7)     // Catch:{ Exception -> 0x00aa }
            java.lang.Throwable r0 = (java.lang.Throwable) r0     // Catch:{ Exception -> 0x00aa }
            r6.<init>(r0)     // Catch:{ Exception -> 0x00aa }
            return r6
        L_0x00aa:
            r6 = move-exception
            io.flatcircle.coroutinehelper.Failure r7 = new io.flatcircle.coroutinehelper.Failure
            java.lang.Throwable r6 = (java.lang.Throwable) r6
            r7.<init>(r6)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.auth.AuthServiceKt.doSuspendedApiCall(kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0066 A[Catch:{ Exception -> 0x009c }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0087 A[Catch:{ Exception -> 0x009c }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <Input, Output> java.lang.Object doSuspendedApiCall(kotlin.jvm.functions.Function2<? super Input, ? super kotlin.coroutines.Continuation<? super retrofit2.Response<Output>>, ? extends java.lang.Object> r5, Input r6, kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<Output>> r7) {
        /*
            boolean r0 = r7 instanceof com.blueair.auth.AuthServiceKt$doSuspendedApiCall$3
            if (r0 == 0) goto L_0x0014
            r0 = r7
            com.blueair.auth.AuthServiceKt$doSuspendedApiCall$3 r0 = (com.blueair.auth.AuthServiceKt$doSuspendedApiCall$3) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            com.blueair.auth.AuthServiceKt$doSuspendedApiCall$3 r0 = new com.blueair.auth.AuthServiceKt$doSuspendedApiCall$3
            r0.<init>(r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0038
            if (r2 != r3) goto L_0x0030
            java.lang.Object r5 = r0.L$1
            java.lang.Object r5 = r0.L$0
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
            kotlin.ResultKt.throwOnFailure(r7)     // Catch:{ Exception -> 0x009c }
            goto L_0x005e
        L_0x0030:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0038:
            kotlin.ResultKt.throwOnFailure(r7)
            kotlinx.coroutines.CoroutineDispatcher r7 = kotlinx.coroutines.Dispatchers.getIO()     // Catch:{ Exception -> 0x009c }
            kotlin.coroutines.CoroutineContext r7 = (kotlin.coroutines.CoroutineContext) r7     // Catch:{ Exception -> 0x009c }
            com.blueair.auth.AuthServiceKt$doSuspendedApiCall$response$2 r2 = new com.blueair.auth.AuthServiceKt$doSuspendedApiCall$response$2     // Catch:{ Exception -> 0x009c }
            r4 = 0
            r2.<init>(r5, r6, r4)     // Catch:{ Exception -> 0x009c }
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2     // Catch:{ Exception -> 0x009c }
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r5)     // Catch:{ Exception -> 0x009c }
            r0.L$0 = r5     // Catch:{ Exception -> 0x009c }
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)     // Catch:{ Exception -> 0x009c }
            r0.L$1 = r5     // Catch:{ Exception -> 0x009c }
            r0.label = r3     // Catch:{ Exception -> 0x009c }
            java.lang.Object r7 = kotlinx.coroutines.BuildersKt.withContext(r7, r2, r0)     // Catch:{ Exception -> 0x009c }
            if (r7 != r1) goto L_0x005e
            return r1
        L_0x005e:
            retrofit2.Response r7 = (retrofit2.Response) r7     // Catch:{ Exception -> 0x009c }
            boolean r5 = r7.isSuccessful()     // Catch:{ Exception -> 0x009c }
            if (r5 == 0) goto L_0x0087
            java.lang.Object r5 = r7.body()     // Catch:{ Exception -> 0x009c }
            if (r5 == 0) goto L_0x0072
            io.flatcircle.coroutinehelper.Success r6 = new io.flatcircle.coroutinehelper.Success     // Catch:{ Exception -> 0x009c }
            r6.<init>(r5)     // Catch:{ Exception -> 0x009c }
            return r6
        L_0x0072:
            io.flatcircle.coroutinehelper.Failure r5 = new io.flatcircle.coroutinehelper.Failure     // Catch:{ Exception -> 0x009c }
            java.lang.Exception r6 = new java.lang.Exception     // Catch:{ Exception -> 0x009c }
            okhttp3.ResponseBody r7 = r7.errorBody()     // Catch:{ Exception -> 0x009c }
            java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch:{ Exception -> 0x009c }
            r6.<init>(r7)     // Catch:{ Exception -> 0x009c }
            java.lang.Throwable r6 = (java.lang.Throwable) r6     // Catch:{ Exception -> 0x009c }
            r5.<init>(r6)     // Catch:{ Exception -> 0x009c }
            return r5
        L_0x0087:
            io.flatcircle.coroutinehelper.Failure r5 = new io.flatcircle.coroutinehelper.Failure     // Catch:{ Exception -> 0x009c }
            java.lang.Exception r6 = new java.lang.Exception     // Catch:{ Exception -> 0x009c }
            okhttp3.ResponseBody r7 = r7.errorBody()     // Catch:{ Exception -> 0x009c }
            java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch:{ Exception -> 0x009c }
            r6.<init>(r7)     // Catch:{ Exception -> 0x009c }
            java.lang.Throwable r6 = (java.lang.Throwable) r6     // Catch:{ Exception -> 0x009c }
            r5.<init>(r6)     // Catch:{ Exception -> 0x009c }
            return r5
        L_0x009c:
            r5 = move-exception
            io.flatcircle.coroutinehelper.Failure r6 = new io.flatcircle.coroutinehelper.Failure
            java.lang.Throwable r5 = (java.lang.Throwable) r5
            r6.<init>(r5)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.auth.AuthServiceKt.doSuspendedApiCall(kotlin.jvm.functions.Function2, java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x006e A[Catch:{ Exception -> 0x00a4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x008f A[Catch:{ Exception -> 0x00a4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <Input1, Input2, Output> java.lang.Object doSuspendedApiCall(kotlin.jvm.functions.Function3<? super Input1, ? super Input2, ? super kotlin.coroutines.Continuation<? super retrofit2.Response<Output>>, ? extends java.lang.Object> r5, Input1 r6, Input2 r7, kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<Output>> r8) {
        /*
            boolean r0 = r8 instanceof com.blueair.auth.AuthServiceKt$doSuspendedApiCall$5
            if (r0 == 0) goto L_0x0014
            r0 = r8
            com.blueair.auth.AuthServiceKt$doSuspendedApiCall$5 r0 = (com.blueair.auth.AuthServiceKt$doSuspendedApiCall$5) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            com.blueair.auth.AuthServiceKt$doSuspendedApiCall$5 r0 = new com.blueair.auth.AuthServiceKt$doSuspendedApiCall$5
            r0.<init>(r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003a
            if (r2 != r3) goto L_0x0032
            java.lang.Object r5 = r0.L$2
            java.lang.Object r5 = r0.L$1
            java.lang.Object r5 = r0.L$0
            kotlin.jvm.functions.Function3 r5 = (kotlin.jvm.functions.Function3) r5
            kotlin.ResultKt.throwOnFailure(r8)     // Catch:{ Exception -> 0x00a4 }
            goto L_0x0066
        L_0x0032:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x003a:
            kotlin.ResultKt.throwOnFailure(r8)
            kotlinx.coroutines.CoroutineDispatcher r8 = kotlinx.coroutines.Dispatchers.getIO()     // Catch:{ Exception -> 0x00a4 }
            kotlin.coroutines.CoroutineContext r8 = (kotlin.coroutines.CoroutineContext) r8     // Catch:{ Exception -> 0x00a4 }
            com.blueair.auth.AuthServiceKt$doSuspendedApiCall$response$3 r2 = new com.blueair.auth.AuthServiceKt$doSuspendedApiCall$response$3     // Catch:{ Exception -> 0x00a4 }
            r4 = 0
            r2.<init>(r5, r6, r7, r4)     // Catch:{ Exception -> 0x00a4 }
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2     // Catch:{ Exception -> 0x00a4 }
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r5)     // Catch:{ Exception -> 0x00a4 }
            r0.L$0 = r5     // Catch:{ Exception -> 0x00a4 }
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)     // Catch:{ Exception -> 0x00a4 }
            r0.L$1 = r5     // Catch:{ Exception -> 0x00a4 }
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)     // Catch:{ Exception -> 0x00a4 }
            r0.L$2 = r5     // Catch:{ Exception -> 0x00a4 }
            r0.label = r3     // Catch:{ Exception -> 0x00a4 }
            java.lang.Object r8 = kotlinx.coroutines.BuildersKt.withContext(r8, r2, r0)     // Catch:{ Exception -> 0x00a4 }
            if (r8 != r1) goto L_0x0066
            return r1
        L_0x0066:
            retrofit2.Response r8 = (retrofit2.Response) r8     // Catch:{ Exception -> 0x00a4 }
            boolean r5 = r8.isSuccessful()     // Catch:{ Exception -> 0x00a4 }
            if (r5 == 0) goto L_0x008f
            java.lang.Object r5 = r8.body()     // Catch:{ Exception -> 0x00a4 }
            if (r5 == 0) goto L_0x007a
            io.flatcircle.coroutinehelper.Success r6 = new io.flatcircle.coroutinehelper.Success     // Catch:{ Exception -> 0x00a4 }
            r6.<init>(r5)     // Catch:{ Exception -> 0x00a4 }
            return r6
        L_0x007a:
            io.flatcircle.coroutinehelper.Failure r5 = new io.flatcircle.coroutinehelper.Failure     // Catch:{ Exception -> 0x00a4 }
            java.lang.Exception r6 = new java.lang.Exception     // Catch:{ Exception -> 0x00a4 }
            okhttp3.ResponseBody r7 = r8.errorBody()     // Catch:{ Exception -> 0x00a4 }
            java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch:{ Exception -> 0x00a4 }
            r6.<init>(r7)     // Catch:{ Exception -> 0x00a4 }
            java.lang.Throwable r6 = (java.lang.Throwable) r6     // Catch:{ Exception -> 0x00a4 }
            r5.<init>(r6)     // Catch:{ Exception -> 0x00a4 }
            return r5
        L_0x008f:
            io.flatcircle.coroutinehelper.Failure r5 = new io.flatcircle.coroutinehelper.Failure     // Catch:{ Exception -> 0x00a4 }
            java.lang.Exception r6 = new java.lang.Exception     // Catch:{ Exception -> 0x00a4 }
            okhttp3.ResponseBody r7 = r8.errorBody()     // Catch:{ Exception -> 0x00a4 }
            java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch:{ Exception -> 0x00a4 }
            r6.<init>(r7)     // Catch:{ Exception -> 0x00a4 }
            java.lang.Throwable r6 = (java.lang.Throwable) r6     // Catch:{ Exception -> 0x00a4 }
            r5.<init>(r6)     // Catch:{ Exception -> 0x00a4 }
            return r5
        L_0x00a4:
            r5 = move-exception
            timber.log.Timber$Forest r6 = timber.log.Timber.Forest
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "doSuspendedApiCall: exception = "
            r7.<init>(r8)
            r7.append(r5)
            java.lang.String r7 = r7.toString()
            r8 = 0
            java.lang.Object[] r8 = new java.lang.Object[r8]
            r6.d(r7, r8)
            io.flatcircle.coroutinehelper.Failure r6 = new io.flatcircle.coroutinehelper.Failure
            java.lang.Throwable r5 = (java.lang.Throwable) r5
            r6.<init>(r5)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.auth.AuthServiceKt.doSuspendedApiCall(kotlin.jvm.functions.Function3, java.lang.Object, java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
