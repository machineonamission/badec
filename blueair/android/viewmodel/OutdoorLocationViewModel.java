package com.blueair.android.viewmodel;

import android.app.Application;
import android.os.Bundle;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.blueair.auth.AuthService;
import com.blueair.auth.LocationService;
import com.blueair.core.model.AqiData;
import com.blueair.core.model.TrackedLocation;
import com.blueair.outdoor.service.OutdoorService;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
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
   d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0005\b\u0007\u0018\u0000 <2\u00020\u0001:\u0001<B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u00102\u001a\u0002032\u0006\u00104\u001a\u000205J\u0016\u00106\u001a\u0002032\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u000208J\u0006\u0010:\u001a\u000203J\u0006\u0010;\u001a\u000203R\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u000b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u00118F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00168F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R#\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u00168FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001b\u0010\u0018R\u001b\u0010\u001e\u001a\u00020\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u001d\u001a\u0004\b \u0010!R\u001b\u0010#\u001a\u00020$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\u001d\u001a\u0004\b%\u0010&R\u001b\u0010(\u001a\u00020)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\u001d\u001a\u0004\b*\u0010+R\u0011\u0010-\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b-\u0010\nR\u0011\u0010.\u001a\u00020/8F¢\u0006\u0006\u001a\u0004\b0\u00101¨\u0006="},
   d2 = {"Lcom/blueair/android/viewmodel/OutdoorLocationViewModel;", "Lcom/blueair/viewcore/viewmodel/BaseViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "value", "", "useCurrentLocation", "getUseCurrentLocation", "()Z", "", "position", "getPosition", "()I", "fixedLocation", "Landroidx/lifecycle/MutableLiveData;", "Lcom/blueair/core/model/TrackedLocation;", "location", "getLocation", "()Lcom/blueair/core/model/TrackedLocation;", "liveLocation", "Landroidx/lifecycle/LiveData;", "getLiveLocation", "()Landroidx/lifecycle/LiveData;", "liveAqiData", "Lcom/blueair/core/model/AqiData;", "getLiveAqiData", "liveAqiData$delegate", "Lkotlin/Lazy;", "outdoorService", "Lcom/blueair/outdoor/service/OutdoorService;", "getOutdoorService", "()Lcom/blueair/outdoor/service/OutdoorService;", "outdoorService$delegate", "locationService", "Lcom/blueair/auth/LocationService;", "getLocationService", "()Lcom/blueair/auth/LocationService;", "locationService$delegate", "authService", "Lcom/blueair/auth/AuthService;", "getAuthService", "()Lcom/blueair/auth/AuthService;", "authService$delegate", "isUserLoggedIn", "mapType", "Lcom/blueair/auth/LocationService$MapType;", "getMapType", "()Lcom/blueair/auth/LocationService$MapType;", "update", "", "args", "Landroid/os/Bundle;", "setCurrentLocation", "lat", "", "lon", "clearCurrentLocation", "refreshAqiData", "Companion", "app_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class OutdoorLocationViewModel extends BaseViewModel {
   static final KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property1((PropertyReference1)(new PropertyReference1Impl(OutdoorLocationViewModel.class, "outdoorService", "getOutdoorService()Lcom/blueair/outdoor/service/OutdoorService;", 0))), Reflection.property1((PropertyReference1)(new PropertyReference1Impl(OutdoorLocationViewModel.class, "locationService", "getLocationService()Lcom/blueair/auth/LocationService;", 0))), Reflection.property1((PropertyReference1)(new PropertyReference1Impl(OutdoorLocationViewModel.class, "authService", "getAuthService()Lcom/blueair/auth/AuthService;", 0)))};
   public static final int $stable = 8;
   private static final TrackedLocation BEJING = new TrackedLocation("beijing", 39.91509030149438, 116.38416193043909, "China", "北京市", "北京市", "China", "CN", "GCJ");
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private static final int FALLBACK_POSITION = -1;
   public static final String KEY_COLLAPSE = "KEY_COLLAPSE";
   public static final String KEY_POSITION = "KEY_POSITION";
   public static final String KEY_TRACKED_LOCATION = "KEY_TRACKED_LOCATION";
   public static final String KEY_USE_CURRENT_LOCATION = "KEY_USE_CURRENT_LOCATION";
   private final Lazy authService$delegate;
   private MutableLiveData fixedLocation;
   private final Lazy liveAqiData$delegate;
   private final Lazy locationService$delegate;
   private final Lazy outdoorService$delegate;
   private int position;
   private boolean useCurrentLocation;

   // $FF: synthetic method
   public static Unit $r8$lambda$YZNdxRWD_5FMTrHD3WuUOpcwyds(Ref.ObjectRef var0, MediatorLiveData var1, OutdoorLocationViewModel var2, TrackedLocation var3) {
      return liveAqiData_delegate$lambda$4$lambda$3$lambda$2(var0, var1, var2, var3);
   }

   // $FF: synthetic method
   public static MediatorLiveData $r8$lambda$ZvheTtp0KUnzqHkzAvRQAaFmPBE(OutdoorLocationViewModel var0) {
      return liveAqiData_delegate$lambda$4(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$qolooIRwiBSasE_tjJZJKOpk6uU/* $FF was: $r8$lambda$qolooIRwiBSasE-tjJZJKOpk6uU*/(MediatorLiveData var0, AqiData var1) {
      return liveAqiData_delegate$lambda$4$lambda$3$lambda$2$lambda$1(var0, var1);
   }

   public OutdoorLocationViewModel(Application var1) {
      Intrinsics.checkNotNullParameter(var1, "application");
      super(var1);
      this.position = -1;
      this.fixedLocation = new MutableLiveData();
      this.liveAqiData$delegate = LazyKt.lazy(new OutdoorLocationViewModel$$ExternalSyntheticLambda1(this));
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
      this.locationService$delegate = DIAwareKt.Instance(var4, (TypeToken)(new GenericJVMTypeTokenDelegate(var6, LocationService.class)), (Object)null).provideDelegate(this, var5[1]);
      var6 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var6, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      this.authService$delegate = DIAwareKt.Instance(var4, (TypeToken)(new GenericJVMTypeTokenDelegate(var6, AuthService.class)), (Object)null).provideDelegate(this, var5[2]);
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

   private static final MediatorLiveData liveAqiData_delegate$lambda$4(OutdoorLocationViewModel var0) {
      MediatorLiveData var1 = new MediatorLiveData();
      Ref.ObjectRef var2 = new Ref.ObjectRef();
      var1.addSource(var0.getLiveLocation(), new Observer(new OutdoorLocationViewModel$$ExternalSyntheticLambda0(var2, var1, var0)) {
         private final Function1 function;

         {
            Intrinsics.checkNotNullParameter(var1, "function");
            this.function = var1;
         }

         public final boolean equals(Object var1) {
            return var1 instanceof Observer && var1 instanceof FunctionAdapter ? Intrinsics.areEqual(((FunctionAdapter)this).getFunctionDelegate(), ((FunctionAdapter)var1).getFunctionDelegate()) : false;
         }

         public final Function getFunctionDelegate() {
            return (Function)this.function;
         }

         public final int hashCode() {
            return ((FunctionAdapter)this).getFunctionDelegate().hashCode();
         }

         // $FF: synthetic method
         public final void onChanged(Object var1) {
            this.function.invoke(var1);
         }
      });
      return var1;
   }

   private static final Unit liveAqiData_delegate$lambda$4$lambda$3$lambda$2(Ref.ObjectRef var0, MediatorLiveData var1, OutdoorLocationViewModel var2, TrackedLocation var3) {
      if (var3 == null) {
         LiveData var4 = (LiveData)var0.element;
         if (var4 != null) {
            var1.removeSource(var4);
         }

         var1.setValue((Object)null);
      } else {
         var0.element = var2.getOutdoorService().liveAqiData(var3);
         Object var5 = var0.element;
         Intrinsics.checkNotNull(var5);
         var1.addSource((LiveData)var5, new Observer(new OutdoorLocationViewModel$$ExternalSyntheticLambda2(var1)) {
            private final Function1 function;

            {
               Intrinsics.checkNotNullParameter(var1, "function");
               this.function = var1;
            }

            public final boolean equals(Object var1) {
               return var1 instanceof Observer && var1 instanceof FunctionAdapter ? Intrinsics.areEqual(((FunctionAdapter)this).getFunctionDelegate(), ((FunctionAdapter)var1).getFunctionDelegate()) : false;
            }

            public final Function getFunctionDelegate() {
               return (Function)this.function;
            }

            public final int hashCode() {
               return ((FunctionAdapter)this).getFunctionDelegate().hashCode();
            }

            // $FF: synthetic method
            public final void onChanged(Object var1) {
               this.function.invoke(var1);
            }
         });
      }

      return Unit.INSTANCE;
   }

   private static final Unit liveAqiData_delegate$lambda$4$lambda$3$lambda$2$lambda$1(MediatorLiveData var0, AqiData var1) {
      var0.setValue(var1);
      return Unit.INSTANCE;
   }

   public final void clearCurrentLocation() {
      BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(this, (Continuation)null) {
         int label;
         final OutdoorLocationViewModel this$0;

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

   public final LiveData getLiveAqiData() {
      return (LiveData)this.liveAqiData$delegate.getValue();
   }

   public final LiveData getLiveLocation() {
      return this.useCurrentLocation ? this.getOutdoorService().getDatabaseLiveCurrentLocation() : (LiveData)this.fixedLocation;
   }

   public final TrackedLocation getLocation() {
      Object var1;
      if (this.useCurrentLocation) {
         var1 = this.getLiveLocation().getValue();
      } else {
         var1 = this.fixedLocation.getValue();
      }

      return (TrackedLocation)var1;
   }

   public final LocationService.MapType getMapType() {
      return this.getLocationService().getMapType();
   }

   public final int getPosition() {
      return this.position;
   }

   public final boolean getUseCurrentLocation() {
      return this.useCurrentLocation;
   }

   public final boolean isUserLoggedIn() {
      return (Boolean)this.getAuthService().isUserLoggedIn().getValue();
   }

   public final void refreshAqiData() {
      BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(this, (Continuation)null) {
         int I$0;
         Object L$0;
         int label;
         final OutdoorLocationViewModel this$0;

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

               TrackedLocation var6 = (TrackedLocation)this.L$0;
               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               TrackedLocation var4 = this.this$0.getLocation();
               if (var4 != null) {
                  var1 = this.this$0.getOutdoorService();
                  this.L$0 = SpillingKt.nullOutSpilledVariable(var4);
                  this.I$0 = 0;
                  this.label = 1;
                  if (OutdoorService.fetchAqiData$default(var1, var4, false, this, 2, (Object)null) == var3) {
                     return var3;
                  }
               }
            }

            return Unit.INSTANCE;
         }
      }, 2, (Object)null);
   }

   public final void setCurrentLocation(double var1, double var3) {
      BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(this, var1, var3, (Continuation)null) {
         final double $lat;
         final double $lon;
         int label;
         final OutdoorLocationViewModel this$0;

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
               var1 = this.this$0.getOutdoorService();
               double var2 = this.$lat;
               double var4 = this.$lon;
               Continuation var8 = (Continuation)this;
               this.label = 1;
               if (var1.setCurrentLocation(var2, var4, var8) == var7) {
                  return var7;
               }
            }

            return Unit.INSTANCE;
         }
      }, 2, (Object)null);
   }

   public final void update(Bundle var1) {
      Intrinsics.checkNotNullParameter(var1, "args");
      boolean var2 = var1.getBoolean("KEY_USE_CURRENT_LOCATION", false);
      this.useCurrentLocation = var2;
      if (!var2) {
         MutableLiveData var5 = this.fixedLocation;
         TrackedLocation var4 = (TrackedLocation)var1.getParcelable("KEY_TRACKED_LOCATION");
         TrackedLocation var3 = var4;
         if (var4 == null) {
            var3 = BEJING;
         }

         var5.setValue(var3);
      }

      this.position = var1.getInt("KEY_POSITION", -1);
      Timber.Forest var6 = Timber.Forest;
      StringBuilder var7 = new StringBuilder("update: position = ");
      var7.append(this.position);
      var7.append(", useCurrentLocation = ");
      var7.append(this.useCurrentLocation);
      var7.append(", fixedLocation.value arg = ");
      var7.append(this.fixedLocation.getValue());
      var6.d(var7.toString(), new Object[0]);
   }

   @Metadata(
      d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"},
      d2 = {"Lcom/blueair/android/viewmodel/OutdoorLocationViewModel$Companion;", "", "<init>", "()V", "KEY_TRACKED_LOCATION", "", "KEY_USE_CURRENT_LOCATION", "KEY_POSITION", "KEY_COLLAPSE", "FALLBACK_POSITION", "", "BEJING", "Lcom/blueair/core/model/TrackedLocation;", "getBEJING", "()Lcom/blueair/core/model/TrackedLocation;", "app_otherRelease"},
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

      public final TrackedLocation getBEJING() {
         return OutdoorLocationViewModel.BEJING;
      }
   }
}
