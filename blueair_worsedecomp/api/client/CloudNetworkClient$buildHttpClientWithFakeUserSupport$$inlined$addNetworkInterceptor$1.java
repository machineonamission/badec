package com.blueair.api.client;

import com.blueair.core.AblEnvironment;
import com.foobot.liblabclient.ApiClient;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Credentials;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "intercept", "okhttp3/OkHttpClient$Builder$addNetworkInterceptor$2"}, k = 3, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.blueair.api.client.CloudNetworkClient$buildHttpClientWithFakeUserSupport$$inlined$-addNetworkInterceptor$1  reason: invalid class name */
/* compiled from: OkHttpClient.kt */
public final class CloudNetworkClient$buildHttpClientWithFakeUserSupport$$inlined$addNetworkInterceptor$1 implements Interceptor {
    final /* synthetic */ boolean $isAbl$inlined;
    final /* synthetic */ CloudNetworkClient this$0;

    public CloudNetworkClient$buildHttpClientWithFakeUserSupport$$inlined$addNetworkInterceptor$1(boolean z, CloudNetworkClient cloudNetworkClient) {
        this.$isAbl$inlined = z;
        this.this$0 = cloudNetworkClient;
    }

    public final Response intercept(Interceptor.Chain chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request request = chain.request();
        Request.Builder method = request.newBuilder().method(request.method(), request.body());
        if (this.$isAbl$inlined) {
            method.addHeader(ApiClient.AK_TOKEN_HEADER, AblEnvironment.INSTANCE.getApiKey());
            if (this.this$0.getAuthService().isUserLoggedIn().getValue().booleanValue()) {
                method.addHeader("Authorization", "Bearer " + this.this$0.getAuthService().getGigyaJwt());
            } else {
                method.addHeader("Authorization", Credentials.basic$default("blueairoutdoor@gmail.com", "outdoordata", (Charset) null, 4, (Object) null));
            }
        }
        return chain.proceed(method.build());
    }
}
