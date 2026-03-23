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

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B#\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\u0004\b\b\u0010\tJ<\u0010\u0014\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0015\u001a\u00020\u00052\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0017H\u0016J\u0018\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0017H\u0016J\u0018\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0017H\u0016J\u0017\u0010 \u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0019\u001a\u00020\u0017H\u0002¢\u0006\u0002\u0010!R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/blueair/devicedetails/adapter/DeviceFilterPageAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "openFilterVideoPublisher", "Lio/reactivex/subjects/PublishSubject;", "", "openFilterSelectionPublisher", "Lcom/blueair/core/model/Device;", "<init>", "(Lio/reactivex/subjects/PublishSubject;Lio/reactivex/subjects/PublishSubject;)V", "widgets", "", "Lcom/blueair/devicedetails/util/DeviceFilterPageWidget;", "device", "filterInfo", "Lcom/blueair/core/model/FilterInfo;", "onOrderFilter", "Lkotlin/Function0;", "", "onResetFilter", "setDevice", "filterPurchase", "getItemCount", "", "getItemViewType", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "getWidgetType", "(I)Ljava/lang/Integer;", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceFilterPageAdapter.kt */
public final class DeviceFilterPageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Device device;
    private FilterInfo filterInfo;
    private Function0<Unit> onOrderFilter;
    private Function0<Unit> onResetFilter;
    private final PublishSubject<Device> openFilterSelectionPublisher;
    private final PublishSubject<Boolean> openFilterVideoPublisher;
    private List<? extends DeviceFilterPageWidget> widgets = CollectionsKt.emptyList();

    public DeviceFilterPageAdapter(PublishSubject<Boolean> publishSubject, PublishSubject<Device> publishSubject2) {
        Intrinsics.checkNotNullParameter(publishSubject, "openFilterVideoPublisher");
        Intrinsics.checkNotNullParameter(publishSubject2, "openFilterSelectionPublisher");
        this.openFilterVideoPublisher = publishSubject;
        this.openFilterSelectionPublisher = publishSubject2;
    }

    public final void setDevice(Device device2, FilterInfo filterInfo2, boolean z, Function0<Unit> function0, Function0<Unit> function02) {
        Intrinsics.checkNotNullParameter(device2, "device");
        Intrinsics.checkNotNullParameter(function0, "onOrderFilter");
        Intrinsics.checkNotNullParameter(function02, "onResetFilter");
        this.device = device2;
        this.filterInfo = filterInfo2;
        this.widgets = DeviceFilterPageWidget.Companion.getSupportedWidgets(device2, z);
        this.onOrderFilter = function0;
        this.onResetFilter = function02;
        notifyDataSetChanged();
    }

    public int getItemCount() {
        if (this.device != null) {
            return this.widgets.size();
        }
        return 0;
    }

    public int getItemViewType(int i) {
        Timber.Forest forest = Timber.Forest;
        forest.d("getItemViewType:  supported widgets = " + this.widgets, new Object[0]);
        Integer widgetType = getWidgetType(i);
        if (widgetType != null) {
            return widgetType.intValue();
        }
        throw new Exception("viewType should not be null if itemcount > 0");
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        DeviceFilterPageWidget deviceFilterPageWidget = DeviceFilterPageWidget.Companion.getWIDGETS().get(i);
        if (Intrinsics.areEqual((Object) deviceFilterPageWidget, (Object) DeviceFilterPageWidget.FilterType.INSTANCE)) {
            return DeviceFilterTypeHolder.Companion.newInstance(viewGroup);
        }
        if (Intrinsics.areEqual((Object) deviceFilterPageWidget, (Object) DeviceFilterPageWidget.FilterStatus.INSTANCE)) {
            return DeviceFilterStatusHolder.Companion.newInstance(viewGroup, new DeviceFilterPageAdapter$$ExternalSyntheticLambda2());
        }
        if (Intrinsics.areEqual((Object) deviceFilterPageWidget, (Object) DeviceFilterPageWidget.FilterImportanceVideo.INSTANCE) || Intrinsics.areEqual((Object) deviceFilterPageWidget, (Object) DeviceFilterPageWidget.FilterTutorialVideo.INSTANCE)) {
            return DeviceFilterVideoHolder.Companion.newInstance(viewGroup);
        }
        if (Intrinsics.areEqual((Object) deviceFilterPageWidget, (Object) DeviceFilterPageWidget.FilterReset.INSTANCE)) {
            return DeviceFilterResetHolder.Companion.newInstance(viewGroup);
        }
        if (Intrinsics.areEqual((Object) deviceFilterPageWidget, (Object) DeviceFilterPageWidget.FilterPurchase.INSTANCE)) {
            return DeviceFilterPurchaseHolder.Companion.newInstance(viewGroup);
        }
        throw new NoWhenBranchMatchedException();
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$0(boolean z) {
        return Unit.INSTANCE;
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        FilterInfo filterInfo2;
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        if (viewHolder instanceof DeviceFilterStatusHolder) {
            Device device2 = this.device;
            if (device2 != null) {
                ((DeviceFilterStatusHolder) viewHolder).update(device2, true);
            }
        } else if (viewHolder instanceof DeviceFilterTypeHolder) {
            Device device3 = this.device;
            if (!(device3 == null || (filterInfo2 = this.filterInfo) == null)) {
                ((DeviceFilterTypeHolder) viewHolder).update(device3, filterInfo2);
            }
            ((DeviceFilterTypeHolder) viewHolder).getBinding().myFilterBtn.setOnClickListener(new DeviceFilterPageAdapter$$ExternalSyntheticLambda0(this));
        } else if (viewHolder instanceof DeviceFilterVideoHolder) {
            DeviceFilterPageWidget deviceFilterPageWidget = (DeviceFilterPageWidget) this.widgets.get(i);
            if (this.device != null) {
                if (Intrinsics.areEqual((Object) deviceFilterPageWidget, (Object) DeviceFilterPageWidget.FilterTutorialVideo.INSTANCE)) {
                    ((DeviceFilterVideoHolder) viewHolder).update(false, R.string.how_to_change_filter);
                } else if (Intrinsics.areEqual((Object) deviceFilterPageWidget, (Object) DeviceFilterPageWidget.FilterImportanceVideo.INSTANCE)) {
                    ((DeviceFilterVideoHolder) viewHolder).update(true, R.string.why_is_this_important);
                }
                ((DeviceFilterVideoHolder) viewHolder).getBinding().iconPlay.setOnClickListener(new DeviceFilterPageAdapter$$ExternalSyntheticLambda1(this));
            }
        } else if (viewHolder instanceof DeviceFilterResetHolder) {
            ((DeviceFilterResetHolder) viewHolder).update(this.onResetFilter);
        } else if (viewHolder instanceof DeviceFilterPurchaseHolder) {
            ((DeviceFilterPurchaseHolder) viewHolder).update(this.onOrderFilter);
        }
    }

    /* access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$5(DeviceFilterPageAdapter deviceFilterPageAdapter, View view) {
        Device device2 = deviceFilterPageAdapter.device;
        if (device2 != null) {
            deviceFilterPageAdapter.openFilterSelectionPublisher.onNext(device2);
        }
    }

    /* access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$7$lambda$6(DeviceFilterPageAdapter deviceFilterPageAdapter, View view) {
        deviceFilterPageAdapter.openFilterVideoPublisher.onNext(true);
    }

    private final Integer getWidgetType(int i) {
        return DeviceFilterPageWidget.Companion.getWidgetsToViewType().get(this.widgets.get(i));
    }
}
