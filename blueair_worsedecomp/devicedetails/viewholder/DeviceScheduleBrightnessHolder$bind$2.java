package com.blueair.devicedetails.viewholder;

import android.widget.SeekBar;
import android.widget.TextView;
import com.blueair.core.model.Brightness;
import com.blueair.core.model.BrightnessKt;
import com.blueair.core.model.Device;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u000b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\f"}, d2 = {"com/blueair/devicedetails/viewholder/DeviceScheduleBrightnessHolder$bind$2", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "onProgressChanged", "", "seekBar", "Landroid/widget/SeekBar;", "progress", "", "fromTouch", "", "onStartTrackingTouch", "onStopTrackingTouch", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceScheduleBrightnessHolder.kt */
public final class DeviceScheduleBrightnessHolder$bind$2 implements SeekBar.OnSeekBarChangeListener {
    final /* synthetic */ Device $device;
    final /* synthetic */ DeviceScheduleBrightnessHolder this$0;

    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    DeviceScheduleBrightnessHolder$bind$2(DeviceScheduleBrightnessHolder deviceScheduleBrightnessHolder, Device device) {
        this.this$0 = deviceScheduleBrightnessHolder;
        this.$device = device;
    }

    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        this.this$0.updateThumb(i);
        if (BrightnessKt.hasBrightnessInPercent(this.$device)) {
            TextView access$getBrightnessPercentView$p = this.this$0.brightnessPercentView;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("%d %s", Arrays.copyOf(new Object[]{Integer.valueOf(i), "%"}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            access$getBrightnessPercentView$p.setText(format);
            return;
        }
        Brightness fromPercentage = Brightness.Companion.fromPercentage(i, this.this$0.isSlidingRight(i));
        TextView access$getBrightnessPercentView$p2 = this.this$0.brightnessPercentView;
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
        String format2 = String.format("%d %s", Arrays.copyOf(new Object[]{Integer.valueOf(fromPercentage.toPercentage()), "%"}, 2));
        Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
        access$getBrightnessPercentView$p2.setText(format2);
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
        this.this$0.onProgressSet(this.$device);
    }
}
