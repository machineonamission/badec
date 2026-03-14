package com.blueair.antifake.fragmnet;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.blueair.antifake.databinding.FragmentScanResultBinding;
import com.blueair.antifake.dialog.BluetoothInstructionsDialog;
import com.blueair.antifake.dialog.ManualResetFilterDialog;
import com.blueair.antifake.viewmodel.AntiFakeViewModel;
import com.blueair.antifake.viewmodel.ScanResult;
import com.blueair.core.model.ConnectivityStatus;
import com.blueair.core.model.DeviceFilterType;
import com.blueair.core.model.HasSKU;
import com.blueair.viewcore.R;
import com.blueair.viewcore.activity.Actions;
import com.blueair.viewcore.dialog.ConfirmationDialogLeftAligned;
import com.blueair.viewcore.extensions.TextViewExtensionsKt;
import com.blueair.viewcore.fragment.BaseFragment;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import com.google.android.material.button.MaterialButton;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 #2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001#B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J$\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u001a\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J(\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0010\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020 H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\u0002X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006$"},
   d2 = {"Lcom/blueair/antifake/fragmnet/ScanResultFragment;", "Lcom/blueair/viewcore/fragment/BaseFragment;", "Lcom/blueair/antifake/viewmodel/AntiFakeViewModel;", "<init>", "()V", "binding", "Lcom/blueair/antifake/databinding/FragmentScanResultBinding;", "viewModel", "getViewModel", "()Lcom/blueair/antifake/viewmodel/AntiFakeViewModel;", "setViewModel", "(Lcom/blueair/antifake/viewmodel/AntiFakeViewModel;)V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "setContent", "icon", "", "title", "message", "code", "", "setButtons", "isCorrect", "", "showProgress", "shouldShowProgress", "Companion", "antifake_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class ScanResultFragment extends BaseFragment {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private FragmentScanResultBinding binding;
   public AntiFakeViewModel viewModel;

   // $FF: synthetic method
   public static Unit $r8$lambda$0PcfHIEjkEIBTNz2acWxCk9tvU8(ScanResultFragment var0, HasSKU var1) {
      return onViewCreated$lambda$3$lambda$2$lambda$1(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$3QbL7gTLsizHvK5nCGLSyJUgpWQ(ScanResultFragment var0, View var1) {
      setButtons$lambda$7(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$bNGX7rrjAH3AYoxcz8gKdBWsMOc(ScanResultFragment var0, View var1) {
      onCreateView$lambda$0(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$buuXyvAiZLfncrhO5wEH194bYCY(ScanResultFragment var0) {
      return setButtons$lambda$7$lambda$6$lambda$5(var0);
   }

   // $FF: synthetic method
   public static void $r8$lambda$gWpNdGh98aoDldxJfB4ixmgAGvU(ScanResultFragment var0, View var1) {
      setButtons$lambda$8(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$pa4aq91oR9c1_4JdqSKIk2wezVM(ScanResultFragment var0, View var1) {
      setButtons$lambda$10(var0, var1);
   }

   private static final void onCreateView$lambda$0(ScanResultFragment var0, View var1) {
      var0.getViewModel().retryValidateCode();
   }

   private static final Unit onViewCreated$lambda$3$lambda$2$lambda$1(ScanResultFragment var0, HasSKU var1) {
      var0.getViewModel().scanBluetooth(var1.getMac());
      return Unit.INSTANCE;
   }

   private final void setButtons(boolean var1) {
      Object var6 = null;
      Object var5 = null;
      if (var1) {
         if (this.getViewModel().getDeviceMismatch()) {
            FragmentScanResultBinding var23 = this.binding;
            FragmentScanResultBinding var12 = var23;
            if (var23 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("binding");
               var12 = null;
            }

            MaterialButton var13 = var12.btnResetFilter;
            Intrinsics.checkNotNullExpressionValue(var13, "btnResetFilter");
            ViewExtensionsKt.hide((View)var13);
            ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, R.string.device_mismatch, (Integer)null, R.string.device_filter_mismatch, R.string.add_device_success_btn_okay, (Integer)null, false, false, false, true, (String[])null, (String)null, (Integer)null, (Function1)null, 7904, (Object)null).show(this.getChildFragmentManager(), (String)null);
         } else if (this.getViewModel().getFilterMismatch()) {
            ConfirmationDialogLeftAligned.Companion var14 = ConfirmationDialogLeftAligned.Companion;
            int var3 = R.string.prompt;
            int var2;
            if (this.getViewModel().getTargetType() == DeviceFilterType.FILTER) {
               var2 = R.string.type_mismatch_wick_on_filter;
            } else {
               var2 = R.string.type_mismatch_filter_on_wick;
            }

            ConfirmationDialogLeftAligned.Companion.newInstance$default(var14, var3, (Integer)null, var2, R.string.add_device_success_btn_okay, (Integer)null, false, false, false, true, (String[])null, (String)null, (Integer)null, (Function1)null, 7904, (Object)null).show(this.getChildFragmentManager(), (String)null);
         }

         FragmentScanResultBinding var24 = this.binding;
         FragmentScanResultBinding var15 = var24;
         if (var24 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var15 = null;
         }

         var15.btnResetFilter.setOnClickListener(new ScanResultFragment$$ExternalSyntheticLambda3(this));
         var24 = this.binding;
         var15 = var24;
         if (var24 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var15 = null;
         }

         MaterialButton var17 = var15.btnCustomerSupport;
         Intrinsics.checkNotNullExpressionValue(var17, "btnCustomerSupport");
         ViewExtensionsKt.hide((View)var17);
         FragmentScanResultBinding var18 = this.binding;
         if (var18 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var18 = (FragmentScanResultBinding)var5;
         }

         TextView var19 = var18.btnManualReset;
         Intrinsics.checkNotNullExpressionValue(var19, "btnManualReset");
         ViewExtensionsKt.hide((View)var19);
      } else {
         FragmentScanResultBinding var20 = this.binding;
         FragmentScanResultBinding var4 = var20;
         if (var20 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var4 = null;
         }

         MaterialButton var7 = var4.btnResetFilter;
         Intrinsics.checkNotNullExpressionValue(var7, "btnResetFilter");
         ViewExtensionsKt.hide((View)var7);
         var20 = this.binding;
         FragmentScanResultBinding var8 = var20;
         if (var20 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var8 = null;
         }

         var8.btnCustomerSupport.setOnClickListener(new ScanResultFragment$$ExternalSyntheticLambda4(this));
         var20 = this.binding;
         var8 = var20;
         if (var20 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var8 = null;
         }

         TextView var10 = var8.btnManualReset;
         Intrinsics.checkNotNullExpressionValue(var10, "btnManualReset");
         TextViewExtensionsKt.underlineText(var10);
         FragmentScanResultBinding var11 = this.binding;
         if (var11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var11 = (FragmentScanResultBinding)var6;
         }

         var11.btnManualReset.setOnClickListener(new ScanResultFragment$$ExternalSyntheticLambda5(this));
      }
   }

   private static final void setButtons$lambda$10(ScanResultFragment var0, View var1) {
      FragmentManager var2 = var0.getChildFragmentManager();
      Intrinsics.checkNotNullExpressionValue(var2, "getChildFragmentManager(...)");
      Intrinsics.checkNotNullExpressionValue("ManualResetFilterDialog", "getSimpleName(...)");
      if (!(var2.findFragmentByTag("ManualResetFilterDialog") instanceof ManualResetFilterDialog) && !var2.isStateSaved()) {
         ((DialogFragment)ManualResetFilterDialog.Companion.newInstance(var0.getViewModel().getFilterType())).show(var2, "ManualResetFilterDialog");
      }

   }

   private static final void setButtons$lambda$7(ScanResultFragment var0, View var1) {
      HasSKU var2 = var0.getViewModel().getDevice();
      if (var2 != null && var2.getConnectivityStatus() != ConnectivityStatus.ONLINE) {
         FragmentManager var3 = var0.getChildFragmentManager();
         Intrinsics.checkNotNullExpressionValue(var3, "getChildFragmentManager(...)");
         Intrinsics.checkNotNullExpressionValue("BluetoothInstructionsDialog", "getSimpleName(...)");
         if (!(var3.findFragmentByTag("BluetoothInstructionsDialog") instanceof BluetoothInstructionsDialog) && !var3.isStateSaved()) {
            ((DialogFragment)BluetoothInstructionsDialog.Companion.newInstance(new ScanResultFragment$$ExternalSyntheticLambda2(var0))).show(var3, "BluetoothInstructionsDialog");
         }

      } else {
         var0.getViewModel().resetFilter();
      }
   }

   private static final Unit setButtons$lambda$7$lambda$6$lambda$5(ScanResultFragment var0) {
      AntiFakeViewModel var1 = var0.getViewModel();
      HasSKU var2 = var0.getViewModel().getDevice();
      Intrinsics.checkNotNull(var2);
      var1.scanBluetooth(var2.getMac());
      return Unit.INSTANCE;
   }

   private static final void setButtons$lambda$8(ScanResultFragment var0, View var1) {
      var0.startActivity(Actions.INSTANCE.openDialerIntent("400-006-9693"));
   }

   private final void setContent(int var1, int var2, int var3, String var4) {
      FragmentScanResultBinding var7 = this.binding;
      Object var6 = null;
      FragmentScanResultBinding var5 = var7;
      if (var7 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var5 = null;
      }

      var5.imageCodeStatus.setImageResource(var1);
      var7 = this.binding;
      var5 = var7;
      if (var7 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var5 = null;
      }

      var5.titleCodeStatus.setText(var2);
      var7 = this.binding;
      var5 = var7;
      if (var7 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var5 = null;
      }

      var5.infoCodeStatus.setText(var3);
      var5 = this.binding;
      if (var5 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var5 = (FragmentScanResultBinding)var6;
      }

      var5.securityCode.setText((CharSequence)var4);
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
      FragmentScanResultBinding var5 = FragmentScanResultBinding.inflate(var1, var2, false);
      Intrinsics.checkNotNullExpressionValue(var5, "inflate(...)");
      this.binding = var5;
      FragmentActivity var6 = ((BaseFragment)this).requireActivity();
      Intrinsics.checkNotNullExpressionValue(var6, "requireActivity(...)");
      this.setViewModel((AntiFakeViewModel)((BaseViewModel)(new ViewModelProvider((ViewModelStoreOwner)var6)).get(AntiFakeViewModel.class)));
      ScanResult var7 = this.getViewModel().getVerifyResult();
      int var4 = ScanResultFragment.WhenMappings.$EnumSwitchMapping$0[var7.ordinal()];
      Object var15 = null;
      if (var4 != 1) {
         if (var4 != 2) {
            if (var4 != 3) {
               if (var4 != 4) {
                  if (var4 != 5) {
                     throw new NoWhenBranchMatchedException();
                  }

                  FragmentScanResultBinding var16 = this.binding;
                  FragmentScanResultBinding var8 = var16;
                  if (var16 == null) {
                     Intrinsics.throwUninitializedPropertyAccessException("binding");
                     var8 = null;
                  }

                  var8.stateLoadingFailed.getRoot().setOnClickListener(new ScanResultFragment$$ExternalSyntheticLambda1(this));
                  var16 = this.binding;
                  var8 = var16;
                  if (var16 == null) {
                     Intrinsics.throwUninitializedPropertyAccessException("binding");
                     var8 = null;
                  }

                  ConstraintLayout var10 = var8.stateLoadingFailed.getRoot();
                  Intrinsics.checkNotNullExpressionValue(var10, "getRoot(...)");
                  ViewExtensionsKt.show$default((View)var10, false, 1, (Object)null);
               } else {
                  this.setContent(R.drawable.ic_scan_result_unrecognizable, R.string.scan_result_unrecognizable, R.string.scan_result_unrecognizable_hint, this.getViewModel().getCode());
                  FragmentScanResultBinding var18 = this.binding;
                  FragmentScanResultBinding var11 = var18;
                  if (var18 == null) {
                     Intrinsics.throwUninitializedPropertyAccessException("binding");
                     var11 = null;
                  }

                  Group var12 = var11.groupCode;
                  Intrinsics.checkNotNullExpressionValue(var12, "groupCode");
                  ViewExtensionsKt.hide((View)var12);
                  this.setButtons(false);
               }
            } else {
               this.setContent(R.drawable.ic_scan_result_invalid, R.string.error_code, R.string.error_code_desc, this.getViewModel().getCode());
               this.setButtons(false);
            }
         } else {
            this.setContent(R.drawable.ic_scan_result_repeat, R.string.scan_result_repeat, R.string.repeat_verification_desc, this.getViewModel().getCode());
            this.setButtons(false);
         }
      } else {
         this.setContent(R.drawable.ic_scan_result_correct, R.string.scan_result_correct, R.string.correct_query_desc, this.getViewModel().getCode());
         this.setButtons(true);
      }

      FragmentScanResultBinding var13 = this.binding;
      if (var13 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var13 = (FragmentScanResultBinding)var15;
      }

      ConstraintLayout var14 = var13.getRoot();
      Intrinsics.checkNotNullExpressionValue(var14, "getRoot(...)");
      return (View)var14;
   }

   public void onViewCreated(View var1, Bundle var2) {
      Intrinsics.checkNotNullParameter(var1, "view");
      super.onViewCreated(var1, var2);
      if (this.getViewModel().getRetryViaBluetooth()) {
         HasSKU var3 = this.getViewModel().getDevice();
         if (var3 != null) {
            FragmentManager var6 = this.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(var6, "getChildFragmentManager(...)");
            Intrinsics.checkNotNullExpressionValue("BluetoothInstructionsDialog", "getSimpleName(...)");
            DialogFragment var4;
            if (!(var6.findFragmentByTag("BluetoothInstructionsDialog") instanceof BluetoothInstructionsDialog) && !var6.isStateSaved()) {
               var4 = BluetoothInstructionsDialog.Companion.newInstance(new ScanResultFragment$$ExternalSyntheticLambda0(this, var3));
               ((DialogFragment)var4).show(var6, "BluetoothInstructionsDialog");
            } else {
               var4 = null;
            }

            var4 = var4;
         }
      }

   }

   public void setViewModel(AntiFakeViewModel var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.viewModel = var1;
   }

   public void showProgress(boolean var1) {
   }

   @Metadata(
      d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"},
      d2 = {"Lcom/blueair/antifake/fragmnet/ScanResultFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/antifake/fragmnet/ScanResultFragment;", "antifake_otherRelease"},
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

      public final ScanResultFragment newInstance() {
         return new ScanResultFragment();
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
         int[] var0 = new int[ScanResult.values().length];

         try {
            var0[ScanResult.CORRECT.ordinal()] = 1;
         } catch (NoSuchFieldError var6) {
         }

         try {
            var0[ScanResult.REPEAT.ordinal()] = 2;
         } catch (NoSuchFieldError var5) {
         }

         try {
            var0[ScanResult.INVALID.ordinal()] = 3;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[ScanResult.UNRECOG.ordinal()] = 4;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[ScanResult.NETWORK.ordinal()] = 5;
         } catch (NoSuchFieldError var2) {
         }

         $EnumSwitchMapping$0 = var0;
      }
   }
}
