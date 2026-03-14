package com.blueair.devicedetails.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceKt;
import com.blueair.devicedetails.databinding.DialogfragmentDeviceC3TemperatureBinding;
import com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel;
import com.blueair.viewcore.R;
import com.blueair.viewcore.dialog.BaseDialogFragment;
import com.blueair.viewcore.dialog.DialogUtils;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u001d2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J$\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0017J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001cH\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0094D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0002X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001e"},
   d2 = {"Lcom/blueair/devicedetails/dialog/DeviceC3TemperatureDialogFragment;", "Lcom/blueair/viewcore/dialog/BaseDialogFragment;", "Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "viewModel", "getViewModel", "()Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;", "setViewModel", "(Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;)V", "binding", "Lcom/blueair/devicedetails/databinding/DialogfragmentDeviceC3TemperatureBinding;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "", "showProgress", "shouldShowProgress", "", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceC3TemperatureDialogFragment extends BaseDialogFragment {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private DialogfragmentDeviceC3TemperatureBinding binding;
   private final String screenName = "device_settings_temperature";
   public DeviceDetailsViewModel viewModel;

   // $FF: synthetic method
   public static void $r8$lambda$FEdEdGn4tIf0DCtMsw_3rSLfeyE(DeviceC3TemperatureDialogFragment var0, View var1) {
      onCreateView$lambda$6$lambda$5(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$Lg8P6uOX0JypKV5SpN6lXqbTNgM(DeviceC3TemperatureDialogFragment var0, Device var1) {
      return onCreateView$lambda$8(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$YI_iKqsONFL5H0FSpvgWlVsxqwI(DeviceC3TemperatureDialogFragment var0, View var1) {
      onCreateView$lambda$6$lambda$3(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$aSYQVYH_gihoOo8wqbd86OMFGUs(DeviceC3TemperatureDialogFragment var0, View var1) {
      onCreateView$lambda$6$lambda$1(var0, var1);
   }

   private static final void onCreateView$lambda$6$lambda$1(DeviceC3TemperatureDialogFragment var0, View var1) {
      var0.dismiss();
   }

   private static final void onCreateView$lambda$6$lambda$3(DeviceC3TemperatureDialogFragment var0, View var1) {
      Device var2 = var0.getViewModel().getDevice();
      if (var2 != null && DeviceKt.isCelsiusUnit(var2)) {
         var0.getViewModel().temperatureUnitChanged(var2);
      }

   }

   private static final void onCreateView$lambda$6$lambda$5(DeviceC3TemperatureDialogFragment var0, View var1) {
      Device var2 = var0.getViewModel().getDevice();
      if (var2 != null && !DeviceKt.isCelsiusUnit(var2)) {
         var0.getViewModel().temperatureUnitChanged(var2);
      }

   }

   private static final Unit onCreateView$lambda$8(DeviceC3TemperatureDialogFragment var0, Device var1) {
      DialogfragmentDeviceC3TemperatureBinding var5 = var0.binding;
      DialogfragmentDeviceC3TemperatureBinding var6 = var5;
      if (var5 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var6 = null;
      }

      boolean var4 = DeviceKt.isCelsiusUnit(var1);
      AppCompatImageView var7 = var6.selectC;
      Intrinsics.checkNotNullExpressionValue(var7, "selectC");
      View var8 = (View)var7;
      byte var3 = 0;
      byte var2;
      if (var4) {
         var2 = 0;
      } else {
         var2 = 8;
      }

      var8.setVisibility(var2);
      AppCompatImageView var9 = var6.selectF;
      Intrinsics.checkNotNullExpressionValue(var9, "selectF");
      View var10 = (View)var9;
      if (!var4) {
         var2 = var3;
      } else {
         var2 = 8;
      }

      var10.setVisibility(var2);
      var6.titleTempC.setSelected(var4);
      var6.titleTempF.setSelected(var4 ^ true);
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
      DialogfragmentDeviceC3TemperatureBinding var7 = DialogfragmentDeviceC3TemperatureBinding.inflate(var1, var2, false);
      Intrinsics.checkNotNullExpressionValue(var7, "inflate(...)");
      this.binding = var7;
      this.setStyle(0, R.style.DialogTheme);
      Dialog var8 = this.getDialog();
      if (var8 != null) {
         Window var9 = var8.getWindow();
         if (var9 != null) {
            var9.setBackgroundDrawable((Drawable)(new ColorDrawable(0)));
            var9.setWindowAnimations(R.style.dialog_animation);
         }
      }

      FragmentActivity var10 = ((BaseDialogFragment)this).requireActivity();
      Intrinsics.checkNotNullExpressionValue(var10, "requireActivity(...)");
      this.setViewModel((DeviceDetailsViewModel)((BaseViewModel)(new ViewModelProvider((ViewModelStoreOwner)var10)).get(DeviceDetailsViewModel.class)));
      DialogfragmentDeviceC3TemperatureBinding var16 = this.binding;
      Object var15 = null;
      DialogfragmentDeviceC3TemperatureBinding var11 = var16;
      if (var16 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var11 = null;
      }

      var11.btnBack.setOnClickListener(new DeviceC3TemperatureDialogFragment$$ExternalSyntheticLambda0(this));
      var11.titleTempF.setOnClickListener(new DeviceC3TemperatureDialogFragment$$ExternalSyntheticLambda1(this));
      var11.titleTempC.setOnClickListener(new DeviceC3TemperatureDialogFragment$$ExternalSyntheticLambda2(this));
      Context var17 = var11.getRoot().getContext();
      CharSequence var4 = var17.getText(R.string.temperature_degree);
      Intrinsics.checkNotNullExpressionValue(var4, "getText(...)");
      TextView var5 = var11.titleTempF;
      StringBuilder var6 = new StringBuilder();
      var6.append(var17.getText(R.string.temperature_fahrenheit));
      var6.append('(');
      var6.append(var4);
      var6.append(var17.getText(R.string.temperature_unit_f));
      var6.append(')');
      var5.setText((CharSequence)var6.toString());
      var5 = var11.titleTempC;
      StringBuilder var12 = new StringBuilder();
      var12.append(var17.getText(R.string.temperature_celsius));
      var12.append('(');
      var12.append(var4);
      var12.append(var17.getText(R.string.temperature_unit_c));
      var12.append(')');
      var5.setText((CharSequence)var12.toString());
      this.getViewModel().getLiveDevice().observe((LifecycleOwner)this, new Observer(new DeviceC3TemperatureDialogFragment$$ExternalSyntheticLambda3(this)) {
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
      DialogfragmentDeviceC3TemperatureBinding var13 = this.binding;
      if (var13 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var13 = (DialogfragmentDeviceC3TemperatureBinding)var15;
      }

      ConstraintLayout var14 = var13.getRoot();
      Intrinsics.checkNotNullExpressionValue(var14, "getRoot(...)");
      return (View)var14;
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

      DialogUtils.INSTANCE.immersiveStatusBar(this.getDialog(), true, true);
   }

   public void setViewModel(DeviceDetailsViewModel var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.viewModel = var1;
   }

   public void showProgress(boolean var1) {
   }

   @Metadata(
      d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"},
      d2 = {"Lcom/blueair/devicedetails/dialog/DeviceC3TemperatureDialogFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/dialog/DeviceC3TemperatureDialogFragment;", "devicedetails_otherRelease"},
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

      public final DeviceC3TemperatureDialogFragment newInstance() {
         return new DeviceC3TemperatureDialogFragment();
      }
   }
}
