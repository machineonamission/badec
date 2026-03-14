package com.blueair.adddevice.viewholder;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.Group;
import androidx.core.util.TypedValueCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.adddevice.databinding.HolderScannedDeviceBinding;
import com.blueair.adddevice.model.BluetoothConnectingState;
import com.blueair.core.model.BluetoothDevice;
import com.blueair.core.model.DeviceImage;
import com.blueair.viewcore.R;
import com.blueair.viewcore.utils.DeviceConfigProvider;
import com.dd.ShadowLayout;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u0010\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"},
   d2 = {"Lcom/blueair/adddevice/viewholder/ScannedDeviceSummaryHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/blueair/adddevice/databinding/HolderScannedDeviceBinding;", "<init>", "(Lcom/blueair/adddevice/databinding/HolderScannedDeviceBinding;)V", "getBinding", "()Lcom/blueair/adddevice/databinding/HolderScannedDeviceBinding;", "clickView", "Landroid/view/View;", "getClickView", "()Landroid/view/View;", "padding", "", "getPadding", "()I", "padding$delegate", "Lkotlin/Lazy;", "update", "", "device", "Lcom/blueair/core/model/BluetoothDevice;", "connectingState", "Lcom/blueair/adddevice/model/BluetoothConnectingState;", "hydrateOnlineStatus", "Companion", "adddevice_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class ScannedDeviceSummaryHolder extends RecyclerView.ViewHolder {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final HolderScannedDeviceBinding binding;
   private final View clickView;
   private final Lazy padding$delegate;

   // $FF: synthetic method
   public static int $r8$lambda$8i2__oNE8F4qG7RZEJEdX5Gbqys/* $FF was: $r8$lambda$8i2-_oNE8F4qG7RZEJEdX5Gbqys*/(ScannedDeviceSummaryHolder var0) {
      return padding_delegate$lambda$0(var0);
   }

   public ScannedDeviceSummaryHolder(HolderScannedDeviceBinding var1) {
      Intrinsics.checkNotNullParameter(var1, "binding");
      super((View)var1.getRoot());
      this.binding = var1;
      ShadowLayout var2 = var1.slRoot;
      Intrinsics.checkNotNullExpressionValue(var2, "slRoot");
      this.clickView = (View)var2;
      this.padding$delegate = LazyKt.lazy(new ScannedDeviceSummaryHolder$$ExternalSyntheticLambda0(this));
   }

   private final int getPadding() {
      return ((Number)this.padding$delegate.getValue()).intValue();
   }

   private final void hydrateOnlineStatus(BluetoothDevice var1) {
      Boolean var3 = var1.isOnline();
      Boolean var2 = true;
      if (Intrinsics.areEqual(var3, var2)) {
         this.binding.clRoot.setBackgroundResource(R.drawable.rounded_rectangle_grey_r20_dark10_stroke1);
      } else {
         this.binding.clRoot.setBackgroundResource(R.drawable.rounded_rectangle_white_r20_dark10_stroke1);
      }

      Group var6 = this.binding.groupMac;
      Intrinsics.checkNotNullExpressionValue(var6, "groupMac");
      ViewExtensionsKt.show((View)var6, Intrinsics.areEqual(var1.isOnline(), false) ^ true);
      if (var1.isOnline() == null) {
         TextView var5 = this.binding.model;
         Intrinsics.checkNotNullExpressionValue(var5, "model");
         ViewExtensionsKt.show((View)var5, var1.isUnknownSku() ^ true);
         TextView var4 = this.binding.tvOnlineStatus;
         Intrinsics.checkNotNullExpressionValue(var4, "tvOnlineStatus");
         ViewExtensionsKt.hide((View)var4);
      } else {
         TextView var7 = this.binding.model;
         Intrinsics.checkNotNullExpressionValue(var7, "model");
         ViewExtensionsKt.hide((View)var7);
         var7 = this.binding.tvOnlineStatus;
         if (Intrinsics.areEqual(var1.isOnline(), var2)) {
            var7.setText(R.string.connected);
            Intrinsics.checkNotNull(var7);
            ((View)var7).setPadding(0, 0, 0, 0);
            var7.setBackground((Drawable)null);
            var7.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.ic_connected_contained, 0);
         } else {
            var7.setText(R.string.offline_label);
            var7.setPadding(this.getPadding() * 2, this.getPadding(), this.getPadding() * 2, this.getPadding());
            var7.setBackgroundResource(R.drawable.rounded_rectangle_dark_5_r8);
            var7.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, 0, 0);
         }

         Intrinsics.checkNotNull(var7);
         ViewExtensionsKt.show$default((View)var7, false, 1, (Object)null);
      }
   }

   private static final int padding_delegate$lambda$0(ScannedDeviceSummaryHolder var0) {
      return (int)TypedValueCompat.dpToPx(4.0F, var0.binding.getRoot().getResources().getDisplayMetrics());
   }

   public final HolderScannedDeviceBinding getBinding() {
      return this.binding;
   }

   public final View getClickView() {
      return this.clickView;
   }

   public final void update(BluetoothDevice var1, BluetoothConnectingState var2) {
      Intrinsics.checkNotNullParameter(var1, "device");
      Intrinsics.checkNotNullParameter(var2, "connectingState");
      TextView var4 = this.binding.name;
      String var5;
      if (var1.isUnknownSku()) {
         var5 = this.itemView.getContext().getString(R.string.unknown_device);
      } else {
         var5 = var1.getFamilyName();
      }

      var4.setText((CharSequence)var5);
      var4 = this.binding.model;
      if (var1.isUnknownSku()) {
         var5 = this.itemView.getContext().getString(R.string.unknown_device);
      } else {
         var5 = var1.getModelName();
      }

      var4.setText((CharSequence)var5);
      this.binding.macNumber.setText((CharSequence)var1.getWifiMac());
      if (var1.isUnknownSku()) {
         AppCompatImageView var7 = this.binding.deviceImg;
         Intrinsics.checkNotNullExpressionValue(var7, "deviceImg");
         ViewExtensionsKt.hide((View)var7);
         TextView var8 = this.binding.connectedLabel;
         Intrinsics.checkNotNullExpressionValue(var8, "connectedLabel");
         ViewExtensionsKt.hide((View)var8);
      } else {
         AppCompatImageView var13 = this.binding.deviceImg;
         DeviceImage var9 = DeviceConfigProvider.INSTANCE.getDeviceImage(var1);
         int var3;
         if (var9 != null) {
            var3 = var9.getDevice();
         } else {
            var3 = 0;
         }

         var13.setImageResource(var3);
         AppCompatImageView var10 = this.binding.deviceImg;
         Intrinsics.checkNotNullExpressionValue(var10, "deviceImg");
         ViewExtensionsKt.show$default((View)var10, false, 1, (Object)null);
         TextView var11 = this.binding.connectedLabel;
         Intrinsics.checkNotNullExpressionValue(var11, "connectedLabel");
         ViewExtensionsKt.show((View)var11, Intrinsics.areEqual(var1.isOnline(), true) ^ true);
      }

      this.hydrateOnlineStatus(var1);
   }

   @Metadata(
      d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"},
      d2 = {"Lcom/blueair/adddevice/viewholder/ScannedDeviceSummaryHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/adddevice/viewholder/ScannedDeviceSummaryHolder;", "parentView", "Landroid/view/ViewGroup;", "adddevice_otherRelease"},
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

      public final ScannedDeviceSummaryHolder newInstance(ViewGroup var1) {
         Intrinsics.checkNotNullParameter(var1, "parentView");
         HolderScannedDeviceBinding var2 = HolderScannedDeviceBinding.inflate(LayoutInflater.from(var1.getContext()), var1, false);
         Intrinsics.checkNotNullExpressionValue(var2, "inflate(...)");
         return new ScannedDeviceSummaryHolder(var2);
      }
   }
}
