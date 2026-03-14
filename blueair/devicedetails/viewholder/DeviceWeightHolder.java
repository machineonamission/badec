package com.blueair.devicedetails.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.blueair.core.model.Device;
import com.blueair.core.model.HasSensorData;
import com.blueair.core.model.HasWeight;
import com.blueair.core.model.IndoorDatapoint;
import com.blueair.devicedetails.databinding.HolderDeviceWeightBinding;
import com.blueair.viewcore.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(
   d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001a\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"},
   d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceWeightHolder;", "Lcom/blueair/devicedetails/viewholder/DeviceAttributeHolder;", "binding", "Lcom/blueair/devicedetails/databinding/HolderDeviceWeightBinding;", "device", "Lcom/blueair/core/model/Device;", "onTareListener", "Lkotlin/Function0;", "", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceWeightBinding;Lcom/blueair/core/model/Device;Lkotlin/jvm/functions/Function0;)V", "getBinding", "()Lcom/blueair/devicedetails/databinding/HolderDeviceWeightBinding;", "getDevice", "()Lcom/blueair/core/model/Device;", "unitG", "", "update", "datapoint", "Lcom/blueair/core/model/IndoorDatapoint;", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceWeightHolder extends DeviceAttributeHolder {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final HolderDeviceWeightBinding binding;
   private final Device device;
   private final Function0 onTareListener;
   private final String unitG;

   // $FF: synthetic method
   public static void $r8$lambda$mfAmMF84ypXVyJb0NtV4X0AsSJo(DeviceWeightHolder var0, View var1) {
      _init_$lambda$0(var0, var1);
   }

   public DeviceWeightHolder(HolderDeviceWeightBinding var1, Device var2, Function0 var3) {
      Intrinsics.checkNotNullParameter(var1, "binding");
      Intrinsics.checkNotNullParameter(var3, "onTareListener");
      FrameLayout var4 = var1.getRoot();
      Intrinsics.checkNotNullExpressionValue(var4, "getRoot(...)");
      super((View)var4);
      this.binding = var1;
      this.device = var2;
      this.onTareListener = var3;
      String var7 = this.itemView.getContext().getString(R.string.unit_g);
      Intrinsics.checkNotNullExpressionValue(var7, "getString(...)");
      this.unitG = var7;
      TextView var6 = var1.weightValue;
      StringBuilder var5 = new StringBuilder("--");
      var5.append(var7);
      var6.setText((CharSequence)var5.toString());
      var1.tareBtn.setOnClickListener(new DeviceWeightHolder$$ExternalSyntheticLambda0(this));
   }

   private static final void _init_$lambda$0(DeviceWeightHolder var0, View var1) {
      var0.onTareListener.invoke();
   }

   public final HolderDeviceWeightBinding getBinding() {
      return this.binding;
   }

   public final Device getDevice() {
      return this.device;
   }

   public void update(Device var1) {
      Intrinsics.checkNotNullParameter(var1, "device");
      if (var1 instanceof HasWeight) {
         boolean var2 = var1 instanceof HasSensorData;
         IndoorDatapoint var4 = null;
         HasSensorData var3;
         if (var2) {
            var3 = (HasSensorData)var1;
         } else {
            var3 = null;
         }

         if (var3 != null) {
            var4 = var3.getLatestSensorDatapoint();
         }

         this.update(var1, var4);
      }

   }

   public final void update(Device var1, IndoorDatapoint var2) {
      Intrinsics.checkNotNullParameter(var1, "device");
      if (var1 instanceof HasWeight) {
         label22: {
            if (var2 != null) {
               Float var5 = var2.getWeight();
               if (var5 != null) {
                  var6 = MathKt.roundToInt(var5);
                  break label22;
               }
            }

            var6 = null;
         }

         StringBuilder var3;
         TextView var4;
         label17: {
            var4 = this.binding.weightValue;
            var3 = new StringBuilder();
            if (var6 != null) {
               String var8 = var6.toString();
               var7 = var8;
               if (var8 != null) {
                  break label17;
               }
            }

            var7 = "--";
         }

         var3.append(var7);
         var3.append(this.unitG);
         var4.setText((CharSequence)var3.toString());
      }

   }

   @Metadata(
      d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¨\u0006\r"},
      d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceWeightHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceWeightHolder;", "parentView", "Landroid/view/ViewGroup;", "device", "Lcom/blueair/core/model/Device;", "onTareListener", "Lkotlin/Function0;", "", "devicedetails_otherRelease"},
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

      public final DeviceWeightHolder newInstance(ViewGroup var1, Device var2, Function0 var3) {
         Intrinsics.checkNotNullParameter(var1, "parentView");
         Intrinsics.checkNotNullParameter(var3, "onTareListener");
         HolderDeviceWeightBinding var4 = HolderDeviceWeightBinding.inflate(LayoutInflater.from(var1.getContext()), var1, false);
         Intrinsics.checkNotNullExpressionValue(var4, "inflate(...)");
         return new DeviceWeightHolder(var4, var2, var3);
      }
   }
}
