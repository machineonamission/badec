package com.blueair.viewcore.view;

import android.widget.SeekBar;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AccessibleSeekBar$setOnSeekBarChangeListener$1$1$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ AccessibleSeekBar f$0;
    public final /* synthetic */ SeekBar.OnSeekBarChangeListener f$1;
    public final /* synthetic */ SeekBar f$2;

    public /* synthetic */ AccessibleSeekBar$setOnSeekBarChangeListener$1$1$$ExternalSyntheticLambda0(AccessibleSeekBar accessibleSeekBar, SeekBar.OnSeekBarChangeListener onSeekBarChangeListener, SeekBar seekBar) {
        this.f$0 = accessibleSeekBar;
        this.f$1 = onSeekBarChangeListener;
        this.f$2 = seekBar;
    }

    public final void run() {
        AccessibleSeekBar$setOnSeekBarChangeListener$1$1.onProgressChanged$lambda$0(this.f$0, this.f$1, this.f$2);
    }
}
