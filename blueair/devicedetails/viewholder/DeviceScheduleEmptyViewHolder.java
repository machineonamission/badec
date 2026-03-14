package com.blueair.devicedetails.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.devicedetails.databinding.HolderDeviceScheduleEmptyBinding;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\r"},
   d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceScheduleEmptyViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/blueair/devicedetails/databinding/HolderDeviceScheduleEmptyBinding;", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceScheduleEmptyBinding;)V", "getBinding", "()Lcom/blueair/devicedetails/databinding/HolderDeviceScheduleEmptyBinding;", "bind", "", "onTap", "Lkotlin/Function0;", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceScheduleEmptyViewHolder extends RecyclerView.ViewHolder {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final HolderDeviceScheduleEmptyBinding binding;

   // $FF: synthetic method
   public static void $r8$lambda$_RXNJL_wwKAaiopLcSy2LuK_SGs/* $FF was: $r8$lambda$-RXNJL-wwKAaiopLcSy2LuK-SGs*/(Function0 var0, View var1) {
      bind$lambda$0(var0, var1);
   }

   public DeviceScheduleEmptyViewHolder(HolderDeviceScheduleEmptyBinding var1) {
      Intrinsics.checkNotNullParameter(var1, "binding");
      super((View)var1.getRoot());
      this.binding = var1;
   }

   private static final void bind$lambda$0(Function0 var0, View var1) {
      var0.invoke();
   }

   public final void bind(Function0 var1) {
      Intrinsics.checkNotNullParameter(var1, "onTap");
      this.binding.buttonAdd.setOnClickListener(new DeviceScheduleEmptyViewHolder$$ExternalSyntheticLambda0(var1));
   }

   public final HolderDeviceScheduleEmptyBinding getBinding() {
      return this.binding;
   }

   @Metadata(
      d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"},
      d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceScheduleEmptyViewHolder$Companion;", "", "<init>", "()V", "instance", "Lcom/blueair/devicedetails/viewholder/DeviceScheduleEmptyViewHolder;", "parent", "Landroid/view/ViewGroup;", "devicedetails_otherRelease"},
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

      public final DeviceScheduleEmptyViewHolder instance(ViewGroup var1) {
         Intrinsics.checkNotNullParameter(var1, "parent");
         HolderDeviceScheduleEmptyBinding var2 = HolderDeviceScheduleEmptyBinding.inflate(LayoutInflater.from(var1.getContext()), var1, false);
         Intrinsics.checkNotNullExpressionValue(var2, "inflate(...)");
         return new DeviceScheduleEmptyViewHolder(var2);
      }
   }
}
