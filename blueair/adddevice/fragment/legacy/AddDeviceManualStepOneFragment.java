package com.blueair.adddevice.fragment.legacy;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import androidx.viewbinding.ViewBinding;
import com.blueair.adddevice.databinding.FragmentAddDeviceManualStepOneBinding;
import com.blueair.adddevice.databinding.FragmentAddDeviceManualStepOneClassicBinding;
import com.blueair.viewcore.R;
import com.google.android.material.button.MaterialButton;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0011\u001a\u00020\u0012H\u0016J$\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u001a\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001e\u001a\u00020\u001cH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000f¨\u0006 "},
   d2 = {"Lcom/blueair/adddevice/fragment/legacy/AddDeviceManualStepOneFragment;", "Lcom/blueair/adddevice/fragment/legacy/AddDeviceBaseFragment;", "<init>", "()V", "binding", "Landroidx/viewbinding/ViewBinding;", "classicBinding", "Lcom/blueair/adddevice/databinding/FragmentAddDeviceManualStepOneClassicBinding;", "getClassicBinding", "()Lcom/blueair/adddevice/databinding/FragmentAddDeviceManualStepOneClassicBinding;", "classicBinding$delegate", "Lkotlin/Lazy;", "otherBinding", "Lcom/blueair/adddevice/databinding/FragmentAddDeviceManualStepOneBinding;", "getOtherBinding", "()Lcom/blueair/adddevice/databinding/FragmentAddDeviceManualStepOneBinding;", "otherBinding$delegate", "getRootView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onResume", "Companion", "adddevice_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class AddDeviceManualStepOneFragment extends AddDeviceBaseFragment {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private ViewBinding binding;
   private final Lazy classicBinding$delegate = LazyKt.lazy(new AddDeviceManualStepOneFragment$$ExternalSyntheticLambda0(this));
   private final Lazy otherBinding$delegate = LazyKt.lazy(new AddDeviceManualStepOneFragment$$ExternalSyntheticLambda1(this));

   // $FF: synthetic method
   public static void $r8$lambda$FF0v9gqt6EZErbfpnVBNYQL32Vg(AddDeviceManualStepOneFragment var0, View var1) {
      onViewCreated$lambda$2(var0, var1);
   }

   // $FF: synthetic method
   public static FragmentAddDeviceManualStepOneClassicBinding $r8$lambda$RIGwjaU_l_0JBu0sVHI6vNUTHNQ/* $FF was: $r8$lambda$RIGwjaU_l-0JBu0sVHI6vNUTHNQ*/(AddDeviceManualStepOneFragment var0) {
      return classicBinding_delegate$lambda$0(var0);
   }

   // $FF: synthetic method
   public static FragmentAddDeviceManualStepOneBinding $r8$lambda$WI_i1VIEqAyz_qT5vKIRmzn4dKg(AddDeviceManualStepOneFragment var0) {
      return otherBinding_delegate$lambda$1(var0);
   }

   private static final FragmentAddDeviceManualStepOneClassicBinding classicBinding_delegate$lambda$0(AddDeviceManualStepOneFragment var0) {
      ViewBinding var1 = var0.binding;
      ViewBinding var2 = var1;
      if (var1 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var2 = null;
      }

      return (FragmentAddDeviceManualStepOneClassicBinding)var2;
   }

   private final FragmentAddDeviceManualStepOneClassicBinding getClassicBinding() {
      return (FragmentAddDeviceManualStepOneClassicBinding)this.classicBinding$delegate.getValue();
   }

   private final FragmentAddDeviceManualStepOneBinding getOtherBinding() {
      return (FragmentAddDeviceManualStepOneBinding)this.otherBinding$delegate.getValue();
   }

   private static final void onViewCreated$lambda$2(AddDeviceManualStepOneFragment var0, View var1) {
      var0.getAddService().manualStepCompleted();
   }

   private static final FragmentAddDeviceManualStepOneBinding otherBinding_delegate$lambda$1(AddDeviceManualStepOneFragment var0) {
      ViewBinding var1 = var0.binding;
      ViewBinding var2 = var1;
      if (var1 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var2 = null;
      }

      return (FragmentAddDeviceManualStepOneBinding)var2;
   }

   public ConstraintLayout getRootView() {
      ViewBinding var2 = this.binding;
      ViewBinding var1 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var1 = null;
      }

      View var3 = var1.getRoot();
      Intrinsics.checkNotNull(var3, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
      return (ConstraintLayout)var3;
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      Intrinsics.checkNotNullParameter(var1, "inflater");
      ViewBinding var5;
      if (this.getDeviceModelType() == 3) {
         FragmentAddDeviceManualStepOneClassicBinding var4 = FragmentAddDeviceManualStepOneClassicBinding.inflate(var1, var2, false);
         Intrinsics.checkNotNull(var4);
         var5 = var4;
      } else {
         FragmentAddDeviceManualStepOneBinding var6 = FragmentAddDeviceManualStepOneBinding.inflate(var1, var2, false);
         Intrinsics.checkNotNull(var6);
         var5 = var6;
      }

      this.binding = var5;
      ViewBinding var8 = var5;
      if (var5 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var8 = null;
      }

      View var7 = var8.getRoot();
      Intrinsics.checkNotNullExpressionValue(var7, "getRoot(...)");
      return var7;
   }

   public void onResume() {
      super.onResume();
      if (this.getDeviceModelType() == 3) {
         FragmentActivity var1 = this.getActivity();
         Intrinsics.checkNotNull(var1, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
         ActionBar var2 = ((AppCompatActivity)var1).getSupportActionBar();
         if (var2 != null) {
            var2.setTitle((CharSequence)this.getString(R.string.manual_configuration));
         }
      }

   }

   public void onViewCreated(View var1, Bundle var2) {
      Intrinsics.checkNotNullParameter(var1, "view");
      super.onViewCreated(var1, var2);
      int var3 = this.getDeviceModelType();
      if (var3 != 1) {
         if (var3 == 2) {
            this.getOtherBinding().imageAuto.setImageDrawable(this.getResources().getDrawable(com.blueair.adddevice.R.drawable.device_sense_step2));
            this.getOtherBinding().textAddDeviceSubtitle.setText(R.string.sense_manual_subtitle);
         }
      } else {
         this.getOtherBinding().textAddDeviceSubtitle.setText(R.string.aware_manual_subtitle);
         AnimatedVectorDrawableCompat var4 = AnimatedVectorDrawableCompat.create(this.requireContext(), com.blueair.adddevice.R.drawable.device_aware_rotate_and_flash_orange);
         this.getOtherBinding().imageAuto.setImageDrawable((Drawable)var4);
         if (var4 != null) {
            var4.start();
         }

         if (var4 != null) {
            var4.registerAnimationCallback(new Animatable2Compat.AnimationCallback(var4) {
               final AnimatedVectorDrawableCompat $avd;

               {
                  this.$avd = var1;
               }

               public void onAnimationEnd(Drawable var1) {
                  Intrinsics.checkNotNullParameter(var1, "drawable");
                  this.$avd.start();
               }
            });
         }
      }

      var3 = this.getDeviceModelType();
      MaterialButton var5;
      if (var3 != 1 && var3 != 2) {
         if (var3 != 3) {
            var5 = null;
         } else {
            var5 = this.getClassicBinding().buttonNext;
         }
      } else {
         var5 = this.getOtherBinding().buttonNext;
      }

      if (var5 != null) {
         var5.setOnClickListener(new AddDeviceManualStepOneFragment$$ExternalSyntheticLambda2(this));
      }

   }

   @Metadata(
      d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"},
      d2 = {"Lcom/blueair/adddevice/fragment/legacy/AddDeviceManualStepOneFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/adddevice/fragment/legacy/AddDeviceManualStepOneFragment;", "deviceModelType", "", "adddevice_otherRelease"},
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

      public final AddDeviceManualStepOneFragment newInstance(int var1) {
         AddDeviceManualStepOneFragment var2 = new AddDeviceManualStepOneFragment();
         Bundle var3 = new Bundle();
         var3.putInt("deviceModelType", var1);
         var2.setArguments(var3);
         return var2;
      }
   }
}
