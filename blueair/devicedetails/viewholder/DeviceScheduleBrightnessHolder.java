package com.blueair.devicedetails.viewholder;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.Brightness;
import com.blueair.core.model.BrightnessKt;
import com.blueair.core.model.Device;
import com.blueair.devicedetails.databinding.HolderDeviceBrightnessBinding;
import com.blueair.viewcore.R;
import com.blueair.viewcore.view.AccessibleSeekBar;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0006J\u0010\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0011H\u0002J\u0010\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0011H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"},
   d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceScheduleBrightnessHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/blueair/devicedetails/databinding/HolderDeviceBrightnessBinding;", "onBrightnessChanged", "Lkotlin/Function1;", "", "", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceBrightnessBinding;Lkotlin/jvm/functions/Function1;)V", "getBinding", "()Lcom/blueair/devicedetails/databinding/HolderDeviceBrightnessBinding;", "brightnessSeekbar", "Lcom/blueair/viewcore/view/AccessibleSeekBar;", "brightnessPercentView", "Landroid/widget/TextView;", "lastProgress", "", "bind", "device", "Lcom/blueair/core/model/Device;", "brightness", "onProgressSet", "isSlidingRight", "", "progress", "updateThumb", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceScheduleBrightnessHolder extends RecyclerView.ViewHolder {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final HolderDeviceBrightnessBinding binding;
   private final TextView brightnessPercentView;
   private final AccessibleSeekBar brightnessSeekbar;
   private int lastProgress;
   private final Function1 onBrightnessChanged;

   public DeviceScheduleBrightnessHolder(HolderDeviceBrightnessBinding var1, Function1 var2) {
      Intrinsics.checkNotNullParameter(var1, "binding");
      Intrinsics.checkNotNullParameter(var2, "onBrightnessChanged");
      super((View)var1.getRoot());
      this.binding = var1;
      this.onBrightnessChanged = var2;
      AccessibleSeekBar var8 = var1.brightnessSeekbar;
      Intrinsics.checkNotNullExpressionValue(var8, "brightnessSeekbar");
      this.brightnessSeekbar = var8;
      TextView var3 = var1.settingValue;
      Intrinsics.checkNotNullExpressionValue(var3, "settingValue");
      this.brightnessPercentView = var3;
      Drawable var4 = var8.getProgressDrawable();
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

   private final boolean isSlidingRight(int var1) {
      return this.lastProgress < var1;
   }

   private final void onProgressSet(Device var1) {
      int var2 = this.brightnessSeekbar.getProgress();
      if (BrightnessKt.hasBrightnessInPercent(var1)) {
         this.updateThumb(var2);
         Timber.Forest var3 = Timber.Forest;
         StringBuilder var5 = new StringBuilder("brightness seekbar:  progress = ");
         var5.append(this.brightnessSeekbar.getProgress());
         var3.d(var5.toString(), new Object[0]);
         this.onBrightnessChanged.invoke(var2);
      } else {
         Brightness var4 = Brightness.Companion.fromPercentage(var2, this.isSlidingRight(var2));
         this.updateThumb(var4.toPercentage());
         this.brightnessSeekbar.setProgress(var4.toPercentage());
         Timber.Forest var6 = Timber.Forest;
         StringBuilder var7 = new StringBuilder("brightness seekbar:  progress = ");
         var7.append(this.brightnessSeekbar.getProgress());
         var7.append(", brightness = ");
         var7.append(var4);
         var7.append(", direction: ");
         var7.append(this.isSlidingRight(var2));
         var6.d(var7.toString(), new Object[0]);
         this.onBrightnessChanged.invoke(var4);
      }

      this.lastProgress = this.brightnessSeekbar.getProgress();
   }

   private final void updateThumb(int var1) {
      if (var1 == 0) {
         this.brightnessSeekbar.setThumb(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.thumb_brightness_at_0_percent));
      } else if (1 <= var1 && var1 < 3) {
         this.brightnessSeekbar.setThumb(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.thumb_brightness_at_two_percent));
      } else if (3 <= var1 && var1 < 6) {
         this.brightnessSeekbar.setThumb(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.atoms_layers_neumorphs_brightness_knob));
      } else if (var1 == 97) {
         this.brightnessSeekbar.setThumb(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.thumb_brightness_at_97_percent));
      } else if (var1 == 98) {
         this.brightnessSeekbar.setThumb(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.thumb_brightness_at_98_percent));
      } else if (var1 == 99) {
         this.brightnessSeekbar.setThumb(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.thumb_brightness_at_99_percent));
      } else if (var1 == 100) {
         this.brightnessSeekbar.setThumb(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.thumb_brightness_at_100_percent));
      } else {
         this.brightnessSeekbar.setThumb(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.thumb_brightness));
      }
   }

   public final void bind(Device var1, Object var2) {
      Intrinsics.checkNotNullParameter(var1, "device");
      Intrinsics.checkNotNullParameter(var2, "brightness");
      Timber.Forest var4 = Timber.Forest;
      StringBuilder var5 = new StringBuilder("current offset: ");
      var5.append(this.brightnessSeekbar.getThumbOffset());
      var4.d(var5.toString(), new Object[0]);
      Integer var6;
      if (var2 instanceof Brightness) {
         var6 = ((Brightness)var2).toPercentage();
      } else {
         var6 = (Integer)var2;
      }

      int var3 = ((Number)var6).intValue();
      TextView var7 = this.brightnessPercentView;
      StringCompanionObject var8 = StringCompanionObject.INSTANCE;
      String var9 = String.format("%d %s", Arrays.copyOf(new Object[]{var3, "%"}, 2));
      Intrinsics.checkNotNullExpressionValue(var9, "format(...)");
      var7.setText((CharSequence)var9);
      this.updateThumb(var3);
      this.brightnessSeekbar.setProgress(var3);
      this.lastProgress = this.brightnessSeekbar.getProgress();
      this.brightnessSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(this, var1) {
         final Device $device;
         final DeviceScheduleBrightnessHolder this$0;

         {
            this.this$0 = var1;
            this.$device = var2;
         }

         public void onProgressChanged(SeekBar var1, int var2, boolean var3) {
            this.this$0.updateThumb(var2);
            if (BrightnessKt.hasBrightnessInPercent(this.$device)) {
               TextView var7 = this.this$0.brightnessPercentView;
               StringCompanionObject var9 = StringCompanionObject.INSTANCE;
               String var10 = String.format("%d %s", Arrays.copyOf(new Object[]{var2, "%"}, 2));
               Intrinsics.checkNotNullExpressionValue(var10, "format(...)");
               var7.setText((CharSequence)var10);
            } else {
               Brightness var5 = Brightness.Companion.fromPercentage(var2, this.this$0.isSlidingRight(var2));
               TextView var6 = this.this$0.brightnessPercentView;
               StringCompanionObject var4 = StringCompanionObject.INSTANCE;
               String var8 = String.format("%d %s", Arrays.copyOf(new Object[]{var5.toPercentage(), "%"}, 2));
               Intrinsics.checkNotNullExpressionValue(var8, "format(...)");
               var6.setText((CharSequence)var8);
            }
         }

         public void onStartTrackingTouch(SeekBar var1) {
         }

         public void onStopTrackingTouch(SeekBar var1) {
            this.this$0.onProgressSet(this.$device);
         }
      });
   }

   public final HolderDeviceBrightnessBinding getBinding() {
      return this.binding;
   }

   @Metadata(
      d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\n0\t¨\u0006\u000b"},
      d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceScheduleBrightnessHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceScheduleBrightnessHolder;", "parentView", "Landroid/view/ViewGroup;", "onBrightnessChanged", "Lkotlin/Function1;", "", "devicedetails_otherRelease"},
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

      public final DeviceScheduleBrightnessHolder newInstance(ViewGroup var1, Function1 var2) {
         Intrinsics.checkNotNullParameter(var1, "parentView");
         Intrinsics.checkNotNullParameter(var2, "onBrightnessChanged");
         HolderDeviceBrightnessBinding var3 = HolderDeviceBrightnessBinding.inflate(LayoutInflater.from(var1.getContext()), var1, false);
         Intrinsics.checkNotNullExpressionValue(var3, "inflate(...)");
         return new DeviceScheduleBrightnessHolder(var3, var2);
      }
   }
}
