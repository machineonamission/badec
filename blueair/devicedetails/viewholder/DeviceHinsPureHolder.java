package com.blueair.devicedetails.viewholder;

import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.HasG4NightMode;
import com.blueair.core.model.HasHinsMode;
import com.blueair.devicedetails.databinding.HolderDeviceHinsPureBinding;
import com.blueair.viewcore.R;
import com.blueair.viewcore.view.SwitchCompat;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0010B3\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"},
   d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceHinsPureHolder;", "Lcom/blueair/devicedetails/viewholder/DeviceControlHolder;", "Lcom/blueair/devicedetails/databinding/HolderDeviceHinsPureBinding;", "binding", "nightMode", "", "onInfoClickListener", "Lkotlin/Function0;", "", "onModeChangeListener", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceHinsPureBinding;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "update", "device", "Lcom/blueair/core/model/Device;", "forceOffline", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceHinsPureHolder extends DeviceControlHolder {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final boolean nightMode;
   private final Function0 onInfoClickListener;
   private final Function0 onModeChangeListener;

   public DeviceHinsPureHolder(HolderDeviceHinsPureBinding var1, boolean var2, Function0 var3, Function0 var4) {
      Intrinsics.checkNotNullParameter(var1, "binding");
      Intrinsics.checkNotNullParameter(var3, "onInfoClickListener");
      Intrinsics.checkNotNullParameter(var4, "onModeChangeListener");
      super(var1);
      this.nightMode = var2;
      this.onInfoClickListener = var3;
      this.onModeChangeListener = var4;
      var1.ivInfo.setOnClickListener(new DeviceHinsPureHolder$$ExternalSyntheticLambda0(this));
      var1.switchMode.setOnCheckedChangeListener(new DeviceHinsPureHolder$$ExternalSyntheticLambda1(this));
      var1.ivInfo.setContentDescription((CharSequence)var1.getRoot().getContext().getString(R.string.more_info_about, new Object[]{var1.title.getText()}));
   }

   static final void lambda$2$lambda$0(DeviceHinsPureHolder var0, View var1) {
      var0.onInfoClickListener.invoke();
   }

   static final void lambda$2$lambda$1(DeviceHinsPureHolder var0, CompoundButton var1, boolean var2) {
      var0.onModeChangeListener.invoke();
   }

   public void update(Device var1, boolean var2) {
      Intrinsics.checkNotNullParameter(var1, "device");
      boolean var3;
      if (var2 || !var1.isOnline() || DeviceKt.isStandByOn(var1) || !this.nightMode && var1 instanceof HasG4NightMode && ((HasG4NightMode)var1).isG4NightModeOn()) {
         var3 = 1;
      } else {
         var3 = 0;
      }

      HolderDeviceHinsPureBinding var5 = (HolderDeviceHinsPureBinding)this.getBinding();
      HasHinsMode var4 = null;
      if (var3) {
         var5.title.setText(R.string.photon_pure);
         var5.title.setTextColor(this.getColor(R.color.surface_dark_55));
         var5.leadingIcon.setImageTintList(ColorStateList.valueOf(this.getColor(R.color.surface_dark_45)));
         var5.ivInfo.setImageTintList(ColorStateList.valueOf(this.getColor(R.color.surface_dark_45)));
         var5.clContainer.setBackgroundResource(R.drawable.rounded_rectangle_white_r16_black5_stroke1_disabled_white_bg);
         SwitchCompat var6 = var5.switchMode;
         if (var1 instanceof HasHinsMode) {
            var4 = var1;
         }

         if (var4 != null) {
            var2 = var4.isHinsModeOn();
         } else {
            var2 = false;
         }

         var6.setCheckedSilence(var2);
         var5.switchMode.setEnabled(false);
      } else {
         var5.title.setTextColor(this.getColor(R.color.colorPrimaryText));
         var5.clContainer.setBackgroundResource(R.drawable.rounded_rectangle_white_r16_black5_stroke1);
         var5.leadingIcon.setImageTintList((ColorStateList)null);
         var5.ivInfo.setImageTintList((ColorStateList)null);
         var5.switchMode.setEnabled(true);
         if (var1 instanceof HasG4NightMode && var1 instanceof HasHinsMode) {
            SwitchCompat var13 = var5.switchMode;
            var2 = this.nightMode;
            var1 = var1;
            if (var2) {
               var2 = var1.isHinsNightModeOn();
            } else {
               var2 = var1.isHinsModeOn();
            }

            var13.setCheckedSilence(var2);
            TextView var8 = var5.title;
            if (this.nightMode) {
               var3 = R.string.photon_pure_night;
            } else {
               var3 = R.string.photon_pure;
            }

            var8.setText(var3);
         } else {
            var5.switchMode.setCheckedSilence(false);
         }
      }
   }

   @Metadata(
      d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J2\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¨\u0006\u000e"},
      d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceHinsPureHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceHinsPureHolder;", "parentView", "Landroid/view/ViewGroup;", "nightMode", "", "onInfoClickListener", "Lkotlin/Function0;", "", "onModeChangeListener", "devicedetails_otherRelease"},
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

      public final DeviceHinsPureHolder newInstance(ViewGroup var1, boolean var2, Function0 var3, Function0 var4) {
         Intrinsics.checkNotNullParameter(var1, "parentView");
         Intrinsics.checkNotNullParameter(var3, "onInfoClickListener");
         Intrinsics.checkNotNullParameter(var4, "onModeChangeListener");
         HolderDeviceHinsPureBinding var5 = HolderDeviceHinsPureBinding.inflate(LayoutInflater.from(var1.getContext()), var1, false);
         Intrinsics.checkNotNullExpressionValue(var5, "inflate(...)");
         return new DeviceHinsPureHolder(var5, var2, var3, var4);
      }
   }
}
