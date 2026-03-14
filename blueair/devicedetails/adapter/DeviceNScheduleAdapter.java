package com.blueair.devicedetails.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceScheduleMerged;
import com.blueair.devicedetails.viewholder.DeviceNScheduleViewHolder;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B3\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0018\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001bH\u0016J\b\u0010\u001f\u001a\u00020\u001bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR0\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\u00112\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\u0011@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006 "},
   d2 = {"Lcom/blueair/devicedetails/adapter/DeviceNScheduleAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/blueair/devicedetails/viewholder/DeviceNScheduleViewHolder;", "hasCustomName", "", "is24Format", "device", "Lcom/blueair/core/model/Device;", "onScheduleTapped", "Lkotlin/Function1;", "Lcom/blueair/core/model/DeviceScheduleMerged;", "", "<init>", "(ZZLcom/blueair/core/model/Device;Lkotlin/jvm/functions/Function1;)V", "getOnScheduleTapped", "()Lkotlin/jvm/functions/Function1;", "value", "", "items", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "getItemCount", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceNScheduleAdapter extends RecyclerView.Adapter {
   private final Device device;
   private final boolean hasCustomName;
   private final boolean is24Format;
   private List items;
   private final Function1 onScheduleTapped;

   // $FF: synthetic method
   public static void $r8$lambda$hawSUt8X19gtzS07L6oFAvNojLs(DeviceNScheduleAdapter var0, DeviceScheduleMerged var1, View var2) {
      onBindViewHolder$lambda$0(var0, var1, var2);
   }

   public DeviceNScheduleAdapter(boolean var1, boolean var2, Device var3, Function1 var4) {
      Intrinsics.checkNotNullParameter(var3, "device");
      Intrinsics.checkNotNullParameter(var4, "onScheduleTapped");
      super();
      this.hasCustomName = var1;
      this.is24Format = var2;
      this.device = var3;
      this.onScheduleTapped = var4;
      this.items = CollectionsKt.emptyList();
   }

   private static final void onBindViewHolder$lambda$0(DeviceNScheduleAdapter var0, DeviceScheduleMerged var1, View var2) {
      var0.onScheduleTapped.invoke(var1);
   }

   public int getItemCount() {
      return ((Collection)this.items).size();
   }

   public final List getItems() {
      return this.items;
   }

   public final Function1 getOnScheduleTapped() {
      return this.onScheduleTapped;
   }

   public void onBindViewHolder(DeviceNScheduleViewHolder var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "holder");
      DeviceScheduleMerged var3 = (DeviceScheduleMerged)this.items.get(var2);
      var1.bind(this.hasCustomName, this.is24Format, var3);
      var1.getBinding().getRoot().setOnClickListener(new DeviceNScheduleAdapter$$ExternalSyntheticLambda0(this, var3));
   }

   public DeviceNScheduleViewHolder onCreateViewHolder(ViewGroup var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "parent");
      return DeviceNScheduleViewHolder.Companion.newInstance(var1, this.device);
   }

   public final void setItems(List var1) {
      Intrinsics.checkNotNullParameter(var1, "value");
      this.items = var1;
      this.notifyDataSetChanged();
   }
}
