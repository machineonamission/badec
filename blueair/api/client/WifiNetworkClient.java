package com.blueair.api.client;

import com.blueair.api.restapi.ProvisioningWifiRestApi;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Deferred;
import retrofit2.Retrofit;

@Metadata(
   d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u00012\u00020\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007À\u0006\u0003"},
   d2 = {"Lcom/blueair/api/client/WifiNetworkClient;", "Lcom/blueair/api/client/BaseNetworkClient;", "Lcom/blueair/api/client/DeviceClient;", "provisioningWifiRestApi", "Lcom/blueair/api/restapi/ProvisioningWifiRestApi;", "getProvisioningWifiRestApi", "()Lcom/blueair/api/restapi/ProvisioningWifiRestApi;", "api_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public interface WifiNetworkClient extends BaseNetworkClient, DeviceClient {
   ProvisioningWifiRestApi getProvisioningWifiRestApi();

   @Metadata(
      k = 3,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class DefaultImpls {
      @Deprecated
      public static Object awaitAllCalls(WifiNetworkClient var0, List var1, Continuation var2) {
         return WifiNetworkClient$_CC.access$awaitAllCalls$jd(var0, var1, var2);
      }

      @Deprecated
      public static Object awaitCall(WifiNetworkClient var0, Deferred var1, Continuation var2) {
         return WifiNetworkClient$_CC.access$awaitCall$jd(var0, var1, var2);
      }

      @Deprecated
      public static Object doSuspendedApiCall(WifiNetworkClient var0, Function2 var1, Object var2, Continuation var3) {
         return WifiNetworkClient$_CC.access$doSuspendedApiCall$jd(var0, var1, var2, var3);
      }

      @Deprecated
      public static Object doSuspendedApiCall(WifiNetworkClient var0, Function3 var1, Object var2, Object var3, Continuation var4) {
         return WifiNetworkClient$_CC.access$doSuspendedApiCall$jd(var0, var1, var2, var3, var4);
      }

      @Deprecated
      public static Retrofit retroFitFactory(WifiNetworkClient var0, String var1) {
         Intrinsics.checkNotNullParameter(var1, "baseUrl");
         return WifiNetworkClient$_CC.access$retroFitFactory$jd(var0, var1);
      }
   }
}
