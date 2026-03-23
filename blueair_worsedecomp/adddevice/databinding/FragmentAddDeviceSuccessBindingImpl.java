package com.blueair.adddevice.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blueair.adddevice.BR;
import com.blueair.adddevice.R;
import com.blueair.adddevice.viewmodel.AddDeviceViewModel;

public class FragmentAddDeviceSuccessBindingImpl extends FragmentAddDeviceSuccessBinding {
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
        sparseIntArray.put(R.id.progressView, 1);
        sparseIntArray.put(R.id.guideline_center, 2);
        sparseIntArray.put(R.id.iv_device, 3);
        sparseIntArray.put(R.id.iv_indicator, 4);
        sparseIntArray.put(R.id.tv_status, 5);
        sparseIntArray.put(R.id.tv_content, 6);
        sparseIntArray.put(R.id.button_continue, 7);
    }

    public FragmentAddDeviceSuccessBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 8, sIncludes, sViewsWithIds));
    }

    private FragmentAddDeviceSuccessBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[7], objArr[2], objArr[3], objArr[4], objArr[1], objArr[0], objArr[6], objArr[5]);
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
