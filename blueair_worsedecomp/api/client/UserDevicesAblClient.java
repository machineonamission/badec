package com.blueair.api.client;

import android.content.res.Resources;
import com.blueair.api.client.BaseNetworkClient;
import com.blueair.api.client.CloudNetworkClient;
import com.blueair.api.restapi.TemperatureAttributeDto;
import com.blueair.api.restapi.UserDevicesAblRestApi;
import com.blueair.auth.AuthService;
import com.blueair.auth.LocationService;
import com.blueair.core.model.DeviceDetailsOnAblServer;
import com.blueair.core.model.MigrationOtaResponse;
import io.flatcircle.coroutinehelper.ApiResult;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
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

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020(0'0&H@¢\u0006\u0002\u0010)J\u001c\u0010*\u001a\b\u0012\u0004\u0012\u00020(0&2\u0006\u0010+\u001a\u00020,H@¢\u0006\u0002\u0010-J\u001c\u0010.\u001a\b\u0012\u0004\u0012\u00020/0&2\u0006\u00100\u001a\u00020,H@¢\u0006\u0002\u0010-J$\u00101\u001a\b\u0012\u0004\u0012\u00020,0&2\u0006\u00100\u001a\u00020,2\u0006\u00102\u001a\u00020,H@¢\u0006\u0002\u00103J\u001c\u00104\u001a\b\u0012\u0004\u0012\u00020/0&2\u0006\u00100\u001a\u00020,H@¢\u0006\u0002\u0010-J\u001c\u00105\u001a\b\u0012\u0004\u0012\u00020/0&2\u0006\u00100\u001a\u00020,H@¢\u0006\u0002\u0010-J\u001c\u00106\u001a\b\u0012\u0004\u0012\u0002070&2\u0006\u00108\u001a\u00020,H@¢\u0006\u0002\u0010-J\u0010\u00109\u001a\u0004\u0018\u00010,H@¢\u0006\u0002\u0010)J\u001c\u0010:\u001a\b\u0012\u0004\u0012\u00020;0&2\u0006\u00100\u001a\u00020,H@¢\u0006\u0002\u0010-R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\u0004\u0018\u00010\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0012\u001a\u00020\u00138VX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00198VX\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u001d8BX\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010 \u001a\u00020!8BX\u0002¢\u0006\f\n\u0004\b$\u0010\u0017\u001a\u0004\b\"\u0010#¨\u0006<"}, d2 = {"Lcom/blueair/api/client/UserDevicesAblClient;", "Lcom/blueair/api/client/CloudNetworkClient;", "resources", "Landroid/content/res/Resources;", "authService", "Lcom/blueair/auth/AuthService;", "locationService", "Lcom/blueair/auth/LocationService;", "mockInterceptor", "Lokhttp3/Interceptor;", "<init>", "(Landroid/content/res/Resources;Lcom/blueair/auth/AuthService;Lcom/blueair/auth/LocationService;Lokhttp3/Interceptor;)V", "getResources", "()Landroid/content/res/Resources;", "getAuthService", "()Lcom/blueair/auth/AuthService;", "getMockInterceptor", "()Lokhttp3/Interceptor;", "okHttpClient", "Lokhttp3/OkHttpClient;", "getOkHttpClient", "()Lokhttp3/OkHttpClient;", "okHttpClient$delegate", "Lkotlin/Lazy;", "retrofit", "Lretrofit2/Retrofit;", "getRetrofit", "()Lretrofit2/Retrofit;", "userDevicesRestApi", "Lcom/blueair/api/restapi/UserDevicesAblRestApi;", "getUserDevicesRestApi", "()Lcom/blueair/api/restapi/UserDevicesAblRestApi;", "migrationUserAblClient", "Lcom/blueair/api/client/MigrationUserDevicesAblClient;", "getMigrationUserAblClient", "()Lcom/blueair/api/client/MigrationUserDevicesAblClient;", "migrationUserAblClient$delegate", "getDevices", "Lio/flatcircle/coroutinehelper/ApiResult;", "", "Lcom/blueair/core/model/DeviceDetailsOnAblServer;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDeviceInfo", "uuid", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeDevice", "", "deviceUid", "repairDevice", "macAddress", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addDevice", "resetAttributes", "setTemperatureUnit", "", "unit", "getTemperatureUnit", "isMigrationOtaRunning", "Lcom/blueair/core/model/MigrationOtaResponse;", "api_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: UserDevicesAblClient.kt */
public final class UserDevicesAblClient implements CloudNetworkClient {
    private final AuthService authService;
    private final LocationService locationService;
    private final Lazy migrationUserAblClient$delegate;
    private final Interceptor mockInterceptor;
    private final Lazy okHttpClient$delegate;
    private final Resources resources;

    public UserDevicesAblClient(Resources resources2, AuthService authService2, LocationService locationService2, Interceptor interceptor) {
        Intrinsics.checkNotNullParameter(resources2, "resources");
        Intrinsics.checkNotNullParameter(authService2, "authService");
        Intrinsics.checkNotNullParameter(locationService2, "locationService");
        this.resources = resources2;
        this.authService = authService2;
        this.locationService = locationService2;
        this.mockInterceptor = interceptor;
        this.okHttpClient$delegate = LazyKt.lazy(new UserDevicesAblClient$$ExternalSyntheticLambda0(this));
        this.migrationUserAblClient$delegate = LazyKt.lazy(new UserDevicesAblClient$$ExternalSyntheticLambda1(this));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UserDevicesAblClient(Resources resources2, AuthService authService2, LocationService locationService2, Interceptor interceptor, int i, DefaultConstructorMarker defaultConstructorMarker) {
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
    public static final OkHttpClient okHttpClient_delegate$lambda$0(UserDevicesAblClient userDevicesAblClient) {
        return userDevicesAblClient.buildHttpClient(true, userDevicesAblClient.getMockInterceptor());
    }

    public Retrofit getRetrofit() {
        return retroFitFactory(getAuthService().getAblHomeHost());
    }

    private final UserDevicesAblRestApi getUserDevicesRestApi() {
        Object create = getRetrofit().create(UserDevicesAblRestApi.class);
        Intrinsics.checkNotNullExpressionValue(create, "create(...)");
        return (UserDevicesAblRestApi) create;
    }

    private final MigrationUserDevicesAblClient getMigrationUserAblClient() {
        return (MigrationUserDevicesAblClient) this.migrationUserAblClient$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final MigrationUserDevicesAblClient migrationUserAblClient_delegate$lambda$1(UserDevicesAblClient userDevicesAblClient) {
        return new MigrationUserDevicesAblClient(userDevicesAblClient.getResources(), userDevicesAblClient.getAuthService(), userDevicesAblClient.locationService, (Interceptor) null, 8, (DefaultConstructorMarker) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0061, code lost:
        if (r10 == r1) goto L_0x00d5;
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getDevices(kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<java.util.List<com.blueair.core.model.DeviceDetailsOnAblServer>>> r10) {
        /*
            r9 = this;
            boolean r0 = r10 instanceof com.blueair.api.client.UserDevicesAblClient$getDevices$1
            if (r0 == 0) goto L_0x0014
            r0 = r10
            com.blueair.api.client.UserDevicesAblClient$getDevices$1 r0 = (com.blueair.api.client.UserDevicesAblClient$getDevices$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L_0x0019
        L_0x0014:
            com.blueair.api.client.UserDevicesAblClient$getDevices$1 r0 = new com.blueair.api.client.UserDevicesAblClient$getDevices$1
            r0.<init>(r9, r10)
        L_0x0019:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0041
            if (r2 == r4) goto L_0x003d
            if (r2 != r3) goto L_0x0035
            java.lang.Object r1 = r0.L$1
            java.util.List r1 = (java.util.List) r1
            java.lang.Object r0 = r0.L$0
            io.flatcircle.coroutinehelper.ApiResult r0 = (io.flatcircle.coroutinehelper.ApiResult) r0
            kotlin.ResultKt.throwOnFailure(r10)
            return r10
        L_0x0035:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0064
        L_0x0041:
            kotlin.ResultKt.throwOnFailure(r10)
            com.blueair.api.client.UserDevicesAblClient$getDevices$sparseDevices$1 r10 = new com.blueair.api.client.UserDevicesAblClient$getDevices$sparseDevices$1
            com.blueair.api.restapi.UserDevicesAblRestApi r2 = r9.getUserDevicesRestApi()
            r10.<init>(r2)
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            com.blueair.auth.AuthService r2 = r9.getAuthService()
            com.blueair.auth.retrofit.AblUserApi$AblUser r2 = r2.getAblUser()
            java.lang.String r2 = r2.getUsername()
            r0.label = r4
            java.lang.Object r10 = r9.doSuspendedApiCall(r10, r2, r0)
            if (r10 != r1) goto L_0x0064
            goto L_0x00d5
        L_0x0064:
            io.flatcircle.coroutinehelper.ApiResult r10 = (io.flatcircle.coroutinehelper.ApiResult) r10
            boolean r2 = r10.isFailure()
            r4 = 0
            if (r2 == 0) goto L_0x0074
            io.flatcircle.coroutinehelper.ApiResult$Companion r0 = io.flatcircle.coroutinehelper.ApiResult.Companion
            io.flatcircle.coroutinehelper.ApiResult r10 = r0.fromResult(r10, r4)
            return r10
        L_0x0074:
            java.lang.Object r2 = r10.getOrNull()
            java.util.List r2 = (java.util.List) r2
            if (r2 == 0) goto L_0x00b5
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.ArrayList r4 = new java.util.ArrayList
            r5 = 10
            int r5 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r2, r5)
            r4.<init>(r5)
            java.util.Collection r4 = (java.util.Collection) r4
            java.util.Iterator r2 = r2.iterator()
        L_0x008f:
            boolean r5 = r2.hasNext()
            if (r5 == 0) goto L_0x00b3
            java.lang.Object r5 = r2.next()
            com.blueair.api.restapi.DeviceSparseOnAblServer r5 = (com.blueair.api.restapi.DeviceSparseOnAblServer) r5
            com.blueair.api.client.BaseNetworkClient$CallWithInput r6 = new com.blueair.api.client.BaseNetworkClient$CallWithInput
            com.blueair.api.client.UserDevicesAblClient$getDevices$detailDeviceCalls$1$1 r7 = new com.blueair.api.client.UserDevicesAblClient$getDevices$detailDeviceCalls$1$1
            com.blueair.api.restapi.UserDevicesAblRestApi r8 = r9.getUserDevicesRestApi()
            r7.<init>(r8)
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            java.lang.String r5 = r5.getUuid()
            r6.<init>(r7, r5)
            r4.add(r6)
            goto L_0x008f
        L_0x00b3:
            java.util.List r4 = (java.util.List) r4
        L_0x00b5:
            r2 = r4
            java.util.Collection r2 = (java.util.Collection) r2
            if (r2 == 0) goto L_0x00d7
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x00c1
            goto L_0x00d7
        L_0x00c1:
            java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r10)
            r0.L$0 = r10
            java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r4)
            r0.L$1 = r10
            r0.label = r3
            java.lang.Object r10 = r9.awaitAllCalls(r4, r0)
            if (r10 != r1) goto L_0x00d6
        L_0x00d5:
            return r1
        L_0x00d6:
            return r10
        L_0x00d7:
            io.flatcircle.coroutinehelper.Success r10 = new io.flatcircle.coroutinehelper.Success
            java.util.List r0 = kotlin.collections.CollectionsKt.emptyList()
            r10.<init>(r0)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.client.UserDevicesAblClient.getDevices(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object getDeviceInfo(String str, Continuation<? super ApiResult<DeviceDetailsOnAblServer>> continuation) {
        return doSuspendedApiCall(new UserDevicesAblClient$getDeviceInfo$2(getUserDevicesRestApi()), str, continuation);
    }

    public final Object removeDevice(String str, Continuation<? super ApiResult<Object>> continuation) {
        return doSuspendedApiCall(new UserDevicesAblClient$removeDevice$2(getUserDevicesRestApi()), getAuthService().getAblUser().getUsername(), str, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object repairDevice(java.lang.String r5, java.lang.String r6, kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<java.lang.String>> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.blueair.api.client.UserDevicesAblClient$repairDevice$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            com.blueair.api.client.UserDevicesAblClient$repairDevice$1 r0 = (com.blueair.api.client.UserDevicesAblClient$repairDevice$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            com.blueair.api.client.UserDevicesAblClient$repairDevice$1 r0 = new com.blueair.api.client.UserDevicesAblClient$repairDevice$1
            r0.<init>(r4, r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003a
            if (r2 != r3) goto L_0x0032
            java.lang.Object r5 = r0.L$1
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r5 = r0.L$0
            java.lang.String r5 = (java.lang.String) r5
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x005e
        L_0x0032:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x003a:
            kotlin.ResultKt.throwOnFailure(r7)
            com.blueair.api.client.UserDevicesAblClient$repairDevice$result$1 r7 = new com.blueair.api.client.UserDevicesAblClient$repairDevice$result$1
            com.blueair.api.restapi.UserDevicesAblRestApi r2 = r4.getUserDevicesRestApi()
            r7.<init>(r2)
            kotlin.jvm.functions.Function3 r7 = (kotlin.jvm.functions.Function3) r7
            com.blueair.api.restapi.RepairBody r2 = new com.blueair.api.restapi.RepairBody
            r2.<init>(r5, r6)
            r0.L$0 = r5
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)
            r0.L$1 = r6
            r0.label = r3
            java.lang.Object r7 = r4.doSuspendedApiCall(r7, r5, r2, r0)
            if (r7 != r1) goto L_0x005e
            return r1
        L_0x005e:
            io.flatcircle.coroutinehelper.ApiResult r7 = (io.flatcircle.coroutinehelper.ApiResult) r7
            java.lang.Object r6 = r7.getOrNull()
            com.blueair.api.restapi.RepairBody r6 = (com.blueair.api.restapi.RepairBody) r6
            if (r6 == 0) goto L_0x006d
            java.lang.String r6 = r6.getUuid()
            goto L_0x006e
        L_0x006d:
            r6 = 0
        L_0x006e:
            r0 = r6
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L_0x0081
            int r0 = r0.length()
            if (r0 != 0) goto L_0x007a
            goto L_0x0081
        L_0x007a:
            io.flatcircle.coroutinehelper.ApiResult$Companion r5 = io.flatcircle.coroutinehelper.ApiResult.Companion
            io.flatcircle.coroutinehelper.ApiResult r5 = r5.success(r6)
            return r5
        L_0x0081:
            io.flatcircle.coroutinehelper.ApiResult$Companion r6 = io.flatcircle.coroutinehelper.ApiResult.Companion
            io.flatcircle.coroutinehelper.ApiResult r5 = r6.fromResult(r7, r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.client.UserDevicesAblClient.repairDevice(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object addDevice(String str, Continuation<? super ApiResult<Object>> continuation) {
        return doSuspendedApiCall(new UserDevicesAblClient$addDevice$2(getUserDevicesRestApi()), getAuthService().getAblUser().getUsername(), str, continuation);
    }

    public final Object resetAttributes(String str, Continuation<? super ApiResult<Object>> continuation) {
        return doSuspendedApiCall(new UserDevicesAblClient$resetAttributes$2(getUserDevicesRestApi()), str, continuation);
    }

    public final Object setTemperatureUnit(String str, Continuation<? super ApiResult<Unit>> continuation) {
        return doSuspendedApiCall(new UserDevicesAblClient$setTemperatureUnit$2(getUserDevicesRestApi()), getAuthService().getAblUser().getUsername(), new TemperatureAttributeDto(str, str, getAuthService().getAblUser().getId(), (String) null, (String) null, 24, (DefaultConstructorMarker) null), continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0064 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getTemperatureUnit(kotlin.coroutines.Continuation<? super java.lang.String> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.blueair.api.client.UserDevicesAblClient$getTemperatureUnit$1
            if (r0 == 0) goto L_0x0014
            r0 = r5
            com.blueair.api.client.UserDevicesAblClient$getTemperatureUnit$1 r0 = (com.blueair.api.client.UserDevicesAblClient$getTemperatureUnit$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r5 = r0.label
            int r5 = r5 - r2
            r0.label = r5
            goto L_0x0019
        L_0x0014:
            com.blueair.api.client.UserDevicesAblClient$getTemperatureUnit$1 r0 = new com.blueair.api.client.UserDevicesAblClient$getTemperatureUnit$1
            r0.<init>(r4, r5)
        L_0x0019:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x0055
        L_0x002a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r5)
            com.blueair.api.client.UserDevicesAblClient$getTemperatureUnit$2 r5 = new com.blueair.api.client.UserDevicesAblClient$getTemperatureUnit$2
            com.blueair.api.restapi.UserDevicesAblRestApi r2 = r4.getUserDevicesRestApi()
            r5.<init>(r2)
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
            com.blueair.auth.AuthService r2 = r4.getAuthService()
            com.blueair.auth.retrofit.AblUserApi$AblUser r2 = r2.getAblUser()
            java.lang.String r2 = r2.getUsername()
            r0.label = r3
            java.lang.Object r5 = r4.doSuspendedApiCall(r5, r2, r0)
            if (r5 != r1) goto L_0x0055
            return r1
        L_0x0055:
            io.flatcircle.coroutinehelper.ApiResult r5 = (io.flatcircle.coroutinehelper.ApiResult) r5
            java.lang.Object r5 = r5.getOrNull()
            com.blueair.api.restapi.TemperatureAttributeDto r5 = (com.blueair.api.restapi.TemperatureAttributeDto) r5
            if (r5 == 0) goto L_0x0064
            java.lang.String r5 = r5.getCurrentValue()
            return r5
        L_0x0064:
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.client.UserDevicesAblClient.getTemperatureUnit(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object isMigrationOtaRunning(String str, Continuation<? super ApiResult<MigrationOtaResponse>> continuation) {
        return getMigrationUserAblClient().isMigrationOtaRunning(str, continuation);
    }
}
