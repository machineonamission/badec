package com.blueair.antifake.fragmnet;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherKt;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.blueair.antifake.databinding.FragmentResetFilterBinding;
import com.blueair.antifake.dialog.AntiFakeActionDialogFragment;
import com.blueair.antifake.dialog.ManualResetFilterDialog;
import com.blueair.antifake.viewmodel.AntiFakeViewModel;
import com.blueair.antifake.viewmodel.BluetoothResult;
import com.blueair.antifake.viewmodel.ResetResult;
import com.blueair.core.model.AwsLinkConfig;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceBlue40;
import com.blueair.core.model.DeviceFilterType;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.DeviceType;
import com.blueair.core.model.FilterConfig;
import com.blueair.core.model.HasSKU;
import com.blueair.devicedetails.activity.DeviceFilterDetailActivity;
import com.blueair.devicedetails.dialog.DeviceDetailsDialogFragment;
import com.blueair.devicedetails.dialog.DeviceNFilterDialogFragment;
import com.blueair.viewcore.R;
import com.blueair.viewcore.activity.Actions;
import com.blueair.viewcore.dialog.ConfirmationDialogLeftAligned;
import com.blueair.viewcore.dialog.GuidesData;
import com.blueair.viewcore.dialog.StepGuideDialogFragment;
import com.blueair.viewcore.dialog.StepGuides;
import com.blueair.viewcore.extensions.FragmentExtensionsKt;
import com.blueair.viewcore.extensions.TextViewExtensionsKt;
import com.blueair.viewcore.fragment.BaseFragment;
import com.blueair.viewcore.utils.DeviceConfigProvider;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import com.google.android.material.button.MaterialButton;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J$\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0015H\u0002J\u0010\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0019H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\u0002X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u001b"},
   d2 = {"Lcom/blueair/antifake/fragmnet/ResetFilterFragment;", "Lcom/blueair/viewcore/fragment/BaseFragment;", "Lcom/blueair/antifake/viewmodel/AntiFakeViewModel;", "<init>", "()V", "binding", "Lcom/blueair/antifake/databinding/FragmentResetFilterBinding;", "viewModel", "getViewModel", "()Lcom/blueair/antifake/viewmodel/AntiFakeViewModel;", "setViewModel", "(Lcom/blueair/antifake/viewmodel/AntiFakeViewModel;)V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "setupFinishBtn", "", "setupManualResetBtn", "showProgress", "shouldShowProgress", "", "Companion", "antifake_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class ResetFilterFragment extends BaseFragment {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private FragmentResetFilterBinding binding;
   public AntiFakeViewModel viewModel;

   // $FF: synthetic method
   public static void $r8$lambda$0x2sPx1iC5naAjb1w_2gCL4_g5c/* $FF was: $r8$lambda$0x2sPx1iC5naAjb1w-2gCL4-g5c*/(ResetFilterFragment var0, View var1) {
      setupFinishBtn$lambda$15(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$2J_YeO4SLYEd_2VuG5fWNqtuxt0/* $FF was: $r8$lambda$2J-YeO4SLYEd_2VuG5fWNqtuxt0*/(ResetFilterFragment var0, OnBackPressedCallback var1) {
      return onCreateView$lambda$2(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$6B3FZSqLz_Dl_QdMl7Hr7BDA_YA(ResetFilterFragment var0, String var1, Bundle var2) {
      return onCreateView$lambda$8$lambda$7(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$Gou_0il5VTXmvtlP6kODtANBL3g(ResetFilterFragment var0, View var1) {
      onCreateView$lambda$14$lambda$9(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$PqY0j4I9gL_rkpQ6Ov9KVgNIp84/* $FF was: $r8$lambda$PqY0j4I9gL-rkpQ6Ov9KVgNIp84*/(ResetFilterFragment var0, boolean var1) {
      return onCreateView$lambda$2$lambda$1$lambda$0(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$Y3DcKZ0Vx5v_tEJWao14g_WlLWo(ResetFilterFragment var0, String var1, Bundle var2) {
      return onCreateView$lambda$14$lambda$13(var0, var1, var2);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$_T5hzKovxB3uqIjAIugUsbL44KA(ResetFilterFragment var0, String var1, Bundle var2) {
      return onCreateView$lambda$14$lambda$11(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$c4KNpUJ6IieG7snZl9ZWalV1G4U(ResetFilterFragment var0, View var1) {
      onCreateView$lambda$5(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$fBpZExGQVKDXSPZtQamwI2Vv_CI(ResetFilterFragment var0, ResetResult var1) {
      return onCreateView$lambda$14(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$m9s5zT8UYYigN1a81Z195KwO3pU(ResetFilterFragment var0, View var1) {
      onCreateView$lambda$4(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$pCBYZkMtbcvHawf576z5sNhRjDY(ResetFilterFragment var0, View var1) {
      setupManualResetBtn$lambda$17(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$uVOJawGRD6S_NbAnfhjt5_WeLBc/* $FF was: $r8$lambda$uVOJawGRD6S_NbAnfhjt5-WeLBc*/(ResetFilterFragment var0, BluetoothResult var1) {
      return onCreateView$lambda$8(var0, var1);
   }

   private static final Unit onCreateView$lambda$14(ResetFilterFragment var0, ResetResult var1) {
      boolean var4 = true;
      Object var7 = null;
      Object var6 = null;
      Object var8 = null;
      FragmentResetFilterBinding var5 = null;
      if (var1 == null) {
         FragmentResetFilterBinding var81 = var0.binding;
         FragmentResetFilterBinding var47 = var81;
         if (var81 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var47 = null;
         }

         ProgressBlockerView var48 = var47.resettingIcPending;
         Intrinsics.checkNotNullExpressionValue(var48, "resettingIcPending");
         ViewExtensionsKt.show$default((View)var48, false, 1, (Object)null);
         var81 = var0.binding;
         FragmentResetFilterBinding var49 = var81;
         if (var81 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var49 = null;
         }

         AppCompatImageView var50 = var49.resettingIcResult;
         Intrinsics.checkNotNullExpressionValue(var50, "resettingIcResult");
         ViewExtensionsKt.hide((View)var50);
         var81 = var0.binding;
         FragmentResetFilterBinding var51 = var81;
         if (var81 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var51 = null;
         }

         var51.btnFinish.setTextColor(var0.requireContext().getColor(R.color.smokegray));
         var81 = var0.binding;
         var51 = var81;
         if (var81 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var51 = null;
         }

         var51.btnFinish.setOnClickListener((View.OnClickListener)null);
         var81 = var0.binding;
         var51 = var81;
         if (var81 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var51 = null;
         }

         MaterialButton var54 = var51.btnCustomerSupport;
         Intrinsics.checkNotNullExpressionValue(var54, "btnCustomerSupport");
         ViewExtensionsKt.hide((View)var54);
         var0.setupManualResetBtn();
         FragmentResetFilterBinding var10 = var0.binding;
         if (var10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var10 = var5;
         }

         TextView var11 = var10.btnManualReset;
         Intrinsics.checkNotNullExpressionValue(var11, "btnManualReset");
         ViewExtensionsKt.hide((View)var11);
         return Unit.INSTANCE;
      } else {
         FragmentResetFilterBinding var9 = var0.binding;
         var5 = var9;
         if (var9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var5 = null;
         }

         ProgressBlockerView var56 = var5.resettingIcPending;
         Intrinsics.checkNotNullExpressionValue(var56, "resettingIcPending");
         ViewExtensionsKt.hide((View)var56);
         var9 = var0.binding;
         FragmentResetFilterBinding var57 = var9;
         if (var9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var57 = null;
         }

         AppCompatImageView var58 = var57.resettingIcResult;
         Intrinsics.checkNotNullExpressionValue(var58, "resettingIcResult");
         ViewExtensionsKt.show$default((View)var58, false, 1, (Object)null);
         var0.setupFinishBtn();
         switch (ResetFilterFragment.WhenMappings.$EnumSwitchMapping$1[var1.ordinal()]) {
            case 1:
               FragmentResetFilterBinding var78 = var0.binding;
               FragmentResetFilterBinding var40 = var78;
               if (var78 == null) {
                  Intrinsics.throwUninitializedPropertyAccessException("binding");
                  var40 = null;
               }

               var40.resettingIcResult.setImageResource(R.drawable.ic_success_new);
               if (var0.getViewModel().getDevice() == null) {
                  FilterConfig var41 = var0.getViewModel().getFilterConfig();
                  DeviceConfigProvider var79 = DeviceConfigProvider.INSTANCE;
                  AwsLinkConfig var42;
                  if (var41 != null) {
                     var42 = var41.getVideo();
                  } else {
                     var42 = null;
                  }

                  CharSequence var43 = (CharSequence)var79.getAwsLinkValue(var42);
                  boolean var2;
                  if (var43 != null && var43.length() != 0) {
                     var2 = false;
                  } else {
                     var2 = true;
                  }

                  FragmentResetFilterBinding var44 = var0.binding;
                  if (var44 == null) {
                     Intrinsics.throwUninitializedPropertyAccessException("binding");
                     var44 = (FragmentResetFilterBinding)var8;
                  }

                  MaterialButton var45 = var44.btnHowToReplace;
                  Intrinsics.checkNotNullExpressionValue(var45, "btnHowToReplace");
                  View var46 = (View)var45;
                  boolean var3 = var4;
                  if (var2) {
                     if (var0.getViewModel().getDevice() instanceof DeviceBlue40) {
                        var3 = var4;
                     } else {
                        var3 = false;
                     }
                  }

                  ViewExtensionsKt.show(var46, var3);
               }
               break;
            case 2:
               FragmentResetFilterBinding var76 = var0.binding;
               FragmentResetFilterBinding var37 = var76;
               if (var76 == null) {
                  Intrinsics.throwUninitializedPropertyAccessException("binding");
                  var37 = null;
               }

               var37.resettingIcResult.setImageResource(R.drawable.ic_error_new);
               var76 = var0.binding;
               var37 = var76;
               if (var76 == null) {
                  Intrinsics.throwUninitializedPropertyAccessException("binding");
                  var37 = null;
               }

               MaterialButton var39 = var37.btnCustomerSupport;
               Intrinsics.checkNotNullExpressionValue(var39, "btnCustomerSupport");
               ViewExtensionsKt.show$default((View)var39, false, 1, (Object)null);
               ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, R.string.invalid_verification_code, (Integer)null, R.string.invalid_verification_code_desc, R.string.add_device_success_btn_okay, (Integer)null, false, false, false, true, (String[])null, (String)null, (Integer)null, (Function1)null, 7904, (Object)null).show(var0.getChildFragmentManager(), (String)null);
               break;
            case 3:
               FragmentResetFilterBinding var74 = var0.binding;
               FragmentResetFilterBinding var34 = var74;
               if (var74 == null) {
                  Intrinsics.throwUninitializedPropertyAccessException("binding");
                  var34 = null;
               }

               var34.resettingIcResult.setImageResource(R.drawable.ic_error_new);
               var74 = var0.binding;
               var34 = var74;
               if (var74 == null) {
                  Intrinsics.throwUninitializedPropertyAccessException("binding");
                  var34 = null;
               }

               MaterialButton var36 = var34.btnCustomerSupport;
               Intrinsics.checkNotNullExpressionValue(var36, "btnCustomerSupport");
               ViewExtensionsKt.show$default((View)var36, false, 1, (Object)null);
               ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, R.string.device_mismatch, (Integer)null, R.string.device_filter_mismatch, R.string.add_device_success_btn_okay, (Integer)null, false, false, false, true, (String[])null, (String)null, (Integer)null, (Function1)null, 7904, (Object)null).show(var0.getChildFragmentManager(), (String)null);
               break;
            case 4:
               FragmentResetFilterBinding var67 = var0.binding;
               FragmentResetFilterBinding var23 = var67;
               if (var67 == null) {
                  Intrinsics.throwUninitializedPropertyAccessException("binding");
                  var23 = null;
               }

               var23.resettingIcResult.setImageResource(R.drawable.ic_error_new);
               var67 = var0.binding;
               var23 = var67;
               if (var67 == null) {
                  Intrinsics.throwUninitializedPropertyAccessException("binding");
                  var23 = null;
               }

               MaterialButton var25 = var23.btnCustomerSupport;
               Intrinsics.checkNotNullExpressionValue(var25, "btnCustomerSupport");
               ViewExtensionsKt.show$default((View)var25, false, 1, (Object)null);
               var67 = var0.binding;
               FragmentResetFilterBinding var26 = var67;
               if (var67 == null) {
                  Intrinsics.throwUninitializedPropertyAccessException("binding");
                  var26 = null;
               }

               var26.btnManualReset.setText(R.string.reset_via_bluetooth);
               var67 = var0.binding;
               var26 = var67;
               if (var67 == null) {
                  Intrinsics.throwUninitializedPropertyAccessException("binding");
                  var26 = null;
               }

               TextView var28 = var26.btnManualReset;
               Intrinsics.checkNotNullExpressionValue(var28, "btnManualReset");
               TextViewExtensionsKt.underlineText(var28);
               var67 = var0.binding;
               FragmentResetFilterBinding var29 = var67;
               if (var67 == null) {
                  Intrinsics.throwUninitializedPropertyAccessException("binding");
                  var29 = null;
               }

               var29.btnManualReset.setOnClickListener(new ResetFilterFragment$$ExternalSyntheticLambda5(var0));
               var67 = var0.binding;
               var29 = var67;
               if (var67 == null) {
                  Intrinsics.throwUninitializedPropertyAccessException("binding");
                  var29 = null;
               }

               TextView var31 = var29.btnManualReset;
               Intrinsics.checkNotNullExpressionValue(var31, "btnManualReset");
               ViewExtensionsKt.show$default((View)var31, false, 1, (Object)null);
               FragmentManager var73 = var0.getChildFragmentManager();
               Intrinsics.checkNotNullExpressionValue(var73, "getChildFragmentManager(...)");
               Intrinsics.checkNotNullExpressionValue("StepGuideDialogFragment", "getSimpleName(...)");
               StepGuideDialogFragment var32 = (StepGuideDialogFragment)var6;
               if (!(var73.findFragmentByTag("StepGuideDialogFragment") instanceof StepGuideDialogFragment)) {
                  var32 = (StepGuideDialogFragment)var6;
                  if (!var73.isStateSaved()) {
                     var32 = StepGuideDialogFragment.Companion.newInstance(GuidesData.INSTANCE.getRESET_FILTER_TROUBLESHOOTING_OFFLINE());
                     ((DialogFragment)var32).show(var73, "StepGuideDialogFragment");
                  }
               }

               var32 = var32;
               if (var32 != null) {
                  FragmentExtensionsKt.setFragmentResultListenerWithClear((Fragment)var32, GuidesData.INSTANCE.getRESET_FILTER_TROUBLESHOOTING_OFFLINE().getRequestKey(), new ResetFilterFragment$$ExternalSyntheticLambda6(var0));
               }
               break;
            case 5:
               FragmentResetFilterBinding var64 = var0.binding;
               FragmentResetFilterBinding var18 = var64;
               if (var64 == null) {
                  Intrinsics.throwUninitializedPropertyAccessException("binding");
                  var18 = null;
               }

               var18.resettingIcResult.setImageResource(R.drawable.ic_error_new);
               var64 = var0.binding;
               var18 = var64;
               if (var64 == null) {
                  Intrinsics.throwUninitializedPropertyAccessException("binding");
                  var18 = null;
               }

               MaterialButton var20 = var18.btnCustomerSupport;
               Intrinsics.checkNotNullExpressionValue(var20, "btnCustomerSupport");
               ViewExtensionsKt.show$default((View)var20, false, 1, (Object)null);
               var64 = var0.binding;
               FragmentResetFilterBinding var21 = var64;
               if (var64 == null) {
                  Intrinsics.throwUninitializedPropertyAccessException("binding");
                  var21 = null;
               }

               TextView var22 = var21.btnManualReset;
               Intrinsics.checkNotNullExpressionValue(var22, "btnManualReset");
               ViewExtensionsKt.show$default((View)var22, false, 1, (Object)null);
               ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, R.string.reset_failed, (Integer)null, R.string.troubleshotting_reset_filter_internal_error, R.string.add_device_success_btn_okay, (Integer)null, false, false, false, true, (String[])null, (String)null, (Integer)null, (Function1)null, 7904, (Object)null).show(var0.getChildFragmentManager(), (String)null);
               break;
            case 6:
               FragmentResetFilterBinding var59 = var0.binding;
               FragmentResetFilterBinding var12 = var59;
               if (var59 == null) {
                  Intrinsics.throwUninitializedPropertyAccessException("binding");
                  var12 = null;
               }

               var12.resettingIcResult.setImageResource(R.drawable.ic_error_new);
               var59 = var0.binding;
               var12 = var59;
               if (var59 == null) {
                  Intrinsics.throwUninitializedPropertyAccessException("binding");
                  var12 = null;
               }

               MaterialButton var14 = var12.btnCustomerSupport;
               Intrinsics.checkNotNullExpressionValue(var14, "btnCustomerSupport");
               ViewExtensionsKt.show$default((View)var14, false, 1, (Object)null);
               var59 = var0.binding;
               FragmentResetFilterBinding var15 = var59;
               if (var59 == null) {
                  Intrinsics.throwUninitializedPropertyAccessException("binding");
                  var15 = null;
               }

               TextView var16 = var15.btnManualReset;
               Intrinsics.checkNotNullExpressionValue(var16, "btnManualReset");
               ViewExtensionsKt.show$default((View)var16, false, 1, (Object)null);
               StepGuides var17;
               if (Intrinsics.areEqual(var0.getViewModel().getResetDeviceType(), DeviceType.Pet20.INSTANCE)) {
                  var17 = GuidesData.INSTANCE.getRESET_FILTER_TROUBLESHOOTING_BLUETOOTH_RESET_FAN();
               } else {
                  var17 = GuidesData.INSTANCE.getRESET_FILTER_TROUBLESHOOTING_BLUETOOTH_RESET();
               }

               FragmentManager var80 = var0.getChildFragmentManager();
               Intrinsics.checkNotNullExpressionValue(var80, "getChildFragmentManager(...)");
               Intrinsics.checkNotNullExpressionValue("StepGuideDialogFragment", "getSimpleName(...)");
               StepGuideDialogFragment var62 = (StepGuideDialogFragment)var7;
               if (!(var80.findFragmentByTag("StepGuideDialogFragment") instanceof StepGuideDialogFragment)) {
                  var62 = (StepGuideDialogFragment)var7;
                  if (!var80.isStateSaved()) {
                     var62 = StepGuideDialogFragment.Companion.newInstance(var17);
                     ((DialogFragment)var62).show(var80, "StepGuideDialogFragment");
                  }
               }

               var62 = var62;
               if (var62 != null) {
                  FragmentExtensionsKt.setFragmentResultListenerWithClear((Fragment)var62, var17.getRequestKey(), new ResetFilterFragment$$ExternalSyntheticLambda7(var0));
               }
               break;
            default:
               throw new NoWhenBranchMatchedException();
         }

         return Unit.INSTANCE;
      }
   }

   private static final Unit onCreateView$lambda$14$lambda$11(ResetFilterFragment var0, String var1, Bundle var2) {
      Intrinsics.checkNotNullParameter(var1, "<unused var>");
      Intrinsics.checkNotNullParameter(var2, "r");
      if (var2.getBoolean("DATA_COMPLETED")) {
         var0.getViewModel().retryResetFilterByWifi();
      }

      return Unit.INSTANCE;
   }

   private static final Unit onCreateView$lambda$14$lambda$13(ResetFilterFragment var0, String var1, Bundle var2) {
      Intrinsics.checkNotNullParameter(var1, "<unused var>");
      Intrinsics.checkNotNullParameter(var2, "r");
      if (var2.getBoolean("DATA_COMPLETED")) {
         var0.getViewModel().retryResetFilterByBluetooth();
      }

      return Unit.INSTANCE;
   }

   private static final void onCreateView$lambda$14$lambda$9(ResetFilterFragment var0, View var1) {
      var0.getViewModel().retryViaBluetooth();
   }

   private static final Unit onCreateView$lambda$2(ResetFilterFragment var0, OnBackPressedCallback var1) {
      Intrinsics.checkNotNullParameter(var1, "$this$addCallback");
      FragmentManager var2 = var0.getChildFragmentManager();
      Intrinsics.checkNotNullExpressionValue(var2, "getChildFragmentManager(...)");
      Intrinsics.checkNotNullExpressionValue("ConfirmationDialogLeftAligned", "getSimpleName(...)");
      if (!(var2.findFragmentByTag("ConfirmationDialogLeftAligned") instanceof ConfirmationDialogLeftAligned) && !var2.isStateSaved()) {
         ((DialogFragment)ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, R.string.quit_with_questing_mark, (Integer)null, R.string.quit_process_warning, R.string.yes, R.string.no, false, false, false, true, (String[])null, (String)null, (Integer)null, new ResetFilterFragment$$ExternalSyntheticLambda0(var0), 3680, (Object)null)).show(var2, "ConfirmationDialogLeftAligned");
      }

      return Unit.INSTANCE;
   }

   private static final Unit onCreateView$lambda$2$lambda$1$lambda$0(ResetFilterFragment var0, boolean var1) {
      if (var1) {
         var0.requireActivity().finish();
      }

      return Unit.INSTANCE;
   }

   private static final void onCreateView$lambda$4(ResetFilterFragment var0, View var1) {
      HasSKU var2 = var0.getViewModel().getDevice();
      if (var2 != null && DeviceKt.useV2UI(var2)) {
         DeviceFilterDetailActivity.Companion var5 = DeviceFilterDetailActivity.Companion;
         Context var4 = var1.getContext();
         Intrinsics.checkNotNullExpressionValue(var4, "getContext(...)");
         DeviceFilterDetailActivity.Companion.launch$default(var5, var4, var0.getViewModel().getDevice(), var0.getViewModel().getResetDeviceSku(), var0.getViewModel().getFilterType(), false, 16, (Object)null);
      } else {
         FragmentManager var3 = var0.getChildFragmentManager();
         Intrinsics.checkNotNullExpressionValue(var3, "getChildFragmentManager(...)");
         Intrinsics.checkNotNullExpressionValue("DeviceNFilterDialogFragment", "getSimpleName(...)");
         if (!(var3.findFragmentByTag("DeviceNFilterDialogFragment") instanceof DeviceNFilterDialogFragment) && !var3.isStateSaved()) {
            ((DialogFragment)DeviceNFilterDialogFragment.Companion.newInstance$default(DeviceNFilterDialogFragment.Companion, (Device)null, var0.getViewModel().getResetDeviceSku(), var0.getViewModel().getFilterType(), false, false, 16, (Object)null)).show(var3, "DeviceNFilterDialogFragment");
         }

      }
   }

   private static final void onCreateView$lambda$5(ResetFilterFragment var0, View var1) {
      var0.startActivity(Actions.INSTANCE.openDialerIntent("400-006-9693"));
   }

   private static final Unit onCreateView$lambda$8(ResetFilterFragment var0, BluetoothResult var1) {
      Object var4 = null;
      Object var3 = null;
      FragmentResetFilterBinding var2 = null;
      if (var1 == null) {
         FragmentResetFilterBinding var26 = var0.binding;
         FragmentResetFilterBinding var15 = var26;
         if (var26 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var15 = null;
         }

         ProgressBlockerView var16 = var15.connectingIcPending;
         Intrinsics.checkNotNullExpressionValue(var16, "connectingIcPending");
         ViewExtensionsKt.show$default((View)var16, false, 1, (Object)null);
         FragmentResetFilterBinding var7 = var0.binding;
         if (var7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var7 = var2;
         }

         AppCompatImageView var8 = var7.connectingIcResult;
         Intrinsics.checkNotNullExpressionValue(var8, "connectingIcResult");
         ViewExtensionsKt.hide((View)var8);
         return Unit.INSTANCE;
      } else {
         FragmentResetFilterBinding var5 = var0.binding;
         var2 = var5;
         if (var5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var2 = null;
         }

         ProgressBlockerView var18 = var2.connectingIcPending;
         Intrinsics.checkNotNullExpressionValue(var18, "connectingIcPending");
         ViewExtensionsKt.hide((View)var18);
         var5 = var0.binding;
         FragmentResetFilterBinding var19 = var5;
         if (var5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var19 = null;
         }

         AppCompatImageView var20 = var19.connectingIcResult;
         Intrinsics.checkNotNullExpressionValue(var20, "connectingIcResult");
         ViewExtensionsKt.show$default((View)var20, false, 1, (Object)null);
         if (ResetFilterFragment.WhenMappings.$EnumSwitchMapping$0[var1.ordinal()] == 1) {
            FragmentResetFilterBinding var6 = var0.binding;
            if (var6 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("binding");
               var6 = (FragmentResetFilterBinding)var4;
            }

            var6.connectingIcResult.setImageResource(R.drawable.ic_success_new);
         } else {
            FragmentResetFilterBinding var21 = var0.binding;
            FragmentResetFilterBinding var9 = var21;
            if (var21 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("binding");
               var9 = null;
            }

            var9.connectingIcResult.setImageResource(R.drawable.ic_error_new);
            var21 = var0.binding;
            var9 = var21;
            if (var21 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("binding");
               var9 = null;
            }

            MaterialButton var11 = var9.btnCustomerSupport;
            Intrinsics.checkNotNullExpressionValue(var11, "btnCustomerSupport");
            ViewExtensionsKt.show$default((View)var11, false, 1, (Object)null);
            var21 = var0.binding;
            FragmentResetFilterBinding var12 = var21;
            if (var21 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("binding");
               var12 = null;
            }

            TextView var13 = var12.btnManualReset;
            Intrinsics.checkNotNullExpressionValue(var13, "btnManualReset");
            ViewExtensionsKt.show$default((View)var13, false, 1, (Object)null);
            var0.setupFinishBtn();
            StepGuides var14;
            if (Intrinsics.areEqual(var0.getViewModel().getResetDeviceType(), DeviceType.Pet20.INSTANCE)) {
               var14 = GuidesData.INSTANCE.getRESET_FILTER_TROUBLESHOOTING_BLUETOOTH_RESET_FAN();
            } else {
               var14 = GuidesData.INSTANCE.getRESET_FILTER_TROUBLESHOOTING_BLUETOOTH_RESET();
            }

            FragmentManager var27 = var0.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(var27, "getChildFragmentManager(...)");
            Intrinsics.checkNotNullExpressionValue("StepGuideDialogFragment", "getSimpleName(...)");
            StepGuideDialogFragment var24 = (StepGuideDialogFragment)var3;
            if (!(var27.findFragmentByTag("StepGuideDialogFragment") instanceof StepGuideDialogFragment)) {
               var24 = (StepGuideDialogFragment)var3;
               if (!var27.isStateSaved()) {
                  var24 = StepGuideDialogFragment.Companion.newInstance(var14);
                  ((DialogFragment)var24).show(var27, "StepGuideDialogFragment");
               }
            }

            var24 = var24;
            if (var24 != null) {
               FragmentExtensionsKt.setFragmentResultListenerWithClear((Fragment)var24, var14.getRequestKey(), new ResetFilterFragment$$ExternalSyntheticLambda4(var0));
            }
         }

         return Unit.INSTANCE;
      }
   }

   private static final Unit onCreateView$lambda$8$lambda$7(ResetFilterFragment var0, String var1, Bundle var2) {
      Intrinsics.checkNotNullParameter(var1, "<unused var>");
      Intrinsics.checkNotNullParameter(var2, "r");
      if (var2.getBoolean("DATA_COMPLETED")) {
         var0.getViewModel().retryResetFilterByBluetooth();
      }

      return Unit.INSTANCE;
   }

   private final void setupFinishBtn() {
      FragmentResetFilterBinding var3 = this.binding;
      Object var2 = null;
      FragmentResetFilterBinding var1 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var1 = null;
      }

      var1.btnFinish.setTextColor(this.requireContext().getColor(R.color.colorPrimaryText));
      var1 = this.binding;
      if (var1 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var1 = (FragmentResetFilterBinding)var2;
      }

      var1.btnFinish.setOnClickListener(new ResetFilterFragment$$ExternalSyntheticLambda2(this));
   }

   private static final void setupFinishBtn$lambda$15(ResetFilterFragment var0, View var1) {
      AntiFakeActionDialogFragment.Companion.setShouldDismiss(true);
      DeviceNFilterDialogFragment.Companion.setShouldDismiss(true);
      DeviceDetailsDialogFragment.Companion var3 = DeviceDetailsDialogFragment.Companion;
      DeviceFilterType var4 = var0.getViewModel().getTargetType();
      int var2;
      if (var4 == null) {
         var2 = -1;
      } else {
         var2 = ResetFilterFragment.WhenMappings.$EnumSwitchMapping$2[var4.ordinal()];
      }

      String var5;
      if (var2 != 1) {
         if (var2 != 2) {
            var5 = null;
         } else {
            var5 = "wick_status";
         }
      } else {
         var5 = "filter_status";
      }

      var3.setJumpToAction(var5);
      var0.requireActivity().finish();
   }

   private final void setupManualResetBtn() {
      FragmentResetFilterBinding var3 = this.binding;
      Object var2 = null;
      FragmentResetFilterBinding var1 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var1 = null;
      }

      var1.btnManualReset.setText(R.string.manual_reset);
      var3 = this.binding;
      var1 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var1 = null;
      }

      TextView var5 = var1.btnManualReset;
      Intrinsics.checkNotNullExpressionValue(var5, "btnManualReset");
      TextViewExtensionsKt.underlineText(var5);
      FragmentResetFilterBinding var6 = this.binding;
      if (var6 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var6 = (FragmentResetFilterBinding)var2;
      }

      var6.btnManualReset.setOnClickListener(new ResetFilterFragment$$ExternalSyntheticLambda3(this));
   }

   private static final void setupManualResetBtn$lambda$17(ResetFilterFragment var0, View var1) {
      FragmentManager var2 = var0.getChildFragmentManager();
      Intrinsics.checkNotNullExpressionValue(var2, "getChildFragmentManager(...)");
      Intrinsics.checkNotNullExpressionValue("ManualResetFilterDialog", "getSimpleName(...)");
      if (!(var2.findFragmentByTag("ManualResetFilterDialog") instanceof ManualResetFilterDialog) && !var2.isStateSaved()) {
         ((DialogFragment)ManualResetFilterDialog.Companion.newInstance(var0.getViewModel().getFilterType())).show(var2, "ManualResetFilterDialog");
      }

   }

   public AntiFakeViewModel getViewModel() {
      AntiFakeViewModel var1 = this.viewModel;
      if (var1 != null) {
         return var1;
      } else {
         Intrinsics.throwUninitializedPropertyAccessException("viewModel");
         return null;
      }
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      Intrinsics.checkNotNullParameter(var1, "inflater");
      FragmentResetFilterBinding var4 = FragmentResetFilterBinding.inflate(var1, var2, false);
      Intrinsics.checkNotNullExpressionValue(var4, "inflate(...)");
      this.binding = var4;
      FragmentActivity var5 = ((BaseFragment)this).requireActivity();
      Intrinsics.checkNotNullExpressionValue(var5, "requireActivity(...)");
      this.setViewModel((AntiFakeViewModel)((BaseViewModel)(new ViewModelProvider((ViewModelStoreOwner)var5)).get(AntiFakeViewModel.class)));
      OnBackPressedDispatcher var6 = this.requireActivity().getOnBackPressedDispatcher();
      Intrinsics.checkNotNullExpressionValue(var6, "<get-onBackPressedDispatcher>(...)");
      OnBackPressedDispatcherKt.addCallback$default(var6, this.getViewLifecycleOwner(), false, new ResetFilterFragment$$ExternalSyntheticLambda8(this), 2, (Object)null);
      FragmentResetFilterBinding var16 = this.binding;
      Object var15 = null;
      FragmentResetFilterBinding var7 = var16;
      if (var16 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var7 = null;
      }

      var7.btnHowToReplace.setOnClickListener(new ResetFilterFragment$$ExternalSyntheticLambda9(this));
      var16 = this.binding;
      var7 = var16;
      if (var16 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var7 = null;
      }

      var7.btnCustomerSupport.setOnClickListener(new ResetFilterFragment$$ExternalSyntheticLambda10(this));
      this.setupManualResetBtn();
      if (((CharSequence)this.getViewModel().getResetDeviceMac()).length() == 0) {
         var16 = this.binding;
         var7 = var16;
         if (var16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var7 = null;
         }

         ConstraintLayout var10 = var7.connectingLine;
         Intrinsics.checkNotNullExpressionValue(var10, "connectingLine");
         ViewExtensionsKt.hide((View)var10);
      } else {
         var16 = this.binding;
         var7 = var16;
         if (var16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var7 = null;
         }

         ConstraintLayout var12 = var7.connectingLine;
         Intrinsics.checkNotNullExpressionValue(var12, "connectingLine");
         ViewExtensionsKt.show$default((View)var12, false, 1, (Object)null);
         this.getViewModel().getBluetoothResult().observe(this.getViewLifecycleOwner(), new Observer(new ResetFilterFragment$$ExternalSyntheticLambda11(this)) {
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

      this.getViewModel().getResetResult().observe(this.getViewLifecycleOwner(), new Observer(new ResetFilterFragment$$ExternalSyntheticLambda1(this)) {
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
      var7 = this.binding;
      if (var7 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var7 = (FragmentResetFilterBinding)var15;
      }

      ConstraintLayout var14 = var7.getRoot();
      Intrinsics.checkNotNullExpressionValue(var14, "getRoot(...)");
      return (View)var14;
   }

   public void setViewModel(AntiFakeViewModel var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.viewModel = var1;
   }

   public void showProgress(boolean var1) {
   }

   @Metadata(
      d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"},
      d2 = {"Lcom/blueair/antifake/fragmnet/ResetFilterFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/antifake/fragmnet/ResetFilterFragment;", "antifake_otherRelease"},
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

      public final ResetFilterFragment newInstance() {
         return new ResetFilterFragment();
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
      public static final int[] $EnumSwitchMapping$2;

      static {
         int[] var0 = new int[BluetoothResult.values().length];

         try {
            var0[BluetoothResult.SUCCESS.ordinal()] = 1;
         } catch (NoSuchFieldError var10) {
         }

         $EnumSwitchMapping$0 = var0;
         var0 = new int[ResetResult.values().length];

         try {
            var0[ResetResult.SUCCESS.ordinal()] = 1;
         } catch (NoSuchFieldError var9) {
         }

         try {
            var0[ResetResult.INVALID_CODE.ordinal()] = 2;
         } catch (NoSuchFieldError var8) {
         }

         try {
            var0[ResetResult.DEVICE_MISMATCH.ordinal()] = 3;
         } catch (NoSuchFieldError var7) {
         }

         try {
            var0[ResetResult.DEVICE_OFFLINE.ordinal()] = 4;
         } catch (NoSuchFieldError var6) {
         }

         try {
            var0[ResetResult.INTERNAL_ERROR.ordinal()] = 5;
         } catch (NoSuchFieldError var5) {
         }

         try {
            var0[ResetResult.BLUETOOTH_FAILED.ordinal()] = 6;
         } catch (NoSuchFieldError var4) {
         }

         $EnumSwitchMapping$1 = var0;
         var0 = new int[DeviceFilterType.values().length];

         try {
            var0[DeviceFilterType.FILTER.ordinal()] = 1;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[DeviceFilterType.WICK.ordinal()] = 2;
         } catch (NoSuchFieldError var2) {
         }

         $EnumSwitchMapping$2 = var0;
      }
   }
}
