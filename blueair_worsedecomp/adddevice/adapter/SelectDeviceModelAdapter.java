package com.blueair.adddevice.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.auth.LocationService;
import io.reactivex.subjects.PublishSubject;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0015H\u0016J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0015H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR0\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u000f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u000f@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u0013¨\u0006\u001e"}, d2 = {"Lcom/blueair/adddevice/adapter/SelectDeviceModelAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/blueair/adddevice/adapter/DeviceModelViewholder;", "locationService", "Lcom/blueair/auth/LocationService;", "deviceSelectedPublisher", "Lio/reactivex/subjects/PublishSubject;", "Lcom/blueair/adddevice/adapter/DeviceModel;", "<init>", "(Lcom/blueair/auth/LocationService;Lio/reactivex/subjects/PublishSubject;)V", "defaultModelList", "", "getDefaultModelList", "()Ljava/util/List;", "value", "", "deviceList", "getDeviceList", "setDeviceList", "(Ljava/util/List;)V", "getItemCount", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", "position", "adddevice_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: SelectDeviceModelAdapter.kt */
public final class SelectDeviceModelAdapter extends RecyclerView.Adapter<DeviceModelViewholder> {
    private final List<DeviceModel> defaultModelList;
    private List<? extends DeviceModel> deviceList;
    private final PublishSubject<DeviceModel> deviceSelectedPublisher;
    private final LocationService locationService;

    public SelectDeviceModelAdapter(LocationService locationService2, PublishSubject<DeviceModel> publishSubject) {
        Intrinsics.checkNotNullParameter(locationService2, "locationService");
        Intrinsics.checkNotNullParameter(publishSubject, "deviceSelectedPublisher");
        this.locationService = locationService2;
        this.deviceSelectedPublisher = publishSubject;
        List<DeviceModel> mutableListOf = CollectionsKt.mutableListOf(DeviceModel.CLASSIC, DeviceModel.SENSE);
        if (locationService2.isInAwareRegion()) {
            mutableListOf.add(DeviceModel.AWARE);
        }
        if (locationService2.isInIcpRegion()) {
            mutableListOf.add(DeviceModel.ICP);
        }
        this.defaultModelList = mutableListOf;
        this.deviceList = mutableListOf;
    }

    public final List<DeviceModel> getDefaultModelList() {
        return this.defaultModelList;
    }

    public final List<DeviceModel> getDeviceList() {
        return this.deviceList;
    }

    public final void setDeviceList(List<? extends DeviceModel> list) {
        Intrinsics.checkNotNullParameter(list, "value");
        if (!Intrinsics.areEqual((Object) list, (Object) this.deviceList)) {
            this.deviceList = list;
            notifyDataSetChanged();
        }
    }

    public int getItemCount() {
        return this.deviceList.size();
    }

    public DeviceModelViewholder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        return DeviceModelViewholder.Companion.newInstance(viewGroup);
    }

    public void onBindViewHolder(DeviceModelViewholder deviceModelViewholder, int i) {
        Intrinsics.checkNotNullParameter(deviceModelViewholder, "holder");
        DeviceModel deviceModel = (DeviceModel) this.deviceList.get(i);
        deviceModelViewholder.update(deviceModel);
        deviceModelViewholder.getClickView().setOnClickListener(new SelectDeviceModelAdapter$$ExternalSyntheticLambda0(this, deviceModel));
    }

    /* access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$1(SelectDeviceModelAdapter selectDeviceModelAdapter, DeviceModel deviceModel, View view) {
        selectDeviceModelAdapter.deviceSelectedPublisher.onNext(deviceModel);
    }
}
