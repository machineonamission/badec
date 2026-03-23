package com.blueair.devicedetails.viewholder;

import android.os.Build;
import android.widget.SeekBar;
import android.widget.TextView;
import com.blueair.devicedetails.databinding.HolderDeviceBrightnessV2Binding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0017J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u000e\u0010\f\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\r"}, d2 = {"com/blueair/devicedetails/viewholder/DeviceBrightnessV2Holder$1$3", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "onProgressChanged", "", "seekBar", "Landroid/widget/SeekBar;", "progress", "", "fromUser", "", "onStartTrackingTouch", "onStopTrackingTouch", "correctProgress", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceBrightnessV2Holder.kt */
public final class DeviceBrightnessV2Holder$1$3 implements SeekBar.OnSeekBarChangeListener {
    final /* synthetic */ HolderDeviceBrightnessV2Binding $this_apply;
    final /* synthetic */ DeviceBrightnessV2Holder this$0;

    DeviceBrightnessV2Holder$1$3(HolderDeviceBrightnessV2Binding holderDeviceBrightnessV2Binding, DeviceBrightnessV2Holder deviceBrightnessV2Holder) {
        this.$this_apply = holderDeviceBrightnessV2Binding;
        this.this$0 = deviceBrightnessV2Holder;
    }

    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        Intrinsics.checkNotNullParameter(seekBar, "seekBar");
        TextView textView = this.$this_apply.progressText;
        StringBuilder sb = new StringBuilder();
        sb.append(correctProgress(seekBar.getProgress()));
        sb.append('%');
        textView.setText(sb.toString());
    }

    public void onStartTrackingTouch(SeekBar seekBar) {
        Intrinsics.checkNotNullParameter(seekBar, "seekBar");
        this.this$0.inTouch = true;
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
        Intrinsics.checkNotNullParameter(seekBar, "seekBar");
        this.this$0.inTouch = false;
        this.this$0.onBrightnessSetListener.invoke(Integer.valueOf(correctProgress(seekBar.getProgress())));
    }

    public final int correctProgress(int i) {
        if (Build.VERSION.SDK_INT >= 26) {
            return i;
        }
        return ((i * (100 - this.this$0.minBrightness)) / 100) + this.this$0.minBrightness;
    }
}
