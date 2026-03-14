package com.blueair.adddevice.fragment.legacy;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blueair.adddevice.databinding.FragmentAddDeviceManualFailBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J$\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0013"},
   d2 = {"Lcom/blueair/adddevice/fragment/legacy/AddDeviceManualConfigurationFailed;", "Lcom/blueair/adddevice/fragment/legacy/AddDeviceBaseFragment;", "<init>", "()V", "binding", "Lcom/blueair/adddevice/databinding/FragmentAddDeviceManualFailBinding;", "getRootView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "", "Companion", "adddevice_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class AddDeviceManualConfigurationFailed extends AddDeviceBaseFragment {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private FragmentAddDeviceManualFailBinding binding;

   // $FF: synthetic method
   public static void $r8$lambda$XOY1kDtM4b7LWqgvProp3Zu7f4E(AddDeviceManualConfigurationFailed var0, View var1) {
      onCreateView$lambda$0(var0, var1);
   }

   private static final void onCreateView$lambda$0(AddDeviceManualConfigurationFailed var0, View var1) {
      var0.getAddService().restartManualConfig();
   }

   public ConstraintLayout getRootView() {
      FragmentAddDeviceManualFailBinding var2 = this.binding;
      FragmentAddDeviceManualFailBinding var1 = var2;
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
      FragmentAddDeviceManualFailBinding var4 = FragmentAddDeviceManualFailBinding.inflate(var1, var2, false);
      Intrinsics.checkNotNullExpressionValue(var4, "inflate(...)");
      this.binding = var4;
      this.getDeviceModelType();
      FragmentAddDeviceManualFailBinding var13 = this.binding;
      Object var12 = null;
      var4 = var13;
      if (var13 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var4 = null;
      }

      ImageView var6 = var4.imgManualFail;
      Intrinsics.checkNotNullExpressionValue(var6, "imgManualFail");
      var6.setVisibility(4);
      var13 = this.binding;
      FragmentAddDeviceManualFailBinding var7 = var13;
      if (var13 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var7 = null;
      }

      var7.buttonRestart.setOnClickListener(new AddDeviceManualConfigurationFailed$$ExternalSyntheticLambda0(this));
      if (this.getContext() != null) {
         Context var8 = this.getContext();
         Intrinsics.checkNotNull(var8, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
         ActionBar var9 = ((AppCompatActivity)var8).getSupportActionBar();
         if (var9 != null) {
            var9.setDisplayHomeAsUpEnabled(false);
         }
      }

      var7 = this.binding;
      if (var7 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var7 = (FragmentAddDeviceManualFailBinding)var12;
      }

      ConstraintLayout var11 = var7.getRoot();
      Intrinsics.checkNotNullExpressionValue(var11, "getRoot(...)");
      return (View)var11;
   }

   public void onDestroyView() {
      super.onDestroyView();
      if (this.getContext() != null) {
         Context var1 = this.getContext();
         Intrinsics.checkNotNull(var1, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
         ActionBar var2 = ((AppCompatActivity)var1).getSupportActionBar();
         if (var2 != null) {
            var2.setDisplayHomeAsUpEnabled(true);
         }
      }

   }

   @Metadata(
      d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"},
      d2 = {"Lcom/blueair/adddevice/fragment/legacy/AddDeviceManualConfigurationFailed$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/adddevice/fragment/legacy/AddDeviceManualConfigurationFailed;", "deviceModelType", "", "adddevice_otherRelease"},
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

      public final AddDeviceManualConfigurationFailed newInstance(int var1) {
         AddDeviceManualConfigurationFailed var3 = new AddDeviceManualConfigurationFailed();
         Bundle var2 = new Bundle();
         var2.putInt("deviceModelType", var1);
         var3.setArguments(var2);
         return var3;
      }
   }
}
