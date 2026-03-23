package com.blueair.devicedetails.adapter;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.blueair.core.model.Filter;
import com.blueair.core.model.HasFanSpeed;
import com.blueair.devicedetails.fragment.FilterFragment;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0016H\u0016R0\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR(\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0019"}, d2 = {"Lcom/blueair/devicedetails/adapter/FilterPagerAdapter;", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "fragment", "Landroidx/fragment/app/Fragment;", "<init>", "(Landroidx/fragment/app/Fragment;)V", "nuFilters", "", "Lcom/blueair/core/model/Filter;", "filters", "getFilters", "()Ljava/util/List;", "setFilters", "(Ljava/util/List;)V", "value", "Lcom/blueair/core/model/HasFanSpeed;", "device", "getDevice", "()Lcom/blueair/core/model/HasFanSpeed;", "setDevice", "(Lcom/blueair/core/model/HasFanSpeed;)V", "getItemCount", "", "createFragment", "position", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: FilterPagerAdapter.kt */
public final class FilterPagerAdapter extends FragmentStateAdapter {
    private HasFanSpeed device;
    private List<? extends Filter> filters = CollectionsKt.emptyList();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FilterPagerAdapter(Fragment fragment) {
        super(fragment);
        Intrinsics.checkNotNullParameter(fragment, "fragment");
    }

    public final List<Filter> getFilters() {
        return this.filters;
    }

    public final void setFilters(List<? extends Filter> list) {
        Intrinsics.checkNotNullParameter(list, "nuFilters");
        if (!Intrinsics.areEqual((Object) list, (Object) this.filters)) {
            Iterator<? extends Filter> it = list.iterator();
            int i = 0;
            int i2 = 0;
            while (true) {
                if (!it.hasNext()) {
                    i2 = -1;
                    break;
                }
                Filter filter = (Filter) it.next();
                HasFanSpeed hasFanSpeed = this.device;
                if (Intrinsics.areEqual((Object) filter, (Object) hasFanSpeed != null ? hasFanSpeed.getFilter() : null)) {
                    break;
                }
                i2++;
            }
            if (i2 >= 0) {
                Collection listOf = CollectionsKt.listOf(list.get(i2));
                Collection arrayList = new ArrayList();
                for (Object next : list) {
                    int i3 = i + 1;
                    if (i < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    Filter filter2 = (Filter) next;
                    if (i != i2) {
                        arrayList.add(next);
                    }
                    i = i3;
                }
                list = CollectionsKt.plus(listOf, (List) arrayList);
            }
            this.filters = list;
            notifyDataSetChanged();
        }
    }

    public final HasFanSpeed getDevice() {
        return this.device;
    }

    public final void setDevice(HasFanSpeed hasFanSpeed) {
        this.device = hasFanSpeed;
        notifyDataSetChanged();
    }

    public int getItemCount() {
        return this.filters.size();
    }

    public Fragment createFragment(int i) {
        return FilterFragment.Companion.newInstance(this.device, (Filter) this.filters.get(i));
    }
}
