package com.blueair.devicedetails.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.blueair.core.model.Device;
import com.blueair.core.model.HasG4NightMode;
import com.blueair.core.model.HasHinsMode;
import com.blueair.core.model.HasStandBy;
import com.blueair.devicedetails.databinding.HolderDeviceNHinsBinding;
import com.blueair.viewcore.R;
import com.blueair.viewcore.view.SwitchCompat;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012!\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005\u0012!\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR)\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R)\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"},
   d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceNHinsHolder;", "Lcom/blueair/devicedetails/viewholder/DeviceAttributeHolder;", "binding", "Lcom/blueair/devicedetails/databinding/HolderDeviceNHinsBinding;", "onHinsInfoClickListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isG4NightMode", "", "onHinsSetListener", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceNHinsBinding;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getBinding", "()Lcom/blueair/devicedetails/databinding/HolderDeviceNHinsBinding;", "update", "device", "Lcom/blueair/core/model/Device;", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceNHinsHolder extends DeviceAttributeHolder {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final HolderDeviceNHinsBinding binding;
   private boolean isG4NightMode;
   private final Function1 onHinsInfoClickListener;
   private final Function1 onHinsSetListener;

   // $FF: synthetic method
   public static void $r8$lambda$byQ_tyO5bPkjQfVYis42LU_Mll8/* $FF was: $r8$lambda$byQ_tyO5bPkjQfVYis42LU-Mll8*/(DeviceNHinsHolder var0, View var1) {
      _init_$lambda$0(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$zeKadce9oUNKxZG_2jMjRp6Wq3I(DeviceNHinsHolder var0, CompoundButton var1, boolean var2) {
      _init_$lambda$1(var0, var1, var2);
   }

   public DeviceNHinsHolder(HolderDeviceNHinsBinding var1, Function1 var2, Function1 var3) {
      Intrinsics.checkNotNullParameter(var1, "binding");
      Intrinsics.checkNotNullParameter(var2, "onHinsInfoClickListener");
      Intrinsics.checkNotNullParameter(var3, "onHinsSetListener");
      FrameLayout var4 = var1.getRoot();
      Intrinsics.checkNotNullExpressionValue(var4, "getRoot(...)");
      super((View)var4);
      this.binding = var1;
      this.onHinsInfoClickListener = var2;
      this.onHinsSetListener = var3;
      var1.title.setOnClickListener(new DeviceNHinsHolder$$ExternalSyntheticLambda0(this));
      var1.switchBtn.setOnCheckedChangeListener(new DeviceNHinsHolder$$ExternalSyntheticLambda1(this));
   }

   private static final void _init_$lambda$0(DeviceNHinsHolder var0, View var1) {
      var0.onHinsInfoClickListener.invoke(var0.isG4NightMode);
   }

   private static final void _init_$lambda$1(DeviceNHinsHolder var0, CompoundButton var1, boolean var2) {
      var0.onHinsSetListener.invoke(var0.isG4NightMode);
   }

   public final HolderDeviceNHinsBinding getBinding() {
      return this.binding;
   }

   public void update(Device var1) {
      Intrinsics.checkNotNullParameter(var1, "device");
      if (var1 instanceof HasStandBy && ((HasStandBy)var1).isStandByOn()) {
         this.binding.title.setText(R.string.photon_pure);
         this.binding.switchBtn.setCheckedSilence(false);
         this.binding.switchBtn.setEnabled(false);
      } else {
         this.binding.switchBtn.setEnabled(true);
         if (var1 instanceof HasG4NightMode && var1 instanceof HasHinsMode) {
            this.isG4NightMode = ((HasG4NightMode)var1).isG4NightModeOn();
            SwitchCompat var4 = this.binding.switchBtn;
            boolean var3 = this.isG4NightMode;
            var1 = var1;
            if (var3) {
               var3 = var1.isHinsNightModeOn();
            } else {
               var3 = var1.isHinsModeOn();
            }

            var4.setCheckedSilence(var3);
            TextView var6 = this.binding.title;
            int var2;
            if (this.isG4NightMode) {
               var2 = R.string.photon_pure_night;
            } else {
               var2 = R.string.photon_pure;
            }

            var6.setText(var2);
         }
      }

      this.binding.switchBtn.setContentDescription(this.binding.title.getText());
   }

   @Metadata(
      d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JT\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\t2!\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\t¨\u0006\u0010"},
      d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceNHinsHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceNHinsHolder;", "parentView", "Landroid/view/ViewGroup;", "onHinsInfoClickListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isG4NightMode", "", "onHinsSetListener", "devicedetails_otherRelease"},
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

      public final DeviceNHinsHolder newInstance(ViewGroup var1, Function1 var2, Function1 var3) {
         Intrinsics.checkNotNullParameter(var1, "parentView");
         Intrinsics.checkNotNullParameter(var2, "onHinsInfoClickListener");
         Intrinsics.checkNotNullParameter(var3, "onHinsSetListener");
         HolderDeviceNHinsBinding var4 = HolderDeviceNHinsBinding.inflate(LayoutInflater.from(var1.getContext()), var1, false);
         Intrinsics.checkNotNullExpressionValue(var4, "inflate(...)");
         return new DeviceNHinsHolder(var4, var2, var3);
      }
   }
}
