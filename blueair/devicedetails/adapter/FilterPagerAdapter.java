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

@Metadata(
   d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0016H\u0016R0\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR(\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0019"},
   d2 = {"Lcom/blueair/devicedetails/adapter/FilterPagerAdapter;", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "fragment", "Landroidx/fragment/app/Fragment;", "<init>", "(Landroidx/fragment/app/Fragment;)V", "nuFilters", "", "Lcom/blueair/core/model/Filter;", "filters", "getFilters", "()Ljava/util/List;", "setFilters", "(Ljava/util/List;)V", "value", "Lcom/blueair/core/model/HasFanSpeed;", "device", "getDevice", "()Lcom/blueair/core/model/HasFanSpeed;", "setDevice", "(Lcom/blueair/core/model/HasFanSpeed;)V", "getItemCount", "", "createFragment", "position", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class FilterPagerAdapter extends FragmentStateAdapter {
   private HasFanSpeed device;
   private List filters;

   public FilterPagerAdapter(Fragment var1) {
      Intrinsics.checkNotNullParameter(var1, "fragment");
      super(var1);
      this.filters = CollectionsKt.emptyList();
   }

   public Fragment createFragment(int var1) {
      return FilterFragment.Companion.newInstance(this.device, (Filter)this.filters.get(var1));
   }

   public final HasFanSpeed getDevice() {
      return this.device;
   }

   public final List getFilters() {
      return this.filters;
   }

   public int getItemCount() {
      return this.filters.size();
   }

   public final void setDevice(HasFanSpeed var1) {
      this.device = var1;
      this.notifyDataSetChanged();
   }

   public final void setFilters(List var1) {
      Intrinsics.checkNotNullParameter(var1, "nuFilters");
      if (!Intrinsics.areEqual(var1, this.filters)) {
         Iterator var5 = var1.iterator();
         int var3 = 0;

         int var2;
         label48: {
            for(var2 = 0; var5.hasNext(); ++var2) {
               Filter var6 = (Filter)var5.next();
               HasFanSpeed var4 = this.device;
               Filter var9;
               if (var4 != null) {
                  var9 = var4.getFilter();
               } else {
                  var9 = null;
               }

               if (Intrinsics.areEqual(var6, var9)) {
                  break label48;
               }
            }

            var2 = -1;
         }

         List var10 = var1;
         if (var2 >= 0) {
            Collection var11 = (Collection)CollectionsKt.listOf(var1.get(var2));
            Iterable var12 = (Iterable)var1;
            Collection var8 = (Collection)(new ArrayList());

            for(Object var14 : var12) {
               if (var3 < 0) {
                  CollectionsKt.throwIndexOverflow();
               }

               Filter var7 = (Filter)var14;
               if (var3 != var2) {
                  var8.add(var14);
               }

               ++var3;
            }

            var10 = CollectionsKt.plus(var11, (Iterable)((List)var8));
         }

         this.filters = var10;
         this.notifyDataSetChanged();
      }

   }
}
