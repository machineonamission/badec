package com.blueair.devicedetails.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceScheduleMerged;
import com.blueair.devicedetails.viewholder.DeviceNScheduleViewHolder;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B3\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0018\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001bH\u0016J\b\u0010\u001f\u001a\u00020\u001bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR0\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\u00112\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\u0011@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006 "}, d2 = {"Lcom/blueair/devicedetails/adapter/DeviceNScheduleAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/blueair/devicedetails/viewholder/DeviceNScheduleViewHolder;", "hasCustomName", "", "is24Format", "device", "Lcom/blueair/core/model/Device;", "onScheduleTapped", "Lkotlin/Function1;", "Lcom/blueair/core/model/DeviceScheduleMerged;", "", "<init>", "(ZZLcom/blueair/core/model/Device;Lkotlin/jvm/functions/Function1;)V", "getOnScheduleTapped", "()Lkotlin/jvm/functions/Function1;", "value", "", "items", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "getItemCount", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceNScheduleAdapter.kt */
public final class DeviceNScheduleAdapter extends RecyclerView.Adapter<DeviceNScheduleViewHolder> {
    private final Device device;
    private final boolean hasCustomName;
    private final boolean is24Format;
    private List<DeviceScheduleMerged> items = CollectionsKt.emptyList();
    private final Function1<DeviceScheduleMerged, Unit> onScheduleTapped;

    public final Function1<DeviceScheduleMerged, Unit> getOnScheduleTapped() {
        return this.onScheduleTapped;
    }

    public DeviceNScheduleAdapter(boolean z, boolean z2, Device device2, Function1<? super DeviceScheduleMerged, Unit> function1) {
        Intrinsics.checkNotNullParameter(device2, "device");
        Intrinsics.checkNotNullParameter(function1, "onScheduleTapped");
        this.hasCustomName = z;
        this.is24Format = z2;
        this.device = device2;
        this.onScheduleTapped = function1;
    }

    public final List<DeviceScheduleMerged> getItems() {
        return this.items;
    }

    public final void setItems(List<DeviceScheduleMerged> list) {
        Intrinsics.checkNotNullParameter(list, "value");
        this.items = list;
        notifyDataSetChanged();
    }

    public DeviceNScheduleViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        return DeviceNScheduleViewHolder.Companion.newInstance(viewGroup, this.device);
    }

    public void onBindViewHolder(DeviceNScheduleViewHolder deviceNScheduleViewHolder, int i) {
        Intrinsics.checkNotNullParameter(deviceNScheduleViewHolder, "holder");
        DeviceScheduleMerged deviceScheduleMerged = this.items.get(i);
        deviceNScheduleViewHolder.bind(this.hasCustomName, this.is24Format, deviceScheduleMerged);
        deviceNScheduleViewHolder.getBinding().getRoot().setOnClickListener(new DeviceNScheduleAdapter$$ExternalSyntheticLambda0(this, deviceScheduleMerged));
    }

    /* access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0(DeviceNScheduleAdapter deviceNScheduleAdapter, DeviceScheduleMerged deviceScheduleMerged, View view) {
        deviceNScheduleAdapter.onScheduleTapped.invoke(deviceScheduleMerged);
    }

    public int getItemCount() {
        return this.items.size();
    }
}
