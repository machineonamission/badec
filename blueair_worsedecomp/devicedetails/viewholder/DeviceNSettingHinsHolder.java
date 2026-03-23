package com.blueair.devicedetails.viewholder;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.DeviceNewClassic;
import com.blueair.devicedetails.databinding.HolderDeviceNSettingsHinsBinding;
import com.blueair.viewcore.R;
import com.blueair.viewcore.view.SwitchCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\r"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceNSettingHinsHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/blueair/devicedetails/databinding/HolderDeviceNSettingsHinsBinding;", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceNSettingsHinsBinding;)V", "getBinding", "()Lcom/blueair/devicedetails/databinding/HolderDeviceNSettingsHinsBinding;", "update", "", "device", "Lcom/blueair/core/model/DeviceNewClassic;", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceNSettingHinsHolder.kt */
public final class DeviceNSettingHinsHolder extends RecyclerView.ViewHolder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final HolderDeviceNSettingsHinsBinding binding;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeviceNSettingHinsHolder(HolderDeviceNSettingsHinsBinding holderDeviceNSettingsHinsBinding) {
        super(holderDeviceNSettingsHinsBinding.getRoot());
        Intrinsics.checkNotNullParameter(holderDeviceNSettingsHinsBinding, "binding");
        this.binding = holderDeviceNSettingsHinsBinding;
    }

    public final HolderDeviceNSettingsHinsBinding getBinding() {
        return this.binding;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceNSettingHinsHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceNSettingHinsHolder;", "parentView", "Landroid/view/ViewGroup;", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceNSettingHinsHolder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DeviceNSettingHinsHolder newInstance(ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(viewGroup, "parentView");
            HolderDeviceNSettingsHinsBinding inflate = HolderDeviceNSettingsHinsBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            return new DeviceNSettingHinsHolder(inflate);
        }
    }

    public final void update(DeviceNewClassic deviceNewClassic) {
        Intrinsics.checkNotNullParameter(deviceNewClassic, "device");
        HolderDeviceNSettingsHinsBinding holderDeviceNSettingsHinsBinding = this.binding;
        holderDeviceNSettingsHinsBinding.daySwitchBtn.setCheckedSilence(deviceNewClassic.isHinsModeOn());
        holderDeviceNSettingsHinsBinding.nightSwitchBtn.setCheckedSilence(deviceNewClassic.isHinsNightModeOn());
        if (deviceNewClassic.isStandByOn()) {
            SwitchCompat switchCompat = holderDeviceNSettingsHinsBinding.daySwitchBtn;
            Intrinsics.checkNotNullExpressionValue(switchCompat, "daySwitchBtn");
            update$lambda$0$setSwitchStyle(this, switchCompat, false);
            SwitchCompat switchCompat2 = holderDeviceNSettingsHinsBinding.nightSwitchBtn;
            Intrinsics.checkNotNullExpressionValue(switchCompat2, "nightSwitchBtn");
            update$lambda$0$setSwitchStyle(this, switchCompat2, false);
            return;
        }
        SwitchCompat switchCompat3 = holderDeviceNSettingsHinsBinding.daySwitchBtn;
        Intrinsics.checkNotNullExpressionValue(switchCompat3, "daySwitchBtn");
        update$lambda$0$setSwitchStyle(this, switchCompat3, !deviceNewClassic.isG4NightModeOn());
        SwitchCompat switchCompat4 = holderDeviceNSettingsHinsBinding.nightSwitchBtn;
        Intrinsics.checkNotNullExpressionValue(switchCompat4, "nightSwitchBtn");
        update$lambda$0$setSwitchStyle(this, switchCompat4, deviceNewClassic.isG4NightModeOn());
    }

    private static final void update$lambda$0$setSwitchStyle(DeviceNSettingHinsHolder deviceNSettingHinsHolder, SwitchCompat switchCompat, boolean z) {
        switchCompat.setTextColor(ContextCompat.getColor(deviceNSettingHinsHolder.itemView.getContext(), z ? R.color.colorPrimaryText : R.color.marineblue_20));
        switchCompat.setEnabled(z);
    }
}
