package com.blueair.devicedetails.viewholder;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.devicedetails.databinding.HolderDeviceSettingInfoBinding;
import com.blueair.devicedetails.util.DeviceInfo;
import com.blueair.viewcore.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\r"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceSettingInfoHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/blueair/devicedetails/databinding/HolderDeviceSettingInfoBinding;", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceSettingInfoBinding;)V", "getBinding", "()Lcom/blueair/devicedetails/databinding/HolderDeviceSettingInfoBinding;", "update", "", "info", "Lcom/blueair/devicedetails/util/DeviceInfo;", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceSettingInfoHolder.kt */
public final class DeviceSettingInfoHolder extends RecyclerView.ViewHolder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final HolderDeviceSettingInfoBinding binding;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeviceSettingInfoHolder(HolderDeviceSettingInfoBinding holderDeviceSettingInfoBinding) {
        super(holderDeviceSettingInfoBinding.getRoot());
        Intrinsics.checkNotNullParameter(holderDeviceSettingInfoBinding, "binding");
        this.binding = holderDeviceSettingInfoBinding;
    }

    public final HolderDeviceSettingInfoBinding getBinding() {
        return this.binding;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceSettingInfoHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceSettingInfoHolder;", "parentView", "Landroid/view/ViewGroup;", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceSettingInfoHolder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DeviceSettingInfoHolder newInstance(ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(viewGroup, "parentView");
            HolderDeviceSettingInfoBinding inflate = HolderDeviceSettingInfoBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            return new DeviceSettingInfoHolder(inflate);
        }
    }

    public final void update(DeviceInfo deviceInfo) {
        Intrinsics.checkNotNullParameter(deviceInfo, "info");
        this.binding.infoTitle.setText(this.itemView.getContext().getText(deviceInfo.getName()));
        if (deviceInfo.getValue().length() > 0) {
            this.binding.infoView.setText(deviceInfo.getValue());
        } else {
            this.binding.infoView.setText(R.string.no_setting_value);
        }
    }
}
