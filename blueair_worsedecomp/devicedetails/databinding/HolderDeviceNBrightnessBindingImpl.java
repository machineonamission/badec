package com.blueair.devicedetails.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blueair.devicedetails.R;

public class HolderDeviceNBrightnessBindingImpl extends HolderDeviceNBrightnessBinding {
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
        sparseIntArray.put(R.id.content_container, 1);
        sparseIntArray.put(R.id.title, 2);
        sparseIntArray.put(R.id.progressText, 3);
        sparseIntArray.put(R.id.seekbar, 4);
    }

    public HolderDeviceNBrightnessBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 5, sIncludes, sViewsWithIds));
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private HolderDeviceNBrightnessBindingImpl(androidx.databinding.DataBindingComponent r10, android.view.View r11, java.lang.Object[] r12) {
        /*
            r9 = this;
            r0 = 1
            r0 = r12[r0]
            r5 = r0
            androidx.constraintlayout.widget.ConstraintLayout r5 = (androidx.constraintlayout.widget.ConstraintLayout) r5
            r0 = 3
            r0 = r12[r0]
            r6 = r0
            android.widget.TextView r6 = (android.widget.TextView) r6
            r0 = 4
            r0 = r12[r0]
            r7 = r0
            com.blueair.viewcore.view.AccessibleSeekBar r7 = (com.blueair.viewcore.view.AccessibleSeekBar) r7
            r0 = 2
            r0 = r12[r0]
            r8 = r0
            android.widget.TextView r8 = (android.widget.TextView) r8
            r4 = 0
            r1 = r9
            r2 = r10
            r3 = r11
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
            r10 = -1
            r1.mDirtyFlags = r10
            r10 = 0
            r10 = r12[r10]
            android.widget.FrameLayout r10 = (android.widget.FrameLayout) r10
            r1.mboundView0 = r10
            r11 = 0
            r10.setTag(r11)
            r9.setRootTag((android.view.View) r3)
            r9.invalidateAll()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.databinding.HolderDeviceNBrightnessBindingImpl.<init>(androidx.databinding.DataBindingComponent, android.view.View, java.lang.Object[]):void");
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
