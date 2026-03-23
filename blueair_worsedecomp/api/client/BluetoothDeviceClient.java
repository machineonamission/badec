package com.blueair.api.client;

import android.content.res.Resources;
import com.blueair.api.client.BaseNetworkClient;
import com.blueair.api.client.CloudNetworkClient;
import com.blueair.api.model.DeviceInfoData;
import com.blueair.api.model.ProvisionRequestBody;
import com.blueair.api.restapi.DeviceAblRestApi;
import com.blueair.api.restapi.SimpleResponse;
import com.blueair.auth.AuthService;
import com.blueair.core.model.DeviceEvent;
import com.blueair.core.model.DeviceUuid;
import com.blueair.core.model.Ssid;
import io.flatcircle.ble.BleIcpController;
import io.flatcircle.ble.BleService;
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

@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005B=\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010/\u001a\u000200H\u0016J\u001c\u00101\u001a\b\u0012\u0004\u0012\u000203022\u0006\u00104\u001a\u000205H@¢\u0006\u0002\u00106J\u001c\u00107\u001a\b\u0012\u0004\u0012\u000203022\u0006\u00108\u001a\u000205H@¢\u0006\u0002\u00106J\u001c\u00109\u001a\b\u0012\u0004\u0012\u00020:022\u0006\u0010;\u001a\u00020<H@¢\u0006\u0002\u0010=J\"\u0010>\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020@0?022\u0006\u0010;\u001a\u00020AH@¢\u0006\u0002\u0010BJ\u0014\u0010C\u001a\b\u0012\u0004\u0012\u00020D02H@¢\u0006\u0002\u0010EJ\u001a\u0010F\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020G0?02H@¢\u0006\u0002\u0010EJ\u001c\u0010H\u001a\b\u0012\u0004\u0012\u00020\r022\u0006\u0010I\u001a\u00020DH@¢\u0006\u0002\u0010JJ\u0014\u0010K\u001a\b\u0012\u0004\u0012\u00020L02H@¢\u0006\u0002\u0010EJ\u0014\u0010M\u001a\b\u0012\u0004\u0012\u00020N02H@¢\u0006\u0002\u0010EJ\u001c\u0010O\u001a\b\u0012\u0004\u0012\u00020L022\u0006\u0010P\u001a\u00020NH@¢\u0006\u0002\u0010QJ\u001c\u0010R\u001a\b\u0012\u0004\u0012\u00020L022\u0006\u0010S\u001a\u00020\rH@¢\u0006\u0002\u0010TR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\b\u001a\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u000e\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001a\"\u0004\b\u001e\u0010\u001cR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u001b\u0010!\u001a\u00020\"8VX\u0002¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b#\u0010$R\u0014\u0010'\u001a\u00020(8VX\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0014\u0010+\u001a\u00020,8VX\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.¨\u0006U"}, d2 = {"Lcom/blueair/api/client/BluetoothDeviceClient;", "Lcom/blueair/api/client/DeviceClient;", "Lcom/blueair/api/client/CanProvisionLocal;", "Lcom/blueair/api/client/CanSetFan;", "Lcom/blueair/api/client/CanSetDeviceName;", "Lcom/blueair/api/client/AblCloudNetworkClient;", "bleService", "Lio/flatcircle/ble/BleService;", "resources", "Landroid/content/res/Resources;", "authService", "Lcom/blueair/auth/AuthService;", "deviceUuid", "", "deviceJwt", "mockInterceptor", "Lokhttp3/Interceptor;", "<init>", "(Lio/flatcircle/ble/BleService;Landroid/content/res/Resources;Lcom/blueair/auth/AuthService;Ljava/lang/String;Ljava/lang/String;Lokhttp3/Interceptor;)V", "getBleService", "()Lio/flatcircle/ble/BleService;", "getResources", "()Landroid/content/res/Resources;", "getAuthService", "()Lcom/blueair/auth/AuthService;", "getDeviceUuid", "()Ljava/lang/String;", "setDeviceUuid", "(Ljava/lang/String;)V", "getDeviceJwt", "setDeviceJwt", "getMockInterceptor", "()Lokhttp3/Interceptor;", "okHttpClient", "Lokhttp3/OkHttpClient;", "getOkHttpClient", "()Lokhttp3/OkHttpClient;", "okHttpClient$delegate", "Lkotlin/Lazy;", "retrofit", "Lretrofit2/Retrofit;", "getRetrofit", "()Lretrofit2/Retrofit;", "deviceDetailsRestApi", "Lcom/blueair/api/restapi/DeviceAblRestApi;", "getDeviceDetailsRestApi", "()Lcom/blueair/api/restapi/DeviceAblRestApi;", "clear", "", "setFanSpeed", "Lio/flatcircle/coroutinehelper/ApiResult;", "Lcom/blueair/api/restapi/SimpleResponse;", "fanSpeed", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setAutoMode", "enabled", "provisionDevice", "Lcom/blueair/api/model/ProvisionRequestBody;", "body", "Lcom/blueair/api/client/ProvisionBody;", "(Lcom/blueair/api/client/ProvisionBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getOnboardingEvents", "", "Lcom/blueair/core/model/DeviceEvent;", "Lcom/blueair/api/client/OnboardingEventsBody;", "(Lcom/blueair/api/client/OnboardingEventsBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUuid", "Lcom/blueair/core/model/DeviceUuid;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSsids", "Lcom/blueair/core/model/Ssid;", "resetDevice", "ipInfo", "(Lcom/blueair/core/model/DeviceUuid;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "switchOffSoftAp", "", "getDeviceInfoData", "Lcom/blueair/api/model/DeviceInfoData;", "setDeviceInfoData", "nuData", "(Lcom/blueair/api/model/DeviceInfoData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setDeviceName", "nuValue", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: BluetoothDeviceClient.kt */
public final class BluetoothDeviceClient implements DeviceClient, CanProvisionLocal, CanSetFan, CanSetDeviceName, AblCloudNetworkClient {
    private final AuthService authService;
    private final BleService bleService;
    private String deviceJwt;
    private String deviceUuid;
    private final Interceptor mockInterceptor;
    private final Lazy okHttpClient$delegate;
    private final Resources resources;

    public void clear() {
    }

    public BluetoothDeviceClient(BleService bleService2, Resources resources2, AuthService authService2, String str, String str2, Interceptor interceptor) {
        Intrinsics.checkNotNullParameter(bleService2, "bleService");
        Intrinsics.checkNotNullParameter(resources2, "resources");
        Intrinsics.checkNotNullParameter(authService2, "authService");
        Intrinsics.checkNotNullParameter(str, "deviceUuid");
        Intrinsics.checkNotNullParameter(str2, "deviceJwt");
        this.bleService = bleService2;
        this.resources = resources2;
        this.authService = authService2;
        this.deviceUuid = str;
        this.deviceJwt = str2;
        this.mockInterceptor = interceptor;
        this.okHttpClient$delegate = LazyKt.lazy(new BluetoothDeviceClient$$ExternalSyntheticLambda0(this));
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

    public final BleService getBleService() {
        return this.bleService;
    }

    public Resources getResources() {
        return this.resources;
    }

    public AuthService getAuthService() {
        return this.authService;
    }

    public String getDeviceUuid() {
        return this.deviceUuid;
    }

    public void setDeviceUuid(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.deviceUuid = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BluetoothDeviceClient(BleService bleService2, Resources resources2, AuthService authService2, String str, String str2, Interceptor interceptor, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(bleService2, resources2, authService2, str, (i & 16) != 0 ? "" : str2, (i & 32) != 0 ? null : interceptor);
    }

    public String getDeviceJwt() {
        return this.deviceJwt;
    }

    public void setDeviceJwt(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.deviceJwt = str;
    }

    public Interceptor getMockInterceptor() {
        return this.mockInterceptor;
    }

    public OkHttpClient getOkHttpClient() {
        return (OkHttpClient) this.okHttpClient$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final OkHttpClient okHttpClient_delegate$lambda$0(BluetoothDeviceClient bluetoothDeviceClient) {
        return bluetoothDeviceClient.buildHttpClient(true, bluetoothDeviceClient.getMockInterceptor());
    }

    public Retrofit getRetrofit() {
        return retroFitFactory(getAuthService().getAblHomeHost());
    }

    public DeviceAblRestApi getDeviceDetailsRestApi() {
        Object create = getRetrofit().create(DeviceAblRestApi.class);
        Intrinsics.checkNotNullExpressionValue(create, "create(...)");
        return (DeviceAblRestApi) create;
    }

    public Object setFanSpeed(int i, Continuation<? super ApiResult<SimpleResponse>> continuation) {
        BleIcpController.FanSpeed fanSpeed;
        if (i == 0) {
            fanSpeed = BleIcpController.FanSpeed.SPEED_1;
        } else if (i == 1) {
            fanSpeed = BleIcpController.FanSpeed.SPEED_1;
        } else if (i == 2) {
            fanSpeed = BleIcpController.FanSpeed.SPEED_2;
        } else if (i != 3) {
            fanSpeed = BleIcpController.FanSpeed.SPEED_1;
        } else {
            fanSpeed = BleIcpController.FanSpeed.SPEED_3;
        }
        this.bleService.setFanSpeed(getDeviceUuid(), fanSpeed);
        return ApiResult.Companion.success(new SimpleResponse((Integer) null, (String) null));
    }

    public Object setAutoMode(int i, Continuation<? super ApiResult<SimpleResponse>> continuation) {
        BleService bleService2 = this.bleService;
        String deviceUuid2 = getDeviceUuid();
        boolean z = true;
        if (i != 1) {
            z = false;
        }
        bleService2.setAutoMode(deviceUuid2, z);
        return ApiResult.Companion.success(new SimpleResponse((Integer) null, (String) null));
    }

    public Object provisionDevice(ProvisionBody provisionBody, Continuation<? super ApiResult<ProvisionRequestBody>> continuation) {
        return ApiResult.Companion.notImplemented();
    }

    public Object getOnboardingEvents(OnboardingEventsBody onboardingEventsBody, Continuation<? super ApiResult<List<DeviceEvent>>> continuation) {
        return ApiResult.Companion.notImplemented();
    }

    public Object getUuid(Continuation<? super ApiResult<DeviceUuid>> continuation) {
        return ApiResult.Companion.notImplemented();
    }

    public Object getSsids(Continuation<? super ApiResult<List<Ssid>>> continuation) {
        return ApiResult.Companion.notImplemented();
    }

    public Object resetDevice(DeviceUuid deviceUuid2, Continuation<? super ApiResult<String>> continuation) {
        return ApiResult.Companion.notImplemented();
    }

    public Object switchOffSoftAp(Continuation<? super ApiResult<Object>> continuation) {
        return ApiResult.Companion.notImplemented();
    }

    public final Object getDeviceInfoData(Continuation<? super ApiResult<DeviceInfoData>> continuation) {
        return awaitCall(getDeviceDetailsRestApi().getDeviceInfoData(getDeviceUuid()), continuation);
    }

    public final Object setDeviceInfoData(DeviceInfoData deviceInfoData, Continuation<? super ApiResult<Object>> continuation) {
        return awaitCall(getDeviceDetailsRestApi().setDeviceInfoData(getDeviceUuid(), deviceInfoData), continuation);
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
            boolean r2 = r1 instanceof com.blueair.api.client.BluetoothDeviceClient$setDeviceName$1
            if (r2 == 0) goto L_0x0018
            r2 = r1
            com.blueair.api.client.BluetoothDeviceClient$setDeviceName$1 r2 = (com.blueair.api.client.BluetoothDeviceClient$setDeviceName$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x001d
        L_0x0018:
            com.blueair.api.client.BluetoothDeviceClient$setDeviceName$1 r2 = new com.blueair.api.client.BluetoothDeviceClient$setDeviceName$1
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
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.client.BluetoothDeviceClient.setDeviceName(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
