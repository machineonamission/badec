package com.blueair.devicedetails.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.Device;
import com.blueair.core.model.FilterInfo;
import com.blueair.devicedetails.util.DeviceFilterPageWidget;
import com.blueair.devicedetails.viewholder.DeviceFilterPurchaseHolder;
import com.blueair.devicedetails.viewholder.DeviceFilterResetHolder;
import com.blueair.devicedetails.viewholder.DeviceFilterStatusHolder;
import com.blueair.devicedetails.viewholder.DeviceFilterTypeHolder;
import com.blueair.devicedetails.viewholder.DeviceFilterVideoHolder;
import com.blueair.viewcore.R;
import io.reactivex.subjects.PublishSubject;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B#\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\u0004\b\b\u0010\tJ<\u0010\u0014\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0015\u001a\u00020\u00052\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0017H\u0016J\u0018\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0017H\u0016J\u0018\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0017H\u0016J\u0017\u0010 \u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0019\u001a\u00020\u0017H\u0002¢\u0006\u0002\u0010!R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""},
   d2 = {"Lcom/blueair/devicedetails/adapter/DeviceFilterPageAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "openFilterVideoPublisher", "Lio/reactivex/subjects/PublishSubject;", "", "openFilterSelectionPublisher", "Lcom/blueair/core/model/Device;", "<init>", "(Lio/reactivex/subjects/PublishSubject;Lio/reactivex/subjects/PublishSubject;)V", "widgets", "", "Lcom/blueair/devicedetails/util/DeviceFilterPageWidget;", "device", "filterInfo", "Lcom/blueair/core/model/FilterInfo;", "onOrderFilter", "Lkotlin/Function0;", "", "onResetFilter", "setDevice", "filterPurchase", "getItemCount", "", "getItemViewType", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "getWidgetType", "(I)Ljava/lang/Integer;", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceFilterPageAdapter extends RecyclerView.Adapter {
   private Device device;
   private FilterInfo filterInfo;
   private Function0 onOrderFilter;
   private Function0 onResetFilter;
   private final PublishSubject openFilterSelectionPublisher;
   private final PublishSubject openFilterVideoPublisher;
   private List widgets;

   // $FF: synthetic method
   public static Unit $r8$lambda$CzcuVgYXTH6gG_jJBlxYo4dxzDY/* $FF was: $r8$lambda$CzcuVgYXTH6gG-jJBlxYo4dxzDY*/(boolean var0) {
      return onCreateViewHolder$lambda$0(var0);
   }

   // $FF: synthetic method
   public static void $r8$lambda$IwCgY0GE8AaW_SRNHNkarLC8_bM/* $FF was: $r8$lambda$IwCgY0GE8AaW_SRNHNkarLC8-bM*/(DeviceFilterPageAdapter var0, View var1) {
      onBindViewHolder$lambda$5(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$b1hFTF6_XAun6BGU43LnPkkkCx0(DeviceFilterPageAdapter var0, View var1) {
      onBindViewHolder$lambda$7$lambda$6(var0, var1);
   }

   public DeviceFilterPageAdapter(PublishSubject var1, PublishSubject var2) {
      Intrinsics.checkNotNullParameter(var1, "openFilterVideoPublisher");
      Intrinsics.checkNotNullParameter(var2, "openFilterSelectionPublisher");
      super();
      this.openFilterVideoPublisher = var1;
      this.openFilterSelectionPublisher = var2;
      this.widgets = CollectionsKt.emptyList();
   }

   private final Integer getWidgetType(int var1) {
      return (Integer)DeviceFilterPageWidget.Companion.getWidgetsToViewType().get(this.widgets.get(var1));
   }

   private static final void onBindViewHolder$lambda$5(DeviceFilterPageAdapter var0, View var1) {
      Device var2 = var0.device;
      if (var2 != null) {
         var0.openFilterSelectionPublisher.onNext(var2);
      }

   }

   private static final void onBindViewHolder$lambda$7$lambda$6(DeviceFilterPageAdapter var0, View var1) {
      var0.openFilterVideoPublisher.onNext(true);
   }

   private static final Unit onCreateViewHolder$lambda$0(boolean var0) {
      return Unit.INSTANCE;
   }

   public int getItemCount() {
      return this.device != null ? this.widgets.size() : 0;
   }

   public int getItemViewType(int var1) {
      Timber.Forest var2 = Timber.Forest;
      StringBuilder var3 = new StringBuilder("getItemViewType:  supported widgets = ");
      var3.append(this.widgets);
      var2.d(var3.toString(), new Object[0]);
      Integer var4 = this.getWidgetType(var1);
      if (var4 != null) {
         return var4;
      } else {
         throw new Exception("viewType should not be null if itemcount > 0");
      }
   }

   public void onBindViewHolder(RecyclerView.ViewHolder var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "holder");
      if (var1 instanceof DeviceFilterStatusHolder) {
         Device var3 = this.device;
         if (var3 != null) {
            ((DeviceFilterStatusHolder)var1).update(var3, true);
            return;
         }
      } else {
         if (var1 instanceof DeviceFilterTypeHolder) {
            Device var6 = this.device;
            if (var6 != null) {
               FilterInfo var4 = this.filterInfo;
               if (var4 != null) {
                  ((DeviceFilterTypeHolder)var1).update(var6, var4);
               }
            }

            ((DeviceFilterTypeHolder)var1).getBinding().myFilterBtn.setOnClickListener(new DeviceFilterPageAdapter$$ExternalSyntheticLambda0(this));
            return;
         }

         if (var1 instanceof DeviceFilterVideoHolder) {
            DeviceFilterPageWidget var5 = (DeviceFilterPageWidget)this.widgets.get(var2);
            if (this.device != null) {
               if (Intrinsics.areEqual(var5, DeviceFilterPageWidget.FilterTutorialVideo.INSTANCE)) {
                  ((DeviceFilterVideoHolder)var1).update(false, R.string.how_to_change_filter);
               } else if (Intrinsics.areEqual(var5, DeviceFilterPageWidget.FilterImportanceVideo.INSTANCE)) {
                  ((DeviceFilterVideoHolder)var1).update(true, R.string.why_is_this_important);
               }

               ((DeviceFilterVideoHolder)var1).getBinding().iconPlay.setOnClickListener(new DeviceFilterPageAdapter$$ExternalSyntheticLambda1(this));
               return;
            }
         } else {
            if (var1 instanceof DeviceFilterResetHolder) {
               ((DeviceFilterResetHolder)var1).update(this.onResetFilter);
               return;
            }

            if (var1 instanceof DeviceFilterPurchaseHolder) {
               ((DeviceFilterPurchaseHolder)var1).update(this.onOrderFilter);
            }
         }
      }

   }

   public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "parent");
      DeviceFilterPageWidget var3 = (DeviceFilterPageWidget)DeviceFilterPageWidget.Companion.getWIDGETS().get(var2);
      if (Intrinsics.areEqual(var3, DeviceFilterPageWidget.FilterType.INSTANCE)) {
         return DeviceFilterTypeHolder.Companion.newInstance(var1);
      } else if (Intrinsics.areEqual(var3, DeviceFilterPageWidget.FilterStatus.INSTANCE)) {
         return DeviceFilterStatusHolder.Companion.newInstance(var1, new DeviceFilterPageAdapter$$ExternalSyntheticLambda2());
      } else if (!Intrinsics.areEqual(var3, DeviceFilterPageWidget.FilterImportanceVideo.INSTANCE) && !Intrinsics.areEqual(var3, DeviceFilterPageWidget.FilterTutorialVideo.INSTANCE)) {
         if (Intrinsics.areEqual(var3, DeviceFilterPageWidget.FilterReset.INSTANCE)) {
            return DeviceFilterResetHolder.Companion.newInstance(var1);
         } else if (Intrinsics.areEqual(var3, DeviceFilterPageWidget.FilterPurchase.INSTANCE)) {
            return DeviceFilterPurchaseHolder.Companion.newInstance(var1);
         } else {
            throw new NoWhenBranchMatchedException();
         }
      } else {
         return DeviceFilterVideoHolder.Companion.newInstance(var1);
      }
   }

   public final void setDevice(Device var1, FilterInfo var2, boolean var3, Function0 var4, Function0 var5) {
      Intrinsics.checkNotNullParameter(var1, "device");
      Intrinsics.checkNotNullParameter(var4, "onOrderFilter");
      Intrinsics.checkNotNullParameter(var5, "onResetFilter");
      this.device = var1;
      this.filterInfo = var2;
      this.widgets = DeviceFilterPageWidget.Companion.getSupportedWidgets(var1, var3);
      this.onOrderFilter = var4;
      this.onResetFilter = var5;
      this.notifyDataSetChanged();
   }
}
