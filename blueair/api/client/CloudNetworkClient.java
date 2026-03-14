package com.blueair.api.client;

import com.blueair.auth.AuthService;
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
   d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\u001a\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u001a\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\r\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u000eÀ\u0006\u0003"},
   d2 = {"Lcom/blueair/api/client/CloudNetworkClient;", "Lcom/blueair/api/client/BaseNetworkClient;", "authService", "Lcom/blueair/auth/AuthService;", "getAuthService", "()Lcom/blueair/auth/AuthService;", "buildHttpClient", "Lokhttp3/OkHttpClient;", "isAbl", "", "mockInterceptor", "Lokhttp3/Interceptor;", "buildHttpClientWithFakeUserSupport", "buildBasicAuthClient", "api_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public interface CloudNetworkClient extends BaseNetworkClient {
   OkHttpClient buildBasicAuthClient(Interceptor var1);

   OkHttpClient buildHttpClient(boolean var1, Interceptor var2);

   OkHttpClient buildHttpClientWithFakeUserSupport(boolean var1, Interceptor var2);

   AuthService getAuthService();

   @Metadata(
      k = 3,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class DefaultImpls {
      @Deprecated
      public static Object awaitAllCalls(CloudNetworkClient var0, List var1, Continuation var2) {
         return CloudNetworkClient$_CC.access$awaitAllCalls$jd(var0, var1, var2);
      }

      @Deprecated
      public static Object awaitCall(CloudNetworkClient var0, Deferred var1, Continuation var2) {
         return CloudNetworkClient$_CC.access$awaitCall$jd(var0, var1, var2);
      }

      @Deprecated
      public static OkHttpClient buildBasicAuthClient(CloudNetworkClient var0, Interceptor var1) {
         return CloudNetworkClient$_CC.access$buildBasicAuthClient$jd(var0, var1);
      }

      @Deprecated
      public static OkHttpClient buildHttpClient(CloudNetworkClient var0, boolean var1, Interceptor var2) {
         return CloudNetworkClient$_CC.access$buildHttpClient$jd(var0, var1, var2);
      }

      @Deprecated
      public static OkHttpClient buildHttpClientWithFakeUserSupport(CloudNetworkClient var0, boolean var1, Interceptor var2) {
         return CloudNetworkClient$_CC.access$buildHttpClientWithFakeUserSupport$jd(var0, var1, var2);
      }

      @Deprecated
      public static Object doSuspendedApiCall(CloudNetworkClient var0, Function2 var1, Object var2, Continuation var3) {
         return CloudNetworkClient$_CC.access$doSuspendedApiCall$jd(var0, var1, var2, var3);
      }

      @Deprecated
      public static Object doSuspendedApiCall(CloudNetworkClient var0, Function3 var1, Object var2, Object var3, Continuation var4) {
         return CloudNetworkClient$_CC.access$doSuspendedApiCall$jd(var0, var1, var2, var3, var4);
      }

      @Deprecated
      public static Retrofit retroFitFactory(CloudNetworkClient var0, String var1) {
         Intrinsics.checkNotNullParameter(var1, "baseUrl");
         return CloudNetworkClient$_CC.access$retroFitFactory$jd(var0, var1);
      }
   }
}
