package com.blueair.devicedetails.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.devicedetails.viewholder.DeviceTimezoneHolder;
import java.util.List;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010#\u001a\u00020\u0006H\u0016J\u0018\u0010$\u001a\u00020\u00022\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0006H\u0016J\u0018\u0010(\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020\u00022\u0006\u0010*\u001a\u00020\u0006H\u0016R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R0\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u00122\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\f0\u0012@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017RL\u0010\u0018\u001a4\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006+"},
   d2 = {"Lcom/blueair/devicedetails/adapter/DeviceTimezoneAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/blueair/devicedetails/viewholder/DeviceTimezoneHolder;", "<init>", "()V", "value", "", "selectedIndex", "getSelectedIndex", "()I", "setSelectedIndex", "(I)V", "Ljava/util/TimeZone;", "selectedTimezone", "getSelectedTimezone", "()Ljava/util/TimeZone;", "setSelectedTimezone", "(Ljava/util/TimeZone;)V", "", "timezoneList", "getTimezoneList", "()Ljava/util/List;", "setTimezoneList", "(Ljava/util/List;)V", "selectedTimezoneListener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "index", "timezone", "", "getSelectedTimezoneListener", "()Lkotlin/jvm/functions/Function2;", "setSelectedTimezoneListener", "(Lkotlin/jvm/functions/Function2;)V", "getItemCount", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceTimezoneAdapter extends RecyclerView.Adapter {
   private int selectedIndex = -1;
   private TimeZone selectedTimezone;
   private Function2 selectedTimezoneListener;
   private List timezoneList;

   // $FF: synthetic method
   public static void $r8$lambda$qZpRHWg712nEPQzU4vaMUsKUGBE(DeviceTimezoneAdapter var0, TimeZone var1, View var2) {
      onBindViewHolder$lambda$0(var0, var1, var2);
   }

   public DeviceTimezoneAdapter() {
      TimeZone var1 = TimeZone.getDefault();
      Intrinsics.checkNotNullExpressionValue(var1, "getDefault(...)");
      this.selectedTimezone = var1;
      this.timezoneList = CollectionsKt.emptyList();
   }

   private static final void onBindViewHolder$lambda$0(DeviceTimezoneAdapter var0, TimeZone var1, View var2) {
      var0.setSelectedTimezone(var1);
   }

   private final void setSelectedIndex(int var1) {
      int var2 = this.selectedIndex;
      if (var2 != var1) {
         this.notifyItemChanged(var2);
         this.notifyItemChanged(var1);
         this.selectedIndex = var1;
      }
   }

   public int getItemCount() {
      return this.timezoneList.size();
   }

   public final int getSelectedIndex() {
      return this.selectedIndex;
   }

   public final TimeZone getSelectedTimezone() {
      return this.selectedTimezone;
   }

   public final Function2 getSelectedTimezoneListener() {
      return this.selectedTimezoneListener;
   }

   public final List getTimezoneList() {
      return this.timezoneList;
   }

   public void onBindViewHolder(DeviceTimezoneHolder var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "holder");
      TimeZone var4 = (TimeZone)this.timezoneList.get(var2);
      boolean var3;
      if (var2 == this.selectedIndex) {
         var3 = true;
      } else {
         var3 = false;
      }

      var1.bind(var4, var3);
      var1.itemView.setOnClickListener(new DeviceTimezoneAdapter$$ExternalSyntheticLambda0(this, var4));
   }

   public DeviceTimezoneHolder onCreateViewHolder(ViewGroup var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "parent");
      return DeviceTimezoneHolder.Companion.newInstance(var1);
   }

   public final void setSelectedTimezone(TimeZone var1) {
      Intrinsics.checkNotNullParameter(var1, "value");
      if (!Intrinsics.areEqual(this.selectedTimezone, var1)) {
         this.selectedTimezone = var1;
         this.setSelectedIndex(this.timezoneList.indexOf(var1));
         Function2 var2 = this.selectedTimezoneListener;
         if (var2 != null) {
            var2.invoke(this.selectedIndex, var1);
         }
      }

   }

   public final void setSelectedTimezoneListener(Function2 var1) {
      this.selectedTimezoneListener = var1;
   }

   public final void setTimezoneList(List var1) {
      Intrinsics.checkNotNullParameter(var1, "value");
      if (!Intrinsics.areEqual(this.timezoneList, var1)) {
         this.timezoneList = var1;
         this.setSelectedIndex(var1.indexOf(this.selectedTimezone));
         this.notifyDataSetChanged();
      }
   }
}
