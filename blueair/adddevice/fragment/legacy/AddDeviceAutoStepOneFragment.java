package com.blueair.adddevice.fragment.legacy;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import com.blueair.adddevice.databinding.FragmentAddDeviceAutoStepOneBinding;
import com.blueair.viewcore.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J$\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0014"},
   d2 = {"Lcom/blueair/adddevice/fragment/legacy/AddDeviceAutoStepOneFragment;", "Lcom/blueair/adddevice/fragment/legacy/AddDeviceBaseFragment;", "<init>", "()V", "binding", "Lcom/blueair/adddevice/databinding/FragmentAddDeviceAutoStepOneBinding;", "getRootView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "Companion", "adddevice_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class AddDeviceAutoStepOneFragment extends AddDeviceBaseFragment {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private FragmentAddDeviceAutoStepOneBinding binding;

   // $FF: synthetic method
   public static void $r8$lambda$sHa2d2RwJhajW0Ip1TuPUyU1EMQ(AddDeviceAutoStepOneFragment var0, View var1) {
      onCreateView$lambda$0(var0, var1);
   }

   private static final void onCreateView$lambda$0(AddDeviceAutoStepOneFragment var0, View var1) {
      var0.getAddService().autoStepCompleted();
   }

   public ConstraintLayout getRootView() {
      FragmentAddDeviceAutoStepOneBinding var2 = this.binding;
      FragmentAddDeviceAutoStepOneBinding var1 = var2;
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
      FragmentAddDeviceAutoStepOneBinding var8 = FragmentAddDeviceAutoStepOneBinding.inflate(var1, var2, false);
      Intrinsics.checkNotNullExpressionValue(var8, "inflate(...)");
      this.binding = var8;
      Object var7 = null;
      FragmentAddDeviceAutoStepOneBinding var4 = var8;
      if (var8 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var4 = null;
      }

      var4.buttonNext.setOnClickListener(new AddDeviceAutoStepOneFragment$$ExternalSyntheticLambda0(this));
      var4 = this.binding;
      if (var4 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var4 = (FragmentAddDeviceAutoStepOneBinding)var7;
      }

      ConstraintLayout var6 = var4.getRoot();
      Intrinsics.checkNotNullExpressionValue(var6, "getRoot(...)");
      return (View)var6;
   }

   public void onViewCreated(View var1, Bundle var2) {
      Intrinsics.checkNotNullParameter(var1, "view");
      super.onViewCreated(var1, var2);
      int var3 = this.getDeviceModelType();
      Object var4 = null;
      Object var9 = null;
      if (var3 != 1) {
         if (var3 == 2) {
            FragmentAddDeviceAutoStepOneBinding var11 = this.binding;
            FragmentAddDeviceAutoStepOneBinding var7 = var11;
            if (var11 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("binding");
               var7 = null;
            }

            var7.textAddDeviceSubtitle.setText(R.string.sense_step1);
            AnimatedVectorDrawableCompat var12 = AnimatedVectorDrawableCompat.create(this.requireContext(), com.blueair.adddevice.R.drawable.device_sense_step1_animated);
            var7 = this.binding;
            if (var7 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("binding");
               var7 = (FragmentAddDeviceAutoStepOneBinding)var9;
            }

            var7.imageAuto.setImageDrawable((Drawable)var12);
            if (var12 != null) {
               var12.start();
            }

            if (var12 != null) {
               var12.registerAnimationCallback(new Animatable2Compat.AnimationCallback(var12) {
                  final AnimatedVectorDrawableCompat $avdSlow;

                  {
                     this.$avdSlow = var1;
                  }

                  public void onAnimationEnd(Drawable var1) {
                     Intrinsics.checkNotNullParameter(var1, "drawable");
                     this.$avdSlow.start();
                  }
               });
            }
         }

      } else {
         FragmentAddDeviceAutoStepOneBinding var10 = this.binding;
         FragmentAddDeviceAutoStepOneBinding var5 = var10;
         if (var10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var5 = null;
         }

         var5.textAddDeviceSubtitle.setText(R.string.aware_step1);
         var5 = this.binding;
         if (var5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var5 = (FragmentAddDeviceAutoStepOneBinding)var4;
         }

         var5.imageAuto.setImageDrawable(this.getResources().getDrawable(com.blueair.adddevice.R.drawable.device_aware_step1));
      }
   }

   @Metadata(
      d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"},
      d2 = {"Lcom/blueair/adddevice/fragment/legacy/AddDeviceAutoStepOneFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/adddevice/fragment/legacy/AddDeviceAutoStepOneFragment;", "deviceModelType", "", "adddevice_otherRelease"},
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

      public final AddDeviceAutoStepOneFragment newInstance(int var1) {
         AddDeviceAutoStepOneFragment var3 = new AddDeviceAutoStepOneFragment();
         Bundle var2 = new Bundle();
         var2.putInt("deviceModelType", var1);
         var3.setArguments(var2);
         return var3;
      }
   }
}
