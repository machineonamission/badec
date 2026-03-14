package com.blueair.android.dialog;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.core.os.BundleKt;
import androidx.fragment.app.DialogFragment;
import com.blueair.android.databinding.DialogfragmentNotificationEditNumberBinding;
import com.blueair.viewcore.R;
import com.shawnlin.numberpicker.NumberPicker;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0016\u001a\u00020\tH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R.\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0018"},
   d2 = {"Lcom/blueair/android/dialog/NotificationEditNumberDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "viewDataBinding", "Lcom/blueair/android/databinding/DialogfragmentNotificationEditNumberBinding;", "onPickResult", "Lkotlin/Function2;", "", "", "getOnPickResult", "()Lkotlin/jvm/functions/Function2;", "setOnPickResult", "(Lkotlin/jvm/functions/Function2;)V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "Companion", "app_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class NotificationEditNumberDialogFragment extends DialogFragment {
   public static final int $stable = 8;
   private static final String ARGUMENT_INITIAL_VALUE = "TRIGGER";
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private Function2 onPickResult;
   private DialogfragmentNotificationEditNumberBinding viewDataBinding;

   // $FF: synthetic method
   public static void $r8$lambda$4fkD2d6BVcQ9iGA_9TwuvpwGLng/* $FF was: $r8$lambda$4fkD2d6BVcQ9iGA-9TwuvpwGLng*/(NotificationEditNumberDialogFragment var0, View var1) {
      onCreateView$lambda$4$lambda$2(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$TZKtWC64U_atCC0xAKxlwJ7463o(NotificationEditNumberDialogFragment var0, DialogfragmentNotificationEditNumberBinding var1, View var2) {
      onCreateView$lambda$4$lambda$3(var0, var1, var2);
   }

   private static final void onCreateView$lambda$4$lambda$2(NotificationEditNumberDialogFragment var0, View var1) {
      var0.dismiss();
   }

   private static final void onCreateView$lambda$4$lambda$3(NotificationEditNumberDialogFragment var0, DialogfragmentNotificationEditNumberBinding var1, View var2) {
      Function2 var3 = var0.onPickResult;
      if (var3 != null) {
         var3.invoke(var0, var1.numberPicker.getValue());
      }

   }

   public final Function2 getOnPickResult() {
      return this.onPickResult;
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      Intrinsics.checkNotNullParameter(var1, "inflater");
      Dialog var10 = this.getDialog();
      if (var10 != null) {
         this.setStyle(0, R.style.DialogTheme);
         Window var11 = var10.getWindow();
         if (var11 != null) {
            var11.setBackgroundDrawable((Drawable)(new ColorDrawable(0)));
            var11.setWindowAnimations(R.style.dialog_animation);
         }
      }

      DialogfragmentNotificationEditNumberBinding var12 = DialogfragmentNotificationEditNumberBinding.inflate(var1, var2, false);
      Intrinsics.checkNotNullExpressionValue(var12, "inflate(...)");
      this.viewDataBinding = var12;
      Object var9 = null;
      DialogfragmentNotificationEditNumberBinding var5 = var12;
      if (var12 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var5 = null;
      }

      var5.btnCancel.setOnClickListener(new NotificationEditNumberDialogFragment$$ExternalSyntheticLambda0(this));
      var5.btnSave.setOnClickListener(new NotificationEditNumberDialogFragment$$ExternalSyntheticLambda1(this, var5));
      NumberPicker var13 = var5.numberPicker;
      Bundle var6 = this.getArguments();
      int var4;
      if (var6 != null) {
         var4 = var6.getInt("TRIGGER");
      } else {
         var4 = 10;
      }

      var13.setValue(var4);
      DialogfragmentNotificationEditNumberBinding var7 = this.viewDataBinding;
      if (var7 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var7 = (DialogfragmentNotificationEditNumberBinding)var9;
      }

      View var8 = var7.getRoot();
      Intrinsics.checkNotNullExpressionValue(var8, "getRoot(...)");
      return var8;
   }

   public void onStart() {
      super.onStart();
      Dialog var1 = this.getDialog();
      if (var1 != null) {
         Window var2 = var1.getWindow();
         if (var2 != null) {
            var2.setLayout(-1, -2);
            var2.setGravity(80);
         }
      }

   }

   public final void setOnPickResult(Function2 var1) {
      this.onPickResult = var1;
   }

   @Metadata(
      d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f0\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"},
      d2 = {"Lcom/blueair/android/dialog/NotificationEditNumberDialogFragment$Companion;", "", "<init>", "()V", "ARGUMENT_INITIAL_VALUE", "", "newInstance", "Lcom/blueair/android/dialog/NotificationEditNumberDialogFragment;", "initialValue", "", "onPickResult", "Lkotlin/Function2;", "", "app_otherRelease"},
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

      public final NotificationEditNumberDialogFragment newInstance(int var1, Function2 var2) {
         Intrinsics.checkNotNullParameter(var2, "onPickResult");
         NotificationEditNumberDialogFragment var3 = new NotificationEditNumberDialogFragment();
         var3.setArguments(BundleKt.bundleOf(new Pair[]{TuplesKt.to("TRIGGER", var1)}));
         var3.setOnPickResult(var2);
         return var3;
      }
   }
}
