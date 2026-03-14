package com.blueair.api.client;

import android.content.res.Resources;
import com.blueair.api.restapi.GetAqiDataByLatLngReq;
import com.blueair.api.restapi.GetAqiDataByLocationIdReq;
import com.blueair.api.restapi.OutdoorRestApi;
import com.blueair.auth.AuthService;
import com.blueair.core.model.AqiData;
import com.blueair.core.model.BlueAqiData;
import com.blueair.core.model.BlueAqiDataContent;
import com.blueair.core.model.TrackedLocation;
import io.flatcircle.coroutinehelper.ApiResult;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
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
   d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0003\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\"0!H\u0086@¢\u0006\u0002\u0010$J\u001c\u0010%\u001a\b\u0012\u0004\u0012\u00020#0!2\u0006\u0010&\u001a\u00020#H\u0086@¢\u0006\u0002\u0010'J\u001c\u0010(\u001a\b\u0012\u0004\u0012\u00020)0!2\u0006\u0010*\u001a\u00020#H\u0086@¢\u0006\u0002\u0010'J\u001c\u0010(\u001a\b\u0012\u0004\u0012\u00020)0!2\u0006\u0010+\u001a\u00020,H\u0086@¢\u0006\u0002\u0010-J(\u0010.\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020/0\"0!2\f\u00100\u001a\b\u0012\u0004\u0012\u00020#0\"H\u0086@¢\u0006\u0002\u00101J$\u00102\u001a\b\u0012\u0004\u0012\u00020/0!2\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u000204H\u0086@¢\u0006\u0002\u00106R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0012\u001a\u00020\u00138VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u001d8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f¨\u00067"},
   d2 = {"Lcom/blueair/api/client/OutdoorClient;", "Lcom/blueair/api/client/OutdoorCloudNetworkClient;", "resources", "Landroid/content/res/Resources;", "authService", "Lcom/blueair/auth/AuthService;", "mockInterceptor", "Lokhttp3/Interceptor;", "<init>", "(Landroid/content/res/Resources;Lcom/blueair/auth/AuthService;Lokhttp3/Interceptor;)V", "getResources", "()Landroid/content/res/Resources;", "getAuthService", "()Lcom/blueair/auth/AuthService;", "setAuthService", "(Lcom/blueair/auth/AuthService;)V", "getMockInterceptor", "()Lokhttp3/Interceptor;", "okHttpClient", "Lokhttp3/OkHttpClient;", "getOkHttpClient", "()Lokhttp3/OkHttpClient;", "okHttpClient$delegate", "Lkotlin/Lazy;", "retrofit", "Lretrofit2/Retrofit;", "getRetrofit", "()Lretrofit2/Retrofit;", "outdoorRestApi", "Lcom/blueair/api/restapi/OutdoorRestApi;", "getOutdoorRestApi", "()Lcom/blueair/api/restapi/OutdoorRestApi;", "getTrackedLocations", "Lio/flatcircle/coroutinehelper/ApiResult;", "", "Lcom/blueair/core/model/TrackedLocation;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addTrackedLocation", "trackedLocation", "(Lcom/blueair/core/model/TrackedLocation;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeTrackedLocation", "Lokhttp3/ResponseBody;", "location", "locationId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAqiDataByLocation", "Lcom/blueair/core/model/AqiData;", "locations", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAqiDataByLatLng", "lat", "", "lon", "(DDLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class OutdoorClient implements OutdoorCloudNetworkClient {
   private AuthService authService;
   private final Interceptor mockInterceptor;
   private final Lazy okHttpClient$delegate;
   private final Resources resources;

   // $FF: synthetic method
   public static OkHttpClient $r8$lambda$AuOmcs6_MDsAgx4GwSAPpdQR26U(OutdoorClient var0) {
      return okHttpClient_delegate$lambda$0(var0);
   }

   public OutdoorClient(Resources var1, AuthService var2, Interceptor var3) {
      Intrinsics.checkNotNullParameter(var1, "resources");
      Intrinsics.checkNotNullParameter(var2, "authService");
      super();
      this.resources = var1;
      this.authService = var2;
      this.mockInterceptor = var3;
      this.okHttpClient$delegate = LazyKt.lazy(new OutdoorClient$$ExternalSyntheticLambda0(this));
   }

   // $FF: synthetic method
   public OutdoorClient(Resources var1, AuthService var2, Interceptor var3, int var4, DefaultConstructorMarker var5) {
      if ((var4 & 4) != 0) {
         var3 = null;
      }

      this(var1, var2, var3);
   }

   private static final OkHttpClient okHttpClient_delegate$lambda$0(OutdoorClient var0) {
      return var0.buildHttpClient(false, var0.getMockInterceptor());
   }

   public final Object addTrackedLocation(TrackedLocation var1, Continuation var2) {
      return this.awaitCall(this.getOutdoorRestApi().addTrackedLocation(var1), var2);
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

   public final Object getAqiDataByLatLng(double var1, double var3, Continuation var5) {
      label29: {
         if (var5 instanceof <undefinedtype>) {
            <undefinedtype> var7 = (<undefinedtype>)var5;
            if ((var7.label & Integer.MIN_VALUE) != 0) {
               var7.label += Integer.MIN_VALUE;
               var13 = var7;
               break label29;
            }
         }

         var13 = new ContinuationImpl(this, var5) {
            double D$0;
            double D$1;
            int label;
            Object result;
            final OutdoorClient this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.getAqiDataByLatLng((double)0.0F, (double)0.0F, (Continuation)this);
            }
         };
      }

      Object var16 = ((<undefinedtype>)var13).result;
      Object var8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var6 = ((<undefinedtype>)var13).label;
      Object var14;
      if (var6 != 0) {
         if (var6 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         var1 = ((<undefinedtype>)var13).D$1;
         var1 = ((<undefinedtype>)var13).D$0;
         ResultKt.throwOnFailure(var16);
         var14 = var16;
      } else {
         ResultKt.throwOnFailure(var16);
         Deferred var17 = this.getOutdoorRestApi().getAqiDataByLatLng(new GetAqiDataByLatLngReq(var1, var3, (double)0.0F, (String)null, 12, (DefaultConstructorMarker)null));
         ((<undefinedtype>)var13).D$0 = var1;
         ((<undefinedtype>)var13).D$1 = var3;
         ((<undefinedtype>)var13).label = 1;
         Object var18 = this.awaitCall(var17, (Continuation)var13);
         var14 = var18;
         if (var18 == var8) {
            return var8;
         }
      }

      ApiResult var9 = (ApiResult)var14;
      ApiResult.Companion var20 = ApiResult.Companion;
      List var10 = (List)var9.getOrNull();
      var16 = null;
      AqiData var15 = (AqiData)var16;
      if (var10 != null) {
         BlueAqiDataContent var21 = (BlueAqiDataContent)CollectionsKt.firstOrNull(var10);
         var15 = (AqiData)var16;
         if (var21 != null) {
            var15 = BlueAqiData.toAqiData$default(new BlueAqiData("", var21), (SimpleDateFormat)null, 1, (Object)null);
         }
      }

      return var20.fromResult(var9, var15);
   }

   public final Object getAqiDataByLocation(List var1, Continuation var2) {
      label45: {
         if (var2 instanceof <undefinedtype>) {
            <undefinedtype> var4 = (<undefinedtype>)var2;
            if ((var4.label & Integer.MIN_VALUE) != 0) {
               var4.label += Integer.MIN_VALUE;
               var12 = var4;
               break label45;
            }
         }

         var12 = new ContinuationImpl(this, var2) {
            Object L$0;
            int label;
            Object result;
            final OutdoorClient this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.getAqiDataByLocation((List)null, (Continuation)this);
            }
         };
      }

      OutdoorRestApi var15 = (OutdoorRestApi)((<undefinedtype>)var12).result;
      Object var5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var3 = ((<undefinedtype>)var12).label;
      Object var9;
      if (var3 != 0) {
         if (var3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         List var8 = (List)((<undefinedtype>)var12).L$0;
         ResultKt.throwOnFailure(var15);
         var9 = var15;
      } else {
         ResultKt.throwOnFailure(var15);
         var15 = this.getOutdoorRestApi();
         Iterable var7 = (Iterable)var1;
         Collection var6 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var7, 10)));
         Iterator var22 = var7.iterator();

         while(var22.hasNext()) {
            var6.add(((TrackedLocation)var22.next()).getId());
         }

         Deferred var17 = var15.getAqiDataByLocationId(new GetAqiDataByLocationIdReq((List)var6, (double)0.0F, (String)null, 6, (DefaultConstructorMarker)null));
         ((<undefinedtype>)var12).L$0 = SpillingKt.nullOutSpilledVariable(var1);
         ((<undefinedtype>)var12).label = 1;
         Object var13 = this.awaitCall(var17, (Continuation)var12);
         var9 = var13;
         if (var13 == var5) {
            return var5;
         }
      }

      ApiResult var18 = (ApiResult)var9;
      ApiResult.Companion var14 = ApiResult.Companion;
      List var19 = (List)var18.getOrNull();
      List var10 = null;
      if (var19 != null) {
         Iterable var20 = (Iterable)var19;
         Collection var11 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var20, 10)));
         Iterator var21 = var20.iterator();

         while(var21.hasNext()) {
            var11.add(BlueAqiData.toAqiData$default((BlueAqiData)var21.next(), (SimpleDateFormat)null, 1, (Object)null));
         }

         var10 = (List)var11;
      }

      return var14.fromResult(var18, var10);
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

   public OutdoorRestApi getOutdoorRestApi() {
      Object var1 = this.getRetrofit().create(OutdoorRestApi.class);
      Intrinsics.checkNotNullExpressionValue(var1, "create(...)");
      return (OutdoorRestApi)var1;
   }

   public Resources getResources() {
      return this.resources;
   }

   public Retrofit getRetrofit() {
      return this.retroFitFactory(this.getAuthService().getBlueHomeHost());
   }

   public final Object getTrackedLocations(Continuation var1) {
      return this.awaitCall(this.getOutdoorRestApi().getTrackedLocations(), var1);
   }

   public final Object removeTrackedLocation(TrackedLocation var1, Continuation var2) {
      return this.removeTrackedLocation(var1.getId(), var2);
   }

   public final Object removeTrackedLocation(String var1, Continuation var2) {
      return this.awaitCall(this.getOutdoorRestApi().removeTrackedLocation(var1), var2);
   }

   public Retrofit retroFitFactory(String var1) {
      return BaseNetworkClient$_CC.$default$retroFitFactory(this, var1);
   }

   public void setAuthService(AuthService var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.authService = var1;
   }
}
