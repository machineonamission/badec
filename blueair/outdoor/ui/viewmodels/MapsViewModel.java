package com.blueair.outdoor.ui.viewmodels;

import android.app.Application;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;
import com.blueair.auth.AuthService;
import com.blueair.core.model.AqiData;
import com.blueair.core.model.Device;
import com.blueair.core.model.HasLocation;
import com.blueair.core.model.TrackedLocation;
import com.blueair.outdoor.service.OutdoorService;
import com.blueair.outdoor.ui.adapters.LocationItem;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import io.flatcircle.coroutinehelper.ApiResult;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
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

@Metadata(
   d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001iB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010L\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002070)0M2\u0006\u0010N\u001a\u000207H\u0086@¢\u0006\u0002\u0010OJ8\u0010P\u001a\b\u0012\u0004\u0012\u00020Q0M2\u0006\u0010N\u001a\u0002072\f\u0010R\u001a\b\u0012\u0004\u0012\u0002070)2\f\u0010S\u001a\b\u0012\u0004\u0012\u0002070)H\u0086@¢\u0006\u0002\u0010TJ \u0010U\u001a\u00020\u00192\u0006\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020W2\b\u0010Y\u001a\u0004\u0018\u000107J\u0010\u0010\u0017\u001a\u00020Z2\u0006\u0010[\u001a\u00020\u0019H\u0002J \u0010\u0017\u001a\u00020Z2\u0006\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020W2\b\u0010Y\u001a\u0004\u0018\u000107J \u0010!\u001a\u00020Z2\u0006\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020W2\b\u0010Y\u001a\u0004\u0018\u000107J \u0010\\\u001a\u00020Z2\u0006\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020W2\b\u0010Y\u001a\u0004\u0018\u000107J\u0006\u0010]\u001a\u00020ZJ\u0006\u0010^\u001a\u00020ZJ\u0006\u0010_\u001a\u00020ZJ\b\u0010A\u001a\u0004\u0018\u00010@J<\u0010`\u001a\u00020Z2\u0006\u0010a\u001a\u00020\u00192\u0006\u0010b\u001a\u0002012\u0006\u0010c\u001a\u00020\u00122\u001c\b\u0002\u0010d\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190M\u0012\u0004\u0012\u00020Z\u0018\u00010eJ\u000e\u0010f\u001a\u00020Z2\u0006\u0010a\u001a\u00020\u0019J\u0014\u0010g\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020:0)09H\u0002J\u0010\u0010h\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010:09H\u0002R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R#\u0010#\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00120$0\u0018¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001bR\u001d\u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190)0(¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0019\u0010,\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190(¢\u0006\b\n\u0000\u001a\u0004\b-\u0010+R\u001d\u0010.\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190)0(¢\u0006\b\n\u0000\u001a\u0004\b/\u0010+R\u001a\u00100\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002010)0(X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u00102\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002030)0(¢\u0006\b\n\u0000\u001a\u0004\b4\u0010+R\u001c\u00105\u001a\u0010\u0012\u0004\u0012\u000207\u0012\u0006\u0012\u0004\u0018\u00010706X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u00108\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010:09¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u001d\u0010=\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020:0)09¢\u0006\b\n\u0000\u001a\u0004\b>\u0010<R \u0010?\u001a\b\u0012\u0004\u0012\u00020@0\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u001b\"\u0004\bB\u0010\u001dR.\u0010C\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u000201\u0018\u00010$0\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\u001b\"\u0004\bE\u0010\u001dR&\u0010F\u001a\u000e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020706X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u0011\u0010K\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\bK\u0010\u0014¨\u0006j"},
   d2 = {"Lcom/blueair/outdoor/ui/viewmodels/MapsViewModel;", "Lcom/blueair/viewcore/viewmodel/BaseViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "outdoorService", "Lcom/blueair/outdoor/service/OutdoorService;", "getOutdoorService", "()Lcom/blueair/outdoor/service/OutdoorService;", "outdoorService$delegate", "Lkotlin/Lazy;", "authService", "Lcom/blueair/auth/AuthService;", "getAuthService", "()Lcom/blueair/auth/AuthService;", "authService$delegate", "mapIsReady", "", "getMapIsReady", "()Z", "setMapIsReady", "(Z)V", "viewLocation", "Landroidx/lifecycle/MutableLiveData;", "Lcom/blueair/core/model/TrackedLocation;", "getViewLocation", "()Landroidx/lifecycle/MutableLiveData;", "setViewLocation", "(Landroidx/lifecycle/MutableLiveData;)V", "currentlyViewedLocation", "getCurrentlyViewedLocation", "()Lcom/blueair/core/model/TrackedLocation;", "setCurrentlyViewedLocation", "(Lcom/blueair/core/model/TrackedLocation;)V", "savedLocationViewIndex", "Lkotlin/Pair;", "", "getSavedLocationViewIndex", "trackedLocations", "Landroidx/lifecycle/LiveData;", "", "getTrackedLocations", "()Landroidx/lifecycle/LiveData;", "currentLocation", "getCurrentLocation", "allLocations", "getAllLocations", "pollutants", "Lcom/blueair/core/model/AqiData;", "devices", "Lcom/blueair/core/model/Device;", "getDevices", "deviceLocationMap", "", "", "currentLocationWithPollutants", "Landroidx/lifecycle/MediatorLiveData;", "Lcom/blueair/outdoor/ui/adapters/LocationItem;", "getCurrentLocationWithPollutants", "()Landroidx/lifecycle/MediatorLiveData;", "trackedLocationWithPollutants", "getTrackedLocationWithPollutants", "mode", "Lcom/blueair/outdoor/ui/viewmodels/MapsViewModel$MapMode;", "getMode", "setMode", "addLocationModel", "getAddLocationModel", "setAddLocationModel", "markers", "getMarkers", "()Ljava/util/Map;", "setMarkers", "(Ljava/util/Map;)V", "isUserLoggedIn", "queryLocationDevices", "Lio/flatcircle/coroutinehelper/ApiResult;", "locationId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setLocationDevices", "Lokhttp3/ResponseBody;", "deviceIdList", "resetDeviceIdList", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createEmptyLocation", "lat", "", "lng", "mapType", "", "location", "fetchAirQuality", "setAddMode", "setNormalMode", "setMinimizedMode", "insertTrackedLocation", "trackedLocation", "pollutant", "isUpdate", "completion", "Lkotlin/Function1;", "deleteLocation", "createMergedSavedLocationsLiveData", "createMergedCurrentLocation", "MapMode", "outdoor_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class MapsViewModel extends BaseViewModel {
   static final KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property1((PropertyReference1)(new PropertyReference1Impl(MapsViewModel.class, "outdoorService", "getOutdoorService()Lcom/blueair/outdoor/service/OutdoorService;", 0))), Reflection.property1((PropertyReference1)(new PropertyReference1Impl(MapsViewModel.class, "authService", "getAuthService()Lcom/blueair/auth/AuthService;", 0)))};
   private MutableLiveData addLocationModel;
   private final LiveData allLocations;
   private final Lazy authService$delegate;
   private final LiveData currentLocation;
   private final MediatorLiveData currentLocationWithPollutants;
   private TrackedLocation currentlyViewedLocation;
   private final Map deviceLocationMap;
   private final LiveData devices;
   private boolean mapIsReady;
   private Map markers;
   private MutableLiveData mode;
   private final Lazy outdoorService$delegate;
   private final LiveData pollutants;
   private final MutableLiveData savedLocationViewIndex;
   private final MediatorLiveData trackedLocationWithPollutants;
   private final LiveData trackedLocations;
   private MutableLiveData viewLocation;

   // $FF: synthetic method
   public static Unit $r8$lambda$ADDeSann3G_4cNMoRmISODsBF_w/* $FF was: $r8$lambda$ADDeSann3G-4cNMoRmISODsBF_w*/(MapsViewModel var0, MediatorLiveData var1, List var2) {
      return createMergedCurrentLocation$lambda$17$lambda$15(var0, var1, var2);
   }

   // $FF: synthetic method
   public static List $r8$lambda$I2JzEKHY5KyZyo5NAgB8FfZGi_Q/* $FF was: $r8$lambda$I2JzEKHY5KyZyo5NAgB8FfZGi-Q*/(List var0) {
      return allLocations$lambda$1(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$_2rV_QfXJ4fjQgchD2YNuM8s8zc(MapsViewModel var0, MediatorLiveData var1, TrackedLocation var2) {
      return createMergedCurrentLocation$lambda$17$lambda$16(var0, var1, var2);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$a1eqX_0BBHDe6sMpGFMaiqO9wH8(MapsViewModel var0, MediatorLiveData var1, List var2) {
      return createMergedSavedLocationsLiveData$lambda$10$lambda$6(var0, var1, var2);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$aW2aG_R_e2bQZXhS0kE5t_4_9GA/* $FF was: $r8$lambda$aW2aG-R_e2bQZXhS0kE5t_4_9GA*/(MapsViewModel var0, MediatorLiveData var1, List var2) {
      return createMergedSavedLocationsLiveData$lambda$10$lambda$9(var0, var1, var2);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$yRgCouavttOOHmik5ST6RZzkQhk(MapsViewModel var0, MediatorLiveData var1, List var2) {
      return createMergedSavedLocationsLiveData$lambda$10$lambda$7(var0, var1, var2);
   }

   public MapsViewModel(Application var1) {
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
      this.viewLocation = new MutableLiveData();
      this.savedLocationViewIndex = new MutableLiveData(new Pair(0, true));
      this.trackedLocations = this.getOutdoorService().getDatabaseLiveUserTrackedLocations();
      this.currentLocation = this.getOutdoorService().getDatabaseLiveCurrentLocation();
      this.allLocations = Transformations.map(this.getOutdoorService().getDatabaseLiveTrackedLocations(), new MapsViewModel$$ExternalSyntheticLambda3());
      this.pollutants = this.getOutdoorService().getDatabaseLiveAqiData();
      this.devices = this.getDeviceManager().getLiveDevices();
      this.deviceLocationMap = (Map)(new LinkedHashMap());
      this.currentLocationWithPollutants = this.createMergedCurrentLocation();
      this.trackedLocationWithPollutants = this.createMergedSavedLocationsLiveData();
      this.mode = new MutableLiveData(MapsViewModel.MapMode.INITIAL);
      this.addLocationModel = new MutableLiveData();
      this.markers = (Map)(new LinkedHashMap());
   }

   private static final List allLocations$lambda$1(List var0) {
      Intrinsics.checkNotNullParameter(var0, "it");
      return CollectionsKt.sortedWith((Iterable)var0, new Comparator() {
         public final int compare(Object var1, Object var2) {
            return ComparisonsKt.compareValues((Comparable)((TrackedLocation)var2).isCurrentLocation(), (Comparable)((TrackedLocation)var1).isCurrentLocation());
         }
      });
   }

   private final MediatorLiveData createMergedCurrentLocation() {
      MediatorLiveData var1 = new MediatorLiveData();
      var1.addSource(this.pollutants, new Observer(new MapsViewModel$$ExternalSyntheticLambda4(this, var1)) {
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
      var1.addSource(this.currentLocation, new Observer(new MapsViewModel$$ExternalSyntheticLambda5(this, var1)) {
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

   private static final Unit createMergedCurrentLocation$lambda$17$lambda$15(MapsViewModel var0, MediatorLiveData var1, List var2) {
      createMergedCurrentLocation$lambda$17$mergeData$14(var0, var1);
      return Unit.INSTANCE;
   }

   private static final Unit createMergedCurrentLocation$lambda$17$lambda$16(MapsViewModel var0, MediatorLiveData var1, TrackedLocation var2) {
      createMergedCurrentLocation$lambda$17$mergeData$14(var0, var1);
      return Unit.INSTANCE;
   }

   private static final void createMergedCurrentLocation$lambda$17$mergeData$14(MapsViewModel var0, MediatorLiveData var1) {
      TrackedLocation var4 = (TrackedLocation)var0.currentLocation.getValue();
      Object var3 = null;
      LocationItem var2 = (LocationItem)var3;
      if (var4 != null) {
         List var5 = (List)var0.pollutants.getValue();
         var2 = (LocationItem)var3;
         if (var5 != null) {
            Iterator var8 = ((Iterable)var5).iterator();

            do {
               if (!var8.hasNext()) {
                  var6 = null;
                  break;
               }

               var6 = var8.next();
            } while(!Intrinsics.areEqual(((AqiData)var6).getLocationId(), var4.getId()));

            AqiData var7 = (AqiData)var6;
            var2 = (LocationItem)var3;
            if (var7 != null) {
               var2 = new LocationItem(var4, var7, CollectionsKt.emptyList());
            }
         }
      }

      var1.setValue(var2);
   }

   private final MediatorLiveData createMergedSavedLocationsLiveData() {
      MediatorLiveData var1 = new MediatorLiveData();
      var1.addSource(this.trackedLocations, new Observer(new MapsViewModel$$ExternalSyntheticLambda0(this, var1)) {
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
      var1.addSource(this.pollutants, new Observer(new MapsViewModel$$ExternalSyntheticLambda1(this, var1)) {
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
      var1.addSource(this.devices, new Observer(new MapsViewModel$$ExternalSyntheticLambda2(this, var1)) {
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

   private static final Unit createMergedSavedLocationsLiveData$lambda$10$lambda$6(MapsViewModel var0, MediatorLiveData var1, List var2) {
      createMergedSavedLocationsLiveData$lambda$10$mergeData(var0, var1);
      return Unit.INSTANCE;
   }

   private static final Unit createMergedSavedLocationsLiveData$lambda$10$lambda$7(MapsViewModel var0, MediatorLiveData var1, List var2) {
      createMergedSavedLocationsLiveData$lambda$10$mergeData(var0, var1);
      return Unit.INSTANCE;
   }

   private static final Unit createMergedSavedLocationsLiveData$lambda$10$lambda$9(MapsViewModel var0, MediatorLiveData var1, List var2) {
      Intrinsics.checkNotNull(var2);
      Iterator var4 = ((Iterable)var2).iterator();
      boolean var3 = false;

      while(var4.hasNext()) {
         Device var5 = (Device)var4.next();
         if (var5 instanceof HasLocation) {
            Object var7 = var0.deviceLocationMap.get(var5.getUid());
            HasLocation var6 = (HasLocation)var5;
            if (!Intrinsics.areEqual(var7, var6.getLocationId())) {
               var0.deviceLocationMap.put(var5.getUid(), var6.getLocationId());
               var3 = true;
            }
         }
      }

      if (var3) {
         createMergedSavedLocationsLiveData$lambda$10$mergeData(var0, var1);
      }

      return Unit.INSTANCE;
   }

   private static final void createMergedSavedLocationsLiveData$lambda$10$mergeData(MapsViewModel var0, MediatorLiveData var1) {
      List var2 = (List)(new ArrayList());
      List var3 = (List)var0.devices.getValue();
      List var5 = (List)var0.trackedLocations.getValue();
      if (var5 != null) {
         List var4 = (List)var0.pollutants.getValue();
         if (var4 != null) {
            for(TrackedLocation var14 : var5) {
               Iterator var7 = ((Iterable)var4).iterator();

               do {
                  if (!var7.hasNext()) {
                     var11 = null;
                     break;
                  }

                  var11 = var7.next();
               } while(!Intrinsics.areEqual(((AqiData)var11).getLocationId(), var14.getId()));

               AqiData var15 = (AqiData)var11;
               if (var15 != null) {
                  List var13;
                  if (var3 == null) {
                     var13 = CollectionsKt.emptyList();
                  } else {
                     Iterable var8 = (Iterable)var3;
                     Collection var12 = (Collection)(new ArrayList());

                     for(Object var9 : var8) {
                        Device var10 = (Device)var9;
                        if (var10 instanceof HasLocation && Intrinsics.areEqual(((HasLocation)var10).getLocationId(), var14.getId())) {
                           var12.add(var9);
                        }
                     }

                     var13 = (List)var12;
                  }

                  var2.add(new LocationItem(var14, var15, var13));
               }
            }
         }
      }

      var1.setValue(var2);
   }

   private final AuthService getAuthService() {
      return (AuthService)this.authService$delegate.getValue();
   }

   private final OutdoorService getOutdoorService() {
      return (OutdoorService)this.outdoorService$delegate.getValue();
   }

   // $FF: synthetic method
   public static void insertTrackedLocation$default(MapsViewModel var0, TrackedLocation var1, AqiData var2, boolean var3, Function1 var4, int var5, Object var6) {
      if ((var5 & 8) != 0) {
         var4 = null;
      }

      var0.insertTrackedLocation(var1, var2, var3, var4);
   }

   private final void viewLocation(TrackedLocation var1) {
      this.viewLocation.setValue(var1);
      this.currentlyViewedLocation = var1;
   }

   public final TrackedLocation createEmptyLocation(double var1, double var3, String var5) {
      return new TrackedLocation("", var1, var3, (String)null, (String)null, (String)null, (String)null, (String)null, var5);
   }

   public final void deleteLocation(TrackedLocation var1) {
      Intrinsics.checkNotNullParameter(var1, "trackedLocation");
      BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(this, var1, (Continuation)null) {
         final TrackedLocation $trackedLocation;
         int label;
         final MapsViewModel this$0;

         {
            this.this$0 = var1;
            this.$trackedLocation = var2;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.this$0, this.$trackedLocation, var2));
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
               OutdoorService var5 = this.this$0.getOutdoorService();
               TrackedLocation var4 = this.$trackedLocation;
               Continuation var6 = (Continuation)this;
               this.label = 1;
               if (var5.deleteTrackedLocation(var4, var6) == var3) {
                  return var3;
               }
            }

            return Unit.INSTANCE;
         }
      }, 2, (Object)null);
   }

   public final void fetchAirQuality(double var1, double var3, String var5) {
      BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(this, var1, var3, var5, (Continuation)null) {
         final double $lat;
         final double $lng;
         final String $mapType;
         Object L$0;
         int label;
         final MapsViewModel this$0;

         {
            this.this$0 = var1;
            this.$lat = var2;
            this.$lng = var4;
            this.$mapType = var6;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.this$0, this.$lat, this.$lng, this.$mapType, var2));
         }

         public final Object invoke(CoroutineScope var1, Continuation var2) {
            return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
         }

         public final Object invokeSuspend(Object var1) {
            Object var8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int var6 = this.label;
            if (var6 != 0) {
               if (var6 != 1) {
                  if (var6 != 2) {
                     throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                  }

                  Pair var7 = (Pair)this.L$0;
                  ResultKt.throwOnFailure(var1);
                  return Unit.INSTANCE;
               }

               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               OutdoorService var9 = this.this$0.getOutdoorService();
               double var4 = this.$lat;
               double var2 = this.$lng;
               String var13 = this.$mapType;
               Continuation var11 = (Continuation)this;
               this.label = 1;
               Object var14 = var9.fetchTrackedLocationWithAqiData(var4, var2, var13, var11);
               var1 = var14;
               if (var14 == var8) {
                  return var8;
               }
            }

            Pair var15 = (Pair)var1;
            CoroutineContext var10 = (CoroutineContext)Dispatchers.getMain();
            Function2 var12 = new Function2(this.this$0, var15, (Continuation)null) {
               final Pair $pair;
               int label;
               final MapsViewModel this$0;

               {
                  this.this$0 = var1;
                  this.$pair = var2;
               }

               public final Continuation create(Object var1, Continuation var2) {
                  return (Continuation)(new <anonymous constructor>(this.this$0, this.$pair, var2));
               }

               public final Object invoke(CoroutineScope var1, Continuation var2) {
                  return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
               }

               public final Object invokeSuspend(Object var1) {
                  IntrinsicsKt.getCOROUTINE_SUSPENDED();
                  if (this.label == 0) {
                     ResultKt.throwOnFailure(var1);
                     this.this$0.getAddLocationModel().setValue(this.$pair);
                     return Unit.INSTANCE;
                  } else {
                     throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                  }
               }
            };
            Continuation var16 = (Continuation)this;
            this.L$0 = SpillingKt.nullOutSpilledVariable(var15);
            this.label = 2;
            if (BuildersKt.withContext(var10, var12, var16) == var8) {
               return var8;
            } else {
               return Unit.INSTANCE;
            }
         }
      }, 2, (Object)null);
   }

   public final MutableLiveData getAddLocationModel() {
      return this.addLocationModel;
   }

   public final LiveData getAllLocations() {
      return this.allLocations;
   }

   public final LiveData getCurrentLocation() {
      return this.currentLocation;
   }

   public final MediatorLiveData getCurrentLocationWithPollutants() {
      return this.currentLocationWithPollutants;
   }

   public final TrackedLocation getCurrentlyViewedLocation() {
      return this.currentlyViewedLocation;
   }

   public final LiveData getDevices() {
      return this.devices;
   }

   public final boolean getMapIsReady() {
      return this.mapIsReady;
   }

   public final Map getMarkers() {
      return this.markers;
   }

   public final MutableLiveData getMode() {
      return this.mode;
   }

   public final MapMode getMode() {
      return (MapMode)this.mode.getValue();
   }

   public final MutableLiveData getSavedLocationViewIndex() {
      return this.savedLocationViewIndex;
   }

   public final MediatorLiveData getTrackedLocationWithPollutants() {
      return this.trackedLocationWithPollutants;
   }

   public final LiveData getTrackedLocations() {
      return this.trackedLocations;
   }

   public final MutableLiveData getViewLocation() {
      return this.viewLocation;
   }

   public final void insertTrackedLocation(TrackedLocation var1, AqiData var2, boolean var3, Function1 var4) {
      Intrinsics.checkNotNullParameter(var1, "trackedLocation");
      Intrinsics.checkNotNullParameter(var2, "pollutant");
      BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(this, var1, var2, var3, var4, (Continuation)null) {
         final Function1 $completion;
         final boolean $isUpdate;
         final AqiData $pollutant;
         final TrackedLocation $trackedLocation;
         Object L$0;
         int label;
         final MapsViewModel this$0;

         {
            this.this$0 = var1;
            this.$trackedLocation = var2;
            this.$pollutant = var3;
            this.$isUpdate = var4;
            this.$completion = var5;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.this$0, this.$trackedLocation, this.$pollutant, this.$isUpdate, this.$completion, var2));
         }

         public final Object invoke(CoroutineScope var1, Continuation var2) {
            return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
         }

         public final Object invokeSuspend(Object var1) {
            Object var5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int var2 = this.label;
            if (var2 != 0) {
               if (var2 != 1) {
                  if (var2 != 2) {
                     throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                  }

                  ApiResult var4 = (ApiResult)this.L$0;
                  ResultKt.throwOnFailure(var1);
                  return Unit.INSTANCE;
               }

               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               OutdoorService var10 = this.this$0.getOutdoorService();
               TrackedLocation var6 = this.$trackedLocation;
               var1 = this.$pollutant;
               boolean var3 = this.$isUpdate;
               Continuation var7 = (Continuation)this;
               this.label = 1;
               Object var11 = var10.insertTrackedLocation(var6, var1, var3, var7);
               var1 = (AqiData)var11;
               if (var11 == var5) {
                  return var5;
               }
            }

            ApiResult var9 = (ApiResult)var1;
            CoroutineContext var13 = (CoroutineContext)Dispatchers.getMain();
            Function2 var12 = new Function2(this.$completion, var9, (Continuation)null) {
               final Function1 $completion;
               final ApiResult $result;
               int label;

               {
                  this.$completion = var1;
                  this.$result = var2;
               }

               public final Continuation create(Object var1, Continuation var2) {
                  return (Continuation)(new <anonymous constructor>(this.$completion, this.$result, var2));
               }

               public final Object invoke(CoroutineScope var1, Continuation var2) {
                  return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
               }

               public final Object invokeSuspend(Object var1) {
                  IntrinsicsKt.getCOROUTINE_SUSPENDED();
                  if (this.label == 0) {
                     ResultKt.throwOnFailure(var1);
                     Function1 var2 = this.$completion;
                     if (var2 != null) {
                        var2.invoke(this.$result);
                     }

                     return Unit.INSTANCE;
                  } else {
                     throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                  }
               }
            };
            Continuation var14 = (Continuation)this;
            this.L$0 = SpillingKt.nullOutSpilledVariable(var9);
            this.label = 2;
            if (BuildersKt.withContext(var13, var12, var14) == var5) {
               return var5;
            } else {
               return Unit.INSTANCE;
            }
         }
      }, 2, (Object)null);
   }

   public final boolean isUserLoggedIn() {
      return (Boolean)this.getAuthService().isUserLoggedIn().getValue();
   }

   public final Object queryLocationDevices(String var1, Continuation var2) {
      return this.getDeviceManager().getLocationDevices(var1, var2);
   }

   public final void setAddLocationModel(MutableLiveData var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.addLocationModel = var1;
   }

   public final void setAddMode() {
      this.mode.setValue(MapsViewModel.MapMode.ADD_LOCATION);
   }

   public final void setCurrentlyViewedLocation(double var1, double var3, String var5) {
      this.currentlyViewedLocation = this.createEmptyLocation(var1, var3, var5);
   }

   public final void setCurrentlyViewedLocation(TrackedLocation var1) {
      this.currentlyViewedLocation = var1;
   }

   public final Object setLocationDevices(String var1, List var2, List var3, Continuation var4) {
      return this.getDeviceManager().setupDeviceLocation(var1, var2, var3, var4);
   }

   public final void setMapIsReady(boolean var1) {
      this.mapIsReady = var1;
   }

   public final void setMarkers(Map var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.markers = var1;
   }

   public final void setMinimizedMode() {
      this.mode.setValue(MapsViewModel.MapMode.MINIMIZED);
   }

   public final void setMode(MutableLiveData var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.mode = var1;
   }

   public final void setNormalMode() {
      this.mode.setValue(MapsViewModel.MapMode.SAVED_LOCATIONS);
   }

   public final void setViewLocation(MutableLiveData var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.viewLocation = var1;
   }

   public final void viewLocation(double var1, double var3, String var5) {
      this.viewLocation(this.createEmptyLocation(var1, var3, var5));
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"},
      d2 = {"Lcom/blueair/outdoor/ui/viewmodels/MapsViewModel$MapMode;", "", "<init>", "(Ljava/lang/String;I)V", "INITIAL", "SAVED_LOCATIONS", "ADD_LOCATION", "MINIMIZED", "outdoor_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static enum MapMode {
      private static final EnumEntries $ENTRIES;
      private static final MapMode[] $VALUES;
      ADD_LOCATION,
      INITIAL,
      MINIMIZED,
      SAVED_LOCATIONS;

      // $FF: synthetic method
      private static final MapMode[] $values() {
         return new MapMode[]{INITIAL, SAVED_LOCATIONS, ADD_LOCATION, MINIMIZED};
      }

      static {
         MapMode[] var0 = $values();
         $VALUES = var0;
         $ENTRIES = EnumEntriesKt.enumEntries(var0);
      }

      public static EnumEntries getEntries() {
         return $ENTRIES;
      }
   }
}
