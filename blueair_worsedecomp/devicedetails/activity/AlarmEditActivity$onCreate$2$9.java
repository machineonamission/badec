package com.blueair.devicedetails.activity;

import android.widget.SeekBar;
import com.blueair.core.model.HasAlarm;
import com.blueair.devicedetails.databinding.ActivityAlarmEditBinding;
import com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u000b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\f"}, d2 = {"com/blueair/devicedetails/activity/AlarmEditActivity$onCreate$2$9", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "onProgressChanged", "", "seekBar", "Landroid/widget/SeekBar;", "progress", "", "fromUser", "", "onStartTrackingTouch", "onStopTrackingTouch", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: AlarmEditActivity.kt */
public final class AlarmEditActivity$onCreate$2$9 implements SeekBar.OnSeekBarChangeListener {
    final /* synthetic */ ActivityAlarmEditBinding $this_apply;
    final /* synthetic */ AlarmEditActivity this$0;

    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    AlarmEditActivity$onCreate$2$9(ActivityAlarmEditBinding activityAlarmEditBinding, AlarmEditActivity alarmEditActivity) {
        this.$this_apply = activityAlarmEditBinding;
        this.this$0 = alarmEditActivity;
    }

    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        this.$this_apply.tvVolumeValue.setText(String.valueOf(i));
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
        DeviceDetailsViewModel access$getViewModel$p = this.this$0.viewModel;
        HasAlarm access$getDevice$p = this.this$0.device;
        if (access$getDevice$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("device");
            access$getDevice$p = null;
        }
        access$getViewModel$p.playAlarm(access$getDevice$p, this.this$0.alarmSound.getValue(), this.$this_apply.seekbarVolume.getProgress());
    }
}
