package com.blueair.devicedetails.viewholder;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceCombo2in120;
import com.blueair.core.model.HasWick;
import com.blueair.devicedetails.databinding.HolderDeviceSettingModeBinding;
import com.blueair.viewcore.R;
import com.blueair.viewcore.view.SwitchCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0017R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0019"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceWickDryEnabledHolder;", "Lcom/blueair/devicedetails/viewholder/DeviceSettingHolder;", "binding", "Lcom/blueair/devicedetails/databinding/HolderDeviceSettingModeBinding;", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceSettingModeBinding;)V", "getBinding", "()Lcom/blueair/devicedetails/databinding/HolderDeviceSettingModeBinding;", "settingTitle", "Landroid/widget/TextView;", "getSettingTitle", "()Landroid/widget/TextView;", "settingSummary", "getSettingSummary", "settingSwitch", "Lcom/blueair/viewcore/view/SwitchCompat;", "getSettingSwitch", "()Lcom/blueair/viewcore/view/SwitchCompat;", "update", "", "device", "Lcom/blueair/core/model/Device;", "deviceOffline", "", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceWickDryEnabledHolder.kt */
public final class DeviceWickDryEnabledHolder extends DeviceSettingHolder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final HolderDeviceSettingModeBinding binding;
    private final TextView settingSummary;
    private final SwitchCompat settingSwitch;
    private final TextView settingTitle;

    public final HolderDeviceSettingModeBinding getBinding() {
        return this.binding;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceWickDryEnabledHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceWickDryEnabledHolder;", "parentView", "Landroid/view/ViewGroup;", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceWickDryEnabledHolder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DeviceWickDryEnabledHolder newInstance(ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(viewGroup, "parentView");
            HolderDeviceSettingModeBinding inflate = HolderDeviceSettingModeBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            return new DeviceWickDryEnabledHolder(inflate);
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DeviceWickDryEnabledHolder(com.blueair.devicedetails.databinding.HolderDeviceSettingModeBinding r3) {
        /*
            r2 = this;
            java.lang.String r0 = "binding"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            androidx.constraintlayout.widget.ConstraintLayout r0 = r3.getRoot()
            java.lang.String r1 = "getRoot(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            android.view.View r0 = (android.view.View) r0
            r2.<init>(r0)
            r2.binding = r3
            android.widget.TextView r0 = r3.settingTitle
            java.lang.String r1 = "settingTitle"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r2.settingTitle = r0
            android.widget.TextView r0 = r3.settingSummary
            java.lang.String r1 = "settingSummary"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r2.settingSummary = r0
            com.blueair.viewcore.view.SwitchCompat r3 = r3.settingSwitch
            java.lang.String r0 = "settingSwitch"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r0)
            r2.settingSwitch = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.viewholder.DeviceWickDryEnabledHolder.<init>(com.blueair.devicedetails.databinding.HolderDeviceSettingModeBinding):void");
    }

    public TextView getSettingTitle() {
        return this.settingTitle;
    }

    public TextView getSettingSummary() {
        return this.settingSummary;
    }

    public SwitchCompat getSettingSwitch() {
        return this.settingSwitch;
    }

    public void update(Device device) {
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(device, "device");
        super.update(device);
        if (device instanceof DeviceCombo2in120) {
            i2 = R.string.label_auto_wick_drying;
            i = R.string.auto_wick_drying_desp;
        } else {
            i2 = R.string.label_wick_drying;
            i = R.string.wick_dry_description;
        }
        boolean z = false;
        getSettingTitle().setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.ic_dry_mode, 0, 0, 0);
        getSettingTitle().setText(this.itemView.getContext().getText(i2));
        getSettingSwitch().setContentDescription(this.itemView.getContext().getText(i2));
        SwitchCompat settingSwitch2 = getSettingSwitch();
        HasWick hasWick = device instanceof HasWick ? (HasWick) device : null;
        if (hasWick != null && hasWick.getWickdryEnabled()) {
            z = true;
        }
        settingSwitch2.setCheckedSilence(z);
        getSettingSummary().setText(this.itemView.getContext().getText(i));
    }

    public final void update(boolean z) {
        getSettingSwitch().setEnabled(!z);
    }
}
