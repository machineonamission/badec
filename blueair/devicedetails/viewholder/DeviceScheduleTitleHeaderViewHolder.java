package com.blueair.devicedetails.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.devicedetails.databinding.HolderScheduleTitleHeaderBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\f\u001a\u00020\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"},
   d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceScheduleTitleHeaderViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/blueair/devicedetails/databinding/HolderScheduleTitleHeaderBinding;", "titleId", "", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderScheduleTitleHeaderBinding;I)V", "getBinding", "()Lcom/blueair/devicedetails/databinding/HolderScheduleTitleHeaderBinding;", "getTitleId", "()I", "bind", "", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceScheduleTitleHeaderViewHolder extends RecyclerView.ViewHolder {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final HolderScheduleTitleHeaderBinding binding;
   private final int titleId;

   public DeviceScheduleTitleHeaderViewHolder(HolderScheduleTitleHeaderBinding var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "binding");
      super((View)var1.getRoot());
      this.binding = var1;
      this.titleId = var2;
   }

   public final void bind() {
      this.binding.title.setText(this.titleId);
   }

   public final HolderScheduleTitleHeaderBinding getBinding() {
      return this.binding;
   }

   public final int getTitleId() {
      return this.titleId;
   }

   @Metadata(
      d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\t¨\u0006\n"},
      d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceScheduleTitleHeaderViewHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceScheduleTitleHeaderViewHolder;", "parent", "Landroid/view/ViewGroup;", "titleId", "", "devicedetails_otherRelease"},
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

      public final DeviceScheduleTitleHeaderViewHolder newInstance(ViewGroup var1, int var2) {
         Intrinsics.checkNotNullParameter(var1, "parent");
         HolderScheduleTitleHeaderBinding var3 = HolderScheduleTitleHeaderBinding.inflate(LayoutInflater.from(var1.getContext()), var1, false);
         Intrinsics.checkNotNullExpressionValue(var3, "inflate(...)");
         return new DeviceScheduleTitleHeaderViewHolder(var3, var2);
      }
   }
}
