package com.blueair.android.dialog;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.DialogFragment;
import com.blueair.android.databinding.DialogAqiIndexInfoBinding;
import com.blueair.viewcore.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0011"},
   d2 = {"Lcom/blueair/android/dialog/AqiIndexInfoDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "viewDataBinding", "Lcom/blueair/android/databinding/DialogAqiIndexInfoBinding;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "", "Companion", "app_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class AqiIndexInfoDialogFragment extends DialogFragment {
   public static final int $stable = 8;
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private DialogAqiIndexInfoBinding viewDataBinding;

   // $FF: synthetic method
   public static void $r8$lambda$qKquMYyATyZanlMJmCkJ14AbSt4(AqiIndexInfoDialogFragment var0, View var1) {
      onCreateView$lambda$2$lambda$1(var0, var1);
   }

   private static final void onCreateView$lambda$2$lambda$1(AqiIndexInfoDialogFragment var0, View var1) {
      var0.dismiss();
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      Intrinsics.checkNotNullParameter(var1, "inflater");
      Dialog var8 = this.getDialog();
      if (var8 != null) {
         this.setStyle(0, R.style.DialogTheme);
         Window var9 = var8.getWindow();
         if (var9 != null) {
            var9.setBackgroundDrawable((Drawable)(new ColorDrawable(0)));
         }

         Dialog var10 = this.getDialog();
         if (var10 != null) {
            Window var11 = var10.getWindow();
            if (var11 != null) {
               var11.setWindowAnimations(R.style.dialog_animation);
            }
         }
      }

      DialogAqiIndexInfoBinding var12 = DialogAqiIndexInfoBinding.inflate(var1, var2, false);
      Intrinsics.checkNotNullExpressionValue(var12, "inflate(...)");
      this.viewDataBinding = var12;
      Object var7 = null;
      DialogAqiIndexInfoBinding var4 = var12;
      if (var12 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var4 = null;
      }

      var4.closeButton.setOnClickListener(new AqiIndexInfoDialogFragment$$ExternalSyntheticLambda0(this));
      var4 = this.viewDataBinding;
      if (var4 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var4 = (DialogAqiIndexInfoBinding)var7;
      }

      View var6 = var4.getRoot();
      Intrinsics.checkNotNullExpressionValue(var6, "getRoot(...)");
      return var6;
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

   @Metadata(
      d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"},
      d2 = {"Lcom/blueair/android/dialog/AqiIndexInfoDialogFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/android/dialog/AqiIndexInfoDialogFragment;", "app_otherRelease"},
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

      public final AqiIndexInfoDialogFragment newInstance() {
         return new AqiIndexInfoDialogFragment();
      }
   }
}
