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
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B1\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bJ\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0018\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0018H\u0016J\u0018\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0018H\u0016J\u0010\u0010 \u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u0018H\u0016J\u0006\u0010!\u001a\u00020\rR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000RL\u0010\u0012\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00100\u000f2\u001a\u0010\u000e\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00100\u000f@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\""}, d2 = {"Lcom/blueair/android/adapter/DeviceListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/blueair/android/viewholder/DeviceViewHolder;", "deviceSelectedPublisher", "Lio/reactivex/subjects/PublishSubject;", "Lcom/blueair/core/model/Device;", "standByModePublisher", "offlineClickPublisher", "<init>", "(Lio/reactivex/subjects/PublishSubject;Lio/reactivex/subjects/PublishSubject;Lio/reactivex/subjects/PublishSubject;)V", "forceOffline", "", "setForceOffline", "", "newList", "", "Lkotlin/Pair;", "Lcom/blueair/core/model/IndoorDatapoint;", "currentList", "getCurrentList", "()Ljava/util/List;", "setCurrentList", "(Ljava/util/List;)V", "getItemCount", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "getItemViewType", "notifyCountdownAndTimerChanged", "app_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceListAdapter.kt */
public final class DeviceListAdapter extends RecyclerView.Adapter<DeviceViewHolder> {
    public static final int $stable = 8;
    private List<? extends Pair<? extends Device, IndoorDatapoint>> currentList = CollectionsKt.emptyList();
    private final PublishSubject<Device> deviceSelectedPublisher;
    private boolean forceOffline;
    private final PublishSubject<Device> offlineClickPublisher;
    private final PublishSubject<Device> standByModePublisher;

    public DeviceListAdapter(PublishSubject<Device> publishSubject, PublishSubject<Device> publishSubject2, PublishSubject<Device> publishSubject3) {
        Intrinsics.checkNotNullParameter(publishSubject, "deviceSelectedPublisher");
        Intrinsics.checkNotNullParameter(publishSubject2, "standByModePublisher");
        Intrinsics.checkNotNullParameter(publishSubject3, "offlineClickPublisher");
        this.deviceSelectedPublisher = publishSubject;
        this.standByModePublisher = publishSubject2;
        this.offlineClickPublisher = publishSubject3;
    }

    public final void setForceOffline(boolean z) {
        this.forceOffline = z;
        notifyDataSetChanged();
    }

    public final List<Pair<Device, IndoorDatapoint>> getCurrentList() {
        return this.currentList;
    }

    public final void setCurrentList(List<? extends Pair<? extends Device, IndoorDatapoint>> list) {
        Intrinsics.checkNotNullParameter(list, "newList");
        List<? extends Pair<? extends Device, IndoorDatapoint>> list2 = this.currentList;
        Iterable<Pair> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (Pair first : iterable) {
            arrayList.add((Device) first.getFirst());
        }
        List list3 = (List) arrayList;
        Iterable<Pair> iterable2 = list2;
        Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable2, 10));
        for (Pair first2 : iterable2) {
            arrayList2.add((Device) first2.getFirst());
        }
        if (DeviceListAdapterKt.doListsContainSameDevices(list3, (List) arrayList2)) {
            int i = 0;
            for (Object next : iterable2) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Pair pair = (Pair) next;
                if (DeviceListAdapterKt.hasDeviceChanged((Device) pair.getFirst(), list3) || (DeviceKt.isG4orB4orNB((Device) pair.getFirst()) && !Intrinsics.areEqual(pair.getSecond(), ((Pair) list.get(i)).getSecond()))) {
                    this.currentList = list;
                    notifyItemRangeChanged(0, list.size());
                    return;
                }
                i = i2;
            }
            return;
        }
        this.currentList = list;
        notifyDataSetChanged();
    }

    public int getItemCount() {
        return this.currentList.size();
    }

    public DeviceViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        return DeviceViewHolder.Companion.newInstance(viewGroup);
    }

    public void onBindViewHolder(DeviceViewHolder deviceViewHolder, int i) {
        Intrinsics.checkNotNullParameter(deviceViewHolder, "holder");
        Device device = (Device) ((Pair) this.currentList.get(i)).getFirst();
        Timber.Forest forest = Timber.Forest;
        forest.v("Binding adapter at position " + i + " with device " + device, new Object[0]);
        deviceViewHolder.update(device, (IndoorDatapoint) ((Pair) this.currentList.get(i)).getSecond(), this.forceOffline);
        deviceViewHolder.getClickView().setOnClickListener(new DeviceListAdapter$$ExternalSyntheticLambda0(this, device));
        deviceViewHolder.getStandByModeClickView().setOnClickListener(new DeviceListAdapter$$ExternalSyntheticLambda1(device, this));
        deviceViewHolder.getOfflineInfoView().setOnClickListener(new DeviceListAdapter$$ExternalSyntheticLambda2(this, device));
    }

    /* access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$3(DeviceListAdapter deviceListAdapter, Device device, View view) {
        deviceListAdapter.deviceSelectedPublisher.onNext(device);
    }

    private static final void onBindViewHolder$onStandbyClicked(Device device, DeviceListAdapter deviceListAdapter) {
        if (device.getConnectivityStatus() == ConnectivityStatus.ONLINE) {
            Timber.Forest.d("onStandbyClicked", new Object[0]);
            deviceListAdapter.standByModePublisher.onNext(device);
        }
    }

    /* access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$4(Device device, DeviceListAdapter deviceListAdapter, View view) {
        onBindViewHolder$onStandbyClicked(device, deviceListAdapter);
    }

    /* access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$5(DeviceListAdapter deviceListAdapter, Device device, View view) {
        deviceListAdapter.offlineClickPublisher.onNext(device);
    }

    public int getItemViewType(int i) {
        return ((Device) ((Pair) this.currentList.get(i)).getFirst()).getUid().hashCode();
    }

    public final void notifyCountdownAndTimerChanged() {
        int i = 0;
        for (Object next : this.currentList) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Pair pair = (Pair) next;
            Device device = (Device) pair.component1();
            IndoorDatapoint indoorDatapoint = (IndoorDatapoint) pair.component2();
            if ((!(device instanceof HasWick) || !((HasWick) device).getWickdryOn()) && !DeviceKt.isDisinfectionOn(device)) {
                if (device instanceof HasTimer) {
                    if (SetsKt.setOf(TimerState.START, TimerState.RESUME).contains(((HasTimer) device).timerStatus())) {
                        notifyItemChanged(i);
                    }
                }
                if ((device instanceof HasAlarm) && !CollectionsKt.filterNotNull(((HasAlarm) device).getAlarms()).isEmpty()) {
                    notifyItemChanged(i);
                }
            } else {
                notifyItemChanged(i);
            }
            i = i2;
        }
    }
}
