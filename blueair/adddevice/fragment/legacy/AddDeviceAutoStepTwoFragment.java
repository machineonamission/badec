package com.blueair.adddevice.fragment.legacy;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import androidx.viewbinding.ViewBinding;
import com.blueair.adddevice.databinding.FragmentAddDeviceAutoStepOneBinding;
import com.blueair.adddevice.databinding.FragmentAddDeviceAutoStepTwoBinding;
import com.blueair.viewcore.R;
import com.blueair.viewcore.ViewUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0011\u001a\u00020\u0012H\u0016J$\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u001a\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001e\u001a\u00020\u001cH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000f¨\u0006 "},
   d2 = {"Lcom/blueair/adddevice/fragment/legacy/AddDeviceAutoStepTwoFragment;", "Lcom/blueair/adddevice/fragment/legacy/AddDeviceBaseFragment;", "<init>", "()V", "binding", "Landroidx/viewbinding/ViewBinding;", "stepOneBinding", "Lcom/blueair/adddevice/databinding/FragmentAddDeviceAutoStepOneBinding;", "getStepOneBinding", "()Lcom/blueair/adddevice/databinding/FragmentAddDeviceAutoStepOneBinding;", "stepOneBinding$delegate", "Lkotlin/Lazy;", "stepTwoBinding", "Lcom/blueair/adddevice/databinding/FragmentAddDeviceAutoStepTwoBinding;", "getStepTwoBinding", "()Lcom/blueair/adddevice/databinding/FragmentAddDeviceAutoStepTwoBinding;", "stepTwoBinding$delegate", "getRootView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onResume", "Companion", "adddevice_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class AddDeviceAutoStepTwoFragment extends AddDeviceBaseFragment {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private ViewBinding binding;
   private final Lazy stepOneBinding$delegate = LazyKt.lazy(new AddDeviceAutoStepTwoFragment$$ExternalSyntheticLambda1(this));
   private final Lazy stepTwoBinding$delegate = LazyKt.lazy(new AddDeviceAutoStepTwoFragment$$ExternalSyntheticLambda2(this));

   // $FF: synthetic method
   public static FragmentAddDeviceAutoStepOneBinding $r8$lambda$M6huBg1EebXMCoGDnNejHH7RkOU(AddDeviceAutoStepTwoFragment var0) {
      return stepOneBinding_delegate$lambda$0(var0);
   }

   // $FF: synthetic method
   public static void $r8$lambda$MPj_dw9bRcsGtDwY5tf0Z0U_aJo(AddDeviceAutoStepTwoFragment var0, View var1) {
      onCreateView$lambda$2(var0, var1);
   }

   // $FF: synthetic method
   public static FragmentAddDeviceAutoStepTwoBinding $r8$lambda$WDc5Lm5XIEEjYZ8nvTK_z_QKY3M/* $FF was: $r8$lambda$WDc5Lm5XIEEjYZ8nvTK-z-QKY3M*/(AddDeviceAutoStepTwoFragment var0) {
      return stepTwoBinding_delegate$lambda$1(var0);
   }

   private final FragmentAddDeviceAutoStepOneBinding getStepOneBinding() {
      return (FragmentAddDeviceAutoStepOneBinding)this.stepOneBinding$delegate.getValue();
   }

   private final FragmentAddDeviceAutoStepTwoBinding getStepTwoBinding() {
      return (FragmentAddDeviceAutoStepTwoBinding)this.stepTwoBinding$delegate.getValue();
   }

   private static final void onCreateView$lambda$2(AddDeviceAutoStepTwoFragment var0, View var1) {
      if (((CharSequence)var0.getAddService().getCurrentNetworkSSIDEstimate()).length() == 0) {
         ViewUtils var3 = ViewUtils.INSTANCE;
         FragmentActivity var2 = var0.requireActivity();
         Intrinsics.checkNotNullExpressionValue(var2, "requireActivity(...)");
         var3.showError((Activity)var2, R.string.error_connect_to_network);
      } else {
         var0.getAddService().autoStepCompleted();
      }
   }

   private static final FragmentAddDeviceAutoStepOneBinding stepOneBinding_delegate$lambda$0(AddDeviceAutoStepTwoFragment var0) {
      ViewBinding var1 = var0.binding;
      ViewBinding var2 = var1;
      if (var1 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var2 = null;
      }

      return (FragmentAddDeviceAutoStepOneBinding)var2;
   }

   private static final FragmentAddDeviceAutoStepTwoBinding stepTwoBinding_delegate$lambda$1(AddDeviceAutoStepTwoFragment var0) {
      ViewBinding var1 = var0.binding;
      ViewBinding var2 = var1;
      if (var1 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var2 = null;
      }

      return (FragmentAddDeviceAutoStepTwoBinding)var2;
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
         FragmentAddDeviceAutoStepTwoBinding var4 = FragmentAddDeviceAutoStepTwoBinding.inflate(var1, var2, false);
         Intrinsics.checkNotNull(var4);
         var5 = var4;
      } else {
         FragmentAddDeviceAutoStepOneBinding var6 = FragmentAddDeviceAutoStepOneBinding.inflate(var1, var2, false);
         Intrinsics.checkNotNull(var6);
         var5 = var6;
      }

      this.binding = var5;
      Object var12 = null;
      ViewBinding var10 = var5;
      if (var5 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var10 = null;
      }

      ((Button)var10.getRoot().findViewById(com.blueair.adddevice.R.id.buttonNext)).setOnClickListener(new AddDeviceAutoStepTwoFragment$$ExternalSyntheticLambda0(this));
      var10 = this.binding;
      var5 = var10;
      if (var10 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var5 = null;
      }

      ((TextView)var5.getRoot().findViewById(com.blueair.adddevice.R.id.textAddDeviceSubtitle)).setText(R.string.add_device_classic_activate_wifi_subtitle);
      var5 = this.binding;
      if (var5 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var5 = (ViewBinding)var12;
      }

      View var9 = var5.getRoot();
      Intrinsics.checkNotNullExpressionValue(var9, "getRoot(...)");
      return var9;
   }

   public void onResume() {
      super.onResume();
      if (this.getDeviceModelType() == 3) {
         FragmentActivity var1 = this.getActivity();
         Intrinsics.checkNotNull(var1, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
         ActionBar var2 = ((AppCompatActivity)var1).getSupportActionBar();
         if (var2 != null) {
            var2.setTitle((CharSequence)this.getString(R.string.activate_wifi));
         }
      }

   }

   public void onViewCreated(View var1, Bundle var2) {
      Intrinsics.checkNotNullParameter(var1, "view");
      super.onViewCreated(var1, var2);
      int var3 = this.getDeviceModelType();
      if (var3 != 1) {
         if (var3 == 2) {
            this.getStepOneBinding().textAddDeviceSubtitle.setText(R.string.sense_step2);
            this.getStepOneBinding().imageAuto.setImageDrawable(this.getResources().getDrawable(com.blueair.adddevice.R.drawable.device_sense_step2));
            return;
         }

         if (var3 == 3) {
            this.getStepTwoBinding().textAddDeviceSubtitle.setText(R.string.add_device_classic_activate_wifi_subtitle);
            return;
         }
      } else {
         this.getStepOneBinding().textAddDeviceSubtitle.setText(R.string.aware_step2);
         AnimatedVectorDrawableCompat var4 = AnimatedVectorDrawableCompat.create(this.requireContext(), com.blueair.adddevice.R.drawable.device_aware_rotate_and_flash_blue);
         ((ImageView)var1.findViewById(com.blueair.adddevice.R.id.imageAuto)).setImageDrawable((Drawable)var4);
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
      }

   }

   @Metadata(
      d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"},
      d2 = {"Lcom/blueair/adddevice/fragment/legacy/AddDeviceAutoStepTwoFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/adddevice/fragment/legacy/AddDeviceAutoStepTwoFragment;", "deviceModelType", "", "adddevice_otherRelease"},
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

      public final AddDeviceAutoStepTwoFragment newInstance(int var1) {
         AddDeviceAutoStepTwoFragment var2 = new AddDeviceAutoStepTwoFragment();
         Bundle var3 = new Bundle();
         var3.putInt("deviceModelType", var1);
         var2.setArguments(var3);
         return var2;
      }
   }
}
