package com.blueair.devicedetails.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.blueair.auth.LocationService;
import com.blueair.core.model.Device;
import com.blueair.core.model.Filter;
import com.blueair.devicedetails.databinding.FragmentFilterBinding;
import com.blueair.devicedetails.dialog.FilterSelectionDialogFragment;
import com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel;
import com.blueair.viewcore.fragment.BaseFragment;
import com.blueair.viewcore.utils.FilterUtils;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
   d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 +2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001+B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J&\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010&\u001a\u00020'H\u0016J\u0010\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020*H\u0016R\u001a\u0010\u0005\u001a\u00020\u0002X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001a\u0010\u001b¨\u0006,"},
   d2 = {"Lcom/blueair/devicedetails/fragment/FilterFragment;", "Lcom/blueair/viewcore/fragment/BaseFragment;", "Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;", "<init>", "()V", "viewModel", "getViewModel", "()Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;", "setViewModel", "(Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;)V", "viewDataBinding", "Lcom/blueair/devicedetails/databinding/FragmentFilterBinding;", "filter", "Lcom/blueair/core/model/Filter;", "getFilter", "()Lcom/blueair/core/model/Filter;", "setFilter", "(Lcom/blueair/core/model/Filter;)V", "device", "Lcom/blueair/core/model/Device;", "getDevice", "()Lcom/blueair/core/model/Device;", "setDevice", "(Lcom/blueair/core/model/Device;)V", "locationService", "Lcom/blueair/auth/LocationService;", "getLocationService", "()Lcom/blueair/auth/LocationService;", "locationService$delegate", "Lkotlin/Lazy;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "", "showProgress", "shouldShowProgress", "", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class FilterFragment extends BaseFragment {
   static final KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property1((PropertyReference1)(new PropertyReference1Impl(FilterFragment.class, "locationService", "getLocationService()Lcom/blueair/auth/LocationService;", 0)))};
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   public static final String KEY_FILTER = "KEY_FILTER";
   private Device device;
   private Filter filter;
   private final Lazy locationService$delegate;
   private FragmentFilterBinding viewDataBinding;
   public DeviceDetailsViewModel viewModel;

   public FilterFragment() {
      DIAware var1 = this;
      JVMTypeToken var2 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var2, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      this.locationService$delegate = DIAwareKt.Instance(var1, (TypeToken)(new GenericJVMTypeTokenDelegate(var2, LocationService.class)), (Object)null).provideDelegate(this, $$delegatedProperties[0]);
   }

   private final LocationService getLocationService() {
      return (LocationService)this.locationService$delegate.getValue();
   }

   public final Device getDevice() {
      return this.device;
   }

   public final Filter getFilter() {
      return this.filter;
   }

   public DeviceDetailsViewModel getViewModel() {
      DeviceDetailsViewModel var1 = this.viewModel;
      if (var1 != null) {
         return var1;
      } else {
         Intrinsics.throwUninitializedPropertyAccessException("viewModel");
         return null;
      }
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      Intrinsics.checkNotNullParameter(var1, "inflater");
      Timber.Forest var10 = Timber.Forest;
      StringBuilder var4 = new StringBuilder("parent fragment: ");
      var4.append(this.getParentFragment());
      var10.d(var4.toString(), new Object[0]);
      Bundle var11 = this.getArguments();
      Object var5 = null;
      String var12;
      if (var11 != null) {
         var12 = var11.getString("KEY_FILTER");
      } else {
         var12 = null;
      }

      Bundle var14 = this.getArguments();
      Device var15;
      if (var14 != null) {
         var15 = (Device)var14.getParcelable("device");
      } else {
         var15 = null;
      }

      this.device = var15;
      Timber.Forest var16 = Timber.Forest;
      StringBuilder var6 = new StringBuilder("filterName : ");
      var6.append(var12);
      var16.d(var6.toString(), new Object[0]);
      if (var12 != null) {
         this.filter = Filter.Companion.fromName(var12);
      }

      FragmentFilterBinding var9 = FragmentFilterBinding.inflate(var1, var2, false);
      Intrinsics.checkNotNullExpressionValue(var9, "inflate(...)");
      this.setViewModel((DeviceDetailsViewModel)((BaseViewModel)(new ViewModelProvider((ViewModelStoreOwner)(this))).get(DeviceDetailsViewModel.class)));
      var9.setLifecycleOwner((LifecycleOwner)this);
      this.viewDataBinding = var9;
      Filter var13 = this.filter;
      if (var13 != null) {
         Device var17 = this.device;
         if (var17 != null) {
            FragmentFilterBinding var7 = var9;
            if (var9 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
               var7 = null;
            }

            var7.filterImage.setImageResource(FilterUtils.INSTANCE.legacyFilterImageRes(var17, var13, this.getLocationService().isInDualProtectionRegion()));
         }
      }

      FragmentFilterBinding var8 = this.viewDataBinding;
      if (var8 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var8 = (FragmentFilterBinding)var5;
      }

      return var8.getRoot();
   }

   public void onResume() {
      super.onResume();
      if (this.getParentFragment() instanceof FilterSelectionDialogFragment) {
         Filter var1 = this.filter;
         if (var1 != null) {
            Device var2 = this.device;
            if (var2 != null) {
               Fragment var3 = this.getParentFragment();
               Intrinsics.checkNotNull(var3, "null cannot be cast to non-null type com.blueair.devicedetails.dialog.FilterSelectionDialogFragment");
               TextView var5 = ((FilterSelectionDialogFragment)var3).getToolbarTitleView();
               FilterUtils var6 = FilterUtils.INSTANCE;
               Context var4 = this.requireContext();
               Intrinsics.checkNotNullExpressionValue(var4, "requireContext(...)");
               var5.setText((CharSequence)var6.legacyFilterName(var4, var2, var1, this.getLocationService().isInDualProtectionRegion()));
            }
         }
      }

   }

   public final void setDevice(Device var1) {
      this.device = var1;
   }

   public final void setFilter(Filter var1) {
      this.filter = var1;
   }

   public void setViewModel(DeviceDetailsViewModel var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.viewModel = var1;
   }

   public void showProgress(boolean var1) {
   }

   @Metadata(
      d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"},
      d2 = {"Lcom/blueair/devicedetails/fragment/FilterFragment$Companion;", "", "<init>", "()V", "KEY_FILTER", "", "newInstance", "Lcom/blueair/devicedetails/fragment/FilterFragment;", "device", "Lcom/blueair/core/model/Device;", "filter", "Lcom/blueair/core/model/Filter;", "devicedetails_otherRelease"},
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

      public final FilterFragment newInstance(Device var1, Filter var2) {
         Intrinsics.checkNotNullParameter(var2, "filter");
         Bundle var4 = new Bundle();
         FilterFragment var3 = new FilterFragment();
         var4.putString("KEY_FILTER", var2.getName());
         var4.putParcelable("device", var1);
         var3.setArguments(var4);
         return var3;
      }
   }
}
