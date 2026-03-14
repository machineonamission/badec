package com.blueair.devicedetails.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.FilterInfo;
import com.blueair.devicedetails.databinding.HolderDeviceFilterTypeBinding;
import com.google.android.material.button.MaterialButton;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"},
   d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceFilterTypeHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/blueair/devicedetails/databinding/HolderDeviceFilterTypeBinding;", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceFilterTypeBinding;)V", "getBinding", "()Lcom/blueair/devicedetails/databinding/HolderDeviceFilterTypeBinding;", "update", "", "device", "Lcom/blueair/core/model/Device;", "filterInfo", "Lcom/blueair/core/model/FilterInfo;", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceFilterTypeHolder extends RecyclerView.ViewHolder {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final HolderDeviceFilterTypeBinding binding;

   public DeviceFilterTypeHolder(HolderDeviceFilterTypeBinding var1) {
      Intrinsics.checkNotNullParameter(var1, "binding");
      super((View)var1.getRoot());
      this.binding = var1;
   }

   public final HolderDeviceFilterTypeBinding getBinding() {
      return this.binding;
   }

   public final void update(Device var1, FilterInfo var2) {
      Intrinsics.checkNotNullParameter(var1, "device");
      Intrinsics.checkNotNullParameter(var2, "filterInfo");
      TextView var4 = this.binding.filterName;
      String var3 = var2.getName().getValue();
      if (var3 == null) {
         var3 = "";
      }

      var4.setText((CharSequence)var3);
      this.binding.filterImage.setImageResource(var2.getImage());
      MaterialButton var5 = this.binding.myFilterBtn;
      Intrinsics.checkNotNullExpressionValue(var5, "myFilterBtn");
      ViewExtensionsKt.show((View)var5, DeviceKt.isG4orB4orNB(var1) ^ true);
   }

   @Metadata(
      d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"},
      d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceFilterTypeHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceFilterTypeHolder;", "parentView", "Landroid/view/ViewGroup;", "devicedetails_otherRelease"},
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

      public final DeviceFilterTypeHolder newInstance(ViewGroup var1) {
         Intrinsics.checkNotNullParameter(var1, "parentView");
         HolderDeviceFilterTypeBinding var2 = HolderDeviceFilterTypeBinding.inflate(LayoutInflater.from(var1.getContext()), var1, false);
         Intrinsics.checkNotNullExpressionValue(var2, "inflate(...)");
         return new DeviceFilterTypeHolder(var2);
      }
   }
}
