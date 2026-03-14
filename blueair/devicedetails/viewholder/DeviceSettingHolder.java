package com.blueair.devicedetails.viewholder;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.ConnectivityStatus;
import com.blueair.core.model.Device;
import com.blueair.viewcore.view.SwitchCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u0004\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0014\u0010\f\u001a\u0004\u0018\u00010\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0017"},
   d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceSettingHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "settingTitle", "Landroid/widget/TextView;", "getSettingTitle", "()Landroid/widget/TextView;", "settingSummary", "getSettingSummary", "settingSwitch", "Lcom/blueair/viewcore/view/SwitchCompat;", "getSettingSwitch", "()Lcom/blueair/viewcore/view/SwitchCompat;", "update", "", "device", "Lcom/blueair/core/model/Device;", "connectivityCheck", "setOnline", "setOffline", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public abstract class DeviceSettingHolder extends RecyclerView.ViewHolder {
   public DeviceSettingHolder(View var1) {
      Intrinsics.checkNotNullParameter(var1, "itemView");
      super(var1);
   }

   private final void connectivityCheck(Device var1) {
      ConnectivityStatus var3 = var1.getConnectivityStatus();
      int var2 = DeviceSettingHolder.WhenMappings.$EnumSwitchMapping$0[var3.ordinal()];
      if (var2 != 1) {
         if (var2 != 2 && var2 != 3) {
            this.setOffline(var1);
         } else {
            this.setOffline(var1);
         }
      } else {
         this.setOnline(var1);
      }
   }

   public abstract TextView getSettingSummary();

   public abstract SwitchCompat getSettingSwitch();

   public abstract TextView getSettingTitle();

   public void setOffline(Device var1) {
      Intrinsics.checkNotNullParameter(var1, "device");
      SwitchCompat var2 = this.getSettingSwitch();
      if (var2 != null) {
         var2.setEnabled(false);
      }

   }

   public void setOnline(Device var1) {
      Intrinsics.checkNotNullParameter(var1, "device");
      SwitchCompat var2 = this.getSettingSwitch();
      if (var2 != null) {
         var2.setEnabled(true);
      }

   }

   public void update(Device var1) {
      Intrinsics.checkNotNullParameter(var1, "device");
      this.connectivityCheck(var1);
   }

   // $FF: synthetic class
   @Metadata(
      k = 3,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class WhenMappings {
      public static final int[] $EnumSwitchMapping$0;

      static {
         int[] var0 = new int[ConnectivityStatus.values().length];

         try {
            var0[ConnectivityStatus.ONLINE.ordinal()] = 1;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[ConnectivityStatus.CONNECTING.ordinal()] = 2;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[ConnectivityStatus.OFFLINE.ordinal()] = 3;
         } catch (NoSuchFieldError var2) {
         }

         $EnumSwitchMapping$0 = var0;
      }
   }
}
