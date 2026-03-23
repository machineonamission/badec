package com.blueair.api.client;

import com.blueair.api.client.BaseNetworkClient;
import com.blueair.auth.AuthService;
import com.blueair.bluetooth.espressif.Provision;
import com.blueair.core.BuildEnvironment;
import com.blueair.core.BuildVariant;
import io.flatcircle.coroutinehelper.ApiResult;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Deferred;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Response;
import retrofit2.Retrofit;
import timber.log.Timber;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\u001a\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u001a\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\r\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u000eÀ\u0006\u0003"}, d2 = {"Lcom/blueair/api/client/CloudNetworkClient;", "Lcom/blueair/api/client/BaseNetworkClient;", "authService", "Lcom/blueair/auth/AuthService;", "getAuthService", "()Lcom/blueair/auth/AuthService;", "buildHttpClient", "Lokhttp3/OkHttpClient;", "isAbl", "", "mockInterceptor", "Lokhttp3/Interceptor;", "buildHttpClientWithFakeUserSupport", "buildBasicAuthClient", "api_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: NetworkClient.kt */
public interface CloudNetworkClient extends BaseNetworkClient {
    OkHttpClient buildBasicAuthClient(Interceptor interceptor);

    OkHttpClient buildHttpClient(boolean z, Interceptor interceptor);

    OkHttpClient buildHttpClientWithFakeUserSupport(boolean z, Interceptor interceptor);

    AuthService getAuthService();

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: NetworkClient.kt */
    public static final class DefaultImpls {
        @Deprecated
        public static <T> Object awaitAllCalls(CloudNetworkClient cloudNetworkClient, List<BaseNetworkClient.CallWithInput<T>> list, Continuation<? super ApiResult<List<T>>> continuation) {
            return BaseNetworkClient.CC.$default$awaitAllCalls(cloudNetworkClient, list, continuation);
        }

        @Deprecated
        public static <T> Object awaitCall(CloudNetworkClient cloudNetworkClient, Deferred<? extends T> deferred, Continuation<? super ApiResult<T>> continuation) {
            return BaseNetworkClient.CC.$default$awaitCall(cloudNetworkClient, deferred, continuation);
        }

        @Deprecated
        public static <Input, Output> Object doSuspendedApiCall(CloudNetworkClient cloudNetworkClient, Function2<? super Input, ? super Continuation<? super Response<Output>>, ? extends Object> function2, Input input, Continuation<? super ApiResult<Output>> continuation) {
            return BaseNetworkClient.CC.$default$doSuspendedApiCall(cloudNetworkClient, function2, input, continuation);
        }

        @Deprecated
        public static <Input1, Input2, Output> Object doSuspendedApiCall(CloudNetworkClient cloudNetworkClient, Function3<? super Input1, ? super Input2, ? super Continuation<? super Response<Output>>, ? extends Object> function3, Input1 input1, Input2 input2, Continuation<? super ApiResult<Output>> continuation) {
            return BaseNetworkClient.CC.$default$doSuspendedApiCall(cloudNetworkClient, function3, input1, input2, continuation);
        }

        @Deprecated
        public static Retrofit retroFitFactory(CloudNetworkClient cloudNetworkClient, String str) {
            Intrinsics.checkNotNullParameter(str, Provision.CONFIG_BASE_URL_KEY);
            return BaseNetworkClient.CC.$default$retroFitFactory(cloudNetworkClient, str);
        }

        @Deprecated
        public static OkHttpClient buildHttpClient(CloudNetworkClient cloudNetworkClient, boolean z, Interceptor interceptor) {
            return CC.$default$buildHttpClient(cloudNetworkClient, z, interceptor);
        }

        @Deprecated
        public static OkHttpClient buildHttpClientWithFakeUserSupport(CloudNetworkClient cloudNetworkClient, boolean z, Interceptor interceptor) {
            return CC.$default$buildHttpClientWithFakeUserSupport(cloudNetworkClient, z, interceptor);
        }

