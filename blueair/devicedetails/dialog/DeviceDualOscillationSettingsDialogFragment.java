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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.os.BundleKt;
import androidx.core.view.ViewGroupKt;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.blueair.core.model.CalibrationState;
import com.blueair.core.model.Device;
import com.blueair.core.model.DualOscillationConfig;
import com.blueair.core.model.HasDualOscillation;
import com.blueair.core.model.OscillationState;
import com.blueair.devicedetails.databinding.DialogfragmentDeviceOscillationSheetBinding;
import com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel;
import com.blueair.viewcore.R;
import com.blueair.viewcore.dialog.BaseDialogFragment;
import com.blueair.viewcore.dialog.ConfirmationDialogLeftAligned;
import com.blueair.viewcore.view.CirculatorFanContainer;
import com.blueair.viewcore.view.CirculatorFanView;
import com.blueair.viewcore.view.SwitchCompat;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import com.google.android.material.button.MaterialButton;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import java.util.Iterator;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\b\u0007\u0018\u0000 (2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001(B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J$\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u001a\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00182\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010\"\u001a\u00020 H\u0002J\b\u0010#\u001a\u00020 H\u0002J\b\u0010$\u001a\u00020 H\u0002J\b\u0010%\u001a\u00020 H\u0016J\u0010\u0010&\u001a\u00020 2\u0006\u0010'\u001a\u00020\nH\u0016R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\u0002X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006)"},
   d2 = {"Lcom/blueair/devicedetails/dialog/DeviceDualOscillationSettingsDialogFragment;", "Lcom/blueair/viewcore/dialog/BaseDialogFragment;", "Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "horizontal", "", "ignoreCheckChange", "device", "Lcom/blueair/core/model/HasDualOscillation;", "oscillationConfig", "Lcom/blueair/core/model/DualOscillationConfig;", "binding", "Lcom/blueair/devicedetails/databinding/DialogfragmentDeviceOscillationSheetBinding;", "viewModel", "getViewModel", "()Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;", "setViewModel", "(Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;)V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "updateFanWhenDirectionChanged", "updateFanWhenFixedChanged", "updateQuickSetup", "onStart", "showProgress", "shouldShowProgress", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceDualOscillationSettingsDialogFragment extends BaseDialogFragment {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   public static final String EXTRA_HORIZONTAL_MODE = "extra_horizontal_mode";
   private DialogfragmentDeviceOscillationSheetBinding binding;
   private HasDualOscillation device;
   private boolean horizontal = true;
   private boolean ignoreCheckChange;
   private DualOscillationConfig oscillationConfig;
   private final String screenName;
   public DeviceDetailsViewModel viewModel;

   // $FF: synthetic method
   public static void $r8$lambda$6UxcxoAgcmER_E641o6w12V7UR4(DeviceDualOscillationSettingsDialogFragment var0, View var1) {
      onViewCreated$lambda$1(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$XEW9wSIETrMTJPwZYc9LIiChQQo(DeviceDualOscillationSettingsDialogFragment var0, View var1) {
      onViewCreated$lambda$3(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$aaFG5kqBAkt124HsStf3r26YXi4(DeviceDualOscillationSettingsDialogFragment var0, View var1) {
      onViewCreated$lambda$7(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$hOiKnASenS5it6YbDoEgZZOZkMs(DeviceDualOscillationSettingsDialogFragment var0, View var1) {
      onViewCreated$lambda$6(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$jJNKU_oZgP9hh3U_ZNls5_1fiBo/* $FF was: $r8$lambda$jJNKU_oZgP9hh3U-ZNls5-1fiBo*/(DeviceDualOscillationSettingsDialogFragment var0, View var1) {
      onViewCreated$lambda$8(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$nIcJ9Nf7dgKRCwPEUxDsWAta_g4/* $FF was: $r8$lambda$nIcJ9Nf7dgKRCwPEUxDsWAta-g4*/(DeviceDualOscillationSettingsDialogFragment var0, View var1) {
      onViewCreated$lambda$9(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$qCNeJk4jrEmSTDpbdlvnNMPB3ew(DeviceDualOscillationSettingsDialogFragment var0, CompoundButton var1, boolean var2) {
      onViewCreated$lambda$2(var0, var1, var2);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$sD_MX32m_ycyfhf8jYlyhWbnuCo/* $FF was: $r8$lambda$sD-MX32m-ycyfhf8jYlyhWbnuCo*/(DeviceDualOscillationSettingsDialogFragment var0, Device var1) {
      return onViewCreated$lambda$10(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$tHCISe9zOM7orm_OmU4PkVBSZ4s/* $FF was: $r8$lambda$tHCISe9zOM7orm-OmU4PkVBSZ4s*/(DeviceDualOscillationSettingsDialogFragment var0, RadioGroup var1, int var2) {
      onViewCreated$lambda$4(var0, var1, var2);
   }

   private static final void onViewCreated$lambda$1(DeviceDualOscillationSettingsDialogFragment var0, View var1) {
      var0.dismissAllowingStateLoss();
   }

   private static final Unit onViewCreated$lambda$10(DeviceDualOscillationSettingsDialogFragment var0, Device var1) {
      if (var1 instanceof HasDualOscillation) {
         DualOscillationConfig var3 = ((HasDualOscillation)var1).getDualOscillationConfig();
         DualOscillationConfig var2 = var0.oscillationConfig;
         DualOscillationConfig var4 = var2;
         if (var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("oscillationConfig");
            var4 = null;
         }

         if (!Intrinsics.areEqual(var3, var4)) {
            var0.oscillationConfig = var3;
            var0.updateFanWhenDirectionChanged();
         }
      }

      return Unit.INSTANCE;
   }

   private static final void onViewCreated$lambda$2(DeviceDualOscillationSettingsDialogFragment var0, CompoundButton var1, boolean var2) {
      var0.updateFanWhenFixedChanged();
      DeviceDetailsViewModel var5 = var0.getViewModel();
      HasDualOscillation var4 = var0.device;
      HasDualOscillation var7 = var4;
      if (var4 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("device");
         var7 = null;
      }

      var4 = var7;
      boolean var3 = var0.horizontal;
      OscillationState var8;
      if (var2) {
         var8 = OscillationState.SWING;
      } else {
         var8 = OscillationState.DISABLE;
      }

      DualOscillationConfig var6 = var0.oscillationConfig;
      if (var6 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("oscillationConfig");
         var6 = null;
      }

      var5.setDualOscillationConfig(var4, var3, var8, var6, true);
   }

   private static final void onViewCreated$lambda$3(DeviceDualOscillationSettingsDialogFragment var0, View var1) {
      DialogfragmentDeviceOscillationSheetBinding var3 = var0.binding;
      DialogfragmentDeviceOscillationSheetBinding var2 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var2 = null;
      }

      var0.horizontal = Intrinsics.areEqual(var1, var2.btnHorizontal);
      var0.updateFanWhenDirectionChanged();
   }

   private static final void onViewCreated$lambda$4(DeviceDualOscillationSettingsDialogFragment var0, RadioGroup var1, int var2) {
      if (var2 != -1) {
         DialogfragmentDeviceOscillationSheetBinding var6 = var0.binding;
         DialogfragmentDeviceOscillationSheetBinding var9 = var6;
         if (var6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var9 = null;
         }

         if (var9.switchOscillation.isChecked() && !var0.ignoreCheckChange) {
            var6 = var0.binding;
            var9 = var6;
            if (var6 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("binding");
               var9 = null;
            }

            if (var2 == var9.rbAngle30.getId()) {
               var2 = 30;
            } else {
               var6 = var0.binding;
               var9 = var6;
               if (var6 == null) {
                  Intrinsics.throwUninitializedPropertyAccessException("binding");
                  var9 = null;
               }

               if (var2 == var9.rbAngle60.getId()) {
                  var2 = 60;
               } else {
                  var6 = var0.binding;
                  var9 = var6;
                  if (var6 == null) {
                     Intrinsics.throwUninitializedPropertyAccessException("binding");
                     var9 = null;
                  }

                  if (var2 == var9.rbAngle90.getId()) {
                     var2 = 90;
                  } else {
                     var2 = 120;
                  }
               }
            }

            boolean var5 = var0.horizontal;
            int var3;
            if (var5) {
               var3 = (120 - var2) / 2;
            } else {
               var3 = 0;
            }

            int var4 = var2;
            if (var5) {
               var4 = (var2 + 120) / 2;
            }

            if (var5) {
               DualOscillationConfig var25 = var0.oscillationConfig;
               DualOscillationConfig var13 = var25;
               if (var25 == null) {
                  Intrinsics.throwUninitializedPropertyAccessException("oscillationConfig");
                  var13 = null;
               }

               var13.setHorizontalOscillationMinAngle(var3);
               var25 = var0.oscillationConfig;
               var13 = var25;
               if (var25 == null) {
                  Intrinsics.throwUninitializedPropertyAccessException("oscillationConfig");
                  var13 = null;
               }

               var13.setHorizontalOscillationMaxAngle(var4);
            } else {
               DualOscillationConfig var27 = var0.oscillationConfig;
               DualOscillationConfig var15 = var27;
               if (var27 == null) {
                  Intrinsics.throwUninitializedPropertyAccessException("oscillationConfig");
                  var15 = null;
               }

               var15.setVerticalOscillationMinAngle(0);
               var27 = var0.oscillationConfig;
               var15 = var27;
               if (var27 == null) {
                  Intrinsics.throwUninitializedPropertyAccessException("oscillationConfig");
                  var15 = null;
               }

               var15.setVerticalOscillationMaxAngle(var4);
            }

            var6 = var0.binding;
            var9 = var6;
            if (var6 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("binding");
               var9 = null;
            }

            var9.fanContainer.setSwingAngle(var3, var4);
            DeviceDetailsViewModel var7 = var0.getViewModel();
            HasDualOscillation var30 = var0.device;
            HasDualOscillation var18 = var30;
            if (var30 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("device");
               var18 = null;
            }

            var18 = var18;
            var5 = var0.horizontal;
            OscillationState var31 = OscillationState.SWING;
            DualOscillationConfig var8 = var0.oscillationConfig;
            if (var8 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("oscillationConfig");
               var8 = null;
            }

            DeviceDetailsViewModel.setDualOscillationConfig$default(var7, var18, var5, var31, var8, false, 16, (Object)null);
         }
      }

   }

   private static final void onViewCreated$lambda$6(DeviceDualOscillationSettingsDialogFragment var0, View var1) {
      FragmentManager var2 = var0.getChildFragmentManager();
      Intrinsics.checkNotNullExpressionValue(var2, "getChildFragmentManager(...)");
      Intrinsics.checkNotNullExpressionValue("ConfirmationDialogLeftAligned", "getSimpleName(...)");
      if (!(var2.findFragmentByTag("ConfirmationDialogLeftAligned") instanceof ConfirmationDialogLeftAligned) && !var2.isStateSaved()) {
         ((DialogFragment)ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, R.string.reset_position, (Integer)null, R.string.oscillation_reset_positon_info, (Integer)null, (Integer)null, false, false, false, false, (String[])null, (String)null, (Integer)null, (Function1)null, 8160, (Object)null)).show(var2, "ConfirmationDialogLeftAligned");
      }

   }

   private static final void onViewCreated$lambda$7(DeviceDualOscillationSettingsDialogFragment var0, View var1) {
      var0.getViewModel().setOscillationAngleHintClosedBefore(true);
      DialogfragmentDeviceOscillationSheetBinding var4 = var0.binding;
      DialogfragmentDeviceOscillationSheetBinding var2 = var4;
      if (var4 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var2 = null;
      }

      ConstraintLayout var3 = var2.hintAngle.getRoot();
      Intrinsics.checkNotNullExpressionValue(var3, "getRoot(...)");
      ViewExtensionsKt.hide((View)var3);
   }

   private static final void onViewCreated$lambda$8(DeviceDualOscillationSettingsDialogFragment var0, View var1) {
      var0.getViewModel().setOscillationResetPosHintClosedBefore(true);
      DialogfragmentDeviceOscillationSheetBinding var4 = var0.binding;
      DialogfragmentDeviceOscillationSheetBinding var2 = var4;
      if (var4 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var2 = null;
      }

      ConstraintLayout var3 = var2.hintReset.getRoot();
      Intrinsics.checkNotNullExpressionValue(var3, "getRoot(...)");
      ViewExtensionsKt.hide((View)var3);
   }

   private static final void onViewCreated$lambda$9(DeviceDualOscillationSettingsDialogFragment var0, View var1) {
      var0.getViewModel().resetOscillationPosition(var0.horizontal);
   }

   private final void updateFanWhenDirectionChanged() {
      DialogfragmentDeviceOscillationSheetBinding var7 = this.binding;
      Object var6 = null;
      DialogfragmentDeviceOscillationSheetBinding var5 = var7;
      if (var7 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var5 = null;
      }

      var5.fanContainer.setHorizontalMode(this.horizontal);
      var7 = this.binding;
      var5 = var7;
      if (var7 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var5 = null;
      }

      var5.btnHorizontal.setChecked(this.horizontal);
      var7 = this.binding;
      var5 = var7;
      if (var7 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var5 = null;
      }

      MaterialButton var14 = var5.btnVertical;
      boolean var3 = this.horizontal;
      boolean var4 = true;
      var14.setChecked(var3 ^ true);
      var7 = this.binding;
      DialogfragmentDeviceOscillationSheetBinding var15 = var7;
      if (var7 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var15 = null;
      }

      SwitchCompat var8 = var15.switchOscillation;
      DualOscillationConfig var28 = this.oscillationConfig;
      DualOscillationConfig var16 = var28;
      if (var28 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("oscillationConfig");
         var16 = null;
      }

      OscillationState var29 = var16.getState(this.horizontal);
      OscillationState var17 = OscillationState.SWING;
      byte var2 = 0;
      if (var29 == var17) {
         var3 = true;
      } else {
         var3 = false;
      }

      var8.setCheckedSilence(var3);
      DialogfragmentDeviceOscillationSheetBinding var30 = this.binding;
      DialogfragmentDeviceOscillationSheetBinding var18 = var30;
      if (var30 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var18 = null;
      }

      MaterialButton var19 = var18.btnResetPosition;
      int var1;
      if (this.horizontal) {
         var1 = R.string.reset_horizontal_position;
      } else {
         var1 = R.string.reset_vertical_position;
      }

      var19.setText(var1);
      var30 = this.binding;
      DialogfragmentDeviceOscillationSheetBinding var20 = var30;
      if (var30 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var20 = null;
      }

      MaterialButton var33 = var20.btnResetPosition;
      DualOscillationConfig var32 = this.oscillationConfig;
      DualOscillationConfig var21 = var32;
      if (var32 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("oscillationConfig");
         var21 = null;
      }

      if (var21.getCalibrationState(this.horizontal) != CalibrationState.CALIBRATING) {
         var3 = var4;
      } else {
         var3 = false;
      }

      var33.setEnabled(var3);
      DialogfragmentDeviceOscillationSheetBinding var22 = this.binding;
      if (var22 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var22 = (DialogfragmentDeviceOscillationSheetBinding)var6;
      }

      RadioButton var23 = var22.rbAngle120;
      Intrinsics.checkNotNullExpressionValue(var23, "rbAngle120");
      View var24 = (View)var23;
      if (this.horizontal) {
         var1 = var2;
      } else {
         var1 = 8;
      }

      var24.setVisibility(var1);
      this.updateFanWhenFixedChanged();
   }

   private final void updateFanWhenFixedChanged() {
      DialogfragmentDeviceOscillationSheetBinding var5 = this.binding;
      Object var4 = null;
      Object var3 = null;
      DialogfragmentDeviceOscillationSheetBinding var2 = var5;
      if (var5 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var2 = null;
      }

      if (var2.switchOscillation.isChecked()) {
         DialogfragmentDeviceOscillationSheetBinding var13 = this.binding;
         var2 = var13;
         if (var13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var2 = null;
         }

         CirculatorFanContainer var15 = var2.fanContainer;
         DualOscillationConfig var14 = this.oscillationConfig;
         DualOscillationConfig var7 = var14;
         if (var14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("oscillationConfig");
            var7 = null;
         }

         int var1 = var7.getMinAngle(this.horizontal);
         var7 = this.oscillationConfig;
         if (var7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("oscillationConfig");
            var7 = (DualOscillationConfig)var3;
         }

         var15.setSwingAngle(var1, var7.getMaxAngle(this.horizontal));
      } else {
         DialogfragmentDeviceOscillationSheetBinding var11 = this.binding;
         var2 = var11;
         if (var11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var2 = null;
         }

         CirculatorFanContainer var12 = var2.fanContainer;
         DualOscillationConfig var10 = this.oscillationConfig;
         if (var10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("oscillationConfig");
            var10 = (DualOscillationConfig)var4;
         }

         var12.setFixAngle(var10.getFixAngle(this.horizontal));
      }

      this.updateQuickSetup();
   }

   private final void updateQuickSetup() {
      DialogfragmentDeviceOscillationSheetBinding var5 = this.binding;
      Object var4 = null;
      Object var3 = null;
      DialogfragmentDeviceOscillationSheetBinding var2 = var5;
      if (var5 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var2 = null;
      }

      var2.rgAngle.clearCheck();
      var5 = this.binding;
      var2 = var5;
      if (var5 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var2 = null;
      }

      if (var2.switchOscillation.isChecked()) {
         DialogfragmentDeviceOscillationSheetBinding var28 = this.binding;
         var2 = var28;
         if (var28 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var2 = null;
         }

         var2.tvQuickSetup.setAlpha(1.0F);
         var28 = this.binding;
         var2 = var28;
         if (var28 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var2 = null;
         }

         RadioGroup var10 = var2.rgAngle;
         Intrinsics.checkNotNullExpressionValue(var10, "rgAngle");
         Iterator var11 = ViewGroupKt.getChildren((ViewGroup)var10).iterator();

         while(var11.hasNext()) {
            ((View)var11.next()).setEnabled(true);
         }

         DualOscillationConfig var30 = this.oscillationConfig;
         DualOscillationConfig var12 = var30;
         if (var30 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("oscillationConfig");
            var12 = null;
         }

         int var1 = var12.getMinAngle(this.horizontal);
         var30 = this.oscillationConfig;
         var12 = var30;
         if (var30 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("oscillationConfig");
            var12 = null;
         }

         label103: {
            Pair var14 = TuplesKt.to(var1, var12.getMaxAngle(this.horizontal));
            if (this.horizontal) {
               if (Intrinsics.areEqual(var14, TuplesKt.to(45, 75))) {
                  DialogfragmentDeviceOscillationSheetBinding var35 = this.binding;
                  DialogfragmentDeviceOscillationSheetBinding var18 = var35;
                  if (var35 == null) {
                     Intrinsics.throwUninitializedPropertyAccessException("binding");
                     var18 = null;
                  }

                  var1 = var18.rbAngle30.getId();
                  break label103;
               }

               if (Intrinsics.areEqual(var14, TuplesKt.to(30, 90))) {
                  DialogfragmentDeviceOscillationSheetBinding var34 = this.binding;
                  DialogfragmentDeviceOscillationSheetBinding var17 = var34;
                  if (var34 == null) {
                     Intrinsics.throwUninitializedPropertyAccessException("binding");
                     var17 = null;
                  }

                  var1 = var17.rbAngle60.getId();
                  break label103;
               }

               if (Intrinsics.areEqual(var14, TuplesKt.to(15, 105))) {
                  DialogfragmentDeviceOscillationSheetBinding var33 = this.binding;
                  DialogfragmentDeviceOscillationSheetBinding var16 = var33;
                  if (var33 == null) {
                     Intrinsics.throwUninitializedPropertyAccessException("binding");
                     var16 = null;
                  }

                  var1 = var16.rbAngle90.getId();
                  break label103;
               }

               if (Intrinsics.areEqual(var14, TuplesKt.to(0, 120))) {
                  DialogfragmentDeviceOscillationSheetBinding var32 = this.binding;
                  DialogfragmentDeviceOscillationSheetBinding var15 = var32;
                  if (var32 == null) {
                     Intrinsics.throwUninitializedPropertyAccessException("binding");
                     var15 = null;
                  }

                  var1 = var15.rbAngle120.getId();
                  break label103;
               }
            } else {
               if (Intrinsics.areEqual(var14, TuplesKt.to(0, 30))) {
                  DialogfragmentDeviceOscillationSheetBinding var38 = this.binding;
                  DialogfragmentDeviceOscillationSheetBinding var21 = var38;
                  if (var38 == null) {
                     Intrinsics.throwUninitializedPropertyAccessException("binding");
                     var21 = null;
                  }

                  var1 = var21.rbAngle30.getId();
                  break label103;
               }

               if (Intrinsics.areEqual(var14, TuplesKt.to(0, 60))) {
                  DialogfragmentDeviceOscillationSheetBinding var37 = this.binding;
                  DialogfragmentDeviceOscillationSheetBinding var20 = var37;
                  if (var37 == null) {
                     Intrinsics.throwUninitializedPropertyAccessException("binding");
                     var20 = null;
                  }

                  var1 = var20.rbAngle60.getId();
                  break label103;
               }

               if (Intrinsics.areEqual(var14, TuplesKt.to(0, 90))) {
                  DialogfragmentDeviceOscillationSheetBinding var36 = this.binding;
                  DialogfragmentDeviceOscillationSheetBinding var19 = var36;
                  if (var36 == null) {
                     Intrinsics.throwUninitializedPropertyAccessException("binding");
                     var19 = null;
                  }

                  var1 = var19.rbAngle90.getId();
                  break label103;
               }
            }

            var1 = -1;
         }

         if (var1 != -1) {
            this.ignoreCheckChange = true;
            DialogfragmentDeviceOscillationSheetBinding var22 = this.binding;
            if (var22 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("binding");
               var22 = (DialogfragmentDeviceOscillationSheetBinding)var3;
            }

            var22.rgAngle.check(var1);
            this.ignoreCheckChange = false;
            return;
         }
      } else {
         DialogfragmentDeviceOscillationSheetBinding var27 = this.binding;
         var2 = var27;
         if (var27 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var2 = null;
         }

         var2.tvQuickSetup.setAlpha(0.35F);
         var2 = this.binding;
         if (var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var2 = (DialogfragmentDeviceOscillationSheetBinding)var4;
         }

         RadioGroup var25 = var2.rgAngle;
         Intrinsics.checkNotNullExpressionValue(var25, "rgAngle");
         Iterator var26 = ViewGroupKt.getChildren((ViewGroup)var25).iterator();

         while(var26.hasNext()) {
            ((View)var26.next()).setEnabled(false);
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
      Dialog var7 = this.getDialog();
      if (var7 != null) {
         Window var8 = var7.getWindow();
         if (var8 != null) {
            var8.setBackgroundDrawable((Drawable)(new ColorDrawable(0)));
            var8.setWindowAnimations(R.style.dialog_animation);
            var8.setGravity(80);
         }
      }

      this.setViewModel((DeviceDetailsViewModel)((BaseViewModel)(new ViewModelProvider((ViewModelStoreOwner)(this))).get(DeviceDetailsViewModel.class)));
      DialogfragmentDeviceOscillationSheetBinding var6 = DialogfragmentDeviceOscillationSheetBinding.inflate(var1, var2, false);
      Intrinsics.checkNotNullExpressionValue(var6, "inflate(...)");
      this.binding = var6;
      DialogfragmentDeviceOscillationSheetBinding var4 = var6;
      if (var6 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var4 = null;
      }

      ConstraintLayout var5 = var4.getRoot();
      Intrinsics.checkNotNullExpressionValue(var5, "getRoot(...)");
      return (View)var5;
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

   public void onViewCreated(View var1, Bundle var2) {
      Intrinsics.checkNotNullParameter(var1, "view");
      super.onViewCreated(var1, var2);
      Bundle var8 = this.getArguments();
      boolean var5;
      if (var8 != null) {
         var5 = var8.getBoolean("extra_horizontal_mode", this.horizontal);
      } else {
         var5 = this.horizontal;
      }

      this.horizontal = var5;
      var8 = this.getArguments();
      Object var6 = null;
      HasDualOscillation var10;
      if (var8 != null) {
         var10 = (HasDualOscillation)var8.getParcelable("device");
      } else {
         var10 = null;
      }

      if (!(var10 instanceof HasDualOscillation)) {
         var10 = null;
      }

      if (var10 == null) {
         this.dismissAllowingStateLoss();
      } else {
         this.device = var10;
         HasDualOscillation var30 = var10;
         if (var10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("device");
            var30 = null;
         }

         this.oscillationConfig = var30.getDualOscillationConfig();
         this.updateFanWhenDirectionChanged();
         DialogfragmentDeviceOscillationSheetBinding var31 = this.binding;
         DialogfragmentDeviceOscillationSheetBinding var11 = var31;
         if (var31 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var11 = null;
         }

         var11.btnClose.setOnClickListener(new DeviceDualOscillationSettingsDialogFragment$$ExternalSyntheticLambda0(this));
         var31 = this.binding;
         var11 = var31;
         if (var31 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var11 = null;
         }

         var11.switchOscillation.setOnCheckedChangeListener(new DeviceDualOscillationSettingsDialogFragment$$ExternalSyntheticLambda1(this));
         DeviceDualOscillationSettingsDialogFragment$$ExternalSyntheticLambda2 var7 = new DeviceDualOscillationSettingsDialogFragment$$ExternalSyntheticLambda2(this);
         var31 = this.binding;
         var11 = var31;
         if (var31 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var11 = null;
         }

         var11.btnVertical.setOnClickListener(var7);
         var31 = this.binding;
         var11 = var31;
         if (var31 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var11 = null;
         }

         var11.btnHorizontal.setOnClickListener(var7);
         var31 = this.binding;
         var11 = var31;
         if (var31 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var11 = null;
         }

         var11.fanContainer.setOnAngleChangeListener(new CirculatorFanView.OnAngleChangeListener(this) {
            final DeviceDualOscillationSettingsDialogFragment this$0;

            {
               this.this$0 = var1;
            }

            public void onFixAngleChange(int var1) {
               DualOscillationConfig var4 = this.this$0.oscillationConfig;
               DualOscillationConfig var3 = var4;
               if (var4 == null) {
                  Intrinsics.throwUninitializedPropertyAccessException("oscillationConfig");
                  var3 = null;
               }

               if (var3.getFixAngle(this.this$0.horizontal) != var1) {
                  if (this.this$0.horizontal) {
                     var4 = this.this$0.oscillationConfig;
                     var3 = var4;
                     if (var4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("oscillationConfig");
                        var3 = null;
                     }

                     var3.setHorizontalOscillationFixAngle(var1);
                  } else {
                     var4 = this.this$0.oscillationConfig;
                     var3 = var4;
                     if (var4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("oscillationConfig");
                        var3 = null;
                     }

                     var3.setVerticalOscillationFixAngle(var1);
                  }

                  DeviceDetailsViewModel var5 = this.this$0.getViewModel();
                  HasDualOscillation var13 = this.this$0.device;
                  HasDualOscillation var9 = var13;
                  if (var13 == null) {
                     Intrinsics.throwUninitializedPropertyAccessException("device");
                     var9 = null;
                  }

                  var13 = var9;
                  boolean var2 = this.this$0.horizontal;
                  OscillationState var6 = OscillationState.FIXED;
                  DualOscillationConfig var10 = this.this$0.oscillationConfig;
                  if (var10 == null) {
                     Intrinsics.throwUninitializedPropertyAccessException("oscillationConfig");
                     var10 = null;
                  }

                  DeviceDetailsViewModel.setDualOscillationConfig$default(var5, var13, var2, var6, var10, false, 16, (Object)null);
               }
            }

            public void onSwing(int var1, int var2) {
               DualOscillationConfig var5 = this.this$0.oscillationConfig;
               DualOscillationConfig var4 = var5;
               if (var5 == null) {
                  Intrinsics.throwUninitializedPropertyAccessException("oscillationConfig");
                  var4 = null;
               }

               if (var4.getMinAngle(this.this$0.horizontal) == var1) {
                  var5 = this.this$0.oscillationConfig;
                  var4 = var5;
                  if (var5 == null) {
                     Intrinsics.throwUninitializedPropertyAccessException("oscillationConfig");
                     var4 = null;
                  }

                  if (var4.getMaxAngle(this.this$0.horizontal) == var2) {
                     return;
                  }
               }

               if (this.this$0.horizontal) {
                  var5 = this.this$0.oscillationConfig;
                  var4 = var5;
                  if (var5 == null) {
                     Intrinsics.throwUninitializedPropertyAccessException("oscillationConfig");
                     var4 = null;
                  }

                  var4.setHorizontalOscillationMinAngle(var1);
                  var5 = this.this$0.oscillationConfig;
                  var4 = var5;
                  if (var5 == null) {
                     Intrinsics.throwUninitializedPropertyAccessException("oscillationConfig");
                     var4 = null;
                  }

                  var4.setHorizontalOscillationMaxAngle(var2);
               } else {
                  var5 = this.this$0.oscillationConfig;
                  var4 = var5;
                  if (var5 == null) {
                     Intrinsics.throwUninitializedPropertyAccessException("oscillationConfig");
                     var4 = null;
                  }

                  var4.setVerticalOscillationMinAngle(var1);
                  var5 = this.this$0.oscillationConfig;
                  var4 = var5;
                  if (var5 == null) {
                     Intrinsics.throwUninitializedPropertyAccessException("oscillationConfig");
                     var4 = null;
                  }

                  var4.setVerticalOscillationMaxAngle(var2);
               }

               DialogfragmentDeviceOscillationSheetBinding var21 = this.this$0.binding;
               DialogfragmentDeviceOscillationSheetBinding var13 = var21;
               if (var21 == null) {
                  Intrinsics.throwUninitializedPropertyAccessException("binding");
                  var13 = null;
               }

               var13.rgAngle.clearCheck();
               DeviceDetailsViewModel var6 = this.this$0.getViewModel();
               HasDualOscillation var22 = this.this$0.device;
               HasDualOscillation var14 = var22;
               if (var22 == null) {
                  Intrinsics.throwUninitializedPropertyAccessException("device");
                  var14 = null;
               }

               Device var7 = var14;
               boolean var3 = this.this$0.horizontal;
               OscillationState var23 = OscillationState.SWING;
               DualOscillationConfig var15 = this.this$0.oscillationConfig;
               if (var15 == null) {
                  Intrinsics.throwUninitializedPropertyAccessException("oscillationConfig");
                  var15 = null;
               }

               DeviceDetailsViewModel.setDualOscillationConfig$default(var6, var7, var3, var23, var15, false, 16, (Object)null);
            }
         });
         var31 = this.binding;
         var11 = var31;
         if (var31 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var11 = null;
         }

         var11.rgAngle.setOnCheckedChangeListener(new DeviceDualOscillationSettingsDialogFragment$$ExternalSyntheticLambda3(this));
         var31 = this.binding;
         var11 = var31;
         if (var31 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var11 = null;
         }

         var11.ivInfo.setOnClickListener(new DeviceDualOscillationSettingsDialogFragment$$ExternalSyntheticLambda4(this));
         var31 = this.binding;
         var11 = var31;
         if (var31 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var11 = null;
         }

         var11.hintAngle.hintText.setText(R.string.oscillation_angle_hint);
         var31 = this.binding;
         var11 = var31;
         if (var31 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var11 = null;
         }

         var11.hintReset.hintText.setText(R.string.oscillation_reset_positon_hint);
         var31 = this.binding;
         var11 = var31;
         if (var31 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var11 = null;
         }

         ConstraintLayout var21 = var11.hintAngle.getRoot();
         Intrinsics.checkNotNullExpressionValue(var21, "getRoot(...)");
         View var22 = (View)var21;
         var5 = this.getViewModel().getOscillationAngleHintClosedBefore();
         byte var4 = 0;
         byte var3;
         if (!var5) {
            var3 = 0;
         } else {
            var3 = 8;
         }

         var22.setVisibility(var3);
         var31 = this.binding;
         DialogfragmentDeviceOscillationSheetBinding var23 = var31;
         if (var31 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var23 = null;
         }

         ConstraintLayout var24 = var23.hintReset.getRoot();
         Intrinsics.checkNotNullExpressionValue(var24, "getRoot(...)");
         View var25 = (View)var24;
         if (!this.getViewModel().getOscillationResetPosHintClosedBefore()) {
            var3 = var4;
         } else {
            var3 = 8;
         }

         var25.setVisibility(var3);
         var31 = this.binding;
         DialogfragmentDeviceOscillationSheetBinding var26 = var31;
         if (var31 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var26 = null;
         }

         var26.hintAngle.btnCloseHint.setOnClickListener(new DeviceDualOscillationSettingsDialogFragment$$ExternalSyntheticLambda5(this));
         var31 = this.binding;
         var26 = var31;
         if (var31 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var26 = null;
         }

         var26.hintReset.btnCloseHint.setOnClickListener(new DeviceDualOscillationSettingsDialogFragment$$ExternalSyntheticLambda6(this));
         var31 = this.binding;
         var26 = var31;
         if (var31 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var26 = null;
         }

         var26.btnResetPosition.setOnClickListener(new DeviceDualOscillationSettingsDialogFragment$$ExternalSyntheticLambda7(this));
         DeviceDetailsViewModel var45 = this.getViewModel();
         HasDualOscillation var29 = this.device;
         if (var29 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("device");
            var29 = (HasDualOscillation)var6;
         }

         var45.setDeviceId(var29.getUid());
         this.getViewModel().getLiveDevice().observe((LifecycleOwner)this, new Observer(new DeviceDualOscillationSettingsDialogFragment$$ExternalSyntheticLambda8(this)) {
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

   public void setViewModel(DeviceDetailsViewModel var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.viewModel = var1;
   }

   public void showProgress(boolean var1) {
   }

   @Metadata(
      d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"},
      d2 = {"Lcom/blueair/devicedetails/dialog/DeviceDualOscillationSettingsDialogFragment$Companion;", "", "<init>", "()V", "EXTRA_HORIZONTAL_MODE", "", "newInstance", "Lcom/blueair/devicedetails/dialog/DeviceDualOscillationSettingsDialogFragment;", "device", "Lcom/blueair/core/model/Device;", "horizontal", "", "devicedetails_otherRelease"},
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

      public final DeviceDualOscillationSettingsDialogFragment newInstance(Device var1, boolean var2) {
         Intrinsics.checkNotNullParameter(var1, "device");
         DeviceDualOscillationSettingsDialogFragment var3 = new DeviceDualOscillationSettingsDialogFragment();
         var3.setArguments(BundleKt.bundleOf(new Pair[]{TuplesKt.to("device", var1), TuplesKt.to("extra_horizontal_mode", var2)}));
         return var3;
      }
   }
}
