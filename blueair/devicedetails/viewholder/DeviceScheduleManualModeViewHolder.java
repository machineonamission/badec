package com.blueair.devicedetails.viewholder;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.FanSpeedEnum;
import com.blueair.core.model.HasFanSpeed;
import com.blueair.devicedetails.databinding.HolderDeviceManualModeBinding;
import com.blueair.devicedetails.util.FanSpeedUtils;
import com.blueair.viewcore.R;
import com.blueair.viewcore.view.AccessibleSeekBar;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 02\u00020\u0001:\u00010B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0006J\u0010\u0010\"\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020 H\u0002J<\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020\u001d2\b\b\u0002\u0010(\u001a\u00020\u001d2\b\b\u0002\u0010)\u001a\u00020\u001dH\u0002J\u0018\u0010*\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010+\u001a\u00020\u001dH\u0002J\u0010\u0010,\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u0006H\u0002J\u0018\u0010-\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010+\u001a\u00020\u001dH\u0002J\u0010\u0010.\u001a\u00020/2\u0006\u0010+\u001a\u00020\u001dH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00061"},
   d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceScheduleManualModeViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/blueair/devicedetails/databinding/HolderDeviceManualModeBinding;", "onFanSpeedChanged", "Lkotlin/Function1;", "Lcom/blueair/core/model/FanSpeedEnum;", "", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceManualModeBinding;Lkotlin/jvm/functions/Function1;)V", "getBinding", "()Lcom/blueair/devicedetails/databinding/HolderDeviceManualModeBinding;", "fanSpeed0View", "Landroid/widget/TextView;", "fanSpeed1BlueView", "fanSpeed1View", "fanSpeed2View", "fanSpeed2ViewIcp", "fanSpeed3View", "fanSpeed3BlueView", "fanSpeedSeekBar", "Lcom/blueair/viewcore/view/AccessibleSeekBar;", "increaseFanSpeedBtn", "Landroid/widget/ImageView;", "decreaseFanSpeedBtn", "title", "separator", "Landroid/view/View;", "lastProgress", "", "bind", "device", "Lcom/blueair/core/model/HasFanSpeed;", "fanSpeedEnum", "onProgressSet", "updateProgressTextTint", "fan0TintRes", "fan1TintRes", "fan2TintRes", "fan3TintRes", "fan2IcpRes", "fan3BlueRes", "getProgressAfterSnap", "progress", "tintFanSpeed", "tintSnapSteps", "isSlidingRight", "", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceScheduleManualModeViewHolder extends RecyclerView.ViewHolder {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   public static final int STEP_INTERVAL = 3;
   public static final int STEP_LESS_INTERVAL = 33;
   public static final int STEP_LESS_INTERVAL_BLUE_PREMIUM = 25;
   private final HolderDeviceManualModeBinding binding;
   private final ImageView decreaseFanSpeedBtn;
   private final TextView fanSpeed0View;
   private final TextView fanSpeed1BlueView;
   private final TextView fanSpeed1View;
   private final TextView fanSpeed2View;
   private final TextView fanSpeed2ViewIcp;
   private final TextView fanSpeed3BlueView;
   private final TextView fanSpeed3View;
   private final AccessibleSeekBar fanSpeedSeekBar;
   private final ImageView increaseFanSpeedBtn;
   private int lastProgress;
   private final Function1 onFanSpeedChanged;
   private final View separator;
   private final TextView title;

   // $FF: synthetic method
   public static void $r8$lambda$U9VNLiIPrDMc_UVynOXNEdIqM_s/* $FF was: $r8$lambda$U9VNLiIPrDMc-UVynOXNEdIqM-s*/(HasFanSpeed var0, DeviceScheduleManualModeViewHolder var1, View var2) {
      bind$lambda$2(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$cO2BpmfDB02Mi_VTMO1GCrUSnXc/* $FF was: $r8$lambda$cO2BpmfDB02Mi-VTMO1GCrUSnXc*/(HasFanSpeed var0, DeviceScheduleManualModeViewHolder var1, View var2) {
      bind$lambda$1(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$yAKVya_dr3OUp0VDmYbjGtlCdYU(DeviceScheduleManualModeViewHolder var0, HasFanSpeed var1, int var2) {
      onProgressSet$lambda$3(var0, var1, var2);
   }

   public DeviceScheduleManualModeViewHolder(HolderDeviceManualModeBinding var1, Function1 var2) {
      Intrinsics.checkNotNullParameter(var1, "binding");
      Intrinsics.checkNotNullParameter(var2, "onFanSpeedChanged");
      super((View)var1.getRoot());
      this.binding = var1;
      this.onFanSpeedChanged = var2;
      TextView var9 = var1.fanspeed0;
      Intrinsics.checkNotNullExpressionValue(var9, "fanspeed0");
      this.fanSpeed0View = var9;
      var9 = var1.fanspeed1Blue;
      Intrinsics.checkNotNullExpressionValue(var9, "fanspeed1Blue");
      this.fanSpeed1BlueView = var9;
      var9 = var1.fanspeed1;
      Intrinsics.checkNotNullExpressionValue(var9, "fanspeed1");
      this.fanSpeed1View = var9;
      var9 = var1.fanspeed2;
      Intrinsics.checkNotNullExpressionValue(var9, "fanspeed2");
      this.fanSpeed2View = var9;
      var9 = var1.fanspeed2Icp;
      Intrinsics.checkNotNullExpressionValue(var9, "fanspeed2Icp");
      this.fanSpeed2ViewIcp = var9;
      var9 = var1.fanspeed3;
      Intrinsics.checkNotNullExpressionValue(var9, "fanspeed3");
      this.fanSpeed3View = var9;
      var9 = var1.fanspeed3Blue;
      Intrinsics.checkNotNullExpressionValue(var9, "fanspeed3Blue");
      this.fanSpeed3BlueView = var9;
      AccessibleSeekBar var16 = var1.fanSpeedSeekbar;
      Intrinsics.checkNotNullExpressionValue(var16, "fanSpeedSeekbar");
      this.fanSpeedSeekBar = var16;
      AppCompatImageView var3 = var1.increaseFanSpeedBg;
      Intrinsics.checkNotNullExpressionValue(var3, "increaseFanSpeedBg");
      this.increaseFanSpeedBtn = (ImageView)var3;
      var3 = var1.decreaseFanSpeedBg;
      Intrinsics.checkNotNullExpressionValue(var3, "decreaseFanSpeedBg");
      this.decreaseFanSpeedBtn = (ImageView)var3;
      TextView var18 = var1.modeTitle;
      Intrinsics.checkNotNullExpressionValue(var18, "modeTitle");
      this.title = var18;
      View var4 = var1.separator;
      Intrinsics.checkNotNullExpressionValue(var4, "separator");
      this.separator = var4;
      Drawable var5 = var16.getProgressDrawable();
      LayerDrawable var6;
      if (var5 instanceof LayerDrawable) {
         var6 = (LayerDrawable)var5;
      } else {
         var6 = null;
      }

      if (var6 != null) {
         Drawable var7 = var6.findDrawableByLayerId(16908301);
         if (var7 != null) {
            var7 = var7.mutate();
            if (var7 != null) {
               var7.setTint(ContextCompat.getColor(this.itemView.getContext(), R.color.colorPrimary));
            }
         }
      }

   }

   private static final void bind$lambda$1(HasFanSpeed var0, DeviceScheduleManualModeViewHolder var1, View var2) {
      if (var0.getHasGear4()) {
         int var9 = var1.fanSpeedSeekBar.getProgress();
         if (var9 >= 0 && var9 < 25) {
            AccessibleSeekBar var8 = var1.fanSpeedSeekBar;
            var8.setProgress(var8.getProgress() + 25);
         } else {
            AccessibleSeekBar var7 = var1.fanSpeedSeekBar;
            var7.setProgress(var7.getProgress() + 3);
         }
      } else if (DeviceKt.isG4orB4orNB(var0)) {
         int var3 = var1.fanSpeedSeekBar.getProgress();
         if (var3 >= 0 && var3 < 33) {
            AccessibleSeekBar var6 = var1.fanSpeedSeekBar;
            var6.setProgress(var6.getProgress() + 33);
         } else {
            AccessibleSeekBar var5 = var1.fanSpeedSeekBar;
            var5.setProgress(var5.getProgress() + 3);
         }
      } else {
         AccessibleSeekBar var4 = var1.fanSpeedSeekBar;
         var4.setProgress(var4.getProgress() + 33);
      }
   }

   private static final void bind$lambda$2(HasFanSpeed var0, DeviceScheduleManualModeViewHolder var1, View var2) {
      if (var0.getHasGear4()) {
         int var7 = var1.fanSpeedSeekBar.getProgress();
         if (var7 >= 0 && var7 < 26) {
            var1.fanSpeedSeekBar.setProgress(0);
         } else {
            AccessibleSeekBar var6 = var1.fanSpeedSeekBar;
            var6.setProgress(var6.getProgress() - 3);
         }
      } else if (DeviceKt.isG4orB4orNB(var0)) {
         int var3 = var1.fanSpeedSeekBar.getProgress();
         if (1 <= var3 && var3 < 34) {
            var1.fanSpeedSeekBar.setProgress(0);
         } else {
            AccessibleSeekBar var5 = var1.fanSpeedSeekBar;
            var5.setProgress(var5.getProgress() - 3);
         }
      } else {
         AccessibleSeekBar var4 = var1.fanSpeedSeekBar;
         var4.setProgress(var4.getProgress() - 33);
      }
   }

   private final int getProgressAfterSnap(HasFanSpeed var1, int var2) {
      if (var1.getHasGear4()) {
         return this.isSlidingRight(var2) ? 25 : 0;
      } else if (DeviceKt.isG4orB4orNB(var1)) {
         return this.isSlidingRight(var2) ? 33 : 0;
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

   private final boolean isSlidingRight(int var1) {
      return this.lastProgress < var1;
   }

   private final void onProgressSet(HasFanSpeed var1) {
      int var2 = this.fanSpeedSeekBar.getProgress();
      FanSpeedEnum var3;
      if (var1.getHasGear4()) {
         var3 = FanSpeedEnum.Companion.fanSpeedEnumFromProgressBluePremium(FanSpeedUtils.INSTANCE.getBluePremiumFromSeekBarProgress(var2));
      } else if (DeviceKt.isG4orB4orNB(var1)) {
         var3 = FanSpeedEnum.Companion.fanSpeedEnumFromProgressG4(FanSpeedUtils.INSTANCE.getG4FanSpeedFromSeekBarProgress(var2));
      } else {
         var3 = FanSpeedEnum.Companion.fanSpeedEnumFromProgressLegacy(FanSpeedUtils.INSTANCE.getLegacySpeedFromSeekBarProgress(var2));
      }

      if (var3 == FanSpeedEnum.SNAP_STEP) {
         this.fanSpeedSeekBar.postDelayed(new DeviceScheduleManualModeViewHolder$$ExternalSyntheticLambda0(this, var1, var2), (long)ViewConfiguration.getTapTimeout());
      } else {
         this.tintFanSpeed(var3);
         this.lastProgress = this.fanSpeedSeekBar.getProgress();
         this.onFanSpeedChanged.invoke(var3);
      }
   }

   private static final void onProgressSet$lambda$3(DeviceScheduleManualModeViewHolder var0, HasFanSpeed var1, int var2) {
      var0.fanSpeedSeekBar.setProgress(var0.getProgressAfterSnap(var1, var2));
   }

   private final void tintFanSpeed(FanSpeedEnum var1) {
      Timber.Forest var2 = Timber.Forest;
      StringBuilder var3 = new StringBuilder("fanSpeedEnum called: ");
      var3.append(var1);
      var2.d(var3.toString(), new Object[0]);
      switch (DeviceScheduleManualModeViewHolder.WhenMappings.$EnumSwitchMapping$0[var1.ordinal()]) {
         case 1:
            updateProgressTextTint$default(this, R.color.blue, R.color.dimgray, R.color.dimgray, R.color.dimgray, R.color.dimgray, 0, 32, (Object)null);
            return;
         case 2:
         case 3:
         case 4:
         case 5:
         case 6:
         case 7:
         case 8:
         case 9:
            updateProgressTextTint$default(this, R.color.blue, R.color.blue, R.color.dimgray, R.color.dimgray, R.color.dimgray, 0, 32, (Object)null);
            return;
         case 10:
         case 11:
         case 12:
         case 13:
            updateProgressTextTint$default(this, R.color.blue, R.color.blue, R.color.dimgray, R.color.dimgray, R.color.blue, 0, 32, (Object)null);
            return;
         case 14:
         case 15:
         case 16:
         case 17:
         case 18:
            this.updateProgressTextTint(R.color.blue, R.color.blue, R.color.blue, R.color.dimgray, R.color.blue, R.color.dimgray);
            return;
         case 19:
         case 20:
         case 21:
         case 22:
         case 23:
         case 24:
         case 25:
            this.updateProgressTextTint(R.color.blue, R.color.blue, R.color.blue, R.color.dimgray, R.color.blue, R.color.blue);
            return;
         case 26:
         case 27:
            this.updateProgressTextTint(R.color.blue, R.color.blue, R.color.blue, R.color.blue, R.color.blue, R.color.blue);
            return;
         default:
      }
   }

   private final void tintSnapSteps(HasFanSpeed var1, int var2) {
      if (var1.getHasGear4()) {
         if (var2 >= 25) {
            updateProgressTextTint$default(this, R.color.blue, R.color.blue, R.color.dimgray, R.color.dimgray, 0, 0, 48, (Object)null);
         } else {
            updateProgressTextTint$default(this, R.color.blue, R.color.dimgray, R.color.dimgray, R.color.dimgray, 0, 0, 48, (Object)null);
         }
      } else if (DeviceKt.isG4orB4orNB(var1)) {
         if (var2 >= 33) {
            updateProgressTextTint$default(this, R.color.blue, R.color.blue, R.color.dimgray, R.color.dimgray, 0, 0, 48, (Object)null);
         } else {
            updateProgressTextTint$default(this, R.color.blue, R.color.dimgray, R.color.dimgray, R.color.dimgray, 0, 0, 48, (Object)null);
         }
      } else if (1 <= var2 && var2 < 33) {
         updateProgressTextTint$default(this, R.color.blue, R.color.blue, R.color.dimgray, R.color.dimgray, 0, 0, 48, (Object)null);
      } else if (34 <= var2 && var2 < 66) {
         updateProgressTextTint$default(this, R.color.blue, R.color.blue, R.color.blue, R.color.dimgray, 0, 0, 48, (Object)null);
      } else {
         if (67 <= var2 && var2 < 99) {
            updateProgressTextTint$default(this, R.color.blue, R.color.blue, R.color.blue, R.color.blue, 0, 0, 48, (Object)null);
         }

      }
   }

   private final void updateProgressTextTint(int var1, int var2, int var3, int var4, int var5, int var6) {
      this.fanSpeed0View.setTextColor(ContextCompat.getColor(this.itemView.getContext(), var1));
      this.fanSpeed1BlueView.setTextColor(ContextCompat.getColor(this.itemView.getContext(), var2));
      this.fanSpeed1View.setTextColor(ContextCompat.getColor(this.itemView.getContext(), var2));
      this.fanSpeed2View.setTextColor(ContextCompat.getColor(this.itemView.getContext(), var3));
      this.fanSpeed3View.setTextColor(ContextCompat.getColor(this.itemView.getContext(), var4));
      this.fanSpeed3BlueView.setTextColor(ContextCompat.getColor(this.itemView.getContext(), var6));
      this.fanSpeed2ViewIcp.setTextColor(ContextCompat.getColor(this.itemView.getContext(), var5));
   }

   // $FF: synthetic method
   static void updateProgressTextTint$default(DeviceScheduleManualModeViewHolder var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, Object var8) {
      if ((var7 & 16) != 0) {
         var5 = R.color.dimgray;
      }

      if ((var7 & 32) != 0) {
         var6 = R.color.dimgray;
      }

      var0.updateProgressTextTint(var1, var2, var3, var4, var5, var6);
   }

   public final void bind(HasFanSpeed var1, FanSpeedEnum var2) {
      Intrinsics.checkNotNullParameter(var1, "device");
      Intrinsics.checkNotNullParameter(var2, "fanSpeedEnum");
      this.title.setText(R.string.set_manual_fan_speed);
      this.title.setTextSize(2, 15.0F);
      ViewExtensionsKt.hide(this.separator);
      if (var1.getHasGear4()) {
         this.fanSpeedSeekBar.setMax(100);
         this.fanSpeed1View.setVisibility(4);
         this.fanSpeed1BlueView.setVisibility(0);
         this.fanSpeed2View.setVisibility(4);
         this.fanSpeed2ViewIcp.setVisibility(0);
         this.fanSpeed3BlueView.setVisibility(0);
         this.fanSpeed3View.setText((CharSequence)"4");
      } else {
         this.fanSpeedSeekBar.setMax(99);
         this.fanSpeed2ViewIcp.setVisibility(4);
         this.fanSpeed1View.setVisibility(0);
         this.fanSpeed2View.setVisibility(0);
      }

      AccessibleSeekBar var4 = this.fanSpeedSeekBar;
      int var3;
      if (var1.getHasGear4()) {
         var3 = FanSpeedUtils.INSTANCE.getProgressFromFanSpeedBluePremium(var2);
      } else if (DeviceKt.isG4orB4orNB(var1)) {
         var3 = FanSpeedUtils.INSTANCE.getProgressFromFanSpeedG4(var2);
      } else {
         var3 = FanSpeedUtils.INSTANCE.getProgressFromFanSpeedLegacy(var2);
      }

      var4.setProgress(var3);
      this.lastProgress = this.fanSpeedSeekBar.getProgress();
      this.tintFanSpeed(var2);
      this.increaseFanSpeedBtn.setOnClickListener(new DeviceScheduleManualModeViewHolder$$ExternalSyntheticLambda1(var1, this));
      this.decreaseFanSpeedBtn.setOnClickListener(new DeviceScheduleManualModeViewHolder$$ExternalSyntheticLambda2(var1, this));
      this.fanSpeedSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(var1, this) {
         final HasFanSpeed $device;
         final DeviceScheduleManualModeViewHolder this$0;

         {
            this.$device = var1;
            this.this$0 = var2;
         }

         public void onProgressChanged(SeekBar var1, int var2, boolean var3) {
            Intrinsics.checkNotNullParameter(var1, "seekBar");
            FanSpeedEnum var6;
            if (this.$device.getHasGear4()) {
               var6 = FanSpeedEnum.Companion.fanSpeedEnumFromProgressBluePremium(FanSpeedUtils.INSTANCE.getBluePremiumFromSeekBarProgress(var2));
            } else if (DeviceKt.isG4orB4orNB(this.$device)) {
               var6 = FanSpeedEnum.Companion.fanSpeedEnumFromProgressG4(FanSpeedUtils.INSTANCE.getG4FanSpeedFromSeekBarProgress(var2));
            } else {
               var6 = FanSpeedEnum.Companion.fanSpeedEnumFromProgressLegacy(FanSpeedUtils.INSTANCE.getLegacySpeedFromSeekBarProgress(var2));
            }

            if (var6 == FanSpeedEnum.SNAP_STEP) {
               Timber.Forest var4 = Timber.Forest;
               StringBuilder var5 = new StringBuilder("fanSpeedEnum :");
               var5.append(var6);
               var4.d(var5.toString(), new Object[0]);
               this.this$0.tintSnapSteps(this.$device, var2);
            } else {
               this.this$0.tintFanSpeed(var6);
            }

            if (!var3) {
               this.this$0.lastProgress = var2;
               this.this$0.onFanSpeedChanged.invoke(var6);
            }

         }

         public void onStartTrackingTouch(SeekBar var1) {
            Intrinsics.checkNotNullParameter(var1, "seekBar");
         }

         public void onStopTrackingTouch(SeekBar var1) {
            Intrinsics.checkNotNullParameter(var1, "seekBar");
            this.this$0.onProgressSet(this.$device);
         }
      });
   }

   public final HolderDeviceManualModeBinding getBinding() {
      return this.binding;
   }

   @Metadata(
      d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tR\u000e\u0010\f\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0010"},
      d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceScheduleManualModeViewHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceScheduleManualModeViewHolder;", "parentView", "Landroid/view/ViewGroup;", "onFanSpeedChanged", "Lkotlin/Function1;", "Lcom/blueair/core/model/FanSpeedEnum;", "", "STEP_LESS_INTERVAL", "", "STEP_LESS_INTERVAL_BLUE_PREMIUM", "STEP_INTERVAL", "devicedetails_otherRelease"},
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

      public final DeviceScheduleManualModeViewHolder newInstance(ViewGroup var1, Function1 var2) {
         Intrinsics.checkNotNullParameter(var1, "parentView");
         Intrinsics.checkNotNullParameter(var2, "onFanSpeedChanged");
         HolderDeviceManualModeBinding var3 = HolderDeviceManualModeBinding.inflate(LayoutInflater.from(var1.getContext()), var1, false);
         Intrinsics.checkNotNullExpressionValue(var3, "inflate(...)");
         return new DeviceScheduleManualModeViewHolder(var3, var2);
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
