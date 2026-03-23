package com.blueair.devicedetails.viewholder;

import android.widget.SeekBar;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceIcp;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.FanSpeedEnum;
import com.blueair.core.model.HasFanSpeed;
import com.blueair.devicedetails.util.FanSpeedUtils;
import kotlin.Metadata;
import timber.log.Timber;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u000b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\f"}, d2 = {"com/blueair/devicedetails/viewholder/DeviceManualModeHolder$update$3", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "onProgressChanged", "", "seekBar", "Landroid/widget/SeekBar;", "progress", "", "fromTouch", "", "onStartTrackingTouch", "onStopTrackingTouch", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceManualModeHolder.kt */
public final class DeviceManualModeHolder$update$3 implements SeekBar.OnSeekBarChangeListener {
    final /* synthetic */ Device $device;
    final /* synthetic */ DeviceManualModeHolder this$0;

    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    DeviceManualModeHolder$update$3(Device device, DeviceManualModeHolder deviceManualModeHolder) {
        this.$device = device;
        this.this$0 = deviceManualModeHolder;
    }

    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        FanSpeedEnum fanSpeedEnum;
        if (((HasFanSpeed) this.$device).getHasGear4()) {
            fanSpeedEnum = FanSpeedEnum.Companion.fanSpeedEnumFromProgressBluePremium(FanSpeedUtils.INSTANCE.getBluePremiumFromSeekBarProgress(i));
        } else if (DeviceKt.isG4orB4orNB(this.$device)) {
            fanSpeedEnum = FanSpeedEnum.Companion.fanSpeedEnumFromProgressG4(FanSpeedUtils.INSTANCE.getG4FanSpeedFromSeekBarProgress(i));
        } else if (this.$device instanceof DeviceIcp) {
            fanSpeedEnum = FanSpeedEnum.Companion.fanSpeedEnumFromProgressIcp(FanSpeedUtils.INSTANCE.getIcpSpeedFromSeekBarProgress(i));
        } else {
            fanSpeedEnum = FanSpeedEnum.Companion.fanSpeedEnumFromProgressLegacy(FanSpeedUtils.INSTANCE.getLegacySpeedFromSeekBarProgress(i));
        }
        if (fanSpeedEnum == FanSpeedEnum.SNAP_STEP) {
            this.this$0.tintSnapSteps((HasFanSpeed) this.$device, i);
        } else {
            this.this$0.tintFanSpeed(fanSpeedEnum);
        }
        Timber.Forest forest = Timber.Forest;
        forest.d("setOnSeekBarChangeListener progress = " + i + ", fanSpeedEnum = " + fanSpeedEnum + ", fromTouch = " + z, new Object[0]);
        if (!z) {
            DeviceManualModeHolder deviceManualModeHolder = this.this$0;
            deviceManualModeHolder.lastProgress = deviceManualModeHolder.getBinding().fanSpeedSeekbar.getProgress();
            Timber.Forest.d("setOnSeekBarChangeListener: publish", new Object[0]);
            this.this$0.publishValue(fanSpeedEnum, (HasFanSpeed) this.$device);
        }
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
        this.this$0.onProgressSet((HasFanSpeed) this.$device);
    }
}
