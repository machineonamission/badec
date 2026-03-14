package com.blueair.outdoor.service;

import android.content.Context;
import androidx.lifecycle.LiveData;
import com.blueair.api.client.OutdoorClient;
import com.blueair.auth.AuthService;
import com.blueair.auth.LogOutable;
import com.blueair.core.model.AqiData;
import com.blueair.core.model.OutdoorPollutants;
import com.blueair.core.model.TrackedLocation;
import com.blueair.core.model.UserInfoItem;
import com.blueair.core.util.CoordinateTransformUtils;
import com.blueair.core.util.PersistentObjectDelegate;
import com.blueair.core.util.UserInfoCollectionsManager;
import com.blueair.database.repository.TrackedLocationRepository;
import com.blueair.sdk.KlaviyoProfileLocationData;
import com.blueair.sdk.KlaviyoSdk;
import io.flatcircle.coroutinehelper.ApiResult;
import io.flatcircle.coroutinehelper.ApiResultKt;
import io.flatcircle.coroutinehelper.DefaultCoroutineScope;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import okhttp3.ResponseBody;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B/\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u0016\u0010/\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010-0 2\u0006\u00100\u001a\u00020\u001cJ\u0016\u00101\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0 2\u0006\u00102\u001a\u00020\u0011J\u0018\u00103\u001a\u0004\u0018\u00010\u001c2\u0006\u00102\u001a\u00020\u0011H\u0086@¢\u0006\u0002\u00104J\u001e\u00105\u001a\u0002062\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u000208H\u0086@¢\u0006\u0002\u0010:J\u000e\u0010;\u001a\u000206H\u0086@¢\u0006\u0002\u0010<J\u0014\u0010=\u001a\b\u0012\u0004\u0012\u00020?0>H\u0086@¢\u0006\u0002\u0010<J,\u0010@\u001a\b\u0012\u0004\u0012\u00020\u001c0>2\u0006\u0010A\u001a\u00020\u001c2\u0006\u0010B\u001a\u00020-2\u0006\u0010C\u001a\u00020?H\u0086@¢\u0006\u0002\u0010DJ\u0016\u0010E\u001a\u00020?2\u0006\u0010A\u001a\u00020\u001cH\u0086@¢\u0006\u0002\u0010FJ6\u0010G\u001a\u0010\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020-\u0018\u00010H2\u0006\u00107\u001a\u0002082\u0006\u0010I\u001a\u0002082\b\u0010J\u001a\u0004\u0018\u00010\u0011H\u0086@¢\u0006\u0002\u0010KJ\u001c\u0010L\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\f\u0010M\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0002J\"\u0010N\u001a\b\u0012\u0004\u0012\u00020-0\u001b2\f\u0010M\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0086@¢\u0006\u0002\u0010OJ\"\u0010N\u001a\u0004\u0018\u00010-2\u0006\u00100\u001a\u00020\u001c2\b\b\u0002\u0010P\u001a\u00020?H\u0086@¢\u0006\u0002\u0010QJ\u0018\u0010R\u001a\u0004\u0018\u00010-2\u0006\u00100\u001a\u00020\u001cH\u0086@¢\u0006\u0002\u0010FJ\b\u0010S\u001a\u000206H\u0002J\b\u0010T\u001a\u000206H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000RC\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u00102\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u00108B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u001d\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u001b0 ¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0017\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8F¢\u0006\u0006\u001a\u0004\b$\u0010\u001eR\u001d\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u001b0 ¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\"R\u0013\u0010'\u001a\u0004\u0018\u00010\u001c8F¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0019\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0 ¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\"R\u001d\u0010,\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020-0\u001b0 ¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\"R\u0012\u0010U\u001a\u00020VX\u0096\u0005¢\u0006\u0006\u001a\u0004\bW\u0010X¨\u0006Y"},
   d2 = {"Lcom/blueair/outdoor/service/OutdoorService;", "Lkotlinx/coroutines/CoroutineScope;", "Lcom/blueair/auth/LogOutable;", "context", "Landroid/content/Context;", "trackedLocationRepository", "Lcom/blueair/database/repository/TrackedLocationRepository;", "outdoorClient", "Lcom/blueair/api/client/OutdoorClient;", "geocodeService", "Lcom/blueair/outdoor/service/GeocodeService;", "authService", "Lcom/blueair/auth/AuthService;", "<init>", "(Landroid/content/Context;Lcom/blueair/database/repository/TrackedLocationRepository;Lcom/blueair/api/client/OutdoorClient;Lcom/blueair/outdoor/service/GeocodeService;Lcom/blueair/auth/AuthService;)V", "<set-?>", "", "", "", "aqiDataRefreshTime", "getAqiDataRefreshTime", "()Ljava/util/Map;", "setAqiDataRefreshTime", "(Ljava/util/Map;)V", "aqiDataRefreshTime$delegate", "Lcom/blueair/core/util/PersistentObjectDelegate;", "databaseTrackedLocations", "", "Lcom/blueair/core/model/TrackedLocation;", "getDatabaseTrackedLocations", "()Ljava/util/List;", "databaseLiveTrackedLocations", "Landroidx/lifecycle/LiveData;", "getDatabaseLiveTrackedLocations", "()Landroidx/lifecycle/LiveData;", "databaseUserTrackedLocations", "getDatabaseUserTrackedLocations", "databaseLiveUserTrackedLocations", "getDatabaseLiveUserTrackedLocations", "databaseCurrentLocation", "getDatabaseCurrentLocation", "()Lcom/blueair/core/model/TrackedLocation;", "databaseLiveCurrentLocation", "getDatabaseLiveCurrentLocation", "databaseLiveAqiData", "Lcom/blueair/core/model/AqiData;", "getDatabaseLiveAqiData", "liveAqiData", "location", "liveTrackedLocation", "locationId", "getTrackedLocation", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setCurrentLocation", "", "lat", "", "lon", "(DDLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearCurrentLocation", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "downloadTrackedLocations", "Lio/flatcircle/coroutinehelper/ApiResult;", "", "insertTrackedLocation", "trackedLocation", "aqiData", "isUpdate", "(Lcom/blueair/core/model/TrackedLocation;Lcom/blueair/core/model/AqiData;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteTrackedLocation", "(Lcom/blueair/core/model/TrackedLocation;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchTrackedLocationWithAqiData", "Lkotlin/Pair;", "lng", "mapType", "(DDLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "filterAllowRefreshLocations", "locations", "fetchAqiData", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "forceFetch", "(Lcom/blueair/core/model/TrackedLocation;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAqiData", "deleteAllOutdoorDataInBackground", "logOut", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "outdoor_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class OutdoorService implements CoroutineScope, LogOutable {
   static final KProperty[] $$delegatedProperties = new KProperty[]{Reflection.mutableProperty1((MutablePropertyReference1)(new MutablePropertyReference1Impl(OutdoorService.class, "aqiDataRefreshTime", "getAqiDataRefreshTime()Ljava/util/Map;", 0)))};
   private final DefaultCoroutineScope $$delegate_0;
   private final PersistentObjectDelegate aqiDataRefreshTime$delegate;
   private final AuthService authService;
   private final Context context;
   private final LiveData databaseLiveAqiData;
   private final LiveData databaseLiveCurrentLocation;
   private final LiveData databaseLiveTrackedLocations;
   private final LiveData databaseLiveUserTrackedLocations;
   private final GeocodeService geocodeService;
   private final OutdoorClient outdoorClient;
   private final TrackedLocationRepository trackedLocationRepository;

   public OutdoorService(Context var1, TrackedLocationRepository var2, OutdoorClient var3, GeocodeService var4, AuthService var5) {
      Intrinsics.checkNotNullParameter(var1, "context");
      Intrinsics.checkNotNullParameter(var2, "trackedLocationRepository");
      Intrinsics.checkNotNullParameter(var3, "outdoorClient");
      Intrinsics.checkNotNullParameter(var4, "geocodeService");
      Intrinsics.checkNotNullParameter(var5, "authService");
      super();
      this.$$delegate_0 = new DefaultCoroutineScope();
      this.context = var1;
      this.trackedLocationRepository = var2;
      this.outdoorClient = var3;
      this.geocodeService = var4;
      this.authService = var5;
      this.aqiDataRefreshTime$delegate = new PersistentObjectDelegate(var1, "aqi_data_refresh_time_map", MapsKt.emptyMap(), (Type)Map.class, new Type[]{String.class, Long.class});
      this.databaseLiveTrackedLocations = var2.getLiveTrackedLocations();
      this.databaseLiveUserTrackedLocations = var2.getLiveUserTrackedLocations();
      this.databaseLiveCurrentLocation = var2.getLiveCurrentLocation();
      this.databaseLiveAqiData = var2.getLiveAqiData();
   }

   private final void deleteAllOutdoorDataInBackground() {
      BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(this, (Continuation)null) {
         int label;
         final OutdoorService this$0;

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
               if (var2 != 1) {
                  throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
               }

               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               var1 = this.this$0.trackedLocationRepository;
               Continuation var4 = (Continuation)this;
               this.label = 1;
               if (var1.deleteAllOutdoorData(var4) == var3) {
                  return var3;
               }
            }

            this.this$0.setAqiDataRefreshTime(MapsKt.emptyMap());
            return Unit.INSTANCE;
         }
      }, 2, (Object)null);
   }

   // $FF: synthetic method
   public static Object fetchAqiData$default(OutdoorService var0, TrackedLocation var1, boolean var2, Continuation var3, int var4, Object var5) {
      if ((var4 & 2) != 0) {
         var2 = false;
      }

      return var0.fetchAqiData(var1, var2, var3);
   }

   private final List filterAllowRefreshLocations(List var1) {
      Timber.Forest var6 = Timber.Forest;
      StringBuilder var10 = new StringBuilder("filterAllowRefreshLocations: ");
      Iterable var7 = (Iterable)var1;
      Collection var8 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var7, 10)));
      Iterator var9 = var7.iterator();

      while(var9.hasNext()) {
         var8.add(((TrackedLocation)var9.next()).getLocationName());
      }

      var10.append((List)var8);
      var6.d(var10.toString(), new Object[0]);
      long var4 = System.currentTimeMillis();
      List var16 = this.trackedLocationRepository.getAqiData();
      if (!((Collection)var16).isEmpty()) {
         Collection var12 = (Collection)(new ArrayList());

         label86:
         for(Object var22 : var7) {
            TrackedLocation var27 = (TrackedLocation)var22;
            Iterable var38 = (Iterable)var16;
            if (!(var38 instanceof Collection) || !((Collection)var38).isEmpty()) {
               for(AqiData var11 : var38) {
                  if (Intrinsics.areEqual(var11.getLocationId(), var27.getId()) && var4 - var11.getDatetime() <= 3600000L) {
                     continue label86;
                  }
               }
            }

            var12.add(var22);
         }

         var16 = (List)var12;
         Timber.Forest var28 = Timber.Forest;
         StringBuilder var23 = new StringBuilder("filterAllowRefreshLocations: after filter aqi data time: ");
         Iterable var34 = (Iterable)var16;
         var12 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var34, 10)));
         Iterator var35 = var34.iterator();

         while(var35.hasNext()) {
            var12.add(((TrackedLocation)var35.next()).getLocationName());
         }

         var23.append((List)var12);
         var28.d(var23.toString(), new Object[0]);
         var1 = var16;
         if (var16.isEmpty()) {
            return CollectionsKt.emptyList();
         }
      }

      Iterable var18 = (Iterable)var1;
      Collection var14 = (Collection)(new ArrayList());

      for(Object var24 : var18) {
         TrackedLocation var29 = (TrackedLocation)var24;
         Long var30 = (Long)this.getAqiDataRefreshTime().get(var29.getId());
         long var2;
         if (var30 != null) {
            var2 = var30;
         } else {
            var2 = 0L;
         }

         if (var4 - var2 > 300000L) {
            var14.add(var24);
         }
      }

      List var15 = (List)var14;
      Timber.Forest var31 = Timber.Forest;
      var10 = new StringBuilder("filterAllowRefreshLocations: after filter last refresh time: ");
      var18 = (Iterable)var15;
      Collection var36 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var18, 10)));
      Iterator var25 = var18.iterator();

      while(var25.hasNext()) {
         var36.add(((TrackedLocation)var25.next()).getLocationName());
      }

      var10.append((List)var36);
      var31.d(var10.toString(), new Object[0]);
      if (var15.isEmpty()) {
         return CollectionsKt.emptyList();
      } else {
         Map var26 = this.getAqiDataRefreshTime();
         Map var32 = (Map)(new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(var18, 10)), 16)));
         Iterator var21 = var18.iterator();

         while(var21.hasNext()) {
            Pair var37 = TuplesKt.to(((TrackedLocation)var21.next()).getId(), var4);
            var32.put(var37.getFirst(), var37.getSecond());
         }

         this.setAqiDataRefreshTime(MapsKt.plus(var26, var32));
         return var15;
      }
   }

   private final Map getAqiDataRefreshTime() {
      return (Map)this.aqiDataRefreshTime$delegate.getValue(this, $$delegatedProperties[0]);
   }

   private final void setAqiDataRefreshTime(Map var1) {
      this.aqiDataRefreshTime$delegate.setValue(this, $$delegatedProperties[0], var1);
   }

   public final Object clearCurrentLocation(Continuation var1) {
      TrackedLocation var2 = this.trackedLocationRepository.getCurrentLocation();
      if (var2 != null) {
         Object var3 = this.trackedLocationRepository.deleteTrackedLocation(var2, var1);
         if (var3 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return var3;
         }
      }

      return Unit.INSTANCE;
   }

   public final Object deleteTrackedLocation(TrackedLocation var1, Continuation var2) {
      label35: {
         if (var2 instanceof <undefinedtype>) {
            <undefinedtype> var4 = (<undefinedtype>)var2;
            if ((var4.label & Integer.MIN_VALUE) != 0) {
               var4.label += Integer.MIN_VALUE;
               var9 = var4;
               break label35;
            }
         }

         var9 = new ContinuationImpl(this, var2) {
            Object L$0;
            int label;
            Object result;
            final OutdoorService this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.deleteTrackedLocation((TrackedLocation)null, (Continuation)this);
            }
         };
      }

      OutdoorClient var10 = (OutdoorClient)((<undefinedtype>)var9).result;
      Object var6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var3 = ((<undefinedtype>)var9).label;
      if (var3 != 0) {
         if (var3 != 1) {
            if (var3 != 2) {
               throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            var1 = (TrackedLocation)((<undefinedtype>)var9).L$0;
            ResultKt.throwOnFailure(var10);
            return Boxing.boxBoolean(((ApiResult)var10).isSuccess());
         }

         var1 = (TrackedLocation)((<undefinedtype>)var9).L$0;
         ResultKt.throwOnFailure(var10);
      } else {
         ResultKt.throwOnFailure(var10);
         var10 = this.outdoorClient;
         ((<undefinedtype>)var9).L$0 = var1;
         ((<undefinedtype>)var9).label = 1;
         Object var5 = var10.removeTrackedLocation((TrackedLocation)var1, (Continuation)var9);
         var10 = (OutdoorClient)var5;
         if (var5 == var6) {
            return var6;
         }
      }

      ApiResult var13 = (ApiResult)var10;
      Function2 var12 = new Function2(this, var1, (Continuation)null) {
         final TrackedLocation $trackedLocation;
         int label;
         final OutdoorService this$0;

         {
            this.this$0 = var1;
            this.$trackedLocation = var2;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.this$0, this.$trackedLocation, var2));
         }

         public final Object invoke(ResponseBody var1, Continuation var2) {
            return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
         }

         public final Object invokeSuspend(Object var1) {
            Object var3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int var2 = this.label;
            if (var2 != 0) {
               if (var2 != 1) {
                  throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
               }

               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               var1 = this.this$0.trackedLocationRepository;
               TrackedLocation var4 = this.$trackedLocation;
               Continuation var5 = (Continuation)this;
               this.label = 1;
               if (var1.deleteTrackedLocation(var4, var5) == var3) {
                  return var3;
               }
            }

            return Unit.INSTANCE;
         }
      };
      ((<undefinedtype>)var9).L$0 = SpillingKt.nullOutSpilledVariable(var1);
      ((<undefinedtype>)var9).label = 2;
      Object var8 = ApiResultKt.onSuccess(var13, var12, (Continuation)var9);
      var10 = (OutdoorClient)var8;
      if (var8 == var6) {
         return var6;
      } else {
         return Boxing.boxBoolean(((ApiResult)var10).isSuccess());
      }
   }

   public final Object downloadTrackedLocations(Continuation var1) {
      label39: {
         if (var1 instanceof <undefinedtype>) {
            <undefinedtype> var3 = (<undefinedtype>)var1;
            if ((var3.label & Integer.MIN_VALUE) != 0) {
               var3.label += Integer.MIN_VALUE;
               var6 = var3;
               break label39;
            }
         }

         var6 = new ContinuationImpl(this, var1) {
            int label;
            Object result;
            final OutdoorService this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.downloadTrackedLocations((Continuation)this);
            }
         };
      }

      label33: {
         OutdoorClient var9 = (OutdoorClient)((<undefinedtype>)var6).result;
         Object var5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
         int var2 = ((<undefinedtype>)var6).label;
         if (var2 != 0) {
            if (var2 != 1) {
               if (var2 != 2) {
                  throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
               }

               ResultKt.throwOnFailure(var9);
               var7 = var9;
               break label33;
            }

            ResultKt.throwOnFailure(var9);
         } else {
            ResultKt.throwOnFailure(var9);
            if (!(Boolean)this.authService.isUserLoggedIn().getValue()) {
               return ApiResult.Companion.success(Boxing.boxBoolean(true));
            }

            BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(this, (Continuation)null) {
               int label;
               final OutdoorService this$0;

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
                  IntrinsicsKt.getCOROUTINE_SUSPENDED();
                  if (this.label == 0) {
                     ResultKt.throwOnFailure(var1);
                     TrackedLocation var2 = this.this$0.getDatabaseCurrentLocation();
                     if (var2 != null) {
                        var1 = this.this$0;
                        KlaviyoSdk.INSTANCE.setProfileLocation(new KlaviyoProfileLocationData(var1.authService.getUsername(), var2.getCountryCode(), var2.getStateName(), var2.getCityName()));
                     }

                     return Unit.INSTANCE;
                  } else {
                     throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                  }
               }
            }, 2, (Object)null);
            var9 = this.outdoorClient;
            ((<undefinedtype>)var6).label = 1;
            Object var4 = var9.getTrackedLocations((Continuation)var6);
            var9 = (OutdoorClient)var4;
            if (var4 == var5) {
               return var5;
            }
         }

         ApiResult var13 = (ApiResult)var9;
         Function2 var11 = new Function2(this, (Continuation)null) {
            int I$0;
            int I$1;
            int I$2;
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            Object L$4;
            Object L$5;
            Object L$6;
            Object L$7;
            Object L$8;
            int label;
            final OutdoorService this$0;

            {
               this.this$0 = var1;
            }

            public final Continuation create(Object var1, Continuation var2) {
               Function2 var3 = new <anonymous constructor>(this.this$0, var2);
               var3.L$0 = var1;
               return (Continuation)var3;
            }

            public final Object invoke(List var1, Continuation var2) {
               return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object var1) {
               Object var17;
               List var18;
               label172: {
                  var18 = (List)this.L$0;
                  var17 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                  int var2 = this.label;
                  Iterator var19;
                  OutdoorService var30;
                  Iterable var43;
                  List var52;
                  List var58;
                  if (var2 != 0) {
                     if (var2 != 1) {
                        if (var2 != 2) {
                           if (var2 != 3) {
                              if (var2 != 4) {
                                 if (var2 != 5) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                 }

                                 List var31 = (List)this.L$2;
                                 var31 = (List)this.L$1;
                                 ResultKt.throwOnFailure(var1);
                                 return Unit.INSTANCE;
                              }

                              var2 = this.I$0;
                              TrackedLocation var6 = (TrackedLocation)this.L$8;
                              var6 = (TrackedLocation)this.L$7;
                              Iterator var10 = (Iterator)this.L$5;
                              var30 = (OutdoorService)this.L$4;
                              Iterable var9 = (Iterable)this.L$3;
                              List var7 = (List)this.L$2;
                              var52 = (List)this.L$1;
                              ResultKt.throwOnFailure(var1);
                              var19 = var10;
                              List var11 = var7;
                              List var62 = var52;
                              var43 = var9;
                              var52 = var11;
                              var58 = var62;
                           } else {
                              int var3 = this.I$2;
                              int var5 = this.I$1;
                              var2 = this.I$0;
                              TrackedLocation var70 = (TrackedLocation)this.L$8;
                              TrackedLocation var12 = (TrackedLocation)this.L$7;
                              Object var63 = this.L$6;
                              Iterator var44 = (Iterator)this.L$5;
                              var30 = (OutdoorService)this.L$4;
                              Iterable var59 = (Iterable)this.L$3;
                              List var13 = (List)this.L$2;
                              var52 = (List)this.L$1;
                              ResultKt.throwOnFailure(var1);
                              Object var14 = var1;
                              var19 = var44;
                              List var45 = var13;
                              ApiResult var80 = (ApiResult)var14;
                              Function2 var86 = new Function2(var30, var70, (Continuation)null) {
                                 final TrackedLocation $infoLoc;
                                 int label;
                                 final OutdoorService this$0;

                                 {
                                    this.this$0 = var1;
                                    this.$infoLoc = var2;
                                 }

                                 public final Continuation create(Object var1, Continuation var2) {
                                    return (Continuation)(new <anonymous constructor>(this.this$0, this.$infoLoc, var2));
                                 }

                                 public final Object invoke(TrackedLocation var1, Continuation var2) {
                                    return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
                                 }

                                 public final Object invokeSuspend(Object var1) {
                                    Object var3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    int var2 = this.label;
                                    if (var2 != 0) {
                                       if (var2 != 1) {
                                          throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                       }

                                       ResultKt.throwOnFailure(var1);
                                    } else {
                                       ResultKt.throwOnFailure(var1);
                                       var1 = this.this$0.trackedLocationRepository;
                                       TrackedLocation var5 = this.$infoLoc;
                                       Continuation var4 = (Continuation)this;
                                       this.label = 1;
                                       if (var1.insertTrackedLocation(var5, var4) == var3) {
                                          return var3;
                                       }
                                    }

                                    return Unit.INSTANCE;
                                 }
                              };
                              this.L$0 = var18;
                              this.L$1 = var52;
                              this.L$2 = var45;
                              this.L$3 = SpillingKt.nullOutSpilledVariable(var59);
                              this.L$4 = var30;
                              this.L$5 = var19;
                              this.L$6 = SpillingKt.nullOutSpilledVariable(var63);
                              this.L$7 = SpillingKt.nullOutSpilledVariable(var12);
                              this.L$8 = SpillingKt.nullOutSpilledVariable(var70);
                              this.I$0 = var2;
                              this.I$1 = var5;
                              this.I$2 = var3;
                              this.label = 4;
                              if (ApiResultKt.onSuccess(var80, var86, this) == var17) {
                                 return var17;
                              }

                              List var71 = var45;
                              List var64 = var52;
                              var43 = var59;
                              var52 = var71;
                              var58 = var64;
                           }
                        } else {
                           int var26 = this.I$1;
                           var2 = this.I$0;
                           TrackedLocation var65 = (TrackedLocation)this.L$7;
                           Object var72 = this.L$6;
                           Iterator var81 = (Iterator)this.L$5;
                           var30 = (OutdoorService)this.L$4;
                           var43 = (Iterable)this.L$3;
                           var52 = (List)this.L$2;
                           var58 = (List)this.L$1;
                           ResultKt.throwOnFailure(var1);
                           Object var75 = var1;
                           var19 = var81;
                           TrackedLocation var76 = (TrackedLocation)var75;
                           if (var76 != null) {
                              var52.add(var76);
                              OutdoorClient var82 = var30.outdoorClient;
                              this.L$0 = var18;
                              this.L$1 = var58;
                              this.L$2 = var52;
                              this.L$3 = SpillingKt.nullOutSpilledVariable(var43);
                              this.L$4 = var30;
                              this.L$5 = var19;
                              this.L$6 = SpillingKt.nullOutSpilledVariable(var72);
                              this.L$7 = SpillingKt.nullOutSpilledVariable(var65);
                              this.L$8 = var76;
                              this.I$0 = var2;
                              this.I$1 = var26;
                              this.I$2 = 0;
                              this.label = 3;
                              Object var16 = var82.addTrackedLocation(var76, this);
                              if (var16 == var17) {
                                 return var17;
                              }

                              byte var4 = 0;
                              ApiResult var83 = (ApiResult)var16;
                              Function2 var87 = new Function2(var30, var76, (Continuation)null) {
                                 final TrackedLocation $infoLoc;
                                 int label;
                                 final OutdoorService this$0;

                                 {
                                    this.this$0 = var1;
                                    this.$infoLoc = var2;
                                 }

                                 public final Continuation create(Object var1, Continuation var2) {
                                    return (Continuation)(new <anonymous constructor>(this.this$0, this.$infoLoc, var2));
                                 }

                                 public final Object invoke(TrackedLocation var1, Continuation var2) {
                                    return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
                                 }

                                 public final Object invokeSuspend(Object var1) {
                                    Object var3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    int var2 = this.label;
                                    if (var2 != 0) {
                                       if (var2 != 1) {
                                          throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                       }

                                       ResultKt.throwOnFailure(var1);
                                    } else {
                                       ResultKt.throwOnFailure(var1);
                                       var1 = this.this$0.trackedLocationRepository;
                                       TrackedLocation var5 = this.$infoLoc;
                                       Continuation var4 = (Continuation)this;
                                       this.label = 1;
                                       if (var1.insertTrackedLocation(var5, var4) == var3) {
                                          return var3;
                                       }
                                    }

                                    return Unit.INSTANCE;
                                 }
                              };
                              this.L$0 = var18;
                              this.L$1 = var58;
                              this.L$2 = var52;
                              this.L$3 = SpillingKt.nullOutSpilledVariable(var43);
                              this.L$4 = var30;
                              this.L$5 = var19;
                              this.L$6 = SpillingKt.nullOutSpilledVariable(var72);
                              this.L$7 = SpillingKt.nullOutSpilledVariable(var65);
                              this.L$8 = SpillingKt.nullOutSpilledVariable(var76);
                              this.I$0 = var2;
                              this.I$1 = var26;
                              this.I$2 = var4;
                              this.label = 4;
                              if (ApiResultKt.onSuccess(var83, var87, this) == var17) {
                                 return var17;
                              }

                              var43 = var43;
                              var52 = var52;
                              var58 = var58;
                           }
                        }
                     } else {
                        ResultKt.throwOnFailure(var1);
                        Iterable var33 = (Iterable)var18;
                        Collection var20 = (Collection)(new ArrayList());

                        for(Object var46 : var33) {
                           TrackedLocation var54 = (TrackedLocation)var46;
                           if (var54.getLocationName() == null && var54.getCityName() == null && var54.getCountryName() == null) {
                              var20.add(var46);
                           }
                        }

                        List var35 = (List)var20;
                        var21 = var35;
                        if (((Collection)var35).isEmpty()) {
                           break label172;
                        }

                        var52 = (List)(new ArrayList());
                        var43 = (Iterable)var35;
                        OutdoorService var66 = this.this$0;
                        var19 = var43.iterator();
                        var58 = var35;
                        var30 = var66;
                        var2 = 0;
                     }
                  } else {
                     ResultKt.throwOnFailure(var1);
                     TrackedLocationRepository var36 = this.this$0.trackedLocationRepository;
                     Continuation var22 = (Continuation)this;
                     this.L$0 = var18;
                     this.label = 1;
                     if (var36.setTrackedLocations(var18, var22) == var17) {
                        return var17;
                     }

                     Iterable var37 = (Iterable)var18;
                     Collection var23 = (Collection)(new ArrayList());

                     for(Object var47 : var37) {
                        TrackedLocation var55 = (TrackedLocation)var47;
                        if (var55.getLocationName() == null && var55.getCityName() == null && var55.getCountryName() == null) {
                           var23.add(var47);
                        }
                     }

                     List var39 = (List)var23;
                     var21 = var39;
                     if (((Collection)var39).isEmpty()) {
                        break label172;
                     }

                     var52 = (List)(new ArrayList());
                     var43 = (Iterable)var39;
                     OutdoorService var67 = this.this$0;
                     var19 = var43.iterator();
                     var58 = var39;
                     var30 = var67;
                     var2 = 0;
                  }

                  while(var19.hasNext()) {
                     Object var73 = var19.next();
                     TrackedLocation var68 = (TrackedLocation)var73;
                     GeocodeService var77 = var30.geocodeService;
                     this.L$0 = var18;
                     this.L$1 = var58;
                     this.L$2 = var52;
                     this.L$3 = SpillingKt.nullOutSpilledVariable(var43);
                     this.L$4 = var30;
                     this.L$5 = var19;
                     this.L$6 = SpillingKt.nullOutSpilledVariable(var73);
                     this.L$7 = SpillingKt.nullOutSpilledVariable(var68);
                     this.L$8 = null;
                     this.I$0 = var2;
                     this.I$1 = 0;
                     this.label = 2;
                     Object var78 = var77.getTrackedLocation(var68, this);
                     if (var78 == var17) {
                        return var17;
                     }

                     byte var27 = 0;
                     TrackedLocation var79 = (TrackedLocation)var78;
                     if (var79 != null) {
                        var52.add(var79);
                        OutdoorClient var84 = var30.outdoorClient;
                        this.L$0 = var18;
                        this.L$1 = var58;
                        this.L$2 = var52;
                        this.L$3 = SpillingKt.nullOutSpilledVariable(var43);
                        this.L$4 = var30;
                        this.L$5 = var19;
                        this.L$6 = SpillingKt.nullOutSpilledVariable(var73);
                        this.L$7 = SpillingKt.nullOutSpilledVariable(var68);
                        this.L$8 = var79;
                        this.I$0 = var2;
                        this.I$1 = var27;
                        this.I$2 = 0;
                        this.label = 3;
                        Object var89 = var84.addTrackedLocation(var79, this);
                        if (var89 == var17) {
                           return var17;
                        }

                        byte var28 = 0;
                        ApiResult var85 = (ApiResult)var89;
                        Function2 var88 = new Function2(var30, var79, (Continuation)null) {
                           final TrackedLocation $infoLoc;
                           int label;
                           final OutdoorService this$0;

                           {
                              this.this$0 = var1;
                              this.$infoLoc = var2;
                           }

                           public final Continuation create(Object var1, Continuation var2) {
                              return (Continuation)(new <anonymous constructor>(this.this$0, this.$infoLoc, var2));
                           }

                           public final Object invoke(TrackedLocation var1, Continuation var2) {
                              return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
                           }

                           public final Object invokeSuspend(Object var1) {
                              Object var3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                              int var2 = this.label;
                              if (var2 != 0) {
                                 if (var2 != 1) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                 }

                                 ResultKt.throwOnFailure(var1);
                              } else {
                                 ResultKt.throwOnFailure(var1);
                                 var1 = this.this$0.trackedLocationRepository;
                                 TrackedLocation var5 = this.$infoLoc;
                                 Continuation var4 = (Continuation)this;
                                 this.label = 1;
                                 if (var1.insertTrackedLocation(var5, var4) == var3) {
                                    return var3;
                                 }
                              }

                              return Unit.INSTANCE;
                           }
                        };
                        this.L$0 = var18;
                        this.L$1 = var58;
                        this.L$2 = var52;
                        this.L$3 = SpillingKt.nullOutSpilledVariable(var43);
                        this.L$4 = var30;
                        this.L$5 = var19;
                        this.L$6 = SpillingKt.nullOutSpilledVariable(var73);
                        this.L$7 = SpillingKt.nullOutSpilledVariable(var68);
                        this.L$8 = SpillingKt.nullOutSpilledVariable(var79);
                        this.I$0 = var2;
                        this.I$1 = var27;
                        this.I$2 = var28;
                        this.label = 4;
                        if (ApiResultKt.onSuccess(var85, var88, this) == var17) {
                           return var17;
                        }

                        var43 = var43;
                        var52 = var52;
                        var58 = var58;
                     }
                  }

                  Timber.Forest var40 = Timber.Forest;
                  StringBuilder var24 = new StringBuilder("Do location info completion: \nbefore: ");
                  var24.append(var58);
                  var24.append("\nafter: ");
                  var24.append(var52);
                  var40.d(var24.toString(), new Object[0]);
                  var21 = var58;
               }

               Iterable var48 = (Iterable)var18;
               Collection var41 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var48, 10)));
               Iterator var49 = var48.iterator();

               while(var49.hasNext()) {
                  var41.add(((TrackedLocation)var49.next()).getId());
               }

               List var42 = (List)var41;
               OutdoorService var56 = this.this$0;
               Map var60 = var56.getAqiDataRefreshTime();
               LinkedHashMap var50 = new LinkedHashMap();

               for(Map.Entry var69 : var60.entrySet()) {
                  String var74 = (String)var69.getKey();
                  if (var42.contains(var74) || Intrinsics.areEqual(var74, "current")) {
                     var50.put(var69.getKey(), var69.getValue());
                  }
               }

               var56.setAqiDataRefreshTime((Map)var50);
               var56 = this.this$0;
               Continuation var51 = (Continuation)this;
               this.L$0 = SpillingKt.nullOutSpilledVariable(var18);
               this.L$1 = SpillingKt.nullOutSpilledVariable(var21);
               this.L$2 = SpillingKt.nullOutSpilledVariable(var42);
               this.L$3 = null;
               this.L$4 = null;
               this.L$5 = null;
               this.L$6 = null;
               this.L$7 = null;
               this.L$8 = null;
               this.label = 5;
               if (var56.fetchAqiData(var18, var51) == var17) {
                  return var17;
               } else {
                  return Unit.INSTANCE;
               }
            }
         };
         ((<undefinedtype>)var6).label = 2;
         Object var12 = ApiResultKt.onSuccess(var13, var11, (Continuation)var6);
         var7 = var12;
         if (var12 == var5) {
            return var5;
         }
      }

      ApiResult var8 = (ApiResult)var7;
      return ApiResult.Companion.fromResult(var8, Boxing.boxBoolean(var8.isSuccess()));
   }

   public final Object fetchAqiData(TrackedLocation var1, boolean var2, Continuation var3) {
      TrackedLocation var9;
      label62: {
         var9 = var1;
         if (var3 instanceof <undefinedtype>) {
            var12 = (<undefinedtype>)var3;
            if ((((<undefinedtype>)var12).label & Integer.MIN_VALUE) != 0) {
               ((<undefinedtype>)var12).label += Integer.MIN_VALUE;
               break label62;
            }
         }

         var12 = new ContinuationImpl(this, var3) {
            Object L$0;
            Object L$1;
            boolean Z$0;
            int label;
            Object result;
            final OutdoorService this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.fetchAqiData((TrackedLocation)null, false, (Continuation)this);
            }
         };
      }

      Object var18 = ((<undefinedtype>)var12).result;
      Object var11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var8 = ((<undefinedtype>)var12).label;
      if (var8 != 0) {
         if (var8 != 1) {
            if (var8 == 2) {
               var2 = ((<undefinedtype>)var12).Z$0;
               AqiData var24 = (AqiData)((<undefinedtype>)var12).L$1;
               var1 = (TrackedLocation)((<undefinedtype>)var12).L$0;
               ResultKt.throwOnFailure(var18);
               return var24;
            }

            if (var8 != 3) {
               throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            var2 = ((<undefinedtype>)var12).Z$0;
            var1 = (TrackedLocation)((<undefinedtype>)var12).L$0;
            ResultKt.throwOnFailure(var18);
            return (AqiData)CollectionsKt.firstOrNull((List)var18);
         }

         var2 = ((<undefinedtype>)var12).Z$0;
         var9 = (TrackedLocation)((<undefinedtype>)var12).L$0;
         ResultKt.throwOnFailure(var18);
      } else {
         ResultKt.throwOnFailure(var18);
         Timber.Forest var10 = Timber.Forest;
         StringBuilder var19 = new StringBuilder("fetchAqiData(");
         var19.append(var9);
         var19.append(", ");
         var19.append(var2);
         var19.append(')');
         var10.d(var19.toString(), new Object[0]);
         if (!var9.isCurrentLocation()) {
            List var23 = CollectionsKt.listOf(var9);
            ((<undefinedtype>)var12).L$0 = SpillingKt.nullOutSpilledVariable(var9);
            ((<undefinedtype>)var12).Z$0 = var2;
            ((<undefinedtype>)var12).label = 3;
            Object var15 = this.fetchAqiData(var23, (Continuation)var12);
            var18 = var15;
            if (var15 == var11) {
               return var11;
            }

            return (AqiData)CollectionsKt.firstOrNull((List)var18);
         }

         if (!var2 && ((Collection)this.filterAllowRefreshLocations(CollectionsKt.listOf(var9))).isEmpty()) {
            return null;
         }

         OutdoorClient var20 = this.outdoorClient;
         double var6 = var9.getLat();
         double var4 = var9.getLon();
         ((<undefinedtype>)var12).L$0 = var9;
         ((<undefinedtype>)var12).Z$0 = var2;
         ((<undefinedtype>)var12).label = 1;
         Object var25 = var20.getAqiDataByLatLng(var6, var4, (Continuation)var12);
         var18 = var25;
         if (var25 == var11) {
            return var11;
         }
      }

      AqiData var21 = (AqiData)((ApiResult)var18).getOrNull();
      if (var21 == null) {
         return null;
      } else {
         var21 = AqiData.copy$default(var21, var9.getId(), 0L, (OutdoorPollutants)null, 6, (Object)null);
         if (var21 == null) {
            return null;
         } else {
            TrackedLocationRepository var26 = this.trackedLocationRepository;
            ((<undefinedtype>)var12).L$0 = SpillingKt.nullOutSpilledVariable(var9);
            ((<undefinedtype>)var12).L$1 = var21;
            ((<undefinedtype>)var12).Z$0 = var2;
            ((<undefinedtype>)var12).label = 2;
            if (var26.insertAqiData((AqiData)var21, (Continuation)var12) != var11) {
               return var21;
            } else {
               return var11;
            }
         }
      }
   }

   public final Object fetchAqiData(List var1, Continuation var2) {
      label43: {
         if (var2 instanceof <undefinedtype>) {
            <undefinedtype> var4 = (<undefinedtype>)var2;
            if ((var4.label & Integer.MIN_VALUE) != 0) {
               var4.label += Integer.MIN_VALUE;
               var12 = var4;
               break label43;
            }
         }

         var12 = new ContinuationImpl(this, var2) {
            Object L$0;
            Object L$1;
            int label;
            Object result;
            final OutdoorService this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.fetchAqiData((List)null, (Continuation)this);
            }
         };
      }

      Object var14;
      label37: {
         var14 = ((<undefinedtype>)var12).result;
         Object var7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
         int var3 = ((<undefinedtype>)var12).label;
         List var5;
         if (var3 != 0) {
            if (var3 != 1) {
               if (var3 != 2) {
                  throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
               }

               var1 = (List)((<undefinedtype>)var12).L$1;
               var1 = (List)((<undefinedtype>)var12).L$0;
               ResultKt.throwOnFailure(var14);
               break label37;
            }

            var5 = (List)((<undefinedtype>)var12).L$1;
            var1 = (List)((<undefinedtype>)var12).L$0;
            ResultKt.throwOnFailure(var14);
         } else {
            ResultKt.throwOnFailure(var14);
            Collection var15 = (Collection)this.filterAllowRefreshLocations(var1);
            if (var15.isEmpty()) {
               return CollectionsKt.emptyList();
            }

            var5 = (List)var15;
            OutdoorClient var16 = this.outdoorClient;
            ((<undefinedtype>)var12).L$0 = SpillingKt.nullOutSpilledVariable(var1);
            ((<undefinedtype>)var12).L$1 = SpillingKt.nullOutSpilledVariable(var5);
            ((<undefinedtype>)var12).label = 1;
            Object var6 = var16.getAqiDataByLocation(var5, (Continuation)var12);
            var14 = var6;
            if (var6 == var7) {
               return var7;
            }
         }

         ApiResult var17 = (ApiResult)var14;
         Function2 var18 = new Function2(this, (Continuation)null) {
            Object L$0;
            int label;
            final OutdoorService this$0;

            {
               this.this$0 = var1;
            }

            public final Continuation create(Object var1, Continuation var2) {
               Function2 var3 = new <anonymous constructor>(this.this$0, var2);
               var3.L$0 = var1;
               return (Continuation)var3;
            }

            public final Object invoke(List var1, Continuation var2) {
               return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object var1) {
               List var3 = (List)this.L$0;
               Object var4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
               int var2 = this.label;
               if (var2 != 0) {
                  if (var2 != 1) {
                     throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                  }

                  ResultKt.throwOnFailure(var1);
               } else {
                  ResultKt.throwOnFailure(var1);
                  TrackedLocationRepository var5 = this.this$0.trackedLocationRepository;
                  Continuation var6 = (Continuation)this;
                  this.L$0 = SpillingKt.nullOutSpilledVariable(var3);
                  this.label = 1;
                  if (var5.insertAqiData(var3, var6) == var4) {
                     return var4;
                  }
               }

               return Unit.INSTANCE;
            }
         };
         ((<undefinedtype>)var12).L$0 = SpillingKt.nullOutSpilledVariable(var1);
         ((<undefinedtype>)var12).L$1 = SpillingKt.nullOutSpilledVariable(var5);
         ((<undefinedtype>)var12).label = 2;
         Object var10 = ApiResultKt.onSuccess(var17, var18, (Continuation)var12);
         var14 = var10;
         if (var10 == var7) {
            return var7;
         }
      }

      List var13 = (List)((ApiResult)var14).getOrNull();
      var1 = var13;
      if (var13 == null) {
         var1 = CollectionsKt.emptyList();
      }

      return var1;
   }

   public final Object fetchTrackedLocationWithAqiData(double var1, double var3, String var5, Continuation var6) {
      label54: {
         if (var6 instanceof <undefinedtype>) {
            <undefinedtype> var12 = (<undefinedtype>)var6;
            if ((var12.label & Integer.MIN_VALUE) != 0) {
               var12.label += Integer.MIN_VALUE;
               var23 = var12;
               break label54;
            }
         }

         var23 = new ContinuationImpl(this, var6) {
            double D$0;
            double D$1;
            Object L$0;
            Object L$1;
            int label;
            Object result;
            final OutdoorService this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.fetchTrackedLocationWithAqiData((double)0.0F, (double)0.0F, (String)null, (Continuation)this);
            }
         };
      }

      Object var27;
      label58: {
         var27 = ((<undefinedtype>)var23).result;
         Object var14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
         int var11 = ((<undefinedtype>)var23).label;
         Object var21;
         String var28;
         if (var11 != 0) {
            if (var11 != 1) {
               if (var11 != 2) {
                  throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
               }

               var1 = ((<undefinedtype>)var23).D$1;
               var1 = ((<undefinedtype>)var23).D$0;
               var22 = (TrackedLocation)((<undefinedtype>)var23).L$1;
               String var24 = (String)((<undefinedtype>)var23).L$0;
               ResultKt.throwOnFailure(var27);
               break label58;
            }

            var1 = ((<undefinedtype>)var23).D$1;
            var3 = ((<undefinedtype>)var23).D$0;
            TrackedLocation var20 = (TrackedLocation)((<undefinedtype>)var23).L$1;
            String var13 = (String)((<undefinedtype>)var23).L$0;
            ResultKt.throwOnFailure(var27);
            var21 = var27;
            var28 = var13;
         } else {
            ResultKt.throwOnFailure(var27);
            TrackedLocation var30 = new TrackedLocation("temp", var1, var3, (String)null, (String)null, (String)null, (String)null, (String)null, var5);
            GeocodeService var29 = this.geocodeService;
            ((<undefinedtype>)var23).L$0 = var5;
            ((<undefinedtype>)var23).L$1 = SpillingKt.nullOutSpilledVariable(var30);
            ((<undefinedtype>)var23).D$0 = var1;
            double var7 = var3;
            ((<undefinedtype>)var23).D$1 = var3;
            ((<undefinedtype>)var23).label = 1;
            var30 = (TrackedLocation)var29.getTrackedLocation(var30, (Continuation)var23);
            if (var30 == var14) {
               return var14;
            }

            var3 = var1;
            var1 = var7;
            var28 = var5;
            var21 = var30;
         }

         var22 = (TrackedLocation)var21;
         if (var22 == null) {
            return null;
         }

         if (var22.useGCJ()) {
            double[] var32 = CoordinateTransformUtils.INSTANCE.gcj02towgs84(var22.getLon(), var22.getLat(), var22.isInMainlandChina());
            var22 = TrackedLocation.copy$default(var22, (String)null, var32[1], var32[0], (String)null, (String)null, (String)null, (String)null, (String)null, "WGS", 249, (Object)null);
         } else if (var22.isLocalMapType()) {
            var22 = TrackedLocation.copy$default(var22, (String)null, (double)0.0F, (double)0.0F, (String)null, (String)null, (String)null, (String)null, (String)null, "WGS", 255, (Object)null);
         }

         Timber.Forest var15 = Timber.Forest;
         StringBuilder var33 = new StringBuilder("fetchTrackedLocationWithAqiData(");
         var33.append(var3);
         var33.append(", ");
         var33.append(var1);
         var33.append(", ");
         var33.append(var28);
         var33.append("): ");
         var33.append(var22);
         var15.d(var33.toString(), new Object[0]);
         OutdoorClient var34 = this.outdoorClient;
         double var9 = var22.getLat();
         double var26 = var22.getLon();
         ((<undefinedtype>)var23).L$0 = SpillingKt.nullOutSpilledVariable(var28);
         ((<undefinedtype>)var23).L$1 = var22;
         ((<undefinedtype>)var23).D$0 = var3;
         ((<undefinedtype>)var23).D$1 = var1;
         ((<undefinedtype>)var23).label = 2;
         var27 = var34.getAqiDataByLatLng(var9, var26, (Continuation)var23);
         if (var27 == var14) {
            return var14;
         }
      }

      AqiData var25 = (AqiData)((ApiResult)var27).getOrNull();
      if (var25 == null) {
         return null;
      } else {
         return new Pair(var22, var25);
      }
   }

   public final Object getAqiData(TrackedLocation var1, Continuation var2) {
      return this.trackedLocationRepository.getAqiData(var1.getId(), var2);
   }

   public CoroutineContext getCoroutineContext() {
      return this.$$delegate_0.getCoroutineContext();
   }

   public final TrackedLocation getDatabaseCurrentLocation() {
      return this.trackedLocationRepository.getCurrentLocation();
   }

   public final LiveData getDatabaseLiveAqiData() {
      return this.databaseLiveAqiData;
   }

   public final LiveData getDatabaseLiveCurrentLocation() {
      return this.databaseLiveCurrentLocation;
   }

   public final LiveData getDatabaseLiveTrackedLocations() {
      return this.databaseLiveTrackedLocations;
   }

   public final LiveData getDatabaseLiveUserTrackedLocations() {
      return this.databaseLiveUserTrackedLocations;
   }

   public final List getDatabaseTrackedLocations() {
      return this.trackedLocationRepository.getTrackedLocations();
   }

   public final List getDatabaseUserTrackedLocations() {
      return this.trackedLocationRepository.getTrackedLocations();
   }

   public final Object getTrackedLocation(String var1, Continuation var2) {
      return this.trackedLocationRepository.getTrackedLocation(var1, var2);
   }

   public final Object insertTrackedLocation(TrackedLocation var1, AqiData var2, boolean var3, Continuation var4) {
      Object var6;
      label39: {
         if (var4 instanceof <undefinedtype>) {
            var6 = (<undefinedtype>)var4;
            if ((((<undefinedtype>)var6).label & Integer.MIN_VALUE) != 0) {
               ((<undefinedtype>)var6).label += Integer.MIN_VALUE;
               break label39;
            }
         }

         var6 = new ContinuationImpl(this, var4) {
            Object L$0;
            Object L$1;
            Object L$2;
            boolean Z$0;
            int label;
            Object result;
            final OutdoorService this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.insertTrackedLocation((TrackedLocation)null, (AqiData)null, false, (Continuation)this);
            }
         };
      }

      OutdoorClient var7 = (OutdoorClient)((<undefinedtype>)var6).result;
      Object var9 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var5 = ((<undefinedtype>)var6).label;
      AqiData var10;
      TrackedLocation var15;
      TrackedLocation var17;
      if (var5 != 0) {
         if (var5 != 1) {
            if (var5 == 2) {
               var3 = ((<undefinedtype>)var6).Z$0;
               TrackedLocation var11 = (TrackedLocation)((<undefinedtype>)var6).L$2;
               AqiData var12 = (AqiData)((<undefinedtype>)var6).L$1;
               TrackedLocation var13 = (TrackedLocation)((<undefinedtype>)var6).L$0;
               ResultKt.throwOnFailure(var7);
               return var7;
            }

            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         var3 = ((<undefinedtype>)var6).Z$0;
         var17 = (TrackedLocation)((<undefinedtype>)var6).L$2;
         var10 = (AqiData)((<undefinedtype>)var6).L$1;
         var15 = (TrackedLocation)((<undefinedtype>)var6).L$0;
         ResultKt.throwOnFailure(var7);
      } else {
         ResultKt.throwOnFailure(var7);
         if (var3) {
            var17 = var1;
         } else {
            var17 = TrackedLocation.copy$default(var1, "", (double)0.0F, (double)0.0F, (String)null, (String)null, (String)null, (String)null, (String)null, (String)null, 510, (Object)null);
         }

         var7 = this.outdoorClient;
         ((<undefinedtype>)var6).L$0 = SpillingKt.nullOutSpilledVariable(var1);
         ((<undefinedtype>)var6).L$1 = var2;
         ((<undefinedtype>)var6).L$2 = SpillingKt.nullOutSpilledVariable(var17);
         ((<undefinedtype>)var6).Z$0 = var3;
         ((<undefinedtype>)var6).label = 1;
         Object var8 = var7.addTrackedLocation(var17, (Continuation)var6);
         if (var8 == var9) {
            return var9;
         }

         AqiData var19 = var2;
         var15 = var1;
         var10 = var19;
         var7 = (OutdoorClient)var8;
      }

      ApiResult var21 = (ApiResult)var7;
      Function2 var20 = new Function2(this, var10, (Continuation)null) {
         final AqiData $aqiData;
         Object L$0;
         int label;
         final OutdoorService this$0;

         {
            this.this$0 = var1;
            this.$aqiData = var2;
         }

         public final Continuation create(Object var1, Continuation var2) {
            Function2 var3 = new <anonymous constructor>(this.this$0, this.$aqiData, var2);
            var3.L$0 = var1;
            return (Continuation)var3;
         }

         public final Object invoke(TrackedLocation var1, Continuation var2) {
            return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
         }

         public final Object invokeSuspend(Object var1) {
            TrackedLocation var4 = (TrackedLocation)this.L$0;
            Object var3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int var2 = this.label;
            if (var2 != 0) {
               if (var2 != 1) {
                  if (var2 != 2) {
                     throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                  }

                  ResultKt.throwOnFailure(var1);
                  return Unit.INSTANCE;
               }

               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               TrackedLocationRepository var5 = this.this$0.trackedLocationRepository;
               Continuation var7 = (Continuation)this;
               this.L$0 = var4;
               this.label = 1;
               if (var5.insertTrackedLocation(var4, var7) == var3) {
                  return var3;
               }
            }

            var1 = this.this$0.trackedLocationRepository;
            AqiData var6 = AqiData.copy$default(this.$aqiData, var4.getId(), 0L, (OutdoorPollutants)null, 6, (Object)null);
            Continuation var9 = (Continuation)this;
            this.L$0 = SpillingKt.nullOutSpilledVariable(var4);
            this.label = 2;
            if (var1.insertAqiData(var6, var9) == var3) {
               return var3;
            } else {
               return Unit.INSTANCE;
            }
         }
      };
      ((<undefinedtype>)var6).L$0 = SpillingKt.nullOutSpilledVariable(var15);
      ((<undefinedtype>)var6).L$1 = SpillingKt.nullOutSpilledVariable(var10);
      ((<undefinedtype>)var6).L$2 = SpillingKt.nullOutSpilledVariable(var17);
      ((<undefinedtype>)var6).Z$0 = var3;
      ((<undefinedtype>)var6).label = 2;
      var10 = (AqiData)ApiResultKt.onSuccess(var21, var20, (Continuation)var6);
      if (var10 != var9) {
         return var10;
      } else {
         return var9;
      }
   }

   public final LiveData liveAqiData(TrackedLocation var1) {
      Intrinsics.checkNotNullParameter(var1, "location");
      return this.trackedLocationRepository.liveAqiData(var1.getId());
   }

   public final LiveData liveTrackedLocation(String var1) {
      Intrinsics.checkNotNullParameter(var1, "locationId");
      return this.trackedLocationRepository.getLiveTrackedLocation(var1);
   }

   public void logOut() {
      this.deleteAllOutdoorDataInBackground();
   }

   public final Object setCurrentLocation(double var1, double var3, Continuation var5) {
      double var6;
      Object var10;
      label65: {
         var6 = var1;
         var1 = var3;
         if (var5 instanceof <undefinedtype>) {
            var10 = (<undefinedtype>)var5;
            if ((((<undefinedtype>)var10).label & Integer.MIN_VALUE) != 0) {
               ((<undefinedtype>)var10).label += Integer.MIN_VALUE;
               break label65;
            }
         }

         var10 = new ContinuationImpl(this, var5) {
            double D$0;
            double D$1;
            int I$0;
            Object L$0;
            Object L$1;
            Object L$2;
            int label;
            Object result;
            final OutdoorService this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.setCurrentLocation((double)0.0F, (double)0.0F, (Continuation)this);
            }
         };
      }

      label58: {
         TrackedLocation var9;
         Object var13;
         int var24;
         TrackedLocation var30;
         label68: {
            var19 = ((<undefinedtype>)var10).result;
            var13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            var24 = ((<undefinedtype>)var10).label;
            if (var24 != 0) {
               if (var24 != 1) {
                  if (var24 != 2) {
                     if (var24 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                     }

                     var24 = ((<undefinedtype>)var10).I$0;
                     var1 = ((<undefinedtype>)var10).D$1;
                     var1 = ((<undefinedtype>)var10).D$0;
                     var9 = (TrackedLocation)((<undefinedtype>)var10).L$2;
                     var9 = (TrackedLocation)((<undefinedtype>)var10).L$1;
                     var9 = (TrackedLocation)((<undefinedtype>)var10).L$0;
                     ResultKt.throwOnFailure(var19);
                     break label58;
                  }

                  var24 = ((<undefinedtype>)var10).I$0;
                  var1 = ((<undefinedtype>)var10).D$1;
                  var3 = ((<undefinedtype>)var10).D$0;
                  var30 = (TrackedLocation)((<undefinedtype>)var10).L$2;
                  TrackedLocation var33 = (TrackedLocation)((<undefinedtype>)var10).L$1;
                  var9 = (TrackedLocation)((<undefinedtype>)var10).L$0;
                  ResultKt.throwOnFailure(var19);
                  var20 = var33;
                  break label68;
               }

               var1 = ((<undefinedtype>)var10).D$1;
               var3 = ((<undefinedtype>)var10).D$0;
               TrackedLocation var12 = (TrackedLocation)((<undefinedtype>)var10).L$1;
               var9 = (TrackedLocation)((<undefinedtype>)var10).L$0;
               ResultKt.throwOnFailure(var19);
               var30 = (TrackedLocation)var19;
               var20 = var12;
            } else {
               ResultKt.throwOnFailure(var19);
               var9 = this.getDatabaseCurrentLocation();
               Double var21;
               if (var9 != null) {
                  var21 = Boxing.boxDouble(var9.getLat());
               } else {
                  var21 = null;
               }

               if (Intrinsics.areEqual(var21, var6) && var9.getLon() == var3) {
                  return Unit.INSTANCE;
               }

               UserInfoCollectionsManager var31 = UserInfoCollectionsManager.INSTANCE;
               UserInfoItem var34 = UserInfoItem.USER_LOCATION;
               StringBuilder var22 = new StringBuilder();
               var22.append(var6);
               var22.append(", ");
               var22.append(var3);
               UserInfoCollectionsManager.addRecord$default(var31, var34, var22.toString(), false, 4, (Object)null);
               var20 = new TrackedLocation("current", var6, var3, (String)null, (String)null, (String)null, (String)null, (String)null, "WGS");
               GeocodeService var32 = this.geocodeService;
               ((<undefinedtype>)var10).L$0 = var9;
               ((<undefinedtype>)var10).L$1 = SpillingKt.nullOutSpilledVariable(var20);
               ((<undefinedtype>)var10).D$0 = var6;
               ((<undefinedtype>)var10).D$1 = var3;
               ((<undefinedtype>)var10).label = 1;
               var30 = (TrackedLocation)var32.getTrackedLocation(var20, (Continuation)var10);
               if (var30 == var13) {
                  return var13;
               }

               var3 = var6;
            }

            var30 = var30;
            if (var30 == null) {
               return Unit.INSTANCE;
            }

            Timber.Forest var14 = Timber.Forest;
            StringBuilder var35 = new StringBuilder("setCurrentLocation: oldCurrentLocation = ");
            var35.append(var9);
            var35.append(", nuCurrentLocation = ");
            var35.append(var30);
            var14.d(var35.toString(), new Object[0]);
            TrackedLocationRepository var36 = this.trackedLocationRepository;
            ((<undefinedtype>)var10).L$0 = SpillingKt.nullOutSpilledVariable(var9);
            ((<undefinedtype>)var10).L$1 = SpillingKt.nullOutSpilledVariable(var20);
            ((<undefinedtype>)var10).L$2 = var30;
            ((<undefinedtype>)var10).D$0 = var3;
            ((<undefinedtype>)var10).D$1 = var1;
            ((<undefinedtype>)var10).I$0 = 0;
            ((<undefinedtype>)var10).label = 2;
            if (var36.insertTrackedLocation(var30, (Continuation)var10) == var13) {
               return var13;
            }

            var24 = 0;
         }

         ((<undefinedtype>)var10).L$0 = SpillingKt.nullOutSpilledVariable(var9);
         ((<undefinedtype>)var10).L$1 = SpillingKt.nullOutSpilledVariable(var20);
         ((<undefinedtype>)var10).L$2 = SpillingKt.nullOutSpilledVariable(var30);
         ((<undefinedtype>)var10).D$0 = var3;
         ((<undefinedtype>)var10).D$1 = var1;
         ((<undefinedtype>)var10).I$0 = var24;
         ((<undefinedtype>)var10).label = 3;
         var9 = (TrackedLocation)this.fetchAqiData(var30, true, (Continuation)var10);
         var19 = var9;
         if (var9 == var13) {
            return var13;
         }
      }

      AqiData var23 = (AqiData)var19;
      return Unit.INSTANCE;
   }
}
