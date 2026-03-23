package com.blueair.devicedetails.activity;

import android.widget.SeekBar;
import android.widget.TextView;
import com.blueair.devicedetails.databinding.ActivityAlarmEditBinding;
import com.blueair.viewcore.R;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0012\u0010\r\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\u000e\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"com/blueair/devicedetails/activity/AlarmEditActivity$onCreate$2$11", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "tintColor", "", "unTintTextColor", "unTintSeparatorColor", "onProgressChanged", "", "seekBar", "Landroid/widget/SeekBar;", "progress", "fromUser", "", "onStartTrackingTouch", "onStopTrackingTouch", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: AlarmEditActivity.kt */
public final class AlarmEditActivity$onCreate$2$11 implements SeekBar.OnSeekBarChangeListener {
    final /* synthetic */ ActivityAlarmEditBinding $this_apply;
    final /* synthetic */ AlarmEditActivity this$0;
    private final int tintColor;
    private final int unTintSeparatorColor;
    private final int unTintTextColor;

    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
    }

    AlarmEditActivity$onCreate$2$11(AlarmEditActivity alarmEditActivity, ActivityAlarmEditBinding activityAlarmEditBinding) {
        this.this$0 = alarmEditActivity;
        this.$this_apply = activityAlarmEditBinding;
        this.tintColor = alarmEditActivity.getColor(R.color.colorPrimary);
        this.unTintTextColor = alarmEditActivity.getColor(R.color.surface_dark_55);
        this.unTintSeparatorColor = alarmEditActivity.getColor(R.color.surface_dark_45);
    }

    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        TextView textView = this.$this_apply.tvDurationValue;
        textView.setText(i + TokenParser.SP + this.this$0.getString(R.string.eta_minutes));
        if (i == 15) {
            this.$this_apply.tvProgress0.setTextColor(this.tintColor);
            this.$this_apply.separatorStart.setBackgroundColor(this.tintColor);
            this.$this_apply.tvProgress100.setTextColor(this.unTintTextColor);
            this.$this_apply.separatorEnd.setBackgroundColor(this.unTintSeparatorColor);
        } else if (i != 30) {
            this.$this_apply.tvProgress0.setTextColor(this.unTintTextColor);
            this.$this_apply.separatorStart.setBackgroundColor(this.unTintSeparatorColor);
            this.$this_apply.tvProgress100.setTextColor(this.unTintTextColor);
            this.$this_apply.separatorEnd.setBackgroundColor(this.unTintSeparatorColor);
        } else {
            this.$this_apply.tvProgress0.setTextColor(this.unTintTextColor);
            this.$this_apply.separatorStart.setBackgroundColor(this.unTintSeparatorColor);
            this.$this_apply.tvProgress100.setTextColor(this.tintColor);
            this.$this_apply.separatorEnd.setBackgroundColor(this.tintColor);
        }
    }
}
