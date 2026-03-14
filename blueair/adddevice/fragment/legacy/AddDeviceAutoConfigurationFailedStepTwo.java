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
import com.blueair.adddevice.databinding.FragmentAwareFailTwoBinding;
import com.blueair.adddevice.databinding.FragmentClassicFailWifiBinding;
import com.blueair.adddevice.databinding.FragmentSenseFailWifiBinding;
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
   d2 = {"Lcom/blueair/adddevice/fragment/legacy/AddDeviceAutoConfigurationFailedStepTwo;", "Lcom/blueair/adddevice/fragment/legacy/AddDeviceBaseFragment;", "<init>", "()V", "binding", "Landroidx/viewbinding/ViewBinding;", "classicBinding", "Lcom/blueair/adddevice/databinding/FragmentClassicFailWifiBinding;", "getClassicBinding", "()Lcom/blueair/adddevice/databinding/FragmentClassicFailWifiBinding;", "classicBinding$delegate", "Lkotlin/Lazy;", "senseBinding", "Lcom/blueair/adddevice/databinding/FragmentSenseFailWifiBinding;", "getSenseBinding", "()Lcom/blueair/adddevice/databinding/FragmentSenseFailWifiBinding;", "senseBinding$delegate", "awareBinding", "Lcom/blueair/adddevice/databinding/FragmentAwareFailTwoBinding;", "getAwareBinding", "()Lcom/blueair/adddevice/databinding/FragmentAwareFailTwoBinding;", "awareBinding$delegate", "rootViewForProgress", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getRootView", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "handleNextClick", "updateNextButton", "deviceModelType", "", "Companion", "onRadioButtonChanged", "adddevice_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class AddDeviceAutoConfigurationFailedStepTwo extends AddDeviceBaseFragment {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final Lazy awareBinding$delegate = LazyKt.lazy(new AddDeviceAutoConfigurationFailedStepTwo$$ExternalSyntheticLambda7(this));
   private ViewBinding binding;
   private final Lazy classicBinding$delegate = LazyKt.lazy(new AddDeviceAutoConfigurationFailedStepTwo$$ExternalSyntheticLambda5(this));
   private ConstraintLayout rootViewForProgress;
   private final Lazy senseBinding$delegate = LazyKt.lazy(new AddDeviceAutoConfigurationFailedStepTwo$$ExternalSyntheticLambda6(this));

   // $FF: synthetic method
   public static void $r8$lambda$CgVfWxCN7ab8VB0BmQEHU_wvViQ(AddDeviceAutoConfigurationFailedStepTwo var0, View var1) {
      onViewCreated$lambda$6(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$OwnJlOee9kIw4PZoS9oBeL4k72g(AddDeviceAutoConfigurationFailedStepTwo var0, View var1) {
      onViewCreated$lambda$3(var0, var1);
   }

   // $FF: synthetic method
   public static FragmentClassicFailWifiBinding $r8$lambda$P3JyiuIMnY0RHfS9vmuPOW42Ggg(AddDeviceAutoConfigurationFailedStepTwo var0) {
      return classicBinding_delegate$lambda$0(var0);
   }

   // $FF: synthetic method
   public static void $r8$lambda$bCwKPWEceagTnqYZXgkTvRVhGr4(AddDeviceAutoConfigurationFailedStepTwo var0, View var1) {
      onViewCreated$lambda$7(var0, var1);
   }

   // $FF: synthetic method
   public static FragmentSenseFailWifiBinding $r8$lambda$bp9GcROw5y2AFJTl_Q1l5Xr4Naw(AddDeviceAutoConfigurationFailedStepTwo var0) {
      return senseBinding_delegate$lambda$1(var0);
   }

   // $FF: synthetic method
   public static void $r8$lambda$fkh2NP3eBoNjs6fN4w_SGy6tvmc(AddDeviceAutoConfigurationFailedStepTwo var0, View var1) {
      onViewCreated$lambda$5(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$n8J1RQFzTQnjpGDWoE8jbV_k7bc(AddDeviceAutoConfigurationFailedStepTwo var0, View var1) {
      onViewCreated$lambda$4(var0, var1);
   }

   // $FF: synthetic method
   public static FragmentAwareFailTwoBinding $r8$lambda$zI5IkO1qvJGBENQ4KXXsDDpdabc(AddDeviceAutoConfigurationFailedStepTwo var0) {
      return awareBinding_delegate$lambda$2(var0);
   }

   private static final FragmentAwareFailTwoBinding awareBinding_delegate$lambda$2(AddDeviceAutoConfigurationFailedStepTwo var0) {
      ViewBinding var1 = var0.binding;
      ViewBinding var2 = var1;
      if (var1 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var2 = null;
      }

      return (FragmentAwareFailTwoBinding)var2;
   }

   private static final FragmentClassicFailWifiBinding classicBinding_delegate$lambda$0(AddDeviceAutoConfigurationFailedStepTwo var0) {
      ViewBinding var1 = var0.binding;
      ViewBinding var2 = var1;
      if (var1 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var2 = null;
      }

      return (FragmentClassicFailWifiBinding)var2;
   }

   private final FragmentAwareFailTwoBinding getAwareBinding() {
      return (FragmentAwareFailTwoBinding)this.awareBinding$delegate.getValue();
   }

   private final FragmentClassicFailWifiBinding getClassicBinding() {
      return (FragmentClassicFailWifiBinding)this.classicBinding$delegate.getValue();
   }

   private final FragmentSenseFailWifiBinding getSenseBinding() {
      return (FragmentSenseFailWifiBinding)this.senseBinding$delegate.getValue();
   }

   private final void handleNextClick() {
      Timber.Forest.d("handleNextClick()", new Object[0]);
      int var1 = this.getDeviceModelType();
      if (var1 != 1) {
         if (var1 != 2) {
            if (var1 == 3) {
               if (this.getClassicBinding().radioBtnFailFlashFaster.isChecked()) {
                  Timber.Forest.d("handleNextClick() -> addService.startManualConfig()", new Object[0]);
                  this.getAddService().startManualConfig();
                  return;
               }

               if (this.getClassicBinding().radioBtnFailFlashSlower.isChecked()) {
                  Timber.Forest.d("handleNextClick() -> addService.startManualStepTwo()", new Object[0]);
                  this.getAddService().startManualStepTwo();
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
            if (this.getSenseBinding().radioBtnWifiFlashingSense.isChecked()) {
               Timber.Forest.d("handleNextClick() -> addService.startManualConfig()", new Object[0]);
               this.getAddService().startManualConfig();
               return;
            }

            if (this.getSenseBinding().radioBtnWifiPulsingSense.isChecked()) {
               Timber.Forest.d("handleNextClick() -> addService.startManualStepTwo()", new Object[0]);
               this.getAddService().startManualStepTwo();
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
         if (this.getAwareBinding().radioBtnBlueFlash.isChecked()) {
            Timber.Forest.d("handleNextClick() -> addService.startManualConfig()", new Object[0]);
            this.getAddService().startManualConfig();
            return;
         }

         if (this.getAwareBinding().radioBtnOrangeFlash.isChecked()) {
            Timber.Forest.d("handleNextClick() -> addService.startManualStepTwo()", new Object[0]);
            this.getAddService().startManualStepTwo();
            return;
         }

         Timber.Forest.w("handleNextClick() -> no option selected", new Object[0]);
         FragmentActivity var4 = this.getActivity();
         if (var4 != null) {
            ViewUtils.INSTANCE.showError((Activity)var4, R.string.error_select_option);
         }
      }

   }

   private static final void onViewCreated$lambda$3(AddDeviceAutoConfigurationFailedStepTwo var0, View var1) {
      var0.handleNextClick();
   }

   private static final void onViewCreated$lambda$4(AddDeviceAutoConfigurationFailedStepTwo var0, View var1) {
      var0.getSenseBinding().radioBtnWifiFlashingSense.setChecked(true);
   }

   private static final void onViewCreated$lambda$5(AddDeviceAutoConfigurationFailedStepTwo var0, View var1) {
      var0.getSenseBinding().radioBtnWifiPulsingSense.setChecked(true);
   }

   private static final void onViewCreated$lambda$6(AddDeviceAutoConfigurationFailedStepTwo var0, View var1) {
      var0.handleNextClick();
   }

   private static final void onViewCreated$lambda$7(AddDeviceAutoConfigurationFailedStepTwo var0, View var1) {
      var0.handleNextClick();
   }

   private static final FragmentSenseFailWifiBinding senseBinding_delegate$lambda$1(AddDeviceAutoConfigurationFailedStepTwo var0) {
      ViewBinding var1 = var0.binding;
      ViewBinding var2 = var1;
      if (var1 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var2 = null;
      }

      return (FragmentSenseFailWifiBinding)var2;
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
               FragmentClassicFailWifiBinding var5 = FragmentClassicFailWifiBinding.inflate(var1, var2, false);
               Intrinsics.checkNotNullExpressionValue(var5, "inflate(...)");
               this.binding = var5;
            }
         } else {
            FragmentSenseFailWifiBinding var6 = FragmentSenseFailWifiBinding.inflate(var1, var2, false);
            Intrinsics.checkNotNullExpressionValue(var6, "inflate(...)");
            this.binding = var6;
         }
      } else {
         FragmentAwareFailTwoBinding var7 = FragmentAwareFailTwoBinding.inflate(var1, var2, false);
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
               this.getClassicBinding().buttonNextClassic.setOnClickListener(new AddDeviceAutoConfigurationFailedStepTwo$$ExternalSyntheticLambda0(this));
               Drawable var8 = this.getClassicBinding().imageFailFlashingFaster.getDrawable();
               Intrinsics.checkNotNull(var8, "null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
               ((AnimationDrawable)var8).start();
               var8 = this.getClassicBinding().imageFailFlashingSlower.getDrawable();
               Intrinsics.checkNotNull(var8, "null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
               AnimationDrawable var10 = (AnimationDrawable)var8;
               var10.setEnterFadeDuration(2000);
               var10.setExitFadeDuration(2000);
               var10.start();
               this.getClassicBinding().radioBtnFailFlashSlower.setOnCheckedChangeListener(new onRadioButtonChanged());
               this.getClassicBinding().radioBtnFailFlashFaster.setOnCheckedChangeListener(new onRadioButtonChanged());
            }
         } else {
            AnimatedVectorDrawableCompat var6 = AnimatedVectorDrawableCompat.create(this.requireContext(), com.blueair.adddevice.R.drawable.sense_ring_solid_wifi_blinking);
            this.getSenseBinding().imageFailFlashingFasterSense.setImageDrawable((Drawable)var6);
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

            var6 = AnimatedVectorDrawableCompat.create(this.requireContext(), com.blueair.adddevice.R.drawable.sense_ring_solid_wifi_fading);
            this.getSenseBinding().imageFailFlashingSlowerSense.setImageDrawable((Drawable)var6);
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

            this.getSenseBinding().imageBackgroundOne.setOnClickListener(new AddDeviceAutoConfigurationFailedStepTwo$$ExternalSyntheticLambda1(this));
            this.getSenseBinding().imageBackgroundTwo.setOnClickListener(new AddDeviceAutoConfigurationFailedStepTwo$$ExternalSyntheticLambda2(this));
            this.getSenseBinding().radioBtnWifiFlashingSense.setOnCheckedChangeListener(new onRadioButtonChanged());
            this.getSenseBinding().radioBtnWifiPulsingSense.setOnCheckedChangeListener(new onRadioButtonChanged());
            this.getSenseBinding().buttonNextSense.setOnClickListener(new AddDeviceAutoConfigurationFailedStepTwo$$ExternalSyntheticLambda3(this));
         }
      } else {
         AnimatedVectorDrawableCompat var4 = AnimatedVectorDrawableCompat.create(this.requireContext(), com.blueair.adddevice.R.drawable.device_aware_flashing_blue);
         this.getAwareBinding().imageFailBlueFlash.setImageDrawable((Drawable)var4);
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

         var4 = AnimatedVectorDrawableCompat.create(this.requireContext(), com.blueair.adddevice.R.drawable.device_aware_flashing_orange);
         this.getAwareBinding().imageFailOrangeFlash.setImageDrawable((Drawable)var4);
         if (var4 != null) {
            var4.start();
         }

         if (var4 != null) {
            var4.registerAnimationCallback(new Animatable2Compat.AnimationCallback(var4) {
               final AnimatedVectorDrawableCompat $avdOrange;

               {
                  this.$avdOrange = var1;
               }

               public void onAnimationEnd(Drawable var1) {
                  Intrinsics.checkNotNullParameter(var1, "drawable");
                  this.$avdOrange.start();
               }
            });
         }

         this.getAwareBinding().radioBtnBlueFlash.setOnCheckedChangeListener(new onRadioButtonChanged());
         this.getAwareBinding().radioBtnOrangeFlash.setOnCheckedChangeListener(new onRadioButtonChanged());
         this.getAwareBinding().buttonNextAware.setOnClickListener(new AddDeviceAutoConfigurationFailedStepTwo$$ExternalSyntheticLambda4(this));
      }
   }

   @Metadata(
      d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"},
      d2 = {"Lcom/blueair/adddevice/fragment/legacy/AddDeviceAutoConfigurationFailedStepTwo$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/adddevice/fragment/legacy/AddDeviceAutoConfigurationFailedStepTwo;", "deviceModelType", "", "adddevice_otherRelease"},
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

      public final AddDeviceAutoConfigurationFailedStepTwo newInstance(int var1) {
         AddDeviceAutoConfigurationFailedStepTwo var2 = new AddDeviceAutoConfigurationFailedStepTwo();
         Bundle var3 = new Bundle();
         var3.putInt("deviceModelType", var1);
         var2.setArguments(var3);
         return var2;
      }
   }

   @Metadata(
      d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"},
      d2 = {"Lcom/blueair/adddevice/fragment/legacy/AddDeviceAutoConfigurationFailedStepTwo$onRadioButtonChanged;", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "<init>", "(Lcom/blueair/adddevice/fragment/legacy/AddDeviceAutoConfigurationFailedStepTwo;)V", "onCheckedChanged", "", "buttonView", "Landroid/widget/CompoundButton;", "isChecked", "", "adddevice_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   private final class onRadioButtonChanged implements CompoundButton.OnCheckedChangeListener {
      final AddDeviceAutoConfigurationFailedStepTwo this$0;

      public onRadioButtonChanged() {
         this.this$0 = AddDeviceAutoConfigurationFailedStepTwo.this;
      }

      public void onCheckedChanged(CompoundButton var1, boolean var2) {
         if (var2) {
            AddDeviceAutoConfigurationFailedStepTwo var4 = this.this$0;
            var4.updateNextButton(var4.getDeviceModelType());
            Integer var5;
            if (var1 != null) {
               var5 = var1.getId();
            } else {
               var5 = null;
            }

            int var3 = com.blueair.adddevice.R.id.radioBtnFailFlashFaster;
            if (var5 != null && var5 == var3) {
               this.this$0.getClassicBinding().radioBtnFailFlashSlower.setChecked(false);
               return;
            }

            var3 = com.blueair.adddevice.R.id.radioBtnFailFlashSlower;
            if (var5 != null && var5 == var3) {
               this.this$0.getClassicBinding().radioBtnFailFlashFaster.setChecked(false);
               return;
            }

            var3 = com.blueair.adddevice.R.id.radioBtnWifiPulsingSense;
            if (var5 != null && var5 == var3) {
               this.this$0.getSenseBinding().radioBtnWifiFlashingSense.setChecked(false);
               return;
            }

            var3 = com.blueair.adddevice.R.id.radioBtnWifiFlashingSense;
            if (var5 != null && var5 == var3) {
               this.this$0.getSenseBinding().radioBtnWifiPulsingSense.setChecked(false);
               return;
            }

            var3 = com.blueair.adddevice.R.id.radioBtnBlueFlash;
            if (var5 != null && var5 == var3) {
               this.this$0.getAwareBinding().radioBtnOrangeFlash.setChecked(false);
               return;
            }

            var3 = com.blueair.adddevice.R.id.radioBtnOrangeFlash;
            if (var5 != null && var5 == var3) {
               this.this$0.getAwareBinding().radioBtnBlueFlash.setChecked(false);
            }
         }

      }
   }
}
