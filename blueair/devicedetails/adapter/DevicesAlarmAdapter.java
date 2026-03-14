package com.blueair.devicedetails.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.HasAlarm;
import com.blueair.devicedetails.viewholder.DevicesAlarmViewHolder;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BU\u0012\u001e\u0010\u0003\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0004\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\n\u0012\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\b0\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\"\u001a\u00020\u00022\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0016J\b\u0010'\u001a\u00020&H\u0016J\u0018\u0010(\u001a\u00020\b2\u0006\u0010)\u001a\u00020\u00022\u0006\u0010*\u001a\u00020&H\u0016R)\u0010\u0003\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\b0\fX\u0082\u0004¢\u0006\u0002\n\u0000R0\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u00132\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u0013@GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u001b0\u001aj\b\u0012\u0004\u0012\u00020\u001b`\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0007@GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006+"},
   d2 = {"Lcom/blueair/devicedetails/adapter/DevicesAlarmAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/blueair/devicedetails/viewholder/DevicesAlarmViewHolder;", "onAlarmChecked", "Lkotlin/Function3;", "Lcom/blueair/core/model/HasAlarm;", "Lcom/blueair/core/model/DeviceAlarm;", "", "", "onTroubleShootClickListener", "Lkotlin/Function1;", "onMoreClickListener", "Lkotlin/Function2;", "Landroid/view/View;", "<init>", "(Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "getOnAlarmChecked", "()Lkotlin/jvm/functions/Function3;", "value", "", "items", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "hideOfflineUidSet", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "forceOffline", "getForceOffline", "()Z", "setForceOffline", "(Z)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "getItemCount", "onBindViewHolder", "holder", "position", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DevicesAlarmAdapter extends RecyclerView.Adapter {
   private boolean forceOffline;
   private final HashSet hideOfflineUidSet;
   private List items;
   private final Function3 onAlarmChecked;
   private final Function2 onMoreClickListener;
   private final Function1 onTroubleShootClickListener;

   // $FF: synthetic method
   public static void $r8$lambda$gpmFFNgFrjpjOocVZiShhy_kgQU/* $FF was: $r8$lambda$gpmFFNgFrjpjOocVZiShhy-kgQU*/(DevicesAlarmAdapter var0, HasAlarm var1, View var2) {
      onBindViewHolder$lambda$0(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$hwsW9bE6QdRq2oq6pi2Ed5ZNOZQ(DevicesAlarmAdapter var0, HasAlarm var1, View var2) {
      onBindViewHolder$lambda$2(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$nsfOXBkmEs2OTPe8Mgza_RWrD7c/* $FF was: $r8$lambda$nsfOXBkmEs2OTPe8Mgza-RWrD7c*/(DevicesAlarmAdapter var0, HasAlarm var1, int var2, View var3) {
      onBindViewHolder$lambda$1(var0, var1, var2, var3);
   }

   public DevicesAlarmAdapter(Function3 var1, Function1 var2, Function2 var3) {
      Intrinsics.checkNotNullParameter(var1, "onAlarmChecked");
      Intrinsics.checkNotNullParameter(var2, "onTroubleShootClickListener");
      Intrinsics.checkNotNullParameter(var3, "onMoreClickListener");
      super();
      this.onAlarmChecked = var1;
      this.onTroubleShootClickListener = var2;
      this.onMoreClickListener = var3;
      this.items = CollectionsKt.emptyList();
      this.hideOfflineUidSet = new HashSet();
   }

   private static final void onBindViewHolder$lambda$0(DevicesAlarmAdapter var0, HasAlarm var1, View var2) {
      Function2 var3 = var0.onMoreClickListener;
      Intrinsics.checkNotNull(var2);
      var3.invoke(var1, var2);
   }

   private static final void onBindViewHolder$lambda$1(DevicesAlarmAdapter var0, HasAlarm var1, int var2, View var3) {
      var0.hideOfflineUidSet.add(var1.getUid());
      var0.notifyItemChanged(var2);
   }

   private static final void onBindViewHolder$lambda$2(DevicesAlarmAdapter var0, HasAlarm var1, View var2) {
      var0.onTroubleShootClickListener.invoke(var1);
   }

   public final boolean getForceOffline() {
      return this.forceOffline;
   }

   public int getItemCount() {
      return ((Collection)this.items).size();
   }

   public final List getItems() {
      return this.items;
   }

   public final Function3 getOnAlarmChecked() {
      return this.onAlarmChecked;
   }

   public void onBindViewHolder(DevicesAlarmViewHolder var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "holder");
      HasAlarm var3 = (HasAlarm)this.items.get(var2);
      var1.bind(var3, this.forceOffline, this.hideOfflineUidSet.contains(var3.getUid()));
      var1.getIconMore().setOnClickListener(new DevicesAlarmAdapter$$ExternalSyntheticLambda0(this, var3));
      var1.getCloseBtn().setOnClickListener(new DevicesAlarmAdapter$$ExternalSyntheticLambda1(this, var3, var2));
      var1.getTroubleshootingBtn().setOnClickListener(new DevicesAlarmAdapter$$ExternalSyntheticLambda2(this, var3));
   }

   public DevicesAlarmViewHolder onCreateViewHolder(ViewGroup var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "parent");
      return DevicesAlarmViewHolder.Companion.instance(var1, this.onAlarmChecked);
   }

   public final void setForceOffline(boolean var1) {
      if (var1 != this.forceOffline) {
         this.forceOffline = var1;
         this.notifyDataSetChanged();
      }

   }

   public final void setItems(List var1) {
      Intrinsics.checkNotNullParameter(var1, "value");
      this.items = var1;
      this.notifyDataSetChanged();
   }
}
