package com.blueair.devicedetails.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blueair.devicedetails.BR;
import com.blueair.devicedetails.R;
import com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel;

public class DialogfragmentDeviceFilterPageBindingImpl extends DialogfragmentDeviceFilterPageBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.toolbar, 1);
        sparseIntArray.put(R.id.title, 2);
        sparseIntArray.put(R.id.filter_widgets, 3);
        sparseIntArray.put(R.id.progress_view, 4);
    }

    public DialogfragmentDeviceFilterPageBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 5, sIncludes, sViewsWithIds));
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private DialogfragmentDeviceFilterPageBindingImpl(androidx.databinding.DataBindingComponent r11, android.view.View r12, java.lang.Object[] r13) {
        /*
            r10 = this;
            r0 = 3
            r0 = r13[r0]
            r5 = r0
            androidx.recyclerview.widget.RecyclerView r5 = (androidx.recyclerview.widget.RecyclerView) r5
            r0 = 4
            r0 = r13[r0]
            r6 = r0
            com.blueair.viewcore.view.ProgressBlockerView r6 = (com.blueair.viewcore.view.ProgressBlockerView) r6
            r0 = 0
            r0 = r13[r0]
            r7 = r0
            androidx.coordinatorlayout.widget.CoordinatorLayout r7 = (androidx.coordinatorlayout.widget.CoordinatorLayout) r7
            r0 = 2
            r0 = r13[r0]
            r8 = r0
            android.widget.TextView r8 = (android.widget.TextView) r8
            r0 = 1
            r13 = r13[r0]
            r9 = r13
            androidx.appcompat.widget.Toolbar r9 = (androidx.appcompat.widget.Toolbar) r9
            r4 = 0
            r1 = r10
            r2 = r11
            r3 = r12
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
            r11 = -1
            r1.mDirtyFlags = r11
            androidx.coordinatorlayout.widget.CoordinatorLayout r11 = r1.rootLayout
            r12 = 0
            r11.setTag(r12)
            r10.setRootTag((android.view.View) r3)
            r10.invalidateAll()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.databinding.DialogfragmentDeviceFilterPageBindingImpl.<init>(androidx.databinding.DataBindingComponent, android.view.View, java.lang.Object[]):void");
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
        if (BR.deviceDetailViewModel != i) {
            return false;
        }
        setDeviceDetailViewModel((DeviceDetailsViewModel) obj);
        return true;
    }

    public void setDeviceDetailViewModel(DeviceDetailsViewModel deviceDetailsViewModel) {
        this.mDeviceDetailViewModel = deviceDetailsViewModel;
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0;
        }
    }
}
