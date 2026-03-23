package com.blueair.devicedetails.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.DayOfWeek;
import com.blueair.devicedetails.viewholder.DayViewHolder;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0010#\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B!\u0012\u0018\u0010\u0003\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0016J\u0018\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0019H\u0016R#\u0010\u0003\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\rX\u0004¢\u0006\u0002\n\u0000R0\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u000f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u000f@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001e"}, d2 = {"Lcom/blueair/devicedetails/adapter/DaysOfWeekSelectorAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/blueair/devicedetails/viewholder/DayViewHolder;", "onChanged", "Lkotlin/Function1;", "", "Lcom/blueair/core/model/DayOfWeek;", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "getOnChanged", "()Lkotlin/jvm/functions/Function1;", "daysOfWeek", "", "value", "", "selectedSet", "getSelectedSet", "()Ljava/util/Set;", "setSelectedSet", "(Ljava/util/Set;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "getItemCount", "onBindViewHolder", "holder", "position", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DaysOfWeekSelectorAdapter.kt */
public final class DaysOfWeekSelectorAdapter extends RecyclerView.Adapter<DayViewHolder> {
    private final List<DayOfWeek> daysOfWeek = CollectionsKt.sortedWith(DayOfWeek.getEntries(), new DaysOfWeekSelectorAdapter$special$$inlined$sortedBy$1());
    private final Function1<Set<? extends DayOfWeek>, Unit> onChanged;
    private Set<DayOfWeek> selectedSet = new LinkedHashSet();

    public final Function1<Set<? extends DayOfWeek>, Unit> getOnChanged() {
        return this.onChanged;
    }

    public DaysOfWeekSelectorAdapter(Function1<? super Set<? extends DayOfWeek>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "onChanged");
        this.onChanged = function1;
    }

    public final Set<DayOfWeek> getSelectedSet() {
        return this.selectedSet;
    }

    public final void setSelectedSet(Set<DayOfWeek> set) {
        Intrinsics.checkNotNullParameter(set, "value");
        this.selectedSet = set;
        notifyDataSetChanged();
    }

    public DayViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        return DayViewHolder.Companion.newInstance(viewGroup);
    }

    public int getItemCount() {
        return this.daysOfWeek.size();
    }

    public void onBindViewHolder(DayViewHolder dayViewHolder, int i) {
        Intrinsics.checkNotNullParameter(dayViewHolder, "holder");
        DayOfWeek dayOfWeek = this.daysOfWeek.get(i);
        dayViewHolder.bind(dayOfWeek, this.selectedSet.contains(dayOfWeek), new DaysOfWeekSelectorAdapter$$ExternalSyntheticLambda0(this, dayOfWeek, i));
    }

    /* access modifiers changed from: private */
    public static final Unit onBindViewHolder$lambda$1(DaysOfWeekSelectorAdapter daysOfWeekSelectorAdapter, DayOfWeek dayOfWeek, int i) {
        if (!daysOfWeekSelectorAdapter.selectedSet.contains(dayOfWeek)) {
            daysOfWeekSelectorAdapter.selectedSet.add(dayOfWeek);
        } else if (daysOfWeekSelectorAdapter.selectedSet.size() > 1) {
            daysOfWeekSelectorAdapter.selectedSet.remove(dayOfWeek);
        }
        daysOfWeekSelectorAdapter.notifyItemChanged(i);
        daysOfWeekSelectorAdapter.onChanged.invoke(daysOfWeekSelectorAdapter.selectedSet);
        return Unit.INSTANCE;
    }
}
