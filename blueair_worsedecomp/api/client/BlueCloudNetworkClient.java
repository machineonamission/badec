package com.blueair.api.client;

import com.blueair.api.client.BaseNetworkClient;
import com.blueair.api.client.CloudNetworkClient;
import com.blueair.api.restapi.BlueCloudRestApi;
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

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u00012\u00020\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lcom/blueair/api/client/BlueCloudNetworkClient;", "Lcom/blueair/api/client/CloudNetworkClient;", "Lcom/blueair/api/client/DeviceClient;", "deviceRestApi", "Lcom/blueair/api/restapi/BlueCloudRestApi;", "getDeviceRestApi", "()Lcom/blueair/api/restapi/BlueCloudRestApi;", "api_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: NetworkClient.kt */
public interface BlueCloudNetworkClient extends CloudNetworkClient, DeviceClient {

    /* renamed from: com.blueair.api.client.BlueCloudNetworkClient$-CC  reason: invalid class name */
    /* compiled from: NetworkClient.kt */
    public final /* synthetic */ class CC {
    }

    BlueCloudRestApi getDeviceRestApi();

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: NetworkClient.kt */
    public static final class DefaultImpls {
        @Deprecated
        public static <T> Object awaitAllCalls(BlueCloudNetworkClient blueCloudNetworkClient, List<BaseNetworkClient.CallWithInput<T>> list, Continuation<? super ApiResult<List<T>>> continuation) {
            return BaseNetworkClient.CC.$default$awaitAllCalls(blueCloudNetworkClient, list, continuation);
        }

        @Deprecated
        public static <T> Object awaitCall(BlueCloudNetworkClient blueCloudNetworkClient, Deferred<? extends T> deferred, Continuation<? super ApiResult<T>> continuation) {
            return BaseNetworkClient.CC.$default$awaitCall(blueCloudNetworkClient, deferred, continuation);
        }

        @Deprecated
        public static OkHttpClient buildBasicAuthClient(BlueCloudNetworkClient blueCloudNetworkClient, Interceptor interceptor) {
            return CloudNetworkClient.CC.$default$buildBasicAuthClient(blueCloudNetworkClient, interceptor);
        }

        @Deprecated
        public static OkHttpClient buildHttpClient(BlueCloudNetworkClient blueCloudNetworkClient, boolean z, Interceptor interceptor) {
            return CloudNetworkClient.CC.$default$buildHttpClient(blueCloudNetworkClient, z, interceptor);
        }

        @Deprecated
        public static OkHttpClient buildHttpClientWithFakeUserSupport(BlueCloudNetworkClient blueCloudNetworkClient, boolean z, Interceptor interceptor) {
            return CloudNetworkClient.CC.$default$buildHttpClientWithFakeUserSupport(blueCloudNetworkClient, z, interceptor);
        }

        @Deprecated
        public static <Input, Output> Object doSuspendedApiCall(BlueCloudNetworkClient blueCloudNetworkClient, Function2<? super Input, ? super Continuation<? super Response<Output>>, ? extends Object> function2, Input input, Continuation<? super ApiResult<Output>> continuation) {
            return BaseNetworkClient.CC.$default$doSuspendedApiCall(blueCloudNetworkClient, function2, input, continuation);
        }

        @Deprecated
        public static <Input1, Input2, Output> Object doSuspendedApiCall(BlueCloudNetworkClient blueCloudNetworkClient, Function3<? super Input1, ? super Input2, ? super Continuation<? super Response<Output>>, ? extends Object> function3, Input1 input1, Input2 input2, Continuation<? super ApiResult<Output>> continuation) {
            return BaseNetworkClient.CC.$default$doSuspendedApiCall(blueCloudNetworkClient, function3, input1, input2, continuation);
        }

        @Deprecated
        public static Retrofit retroFitFactory(BlueCloudNetworkClient blueCloudNetworkClient, String str) {
            Intrinsics.checkNotNullParameter(str, Provision.CONFIG_BASE_URL_KEY);
            return BaseNetworkClient.CC.$default$retroFitFactory(blueCloudNetworkClient, str);
        }
    }
}
