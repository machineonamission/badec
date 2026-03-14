package com.blueair.antifake.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.blueair.antifake.activity.ScanActivity;
import com.blueair.antifake.databinding.DialogfragmentAntifakeActionBinding;
import com.blueair.antifake.viewmodel.AntiFakeActionViewModel;
import com.blueair.viewcore.R;
import com.blueair.viewcore.activity.Actions;
import com.blueair.viewcore.activity.LoginPendingAction;
import com.blueair.viewcore.dialog.BaseDialogFragment;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 !2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J$\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u001a\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u001b\u001a\u00020\u0019H\u0016J\b\u0010\u001c\u001a\u00020\u0019H\u0016J\b\u0010\u001d\u001a\u00020\u0019H\u0016J\u0010\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020 H\u0016R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0002X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000¨\u0006\""},
   d2 = {"Lcom/blueair/antifake/dialog/AntiFakeActionDialogFragment;", "Lcom/blueair/viewcore/dialog/BaseDialogFragment;", "Lcom/blueair/antifake/viewmodel/AntiFakeActionViewModel;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "viewModel", "getViewModel", "()Lcom/blueair/antifake/viewmodel/AntiFakeActionViewModel;", "setViewModel", "(Lcom/blueair/antifake/viewmodel/AntiFakeActionViewModel;)V", "binding", "Lcom/blueair/antifake/databinding/DialogfragmentAntifakeActionBinding;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onStart", "onResume", "onPause", "showProgress", "shouldShowProgress", "", "Companion", "antifake_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class AntiFakeActionDialogFragment extends BaseDialogFragment {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private static boolean shouldDismiss;
   private DialogfragmentAntifakeActionBinding binding;
   private final String screenName = "antifake_instruction";
   public AntiFakeActionViewModel viewModel;

   // $FF: synthetic method
   public static void $r8$lambda$4lxJq6szoMNZZHf7VMZB3IMW_VI(AntiFakeActionDialogFragment var0, View var1) {
      onViewCreated$lambda$2(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$GrPt_A_RR3VxE8y55HYAZ0zA19k/* $FF was: $r8$lambda$GrPt_A-RR3VxE8y55HYAZ0zA19k*/(AntiFakeActionDialogFragment var0, View var1) {
      onViewCreated$lambda$1(var0, var1);
   }

   private static final void onViewCreated$lambda$1(AntiFakeActionDialogFragment var0, View var1) {
      var0.dismiss();
   }

   private static final void onViewCreated$lambda$2(AntiFakeActionDialogFragment var0, View var1) {
      if (var0.getViewModel().isUserLoggedIn()) {
         var0.startActivity(new Intent(var0.requireContext(), ScanActivity.class));
      } else {
         var0.getViewModel().setLoginPendingAction(LoginPendingAction.Companion.antiFakeScan());
         Actions var3 = Actions.INSTANCE;
         Context var2 = var0.requireContext();
         Intrinsics.checkNotNullExpressionValue(var2, "requireContext(...)");
         var0.startActivity(Actions.openWelcomeIntent$default(var3, var2, false, 2, (Object)null));
      }
   }

   protected String getScreenName() {
      return this.screenName;
   }

   public AntiFakeActionViewModel getViewModel() {
      AntiFakeActionViewModel var1 = this.viewModel;
      if (var1 != null) {
         return var1;
      } else {
         Intrinsics.throwUninitializedPropertyAccessException("viewModel");
         return null;
      }
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      Intrinsics.checkNotNullParameter(var1, "inflater");
      shouldDismiss = false;
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

      DialogfragmentAntifakeActionBinding var4 = DialogfragmentAntifakeActionBinding.inflate(var1, var2, false);
      Intrinsics.checkNotNullExpressionValue(var4, "inflate(...)");
      this.binding = var4;
      this.setViewModel((AntiFakeActionViewModel)((BaseViewModel)(new ViewModelProvider((ViewModelStoreOwner)(this))).get(AntiFakeActionViewModel.class)));
      DialogfragmentAntifakeActionBinding var7 = this.binding;
      var4 = var7;
      if (var7 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var4 = null;
      }

      FrameLayout var6 = var4.getRoot();
      Intrinsics.checkNotNullExpressionValue(var6, "getRoot(...)");
      return (View)var6;
   }

   public void onPause() {
      Dialog var1 = this.getDialog();
      if (var1 != null) {
         Window var2 = var1.getWindow();
         if (var2 != null) {
            WindowManager.LayoutParams var3 = var2.getAttributes();
            if (var3 != null) {
               var3.windowAnimations = R.style.dialog_animation_exit_only;
            }
         }
      }

      super.onPause();
   }

   public void onResume() {
      super.onResume();
      if (shouldDismiss) {
         shouldDismiss = false;
         this.dismiss();
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
      DialogfragmentAntifakeActionBinding var3 = this.binding;
      Object var6 = null;
      DialogfragmentAntifakeActionBinding var4 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var4 = null;
      }

      var4.backBtn.setOnClickListener(new AntiFakeActionDialogFragment$$ExternalSyntheticLambda0(this));
      var4 = this.binding;
      if (var4 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var4 = (DialogfragmentAntifakeActionBinding)var6;
      }

      var4.scanBtn.setOnClickListener(new AntiFakeActionDialogFragment$$ExternalSyntheticLambda1(this));
   }

   public void setViewModel(AntiFakeActionViewModel var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.viewModel = var1;
   }

   public void showProgress(boolean var1) {
   }

   @Metadata(
      d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\n\u001a\u00020\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\f"},
      d2 = {"Lcom/blueair/antifake/dialog/AntiFakeActionDialogFragment$Companion;", "", "<init>", "()V", "shouldDismiss", "", "getShouldDismiss", "()Z", "setShouldDismiss", "(Z)V", "newInstance", "Lcom/blueair/antifake/dialog/AntiFakeActionDialogFragment;", "antifake_otherRelease"},
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

      public final boolean getShouldDismiss() {
         return AntiFakeActionDialogFragment.shouldDismiss;
      }

      public final AntiFakeActionDialogFragment newInstance() {
         return new AntiFakeActionDialogFragment();
      }

      public final void setShouldDismiss(boolean var1) {
         AntiFakeActionDialogFragment.shouldDismiss = var1;
      }
   }
}
