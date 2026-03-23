package com.blueair.viewcore.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blueair.viewcore.R;

public class FragmentWebviewBindingImpl extends FragmentWebviewBinding {
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
        sparseIntArray.put(R.id.web_view, 1);
        sparseIntArray.put(R.id.progressView, 2);
    }

    public FragmentWebviewBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 3, sIncludes, sViewsWithIds));
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private FragmentWebviewBindingImpl(androidx.databinding.DataBindingComponent r9, android.view.View r10, java.lang.Object[] r11) {
        /*
            r8 = this;
            r0 = 2
            r0 = r11[r0]
            r5 = r0
            com.blueair.viewcore.view.ProgressBlockerView r5 = (com.blueair.viewcore.view.ProgressBlockerView) r5
            r0 = 0
            r0 = r11[r0]
            r6 = r0
            androidx.constraintlayout.widget.ConstraintLayout r6 = (androidx.constraintlayout.widget.ConstraintLayout) r6
            r0 = 1
            r11 = r11[r0]
            r7 = r11
            android.webkit.WebView r7 = (android.webkit.WebView) r7
            r4 = 0
            r1 = r8
            r2 = r9
            r3 = r10
            r1.<init>(r2, r3, r4, r5, r6, r7)
            r9 = -1
            r1.mDirtyFlags = r9
            androidx.constraintlayout.widget.ConstraintLayout r9 = r1.webContainer
            r10 = 0
            r9.setTag(r10)
            r8.setRootTag((android.view.View) r3)
            r8.invalidateAll()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.viewcore.databinding.FragmentWebviewBindingImpl.<init>(androidx.databinding.DataBindingComponent, android.view.View, java.lang.Object[]):void");
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
