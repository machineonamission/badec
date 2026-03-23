package com.blueair.devicedetails.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blueair.devicedetails.BR;
import com.blueair.devicedetails.R;
import com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel;

public class DialogfragmentDeviceFilterSelectionBindingImpl extends DialogfragmentDeviceFilterSelectionBinding {
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
        sparseIntArray.put(R.id.pager_root_layout, 3);
        sparseIntArray.put(R.id.filter_pager, 4);
        sparseIntArray.put(R.id.dots_indicator, 5);
        sparseIntArray.put(R.id.btnLeft, 6);
        sparseIntArray.put(R.id.btnRight, 7);
        sparseIntArray.put(R.id.button_save, 8);
        sparseIntArray.put(R.id.progressView, 9);
    }

    public DialogfragmentDeviceFilterSelectionBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 10, sIncludes, sViewsWithIds));
    }

    private DialogfragmentDeviceFilterSelectionBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[6], objArr[7], objArr[8], objArr[5], objArr[4], objArr[3], objArr[9], objArr[0], objArr[2], objArr[1]);
        this.mDirtyFlags = -1;
        this.rootLayout.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
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