        @Deprecated
        public static OkHttpClient buildBasicAuthClient(CloudNetworkClient cloudNetworkClient, Interceptor interceptor) {
            return CC.$default$buildBasicAuthClient(cloudNetworkClient, interceptor);
        }
    }

    /* renamed from: com.blueair.api.client.CloudNetworkClient$-CC  reason: invalid class name */
    /* compiled from: NetworkClient.kt */
    public final /* synthetic */ class CC {
        public static OkHttpClient $default$buildHttpClient(CloudNetworkClient _this, boolean z, Interceptor interceptor) {
            HttpLoggingInterceptor.Level level;
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor((HttpLoggingInterceptor.Logger) null, 1, (DefaultConstructorMarker) null);
            if (BuildEnvironment.INSTANCE.getVariant() == BuildVariant.RELEASE) {
                level = HttpLoggingInterceptor.Level.NONE;
            } else {
                level = HttpLoggingInterceptor.Level.BODY;
            }
            httpLoggingInterceptor.setLevel(level);
            OkHttpClient.Builder writeTimeout = new OkHttpClient.Builder().addNetworkInterceptor(new CloudNetworkClient$buildHttpClient$$inlined$addNetworkInterceptor$1(z, _this)).addInterceptor(httpLoggingInterceptor).connectTimeout(45, TimeUnit.SECONDS).readTimeout(30, TimeUnit.SECONDS).writeTimeout(30, TimeUnit.SECONDS);
            if (interceptor != null) {
                return writeTimeout.addInterceptor(interceptor).build();
            }
            return writeTimeout.build();
        }

        public static OkHttpClient $default$buildHttpClientWithFakeUserSupport(CloudNetworkClient _this, boolean z, Interceptor interceptor) {
            HttpLoggingInterceptor.Level level;
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor((HttpLoggingInterceptor.Logger) null, 1, (DefaultConstructorMarker) null);
            if (BuildEnvironment.INSTANCE.getVariant() == BuildVariant.RELEASE) {
                level = HttpLoggingInterceptor.Level.NONE;
            } else {
                level = HttpLoggingInterceptor.Level.BODY;
            }
            httpLoggingInterceptor.setLevel(level);
            Timber.Forest.d("", new Object[0]);
            OkHttpClient.Builder writeTimeout = new OkHttpClient.Builder().addNetworkInterceptor(new CloudNetworkClient$buildHttpClientWithFakeUserSupport$$inlined$addNetworkInterceptor$1(z, _this)).addInterceptor(httpLoggingInterceptor).connectTimeout(45, TimeUnit.SECONDS).readTimeout(30, TimeUnit.SECONDS).writeTimeout(30, TimeUnit.SECONDS);
            if (interceptor != null) {
                return writeTimeout.addInterceptor(interceptor).build();
            }
            return writeTimeout.build();
        }

        public static OkHttpClient $default$buildBasicAuthClient(CloudNetworkClient _this, Interceptor interceptor) {
            HttpLoggingInterceptor.Level level;
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor((HttpLoggingInterceptor.Logger) null, 1, (DefaultConstructorMarker) null);
            if (BuildEnvironment.INSTANCE.getVariant() == BuildVariant.RELEASE) {
                level = HttpLoggingInterceptor.Level.NONE;
            } else {
                level = HttpLoggingInterceptor.Level.BODY;
            }
            httpLoggingInterceptor.setLevel(level);
            Timber.Forest.d("", new Object[0]);
            OkHttpClient.Builder writeTimeout = new OkHttpClient.Builder().addNetworkInterceptor(new CloudNetworkClient$buildBasicAuthClient$$inlined$addNetworkInterceptor$1()).addInterceptor(httpLoggingInterceptor).connectTimeout(45, TimeUnit.SECONDS).readTimeout(30, TimeUnit.SECONDS).writeTimeout(30, TimeUnit.SECONDS);
            if (interceptor != null) {
                return writeTimeout.addInterceptor(interceptor).build();
            }
            return writeTimeout.build();
        }
    }
}
