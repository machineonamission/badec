package com.blueair.devicedetails.viewholder;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.Group;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.HasHumMainMode;
import com.blueair.core.model.HasWick;
import com.blueair.core.model.HasWickDryDuration;
import com.blueair.core.model.MainMode;
import com.blueair.core.model.WickDryingGear;
import com.blueair.devicedetails.databinding.HolderDeviceWickDryingBinding;
import com.blueair.viewcore.R;
import com.blueair.viewcore.view.SwitchCompat;
import com.google.android.material.progressindicator.LinearProgressIndicator;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(
   d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0014B9\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\b0\n¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0005H\u0016J\u0010\u0010\u0013\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000eR\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"},
   d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceWickDryingHolder;", "Lcom/blueair/devicedetails/viewholder/DeviceControlHolder;", "Lcom/blueair/devicedetails/databinding/HolderDeviceWickDryingBinding;", "binding", "isInSchedule", "", "onOpenInfoListener", "Lkotlin/Function0;", "", "onChangeListener", "Lkotlin/Function1;", "Lcom/blueair/core/model/WickDryingGear;", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceWickDryingBinding;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "()Z", "device", "Lcom/blueair/core/model/Device;", "update", "forceOffline", "updateProgress", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceWickDryingHolder extends DeviceControlHolder {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private Device device;
   private final boolean isInSchedule;
   private final Function1 onChangeListener;
   private final Function0 onOpenInfoListener;

   public DeviceWickDryingHolder(HolderDeviceWickDryingBinding var1, boolean var2, Function0 var3, Function1 var4) {
      Intrinsics.checkNotNullParameter(var1, "binding");
      Intrinsics.checkNotNullParameter(var3, "onOpenInfoListener");
      Intrinsics.checkNotNullParameter(var4, "onChangeListener");
      super(var1);
      this.isInSchedule = var2;
      this.onOpenInfoListener = var3;
      this.onChangeListener = var4;
      var1.expendSwitch.setOnCheckedChangeListener(new DeviceWickDryingHolder$$ExternalSyntheticLambda0(var1, this));
      var1.ivInfo.setOnClickListener(new DeviceWickDryingHolder$$ExternalSyntheticLambda1(this));
      var1.btnLow.setOnClickListener(new DeviceWickDryingHolder$$ExternalSyntheticLambda2(var1, this));
      var1.btnHigh.setOnClickListener(new DeviceWickDryingHolder$$ExternalSyntheticLambda3(var1, this));
      var1.ivInfo.setContentDescription((CharSequence)var1.getRoot().getContext().getString(R.string.more_info_about, new Object[]{var1.title.getText()}));
   }

   static final void lambda$7$lambda$1(HolderDeviceWickDryingBinding var0, DeviceWickDryingHolder var1, CompoundButton var2, boolean var3) {
      Group var4 = var0.expendedContent;
      Intrinsics.checkNotNullExpressionValue(var4, "expendedContent");
      ViewExtensionsKt.show((View)var4, var3);
      if (!var1.isInSchedule) {
         Device var5 = var1.device;
         HasWickDryDuration var6;
         if (var5 instanceof HasWickDryDuration) {
            var6 = (HasWickDryDuration)var5;
         } else {
            var6 = null;
         }

         if (var6 != null) {
            if (var3) {
               WickDryingGear var8 = WickDryingGear.Companion.fromDuration(var6.getWickdryDuration());
               WickDryingGear var7 = var8;
               if (var8 == WickDryingGear.OFF) {
                  var7 = WickDryingGear.HIGH;
               }

               var1.onChangeListener.invoke(var7);
               return;
            }

            var1.onChangeListener.invoke(WickDryingGear.OFF);
         }
      }

   }

   static final void lambda$7$lambda$2(DeviceWickDryingHolder var0, View var1) {
      var0.onOpenInfoListener.invoke();
   }

   static final void lambda$7$lambda$4(HolderDeviceWickDryingBinding var0, DeviceWickDryingHolder var1, View var2) {
      if (!var0.btnLow.isChecked()) {
         Device var3 = var1.device;
         HasWickDryDuration var4;
         if (var3 instanceof HasWickDryDuration) {
            var4 = (HasWickDryDuration)var3;
         } else {
            var4 = null;
         }

         if (var4 != null) {
            var1.onChangeListener.invoke(WickDryingGear.LOW);
         }
      }

   }

   static final void lambda$7$lambda$6(HolderDeviceWickDryingBinding var0, DeviceWickDryingHolder var1, View var2) {
      if (!var0.btnHigh.isChecked()) {
         Device var3 = var1.device;
         HasWickDryDuration var4;
         if (var3 instanceof HasWickDryDuration) {
            var4 = (HasWickDryDuration)var3;
         } else {
            var4 = null;
         }

         if (var4 != null) {
            var1.onChangeListener.invoke(WickDryingGear.HIGH);
         }
      }

   }

   private final void updateProgress(Device var1) {
      if (var1 instanceof HasWickDryDuration && var1 instanceof HasWick) {
         SwitchCompat var7 = ((HolderDeviceWickDryingBinding)this.getBinding()).expendSwitch;
         HasWick var6 = (HasWick)var1;
         var7.setCheckedSilence(var6.getWickdryOn());
         Group var15 = ((HolderDeviceWickDryingBinding)this.getBinding()).expendedContent;
         Intrinsics.checkNotNullExpressionValue(var15, "expendedContent");
         ViewExtensionsKt.show((View)var15, ((HolderDeviceWickDryingBinding)this.getBinding()).expendSwitch.isChecked());
         int var4 = ((HasWickDryDuration)var1).getWickdryDuration();
         int var3 = var6.getWickDryLeftSeconds();
         LinearProgressIndicator var8 = ((HolderDeviceWickDryingBinding)this.getBinding()).progressIndicator;
         int var2;
         if (var4 == 0) {
            var2 = 0;
         } else {
            var2 = RangesKt.coerceIn(var3 * 100 / var4, 0, 100);
         }

         var8.setProgress(var2);
         boolean var5;
         if (WickDryingGear.Companion.fromDuration(var4) == WickDryingGear.LOW) {
            var5 = true;
         } else {
            var5 = false;
         }

         ((HolderDeviceWickDryingBinding)this.getBinding()).btnLow.setChecked(var5);
         ((HolderDeviceWickDryingBinding)this.getBinding()).btnHigh.setChecked(var5 ^ true);
         AppCompatTextView var9 = ((HolderDeviceWickDryingBinding)this.getBinding()).tvDuration;
         if (var5) {
            var2 = R.string.time_duration_low;
         } else {
            var2 = R.string.time_duration_high;
         }

         var9.setText(var2);
         var3 = (int)Math.ceil((double)var3 / (double)60.0F);
         AppCompatTextView var14 = ((HolderDeviceWickDryingBinding)this.getBinding()).tvLeft;
         Context var10 = var14.getContext();
         if (var3 > 1) {
            var2 = R.string.disinfection_left_time;
         } else {
            var2 = R.string.disinfection_left_time_1min;
         }

         var14.setText((CharSequence)var10.getString(var2, new Object[]{String.valueOf(var3)}));
      }

   }

   public final boolean isInSchedule() {
      return this.isInSchedule;
   }

   public void update(Device var1, boolean var2) {
      Intrinsics.checkNotNullParameter(var1, "device");
      this.device = var1;
      boolean var3 = false;
      if (!var2 && var1.isOnline() && DeviceKt.isSafetySwitchOn(var1)) {
         SwitchCompat var5;
         HolderDeviceWickDryingBinding var9;
         label20: {
            var9 = (HolderDeviceWickDryingBinding)this.getBinding();
            var9.title.setTextColor(this.getColor(R.color.colorPrimaryText));
            var9.contentContainer.setEnabled(true);
            var9.leadingIcon.setImageTintList((ColorStateList)null);
            var9.btnHigh.setChecked(true);
            this.updateProgress(var1);
            var5 = var9.expendSwitch;
            if (!DeviceKt.isStandByOn(var1) && !var9.expendSwitch.isChecked() && var1 instanceof HasHumMainMode) {
               var2 = var3;
               if (((HasHumMainMode)var1).isInMainMode(MainMode.AirPurify)) {
                  break label20;
               }
            }

            var2 = true;
         }

         var5.setEnabled(var2);
         SwitchCompat var7 = var9.expendSwitch;
         Intrinsics.checkNotNullExpressionValue(var7, "expendSwitch");
         ViewExtensionsKt.show((View)var7, true);
      } else {
         HolderDeviceWickDryingBinding var4 = (HolderDeviceWickDryingBinding)this.getBinding();
         var4.expendSwitch.setChecked(false);
         var4.expendSwitch.setEnabled(false);
         SwitchCompat var6 = var4.expendSwitch;
         Intrinsics.checkNotNullExpressionValue(var6, "expendSwitch");
         ViewExtensionsKt.show((View)var6, true);
         var4.contentContainer.setEnabled(false);
         var4.leadingIcon.setImageTintList(ColorStateList.valueOf(this.getColor(R.color.surface_dark_45)));
         var4.title.setTextColor(this.getColor(R.color.surface_dark_55));
      }
   }

   @Metadata(
      d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J8\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\f0\u000e¨\u0006\u0010"},
      d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceWickDryingHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceWickDryingHolder;", "parentView", "Landroid/view/ViewGroup;", "isInSchedule", "", "onOpenInfoListener", "Lkotlin/Function0;", "", "onChangeListener", "Lkotlin/Function1;", "Lcom/blueair/core/model/WickDryingGear;", "devicedetails_otherRelease"},
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

      public final DeviceWickDryingHolder newInstance(ViewGroup var1, boolean var2, Function0 var3, Function1 var4) {
         Intrinsics.checkNotNullParameter(var1, "parentView");
         Intrinsics.checkNotNullParameter(var3, "onOpenInfoListener");
         Intrinsics.checkNotNullParameter(var4, "onChangeListener");
         HolderDeviceWickDryingBinding var5 = HolderDeviceWickDryingBinding.inflate(LayoutInflater.from(var1.getContext()), var1, false);
         Intrinsics.checkNotNullExpressionValue(var5, "inflate(...)");
         return new DeviceWickDryingHolder(var5, var2, var3, var4);
      }
   }
}
