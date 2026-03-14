package com.blueair.devicedetails.viewholder;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.res.ResourcesCompat;
import androidx.viewbinding.ViewBinding;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceHumidifier;
import com.blueair.core.model.DeviceIcp;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.DeviceNewClassic;
import com.blueair.devicedetails.databinding.HolderDeviceHOfflineBinding;
import com.blueair.devicedetails.databinding.HolderDeviceOfflineBinding;
import com.blueair.viewcore.R;
import com.google.android.material.button.MaterialButton;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"},
   d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceOfflineHolder;", "Lcom/blueair/devicedetails/viewholder/DeviceAttributeHolder;", "binding", "Landroidx/viewbinding/ViewBinding;", "device", "Lcom/blueair/core/model/Device;", "onTroubleShootClickListener", "Lkotlin/Function0;", "", "<init>", "(Landroidx/viewbinding/ViewBinding;Lcom/blueair/core/model/Device;Lkotlin/jvm/functions/Function0;)V", "getBinding", "()Landroidx/viewbinding/ViewBinding;", "getDevice", "()Lcom/blueair/core/model/Device;", "getOnTroubleShootClickListener", "()Lkotlin/jvm/functions/Function0;", "separator", "Landroid/view/View;", "offlineImageview", "Landroid/widget/ImageView;", "subtitle", "Landroid/widget/TextView;", "troubleshootBtn", "Landroid/widget/Button;", "update", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceOfflineHolder extends DeviceAttributeHolder {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final ViewBinding binding;
   private final Device device;
   private final ImageView offlineImageview;
   private final Function0 onTroubleShootClickListener;
   private final View separator;
   private final TextView subtitle;
   private final Button troubleshootBtn;

   // $FF: synthetic method
   public static void $r8$lambda$gzGx2jG2Jhs_hHbmPq_yi1Hf8rc(DeviceOfflineHolder var0, View var1) {
      _init_$lambda$0(var0, var1);
   }

   public DeviceOfflineHolder(ViewBinding var1, Device var2, Function0 var3) {
      Intrinsics.checkNotNullParameter(var1, "binding");
      Intrinsics.checkNotNullParameter(var3, "onTroubleShootClickListener");
      View var5 = var1.getRoot();
      Intrinsics.checkNotNullExpressionValue(var5, "getRoot(...)");
      super(var5);
      this.binding = var1;
      this.device = var2;
      this.onTroubleShootClickListener = var3;
      if (var1 instanceof HolderDeviceHOfflineBinding) {
         this.separator = null;
         AppCompatImageView var7 = ((HolderDeviceHOfflineBinding)var1).offlineImageview;
         Intrinsics.checkNotNullExpressionValue(var7, "offlineImageview");
         this.offlineImageview = (ImageView)var7;
         TextView var8 = ((HolderDeviceHOfflineBinding)var1).subtitle;
         Intrinsics.checkNotNullExpressionValue(var8, "subtitle");
         this.subtitle = var8;
         MaterialButton var9 = ((HolderDeviceHOfflineBinding)var1).troubleshootBtn;
         Intrinsics.checkNotNullExpressionValue(var9, "troubleshootBtn");
         this.troubleshootBtn = (Button)var9;
         int var4;
         if (var2 instanceof DeviceHumidifier) {
            var4 = R.string.offline_title_humidifier;
         } else {
            var4 = R.string.offline_title;
         }

         ((HolderDeviceHOfflineBinding)var1).title.setText(var4);
      } else {
         Intrinsics.checkNotNull(var1, "null cannot be cast to non-null type com.blueair.devicedetails.databinding.HolderDeviceOfflineBinding");
         HolderDeviceOfflineBinding var10 = (HolderDeviceOfflineBinding)var1;
         this.separator = ((HolderDeviceOfflineBinding)var1).separator;
         AppCompatImageView var11 = ((HolderDeviceOfflineBinding)var1).offlineImageview;
         Intrinsics.checkNotNullExpressionValue(var11, "offlineImageview");
         this.offlineImageview = (ImageView)var11;
         TextView var12 = ((HolderDeviceOfflineBinding)var1).subtitle;
         Intrinsics.checkNotNullExpressionValue(var12, "subtitle");
         this.subtitle = var12;
         MaterialButton var6 = ((HolderDeviceOfflineBinding)var1).troubleshootBtn;
         Intrinsics.checkNotNullExpressionValue(var6, "troubleshootBtn");
         this.troubleshootBtn = (Button)var6;
      }

      if (var2 instanceof DeviceIcp) {
         ViewExtensionsKt.hide((View)this.troubleshootBtn);
      } else {
         this.troubleshootBtn.setOnClickListener(new DeviceOfflineHolder$$ExternalSyntheticLambda0(this));
      }
   }

   private static final void _init_$lambda$0(DeviceOfflineHolder var0, View var1) {
      var0.onTroubleShootClickListener.invoke();
   }

   public final ViewBinding getBinding() {
      return this.binding;
   }

   public final Device getDevice() {
      return this.device;
   }

   public final Function0 getOnTroubleShootClickListener() {
      return this.onTroubleShootClickListener;
   }

   public void update(Device var1) {
      Intrinsics.checkNotNullParameter(var1, "device");
      if (var1 instanceof DeviceNewClassic) {
         View var2 = this.separator;
         if (var2 != null) {
            ViewExtensionsKt.hide(var2);
         }

         this.binding.getRoot().setBackgroundTintList(ColorStateList.valueOf(0));
      } else {
         if (var1 instanceof DeviceIcp) {
            this.offlineImageview.setImageDrawable(ResourcesCompat.getDrawable(this.itemView.getResources(), R.drawable.ic_bluetooth_disabled, (Resources.Theme)null));
            this.subtitle.setText(this.itemView.getResources().getText(R.string.offline_subtitle_ble));
         }

      }
   }

   @Metadata(
      d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¨\u0006\r"},
      d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceOfflineHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceOfflineHolder;", "parentView", "Landroid/view/ViewGroup;", "device", "Lcom/blueair/core/model/Device;", "onTroubleShootClickListener", "Lkotlin/Function0;", "", "devicedetails_otherRelease"},
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

      public final DeviceOfflineHolder newInstance(ViewGroup var1, Device var2, Function0 var3) {
         Intrinsics.checkNotNullParameter(var1, "parentView");
         Intrinsics.checkNotNullParameter(var3, "onTroubleShootClickListener");
         Function3 var4;
         if (var2 != null && DeviceKt.isAfterG4(var2)) {
            var4 = null.INSTANCE;
         } else {
            var4 = null.INSTANCE;
         }

         LayoutInflater var5 = LayoutInflater.from(var1.getContext());
         Intrinsics.checkNotNullExpressionValue(var5, "from(...)");
         return new DeviceOfflineHolder((ViewBinding)var4.invoke(var5, var1, false), var2, var3);
      }
   }
}
