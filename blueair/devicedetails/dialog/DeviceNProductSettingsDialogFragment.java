package com.blueair.devicedetails.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
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
import com.blueair.core.model.DeviceNewClassic;
import com.blueair.core.model.FilterTrigger;
import com.blueair.core.model.HasG4NightMode;
import com.blueair.devicedetails.adapter.DeviceNSettingsAdapter;
import com.blueair.devicedetails.databinding.DialogfragmentDeviceNProductSettingsBinding;
import com.blueair.devicedetails.util.DeviceNSettings;
import com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel;
import com.blueair.viewcore.R;
import com.blueair.viewcore.dialog.BaseDialogFragment;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 !2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J$\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u001a\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001d\u001a\u00020\u001bH\u0016J\u0010\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020 H\u0016R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\u0002X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000¨\u0006\""},
   d2 = {"Lcom/blueair/devicedetails/dialog/DeviceNProductSettingsDialogFragment;", "Lcom/blueair/viewcore/dialog/BaseDialogFragment;", "Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "binding", "Lcom/blueair/devicedetails/databinding/DialogfragmentDeviceNProductSettingsBinding;", "viewModel", "getViewModel", "()Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;", "setViewModel", "(Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;)V", "adapter", "Lcom/blueair/devicedetails/adapter/DeviceNSettingsAdapter;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onStart", "showProgress", "shouldShowProgress", "", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceNProductSettingsDialogFragment extends BaseDialogFragment {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private DeviceNSettingsAdapter adapter;
   private DialogfragmentDeviceNProductSettingsBinding binding;
   private final String screenName = "device_settings";
   public DeviceDetailsViewModel viewModel;

   // $FF: synthetic method
   public static void $r8$lambda$5AYuo4Vv_ktkltOZmzKsJeRjWmk/* $FF was: $r8$lambda$5AYuo4Vv-ktkltOZmzKsJeRjWmk*/(DeviceNProductSettingsDialogFragment var0, Device var1, DialogInterface var2, int var3) {
      onViewCreated$lambda$15$lambda$13$lambda$8(var0, var1, var2, var3);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$MON3Z0OAuXp_3Plo1j_y_0_9ZQQ/* $FF was: $r8$lambda$MON3Z0OAuXp_3Plo1j-y_0-9ZQQ*/(DeviceNProductSettingsDialogFragment var0, Device var1) {
      return onViewCreated$lambda$15$lambda$14(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$NcV1Pcfg3p0tcVfh0yMDbF9jawA(DeviceNProductSettingsDialogFragment var0, View var1) {
      onViewCreated$lambda$15$lambda$3(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$f6tyZfgosq1GxHV0GiOO6dnNCss(DialogInterface var0, int var1) {
      onViewCreated$lambda$15$lambda$13$lambda$9(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$jeDAIA1uHxHK3rR3W_AyaWP1_r8(DeviceNProductSettingsDialogFragment var0, DeviceNSettings var1, Device var2, Object var3) {
      return onViewCreated$lambda$15$lambda$13(var0, var1, var2, var3);
   }

   // $FF: synthetic method
   public static void $r8$lambda$vTyhj1zM_sTBAxyIS5oU3t4YqzE(DeviceNProductSettingsDialogFragment var0, View var1) {
      onViewCreated$lambda$15$lambda$2(var0, var1);
   }

   private static final Unit onViewCreated$lambda$15$lambda$13(DeviceNProductSettingsDialogFragment var0, DeviceNSettings var1, Device var2, Object var3) {
      Intrinsics.checkNotNullParameter(var1, "type");
      Intrinsics.checkNotNullParameter(var2, "device");
      Intrinsics.checkNotNullParameter(var3, "data");
      switch (DeviceNProductSettingsDialogFragment.WhenMappings.$EnumSwitchMapping$0[var1.ordinal()]) {
         case 1:
            FragmentManager var9 = var0.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(var9, "getChildFragmentManager(...)");
            Intrinsics.checkNotNullExpressionValue("DeviceEditNameDialogFragment", "getSimpleName(...)");
            if (!(var9.findFragmentByTag("DeviceEditNameDialogFragment") instanceof DeviceEditNameDialogFragment) && !var9.isStateSaved()) {
               ((DialogFragment)DeviceEditNameDialogFragment.Companion.newInstance(var2)).show(var9, "DeviceEditNameDialogFragment");
            }
            break;
         case 2:
            FragmentManager var8 = var0.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(var8, "getChildFragmentManager(...)");
            Intrinsics.checkNotNullExpressionValue("DeviceSetTimezoneDialogFragment", "getSimpleName(...)");
            if (!(var8.findFragmentByTag("DeviceSetTimezoneDialogFragment") instanceof DeviceSetTimezoneDialogFragment) && !var8.isStateSaved()) {
               ((DialogFragment)DeviceSetTimezoneDialogFragment.Companion.newInstance(var2)).show(var8, "DeviceSetTimezoneDialogFragment");
            }
            break;
         case 3:
            HasG4NightMode var11 = (HasG4NightMode)var2;
            var0.getViewModel().autoModeFilterTriggerChanged((FilterTrigger)var3, var11.getG4NightModeTrigger());
            break;
         case 4:
            HasG4NightMode var10 = (HasG4NightMode)var2;
            var0.getViewModel().autoModeFilterTriggerChanged(var10.getTrigger(), (FilterTrigger)var3);
            break;
         case 5:
            FragmentManager var7 = var0.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(var7, "getChildFragmentManager(...)");
            Intrinsics.checkNotNullExpressionValue("DeviceSettingInfoDialogFragment", "getSimpleName(...)");
            if (!(var7.findFragmentByTag("DeviceSettingInfoDialogFragment") instanceof DeviceSettingInfoDialogFragment) && !var7.isStateSaved()) {
               ((DialogFragment)DeviceSettingInfoDialogFragment.Companion.newInstance(var2)).show(var7, "DeviceSettingInfoDialogFragment");
            }
            break;
         case 6:
            (new AlertDialog.Builder(var0.requireContext())).setMessage(R.string.error_report_open_confirmation).setPositiveButton(17039370, new DeviceNProductSettingsDialogFragment$$ExternalSyntheticLambda4(var0, var2)).setNegativeButton(17039360, new DeviceNProductSettingsDialogFragment$$ExternalSyntheticLambda5()).show();
            break;
         case 7:
            FragmentManager var6 = var0.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(var6, "getChildFragmentManager(...)");
            Intrinsics.checkNotNullExpressionValue("DeleteDeviceDialogFragment", "getSimpleName(...)");
            if (!(var6.findFragmentByTag("DeleteDeviceDialogFragment") instanceof DeleteDeviceDialogFragment) && !var6.isStateSaved()) {
               ((DialogFragment)DeleteDeviceDialogFragment.Companion.newInstance(var2, false)).show(var6, "DeleteDeviceDialogFragment");
            }
            break;
         case 8:
            FragmentManager var5 = var0.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(var5, "getChildFragmentManager(...)");
            Intrinsics.checkNotNullExpressionValue("DeviceC3TemperatureDialogFragment", "getSimpleName(...)");
            if (!(var5.findFragmentByTag("DeviceC3TemperatureDialogFragment") instanceof DeviceC3TemperatureDialogFragment) && !var5.isStateSaved()) {
               ((DialogFragment)DeviceC3TemperatureDialogFragment.Companion.newInstance()).show(var5, "DeviceC3TemperatureDialogFragment");
            }
            break;
         case 9:
            FragmentManager var4 = var0.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(var4, "getChildFragmentManager(...)");
            Intrinsics.checkNotNullExpressionValue("DeviceHDryModeDialogFragment", "getSimpleName(...)");
            if (!(var4.findFragmentByTag("DeviceHDryModeDialogFragment") instanceof DeviceHDryModeDialogFragment) && !var4.isStateSaved()) {
               ((DialogFragment)DeviceHDryModeDialogFragment.Companion.newInstance()).show(var4, "DeviceHDryModeDialogFragment");
            }
            break;
         default:
            throw new NoWhenBranchMatchedException();
      }

      return Unit.INSTANCE;
   }

   private static final void onViewCreated$lambda$15$lambda$13$lambda$8(DeviceNProductSettingsDialogFragment var0, Device var1, DialogInterface var2, int var3) {
      FragmentManager var4 = var0.getChildFragmentManager();
      Intrinsics.checkNotNullExpressionValue(var4, "getChildFragmentManager(...)");
      Intrinsics.checkNotNullExpressionValue("DeviceErrorReportDialogFragment", "getSimpleName(...)");
      if (!(var4.findFragmentByTag("DeviceErrorReportDialogFragment") instanceof DeviceErrorReportDialogFragment) && !var4.isStateSaved()) {
         ((DialogFragment)DeviceErrorReportDialogFragment.Companion.newInstance(var1)).show(var4, "DeviceErrorReportDialogFragment");
      }

   }

   private static final void onViewCreated$lambda$15$lambda$13$lambda$9(DialogInterface var0, int var1) {
      var0.dismiss();
   }

   private static final Unit onViewCreated$lambda$15$lambda$14(DeviceNProductSettingsDialogFragment var0, Device var1) {
      if (var1 == null) {
         var0.dismiss();
      } else {
         var0.getViewModel().setDevice(var1);
         DeviceNSettingsAdapter var2 = var0.adapter;
         DeviceNSettingsAdapter var3 = var2;
         if (var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            var3 = null;
         }

         var3.setDevice(var1);
      }

      return Unit.INSTANCE;
   }

   private static final void onViewCreated$lambda$15$lambda$2(DeviceNProductSettingsDialogFragment var0, View var1) {
      var0.dismiss();
   }

   private static final void onViewCreated$lambda$15$lambda$3(DeviceNProductSettingsDialogFragment var0, View var1) {
      var0.dismiss();
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
      Dialog var8 = this.getDialog();
      if (var8 != null) {
         Window var9 = var8.getWindow();
         if (var9 != null) {
            var9.setBackgroundDrawable((Drawable)(new ColorDrawable(0)));
            var9.setWindowAnimations(R.style.dialog_animation);
            var9.setGravity(80);
         }
      }

      Parcelable var10 = this.requireArguments().getParcelable("device");
      if (var10 != null) {
         Device var11 = (Device)var10;
         FragmentActivity var4 = ((BaseDialogFragment)this).requireActivity();
         Intrinsics.checkNotNullExpressionValue(var4, "requireActivity(...)");
         this.setViewModel((DeviceDetailsViewModel)((BaseViewModel)(new ViewModelProvider((ViewModelStoreOwner)var4)).get(DeviceDetailsViewModel.class)));
         this.getViewModel().setDeviceId(var11.getUid());
         this.getViewModel().setDevice(var11);
         DialogfragmentDeviceNProductSettingsBinding var7 = DialogfragmentDeviceNProductSettingsBinding.inflate(var1, var2, false);
         Intrinsics.checkNotNullExpressionValue(var7, "inflate(...)");
         if (!(var11 instanceof DeviceNewClassic)) {
            var7.closeBtn.setVisibility(4);
            var7.doneBtn.setVisibility(0);
            var7.contentContainer.setBackgroundTintList(ColorStateList.valueOf(this.requireContext().getColor(R.color.anti_flash_blue)));
         }

         this.binding = var7;
         DialogfragmentDeviceNProductSettingsBinding var5 = var7;
         if (var7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var5 = null;
         }

         View var6 = var5.getRoot();
         Intrinsics.checkNotNullExpressionValue(var6, "getRoot(...)");
         return var6;
      } else {
         throw new IllegalStateException("Required value was null.".toString());
      }
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

   public void onViewCreated(View var1, Bundle var2) {
      Intrinsics.checkNotNullParameter(var1, "view");
      super.onViewCreated(var1, var2);
      DialogfragmentDeviceNProductSettingsBinding var3 = this.binding;
      Object var6 = null;
      DialogfragmentDeviceNProductSettingsBinding var4 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var4 = null;
      }

      var4.closeBtn.setOnClickListener(new DeviceNProductSettingsDialogFragment$$ExternalSyntheticLambda0(this));
      var4.doneBtn.setOnClickListener(new DeviceNProductSettingsDialogFragment$$ExternalSyntheticLambda1(this));
      var4.settingsList.setLayoutManager((RecyclerView.LayoutManager)(new LinearLayoutManager(this.requireContext())));
      DeviceNSettingsAdapter var7 = new DeviceNSettingsAdapter();
      this.adapter = var7;
      var7.setOnSettingActionListener(new DeviceNProductSettingsDialogFragment$$ExternalSyntheticLambda2(this));
      RecyclerView var8 = var4.settingsList;
      DeviceNSettingsAdapter var5 = this.adapter;
      if (var5 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("adapter");
         var5 = (DeviceNSettingsAdapter)var6;
      }

      var8.setAdapter(var5);
      this.getViewModel().getLiveDevice().observe(this.getViewLifecycleOwner(), new Observer(new DeviceNProductSettingsDialogFragment$$ExternalSyntheticLambda3(this)) {
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

   public void setViewModel(DeviceDetailsViewModel var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.viewModel = var1;
   }

   public void showProgress(boolean var1) {
   }

   @Metadata(
      d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"},
      d2 = {"Lcom/blueair/devicedetails/dialog/DeviceNProductSettingsDialogFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/dialog/DeviceNProductSettingsDialogFragment;", "device", "Lcom/blueair/core/model/Device;", "devicedetails_otherRelease"},
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

      public final DeviceNProductSettingsDialogFragment newInstance(Device var1) {
         Intrinsics.checkNotNullParameter(var1, "device");
         DeviceNProductSettingsDialogFragment var2 = new DeviceNProductSettingsDialogFragment();
         var2.setArguments(BundleKt.bundleOf(new Pair[]{TuplesKt.to("device", var1)}));
         return var2;
      }
   }

   // $FF: synthetic class
   @Metadata(
      k = 3,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class WhenMappings {
      public static final int[] $EnumSwitchMapping$0;

      static {
         int[] var0 = new int[DeviceNSettings.values().length];

         try {
            var0[DeviceNSettings.CUSTOM_NAME.ordinal()] = 1;
         } catch (NoSuchFieldError var10) {
         }

         try {
            var0[DeviceNSettings.TIME_ZONE.ordinal()] = 2;
         } catch (NoSuchFieldError var9) {
         }

         try {
            var0[DeviceNSettings.TRIGGER_AUTO.ordinal()] = 3;
         } catch (NoSuchFieldError var8) {
         }

         try {
            var0[DeviceNSettings.TRIGGER_NIGHT.ordinal()] = 4;
         } catch (NoSuchFieldError var7) {
         }

         try {
            var0[DeviceNSettings.PRODUCT_INFO.ordinal()] = 5;
         } catch (NoSuchFieldError var6) {
         }

         try {
            var0[DeviceNSettings.SYSTEM_INFO.ordinal()] = 6;
         } catch (NoSuchFieldError var5) {
         }

         try {
            var0[DeviceNSettings.DELETE.ordinal()] = 7;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[DeviceNSettings.TEMPERATURE.ordinal()] = 8;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[DeviceNSettings.DRY_MODE.ordinal()] = 9;
         } catch (NoSuchFieldError var2) {
         }

         $EnumSwitchMapping$0 = var0;
      }
   }
}
