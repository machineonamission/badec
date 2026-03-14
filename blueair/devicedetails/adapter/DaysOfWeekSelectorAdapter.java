package com.blueair.devicedetails.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.DayOfWeek;
import com.blueair.devicedetails.viewholder.DayViewHolder;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0010#\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B!\u0012\u0018\u0010\u0003\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0016J\u0018\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0019H\u0016R#\u0010\u0003\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\rX\u0082\u0004¢\u0006\u0002\n\u0000R0\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u000f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u000f@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001e"},
   d2 = {"Lcom/blueair/devicedetails/adapter/DaysOfWeekSelectorAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/blueair/devicedetails/viewholder/DayViewHolder;", "onChanged", "Lkotlin/Function1;", "", "Lcom/blueair/core/model/DayOfWeek;", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "getOnChanged", "()Lkotlin/jvm/functions/Function1;", "daysOfWeek", "", "value", "", "selectedSet", "getSelectedSet", "()Ljava/util/Set;", "setSelectedSet", "(Ljava/util/Set;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "getItemCount", "onBindViewHolder", "holder", "position", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DaysOfWeekSelectorAdapter extends RecyclerView.Adapter {
   private final List daysOfWeek;
   private final Function1 onChanged;
   private Set selectedSet;

   // $FF: synthetic method
   public static Unit $r8$lambda$_gfRLOsehxhs_OxmSvl4c4jMcRE(DaysOfWeekSelectorAdapter var0, DayOfWeek var1, int var2) {
      return onBindViewHolder$lambda$1(var0, var1, var2);
   }

   public DaysOfWeekSelectorAdapter(Function1 var1) {
      Intrinsics.checkNotNullParameter(var1, "onChanged");
      super();
      this.onChanged = var1;
      this.daysOfWeek = CollectionsKt.sortedWith((Iterable)DayOfWeek.getEntries(), new Comparator() {
         public final int compare(Object var1, Object var2) {
            return ComparisonsKt.compareValues((Comparable)((DayOfWeek)var1).getWeekDayCompareValue(), (Comparable)((DayOfWeek)var2).getWeekDayCompareValue());
         }
      });
      this.selectedSet = (Set)(new LinkedHashSet());
   }

   private static final Unit onBindViewHolder$lambda$1(DaysOfWeekSelectorAdapter var0, DayOfWeek var1, int var2) {
      if (var0.selectedSet.contains(var1)) {
         if (((Collection)var0.selectedSet).size() > 1) {
            var0.selectedSet.remove(var1);
         }
      } else {
         var0.selectedSet.add(var1);
      }

      var0.notifyItemChanged(var2);
      var0.onChanged.invoke(var0.selectedSet);
      return Unit.INSTANCE;
   }

   public int getItemCount() {
      return ((Collection)this.daysOfWeek).size();
   }

   public final Function1 getOnChanged() {
      return this.onChanged;
   }

   public final Set getSelectedSet() {
      return this.selectedSet;
   }

   public void onBindViewHolder(DayViewHolder var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "holder");
      DayOfWeek var3 = (DayOfWeek)this.daysOfWeek.get(var2);
      var1.bind(var3, this.selectedSet.contains(var3), new DaysOfWeekSelectorAdapter$$ExternalSyntheticLambda0(this, var3, var2));
   }

   public DayViewHolder onCreateViewHolder(ViewGroup var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "parent");
      return DayViewHolder.Companion.newInstance(var1);
   }

   public final void setSelectedSet(Set var1) {
      Intrinsics.checkNotNullParameter(var1, "value");
      this.selectedSet = var1;
      this.notifyDataSetChanged();
   }
}
