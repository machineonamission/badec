package com.blueair.api.client;

import com.blueair.api.client.BaseNetworkClient;
import com.blueair.api.client.CloudNetworkClient;
import com.blueair.api.restapi.OutdoorRestApi;
import com.blueair.bluetooth.espressif.Provision;
import io.flatcircle.coroutinehelper.ApiResult;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Deferred;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Response;
import retrofit2.Retrofit;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/blueair/api/client/OutdoorCloudNetworkClient;", "Lcom/blueair/api/client/CloudNetworkClient;", "outdoorRestApi", "Lcom/blueair/api/restapi/OutdoorRestApi;", "getOutdoorRestApi", "()Lcom/blueair/api/restapi/OutdoorRestApi;", "api_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: NetworkClient.kt */
public interface OutdoorCloudNetworkClient extends CloudNetworkClient {

    /* renamed from: com.blueair.api.client.OutdoorCloudNetworkClient$-CC  reason: invalid class name */
    /* compiled from: NetworkClient.kt */
    public final /* synthetic */ class CC {
    }

    OutdoorRestApi getOutdoorRestApi();

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: NetworkClient.kt */
    public static final class DefaultImpls {
        @Deprecated
        public static <T> Object awaitAllCalls(OutdoorCloudNetworkClient outdoorCloudNetworkClient, List<BaseNetworkClient.CallWithInput<T>> list, Continuation<? super ApiResult<List<T>>> continuation) {
            return BaseNetworkClient.CC.$default$awaitAllCalls(outdoorCloudNetworkClient, list, continuation);
        }

        @Deprecated
        public static <T> Object awaitCall(OutdoorCloudNetworkClient outdoorCloudNetworkClient, Deferred<? extends T> deferred, Continuation<? super ApiResult<T>> continuation) {
            return BaseNetworkClient.CC.$default$awaitCall(outdoorCloudNetworkClient, deferred, continuation);
        }

        @Deprecated
        public static OkHttpClient buildBasicAuthClient(OutdoorCloudNetworkClient outdoorCloudNetworkClient, Interceptor interceptor) {
            return CloudNetworkClient.CC.$default$buildBasicAuthClient(outdoorCloudNetworkClient, interceptor);
        }

        @Deprecated
        public static OkHttpClient buildHttpClient(OutdoorCloudNetworkClient outdoorCloudNetworkClient, boolean z, Interceptor interceptor) {
            return CloudNetworkClient.CC.$default$buildHttpClient(outdoorCloudNetworkClient, z, interceptor);
        }

        @Deprecated
        public static OkHttpClient buildHttpClientWithFakeUserSupport(OutdoorCloudNetworkClient outdoorCloudNetworkClient, boolean z, Interceptor interceptor) {
            return CloudNetworkClient.CC.$default$buildHttpClientWithFakeUserSupport(outdoorCloudNetworkClient, z, interceptor);
        }

        @Deprecated
        public static <Input, Output> Object doSuspendedApiCall(OutdoorCloudNetworkClient outdoorCloudNetworkClient, Function2<? super Input, ? super Continuation<? super Response<Output>>, ? extends Object> function2, Input input, Continuation<? super ApiResult<Output>> continuation) {
            return BaseNetworkClient.CC.$default$doSuspendedApiCall(outdoorCloudNetworkClient, function2, input, continuation);
        }

        @Deprecated
        public static <Input1, Input2, Output> Object doSuspendedApiCall(OutdoorCloudNetworkClient outdoorCloudNetworkClient, Function3<? super Input1, ? super Input2, ? super Continuation<? super Response<Output>>, ? extends Object> function3, Input1 input1, Input2 input2, Continuation<? super ApiResult<Output>> continuation) {
            return BaseNetworkClient.CC.$default$doSuspendedApiCall(outdoorCloudNetworkClient, function3, input1, input2, continuation);
        }

        @Deprecated
        public static Retrofit retroFitFactory(OutdoorCloudNetworkClient outdoorCloudNetworkClient, String str) {
            Intrinsics.checkNotNullParameter(str, Provision.CONFIG_BASE_URL_KEY);
            return BaseNetworkClient.CC.$default$retroFitFactory(outdoorCloudNetworkClient, str);
        }
    }
}
