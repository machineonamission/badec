package com.blueair.devicedetails.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RadioGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.core.content.ContextCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceScheduleMerged;
import com.blueair.core.model.FanSpeedEnum;
import com.blueair.core.model.HasBlueCloudFunctions;
import com.blueair.devicedetails.R;
import com.blueair.devicedetails.adapter.DaysOfWeekSelectorAdapter;
import com.blueair.devicedetails.adapter.DeviceScheduleAfterInstructionAdapter;
import com.blueair.devicedetails.adapter.DeviceScheduleInstructionAdapter;
import com.blueair.devicedetails.databinding.DialogfragmentDeviceCreateEditScheduleBinding;
import com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel;
import com.blueair.viewcore.ViewUtils;
import com.blueair.viewcore.dialog.BaseDialogFragment;
import com.blueair.viewcore.dialog.ConfirmationDialogCentered;
import com.blueair.viewcore.extensions.FragmentExtensionsKt;
import com.blueair.viewcore.fragment.BaseFragmentInterface;
import com.blueair.viewcore.fragment.BaseFragmentInterface$_CC;
import com.blueair.viewcore.fragment.ProgressFragment;
import com.blueair.viewcore.fragment.ProgressFragment$_CC;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import com.google.android.material.button.MaterialButton;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import java.util.Calendar;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 _2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001_B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u00102\u001a\u000203H\u0016J\u0012\u0010?\u001a\u00020:2\b\u0010@\u001a\u0004\u0018\u00010AH\u0017J\u0012\u0010B\u001a\u00020:2\b\u0010@\u001a\u0004\u0018\u00010AH\u0016J\b\u0010C\u001a\u00020:H\u0016J\b\u0010D\u001a\u00020:H\u0016J\u0012\u0010E\u001a\u00020F2\b\u0010@\u001a\u0004\u0018\u00010AH\u0016J$\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020J2\b\u0010K\u001a\u0004\u0018\u00010L2\b\u0010@\u001a\u0004\u0018\u00010AH\u0016J\u001a\u0010M\u001a\u00020:2\u0006\u0010N\u001a\u00020H2\b\u0010@\u001a\u0004\u0018\u00010AH\u0016J\b\u0010O\u001a\u00020:H\u0002J\u0010\u0010P\u001a\u00020:2\u0006\u0010Q\u001a\u00020RH\u0002J\b\u0010S\u001a\u00020:H\u0002J\b\u0010T\u001a\u00020:H\u0002J\b\u0010U\u001a\u00020:H\u0002J\b\u0010V\u001a\u00020:H\u0002J\b\u0010W\u001a\u00020:H\u0002J\b\u0010X\u001a\u00020:H\u0002J\b\u0010Y\u001a\u00020:H\u0016J\u0010\u0010Z\u001a\u00020:2\u0006\u0010[\u001a\u000206H\u0016J\b\u0010\\\u001a\u000206H\u0002J\b\u0010]\u001a\u000206H\u0002J\b\u0010^\u001a\u000206H\u0002R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\u0002X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0012X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\u001a\u0010\u001a\u001a\u00020\u001bX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020!X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020'X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001c\u0010,\u001a\u0004\u0018\u00010-X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R7\u00104\u001a\u001f\u0012\u0013\u0012\u001106¢\u0006\f\b7\u0012\b\b8\u0012\u0004\b\b(9\u0012\u0004\u0012\u00020:\u0018\u000105X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>¨\u0006`"},
   d2 = {"Lcom/blueair/devicedetails/dialog/DeviceCreateEditScheduleDialogFragment;", "Lcom/blueair/viewcore/dialog/BaseDialogFragment;", "Lcom/blueair/devicedetails/viewmodel/DeviceCreateEditScheduleViewModel;", "Lcom/blueair/viewcore/fragment/ProgressFragment;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "viewDataBinding", "Lcom/blueair/devicedetails/databinding/DialogfragmentDeviceCreateEditScheduleBinding;", "viewModel", "getViewModel", "()Lcom/blueair/devicedetails/viewmodel/DeviceCreateEditScheduleViewModel;", "setViewModel", "(Lcom/blueair/devicedetails/viewmodel/DeviceCreateEditScheduleViewModel;)V", "onStartAdapter", "Lcom/blueair/devicedetails/adapter/DeviceScheduleInstructionAdapter;", "getOnStartAdapter", "()Lcom/blueair/devicedetails/adapter/DeviceScheduleInstructionAdapter;", "setOnStartAdapter", "(Lcom/blueair/devicedetails/adapter/DeviceScheduleInstructionAdapter;)V", "onCustomAdapter", "getOnCustomAdapter", "setOnCustomAdapter", "onEndAdapter", "Lcom/blueair/devicedetails/adapter/DeviceScheduleAfterInstructionAdapter;", "getOnEndAdapter", "()Lcom/blueair/devicedetails/adapter/DeviceScheduleAfterInstructionAdapter;", "setOnEndAdapter", "(Lcom/blueair/devicedetails/adapter/DeviceScheduleAfterInstructionAdapter;)V", "daysOfWeekAdapter", "Lcom/blueair/devicedetails/adapter/DaysOfWeekSelectorAdapter;", "getDaysOfWeekAdapter", "()Lcom/blueair/devicedetails/adapter/DaysOfWeekSelectorAdapter;", "setDaysOfWeekAdapter", "(Lcom/blueair/devicedetails/adapter/DaysOfWeekSelectorAdapter;)V", "device", "Lcom/blueair/core/model/Device;", "getDevice", "()Lcom/blueair/core/model/Device;", "setDevice", "(Lcom/blueair/core/model/Device;)V", "progressBlockerView", "Lcom/blueair/viewcore/view/ProgressBlockerView;", "getProgressBlockerView", "()Lcom/blueair/viewcore/view/ProgressBlockerView;", "setProgressBlockerView", "(Lcom/blueair/viewcore/view/ProgressBlockerView;)V", "getRootView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "onDismiss", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isDeleteSchedule", "", "getOnDismiss", "()Lkotlin/jvm/functions/Function1;", "setOnDismiss", "(Lkotlin/jvm/functions/Function1;)V", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onCreate", "onStart", "onStop", "onCreateDialog", "Landroid/app/Dialog;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "configureTimePicker", "updateTimePickerWithPurifyMode", "mode", "Lcom/blueair/devicedetails/viewmodel/DeviceCreateEditScheduleViewModel$PurifierMode;", "configureControls", "configureCustomSchedule", "configureRepeat", "configureToolbar", "bindViewModeltoView", "configureDelete", "onDestroy", "showProgress", "shouldShowProgress", "shouldShowLabelEditText", "shouldShowEndSchedule", "shouldShowCustomSchedule", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceCreateEditScheduleDialogFragment extends BaseDialogFragment implements ProgressFragment {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   public DaysOfWeekSelectorAdapter daysOfWeekAdapter;
   public Device device;
   public DeviceScheduleInstructionAdapter onCustomAdapter;
   private Function1 onDismiss;
   public DeviceScheduleAfterInstructionAdapter onEndAdapter;
   public DeviceScheduleInstructionAdapter onStartAdapter;
   private ProgressBlockerView progressBlockerView;
   private final String screenName = "device_details_schedule_details";
   private DialogfragmentDeviceCreateEditScheduleBinding viewDataBinding;
   public DeviceCreateEditScheduleViewModel viewModel;

   // $FF: synthetic method
   public static Unit $r8$lambda$_aX7Z54jVGpuYju9btCEjlhNpyc/* $FF was: $r8$lambda$-aX7Z54jVGpuYju9btCEjlhNpyc*/(DeviceCreateEditScheduleDialogFragment var0, String var1, Bundle var2) {
      return configureDelete$lambda$37$lambda$36(var0, var1, var2);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$17dtFlT1_kYJQXAQmQNC9cbuJk0/* $FF was: $r8$lambda$17dtFlT1-kYJQXAQmQNC9cbuJk0*/(DeviceCreateEditScheduleDialogFragment var0, Object var1) {
      return configureControls$lambda$11(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$2wXXYCELThkuR4btQcaKrbxAAtM(DeviceCreateEditScheduleDialogFragment var0, RadioGroup var1, int var2) {
      configureCustomSchedule$lambda$22(var0, var1, var2);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$4WHfBh50hcwBo03fgJl32ISgiSI(DeviceCreateEditScheduleDialogFragment var0, Set var1) {
      return configureRepeat$lambda$24(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$65j8788coiOOQ2vqnbG8NbPSlZ0(DeviceCreateEditScheduleDialogFragment var0, DeviceCreateEditScheduleViewModel.PurifierMode var1) {
      return configureControls$lambda$9(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$7Z4C8nHx5whemikNwAbjPj4T1YA(DeviceCreateEditScheduleDialogFragment var0, DeviceCreateEditScheduleViewModel.PurifierMode var1) {
      return configureControls$lambda$21(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$JrtFZhpIMrTkBWUICNRNghom_hg/* $FF was: $r8$lambda$JrtFZhpIMrTkBWUICNRNghom-hg*/(DeviceCreateEditScheduleDialogFragment var0, Object var1) {
      return configureControls$lambda$16(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$JuCzI3EnyzBVUbLGXbZmdV5hEcQ(DeviceCreateEditScheduleDialogFragment var0, Boolean var1) {
      return configureToolbar$lambda$33(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$Q9UYfXVEk3L6L6GZ6ACqE7flUBY(DeviceCreateEditScheduleDialogFragment var0, boolean var1, boolean var2) {
      return configureToolbar$lambda$31$lambda$30(var0, var1, var2);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$RRPH4_oXr1aic_UeBKtl_6d6lO4/* $FF was: $r8$lambda$RRPH4_oXr1aic-UeBKtl_6d6lO4*/(DeviceCreateEditScheduleDialogFragment var0, Boolean var1) {
      return configureToolbar$lambda$32(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$SVSSiMlWOS_m0RLDvInmvORhVYc(DeviceCreateEditScheduleDialogFragment var0, Object var1) {
      return configureControls$lambda$13(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$W9KAEG9d72p5g0mRh3HBH7c3Lzw(DeviceCreateEditScheduleDialogFragment var0, View var1) {
      configureTimePicker$lambda$8(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$X3wjaNxTB9jx1uOpH8_imaRshY8/* $FF was: $r8$lambda$X3wjaNxTB9jx1uOpH8-imaRshY8*/(DeviceCreateEditScheduleDialogFragment var0, View var1) {
      configureRepeat$lambda$26(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$au_wCD__kXRb1mKOjRrwCrFaO7A/* $FF was: $r8$lambda$au-wCD__kXRb1mKOjRrwCrFaO7A*/(DeviceCreateEditScheduleDialogFragment var0, DeviceCreateEditScheduleViewModel.PurifierMode var1) {
      return configureControls$lambda$14(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$bF3LlJl5qUmanInPWIqoc5s8jSI(DeviceCreateEditScheduleDialogFragment var0, Calendar var1) {
      return configureTimePicker$lambda$8$lambda$7$lambda$6(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$gBexYwVxvK8cH9S42Nm4ONQdK0U(DeviceCreateEditScheduleDialogFragment var0, FanSpeedEnum var1) {
      return configureControls$lambda$12(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$gsWgbGvG3AfrUjFBuLgrAxFkt_0/* $FF was: $r8$lambda$gsWgbGvG3AfrUjFBuLgrAxFkt-0*/(DeviceCreateEditScheduleDialogFragment var0, View var1) {
      configureToolbar$lambda$31(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$kQQaQnt09_JedW7kKFfBgGn3b0M/* $FF was: $r8$lambda$kQQaQnt09-JedW7kKFfBgGn3b0M*/(DeviceCreateEditScheduleDialogFragment var0, View var1) {
      configureTimePicker$lambda$5(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$mdULw_gOkRX3v438nJf6KZ9_IR8/* $FF was: $r8$lambda$mdULw_gOkRX3v438nJf6KZ9-IR8*/(DeviceCreateEditScheduleDialogFragment var0, View var1) {
      configureToolbar$lambda$27(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$ouYCWokq5uTrRE3N9Nq2L6TpJ9Y(DeviceCreateEditScheduleDialogFragment var0, Calendar var1) {
      return configureTimePicker$lambda$5$lambda$4$lambda$3(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$sbQFkBBsbCGPWHcfFcBek7QQnQg(DeviceCreateEditScheduleDialogFragment var0, FanSpeedEnum var1) {
      return configureControls$lambda$15(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$vt3Ru_PRtpHgyULTKyir29wyLjA/* $FF was: $r8$lambda$vt3Ru-PRtpHgyULTKyir29wyLjA*/(DeviceCreateEditScheduleDialogFragment var0, String var1) {
      return configureCustomSchedule$lambda$23(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$xjWCCTcB7xjTTXc5aY5CmEExql0(DeviceCreateEditScheduleDialogFragment var0, Device var1) {
      return configureControls$lambda$20(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$yEyutNQRu6kvFiQ_yexlrqQchnU/* $FF was: $r8$lambda$yEyutNQRu6kvFiQ-yexlrqQchnU*/(DeviceCreateEditScheduleDialogFragment var0, View var1) {
      configureDelete$lambda$37(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$yo66_joy_lEzD0vOl5h2PttEIJY(DeviceCreateEditScheduleDialogFragment var0, FanSpeedEnum var1) {
      return configureControls$lambda$10(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$yrL47CF8FWi_WXwYSEEfigXoFE0/* $FF was: $r8$lambda$yrL47CF8FWi-WXwYSEEfigXoFE0*/(DeviceCreateEditScheduleDialogFragment var0, boolean var1) {
      return configureDelete$lambda$37$lambda$36$lambda$35(var0, var1);
   }

   private final void bindViewModeltoView() {
      DialogfragmentDeviceCreateEditScheduleBinding var3 = this.viewDataBinding;
      Object var2 = null;
      DialogfragmentDeviceCreateEditScheduleBinding var1 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var1 = null;
      }

      var1.textViewSelectedDays.setText((CharSequence)this.getViewModel().getDisplayRepeat());
      var3 = this.viewDataBinding;
      var1 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var1 = null;
      }

      var1.buttonStartTime.setText((CharSequence)this.getViewModel().getDisplayStartTime());
      var3 = this.viewDataBinding;
      var1 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var1 = null;
      }

      var1.buttonEndTime.setText((CharSequence)this.getViewModel().getDisplayEndTime());
      var1 = this.viewDataBinding;
      if (var1 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var1 = (DialogfragmentDeviceCreateEditScheduleBinding)var2;
      }

      var1.editTextLabel.setText((CharSequence)this.getViewModel().getDisplayLabel());
   }

   private final void configureControls() {
      this.setOnStartAdapter(new DeviceScheduleInstructionAdapter(false, this.getViewModel().getPurifierMode(), this.getViewModel().getStartFanSpeed(), this.getViewModel().getStartBrightness(), new DeviceCreateEditScheduleDialogFragment$$ExternalSyntheticLambda21(this), new DeviceCreateEditScheduleDialogFragment$$ExternalSyntheticLambda22(this), new DeviceCreateEditScheduleDialogFragment$$ExternalSyntheticLambda23(this)));
      this.setOnEndAdapter(new DeviceScheduleAfterInstructionAdapter(this.getViewModel().getEndFanSpeed(), this.getViewModel().getEndBrightness(), new DeviceCreateEditScheduleDialogFragment$$ExternalSyntheticLambda24(this), new DeviceCreateEditScheduleDialogFragment$$ExternalSyntheticLambda25(this)));
      this.setOnCustomAdapter(new DeviceScheduleInstructionAdapter(true, this.getViewModel().getScheduleEndCustomMode(), this.getViewModel().getScheduleEndCustomFanSpeed(), this.getViewModel().getScheduleEndCustomBrightness(), new DeviceCreateEditScheduleDialogFragment$$ExternalSyntheticLambda1(this), new DeviceCreateEditScheduleDialogFragment$$ExternalSyntheticLambda2(this), new DeviceCreateEditScheduleDialogFragment$$ExternalSyntheticLambda3(this)));
      DialogfragmentDeviceCreateEditScheduleBinding var3 = this.viewDataBinding;
      Object var2 = null;
      DialogfragmentDeviceCreateEditScheduleBinding var1 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var1 = null;
      }

      RecyclerView var4 = var1.recyclerViewStartSchedule;
      var4.setAdapter(this.getOnStartAdapter());
      var4.setLayoutManager((RecyclerView.LayoutManager)(new LinearLayoutManager(var4.getContext(), 1, false)));
      var4.setNestedScrollingEnabled(false);
      var3 = this.viewDataBinding;
      DialogfragmentDeviceCreateEditScheduleBinding var5 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var5 = null;
      }

      RecyclerView var6 = var5.recyclerViewEndSchedule;
      var6.setAdapter(this.getOnEndAdapter());
      var6.setLayoutManager((RecyclerView.LayoutManager)(new LinearLayoutManager(var6.getContext(), 1, false)));
      var6.setNestedScrollingEnabled(false);
      DialogfragmentDeviceCreateEditScheduleBinding var7 = this.viewDataBinding;
      if (var7 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var7 = (DialogfragmentDeviceCreateEditScheduleBinding)var2;
      }

      RecyclerView var8 = var7.recyclerViewCustomSchedule;
      var8.setAdapter(this.getOnCustomAdapter());
      var8.setLayoutManager((RecyclerView.LayoutManager)(new LinearLayoutManager(var8.getContext(), 1, false)));
      var8.setNestedScrollingEnabled(false);
      this.getViewModel().getLiveDevice().observe(this.getViewLifecycleOwner(), new Observer(new DeviceCreateEditScheduleDialogFragment$$ExternalSyntheticLambda4(this)) {
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
      this.getViewModel().getLivePurifierMode().observe(this.getViewLifecycleOwner(), new Observer(new DeviceCreateEditScheduleDialogFragment$$ExternalSyntheticLambda5(this)) {
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

   private static final Unit configureControls$lambda$10(DeviceCreateEditScheduleDialogFragment var0, FanSpeedEnum var1) {
      Intrinsics.checkNotNullParameter(var1, "it");
      var0.getViewModel().setStartFanSpeed(var1);
      return Unit.INSTANCE;
   }

   private static final Unit configureControls$lambda$11(DeviceCreateEditScheduleDialogFragment var0, Object var1) {
      Intrinsics.checkNotNullParameter(var1, "it");
      var0.getViewModel().setStartBrightness(var1);
      return Unit.INSTANCE;
   }

   private static final Unit configureControls$lambda$12(DeviceCreateEditScheduleDialogFragment var0, FanSpeedEnum var1) {
      Intrinsics.checkNotNullParameter(var1, "it");
      var0.getViewModel().setEndFanSpeed(var1);
      return Unit.INSTANCE;
   }

   private static final Unit configureControls$lambda$13(DeviceCreateEditScheduleDialogFragment var0, Object var1) {
      Intrinsics.checkNotNullParameter(var1, "it");
      var0.getViewModel().setEndBrightness(var1);
      return Unit.INSTANCE;
   }

   private static final Unit configureControls$lambda$14(DeviceCreateEditScheduleDialogFragment var0, DeviceCreateEditScheduleViewModel.PurifierMode var1) {
      Intrinsics.checkNotNullParameter(var1, "it");
      var0.getViewModel().setScheduleEndCustomMode(var1);
      return Unit.INSTANCE;
   }

   private static final Unit configureControls$lambda$15(DeviceCreateEditScheduleDialogFragment var0, FanSpeedEnum var1) {
      Intrinsics.checkNotNullParameter(var1, "it");
      var0.getViewModel().setScheduleEndCustomFanSpeed(var1);
      return Unit.INSTANCE;
   }

   private static final Unit configureControls$lambda$16(DeviceCreateEditScheduleDialogFragment var0, Object var1) {
      Intrinsics.checkNotNullParameter(var1, "it");
      var0.getViewModel().setScheduleEndCustomBrightness(var1);
      return Unit.INSTANCE;
   }

   private static final Unit configureControls$lambda$20(DeviceCreateEditScheduleDialogFragment var0, Device var1) {
      var0.getOnStartAdapter().setDevice(var1);
      var0.getOnCustomAdapter().setDevice(var1);
      var0.getOnEndAdapter().setDevice(var1);
      return Unit.INSTANCE;
   }

   private static final Unit configureControls$lambda$21(DeviceCreateEditScheduleDialogFragment var0, DeviceCreateEditScheduleViewModel.PurifierMode var1) {
      DeviceScheduleAfterInstructionAdapter var2 = var0.getOnEndAdapter();
      Intrinsics.checkNotNull(var1);
      var2.setMode(var1);
      var0.updateTimePickerWithPurifyMode(var1);
      return Unit.INSTANCE;
   }

   private static final Unit configureControls$lambda$9(DeviceCreateEditScheduleDialogFragment var0, DeviceCreateEditScheduleViewModel.PurifierMode var1) {
      Intrinsics.checkNotNullParameter(var1, "it");
      var0.getViewModel().setPurifierMode(var1);
      return Unit.INSTANCE;
   }

   private final void configureCustomSchedule() {
      if (this.shouldShowCustomSchedule()) {
         DialogfragmentDeviceCreateEditScheduleBinding var2 = this.viewDataBinding;
         DialogfragmentDeviceCreateEditScheduleBinding var1 = var2;
         if (var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            var1 = null;
         }

         var1.radioGroupCustomScheduleSettings.setOnCheckedChangeListener(new DeviceCreateEditScheduleDialogFragment$$ExternalSyntheticLambda11(this));
         this.getViewModel().getScheduleEndType().observe(this.getViewLifecycleOwner(), new Observer(new DeviceCreateEditScheduleDialogFragment$$ExternalSyntheticLambda18(this)) {
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
   }

   private static final void configureCustomSchedule$lambda$22(DeviceCreateEditScheduleDialogFragment var0, RadioGroup var1, int var2) {
      if (var2 == R.id.radio_button_previous) {
         var0.getViewModel().getScheduleEndType().setValue("previous");
      } else {
         if (var2 == R.id.radio_button_custom) {
            var0.getViewModel().getScheduleEndType().setValue("custom");
         }

      }
   }

   private static final Unit configureCustomSchedule$lambda$23(DeviceCreateEditScheduleDialogFragment var0, String var1) {
      Intrinsics.checkNotNull(var1);
      boolean var2 = Intrinsics.areEqual(var1, "previous");
      Object var4 = null;
      Object var3 = null;
      if (var2) {
         DialogfragmentDeviceCreateEditScheduleBinding var15 = var0.viewDataBinding;
         DialogfragmentDeviceCreateEditScheduleBinding var7 = var15;
         if (var15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            var7 = null;
         }

         var7.radioGroupCustomScheduleSettings.check(R.id.radio_button_previous);
         var15 = var0.viewDataBinding;
         var7 = var15;
         if (var15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            var7 = null;
         }

         RecyclerView var9 = var7.recyclerViewCustomSchedule;
         Intrinsics.checkNotNullExpressionValue(var9, "recyclerViewCustomSchedule");
         ViewExtensionsKt.hide((View)var9);
         DialogfragmentDeviceCreateEditScheduleBinding var5 = var0.viewDataBinding;
         if (var5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            var5 = (DialogfragmentDeviceCreateEditScheduleBinding)var3;
         }

         var5.textviewCustomScheduleDescription.setText(com.blueair.viewcore.R.string.schedule_previous_description);
      } else if (Intrinsics.areEqual(var1, "custom")) {
         DialogfragmentDeviceCreateEditScheduleBinding var13 = var0.viewDataBinding;
         DialogfragmentDeviceCreateEditScheduleBinding var10 = var13;
         if (var13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            var10 = null;
         }

         var10.radioGroupCustomScheduleSettings.check(R.id.radio_button_custom);
         var13 = var0.viewDataBinding;
         var10 = var13;
         if (var13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            var10 = null;
         }

         RecyclerView var12 = var10.recyclerViewCustomSchedule;
         Intrinsics.checkNotNullExpressionValue(var12, "recyclerViewCustomSchedule");
         ViewExtensionsKt.show$default((View)var12, false, 1, (Object)null);
         DialogfragmentDeviceCreateEditScheduleBinding var6 = var0.viewDataBinding;
         if (var6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            var6 = (DialogfragmentDeviceCreateEditScheduleBinding)var4;
         }

         var6.textviewCustomScheduleDescription.setText(com.blueair.viewcore.R.string.schedule_custom_description);
      }

      return Unit.INSTANCE;
   }

   private final void configureDelete() {
      if (this.getViewModel().getState() == DeviceCreateEditScheduleViewModel.State.MODIFY) {
         DialogfragmentDeviceCreateEditScheduleBinding var3 = this.viewDataBinding;
         Object var2 = null;
         DialogfragmentDeviceCreateEditScheduleBinding var1 = var3;
         if (var3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            var1 = null;
         }

         MaterialButton var4 = var1.buttonDeleteSchedule;
         Intrinsics.checkNotNullExpressionValue(var4, "buttonDeleteSchedule");
         ViewExtensionsKt.show$default((View)var4, false, 1, (Object)null);
         DialogfragmentDeviceCreateEditScheduleBinding var5 = this.viewDataBinding;
         if (var5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            var5 = (DialogfragmentDeviceCreateEditScheduleBinding)var2;
         }

         var5.buttonDeleteSchedule.setOnClickListener(new DeviceCreateEditScheduleDialogFragment$$ExternalSyntheticLambda6(this));
      }

   }

   private static final void configureDelete$lambda$37(DeviceCreateEditScheduleDialogFragment var0, View var1) {
      FragmentManager var2 = var0.getChildFragmentManager();
      Intrinsics.checkNotNullExpressionValue(var2, "getChildFragmentManager(...)");
      Intrinsics.checkNotNullExpressionValue("ConfirmationDialogCentered", "getSimpleName(...)");
      DialogFragment var3;
      if (!(var2.findFragmentByTag("ConfirmationDialogCentered") instanceof ConfirmationDialogCentered) && !var2.isStateSaved()) {
         var3 = ConfirmationDialogCentered.Companion.newInstance$default(ConfirmationDialogCentered.Companion, com.blueair.viewcore.R.string.delete_schedule_title, com.blueair.viewcore.R.string.delete_schedule_content, com.blueair.viewcore.R.string.delete_schedule_confirm, com.blueair.viewcore.R.string.btn_cancel, true, false, false, (String[])null, 224, (Object)null);
         ((DialogFragment)var3).show(var2, "ConfirmationDialogCentered");
      } else {
         var3 = null;
      }

      var3 = var3;
      if (var3 != null) {
         FragmentExtensionsKt.setFragmentResultListenerWithClear((Fragment)var3, "CONFIRMATION", new DeviceCreateEditScheduleDialogFragment$$ExternalSyntheticLambda20(var0));
      }

   }

   private static final Unit configureDelete$lambda$37$lambda$36(DeviceCreateEditScheduleDialogFragment var0, String var1, Bundle var2) {
      Intrinsics.checkNotNullParameter(var1, "<unused var>");
      Intrinsics.checkNotNullParameter(var2, "result");
      if (var2.getBoolean("IS_CONFIRMED")) {
         var0.getViewModel().delete(new DeviceCreateEditScheduleDialogFragment$$ExternalSyntheticLambda19(var0));
      }

      return Unit.INSTANCE;
   }

   private static final Unit configureDelete$lambda$37$lambda$36$lambda$35(DeviceCreateEditScheduleDialogFragment var0, boolean var1) {
      if (var1) {
         Function1 var2 = var0.onDismiss;
         if (var2 != null) {
            var2.invoke(true);
         }

         var0.dismiss();
      }

      return Unit.INSTANCE;
   }

   private final void configureRepeat() {
      this.setDaysOfWeekAdapter(new DaysOfWeekSelectorAdapter(new DeviceCreateEditScheduleDialogFragment$$ExternalSyntheticLambda7(this)));
      this.getDaysOfWeekAdapter().setSelectedSet(CollectionsKt.toMutableSet((Iterable)this.getViewModel().getRepeat()));
      DialogfragmentDeviceCreateEditScheduleBinding var3 = this.viewDataBinding;
      Object var2 = null;
      DialogfragmentDeviceCreateEditScheduleBinding var1 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var1 = null;
      }

      RecyclerView var4 = var1.recyclerViewDayPicker;
      var4.setAdapter(this.getDaysOfWeekAdapter());
      var4.setLayoutManager((RecyclerView.LayoutManager)(new LinearLayoutManager(var4.getContext(), 1, false)));
      var4.setNestedScrollingEnabled(false);
      DialogfragmentDeviceCreateEditScheduleBinding var5 = this.viewDataBinding;
      if (var5 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var5 = (DialogfragmentDeviceCreateEditScheduleBinding)var2;
      }

      var5.textViewSelectedDays.setOnClickListener(new DeviceCreateEditScheduleDialogFragment$$ExternalSyntheticLambda8(this));
   }

   private static final Unit configureRepeat$lambda$24(DeviceCreateEditScheduleDialogFragment var0, Set var1) {
      Intrinsics.checkNotNullParameter(var1, "it");
      var0.getViewModel().setRepeat(var1);
      var0.bindViewModeltoView();
      return Unit.INSTANCE;
   }

   private static final void configureRepeat$lambda$26(DeviceCreateEditScheduleDialogFragment var0, View var1) {
      DialogfragmentDeviceCreateEditScheduleBinding var3 = var0.viewDataBinding;
      Object var2 = null;
      DialogfragmentDeviceCreateEditScheduleBinding var8 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var8 = null;
      }

      RecyclerView var9 = var8.recyclerViewDayPicker;
      Intrinsics.checkNotNullExpressionValue(var9, "recyclerViewDayPicker");
      if (((View)var9).getVisibility() == 0) {
         var3 = var0.viewDataBinding;
         DialogfragmentDeviceCreateEditScheduleBinding var12 = var3;
         if (var3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            var12 = null;
         }

         var12.textViewSelectedDays.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, com.blueair.viewcore.R.drawable.ic_chevron_down_marineblue, 0);
         DialogfragmentDeviceCreateEditScheduleBinding var6 = var0.viewDataBinding;
         if (var6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            var6 = (DialogfragmentDeviceCreateEditScheduleBinding)var2;
         }

         RecyclerView var7 = var6.recyclerViewDayPicker;
         Intrinsics.checkNotNullExpressionValue(var7, "recyclerViewDayPicker");
         ViewExtensionsKt.hide((View)var7);
      } else {
         DialogfragmentDeviceCreateEditScheduleBinding var13 = var0.viewDataBinding;
         DialogfragmentDeviceCreateEditScheduleBinding var10 = var13;
         if (var13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            var10 = null;
         }

         var10.textViewSelectedDays.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, com.blueair.viewcore.R.drawable.ic_chevron_up_marineblue, 0);
         var10 = var0.viewDataBinding;
         DialogfragmentDeviceCreateEditScheduleBinding var4 = var10;
         if (var10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            var4 = null;
         }

         RecyclerView var5 = var4.recyclerViewDayPicker;
         Intrinsics.checkNotNullExpressionValue(var5, "recyclerViewDayPicker");
         ViewExtensionsKt.show$default((View)var5, false, 1, (Object)null);
      }
   }

   private final void configureTimePicker() {
      DialogfragmentDeviceCreateEditScheduleBinding var3 = this.viewDataBinding;
      Object var2 = null;
      DialogfragmentDeviceCreateEditScheduleBinding var1 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var1 = null;
      }

      ViewCompat.setAccessibilityDelegate((View)var1.buttonStartTime, ViewUtils.INSTANCE.createTimePickerShowAccessibilityDelegate(com.blueair.viewcore.R.string.schedule_start_time_content_description));
      var3 = this.viewDataBinding;
      var1 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var1 = null;
      }

      var1.buttonStartTime.setOnClickListener(new DeviceCreateEditScheduleDialogFragment$$ExternalSyntheticLambda16(this));
      var3 = this.viewDataBinding;
      var1 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var1 = null;
      }

      ViewCompat.setAccessibilityDelegate((View)var1.buttonEndTime, ViewUtils.INSTANCE.createTimePickerShowAccessibilityDelegate(com.blueair.viewcore.R.string.schedule_end_time_content_description));
      var1 = this.viewDataBinding;
      if (var1 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var1 = (DialogfragmentDeviceCreateEditScheduleBinding)var2;
      }

      var1.buttonEndTime.setOnClickListener(new DeviceCreateEditScheduleDialogFragment$$ExternalSyntheticLambda17(this));
   }

   private static final void configureTimePicker$lambda$5(DeviceCreateEditScheduleDialogFragment var0, View var1) {
      FragmentManager var2 = var0.getChildFragmentManager();
      Intrinsics.checkNotNullExpressionValue(var2, "getChildFragmentManager(...)");
      Intrinsics.checkNotNullExpressionValue("TimePickerDialogFragment", "getSimpleName(...)");
      if (!(var2.findFragmentByTag("TimePickerDialogFragment") instanceof TimePickerDialogFragment) && !var2.isStateSaved()) {
         ((DialogFragment)(new TimePickerDialogFragment(var0.getViewModel().getStartTime(), new DeviceCreateEditScheduleDialogFragment$$ExternalSyntheticLambda10(var0)))).show(var2, "TimePickerDialogFragment");
      }

   }

   private static final Unit configureTimePicker$lambda$5$lambda$4$lambda$3(DeviceCreateEditScheduleDialogFragment var0, Calendar var1) {
      Intrinsics.checkNotNullParameter(var1, "it");
      var0.getViewModel().setStartTime(var1);
      var0.bindViewModeltoView();
      return Unit.INSTANCE;
   }

   private static final void configureTimePicker$lambda$8(DeviceCreateEditScheduleDialogFragment var0, View var1) {
      FragmentManager var2 = var0.getChildFragmentManager();
      Intrinsics.checkNotNullExpressionValue(var2, "getChildFragmentManager(...)");
      Intrinsics.checkNotNullExpressionValue("TimePickerDialogFragment", "getSimpleName(...)");
      if (!(var2.findFragmentByTag("TimePickerDialogFragment") instanceof TimePickerDialogFragment) && !var2.isStateSaved()) {
         ((DialogFragment)(new TimePickerDialogFragment(var0.getViewModel().getEndTime(), new DeviceCreateEditScheduleDialogFragment$$ExternalSyntheticLambda0(var0)))).show(var2, "TimePickerDialogFragment");
      }

   }

   private static final Unit configureTimePicker$lambda$8$lambda$7$lambda$6(DeviceCreateEditScheduleDialogFragment var0, Calendar var1) {
      Intrinsics.checkNotNullParameter(var1, "it");
      var0.getViewModel().setEndTime(var1);
      var0.bindViewModeltoView();
      return Unit.INSTANCE;
   }

   private final void configureToolbar() {
      DialogfragmentDeviceCreateEditScheduleBinding var3 = this.viewDataBinding;
      Object var2 = null;
      DialogfragmentDeviceCreateEditScheduleBinding var1 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var1 = null;
      }

      var1.title.setText((CharSequence)this.getViewModel().getTitle());
      var3 = this.viewDataBinding;
      var1 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var1 = null;
      }

      var1.cancelBtn.setOnClickListener(new DeviceCreateEditScheduleDialogFragment$$ExternalSyntheticLambda12(this));
      var1 = this.viewDataBinding;
      if (var1 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var1 = (DialogfragmentDeviceCreateEditScheduleBinding)var2;
      }

      var1.saveBtn.setOnClickListener(new DeviceCreateEditScheduleDialogFragment$$ExternalSyntheticLambda13(this));
      this.getViewModel().getSaveBtnEnabled().observe(this.getViewLifecycleOwner(), new Observer(new DeviceCreateEditScheduleDialogFragment$$ExternalSyntheticLambda14(this)) {
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
      this.getViewModel().isStartTimeSameAsEndTime().observe(this.getViewLifecycleOwner(), new Observer(new DeviceCreateEditScheduleDialogFragment$$ExternalSyntheticLambda15(this)) {
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

   private static final void configureToolbar$lambda$27(DeviceCreateEditScheduleDialogFragment var0, View var1) {
      var0.dismiss();
   }

   private static final void configureToolbar$lambda$31(DeviceCreateEditScheduleDialogFragment var0, View var1) {
      BaseFragmentInterface var2 = var0;
      DialogfragmentDeviceCreateEditScheduleBinding var4 = null;
      BaseFragmentInterface$_CC.showProgress$default(var2, false, 1, (Object)null);
      DeviceCreateEditScheduleViewModel var3 = var0.getViewModel();
      DialogfragmentDeviceCreateEditScheduleBinding var5 = var0.viewDataBinding;
      if (var5 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
      } else {
         var4 = var5;
      }

      var3.setLabel(String.valueOf(var4.editTextLabel.getText()));
      var0.getViewModel().onComplete(new DeviceCreateEditScheduleDialogFragment$$ExternalSyntheticLambda9(var0));
   }

   private static final Unit configureToolbar$lambda$31$lambda$30(DeviceCreateEditScheduleDialogFragment var0, boolean var1, boolean var2) {
      Context var3 = var0.getContext();
      if (var3 != null) {
         var0.hideProgress(var3);
      }

      if (var1) {
         FragmentManager var4 = var0.getChildFragmentManager();
         Intrinsics.checkNotNullExpressionValue(var4, "getChildFragmentManager(...)");
         Intrinsics.checkNotNullExpressionValue("ConfirmationDialogCentered", "getSimpleName(...)");
         if (!(var4.findFragmentByTag("ConfirmationDialogCentered") instanceof ConfirmationDialogCentered) && !var4.isStateSaved()) {
            ((DialogFragment)ConfirmationDialogCentered.Companion.newInstance$default(ConfirmationDialogCentered.Companion, com.blueair.viewcore.R.string.overlap_title, com.blueair.viewcore.R.string.overlap_content, com.blueair.viewcore.R.string.btn_cancel, (Integer)null, false, false, false, (String[])null, 240, (Object)null)).show(var4, "ConfirmationDialogCentered");
         }

         return Unit.INSTANCE;
      } else {
         if (var2) {
            Function1 var5 = var0.onDismiss;
            if (var5 != null) {
               var5.invoke(false);
            }

            var0.dismissAllowingStateLoss();
         }

         return Unit.INSTANCE;
      }
   }

   private static final Unit configureToolbar$lambda$32(DeviceCreateEditScheduleDialogFragment var0, Boolean var1) {
      DialogfragmentDeviceCreateEditScheduleBinding var2 = var0.viewDataBinding;
      DialogfragmentDeviceCreateEditScheduleBinding var3 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var3 = null;
      }

      MaterialButton var4 = var3.saveBtn;
      Intrinsics.checkNotNull(var1);
      var4.setEnabled(var1);
      return Unit.INSTANCE;
   }

   private static final Unit configureToolbar$lambda$33(DeviceCreateEditScheduleDialogFragment var0, Boolean var1) {
      boolean var2 = var1;
      Object var3 = null;
      Object var4 = null;
      if (var2) {
         DialogfragmentDeviceCreateEditScheduleBinding var9 = var0.viewDataBinding;
         DialogfragmentDeviceCreateEditScheduleBinding var5 = var9;
         if (var9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            var5 = null;
         }

         var5.buttonStartTime.setTextColor(ContextCompat.getColor(var0.requireContext(), com.blueair.viewcore.R.color.error_red));
         var5 = var0.viewDataBinding;
         if (var5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            var5 = (DialogfragmentDeviceCreateEditScheduleBinding)var4;
         }

         var5.buttonEndTime.setTextColor(ContextCompat.getColor(var0.requireContext(), com.blueair.viewcore.R.color.error_red));
      } else {
         DialogfragmentDeviceCreateEditScheduleBinding var10 = var0.viewDataBinding;
         DialogfragmentDeviceCreateEditScheduleBinding var7 = var10;
         if (var10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            var7 = null;
         }

         var7.buttonStartTime.setTextColor(ContextCompat.getColor(var0.requireContext(), com.blueair.viewcore.R.color.colorPrimaryText));
         var7 = var0.viewDataBinding;
         if (var7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            var7 = (DialogfragmentDeviceCreateEditScheduleBinding)var3;
         }

         var7.buttonEndTime.setTextColor(ContextCompat.getColor(var0.requireContext(), com.blueair.viewcore.R.color.colorPrimaryText));
      }

      return Unit.INSTANCE;
   }

   private final boolean shouldShowCustomSchedule() {
      return this.getDevice() instanceof HasBlueCloudFunctions;
   }

   private final boolean shouldShowEndSchedule() {
      return this.getDevice() instanceof HasBlueCloudFunctions ^ true;
   }

   private final boolean shouldShowLabelEditText() {
      return this.getDevice() instanceof HasBlueCloudFunctions;
   }

   private final void updateTimePickerWithPurifyMode(DeviceCreateEditScheduleViewModel.PurifierMode var1) {
      DeviceCreateEditScheduleViewModel.PurifierMode var4 = DeviceCreateEditScheduleViewModel.PurifierMode.DISINFECTION;
      Object var3 = null;
      Object var2 = null;
      if (var1 == var4) {
         DialogfragmentDeviceCreateEditScheduleBinding var10 = this.viewDataBinding;
         DialogfragmentDeviceCreateEditScheduleBinding var5 = var10;
         if (var10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            var5 = null;
         }

         var5.buttonEndTimeLayout.setAlpha(0.45F);
         var5 = this.viewDataBinding;
         if (var5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            var5 = (DialogfragmentDeviceCreateEditScheduleBinding)var2;
         }

         var5.buttonEndTimeLayout.setEnabled(false);
      } else {
         DialogfragmentDeviceCreateEditScheduleBinding var9 = this.viewDataBinding;
         DialogfragmentDeviceCreateEditScheduleBinding var7 = var9;
         if (var9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            var7 = null;
         }

         var7.buttonEndTimeLayout.setAlpha(1.0F);
         var7 = this.viewDataBinding;
         if (var7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            var7 = (DialogfragmentDeviceCreateEditScheduleBinding)var3;
         }

         var7.buttonEndTimeLayout.setEnabled(true);
      }

      this.bindViewModeltoView();
   }

   public void clearProgressFragment() {
      ProgressFragment$_CC.$default$clearProgressFragment(this);
   }

   public final DaysOfWeekSelectorAdapter getDaysOfWeekAdapter() {
      DaysOfWeekSelectorAdapter var1 = this.daysOfWeekAdapter;
      if (var1 != null) {
         return var1;
      } else {
         Intrinsics.throwUninitializedPropertyAccessException("daysOfWeekAdapter");
         return null;
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

   public final DeviceScheduleInstructionAdapter getOnCustomAdapter() {
      DeviceScheduleInstructionAdapter var1 = this.onCustomAdapter;
      if (var1 != null) {
         return var1;
      } else {
         Intrinsics.throwUninitializedPropertyAccessException("onCustomAdapter");
         return null;
      }
   }

   public final Function1 getOnDismiss() {
      return this.onDismiss;
   }

   public final DeviceScheduleAfterInstructionAdapter getOnEndAdapter() {
      DeviceScheduleAfterInstructionAdapter var1 = this.onEndAdapter;
      if (var1 != null) {
         return var1;
      } else {
         Intrinsics.throwUninitializedPropertyAccessException("onEndAdapter");
         return null;
      }
   }

   public final DeviceScheduleInstructionAdapter getOnStartAdapter() {
      DeviceScheduleInstructionAdapter var1 = this.onStartAdapter;
      if (var1 != null) {
         return var1;
      } else {
         Intrinsics.throwUninitializedPropertyAccessException("onStartAdapter");
         return null;
      }
   }

   public ProgressBlockerView getProgressBlockerView() {
      return this.progressBlockerView;
   }

   public ConstraintLayout getRootView() {
      DialogfragmentDeviceCreateEditScheduleBinding var2 = this.viewDataBinding;
      DialogfragmentDeviceCreateEditScheduleBinding var1 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var1 = null;
      }

      ConstraintLayout var3 = var1.rootLayout;
      Intrinsics.checkNotNullExpressionValue(var3, "rootLayout");
      return var3;
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

   public void hideProgress(Context var1) {
      ProgressFragment$_CC.$default$hideProgress(this, var1);
   }

   @Deprecated(
      message = "Deprecated in Java"
   )
   public void onActivityCreated(Bundle var1) {
      super.onActivityCreated(var1);
      Dialog var2 = this.getDialog();
      if (var2 != null) {
         Window var3 = var2.getWindow();
         if (var3 != null) {
            WindowManager.LayoutParams var4 = var3.getAttributes();
            if (var4 != null) {
               var4.windowAnimations = com.blueair.viewcore.R.style.dialog_animation;
            }
         }
      }

   }

   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.setStyle(0, com.blueair.viewcore.R.style.DialogTheme);
      var1 = this.getArguments();
      Device var3;
      if (var1 != null) {
         var3 = (Device)var1.getParcelable("device");
      } else {
         var3 = null;
      }

      if (var3 != null) {
         this.setDevice(var3);
      } else {
         throw new IllegalStateException("Required value was null.".toString());
      }
   }

   public Dialog onCreateDialog(Bundle var1) {
      Timber.Forest.d("DialogFragment: onCreateDialog", new Object[0]);
      Dialog var4 = new Dialog(this.requireContext());
      Timber.Forest var3 = Timber.Forest;
      StringBuilder var2 = new StringBuilder("onCreateDialog: dialog = ");
      var2.append(var4);
      var3.d(var2.toString(), new Object[0]);
      FragmentActivity var5 = this.getActivity();
      if (var5 != null) {
         Window var6 = var4.getWindow();
         if (var6 != null) {
            var6.setBackgroundDrawable(ContextCompat.getDrawable((Context)var5, com.blueair.viewcore.R.drawable.top_rounded_rectangle_white));
         }
      }

      return var4;
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      Intrinsics.checkNotNullParameter(var1, "inflater");
      DialogfragmentDeviceCreateEditScheduleBinding var21 = DialogfragmentDeviceCreateEditScheduleBinding.inflate(var1, var2, false);
      Intrinsics.checkNotNullExpressionValue(var21, "inflate(...)");
      var21.setDeviceCreateEditScheduleViewModel((DeviceCreateEditScheduleViewModel)((BaseViewModel)(new ViewModelProvider((ViewModelStoreOwner)(this))).get(DeviceCreateEditScheduleViewModel.class)));
      var21.setLifecycleOwner((LifecycleOwner)this);
      this.viewDataBinding = var21;
      Object var20 = null;
      DialogfragmentDeviceCreateEditScheduleBinding var4 = var21;
      if (var21 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var4 = null;
      }

      ViewCompat.setAccessibilityDelegate((View)var4.textViewSelectedDays, new AccessibilityDelegateCompat() {
         public void onInitializeAccessibilityNodeInfo(View var1, AccessibilityNodeInfoCompat var2) {
            Intrinsics.checkNotNullParameter(var1, "host");
            Intrinsics.checkNotNullParameter(var2, "info");
            super.onInitializeAccessibilityNodeInfo(var1, var2);
            var2.setRoleDescription((CharSequence)var1.getResources().getString(com.blueair.viewcore.R.string.list_role_description));
            var2.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16, (CharSequence)var1.getResources().getString(com.blueair.viewcore.R.string.change_action_description)));
         }
      });
      var21 = this.viewDataBinding;
      var4 = var21;
      if (var21 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var4 = null;
      }

      DeviceCreateEditScheduleViewModel var6 = var4.getDeviceCreateEditScheduleViewModel();
      if (var6 != null) {
         this.setViewModel(var6);
         DeviceCreateEditScheduleViewModel var23 = this.getViewModel();
         Context var7 = this.requireContext();
         Intrinsics.checkNotNullExpressionValue(var7, "requireContext(...)");
         var23.initTimeFormat(var7);
         Timber.Forest var24 = Timber.Forest;
         StringBuilder var8 = new StringBuilder("onViewCreated: viewModel = ");
         var8.append(this.getViewModel());
         var8.append(",  device = ");
         var8.append(this.getDevice());
         var24.d(var8.toString(), new Object[0]);
         this.getViewModel().setDevice(this.getDevice());
         DeviceCreateEditScheduleViewModel var25 = this.getViewModel();
         Bundle var9 = this.getArguments();
         DeviceScheduleMerged var10;
         if (var9 != null) {
            var10 = (DeviceScheduleMerged)var9.getParcelable("schedule_merged");
         } else {
            var10 = null;
         }

         var25.setEditingSchedule(var10);
         DialogfragmentDeviceCreateEditScheduleBinding var26 = this.viewDataBinding;
         DialogfragmentDeviceCreateEditScheduleBinding var11 = var26;
         if (var26 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            var11 = null;
         }

         this.setProgressBlockerView(var11.progressView);
         var26 = this.viewDataBinding;
         var11 = var26;
         if (var26 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            var11 = null;
         }

         Group var13 = var11.groupLabelText;
         Intrinsics.checkNotNullExpressionValue(var13, "groupLabelText");
         ViewExtensionsKt.show((View)var13, this.shouldShowLabelEditText());
         var26 = this.viewDataBinding;
         DialogfragmentDeviceCreateEditScheduleBinding var14 = var26;
         if (var26 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            var14 = null;
         }

         Group var15 = var14.groupAfterSchedule;
         Intrinsics.checkNotNullExpressionValue(var15, "groupAfterSchedule");
         ViewExtensionsKt.show((View)var15, this.shouldShowEndSchedule());
         var26 = this.viewDataBinding;
         DialogfragmentDeviceCreateEditScheduleBinding var16 = var26;
         if (var26 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            var16 = null;
         }

         Group var17 = var16.groupCustomSchedule;
         Intrinsics.checkNotNullExpressionValue(var17, "groupCustomSchedule");
         ViewExtensionsKt.show((View)var17, this.shouldShowCustomSchedule());
         DialogfragmentDeviceCreateEditScheduleBinding var18 = this.viewDataBinding;
         if (var18 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            var18 = (DialogfragmentDeviceCreateEditScheduleBinding)var20;
         }

         View var19 = var18.getRoot();
         Intrinsics.checkNotNullExpressionValue(var19, "getRoot(...)");
         return var19;
      } else {
         throw new IllegalStateException("Required value was null.".toString());
      }
   }

   public void onDestroy() {
      super.onDestroy();
      this.clearProgressFragment();
   }

   public void onStart() {
      super.onStart();
      Dialog var2 = this.getDialog();
      if (var2 != null) {
         Point var3;
         Display var5;
         label24: {
            var3 = new Point();
            Window var1 = var2.getWindow();
            if (var1 != null) {
               WindowManager var4 = var1.getWindowManager();
               if (var4 != null) {
                  var5 = var4.getDefaultDisplay();
                  break label24;
               }
            }

            var5 = null;
         }

         if (var5 != null) {
            var5.getSize(var3);
         }

         Window var6 = var2.getWindow();
         if (var6 != null) {
            var6.setLayout(-1, -1);
         }

         var6 = var2.getWindow();
         if (var6 != null) {
            var6.setGravity(80);
         }
      }

   }

   public void onStop() {
      Dialog var1 = this.getDialog();
      if (var1 != null) {
         Window var2 = var1.getWindow();
         if (var2 != null) {
            WindowManager.LayoutParams var3 = var2.getAttributes();
            if (var3 != null) {
               var3.windowAnimations = com.blueair.viewcore.R.style.dialog_animation_exit_only;
            }
         }
      }

      super.onStop();
   }

   public void onViewCreated(View var1, Bundle var2) {
      Intrinsics.checkNotNullParameter(var1, "view");
      super.onViewCreated(var1, var2);
      this.configureToolbar();
      this.configureTimePicker();
      this.configureControls();
      this.configureCustomSchedule();
      this.configureRepeat();
      this.configureDelete();
      this.bindViewModeltoView();
   }

   public final void setDaysOfWeekAdapter(DaysOfWeekSelectorAdapter var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.daysOfWeekAdapter = var1;
   }

   public final void setDevice(Device var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.device = var1;
   }

   public final void setOnCustomAdapter(DeviceScheduleInstructionAdapter var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.onCustomAdapter = var1;
   }

   public final void setOnDismiss(Function1 var1) {
      this.onDismiss = var1;
   }

   public final void setOnEndAdapter(DeviceScheduleAfterInstructionAdapter var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.onEndAdapter = var1;
   }

   public final void setOnStartAdapter(DeviceScheduleInstructionAdapter var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.onStartAdapter = var1;
   }

   public void setProgressBlockerView(ProgressBlockerView var1) {
      this.progressBlockerView = var1;
   }

   public void setViewModel(DeviceCreateEditScheduleViewModel var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.viewModel = var1;
   }

   public void showProgress(Context var1, boolean var2, Integer var3) {
      ProgressFragment$_CC.$default$showProgress(this, var1, var2, var3);
   }

   public void showProgress(boolean var1) {
      ProgressFragment$_CC.showProgress$default(this, this.getContext(), var1, (Integer)null, 4, (Object)null);
   }

   @Metadata(
      d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¨\u0006\n"},
      d2 = {"Lcom/blueair/devicedetails/dialog/DeviceCreateEditScheduleDialogFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/dialog/DeviceCreateEditScheduleDialogFragment;", "device", "Lcom/blueair/core/model/Device;", "mergedSchedule", "Lcom/blueair/core/model/DeviceScheduleMerged;", "devicedetails_otherRelease"},
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

      // $FF: synthetic method
      public static DeviceCreateEditScheduleDialogFragment newInstance$default(Companion var0, Device var1, DeviceScheduleMerged var2, int var3, Object var4) {
         if ((var3 & 2) != 0) {
            var2 = null;
         }

         return var0.newInstance(var1, var2);
      }

      public final DeviceCreateEditScheduleDialogFragment newInstance(Device var1, DeviceScheduleMerged var2) {
         Intrinsics.checkNotNullParameter(var1, "device");
         DeviceCreateEditScheduleDialogFragment var4 = new DeviceCreateEditScheduleDialogFragment();
         Bundle var3 = new Bundle();
         var3.putParcelable("device", var1);
         var3.putParcelable("schedule_merged", var2);
         var4.setArguments(var3);
         return var4;
      }
   }
}
