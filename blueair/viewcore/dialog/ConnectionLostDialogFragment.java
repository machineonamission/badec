package com.blueair.viewcore.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.blueair.viewcore.R;
import com.google.android.material.button.MaterialButton;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0016R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"},
   d2 = {"Lcom/blueair/viewcore/dialog/ConnectionLostDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "dismissListener", "Lkotlin/Function0;", "", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "Companion", "viewcore_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class ConnectionLostDialogFragment extends DialogFragment {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private Function0 dismissListener;

   // $FF: synthetic method
   public static void $r8$lambda$9lw1l_VvHTnQLze2Lv2EUXcYj_g/* $FF was: $r8$lambda$9lw1l_VvHTnQLze2Lv2EUXcYj-g*/(ConnectionLostDialogFragment var0, View var1) {
      onCreateDialog$lambda$2(var0, var1);
   }

   private static final void onCreateDialog$lambda$2(ConnectionLostDialogFragment var0, View var1) {
      var0.dismiss();
   }

   public Dialog onCreateDialog(Bundle var1) {
      FragmentActivity var6 = this.getActivity();
      MaterialButton var2 = null;
      LayoutInflater var7;
      if (var6 != null) {
         var7 = var6.getLayoutInflater();
      } else {
         var7 = null;
      }

      View var8;
      if (var7 != null) {
         var8 = var7.inflate(R.layout.dialog_connection_lost, (ViewGroup)null);
      } else {
         var8 = null;
      }

      Dialog var3 = new Dialog(this.requireContext());
      if (var8 != null) {
         var3.setContentView(var8);
      }

      FragmentActivity var5 = this.getActivity();
      if (var5 != null) {
         Window var4 = var3.getWindow();
         if (var4 != null) {
            var4.setBackgroundDrawable(ContextCompat.getDrawable((Context)var5, R.drawable.rounded_rectangle_white));
         }
      }

      if (var8 != null) {
         var2 = (MaterialButton)var8.findViewById(R.id.buttonTryAgainLater);
      }

      if (var2 != null) {
         var2.setOnClickListener(new ConnectionLostDialogFragment$$ExternalSyntheticLambda0(this));
      }

      var3.show();
      return var3;
   }

   public void onDismiss(DialogInterface var1) {
      Intrinsics.checkNotNullParameter(var1, "dialog");
      super.onDismiss(var1);
      Function0 var2 = this.dismissListener;
      if (var2 != null) {
         var2.invoke();
      }

   }

   @Metadata(
      d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¨\u0006\t"},
      d2 = {"Lcom/blueair/viewcore/dialog/ConnectionLostDialogFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/viewcore/dialog/ConnectionLostDialogFragment;", "dismissListener", "Lkotlin/Function0;", "", "viewcore_otherRelease"},
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

      public final ConnectionLostDialogFragment newInstance(Function0 var1) {
         ConnectionLostDialogFragment var2 = new ConnectionLostDialogFragment();
         var2.dismissListener = var1;
         return var2;
      }
   }
}
