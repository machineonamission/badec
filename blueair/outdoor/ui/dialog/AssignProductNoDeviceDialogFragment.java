package com.blueair.outdoor.ui.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.os.BundleKt;
import androidx.fragment.app.DialogFragment;
import com.blueair.outdoor.R;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\t"},
   d2 = {"Lcom/blueair/outdoor/ui/dialog/AssignProductNoDeviceDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "outdoor_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class AssignProductNoDeviceDialogFragment extends DialogFragment {
   private static final String ARG_LOCATION_NAME = "ARG_LOCATION_NAME";
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);

   // $FF: synthetic method
   public static void $r8$lambda$QsoRTausFIHFAoN7BE5ADelUTlw(AssignProductNoDeviceDialogFragment var0, View var1) {
      onCreateDialog$lambda$1(var0, var1);
   }

   private static final void onCreateDialog$lambda$1(AssignProductNoDeviceDialogFragment var0, View var1) {
      var0.dismiss();
   }

   public Dialog onCreateDialog(Bundle var1) {
      View var4 = this.requireActivity().getLayoutInflater().inflate(R.layout.dialog_assign_product_no_device, (ViewGroup)null);
      String var3 = this.requireArguments().getString("ARG_LOCATION_NAME");
      if (var3 != null) {
         TextView var2 = (TextView)var4.findViewById(R.id.dialog_sub_title);
         if (var2 != null) {
            var2.setText((CharSequence)var3);
         }
      }

      Dialog var6 = new Dialog(this.requireContext());
      var6.setContentView(var4);
      Window var7 = var6.getWindow();
      if (var7 != null) {
         var7.setBackgroundDrawable(ContextCompat.getDrawable(this.requireContext(), com.blueair.viewcore.R.drawable.rounded_rectangle_white));
      }

      var4 = var4.findViewById(R.id.btn_primary);
      if (var4 != null) {
         var4.setOnClickListener(new AssignProductNoDeviceDialogFragment$$ExternalSyntheticLambda0(this));
      }

      var6.show();
      return var6;
   }

   @Metadata(
      d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"},
      d2 = {"Lcom/blueair/outdoor/ui/dialog/AssignProductNoDeviceDialogFragment$Companion;", "", "<init>", "()V", "ARG_LOCATION_NAME", "", "newInstance", "Lcom/blueair/outdoor/ui/dialog/AssignProductNoDeviceDialogFragment;", "locationName", "outdoor_otherRelease"},
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

      public final AssignProductNoDeviceDialogFragment newInstance(String var1) {
         Intrinsics.checkNotNullParameter(var1, "locationName");
         AssignProductNoDeviceDialogFragment var2 = new AssignProductNoDeviceDialogFragment();
         var2.setArguments(BundleKt.bundleOf(new Pair[]{TuplesKt.to("ARG_LOCATION_NAME", var1)}));
         return var2;
      }
   }
}
