package com.blueair.android.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.android.viewholder.DeviceViewHolder;
import com.blueair.core.model.ConnectivityStatus;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.HasAlarm;
import com.blueair.core.model.HasTimer;
import com.blueair.core.model.HasWick;
import com.blueair.core.model.IndoorDatapoint;
import com.blueair.core.model.TimerState;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B1\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bJ\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0018\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0018H\u0016J\u0018\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0018H\u0016J\u0010\u0010 \u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u0018H\u0016J\u0006\u0010!\u001a\u00020\rR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000RL\u0010\u0012\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00100\u000f2\u001a\u0010\u000e\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00100\u000f@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\""},
   d2 = {"Lcom/blueair/android/adapter/DeviceListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/blueair/android/viewholder/DeviceViewHolder;", "deviceSelectedPublisher", "Lio/reactivex/subjects/PublishSubject;", "Lcom/blueair/core/model/Device;", "standByModePublisher", "offlineClickPublisher", "<init>", "(Lio/reactivex/subjects/PublishSubject;Lio/reactivex/subjects/PublishSubject;Lio/reactivex/subjects/PublishSubject;)V", "forceOffline", "", "setForceOffline", "", "newList", "", "Lkotlin/Pair;", "Lcom/blueair/core/model/IndoorDatapoint;", "currentList", "getCurrentList", "()Ljava/util/List;", "setCurrentList", "(Ljava/util/List;)V", "getItemCount", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "getItemViewType", "notifyCountdownAndTimerChanged", "app_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceListAdapter extends RecyclerView.Adapter {
   public static final int $stable = 8;
   private List currentList;
   private final PublishSubject deviceSelectedPublisher;
   private boolean forceOffline;
   private final PublishSubject offlineClickPublisher;
   private final PublishSubject standByModePublisher;

   // $FF: synthetic method
   public static void $r8$lambda$1YsLK8wZhVzQ9T7Ict6hU2DWIz8(DeviceListAdapter var0, Device var1, View var2) {
      onBindViewHolder$lambda$5(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$2Wl_wXa7GvZqudkH8i94RtFn5ys(Device var0, DeviceListAdapter var1, View var2) {
      onBindViewHolder$lambda$4(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$KZT3hC3v2EuNhKxMfRf_DivemAQ/* $FF was: $r8$lambda$KZT3hC3v2EuNhKxMfRf-DivemAQ*/(DeviceListAdapter var0, Device var1, View var2) {
      onBindViewHolder$lambda$3(var0, var1, var2);
   }

   public DeviceListAdapter(PublishSubject var1, PublishSubject var2, PublishSubject var3) {
      Intrinsics.checkNotNullParameter(var1, "deviceSelectedPublisher");
      Intrinsics.checkNotNullParameter(var2, "standByModePublisher");
      Intrinsics.checkNotNullParameter(var3, "offlineClickPublisher");
      super();
      this.deviceSelectedPublisher = var1;
      this.standByModePublisher = var2;
      this.offlineClickPublisher = var3;
      this.currentList = CollectionsKt.emptyList();
   }

   private static final void onBindViewHolder$lambda$3(DeviceListAdapter var0, Device var1, View var2) {
      var0.deviceSelectedPublisher.onNext(var1);
   }

   private static final void onBindViewHolder$lambda$4(Device var0, DeviceListAdapter var1, View var2) {
      onBindViewHolder$onStandbyClicked(var0, var1);
   }

   private static final void onBindViewHolder$lambda$5(DeviceListAdapter var0, Device var1, View var2) {
      var0.offlineClickPublisher.onNext(var1);
   }

   private static final void onBindViewHolder$onStandbyClicked(Device var0, DeviceListAdapter var1) {
      if (var0.getConnectivityStatus() == ConnectivityStatus.ONLINE) {
         Timber.Forest.d("onStandbyClicked", new Object[0]);
         var1.standByModePublisher.onNext(var0);
      }

   }

   public final List getCurrentList() {
      return this.currentList;
   }

   public int getItemCount() {
      return this.currentList.size();
   }

   public int getItemViewType(int var1) {
      return ((Device)((Pair)this.currentList.get(var1)).getFirst()).getUid().hashCode();
   }

   public final void notifyCountdownAndTimerChanged() {
      Iterator var2 = ((Iterable)this.currentList).iterator();

      for(int var1 = 0; var2.hasNext(); ++var1) {
         Object var3 = var2.next();
         if (var1 < 0) {
            CollectionsKt.throwIndexOverflow();
         }

         Device var4 = (Device)((Pair)var3).component1();
         if ((!(var4 instanceof HasWick) || !((HasWick)var4).getWickdryOn()) && !DeviceKt.isDisinfectionOn(var4)) {
            if (var4 instanceof HasTimer && SetsKt.setOf(new TimerState[]{TimerState.START, TimerState.RESUME}).contains(((HasTimer)var4).timerStatus())) {
               this.notifyItemChanged(var1);
            } else if (var4 instanceof HasAlarm && !((Collection)CollectionsKt.filterNotNull((Iterable)((HasAlarm)var4).getAlarms())).isEmpty()) {
               this.notifyItemChanged(var1);
            }
         } else {
            this.notifyItemChanged(var1);
         }
      }

   }

   public void onBindViewHolder(DeviceViewHolder var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "holder");
      Device var5 = (Device)((Pair)this.currentList.get(var2)).getFirst();
      IndoorDatapoint var3 = (IndoorDatapoint)((Pair)this.currentList.get(var2)).getSecond();
      Timber.Forest var4 = Timber.Forest;
      StringBuilder var6 = new StringBuilder("Binding adapter at position ");
      var6.append(var2);
      var6.append(" with device ");
      var6.append(var5);
      var4.v(var6.toString(), new Object[0]);
      var1.update(var5, var3, this.forceOffline);
      var1.getClickView().setOnClickListener(new DeviceListAdapter$$ExternalSyntheticLambda0(this, var5));
      var1.getStandByModeClickView().setOnClickListener(new DeviceListAdapter$$ExternalSyntheticLambda1(var5, this));
      var1.getOfflineInfoView().setOnClickListener(new DeviceListAdapter$$ExternalSyntheticLambda2(this, var5));
   }

   public DeviceViewHolder onCreateViewHolder(ViewGroup var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "parent");
      return DeviceViewHolder.Companion.newInstance(var1);
   }

   public final void setCurrentList(List var1) {
      Intrinsics.checkNotNullParameter(var1, "newList");
      List var4 = this.currentList;
      Iterable var5 = (Iterable)var1;
      Collection var3 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var5, 10)));
      Iterator var10 = var5.iterator();

      while(var10.hasNext()) {
         var3.add((Device)((Pair)var10.next()).getFirst());
      }

      List var7 = (List)var3;
      Iterable var8 = (Iterable)var4;
      Collection var11 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var8, 10)));
      Iterator var6 = var8.iterator();

      while(var6.hasNext()) {
         var11.add((Device)((Pair)var6.next()).getFirst());
      }

      if (!DeviceListAdapterKt.access$doListsContainSameDevices(var7, (List)var11)) {
         this.currentList = var1;
         this.notifyDataSetChanged();
      } else {
         Iterator var9 = var8.iterator();

         for(int var2 = 0; var9.hasNext(); ++var2) {
            Object var12 = var9.next();
            if (var2 < 0) {
               CollectionsKt.throwIndexOverflow();
            }

            Pair var13 = (Pair)var12;
            if (DeviceListAdapterKt.access$hasDeviceChanged((Device)var13.getFirst(), var7) || DeviceKt.isG4orB4orNB((Device)var13.getFirst()) && !Intrinsics.areEqual(var13.getSecond(), ((Pair)var1.get(var2)).getSecond())) {
               this.currentList = var1;
               this.notifyItemRangeChanged(0, var1.size());
               break;
            }
         }

      }
   }

   public final void setForceOffline(boolean var1) {
      this.forceOffline = var1;
      this.notifyDataSetChanged();
   }
}
