package com.blueair.adddevice.fragment.legacy;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import androidx.viewbinding.ViewBinding;
import com.blueair.adddevice.databinding.FragmentAwareFailOneBinding;
import com.blueair.adddevice.databinding.FragmentClassicFailRingBinding;
import com.blueair.adddevice.databinding.FragmentSenseFailRingBinding;
import com.blueair.viewcore.R;
import com.blueair.viewcore.ViewUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 (2\u00020\u0001:\u0002()B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J$\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u001a\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u001a2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010$\u001a\u00020\"H\u0002J\u0010\u0010%\u001a\u00020\"2\u0006\u0010&\u001a\u00020'H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"},
   d2 = {"Lcom/blueair/adddevice/fragment/legacy/AddDeviceAutoConfigurationFailedStepOne;", "Lcom/blueair/adddevice/fragment/legacy/AddDeviceBaseFragment;", "<init>", "()V", "binding", "Landroidx/viewbinding/ViewBinding;", "classicBinding", "Lcom/blueair/adddevice/databinding/FragmentClassicFailRingBinding;", "getClassicBinding", "()Lcom/blueair/adddevice/databinding/FragmentClassicFailRingBinding;", "classicBinding$delegate", "Lkotlin/Lazy;", "senseBinding", "Lcom/blueair/adddevice/databinding/FragmentSenseFailRingBinding;", "getSenseBinding", "()Lcom/blueair/adddevice/databinding/FragmentSenseFailRingBinding;", "senseBinding$delegate", "awareBinding", "Lcom/blueair/adddevice/databinding/FragmentAwareFailOneBinding;", "getAwareBinding", "()Lcom/blueair/adddevice/databinding/FragmentAwareFailOneBinding;", "awareBinding$delegate", "rootViewForProgress", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getRootView", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "handleNextClick", "updateNextButton", "deviceModelType", "", "Companion", "onRadioButtonChanged", "adddevice_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class AddDeviceAutoConfigurationFailedStepOne extends AddDeviceBaseFragment {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final Lazy awareBinding$delegate = LazyKt.lazy(new AddDeviceAutoConfigurationFailedStepOne$$ExternalSyntheticLambda5(this));
   private ViewBinding binding;
   private final Lazy classicBinding$delegate = LazyKt.lazy(new AddDeviceAutoConfigurationFailedStepOne$$ExternalSyntheticLambda3(this));
   private ConstraintLayout rootViewForProgress;
   private final Lazy senseBinding$delegate = LazyKt.lazy(new AddDeviceAutoConfigurationFailedStepOne$$ExternalSyntheticLambda4(this));

   // $FF: synthetic method
   public static void $r8$lambda$_4Ok7CLEOKtzhR2Zl9nPvLC1tE4/* $FF was: $r8$lambda$-4Ok7CLEOKtzhR2Zl9nPvLC1tE4*/(AddDeviceAutoConfigurationFailedStepOne var0, View var1) {
      onViewCreated$lambda$10(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$7Y_axkmrfZDBHBGxVrnGfhqJt20(AddDeviceAutoConfigurationFailedStepOne var0, View var1) {
      onViewCreated$lambda$6(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$83G1g3vP_BfpKOICbGH4LoQM_xY/* $FF was: $r8$lambda$83G1g3vP-BfpKOICbGH4LoQM-xY*/(AddDeviceAutoConfigurationFailedStepOne var0, View var1) {
      onViewCreated$lambda$14(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$8UTszBQve4jd3uDyYEBGC28eQxw(AddDeviceAutoConfigurationFailedStepOne var0, View var1) {
      onViewCreated$lambda$11(var0, var1);
   }

   // $FF: synthetic method
   public static FragmentClassicFailRingBinding $r8$lambda$BUBYxAz5eDoxrOjdVhfJaYm0JQI(AddDeviceAutoConfigurationFailedStepOne var0) {
      return classicBinding_delegate$lambda$0(var0);
   }

   // $FF: synthetic method
   public static void $r8$lambda$JudcuSNxhcL48QBVk1KpIh_R6XQ/* $FF was: $r8$lambda$JudcuSNxhcL48QBVk1KpIh-R6XQ*/(AddDeviceAutoConfigurationFailedStepOne var0, View var1) {
      onViewCreated$lambda$12(var0, var1);
   }

   // $FF: synthetic method
   public static FragmentSenseFailRingBinding $r8$lambda$O15C25YcNBcr8UzQpqQzo4dPCUk(AddDeviceAutoConfigurationFailedStepOne var0) {
      return senseBinding_delegate$lambda$1(var0);
   }

   // $FF: synthetic method
   public static void $r8$lambda$OoIRX1vEDBDXCfTJsstbDcUOp98(AddDeviceAutoConfigurationFailedStepOne var0, View var1) {
      onViewCreated$lambda$9(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$TuUiFb8D173iYvEIOSYQUZt_33w(AddDeviceAutoConfigurationFailedStepOne var0, View var1) {
      onViewCreated$lambda$7(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$VA76LixfKDCZXXmNckBJFfdIUgw(AddDeviceAutoConfigurationFailedStepOne var0, View var1) {
      onViewCreated$lambda$13(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$YVi7PxUdW4OQ9ezDevuO3xVxjRY(AddDeviceAutoConfigurationFailedStepOne var0, View var1) {
      onViewCreated$lambda$5(var0, var1);
   }

   // $FF: synthetic method
   public static FragmentAwareFailOneBinding $r8$lambda$grpzP1i2ta_zlcXKvKKz_edbBD8(AddDeviceAutoConfigurationFailedStepOne var0) {
      return awareBinding_delegate$lambda$2(var0);
   }

   // $FF: synthetic method
   public static void $r8$lambda$ifmQWx_RrWbyUozN9SqhKurgXZM/* $FF was: $r8$lambda$ifmQWx-RrWbyUozN9SqhKurgXZM*/(AddDeviceAutoConfigurationFailedStepOne var0, View var1) {
      onViewCreated$lambda$8(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$kNjGu93GFrgCX2NySgnyZ_ibQec/* $FF was: $r8$lambda$kNjGu93GFrgCX2NySgnyZ-ibQec*/(AddDeviceAutoConfigurationFailedStepOne var0, View var1) {
      onViewCreated$lambda$3(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$xT64PHVxttNGj0_1C3nZbheu4pE/* $FF was: $r8$lambda$xT64PHVxttNGj0-1C3nZbheu4pE*/(AddDeviceAutoConfigurationFailedStepOne var0, View var1) {
      onViewCreated$lambda$4(var0, var1);
   }

   private static final FragmentAwareFailOneBinding awareBinding_delegate$lambda$2(AddDeviceAutoConfigurationFailedStepOne var0) {
      ViewBinding var1 = var0.binding;
      ViewBinding var2 = var1;
      if (var1 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var2 = null;
      }

      return (FragmentAwareFailOneBinding)var2;
   }

   private static final FragmentClassicFailRingBinding classicBinding_delegate$lambda$0(AddDeviceAutoConfigurationFailedStepOne var0) {
      ViewBinding var1 = var0.binding;
      ViewBinding var2 = var1;
      if (var1 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var2 = null;
      }

      return (FragmentClassicFailRingBinding)var2;
   }

   private final FragmentAwareFailOneBinding getAwareBinding() {
      return (FragmentAwareFailOneBinding)this.awareBinding$delegate.getValue();
   }

   private final FragmentClassicFailRingBinding getClassicBinding() {
      return (FragmentClassicFailRingBinding)this.classicBinding$delegate.getValue();
   }

   private final FragmentSenseFailRingBinding getSenseBinding() {
      return (FragmentSenseFailRingBinding)this.senseBinding$delegate.getValue();
   }

   private final void handleNextClick() {
      Timber.Forest.d("handleNextClick()", new Object[0]);
      int var1 = this.getDeviceModelType();
      if (var1 != 1) {
         if (var1 != 2) {
            if (var1 == 3) {
               if (this.getClassicBinding().radioBtnFailRingSolidClassic.isChecked()) {
                  Timber.Forest.d("handleNextClick() -> addService.autoFailStepCompleted()", new Object[0]);
                  this.getAddService().autoFailStepCompleted();
                  return;
               }

               if (this.getClassicBinding().radioBtnFailRingFlashingClassic.isChecked() || this.getClassicBinding().radioBtnFailWifiSolidClassic.isChecked()) {
                  Timber.Forest.d("handleNextClick() -> addService.recommendResetDevice()", new Object[0]);
                  this.getAddService().recommendResetDevice();
                  return;
               }

               Timber.Forest.w("handleNextClick() -> no option selected", new Object[0]);
               FragmentActivity var2 = this.getActivity();
               if (var2 != null) {
                  ViewUtils.INSTANCE.showError((Activity)var2, R.string.error_select_option);
                  return;
               }
            }
         } else {
            if (this.getSenseBinding().radioBtnRingSolidWifiFlashingSense.isChecked()) {
               Timber.Forest.d("handleNextClick() -> addService.startManualConfig()", new Object[0]);
               this.getAddService().autoFailStepCompleted();
               return;
            }

            if (this.getSenseBinding().radioBtnRingWifiFadingSense.isChecked() || this.getSenseBinding().radioBtnRingWifiSolidSense.isChecked()) {
               Timber.Forest.d("handleNextClick() -> addService.recommendResetDevice()", new Object[0]);
               this.getAddService().recommendResetDevice();
               return;
            }

            Timber.Forest.w("handleNextClick() -> no option selected", new Object[0]);
            FragmentActivity var3 = this.getActivity();
            if (var3 != null) {
               ViewUtils.INSTANCE.showError((Activity)var3, R.string.error_select_option);
               return;
            }
         }
      } else {
         if (this.getAwareBinding().radioBtnFailFadingAware.isChecked()) {
            Timber.Forest.d("handleNextClick() -> addService.startManualConfig()", new Object[0]);
            this.getAddService().recommendResetDevice();
            return;
         }

         if (this.getAwareBinding().radioBtnFailSolidAware.isChecked()) {
            Timber.Forest.d("handleNextClick() -> addService.recommendResetDevice()", new Object[0]);
            this.getAddService().recommendResetDevice();
            return;
         }

         if (this.getAwareBinding().radioBtnFailFlashingAware.isChecked()) {
            Timber.Forest.d("handleNextClick() -> addService.autoFailStepCompleted()", new Object[0]);
            this.getAddService().autoFailStepCompleted();
            return;
         }

         Timber.Forest.w("handleNextClick() -> no option selected", new Object[0]);
         FragmentActivity var4 = this.getActivity();
         if (var4 != null) {
            ViewUtils.INSTANCE.showError((Activity)var4, R.string.error_select_option);
         }
      }

   }

   private static final void onViewCreated$lambda$10(AddDeviceAutoConfigurationFailedStepOne var0, View var1) {
      var0.handleNextClick();
   }

   private static final void onViewCreated$lambda$11(AddDeviceAutoConfigurationFailedStepOne var0, View var1) {
      var0.getAwareBinding().radioBtnFailFlashingAware.setChecked(true);
   }

   private static final void onViewCreated$lambda$12(AddDeviceAutoConfigurationFailedStepOne var0, View var1) {
      var0.getAwareBinding().radioBtnFailFadingAware.setChecked(true);
   }

   private static final void onViewCreated$lambda$13(AddDeviceAutoConfigurationFailedStepOne var0, View var1) {
      var0.getAwareBinding().radioBtnFailSolidAware.setChecked(true);
   }

   private static final void onViewCreated$lambda$14(AddDeviceAutoConfigurationFailedStepOne var0, View var1) {
      var0.handleNextClick();
   }

   private static final void onViewCreated$lambda$3(AddDeviceAutoConfigurationFailedStepOne var0, View var1) {
      var0.getClassicBinding().radioBtnFailRingSolidClassic.setChecked(true);
   }

   private static final void onViewCreated$lambda$4(AddDeviceAutoConfigurationFailedStepOne var0, View var1) {
      var0.getClassicBinding().radioBtnFailRingFlashingClassic.setChecked(true);
   }

   private static final void onViewCreated$lambda$5(AddDeviceAutoConfigurationFailedStepOne var0, View var1) {
      var0.getClassicBinding().radioBtnFailWifiSolidClassic.setChecked(true);
   }

   private static final void onViewCreated$lambda$6(AddDeviceAutoConfigurationFailedStepOne var0, View var1) {
      var0.handleNextClick();
   }

   private static final void onViewCreated$lambda$7(AddDeviceAutoConfigurationFailedStepOne var0, View var1) {
      var0.getSenseBinding().radioBtnRingSolidWifiFlashingSense.setChecked(true);
   }

   private static final void onViewCreated$lambda$8(AddDeviceAutoConfigurationFailedStepOne var0, View var1) {
      var0.getSenseBinding().radioBtnRingWifiFadingSense.setChecked(true);
   }

   private static final void onViewCreated$lambda$9(AddDeviceAutoConfigurationFailedStepOne var0, View var1) {
      var0.getSenseBinding().radioBtnRingWifiSolidSense.setChecked(true);
   }

   private static final FragmentSenseFailRingBinding senseBinding_delegate$lambda$1(AddDeviceAutoConfigurationFailedStepOne var0) {
      ViewBinding var1 = var0.binding;
      ViewBinding var2 = var1;
      if (var1 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var2 = null;
      }

      return (FragmentSenseFailRingBinding)var2;
   }

   private final void updateNextButton(int var1) {
      if (var1 != 1) {
         if (var1 != 2) {
            if (var1 == 3) {
               this.getClassicBinding().buttonNextClassic.setEnabled(true);
               this.getClassicBinding().buttonNextClassic.setText((CharSequence)this.getResources().getString(R.string.button_next));
            }
         } else {
            this.getSenseBinding().buttonNextSense.setEnabled(true);
            this.getSenseBinding().buttonNextSense.setText((CharSequence)this.getResources().getString(R.string.button_next));
         }
      } else {
         this.getAwareBinding().buttonNextAware.setEnabled(true);
         this.getAwareBinding().buttonNextAware.setText((CharSequence)this.getResources().getString(R.string.button_next));
      }
   }

   public ConstraintLayout getRootView() {
      return this.rootViewForProgress;
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      Intrinsics.checkNotNullParameter(var1, "inflater");
      int var4 = this.getDeviceModelType();
      if (var4 != 1) {
         if (var4 != 2) {
            if (var4 == 3) {
               FragmentClassicFailRingBinding var5 = FragmentClassicFailRingBinding.inflate(var1, var2, false);
               Intrinsics.checkNotNullExpressionValue(var5, "inflate(...)");
               this.binding = var5;
            }
         } else {
            FragmentSenseFailRingBinding var6 = FragmentSenseFailRingBinding.inflate(var1, var2, false);
            Intrinsics.checkNotNullExpressionValue(var6, "inflate(...)");
            this.binding = var6;
         }
      } else {
         FragmentAwareFailOneBinding var7 = FragmentAwareFailOneBinding.inflate(var1, var2, false);
         Intrinsics.checkNotNullExpressionValue(var7, "inflate(...)");
         this.binding = var7;
      }

      ViewBinding var12 = this.binding;
      Object var11 = null;
      ViewBinding var8 = var12;
      if (var12 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var8 = null;
      }

      this.rootViewForProgress = (ConstraintLayout)var8.getRoot().findViewById(com.blueair.adddevice.R.id.rootLayout);
      var8 = this.binding;
      if (var8 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var8 = (ViewBinding)var11;
      }

      View var10 = var8.getRoot();
      Intrinsics.checkNotNullExpressionValue(var10, "getRoot(...)");
      return var10;
   }

   public void onViewCreated(View var1, Bundle var2) {
      Intrinsics.checkNotNullParameter(var1, "view");
      super.onViewCreated(var1, var2);
      int var3 = this.getDeviceModelType();
      if (var3 != 1) {
         if (var3 != 2) {
            if (var3 == 3) {
               Drawable var8 = this.getClassicBinding().imageFailRingFlashingClassic.getDrawable();
               Intrinsics.checkNotNull(var8, "null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
               ((AnimationDrawable)var8).start();
               this.getClassicBinding().radioBtnFailRingSolidClassic.setOnCheckedChangeListener(new onRadioButtonChanged());
               this.getClassicBinding().radioBtnFailRingFlashingClassic.setOnCheckedChangeListener(new onRadioButtonChanged());
               this.getClassicBinding().radioBtnFailWifiSolidClassic.setOnCheckedChangeListener(new onRadioButtonChanged());
               this.getClassicBinding().imageFailSolidRingClassic.setOnClickListener(new AddDeviceAutoConfigurationFailedStepOne$$ExternalSyntheticLambda0(this));
               this.getClassicBinding().imageFailRingFlashingClassic.setOnClickListener(new AddDeviceAutoConfigurationFailedStepOne$$ExternalSyntheticLambda8(this));
               this.getClassicBinding().imageFailRingFadedClassic.setOnClickListener(new AddDeviceAutoConfigurationFailedStepOne$$ExternalSyntheticLambda9(this));
               this.getClassicBinding().buttonNextClassic.setOnClickListener(new AddDeviceAutoConfigurationFailedStepOne$$ExternalSyntheticLambda10(this));
            }
         } else {
            AnimatedVectorDrawableCompat var6 = AnimatedVectorDrawableCompat.create(this.requireContext(), com.blueair.adddevice.R.drawable.sense_ring_solid_wifi_blinking);
            this.getSenseBinding().imageFailRingSolidWifiFlashingSense.setImageDrawable((Drawable)var6);
            if (var6 != null) {
               var6.start();
            }

            if (var6 != null) {
               var6.registerAnimationCallback(new Animatable2Compat.AnimationCallback(var6) {
                  final AnimatedVectorDrawableCompat $avdBlinkingWifi;

                  {
                     this.$avdBlinkingWifi = var1;
                  }

                  public void onAnimationEnd(Drawable var1) {
                     Intrinsics.checkNotNullParameter(var1, "drawable");
                     this.$avdBlinkingWifi.start();
                  }
               });
            }

            var6 = AnimatedVectorDrawableCompat.create(this.requireContext(), com.blueair.adddevice.R.drawable.sense_ring_wifi_fading);
            this.getSenseBinding().imageFailRingWifiFadingSense.setImageDrawable((Drawable)var6);
            if (var6 != null) {
               var6.start();
            }

            if (var6 != null) {
               var6.registerAnimationCallback(new Animatable2Compat.AnimationCallback(var6) {
                  final AnimatedVectorDrawableCompat $avdFading;

                  {
                     this.$avdFading = var1;
                  }

                  public void onAnimationEnd(Drawable var1) {
                     Intrinsics.checkNotNullParameter(var1, "drawable");
                     this.$avdFading.start();
                  }
               });
            }

            this.getSenseBinding().imageBackgroundOne.setOnClickListener(new AddDeviceAutoConfigurationFailedStepOne$$ExternalSyntheticLambda11(this));
            this.getSenseBinding().imageBackgroundTwo.setOnClickListener(new AddDeviceAutoConfigurationFailedStepOne$$ExternalSyntheticLambda12(this));
            this.getSenseBinding().imageBackgroundThree.setOnClickListener(new AddDeviceAutoConfigurationFailedStepOne$$ExternalSyntheticLambda13(this));
            this.getSenseBinding().radioBtnRingSolidWifiFlashingSense.setOnCheckedChangeListener(new onRadioButtonChanged());
            this.getSenseBinding().radioBtnRingWifiFadingSense.setOnCheckedChangeListener(new onRadioButtonChanged());
            this.getSenseBinding().radioBtnRingWifiSolidSense.setOnCheckedChangeListener(new onRadioButtonChanged());
            this.getSenseBinding().buttonNextSense.setOnClickListener(new AddDeviceAutoConfigurationFailedStepOne$$ExternalSyntheticLambda14(this));
         }
      } else {
         AnimatedVectorDrawableCompat var4 = AnimatedVectorDrawableCompat.create(this.requireContext(), com.blueair.adddevice.R.drawable.device_aware_flashing_blue);
         this.getAwareBinding().imageFailFlashingFastAware.setImageDrawable((Drawable)var4);
         if (var4 != null) {
            var4.start();
         }

         if (var4 != null) {
            var4.registerAnimationCallback(new Animatable2Compat.AnimationCallback(var4) {
               final AnimatedVectorDrawableCompat $avdFast;

               {
                  this.$avdFast = var1;
               }

               public void onAnimationEnd(Drawable var1) {
                  Intrinsics.checkNotNullParameter(var1, "drawable");
                  this.$avdFast.start();
               }
            });
         }

         var4 = AnimatedVectorDrawableCompat.create(this.requireContext(), com.blueair.adddevice.R.drawable.device_aware_pulsing_blue);
         this.getAwareBinding().imageFailFadingSlowAware.setImageDrawable((Drawable)var4);
         if (var4 != null) {
            var4.start();
         }

         if (var4 != null) {
            var4.registerAnimationCallback(new Animatable2Compat.AnimationCallback(var4) {
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

         this.getAwareBinding().radioBtnFailFlashingAware.setOnCheckedChangeListener(new onRadioButtonChanged());
         this.getAwareBinding().radioBtnFailFadingAware.setOnCheckedChangeListener(new onRadioButtonChanged());
         this.getAwareBinding().radioBtnFailSolidAware.setOnCheckedChangeListener(new onRadioButtonChanged());
         this.getAwareBinding().imageFailFlashingFastAware.setOnClickListener(new AddDeviceAutoConfigurationFailedStepOne$$ExternalSyntheticLambda1(this));
         this.getAwareBinding().imageFailFadingSlowAware.setOnClickListener(new AddDeviceAutoConfigurationFailedStepOne$$ExternalSyntheticLambda2(this));
         this.getAwareBinding().imageFailSolidAware.setOnClickListener(new AddDeviceAutoConfigurationFailedStepOne$$ExternalSyntheticLambda6(this));
         this.getAwareBinding().buttonNextAware.setOnClickListener(new AddDeviceAutoConfigurationFailedStepOne$$ExternalSyntheticLambda7(this));
      }
   }

   @Metadata(
      d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"},
      d2 = {"Lcom/blueair/adddevice/fragment/legacy/AddDeviceAutoConfigurationFailedStepOne$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/adddevice/fragment/legacy/AddDeviceAutoConfigurationFailedStepOne;", "deviceModelType", "", "adddevice_otherRelease"},
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

      public final AddDeviceAutoConfigurationFailedStepOne newInstance(int var1) {
         AddDeviceAutoConfigurationFailedStepOne var3 = new AddDeviceAutoConfigurationFailedStepOne();
         Bundle var2 = new Bundle();
         var2.putInt("deviceModelType", var1);
         var3.setArguments(var2);
         return var3;
      }
   }

   @Metadata(
      d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"},
      d2 = {"Lcom/blueair/adddevice/fragment/legacy/AddDeviceAutoConfigurationFailedStepOne$onRadioButtonChanged;", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "<init>", "(Lcom/blueair/adddevice/fragment/legacy/AddDeviceAutoConfigurationFailedStepOne;)V", "onCheckedChanged", "", "buttonView", "Landroid/widget/CompoundButton;", "isChecked", "", "adddevice_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   private final class onRadioButtonChanged implements CompoundButton.OnCheckedChangeListener {
      final AddDeviceAutoConfigurationFailedStepOne this$0;

      public onRadioButtonChanged() {
         this.this$0 = AddDeviceAutoConfigurationFailedStepOne.this;
      }

      public void onCheckedChanged(CompoundButton var1, boolean var2) {
         if (var2) {
            AddDeviceAutoConfigurationFailedStepOne var4 = this.this$0;
            var4.updateNextButton(var4.getDeviceModelType());
            Integer var5;
            if (var1 != null) {
               var5 = var1.getId();
            } else {
               var5 = null;
            }

            int var3 = com.blueair.adddevice.R.id.radioBtnFailRingFlashingClassic;
            if (var5 != null && var5 == var3) {
               this.this$0.getClassicBinding().radioBtnFailRingSolidClassic.setChecked(false);
               this.this$0.getClassicBinding().radioBtnFailWifiSolidClassic.setChecked(false);
               return;
            }

            var3 = com.blueair.adddevice.R.id.radioBtnFailRingSolidClassic;
            if (var5 != null && var5 == var3) {
               this.this$0.getClassicBinding().radioBtnFailRingFlashingClassic.setChecked(false);
               this.this$0.getClassicBinding().radioBtnFailWifiSolidClassic.setChecked(false);
               return;
            }

            var3 = com.blueair.adddevice.R.id.radioBtnFailWifiSolidClassic;
            if (var5 != null && var5 == var3) {
               this.this$0.getClassicBinding().radioBtnFailRingFlashingClassic.setChecked(false);
               this.this$0.getClassicBinding().radioBtnFailRingSolidClassic.setChecked(false);
               return;
            }

            var3 = com.blueair.adddevice.R.id.radioBtnRingWifiFadingSense;
            if (var5 != null && var5 == var3) {
               this.this$0.getSenseBinding().radioBtnRingSolidWifiFlashingSense.setChecked(false);
               this.this$0.getSenseBinding().radioBtnRingWifiSolidSense.setChecked(false);
               return;
            }

            var3 = com.blueair.adddevice.R.id.radioBtnRingSolidWifiFlashingSense;
            if (var5 != null && var5 == var3) {
               this.this$0.getSenseBinding().radioBtnRingWifiFadingSense.setChecked(false);
               this.this$0.getSenseBinding().radioBtnRingWifiSolidSense.setChecked(false);
               return;
            }

            var3 = com.blueair.adddevice.R.id.radioBtnRingWifiSolidSense;
            if (var5 != null && var5 == var3) {
               this.this$0.getSenseBinding().radioBtnRingWifiFadingSense.setChecked(false);
               this.this$0.getSenseBinding().radioBtnRingSolidWifiFlashingSense.setChecked(false);
               return;
            }

            var3 = com.blueair.adddevice.R.id.radioBtnFailFadingAware;
            if (var5 != null && var5 == var3) {
               this.this$0.getAwareBinding().radioBtnFailFlashingAware.setChecked(false);
               this.this$0.getAwareBinding().radioBtnFailSolidAware.setChecked(false);
               return;
            }

            var3 = com.blueair.adddevice.R.id.radioBtnFailFlashingAware;
            if (var5 != null && var5 == var3) {
               this.this$0.getAwareBinding().radioBtnFailFadingAware.setChecked(false);
               this.this$0.getAwareBinding().radioBtnFailSolidAware.setChecked(false);
               return;
            }

            var3 = com.blueair.adddevice.R.id.radioBtnFailSolidAware;
            if (var5 != null && var5 == var3) {
               this.this$0.getAwareBinding().radioBtnFailFadingAware.setChecked(false);
               this.this$0.getAwareBinding().radioBtnFailFlashingAware.setChecked(false);
            }
         }

      }
   }
}
