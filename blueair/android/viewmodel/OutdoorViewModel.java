package com.blueair.android.viewmodel;

import android.app.Application;
import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.LiveData;
import com.blueair.auth.AuthService;
import com.blueair.auth.LocationService;
import com.blueair.core.model.AnalyticEvent;
import com.blueair.core.model.TrackedLocation;
import com.blueair.outdoor.service.OutdoorService;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import io.flatcircle.coroutinehelper.ApiResult;
import io.flatcircle.coroutinehelper.ApiResultKt;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import org.kodein.di.DIAware;
import org.kodein.di.DIAwareKt;
import org.kodein.di.LazyDelegate;
import org.kodein.type.GenericJVMTypeTokenDelegate;
import org.kodein.type.JVMTypeToken;
import org.kodein.type.TypeReference;
import org.kodein.type.TypeToken;
import org.kodein.type.TypeTokensJVMKt;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010.\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010)0\u001d2\u0006\u0010/\u001a\u00020\"J\u000e\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u001eJ\b\u00103\u001a\u000201H\u0014J\u000e\u00104\u001a\u0002012\u0006\u0010/\u001a\u00020\"J\u0016\u00105\u001a\u0002012\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u000207J\u0006\u00109\u001a\u000201J\u000e\u0010:\u001a\u0002012\u0006\u0010;\u001a\u00020<R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0018\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001fR\u001d\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0!0\u001d8F¢\u0006\u0006\u001a\u0004\b#\u0010\u001fR\u0019\u0010$\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\"0\u001d8F¢\u0006\u0006\u001a\u0004\b%\u0010\u001fRG\u0010&\u001a.\u0012\u0004\u0012\u00020(\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010)0\u001d0'j\u0016\u0012\u0004\u0012\u00020(\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010)0\u001d`*8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b-\u0010\r\u001a\u0004\b+\u0010,¨\u0006="},
   d2 = {"Lcom/blueair/android/viewmodel/OutdoorViewModel;", "Lcom/blueair/viewcore/viewmodel/BaseViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "lastRefreshTime", "", "outdoorService", "Lcom/blueair/outdoor/service/OutdoorService;", "getOutdoorService", "()Lcom/blueair/outdoor/service/OutdoorService;", "outdoorService$delegate", "Lkotlin/Lazy;", "authService", "Lcom/blueair/auth/AuthService;", "getAuthService", "()Lcom/blueair/auth/AuthService;", "authService$delegate", "locationService", "Lcom/blueair/auth/LocationService;", "getLocationService", "()Lcom/blueair/auth/LocationService;", "locationService$delegate", "mapType", "Lcom/blueair/auth/LocationService$MapType;", "getMapType", "()Lcom/blueair/auth/LocationService$MapType;", "isUserLoggedIn", "Landroidx/lifecycle/LiveData;", "", "()Landroidx/lifecycle/LiveData;", "liveUserLocations", "", "Lcom/blueair/core/model/TrackedLocation;", "getLiveUserLocations", "liveCurrentLocation", "getLiveCurrentLocation", "aqiDataMap", "Ljava/util/HashMap;", "", "Lcom/blueair/core/model/AqiData;", "Lkotlin/collections/HashMap;", "getAqiDataMap", "()Ljava/util/HashMap;", "aqiDataMap$delegate", "liveAqiData", "location", "refreshTrackedLocationList", "", "hasBeenPaused", "onCleared", "refreshAqiData", "setCurrentLocation", "lat", "", "lon", "clearCurrentLocation", "trackEvent", "event", "Lcom/blueair/core/model/AnalyticEvent;", "app_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class OutdoorViewModel extends BaseViewModel {
   static final KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property1((PropertyReference1)(new PropertyReference1Impl(OutdoorViewModel.class, "outdoorService", "getOutdoorService()Lcom/blueair/outdoor/service/OutdoorService;", 0))), Reflection.property1((PropertyReference1)(new PropertyReference1Impl(OutdoorViewModel.class, "authService", "getAuthService()Lcom/blueair/auth/AuthService;", 0))), Reflection.property1((PropertyReference1)(new PropertyReference1Impl(OutdoorViewModel.class, "locationService", "getLocationService()Lcom/blueair/auth/LocationService;", 0)))};
   public static final int $stable = 8;
   private final Lazy aqiDataMap$delegate;
   private final Lazy authService$delegate;
   private final LiveData isUserLoggedIn;
   private long lastRefreshTime;
   private final Lazy locationService$delegate;
   private final Lazy outdoorService$delegate;

   // $FF: synthetic method
   public static HashMap $r8$lambda$J04UKd8tI3TrWHX4SVEkoBOwvwE() {
      return aqiDataMap_delegate$lambda$0();
   }

   public OutdoorViewModel(Application var1) {
      Intrinsics.checkNotNullParameter(var1, "application");
      super(var1);
      DIAware var4 = this;
      JVMTypeToken var2 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var2, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      LazyDelegate var3 = DIAwareKt.Instance(var4, (TypeToken)(new GenericJVMTypeTokenDelegate(var2, OutdoorService.class)), (Object)null);
      KProperty[] var5 = $$delegatedProperties;
      this.outdoorService$delegate = var3.provideDelegate(this, var5[0]);
      JVMTypeToken var6 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var6, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      this.authService$delegate = DIAwareKt.Instance(var4, (TypeToken)(new GenericJVMTypeTokenDelegate(var6, AuthService.class)), (Object)null).provideDelegate(this, var5[1]);
      var6 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var6, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      this.locationService$delegate = DIAwareKt.Instance(var4, (TypeToken)(new GenericJVMTypeTokenDelegate(var6, LocationService.class)), (Object)null).provideDelegate(this, var5[2]);
      this.isUserLoggedIn = FlowLiveDataConversions.asLiveData$default((Flow)this.getAuthService().isUserLoggedIn(), (CoroutineContext)null, 0L, 3, (Object)null);
      this.aqiDataMap$delegate = LazyKt.lazy(new OutdoorViewModel$$ExternalSyntheticLambda0());
   }

   private static final HashMap aqiDataMap_delegate$lambda$0() {
      return new HashMap();
   }

   private final AuthService getAuthService() {
      return (AuthService)this.authService$delegate.getValue();
   }

   private final LocationService getLocationService() {
      return (LocationService)this.locationService$delegate.getValue();
   }

   private final OutdoorService getOutdoorService() {
      return (OutdoorService)this.outdoorService$delegate.getValue();
   }

   public final void clearCurrentLocation() {
      BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(this, (Continuation)null) {
         int label;
         final OutdoorViewModel this$0;

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
               OutdoorService var4 = this.this$0.getOutdoorService();
               Continuation var5 = (Continuation)this;
               this.label = 1;
               if (var4.clearCurrentLocation(var5) == var3) {
                  return var3;
               }
            }

            return Unit.INSTANCE;
         }
      }, 2, (Object)null);
   }

   public final HashMap getAqiDataMap() {
      return (HashMap)this.aqiDataMap$delegate.getValue();
   }

   public final LiveData getLiveCurrentLocation() {
      return this.getOutdoorService().getDatabaseLiveCurrentLocation();
   }

   public final LiveData getLiveUserLocations() {
      return this.getOutdoorService().getDatabaseLiveUserTrackedLocations();
   }

   public final LocationService.MapType getMapType() {
      return this.getLocationService().getMapType();
   }

   public final LiveData isUserLoggedIn() {
      return this.isUserLoggedIn;
   }

   public final LiveData liveAqiData(TrackedLocation var1) {
      Intrinsics.checkNotNullParameter(var1, "location");
      return this.getOutdoorService().liveAqiData(var1);
   }

   protected void onCleared() {
      super.onCleared();
      this.getAqiDataMap().clear();
   }

   public final void refreshAqiData(TrackedLocation var1) {
      Intrinsics.checkNotNullParameter(var1, "location");
      BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(this, var1, (Continuation)null) {
         final TrackedLocation $location;
         int label;
         final OutdoorViewModel this$0;

         {
            this.this$0 = var1;
            this.$location = var2;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.this$0, this.$location, var2));
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
               var1 = this.this$0.getOutdoorService();
               TrackedLocation var4 = this.$location;
               Continuation var5 = (Continuation)this;
               this.label = 1;
               if (var1.fetchAqiData(var4, true, var5) == var3) {
                  return var3;
               }
            }

            return Unit.INSTANCE;
         }
      }, 2, (Object)null);
   }

   public final void refreshTrackedLocationList(boolean var1) {
      boolean var6 = (Boolean)this.getAuthService().isUserLoggedIn().getValue();
      Timber.Forest var7 = Timber.Forest;
      StringBuilder var8 = new StringBuilder("refresh location list: hasBeenPaused = ");
      var8.append(var1);
      var8.append(", isUserLoggedIn = ");
      var8.append(var6);
      var7.d(var8.toString(), new Object[0]);
      if (var6) {
         long var4 = System.currentTimeMillis();
         long var2 = this.lastRefreshTime;
         if (!var1 || var4 - var2 > 300000L) {
            this.lastRefreshTime = var4;
            BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(this, (Continuation)null) {
               int label;
               final OutdoorViewModel this$0;

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
                  label32: {
                     var4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                     int var2 = this.label;
                     if (var2 != 0) {
                        if (var2 != 1) {
                           if (var2 != 2) {
                              if (var2 != 3) {
                                 throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                              }

                              ResultKt.throwOnFailure(var1);
                              return Unit.INSTANCE;
                           }

                           ResultKt.throwOnFailure(var1);
                           break label32;
                        }

                        ResultKt.throwOnFailure(var1);
                     } else {
                        ResultKt.throwOnFailure(var1);
                        OutdoorService var3 = this.this$0.getOutdoorService();
                        Continuation var6 = (Continuation)this;
                        this.label = 1;
                        Object var9 = var3.downloadTrackedLocations(var6);
                        var1 = var9;
                        if (var9 == var4) {
                           return var4;
                        }
                     }

                     ApiResult var10 = (ApiResult)var1;
                     Function2 var7 = new Function2((Continuation)null) {
                        Object L$0;
                        int label;

                        public final Continuation create(Object var1, Continuation var2) {
                           Function2 var3 = new <anonymous constructor>(var2);
                           var3.L$0 = var1;
                           return (Continuation)var3;
                        }

                        public final Object invoke(Throwable var1, Continuation var2) {
                           return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
                        }

                        public final Object invokeSuspend(Object var1) {
                           Throwable var2 = (Throwable)this.L$0;
                           IntrinsicsKt.getCOROUTINE_SUSPENDED();
                           if (this.label == 0) {
                              ResultKt.throwOnFailure(var1);
                              Timber.Forest var3 = Timber.Forest;
                              StringBuilder var4 = new StringBuilder("downloadTrackedLocationList: fail = ");
                              var4.append(var2);
                              var3.e(var2, var4.toString(), new Object[0]);
                              return Unit.INSTANCE;
                           } else {
                              throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                           }
                        }
                     };
                     Continuation var5 = (Continuation)this;
                     this.label = 2;
                     Object var11 = ApiResultKt.onFail(var10, var7, var5);
                     var1 = var11;
                     if (var11 == var4) {
                        return var4;
                     }
                  }

                  ApiResult var8 = (ApiResult)var1;
                  Function2 var13 = new Function2((Continuation)null) {
                     boolean Z$0;
                     int label;

                     public final Continuation create(Object var1, Continuation var2) {
                        Function2 var3 = new <anonymous constructor>(var2);
                        var3.Z$0 = (Boolean)var1;
                        return (Continuation)var3;
                     }

                     public final Object invoke(boolean var1, Continuation var2) {
                        return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
                     }

                     public final Object invokeSuspend(Object var1) {
                        boolean var2 = this.Z$0;
                        IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        if (this.label == 0) {
                           ResultKt.throwOnFailure(var1);
                           Timber.Forest var4 = Timber.Forest;
                           StringBuilder var3 = new StringBuilder("downloadTrackedLocationList: success = ");
                           var3.append(var2);
                           var4.d(var3.toString(), new Object[0]);
                           return Unit.INSTANCE;
                        } else {
                           throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                     }
                  };
                  Continuation var12 = (Continuation)this;
                  this.label = 3;
                  if (ApiResultKt.onSuccess(var8, var13, var12) == var4) {
                     return var4;
                  } else {
                     return Unit.INSTANCE;
                  }
               }
            }, 2, (Object)null);
         }
      }
   }

   public final void setCurrentLocation(double var1, double var3) {
      BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(this, var1, var3, (Continuation)null) {
         final double $lat;
         final double $lon;
         int label;
         final OutdoorViewModel this$0;

         {
            this.this$0 = var1;
            this.$lat = var2;
            this.$lon = var4;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.this$0, this.$lat, this.$lon, var2));
         }

         public final Object invoke(CoroutineScope var1, Continuation var2) {
            return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
         }

         public final Object invokeSuspend(Object var1) {
            Object var7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int var6 = this.label;
            if (var6 != 0) {
               if (var6 != 1) {
                  throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
               }

               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               OutdoorService var8 = this.this$0.getOutdoorService();
               double var2 = this.$lat;
               double var4 = this.$lon;
               Continuation var9 = (Continuation)this;
               this.label = 1;
               if (var8.setCurrentLocation(var2, var4, var9) == var7) {
                  return var7;
               }
            }

            return Unit.INSTANCE;
         }
      }, 2, (Object)null);
   }

   public final void trackEvent(AnalyticEvent var1) {
      Intrinsics.checkNotNullParameter(var1, "event");
      this.getAnalyticsService().event(var1);
   }
}
