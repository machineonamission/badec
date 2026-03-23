package com.blueair.android.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.android.databinding.HolderDeviceSmartIntegrationBinding;
import com.blueair.core.model.DeviceType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/blueair/android/adapter/SmartIntegrationDeviceHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/blueair/android/databinding/HolderDeviceSmartIntegrationBinding;", "<init>", "(Lcom/blueair/android/databinding/HolderDeviceSmartIntegrationBinding;)V", "getBinding", "()Lcom/blueair/android/databinding/HolderDeviceSmartIntegrationBinding;", "update", "", "nameRes", "", "imageRes", "g4Protect", "", "Companion", "app_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: SmartIntegrationDevicesAdapter.kt */
public final class SmartIntegrationDeviceHolder extends RecyclerView.ViewHolder {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final HolderDeviceSmartIntegrationBinding binding;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/blueair/android/adapter/SmartIntegrationDeviceHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/android/adapter/SmartIntegrationDeviceHolder;", "parentView", "Landroid/view/ViewGroup;", "app_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: SmartIntegrationDevicesAdapter.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SmartIntegrationDeviceHolder newInstance(ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(viewGroup, "parentView");
            HolderDeviceSmartIntegrationBinding inflate = HolderDeviceSmartIntegrationBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            return new SmartIntegrationDeviceHolder(inflate);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SmartIntegrationDeviceHolder(HolderDeviceSmartIntegrationBinding holderDeviceSmartIntegrationBinding) {
        super(holderDeviceSmartIntegrationBinding.getRoot());
        Intrinsics.checkNotNullParameter(holderDeviceSmartIntegrationBinding, "binding");
        this.binding = holderDeviceSmartIntegrationBinding;
    }

    public final HolderDeviceSmartIntegrationBinding getBinding() {
        return this.binding;
    }

    public final void update(int i, int i2, boolean z) {
        this.binding.deviceName.setText(z ? DeviceType.PROTECT : this.itemView.getContext().getText(i));
        this.binding.deviceImageView.setImageResource(i2);
    }
}
