package com.blueair.api.client;

import android.content.res.Resources;
import com.blueair.core.AblEnvironment;
import com.blueair.core.BuildEnvironment;
import com.blueair.core.BuildVariant;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Deferred;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import retrofit2.Retrofit;

@Metadata(
   d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0014\u0010\u001a\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0012\u0004\u0012\u00020\u00170\u001bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\f\u001a\u00020\r8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001d"},
   d2 = {"Lcom/blueair/api/client/DownloadNetworkClient;", "Lcom/blueair/api/client/BaseNetworkClient;", "resources", "Landroid/content/res/Resources;", "mockInterceptor", "Lokhttp3/Interceptor;", "<init>", "(Landroid/content/res/Resources;Lokhttp3/Interceptor;)V", "getResources", "()Landroid/content/res/Resources;", "getMockInterceptor", "()Lokhttp3/Interceptor;", "okHttpClient", "Lokhttp3/OkHttpClient;", "getOkHttpClient", "()Lokhttp3/OkHttpClient;", "okHttpClient$delegate", "Lkotlin/Lazy;", "retrofit", "Lretrofit2/Retrofit;", "getRetrofit", "()Lretrofit2/Retrofit;", "downloadFromUrl", "", "url", "", "callback", "Lkotlin/Function1;", "Ljava/io/InputStream;", "api_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DownloadNetworkClient implements BaseNetworkClient {
   private final Interceptor mockInterceptor;
   private final Lazy okHttpClient$delegate;
   private final Resources resources;

   // $FF: synthetic method
   public static OkHttpClient $r8$lambda$T89AkUmd53KDO8oARTNupxWU1_I() {
      return okHttpClient_delegate$lambda$1();
   }

   // $FF: synthetic method
   public static Response $r8$lambda$gpAX1JRpAQQU8qBgx19QBMqez0c(Interceptor.Chain var0) {
      return okHttpClient_delegate$lambda$1$lambda$0(var0);
   }

   public DownloadNetworkClient(Resources var1, Interceptor var2) {
      Intrinsics.checkNotNullParameter(var1, "resources");
      super();
      this.resources = var1;
      this.mockInterceptor = var2;
      this.okHttpClient$delegate = LazyKt.lazy(new DownloadNetworkClient$$ExternalSyntheticLambda1());
   }

   // $FF: synthetic method
   public DownloadNetworkClient(Resources var1, Interceptor var2, int var3, DefaultConstructorMarker var4) {
      if ((var3 & 2) != 0) {
         var2 = null;
      }

      this(var1, var2);
   }

   private static final OkHttpClient okHttpClient_delegate$lambda$1() {
      HttpLoggingInterceptor var1 = new HttpLoggingInterceptor((HttpLoggingInterceptor.Logger)null, 1, (DefaultConstructorMarker)null);
      HttpLoggingInterceptor.Level var0;
      if (BuildEnvironment.INSTANCE.getVariant() == BuildVariant.RELEASE) {
         var0 = Level.NONE;
      } else {
         var0 = Level.BODY;
      }

      var1.setLevel(var0);
      DownloadNetworkClient$$ExternalSyntheticLambda0 var2 = new DownloadNetworkClient$$ExternalSyntheticLambda0();
      return (new OkHttpClient.Builder()).addInterceptor(var2).addInterceptor((Interceptor)var1).build();
   }

   private static final Response okHttpClient_delegate$lambda$1$lambda$0(Interceptor.Chain var0) {
      Intrinsics.checkNotNullParameter(var0, "chain");
      return var0.proceed(var0.request().newBuilder().addHeader("X-API-KEY-TOKEN", AblEnvironment.INSTANCE.getApiKey()).build());
   }

   public Object awaitAllCalls(List var1, Continuation var2) {
      return BaseNetworkClient$_CC.$default$awaitAllCalls(this, var1, var2);
   }

   public Object awaitCall(Deferred var1, Continuation var2) {
      return BaseNetworkClient$_CC.$default$awaitCall(this, var1, var2);
   }

   public Object doSuspendedApiCall(Function2 var1, Object var2, Continuation var3) {
      return BaseNetworkClient$_CC.$default$doSuspendedApiCall(this, var1, var2, var3);
   }

   public Object doSuspendedApiCall(Function3 var1, Object var2, Object var3, Continuation var4) {
      return BaseNetworkClient$_CC.$default$doSuspendedApiCall(this, var1, var2, var3, var4);
   }

   public final void downloadFromUrl(String var1, Function1 var2) {
      Intrinsics.checkNotNullParameter(var1, "url");
      Intrinsics.checkNotNullParameter(var2, "callback");
      Request var3 = (new Request.Builder()).url(var1).build();
      (new OkHttpClient()).newCall(var3).enqueue(new Callback(var2) {
         final Function1 $callback;

         {
            this.$callback = var1;
         }

         public void onFailure(Call var1, IOException var2) {
            Intrinsics.checkNotNullParameter(var1, "call");
            Intrinsics.checkNotNullParameter(var2, "e");
         }

         public void onResponse(Call var1, Response var2) {
            Intrinsics.checkNotNullParameter(var1, "call");
            Intrinsics.checkNotNullParameter(var2, "response");
            ResponseBody var3 = var2.body();
            InputStream var4;
            if (var3 != null) {
               var4 = var3.byteStream();
            } else {
               var4 = null;
            }

            this.$callback.invoke(var4);
         }
      });
   }

   public Interceptor getMockInterceptor() {
      return this.mockInterceptor;
   }

   public OkHttpClient getOkHttpClient() {
      return (OkHttpClient)this.okHttpClient$delegate.getValue();
   }

   public Resources getResources() {
      return this.resources;
   }

   public Retrofit getRetrofit() {
      return this.retroFitFactory("http://api-nc.foobot.io");
   }

   public Retrofit retroFitFactory(String var1) {
      return BaseNetworkClient$_CC.$default$retroFitFactory(this, var1);
   }
}
