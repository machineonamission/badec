package com.blueair.auth;

import android.content.Context;
import android.content.res.Resources;
import com.blueair.auth.retrofit.AblRegion;
import com.blueair.auth.retrofit.BlueairRegion;
import com.blueair.auth.retrofit.RegionApi;
import com.blueair.core.AblEnvironment;
import com.blueair.core.BuildEnvironment;
import com.blueair.core.BuildVariant;
import com.blueair.core.model.DeviceType;
import com.blueair.core.service.UnsecurePrefs;
import com.blueair.core.util.PhoneUtil;
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory;
import io.flatcircle.coroutinehelper.ApiResult;
import io.flatcircle.preferenceshelper2.PreferencesHelper;
import io.flatcircle.preferenceshelper2.Prefs;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import org.kodein.di.DI;
import org.kodein.di.DIAware;
import org.kodein.di.DIAwareKt;
import org.kodein.di.DIContext;
import org.kodein.di.DITrigger;
import org.kodein.di.DIAware.DefaultImpls;
import org.kodein.di.android.ClosestKt;
import org.kodein.di.android.LazyContextDIPropertyDelegateProvider;
import org.kodein.type.GenericJVMTypeTokenDelegate;
import org.kodein.type.JVMTypeToken;
import org.kodein.type.TypeReference;
import org.kodein.type.TypeToken;
import org.kodein.type.TypeTokensJVMKt;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 m2\u00020\u0001:\u0002lmB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J(\u0010O\u001a\u000209*\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010P2\b\b\u0002\u0010Q\u001a\u0002092\b\b\u0002\u0010R\u001a\u000209H\u0002J\u000e\u00104\u001a\u00020YH\u0086@¢\u0006\u0002\u0010ZJ\u0010\u0010[\u001a\u0004\u0018\u00010\u001aH\u0087@¢\u0006\u0002\u0010ZJ\u0010\u0010\\\u001a\u0004\u0018\u00010\u001aH\u0082@¢\u0006\u0002\u0010ZJ\u0006\u0010]\u001a\u00020YJ\u000e\u0010^\u001a\u00020Y2\u0006\u0010_\u001a\u00020\u001aJ\u0006\u0010`\u001a\u00020\u001aJ\u0006\u0010a\u001a\u000209J\u0006\u0010b\u001a\u000209J\u0010\u0010e\u001a\u00020\u001a2\b\b\u0002\u0010f\u001a\u000209J\u0010\u0010g\u001a\u00020\u001a2\b\b\u0002\u0010f\u001a\u000209J\u0006\u0010h\u001a\u00020iJ\u000e\u0010j\u001a\u0002092\u0006\u0010k\u001a\u00020\u001aR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0015\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u000f\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u001e\u001a\u00020\u001a8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001cR\u0011\u0010 \u001a\u00020!¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u001b\u0010$\u001a\u00020%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010\u000f\u001a\u0004\b&\u0010'R\u001b\u0010)\u001a\u00020*8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b-\u0010\u000f\u001a\u0004\b+\u0010,R\u001b\u0010.\u001a\u00020/8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b2\u0010\u000f\u001a\u0004\b0\u00101R\"\u00104\u001a\u0004\u0018\u00010\u001a2\b\u00103\u001a\u0004\u0018\u00010\u001a@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\u001cR\u0011\u00106\u001a\u00020\u001a8F¢\u0006\u0006\u001a\u0004\b7\u0010\u001cR\u0011\u00108\u001a\u0002098F¢\u0006\u0006\u001a\u0004\b8\u0010:R\u0011\u0010;\u001a\u0002098F¢\u0006\u0006\u001a\u0004\b;\u0010:R\u0011\u0010<\u001a\u0002098F¢\u0006\u0006\u001a\u0004\b<\u0010:R\u0011\u0010=\u001a\u0002098F¢\u0006\u0006\u001a\u0004\b=\u0010:R\u0011\u0010>\u001a\u0002098F¢\u0006\u0006\u001a\u0004\b>\u0010:R\u0011\u0010?\u001a\u0002098F¢\u0006\u0006\u001a\u0004\b?\u0010:R\u0011\u0010@\u001a\u0002098F¢\u0006\u0006\u001a\u0004\b@\u0010:R\u0011\u0010A\u001a\u0002098F¢\u0006\u0006\u001a\u0004\bA\u0010:R\u0011\u0010B\u001a\u0002098F¢\u0006\u0006\u001a\u0004\bB\u0010:R\u0013\u0010C\u001a\u0004\u0018\u00010D8G¢\u0006\u0006\u001a\u0004\bE\u0010FR\u0011\u0010G\u001a\u0002098F¢\u0006\u0006\u001a\u0004\bG\u0010:R\u0011\u0010H\u001a\u0002098F¢\u0006\u0006\u001a\u0004\bH\u0010:R\u0011\u0010I\u001a\u0002098F¢\u0006\u0006\u001a\u0004\bI\u0010:R\u0011\u0010J\u001a\u0002098F¢\u0006\u0006\u001a\u0004\bJ\u0010:R\u0011\u0010K\u001a\u0002098F¢\u0006\u0006\u001a\u0004\bK\u0010:R\u0011\u0010L\u001a\u0002098F¢\u0006\u0006\u001a\u0004\bL\u0010:R\u0011\u0010M\u001a\u0002098F¢\u0006\u0006\u001a\u0004\bM\u0010:R\u0011\u0010N\u001a\u0002098F¢\u0006\u0006\u001a\u0004\bN\u0010:R\u000e\u0010S\u001a\u00020TX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010U\u001a\u00020\u001aX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010\u001c\"\u0004\bW\u0010XR\u0011\u0010c\u001a\u0002098F¢\u0006\u0006\u001a\u0004\bd\u0010:¨\u0006n"},
   d2 = {"Lcom/blueair/auth/LocationService;", "Lorg/kodein/di/DIAware;", "context", "Landroid/content/Context;", "prefs", "Lcom/blueair/core/service/UnsecurePrefs;", "<init>", "(Landroid/content/Context;Lcom/blueair/core/service/UnsecurePrefs;)V", "getContext", "()Landroid/content/Context;", "di", "Lorg/kodein/di/DI;", "getDi", "()Lorg/kodein/di/DI;", "di$delegate", "Lkotlin/Lazy;", "authService", "Lcom/blueair/auth/AuthService;", "getAuthService", "()Lcom/blueair/auth/AuthService;", "authService$delegate", "resources", "Landroid/content/res/Resources;", "getResources", "()Landroid/content/res/Resources;", "baseUrl", "", "getBaseUrl", "()Ljava/lang/String;", "baseUrl$delegate", "cloudRegion", "getCloudRegion", "remoteConfig", "Lcom/blueair/auth/RemoteConfig;", "getRemoteConfig", "()Lcom/blueair/auth/RemoteConfig;", "okHttpClient", "Lokhttp3/OkHttpClient;", "getOkHttpClient", "()Lokhttp3/OkHttpClient;", "okHttpClient$delegate", "restAdapter", "Lretrofit2/Retrofit;", "getRestAdapter", "()Lretrofit2/Retrofit;", "restAdapter$delegate", "regionApi", "Lcom/blueair/auth/retrofit/RegionApi;", "getRegionApi", "()Lcom/blueair/auth/retrofit/RegionApi;", "regionApi$delegate", "value", "ablRegion", "getAblRegion", "deviceRegion", "getDeviceRegion", "isInKlaviyoRegion", "", "()Z", "isInTmallRegion", "isInAlexaRegion", "isInGoogleAssistantRegion", "isInIcpRegion", "isInAwareRegion", "isInB4Region", "isInG4Region", "isInRateUsRegion", "rateUsResetTimestamp", "", "getRateUsResetTimestamp", "()Ljava/lang/Long;", "isInWarrantyRegion", "isInGoogleLoginRegion", "isInFacebookLoginRegion", "isInWeChatLoginRegion", "isInQQLoginRegion", "isInWelcomeHomeRegion", "isInG4ProtectRegion", "isInAntiFakeRegion", "getAvailability", "", "useExclude", "useUserRegion", "regionMutex", "Lkotlinx/coroutines/sync/Mutex;", "marketLink", "getMarketLink", "setMarketLink", "(Ljava/lang/String;)V", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchBlueairRegion", "fetchAblRegion", "fetchRegion", "setRegion", "nuCountry", "getCountry", "isInChina", "isInDualProtectionRegion", "useProdGoogle", "getUseProdGoogle", "getGoogleClientId", "useProd", "getGoogleDeeplink", "getMapType", "Lcom/blueair/auth/LocationService$MapType;", "isMultiPassLink", "link", "MapType", "Companion", "auth_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class LocationService implements DIAware {
   static final KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property1((PropertyReference1)(new PropertyReference1Impl(LocationService.class, "di", "getDi()Lorg/kodein/di/DI;", 0))), Reflection.property1((PropertyReference1)(new PropertyReference1Impl(LocationService.class, "authService", "getAuthService()Lcom/blueair/auth/AuthService;", 0)))};
   public static final String CHINA = "cn";
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   public static final String HONGKONG = "hk";
   public static final String JAPAN = "jp";
   public static final String KOREA = "kr";
   public static final String MALAYSIA = "my";
   public static final String PHILIPPINES = "ph";
   public static final String SINGAPORE = "sg";
   public static final String TAIWAN = "tw";
   public static final String THAILAND = "th";
   public static final String USA = "us";
   public static final String VIETNAM = "vn";
   private String ablRegion;
   private final Lazy authService$delegate;
   private final Lazy baseUrl$delegate;
   private final Context context;
   private final Lazy di$delegate;
   public String marketLink;
   private final Lazy okHttpClient$delegate;
   private final UnsecurePrefs prefs;
   private final Lazy regionApi$delegate;
   private final Mutex regionMutex;
   private final RemoteConfig remoteConfig;
   private final Lazy restAdapter$delegate;

   // $FF: synthetic method
   public static Response $r8$lambda$D1zjok4HV4oR1iKwcgccmOLwO9g(Interceptor.Chain var0) {
      return okHttpClient_delegate$lambda$2$lambda$1(var0);
   }

   // $FF: synthetic method
   public static OkHttpClient $r8$lambda$h7HxNxzXi_9mtBP1rkmme_7KCaQ/* $FF was: $r8$lambda$h7HxNxzXi-9mtBP1rkmme-7KCaQ*/() {
      return okHttpClient_delegate$lambda$2();
   }

   // $FF: synthetic method
   public static RegionApi $r8$lambda$h_ci1ADIAAHHTj8y_WWugSk0fD8/* $FF was: $r8$lambda$h_ci1ADIAAHHTj8y-WWugSk0fD8*/(LocationService var0) {
      return regionApi_delegate$lambda$4(var0);
   }

   // $FF: synthetic method
   public static String $r8$lambda$s_OmUdbCDSN1Pq8FKAgQCxLLIPk/* $FF was: $r8$lambda$s-OmUdbCDSN1Pq8FKAgQCxLLIPk*/() {
      return baseUrl_delegate$lambda$0();
   }

   // $FF: synthetic method
   public static Retrofit $r8$lambda$vuCEexVwt2WX2XUPQ8fnjYlVIK4(LocationService var0) {
      return restAdapter_delegate$lambda$3(var0);
   }

   public LocationService(Context var1, UnsecurePrefs var2) {
      Intrinsics.checkNotNullParameter(var1, "context");
      Intrinsics.checkNotNullParameter(var2, "prefs");
      super();
      this.context = var1;
      this.prefs = var2;
      LazyContextDIPropertyDelegateProvider var5 = ClosestKt.closestDI(var1);
      KProperty[] var4 = $$delegatedProperties;
      this.di$delegate = var5.provideDelegate(this, var4[0]);
      DIAware var6 = this;
      JVMTypeToken var3 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var3, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      this.authService$delegate = DIAwareKt.Instance(var6, (TypeToken)(new GenericJVMTypeTokenDelegate(var3, AuthService.class)), (Object)null).provideDelegate(this, var4[1]);
      this.baseUrl$delegate = LazyKt.lazy(new LocationService$$ExternalSyntheticLambda1());
      this.remoteConfig = new RemoteConfigImpl();
      this.okHttpClient$delegate = LazyKt.lazy(new LocationService$$ExternalSyntheticLambda2());
      this.restAdapter$delegate = LazyKt.lazy(new LocationService$$ExternalSyntheticLambda3(this));
      this.regionApi$delegate = LazyKt.lazy(new LocationService$$ExternalSyntheticLambda4(this));
      this.regionMutex = MutexKt.Mutex$default(false, 1, (Object)null);
   }

   private static final String baseUrl_delegate$lambda$0() {
      return AblEnvironment.INSTANCE.getBaseUrl();
   }

   private final Object fetchAblRegion(Continuation var1) {
      label31: {
         if (var1 instanceof <undefinedtype>) {
            <undefinedtype> var3 = (<undefinedtype>)var1;
            if ((var3.label & Integer.MIN_VALUE) != 0) {
               var3.label += Integer.MIN_VALUE;
               var5 = var3;
               break label31;
            }
         }

         var5 = new ContinuationImpl(this, var1) {
            int label;
            Object result;
            final LocationService this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.fetchAblRegion((Continuation)this);
            }
         };
      }

      Object var9 = ((<undefinedtype>)var5).result;
      Object var4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var2 = ((<undefinedtype>)var5).label;
      Object var6;
      if (var2 != 0) {
         if (var2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         ResultKt.throwOnFailure(var9);
         var6 = var9;
      } else {
         ResultKt.throwOnFailure(var9);
         Function1 var10 = new Function1(this.getRegionApi()) {
            public final Object invoke(Continuation var1) {
               return ((RegionApi)this.receiver).getAblRegion(var1);
            }
         };
         ((<undefinedtype>)var5).label = 1;
         Object var11 = AuthServiceKt.doSuspendedApiCall(var10, (Continuation)var5);
         var6 = var11;
         if (var11 == var4) {
            return var4;
         }
      }

      ApiResult var7 = (ApiResult)var6;
      Timber.Forest var15 = Timber.Forest;
      StringBuilder var12 = new StringBuilder("fetchRegionSync: response = ");
      var12.append(var7);
      var15.d(var12.toString(), new Object[0]);
      if (var7.isSuccess()) {
         Timber.Forest var14 = Timber.Forest;
         StringBuilder var17 = new StringBuilder("fetchRegionSync: response.body = ");
         var17.append(var7.getOrNull());
         var14.d(var17.toString(), new Object[0]);
         AblRegion var8 = (AblRegion)var7.getOrNull();
         return var8 != null ? var8.getRegion() : null;
      } else {
         var15 = Timber.Forest;
         var12 = new StringBuilder("fetchRegionSync: failed with exception = ");
         var12.append(var7.exceptionOrNull());
         var15.w(var12.toString(), new Object[0]);
         return null;
      }
   }

   private final AuthService getAuthService() {
      return (AuthService)this.authService$delegate.getValue();
   }

   private final boolean getAvailability(Set var1, boolean var2, boolean var3) {
      String var4;
      if (var3) {
         var4 = this.getAuthService().getCloudUserRegion();
      } else {
         var4 = this.getDeviceRegion();
      }

      if (var2) {
         if (var1 != null) {
            return var1.isEmpty() || !var1.contains(var4);
         } else {
            return false;
         }
      } else if (var1 != null) {
         return !((Collection)var1).isEmpty() && var1.contains(var4);
      } else {
         return true;
      }
   }

   // $FF: synthetic method
   static boolean getAvailability$default(LocationService var0, Set var1, boolean var2, boolean var3, int var4, Object var5) {
      if ((var4 & 1) != 0) {
         var2 = false;
      }

      if ((var4 & 2) != 0) {
         var3 = false;
      }

      return var0.getAvailability(var1, var2, var3);
   }

   private final String getBaseUrl() {
      return (String)this.baseUrl$delegate.getValue();
   }

   // $FF: synthetic method
   public static String getGoogleClientId$default(LocationService var0, boolean var1, int var2, Object var3) {
      if ((var2 & 1) != 0) {
         var1 = var0.getUseProdGoogle();
      }

      return var0.getGoogleClientId(var1);
   }

   // $FF: synthetic method
   public static String getGoogleDeeplink$default(LocationService var0, boolean var1, int var2, Object var3) {
      if ((var2 & 1) != 0) {
         var1 = var0.getUseProdGoogle();
      }

      return var0.getGoogleDeeplink(var1);
   }

   private final OkHttpClient getOkHttpClient() {
      return (OkHttpClient)this.okHttpClient$delegate.getValue();
   }

   private final RegionApi getRegionApi() {
      Object var1 = this.regionApi$delegate.getValue();
      Intrinsics.checkNotNullExpressionValue(var1, "getValue(...)");
      return (RegionApi)var1;
   }

   private final Retrofit getRestAdapter() {
      Object var1 = this.restAdapter$delegate.getValue();
      Intrinsics.checkNotNullExpressionValue(var1, "getValue(...)");
      return (Retrofit)var1;
   }

   private static final OkHttpClient okHttpClient_delegate$lambda$2() {
      HttpLoggingInterceptor var1 = new HttpLoggingInterceptor((HttpLoggingInterceptor.Logger)null, 1, (DefaultConstructorMarker)null);
      HttpLoggingInterceptor.Level var0;
      if (BuildEnvironment.INSTANCE.getVariant() == BuildVariant.RELEASE) {
         var0 = Level.NONE;
      } else {
         var0 = Level.BODY;
      }

      var1.setLevel(var0);
      LocationService$$ExternalSyntheticLambda0 var2 = new LocationService$$ExternalSyntheticLambda0();
      return (new OkHttpClient.Builder()).addInterceptor(var2).addInterceptor((Interceptor)var1).build();
   }

   private static final Response okHttpClient_delegate$lambda$2$lambda$1(Interceptor.Chain var0) {
      Intrinsics.checkNotNullParameter(var0, "chain");
      return var0.proceed(var0.request().newBuilder().addHeader("X-API-KEY-TOKEN", AblEnvironment.INSTANCE.getApiKey()).build());
   }

   private static final RegionApi regionApi_delegate$lambda$4(LocationService var0) {
      return (RegionApi)var0.getRestAdapter().create(RegionApi.class);
   }

   private static final Retrofit restAdapter_delegate$lambda$3(LocationService var0) {
      return (new Retrofit.Builder()).baseUrl(var0.getBaseUrl()).addConverterFactory((Converter.Factory)MoshiConverterFactory.create((new Moshi.Builder()).add((JsonAdapter.Factory)(new KotlinJsonAdapterFactory())).add((JsonAdapter.Factory)(new KotlinJsonAdapterFactory())).build())).addCallAdapterFactory((CallAdapter.Factory)CoroutineCallAdapterFactory.Companion.create()).client(var0.getOkHttpClient()).build();
   }

   public final Object ablRegion(Continuation var1) {
      Object var3;
      label688: {
         if (var1 instanceof <undefinedtype>) {
            var3 = (<undefinedtype>)var1;
            if ((((<undefinedtype>)var3).label & Integer.MIN_VALUE) != 0) {
               ((<undefinedtype>)var3).label += Integer.MIN_VALUE;
               break label688;
            }
         }

         var3 = new ContinuationImpl(this, var1) {
            int I$0;
            int I$1;
            Object L$0;
            Object L$1;
            int label;
            Object result;
            final LocationService this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.ablRegion((Continuation)this);
            }
         };
      }

      label681: {
         Throwable var10000;
         label691: {
            label679: {
               label692: {
                  Object var4;
                  LocationService var56;
                  label693: {
                     var4 = ((<undefinedtype>)var3).result;
                     Object var5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                     int var2 = ((<undefinedtype>)var3).label;
                     if (var2 != 0) {
                        if (var2 != 1) {
                           if (var2 != 2) {
                              throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                           }

                           var2 = ((<undefinedtype>)var3).I$1;
                           var2 = ((<undefinedtype>)var3).I$0;
                           var56 = (LocationService)((<undefinedtype>)var3).L$1;
                           var52 = (Mutex)((<undefinedtype>)var3).L$0;
                           var48 = var52;

                           try {
                              ResultKt.throwOnFailure(var4);
                              break label693;
                           } catch (Throwable var44) {
                              var10000 = var44;
                              boolean var10001 = false;
                              break label691;
                           }
                        }

                        var2 = ((<undefinedtype>)var3).I$0;
                        var48 = (Mutex)((<undefinedtype>)var3).L$0;
                        ResultKt.throwOnFailure(var4);
                     } else {
                        ResultKt.throwOnFailure(var4);
                        var48 = this.regionMutex;
                        ((<undefinedtype>)var3).L$0 = var48;
                        ((<undefinedtype>)var3).I$0 = 0;
                        ((<undefinedtype>)var3).label = 1;
                        if (var48.lock((Object)null, (Continuation)var3) == var5) {
                           return var5;
                        }

                        var2 = 0;
                     }

                     label675: {
                        label695: {
                           try {
                              var54 = (CharSequence)this.ablRegion;
                           } catch (Throwable var47) {
                              var10000 = var47;
                              boolean var58 = false;
                              break label695;
                           }

                           if (var54 != null) {
                              try {
                                 if (var54.length() != 0) {
                                    break label692;
                                 }
                              } catch (Throwable var46) {
                                 var10000 = var46;
                                 boolean var59 = false;
                                 break label695;
                              }
                           }

                           label666:
                           try {
                              ((<undefinedtype>)var3).L$0 = var48;
                              ((<undefinedtype>)var3).L$1 = this;
                              ((<undefinedtype>)var3).I$0 = var2;
                              ((<undefinedtype>)var3).I$1 = 0;
                              ((<undefinedtype>)var3).label = 2;
                              var4 = this.fetchAblRegion((Continuation)var3);
                              break label675;
                           } catch (Throwable var45) {
                              var10000 = var45;
                              boolean var60 = false;
                              break label666;
                           }
                        }

                        var53 = var10000;
                        break label681;
                     }

                     if (var4 == var5) {
                        return var5;
                     }

                     var56 = this;
                     var52 = var48;
                  }

                  var48 = var52;

                  try {
                     var56.ablRegion = (String)var4;
                     break label679;
                  } catch (Throwable var43) {
                     var10000 = var43;
                     boolean var61 = false;
                     break label691;
                  }
               }

               var52 = var48;
            }

            var48 = var52;

            try {
               Unit var55 = Unit.INSTANCE;
            } catch (Throwable var42) {
               var10000 = var42;
               boolean var62 = false;
               break label691;
            }

            var52.unlock((Object)null);
            return Unit.INSTANCE;
         }

         var53 = var10000;
      }

      var48.unlock((Object)null);
      throw var53;
   }

   public final Object fetchBlueairRegion(Continuation var1) {
      label33: {
         if (var1 instanceof <undefinedtype>) {
            <undefinedtype> var3 = (<undefinedtype>)var1;
            if ((var3.label & Integer.MIN_VALUE) != 0) {
               var3.label += Integer.MIN_VALUE;
               var5 = var3;
               break label33;
            }
         }

         var5 = new ContinuationImpl(this, var1) {
            int label;
            Object result;
            final LocationService this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.fetchBlueairRegion((Continuation)this);
            }
         };
      }

      Object var11 = ((<undefinedtype>)var5).result;
      Object var4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var2 = ((<undefinedtype>)var5).label;
      Object var6;
      if (var2 != 0) {
         if (var2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         ResultKt.throwOnFailure(var11);
         var6 = var11;
      } else {
         ResultKt.throwOnFailure(var11);
         Function1 var12 = new Function1(this.getRegionApi()) {
            public final Object invoke(Continuation var1) {
               return ((RegionApi)this.receiver).getRegion(var1);
            }
         };
         ((<undefinedtype>)var5).label = 1;
         Object var13 = AuthServiceKt.doSuspendedApiCall(var12, (Continuation)var5);
         var6 = var13;
         if (var13 == var4) {
            return var4;
         }
      }

      ApiResult var7 = (ApiResult)var6;
      Timber.Forest var16 = Timber.Forest;
      StringBuilder var14 = new StringBuilder("fetchBlueairRegion: response = ");
      var14.append(var7);
      var16.d(var14.toString(), new Object[0]);
      if (var7.isSuccess()) {
         BlueairRegion var8 = (BlueairRegion)var7.getOrNull();
         if (var8 != null) {
            String var9 = var8.getCountryCode();
            if (var9 != null) {
               var9 = var9.toLowerCase(Locale.ROOT);
               Intrinsics.checkNotNullExpressionValue(var9, "toLowerCase(...)");
               return var9;
            }
         }

         return null;
      } else {
         Timber.Forest var15 = Timber.Forest;
         StringBuilder var17 = new StringBuilder("fetchBlueairRegion: failed with exception = ");
         var17.append(var7.exceptionOrNull());
         var15.w(var17.toString(), new Object[0]);
         return null;
      }
   }

   public final void fetchRegion() {
      BuildersKt.launch$default((CoroutineScope)GlobalScope.INSTANCE, (CoroutineContext)null, (CoroutineStart)null, new Function2(this, (Continuation)null) {
         int I$0;
         Object L$0;
         Object L$1;
         int label;
         final LocationService this$0;

         {
            this.this$0 = var1;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.this$0, var2));
         }

         public final Object invoke(CoroutineScope var1, Continuation var2) {
            return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
         }

         public final Object invokeSuspend(Object var1) {
            Object var4;
            label34: {
               var4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
               int var2 = this.label;
               if (var2 != 0) {
                  if (var2 != 1) {
                     if (var2 != 2) {
                        if (var2 != 3) {
                           throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }

                        String var8 = (String)this.L$1;
                        var8 = (String)this.L$0;
                        ResultKt.throwOnFailure(var1);
                        return Unit.INSTANCE;
                     }

                     String var3 = (String)this.L$0;
                     ResultKt.throwOnFailure(var1);
                     var6 = var3;
                     break label34;
                  }

                  ResultKt.throwOnFailure(var1);
               } else {
                  ResultKt.throwOnFailure(var1);
                  LocationService var10 = this.this$0;
                  Continuation var7 = (Continuation)this;
                  this.label = 1;
                  Object var11 = var10.fetchBlueairRegion(var7);
                  var1 = var11;
                  if (var11 == var4) {
                     return var4;
                  }
               }

               var6 = (String)var1;
               LocationService var12 = this.this$0;
               Continuation var5 = (Continuation)this;
               this.L$0 = var6;
               this.label = 2;
               if (var12.ablRegion(var5) == var4) {
                  return var4;
               }
            }

            if (var6 != null) {
               LocationService var14 = this.this$0;
               CoroutineContext var13 = CoroutineScopeKt.MainScope().getCoroutineContext();
               Function2 var15 = new Function2(var14, var6, (Continuation)null) {
                  final String $region;
                  int label;
                  final LocationService this$0;

                  {
                     this.this$0 = var1;
                     this.$region = var2;
                  }

                  public final Continuation create(Object var1, Continuation var2) {
                     return (Continuation)(new <anonymous constructor>(this.this$0, this.$region, var2));
                  }

                  public final Object invoke(CoroutineScope var1, Continuation var2) {
                     return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
                  }

                  public final Object invokeSuspend(Object var1) {
                     IntrinsicsKt.getCOROUTINE_SUSPENDED();
                     if (this.label == 0) {
                        ResultKt.throwOnFailure(var1);
                        this.this$0.setRegion(this.$region);
                        return Unit.INSTANCE;
                     } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                     }
                  }
               };
               this.L$0 = SpillingKt.nullOutSpilledVariable(var6);
               this.L$1 = SpillingKt.nullOutSpilledVariable(var6);
               this.I$0 = 0;
               this.label = 3;
               if (BuildersKt.withContext(var13, var15, this) == var4) {
                  return var4;
               }
            }

            return Unit.INSTANCE;
         }
      }, 3, (Object)null);
   }

   public final String getAblRegion() {
      return this.ablRegion;
   }

   public final String getCloudRegion() {
      return this.getAuthService().getCloudUserRegion();
   }

   public final Context getContext() {
      return this.context;
   }

   public final String getCountry() {
      Prefs var1 = this.prefs;
      String var3 = (String)PreferencesHelper.INSTANCE.get(var1.getBackend(), "country_code_pref", (Object)null, Reflection.getOrCreateKotlinClass(String.class));
      if (((CharSequence)var3).length() > 0) {
         Timber.Forest var7 = Timber.Forest;
         StringBuilder var9 = new StringBuilder("getCountry: pref country: ");
         var9.append(var3);
         var7.d(var9.toString(), new Object[0]);
         return var3;
      } else {
         var1 = this.prefs;
         String var5 = (String)PreferencesHelper.INSTANCE.get(var1.getBackend(), "region_country", (Object)null, Reflection.getOrCreateKotlinClass(String.class));
         Timber.Forest var2 = Timber.Forest;
         StringBuilder var10 = new StringBuilder("getCountry:  stored country: ");
         var10.append(var5);
         var2.v(var10.toString(), new Object[0]);
         if (((CharSequence)var5).length() > 0) {
            return var5;
         } else {
            String var8 = RegionUtils.INSTANCE.getBackupCountryCascading(this.context);
            Timber.Forest var11 = Timber.Forest;
            StringBuilder var6 = new StringBuilder("getCountry(): from backup cascading ");
            var6.append(var8);
            var11.v(var6.toString(), new Object[0]);
            return var8;
         }
      }
   }

   public final String getDeviceRegion() {
      String var2 = RegionUtils.INSTANCE.getResourceConfigCountryOrFallback(this.context);
      Timber.Forest var3 = Timber.Forest;
      StringBuilder var1 = new StringBuilder("deviceRegion: ");
      var1.append(var2);
      var3.v(var1.toString(), new Object[0]);
      return var2;
   }

   public DI getDi() {
      return (DI)this.di$delegate.getValue();
   }

   public DIContext getDiContext() {
      return DefaultImpls.getDiContext(this);
   }

   public DITrigger getDiTrigger() {
      return DefaultImpls.getDiTrigger(this);
   }

   public final String getGoogleClientId(boolean var1) {
      return var1 ? this.remoteConfig.getGoogleAssistantClientId() : this.remoteConfig.getGoogleAssistantClientIdDev();
   }

   public final String getGoogleDeeplink(boolean var1) {
      return var1 ? this.remoteConfig.getGoogleAssistantDeeplink() : this.remoteConfig.getGoogleAssistantDeeplinkDev();
   }

   public final MapType getMapType() {
      if (BuildEnvironment.INSTANCE.isChina()) {
         return LocationService.MapType.AMAP;
      } else {
         return PhoneUtil.INSTANCE.isGoogleServicesAvailable(this.context) ? LocationService.MapType.GOOGLE : LocationService.MapType.MAPBOX;
      }
   }

   public final String getMarketLink() {
      String var1 = this.marketLink;
      if (var1 != null) {
         return var1;
      } else {
         Intrinsics.throwUninitializedPropertyAccessException("marketLink");
         return null;
      }
   }

   public final Long getRateUsResetTimestamp() {
      Map var2 = this.remoteConfig.getRateUsPromo();
      if (var2 != null) {
         String var1 = this.getCountry().toLowerCase(Locale.ROOT);
         Intrinsics.checkNotNullExpressionValue(var1, "toLowerCase(...)");
         return (Long)var2.get(var1);
      } else {
         return null;
      }
   }

   public final RemoteConfig getRemoteConfig() {
      return this.remoteConfig;
   }

   public final Resources getResources() {
      Resources var1 = this.context.getResources();
      Intrinsics.checkNotNullExpressionValue(var1, "getResources(...)");
      return var1;
   }

   public final boolean getUseProdGoogle() {
      Prefs var1 = this.prefs;
      return (Boolean)PreferencesHelper.INSTANCE.get(var1.getBackend(), "KEY_GOOGLE_LIVE", true, Reflection.getOrCreateKotlinClass(Boolean.class));
   }

   public final boolean isInAlexaRegion() {
      return this.getAvailability(this.remoteConfig.getAlexaUnavailableCounties(), true, true);
   }

   public final boolean isInAntiFakeRegion() {
      return BuildEnvironment.INSTANCE.isChina();
   }

   public final boolean isInAwareRegion() {
      Prefs var3 = this.prefs;
      boolean var2 = (Boolean)PreferencesHelper.INSTANCE.get(var3.getBackend(), "KEY_FORCE_AWARE_AVAILABLE", false, Reflection.getOrCreateKotlinClass(Boolean.class));
      Collection var4 = (Collection)this.remoteConfig.getAwareUnavailableCountries();
      boolean var1;
      if (var4 != null && !var4.isEmpty()) {
         var1 = getAvailability$default(this, this.remoteConfig.getAwareUnavailableCountries(), true, false, 2, (Object)null);
      } else {
         var1 = getAvailability$default(this, this.remoteConfig.getAwareAvailableCountries(), false, false, 3, (Object)null);
      }

      return var2 || var1;
   }

   public final boolean isInB4Region() {
      Prefs var1 = this.prefs;
      return (Boolean)PreferencesHelper.INSTANCE.get(var1.getBackend(), "KEY_FORCE_B4_AVAILABLE", false, Reflection.getOrCreateKotlinClass(Boolean.class)) || getAvailability$default(this, this.remoteConfig.getB4AvailableCounties(), false, false, 3, (Object)null);
   }

   public final boolean isInChina() {
      String var3 = this.getCountry();
      Timber.Forest var2 = Timber.Forest;
      StringBuilder var1 = new StringBuilder("isInChina(): ");
      var1.append(var3);
      var2.v(var1.toString(), new Object[0]);
      return StringsKt.equals(var3, "cn", true);
   }

   public final boolean isInDualProtectionRegion() {
      String var2 = this.getCountry();
      int var1 = var2.hashCode();
      if (var1 != 3331) {
         if (var1 != 3398) {
            if (var1 != 3431) {
               if (var1 != 3500) {
                  if (var1 != 3576) {
                     if (var1 != 3668) {
                        if (var1 != 3700) {
                           if (var1 != 3715) {
                              if (var1 != 3742) {
                                 if (var1 != 3768 || !var2.equals("vn")) {
                                    return false;
                                 }
                              } else if (!var2.equals("us")) {
                                 return false;
                              }
                           } else if (!var2.equals("tw")) {
                              return false;
                           }
                        } else if (!var2.equals("th")) {
                           return false;
                        }
                     } else if (!var2.equals("sg")) {
                        return false;
                     }
                  } else if (!var2.equals("ph")) {
                     return false;
                  }
               } else if (!var2.equals("my")) {
                  return false;
               }
            } else if (!var2.equals("kr")) {
               return false;
            }
         } else if (!var2.equals("jp")) {
            return false;
         }
      } else if (!var2.equals("hk")) {
         return false;
      }

      return true;
   }

   public final boolean isInFacebookLoginRegion() {
      return getAvailability$default(this, this.remoteConfig.getFacebookLoginCountries(), false, false, 3, (Object)null);
   }

   public final boolean isInG4ProtectRegion() {
      boolean var1 = getAvailability$default(this, this.remoteConfig.getG4ProtectCountries(), false, false, 3, (Object)null);
      DeviceType.Companion.setInG4ProtectRegion(var1);
      return var1;
   }

   public final boolean isInG4Region() {
      Prefs var1 = this.prefs;
      return (Boolean)PreferencesHelper.INSTANCE.get(var1.getBackend(), "KEY_FORCE_G4_AVAILABLE", false, Reflection.getOrCreateKotlinClass(Boolean.class)) || getAvailability$default(this, this.remoteConfig.getG4AvailableCounties(), false, false, 3, (Object)null);
   }

   public final boolean isInGoogleAssistantRegion() {
      return this.getAvailability(this.remoteConfig.getGoogleAssistantUnavailableCountries(), true, true);
   }

   public final boolean isInGoogleLoginRegion() {
      return getAvailability$default(this, this.remoteConfig.getGoogleLoginCountries(), false, false, 3, (Object)null);
   }

   public final boolean isInIcpRegion() {
      Prefs var3 = this.prefs;
      boolean var2 = (Boolean)PreferencesHelper.INSTANCE.get(var3.getBackend(), "KEY_FORCE_ICP_AVAILABLE", false, Reflection.getOrCreateKotlinClass(Boolean.class));
      Collection var4 = (Collection)this.remoteConfig.getIcpUnavailableCountries();
      boolean var1;
      if (var4 != null && !var4.isEmpty()) {
         var1 = getAvailability$default(this, this.remoteConfig.getIcpUnavailableCountries(), true, false, 2, (Object)null);
      } else {
         var1 = getAvailability$default(this, this.remoteConfig.getIcpAvailableCountries(), false, false, 3, (Object)null);
      }

      return var2 || var1;
   }

   public final boolean isInKlaviyoRegion() {
      return this.getAvailability(this.remoteConfig.getKlaviyoAvailableCountries(), false, true);
   }

   public final boolean isInQQLoginRegion() {
      return getAvailability$default(this, this.remoteConfig.getQqLoginCountries(), false, false, 3, (Object)null);
   }

   public final boolean isInRateUsRegion() {
      return getAvailability$default(this, this.remoteConfig.getRateUsCountries(), false, false, 3, (Object)null);
   }

   public final boolean isInTmallRegion() {
      return getAvailability$default(this, this.remoteConfig.getTmallAvailableCounties(), false, false, 3, (Object)null);
   }

   public final boolean isInWarrantyRegion() {
      return getAvailability$default(this, this.remoteConfig.getWarrantyCountries(), false, false, 3, (Object)null);
   }

   public final boolean isInWeChatLoginRegion() {
      return getAvailability$default(this, this.remoteConfig.getWeChatLoginCountries(), false, false, 3, (Object)null);
   }

   public final boolean isInWelcomeHomeRegion() {
      Prefs var1 = this.prefs;
      return (Boolean)PreferencesHelper.INSTANCE.get(var1.getBackend(), "KEY_FORCE_WELCOME_HOME", false, Reflection.getOrCreateKotlinClass(Boolean.class)) || getAvailability$default(this, this.remoteConfig.getWelcomeHomeCountries(), false, false, 3, (Object)null);
   }

   public final boolean isMultiPassLink(String var1) {
      Intrinsics.checkNotNullParameter(var1, "link");
      Iterator var2 = ((Iterable)this.remoteConfig.getMultiPassRules()).iterator();

      while(var2.hasNext()) {
         if ((new Regex(StringsKt.replace$default((String)var2.next(), "\\\\", "\\", false, 4, (Object)null))).matches((CharSequence)var1)) {
            return true;
         }
      }

      return false;
   }

   public final void setMarketLink(String var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.marketLink = var1;
   }

   public final void setRegion(String var1) {
      Intrinsics.checkNotNullParameter(var1, "nuCountry");
      Timber.Forest var3 = Timber.Forest;
      StringBuilder var2 = new StringBuilder("setRegion: ");
      var2.append(var1);
      var3.v(var2.toString(), new Object[0]);
      Prefs var4 = this.prefs;
      PreferencesHelper.INSTANCE.set(var4.getBackend(), "region_country", var1, Reflection.getOrCreateKotlinClass(String.class));
   }

   @Metadata(
      d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0010"},
      d2 = {"Lcom/blueair/auth/LocationService$Companion;", "", "<init>", "()V", "CHINA", "", "KOREA", "USA", "PHILIPPINES", "THAILAND", "VIETNAM", "JAPAN", "TAIWAN", "HONGKONG", "MALAYSIA", "SINGAPORE", "auth_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Companion {
      private Companion() {
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker var1) {
         this();
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"},
      d2 = {"Lcom/blueair/auth/LocationService$MapType;", "", "<init>", "(Ljava/lang/String;I)V", "GOOGLE", "MAPBOX", "AMAP", "auth_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static enum MapType {
      private static final EnumEntries $ENTRIES;
      private static final MapType[] $VALUES;
      AMAP,
      GOOGLE,
      MAPBOX;

      // $FF: synthetic method
      private static final MapType[] $values() {
         return new MapType[]{GOOGLE, MAPBOX, AMAP};
      }

      static {
         MapType[] var0 = $values();
         $VALUES = var0;
         $ENTRIES = EnumEntriesKt.enumEntries(var0);
      }

      public static EnumEntries getEntries() {
         return $ENTRIES;
      }
   }
}
