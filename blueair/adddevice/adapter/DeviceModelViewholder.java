package com.blueair.adddevice.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.adddevice.databinding.HolderDeviceModelBinding;
import com.dd.ShadowLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u0011"},
   d2 = {"Lcom/blueair/adddevice/adapter/DeviceModelViewholder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/blueair/adddevice/databinding/HolderDeviceModelBinding;", "<init>", "(Lcom/blueair/adddevice/databinding/HolderDeviceModelBinding;)V", "getBinding", "()Lcom/blueair/adddevice/databinding/HolderDeviceModelBinding;", "clickView", "Landroid/view/View;", "getClickView", "()Landroid/view/View;", "update", "", "model", "Lcom/blueair/adddevice/adapter/DeviceModel;", "Companion", "adddevice_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceModelViewholder extends RecyclerView.ViewHolder {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final HolderDeviceModelBinding binding;

   public DeviceModelViewholder(HolderDeviceModelBinding var1) {
      Intrinsics.checkNotNullParameter(var1, "binding");
      super((View)var1.getRoot());
      this.binding = var1;
   }

   public final HolderDeviceModelBinding getBinding() {
      return this.binding;
   }

   public final View getClickView() {
      ShadowLayout var1 = this.binding.slRoot;
      Intrinsics.checkNotNullExpressionValue(var1, "slRoot");
      return (View)var1;
   }

   public final void update(DeviceModel var1) {
      Intrinsics.checkNotNullParameter(var1, "model");
      this.binding.modelName.setText((CharSequence)var1.getModelName());
      this.binding.modelImage.setImageResource(var1.getModelImageRes());
   }

   @Metadata(
      d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"},
      d2 = {"Lcom/blueair/adddevice/adapter/DeviceModelViewholder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/adddevice/adapter/DeviceModelViewholder;", "parentView", "Landroid/view/ViewGroup;", "adddevice_otherRelease"},
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

      public final DeviceModelViewholder newInstance(ViewGroup var1) {
         Intrinsics.checkNotNullParameter(var1, "parentView");
         HolderDeviceModelBinding var2 = HolderDeviceModelBinding.inflate(LayoutInflater.from(var1.getContext()), var1, false);
         Intrinsics.checkNotNullExpressionValue(var2, "inflate(...)");
         return new DeviceModelViewholder(var2);
      }
   }
}
