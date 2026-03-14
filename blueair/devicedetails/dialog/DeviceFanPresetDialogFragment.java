package com.blueair.devicedetails.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.os.BundleKt;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.blueair.core.model.ApSubMode;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceData;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.HasCombo3in1MainMode;
import com.blueair.devicedetails.databinding.DialogfragmentDeviceFanPresetBinding;
import com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel;
import com.blueair.viewcore.R;
import com.blueair.viewcore.dialog.BaseDialogFragment;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import com.google.android.material.button.MaterialButton;
import io.apptik.widget.MultiSlider;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

@Metadata(
   d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u0013\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\u0006\n\u0002\b\u0006\u0018\u0000 C2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001CB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J$\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\u001a\u00101\u001a\u0002022\u0006\u00103\u001a\u00020*2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\b\u00104\u001a\u000202H\u0002J\b\u00105\u001a\u000202H\u0002J\u0010\u00106\u001a\u0002022\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\b\u00107\u001a\u000202H\u0002J\u0010\u00108\u001a\u0002022\u0006\u00109\u001a\u00020%H\u0002J\u0010\u0010:\u001a\u00020\u00132\u0006\u0010;\u001a\u00020\u0013H\u0002J\u0018\u0010<\u001a\u0002022\u0006\u0010;\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0010\u0010=\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020>H\u0002J\u0010\u0010?\u001a\u00020>2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\b\u0010@\u001a\u000202H\u0016J\u0010\u0010A\u001a\u0002022\u0006\u0010B\u001a\u00020\u0015H\u0016R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0010X\u0082.¢\u0006\u0002\n\u0000R\u001e\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0015@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0010X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u001f\u001a\u00020\u0002X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u000e\u0010$\u001a\u00020%X\u0082.¢\u0006\u0002\n\u0000R\u001e\u0010&\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b'\u0010(¨\u0006D"},
   d2 = {"Lcom/blueair/devicedetails/dialog/DeviceFanPresetDialogFragment;", "Lcom/blueair/viewcore/dialog/BaseDialogFragment;", "Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "device", "Lcom/blueair/core/model/Device;", "binding", "Lcom/blueair/devicedetails/databinding/DialogfragmentDeviceFanPresetBinding;", "tmpDegreeTxt", "tmpUnitTxt", "tempSelectTvs", "", "Landroid/widget/TextView;", "drawableList", "", "value", "", "isEcoMode", "setEcoMode", "(Z)V", "minTemperatureApart", "maxTemperature", "minTemperature", "isTempC", "isReset", "tagList", "viewModel", "getViewModel", "()Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;", "setViewModel", "(Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;)V", "currentPresetArray", "", "currentTag", "setCurrentTag", "(I)V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "updateTriggerSelect", "updateResetBtnEnable", "updateCurrentTemp", "resetPresets", "validateTempArray", "oldTempArray", "getThumbValue", "index", "setThumbValue", "getTempSliderValue", "", "getTempValueFromSlider", "onStart", "showProgress", "shouldShowProgress", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceFanPresetDialogFragment extends BaseDialogFragment {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private static final double[] DEFAULT_PRESET_AUTO = new double[]{(double)20.0F, (double)23.0F, (double)25.0F};
   private static final double[] DEFAULT_PRESET_ECO = new double[]{(double)20.0F, (double)25.0F};
   private DialogfragmentDeviceFanPresetBinding binding;
   private double[] currentPresetArray;
   private int currentTag;
   private Device device;
   private List drawableList;
   private boolean isEcoMode;
   private boolean isReset;
   private boolean isTempC = true;
   private int maxTemperature = 37;
   private int minTemperature = 15;
   private int minTemperatureApart = 2;
   private final String screenName;
   private List tagList;
   private List tempSelectTvs;
   private String tmpDegreeTxt;
   private String tmpUnitTxt;
   public DeviceDetailsViewModel viewModel;

   // $FF: synthetic method
   public static void $r8$lambda$76R_m32N8Nzu_j3KlSD2hh89Htc/* $FF was: $r8$lambda$76R-m32N8Nzu_j3KlSD2hh89Htc*/(TextView var0) {
      updateCurrentTemp$lambda$26$lambda$25(var0);
   }

   // $FF: synthetic method
   public static void $r8$lambda$7ejRIZyyE8va984ET37P9fA1Deo(DeviceFanPresetDialogFragment var0, HasCombo3in1MainMode var1, View var2) {
      onViewCreated$lambda$24$lambda$6(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$CokqH8Bua5kupqdGGn62xllH66w(DeviceFanPresetDialogFragment var0, HasCombo3in1MainMode var1, int var2, TextView var3, View var4) {
      onViewCreated$lambda$24$lambda$18$lambda$17(var0, var1, var2, var3, var4);
   }

   // $FF: synthetic method
   public static void $r8$lambda$F9x_XV7yHK4xRjRTaMVeLWJKZJU/* $FF was: $r8$lambda$F9x-XV7yHK4xRjRTaMVeLWJKZJU*/(DeviceFanPresetDialogFragment var0, MultiSlider var1, MultiSlider.Thumb var2, int var3, int var4) {
      onViewCreated$lambda$24$lambda$11$lambda$10(var0, var1, var2, var3, var4);
   }

   // $FF: synthetic method
   public static void $r8$lambda$UAISdJrphs23hRjw1v8yrhQK1w4(DeviceFanPresetDialogFragment var0, View var1) {
      onViewCreated$lambda$24$lambda$4(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$alYQd6KOSarCVcEp3owglrlPqtw(DeviceFanPresetDialogFragment var0, View var1) {
      onViewCreated$lambda$24$lambda$23$lambda$22(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$dPXrhr68t1BbjuECtDfbkzo7ziY(DeviceFanPresetDialogFragment var0, MultiSlider.Thumb var1, View var2) {
      onViewCreated$lambda$24$lambda$11$lambda$9$lambda$8$lambda$7(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$rTNNjqbJ5RB2ddv8_IQQCJKaCXo(DeviceFanPresetDialogFragment var0, View var1) {
      onViewCreated$lambda$24$lambda$5(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$tZ3gB1J6aX_bQRCVmpJZBSu8n9I/* $FF was: $r8$lambda$tZ3gB1J6aX-bQRCVmpJZBSu8n9I*/(DeviceFanPresetDialogFragment var0, int var1) {
      return onViewCreated$lambda$24$lambda$23$lambda$22$lambda$21$lambda$20$lambda$19(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$wZgsAkUu4TxuMg2NY5SYGjpDmYA(TextView var0, List var1, DeviceFanPresetDialogFragment var2, int var3, List var4, int var5) {
      return onViewCreated$lambda$24$lambda$18$lambda$17$lambda$16$lambda$15$lambda$14(var0, var1, var2, var3, var4, var5);
   }

   private final int getTempSliderValue(double var1) {
      return this.isTempC ? MathKt.roundToInt(var1) : MathKt.roundToInt(DeviceData.Companion.convertCelsiusToFahrenheit(var1));
   }

   private final double getTempValueFromSlider(int var1) {
      return this.isTempC ? (double)var1 : DeviceData.Companion.convertFahrenheitToCelsius((double)var1);
   }

   private final int getThumbValue(int var1) {
      DialogfragmentDeviceFanPresetBinding var3 = this.binding;
      DialogfragmentDeviceFanPresetBinding var2 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var2 = null;
      }

      return var2.rangeSlider.getThumb(var1).getValue();
   }

   private static final void onViewCreated$lambda$24$lambda$11$lambda$10(DeviceFanPresetDialogFragment var0, MultiSlider var1, MultiSlider.Thumb var2, int var3, int var4) {
      List var5 = var0.tempSelectTvs;
      Object var15 = null;
      List var8 = var5;
      if (var5 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("tempSelectTvs");
         var8 = null;
      }

      TextView var7 = (TextView)var8.get(var3);
      StringBuilder var6 = new StringBuilder();
      var6.append(var4);
      String var16 = var0.tmpDegreeTxt;
      String var9 = var16;
      if (var16 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("tmpDegreeTxt");
         var9 = null;
      }

      var6.append(var9);
      var16 = var0.tmpUnitTxt;
      var9 = var16;
      if (var16 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("tmpUnitTxt");
         var9 = null;
      }

      var6.append(var9);
      var7.setText((CharSequence)var6.toString());
      if (var3 == 0) {
         DialogfragmentDeviceFanPresetBinding var18 = var0.binding;
         DialogfragmentDeviceFanPresetBinding var11 = var18;
         if (var18 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var11 = null;
         }

         var7 = var11.timerSelect1;
         var6 = new StringBuilder("<");
         var6.append(var4);
         String var19 = var0.tmpDegreeTxt;
         String var12 = var19;
         if (var19 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tmpDegreeTxt");
            var12 = null;
         }

         var6.append(var12);
         var19 = var0.tmpUnitTxt;
         var12 = var19;
         if (var19 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tmpUnitTxt");
            var12 = null;
         }

         var6.append(var12);
         var7.setText((CharSequence)var6.toString());
      }

      if (!var0.isReset) {
         double[] var14 = var0.currentPresetArray;
         if (var14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentPresetArray");
            var14 = (double[])var15;
         }

         var14[var3] = var0.getTempValueFromSlider(var4);
      }

      var0.updateCurrentTemp(var4);
      var0.updateResetBtnEnable();
   }

   private static final void onViewCreated$lambda$24$lambda$11$lambda$9$lambda$8$lambda$7(DeviceFanPresetDialogFragment var0, MultiSlider.Thumb var1, View var2) {
      var0.updateCurrentTemp(var1.getValue());
   }

   private static final void onViewCreated$lambda$24$lambda$18$lambda$17(DeviceFanPresetDialogFragment var0, HasCombo3in1MainMode var1, int var2, TextView var3, View var4) {
      FragmentManager var7 = var0.getChildFragmentManager();
      Intrinsics.checkNotNullExpressionValue(var7, "getChildFragmentManager(...)");
      Intrinsics.checkNotNullExpressionValue("DeviceTimerPickerDialogFragment", "getSimpleName(...)");
      if (!(var7.findFragmentByTag("DeviceTimerPickerDialogFragment") instanceof DeviceTimerPickerDialogFragment) && !var7.isStateSaved()) {
         String var8 = var4.getContext().getString(R.string.temp_expanded);
         Intrinsics.checkNotNullExpressionValue(var8, "getString(...)");
         ApSubMode var13 = var1.currentSubMode();
         List var14;
         if (DeviceFanPresetDialogFragment.WhenMappings.$EnumSwitchMapping$0[var13.ordinal()] == 1) {
            if (var2 != 0) {
               if (var2 != 1) {
                  var14 = CollectionsKt.toList((Iterable)(new IntRange(var0.minTemperature, var0.maxTemperature)));
               } else {
                  var14 = CollectionsKt.toList((Iterable)(new IntRange(var0.getThumbValue(0) + var0.minTemperatureApart, var0.maxTemperature)));
               }
            } else {
               var14 = CollectionsKt.toList((Iterable)(new IntRange(var0.minTemperature, var0.getThumbValue(1) - var0.minTemperatureApart)));
            }
         } else if (var2 != 0) {
            if (var2 != 1) {
               if (var2 != 2) {
                  var14 = CollectionsKt.toList((Iterable)(new IntRange(var0.minTemperature, var0.maxTemperature)));
               } else {
                  var14 = CollectionsKt.toList((Iterable)(new IntRange(var0.getThumbValue(1) + var0.minTemperatureApart, var0.maxTemperature)));
               }
            } else {
               var14 = CollectionsKt.toList((Iterable)(new IntRange(var0.getThumbValue(0) + var0.minTemperatureApart, var0.getThumbValue(2) - var0.minTemperatureApart)));
            }
         } else {
            var14 = CollectionsKt.toList((Iterable)(new IntRange(var0.minTemperature, var0.getThumbValue(1) - var0.minTemperatureApart)));
         }

         Collection var20 = (Collection)var14;
         Object var15 = var20;
         if (var20.isEmpty()) {
            var15 = CollectionsKt.listOf(var0.getThumbValue(var2));
         }

         List var9 = (List)var15;
         Iterable var16 = (Iterable)var9;
         Collection var10 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var16, 10)));
         Iterator var12 = var16.iterator();

         while(var12.hasNext()) {
            int var5 = ((Number)var12.next()).intValue();
            StringBuilder var11 = new StringBuilder();
            var11.append(var5);
            String var6 = var0.tmpDegreeTxt;
            Object var21 = null;
            String var17 = var6;
            if (var6 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("tmpDegreeTxt");
               var17 = null;
            }

            var11.append(var17);
            var17 = var0.tmpUnitTxt;
            if (var17 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("tmpUnitTxt");
               var17 = (String)var21;
            }

            var11.append(var17);
            var10.add(var11.toString());
         }

         List var19 = (List)var10;
         int var23 = RangesKt.coerceAtLeast(var9.indexOf(var0.getThumbValue(var2)), 0);
         DeviceTimerPickerDialogFragment var22 = DeviceTimerPickerDialogFragment.Companion.newInstance(var8, var19, var23, false);
         var22.setOnPickResult(new DeviceFanPresetDialogFragment$$ExternalSyntheticLambda0(var3, var19, var0, var2, var9));
         ((DialogFragment)var22).show(var7, "DeviceTimerPickerDialogFragment");
      }

   }

   private static final Unit onViewCreated$lambda$24$lambda$18$lambda$17$lambda$16$lambda$15$lambda$14(TextView var0, List var1, DeviceFanPresetDialogFragment var2, int var3, List var4, int var5) {
      var0.setText((CharSequence)var1.get(var5));
      var2.setThumbValue(var3, ((Number)var4.get(var5)).intValue());
      double[] var7 = var2.currentPresetArray;
      double[] var6 = var7;
      if (var7 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("currentPresetArray");
         var6 = null;
      }

      var6[var3] = var2.getTempValueFromSlider(((Number)var4.get(var5)).intValue());
      var2.updateResetBtnEnable();
      return Unit.INSTANCE;
   }

   private static final void onViewCreated$lambda$24$lambda$23$lambda$22(DeviceFanPresetDialogFragment var0, View var1) {
      FragmentManager var3 = var0.getChildFragmentManager();
      Intrinsics.checkNotNullExpressionValue(var3, "getChildFragmentManager(...)");
      Intrinsics.checkNotNullExpressionValue("DeviceTimerPickerDialogFragment", "getSimpleName(...)");
      if (!(var3.findFragmentByTag("DeviceTimerPickerDialogFragment") instanceof DeviceTimerPickerDialogFragment) && !var3.isStateSaved()) {
         String var4 = var0.requireContext().getString(R.string.fan_speed_trigger);
         Intrinsics.checkNotNullExpressionValue(var4, "getString(...)");
         DeviceTimerPickerDialogFragment.Companion var5 = DeviceTimerPickerDialogFragment.Companion;
         List var2 = var0.tagList;
         List var6 = var2;
         if (var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tagList");
            var6 = null;
         }

         DeviceTimerPickerDialogFragment var7 = var5.newInstance(var4, var6, var0.currentTag, false);
         var7.setOnPickResult(new DeviceFanPresetDialogFragment$$ExternalSyntheticLambda8(var0));
         ((DialogFragment)var7).show(var3, "DeviceTimerPickerDialogFragment");
      }

   }

   private static final Unit onViewCreated$lambda$24$lambda$23$lambda$22$lambda$21$lambda$20$lambda$19(DeviceFanPresetDialogFragment var0, int var1) {
      var0.setCurrentTag(var1);
      return Unit.INSTANCE;
   }

   private static final void onViewCreated$lambda$24$lambda$4(DeviceFanPresetDialogFragment var0, View var1) {
      var0.dismiss();
   }

   private static final void onViewCreated$lambda$24$lambda$5(DeviceFanPresetDialogFragment var0, View var1) {
      var0.resetPresets();
   }

   private static final void onViewCreated$lambda$24$lambda$6(DeviceFanPresetDialogFragment var0, HasCombo3in1MainMode var1, View var2) {
      boolean var4 = var0.isEcoMode;
      Object var9 = null;
      Object var5 = null;
      if (var4) {
         DeviceDetailsViewModel var10 = var0.getViewModel();
         Device var6 = var1;
         int var3 = var0.currentTag;
         double[] var7 = var0.currentPresetArray;
         if (var7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentPresetArray");
            var7 = (double[])var5;
         }

         var10.setCoolEcoPresets(var6, var3, var7);
      } else {
         DeviceDetailsViewModel var12 = var0.getViewModel();
         Device var13 = var1;
         int var11 = var0.currentTag;
         double[] var8 = var0.currentPresetArray;
         if (var8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentPresetArray");
            var8 = (double[])var9;
         }

         var12.setCoolAutoPresets(var13, var11, var8);
      }

      var0.dismiss();
   }

   private final void resetPresets() {
      this.isReset = true;
      double[] var3;
      if (this.isEcoMode) {
         var3 = DEFAULT_PRESET_ECO;
      } else {
         var3 = DEFAULT_PRESET_AUTO;
      }

      this.currentPresetArray = (double[])var3.clone();
      List var4 = this.drawableList;
      List var8 = var4;
      if (var4 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("drawableList");
         var8 = null;
      }

      Iterator var5 = ((Iterable)var8).iterator();

      for(int var1 = 0; var5.hasNext(); ++var1) {
         Object var9 = var5.next();
         if (var1 < 0) {
            CollectionsKt.throwIndexOverflow();
         }

         ((Number)var9).intValue();
         double[] var17 = this.currentPresetArray;
         double[] var10 = var17;
         if (var17 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentPresetArray");
            var10 = null;
         }

         int var2 = this.getTempSliderValue(var10[var1]);
         this.setThumbValue(var1, var2);
         List var18 = this.tempSelectTvs;
         List var11 = var18;
         if (var18 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tempSelectTvs");
            var11 = null;
         }

         TextView var7 = (TextView)var11.get(var1);
         StringBuilder var6 = new StringBuilder();
         var6.append(var2);
         String var19 = this.tmpDegreeTxt;
         String var12 = var19;
         if (var19 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tmpDegreeTxt");
            var12 = null;
         }

         var6.append(var12);
         var19 = this.tmpUnitTxt;
         var12 = var19;
         if (var19 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tmpUnitTxt");
            var12 = null;
         }

         var6.append(var12);
         var7.setText((CharSequence)var6.toString());
         if (var1 == 0) {
            DialogfragmentDeviceFanPresetBinding var21 = this.binding;
            DialogfragmentDeviceFanPresetBinding var14 = var21;
            if (var21 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("binding");
               var14 = null;
            }

            TextView var24 = var14.timerSelect1;
            StringBuilder var25 = new StringBuilder("<");
            var25.append(var2);
            String var22 = this.tmpDegreeTxt;
            String var15 = var22;
            if (var22 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("tmpDegreeTxt");
               var15 = null;
            }

            var25.append(var15);
            var22 = this.tmpUnitTxt;
            var15 = var22;
            if (var22 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("tmpUnitTxt");
               var15 = null;
            }

            var25.append(var15);
            var24.setText((CharSequence)var25.toString());
         }
      }

   }

   private final void setCurrentTag(int var1) {
      this.currentTag = var1;
      this.updateTriggerSelect();
   }

   private final void setEcoMode(boolean var1) {
      this.isEcoMode = var1;
      byte var2;
      if (var1) {
         var2 = 25;
      } else {
         var2 = 37;
      }

      this.maxTemperature = var2;
   }

   private final void setThumbValue(int var1, int var2) {
      DialogfragmentDeviceFanPresetBinding var4 = this.binding;
      DialogfragmentDeviceFanPresetBinding var3 = var4;
      if (var4 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var3 = null;
      }

      var3.rangeSlider.getThumb(var1).setValue(var2);
   }

   private final void updateCurrentTemp(int var1) {
      DialogfragmentDeviceFanPresetBinding var8 = this.binding;
      DialogfragmentDeviceFanPresetBinding var7 = var8;
      if (var8 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var7 = null;
      }

      int var6 = var7.rangeSlider.getWidth();
      var8 = this.binding;
      var7 = var8;
      if (var8 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var7 = null;
      }

      int var5 = var7.rangeSlider.getMax();
      int var4 = this.minTemperature;
      float var2 = (float)(var1 - var4) / (float)(var5 - var4);
      var8 = this.binding;
      var7 = var8;
      if (var8 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var7 = null;
      }

      float var3 = (float)(var6 - var7.rangeSlider.getPaddingStart());
      var8 = this.binding;
      var7 = var8;
      if (var8 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var7 = null;
      }

      var4 = (int)((var3 - (float)var7.rangeSlider.getPaddingEnd() * var2) * var2);
      var8 = this.binding;
      var7 = var8;
      if (var8 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var7 = null;
      }

      ViewGroup.LayoutParams var17 = var7.currentUpdateTemp.getLayoutParams();
      Intrinsics.checkNotNull(var17, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
      ConstraintLayout.LayoutParams var9 = (ConstraintLayout.LayoutParams)var17;
      var9.setMarginStart(var4);
      var8 = this.binding;
      DialogfragmentDeviceFanPresetBinding var18 = var8;
      if (var8 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var18 = null;
      }

      TextView var10 = var18.currentUpdateTemp;
      StringBuilder var11 = new StringBuilder();
      var11.append(var1);
      String var26 = this.tmpDegreeTxt;
      String var19 = var26;
      if (var26 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("tmpDegreeTxt");
         var19 = null;
      }

      var11.append(var19);
      var26 = this.tmpUnitTxt;
      var19 = var26;
      if (var26 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("tmpUnitTxt");
         var19 = null;
      }

      var11.append(var19);
      var10.setText((CharSequence)var11.toString());
      var10.setLayoutParams((ViewGroup.LayoutParams)var9);
      var10.setVisibility(0);
      var10.getHandler().removeCallbacksAndMessages((Object)null);
      var10.getHandler().postDelayed(new DeviceFanPresetDialogFragment$$ExternalSyntheticLambda9(var10), 2000L);
   }

   private static final void updateCurrentTemp$lambda$26$lambda$25(TextView var0) {
      var0.setVisibility(4);
   }

   private final void updateResetBtnEnable() {
      DialogfragmentDeviceFanPresetBinding var2 = this.binding;
      Object var3 = null;
      DialogfragmentDeviceFanPresetBinding var1 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var1 = null;
      }

      MaterialButton var4 = var1.btnReset;
      double[] var7 = this.currentPresetArray;
      double[] var5 = var7;
      if (var7 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("currentPresetArray");
         var5 = null;
      }

      if (this.isEcoMode) {
         var7 = DEFAULT_PRESET_ECO;
      } else {
         var7 = DEFAULT_PRESET_AUTO;
      }

      var4.setEnabled(Arrays.equals(var5, var7) ^ true);
      DialogfragmentDeviceFanPresetBinding var6 = this.binding;
      if (var6 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var6 = (DialogfragmentDeviceFanPresetBinding)var3;
      }

      var6.btnReset.setPressed(false);
   }

   private final void updateTriggerSelect() {
      boolean var1;
      if (this.currentTag == 0) {
         var1 = true;
      } else {
         var1 = false;
      }

      DialogfragmentDeviceFanPresetBinding var4 = this.binding;
      Object var3 = null;
      DialogfragmentDeviceFanPresetBinding var2 = var4;
      if (var4 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var2 = null;
      }

      ConstraintLayout var5 = var2.contentPresetDetail;
      Intrinsics.checkNotNullExpressionValue(var5, "contentPresetDetail");
      ViewExtensionsKt.show((View)var5, var1);
      var4 = this.binding;
      DialogfragmentDeviceFanPresetBinding var6 = var4;
      if (var4 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var6 = null;
      }

      MaterialButton var7 = var6.btnReset;
      Intrinsics.checkNotNullExpressionValue(var7, "btnReset");
      ViewExtensionsKt.show((View)var7, var1);
      var4 = this.binding;
      DialogfragmentDeviceFanPresetBinding var8 = var4;
      if (var4 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var8 = null;
      }

      TextView var12 = var8.timerTriggerSelect;
      List var9 = this.tagList;
      if (var9 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("tagList");
         var9 = (List)var3;
      }

      var12.setText((CharSequence)var9.get(this.currentTag));
   }

   private final void validateTempArray(double[] var1) {
      double[] var18 = this.currentPresetArray;
      String var17 = "currentPresetArray";
      double[] var16 = var18;
      if (var18 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("currentPresetArray");
         var16 = null;
      }

      int var15 = var16.length;
      int var7 = 0;

      int var12;
      for(int var8 = 0; var7 < var15; var8 = var12) {
         double var10000 = var16[var7];
         var12 = var8 + 1;
         int var9 = this.getThumbValue(var8);
         if (var9 != MathKt.roundToInt(var1[var8])) {
            boolean var6 = true;
            int var4 = 1;
            boolean var5 = true;
            if (var8 == 0) {
               int var25 = this.getThumbValue(var12) - this.minTemperatureApart;
               if (var9 <= var25) {
                  var5 = false;
               }

               var4 = var9;
               var6 = var5;
               if (var5) {
                  var4 = RangesKt.coerceAtLeast(var25, this.minTemperature);
                  var6 = var5;
               }
            } else {
               double[] var19 = this.currentPresetArray;
               var18 = var19;
               if (var19 == null) {
                  Intrinsics.throwUninitializedPropertyAccessException(var17);
                  var18 = null;
               }

               if (var8 == var18.length - 1) {
                  int var24 = this.getThumbValue(var8 - 1) + this.minTemperatureApart;
                  if (var9 < var24) {
                     var5 = var6;
                  } else {
                     var5 = false;
                  }

                  var4 = var9;
                  var6 = var5;
                  if (var5) {
                     var4 = RangesKt.coerceAtMost(var24, this.maxTemperature);
                     var6 = var5;
                  }
               } else {
                  int var14 = this.getThumbValue(var8 - 1) + this.minTemperatureApart;
                  int var13 = this.getThumbValue(var12) - this.minTemperatureApart;
                  boolean var10;
                  if (var9 < var14) {
                     var10 = true;
                  } else {
                     var10 = false;
                  }

                  boolean var11;
                  if (var9 > var13) {
                     var11 = true;
                  } else {
                     var11 = false;
                  }

                  var5 = (boolean)var4;
                  if (!var10) {
                     if (var11) {
                        var5 = (boolean)var4;
                     } else {
                        var5 = false;
                     }
                  }

                  var4 = var9;
                  var6 = var5;
                  if (var5) {
                     var4 = this.getTempSliderValue(var1[var8]);
                     if (var10 && var11) {
                        var6 = var5;
                     } else if (var10) {
                        var4 = var14;
                        var6 = var5;
                     } else {
                        var4 = var9;
                        var6 = var5;
                        if (var11) {
                           var4 = var13;
                           var6 = var5;
                        }
                     }
                  }
               }
            }

            if (var6) {
               this.setThumbValue(var8, var4);
            }
         }

         ++var7;
      }

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
      Dialog var7 = this.getDialog();
      if (var7 != null) {
         Window var8 = var7.getWindow();
         if (var8 != null) {
            var8.setBackgroundDrawable((Drawable)(new ColorDrawable(0)));
            var8.setWindowAnimations(R.style.dialog_animation);
            var8.setGravity(80);
         }
      }

      DialogfragmentDeviceFanPresetBinding var6 = DialogfragmentDeviceFanPresetBinding.inflate(var1, var2, false);
      Intrinsics.checkNotNullExpressionValue(var6, "inflate(...)");
      this.binding = var6;
      DialogfragmentDeviceFanPresetBinding var4 = var6;
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
            var2.setLayout(-1, -2);
         }
      }

   }

   public void onViewCreated(View var1, Bundle var2) {
      Intrinsics.checkNotNullParameter(var1, "view");
      super.onViewCreated(var1, var2);
      Parcelable var13 = this.requireArguments().getParcelable("device");
      if (var13 == null) {
         throw new IllegalArgumentException("Required value was null.".toString());
      } else {
         Device var17 = (Device)var13;
         this.device = var17;
         HasCombo3in1MainMode var14 = var17;
         if (var17 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("device");
            var14 = null;
         }

         if (var14 instanceof HasCombo3in1MainMode) {
            var14 = var14;
         } else {
            var14 = null;
         }

         if (var14 != null) {
            this.setViewModel((DeviceDetailsViewModel)((BaseViewModel)(new ViewModelProvider((ViewModelStoreOwner)(this))).get(DeviceDetailsViewModel.class)));
            this.getViewModel().setDeviceId(var14.getUid());
            DeviceDetailsViewModel var18 = this.getViewModel();
            Device var8 = var14;
            var18.setDevice(var8);
            this.setEcoMode(var14.isInSubMode(ApSubMode.ECO));
            boolean var7 = DeviceKt.isCelsiusUnit(var8);
            this.isTempC = var7;
            int var4 = 2;
            byte var3;
            if (var7) {
               var3 = 2;
            } else {
               var3 = 4;
            }

            this.minTemperatureApart = var3;
            DialogfragmentDeviceFanPresetBinding var46 = this.binding;
            DialogfragmentDeviceFanPresetBinding var19 = var46;
            if (var46 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("binding");
               var19 = null;
            }

            TextView var47 = var19.fanPresetInfo;
            var3 = R.string.fan_preset_description;
            String var20;
            if (this.isTempC) {
               var20 = "2℃";
            } else {
               var20 = "4℉";
            }

            byte var5 = 0;
            var47.setText((CharSequence)this.getString(var3, new Object[]{var20}));
            if (this.isEcoMode) {
               var3 = 25;
            } else {
               var3 = 37;
            }

            this.maxTemperature = this.getTempSliderValue((double)var3);
            this.minTemperature = this.getTempSliderValue((double)15.0F);
            double[] var21;
            if (this.isEcoMode) {
               var21 = var14.getCoolEcoPresets();
            } else {
               var21 = var14.getCoolAutoPresets();
            }

            this.currentPresetArray = (double[])var21.clone();
            Context var22 = this.requireContext();
            String var48 = var22.getString(R.string.temperature_degree);
            Intrinsics.checkNotNullExpressionValue(var48, "getString(...)");
            this.tmpDegreeTxt = var48;
            if (this.isTempC) {
               var3 = R.string.temperature_unit_c;
            } else {
               var3 = R.string.temperature_unit_f;
            }

            var48 = var22.getString(var3);
            Intrinsics.checkNotNullExpressionValue(var48, "getString(...)");
            this.tmpUnitTxt = var48;
            Iterable var9 = (Iterable)CollectionsKt.listOf(new Integer[]{R.string.room_temperature, R.string.particle_matter});
            Collection var50 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var9, 10)));
            Iterator var84 = var9.iterator();

            while(var84.hasNext()) {
               var50.add(var22.getString(((Number)var84.next()).intValue()));
            }

            this.tagList = (List)var50;
            String var85 = var22.getString(R.string.fan_speed);
            Intrinsics.checkNotNullExpressionValue(var85, "getString(...)");
            DialogfragmentDeviceFanPresetBinding var51 = this.binding;
            DialogfragmentDeviceFanPresetBinding var23 = var51;
            if (var51 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("binding");
               var23 = null;
            }

            TextView var10 = var23.fanSpeedTitle1;
            var51 = this.binding;
            var23 = var51;
            if (var51 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("binding");
               var23 = null;
            }

            TextView var11 = var23.fanSpeedTitle2;
            var51 = this.binding;
            var23 = var51;
            if (var51 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("binding");
               var23 = null;
            }

            TextView var12 = var23.fanSpeedTitle3;
            var51 = this.binding;
            var23 = var51;
            if (var51 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("binding");
               var23 = null;
            }

            Iterator var27 = ((Iterable)CollectionsKt.listOf(new TextView[]{var10, var11, var12, var23.fanSpeedTitle4})).iterator();

            int var6;
            for(int var36 = 0; var27.hasNext(); var36 = var6) {
               var51 = (DialogfragmentDeviceFanPresetBinding)var27.next();
               var6 = var36 + 1;
               if (var36 < 0) {
                  CollectionsKt.throwIndexOverflow();
               }

               TextView var56 = (TextView)var51;
               StringBuilder var106 = new StringBuilder();
               var106.append(var85);
               var106.append(' ');
               var106.append(var6);
               var56.setText((CharSequence)var106.toString());
            }

            var51 = this.binding;
            DialogfragmentDeviceFanPresetBinding var28 = var51;
            if (var51 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("binding");
               var28 = null;
            }

            TextView var86 = var28.timerSelect2;
            Intrinsics.checkNotNullExpressionValue(var86, "timerSelect2");
            var51 = this.binding;
            var28 = var51;
            if (var51 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("binding");
               var28 = null;
            }

            TextView var30 = var28.timerSelect3;
            Intrinsics.checkNotNullExpressionValue(var30, "timerSelect3");
            this.tempSelectTvs = CollectionsKt.listOf(new TextView[]{var86, var30});
            this.drawableList = CollectionsKt.listOf(new Integer[]{R.drawable.multi_seekbar_thumb_silver_lake_blue, R.drawable.multi_seekbar_thumb_steel_blue});
            if (this.isEcoMode) {
               var3 = var14.getCoolEcoTag();
            } else {
               var3 = var14.getCoolAutoTag();
            }

            this.setCurrentTag(var3);
            var51 = this.binding;
            DialogfragmentDeviceFanPresetBinding var31 = var51;
            if (var51 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("binding");
               var31 = null;
            }

            if (this.isEcoMode) {
               TextView var60 = var31.timerSelect4;
               Intrinsics.checkNotNullExpressionValue(var60, "timerSelect4");
               ViewExtensionsKt.hide((View)var60);
               View var61 = var31.separator3;
               Intrinsics.checkNotNullExpressionValue(var61, "separator3");
               ViewExtensionsKt.hide(var61);
               TextView var62 = var31.fanSpeedTitle4;
               Intrinsics.checkNotNullExpressionValue(var62, "fanSpeedTitle4");
               ViewExtensionsKt.hide((View)var62);
            } else {
               List var87 = this.tempSelectTvs;
               List var63 = var87;
               if (var87 == null) {
                  Intrinsics.throwUninitializedPropertyAccessException("tempSelectTvs");
                  var63 = null;
               }

               this.tempSelectTvs = CollectionsKt.plus((Collection)var63, var31.timerSelect4);
               var87 = this.drawableList;
               var63 = var87;
               if (var87 == null) {
                  Intrinsics.throwUninitializedPropertyAccessException("drawableList");
                  var63 = null;
               }

               this.drawableList = CollectionsKt.plus((Collection)var63, R.drawable.multi_seekbar_thumb_dark_cerulean);
               TextView var65 = var31.timerSelect4;
               Intrinsics.checkNotNullExpressionValue(var65, "timerSelect4");
               ViewExtensionsKt.show((View)var65, true);
               View var66 = var31.separator3;
               Intrinsics.checkNotNullExpressionValue(var66, "separator3");
               ViewExtensionsKt.show(var66, true);
               TextView var67 = var31.fanSpeedTitle4;
               Intrinsics.checkNotNullExpressionValue(var67, "fanSpeedTitle4");
               ViewExtensionsKt.show((View)var67, true);
            }

            var31.currentUpdateTemp.setVisibility(4);
            var11 = var31.maxTemp;
            StringBuilder var107 = new StringBuilder();
            var107.append(this.maxTemperature);
            String var89 = this.tmpDegreeTxt;
            String var68 = var89;
            if (var89 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("tmpDegreeTxt");
               var68 = null;
            }

            var107.append(var68);
            var89 = this.tmpUnitTxt;
            var68 = var89;
            if (var89 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("tmpUnitTxt");
               var68 = null;
            }

            var107.append(var68);
            var11.setText((CharSequence)var107.toString());
            var11 = var31.minTemp;
            var107 = new StringBuilder();
            var107.append(this.minTemperature);
            var89 = this.tmpDegreeTxt;
            var68 = var89;
            if (var89 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("tmpDegreeTxt");
               var68 = null;
            }

            var107.append(var68);
            var89 = this.tmpUnitTxt;
            var68 = var89;
            if (var89 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("tmpUnitTxt");
               var68 = null;
            }

            var107.append(var68);
            var11.setText((CharSequence)var107.toString());
            TextView var72 = var31.title;
            if (this.isEcoMode) {
               var3 = R.string.eco_fan_preset;
            } else {
               var3 = R.string.auto_fan_preset;
            }

            var72.setText(var3);
            var31.closeBtn.setOnClickListener(new DeviceFanPresetDialogFragment$$ExternalSyntheticLambda1(this));
            var31.btnReset.setOnClickListener(new DeviceFanPresetDialogFragment$$ExternalSyntheticLambda2(this));
            var31.btnApply.setOnClickListener(new DeviceFanPresetDialogFragment$$ExternalSyntheticLambda3(this, var14));
            MultiSlider var109 = var31.rangeSlider;
            var109.setMin(this.minTemperature);
            var109.setMax(this.maxTemperature);
            var109.setStepsThumbsApart(1);
            var109.clearThumbs();
            if (this.isEcoMode) {
               var3 = var4;
            } else {
               var3 = 3;
            }

            for(int var43 = 0; var43 < var3; ++var43) {
               double[] var93 = this.currentPresetArray;
               double[] var73 = var93;
               if (var93 == null) {
                  Intrinsics.throwUninitializedPropertyAccessException("currentPresetArray");
                  var73 = null;
               }

               var6 = this.getTempSliderValue(var73[var43]);
               List var94 = this.tempSelectTvs;
               List var74 = var94;
               if (var94 == null) {
                  Intrinsics.throwUninitializedPropertyAccessException("tempSelectTvs");
                  var74 = null;
               }

               var11 = (TextView)var74.get(var43);
               StringBuilder var114 = new StringBuilder();
               var114.append(var6);
               String var95 = this.tmpDegreeTxt;
               String var75 = var95;
               if (var95 == null) {
                  Intrinsics.throwUninitializedPropertyAccessException("tmpDegreeTxt");
                  var75 = null;
               }

               var114.append(var75);
               var95 = this.tmpUnitTxt;
               var75 = var95;
               if (var95 == null) {
                  Intrinsics.throwUninitializedPropertyAccessException("tmpUnitTxt");
                  var75 = null;
               }

               var114.append(var75);
               var11.setText((CharSequence)var114.toString());
               if (var43 == 0) {
                  DialogfragmentDeviceFanPresetBinding var97 = this.binding;
                  DialogfragmentDeviceFanPresetBinding var77 = var97;
                  if (var97 == null) {
                     Intrinsics.throwUninitializedPropertyAccessException("binding");
                     var77 = null;
                  }

                  TextView var115 = var77.timerSelect1;
                  StringBuilder var113 = new StringBuilder("<");
                  var113.append(var6);
                  String var98 = this.tmpDegreeTxt;
                  String var78 = var98;
                  if (var98 == null) {
                     Intrinsics.throwUninitializedPropertyAccessException("tmpDegreeTxt");
                     var78 = null;
                  }

                  var113.append(var78);
                  var98 = this.tmpUnitTxt;
                  var78 = var98;
                  if (var98 == null) {
                     Intrinsics.throwUninitializedPropertyAccessException("tmpUnitTxt");
                     var78 = null;
                  }

                  var113.append(var78);
                  var115.setText((CharSequence)var113.toString());
               }

               var109.addThumb(var6);
            }

            List var100 = this.drawableList;
            List var80 = var100;
            if (var100 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("drawableList");
               var80 = null;
            }

            Iterator var81 = ((Iterable)var80).iterator();

            for(int var40 = 0; var81.hasNext(); ++var40) {
               Object var101 = var81.next();
               if (var40 < 0) {
                  CollectionsKt.throwIndexOverflow();
               }

               var4 = ((Number)var101).intValue();
               MultiSlider.Thumb var102 = var109.getThumb(var40);
               var102.setRange(AppCompatResources.getDrawable(var109.getContext(), var4));
               var109.setOnClickListener(new DeviceFanPresetDialogFragment$$ExternalSyntheticLambda4(this, var102));
            }

            if (this.isEcoMode) {
               var3 = R.drawable.multi_seekbar_thumb_dark_cerulean;
            } else {
               var3 = R.drawable.multi_seekbar_thumb_oxford_blue;
            }

            var109.setTrackDrawable(AppCompatResources.getDrawable(var109.getContext(), var3));
            var109.setOnTrackingChangeListener(new MultiSlider.OnTrackingChangeListener(this) {
               public double[] oldTempArray;
               final DeviceFanPresetDialogFragment this$0;

               {
                  this.this$0 = var1;
               }

               public final double[] getOldTempArray() {
                  double[] var1 = this.oldTempArray;
                  if (var1 != null) {
                     return var1;
                  } else {
                     Intrinsics.throwUninitializedPropertyAccessException("oldTempArray");
                     return null;
                  }
               }

               public void onStartTrackingTouch(MultiSlider var1, MultiSlider.Thumb var2, int var3) {
                  this.this$0.isReset = false;
                  double[] var5 = this.this$0.currentPresetArray;
                  double[] var4 = var5;
                  if (var5 == null) {
                     Intrinsics.throwUninitializedPropertyAccessException("currentPresetArray");
                     var4 = null;
                  }

                  this.setOldTempArray((double[])var4.clone());
               }

               public void onStopTrackingTouch(MultiSlider var1, MultiSlider.Thumb var2, int var3) {
                  this.this$0.validateTempArray(this.getOldTempArray());
               }

               public final void setOldTempArray(double[] var1) {
                  Intrinsics.checkNotNullParameter(var1, "<set-?>");
                  this.oldTempArray = var1;
               }
            });
            var109.setOnThumbValueChangeListener(new DeviceFanPresetDialogFragment$$ExternalSyntheticLambda5(this));
            var100 = this.tempSelectTvs;
            List var82 = var100;
            if (var100 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("tempSelectTvs");
               var82 = null;
            }

            Iterator var83 = ((Iterable)var82).iterator();

            for(int var42 = var5; var83.hasNext(); ++var42) {
               Object var104 = var83.next();
               if (var42 < 0) {
                  CollectionsKt.throwIndexOverflow();
               }

               TextView var105 = (TextView)var104;
               var105.setOnClickListener(new DeviceFanPresetDialogFragment$$ExternalSyntheticLambda6(this, var14, var42, var105));
            }

            TextView var32 = var31.timerTriggerSelect;
            List var16 = this.tagList;
            if (var16 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("tagList");
               var16 = null;
            }

            var32.setText((CharSequence)var16.get(this.currentTag));
            var32.setOnClickListener(new DeviceFanPresetDialogFragment$$ExternalSyntheticLambda7(this));
            this.updateResetBtnEnable();
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
      d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0013\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"},
      d2 = {"Lcom/blueair/devicedetails/dialog/DeviceFanPresetDialogFragment$Companion;", "", "<init>", "()V", "DEFAULT_PRESET_AUTO", "", "DEFAULT_PRESET_ECO", "newInstance", "Lcom/blueair/devicedetails/dialog/DeviceFanPresetDialogFragment;", "device", "Lcom/blueair/core/model/Device;", "devicedetails_otherRelease"},
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

      public final DeviceFanPresetDialogFragment newInstance(Device var1) {
         Intrinsics.checkNotNullParameter(var1, "device");
         DeviceFanPresetDialogFragment var2 = new DeviceFanPresetDialogFragment();
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
         int[] var0 = new int[ApSubMode.values().length];

         try {
            var0[ApSubMode.ECO.ordinal()] = 1;
         } catch (NoSuchFieldError var2) {
         }

         $EnumSwitchMapping$0 = var0;
      }
   }
}
