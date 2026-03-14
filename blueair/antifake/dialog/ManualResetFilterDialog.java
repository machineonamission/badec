package com.blueair.antifake.dialog;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.os.BundleKt;
import androidx.fragment.app.DialogFragment;
import com.blueair.antifake.adapter.ManualResetAdapter;
import com.blueair.antifake.databinding.DialogfragmentManualResetFilterBinding;
import com.blueair.core.model.DeviceFilterType;
import com.blueair.viewcore.R;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000f"},
   d2 = {"Lcom/blueair/antifake/dialog/ManualResetFilterDialog;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "", "Companion", "antifake_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class ManualResetFilterDialog extends DialogFragment {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);

   // $FF: synthetic method
   public static void $r8$lambda$T2mqfRJ4l5Yx0pWClM3sNxT583M(ManualResetFilterDialog var0, View var1) {
      onCreateView$lambda$1(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$UUOVxtFf_NZ6u8bxfnXisl64wiE/* $FF was: $r8$lambda$UUOVxtFf-NZ6u8bxfnXisl64wiE*/(ManualResetFilterDialog var0, View var1) {
      onCreateView$lambda$2(var0, var1);
   }

   private static final void onCreateView$lambda$1(ManualResetFilterDialog var0, View var1) {
      var0.dismiss();
   }

   private static final void onCreateView$lambda$2(ManualResetFilterDialog var0, View var1) {
      var0.dismiss();
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      Intrinsics.checkNotNullParameter(var1, "inflater");
      Dialog var7 = this.getDialog();
      if (var7 != null) {
         this.setStyle(0, R.style.DialogTheme);
         Window var8 = var7.getWindow();
         if (var8 != null) {
            var8.setBackgroundDrawable((Drawable)(new ColorDrawable(0)));
         }

         Dialog var9 = this.getDialog();
         if (var9 != null) {
            Window var10 = var9.getWindow();
            if (var10 != null) {
               var10.setWindowAnimations(R.style.dialog_animation_right);
            }
         }
      }

      DialogfragmentManualResetFilterBinding var4 = DialogfragmentManualResetFilterBinding.inflate(var1, var2, false);
      Intrinsics.checkNotNullExpressionValue(var4, "inflate(...)");
      var4.pager.setAdapter(new ManualResetAdapter());
      var4.pageDots.attachToPager(var4.pager);
      var4.btnBack.setOnClickListener(new ManualResetFilterDialog$$ExternalSyntheticLambda0(this));
      var4.btnConfirm.setOnClickListener(new ManualResetFilterDialog$$ExternalSyntheticLambda1(this));
      TextView var6 = var4.customerSupportText;
      String var11 = this.getString(R.string.customer_support);
      Intrinsics.checkNotNullExpressionValue(var11, "getString(...)");
      Pattern var12 = Pattern.compile(var11, 0);
      Intrinsics.checkNotNullExpressionValue(var12, "compile(...)");
      Linkify.addLinks(var6, var12, "tel:400-006-9693");
      var4.customerSupportText.setMovementMethod(LinkMovementMethod.getInstance());
      LinearLayout var5 = var4.getRoot();
      Intrinsics.checkNotNullExpressionValue(var5, "getRoot(...)");
      return (View)var5;
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
      d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"},
      d2 = {"Lcom/blueair/antifake/dialog/ManualResetFilterDialog$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/antifake/dialog/ManualResetFilterDialog;", "filterType", "Lcom/blueair/core/model/DeviceFilterType;", "antifake_otherRelease"},
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

      public final ManualResetFilterDialog newInstance(DeviceFilterType var1) {
         Intrinsics.checkNotNullParameter(var1, "filterType");
         ManualResetFilterDialog var2 = new ManualResetFilterDialog();
         var2.setArguments(BundleKt.bundleOf(new Pair[]{TuplesKt.to("filter_type", var1.name())}));
         return var2;
      }
   }
}
