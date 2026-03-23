package com.blueair.outdoor.ui.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.AqiData;
import com.blueair.core.model.Device;
import com.blueair.core.model.TrackedLocation;
import com.blueair.outdoor.ui.adapters.LocationView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0001\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0018\u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00070\u00122\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00070\u00162&\u0010\u0017\u001a\"\u0012\u0004\u0012\u00020\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0012\u0004\u0012\u00020\u00070\u0018¨\u0006\u001c"}, d2 = {"Lcom/blueair/outdoor/ui/adapters/LocationViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Lcom/blueair/outdoor/ui/adapters/LocationView;", "<init>", "(Lcom/blueair/outdoor/ui/adapters/LocationView;)V", "bind", "", "locationData", "Lcom/blueair/outdoor/ui/adapters/LocationItem;", "mapType", "", "type", "Lcom/blueair/outdoor/ui/adapters/LocationView$TYPE;", "showAssignProduct", "", "isSaveEnabled", "onSaveClicked", "Lkotlin/Function2;", "Lcom/blueair/core/model/TrackedLocation;", "Lcom/blueair/core/model/AqiData;", "onDeleteClicked", "Lkotlin/Function1;", "onAssignClicked", "Lkotlin/Function3;", "", "Lcom/blueair/core/model/Device;", "Companion", "outdoor_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: LocationAdapter.kt */
public final class LocationViewHolder extends RecyclerView.ViewHolder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002¨\u0006\n"}, d2 = {"Lcom/blueair/outdoor/ui/adapters/LocationViewHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/outdoor/ui/adapters/LocationViewHolder;", "parent", "Landroid/view/ViewGroup;", "createView", "Lcom/blueair/outdoor/ui/adapters/LocationView;", "outdoor_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: LocationAdapter.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final LocationViewHolder newInstance(ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            return new LocationViewHolder(createView(viewGroup));
        }

        private final LocationView createView(ViewGroup viewGroup) {
            Context context = viewGroup.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            LocationView locationView = new LocationView(context);
            FrameLayout frameLayout = locationView.getBinding().progressBar;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "progressBar");
            ViewExtensionsKt.hide(frameLayout);
            ConstraintLayout constraintLayout = locationView.getBinding().saveContainer;
            Intrinsics.checkNotNullExpressionValue(constraintLayout, "saveContainer");
            ViewExtensionsKt.hide(constraintLayout);
            return locationView;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LocationViewHolder(LocationView locationView) {
        super(locationView);
        Intrinsics.checkNotNullParameter(locationView, ViewHierarchyConstants.VIEW_KEY);
    }

    public final void bind(LocationItem locationItem, String str, LocationView.TYPE type, boolean z, boolean z2, Function2<? super TrackedLocation, ? super AqiData, Unit> function2, Function1<? super TrackedLocation, Unit> function1, Function3<? super TrackedLocation, ? super List<? extends Device>, ? super AqiData, Unit> function3) {
        Intrinsics.checkNotNullParameter(locationItem, "locationData");
        Intrinsics.checkNotNullParameter(str, "mapType");
        Intrinsics.checkNotNullParameter(type, "type");
        Function2<? super TrackedLocation, ? super AqiData, Unit> function22 = function2;
        Intrinsics.checkNotNullParameter(function22, "onSaveClicked");
        Function1<? super TrackedLocation, Unit> function12 = function1;
        Intrinsics.checkNotNullParameter(function12, "onDeleteClicked");
        Function3<? super TrackedLocation, ? super List<? extends Device>, ? super AqiData, Unit> function32 = function3;
        Intrinsics.checkNotNullParameter(function32, "onAssignClicked");
        View view = this.itemView;
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.blueair.outdoor.ui.adapters.LocationView");
        ((LocationView) view).bind(locationItem, str, type, z, z2, function22, function12, function32);
    }
}
