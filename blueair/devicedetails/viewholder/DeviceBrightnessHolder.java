package com.blueair.devicedetails.viewholder;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.blueair.core.model.Brightness;
import com.blueair.core.model.BrightnessKt;
import com.blueair.core.model.ConnectivityStatus;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceAware;
import com.blueair.core.model.DeviceB4;
import com.blueair.core.model.DeviceB4sp;
import com.blueair.core.model.DeviceBlue;
import com.blueair.core.model.DeviceG4;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.HasBrightness;
import com.blueair.core.model.HasG4NightMode;
import com.blueair.core.model.HasStandBy;
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
   d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000  2\u00020\u0001:\u0001 B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\tH\u0002J\u0010\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\tH\u0002J\u0010\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0018H\u0002J\u0010\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0018H\u0002J\u0010\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0018H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"},
   d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceBrightnessHolder;", "Lcom/blueair/devicedetails/viewholder/DeviceAttributeHolder;", "binding", "Lcom/blueair/devicedetails/databinding/HolderDeviceBrightnessBinding;", "onBrightnessSetListener", "Lkotlin/Function1;", "Lcom/blueair/core/model/Brightness;", "", "onBrightnessIntSetListener", "", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceBrightnessBinding;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getBinding", "()Lcom/blueair/devicedetails/databinding/HolderDeviceBrightnessBinding;", "brightnessSeekbar", "Lcom/blueair/viewcore/view/AccessibleSeekBar;", "brightnessPercentView", "Landroid/widget/TextView;", "titleView", "lastProgress", "onProgressSet", "device", "Lcom/blueair/core/model/HasBrightness;", "update", "Lcom/blueair/core/model/Device;", "isSlidingRight", "", "progress", "updateThumb", "setOnline", "setOffline", "initializeBrightnessState", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceBrightnessHolder extends DeviceAttributeHolder {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final HolderDeviceBrightnessBinding binding;
   private final TextView brightnessPercentView;
   private final AccessibleSeekBar brightnessSeekbar;
   private int lastProgress;
   private final Function1 onBrightnessIntSetListener;
   private final Function1 onBrightnessSetListener;
   private final TextView titleView;

   // $FF: synthetic method
   public static void $r8$lambda$e7rzhpio56W1vFqJTdKa4rF0iPU(DeviceBrightnessHolder var0, Brightness var1) {
      onProgressSet$lambda$1(var0, var1);
   }

   public DeviceBrightnessHolder(HolderDeviceBrightnessBinding var1, Function1 var2, Function1 var3) {
      Intrinsics.checkNotNullParameter(var1, "binding");
      Intrinsics.checkNotNullParameter(var2, "onBrightnessSetListener");
      Intrinsics.checkNotNullParameter(var3, "onBrightnessIntSetListener");
      ConstraintLayout var4 = var1.getRoot();
      Intrinsics.checkNotNullExpressionValue(var4, "getRoot(...)");
      super((View)var4);
      this.binding = var1;
      this.onBrightnessSetListener = var2;
      this.onBrightnessIntSetListener = var3;
      AccessibleSeekBar var10 = var1.brightnessSeekbar;
      Intrinsics.checkNotNullExpressionValue(var10, "brightnessSeekbar");
      this.brightnessSeekbar = var10;
      TextView var11 = var1.settingValue;
      Intrinsics.checkNotNullExpressionValue(var11, "settingValue");
      this.brightnessPercentView = var11;
      TextView var5 = var1.settingTitle;
      Intrinsics.checkNotNullExpressionValue(var5, "settingTitle");
      this.titleView = var5;
      Drawable var6 = var10.getProgressDrawable();
      LayerDrawable var7;
      if (var6 instanceof LayerDrawable) {
         var7 = (LayerDrawable)var6;
      } else {
         var7 = null;
      }

      if (var7 != null) {
         Drawable var8 = var7.findDrawableByLayerId(16908301);
         if (var8 != null) {
            var8 = var8.mutate();
            if (var8 != null) {
               var8.setTint(ContextCompat.getColor(this.itemView.getContext(), R.color.colorPrimary));
            }
         }
      }

   }

   private final void initializeBrightnessState(Device var1) {
      if (var1 instanceof HasBrightness) {
         var1 = var1;
         int var2;
         if (!(var1 instanceof DeviceG4) && !(var1 instanceof DeviceB4) && !(var1 instanceof DeviceB4sp) && !(var1 instanceof DeviceBlue) && !(var1 instanceof DeviceAware)) {
            var2 = var1.getBrightnessEnum().toPercentage();
         } else {
            var2 = var1.getBrightness();
         }

         TextView var5 = this.brightnessPercentView;
         StringCompanionObject var3 = StringCompanionObject.INSTANCE;
         String var6 = String.format("%d %s", Arrays.copyOf(new Object[]{var2, "%"}, 2));
         Intrinsics.checkNotNullExpressionValue(var6, "format(...)");
         var5.setText((CharSequence)var6);
         this.updateThumb(var2);
         this.brightnessSeekbar.setProgress(var2);
         this.lastProgress = this.brightnessSeekbar.getProgress();
      }

   }

   private final boolean isSlidingRight(int var1) {
      return this.lastProgress < var1;
   }

   private final void onProgressSet(HasBrightness var1) {
      int var2 = this.brightnessSeekbar.getProgress();
      Timber.Forest var4 = Timber.Forest;
      StringBuilder var3 = new StringBuilder("progress before snap: ");
      var3.append(var2);
      var4.e(var3.toString(), new Object[0]);
      if (BrightnessKt.hasBrightnessInPercent(var1)) {
         this.updateThumb(var2);
         Timber.Forest.d("brightness seekbar:  progress = %d", new Object[]{this.brightnessSeekbar.getProgress()});
         this.onBrightnessIntSetListener.invoke(var2);
      } else {
         Brightness var5 = Brightness.Companion.fromPercentage(var2, this.isSlidingRight(var2));
         this.updateThumb(var5.toPercentage());
         this.brightnessSeekbar.postDelayed(new DeviceBrightnessHolder$$ExternalSyntheticLambda0(this, var5), (long)ViewConfiguration.getTapTimeout());
         Timber.Forest.d("brightness seekbar:  progress = %d, brightness = %s, direction: %s", new Object[]{var2, var5, this.isSlidingRight(var2)});
         this.onBrightnessSetListener.invoke(var5);
      }

      this.lastProgress = this.brightnessSeekbar.getProgress();
   }

   private static final void onProgressSet$lambda$1(DeviceBrightnessHolder var0, Brightness var1) {
      var0.brightnessSeekbar.setProgress(var1.toPercentage());
      Timber.Forest var2 = Timber.Forest;
      StringBuilder var3 = new StringBuilder("progress after snap: ");
      var3.append(var0.brightnessSeekbar.getProgress());
      var2.e(var3.toString(), new Object[0]);
   }

   private final void setOffline(Device var1) {
      this.brightnessPercentView.setTextColor(ContextCompat.getColor(this.itemView.getContext(), R.color.smokegray));
      this.titleView.setTextColor(ContextCompat.getColor(this.itemView.getContext(), R.color.smokegray));
      this.brightnessSeekbar.setAlpha(0.5F);
      this.brightnessSeekbar.setEnabled(false);
      this.initializeBrightnessState(var1);
   }

   private final void setOnline(Device var1) {
      this.brightnessPercentView.setTextColor(ContextCompat.getColor(this.itemView.getContext(), R.color.colorPrimary));
      this.titleView.setTextColor(ContextCompat.getColor(this.itemView.getContext(), R.color.marineblue));
      this.brightnessSeekbar.setAlpha(1.0F);
      this.brightnessSeekbar.setEnabled(true);
      this.initializeBrightnessState(var1);
   }

   private final void updateThumb(int var1) {
   }

   public final HolderDeviceBrightnessBinding getBinding() {
      return this.binding;
   }

   public void update(Device var1) {
      Intrinsics.checkNotNullParameter(var1, "device");
      if (var1 instanceof HasBrightness) {
         Timber.Forest var3 = Timber.Forest;
         StringBuilder var2 = new StringBuilder("current offset: ");
         var2.append(this.brightnessSeekbar.getThumbOffset());
         var3.d(var2.toString(), new Object[0]);
         this.initializeBrightnessState(var1);
         if (var1.getConnectivityStatus() != ConnectivityStatus.ONLINE) {
            this.setOffline(var1);
         } else if ((!(var1 instanceof HasStandBy) || !((HasStandBy)var1).isStandByOn()) && (!(var1 instanceof HasG4NightMode) || !((HasG4NightMode)var1).isG4NightModeOn()) && !DeviceKt.isDisinfectionOn(var1)) {
            this.setOnline(var1);
         } else {
            this.setOffline(var1);
         }

         this.brightnessSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(this, var1) {
            final Device $device;
            final DeviceBrightnessHolder this$0;

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
               this.this$0.onProgressSet((HasBrightness)this.$device);
            }
         });
      }

   }

   @Metadata(
      d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J6\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000b0\t¨\u0006\u000e"},
      d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceBrightnessHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceBrightnessHolder;", "parentView", "Landroid/view/ViewGroup;", "onBrightnessSetListener", "Lkotlin/Function1;", "Lcom/blueair/core/model/Brightness;", "", "onBrightnessIntSetListener", "", "devicedetails_otherRelease"},
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

      public final DeviceBrightnessHolder newInstance(ViewGroup var1, Function1 var2, Function1 var3) {
         Intrinsics.checkNotNullParameter(var1, "parentView");
         Intrinsics.checkNotNullParameter(var2, "onBrightnessSetListener");
         Intrinsics.checkNotNullParameter(var3, "onBrightnessIntSetListener");
         HolderDeviceBrightnessBinding var4 = HolderDeviceBrightnessBinding.inflate(LayoutInflater.from(var1.getContext()), var1, false);
         Intrinsics.checkNotNullExpressionValue(var4, "inflate(...)");
         return new DeviceBrightnessHolder(var4, var2, var3);
      }
   }
}
