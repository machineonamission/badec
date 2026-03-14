package com.blueair.devicedetails.dialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.DialogFragment;
import com.blueair.devicedetails.databinding.DialogfragmentWhExploreBinding;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u001a\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0014"},
   d2 = {"Lcom/blueair/devicedetails/dialog/WelcomeHomeExploreDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "onProceed", "Lkotlin/Function0;", "", "onNeverShow", "<init>", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "binding", "Lcom/blueair/devicedetails/databinding/DialogfragmentWhExploreBinding;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class WelcomeHomeExploreDialogFragment extends DialogFragment {
   private DialogfragmentWhExploreBinding binding;
   private final Function0 onNeverShow;
   private final Function0 onProceed;

   // $FF: synthetic method
   public static void $r8$lambda$_nQMC0LIxwQXZ0jT7KNWUkNpeoc/* $FF was: $r8$lambda$-nQMC0LIxwQXZ0jT7KNWUkNpeoc*/(WelcomeHomeExploreDialogFragment var0, View var1) {
      onViewCreated$lambda$3(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$1dszmxWsNO2H8sTvZyHwKRzOUnc(WelcomeHomeExploreDialogFragment var0, View var1) {
      onViewCreated$lambda$1(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$AkOQxOFjhHQhWc5G5MXlkG90kuo(WelcomeHomeExploreDialogFragment var0, View var1) {
      onViewCreated$lambda$0(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$Rx41TF7B3BMQFI6XVnKpfFYBPB4(WelcomeHomeExploreDialogFragment var0, View var1) {
      onViewCreated$lambda$2(var0, var1);
   }

   public WelcomeHomeExploreDialogFragment(Function0 var1, Function0 var2) {
      Intrinsics.checkNotNullParameter(var1, "onProceed");
      Intrinsics.checkNotNullParameter(var2, "onNeverShow");
      super();
      this.onProceed = var1;
      this.onNeverShow = var2;
   }

   private static final void onViewCreated$lambda$0(WelcomeHomeExploreDialogFragment var0, View var1) {
      var0.onProceed.invoke();
      var0.dismiss();
   }

   private static final void onViewCreated$lambda$1(WelcomeHomeExploreDialogFragment var0, View var1) {
      var0.dismiss();
   }

   private static final void onViewCreated$lambda$2(WelcomeHomeExploreDialogFragment var0, View var1) {
      var0.onNeverShow.invoke();
      var0.dismiss();
   }

   private static final void onViewCreated$lambda$3(WelcomeHomeExploreDialogFragment var0, View var1) {
      var0.dismiss();
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      Intrinsics.checkNotNullParameter(var1, "inflater");
      DialogfragmentWhExploreBinding var6 = DialogfragmentWhExploreBinding.inflate(var1, var2, false);
      Intrinsics.checkNotNullExpressionValue(var6, "inflate(...)");
      this.binding = var6;
      DialogfragmentWhExploreBinding var4 = var6;
      if (var6 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var4 = null;
      }

      LinearLayout var5 = var4.getRoot();
      Intrinsics.checkNotNullExpressionValue(var5, "getRoot(...)");
      return (View)var5;
   }

   public void onViewCreated(View var1, Bundle var2) {
      Intrinsics.checkNotNullParameter(var1, "view");
      super.onViewCreated(var1, var2);
      DialogfragmentWhExploreBinding var3 = this.binding;
      Object var8 = null;
      DialogfragmentWhExploreBinding var4 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var4 = null;
      }

      var4.buttonProceed.setOnClickListener(new WelcomeHomeExploreDialogFragment$$ExternalSyntheticLambda0(this));
      var3 = this.binding;
      var4 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var4 = null;
      }

      var4.buttonTryLater.setOnClickListener(new WelcomeHomeExploreDialogFragment$$ExternalSyntheticLambda1(this));
      var3 = this.binding;
      var4 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var4 = null;
      }

      var4.buttonNeverShow.setOnClickListener(new WelcomeHomeExploreDialogFragment$$ExternalSyntheticLambda2(this));
      var4 = this.binding;
      if (var4 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var4 = (DialogfragmentWhExploreBinding)var8;
      }

      var4.imClose.setOnClickListener(new WelcomeHomeExploreDialogFragment$$ExternalSyntheticLambda3(this));
   }
}
