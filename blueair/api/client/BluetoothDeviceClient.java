package com.blueair.api.client;

import android.content.res.Resources;
import com.blueair.api.model.DeviceInfoData;
import com.blueair.api.restapi.DeviceAblRestApi;
import com.blueair.api.restapi.SimpleResponse;
import com.blueair.auth.AuthService;
import com.blueair.core.model.DeviceUuid;
import io.flatcircle.ble.BleIcpController;
import io.flatcircle.ble.BleService;
import io.flatcircle.ble.BleIcpController.FanSpeed;
import io.flatcircle.coroutinehelper.ApiResult;
import java.io.IOException;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
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
   d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005B=\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010/\u001a\u000200H\u0016J\u001c\u00101\u001a\b\u0012\u0004\u0012\u000203022\u0006\u00104\u001a\u000205H\u0096@¢\u0006\u0002\u00106J&\u00107\u001a\b\u0012\u0004\u0012\u000203022\u0006\u00108\u001a\u0002052\b\u00109\u001a\u0004\u0018\u00010\rH\u0096@¢\u0006\u0002\u0010:J\u001c\u0010;\u001a\b\u0012\u0004\u0012\u00020<022\u0006\u0010=\u001a\u00020>H\u0096@¢\u0006\u0002\u0010?J\"\u0010@\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020B0A022\u0006\u0010=\u001a\u00020CH\u0096@¢\u0006\u0002\u0010DJ\u0014\u0010E\u001a\b\u0012\u0004\u0012\u00020F02H\u0096@¢\u0006\u0002\u0010GJ\u001a\u0010H\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020I0A02H\u0096@¢\u0006\u0002\u0010GJ\u001c\u0010J\u001a\b\u0012\u0004\u0012\u00020\r022\u0006\u0010K\u001a\u00020FH\u0096@¢\u0006\u0002\u0010LJ\u0014\u0010M\u001a\b\u0012\u0004\u0012\u00020N02H\u0096@¢\u0006\u0002\u0010GJ\u0014\u0010O\u001a\b\u0012\u0004\u0012\u00020P02H\u0086@¢\u0006\u0002\u0010GJ\u001c\u0010Q\u001a\b\u0012\u0004\u0012\u00020N022\u0006\u0010R\u001a\u00020PH\u0086@¢\u0006\u0002\u0010SJ\u001c\u0010T\u001a\b\u0012\u0004\u0012\u00020N022\u0006\u0010U\u001a\u00020\rH\u0096@¢\u0006\u0002\u0010VR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\f\u001a\u00020\rX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u000e\u001a\u00020\rX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001a\"\u0004\b\u001e\u0010\u001cR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u001b\u0010!\u001a\u00020\"8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b#\u0010$R\u0014\u0010'\u001a\u00020(8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0014\u0010+\u001a\u00020,8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.¨\u0006W"},
   d2 = {"Lcom/blueair/api/client/BluetoothDeviceClient;", "Lcom/blueair/api/client/DeviceClient;", "Lcom/blueair/api/client/CanProvisionLocal;", "Lcom/blueair/api/client/CanSetFan;", "Lcom/blueair/api/client/CanSetDeviceName;", "Lcom/blueair/api/client/AblCloudNetworkClient;", "bleService", "Lio/flatcircle/ble/BleService;", "resources", "Landroid/content/res/Resources;", "authService", "Lcom/blueair/auth/AuthService;", "deviceUuid", "", "deviceJwt", "mockInterceptor", "Lokhttp3/Interceptor;", "<init>", "(Lio/flatcircle/ble/BleService;Landroid/content/res/Resources;Lcom/blueair/auth/AuthService;Ljava/lang/String;Ljava/lang/String;Lokhttp3/Interceptor;)V", "getBleService", "()Lio/flatcircle/ble/BleService;", "getResources", "()Landroid/content/res/Resources;", "getAuthService", "()Lcom/blueair/auth/AuthService;", "getDeviceUuid", "()Ljava/lang/String;", "setDeviceUuid", "(Ljava/lang/String;)V", "getDeviceJwt", "setDeviceJwt", "getMockInterceptor", "()Lokhttp3/Interceptor;", "okHttpClient", "Lokhttp3/OkHttpClient;", "getOkHttpClient", "()Lokhttp3/OkHttpClient;", "okHttpClient$delegate", "Lkotlin/Lazy;", "retrofit", "Lretrofit2/Retrofit;", "getRetrofit", "()Lretrofit2/Retrofit;", "deviceDetailsRestApi", "Lcom/blueair/api/restapi/DeviceAblRestApi;", "getDeviceDetailsRestApi", "()Lcom/blueair/api/restapi/DeviceAblRestApi;", "clear", "", "setFanSpeed", "Lio/flatcircle/coroutinehelper/ApiResult;", "Lcom/blueair/api/restapi/SimpleResponse;", "fanSpeed", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setAutoMode", "enabled", "type", "(ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "provisionDevice", "Lcom/blueair/api/model/ProvisionRequestBody;", "body", "Lcom/blueair/api/client/ProvisionBody;", "(Lcom/blueair/api/client/ProvisionBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getOnboardingEvents", "", "Lcom/blueair/core/model/DeviceEvent;", "Lcom/blueair/api/client/OnboardingEventsBody;", "(Lcom/blueair/api/client/OnboardingEventsBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUuid", "Lcom/blueair/core/model/DeviceUuid;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSsids", "Lcom/blueair/core/model/Ssid;", "resetDevice", "ipInfo", "(Lcom/blueair/core/model/DeviceUuid;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "switchOffSoftAp", "", "getDeviceInfoData", "Lcom/blueair/api/model/DeviceInfoData;", "setDeviceInfoData", "nuData", "(Lcom/blueair/api/model/DeviceInfoData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setDeviceName", "nuValue", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class BluetoothDeviceClient implements DeviceClient, CanProvisionLocal, CanSetFan, CanSetDeviceName, AblCloudNetworkClient {
   private final AuthService authService;
   private final BleService bleService;
   private String deviceJwt;
   private String deviceUuid;
   private final Interceptor mockInterceptor;
   private final Lazy okHttpClient$delegate;
   private final Resources resources;

   // $FF: synthetic method
   public static OkHttpClient $r8$lambda$oyMVGPPjaf_myDQDClTBtuNCcoc/* $FF was: $r8$lambda$oyMVGPPjaf-myDQDClTBtuNCcoc*/(BluetoothDeviceClient var0) {
      return okHttpClient_delegate$lambda$0(var0);
   }

   public BluetoothDeviceClient(BleService var1, Resources var2, AuthService var3, String var4, String var5, Interceptor var6) {
      Intrinsics.checkNotNullParameter(var1, "bleService");
      Intrinsics.checkNotNullParameter(var2, "resources");
      Intrinsics.checkNotNullParameter(var3, "authService");
      Intrinsics.checkNotNullParameter(var4, "deviceUuid");
      Intrinsics.checkNotNullParameter(var5, "deviceJwt");
      super();
      this.bleService = var1;
      this.resources = var2;
      this.authService = var3;
      this.deviceUuid = var4;
      this.deviceJwt = var5;
      this.mockInterceptor = var6;
      this.okHttpClient$delegate = LazyKt.lazy(new BluetoothDeviceClient$$ExternalSyntheticLambda0(this));
   }

   // $FF: synthetic method
   public BluetoothDeviceClient(BleService var1, Resources var2, AuthService var3, String var4, String var5, Interceptor var6, int var7, DefaultConstructorMarker var8) {
      if ((var7 & 16) != 0) {
         var5 = "";
      }

      if ((var7 & 32) != 0) {
         var6 = null;
      }

      this(var1, var2, var3, var4, var5, var6);
   }

   private static final OkHttpClient okHttpClient_delegate$lambda$0(BluetoothDeviceClient var0) {
      return var0.buildHttpClient(true, var0.getMockInterceptor());
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

   public void clear() {
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

   public final BleService getBleService() {
      return this.bleService;
   }

   public DeviceAblRestApi getDeviceDetailsRestApi() {
      Object var1 = this.getRetrofit().create(DeviceAblRestApi.class);
      Intrinsics.checkNotNullExpressionValue(var1, "create(...)");
      return (DeviceAblRestApi)var1;
   }

   public final Object getDeviceInfoData(Continuation var1) {
      return this.awaitCall(this.getDeviceDetailsRestApi().getDeviceInfoData(this.getDeviceUuid()), var1);
   }

   public String getDeviceJwt() {
      return this.deviceJwt;
   }

   public String getDeviceUuid() {
      return this.deviceUuid;
   }

   public Interceptor getMockInterceptor() {
      return this.mockInterceptor;
   }

   public OkHttpClient getOkHttpClient() {
      return (OkHttpClient)this.okHttpClient$delegate.getValue();
   }

   public Object getOnboardingEvents(OnboardingEventsBody var1, Continuation var2) {
      return ApiResult.Companion.notImplemented();
   }

   public Resources getResources() {
      return this.resources;
   }

   public Retrofit getRetrofit() {
      return this.retroFitFactory(this.getAuthService().getAblHomeHost());
   }

   public Object getSsids(Continuation var1) {
      return ApiResult.Companion.notImplemented();
   }

   public Object getUuid(Continuation var1) {
      return ApiResult.Companion.notImplemented();
   }

   public Object provisionDevice(ProvisionBody var1, Continuation var2) {
      return ApiResult.Companion.notImplemented();
   }

   public Object resetDevice(DeviceUuid var1, Continuation var2) {
      return ApiResult.Companion.notImplemented();
   }

   public Retrofit retroFitFactory(String var1) {
      return BaseNetworkClient$_CC.$default$retroFitFactory(this, var1);
   }

   public Object setAutoMode(int var1, String var2, Continuation var3) {
      BleService var5 = this.bleService;
      String var6 = this.getDeviceUuid();
      boolean var4 = true;
      if (var1 != 1) {
         var4 = false;
      }

      var5.setAutoMode(var6, var4);
      return ApiResult.Companion.success(new SimpleResponse((Integer)null, (String)null));
   }

   public final Object setDeviceInfoData(DeviceInfoData var1, Continuation var2) {
      return this.awaitCall(this.getDeviceDetailsRestApi().setDeviceInfoData(this.getDeviceUuid(), var1), var2);
   }

   public void setDeviceJwt(String var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.deviceJwt = var1;
   }

   public Object setDeviceName(String var1, Continuation var2) {
      label48: {
         if (var2 instanceof <undefinedtype>) {
            <undefinedtype> var4 = (<undefinedtype>)var2;
            if ((var4.label & Integer.MIN_VALUE) != 0) {
               var4.label += Integer.MIN_VALUE;
               var10 = var4;
               break label48;
            }
         }

         var10 = new ContinuationImpl(this, var2) {
            Object L$0;
            Object L$1;
            Object L$2;
            int label;
            Object result;
            final BluetoothDeviceClient this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.setDeviceName((String)null, (Continuation)this);
            }
         };
      }

      Object var13;
      label53: {
         var13 = ((<undefinedtype>)var10).result;
         Object var6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
         int var3 = ((<undefinedtype>)var10).label;
         if (var3 != 0) {
            if (var3 != 1) {
               if (var3 != 2) {
                  throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
               }

               DeviceInfoData var5 = (DeviceInfoData)((<undefinedtype>)var10).L$2;
               ApiResult var8 = (ApiResult)((<undefinedtype>)var10).L$1;
               var1 = (String)((<undefinedtype>)var10).L$0;
               ResultKt.throwOnFailure(var13);
               var11 = var5;
               break label53;
            }

            var1 = (String)((<undefinedtype>)var10).L$0;
            ResultKt.throwOnFailure(var13);
         } else {
            ResultKt.throwOnFailure(var13);
            ((<undefinedtype>)var10).L$0 = var1;
            ((<undefinedtype>)var10).label = 1;
            var13 = this.getDeviceInfoData((Continuation)var10);
            if (var13 == var6) {
               return var6;
            }
         }

         ApiResult var14 = (ApiResult)var13;
         DeviceInfoData var16 = (DeviceInfoData)var14.getOrNull();
         if (var16 == null || var14.isFailure()) {
            ApiResult.Companion var17 = ApiResult.Companion;
            Throwable var12 = var14.exceptionOrNull();
            Throwable var9 = var12;
            if (var12 == null) {
               var9 = (Throwable)(new IOException("The Api call to get device data failed"));
            }

            return var17.fail(var9);
         }

         DeviceInfoData var7 = DeviceInfoData.copy$default(var16, (String)null, var1, (String)null, (String)null, (String)null, (String)null, (String)null, (String)null, (String)null, (Long)null, (Long)null, (Long)null, (Long)null, (Long)null, (Long)null, (String)null, (Long)null, 131069, (Object)null);
         ((<undefinedtype>)var10).L$0 = var1;
         ((<undefinedtype>)var10).L$1 = SpillingKt.nullOutSpilledVariable(var14);
         ((<undefinedtype>)var10).L$2 = var16;
         ((<undefinedtype>)var10).label = 2;
         var13 = this.setDeviceInfoData(var7, (Continuation)var10);
         if (var13 == var6) {
            return var6;
         }

         var11 = var16;
      }

      ApiResult var15 = (ApiResult)var13;
      return ApiResult.Companion.fromResult(var15, DeviceInfoData.copy$default(var11, (String)null, var1, (String)null, (String)null, (String)null, (String)null, (String)null, (String)null, (String)null, (Long)null, (Long)null, (Long)null, (Long)null, (Long)null, (Long)null, (String)null, (Long)null, 131069, (Object)null));
   }

   public void setDeviceUuid(String var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.deviceUuid = var1;
   }

   public Object setFanSpeed(int var1, Continuation var2) {
      BleIcpController.FanSpeed var3;
      if (var1 != 0) {
         if (var1 != 1) {
            if (var1 != 2) {
               if (var1 != 3) {
                  var3 = FanSpeed.SPEED_1;
               } else {
                  var3 = FanSpeed.SPEED_3;
               }
            } else {
               var3 = FanSpeed.SPEED_2;
            }
         } else {
            var3 = FanSpeed.SPEED_1;
         }
      } else {
         var3 = FanSpeed.SPEED_1;
      }

      this.bleService.setFanSpeed(this.getDeviceUuid(), var3);
      return ApiResult.Companion.success(new SimpleResponse((Integer)null, (String)null));
   }

   public Object switchOffSoftAp(Continuation var1) {
      return ApiResult.Companion.notImplemented();
   }
}
