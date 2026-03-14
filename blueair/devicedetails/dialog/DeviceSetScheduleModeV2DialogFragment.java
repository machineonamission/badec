package com.blueair.devicedetails.dialog;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.os.BundleKt;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.blueair.core.model.Device;
import com.blueair.core.model.MainMode;
import com.blueair.devicedetails.adapter.DeviceScheduleModeV2Adapter;
import com.blueair.devicedetails.databinding.DialogfragmentDeviceSetScheduleModeV2Binding;
import com.blueair.devicedetails.util.DeviceControlUtils;
import com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel;
import com.blueair.viewcore.R;
import com.blueair.viewcore.dialog.BaseDialogFragment;
import com.blueair.viewcore.dialog.ConfirmationDialogLeftAligned;
import com.blueair.viewcore.utils.ModeIcon;
import com.blueair.viewcore.view.ShadowedRecyclerViewLayout;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import com.dd.ShadowLayout;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 *2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001*B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J$\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010\"\u001a\u00020\u0018H\u0002J\b\u0010#\u001a\u00020\u0018H\u0002J\b\u0010$\u001a\u00020\u0018H\u0002J\u001a\u0010%\u001a\u00020\u00182\u0006\u0010&\u001a\u00020\u001b2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010'\u001a\u00020\u0018H\u0016J\u0010\u0010(\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\u0011H\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0094D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\u0002X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u001e\u0010\u0015\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0017\u0012\u0004\u0012\u00020\u00180\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0019\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0017\u0012\u0004\u0012\u00020\u00180\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006+"},
   d2 = {"Lcom/blueair/devicedetails/dialog/DeviceSetScheduleModeV2DialogFragment;", "Lcom/blueair/viewcore/dialog/BaseDialogFragment;", "Lcom/blueair/devicedetails/viewmodel/DeviceCreateEditScheduleViewModel;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "binding", "Lcom/blueair/devicedetails/databinding/DialogfragmentDeviceSetScheduleModeV2Binding;", "viewModel", "getViewModel", "()Lcom/blueair/devicedetails/viewmodel/DeviceCreateEditScheduleViewModel;", "setViewModel", "(Lcom/blueair/devicedetails/viewmodel/DeviceCreateEditScheduleViewModel;)V", "isStartMode", "", "modesAdapter", "Lcom/blueair/devicedetails/adapter/DeviceScheduleModeV2Adapter;", "controlsAdapter", "modesAdapterActionListener", "Lkotlin/Function1;", "Lcom/blueair/devicedetails/adapter/DeviceScheduleModeV2Adapter$Action;", "", "controlsAdapterActionListener", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "configureAsStartMode", "configureAsEndMode", "updateStandByUI", "onViewCreated", "view", "onStart", "showProgress", "shouldShowProgress", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceSetScheduleModeV2DialogFragment extends BaseDialogFragment {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private static final String EXTRA_IS_START_MODE = "EXTRA_IS_START_MODE";
   private DialogfragmentDeviceSetScheduleModeV2Binding binding;
   private DeviceScheduleModeV2Adapter controlsAdapter;
   private final Function1 controlsAdapterActionListener = new DeviceSetScheduleModeV2DialogFragment$$ExternalSyntheticLambda2(this);
   private boolean isStartMode = true;
   private DeviceScheduleModeV2Adapter modesAdapter;
   private final Function1 modesAdapterActionListener = new DeviceSetScheduleModeV2DialogFragment$$ExternalSyntheticLambda1(this);
   private final String screenName = "device_details_schedule_mode";
   public DeviceCreateEditScheduleViewModel viewModel;

   // $FF: synthetic method
   public static Unit $r8$lambda$0cYOcjhmBR9usRgxdwrrLi49R4I(DeviceSetScheduleModeV2DialogFragment var0, DeviceScheduleModeV2Adapter.Action var1) {
      return controlsAdapterActionListener$lambda$3(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$O6TjzBj1JZzuq77IG6vVby8IC7k(DeviceSetScheduleModeV2DialogFragment var0, DeviceScheduleModeV2Adapter.Action var1) {
      return modesAdapterActionListener$lambda$0(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$OxtaN640bkUOpyoCYawuQjV3Pr0(DeviceSetScheduleModeV2DialogFragment var0, View var1) {
      configureAsStartMode$lambda$6$lambda$5(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$bkhYjX_MKRJop39XKVxfrNhnxJU(DeviceSetScheduleModeV2DialogFragment var0, View var1) {
      onViewCreated$lambda$11$lambda$9(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$vOLOQ0JDQw_7_wOcmZWwckv7sJU/* $FF was: $r8$lambda$vOLOQ0JDQw-7_wOcmZWwckv7sJU*/(DeviceSetScheduleModeV2DialogFragment var0, View var1) {
      onViewCreated$lambda$11$lambda$10(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$xLhqj_fLhz1fiCnqHCeyFwog3lc/* $FF was: $r8$lambda$xLhqj-fLhz1fiCnqHCeyFwog3lc*/(DeviceSetScheduleModeV2DialogFragment var0, View var1) {
      configureAsEndMode$lambda$8$lambda$7(var0, var1);
   }

   private final void configureAsEndMode() {
      DialogfragmentDeviceSetScheduleModeV2Binding var2 = this.binding;
      Object var3 = null;
      DialogfragmentDeviceSetScheduleModeV2Binding var1 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var1 = null;
      }

      var1.title.setText(R.string.select_end_mode);
      var1.btnDone.setText(R.string.btn_done);
      var1.btnDone.setOnClickListener(new DeviceSetScheduleModeV2DialogFragment$$ExternalSyntheticLambda0(this));
      String var4 = (String)this.getViewModel().getScheduleEndType().getValue();
      String var7 = var4;
      if (var4 == null) {
         var7 = "previous";
      }

      Device var14 = this.getViewModel().getDevice();
      Intrinsics.checkNotNull(var14);
      DeviceScheduleModeV2Adapter var15 = new DeviceScheduleModeV2Adapter(var14, DeviceScheduleModeV2Adapter.ControlGroup.MODES, false, var7, this.getViewModel().getScheduleEndCustomMainMode(), this.getViewModel().getScheduleEndCustomMode(), this.getViewModel().getScheduleEndCustomFanSpeed(), this.getViewModel().getScheduleEndCustomBrightness(), this.getViewModel().getScheduleEndCustomAutoRh(), this.getViewModel().getScheduleEndCustomHumMode(), this.getViewModel().getScheduleEndCustomHeatAutoTemp(), this.getViewModel().getScheduleEndCustomHeatEcoTemp(), this.getViewModel().getScheduleEndCustomOscillationEnabled(), this.modesAdapterActionListener);
      this.modesAdapter = var15;
      var15.setEndTypeHintClosedBefore(this.getViewModel().getScheduleEndTypeHintClosedBefore());
      Device var16 = this.getViewModel().getDevice();
      Intrinsics.checkNotNull(var16);
      this.controlsAdapter = new DeviceScheduleModeV2Adapter(var16, DeviceScheduleModeV2Adapter.ControlGroup.CONTROLS, false, var7, this.getViewModel().getScheduleEndCustomMainMode(), this.getViewModel().getScheduleEndCustomMode(), this.getViewModel().getScheduleEndCustomFanSpeed(), this.getViewModel().getScheduleEndCustomBrightness(), this.getViewModel().getScheduleEndCustomAutoRh(), this.getViewModel().getScheduleEndCustomHumMode(), this.getViewModel().getScheduleEndCustomHeatAutoTemp(), this.getViewModel().getScheduleEndCustomHeatEcoTemp(), this.getViewModel().getScheduleEndCustomOscillationEnabled(), this.controlsAdapterActionListener);
      DeviceScheduleModeV2Adapter var17 = this.modesAdapter;
      DeviceScheduleModeV2Adapter var8 = var17;
      if (var17 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("modesAdapter");
         var8 = null;
      }

      Function1 var5 = var8.getOnActionListener();
      var17 = this.modesAdapter;
      var8 = var17;
      if (var17 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("modesAdapter");
         var8 = null;
      }

      var5.invoke(new DeviceScheduleModeV2Adapter.Action.CUSTOM_TYPE_CHANGED(var8.getCustomType()));
      var17 = this.controlsAdapter;
      var8 = var17;
      if (var17 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("controlsAdapter");
         var8 = null;
      }

      var5 = var8.getOnActionListener();
      var17 = this.controlsAdapter;
      var8 = var17;
      if (var17 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("controlsAdapter");
         var8 = null;
      }

      var5.invoke(new DeviceScheduleModeV2Adapter.Action.ITEM_COUNT_CHANGED(var8.getItemCount()));
      RecyclerView var23 = var1.rvModeButtons;
      var17 = this.modesAdapter;
      var8 = var17;
      if (var17 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("modesAdapter");
         var8 = null;
      }

      var23.setAdapter(var8);
      RecyclerView var13 = var1.rvControlGroup.getRecyclerView();
      DeviceScheduleModeV2Adapter var6 = this.controlsAdapter;
      if (var6 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("controlsAdapter");
         var6 = (DeviceScheduleModeV2Adapter)var3;
      }

      var13.setAdapter(var6);
      this.updateStandByUI();
   }

   private static final void configureAsEndMode$lambda$8$lambda$7(DeviceSetScheduleModeV2DialogFragment var0, View var1) {
      MutableLiveData var4 = var0.getViewModel().getScheduleEndType();
      DeviceScheduleModeV2Adapter var3 = var0.modesAdapter;
      Object var2 = null;
      DeviceScheduleModeV2Adapter var5 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("modesAdapter");
         var5 = null;
      }

      var4.setValue(var5.getCustomType());
      DeviceCreateEditScheduleViewModel var24 = var0.getViewModel();
      var3 = var0.modesAdapter;
      var5 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("modesAdapter");
         var5 = null;
      }

      var24.setScheduleEndCustomMainMode(var5.getMainMode());
      var24 = var0.getViewModel();
      var3 = var0.modesAdapter;
      var5 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("modesAdapter");
         var5 = null;
      }

      var24.setScheduleEndCustomMode(var5.getMode());
      var24 = var0.getViewModel();
      var3 = var0.modesAdapter;
      var5 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("modesAdapter");
         var5 = null;
      }

      var24.setScheduleEndCustomHumMode(var5.getHumMode());
      var24 = var0.getViewModel();
      var3 = var0.controlsAdapter;
      var5 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("controlsAdapter");
         var5 = null;
      }

      var24.setScheduleEndCustomFanSpeed(var5.getFanSpeed());
      var24 = var0.getViewModel();
      var3 = var0.controlsAdapter;
      var5 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("controlsAdapter");
         var5 = null;
      }

      var24.setScheduleEndCustomBrightness(var5.getBrightness());
      var24 = var0.getViewModel();
      var3 = var0.controlsAdapter;
      var5 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("controlsAdapter");
         var5 = null;
      }

      var24.setScheduleEndCustomAutoRh(var5.getAutoRh());
      var24 = var0.getViewModel();
      var3 = var0.controlsAdapter;
      var5 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("controlsAdapter");
         var5 = null;
      }

      var24.setScheduleEndCustomHeatAutoTemp(var5.getHeatAutoTemp());
      var24 = var0.getViewModel();
      var3 = var0.controlsAdapter;
      var5 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("controlsAdapter");
         var5 = null;
      }

      var24.setScheduleEndCustomHeatEcoTemp(var5.getHeatEcoTmp());
      DeviceCreateEditScheduleViewModel var23 = var0.getViewModel();
      var5 = var0.controlsAdapter;
      if (var5 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("controlsAdapter");
         var5 = (DeviceScheduleModeV2Adapter)var2;
      }

      var23.setScheduleEndCustomOscillationEnabled(var5.getOscillationEnabled());
      var0.dismiss();
   }

   private final void configureAsStartMode() {
      DialogfragmentDeviceSetScheduleModeV2Binding var2 = this.binding;
      Object var3 = null;
      DialogfragmentDeviceSetScheduleModeV2Binding var1 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var1 = null;
      }

      var1.title.setText(R.string.select_start_mode);
      var1.btnDone.setText(R.string.select_end_mode);
      var1.btnDone.setOnClickListener(new DeviceSetScheduleModeV2DialogFragment$$ExternalSyntheticLambda3(this));
      Device var7 = this.getViewModel().getDevice();
      Intrinsics.checkNotNull(var7);
      this.modesAdapter = new DeviceScheduleModeV2Adapter(var7, DeviceScheduleModeV2Adapter.ControlGroup.MODES, true, "previous", this.getViewModel().getStartMainMode(), this.getViewModel().getPurifierMode(), this.getViewModel().getStartFanSpeed(), this.getViewModel().getStartBrightness(), this.getViewModel().getStartAutoRh(), this.getViewModel().getStartHumMode(), this.getViewModel().getStartHeatAutoTemp(), this.getViewModel().getStartHeatEcoTemp(), this.getViewModel().getStartOscillationEnabled(), this.modesAdapterActionListener);
      var7 = this.getViewModel().getDevice();
      Intrinsics.checkNotNull(var7);
      this.controlsAdapter = new DeviceScheduleModeV2Adapter(var7, DeviceScheduleModeV2Adapter.ControlGroup.CONTROLS, true, "previous", this.getViewModel().getStartMainMode(), this.getViewModel().getPurifierMode(), this.getViewModel().getStartFanSpeed(), this.getViewModel().getStartBrightness(), this.getViewModel().getStartAutoRh(), this.getViewModel().getStartHumMode(), this.getViewModel().getStartHeatAutoTemp(), this.getViewModel().getStartHeatEcoTemp(), this.getViewModel().getStartOscillationEnabled(), this.controlsAdapterActionListener);
      RecyclerView var5 = var1.rvModeButtons;
      DeviceScheduleModeV2Adapter var4 = this.modesAdapter;
      DeviceScheduleModeV2Adapter var9 = var4;
      if (var4 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("modesAdapter");
         var9 = null;
      }

      var5.setAdapter(var9);
      RecyclerView var11 = var1.rvControlGroup.getRecyclerView();
      var9 = this.controlsAdapter;
      if (var9 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("controlsAdapter");
         var9 = (DeviceScheduleModeV2Adapter)var3;
      }

      var11.setAdapter(var9);
      ShadowLayout var6 = var1.standbyContainer;
      Intrinsics.checkNotNullExpressionValue(var6, "standbyContainer");
      ViewExtensionsKt.show((View)var6, true);
      this.updateStandByUI();
   }

   private static final void configureAsStartMode$lambda$6$lambda$5(DeviceSetScheduleModeV2DialogFragment var0, View var1) {
      DeviceCreateEditScheduleViewModel var4 = var0.getViewModel();
      DeviceScheduleModeV2Adapter var3 = var0.modesAdapter;
      Object var2 = null;
      DeviceScheduleModeV2Adapter var5 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("modesAdapter");
         var5 = null;
      }

      var4.setStartMainMode(var5.getMainMode());
      var4 = var0.getViewModel();
      var3 = var0.modesAdapter;
      var5 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("modesAdapter");
         var5 = null;
      }

      var4.setPurifierMode(var5.getMode());
      var4 = var0.getViewModel();
      var3 = var0.modesAdapter;
      var5 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("modesAdapter");
         var5 = null;
      }

      var4.setStartHumMode(var5.getHumMode());
      var4 = var0.getViewModel();
      var3 = var0.controlsAdapter;
      var5 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("controlsAdapter");
         var5 = null;
      }

      var4.setStartFanSpeed(var5.getFanSpeed());
      var4 = var0.getViewModel();
      var3 = var0.controlsAdapter;
      var5 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("controlsAdapter");
         var5 = null;
      }

      var4.setStartBrightness(var5.getBrightness());
      var4 = var0.getViewModel();
      var3 = var0.controlsAdapter;
      var5 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("controlsAdapter");
         var5 = null;
      }

      var4.setStartAutoRh(var5.getAutoRh());
      var4 = var0.getViewModel();
      var3 = var0.controlsAdapter;
      var5 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("controlsAdapter");
         var5 = null;
      }

      var4.setStartHeatAutoTemp(var5.getHeatAutoTemp());
      var4 = var0.getViewModel();
      var3 = var0.controlsAdapter;
      var5 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("controlsAdapter");
         var5 = null;
      }

      var4.setStartHeatEcoTemp(var5.getHeatEcoTmp());
      DeviceCreateEditScheduleViewModel var21 = var0.getViewModel();
      var5 = var0.controlsAdapter;
      if (var5 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("controlsAdapter");
         var5 = (DeviceScheduleModeV2Adapter)var2;
      }

      var21.setStartOscillationEnabled(var5.getOscillationEnabled());
      var0.configureAsEndMode();
   }

   private static final Unit controlsAdapterActionListener$lambda$3(DeviceSetScheduleModeV2DialogFragment var0, DeviceScheduleModeV2Adapter.Action var1) {
      Intrinsics.checkNotNullParameter(var1, "action");
      if (var1 instanceof DeviceScheduleModeV2Adapter.Action.OPEN_TARGET_HUMIDITY_INFO) {
         FragmentManager var8 = var0.getChildFragmentManager();
         Intrinsics.checkNotNullExpressionValue(var8, "getChildFragmentManager(...)");
         Intrinsics.checkNotNullExpressionValue("ConfirmationDialogLeftAligned", "getSimpleName(...)");
         if (!(var8.findFragmentByTag("ConfirmationDialogLeftAligned") instanceof ConfirmationDialogLeftAligned) && !var8.isStateSaved()) {
            ((DialogFragment)ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, R.string.target_humidity, (Integer)null, DeviceControlUtils.INSTANCE.obtainTargetHumidityInfoRes(var0.getViewModel().getDevice()), R.string.snackbar_ok, (Integer)null, false, false, false, false, (String[])null, (String)null, (Integer)null, (Function1)null, 8032, (Object)null)).show(var8, "ConfirmationDialogLeftAligned");
         }
      } else if (var1 instanceof DeviceScheduleModeV2Adapter.Action.OPEN_TARGET_TEMPERATURE_INFO) {
         FragmentManager var4 = var0.getChildFragmentManager();
         Intrinsics.checkNotNullExpressionValue(var4, "getChildFragmentManager(...)");
         Intrinsics.checkNotNullExpressionValue("ConfirmationDialogLeftAligned", "getSimpleName(...)");
         if (!(var4.findFragmentByTag("ConfirmationDialogLeftAligned") instanceof ConfirmationDialogLeftAligned) && !var4.isStateSaved()) {
            ((DialogFragment)ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, R.string.target_temperature, (Integer)null, R.string.target_temperature_info, R.string.snackbar_ok, (Integer)null, false, false, false, false, (String[])null, (String)null, (Integer)null, (Function1)null, 8032, (Object)null)).show(var4, "ConfirmationDialogLeftAligned");
         }
      } else if (var1 instanceof DeviceScheduleModeV2Adapter.Action.ITEM_COUNT_CHANGED) {
         DialogfragmentDeviceSetScheduleModeV2Binding var3 = var0.binding;
         DialogfragmentDeviceSetScheduleModeV2Binding var5 = var3;
         if (var3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var5 = null;
         }

         ShadowedRecyclerViewLayout var6 = var5.rvControlGroup;
         Intrinsics.checkNotNullExpressionValue(var6, "rvControlGroup");
         View var7 = (View)var6;
         boolean var2;
         if (((Number)((DeviceScheduleModeV2Adapter.Action.ITEM_COUNT_CHANGED)var1).getData()).intValue() > 0) {
            var2 = true;
         } else {
            var2 = false;
         }

         ViewExtensionsKt.show(var7, var2);
      }

      return Unit.INSTANCE;
   }

   private static final Unit modesAdapterActionListener$lambda$0(DeviceSetScheduleModeV2DialogFragment var0, DeviceScheduleModeV2Adapter.Action var1) {
      Intrinsics.checkNotNullParameter(var1, "action");
      boolean var2 = var1 instanceof DeviceScheduleModeV2Adapter.Action.MAIN_MODE_CHANGED;
      Object var8 = null;
      Object var7 = null;
      Object var5 = null;
      Object var4 = null;
      Object var9 = null;
      Object var6 = null;
      if (var2) {
         DeviceScheduleModeV2Adapter var10 = var0.controlsAdapter;
         if (var10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("controlsAdapter");
            var10 = (DeviceScheduleModeV2Adapter)var6;
         }

         var10.setMainMode((MainMode)((DeviceScheduleModeV2Adapter.Action.MAIN_MODE_CHANGED)var1).getData());
      } else if (var1 instanceof DeviceScheduleModeV2Adapter.Action.SUB_MODE_CHANGED) {
         DeviceScheduleModeV2Adapter var20 = var0.controlsAdapter;
         if (var20 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("controlsAdapter");
            var20 = (DeviceScheduleModeV2Adapter)var8;
         }

         var20.setMode((DeviceCreateEditScheduleViewModel.PurifierMode)((DeviceScheduleModeV2Adapter.Action.SUB_MODE_CHANGED)var1).getData());
         var0.updateStandByUI();
      } else {
         boolean var3 = var1 instanceof DeviceScheduleModeV2Adapter.Action.END_TYPE_HINT_CLOSED;
         var2 = true;
         if (var3) {
            var0.getViewModel().setScheduleEndTypeHintClosedBefore(true);
            DeviceScheduleModeV2Adapter var11 = var0.modesAdapter;
            if (var11 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("modesAdapter");
               var11 = (DeviceScheduleModeV2Adapter)var7;
            }

            var11.setEndTypeHintClosedBefore(true);
         } else if (var1 instanceof DeviceScheduleModeV2Adapter.Action.CUSTOM_TYPE_CHANGED) {
            DeviceScheduleModeV2Adapter var22 = var0.controlsAdapter;
            DeviceScheduleModeV2Adapter var21 = var22;
            if (var22 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("controlsAdapter");
               var21 = null;
            }

            var1 = var1;
            var21.setCustomType((String)var1.getData());
            DialogfragmentDeviceSetScheduleModeV2Binding var12 = var0.binding;
            if (var12 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("binding");
               var12 = (DialogfragmentDeviceSetScheduleModeV2Binding)var5;
            }

            ShadowLayout var13 = var12.standbyContainer;
            Intrinsics.checkNotNullExpressionValue(var13, "standbyContainer");
            ViewExtensionsKt.show((View)var13, Intrinsics.areEqual(var1.getData(), "custom"));
         } else if (var1 instanceof DeviceScheduleModeV2Adapter.Action.ITEM_COUNT_CHANGED) {
            DialogfragmentDeviceSetScheduleModeV2Binding var14 = var0.binding;
            if (var14 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("binding");
               var14 = (DialogfragmentDeviceSetScheduleModeV2Binding)var4;
            }

            RecyclerView var15 = var14.rvModeButtons;
            Intrinsics.checkNotNullExpressionValue(var15, "rvModeButtons");
            View var16 = (View)var15;
            if (((Number)((DeviceScheduleModeV2Adapter.Action.ITEM_COUNT_CHANGED)var1).getData()).intValue() <= 0) {
               var2 = false;
            }

            ViewExtensionsKt.show(var16, var2);
         } else if (var1 instanceof DeviceScheduleModeV2Adapter.Action.HUM_MODE_CHANGED) {
            DeviceScheduleModeV2Adapter var17 = var0.controlsAdapter;
            if (var17 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("controlsAdapter");
               var17 = (DeviceScheduleModeV2Adapter)var9;
            }

            var17.setHumMode((Boolean)((DeviceScheduleModeV2Adapter.Action.HUM_MODE_CHANGED)var1).getData());
         }
      }

      return Unit.INSTANCE;
   }

   private static final void onViewCreated$lambda$11$lambda$10(DeviceSetScheduleModeV2DialogFragment var0, View var1) {
      DeviceScheduleModeV2Adapter var3 = var0.modesAdapter;
      Object var2 = null;
      DeviceScheduleModeV2Adapter var5 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("modesAdapter");
         var5 = null;
      }

      DeviceScheduleModeV2Adapter var4 = var0.modesAdapter;
      if (var4 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("modesAdapter");
         var4 = (DeviceScheduleModeV2Adapter)var2;
      }

      var5.setStandByOn(var4.isStandByOn() ^ true);
   }

   private static final void onViewCreated$lambda$11$lambda$9(DeviceSetScheduleModeV2DialogFragment var0, View var1) {
      var0.dismiss();
   }

   private final void updateStandByUI() {
      DialogfragmentDeviceSetScheduleModeV2Binding var4 = this.binding;
      Object var3 = null;
      DialogfragmentDeviceSetScheduleModeV2Binding var2 = var4;
      if (var4 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var2 = null;
      }

      ImageView var6 = var2.standbyIcon;
      DeviceScheduleModeV2Adapter var5 = this.modesAdapter;
      if (var5 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("modesAdapter");
         var5 = (DeviceScheduleModeV2Adapter)var3;
      }

      int var1;
      if (var5.isStandByOn()) {
         var1 = R.drawable.mode_icon_standby_on_schedule;
      } else {
         var1 = ModeIcon.STANDBY.getOffIconV2();
      }

      var6.setImageResource(var1);
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
      FragmentActivity var9 = ((BaseDialogFragment)this).requireActivity();
      Intrinsics.checkNotNullExpressionValue(var9, "requireActivity(...)");
      this.setViewModel((DeviceCreateEditScheduleViewModel)((BaseViewModel)(new ViewModelProvider((ViewModelStoreOwner)var9)).get(DeviceCreateEditScheduleViewModel.class)));
      DialogfragmentDeviceSetScheduleModeV2Binding var6 = DialogfragmentDeviceSetScheduleModeV2Binding.inflate(var1, var2, false);
      Intrinsics.checkNotNullExpressionValue(var6, "inflate(...)");
      this.binding = var6;
      DialogfragmentDeviceSetScheduleModeV2Binding var4 = var6;
      if (var6 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var4 = null;
      }

      FrameLayout var5 = var4.getRoot();
      Intrinsics.checkNotNullExpressionValue(var5, "getRoot(...)");
      return (View)var5;
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
      if (this.isStartMode) {
         this.configureAsStartMode();
      } else {
         this.configureAsEndMode();
      }

      DialogfragmentDeviceSetScheduleModeV2Binding var3 = this.binding;
      SimpleItemAnimator var5 = null;
      DialogfragmentDeviceSetScheduleModeV2Binding var4 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var4 = null;
      }

      var4.btnClose.setOnClickListener(new DeviceSetScheduleModeV2DialogFragment$$ExternalSyntheticLambda4(this));
      var4.standbyContainer.setOnClickListener(new DeviceSetScheduleModeV2DialogFragment$$ExternalSyntheticLambda5(this));
      RecyclerView.ItemAnimator var6 = var4.rvModeButtons.getItemAnimator();
      if (var6 instanceof SimpleItemAnimator) {
         var5 = (SimpleItemAnimator)var6;
      }

      if (var5 != null) {
         var5.setSupportsChangeAnimations(false);
      }

      var4.scrollable.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener(var4) {
         final DialogfragmentDeviceSetScheduleModeV2Binding $this_apply;
         private long lastScrollTime;

         {
            this.$this_apply = var1;
         }

         public final long getLastScrollTime() {
            return this.lastScrollTime;
         }

         public void onScrollChange(NestedScrollView var1, int var2, int var3, int var4, int var5) {
            Intrinsics.checkNotNullParameter(var1, "v");
            this.lastScrollTime = System.currentTimeMillis();
            this.$this_apply.bottomBar.setBackgroundColor(-1);
            View var6 = this.$this_apply.separator;
            Intrinsics.checkNotNullExpressionValue(var6, "separator");
            ViewExtensionsKt.show$default(var6, false, 1, (Object)null);
            ((View)var1).postDelayed(new Runnable(this, this.$this_apply) {
               final DialogfragmentDeviceSetScheduleModeV2Binding $this_apply$inlined;
               final <undefinedtype> this$0;

               public {
                  this.this$0 = var1;
                  this.$this_apply$inlined = var2;
               }

               public final void run() {
                  if (System.currentTimeMillis() - this.this$0.getLastScrollTime() > 250L) {
                     this.$this_apply$inlined.bottomBar.setBackgroundColor(0);
                     View var1 = this.$this_apply$inlined.separator;
                     Intrinsics.checkNotNullExpressionValue(var1, "separator");
                     ViewExtensionsKt.hide(var1);
                  }

               }
            }, 300L);
         }

         public final void setLastScrollTime(long var1) {
            this.lastScrollTime = var1;
         }
      });
   }

   public void setViewModel(DeviceCreateEditScheduleViewModel var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.viewModel = var1;
   }

   public void showProgress(boolean var1) {
   }

   @Metadata(
      d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"},
      d2 = {"Lcom/blueair/devicedetails/dialog/DeviceSetScheduleModeV2DialogFragment$Companion;", "", "<init>", "()V", "EXTRA_IS_START_MODE", "", "newInstance", "Lcom/blueair/devicedetails/dialog/DeviceSetScheduleModeV2DialogFragment;", "isStartMode", "", "devicedetails_otherRelease"},
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

      public final DeviceSetScheduleModeV2DialogFragment newInstance(boolean var1) {
         DeviceSetScheduleModeV2DialogFragment var2 = new DeviceSetScheduleModeV2DialogFragment();
         var2.setArguments(BundleKt.bundleOf(new Pair[]{TuplesKt.to("EXTRA_IS_START_MODE", var1)}));
         return var2;
      }
   }
}
