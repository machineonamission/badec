package com.blueair.viewcore.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.FilterInfo;
import com.blueair.viewcore.viewholder.FilterTypeHolder;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B9\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u0012\u001c\b\u0002\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0017J\u0018\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\tH\u0016J\b\u0010\u001c\u001a\u00020\tH\u0016J\u0018\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\tH\u0016J\b\u0010 \u001a\u0004\u0018\u00010\u0005R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R0\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006!"},
   d2 = {"Lcom/blueair/viewcore/adapter/FilterTypeAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/blueair/viewcore/viewholder/FilterTypeHolder;", "onFilterInfoClickListener", "Lkotlin/Function1;", "Lcom/blueair/core/model/FilterInfo;", "", "onFilterSelectedListener", "Lkotlin/Function2;", "", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "selectedIndex", "value", "", "filters", "getFilters", "()Ljava/util/List;", "setFilters", "(Ljava/util/List;)V", "selectFilter", "index", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "getItemCount", "onBindViewHolder", "holder", "position", "getSelectedFilter", "viewcore_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class FilterTypeAdapter extends RecyclerView.Adapter {
   private List filters;
   private final Function1 onFilterInfoClickListener;
   private final Function2 onFilterSelectedListener;
   private int selectedIndex;

   // $FF: synthetic method
   public static void $r8$lambda$kvYAjcaHxg35UK_hW1Ru3w0pwcM(int var0, FilterTypeAdapter var1) {
      selectFilter$lambda$0(var0, var1);
   }

   public FilterTypeAdapter(Function1 var1, Function2 var2) {
      Intrinsics.checkNotNullParameter(var1, "onFilterInfoClickListener");
      super();
      this.onFilterInfoClickListener = var1;
      this.onFilterSelectedListener = var2;
      this.selectedIndex = -1;
      this.filters = CollectionsKt.emptyList();
   }

   // $FF: synthetic method
   public FilterTypeAdapter(Function1 var1, Function2 var2, int var3, DefaultConstructorMarker var4) {
      if ((var3 & 2) != 0) {
         var2 = null;
      }

      this(var1, var2);
   }

   private static final void selectFilter$lambda$0(int var0, FilterTypeAdapter var1) {
      if (var0 != -1 && var0 < var1.getItemCount()) {
         var1.notifyItemChanged(var0);
      }

      if (var1.selectedIndex != -1 && var0 < var1.getItemCount()) {
         var1.notifyItemChanged(var1.selectedIndex);
      }

   }

   public final List getFilters() {
      return this.filters;
   }

   public int getItemCount() {
      return this.filters.size();
   }

   public final FilterInfo getSelectedFilter() {
      return (FilterInfo)CollectionsKt.getOrNull(this.filters, this.selectedIndex);
   }

   public void onBindViewHolder(FilterTypeHolder var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "holder");
      FilterInfo var4 = (FilterInfo)this.filters.get(var2);
      boolean var3;
      if (this.selectedIndex == var2) {
         var3 = true;
      } else {
         var3 = false;
      }

      var1.update(var4, var3, var2, this.onFilterInfoClickListener, this.onFilterSelectedListener);
   }

   public FilterTypeHolder onCreateViewHolder(ViewGroup var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "parent");
      return FilterTypeHolder.Companion.newInstance(var1);
   }

   public final void selectFilter(int var1, RecyclerView var2) {
      Intrinsics.checkNotNullParameter(var2, "recyclerView");
      int var3 = this.selectedIndex;
      if (var1 != var3) {
         this.selectedIndex = var1;
         var2.post(new FilterTypeAdapter$$ExternalSyntheticLambda0(var3, this));
      }

   }

   public final void setFilters(List var1) {
      Intrinsics.checkNotNullParameter(var1, "value");
      if (!Intrinsics.areEqual(this.filters, var1)) {
         this.filters = var1;
         this.notifyDataSetChanged();
      }
   }
}
