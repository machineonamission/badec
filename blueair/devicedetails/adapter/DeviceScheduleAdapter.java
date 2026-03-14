package com.blueair.devicedetails.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceScheduleMerged;
import com.blueair.devicedetails.viewholder.DeviceScheduleEmptyViewHolder;
import com.blueair.devicedetails.viewholder.DeviceScheduleViewHolder;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 #2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001#BA\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n0\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001dH\u0016J\u0010\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001dH\u0016J\u0018\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u001dH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n0\f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R0\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\u00132\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\u0013@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006$"},
   d2 = {"Lcom/blueair/devicedetails/adapter/DeviceScheduleAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "hasCustomName", "", "is24Format", "device", "Lcom/blueair/core/model/Device;", "onAdd", "Lkotlin/Function0;", "", "onScheduleTapped", "Lkotlin/Function1;", "Lcom/blueair/core/model/DeviceScheduleMerged;", "<init>", "(ZZLcom/blueair/core/model/Device;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "getOnScheduleTapped", "()Lkotlin/jvm/functions/Function1;", "value", "", "items", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "getItemCount", "getItemViewType", "position", "onBindViewHolder", "holder", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceScheduleAdapter extends RecyclerView.Adapter {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   public static final int emptyVH = 1;
   public static final int item = 0;
   private final Device device;
   private final boolean hasCustomName;
   private final boolean is24Format;
   private List items;
   private final Function0 onAdd;
   private final Function1 onScheduleTapped;

   // $FF: synthetic method
   public static void $r8$lambda$SQabSDLoP_gD_pRCkVNnTosYJ0E(DeviceScheduleAdapter var0, DeviceScheduleMerged var1, View var2) {
      onBindViewHolder$lambda$0(var0, var1, var2);
   }

   public DeviceScheduleAdapter(boolean var1, boolean var2, Device var3, Function0 var4, Function1 var5) {
      Intrinsics.checkNotNullParameter(var3, "device");
      Intrinsics.checkNotNullParameter(var4, "onAdd");
      Intrinsics.checkNotNullParameter(var5, "onScheduleTapped");
      super();
      this.hasCustomName = var1;
      this.is24Format = var2;
      this.device = var3;
      this.onAdd = var4;
      this.onScheduleTapped = var5;
      this.items = CollectionsKt.emptyList();
   }

   private static final void onBindViewHolder$lambda$0(DeviceScheduleAdapter var0, DeviceScheduleMerged var1, View var2) {
      var0.onScheduleTapped.invoke(var1);
   }

   public int getItemCount() {
      return ((Collection)this.items).size() == 0 ? 1 : ((Collection)this.items).size();
   }

   public int getItemViewType(int var1) {
      return ((Collection)this.items).size() == 0 ? 1 : 0;
   }

   public final List getItems() {
      return this.items;
   }

   public final Function1 getOnScheduleTapped() {
      return this.onScheduleTapped;
   }

   public void onBindViewHolder(RecyclerView.ViewHolder var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "holder");
      if (var1 instanceof DeviceScheduleEmptyViewHolder) {
         ((DeviceScheduleEmptyViewHolder)var1).bind(this.onAdd);
      } else {
         if (var1 instanceof DeviceScheduleViewHolder) {
            DeviceScheduleMerged var3 = (DeviceScheduleMerged)this.items.get(var2);
            var1 = var1;
            var1.bind(this.hasCustomName, this.is24Format, var3, this.device);
            var1.getBinding().rootLayout.setOnClickListener(new DeviceScheduleAdapter$$ExternalSyntheticLambda0(this, var3));
         }

      }
   }

   public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "parent");
      if (var2 != 0) {
         if (var2 == 1) {
            return DeviceScheduleEmptyViewHolder.Companion.instance(var1);
         } else {
            throw new Exception("Device schedule adapter view not supported");
         }
      } else {
         return DeviceScheduleViewHolder.Companion.instance(var1);
      }
   }

   public final void setItems(List var1) {
      Intrinsics.checkNotNullParameter(var1, "value");
      this.items = var1;
      this.notifyDataSetChanged();
   }

   @Metadata(
      d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"},
      d2 = {"Lcom/blueair/devicedetails/adapter/DeviceScheduleAdapter$Companion;", "", "<init>", "()V", "item", "", "emptyVH", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Companion {
      private Companion() {
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker var1) {
         this();
      }
   }
}
