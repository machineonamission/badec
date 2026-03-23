package com.blueair.api.client;

import com.blueair.api.client.BaseNetworkClient;
import com.blueair.api.client.CloudNetworkClient;
import com.blueair.api.restapi.DeviceAblRestApi;
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

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u00012\u00020\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lcom/blueair/api/client/AblCloudNetworkClient;", "Lcom/blueair/api/client/CloudNetworkClient;", "Lcom/blueair/api/client/DeviceClient;", "deviceDetailsRestApi", "Lcom/blueair/api/restapi/DeviceAblRestApi;", "getDeviceDetailsRestApi", "()Lcom/blueair/api/restapi/DeviceAblRestApi;", "api_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: NetworkClient.kt */
public interface AblCloudNetworkClient extends CloudNetworkClient, DeviceClient {

    /* renamed from: com.blueair.api.client.AblCloudNetworkClient$-CC  reason: invalid class name */
    /* compiled from: NetworkClient.kt */
    public final /* synthetic */ class CC {
    }

    DeviceAblRestApi getDeviceDetailsRestApi();

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: NetworkClient.kt */
    public static final class DefaultImpls {
        @Deprecated
        public static <T> Object awaitAllCalls(AblCloudNetworkClient ablCloudNetworkClient, List<BaseNetworkClient.CallWithInput<T>> list, Continuation<? super ApiResult<List<T>>> continuation) {
            return BaseNetworkClient.CC.$default$awaitAllCalls(ablCloudNetworkClient, list, continuation);
        }

        @Deprecated
        public static <T> Object awaitCall(AblCloudNetworkClient ablCloudNetworkClient, Deferred<? extends T> deferred, Continuation<? super ApiResult<T>> continuation) {
            return BaseNetworkClient.CC.$default$awaitCall(ablCloudNetworkClient, deferred, continuation);
        }

        @Deprecated
        public static OkHttpClient buildBasicAuthClient(AblCloudNetworkClient ablCloudNetworkClient, Interceptor interceptor) {
            return CloudNetworkClient.CC.$default$buildBasicAuthClient(ablCloudNetworkClient, interceptor);
        }

        @Deprecated
        public static OkHttpClient buildHttpClient(AblCloudNetworkClient ablCloudNetworkClient, boolean z, Interceptor interceptor) {
            return CloudNetworkClient.CC.$default$buildHttpClient(ablCloudNetworkClient, z, interceptor);
        }

        @Deprecated
        public static OkHttpClient buildHttpClientWithFakeUserSupport(AblCloudNetworkClient ablCloudNetworkClient, boolean z, Interceptor interceptor) {
            return CloudNetworkClient.CC.$default$buildHttpClientWithFakeUserSupport(ablCloudNetworkClient, z, interceptor);
        }

        @Deprecated
        public static <Input, Output> Object doSuspendedApiCall(AblCloudNetworkClient ablCloudNetworkClient, Function2<? super Input, ? super Continuation<? super Response<Output>>, ? extends Object> function2, Input input, Continuation<? super ApiResult<Output>> continuation) {
            return BaseNetworkClient.CC.$default$doSuspendedApiCall(ablCloudNetworkClient, function2, input, continuation);
        }

        @Deprecated
        public static <Input1, Input2, Output> Object doSuspendedApiCall(AblCloudNetworkClient ablCloudNetworkClient, Function3<? super Input1, ? super Input2, ? super Continuation<? super Response<Output>>, ? extends Object> function3, Input1 input1, Input2 input2, Continuation<? super ApiResult<Output>> continuation) {
            return BaseNetworkClient.CC.$default$doSuspendedApiCall(ablCloudNetworkClient, function3, input1, input2, continuation);
        }

        @Deprecated
        public static Retrofit retroFitFactory(AblCloudNetworkClient ablCloudNetworkClient, String str) {
            Intrinsics.checkNotNullParameter(str, Provision.CONFIG_BASE_URL_KEY);
            return BaseNetworkClient.CC.$default$retroFitFactory(ablCloudNetworkClient, str);
        }
    }
}
