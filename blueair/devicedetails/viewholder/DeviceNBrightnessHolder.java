package com.blueair.devicedetails.viewholder;

import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.databinding.ViewDataBinding;
import com.blueair.android.BlueairApp$$ExternalSyntheticApiModelOutline0;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceNewClassic;
import com.blueair.core.model.HasBrightness;
import com.blueair.devicedetails.databinding.HolderDeviceHBrightnessBinding;
import com.blueair.devicedetails.databinding.HolderDeviceNBrightnessBinding;
import com.blueair.viewcore.R;
import com.blueair.viewcore.view.AccessibleSeekBar;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(
   d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cBD\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\t¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u000e\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0015R)\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"},
   d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceNBrightnessHolder;", "Lcom/blueair/devicedetails/viewholder/DeviceAttributeHolder;", "binding", "Landroidx/databinding/ViewDataBinding;", "device", "Lcom/blueair/core/model/Device;", "isInSchedule", "", "onBrightnessSetListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "brightness", "", "<init>", "(Landroidx/databinding/ViewDataBinding;Lcom/blueair/core/model/Device;ZLkotlin/jvm/functions/Function1;)V", "getBinding", "()Landroidx/databinding/ViewDataBinding;", "getDevice", "()Lcom/blueair/core/model/Device;", "()Z", "seekbar", "Landroid/widget/SeekBar;", "progressText", "Landroid/widget/TextView;", "seekbarMin", "update", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceNBrightnessHolder extends DeviceAttributeHolder {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final ViewDataBinding binding;
   private final Device device;
   private final boolean isInSchedule;
   private final Function1 onBrightnessSetListener;
   private final TextView progressText;
   private final SeekBar seekbar;
   private final int seekbarMin;

   public DeviceNBrightnessHolder(ViewDataBinding var1, Device var2, boolean var3, Function1 var4) {
      Intrinsics.checkNotNullParameter(var1, "binding");
      Intrinsics.checkNotNullParameter(var4, "onBrightnessSetListener");
      View var6 = var1.getRoot();
      Intrinsics.checkNotNullExpressionValue(var6, "getRoot(...)");
      super(var6);
      this.binding = var1;
      this.device = var2;
      this.isInSchedule = var3;
      this.onBrightnessSetListener = var4;
      byte var5 = var2 instanceof DeviceNewClassic;
      this.seekbarMin = var5;
      if (var1 instanceof HolderDeviceHBrightnessBinding) {
         AccessibleSeekBar var9 = ((HolderDeviceHBrightnessBinding)var1).seekbar;
         Intrinsics.checkNotNullExpressionValue(var9, "seekbar");
         this.seekbar = (SeekBar)var9;
         TextView var7 = ((HolderDeviceHBrightnessBinding)var1).progressText;
         Intrinsics.checkNotNullExpressionValue(var7, "progressText");
         this.progressText = var7;
      } else {
         Intrinsics.checkNotNull(var1, "null cannot be cast to non-null type com.blueair.devicedetails.databinding.HolderDeviceNBrightnessBinding");
         HolderDeviceNBrightnessBinding var10 = (HolderDeviceNBrightnessBinding)var1;
         AccessibleSeekBar var11 = ((HolderDeviceNBrightnessBinding)var1).seekbar;
         Intrinsics.checkNotNullExpressionValue(var11, "seekbar");
         this.seekbar = (SeekBar)var11;
         TextView var8 = ((HolderDeviceNBrightnessBinding)var1).progressText;
         Intrinsics.checkNotNullExpressionValue(var8, "progressText");
         this.progressText = var8;
      }

      if (VERSION.SDK_INT >= 26) {
         BlueairApp$$ExternalSyntheticApiModelOutline0.m((AccessibleSeekBar)((AccessibleSeekBar)this.seekbar), var5);
      }

      ((AccessibleSeekBar)this.seekbar).setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(this) {
         final DeviceNBrightnessHolder this$0;

         {
            this.this$0 = var1;
         }

         public void onProgressChanged(SeekBar var1, int var2, boolean var3) {
            Intrinsics.checkNotNullParameter(var1, "seekBar");
            TextView var5 = this.this$0.progressText;
            StringBuilder var4 = new StringBuilder();
            var4.append(var2);
            var4.append('%');
            var5.setText((CharSequence)var4.toString());
         }

         public void onStartTrackingTouch(SeekBar var1) {
            Intrinsics.checkNotNullParameter(var1, "seekBar");
         }

         public void onStopTrackingTouch(SeekBar var1) {
            Intrinsics.checkNotNullParameter(var1, "seekBar");
            this.this$0.onBrightnessSetListener.invoke(var1.getProgress());
         }
      });
   }

   public final ViewDataBinding getBinding() {
      return this.binding;
   }

   public final Device getDevice() {
      return this.device;
   }

   public final boolean isInSchedule() {
      return this.isInSchedule;
   }

   public final void update(int var1) {
      var1 = RangesKt.coerceIn(var1, this.seekbarMin, 100);
      this.seekbar.setProgress(var1);
      TextView var3 = this.progressText;
      StringBuilder var2 = new StringBuilder();
      var2.append(var1);
      var2.append('%');
      var3.setText((CharSequence)var2.toString());
   }

   public void update(Device var1) {
      Intrinsics.checkNotNullParameter(var1, "device");
      if (var1 instanceof HasBrightness) {
         this.update(RangesKt.coerceIn(((HasBrightness)var1).getBrightness(), this.seekbarMin, 100));
      }

   }

   @Metadata(
      d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JC\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2!\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\r¨\u0006\u0013"},
      d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceNBrightnessHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceNBrightnessHolder;", "parentView", "Landroid/view/ViewGroup;", "device", "Lcom/blueair/core/model/Device;", "isInSchedule", "", "onBrightnessSetListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "brightness", "", "devicedetails_otherRelease"},
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

      public final DeviceNBrightnessHolder newInstance(ViewGroup var1, Device var2, boolean var3, Function1 var4) {
         Intrinsics.checkNotNullParameter(var1, "parentView");
         Intrinsics.checkNotNullParameter(var4, "onBrightnessSetListener");
         ViewDataBinding var6;
         if (var2 instanceof DeviceNewClassic) {
            HolderDeviceNBrightnessBinding var5 = HolderDeviceNBrightnessBinding.inflate(LayoutInflater.from(var1.getContext()), var1, false);
            if (var3) {
               var5.contentContainer.setBackground(AppCompatResources.getDrawable(var1.getContext(), R.drawable.rounded_square_light_grey));
            }

            Intrinsics.checkNotNullExpressionValue(var5, "apply(...)");
            var6 = var5;
         } else {
            HolderDeviceHBrightnessBinding var7 = HolderDeviceHBrightnessBinding.inflate(LayoutInflater.from(var1.getContext()), var1, false);
            if (var3) {
               var7.contentContainer.setBackground(AppCompatResources.getDrawable(var1.getContext(), R.drawable.rounded_square_anti_flash_blue_r8));
            }

            Intrinsics.checkNotNullExpressionValue(var7, "apply(...)");
            var6 = var7;
         }

         return new DeviceNBrightnessHolder(var6, var2, var3, var4);
      }
   }
}
