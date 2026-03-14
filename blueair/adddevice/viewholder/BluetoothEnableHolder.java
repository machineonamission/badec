package com.blueair.adddevice.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.adddevice.databinding.HolderBluetoothEnableBinding;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000e"},
   d2 = {"Lcom/blueair/adddevice/viewholder/BluetoothEnableHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/blueair/adddevice/databinding/HolderBluetoothEnableBinding;", "<init>", "(Lcom/blueair/adddevice/databinding/HolderBluetoothEnableBinding;)V", "getBinding", "()Lcom/blueair/adddevice/databinding/HolderBluetoothEnableBinding;", "update", "", "content", "Lkotlin/Pair;", "", "Companion", "adddevice_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class BluetoothEnableHolder extends RecyclerView.ViewHolder {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final HolderBluetoothEnableBinding binding;

   public BluetoothEnableHolder(HolderBluetoothEnableBinding var1) {
      Intrinsics.checkNotNullParameter(var1, "binding");
      super((View)var1.getRoot());
      this.binding = var1;
   }

   public final HolderBluetoothEnableBinding getBinding() {
      return this.binding;
   }

   public final void update(Pair var1) {
      Intrinsics.checkNotNullParameter(var1, "content");
      this.binding.enableTitle.setText((CharSequence)var1.getFirst());
      this.binding.tvContent.setText((CharSequence)var1.getSecond());
   }

   @Metadata(
      d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"},
      d2 = {"Lcom/blueair/adddevice/viewholder/BluetoothEnableHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/adddevice/viewholder/BluetoothEnableHolder;", "parentView", "Landroid/view/ViewGroup;", "adddevice_otherRelease"},
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

      public final BluetoothEnableHolder newInstance(ViewGroup var1) {
         Intrinsics.checkNotNullParameter(var1, "parentView");
         HolderBluetoothEnableBinding var2 = HolderBluetoothEnableBinding.inflate(LayoutInflater.from(var1.getContext()), var1, false);
         Intrinsics.checkNotNullExpressionValue(var2, "inflate(...)");
         return new BluetoothEnableHolder(var2);
      }
   }
}
