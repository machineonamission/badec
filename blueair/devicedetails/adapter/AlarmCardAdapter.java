package com.blueair.devicedetails.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.DeviceAlarm;
import com.blueair.devicedetails.viewholder.AlarmCardViewHolder;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BA\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0018\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0006\u0012\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\u001e\u0010\u0015\u001a\u00020\t2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u00132\u0006\u0010\u0014\u001a\u00020\bH\u0007J\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0004H\u0016J\b\u0010\u001b\u001a\u00020\u0004H\u0016J\u0018\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u0004H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR#\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\t\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"},
   d2 = {"Lcom/blueair/devicedetails/adapter/AlarmCardAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/blueair/devicedetails/viewholder/AlarmCardViewHolder;", "alarmNameColor", "", "onAlarmChecked", "Lkotlin/Function2;", "Lcom/blueair/core/model/DeviceAlarm;", "", "", "onAlarmTapped", "Lkotlin/Function1;", "<init>", "(ILkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;)V", "getAlarmNameColor", "()I", "getOnAlarmChecked", "()Lkotlin/jvm/functions/Function2;", "items", "", "offline", "setData", "newData", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "getItemCount", "onBindViewHolder", "holder", "position", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class AlarmCardAdapter extends RecyclerView.Adapter {
   private final int alarmNameColor;
   private List items;
   private boolean offline;
   private final Function2 onAlarmChecked;
   private final Function1 onAlarmTapped;

   public AlarmCardAdapter(int var1, Function2 var2, Function1 var3) {
      Intrinsics.checkNotNullParameter(var2, "onAlarmChecked");
      super();
      this.alarmNameColor = var1;
      this.onAlarmChecked = var2;
      this.onAlarmTapped = var3;
      this.items = CollectionsKt.emptyList();
   }

   // $FF: synthetic method
   public AlarmCardAdapter(int var1, Function2 var2, Function1 var3, int var4, DefaultConstructorMarker var5) {
      if ((var4 & 4) != 0) {
         var3 = null;
      }

      this(var1, var2, var3);
   }

   public final int getAlarmNameColor() {
      return this.alarmNameColor;
   }

   public int getItemCount() {
      return this.items.size();
   }

   public final Function2 getOnAlarmChecked() {
      return this.onAlarmChecked;
   }

   public void onBindViewHolder(AlarmCardViewHolder var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "holder");
      var1.bind((DeviceAlarm)this.items.get(var2), this.offline);
   }

   public AlarmCardViewHolder onCreateViewHolder(ViewGroup var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "parent");
      return AlarmCardViewHolder.Companion.instance(var1, this.onAlarmChecked, this.onAlarmTapped, this.alarmNameColor);
   }

   public final void setData(List var1, boolean var2) {
      Intrinsics.checkNotNullParameter(var1, "newData");
      this.items = var1;
      this.offline = var2;
      this.notifyDataSetChanged();
   }
}
