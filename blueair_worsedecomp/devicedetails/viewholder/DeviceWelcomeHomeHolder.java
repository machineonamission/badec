package com.blueair.devicedetails.viewholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.blueair.core.model.Device;
import com.blueair.devicedetails.databinding.HolderWelcomeHomeModeBinding;
import com.blueair.devicedetails.util.DeviceWelcomeHomeProvider;
import com.blueair.viewcore.R;
import com.blueair.viewcore.view.SwitchCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u000fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001d"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceWelcomeHomeHolder;", "Lcom/blueair/devicedetails/viewholder/DeviceSettingHolder;", "binding", "Lcom/blueair/devicedetails/databinding/HolderWelcomeHomeModeBinding;", "welcomeHomeProvider", "Lcom/blueair/devicedetails/util/DeviceWelcomeHomeProvider;", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderWelcomeHomeModeBinding;Lcom/blueair/devicedetails/util/DeviceWelcomeHomeProvider;)V", "getBinding", "()Lcom/blueair/devicedetails/databinding/HolderWelcomeHomeModeBinding;", "clickView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getClickView", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "settingTitle", "Landroid/widget/TextView;", "getSettingTitle", "()Landroid/widget/TextView;", "settingSummary", "getSettingSummary", "settingSwitch", "Lcom/blueair/viewcore/view/SwitchCompat;", "getSettingSwitch", "()Lcom/blueair/viewcore/view/SwitchCompat;", "update", "", "device", "Lcom/blueair/core/model/Device;", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceWelcomeHomeHolder.kt */
public final class DeviceWelcomeHomeHolder extends DeviceSettingHolder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final HolderWelcomeHomeModeBinding binding;
    private final ConstraintLayout clickView;
    private final TextView settingSummary;
    private final SwitchCompat settingSwitch;
    private final TextView settingTitle;
    private final DeviceWelcomeHomeProvider welcomeHomeProvider;

    public final HolderWelcomeHomeModeBinding getBinding() {
        return this.binding;
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t¨\u0006\n"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceWelcomeHomeHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceWelcomeHomeHolder;", "parentView", "Landroid/view/ViewGroup;", "welcomeHomeProvider", "Lcom/blueair/devicedetails/util/DeviceWelcomeHomeProvider;", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceWelcomeHomeHolder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DeviceWelcomeHomeHolder newInstance(ViewGroup viewGroup, DeviceWelcomeHomeProvider deviceWelcomeHomeProvider) {
            Intrinsics.checkNotNullParameter(viewGroup, "parentView");
            HolderWelcomeHomeModeBinding inflate = HolderWelcomeHomeModeBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            return new DeviceWelcomeHomeHolder(inflate, deviceWelcomeHomeProvider);
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DeviceWelcomeHomeHolder(com.blueair.devicedetails.databinding.HolderWelcomeHomeModeBinding r10, com.blueair.devicedetails.util.DeviceWelcomeHomeProvider r11) {
        /*
            r9 = this;
            java.lang.String r0 = "binding"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            androidx.constraintlayout.widget.ConstraintLayout r0 = r10.getRoot()
            java.lang.String r1 = "getRoot(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            android.view.View r0 = (android.view.View) r0
            r9.<init>(r0)
            r9.binding = r10
            r9.welcomeHomeProvider = r11
            androidx.constraintlayout.widget.ConstraintLayout r11 = r10.clLocation
            java.lang.String r0 = "clLocation"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r0)
            r9.clickView = r11
            androidx.appcompat.widget.AppCompatTextView r11 = r10.settingTitle
            java.lang.String r1 = "settingTitle"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r1)
            android.widget.TextView r11 = (android.widget.TextView) r11
            r9.settingTitle = r11
            android.widget.TextView r11 = r10.settingSummary
            java.lang.String r1 = "settingSummary"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r1)
            r9.settingSummary = r11
            com.blueair.viewcore.view.SwitchCompat r11 = r10.settingSwitch
            java.lang.String r1 = "settingSwitch"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r1)
            r9.settingSwitch = r11
            com.blueair.viewcore.ViewUtils r2 = com.blueair.viewcore.ViewUtils.INSTANCE
            androidx.constraintlayout.widget.ConstraintLayout r11 = r10.clLocation
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r0)
            r3 = r11
            android.view.View r3 = (android.view.View) r3
            androidx.constraintlayout.widget.ConstraintLayout r10 = r10.getRoot()
            android.content.Context r10 = r10.getContext()
            int r11 = com.blueair.viewcore.R.string.button_role
            java.lang.String r5 = r10.getString(r11)
            r7 = 10
            r8 = 0
            r4 = 0
            r6 = 0
            com.blueair.viewcore.ViewUtils.setAccessibilityDelegate$default(r2, r3, r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.viewholder.DeviceWelcomeHomeHolder.<init>(com.blueair.devicedetails.databinding.HolderWelcomeHomeModeBinding, com.blueair.devicedetails.util.DeviceWelcomeHomeProvider):void");
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
        DeviceWelcomeHomeProvider deviceWelcomeHomeProvider = this.welcomeHomeProvider;
        if (deviceWelcomeHomeProvider != null) {
            Context context = this.binding.getRoot().getContext();
            int color = ContextCompat.getColor(context, R.color.colorPrimary);
            int color2 = ContextCompat.getColor(context, R.color.surface_dark_65);
            if (deviceWelcomeHomeProvider.isHomeLocationExist()) {
                this.binding.tvLocation.setText(deviceWelcomeHomeProvider.getHomeAddress());
                this.binding.tvLocation.setTextColor(color);
                AppCompatTextView appCompatTextView = this.binding.tvRadius;
                appCompatTextView.setText(ContextCompat.getString(context, R.string.welcome_home_radius) + TokenParser.SP + deviceWelcomeHomeProvider.fetchRadius());
                this.binding.ivEdit.setImageResource(R.drawable.ic_edit_flat);
                this.binding.tvRadius.setTextColor(color2);
                this.binding.tvRadius.setTextSize(12.0f);
            } else {
                this.binding.tvLocation.setText(R.string.no_location_assigned_value);
                this.binding.tvRadius.setText(R.string.add);
                this.binding.ivEdit.setImageResource(R.drawable.ic_add_flat);
                this.binding.tvLocation.setTextColor(color2);
                this.binding.tvRadius.setTextColor(color);
                this.binding.tvRadius.setTextSize(14.0f);
            }
            this.binding.settingSwitch.setChecked(deviceWelcomeHomeProvider.isEnabled());
        }
    }
}
