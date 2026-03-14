package com.blueair.api.client;

import java.util.List;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.Deferred;
import retrofit2.Retrofit;

// $FF: synthetic class
public final class WifiNetworkClient$_CC {
   // $FF: synthetic method
   public static Object access$awaitAllCalls$jd(WifiNetworkClient var0, List var1, Continuation var2) {
      return BaseNetworkClient$_CC.$default$awaitAllCalls(var0, var1, var2);
   }

   // $FF: synthetic method
   public static Object access$awaitCall$jd(WifiNetworkClient var0, Deferred var1, Continuation var2) {
      return BaseNetworkClient$_CC.$default$awaitCall(var0, var1, var2);
   }

   // $FF: synthetic method
   public static Object access$doSuspendedApiCall$jd(WifiNetworkClient var0, Function2 var1, Object var2, Continuation var3) {
      return BaseNetworkClient$_CC.$default$doSuspendedApiCall(var0, var1, var2, var3);
   }

   // $FF: synthetic method
   public static Object access$doSuspendedApiCall$jd(WifiNetworkClient var0, Function3 var1, Object var2, Object var3, Continuation var4) {
      return BaseNetworkClient$_CC.$default$doSuspendedApiCall(var0, var1, var2, var3, var4);
   }

   // $FF: synthetic method
   public static Retrofit access$retroFitFactory$jd(WifiNetworkClient var0, String var1) {
      return BaseNetworkClient$_CC.$default$retroFitFactory(var0, var1);
   }
}
