package com.blueair.devicedetails.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.HasWelcomeHome;
import com.blueair.core.model.WelcomeHomeLocation;
import com.blueair.devicedetails.activity.WelcomeHomeConfigActivity;
import com.blueair.devicedetails.databinding.FragmentDeviceHWelcomeHomeBinding;
import com.blueair.devicedetails.databinding.FragmentDeviceWelcomeHomeBinding;
import com.blueair.devicedetails.dialog.WelcomeHomePermissionsDialogFragment;
import com.blueair.devicedetails.util.WelcomeHomePermissionManager;
import com.blueair.devicedetails.viewmodel.DeviceWelcomeHomeViewModel;
import com.blueair.viewcore.ViewUtilsKt;
import com.blueair.viewcore.fragment.BaseFragment;
import com.blueair.viewcore.view.SwitchCompat;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import com.google.android.material.button.MaterialButton;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 .2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001.B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J$\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u001a\u0010&\u001a\u00020\u001b2\u0006\u0010'\u001a\u00020\u001f2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010(\u001a\u00020\u001bH\u0002J\b\u0010)\u001a\u00020\u001bH\u0002J\b\u0010*\u001a\u00020\u001bH\u0002J\b\u0010+\u001a\u00020\u001bH\u0002J\b\u0010,\u001a\u00020\u001bH\u0002J\b\u0010-\u001a\u00020\u001bH\u0002R\u001a\u0010\u0005\u001a\u00020\u0002X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/"},
   d2 = {"Lcom/blueair/devicedetails/fragment/DeviceWelcomeHomeFragment;", "Lcom/blueair/viewcore/fragment/BaseFragment;", "Lcom/blueair/devicedetails/viewmodel/DeviceWelcomeHomeViewModel;", "<init>", "()V", "viewModel", "getViewModel", "()Lcom/blueair/devicedetails/viewmodel/DeviceWelcomeHomeViewModel;", "setViewModel", "(Lcom/blueair/devicedetails/viewmodel/DeviceWelcomeHomeViewModel;)V", "btnAddHome", "Lcom/google/android/material/button/MaterialButton;", "welcomeHomeTitle", "Landroid/widget/TextView;", "welcomeHomeSwitch", "Lcom/blueair/viewcore/view/SwitchCompat;", "layoutAddress", "Landroidx/constraintlayout/widget/ConstraintLayout;", "device", "Lcom/blueair/core/model/Device;", "getDevice", "()Lcom/blueair/core/model/Device;", "setDevice", "(Lcom/blueair/core/model/Device;)V", "locationPermissionManager", "Lcom/blueair/devicedetails/util/WelcomeHomePermissionManager;", "showProgress", "", "shouldShowProgress", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "initViews", "initAddHomeBtn", "showWHPermissions", "initWelcomeHomeSwitch", "initAddressLayout", "openCreateUpdateWelcomeHome", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceWelcomeHomeFragment extends BaseFragment {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private MaterialButton btnAddHome;
   public Device device;
   private ConstraintLayout layoutAddress;
   private final WelcomeHomePermissionManager locationPermissionManager = new WelcomeHomePermissionManager(this);
   public DeviceWelcomeHomeViewModel viewModel;
   private SwitchCompat welcomeHomeSwitch;
   private TextView welcomeHomeTitle;

   // $FF: synthetic method
   public static Unit $r8$lambda$0cqCjDLK46oyZHUy7_pu_qeLRdw(DeviceWelcomeHomeFragment var0) {
      return initAddressLayout$lambda$12$lambda$11(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$8BNG0oeJmjBxvu3c92ZF0ZH2u7U(DeviceWelcomeHomeFragment var0, WelcomeHomeLocation var1) {
      return onViewCreated$lambda$2(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$GsYrenj1JpoiUWX7I8Zsdrd3_t8(DeviceWelcomeHomeFragment var0, View var1) {
      return initAddHomeBtn$lambda$4(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$LWRhDg6X1HNID02qBLFwvk9yDIM(DeviceWelcomeHomeFragment var0) {
      return initAddHomeBtn$lambda$4$lambda$3(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$Lh3jf8_g2V8VPNJkvocCf_aWh_A/* $FF was: $r8$lambda$Lh3jf8-g2V8VPNJkvocCf_aWh-A*/(DeviceWelcomeHomeFragment var0, View var1) {
      return initAddHomeBtn$lambda$5(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$MH3YGEhq2D5XVcYu4z_9ZAOpBPs(DeviceWelcomeHomeFragment var0, Boolean var1) {
      return initWelcomeHomeSwitch$lambda$7(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$ZvUepfdRfigAhdtGAZKe_wXM5c8/* $FF was: $r8$lambda$ZvUepfdRfigAhdtGAZKe-wXM5c8*/(DeviceWelcomeHomeFragment var0) {
      return initWelcomeHomeSwitch$lambda$10$lambda$9(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$rvAuUAQ_FRqF_X3BweodbSUUuD4/* $FF was: $r8$lambda$rvAuUAQ-FRqF_X3BweodbSUUuD4*/(DeviceWelcomeHomeFragment var0) {
      return initWelcomeHomeSwitch$lambda$10$lambda$8(var0);
   }

   // $FF: synthetic method
   public static void $r8$lambda$v6QrhXD_vVf8k83_zf433_YPU2E/* $FF was: $r8$lambda$v6QrhXD_vVf8k83-zf433-YPU2E*/(DeviceWelcomeHomeFragment var0, CompoundButton var1, boolean var2) {
      initWelcomeHomeSwitch$lambda$10(var0, var1, var2);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$vMj5wZkQRiROBLtz1tyWvrlhdZk(DeviceWelcomeHomeFragment var0, View var1) {
      return initAddressLayout$lambda$12(var0, var1);
   }

   private final void initAddHomeBtn() {
      MaterialButton var3 = this.btnAddHome;
      Object var2 = null;
      MaterialButton var1 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("btnAddHome");
         var1 = null;
      }

      ViewUtilsKt.setOnClickListener((View)var1, 2000L, new DeviceWelcomeHomeFragment$$ExternalSyntheticLambda3(this));
      TextView var4 = this.welcomeHomeTitle;
      if (var4 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("welcomeHomeTitle");
         var4 = (TextView)var2;
      }

      ViewUtilsKt.setOnClickListener((View)var4, 2000L, new DeviceWelcomeHomeFragment$$ExternalSyntheticLambda4(this));
   }

   private static final Unit initAddHomeBtn$lambda$4(DeviceWelcomeHomeFragment var0, View var1) {
      Intrinsics.checkNotNullParameter(var1, "it");
      WelcomeHomePermissionManager.checkAndRequest$default(var0.locationPermissionManager, (Function0)null, new DeviceWelcomeHomeFragment$$ExternalSyntheticLambda2(var0), 1, (Object)null);
      return Unit.INSTANCE;
   }

   private static final Unit initAddHomeBtn$lambda$4$lambda$3(DeviceWelcomeHomeFragment var0) {
      var0.openCreateUpdateWelcomeHome();
      return Unit.INSTANCE;
   }

   private static final Unit initAddHomeBtn$lambda$5(DeviceWelcomeHomeFragment var0, View var1) {
      Intrinsics.checkNotNullParameter(var1, "it");
      var0.showWHPermissions();
      return Unit.INSTANCE;
   }

   private final void initAddressLayout() {
      ConstraintLayout var2 = this.layoutAddress;
      ConstraintLayout var1 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("layoutAddress");
         var1 = null;
      }

      ViewUtilsKt.setOnClickListener((View)var1, 2000L, new DeviceWelcomeHomeFragment$$ExternalSyntheticLambda7(this));
   }

   private static final Unit initAddressLayout$lambda$12(DeviceWelcomeHomeFragment var0, View var1) {
      Intrinsics.checkNotNullParameter(var1, "it");
      WelcomeHomePermissionManager.checkAndRequest$default(var0.locationPermissionManager, (Function0)null, new DeviceWelcomeHomeFragment$$ExternalSyntheticLambda6(var0), 1, (Object)null);
      return Unit.INSTANCE;
   }

   private static final Unit initAddressLayout$lambda$12$lambda$11(DeviceWelcomeHomeFragment var0) {
      var0.openCreateUpdateWelcomeHome();
      return Unit.INSTANCE;
   }

   private final void initViews() {
      this.initAddHomeBtn();
      this.initWelcomeHomeSwitch();
      this.initAddressLayout();
   }

   private final void initWelcomeHomeSwitch() {
      this.getViewModel().getWelcomeHomeEnabled().observe(this.getViewLifecycleOwner(), new Observer(new DeviceWelcomeHomeFragment$$ExternalSyntheticLambda8(this)) {
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
      SwitchCompat var2 = this.welcomeHomeSwitch;
      SwitchCompat var1 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("welcomeHomeSwitch");
         var1 = null;
      }

      var1.setOnCheckedChangeListener(new DeviceWelcomeHomeFragment$$ExternalSyntheticLambda9(this));
   }

   private static final void initWelcomeHomeSwitch$lambda$10(DeviceWelcomeHomeFragment var0, CompoundButton var1, boolean var2) {
      if (var2) {
         var0.locationPermissionManager.checkAndRequest(new DeviceWelcomeHomeFragment$$ExternalSyntheticLambda0(var0), new DeviceWelcomeHomeFragment$$ExternalSyntheticLambda1(var0));
      } else {
         var0.getViewModel().setWelcomeHomeEnabled(false);
      }
   }

   private static final Unit initWelcomeHomeSwitch$lambda$10$lambda$8(DeviceWelcomeHomeFragment var0) {
      SwitchCompat var1 = var0.welcomeHomeSwitch;
      SwitchCompat var2 = var1;
      if (var1 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("welcomeHomeSwitch");
         var2 = null;
      }

      var2.setCheckedSilence(false);
      return Unit.INSTANCE;
   }

   private static final Unit initWelcomeHomeSwitch$lambda$10$lambda$9(DeviceWelcomeHomeFragment var0) {
      SwitchCompat var2 = var0.welcomeHomeSwitch;
      SwitchCompat var1 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("welcomeHomeSwitch");
         var1 = null;
      }

      var1.setCheckedSilence(true);
      var0.getViewModel().setWelcomeHomeEnabled(true);
      return Unit.INSTANCE;
   }

   private static final Unit initWelcomeHomeSwitch$lambda$7(DeviceWelcomeHomeFragment var0, Boolean var1) {
      SwitchCompat var2 = var0.welcomeHomeSwitch;
      SwitchCompat var3 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("welcomeHomeSwitch");
         var3 = null;
      }

      Intrinsics.checkNotNull(var1);
      var3.setCheckedSilence(var1);
      return Unit.INSTANCE;
   }

   private static final Unit onViewCreated$lambda$2(DeviceWelcomeHomeFragment var0, WelcomeHomeLocation var1) {
      var0.getViewModel().loadHomeLocation(var1);
      return Unit.INSTANCE;
   }

   private final void openCreateUpdateWelcomeHome() {
      Context var1 = this.getContext();
      if (var1 != null) {
         this.startActivity(WelcomeHomeConfigActivity.Companion.getLaunchIntent(var1, this.getViewModel().getDevice()));
      }

   }

   private final void showWHPermissions() {
      FragmentManager var1 = this.getChildFragmentManager();
      Intrinsics.checkNotNullExpressionValue(var1, "getChildFragmentManager(...)");
      Intrinsics.checkNotNullExpressionValue("WelcomeHomePermissionsDialogFragment", "getSimpleName(...)");
      if (!(var1.findFragmentByTag("WelcomeHomePermissionsDialogFragment") instanceof WelcomeHomePermissionsDialogFragment) && !var1.isStateSaved()) {
         ((DialogFragment)(new WelcomeHomePermissionsDialogFragment())).show(var1, "WelcomeHomePermissionsDialogFragment");
      }

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

   public DeviceWelcomeHomeViewModel getViewModel() {
      DeviceWelcomeHomeViewModel var1 = this.viewModel;
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
      Device var14;
      if (var3 != null) {
         var14 = (Device)var3.getParcelable("device");
      } else {
         var14 = null;
      }

      if (var14 != null) {
         this.setDevice(var14);
         this.setViewModel((DeviceWelcomeHomeViewModel)((BaseViewModel)(new ViewModelProvider((ViewModelStoreOwner)(this))).get(DeviceWelcomeHomeViewModel.class)));
         ViewDataBinding var5;
         if (DeviceKt.isAfterG4(this.getDevice())) {
            FragmentDeviceHWelcomeHomeBinding var4 = FragmentDeviceHWelcomeHomeBinding.inflate(var1, var2, false);
            var4.setVm(this.getViewModel());
            Intrinsics.checkNotNullExpressionValue(var4, "apply(...)");
            var5 = var4;
            FragmentDeviceHWelcomeHomeBinding var8 = (FragmentDeviceHWelcomeHomeBinding)var5;
            MaterialButton var15 = var8.btnAddHome;
            Intrinsics.checkNotNullExpressionValue(var15, "btnAddHome");
            this.btnAddHome = var15;
            TextView var16 = var8.welcomeHomeTitle;
            Intrinsics.checkNotNullExpressionValue(var16, "welcomeHomeTitle");
            this.welcomeHomeTitle = var16;
            SwitchCompat var17 = var8.welcomeHomeSwitch;
            Intrinsics.checkNotNullExpressionValue(var17, "welcomeHomeSwitch");
            this.welcomeHomeSwitch = var17;
            ConstraintLayout var9 = var8.layoutAddress;
            Intrinsics.checkNotNullExpressionValue(var9, "layoutAddress");
            this.layoutAddress = var9;
         } else {
            FragmentDeviceWelcomeHomeBinding var6 = FragmentDeviceWelcomeHomeBinding.inflate(var1, var2, false);
            var6.setVm(this.getViewModel());
            Intrinsics.checkNotNullExpressionValue(var6, "apply(...)");
            var5 = var6;
            FragmentDeviceWelcomeHomeBinding var10 = (FragmentDeviceWelcomeHomeBinding)var5;
            MaterialButton var18 = var10.btnAddHome;
            Intrinsics.checkNotNullExpressionValue(var18, "btnAddHome");
            this.btnAddHome = var18;
            TextView var19 = var10.welcomeHomeTitle;
            Intrinsics.checkNotNullExpressionValue(var19, "welcomeHomeTitle");
            this.welcomeHomeTitle = var19;
            SwitchCompat var20 = var10.welcomeHomeSwitch;
            Intrinsics.checkNotNullExpressionValue(var20, "welcomeHomeSwitch");
            this.welcomeHomeSwitch = var20;
            ConstraintLayout var11 = var10.layoutAddress;
            Intrinsics.checkNotNullExpressionValue(var11, "layoutAddress");
            this.layoutAddress = var11;
         }

         var5.setLifecycleOwner((LifecycleOwner)this);
         DeviceWelcomeHomeViewModel var21 = this.getViewModel();
         Device var12 = this.getDevice();
         Intrinsics.checkNotNull(var12, "null cannot be cast to non-null type com.blueair.core.model.HasWelcomeHome");
         var21.setDevice((HasWelcomeHome)var12);
         View var7 = var5.getRoot();
         Intrinsics.checkNotNullExpressionValue(var7, "getRoot(...)");
         return var7;
      } else {
         throw new IllegalStateException("Required value was null.".toString());
      }
   }

   public void onViewCreated(View var1, Bundle var2) {
      Intrinsics.checkNotNullParameter(var1, "view");
      super.onViewCreated(var1, var2);
      this.initViews();
      this.getViewModel().getLiveDeviceWelcomeHome(this.getDevice().getUid()).observe(this.getViewLifecycleOwner(), new Observer(new DeviceWelcomeHomeFragment$$ExternalSyntheticLambda5(this)) {
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

   public final void setDevice(Device var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.device = var1;
   }

   public void setViewModel(DeviceWelcomeHomeViewModel var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.viewModel = var1;
   }

   public void showProgress(boolean var1) {
   }

   @Metadata(
      d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"},
      d2 = {"Lcom/blueair/devicedetails/fragment/DeviceWelcomeHomeFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/fragment/DeviceWelcomeHomeFragment;", "device", "Lcom/blueair/core/model/Device;", "devicedetails_otherRelease"},
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

      public final DeviceWelcomeHomeFragment newInstance(Device var1) {
         Intrinsics.checkNotNullParameter(var1, "device");
         DeviceWelcomeHomeFragment var2 = new DeviceWelcomeHomeFragment();
         Bundle var3 = new Bundle();
         var3.putParcelable("device", var1);
         var2.setArguments(var3);
         return var2;
      }
   }
}
