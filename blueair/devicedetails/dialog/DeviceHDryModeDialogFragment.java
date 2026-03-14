package com.blueair.devicedetails.dialog;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceCombo2in1;
import com.blueair.core.model.HasWick;
import com.blueair.devicedetails.databinding.DialogfragmentDeviceHDryModeBinding;
import com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel;
import com.blueair.viewcore.R;
import com.blueair.viewcore.dialog.BaseDialogFragment;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u001d2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J$\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001cH\u0016R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0002X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001e"},
   d2 = {"Lcom/blueair/devicedetails/dialog/DeviceHDryModeDialogFragment;", "Lcom/blueair/viewcore/dialog/BaseDialogFragment;", "Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "viewModel", "getViewModel", "()Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;", "setViewModel", "(Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;)V", "binding", "Lcom/blueair/devicedetails/databinding/DialogfragmentDeviceHDryModeBinding;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "", "showProgress", "shouldShowProgress", "", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceHDryModeDialogFragment extends BaseDialogFragment {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private DialogfragmentDeviceHDryModeBinding binding;
   private final String screenName = "device_settings_dry_mode";
   public DeviceDetailsViewModel viewModel;

   // $FF: synthetic method
   public static void $r8$lambda$63uYnTC0Knb18QSBlZfZSRapQQk(DeviceHDryModeDialogFragment var0, CompoundButton var1, boolean var2) {
      onCreateView$lambda$4$lambda$3(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$b2W3_wFsFRsi0zuSzXI3a3lONWU(DeviceHDryModeDialogFragment var0, View var1) {
      onCreateView$lambda$4$lambda$1(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$x4BVVoiGQfzHr7hQrxKrf9Y_q98(DeviceHDryModeDialogFragment var0, Device var1) {
      return onCreateView$lambda$6(var0, var1);
   }

   private static final void onCreateView$lambda$4$lambda$1(DeviceHDryModeDialogFragment var0, View var1) {
      var0.dismiss();
   }

   private static final void onCreateView$lambda$4$lambda$3(DeviceHDryModeDialogFragment var0, CompoundButton var1, boolean var2) {
      Device var3 = var0.getViewModel().getDevice();
      if (var3 != null) {
         var0.getViewModel().wickDryEnabledChanged(var3);
      }

   }

   private static final Unit onCreateView$lambda$6(DeviceHDryModeDialogFragment var0, Device var1) {
      boolean var2 = var1 instanceof HasWick;
      Object var4 = null;
      HasWick var3;
      if (var2) {
         var3 = (HasWick)var1;
      } else {
         var3 = null;
      }

      if (var3 != null) {
         DialogfragmentDeviceHDryModeBinding var5 = var0.binding;
         if (var5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var5 = (DialogfragmentDeviceHDryModeBinding)var4;
         }

         var5.switchBtn.setCheckedSilence(((HasWick)var1).getWickdryEnabled());
      }

      return Unit.INSTANCE;
   }

   protected String getScreenName() {
      return this.screenName;
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
      this.setStyle(0, R.style.DialogTheme);
      Dialog var12 = this.getDialog();
      if (var12 != null) {
         Window var13 = var12.getWindow();
         if (var13 != null) {
            var13.setBackgroundDrawable((Drawable)(new ColorDrawable(0)));
            var13.setWindowAnimations(R.style.dialog_animation);
            var13.setGravity(80);
         }
      }

      DialogfragmentDeviceHDryModeBinding var14 = DialogfragmentDeviceHDryModeBinding.inflate(var1, var2, false);
      Intrinsics.checkNotNullExpressionValue(var14, "inflate(...)");
      this.binding = var14;
      Object var11 = null;
      DialogfragmentDeviceHDryModeBinding var5 = var14;
      if (var14 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var5 = null;
      }

      var5.contentBack.setOnClickListener(new DeviceHDryModeDialogFragment$$ExternalSyntheticLambda0(this));
      var5.switchBtn.setOnCheckedChangeListener(new DeviceHDryModeDialogFragment$$ExternalSyntheticLambda1(this));
      FragmentActivity var6 = ((BaseDialogFragment)this).requireActivity();
      Intrinsics.checkNotNullExpressionValue(var6, "requireActivity(...)");
      this.setViewModel((DeviceDetailsViewModel)((BaseViewModel)(new ViewModelProvider((ViewModelStoreOwner)var6)).get(DeviceDetailsViewModel.class)));
      this.getViewModel().getLiveDevice().observe((LifecycleOwner)this, new Observer(new DeviceHDryModeDialogFragment$$ExternalSyntheticLambda2(this)) {
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
      var14 = this.binding;
      DialogfragmentDeviceHDryModeBinding var7 = var14;
      if (var14 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var7 = null;
      }

      TextView var8 = var7.dryModeInfo;
      int var4;
      if (this.getViewModel().getDevice() instanceof DeviceCombo2in1) {
         var4 = R.string.dry_mode_description_2in1;
      } else {
         var4 = R.string.dry_mode_description;
      }

      var8.setText(var4);
      DialogfragmentDeviceHDryModeBinding var9 = this.binding;
      if (var9 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var9 = (DialogfragmentDeviceHDryModeBinding)var11;
      }

      FrameLayout var10 = var9.getRoot();
      Intrinsics.checkNotNullExpressionValue(var10, "getRoot(...)");
      return (View)var10;
   }

   public void onStart() {
      super.onStart();
      Dialog var1 = this.getDialog();
      if (var1 != null) {
         Window var2 = var1.getWindow();
         if (var2 != null) {
            var2.setLayout(-1, -1);
         }
      }

   }

   public void setViewModel(DeviceDetailsViewModel var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.viewModel = var1;
   }

   public void showProgress(boolean var1) {
   }

   @Metadata(
      d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"},
      d2 = {"Lcom/blueair/devicedetails/dialog/DeviceHDryModeDialogFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/dialog/DeviceHDryModeDialogFragment;", "devicedetails_otherRelease"},
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

      public final DeviceHDryModeDialogFragment newInstance() {
         return new DeviceHDryModeDialogFragment();
      }
   }
}
