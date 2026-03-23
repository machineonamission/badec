package com.blueair.api.client;

import android.content.res.Resources;
import com.blueair.api.R;
import com.blueair.api.client.BaseNetworkClient;
import com.blueair.api.model.ProvisionRequestBody;
import com.blueair.api.restapi.ProvisioningWifiRestApi;
import com.blueair.auth.AuthService;
import com.blueair.core.BuildEnvironment;
import com.blueair.core.BuildVariant;
import com.blueair.core.model.DeviceUuid;
import com.blueair.core.model.Ipv4;
import com.blueair.core.util.HttpsTrustUtils;
import io.flatcircle.coroutinehelper.ApiResult;
import java.security.cert.Certificate;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.Triple;
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

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B5\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\u0014\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(H@¢\u0006\u0002\u0010*J\u001a\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020-0,0(H@¢\u0006\u0002\u0010*J\u001c\u0010.\u001a\b\u0012\u0004\u0012\u00020/0(2\u0006\u00100\u001a\u000201H@¢\u0006\u0002\u00102J\"\u00103\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002040,0(2\u0006\u00100\u001a\u000205H@¢\u0006\u0002\u00106J\u001c\u00107\u001a\b\u0012\u0004\u0012\u00020\u00060(2\u0006\u00108\u001a\u00020)H@¢\u0006\u0002\u00109J\u0014\u0010:\u001a\b\u0012\u0004\u0012\u00020;0(H@¢\u0006\u0002\u0010*J\b\u0010<\u001a\u00020=H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0011\"\u0004\b\u001a\u0010\u0013R\u0014\u0010\u001b\u001a\u00020\u001c8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\u00020 8VX\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0014\u0010#\u001a\u00020$8VX\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&¨\u0006>"}, d2 = {"Lcom/blueair/api/client/WifiDeviceClient;", "Lcom/blueair/api/client/WifiNetworkClient;", "Lcom/blueair/api/client/CanProvisionLocal;", "resources", "Landroid/content/res/Resources;", "deviceUuid", "", "deviceJwt", "authService", "Lcom/blueair/auth/AuthService;", "mockInterceptor", "Lokhttp3/Interceptor;", "<init>", "(Landroid/content/res/Resources;Ljava/lang/String;Ljava/lang/String;Lcom/blueair/auth/AuthService;Lokhttp3/Interceptor;)V", "getResources", "()Landroid/content/res/Resources;", "getDeviceUuid", "()Ljava/lang/String;", "setDeviceUuid", "(Ljava/lang/String;)V", "getDeviceJwt", "setDeviceJwt", "getMockInterceptor", "()Lokhttp3/Interceptor;", "baseUrl", "getBaseUrl", "setBaseUrl", "okHttpClient", "Lokhttp3/OkHttpClient;", "getOkHttpClient", "()Lokhttp3/OkHttpClient;", "retrofit", "Lretrofit2/Retrofit;", "getRetrofit", "()Lretrofit2/Retrofit;", "provisioningWifiRestApi", "Lcom/blueair/api/restapi/ProvisioningWifiRestApi;", "getProvisioningWifiRestApi", "()Lcom/blueair/api/restapi/ProvisioningWifiRestApi;", "getUuid", "Lio/flatcircle/coroutinehelper/ApiResult;", "Lcom/blueair/core/model/DeviceUuid;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSsids", "", "Lcom/blueair/core/model/Ssid;", "provisionDevice", "Lcom/blueair/api/model/ProvisionRequestBody;", "body", "Lcom/blueair/api/client/ProvisionBody;", "(Lcom/blueair/api/client/ProvisionBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getOnboardingEvents", "Lcom/blueair/core/model/DeviceEvent;", "Lcom/blueair/api/client/OnboardingEventsBody;", "(Lcom/blueair/api/client/OnboardingEventsBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resetDevice", "ipInfo", "(Lcom/blueair/core/model/DeviceUuid;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "switchOffSoftAp", "", "clear", "", "api_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: WifiDeviceClient.kt */
public final class WifiDeviceClient implements WifiNetworkClient, CanProvisionLocal {
    private final AuthService authService;
    private String baseUrl;
    private String deviceJwt;
    private String deviceUuid;
    private final Interceptor mockInterceptor;
    private final Resources resources;

    public void clear() {
    }

    public WifiDeviceClient(Resources resources2, String str, String str2, AuthService authService2, Interceptor interceptor) {
        Intrinsics.checkNotNullParameter(resources2, "resources");
        Intrinsics.checkNotNullParameter(str, "deviceUuid");
        Intrinsics.checkNotNullParameter(str2, "deviceJwt");
        Intrinsics.checkNotNullParameter(authService2, "authService");
        this.resources = resources2;
        this.deviceUuid = str;
        this.deviceJwt = str2;
        this.authService = authService2;
        this.mockInterceptor = interceptor;
        this.baseUrl = "https://192.168.4.1/";
    }

    public <T> Object awaitAllCalls(List<BaseNetworkClient.CallWithInput<T>> list, Continuation<? super ApiResult<List<T>>> continuation) {
        return BaseNetworkClient.CC.$default$awaitAllCalls(this, list, continuation);
    }

    public <T> Object awaitCall(Deferred<? extends T> deferred, Continuation<? super ApiResult<T>> continuation) {
        return BaseNetworkClient.CC.$default$awaitCall(this, deferred, continuation);
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

    public String getDeviceUuid() {
        return this.deviceUuid;
    }

    public void setDeviceUuid(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.deviceUuid = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WifiDeviceClient(Resources resources2, String str, String str2, AuthService authService2, Interceptor interceptor, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(resources2, str, (i & 4) != 0 ? "" : str2, authService2, (i & 16) != 0 ? null : interceptor);
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

    public final String getBaseUrl() {
        return this.baseUrl;
    }

    public final void setBaseUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.baseUrl = str;
    }

    public OkHttpClient getOkHttpClient() {
        HttpLoggingInterceptor.Level level;
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor((HttpLoggingInterceptor.Logger) null, 1, (DefaultConstructorMarker) null);
        if (BuildEnvironment.INSTANCE.getVariant() == BuildVariant.RELEASE) {
            level = HttpLoggingInterceptor.Level.NONE;
        } else {
            level = HttpLoggingInterceptor.Level.BODY;
        }
        httpLoggingInterceptor.setLevel(level);
        Triple<X509TrustManager, SSLSocketFactory, Collection<Certificate>> trustSslDetailsFor = HttpsTrustUtils.INSTANCE.getTrustSslDetailsFor(getResources(), R.raw.g4cacert);
        X509TrustManager component1 = trustSslDetailsFor.component1();
        SSLSocketFactory component2 = trustSslDetailsFor.component2();
        Collection component3 = trustSslDetailsFor.component3();
        OkHttpClient.Builder writeTimeout = new OkHttpClient.Builder().addNetworkInterceptor(new WifiDeviceClient$special$$inlined$addNetworkInterceptor$1(this)).addInterceptor(httpLoggingInterceptor).connectTimeout(45, TimeUnit.SECONDS).readTimeout(30, TimeUnit.SECONDS).writeTimeout(30, TimeUnit.SECONDS);
        if (component1 == null) {
            Interceptor mockInterceptor2 = getMockInterceptor();
            Intrinsics.checkNotNull(mockInterceptor2);
            return writeTimeout.addInterceptor(mockInterceptor2).build();
        }
        Intrinsics.checkNotNull(component2);
        OkHttpClient.Builder sslSocketFactory = writeTimeout.sslSocketFactory(component2, component1);
        Intrinsics.checkNotNull(component3);
        return sslSocketFactory.hostnameVerifier(new HttpsTrustUtils.CertificateOnlyHostnameVerifier(component3)).build();
    }

    public Retrofit getRetrofit() {
        return retroFitFactory(this.baseUrl);
    }

    public ProvisioningWifiRestApi getProvisioningWifiRestApi() {
        Object create = getRetrofit().create(ProvisioningWifiRestApi.class);
        Intrinsics.checkNotNullExpressionValue(create, "create(...)");
        return (ProvisioningWifiRestApi) create;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0052, code lost:
        r1 = r1.getUuid();
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object getUuid(kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<com.blueair.core.model.DeviceUuid>> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.blueair.api.client.WifiDeviceClient$getUuid$1
            if (r0 == 0) goto L_0x0014
            r0 = r5
            com.blueair.api.client.WifiDeviceClient$getUuid$1 r0 = (com.blueair.api.client.WifiDeviceClient$getUuid$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r5 = r0.label
            int r5 = r5 - r2
            r0.label = r5
            goto L_0x0019
        L_0x0014:
            com.blueair.api.client.WifiDeviceClient$getUuid$1 r0 = new com.blueair.api.client.WifiDeviceClient$getUuid$1
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
            com.blueair.api.restapi.ProvisioningWifiRestApi r5 = r4.getProvisioningWifiRestApi()
            kotlinx.coroutines.Deferred r5 = r5.getUuid()
            r0.label = r3
            java.lang.Object r5 = r4.awaitCall(r5, r0)
            if (r5 != r1) goto L_0x0046
            return r1
        L_0x0046:
            io.flatcircle.coroutinehelper.ApiResult r5 = (io.flatcircle.coroutinehelper.ApiResult) r5
            io.flatcircle.coroutinehelper.ApiResult$Companion r0 = io.flatcircle.coroutinehelper.ApiResult.Companion
            java.lang.Object r1 = r5.getOrNull()
            com.blueair.api.restapi.ProvisioningWifiRestApi$UuidWrapper r1 = (com.blueair.api.restapi.ProvisioningWifiRestApi.UuidWrapper) r1
            if (r1 == 0) goto L_0x0060
            java.util.List r1 = r1.getUuid()
            if (r1 == 0) goto L_0x0060
            r2 = 0
            java.lang.Object r1 = r1.get(r2)
            com.blueair.core.model.DeviceUuid r1 = (com.blueair.core.model.DeviceUuid) r1
            goto L_0x0061
        L_0x0060:
            r1 = 0
        L_0x0061:
            io.flatcircle.coroutinehelper.ApiResult r5 = r0.fromResult(r5, r1)
            java.lang.Object r0 = r5.getOrNull()
            com.blueair.core.model.DeviceUuid r0 = (com.blueair.core.model.DeviceUuid) r0
            if (r0 != 0) goto L_0x0070
            java.lang.String r0 = ""
            goto L_0x0074
        L_0x0070:
            java.lang.String r0 = r0.getUuid()
        L_0x0074:
            r4.setDeviceUuid(r0)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.client.WifiDeviceClient.getUuid(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object getSsids(kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<java.util.List<com.blueair.core.model.Ssid>>> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.blueair.api.client.WifiDeviceClient$getSsids$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            com.blueair.api.client.WifiDeviceClient$getSsids$1 r0 = (com.blueair.api.client.WifiDeviceClient$getSsids$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            com.blueair.api.client.WifiDeviceClient$getSsids$1 r0 = new com.blueair.api.client.WifiDeviceClient$getSsids$1
            r0.<init>(r5, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0070
        L_0x002a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r6)
            java.lang.String r6 = r5.getDeviceUuid()
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            int r6 = r6.length()
            if (r6 <= 0) goto L_0x0087
            timber.log.Timber$Forest r6 = timber.log.Timber.Forest
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r4 = "Getting ssids from "
            r2.<init>(r4)
            java.lang.String r4 = r5.getDeviceUuid()
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            r4 = 0
            java.lang.Object[] r4 = new java.lang.Object[r4]
            r6.v(r2, r4)
            com.blueair.api.restapi.ProvisioningWifiRestApi r6 = r5.getProvisioningWifiRestApi()
            java.lang.String r2 = r5.getDeviceUuid()
            kotlinx.coroutines.Deferred r6 = r6.getSsids(r2)
            r0.label = r3
            java.lang.Object r6 = r5.awaitCall(r6, r0)
            if (r6 != r1) goto L_0x0070
            return r1
        L_0x0070:
            io.flatcircle.coroutinehelper.ApiResult r6 = (io.flatcircle.coroutinehelper.ApiResult) r6
            io.flatcircle.coroutinehelper.ApiResult$Companion r0 = io.flatcircle.coroutinehelper.ApiResult.Companion
            java.lang.Object r1 = r6.getOrNull()
            com.blueair.api.restapi.ProvisioningWifiRestApi$SsidWrapper r1 = (com.blueair.api.restapi.ProvisioningWifiRestApi.SsidWrapper) r1
            if (r1 == 0) goto L_0x0081
            java.util.List r1 = r1.getNetwork()
            goto L_0x0082
        L_0x0081:
            r1 = 0
        L_0x0082:
            io.flatcircle.coroutinehelper.ApiResult r6 = r0.fromResult(r6, r1)
            return r6
        L_0x0087:
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "Failed requirement."
            java.lang.String r0 = r0.toString()
            r6.<init>(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.client.WifiDeviceClient.getSsids(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public Object provisionDevice(ProvisionBody provisionBody, Continuation<? super ApiResult<ProvisionRequestBody>> continuation) {
        if (getDeviceUuid().length() <= 0) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        } else if (provisionBody.getSsid().length() <= 0) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        } else if (provisionBody.getBssid().length() <= 0) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        } else if (provisionBody.getPassword().length() <= 0) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        } else if (provisionBody.getRand().length() <= 0) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        } else if (provisionBody.getText().length() > 0) {
            Timber.Forest.v("Provisioning device for " + getDeviceUuid(), new Object[0]);
            return awaitCall(getProvisioningWifiRestApi().provisionDevice(getDeviceUuid(), new ProvisionRequestBody(provisionBody.getSsid(), provisionBody.getBssid(), provisionBody.getPassword(), this.authService.getBlueHomeHost(), this.authService.getBlueHomeHost() + "c/authenticate", this.authService.getBlueBrokerURL(), (String) null, provisionBody.getText(), provisionBody.getRand(), 64, (DefaultConstructorMarker) null)), continuation);
        } else {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object getOnboardingEvents(com.blueair.api.client.OnboardingEventsBody r6, kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<java.util.List<com.blueair.core.model.DeviceEvent>>> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.blueair.api.client.WifiDeviceClient$getOnboardingEvents$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            com.blueair.api.client.WifiDeviceClient$getOnboardingEvents$1 r0 = (com.blueair.api.client.WifiDeviceClient$getOnboardingEvents$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            com.blueair.api.client.WifiDeviceClient$getOnboardingEvents$1 r0 = new com.blueair.api.client.WifiDeviceClient$getOnboardingEvents$1
            r0.<init>(r5, r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r6 = r0.L$0
            com.blueair.api.client.OnboardingEventsBody r6 = (com.blueair.api.client.OnboardingEventsBody) r6
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0088
        L_0x002e:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r7)
            timber.log.Timber$Forest r7 = timber.log.Timber.Forest
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r4 = "Getting onboardingEvent for "
            r2.<init>(r4)
            java.lang.String r4 = r5.getDeviceUuid()
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            r4 = 0
            java.lang.Object[] r4 = new java.lang.Object[r4]
            r7.v(r2, r4)
            com.blueair.core.model.OnboardingError r7 = r6.getOnboardingError()
            if (r7 == 0) goto L_0x006d
            io.flatcircle.coroutinehelper.Success r7 = new io.flatcircle.coroutinehelper.Success
            com.blueair.api.MockingUtils r0 = com.blueair.api.MockingUtils.INSTANCE
            int r1 = r6.getIteration()
            com.blueair.core.model.OnboardingError r6 = r6.getOnboardingError()
            java.util.List r6 = r0.onboardingEvents(r1, r6)
            r7.<init>(r6)
            return r7
        L_0x006d:
            com.blueair.api.restapi.ProvisioningWifiRestApi r7 = r5.getProvisioningWifiRestApi()
            java.lang.String r2 = r5.getDeviceUuid()
            kotlinx.coroutines.Deferred r7 = r7.getOnboardingEventQueue(r2)
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r7 = r5.awaitCall(r7, r0)
            if (r7 != r1) goto L_0x0088
            return r1
        L_0x0088:
            io.flatcircle.coroutinehelper.ApiResult r7 = (io.flatcircle.coroutinehelper.ApiResult) r7
            io.flatcircle.coroutinehelper.ApiResult$Companion r6 = io.flatcircle.coroutinehelper.ApiResult.Companion
            java.lang.Object r0 = r7.getOrNull()
            com.blueair.api.restapi.ProvisioningWifiRestApi$DeviceEventWrapper r0 = (com.blueair.api.restapi.ProvisioningWifiRestApi.DeviceEventWrapper) r0
            if (r0 == 0) goto L_0x0099
            java.util.List r0 = r0.getEvents()
            goto L_0x009a
        L_0x0099:
            r0 = 0
        L_0x009a:
            io.flatcircle.coroutinehelper.ApiResult r6 = r6.fromResult(r7, r0)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.client.WifiDeviceClient.getOnboardingEvents(com.blueair.api.client.OnboardingEventsBody, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public Object resetDevice(DeviceUuid deviceUuid2, Continuation<? super ApiResult<String>> continuation) {
        if (getDeviceUuid().length() > 0) {
            Ipv4 ipv4 = deviceUuid2.getIpv4();
            if ((ipv4 != null ? ipv4.getIp() : null) != null) {
                Timber.Forest forest = Timber.Forest;
                forest.v("resetting access point for " + getDeviceUuid(), new Object[0]);
                ProvisioningWifiRestApi provisioningWifiRestApi = getProvisioningWifiRestApi();
                Ipv4 ipv42 = deviceUuid2.getIpv4();
                Intrinsics.checkNotNull(ipv42);
                String ip = ipv42.getIp();
                Intrinsics.checkNotNull(ip);
                return awaitCall(provisioningWifiRestApi.resetDevice(ip, getDeviceUuid()), continuation);
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public Object switchOffSoftAp(Continuation<? super ApiResult<Object>> continuation) {
        if (getDeviceUuid().length() > 0) {
            Timber.Forest forest = Timber.Forest;
            forest.v("Switching off access point for " + getDeviceUuid(), new Object[0]);
            return awaitCall(ProvisioningWifiRestApi.CC.switchOffSoftAp$default(getProvisioningWifiRestApi(), getDeviceUuid(), (ProvisioningWifiRestApi.SwitchOffSoftApBody) null, 2, (Object) null), continuation);
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }
}
