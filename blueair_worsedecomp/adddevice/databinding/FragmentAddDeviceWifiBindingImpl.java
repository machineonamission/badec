package com.blueair.adddevice.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blueair.adddevice.BR;
import com.blueair.adddevice.R;
import com.blueair.adddevice.viewmodel.AddDeviceViewModel;

public class FragmentAddDeviceWifiBindingImpl extends FragmentAddDeviceWifiBinding {
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
        sparseIntArray.put(R.id.rootLayout, 1);
        sparseIntArray.put(R.id.tv_title, 2);
        sparseIntArray.put(R.id.tv_subtitle, 3);
        sparseIntArray.put(R.id.btn_refresh, 4);
        sparseIntArray.put(R.id.recyclerViewSsid, 5);
        sparseIntArray.put(R.id.progressView, 6);
    }

    public FragmentAddDeviceWifiBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 7, sIncludes, sViewsWithIds));
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private FragmentAddDeviceWifiBindingImpl(androidx.databinding.DataBindingComponent r13, android.view.View r14, java.lang.Object[] r15) {
        /*
            r12 = this;
            r0 = 4
            r0 = r15[r0]
            r5 = r0
            com.google.android.material.button.MaterialButton r5 = (com.google.android.material.button.MaterialButton) r5
            r0 = 6
            r0 = r15[r0]
            r6 = r0
            com.blueair.viewcore.view.ProgressBlockerView r6 = (com.blueair.viewcore.view.ProgressBlockerView) r6
            r0 = 5
            r0 = r15[r0]
            r7 = r0
            androidx.recyclerview.widget.RecyclerView r7 = (androidx.recyclerview.widget.RecyclerView) r7
            r0 = 1
            r0 = r15[r0]
            r8 = r0
            androidx.constraintlayout.widget.ConstraintLayout r8 = (androidx.constraintlayout.widget.ConstraintLayout) r8
            r0 = 0
            r0 = r15[r0]
            r9 = r0
            androidx.swiperefreshlayout.widget.SwipeRefreshLayout r9 = (androidx.swiperefreshlayout.widget.SwipeRefreshLayout) r9
            r0 = 3
            r0 = r15[r0]
            r10 = r0
            androidx.appcompat.widget.AppCompatTextView r10 = (androidx.appcompat.widget.AppCompatTextView) r10
            r0 = 2
            r15 = r15[r0]
            r11 = r15
            androidx.appcompat.widget.AppCompatTextView r11 = (androidx.appcompat.widget.AppCompatTextView) r11
            r4 = 0
            r1 = r12
            r2 = r13
            r3 = r14
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r13 = -1
            r1.mDirtyFlags = r13
            androidx.swiperefreshlayout.widget.SwipeRefreshLayout r13 = r1.swipeToRefresh
            r14 = 0
            r13.setTag(r14)
            r12.setRootTag((android.view.View) r3)
            r12.invalidateAll()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.adddevice.databinding.FragmentAddDeviceWifiBindingImpl.<init>(androidx.databinding.DataBindingComponent, android.view.View, java.lang.Object[]):void");
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
        if (BR.addDeviceViewModel != i) {
            return false;
        }
        setAddDeviceViewModel((AddDeviceViewModel) obj);
        return true;
    }

    public void setAddDeviceViewModel(AddDeviceViewModel addDeviceViewModel) {
        this.mAddDeviceViewModel = addDeviceViewModel;
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0;
        }
    }
}
