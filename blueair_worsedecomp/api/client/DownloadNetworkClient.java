package com.blueair.api.client;

import android.content.res.Resources;
import com.blueair.api.client.BaseNetworkClient;
import com.blueair.core.AblEnvironment;
import com.blueair.core.BuildEnvironment;
import com.blueair.core.BuildVariant;
import com.foobot.liblabclient.ApiClient;
import io.flatcircle.coroutinehelper.ApiResult;
import java.io.InputStream;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Deferred;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Response;
import retrofit2.Retrofit;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0014\u0010\u001a\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0012\u0004\u0012\u00020\u00170\u001bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\f\u001a\u00020\r8VX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u00138VX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001d"}, d2 = {"Lcom/blueair/api/client/DownloadNetworkClient;", "Lcom/blueair/api/client/BaseNetworkClient;", "resources", "Landroid/content/res/Resources;", "mockInterceptor", "Lokhttp3/Interceptor;", "<init>", "(Landroid/content/res/Resources;Lokhttp3/Interceptor;)V", "getResources", "()Landroid/content/res/Resources;", "getMockInterceptor", "()Lokhttp3/Interceptor;", "okHttpClient", "Lokhttp3/OkHttpClient;", "getOkHttpClient", "()Lokhttp3/OkHttpClient;", "okHttpClient$delegate", "Lkotlin/Lazy;", "retrofit", "Lretrofit2/Retrofit;", "getRetrofit", "()Lretrofit2/Retrofit;", "downloadFromUrl", "", "url", "", "callback", "Lkotlin/Function1;", "Ljava/io/InputStream;", "api_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DownloadNetworkClient.kt */
public final class DownloadNetworkClient implements BaseNetworkClient {
    private final Interceptor mockInterceptor;
    private final Lazy okHttpClient$delegate;
    private final Resources resources;

    public DownloadNetworkClient(Resources resources2, Interceptor interceptor) {
        Intrinsics.checkNotNullParameter(resources2, "resources");
        this.resources = resources2;
        this.mockInterceptor = interceptor;
        this.okHttpClient$delegate = LazyKt.lazy(new DownloadNetworkClient$$ExternalSyntheticLambda1());
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DownloadNetworkClient(Resources resources2, Interceptor interceptor, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(resources2, (i & 2) != 0 ? null : interceptor);
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

    public Interceptor getMockInterceptor() {
        return this.mockInterceptor;
    }

    public OkHttpClient getOkHttpClient() {
        return (OkHttpClient) this.okHttpClient$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final OkHttpClient okHttpClient_delegate$lambda$1() {
        HttpLoggingInterceptor.Level level;
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor((HttpLoggingInterceptor.Logger) null, 1, (DefaultConstructorMarker) null);
        if (BuildEnvironment.INSTANCE.getVariant() == BuildVariant.RELEASE) {
            level = HttpLoggingInterceptor.Level.NONE;
        } else {
            level = HttpLoggingInterceptor.Level.BODY;
        }
        httpLoggingInterceptor.setLevel(level);
        return new OkHttpClient.Builder().addInterceptor(new DownloadNetworkClient$$ExternalSyntheticLambda0()).addInterceptor(httpLoggingInterceptor).build();
    }

    /* access modifiers changed from: private */
    public static final okhttp3.Response okHttpClient_delegate$lambda$1$lambda$0(Interceptor.Chain chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        return chain.proceed(chain.request().newBuilder().addHeader(ApiClient.AK_TOKEN_HEADER, AblEnvironment.INSTANCE.getApiKey()).build());
    }

    public Retrofit getRetrofit() {
        return retroFitFactory("http://api-nc.foobot.io");
    }

    public final void downloadFromUrl(String str, Function1<? super InputStream, Unit> function1) {
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(function1, "callback");
        new OkHttpClient().newCall(new Request.Builder().url(str).build()).enqueue(new DownloadNetworkClient$downloadFromUrl$1(function1));
    }
}
