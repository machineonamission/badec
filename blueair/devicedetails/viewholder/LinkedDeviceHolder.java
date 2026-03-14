package com.blueair.devicedetails.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.devicedetails.databinding.HolderLinkDeviceBinding;
import com.blueair.viewcore.R;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0013"},
   d2 = {"Lcom/blueair/devicedetails/viewholder/LinkedDeviceHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/blueair/devicedetails/databinding/HolderLinkDeviceBinding;", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderLinkDeviceBinding;)V", "getBinding", "()Lcom/blueair/devicedetails/databinding/HolderLinkDeviceBinding;", "clickView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getClickView", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "update", "", "name", "", "isSelected", "", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class LinkedDeviceHolder extends RecyclerView.ViewHolder {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final HolderLinkDeviceBinding binding;
   private final ConstraintLayout clickView;

   public LinkedDeviceHolder(HolderLinkDeviceBinding var1) {
      Intrinsics.checkNotNullParameter(var1, "binding");
      super((View)var1.getRoot());
      this.binding = var1;
      ConstraintLayout var2 = var1.rootLayout;
      Intrinsics.checkNotNullExpressionValue(var2, "rootLayout");
      this.clickView = var2;
   }

   public final HolderLinkDeviceBinding getBinding() {
      return this.binding;
   }

   public final ConstraintLayout getClickView() {
      return this.clickView;
   }

   public final void update(String var1, boolean var2) {
      AppCompatImageView var3 = this.binding.deviceTick;
      Intrinsics.checkNotNullExpressionValue(var3, "deviceTick");
      ViewExtensionsKt.show((View)var3, var2);
      if (var1 != null) {
         this.binding.deviceName.setText((CharSequence)var1);
      } else {
         this.binding.deviceName.setText(R.string.none);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"},
      d2 = {"Lcom/blueair/devicedetails/viewholder/LinkedDeviceHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/LinkedDeviceHolder;", "parentView", "Landroid/view/ViewGroup;", "devicedetails_otherRelease"},
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

      public final LinkedDeviceHolder newInstance(ViewGroup var1) {
         Intrinsics.checkNotNullParameter(var1, "parentView");
         HolderLinkDeviceBinding var2 = HolderLinkDeviceBinding.inflate(LayoutInflater.from(var1.getContext()), var1, false);
         Intrinsics.checkNotNullExpressionValue(var2, "inflate(...)");
         return new LinkedDeviceHolder(var2);
      }
   }
}
