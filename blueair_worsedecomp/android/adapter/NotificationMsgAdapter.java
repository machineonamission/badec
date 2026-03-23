package com.blueair.android.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.android.databinding.CardItemNotificationBinding;
import com.blueair.android.viewholder.NotificationMsgHolder;
import com.blueair.auth.LocationService;
import com.blueair.core.model.NotificationMessage;
import com.blueair.core.model.SimpleEvent;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B)\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0018\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00070\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0013H\u0016J\b\u0010\u0018\u001a\u00020\u0013H\u0016J\u0016\u0010\u0019\u001a\u00020\u00152\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0007J\u000e\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\tJ\u000e\u0010\u001f\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\u0013J\u0010\u0010!\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0017\u001a\u00020\u0013R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R \u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\t0\rj\b\u0012\u0004\u0012\u00020\t`\u000eX\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/blueair/android/adapter/NotificationMsgAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/blueair/android/viewholder/NotificationMsgHolder;", "locationService", "Lcom/blueair/auth/LocationService;", "clickPublisher", "Lio/reactivex/subjects/PublishSubject;", "Lcom/blueair/core/model/SimpleEvent;", "", "Lcom/blueair/android/adapter/NotificationItem;", "<init>", "(Lcom/blueair/auth/LocationService;Lio/reactivex/subjects/PublishSubject;)V", "items", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "getItemCount", "setNewList", "list", "", "Lcom/blueair/core/model/NotificationMessage;", "remove", "item", "removeAt", "index", "getItem", "app_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: NotificationMsgAdapter.kt */
public final class NotificationMsgAdapter extends RecyclerView.Adapter<NotificationMsgHolder> {
    public static final int $stable = 8;
    private final PublishSubject<SimpleEvent<String, NotificationItem>> clickPublisher;
    private final ArrayList<NotificationItem> items = new ArrayList<>();
    private final LocationService locationService;

    public NotificationMsgAdapter(LocationService locationService2, PublishSubject<SimpleEvent<String, NotificationItem>> publishSubject) {
        Intrinsics.checkNotNullParameter(locationService2, "locationService");
        Intrinsics.checkNotNullParameter(publishSubject, "clickPublisher");
        this.locationService = locationService2;
        this.clickPublisher = publishSubject;
    }

    public NotificationMsgHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        CardItemNotificationBinding inflate = CardItemNotificationBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new NotificationMsgHolder(inflate);
    }

    public void onBindViewHolder(NotificationMsgHolder notificationMsgHolder, int i) {
        Intrinsics.checkNotNullParameter(notificationMsgHolder, "holder");
        notificationMsgHolder.hydrate(this.items.get(i), this.clickPublisher);
    }

    public int getItemCount() {
        return this.items.size();
    }

    public final void setNewList(List<NotificationMessage> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.items.clear();
        ArrayList<NotificationItem> arrayList = this.items;
        Iterable<NotificationMessage> iterable = list;
        Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (NotificationMessage notificationItem : iterable) {
            arrayList2.add(new NotificationItem(notificationItem, (List) null, false, 4, (DefaultConstructorMarker) null));
        }
        arrayList.addAll((List) arrayList2);
        notifyDataSetChanged();
    }

    public final void remove(NotificationItem notificationItem) {
        Intrinsics.checkNotNullParameter(notificationItem, "item");
        int indexOf = this.items.indexOf(notificationItem);
        if (indexOf > -1) {
            removeAt(indexOf);
        }
    }

    public final void removeAt(int i) {
        this.items.remove(i);
        notifyItemRemoved(i);
    }

    public final NotificationItem getItem(int i) {
        return (NotificationItem) CollectionsKt.getOrNull(this.items, i);
    }
}
