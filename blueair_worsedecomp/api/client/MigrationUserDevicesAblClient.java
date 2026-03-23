package com.blueair.api.client;

import android.content.res.Resources;
import com.blueair.api.client.BaseNetworkClient;
import com.blueair.api.client.CloudNetworkClient;
import com.blueair.api.restapi.MigrationDeviceAblRestApi;
import com.blueair.auth.AuthService;
import com.blueair.auth.LocationService;
import com.blueair.core.model.MigrationOtaResponse;
import io.flatcircle.coroutinehelper.ApiResult;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Deferred;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Response;
import retrofit2.Retrofit;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u001c\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!2\u0006\u0010#\u001a\u00020$H@¢\u0006\u0002\u0010%R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\u0004\u0018\u00010\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0012\u001a\u00020\u00138VX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00198VX\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u001d8BX\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f¨\u0006&"}, d2 = {"Lcom/blueair/api/client/MigrationUserDevicesAblClient;", "Lcom/blueair/api/client/CloudNetworkClient;", "resources", "Landroid/content/res/Resources;", "authService", "Lcom/blueair/auth/AuthService;", "locationService", "Lcom/blueair/auth/LocationService;", "mockInterceptor", "Lokhttp3/Interceptor;", "<init>", "(Landroid/content/res/Resources;Lcom/blueair/auth/AuthService;Lcom/blueair/auth/LocationService;Lokhttp3/Interceptor;)V", "getResources", "()Landroid/content/res/Resources;", "getAuthService", "()Lcom/blueair/auth/AuthService;", "getMockInterceptor", "()Lokhttp3/Interceptor;", "okHttpClient", "Lokhttp3/OkHttpClient;", "getOkHttpClient", "()Lokhttp3/OkHttpClient;", "okHttpClient$delegate", "Lkotlin/Lazy;", "retrofit", "Lretrofit2/Retrofit;", "getRetrofit", "()Lretrofit2/Retrofit;", "migrationUserDevicesRestApi", "Lcom/blueair/api/restapi/MigrationDeviceAblRestApi;", "getMigrationUserDevicesRestApi", "()Lcom/blueair/api/restapi/MigrationDeviceAblRestApi;", "isMigrationOtaRunning", "Lio/flatcircle/coroutinehelper/ApiResult;", "Lcom/blueair/core/model/MigrationOtaResponse;", "deviceUid", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: MigrationUserDevicesAblClient.kt */
public final class MigrationUserDevicesAblClient implements CloudNetworkClient {
    private final AuthService authService;
    private final LocationService locationService;
    private final Interceptor mockInterceptor;
    private final Lazy okHttpClient$delegate;
    private final Resources resources;

    public MigrationUserDevicesAblClient(Resources resources2, AuthService authService2, LocationService locationService2, Interceptor interceptor) {
        Intrinsics.checkNotNullParameter(resources2, "resources");
        Intrinsics.checkNotNullParameter(authService2, "authService");
        Intrinsics.checkNotNullParameter(locationService2, "locationService");
        this.resources = resources2;
        this.authService = authService2;
        this.locationService = locationService2;
        this.mockInterceptor = interceptor;
        this.okHttpClient$delegate = LazyKt.lazy(new MigrationUserDevicesAblClient$$ExternalSyntheticLambda0(this));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MigrationUserDevicesAblClient(Resources resources2, AuthService authService2, LocationService locationService2, Interceptor interceptor, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(resources2, authService2, locationService2, (i & 8) != 0 ? null : interceptor);
    }

    public <T> Object awaitAllCalls(List<BaseNetworkClient.CallWithInput<T>> list, Continuation<? super ApiResult<List<T>>> continuation) {
        return BaseNetworkClient.CC.$default$awaitAllCalls(this, list, continuation);
    }

    public <T> Object awaitCall(Deferred<? extends T> deferred, Continuation<? super ApiResult<T>> continuation) {
        return BaseNetworkClient.CC.$default$awaitCall(this, deferred, continuation);
    }

    public OkHttpClient buildBasicAuthClient(Interceptor interceptor) {
        return CloudNetworkClient.CC.$default$buildBasicAuthClient(this, interceptor);
    }

    public OkHttpClient buildHttpClient(boolean z, Interceptor interceptor) {
        return CloudNetworkClient.CC.$default$buildHttpClient(this, z, interceptor);
    }

    public OkHttpClient buildHttpClientWithFakeUserSupport(boolean z, Interceptor interceptor) {
        return CloudNetworkClient.CC.$default$buildHttpClientWithFakeUserSupport(this, z, interceptor);
    }

    public <Input, Output> Object doSuspendedApiCall(Function2<? super Input, ? super Continuation<? super Response<Output>>, ? extends Object> function2, Input input, Continuation<? super ApiResult<Output>> continuation) {
        return BaseNetworkClient.CC.$default$doSuspendedApiCall(this, function2, input, continuation);
    }

    public <Input1, Input2, Output> Object doSuspendedApiCall(Function3<? super Input1, ? super Input2, ? super Continuation<? super Response<Output>>, ? extends Object> function3, Input1 input1, Input2 input2, Continuation<? super ApiResult<Output>> continuation) {
        return BaseNetworkClient.CC.$default$doSuspendedApiCall(this, function3, input1, input2, continuation);
    }

    public Retrofit retroFitFactory(String str) {
        return BaseNetworkClient.CC.$default$retroFitFactory(this, str);
    }

    public Resources getResources() {
        return this.resources;
    }

    public AuthService getAuthService() {
        return this.authService;
    }

    public Interceptor getMockInterceptor() {
        return this.mockInterceptor;
    }

    public OkHttpClient getOkHttpClient() {
        return (OkHttpClient) this.okHttpClient$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final OkHttpClient okHttpClient_delegate$lambda$0(MigrationUserDevicesAblClient migrationUserDevicesAblClient) {
        return migrationUserDevicesAblClient.buildBasicAuthClient(migrationUserDevicesAblClient.getMockInterceptor());
    }

    public Retrofit getRetrofit() {
        return retroFitFactory(this.locationService.isInChina() ? "http://api-nc.foobot.io" : "https://api-nc.foobot.io");
    }

    private final MigrationDeviceAblRestApi getMigrationUserDevicesRestApi() {
        Object create = getRetrofit().create(MigrationDeviceAblRestApi.class);
        Intrinsics.checkNotNullExpressionValue(create, "create(...)");
        return (MigrationDeviceAblRestApi) create;
    }

    public final Object isMigrationOtaRunning(String str, Continuation<? super ApiResult<MigrationOtaResponse>> continuation) {
        return doSuspendedApiCall(new MigrationUserDevicesAblClient$isMigrationOtaRunning$2(getMigrationUserDevicesRestApi()), str, continuation);
    }
}
