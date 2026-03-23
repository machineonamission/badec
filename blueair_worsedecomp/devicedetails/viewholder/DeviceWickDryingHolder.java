package com.blueair.devicedetails.viewholder;

import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.Group;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.HasHumMainMode;
import com.blueair.core.model.HasWick;
import com.blueair.core.model.HasWickDryDuration;
import com.blueair.core.model.MainMode;
import com.blueair.core.model.WickDryingGear;
import com.blueair.devicedetails.databinding.HolderDeviceWickDryingBinding;
import com.blueair.viewcore.R;
import com.blueair.viewcore.view.SwitchCompat;
import com.google.android.material.progressindicator.LinearProgressIndicator;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0014B9\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\b0\n¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0005H\u0016J\u0010\u0010\u0013\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000eR\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\b0\nX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceWickDryingHolder;", "Lcom/blueair/devicedetails/viewholder/DeviceControlHolder;", "Lcom/blueair/devicedetails/databinding/HolderDeviceWickDryingBinding;", "binding", "isInSchedule", "", "onOpenInfoListener", "Lkotlin/Function0;", "", "onChangeListener", "Lkotlin/Function1;", "Lcom/blueair/core/model/WickDryingGear;", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceWickDryingBinding;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "()Z", "device", "Lcom/blueair/core/model/Device;", "update", "forceOffline", "updateProgress", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceWickDryingHolder.kt */
public final class DeviceWickDryingHolder extends DeviceControlHolder<HolderDeviceWickDryingBinding> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private Device device;
    private final boolean isInSchedule;
    private final Function1<WickDryingGear, Unit> onChangeListener;
    private final Function0<Unit> onOpenInfoListener;

    public final boolean isInSchedule() {
        return this.isInSchedule;
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J8\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\f0\u000e¨\u0006\u0010"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceWickDryingHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceWickDryingHolder;", "parentView", "Landroid/view/ViewGroup;", "isInSchedule", "", "onOpenInfoListener", "Lkotlin/Function0;", "", "onChangeListener", "Lkotlin/Function1;", "Lcom/blueair/core/model/WickDryingGear;", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceWickDryingHolder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DeviceWickDryingHolder newInstance(ViewGroup viewGroup, boolean z, Function0<Unit> function0, Function1<? super WickDryingGear, Unit> function1) {
            Intrinsics.checkNotNullParameter(viewGroup, "parentView");
            Intrinsics.checkNotNullParameter(function0, "onOpenInfoListener");
            Intrinsics.checkNotNullParameter(function1, "onChangeListener");
            HolderDeviceWickDryingBinding inflate = HolderDeviceWickDryingBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            return new DeviceWickDryingHolder(inflate, z, function0, function1);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeviceWickDryingHolder(HolderDeviceWickDryingBinding holderDeviceWickDryingBinding, boolean z, Function0<Unit> function0, Function1<? super WickDryingGear, Unit> function1) {
        super(holderDeviceWickDryingBinding);
        Intrinsics.checkNotNullParameter(holderDeviceWickDryingBinding, "binding");
        Intrinsics.checkNotNullParameter(function0, "onOpenInfoListener");
        Intrinsics.checkNotNullParameter(function1, "onChangeListener");
        this.isInSchedule = z;
        this.onOpenInfoListener = function0;
        this.onChangeListener = function1;
        holderDeviceWickDryingBinding.expendSwitch.setOnCheckedChangeListener(new DeviceWickDryingHolder$$ExternalSyntheticLambda0(holderDeviceWickDryingBinding, this));
        holderDeviceWickDryingBinding.ivInfo.setOnClickListener(new DeviceWickDryingHolder$$ExternalSyntheticLambda1(this));
        holderDeviceWickDryingBinding.btnLow.setOnClickListener(new DeviceWickDryingHolder$$ExternalSyntheticLambda2(holderDeviceWickDryingBinding, this));
        holderDeviceWickDryingBinding.btnHigh.setOnClickListener(new DeviceWickDryingHolder$$ExternalSyntheticLambda3(holderDeviceWickDryingBinding, this));
    }

    static final void lambda$7$lambda$1(HolderDeviceWickDryingBinding holderDeviceWickDryingBinding, DeviceWickDryingHolder deviceWickDryingHolder, CompoundButton compoundButton, boolean z) {
        Group group = holderDeviceWickDryingBinding.expendedContent;
        Intrinsics.checkNotNullExpressionValue(group, "expendedContent");
        ViewExtensionsKt.show(group, z);
        if (!deviceWickDryingHolder.isInSchedule) {
            Device device2 = deviceWickDryingHolder.device;
            HasWickDryDuration hasWickDryDuration = device2 instanceof HasWickDryDuration ? (HasWickDryDuration) device2 : null;
            if (hasWickDryDuration == null) {
                return;
            }
            if (z) {
                WickDryingGear fromDuration = WickDryingGear.Companion.fromDuration(hasWickDryDuration.getWickdryDuration());
                if (fromDuration == WickDryingGear.OFF) {
                    fromDuration = WickDryingGear.HIGH;
                }
                deviceWickDryingHolder.onChangeListener.invoke(fromDuration);
                return;
            }
            deviceWickDryingHolder.onChangeListener.invoke(WickDryingGear.OFF);
        }
    }

    static final void lambda$7$lambda$2(DeviceWickDryingHolder deviceWickDryingHolder, View view) {
        deviceWickDryingHolder.onOpenInfoListener.invoke();
    }

    static final void lambda$7$lambda$4(HolderDeviceWickDryingBinding holderDeviceWickDryingBinding, DeviceWickDryingHolder deviceWickDryingHolder, View view) {
        if (!holderDeviceWickDryingBinding.btnLow.isChecked()) {
            Device device2 = deviceWickDryingHolder.device;
            if ((device2 instanceof HasWickDryDuration ? (HasWickDryDuration) device2 : null) != null) {
                deviceWickDryingHolder.onChangeListener.invoke(WickDryingGear.LOW);
            }
        }
    }

    static final void lambda$7$lambda$6(HolderDeviceWickDryingBinding holderDeviceWickDryingBinding, DeviceWickDryingHolder deviceWickDryingHolder, View view) {
        if (!holderDeviceWickDryingBinding.btnHigh.isChecked()) {
            Device device2 = deviceWickDryingHolder.device;
            if ((device2 instanceof HasWickDryDuration ? (HasWickDryDuration) device2 : null) != null) {
                deviceWickDryingHolder.onChangeListener.invoke(WickDryingGear.HIGH);
            }
        }
    }

    public void update(Device device2, boolean z) {
        Intrinsics.checkNotNullParameter(device2, "device");
        this.device = device2;
        boolean z2 = false;
        if (z || !device2.isOnline() || !DeviceKt.isSafetySwitchOn(device2)) {
            HolderDeviceWickDryingBinding holderDeviceWickDryingBinding = (HolderDeviceWickDryingBinding) getBinding();
            holderDeviceWickDryingBinding.expendSwitch.setChecked(false);
            holderDeviceWickDryingBinding.expendSwitch.setEnabled(false);
            SwitchCompat switchCompat = holderDeviceWickDryingBinding.expendSwitch;
            Intrinsics.checkNotNullExpressionValue(switchCompat, "expendSwitch");
            ViewExtensionsKt.show(switchCompat, true);
            holderDeviceWickDryingBinding.contentContainer.setEnabled(false);
            holderDeviceWickDryingBinding.leadingIcon.setImageTintList(ColorStateList.valueOf(getColor(R.color.surface_dark_45)));
            holderDeviceWickDryingBinding.title.setTextColor(getColor(R.color.surface_dark_55));
            return;
        }
        HolderDeviceWickDryingBinding holderDeviceWickDryingBinding2 = (HolderDeviceWickDryingBinding) getBinding();
        holderDeviceWickDryingBinding2.title.setTextColor(getColor(R.color.colorPrimaryText));
        holderDeviceWickDryingBinding2.contentContainer.setEnabled(true);
        holderDeviceWickDryingBinding2.leadingIcon.setImageTintList((ColorStateList) null);
        holderDeviceWickDryingBinding2.btnHigh.setChecked(true);
        updateProgress(device2);
        SwitchCompat switchCompat2 = holderDeviceWickDryingBinding2.expendSwitch;
        if (DeviceKt.isStandByOn(device2) || holderDeviceWickDryingBinding2.expendSwitch.isChecked() || !(device2 instanceof HasHumMainMode) || !((HasHumMainMode) device2).isInMainMode(MainMode.AirPurify)) {
            z2 = true;
        }
        switchCompat2.setEnabled(z2);
        SwitchCompat switchCompat3 = holderDeviceWickDryingBinding2.expendSwitch;
        Intrinsics.checkNotNullExpressionValue(switchCompat3, "expendSwitch");
        ViewExtensionsKt.show(switchCompat3, true);
    }

    private final void updateProgress(Device device2) {
        int i;
        if ((device2 instanceof HasWickDryDuration) && (device2 instanceof HasWick)) {
            HasWick hasWick = (HasWick) device2;
            ((HolderDeviceWickDryingBinding) getBinding()).expendSwitch.setCheckedSilence(hasWick.getWickdryOn());
            Group group = ((HolderDeviceWickDryingBinding) getBinding()).expendedContent;
            Intrinsics.checkNotNullExpressionValue(group, "expendedContent");
            ViewExtensionsKt.show(group, ((HolderDeviceWickDryingBinding) getBinding()).expendSwitch.isChecked());
            int wickdryDuration = ((HasWickDryDuration) device2).getWickdryDuration();
            int wickDryLeftSeconds = hasWick.getWickDryLeftSeconds();
            LinearProgressIndicator linearProgressIndicator = ((HolderDeviceWickDryingBinding) getBinding()).progressIndicator;
            if (wickdryDuration == 0) {
                i = 0;
            } else {
                i = RangesKt.coerceIn((wickDryLeftSeconds * 100) / wickdryDuration, 0, 100);
            }
            linearProgressIndicator.setProgress(i);
            boolean z = WickDryingGear.Companion.fromDuration(wickdryDuration) == WickDryingGear.LOW;
            ((HolderDeviceWickDryingBinding) getBinding()).btnLow.setChecked(z);
            ((HolderDeviceWickDryingBinding) getBinding()).btnHigh.setChecked(!z);
            ((HolderDeviceWickDryingBinding) getBinding()).tvDuration.setText(z ? R.string.time_duration_low : R.string.time_duration_high);
            int ceil = (int) Math.ceil(((double) wickDryLeftSeconds) / 60.0d);
            AppCompatTextView appCompatTextView = ((HolderDeviceWickDryingBinding) getBinding()).tvLeft;
            appCompatTextView.setText(appCompatTextView.getContext().getString(ceil > 1 ? R.string.disinfection_left_time : R.string.disinfection_left_time_1min, new Object[]{String.valueOf(ceil)}));
        }
    }
}
