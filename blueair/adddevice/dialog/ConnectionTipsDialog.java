package com.blueair.adddevice.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.blueair.adddevice.databinding.DialogConnectionTipsBinding;
import com.blueair.viewcore.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\t"},
   d2 = {"Lcom/blueair/adddevice/dialog/ConnectionTipsDialog;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "adddevice_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class ConnectionTipsDialog extends DialogFragment {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);

   // $FF: synthetic method
   public static void $r8$lambda$x1d9sesP__VFb9ZKDo7NeqSXdiM(ConnectionTipsDialog var0, View var1) {
      onCreateDialog$lambda$0(var0, var1);
   }

   private static final void onCreateDialog$lambda$0(ConnectionTipsDialog var0, View var1) {
      var0.dismiss();
   }

   public Dialog onCreateDialog(Bundle var1) {
      DialogConnectionTipsBinding var2 = DialogConnectionTipsBinding.inflate(this.getLayoutInflater(), (ViewGroup)null, false);
      Intrinsics.checkNotNullExpressionValue(var2, "inflate(...)");
      var2.confirmButton.setOnClickListener(new ConnectionTipsDialog$$ExternalSyntheticLambda0(this));
      Dialog var4 = new Dialog(this.requireContext());
      var4.setContentView((View)var2.getRoot());
      FragmentActivity var5 = this.getActivity();
      if (var5 != null) {
         Window var3 = var4.getWindow();
         if (var3 != null) {
            var3.setBackgroundDrawable(ContextCompat.getDrawable((Context)var5, R.drawable.rounded_rectangle_white));
         }
      }

      return var4;
   }

   @Metadata(
      d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"},
      d2 = {"Lcom/blueair/adddevice/dialog/ConnectionTipsDialog$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/adddevice/dialog/ConnectionTipsDialog;", "adddevice_otherRelease"},
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

      public final ConnectionTipsDialog newInstance() {
         return new ConnectionTipsDialog();
      }
   }
}
