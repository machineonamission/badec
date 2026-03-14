package com.blueair.android.fragment;

import android.content.Context;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.util.TypedValueCompat;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.android.BlueairApp$$ExternalSyntheticApiModelOutline0;
import com.blueair.android.adapter.AddLocationItem;
import com.blueair.android.adapter.OutdoorLocationItem;
import com.blueair.android.databinding.FragmentOutdoorBinding;
import com.blueair.android.util.SimpleScrollingPagerIndicator;
import com.blueair.android.viewmodel.OutdoorViewModel;
import com.blueair.auth.LocationService;
import com.blueair.core.model.AnalyticEvent;
import com.blueair.core.model.AqiData;
import com.blueair.core.model.TrackedLocation;
import com.blueair.core.util.LocationPermissionTracker;
import com.blueair.core.util.LocationUtils;
import com.blueair.viewcore.R;
import com.blueair.viewcore.activity.Actions;
import com.blueair.viewcore.dialog.DialogUtils;
import com.blueair.viewcore.fragment.BaseFragment;
import com.blueair.viewcore.utils.SimpleSpacingDecoration;
import com.blueair.viewcore.view.ScrollingPageIndicatorAccessibilityDelegate;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.IAdapter;
import com.mikepenz.fastadapter.IItemAdapter;
import com.mikepenz.fastadapter.adapters.ItemAdapter;
import com.mikepenz.fastadapter.binding.AbstractBindingItem;
import io.flatcircle.livedatahelper.LiveDataExtensionsKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.kodein.di.DIAware;
import org.kodein.di.DIAwareKt;
import org.kodein.type.GenericJVMTypeTokenDelegate;
import org.kodein.type.JVMTypeToken;
import org.kodein.type.TypeReference;
import org.kodein.type.TypeToken;
import org.kodein.type.TypeTokensJVMKt;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u0000 N2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002NOB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J$\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\u001a\u00101\u001a\u0002022\u0006\u00103\u001a\u00020*2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\b\u00104\u001a\u000202H\u0002J\f\u00105\u001a\u000202*\u00020\u0000H\u0002J\b\u00106\u001a\u000202H\u0002J\u0016\u00107\u001a\u0002022\f\u00108\u001a\b\u0012\u0004\u0012\u00020:09H\u0002J\u0010\u0010;\u001a\u0002022\u0006\u0010<\u001a\u00020:H\u0002J\b\u0010=\u001a\u000202H\u0016J\u0012\u0010>\u001a\u0002022\b\b\u0002\u0010?\u001a\u00020@H\u0002J\u0010\u0010A\u001a\u0002022\u0006\u0010B\u001a\u00020CH\u0003J\b\u0010D\u001a\u000202H\u0003J\u0010\u0010E\u001a\u0002022\u0006\u0010F\u001a\u00020GH\u0002J&\u0010H\u001a\u0002022\f\u0010I\u001a\b\u0012\u0004\u0012\u00020\r0\u000f2\u0006\u0010J\u001a\u00020K2\u0006\u0010F\u001a\u00020GH\u0002J\u0010\u0010L\u001a\u0002022\u0006\u0010M\u001a\u00020@H\u0016R\u001a\u0010\u0005\u001a\u00020\u0002X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R!\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R!\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0014\u001a\u0004\b\u0017\u0010\u0012R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0014\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010\u001e\u001a\u00020\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u0014\u001a\u0004\b \u0010!R#\u0010#\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010%0$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010\u0014\u001a\u0004\b&\u0010'¨\u0006P"},
   d2 = {"Lcom/blueair/android/fragment/OutdoorFragment;", "Lcom/blueair/viewcore/fragment/BaseFragment;", "Lcom/blueair/android/viewmodel/OutdoorViewModel;", "<init>", "()V", "viewModel", "getViewModel", "()Lcom/blueair/android/viewmodel/OutdoorViewModel;", "setViewModel", "(Lcom/blueair/android/viewmodel/OutdoorViewModel;)V", "viewDataBinding", "Lcom/blueair/android/databinding/FragmentOutdoorBinding;", "curLocationItem", "Lcom/blueair/android/adapter/OutdoorLocationItem;", "userLocationAdapter", "Lcom/mikepenz/fastadapter/adapters/ItemAdapter;", "currentLocationAdapter", "getCurrentLocationAdapter", "()Lcom/mikepenz/fastadapter/adapters/ItemAdapter;", "currentLocationAdapter$delegate", "Lkotlin/Lazy;", "addLocationAdapter", "Lcom/blueair/android/adapter/AddLocationItem;", "getAddLocationAdapter", "addLocationAdapter$delegate", "locationPermissionTracker", "Lcom/blueair/core/util/LocationPermissionTracker;", "getLocationPermissionTracker", "()Lcom/blueair/core/util/LocationPermissionTracker;", "locationPermissionTracker$delegate", "locationListener", "Lcom/blueair/android/fragment/OutdoorFragment$CurrentLocationListener;", "getLocationListener", "()Lcom/blueair/android/fragment/OutdoorFragment$CurrentLocationListener;", "locationListener$delegate", "aqiDataObserver", "Landroidx/lifecycle/Observer;", "Lcom/blueair/core/model/AqiData;", "getAqiDataObserver", "()Landroidx/lifecycle/Observer;", "aqiDataObserver$delegate", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "setupRecyclerView", "enableLocation", "observeViewModel", "observeAqiForUserLocation", "userLocations", "", "Lcom/blueair/core/model/TrackedLocation;", "observeAqiWithLocation", "trackedLocation", "onResume", "handleCurLocation", "forceTrack", "", "startLocationTracking", "context", "Landroid/content/Context;", "stopLocationTracking", "notifyCurLocationItemChange", "payload", "", "notifyLocationItemChange", "itemAdapter", "position", "", "showProgress", "shouldShowProgress", "Companion", "CurrentLocationListener", "app_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class OutdoorFragment extends BaseFragment {
   static final KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property1((PropertyReference1)(new PropertyReference1Impl(OutdoorFragment.class, "locationPermissionTracker", "getLocationPermissionTracker()Lcom/blueair/core/util/LocationPermissionTracker;", 0)))};
   public static final int $stable = 8;
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   public static final int REQUEST_LOCATION_SERVICE = 10102;
   private final Lazy addLocationAdapter$delegate = LazyKt.lazy(new OutdoorFragment$$ExternalSyntheticLambda10());
   private final Lazy aqiDataObserver$delegate;
   private final OutdoorLocationItem curLocationItem = new OutdoorLocationItem((TrackedLocation)null, (AqiData)null, true, 3, (DefaultConstructorMarker)null);
   private final Lazy currentLocationAdapter$delegate = LazyKt.lazy(new OutdoorFragment$$ExternalSyntheticLambda9(this));
   private final Lazy locationListener$delegate;
   private final Lazy locationPermissionTracker$delegate;
   private final ItemAdapter userLocationAdapter = new ItemAdapter();
   private FragmentOutdoorBinding viewDataBinding;
   public OutdoorViewModel viewModel;

   // $FF: synthetic method
   public static void $r8$lambda$64rkdbCuTKKBXr7xDt7YYsMrWpY(int var0, ItemAdapter var1, String var2) {
      notifyLocationItemChange$lambda$22(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$6XLeOGzfj6rnrEcCGsZeWSvbQQA(OutdoorFragment var0, AqiData var1) {
      aqiDataObserver_delegate$lambda$7$lambda$6(var0, var1);
   }

   // $FF: synthetic method
   public static int $r8$lambda$F8Ad13ggdVCMQEck0f3rRj2IEdc(OutdoorFragment var0) {
      return onViewCreated$lambda$11(var0);
   }

   // $FF: synthetic method
   public static ItemAdapter $r8$lambda$GNlOIFP7MhB_k6RKswvRt0ULfaU/* $FF was: $r8$lambda$GNlOIFP7MhB-k6RKswvRt0ULfaU*/(OutdoorFragment var0) {
      return currentLocationAdapter_delegate$lambda$1(var0);
   }

   // $FF: synthetic method
   public static boolean $r8$lambda$HHb1f70f7r0hPVVAjmqS5eM8mDk(OutdoorFragment var0, View var1, IAdapter var2, AbstractBindingItem var3, int var4) {
      return setupRecyclerView$lambda$12(var0, var1, var2, var3, var4);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$N7BSA8HSVKd8_uZuiqfXQwbJRmo/* $FF was: $r8$lambda$N7BSA8HSVKd8-uZuiqfXQwbJRmo*/() {
      return enableLocation$lambda$13();
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$TgNVPaB834Qy2ScWwSJaLA6x_KI(OutdoorFragment var0, TrackedLocation var1) {
      return observeViewModel$lambda$16(var0, var1);
   }

   // $FF: synthetic method
   public static ItemAdapter $r8$lambda$eeMRsQYS6B2LLw6p3FQ7fUq0BpI() {
      return addLocationAdapter_delegate$lambda$3();
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$fv8KRiuiHJEIrJGSQyZTZBZ3O_I/* $FF was: $r8$lambda$fv8KRiuiHJEIrJGSQyZTZBZ3O-I*/(OutdoorFragment var0, Location var1) {
      return observeViewModel$lambda$17(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$l_cbzoodg2TJjk2zEBASCRPZCWk/* $FF was: $r8$lambda$l-cbzoodg2TJjk2zEBASCRPZCWk*/(OutdoorFragment var0, List var1) {
      return observeViewModel$lambda$15(var0, var1);
   }

   // $FF: synthetic method
   public static int $r8$lambda$ur41PzwEzWnKTbWAsCzCUVmGHyw(SimpleScrollingPagerIndicator var0) {
      return onViewCreated$lambda$10(var0);
   }

   // $FF: synthetic method
   public static CurrentLocationListener $r8$lambda$xffHUOH10RvGc0O8Zh0J1ToBKV0() {
      return locationListener_delegate$lambda$4();
   }

   // $FF: synthetic method
   public static Observer $r8$lambda$xnfOzvzNjGXzqfl9gQaOy4a_YyI/* $FF was: $r8$lambda$xnfOzvzNjGXzqfl9gQaOy4a-YyI*/(OutdoorFragment var0) {
      return aqiDataObserver_delegate$lambda$7(var0);
   }

   public OutdoorFragment() {
      DIAware var2 = this;
      JVMTypeToken var1 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var1, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      this.locationPermissionTracker$delegate = DIAwareKt.Instance(var2, (TypeToken)(new GenericJVMTypeTokenDelegate(var1, LocationPermissionTracker.class)), (Object)null).provideDelegate(this, $$delegatedProperties[0]);
      this.locationListener$delegate = LazyKt.lazy(new OutdoorFragment$$ExternalSyntheticLambda11());
      this.aqiDataObserver$delegate = LazyKt.lazy(new OutdoorFragment$$ExternalSyntheticLambda12(this));
   }

   private static final ItemAdapter addLocationAdapter_delegate$lambda$3() {
      ItemAdapter var0 = new ItemAdapter();
      var0.add(new AddLocationItem[]{AddLocationItem.INSTANCE});
      return var0;
   }

   private static final Observer aqiDataObserver_delegate$lambda$7(OutdoorFragment var0) {
      return new OutdoorFragment$$ExternalSyntheticLambda3(var0);
   }

   private static final void aqiDataObserver_delegate$lambda$7$lambda$6(OutdoorFragment var0, AqiData var1) {
      if (var1 != null) {
         String var5 = var1.getLocationId();
         if (Intrinsics.areEqual(var5, "current")) {
            var0.curLocationItem.setAqiData(var1);
            var0.notifyCurLocationItemChange("payload_aqidata");
            return;
         }

         Iterator var4 = var0.userLocationAdapter.getAdapterItems().iterator();

         int var2;
         label32: {
            for(var2 = 0; var4.hasNext(); ++var2) {
               TrackedLocation var3 = ((OutdoorLocationItem)var4.next()).getTrackedLocation();
               String var6;
               if (var3 != null) {
                  var6 = var3.getId();
               } else {
                  var6 = null;
               }

               if (Intrinsics.areEqual(var6, var5)) {
                  break label32;
               }
            }

            var2 = -1;
         }

         if (var2 > -1) {
            ((OutdoorLocationItem)var0.userLocationAdapter.getAdapterItem(var2)).setAqiData(var1);
            var0.notifyLocationItemChange(var0.userLocationAdapter, var2, "payload_aqidata");
         }
      }

   }

   private static final ItemAdapter currentLocationAdapter_delegate$lambda$1(OutdoorFragment var0) {
      ItemAdapter var1 = new ItemAdapter();
      var1.add(new OutdoorLocationItem[]{var0.curLocationItem});
      return var1;
   }

   private final void enableLocation(OutdoorFragment var1) {
      LocationUtils var2 = LocationUtils.INSTANCE;
      Context var3 = var1.requireContext();
      Intrinsics.checkNotNullExpressionValue(var3, "requireContext(...)");
      if (!var2.isLocationPermissionGranted(var3)) {
         var1.getLocationPermissionTracker().requestLocationPermission(var1, new OutdoorFragment$$ExternalSyntheticLambda4());
      } else {
         var1.startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), 10102);
      }

      var1.getViewModel().trackEvent(new AnalyticEvent.ENABLE_GPS_LOCATION());
   }

   private static final Unit enableLocation$lambda$13() {
      DialogUtils.INSTANCE.showRequestPermissionHint(R.string.permission_request_title_location_outdoor, R.string.permission_request_message_location_outdoor);
      return Unit.INSTANCE;
   }

   private final ItemAdapter getAddLocationAdapter() {
      return (ItemAdapter)this.addLocationAdapter$delegate.getValue();
   }

   private final Observer getAqiDataObserver() {
      return (Observer)this.aqiDataObserver$delegate.getValue();
   }

   private final ItemAdapter getCurrentLocationAdapter() {
      return (ItemAdapter)this.currentLocationAdapter$delegate.getValue();
   }

   private final CurrentLocationListener getLocationListener() {
      return (CurrentLocationListener)this.locationListener$delegate.getValue();
   }

   private final LocationPermissionTracker getLocationPermissionTracker() {
      return (LocationPermissionTracker)this.locationPermissionTracker$delegate.getValue();
   }

   private final void handleCurLocation(boolean var1) {
      Context var2 = this.getContext();
      if (var2 != null) {
         if (this.curLocationItem.isLocationEnable(var2)) {
            if (this.curLocationItem.getTrackedLocation() == null || var1) {
               this.startLocationTracking(var2);
            }
         } else {
            this.getViewModel().clearCurrentLocation();
         }
      }

      this.notifyCurLocationItemChange("payload_tracked_location");
   }

   // $FF: synthetic method
   static void handleCurLocation$default(OutdoorFragment var0, boolean var1, int var2, Object var3) {
      if ((var2 & 1) != 0) {
         var1 = false;
      }

      var0.handleCurLocation(var1);
   }

   private static final CurrentLocationListener locationListener_delegate$lambda$4() {
      return new CurrentLocationListener();
   }

   private final void notifyCurLocationItemChange(String var1) {
      this.notifyLocationItemChange(this.getCurrentLocationAdapter(), 0, var1);
   }

   private final void notifyLocationItemChange(ItemAdapter var1, int var2, String var3) {
      FragmentOutdoorBinding var6 = this.viewDataBinding;
      Object var5 = null;
      FragmentOutdoorBinding var4 = var6;
      if (var6 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var4 = null;
      }

      if (var4.rvLocation.isComputingLayout()) {
         var4 = this.viewDataBinding;
         if (var4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            var4 = (FragmentOutdoorBinding)var5;
         }

         var4.rvLocation.post(new OutdoorFragment$$ExternalSyntheticLambda5(var2, var1, var3));
      } else {
         notifyLocationItemChange$notifyItemChangeReal(var2, var1, var3);
      }
   }

   private static final void notifyLocationItemChange$lambda$22(int var0, ItemAdapter var1, String var2) {
      notifyLocationItemChange$notifyItemChangeReal(var0, var1, var2);
   }

   private static final void notifyLocationItemChange$notifyItemChangeReal(int var0, ItemAdapter var1, String var2) {
      if (var0 >= 0 && var0 < var1.getAdapterItemCount()) {
         FastAdapter var3 = var1.getFastAdapter();
         if (var3 != null) {
            var3.notifyItemChanged(var1.getGlobalPosition(var0), var2);
         }
      }

   }

   private final void observeAqiForUserLocation(List var1) {
      Iterable var6 = (Iterable)var1;
      Collection var3 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var6, 10)));
      Iterator var2 = var6.iterator();

      while(var2.hasNext()) {
         var3.add(((TrackedLocation)var2.next()).getId());
      }

      Set var5 = CollectionsKt.toSet((Iterable)((List)var3));
      Iterator var9 = ((Map)this.getViewModel().getAqiDataMap()).entrySet().iterator();

      while(var9.hasNext()) {
         Map.Entry var4 = (Map.Entry)var9.next();
         String var8 = (String)var4.getKey();
         if (!var5.contains(var8) && !Intrinsics.areEqual(var8, "current")) {
            ((LiveData)var4.getValue()).removeObserver(this.getAqiDataObserver());
            var9.remove();
         }
      }

      Iterator var7 = var6.iterator();

      while(var7.hasNext()) {
         this.observeAqiWithLocation((TrackedLocation)var7.next());
      }

   }

   private final void observeAqiWithLocation(TrackedLocation var1) {
      String var4 = var1.getId();
      LiveData var3 = (LiveData)this.getViewModel().getAqiDataMap().get(var4);
      LiveData var2 = var3;
      if (var3 == null) {
         var2 = this.getViewModel().liveAqiData(var1);
         ((Map)this.getViewModel().getAqiDataMap()).put(var4, var2);
      }

      if (!var2.hasObservers()) {
         var2.observe(this.getViewLifecycleOwner(), this.getAqiDataObserver());
      }

   }

   private final void observeViewModel() {
      this.getViewModel().getLiveUserLocations().observe(this.getViewLifecycleOwner(), new Observer(new OutdoorFragment$$ExternalSyntheticLambda13(this)) {
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
      this.getViewModel().getLiveCurrentLocation().observe(this.getViewLifecycleOwner(), new Observer(new OutdoorFragment$$ExternalSyntheticLambda1(this)) {
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
      LiveData var2 = this.getLocationListener().getLiveLocation();
      LifecycleOwner var1 = this.getViewLifecycleOwner();
      Intrinsics.checkNotNullExpressionValue(var1, "getViewLifecycleOwner(...)");
      LiveDataExtensionsKt.observeNonNull(var2, var1, new OutdoorFragment$$ExternalSyntheticLambda2(this));
   }

   private static final Unit observeViewModel$lambda$15(OutdoorFragment var0, List var1) {
      List var2 = var1;
      if (var1 == null) {
         var2 = CollectionsKt.emptyList();
      }

      IItemAdapter var3 = (IItemAdapter)var0.userLocationAdapter;
      Iterable var4 = (Iterable)var2;
      Collection var5 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var4, 10)));
      Iterator var6 = var4.iterator();

      while(var6.hasNext()) {
         var5.add(new OutdoorLocationItem((TrackedLocation)var6.next(), (AqiData)null, false, 6, (DefaultConstructorMarker)null));
      }

      com.mikepenz.fastadapter.IItemAdapter.DefaultImpls.setNewList$default(var3, (List)var5, false, 2, (Object)null);
      var0.observeAqiForUserLocation(var2);
      return Unit.INSTANCE;
   }

   private static final Unit observeViewModel$lambda$16(OutdoorFragment var0, TrackedLocation var1) {
      var0.curLocationItem.setTrackedLocation(var1);
      var0.notifyCurLocationItemChange("payload_tracked_location");
      if (var1 == null) {
         LiveData var2 = (LiveData)var0.getViewModel().getAqiDataMap().remove("current");
         if (var2 != null) {
            var2.removeObserver(var0.getAqiDataObserver());
         }
      } else {
         var0.observeAqiWithLocation(var1);
         var0.getViewModel().refreshAqiData(var1);
      }

      return Unit.INSTANCE;
   }

   private static final Unit observeViewModel$lambda$17(OutdoorFragment var0, Location var1) {
      Intrinsics.checkNotNullParameter(var1, "loc");
      var0.getViewModel().setCurrentLocation(var1.getLatitude(), var1.getLongitude());
      var0.stopLocationTracking();
      return Unit.INSTANCE;
   }

   private static final int onViewCreated$lambda$10(SimpleScrollingPagerIndicator var0) {
      return var0.getCurrentPostion() + 1;
   }

   private static final int onViewCreated$lambda$11(OutdoorFragment var0) {
      FragmentOutdoorBinding var1 = var0.viewDataBinding;
      FragmentOutdoorBinding var2 = var1;
      if (var1 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var2 = null;
      }

      RecyclerView.Adapter var3 = var2.rvLocation.getAdapter();
      return var3 != null ? var3.getItemCount() : 0;
   }

   private final void setupRecyclerView() {
      FastAdapter var5 = FastAdapter.Companion.with((Collection)CollectionsKt.listOf(new ItemAdapter[]{this.getCurrentLocationAdapter(), this.userLocationAdapter, this.getAddLocationAdapter()}));
      var5.setOnClickListener(new OutdoorFragment$$ExternalSyntheticLambda8(this));
      FragmentOutdoorBinding var4 = this.viewDataBinding;
      Object var3 = null;
      FragmentOutdoorBinding var2 = var4;
      if (var4 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var2 = null;
      }

      var2.rvLocation.setAdapter((RecyclerView.Adapter)var5);
      float var1 = TypedValueCompat.dpToPx(8.0F, this.getResources().getDisplayMetrics());
      var4 = this.viewDataBinding;
      var2 = var4;
      if (var4 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var2 = null;
      }

      var2.rvLocation.addItemDecoration(new SimpleSpacingDecoration((int)var1, 0, false, 4, (DefaultConstructorMarker)null));
      var2 = this.viewDataBinding;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var2 = (FragmentOutdoorBinding)var3;
      }

      var2.rvLocation.addOnScrollListener(new RecyclerView.OnScrollListener(this) {
         private int cacheFirstCompletelyVisiblePos;
         final OutdoorFragment this$0;

         {
            this.this$0 = var1;
         }

         public final int getCacheFirstCompletelyVisiblePos() {
            return this.cacheFirstCompletelyVisiblePos;
         }

         public void onScrollStateChanged(RecyclerView var1, int var2) {
            Intrinsics.checkNotNullParameter(var1, "recyclerView");
            super.onScrollStateChanged(var1, var2);
            if (var2 == 0) {
               RecyclerView.LayoutManager var6 = var1.getLayoutManager();
               boolean var3 = var6 instanceof LinearLayoutManager;
               Object var4 = null;
               LinearLayoutManager var7;
               if (var3) {
                  var7 = (LinearLayoutManager)var6;
               } else {
                  var7 = null;
               }

               if (var7 != null) {
                  OutdoorFragment var5 = this.this$0;
                  var2 = var7.findFirstCompletelyVisibleItemPosition();
                  if (var2 != this.cacheFirstCompletelyVisiblePos && var2 == 0) {
                     OutdoorFragment.handleCurLocation$default(var5, false, 1, (Object)null);
                  }

                  this.cacheFirstCompletelyVisiblePos = var2;
                  var2 = var7.findLastCompletelyVisibleItemPosition();
                  if (var2 == var7.getItemCount() - 1) {
                     FragmentOutdoorBinding var8 = var5.viewDataBinding;
                     if (var8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
                        var8 = (FragmentOutdoorBinding)var4;
                     }

                     var8.pageDots.setCurrentPosition(var2);
                  }
               }
            }

         }

         public final void setCacheFirstCompletelyVisiblePos(int var1) {
            this.cacheFirstCompletelyVisiblePos = var1;
         }
      });
   }

   private static final boolean setupRecyclerView$lambda$12(OutdoorFragment var0, View var1, IAdapter var2, AbstractBindingItem var3, int var4) {
      Intrinsics.checkNotNullParameter(var2, "<unused var>");
      Intrinsics.checkNotNullParameter(var3, "item");
      if (var3 instanceof OutdoorLocationItem) {
         var3 = var3;
         if (var3.getUseCurrentLocation()) {
            Context var8 = var0.requireContext();
            Intrinsics.checkNotNullExpressionValue(var8, "requireContext(...)");
            if (!var3.isLocationEnable(var8)) {
               var0.enableLocation(var0);
               return true;
            }
         }

         Actions var5;
         Context var6;
         LocationService.MapType var7;
         label19: {
            var5 = Actions.INSTANCE;
            FragmentActivity var9 = var0.requireActivity();
            Intrinsics.checkNotNullExpressionValue(var9, "requireActivity(...)");
            var6 = (Context)var9;
            var7 = var0.getViewModel().getMapType();
            TrackedLocation var10 = var3.getTrackedLocation();
            if (var10 != null) {
               String var13 = var10.getId();
               var11 = var13;
               if (var13 != null) {
                  break label19;
               }
            }

            var11 = "";
         }

         var0.startActivity(Actions.openMapIntent$default(var5, var6, var7, var11, false, var3.getUseCurrentLocation(), (String)null, 40, (Object)null));
      } else if (var3 instanceof AddLocationItem) {
         Actions var14 = Actions.INSTANCE;
         Context var12 = var0.requireContext();
         Intrinsics.checkNotNullExpressionValue(var12, "requireContext(...)");
         var0.startActivity(Actions.openMapIntent$default(var14, var12, var0.getViewModel().getMapType(), (String)null, true, false, (String)null, 52, (Object)null));
      }

      return true;
   }

   private final void startLocationTracking(Context var1) {
      this.getLocationListener().start(false);
      this.notifyCurLocationItemChange("payload_progress");
      Criteria var2 = new Criteria();
      var2.setAccuracy(2);
      Object var3 = var1.getSystemService("location");
      Intrinsics.checkNotNull(var3, "null cannot be cast to non-null type android.location.LocationManager");
      LocationManager var4 = (LocationManager)var3;
      if (VERSION.SDK_INT >= 31) {
         String var5 = var4.getBestProvider(var2, true);
         if (var5 != null) {
            var4.requestLocationUpdates(var5, 1000L, 10.0F, this.getLocationListener(), (Looper)null);
         }
      } else {
         var4.requestLocationUpdates(1000L, 10.0F, var2, this.getLocationListener(), (Looper)null);
      }
   }

   private final void stopLocationTracking() {
      this.getLocationListener().stop();

      try {
         Object var1 = this.requireContext().getSystemService("location");
         Intrinsics.checkNotNull(var1, "null cannot be cast to non-null type android.location.LocationManager");
         ((LocationManager)var1).removeUpdates(this.getLocationListener());
      } catch (Throwable var3) {
         Timber.Forest.d(var3, "stopLocationTracking fail", new Object[0]);
         return;
      }
   }

   public OutdoorViewModel getViewModel() {
      OutdoorViewModel var1 = this.viewModel;
      if (var1 != null) {
         return var1;
      } else {
         Intrinsics.throwUninitializedPropertyAccessException("viewModel");
         return null;
      }
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      Intrinsics.checkNotNullParameter(var1, "inflater");
      FragmentOutdoorBinding var14 = FragmentOutdoorBinding.inflate(var1, var2, false);
      Intrinsics.checkNotNullExpressionValue(var14, "inflate(...)");
      FragmentActivity var6 = ((BaseFragment)this).requireActivity();
      Intrinsics.checkNotNullExpressionValue(var6, "requireActivity(...)");
      var14.setOutdoorViewModel((OutdoorViewModel)((BaseViewModel)(new ViewModelProvider((ViewModelStoreOwner)var6)).get(OutdoorViewModel.class)));
      var14.setLifecycleOwner((LifecycleOwner)this);
      this.viewDataBinding = var14;
      Timber.Forest var5 = Timber.Forest;
      StringBuilder var4 = new StringBuilder("onCreateView: viewDataBinding = ");
      FragmentOutdoorBinding var16 = this.viewDataBinding;
      Object var15 = null;
      FragmentOutdoorBinding var7 = var16;
      if (var16 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var7 = null;
      }

      var4.append(var7);
      var4.append(", root = ");
      var16 = this.viewDataBinding;
      var7 = var16;
      if (var16 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var7 = null;
      }

      var4.append(var7.getRoot());
      var4.append(", outdoorViewModel = ");
      var16 = this.viewDataBinding;
      var7 = var16;
      if (var16 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var7 = null;
      }

      var4.append(var7.getOutdoorViewModel());
      var5.d(var4.toString(), new Object[0]);
      var16 = this.viewDataBinding;
      var7 = var16;
      if (var16 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var7 = null;
      }

      OutdoorViewModel var11 = var7.getOutdoorViewModel();
      if (var11 != null) {
         this.setViewModel(var11);
         FragmentOutdoorBinding var12 = this.viewDataBinding;
         if (var12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            var12 = (FragmentOutdoorBinding)var15;
         }

         View var13 = var12.getRoot();
         Intrinsics.checkNotNullExpressionValue(var13, "getRoot(...)");
         return var13;
      } else {
         throw new IllegalStateException("Required value was null.".toString());
      }
   }

   public void onResume() {
      super.onResume();
      this.getViewModel().refreshTrackedLocationList(this.getHasBeenPaused());
      this.handleCurLocation(true);
      TrackedLocation var1 = this.curLocationItem.getTrackedLocation();
      if (var1 != null) {
         this.getViewModel().refreshAqiData(var1);
      }

   }

   public void onViewCreated(View var1, Bundle var2) {
      Intrinsics.checkNotNullParameter(var1, "view");
      super.onViewCreated(var1, var2);
      this.setupRecyclerView();
      FragmentOutdoorBinding var3 = this.viewDataBinding;
      Object var6 = null;
      FragmentOutdoorBinding var4 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var4 = null;
      }

      SimpleScrollingPagerIndicator var7 = var4.pageDots;
      var4 = this.viewDataBinding;
      if (var4 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var4 = (FragmentOutdoorBinding)var6;
      }

      var7.attachToRecyclerView(var4.rvLocation);
      var7.setFocusable(true);
      var7.setFocusableInTouchMode(false);
      if (VERSION.SDK_INT > 27) {
         BlueairApp$$ExternalSyntheticApiModelOutline0.m(var7, true);
      }

      Intrinsics.checkNotNullExpressionValue(var7, "apply(...)");
      ViewCompat.setAccessibilityDelegate((View)var7, new ScrollingPageIndicatorAccessibilityDelegate(new OutdoorFragment$$ExternalSyntheticLambda6(var7), new OutdoorFragment$$ExternalSyntheticLambda7(this)));
      this.observeViewModel();
   }

   public void setViewModel(OutdoorViewModel var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.viewModel = var1;
   }

   public void showProgress(boolean var1) {
   }

   @Metadata(
      d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"},
      d2 = {"Lcom/blueair/android/fragment/OutdoorFragment$Companion;", "", "<init>", "()V", "REQUEST_LOCATION_SERVICE", "", "app_otherRelease"},
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
      d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0005J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\bH\u0016J$\u0010\u0015\u001a\u00020\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0017J\u0010\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u0017H\u0016J\u0010\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\n8F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\f¨\u0006\u001f"},
      d2 = {"Lcom/blueair/android/fragment/OutdoorFragment$CurrentLocationListener;", "Landroid/location/LocationListener;", "<init>", "()V", "stopped", "", "_liveLocation", "Landroidx/lifecycle/MutableLiveData;", "Landroid/location/Location;", "liveLocation", "Landroidx/lifecycle/LiveData;", "getLiveLocation", "()Landroidx/lifecycle/LiveData;", "_showLoading", "stop", "", "start", "showLoading", "getShowLoading", "onLocationChanged", "loc", "onStatusChanged", "p0", "", "p1", "", "p2", "Landroid/os/Bundle;", "onProviderEnabled", "provider", "onProviderDisabled", "app_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class CurrentLocationListener implements LocationListener {
      public static final int $stable = 8;
      private final MutableLiveData _liveLocation = new MutableLiveData();
      private final MutableLiveData _showLoading = new MutableLiveData(false);
      private volatile boolean stopped;

      public final LiveData getLiveLocation() {
         return (LiveData)this._liveLocation;
      }

      public final LiveData getShowLoading() {
         return (LiveData)this._showLoading;
      }

      public void onLocationChanged(Location var1) {
         Intrinsics.checkNotNullParameter(var1, "loc");
         if (!this.stopped) {
            this._liveLocation.postValue(var1);
         }

      }

      public void onProviderDisabled(String var1) {
         Intrinsics.checkNotNullParameter(var1, "p0");
      }

      public void onProviderEnabled(String var1) {
         Intrinsics.checkNotNullParameter(var1, "provider");
         Timber.Forest var3 = Timber.Forest;
         StringBuilder var2 = new StringBuilder("onProviderEnabled: provider = ");
         var2.append(var1);
         var3.d(var2.toString(), new Object[0]);
      }

      @Deprecated(
         message = "Deprecated in Java"
      )
      public void onStatusChanged(String var1, int var2, Bundle var3) {
      }

      public final void start(boolean var1) {
         this.stopped = false;
         if (var1) {
            this._showLoading.postValue(true);
         }

      }

      public final void stop() {
         this.stopped = true;
         this._showLoading.postValue(false);
      }
   }
}
