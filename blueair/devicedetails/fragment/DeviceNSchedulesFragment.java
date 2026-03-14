package com.blueair.devicedetails.fragment;

import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.os.BundleKt;
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
import com.blueair.devicedetails.adapter.DeviceNScheduleAdapter;
import com.blueair.devicedetails.databinding.FragmentDeviceNSchedulesBinding;
import com.blueair.devicedetails.dialog.DeviceCreateEditScheduleDialogFragment;
import com.blueair.devicedetails.dialog.DeviceNCreateEditScheduleDialogFragment;
import com.blueair.devicedetails.viewmodel.DeviceSchedulesViewModel;
import com.blueair.viewcore.fragment.BaseFragment;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import java.util.List;
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
   d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u001b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J$\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001aH\u0016R\u001a\u0010\u0005\u001a\u00020\u0002X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001c"},
   d2 = {"Lcom/blueair/devicedetails/fragment/DeviceNSchedulesFragment;", "Lcom/blueair/viewcore/fragment/BaseFragment;", "Lcom/blueair/devicedetails/viewmodel/DeviceSchedulesViewModel;", "<init>", "()V", "viewModel", "getViewModel", "()Lcom/blueair/devicedetails/viewmodel/DeviceSchedulesViewModel;", "setViewModel", "(Lcom/blueair/devicedetails/viewmodel/DeviceSchedulesViewModel;)V", "binding", "Lcom/blueair/devicedetails/databinding/FragmentDeviceNSchedulesBinding;", "scheduleAdapter", "Lcom/blueair/devicedetails/adapter/DeviceNScheduleAdapter;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "configure", "", "showProgress", "shouldShowProgress", "", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceNSchedulesFragment extends BaseFragment {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private FragmentDeviceNSchedulesBinding binding;
   private DeviceNScheduleAdapter scheduleAdapter;
   public DeviceSchedulesViewModel viewModel;

   // $FF: synthetic method
   public static void $r8$lambda$8XWEtOaZqt5NlEKUyXpfAr8d2Rg(DeviceNSchedulesFragment var0, View var1) {
      configure$lambda$3(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$8j9_HMlySiqgsH7hi4IODI3g9EQ(DeviceNSchedulesFragment var0, List var1) {
      return configure$lambda$9(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$BI3kniTG6RkHX5laBZ4djHhL_Ic/* $FF was: $r8$lambda$BI3kniTG6RkHX5laBZ4djHhL-Ic*/(DeviceNSchedulesFragment var0, boolean var1) {
      return configure$lambda$3$lambda$2$lambda$1$lambda$0(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$PLuQhc4M51jdxSWIKyPXc18Fgrg(DeviceNSchedulesFragment var0, DeviceScheduleMerged var1, Device var2) {
      return configure$lambda$8$lambda$7$lambda$6(var0, var1, var2);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$WaPo9u91dtb25T7Z2N90t8BzmDk(DeviceNSchedulesFragment var0, DeviceScheduleMerged var1) {
      return configure$lambda$8$lambda$7(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$hHsvjLquRweFoCaauIsOVWRqRFM(DeviceNSchedulesFragment var0, Device var1) {
      return configure$lambda$3$lambda$2(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$zz2kd3iuZ03jeJbz7CtDr0ucqVo(DeviceNSchedulesFragment var0, boolean var1) {
      return configure$lambda$8$lambda$7$lambda$6$lambda$5$lambda$4(var0, var1);
   }

   private final void configure() {
      FragmentDeviceNSchedulesBinding var3 = this.binding;
      Object var2 = null;
      FragmentDeviceNSchedulesBinding var1 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var1 = null;
      }

      var1.addSchedule.setOnClickListener(new DeviceNSchedulesFragment$$ExternalSyntheticLambda1(this));
      var1 = this.binding;
      if (var1 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var1 = (FragmentDeviceNSchedulesBinding)var2;
      }

      RecyclerView var6 = var1.scheduleList;
      DeviceNScheduleAdapter var5 = new DeviceNScheduleAdapter(this.getViewModel().getDevice() instanceof HasBlueCloudFunctions, DateFormat.is24HourFormat(this.requireContext()), this.getViewModel().getDevice(), new DeviceNSchedulesFragment$$ExternalSyntheticLambda2(this));
      this.scheduleAdapter = var5;
      var6.setAdapter(var5);
      var6.setLayoutManager((RecyclerView.LayoutManager)(new LinearLayoutManager(var6.getContext(), 1, false)));
      this.getViewModel().getSchedules().observe(this.getViewLifecycleOwner(), new Observer(new DeviceNSchedulesFragment$$ExternalSyntheticLambda3(this)) {
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

   private static final void configure$lambda$3(DeviceNSchedulesFragment var0, View var1) {
      FragmentManager var2 = var0.getChildFragmentManager();
      Intrinsics.checkNotNullExpressionValue(var2, "getChildFragmentManager(...)");
      Intrinsics.checkNotNullExpressionValue("DeviceNCreateEditScheduleDialogFragment", "getSimpleName(...)");
      if (!(var2.findFragmentByTag("DeviceNCreateEditScheduleDialogFragment") instanceof DeviceNCreateEditScheduleDialogFragment)) {
         var0.getViewModel().getLatestDevice(new DeviceNSchedulesFragment$$ExternalSyntheticLambda4(var0));
      }

   }

   private static final Unit configure$lambda$3$lambda$2(DeviceNSchedulesFragment var0, Device var1) {
      Intrinsics.checkNotNullParameter(var1, "device");
      FragmentManager var2 = var0.getChildFragmentManager();
      Intrinsics.checkNotNullExpressionValue(var2, "getChildFragmentManager(...)");
      Intrinsics.checkNotNullExpressionValue("DeviceNCreateEditScheduleDialogFragment", "getSimpleName(...)");
      if (!(var2.findFragmentByTag("DeviceNCreateEditScheduleDialogFragment") instanceof DeviceNCreateEditScheduleDialogFragment) && !var2.isStateSaved()) {
         ((DialogFragment)DeviceNCreateEditScheduleDialogFragment.Companion.newInstance$default(DeviceNCreateEditScheduleDialogFragment.Companion, var1, (DeviceScheduleMerged)null, new DeviceNSchedulesFragment$$ExternalSyntheticLambda0(var0), 2, (Object)null)).show(var2, "DeviceNCreateEditScheduleDialogFragment");
      }

      return Unit.INSTANCE;
   }

   private static final Unit configure$lambda$3$lambda$2$lambda$1$lambda$0(DeviceNSchedulesFragment var0, boolean var1) {
      var0.getViewModel().refreshDeviceSchedule(var1);
      return Unit.INSTANCE;
   }

   private static final Unit configure$lambda$8$lambda$7(DeviceNSchedulesFragment var0, DeviceScheduleMerged var1) {
      Intrinsics.checkNotNullParameter(var1, "tappedSchedule");
      FragmentManager var2 = var0.getChildFragmentManager();
      Intrinsics.checkNotNullExpressionValue(var2, "getChildFragmentManager(...)");
      Intrinsics.checkNotNullExpressionValue("DeviceCreateEditScheduleDialogFragment", "getSimpleName(...)");
      if (!(var2.findFragmentByTag("DeviceCreateEditScheduleDialogFragment") instanceof DeviceCreateEditScheduleDialogFragment)) {
         var0.getViewModel().getLatestDevice(new DeviceNSchedulesFragment$$ExternalSyntheticLambda5(var0, var1));
      }

      return Unit.INSTANCE;
   }

   private static final Unit configure$lambda$8$lambda$7$lambda$6(DeviceNSchedulesFragment var0, DeviceScheduleMerged var1, Device var2) {
      Intrinsics.checkNotNullParameter(var2, "device");
      FragmentManager var3 = var0.getChildFragmentManager();
      Intrinsics.checkNotNullExpressionValue(var3, "getChildFragmentManager(...)");
      Intrinsics.checkNotNullExpressionValue("DeviceNCreateEditScheduleDialogFragment", "getSimpleName(...)");
      if (!(var3.findFragmentByTag("DeviceNCreateEditScheduleDialogFragment") instanceof DeviceNCreateEditScheduleDialogFragment) && !var3.isStateSaved()) {
         ((DialogFragment)DeviceNCreateEditScheduleDialogFragment.Companion.newInstance(var2, var1, new DeviceNSchedulesFragment$$ExternalSyntheticLambda6(var0))).show(var3, "DeviceNCreateEditScheduleDialogFragment");
      }

      return Unit.INSTANCE;
   }

   private static final Unit configure$lambda$8$lambda$7$lambda$6$lambda$5$lambda$4(DeviceNSchedulesFragment var0, boolean var1) {
      var0.getViewModel().refreshDeviceSchedule(var1);
      return Unit.INSTANCE;
   }

   private static final Unit configure$lambda$9(DeviceNSchedulesFragment var0, List var1) {
      DeviceNScheduleAdapter var2 = var0.scheduleAdapter;
      DeviceNScheduleAdapter var3 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("scheduleAdapter");
         var3 = null;
      }

      Intrinsics.checkNotNull(var1);
      var3.setItems(var1);
      return Unit.INSTANCE;
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

      if (!(var10 instanceof Device)) {
         var10 = null;
      }

      if (var10 != null) {
         FragmentActivity var5 = ((BaseFragment)this).requireActivity();
         Intrinsics.checkNotNullExpressionValue(var5, "requireActivity(...)");
         this.setViewModel((DeviceSchedulesViewModel)((BaseViewModel)(new ViewModelProvider((ViewModelStoreOwner)var5)).get(DeviceSchedulesViewModel.class)));
         this.getViewModel().setDevice(var10);
         this.getViewModel().refreshDeviceSchedule(false);
         FragmentDeviceNSchedulesBinding var6 = FragmentDeviceNSchedulesBinding.inflate(var1, var2, false);
         Intrinsics.checkNotNullExpressionValue(var6, "inflate(...)");
         this.binding = var6;
         this.configure();
         var6 = this.binding;
         if (var6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var6 = (FragmentDeviceNSchedulesBinding)var4;
         }

         FrameLayout var8 = var6.getRoot();
         Intrinsics.checkNotNullExpressionValue(var8, "getRoot(...)");
         return (View)var8;
      } else {
         throw new IllegalStateException("Required value was null.".toString());
      }
   }

   public void setViewModel(DeviceSchedulesViewModel var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.viewModel = var1;
   }

   public void showProgress(boolean var1) {
   }

   @Metadata(
      d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"},
      d2 = {"Lcom/blueair/devicedetails/fragment/DeviceNSchedulesFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/fragment/DeviceNSchedulesFragment;", "device", "Lcom/blueair/core/model/Device;", "devicedetails_otherRelease"},
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

      public final DeviceNSchedulesFragment newInstance(Device var1) {
         Intrinsics.checkNotNullParameter(var1, "device");
         DeviceNSchedulesFragment var2 = new DeviceNSchedulesFragment();
         var2.setArguments(BundleKt.bundleOf(new Pair[]{TuplesKt.to("device", var1)}));
         return var2;
      }
   }
}
