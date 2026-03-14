package com.blueair.devicedetails.viewholder;

import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.HasWaterLevel;
import com.blueair.core.model.HasWaterTank;
import com.blueair.core.model.WaterLevel;
import com.blueair.devicedetails.databinding.HolderDeviceHumidificationBinding;
import com.blueair.viewcore.R;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0014B5\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J\u001e\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0005J\u0016\u0010\r\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"},
   d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceHumidificationHolder;", "Lcom/blueair/devicedetails/viewholder/DeviceControlHolder;", "Lcom/blueair/devicedetails/databinding/HolderDeviceHumidificationBinding;", "binding", "inSchedule", "", "onModeChangeListener", "Lkotlin/Function0;", "", "onCloseHintListener", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceHumidificationBinding;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "hintClosedBefore", "update", "device", "Lcom/blueair/core/model/Device;", "forceOffline", "closedBefore", "humMode", "inactive", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceHumidificationHolder extends DeviceControlHolder {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private boolean hintClosedBefore;
   private final boolean inSchedule;
   private final Function0 onCloseHintListener;
   private final Function0 onModeChangeListener;

   public DeviceHumidificationHolder(HolderDeviceHumidificationBinding var1, boolean var2, Function0 var3, Function0 var4) {
      Intrinsics.checkNotNullParameter(var1, "binding");
      Intrinsics.checkNotNullParameter(var3, "onModeChangeListener");
      super(var1);
      this.inSchedule = var2;
      this.onModeChangeListener = var3;
      this.onCloseHintListener = var4;
      var1.hintContainer.btnCloseHint.setOnClickListener(new DeviceHumidificationHolder$$ExternalSyntheticLambda0(this));
      var1.switchMode.setOnCheckedChangeListener(new DeviceHumidificationHolder$$ExternalSyntheticLambda1(this));
   }

   static final void lambda$2$lambda$0(DeviceHumidificationHolder var0, View var1) {
      Function0 var2 = var0.onCloseHintListener;
      if (var2 != null) {
         var2.invoke();
      }

   }

   static final void lambda$2$lambda$1(DeviceHumidificationHolder var0, CompoundButton var1, boolean var2) {
      var0.onModeChangeListener.invoke();
   }

   public void update(Device var1, boolean var2) {
      Intrinsics.checkNotNullParameter(var1, "device");
      boolean var5 = var1 instanceof HasWaterLevel;
      boolean var6 = true;
      boolean var3;
      if (var5 && ((HasWaterLevel)var1).isInWaterLevel(WaterLevel.SHORTAGE)) {
         var3 = true;
      } else {
         var3 = false;
      }

      boolean var4;
      if (var1 instanceof HasWaterTank && ((HasWaterTank)var1).getWaterTankFailure()) {
         var4 = true;
      } else {
         var4 = false;
      }

      if (DeviceKt.isHumidifyModeOn(var1) || !var3 && !var4) {
         var3 = false;
      } else {
         var3 = true;
      }

      var5 = var6;
      if (!var2) {
         var5 = var6;
         if (var1.isOnline()) {
            var5 = var6;
            if (!DeviceKt.isStandByOn(var1)) {
               if (var3) {
                  var5 = var6;
               } else {
                  var5 = false;
               }
            }
         }
      }

      this.update(DeviceKt.isHumidifyModeOn(var1), var5);
   }

   public final void update(Device var1, boolean var2, boolean var3) {
      Intrinsics.checkNotNullParameter(var1, "device");
      this.hintClosedBefore = var3;
      this.update(var1, var2);
   }

   public final void update(boolean var1, boolean var2) {
      HolderDeviceHumidificationBinding var4 = (HolderDeviceHumidificationBinding)this.getBinding();
      boolean var3 = false;
      if (var2) {
         var4.title.setTextColor(this.getColor(R.color.surface_dark_55));
         ConstraintLayout var5 = var4.hintContainer.getRoot();
         Intrinsics.checkNotNullExpressionValue(var5, "getRoot(...)");
         ViewExtensionsKt.show((View)var5, false);
         var4.switchMode.setEnabled(false);
         var4.leadingIcon.setImageTintList(ColorStateList.valueOf(this.getColor(R.color.surface_dark_45)));
         var4.clContainer.setBackgroundResource(R.drawable.rounded_rectangle_white_r16_black5_stroke1_disabled_white_bg);
      } else {
         var4.title.setTextColor(this.getColor(R.color.colorPrimaryText));
         var4.clContainer.setBackgroundResource(R.drawable.rounded_rectangle_white_r16_black5_stroke1);
         var4.leadingIcon.setImageTintList((ColorStateList)null);
         var4.hintContainer.hintText.setText((CharSequence)this.itemView.getContext().getString(R.string.humidification_mode_hint));
         ConstraintLayout var7 = var4.hintContainer.getRoot();
         Intrinsics.checkNotNullExpressionValue(var7, "getRoot(...)");
         View var8 = (View)var7;
         var2 = var3;
         if (!this.hintClosedBefore) {
            var2 = var3;
            if (!this.inSchedule) {
               var2 = var3;
               if (var1) {
                  var2 = true;
               }
            }
         }

         ViewExtensionsKt.show(var8, var2);
         var4.switchMode.setEnabled(true);
      }

      var4.switchMode.setCheckedSilence(var1);
   }

   @Metadata(
      d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J8\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¨\u0006\u000e"},
      d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceHumidificationHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceHumidificationHolder;", "parentView", "Landroid/view/ViewGroup;", "inSchedule", "", "onModeChangeListener", "Lkotlin/Function0;", "", "onClosePromptListener", "devicedetails_otherRelease"},
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

      // $FF: synthetic method
      public static DeviceHumidificationHolder newInstance$default(Companion var0, ViewGroup var1, boolean var2, Function0 var3, Function0 var4, int var5, Object var6) {
         if ((var5 & 2) != 0) {
            var2 = false;
         }

         if ((var5 & 8) != 0) {
            var4 = null;
         }

         return var0.newInstance(var1, var2, var3, var4);
      }

      public final DeviceHumidificationHolder newInstance(ViewGroup var1, boolean var2, Function0 var3, Function0 var4) {
         Intrinsics.checkNotNullParameter(var1, "parentView");
         Intrinsics.checkNotNullParameter(var3, "onModeChangeListener");
         HolderDeviceHumidificationBinding var5 = HolderDeviceHumidificationBinding.inflate(LayoutInflater.from(var1.getContext()), var1, false);
         Intrinsics.checkNotNullExpressionValue(var5, "inflate(...)");
         return new DeviceHumidificationHolder(var5, var2, var3, var4);
      }
   }
}
