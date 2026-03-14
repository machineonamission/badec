package com.blueair.devicedetails.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.AlarmSound;
import com.blueair.core.model.Device;
import com.blueair.devicedetails.adapter.AlarmSoundAdapter;
import com.blueair.devicedetails.databinding.DialogfragmentDeviceAlarmSoundPickerBinding;
import com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel;
import com.blueair.viewcore.R;
import com.blueair.viewcore.dialog.BaseDialogFragment;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import com.blueair.viewcore.viewmodel.CustomViewModelStoreOwner;
import com.google.android.material.divider.MaterialDividerItemDecoration;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \"2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J$\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020!H\u0016R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0002X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000¨\u0006#"},
   d2 = {"Lcom/blueair/devicedetails/dialog/DeviceAlarmSoundPickerDialogFragment;", "Lcom/blueair/viewcore/dialog/BaseDialogFragment;", "Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "viewModel", "getViewModel", "()Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;", "setViewModel", "(Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;)V", "binding", "Lcom/blueair/devicedetails/databinding/DialogfragmentDeviceAlarmSoundPickerBinding;", "adapter", "Lcom/blueair/devicedetails/adapter/AlarmSoundAdapter;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "showProgress", "shouldShowProgress", "", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceAlarmSoundPickerDialogFragment extends BaseDialogFragment {
   public static final String ARG_SOUND = "ARG_SOUND";
   private static final String ARG_VOLUME = "ARG_VOLUME";
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   public static final String REQUEST_KEY = "DeviceAlarmSoundPickerDialogFragment";
   private AlarmSoundAdapter adapter;
   private DialogfragmentDeviceAlarmSoundPickerBinding binding;
   private final String screenName = "device_details_alarm_sound";
   private DeviceDetailsViewModel viewModel;

   // $FF: synthetic method
   public static void $r8$lambda$8nv4CR1cqN1ctLYkALsiUrXpvko(DeviceAlarmSoundPickerDialogFragment var0, View var1) {
      onCreateView$lambda$6$lambda$2(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$You4Tu6Hh6h1oOX6iaMSHpEbURM(DeviceAlarmSoundPickerDialogFragment var0, View var1) {
      onCreateView$lambda$6$lambda$1(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$j1M1sjNtPIV1NJq6LnaaPXs0_PY(DeviceAlarmSoundPickerDialogFragment var0, int var1, AlarmSound var2) {
      return onCreateView$lambda$6$lambda$5(var0, var1, var2);
   }

   public DeviceAlarmSoundPickerDialogFragment() {
      BaseDialogFragment var1 = this;
      this.viewModel = (DeviceDetailsViewModel)((BaseViewModel)(new ViewModelProvider(CustomViewModelStoreOwner.Companion.getDEVICE_DETAILS())).get(DeviceDetailsViewModel.class));
   }

   private static final void onCreateView$lambda$6$lambda$1(DeviceAlarmSoundPickerDialogFragment var0, View var1) {
      var0.dismiss();
   }

   private static final void onCreateView$lambda$6$lambda$2(DeviceAlarmSoundPickerDialogFragment var0, View var1) {
      var0.dismissAllowingStateLoss();
      Fragment var2 = (Fragment)var0;
      AlarmSoundAdapter var4 = var0.adapter;
      AlarmSoundAdapter var3 = var4;
      if (var4 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("adapter");
         var3 = null;
      }

      FragmentKt.setFragmentResult(var2, "DeviceAlarmSoundPickerDialogFragment", BundleKt.bundleOf(new Pair[]{TuplesKt.to("ARG_SOUND", var3.getSelectedSound().getValue())}));
   }

   private static final Unit onCreateView$lambda$6$lambda$5(DeviceAlarmSoundPickerDialogFragment var0, int var1, AlarmSound var2) {
      Intrinsics.checkNotNullParameter(var2, "sound");
      Device var3 = var0.getViewModel().getDevice();
      if (var3 != null) {
         var0.getViewModel().playAlarm(var3, var2.getValue(), var1);
      }

      return Unit.INSTANCE;
   }

   protected String getScreenName() {
      return this.screenName;
   }

   public DeviceDetailsViewModel getViewModel() {
      return this.viewModel;
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      Intrinsics.checkNotNullParameter(var1, "inflater");
      this.setStyle(0, R.style.DialogTheme);
      Dialog var16 = this.getDialog();
      if (var16 != null) {
         Window var17 = var16.getWindow();
         if (var17 != null) {
            var17.setBackgroundDrawable((Drawable)(new ColorDrawable(0)));
            var17.setWindowAnimations(R.style.dialog_animation);
            var17.setGravity(80);
         }
      }

      DialogfragmentDeviceAlarmSoundPickerBinding var10 = DialogfragmentDeviceAlarmSoundPickerBinding.inflate(var1, var2, false);
      Intrinsics.checkNotNullExpressionValue(var10, "inflate(...)");
      this.binding = var10;
      Object var18 = null;
      DialogfragmentDeviceAlarmSoundPickerBinding var7 = var10;
      if (var10 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var7 = null;
      }

      int var4;
      label26: {
         var7.btnClose.setOnClickListener(new DeviceAlarmSoundPickerDialogFragment$$ExternalSyntheticLambda0(this));
         var7.btnDone.setOnClickListener(new DeviceAlarmSoundPickerDialogFragment$$ExternalSyntheticLambda1(this));
         RecyclerView var11 = var7.rvList;
         MaterialDividerItemDecoration var5 = new MaterialDividerItemDecoration(this.requireContext(), 1);
         var5.setDividerColorResource(this.requireContext(), R.color.surface_dark_10);
         var11.addItemDecoration((RecyclerView.ItemDecoration)var5);
         var4 = this.requireArguments().getInt("ARG_VOLUME", 50);
         Device var12 = this.getViewModel().getDevice();
         if (var12 != null) {
            String var19 = var12.getMcuFirmware();
            var13 = var19;
            if (var19 != null) {
               break label26;
            }
         }

         var13 = "";
      }

      AlarmSoundAdapter var14 = new AlarmSoundAdapter(var13, new DeviceAlarmSoundPickerDialogFragment$$ExternalSyntheticLambda2(this, var4));
      this.adapter = var14;
      var14.setSelectedSound(AlarmSound.Companion.fromValue(this.requireArguments().getInt("ARG_SOUND", AlarmSound.Birds.getValue())));
      RecyclerView var6 = var7.rvList;
      AlarmSoundAdapter var20 = this.adapter;
      var14 = var20;
      if (var20 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("adapter");
         var14 = null;
      }

      var6.setAdapter(var14);
      var7.rvList.addOnScrollListener(new RecyclerView.OnScrollListener(var7) {
         final DialogfragmentDeviceAlarmSoundPickerBinding $this_run;

         {
            this.$this_run = var1;
         }

         public void onScrollStateChanged(RecyclerView var1, int var2) {
            Intrinsics.checkNotNullParameter(var1, "recyclerView");
            super.onScrollStateChanged(var1, var2);
            if (var2 != 0) {
               this.$this_run.bottomBar.setBackgroundColor(-1);
               View var4 = this.$this_run.separator;
               Intrinsics.checkNotNullExpressionValue(var4, "separator");
               ViewExtensionsKt.show$default(var4, false, 1, (Object)null);
            } else {
               this.$this_run.bottomBar.setBackgroundColor(0);
               View var3 = this.$this_run.separator;
               Intrinsics.checkNotNullExpressionValue(var3, "separator");
               ViewExtensionsKt.hide(var3);
            }
         }
      });
      var7 = this.binding;
      if (var7 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var7 = (DialogfragmentDeviceAlarmSoundPickerBinding)var18;
      }

      View var9 = var7.getRoot();
      Intrinsics.checkNotNullExpressionValue(var9, "getRoot(...)");
      return var9;
   }

   public void onDismiss(DialogInterface var1) {
      Intrinsics.checkNotNullParameter(var1, "dialog");
      super.onDismiss(var1);
      Device var2 = this.getViewModel().getDevice();
      if (var2 != null) {
         this.getViewModel().stopAlarm(var2);
      }

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

   public void setViewModel(DeviceDetailsViewModel var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.viewModel = var1;
   }

   public void showProgress(boolean var1) {
   }

   @Metadata(
      d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"},
      d2 = {"Lcom/blueair/devicedetails/dialog/DeviceAlarmSoundPickerDialogFragment$Companion;", "", "<init>", "()V", "REQUEST_KEY", "", "ARG_SOUND", "ARG_VOLUME", "newInstance", "Lcom/blueair/devicedetails/dialog/DeviceAlarmSoundPickerDialogFragment;", "sound", "", "volume", "devicedetails_otherRelease"},
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

      public final DeviceAlarmSoundPickerDialogFragment newInstance(int var1, int var2) {
         DeviceAlarmSoundPickerDialogFragment var3 = new DeviceAlarmSoundPickerDialogFragment();
         var3.setArguments(BundleKt.bundleOf(new Pair[]{TuplesKt.to("ARG_SOUND", var1), TuplesKt.to("ARG_VOLUME", var2)}));
         return var3;
      }
   }
}
