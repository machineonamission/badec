package com.blueair.android.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.android.databinding.CardItemNotificationBinding;
import com.blueair.android.viewholder.NotificationMsgHolder;
import com.blueair.auth.LocationService;
import com.blueair.core.model.NotificationMessage;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B)\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0018\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00070\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0013H\u0016J\b\u0010\u0018\u001a\u00020\u0013H\u0016J\u0016\u0010\u0019\u001a\u00020\u00152\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0007J\u000e\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\tJ\u000e\u0010\u001f\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\u0013J\u0010\u0010!\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0017\u001a\u00020\u0013R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\t0\rj\b\u0012\u0004\u0012\u00020\t`\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""},
   d2 = {"Lcom/blueair/android/adapter/NotificationMsgAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/blueair/android/viewholder/NotificationMsgHolder;", "locationService", "Lcom/blueair/auth/LocationService;", "clickPublisher", "Lio/reactivex/subjects/PublishSubject;", "Lcom/blueair/core/model/SimpleEvent;", "", "Lcom/blueair/android/adapter/NotificationItem;", "<init>", "(Lcom/blueair/auth/LocationService;Lio/reactivex/subjects/PublishSubject;)V", "items", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "getItemCount", "setNewList", "list", "", "Lcom/blueair/core/model/NotificationMessage;", "remove", "item", "removeAt", "index", "getItem", "app_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class NotificationMsgAdapter extends RecyclerView.Adapter {
   public static final int $stable = 8;
   private final PublishSubject clickPublisher;
   private final ArrayList items;
   private final LocationService locationService;

   public NotificationMsgAdapter(LocationService var1, PublishSubject var2) {
      Intrinsics.checkNotNullParameter(var1, "locationService");
      Intrinsics.checkNotNullParameter(var2, "clickPublisher");
      super();
      this.locationService = var1;
      this.clickPublisher = var2;
      this.items = new ArrayList();
   }

   public final NotificationItem getItem(int var1) {
      return (NotificationItem)CollectionsKt.getOrNull((List)this.items, var1);
   }

   public int getItemCount() {
      return this.items.size();
   }

   public void onBindViewHolder(NotificationMsgHolder var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "holder");
      var1.hydrate((NotificationItem)this.items.get(var2), this.clickPublisher);
   }

   public NotificationMsgHolder onCreateViewHolder(ViewGroup var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "parent");
      CardItemNotificationBinding var3 = CardItemNotificationBinding.inflate(LayoutInflater.from(var1.getContext()), var1, false);
      Intrinsics.checkNotNullExpressionValue(var3, "inflate(...)");
      return new NotificationMsgHolder(var3);
   }

   public final void remove(NotificationItem var1) {
      Intrinsics.checkNotNullParameter(var1, "item");
      int var2 = this.items.indexOf(var1);
      if (var2 > -1) {
         this.removeAt(var2);
      }

   }

   public final void removeAt(int var1) {
      this.items.remove(var1);
      this.notifyItemRemoved(var1);
   }

   public final void setNewList(List var1) {
      Intrinsics.checkNotNullParameter(var1, "list");
      this.items.clear();
      ArrayList var2 = this.items;
      Iterable var3 = (Iterable)var1;
      Collection var4 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var3, 10)));
      Iterator var5 = var3.iterator();

      while(var5.hasNext()) {
         var4.add(new NotificationItem((NotificationMessage)var5.next(), (List)null, false, 4, (DefaultConstructorMarker)null));
      }

      var2.addAll((Collection)((List)var4));
      this.notifyDataSetChanged();
   }
}
