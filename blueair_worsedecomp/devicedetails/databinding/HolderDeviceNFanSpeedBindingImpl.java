package com.blueair.devicedetails.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blueair.devicedetails.R;

public class HolderDeviceNFanSpeedBindingImpl extends HolderDeviceNFanSpeedBinding {
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
        sparseIntArray.put(R.id.title, 1);
        sparseIntArray.put(R.id.radio_group, 2);
        sparseIntArray.put(R.id.speed_0, 3);
        sparseIntArray.put(R.id.speed_1, 4);
        sparseIntArray.put(R.id.speed_2, 5);
        sparseIntArray.put(R.id.speed_3, 6);
        sparseIntArray.put(R.id.speed_4, 7);
    }

    public HolderDeviceNFanSpeedBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 8, sIncludes, sViewsWithIds));
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private HolderDeviceNFanSpeedBindingImpl(androidx.databinding.DataBindingComponent r13, android.view.View r14, java.lang.Object[] r15) {
        /*
            r12 = this;
            r0 = 2
            r0 = r15[r0]
            r5 = r0
            android.widget.RadioGroup r5 = (android.widget.RadioGroup) r5
            r0 = 3
            r0 = r15[r0]
            r6 = r0
            android.widget.RadioButton r6 = (android.widget.RadioButton) r6
            r0 = 4
            r0 = r15[r0]
            r7 = r0
            android.widget.RadioButton r7 = (android.widget.RadioButton) r7
            r0 = 5
            r0 = r15[r0]
            r8 = r0
            android.widget.RadioButton r8 = (android.widget.RadioButton) r8
            r0 = 6
            r0 = r15[r0]
            r9 = r0
            android.widget.RadioButton r9 = (android.widget.RadioButton) r9
            r0 = 7
            r0 = r15[r0]
            r10 = r0
            android.widget.RadioButton r10 = (android.widget.RadioButton) r10
            r0 = 1
            r0 = r15[r0]
            r11 = r0
            android.widget.TextView r11 = (android.widget.TextView) r11
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
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.databinding.HolderDeviceNFanSpeedBindingImpl.<init>(androidx.databinding.DataBindingComponent, android.view.View, java.lang.Object[]):void");
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
