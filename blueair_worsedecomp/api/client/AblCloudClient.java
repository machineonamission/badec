package com.blueair.api.client;

import android.content.res.Resources;
import com.blueair.api.client.BaseNetworkClient;
import com.blueair.api.client.CloudNetworkClient;
import com.blueair.api.model.DeviceInfoData;
import com.blueair.api.restapi.DeviceAblRestApi;
import com.blueair.api.restapi.DeviceAttributeName;
import com.blueair.api.restapi.DeviceAttributeOnAbl;
import com.blueair.api.restapi.SimpleResponse;
import com.blueair.auth.AuthService;
import com.blueair.core.model.DeviceSchedule;
import com.blueair.core.model.LegacyDeviceSchedule;
import io.flatcircle.coroutinehelper.ApiResult;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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
import timber.log.Timber;

@Metadata(d1 = {"\u0000Ì\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\t2\u00020\n2\u00020\u000b2\u00020\fB+\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u0014\u00101\u001a\b\u0012\u0004\u0012\u00020302H@¢\u0006\u0002\u00104J\"\u00105\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020306022\u0006\u00107\u001a\u000208H@¢\u0006\u0002\u00109J\u001a\u0010:\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020;0602H@¢\u0006\u0002\u00104J\u0018\u0010<\u001a\u00020;2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\u0012H\u0002J\u001c\u0010@\u001a\b\u0012\u0004\u0012\u00020A022\u0006\u0010B\u001a\u00020CH@¢\u0006\u0002\u0010DJ\u001c\u0010E\u001a\b\u0012\u0004\u0012\u00020A022\u0006\u0010F\u001a\u00020CH@¢\u0006\u0002\u0010DJ\u001c\u0010G\u001a\b\u0012\u0004\u0012\u00020A022\u0006\u0010H\u001a\u00020CH@¢\u0006\u0002\u0010DJ\u001c\u0010I\u001a\b\u0012\u0004\u0012\u00020A022\u0006\u0010J\u001a\u00020CH@¢\u0006\u0002\u0010DJ\u001a\u0010K\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120602H@¢\u0006\u0002\u00104J\u001c\u0010L\u001a\b\u0012\u0004\u0012\u00020A022\u0006\u0010M\u001a\u00020\u0012H@¢\u0006\u0002\u0010NJ\u001c\u0010O\u001a\b\u0012\u0004\u0012\u00020A022\u0006\u0010M\u001a\u00020\u0012H@¢\u0006\u0002\u0010NJ\u0014\u0010P\u001a\b\u0012\u0004\u0012\u00020Q02H@¢\u0006\u0002\u00104J\u001c\u0010R\u001a\b\u0012\u0004\u0012\u00020Q022\u0006\u0010?\u001a\u00020QH@¢\u0006\u0002\u0010SJ\u0014\u0010T\u001a\b\u0012\u0004\u0012\u00020U02H@¢\u0006\u0002\u00104J\u001c\u0010V\u001a\b\u0012\u0004\u0012\u00020Q022\u0006\u0010W\u001a\u00020UH@¢\u0006\u0002\u0010XJ\u0014\u0010Y\u001a\b\u0012\u0004\u0012\u00020Z02H@¢\u0006\u0002\u00104J\u001c\u0010[\u001a\b\u0012\u0004\u0012\u00020\\022\u0006\u0010]\u001a\u00020^H@¢\u0006\u0002\u0010_J\u0016\u0010`\u001a\u00020a2\u0006\u0010b\u001a\u00020\u0012H@¢\u0006\u0002\u0010NJ\u001e\u0010c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010Q022\u0006\u0010]\u001a\u00020^H@¢\u0006\u0002\u0010_J\u001a\u0010d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020^0602H@¢\u0006\u0002\u00104J\u001c\u0010e\u001a\b\u0012\u0004\u0012\u00020Q022\u0006\u0010?\u001a\u00020\u0012H@¢\u0006\u0002\u0010NJ\u001c\u0010f\u001a\b\u0012\u0004\u0012\u00020A022\u0006\u0010g\u001a\u00020\u0012H@¢\u0006\u0002\u0010NJ\u0014\u0010h\u001a\b\u0012\u0004\u0012\u00020\u001202H@¢\u0006\u0002\u00104J\b\u0010i\u001a\u00020aH\u0016R\u0014\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u001b\u0010#\u001a\u00020$8VX\u0002¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b%\u0010&R\u0014\u0010)\u001a\u00020*8VX\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,R\u0014\u0010-\u001a\u00020.8VX\u0004¢\u0006\u0006\u001a\u0004\b/\u00100¨\u0006j"}, d2 = {"Lcom/blueair/api/client/AblCloudClient;", "Lcom/blueair/api/client/AblCloudNetworkClient;", "Lcom/blueair/api/client/CanGetSensorData;", "Lcom/blueair/api/client/CanGetAttributes;", "Lcom/blueair/api/client/CanSetFan;", "Lcom/blueair/api/client/CanSetBrightness;", "Lcom/blueair/api/client/CanSetChildLock;", "Lcom/blueair/api/client/CanLinkWithAware;", "Lcom/blueair/api/client/CanSetAutoModeDependency;", "Lcom/blueair/api/client/CanSetDeviceName;", "Lcom/blueair/api/client/CanManageSchedule;", "Lcom/blueair/api/client/CanSetFilterType;", "Lcom/blueair/api/client/CanGetStatus;", "resources", "Landroid/content/res/Resources;", "authService", "Lcom/blueair/auth/AuthService;", "deviceUuid", "", "mockInterceptor", "Lokhttp3/Interceptor;", "<init>", "(Landroid/content/res/Resources;Lcom/blueair/auth/AuthService;Ljava/lang/String;Lokhttp3/Interceptor;)V", "getResources", "()Landroid/content/res/Resources;", "getAuthService", "()Lcom/blueair/auth/AuthService;", "setAuthService", "(Lcom/blueair/auth/AuthService;)V", "getDeviceUuid", "()Ljava/lang/String;", "setDeviceUuid", "(Ljava/lang/String;)V", "getMockInterceptor", "()Lokhttp3/Interceptor;", "okHttpClient", "Lokhttp3/OkHttpClient;", "getOkHttpClient", "()Lokhttp3/OkHttpClient;", "okHttpClient$delegate", "Lkotlin/Lazy;", "retrofit", "Lretrofit2/Retrofit;", "getRetrofit", "()Lretrofit2/Retrofit;", "deviceDetailsRestApi", "Lcom/blueair/api/restapi/DeviceAblRestApi;", "getDeviceDetailsRestApi", "()Lcom/blueair/api/restapi/DeviceAblRestApi;", "getLatestSensorPoint", "Lio/flatcircle/coroutinehelper/ApiResult;", "Lcom/blueair/core/model/IndoorDatapoint;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMonthSensorPoints", "", "fromTime", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAttributes", "Lcom/blueair/api/restapi/DeviceAttributeOnAbl;", "attributeForPost", "attribute", "Lcom/blueair/api/restapi/DeviceAttributeName;", "nuValue", "setFanSpeed", "Lcom/blueair/api/restapi/SimpleResponse;", "fanSpeed", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setAutoMode", "enabled", "setBrightness", "brightness", "setChildLock", "isLocked", "getLink", "setLink", "linkedUid", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteLink", "resetAutoModeDependency", "", "setAutoModeDependency", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDeviceInfoData", "Lcom/blueair/api/model/DeviceInfoData;", "setDeviceInfoData", "nuData", "(Lcom/blueair/api/model/DeviceInfoData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getIsUpdating", "", "createSchedule", "Lokhttp3/ResponseBody;", "schedule", "Lcom/blueair/core/model/DeviceSchedule;", "(Lcom/blueair/core/model/DeviceSchedule;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteSchedule", "", "scheduleId", "updateSchedule", "getSchedules", "setDeviceName", "setFilterType", "nuFilter", "getDeviceStatus", "clear", "api_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: AblCloudClient.kt */
public final class AblCloudClient implements AblCloudNetworkClient, CanGetSensorData, CanGetAttributes, CanSetFan, CanSetBrightness, CanSetChildLock, CanLinkWithAware, CanSetAutoModeDependency, CanSetDeviceName, CanManageSchedule, CanSetFilterType, CanGetStatus {
    private AuthService authService;
    private String deviceUuid;
    private final Interceptor mockInterceptor;
    private final Lazy okHttpClient$delegate;
    private final Resources resources;

    public void clear() {
    }

    public AblCloudClient(Resources resources2, AuthService authService2, String str, Interceptor interceptor) {
        Intrinsics.checkNotNullParameter(resources2, "resources");
        Intrinsics.checkNotNullParameter(authService2, "authService");
        Intrinsics.checkNotNullParameter(str, "deviceUuid");
        this.resources = resources2;
        this.authService = authService2;
        this.deviceUuid = str;
        this.mockInterceptor = interceptor;
        this.okHttpClient$delegate = LazyKt.lazy(new AblCloudClient$$ExternalSyntheticLambda0(this));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AblCloudClient(Resources resources2, AuthService authService2, String str, Interceptor interceptor, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(resources2, authService2, str, (i & 8) != 0 ? null : interceptor);
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

    public String getDeviceUuid() {
        return this.deviceUuid;
    }

    public void setDeviceUuid(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.deviceUuid = str;
    }

    public Interceptor getMockInterceptor() {
        return this.mockInterceptor;
    }

    public OkHttpClient getOkHttpClient() {
        return (OkHttpClient) this.okHttpClient$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final OkHttpClient okHttpClient_delegate$lambda$0(AblCloudClient ablCloudClient) {
        return ablCloudClient.buildHttpClient(true, ablCloudClient.getMockInterceptor());
    }

    public Retrofit getRetrofit() {
        return retroFitFactory(getAuthService().getAblHomeHost());
    }

    public DeviceAblRestApi getDeviceDetailsRestApi() {
        Object create = getRetrofit().create(DeviceAblRestApi.class);
        Intrinsics.checkNotNullExpressionValue(create, "create(...)");
        return (DeviceAblRestApi) create;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v9, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: com.blueair.core.model.IndoorDatapoint} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object getLatestSensorPoint(kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<com.blueair.core.model.IndoorDatapoint>> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.blueair.api.client.AblCloudClient$getLatestSensorPoint$1
            if (r0 == 0) goto L_0x0014
            r0 = r5
            com.blueair.api.client.AblCloudClient$getLatestSensorPoint$1 r0 = (com.blueair.api.client.AblCloudClient$getLatestSensorPoint$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r5 = r0.label
            int r5 = r5 - r2
            r0.label = r5
            goto L_0x0019
        L_0x0014:
            com.blueair.api.client.AblCloudClient$getLatestSensorPoint$1 r0 = new com.blueair.api.client.AblCloudClient$getLatestSensorPoint$1
            r0.<init>(r4, r5)
        L_0x0019:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x004a
        L_0x002a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r5)
            com.blueair.api.restapi.DeviceAblRestApi r5 = r4.getDeviceDetailsRestApi()
            java.lang.String r2 = r4.getDeviceUuid()
            kotlinx.coroutines.Deferred r5 = r5.getDatapoint(r2)
            r0.label = r3
            java.lang.Object r5 = r4.awaitCall(r5, r0)
            if (r5 != r1) goto L_0x004a
            return r1
        L_0x004a:
            io.flatcircle.coroutinehelper.ApiResult r5 = (io.flatcircle.coroutinehelper.ApiResult) r5
            boolean r0 = r5.isFailure()
            r1 = 0
            if (r0 == 0) goto L_0x005a
            io.flatcircle.coroutinehelper.ApiResult$Companion r0 = io.flatcircle.coroutinehelper.ApiResult.Companion
            io.flatcircle.coroutinehelper.ApiResult r5 = r0.fromResult(r5, r1)
            return r5
        L_0x005a:
            java.lang.Object r0 = r5.getOrNull()
            com.blueair.api.restapi.DatapointsWrapper r0 = (com.blueair.api.restapi.DatapointsWrapper) r0
            if (r0 == 0) goto L_0x006f
            java.util.List r0 = r0.convertToIndoorDataPoints()
            if (r0 == 0) goto L_0x006f
            java.lang.Object r0 = kotlin.collections.CollectionsKt.firstOrNull(r0)
            r1 = r0
            com.blueair.core.model.IndoorDatapoint r1 = (com.blueair.core.model.IndoorDatapoint) r1
        L_0x006f:
            if (r1 != 0) goto L_0x0080
            io.flatcircle.coroutinehelper.Failure r5 = new io.flatcircle.coroutinehelper.Failure
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "You're not supposed to make this call on this device"
            r0.<init>(r1)
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            r5.<init>(r0)
            return r5
        L_0x0080:
            io.flatcircle.coroutinehelper.ApiResult$Companion r0 = io.flatcircle.coroutinehelper.ApiResult.Companion
            io.flatcircle.coroutinehelper.ApiResult r5 = r0.fromResult(r5, r1)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.client.AblCloudClient.getLatestSensorPoint(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object getMonthSensorPoints(long r11, kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<java.util.List<com.blueair.core.model.IndoorDatapoint>>> r13) {
        /*
            r10 = this;
            boolean r0 = r13 instanceof com.blueair.api.client.AblCloudClient$getMonthSensorPoints$1
            if (r0 == 0) goto L_0x0014
            r0 = r13
            com.blueair.api.client.AblCloudClient$getMonthSensorPoints$1 r0 = (com.blueair.api.client.AblCloudClient$getMonthSensorPoints$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r13 = r0.label
            int r13 = r13 - r2
            r0.label = r13
            goto L_0x0019
        L_0x0014:
            com.blueair.api.client.AblCloudClient$getMonthSensorPoints$1 r0 = new com.blueair.api.client.AblCloudClient$getMonthSensorPoints$1
            r0.<init>(r10, r13)
        L_0x0019:
            java.lang.Object r13 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0044
            if (r2 != r3) goto L_0x003c
            long r11 = r0.J$0
            java.lang.Object r11 = r0.L$3
            java.lang.String r11 = (java.lang.String) r11
            java.lang.Object r11 = r0.L$2
            java.lang.String r11 = (java.lang.String) r11
            java.lang.Object r11 = r0.L$1
            java.util.Calendar r11 = (java.util.Calendar) r11
            java.lang.Object r11 = r0.L$0
            java.text.SimpleDateFormat r11 = (java.text.SimpleDateFormat) r11
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x009a
        L_0x003c:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x0044:
            kotlin.ResultKt.throwOnFailure(r13)
            java.text.SimpleDateFormat r13 = new java.text.SimpleDateFormat
            java.lang.String r2 = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"
            r13.<init>(r2)
            java.util.Calendar r2 = java.util.Calendar.getInstance()
            java.util.Date r4 = r2.getTime()
            java.lang.String r4 = r13.format(r4)
            java.util.Date r5 = new java.util.Date
            r5.<init>(r11)
            java.lang.String r5 = r13.format(r5)
            com.blueair.api.restapi.DeviceAblRestApi r6 = r10.getDeviceDetailsRestApi()
            java.lang.String r7 = r10.getDeviceUuid()
            java.lang.String r8 = r5.toString()
            java.lang.String r9 = r4.toString()
            kotlinx.coroutines.Deferred r6 = r6.getMonthDatapoints(r7, r8, r9)
            java.lang.Object r13 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r13)
            r0.L$0 = r13
            java.lang.Object r13 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r0.L$1 = r13
            java.lang.Object r13 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r4)
            r0.L$2 = r13
            java.lang.Object r13 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r5)
            r0.L$3 = r13
            r0.J$0 = r11
            r0.label = r3
            java.lang.Object r13 = r10.awaitCall(r6, r0)
            if (r13 != r1) goto L_0x009a
            return r1
        L_0x009a:
            io.flatcircle.coroutinehelper.ApiResult r13 = (io.flatcircle.coroutinehelper.ApiResult) r13
            boolean r11 = r13.isFailure()
            r12 = 0
            if (r11 == 0) goto L_0x00aa
            io.flatcircle.coroutinehelper.ApiResult$Companion r11 = io.flatcircle.coroutinehelper.ApiResult.Companion
            io.flatcircle.coroutinehelper.ApiResult r11 = r11.fromResult(r13, r12)
            return r11
        L_0x00aa:
            java.lang.Object r11 = r13.getOrNull()
            com.blueair.api.restapi.DatapointsWrapper r11 = (com.blueair.api.restapi.DatapointsWrapper) r11
            if (r11 == 0) goto L_0x00b6
            java.util.List r12 = r11.convertToIndoorDataPoints()
        L_0x00b6:
            if (r12 != 0) goto L_0x00c7
            io.flatcircle.coroutinehelper.Failure r11 = new io.flatcircle.coroutinehelper.Failure
            java.lang.IllegalArgumentException r12 = new java.lang.IllegalArgumentException
            java.lang.String r13 = "You're not supposed to make this call on this device"
            r12.<init>(r13)
            java.lang.Throwable r12 = (java.lang.Throwable) r12
            r11.<init>(r12)
            return r11
        L_0x00c7:
            io.flatcircle.coroutinehelper.ApiResult$Companion r11 = io.flatcircle.coroutinehelper.ApiResult.Companion
            io.flatcircle.coroutinehelper.ApiResult r11 = r11.fromResult(r13, r12)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.client.AblCloudClient.getMonthSensorPoints(long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public Object getAttributes(Continuation<? super ApiResult<List<DeviceAttributeOnAbl>>> continuation) {
        return awaitCall(getDeviceDetailsRestApi().getAttributes(getDeviceUuid()), continuation);
    }

    private final DeviceAttributeOnAbl attributeForPost(DeviceAttributeName deviceAttributeName, String str) {
        return new DeviceAttributeOnAbl(Integer.valueOf(getAuthService().getUserId()), getDeviceUuid(), (String) null, deviceAttributeName.getAttributeName(), str, str, 4, (DefaultConstructorMarker) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a2 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object setFanSpeed(int r8, kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<com.blueair.api.restapi.SimpleResponse>> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.blueair.api.client.AblCloudClient$setFanSpeed$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            com.blueair.api.client.AblCloudClient$setFanSpeed$1 r0 = (com.blueair.api.client.AblCloudClient$setFanSpeed$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            com.blueair.api.client.AblCloudClient$setFanSpeed$1 r0 = new com.blueair.api.client.AblCloudClient$setFanSpeed$1
            r0.<init>(r7, r9)
        L_0x0019:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0034
            if (r2 != r3) goto L_0x002c
            int r8 = r0.I$0
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x005e
        L_0x002c:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0034:
            kotlin.ResultKt.throwOnFailure(r9)
            com.blueair.api.restapi.DeviceAblRestApi r9 = r7.getDeviceDetailsRestApi()
            java.lang.String r2 = r7.getDeviceUuid()
            com.blueair.api.restapi.DeviceAttributeName r4 = com.blueair.api.restapi.DeviceAttributeName.FanSpeed
            java.lang.String r4 = r4.getAttributeName()
            com.blueair.api.restapi.DeviceAttributeName r5 = com.blueair.api.restapi.DeviceAttributeName.FanSpeed
            java.lang.String r6 = java.lang.String.valueOf(r8)
            com.blueair.api.restapi.DeviceAttributeOnAbl r5 = r7.attributeForPost(r5, r6)
            kotlinx.coroutines.Deferred r9 = r9.setAttribute(r2, r4, r5)
            r0.I$0 = r8
            r0.label = r3
            java.lang.Object r9 = r7.awaitCall(r9, r0)
            if (r9 != r1) goto L_0x005e
            return r1
        L_0x005e:
            io.flatcircle.coroutinehelper.ApiResult r9 = (io.flatcircle.coroutinehelper.ApiResult) r9
            boolean r8 = r9.isSuccess()
            if (r8 == 0) goto L_0x00a2
            java.lang.Object r8 = r9.getOrNull()
            com.blueair.api.restapi.SimpleResponse r8 = (com.blueair.api.restapi.SimpleResponse) r8
            if (r8 == 0) goto L_0x007e
            java.lang.Integer r8 = r8.getState()
            if (r8 != 0) goto L_0x0075
            goto L_0x007e
        L_0x0075:
            int r8 = r8.intValue()
            r0 = 200(0xc8, float:2.8E-43)
            if (r8 != r0) goto L_0x007e
            return r9
        L_0x007e:
            io.flatcircle.coroutinehelper.ApiResult$Companion r8 = io.flatcircle.coroutinehelper.ApiResult.Companion
            java.lang.Throwable r0 = r9.exceptionOrNull()
            if (r0 != 0) goto L_0x009d
            java.io.IOException r0 = new java.io.IOException
            java.lang.Object r9 = r9.getOrNull()
            com.blueair.api.restapi.SimpleResponse r9 = (com.blueair.api.restapi.SimpleResponse) r9
            if (r9 == 0) goto L_0x0096
            java.lang.String r9 = r9.getMessage()
            if (r9 != 0) goto L_0x0098
        L_0x0096:
            java.lang.String r9 = "Unknown API failure"
        L_0x0098:
            r0.<init>(r9)
            java.lang.Throwable r0 = (java.lang.Throwable) r0
        L_0x009d:
            io.flatcircle.coroutinehelper.ApiResult r8 = r8.fail(r0)
            return r8
        L_0x00a2:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.client.AblCloudClient.setFanSpeed(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00a5 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object setAutoMode(int r8, kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<com.blueair.api.restapi.SimpleResponse>> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.blueair.api.client.AblCloudClient$setAutoMode$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            com.blueair.api.client.AblCloudClient$setAutoMode$1 r0 = (com.blueair.api.client.AblCloudClient$setAutoMode$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            com.blueair.api.client.AblCloudClient$setAutoMode$1 r0 = new com.blueair.api.client.AblCloudClient$setAutoMode$1
            r0.<init>(r7, r9)
        L_0x0019:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0034
            if (r2 != r3) goto L_0x002c
            int r8 = r0.I$0
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0061
        L_0x002c:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0034:
            kotlin.ResultKt.throwOnFailure(r9)
            com.blueair.api.restapi.DeviceAblRestApi r9 = r7.getDeviceDetailsRestApi()
            java.lang.String r2 = r7.getDeviceUuid()
            com.blueair.api.restapi.DeviceAttributeName r4 = com.blueair.api.restapi.DeviceAttributeName.Mode
            java.lang.String r4 = r4.getAttributeName()
            com.blueair.api.restapi.DeviceAttributeName r5 = com.blueair.api.restapi.DeviceAttributeName.Mode
            if (r8 != r3) goto L_0x004c
            java.lang.String r6 = "auto"
            goto L_0x004e
        L_0x004c:
            java.lang.String r6 = "manual"
        L_0x004e:
            com.blueair.api.restapi.DeviceAttributeOnAbl r5 = r7.attributeForPost(r5, r6)
            kotlinx.coroutines.Deferred r9 = r9.setAttribute(r2, r4, r5)
            r0.I$0 = r8
            r0.label = r3
            java.lang.Object r9 = r7.awaitCall(r9, r0)
            if (r9 != r1) goto L_0x0061
            return r1
        L_0x0061:
            io.flatcircle.coroutinehelper.ApiResult r9 = (io.flatcircle.coroutinehelper.ApiResult) r9
            boolean r8 = r9.isSuccess()
            if (r8 == 0) goto L_0x00a5
            java.lang.Object r8 = r9.getOrNull()
            com.blueair.api.restapi.SimpleResponse r8 = (com.blueair.api.restapi.SimpleResponse) r8
            if (r8 == 0) goto L_0x0081
            java.lang.Integer r8 = r8.getState()
            if (r8 != 0) goto L_0x0078
            goto L_0x0081
        L_0x0078:
            int r8 = r8.intValue()
            r0 = 200(0xc8, float:2.8E-43)
            if (r8 != r0) goto L_0x0081
            return r9
        L_0x0081:
            io.flatcircle.coroutinehelper.ApiResult$Companion r8 = io.flatcircle.coroutinehelper.ApiResult.Companion
            java.lang.Throwable r0 = r9.exceptionOrNull()
            if (r0 != 0) goto L_0x00a0
            java.io.IOException r0 = new java.io.IOException
            java.lang.Object r9 = r9.getOrNull()
            com.blueair.api.restapi.SimpleResponse r9 = (com.blueair.api.restapi.SimpleResponse) r9
            if (r9 == 0) goto L_0x0099
            java.lang.String r9 = r9.getMessage()
            if (r9 != 0) goto L_0x009b
        L_0x0099:
            java.lang.String r9 = "Unknown API failure"
        L_0x009b:
            r0.<init>(r9)
            java.lang.Throwable r0 = (java.lang.Throwable) r0
        L_0x00a0:
            io.flatcircle.coroutinehelper.ApiResult r8 = r8.fail(r0)
            return r8
        L_0x00a5:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.client.AblCloudClient.setAutoMode(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a2 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object setBrightness(int r8, kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<com.blueair.api.restapi.SimpleResponse>> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.blueair.api.client.AblCloudClient$setBrightness$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            com.blueair.api.client.AblCloudClient$setBrightness$1 r0 = (com.blueair.api.client.AblCloudClient$setBrightness$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            com.blueair.api.client.AblCloudClient$setBrightness$1 r0 = new com.blueair.api.client.AblCloudClient$setBrightness$1
            r0.<init>(r7, r9)
        L_0x0019:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0034
            if (r2 != r3) goto L_0x002c
            int r8 = r0.I$0
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x005e
        L_0x002c:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0034:
            kotlin.ResultKt.throwOnFailure(r9)
            com.blueair.api.restapi.DeviceAblRestApi r9 = r7.getDeviceDetailsRestApi()
            java.lang.String r2 = r7.getDeviceUuid()
            com.blueair.api.restapi.DeviceAttributeName r4 = com.blueair.api.restapi.DeviceAttributeName.Brightness
            java.lang.String r4 = r4.getAttributeName()
            com.blueair.api.restapi.DeviceAttributeName r5 = com.blueair.api.restapi.DeviceAttributeName.Brightness
            java.lang.String r6 = java.lang.String.valueOf(r8)
            com.blueair.api.restapi.DeviceAttributeOnAbl r5 = r7.attributeForPost(r5, r6)
            kotlinx.coroutines.Deferred r9 = r9.setAttribute(r2, r4, r5)
            r0.I$0 = r8
            r0.label = r3
            java.lang.Object r9 = r7.awaitCall(r9, r0)
            if (r9 != r1) goto L_0x005e
            return r1
        L_0x005e:
            io.flatcircle.coroutinehelper.ApiResult r9 = (io.flatcircle.coroutinehelper.ApiResult) r9
            boolean r8 = r9.isSuccess()
            if (r8 == 0) goto L_0x00a2
            java.lang.Object r8 = r9.getOrNull()
            com.blueair.api.restapi.SimpleResponse r8 = (com.blueair.api.restapi.SimpleResponse) r8
            if (r8 == 0) goto L_0x007e
            java.lang.Integer r8 = r8.getState()
            if (r8 != 0) goto L_0x0075
            goto L_0x007e
        L_0x0075:
            int r8 = r8.intValue()
            r0 = 200(0xc8, float:2.8E-43)
            if (r8 != r0) goto L_0x007e
            return r9
        L_0x007e:
            io.flatcircle.coroutinehelper.ApiResult$Companion r8 = io.flatcircle.coroutinehelper.ApiResult.Companion
            java.lang.Throwable r0 = r9.exceptionOrNull()
            if (r0 != 0) goto L_0x009d
            java.io.IOException r0 = new java.io.IOException
            java.lang.Object r9 = r9.getOrNull()
            com.blueair.api.restapi.SimpleResponse r9 = (com.blueair.api.restapi.SimpleResponse) r9
            if (r9 == 0) goto L_0x0096
            java.lang.String r9 = r9.getMessage()
            if (r9 != 0) goto L_0x0098
        L_0x0096:
            java.lang.String r9 = "Unknown API failure"
        L_0x0098:
            r0.<init>(r9)
            java.lang.Throwable r0 = (java.lang.Throwable) r0
        L_0x009d:
            io.flatcircle.coroutinehelper.ApiResult r8 = r8.fail(r0)
            return r8
        L_0x00a2:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.client.AblCloudClient.setBrightness(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00a5 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object setChildLock(int r8, kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<com.blueair.api.restapi.SimpleResponse>> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.blueair.api.client.AblCloudClient$setChildLock$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            com.blueair.api.client.AblCloudClient$setChildLock$1 r0 = (com.blueair.api.client.AblCloudClient$setChildLock$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            com.blueair.api.client.AblCloudClient$setChildLock$1 r0 = new com.blueair.api.client.AblCloudClient$setChildLock$1
            r0.<init>(r7, r9)
        L_0x0019:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0034
            if (r2 != r3) goto L_0x002c
            int r8 = r0.I$0
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0061
        L_0x002c:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0034:
            kotlin.ResultKt.throwOnFailure(r9)
            com.blueair.api.restapi.DeviceAblRestApi r9 = r7.getDeviceDetailsRestApi()
            java.lang.String r2 = r7.getDeviceUuid()
            com.blueair.api.restapi.DeviceAttributeName r4 = com.blueair.api.restapi.DeviceAttributeName.ChildLock
            java.lang.String r4 = r4.getAttributeName()
            com.blueair.api.restapi.DeviceAttributeName r5 = com.blueair.api.restapi.DeviceAttributeName.ChildLock
            if (r8 != r3) goto L_0x004c
            java.lang.String r6 = "1"
            goto L_0x004e
        L_0x004c:
            java.lang.String r6 = "0"
        L_0x004e:
            com.blueair.api.restapi.DeviceAttributeOnAbl r5 = r7.attributeForPost(r5, r6)
            kotlinx.coroutines.Deferred r9 = r9.setAttribute(r2, r4, r5)
            r0.I$0 = r8
            r0.label = r3
            java.lang.Object r9 = r7.awaitCall(r9, r0)
            if (r9 != r1) goto L_0x0061
            return r1
        L_0x0061:
            io.flatcircle.coroutinehelper.ApiResult r9 = (io.flatcircle.coroutinehelper.ApiResult) r9
            boolean r8 = r9.isSuccess()
            if (r8 == 0) goto L_0x00a5
            java.lang.Object r8 = r9.getOrNull()
            com.blueair.api.restapi.SimpleResponse r8 = (com.blueair.api.restapi.SimpleResponse) r8
            if (r8 == 0) goto L_0x0081
            java.lang.Integer r8 = r8.getState()
            if (r8 != 0) goto L_0x0078
            goto L_0x0081
        L_0x0078:
            int r8 = r8.intValue()
            r0 = 200(0xc8, float:2.8E-43)
            if (r8 != r0) goto L_0x0081
            return r9
        L_0x0081:
            io.flatcircle.coroutinehelper.ApiResult$Companion r8 = io.flatcircle.coroutinehelper.ApiResult.Companion
            java.lang.Throwable r0 = r9.exceptionOrNull()
            if (r0 != 0) goto L_0x00a0
            java.io.IOException r0 = new java.io.IOException
            java.lang.Object r9 = r9.getOrNull()
            com.blueair.api.restapi.SimpleResponse r9 = (com.blueair.api.restapi.SimpleResponse) r9
            if (r9 == 0) goto L_0x0099
            java.lang.String r9 = r9.getMessage()
            if (r9 != 0) goto L_0x009b
        L_0x0099:
            java.lang.String r9 = "Unknown API failure"
        L_0x009b:
            r0.<init>(r9)
            java.lang.Throwable r0 = (java.lang.Throwable) r0
        L_0x00a0:
            io.flatcircle.coroutinehelper.ApiResult r8 = r8.fail(r0)
            return r8
        L_0x00a5:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.client.AblCloudClient.setChildLock(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public Object getLink(Continuation<? super ApiResult<List<String>>> continuation) {
        return awaitCall(getDeviceDetailsRestApi().getLink(getDeviceUuid()), continuation);
    }

    public Object setLink(String str, Continuation<? super ApiResult<SimpleResponse>> continuation) {
        return awaitCall(getDeviceDetailsRestApi().setLink(getDeviceUuid(), str), continuation);
    }

    public Object deleteLink(String str, Continuation<? super ApiResult<SimpleResponse>> continuation) {
        return awaitCall(getDeviceDetailsRestApi().deleteLink(getDeviceUuid(), str), continuation);
    }

    public Object resetAutoModeDependency(Continuation<? super ApiResult<Object>> continuation) {
        return setAutoModeDependency("pm", continuation);
    }

    public Object setAutoModeDependency(Object obj, Continuation<? super ApiResult<Object>> continuation) {
        DeviceAttributeName deviceAttributeName = DeviceAttributeName.AutoModeDependency;
        DeviceAblRestApi deviceDetailsRestApi = getDeviceDetailsRestApi();
        String deviceUuid2 = getDeviceUuid();
        String attributeName = deviceAttributeName.getAttributeName();
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
        return awaitCall(deviceDetailsRestApi.setAttribute(deviceUuid2, attributeName, attributeForPost(deviceAttributeName, (String) obj)), continuation);
    }

    public Object getDeviceInfoData(Continuation<? super ApiResult<DeviceInfoData>> continuation) {
        return awaitCall(getDeviceDetailsRestApi().getDeviceInfoData(getDeviceUuid()), continuation);
    }

    public Object setDeviceInfoData(DeviceInfoData deviceInfoData, Continuation<? super ApiResult<Object>> continuation) {
        return awaitCall(getDeviceDetailsRestApi().setDeviceInfoData(getDeviceUuid(), deviceInfoData), continuation);
    }

    public Object getIsUpdating(Continuation<? super ApiResult<Boolean>> continuation) {
        return awaitCall(getDeviceDetailsRestApi().getIsUpdating(getDeviceUuid()), continuation);
    }

    public Object createSchedule(DeviceSchedule deviceSchedule, Continuation<? super ApiResult<ResponseBody>> continuation) {
        List legacy$default = DeviceSchedule.Companion.toLegacy$default(DeviceSchedule.Companion, deviceSchedule, (Integer) null, 2, (Object) null);
        int i = 0;
        for (Object next : legacy$default) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            LegacyDeviceSchedule legacyDeviceSchedule = (LegacyDeviceSchedule) next;
            if (i == CollectionsKt.getLastIndex(legacy$default)) {
                return awaitCall(getDeviceDetailsRestApi().createSchedule(deviceSchedule.getDeviceId(), legacyDeviceSchedule), continuation);
            }
            getDeviceDetailsRestApi().createSchedule(deviceSchedule.getDeviceId(), legacyDeviceSchedule);
            i = i2;
        }
        return ApiResult.Companion.notImplemented();
    }

    public Object deleteSchedule(String str, Continuation<? super Unit> continuation) {
        getDeviceDetailsRestApi().deleteSchedules(getDeviceUuid(), str);
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object updateSchedule(com.blueair.core.model.DeviceSchedule r5, kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<java.lang.Object>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.blueair.api.client.AblCloudClient$updateSchedule$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            com.blueair.api.client.AblCloudClient$updateSchedule$1 r0 = (com.blueair.api.client.AblCloudClient$updateSchedule$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            com.blueair.api.client.AblCloudClient$updateSchedule$1 r0 = new com.blueair.api.client.AblCloudClient$updateSchedule$1
            r0.<init>(r4, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r5 = r0.L$0
            com.blueair.core.model.DeviceSchedule r5 = (com.blueair.core.model.DeviceSchedule) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0048
        L_0x002e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r6)
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r5)
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r6 = r4.createSchedule(r5, r0)
            if (r6 != r1) goto L_0x0048
            return r1
        L_0x0048:
            java.lang.String r5 = "null cannot be cast to non-null type io.flatcircle.coroutinehelper.ApiResult<kotlin.Any?>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6, r5)
            io.flatcircle.coroutinehelper.ApiResult r6 = (io.flatcircle.coroutinehelper.ApiResult) r6
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.client.AblCloudClient.updateSchedule(com.blueair.core.model.DeviceSchedule, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object getSchedules(kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<java.util.List<com.blueair.core.model.DeviceSchedule>>> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.blueair.api.client.AblCloudClient$getSchedules$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            com.blueair.api.client.AblCloudClient$getSchedules$1 r0 = (com.blueair.api.client.AblCloudClient$getSchedules$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            com.blueair.api.client.AblCloudClient$getSchedules$1 r0 = new com.blueair.api.client.AblCloudClient$getSchedules$1
            r0.<init>(r5, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x004a
        L_0x002a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r6)
            com.blueair.api.restapi.DeviceAblRestApi r6 = r5.getDeviceDetailsRestApi()
            java.lang.String r2 = r5.getDeviceUuid()
            kotlinx.coroutines.Deferred r6 = r6.getSchedules(r2)
            r0.label = r3
            java.lang.Object r6 = r5.awaitCall(r6, r0)
            if (r6 != r1) goto L_0x004a
            return r1
        L_0x004a:
            io.flatcircle.coroutinehelper.ApiResult r6 = (io.flatcircle.coroutinehelper.ApiResult) r6
            io.flatcircle.coroutinehelper.ApiResult$Companion r0 = io.flatcircle.coroutinehelper.ApiResult.Companion
            java.lang.Object r1 = r6.getOrNull()
            java.util.List r1 = (java.util.List) r1
            if (r1 == 0) goto L_0x0082
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.ArrayList r2 = new java.util.ArrayList
            r3 = 10
            int r3 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r1, r3)
            r2.<init>(r3)
            java.util.Collection r2 = (java.util.Collection) r2
            java.util.Iterator r1 = r1.iterator()
        L_0x0069:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x007f
            java.lang.Object r3 = r1.next()
            com.blueair.core.model.LegacyDeviceSchedule r3 = (com.blueair.core.model.LegacyDeviceSchedule) r3
            com.blueair.core.model.DeviceSchedule$Companion r4 = com.blueair.core.model.DeviceSchedule.Companion
            com.blueair.core.model.DeviceSchedule r3 = r4.fromLegacy(r3)
            r2.add(r3)
            goto L_0x0069
        L_0x007f:
            java.util.List r2 = (java.util.List) r2
            goto L_0x0083
        L_0x0082:
            r2 = 0
        L_0x0083:
            io.flatcircle.coroutinehelper.ApiResult r6 = r0.fromResult(r6, r2)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.client.AblCloudClient.getSchedules(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: com.blueair.api.model.DeviceInfoData} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object setDeviceName(java.lang.String r27, kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<java.lang.Object>> r28) {
        /*
            r26 = this;
            r0 = r26
            r1 = r28
            boolean r2 = r1 instanceof com.blueair.api.client.AblCloudClient$setDeviceName$1
            if (r2 == 0) goto L_0x0018
            r2 = r1
            com.blueair.api.client.AblCloudClient$setDeviceName$1 r2 = (com.blueair.api.client.AblCloudClient$setDeviceName$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x001d
        L_0x0018:
            com.blueair.api.client.AblCloudClient$setDeviceName$1 r2 = new com.blueair.api.client.AblCloudClient$setDeviceName$1
            r2.<init>(r0, r1)
        L_0x001d:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 2
            r6 = 1
            if (r4 == 0) goto L_0x0051
            if (r4 == r6) goto L_0x0048
            if (r4 != r5) goto L_0x0040
            java.lang.Object r3 = r2.L$2
            com.blueair.api.model.DeviceInfoData r3 = (com.blueair.api.model.DeviceInfoData) r3
            java.lang.Object r4 = r2.L$1
            io.flatcircle.coroutinehelper.ApiResult r4 = (io.flatcircle.coroutinehelper.ApiResult) r4
            java.lang.Object r2 = r2.L$0
            java.lang.String r2 = (java.lang.String) r2
            kotlin.ResultKt.throwOnFailure(r1)
            r4 = r2
            r2 = r3
            goto L_0x00ac
        L_0x0040:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0048:
            java.lang.Object r4 = r2.L$0
            java.lang.String r4 = (java.lang.String) r4
            kotlin.ResultKt.throwOnFailure(r1)
            r8 = r4
            goto L_0x0063
        L_0x0051:
            kotlin.ResultKt.throwOnFailure(r1)
            r1 = r27
            r2.L$0 = r1
            r2.label = r6
            java.lang.Object r4 = r0.getDeviceInfoData(r2)
            if (r4 != r3) goto L_0x0061
            goto L_0x00a9
        L_0x0061:
            r8 = r1
            r1 = r4
        L_0x0063:
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            java.lang.Object r4 = r1.getOrNull()
            r6 = r4
            com.blueair.api.model.DeviceInfoData r6 = (com.blueair.api.model.DeviceInfoData) r6
            if (r6 == 0) goto L_0x00e9
            boolean r4 = r1.isFailure()
            if (r4 == 0) goto L_0x0076
            goto L_0x00e9
        L_0x0076:
            r24 = 131069(0x1fffd, float:1.83667E-40)
            r25 = 0
            r7 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            com.blueair.api.model.DeviceInfoData r4 = com.blueair.api.model.DeviceInfoData.copy$default(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25)
            r2.L$0 = r8
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r2.L$1 = r1
            r2.L$2 = r6
            r2.label = r5
            java.lang.Object r1 = r0.setDeviceInfoData(r4, r2)
            if (r1 != r3) goto L_0x00aa
        L_0x00a9:
            return r3
        L_0x00aa:
            r2 = r6
            r4 = r8
        L_0x00ac:
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            io.flatcircle.coroutinehelper.ApiResult$Companion r3 = io.flatcircle.coroutinehelper.ApiResult.Companion
            r20 = 131069(0x1fffd, float:1.83667E-40)
            r21 = 0
            r5 = r3
            r3 = 0
            r6 = r5
            r5 = 0
            r7 = r6
            r6 = 0
            r8 = r7
            r7 = 0
            r9 = r8
            r8 = 0
            r10 = r9
            r9 = 0
            r11 = r10
            r10 = 0
            r12 = r11
            r11 = 0
            r13 = r12
            r12 = 0
            r14 = r13
            r13 = 0
            r15 = r14
            r14 = 0
            r16 = r15
            r15 = 0
            r17 = r16
            r16 = 0
            r18 = r17
            r17 = 0
            r19 = r18
            r18 = 0
            r22 = r19
            r19 = 0
            r0 = r22
            com.blueair.api.model.DeviceInfoData r2 = com.blueair.api.model.DeviceInfoData.copy$default(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)
            io.flatcircle.coroutinehelper.ApiResult r0 = r0.fromResult(r1, r2)
            return r0
        L_0x00e9:
            io.flatcircle.coroutinehelper.ApiResult$Companion r0 = io.flatcircle.coroutinehelper.ApiResult.Companion
            java.lang.Throwable r1 = r1.exceptionOrNull()
            if (r1 != 0) goto L_0x00fa
            java.io.IOException r1 = new java.io.IOException
            java.lang.String r2 = "The Api call to get device data failed"
            r1.<init>(r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
        L_0x00fa:
            io.flatcircle.coroutinehelper.ApiResult r0 = r0.fail(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.client.AblCloudClient.setDeviceName(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a4 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object setFilterType(java.lang.String r7, kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<com.blueair.api.restapi.SimpleResponse>> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.blueair.api.client.AblCloudClient$setFilterType$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            com.blueair.api.client.AblCloudClient$setFilterType$1 r0 = (com.blueair.api.client.AblCloudClient$setFilterType$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            com.blueair.api.client.AblCloudClient$setFilterType$1 r0 = new com.blueair.api.client.AblCloudClient$setFilterType$1
            r0.<init>(r6, r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r7 = r0.L$0
            java.lang.String r7 = (java.lang.String) r7
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0060
        L_0x002e:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r8)
            com.blueair.api.restapi.DeviceAblRestApi r8 = r6.getDeviceDetailsRestApi()
            java.lang.String r2 = r6.getDeviceUuid()
            com.blueair.api.restapi.DeviceAttributeName r4 = com.blueair.api.restapi.DeviceAttributeName.FilterType
            java.lang.String r4 = r4.getAttributeName()
            com.blueair.api.restapi.DeviceAttributeName r5 = com.blueair.api.restapi.DeviceAttributeName.FilterType
            com.blueair.api.restapi.DeviceAttributeOnAbl r5 = r6.attributeForPost(r5, r7)
            kotlinx.coroutines.Deferred r8 = r8.setAttribute(r2, r4, r5)
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
            r0.L$0 = r7
            r0.label = r3
            java.lang.Object r8 = r6.awaitCall(r8, r0)
            if (r8 != r1) goto L_0x0060
            return r1
        L_0x0060:
            io.flatcircle.coroutinehelper.ApiResult r8 = (io.flatcircle.coroutinehelper.ApiResult) r8
            boolean r7 = r8.isSuccess()
            if (r7 == 0) goto L_0x00a4
            java.lang.Object r7 = r8.getOrNull()
            com.blueair.api.restapi.SimpleResponse r7 = (com.blueair.api.restapi.SimpleResponse) r7
            if (r7 == 0) goto L_0x0080
            java.lang.Integer r7 = r7.getState()
            if (r7 != 0) goto L_0x0077
            goto L_0x0080
        L_0x0077:
            int r7 = r7.intValue()
            r0 = 200(0xc8, float:2.8E-43)
            if (r7 != r0) goto L_0x0080
            return r8
        L_0x0080:
            io.flatcircle.coroutinehelper.ApiResult$Companion r7 = io.flatcircle.coroutinehelper.ApiResult.Companion
            java.lang.Throwable r0 = r8.exceptionOrNull()
            if (r0 != 0) goto L_0x009f
            java.io.IOException r0 = new java.io.IOException
            java.lang.Object r8 = r8.getOrNull()
            com.blueair.api.restapi.SimpleResponse r8 = (com.blueair.api.restapi.SimpleResponse) r8
            if (r8 == 0) goto L_0x0098
            java.lang.String r8 = r8.getMessage()
            if (r8 != 0) goto L_0x009a
        L_0x0098:
            java.lang.String r8 = "Unknown API failure"
        L_0x009a:
            r0.<init>(r8)
            java.lang.Throwable r0 = (java.lang.Throwable) r0
        L_0x009f:
            io.flatcircle.coroutinehelper.ApiResult r7 = r7.fail(r0)
            return r7
        L_0x00a4:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.client.AblCloudClient.setFilterType(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public Object getDeviceStatus(Continuation<? super ApiResult<String>> continuation) {
        Timber.Forest.d("getDeviceStatus called", new Object[0]);
        return awaitCall(getDeviceDetailsRestApi().getDeviceStatus(getDeviceUuid()), continuation);
    }
}
