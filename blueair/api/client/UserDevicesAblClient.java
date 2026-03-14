package com.blueair.api.client;

import android.content.res.Resources;
import com.blueair.api.restapi.DeviceSparseOnAblServer;
import com.blueair.api.restapi.RepairBody;
import com.blueair.api.restapi.TemperatureAttributeDto;
import com.blueair.api.restapi.UserDevicesAblRestApi;
import com.blueair.auth.AuthService;
import com.blueair.auth.LocationService;
import io.flatcircle.coroutinehelper.ApiResult;
import io.flatcircle.coroutinehelper.Success;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Deferred;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

@Metadata(
   d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020(0'0&H\u0086@¢\u0006\u0002\u0010)J\u001c\u0010*\u001a\b\u0012\u0004\u0012\u00020(0&2\u0006\u0010+\u001a\u00020,H\u0086@¢\u0006\u0002\u0010-J\u001c\u0010.\u001a\b\u0012\u0004\u0012\u00020/0&2\u0006\u00100\u001a\u00020,H\u0086@¢\u0006\u0002\u0010-J$\u00101\u001a\b\u0012\u0004\u0012\u00020,0&2\u0006\u00100\u001a\u00020,2\u0006\u00102\u001a\u00020,H\u0086@¢\u0006\u0002\u00103J\u001c\u00104\u001a\b\u0012\u0004\u0012\u00020/0&2\u0006\u00100\u001a\u00020,H\u0086@¢\u0006\u0002\u0010-J\u001c\u00105\u001a\b\u0012\u0004\u0012\u00020/0&2\u0006\u00100\u001a\u00020,H\u0086@¢\u0006\u0002\u0010-J\u001c\u00106\u001a\b\u0012\u0004\u0012\u0002070&2\u0006\u00108\u001a\u00020,H\u0086@¢\u0006\u0002\u0010-J\u0010\u00109\u001a\u0004\u0018\u00010,H\u0086@¢\u0006\u0002\u0010)J\u001c\u0010:\u001a\b\u0012\u0004\u0012\u00020;0&2\u0006\u00100\u001a\u00020,H\u0086@¢\u0006\u0002\u0010-R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\u0004\u0018\u00010\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0012\u001a\u00020\u00138VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u001d8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010 \u001a\u00020!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u0017\u001a\u0004\b\"\u0010#¨\u0006<"},
   d2 = {"Lcom/blueair/api/client/UserDevicesAblClient;", "Lcom/blueair/api/client/CloudNetworkClient;", "resources", "Landroid/content/res/Resources;", "authService", "Lcom/blueair/auth/AuthService;", "locationService", "Lcom/blueair/auth/LocationService;", "mockInterceptor", "Lokhttp3/Interceptor;", "<init>", "(Landroid/content/res/Resources;Lcom/blueair/auth/AuthService;Lcom/blueair/auth/LocationService;Lokhttp3/Interceptor;)V", "getResources", "()Landroid/content/res/Resources;", "getAuthService", "()Lcom/blueair/auth/AuthService;", "getMockInterceptor", "()Lokhttp3/Interceptor;", "okHttpClient", "Lokhttp3/OkHttpClient;", "getOkHttpClient", "()Lokhttp3/OkHttpClient;", "okHttpClient$delegate", "Lkotlin/Lazy;", "retrofit", "Lretrofit2/Retrofit;", "getRetrofit", "()Lretrofit2/Retrofit;", "userDevicesRestApi", "Lcom/blueair/api/restapi/UserDevicesAblRestApi;", "getUserDevicesRestApi", "()Lcom/blueair/api/restapi/UserDevicesAblRestApi;", "migrationUserAblClient", "Lcom/blueair/api/client/MigrationUserDevicesAblClient;", "getMigrationUserAblClient", "()Lcom/blueair/api/client/MigrationUserDevicesAblClient;", "migrationUserAblClient$delegate", "getDevices", "Lio/flatcircle/coroutinehelper/ApiResult;", "", "Lcom/blueair/core/model/DeviceDetailsOnAblServer;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDeviceInfo", "uuid", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeDevice", "", "deviceUid", "repairDevice", "macAddress", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addDevice", "resetAttributes", "setTemperatureUnit", "", "unit", "getTemperatureUnit", "isMigrationOtaRunning", "Lcom/blueair/core/model/MigrationOtaResponse;", "api_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class UserDevicesAblClient implements CloudNetworkClient {
   private final AuthService authService;
   private final LocationService locationService;
   private final Lazy migrationUserAblClient$delegate;
   private final Interceptor mockInterceptor;
   private final Lazy okHttpClient$delegate;
   private final Resources resources;

   // $FF: synthetic method
   public static MigrationUserDevicesAblClient $r8$lambda$5g0osgefVmA3rn1tU3BkBMp_eyw/* $FF was: $r8$lambda$5g0osgefVmA3rn1tU3BkBMp-eyw*/(UserDevicesAblClient var0) {
      return migrationUserAblClient_delegate$lambda$1(var0);
   }

   // $FF: synthetic method
   public static OkHttpClient $r8$lambda$_70BWrLUv72Z61ycukpAjfNLJfY(UserDevicesAblClient var0) {
      return okHttpClient_delegate$lambda$0(var0);
   }

   public UserDevicesAblClient(Resources var1, AuthService var2, LocationService var3, Interceptor var4) {
      Intrinsics.checkNotNullParameter(var1, "resources");
      Intrinsics.checkNotNullParameter(var2, "authService");
      Intrinsics.checkNotNullParameter(var3, "locationService");
      super();
      this.resources = var1;
      this.authService = var2;
      this.locationService = var3;
      this.mockInterceptor = var4;
      this.okHttpClient$delegate = LazyKt.lazy(new UserDevicesAblClient$$ExternalSyntheticLambda0(this));
      this.migrationUserAblClient$delegate = LazyKt.lazy(new UserDevicesAblClient$$ExternalSyntheticLambda1(this));
   }

   // $FF: synthetic method
   public UserDevicesAblClient(Resources var1, AuthService var2, LocationService var3, Interceptor var4, int var5, DefaultConstructorMarker var6) {
      if ((var5 & 8) != 0) {
         var4 = null;
      }

      this(var1, var2, var3, var4);
   }

   private final MigrationUserDevicesAblClient getMigrationUserAblClient() {
      return (MigrationUserDevicesAblClient)this.migrationUserAblClient$delegate.getValue();
   }

   private final UserDevicesAblRestApi getUserDevicesRestApi() {
      Object var1 = this.getRetrofit().create(UserDevicesAblRestApi.class);
      Intrinsics.checkNotNullExpressionValue(var1, "create(...)");
      return (UserDevicesAblRestApi)var1;
   }

   private static final MigrationUserDevicesAblClient migrationUserAblClient_delegate$lambda$1(UserDevicesAblClient var0) {
      return new MigrationUserDevicesAblClient(var0.getResources(), var0.getAuthService(), var0.locationService, (Interceptor)null, 8, (DefaultConstructorMarker)null);
   }

   private static final OkHttpClient okHttpClient_delegate$lambda$0(UserDevicesAblClient var0) {
      return var0.buildHttpClient(true, var0.getMockInterceptor());
   }

   public final Object addDevice(String var1, Continuation var2) {
      return this.doSuspendedApiCall(new Function3(this.getUserDevicesRestApi()) {
         public final Object invoke(String var1, String var2, Continuation var3) {
            return ((UserDevicesAblRestApi)this.receiver).addDevice(var1, var2, var3);
         }
      }, this.getAuthService().getAblUser().getUsername(), var1, var2);
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

   public final Object getDeviceInfo(String var1, Continuation var2) {
      return this.doSuspendedApiCall(new Function2(this.getUserDevicesRestApi()) {
         public final Object invoke(String var1, Continuation var2) {
            return ((UserDevicesAblRestApi)this.receiver).getDeviceDetails(var1, var2);
         }
      }, var1, var2);
   }

   public final Object getDevices(Continuation var1) {
      label56: {
         if (var1 instanceof <undefinedtype>) {
            <undefinedtype> var4 = (<undefinedtype>)var1;
            if ((var4.label & Integer.MIN_VALUE) != 0) {
               var4.label += Integer.MIN_VALUE;
               var9 = var4;
               break label56;
            }
         }

         var9 = new ContinuationImpl(this, var1) {
            Object L$0;
            Object L$1;
            int label;
            Object result;
            final UserDevicesAblClient this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.getDevices((Continuation)this);
            }
         };
      }

      Object var12 = ((<undefinedtype>)var9).result;
      Object var6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var2 = ((<undefinedtype>)var9).label;
      if (var2 != 0) {
         if (var2 != 1) {
            if (var2 == 2) {
               List var5 = (List)((<undefinedtype>)var9).L$1;
               ApiResult var10 = (ApiResult)((<undefinedtype>)var9).L$0;
               ResultKt.throwOnFailure(var12);
               return var12;
            }

            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         ResultKt.throwOnFailure(var12);
      } else {
         ResultKt.throwOnFailure(var12);
         Function2 var13 = new Function2(this.getUserDevicesRestApi()) {
            public final Object invoke(String var1, Continuation var2) {
               return ((UserDevicesAblRestApi)this.receiver).getDeviceList(var1, var2);
            }
         };
         String var16 = this.getAuthService().getAblUser().getUsername();
         ((<undefinedtype>)var9).label = 1;
         Object var17 = this.doSuspendedApiCall(var13, var16, (Continuation)var9);
         var12 = var17;
         if (var17 == var6) {
            return var6;
         }
      }

      ApiResult var18 = (ApiResult)var12;
      boolean var3 = var18.isFailure();
      List var14 = null;
      if (var3) {
         return ApiResult.Companion.fromResult(var18, (Object)null);
      } else {
         List var7 = (List)var18.getOrNull();
         if (var7 != null) {
            Iterable var19 = (Iterable)var7;
            Collection var15 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var19, 10)));

            for(DeviceSparseOnAblServer var20 : var19) {
               var15.add(new BaseNetworkClient.CallWithInput(new Function2(this.getUserDevicesRestApi()) {
                  public final Object invoke(String var1, Continuation var2) {
                     return ((UserDevicesAblRestApi)this.receiver).getDeviceDetails(var1, var2);
                  }
               }, var20.getUuid()));
            }

            var14 = (List)var15;
         }

         Collection var21 = (Collection)var14;
         if (var21 == null || var21.isEmpty()) {
            return new Success(CollectionsKt.emptyList());
         } else {
            ((<undefinedtype>)var9).L$0 = SpillingKt.nullOutSpilledVariable(var18);
            ((<undefinedtype>)var9).L$1 = SpillingKt.nullOutSpilledVariable(var14);
            ((<undefinedtype>)var9).label = 2;
            Object var11 = this.awaitAllCalls(var14, (Continuation)var9);
            if (var11 != var6) {
               return var11;
            } else {
               return var6;
            }
         }
      }
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
      return this.retroFitFactory(this.getAuthService().getAblHomeHost());
   }

   public final Object getTemperatureUnit(Continuation var1) {
      label27: {
         if (var1 instanceof <undefinedtype>) {
            <undefinedtype> var3 = (<undefinedtype>)var1;
            if ((var3.label & Integer.MIN_VALUE) != 0) {
               var3.label += Integer.MIN_VALUE;
               var6 = var3;
               break label27;
            }
         }

         var6 = new ContinuationImpl(this, var1) {
            int label;
            Object result;
            final UserDevicesAblClient this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.getTemperatureUnit((Continuation)this);
            }
         };
      }

      Object var9 = ((<undefinedtype>)var6).result;
      Object var4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var2 = ((<undefinedtype>)var6).label;
      Object var7;
      if (var2 != 0) {
         if (var2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         ResultKt.throwOnFailure(var9);
         var7 = var9;
      } else {
         ResultKt.throwOnFailure(var9);
         Function2 var5 = new Function2(this.getUserDevicesRestApi()) {
            public final Object invoke(String var1, Continuation var2) {
               return ((UserDevicesAblRestApi)this.receiver).getTemperaturePreference(var1, var2);
            }
         };
         String var10 = this.getAuthService().getAblUser().getUsername();
         ((<undefinedtype>)var6).label = 1;
         Object var11 = this.doSuspendedApiCall(var5, var10, (Continuation)var6);
         var7 = var11;
         if (var11 == var4) {
            return var4;
         }
      }

      TemperatureAttributeDto var8 = (TemperatureAttributeDto)((ApiResult)var7).getOrNull();
      return var8 != null ? var8.getCurrentValue() : null;
   }

   public final Object isMigrationOtaRunning(String var1, Continuation var2) {
      return this.getMigrationUserAblClient().isMigrationOtaRunning(var1, var2);
   }

   public final Object removeDevice(String var1, Continuation var2) {
      return this.doSuspendedApiCall(new Function3(this.getUserDevicesRestApi()) {
         public final Object invoke(String var1, String var2, Continuation var3) {
            return ((UserDevicesAblRestApi)this.receiver).removeDevice(var1, var2, var3);
         }
      }, this.getAuthService().getAblUser().getUsername(), var1, var2);
   }

   public final Object repairDevice(String var1, String var2, Continuation var3) {
      label35: {
         if (var3 instanceof <undefinedtype>) {
            <undefinedtype> var5 = (<undefinedtype>)var3;
            if ((var5.label & Integer.MIN_VALUE) != 0) {
               var5.label += Integer.MIN_VALUE;
               var12 = var5;
               break label35;
            }
         }

         var12 = new ContinuationImpl(this, var3) {
            Object L$0;
            Object L$1;
            int label;
            Object result;
            final UserDevicesAblClient this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.repairDevice((String)null, (String)null, (Continuation)this);
            }
         };
      }

      Object var15 = ((<undefinedtype>)var12).result;
      Object var6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var4 = ((<undefinedtype>)var12).label;
      Object var9;
      if (var4 != 0) {
         if (var4 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         var1 = (String)((<undefinedtype>)var12).L$1;
         var1 = (String)((<undefinedtype>)var12).L$0;
         ResultKt.throwOnFailure(var15);
         var9 = (RepairBody)var15;
      } else {
         ResultKt.throwOnFailure(var15);
         Function3 var7 = new Function3(this.getUserDevicesRestApi()) {
            public final Object invoke(String var1, RepairBody var2, Continuation var3) {
               return ((UserDevicesAblRestApi)this.receiver).repairDevice(var1, var2, var3);
            }
         };
         RepairBody var16 = new RepairBody(var1, var2);
         ((<undefinedtype>)var12).L$0 = var1;
         ((<undefinedtype>)var12).L$1 = SpillingKt.nullOutSpilledVariable(var2);
         ((<undefinedtype>)var12).label = 1;
         Object var13 = this.doSuspendedApiCall(var7, var1, var16, (Continuation)var12);
         var9 = (RepairBody)var13;
         if (var13 == var6) {
            return var6;
         }
      }

      ApiResult var14 = (ApiResult)var9;
      var9 = (RepairBody)var14.getOrNull();
      String var11;
      if (var9 != null) {
         var11 = var9.getUuid();
      } else {
         var11 = null;
      }

      CharSequence var17 = (CharSequence)var11;
      return var17 != null && var17.length() != 0 ? ApiResult.Companion.success(var11) : ApiResult.Companion.fromResult(var14, var1);
   }

   public final Object resetAttributes(String var1, Continuation var2) {
      return this.doSuspendedApiCall(new Function2(this.getUserDevicesRestApi()) {
         public final Object invoke(String var1, Continuation var2) {
            return ((UserDevicesAblRestApi)this.receiver).resetAttributes(var1, var2);
         }
      }, var1, var2);
   }

   public Retrofit retroFitFactory(String var1) {
      return BaseNetworkClient$_CC.$default$retroFitFactory(this, var1);
   }

   public final Object setTemperatureUnit(String var1, Continuation var2) {
      return this.doSuspendedApiCall(new Function3(this.getUserDevicesRestApi()) {
         public final Object invoke(String var1, TemperatureAttributeDto var2, Continuation var3) {
            return ((UserDevicesAblRestApi)this.receiver).setTemperaturePreference(var1, var2, var3);
         }
      }, this.getAuthService().getAblUser().getUsername(), new TemperatureAttributeDto(var1, var1, this.getAuthService().getAblUser().getId(), (String)null, (String)null, 24, (DefaultConstructorMarker)null), var2);
   }
}
