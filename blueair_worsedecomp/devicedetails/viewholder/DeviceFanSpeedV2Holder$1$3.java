package com.blueair.devicedetails.viewholder;

import android.widget.SeekBar;
import com.blueair.core.model.Device;
import com.blueair.core.model.FanSpeedEnum;
import com.blueair.core.model.HasFanSpeed;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\f"}, d2 = {"com/blueair/devicedetails/viewholder/DeviceFanSpeedV2Holder$1$3", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "onProgressChanged", "", "seekBar", "Landroid/widget/SeekBar;", "progress", "", "fromUser", "", "onStartTrackingTouch", "onStopTrackingTouch", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceFanSpeedV2Holder.kt */
public final class DeviceFanSpeedV2Holder$1$3 implements SeekBar.OnSeekBarChangeListener {
    final /* synthetic */ DeviceFanSpeedV2Holder this$0;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceFanSpeedV2Holder.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FanSpeedEnum.values().length];
            try {
                iArr[FanSpeedEnum.SNAP_STEP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    DeviceFanSpeedV2Holder$1$3(DeviceFanSpeedV2Holder deviceFanSpeedV2Holder) {
        this.this$0 = deviceFanSpeedV2Holder;
    }

    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        Intrinsics.checkNotNullParameter(seekBar, "seekBar");
        DeviceFanSpeedV2Holder deviceFanSpeedV2Holder = this.this$0;
        DeviceFanSpeedV2Holder.update$default(deviceFanSpeedV2Holder, deviceFanSpeedV2Holder.calcFanSpeedByProgress(i), (Integer) null, 2, (Object) null);
    }

    public void onStartTrackingTouch(SeekBar seekBar) {
        Intrinsics.checkNotNullParameter(seekBar, "seekBar");
        this.this$0.inTouch = true;
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
        Intrinsics.checkNotNullParameter(seekBar, "seekBar");
        this.this$0.inTouch = false;
        FanSpeedEnum access$calcFanSpeedByProgress = this.this$0.calcFanSpeedByProgress(seekBar.getProgress());
        if (WhenMappings.$EnumSwitchMapping$0[access$calcFanSpeedByProgress.ordinal()] == 1) {
            Device device = this.this$0.getDevice();
            HasFanSpeed hasFanSpeed = device instanceof HasFanSpeed ? (HasFanSpeed) device : null;
            if (hasFanSpeed != null) {
                DeviceFanSpeedV2Holder deviceFanSpeedV2Holder = this.this$0;
                int access$getProgressAfterSnap = deviceFanSpeedV2Holder.getProgressAfterSnap(hasFanSpeed, seekBar.getProgress());
                seekBar.setProgress(access$getProgressAfterSnap);
                deviceFanSpeedV2Holder.onFanSpeedSelectedListener.invoke(deviceFanSpeedV2Holder.calcFanSpeedByProgress(access$getProgressAfterSnap));
                return;
            }
            return;
        }
        this.this$0.onFanSpeedSelectedListener.invoke(access$calcFanSpeedByProgress);
    }
}
