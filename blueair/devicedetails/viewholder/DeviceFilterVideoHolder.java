package com.blueair.devicedetails.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.devicedetails.databinding.HolderDeviceFilterVideosBinding;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"},
   d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceFilterVideoHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/blueair/devicedetails/databinding/HolderDeviceFilterVideosBinding;", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceFilterVideosBinding;)V", "getBinding", "()Lcom/blueair/devicedetails/databinding/HolderDeviceFilterVideosBinding;", "update", "", "shouldShowSummary", "", "titleRes", "", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceFilterVideoHolder extends RecyclerView.ViewHolder {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final HolderDeviceFilterVideosBinding binding;

   public DeviceFilterVideoHolder(HolderDeviceFilterVideosBinding var1) {
      Intrinsics.checkNotNullParameter(var1, "binding");
      super((View)var1.getRoot());
      this.binding = var1;
   }

   // $FF: synthetic method
   public static void update$default(DeviceFilterVideoHolder var0, boolean var1, int var2, int var3, Object var4) {
      if ((var3 & 1) != 0) {
         var1 = false;
      }

      var0.update(var1, var2);
   }

   public final HolderDeviceFilterVideosBinding getBinding() {
      return this.binding;
   }

   public final void update(boolean var1, int var2) {
      TextView var3 = this.binding.videoSummary;
      Intrinsics.checkNotNullExpressionValue(var3, "videoSummary");
      ViewExtensionsKt.show((View)var3, var1);
      ConstraintLayout var4 = this.binding.videoThumbnailRoot;
      Intrinsics.checkNotNullExpressionValue(var4, "videoThumbnailRoot");
      ViewExtensionsKt.show((View)var4, var1 ^ true);
      this.binding.videoTitle.setText(var2);
   }

   @Metadata(
      d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"},
      d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceFilterVideoHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceFilterVideoHolder;", "parentView", "Landroid/view/ViewGroup;", "devicedetails_otherRelease"},
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

      public final DeviceFilterVideoHolder newInstance(ViewGroup var1) {
         Intrinsics.checkNotNullParameter(var1, "parentView");
         HolderDeviceFilterVideosBinding var2 = HolderDeviceFilterVideosBinding.inflate(LayoutInflater.from(var1.getContext()), var1, false);
         Intrinsics.checkNotNullExpressionValue(var2, "inflate(...)");
         return new DeviceFilterVideoHolder(var2);
      }
   }
}
