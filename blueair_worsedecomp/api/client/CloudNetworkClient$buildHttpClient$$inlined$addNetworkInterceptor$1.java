package com.blueair.api.client;

import kotlin.Metadata;
import okhttp3.Interceptor;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "intercept", "okhttp3/OkHttpClient$Builder$addNetworkInterceptor$2"}, k = 3, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.blueair.api.client.CloudNetworkClient$buildHttpClient$$inlined$-addNetworkInterceptor$1  reason: invalid class name */
/* compiled from: OkHttpClient.kt */
public final class CloudNetworkClient$buildHttpClient$$inlined$addNetworkInterceptor$1 implements Interceptor {
    final /* synthetic */ boolean $isAbl$inlined;
    final /* synthetic */ CloudNetworkClient this$0;

    public CloudNetworkClient$buildHttpClient$$inlined$addNetworkInterceptor$1(boolean z, CloudNetworkClient cloudNetworkClient) {
        this.$isAbl$inlined = z;
        this.this$0 = cloudNetworkClient;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0010, code lost:
        r0 = r0.socket();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final okhttp3.Response intercept(okhttp3.Interceptor.Chain r9) {
        /*
            r8 = this;
            java.lang.String r0 = "chain"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            com.blueair.core.util.UserInfoCollectionsManager r1 = com.blueair.core.util.UserInfoCollectionsManager.INSTANCE
            com.blueair.core.model.UserInfoItem r2 = com.blueair.core.model.UserInfoItem.NET_IP
            okhttp3.Connection r0 = r9.connection()
            r7 = 0
            if (r0 == 0) goto L_0x001b
            java.net.Socket r0 = r0.socket()
            if (r0 == 0) goto L_0x001b
            java.net.InetAddress r0 = r0.getLocalAddress()
            goto L_0x001c
        L_0x001b:
            r0 = r7
        L_0x001c:
            java.lang.String r3 = java.lang.String.valueOf(r0)
            r5 = 4
            r6 = 0
            r4 = 0
            com.blueair.core.util.UserInfoCollectionsManager.addRecord$default(r1, r2, r3, r4, r5, r6)
            okhttp3.Request r0 = r9.request()
            okhttp3.Request$Builder r1 = r0.newBuilder()
            java.lang.String r2 = r0.method()
            okhttp3.RequestBody r0 = r0.body()
            okhttp3.Request$Builder r0 = r1.method(r2, r0)
            boolean r1 = r8.$isAbl$inlined
            java.lang.String r2 = "Bearer "
            java.lang.String r3 = "Authorization"
            if (r1 == 0) goto L_0x0067
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r2)
            com.blueair.api.client.CloudNetworkClient r2 = r8.this$0
            com.blueair.auth.AuthService r2 = r2.getAuthService()
            java.lang.String r2 = r2.getGigyaJwt()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.addHeader(r3, r1)
            com.blueair.core.AblEnvironment r1 = com.blueair.core.AblEnvironment.INSTANCE
            java.lang.String r1 = r1.getApiKey()
            java.lang.String r2 = "X-API-KEY-TOKEN"
            r0.addHeader(r2, r1)
            goto L_0x008d
        L_0x0067:
            java.lang.String r1 = "X-Source"
            java.lang.String r4 = "android"
            r0.addHeader(r1, r4)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r2)
            com.blueair.api.client.CloudNetworkClient$buildHttpClient$builder$1$1 r2 = new com.blueair.api.client.CloudNetworkClient$buildHttpClient$builder$1$1
            com.blueair.api.client.CloudNetworkClient r4 = r8.this$0
            r2.<init>(r4, r7)
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            r4 = 1
            java.lang.Object r2 = kotlinx.coroutines.BuildersKt__BuildersKt.runBlocking$default(r7, r2, r4, r7)
            java.lang.String r2 = (java.lang.String) r2
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.addHeader(r3, r1)
        L_0x008d:
            okhttp3.Request r0 = r0.build()
            java.lang.String r1 = r0.header(r3)
            if (r1 == 0) goto L_0x00a1
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            java.lang.CharSequence r1 = kotlin.text.StringsKt.trim((java.lang.CharSequence) r1)
            java.lang.String r7 = r1.toString()
        L_0x00a1:
            java.lang.String r1 = "Bearer"
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r1)
            if (r1 == 0) goto L_0x00b0
            okhttp3.Call r1 = r9.call()
            r1.cancel()
        L_0x00b0:
            okhttp3.Response r9 = r9.proceed(r0)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.client.CloudNetworkClient$buildHttpClient$$inlined$addNetworkInterceptor$1.intercept(okhttp3.Interceptor$Chain):okhttp3.Response");
    }
}
