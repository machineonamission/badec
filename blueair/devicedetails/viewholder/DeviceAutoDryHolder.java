package com.blueair.devicedetails.viewholder;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import com.blueair.core.model.Device;
import com.blueair.core.model.HasWick;
import com.blueair.devicedetails.databinding.HolderDeviceAutoDryBinding;
import com.blueair.viewcore.R;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(
   d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0011B+\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0010H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"},
   d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceAutoDryHolder;", "Lcom/blueair/devicedetails/viewholder/DeviceControlHolder;", "Lcom/blueair/devicedetails/databinding/HolderDeviceAutoDryBinding;", "binding", "onOpenInfoListener", "Lkotlin/Function0;", "", "onCancelListener", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceAutoDryBinding;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "update", "device", "Lcom/blueair/core/model/Device;", "forceOffline", "", "updateProgress", "Lcom/blueair/core/model/HasWick;", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceAutoDryHolder extends DeviceControlHolder {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final Function0 onCancelListener;
   private final Function0 onOpenInfoListener;

   public DeviceAutoDryHolder(HolderDeviceAutoDryBinding var1, Function0 var2, Function0 var3) {
      Intrinsics.checkNotNullParameter(var1, "binding");
      Intrinsics.checkNotNullParameter(var2, "onOpenInfoListener");
      Intrinsics.checkNotNullParameter(var3, "onCancelListener");
      super(var1);
      this.onOpenInfoListener = var2;
      this.onCancelListener = var3;
      var1.infoIcon.setOnClickListener(new DeviceAutoDryHolder$$ExternalSyntheticLambda0(this));
      var1.btnCancel.setOnClickListener(new DeviceAutoDryHolder$$ExternalSyntheticLambda1(this));
   }

   static final void lambda$2$lambda$0(DeviceAutoDryHolder var0, View var1) {
      var0.onOpenInfoListener.invoke();
   }

   static final void lambda$2$lambda$1(DeviceAutoDryHolder var0, View var1) {
      var0.onCancelListener.invoke();
   }

   private final void updateProgress(HasWick var1) {
      int var2 = var1.getWickDryLeftSeconds();
      ((HolderDeviceAutoDryBinding)this.getBinding()).progressIndicator.setProgress(RangesKt.coerceIn(var2 * 100 / 7200, 0, 100));
      int var3 = (int)Math.ceil((double)var2 / (double)60.0F);
      TextView var5 = ((HolderDeviceAutoDryBinding)this.getBinding()).tvLeft;
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

      HolderDeviceAutoDryBinding var4 = (HolderDeviceAutoDryBinding)this.getBinding();
      if (var1 instanceof HasWick) {
         if (var3) {
            var4.leadingIcon.setImageTintList(ColorStateList.valueOf(this.getColor(R.color.surface_dark_45)));
            var4.title.setTextColor(this.getColor(R.color.surface_dark_55));
            Group var9 = var4.expendedContent;
            Intrinsics.checkNotNullExpressionValue(var9, "expendedContent");
            ViewExtensionsKt.show((View)var9, false);
            var4.clContainer.setBackgroundResource(R.drawable.rounded_rectangle_white_r16_black5_stroke1_disabled_white_bg);
            return;
         }

         var4.leadingIcon.setImageTintList((ColorStateList)null);
         var4.title.setTextColor(this.getColor(R.color.colorPrimaryText));
         var4.clContainer.setBackgroundResource(R.drawable.rounded_rectangle_white_r16_black5_stroke1);
         var1 = var1;
         if (var1.getWickdryEnabled()) {
            if (var1.getWickdryOn()) {
               this.updateProgress(var1);
               Group var8 = var4.expendedContent;
               Intrinsics.checkNotNullExpressionValue(var8, "expendedContent");
               ViewExtensionsKt.show((View)var8, true);
               return;
            }

            Group var7 = var4.expendedContent;
            Intrinsics.checkNotNullExpressionValue(var7, "expendedContent");
            ViewExtensionsKt.show((View)var7, false);
            return;
         }

         Group var6 = var4.expendedContent;
         Intrinsics.checkNotNullExpressionValue(var6, "expendedContent");
         ViewExtensionsKt.show((View)var6, false);
      }

   }

   @Metadata(
      d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t¨\u0006\f"},
      d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceAutoDryHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceAutoDryHolder;", "parentView", "Landroid/view/ViewGroup;", "onOpenInfoListener", "Lkotlin/Function0;", "", "onCancelListener", "devicedetails_otherRelease"},
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

      public final DeviceAutoDryHolder newInstance(ViewGroup var1, Function0 var2, Function0 var3) {
         Intrinsics.checkNotNullParameter(var1, "parentView");
         Intrinsics.checkNotNullParameter(var2, "onOpenInfoListener");
         Intrinsics.checkNotNullParameter(var3, "onCancelListener");
         HolderDeviceAutoDryBinding var4 = HolderDeviceAutoDryBinding.inflate(LayoutInflater.from(var1.getContext()), var1, false);
         Intrinsics.checkNotNullExpressionValue(var4, "inflate(...)");
         return new DeviceAutoDryHolder(var4, var2, var3);
      }
   }
}
