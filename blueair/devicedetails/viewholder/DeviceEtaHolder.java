package com.blueair.devicedetails.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.HasFanSpeed;
import com.blueair.core.model.HasSensorData;
import com.blueair.core.model.IndoorDatapoint;
import com.blueair.core.model.SensorType;
import com.blueair.devicedetails.databinding.HolderDeviceEtaBinding;
import com.blueair.devicedetails.util.EtaUtils;
import com.blueair.viewcore.R;
import com.blueair.viewcore.view.IndoorAirStatusLabel;
import com.blueair.viewcore.view.SeekProgressBar;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000eH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"},
   d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceEtaHolder;", "Lcom/blueair/devicedetails/viewholder/DeviceAttributeHolder;", "binding", "Lcom/blueair/devicedetails/databinding/HolderDeviceEtaBinding;", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceEtaBinding;)V", "getBinding", "()Lcom/blueair/devicedetails/databinding/HolderDeviceEtaBinding;", "update", "", "device", "Lcom/blueair/core/model/HasFanSpeed;", "dataPoint", "Lcom/blueair/core/model/IndoorDatapoint;", "Lcom/blueair/core/model/Device;", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceEtaHolder extends DeviceAttributeHolder {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final HolderDeviceEtaBinding binding;

   public DeviceEtaHolder(HolderDeviceEtaBinding var1) {
      Intrinsics.checkNotNullParameter(var1, "binding");
      ConstraintLayout var2 = var1.getRoot();
      Intrinsics.checkNotNullExpressionValue(var2, "getRoot(...)");
      super((View)var2);
      this.binding = var1;
   }

   public final HolderDeviceEtaBinding getBinding() {
      return this.binding;
   }

   public void update(Device var1) {
      Intrinsics.checkNotNullParameter(var1, "device");
   }

   public final void update(HasFanSpeed var1, IndoorDatapoint var2) {
      Intrinsics.checkNotNullParameter(var1, "device");
      Intrinsics.checkNotNullParameter(var2, "dataPoint");
      if (var2.getPm25() == null) {
         TextView var6 = this.binding.clearAirMinView;
         Intrinsics.checkNotNullExpressionValue(var6, "clearAirMinView");
         ViewExtensionsKt.show((View)var6, false);
         var6 = this.binding.clearAirMsgView;
         Intrinsics.checkNotNullExpressionValue(var6, "clearAirMsgView");
         ViewExtensionsKt.show((View)var6, false);
         SeekProgressBar var15 = this.binding.progress;
         Intrinsics.checkNotNullExpressionValue(var15, "progress");
         ViewExtensionsKt.show((View)var15, false);
      }

      EtaUtils var7 = EtaUtils.INSTANCE;
      Device var16 = var1;
      int var4 = DeviceKt.fanSpeedValue(var16);
      Float var8 = var2.getPm25();
      int var3;
      if (var8 != null) {
         var3 = (int)var8;
      } else {
         var3 = Integer.MAX_VALUE;
      }

      var4 = var7.eta(var4, var3);
      if (var4 > 60) {
         var3 = 1;
      } else {
         var3 = 0;
      }

      int var5 = EtaUtils.INSTANCE.calcEtaPercent(var4);
      Timber.Forest var20 = Timber.Forest;
      StringBuilder var18 = new StringBuilder("update: eta = ");
      var18.append(var4);
      var18.append(", perc = ");
      var18.append(var5);
      var18.append(", dataPoint = ");
      var18.append(var2);
      var18.append(", fanspeed = ");
      var18.append(DeviceKt.fanSpeedValue(var16));
      var20.d(var18.toString(), new Object[0]);
      String var17 = "";
      if (var4 == 0) {
         this.binding.clearAirMinView.setText((CharSequence)this.itemView.getResources().getString(R.string.eta_success));
         this.binding.clearAirMsgView.setText((CharSequence)"");
      } else {
         TextView var19 = this.binding.clearAirMinView;
         StringBuilder var21 = new StringBuilder();
         if (var3) {
            var17 = "> ";
         }

         var21.append(var17);
         var21.append(Math.min(var4, 60));
         var21.append(' ');
         var21.append(this.itemView.getResources().getString(R.string.eta_minutes));
         var19.setText((CharSequence)var21.toString());
         this.binding.clearAirMsgView.setText((CharSequence)this.itemView.getResources().getString(R.string.clear_air_in));
      }

      this.binding.progress.setProgress(var5);
      if (var1 instanceof HasSensorData) {
         IndoorAirStatusLabel var9 = IndoorAirStatusLabel.Companion.fromDeviceAndSensorAndDatapoint(var2, (HasSensorData)var1, SensorType.PM25, true);
         if (var9 != null) {
            Integer var10 = var9.getIndoorAirStatusProgressDrawable();
            if (var10 != null) {
               var3 = ((Number)var10).intValue();
               this.binding.progress.setProgressDrawable(ContextCompat.getDrawable(this.itemView.getContext(), var3));
            }
         }
      }

   }

   @Metadata(
      d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"},
      d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceEtaHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceEtaHolder;", "parentView", "Landroid/view/ViewGroup;", "devicedetails_otherRelease"},
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

      public final DeviceEtaHolder newInstance(ViewGroup var1) {
         Intrinsics.checkNotNullParameter(var1, "parentView");
         HolderDeviceEtaBinding var2 = HolderDeviceEtaBinding.inflate(LayoutInflater.from(var1.getContext()), var1, false);
         Intrinsics.checkNotNullExpressionValue(var2, "inflate(...)");
         return new DeviceEtaHolder(var2);
      }
   }
}
