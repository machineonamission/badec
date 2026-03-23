package com.blueair.api.client;

import android.content.res.Resources;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.blueair.adddevice.model.AddDeviceState$$ExternalSyntheticBackport0;
import com.blueair.api.client.BaseNetworkClient;
import com.blueair.api.client.CloudNetworkClient;
import com.blueair.api.restapi.AnalyticsFilterCLickEvent;
import com.blueair.api.restapi.AntiFakeLogReq;
import com.blueair.api.restapi.AntiFakeResetReq;
import com.blueair.api.restapi.AntiFakeResetResp;
import com.blueair.api.restapi.AntiFakeVerifyResult;
import com.blueair.api.restapi.FilterResetReq;
import com.blueair.api.restapi.PresignUploadRsp;
import com.blueair.api.restapi.SetTimezoneReq;
import com.blueair.api.restapi.SetupDeviceLocationReq;
import com.blueair.api.restapi.UploadLogReq;
import com.blueair.api.restapi.UploadLogRsp;
import com.blueair.api.restapi.UserDevicesRestApi;
import com.blueair.api.utils.ProgressListener;
import com.blueair.api.utils.ProgressRequestBody;
import com.blueair.auth.AuthService;
import com.blueair.core.model.AnalyticEvent;
import com.blueair.core.model.DeviceAlarm;
import com.blueair.core.model.IndoorDatapoint;
import com.blueair.core.model.NotificationSetting;
import com.blueair.core.model.SkuConfigurationData;
import com.blueair.core.model.UserForm;
import com.blueair.core.model.UserInfoCollections;
import com.blueair.core.model.WelcomeHomeLocation;
import com.blueair.core.util.MoshiSerializer;
import com.blueair.core.util.TimezoneNames;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import io.flatcircle.coroutinehelper.ApiResult;
import java.io.File;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import org.json.JSONArray;
import org.json.JSONObject;
import retrofit2.Response;
import retrofit2.Retrofit;

