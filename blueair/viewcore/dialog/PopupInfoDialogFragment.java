package com.blueair.viewcore.dialog;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.core.os.BundleKt;
import androidx.fragment.app.DialogFragment;
import com.blueair.viewcore.R;
import com.blueair.viewcore.databinding.DialogfragmentPopupInfoBinding;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0011"},
   d2 = {"Lcom/blueair/viewcore/dialog/PopupInfoDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "binding", "Lcom/blueair/viewcore/databinding/DialogfragmentPopupInfoBinding;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "", "Companion", "viewcore_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class PopupInfoDialogFragment extends DialogFragment {
   private static final String ARG_CONTENT_MESSAGE = "ARG_CONTENT_MESSAGE";
   private static final String ARG_CONTENT_TITLE = "ARG_CONTENT_TITLE";
   private static final String ARG_TITLE = "ARG_TITLE";
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private DialogfragmentPopupInfoBinding binding;

   // $FF: synthetic method
   public static void $r8$lambda$qwFW7snDFHq4TwCyDWuDx3_4ep4/* $FF was: $r8$lambda$qwFW7snDFHq4TwCyDWuDx3-4ep4*/(PopupInfoDialogFragment var0, View var1) {
      onCreateView$lambda$4$lambda$3(var0, var1);
   }

   private static final void onCreateView$lambda$4$lambda$3(PopupInfoDialogFragment var0, View var1) {
      var0.dismiss();
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      Intrinsics.checkNotNullParameter(var1, "inflater");
      this.setStyle(0, R.style.DialogTheme);
      Dialog var9 = this.getDialog();
      if (var9 != null) {
         Window var10 = var9.getWindow();
         if (var10 != null) {
            var10.setBackgroundDrawable((Drawable)(new ColorDrawable(0)));
            var10.setWindowAnimations(R.style.dialog_animation);
            var10.setGravity(80);
         }
      }

      DialogfragmentPopupInfoBinding var8 = DialogfragmentPopupInfoBinding.inflate(var1, var2, false);
      Intrinsics.checkNotNullExpressionValue(var8, "inflate(...)");
      Bundle var11 = this.requireArguments();
      var8.title.setText(var11.getInt("ARG_TITLE"));
      int var4 = var11.getInt("ARG_CONTENT_TITLE");
      if (var4 > 0) {
         var8.contentTitle.setText(var4);
      } else {
         TextView var5 = var8.contentTitle;
         Intrinsics.checkNotNullExpressionValue(var5, "contentTitle");
         ViewExtensionsKt.hide((View)var5);
      }

      var8.contentMessage.setText(var11.getInt("ARG_CONTENT_MESSAGE"));
      var8.doneBtn.setOnClickListener(new PopupInfoDialogFragment$$ExternalSyntheticLambda0(this));
      this.binding = var8;
      DialogfragmentPopupInfoBinding var6 = var8;
      if (var8 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var6 = null;
      }

      View var7 = var6.getRoot();
      Intrinsics.checkNotNullExpressionValue(var7, "getRoot(...)");
      return var7;
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
      d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u000b¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"},
      d2 = {"Lcom/blueair/viewcore/dialog/PopupInfoDialogFragment$Companion;", "", "<init>", "()V", "ARG_TITLE", "", "ARG_CONTENT_TITLE", "ARG_CONTENT_MESSAGE", "newInstance", "Lcom/blueair/viewcore/dialog/PopupInfoDialogFragment;", "title", "", "contentTitle", "message", "(ILjava/lang/Integer;I)Lcom/blueair/viewcore/dialog/PopupInfoDialogFragment;", "viewcore_otherRelease"},
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

      public final PopupInfoDialogFragment newInstance(int var1, Integer var2, int var3) {
         PopupInfoDialogFragment var4 = new PopupInfoDialogFragment();
         Pair var5 = TuplesKt.to("ARG_TITLE", var1);
         if (var2 != null) {
            var1 = var2;
         } else {
            var1 = -1;
         }

         var4.setArguments(BundleKt.bundleOf(new Pair[]{var5, TuplesKt.to("ARG_CONTENT_TITLE", var1), TuplesKt.to("ARG_CONTENT_MESSAGE", var3)}));
         return var4;
      }
   }
}
