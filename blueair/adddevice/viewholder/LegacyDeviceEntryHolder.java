package com.blueair.adddevice.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.adddevice.adapter.DeviceModel;
import com.blueair.adddevice.databinding.HolderLegacyDeviceEntryBinding;
import com.blueair.adddevice.databinding.LayoutLegacyDeviceBinding;
import com.blueair.auth.LocationService;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0015"},
   d2 = {"Lcom/blueair/adddevice/viewholder/LegacyDeviceEntryHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/blueair/adddevice/databinding/HolderLegacyDeviceEntryBinding;", "locationService", "Lcom/blueair/auth/LocationService;", "<init>", "(Lcom/blueair/adddevice/databinding/HolderLegacyDeviceEntryBinding;Lcom/blueair/auth/LocationService;)V", "getBinding", "()Lcom/blueair/adddevice/databinding/HolderLegacyDeviceEntryBinding;", "clickView", "Landroid/view/View;", "getClickView", "()Landroid/view/View;", "hydrateDeviceModel", "", "layoutBinding", "Lcom/blueair/adddevice/databinding/LayoutLegacyDeviceBinding;", "model", "Lcom/blueair/adddevice/adapter/DeviceModel;", "Companion", "adddevice_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class LegacyDeviceEntryHolder extends RecyclerView.ViewHolder {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final HolderLegacyDeviceEntryBinding binding;
   private final View clickView;
   private final LocationService locationService;

   public LegacyDeviceEntryHolder(HolderLegacyDeviceEntryBinding var1, LocationService var2) {
      Intrinsics.checkNotNullParameter(var1, "binding");
      Intrinsics.checkNotNullParameter(var2, "locationService");
      super((View)var1.getRoot());
      this.binding = var1;
      this.locationService = var2;
      TextView var3 = var1.tvSelect;
      Intrinsics.checkNotNullExpressionValue(var3, "tvSelect");
      this.clickView = (View)var3;
      LayoutLegacyDeviceBinding var6 = var1.layoutClassic;
      Intrinsics.checkNotNullExpressionValue(var6, "layoutClassic");
      this.hydrateDeviceModel(var6, DeviceModel.CLASSIC);
      var6 = var1.layoutSense;
      Intrinsics.checkNotNullExpressionValue(var6, "layoutSense");
      this.hydrateDeviceModel(var6, DeviceModel.SENSE);
      if (var2.isInAwareRegion()) {
         var6 = var1.layoutAware;
         Intrinsics.checkNotNullExpressionValue(var6, "layoutAware");
         this.hydrateDeviceModel(var6, DeviceModel.AWARE);
         LinearLayout var9 = var1.layoutAware.getRoot();
         Intrinsics.checkNotNullExpressionValue(var9, "getRoot(...)");
         ViewExtensionsKt.show$default((View)var9, false, 1, (Object)null);
      }

      if (var2.isInIcpRegion()) {
         LayoutLegacyDeviceBinding var5 = var1.layoutIcp;
         Intrinsics.checkNotNullExpressionValue(var5, "layoutIcp");
         this.hydrateDeviceModel(var5, DeviceModel.ICP);
         LinearLayout var4 = var1.layoutIcp.getRoot();
         Intrinsics.checkNotNullExpressionValue(var4, "getRoot(...)");
         ViewExtensionsKt.show$default((View)var4, false, 1, (Object)null);
      }

   }

   private final void hydrateDeviceModel(LayoutLegacyDeviceBinding var1, DeviceModel var2) {
      var1.ivImage.setImageResource(var2.getModelImageRes());
      var1.tvTitle.setText((CharSequence)var2.getModelName());
   }

   public final HolderLegacyDeviceEntryBinding getBinding() {
      return this.binding;
   }

   public final View getClickView() {
      return this.clickView;
   }

   @Metadata(
      d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¨\u0006\n"},
      d2 = {"Lcom/blueair/adddevice/viewholder/LegacyDeviceEntryHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/adddevice/viewholder/LegacyDeviceEntryHolder;", "parentView", "Landroid/view/ViewGroup;", "locationService", "Lcom/blueair/auth/LocationService;", "adddevice_otherRelease"},
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

      public final LegacyDeviceEntryHolder newInstance(ViewGroup var1, LocationService var2) {
         Intrinsics.checkNotNullParameter(var1, "parentView");
         Intrinsics.checkNotNullParameter(var2, "locationService");
         HolderLegacyDeviceEntryBinding var3 = HolderLegacyDeviceEntryBinding.inflate(LayoutInflater.from(var1.getContext()), var1, false);
         Intrinsics.checkNotNullExpressionValue(var3, "inflate(...)");
         return new LegacyDeviceEntryHolder(var3, var2);
      }
   }
}
