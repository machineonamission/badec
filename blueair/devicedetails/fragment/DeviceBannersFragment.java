package com.blueair.devicedetails.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.os.BundleKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.Device;
import com.blueair.devicedetails.adapter.DeviceBannerAdapter;
import com.blueair.devicedetails.databinding.FragmentDeviceBannersBinding;
import com.blueair.devicedetails.viewmodel.DeviceDetailsState;
import com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel;
import com.blueair.viewcore.fragment.BaseFragment;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J$\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\u0002X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001d"},
   d2 = {"Lcom/blueair/devicedetails/fragment/DeviceBannersFragment;", "Lcom/blueair/viewcore/fragment/BaseFragment;", "Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;", "<init>", "()V", "binding", "Lcom/blueair/devicedetails/databinding/FragmentDeviceBannersBinding;", "device", "Lcom/blueair/core/model/Device;", "adapter", "Lcom/blueair/devicedetails/adapter/DeviceBannerAdapter;", "viewModel", "getViewModel", "()Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;", "setViewModel", "(Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;)V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "showProgress", "", "shouldShowProgress", "", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceBannersFragment extends BaseFragment {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   public static final String TAG = "DeviceBannersFragment";
   private final DeviceBannerAdapter adapter = new DeviceBannerAdapter();
   private FragmentDeviceBannersBinding binding;
   private Device device;
   public DeviceDetailsViewModel viewModel;

   // $FF: synthetic method
   public static Unit $r8$lambda$aPbfy5LzvwPPcWrx40NHPJ1UAmM(DeviceBannersFragment var0, DeviceDetailsState var1) {
      return onCreateView$lambda$0(var0, var1);
   }

   private static final Unit onCreateView$lambda$0(DeviceBannersFragment var0, DeviceDetailsState var1) {
      var0.adapter.setDevice(var1.getDevice());
      return Unit.INSTANCE;
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
      BaseFragment var13 = this;
      var13 = this.requireParentFragment();
      Intrinsics.checkNotNullExpressionValue(var13, "requireParentFragment(...)");
      this.setViewModel((DeviceDetailsViewModel)((BaseViewModel)(new ViewModelProvider((ViewModelStoreOwner)var13)).get(DeviceDetailsViewModel.class)));
      Bundle var15 = this.getArguments();
      Object var4 = null;
      Device var16;
      if (var15 != null) {
         var16 = (Device)var15.getParcelable("device");
      } else {
         var16 = null;
      }

      if (var16 != null) {
         this.device = var16;
         FragmentDeviceBannersBinding var10 = FragmentDeviceBannersBinding.inflate(var1, var2, false);
         Intrinsics.checkNotNullExpressionValue(var10, "inflate(...)");
         this.binding = var10;
         FragmentDeviceBannersBinding var5 = var10;
         if (var10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var5 = null;
         }

         var5.bannerList.setLayoutManager((RecyclerView.LayoutManager)(new LinearLayoutManager(this.requireContext())));
         this.adapter.setViewModel(this.getViewModel());
         DeviceBannerAdapter var17 = this.adapter;
         Device var11 = this.device;
         Device var6 = var11;
         if (var11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("device");
            var6 = null;
         }

         var17.setDevice(var6);
         FragmentDeviceBannersBinding var12 = this.binding;
         FragmentDeviceBannersBinding var7 = var12;
         if (var12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var7 = null;
         }

         var7.bannerList.setAdapter(this.adapter);
         this.getViewModel().getDeviceDetailsState().observe((LifecycleOwner)this, new Observer(new DeviceBannersFragment$$ExternalSyntheticLambda0(this)) {
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
         var7 = this.binding;
         if (var7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var7 = (FragmentDeviceBannersBinding)var4;
         }

         FrameLayout var9 = var7.getRoot();
         Intrinsics.checkNotNullExpressionValue(var9, "getRoot(...)");
         return (View)var9;
      } else {
         throw new IllegalStateException("Required value was null.".toString());
      }
   }

   public void setViewModel(DeviceDetailsViewModel var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.viewModel = var1;
   }

   public void showProgress(boolean var1) {
   }

   @Metadata(
      d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"},
      d2 = {"Lcom/blueair/devicedetails/fragment/DeviceBannersFragment$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Lcom/blueair/devicedetails/fragment/DeviceBannersFragment;", "device", "Lcom/blueair/core/model/Device;", "devicedetails_otherRelease"},
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

      public final DeviceBannersFragment newInstance(Device var1) {
         Intrinsics.checkNotNullParameter(var1, "device");
         DeviceBannersFragment var2 = new DeviceBannersFragment();
         var2.setArguments(BundleKt.bundleOf(new Pair[]{TuplesKt.to("device", var1)}));
         return var2;
      }
   }
}
