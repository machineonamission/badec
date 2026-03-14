package com.blueair.devicedetails.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import androidx.appcompat.content.res.AppCompatResources;
import com.blueair.core.model.Device;
import com.blueair.core.model.HasPetMainMode;
import com.blueair.core.model.SmartSubMode;
import com.blueair.devicedetails.databinding.HolderDeviceSubAutoBinding;
import com.blueair.viewcore.R;
import com.blueair.viewcore.view.SwitchCompat;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u000e\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0011R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"},
   d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceSubAutoHolder;", "Lcom/blueair/devicedetails/viewholder/DeviceAttributeHolder;", "binding", "Lcom/blueair/devicedetails/databinding/HolderDeviceSubAutoBinding;", "device", "Lcom/blueair/core/model/Device;", "isInSchedule", "", "onSubAutoSetListener", "Lkotlin/Function1;", "", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceSubAutoBinding;Lcom/blueair/core/model/Device;ZLkotlin/jvm/functions/Function1;)V", "getBinding", "()Lcom/blueair/devicedetails/databinding/HolderDeviceSubAutoBinding;", "getDevice", "()Lcom/blueair/core/model/Device;", "()Z", "update", "smartSubMode", "Lcom/blueair/core/model/SmartSubMode;", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceSubAutoHolder extends DeviceAttributeHolder {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final HolderDeviceSubAutoBinding binding;
   private final Device device;
   private final boolean isInSchedule;
   private final Function1 onSubAutoSetListener;

   // $FF: synthetic method
   public static void $r8$lambda$rwQh_IBlzNYU3nUt5DczZWhjyhY/* $FF was: $r8$lambda$rwQh-IBlzNYU3nUt5DczZWhjyhY*/(DeviceSubAutoHolder var0, CompoundButton var1, boolean var2) {
      _init_$lambda$0(var0, var1, var2);
   }

   public DeviceSubAutoHolder(HolderDeviceSubAutoBinding var1, Device var2, boolean var3, Function1 var4) {
      Intrinsics.checkNotNullParameter(var1, "binding");
      Intrinsics.checkNotNullParameter(var4, "onSubAutoSetListener");
      FrameLayout var5 = var1.getRoot();
      Intrinsics.checkNotNullExpressionValue(var5, "getRoot(...)");
      super((View)var5);
      this.binding = var1;
      this.device = var2;
      this.isInSchedule = var3;
      this.onSubAutoSetListener = var4;
      var1.switchBtn.setOnCheckedChangeListener(new DeviceSubAutoHolder$$ExternalSyntheticLambda0(this));
      if (var3) {
         var1.contentContainer.setBackground(AppCompatResources.getDrawable(this.itemView.getContext(), R.drawable.rounded_square_anti_flash_blue_r8));
      }

   }

   private static final void _init_$lambda$0(DeviceSubAutoHolder var0, CompoundButton var1, boolean var2) {
      var0.onSubAutoSetListener.invoke(var2);
   }

   public final HolderDeviceSubAutoBinding getBinding() {
      return this.binding;
   }

   public final Device getDevice() {
      return this.device;
   }

   public final boolean isInSchedule() {
      return this.isInSchedule;
   }

   public void update(Device var1) {
      Intrinsics.checkNotNullParameter(var1, "device");
      if (var1 instanceof HasPetMainMode) {
         this.update(((HasPetMainMode)var1).smartSubMode());
      }

   }

   public final void update(SmartSubMode var1) {
      Intrinsics.checkNotNullParameter(var1, "smartSubMode");
      SwitchCompat var3 = this.binding.switchBtn;
      boolean var2;
      if (var1 == SmartSubMode.AUTO_ON) {
         var2 = true;
      } else {
         var2 = false;
      }

      var3.setCheckedSilence(var2);
   }

   @Metadata(
      d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J4\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000e0\r¨\u0006\u000f"},
      d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceSubAutoHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceSubAutoHolder;", "parentView", "Landroid/view/ViewGroup;", "device", "Lcom/blueair/core/model/Device;", "isInSchedule", "", "onSubAutoSetListener", "Lkotlin/Function1;", "", "devicedetails_otherRelease"},
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

      public final DeviceSubAutoHolder newInstance(ViewGroup var1, Device var2, boolean var3, Function1 var4) {
         Intrinsics.checkNotNullParameter(var1, "parentView");
         Intrinsics.checkNotNullParameter(var4, "onSubAutoSetListener");
         HolderDeviceSubAutoBinding var5 = HolderDeviceSubAutoBinding.inflate(LayoutInflater.from(var1.getContext()), var1, false);
         Intrinsics.checkNotNullExpressionValue(var5, "inflate(...)");
         return new DeviceSubAutoHolder(var5, var2, var3, var4);
      }
   }
}
