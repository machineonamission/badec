package com.blueair.devicedetails.dialog;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.os.BundleKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.blueair.core.model.ApSubMode;
import com.blueair.core.model.Device;
import com.blueair.core.model.HasCombo3in1MainMode;
import com.blueair.core.model.HasOscillation;
import com.blueair.core.model.OscillationDirection;
import com.blueair.core.model.OscillationFanSpeed;
import com.blueair.devicedetails.databinding.DialogfragmentDeviceOscillationSettingsBinding;
import com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel;
import com.blueair.viewcore.R;
import com.blueair.viewcore.dialog.BaseDialogFragment;
import com.blueair.viewcore.view.FanView;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(
   d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 32\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00013B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J$\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0002J\b\u0010'\u001a\u00020(H\u0002J\u0010\u0010)\u001a\u00020$2\u0006\u0010*\u001a\u00020+H\u0002J\b\u0010,\u001a\u00020$H\u0002J\b\u0010-\u001a\u00020$H\u0002J\u0010\u0010.\u001a\u00020$2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010/\u001a\u00020$H\u0002J\b\u00100\u001a\u00020$H\u0016J\u0010\u00101\u001a\u00020$2\u0006\u00102\u001a\u00020&H\u0016R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\u0002X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0011X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00140\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0019\u001a\n \u001b*\u0004\u0018\u00010\u001a0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00064"},
   d2 = {"Lcom/blueair/devicedetails/dialog/DeviceOscillationSettingsDialogFragment;", "Lcom/blueair/viewcore/dialog/BaseDialogFragment;", "Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "binding", "Lcom/blueair/devicedetails/databinding/DialogfragmentDeviceOscillationSettingsBinding;", "viewModel", "getViewModel", "()Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;", "setViewModel", "(Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;)V", "angleBarLabels", "", "Landroid/widget/TextView;", "angleSeparatorList", "Landroid/view/View;", "speedBarLabels", "speedSeparatorList", "currentDirection", "Lcom/blueair/core/model/OscillationDirection;", "mAnimator", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "disableView", "", "disable", "", "currentAngleBarValue", "", "update", "device", "Lcom/blueair/core/model/HasOscillation;", "updateSpeedLabel", "updateFanView", "updateDeviceImageAngle", "updateAngleLabel", "onStart", "showProgress", "shouldShowProgress", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceOscillationSettingsDialogFragment extends BaseDialogFragment {
   private static final List ANGLES = CollectionsKt.listOf(new Integer[]{45, 90, 180, 270, 350});
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private List angleBarLabels;
   private List angleSeparatorList;
   private DialogfragmentDeviceOscillationSettingsBinding binding;
   private OscillationDirection currentDirection;
   private final ValueAnimator mAnimator;
   private final String screenName;
   private List speedBarLabels;
   private List speedSeparatorList;
   public DeviceDetailsViewModel viewModel;

   // $FF: synthetic method
   public static void $r8$lambda$5oAb5pax77Z0JhIfmVmM4_09pU0/* $FF was: $r8$lambda$5oAb5pax77Z0JhIfmVmM4-09pU0*/(DeviceOscillationSettingsDialogFragment var0, View var1) {
      onCreateView$lambda$8$lambda$5(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$Gz4iNoQ7CNAK3_NkPpfA_Khit4U/* $FF was: $r8$lambda$Gz4iNoQ7CNAK3_NkPpfA-Khit4U*/(DeviceOscillationSettingsDialogFragment var0, View var1) {
      onCreateView$lambda$8$lambda$2(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$JJRIqYSsLoY_PuVA0T2XKNVj1Hc(DeviceOscillationSettingsDialogFragment var0, int var1, ValueAnimator var2) {
      updateDeviceImageAngle$lambda$13(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$ZKrw_zaifcvv9Q6Gc6H1RZtg7eE(DeviceOscillationSettingsDialogFragment var0, View var1) {
      onCreateView$lambda$8$lambda$6(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$cTtqu3vg6WyQwtvO9oG_N7HTQys/* $FF was: $r8$lambda$cTtqu3vg6WyQwtvO9oG-N7HTQys*/(DialogfragmentDeviceOscillationSettingsBinding var0, HasOscillation var1, DeviceOscillationSettingsDialogFragment var2, View var3) {
      onCreateView$lambda$8$lambda$4(var0, var1, var2, var3);
   }

   // $FF: synthetic method
   public static void $r8$lambda$zRQK2clY3rUJFUK0XsJYyEIFxtM(DeviceOscillationSettingsDialogFragment var0, View var1) {
      onCreateView$lambda$8$lambda$7(var0, var1);
   }

   public DeviceOscillationSettingsDialogFragment() {
      this.currentDirection = OscillationDirection.STRAIGHT;
      ValueAnimator var1 = ValueAnimator.ofFloat(new float[]{0.0F, 1.0F});
      var1.setDuration(1000L);
      var1.setInterpolator((TimeInterpolator)(new AccelerateDecelerateInterpolator()));
      this.mAnimator = var1;
   }

   private final int currentAngleBarValue() {
      List var3 = ANGLES;
      DialogfragmentDeviceOscillationSettingsBinding var2 = this.binding;
      DialogfragmentDeviceOscillationSettingsBinding var1 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var1 = null;
      }

      return ((Number)var3.get(var1.seekbarAngle.getProgress() - 1)).intValue();
   }

   private final void disableView(boolean var1) {
      DialogfragmentDeviceOscillationSettingsBinding var4 = this.binding;
      Object var3 = null;
      DialogfragmentDeviceOscillationSettingsBinding var2 = var4;
      if (var4 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var2 = null;
      }

      var2.seekbarAngle.setEnabled(var1 ^ true);
      var2 = this.binding;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var2 = (DialogfragmentDeviceOscillationSettingsBinding)var3;
      }

      var2.seekbarSpeed.setEnabled(var1 ^ true);
   }

   private static final void onCreateView$lambda$8$lambda$2(DeviceOscillationSettingsDialogFragment var0, View var1) {
      var0.dismissAllowingStateLoss();
   }

   private static final void onCreateView$lambda$8$lambda$4(DialogfragmentDeviceOscillationSettingsBinding var0, HasOscillation var1, DeviceOscillationSettingsDialogFragment var2, View var3) {
      int var4 = var0.seekbarSpeed.getProgress();
      OscillationFanSpeed var5;
      if (var4 != 2) {
         if (var4 != 3) {
            var5 = OscillationFanSpeed.SPEED_1;
         } else {
            var5 = OscillationFanSpeed.SPEED_3;
         }
      } else {
         var5 = OscillationFanSpeed.SPEED_2;
      }

      if (var1 != null) {
         var2.getViewModel().setOscillationParams(var1, var2.currentAngleBarValue(), var2.currentDirection.getValue(), var5.getValue());
      }

      var2.dismissAllowingStateLoss();
   }

   private static final void onCreateView$lambda$8$lambda$5(DeviceOscillationSettingsDialogFragment var0, View var1) {
      var0.currentDirection = OscillationDirection.LEFT;
      var0.updateFanView();
   }

   private static final void onCreateView$lambda$8$lambda$6(DeviceOscillationSettingsDialogFragment var0, View var1) {
      var0.currentDirection = OscillationDirection.STRAIGHT;
      var0.updateFanView();
   }

   private static final void onCreateView$lambda$8$lambda$7(DeviceOscillationSettingsDialogFragment var0, View var1) {
      var0.currentDirection = OscillationDirection.RIGHT;
      var0.updateFanView();
   }

   private final void update(HasOscillation var1) {
      boolean var4;
      if (var1 instanceof HasCombo3in1MainMode && ((HasCombo3in1MainMode)var1).currentSubMode() == ApSubMode.ECO) {
         var4 = true;
      } else {
         var4 = false;
      }

      this.currentDirection = var1.oscillationDirection();
      DialogfragmentDeviceOscillationSettingsBinding var6 = this.binding;
      DialogfragmentDeviceOscillationSettingsBinding var5 = var6;
      if (var6 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var5 = null;
      }

      Iterator var10 = ANGLES.iterator();
      int var2 = 0;

      while(true) {
         if (!var10.hasNext()) {
            var2 = -1;
            break;
         }

         if (((Number)var10.next()).intValue() >= var1.getOscillationAngle()) {
            break;
         }

         ++var2;
      }

      var2 = RangesKt.coerceAtLeast(var2, 0) + 1;
      if (var2 == var5.seekbarAngle.getProgress()) {
         this.updateFanView();
      } else {
         var5.seekbarAngle.setProgress(var2);
      }

      this.updateAngleLabel();
      OscillationFanSpeed var7 = var1.oscillationFanSpeed();
      int var3 = DeviceOscillationSettingsDialogFragment.WhenMappings.$EnumSwitchMapping$0[var7.ordinal()];
      if (var3 != 1) {
         var2 = 2;
         if (var3 != 2) {
            var2 = 3;
            if (var3 != 3) {
               throw new NoWhenBranchMatchedException();
            }
         }
      } else {
         var2 = 1;
      }

      var5.tvSpeedValue.setText((CharSequence)String.valueOf(var2));
      var5.seekbarSpeed.setProgress(var2 - 1);
      this.updateSpeedLabel();
      this.disableView(var4);
   }

   private final void updateAngleLabel() {
      StringBuilder var7 = new StringBuilder();
      var7.append(this.currentAngleBarValue());
      Context var6 = this.getContext();
      String var9;
      if (var6 != null) {
         var9 = var6.getString(R.string.temperature_degree);
      } else {
         var9 = null;
      }

      var7.append(var9);
      String var8 = var7.toString();
      DialogfragmentDeviceOscillationSettingsBinding var21 = this.binding;
      DialogfragmentDeviceOscillationSettingsBinding var10 = var21;
      if (var21 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var10 = null;
      }

      TextView var11 = var10.oscillationDiagramAngle;
      CharSequence var30 = (CharSequence)var8;
      var11.setText(var30);
      var21 = this.binding;
      DialogfragmentDeviceOscillationSettingsBinding var12 = var21;
      if (var21 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var12 = null;
      }

      var12.tvAngleValue.setText(var30);
      var21 = this.binding;
      var12 = var21;
      if (var21 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var12 = null;
      }

      int var4 = var12.seekbarAngle.getProgress();
      var21 = this.binding;
      var12 = var21;
      if (var21 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var12 = null;
      }

      Context var15 = var12.getRoot().getContext();
      int var3 = var15.getColor(R.color.colorPrimary);
      int var5 = var15.getColor(R.color.surface_dark_55);
      List var25 = this.angleBarLabels;
      List var16 = var25;
      if (var25 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("angleBarLabels");
         var16 = null;
      }

      int var2 = var16.size();

      for(int var1 = 0; var1 < var2; ++var1) {
         if (var1 > var4 - 1) {
            var25 = this.angleBarLabels;
            var16 = var25;
            if (var25 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("angleBarLabels");
               var16 = null;
            }

            ((TextView)var16.get(var1)).setTextColor(var5);
            var25 = this.angleSeparatorList;
            var16 = var25;
            if (var25 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("angleSeparatorList");
               var16 = null;
            }

            ((View)var16.get(var1)).setBackgroundResource(R.drawable.rounded_rectangle_dark_45_r4);
         } else {
            var25 = this.angleBarLabels;
            var16 = var25;
            if (var25 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("angleBarLabels");
               var16 = null;
            }

            ((TextView)var16.get(var1)).setTextColor(var3);
            var25 = this.angleSeparatorList;
            var16 = var25;
            if (var25 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("angleSeparatorList");
               var16 = null;
            }

            ((View)var16.get(var1)).setBackgroundResource(R.drawable.rounded_rectangle_primary_r4);
         }
      }

   }

   private final void updateDeviceImageAngle(OscillationDirection var1) {
      int var2 = DeviceOscillationSettingsDialogFragment.WhenMappings.$EnumSwitchMapping$1[var1.ordinal()];
      if (var2 != 1) {
         if (var2 != 2) {
            if (var2 != 3) {
               throw new NoWhenBranchMatchedException();
            }

            var2 = -90;
         } else {
            var2 = 0;
         }
      } else {
         var2 = 90;
      }

      this.mAnimator.removeAllUpdateListeners();
      this.mAnimator.addUpdateListener(new DeviceOscillationSettingsDialogFragment$$ExternalSyntheticLambda0(this, var2));
      this.mAnimator.start();
   }

   private static final void updateDeviceImageAngle$lambda$13(DeviceOscillationSettingsDialogFragment var0, int var1, ValueAnimator var2) {
      Intrinsics.checkNotNullParameter(var2, "animation");
      DialogfragmentDeviceOscillationSettingsBinding var7 = (DialogfragmentDeviceOscillationSettingsBinding)var2.getAnimatedValue();
      Intrinsics.checkNotNull(var7, "null cannot be cast to non-null type kotlin.Float");
      float var3 = (Float)var7;
      DialogfragmentDeviceOscillationSettingsBinding var5 = var0.binding;
      Object var4 = null;
      var7 = var5;
      if (var5 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var7 = null;
      }

      AppCompatImageView var9 = var7.deviceImage;
      FanView.Companion var10 = FanView.Companion;
      DialogfragmentDeviceOscillationSettingsBinding var6 = var0.binding;
      if (var6 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var6 = (DialogfragmentDeviceOscillationSettingsBinding)var4;
      }

      var9.setRotation(var10.lerp(var6.deviceImage.getRotation(), (float)var1, var3));
   }

   private final void updateFanView() {
      DialogfragmentDeviceOscillationSettingsBinding var3 = this.binding;
      DialogfragmentDeviceOscillationSettingsBinding var2 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var2 = null;
      }

      AppCompatImageView var6 = var2.arrowLeft;
      int var1;
      if (this.currentDirection == OscillationDirection.LEFT) {
         var1 = R.drawable.ic_arrow_left_on;
      } else {
         var1 = R.drawable.ic_arrow_left_off;
      }

      var6.setImageResource(var1);
      var6 = var2.arrowStraight;
      if (this.currentDirection == OscillationDirection.STRAIGHT) {
         var1 = R.drawable.ic_arrow_straight_on;
      } else {
         var1 = R.drawable.ic_arrow_straight_off;
      }

      var6.setImageResource(var1);
      var6 = var2.arrowRight;
      if (this.currentDirection == OscillationDirection.RIGHT) {
         var1 = R.drawable.ic_arrow_right_on;
      } else {
         var1 = R.drawable.ic_arrow_right_off;
      }

      var6.setImageResource(var1);
      var2.fanView.animateFanAngles(this.currentAngleBarValue(), this.currentDirection);
      this.updateDeviceImageAngle(this.currentDirection);
      this.updateAngleLabel();
   }

   private final void updateSpeedLabel() {
      DialogfragmentDeviceOscillationSettingsBinding var7 = this.binding;
      DialogfragmentDeviceOscillationSettingsBinding var6 = var7;
      if (var7 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var6 = null;
      }

      int var4 = var6.seekbarSpeed.getProgress();
      var7 = this.binding;
      var6 = var7;
      if (var7 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var6 = null;
      }

      Context var9 = var6.getRoot().getContext();
      int var3 = var9.getColor(R.color.colorPrimary);
      int var2 = var9.getColor(R.color.surface_dark_55);
      List var16 = this.speedBarLabels;
      List var10 = var16;
      if (var16 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("speedBarLabels");
         var10 = null;
      }

      int var5 = var10.size();

      for(int var1 = 0; var1 < var5; ++var1) {
         if (var1 > var4) {
            var16 = this.speedBarLabels;
            var10 = var16;
            if (var16 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("speedBarLabels");
               var10 = null;
            }

            ((TextView)var10.get(var1)).setTextColor(var2);
            var16 = this.speedSeparatorList;
            var10 = var16;
            if (var16 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("speedSeparatorList");
               var10 = null;
            }

            ((View)var10.get(var1)).setBackgroundResource(R.drawable.rounded_rectangle_dark_45_r4);
         } else {
            var16 = this.speedBarLabels;
            var10 = var16;
            if (var16 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("speedBarLabels");
               var10 = null;
            }

            ((TextView)var10.get(var1)).setTextColor(var3);
            var16 = this.speedSeparatorList;
            var10 = var16;
            if (var16 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("speedSeparatorList");
               var10 = null;
            }

            ((View)var10.get(var1)).setBackgroundResource(R.drawable.rounded_rectangle_primary_r4);
         }
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
      Dialog var16 = this.getDialog();
      if (var16 != null) {
         Window var17 = var16.getWindow();
         if (var17 != null) {
            var17.setBackgroundDrawable((Drawable)(new ColorDrawable(0)));
            var17.setWindowAnimations(R.style.dialog_animation);
            var17.setGravity(80);
         }
      }

      Bundle var18 = this.getArguments();
      Object var4 = null;
      HasOscillation var19;
      if (var18 != null) {
         var19 = (HasOscillation)var18.getParcelable("device");
      } else {
         var19 = null;
      }

      if (!(var19 instanceof HasOscillation)) {
         var19 = null;
      }

      if (var19 instanceof HasCombo3in1MainMode) {
         ((HasCombo3in1MainMode)var19).currentSubMode();
         ApSubMode var5 = ApSubMode.ECO;
      }

      this.setViewModel((DeviceDetailsViewModel)((BaseViewModel)(new ViewModelProvider((ViewModelStoreOwner)(this))).get(DeviceDetailsViewModel.class)));
      DialogfragmentDeviceOscillationSettingsBinding var9 = DialogfragmentDeviceOscillationSettingsBinding.inflate(var1, var2, false);
      Intrinsics.checkNotNullExpressionValue(var9, "inflate(...)");
      TextView var8 = var9.angleLevel1;
      Intrinsics.checkNotNullExpressionValue(var8, "angleLevel1");
      TextView var12 = var9.angleLevel2;
      Intrinsics.checkNotNullExpressionValue(var12, "angleLevel2");
      TextView var6 = var9.angleLevel3;
      Intrinsics.checkNotNullExpressionValue(var6, "angleLevel3");
      TextView var20 = var9.angleLevel4;
      Intrinsics.checkNotNullExpressionValue(var20, "angleLevel4");
      TextView var7 = var9.angleLevel5;
      Intrinsics.checkNotNullExpressionValue(var7, "angleLevel5");
      this.angleBarLabels = CollectionsKt.listOf(new TextView[]{var8, var12, var6, var20, var7});
      View var13 = var9.separatorAngle1;
      Intrinsics.checkNotNullExpressionValue(var13, "separatorAngle1");
      View var24 = var9.separatorAngle2;
      Intrinsics.checkNotNullExpressionValue(var24, "separatorAngle2");
      View var27 = var9.separatorAngle3;
      Intrinsics.checkNotNullExpressionValue(var27, "separatorAngle3");
      View var28 = var9.separatorAngle4;
      Intrinsics.checkNotNullExpressionValue(var28, "separatorAngle4");
      View var21 = var9.separatorAngle5;
      Intrinsics.checkNotNullExpressionValue(var21, "separatorAngle5");
      this.angleSeparatorList = CollectionsKt.listOf(new View[]{var13, var24, var27, var28, var21});
      TextView var25 = var9.speedLevel1;
      Intrinsics.checkNotNullExpressionValue(var25, "speedLevel1");
      TextView var22 = var9.speedLevel2;
      Intrinsics.checkNotNullExpressionValue(var22, "speedLevel2");
      TextView var14 = var9.speedLevel3;
      Intrinsics.checkNotNullExpressionValue(var14, "speedLevel3");
      this.speedBarLabels = CollectionsKt.listOf(new TextView[]{var25, var22, var14});
      View var23 = var9.separatorSpeed1;
      Intrinsics.checkNotNullExpressionValue(var23, "separatorSpeed1");
      View var15 = var9.separatorSpeed2;
      Intrinsics.checkNotNullExpressionValue(var15, "separatorSpeed2");
      View var26 = var9.separatorSpeed3;
      Intrinsics.checkNotNullExpressionValue(var26, "separatorSpeed3");
      this.speedSeparatorList = CollectionsKt.listOf(new View[]{var23, var15, var26});
      var9.btnClose.setOnClickListener(new DeviceOscillationSettingsDialogFragment$$ExternalSyntheticLambda1(this));
      var9.btnDone.setOnClickListener(new DeviceOscillationSettingsDialogFragment$$ExternalSyntheticLambda2(var9, var19, this));
      var9.fanView.setInAttribute(false);
      var9.seekbarSpeed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(var9, this) {
         final DialogfragmentDeviceOscillationSettingsBinding $this_apply;
         final DeviceOscillationSettingsDialogFragment this$0;

         {
            this.$this_apply = var1;
            this.this$0 = var2;
         }

         public void onProgressChanged(SeekBar var1, int var2, boolean var3) {
            this.$this_apply.tvSpeedValue.setText((CharSequence)String.valueOf(var2 + 1));
            this.this$0.updateSpeedLabel();
         }

         public void onStartTrackingTouch(SeekBar var1) {
         }

         public void onStopTrackingTouch(SeekBar var1) {
         }
      });
      var9.seekbarAngle.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(this) {
         final DeviceOscillationSettingsDialogFragment this$0;

         {
            this.this$0 = var1;
         }

         public void onProgressChanged(SeekBar var1, int var2, boolean var3) {
            this.this$0.updateFanView();
         }

         public void onStartTrackingTouch(SeekBar var1) {
         }

         public void onStopTrackingTouch(SeekBar var1) {
         }
      });
      var9.arrowLeft.setOnClickListener(new DeviceOscillationSettingsDialogFragment$$ExternalSyntheticLambda3(this));
      var9.arrowStraight.setOnClickListener(new DeviceOscillationSettingsDialogFragment$$ExternalSyntheticLambda4(this));
      var9.arrowRight.setOnClickListener(new DeviceOscillationSettingsDialogFragment$$ExternalSyntheticLambda5(this));
      this.binding = var9;
      if (var19 != null) {
         this.update(var19);
      }

      var9 = this.binding;
      if (var9 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var9 = (DialogfragmentDeviceOscillationSettingsBinding)var4;
      }

      ConstraintLayout var11 = var9.getRoot();
      Intrinsics.checkNotNullExpressionValue(var11, "getRoot(...)");
      return (View)var11;
   }

   public void onStart() {
      super.onStart();
      Dialog var1 = this.getDialog();
      if (var1 != null) {
         Window var2 = var1.getWindow();
         if (var2 != null) {
            var2.addFlags(Integer.MIN_VALUE);
            var2.getDecorView().setSystemUiVisibility(8448);
            var2.setStatusBarColor(0);
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
      d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\r"},
      d2 = {"Lcom/blueair/devicedetails/dialog/DeviceOscillationSettingsDialogFragment$Companion;", "", "<init>", "()V", "ANGLES", "", "", "getANGLES", "()Ljava/util/List;", "newInstance", "Lcom/blueair/devicedetails/dialog/DeviceOscillationSettingsDialogFragment;", "device", "Lcom/blueair/core/model/Device;", "devicedetails_otherRelease"},
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

      public final List getANGLES() {
         return DeviceOscillationSettingsDialogFragment.ANGLES;
      }

      public final DeviceOscillationSettingsDialogFragment newInstance(Device var1) {
         Intrinsics.checkNotNullParameter(var1, "device");
         DeviceOscillationSettingsDialogFragment var2 = new DeviceOscillationSettingsDialogFragment();
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
      public static final int[] $EnumSwitchMapping$1;

      static {
         int[] var0 = new int[OscillationFanSpeed.values().length];

         try {
            var0[OscillationFanSpeed.SPEED_1.ordinal()] = 1;
         } catch (NoSuchFieldError var7) {
         }

         try {
            var0[OscillationFanSpeed.SPEED_2.ordinal()] = 2;
         } catch (NoSuchFieldError var6) {
         }

         try {
            var0[OscillationFanSpeed.SPEED_3.ordinal()] = 3;
         } catch (NoSuchFieldError var5) {
         }

         $EnumSwitchMapping$0 = var0;
         var0 = new int[OscillationDirection.values().length];

         try {
            var0[OscillationDirection.LEFT.ordinal()] = 1;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[OscillationDirection.STRAIGHT.ordinal()] = 2;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[OscillationDirection.RIGHT.ordinal()] = 3;
         } catch (NoSuchFieldError var2) {
         }

         $EnumSwitchMapping$1 = var0;
      }
   }
}
