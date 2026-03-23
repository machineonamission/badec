package com.blueair.viewcore.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.SeekBar;
import androidx.appcompat.widget.AppCompatSeekBar;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0015"}, d2 = {"Lcom/blueair/viewcore/view/AccessibleSeekBar;", "Landroidx/appcompat/widget/AppCompatSeekBar;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "isAccessibilityProgressStartPosted", "", "lastAccessibilityProgressChangeTime", "", "accessibilityProgressCheckDelay", "getAccessibilityProgressCheckDelay", "()J", "setAccessibilityProgressCheckDelay", "(J)V", "setOnSeekBarChangeListener", "", "listener", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: AccessibleSeekBar.kt */
public final class AccessibleSeekBar extends AppCompatSeekBar {
    private long accessibilityProgressCheckDelay;
    /* access modifiers changed from: private */
    public boolean isAccessibilityProgressStartPosted;
    /* access modifiers changed from: private */
    public long lastAccessibilityProgressChangeTime;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AccessibleSeekBar(Context context) {
        this(context, (AttributeSet) null, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AccessibleSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.accessibilityProgressCheckDelay = 3000;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AccessibleSeekBar(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    public final long getAccessibilityProgressCheckDelay() {
        return this.accessibilityProgressCheckDelay;
    }

    public final void setAccessibilityProgressCheckDelay(long j) {
        this.accessibilityProgressCheckDelay = j;
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        super.setOnSeekBarChangeListener(onSeekBarChangeListener != null ? new AccessibleSeekBar$setOnSeekBarChangeListener$1$1(onSeekBarChangeListener, this) : null);
    }
}
