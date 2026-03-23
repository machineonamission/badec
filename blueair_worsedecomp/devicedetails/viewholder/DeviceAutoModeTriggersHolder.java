package com.blueair.devicedetails.viewholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewGroupKt;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.FilterTrigger;
import com.blueair.core.model.HasFanSpeed;
import com.blueair.core.model.HasG4NightMode;
import com.blueair.core.model.HasStandBy;
import com.blueair.devicedetails.databinding.HolderSettingAutoModeTriggersBinding;
import com.blueair.viewcore.R;
import com.blueair.viewcore.view.SwitchCompat;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 #2\u00020\u0001:\u0001#B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\"\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u001fJ\u0010\u0010!\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\"\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0014\u0010\u0010\u001a\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceAutoModeTriggersHolder;", "Lcom/blueair/devicedetails/viewholder/DeviceSettingHolder;", "binding", "Lcom/blueair/devicedetails/databinding/HolderSettingAutoModeTriggersBinding;", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderSettingAutoModeTriggersBinding;)V", "getBinding", "()Lcom/blueair/devicedetails/databinding/HolderSettingAutoModeTriggersBinding;", "nightTitleView", "Landroid/widget/TextView;", "nightGroup", "Landroid/widget/RadioGroup;", "getNightGroup", "()Landroid/widget/RadioGroup;", "autoGroup", "getAutoGroup", "settingTitle", "getSettingTitle", "()Landroid/widget/TextView;", "settingSummary", "getSettingSummary", "settingSwitch", "Lcom/blueair/viewcore/view/SwitchCompat;", "getSettingSwitch", "()Lcom/blueair/viewcore/view/SwitchCompat;", "autoTitleView", "update", "", "device", "Lcom/blueair/core/model/Device;", "overrideAutoModeTrigger", "Lcom/blueair/core/model/FilterTrigger;", "overrideNighModeTrigger", "setOnline", "setOffline", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceAutoModeTriggersHolder.kt */
public final class DeviceAutoModeTriggersHolder extends DeviceSettingHolder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final RadioGroup autoGroup;
    private final TextView autoTitleView;
    private final HolderSettingAutoModeTriggersBinding binding;
    private final RadioGroup nightGroup;
    private final TextView nightTitleView;
    private final TextView settingSummary;
    private final SwitchCompat settingSwitch;
    private final TextView settingTitle;

    public void update(Device device) {
        Intrinsics.checkNotNullParameter(device, "device");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DeviceAutoModeTriggersHolder(com.blueair.devicedetails.databinding.HolderSettingAutoModeTriggersBinding r3) {
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
            android.widget.TextView r0 = r3.nightTitle
            java.lang.String r1 = "nightTitle"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r2.nightTitleView = r0
            android.widget.RadioGroup r0 = r3.buttonGroupNightMode
            java.lang.String r1 = "buttonGroupNightMode"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r2.nightGroup = r0
            android.widget.RadioGroup r0 = r3.buttonGroupAutoMode
            java.lang.String r1 = "buttonGroupAutoMode"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r2.autoGroup = r0
            android.widget.TextView r0 = r3.settingTitle
            java.lang.String r1 = "settingTitle"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r2.settingTitle = r0
            android.widget.TextView r0 = r3.settingSummary
            java.lang.String r1 = "settingSummary"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r2.settingSummary = r0
            android.widget.TextView r3 = r3.autoTitle
            java.lang.String r0 = "autoTitle"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r0)
            r2.autoTitleView = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.viewholder.DeviceAutoModeTriggersHolder.<init>(com.blueair.devicedetails.databinding.HolderSettingAutoModeTriggersBinding):void");
    }

    public final HolderSettingAutoModeTriggersBinding getBinding() {
        return this.binding;
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J \u0010\b\u001a\u00020\t*\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010\r\u001a\u00020\fH\u0002¨\u0006\u000e"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceAutoModeTriggersHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceAutoModeTriggersHolder;", "parentView", "Landroid/view/ViewGroup;", "setModeButtonContentDescription", "", "Landroid/widget/RadioButton;", "modeTextResId", "", "triggerTextResId", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceAutoModeTriggersHolder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DeviceAutoModeTriggersHolder newInstance(ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(viewGroup, "parentView");
            HolderSettingAutoModeTriggersBinding inflate = HolderSettingAutoModeTriggersBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            Companion companion = DeviceAutoModeTriggersHolder.Companion;
            RadioButton radioButton = inflate.autoModePmButton;
            Intrinsics.checkNotNullExpressionValue(radioButton, "autoModePmButton");
            companion.setModeButtonContentDescription(radioButton, R.string.auto_mode, R.string.pm_button_text);
            Companion companion2 = DeviceAutoModeTriggersHolder.Companion;
            RadioButton radioButton2 = inflate.autoModePmTvocButton;
            Intrinsics.checkNotNullExpressionValue(radioButton2, "autoModePmTvocButton");
            companion2.setModeButtonContentDescription(radioButton2, R.string.auto_mode, R.string.pm_tvoc_button_text);
            Companion companion3 = DeviceAutoModeTriggersHolder.Companion;
            RadioButton radioButton3 = inflate.nightModePmButton;
            Intrinsics.checkNotNullExpressionValue(radioButton3, "nightModePmButton");
            companion3.setModeButtonContentDescription(radioButton3, R.string.night, R.string.pm_button_text);
            Companion companion4 = DeviceAutoModeTriggersHolder.Companion;
            RadioButton radioButton4 = inflate.nightModePmTvocButton;
            Intrinsics.checkNotNullExpressionValue(radioButton4, "nightModePmTvocButton");
            companion4.setModeButtonContentDescription(radioButton4, R.string.night, R.string.pm_tvoc_button_text);
            Intrinsics.checkNotNullExpressionValue(inflate, "apply(...)");
            return new DeviceAutoModeTriggersHolder(inflate);
        }

        private final void setModeButtonContentDescription(RadioButton radioButton, int i, int i2) {
            radioButton.setContentDescription(radioButton.getResources().getString(R.string.mode_button_content_description_pattern, new Object[]{radioButton.getResources().getString(i), radioButton.getResources().getString(i2)}));
        }
    }

    public final RadioGroup getNightGroup() {
        return this.nightGroup;
    }

    public final RadioGroup getAutoGroup() {
        return this.autoGroup;
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

    public final void update(Device device, FilterTrigger filterTrigger, FilterTrigger filterTrigger2) {
        Context context;
        int i;
        Intrinsics.checkNotNullParameter(device, "device");
        super.update(device);
        if ((device instanceof HasStandBy) && ((HasStandBy) device).isStandByOn()) {
            setOffline(device);
        }
        if (device instanceof HasFanSpeed) {
            Timber.Forest forest = Timber.Forest;
            StringBuilder sb = new StringBuilder("update : filter type = ");
            HasFanSpeed hasFanSpeed = (HasFanSpeed) device;
            sb.append(hasFanSpeed.getFilter().getName());
            sb.append(" & trigger = ");
            sb.append(filterTrigger == null ? hasFanSpeed.getTrigger() : filterTrigger);
            forest.d(sb.toString(), new Object[0]);
            if (filterTrigger == null) {
                filterTrigger = hasFanSpeed.getTrigger();
            }
            if (Intrinsics.areEqual((Object) filterTrigger, (Object) FilterTrigger.Particles.INSTANCE)) {
                this.autoGroup.check(com.blueair.devicedetails.R.id.auto_mode_pm_button);
            } else if (Intrinsics.areEqual((Object) filterTrigger, (Object) FilterTrigger.ParticlesAndGases.INSTANCE)) {
                this.autoGroup.check(com.blueair.devicedetails.R.id.auto_mode_pm_tvoc_button);
            } else {
                this.autoGroup.clearCheck();
            }
            if (device instanceof HasG4NightMode) {
                Timber.Forest forest2 = Timber.Forest;
                StringBuilder sb2 = new StringBuilder("update : g4 night mode trigger = ");
                sb2.append(filterTrigger2 == null ? ((HasG4NightMode) device).getG4NightModeTrigger() : filterTrigger2);
                forest2.d(sb2.toString(), new Object[0]);
                if (filterTrigger2 == null) {
                    filterTrigger2 = ((HasG4NightMode) device).getG4NightModeTrigger();
                }
                if (Intrinsics.areEqual((Object) filterTrigger2, (Object) FilterTrigger.Particles.INSTANCE)) {
                    this.nightGroup.check(com.blueair.devicedetails.R.id.night_mode_pm_button);
                } else if (Intrinsics.areEqual((Object) filterTrigger2, (Object) FilterTrigger.ParticlesAndGases.INSTANCE)) {
                    this.nightGroup.check(com.blueair.devicedetails.R.id.night_mode_pm_tvoc_button);
                } else {
                    this.nightGroup.clearCheck();
                }
            }
        }
        TextView settingTitle2 = getSettingTitle();
        if (DeviceKt.isG4orB4orNB(device)) {
            context = this.itemView.getContext();
            i = R.string.triggers_for_auto_night_mode;
        } else {
            context = this.itemView.getContext();
            i = R.string.triggers_for_auto_mode;
        }
        settingTitle2.setText(context.getText(i));
        ViewExtensionsKt.show(this.nightTitleView, DeviceKt.isG4orB4orNB(device));
        ViewExtensionsKt.show(this.nightGroup, DeviceKt.isG4orB4orNB(device));
    }

    public void setOnline(Device device) {
        Intrinsics.checkNotNullParameter(device, "device");
        super.setOnline(device);
        this.autoTitleView.setTextColor(ContextCompat.getColor(this.itemView.getContext(), R.color.colorPrimary));
        this.nightTitleView.setTextColor(ContextCompat.getColor(this.itemView.getContext(), R.color.colorPrimary));
        this.nightGroup.setActivated(false);
        for (View enabled : ViewGroupKt.getChildren(this.nightGroup)) {
            enabled.setEnabled(true);
        }
        this.autoGroup.setActivated(false);
        for (View enabled2 : ViewGroupKt.getChildren(this.autoGroup)) {
            enabled2.setEnabled(true);
        }
    }

    public void setOffline(Device device) {
        Intrinsics.checkNotNullParameter(device, "device");
        super.setOffline(device);
        this.autoTitleView.setTextColor(ContextCompat.getColor(this.itemView.getContext(), R.color.smokegray));
        this.nightTitleView.setTextColor(ContextCompat.getColor(this.itemView.getContext(), R.color.smokegray));
        this.nightGroup.setActivated(true);
        for (View enabled : ViewGroupKt.getChildren(this.nightGroup)) {
            enabled.setEnabled(false);
        }
        this.autoGroup.setActivated(true);
        for (View enabled2 : ViewGroupKt.getChildren(this.autoGroup)) {
            enabled2.setEnabled(false);
        }
    }
}
