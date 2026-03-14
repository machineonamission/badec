package com.blueair.adddevice.dialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;
import com.blueair.adddevice.databinding.DialogNoIcpDetectedBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\r"},
   d2 = {"Lcom/blueair/adddevice/dialog/CannotFindIcpDialog;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "adddevice_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class CannotFindIcpDialog extends DialogFragment {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);

   // $FF: synthetic method
   public static void $r8$lambda$XarTKpdLlFe_n__R341EVeraTQw/* $FF was: $r8$lambda$XarTKpdLlFe_n-_R341EVeraTQw*/(CannotFindIcpDialog var0, View var1) {
      onCreateView$lambda$0(var0, var1);
   }

   private static final void onCreateView$lambda$0(CannotFindIcpDialog var0, View var1) {
      var0.dismiss();
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      Intrinsics.checkNotNullParameter(var1, "inflater");
      DialogNoIcpDetectedBinding var4 = DialogNoIcpDetectedBinding.inflate(var1, var2, false);
      Intrinsics.checkNotNullExpressionValue(var4, "inflate(...)");
      var4.button.setOnClickListener(new CannotFindIcpDialog$$ExternalSyntheticLambda0(this));
      ConstraintLayout var5 = var4.getRoot();
      Intrinsics.checkNotNullExpressionValue(var5, "getRoot(...)");
      return (View)var5;
   }

   @Metadata(
      d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"},
      d2 = {"Lcom/blueair/adddevice/dialog/CannotFindIcpDialog$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/adddevice/dialog/CannotFindIcpDialog;", "adddevice_otherRelease"},
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

      public final CannotFindIcpDialog newInstance() {
         return new CannotFindIcpDialog();
      }
   }
}
