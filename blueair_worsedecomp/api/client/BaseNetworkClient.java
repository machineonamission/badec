package com.blueair.api.client;

import android.content.res.Resources;
import androidx.core.app.NotificationCompat;
import com.blueair.api.utils.DefaultOnDataMismatchAdapter;
import com.blueair.api.utils.SkipBadElementsListAdapter;
import com.blueair.bluetooth.espressif.Provision;
import com.blueair.core.model.BlueCloudHomeLocationReceive;
import com.blueair.core.model.I18nConfig;
import com.blueair.core.model.IpConfig;
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory;
import io.flatcircle.coroutinehelper.ApiResult;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\b`\u0018\u0000 12\u00020\u0001:\u000212J(\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00140\u0013\"\u0004\b\u0000\u0010\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00140\u0016H@¢\u0006\u0002\u0010\u0017J4\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00140\u00190\u0013\"\u0004\b\u0000\u0010\u00142\u0012\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00140\u001b0\u0019H@¢\u0006\u0002\u0010\u001cJa\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u001e0\u0013\"\u0004\b\u0000\u0010\u001f\"\u0004\b\u0001\u0010\u001e27\u0010 \u001a3\b\u0001\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001e0&0%\u0012\u0006\u0012\u0004\u0018\u00010\u00010!2\u0006\u0010$\u001a\u0002H\u001fH@¢\u0006\u0002\u0010'J\u0001\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u001e0\u0013\"\u0004\b\u0000\u0010(\"\u0004\b\u0001\u0010)\"\u0004\b\u0002\u0010\u001e2L\u0010 \u001aH\b\u0001\u0012\u0013\u0012\u0011H(¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(+\u0012\u0013\u0012\u0011H)¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(,\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001e0&0%\u0012\u0006\u0012\u0004\u0018\u00010\u00010*2\u0006\u0010+\u001a\u0002H(2\u0006\u0010,\u001a\u0002H)H@¢\u0006\u0002\u0010-J\u0010\u0010.\u001a\u00020\u00072\u0006\u0010/\u001a\u000200H\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u00063À\u0006\u0003"}, d2 = {"Lcom/blueair/api/client/BaseNetworkClient;", "", "resources", "Landroid/content/res/Resources;", "getResources", "()Landroid/content/res/Resources;", "retrofit", "Lretrofit2/Retrofit;", "getRetrofit", "()Lretrofit2/Retrofit;", "mockInterceptor", "Lokhttp3/Interceptor;", "getMockInterceptor", "()Lokhttp3/Interceptor;", "okHttpClient", "Lokhttp3/OkHttpClient;", "getOkHttpClient", "()Lokhttp3/OkHttpClient;", "awaitCall", "Lio/flatcircle/coroutinehelper/ApiResult;", "T", "job", "Lkotlinx/coroutines/Deferred;", "(Lkotlinx/coroutines/Deferred;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitAllCalls", "", "calls", "Lcom/blueair/api/client/BaseNetworkClient$CallWithInput;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "doSuspendedApiCall", "Output", "Input", "apiCall", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "input", "Lkotlin/coroutines/Continuation;", "Lretrofit2/Response;", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Input1", "Input2", "Lkotlin/Function3;", "input1", "input2", "(Lkotlin/jvm/functions/Function3;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "retroFitFactory", "baseUrl", "", "Companion", "CallWithInput", "api_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: NetworkClient.kt */
public interface BaseNetworkClient {
    public static final long CONNECTION_TIMEOUT = 45;
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final long READ_TIMEOUT = 30;
    public static final long WRITE_TIMEOUT = 30;

    <T> Object awaitAllCalls(List<CallWithInput<T>> list, Continuation<? super ApiResult<List<T>>> continuation);

    <T> Object awaitCall(Deferred<? extends T> deferred, Continuation<? super ApiResult<T>> continuation);

    <Input, Output> Object doSuspendedApiCall(Function2<? super Input, ? super Continuation<? super Response<Output>>, ? extends Object> function2, Input input, Continuation<? super ApiResult<Output>> continuation);

    <Input1, Input2, Output> Object doSuspendedApiCall(Function3<? super Input1, ? super Input2, ? super Continuation<? super Response<Output>>, ? extends Object> function3, Input1 input1, Input2 input2, Continuation<? super ApiResult<Output>> continuation);

    Interceptor getMockInterceptor();

    OkHttpClient getOkHttpClient();

    Resources getResources();

    Retrofit getRetrofit();

    Retrofit retroFitFactory(String str);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/blueair/api/client/BaseNetworkClient$Companion;", "", "<init>", "()V", "CONNECTION_TIMEOUT", "", "READ_TIMEOUT", "WRITE_TIMEOUT", "api_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: NetworkClient.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final long CONNECTION_TIMEOUT = 45;
        public static final long READ_TIMEOUT = 30;
        public static final long WRITE_TIMEOUT = 30;

        private Companion() {
        }
    }

    /* renamed from: com.blueair.api.client.BaseNetworkClient$-CC  reason: invalid class name */
    /* compiled from: NetworkClient.kt */
    public final /* synthetic */ class CC {
        public static Object $default$awaitAllCalls(BaseNetworkClient _this, List list, Continuation continuation) {
            return CoroutineScopeKt.coroutineScope(new BaseNetworkClient$awaitAllCalls$2(list, _this, (Continuation<? super BaseNetworkClient$awaitAllCalls$2>) null), continuation);
        }

        public static Object $default$awaitCall(BaseNetworkClient _this, Deferred deferred, Continuation continuation) {
            return awaitCall$suspendImpl(_this, deferred, continuation);
        }

        public static Object $default$doSuspendedApiCall(BaseNetworkClient _this, Function2 function2, Object obj, Continuation continuation) {
            return doSuspendedApiCall$suspendImpl(_this, function2, obj, continuation);
        }

        public static Object $default$doSuspendedApiCall(BaseNetworkClient _this, Function3 function3, Object obj, Object obj2, Continuation continuation) {
            return doSuspendedApiCall$suspendImpl(_this, function3, obj, obj2, continuation);
        }

        static {
            Companion companion = BaseNetworkClient.Companion;
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x003a  */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static /* synthetic */ <T> java.lang.Object awaitCall$suspendImpl(com.blueair.api.client.BaseNetworkClient r5, kotlinx.coroutines.Deferred<? extends T> r6, kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<T>> r7) {
            /*
                boolean r0 = r7 instanceof com.blueair.api.client.BaseNetworkClient$awaitCall$1
                if (r0 == 0) goto L_0x0014
                r0 = r7
                com.blueair.api.client.BaseNetworkClient$awaitCall$1 r0 = (com.blueair.api.client.BaseNetworkClient$awaitCall$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r1 = r1 & r2
                if (r1 == 0) goto L_0x0014
                int r7 = r0.label
                int r7 = r7 - r2
                r0.label = r7
                goto L_0x0019
            L_0x0014:
                com.blueair.api.client.BaseNetworkClient$awaitCall$1 r0 = new com.blueair.api.client.BaseNetworkClient$awaitCall$1
                r0.<init>(r5, r7)
            L_0x0019:
                java.lang.Object r7 = r0.result
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r0.label
                r3 = 1
                if (r2 == 0) goto L_0x003a
                if (r2 != r3) goto L_0x0032
                java.lang.Object r5 = r0.L$1
                kotlinx.coroutines.Deferred r5 = (kotlinx.coroutines.Deferred) r5
                java.lang.Object r5 = r0.L$0
                com.blueair.api.client.BaseNetworkClient r5 = (com.blueair.api.client.BaseNetworkClient) r5
                kotlin.ResultKt.throwOnFailure(r7)     // Catch:{ Exception -> 0x0067 }
                goto L_0x0060
            L_0x0032:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L_0x003a:
                kotlin.ResultKt.throwOnFailure(r7)
                kotlinx.coroutines.CoroutineDispatcher r7 = kotlinx.coroutines.Dispatchers.getIO()     // Catch:{ Exception -> 0x0067 }
                kotlin.coroutines.CoroutineContext r7 = (kotlin.coroutines.CoroutineContext) r7     // Catch:{ Exception -> 0x0067 }
                com.blueair.api.client.BaseNetworkClient$awaitCall$value$1 r2 = new com.blueair.api.client.BaseNetworkClient$awaitCall$value$1     // Catch:{ Exception -> 0x0067 }
                r4 = 0
                r2.<init>(r6, r4)     // Catch:{ Exception -> 0x0067 }
                kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2     // Catch:{ Exception -> 0x0067 }
                java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r5)     // Catch:{ Exception -> 0x0067 }
                r0.L$0 = r5     // Catch:{ Exception -> 0x0067 }
                java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)     // Catch:{ Exception -> 0x0067 }
                r0.L$1 = r5     // Catch:{ Exception -> 0x0067 }
                r0.label = r3     // Catch:{ Exception -> 0x0067 }
                java.lang.Object r7 = kotlinx.coroutines.BuildersKt.withContext(r7, r2, r0)     // Catch:{ Exception -> 0x0067 }
                if (r7 != r1) goto L_0x0060
                return r1
            L_0x0060:
                io.flatcircle.coroutinehelper.ApiResult$Companion r5 = io.flatcircle.coroutinehelper.ApiResult.Companion     // Catch:{ Exception -> 0x0067 }
                io.flatcircle.coroutinehelper.ApiResult r5 = r5.success(r7)     // Catch:{ Exception -> 0x0067 }
                return r5
            L_0x0067:
                r5 = move-exception
                io.flatcircle.coroutinehelper.ApiResult$Companion r6 = io.flatcircle.coroutinehelper.ApiResult.Companion
                java.lang.Throwable r5 = (java.lang.Throwable) r5
                io.flatcircle.coroutinehelper.ApiResult r5 = r6.fail(r5)
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.client.BaseNetworkClient.CC.awaitCall$suspendImpl(com.blueair.api.client.BaseNetworkClient, kotlinx.coroutines.Deferred, kotlin.coroutines.Continuation):java.lang.Object");
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x003c  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x0076 A[Catch:{ Exception -> 0x0098 }] */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x0083 A[Catch:{ Exception -> 0x0098 }] */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static /* synthetic */ <Input, Output> java.lang.Object doSuspendedApiCall$suspendImpl(com.blueair.api.client.BaseNetworkClient r5, kotlin.jvm.functions.Function2<? super Input, ? super kotlin.coroutines.Continuation<? super retrofit2.Response<Output>>, ? extends java.lang.Object> r6, Input r7, kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<Output>> r8) {
            /*
                boolean r0 = r8 instanceof com.blueair.api.client.BaseNetworkClient$doSuspendedApiCall$1
                if (r0 == 0) goto L_0x0014
                r0 = r8
                com.blueair.api.client.BaseNetworkClient$doSuspendedApiCall$1 r0 = (com.blueair.api.client.BaseNetworkClient$doSuspendedApiCall$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r1 = r1 & r2
                if (r1 == 0) goto L_0x0014
                int r8 = r0.label
                int r8 = r8 - r2
                r0.label = r8
                goto L_0x0019
            L_0x0014:
                com.blueair.api.client.BaseNetworkClient$doSuspendedApiCall$1 r0 = new com.blueair.api.client.BaseNetworkClient$doSuspendedApiCall$1
                r0.<init>(r5, r8)
            L_0x0019:
                java.lang.Object r8 = r0.result
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r0.label
                r3 = 1
                if (r2 == 0) goto L_0x003c
                if (r2 != r3) goto L_0x0034
                java.lang.Object r5 = r0.L$2
                java.lang.Object r5 = r0.L$1
                kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
                java.lang.Object r5 = r0.L$0
                com.blueair.api.client.BaseNetworkClient r5 = (com.blueair.api.client.BaseNetworkClient) r5
                kotlin.ResultKt.throwOnFailure(r8)     // Catch:{ Exception -> 0x0098 }
                goto L_0x0068
            L_0x0034:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L_0x003c:
                kotlin.ResultKt.throwOnFailure(r8)
                kotlinx.coroutines.CoroutineDispatcher r8 = kotlinx.coroutines.Dispatchers.getIO()     // Catch:{ Exception -> 0x0098 }
                kotlin.coroutines.CoroutineContext r8 = (kotlin.coroutines.CoroutineContext) r8     // Catch:{ Exception -> 0x0098 }
                com.blueair.api.client.BaseNetworkClient$doSuspendedApiCall$response$1 r2 = new com.blueair.api.client.BaseNetworkClient$doSuspendedApiCall$response$1     // Catch:{ Exception -> 0x0098 }
                r4 = 0
                r2.<init>(r6, r7, r4)     // Catch:{ Exception -> 0x0098 }
                kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2     // Catch:{ Exception -> 0x0098 }
                java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r5)     // Catch:{ Exception -> 0x0098 }
                r0.L$0 = r5     // Catch:{ Exception -> 0x0098 }
                java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)     // Catch:{ Exception -> 0x0098 }
                r0.L$1 = r5     // Catch:{ Exception -> 0x0098 }
                java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)     // Catch:{ Exception -> 0x0098 }
                r0.L$2 = r5     // Catch:{ Exception -> 0x0098 }
                r0.label = r3     // Catch:{ Exception -> 0x0098 }
                java.lang.Object r8 = kotlinx.coroutines.BuildersKt.withContext(r8, r2, r0)     // Catch:{ Exception -> 0x0098 }
                if (r8 != r1) goto L_0x0068
                return r1
            L_0x0068:
                retrofit2.Response r8 = (retrofit2.Response) r8     // Catch:{ Exception -> 0x0098 }
                boolean r5 = r8.isSuccessful()     // Catch:{ Exception -> 0x0098 }
                if (r5 == 0) goto L_0x0083
                java.lang.Object r5 = r8.body()     // Catch:{ Exception -> 0x0098 }
                if (r5 == 0) goto L_0x0083
                io.flatcircle.coroutinehelper.Success r5 = new io.flatcircle.coroutinehelper.Success     // Catch:{ Exception -> 0x0098 }
                java.lang.Object r6 = r8.body()     // Catch:{ Exception -> 0x0098 }
                kotlin.jvm.internal.Intrinsics.checkNotNull(r6)     // Catch:{ Exception -> 0x0098 }
                r5.<init>(r6)     // Catch:{ Exception -> 0x0098 }
                return r5
            L_0x0083:
                io.flatcircle.coroutinehelper.Failure r5 = new io.flatcircle.coroutinehelper.Failure     // Catch:{ Exception -> 0x0098 }
                java.lang.Exception r6 = new java.lang.Exception     // Catch:{ Exception -> 0x0098 }
                okhttp3.ResponseBody r7 = r8.errorBody()     // Catch:{ Exception -> 0x0098 }
                java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch:{ Exception -> 0x0098 }
                r6.<init>(r7)     // Catch:{ Exception -> 0x0098 }
                java.lang.Throwable r6 = (java.lang.Throwable) r6     // Catch:{ Exception -> 0x0098 }
                r5.<init>(r6)     // Catch:{ Exception -> 0x0098 }
                return r5
            L_0x0098:
                r5 = move-exception
                io.flatcircle.coroutinehelper.Failure r6 = new io.flatcircle.coroutinehelper.Failure
                java.lang.Throwable r5 = (java.lang.Throwable) r5
                r6.<init>(r5)
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.client.BaseNetworkClient.CC.doSuspendedApiCall$suspendImpl(com.blueair.api.client.BaseNetworkClient, kotlin.jvm.functions.Function2, java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x003e  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x007e A[Catch:{ Exception -> 0x00a4 }] */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x008d A[Catch:{ Exception -> 0x00a4 }] */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static /* synthetic */ <Input1, Input2, Output> java.lang.Object doSuspendedApiCall$suspendImpl(com.blueair.api.client.BaseNetworkClient r5, kotlin.jvm.functions.Function3<? super Input1, ? super Input2, ? super kotlin.coroutines.Continuation<? super retrofit2.Response<Output>>, ? extends java.lang.Object> r6, Input1 r7, Input2 r8, kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<Output>> r9) {
            /*
                boolean r0 = r9 instanceof com.blueair.api.client.BaseNetworkClient$doSuspendedApiCall$2
                if (r0 == 0) goto L_0x0014
                r0 = r9
                com.blueair.api.client.BaseNetworkClient$doSuspendedApiCall$2 r0 = (com.blueair.api.client.BaseNetworkClient$doSuspendedApiCall$2) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r1 = r1 & r2
                if (r1 == 0) goto L_0x0014
                int r9 = r0.label
                int r9 = r9 - r2
                r0.label = r9
                goto L_0x0019
            L_0x0014:
                com.blueair.api.client.BaseNetworkClient$doSuspendedApiCall$2 r0 = new com.blueair.api.client.BaseNetworkClient$doSuspendedApiCall$2
                r0.<init>(r5, r9)
            L_0x0019:
                java.lang.Object r9 = r0.result
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r0.label
                r3 = 1
                if (r2 == 0) goto L_0x003e
                if (r2 != r3) goto L_0x0036
                java.lang.Object r5 = r0.L$3
                java.lang.Object r5 = r0.L$2
                java.lang.Object r5 = r0.L$1
                kotlin.jvm.functions.Function3 r5 = (kotlin.jvm.functions.Function3) r5
                java.lang.Object r5 = r0.L$0
                com.blueair.api.client.BaseNetworkClient r5 = (com.blueair.api.client.BaseNetworkClient) r5
                kotlin.ResultKt.throwOnFailure(r9)     // Catch:{ Exception -> 0x00a4 }
                goto L_0x0070
            L_0x0036:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L_0x003e:
                kotlin.ResultKt.throwOnFailure(r9)
                kotlinx.coroutines.CoroutineDispatcher r9 = kotlinx.coroutines.Dispatchers.getIO()     // Catch:{ Exception -> 0x00a4 }
                kotlin.coroutines.CoroutineContext r9 = (kotlin.coroutines.CoroutineContext) r9     // Catch:{ Exception -> 0x00a4 }
                com.blueair.api.client.BaseNetworkClient$doSuspendedApiCall$response$2 r2 = new com.blueair.api.client.BaseNetworkClient$doSuspendedApiCall$response$2     // Catch:{ Exception -> 0x00a4 }
                r4 = 0
                r2.<init>(r6, r7, r8, r4)     // Catch:{ Exception -> 0x00a4 }
                kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2     // Catch:{ Exception -> 0x00a4 }
                java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r5)     // Catch:{ Exception -> 0x00a4 }
                r0.L$0 = r5     // Catch:{ Exception -> 0x00a4 }
                java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)     // Catch:{ Exception -> 0x00a4 }
                r0.L$1 = r5     // Catch:{ Exception -> 0x00a4 }
                java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)     // Catch:{ Exception -> 0x00a4 }
                r0.L$2 = r5     // Catch:{ Exception -> 0x00a4 }
                java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)     // Catch:{ Exception -> 0x00a4 }
                r0.L$3 = r5     // Catch:{ Exception -> 0x00a4 }
                r0.label = r3     // Catch:{ Exception -> 0x00a4 }
                java.lang.Object r9 = kotlinx.coroutines.BuildersKt.withContext(r9, r2, r0)     // Catch:{ Exception -> 0x00a4 }
                if (r9 != r1) goto L_0x0070
                return r1
            L_0x0070:
                retrofit2.Response r9 = (retrofit2.Response) r9     // Catch:{ Exception -> 0x00a4 }
                boolean r5 = r9.isSuccessful()     // Catch:{ Exception -> 0x00a4 }
                if (r5 == 0) goto L_0x008d
                java.lang.Object r5 = r9.body()     // Catch:{ Exception -> 0x00a4 }
                if (r5 == 0) goto L_0x008d
                io.flatcircle.coroutinehelper.Success r5 = new io.flatcircle.coroutinehelper.Success     // Catch:{ Exception -> 0x00a4 }
                java.lang.Object r6 = r9.body()     // Catch:{ Exception -> 0x00a4 }
                kotlin.jvm.internal.Intrinsics.checkNotNull(r6)     // Catch:{ Exception -> 0x00a4 }
                r5.<init>(r6)     // Catch:{ Exception -> 0x00a4 }
                io.flatcircle.coroutinehelper.ApiResult r5 = (io.flatcircle.coroutinehelper.ApiResult) r5     // Catch:{ Exception -> 0x00a4 }
                return r5
            L_0x008d:
                io.flatcircle.coroutinehelper.Failure r5 = new io.flatcircle.coroutinehelper.Failure     // Catch:{ Exception -> 0x00a4 }
                java.lang.Exception r6 = new java.lang.Exception     // Catch:{ Exception -> 0x00a4 }
                okhttp3.ResponseBody r7 = r9.errorBody()     // Catch:{ Exception -> 0x00a4 }
                java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch:{ Exception -> 0x00a4 }
                r6.<init>(r7)     // Catch:{ Exception -> 0x00a4 }
                java.lang.Throwable r6 = (java.lang.Throwable) r6     // Catch:{ Exception -> 0x00a4 }
                r5.<init>(r6)     // Catch:{ Exception -> 0x00a4 }
                io.flatcircle.coroutinehelper.ApiResult r5 = (io.flatcircle.coroutinehelper.ApiResult) r5     // Catch:{ Exception -> 0x00a4 }
                return r5
            L_0x00a4:
                r5 = move-exception
                io.flatcircle.coroutinehelper.Failure r6 = new io.flatcircle.coroutinehelper.Failure
                java.lang.Throwable r5 = (java.lang.Throwable) r5
                r6.<init>(r5)
                io.flatcircle.coroutinehelper.ApiResult r6 = (io.flatcircle.coroutinehelper.ApiResult) r6
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.client.BaseNetworkClient.CC.doSuspendedApiCall$suspendImpl(com.blueair.api.client.BaseNetworkClient, kotlin.jvm.functions.Function3, java.lang.Object, java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
        }

        public static Retrofit $default$retroFitFactory(BaseNetworkClient _this, String str) {
            Intrinsics.checkNotNullParameter(str, Provision.CONFIG_BASE_URL_KEY);
            Retrofit build = new Retrofit.Builder().baseUrl(str).addConverterFactory(MoshiConverterFactory.create(new Moshi.Builder().add((Object) I18nConfig.Adapter.INSTANCE).add((Object) IpConfig.Adapter.INSTANCE).add(DefaultOnDataMismatchAdapter.newFactory(BlueCloudHomeLocationReceive.class, null)).add((JsonAdapter.Factory) SkipBadElementsListAdapter.Factory.INSTANCE).add((JsonAdapter.Factory) new KotlinJsonAdapterFactory()).build())).addCallAdapterFactory(CoroutineCallAdapterFactory.Companion.create()).client(_this.getOkHttpClient()).build();
            Intrinsics.checkNotNullExpressionValue(build, "build(...)");
            return build;
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: NetworkClient.kt */
    public static final class DefaultImpls {
        @Deprecated
        public static <T> Object awaitCall(BaseNetworkClient baseNetworkClient, Deferred<? extends T> deferred, Continuation<? super ApiResult<T>> continuation) {
            return CC.$default$awaitCall(baseNetworkClient, deferred, continuation);
        }

        @Deprecated
        public static <T> Object awaitAllCalls(BaseNetworkClient baseNetworkClient, List<CallWithInput<T>> list, Continuation<? super ApiResult<List<T>>> continuation) {
            return CC.$default$awaitAllCalls(baseNetworkClient, list, continuation);
        }

        @Deprecated
        public static <Input, Output> Object doSuspendedApiCall(BaseNetworkClient baseNetworkClient, Function2<? super Input, ? super Continuation<? super Response<Output>>, ? extends Object> function2, Input input, Continuation<? super ApiResult<Output>> continuation) {
            return CC.$default$doSuspendedApiCall(baseNetworkClient, function2, input, continuation);
        }

        @Deprecated
        public static <Input1, Input2, Output> Object doSuspendedApiCall(BaseNetworkClient baseNetworkClient, Function3<? super Input1, ? super Input2, ? super Continuation<? super Response<Output>>, ? extends Object> function3, Input1 input1, Input2 input2, Continuation<? super ApiResult<Output>> continuation) {
            return CC.$default$doSuspendedApiCall(baseNetworkClient, function3, input1, input2, continuation);
        }

        @Deprecated
        public static Retrofit retroFitFactory(BaseNetworkClient baseNetworkClient, String str) {
            Intrinsics.checkNotNullParameter(str, Provision.CONFIG_BASE_URL_KEY);
            return CC.$default$retroFitFactory(baseNetworkClient, str);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002BH\u00127\u0010\u0003\u001a3\b\u0001\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\fRD\u0010\u0003\u001a3\b\u0001\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/blueair/api/client/BaseNetworkClient$CallWithInput;", "T", "", "call", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "input", "Lkotlin/coroutines/Continuation;", "Lretrofit2/Response;", "<init>", "(Lkotlin/jvm/functions/Function2;Ljava/lang/String;)V", "getCall", "()Lkotlin/jvm/functions/Function2;", "Lkotlin/jvm/functions/Function2;", "getInput", "()Ljava/lang/String;", "api_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: NetworkClient.kt */
    public static final class CallWithInput<T> {
        private final Function2<String, Continuation<? super Response<T>>, Object> call;
        private final String input;

        public CallWithInput(Function2<? super String, ? super Continuation<? super Response<T>>, ? extends Object> function2, String str) {
            Intrinsics.checkNotNullParameter(function2, NotificationCompat.CATEGORY_CALL);
            Intrinsics.checkNotNullParameter(str, "input");
            this.call = function2;
            this.input = str;
        }

        public final Function2<String, Continuation<? super Response<T>>, Object> getCall() {
            return this.call;
        }

        public final String getInput() {
            return this.input;
        }
    }
}
