package com.blueair.devicedetails.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceKt;
import com.blueair.devicedetails.R;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.blueair.viewcore.view.SeekProgressBar;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0013"},
   d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceOTAHolder;", "Lcom/blueair/devicedetails/viewholder/DeviceAttributeHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "otaProgress", "Lcom/blueair/viewcore/view/ProgressBlockerView;", "getOtaProgress", "()Lcom/blueair/viewcore/view/ProgressBlockerView;", "progressBar", "Lcom/blueair/viewcore/view/SeekProgressBar;", "getProgressBar", "()Lcom/blueair/viewcore/view/SeekProgressBar;", "update", "", "device", "Lcom/blueair/core/model/Device;", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceOTAHolder extends DeviceAttributeHolder {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final ProgressBlockerView otaProgress;
   private final SeekProgressBar progressBar;

   public DeviceOTAHolder(View var1) {
      Intrinsics.checkNotNullParameter(var1, "itemView");
      super(var1);
      View var2 = var1.findViewById(R.id.otaProgress);
      Intrinsics.checkNotNullExpressionValue(var2, "findViewById(...)");
      this.otaProgress = (ProgressBlockerView)var2;
      var1 = var1.findViewById(R.id.progress);
      Intrinsics.checkNotNullExpressionValue(var1, "findViewById(...)");
      this.progressBar = (SeekProgressBar)var1;
   }

   public final ProgressBlockerView getOtaProgress() {
      return this.otaProgress;
   }

   public final SeekProgressBar getProgressBar() {
      return this.progressBar;
   }

   public void update(Device var1) {
      Intrinsics.checkNotNullParameter(var1, "device");
      if (DeviceKt.isG4orB4orNB(var1)) {
         ViewExtensionsKt.hide((View)this.otaProgress);
         ViewExtensionsKt.show$default((View)this.progressBar, false, 1, (Object)null);
         this.progressBar.setProgress(var1.getUpdateProgress());
      }

   }

   @Metadata(
      d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002¨\u0006\n"},
      d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceOTAHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceOTAHolder;", "parentView", "Landroid/view/ViewGroup;", "createView", "Landroid/view/View;", "devicedetails_otherRelease"},
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

      private final View createView(ViewGroup var1) {
         View var2 = LayoutInflater.from(var1.getContext()).inflate(R.layout.holder_device_ota, var1, false);
         Intrinsics.checkNotNullExpressionValue(var2, "inflate(...)");
         return var2;
      }

      public final DeviceOTAHolder newInstance(ViewGroup var1) {
         Intrinsics.checkNotNullParameter(var1, "parentView");
         return new DeviceOTAHolder(this.createView(var1));
      }
   }
}
