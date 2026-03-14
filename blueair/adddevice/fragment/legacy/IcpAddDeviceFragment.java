package com.blueair.adddevice.fragment.legacy;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import com.blueair.adddevice.databinding.FragmentAddDeviceAutoStepOneIcpBinding;
import com.blueair.viewcore.R;
import com.blueair.viewcore.ViewUtils;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J$\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0003J\"\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001c"},
   d2 = {"Lcom/blueair/adddevice/fragment/legacy/IcpAddDeviceFragment;", "Lcom/blueair/adddevice/fragment/legacy/AddDeviceBaseFragment;", "<init>", "()V", "binding", "Lcom/blueair/adddevice/databinding/FragmentAddDeviceAutoStepOneIcpBinding;", "getRootView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "isBluetoothEnabled", "", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "Companion", "adddevice_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class IcpAddDeviceFragment extends AddDeviceBaseFragment {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private static final int REQUEST_CODE_ENABLE_BT = 100;
   private FragmentAddDeviceAutoStepOneIcpBinding binding;

   // $FF: synthetic method
   public static void $r8$lambda$2w79ytHBwykE8sXGFG19ra2HVz8(IcpAddDeviceFragment var0, View var1) {
      onViewCreated$lambda$0(var0, var1);
   }

   private final boolean isBluetoothEnabled() {
      BluetoothAdapter var1 = BluetoothAdapter.getDefaultAdapter();
      return var1 != null && var1.isEnabled();
   }

   private static final void onViewCreated$lambda$0(IcpAddDeviceFragment var0, View var1) {
      if (!var0.isBluetoothEnabled()) {
         Timber.Forest.w("attemptToCompleteStep ble not enabled", new Object[0]);
         var0.startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), REQUEST_CODE_ENABLE_BT);
      } else {
         Timber.Forest.w("attemptToCompleteStep ready to complete", new Object[0]);
         var0.getAddService().icpAddDeviceCompleted();
      }
   }

   public ConstraintLayout getRootView() {
      FragmentAddDeviceAutoStepOneIcpBinding var2 = this.binding;
      FragmentAddDeviceAutoStepOneIcpBinding var1 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var1 = null;
      }

      ConstraintLayout var3 = var1.getRoot();
      Intrinsics.checkNotNullExpressionValue(var3, "getRoot(...)");
      return var3;
   }

   @Deprecated(
      message = "Deprecated in Java"
   )
   public void onActivityResult(int var1, int var2, Intent var3) {
      super.onActivityResult(var1, var2, var3);
      if (var1 == REQUEST_CODE_ENABLE_BT) {
         if (var2 == -1) {
            this.getAddService().icpAddDeviceCompleted();
            return;
         }

         ViewUtils var5 = ViewUtils.INSTANCE;
         FragmentActivity var4 = this.requireActivity();
         Intrinsics.checkNotNullExpressionValue(var4, "requireActivity(...)");
         var5.showError((Activity)var4, R.string.add_device_turn_on_bluetooth);
      }

   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      Intrinsics.checkNotNullParameter(var1, "inflater");
      FragmentAddDeviceAutoStepOneIcpBinding var6 = FragmentAddDeviceAutoStepOneIcpBinding.inflate(var1, var2, false);
      Intrinsics.checkNotNullExpressionValue(var6, "inflate(...)");
      this.binding = var6;
      FragmentAddDeviceAutoStepOneIcpBinding var4 = var6;
      if (var6 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var4 = null;
      }

      ConstraintLayout var5 = var4.getRoot();
      Intrinsics.checkNotNullExpressionValue(var5, "getRoot(...)");
      return (View)var5;
   }

   public void onViewCreated(View var1, Bundle var2) {
      Intrinsics.checkNotNullParameter(var1, "view");
      super.onViewCreated(var1, var2);
      FragmentAddDeviceAutoStepOneIcpBinding var4 = this.binding;
      FragmentAddDeviceAutoStepOneIcpBinding var3 = var4;
      if (var4 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var3 = null;
      }

      var3.buttonNext.setOnClickListener(new IcpAddDeviceFragment$$ExternalSyntheticLambda0(this));
   }

   @Metadata(
      d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000¨\u0006\t"},
      d2 = {"Lcom/blueair/adddevice/fragment/legacy/IcpAddDeviceFragment$Companion;", "", "<init>", "()V", "REQUEST_CODE_ENABLE_BT", "", "newInstance", "Lcom/blueair/adddevice/fragment/legacy/IcpAddDeviceFragment;", "deviceModelType", "adddevice_otherRelease"},
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

      public final IcpAddDeviceFragment newInstance(int var1) {
         IcpAddDeviceFragment var3 = new IcpAddDeviceFragment();
         Bundle var2 = new Bundle();
         var2.putInt("deviceModelType", var1);
         var3.setArguments(var2);
         return var3;
      }
   }
}
