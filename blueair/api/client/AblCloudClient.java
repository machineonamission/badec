package com.blueair.api.client;

import android.content.res.Resources;
import com.blueair.api.model.DeviceInfoData;
import com.blueair.api.restapi.DatapointsWrapper;
import com.blueair.api.restapi.DeviceAblRestApi;
import com.blueair.api.restapi.DeviceAttributeName;
import com.blueair.api.restapi.DeviceAttributeOnAbl;
import com.blueair.api.restapi.SimpleResponse;
import com.blueair.auth.AuthService;
import com.blueair.core.model.DeviceSchedule;
import com.blueair.core.model.IndoorDatapoint;
import com.blueair.core.model.LegacyDeviceSchedule;
import io.flatcircle.coroutinehelper.ApiResult;
import io.flatcircle.coroutinehelper.Failure;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
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
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000Ì\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\t2\u00020\n2\u00020\u000b2\u00020\fB+\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u0014\u00101\u001a\b\u0012\u0004\u0012\u00020302H\u0096@¢\u0006\u0002\u00104J\"\u00105\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020306022\u0006\u00107\u001a\u000208H\u0096@¢\u0006\u0002\u00109J\u001a\u0010:\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020;0602H\u0096@¢\u0006\u0002\u00104J\u0018\u0010<\u001a\u00020;2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\u0012H\u0002J\u001c\u0010@\u001a\b\u0012\u0004\u0012\u00020A022\u0006\u0010B\u001a\u00020CH\u0096@¢\u0006\u0002\u0010DJ&\u0010E\u001a\b\u0012\u0004\u0012\u00020A022\u0006\u0010F\u001a\u00020C2\b\u0010G\u001a\u0004\u0018\u00010\u0012H\u0096@¢\u0006\u0002\u0010HJ\u001c\u0010I\u001a\b\u0012\u0004\u0012\u00020A022\u0006\u0010J\u001a\u00020CH\u0096@¢\u0006\u0002\u0010DJ\u001c\u0010K\u001a\b\u0012\u0004\u0012\u00020A022\u0006\u0010L\u001a\u00020CH\u0096@¢\u0006\u0002\u0010DJ\u001a\u0010M\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120602H\u0096@¢\u0006\u0002\u00104J\u001c\u0010N\u001a\b\u0012\u0004\u0012\u00020A022\u0006\u0010O\u001a\u00020\u0012H\u0096@¢\u0006\u0002\u0010PJ\u001c\u0010Q\u001a\b\u0012\u0004\u0012\u00020A022\u0006\u0010O\u001a\u00020\u0012H\u0096@¢\u0006\u0002\u0010PJ\u0014\u0010R\u001a\b\u0012\u0004\u0012\u00020S02H\u0096@¢\u0006\u0002\u00104J\u001c\u0010T\u001a\b\u0012\u0004\u0012\u00020S022\u0006\u0010?\u001a\u00020SH\u0096@¢\u0006\u0002\u0010UJ\u0014\u0010V\u001a\b\u0012\u0004\u0012\u00020W02H\u0096@¢\u0006\u0002\u00104J\u001c\u0010X\u001a\b\u0012\u0004\u0012\u00020S022\u0006\u0010Y\u001a\u00020WH\u0096@¢\u0006\u0002\u0010ZJ\u0014\u0010[\u001a\b\u0012\u0004\u0012\u00020\\02H\u0096@¢\u0006\u0002\u00104J\u001c\u0010]\u001a\b\u0012\u0004\u0012\u00020^022\u0006\u0010_\u001a\u00020`H\u0096@¢\u0006\u0002\u0010aJ\u0016\u0010b\u001a\u00020c2\u0006\u0010d\u001a\u00020\u0012H\u0096@¢\u0006\u0002\u0010PJ\u001e\u0010e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010S022\u0006\u0010_\u001a\u00020`H\u0096@¢\u0006\u0002\u0010aJ\u001a\u0010f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020`0602H\u0096@¢\u0006\u0002\u00104J\u001c\u0010g\u001a\b\u0012\u0004\u0012\u00020S022\u0006\u0010?\u001a\u00020\u0012H\u0096@¢\u0006\u0002\u0010PJ\u001c\u0010h\u001a\b\u0012\u0004\u0012\u00020A022\u0006\u0010i\u001a\u00020\u0012H\u0096@¢\u0006\u0002\u0010PJ\u0014\u0010j\u001a\b\u0012\u0004\u0012\u00020\u001202H\u0096@¢\u0006\u0002\u00104J\b\u0010k\u001a\u00020cH\u0016R\u0014\u0010\r\u001a\u00020\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u000f\u001a\u00020\u0010X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u0011\u001a\u00020\u0012X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u001b\u0010#\u001a\u00020$8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b%\u0010&R\u0014\u0010)\u001a\u00020*8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,R\u0014\u0010-\u001a\u00020.8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b/\u00100¨\u0006l"},
   d2 = {"Lcom/blueair/api/client/AblCloudClient;", "Lcom/blueair/api/client/AblCloudNetworkClient;", "Lcom/blueair/api/client/CanGetSensorData;", "Lcom/blueair/api/client/CanGetAttributes;", "Lcom/blueair/api/client/CanSetFan;", "Lcom/blueair/api/client/CanSetBrightness;", "Lcom/blueair/api/client/CanSetChildLock;", "Lcom/blueair/api/client/CanLinkWithAware;", "Lcom/blueair/api/client/CanSetAutoModeDependency;", "Lcom/blueair/api/client/CanSetDeviceName;", "Lcom/blueair/api/client/CanManageSchedule;", "Lcom/blueair/api/client/CanSetFilterType;", "Lcom/blueair/api/client/CanGetStatus;", "resources", "Landroid/content/res/Resources;", "authService", "Lcom/blueair/auth/AuthService;", "deviceUuid", "", "mockInterceptor", "Lokhttp3/Interceptor;", "<init>", "(Landroid/content/res/Resources;Lcom/blueair/auth/AuthService;Ljava/lang/String;Lokhttp3/Interceptor;)V", "getResources", "()Landroid/content/res/Resources;", "getAuthService", "()Lcom/blueair/auth/AuthService;", "setAuthService", "(Lcom/blueair/auth/AuthService;)V", "getDeviceUuid", "()Ljava/lang/String;", "setDeviceUuid", "(Ljava/lang/String;)V", "getMockInterceptor", "()Lokhttp3/Interceptor;", "okHttpClient", "Lokhttp3/OkHttpClient;", "getOkHttpClient", "()Lokhttp3/OkHttpClient;", "okHttpClient$delegate", "Lkotlin/Lazy;", "retrofit", "Lretrofit2/Retrofit;", "getRetrofit", "()Lretrofit2/Retrofit;", "deviceDetailsRestApi", "Lcom/blueair/api/restapi/DeviceAblRestApi;", "getDeviceDetailsRestApi", "()Lcom/blueair/api/restapi/DeviceAblRestApi;", "getLatestSensorPoint", "Lio/flatcircle/coroutinehelper/ApiResult;", "Lcom/blueair/core/model/IndoorDatapoint;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMonthSensorPoints", "", "fromTime", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAttributes", "Lcom/blueair/api/restapi/DeviceAttributeOnAbl;", "attributeForPost", "attribute", "Lcom/blueair/api/restapi/DeviceAttributeName;", "nuValue", "setFanSpeed", "Lcom/blueair/api/restapi/SimpleResponse;", "fanSpeed", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setAutoMode", "enabled", "type", "(ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setBrightness", "brightness", "setChildLock", "isLocked", "getLink", "setLink", "linkedUid", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteLink", "resetAutoModeDependency", "", "setAutoModeDependency", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDeviceInfoData", "Lcom/blueair/api/model/DeviceInfoData;", "setDeviceInfoData", "nuData", "(Lcom/blueair/api/model/DeviceInfoData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getIsUpdating", "", "createSchedule", "Lokhttp3/ResponseBody;", "schedule", "Lcom/blueair/core/model/DeviceSchedule;", "(Lcom/blueair/core/model/DeviceSchedule;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteSchedule", "", "scheduleId", "updateSchedule", "getSchedules", "setDeviceName", "setFilterType", "nuFilter", "getDeviceStatus", "clear", "api_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class AblCloudClient implements AblCloudNetworkClient, CanGetSensorData, CanGetAttributes, CanSetFan, CanSetBrightness, CanSetChildLock, CanLinkWithAware, CanSetAutoModeDependency, CanSetDeviceName, CanManageSchedule, CanSetFilterType, CanGetStatus {
   private AuthService authService;
   private String deviceUuid;
   private final Interceptor mockInterceptor;
   private final Lazy okHttpClient$delegate;
   private final Resources resources;

   // $FF: synthetic method
   public static OkHttpClient $r8$lambda$lSjOTT3O6pEcfFV08JBKxXiZpEA(AblCloudClient var0) {
      return okHttpClient_delegate$lambda$0(var0);
   }

   public AblCloudClient(Resources var1, AuthService var2, String var3, Interceptor var4) {
      Intrinsics.checkNotNullParameter(var1, "resources");
      Intrinsics.checkNotNullParameter(var2, "authService");
      Intrinsics.checkNotNullParameter(var3, "deviceUuid");
      super();
      this.resources = var1;
      this.authService = var2;
      this.deviceUuid = var3;
      this.mockInterceptor = var4;
      this.okHttpClient$delegate = LazyKt.lazy(new AblCloudClient$$ExternalSyntheticLambda0(this));
   }

   // $FF: synthetic method
   public AblCloudClient(Resources var1, AuthService var2, String var3, Interceptor var4, int var5, DefaultConstructorMarker var6) {
      if ((var5 & 8) != 0) {
         var4 = null;
      }

      this(var1, var2, var3, var4);
   }

   private final DeviceAttributeOnAbl attributeForPost(DeviceAttributeName var1, String var2) {
      return new DeviceAttributeOnAbl(this.getAuthService().getUserId(), this.getDeviceUuid(), (String)null, var1.getAttributeName(), var2, var2, 4, (DefaultConstructorMarker)null);
   }

   private static final OkHttpClient okHttpClient_delegate$lambda$0(AblCloudClient var0) {
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

   public Object createSchedule(DeviceSchedule var1, Continuation var2) {
      List var5 = DeviceSchedule.Companion.toLegacy$default(DeviceSchedule.Companion, var1, (Integer)null, 2, (Object)null);
      Iterator var4 = ((Iterable)var5).iterator();

      for(int var3 = 0; var4.hasNext(); ++var3) {
         Object var6 = var4.next();
         if (var3 < 0) {
            CollectionsKt.throwIndexOverflow();
         }

         LegacyDeviceSchedule var7 = (LegacyDeviceSchedule)var6;
         if (var3 == CollectionsKt.getLastIndex(var5)) {
            return this.awaitCall(this.getDeviceDetailsRestApi().createSchedule(var1.getDeviceId(), var7), var2);
         }

         this.getDeviceDetailsRestApi().createSchedule(var1.getDeviceId(), var7);
      }

      return ApiResult.Companion.notImplemented();
   }

   public Object deleteLink(String var1, Continuation var2) {
      return this.awaitCall(this.getDeviceDetailsRestApi().deleteLink(this.getDeviceUuid(), var1), var2);
   }

   public Object deleteSchedule(String var1, Continuation var2) {
      this.getDeviceDetailsRestApi().deleteSchedules(this.getDeviceUuid(), var1);
      return Unit.INSTANCE;
   }

   public Object doSuspendedApiCall(Function2 var1, Object var2, Continuation var3) {
      return BaseNetworkClient$_CC.$default$doSuspendedApiCall(this, var1, var2, var3);
   }

   public Object doSuspendedApiCall(Function3 var1, Object var2, Object var3, Continuation var4) {
      return BaseNetworkClient$_CC.$default$doSuspendedApiCall(this, var1, var2, var3, var4);
   }

   public Object getAttributes(Continuation var1) {
      return this.awaitCall(this.getDeviceDetailsRestApi().getAttributes(this.getDeviceUuid()), var1);
   }

   public AuthService getAuthService() {
      return this.authService;
   }

   public DeviceAblRestApi getDeviceDetailsRestApi() {
      Object var1 = this.getRetrofit().create(DeviceAblRestApi.class);
      Intrinsics.checkNotNullExpressionValue(var1, "create(...)");
      return (DeviceAblRestApi)var1;
   }

   public Object getDeviceInfoData(Continuation var1) {
      return this.awaitCall(this.getDeviceDetailsRestApi().getDeviceInfoData(this.getDeviceUuid()), var1);
   }

   public Object getDeviceStatus(Continuation var1) {
      Timber.Forest.d("getDeviceStatus called", new Object[0]);
      return this.awaitCall(this.getDeviceDetailsRestApi().getDeviceStatus(this.getDeviceUuid()), var1);
   }

   public String getDeviceUuid() {
      return this.deviceUuid;
   }

   public Object getIsUpdating(Continuation var1) {
      return this.awaitCall(this.getDeviceDetailsRestApi().getIsUpdating(this.getDeviceUuid()), var1);
   }

   public Object getLatestSensorPoint(Continuation var1) {
      label37: {
         if (var1 instanceof <undefinedtype>) {
            <undefinedtype> var4 = (<undefinedtype>)var1;
            if ((var4.label & Integer.MIN_VALUE) != 0) {
               var4.label += Integer.MIN_VALUE;
               var7 = var4;
               break label37;
            }
         }

         var7 = new ContinuationImpl(this, var1) {
            int label;
            Object result;
            final AblCloudClient this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.getLatestSensorPoint((Continuation)this);
            }
         };
      }

      Object var10 = ((<undefinedtype>)var7).result;
      Object var5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var2 = ((<undefinedtype>)var7).label;
      Object var8;
      if (var2 != 0) {
         if (var2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         ResultKt.throwOnFailure(var10);
         var8 = var10;
      } else {
         ResultKt.throwOnFailure(var10);
         Deferred var11 = this.getDeviceDetailsRestApi().getDatapoint(this.getDeviceUuid());
         ((<undefinedtype>)var7).label = 1;
         Object var12 = this.awaitCall(var11, (Continuation)var7);
         var8 = var12;
         if (var12 == var5) {
            return var5;
         }
      }

      ApiResult var14 = (ApiResult)var8;
      boolean var3 = var14.isFailure();
      var10 = null;
      if (var3) {
         return ApiResult.Companion.fromResult(var14, (Object)null);
      } else {
         DatapointsWrapper var6 = (DatapointsWrapper)var14.getOrNull();
         IndoorDatapoint var9 = (IndoorDatapoint)var10;
         if (var6 != null) {
            List var15 = var6.convertToIndoorDataPoints();
            var9 = (IndoorDatapoint)var10;
            if (var15 != null) {
               var9 = (IndoorDatapoint)CollectionsKt.firstOrNull(var15);
            }
         }

         return var9 == null ? new Failure((Throwable)(new IllegalArgumentException("You're not supposed to make this call on this device"))) : ApiResult.Companion.fromResult(var14, var9);
      }
   }

   public Object getLink(Continuation var1) {
      return this.awaitCall(this.getDeviceDetailsRestApi().getLink(this.getDeviceUuid()), var1);
   }

   public Interceptor getMockInterceptor() {
      return this.mockInterceptor;
   }

   public Object getMonthSensorPoints(long var1, Continuation var3) {
      label35: {
         if (var3 instanceof <undefinedtype>) {
            <undefinedtype> var6 = (<undefinedtype>)var3;
            if ((var6.label & Integer.MIN_VALUE) != 0) {
               var6.label += Integer.MIN_VALUE;
               var13 = var6;
               break label35;
            }
         }

         var13 = new ContinuationImpl(this, var3) {
            long J$0;
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            int label;
            Object result;
            final AblCloudClient this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.getMonthSensorPoints(0L, (Continuation)this);
            }
         };
      }

      Object var17 = ((<undefinedtype>)var13).result;
      DatapointsWrapper var7 = (DatapointsWrapper)IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var4 = ((<undefinedtype>)var13).label;
      Object var15;
      if (var4 != 0) {
         if (var4 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         var1 = ((<undefinedtype>)var13).J$0;
         String var21 = (String)((<undefinedtype>)var13).L$3;
         var21 = (String)((<undefinedtype>)var13).L$2;
         Calendar var23 = (Calendar)((<undefinedtype>)var13).L$1;
         SimpleDateFormat var14 = (SimpleDateFormat)((<undefinedtype>)var13).L$0;
         ResultKt.throwOnFailure(var17);
         var15 = var17;
      } else {
         ResultKt.throwOnFailure(var17);
         SimpleDateFormat var11 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
         Calendar var18 = Calendar.getInstance();
         String var9 = var11.format(var18.getTime());
         String var8 = var11.format(new Date(var1));
         Deferred var10 = this.getDeviceDetailsRestApi().getMonthDatapoints(this.getDeviceUuid(), var8.toString(), var9.toString());
         ((<undefinedtype>)var13).L$0 = SpillingKt.nullOutSpilledVariable(var11);
         ((<undefinedtype>)var13).L$1 = SpillingKt.nullOutSpilledVariable(var18);
         ((<undefinedtype>)var13).L$2 = SpillingKt.nullOutSpilledVariable(var9);
         ((<undefinedtype>)var13).L$3 = SpillingKt.nullOutSpilledVariable(var8);
         ((<undefinedtype>)var13).J$0 = var1;
         ((<undefinedtype>)var13).label = 1;
         Object var19 = this.awaitCall(var10, (Continuation)var13);
         var15 = var19;
         if (var19 == var7) {
            return var7;
         }
      }

      ApiResult var20 = (ApiResult)var15;
      boolean var5 = var20.isFailure();
      List var16 = null;
      if (var5) {
         return ApiResult.Companion.fromResult(var20, (Object)null);
      } else {
         var7 = (DatapointsWrapper)var20.getOrNull();
         if (var7 != null) {
            var16 = var7.convertToIndoorDataPoints();
         }

         return var16 == null ? new Failure((Throwable)(new IllegalArgumentException("You're not supposed to make this call on this device"))) : ApiResult.Companion.fromResult(var20, var16);
      }
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

   public Object getSchedules(Continuation var1) {
      label37: {
         if (var1 instanceof <undefinedtype>) {
            <undefinedtype> var3 = (<undefinedtype>)var1;
            if ((var3.label & Integer.MIN_VALUE) != 0) {
               var3.label += Integer.MIN_VALUE;
               var7 = var3;
               break label37;
            }
         }

         var7 = new ContinuationImpl(this, var1) {
            int label;
            Object result;
            final AblCloudClient this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.getSchedules((Continuation)this);
            }
         };
      }

      Object var12 = ((<undefinedtype>)var7).result;
      Object var4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var2 = ((<undefinedtype>)var7).label;
      Object var8;
      if (var2 != 0) {
         if (var2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         ResultKt.throwOnFailure(var12);
         var8 = var12;
      } else {
         ResultKt.throwOnFailure(var12);
         Deferred var13 = this.getDeviceDetailsRestApi().getSchedules(this.getDeviceUuid());
         ((<undefinedtype>)var7).label = 1;
         Object var14 = this.awaitCall(var13, (Continuation)var7);
         var8 = var14;
         if (var14 == var4) {
            return var4;
         }
      }

      ApiResult var15 = (ApiResult)var8;
      ApiResult.Companion var16 = ApiResult.Companion;
      List var9 = (List)var15.getOrNull();
      if (var9 != null) {
         Iterable var5 = (Iterable)var9;
         Collection var10 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var5, 10)));

         for(LegacyDeviceSchedule var6 : var5) {
            var10.add(DeviceSchedule.Companion.fromLegacy(var6));
         }

         var9 = (List)var10;
      } else {
         var9 = null;
      }

      return var16.fromResult(var15, var9);
   }

   public Object resetAutoModeDependency(Continuation var1) {
      return this.setAutoModeDependency("pm", var1);
   }

   public Retrofit retroFitFactory(String var1) {
      return BaseNetworkClient$_CC.$default$retroFitFactory(this, var1);
   }

   public void setAuthService(AuthService var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.authService = var1;
   }

   public Object setAutoMode(int var1, String var2, Continuation var3) {
      label53: {
         if (var3 instanceof <undefinedtype>) {
            <undefinedtype> var5 = (<undefinedtype>)var3;
            if ((var5.label & Integer.MIN_VALUE) != 0) {
               var5.label += Integer.MIN_VALUE;
               var19 = var5;
               break label53;
            }
         }

         var19 = new ContinuationImpl(this, var3) {
            int I$0;
            Object L$0;
            int label;
            Object result;
            final AblCloudClient this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.setAutoMode(0, (String)null, (Continuation)this);
            }
         };
      }

      Object var23 = ((<undefinedtype>)var19).result;
      Object var6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var4 = ((<undefinedtype>)var19).label;
      Object var13;
      if (var4 != 0) {
         if (var4 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         var1 = ((<undefinedtype>)var19).I$0;
         String var12 = (String)((<undefinedtype>)var19).L$0;
         ResultKt.throwOnFailure(var23);
         var13 = (SimpleResponse)var23;
      } else {
         ResultKt.throwOnFailure(var23);
         DeviceAblRestApi var7 = this.getDeviceDetailsRestApi();
         String var8 = this.getDeviceUuid();
         String var9 = DeviceAttributeName.Mode.getAttributeName();
         DeviceAttributeName var10 = DeviceAttributeName.Mode;
         String var24;
         if (var1 == 1) {
            var24 = "auto";
         } else {
            var24 = "manual";
         }

         Deferred var25 = var7.setAttribute(var8, var9, this.attributeForPost(var10, var24));
         ((<undefinedtype>)var19).L$0 = SpillingKt.nullOutSpilledVariable(var2);
         ((<undefinedtype>)var19).I$0 = var1;
         ((<undefinedtype>)var19).label = 1;
         Object var20 = this.awaitCall(var25, (Continuation)var19);
         var13 = (SimpleResponse)var20;
         if (var20 == var6) {
            return var6;
         }
      }

      ApiResult var27 = (ApiResult)var13;
      if (var27.isSuccess()) {
         var13 = (SimpleResponse)var27.getOrNull();
         if (var13 != null) {
            Integer var15 = var13.getState();
            if (var15 != null && var15 == 200) {
               return var27;
            }
         }

         ApiResult.Companion var26 = ApiResult.Companion;
         Throwable var21 = var27.exceptionOrNull();
         Throwable var16 = var21;
         if (var21 == null) {
            label42: {
               SimpleResponse var17 = (SimpleResponse)var27.getOrNull();
               if (var17 != null) {
                  String var22 = var17.getMessage();
                  var18 = var22;
                  if (var22 != null) {
                     break label42;
                  }
               }

               var18 = "Unknown API failure";
            }

            var16 = (Throwable)(new IOException(var18));
         }

         return var26.fail(var16);
      } else {
         return var27;
      }
   }

   public Object setAutoModeDependency(Object var1, Continuation var2) {
      DeviceAttributeName var4 = DeviceAttributeName.AutoModeDependency;
      DeviceAblRestApi var5 = this.getDeviceDetailsRestApi();
      String var3 = this.getDeviceUuid();
      String var6 = var4.getAttributeName();
      Intrinsics.checkNotNull(var1, "null cannot be cast to non-null type kotlin.String");
      return this.awaitCall(var5.setAttribute(var3, var6, this.attributeForPost(var4, (String)var1)), var2);
   }

   public Object setBrightness(int var1, Continuation var2) {
      label48: {
         if (var2 instanceof <undefinedtype>) {
            <undefinedtype> var4 = (<undefinedtype>)var2;
            if ((var4.label & Integer.MIN_VALUE) != 0) {
               var4.label += Integer.MIN_VALUE;
               var8 = var4;
               break label48;
            }
         }

         var8 = new ContinuationImpl(this, var2) {
            int I$0;
            int label;
            Object result;
            final AblCloudClient this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.setBrightness(0, (Continuation)this);
            }
         };
      }

      Object var15 = ((<undefinedtype>)var8).result;
      Object var5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var3 = ((<undefinedtype>)var8).label;
      Object var9;
      if (var3 != 0) {
         if (var3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         var1 = ((<undefinedtype>)var8).I$0;
         ResultKt.throwOnFailure(var15);
         var9 = (SimpleResponse)var15;
      } else {
         ResultKt.throwOnFailure(var15);
         Deferred var16 = this.getDeviceDetailsRestApi().setAttribute(this.getDeviceUuid(), DeviceAttributeName.Brightness.getAttributeName(), this.attributeForPost(DeviceAttributeName.Brightness, String.valueOf(var1)));
         ((<undefinedtype>)var8).I$0 = var1;
         ((<undefinedtype>)var8).label = 1;
         Object var17 = this.awaitCall(var16, (Continuation)var8);
         var9 = (SimpleResponse)var17;
         if (var17 == var5) {
            return var5;
         }
      }

      ApiResult var6 = (ApiResult)var9;
      if (var6.isSuccess()) {
         var9 = (SimpleResponse)var6.getOrNull();
         if (var9 != null) {
            Integer var11 = var9.getState();
            if (var11 != null && var11 == 200) {
               return var6;
            }
         }

         ApiResult.Companion var20 = ApiResult.Companion;
         Throwable var18 = var6.exceptionOrNull();
         Throwable var12 = var18;
         if (var18 == null) {
            label37: {
               SimpleResponse var13 = (SimpleResponse)var6.getOrNull();
               if (var13 != null) {
                  String var19 = var13.getMessage();
                  var14 = var19;
                  if (var19 != null) {
                     break label37;
                  }
               }

               var14 = "Unknown API failure";
            }

            var12 = (Throwable)(new IOException(var14));
         }

         return var20.fail(var12);
      } else {
         return var6;
      }
   }

   public Object setChildLock(int var1, Continuation var2) {
      label53: {
         if (var2 instanceof <undefinedtype>) {
            <undefinedtype> var4 = (<undefinedtype>)var2;
            if ((var4.label & Integer.MIN_VALUE) != 0) {
               var4.label += Integer.MIN_VALUE;
               var11 = var4;
               break label53;
            }
         }

         var11 = new ContinuationImpl(this, var2) {
            int I$0;
            int label;
            Object result;
            final AblCloudClient this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.setChildLock(0, (Continuation)this);
            }
         };
      }

      Object var18 = ((<undefinedtype>)var11).result;
      Object var5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var3 = ((<undefinedtype>)var11).label;
      Object var12;
      if (var3 != 0) {
         if (var3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         var1 = ((<undefinedtype>)var11).I$0;
         ResultKt.throwOnFailure(var18);
         var12 = (SimpleResponse)var18;
      } else {
         ResultKt.throwOnFailure(var18);
         DeviceAblRestApi var6 = this.getDeviceDetailsRestApi();
         String var7 = this.getDeviceUuid();
         String var9 = DeviceAttributeName.ChildLock.getAttributeName();
         DeviceAttributeName var8 = DeviceAttributeName.ChildLock;
         String var19;
         if (var1 == 1) {
            var19 = "1";
         } else {
            var19 = "0";
         }

         Deferred var20 = var6.setAttribute(var7, var9, this.attributeForPost(var8, var19));
         ((<undefinedtype>)var11).I$0 = var1;
         ((<undefinedtype>)var11).label = 1;
         Object var21 = this.awaitCall(var20, (Continuation)var11);
         var12 = (SimpleResponse)var21;
         if (var21 == var5) {
            return var5;
         }
      }

      ApiResult var25 = (ApiResult)var12;
      if (var25.isSuccess()) {
         var12 = (SimpleResponse)var25.getOrNull();
         if (var12 != null) {
            Integer var14 = var12.getState();
            if (var14 != null && var14 == 200) {
               return var25;
            }
         }

         ApiResult.Companion var24 = ApiResult.Companion;
         Throwable var22 = var25.exceptionOrNull();
         Throwable var15 = var22;
         if (var22 == null) {
            label42: {
               SimpleResponse var16 = (SimpleResponse)var25.getOrNull();
               if (var16 != null) {
                  String var23 = var16.getMessage();
                  var17 = var23;
                  if (var23 != null) {
                     break label42;
                  }
               }

               var17 = "Unknown API failure";
            }

            var15 = (Throwable)(new IOException(var17));
         }

         return var24.fail(var15);
      } else {
         return var25;
      }
   }

   public Object setDeviceInfoData(DeviceInfoData var1, Continuation var2) {
      return this.awaitCall(this.getDeviceDetailsRestApi().setDeviceInfoData(this.getDeviceUuid(), var1), var2);
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
            final AblCloudClient this$0;

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
      label48: {
         if (var2 instanceof <undefinedtype>) {
            <undefinedtype> var4 = (<undefinedtype>)var2;
            if ((var4.label & Integer.MIN_VALUE) != 0) {
               var4.label += Integer.MIN_VALUE;
               var8 = var4;
               break label48;
            }
         }

         var8 = new ContinuationImpl(this, var2) {
            int I$0;
            int label;
            Object result;
            final AblCloudClient this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.setFanSpeed(0, (Continuation)this);
            }
         };
      }

      Object var15 = ((<undefinedtype>)var8).result;
      Object var5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var3 = ((<undefinedtype>)var8).label;
      Object var9;
      if (var3 != 0) {
         if (var3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         var1 = ((<undefinedtype>)var8).I$0;
         ResultKt.throwOnFailure(var15);
         var9 = (SimpleResponse)var15;
      } else {
         ResultKt.throwOnFailure(var15);
         Deferred var16 = this.getDeviceDetailsRestApi().setAttribute(this.getDeviceUuid(), DeviceAttributeName.FanSpeed.getAttributeName(), this.attributeForPost(DeviceAttributeName.FanSpeed, String.valueOf(var1)));
         ((<undefinedtype>)var8).I$0 = var1;
         ((<undefinedtype>)var8).label = 1;
         Object var17 = this.awaitCall(var16, (Continuation)var8);
         var9 = (SimpleResponse)var17;
         if (var17 == var5) {
            return var5;
         }
      }

      ApiResult var6 = (ApiResult)var9;
      if (var6.isSuccess()) {
         var9 = (SimpleResponse)var6.getOrNull();
         if (var9 != null) {
            Integer var11 = var9.getState();
            if (var11 != null && var11 == 200) {
               return var6;
            }
         }

         ApiResult.Companion var20 = ApiResult.Companion;
         Throwable var18 = var6.exceptionOrNull();
         Throwable var12 = var18;
         if (var18 == null) {
            label37: {
               SimpleResponse var13 = (SimpleResponse)var6.getOrNull();
               if (var13 != null) {
                  String var19 = var13.getMessage();
                  var14 = var19;
                  if (var19 != null) {
                     break label37;
                  }
               }

               var14 = "Unknown API failure";
            }

            var12 = (Throwable)(new IOException(var14));
         }

         return var20.fail(var12);
      } else {
         return var6;
      }
   }

   public Object setFilterType(String var1, Continuation var2) {
      label48: {
         if (var2 instanceof <undefinedtype>) {
            <undefinedtype> var4 = (<undefinedtype>)var2;
            if ((var4.label & Integer.MIN_VALUE) != 0) {
               var4.label += Integer.MIN_VALUE;
               var13 = var4;
               break label48;
            }
         }

         var13 = new ContinuationImpl(this, var2) {
            Object L$0;
            int label;
            Object result;
            final AblCloudClient this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.setFilterType((String)null, (Continuation)this);
            }
         };
      }

      Object var17 = ((<undefinedtype>)var13).result;
      Object var5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var3 = ((<undefinedtype>)var13).label;
      Object var7;
      if (var3 != 0) {
         if (var3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         String var6 = (String)((<undefinedtype>)var13).L$0;
         ResultKt.throwOnFailure(var17);
         var7 = (SimpleResponse)var17;
      } else {
         ResultKt.throwOnFailure(var17);
         Deferred var18 = this.getDeviceDetailsRestApi().setAttribute(this.getDeviceUuid(), DeviceAttributeName.FilterType.getAttributeName(), this.attributeForPost(DeviceAttributeName.FilterType, var1));
         ((<undefinedtype>)var13).L$0 = SpillingKt.nullOutSpilledVariable(var1);
         ((<undefinedtype>)var13).label = 1;
         Object var14 = this.awaitCall(var18, (Continuation)var13);
         var7 = (SimpleResponse)var14;
         if (var14 == var5) {
            return var5;
         }
      }

      ApiResult var20 = (ApiResult)var7;
      if (var20.isSuccess()) {
         var7 = (SimpleResponse)var20.getOrNull();
         if (var7 != null) {
            Integer var9 = var7.getState();
            if (var9 != null && var9 == 200) {
               return var20;
            }
         }

         ApiResult.Companion var19 = ApiResult.Companion;
         Throwable var15 = var20.exceptionOrNull();
         Throwable var10 = var15;
         if (var15 == null) {
            label37: {
               SimpleResponse var11 = (SimpleResponse)var20.getOrNull();
               if (var11 != null) {
                  String var16 = var11.getMessage();
                  var12 = var16;
                  if (var16 != null) {
                     break label37;
                  }
               }

               var12 = "Unknown API failure";
            }

            var10 = (Throwable)(new IOException(var12));
         }

         return var19.fail(var10);
      } else {
         return var20;
      }
   }

   public Object setLink(String var1, Continuation var2) {
      return this.awaitCall(this.getDeviceDetailsRestApi().setLink(this.getDeviceUuid(), var1), var2);
   }

   public Object updateSchedule(DeviceSchedule var1, Continuation var2) {
      label23: {
         if (var2 instanceof <undefinedtype>) {
            <undefinedtype> var4 = (<undefinedtype>)var2;
            if ((var4.label & Integer.MIN_VALUE) != 0) {
               var4.label += Integer.MIN_VALUE;
               var8 = var4;
               break label23;
            }
         }

         var8 = new ContinuationImpl(this, var2) {
            Object L$0;
            int label;
            Object result;
            final AblCloudClient this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.updateSchedule((DeviceSchedule)null, (Continuation)this);
            }
         };
      }

      Object var10 = ((<undefinedtype>)var8).result;
      Object var5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var3 = ((<undefinedtype>)var8).label;
      Object var7;
      if (var3 != 0) {
         if (var3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         DeviceSchedule var6 = (DeviceSchedule)((<undefinedtype>)var8).L$0;
         ResultKt.throwOnFailure(var10);
         var7 = var10;
      } else {
         ResultKt.throwOnFailure(var10);
         ((<undefinedtype>)var8).L$0 = SpillingKt.nullOutSpilledVariable(var1);
         ((<undefinedtype>)var8).label = 1;
         Object var9 = this.createSchedule(var1, (Continuation)var8);
         var7 = var9;
         if (var9 == var5) {
            return var5;
         }
      }

      Intrinsics.checkNotNull(var7, "null cannot be cast to non-null type io.flatcircle.coroutinehelper.ApiResult<kotlin.Any?>");
      return (ApiResult)var7;
   }
}
