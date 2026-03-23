package com.blueair.devicedetails.dialog;

import android.widget.SeekBar;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u000b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\f"}, d2 = {"com/blueair/devicedetails/dialog/DeviceOscillationSettingsDialogFragment$onCreateView$2$3", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "onProgressChanged", "", "seekBar", "Landroid/widget/SeekBar;", "progress", "", "fromUser", "", "onStartTrackingTouch", "onStopTrackingTouch", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceOscillationSettingsDialogFragment.kt */
public final class DeviceOscillationSettingsDialogFragment$onCreateView$2$3 implements SeekBar.OnSeekBarChangeListener {
    final /* synthetic */ boolean $disable;
    final /* synthetic */ DeviceOscillationSettingsDialogFragment this$0;

    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
    }

    DeviceOscillationSettingsDialogFragment$onCreateView$2$3(DeviceOscillationSettingsDialogFragment deviceOscillationSettingsDialogFragment, boolean z) {
        this.this$0 = deviceOscillationSettingsDialogFragment;
        this.$disable = z;
    }

    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        this.this$0.updateFanView();
        this.this$0.updateAngleBarLabels(this.$disable);
    }
}
