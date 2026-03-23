package com.blueair.devicedetails.viewholder;

import android.widget.SeekBar;
import com.blueair.core.model.MoodLampEnum;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\f"}, d2 = {"com/blueair/devicedetails/viewholder/DeviceMoodLampHolder$1$3", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "onProgressChanged", "", "seekBar", "Landroid/widget/SeekBar;", "progress", "", "fromUser", "", "onStartTrackingTouch", "onStopTrackingTouch", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceMoodLampHolder.kt */
public final class DeviceMoodLampHolder$1$3 implements SeekBar.OnSeekBarChangeListener {
    final /* synthetic */ DeviceMoodLampHolder this$0;

    DeviceMoodLampHolder$1$3(DeviceMoodLampHolder deviceMoodLampHolder) {
        this.this$0 = deviceMoodLampHolder;
    }

    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        Intrinsics.checkNotNullParameter(seekBar, "seekBar");
        this.this$0.update(MoodLampEnum.Companion.fromStep(i));
    }

    public void onStartTrackingTouch(SeekBar seekBar) {
        Intrinsics.checkNotNullParameter(seekBar, "seekBar");
        this.this$0.inTouch = true;
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
        Intrinsics.checkNotNullParameter(seekBar, "seekBar");
        this.this$0.inTouch = false;
        this.this$0.onLampGearSelectedListener.invoke(MoodLampEnum.Companion.fromStep(seekBar.getProgress()));
    }
}
