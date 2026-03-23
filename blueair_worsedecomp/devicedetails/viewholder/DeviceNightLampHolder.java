package com.blueair.devicedetails.viewholder;

import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import com.blueair.core.model.Device;
import com.blueair.core.model.HasNightLamp;
import com.blueair.devicedetails.databinding.HolderDeviceNightLampBinding;
import com.blueair.viewcore.R;
import com.blueair.viewcore.view.SwitchCompat;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\u0018\u0000 \u00192\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019BD\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\t¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0007H\u0016J\u000e\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\nR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0015R)\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceNightLampHolder;", "Lcom/blueair/devicedetails/viewholder/DeviceControlHolder;", "Lcom/blueair/devicedetails/databinding/HolderDeviceNightLampBinding;", "binding", "device", "Lcom/blueair/core/model/Device;", "isInSchedule", "", "onLampBrightnessSetListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "brightness", "", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceNightLampBinding;Lcom/blueair/core/model/Device;ZLkotlin/jvm/functions/Function1;)V", "getDevice", "()Lcom/blueair/core/model/Device;", "setDevice", "(Lcom/blueair/core/model/Device;)V", "()Z", "inTouch", "update", "forceOffline", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceNightLampHolder.kt */
public final class DeviceNightLampHolder extends DeviceControlHolder<HolderDeviceNightLampBinding> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private Device device;
    /* access modifiers changed from: private */
    public boolean inTouch;
    private final boolean isInSchedule;
    /* access modifiers changed from: private */
    public final Function1<Integer, Unit> onLampBrightnessSetListener;

    public final Device getDevice() {
        return this.device;
    }

    public final void setDevice(Device device2) {
        this.device = device2;
    }

    public final boolean isInSchedule() {
        return this.isInSchedule;
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JC\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2!\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\r¨\u0006\u0013"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceNightLampHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceNightLampHolder;", "parentView", "Landroid/view/ViewGroup;", "device", "Lcom/blueair/core/model/Device;", "isInSchedule", "", "onLampBrightnessSetListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "brightness", "", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceNightLampHolder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DeviceNightLampHolder newInstance(ViewGroup viewGroup, Device device, boolean z, Function1<? super Integer, Unit> function1) {
            Intrinsics.checkNotNullParameter(viewGroup, "parentView");
            Intrinsics.checkNotNullParameter(function1, "onLampBrightnessSetListener");
            HolderDeviceNightLampBinding inflate = HolderDeviceNightLampBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            return new DeviceNightLampHolder(inflate, device, z, function1);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeviceNightLampHolder(HolderDeviceNightLampBinding holderDeviceNightLampBinding, Device device2, boolean z, Function1<? super Integer, Unit> function1) {
        super(holderDeviceNightLampBinding);
        Intrinsics.checkNotNullParameter(holderDeviceNightLampBinding, "binding");
        Intrinsics.checkNotNullParameter(function1, "onLampBrightnessSetListener");
        this.device = device2;
        this.isInSchedule = z;
        this.onLampBrightnessSetListener = function1;
        holderDeviceNightLampBinding.clickView.setOnClickListener(new DeviceNightLampHolder$$ExternalSyntheticLambda0(holderDeviceNightLampBinding));
        holderDeviceNightLampBinding.expendSwitch.setOnCheckedChangeListener(new DeviceNightLampHolder$$ExternalSyntheticLambda1(holderDeviceNightLampBinding, this));
        holderDeviceNightLampBinding.seekbar.setOnSeekBarChangeListener(new DeviceNightLampHolder$1$3(this));
        holderDeviceNightLampBinding.expendSwitch.setChecked(false);
    }

    static final void lambda$3$lambda$0(HolderDeviceNightLampBinding holderDeviceNightLampBinding, View view) {
        holderDeviceNightLampBinding.expendSwitch.setChecked(!holderDeviceNightLampBinding.expendSwitch.isChecked());
    }

    static final void lambda$3$lambda$2(HolderDeviceNightLampBinding holderDeviceNightLampBinding, DeviceNightLampHolder deviceNightLampHolder, CompoundButton compoundButton, boolean z) {
        Device device2;
        Group group = holderDeviceNightLampBinding.expendedContent;
        Intrinsics.checkNotNullExpressionValue(group, "expendedContent");
        ViewExtensionsKt.show(group, !z);
        if (!deviceNightLampHolder.isInSchedule && !z && (device2 = deviceNightLampHolder.device) != null) {
            deviceNightLampHolder.update(device2, false);
        }
    }

    public void update(Device device2, boolean z) {
        Intrinsics.checkNotNullParameter(device2, "device");
        if (!this.inTouch) {
            this.device = device2;
            if (device2 instanceof HasNightLamp) {
                update(((HasNightLamp) device2).getNightLampSteplessBrightness());
            }
            if (z || !device2.isOnline()) {
                HolderDeviceNightLampBinding holderDeviceNightLampBinding = (HolderDeviceNightLampBinding) getBinding();
                holderDeviceNightLampBinding.clickView.setEnabled(false);
                holderDeviceNightLampBinding.expendSwitch.setEnabled(false);
                holderDeviceNightLampBinding.expendSwitch.setChecked(true);
                SwitchCompat switchCompat = holderDeviceNightLampBinding.expendSwitch;
                Intrinsics.checkNotNullExpressionValue(switchCompat, "expendSwitch");
                ViewExtensionsKt.show(switchCompat, false);
                holderDeviceNightLampBinding.contentContainer.setEnabled(false);
                holderDeviceNightLampBinding.leadingIcon.setImageTintList(ColorStateList.valueOf(getColor(R.color.surface_dark_45)));
                holderDeviceNightLampBinding.title.setTextColor(getColor(R.color.surface_dark_55));
                holderDeviceNightLampBinding.progressText.setText("");
                return;
            }
            HolderDeviceNightLampBinding holderDeviceNightLampBinding2 = (HolderDeviceNightLampBinding) getBinding();
            holderDeviceNightLampBinding2.clickView.setEnabled(true);
            holderDeviceNightLampBinding2.expendSwitch.setEnabled(true);
            holderDeviceNightLampBinding2.contentContainer.setEnabled(true);
            holderDeviceNightLampBinding2.leadingIcon.setImageTintList((ColorStateList) null);
            holderDeviceNightLampBinding2.title.setTextColor(getColor(R.color.colorPrimaryText));
            SwitchCompat switchCompat2 = holderDeviceNightLampBinding2.expendSwitch;
            Intrinsics.checkNotNullExpressionValue(switchCompat2, "expendSwitch");
            ViewExtensionsKt.show(switchCompat2, true);
        }
    }

    public final void update(int i) {
        ((HolderDeviceNightLampBinding) getBinding()).seekbar.setProgress(i);
        if (i <= 0) {
            ((HolderDeviceNightLampBinding) getBinding()).progressText.setText(R.string.light_gear_off);
            return;
        }
        TextView textView = ((HolderDeviceNightLampBinding) getBinding()).progressText;
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append('%');
        textView.setText(sb.toString());
    }
}
