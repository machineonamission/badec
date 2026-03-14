package com.blueair.devicedetails.viewholder;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceIcp;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.FanSpeedEnum;
import com.blueair.core.model.HasFanSpeed;
import com.blueair.core.util.BasicTwoWayBindingThrottle;
import com.blueair.devicedetails.databinding.HolderDeviceManualModeBinding;
import com.blueair.devicedetails.util.FanSpeedUtils;
import com.blueair.viewcore.R;
import com.blueair.viewcore.view.AccessibleSeekBar;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 +2\u00020\u0001:\u0001+B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u001aH\u0002J\u0018\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u001aH\u0002J\u0010\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J<\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\u00152\u0006\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u00152\b\b\u0002\u0010#\u001a\u00020\u00152\b\b\u0002\u0010$\u001a\u00020\u0015H\u0002J\u0018\u0010%\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u001a2\u0006\u0010&\u001a\u00020\u0015H\u0002J\u0010\u0010'\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u0006H\u0002J\u0018\u0010(\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u001a2\u0006\u0010&\u001a\u00020\u0015H\u0002J\u0010\u0010)\u001a\u00020*2\u0006\u0010&\u001a\u00020\u0015H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006,"},
   d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceManualModeHolder;", "Lcom/blueair/devicedetails/viewholder/DeviceAttributeHolder;", "binding", "Lcom/blueair/devicedetails/databinding/HolderDeviceManualModeBinding;", "onFanSpeedSetListener", "Lkotlin/Function1;", "Lcom/blueair/core/model/FanSpeedEnum;", "", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceManualModeBinding;Lkotlin/jvm/functions/Function1;)V", "getBinding", "()Lcom/blueair/devicedetails/databinding/HolderDeviceManualModeBinding;", "getOnFanSpeedSetListener", "()Lkotlin/jvm/functions/Function1;", "twbThrottle", "Lcom/blueair/core/util/BasicTwoWayBindingThrottle;", "getTwbThrottle", "()Lcom/blueair/core/util/BasicTwoWayBindingThrottle;", "twbThrottle$delegate", "Lkotlin/Lazy;", "lastProgress", "", "update", "device", "Lcom/blueair/core/model/Device;", "onProgressSet", "Lcom/blueair/core/model/HasFanSpeed;", "publishValue", "fanSpeedEnum", "updateGermShield", "updateProgressTextTint", "fan0TintRes", "fan1TintRes", "fan2TintRes", "fan3TintRes", "fan2IcpRes", "fan3BlueRes", "getProgressAfterSnap", "progress", "tintFanSpeed", "tintSnapSteps", "isSlidingRight", "", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceManualModeHolder extends DeviceAttributeHolder {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   public static final int STEP_LESS_INTERVAL = 33;
   public static final int STEP_LESS_INTERVAL_ICP = 50;
   private final HolderDeviceManualModeBinding binding;
   private int lastProgress;
   private final Function1 onFanSpeedSetListener;
   private final Lazy twbThrottle$delegate;

   // $FF: synthetic method
   public static void $r8$lambda$KAds7jqKXUaCWePNPd7x94zTwRE(DeviceManualModeHolder var0, Device var1, View var2) {
      update$lambda$7(var0, var1, var2);
   }

   // $FF: synthetic method
   public static BasicTwoWayBindingThrottle $r8$lambda$PCjRBUg6NpSLcxsr8AYu_bVjypQ() {
      return twbThrottle_delegate$lambda$0();
   }

   // $FF: synthetic method
   public static void $r8$lambda$srg4ZkXFbt6i3DiH6iO2ZXyEq68(DeviceManualModeHolder var0, Device var1, View var2) {
      update$lambda$4(var0, var1, var2);
   }

   public DeviceManualModeHolder(HolderDeviceManualModeBinding var1, Function1 var2) {
      Intrinsics.checkNotNullParameter(var1, "binding");
      Intrinsics.checkNotNullParameter(var2, "onFanSpeedSetListener");
      ConstraintLayout var3 = var1.getRoot();
      Intrinsics.checkNotNullExpressionValue(var3, "getRoot(...)");
      super((View)var3);
      this.binding = var1;
      this.onFanSpeedSetListener = var2;
      this.twbThrottle$delegate = LazyKt.lazy(new DeviceManualModeHolder$$ExternalSyntheticLambda0());
      Drawable var4 = var1.fanSpeedSeekbar.getProgressDrawable();
      LayerDrawable var5;
      if (var4 instanceof LayerDrawable) {
         var5 = (LayerDrawable)var4;
      } else {
         var5 = null;
      }

      if (var5 != null) {
         Drawable var6 = var5.findDrawableByLayerId(16908301);
         if (var6 != null) {
            var6 = var6.mutate();
            if (var6 != null) {
               var6.setTint(ContextCompat.getColor(this.itemView.getContext(), R.color.colorPrimary));
            }
         }
      }

   }

   private final int getProgressAfterSnap(HasFanSpeed var1, int var2) {
      if (var1.getHasGear4()) {
         return this.isSlidingRight(var2) ? 25 : 0;
      } else if (DeviceKt.isG4orB4orNB(var1)) {
         return this.isSlidingRight(var2) ? 33 : 0;
      } else if (var1 instanceof DeviceIcp) {
         if (76 <= var2 && var2 < 101) {
            return 100;
         } else {
            return 26 <= var2 && var2 < 76 ? 50 : 0;
         }
      } else if (1 <= var2 && var2 < 33) {
         return this.isSlidingRight(var2) ? 33 : 0;
      } else if (34 <= var2 && var2 < 66) {
         return this.isSlidingRight(var2) ? 66 : 33;
      } else if (67 <= var2 && var2 < 99) {
         return this.isSlidingRight(var2) ? 99 : 66;
      } else {
         return 0;
      }
   }

   private final BasicTwoWayBindingThrottle getTwbThrottle() {
      return (BasicTwoWayBindingThrottle)this.twbThrottle$delegate.getValue();
   }

   private final boolean isSlidingRight(int var1) {
      return this.lastProgress < var1;
   }

   private final void onProgressSet(HasFanSpeed var1) {
      int var2 = this.binding.fanSpeedSeekbar.getProgress();
      Timber.Forest var4 = Timber.Forest;
      StringBuilder var3 = new StringBuilder("onStopTrackingTouch = ");
      var3.append(var2);
      var4.d(var3.toString(), new Object[0]);
      FanSpeedEnum var5;
      if (var1.getHasGear4()) {
         var5 = FanSpeedEnum.Companion.fanSpeedEnumFromProgressBluePremium(FanSpeedUtils.INSTANCE.getBluePremiumFromSeekBarProgress(var2));
      } else if (DeviceKt.isG4orB4orNB(var1)) {
         var5 = FanSpeedEnum.Companion.fanSpeedEnumFromProgressG4(FanSpeedUtils.INSTANCE.getG4FanSpeedFromSeekBarProgress(var2));
      } else if (var1 instanceof DeviceIcp) {
         var5 = FanSpeedEnum.Companion.fanSpeedEnumFromProgressIcp(FanSpeedUtils.INSTANCE.getIcpSpeedFromSeekBarProgress(var2));
      } else {
         var5 = FanSpeedEnum.Companion.fanSpeedEnumFromProgressLegacy(FanSpeedUtils.INSTANCE.getLegacySpeedFromSeekBarProgress(var2));
      }

      if (var5 == FanSpeedEnum.SNAP_STEP) {
         this.binding.fanSpeedSeekbar.setProgress(this.getProgressAfterSnap(var1, var2));
      } else {
         this.tintFanSpeed(var5);
         this.lastProgress = this.binding.fanSpeedSeekbar.getProgress();
         Timber.Forest.d("onStopTrackingTouch: publish", new Object[0]);
         this.publishValue(var5, var1);
      }
   }

   private final void publishValue(FanSpeedEnum var1, HasFanSpeed var2) {
      this.getTwbThrottle().notifyUpdateSent();
      this.updateGermShield(var2);
      this.onFanSpeedSetListener.invoke(var1);
   }

   private final void tintFanSpeed(FanSpeedEnum var1) {
      switch (DeviceManualModeHolder.WhenMappings.$EnumSwitchMapping$0[var1.ordinal()]) {
         case 1:
            updateProgressTextTint$default(this, R.color.navy_blue, R.color.dimgray, R.color.dimgray, R.color.dimgray, R.color.dimgray, 0, 32, (Object)null);
            return;
         case 2:
         case 3:
         case 4:
         case 5:
         case 6:
         case 7:
         case 8:
         case 9:
            updateProgressTextTint$default(this, R.color.navy_blue, R.color.navy_blue, R.color.dimgray, R.color.dimgray, R.color.dimgray, 0, 32, (Object)null);
            return;
         case 10:
         case 11:
         case 12:
         case 13:
            updateProgressTextTint$default(this, R.color.navy_blue, R.color.navy_blue, R.color.dimgray, R.color.dimgray, R.color.navy_blue, 0, 32, (Object)null);
            return;
         case 14:
         case 15:
         case 16:
         case 17:
         case 18:
            this.updateProgressTextTint(R.color.navy_blue, R.color.navy_blue, R.color.navy_blue, R.color.dimgray, R.color.navy_blue, R.color.dimgray);
            return;
         case 19:
         case 20:
         case 21:
         case 22:
         case 23:
         case 24:
         case 25:
            this.updateProgressTextTint(R.color.navy_blue, R.color.navy_blue, R.color.navy_blue, R.color.dimgray, R.color.navy_blue, R.color.navy_blue);
            return;
         case 26:
         case 27:
            this.updateProgressTextTint(R.color.navy_blue, R.color.navy_blue, R.color.navy_blue, R.color.navy_blue, R.color.navy_blue, R.color.navy_blue);
            return;
         default:
      }
   }

   private final void tintSnapSteps(HasFanSpeed var1, int var2) {
      if (var1.getHasGear4()) {
         if (var2 >= 25) {
            updateProgressTextTint$default(this, R.color.navy_blue, R.color.navy_blue, R.color.dimgray, R.color.dimgray, 0, 0, 48, (Object)null);
         } else {
            updateProgressTextTint$default(this, R.color.navy_blue, R.color.dimgray, R.color.dimgray, R.color.dimgray, 0, 0, 48, (Object)null);
         }
      } else if (DeviceKt.isG4orB4orNB(var1)) {
         if (var2 >= 33) {
            updateProgressTextTint$default(this, R.color.navy_blue, R.color.navy_blue, R.color.dimgray, R.color.dimgray, 0, 0, 48, (Object)null);
         } else {
            updateProgressTextTint$default(this, R.color.navy_blue, R.color.dimgray, R.color.dimgray, R.color.dimgray, 0, 0, 48, (Object)null);
         }
      } else if (var1 instanceof DeviceIcp) {
         if (var2 > 75) {
            updateProgressTextTint$default(this, R.color.navy_blue, R.color.dimgray, R.color.dimgray, R.color.navy_blue, R.color.navy_blue, 0, 32, (Object)null);
         } else if (var2 > 25) {
            updateProgressTextTint$default(this, R.color.navy_blue, R.color.dimgray, R.color.dimgray, R.color.dimgray, R.color.navy_blue, 0, 32, (Object)null);
         } else {
            updateProgressTextTint$default(this, R.color.navy_blue, R.color.dimgray, R.color.dimgray, R.color.dimgray, R.color.dimgray, 0, 32, (Object)null);
         }
      } else if (1 <= var2 && var2 < 33) {
         updateProgressTextTint$default(this, R.color.navy_blue, R.color.navy_blue, R.color.dimgray, R.color.dimgray, 0, 0, 48, (Object)null);
      } else if (34 <= var2 && var2 < 66) {
         updateProgressTextTint$default(this, R.color.navy_blue, R.color.navy_blue, R.color.navy_blue, R.color.dimgray, 0, 0, 48, (Object)null);
      } else {
         if (67 <= var2 && var2 < 99) {
            updateProgressTextTint$default(this, R.color.navy_blue, R.color.navy_blue, R.color.navy_blue, R.color.navy_blue, 0, 0, 48, (Object)null);
         }

      }
   }

   private static final BasicTwoWayBindingThrottle twbThrottle_delegate$lambda$0() {
      return new BasicTwoWayBindingThrottle(1000L);
   }

   private static final void update$lambda$4(DeviceManualModeHolder var0, Device var1, View var2) {
      Timber.Forest var7 = Timber.Forest;
      StringBuilder var13 = new StringBuilder("increaseFanSpeedBtn: was = ");
      var13.append(var0.binding.fanSpeedSeekbar.getProgress());
      var7.d(var13.toString(), new Object[0]);
      boolean var6 = ((HasFanSpeed)var1).getHasGear4();
      byte var4 = -1;
      if (var6) {
         Iterator var8 = FanSpeedUtils.INSTANCE.getBLUE_PREMIUM_FAN_PROGRESS_SNAP().iterator();
         int var3 = 0;

         int var5;
         while(true) {
            var5 = var4;
            if (!var8.hasNext()) {
               break;
            }

            if (((Number)var8.next()).intValue() > var0.binding.fanSpeedSeekbar.getProgress()) {
               var5 = var3;
               break;
            }

            ++var3;
         }

         if (var5 >= 0) {
            var0.binding.fanSpeedSeekbar.setProgress(((Number)FanSpeedUtils.INSTANCE.getBLUE_PREMIUM_FAN_PROGRESS_SNAP().get(var5)).intValue());
         }
      } else if (DeviceKt.isG4orB4orNB(var1)) {
         Iterator var9 = FanSpeedUtils.INSTANCE.getG4_FAN_PROGRESS_SNAP().iterator();
         int var15 = 0;

         int var16;
         while(true) {
            var16 = var4;
            if (!var9.hasNext()) {
               break;
            }

            if (((Number)var9.next()).intValue() > var0.binding.fanSpeedSeekbar.getProgress()) {
               var16 = var15;
               break;
            }

            ++var15;
         }

         if (var16 >= 0) {
            var0.binding.fanSpeedSeekbar.setProgress(((Number)FanSpeedUtils.INSTANCE.getG4_FAN_PROGRESS_SNAP().get(var16)).intValue());
         }
      } else if (var1 instanceof DeviceIcp) {
         AccessibleSeekBar var10 = var0.binding.fanSpeedSeekbar;
         var10.setProgress(var10.getProgress() + 50);
      } else {
         AccessibleSeekBar var11 = var0.binding.fanSpeedSeekbar;
         var11.setProgress(var11.getProgress() + 33);
      }

      Timber.Forest var12 = Timber.Forest;
      var13 = new StringBuilder("increaseFanSpeedBtn: now = ");
      var13.append(var0.binding.fanSpeedSeekbar.getProgress());
      var12.d(var13.toString(), new Object[0]);
   }

   private static final void update$lambda$7(DeviceManualModeHolder var0, Device var1, View var2) {
      Timber.Forest var6 = Timber.Forest;
      StringBuilder var14 = new StringBuilder("decreaseFanSpeedBtn: was = ");
      var14.append(var0.binding.fanSpeedSeekbar.getProgress());
      var6.d(var14.toString(), new Object[0]);
      boolean var5 = ((HasFanSpeed)var1).getHasGear4();
      byte var3 = -1;
      if (var5) {
         List var7 = FanSpeedUtils.INSTANCE.getBLUE_PREMIUM_FAN_PROGRESS_SNAP();
         ListIterator var8 = var7.listIterator(var7.size());

         int var4;
         while(true) {
            var4 = var3;
            if (!var8.hasPrevious()) {
               break;
            }

            if (((Number)var8.previous()).intValue() < var0.binding.fanSpeedSeekbar.getProgress()) {
               var4 = var8.nextIndex();
               break;
            }
         }

         if (var4 >= 0) {
            var0.binding.fanSpeedSeekbar.setProgress(((Number)FanSpeedUtils.INSTANCE.getBLUE_PREMIUM_FAN_PROGRESS_SNAP().get(var4)).intValue());
         }
      } else if (DeviceKt.isG4orB4orNB(var1)) {
         List var9 = FanSpeedUtils.INSTANCE.getG4_FAN_PROGRESS_SNAP();
         ListIterator var10 = var9.listIterator(var9.size());

         int var16;
         while(true) {
            var16 = var3;
            if (!var10.hasPrevious()) {
               break;
            }

            if (((Number)var10.previous()).intValue() < var0.binding.fanSpeedSeekbar.getProgress()) {
               var16 = var10.nextIndex();
               break;
            }
         }

         if (var16 >= 0) {
            var0.binding.fanSpeedSeekbar.setProgress(((Number)FanSpeedUtils.INSTANCE.getG4_FAN_PROGRESS_SNAP().get(var16)).intValue());
         }
      } else if (var1 instanceof DeviceIcp) {
         AccessibleSeekBar var11 = var0.binding.fanSpeedSeekbar;
         var11.setProgress(var11.getProgress() - 50);
      } else {
         AccessibleSeekBar var12 = var0.binding.fanSpeedSeekbar;
         var12.setProgress(var12.getProgress() - 33);
      }

      Timber.Forest var15 = Timber.Forest;
      StringBuilder var13 = new StringBuilder("decreaseFanSpeedBtn: now = ");
      var13.append(var0.binding.fanSpeedSeekbar.getProgress());
      var15.d(var13.toString(), new Object[0]);
   }

   private final void updateGermShield(Device var1) {
      ConstraintLayout var3 = this.binding.germshieldRoot;
      Intrinsics.checkNotNullExpressionValue(var3, "germshieldRoot");
      View var4 = (View)var3;
      boolean var2;
      if (DeviceKt.isGermShieldOn(var1) && !DeviceKt.isGermShieldPlus(var1)) {
         var2 = true;
      } else {
         var2 = false;
      }

      ViewExtensionsKt.show(var4, var2);
   }

   private final void updateProgressTextTint(int var1, int var2, int var3, int var4, int var5, int var6) {
      this.binding.fanspeed0.setTextColor(ContextCompat.getColor(this.itemView.getContext(), var1));
      this.binding.fanspeed1Blue.setTextColor(ContextCompat.getColor(this.itemView.getContext(), var2));
      this.binding.fanspeed1.setTextColor(ContextCompat.getColor(this.itemView.getContext(), var2));
      this.binding.fanspeed2.setTextColor(ContextCompat.getColor(this.itemView.getContext(), var3));
      this.binding.fanspeed3.setTextColor(ContextCompat.getColor(this.itemView.getContext(), var4));
      this.binding.fanspeed3Blue.setTextColor(ContextCompat.getColor(this.itemView.getContext(), var6));
      this.binding.fanspeed2Icp.setTextColor(ContextCompat.getColor(this.itemView.getContext(), var5));
   }

   // $FF: synthetic method
   static void updateProgressTextTint$default(DeviceManualModeHolder var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, Object var8) {
      if ((var7 & 16) != 0) {
         var5 = R.color.dimgray;
      }

      if ((var7 & 32) != 0) {
         var6 = R.color.dimgray;
      }

      var0.updateProgressTextTint(var1, var2, var3, var4, var5, var6);
   }

   public final HolderDeviceManualModeBinding getBinding() {
      return this.binding;
   }

   public final Function1 getOnFanSpeedSetListener() {
      return this.onFanSpeedSetListener;
   }

   public void update(Device var1) {
      Intrinsics.checkNotNullParameter(var1, "device");
      if (var1 instanceof HasFanSpeed && this.getTwbThrottle().allowReceiveUpdate()) {
         boolean var3 = var1 instanceof DeviceIcp;
         if (var3) {
            this.binding.fanSpeedSeekbar.setMax(100);
            this.binding.fanspeed2Icp.setVisibility(0);
            this.binding.fanspeed1.setVisibility(4);
            this.binding.fanspeed2.setVisibility(4);
            this.binding.fanspeed0.setText((CharSequence)"1");
         } else if (((HasFanSpeed)var1).getHasGear4()) {
            this.binding.fanSpeedSeekbar.setMax(100);
            this.binding.fanspeed1.setVisibility(4);
            this.binding.fanspeed1Blue.setVisibility(0);
            this.binding.fanspeed2.setVisibility(4);
            this.binding.fanspeed2Icp.setVisibility(0);
            this.binding.fanspeed3Blue.setVisibility(0);
            this.binding.fanspeed3.setText((CharSequence)"4");
         } else {
            this.binding.fanSpeedSeekbar.setMax(99);
            this.binding.fanspeed2Icp.setVisibility(4);
            this.binding.fanspeed1.setVisibility(0);
            this.binding.fanspeed2.setVisibility(0);
            this.binding.fanspeed0.setText((CharSequence)"0");
         }

         this.binding.fanSpeedSeekbar.setOnSeekBarChangeListener((SeekBar.OnSeekBarChangeListener)null);
         AccessibleSeekBar var5 = this.binding.fanSpeedSeekbar;
         HasFanSpeed var4 = (HasFanSpeed)var1;
         int var2;
         if (var4.getHasGear4()) {
            var2 = FanSpeedUtils.INSTANCE.getProgressFromFanSpeedBluePremium(var4.getFanSpeedEnum());
         } else if (DeviceKt.isG4orB4orNB(var1)) {
            var2 = FanSpeedUtils.INSTANCE.getProgressFromFanSpeedG4(var4.getFanSpeedEnum());
         } else if (var3) {
            var2 = FanSpeedUtils.INSTANCE.getProgressFromFanSpeedIcp(((DeviceIcp)var1).getFanSpeedEnum());
         } else {
            var2 = FanSpeedUtils.INSTANCE.getProgressFromFanSpeedLegacy(var4.getFanSpeedEnum());
         }

         var5.setProgress(var2);
         this.lastProgress = this.binding.fanSpeedSeekbar.getProgress();
         Timber.Forest var7 = Timber.Forest;
         StringBuilder var6 = new StringBuilder("update: progress = ");
         var6.append(this.binding.fanSpeedSeekbar.getProgress());
         var6.append(", fanSpeedEnum = ");
         var6.append(var4.getFanSpeedEnum());
         var7.d(var6.toString(), new Object[0]);
         this.tintFanSpeed(var4.getFanSpeedEnum());
         this.updateGermShield(var1);
         this.binding.increaseFanSpeedBg.setOnClickListener(new DeviceManualModeHolder$$ExternalSyntheticLambda1(this, var1));
         this.binding.decreaseFanSpeedBg.setOnClickListener(new DeviceManualModeHolder$$ExternalSyntheticLambda2(this, var1));
         this.binding.fanSpeedSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(var1, this) {
            final Device $device;
            final DeviceManualModeHolder this$0;

            {
               this.$device = var1;
               this.this$0 = var2;
            }

            public void onProgressChanged(SeekBar var1, int var2, boolean var3) {
               FanSpeedEnum var6;
               if (((HasFanSpeed)this.$device).getHasGear4()) {
                  var6 = FanSpeedEnum.Companion.fanSpeedEnumFromProgressBluePremium(FanSpeedUtils.INSTANCE.getBluePremiumFromSeekBarProgress(var2));
               } else if (DeviceKt.isG4orB4orNB(this.$device)) {
                  var6 = FanSpeedEnum.Companion.fanSpeedEnumFromProgressG4(FanSpeedUtils.INSTANCE.getG4FanSpeedFromSeekBarProgress(var2));
               } else if (this.$device instanceof DeviceIcp) {
                  var6 = FanSpeedEnum.Companion.fanSpeedEnumFromProgressIcp(FanSpeedUtils.INSTANCE.getIcpSpeedFromSeekBarProgress(var2));
               } else {
                  var6 = FanSpeedEnum.Companion.fanSpeedEnumFromProgressLegacy(FanSpeedUtils.INSTANCE.getLegacySpeedFromSeekBarProgress(var2));
               }

               if (var6 == FanSpeedEnum.SNAP_STEP) {
                  this.this$0.tintSnapSteps((HasFanSpeed)this.$device, var2);
               } else {
                  this.this$0.tintFanSpeed(var6);
               }

               Timber.Forest var5 = Timber.Forest;
               StringBuilder var4 = new StringBuilder("setOnSeekBarChangeListener progress = ");
               var4.append(var2);
               var4.append(", fanSpeedEnum = ");
               var4.append(var6);
               var4.append(", fromTouch = ");
               var4.append(var3);
               var5.d(var4.toString(), new Object[0]);
               if (!var3) {
                  DeviceManualModeHolder var7 = this.this$0;
                  var7.lastProgress = var7.getBinding().fanSpeedSeekbar.getProgress();
                  Timber.Forest.d("setOnSeekBarChangeListener: publish", new Object[0]);
                  this.this$0.publishValue(var6, (HasFanSpeed)this.$device);
               }

            }

            public void onStartTrackingTouch(SeekBar var1) {
            }

            public void onStopTrackingTouch(SeekBar var1) {
               this.this$0.onProgressSet((HasFanSpeed)this.$device);
            }
         });
      }
   }

   @Metadata(
      d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tR\u000e\u0010\f\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f"},
      d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceManualModeHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceManualModeHolder;", "parentView", "Landroid/view/ViewGroup;", "onFanSpeedSetListener", "Lkotlin/Function1;", "Lcom/blueair/core/model/FanSpeedEnum;", "", "STEP_LESS_INTERVAL", "", "STEP_LESS_INTERVAL_ICP", "devicedetails_otherRelease"},
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

      public final DeviceManualModeHolder newInstance(ViewGroup var1, Function1 var2) {
         Intrinsics.checkNotNullParameter(var1, "parentView");
         Intrinsics.checkNotNullParameter(var2, "onFanSpeedSetListener");
         HolderDeviceManualModeBinding var3 = HolderDeviceManualModeBinding.inflate(LayoutInflater.from(var1.getContext()), var1, false);
         Intrinsics.checkNotNullExpressionValue(var3, "inflate(...)");
         return new DeviceManualModeHolder(var3, var2);
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
         int[] var0 = new int[FanSpeedEnum.values().length];

         try {
            var0[FanSpeedEnum.OFF.ordinal()] = 1;
         } catch (NoSuchFieldError var28) {
         }

         try {
            var0[FanSpeedEnum.ONE.ordinal()] = 2;
         } catch (NoSuchFieldError var27) {
         }

         try {
            var0[FanSpeedEnum.ELEVEN.ordinal()] = 3;
         } catch (NoSuchFieldError var26) {
         }

         try {
            var0[FanSpeedEnum.FIFTEEN.ordinal()] = 4;
         } catch (NoSuchFieldError var25) {
         }

         try {
            var0[FanSpeedEnum.NINETEEN.ordinal()] = 5;
         } catch (NoSuchFieldError var24) {
         }

         try {
            var0[FanSpeedEnum.TWENTY_THREE.ordinal()] = 6;
         } catch (NoSuchFieldError var23) {
         }

         try {
            var0[FanSpeedEnum.TWENTY_SEVEN.ordinal()] = 7;
         } catch (NoSuchFieldError var22) {
         }

         try {
            var0[FanSpeedEnum.THIRTY_ONE.ordinal()] = 8;
         } catch (NoSuchFieldError var21) {
         }

         try {
            var0[FanSpeedEnum.THIRTY_FIVE.ordinal()] = 9;
         } catch (NoSuchFieldError var20) {
         }

         try {
            var0[FanSpeedEnum.THIRTY_SEVEN.ordinal()] = 10;
         } catch (NoSuchFieldError var19) {
         }

         try {
            var0[FanSpeedEnum.THIRTY_NINE.ordinal()] = 11;
         } catch (NoSuchFieldError var18) {
         }

         try {
            var0[FanSpeedEnum.FORTY_THREE.ordinal()] = 12;
         } catch (NoSuchFieldError var17) {
         }

         try {
            var0[FanSpeedEnum.FORTY_SEVEN.ordinal()] = 13;
         } catch (NoSuchFieldError var16) {
         }

         try {
            var0[FanSpeedEnum.TWO.ordinal()] = 14;
         } catch (NoSuchFieldError var15) {
         }

         try {
            var0[FanSpeedEnum.FIFTY_ONE.ordinal()] = 15;
         } catch (NoSuchFieldError var14) {
         }

         try {
            var0[FanSpeedEnum.FIFTY_FIVE.ordinal()] = 16;
         } catch (NoSuchFieldError var13) {
         }

         try {
            var0[FanSpeedEnum.FIFTY_NINE.ordinal()] = 17;
         } catch (NoSuchFieldError var12) {
         }

         try {
            var0[FanSpeedEnum.SIXTY_THREE.ordinal()] = 18;
         } catch (NoSuchFieldError var11) {
         }

         try {
            var0[FanSpeedEnum.SIXTY_FOUR.ordinal()] = 19;
         } catch (NoSuchFieldError var10) {
         }

         try {
            var0[FanSpeedEnum.SIXTY_SEVEN.ordinal()] = 20;
         } catch (NoSuchFieldError var9) {
         }

         try {
            var0[FanSpeedEnum.SEVENTY_ONE.ordinal()] = 21;
         } catch (NoSuchFieldError var8) {
         }

         try {
            var0[FanSpeedEnum.SEVENTY_FIVE.ordinal()] = 22;
         } catch (NoSuchFieldError var7) {
         }

         try {
            var0[FanSpeedEnum.SEVENTY_NINE.ordinal()] = 23;
         } catch (NoSuchFieldError var6) {
         }

         try {
            var0[FanSpeedEnum.EIGHTY_THREE.ordinal()] = 24;
         } catch (NoSuchFieldError var5) {
         }

         try {
            var0[FanSpeedEnum.EIGHTY_SEVEN.ordinal()] = 25;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[FanSpeedEnum.THREE.ordinal()] = 26;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[FanSpeedEnum.NINETY_ONE.ordinal()] = 27;
         } catch (NoSuchFieldError var2) {
         }

         $EnumSwitchMapping$0 = var0;
      }
   }
}
