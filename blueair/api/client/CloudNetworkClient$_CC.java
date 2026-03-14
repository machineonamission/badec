package com.blueair.api.client;

import com.blueair.core.AblEnvironment;
import com.blueair.core.BuildEnvironment;
import com.blueair.core.BuildVariant;
import com.blueair.core.model.UserInfoItem;
import com.blueair.core.util.UserInfoCollectionsManager;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import okhttp3.Connection;
import okhttp3.Credentials;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import retrofit2.Retrofit;
import timber.log.Timber;

// $FF: synthetic class
public final class CloudNetworkClient$_CC {
   public static OkHttpClient $default$buildBasicAuthClient(CloudNetworkClient var0, Interceptor var1) {
      HttpLoggingInterceptor var2 = new HttpLoggingInterceptor((HttpLoggingInterceptor.Logger)null, 1, (DefaultConstructorMarker)null);
      HttpLoggingInterceptor.Level var3;
      if (BuildEnvironment.INSTANCE.getVariant() == BuildVariant.RELEASE) {
         var3 = Level.NONE;
      } else {
         var3 = Level.BODY;
      }

      var2.setLevel(var3);
      Timber.Forest.d("", new Object[0]);
      OkHttpClient.Builder var4 = (new OkHttpClient.Builder()).addNetworkInterceptor(new Interceptor() {
         public final Response intercept(Interceptor.Chain var1) {
            Intrinsics.checkNotNullParameter(var1, "chain");
            Request var2 = var1.request();
            Request.Builder var3 = var2.newBuilder().method(var2.method(), var2.body());
            var3.addHeader("Authorization", Credentials.basic$default("blueair_legacy", "legUpgrade%$+!", (Charset)null, 4, (Object)null));
            return var1.proceed(var3.build());
         }
      }).addInterceptor((Interceptor)var2).connectTimeout(45L, TimeUnit.SECONDS).readTimeout(30L, TimeUnit.SECONDS).writeTimeout(30L, TimeUnit.SECONDS);
      return var1 != null ? var4.addInterceptor(var1).build() : var4.build();
   }

