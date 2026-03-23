package com.blueair.viewcore.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.FilterInfo;
import com.blueair.viewcore.viewholder.FilterTypeHolder;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B9\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u0012\u001c\b\u0002\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0017J\u0018\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\tH\u0016J\b\u0010\u001c\u001a\u00020\tH\u0016J\u0018\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\tH\u0016J\b\u0010 \u001a\u0004\u0018\u00010\u0005R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R0\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006!"}, d2 = {"Lcom/blueair/viewcore/adapter/FilterTypeAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/blueair/viewcore/viewholder/FilterTypeHolder;", "onFilterInfoClickListener", "Lkotlin/Function1;", "Lcom/blueair/core/model/FilterInfo;", "", "onFilterSelectedListener", "Lkotlin/Function2;", "", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "selectedIndex", "value", "", "filters", "getFilters", "()Ljava/util/List;", "setFilters", "(Ljava/util/List;)V", "selectFilter", "index", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "getItemCount", "onBindViewHolder", "holder", "position", "getSelectedFilter", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: FilterTypeAdapter.kt */
public final class FilterTypeAdapter extends RecyclerView.Adapter<FilterTypeHolder> {
    private List<FilterInfo> filters;
    private final Function1<FilterInfo, Unit> onFilterInfoClickListener;
    private final Function2<Integer, FilterInfo, Unit> onFilterSelectedListener;
    private int selectedIndex;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FilterTypeAdapter(Function1 function1, Function2 function2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(function1, (i & 2) != 0 ? null : function2);
    }

    public FilterTypeAdapter(Function1<? super FilterInfo, Unit> function1, Function2<? super Integer, ? super FilterInfo, Unit> function2) {
        Intrinsics.checkNotNullParameter(function1, "onFilterInfoClickListener");
        this.onFilterInfoClickListener = function1;
        this.onFilterSelectedListener = function2;
        this.selectedIndex = -1;
        this.filters = CollectionsKt.emptyList();
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

    public final void selectFilter(int i, RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        int i2 = this.selectedIndex;
        if (i != i2) {
            this.selectedIndex = i;
            recyclerView.post(new FilterTypeAdapter$$ExternalSyntheticLambda0(i2, this));
        }
    }

    /* access modifiers changed from: private */
    public static final void selectFilter$lambda$0(int i, FilterTypeAdapter filterTypeAdapter) {
        if (i != -1 && i < filterTypeAdapter.getItemCount()) {
            filterTypeAdapter.notifyItemChanged(i);
        }
        if (filterTypeAdapter.selectedIndex != -1 && i < filterTypeAdapter.getItemCount()) {
            filterTypeAdapter.notifyItemChanged(filterTypeAdapter.selectedIndex);
        }
    }

    public FilterTypeHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        return FilterTypeHolder.Companion.newInstance(viewGroup);
    }

    public int getItemCount() {
        return this.filters.size();
    }

    public void onBindViewHolder(FilterTypeHolder filterTypeHolder, int i) {
        Intrinsics.checkNotNullParameter(filterTypeHolder, "holder");
        filterTypeHolder.update(this.filters.get(i), this.selectedIndex == i, i, this.onFilterInfoClickListener, this.onFilterSelectedListener);
    }

    public final FilterInfo getSelectedFilter() {
        return (FilterInfo) CollectionsKt.getOrNull(this.filters, this.selectedIndex);
    }
}
