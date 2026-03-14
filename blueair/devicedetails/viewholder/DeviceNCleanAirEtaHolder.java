package com.blueair.devicedetails.viewholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.blueair.core.model.Device;
import com.blueair.core.model.HasFanSpeed;
import com.blueair.core.model.HasSensorData;
import com.blueair.core.model.IndoorDatapoint;
import com.blueair.devicedetails.databinding.HolderDeviceNCleanAirEtaBinding;
import com.blueair.devicedetails.util.EtaUtils;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"},
   d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceNCleanAirEtaHolder;", "Lcom/blueair/devicedetails/viewholder/DeviceAttributeHolder;", "binding", "Lcom/blueair/devicedetails/databinding/HolderDeviceNCleanAirEtaBinding;", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceNCleanAirEtaBinding;)V", "getBinding", "()Lcom/blueair/devicedetails/databinding/HolderDeviceNCleanAirEtaBinding;", "update", "", "device", "Lcom/blueair/core/model/Device;", "dataPoint", "Lcom/blueair/core/model/IndoorDatapoint;", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceNCleanAirEtaHolder extends DeviceAttributeHolder {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final HolderDeviceNCleanAirEtaBinding binding;

   public DeviceNCleanAirEtaHolder(HolderDeviceNCleanAirEtaBinding var1) {
      Intrinsics.checkNotNullParameter(var1, "binding");
      View var2 = var1.getRoot();
      Intrinsics.checkNotNullExpressionValue(var2, "getRoot(...)");
      super(var2);
      this.binding = var1;
   }

   public final HolderDeviceNCleanAirEtaBinding getBinding() {
      return this.binding;
   }

   public void update(Device var1) {
      Intrinsics.checkNotNullParameter(var1, "device");
   }

   public final void update(Device var1, IndoorDatapoint var2) {
      Intrinsics.checkNotNullParameter(var1, "device");
      boolean var4 = var1 instanceof HasFanSpeed;
      Object var7 = null;
      HasFanSpeed var6;
      if (var4) {
         var6 = (HasFanSpeed)var1;
      } else {
         var6 = null;
      }

      IndoorDatapoint var11;
      if (var2 == null) {
         HasSensorData var5;
         if (var6 instanceof HasSensorData) {
            var5 = (HasSensorData)var6;
         } else {
            var5 = null;
         }

         if (var5 != null) {
            var11 = var5.getLatestSensorDatapoint();
         } else {
            var11 = null;
         }
      } else {
         var11 = var2;
      }

      if (var6 != null) {
         Float var12;
         if (var11 != null) {
            var12 = var11.getPm25();
         } else {
            var12 = null;
         }

         if (var12 != null) {
            TextView var8 = this.binding.cleanAirEta;
            EtaUtils var13 = EtaUtils.INSTANCE;
            Context var14 = this.itemView.getContext();
            Intrinsics.checkNotNullExpressionValue(var14, "getContext(...)");
            int var3 = ((HasFanSpeed)var1).getFanSpeed();
            Float var10 = (Float)var7;
            if (var2 != null) {
               var10 = var2.getPm25();
            }

            var8.setText(var13.etaString(var14, var3, var10));
            return;
         }
      }

      TextView var9 = this.binding.cleanAirEta;
      Intrinsics.checkNotNullExpressionValue(var9, "cleanAirEta");
      ViewExtensionsKt.show((View)var9, false);
   }

   @Metadata(
      d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"},
      d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceNCleanAirEtaHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceNCleanAirEtaHolder;", "parentView", "Landroid/view/ViewGroup;", "devicedetails_otherRelease"},
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

      public final DeviceNCleanAirEtaHolder newInstance(ViewGroup var1) {
         Intrinsics.checkNotNullParameter(var1, "parentView");
         HolderDeviceNCleanAirEtaBinding var2 = HolderDeviceNCleanAirEtaBinding.inflate(LayoutInflater.from(var1.getContext()), var1, false);
         Intrinsics.checkNotNullExpressionValue(var2, "inflate(...)");
         return new DeviceNCleanAirEtaHolder(var2);
      }
   }
}
