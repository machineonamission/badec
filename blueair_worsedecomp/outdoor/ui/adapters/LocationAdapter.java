package com.blueair.outdoor.ui.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.AqiData;
import com.blueair.core.model.Device;
import com.blueair.core.model.TrackedLocation;
import com.blueair.outdoor.ui.adapters.LocationView;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B}\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\u000b\u0012\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000e0\u0010\u0012&\u0010\u0011\u001a\"\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0004\u0012\u00020\u000e0\u0012¢\u0006\u0004\b\u0015\u0010\u0016J\u0018\u00101\u001a\u00020\u00022\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020.H\u0016J\b\u00105\u001a\u00020.H\u0016J\u0018\u00106\u001a\u00020\u000e2\u0006\u00107\u001a\u00020\u00022\u0006\u00108\u001a\u00020.H\u0016J\u000e\u00109\u001a\u00020 2\u0006\u00108\u001a\u00020.J\u0018\u0010:\u001a\u00020\u000e2\u0006\u00108\u001a\u00020.2\u0006\u00107\u001a\u00020\u0002H\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\t\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R \u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\u000bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000e0\u0010X\u0004¢\u0006\u0002\n\u0000R.\u0010\u0011\u001a\"\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0004\u0012\u00020\u000e0\u0012X\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\b@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR(\u0010!\u001a\u0004\u0018\u00010 2\b\u0010\u001b\u001a\u0004\u0018\u00010 @FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R0\u0010&\u001a\b\u0012\u0004\u0012\u00020 0\u00132\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020 0\u0013@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u0011\u0010+\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b,\u0010\u001dR\u0014\u0010-\u001a\u00020.8BX\u0004¢\u0006\u0006\u001a\u0004\b/\u00100¨\u0006;"}, d2 = {"Lcom/blueair/outdoor/ui/adapters/LocationAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "context", "Landroid/content/Context;", "mapType", "", "showAssignProduct", "", "isSaveEnabled", "onSaveClicked", "Lkotlin/Function2;", "Lcom/blueair/core/model/TrackedLocation;", "Lcom/blueair/core/model/AqiData;", "", "onDeleteClicked", "Lkotlin/Function1;", "onAssignClicked", "Lkotlin/Function3;", "", "Lcom/blueair/core/model/Device;", "<init>", "(Landroid/content/Context;Ljava/lang/String;ZZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;)V", "getContext", "()Landroid/content/Context;", "getMapType", "()Ljava/lang/String;", "value", "getShowAssignProduct", "()Z", "setShowAssignProduct", "(Z)V", "Lcom/blueair/outdoor/ui/adapters/LocationItem;", "mergedCurrentLocation", "getMergedCurrentLocation", "()Lcom/blueair/outdoor/ui/adapters/LocationItem;", "setMergedCurrentLocation", "(Lcom/blueair/outdoor/ui/adapters/LocationItem;)V", "mergedData", "getMergedData", "()Ljava/util/List;", "setMergedData", "(Ljava/util/List;)V", "showCurrentLocation", "getShowCurrentLocation", "offset", "", "getOffset", "()I", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "getItemCount", "onBindViewHolder", "holder", "position", "getItem", "adjustWidth", "outdoor_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: LocationAdapter.kt */
public final class LocationAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final Context context;
    private final boolean isSaveEnabled;
    private final String mapType;
    private LocationItem mergedCurrentLocation;
    private List<LocationItem> mergedData = CollectionsKt.emptyList();
    private final Function3<TrackedLocation, List<? extends Device>, AqiData, Unit> onAssignClicked;
    private final Function1<TrackedLocation, Unit> onDeleteClicked;
    private final Function2<TrackedLocation, AqiData, Unit> onSaveClicked;
    private boolean showAssignProduct;

    public final Context getContext() {
        return this.context;
    }

    public final String getMapType() {
        return this.mapType;
    }

    public LocationAdapter(Context context2, String str, boolean z, boolean z2, Function2<? super TrackedLocation, ? super AqiData, Unit> function2, Function1<? super TrackedLocation, Unit> function1, Function3<? super TrackedLocation, ? super List<? extends Device>, ? super AqiData, Unit> function3) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(str, "mapType");
        Intrinsics.checkNotNullParameter(function2, "onSaveClicked");
        Intrinsics.checkNotNullParameter(function1, "onDeleteClicked");
        Intrinsics.checkNotNullParameter(function3, "onAssignClicked");
        this.context = context2;
        this.mapType = str;
        this.isSaveEnabled = z2;
        this.onSaveClicked = function2;
        this.onDeleteClicked = function1;
        this.onAssignClicked = function3;
        this.showAssignProduct = z;
    }

    public final boolean getShowAssignProduct() {
        return this.showAssignProduct;
    }

    public final void setShowAssignProduct(boolean z) {
        if (this.showAssignProduct != z) {
            this.showAssignProduct = z;
            notifyDataSetChanged();
        }
    }

    public final LocationItem getMergedCurrentLocation() {
        return this.mergedCurrentLocation;
    }

    public final void setMergedCurrentLocation(LocationItem locationItem) {
        this.mergedCurrentLocation = locationItem;
        notifyDataSetChanged();
    }

    public final List<LocationItem> getMergedData() {
        return this.mergedData;
    }

    public final void setMergedData(List<LocationItem> list) {
        Intrinsics.checkNotNullParameter(list, "value");
        this.mergedData = list;
        notifyDataSetChanged();
    }

    public final boolean getShowCurrentLocation() {
        return this.mergedCurrentLocation != null;
    }

    private final int getOffset() {
        return getShowCurrentLocation() ? 1 : 0;
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        return LocationViewHolder.Companion.newInstance(viewGroup);
    }

    public int getItemCount() {
        return this.mergedData.size() + getOffset();
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        adjustWidth(i, viewHolder);
        if (viewHolder instanceof LocationViewHolder) {
            LocationItem item = getItem(i);
            if (i != 0 || !getShowCurrentLocation()) {
                ((LocationViewHolder) viewHolder).bind(item, this.mapType, LocationView.TYPE.SAVED_LOCATION, this.showAssignProduct, this.isSaveEnabled, this.onSaveClicked, this.onDeleteClicked, this.onAssignClicked);
            } else {
                ((LocationViewHolder) viewHolder).bind(item, this.mapType, LocationView.TYPE.CURRENT_LOCATION, this.showAssignProduct, this.isSaveEnabled, this.onSaveClicked, this.onDeleteClicked, this.onAssignClicked);
            }
        }
    }

    public final LocationItem getItem(int i) {
        LocationItem locationItem = this.mergedCurrentLocation;
        if (i != 0 || locationItem == null) {
            return this.mergedData.get(i - getOffset());
        }
        return locationItem;
    }

    private final void adjustWidth(int i, RecyclerView.ViewHolder viewHolder) {
        int i2;
        Resources resources = this.context.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
        int applyDimension = (int) TypedValue.applyDimension(1, 20.0f, resources.getDisplayMetrics());
        int applyDimension2 = (int) TypedValue.applyDimension(1, 8.0f, resources.getDisplayMetrics());
        int applyDimension3 = (resources.getDisplayMetrics().widthPixels - (applyDimension2 * 2)) - ((int) TypedValue.applyDimension(1, 32.0f, resources.getDisplayMetrics()));
        if (i == 0) {
            i2 = 0;
        } else if ((getShowCurrentLocation() || i != this.mergedData.size() - 1) && (!getShowCurrentLocation() || i != this.mergedData.size())) {
            i2 = 0;
            applyDimension = 0;
        } else {
            i2 = applyDimension;
            applyDimension = 0;
        }
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(applyDimension3, -1);
        layoutParams.setMargins(applyDimension + applyDimension2, 0, applyDimension2 + i2, 0);
        viewHolder.itemView.setLayoutParams(layoutParams);
    }
}
