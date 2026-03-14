package com.blueair.devicedetails.dialog;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.Device;
import com.blueair.devicedetails.adapter.DeviceNScheduleModeAdapter;
import com.blueair.devicedetails.databinding.DialogfragmentDeviceNSetScheduleModeBinding;
import com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel;
import com.blueair.viewcore.R;
import com.blueair.viewcore.dialog.BaseDialogFragment;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \"2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J$\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u001a\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001f\u001a\u00020\u001dH\u0016J\u0010\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u0011H\u0016R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\u0002X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000¨\u0006#"},
   d2 = {"Lcom/blueair/devicedetails/dialog/DeviceNSetScheduleModeDialogFragment;", "Lcom/blueair/viewcore/dialog/BaseDialogFragment;", "Lcom/blueair/devicedetails/viewmodel/DeviceCreateEditScheduleViewModel;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "binding", "Lcom/blueair/devicedetails/databinding/DialogfragmentDeviceNSetScheduleModeBinding;", "viewModel", "getViewModel", "()Lcom/blueair/devicedetails/viewmodel/DeviceCreateEditScheduleViewModel;", "setViewModel", "(Lcom/blueair/devicedetails/viewmodel/DeviceCreateEditScheduleViewModel;)V", "isStartMode", "", "adapter", "Lcom/blueair/devicedetails/adapter/DeviceNScheduleModeAdapter;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onStart", "showProgress", "shouldShowProgress", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceNSetScheduleModeDialogFragment extends BaseDialogFragment {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private static final String EXTRA_IS_START_MODE = "EXTRA_IS_START_MODE";
   private DeviceNScheduleModeAdapter adapter;
   private DialogfragmentDeviceNSetScheduleModeBinding binding;
   private boolean isStartMode = true;
   private final String screenName = "device_details_schedule_mode";
   public DeviceCreateEditScheduleViewModel viewModel;

   // $FF: synthetic method
   public static void $r8$lambda$CBEId2xv45zuZuAqZSB29q6arv0(DeviceNSetScheduleModeDialogFragment var0, View var1) {
      onViewCreated$lambda$3$lambda$2(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$JU6egh4h8l42gxZYg2xGigQ1n30(DeviceNSetScheduleModeDialogFragment var0, View var1) {
      onViewCreated$lambda$3$lambda$1(var0, var1);
   }

   private static final void onViewCreated$lambda$3$lambda$1(DeviceNSetScheduleModeDialogFragment var0, View var1) {
      var0.dismiss();
   }

   private static final void onViewCreated$lambda$3$lambda$2(DeviceNSetScheduleModeDialogFragment var0, View var1) {
      boolean var2 = var0.isStartMode;
      Object var3 = null;
      Object var4 = null;
      if (var2) {
         DeviceCreateEditScheduleViewModel var5 = var0.getViewModel();
         DeviceNScheduleModeAdapter var29 = var0.adapter;
         DeviceNScheduleModeAdapter var6 = var29;
         if (var29 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            var6 = null;
         }

         var5.setStartFanSpeed(var6.getFanSpeed());
         var5 = var0.getViewModel();
         var29 = var0.adapter;
         var6 = var29;
         if (var29 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            var6 = null;
         }

         var5.setPurifierMode(var6.getMode());
         var5 = var0.getViewModel();
         var29 = var0.adapter;
         var6 = var29;
         if (var29 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            var6 = null;
         }

         var5.setStartBrightness(var6.getBrightness());
         var5 = var0.getViewModel();
         var29 = var0.adapter;
         var6 = var29;
         if (var29 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            var6 = null;
         }

         var5.setStartAutoRh(var6.getAutoRh());
         var5 = var0.getViewModel();
         var29 = var0.adapter;
         var6 = var29;
         if (var29 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            var6 = null;
         }

         var5.setStartMainMode(var6.getMainMode());
         var5 = var0.getViewModel();
         var29 = var0.adapter;
         var6 = var29;
         if (var29 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            var6 = null;
         }

         var5.setStartApSubMode(var6.getApSubMode());
         var5 = var0.getViewModel();
         var29 = var0.adapter;
         var6 = var29;
         if (var29 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            var6 = null;
         }

         var5.setStartSmartSubMode(var6.getSmartSubMode());
         var5 = var0.getViewModel();
         var29 = var0.adapter;
         var6 = var29;
         if (var29 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            var6 = null;
         }

         var5.setStartHeatAutoTemp(var6.getHeatAutoTemp());
         var5 = var0.getViewModel();
         var29 = var0.adapter;
         var6 = var29;
         if (var29 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            var6 = null;
         }

         var5.setStartHeatEcoTemp(var6.getHeatEcoTmp());
         var5 = var0.getViewModel();
         var29 = var0.adapter;
         var6 = var29;
         if (var29 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            var6 = null;
         }

         var5.setStartOscillationEnabled(var6.getOscillationEnabled());
         DeviceCreateEditScheduleViewModel var39 = var0.getViewModel();
         var6 = var0.adapter;
         if (var6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            var6 = (DeviceNScheduleModeAdapter)var4;
         }

         var39.setStartHumMode(var6.getHumMode());
      } else {
         MutableLiveData var61 = var0.getViewModel().getScheduleEndType();
         DeviceNScheduleModeAdapter var40 = var0.adapter;
         DeviceNScheduleModeAdapter var17 = var40;
         if (var40 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            var17 = null;
         }

         var61.setValue(var17.getCustomType());
         DeviceCreateEditScheduleViewModel var62 = var0.getViewModel();
         var40 = var0.adapter;
         var17 = var40;
         if (var40 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            var17 = null;
         }

         var62.setScheduleEndCustomFanSpeed(var17.getFanSpeed());
         var62 = var0.getViewModel();
         var40 = var0.adapter;
         var17 = var40;
         if (var40 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            var17 = null;
         }

         var62.setScheduleEndCustomMode(var17.getMode());
         var62 = var0.getViewModel();
         var40 = var0.adapter;
         var17 = var40;
         if (var40 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            var17 = null;
         }

         var62.setScheduleEndCustomBrightness(var17.getBrightness());
         var62 = var0.getViewModel();
         var40 = var0.adapter;
         var17 = var40;
         if (var40 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            var17 = null;
         }

         var62.setScheduleEndCustomAutoRh(var17.getAutoRh());
         var62 = var0.getViewModel();
         var40 = var0.adapter;
         var17 = var40;
         if (var40 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            var17 = null;
         }

         var62.setScheduleEndCustomMainMode(var17.getMainMode());
         var62 = var0.getViewModel();
         var40 = var0.adapter;
         var17 = var40;
         if (var40 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            var17 = null;
         }

         var62.setScheduleEndCustomApSubMode(var17.getApSubMode());
         var62 = var0.getViewModel();
         var40 = var0.adapter;
         var17 = var40;
         if (var40 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            var17 = null;
         }

         var62.setScheduleEndCustomSmartSubMode(var17.getSmartSubMode());
         var62 = var0.getViewModel();
         var40 = var0.adapter;
         var17 = var40;
         if (var40 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            var17 = null;
         }

         var62.setScheduleEndCustomHeatAutoTemp(var17.getHeatAutoTemp());
         var62 = var0.getViewModel();
         var40 = var0.adapter;
         var17 = var40;
         if (var40 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            var17 = null;
         }

         var62.setScheduleEndCustomHeatEcoTemp(var17.getHeatEcoTmp());
         var62 = var0.getViewModel();
         var40 = var0.adapter;
         var17 = var40;
         if (var40 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            var17 = null;
         }

         var62.setScheduleEndCustomOscillationEnabled(var17.getOscillationEnabled());
         DeviceCreateEditScheduleViewModel var51 = var0.getViewModel();
         var17 = var0.adapter;
         if (var17 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            var17 = (DeviceNScheduleModeAdapter)var3;
         }

         var51.setScheduleEndCustomHumMode(var17.getHumMode());
      }

      var0.dismiss();
   }

   protected String getScreenName() {
      return this.screenName;
   }

   public DeviceCreateEditScheduleViewModel getViewModel() {
      DeviceCreateEditScheduleViewModel var1 = this.viewModel;
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
      Dialog var7 = this.getDialog();
      if (var7 != null) {
         Window var8 = var7.getWindow();
         if (var8 != null) {
            var8.setBackgroundDrawable((Drawable)(new ColorDrawable(0)));
            var8.setWindowAnimations(R.style.dialog_animation);
            var8.setGravity(80);
         }
      }

      this.isStartMode = this.requireArguments().getBoolean("EXTRA_IS_START_MODE", true);
      DeviceCreateEditScheduleViewModel var10;
      if (this.getParentFragment() == null) {
         FragmentActivity var9 = ((BaseDialogFragment)this).requireActivity();
         Intrinsics.checkNotNullExpressionValue(var9, "requireActivity(...)");
         var10 = (DeviceCreateEditScheduleViewModel)((BaseViewModel)(new ViewModelProvider((ViewModelStoreOwner)var9)).get(DeviceCreateEditScheduleViewModel.class));
      } else {
         BaseDialogFragment var11 = this;
         Fragment var12 = this.requireParentFragment();
         Intrinsics.checkNotNullExpressionValue(var12, "requireParentFragment(...)");
         var10 = (DeviceCreateEditScheduleViewModel)((BaseViewModel)(new ViewModelProvider((ViewModelStoreOwner)var12)).get(DeviceCreateEditScheduleViewModel.class));
      }

      this.setViewModel(var10);
      DialogfragmentDeviceNSetScheduleModeBinding var6 = DialogfragmentDeviceNSetScheduleModeBinding.inflate(var1, var2, false);
      Intrinsics.checkNotNullExpressionValue(var6, "inflate(...)");
      this.binding = var6;
      DialogfragmentDeviceNSetScheduleModeBinding var4 = var6;
      if (var6 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var4 = null;
      }

      View var5 = var4.getRoot();
      Intrinsics.checkNotNullExpressionValue(var5, "getRoot(...)");
      return var5;
   }

   public void onStart() {
      super.onStart();
      Dialog var1 = this.getDialog();
      if (var1 != null) {
         Window var2 = var1.getWindow();
         if (var2 != null) {
            var2.setLayout(-1, -2);
         }
      }

   }

   public void onViewCreated(View var1, Bundle var2) {
      Intrinsics.checkNotNullParameter(var1, "view");
      super.onViewCreated(var1, var2);
      DialogfragmentDeviceNSetScheduleModeBinding var8 = this.binding;
      Object var4 = null;
      DialogfragmentDeviceNSetScheduleModeBinding var6 = var8;
      if (var8 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var6 = null;
      }

      TextView var9 = var6.title;
      int var3;
      if (this.isStartMode) {
         var3 = R.string.schedule_set_start_mode;
      } else {
         var3 = R.string.schedule_set_end_mode;
      }

      var9.setText(var3);
      var6.backBtn.setOnClickListener(new DeviceNSetScheduleModeDialogFragment$$ExternalSyntheticLambda0(this));
      var6.saveBtn.setOnClickListener(new DeviceNSetScheduleModeDialogFragment$$ExternalSyntheticLambda1(this));
      var6.modeControls.setLayoutManager((RecyclerView.LayoutManager)(new LinearLayoutManager(this.requireContext())));
      String var5 = (String)this.getViewModel().getScheduleEndType().getValue();
      String var10 = var5;
      if (var5 == null) {
         var10 = "previous";
      }

      DeviceNScheduleModeAdapter var11;
      if (this.isStartMode) {
         Device var13 = this.getViewModel().getDevice();
         Intrinsics.checkNotNull(var13);
         var11 = new DeviceNScheduleModeAdapter(var13, true, var10, this.getViewModel().getPurifierMode(), this.getViewModel().getStartFanSpeed(), this.getViewModel().getStartBrightness(), this.getViewModel().getStartAutoRh(), this.getViewModel().getStartMainMode(), this.getViewModel().getStartApSubMode(), this.getViewModel().getStartSmartSubMode(), this.getViewModel().getStartHeatAutoTemp(), this.getViewModel().getStartHeatEcoTemp(), this.getViewModel().getStartOscillationEnabled(), this.getViewModel().getStartHumMode());
      } else {
         Device var14 = this.getViewModel().getDevice();
         Intrinsics.checkNotNull(var14);
         var11 = new DeviceNScheduleModeAdapter(var14, false, var10, this.getViewModel().getScheduleEndCustomMode(), this.getViewModel().getScheduleEndCustomFanSpeed(), this.getViewModel().getScheduleEndCustomBrightness(), this.getViewModel().getScheduleEndCustomAutoRh(), this.getViewModel().getScheduleEndCustomMainMode(), this.getViewModel().getScheduleEndCustomApSubMode(), this.getViewModel().getScheduleEndCustomSmartSubMode(), this.getViewModel().getScheduleEndCustomHeatAutoTemp(), this.getViewModel().getScheduleEndCustomHeatEcoTemp(), this.getViewModel().getScheduleEndCustomOscillationEnabled(), this.getViewModel().getScheduleEndCustomHumMode());
      }

      this.adapter = var11;
      RecyclerView var12 = var6.modeControls;
      DeviceNScheduleModeAdapter var7 = this.adapter;
      if (var7 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("adapter");
         var7 = (DeviceNScheduleModeAdapter)var4;
      }

      var12.setAdapter(var7);
   }

   public void setViewModel(DeviceCreateEditScheduleViewModel var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.viewModel = var1;
   }

   public void showProgress(boolean var1) {
   }

   @Metadata(
      d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"},
      d2 = {"Lcom/blueair/devicedetails/dialog/DeviceNSetScheduleModeDialogFragment$Companion;", "", "<init>", "()V", "EXTRA_IS_START_MODE", "", "newInstance", "Lcom/blueair/devicedetails/dialog/DeviceNSetScheduleModeDialogFragment;", "isStartMode", "", "devicedetails_otherRelease"},
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

      public final DeviceNSetScheduleModeDialogFragment newInstance(boolean var1) {
         DeviceNSetScheduleModeDialogFragment var2 = new DeviceNSetScheduleModeDialogFragment();
         var2.setArguments(BundleKt.bundleOf(new Pair[]{TuplesKt.to("EXTRA_IS_START_MODE", var1)}));
         return var2;
      }
   }
}
