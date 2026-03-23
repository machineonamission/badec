package com.blueair.adddevice.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.adddevice.adapter.DeviceModel;
import com.blueair.adddevice.databinding.HolderLegacyDeviceEntryBinding;
import com.blueair.adddevice.databinding.LayoutLegacyDeviceBinding;
import com.blueair.auth.LocationService;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0015"}, d2 = {"Lcom/blueair/adddevice/viewholder/LegacyDeviceEntryHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/blueair/adddevice/databinding/HolderLegacyDeviceEntryBinding;", "locationService", "Lcom/blueair/auth/LocationService;", "<init>", "(Lcom/blueair/adddevice/databinding/HolderLegacyDeviceEntryBinding;Lcom/blueair/auth/LocationService;)V", "getBinding", "()Lcom/blueair/adddevice/databinding/HolderLegacyDeviceEntryBinding;", "clickView", "Landroid/view/View;", "getClickView", "()Landroid/view/View;", "hydrateDeviceModel", "", "layoutBinding", "Lcom/blueair/adddevice/databinding/LayoutLegacyDeviceBinding;", "model", "Lcom/blueair/adddevice/adapter/DeviceModel;", "Companion", "adddevice_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: LegacyDeviceEntryHolder.kt */
public final class LegacyDeviceEntryHolder extends RecyclerView.ViewHolder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final HolderLegacyDeviceEntryBinding binding;
    private final View clickView;
    private final LocationService locationService;

    public final HolderLegacyDeviceEntryBinding getBinding() {
        return this.binding;
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"Lcom/blueair/adddevice/viewholder/LegacyDeviceEntryHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/adddevice/viewholder/LegacyDeviceEntryHolder;", "parentView", "Landroid/view/ViewGroup;", "locationService", "Lcom/blueair/auth/LocationService;", "adddevice_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: LegacyDeviceEntryHolder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final LegacyDeviceEntryHolder newInstance(ViewGroup viewGroup, LocationService locationService) {
            Intrinsics.checkNotNullParameter(viewGroup, "parentView");
            Intrinsics.checkNotNullParameter(locationService, "locationService");
            HolderLegacyDeviceEntryBinding inflate = HolderLegacyDeviceEntryBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            return new LegacyDeviceEntryHolder(inflate, locationService);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LegacyDeviceEntryHolder(HolderLegacyDeviceEntryBinding holderLegacyDeviceEntryBinding, LocationService locationService2) {
        super(holderLegacyDeviceEntryBinding.getRoot());
        Intrinsics.checkNotNullParameter(holderLegacyDeviceEntryBinding, "binding");
        Intrinsics.checkNotNullParameter(locationService2, "locationService");
        this.binding = holderLegacyDeviceEntryBinding;
        this.locationService = locationService2;
        TextView textView = holderLegacyDeviceEntryBinding.tvSelect;
        Intrinsics.checkNotNullExpressionValue(textView, "tvSelect");
        this.clickView = textView;
        LayoutLegacyDeviceBinding layoutLegacyDeviceBinding = holderLegacyDeviceEntryBinding.layoutClassic;
        Intrinsics.checkNotNullExpressionValue(layoutLegacyDeviceBinding, "layoutClassic");
        hydrateDeviceModel(layoutLegacyDeviceBinding, DeviceModel.CLASSIC);
        LayoutLegacyDeviceBinding layoutLegacyDeviceBinding2 = holderLegacyDeviceEntryBinding.layoutSense;
        Intrinsics.checkNotNullExpressionValue(layoutLegacyDeviceBinding2, "layoutSense");
        hydrateDeviceModel(layoutLegacyDeviceBinding2, DeviceModel.SENSE);
        if (locationService2.isInAwareRegion()) {
            LayoutLegacyDeviceBinding layoutLegacyDeviceBinding3 = holderLegacyDeviceEntryBinding.layoutAware;
            Intrinsics.checkNotNullExpressionValue(layoutLegacyDeviceBinding3, "layoutAware");
            hydrateDeviceModel(layoutLegacyDeviceBinding3, DeviceModel.AWARE);
            LinearLayout root = holderLegacyDeviceEntryBinding.layoutAware.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
            ViewExtensionsKt.show$default(root, false, 1, (Object) null);
        }
        if (locationService2.isInIcpRegion()) {
            LayoutLegacyDeviceBinding layoutLegacyDeviceBinding4 = holderLegacyDeviceEntryBinding.layoutIcp;
            Intrinsics.checkNotNullExpressionValue(layoutLegacyDeviceBinding4, "layoutIcp");
            hydrateDeviceModel(layoutLegacyDeviceBinding4, DeviceModel.ICP);
            LinearLayout root2 = holderLegacyDeviceEntryBinding.layoutIcp.getRoot();
            Intrinsics.checkNotNullExpressionValue(root2, "getRoot(...)");
            ViewExtensionsKt.show$default(root2, false, 1, (Object) null);
        }
    }

    public final View getClickView() {
        return this.clickView;
    }

    private final void hydrateDeviceModel(LayoutLegacyDeviceBinding layoutLegacyDeviceBinding, DeviceModel deviceModel) {
        layoutLegacyDeviceBinding.ivImage.setImageResource(deviceModel.getModelImageRes());
        layoutLegacyDeviceBinding.tvTitle.setText(deviceModel.getModelName());
    }
}
