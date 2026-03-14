package com.blueair.api.client;

import android.content.res.Resources;
import com.blueair.api.MockingUtils;
import com.blueair.api.R;
import com.blueair.api.model.ProvisionRequestBody;
import com.blueair.api.restapi.ProvisioningWifiRestApi;
import com.blueair.api.restapi.ProvisioningWifiRestApi$_CC;
import com.blueair.auth.AuthService;
import com.blueair.core.BuildEnvironment;
import com.blueair.core.BuildVariant;
import com.blueair.core.model.DeviceUuid;
import com.blueair.core.model.Ipv4;
import com.blueair.core.util.HttpsTrustUtils;
import io.flatcircle.coroutinehelper.ApiResult;
import io.flatcircle.coroutinehelper.Success;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Triple;
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
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import retrofit2.Retrofit;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B5\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\u0014\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(H\u0096@¢\u0006\u0002\u0010*J\u001a\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020-0,0(H\u0096@¢\u0006\u0002\u0010*J\u001c\u0010.\u001a\b\u0012\u0004\u0012\u00020/0(2\u0006\u00100\u001a\u000201H\u0096@¢\u0006\u0002\u00102J\"\u00103\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002040,0(2\u0006\u00100\u001a\u000205H\u0096@¢\u0006\u0002\u00106J\u001c\u00107\u001a\b\u0012\u0004\u0012\u00020\u00060(2\u0006\u00108\u001a\u00020)H\u0096@¢\u0006\u0002\u00109J\u0014\u0010:\u001a\b\u0012\u0004\u0012\u00020;0(H\u0096@¢\u0006\u0002\u0010*J\b\u0010<\u001a\u00020=H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0005\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0007\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0011\"\u0004\b\u001a\u0010\u0013R\u0014\u0010\u001b\u001a\u00020\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\u00020 8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0014\u0010#\u001a\u00020$8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&¨\u0006>"},
   d2 = {"Lcom/blueair/api/client/WifiDeviceClient;", "Lcom/blueair/api/client/WifiNetworkClient;", "Lcom/blueair/api/client/CanProvisionLocal;", "resources", "Landroid/content/res/Resources;", "deviceUuid", "", "deviceJwt", "authService", "Lcom/blueair/auth/AuthService;", "mockInterceptor", "Lokhttp3/Interceptor;", "<init>", "(Landroid/content/res/Resources;Ljava/lang/String;Ljava/lang/String;Lcom/blueair/auth/AuthService;Lokhttp3/Interceptor;)V", "getResources", "()Landroid/content/res/Resources;", "getDeviceUuid", "()Ljava/lang/String;", "setDeviceUuid", "(Ljava/lang/String;)V", "getDeviceJwt", "setDeviceJwt", "getMockInterceptor", "()Lokhttp3/Interceptor;", "baseUrl", "getBaseUrl", "setBaseUrl", "okHttpClient", "Lokhttp3/OkHttpClient;", "getOkHttpClient", "()Lokhttp3/OkHttpClient;", "retrofit", "Lretrofit2/Retrofit;", "getRetrofit", "()Lretrofit2/Retrofit;", "provisioningWifiRestApi", "Lcom/blueair/api/restapi/ProvisioningWifiRestApi;", "getProvisioningWifiRestApi", "()Lcom/blueair/api/restapi/ProvisioningWifiRestApi;", "getUuid", "Lio/flatcircle/coroutinehelper/ApiResult;", "Lcom/blueair/core/model/DeviceUuid;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSsids", "", "Lcom/blueair/core/model/Ssid;", "provisionDevice", "Lcom/blueair/api/model/ProvisionRequestBody;", "body", "Lcom/blueair/api/client/ProvisionBody;", "(Lcom/blueair/api/client/ProvisionBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getOnboardingEvents", "Lcom/blueair/core/model/DeviceEvent;", "Lcom/blueair/api/client/OnboardingEventsBody;", "(Lcom/blueair/api/client/OnboardingEventsBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resetDevice", "ipInfo", "(Lcom/blueair/core/model/DeviceUuid;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "switchOffSoftAp", "", "clear", "", "api_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class WifiDeviceClient implements WifiNetworkClient, CanProvisionLocal {
   private final AuthService authService;
   private String baseUrl;
   private String deviceJwt;
   private String deviceUuid;
   private final Interceptor mockInterceptor;
   private final Resources resources;

   public WifiDeviceClient(Resources var1, String var2, String var3, AuthService var4, Interceptor var5) {
      Intrinsics.checkNotNullParameter(var1, "resources");
      Intrinsics.checkNotNullParameter(var2, "deviceUuid");
      Intrinsics.checkNotNullParameter(var3, "deviceJwt");
      Intrinsics.checkNotNullParameter(var4, "authService");
      super();
      this.resources = var1;
      this.deviceUuid = var2;
      this.deviceJwt = var3;
      this.authService = var4;
      this.mockInterceptor = var5;
      this.baseUrl = "https://192.168.4.1/";
   }

   // $FF: synthetic method
   public WifiDeviceClient(Resources var1, String var2, String var3, AuthService var4, Interceptor var5, int var6, DefaultConstructorMarker var7) {
      if ((var6 & 4) != 0) {
         var3 = "";
      }

      if ((var6 & 16) != 0) {
         var5 = null;
      }

      this(var1, var2, var3, var4, var5);
   }

   public Object awaitAllCalls(List var1, Continuation var2) {
      return BaseNetworkClient$_CC.$default$awaitAllCalls(this, var1, var2);
   }

   public Object awaitCall(Deferred var1, Continuation var2) {
      return BaseNetworkClient$_CC.$default$awaitCall(this, var1, var2);
   }

   public void clear() {
   }

   public Object doSuspendedApiCall(Function2 var1, Object var2, Continuation var3) {
      return BaseNetworkClient$_CC.$default$doSuspendedApiCall(this, var1, var2, var3);
   }

   public Object doSuspendedApiCall(Function3 var1, Object var2, Object var3, Continuation var4) {
      return BaseNetworkClient$_CC.$default$doSuspendedApiCall(this, var1, var2, var3, var4);
   }

   public final String getBaseUrl() {
      return this.baseUrl;
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
      HttpLoggingInterceptor var2 = new HttpLoggingInterceptor((HttpLoggingInterceptor.Logger)null, 1, (DefaultConstructorMarker)null);
      HttpLoggingInterceptor.Level var1;
      if (BuildEnvironment.INSTANCE.getVariant() == BuildVariant.RELEASE) {
         var1 = Level.NONE;
      } else {
         var1 = Level.BODY;
      }

      var2.setLevel(var1);
      Triple var5 = HttpsTrustUtils.INSTANCE.getTrustSslDetailsFor(this.getResources(), R.raw.g4cacert);
      X509TrustManager var3 = (X509TrustManager)var5.component1();
      SSLSocketFactory var4 = (SSLSocketFactory)var5.component2();
      Collection var6 = (Collection)var5.component3();
      OkHttpClient.Builder var8 = (new OkHttpClient.Builder()).addNetworkInterceptor(new Interceptor(this) {
         final WifiDeviceClient this$0;

         public {
            this.this$0 = var1;
         }

         public final Response intercept(Interceptor.Chain var1) {
            Intrinsics.checkNotNullParameter(var1, "chain");
            Request var2 = var1.request();
            Request.Builder var3 = var2.newBuilder().method(var2.method(), var2.body());
            StringBuilder var4 = new StringBuilder("Bearer ");
            var4.append(this.this$0.getDeviceJwt());
            var3.addHeader("Authorization", var4.toString());
            return var1.proceed(var3.build());
         }
      }).addInterceptor((Interceptor)var2).connectTimeout(45L, TimeUnit.SECONDS).readTimeout(30L, TimeUnit.SECONDS).writeTimeout(30L, TimeUnit.SECONDS);
      if (var3 == null) {
         Interceptor var7 = this.getMockInterceptor();
         Intrinsics.checkNotNull(var7);
         return var8.addInterceptor(var7).build();
      } else {
         Intrinsics.checkNotNull(var4);
         var8 = var8.sslSocketFactory(var4, var3);
         Intrinsics.checkNotNull(var6);
         return var8.hostnameVerifier(new HttpsTrustUtils.CertificateOnlyHostnameVerifier(var6)).build();
      }
   }

   public Object getOnboardingEvents(OnboardingEventsBody var1, Continuation var2) {
      label32: {
         if (var2 instanceof <undefinedtype>) {
            <undefinedtype> var4 = (<undefinedtype>)var2;
            if ((var4.label & Integer.MIN_VALUE) != 0) {
               var4.label += Integer.MIN_VALUE;
               var11 = var4;
               break label32;
            }
         }

         var11 = new ContinuationImpl(this, var2) {
            Object L$0;
            int label;
            Object result;
            final WifiDeviceClient this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.getOnboardingEvents((OnboardingEventsBody)null, (Continuation)this);
            }
         };
      }

      Object var14 = ((<undefinedtype>)var11).result;
      Object var5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var3 = ((<undefinedtype>)var11).label;
      Object var8;
      if (var3 != 0) {
         if (var3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         OnboardingEventsBody var7 = (OnboardingEventsBody)((<undefinedtype>)var11).L$0;
         ResultKt.throwOnFailure(var14);
         var8 = (ProvisioningWifiRestApi.DeviceEventWrapper)var14;
      } else {
         ResultKt.throwOnFailure(var14);
         Timber.Forest var6 = Timber.Forest;
         StringBuilder var15 = new StringBuilder("Getting onboardingEvent for ");
         var15.append(this.getDeviceUuid());
         var6.v(var15.toString(), new Object[0]);
         if (var1.getOnboardingError() != null) {
            return new Success(MockingUtils.INSTANCE.onboardingEvents(var1.getIteration(), var1.getOnboardingError()));
         }

         Deferred var16 = this.getProvisioningWifiRestApi().getOnboardingEventQueue(this.getDeviceUuid());
         ((<undefinedtype>)var11).L$0 = SpillingKt.nullOutSpilledVariable(var1);
         ((<undefinedtype>)var11).label = 1;
         Object var12 = this.awaitCall(var16, (Continuation)var11);
         var8 = (ProvisioningWifiRestApi.DeviceEventWrapper)var12;
         if (var12 == var5) {
            return var5;
         }
      }

      ApiResult var17 = (ApiResult)var8;
      ApiResult.Companion var13 = ApiResult.Companion;
      var8 = (ProvisioningWifiRestApi.DeviceEventWrapper)var17.getOrNull();
      List var10;
      if (var8 != null) {
         var10 = var8.getEvents();
      } else {
         var10 = null;
      }

      return var13.fromResult(var17, var10);
   }

   public ProvisioningWifiRestApi getProvisioningWifiRestApi() {
      Object var1 = this.getRetrofit().create(ProvisioningWifiRestApi.class);
      Intrinsics.checkNotNullExpressionValue(var1, "create(...)");
      return (ProvisioningWifiRestApi)var1;
   }

   public Resources getResources() {
      return this.resources;
   }

   public Retrofit getRetrofit() {
      return this.retroFitFactory(this.baseUrl);
   }

   public Object getSsids(Continuation var1) {
      label32: {
         if (var1 instanceof <undefinedtype>) {
            <undefinedtype> var3 = (<undefinedtype>)var1;
            if ((var3.label & Integer.MIN_VALUE) != 0) {
               var3.label += Integer.MIN_VALUE;
               var6 = var3;
               break label32;
            }
         }

         var6 = new ContinuationImpl(this, var1) {
            int label;
            Object result;
            final WifiDeviceClient this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.getSsids((Continuation)this);
            }
         };
      }

      Object var10 = ((<undefinedtype>)var6).result;
      Object var4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var2 = ((<undefinedtype>)var6).label;
      Object var7;
      if (var2 != 0) {
         if (var2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         ResultKt.throwOnFailure(var10);
         var7 = (ProvisioningWifiRestApi.SsidWrapper)var10;
      } else {
         ResultKt.throwOnFailure(var10);
         if (((CharSequence)this.getDeviceUuid()).length() <= 0) {
            throw new IllegalArgumentException("Failed requirement.".toString());
         }

         Timber.Forest var5 = Timber.Forest;
         StringBuilder var11 = new StringBuilder("Getting ssids from ");
         var11.append(this.getDeviceUuid());
         var5.v(var11.toString(), new Object[0]);
         Deferred var12 = this.getProvisioningWifiRestApi().getSsids(this.getDeviceUuid());
         ((<undefinedtype>)var6).label = 1;
         Object var13 = this.awaitCall(var12, (Continuation)var6);
         var7 = (ProvisioningWifiRestApi.SsidWrapper)var13;
         if (var13 == var4) {
            return var4;
         }
      }

      ApiResult var14 = (ApiResult)var7;
      ApiResult.Companion var15 = ApiResult.Companion;
      var7 = (ProvisioningWifiRestApi.SsidWrapper)var14.getOrNull();
      List var9;
      if (var7 != null) {
         var9 = var7.getNetwork();
      } else {
         var9 = null;
      }

      return var15.fromResult(var14, var9);
   }

   public Object getUuid(Continuation var1) {
      label37: {
         if (var1 instanceof <undefinedtype>) {
            <undefinedtype> var3 = (<undefinedtype>)var1;
            if ((var3.label & Integer.MIN_VALUE) != 0) {
               var3.label += Integer.MIN_VALUE;
               var5 = var3;
               break label37;
            }
         }

         var5 = new ContinuationImpl(this, var1) {
            int label;
            Object result;
            final WifiDeviceClient this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.getUuid((Continuation)this);
            }
         };
      }

      Object var12 = ((<undefinedtype>)var5).result;
      Object var4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var2 = ((<undefinedtype>)var5).label;
      Object var6;
      if (var2 != 0) {
         if (var2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         ResultKt.throwOnFailure(var12);
         var6 = (ProvisioningWifiRestApi.UuidWrapper)var12;
      } else {
         ResultKt.throwOnFailure(var12);
         Deferred var13 = this.getProvisioningWifiRestApi().getUuid();
         ((<undefinedtype>)var5).label = 1;
         Object var14 = this.awaitCall(var13, (Continuation)var5);
         var6 = (ProvisioningWifiRestApi.UuidWrapper)var14;
         if (var14 == var4) {
            return var4;
         }
      }

      label31: {
         var15 = (ApiResult)var6;
         var17 = ApiResult.Companion;
         var6 = (ProvisioningWifiRestApi.UuidWrapper)var15.getOrNull();
         if (var6 != null) {
            List var8 = var6.getUuid();
            if (var8 != null) {
               var9 = (DeviceUuid)var8.get(0);
               break label31;
            }
         }

         var9 = null;
      }

      ApiResult var16 = var17.fromResult(var15, var9);
      DeviceUuid var10 = (DeviceUuid)var16.getOrNull();
      String var11;
      if (var10 == null) {
         var11 = "";
      } else {
         var11 = var10.getUuid();
      }

      this.setDeviceUuid(var11);
      return var16;
   }

   public Object provisionDevice(ProvisionBody var1, Continuation var2) {
      if (((CharSequence)this.getDeviceUuid()).length() > 0) {
         if (((CharSequence)var1.getSsid()).length() > 0) {
            if (((CharSequence)var1.getBssid()).length() > 0) {
               if (((CharSequence)var1.getPassword()).length() > 0) {
                  if (((CharSequence)var1.getRand()).length() > 0) {
                     if (((CharSequence)var1.getText()).length() > 0) {
                        Timber.Forest var3 = Timber.Forest;
                        StringBuilder var4 = new StringBuilder("Provisioning device for ");
                        var4.append(this.getDeviceUuid());
                        var3.v(var4.toString(), new Object[0]);
                        StringBuilder var11 = new StringBuilder();
                        var11.append(this.authService.getBlueHomeHost());
                        var11.append("c/authenticate");
                        String var13 = var11.toString();
                        String var5 = this.authService.getBlueBrokerURL();
                        String var12 = var1.getSsid();
                        String var7 = var1.getBssid();
                        String var8 = var1.getPassword();
                        String var6 = var1.getText();
                        String var9 = var1.getRand();
                        ProvisionRequestBody var10 = new ProvisionRequestBody(var12, var7, var8, this.authService.getBlueHomeHost(), var13, var5, (String)null, var6, var9, 64, (DefaultConstructorMarker)null);
                        return this.awaitCall(this.getProvisioningWifiRestApi().provisionDevice(this.getDeviceUuid(), var10), var2);
                     } else {
                        throw new IllegalArgumentException("Failed requirement.".toString());
                     }
                  } else {
                     throw new IllegalArgumentException("Failed requirement.".toString());
                  }
               } else {
                  throw new IllegalArgumentException("Failed requirement.".toString());
               }
            } else {
               throw new IllegalArgumentException("Failed requirement.".toString());
            }
         } else {
            throw new IllegalArgumentException("Failed requirement.".toString());
         }
      } else {
         throw new IllegalArgumentException("Failed requirement.".toString());
      }
   }

   public Object resetDevice(DeviceUuid var1, Continuation var2) {
      if (((CharSequence)this.getDeviceUuid()).length() > 0) {
         Ipv4 var3 = var1.getIpv4();
         String var7;
         if (var3 != null) {
            var7 = var3.getIp();
         } else {
            var7 = null;
         }

         if (var7 != null) {
            Timber.Forest var8 = Timber.Forest;
            StringBuilder var4 = new StringBuilder("resetting access point for ");
            var4.append(this.getDeviceUuid());
            var8.v(var4.toString(), new Object[0]);
            ProvisioningWifiRestApi var9 = this.getProvisioningWifiRestApi();
            Ipv4 var5 = var1.getIpv4();
            Intrinsics.checkNotNull(var5);
            String var6 = var5.getIp();
            Intrinsics.checkNotNull(var6);
            return this.awaitCall(var9.resetDevice(var6, this.getDeviceUuid()), var2);
         } else {
            throw new IllegalArgumentException("Failed requirement.".toString());
         }
      } else {
         throw new IllegalArgumentException("Failed requirement.".toString());
      }
   }

   public Retrofit retroFitFactory(String var1) {
      return BaseNetworkClient$_CC.$default$retroFitFactory(this, var1);
   }

   public final void setBaseUrl(String var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.baseUrl = var1;
   }

   public void setDeviceJwt(String var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.deviceJwt = var1;
   }

   public void setDeviceUuid(String var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.deviceUuid = var1;
   }

   public Object switchOffSoftAp(Continuation var1) {
      if (((CharSequence)this.getDeviceUuid()).length() > 0) {
         Timber.Forest var3 = Timber.Forest;
         StringBuilder var2 = new StringBuilder("Switching off access point for ");
         var2.append(this.getDeviceUuid());
         var3.v(var2.toString(), new Object[0]);
         return this.awaitCall(ProvisioningWifiRestApi$_CC.switchOffSoftAp$default(this.getProvisioningWifiRestApi(), this.getDeviceUuid(), (ProvisioningWifiRestApi.SwitchOffSoftApBody)null, 2, (Object)null), var1);
      } else {
         throw new IllegalArgumentException("Failed requirement.".toString());
      }
   }
}
