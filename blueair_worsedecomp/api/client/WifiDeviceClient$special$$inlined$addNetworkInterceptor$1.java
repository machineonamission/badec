package com.blueair.api.client;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "intercept", "okhttp3/OkHttpClient$Builder$addNetworkInterceptor$2"}, k = 3, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.blueair.api.client.WifiDeviceClient$special$$inlined$-addNetworkInterceptor$1  reason: invalid class name */
/* compiled from: OkHttpClient.kt */
public final class WifiDeviceClient$special$$inlined$addNetworkInterceptor$1 implements Interceptor {
    final /* synthetic */ WifiDeviceClient this$0;

    public WifiDeviceClient$special$$inlined$addNetworkInterceptor$1(WifiDeviceClient wifiDeviceClient) {
        this.this$0 = wifiDeviceClient;
    }

    public final Response intercept(Interceptor.Chain chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request request = chain.request();
        Request.Builder method = request.newBuilder().method(request.method(), request.body());
        method.addHeader("Authorization", "Bearer " + this.this$0.getDeviceJwt());
        return chain.proceed(method.build());
    }
}
