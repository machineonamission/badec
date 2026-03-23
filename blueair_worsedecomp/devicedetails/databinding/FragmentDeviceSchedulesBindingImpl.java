package com.blueair.devicedetails.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blueair.devicedetails.BR;
import com.blueair.devicedetails.R;
import com.blueair.devicedetails.viewmodel.DeviceSchedulesViewModel;

public class FragmentDeviceSchedulesBindingImpl extends FragmentDeviceSchedulesBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.start_guideline, 1);
        sparseIntArray.put(R.id.end_guideline, 2);
        sparseIntArray.put(R.id.device_schedule_title, 3);
        sparseIntArray.put(R.id.add_schedule, 4);
        sparseIntArray.put(R.id.recycler_view_device_schedules, 5);
    }

    public FragmentDeviceSchedulesBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 6, sIncludes, sViewsWithIds));
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private FragmentDeviceSchedulesBindingImpl(androidx.databinding.DataBindingComponent r11, android.view.View r12, java.lang.Object[] r13) {
        /*
            r10 = this;
            r0 = 4
            r0 = r13[r0]
            r5 = r0
            com.google.android.material.button.MaterialButton r5 = (com.google.android.material.button.MaterialButton) r5
            r0 = 3
            r0 = r13[r0]
            r6 = r0
            android.widget.TextView r6 = (android.widget.TextView) r6
            r0 = 2
            r0 = r13[r0]
            r7 = r0
            androidx.constraintlayout.widget.Guideline r7 = (androidx.constraintlayout.widget.Guideline) r7
            r0 = 5
            r0 = r13[r0]
            r8 = r0
            androidx.recyclerview.widget.RecyclerView r8 = (androidx.recyclerview.widget.RecyclerView) r8
            r0 = 1
            r0 = r13[r0]
            r9 = r0
            androidx.constraintlayout.widget.Guideline r9 = (androidx.constraintlayout.widget.Guideline) r9
            r4 = 0
            r1 = r10
            r2 = r11
            r3 = r12
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
            r11 = -1
            r1.mDirtyFlags = r11
            r11 = 0
            r11 = r13[r11]
            androidx.constraintlayout.widget.ConstraintLayout r11 = (androidx.constraintlayout.widget.ConstraintLayout) r11
            r1.mboundView0 = r11
            r12 = 0
            r11.setTag(r12)
            r10.setRootTag((android.view.View) r3)
            r10.invalidateAll()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.databinding.FragmentDeviceSchedulesBindingImpl.<init>(androidx.databinding.DataBindingComponent, android.view.View, java.lang.Object[]):void");
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 2;
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

    public boolean setVariable(int i, Object obj) {
        if (BR.deviceSchedulesViewModel != i) {
            return false;
        }
        setDeviceSchedulesViewModel((DeviceSchedulesViewModel) obj);
        return true;
    }

    public void setDeviceSchedulesViewModel(DeviceSchedulesViewModel deviceSchedulesViewModel) {
        this.mDeviceSchedulesViewModel = deviceSchedulesViewModel;
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0;
        }
    }
}
