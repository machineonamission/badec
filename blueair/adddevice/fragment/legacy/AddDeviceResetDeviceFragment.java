package com.blueair.adddevice.fragment.legacy;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import com.blueair.adddevice.R;
import com.blueair.adddevice.databinding.FragmentAddDeviceResetClassicBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J&\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"},
   d2 = {"Lcom/blueair/adddevice/fragment/legacy/AddDeviceResetDeviceFragment;", "Lcom/blueair/adddevice/fragment/legacy/AddDeviceBaseFragment;", "<init>", "()V", "binding", "Lcom/blueair/adddevice/databinding/FragmentAddDeviceResetClassicBinding;", "getRootView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "Companion", "adddevice_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class AddDeviceResetDeviceFragment extends AddDeviceBaseFragment {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private FragmentAddDeviceResetClassicBinding binding;

   // $FF: synthetic method
   public static void $r8$lambda$c8BJILHHN0q3EAf3M4BSNOaPXHk(AddDeviceResetDeviceFragment var0, View var1) {
      onViewCreated$lambda$0(var0, var1);
   }

   private static final void onViewCreated$lambda$0(AddDeviceResetDeviceFragment var0, View var1) {
      var0.getAddService().startManualConfig();
   }

   public ConstraintLayout getRootView() {
      FragmentAddDeviceResetClassicBinding var1 = this.binding;
      return var1 != null ? var1.getRoot() : null;
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      Intrinsics.checkNotNullParameter(var1, "inflater");
      int var4 = this.getDeviceModelType();
      Object var7 = null;
      FragmentAddDeviceResetClassicBinding var5;
      if (var4 != 1 && var4 != 2 && var4 != 3) {
         var5 = null;
      } else {
         var5 = FragmentAddDeviceResetClassicBinding.inflate(var1, var2, false);
      }

      this.binding = var5;
      ConstraintLayout var6 = (ConstraintLayout)var7;
      if (var5 != null) {
         var6 = var5.getRoot();
      }

      return (View)var6;
   }

   public void onViewCreated(View var1, Bundle var2) {
      Intrinsics.checkNotNullParameter(var1, "view");
      super.onViewCreated(var1, var2);
      FragmentAddDeviceResetClassicBinding var5 = this.binding;
      if (var5 != null) {
         int var3 = this.getDeviceModelType();
         if (var3 != 1) {
            if (var3 != 2) {
               if (var3 == 3) {
                  var5.imageAuto.setImageDrawable(this.getResources().getDrawable(R.drawable.device_classic_step2));
               }
            } else {
               var5.imageAuto.setImageDrawable(this.getResources().getDrawable(R.drawable.device_sense_step2));
               var5.textAddDeviceSubtitle.setText(com.blueair.viewcore.R.string.sense_reset_turn_around);
            }
         } else {
            AnimatedVectorDrawableCompat var4 = AnimatedVectorDrawableCompat.create(this.requireContext(), R.drawable.device_aware_rotate_and_flash_blue);
            var5.imageAuto.setImageDrawable((Drawable)var4);
            if (var4 != null) {
               var4.start();
            }

            if (var4 != null) {
               var4.registerAnimationCallback(new Animatable2Compat.AnimationCallback(var4) {
                  final AnimatedVectorDrawableCompat $avdBlue;

                  {
                     this.$avdBlue = var1;
                  }

                  public void onAnimationEnd(Drawable var1) {
                     Intrinsics.checkNotNullParameter(var1, "drawable");
                     this.$avdBlue.start();
                  }
               });
            }

            var5.textAddDeviceSubtitle.setText(com.blueair.viewcore.R.string.aware_reset_turn_around);
         }

         var3 = this.getDeviceModelType();
         if (var3 == 1 || var3 == 2 || var3 == 3) {
            var5.buttonNext.setOnClickListener(new AddDeviceResetDeviceFragment$$ExternalSyntheticLambda0(this));
            return;
         }
      }

   }

   @Metadata(
      d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"},
      d2 = {"Lcom/blueair/adddevice/fragment/legacy/AddDeviceResetDeviceFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/adddevice/fragment/legacy/AddDeviceResetDeviceFragment;", "deviceModelType", "", "adddevice_otherRelease"},
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

      public final AddDeviceResetDeviceFragment newInstance(int var1) {
         AddDeviceResetDeviceFragment var3 = new AddDeviceResetDeviceFragment();
         Bundle var2 = new Bundle();
         var2.putInt("deviceModelType", var1);
         var3.setArguments(var2);
         return var3;
      }
   }
}
