package com.blueair.devicedetails.viewholder;

import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.HasG4NightMode;
import com.blueair.core.model.HasGermShieldMode;
import com.blueair.devicedetails.databinding.HolderDeviceGermShieldStatusV2Binding;
import com.blueair.viewcore.R;
import com.blueair.viewcore.view.SwitchCompat;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0010B3\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"},
   d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceGermShieldStatusV2Holder;", "Lcom/blueair/devicedetails/viewholder/DeviceControlHolder;", "Lcom/blueair/devicedetails/databinding/HolderDeviceGermShieldStatusV2Binding;", "binding", "nightMode", "", "onInfoClickListener", "Lkotlin/Function0;", "", "onModeChangeListener", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceGermShieldStatusV2Binding;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "update", "device", "Lcom/blueair/core/model/Device;", "forceOffline", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceGermShieldStatusV2Holder extends DeviceControlHolder {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final boolean nightMode;
   private final Function0 onInfoClickListener;
   private final Function0 onModeChangeListener;

   public DeviceGermShieldStatusV2Holder(HolderDeviceGermShieldStatusV2Binding var1, boolean var2, Function0 var3, Function0 var4) {
      Intrinsics.checkNotNullParameter(var1, "binding");
      Intrinsics.checkNotNullParameter(var3, "onInfoClickListener");
      Intrinsics.checkNotNullParameter(var4, "onModeChangeListener");
      super(var1);
      this.nightMode = var2;
      this.onInfoClickListener = var3;
      this.onModeChangeListener = var4;
      var1.ivInfo.setOnClickListener(new DeviceGermShieldStatusV2Holder$$ExternalSyntheticLambda0(var1, this));
      var1.switchMode.setOnCheckedChangeListener(new DeviceGermShieldStatusV2Holder$$ExternalSyntheticLambda1(this));
      var1.ivInfo.setContentDescription((CharSequence)var1.getRoot().getContext().getString(R.string.more_info_about, new Object[]{var1.tvTitle.getText()}));
   }

   static final void lambda$2$lambda$0(HolderDeviceGermShieldStatusV2Binding var0, DeviceGermShieldStatusV2Holder var1, View var2) {
      if (var0.switchMode.isEnabled()) {
         var1.onInfoClickListener.invoke();
      }

   }

   static final void lambda$2$lambda$1(DeviceGermShieldStatusV2Holder var0, CompoundButton var1, boolean var2) {
      var0.onModeChangeListener.invoke();
   }

   public void update(Device var1, boolean var2) {
      Intrinsics.checkNotNullParameter(var1, "device");
      if (var1 instanceof HasGermShieldMode) {
         HolderDeviceGermShieldStatusV2Binding var5 = (HolderDeviceGermShieldStatusV2Binding)this.getBinding();
         boolean var3;
         if (!var2 && var1.isOnline() && DeviceKt.isSafetySwitchOn(var1)) {
            var3 = false;
         } else {
            var3 = true;
         }

         boolean var4;
         if (var3 || !this.nightMode && ((HasGermShieldMode)var1).getHasGermShieldNightMode() && var1 instanceof HasG4NightMode && ((HasG4NightMode)var1).isG4NightModeOn() && !DeviceKt.isDisinfectionOn(var1) && !DeviceKt.isStandByOn(var1)) {
            var4 = true;
         } else {
            var4 = false;
         }

         if (this.nightMode) {
            Boolean var6 = ((HasGermShieldMode)var1).isGermShieldNightModeOn();
            if (var6 != null) {
               var2 = var6;
            } else {
               var2 = true;
            }
         } else {
            var2 = ((HasGermShieldMode)var1).isGermShieldModeOn();
         }

         SwitchCompat var9 = var5.switchMode;
         if (var2 && !var3) {
            var2 = true;
         } else {
            var2 = false;
         }

         var9.setCheckedSilence(var2);
         if (((HasGermShieldMode)var1).isGermShieldPlus()) {
            if (this.nightMode) {
               var5.tvTitle.setText(R.string.germ_shield_in_night_mode);
            } else {
               var5.tvTitle.setText(R.string.germ_shield_plus);
            }

            var5.leadingIcon.setImageResource(com.blueair.devicedetails.R.drawable.ic_germ_shield_plus_v2);
         }

         if (var4) {
            var5.tvTitle.setTextColor(this.getColor(R.color.surface_dark_55));
            var5.leadingIcon.setImageTintList(ColorStateList.valueOf(this.getColor(R.color.surface_dark_45)));
            var5.ivInfo.setImageTintList(ColorStateList.valueOf(this.getColor(R.color.surface_dark_45)));
            var5.clContainer.setBackgroundResource(R.drawable.rounded_rectangle_white_r16_black5_stroke1_disabled_white_bg);
            var5.switchMode.setEnabled(false);
         } else {
            var5.tvTitle.setTextColor(this.getColor(R.color.colorPrimaryText));
            var5.leadingIcon.setImageTintList((ColorStateList)null);
            var5.ivInfo.setImageTintList((ColorStateList)null);
            var5.clContainer.setBackgroundResource(R.drawable.rounded_rectangle_white_r16_black5_stroke1);
            var5.switchMode.setEnabled(true);
         }
      }
   }

   @Metadata(
      d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J2\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¨\u0006\u000e"},
      d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceGermShieldStatusV2Holder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceGermShieldStatusV2Holder;", "parentView", "Landroid/view/ViewGroup;", "nightMode", "", "onInfoClickListener", "Lkotlin/Function0;", "", "onModeChangeListener", "devicedetails_otherRelease"},
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

      public final DeviceGermShieldStatusV2Holder newInstance(ViewGroup var1, boolean var2, Function0 var3, Function0 var4) {
         Intrinsics.checkNotNullParameter(var1, "parentView");
         Intrinsics.checkNotNullParameter(var3, "onInfoClickListener");
         Intrinsics.checkNotNullParameter(var4, "onModeChangeListener");
         HolderDeviceGermShieldStatusV2Binding var5 = HolderDeviceGermShieldStatusV2Binding.inflate(LayoutInflater.from(var1.getContext()), var1, false);
         Intrinsics.checkNotNullExpressionValue(var5, "inflate(...)");
         return new DeviceGermShieldStatusV2Holder(var5, var2, var3, var4);
      }
   }
}
