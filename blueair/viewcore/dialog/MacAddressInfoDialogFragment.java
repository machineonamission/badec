package com.blueair.viewcore.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.blueair.core.model.DeviceType;
import com.blueair.viewcore.R;
import com.google.android.material.button.MaterialButton;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(
   d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"},
   d2 = {"Lcom/blueair/viewcore/dialog/MacAddressInfoDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "deviceType", "Lcom/blueair/core/model/DeviceType;", "<init>", "(Lcom/blueair/core/model/DeviceType;)V", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "viewcore_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class MacAddressInfoDialogFragment extends DialogFragment {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private DeviceType deviceType;

   // $FF: synthetic method
   public static void $r8$lambda$zp_uS_7CZ3KUR9yav5bnLktrWFw/* $FF was: $r8$lambda$zp_uS-7CZ3KUR9yav5bnLktrWFw*/(MacAddressInfoDialogFragment var0, View var1) {
      onCreateDialog$lambda$3(var0, var1);
   }

   public MacAddressInfoDialogFragment() {
      this((DeviceType)null, 1, (DefaultConstructorMarker)null);
   }

   public MacAddressInfoDialogFragment(DeviceType var1) {
      this.deviceType = var1;
   }

   // $FF: synthetic method
   public MacAddressInfoDialogFragment(DeviceType var1, int var2, DefaultConstructorMarker var3) {
      if ((var2 & 1) != 0) {
         var1 = null;
      }

      this(var1);
   }

   private static final void onCreateDialog$lambda$3(MacAddressInfoDialogFragment var0, View var1) {
      var0.dismiss();
   }

   public Dialog onCreateDialog(Bundle var1) {
      FragmentActivity var6 = this.getActivity();
      Object var3 = null;
      LayoutInflater var7;
      if (var6 != null) {
         var7 = var6.getLayoutInflater();
      } else {
         var7 = null;
      }

      View var8;
      if (var7 != null) {
         var8 = var7.inflate(R.layout.dialog_mac_address_info, (ViewGroup)null);
      } else {
         var8 = null;
      }

      if (var8 != null) {
         TextView var4 = (TextView)var8.findViewById(R.id.dialog_msg);
         if (var4 != null) {
            DeviceType var2 = this.deviceType;
            String var9;
            if (!(var2 instanceof DeviceType.B4) && !(var2 instanceof DeviceType.B4sp)) {
               var9 = this.getString(R.string.mac_address_info);
            } else {
               var9 = this.getString(R.string.mac_address_info_b4);
            }

            var4.setText((CharSequence)var9);
         }
      }

      Dialog var12 = new Dialog(this.requireContext());
      if (var8 != null) {
         var12.setContentView(var8);
      }

      FragmentActivity var5 = this.getActivity();
      if (var5 != null) {
         Window var10 = var12.getWindow();
         if (var10 != null) {
            var10.setBackgroundDrawable(ContextCompat.getDrawable((Context)var5, R.drawable.rounded_rectangle_white));
         }
      }

      MaterialButton var11 = (MaterialButton)var3;
      if (var8 != null) {
         var11 = (MaterialButton)var8.findViewById(R.id.buttonClose);
      }

      if (var11 != null) {
         var11.setOnClickListener(new MacAddressInfoDialogFragment$$ExternalSyntheticLambda0(this));
      }

      var12.show();
      return var12;
   }

   @Metadata(
      d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¨\u0006\b"},
      d2 = {"Lcom/blueair/viewcore/dialog/MacAddressInfoDialogFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/viewcore/dialog/MacAddressInfoDialogFragment;", "deviceType", "Lcom/blueair/core/model/DeviceType;", "viewcore_otherRelease"},
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

      // $FF: synthetic method
      public static MacAddressInfoDialogFragment newInstance$default(Companion var0, DeviceType var1, int var2, Object var3) {
         if ((var2 & 1) != 0) {
            var1 = null;
         }

         return var0.newInstance(var1);
      }

      public final MacAddressInfoDialogFragment newInstance(DeviceType var1) {
         return new MacAddressInfoDialogFragment(var1);
      }
   }
}
