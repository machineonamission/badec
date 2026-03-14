package com.blueair.api.client;

import com.blueair.api.restapi.OutdoorRestApi;
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
   d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006À\u0006\u0003"},
   d2 = {"Lcom/blueair/api/client/OutdoorCloudNetworkClient;", "Lcom/blueair/api/client/CloudNetworkClient;", "outdoorRestApi", "Lcom/blueair/api/restapi/OutdoorRestApi;", "getOutdoorRestApi", "()Lcom/blueair/api/restapi/OutdoorRestApi;", "api_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public interface OutdoorCloudNetworkClient extends CloudNetworkClient {
   OutdoorRestApi getOutdoorRestApi();

   @Metadata(
      k = 3,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class DefaultImpls {
      @Deprecated
      public static Object awaitAllCalls(OutdoorCloudNetworkClient var0, List var1, Continuation var2) {
         return OutdoorCloudNetworkClient$_CC.access$awaitAllCalls$jd(var0, var1, var2);
      }

      @Deprecated
      public static Object awaitCall(OutdoorCloudNetworkClient var0, Deferred var1, Continuation var2) {
         return OutdoorCloudNetworkClient$_CC.access$awaitCall$jd(var0, var1, var2);
      }

      @Deprecated
      public static OkHttpClient buildBasicAuthClient(OutdoorCloudNetworkClient var0, Interceptor var1) {
         return OutdoorCloudNetworkClient$_CC.access$buildBasicAuthClient$jd(var0, var1);
      }

      @Deprecated
      public static OkHttpClient buildHttpClient(OutdoorCloudNetworkClient var0, boolean var1, Interceptor var2) {
         return OutdoorCloudNetworkClient$_CC.access$buildHttpClient$jd(var0, var1, var2);
      }

      @Deprecated
      public static OkHttpClient buildHttpClientWithFakeUserSupport(OutdoorCloudNetworkClient var0, boolean var1, Interceptor var2) {
         return OutdoorCloudNetworkClient$_CC.access$buildHttpClientWithFakeUserSupport$jd(var0, var1, var2);
      }

      @Deprecated
      public static Object doSuspendedApiCall(OutdoorCloudNetworkClient var0, Function2 var1, Object var2, Continuation var3) {
         return OutdoorCloudNetworkClient$_CC.access$doSuspendedApiCall$jd(var0, var1, var2, var3);
      }

      @Deprecated
      public static Object doSuspendedApiCall(OutdoorCloudNetworkClient var0, Function3 var1, Object var2, Object var3, Continuation var4) {
         return OutdoorCloudNetworkClient$_CC.access$doSuspendedApiCall$jd(var0, var1, var2, var3, var4);
      }

      @Deprecated
      public static Retrofit retroFitFactory(OutdoorCloudNetworkClient var0, String var1) {
         Intrinsics.checkNotNullParameter(var1, "baseUrl");
         return OutdoorCloudNetworkClient$_CC.access$retroFitFactory$jd(var0, var1);
      }
   }
}
