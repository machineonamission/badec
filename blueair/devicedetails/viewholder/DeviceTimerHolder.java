package com.blueair.devicedetails.viewholder;

import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.airbnb.lottie.LottieAnimationView;
import com.blueair.core.model.CoolSubMode;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceFanTable;
import com.blueair.core.model.HasTimer;
import com.blueair.core.model.TimerState;
import com.blueair.devicedetails.databinding.HolderDeviceTimerBinding;
import com.blueair.viewcore.R;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u00162\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0016B1\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0015H\u0003R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"},
   d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceTimerHolder;", "Lcom/blueair/devicedetails/viewholder/DeviceControlHolder;", "Lcom/blueair/devicedetails/databinding/HolderDeviceTimerBinding;", "binding", "onStateSetListener", "Lkotlin/Function1;", "Lcom/blueair/core/model/TimerState;", "", "onClickDurationListener", "Lkotlin/Function0;", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceTimerBinding;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "liveDevice", "Lcom/blueair/core/model/HasTimer;", "update", "device", "Lcom/blueair/core/model/Device;", "forceOffline", "", "hydrateTime", "leftSeconds", "", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceTimerHolder extends DeviceControlHolder {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private HasTimer liveDevice;
   private final Function0 onClickDurationListener;
   private final Function1 onStateSetListener;

   // $FF: synthetic method
   public static void $r8$lambda$5K0WDSH6Ag3EAdPYu_nwAlGhqBo/* $FF was: $r8$lambda$5K0WDSH6Ag3EAdPYu-nwAlGhqBo*/(DeviceTimerHolder var0, View var1) {
      _init_$lambda$1(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$Du9Nomcpm7Ga6OHOT7pnK0erNLw(DeviceTimerHolder var0, View var1) {
      _init_$lambda$3(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$kAtQ_aHCsLj5DPSQpCPXKyZ_TfU/* $FF was: $r8$lambda$kAtQ-aHCsLj5DPSQpCPXKyZ_TfU*/(DeviceTimerHolder var0, View var1) {
      _init_$lambda$2(var0, var1);
   }

   public DeviceTimerHolder(HolderDeviceTimerBinding var1, Function1 var2, Function0 var3) {
      Intrinsics.checkNotNullParameter(var1, "binding");
      Intrinsics.checkNotNullParameter(var2, "onStateSetListener");
      Intrinsics.checkNotNullParameter(var3, "onClickDurationListener");
      super(var1);
      this.onStateSetListener = var2;
      this.onClickDurationListener = var3;
      var1.ivSwitch.setOnClickListener(new DeviceTimerHolder$$ExternalSyntheticLambda0(this));
      var1.tvTimer.setOnClickListener(new DeviceTimerHolder$$ExternalSyntheticLambda1(this));
      var1.ivClose.setOnClickListener(new DeviceTimerHolder$$ExternalSyntheticLambda2(this));
   }

   private static final void _init_$lambda$1(DeviceTimerHolder var0, View var1) {
      HasTimer var3 = var0.liveDevice;
      if (var3 != null) {
         TimerState var4 = var3.timerStatus();
         int var2 = DeviceTimerHolder.WhenMappings.$EnumSwitchMapping$0[var4.ordinal()];
         if (var2 != 1 && var2 != 2) {
            if (var2 != 3) {
               var0.onStateSetListener.invoke(TimerState.START);
               return;
            }

            var0.onStateSetListener.invoke(TimerState.RESUME);
            return;
         }

         var0.onStateSetListener.invoke(TimerState.STOP);
      }

   }

   private static final void _init_$lambda$2(DeviceTimerHolder var0, View var1) {
      var0.onClickDurationListener.invoke();
   }

   private static final void _init_$lambda$3(DeviceTimerHolder var0, View var1) {
      var0.onStateSetListener.invoke(TimerState.COMPLETED);
   }

   private final void hydrateTime(int var1) {
      int var3 = var1 / 3600;
      int var4 = (int)Math.ceil((double)(var1 - var3 * 3600) / (double)60.0F);
      int var2 = var3;
      var1 = var4;
      if (var4 > 59) {
         var2 = var3 + 1;
         var1 = 0;
      }

      AppCompatTextView var6 = ((HolderDeviceTimerBinding)this.getBinding()).tvTimer;
      String var5 = String.format("%02d:%02d", Arrays.copyOf(new Object[]{var2, var1}, 2));
      Intrinsics.checkNotNullExpressionValue(var5, "format(...)");
      var6.setText((CharSequence)var5);
   }

   public void update(Device var1, boolean var2) {
      Intrinsics.checkNotNullParameter(var1, "device");
      if (var1 instanceof HasTimer) {
         HasTimer var5 = (HasTimer)var1;
         this.liveDevice = var5;
         boolean var3;
         if (var1 instanceof DeviceFanTable && ((DeviceFanTable)var1).isInSubMode(CoolSubMode.NIGHT)) {
            var3 = 1;
         } else {
            var3 = 0;
         }

         HolderDeviceTimerBinding var8 = (HolderDeviceTimerBinding)this.getBinding();
         if (var3) {
            var8.getRoot().setBackgroundResource(R.color.surface_dark_5);
            var8.leadingIcon.setImageTintList(ColorStateList.valueOf(this.getColor(R.color.surface_dark_45)));
            var8.title.setTextColor(this.getColor(R.color.surface_dark_55));
            var8.tvTimer.setBackgroundResource(R.drawable.rounded_rectangle_dark_5_r8);
            var8.ivSwitch.setEnabled(false);
         } else {
            var8.getRoot().setBackgroundResource(R.color.white);
            var8.leadingIcon.setImageTintList((ColorStateList)null);
            var8.title.setTextColor(this.getColor(R.color.colorPrimaryText));
            var8.tvTimer.setBackgroundResource(R.drawable.rounded_rectangle_misty_grey_r8);
            var8.ivSwitch.setEnabled(true);
         }

         TimerState var7 = var5.timerStatus();
         if (DeviceTimerHolder.WhenMappings.$EnumSwitchMapping$0[var7.ordinal()] == 4) {
            var8 = (HolderDeviceTimerBinding)this.getBinding();
            AppCompatImageView var17 = var8.ivClose;
            Intrinsics.checkNotNullExpressionValue(var17, "ivClose");
            ViewExtensionsKt.hide((View)var17);
            var8.lavProgress.cancelAnimation();
            LottieAnimationView var18 = var8.lavProgress;
            Intrinsics.checkNotNullExpressionValue(var18, "lavProgress");
            ViewExtensionsKt.hide((View)var18);
            ImageView var19 = var8.ivSwitch;
            int var15;
            if (var3) {
               var15 = R.drawable.ic_control_start_dark;
            } else {
               var15 = R.drawable.ic_control_start;
            }

            var19.setImageResource(var15);
            var8.tvTimer.setEnabled((boolean)(var3 ^ true));
            this.hydrateTime(var5.getTimerDuration());
         } else {
            var8 = (HolderDeviceTimerBinding)this.getBinding();
            if (var3) {
               var8.ivClose.setImageResource(R.drawable.ic_close_dark_contained);
               var8.ivClose.setEnabled(false);
            } else {
               var8.ivClose.setImageResource(R.drawable.ic_close_white_contained);
               var8.ivClose.setEnabled(true);
            }

            AppCompatImageView var6 = var8.ivClose;
            Intrinsics.checkNotNullExpressionValue(var6, "ivClose");
            ViewExtensionsKt.show$default((View)var6, false, 1, (Object)null);
            var8.tvTimer.setEnabled(false);
            if (var7 == TimerState.STOP) {
               ((HolderDeviceTimerBinding)this.getBinding()).lavProgress.cancelAnimation();
               LottieAnimationView var16 = ((HolderDeviceTimerBinding)this.getBinding()).lavProgress;
               Intrinsics.checkNotNullExpressionValue(var16, "lavProgress");
               ViewExtensionsKt.hide((View)var16);
               ImageView var10 = var8.ivSwitch;
               if (var3) {
                  var3 = R.drawable.ic_control_start_dark;
               } else {
                  var3 = R.drawable.ic_control_start;
               }

               var10.setImageResource(var3);
            } else {
               if (!((HolderDeviceTimerBinding)this.getBinding()).lavProgress.isAnimating() && !var3) {
                  ((HolderDeviceTimerBinding)this.getBinding()).lavProgress.playAnimation();
               }

               ImageView var11 = var8.ivSwitch;
               int var4;
               if (var3) {
                  var4 = R.drawable.ic_control_pause_dark;
               } else {
                  var4 = R.drawable.ic_control_pause;
               }

               var11.setImageResource(var4);
               LottieAnimationView var12 = ((HolderDeviceTimerBinding)this.getBinding()).lavProgress;
               Intrinsics.checkNotNullExpressionValue(var12, "lavProgress");
               ViewExtensionsKt.show((View)var12, (boolean)(var3 ^ true));
            }

            this.hydrateTime(var5.getLeftSeconds());
         }
      }
   }

   @Metadata(
      d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J0\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r¨\u0006\u000e"},
      d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceTimerHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceTimerHolder;", "parentView", "Landroid/view/ViewGroup;", "onStateSetListener", "Lkotlin/Function1;", "Lcom/blueair/core/model/TimerState;", "", "onClickDurationListener", "Lkotlin/Function0;", "devicedetails_otherRelease"},
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

      public final DeviceTimerHolder newInstance(ViewGroup var1, Function1 var2, Function0 var3) {
         Intrinsics.checkNotNullParameter(var1, "parentView");
         Intrinsics.checkNotNullParameter(var2, "onStateSetListener");
         Intrinsics.checkNotNullParameter(var3, "onClickDurationListener");
         HolderDeviceTimerBinding var4 = HolderDeviceTimerBinding.inflate(LayoutInflater.from(var1.getContext()), var1, false);
         Intrinsics.checkNotNullExpressionValue(var4, "inflate(...)");
         return new DeviceTimerHolder(var4, var2, var3);
      }
   }

   // $FF: synthetic class
   @Metadata(
      k = 3,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class WhenMappings {
      public static final int[] $EnumSwitchMapping$0;

      static {
         int[] var0 = new int[TimerState.values().length];

         try {
            var0[TimerState.START.ordinal()] = 1;
         } catch (NoSuchFieldError var5) {
         }

         try {
            var0[TimerState.RESUME.ordinal()] = 2;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[TimerState.STOP.ordinal()] = 3;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[TimerState.COMPLETED.ordinal()] = 4;
         } catch (NoSuchFieldError var2) {
         }

         $EnumSwitchMapping$0 = var0;
      }
   }
}
