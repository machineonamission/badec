package com.blueair.devicedetails.viewholder;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.devicedetails.databinding.HolderDeviceFilterVideosBinding;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceFilterVideoHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/blueair/devicedetails/databinding/HolderDeviceFilterVideosBinding;", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceFilterVideosBinding;)V", "getBinding", "()Lcom/blueair/devicedetails/databinding/HolderDeviceFilterVideosBinding;", "update", "", "shouldShowSummary", "", "titleRes", "", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceFilterVideoHolder.kt */
public final class DeviceFilterVideoHolder extends RecyclerView.ViewHolder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final HolderDeviceFilterVideosBinding binding;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeviceFilterVideoHolder(HolderDeviceFilterVideosBinding holderDeviceFilterVideosBinding) {
        super(holderDeviceFilterVideosBinding.getRoot());
        Intrinsics.checkNotNullParameter(holderDeviceFilterVideosBinding, "binding");
        this.binding = holderDeviceFilterVideosBinding;
    }

    public final HolderDeviceFilterVideosBinding getBinding() {
        return this.binding;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceFilterVideoHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceFilterVideoHolder;", "parentView", "Landroid/view/ViewGroup;", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceFilterVideoHolder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DeviceFilterVideoHolder newInstance(ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(viewGroup, "parentView");
            HolderDeviceFilterVideosBinding inflate = HolderDeviceFilterVideosBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            return new DeviceFilterVideoHolder(inflate);
        }
    }

    public static /* synthetic */ void update$default(DeviceFilterVideoHolder deviceFilterVideoHolder, boolean z, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        deviceFilterVideoHolder.update(z, i);
    }

    public final void update(boolean z, int i) {
        TextView textView = this.binding.videoSummary;
        Intrinsics.checkNotNullExpressionValue(textView, "videoSummary");
        ViewExtensionsKt.show(textView, z);
        ConstraintLayout constraintLayout = this.binding.videoThumbnailRoot;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "videoThumbnailRoot");
        ViewExtensionsKt.show(constraintLayout, !z);
        this.binding.videoTitle.setText(i);
    }
}
