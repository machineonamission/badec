package com.blueair.adddevice.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import androidx.core.os.BundleKt;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentKt;
import androidx.fragment.app.FragmentManager;
import com.blueair.adddevice.databinding.DialogDeviceDetectedBinding;
import com.blueair.core.model.BluetoothDevice;
import com.blueair.core.model.DeviceImage;
import com.blueair.viewcore.R;
import com.blueair.viewcore.dialog.MacAddressInfoDialogFragment;
import com.blueair.viewcore.utils.DeviceConfigProvider;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"},
   d2 = {"Lcom/blueair/adddevice/dialog/DeviceDetectedDialog;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "connectClicked", "", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onDismiss", "", "dialog", "Landroid/content/DialogInterface;", "Companion", "adddevice_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceDetectedDialog extends DialogFragment {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   public static final String DATA_CONNECT_CLICKED = "DATA_CONNECT_CLICKED";
   public static final String REQUEST_KEY = "DeviceDetectedDialog";
   private boolean connectClicked;

   // $FF: synthetic method
   public static void $r8$lambda$2xNbaGkF3Vd0tGrgl7tK6FI0Sr4(DeviceDetectedDialog var0, BluetoothDevice var1, View var2) {
      onCreateDialog$lambda$5$lambda$2(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$O5QhScQCB410tOqYCqlhy_z6Tzc(DeviceDetectedDialog var0, View var1) {
      onCreateDialog$lambda$5$lambda$4(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$sW0WxKztLxD8JEC9qphRYOhUgOM(DeviceDetectedDialog var0, View var1) {
      onCreateDialog$lambda$5$lambda$3(var0, var1);
   }

   private static final void onCreateDialog$lambda$5$lambda$2(DeviceDetectedDialog var0, BluetoothDevice var1, View var2) {
      FragmentManager var3 = var0.getChildFragmentManager();
      Intrinsics.checkNotNullExpressionValue(var3, "getChildFragmentManager(...)");
      Intrinsics.checkNotNullExpressionValue("MacAddressInfoDialogFragment", "getSimpleName(...)");
      if (!(var3.findFragmentByTag("MacAddressInfoDialogFragment") instanceof MacAddressInfoDialogFragment) && !var3.isStateSaved()) {
         ((DialogFragment)MacAddressInfoDialogFragment.Companion.newInstance(var1.getDeviceType())).show(var3, "MacAddressInfoDialogFragment");
      }

   }

   private static final void onCreateDialog$lambda$5$lambda$3(DeviceDetectedDialog var0, View var1) {
      var0.dismiss();
   }

   private static final void onCreateDialog$lambda$5$lambda$4(DeviceDetectedDialog var0, View var1) {
      var0.connectClicked = true;
      var0.dismiss();
   }

   public Dialog onCreateDialog(Bundle var1) {
      LayoutInflater var7 = this.getLayoutInflater();
      int var2 = 0;
      DialogDeviceDetectedBinding var3 = DialogDeviceDetectedBinding.inflate(var7, (ViewGroup)null, false);
      Intrinsics.checkNotNullExpressionValue(var3, "inflate(...)");
      Dialog var8 = new Dialog(this.requireContext());
      var8.setContentView((View)var3.getRoot());
      Window var4 = var8.getWindow();
      if (var4 != null) {
         var4.setBackgroundDrawable(ContextCompat.getDrawable(this.requireContext(), R.drawable.rounded_rectangle_white));
      }

      BluetoothDevice var9 = (BluetoothDevice)this.requireArguments().getParcelable("device");
      if (var9 == null) {
         this.dismiss();
         return var8;
      } else {
         var3.title.setText((CharSequence)var9.getModelName());
         ImageView var6 = var3.deviceImg;
         DeviceImage var5 = DeviceConfigProvider.INSTANCE.getDeviceImage(var9);
         if (var5 != null) {
            var2 = var5.getDevice();
         }

         var6.setImageResource(var2);
         var3.macNumberValue.setText((CharSequence)var9.getWifiMac());
         var3.macNumberTitle.setOnClickListener(new DeviceDetectedDialog$$ExternalSyntheticLambda0(this, var9));
         var3.closeButton.setOnClickListener(new DeviceDetectedDialog$$ExternalSyntheticLambda1(this));
         var3.connectButton.setOnClickListener(new DeviceDetectedDialog$$ExternalSyntheticLambda2(this));
         return var8;
      }
   }

   public void onDismiss(DialogInterface var1) {
      Intrinsics.checkNotNullParameter(var1, "dialog");
      super.onDismiss(var1);
      FragmentKt.setFragmentResult((Fragment)this, "DeviceDetectedDialog", BundleKt.bundleOf(new Pair[]{TuplesKt.to("DATA_CONNECT_CLICKED", this.connectClicked)}));
   }

   @Metadata(
      d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"},
      d2 = {"Lcom/blueair/adddevice/dialog/DeviceDetectedDialog$Companion;", "", "<init>", "()V", "REQUEST_KEY", "", "DATA_CONNECT_CLICKED", "newInstance", "Lcom/blueair/adddevice/dialog/DeviceDetectedDialog;", "device", "Lcom/blueair/core/model/BluetoothDevice;", "adddevice_otherRelease"},
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

      public final DeviceDetectedDialog newInstance(BluetoothDevice var1) {
         Intrinsics.checkNotNullParameter(var1, "device");
         DeviceDetectedDialog var2 = new DeviceDetectedDialog();
         var2.setArguments(BundleKt.bundleOf(new Pair[]{TuplesKt.to("device", var1)}));
         return var2;
      }
   }
}
