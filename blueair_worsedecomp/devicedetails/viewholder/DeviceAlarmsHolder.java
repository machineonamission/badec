package com.blueair.devicedetails.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceAlarm;
import com.blueair.core.model.HasAlarm;
import com.blueair.devicedetails.databinding.HolderDeviceAlarmsBinding;
import com.blueair.viewcore.R;
import java.util.Arrays;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000eB\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceAlarmsHolder;", "Lcom/blueair/devicedetails/viewholder/DeviceControlHolder;", "Lcom/blueair/devicedetails/databinding/HolderDeviceAlarmsBinding;", "binding", "onOpenAlarmsListener", "Lkotlin/Function0;", "", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceAlarmsBinding;Lkotlin/jvm/functions/Function0;)V", "update", "device", "Lcom/blueair/core/model/Device;", "forceOffline", "", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceAlarmsHolder.kt */
public final class DeviceAlarmsHolder extends DeviceControlHolder<HolderDeviceAlarmsBinding> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final Function0<Unit> onOpenAlarmsListener;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeviceAlarmsHolder(HolderDeviceAlarmsBinding holderDeviceAlarmsBinding, Function0<Unit> function0) {
        super(holderDeviceAlarmsBinding);
        Intrinsics.checkNotNullParameter(holderDeviceAlarmsBinding, "binding");
        Intrinsics.checkNotNullParameter(function0, "onOpenAlarmsListener");
        this.onOpenAlarmsListener = function0;
        holderDeviceAlarmsBinding.contentContainer.setOnClickListener(new DeviceAlarmsHolder$$ExternalSyntheticLambda0(this));
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¨\u0006\u000b"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceAlarmsHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceAlarmsHolder;", "parentView", "Landroid/view/ViewGroup;", "onOpenAlarmsListener", "Lkotlin/Function0;", "", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceAlarmsHolder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DeviceAlarmsHolder newInstance(ViewGroup viewGroup, Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(viewGroup, "parentView");
            Intrinsics.checkNotNullParameter(function0, "onOpenAlarmsListener");
            HolderDeviceAlarmsBinding inflate = HolderDeviceAlarmsBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            return new DeviceAlarmsHolder(inflate, function0);
        }
    }

    /* access modifiers changed from: private */
    public static final void _init_$lambda$0(DeviceAlarmsHolder deviceAlarmsHolder, View view) {
        deviceAlarmsHolder.onOpenAlarmsListener.invoke();
    }

    public void update(Device device, boolean z) {
        int i;
        Intrinsics.checkNotNullParameter(device, "device");
        HolderDeviceAlarmsBinding holderDeviceAlarmsBinding = (HolderDeviceAlarmsBinding) getBinding();
        if (device instanceof HasAlarm) {
            Iterable<DeviceAlarm> alarms = ((HasAlarm) device).getAlarms();
            if (!(alarms instanceof Collection) || !((Collection) alarms).isEmpty()) {
                i = 0;
                for (DeviceAlarm deviceAlarm : alarms) {
                    if (deviceAlarm != null && deviceAlarm.getEnabled() && (i = i + 1) < 0) {
                        CollectionsKt.throwCountOverflow();
                    }
                }
            } else {
                i = 0;
            }
            TextView textView = holderDeviceAlarmsBinding.tvAlarmValue;
            String format = String.format(getString(R.string.alarm_active), Arrays.copyOf(new Object[]{Integer.valueOf(i)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            textView.setText(format);
            holderDeviceAlarmsBinding.ivAlarm.setImageResource(i > 0 ? R.drawable.ic_alarm_active : R.drawable.ic_alarm_off);
        }
        if (z || !device.isOnline()) {
            holderDeviceAlarmsBinding.contentContainer.setEnabled(false);
            holderDeviceAlarmsBinding.contentContainer.setBackgroundResource(R.drawable.rounded_rectangle_white_r1000_black5_stroke1_disabled_white_bg);
            holderDeviceAlarmsBinding.ivAlarm.setImageResource(R.drawable.ic_alarm_disabled);
            holderDeviceAlarmsBinding.tvAlarmLabel.setTextColor(getColor(R.color.surface_dark_55));
            return;
        }
        holderDeviceAlarmsBinding.contentContainer.setEnabled(true);
        holderDeviceAlarmsBinding.contentContainer.setBackgroundResource(R.drawable.rounded_rectangle_white_r1000_black5_stroke1);
        holderDeviceAlarmsBinding.tvAlarmLabel.setTextColor(getColor(R.color.colorPrimaryText));
    }
}
