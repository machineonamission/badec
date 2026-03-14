package com.blueair.devicedetails.viewholder;

import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import com.blueair.core.model.Device;
import com.blueair.core.model.HasNightLamp;
import com.blueair.devicedetails.databinding.HolderDeviceNightLampBinding;
import com.blueair.viewcore.R;
import com.blueair.viewcore.view.SwitchCompat;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\u0018\u0000 \u00192\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019BD\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\t¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0007H\u0016J\u000e\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\nR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0015R)\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"},
   d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceNightLampHolder;", "Lcom/blueair/devicedetails/viewholder/DeviceControlHolder;", "Lcom/blueair/devicedetails/databinding/HolderDeviceNightLampBinding;", "binding", "device", "Lcom/blueair/core/model/Device;", "isInSchedule", "", "onLampBrightnessSetListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "brightness", "", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceNightLampBinding;Lcom/blueair/core/model/Device;ZLkotlin/jvm/functions/Function1;)V", "getDevice", "()Lcom/blueair/core/model/Device;", "setDevice", "(Lcom/blueair/core/model/Device;)V", "()Z", "inTouch", "update", "forceOffline", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceNightLampHolder extends DeviceControlHolder {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private Device device;
   private boolean inTouch;
   private final boolean isInSchedule;
   private final Function1 onLampBrightnessSetListener;

   public DeviceNightLampHolder(HolderDeviceNightLampBinding var1, Device var2, boolean var3, Function1 var4) {
      Intrinsics.checkNotNullParameter(var1, "binding");
      Intrinsics.checkNotNullParameter(var4, "onLampBrightnessSetListener");
      super(var1);
      this.device = var2;
      this.isInSchedule = var3;
      this.onLampBrightnessSetListener = var4;
      var1.clickView.setOnClickListener(new DeviceNightLampHolder$$ExternalSyntheticLambda0(var1));
      var1.expendSwitch.setOnCheckedChangeListener(new DeviceNightLampHolder$$ExternalSyntheticLambda1(var1, this));
      var1.seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(this) {
         final DeviceNightLampHolder this$0;

         {
            this.this$0 = var1;
         }

         public void onProgressChanged(SeekBar var1, int var2, boolean var3) {
            Intrinsics.checkNotNullParameter(var1, "seekBar");
            this.this$0.update(var2);
         }

         public void onStartTrackingTouch(SeekBar var1) {
            Intrinsics.checkNotNullParameter(var1, "seekBar");
            this.this$0.inTouch = true;
         }

         public void onStopTrackingTouch(SeekBar var1) {
            Intrinsics.checkNotNullParameter(var1, "seekBar");
            this.this$0.inTouch = false;
            this.this$0.onLampBrightnessSetListener.invoke(var1.getProgress());
         }
      });
      var1.expendSwitch.setChecked(false);
   }

   static final void lambda$3$lambda$0(HolderDeviceNightLampBinding var0, View var1) {
      var0.expendSwitch.setChecked(var0.expendSwitch.isChecked() ^ true);
   }

   static final void lambda$3$lambda$2(HolderDeviceNightLampBinding var0, DeviceNightLampHolder var1, CompoundButton var2, boolean var3) {
      Group var4 = var0.expendedContent;
      Intrinsics.checkNotNullExpressionValue(var4, "expendedContent");
      ViewExtensionsKt.show((View)var4, var3 ^ true);
      if (!var1.isInSchedule && !var3) {
         Device var5 = var1.device;
         if (var5 != null) {
            var1.update(var5, false);
         }
      }

   }

   public final Device getDevice() {
      return this.device;
   }

   public final boolean isInSchedule() {
      return this.isInSchedule;
   }

   public final void setDevice(Device var1) {
      this.device = var1;
   }

   public final void update(int var1) {
      ((HolderDeviceNightLampBinding)this.getBinding()).seekbar.setProgress(var1);
      if (var1 <= 0) {
         ((HolderDeviceNightLampBinding)this.getBinding()).progressText.setText(R.string.light_gear_off);
      } else {
         TextView var2 = ((HolderDeviceNightLampBinding)this.getBinding()).progressText;
         StringBuilder var3 = new StringBuilder();
         var3.append(var1);
         var3.append('%');
         var2.setText((CharSequence)var3.toString());
      }
   }

   public void update(Device var1, boolean var2) {
      Intrinsics.checkNotNullParameter(var1, "device");
      if (!this.inTouch) {
         this.device = var1;
         if (var1 instanceof HasNightLamp) {
            this.update(((HasNightLamp)var1).getNightLampSteplessBrightness());
         }

         if (!var2 && var1.isOnline()) {
            HolderDeviceNightLampBinding var5 = (HolderDeviceNightLampBinding)this.getBinding();
            var5.clickView.setEnabled(true);
            var5.expendSwitch.setEnabled(true);
            var5.contentContainer.setEnabled(true);
            var5.leadingIcon.setImageTintList((ColorStateList)null);
            var5.title.setTextColor(this.getColor(R.color.colorPrimaryText));
            SwitchCompat var6 = var5.expendSwitch;
            Intrinsics.checkNotNullExpressionValue(var6, "expendSwitch");
            ViewExtensionsKt.show((View)var6, true);
         } else {
            HolderDeviceNightLampBinding var4 = (HolderDeviceNightLampBinding)this.getBinding();
            var4.clickView.setEnabled(false);
            var4.expendSwitch.setEnabled(false);
            var4.expendSwitch.setChecked(true);
            SwitchCompat var3 = var4.expendSwitch;
            Intrinsics.checkNotNullExpressionValue(var3, "expendSwitch");
            ViewExtensionsKt.show((View)var3, false);
            var4.contentContainer.setEnabled(false);
            var4.leadingIcon.setImageTintList(ColorStateList.valueOf(this.getColor(R.color.surface_dark_45)));
            var4.title.setTextColor(this.getColor(R.color.surface_dark_55));
            var4.progressText.setText((CharSequence)"");
         }
      }
   }

   @Metadata(
      d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JC\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2!\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\r¨\u0006\u0013"},
      d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceNightLampHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceNightLampHolder;", "parentView", "Landroid/view/ViewGroup;", "device", "Lcom/blueair/core/model/Device;", "isInSchedule", "", "onLampBrightnessSetListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "brightness", "", "devicedetails_otherRelease"},
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

      public final DeviceNightLampHolder newInstance(ViewGroup var1, Device var2, boolean var3, Function1 var4) {
         Intrinsics.checkNotNullParameter(var1, "parentView");
         Intrinsics.checkNotNullParameter(var4, "onLampBrightnessSetListener");
         HolderDeviceNightLampBinding var5 = HolderDeviceNightLampBinding.inflate(LayoutInflater.from(var1.getContext()), var1, false);
         Intrinsics.checkNotNullExpressionValue(var5, "inflate(...)");
         return new DeviceNightLampHolder(var5, var2, var3, var4);
      }
   }
}
