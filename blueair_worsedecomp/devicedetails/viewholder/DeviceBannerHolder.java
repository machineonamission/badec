package com.blueair.devicedetails.viewholder;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.Device;
import com.blueair.devicedetails.adapter.DeviceBannerAdapter;
import com.blueair.devicedetails.databinding.HolderDeviceBannerBinding;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceBannerHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/blueair/devicedetails/databinding/HolderDeviceBannerBinding;", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceBannerBinding;)V", "getBinding", "()Lcom/blueair/devicedetails/databinding/HolderDeviceBannerBinding;", "bind", "", "banner", "Lcom/blueair/devicedetails/adapter/DeviceBannerAdapter$Banner;", "device", "Lcom/blueair/core/model/Device;", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceBannerHolder.kt */
public final class DeviceBannerHolder extends RecyclerView.ViewHolder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final HolderDeviceBannerBinding binding;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceBannerHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceBannerHolder;", "parentView", "Landroid/view/ViewGroup;", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceBannerHolder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DeviceBannerHolder newInstance(ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(viewGroup, "parentView");
            HolderDeviceBannerBinding inflate = HolderDeviceBannerBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            return new DeviceBannerHolder(inflate);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeviceBannerHolder(HolderDeviceBannerBinding holderDeviceBannerBinding) {
        super(holderDeviceBannerBinding.getRoot());
        Intrinsics.checkNotNullParameter(holderDeviceBannerBinding, "binding");
        this.binding = holderDeviceBannerBinding;
    }

    public final HolderDeviceBannerBinding getBinding() {
        return this.binding;
    }

    public final void bind(DeviceBannerAdapter.Banner banner, Device device) {
        Intrinsics.checkNotNullParameter(banner, "banner");
        Intrinsics.checkNotNullParameter(device, "device");
        HolderDeviceBannerBinding holderDeviceBannerBinding = this.binding;
        if (Intrinsics.areEqual((Object) banner, (Object) DeviceBannerAdapter.Banner.WarningWaterShortage.INSTANCE)) {
            ImageView imageView = holderDeviceBannerBinding.warningIcon;
            Intrinsics.checkNotNullExpressionValue(imageView, "warningIcon");
            ViewExtensionsKt.hide(imageView);
            holderDeviceBannerBinding.title.setText(this.itemView.getContext().getString(banner.getTitleRes(), new Object[]{device.getName()}));
            holderDeviceBannerBinding.message.setText(this.itemView.getContext().getString(banner.getMessageRes(), new Object[]{device.getName()}));
            return;
        }
        ImageView imageView2 = holderDeviceBannerBinding.warningIcon;
        Intrinsics.checkNotNullExpressionValue(imageView2, "warningIcon");
        ViewExtensionsKt.show$default(imageView2, false, 1, (Object) null);
        holderDeviceBannerBinding.title.setText(banner.getTitleRes());
        holderDeviceBannerBinding.message.setText(banner.getMessageRes());
    }
}