@Metadata(d1 = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0002\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020'0&0%H@¢\u0006\u0002\u0010(J\u001c\u0010)\u001a\b\u0012\u0004\u0012\u00020*0%2\u0006\u0010+\u001a\u00020,H@¢\u0006\u0002\u0010-J(\u0010.\u001a\b\u0012\u0004\u0012\u00020/0%2\u0012\u00100\u001a\n\u0012\u0006\b\u0001\u0012\u00020,01\"\u00020,H@¢\u0006\u0002\u00102J(\u00103\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002040&0%2\f\u00105\u001a\b\u0012\u0004\u0012\u0002060&H@¢\u0006\u0002\u00107J@\u00108\u001a\u0004\u0018\u00010,2\u0006\u00109\u001a\u00020,2\u0006\u0010:\u001a\u00020,2\u0006\u0010;\u001a\u00020,2\u0006\u0010<\u001a\u00020,2\u0006\u0010=\u001a\u00020,2\u0006\u0010>\u001a\u00020*H@¢\u0006\u0002\u0010?J,\u0010@\u001a\u0010\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020,\u0018\u00010A2\u0006\u0010B\u001a\u00020,2\u0006\u0010;\u001a\u00020,H@¢\u0006\u0002\u0010CJ\u001e\u0010D\u001a\u00020*2\u0006\u0010E\u001a\u00020,2\u0006\u0010B\u001a\u00020,H@¢\u0006\u0002\u0010CJ\u000e\u0010F\u001a\u00020*H@¢\u0006\u0002\u0010(J\u0016\u0010G\u001a\u00020*2\u0006\u0010B\u001a\u00020,H@¢\u0006\u0002\u0010-J\u001e\u0010H\u001a\u00020,2\u0006\u00109\u001a\u00020,2\u0006\u0010I\u001a\u00020,H@¢\u0006\u0002\u0010CJ\u0016\u0010J\u001a\u00020*2\u0006\u00109\u001a\u00020,H@¢\u0006\u0002\u0010-J\u0016\u0010K\u001a\u00020*2\u0006\u00109\u001a\u00020,H@¢\u0006\u0002\u0010-J\u001a\u0010L\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020M0&0%H@¢\u0006\u0002\u0010(J\u001c\u0010N\u001a\b\u0012\u0004\u0012\u00020O0%2\u0006\u0010P\u001a\u00020MH@¢\u0006\u0002\u0010QJ*\u0010R\u001a\b\u0012\u0004\u0012\u00020O0%2\f\u0010S\u001a\b\u0012\u0004\u0012\u00020,0&2\u0006\u0010T\u001a\u00020,H@¢\u0006\u0002\u0010UJ$\u0010V\u001a\b\u0012\u0004\u0012\u00020,0%2\u0006\u0010+\u001a\u00020,2\u0006\u0010W\u001a\u00020,H@¢\u0006\u0002\u0010CJ\u001c\u0010X\u001a\b\u0012\u0004\u0012\u00020Y0%2\u0006\u0010Z\u001a\u00020,H@¢\u0006\u0002\u0010-J$\u0010[\u001a\b\u0012\u0004\u0012\u00020\\0%2\u0006\u0010Z\u001a\u00020]2\u0006\u0010^\u001a\u00020]H@¢\u0006\u0002\u0010_J$\u0010`\u001a\b\u0012\u0004\u0012\u00020a0%2\u0006\u0010Z\u001a\u00020]2\u0006\u0010^\u001a\u00020]H@¢\u0006\u0002\u0010_J\u001c\u0010b\u001a\b\u0012\u0004\u0012\u00020O0%2\u0006\u0010c\u001a\u00020aH@¢\u0006\u0002\u0010dJ\u001e\u0010e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010f0%2\u0006\u0010g\u001a\u00020,H@¢\u0006\u0002\u0010-J8\u0010h\u001a\b\u0012\u0004\u0012\u00020O0%2\u0006\u0010i\u001a\u00020,2\f\u0010S\u001a\b\u0012\u0004\u0012\u00020,0&2\f\u0010j\u001a\b\u0012\u0004\u0012\u00020,0&H@¢\u0006\u0002\u0010kJ\u001c\u0010l\u001a\b\u0012\u0004\u0012\u00020,0%2\u0006\u0010+\u001a\u00020,H@¢\u0006\u0002\u0010-J\"\u0010m\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0&0%2\u0006\u0010i\u001a\u00020,H@¢\u0006\u0002\u0010-J\u001c\u0010n\u001a\b\u0012\u0004\u0012\u00020o0%2\u0006\u0010E\u001a\u00020,H@¢\u0006\u0002\u0010-J,\u0010p\u001a\b\u0012\u0004\u0012\u00020q0%2\u0006\u0010E\u001a\u00020,2\u0006\u0010r\u001a\u00020,2\u0006\u0010+\u001a\u00020,H@¢\u0006\u0002\u0010sJ4\u0010t\u001a\b\u0012\u0004\u0012\u00020q0%2\u0006\u0010E\u001a\u00020,2\u0006\u0010r\u001a\u00020,2\u0006\u0010u\u001a\u00020,2\u0006\u0010v\u001a\u00020]H@¢\u0006\u0002\u0010wJ4\u0010x\u001a\b\u0012\u0004\u0012\u00020O0%2\u0006\u0010E\u001a\u00020,2\u0006\u0010r\u001a\u00020,2\u0006\u0010u\u001a\u00020,2\u0006\u0010y\u001a\u00020,H@¢\u0006\u0002\u0010zJ$\u0010{\u001a\b\u0012\u0004\u0012\u00020q0%2\u0006\u0010+\u001a\u00020,2\u0006\u0010|\u001a\u00020,H@¢\u0006\u0002\u0010CJ\u001d\u0010}\u001a\b\u0012\u0004\u0012\u00020O0%2\u0006\u0010~\u001a\u00020H@¢\u0006\u0003\u0010\u0001J'\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020,0%2\u0007\u0010\u0001\u001a\u00020,2\u0007\u0010\u0001\u001a\u00020,H@¢\u0006\u0002\u0010CJ\u001b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001H@¢\u0006\u0003\u0010\u0001J!\u0010\u0001\u001a\t\u0012\u0005\u0012\u00030\u00010%2\b\u0010\u0001\u001a\u00030\u0001H@¢\u0006\u0003\u0010\u0001J(\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001H\u0007R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0010\u001a\u00020\u00118VX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00178VX\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u001b8BX\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR!\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001f8BX\u0002¢\u0006\f\n\u0004\b#\u0010\u0015\u001a\u0004\b!\u0010\"¨\u0006\u0001"}, d2 = {"Lcom/blueair/api/client/UserDevicesBlueClient;", "Lcom/blueair/api/client/CloudNetworkClient;", "resources", "Landroid/content/res/Resources;", "authService", "Lcom/blueair/auth/AuthService;", "mockInterceptor", "Lokhttp3/Interceptor;", "<init>", "(Landroid/content/res/Resources;Lcom/blueair/auth/AuthService;Lokhttp3/Interceptor;)V", "getResources", "()Landroid/content/res/Resources;", "getAuthService", "()Lcom/blueair/auth/AuthService;", "getMockInterceptor", "()Lokhttp3/Interceptor;", "okHttpClient", "Lokhttp3/OkHttpClient;", "getOkHttpClient", "()Lokhttp3/OkHttpClient;", "okHttpClient$delegate", "Lkotlin/Lazy;", "retrofit", "Lretrofit2/Retrofit;", "getRetrofit", "()Lretrofit2/Retrofit;", "userDevicesRestApi", "Lcom/blueair/api/restapi/UserDevicesRestApi;", "getUserDevicesRestApi", "()Lcom/blueair/api/restapi/UserDevicesRestApi;", "alarmSerializer", "Lcom/blueair/core/util/MoshiSerializer;", "Lcom/blueair/core/model/DeviceAlarm;", "getAlarmSerializer", "()Lcom/blueair/core/util/MoshiSerializer;", "alarmSerializer$delegate", "getDevices", "Lio/flatcircle/coroutinehelper/ApiResult;", "", "Lcom/blueair/core/model/DeviceOnBlueServer;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDeviceStatus", "", "deviceId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeDevice", "", "uid", "", "([Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "initialSetupCall", "Lcom/blueair/api/client/UserDevicesBlueClient$DeviceDataOnBlue;", "blueDevices", "Lcom/blueair/core/model/HasBlueCloudFunctions;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAlexaRedirectUrl", "clientId", "responseType", "state", "scope", "redirectUri", "userAccepted", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAlexaLinkingUrls", "Lkotlin/Pair;", "stage", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "alexaLinkAccount", "code", "getAlexaLinkStatus", "unlinkAlexa", "getGoogleAuthCode", "gigyaJwt", "getGoogleLinkStatus", "unlinkGoogle", "getNotificationSettings", "Lcom/blueair/core/model/NotificationSetting;", "updateNotificationSetting", "Lokhttp3/ResponseBody;", "setting", "(Lcom/blueair/core/model/NotificationSetting;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setDeviceTimezone", "deviceIdList", "timezone", "(Ljava/util/List;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDeviceTimezone", "defaultTimezone", "getTimezoneList", "Lcom/blueair/core/util/TimezoneNames;", "version", "getSkuConfigurations", "Lcom/blueair/core/model/SkuConfigurationData;", "", "series", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUserInfoCollections", "Lcom/blueair/core/model/UserInfoCollections;", "uploadUserInfoCollections", "collections", "(Lcom/blueair/core/model/UserInfoCollections;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "downloadFile", "Ljava/io/InputStream;", "url", "setupDeviceLocation", "locationId", "resetDeviceIdList", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDeviceLocation", "getLocationDevices", "antiFakeVerify", "Lcom/blueair/api/restapi/AntiFakeVerifyResult;", "antiFakeResetByWifi", "Lcom/blueair/api/restapi/AntiFakeResetResp;", "deviceSku", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "antiFakeResetByBluetooth", "mac", "usage", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "antiFakeLogBluetooth", "result", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resetFilterLife", "type", "analyticsLogFilterClickEvent", "event", "Lcom/blueair/core/model/AnalyticEvent$FilterClickEvent;", "(Lcom/blueair/core/model/AnalyticEvent$FilterClickEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shopifyMultiPassLink", "email", "redirectUrl", "postUserForm", "", "userForm", "Lcom/blueair/core/model/UserForm;", "(Lcom/blueair/core/model/UserForm;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "presignUploadLog", "Lcom/blueair/api/restapi/UploadLogRsp;", "req", "Lcom/blueair/api/restapi/UploadLogReq;", "(Lcom/blueair/api/restapi/UploadLogReq;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "presignUploadFile", "Lokhttp3/Response;", "rsp", "Lcom/blueair/api/restapi/PresignUploadRsp;", "file", "Ljava/io/File;", "listener", "Lcom/blueair/api/utils/ProgressListener;", "DeviceDataOnBlue", "api_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: UserDevicesBlueClient.kt */
public final class UserDevicesBlueClient implements CloudNetworkClient {
    private final Lazy alarmSerializer$delegate;
    private final AuthService authService;
    private final Interceptor mockInterceptor;
    private final Lazy okHttpClient$delegate;
    private final Resources resources;

    public UserDevicesBlueClient(Resources resources2, AuthService authService2, Interceptor interceptor) {
        Intrinsics.checkNotNullParameter(resources2, "resources");
        Intrinsics.checkNotNullParameter(authService2, "authService");
        this.resources = resources2;
        this.authService = authService2;
        this.mockInterceptor = interceptor;
        this.okHttpClient$delegate = LazyKt.lazy(new UserDevicesBlueClient$$ExternalSyntheticLambda0(this));
        this.alarmSerializer$delegate = LazyKt.lazy(new UserDevicesBlueClient$$ExternalSyntheticLambda1());
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UserDevicesBlueClient(Resources resources2, AuthService authService2, Interceptor interceptor, int i, DefaultConstructorMarker defaultConstructorMarker) {
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

    public Interceptor getMockInterceptor() {
        return this.mockInterceptor;
    }

    public OkHttpClient getOkHttpClient() {
        return (OkHttpClient) this.okHttpClient$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final OkHttpClient okHttpClient_delegate$lambda$0(UserDevicesBlueClient userDevicesBlueClient) {
        return userDevicesBlueClient.buildHttpClient(false, userDevicesBlueClient.getMockInterceptor());
    }

    public Retrofit getRetrofit() {
        return retroFitFactory(getAuthService().getBlueHomeHost());
    }

    private final UserDevicesRestApi getUserDevicesRestApi() {
        Object create = getRetrofit().create(UserDevicesRestApi.class);
        Intrinsics.checkNotNullExpressionValue(create, "create(...)");
        return (UserDevicesRestApi) create;
    }

    /* access modifiers changed from: private */
    public static final MoshiSerializer alarmSerializer_delegate$lambda$1() {
        return new MoshiSerializer(DeviceAlarm.class, new Object[0]);
    }

    private final MoshiSerializer<DeviceAlarm> getAlarmSerializer() {
        return (MoshiSerializer) this.alarmSerializer$delegate.getValue();
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getDevices(kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<java.util.List<com.blueair.core.model.DeviceOnBlueServer>>> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.blueair.api.client.UserDevicesBlueClient$getDevices$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            com.blueair.api.client.UserDevicesBlueClient$getDevices$1 r0 = (com.blueair.api.client.UserDevicesBlueClient$getDevices$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            com.blueair.api.client.UserDevicesBlueClient$getDevices$1 r0 = new com.blueair.api.client.UserDevicesBlueClient$getDevices$1
            r0.<init>(r5, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0050
        L_0x002a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r6)
            timber.log.Timber$Forest r6 = timber.log.Timber.Forest
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.String r4 = "getDevices"
            r6.v(r4, r2)
            com.blueair.api.restapi.UserDevicesRestApi r6 = r5.getUserDevicesRestApi()
            kotlinx.coroutines.Deferred r6 = r6.getDeviceList()
            r0.label = r3
            java.lang.Object r6 = r5.awaitCall(r6, r0)
            if (r6 != r1) goto L_0x0050
            return r1
        L_0x0050:
            io.flatcircle.coroutinehelper.ApiResult r6 = (io.flatcircle.coroutinehelper.ApiResult) r6
            io.flatcircle.coroutinehelper.ApiResult$Companion r0 = io.flatcircle.coroutinehelper.ApiResult.Companion
            java.lang.Object r1 = r6.getOrNull()
            com.blueair.api.restapi.DeviceBlueWrapper r1 = (com.blueair.api.restapi.DeviceBlueWrapper) r1
            if (r1 == 0) goto L_0x0061
            java.util.List r1 = r1.getDevices()
            goto L_0x0062
        L_0x0061:
            r1 = 0
        L_0x0062:
            io.flatcircle.coroutinehelper.ApiResult r6 = r0.fromResult(r6, r1)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.client.UserDevicesBlueClient.getDevices(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getDeviceStatus(java.lang.String r5, kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<java.lang.Boolean>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.blueair.api.client.UserDevicesBlueClient$getDeviceStatus$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            com.blueair.api.client.UserDevicesBlueClient$getDeviceStatus$1 r0 = (com.blueair.api.client.UserDevicesBlueClient$getDeviceStatus$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            com.blueair.api.client.UserDevicesBlueClient$getDeviceStatus$1 r0 = new com.blueair.api.client.UserDevicesBlueClient$getDeviceStatus$1
            r0.<init>(r4, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r5 = r0.L$0
            java.lang.String r5 = (java.lang.String) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0055
        L_0x002e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r6)
            com.blueair.api.restapi.UserDevicesRestApi r6 = r4.getUserDevicesRestApi()
            com.blueair.api.restapi.GetDeviceStatusReq r2 = new com.blueair.api.restapi.GetDeviceStatusReq
            r2.<init>(r5)
            kotlinx.coroutines.Deferred r6 = r6.getDeviceStatus(r2)
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r5)
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r6 = r4.awaitCall(r6, r0)
            if (r6 != r1) goto L_0x0055
            return r1
        L_0x0055:
            io.flatcircle.coroutinehelper.ApiResult r6 = (io.flatcircle.coroutinehelper.ApiResult) r6
            io.flatcircle.coroutinehelper.ApiResult$Companion r5 = io.flatcircle.coroutinehelper.ApiResult.Companion
            java.lang.Object r0 = r6.getOrNull()
            com.blueair.api.restapi.GetDeviceStatusRsp r0 = (com.blueair.api.restapi.GetDeviceStatusRsp) r0
            if (r0 == 0) goto L_0x0066
            boolean r0 = r0.getOnline()
            goto L_0x0067
        L_0x0066:
            r0 = 0
        L_0x0067:
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r0)
            io.flatcircle.coroutinehelper.ApiResult r5 = r5.fromResult(r6, r0)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.client.UserDevicesBlueClient.getDeviceStatus(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object removeDevice(String[] strArr, Continuation<? super ApiResult<Object>> continuation) {
        return awaitCall(getUserDevicesRestApi().removeDevice(ArraysKt.toList((T[]) strArr)), continuation);
    }

    /* JADX WARNING: type inference failed for: r112v1 */
    /* JADX WARNING: type inference failed for: r112v2, types: [boolean] */
    /* JADX WARNING: type inference failed for: r112v4 */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x019c, code lost:
        r0 = r10.getV();
     */
    /* JADX WARNING: Removed duplicated region for block: B:1001:0x14b7  */
    /* JADX WARNING: Removed duplicated region for block: B:1002:0x14c3  */
    /* JADX WARNING: Removed duplicated region for block: B:1004:0x14c7  */
    /* JADX WARNING: Removed duplicated region for block: B:1005:0x14d3  */
    /* JADX WARNING: Removed duplicated region for block: B:1007:0x14d7  */
    /* JADX WARNING: Removed duplicated region for block: B:1008:0x14ea  */
    /* JADX WARNING: Removed duplicated region for block: B:1010:0x14ee  */
    /* JADX WARNING: Removed duplicated region for block: B:1011:0x1503  */
    /* JADX WARNING: Removed duplicated region for block: B:1015:0x1551  */
    /* JADX WARNING: Removed duplicated region for block: B:1130:0x0d7c A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:1132:0x0dae A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:1134:0x0de0 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:1136:0x0e12 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:1139:0x0e44 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:1140:0x0e76 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:1142:0x0ea8 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:1144:0x0eda A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:1146:0x0f0c A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:1148:0x0f3e A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:1150:0x0f70 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:1152:0x0fa2 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:1155:0x0fd4 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:1156:0x1006 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:1158:0x1038 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:1160:0x106a A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:1162:0x109c A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:1164:0x10e1 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:1167:0x1113 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:1169:0x1145 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:1170:0x1177 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:1172:0x11a9 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:1174:0x1310 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:1181:0x1339 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0132  */
    /* JADX WARNING: Removed duplicated region for block: B:633:0x0d68  */
    /* JADX WARNING: Removed duplicated region for block: B:638:0x0d81  */
    /* JADX WARNING: Removed duplicated region for block: B:639:0x0d88  */
    /* JADX WARNING: Removed duplicated region for block: B:643:0x0d9a  */
    /* JADX WARNING: Removed duplicated region for block: B:648:0x0db3  */
    /* JADX WARNING: Removed duplicated region for block: B:649:0x0dba  */
    /* JADX WARNING: Removed duplicated region for block: B:653:0x0dcc  */
    /* JADX WARNING: Removed duplicated region for block: B:658:0x0de5  */
    /* JADX WARNING: Removed duplicated region for block: B:659:0x0dec  */
    /* JADX WARNING: Removed duplicated region for block: B:663:0x0dfe  */
    /* JADX WARNING: Removed duplicated region for block: B:668:0x0e17  */
    /* JADX WARNING: Removed duplicated region for block: B:669:0x0e1e  */
    /* JADX WARNING: Removed duplicated region for block: B:673:0x0e30  */
    /* JADX WARNING: Removed duplicated region for block: B:678:0x0e49  */
    /* JADX WARNING: Removed duplicated region for block: B:679:0x0e50  */
    /* JADX WARNING: Removed duplicated region for block: B:683:0x0e62  */
    /* JADX WARNING: Removed duplicated region for block: B:688:0x0e7b  */
    /* JADX WARNING: Removed duplicated region for block: B:689:0x0e82  */
    /* JADX WARNING: Removed duplicated region for block: B:693:0x0e94  */
    /* JADX WARNING: Removed duplicated region for block: B:698:0x0ead  */
    /* JADX WARNING: Removed duplicated region for block: B:699:0x0eb4  */
    /* JADX WARNING: Removed duplicated region for block: B:703:0x0ec6  */
    /* JADX WARNING: Removed duplicated region for block: B:708:0x0edf  */
    /* JADX WARNING: Removed duplicated region for block: B:709:0x0ee6  */
    /* JADX WARNING: Removed duplicated region for block: B:713:0x0ef8  */
    /* JADX WARNING: Removed duplicated region for block: B:718:0x0f11  */
    /* JADX WARNING: Removed duplicated region for block: B:719:0x0f18  */
    /* JADX WARNING: Removed duplicated region for block: B:723:0x0f2a  */
    /* JADX WARNING: Removed duplicated region for block: B:728:0x0f43  */
    /* JADX WARNING: Removed duplicated region for block: B:729:0x0f4a  */
    /* JADX WARNING: Removed duplicated region for block: B:733:0x0f5c  */
    /* JADX WARNING: Removed duplicated region for block: B:738:0x0f75  */
    /* JADX WARNING: Removed duplicated region for block: B:739:0x0f7c  */
    /* JADX WARNING: Removed duplicated region for block: B:743:0x0f8e  */
    /* JADX WARNING: Removed duplicated region for block: B:748:0x0fa7  */
    /* JADX WARNING: Removed duplicated region for block: B:749:0x0fae  */
    /* JADX WARNING: Removed duplicated region for block: B:753:0x0fc0  */
    /* JADX WARNING: Removed duplicated region for block: B:758:0x0fd9  */
    /* JADX WARNING: Removed duplicated region for block: B:759:0x0fe0  */
    /* JADX WARNING: Removed duplicated region for block: B:763:0x0ff2  */
    /* JADX WARNING: Removed duplicated region for block: B:768:0x100b  */
    /* JADX WARNING: Removed duplicated region for block: B:769:0x1012  */
    /* JADX WARNING: Removed duplicated region for block: B:773:0x1024  */
    /* JADX WARNING: Removed duplicated region for block: B:778:0x103d  */
    /* JADX WARNING: Removed duplicated region for block: B:779:0x1044  */
    /* JADX WARNING: Removed duplicated region for block: B:783:0x1056  */
    /* JADX WARNING: Removed duplicated region for block: B:788:0x106f  */
    /* JADX WARNING: Removed duplicated region for block: B:789:0x1076  */
    /* JADX WARNING: Removed duplicated region for block: B:793:0x1088  */
    /* JADX WARNING: Removed duplicated region for block: B:798:0x10a1  */
    /* JADX WARNING: Removed duplicated region for block: B:799:0x10a8  */
    /* JADX WARNING: Removed duplicated region for block: B:802:0x10b4  */
    /* JADX WARNING: Removed duplicated region for block: B:803:0x10bb  */
    /* JADX WARNING: Removed duplicated region for block: B:807:0x10cd  */
    /* JADX WARNING: Removed duplicated region for block: B:812:0x10e6  */
    /* JADX WARNING: Removed duplicated region for block: B:813:0x10ed  */
    /* JADX WARNING: Removed duplicated region for block: B:817:0x10ff  */
    /* JADX WARNING: Removed duplicated region for block: B:822:0x1118  */
    /* JADX WARNING: Removed duplicated region for block: B:823:0x111f  */
    /* JADX WARNING: Removed duplicated region for block: B:827:0x1131  */
    /* JADX WARNING: Removed duplicated region for block: B:832:0x114a  */
    /* JADX WARNING: Removed duplicated region for block: B:833:0x1151  */
    /* JADX WARNING: Removed duplicated region for block: B:837:0x1163  */
    /* JADX WARNING: Removed duplicated region for block: B:842:0x117c  */
    /* JADX WARNING: Removed duplicated region for block: B:843:0x1183  */
    /* JADX WARNING: Removed duplicated region for block: B:847:0x1195  */
    /* JADX WARNING: Removed duplicated region for block: B:852:0x11ae  */
    /* JADX WARNING: Removed duplicated region for block: B:853:0x11b5  */
    /* JADX WARNING: Removed duplicated region for block: B:856:0x11c1  */
    /* JADX WARNING: Removed duplicated region for block: B:857:0x11c3  */
    /* JADX WARNING: Removed duplicated region for block: B:862:0x11ea  */
    /* JADX WARNING: Removed duplicated region for block: B:879:0x124f  */
    /* JADX WARNING: Removed duplicated region for block: B:883:0x1268  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002c  */
    /* JADX WARNING: Removed duplicated region for block: B:918:0x1325  */
    /* JADX WARNING: Removed duplicated region for block: B:923:0x133e  */
    /* JADX WARNING: Removed duplicated region for block: B:924:0x1343  */
    /* JADX WARNING: Removed duplicated region for block: B:927:0x134e  */
    /* JADX WARNING: Removed duplicated region for block: B:928:0x1359  */
    /* JADX WARNING: Removed duplicated region for block: B:936:0x1380  */
    /* JADX WARNING: Removed duplicated region for block: B:937:0x1387  */
    /* JADX WARNING: Removed duplicated region for block: B:942:0x1399  */
    /* JADX WARNING: Removed duplicated region for block: B:943:0x13a0  */
    /* JADX WARNING: Removed duplicated region for block: B:946:0x13b1  */
    /* JADX WARNING: Removed duplicated region for block: B:947:0x13b6  */
    /* JADX WARNING: Removed duplicated region for block: B:950:0x13c1  */
    /* JADX WARNING: Removed duplicated region for block: B:951:0x13c6  */
    /* JADX WARNING: Removed duplicated region for block: B:954:0x13d1  */
    /* JADX WARNING: Removed duplicated region for block: B:955:0x13d6  */
    /* JADX WARNING: Removed duplicated region for block: B:958:0x13e2  */
    /* JADX WARNING: Removed duplicated region for block: B:959:0x13e7  */
    /* JADX WARNING: Removed duplicated region for block: B:961:0x13eb  */
    /* JADX WARNING: Removed duplicated region for block: B:962:0x13f4  */
    /* JADX WARNING: Removed duplicated region for block: B:964:0x13fa  */
    /* JADX WARNING: Removed duplicated region for block: B:965:0x1405  */
    /* JADX WARNING: Removed duplicated region for block: B:967:0x140b  */
    /* JADX WARNING: Removed duplicated region for block: B:968:0x1417  */
    /* JADX WARNING: Removed duplicated region for block: B:970:0x141e  */
    /* JADX WARNING: Removed duplicated region for block: B:971:0x1429  */
    /* JADX WARNING: Removed duplicated region for block: B:973:0x142f  */
    /* JADX WARNING: Removed duplicated region for block: B:974:0x1439  */
    /* JADX WARNING: Removed duplicated region for block: B:976:0x1440  */
    /* JADX WARNING: Removed duplicated region for block: B:977:0x1447  */
    /* JADX WARNING: Removed duplicated region for block: B:979:0x144b  */
    /* JADX WARNING: Removed duplicated region for block: B:980:0x1452  */
    /* JADX WARNING: Removed duplicated region for block: B:982:0x1456  */
    /* JADX WARNING: Removed duplicated region for block: B:983:0x145d  */
    /* JADX WARNING: Removed duplicated region for block: B:986:0x1469  */
    /* JADX WARNING: Removed duplicated region for block: B:987:0x1470  */
    /* JADX WARNING: Removed duplicated region for block: B:990:0x147c  */
    /* JADX WARNING: Removed duplicated region for block: B:991:0x1483  */
    /* JADX WARNING: Removed duplicated region for block: B:993:0x1487  */
    /* JADX WARNING: Removed duplicated region for block: B:994:0x148e  */
    /* JADX WARNING: Removed duplicated region for block: B:997:0x149a  */
    /* JADX WARNING: Removed duplicated region for block: B:998:0x14a1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object initialSetupCall(java.util.List<? extends com.blueair.core.model.HasBlueCloudFunctions> r111, kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<java.util.List<com.blueair.api.client.UserDevicesBlueClient.DeviceDataOnBlue>>> r112) {
        /*
            r110 = this;
            r1 = r110
            r0 = r112
            boolean r2 = r0 instanceof com.blueair.api.client.UserDevicesBlueClient$initialSetupCall$1
            if (r2 == 0) goto L_0x0018
            r2 = r0
            com.blueair.api.client.UserDevicesBlueClient$initialSetupCall$1 r2 = (com.blueair.api.client.UserDevicesBlueClient$initialSetupCall$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r0 = r2.label
            int r0 = r0 - r4
            r2.label = r0
            goto L_0x001d
        L_0x0018:
            com.blueair.api.client.UserDevicesBlueClient$initialSetupCall$1 r2 = new com.blueair.api.client.UserDevicesBlueClient$initialSetupCall$1
            r2.<init>(r1, r0)
        L_0x001d:
            java.lang.Object r0 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 2
            r6 = 10
            r7 = 1
            r8 = 0
            if (r4 == 0) goto L_0x004f
            if (r4 != r7) goto L_0x0047
            java.lang.Object r3 = r2.L$4
            com.blueair.api.restapi.InitialBody r3 = (com.blueair.api.restapi.InitialBody) r3
            java.lang.Object r3 = r2.L$3
            java.util.List r3 = (java.util.List) r3
            java.lang.Object r3 = r2.L$2
            com.blueair.api.restapi.EventSubscription r3 = (com.blueair.api.restapi.EventSubscription) r3
            java.lang.Object r3 = r2.L$1
            kotlin.jvm.internal.Ref$ObjectRef r3 = (kotlin.jvm.internal.Ref.ObjectRef) r3
            java.lang.Object r2 = r2.L$0
            java.util.List r2 = (java.util.List) r2
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x012a
        L_0x0047:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x004f:
            kotlin.ResultKt.throwOnFailure(r0)
            boolean r0 = r111.isEmpty()
            if (r0 == 0) goto L_0x0063
            io.flatcircle.coroutinehelper.ApiResult$Companion r0 = io.flatcircle.coroutinehelper.ApiResult.Companion
            java.util.List r2 = kotlin.collections.CollectionsKt.emptyList()
            io.flatcircle.coroutinehelper.ApiResult r0 = r0.success(r2)
            return r0
        L_0x0063:
            kotlin.jvm.internal.Ref$ObjectRef r0 = new kotlin.jvm.internal.Ref$ObjectRef
            r0.<init>()
            java.lang.String r4 = "= "
            r0.element = r4
            r4 = r111
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.util.Iterator r9 = r4.iterator()
        L_0x0074:
            boolean r10 = r9.hasNext()
            if (r10 == 0) goto L_0x009f
            java.lang.Object r10 = r9.next()
            com.blueair.core.model.HasBlueCloudFunctions r10 = (com.blueair.core.model.HasBlueCloudFunctions) r10
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            T r12 = r0.element
            java.lang.String r12 = (java.lang.String) r12
            r11.append(r12)
            java.lang.String r10 = r10.getUid()
            r11.append(r10)
            java.lang.String r10 = ", "
            r11.append(r10)
            java.lang.String r10 = r11.toString()
            r0.element = r10
            goto L_0x0074
        L_0x009f:
            T r9 = r0.element
            java.lang.String r9 = (java.lang.String) r9
            kotlin.text.StringsKt.dropLast((java.lang.String) r9, (int) r5)
            com.blueair.api.restapi.EventSubscription r11 = new com.blueair.api.restapi.EventSubscription
            com.blueair.api.restapi.Include r9 = new com.blueair.api.restapi.Include
            com.blueair.api.restapi.Filter r10 = new com.blueair.api.restapi.Filter
            T r12 = r0.element
            java.lang.String r12 = (java.lang.String) r12
            r10.<init>(r12)
            r9.<init>(r10)
            java.util.List r9 = kotlin.collections.CollectionsKt.listOf(r9)
            r11.<init>(r9)
            java.util.ArrayList r9 = new java.util.ArrayList
            int r10 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r4, r6)
            r9.<init>(r10)
            java.util.Collection r9 = (java.util.Collection) r9
            java.util.Iterator r4 = r4.iterator()
        L_0x00cc:
            boolean r10 = r4.hasNext()
            if (r10 == 0) goto L_0x00e5
            java.lang.Object r10 = r4.next()
            com.blueair.core.model.HasBlueCloudFunctions r10 = (com.blueair.core.model.HasBlueCloudFunctions) r10
            com.blueair.api.restapi.DeviceConfigQuery r12 = new com.blueair.api.restapi.DeviceConfigQuery
            java.lang.String r10 = r10.getUid()
            r12.<init>(r10, r8, r5, r8)
            r9.add(r12)
            goto L_0x00cc
        L_0x00e5:
            r12 = r9
            java.util.List r12 = (java.util.List) r12
            com.blueair.api.restapi.InitialBody r10 = new com.blueair.api.restapi.InitialBody
            r15 = 12
            r16 = 0
            r13 = 0
            r14 = 0
            r10.<init>(r11, r12, r13, r14, r15, r16)
            com.blueair.api.restapi.UserDevicesRestApi r4 = r1.getUserDevicesRestApi()
            com.blueair.auth.AuthService r9 = r1.getAuthService()
            java.lang.String r9 = r9.getUserIdForBlueCloud()
            kotlinx.coroutines.Deferred r4 = r4.initialSetupCall(r9, r10)
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r111)
            r2.L$0 = r9
            java.lang.Object r0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)
            r2.L$1 = r0
            java.lang.Object r0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r11)
            r2.L$2 = r0
            java.lang.Object r0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r12)
            r2.L$3 = r0
            java.lang.Object r0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r10)
            r2.L$4 = r0
            r2.label = r7
            java.lang.Object r0 = r1.awaitCall(r4, r2)
            if (r0 != r3) goto L_0x012a
            return r3
        L_0x012a:
            io.flatcircle.coroutinehelper.ApiResult r0 = (io.flatcircle.coroutinehelper.ApiResult) r0
            boolean r2 = r0.isSuccess()
            if (r2 == 0) goto L_0x1551
            java.lang.Object r0 = r0.getOrNull()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            com.blueair.api.restapi.InitialResponse r0 = (com.blueair.api.restapi.InitialResponse) r0
            java.util.List r0 = r0.getDeviceInfo()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r2 = new java.util.ArrayList
            int r3 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r0, r6)
            r2.<init>(r3)
            java.util.Collection r2 = (java.util.Collection) r2
            java.util.Iterator r3 = r0.iterator()
        L_0x0150:
            boolean r0 = r3.hasNext()
            r4 = 0
            if (r0 == 0) goto L_0x151e
            java.lang.Object r0 = r3.next()
            r9 = r0
            com.blueair.api.restapi.DeviceInfo r9 = (com.blueair.api.restapi.DeviceInfo) r9
            timber.log.Timber$Forest r0 = timber.log.Timber.Forest
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r11 = "Initial call done, received "
            r10.<init>(r11)
            r10.append(r9)
            java.lang.String r10 = r10.toString()
            java.lang.Object[] r11 = new java.lang.Object[r4]
            r0.d(r10, r11)
            java.util.List r0 = r9.getStates()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x017d:
            boolean r10 = r0.hasNext()
            if (r10 == 0) goto L_0x0197
            java.lang.Object r10 = r0.next()
            r11 = r10
            com.blueair.api.restapi.State r11 = (com.blueair.api.restapi.State) r11
            java.lang.String r11 = r11.getN()
            java.lang.String r12 = "fanspeed"
            boolean r11 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r11, (java.lang.Object) r12)
            if (r11 == 0) goto L_0x017d
            goto L_0x0198
        L_0x0197:
            r10 = r8
        L_0x0198:
            com.blueair.api.restapi.State r10 = (com.blueair.api.restapi.State) r10
            if (r10 == 0) goto L_0x01a9
            java.lang.Integer r0 = r10.getV()
            if (r0 == 0) goto L_0x01a9
            int r0 = r0.intValue()
            r18 = r0
            goto L_0x01ab
        L_0x01a9:
            r18 = r4
        L_0x01ab:
            java.util.List r0 = r9.getStates()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x01b5:
            boolean r10 = r0.hasNext()
            if (r10 == 0) goto L_0x01cf
            java.lang.Object r10 = r0.next()
            r11 = r10
            com.blueair.api.restapi.State r11 = (com.blueair.api.restapi.State) r11
            java.lang.String r11 = r11.getN()
            java.lang.String r12 = "brightness"
            boolean r11 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r11, (java.lang.Object) r12)
            if (r11 == 0) goto L_0x01b5
            goto L_0x01d0
        L_0x01cf:
            r10 = r8
        L_0x01d0:
            com.blueair.api.restapi.State r10 = (com.blueair.api.restapi.State) r10
            if (r10 == 0) goto L_0x01e1
            java.lang.Integer r0 = r10.getV()
            if (r0 == 0) goto L_0x01e1
            int r0 = r0.intValue()
            r19 = r0
            goto L_0x01e3
        L_0x01e1:
            r19 = r4
        L_0x01e3:
            java.util.List r0 = r9.getStates()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x01ed:
            boolean r10 = r0.hasNext()
            if (r10 == 0) goto L_0x0207
            java.lang.Object r10 = r0.next()
            r11 = r10
            com.blueair.api.restapi.State r11 = (com.blueair.api.restapi.State) r11
            java.lang.String r11 = r11.getN()
            java.lang.String r12 = "childlock"
            boolean r11 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r11, (java.lang.Object) r12)
            if (r11 == 0) goto L_0x01ed
            goto L_0x0208
        L_0x0207:
            r10 = r8
        L_0x0208:
            com.blueair.api.restapi.State r10 = (com.blueair.api.restapi.State) r10
            if (r10 == 0) goto L_0x0212
            java.lang.Boolean r0 = r10.getVb()
            r10 = r0
            goto L_0x0213
        L_0x0212:
            r10 = r8
        L_0x0213:
            java.util.List r0 = r9.getStates()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x021d:
            boolean r11 = r0.hasNext()
            if (r11 == 0) goto L_0x0237
            java.lang.Object r11 = r0.next()
            r12 = r11
            com.blueair.api.restapi.State r12 = (com.blueair.api.restapi.State) r12
            java.lang.String r12 = r12.getN()
            java.lang.String r13 = "automode"
            boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r12, (java.lang.Object) r13)
            if (r12 == 0) goto L_0x021d
            goto L_0x0238
        L_0x0237:
            r11 = r8
        L_0x0238:
            com.blueair.api.restapi.State r11 = (com.blueair.api.restapi.State) r11
            if (r11 == 0) goto L_0x0242
            java.lang.Boolean r0 = r11.getVb()
            r11 = r0
            goto L_0x0243
        L_0x0242:
            r11 = r8
        L_0x0243:
            java.util.List r0 = r9.getStates()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x024d:
            boolean r12 = r0.hasNext()
            if (r12 == 0) goto L_0x0267
            java.lang.Object r12 = r0.next()
            r13 = r12
            com.blueair.api.restapi.State r13 = (com.blueair.api.restapi.State) r13
            java.lang.String r13 = r13.getN()
            java.lang.String r14 = "standby"
            boolean r13 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r13, (java.lang.Object) r14)
            if (r13 == 0) goto L_0x024d
            goto L_0x0268
        L_0x0267:
            r12 = r8
        L_0x0268:
            com.blueair.api.restapi.State r12 = (com.blueair.api.restapi.State) r12
            if (r12 == 0) goto L_0x0272
            java.lang.Boolean r0 = r12.getVb()
            r12 = r0
            goto L_0x0273
        L_0x0272:
            r12 = r8
        L_0x0273:
            java.util.List r0 = r9.getStates()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x027d:
            boolean r13 = r0.hasNext()
            if (r13 == 0) goto L_0x0297
            java.lang.Object r13 = r0.next()
            r14 = r13
            com.blueair.api.restapi.State r14 = (com.blueair.api.restapi.State) r14
            java.lang.String r14 = r14.getN()
            java.lang.String r15 = "eco"
            boolean r14 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r15)
            if (r14 == 0) goto L_0x027d
            goto L_0x0298
        L_0x0297:
            r13 = r8
        L_0x0298:
            com.blueair.api.restapi.State r13 = (com.blueair.api.restapi.State) r13
            if (r13 == 0) goto L_0x02a2
            java.lang.Boolean r0 = r13.getVb()
            r13 = r0
            goto L_0x02a3
        L_0x02a2:
            r13 = r8
        L_0x02a3:
            java.util.List r0 = r9.getStates()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x02ad:
            boolean r14 = r0.hasNext()
            if (r14 == 0) goto L_0x02cc
            java.lang.Object r14 = r0.next()
            r15 = r14
            com.blueair.api.restapi.State r15 = (com.blueair.api.restapi.State) r15
            java.lang.String r15 = r15.getN()
            r112 = r7
            java.lang.String r7 = "hins"
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r15, (java.lang.Object) r7)
            if (r7 == 0) goto L_0x02c9
            goto L_0x02cf
        L_0x02c9:
            r7 = r112
            goto L_0x02ad
        L_0x02cc:
            r112 = r7
            r14 = r8
        L_0x02cf:
            com.blueair.api.restapi.State r14 = (com.blueair.api.restapi.State) r14
            if (r14 == 0) goto L_0x02d9
            java.lang.Boolean r0 = r14.getVb()
            r7 = r0
            goto L_0x02da
        L_0x02d9:
            r7 = r8
        L_0x02da:
            java.util.List r0 = r9.getStates()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x02e4:
            boolean r14 = r0.hasNext()
            if (r14 == 0) goto L_0x0300
            java.lang.Object r14 = r0.next()
            r15 = r14
            com.blueair.api.restapi.State r15 = (com.blueair.api.restapi.State) r15
            java.lang.String r15 = r15.getN()
            java.lang.String r8 = "nmhins"
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r15, (java.lang.Object) r8)
            if (r8 == 0) goto L_0x02fe
            goto L_0x0301
        L_0x02fe:
            r8 = 0
            goto L_0x02e4
        L_0x0300:
            r14 = 0
        L_0x0301:
            com.blueair.api.restapi.State r14 = (com.blueair.api.restapi.State) r14
            if (r14 == 0) goto L_0x030b
            java.lang.Boolean r0 = r14.getVb()
            r8 = r0
            goto L_0x030c
        L_0x030b:
            r8 = 0
        L_0x030c:
            java.util.List r0 = r9.getStates()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x0316:
            boolean r14 = r0.hasNext()
            if (r14 == 0) goto L_0x0335
            java.lang.Object r14 = r0.next()
            r15 = r14
            com.blueair.api.restapi.State r15 = (com.blueair.api.restapi.State) r15
            java.lang.String r15 = r15.getN()
            r111 = r4
            java.lang.String r4 = "nightmode"
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r15, (java.lang.Object) r4)
            if (r4 == 0) goto L_0x0332
            goto L_0x0338
        L_0x0332:
            r4 = r111
            goto L_0x0316
        L_0x0335:
            r111 = r4
            r14 = 0
        L_0x0338:
            com.blueair.api.restapi.State r14 = (com.blueair.api.restapi.State) r14
            if (r14 == 0) goto L_0x0342
            java.lang.Boolean r0 = r14.getVb()
            r4 = r0
            goto L_0x0343
        L_0x0342:
            r4 = 0
        L_0x0343:
            java.util.List r0 = r9.getStates()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x034d:
            boolean r14 = r0.hasNext()
            if (r14 == 0) goto L_0x036c
            java.lang.Object r14 = r0.next()
            r15 = r14
            com.blueair.api.restapi.State r15 = (com.blueair.api.restapi.State) r15
            java.lang.String r15 = r15.getN()
            r106 = r5
            java.lang.String r5 = "germshield"
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r15, (java.lang.Object) r5)
            if (r5 == 0) goto L_0x0369
            goto L_0x036f
        L_0x0369:
            r5 = r106
            goto L_0x034d
        L_0x036c:
            r106 = r5
            r14 = 0
        L_0x036f:
            com.blueair.api.restapi.State r14 = (com.blueair.api.restapi.State) r14
            if (r14 == 0) goto L_0x0379
            java.lang.Boolean r0 = r14.getVb()
            r5 = r0
            goto L_0x037a
        L_0x0379:
            r5 = 0
        L_0x037a:
            java.util.List r0 = r9.getStates()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x0384:
            boolean r14 = r0.hasNext()
            if (r14 == 0) goto L_0x03a1
            java.lang.Object r14 = r0.next()
            r15 = r14
            com.blueair.api.restapi.State r15 = (com.blueair.api.restapi.State) r15
            java.lang.String r15 = r15.getN()
            java.lang.String r6 = "gsnm"
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r15, (java.lang.Object) r6)
            if (r6 == 0) goto L_0x039e
            goto L_0x03a2
        L_0x039e:
            r6 = 10
            goto L_0x0384
        L_0x03a1:
            r14 = 0
        L_0x03a2:
            com.blueair.api.restapi.State r14 = (com.blueair.api.restapi.State) r14
            if (r14 == 0) goto L_0x03ad
            java.lang.Boolean r0 = r14.getVb()
            r34 = r0
            goto L_0x03af
        L_0x03ad:
            r34 = 0
        L_0x03af:
            java.util.List r0 = r9.getStates()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x03b9:
            boolean r6 = r0.hasNext()
            if (r6 == 0) goto L_0x03d3
            java.lang.Object r6 = r0.next()
            r14 = r6
            com.blueair.api.restapi.State r14 = (com.blueair.api.restapi.State) r14
            java.lang.String r14 = r14.getN()
            java.lang.String r15 = "safetyswitch"
            boolean r14 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r15)
            if (r14 == 0) goto L_0x03b9
            goto L_0x03d4
        L_0x03d3:
            r6 = 0
        L_0x03d4:
            com.blueair.api.restapi.State r6 = (com.blueair.api.restapi.State) r6
            if (r6 == 0) goto L_0x03de
            java.lang.Boolean r0 = r6.getVb()
            r6 = r0
            goto L_0x03df
        L_0x03de:
            r6 = 0
        L_0x03df:
            java.util.List r0 = r9.getStates()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x03e9:
            boolean r14 = r0.hasNext()
            if (r14 == 0) goto L_0x0408
            java.lang.Object r14 = r0.next()
            r15 = r14
            com.blueair.api.restapi.State r15 = (com.blueair.api.restapi.State) r15
            java.lang.String r15 = r15.getN()
            r16 = r0
            java.lang.String r0 = "filterusage"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r15, (java.lang.Object) r0)
            if (r0 == 0) goto L_0x0405
            goto L_0x0409
        L_0x0405:
            r0 = r16
            goto L_0x03e9
        L_0x0408:
            r14 = 0
        L_0x0409:
            com.blueair.api.restapi.State r14 = (com.blueair.api.restapi.State) r14
            if (r14 == 0) goto L_0x0414
            java.lang.Integer r0 = r14.getV()
            r22 = r0
            goto L_0x0416
        L_0x0414:
            r22 = 0
        L_0x0416:
            java.util.List r0 = r9.getStates()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x0420:
            boolean r14 = r0.hasNext()
            if (r14 == 0) goto L_0x043f
            java.lang.Object r14 = r0.next()
            r15 = r14
            com.blueair.api.restapi.State r15 = (com.blueair.api.restapi.State) r15
            java.lang.String r15 = r15.getN()
            r16 = r0
            java.lang.String r0 = "disinfection"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r15, (java.lang.Object) r0)
            if (r0 == 0) goto L_0x043c
            goto L_0x0440
        L_0x043c:
            r0 = r16
            goto L_0x0420
        L_0x043f:
            r14 = 0
        L_0x0440:
            com.blueair.api.restapi.State r14 = (com.blueair.api.restapi.State) r14
            if (r14 == 0) goto L_0x044b
            java.lang.Boolean r0 = r14.getVb()
            r43 = r0
            goto L_0x044d
        L_0x044b:
            r43 = 0
        L_0x044d:
            java.util.List r0 = r9.getStates()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x0457:
            boolean r14 = r0.hasNext()
            if (r14 == 0) goto L_0x0476
            java.lang.Object r14 = r0.next()
            r15 = r14
            com.blueair.api.restapi.State r15 = (com.blueair.api.restapi.State) r15
            java.lang.String r15 = r15.getN()
            r16 = r0
            java.lang.String r0 = "disinftime"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r15, (java.lang.Object) r0)
            if (r0 == 0) goto L_0x0473
            goto L_0x0477
        L_0x0473:
            r0 = r16
            goto L_0x0457
        L_0x0476:
            r14 = 0
        L_0x0477:
            com.blueair.api.restapi.State r14 = (com.blueair.api.restapi.State) r14
            if (r14 == 0) goto L_0x0482
            java.lang.Integer r0 = r14.getV()
            r44 = r0
            goto L_0x0484
        L_0x0482:
            r44 = 0
        L_0x0484:
            if (r14 == 0) goto L_0x0491
            long r14 = r14.getT()
            java.lang.Long r0 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r14)
            r45 = r0
            goto L_0x0493
        L_0x0491:
            r45 = 0
        L_0x0493:
            java.util.List r0 = r9.getStates()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x049d:
            boolean r14 = r0.hasNext()
            if (r14 == 0) goto L_0x04bc
            java.lang.Object r14 = r0.next()
            r15 = r14
            com.blueair.api.restapi.State r15 = (com.blueair.api.restapi.State) r15
            java.lang.String r15 = r15.getN()
            r16 = r0
            java.lang.String r0 = "wickdrye"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r15, (java.lang.Object) r0)
            if (r0 == 0) goto L_0x04b9
            goto L_0x04bd
        L_0x04b9:
            r0 = r16
            goto L_0x049d
        L_0x04bc:
            r14 = 0
        L_0x04bd:
            com.blueair.api.restapi.State r14 = (com.blueair.api.restapi.State) r14
            if (r14 == 0) goto L_0x04c8
            java.lang.Boolean r0 = r14.getVb()
            r47 = r0
            goto L_0x04ca
        L_0x04c8:
            r47 = 0
        L_0x04ca:
            java.util.List r0 = r9.getStates()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x04d4:
            boolean r14 = r0.hasNext()
            if (r14 == 0) goto L_0x04f3
            java.lang.Object r14 = r0.next()
            r15 = r14
            com.blueair.api.restapi.State r15 = (com.blueair.api.restapi.State) r15
            java.lang.String r15 = r15.getN()
            r16 = r0
            java.lang.String r0 = "wickdrys"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r15, (java.lang.Object) r0)
            if (r0 == 0) goto L_0x04f0
            goto L_0x04f4
        L_0x04f0:
            r0 = r16
            goto L_0x04d4
        L_0x04f3:
            r14 = 0
        L_0x04f4:
            com.blueair.api.restapi.State r14 = (com.blueair.api.restapi.State) r14
            if (r14 == 0) goto L_0x04ff
            java.lang.Boolean r0 = r14.getVb()
            r48 = r0
            goto L_0x0501
        L_0x04ff:
            r48 = 0
        L_0x0501:
            java.util.List r0 = r9.getStates()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x050b:
            boolean r14 = r0.hasNext()
            if (r14 == 0) goto L_0x052a
            java.lang.Object r14 = r0.next()
            r15 = r14
            com.blueair.api.restapi.State r15 = (com.blueair.api.restapi.State) r15
            java.lang.String r15 = r15.getN()
            r16 = r0
            java.lang.String r0 = "wickdryl"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r15, (java.lang.Object) r0)
            if (r0 == 0) goto L_0x0527
            goto L_0x052b
        L_0x0527:
            r0 = r16
            goto L_0x050b
        L_0x052a:
            r14 = 0
        L_0x052b:
            com.blueair.api.restapi.State r14 = (com.blueair.api.restapi.State) r14
            if (r14 == 0) goto L_0x0536
            java.lang.Integer r0 = r14.getV()
            r49 = r0
            goto L_0x0538
        L_0x0536:
            r49 = 0
        L_0x0538:
            java.util.List r0 = r9.getStates()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x0542:
            boolean r14 = r0.hasNext()
            if (r14 == 0) goto L_0x0561
            java.lang.Object r14 = r0.next()
            r15 = r14
            com.blueair.api.restapi.State r15 = (com.blueair.api.restapi.State) r15
            java.lang.String r15 = r15.getN()
            r16 = r0
            java.lang.String r0 = "wickdryts"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r15, (java.lang.Object) r0)
            if (r0 == 0) goto L_0x055e
            goto L_0x0562
        L_0x055e:
            r0 = r16
            goto L_0x0542
        L_0x0561:
            r14 = 0
        L_0x0562:
            com.blueair.api.restapi.State r14 = (com.blueair.api.restapi.State) r14
            if (r14 == 0) goto L_0x056c
            java.lang.Integer r0 = r14.getV()
            r14 = r0
            goto L_0x056d
        L_0x056c:
            r14 = 0
        L_0x056d:
            java.util.List r0 = r9.getStates()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x0577:
            boolean r15 = r0.hasNext()
            if (r15 == 0) goto L_0x0599
            java.lang.Object r15 = r0.next()
            r16 = r15
            com.blueair.api.restapi.State r16 = (com.blueair.api.restapi.State) r16
            r17 = r0
            java.lang.String r0 = r16.getN()
            java.lang.String r1 = "wickusage"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            if (r0 == 0) goto L_0x0594
            goto L_0x059a
        L_0x0594:
            r1 = r110
            r0 = r17
            goto L_0x0577
        L_0x0599:
            r15 = 0
        L_0x059a:
            com.blueair.api.restapi.State r15 = (com.blueair.api.restapi.State) r15
            if (r15 == 0) goto L_0x05a5
            java.lang.Integer r0 = r15.getV()
            r51 = r0
            goto L_0x05a7
        L_0x05a5:
            r51 = 0
        L_0x05a7:
            java.util.List r0 = r9.getStates()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x05b1:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x05d0
            java.lang.Object r1 = r0.next()
            r15 = r1
            com.blueair.api.restapi.State r15 = (com.blueair.api.restapi.State) r15
            java.lang.String r15 = r15.getN()
            r16 = r0
            java.lang.String r0 = "wshortage"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r15, (java.lang.Object) r0)
            if (r0 == 0) goto L_0x05cd
            goto L_0x05d1
        L_0x05cd:
            r0 = r16
            goto L_0x05b1
        L_0x05d0:
            r1 = 0
        L_0x05d1:
            com.blueair.api.restapi.State r1 = (com.blueair.api.restapi.State) r1
            if (r1 == 0) goto L_0x05dc
            java.lang.Boolean r0 = r1.getVb()
            r52 = r0
            goto L_0x05de
        L_0x05dc:
            r52 = 0
        L_0x05de:
            java.util.List r0 = r9.getStates()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x05e8:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0607
            java.lang.Object r1 = r0.next()
            r15 = r1
            com.blueair.api.restapi.State r15 = (com.blueair.api.restapi.State) r15
            java.lang.String r15 = r15.getN()
            r16 = r0
            java.lang.String r0 = "autorh"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r15, (java.lang.Object) r0)
            if (r0 == 0) goto L_0x0604
            goto L_0x0608
        L_0x0604:
            r0 = r16
            goto L_0x05e8
        L_0x0607:
            r1 = 0
        L_0x0608:
            com.blueair.api.restapi.State r1 = (com.blueair.api.restapi.State) r1
            if (r1 == 0) goto L_0x0613
            java.lang.Integer r0 = r1.getV()
            r53 = r0
            goto L_0x0615
        L_0x0613:
            r53 = 0
        L_0x0615:
            java.util.List r0 = r9.getStates()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x061f:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x063e
            java.lang.Object r1 = r0.next()
            r15 = r1
            com.blueair.api.restapi.State r15 = (com.blueair.api.restapi.State) r15
            java.lang.String r15 = r15.getN()
            r16 = r0
            java.lang.String r0 = "timstate"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r15, (java.lang.Object) r0)
            if (r0 == 0) goto L_0x063b
            goto L_0x063f
        L_0x063b:
            r0 = r16
            goto L_0x061f
        L_0x063e:
            r1 = 0
        L_0x063f:
            com.blueair.api.restapi.State r1 = (com.blueair.api.restapi.State) r1
            if (r1 == 0) goto L_0x064a
            java.lang.Integer r0 = r1.getV()
            r54 = r0
            goto L_0x064c
        L_0x064a:
            r54 = 0
        L_0x064c:
            java.util.List r0 = r9.getStates()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x0656:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0675
            java.lang.Object r1 = r0.next()
            r15 = r1
            com.blueair.api.restapi.State r15 = (com.blueair.api.restapi.State) r15
            java.lang.String r15 = r15.getN()
            r16 = r0
            java.lang.String r0 = "timdur"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r15, (java.lang.Object) r0)
            if (r0 == 0) goto L_0x0672
            goto L_0x0676
        L_0x0672:
            r0 = r16
            goto L_0x0656
        L_0x0675:
            r1 = 0
        L_0x0676:
            com.blueair.api.restapi.State r1 = (com.blueair.api.restapi.State) r1
            if (r1 == 0) goto L_0x0681
            java.lang.Integer r0 = r1.getV()
            r55 = r0
            goto L_0x0683
        L_0x0681:
            r55 = 0
        L_0x0683:
            java.util.List r0 = r9.getStates()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x068d:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x06ac
            java.lang.Object r1 = r0.next()
            r15 = r1
            com.blueair.api.restapi.State r15 = (com.blueair.api.restapi.State) r15
            java.lang.String r15 = r15.getN()
            r16 = r0
            java.lang.String r0 = "timl"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r15, (java.lang.Object) r0)
            if (r0 == 0) goto L_0x06a9
            goto L_0x06ad
        L_0x06a9:
            r0 = r16
            goto L_0x068d
        L_0x06ac:
            r1 = 0
        L_0x06ad:
            com.blueair.api.restapi.State r1 = (com.blueair.api.restapi.State) r1
            if (r1 == 0) goto L_0x06b8
            java.lang.Integer r0 = r1.getV()
            r56 = r0
            goto L_0x06ba
        L_0x06b8:
            r56 = 0
        L_0x06ba:
            java.util.List r0 = r9.getStates()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x06c4:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x06e3
            java.lang.Object r1 = r0.next()
            r15 = r1
            com.blueair.api.restapi.State r15 = (com.blueair.api.restapi.State) r15
            java.lang.String r15 = r15.getN()
            r16 = r0
            java.lang.String r0 = "timts"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r15, (java.lang.Object) r0)
            if (r0 == 0) goto L_0x06e0
            goto L_0x06e4
        L_0x06e0:
            r0 = r16
            goto L_0x06c4
        L_0x06e3:
            r1 = 0
        L_0x06e4:
            com.blueair.api.restapi.State r1 = (com.blueair.api.restapi.State) r1
            if (r1 == 0) goto L_0x06ee
            java.lang.Integer r0 = r1.getV()
            r1 = r0
            goto L_0x06ef
        L_0x06ee:
            r1 = 0
        L_0x06ef:
            java.util.List r0 = r9.getStates()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x06f9:
            boolean r15 = r0.hasNext()
            if (r15 == 0) goto L_0x071d
            java.lang.Object r15 = r0.next()
            r16 = r15
            com.blueair.api.restapi.State r16 = (com.blueair.api.restapi.State) r16
            r17 = r0
            java.lang.String r0 = r16.getN()
            r16 = r1
            java.lang.String r1 = "tu"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            if (r0 == 0) goto L_0x0718
            goto L_0x0720
        L_0x0718:
            r1 = r16
            r0 = r17
            goto L_0x06f9
        L_0x071d:
            r16 = r1
            r15 = 0
        L_0x0720:
            com.blueair.api.restapi.State r15 = (com.blueair.api.restapi.State) r15
            if (r15 == 0) goto L_0x072b
            java.lang.Integer r0 = r15.getV()
            r58 = r0
            goto L_0x072d
        L_0x072b:
            r58 = 0
        L_0x072d:
            java.util.List r0 = r9.getStates()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x0737:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0756
            java.lang.Object r1 = r0.next()
            r15 = r1
            com.blueair.api.restapi.State r15 = (com.blueair.api.restapi.State) r15
            java.lang.String r15 = r15.getN()
            r17 = r0
            java.lang.String r0 = "oscstate"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r15, (java.lang.Object) r0)
            if (r0 == 0) goto L_0x0753
            goto L_0x0757
        L_0x0753:
            r0 = r17
            goto L_0x0737
        L_0x0756:
            r1 = 0
        L_0x0757:
            com.blueair.api.restapi.State r1 = (com.blueair.api.restapi.State) r1
            if (r1 == 0) goto L_0x0762
            java.lang.Integer r0 = r1.getV()
            r59 = r0
            goto L_0x0764
        L_0x0762:
            r59 = 0
        L_0x0764:
            java.util.List r0 = r9.getStates()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x076e:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x078d
            java.lang.Object r1 = r0.next()
            r15 = r1
            com.blueair.api.restapi.State r15 = (com.blueair.api.restapi.State) r15
            java.lang.String r15 = r15.getN()
            r17 = r0
            java.lang.String r0 = "osc"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r15, (java.lang.Object) r0)
            if (r0 == 0) goto L_0x078a
            goto L_0x078e
        L_0x078a:
            r0 = r17
            goto L_0x076e
        L_0x078d:
            r1 = 0
        L_0x078e:
            com.blueair.api.restapi.State r1 = (com.blueair.api.restapi.State) r1
            if (r1 == 0) goto L_0x0799
            java.lang.Integer r0 = r1.getV()
            r60 = r0
            goto L_0x079b
        L_0x0799:
            r60 = 0
        L_0x079b:
            java.util.List r0 = r9.getStates()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x07a5:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x07c4
            java.lang.Object r1 = r0.next()
            r15 = r1
            com.blueair.api.restapi.State r15 = (com.blueair.api.restapi.State) r15
            java.lang.String r15 = r15.getN()
            r17 = r0
            java.lang.String r0 = "oscdir"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r15, (java.lang.Object) r0)
            if (r0 == 0) goto L_0x07c1
            goto L_0x07c5
        L_0x07c1:
            r0 = r17
            goto L_0x07a5
        L_0x07c4:
            r1 = 0
        L_0x07c5:
            com.blueair.api.restapi.State r1 = (com.blueair.api.restapi.State) r1
            if (r1 == 0) goto L_0x07d0
            java.lang.Integer r0 = r1.getV()
            r61 = r0
            goto L_0x07d2
        L_0x07d0:
            r61 = 0
        L_0x07d2:
            java.util.List r0 = r9.getStates()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x07dc:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x07fb
            java.lang.Object r1 = r0.next()
            r15 = r1
            com.blueair.api.restapi.State r15 = (com.blueair.api.restapi.State) r15
            java.lang.String r15 = r15.getN()
            r17 = r0
            java.lang.String r0 = "oscfs"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r15, (java.lang.Object) r0)
            if (r0 == 0) goto L_0x07f8
            goto L_0x07fc
        L_0x07f8:
            r0 = r17
            goto L_0x07dc
        L_0x07fb:
            r1 = 0
        L_0x07fc:
            com.blueair.api.restapi.State r1 = (com.blueair.api.restapi.State) r1
            if (r1 == 0) goto L_0x0807
            java.lang.Integer r0 = r1.getV()
            r62 = r0
            goto L_0x0809
        L_0x0807:
            r62 = 0
        L_0x0809:
            java.util.List r0 = r9.getStates()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x0813:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0832
            java.lang.Object r1 = r0.next()
            r15 = r1
            com.blueair.api.restapi.State r15 = (com.blueair.api.restapi.State) r15
            java.lang.String r15 = r15.getN()
            r17 = r0
            java.lang.String r0 = "mainmode"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r15, (java.lang.Object) r0)
            if (r0 == 0) goto L_0x082f
            goto L_0x0833
        L_0x082f:
            r0 = r17
            goto L_0x0813
        L_0x0832:
            r1 = 0
        L_0x0833:
            com.blueair.api.restapi.State r1 = (com.blueair.api.restapi.State) r1
            if (r1 == 0) goto L_0x083e
            java.lang.Integer r0 = r1.getV()
            r63 = r0
            goto L_0x0840
        L_0x083e:
            r63 = 0
        L_0x0840:
            java.util.List r0 = r9.getStates()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x084a:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0869
            java.lang.Object r1 = r0.next()
            r15 = r1
            com.blueair.api.restapi.State r15 = (com.blueair.api.restapi.State) r15
            java.lang.String r15 = r15.getN()
            r17 = r0
            java.lang.String r0 = "apsubmode"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r15, (java.lang.Object) r0)
            if (r0 == 0) goto L_0x0866
            goto L_0x086a
        L_0x0866:
            r0 = r17
            goto L_0x084a
        L_0x0869:
            r1 = 0
        L_0x086a:
            com.blueair.api.restapi.State r1 = (com.blueair.api.restapi.State) r1
            if (r1 == 0) goto L_0x0875
            java.lang.Integer r0 = r1.getV()
            r64 = r0
            goto L_0x0877
        L_0x0875:
            r64 = 0
        L_0x0877:
            java.util.List r0 = r9.getStates()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x0881:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x08a0
            java.lang.Object r1 = r0.next()
            r15 = r1
            com.blueair.api.restapi.State r15 = (com.blueair.api.restapi.State) r15
            java.lang.String r15 = r15.getN()
            r17 = r0
            java.lang.String r0 = "fsp0"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r15, (java.lang.Object) r0)
            if (r0 == 0) goto L_0x089d
            goto L_0x08a1
        L_0x089d:
            r0 = r17
            goto L_0x0881
        L_0x08a0:
            r1 = 0
        L_0x08a1:
            com.blueair.api.restapi.State r1 = (com.blueair.api.restapi.State) r1
            if (r1 == 0) goto L_0x08ac
            java.lang.Integer r0 = r1.getV()
            r65 = r0
            goto L_0x08ae
        L_0x08ac:
            r65 = 0
        L_0x08ae:
            java.util.List r0 = r9.getStates()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x08b8:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x08d7
            java.lang.Object r1 = r0.next()
            r15 = r1
            com.blueair.api.restapi.State r15 = (com.blueair.api.restapi.State) r15
            java.lang.String r15 = r15.getN()
            r17 = r0
            java.lang.String r0 = "heatsubmode"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r15, (java.lang.Object) r0)
            if (r0 == 0) goto L_0x08d4
            goto L_0x08d8
        L_0x08d4:
            r0 = r17
            goto L_0x08b8
        L_0x08d7:
            r1 = 0
        L_0x08d8:
            com.blueair.api.restapi.State r1 = (com.blueair.api.restapi.State) r1
            if (r1 == 0) goto L_0x08e3
            java.lang.Integer r0 = r1.getV()
            r66 = r0
            goto L_0x08e5
        L_0x08e3:
            r66 = 0
        L_0x08e5:
            java.util.List r0 = r9.getStates()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x08ef:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x090e
            java.lang.Object r1 = r0.next()
            r15 = r1
            com.blueair.api.restapi.State r15 = (com.blueair.api.restapi.State) r15
            java.lang.String r15 = r15.getN()
            r17 = r0
            java.lang.String r0 = "heatfs"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r15, (java.lang.Object) r0)
            if (r0 == 0) goto L_0x090b
            goto L_0x090f
        L_0x090b:
            r0 = r17
            goto L_0x08ef
        L_0x090e:
            r1 = 0
        L_0x090f:
            com.blueair.api.restapi.State r1 = (com.blueair.api.restapi.State) r1
            if (r1 == 0) goto L_0x091a
            java.lang.Integer r0 = r1.getV()
            r67 = r0
            goto L_0x091c
        L_0x091a:
            r67 = 0
        L_0x091c:
            java.util.List r0 = r9.getStates()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x0926:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0945
            java.lang.Object r1 = r0.next()
            r15 = r1
            com.blueair.api.restapi.State r15 = (com.blueair.api.restapi.State) r15
            java.lang.String r15 = r15.getN()
            r17 = r0
            java.lang.String r0 = "heattemp"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r15, (java.lang.Object) r0)
            if (r0 == 0) goto L_0x0942
            goto L_0x0946
        L_0x0942:
            r0 = r17
            goto L_0x0926
        L_0x0945:
            r1 = 0
        L_0x0946:
            com.blueair.api.restapi.State r1 = (com.blueair.api.restapi.State) r1
            if (r1 == 0) goto L_0x0950
            java.lang.Integer r0 = r1.getV()
            r1 = r0
            goto L_0x0951
        L_0x0950:
            r1 = 0
        L_0x0951:
            java.util.List r0 = r9.getStates()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x095b:
            boolean r15 = r0.hasNext()
            if (r15 == 0) goto L_0x097f
            java.lang.Object r15 = r0.next()
            r17 = r15
            com.blueair.api.restapi.State r17 = (com.blueair.api.restapi.State) r17
            r20 = r0
            java.lang.String r0 = r17.getN()
            r17 = r1
            java.lang.String r1 = "ecoheattemp"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            if (r0 == 0) goto L_0x097a
            goto L_0x0982
        L_0x097a:
            r1 = r17
            r0 = r20
            goto L_0x095b
        L_0x097f:
            r17 = r1
            r15 = 0
        L_0x0982:
            com.blueair.api.restapi.State r15 = (com.blueair.api.restapi.State) r15
            if (r15 == 0) goto L_0x098c
            java.lang.Integer r0 = r15.getV()
            r1 = r0
            goto L_0x098d
        L_0x098c:
            r1 = 0
        L_0x098d:
            java.util.List r0 = r9.getStates()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x0997:
            boolean r15 = r0.hasNext()
            if (r15 == 0) goto L_0x09bb
            java.lang.Object r15 = r0.next()
            r20 = r15
            com.blueair.api.restapi.State r20 = (com.blueair.api.restapi.State) r20
            r21 = r0
            java.lang.String r0 = r20.getN()
            r20 = r1
            java.lang.String r1 = "coolsubmode"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            if (r0 == 0) goto L_0x09b6
            goto L_0x09be
        L_0x09b6:
            r1 = r20
            r0 = r21
            goto L_0x0997
        L_0x09bb:
            r20 = r1
            r15 = 0
        L_0x09be:
            com.blueair.api.restapi.State r15 = (com.blueair.api.restapi.State) r15
            if (r15 == 0) goto L_0x09c9
            java.lang.Integer r0 = r15.getV()
            r70 = r0
            goto L_0x09cb
        L_0x09c9:
            r70 = 0
        L_0x09cb:
            java.util.List r0 = r9.getStates()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x09d5:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x09f4
            java.lang.Object r1 = r0.next()
            r15 = r1
            com.blueair.api.restapi.State r15 = (com.blueair.api.restapi.State) r15
            java.lang.String r15 = r15.getN()
            r21 = r0
            java.lang.String r0 = "coolfs"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r15, (java.lang.Object) r0)
            if (r0 == 0) goto L_0x09f1
            goto L_0x09f5
        L_0x09f1:
            r0 = r21
            goto L_0x09d5
        L_0x09f4:
            r1 = 0
        L_0x09f5:
            com.blueair.api.restapi.State r1 = (com.blueair.api.restapi.State) r1
            if (r1 == 0) goto L_0x0a00
            java.lang.Integer r0 = r1.getV()
            r71 = r0
            goto L_0x0a02
        L_0x0a00:
            r71 = 0
        L_0x0a02:
            java.util.List r0 = r9.getStates()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x0a0c:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0a2b
            java.lang.Object r1 = r0.next()
            r15 = r1
            com.blueair.api.restapi.State r15 = (com.blueair.api.restapi.State) r15
            java.lang.String r15 = r15.getN()
            r21 = r0
            java.lang.String r0 = "coolautotag"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r15, (java.lang.Object) r0)
            if (r0 == 0) goto L_0x0a28
            goto L_0x0a2c
        L_0x0a28:
            r0 = r21
            goto L_0x0a0c
        L_0x0a2b:
            r1 = 0
        L_0x0a2c:
            com.blueair.api.restapi.State r1 = (com.blueair.api.restapi.State) r1
            if (r1 == 0) goto L_0x0a37
            java.lang.Integer r0 = r1.getV()
            r72 = r0
            goto L_0x0a39
        L_0x0a37:
            r72 = 0
        L_0x0a39:
            java.util.List r0 = r9.getStates()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x0a43:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0a62
            java.lang.Object r1 = r0.next()
            r15 = r1
            com.blueair.api.restapi.State r15 = (com.blueair.api.restapi.State) r15
            java.lang.String r15 = r15.getN()
            r21 = r0
            java.lang.String r0 = "coolautofs1"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r15, (java.lang.Object) r0)
            if (r0 == 0) goto L_0x0a5f
            goto L_0x0a63
        L_0x0a5f:
            r0 = r21
            goto L_0x0a43
        L_0x0a62:
            r1 = 0
        L_0x0a63:
            com.blueair.api.restapi.State r1 = (com.blueair.api.restapi.State) r1
            if (r1 == 0) goto L_0x0a6c
            java.lang.Integer r0 = r1.getV()
            goto L_0x0a6d
        L_0x0a6c:
            r0 = 0
        L_0x0a6d:
            java.util.List r1 = r9.getStates()
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r1 = r1.iterator()
        L_0x0a77:
            boolean r15 = r1.hasNext()
            if (r15 == 0) goto L_0x0a9b
            java.lang.Object r15 = r1.next()
            r21 = r15
            com.blueair.api.restapi.State r21 = (com.blueair.api.restapi.State) r21
            r23 = r0
            java.lang.String r0 = r21.getN()
            r21 = r1
            java.lang.String r1 = "coolautofs2"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            if (r0 == 0) goto L_0x0a96
            goto L_0x0a9e
        L_0x0a96:
            r1 = r21
            r0 = r23
            goto L_0x0a77
        L_0x0a9b:
            r23 = r0
            r15 = 0
        L_0x0a9e:
            com.blueair.api.restapi.State r15 = (com.blueair.api.restapi.State) r15
            if (r15 == 0) goto L_0x0aa7
            java.lang.Integer r0 = r15.getV()
            goto L_0x0aa8
        L_0x0aa7:
            r0 = 0
        L_0x0aa8:
            java.util.List r1 = r9.getStates()
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r1 = r1.iterator()
        L_0x0ab2:
            boolean r15 = r1.hasNext()
            if (r15 == 0) goto L_0x0ad6
            java.lang.Object r15 = r1.next()
            r21 = r15
            com.blueair.api.restapi.State r21 = (com.blueair.api.restapi.State) r21
            r24 = r0
            java.lang.String r0 = r21.getN()
            r21 = r1
            java.lang.String r1 = "coolautofs3"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            if (r0 == 0) goto L_0x0ad1
            goto L_0x0ad9
        L_0x0ad1:
            r1 = r21
            r0 = r24
            goto L_0x0ab2
        L_0x0ad6:
            r24 = r0
            r15 = 0
        L_0x0ad9:
            com.blueair.api.restapi.State r15 = (com.blueair.api.restapi.State) r15
            if (r15 == 0) goto L_0x0ae2
            java.lang.Integer r0 = r15.getV()
            goto L_0x0ae3
        L_0x0ae2:
            r0 = 0
        L_0x0ae3:
            r1 = 3
            java.lang.Integer[] r1 = new java.lang.Integer[r1]
            r1[r111] = r23
            r1[r112] = r24
            r1[r106] = r0
            java.util.List r0 = kotlin.collections.CollectionsKt.listOfNotNull((T[]) r1)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r1 = new java.util.ArrayList
            r108 = r3
            r15 = 10
            int r3 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r0, r15)
            r1.<init>(r3)
            java.util.Collection r1 = (java.util.Collection) r1
            java.util.Iterator r0 = r0.iterator()
        L_0x0b05:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x0b23
            java.lang.Object r3 = r0.next()
            java.lang.Number r3 = (java.lang.Number) r3
            int r3 = r3.intValue()
            com.blueair.core.model.DeviceData$Companion r15 = com.blueair.core.model.DeviceData.Companion
            double r23 = r15.fromServerValue(r3)
            java.lang.Double r3 = kotlin.coroutines.jvm.internal.Boxing.boxDouble(r23)
            r1.add(r3)
            goto L_0x0b05
        L_0x0b23:
            java.util.List r1 = (java.util.List) r1
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r0 = r1.isEmpty()
            if (r0 == 0) goto L_0x0b2e
            r1 = 0
        L_0x0b2e:
            java.util.List r1 = (java.util.List) r1
            if (r1 == 0) goto L_0x0b3b
            java.util.Collection r1 = (java.util.Collection) r1
            double[] r0 = kotlin.collections.CollectionsKt.toDoubleArray(r1)
            r73 = r0
            goto L_0x0b3d
        L_0x0b3b:
            r73 = 0
        L_0x0b3d:
            java.util.List r0 = r9.getStates()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x0b47:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0b61
            java.lang.Object r1 = r0.next()
            r3 = r1
            com.blueair.api.restapi.State r3 = (com.blueair.api.restapi.State) r3
            java.lang.String r3 = r3.getN()
            java.lang.String r15 = "coolecotag"
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r15)
            if (r3 == 0) goto L_0x0b47
            goto L_0x0b62
        L_0x0b61:
            r1 = 0
        L_0x0b62:
            com.blueair.api.restapi.State r1 = (com.blueair.api.restapi.State) r1
            if (r1 == 0) goto L_0x0b6d
            java.lang.Integer r0 = r1.getV()
            r74 = r0
            goto L_0x0b6f
        L_0x0b6d:
            r74 = 0
        L_0x0b6f:
            java.util.List r0 = r9.getStates()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x0b79:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0b93
            java.lang.Object r1 = r0.next()
            r3 = r1
            com.blueair.api.restapi.State r3 = (com.blueair.api.restapi.State) r3
            java.lang.String r3 = r3.getN()
            java.lang.String r15 = "coolecofs1"
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r15)
            if (r3 == 0) goto L_0x0b79
            goto L_0x0b94
        L_0x0b93:
            r1 = 0
        L_0x0b94:
            com.blueair.api.restapi.State r1 = (com.blueair.api.restapi.State) r1
            if (r1 == 0) goto L_0x0b9d
            java.lang.Integer r0 = r1.getV()
            goto L_0x0b9e
        L_0x0b9d:
            r0 = 0
        L_0x0b9e:
            java.util.List r1 = r9.getStates()
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r1 = r1.iterator()
        L_0x0ba8:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x0bc7
            java.lang.Object r3 = r1.next()
            r15 = r3
            com.blueair.api.restapi.State r15 = (com.blueair.api.restapi.State) r15
            java.lang.String r15 = r15.getN()
            r21 = r0
            java.lang.String r0 = "coolecofs2"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r15, (java.lang.Object) r0)
            if (r0 == 0) goto L_0x0bc4
            goto L_0x0bca
        L_0x0bc4:
            r0 = r21
            goto L_0x0ba8
        L_0x0bc7:
            r21 = r0
            r3 = 0
        L_0x0bca:
            com.blueair.api.restapi.State r3 = (com.blueair.api.restapi.State) r3
            if (r3 == 0) goto L_0x0bd3
            java.lang.Integer r0 = r3.getV()
            goto L_0x0bd4
        L_0x0bd3:
            r0 = 0
        L_0x0bd4:
            r1 = r106
            java.lang.Integer[] r3 = new java.lang.Integer[r1]
            r3[r111] = r21
            r3[r112] = r0
            java.util.List r0 = kotlin.collections.CollectionsKt.listOfNotNull((T[]) r3)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r3 = new java.util.ArrayList
            r15 = 10
            int r1 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r0, r15)
            r3.<init>(r1)
            java.util.Collection r3 = (java.util.Collection) r3
            java.util.Iterator r0 = r0.iterator()
        L_0x0bf3:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0c13
            java.lang.Object r1 = r0.next()
            java.lang.Number r1 = (java.lang.Number) r1
            int r1 = r1.intValue()
            com.blueair.core.model.DeviceData$Companion r15 = com.blueair.core.model.DeviceData.Companion
            double r23 = r15.fromServerValue(r1)
            java.lang.Double r1 = kotlin.coroutines.jvm.internal.Boxing.boxDouble(r23)
            r3.add(r1)
            r15 = 10
            goto L_0x0bf3
        L_0x0c13:
            java.util.List r3 = (java.util.List) r3
            java.util.Collection r3 = (java.util.Collection) r3
            boolean r0 = r3.isEmpty()
            if (r0 == 0) goto L_0x0c1e
            r3 = 0
        L_0x0c1e:
            java.util.List r3 = (java.util.List) r3
            if (r3 == 0) goto L_0x0c2b
            java.util.Collection r3 = (java.util.Collection) r3
            double[] r0 = kotlin.collections.CollectionsKt.toDoubleArray(r3)
            r75 = r0
            goto L_0x0c2d
        L_0x0c2b:
            r75 = 0
        L_0x0c2d:
            java.util.List r0 = r9.getStates()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x0c37:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0c51
            java.lang.Object r1 = r0.next()
            r3 = r1
            com.blueair.api.restapi.State r3 = (com.blueair.api.restapi.State) r3
            java.lang.String r3 = r3.getN()
            java.lang.String r15 = "mode"
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r15)
            if (r3 == 0) goto L_0x0c37
            goto L_0x0c52
        L_0x0c51:
            r1 = 0
        L_0x0c52:
            com.blueair.api.restapi.State r1 = (com.blueair.api.restapi.State) r1
            if (r1 == 0) goto L_0x0c5d
            java.lang.Integer r0 = r1.getV()
            r76 = r0
            goto L_0x0c5f
        L_0x0c5d:
            r76 = 0
        L_0x0c5f:
            java.util.List r0 = r9.getStates()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x0c69:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0c83
            java.lang.Object r1 = r0.next()
            r3 = r1
            com.blueair.api.restapi.State r3 = (com.blueair.api.restapi.State) r3
            java.lang.String r3 = r3.getN()
            java.lang.String r15 = "hummode"
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r15)
            if (r3 == 0) goto L_0x0c69
            goto L_0x0c84
        L_0x0c83:
            r1 = 0
        L_0x0c84:
            com.blueair.api.restapi.State r1 = (com.blueair.api.restapi.State) r1
            if (r1 == 0) goto L_0x0c8f
            java.lang.Boolean r0 = r1.getVb()
            r77 = r0
            goto L_0x0c91
        L_0x0c8f:
            r77 = 0
        L_0x0c91:
            java.util.List r0 = r9.getStates()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x0c9b:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0cb5
            java.lang.Object r1 = r0.next()
            r3 = r1
            com.blueair.api.restapi.State r3 = (com.blueair.api.restapi.State) r3
            java.lang.String r3 = r3.getN()
            java.lang.String r15 = "wlevel"
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r15)
            if (r3 == 0) goto L_0x0c9b
            goto L_0x0cb6
        L_0x0cb5:
            r1 = 0
        L_0x0cb6:
            com.blueair.api.restapi.State r1 = (com.blueair.api.restapi.State) r1
            if (r1 == 0) goto L_0x0cc1
            java.lang.Integer r0 = r1.getV()
            r78 = r0
            goto L_0x0cc3
        L_0x0cc1:
            r78 = 0
        L_0x0cc3:
            java.util.List r0 = r9.getStates()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x0ccd:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0ce7
            java.lang.Object r1 = r0.next()
            r3 = r1
            com.blueair.api.restapi.State r3 = (com.blueair.api.restapi.State) r3
            java.lang.String r3 = r3.getN()
            java.lang.String r15 = "dehsubmode"
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r15)
            if (r3 == 0) goto L_0x0ccd
            goto L_0x0ce8
        L_0x0ce7:
            r1 = 0
        L_0x0ce8:
            com.blueair.api.restapi.State r1 = (com.blueair.api.restapi.State) r1
            if (r1 == 0) goto L_0x0cf3
            java.lang.Integer r0 = r1.getV()
            r79 = r0
            goto L_0x0cf5
        L_0x0cf3:
            r79 = 0
        L_0x0cf5:
            java.util.List r0 = r9.getStates()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x0cff:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0d19
            java.lang.Object r1 = r0.next()
            r3 = r1
            com.blueair.api.restapi.State r3 = (com.blueair.api.restapi.State) r3
            java.lang.String r3 = r3.getN()
            java.lang.String r15 = "watertankfailure"
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r15)
            if (r3 == 0) goto L_0x0cff
            goto L_0x0d1a
        L_0x0d19:
            r1 = 0
        L_0x0d1a:
            com.blueair.api.restapi.State r1 = (com.blueair.api.restapi.State) r1
            if (r1 == 0) goto L_0x0d28
            java.lang.Boolean r0 = r1.getVb()
            if (r0 != 0) goto L_0x0d25
            goto L_0x0d28
        L_0x0d25:
            r80 = r0
            goto L_0x0d58
        L_0x0d28:
            java.util.List r0 = r9.getStates()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x0d32:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0d4c
            java.lang.Object r1 = r0.next()
            r3 = r1
            com.blueair.api.restapi.State r3 = (com.blueair.api.restapi.State) r3
            java.lang.String r3 = r3.getN()
            java.lang.String r15 = "wtankfail"
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r15)
            if (r3 == 0) goto L_0x0d32
            goto L_0x0d4d
        L_0x0d4c:
            r1 = 0
        L_0x0d4d:
            com.blueair.api.restapi.State r1 = (com.blueair.api.restapi.State) r1
            if (r1 == 0) goto L_0x0d56
            java.lang.Boolean r0 = r1.getVb()
            goto L_0x0d25
        L_0x0d56:
            r80 = 0
        L_0x0d58:
            java.util.List r0 = r9.getStates()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x0d62:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0d7c
            java.lang.Object r1 = r0.next()
            r3 = r1
            com.blueair.api.restapi.State r3 = (com.blueair.api.restapi.State) r3
            java.lang.String r3 = r3.getN()
            java.lang.String r15 = "smartsubmode"
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r15)
            if (r3 == 0) goto L_0x0d62
            goto L_0x0d7d
        L_0x0d7c:
            r1 = 0
        L_0x0d7d:
            com.blueair.api.restapi.State r1 = (com.blueair.api.restapi.State) r1
            if (r1 == 0) goto L_0x0d88
            java.lang.Integer r0 = r1.getV()
            r81 = r0
            goto L_0x0d8a
        L_0x0d88:
            r81 = 0
        L_0x0d8a:
            java.util.List r0 = r9.getStates()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x0d94:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0dae
            java.lang.Object r1 = r0.next()
            r3 = r1
            com.blueair.api.restapi.State r3 = (com.blueair.api.restapi.State) r3
            java.lang.String r3 = r3.getN()
            java.lang.String r15 = "detectcat"
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r15)
            if (r3 == 0) goto L_0x0d94
            goto L_0x0daf
        L_0x0dae:
            r1 = 0
        L_0x0daf:
            com.blueair.api.restapi.State r1 = (com.blueair.api.restapi.State) r1
            if (r1 == 0) goto L_0x0dba
            java.lang.Boolean r0 = r1.getVb()
            r82 = r0
            goto L_0x0dbc
        L_0x0dba:
            r82 = 0
        L_0x0dbc:
            java.util.List r0 = r9.getStates()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x0dc6:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0de0
            java.lang.Object r1 = r0.next()
            r3 = r1
            com.blueair.api.restapi.State r3 = (com.blueair.api.restapi.State) r3
            java.lang.String r3 = r3.getN()
            java.lang.String r15 = "bodymounted"
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r15)
            if (r3 == 0) goto L_0x0dc6
            goto L_0x0de1
        L_0x0de0:
            r1 = 0
        L_0x0de1:
            com.blueair.api.restapi.State r1 = (com.blueair.api.restapi.State) r1
            if (r1 == 0) goto L_0x0dec
            java.lang.Boolean r0 = r1.getVb()
            r83 = r0
            goto L_0x0dee
        L_0x0dec:
            r83 = 0
        L_0x0dee:
            java.util.List r0 = r9.getStates()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x0df8:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0e12
            java.lang.Object r1 = r0.next()
            r3 = r1
            com.blueair.api.restapi.State r3 = (com.blueair.api.restapi.State) r3
            java.lang.String r3 = r3.getN()
            java.lang.String r15 = "aireta"
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r15)
            if (r3 == 0) goto L_0x0df8
            goto L_0x0e13
        L_0x0e12:
            r1 = 0
        L_0x0e13:
            com.blueair.api.restapi.State r1 = (com.blueair.api.restapi.State) r1
            if (r1 == 0) goto L_0x0e1e
            java.lang.Integer r0 = r1.getV()
            r84 = r0
            goto L_0x0e20
        L_0x0e1e:
            r84 = 0
        L_0x0e20:
            java.util.List r0 = r9.getStates()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x0e2a:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0e44
            java.lang.Object r1 = r0.next()
            r3 = r1
            com.blueair.api.restapi.State r3 = (com.blueair.api.restapi.State) r3
            java.lang.String r3 = r3.getN()
            java.lang.String r15 = "displaymode"
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r15)
            if (r3 == 0) goto L_0x0e2a
            goto L_0x0e45
        L_0x0e44:
            r1 = 0
        L_0x0e45:
            com.blueair.api.restapi.State r1 = (com.blueair.api.restapi.State) r1
            if (r1 == 0) goto L_0x0e50
            java.lang.Integer r0 = r1.getV()
            r85 = r0
            goto L_0x0e52
        L_0x0e50:
            r85 = 0
        L_0x0e52:
            java.util.List r0 = r9.getStates()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x0e5c:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0e76
            java.lang.Object r1 = r0.next()
            r3 = r1
            com.blueair.api.restapi.State r3 = (com.blueair.api.restapi.State) r3
            java.lang.String r3 = r3.getN()
            java.lang.String r15 = "hover"
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r15)
            if (r3 == 0) goto L_0x0e5c
            goto L_0x0e77
        L_0x0e76:
            r1 = 0
        L_0x0e77:
            com.blueair.api.restapi.State r1 = (com.blueair.api.restapi.State) r1
            if (r1 == 0) goto L_0x0e82
            java.lang.Boolean r0 = r1.getVb()
            r86 = r0
            goto L_0x0e84
        L_0x0e82:
            r86 = 0
        L_0x0e84:
            java.util.List r0 = r9.getStates()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x0e8e:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0ea8
            java.lang.Object r1 = r0.next()
            r3 = r1
            com.blueair.api.restapi.State r3 = (com.blueair.api.restapi.State) r3
            java.lang.String r3 = r3.getN()
            java.lang.String r15 = "airrefresh"
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r15)
            if (r3 == 0) goto L_0x0e8e
            goto L_0x0ea9
        L_0x0ea8:
            r1 = 0
        L_0x0ea9:
            com.blueair.api.restapi.State r1 = (com.blueair.api.restapi.State) r1
            if (r1 == 0) goto L_0x0eb4
            java.lang.Boolean r0 = r1.getVb()
            r87 = r0
            goto L_0x0eb6
        L_0x0eb4:
            r87 = 0
        L_0x0eb6:
            java.util.List r0 = r9.getStates()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x0ec0:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0eda
            java.lang.Object r1 = r0.next()
            r3 = r1
            com.blueair.api.restapi.State r3 = (com.blueair.api.restapi.State) r3
            java.lang.String r3 = r3.getN()
            java.lang.String r15 = "arstate"
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r15)
            if (r3 == 0) goto L_0x0ec0
            goto L_0x0edb
        L_0x0eda:
            r1 = 0
        L_0x0edb:
            com.blueair.api.restapi.State r1 = (com.blueair.api.restapi.State) r1
            if (r1 == 0) goto L_0x0ee6
            java.lang.Integer r0 = r1.getV()
            r88 = r0
            goto L_0x0ee8
        L_0x0ee6:
            r88 = 0
        L_0x0ee8:
            java.util.List r0 = r9.getStates()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x0ef2:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0f0c
            java.lang.Object r1 = r0.next()
            r3 = r1
            com.blueair.api.restapi.State r3 = (com.blueair.api.restapi.State) r3
            java.lang.String r3 = r3.getN()
            java.lang.String r15 = "ardur"
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r15)
            if (r3 == 0) goto L_0x0ef2
            goto L_0x0f0d
        L_0x0f0c:
            r1 = 0
        L_0x0f0d:
            com.blueair.api.restapi.State r1 = (com.blueair.api.restapi.State) r1
            if (r1 == 0) goto L_0x0f18
            java.lang.Integer r0 = r1.getV()
            r89 = r0
            goto L_0x0f1a
        L_0x0f18:
            r89 = 0
        L_0x0f1a:
            java.util.List r0 = r9.getStates()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x0f24:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0f3e
            java.lang.Object r1 = r0.next()
            r3 = r1
            com.blueair.api.restapi.State r3 = (com.blueair.api.restapi.State) r3
            java.lang.String r3 = r3.getN()
            java.lang.String r15 = "arts"
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r15)
            if (r3 == 0) goto L_0x0f24
            goto L_0x0f3f
        L_0x0f3e:
            r1 = 0
        L_0x0f3f:
            com.blueair.api.restapi.State r1 = (com.blueair.api.restapi.State) r1
            if (r1 == 0) goto L_0x0f4a
            java.lang.Integer r0 = r1.getV()
            r90 = r0
            goto L_0x0f4c
        L_0x0f4a:
            r90 = 0
        L_0x0f4c:
            java.util.List r0 = r9.getStates()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x0f56:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0f70
            java.lang.Object r1 = r0.next()
            r3 = r1
            com.blueair.api.restapi.State r3 = (com.blueair.api.restapi.State) r3
            java.lang.String r3 = r3.getN()
            java.lang.String r15 = "startts"
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r15)
            if (r3 == 0) goto L_0x0f56
            goto L_0x0f71
        L_0x0f70:
            r1 = 0
        L_0x0f71:
            com.blueair.api.restapi.State r1 = (com.blueair.api.restapi.State) r1
            if (r1 == 0) goto L_0x0f7c
            java.lang.Integer r0 = r1.getV()
            r91 = r0
            goto L_0x0f7e
        L_0x0f7c:
            r91 = 0
        L_0x0f7e:
            java.util.List r0 = r9.getStates()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x0f88:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0fa2
            java.lang.Object r1 = r0.next()
            r3 = r1
            com.blueair.api.restapi.State r3 = (com.blueair.api.restapi.State) r3
            java.lang.String r3 = r3.getN()
            java.lang.String r15 = "endts"
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r15)
            if (r3 == 0) goto L_0x0f88
            goto L_0x0fa3
        L_0x0fa2:
            r1 = 0
        L_0x0fa3:
            com.blueair.api.restapi.State r1 = (com.blueair.api.restapi.State) r1
            if (r1 == 0) goto L_0x0fae
            java.lang.Integer r0 = r1.getV()
            r92 = r0
            goto L_0x0fb0
        L_0x0fae:
            r92 = 0
        L_0x0fb0:
            java.util.List r0 = r9.getStates()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x0fba:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0fd4
            java.lang.Object r1 = r0.next()
            r3 = r1
            com.blueair.api.restapi.State r3 = (com.blueair.api.restapi.State) r3
            java.lang.String r3 = r3.getN()
            java.lang.String r15 = "roomtype"
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r15)
            if (r3 == 0) goto L_0x0fba
            goto L_0x0fd5
        L_0x0fd4:
            r1 = 0
        L_0x0fd5:
            com.blueair.api.restapi.State r1 = (com.blueair.api.restapi.State) r1
            if (r1 == 0) goto L_0x0fe0
            java.lang.Integer r0 = r1.getV()
            r93 = r0
            goto L_0x0fe2
        L_0x0fe0:
            r93 = 0
        L_0x0fe2:
            java.util.List r0 = r9.getStates()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x0fec:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x1006
            java.lang.Object r1 = r0.next()
            r3 = r1
            com.blueair.api.restapi.State r3 = (com.blueair.api.restapi.State) r3
            java.lang.String r3 = r3.getN()
            java.lang.String r15 = "nlbrightness"
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r15)
            if (r3 == 0) goto L_0x0fec
            goto L_0x1007
        L_0x1006:
            r1 = 0
        L_0x1007:
            com.blueair.api.restapi.State r1 = (com.blueair.api.restapi.State) r1
            if (r1 == 0) goto L_0x1012
            java.lang.Integer r0 = r1.getV()
            r94 = r0
            goto L_0x1014
        L_0x1012:
            r94 = 0
        L_0x1014:
            java.util.List r0 = r9.getStates()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x101e:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x1038
            java.lang.Object r1 = r0.next()
            r3 = r1
            com.blueair.api.restapi.State r3 = (com.blueair.api.restapi.State) r3
            java.lang.String r3 = r3.getN()
            java.lang.String r15 = "nlstepless"
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r15)
            if (r3 == 0) goto L_0x101e
            goto L_0x1039
        L_0x1038:
            r1 = 0
        L_0x1039:
            com.blueair.api.restapi.State r1 = (com.blueair.api.restapi.State) r1
            if (r1 == 0) goto L_0x1044
            java.lang.Integer r0 = r1.getV()
            r95 = r0
            goto L_0x1046
        L_0x1044:
            r95 = 0
        L_0x1046:
            java.util.List r0 = r9.getStates()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x1050:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x106a
            java.lang.Object r1 = r0.next()
            r3 = r1
            com.blueair.api.restapi.State r3 = (com.blueair.api.restapi.State) r3
            java.lang.String r3 = r3.getN()
            java.lang.String r15 = "wickdrydur"
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r15)
            if (r3 == 0) goto L_0x1050
            goto L_0x106b
        L_0x106a:
            r1 = 0
        L_0x106b:
            com.blueair.api.restapi.State r1 = (com.blueair.api.restapi.State) r1
            if (r1 == 0) goto L_0x1076
            java.lang.Integer r0 = r1.getV()
            r96 = r0
            goto L_0x1078
        L_0x1076:
            r96 = 0
        L_0x1078:
            java.util.List r0 = r9.getStates()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x1082:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x109c
            java.lang.Object r1 = r0.next()
            r3 = r1
            com.blueair.api.restapi.State r3 = (com.blueair.api.restapi.State) r3
            java.lang.String r3 = r3.getN()
            java.lang.String r15 = "wickdrydone"
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r15)
            if (r3 == 0) goto L_0x1082
            goto L_0x109d
        L_0x109c:
            r1 = 0
        L_0x109d:
            com.blueair.api.restapi.State r1 = (com.blueair.api.restapi.State) r1
            if (r1 == 0) goto L_0x10a8
            java.lang.Boolean r0 = r1.getVb()
            r97 = r0
            goto L_0x10aa
        L_0x10a8:
            r97 = 0
        L_0x10aa:
            com.blueair.api.restapi.Configuration r0 = r9.getConfiguration()
            com.blueair.api.restapi.ConfigurationDeviceInfo r0 = r0.getDeviceInfo()
            if (r0 == 0) goto L_0x10bb
            java.lang.Boolean r0 = r0.getYwrmEnable()
            r98 = r0
            goto L_0x10bd
        L_0x10bb:
            r98 = 0
        L_0x10bd:
            java.util.List r0 = r9.getStates()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x10c7:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x10e1
            java.lang.Object r1 = r0.next()
            r3 = r1
            com.blueair.api.restapi.State r3 = (com.blueair.api.restapi.State) r3
            java.lang.String r3 = r3.getN()
            java.lang.String r15 = "ywrmusage"
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r15)
            if (r3 == 0) goto L_0x10c7
            goto L_0x10e2
        L_0x10e1:
            r1 = 0
        L_0x10e2:
            com.blueair.api.restapi.State r1 = (com.blueair.api.restapi.State) r1
            if (r1 == 0) goto L_0x10ed
            java.lang.Integer r0 = r1.getV()
            r99 = r0
            goto L_0x10ef
        L_0x10ed:
            r99 = 0
        L_0x10ef:
            java.util.List r0 = r9.getStates()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x10f9:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x1113
            java.lang.Object r1 = r0.next()
            r3 = r1
            com.blueair.api.restapi.State r3 = (com.blueair.api.restapi.State) r3
            java.lang.String r3 = r3.getN()
            java.lang.String r15 = "humsubmode"
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r15)
            if (r3 == 0) goto L_0x10f9
            goto L_0x1114
        L_0x1113:
            r1 = 0
        L_0x1114:
            com.blueair.api.restapi.State r1 = (com.blueair.api.restapi.State) r1
            if (r1 == 0) goto L_0x111f
            java.lang.Integer r0 = r1.getV()
            r101 = r0
            goto L_0x1121
        L_0x111f:
            r101 = 0
        L_0x1121:
            java.util.List r0 = r9.getStates()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x112b:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x1145
            java.lang.Object r1 = r0.next()
            r3 = r1
            com.blueair.api.restapi.State r3 = (com.blueair.api.restapi.State) r3
            java.lang.String r3 = r3.getN()
            java.lang.String r15 = "hourformat"
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r15)
            if (r3 == 0) goto L_0x112b
            goto L_0x1146
        L_0x1145:
            r1 = 0
        L_0x1146:
            com.blueair.api.restapi.State r1 = (com.blueair.api.restapi.State) r1
            if (r1 == 0) goto L_0x1151
            java.lang.Boolean r0 = r1.getVb()
            r102 = r0
            goto L_0x1153
        L_0x1151:
            r102 = 0
        L_0x1153:
            java.util.List r0 = r9.getStates()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x115d:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x1177
            java.lang.Object r1 = r0.next()
            r3 = r1
            com.blueair.api.restapi.State r3 = (com.blueair.api.restapi.State) r3
            java.lang.String r3 = r3.getN()
            java.lang.String r15 = "waterinfill"
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r15)
            if (r3 == 0) goto L_0x115d
            goto L_0x1178
        L_0x1177:
            r1 = 0
        L_0x1178:
            com.blueair.api.restapi.State r1 = (com.blueair.api.restapi.State) r1
            if (r1 == 0) goto L_0x1183
            java.lang.Boolean r0 = r1.getVb()
            r103 = r0
            goto L_0x1185
        L_0x1183:
            r103 = 0
        L_0x1185:
            java.util.List r0 = r9.getStates()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x118f:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x11a9
            java.lang.Object r1 = r0.next()
            r3 = r1
            com.blueair.api.restapi.State r3 = (com.blueair.api.restapi.State) r3
            java.lang.String r3 = r3.getN()
            java.lang.String r15 = "sensormode"
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r15)
            if (r3 == 0) goto L_0x118f
            goto L_0x11aa
        L_0x11a9:
            r1 = 0
        L_0x11aa:
            com.blueair.api.restapi.State r1 = (com.blueair.api.restapi.State) r1
            if (r1 == 0) goto L_0x11b5
            java.lang.Integer r0 = r1.getV()
            r104 = r0
            goto L_0x11b7
        L_0x11b5:
            r104 = 0
        L_0x11b7:
            java.util.List r0 = r9.getSensordata()
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto L_0x11c3
            r1 = 0
            goto L_0x11c8
        L_0x11c3:
            com.blueair.core.model.IndoorDatapoint r0 = com.blueair.api.model.SensorDataKt.toIndoorDatapoint(r0)
            r1 = r0
        L_0x11c8:
            r3 = r111
            double[] r0 = new double[r3]
            double[] r15 = new double[r3]
            r21 = r0
            double[] r0 = new double[r3]
            r23 = r0
            double[] r0 = new double[r3]
            r24 = r0
            double[] r0 = new double[r3]
            com.blueair.api.restapi.Configuration r3 = r9.getConfiguration()
            com.blueair.api.restapi.ConfigurationDeviceInfo r3 = r3.getDeviceInfo()
            if (r3 == 0) goto L_0x124f
            java.lang.String r3 = r3.getSensorRanges()
            if (r3 == 0) goto L_0x124f
            r25 = r0
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>(r3)
            java.util.Iterator r3 = r0.keys()
            r26 = r1
            java.lang.String r1 = "keys(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r1)
            kotlin.sequences.Sequence r1 = kotlin.sequences.SequencesKt.asSequence(r3)
            java.util.List r1 = kotlin.sequences.SequencesKt.toList(r1)
            java.lang.String r3 = "pm1"
            double[] r3 = initialSetupCall$lambda$97$lambda$90$parseArray(r1, r0, r3)
            if (r3 == 0) goto L_0x1210
            kotlin.Unit r21 = kotlin.Unit.INSTANCE
            r21 = r3
        L_0x1210:
            java.lang.String r3 = "pm25"
            double[] r3 = initialSetupCall$lambda$97$lambda$90$parseArray(r1, r0, r3)
            if (r3 == 0) goto L_0x121c
            kotlin.Unit r23 = kotlin.Unit.INSTANCE
            r23 = r3
        L_0x121c:
            java.lang.String r3 = "pm10"
            double[] r3 = initialSetupCall$lambda$97$lambda$90$parseArray(r1, r0, r3)
            if (r3 == 0) goto L_0x1227
            kotlin.Unit r15 = kotlin.Unit.INSTANCE
            r15 = r3
        L_0x1227:
            java.lang.String r3 = "tvoc"
            double[] r3 = initialSetupCall$lambda$97$lambda$90$parseArray(r1, r0, r3)
            if (r3 == 0) goto L_0x1233
            kotlin.Unit r24 = kotlin.Unit.INSTANCE
            r24 = r3
        L_0x1233:
            java.lang.String r3 = "hcho"
            double[] r0 = initialSetupCall$lambda$97$lambda$90$parseArray(r1, r0, r3)
            if (r0 == 0) goto L_0x123e
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            goto L_0x1240
        L_0x123e:
            r0 = r25
        L_0x1240:
            r27 = r0
            r1 = r17
            r25 = r23
            r17 = r26
            r23 = r21
            r26 = r24
            r24 = r15
            goto L_0x1261
        L_0x124f:
            r25 = r0
            r26 = r1
            r27 = r25
            r1 = r17
            r17 = r26
            r25 = r23
            r26 = r24
            r24 = r15
            r23 = r21
        L_0x1261:
            r3 = r112
            r100 = 0
        L_0x1265:
            r0 = 7
            if (r3 >= r0) goto L_0x1310
            java.util.List r0 = r9.getStates()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x1272:
            boolean r15 = r0.hasNext()
            if (r15 == 0) goto L_0x12a6
            java.lang.Object r15 = r0.next()
            r21 = r15
            com.blueair.api.restapi.State r21 = (com.blueair.api.restapi.State) r21
            r28 = r0
            java.lang.String r0 = r21.getN()
            r21 = r1
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r29 = r4
            java.lang.String r4 = "alarm"
            r1.<init>(r4)
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            if (r0 == 0) goto L_0x129f
            goto L_0x12ab
        L_0x129f:
            r1 = r21
            r0 = r28
            r4 = r29
            goto L_0x1272
        L_0x12a6:
            r21 = r1
            r29 = r4
            r15 = 0
        L_0x12ab:
            com.blueair.api.restapi.State r15 = (com.blueair.api.restapi.State) r15
            if (r15 != 0) goto L_0x12b0
            goto L_0x1314
        L_0x12b0:
            java.lang.Object r0 = r15.getVj()
            if (r0 == 0) goto L_0x12e4
            kotlin.Result$Companion r1 = kotlin.Result.Companion     // Catch:{ all -> 0x12cf }
            boolean r1 = r0 instanceof java.util.Map     // Catch:{ all -> 0x12cf }
            if (r1 == 0) goto L_0x12c9
            com.blueair.core.util.MoshiSerializer r1 = r110.getAlarmSerializer()     // Catch:{ all -> 0x12cf }
            java.util.Map r0 = (java.util.Map) r0     // Catch:{ all -> 0x12cf }
            java.lang.Object r0 = r1.fromMap(r0)     // Catch:{ all -> 0x12cf }
            com.blueair.core.model.DeviceAlarm r0 = (com.blueair.core.model.DeviceAlarm) r0     // Catch:{ all -> 0x12cf }
            goto L_0x12ca
        L_0x12c9:
            r0 = 0
        L_0x12ca:
            java.lang.Object r0 = kotlin.Result.m9366constructorimpl(r0)     // Catch:{ all -> 0x12cf }
            goto L_0x12da
        L_0x12cf:
            r0 = move-exception
            kotlin.Result$Companion r1 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            java.lang.Object r0 = kotlin.Result.m9366constructorimpl(r0)
        L_0x12da:
            boolean r1 = kotlin.Result.m9372isFailureimpl(r0)
            if (r1 == 0) goto L_0x12e1
            r0 = 0
        L_0x12e1:
            com.blueair.core.model.DeviceAlarm r0 = (com.blueair.core.model.DeviceAlarm) r0
            goto L_0x12e5
        L_0x12e4:
            r0 = 0
        L_0x12e5:
            if (r100 != 0) goto L_0x12fe
            java.util.ArrayList r1 = new java.util.ArrayList
            r4 = 6
            r1.<init>(r4)
            r15 = 0
        L_0x12ee:
            if (r15 >= r4) goto L_0x12f8
            r4 = 0
            r1.add(r4)
            int r15 = r15 + 1
            r4 = 6
            goto L_0x12ee
        L_0x12f8:
            r4 = 0
            r100 = r1
            java.util.List r100 = (java.util.List) r100
            goto L_0x12ff
        L_0x12fe:
            r4 = 0
        L_0x12ff:
            r1 = r100
            int r15 = r3 + -1
            r1.set(r15, r0)
            int r3 = r3 + 1
            r100 = r1
            r1 = r21
            r4 = r29
            goto L_0x1265
        L_0x1310:
            r21 = r1
            r29 = r4
        L_0x1314:
            r4 = 0
            java.util.List r0 = r9.getStates()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x131f:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x1339
            java.lang.Object r1 = r0.next()
            r3 = r1
            com.blueair.api.restapi.State r3 = (com.blueair.api.restapi.State) r3
            java.lang.String r3 = r3.getN()
            java.lang.String r15 = "online"
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r15)
            if (r3 == 0) goto L_0x131f
            goto L_0x133a
        L_0x1339:
            r1 = r4
        L_0x133a:
            com.blueair.api.restapi.State r1 = (com.blueair.api.restapi.State) r1
            if (r1 == 0) goto L_0x1343
            java.lang.Boolean r0 = r1.getVb()
            goto L_0x1344
        L_0x1343:
            r0 = r4
        L_0x1344:
            java.lang.Boolean r1 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r112)
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            if (r1 == 0) goto L_0x1359
            com.blueair.core.model.ConnectivityStatus r0 = com.blueair.core.model.ConnectivityStatus.ONLINE
            int r0 = r0.ordinal()
            java.lang.Integer r0 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r0)
            goto L_0x1370
        L_0x1359:
            r3 = 0
            java.lang.Boolean r1 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            if (r0 == 0) goto L_0x136f
            com.blueair.core.model.ConnectivityStatus r0 = com.blueair.core.model.ConnectivityStatus.OFFLINE
            int r0 = r0.ordinal()
            java.lang.Integer r0 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r0)
            goto L_0x1370
        L_0x136f:
            r0 = r4
        L_0x1370:
            com.blueair.api.restapi.Configuration r1 = r9.getConfiguration()
            com.blueair.api.restapi.Da r1 = r1.getDa()
            if (r1 == 0) goto L_0x1387
            com.blueair.api.restapi.ConfigurationAutoMode r1 = r1.getNightMode()
            if (r1 == 0) goto L_0x1387
            java.lang.String r1 = r1.getNightModeTrigger()
            r38 = r1
            goto L_0x1389
        L_0x1387:
            r38 = r4
        L_0x1389:
            com.blueair.api.restapi.Configuration r1 = r9.getConfiguration()
            com.blueair.api.restapi.Da r1 = r1.getDa()
            if (r1 == 0) goto L_0x13a0
            com.blueair.api.restapi.ConfigurationAutoMode r1 = r1.getAutoMode()
            if (r1 == 0) goto L_0x13a0
            java.lang.String r1 = r1.getAutoModeTrigger()
            r37 = r1
            goto L_0x13a2
        L_0x13a0:
            r37 = r4
        L_0x13a2:
            r1 = r11
            java.lang.String r11 = r9.getId()
            com.blueair.api.restapi.Configuration r3 = r9.getConfiguration()
            com.blueair.api.restapi.ConfigurationDeviceInfo r3 = r3.getDeviceInfo()
            if (r3 == 0) goto L_0x13b6
            java.lang.String r3 = r3.getType()
            goto L_0x13b7
        L_0x13b6:
            r3 = r4
        L_0x13b7:
            com.blueair.api.restapi.Configuration r15 = r9.getConfiguration()
            com.blueair.api.restapi.ConfigurationDeviceInfo r15 = r15.getDeviceInfo()
            if (r15 == 0) goto L_0x13c6
            java.lang.String r15 = r15.getMcuFirmware()
            goto L_0x13c7
        L_0x13c6:
            r15 = r4
        L_0x13c7:
            com.blueair.api.restapi.Configuration r28 = r9.getConfiguration()
            com.blueair.api.restapi.ConfigurationDeviceInfo r28 = r28.getDeviceInfo()
            if (r28 == 0) goto L_0x13d6
            java.lang.String r28 = r28.getWifiFirmware()
            goto L_0x13d8
        L_0x13d6:
            r28 = r4
        L_0x13d8:
            com.blueair.api.restapi.Configuration r30 = r9.getConfiguration()
            com.blueair.api.restapi.ConfigurationDeviceInfo r30 = r30.getDeviceInfo()
            if (r30 == 0) goto L_0x13e7
            java.lang.String r30 = r30.getHardware()
            goto L_0x13e9
        L_0x13e7:
            r30 = r4
        L_0x13e9:
            if (r10 == 0) goto L_0x13f4
            boolean r10 = r10.booleanValue()
            r105 = r20
            r20 = r10
            goto L_0x13f8
        L_0x13f4:
            r105 = r20
            r20 = 0
        L_0x13f8:
            if (r1 == 0) goto L_0x1405
            boolean r1 = r1.booleanValue()
            r109 = r21
            r21 = r1
            r1 = r109
            goto L_0x1409
        L_0x1405:
            r1 = r21
            r21 = 0
        L_0x1409:
            if (r12 == 0) goto L_0x1417
            boolean r10 = r12.booleanValue()
            r109 = r28
            r28 = r10
            r10 = r14
            r14 = r109
            goto L_0x141c
        L_0x1417:
            r10 = r14
            r14 = r28
            r28 = 0
        L_0x141c:
            if (r13 == 0) goto L_0x1429
            boolean r12 = r13.booleanValue()
            r109 = r29
            r29 = r12
            r12 = r109
            goto L_0x142d
        L_0x1429:
            r12 = r29
            r29 = 0
        L_0x142d:
            if (r7 == 0) goto L_0x1439
            boolean r7 = r7.booleanValue()
            r13 = r15
            r15 = r30
            r30 = r7
            goto L_0x143e
        L_0x1439:
            r13 = r15
            r15 = r30
            r30 = 0
        L_0x143e:
            if (r8 == 0) goto L_0x1447
            boolean r7 = r8.booleanValue()
            r31 = r7
            goto L_0x1449
        L_0x1447:
            r31 = 0
        L_0x1449:
            if (r12 == 0) goto L_0x1452
            boolean r7 = r12.booleanValue()
            r32 = r7
            goto L_0x1454
        L_0x1452:
            r32 = 0
        L_0x1454:
            if (r5 == 0) goto L_0x145d
            boolean r5 = r5.booleanValue()
            r33 = r5
            goto L_0x145f
        L_0x145d:
            r33 = 0
        L_0x145f:
            com.blueair.api.restapi.Configuration r5 = r9.getConfiguration()
            com.blueair.api.restapi.ConfigurationDeviceInfo r5 = r5.getDeviceInfo()
            if (r5 == 0) goto L_0x1470
            java.lang.String r5 = r5.getSerialNumber()
            r35 = r5
            goto L_0x1472
        L_0x1470:
            r35 = r4
        L_0x1472:
            com.blueair.api.restapi.Configuration r5 = r9.getConfiguration()
            com.blueair.api.restapi.ConfigurationDeviceInfo r5 = r5.getDeviceInfo()
            if (r5 == 0) goto L_0x1483
            java.lang.String r5 = r5.getName()
            r36 = r5
            goto L_0x1485
        L_0x1483:
            r36 = r4
        L_0x1485:
            if (r6 == 0) goto L_0x148e
            boolean r5 = r6.booleanValue()
            r39 = r5
            goto L_0x1490
        L_0x148e:
            r39 = 0
        L_0x1490:
            com.blueair.api.restapi.Configuration r5 = r9.getConfiguration()
            com.blueair.api.restapi.ConfigurationDeviceInfo r5 = r5.getDeviceInfo()
            if (r5 == 0) goto L_0x14a1
            java.lang.String r5 = r5.getMacAddress()
            r40 = r5
            goto L_0x14a3
        L_0x14a1:
            r40 = r4
        L_0x14a3:
            com.blueair.core.model.WelcomeHomeLocation$Companion r5 = com.blueair.core.model.WelcomeHomeLocation.Companion
            com.blueair.core.model.BlueCloudHomeLocationReceive r6 = r9.getWelcomehome()
            com.blueair.core.model.WelcomeHomeLocation r41 = r5.fromBlueWelcomeHomeLocation(r6)
            java.lang.String r42 = r9.getLocation_id()
            java.lang.String r46 = r9.getTimezone()
            if (r10 == 0) goto L_0x14c3
            int r5 = r10.intValue()
            long r5 = (long) r5
            java.lang.Long r5 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r5)
            r50 = r5
            goto L_0x14c5
        L_0x14c3:
            r50 = r4
        L_0x14c5:
            if (r16 == 0) goto L_0x14d3
            int r5 = r16.intValue()
            long r5 = (long) r5
            java.lang.Long r5 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r5)
            r57 = r5
            goto L_0x14d5
        L_0x14d3:
            r57 = r4
        L_0x14d5:
            if (r1 == 0) goto L_0x14ea
            java.lang.Number r1 = (java.lang.Number) r1
            int r1 = r1.intValue()
            com.blueair.core.model.DeviceData$Companion r5 = com.blueair.core.model.DeviceData.Companion
            double r5 = r5.fromServerValue(r1)
            java.lang.Double r1 = kotlin.coroutines.jvm.internal.Boxing.boxDouble(r5)
            r68 = r1
            goto L_0x14ec
        L_0x14ea:
            r68 = r4
        L_0x14ec:
            if (r105 == 0) goto L_0x1503
            r1 = r105
            java.lang.Number r1 = (java.lang.Number) r1
            int r1 = r1.intValue()
            com.blueair.core.model.DeviceData$Companion r5 = com.blueair.core.model.DeviceData.Companion
            double r5 = r5.fromServerValue(r1)
            java.lang.Double r1 = kotlin.coroutines.jvm.internal.Boxing.boxDouble(r5)
            r69 = r1
            goto L_0x1505
        L_0x1503:
            r69 = r4
        L_0x1505:
            com.blueair.api.client.UserDevicesBlueClient$DeviceDataOnBlue r10 = new com.blueair.api.client.UserDevicesBlueClient$DeviceDataOnBlue
            r16 = r0
            r12 = r3
            r107 = 10
            r10.<init>(r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r64, r65, r66, r67, r68, r69, r70, r71, r72, r73, r74, r75, r76, r77, r78, r79, r80, r81, r82, r83, r84, r85, r86, r87, r88, r89, r90, r91, r92, r93, r94, r95, r96, r97, r98, r99, r100, r101, r102, r103, r104)
            r2.add(r10)
            r1 = r110
            r7 = r112
            r8 = r4
            r6 = r107
            r3 = r108
            r5 = 2
            goto L_0x0150
        L_0x151e:
            java.util.List r2 = (java.util.List) r2
            timber.log.Timber$Forest r0 = timber.log.Timber.Forest
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r3 = "WH DEVICES: "
            r1.<init>(r3)
            r4 = r2
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.lang.String r3 = "=\n="
            r5 = r3
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r11 = 62
            r12 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            java.lang.String r3 = kotlin.collections.CollectionsKt.joinToString$default(r4, r5, r6, r7, r8, r9, r10, r11, r12)
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            r3 = 0
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r0.d(r1, r3)
            io.flatcircle.coroutinehelper.ApiResult$Companion r0 = io.flatcircle.coroutinehelper.ApiResult.Companion
            io.flatcircle.coroutinehelper.ApiResult r0 = r0.success(r2)
            return r0
        L_0x1551:
            io.flatcircle.coroutinehelper.ApiResult$Companion r1 = io.flatcircle.coroutinehelper.ApiResult.Companion
            java.util.List r2 = kotlin.collections.CollectionsKt.emptyList()
            io.flatcircle.coroutinehelper.ApiResult r0 = r1.fromResult(r0, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.client.UserDevicesBlueClient.initialSetupCall(java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final double[] initialSetupCall$lambda$97$lambda$90$parseArray(List<String> list, JSONObject jSONObject, String str) {
        Object obj;
        try {
            Iterator it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                String str2 = (String) obj;
                Intrinsics.checkNotNull(str2);
                String lowerCase = str2.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                if (Intrinsics.areEqual((Object) lowerCase, (Object) str)) {
                    break;
                }
            }
            String str3 = (String) obj;
            if (str3 != null) {
                str = str3;
            }
            JSONArray jSONArray = jSONObject.getJSONArray(str);
            if (jSONObject.length() > 0) {
                int length = jSONArray.length();
                double[] dArr = new double[length];
                for (int i = 0; i < length; i++) {
                    dArr[i] = jSONArray.getDouble(i);
                }
                return dArr;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x009b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getAlexaRedirectUrl(java.lang.String r13, java.lang.String r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, boolean r18, kotlin.coroutines.Continuation<? super java.lang.String> r19) {
        /*
            r12 = this;
            r0 = r19
            boolean r1 = r0 instanceof com.blueair.api.client.UserDevicesBlueClient$getAlexaRedirectUrl$1
            if (r1 == 0) goto L_0x0016
            r1 = r0
            com.blueair.api.client.UserDevicesBlueClient$getAlexaRedirectUrl$1 r1 = (com.blueair.api.client.UserDevicesBlueClient$getAlexaRedirectUrl$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0016
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            goto L_0x001b
        L_0x0016:
            com.blueair.api.client.UserDevicesBlueClient$getAlexaRedirectUrl$1 r1 = new com.blueair.api.client.UserDevicesBlueClient$getAlexaRedirectUrl$1
            r1.<init>(r12, r0)
        L_0x001b:
            java.lang.Object r0 = r1.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r1.label
            r4 = 1
            if (r3 == 0) goto L_0x004a
            if (r3 != r4) goto L_0x0042
            boolean r13 = r1.Z$0
            java.lang.Object r13 = r1.L$4
            java.lang.String r13 = (java.lang.String) r13
            java.lang.Object r13 = r1.L$3
            java.lang.String r13 = (java.lang.String) r13
            java.lang.Object r13 = r1.L$2
            java.lang.String r13 = (java.lang.String) r13
            java.lang.Object r13 = r1.L$1
            java.lang.String r13 = (java.lang.String) r13
            java.lang.Object r13 = r1.L$0
            java.lang.String r13 = (java.lang.String) r13
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x008c
        L_0x0042:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L_0x004a:
            kotlin.ResultKt.throwOnFailure(r0)
            com.blueair.api.restapi.UserDevicesRestApi r0 = r12.getUserDevicesRestApi()
            com.blueair.api.restapi.AlexaLinkAppReq r5 = new com.blueair.api.restapi.AlexaLinkAppReq
            r6 = r13
            r7 = r14
            r8 = r15
            r9 = r16
            r10 = r17
            r11 = r18
            r5.<init>(r6, r7, r8, r9, r10, r11)
            kotlinx.coroutines.Deferred r0 = r0.getAlexaRedirectUrl(r5)
            java.lang.Object r13 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r13)
            r1.L$0 = r13
            java.lang.Object r13 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r1.L$1 = r13
            java.lang.Object r13 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r1.L$2 = r13
            java.lang.Object r13 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r16)
            r1.L$3 = r13
            java.lang.Object r13 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r17)
            r1.L$4 = r13
            r1.Z$0 = r11
            r1.label = r4
            java.lang.Object r0 = r12.awaitCall(r0, r1)
            if (r0 != r2) goto L_0x008c
            return r2
        L_0x008c:
            io.flatcircle.coroutinehelper.ApiResult r0 = (io.flatcircle.coroutinehelper.ApiResult) r0
            java.lang.Object r13 = r0.getOrNull()
            com.blueair.api.restapi.UrlResponse r13 = (com.blueair.api.restapi.UrlResponse) r13
            if (r13 == 0) goto L_0x009b
            java.lang.String r13 = r13.getUrl()
            return r13
        L_0x009b:
            r13 = 0
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.client.UserDevicesBlueClient.getAlexaRedirectUrl(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0071 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getAlexaLinkingUrls(java.lang.String r5, java.lang.String r6, kotlin.coroutines.Continuation<? super kotlin.Pair<java.lang.String, java.lang.String>> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.blueair.api.client.UserDevicesBlueClient$getAlexaLinkingUrls$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            com.blueair.api.client.UserDevicesBlueClient$getAlexaLinkingUrls$1 r0 = (com.blueair.api.client.UserDevicesBlueClient$getAlexaLinkingUrls$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            com.blueair.api.client.UserDevicesBlueClient$getAlexaLinkingUrls$1 r0 = new com.blueair.api.client.UserDevicesBlueClient$getAlexaLinkingUrls$1
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
            goto L_0x005a
        L_0x0032:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x003a:
            kotlin.ResultKt.throwOnFailure(r7)
            com.blueair.api.restapi.UserDevicesRestApi r7 = r4.getUserDevicesRestApi()
            kotlinx.coroutines.Deferred r7 = r7.getAlexaUrls(r5, r6)
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r5)
            r0.L$0 = r5
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r7 = r4.awaitCall(r7, r0)
            if (r7 != r1) goto L_0x005a
            return r1
        L_0x005a:
            io.flatcircle.coroutinehelper.ApiResult r7 = (io.flatcircle.coroutinehelper.ApiResult) r7
            java.lang.Object r5 = r7.getOrNull()
            com.blueair.api.restapi.AlexaUrls r5 = (com.blueair.api.restapi.AlexaUrls) r5
            if (r5 == 0) goto L_0x0071
            java.lang.String r6 = r5.getAlexaAppUrl()
            java.lang.String r5 = r5.getLwaFallbackUrl()
            kotlin.Pair r5 = kotlin.TuplesKt.to(r6, r5)
            return r5
        L_0x0071:
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.client.UserDevicesBlueClient.getAlexaLinkingUrls(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object alexaLinkAccount(java.lang.String r6, java.lang.String r7, kotlin.coroutines.Continuation<? super java.lang.Boolean> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof com.blueair.api.client.UserDevicesBlueClient$alexaLinkAccount$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            com.blueair.api.client.UserDevicesBlueClient$alexaLinkAccount$1 r0 = (com.blueair.api.client.UserDevicesBlueClient$alexaLinkAccount$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            com.blueair.api.client.UserDevicesBlueClient$alexaLinkAccount$1 r0 = new com.blueair.api.client.UserDevicesBlueClient$alexaLinkAccount$1
            r0.<init>(r5, r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003e
            if (r2 != r3) goto L_0x0036
            java.lang.Object r6 = r0.L$2
            java.util.Map r6 = (java.util.Map) r6
            java.lang.Object r6 = r0.L$1
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r6 = r0.L$0
            java.lang.String r6 = (java.lang.String) r6
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x007c
        L_0x0036:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x003e:
            kotlin.ResultKt.throwOnFailure(r8)
            r8 = 2
            kotlin.Pair[] r8 = new kotlin.Pair[r8]
            java.lang.String r2 = "amazon_auth_code_from_url"
            kotlin.Pair r2 = kotlin.TuplesKt.to(r2, r6)
            r4 = 0
            r8[r4] = r2
            java.lang.String r2 = "stage_value"
            kotlin.Pair r2 = kotlin.TuplesKt.to(r2, r7)
            r8[r3] = r2
            java.util.Map r8 = kotlin.collections.MapsKt.mapOf(r8)
            com.blueair.api.restapi.UserDevicesRestApi r2 = r5.getUserDevicesRestApi()
            kotlinx.coroutines.Deferred r2 = r2.alexaLinkAccount(r8)
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)
            r0.L$0 = r6
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
            r0.L$1 = r6
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r0.L$2 = r6
            r0.label = r3
            java.lang.Object r8 = r5.awaitCall(r2, r0)
            if (r8 != r1) goto L_0x007c
            return r1
        L_0x007c:
            io.flatcircle.coroutinehelper.ApiResult r8 = (io.flatcircle.coroutinehelper.ApiResult) r8
            boolean r6 = r8.isSuccess()
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.client.UserDevicesBlueClient.alexaLinkAccount(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getAlexaLinkStatus(kotlin.coroutines.Continuation<? super java.lang.Boolean> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.blueair.api.client.UserDevicesBlueClient$getAlexaLinkStatus$1
            if (r0 == 0) goto L_0x0014
            r0 = r5
            com.blueair.api.client.UserDevicesBlueClient$getAlexaLinkStatus$1 r0 = (com.blueair.api.client.UserDevicesBlueClient$getAlexaLinkStatus$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r5 = r0.label
            int r5 = r5 - r2
            r0.label = r5
            goto L_0x0019
        L_0x0014:
            com.blueair.api.client.UserDevicesBlueClient$getAlexaLinkStatus$1 r0 = new com.blueair.api.client.UserDevicesBlueClient$getAlexaLinkStatus$1
            r0.<init>(r4, r5)
        L_0x0019:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x0046
        L_0x002a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r5)
            com.blueair.api.restapi.UserDevicesRestApi r5 = r4.getUserDevicesRestApi()
            kotlinx.coroutines.Deferred r5 = r5.getAlexaLinkStatus()
            r0.label = r3
            java.lang.Object r5 = r4.awaitCall(r5, r0)
            if (r5 != r1) goto L_0x0046
            return r1
        L_0x0046:
            io.flatcircle.coroutinehelper.ApiResult r5 = (io.flatcircle.coroutinehelper.ApiResult) r5
            java.lang.Object r5 = r5.getOrNull()
            java.util.Map r5 = (java.util.Map) r5
            if (r5 == 0) goto L_0x0059
            java.lang.String r0 = "skill_status"
            java.lang.Object r5 = r5.get(r0)
            java.lang.String r5 = (java.lang.String) r5
            goto L_0x005a
        L_0x0059:
            r5 = 0
        L_0x005a:
            java.lang.String r0 = "enable"
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r0)
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.client.UserDevicesBlueClient.getAlexaLinkStatus(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object unlinkAlexa(java.lang.String r5, kotlin.coroutines.Continuation<? super java.lang.Boolean> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.blueair.api.client.UserDevicesBlueClient$unlinkAlexa$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            com.blueair.api.client.UserDevicesBlueClient$unlinkAlexa$1 r0 = (com.blueair.api.client.UserDevicesBlueClient$unlinkAlexa$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            com.blueair.api.client.UserDevicesBlueClient$unlinkAlexa$1 r0 = new com.blueair.api.client.UserDevicesBlueClient$unlinkAlexa$1
            r0.<init>(r4, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r5 = r0.L$0
            java.lang.String r5 = (java.lang.String) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0050
        L_0x002e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r6)
            com.blueair.api.restapi.UserDevicesRestApi r6 = r4.getUserDevicesRestApi()
            kotlinx.coroutines.Deferred r6 = r6.unlinkAlexa(r5)
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r5)
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r6 = r4.awaitCall(r6, r0)
            if (r6 != r1) goto L_0x0050
            return r1
        L_0x0050:
            io.flatcircle.coroutinehelper.ApiResult r6 = (io.flatcircle.coroutinehelper.ApiResult) r6
            java.lang.Object r5 = r6.getOrNull()
            java.util.Map r5 = (java.util.Map) r5
            if (r5 == 0) goto L_0x0063
            java.lang.String r6 = "skill_status"
            java.lang.Object r5 = r5.get(r6)
            java.lang.String r5 = (java.lang.String) r5
            goto L_0x0064
        L_0x0063:
            r5 = 0
        L_0x0064:
            java.lang.String r6 = "Disabled"
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r6)
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.client.UserDevicesBlueClient.unlinkAlexa(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x006e, code lost:
        r11 = r11.getCode();
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0075 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getGoogleAuthCode(java.lang.String r11, java.lang.String r12, kotlin.coroutines.Continuation<? super java.lang.String> r13) {
        /*
            r10 = this;
            boolean r0 = r13 instanceof com.blueair.api.client.UserDevicesBlueClient$getGoogleAuthCode$1
            if (r0 == 0) goto L_0x0014
            r0 = r13
            com.blueair.api.client.UserDevicesBlueClient$getGoogleAuthCode$1 r0 = (com.blueair.api.client.UserDevicesBlueClient$getGoogleAuthCode$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r13 = r0.label
            int r13 = r13 - r2
            r0.label = r13
            goto L_0x0019
        L_0x0014:
            com.blueair.api.client.UserDevicesBlueClient$getGoogleAuthCode$1 r0 = new com.blueair.api.client.UserDevicesBlueClient$getGoogleAuthCode$1
            r0.<init>(r10, r13)
        L_0x0019:
            java.lang.Object r13 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003a
            if (r2 != r3) goto L_0x0032
            java.lang.Object r11 = r0.L$1
            java.lang.String r11 = (java.lang.String) r11
            java.lang.Object r11 = r0.L$0
            java.lang.String r11 = (java.lang.String) r11
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x0064
        L_0x0032:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x003a:
            kotlin.ResultKt.throwOnFailure(r13)
            com.blueair.api.restapi.UserDevicesRestApi r13 = r10.getUserDevicesRestApi()
            com.blueair.api.restapi.GetGoogleAuthCodeReq r4 = new com.blueair.api.restapi.GetGoogleAuthCodeReq
            r8 = 4
            r9 = 0
            r7 = 0
            r5 = r11
            r6 = r12
            r4.<init>(r5, r6, r7, r8, r9)
            kotlinx.coroutines.Deferred r11 = r13.getGoogleAuthCode(r4)
            java.lang.Object r12 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r5)
            r0.L$0 = r12
            java.lang.Object r12 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)
            r0.L$1 = r12
            r0.label = r3
            java.lang.Object r13 = r10.awaitCall(r11, r0)
            if (r13 != r1) goto L_0x0064
            return r1
        L_0x0064:
            io.flatcircle.coroutinehelper.ApiResult r13 = (io.flatcircle.coroutinehelper.ApiResult) r13
            java.lang.Object r11 = r13.getOrNull()
            com.blueair.api.restapi.GetGoogleAuthCodeRsp r11 = (com.blueair.api.restapi.GetGoogleAuthCodeRsp) r11
            if (r11 == 0) goto L_0x0076
            java.lang.String r11 = r11.getCode()
            if (r11 != 0) goto L_0x0075
            goto L_0x0076
        L_0x0075:
            return r11
        L_0x0076:
            java.lang.String r11 = ""
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.client.UserDevicesBlueClient.getGoogleAuthCode(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getGoogleLinkStatus(java.lang.String r6, kotlin.coroutines.Continuation<? super java.lang.Boolean> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.blueair.api.client.UserDevicesBlueClient$getGoogleLinkStatus$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            com.blueair.api.client.UserDevicesBlueClient$getGoogleLinkStatus$1 r0 = (com.blueair.api.client.UserDevicesBlueClient$getGoogleLinkStatus$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            com.blueair.api.client.UserDevicesBlueClient$getGoogleLinkStatus$1 r0 = new com.blueair.api.client.UserDevicesBlueClient$getGoogleLinkStatus$1
            r0.<init>(r5, r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r6 = r0.L$0
            java.lang.String r6 = (java.lang.String) r6
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0052
        L_0x002e:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r7)
            com.blueair.api.restapi.UserDevicesRestApi r7 = r5.getUserDevicesRestApi()
            r2 = 2
            r4 = 0
            kotlinx.coroutines.Deferred r7 = com.blueair.api.restapi.UserDevicesRestApi.CC.getGoogleLinkStatus$default(r7, r6, r4, r2, r4)
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r7 = r5.awaitCall(r7, r0)
            if (r7 != r1) goto L_0x0052
            return r1
        L_0x0052:
            io.flatcircle.coroutinehelper.ApiResult r7 = (io.flatcircle.coroutinehelper.ApiResult) r7
            java.lang.Object r6 = r7.getOrNull()
            java.lang.Integer r6 = (java.lang.Integer) r6
            if (r6 != 0) goto L_0x005d
            goto L_0x0064
        L_0x005d:
            int r6 = r6.intValue()
            if (r6 != r3) goto L_0x0064
            goto L_0x0065
        L_0x0064:
            r3 = 0
        L_0x0065:
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.client.UserDevicesBlueClient.getGoogleLinkStatus(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object unlinkGoogle(java.lang.String r5, kotlin.coroutines.Continuation<? super java.lang.Boolean> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.blueair.api.client.UserDevicesBlueClient$unlinkGoogle$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            com.blueair.api.client.UserDevicesBlueClient$unlinkGoogle$1 r0 = (com.blueair.api.client.UserDevicesBlueClient$unlinkGoogle$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            com.blueair.api.client.UserDevicesBlueClient$unlinkGoogle$1 r0 = new com.blueair.api.client.UserDevicesBlueClient$unlinkGoogle$1
            r0.<init>(r4, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r5 = r0.L$0
            java.lang.String r5 = (java.lang.String) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0050
        L_0x002e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r6)
            com.blueair.api.restapi.UserDevicesRestApi r6 = r4.getUserDevicesRestApi()
            kotlinx.coroutines.Deferred r6 = r6.unlinkGoogle(r5)
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r5)
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r6 = r4.awaitCall(r6, r0)
            if (r6 != r1) goto L_0x0050
            return r1
        L_0x0050:
            io.flatcircle.coroutinehelper.ApiResult r6 = (io.flatcircle.coroutinehelper.ApiResult) r6
            boolean r5 = r6.isSuccess()
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.client.UserDevicesBlueClient.unlinkGoogle(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object getNotificationSettings(Continuation<? super ApiResult<List<NotificationSetting>>> continuation) {
        return awaitCall(getUserDevicesRestApi().getNotificationSettings(), continuation);
    }

    public final Object updateNotificationSetting(NotificationSetting notificationSetting, Continuation<? super ApiResult<ResponseBody>> continuation) {
        return awaitCall(getUserDevicesRestApi().updateNotificationSetting(notificationSetting), continuation);
    }

    public final Object setDeviceTimezone(List<String> list, String str, Continuation<? super ApiResult<ResponseBody>> continuation) {
        return awaitCall(getUserDevicesRestApi().setTimezone(new SetTimezoneReq(list, str)), continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getDeviceTimezone(java.lang.String r5, java.lang.String r6, kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<java.lang.String>> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.blueair.api.client.UserDevicesBlueClient$getDeviceTimezone$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            com.blueair.api.client.UserDevicesBlueClient$getDeviceTimezone$1 r0 = (com.blueair.api.client.UserDevicesBlueClient$getDeviceTimezone$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            com.blueair.api.client.UserDevicesBlueClient$getDeviceTimezone$1 r0 = new com.blueair.api.client.UserDevicesBlueClient$getDeviceTimezone$1
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
            goto L_0x005a
        L_0x0032:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x003a:
            kotlin.ResultKt.throwOnFailure(r7)
            com.blueair.api.restapi.UserDevicesRestApi r7 = r4.getUserDevicesRestApi()
            kotlinx.coroutines.Deferred r7 = r7.getTimezone(r5, r6)
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r5)
            r0.L$0 = r5
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r7 = r4.awaitCall(r7, r0)
            if (r7 != r1) goto L_0x005a
            return r1
        L_0x005a:
            io.flatcircle.coroutinehelper.ApiResult r7 = (io.flatcircle.coroutinehelper.ApiResult) r7
            io.flatcircle.coroutinehelper.ApiResult$Companion r5 = io.flatcircle.coroutinehelper.ApiResult.Companion
            java.lang.Object r6 = r7.getOrNull()
            com.blueair.api.restapi.TimezoneConfiguration r6 = (com.blueair.api.restapi.TimezoneConfiguration) r6
            if (r6 == 0) goto L_0x006b
            java.lang.String r6 = r6.getTimezone()
            goto L_0x006c
        L_0x006b:
            r6 = 0
        L_0x006c:
            io.flatcircle.coroutinehelper.ApiResult r5 = r5.fromResult(r7, r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.client.UserDevicesBlueClient.getDeviceTimezone(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object getTimezoneList(String str, Continuation<? super ApiResult<TimezoneNames>> continuation) {
        return awaitCall(getUserDevicesRestApi().getTimezoneList(str), continuation);
    }

    public final Object getSkuConfigurations(int i, int i2, Continuation<? super ApiResult<SkuConfigurationData>> continuation) {
        return awaitCall(getUserDevicesRestApi().getSkuConfigurations(i, i2), continuation);
    }

    public final Object getUserInfoCollections(int i, int i2, Continuation<? super ApiResult<UserInfoCollections>> continuation) {
        return awaitCall(getUserDevicesRestApi().getUserInfoCollections(i, i2), continuation);
    }

    public final Object uploadUserInfoCollections(UserInfoCollections userInfoCollections, Continuation<? super ApiResult<ResponseBody>> continuation) {
        return awaitCall(getUserDevicesRestApi().uploadUserInfoCollections(userInfoCollections), continuation);
    }

    public final Object downloadFile(String str, Continuation<? super ApiResult<InputStream>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new UserDevicesBlueClient$downloadFile$2(str, this, (Continuation<? super UserDevicesBlueClient$downloadFile$2>) null), continuation);
    }

    public final Object setupDeviceLocation(String str, List<String> list, List<String> list2, Continuation<? super ApiResult<ResponseBody>> continuation) {
        return awaitCall(getUserDevicesRestApi().setupDeviceLocation(new SetupDeviceLocationReq(str, list, list2)), continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getDeviceLocation(java.lang.String r5, kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<java.lang.String>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.blueair.api.client.UserDevicesBlueClient$getDeviceLocation$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            com.blueair.api.client.UserDevicesBlueClient$getDeviceLocation$1 r0 = (com.blueair.api.client.UserDevicesBlueClient$getDeviceLocation$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            com.blueair.api.client.UserDevicesBlueClient$getDeviceLocation$1 r0 = new com.blueair.api.client.UserDevicesBlueClient$getDeviceLocation$1
            r0.<init>(r4, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r5 = r0.L$0
            java.lang.String r5 = (java.lang.String) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0052
        L_0x002e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r6)
            com.blueair.api.restapi.UserDevicesRestApi r6 = r4.getUserDevicesRestApi()
            java.lang.String r2 = "device"
            kotlinx.coroutines.Deferred r6 = r6.getLocationInfo(r5, r2)
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r5)
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r6 = r4.awaitCall(r6, r0)
            if (r6 != r1) goto L_0x0052
            return r1
        L_0x0052:
            io.flatcircle.coroutinehelper.ApiResult r6 = (io.flatcircle.coroutinehelper.ApiResult) r6
            io.flatcircle.coroutinehelper.ApiResult$Companion r5 = io.flatcircle.coroutinehelper.ApiResult.Companion
            java.lang.Object r0 = r6.getOrNull()
            java.util.List r0 = (java.util.List) r0
            if (r0 == 0) goto L_0x006c
            java.lang.Object r0 = kotlin.collections.CollectionsKt.firstOrNull(r0)
            com.blueair.api.restapi.DeviceLocationInfo r0 = (com.blueair.api.restapi.DeviceLocationInfo) r0
            if (r0 == 0) goto L_0x006c
            java.lang.String r0 = r0.getLocation_id()
            if (r0 != 0) goto L_0x006e
        L_0x006c:
            java.lang.String r0 = ""
        L_0x006e:
            io.flatcircle.coroutinehelper.ApiResult r5 = r5.fromResult(r6, r0)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.client.UserDevicesBlueClient.getDeviceLocation(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getLocationDevices(java.lang.String r5, kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<java.util.List<java.lang.String>>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.blueair.api.client.UserDevicesBlueClient$getLocationDevices$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            com.blueair.api.client.UserDevicesBlueClient$getLocationDevices$1 r0 = (com.blueair.api.client.UserDevicesBlueClient$getLocationDevices$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            com.blueair.api.client.UserDevicesBlueClient$getLocationDevices$1 r0 = new com.blueair.api.client.UserDevicesBlueClient$getLocationDevices$1
            r0.<init>(r4, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r5 = r0.L$0
            java.lang.String r5 = (java.lang.String) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0052
        L_0x002e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r6)
            com.blueair.api.restapi.UserDevicesRestApi r6 = r4.getUserDevicesRestApi()
            java.lang.String r2 = "location"
            kotlinx.coroutines.Deferred r6 = r6.getLocationInfo(r5, r2)
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r5)
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r6 = r4.awaitCall(r6, r0)
            if (r6 != r1) goto L_0x0052
            return r1
        L_0x0052:
            io.flatcircle.coroutinehelper.ApiResult r6 = (io.flatcircle.coroutinehelper.ApiResult) r6
            io.flatcircle.coroutinehelper.ApiResult$Companion r5 = io.flatcircle.coroutinehelper.ApiResult.Companion
            java.lang.Object r0 = r6.getOrNull()
            java.util.List r0 = (java.util.List) r0
            if (r0 == 0) goto L_0x0088
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r1 = new java.util.ArrayList
            r2 = 10
            int r2 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r0, r2)
            r1.<init>(r2)
            java.util.Collection r1 = (java.util.Collection) r1
            java.util.Iterator r0 = r0.iterator()
        L_0x0071:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0085
            java.lang.Object r2 = r0.next()
            com.blueair.api.restapi.DeviceLocationInfo r2 = (com.blueair.api.restapi.DeviceLocationInfo) r2
            java.lang.String r2 = r2.getDevice_id()
            r1.add(r2)
            goto L_0x0071
        L_0x0085:
            java.util.List r1 = (java.util.List) r1
            goto L_0x008c
        L_0x0088:
            java.util.List r1 = kotlin.collections.CollectionsKt.emptyList()
        L_0x008c:
            io.flatcircle.coroutinehelper.ApiResult r5 = r5.fromResult(r6, r1)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.client.UserDevicesBlueClient.getLocationDevices(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object antiFakeVerify(String str, Continuation<? super ApiResult<AntiFakeVerifyResult>> continuation) {
        return awaitCall(getUserDevicesRestApi().antiFakeVerify(str), continuation);
    }

    public final Object antiFakeResetByWifi(String str, String str2, String str3, Continuation<? super ApiResult<AntiFakeResetResp>> continuation) {
        return awaitCall(getUserDevicesRestApi().antiFakeReset(new AntiFakeResetReq(str, str2, str3, (String) null, (Integer) null, 24, (DefaultConstructorMarker) null)), continuation);
    }

    public final Object antiFakeResetByBluetooth(String str, String str2, String str3, int i, Continuation<? super ApiResult<AntiFakeResetResp>> continuation) {
        return awaitCall(getUserDevicesRestApi().antiFakeReset(new AntiFakeResetReq(str, str2, (String) null, str3, Boxing.boxInt(i), 4, (DefaultConstructorMarker) null)), continuation);
    }

    public final Object antiFakeLogBluetooth(String str, String str2, String str3, String str4, Continuation<? super ApiResult<ResponseBody>> continuation) {
        return awaitCall(getUserDevicesRestApi().antiFakeLog(new AntiFakeLogReq(str, str2, str4, (String) null, str3, 8, (DefaultConstructorMarker) null)), continuation);
    }

    public final Object resetFilterLife(String str, String str2, Continuation<? super ApiResult<AntiFakeResetResp>> continuation) {
        return awaitCall(getUserDevicesRestApi().resetFilterLife(new FilterResetReq(str, str2)), continuation);
    }

    public final Object analyticsLogFilterClickEvent(AnalyticEvent.FilterClickEvent filterClickEvent, Continuation<? super ApiResult<ResponseBody>> continuation) {
        return awaitCall(getUserDevicesRestApi().analyticsLogFilterClickEvent(AnalyticsFilterCLickEvent.Companion.fromAnalyticEvent(filterClickEvent)), continuation);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v5, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object shopifyMultiPassLink(java.lang.String r5, java.lang.String r6, kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<java.lang.String>> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.blueair.api.client.UserDevicesBlueClient$shopifyMultiPassLink$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            com.blueair.api.client.UserDevicesBlueClient$shopifyMultiPassLink$1 r0 = (com.blueair.api.client.UserDevicesBlueClient$shopifyMultiPassLink$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            com.blueair.api.client.UserDevicesBlueClient$shopifyMultiPassLink$1 r0 = new com.blueair.api.client.UserDevicesBlueClient$shopifyMultiPassLink$1
            r0.<init>(r4, r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003b
            if (r2 != r3) goto L_0x0033
            java.lang.Object r5 = r0.L$1
            r6 = r5
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r5 = r0.L$0
            java.lang.String r5 = (java.lang.String) r5
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x005c
        L_0x0033:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x003b:
            kotlin.ResultKt.throwOnFailure(r7)
            com.blueair.api.restapi.UserDevicesRestApi r7 = r4.getUserDevicesRestApi()
            com.blueair.api.restapi.ShopifyMultiPassReq r2 = new com.blueair.api.restapi.ShopifyMultiPassReq
            r2.<init>(r5, r6)
            kotlinx.coroutines.Deferred r7 = r7.shopifyMultiPassLink(r2)
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r5)
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r3
            java.lang.Object r7 = r4.awaitCall(r7, r0)
            if (r7 != r1) goto L_0x005c
            return r1
        L_0x005c:
            io.flatcircle.coroutinehelper.ApiResult r7 = (io.flatcircle.coroutinehelper.ApiResult) r7
            io.flatcircle.coroutinehelper.ApiResult$Companion r5 = io.flatcircle.coroutinehelper.ApiResult.Companion
            java.lang.Object r0 = r7.getOrNull()
            com.blueair.api.restapi.UrlResponse r0 = (com.blueair.api.restapi.UrlResponse) r0
            if (r0 == 0) goto L_0x0070
            java.lang.String r0 = r0.getUrl()
            if (r0 != 0) goto L_0x006f
            goto L_0x0070
        L_0x006f:
            r6 = r0
        L_0x0070:
            io.flatcircle.coroutinehelper.ApiResult r5 = r5.fromResult(r7, r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.client.UserDevicesBlueClient.shopifyMultiPassLink(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object postUserForm(UserForm userForm, Continuation<? super Unit> continuation) {
        Object awaitCall = awaitCall(getUserDevicesRestApi().postUserForm(userForm), continuation);
        return awaitCall == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? awaitCall : Unit.INSTANCE;
    }

    public final Object presignUploadLog(UploadLogReq uploadLogReq, Continuation<? super ApiResult<UploadLogRsp>> continuation) {
        return awaitCall(getUserDevicesRestApi().presignUploadLog(uploadLogReq), continuation);
    }

    public final okhttp3.Response presignUploadFile(PresignUploadRsp presignUploadRsp, File file, ProgressListener progressListener) {
        Intrinsics.checkNotNullParameter(presignUploadRsp, "rsp");
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(progressListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        MultipartBody.Builder type = new MultipartBody.Builder((String) null, 1, (DefaultConstructorMarker) null).setType(MultipartBody.FORM);
        for (Map.Entry next : presignUploadRsp.getFields().entrySet()) {
            type.addFormDataPart((String) next.getKey(), (String) next.getValue());
        }
        type.addFormDataPart("file", (String) null, RequestBody.Companion.create(file, (MediaType) null));
        return new OkHttpClient().newCall(new Request.Builder().url(presignUploadRsp.getUrl()).post(new ProgressRequestBody(type.build(), progressListener)).build()).execute();
    }

    @Metadata(d1 = {"\u0000U\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0013\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0017\n\u0002\u0010\u0006\n\u0002\b \n\u0002\u0010 \n\u0002\u0018\u0002\n\u0003\bØ\u0001\b\b\u0018\u00002\u00020\u0001B\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0015\u001a\u00020\u0013\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u0006\u0010\u0017\u001a\u00020\u0013\u0012\u0006\u0010\u0018\u001a\u00020\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u000f\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0003\u0012\b\u0010!\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010#\u001a\u00020\u000f\u0012\b\u0010$\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010%\u001a\u0004\u0018\u00010&\u0012\b\u0010'\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010(\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010)\u001a\u0004\u0018\u00010\t\u0012\b\u0010*\u001a\u0004\u0018\u00010+\u0012\b\u0010,\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010-\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010.\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010/\u001a\u0004\u0018\u00010\t\u0012\b\u00100\u001a\u0004\u0018\u00010+\u0012\b\u00101\u001a\u0004\u0018\u00010\t\u0012\b\u00102\u001a\u0004\u0018\u00010\u000f\u0012\b\u00103\u001a\u0004\u0018\u00010\t\u0012\b\u00104\u001a\u0004\u0018\u00010\t\u0012\b\u00105\u001a\u0004\u0018\u00010\t\u0012\b\u00106\u001a\u0004\u0018\u00010\t\u0012\b\u00107\u001a\u0004\u0018\u00010+\u0012\b\u00108\u001a\u0004\u0018\u00010\t\u0012\b\u00109\u001a\u0004\u0018\u00010\t\u0012\b\u0010:\u001a\u0004\u0018\u00010\t\u0012\b\u0010;\u001a\u0004\u0018\u00010\t\u0012\b\u0010<\u001a\u0004\u0018\u00010\t\u0012\b\u0010=\u001a\u0004\u0018\u00010\t\u0012\b\u0010>\u001a\u0004\u0018\u00010\t\u0012\b\u0010?\u001a\u0004\u0018\u00010\t\u0012\b\u0010@\u001a\u0004\u0018\u00010\t\u0012\b\u0010A\u001a\u0004\u0018\u00010\t\u0012\b\u0010B\u001a\u0004\u0018\u00010C\u0012\b\u0010D\u001a\u0004\u0018\u00010C\u0012\b\u0010E\u001a\u0004\u0018\u00010\t\u0012\b\u0010F\u001a\u0004\u0018\u00010\t\u0012\b\u0010G\u001a\u0004\u0018\u00010\t\u0012\b\u0010H\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010I\u001a\u0004\u0018\u00010\t\u0012\b\u0010J\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010K\u001a\u0004\u0018\u00010\t\u0012\b\u0010L\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010M\u001a\u0004\u0018\u00010\t\u0012\b\u0010N\u001a\u0004\u0018\u00010\t\u0012\b\u0010O\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010P\u001a\u0004\u0018\u00010\t\u0012\b\u0010Q\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010R\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010S\u001a\u0004\u0018\u00010\t\u0012\b\u0010T\u001a\u0004\u0018\u00010\t\u0012\b\u0010U\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010V\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010W\u001a\u0004\u0018\u00010\t\u0012\b\u0010X\u001a\u0004\u0018\u00010\t\u0012\b\u0010Y\u001a\u0004\u0018\u00010\t\u0012\b\u0010Z\u001a\u0004\u0018\u00010\t\u0012\b\u0010[\u001a\u0004\u0018\u00010\t\u0012\b\u0010\\\u001a\u0004\u0018\u00010\t\u0012\b\u0010]\u001a\u0004\u0018\u00010\t\u0012\b\u0010^\u001a\u0004\u0018\u00010\t\u0012\b\u0010_\u001a\u0004\u0018\u00010\t\u0012\b\u0010`\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010a\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010b\u001a\u0004\u0018\u00010\t\u0012\u0010\u0010c\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010e\u0018\u00010d\u0012\b\u0010f\u001a\u0004\u0018\u00010\t\u0012\b\u0010g\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010h\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010i\u001a\u0004\u0018\u00010\t¢\u0006\u0004\bj\u0010kJ\n\u0010Ù\u0001\u001a\u00020\u0003HÆ\u0003J\f\u0010Ú\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010Û\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010Ü\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010Ý\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010Þ\u0001\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010sJ\f\u0010ß\u0001\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\n\u0010à\u0001\u001a\u00020\tHÆ\u0003J\n\u0010á\u0001\u001a\u00020\tHÆ\u0003J\n\u0010â\u0001\u001a\u00020\u000fHÆ\u0003J\n\u0010ã\u0001\u001a\u00020\u000fHÆ\u0003J\u0011\u0010ä\u0001\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010sJ\n\u0010å\u0001\u001a\u00020\u0013HÆ\u0003J\n\u0010æ\u0001\u001a\u00020\u0013HÆ\u0003J\n\u0010ç\u0001\u001a\u00020\u0013HÆ\u0003J\n\u0010è\u0001\u001a\u00020\u0013HÆ\u0003J\n\u0010é\u0001\u001a\u00020\u0013HÆ\u0003J\n\u0010ê\u0001\u001a\u00020\u000fHÆ\u0003J\n\u0010ë\u0001\u001a\u00020\u000fHÆ\u0003J\n\u0010ì\u0001\u001a\u00020\u000fHÆ\u0003J\n\u0010í\u0001\u001a\u00020\u000fHÆ\u0003J\n\u0010î\u0001\u001a\u00020\u000fHÆ\u0003J\n\u0010ï\u0001\u001a\u00020\u000fHÆ\u0003J\u0012\u0010ð\u0001\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0003\u0010\u0001J\f\u0010ñ\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010ò\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010ó\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010ô\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\n\u0010õ\u0001\u001a\u00020\u000fHÆ\u0003J\f\u0010ö\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010÷\u0001\u001a\u0004\u0018\u00010&HÆ\u0003J\f\u0010ø\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0012\u0010ù\u0001\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0003\u0010\u0001J\u0011\u0010ú\u0001\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010sJ\u0012\u0010û\u0001\u001a\u0004\u0018\u00010+HÆ\u0003¢\u0006\u0003\u0010\u0001J\f\u0010ü\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0012\u0010ý\u0001\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0003\u0010\u0001J\u0012\u0010þ\u0001\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0003\u0010\u0001J\u0011\u0010ÿ\u0001\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010sJ\u0012\u0010\u0002\u001a\u0004\u0018\u00010+HÆ\u0003¢\u0006\u0003\u0010\u0001J\u0011\u0010\u0002\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010sJ\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0003\u0010\u0001J\u0011\u0010\u0002\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010sJ\u0011\u0010\u0002\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010sJ\u0011\u0010\u0002\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010sJ\u0011\u0010\u0002\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010sJ\u0012\u0010\u0002\u001a\u0004\u0018\u00010+HÆ\u0003¢\u0006\u0003\u0010\u0001J\u0011\u0010\u0002\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010sJ\u0011\u0010\u0002\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010sJ\u0011\u0010\u0002\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010sJ\u0011\u0010\u0002\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010sJ\u0011\u0010\u0002\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010sJ\u0011\u0010\u0002\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010sJ\u0011\u0010\u0002\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010sJ\u0011\u0010\u0002\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010sJ\u0011\u0010\u0002\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010sJ\u0011\u0010\u0002\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010sJ\u0012\u0010\u0002\u001a\u0004\u0018\u00010CHÆ\u0003¢\u0006\u0003\u0010²\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010CHÆ\u0003¢\u0006\u0003\u0010²\u0001J\u0011\u0010\u0002\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010sJ\u0011\u0010\u0002\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010sJ\u0011\u0010\u0002\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010sJ\f\u0010\u0002\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u0011\u0010\u0002\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010sJ\f\u0010\u0002\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u0011\u0010\u0002\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010sJ\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0003\u0010\u0001J\u0011\u0010\u0002\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010sJ\u0011\u0010\u0002\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010sJ\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0003\u0010\u0001J\u0011\u0010\u0002\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010sJ\u0012\u0010 \u0002\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0003\u0010\u0001J\u0012\u0010¡\u0002\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0003\u0010\u0001J\u0011\u0010¢\u0002\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010sJ\u0011\u0010£\u0002\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010sJ\u0012\u0010¤\u0002\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0003\u0010\u0001J\u0012\u0010¥\u0002\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0003\u0010\u0001J\u0011\u0010¦\u0002\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010sJ\u0011\u0010§\u0002\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010sJ\u0011\u0010¨\u0002\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010sJ\u0011\u0010©\u0002\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010sJ\u0011\u0010ª\u0002\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010sJ\u0011\u0010«\u0002\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010sJ\u0011\u0010¬\u0002\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010sJ\u0011\u0010­\u0002\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010sJ\u0011\u0010®\u0002\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010sJ\u0012\u0010¯\u0002\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0003\u0010\u0001J\u0012\u0010°\u0002\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0003\u0010\u0001J\u0011\u0010±\u0002\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010sJ\u0014\u0010²\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010e\u0018\u00010dHÆ\u0003J\u0011\u0010³\u0002\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010sJ\u0012\u0010´\u0002\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0003\u0010\u0001J\u0012\u0010µ\u0002\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0003\u0010\u0001J\u0011\u0010¶\u0002\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010sJÞ\b\u0010·\u0002\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u00132\b\b\u0002\u0010\u0017\u001a\u00020\u00132\b\b\u0002\u0010\u0018\u001a\u00020\u000f2\b\b\u0002\u0010\u0019\u001a\u00020\u000f2\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f2\b\b\u0002\u0010\u001c\u001a\u00020\u000f2\b\b\u0002\u0010\u001d\u001a\u00020\u000f2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010#\u001a\u00020\u000f2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010+2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\t2\n\b\u0002\u00100\u001a\u0004\u0018\u00010+2\n\b\u0002\u00101\u001a\u0004\u0018\u00010\t2\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u00103\u001a\u0004\u0018\u00010\t2\n\b\u0002\u00104\u001a\u0004\u0018\u00010\t2\n\b\u0002\u00105\u001a\u0004\u0018\u00010\t2\n\b\u0002\u00106\u001a\u0004\u0018\u00010\t2\n\b\u0002\u00107\u001a\u0004\u0018\u00010+2\n\b\u0002\u00108\u001a\u0004\u0018\u00010\t2\n\b\u0002\u00109\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010B\u001a\u0004\u0018\u00010C2\n\b\u0002\u0010D\u001a\u0004\u0018\u00010C2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010F\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010G\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010H\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010I\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010J\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010K\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010L\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010M\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010N\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010O\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010P\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010R\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010S\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010T\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010U\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010V\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010W\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010X\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010Y\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010Z\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010[\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\\\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010]\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010^\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010_\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010`\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010a\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010b\u001a\u0004\u0018\u00010\t2\u0012\b\u0002\u0010c\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010e\u0018\u00010d2\n\b\u0002\u0010f\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010g\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010h\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010i\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0003\u0010¸\u0002J\u0015\u0010¹\u0002\u001a\u00020\u000f2\t\u0010º\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\n\u0010»\u0002\u001a\u00020\tHÖ\u0001J\n\u0010¼\u0002\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bl\u0010mR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bn\u0010mR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bo\u0010mR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bp\u0010mR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bq\u0010mR\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010t\u001a\u0004\br\u0010sR\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\bu\u0010vR\u0011\u0010\f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\bw\u0010xR\u0011\u0010\r\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\by\u0010xR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\bz\u0010{R\u0011\u0010\u0010\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b|\u0010{R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010t\u001a\u0004\b}\u0010sR\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b~\u0010R\u0012\u0010\u0014\u001a\u00020\u0013¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010R\u0012\u0010\u0015\u001a\u00020\u0013¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010R\u0012\u0010\u0016\u001a\u00020\u0013¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010R\u0012\u0010\u0017\u001a\u00020\u0013¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010R\u0012\u0010\u0018\u001a\u00020\u000f¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010{R\u0012\u0010\u0019\u001a\u00020\u000f¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010{R\u0012\u0010\u001a\u001a\u00020\u000f¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010{R\u0012\u0010\u001b\u001a\u00020\u000f¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010{R\u0012\u0010\u001c\u001a\u00020\u000f¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010{R\u0012\u0010\u001d\u001a\u00020\u000f¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010{R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u000f¢\u0006\r\n\u0003\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001R\u0014\u0010\u001f\u001a\u0004\u0018\u00010\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010mR\u0014\u0010 \u001a\u0004\u0018\u00010\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010mR\u0014\u0010!\u001a\u0004\u0018\u00010\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010mR\u0014\u0010\"\u001a\u0004\u0018\u00010\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010mR\u0012\u0010#\u001a\u00020\u000f¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010{R\u0014\u0010$\u001a\u0004\u0018\u00010\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010mR\u0015\u0010%\u001a\u0004\u0018\u00010&¢\u0006\n\n\u0000\u001a\u0006\b\u0001\u0010\u0001R\u0014\u0010'\u001a\u0004\u0018\u00010\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010mR\u0018\u0010(\u001a\u0004\u0018\u00010\u000f¢\u0006\r\n\u0003\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001R\u0016\u0010)\u001a\u0004\u0018\u00010\t¢\u0006\u000b\n\u0002\u0010t\u001a\u0005\b\u0001\u0010sR\u0018\u0010*\u001a\u0004\u0018\u00010+¢\u0006\r\n\u0003\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001R\u0014\u0010,\u001a\u0004\u0018\u00010\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010mR\u0018\u0010-\u001a\u0004\u0018\u00010\u000f¢\u0006\r\n\u0003\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001R\u0018\u0010.\u001a\u0004\u0018\u00010\u000f¢\u0006\r\n\u0003\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001R\u0016\u0010/\u001a\u0004\u0018\u00010\t¢\u0006\u000b\n\u0002\u0010t\u001a\u0005\b\u0001\u0010sR\u0018\u00100\u001a\u0004\u0018\u00010+¢\u0006\r\n\u0003\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001R\u0016\u00101\u001a\u0004\u0018\u00010\t¢\u0006\u000b\n\u0002\u0010t\u001a\u0005\b \u0001\u0010sR\u0018\u00102\u001a\u0004\u0018\u00010\u000f¢\u0006\r\n\u0003\u0010\u0001\u001a\u0006\b¡\u0001\u0010\u0001R\u0016\u00103\u001a\u0004\u0018\u00010\t¢\u0006\u000b\n\u0002\u0010t\u001a\u0005\b¢\u0001\u0010sR\u0016\u00104\u001a\u0004\u0018\u00010\t¢\u0006\u000b\n\u0002\u0010t\u001a\u0005\b£\u0001\u0010sR\u0016\u00105\u001a\u0004\u0018\u00010\t¢\u0006\u000b\n\u0002\u0010t\u001a\u0005\b¤\u0001\u0010sR\u0016\u00106\u001a\u0004\u0018\u00010\t¢\u0006\u000b\n\u0002\u0010t\u001a\u0005\b¥\u0001\u0010sR\u0018\u00107\u001a\u0004\u0018\u00010+¢\u0006\r\n\u0003\u0010\u0001\u001a\u0006\b¦\u0001\u0010\u0001R\u0016\u00108\u001a\u0004\u0018\u00010\t¢\u0006\u000b\n\u0002\u0010t\u001a\u0005\b§\u0001\u0010sR\u0016\u00109\u001a\u0004\u0018\u00010\t¢\u0006\u000b\n\u0002\u0010t\u001a\u0005\b¨\u0001\u0010sR\u0016\u0010:\u001a\u0004\u0018\u00010\t¢\u0006\u000b\n\u0002\u0010t\u001a\u0005\b©\u0001\u0010sR\u0016\u0010;\u001a\u0004\u0018\u00010\t¢\u0006\u000b\n\u0002\u0010t\u001a\u0005\bª\u0001\u0010sR\u0016\u0010<\u001a\u0004\u0018\u00010\t¢\u0006\u000b\n\u0002\u0010t\u001a\u0005\b«\u0001\u0010sR\u0016\u0010=\u001a\u0004\u0018\u00010\t¢\u0006\u000b\n\u0002\u0010t\u001a\u0005\b¬\u0001\u0010sR\u0016\u0010>\u001a\u0004\u0018\u00010\t¢\u0006\u000b\n\u0002\u0010t\u001a\u0005\b­\u0001\u0010sR\u0016\u0010?\u001a\u0004\u0018\u00010\t¢\u0006\u000b\n\u0002\u0010t\u001a\u0005\b®\u0001\u0010sR\u0016\u0010@\u001a\u0004\u0018\u00010\t¢\u0006\u000b\n\u0002\u0010t\u001a\u0005\b¯\u0001\u0010sR\u0016\u0010A\u001a\u0004\u0018\u00010\t¢\u0006\u000b\n\u0002\u0010t\u001a\u0005\b°\u0001\u0010sR\u0018\u0010B\u001a\u0004\u0018\u00010C¢\u0006\r\n\u0003\u0010³\u0001\u001a\u0006\b±\u0001\u0010²\u0001R\u0018\u0010D\u001a\u0004\u0018\u00010C¢\u0006\r\n\u0003\u0010³\u0001\u001a\u0006\b´\u0001\u0010²\u0001R\u0016\u0010E\u001a\u0004\u0018\u00010\t¢\u0006\u000b\n\u0002\u0010t\u001a\u0005\bµ\u0001\u0010sR\u0016\u0010F\u001a\u0004\u0018\u00010\t¢\u0006\u000b\n\u0002\u0010t\u001a\u0005\b¶\u0001\u0010sR\u0016\u0010G\u001a\u0004\u0018\u00010\t¢\u0006\u000b\n\u0002\u0010t\u001a\u0005\b·\u0001\u0010sR\u0014\u0010H\u001a\u0004\u0018\u00010\u0013¢\u0006\t\n\u0000\u001a\u0005\b¸\u0001\u0010R\u0016\u0010I\u001a\u0004\u0018\u00010\t¢\u0006\u000b\n\u0002\u0010t\u001a\u0005\b¹\u0001\u0010sR\u0014\u0010J\u001a\u0004\u0018\u00010\u0013¢\u0006\t\n\u0000\u001a\u0005\bº\u0001\u0010R\u0016\u0010K\u001a\u0004\u0018\u00010\t¢\u0006\u000b\n\u0002\u0010t\u001a\u0005\b»\u0001\u0010sR\u0018\u0010L\u001a\u0004\u0018\u00010\u000f¢\u0006\r\n\u0003\u0010\u0001\u001a\u0006\b¼\u0001\u0010\u0001R\u0016\u0010M\u001a\u0004\u0018\u00010\t¢\u0006\u000b\n\u0002\u0010t\u001a\u0005\b½\u0001\u0010sR\u0016\u0010N\u001a\u0004\u0018\u00010\t¢\u0006\u000b\n\u0002\u0010t\u001a\u0005\b¾\u0001\u0010sR\u0018\u0010O\u001a\u0004\u0018\u00010\u000f¢\u0006\r\n\u0003\u0010\u0001\u001a\u0006\b¿\u0001\u0010\u0001R\u0016\u0010P\u001a\u0004\u0018\u00010\t¢\u0006\u000b\n\u0002\u0010t\u001a\u0005\bÀ\u0001\u0010sR\u0018\u0010Q\u001a\u0004\u0018\u00010\u000f¢\u0006\r\n\u0003\u0010\u0001\u001a\u0006\bÁ\u0001\u0010\u0001R\u0018\u0010R\u001a\u0004\u0018\u00010\u000f¢\u0006\r\n\u0003\u0010\u0001\u001a\u0006\bÂ\u0001\u0010\u0001R\u0016\u0010S\u001a\u0004\u0018\u00010\t¢\u0006\u000b\n\u0002\u0010t\u001a\u0005\bÃ\u0001\u0010sR\u0016\u0010T\u001a\u0004\u0018\u00010\t¢\u0006\u000b\n\u0002\u0010t\u001a\u0005\bÄ\u0001\u0010sR\u0018\u0010U\u001a\u0004\u0018\u00010\u000f¢\u0006\r\n\u0003\u0010\u0001\u001a\u0006\bÅ\u0001\u0010\u0001R\u0018\u0010V\u001a\u0004\u0018\u00010\u000f¢\u0006\r\n\u0003\u0010\u0001\u001a\u0006\bÆ\u0001\u0010\u0001R\u0016\u0010W\u001a\u0004\u0018\u00010\t¢\u0006\u000b\n\u0002\u0010t\u001a\u0005\bÇ\u0001\u0010sR\u0016\u0010X\u001a\u0004\u0018\u00010\t¢\u0006\u000b\n\u0002\u0010t\u001a\u0005\bÈ\u0001\u0010sR\u0016\u0010Y\u001a\u0004\u0018\u00010\t¢\u0006\u000b\n\u0002\u0010t\u001a\u0005\bÉ\u0001\u0010sR\u0016\u0010Z\u001a\u0004\u0018\u00010\t¢\u0006\u000b\n\u0002\u0010t\u001a\u0005\bÊ\u0001\u0010sR\u0016\u0010[\u001a\u0004\u0018\u00010\t¢\u0006\u000b\n\u0002\u0010t\u001a\u0005\bË\u0001\u0010sR\u0016\u0010\\\u001a\u0004\u0018\u00010\t¢\u0006\u000b\n\u0002\u0010t\u001a\u0005\bÌ\u0001\u0010sR\u0016\u0010]\u001a\u0004\u0018\u00010\t¢\u0006\u000b\n\u0002\u0010t\u001a\u0005\bÍ\u0001\u0010sR\u0016\u0010^\u001a\u0004\u0018\u00010\t¢\u0006\u000b\n\u0002\u0010t\u001a\u0005\bÎ\u0001\u0010sR\u0016\u0010_\u001a\u0004\u0018\u00010\t¢\u0006\u000b\n\u0002\u0010t\u001a\u0005\bÏ\u0001\u0010sR\u0018\u0010`\u001a\u0004\u0018\u00010\u000f¢\u0006\r\n\u0003\u0010\u0001\u001a\u0006\bÐ\u0001\u0010\u0001R\u0018\u0010a\u001a\u0004\u0018\u00010\u000f¢\u0006\r\n\u0003\u0010\u0001\u001a\u0006\bÑ\u0001\u0010\u0001R\u0016\u0010b\u001a\u0004\u0018\u00010\t¢\u0006\u000b\n\u0002\u0010t\u001a\u0005\bÒ\u0001\u0010sR\u001d\u0010c\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010e\u0018\u00010d¢\u0006\n\n\u0000\u001a\u0006\bÓ\u0001\u0010Ô\u0001R\u0016\u0010f\u001a\u0004\u0018\u00010\t¢\u0006\u000b\n\u0002\u0010t\u001a\u0005\bÕ\u0001\u0010sR\u0018\u0010g\u001a\u0004\u0018\u00010\u000f¢\u0006\r\n\u0003\u0010\u0001\u001a\u0006\bÖ\u0001\u0010\u0001R\u0018\u0010h\u001a\u0004\u0018\u00010\u000f¢\u0006\r\n\u0003\u0010\u0001\u001a\u0006\b×\u0001\u0010\u0001R\u0016\u0010i\u001a\u0004\u0018\u00010\t¢\u0006\u000b\n\u0002\u0010t\u001a\u0005\bØ\u0001\u0010s¨\u0006½\u0002"}, d2 = {"Lcom/blueair/api/client/UserDevicesBlueClient$DeviceDataOnBlue;", "", "uuid", "", "deviceType", "mcuFirmware", "wifiFirmare", "hardware", "connectivityStatus", "", "latestSensorDataPoint", "Lcom/blueair/core/model/IndoorDatapoint;", "fanSpeed", "brightness", "childlock", "", "autoMode", "filter", "pm1Ranges", "", "pm10Ranges", "pm25Ranges", "vocRanges", "hchoRanges", "standByMode", "ecoMode", "hinsMode", "hinsNightMode", "g4NightMode", "germShieldMode", "germShieldNightMode", "serialNumber", "name", "autoModeTrigger", "nightModeTrigger", "safetySwitch", "macAddress", "welcomeHome", "Lcom/blueair/core/model/WelcomeHomeLocation;", "locationId", "disinfection", "disinfectLeftTime", "disinfectLeftTimeUpdateTime", "", "timezone", "wickdryEnabled", "wickdryOn", "wickdryLeftTime", "wickdryLeftTimeUpdateTime", "wickUsage", "waterShortage", "autoRh", "timerStatus", "timerDuration", "timerLeftTime", "timerLeftTimeUpdateTime", "temperatureUnit", "oscillationState", "oscillationAngle", "oscillationDirection", "oscillationFanSpeed", "mainMode", "apSubMode", "apFanSpeed", "heatSubMode", "heatFanSpeed", "heatAutoTmp", "", "heatEcoTmp", "coolSubMode", "coolFanSpeed", "coolAutoTag", "coolAutoPresets", "coolEcoTag", "coolEcoPresets", "mode", "humMode", "waterLevel", "dehSubMode", "waterTankFailure", "smartSubMode", "detectCat", "bodyMounted", "cleanAirEta", "panelDisplayMode", "hoverEnabled", "airRefreshEnabled", "airRefreshStatus", "airRefreshDuration", "airRefreshTimeStamp", "airRefreshStartTimeStamp", "airRefreshEndTimeStamp", "roomType", "nightLampBrightness", "nightLampSteplessBrightness", "wickdryDuration", "wickdryDone", "ywrmEnabled", "ywrmUsage", "alarms", "", "Lcom/blueair/core/model/DeviceAlarm;", "humSubMode", "use24Hour", "waterInfill", "sensorMode", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/blueair/core/model/IndoorDatapoint;IIZZLjava/lang/Integer;[D[D[D[D[DZZZZZZLjava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Lcom/blueair/core/model/WelcomeHomeLocation;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;[DLjava/lang/Integer;[DLjava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;)V", "getUuid", "()Ljava/lang/String;", "getDeviceType", "getMcuFirmware", "getWifiFirmare", "getHardware", "getConnectivityStatus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getLatestSensorDataPoint", "()Lcom/blueair/core/model/IndoorDatapoint;", "getFanSpeed", "()I", "getBrightness", "getChildlock", "()Z", "getAutoMode", "getFilter", "getPm1Ranges", "()[D", "getPm10Ranges", "getPm25Ranges", "getVocRanges", "getHchoRanges", "getStandByMode", "getEcoMode", "getHinsMode", "getHinsNightMode", "getG4NightMode", "getGermShieldMode", "getGermShieldNightMode", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getSerialNumber", "getName", "getAutoModeTrigger", "getNightModeTrigger", "getSafetySwitch", "getMacAddress", "getWelcomeHome", "()Lcom/blueair/core/model/WelcomeHomeLocation;", "getLocationId", "getDisinfection", "getDisinfectLeftTime", "getDisinfectLeftTimeUpdateTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getTimezone", "getWickdryEnabled", "getWickdryOn", "getWickdryLeftTime", "getWickdryLeftTimeUpdateTime", "getWickUsage", "getWaterShortage", "getAutoRh", "getTimerStatus", "getTimerDuration", "getTimerLeftTime", "getTimerLeftTimeUpdateTime", "getTemperatureUnit", "getOscillationState", "getOscillationAngle", "getOscillationDirection", "getOscillationFanSpeed", "getMainMode", "getApSubMode", "getApFanSpeed", "getHeatSubMode", "getHeatFanSpeed", "getHeatAutoTmp", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getHeatEcoTmp", "getCoolSubMode", "getCoolFanSpeed", "getCoolAutoTag", "getCoolAutoPresets", "getCoolEcoTag", "getCoolEcoPresets", "getMode", "getHumMode", "getWaterLevel", "getDehSubMode", "getWaterTankFailure", "getSmartSubMode", "getDetectCat", "getBodyMounted", "getCleanAirEta", "getPanelDisplayMode", "getHoverEnabled", "getAirRefreshEnabled", "getAirRefreshStatus", "getAirRefreshDuration", "getAirRefreshTimeStamp", "getAirRefreshStartTimeStamp", "getAirRefreshEndTimeStamp", "getRoomType", "getNightLampBrightness", "getNightLampSteplessBrightness", "getWickdryDuration", "getWickdryDone", "getYwrmEnabled", "getYwrmUsage", "getAlarms", "()Ljava/util/List;", "getHumSubMode", "getUse24Hour", "getWaterInfill", "getSensorMode", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component40", "component41", "component42", "component43", "component44", "component45", "component46", "component47", "component48", "component49", "component50", "component51", "component52", "component53", "component54", "component55", "component56", "component57", "component58", "component59", "component60", "component61", "component62", "component63", "component64", "component65", "component66", "component67", "component68", "component69", "component70", "component71", "component72", "component73", "component74", "component75", "component76", "component77", "component78", "component79", "component80", "component81", "component82", "component83", "component84", "component85", "component86", "component87", "component88", "component89", "component90", "component91", "component92", "component93", "component94", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/blueair/core/model/IndoorDatapoint;IIZZLjava/lang/Integer;[D[D[D[D[DZZZZZZLjava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Lcom/blueair/core/model/WelcomeHomeLocation;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;[DLjava/lang/Integer;[DLjava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;)Lcom/blueair/api/client/UserDevicesBlueClient$DeviceDataOnBlue;", "equals", "other", "hashCode", "toString", "api_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: UserDevicesBlueClient.kt */
    public static final class DeviceDataOnBlue {
        private final Integer airRefreshDuration;
        private final Boolean airRefreshEnabled;
        private final Integer airRefreshEndTimeStamp;
        private final Integer airRefreshStartTimeStamp;
        private final Integer airRefreshStatus;
        private final Integer airRefreshTimeStamp;
        private final List<DeviceAlarm> alarms;
        private final Integer apFanSpeed;
        private final Integer apSubMode;
        private final boolean autoMode;
        private final String autoModeTrigger;
        private final Integer autoRh;
        private final Boolean bodyMounted;
        private final int brightness;
        private final boolean childlock;
        private final Integer cleanAirEta;
        private final Integer connectivityStatus;
        private final double[] coolAutoPresets;
        private final Integer coolAutoTag;
        private final double[] coolEcoPresets;
        private final Integer coolEcoTag;
        private final Integer coolFanSpeed;
        private final Integer coolSubMode;
        private final Integer dehSubMode;
        private final Boolean detectCat;
        private final String deviceType;
        private final Integer disinfectLeftTime;
        private final Long disinfectLeftTimeUpdateTime;
        private final Boolean disinfection;
        private final boolean ecoMode;
        private final int fanSpeed;
        private final Integer filter;
        private final boolean g4NightMode;
        private final boolean germShieldMode;
        private final Boolean germShieldNightMode;
        private final String hardware;
        private final double[] hchoRanges;
        private final Double heatAutoTmp;
        private final Double heatEcoTmp;
        private final Integer heatFanSpeed;
        private final Integer heatSubMode;
        private final boolean hinsMode;
        private final boolean hinsNightMode;
        private final Boolean hoverEnabled;
        private final Boolean humMode;
        private final Integer humSubMode;
        private final IndoorDatapoint latestSensorDataPoint;
        private final String locationId;
        private final String macAddress;
        private final Integer mainMode;
        private final String mcuFirmware;
        private final Integer mode;
        private final String name;
        private final Integer nightLampBrightness;
        private final Integer nightLampSteplessBrightness;
        private final String nightModeTrigger;
        private final Integer oscillationAngle;
        private final Integer oscillationDirection;
        private final Integer oscillationFanSpeed;
        private final Integer oscillationState;
        private final Integer panelDisplayMode;
        private final double[] pm10Ranges;
        private final double[] pm1Ranges;
        private final double[] pm25Ranges;
        private final Integer roomType;
        private final boolean safetySwitch;
        private final Integer sensorMode;
        private final String serialNumber;
        private final Integer smartSubMode;
        private final boolean standByMode;
        private final Integer temperatureUnit;
        private final Integer timerDuration;
        private final Integer timerLeftTime;
        private final Long timerLeftTimeUpdateTime;
        private final Integer timerStatus;
        private final String timezone;
        private final Boolean use24Hour;
        private final String uuid;
        private final double[] vocRanges;
        private final Boolean waterInfill;
        private final Integer waterLevel;
        private final Boolean waterShortage;
        private final Boolean waterTankFailure;
        private final WelcomeHomeLocation welcomeHome;
        private final Integer wickUsage;
        private final Boolean wickdryDone;
        private final Integer wickdryDuration;
        private final Boolean wickdryEnabled;
        private final Integer wickdryLeftTime;
        private final Long wickdryLeftTimeUpdateTime;
        private final Boolean wickdryOn;
        private final String wifiFirmare;
        private final Boolean ywrmEnabled;
        private final Integer ywrmUsage;

        public static /* synthetic */ DeviceDataOnBlue copy$default(DeviceDataOnBlue deviceDataOnBlue, String str, String str2, String str3, String str4, String str5, Integer num, IndoorDatapoint indoorDatapoint, int i, int i2, boolean z, boolean z2, Integer num2, double[] dArr, double[] dArr2, double[] dArr3, double[] dArr4, double[] dArr5, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, Boolean bool, String str6, String str7, String str8, String str9, boolean z9, String str10, WelcomeHomeLocation welcomeHomeLocation, String str11, Boolean bool2, Integer num3, Long l, String str12, Boolean bool3, Boolean bool4, Integer num4, Long l2, Integer num5, Boolean bool5, Integer num6, Integer num7, Integer num8, Integer num9, Long l3, Integer num10, Integer num11, Integer num12, Integer num13, Integer num14, Integer num15, Integer num16, Integer num17, Integer num18, Integer num19, Double d, Double d2, Integer num20, Integer num21, Integer num22, double[] dArr6, Integer num23, double[] dArr7, Integer num24, Boolean bool6, Integer num25, Integer num26, Boolean bool7, Integer num27, Boolean bool8, Boolean bool9, Integer num28, Integer num29, Boolean bool10, Boolean bool11, Integer num30, Integer num31, Integer num32, Integer num33, Integer num34, Integer num35, Integer num36, Integer num37, Integer num38, Boolean bool12, Boolean bool13, Integer num39, List list, Integer num40, Boolean bool14, Boolean bool15, Integer num41, int i3, int i4, int i5, Object obj) {
            DeviceDataOnBlue deviceDataOnBlue2 = deviceDataOnBlue;
            int i6 = i3;
            int i7 = i4;
            int i8 = i5;
            String str13 = (i6 & 1) != 0 ? deviceDataOnBlue2.uuid : str;
            return deviceDataOnBlue2.copy(str13, (i6 & 2) != 0 ? deviceDataOnBlue2.deviceType : str2, (i6 & 4) != 0 ? deviceDataOnBlue2.mcuFirmware : str3, (i6 & 8) != 0 ? deviceDataOnBlue2.wifiFirmare : str4, (i6 & 16) != 0 ? deviceDataOnBlue2.hardware : str5, (i6 & 32) != 0 ? deviceDataOnBlue2.connectivityStatus : num, (i6 & 64) != 0 ? deviceDataOnBlue2.latestSensorDataPoint : indoorDatapoint, (i6 & 128) != 0 ? deviceDataOnBlue2.fanSpeed : i, (i6 & 256) != 0 ? deviceDataOnBlue2.brightness : i2, (i6 & 512) != 0 ? deviceDataOnBlue2.childlock : z, (i6 & 1024) != 0 ? deviceDataOnBlue2.autoMode : z2, (i6 & 2048) != 0 ? deviceDataOnBlue2.filter : num2, (i6 & 4096) != 0 ? deviceDataOnBlue2.pm1Ranges : dArr, (i6 & 8192) != 0 ? deviceDataOnBlue2.pm10Ranges : dArr2, (i6 & 16384) != 0 ? deviceDataOnBlue2.pm25Ranges : dArr3, (i6 & 32768) != 0 ? deviceDataOnBlue2.vocRanges : dArr4, (i3 & 65536) != 0 ? deviceDataOnBlue2.hchoRanges : dArr5, (i3 & 131072) != 0 ? deviceDataOnBlue2.standByMode : z3, (i3 & 262144) != 0 ? deviceDataOnBlue2.ecoMode : z4, (i3 & 524288) != 0 ? deviceDataOnBlue2.hinsMode : z5, (i3 & 1048576) != 0 ? deviceDataOnBlue2.hinsNightMode : z6, (i3 & 2097152) != 0 ? deviceDataOnBlue2.g4NightMode : z7, (i3 & 4194304) != 0 ? deviceDataOnBlue2.germShieldMode : z8, (i3 & 8388608) != 0 ? deviceDataOnBlue2.germShieldNightMode : bool, (i3 & 16777216) != 0 ? deviceDataOnBlue2.serialNumber : str6, (i3 & 33554432) != 0 ? deviceDataOnBlue2.name : str7, (i3 & AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) != 0 ? deviceDataOnBlue2.autoModeTrigger : str8, (i3 & 134217728) != 0 ? deviceDataOnBlue2.nightModeTrigger : str9, (i3 & 268435456) != 0 ? deviceDataOnBlue2.safetySwitch : z9, (i3 & 536870912) != 0 ? deviceDataOnBlue2.macAddress : str10, (i3 & 1073741824) != 0 ? deviceDataOnBlue2.welcomeHome : welcomeHomeLocation, (i3 & Integer.MIN_VALUE) != 0 ? deviceDataOnBlue2.locationId : str11, (i7 & 1) != 0 ? deviceDataOnBlue2.disinfection : bool2, (i7 & 2) != 0 ? deviceDataOnBlue2.disinfectLeftTime : num3, (i7 & 4) != 0 ? deviceDataOnBlue2.disinfectLeftTimeUpdateTime : l, (i7 & 8) != 0 ? deviceDataOnBlue2.timezone : str12, (i7 & 16) != 0 ? deviceDataOnBlue2.wickdryEnabled : bool3, (i7 & 32) != 0 ? deviceDataOnBlue2.wickdryOn : bool4, (i7 & 64) != 0 ? deviceDataOnBlue2.wickdryLeftTime : num4, (i7 & 128) != 0 ? deviceDataOnBlue2.wickdryLeftTimeUpdateTime : l2, (i7 & 256) != 0 ? deviceDataOnBlue2.wickUsage : num5, (i7 & 512) != 0 ? deviceDataOnBlue2.waterShortage : bool5, (i7 & 1024) != 0 ? deviceDataOnBlue2.autoRh : num6, (i7 & 2048) != 0 ? deviceDataOnBlue2.timerStatus : num7, (i7 & 4096) != 0 ? deviceDataOnBlue2.timerDuration : num8, (i7 & 8192) != 0 ? deviceDataOnBlue2.timerLeftTime : num9, (i7 & 16384) != 0 ? deviceDataOnBlue2.timerLeftTimeUpdateTime : l3, (i7 & 32768) != 0 ? deviceDataOnBlue2.temperatureUnit : num10, (i7 & 65536) != 0 ? deviceDataOnBlue2.oscillationState : num11, (i7 & 131072) != 0 ? deviceDataOnBlue2.oscillationAngle : num12, (i7 & 262144) != 0 ? deviceDataOnBlue2.oscillationDirection : num13, (i7 & 524288) != 0 ? deviceDataOnBlue2.oscillationFanSpeed : num14, (i7 & 1048576) != 0 ? deviceDataOnBlue2.mainMode : num15, (i7 & 2097152) != 0 ? deviceDataOnBlue2.apSubMode : num16, (i7 & 4194304) != 0 ? deviceDataOnBlue2.apFanSpeed : num17, (i7 & 8388608) != 0 ? deviceDataOnBlue2.heatSubMode : num18, (i7 & 16777216) != 0 ? deviceDataOnBlue2.heatFanSpeed : num19, (i7 & 33554432) != 0 ? deviceDataOnBlue2.heatAutoTmp : d, (i7 & AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) != 0 ? deviceDataOnBlue2.heatEcoTmp : d2, (i7 & 134217728) != 0 ? deviceDataOnBlue2.coolSubMode : num20, (i7 & 268435456) != 0 ? deviceDataOnBlue2.coolFanSpeed : num21, (i7 & 536870912) != 0 ? deviceDataOnBlue2.coolAutoTag : num22, (i7 & 1073741824) != 0 ? deviceDataOnBlue2.coolAutoPresets : dArr6, (i7 & Integer.MIN_VALUE) != 0 ? deviceDataOnBlue2.coolEcoTag : num23, (i8 & 1) != 0 ? deviceDataOnBlue2.coolEcoPresets : dArr7, (i8 & 2) != 0 ? deviceDataOnBlue2.mode : num24, (i8 & 4) != 0 ? deviceDataOnBlue2.humMode : bool6, (i8 & 8) != 0 ? deviceDataOnBlue2.waterLevel : num25, (i8 & 16) != 0 ? deviceDataOnBlue2.dehSubMode : num26, (i8 & 32) != 0 ? deviceDataOnBlue2.waterTankFailure : bool7, (i8 & 64) != 0 ? deviceDataOnBlue2.smartSubMode : num27, (i8 & 128) != 0 ? deviceDataOnBlue2.detectCat : bool8, (i8 & 256) != 0 ? deviceDataOnBlue2.bodyMounted : bool9, (i8 & 512) != 0 ? deviceDataOnBlue2.cleanAirEta : num28, (i8 & 1024) != 0 ? deviceDataOnBlue2.panelDisplayMode : num29, (i8 & 2048) != 0 ? deviceDataOnBlue2.hoverEnabled : bool10, (i8 & 4096) != 0 ? deviceDataOnBlue2.airRefreshEnabled : bool11, (i8 & 8192) != 0 ? deviceDataOnBlue2.airRefreshStatus : num30, (i8 & 16384) != 0 ? deviceDataOnBlue2.airRefreshDuration : num31, (i8 & 32768) != 0 ? deviceDataOnBlue2.airRefreshTimeStamp : num32, (i8 & 65536) != 0 ? deviceDataOnBlue2.airRefreshStartTimeStamp : num33, (i8 & 131072) != 0 ? deviceDataOnBlue2.airRefreshEndTimeStamp : num34, (i8 & 262144) != 0 ? deviceDataOnBlue2.roomType : num35, (i8 & 524288) != 0 ? deviceDataOnBlue2.nightLampBrightness : num36, (i8 & 1048576) != 0 ? deviceDataOnBlue2.nightLampSteplessBrightness : num37, (i8 & 2097152) != 0 ? deviceDataOnBlue2.wickdryDuration : num38, (i8 & 4194304) != 0 ? deviceDataOnBlue2.wickdryDone : bool12, (i8 & 8388608) != 0 ? deviceDataOnBlue2.ywrmEnabled : bool13, (i8 & 16777216) != 0 ? deviceDataOnBlue2.ywrmUsage : num39, (i8 & 33554432) != 0 ? deviceDataOnBlue2.alarms : list, (i8 & AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) != 0 ? deviceDataOnBlue2.humSubMode : num40, (i8 & 134217728) != 0 ? deviceDataOnBlue2.use24Hour : bool14, (i8 & 268435456) != 0 ? deviceDataOnBlue2.waterInfill : bool15, (i8 & 536870912) != 0 ? deviceDataOnBlue2.sensorMode : num41);
        }

        public final String component1() {
            return this.uuid;
        }

        public final boolean component10() {
            return this.childlock;
        }

        public final boolean component11() {
            return this.autoMode;
        }

        public final Integer component12() {
            return this.filter;
        }

        public final double[] component13() {
            return this.pm1Ranges;
        }

        public final double[] component14() {
            return this.pm10Ranges;
        }

        public final double[] component15() {
            return this.pm25Ranges;
        }

        public final double[] component16() {
            return this.vocRanges;
        }

        public final double[] component17() {
            return this.hchoRanges;
        }

        public final boolean component18() {
            return this.standByMode;
        }

        public final boolean component19() {
            return this.ecoMode;
        }

        public final String component2() {
            return this.deviceType;
        }

        public final boolean component20() {
            return this.hinsMode;
        }

        public final boolean component21() {
            return this.hinsNightMode;
        }

        public final boolean component22() {
            return this.g4NightMode;
        }

        public final boolean component23() {
            return this.germShieldMode;
        }

        public final Boolean component24() {
            return this.germShieldNightMode;
        }

        public final String component25() {
            return this.serialNumber;
        }

        public final String component26() {
            return this.name;
        }

        public final String component27() {
            return this.autoModeTrigger;
        }

        public final String component28() {
            return this.nightModeTrigger;
        }

        public final boolean component29() {
            return this.safetySwitch;
        }

        public final String component3() {
            return this.mcuFirmware;
        }

        public final String component30() {
            return this.macAddress;
        }

        public final WelcomeHomeLocation component31() {
            return this.welcomeHome;
        }

        public final String component32() {
            return this.locationId;
        }

        public final Boolean component33() {
            return this.disinfection;
        }

        public final Integer component34() {
            return this.disinfectLeftTime;
        }

        public final Long component35() {
            return this.disinfectLeftTimeUpdateTime;
        }

        public final String component36() {
            return this.timezone;
        }

        public final Boolean component37() {
            return this.wickdryEnabled;
        }

        public final Boolean component38() {
            return this.wickdryOn;
        }

        public final Integer component39() {
            return this.wickdryLeftTime;
        }

        public final String component4() {
            return this.wifiFirmare;
        }

        public final Long component40() {
            return this.wickdryLeftTimeUpdateTime;
        }

        public final Integer component41() {
            return this.wickUsage;
        }

        public final Boolean component42() {
            return this.waterShortage;
        }

        public final Integer component43() {
            return this.autoRh;
        }

        public final Integer component44() {
            return this.timerStatus;
        }

        public final Integer component45() {
            return this.timerDuration;
        }

        public final Integer component46() {
            return this.timerLeftTime;
        }

        public final Long component47() {
            return this.timerLeftTimeUpdateTime;
        }

        public final Integer component48() {
            return this.temperatureUnit;
        }

        public final Integer component49() {
            return this.oscillationState;
        }

        public final String component5() {
            return this.hardware;
        }

        public final Integer component50() {
            return this.oscillationAngle;
        }

        public final Integer component51() {
            return this.oscillationDirection;
        }

        public final Integer component52() {
            return this.oscillationFanSpeed;
        }

        public final Integer component53() {
            return this.mainMode;
        }

        public final Integer component54() {
            return this.apSubMode;
        }

        public final Integer component55() {
            return this.apFanSpeed;
        }

        public final Integer component56() {
            return this.heatSubMode;
        }

        public final Integer component57() {
            return this.heatFanSpeed;
        }

        public final Double component58() {
            return this.heatAutoTmp;
        }

        public final Double component59() {
            return this.heatEcoTmp;
        }

        public final Integer component6() {
            return this.connectivityStatus;
        }

        public final Integer component60() {
            return this.coolSubMode;
        }

        public final Integer component61() {
            return this.coolFanSpeed;
        }

        public final Integer component62() {
            return this.coolAutoTag;
        }

        public final double[] component63() {
            return this.coolAutoPresets;
        }

        public final Integer component64() {
            return this.coolEcoTag;
        }

        public final double[] component65() {
            return this.coolEcoPresets;
        }

        public final Integer component66() {
            return this.mode;
        }

        public final Boolean component67() {
            return this.humMode;
        }

        public final Integer component68() {
            return this.waterLevel;
        }

        public final Integer component69() {
            return this.dehSubMode;
        }

        public final IndoorDatapoint component7() {
            return this.latestSensorDataPoint;
        }

        public final Boolean component70() {
            return this.waterTankFailure;
        }

        public final Integer component71() {
            return this.smartSubMode;
        }

        public final Boolean component72() {
            return this.detectCat;
        }

        public final Boolean component73() {
            return this.bodyMounted;
        }

        public final Integer component74() {
            return this.cleanAirEta;
        }

        public final Integer component75() {
            return this.panelDisplayMode;
        }

        public final Boolean component76() {
            return this.hoverEnabled;
        }

        public final Boolean component77() {
            return this.airRefreshEnabled;
        }

        public final Integer component78() {
            return this.airRefreshStatus;
        }

        public final Integer component79() {
            return this.airRefreshDuration;
        }

        public final int component8() {
            return this.fanSpeed;
        }

        public final Integer component80() {
            return this.airRefreshTimeStamp;
        }

        public final Integer component81() {
            return this.airRefreshStartTimeStamp;
        }

        public final Integer component82() {
            return this.airRefreshEndTimeStamp;
        }

        public final Integer component83() {
            return this.roomType;
        }

        public final Integer component84() {
            return this.nightLampBrightness;
        }

        public final Integer component85() {
            return this.nightLampSteplessBrightness;
        }

        public final Integer component86() {
            return this.wickdryDuration;
        }

        public final Boolean component87() {
            return this.wickdryDone;
        }

        public final Boolean component88() {
            return this.ywrmEnabled;
        }

        public final Integer component89() {
            return this.ywrmUsage;
        }

        public final int component9() {
            return this.brightness;
        }

        public final List<DeviceAlarm> component90() {
            return this.alarms;
        }

        public final Integer component91() {
            return this.humSubMode;
        }

        public final Boolean component92() {
            return this.use24Hour;
        }

        public final Boolean component93() {
            return this.waterInfill;
        }

        public final Integer component94() {
            return this.sensorMode;
        }

        public final DeviceDataOnBlue copy(String str, String str2, String str3, String str4, String str5, Integer num, IndoorDatapoint indoorDatapoint, int i, int i2, boolean z, boolean z2, Integer num2, double[] dArr, double[] dArr2, double[] dArr3, double[] dArr4, double[] dArr5, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, Boolean bool, String str6, String str7, String str8, String str9, boolean z9, String str10, WelcomeHomeLocation welcomeHomeLocation, String str11, Boolean bool2, Integer num3, Long l, String str12, Boolean bool3, Boolean bool4, Integer num4, Long l2, Integer num5, Boolean bool5, Integer num6, Integer num7, Integer num8, Integer num9, Long l3, Integer num10, Integer num11, Integer num12, Integer num13, Integer num14, Integer num15, Integer num16, Integer num17, Integer num18, Integer num19, Double d, Double d2, Integer num20, Integer num21, Integer num22, double[] dArr6, Integer num23, double[] dArr7, Integer num24, Boolean bool6, Integer num25, Integer num26, Boolean bool7, Integer num27, Boolean bool8, Boolean bool9, Integer num28, Integer num29, Boolean bool10, Boolean bool11, Integer num30, Integer num31, Integer num32, Integer num33, Integer num34, Integer num35, Integer num36, Integer num37, Integer num38, Boolean bool12, Boolean bool13, Integer num39, List<DeviceAlarm> list, Integer num40, Boolean bool14, Boolean bool15, Integer num41) {
            String str13 = str;
            Intrinsics.checkNotNullParameter(str13, "uuid");
            double[] dArr8 = dArr;
            Intrinsics.checkNotNullParameter(dArr8, "pm1Ranges");
            double[] dArr9 = dArr2;
            Intrinsics.checkNotNullParameter(dArr9, "pm10Ranges");
            Intrinsics.checkNotNullParameter(dArr3, "pm25Ranges");
            double[] dArr10 = dArr4;
            Intrinsics.checkNotNullParameter(dArr10, "vocRanges");
            double[] dArr11 = dArr5;
            Intrinsics.checkNotNullParameter(dArr11, "hchoRanges");
            double[] dArr12 = dArr10;
            double[] dArr13 = dArr11;
            return new DeviceDataOnBlue(str13, str2, str3, str4, str5, num, indoorDatapoint, i, i2, z, z2, num2, dArr8, dArr9, dArr3, dArr12, dArr13, z3, z4, z5, z6, z7, z8, bool, str6, str7, str8, str9, z9, str10, welcomeHomeLocation, str11, bool2, num3, l, str12, bool3, bool4, num4, l2, num5, bool5, num6, num7, num8, num9, l3, num10, num11, num12, num13, num14, num15, num16, num17, num18, num19, d, d2, num20, num21, num22, dArr6, num23, dArr7, num24, bool6, num25, num26, bool7, num27, bool8, bool9, num28, num29, bool10, bool11, num30, num31, num32, num33, num34, num35, num36, num37, num38, bool12, bool13, num39, list, num40, bool14, bool15, num41);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof DeviceDataOnBlue)) {
                return false;
            }
            DeviceDataOnBlue deviceDataOnBlue = (DeviceDataOnBlue) obj;
            return Intrinsics.areEqual((Object) this.uuid, (Object) deviceDataOnBlue.uuid) && Intrinsics.areEqual((Object) this.deviceType, (Object) deviceDataOnBlue.deviceType) && Intrinsics.areEqual((Object) this.mcuFirmware, (Object) deviceDataOnBlue.mcuFirmware) && Intrinsics.areEqual((Object) this.wifiFirmare, (Object) deviceDataOnBlue.wifiFirmare) && Intrinsics.areEqual((Object) this.hardware, (Object) deviceDataOnBlue.hardware) && Intrinsics.areEqual((Object) this.connectivityStatus, (Object) deviceDataOnBlue.connectivityStatus) && Intrinsics.areEqual((Object) this.latestSensorDataPoint, (Object) deviceDataOnBlue.latestSensorDataPoint) && this.fanSpeed == deviceDataOnBlue.fanSpeed && this.brightness == deviceDataOnBlue.brightness && this.childlock == deviceDataOnBlue.childlock && this.autoMode == deviceDataOnBlue.autoMode && Intrinsics.areEqual((Object) this.filter, (Object) deviceDataOnBlue.filter) && Intrinsics.areEqual((Object) this.pm1Ranges, (Object) deviceDataOnBlue.pm1Ranges) && Intrinsics.areEqual((Object) this.pm10Ranges, (Object) deviceDataOnBlue.pm10Ranges) && Intrinsics.areEqual((Object) this.pm25Ranges, (Object) deviceDataOnBlue.pm25Ranges) && Intrinsics.areEqual((Object) this.vocRanges, (Object) deviceDataOnBlue.vocRanges) && Intrinsics.areEqual((Object) this.hchoRanges, (Object) deviceDataOnBlue.hchoRanges) && this.standByMode == deviceDataOnBlue.standByMode && this.ecoMode == deviceDataOnBlue.ecoMode && this.hinsMode == deviceDataOnBlue.hinsMode && this.hinsNightMode == deviceDataOnBlue.hinsNightMode && this.g4NightMode == deviceDataOnBlue.g4NightMode && this.germShieldMode == deviceDataOnBlue.germShieldMode && Intrinsics.areEqual((Object) this.germShieldNightMode, (Object) deviceDataOnBlue.germShieldNightMode) && Intrinsics.areEqual((Object) this.serialNumber, (Object) deviceDataOnBlue.serialNumber) && Intrinsics.areEqual((Object) this.name, (Object) deviceDataOnBlue.name) && Intrinsics.areEqual((Object) this.autoModeTrigger, (Object) deviceDataOnBlue.autoModeTrigger) && Intrinsics.areEqual((Object) this.nightModeTrigger, (Object) deviceDataOnBlue.nightModeTrigger) && this.safetySwitch == deviceDataOnBlue.safetySwitch && Intrinsics.areEqual((Object) this.macAddress, (Object) deviceDataOnBlue.macAddress) && Intrinsics.areEqual((Object) this.welcomeHome, (Object) deviceDataOnBlue.welcomeHome) && Intrinsics.areEqual((Object) this.locationId, (Object) deviceDataOnBlue.locationId) && Intrinsics.areEqual((Object) this.disinfection, (Object) deviceDataOnBlue.disinfection) && Intrinsics.areEqual((Object) this.disinfectLeftTime, (Object) deviceDataOnBlue.disinfectLeftTime) && Intrinsics.areEqual((Object) this.disinfectLeftTimeUpdateTime, (Object) deviceDataOnBlue.disinfectLeftTimeUpdateTime) && Intrinsics.areEqual((Object) this.timezone, (Object) deviceDataOnBlue.timezone) && Intrinsics.areEqual((Object) this.wickdryEnabled, (Object) deviceDataOnBlue.wickdryEnabled) && Intrinsics.areEqual((Object) this.wickdryOn, (Object) deviceDataOnBlue.wickdryOn) && Intrinsics.areEqual((Object) this.wickdryLeftTime, (Object) deviceDataOnBlue.wickdryLeftTime) && Intrinsics.areEqual((Object) this.wickdryLeftTimeUpdateTime, (Object) deviceDataOnBlue.wickdryLeftTimeUpdateTime) && Intrinsics.areEqual((Object) this.wickUsage, (Object) deviceDataOnBlue.wickUsage) && Intrinsics.areEqual((Object) this.waterShortage, (Object) deviceDataOnBlue.waterShortage) && Intrinsics.areEqual((Object) this.autoRh, (Object) deviceDataOnBlue.autoRh) && Intrinsics.areEqual((Object) this.timerStatus, (Object) deviceDataOnBlue.timerStatus) && Intrinsics.areEqual((Object) this.timerDuration, (Object) deviceDataOnBlue.timerDuration) && Intrinsics.areEqual((Object) this.timerLeftTime, (Object) deviceDataOnBlue.timerLeftTime) && Intrinsics.areEqual((Object) this.timerLeftTimeUpdateTime, (Object) deviceDataOnBlue.timerLeftTimeUpdateTime) && Intrinsics.areEqual((Object) this.temperatureUnit, (Object) deviceDataOnBlue.temperatureUnit) && Intrinsics.areEqual((Object) this.oscillationState, (Object) deviceDataOnBlue.oscillationState) && Intrinsics.areEqual((Object) this.oscillationAngle, (Object) deviceDataOnBlue.oscillationAngle) && Intrinsics.areEqual((Object) this.oscillationDirection, (Object) deviceDataOnBlue.oscillationDirection) && Intrinsics.areEqual((Object) this.oscillationFanSpeed, (Object) deviceDataOnBlue.oscillationFanSpeed) && Intrinsics.areEqual((Object) this.mainMode, (Object) deviceDataOnBlue.mainMode) && Intrinsics.areEqual((Object) this.apSubMode, (Object) deviceDataOnBlue.apSubMode) && Intrinsics.areEqual((Object) this.apFanSpeed, (Object) deviceDataOnBlue.apFanSpeed) && Intrinsics.areEqual((Object) this.heatSubMode, (Object) deviceDataOnBlue.heatSubMode) && Intrinsics.areEqual((Object) this.heatFanSpeed, (Object) deviceDataOnBlue.heatFanSpeed) && Intrinsics.areEqual((Object) this.heatAutoTmp, (Object) deviceDataOnBlue.heatAutoTmp) && Intrinsics.areEqual((Object) this.heatEcoTmp, (Object) deviceDataOnBlue.heatEcoTmp) && Intrinsics.areEqual((Object) this.coolSubMode, (Object) deviceDataOnBlue.coolSubMode) && Intrinsics.areEqual((Object) this.coolFanSpeed, (Object) deviceDataOnBlue.coolFanSpeed) && Intrinsics.areEqual((Object) this.coolAutoTag, (Object) deviceDataOnBlue.coolAutoTag) && Intrinsics.areEqual((Object) this.coolAutoPresets, (Object) deviceDataOnBlue.coolAutoPresets) && Intrinsics.areEqual((Object) this.coolEcoTag, (Object) deviceDataOnBlue.coolEcoTag) && Intrinsics.areEqual((Object) this.coolEcoPresets, (Object) deviceDataOnBlue.coolEcoPresets) && Intrinsics.areEqual((Object) this.mode, (Object) deviceDataOnBlue.mode) && Intrinsics.areEqual((Object) this.humMode, (Object) deviceDataOnBlue.humMode) && Intrinsics.areEqual((Object) this.waterLevel, (Object) deviceDataOnBlue.waterLevel) && Intrinsics.areEqual((Object) this.dehSubMode, (Object) deviceDataOnBlue.dehSubMode) && Intrinsics.areEqual((Object) this.waterTankFailure, (Object) deviceDataOnBlue.waterTankFailure) && Intrinsics.areEqual((Object) this.smartSubMode, (Object) deviceDataOnBlue.smartSubMode) && Intrinsics.areEqual((Object) this.detectCat, (Object) deviceDataOnBlue.detectCat) && Intrinsics.areEqual((Object) this.bodyMounted, (Object) deviceDataOnBlue.bodyMounted) && Intrinsics.areEqual((Object) this.cleanAirEta, (Object) deviceDataOnBlue.cleanAirEta) && Intrinsics.areEqual((Object) this.panelDisplayMode, (Object) deviceDataOnBlue.panelDisplayMode) && Intrinsics.areEqual((Object) this.hoverEnabled, (Object) deviceDataOnBlue.hoverEnabled) && Intrinsics.areEqual((Object) this.airRefreshEnabled, (Object) deviceDataOnBlue.airRefreshEnabled) && Intrinsics.areEqual((Object) this.airRefreshStatus, (Object) deviceDataOnBlue.airRefreshStatus) && Intrinsics.areEqual((Object) this.airRefreshDuration, (Object) deviceDataOnBlue.airRefreshDuration) && Intrinsics.areEqual((Object) this.airRefreshTimeStamp, (Object) deviceDataOnBlue.airRefreshTimeStamp) && Intrinsics.areEqual((Object) this.airRefreshStartTimeStamp, (Object) deviceDataOnBlue.airRefreshStartTimeStamp) && Intrinsics.areEqual((Object) this.airRefreshEndTimeStamp, (Object) deviceDataOnBlue.airRefreshEndTimeStamp) && Intrinsics.areEqual((Object) this.roomType, (Object) deviceDataOnBlue.roomType) && Intrinsics.areEqual((Object) this.nightLampBrightness, (Object) deviceDataOnBlue.nightLampBrightness) && Intrinsics.areEqual((Object) this.nightLampSteplessBrightness, (Object) deviceDataOnBlue.nightLampSteplessBrightness) && Intrinsics.areEqual((Object) this.wickdryDuration, (Object) deviceDataOnBlue.wickdryDuration) && Intrinsics.areEqual((Object) this.wickdryDone, (Object) deviceDataOnBlue.wickdryDone) && Intrinsics.areEqual((Object) this.ywrmEnabled, (Object) deviceDataOnBlue.ywrmEnabled) && Intrinsics.areEqual((Object) this.ywrmUsage, (Object) deviceDataOnBlue.ywrmUsage) && Intrinsics.areEqual((Object) this.alarms, (Object) deviceDataOnBlue.alarms) && Intrinsics.areEqual((Object) this.humSubMode, (Object) deviceDataOnBlue.humSubMode) && Intrinsics.areEqual((Object) this.use24Hour, (Object) deviceDataOnBlue.use24Hour) && Intrinsics.areEqual((Object) this.waterInfill, (Object) deviceDataOnBlue.waterInfill) && Intrinsics.areEqual((Object) this.sensorMode, (Object) deviceDataOnBlue.sensorMode);
        }

        public int hashCode() {
            int hashCode = this.uuid.hashCode() * 31;
            String str = this.deviceType;
            int i = 0;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.mcuFirmware;
            int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.wifiFirmare;
            int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.hardware;
            int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
            Integer num = this.connectivityStatus;
            int hashCode6 = (hashCode5 + (num == null ? 0 : num.hashCode())) * 31;
            IndoorDatapoint indoorDatapoint = this.latestSensorDataPoint;
            int hashCode7 = (((((((((hashCode6 + (indoorDatapoint == null ? 0 : indoorDatapoint.hashCode())) * 31) + this.fanSpeed) * 31) + this.brightness) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.childlock)) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.autoMode)) * 31;
            Integer num2 = this.filter;
            int hashCode8 = (((((((((((((((((((((((hashCode7 + (num2 == null ? 0 : num2.hashCode())) * 31) + Arrays.hashCode(this.pm1Ranges)) * 31) + Arrays.hashCode(this.pm10Ranges)) * 31) + Arrays.hashCode(this.pm25Ranges)) * 31) + Arrays.hashCode(this.vocRanges)) * 31) + Arrays.hashCode(this.hchoRanges)) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.standByMode)) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.ecoMode)) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.hinsMode)) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.hinsNightMode)) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.g4NightMode)) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.germShieldMode)) * 31;
            Boolean bool = this.germShieldNightMode;
            int hashCode9 = (hashCode8 + (bool == null ? 0 : bool.hashCode())) * 31;
            String str5 = this.serialNumber;
            int hashCode10 = (hashCode9 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.name;
            int hashCode11 = (hashCode10 + (str6 == null ? 0 : str6.hashCode())) * 31;
            String str7 = this.autoModeTrigger;
            int hashCode12 = (hashCode11 + (str7 == null ? 0 : str7.hashCode())) * 31;
            String str8 = this.nightModeTrigger;
            int hashCode13 = (((hashCode12 + (str8 == null ? 0 : str8.hashCode())) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.safetySwitch)) * 31;
            String str9 = this.macAddress;
            int hashCode14 = (hashCode13 + (str9 == null ? 0 : str9.hashCode())) * 31;
            WelcomeHomeLocation welcomeHomeLocation = this.welcomeHome;
            int hashCode15 = (hashCode14 + (welcomeHomeLocation == null ? 0 : welcomeHomeLocation.hashCode())) * 31;
            String str10 = this.locationId;
            int hashCode16 = (hashCode15 + (str10 == null ? 0 : str10.hashCode())) * 31;
            Boolean bool2 = this.disinfection;
            int hashCode17 = (hashCode16 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
            Integer num3 = this.disinfectLeftTime;
            int hashCode18 = (hashCode17 + (num3 == null ? 0 : num3.hashCode())) * 31;
            Long l = this.disinfectLeftTimeUpdateTime;
            int hashCode19 = (hashCode18 + (l == null ? 0 : l.hashCode())) * 31;
            String str11 = this.timezone;
            int hashCode20 = (hashCode19 + (str11 == null ? 0 : str11.hashCode())) * 31;
            Boolean bool3 = this.wickdryEnabled;
            int hashCode21 = (hashCode20 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
            Boolean bool4 = this.wickdryOn;
            int hashCode22 = (hashCode21 + (bool4 == null ? 0 : bool4.hashCode())) * 31;
            Integer num4 = this.wickdryLeftTime;
            int hashCode23 = (hashCode22 + (num4 == null ? 0 : num4.hashCode())) * 31;
            Long l2 = this.wickdryLeftTimeUpdateTime;
            int hashCode24 = (hashCode23 + (l2 == null ? 0 : l2.hashCode())) * 31;
            Integer num5 = this.wickUsage;
            int hashCode25 = (hashCode24 + (num5 == null ? 0 : num5.hashCode())) * 31;
            Boolean bool5 = this.waterShortage;
            int hashCode26 = (hashCode25 + (bool5 == null ? 0 : bool5.hashCode())) * 31;
            Integer num6 = this.autoRh;
            int hashCode27 = (hashCode26 + (num6 == null ? 0 : num6.hashCode())) * 31;
            Integer num7 = this.timerStatus;
            int hashCode28 = (hashCode27 + (num7 == null ? 0 : num7.hashCode())) * 31;
            Integer num8 = this.timerDuration;
            int hashCode29 = (hashCode28 + (num8 == null ? 0 : num8.hashCode())) * 31;
            Integer num9 = this.timerLeftTime;
            int hashCode30 = (hashCode29 + (num9 == null ? 0 : num9.hashCode())) * 31;
            Long l3 = this.timerLeftTimeUpdateTime;
            int hashCode31 = (hashCode30 + (l3 == null ? 0 : l3.hashCode())) * 31;
            Integer num10 = this.temperatureUnit;
            int hashCode32 = (hashCode31 + (num10 == null ? 0 : num10.hashCode())) * 31;
            Integer num11 = this.oscillationState;
            int hashCode33 = (hashCode32 + (num11 == null ? 0 : num11.hashCode())) * 31;
            Integer num12 = this.oscillationAngle;
            int hashCode34 = (hashCode33 + (num12 == null ? 0 : num12.hashCode())) * 31;
            Integer num13 = this.oscillationDirection;
            int hashCode35 = (hashCode34 + (num13 == null ? 0 : num13.hashCode())) * 31;
            Integer num14 = this.oscillationFanSpeed;
            int hashCode36 = (hashCode35 + (num14 == null ? 0 : num14.hashCode())) * 31;
            Integer num15 = this.mainMode;
            int hashCode37 = (hashCode36 + (num15 == null ? 0 : num15.hashCode())) * 31;
            Integer num16 = this.apSubMode;
            int hashCode38 = (hashCode37 + (num16 == null ? 0 : num16.hashCode())) * 31;
            Integer num17 = this.apFanSpeed;
            int hashCode39 = (hashCode38 + (num17 == null ? 0 : num17.hashCode())) * 31;
            Integer num18 = this.heatSubMode;
            int hashCode40 = (hashCode39 + (num18 == null ? 0 : num18.hashCode())) * 31;
            Integer num19 = this.heatFanSpeed;
            int hashCode41 = (hashCode40 + (num19 == null ? 0 : num19.hashCode())) * 31;
            Double d = this.heatAutoTmp;
            int hashCode42 = (hashCode41 + (d == null ? 0 : d.hashCode())) * 31;
            Double d2 = this.heatEcoTmp;
            int hashCode43 = (hashCode42 + (d2 == null ? 0 : d2.hashCode())) * 31;
            Integer num20 = this.coolSubMode;
            int hashCode44 = (hashCode43 + (num20 == null ? 0 : num20.hashCode())) * 31;
            Integer num21 = this.coolFanSpeed;
            int hashCode45 = (hashCode44 + (num21 == null ? 0 : num21.hashCode())) * 31;
            Integer num22 = this.coolAutoTag;
            int hashCode46 = (hashCode45 + (num22 == null ? 0 : num22.hashCode())) * 31;
            double[] dArr = this.coolAutoPresets;
            int hashCode47 = (hashCode46 + (dArr == null ? 0 : Arrays.hashCode(dArr))) * 31;
            Integer num23 = this.coolEcoTag;
            int hashCode48 = (hashCode47 + (num23 == null ? 0 : num23.hashCode())) * 31;
            double[] dArr2 = this.coolEcoPresets;
            int hashCode49 = (hashCode48 + (dArr2 == null ? 0 : Arrays.hashCode(dArr2))) * 31;
            Integer num24 = this.mode;
            int hashCode50 = (hashCode49 + (num24 == null ? 0 : num24.hashCode())) * 31;
            Boolean bool6 = this.humMode;
            int hashCode51 = (hashCode50 + (bool6 == null ? 0 : bool6.hashCode())) * 31;
            Integer num25 = this.waterLevel;
            int hashCode52 = (hashCode51 + (num25 == null ? 0 : num25.hashCode())) * 31;
            Integer num26 = this.dehSubMode;
            int hashCode53 = (hashCode52 + (num26 == null ? 0 : num26.hashCode())) * 31;
            Boolean bool7 = this.waterTankFailure;
            int hashCode54 = (hashCode53 + (bool7 == null ? 0 : bool7.hashCode())) * 31;
            Integer num27 = this.smartSubMode;
            int hashCode55 = (hashCode54 + (num27 == null ? 0 : num27.hashCode())) * 31;
            Boolean bool8 = this.detectCat;
            int hashCode56 = (hashCode55 + (bool8 == null ? 0 : bool8.hashCode())) * 31;
            Boolean bool9 = this.bodyMounted;
            int hashCode57 = (hashCode56 + (bool9 == null ? 0 : bool9.hashCode())) * 31;
            Integer num28 = this.cleanAirEta;
            int hashCode58 = (hashCode57 + (num28 == null ? 0 : num28.hashCode())) * 31;
            Integer num29 = this.panelDisplayMode;
            int hashCode59 = (hashCode58 + (num29 == null ? 0 : num29.hashCode())) * 31;
            Boolean bool10 = this.hoverEnabled;
            int hashCode60 = (hashCode59 + (bool10 == null ? 0 : bool10.hashCode())) * 31;
            Boolean bool11 = this.airRefreshEnabled;
            int hashCode61 = (hashCode60 + (bool11 == null ? 0 : bool11.hashCode())) * 31;
            Integer num30 = this.airRefreshStatus;
            int hashCode62 = (hashCode61 + (num30 == null ? 0 : num30.hashCode())) * 31;
            Integer num31 = this.airRefreshDuration;
            int hashCode63 = (hashCode62 + (num31 == null ? 0 : num31.hashCode())) * 31;
            Integer num32 = this.airRefreshTimeStamp;
            int hashCode64 = (hashCode63 + (num32 == null ? 0 : num32.hashCode())) * 31;
            Integer num33 = this.airRefreshStartTimeStamp;
            int hashCode65 = (hashCode64 + (num33 == null ? 0 : num33.hashCode())) * 31;
            Integer num34 = this.airRefreshEndTimeStamp;
            int hashCode66 = (hashCode65 + (num34 == null ? 0 : num34.hashCode())) * 31;
            Integer num35 = this.roomType;
            int hashCode67 = (hashCode66 + (num35 == null ? 0 : num35.hashCode())) * 31;
            Integer num36 = this.nightLampBrightness;
            int hashCode68 = (hashCode67 + (num36 == null ? 0 : num36.hashCode())) * 31;
            Integer num37 = this.nightLampSteplessBrightness;
            int hashCode69 = (hashCode68 + (num37 == null ? 0 : num37.hashCode())) * 31;
            Integer num38 = this.wickdryDuration;
            int hashCode70 = (hashCode69 + (num38 == null ? 0 : num38.hashCode())) * 31;
            Boolean bool12 = this.wickdryDone;
            int hashCode71 = (hashCode70 + (bool12 == null ? 0 : bool12.hashCode())) * 31;
            Boolean bool13 = this.ywrmEnabled;
            int hashCode72 = (hashCode71 + (bool13 == null ? 0 : bool13.hashCode())) * 31;
            Integer num39 = this.ywrmUsage;
            int hashCode73 = (hashCode72 + (num39 == null ? 0 : num39.hashCode())) * 31;
            List<DeviceAlarm> list = this.alarms;
            int hashCode74 = (hashCode73 + (list == null ? 0 : list.hashCode())) * 31;
            Integer num40 = this.humSubMode;
            int hashCode75 = (hashCode74 + (num40 == null ? 0 : num40.hashCode())) * 31;
            Boolean bool14 = this.use24Hour;
            int hashCode76 = (hashCode75 + (bool14 == null ? 0 : bool14.hashCode())) * 31;
            Boolean bool15 = this.waterInfill;
            int hashCode77 = (hashCode76 + (bool15 == null ? 0 : bool15.hashCode())) * 31;
            Integer num41 = this.sensorMode;
            if (num41 != null) {
                i = num41.hashCode();
            }
            return hashCode77 + i;
        }

        public String toString() {
            return "DeviceDataOnBlue(uuid=" + this.uuid + ", deviceType=" + this.deviceType + ", mcuFirmware=" + this.mcuFirmware + ", wifiFirmare=" + this.wifiFirmare + ", hardware=" + this.hardware + ", connectivityStatus=" + this.connectivityStatus + ", latestSensorDataPoint=" + this.latestSensorDataPoint + ", fanSpeed=" + this.fanSpeed + ", brightness=" + this.brightness + ", childlock=" + this.childlock + ", autoMode=" + this.autoMode + ", filter=" + this.filter + ", pm1Ranges=" + Arrays.toString(this.pm1Ranges) + ", pm10Ranges=" + Arrays.toString(this.pm10Ranges) + ", pm25Ranges=" + Arrays.toString(this.pm25Ranges) + ", vocRanges=" + Arrays.toString(this.vocRanges) + ", hchoRanges=" + Arrays.toString(this.hchoRanges) + ", standByMode=" + this.standByMode + ", ecoMode=" + this.ecoMode + ", hinsMode=" + this.hinsMode + ", hinsNightMode=" + this.hinsNightMode + ", g4NightMode=" + this.g4NightMode + ", germShieldMode=" + this.germShieldMode + ", germShieldNightMode=" + this.germShieldNightMode + ", serialNumber=" + this.serialNumber + ", name=" + this.name + ", autoModeTrigger=" + this.autoModeTrigger + ", nightModeTrigger=" + this.nightModeTrigger + ", safetySwitch=" + this.safetySwitch + ", macAddress=" + this.macAddress + ", welcomeHome=" + this.welcomeHome + ", locationId=" + this.locationId + ", disinfection=" + this.disinfection + ", disinfectLeftTime=" + this.disinfectLeftTime + ", disinfectLeftTimeUpdateTime=" + this.disinfectLeftTimeUpdateTime + ", timezone=" + this.timezone + ", wickdryEnabled=" + this.wickdryEnabled + ", wickdryOn=" + this.wickdryOn + ", wickdryLeftTime=" + this.wickdryLeftTime + ", wickdryLeftTimeUpdateTime=" + this.wickdryLeftTimeUpdateTime + ", wickUsage=" + this.wickUsage + ", waterShortage=" + this.waterShortage + ", autoRh=" + this.autoRh + ", timerStatus=" + this.timerStatus + ", timerDuration=" + this.timerDuration + ", timerLeftTime=" + this.timerLeftTime + ", timerLeftTimeUpdateTime=" + this.timerLeftTimeUpdateTime + ", temperatureUnit=" + this.temperatureUnit + ", oscillationState=" + this.oscillationState + ", oscillationAngle=" + this.oscillationAngle + ", oscillationDirection=" + this.oscillationDirection + ", oscillationFanSpeed=" + this.oscillationFanSpeed + ", mainMode=" + this.mainMode + ", apSubMode=" + this.apSubMode + ", apFanSpeed=" + this.apFanSpeed + ", heatSubMode=" + this.heatSubMode + ", heatFanSpeed=" + this.heatFanSpeed + ", heatAutoTmp=" + this.heatAutoTmp + ", heatEcoTmp=" + this.heatEcoTmp + ", coolSubMode=" + this.coolSubMode + ", coolFanSpeed=" + this.coolFanSpeed + ", coolAutoTag=" + this.coolAutoTag + ", coolAutoPresets=" + Arrays.toString(this.coolAutoPresets) + ", coolEcoTag=" + this.coolEcoTag + ", coolEcoPresets=" + Arrays.toString(this.coolEcoPresets) + ", mode=" + this.mode + ", humMode=" + this.humMode + ", waterLevel=" + this.waterLevel + ", dehSubMode=" + this.dehSubMode + ", waterTankFailure=" + this.waterTankFailure + ", smartSubMode=" + this.smartSubMode + ", detectCat=" + this.detectCat + ", bodyMounted=" + this.bodyMounted + ", cleanAirEta=" + this.cleanAirEta + ", panelDisplayMode=" + this.panelDisplayMode + ", hoverEnabled=" + this.hoverEnabled + ", airRefreshEnabled=" + this.airRefreshEnabled + ", airRefreshStatus=" + this.airRefreshStatus + ", airRefreshDuration=" + this.airRefreshDuration + ", airRefreshTimeStamp=" + this.airRefreshTimeStamp + ", airRefreshStartTimeStamp=" + this.airRefreshStartTimeStamp + ", airRefreshEndTimeStamp=" + this.airRefreshEndTimeStamp + ", roomType=" + this.roomType + ", nightLampBrightness=" + this.nightLampBrightness + ", nightLampSteplessBrightness=" + this.nightLampSteplessBrightness + ", wickdryDuration=" + this.wickdryDuration + ", wickdryDone=" + this.wickdryDone + ", ywrmEnabled=" + this.ywrmEnabled + ", ywrmUsage=" + this.ywrmUsage + ", alarms=" + this.alarms + ", humSubMode=" + this.humSubMode + ", use24Hour=" + this.use24Hour + ", waterInfill=" + this.waterInfill + ", sensorMode=" + this.sensorMode + ')';
        }

        public DeviceDataOnBlue(String str, String str2, String str3, String str4, String str5, Integer num, IndoorDatapoint indoorDatapoint, int i, int i2, boolean z, boolean z2, Integer num2, double[] dArr, double[] dArr2, double[] dArr3, double[] dArr4, double[] dArr5, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, Boolean bool, String str6, String str7, String str8, String str9, boolean z9, String str10, WelcomeHomeLocation welcomeHomeLocation, String str11, Boolean bool2, Integer num3, Long l, String str12, Boolean bool3, Boolean bool4, Integer num4, Long l2, Integer num5, Boolean bool5, Integer num6, Integer num7, Integer num8, Integer num9, Long l3, Integer num10, Integer num11, Integer num12, Integer num13, Integer num14, Integer num15, Integer num16, Integer num17, Integer num18, Integer num19, Double d, Double d2, Integer num20, Integer num21, Integer num22, double[] dArr6, Integer num23, double[] dArr7, Integer num24, Boolean bool6, Integer num25, Integer num26, Boolean bool7, Integer num27, Boolean bool8, Boolean bool9, Integer num28, Integer num29, Boolean bool10, Boolean bool11, Integer num30, Integer num31, Integer num32, Integer num33, Integer num34, Integer num35, Integer num36, Integer num37, Integer num38, Boolean bool12, Boolean bool13, Integer num39, List<DeviceAlarm> list, Integer num40, Boolean bool14, Boolean bool15, Integer num41) {
            double[] dArr8 = dArr;
            double[] dArr9 = dArr2;
            double[] dArr10 = dArr3;
            double[] dArr11 = dArr4;
            double[] dArr12 = dArr5;
            Intrinsics.checkNotNullParameter(str, "uuid");
            Intrinsics.checkNotNullParameter(dArr8, "pm1Ranges");
            Intrinsics.checkNotNullParameter(dArr9, "pm10Ranges");
            Intrinsics.checkNotNullParameter(dArr10, "pm25Ranges");
            Intrinsics.checkNotNullParameter(dArr11, "vocRanges");
            Intrinsics.checkNotNullParameter(dArr12, "hchoRanges");
            this.uuid = str;
            this.deviceType = str2;
            this.mcuFirmware = str3;
            this.wifiFirmare = str4;
            this.hardware = str5;
            this.connectivityStatus = num;
            this.latestSensorDataPoint = indoorDatapoint;
            this.fanSpeed = i;
            this.brightness = i2;
            this.childlock = z;
            this.autoMode = z2;
            this.filter = num2;
            this.pm1Ranges = dArr8;
            this.pm10Ranges = dArr9;
            this.pm25Ranges = dArr10;
            this.vocRanges = dArr11;
            this.hchoRanges = dArr12;
            this.standByMode = z3;
            this.ecoMode = z4;
            this.hinsMode = z5;
            this.hinsNightMode = z6;
            this.g4NightMode = z7;
            this.germShieldMode = z8;
            this.germShieldNightMode = bool;
            this.serialNumber = str6;
            this.name = str7;
            this.autoModeTrigger = str8;
            this.nightModeTrigger = str9;
            this.safetySwitch = z9;
            this.macAddress = str10;
            this.welcomeHome = welcomeHomeLocation;
            this.locationId = str11;
            this.disinfection = bool2;
            this.disinfectLeftTime = num3;
            this.disinfectLeftTimeUpdateTime = l;
            this.timezone = str12;
            this.wickdryEnabled = bool3;
            this.wickdryOn = bool4;
            this.wickdryLeftTime = num4;
            this.wickdryLeftTimeUpdateTime = l2;
            this.wickUsage = num5;
            this.waterShortage = bool5;
            this.autoRh = num6;
            this.timerStatus = num7;
            this.timerDuration = num8;
            this.timerLeftTime = num9;
            this.timerLeftTimeUpdateTime = l3;
            this.temperatureUnit = num10;
            this.oscillationState = num11;
            this.oscillationAngle = num12;
            this.oscillationDirection = num13;
            this.oscillationFanSpeed = num14;
            this.mainMode = num15;
            this.apSubMode = num16;
            this.apFanSpeed = num17;
            this.heatSubMode = num18;
            this.heatFanSpeed = num19;
            this.heatAutoTmp = d;
            this.heatEcoTmp = d2;
            this.coolSubMode = num20;
            this.coolFanSpeed = num21;
            this.coolAutoTag = num22;
            this.coolAutoPresets = dArr6;
            this.coolEcoTag = num23;
            this.coolEcoPresets = dArr7;
            this.mode = num24;
            this.humMode = bool6;
            this.waterLevel = num25;
            this.dehSubMode = num26;
            this.waterTankFailure = bool7;
            this.smartSubMode = num27;
            this.detectCat = bool8;
            this.bodyMounted = bool9;
            this.cleanAirEta = num28;
            this.panelDisplayMode = num29;
            this.hoverEnabled = bool10;
            this.airRefreshEnabled = bool11;
            this.airRefreshStatus = num30;
            this.airRefreshDuration = num31;
            this.airRefreshTimeStamp = num32;
            this.airRefreshStartTimeStamp = num33;
            this.airRefreshEndTimeStamp = num34;
            this.roomType = num35;
            this.nightLampBrightness = num36;
            this.nightLampSteplessBrightness = num37;
            this.wickdryDuration = num38;
            this.wickdryDone = bool12;
            this.ywrmEnabled = bool13;
            this.ywrmUsage = num39;
            this.alarms = list;
            this.humSubMode = num40;
            this.use24Hour = bool14;
            this.waterInfill = bool15;
            this.sensorMode = num41;
        }

        public final String getUuid() {
            return this.uuid;
        }

        public final String getDeviceType() {
            return this.deviceType;
        }

        public final String getMcuFirmware() {
            return this.mcuFirmware;
        }

        public final String getWifiFirmare() {
            return this.wifiFirmare;
        }

        public final String getHardware() {
            return this.hardware;
        }

        public final Integer getConnectivityStatus() {
            return this.connectivityStatus;
        }

        public final IndoorDatapoint getLatestSensorDataPoint() {
            return this.latestSensorDataPoint;
        }

        public final int getFanSpeed() {
            return this.fanSpeed;
        }

        public final int getBrightness() {
            return this.brightness;
        }

        public final boolean getChildlock() {
            return this.childlock;
        }

        public final boolean getAutoMode() {
            return this.autoMode;
        }

        public final Integer getFilter() {
            return this.filter;
        }

        public final double[] getPm1Ranges() {
            return this.pm1Ranges;
        }

        public final double[] getPm10Ranges() {
            return this.pm10Ranges;
        }

        public final double[] getPm25Ranges() {
            return this.pm25Ranges;
        }

        public final double[] getVocRanges() {
            return this.vocRanges;
        }

        public final double[] getHchoRanges() {
            return this.hchoRanges;
        }

        public final boolean getStandByMode() {
            return this.standByMode;
        }

        public final boolean getEcoMode() {
            return this.ecoMode;
        }

        public final boolean getHinsMode() {
            return this.hinsMode;
        }

        public final boolean getHinsNightMode() {
            return this.hinsNightMode;
        }

        public final boolean getG4NightMode() {
            return this.g4NightMode;
        }

        public final boolean getGermShieldMode() {
            return this.germShieldMode;
        }

        public final Boolean getGermShieldNightMode() {
            return this.germShieldNightMode;
        }

        public final String getSerialNumber() {
            return this.serialNumber;
        }

        public final String getName() {
            return this.name;
        }

        public final String getAutoModeTrigger() {
            return this.autoModeTrigger;
        }

        public final String getNightModeTrigger() {
            return this.nightModeTrigger;
        }

        public final boolean getSafetySwitch() {
            return this.safetySwitch;
        }

        public final String getMacAddress() {
            return this.macAddress;
        }

        public final WelcomeHomeLocation getWelcomeHome() {
            return this.welcomeHome;
        }

        public final String getLocationId() {
            return this.locationId;
        }

        public final Boolean getDisinfection() {
            return this.disinfection;
        }

        public final Integer getDisinfectLeftTime() {
            return this.disinfectLeftTime;
        }

        public final Long getDisinfectLeftTimeUpdateTime() {
            return this.disinfectLeftTimeUpdateTime;
        }

        public final String getTimezone() {
            return this.timezone;
        }

        public final Boolean getWickdryEnabled() {
            return this.wickdryEnabled;
        }

        public final Boolean getWickdryOn() {
            return this.wickdryOn;
        }

        public final Integer getWickdryLeftTime() {
            return this.wickdryLeftTime;
        }

        public final Long getWickdryLeftTimeUpdateTime() {
            return this.wickdryLeftTimeUpdateTime;
        }

        public final Integer getWickUsage() {
            return this.wickUsage;
        }

        public final Boolean getWaterShortage() {
            return this.waterShortage;
        }

        public final Integer getAutoRh() {
            return this.autoRh;
        }

        public final Integer getTimerStatus() {
            return this.timerStatus;
        }

        public final Integer getTimerDuration() {
            return this.timerDuration;
        }

        public final Integer getTimerLeftTime() {
            return this.timerLeftTime;
        }

        public final Long getTimerLeftTimeUpdateTime() {
            return this.timerLeftTimeUpdateTime;
        }

        public final Integer getTemperatureUnit() {
            return this.temperatureUnit;
        }

        public final Integer getOscillationState() {
            return this.oscillationState;
        }

        public final Integer getOscillationAngle() {
            return this.oscillationAngle;
        }

        public final Integer getOscillationDirection() {
            return this.oscillationDirection;
        }

        public final Integer getOscillationFanSpeed() {
            return this.oscillationFanSpeed;
        }

        public final Integer getMainMode() {
            return this.mainMode;
        }

        public final Integer getApSubMode() {
            return this.apSubMode;
        }

        public final Integer getApFanSpeed() {
            return this.apFanSpeed;
        }

        public final Integer getHeatSubMode() {
            return this.heatSubMode;
        }

        public final Integer getHeatFanSpeed() {
            return this.heatFanSpeed;
        }

        public final Double getHeatAutoTmp() {
            return this.heatAutoTmp;
        }

        public final Double getHeatEcoTmp() {
            return this.heatEcoTmp;
        }

        public final Integer getCoolSubMode() {
            return this.coolSubMode;
        }

        public final Integer getCoolFanSpeed() {
            return this.coolFanSpeed;
        }

        public final Integer getCoolAutoTag() {
            return this.coolAutoTag;
        }

        public final double[] getCoolAutoPresets() {
            return this.coolAutoPresets;
        }

        public final Integer getCoolEcoTag() {
            return this.coolEcoTag;
        }

        public final double[] getCoolEcoPresets() {
            return this.coolEcoPresets;
        }

        public final Integer getMode() {
            return this.mode;
        }

        public final Boolean getHumMode() {
            return this.humMode;
        }

        public final Integer getWaterLevel() {
            return this.waterLevel;
        }

        public final Integer getDehSubMode() {
            return this.dehSubMode;
        }

        public final Boolean getWaterTankFailure() {
            return this.waterTankFailure;
        }

        public final Integer getSmartSubMode() {
            return this.smartSubMode;
        }

        public final Boolean getDetectCat() {
            return this.detectCat;
        }

        public final Boolean getBodyMounted() {
            return this.bodyMounted;
        }

        public final Integer getCleanAirEta() {
            return this.cleanAirEta;
        }

        public final Integer getPanelDisplayMode() {
            return this.panelDisplayMode;
        }

        public final Boolean getHoverEnabled() {
            return this.hoverEnabled;
        }

        public final Boolean getAirRefreshEnabled() {
            return this.airRefreshEnabled;
        }

        public final Integer getAirRefreshStatus() {
            return this.airRefreshStatus;
        }

        public final Integer getAirRefreshDuration() {
            return this.airRefreshDuration;
        }

        public final Integer getAirRefreshTimeStamp() {
            return this.airRefreshTimeStamp;
        }

        public final Integer getAirRefreshStartTimeStamp() {
            return this.airRefreshStartTimeStamp;
        }

        public final Integer getAirRefreshEndTimeStamp() {
            return this.airRefreshEndTimeStamp;
        }

        public final Integer getRoomType() {
            return this.roomType;
        }

        public final Integer getNightLampBrightness() {
            return this.nightLampBrightness;
        }

        public final Integer getNightLampSteplessBrightness() {
            return this.nightLampSteplessBrightness;
        }

        public final Integer getWickdryDuration() {
            return this.wickdryDuration;
        }

        public final Boolean getWickdryDone() {
            return this.wickdryDone;
        }

        public final Boolean getYwrmEnabled() {
            return this.ywrmEnabled;
        }

        public final Integer getYwrmUsage() {
            return this.ywrmUsage;
        }

        public final List<DeviceAlarm> getAlarms() {
            return this.alarms;
        }

        public final Integer getHumSubMode() {
            return this.humSubMode;
        }

        public final Boolean getUse24Hour() {
            return this.use24Hour;
        }

        public final Boolean getWaterInfill() {
            return this.waterInfill;
        }

        public final Integer getSensorMode() {
            return this.sensorMode;
        }
    }
}
