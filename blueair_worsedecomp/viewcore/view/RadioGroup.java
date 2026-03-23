package com.blueair.viewcore.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RadioGroup;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bJ\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u000e\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/blueair/viewcore/view/RadioGroup;", "Landroid/widget/RadioGroup;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "shouldIgnoreCheckedChange", "", "setOnCheckedChangeListener", "", "listener", "Landroid/widget/RadioGroup$OnCheckedChangeListener;", "checkSilence", "id", "", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: RadioGroup.kt */
public final class RadioGroup extends android.widget.RadioGroup {
    private boolean shouldIgnoreCheckedChange;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RadioGroup(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RadioGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
    }

    public void setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener onCheckedChangeListener) {
        super.setOnCheckedChangeListener(new RadioGroup$$ExternalSyntheticLambda0(this, onCheckedChangeListener));
    }

    /* access modifiers changed from: private */
    public static final void setOnCheckedChangeListener$lambda$0(RadioGroup radioGroup, RadioGroup.OnCheckedChangeListener onCheckedChangeListener, android.widget.RadioGroup radioGroup2, int i) {
        if (!radioGroup.shouldIgnoreCheckedChange && onCheckedChangeListener != null) {
            onCheckedChangeListener.onCheckedChanged(radioGroup2, i);
        }
    }

    public final void checkSilence(int i) {
        this.shouldIgnoreCheckedChange = true;
        super.check(i);
        this.shouldIgnoreCheckedChange = false;
    }
}
