package com.blueair.devicedetails.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceSchedule;
import com.blueair.core.model.DeviceScheduleMerged;
import com.blueair.devicedetails.viewholder.ScheduleCardEmptyViewHolder;
import com.blueair.devicedetails.viewholder.ScheduleCardViewHolder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 '2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001'B[\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n0\f\u0012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n0\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020!H\u0016J\u0010\u0010#\u001a\u00020!2\u0006\u0010$\u001a\u00020!H\u0016J\u0018\u0010%\u001a\u00020\n2\u0006\u0010&\u001a\u00020\u00022\u0006\u0010$\u001a\u00020!H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000R#\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n0\f¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n0\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R0\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\r0\u00172\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\r0\u0017@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006("}, d2 = {"Lcom/blueair/devicedetails/adapter/ScheduleCardAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "hasCustomName", "", "is24Format", "device", "Lcom/blueair/core/model/Device;", "onCreate", "Lkotlin/Function0;", "", "onScheduleChecked", "Lkotlin/Function2;", "Lcom/blueair/core/model/DeviceScheduleMerged;", "onScheduleTapped", "Lkotlin/Function1;", "<init>", "(ZZLcom/blueair/core/model/Device;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;)V", "getOnScheduleChecked", "()Lkotlin/jvm/functions/Function2;", "getOnScheduleTapped", "()Lkotlin/jvm/functions/Function1;", "value", "", "items", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "getItemCount", "getItemViewType", "position", "onBindViewHolder", "holder", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: ScheduleCardAdapter.kt */
public final class ScheduleCardAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int CARD_ITEM = 0;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int EMPTY_VIEW = 1;
    private final Device device;
    private final boolean hasCustomName;
    private final boolean is24Format;
    private List<DeviceScheduleMerged> items = CollectionsKt.emptyList();
    private final Function0<Unit> onCreate;
    private final Function2<DeviceScheduleMerged, Boolean, Unit> onScheduleChecked;
    private final Function1<DeviceScheduleMerged, Unit> onScheduleTapped;

    public final Function2<DeviceScheduleMerged, Boolean, Unit> getOnScheduleChecked() {
        return this.onScheduleChecked;
    }

    public final Function1<DeviceScheduleMerged, Unit> getOnScheduleTapped() {
        return this.onScheduleTapped;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/blueair/devicedetails/adapter/ScheduleCardAdapter$Companion;", "", "<init>", "()V", "CARD_ITEM", "", "EMPTY_VIEW", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: ScheduleCardAdapter.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public ScheduleCardAdapter(boolean z, boolean z2, Device device2, Function0<Unit> function0, Function2<? super DeviceScheduleMerged, ? super Boolean, Unit> function2, Function1<? super DeviceScheduleMerged, Unit> function1) {
        Intrinsics.checkNotNullParameter(device2, "device");
        Intrinsics.checkNotNullParameter(function0, "onCreate");
        Intrinsics.checkNotNullParameter(function2, "onScheduleChecked");
        Intrinsics.checkNotNullParameter(function1, "onScheduleTapped");
        this.hasCustomName = z;
        this.is24Format = z2;
        this.device = device2;
        this.onCreate = function0;
        this.onScheduleChecked = function2;
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
            return ScheduleCardViewHolder.Companion.instance(viewGroup);
        }
        if (i == 1) {
            return ScheduleCardEmptyViewHolder.Companion.instance(viewGroup);
        }
        throw new Exception("Device schedule adapter view not supported");
    }

    public int getItemCount() {
        if (this.items.isEmpty()) {
            return 1;
        }
        return this.items.size();
    }

    public int getItemViewType(int i) {
        return this.items.isEmpty() ? 1 : 0;
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        if (viewHolder instanceof ScheduleCardEmptyViewHolder) {
            ((ScheduleCardEmptyViewHolder) viewHolder).bind(this.onCreate);
        } else if (viewHolder instanceof ScheduleCardViewHolder) {
            DeviceScheduleMerged deviceScheduleMerged = this.items.get(i);
            ScheduleCardViewHolder scheduleCardViewHolder = (ScheduleCardViewHolder) viewHolder;
            scheduleCardViewHolder.bind(this.hasCustomName, this.is24Format, deviceScheduleMerged, this.device);
            scheduleCardViewHolder.getBinding().switchSchedule.setOnCheckedChangeListener(new ScheduleCardAdapter$$ExternalSyntheticLambda0(deviceScheduleMerged, this, i));
            scheduleCardViewHolder.getBinding().rootLayout.setOnClickListener(new ScheduleCardAdapter$$ExternalSyntheticLambda1(this, deviceScheduleMerged));
        }
    }

    /* access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$3(DeviceScheduleMerged deviceScheduleMerged, ScheduleCardAdapter scheduleCardAdapter, int i, CompoundButton compoundButton, boolean z) {
        ScheduleCardAdapter scheduleCardAdapter2 = scheduleCardAdapter;
        DeviceScheduleMerged.Companion companion = DeviceScheduleMerged.Companion;
        Iterable<DeviceSchedule> schedule = deviceScheduleMerged.getSchedule();
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(schedule, 10));
        for (DeviceSchedule copy$default : schedule) {
            arrayList.add(DeviceSchedule.copy$default(copy$default, (String) null, (String) null, (String) null, (String) null, (String) null, (List) null, !z, (Set) null, (String) null, (List) null, (String) null, 1983, (Object) null));
        }
        DeviceScheduleMerged newInstance = companion.newInstance((List) arrayList);
        if (newInstance != null) {
            List mutableList = CollectionsKt.toMutableList(scheduleCardAdapter2.items);
            mutableList.set(i, newInstance);
            scheduleCardAdapter2.setItems(mutableList);
        }
        scheduleCardAdapter2.onScheduleChecked.invoke(deviceScheduleMerged, Boolean.valueOf(z));
    }

    /* access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$4(ScheduleCardAdapter scheduleCardAdapter, DeviceScheduleMerged deviceScheduleMerged, View view) {
        scheduleCardAdapter.onScheduleTapped.invoke(deviceScheduleMerged);
    }
}
