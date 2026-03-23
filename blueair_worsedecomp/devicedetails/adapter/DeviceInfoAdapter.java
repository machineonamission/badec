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

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0011H\u0016J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0011H\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u000e¢\u0006\u0002\n\u0000R(\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\t@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/blueair/devicedetails/adapter/DeviceInfoAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/blueair/devicedetails/viewholder/DeviceSettingInfoHolder;", "<init>", "()V", "infos", "", "Lcom/blueair/devicedetails/util/DeviceInfo;", "value", "Lcom/blueair/core/model/Device;", "device", "getDevice", "()Lcom/blueair/core/model/Device;", "setDevice", "(Lcom/blueair/core/model/Device;)V", "deriveInfos", "getItemCount", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", "position", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceInfoAdapter.kt */
public final class DeviceInfoAdapter extends RecyclerView.Adapter<DeviceSettingInfoHolder> {
    private Device device;
    private List<DeviceInfo> infos = CollectionsKt.emptyList();

    public final Device getDevice() {
        return this.device;
    }

    public final void setDevice(Device device2) {
        if (!Intrinsics.areEqual((Object) this.device, (Object) device2)) {
            this.device = device2;
            this.infos = deriveInfos(device2);
            notifyDataSetChanged();
        }
    }

    private final List<DeviceInfo> deriveInfos(Device device2) {
        List<DeviceInfo> arrayList = new ArrayList<>();
        if (device2 != null) {
            for (DeviceInfoType deriveInfo : DeviceInfoType.values()) {
                DeviceInfo deriveInfo2 = DeviceInfoKt.deriveInfo(device2, deriveInfo);
                if (deriveInfo2 != null) {
                    arrayList.add(deriveInfo2);
                }
            }
        }
        return arrayList;
    }

    public int getItemCount() {
        if (this.device != null) {
            return this.infos.size();
        }
        return 0;
    }

    public DeviceSettingInfoHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        return DeviceSettingInfoHolder.Companion.newInstance(viewGroup);
    }

    public void onBindViewHolder(DeviceSettingInfoHolder deviceSettingInfoHolder, int i) {
        Intrinsics.checkNotNullParameter(deviceSettingInfoHolder, "holder");
        deviceSettingInfoHolder.update(this.infos.get(i));
    }
}
