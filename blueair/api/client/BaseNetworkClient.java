package com.blueair.api.client;

import android.content.res.Resources;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Deferred;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

@Metadata(
   d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\b`\u0018\u0000 12\u00020\u0001:\u000212J(\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00140\u0013\"\u0004\b\u0000\u0010\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00140\u0016H\u0096@¢\u0006\u0002\u0010\u0017J4\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00140\u00190\u0013\"\u0004\b\u0000\u0010\u00142\u0012\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00140\u001b0\u0019H\u0096@¢\u0006\u0002\u0010\u001cJa\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u001e0\u0013\"\u0004\b\u0000\u0010\u001f\"\u0004\b\u0001\u0010\u001e27\u0010 \u001a3\b\u0001\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001e0&0%\u0012\u0006\u0012\u0004\u0018\u00010\u00010!2\u0006\u0010$\u001a\u0002H\u001fH\u0096@¢\u0006\u0002\u0010'J\u0084\u0001\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u001e0\u0013\"\u0004\b\u0000\u0010(\"\u0004\b\u0001\u0010)\"\u0004\b\u0002\u0010\u001e2L\u0010 \u001aH\b\u0001\u0012\u0013\u0012\u0011H(¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(+\u0012\u0013\u0012\u0011H)¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(,\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001e0&0%\u0012\u0006\u0012\u0004\u0018\u00010\u00010*2\u0006\u0010+\u001a\u0002H(2\u0006\u0010,\u001a\u0002H)H\u0096@¢\u0006\u0002\u0010-J\u0010\u0010.\u001a\u00020\u00072\u0006\u0010/\u001a\u000200H\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u00063À\u0006\u0003"},
   d2 = {"Lcom/blueair/api/client/BaseNetworkClient;", "", "resources", "Landroid/content/res/Resources;", "getResources", "()Landroid/content/res/Resources;", "retrofit", "Lretrofit2/Retrofit;", "getRetrofit", "()Lretrofit2/Retrofit;", "mockInterceptor", "Lokhttp3/Interceptor;", "getMockInterceptor", "()Lokhttp3/Interceptor;", "okHttpClient", "Lokhttp3/OkHttpClient;", "getOkHttpClient", "()Lokhttp3/OkHttpClient;", "awaitCall", "Lio/flatcircle/coroutinehelper/ApiResult;", "T", "job", "Lkotlinx/coroutines/Deferred;", "(Lkotlinx/coroutines/Deferred;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitAllCalls", "", "calls", "Lcom/blueair/api/client/BaseNetworkClient$CallWithInput;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "doSuspendedApiCall", "Output", "Input", "apiCall", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "input", "Lkotlin/coroutines/Continuation;", "Lretrofit2/Response;", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Input1", "Input2", "Lkotlin/Function3;", "input1", "input2", "(Lkotlin/jvm/functions/Function3;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "retroFitFactory", "baseUrl", "", "Companion", "CallWithInput", "api_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public interface BaseNetworkClient {
   long CONNECTION_TIMEOUT = 45L;
   Companion Companion = BaseNetworkClient.Companion.$$INSTANCE;
   long READ_TIMEOUT = 30L;
   long WRITE_TIMEOUT = 30L;

   Object awaitAllCalls(List var1, Continuation var2);

   Object awaitCall(Deferred var1, Continuation var2);

   Object doSuspendedApiCall(Function2 var1, Object var2, Continuation var3);

   Object doSuspendedApiCall(Function3 var1, Object var2, Object var3, Continuation var4);

   Interceptor getMockInterceptor();

   OkHttpClient getOkHttpClient();

   Resources getResources();

   Retrofit getRetrofit();

   Retrofit retroFitFactory(String var1);

   @Metadata(
      d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002BH\u00127\u0010\u0003\u001a3\b\u0001\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\fRD\u0010\u0003\u001a3\b\u0001\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"},
      d2 = {"Lcom/blueair/api/client/BaseNetworkClient$CallWithInput;", "T", "", "call", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "input", "Lkotlin/coroutines/Continuation;", "Lretrofit2/Response;", "<init>", "(Lkotlin/jvm/functions/Function2;Ljava/lang/String;)V", "getCall", "()Lkotlin/jvm/functions/Function2;", "Lkotlin/jvm/functions/Function2;", "getInput", "()Ljava/lang/String;", "api_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class CallWithInput {
      private final Function2 call;
      private final String input;

      public CallWithInput(Function2 var1, String var2) {
         Intrinsics.checkNotNullParameter(var1, "call");
         Intrinsics.checkNotNullParameter(var2, "input");
         super();
         this.call = var1;
         this.input = var2;
      }

      public final Function2 getCall() {
         return this.call;
      }

      public final String getInput() {
         return this.input;
      }
   }

   @Metadata(
      d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"},
      d2 = {"Lcom/blueair/api/client/BaseNetworkClient$Companion;", "", "<init>", "()V", "CONNECTION_TIMEOUT", "", "READ_TIMEOUT", "WRITE_TIMEOUT", "api_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Companion {
      static final Companion $$INSTANCE = new Companion();
      public static final long CONNECTION_TIMEOUT = 45L;
      public static final long READ_TIMEOUT = 30L;
      public static final long WRITE_TIMEOUT = 30L;

      private Companion() {
      }
   }

   @Metadata(
      k = 3,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class DefaultImpls {
      @Deprecated
      public static Object awaitAllCalls(BaseNetworkClient var0, List var1, Continuation var2) {
         return BaseNetworkClient$_CC.access$awaitAllCalls$jd(var0, var1, var2);
      }

      @Deprecated
      public static Object awaitCall(BaseNetworkClient var0, Deferred var1, Continuation var2) {
         return BaseNetworkClient$_CC.access$awaitCall$jd(var0, var1, var2);
      }

      @Deprecated
      public static Object doSuspendedApiCall(BaseNetworkClient var0, Function2 var1, Object var2, Continuation var3) {
         return BaseNetworkClient$_CC.access$doSuspendedApiCall$jd(var0, var1, var2, var3);
      }

      @Deprecated
      public static Object doSuspendedApiCall(BaseNetworkClient var0, Function3 var1, Object var2, Object var3, Continuation var4) {
         return BaseNetworkClient$_CC.access$doSuspendedApiCall$jd(var0, var1, var2, var3, var4);
      }

      @Deprecated
      public static Retrofit retroFitFactory(BaseNetworkClient var0, String var1) {
         Intrinsics.checkNotNullParameter(var1, "baseUrl");
         return BaseNetworkClient$_CC.access$retroFitFactory$jd(var0, var1);
      }
   }
}
