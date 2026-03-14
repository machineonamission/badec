package com.blueair.api.client;

import android.content.res.Resources;
import com.blueair.api.restapi.MigrationDeviceAblRestApi;
import com.blueair.auth.AuthService;
import com.blueair.auth.LocationService;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Deferred;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

@Metadata(
   d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u001c\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!2\u0006\u0010#\u001a\u00020$H\u0086@¢\u0006\u0002\u0010%R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\u0004\u0018\u00010\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0012\u001a\u00020\u00138VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u001d8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f¨\u0006&"},
   d2 = {"Lcom/blueair/api/client/MigrationUserDevicesAblClient;", "Lcom/blueair/api/client/CloudNetworkClient;", "resources", "Landroid/content/res/Resources;", "authService", "Lcom/blueair/auth/AuthService;", "locationService", "Lcom/blueair/auth/LocationService;", "mockInterceptor", "Lokhttp3/Interceptor;", "<init>", "(Landroid/content/res/Resources;Lcom/blueair/auth/AuthService;Lcom/blueair/auth/LocationService;Lokhttp3/Interceptor;)V", "getResources", "()Landroid/content/res/Resources;", "getAuthService", "()Lcom/blueair/auth/AuthService;", "getMockInterceptor", "()Lokhttp3/Interceptor;", "okHttpClient", "Lokhttp3/OkHttpClient;", "getOkHttpClient", "()Lokhttp3/OkHttpClient;", "okHttpClient$delegate", "Lkotlin/Lazy;", "retrofit", "Lretrofit2/Retrofit;", "getRetrofit", "()Lretrofit2/Retrofit;", "migrationUserDevicesRestApi", "Lcom/blueair/api/restapi/MigrationDeviceAblRestApi;", "getMigrationUserDevicesRestApi", "()Lcom/blueair/api/restapi/MigrationDeviceAblRestApi;", "isMigrationOtaRunning", "Lio/flatcircle/coroutinehelper/ApiResult;", "Lcom/blueair/core/model/MigrationOtaResponse;", "deviceUid", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class MigrationUserDevicesAblClient implements CloudNetworkClient {
   private final AuthService authService;
   private final LocationService locationService;
   private final Interceptor mockInterceptor;
   private final Lazy okHttpClient$delegate;
   private final Resources resources;

   // $FF: synthetic method
   public static OkHttpClient $r8$lambda$pOKRMqvNMx193QzS7rmFX5T7Vv4(MigrationUserDevicesAblClient var0) {
      return okHttpClient_delegate$lambda$0(var0);
   }

   public MigrationUserDevicesAblClient(Resources var1, AuthService var2, LocationService var3, Interceptor var4) {
      Intrinsics.checkNotNullParameter(var1, "resources");
      Intrinsics.checkNotNullParameter(var2, "authService");
      Intrinsics.checkNotNullParameter(var3, "locationService");
      super();
      this.resources = var1;
      this.authService = var2;
      this.locationService = var3;
      this.mockInterceptor = var4;
      this.okHttpClient$delegate = LazyKt.lazy(new MigrationUserDevicesAblClient$$ExternalSyntheticLambda0(this));
   }

   // $FF: synthetic method
   public MigrationUserDevicesAblClient(Resources var1, AuthService var2, LocationService var3, Interceptor var4, int var5, DefaultConstructorMarker var6) {
      if ((var5 & 8) != 0) {
         var4 = null;
      }

      this(var1, var2, var3, var4);
   }

   private final MigrationDeviceAblRestApi getMigrationUserDevicesRestApi() {
      Object var1 = this.getRetrofit().create(MigrationDeviceAblRestApi.class);
      Intrinsics.checkNotNullExpressionValue(var1, "create(...)");
      return (MigrationDeviceAblRestApi)var1;
   }

   private static final OkHttpClient okHttpClient_delegate$lambda$0(MigrationUserDevicesAblClient var0) {
      return var0.buildBasicAuthClient(var0.getMockInterceptor());
   }

   public Object awaitAllCalls(List var1, Continuation var2) {
      return BaseNetworkClient$_CC.$default$awaitAllCalls(this, var1, var2);
   }

   public Object awaitCall(Deferred var1, Continuation var2) {
      return BaseNetworkClient$_CC.$default$awaitCall(this, var1, var2);
   }

   public OkHttpClient buildBasicAuthClient(Interceptor var1) {
      return CloudNetworkClient$_CC.$default$buildBasicAuthClient(this, var1);
   }

   public OkHttpClient buildHttpClient(boolean var1, Interceptor var2) {
      return CloudNetworkClient$_CC.$default$buildHttpClient(this, var1, var2);
   }

   public OkHttpClient buildHttpClientWithFakeUserSupport(boolean var1, Interceptor var2) {
      return CloudNetworkClient$_CC.$default$buildHttpClientWithFakeUserSupport(this, var1, var2);
   }

   public Object doSuspendedApiCall(Function2 var1, Object var2, Continuation var3) {
      return BaseNetworkClient$_CC.$default$doSuspendedApiCall(this, var1, var2, var3);
   }

   public Object doSuspendedApiCall(Function3 var1, Object var2, Object var3, Continuation var4) {
      return BaseNetworkClient$_CC.$default$doSuspendedApiCall(this, var1, var2, var3, var4);
   }

   public AuthService getAuthService() {
      return this.authService;
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
      String var1;
      if (this.locationService.isInChina()) {
         var1 = "http://api-nc.foobot.io";
      } else {
         var1 = "https://api-nc.foobot.io";
      }

      return this.retroFitFactory(var1);
   }

   public final Object isMigrationOtaRunning(String var1, Continuation var2) {
      return this.doSuspendedApiCall(new Function2(this.getMigrationUserDevicesRestApi()) {
         public final Object invoke(String var1, Continuation var2) {
            return ((MigrationDeviceAblRestApi)this.receiver).isMigrationOtaRunning(var1, var2);
         }
      }, var1, var2);
   }

   public Retrofit retroFitFactory(String var1) {
      return BaseNetworkClient$_CC.$default$retroFitFactory(this, var1);
   }
}
