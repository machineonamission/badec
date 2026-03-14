package com.blueair.devicedetails.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.viewbinding.ViewBinding;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.DeviceNewClassic;
import com.blueair.devicedetails.activity.DeviceSettingsActivity;
import com.blueair.devicedetails.databinding.FragmentDeviceHSettingsBinding;
import com.blueair.devicedetails.databinding.FragmentDeviceNSettingsBinding;
import com.blueair.devicedetails.databinding.FragmentDeviceSettingsBinding;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0011"},
   d2 = {"Lcom/blueair/devicedetails/fragment/DeviceSettingsFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "binding", "Landroidx/viewbinding/ViewBinding;", "device", "Lcom/blueair/core/model/Device;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceSettingsFragment extends Fragment {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private ViewBinding binding;
   private Device device;

   // $FF: synthetic method
   public static void $r8$lambda$DAFvHywhgA_kz_YxUicD7gWNkUc(DeviceSettingsFragment var0, View var1) {
      onCreateView$lambda$4$lambda$3(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$Fm91y2D1pe_4lAenphD__7gq03E(DeviceSettingsFragment var0, View var1) {
      onCreateView$lambda$2$lambda$1(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$v5kuEodwOp_b_unTFQp6w0DyjQs/* $FF was: $r8$lambda$v5kuEodwOp-b-unTFQp6w0DyjQs*/(DeviceSettingsFragment var0, View var1) {
      onCreateView$lambda$6$lambda$5(var0, var1);
   }

   private static final void onCreateView$gotoDeviceSettings(DeviceSettingsFragment var0) {
      Context var2 = var0.getContext();
      if (var2 != null) {
         DeviceSettingsActivity.Companion var3 = DeviceSettingsActivity.Companion;
         Device var1 = var0.device;
         Device var4 = var1;
         if (var1 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("device");
            var4 = null;
         }

         var3.launch(var2, var4);
      }

   }

   private static final void onCreateView$lambda$2$lambda$1(DeviceSettingsFragment var0, View var1) {
      onCreateView$gotoDeviceSettings(var0);
   }

   private static final void onCreateView$lambda$4$lambda$3(DeviceSettingsFragment var0, View var1) {
      onCreateView$gotoDeviceSettings(var0);
   }

   private static final void onCreateView$lambda$6$lambda$5(DeviceSettingsFragment var0, View var1) {
      onCreateView$gotoDeviceSettings(var0);
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      Intrinsics.checkNotNullParameter(var1, "inflater");
      var3 = this.getArguments();
      Object var5 = null;
      Device var12;
      if (var3 != null) {
         var12 = (Device)var3.getParcelable("device");
      } else {
         var12 = null;
      }

      if (var12 != null) {
         this.device = var12;
         Device var4 = var12;
         if (var12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("device");
            var4 = null;
         }

         ViewBinding var7;
         if (var4 instanceof DeviceNewClassic) {
            var7 = FragmentDeviceNSettingsBinding.inflate(var1, var2, false);
            var7.getRoot().setOnClickListener(new DeviceSettingsFragment$$ExternalSyntheticLambda0(this));
            Intrinsics.checkNotNullExpressionValue(var7, "apply(...)");
            var7 = var7;
         } else {
            var4 = this.device;
            var12 = var4;
            if (var4 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("device");
               var12 = null;
            }

            if (DeviceKt.isAfterG4(var12)) {
               var7 = FragmentDeviceHSettingsBinding.inflate(var1, var2, false);
               var7.btnSettings.setOnClickListener(new DeviceSettingsFragment$$ExternalSyntheticLambda1(this));
               Intrinsics.checkNotNullExpressionValue(var7, "apply(...)");
               var7 = var7;
            } else {
               var7 = FragmentDeviceSettingsBinding.inflate(var1, var2, false);
               var7.getRoot().setOnClickListener(new DeviceSettingsFragment$$ExternalSyntheticLambda2(this));
               Intrinsics.checkNotNullExpressionValue(var7, "apply(...)");
               var7 = var7;
            }
         }

         this.binding = var7;
         if (var7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var7 = (FragmentDeviceSettingsBinding)var5;
         }

         View var10 = var7.getRoot();
         Intrinsics.checkNotNullExpressionValue(var10, "getRoot(...)");
         return var10;
      } else {
         throw new IllegalStateException("Required value was null.".toString());
      }
   }

   @Metadata(
      d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"},
      d2 = {"Lcom/blueair/devicedetails/fragment/DeviceSettingsFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/fragment/DeviceSettingsFragment;", "device", "Lcom/blueair/core/model/Device;", "devicedetails_otherRelease"},
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

      public final DeviceSettingsFragment newInstance(Device var1) {
         Intrinsics.checkNotNullParameter(var1, "device");
         DeviceSettingsFragment var2 = new DeviceSettingsFragment();
         var2.setArguments(BundleKt.bundleOf(new Pair[]{TuplesKt.to("device", var1)}));
         return var2;
      }
   }
}
