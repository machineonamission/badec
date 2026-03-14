package com.blueair.devicedetails.fragment;

import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceScheduleMerged;
import com.blueair.core.model.HasBlueCloudFunctions;
import com.blueair.devicedetails.adapter.DeviceScheduleAdapter;
import com.blueair.devicedetails.databinding.FragmentDeviceSchedulesBinding;
import com.blueair.devicedetails.dialog.DeviceCreateEditScheduleDialogFragment;
import com.blueair.devicedetails.viewmodel.DeviceSchedulesViewModel;
import com.blueair.viewcore.fragment.BaseFragment;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import com.google.android.material.button.MaterialButton;
import java.util.Collection;
import java.util.List;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \"2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J$\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u001dH\u0002J\u0010\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020!H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\u0002X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006#"},
   d2 = {"Lcom/blueair/devicedetails/fragment/DeviceSchedulesFragment;", "Lcom/blueair/viewcore/fragment/BaseFragment;", "Lcom/blueair/devicedetails/viewmodel/DeviceSchedulesViewModel;", "<init>", "()V", "deviceSchedulesBinding", "Lcom/blueair/devicedetails/databinding/FragmentDeviceSchedulesBinding;", "viewModel", "getViewModel", "()Lcom/blueair/devicedetails/viewmodel/DeviceSchedulesViewModel;", "setViewModel", "(Lcom/blueair/devicedetails/viewmodel/DeviceSchedulesViewModel;)V", "scheduleAdapter", "Lcom/blueair/devicedetails/adapter/DeviceScheduleAdapter;", "device", "Lcom/blueair/core/model/Device;", "getDevice", "()Lcom/blueair/core/model/Device;", "setDevice", "(Lcom/blueair/core/model/Device;)V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "configure", "", "onAddClicked", "showProgress", "shouldShowProgress", "", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceSchedulesFragment extends BaseFragment {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   public Device device;
   private FragmentDeviceSchedulesBinding deviceSchedulesBinding;
   private DeviceScheduleAdapter scheduleAdapter;
   public DeviceSchedulesViewModel viewModel;

   // $FF: synthetic method
   public static Unit $r8$lambda$0M6iV8L787cIUT0j4NsJLee79t4(DeviceSchedulesFragment var0, DeviceScheduleMerged var1) {
      return configure$lambda$7$lambda$6(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$IpNmUsO49GNg67l0KPs_3G_5PZk/* $FF was: $r8$lambda$IpNmUsO49GNg67l0KPs-3G_5PZk*/(DeviceSchedulesFragment var0, boolean var1) {
      return configure$lambda$7$lambda$6$lambda$5$lambda$4$lambda$3(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$MicGRM6Zh6WVaqmgbro4m6PWlBc(DeviceSchedulesFragment var0, List var1) {
      return configure$lambda$8(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$YnHd1Csp8_fqKqNy7d2Usi4t46Q(DeviceSchedulesFragment var0) {
      return configure$lambda$7$lambda$2(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$vR5P0WIFxlzb_TQWJXQOYv9WgO4(DeviceSchedulesFragment var0, boolean var1) {
      return onAddClicked$lambda$11$lambda$10$lambda$9(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$xsze1cFl0FHG3DCccFSwrOIv5N4(DeviceSchedulesFragment var0, View var1) {
      configure$lambda$1(var0, var1);
   }

   private final void configure() {
      FragmentDeviceSchedulesBinding var3 = this.deviceSchedulesBinding;
      Object var2 = null;
      FragmentDeviceSchedulesBinding var1 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("deviceSchedulesBinding");
         var1 = null;
      }

      var1.addSchedule.setOnClickListener(new DeviceSchedulesFragment$$ExternalSyntheticLambda2(this));
      var1 = this.deviceSchedulesBinding;
      if (var1 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("deviceSchedulesBinding");
         var1 = (FragmentDeviceSchedulesBinding)var2;
      }

      RecyclerView var5 = var1.recyclerViewDeviceSchedules;
      DeviceScheduleAdapter var6 = new DeviceScheduleAdapter(this.getDevice() instanceof HasBlueCloudFunctions, DateFormat.is24HourFormat(this.requireContext()), this.getDevice(), new DeviceSchedulesFragment$$ExternalSyntheticLambda3(this), new DeviceSchedulesFragment$$ExternalSyntheticLambda4(this));
      this.scheduleAdapter = var6;
      var5.setAdapter(var6);
      var5.setLayoutManager((RecyclerView.LayoutManager)(new LinearLayoutManager(var5.getContext(), 1, false)));
      this.getViewModel().getSchedules().observe(this.getViewLifecycleOwner(), new Observer(new DeviceSchedulesFragment$$ExternalSyntheticLambda5(this)) {
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

   private static final void configure$lambda$1(DeviceSchedulesFragment var0, View var1) {
      var0.onAddClicked();
   }

   private static final Unit configure$lambda$7$lambda$2(DeviceSchedulesFragment var0) {
      var0.onAddClicked();
      return Unit.INSTANCE;
   }

   private static final Unit configure$lambda$7$lambda$6(DeviceSchedulesFragment var0, DeviceScheduleMerged var1) {
      Intrinsics.checkNotNullParameter(var1, "tappedSchedule");
      FragmentManager var2 = var0.getChildFragmentManager();
      Intrinsics.checkNotNullExpressionValue(var2, "getChildFragmentManager(...)");
      Intrinsics.checkNotNullExpressionValue("DeviceCreateEditScheduleDialogFragment", "getSimpleName(...)");
      if (!(var2.findFragmentByTag("DeviceCreateEditScheduleDialogFragment") instanceof DeviceCreateEditScheduleDialogFragment) && !var2.isStateSaved()) {
         DeviceCreateEditScheduleDialogFragment var3 = DeviceCreateEditScheduleDialogFragment.Companion.newInstance(var0.getDevice(), var1);
         var3.setOnDismiss(new DeviceSchedulesFragment$$ExternalSyntheticLambda0(var0));
         ((DialogFragment)var3).show(var2, "DeviceCreateEditScheduleDialogFragment");
      }

      return Unit.INSTANCE;
   }

   private static final Unit configure$lambda$7$lambda$6$lambda$5$lambda$4$lambda$3(DeviceSchedulesFragment var0, boolean var1) {
      var0.getViewModel().refreshDeviceSchedule(var1);
      return Unit.INSTANCE;
   }

   private static final Unit configure$lambda$8(DeviceSchedulesFragment var0, List var1) {
      FragmentDeviceSchedulesBinding var5 = var0.deviceSchedulesBinding;
      Object var4 = null;
      FragmentDeviceSchedulesBinding var3 = var5;
      if (var5 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("deviceSchedulesBinding");
         var3 = null;
      }

      MaterialButton var7 = var3.addSchedule;
      Intrinsics.checkNotNull(var1);
      byte var2;
      if (!((Collection)var1).isEmpty()) {
         var2 = 0;
      } else {
         var2 = 4;
      }

      var7.setVisibility(var2);
      DeviceScheduleAdapter var6 = var0.scheduleAdapter;
      if (var6 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("scheduleAdapter");
         var6 = (DeviceScheduleAdapter)var4;
      }

      var6.setItems(var1);
      return Unit.INSTANCE;
   }

   private final void onAddClicked() {
      FragmentManager var1 = this.getChildFragmentManager();
      Intrinsics.checkNotNullExpressionValue(var1, "getChildFragmentManager(...)");
      Intrinsics.checkNotNullExpressionValue("DeviceCreateEditScheduleDialogFragment", "getSimpleName(...)");
      if (!(var1.findFragmentByTag("DeviceCreateEditScheduleDialogFragment") instanceof DeviceCreateEditScheduleDialogFragment) && !var1.isStateSaved()) {
         DeviceCreateEditScheduleDialogFragment var2 = DeviceCreateEditScheduleDialogFragment.Companion.newInstance$default(DeviceCreateEditScheduleDialogFragment.Companion, this.getDevice(), (DeviceScheduleMerged)null, 2, (Object)null);
         var2.setOnDismiss(new DeviceSchedulesFragment$$ExternalSyntheticLambda1(this));
         ((DialogFragment)var2).show(var1, "DeviceCreateEditScheduleDialogFragment");
      }

   }

   private static final Unit onAddClicked$lambda$11$lambda$10$lambda$9(DeviceSchedulesFragment var0, boolean var1) {
      var0.getViewModel().refreshDeviceSchedule(var1);
      return Unit.INSTANCE;
   }

   public final Device getDevice() {
      Device var1 = this.device;
      if (var1 != null) {
         return var1;
      } else {
         Intrinsics.throwUninitializedPropertyAccessException("device");
         return null;
      }
   }

   public DeviceSchedulesViewModel getViewModel() {
      DeviceSchedulesViewModel var1 = this.viewModel;
      if (var1 != null) {
         return var1;
      } else {
         Intrinsics.throwUninitializedPropertyAccessException("viewModel");
         return null;
      }
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      Intrinsics.checkNotNullParameter(var1, "inflater");
      var3 = this.getArguments();
      Object var4 = null;
      Device var10;
      if (var3 != null) {
         var10 = (Device)var3.getParcelable("device");
      } else {
         var10 = null;
      }

      if (var10 != null) {
         this.setDevice(var10);
         FragmentDeviceSchedulesBinding var8 = FragmentDeviceSchedulesBinding.inflate(var1, var2, false);
         Intrinsics.checkNotNullExpressionValue(var8, "inflate(...)");
         FragmentActivity var5 = ((BaseFragment)this).requireActivity();
         Intrinsics.checkNotNullExpressionValue(var5, "requireActivity(...)");
         this.setViewModel((DeviceSchedulesViewModel)((BaseViewModel)(new ViewModelProvider((ViewModelStoreOwner)var5)).get(DeviceSchedulesViewModel.class)));
         var8.setDeviceSchedulesViewModel(this.getViewModel());
         this.deviceSchedulesBinding = var8;
         this.getViewModel().setDevice(this.getDevice());
         this.getViewModel().refreshDeviceSchedule(false);
         this.configure();
         FragmentDeviceSchedulesBinding var6 = this.deviceSchedulesBinding;
         if (var6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deviceSchedulesBinding");
            var6 = (FragmentDeviceSchedulesBinding)var4;
         }

         View var7 = var6.getRoot();
         Intrinsics.checkNotNullExpressionValue(var7, "getRoot(...)");
         return var7;
      } else {
         throw new IllegalStateException("Required value was null.".toString());
      }
   }

   public final void setDevice(Device var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.device = var1;
   }

   public void setViewModel(DeviceSchedulesViewModel var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.viewModel = var1;
   }

   public void showProgress(boolean var1) {
   }

   @Metadata(
      d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"},
      d2 = {"Lcom/blueair/devicedetails/fragment/DeviceSchedulesFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/fragment/DeviceSchedulesFragment;", "device", "Lcom/blueair/core/model/Device;", "devicedetails_otherRelease"},
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

      public final DeviceSchedulesFragment newInstance(Device var1) {
         Intrinsics.checkNotNullParameter(var1, "device");
         DeviceSchedulesFragment var2 = new DeviceSchedulesFragment();
         Bundle var3 = new Bundle();
         var3.putParcelable("device", var1);
         var2.setArguments(var3);
         return var2;
      }
   }
}
