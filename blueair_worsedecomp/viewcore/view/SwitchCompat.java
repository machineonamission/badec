package com.blueair.viewcore.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bB!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u000e\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\rR\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/blueair/viewcore/view/SwitchCompat;", "Landroidx/appcompat/widget/SwitchCompat;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "shouldIgnoreCheckedChange", "", "setOnCheckedChangeListener", "", "listener", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "setCheckedSilence", "checked", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: SwitchCompat.kt */
public final class SwitchCompat extends androidx.appcompat.widget.SwitchCompat {
    private boolean shouldIgnoreCheckedChange;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SwitchCompat(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        setEnforceSwitchWidth(getSwitchMinWidth() <= 0);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SwitchCompat(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
        setEnforceSwitchWidth(getSwitchMinWidth() <= 0);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SwitchCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
        setEnforceSwitchWidth(getSwitchMinWidth() <= 0);
    }

    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        super.setOnCheckedChangeListener(new SwitchCompat$$ExternalSyntheticLambda0(this, onCheckedChangeListener));
    }

    /* access modifiers changed from: private */
    public static final void setOnCheckedChangeListener$lambda$0(SwitchCompat switchCompat, CompoundButton.OnCheckedChangeListener onCheckedChangeListener, CompoundButton compoundButton, boolean z) {
        if (!switchCompat.shouldIgnoreCheckedChange && onCheckedChangeListener != null) {
            onCheckedChangeListener.onCheckedChanged(compoundButton, z);
        }
    }

    public final void setCheckedSilence(boolean z) {
        this.shouldIgnoreCheckedChange = true;
        super.setChecked(z);
        this.shouldIgnoreCheckedChange = false;
    }
}
