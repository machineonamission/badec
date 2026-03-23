package com.blueair.devicedetails.viewholder;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blueair.core.model.Device;
import com.blueair.devicedetails.databinding.HolderDeviceRegularSettingBinding;
import com.blueair.viewcore.R;
import com.blueair.viewcore.view.SwitchCompat;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceErrorReportHolder;", "Lcom/blueair/devicedetails/viewholder/DeviceSettingHolder;", "binding", "Lcom/blueair/devicedetails/databinding/HolderDeviceRegularSettingBinding;", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceRegularSettingBinding;)V", "getBinding", "()Lcom/blueair/devicedetails/databinding/HolderDeviceRegularSettingBinding;", "clickView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getClickView", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "settingTitle", "Landroid/widget/TextView;", "getSettingTitle", "()Landroid/widget/TextView;", "settingSummary", "getSettingSummary", "settingSwitch", "Lcom/blueair/viewcore/view/SwitchCompat;", "getSettingSwitch", "()Lcom/blueair/viewcore/view/SwitchCompat;", "settingValue", "update", "", "device", "Lcom/blueair/core/model/Device;", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceErrorReportHolder.kt */
public final class DeviceErrorReportHolder extends DeviceSettingHolder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final HolderDeviceRegularSettingBinding binding;
    private final ConstraintLayout clickView;
    private final TextView settingSummary;
    private final SwitchCompat settingSwitch;
    private final TextView settingTitle;
    private final TextView settingValue;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DeviceErrorReportHolder(com.blueair.devicedetails.databinding.HolderDeviceRegularSettingBinding r3) {
        /*
            r2 = this;
            java.lang.String r0 = "binding"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            com.blueair.devicedetails.view.ButtonTileConstraintLayout r0 = r3.getRoot()
            java.lang.String r1 = "getRoot(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            android.view.View r0 = (android.view.View) r0
            r2.<init>(r0)
            r2.binding = r3
            com.blueair.devicedetails.view.ButtonTileConstraintLayout r0 = r3.regularSettingLayout
            java.lang.String r1 = "regularSettingLayout"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            androidx.constraintlayout.widget.ConstraintLayout r0 = (androidx.constraintlayout.widget.ConstraintLayout) r0
            r2.clickView = r0
            android.widget.TextView r0 = r3.settingTitle
            java.lang.String r1 = "settingTitle"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r2.settingTitle = r0
            android.widget.TextView r3 = r3.settingValue
            java.lang.String r0 = "settingValue"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r0)
            r2.settingValue = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.viewholder.DeviceErrorReportHolder.<init>(com.blueair.devicedetails.databinding.HolderDeviceRegularSettingBinding):void");
    }

    public final HolderDeviceRegularSettingBinding getBinding() {
        return this.binding;
    }

    public final ConstraintLayout getClickView() {
        return this.clickView;
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
        Intrinsics.checkNotNullParameter(device, "device");
        getSettingTitle().setText(this.itemView.getContext().getText(R.string.error_report));
        ViewExtensionsKt.show(this.settingValue, false);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceErrorReportHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceErrorReportHolder;", "parentView", "Landroid/view/ViewGroup;", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceErrorReportHolder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DeviceErrorReportHolder newInstance(ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(viewGroup, "parentView");
            HolderDeviceRegularSettingBinding inflate = HolderDeviceRegularSettingBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            return new DeviceErrorReportHolder(inflate);
        }
    }
}
