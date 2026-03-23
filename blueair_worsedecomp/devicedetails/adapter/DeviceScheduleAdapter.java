package com.blueair.devicedetails.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceScheduleMerged;
import com.blueair.devicedetails.viewholder.DeviceScheduleEmptyViewHolder;
import com.blueair.devicedetails.viewholder.DeviceScheduleViewHolder;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 #2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001#BA\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n0\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001dH\u0016J\u0010\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001dH\u0016J\u0018\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u001dH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n0\f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R0\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\u00132\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\u0013@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006$"}, d2 = {"Lcom/blueair/devicedetails/adapter/DeviceScheduleAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "hasCustomName", "", "is24Format", "device", "Lcom/blueair/core/model/Device;", "onAdd", "Lkotlin/Function0;", "", "onScheduleTapped", "Lkotlin/Function1;", "Lcom/blueair/core/model/DeviceScheduleMerged;", "<init>", "(ZZLcom/blueair/core/model/Device;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "getOnScheduleTapped", "()Lkotlin/jvm/functions/Function1;", "value", "", "items", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "getItemCount", "getItemViewType", "position", "onBindViewHolder", "holder", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceScheduleAdapter.kt */
public final class DeviceScheduleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int emptyVH = 1;
    public static final int item = 0;
    private final Device device;
    private final boolean hasCustomName;
    private final boolean is24Format;
    private List<DeviceScheduleMerged> items = CollectionsKt.emptyList();
    private final Function0<Unit> onAdd;
    private final Function1<DeviceScheduleMerged, Unit> onScheduleTapped;

    public final Function1<DeviceScheduleMerged, Unit> getOnScheduleTapped() {
        return this.onScheduleTapped;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/blueair/devicedetails/adapter/DeviceScheduleAdapter$Companion;", "", "<init>", "()V", "item", "", "emptyVH", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceScheduleAdapter.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public DeviceScheduleAdapter(boolean z, boolean z2, Device device2, Function0<Unit> function0, Function1<? super DeviceScheduleMerged, Unit> function1) {
        Intrinsics.checkNotNullParameter(device2, "device");
        Intrinsics.checkNotNullParameter(function0, "onAdd");
        Intrinsics.checkNotNullParameter(function1, "onScheduleTapped");
        this.hasCustomName = z;
        this.is24Format = z2;
        this.device = device2;
        this.onAdd = function0;
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

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        if (i == 0) {
            return DeviceScheduleViewHolder.Companion.instance(viewGroup);
        }
        if (i == 1) {
            return DeviceScheduleEmptyViewHolder.Companion.instance(viewGroup);
        }
        throw new Exception("Device schedule adapter view not supported");
    }

    public int getItemCount() {
        if (this.items.size() == 0) {
            return 1;
        }
        return this.items.size();
    }

    public int getItemViewType(int i) {
        return this.items.size() == 0 ? 1 : 0;
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        if (viewHolder instanceof DeviceScheduleEmptyViewHolder) {
            ((DeviceScheduleEmptyViewHolder) viewHolder).bind(this.onAdd);
        } else if (viewHolder instanceof DeviceScheduleViewHolder) {
            DeviceScheduleMerged deviceScheduleMerged = this.items.get(i);
            DeviceScheduleViewHolder deviceScheduleViewHolder = (DeviceScheduleViewHolder) viewHolder;
            deviceScheduleViewHolder.bind(this.hasCustomName, this.is24Format, deviceScheduleMerged, this.device);
            deviceScheduleViewHolder.getBinding().rootLayout.setOnClickListener(new DeviceScheduleAdapter$$ExternalSyntheticLambda0(this, deviceScheduleMerged));
        }
    }

    /* access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0(DeviceScheduleAdapter deviceScheduleAdapter, DeviceScheduleMerged deviceScheduleMerged, View view) {
        deviceScheduleAdapter.onScheduleTapped.invoke(deviceScheduleMerged);
    }
}
