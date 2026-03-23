package com.blueair.api.client;

import android.content.res.Resources;
import com.blueair.api.client.BaseNetworkClient;
import com.blueair.api.client.CloudNetworkClient;
import com.blueair.api.restapi.OutdoorRestApi;
import com.blueair.auth.AuthService;
import com.blueair.core.model.TrackedLocation;
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
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.Retrofit;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0003\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\"0!H@¢\u0006\u0002\u0010$J\u001c\u0010%\u001a\b\u0012\u0004\u0012\u00020#0!2\u0006\u0010&\u001a\u00020#H@¢\u0006\u0002\u0010'J\u001c\u0010(\u001a\b\u0012\u0004\u0012\u00020)0!2\u0006\u0010*\u001a\u00020#H@¢\u0006\u0002\u0010'J\u001c\u0010(\u001a\b\u0012\u0004\u0012\u00020)0!2\u0006\u0010+\u001a\u00020,H@¢\u0006\u0002\u0010-J(\u0010.\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020/0\"0!2\f\u00100\u001a\b\u0012\u0004\u0012\u00020#0\"H@¢\u0006\u0002\u00101J$\u00102\u001a\b\u0012\u0004\u0012\u00020/0!2\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u000204H@¢\u0006\u0002\u00106R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0012\u001a\u00020\u00138VX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00198VX\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u001d8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f¨\u00067"}, d2 = {"Lcom/blueair/api/client/OutdoorClient;", "Lcom/blueair/api/client/OutdoorCloudNetworkClient;", "resources", "Landroid/content/res/Resources;", "authService", "Lcom/blueair/auth/AuthService;", "mockInterceptor", "Lokhttp3/Interceptor;", "<init>", "(Landroid/content/res/Resources;Lcom/blueair/auth/AuthService;Lokhttp3/Interceptor;)V", "getResources", "()Landroid/content/res/Resources;", "getAuthService", "()Lcom/blueair/auth/AuthService;", "setAuthService", "(Lcom/blueair/auth/AuthService;)V", "getMockInterceptor", "()Lokhttp3/Interceptor;", "okHttpClient", "Lokhttp3/OkHttpClient;", "getOkHttpClient", "()Lokhttp3/OkHttpClient;", "okHttpClient$delegate", "Lkotlin/Lazy;", "retrofit", "Lretrofit2/Retrofit;", "getRetrofit", "()Lretrofit2/Retrofit;", "outdoorRestApi", "Lcom/blueair/api/restapi/OutdoorRestApi;", "getOutdoorRestApi", "()Lcom/blueair/api/restapi/OutdoorRestApi;", "getTrackedLocations", "Lio/flatcircle/coroutinehelper/ApiResult;", "", "Lcom/blueair/core/model/TrackedLocation;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addTrackedLocation", "trackedLocation", "(Lcom/blueair/core/model/TrackedLocation;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeTrackedLocation", "Lokhttp3/ResponseBody;", "location", "locationId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAqiDataByLocation", "Lcom/blueair/core/model/AqiData;", "locations", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAqiDataByLatLng", "lat", "", "lon", "(DDLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: OutdoorClient.kt */
public final class OutdoorClient implements OutdoorCloudNetworkClient {
    private AuthService authService;
    private final Interceptor mockInterceptor;
    private final Lazy okHttpClient$delegate;
    private final Resources resources;

    public OutdoorClient(Resources resources2, AuthService authService2, Interceptor interceptor) {
        Intrinsics.checkNotNullParameter(resources2, "resources");
        Intrinsics.checkNotNullParameter(authService2, "authService");
        this.resources = resources2;
        this.authService = authService2;
        this.mockInterceptor = interceptor;
        this.okHttpClient$delegate = LazyKt.lazy(new OutdoorClient$$ExternalSyntheticLambda0(this));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ OutdoorClient(Resources resources2, AuthService authService2, Interceptor interceptor, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(resources2, authService2, (i & 4) != 0 ? null : interceptor);
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

    public void setAuthService(AuthService authService2) {
        Intrinsics.checkNotNullParameter(authService2, "<set-?>");
        this.authService = authService2;
    }

    public Interceptor getMockInterceptor() {
        return this.mockInterceptor;
    }

    public OkHttpClient getOkHttpClient() {
        return (OkHttpClient) this.okHttpClient$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final OkHttpClient okHttpClient_delegate$lambda$0(OutdoorClient outdoorClient) {
        return outdoorClient.buildHttpClient(false, outdoorClient.getMockInterceptor());
    }

    public Retrofit getRetrofit() {
        return retroFitFactory(getAuthService().getBlueHomeHost());
    }

    public OutdoorRestApi getOutdoorRestApi() {
        Object create = getRetrofit().create(OutdoorRestApi.class);
        Intrinsics.checkNotNullExpressionValue(create, "create(...)");
        return (OutdoorRestApi) create;
    }

    public final Object getTrackedLocations(Continuation<? super ApiResult<List<TrackedLocation>>> continuation) {
        return awaitCall(getOutdoorRestApi().getTrackedLocations(), continuation);
    }

    public final Object addTrackedLocation(TrackedLocation trackedLocation, Continuation<? super ApiResult<TrackedLocation>> continuation) {
        return awaitCall(getOutdoorRestApi().addTrackedLocation(trackedLocation), continuation);
    }

    public final Object removeTrackedLocation(TrackedLocation trackedLocation, Continuation<? super ApiResult<ResponseBody>> continuation) {
        return removeTrackedLocation(trackedLocation.getId(), continuation);
    }

    public final Object removeTrackedLocation(String str, Continuation<? super ApiResult<ResponseBody>> continuation) {
        return awaitCall(getOutdoorRestApi().removeTrackedLocation(str), continuation);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: java.util.Collection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: java.util.List} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getAqiDataByLocation(java.util.List<com.blueair.core.model.TrackedLocation> r17, kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<java.util.List<com.blueair.core.model.AqiData>>> r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r18
            boolean r2 = r1 instanceof com.blueair.api.client.OutdoorClient$getAqiDataByLocation$1
            if (r2 == 0) goto L_0x0018
            r2 = r1
            com.blueair.api.client.OutdoorClient$getAqiDataByLocation$1 r2 = (com.blueair.api.client.OutdoorClient$getAqiDataByLocation$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x001d
        L_0x0018:
            com.blueair.api.client.OutdoorClient$getAqiDataByLocation$1 r2 = new com.blueair.api.client.OutdoorClient$getAqiDataByLocation$1
            r2.<init>(r0, r1)
        L_0x001d:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 10
            r6 = 1
            if (r4 == 0) goto L_0x003c
            if (r4 != r6) goto L_0x0034
            java.lang.Object r2 = r2.L$0
            java.util.List r2 = (java.util.List) r2
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x008a
        L_0x0034:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x003c:
            kotlin.ResultKt.throwOnFailure(r1)
            com.blueair.api.restapi.OutdoorRestApi r1 = r0.getOutdoorRestApi()
            r4 = r17
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.util.ArrayList r7 = new java.util.ArrayList
            int r8 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r4, r5)
            r7.<init>(r8)
            java.util.Collection r7 = (java.util.Collection) r7
            java.util.Iterator r4 = r4.iterator()
        L_0x0056:
            boolean r8 = r4.hasNext()
            if (r8 == 0) goto L_0x006a
            java.lang.Object r8 = r4.next()
            com.blueair.core.model.TrackedLocation r8 = (com.blueair.core.model.TrackedLocation) r8
            java.lang.String r8 = r8.getId()
            r7.add(r8)
            goto L_0x0056
        L_0x006a:
            r10 = r7
            java.util.List r10 = (java.util.List) r10
            com.blueair.api.restapi.GetAqiDataByLocationIdReq r9 = new com.blueair.api.restapi.GetAqiDataByLocationIdReq
            r11 = 0
            r13 = 0
            r14 = 6
            r15 = 0
            r9.<init>(r10, r11, r13, r14, r15)
            kotlinx.coroutines.Deferred r1 = r1.getAqiDataByLocationId(r9)
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r17)
            r2.L$0 = r4
            r2.label = r6
            java.lang.Object r1 = r0.awaitCall(r1, r2)
            if (r1 != r3) goto L_0x008a
            return r3
        L_0x008a:
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            io.flatcircle.coroutinehelper.ApiResult$Companion r2 = io.flatcircle.coroutinehelper.ApiResult.Companion
            java.lang.Object r3 = r1.getOrNull()
            java.util.List r3 = (java.util.List) r3
            r4 = 0
            if (r3 == 0) goto L_0x00bf
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.ArrayList r7 = new java.util.ArrayList
            int r5 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r3, r5)
            r7.<init>(r5)
            java.util.Collection r7 = (java.util.Collection) r7
            java.util.Iterator r3 = r3.iterator()
        L_0x00a8:
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x00bc
            java.lang.Object r5 = r3.next()
            com.blueair.core.model.BlueAqiData r5 = (com.blueair.core.model.BlueAqiData) r5
            com.blueair.core.model.AqiData r5 = com.blueair.core.model.BlueAqiData.toAqiData$default(r5, r4, r6, r4)
            r7.add(r5)
            goto L_0x00a8
        L_0x00bc:
            r4 = r7
            java.util.List r4 = (java.util.List) r4
        L_0x00bf:
            io.flatcircle.coroutinehelper.ApiResult r1 = r2.fromResult(r1, r4)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.client.OutdoorClient.getAqiDataByLocation(java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getAqiDataByLatLng(double r17, double r19, kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<com.blueair.core.model.AqiData>> r21) {
        /*
            r16 = this;
            r0 = r16
            r1 = r21
            boolean r2 = r1 instanceof com.blueair.api.client.OutdoorClient$getAqiDataByLatLng$1
            if (r2 == 0) goto L_0x0018
            r2 = r1
            com.blueair.api.client.OutdoorClient$getAqiDataByLatLng$1 r2 = (com.blueair.api.client.OutdoorClient$getAqiDataByLatLng$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x001d
        L_0x0018:
            com.blueair.api.client.OutdoorClient$getAqiDataByLatLng$1 r2 = new com.blueair.api.client.OutdoorClient$getAqiDataByLatLng$1
            r2.<init>(r0, r1)
        L_0x001d:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 1
            if (r4 == 0) goto L_0x003a
            if (r4 != r5) goto L_0x0032
            double r3 = r2.D$1
            double r2 = r2.D$0
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x0061
        L_0x0032:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x003a:
            kotlin.ResultKt.throwOnFailure(r1)
            com.blueair.api.restapi.OutdoorRestApi r1 = r0.getOutdoorRestApi()
            com.blueair.api.restapi.GetAqiDataByLatLngReq r6 = new com.blueair.api.restapi.GetAqiDataByLatLngReq
            r14 = 12
            r15 = 0
            r11 = 0
            r13 = 0
            r7 = r17
            r9 = r19
            r6.<init>(r7, r9, r11, r13, r14, r15)
            kotlinx.coroutines.Deferred r1 = r1.getAqiDataByLatLng(r6)
            r2.D$0 = r7
            r2.D$1 = r9
            r2.label = r5
            java.lang.Object r1 = r0.awaitCall(r1, r2)
            if (r1 != r3) goto L_0x0061
            return r3
        L_0x0061:
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            io.flatcircle.coroutinehelper.ApiResult$Companion r2 = io.flatcircle.coroutinehelper.ApiResult.Companion
            java.lang.Object r3 = r1.getOrNull()
            java.util.List r3 = (java.util.List) r3
            r4 = 0
            if (r3 == 0) goto L_0x0081
            java.lang.Object r3 = kotlin.collections.CollectionsKt.firstOrNull(r3)
            com.blueair.core.model.BlueAqiDataContent r3 = (com.blueair.core.model.BlueAqiDataContent) r3
            if (r3 == 0) goto L_0x0081
            com.blueair.core.model.BlueAqiData r6 = new com.blueair.core.model.BlueAqiData
            java.lang.String r7 = ""
            r6.<init>(r7, r3)
            com.blueair.core.model.AqiData r4 = com.blueair.core.model.BlueAqiData.toAqiData$default(r6, r4, r5, r4)
        L_0x0081:
            io.flatcircle.coroutinehelper.ApiResult r1 = r2.fromResult(r1, r4)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.client.OutdoorClient.getAqiDataByLatLng(double, double, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
