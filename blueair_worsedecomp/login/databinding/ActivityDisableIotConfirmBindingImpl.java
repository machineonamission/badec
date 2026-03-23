package com.blueair.login.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blueair.login.R;

public class ActivityDisableIotConfirmBindingImpl extends ActivityDisableIotConfirmBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final FrameLayout mboundView0;

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
        sparseIntArray.put(R.id.toolbar, 1);
        sparseIntArray.put(R.id.btnClose, 2);
        sparseIntArray.put(R.id.scrollableRoot, 3);
        sparseIntArray.put(R.id.icon, 4);
        sparseIntArray.put(R.id.description, 5);
        sparseIntArray.put(R.id.btnDelete, 6);
        sparseIntArray.put(R.id.loading, 7);
    }

    public ActivityDisableIotConfirmBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 8, sIncludes, sViewsWithIds));
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private ActivityDisableIotConfirmBindingImpl(androidx.databinding.DataBindingComponent r13, android.view.View r14, java.lang.Object[] r15) {
        /*
            r12 = this;
            r0 = 2
            r0 = r15[r0]
            r5 = r0
            androidx.appcompat.widget.AppCompatImageButton r5 = (androidx.appcompat.widget.AppCompatImageButton) r5
            r0 = 6
            r0 = r15[r0]
            r6 = r0
            com.google.android.material.button.MaterialButton r6 = (com.google.android.material.button.MaterialButton) r6
            r0 = 5
            r0 = r15[r0]
            r7 = r0
            android.widget.TextView r7 = (android.widget.TextView) r7
            r0 = 4
            r0 = r15[r0]
            r8 = r0
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            r0 = 7
            r0 = r15[r0]
            r9 = r0
            com.blueair.viewcore.view.ProgressBlockerView r9 = (com.blueair.viewcore.view.ProgressBlockerView) r9
            r0 = 3
            r0 = r15[r0]
            r10 = r0
            android.widget.ScrollView r10 = (android.widget.ScrollView) r10
            r0 = 1
            r0 = r15[r0]
            r11 = r0
            com.google.android.material.appbar.MaterialToolbar r11 = (com.google.android.material.appbar.MaterialToolbar) r11
            r4 = 0
            r1 = r12
            r2 = r13
            r3 = r14
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r13 = -1
            r1.mDirtyFlags = r13
            r13 = 0
            r13 = r15[r13]
            android.widget.FrameLayout r13 = (android.widget.FrameLayout) r13
            r1.mboundView0 = r13
            r14 = 0
            r13.setTag(r14)
            r12.setRootTag((android.view.View) r3)
            r12.invalidateAll()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.login.databinding.ActivityDisableIotConfirmBindingImpl.<init>(androidx.databinding.DataBindingComponent, android.view.View, java.lang.Object[]):void");
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
