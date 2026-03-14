package com.blueair.devicedetails.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceCombo2in1;
import com.blueair.core.model.DevicePet20;
import com.blueair.core.model.HasBody;
import com.blueair.core.model.HasFanSpeed;
import com.blueair.core.model.HasWaterLevel;
import com.blueair.core.model.HasWick;
import com.blueair.core.model.WaterLevel;
import com.blueair.devicedetails.viewholder.DeviceBannerHolder;
import com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel;
import com.blueair.viewcore.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u0018\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001aH\u0016J\u0018\u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u001aH\u0016R*\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R(\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0005\u001a\u0004\u0018\u00010\u0011@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006#"},
   d2 = {"Lcom/blueair/devicedetails/adapter/DeviceBannerAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/blueair/devicedetails/viewholder/DeviceBannerHolder;", "<init>", "()V", "value", "", "Lcom/blueair/devicedetails/adapter/DeviceBannerAdapter$Banner;", "banners", "setBanners", "(Ljava/util/List;)V", "viewModel", "Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;", "getViewModel", "()Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;", "setViewModel", "(Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;)V", "Lcom/blueair/core/model/Device;", "device", "getDevice", "()Lcom/blueair/core/model/Device;", "setDevice", "(Lcom/blueair/core/model/Device;)V", "refreshBanners", "", "getItemCount", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "Banner", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceBannerAdapter extends RecyclerView.Adapter {
   private List banners = CollectionsKt.emptyList();
   private Device device;
   public DeviceDetailsViewModel viewModel;

   // $FF: synthetic method
   public static void $r8$lambda$dnDGlpgVvGpnuGReV63WZf3GZg0(Banner var0, DeviceBannerAdapter var1, View var2) {
      onBindViewHolder$lambda$4(var0, var1, var2);
   }

   private static final void onBindViewHolder$lambda$4(Banner var0, DeviceBannerAdapter var1, View var2) {
      if (var0 instanceof Banner.WarningBodyNotMounted) {
         var1.getViewModel().setBannerBodyNotMountedClosed(true);
      } else if (var0 instanceof Banner.WarningFilterExpired) {
         var1.getViewModel().setBannerFilterExpiredClosed(true);
      } else if (var0 instanceof Banner.WarningWickExpired) {
         var1.getViewModel().setBannerWickExpiredClosed(true);
      } else {
         if (!(var0 instanceof Banner.WarningWaterShortage)) {
            throw new NoWhenBranchMatchedException();
         }

         var1.getViewModel().setBannerWaterShortageClosed(true);
      }

      Device var3 = var1.device;
      if (var3 != null) {
         var1.refreshBanners(var3);
      }

   }

   private final void refreshBanners(Device var1) {
      List var6 = (List)(new ArrayList());
      if (var1 instanceof HasBody && !((HasBody)var1).getBodyMounted() && !this.getViewModel().getBannerBodyNotMountedClosed()) {
         var6.add(DeviceBannerAdapter.Banner.WarningBodyNotMounted.INSTANCE);
      }

      boolean var3 = var1 instanceof DeviceCombo2in1;
      Object var5 = null;
      if (var3 || var1 instanceof DevicePet20) {
         HasFanSpeed var4;
         if (var1 instanceof HasFanSpeed) {
            var4 = (HasFanSpeed)var1;
         } else {
            var4 = null;
         }

         int var2;
         label53: {
            if (var4 != null) {
               Integer var8 = var4.getFilterLife();
               if (var8 != null) {
                  var2 = var8;
                  break label53;
               }
            }

            var2 = 0;
         }

         if (var2 >= 100 && !this.getViewModel().getBannerFilterExpiredClosed()) {
            var6.add(DeviceBannerAdapter.Banner.WarningFilterExpired.INSTANCE);
         }
      }

      HasWick var9 = (HasWick)var5;
      if (var1 instanceof HasWick) {
         var9 = (HasWick)var1;
      }

      if (var9 != null) {
         if (var9.getWickUsage() >= 100 && !this.getViewModel().getBannerWickExpiredClosed()) {
            var6.add(DeviceBannerAdapter.Banner.WarningWickExpired.INSTANCE);
         }

         if (var1 instanceof HasWaterLevel) {
            var3 = ((HasWaterLevel)var1).isInWaterLevel(WaterLevel.SHORTAGE);
         } else {
            var3 = var9.getWaterShortage();
         }

         if (var3 && !this.getViewModel().getBannerWaterShortageClosed()) {
            var6.add(DeviceBannerAdapter.Banner.WarningWaterShortage.INSTANCE);
         }
      }

      this.setBanners(var6);
   }

   private final void setBanners(List var1) {
      if (!Intrinsics.areEqual(this.banners, var1)) {
         this.banners = var1;
         this.notifyDataSetChanged();
      }
   }

   public final Device getDevice() {
      return this.device;
   }

   public int getItemCount() {
      return this.banners.size();
   }

   public final DeviceDetailsViewModel getViewModel() {
      DeviceDetailsViewModel var1 = this.viewModel;
      if (var1 != null) {
         return var1;
      } else {
         Intrinsics.throwUninitializedPropertyAccessException("viewModel");
         return null;
      }
   }

   public void onBindViewHolder(DeviceBannerHolder var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "holder");
      Banner var4 = (Banner)this.banners.get(var2);
      Device var3 = this.device;
      if (var3 != null) {
         var1.bind(var4, var3);
      }

      var1.getBinding().closeBtn.setOnClickListener(new DeviceBannerAdapter$$ExternalSyntheticLambda0(var4, this));
   }

   public DeviceBannerHolder onCreateViewHolder(ViewGroup var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "parent");
      return DeviceBannerHolder.Companion.newInstance(var1);
   }

   public final void setDevice(Device var1) {
      if (!Intrinsics.areEqual(this.device, var1)) {
         this.device = var1;
         if (var1 != null) {
            this.refreshBanners(var1);
         }
      }

   }

   public final void setViewModel(DeviceDetailsViewModel var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.viewModel = var1;
   }

   @Metadata(
      d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\n\u000b\f\rB\u0019\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b\u0082\u0001\u0004\u000e\u000f\u0010\u0011¨\u0006\u0012"},
      d2 = {"Lcom/blueair/devicedetails/adapter/DeviceBannerAdapter$Banner;", "", "titleRes", "", "messageRes", "<init>", "(II)V", "getTitleRes", "()I", "getMessageRes", "WarningBodyNotMounted", "WarningFilterExpired", "WarningWickExpired", "WarningWaterShortage", "Lcom/blueair/devicedetails/adapter/DeviceBannerAdapter$Banner$WarningBodyNotMounted;", "Lcom/blueair/devicedetails/adapter/DeviceBannerAdapter$Banner$WarningFilterExpired;", "Lcom/blueair/devicedetails/adapter/DeviceBannerAdapter$Banner$WarningWaterShortage;", "Lcom/blueair/devicedetails/adapter/DeviceBannerAdapter$Banner$WarningWickExpired;", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public abstract static class Banner {
      private final int messageRes;
      private final int titleRes;

      private Banner(int var1, int var2) {
         this.titleRes = var1;
         this.messageRes = var2;
      }

      // $FF: synthetic method
      public Banner(int var1, int var2, DefaultConstructorMarker var3) {
         this(var1, var2);
      }

      public final int getMessageRes() {
         return this.messageRes;
      }

      public final int getTitleRes() {
         return this.titleRes;
      }

      @Metadata(
         d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
         d2 = {"Lcom/blueair/devicedetails/adapter/DeviceBannerAdapter$Banner$WarningBodyNotMounted;", "Lcom/blueair/devicedetails/adapter/DeviceBannerAdapter$Banner;", "<init>", "()V", "devicedetails_otherRelease"},
         k = 1,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class WarningBodyNotMounted extends Banner {
         public static final WarningBodyNotMounted INSTANCE = new WarningBodyNotMounted();

         private WarningBodyNotMounted() {
            super(R.string.body_not_in_position, R.string.body_not_in_position_desc, (DefaultConstructorMarker)null);
         }
      }

      @Metadata(
         d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
         d2 = {"Lcom/blueair/devicedetails/adapter/DeviceBannerAdapter$Banner$WarningFilterExpired;", "Lcom/blueair/devicedetails/adapter/DeviceBannerAdapter$Banner;", "<init>", "()V", "devicedetails_otherRelease"},
         k = 1,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class WarningFilterExpired extends Banner {
         public static final WarningFilterExpired INSTANCE = new WarningFilterExpired();

         private WarningFilterExpired() {
            super(R.string.warning_title_filter_expired, R.string.warning_msg_wick_expired, (DefaultConstructorMarker)null);
         }
      }

      @Metadata(
         d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
         d2 = {"Lcom/blueair/devicedetails/adapter/DeviceBannerAdapter$Banner$WarningWaterShortage;", "Lcom/blueair/devicedetails/adapter/DeviceBannerAdapter$Banner;", "<init>", "()V", "devicedetails_otherRelease"},
         k = 1,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class WarningWaterShortage extends Banner {
         public static final WarningWaterShortage INSTANCE = new WarningWaterShortage();

         private WarningWaterShortage() {
            super(R.string.notification_template_title_water_shortage_new, R.string.notification_template_content_water_shortage_new, (DefaultConstructorMarker)null);
         }
      }

      @Metadata(
         d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
         d2 = {"Lcom/blueair/devicedetails/adapter/DeviceBannerAdapter$Banner$WarningWickExpired;", "Lcom/blueair/devicedetails/adapter/DeviceBannerAdapter$Banner;", "<init>", "()V", "devicedetails_otherRelease"},
         k = 1,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class WarningWickExpired extends Banner {
         public static final WarningWickExpired INSTANCE = new WarningWickExpired();

         private WarningWickExpired() {
            super(R.string.warning_title_wick_expired, R.string.warning_msg_wick_expired, (DefaultConstructorMarker)null);
         }
      }
   }
}
