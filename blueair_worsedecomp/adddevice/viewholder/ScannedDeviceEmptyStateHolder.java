package com.blueair.adddevice.viewholder;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.adddevice.databinding.HolderScannedDeviceEmptyStateBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/blueair/adddevice/viewholder/ScannedDeviceEmptyStateHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/blueair/adddevice/databinding/HolderScannedDeviceEmptyStateBinding;", "<init>", "(Lcom/blueair/adddevice/databinding/HolderScannedDeviceEmptyStateBinding;)V", "getBinding", "()Lcom/blueair/adddevice/databinding/HolderScannedDeviceEmptyStateBinding;", "Companion", "adddevice_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: ScannedDeviceEmptyStateHolder.kt */
public final class ScannedDeviceEmptyStateHolder extends RecyclerView.ViewHolder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final HolderScannedDeviceEmptyStateBinding binding;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/blueair/adddevice/viewholder/ScannedDeviceEmptyStateHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/adddevice/viewholder/ScannedDeviceEmptyStateHolder;", "parentView", "Landroid/view/ViewGroup;", "adddevice_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: ScannedDeviceEmptyStateHolder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ScannedDeviceEmptyStateHolder newInstance(ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(viewGroup, "parentView");
            HolderScannedDeviceEmptyStateBinding inflate = HolderScannedDeviceEmptyStateBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            return new ScannedDeviceEmptyStateHolder(inflate);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScannedDeviceEmptyStateHolder(HolderScannedDeviceEmptyStateBinding holderScannedDeviceEmptyStateBinding) {
        super(holderScannedDeviceEmptyStateBinding.getRoot());
        Intrinsics.checkNotNullParameter(holderScannedDeviceEmptyStateBinding, "binding");
        this.binding = holderScannedDeviceEmptyStateBinding;
    }

    public final HolderScannedDeviceEmptyStateBinding getBinding() {
        return this.binding;
    }
}
