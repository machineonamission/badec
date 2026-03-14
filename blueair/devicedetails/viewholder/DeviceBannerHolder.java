package com.blueair.devicedetails.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.Device;
import com.blueair.devicedetails.adapter.DeviceBannerAdapter;
import com.blueair.devicedetails.databinding.HolderDeviceBannerBinding;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"},
   d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceBannerHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/blueair/devicedetails/databinding/HolderDeviceBannerBinding;", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceBannerBinding;)V", "getBinding", "()Lcom/blueair/devicedetails/databinding/HolderDeviceBannerBinding;", "bind", "", "banner", "Lcom/blueair/devicedetails/adapter/DeviceBannerAdapter$Banner;", "device", "Lcom/blueair/core/model/Device;", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceBannerHolder extends RecyclerView.ViewHolder {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final HolderDeviceBannerBinding binding;

   public DeviceBannerHolder(HolderDeviceBannerBinding var1) {
      Intrinsics.checkNotNullParameter(var1, "binding");
      super((View)var1.getRoot());
      this.binding = var1;
   }

   public final void bind(DeviceBannerAdapter.Banner var1, Device var2) {
      Intrinsics.checkNotNullParameter(var1, "banner");
      Intrinsics.checkNotNullParameter(var2, "device");
      HolderDeviceBannerBinding var3 = this.binding;
      if (Intrinsics.areEqual(var1, DeviceBannerAdapter.Banner.WarningWaterShortage.INSTANCE)) {
         ImageView var4 = var3.warningIcon;
         Intrinsics.checkNotNullExpressionValue(var4, "warningIcon");
         ViewExtensionsKt.hide((View)var4);
         var3.title.setText((CharSequence)this.itemView.getContext().getString(var1.getTitleRes(), new Object[]{var2.getName()}));
         var3.message.setText((CharSequence)this.itemView.getContext().getString(var1.getMessageRes(), new Object[]{var2.getName()}));
      } else {
         ImageView var5 = var3.warningIcon;
         Intrinsics.checkNotNullExpressionValue(var5, "warningIcon");
         ViewExtensionsKt.show$default((View)var5, false, 1, (Object)null);
         var3.title.setText(var1.getTitleRes());
         var3.message.setText(var1.getMessageRes());
      }
   }

   public final HolderDeviceBannerBinding getBinding() {
      return this.binding;
   }

   @Metadata(
      d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"},
      d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceBannerHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceBannerHolder;", "parentView", "Landroid/view/ViewGroup;", "devicedetails_otherRelease"},
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

      public final DeviceBannerHolder newInstance(ViewGroup var1) {
         Intrinsics.checkNotNullParameter(var1, "parentView");
         HolderDeviceBannerBinding var2 = HolderDeviceBannerBinding.inflate(LayoutInflater.from(var1.getContext()), var1, false);
         Intrinsics.checkNotNullExpressionValue(var2, "inflate(...)");
         return new DeviceBannerHolder(var2);
      }
   }
}