   public static OkHttpClient $default$buildHttpClient(CloudNetworkClient var0, boolean var1, Interceptor var2) {
      HttpLoggingInterceptor var4 = new HttpLoggingInterceptor((HttpLoggingInterceptor.Logger)null, 1, (DefaultConstructorMarker)null);
      HttpLoggingInterceptor.Level var3;
      if (BuildEnvironment.INSTANCE.getVariant() == BuildVariant.RELEASE) {
         var3 = Level.NONE;
      } else {
         var3 = Level.BODY;
      }

      var4.setLevel(var3);
      OkHttpClient.Builder var5 = (new OkHttpClient.Builder()).addInterceptor((Interceptor)var4).addNetworkInterceptor(new Interceptor(var1, var0) {
         final boolean $isAbl$inlined;
         final CloudNetworkClient this$0;

         public {
            this.$isAbl$inlined = var1;
            this.this$0 = var2;
         }

         public final Response intercept(Interceptor.Chain var1) {
            Object var3;
            UserInfoCollectionsManager var4;
            UserInfoItem var5;
            InetAddress var7;
            label41: {
               Intrinsics.checkNotNullParameter(var1, "chain");
               var4 = UserInfoCollectionsManager.INSTANCE;
               var5 = UserInfoItem.NET_IP;
               Connection var2 = var1.connection();
               var3 = null;
               if (var2 != null) {
                  Socket var6 = var2.socket();
                  if (var6 != null) {
                     var7 = var6.getLocalAddress();
                     break label41;
                  }
               }

               var7 = null;
            }

            UserInfoCollectionsManager.addRecord$default(var4, var5, String.valueOf(var7), false, 4, (Object)null);
            Request var8 = var1.request();
            String var11 = var8.header("Authorization");
            Request.Builder var9 = var8.newBuilder().method(var8.method(), var8.body());
            if (this.$isAbl$inlined) {
               CharSequence var12 = (CharSequence)var11;
               if (var12 == null || var12.length() == 0) {
                  StringBuilder var13 = new StringBuilder("Bearer ");
                  var13.append(this.this$0.getAuthService().getGigyaJwt());
                  var9.addHeader("Authorization", var13.toString());
               }

               var9.addHeader("X-API-KEY-TOKEN", AblEnvironment.INSTANCE.getApiKey());
            } else {
               CharSequence var14 = (CharSequence)var11;
               if (var14 == null || var14.length() == 0) {
                  StringBuilder var15 = new StringBuilder("Bearer ");
                  var15.append((String)BuildersKt.runBlocking$default((CoroutineContext)null, new Function2(this.this$0, (Continuation)null) {
                     int label;
                     final CloudNetworkClient this$0;

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
                        Object var3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int var2 = this.label;
                        if (var2 != 0) {
                           if (var2 == 1) {
                              ResultKt.throwOnFailure(var1);
                              return var1;
                           } else {
                              throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                           }
                        } else {
                           ResultKt.throwOnFailure(var1);
                           var1 = this.this$0.getAuthService();
                           Continuation var4 = (Continuation)this;
                           this.label = 1;
                           var1 = var1.getCloudJwt(var4);
                           return var1 == var3 ? var3 : var1;
                        }
                     }
                  }, 1, (Object)null));
                  var9.addHeader("Authorization", var15.toString());
               }

               var9.addHeader("X-Source", "android");
            }

            Request var16 = var9.build();
            String var17 = var16.header("Authorization");
            String var10 = (String)var3;
            if (var17 != null) {
               var10 = StringsKt.trim((CharSequence)var17).toString();
            }

            if (Intrinsics.areEqual(var10, "Bearer")) {
               var1.call().cancel();
            }

            return var1.proceed(var16);
         }
      }).connectTimeout(45L, TimeUnit.SECONDS).readTimeout(30L, TimeUnit.SECONDS).writeTimeout(30L, TimeUnit.SECONDS);
      return var2 != null ? var5.addInterceptor(var2).build() : var5.build();
   }

   public static OkHttpClient $default$buildHttpClientWithFakeUserSupport(CloudNetworkClient var0, boolean var1, Interceptor var2) {
      HttpLoggingInterceptor var4 = new HttpLoggingInterceptor((HttpLoggingInterceptor.Logger)null, 1, (DefaultConstructorMarker)null);
      HttpLoggingInterceptor.Level var3;
      if (BuildEnvironment.INSTANCE.getVariant() == BuildVariant.RELEASE) {
         var3 = Level.NONE;
      } else {
         var3 = Level.BODY;
      }

      var4.setLevel(var3);
      Timber.Forest.d("", new Object[0]);
      OkHttpClient.Builder var5 = (new OkHttpClient.Builder()).addNetworkInterceptor(new Interceptor(var1, var0) {
         final boolean $isAbl$inlined;
         final CloudNetworkClient this$0;

         public {
            this.$isAbl$inlined = var1;
            this.this$0 = var2;
         }

         public final Response intercept(Interceptor.Chain var1) {
            Intrinsics.checkNotNullParameter(var1, "chain");
            Request var2 = var1.request();
            Request.Builder var4 = var2.newBuilder().method(var2.method(), var2.body());
            if (this.$isAbl$inlined) {
               var4.addHeader("X-API-KEY-TOKEN", AblEnvironment.INSTANCE.getApiKey());
               if ((Boolean)this.this$0.getAuthService().isUserLoggedIn().getValue()) {
                  StringBuilder var3 = new StringBuilder("Bearer ");
                  var3.append(this.this$0.getAuthService().getGigyaJwt());
                  var4.addHeader("Authorization", var3.toString());
               } else {
                  var4.addHeader("Authorization", Credentials.basic$default("blueairoutdoor@gmail.com", "outdoordata", (Charset)null, 4, (Object)null));
               }
            }

            return var1.proceed(var4.build());
         }
      }).addInterceptor((Interceptor)var4).connectTimeout(45L, TimeUnit.SECONDS).readTimeout(30L, TimeUnit.SECONDS).writeTimeout(30L, TimeUnit.SECONDS);
      return var2 != null ? var5.addInterceptor(var2).build() : var5.build();
   }

   // $FF: synthetic method
   public static Object access$awaitAllCalls$jd(CloudNetworkClient var0, List var1, Continuation var2) {
      return BaseNetworkClient$_CC.$default$awaitAllCalls(var0, var1, var2);
   }

   // $FF: synthetic method
   public static Object access$awaitCall$jd(CloudNetworkClient var0, Deferred var1, Continuation var2) {
      return BaseNetworkClient$_CC.$default$awaitCall(var0, var1, var2);
   }

   // $FF: synthetic method
   public static OkHttpClient access$buildBasicAuthClient$jd(CloudNetworkClient var0, Interceptor var1) {
      return $default$buildBasicAuthClient(var0, var1);
   }

   // $FF: synthetic method
   public static OkHttpClient access$buildHttpClient$jd(CloudNetworkClient var0, boolean var1, Interceptor var2) {
      return $default$buildHttpClient(var0, var1, var2);
   }

   // $FF: synthetic method
   public static OkHttpClient access$buildHttpClientWithFakeUserSupport$jd(CloudNetworkClient var0, boolean var1, Interceptor var2) {
      return $default$buildHttpClientWithFakeUserSupport(var0, var1, var2);
   }

   // $FF: synthetic method
   public static Object access$doSuspendedApiCall$jd(CloudNetworkClient var0, Function2 var1, Object var2, Continuation var3) {
      return BaseNetworkClient$_CC.$default$doSuspendedApiCall(var0, var1, var2, var3);
   }

   // $FF: synthetic method
   public static Object access$doSuspendedApiCall$jd(CloudNetworkClient var0, Function3 var1, Object var2, Object var3, Continuation var4) {
      return BaseNetworkClient$_CC.$default$doSuspendedApiCall(var0, var1, var2, var3, var4);
   }

   // $FF: synthetic method
   public static Retrofit access$retroFitFactory$jd(CloudNetworkClient var0, String var1) {
      return BaseNetworkClient$_CC.$default$retroFitFactory(var0, var1);
   }
}
