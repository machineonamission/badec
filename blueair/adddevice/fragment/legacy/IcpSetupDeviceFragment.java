package com.blueair.adddevice.fragment.legacy;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blueair.adddevice.databinding.FragmentAddDeviceAutoStepSetupIcpBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J$\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0014"},
   d2 = {"Lcom/blueair/adddevice/fragment/legacy/IcpSetupDeviceFragment;", "Lcom/blueair/adddevice/fragment/legacy/AddDeviceBaseFragment;", "<init>", "()V", "binding", "Lcom/blueair/adddevice/databinding/FragmentAddDeviceAutoStepSetupIcpBinding;", "getRootView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "Companion", "adddevice_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class IcpSetupDeviceFragment extends AddDeviceBaseFragment {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private FragmentAddDeviceAutoStepSetupIcpBinding binding;

   // $FF: synthetic method
   public static void $r8$lambda$u_rFVj46j71OMs2IUL6Rk8o948k(IcpSetupDeviceFragment var0, View var1) {
      onViewCreated$lambda$0(var0, var1);
   }

   private static final void onViewCreated$lambda$0(IcpSetupDeviceFragment var0, View var1) {
      var0.getAddService().icpSetupDeviceCompleted();
   }

   public ConstraintLayout getRootView() {
      FragmentAddDeviceAutoStepSetupIcpBinding var2 = this.binding;
      FragmentAddDeviceAutoStepSetupIcpBinding var1 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var1 = null;
      }

      ConstraintLayout var3 = var1.getRoot();
      Intrinsics.checkNotNullExpressionValue(var3, "getRoot(...)");
      return var3;
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      Intrinsics.checkNotNullParameter(var1, "inflater");
      FragmentAddDeviceAutoStepSetupIcpBinding var6 = FragmentAddDeviceAutoStepSetupIcpBinding.inflate(var1, var2, false);
      Intrinsics.checkNotNullExpressionValue(var6, "inflate(...)");
      this.binding = var6;
      FragmentAddDeviceAutoStepSetupIcpBinding var4 = var6;
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
      FragmentAddDeviceAutoStepSetupIcpBinding var4 = this.binding;
      FragmentAddDeviceAutoStepSetupIcpBinding var3 = var4;
      if (var4 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var3 = null;
      }

      var3.buttonNext.setOnClickListener(new IcpSetupDeviceFragment$$ExternalSyntheticLambda0(this));
   }

   @Metadata(
      d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"},
      d2 = {"Lcom/blueair/adddevice/fragment/legacy/IcpSetupDeviceFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/adddevice/fragment/legacy/IcpSetupDeviceFragment;", "deviceModelType", "", "adddevice_otherRelease"},
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

      public final IcpSetupDeviceFragment newInstance(int var1) {
         IcpSetupDeviceFragment var2 = new IcpSetupDeviceFragment();
         Bundle var3 = new Bundle();
         var3.putInt("deviceModelType", var1);
         var2.setArguments(var3);
         return var2;
      }
   }
}
