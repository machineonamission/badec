package com.blueair.viewcore.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.FilterInfo;
import com.blueair.viewcore.viewholder.DeviceFilterHolder;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\u0014\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\u0018\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0014H\u0016R\u001c\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u0004¢\u0006\u0002\n\u0000R0\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\n2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\n@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/blueair/viewcore/adapter/DeviceFilterAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/blueair/viewcore/viewholder/DeviceFilterHolder;", "onFilterSelectedListener", "Lkotlin/Function1;", "Lcom/blueair/core/model/FilterInfo;", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "value", "", "filters", "getFilters", "()Ljava/util/List;", "setFilters", "(Ljava/util/List;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "getItemCount", "onBindViewHolder", "holder", "position", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceFilterAdapter.kt */
public final class DeviceFilterAdapter extends RecyclerView.Adapter<DeviceFilterHolder> {
    private List<FilterInfo> filters = CollectionsKt.emptyList();
    private final Function1<FilterInfo, Unit> onFilterSelectedListener;

    public DeviceFilterAdapter(Function1<? super FilterInfo, Unit> function1) {
        this.onFilterSelectedListener = function1;
    }

    public final List<FilterInfo> getFilters() {
        return this.filters;
    }

    public final void setFilters(List<FilterInfo> list) {
        Intrinsics.checkNotNullParameter(list, "value");
        if (!Intrinsics.areEqual((Object) this.filters, (Object) list)) {
            this.filters = list;
            notifyDataSetChanged();
        }
    }

    public DeviceFilterHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        return DeviceFilterHolder.Companion.newInstance(viewGroup);
    }

    public int getItemCount() {
        return this.filters.size();
    }

    public void onBindViewHolder(DeviceFilterHolder deviceFilterHolder, int i) {
        Intrinsics.checkNotNullParameter(deviceFilterHolder, "holder");
        deviceFilterHolder.update(this.filters.get(i), this.onFilterSelectedListener);
    }
}
