package com.blueair.viewcore.view;

import android.widget.SeekBar;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0019\u0010\n\u001a\u00020\u00032\u000e\u0010\u000b\u001a\n \f*\u0004\u0018\u00010\u00050\u0005H\u0001J\u0019\u0010\r\u001a\u00020\u00032\u000e\u0010\u000b\u001a\n \f*\u0004\u0018\u00010\u00050\u0005H\u0001¨\u0006\u000e"}, d2 = {"com/blueair/viewcore/view/AccessibleSeekBar$setOnSeekBarChangeListener$1$1", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "onProgressChanged", "", "seekBar", "Landroid/widget/SeekBar;", "progress", "", "fromUser", "", "onStartTrackingTouch", "p0", "kotlin.jvm.PlatformType", "onStopTrackingTouch", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: AccessibleSeekBar.kt */
public final class AccessibleSeekBar$setOnSeekBarChangeListener$1$1 implements SeekBar.OnSeekBarChangeListener {
    private final /* synthetic */ SeekBar.OnSeekBarChangeListener $$delegate_0;
    final /* synthetic */ SeekBar.OnSeekBarChangeListener $listener;
    final /* synthetic */ AccessibleSeekBar this$0;

    public void onStartTrackingTouch(SeekBar seekBar) {
        this.$$delegate_0.onStartTrackingTouch(seekBar);
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
        this.$$delegate_0.onStopTrackingTouch(seekBar);
    }

    AccessibleSeekBar$setOnSeekBarChangeListener$1$1(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener, AccessibleSeekBar accessibleSeekBar) {
        this.$listener = onSeekBarChangeListener;
        this.this$0 = accessibleSeekBar;
        this.$$delegate_0 = onSeekBarChangeListener;
    }

    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        if (this.this$0.isAccessibilityFocused()) {
            if (!this.this$0.isAccessibilityProgressStartPosted) {
                this.this$0.isAccessibilityProgressStartPosted = true;
                this.$listener.onStartTrackingTouch(seekBar);
            }
            this.this$0.lastAccessibilityProgressChangeTime = System.currentTimeMillis();
            this.$listener.onProgressChanged(seekBar, i, z);
            AccessibleSeekBar accessibleSeekBar = this.this$0;
            accessibleSeekBar.postDelayed(new AccessibleSeekBar$setOnSeekBarChangeListener$1$1$$ExternalSyntheticLambda0(accessibleSeekBar, this.$listener, seekBar), this.this$0.getAccessibilityProgressCheckDelay());
            return;
        }
        this.$listener.onProgressChanged(seekBar, i, z);
    }

    /* access modifiers changed from: private */
    public static final void onProgressChanged$lambda$0(AccessibleSeekBar accessibleSeekBar, SeekBar.OnSeekBarChangeListener onSeekBarChangeListener, SeekBar seekBar) {
        if (accessibleSeekBar.isAccessibilityProgressStartPosted && System.currentTimeMillis() - accessibleSeekBar.lastAccessibilityProgressChangeTime > accessibleSeekBar.getAccessibilityProgressCheckDelay() - ((long) 100)) {
            accessibleSeekBar.isAccessibilityProgressStartPosted = false;
            onSeekBarChangeListener.onStopTrackingTouch(seekBar);
        }
    }
}
