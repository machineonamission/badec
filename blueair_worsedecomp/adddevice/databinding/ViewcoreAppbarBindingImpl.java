package com.blueair.adddevice.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blueair.adddevice.R;

public class ViewcoreAppbarBindingImpl extends ViewcoreAppbarBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.btnBack, 1);
        sparseIntArray.put(R.id.header_title, 2);
        sparseIntArray.put(R.id.header_msg, 3);
        sparseIntArray.put(R.id.btnClose, 4);
        sparseIntArray.put(R.id.progress_indicator, 5);
    }

    public ViewcoreAppbarBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 6, sIncludes, sViewsWithIds));
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private ViewcoreAppbarBindingImpl(androidx.databinding.DataBindingComponent r12, android.view.View r13, java.lang.Object[] r14) {
        /*
            r11 = this;
            r0 = 1
            r0 = r14[r0]
            r5 = r0
            androidx.appcompat.widget.AppCompatImageButton r5 = (androidx.appcompat.widget.AppCompatImageButton) r5
            r0 = 4
            r0 = r14[r0]
            r6 = r0
            androidx.appcompat.widget.AppCompatImageButton r6 = (androidx.appcompat.widget.AppCompatImageButton) r6
            r0 = 3
            r0 = r14[r0]
            r7 = r0
            androidx.appcompat.widget.AppCompatTextView r7 = (androidx.appcompat.widget.AppCompatTextView) r7
            r0 = 0
            r0 = r14[r0]
            r8 = r0
            androidx.constraintlayout.widget.ConstraintLayout r8 = (androidx.constraintlayout.widget.ConstraintLayout) r8
            r0 = 2
            r0 = r14[r0]
            r9 = r0
            androidx.appcompat.widget.AppCompatTextView r9 = (androidx.appcompat.widget.AppCompatTextView) r9
            r0 = 5
            r14 = r14[r0]
            r10 = r14
            com.google.android.material.progressindicator.LinearProgressIndicator r10 = (com.google.android.material.progressindicator.LinearProgressIndicator) r10
            r4 = 0
            r1 = r11
            r2 = r12
            r3 = r13
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r12 = -1
            r1.mDirtyFlags = r12
            androidx.constraintlayout.widget.ConstraintLayout r12 = r1.headerRoot
            r13 = 0
            r12.setTag(r13)
            r11.setRootTag((android.view.View) r3)
            r11.invalidateAll()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.adddevice.databinding.ViewcoreAppbarBindingImpl.<init>(androidx.databinding.DataBindingComponent, android.view.View, java.lang.Object[]):void");
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 1;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.mDirtyFlags != 0) {
                return true;
            }
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0;
        }
    }
}
