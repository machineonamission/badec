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
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 '2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001'B[\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n0\f\u0012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n0\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020!H\u0016J\u0010\u0010#\u001a\u00020!2\u0006\u0010$\u001a\u00020!H\u0016J\u0018\u0010%\u001a\u00020\n2\u0006\u0010&\u001a\u00020\u00022\u0006\u0010$\u001a\u00020!H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n0\f¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n0\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R0\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\r0\u00172\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\r0\u0017@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006("},
   d2 = {"Lcom/blueair/devicedetails/adapter/ScheduleCardAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "hasCustomName", "", "is24Format", "device", "Lcom/blueair/core/model/Device;", "onCreate", "Lkotlin/Function0;", "", "onScheduleChecked", "Lkotlin/Function2;", "Lcom/blueair/core/model/DeviceScheduleMerged;", "onScheduleTapped", "Lkotlin/Function1;", "<init>", "(ZZLcom/blueair/core/model/Device;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;)V", "getOnScheduleChecked", "()Lkotlin/jvm/functions/Function2;", "getOnScheduleTapped", "()Lkotlin/jvm/functions/Function1;", "value", "", "items", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "getItemCount", "getItemViewType", "position", "onBindViewHolder", "holder", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class ScheduleCardAdapter extends RecyclerView.Adapter {
   public static final int CARD_ITEM = 0;
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   public static final int EMPTY_VIEW = 1;
   private final Device device;
   private final boolean hasCustomName;
   private final boolean is24Format;
   private List items;
   private final Function0 onCreate;
   private final Function2 onScheduleChecked;
   private final Function1 onScheduleTapped;

   // $FF: synthetic method
   public static void $r8$lambda$Dr4wfwtJscxn6QVStjBeQFB80vY(ScheduleCardAdapter var0, DeviceScheduleMerged var1, View var2) {
      onBindViewHolder$lambda$4(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$zXHJbRzyE_xgJQt0z_75ubtKajA/* $FF was: $r8$lambda$zXHJbRzyE-xgJQt0z_75ubtKajA*/(DeviceScheduleMerged var0, ScheduleCardAdapter var1, int var2, CompoundButton var3, boolean var4) {
      onBindViewHolder$lambda$3(var0, var1, var2, var3, var4);
   }

   public ScheduleCardAdapter(boolean var1, boolean var2, Device var3, Function0 var4, Function2 var5, Function1 var6) {
      Intrinsics.checkNotNullParameter(var3, "device");
      Intrinsics.checkNotNullParameter(var4, "onCreate");
      Intrinsics.checkNotNullParameter(var5, "onScheduleChecked");
      Intrinsics.checkNotNullParameter(var6, "onScheduleTapped");
      super();
      this.hasCustomName = var1;
      this.is24Format = var2;
      this.device = var3;
      this.onCreate = var4;
      this.onScheduleChecked = var5;
      this.onScheduleTapped = var6;
      this.items = CollectionsKt.emptyList();
   }

   private static final void onBindViewHolder$lambda$3(DeviceScheduleMerged var0, ScheduleCardAdapter var1, int var2, CompoundButton var3, boolean var4) {
      DeviceScheduleMerged.Companion var7 = DeviceScheduleMerged.Companion;
      Iterable var6 = (Iterable)var0.getSchedule();
      Collection var5 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var6, 10)));
      Iterator var10 = var6.iterator();

      while(var10.hasNext()) {
         var5.add(DeviceSchedule.copy$default((DeviceSchedule)var10.next(), (String)null, (String)null, (String)null, (String)null, (String)null, (List)null, var4 ^ true, (Set)null, (String)null, (List)null, (String)null, 1983, (Object)null));
      }

      DeviceScheduleMerged var8 = var7.newInstance((List)var5);
      if (var8 != null) {
         List var9 = CollectionsKt.toMutableList((Collection)var1.items);
         var9.set(var2, var8);
         var1.setItems(var9);
      }

      var1.onScheduleChecked.invoke(var0, var4);
   }

   private static final void onBindViewHolder$lambda$4(ScheduleCardAdapter var0, DeviceScheduleMerged var1, View var2) {
      var0.onScheduleTapped.invoke(var1);
   }

   public int getItemCount() {
      return this.items.isEmpty() ? 1 : ((Collection)this.items).size();
   }

   public int getItemViewType(int var1) {
      return this.items.isEmpty();
   }

   public final List getItems() {
      return this.items;
   }

   public final Function2 getOnScheduleChecked() {
      return this.onScheduleChecked;
   }

   public final Function1 getOnScheduleTapped() {
      return this.onScheduleTapped;
   }

   public void onBindViewHolder(RecyclerView.ViewHolder var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "holder");
      if (var1 instanceof ScheduleCardEmptyViewHolder) {
         ((ScheduleCardEmptyViewHolder)var1).bind(this.onCreate);
      } else {
         if (var1 instanceof ScheduleCardViewHolder) {
            DeviceScheduleMerged var3 = (DeviceScheduleMerged)this.items.get(var2);
            var1 = var1;
            var1.bind(this.hasCustomName, this.is24Format, var3, this.device);
            var1.getBinding().switchSchedule.setOnCheckedChangeListener(new ScheduleCardAdapter$$ExternalSyntheticLambda0(var3, this, var2));
            var1.getBinding().rootLayout.setOnClickListener(new ScheduleCardAdapter$$ExternalSyntheticLambda1(this, var3));
         }

      }
   }

   public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "parent");
      if (var2 != 0) {
         if (var2 == 1) {
            return ScheduleCardEmptyViewHolder.Companion.instance(var1);
         } else {
            throw new Exception("Device schedule adapter view not supported");
         }
      } else {
         return ScheduleCardViewHolder.Companion.instance(var1);
      }
   }

   public final void setItems(List var1) {
      Intrinsics.checkNotNullParameter(var1, "value");
      this.items = var1;
      this.notifyDataSetChanged();
   }

   @Metadata(
      d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"},
      d2 = {"Lcom/blueair/devicedetails/adapter/ScheduleCardAdapter$Companion;", "", "<init>", "()V", "CARD_ITEM", "", "EMPTY_VIEW", "devicedetails_otherRelease"},
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
