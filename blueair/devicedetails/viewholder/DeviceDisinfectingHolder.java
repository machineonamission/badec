package com.blueair.devicedetails.viewholder;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.blueair.core.model.Device;
import com.blueair.core.model.HasDisinfection;
import com.blueair.devicedetails.databinding.HolderDeviceDisinfectingBinding;
import com.blueair.devicedetails.util.DisinfectionUtils;
import com.blueair.viewcore.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(
   d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0010B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000fH\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"},
   d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceDisinfectingHolder;", "Lcom/blueair/devicedetails/viewholder/DeviceControlHolder;", "Lcom/blueair/devicedetails/databinding/HolderDeviceDisinfectingBinding;", "binding", "onOpenInfoListener", "Lkotlin/Function0;", "", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceDisinfectingBinding;Lkotlin/jvm/functions/Function0;)V", "update", "device", "Lcom/blueair/core/model/Device;", "forceOffline", "", "updateProgress", "Lcom/blueair/core/model/HasDisinfection;", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceDisinfectingHolder extends DeviceControlHolder {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final Function0 onOpenInfoListener;

   public DeviceDisinfectingHolder(HolderDeviceDisinfectingBinding var1, Function0 var2) {
      Intrinsics.checkNotNullParameter(var1, "binding");
      Intrinsics.checkNotNullParameter(var2, "onOpenInfoListener");
      super(var1);
      this.onOpenInfoListener = var2;
      var1.infoIcon.setOnClickListener(new DeviceDisinfectingHolder$$ExternalSyntheticLambda0(this));
   }

   static final void lambda$1$lambda$0(DeviceDisinfectingHolder var0, View var1) {
      var0.onOpenInfoListener.invoke();
   }

   private final void updateProgress(HasDisinfection var1) {
      int var2 = DisinfectionUtils.INSTANCE.getLeftSeconds(var1);
      ((HolderDeviceDisinfectingBinding)this.getBinding()).progressIndicator.setProgress(RangesKt.coerceIn(var2 * 100 / 7200, 0, 100));
      int var3 = (int)Math.ceil((double)var2 / (double)60.0F);
      TextView var5 = ((HolderDeviceDisinfectingBinding)this.getBinding()).tvLeft;
      Context var4 = var5.getContext();
      if (var3 > 1) {
         var2 = R.string.disinfection_left_time;
      } else {
         var2 = R.string.disinfection_left_time_1min;
      }

      var5.setText((CharSequence)var4.getString(var2, new Object[]{String.valueOf(var3)}));
   }

   public void update(Device var1, boolean var2) {
      Intrinsics.checkNotNullParameter(var1, "device");
      boolean var3;
      if (!var2 && var1.isOnline()) {
         var3 = false;
      } else {
         var3 = true;
      }

      HolderDeviceDisinfectingBinding var4 = (HolderDeviceDisinfectingBinding)this.getBinding();
      if (var1 instanceof HasDisinfection) {
         if (var3) {
            var4.leadingIcon.setImageTintList(ColorStateList.valueOf(this.getColor(R.color.surface_dark_45)));
            var4.title.setTextColor(this.getColor(R.color.surface_dark_55));
            var4.clContainer.setBackgroundResource(R.drawable.rounded_rectangle_white_r16_black5_stroke1_disabled_white_bg);
            return;
         }

         var4.leadingIcon.setImageTintList((ColorStateList)null);
         var4.title.setTextColor(this.getColor(R.color.colorPrimaryText));
         var4.clContainer.setBackgroundResource(R.drawable.rounded_rectangle_white_r16_black5_stroke1);
         this.updateProgress((HasDisinfection)var1);
      }

   }

   @Metadata(
      d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¨\u0006\u000b"},
      d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceDisinfectingHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceDisinfectingHolder;", "parentView", "Landroid/view/ViewGroup;", "onOpenInfoListener", "Lkotlin/Function0;", "", "devicedetails_otherRelease"},
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

      public final DeviceDisinfectingHolder newInstance(ViewGroup var1, Function0 var2) {
         Intrinsics.checkNotNullParameter(var1, "parentView");
         Intrinsics.checkNotNullParameter(var2, "onOpenInfoListener");
         HolderDeviceDisinfectingBinding var3 = HolderDeviceDisinfectingBinding.inflate(LayoutInflater.from(var1.getContext()), var1, false);
         Intrinsics.checkNotNullExpressionValue(var3, "inflate(...)");
         return new DeviceDisinfectingHolder(var3, var2);
      }
   }
}
