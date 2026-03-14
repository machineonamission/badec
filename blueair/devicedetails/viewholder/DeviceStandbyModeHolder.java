package com.blueair.devicedetails.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceKt;
import com.blueair.devicedetails.databinding.HolderDeviceStandbyModeBinding;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\r"},
   d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceStandbyModeHolder;", "Lcom/blueair/devicedetails/viewholder/DeviceAttributeHolder;", "binding", "Lcom/blueair/devicedetails/databinding/HolderDeviceStandbyModeBinding;", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceStandbyModeBinding;)V", "getBinding", "()Lcom/blueair/devicedetails/databinding/HolderDeviceStandbyModeBinding;", "update", "", "device", "Lcom/blueair/core/model/Device;", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceStandbyModeHolder extends DeviceAttributeHolder {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final HolderDeviceStandbyModeBinding binding;

   public DeviceStandbyModeHolder(HolderDeviceStandbyModeBinding var1) {
      Intrinsics.checkNotNullParameter(var1, "binding");
      ConstraintLayout var2 = var1.getRoot();
      Intrinsics.checkNotNullExpressionValue(var2, "getRoot(...)");
      super((View)var2);
      this.binding = var1;
   }

   public final HolderDeviceStandbyModeBinding getBinding() {
      return this.binding;
   }

   public void update(Device var1) {
      Intrinsics.checkNotNullParameter(var1, "device");
      AppCompatImageView var3 = this.binding.germshieldIcon;
      Intrinsics.checkNotNullExpressionValue(var3, "germshieldIcon");
      View var4 = (View)var3;
      boolean var2;
      if (DeviceKt.isGermShieldOn(var1) && !DeviceKt.isGermShieldPlus(var1)) {
         var2 = true;
      } else {
         var2 = false;
      }

      ViewExtensionsKt.show(var4, var2);
   }

   @Metadata(
      d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"},
      d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceStandbyModeHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceStandbyModeHolder;", "parentView", "Landroid/view/ViewGroup;", "devicedetails_otherRelease"},
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

      public final DeviceStandbyModeHolder newInstance(ViewGroup var1) {
         Intrinsics.checkNotNullParameter(var1, "parentView");
         HolderDeviceStandbyModeBinding var2 = HolderDeviceStandbyModeBinding.inflate(LayoutInflater.from(var1.getContext()), var1, false);
         Intrinsics.checkNotNullExpressionValue(var2, "inflate(...)");
         return new DeviceStandbyModeHolder(var2);
      }
   }
}
