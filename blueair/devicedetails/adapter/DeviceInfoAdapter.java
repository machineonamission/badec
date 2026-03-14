package com.blueair.devicedetails.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.Device;
import com.blueair.devicedetails.util.DeviceInfo;
import com.blueair.devicedetails.util.DeviceInfoKt;
import com.blueair.devicedetails.util.DeviceInfoType;
import com.blueair.devicedetails.viewholder.DeviceSettingInfoHolder;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0011H\u0016J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0011H\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\t@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u001a"},
   d2 = {"Lcom/blueair/devicedetails/adapter/DeviceInfoAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/blueair/devicedetails/viewholder/DeviceSettingInfoHolder;", "<init>", "()V", "infos", "", "Lcom/blueair/devicedetails/util/DeviceInfo;", "value", "Lcom/blueair/core/model/Device;", "device", "getDevice", "()Lcom/blueair/core/model/Device;", "setDevice", "(Lcom/blueair/core/model/Device;)V", "deriveInfos", "getItemCount", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", "position", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceInfoAdapter extends RecyclerView.Adapter {
   private Device device;
   private List infos = CollectionsKt.emptyList();

   private final List deriveInfos(Device var1) {
      List var4 = (List)(new ArrayList());
      if (var1 != null) {
         DeviceInfoType[] var5 = DeviceInfoType.values();
         int var3 = var5.length;

         for(int var2 = 0; var2 < var3; ++var2) {
            DeviceInfo var6 = DeviceInfoKt.deriveInfo(var1, var5[var2]);
            if (var6 != null) {
               var4.add(var6);
            }
         }
      }

      return var4;
   }

   public final Device getDevice() {
      return this.device;
   }

   public int getItemCount() {
      return this.device != null ? this.infos.size() : 0;
   }

   public void onBindViewHolder(DeviceSettingInfoHolder var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "holder");
      var1.update((DeviceInfo)this.infos.get(var2));
   }

   public DeviceSettingInfoHolder onCreateViewHolder(ViewGroup var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "parent");
      return DeviceSettingInfoHolder.Companion.newInstance(var1);
   }

   public final void setDevice(Device var1) {
      if (!Intrinsics.areEqual(this.device, var1)) {
         this.device = var1;
         this.infos = this.deriveInfos(var1);
         this.notifyDataSetChanged();
      }

   }
}
