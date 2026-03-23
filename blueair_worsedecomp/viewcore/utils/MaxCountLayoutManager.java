package com.blueair.viewcore.utils;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import kotlin.Metadata;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B#\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\nB-\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\u000fJ\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u0007J\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0007H\u0016J\b\u0010\u0016\u001a\u00020\u0007H\u0002R\u000e\u0010\u0010\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/blueair/viewcore/utils/MaxCountLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "orientation", "", "reverseLayout", "", "(Landroid/content/Context;IZ)V", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "maxCount", "setMaxCount", "", "setMeasuredDimension", "widthSize", "heightSize", "calculateMaxHeight", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: MaxCountLayoutManager.kt */
public final class MaxCountLayoutManager extends LinearLayoutManager {
    private int maxCount = -1;

    public MaxCountLayoutManager(Context context) {
        super(context);
    }

    public MaxCountLayoutManager(Context context, int i, boolean z) {
        super(context, i, z);
    }

    public MaxCountLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public final void setMaxCount(int i) {
        this.maxCount = i;
    }

    public void setMeasuredDimension(int i, int i2) {
        int calculateMaxHeight = calculateMaxHeight();
        if (calculateMaxHeight <= 0 || calculateMaxHeight >= i2) {
            super.setMeasuredDimension(i, i2);
        } else {
            super.setMeasuredDimension(i, calculateMaxHeight);
        }
    }

    private final int calculateMaxHeight() {
        View childAt;
        if (getChildCount() == 0 || this.maxCount <= 0 || (childAt = getChildAt(0)) == null) {
            return 0;
        }
        return (childAt.getHeight() * this.maxCount) + getPaddingBottom() + getPaddingTop();
    }
}
