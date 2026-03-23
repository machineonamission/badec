package com.blueair.devicedetails.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.blueair.core.model.Device;
import com.blueair.devicedetails.BR;
import com.blueair.devicedetails.R;
import com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel;

public class ActivityDeviceDetailsBindingImpl extends ActivityDeviceDetailsBinding {
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
        sparseIntArray.put(R.id.toolbar, 2);
        sparseIntArray.put(R.id.textModel, 3);
        sparseIntArray.put(R.id.content_fragment, 4);
        sparseIntArray.put(R.id.blockerGroup, 5);
        sparseIntArray.put(R.id.blocker, 6);
        sparseIntArray.put(R.id.textUpdating, 7);
        sparseIntArray.put(R.id.textUpdatingDescription, 8);
        sparseIntArray.put(R.id.progressUpdating, 9);
    }

    public ActivityDeviceDetailsBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 10, sIncludes, sViewsWithIds));
    }

    private ActivityDeviceDetailsBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[6], objArr[5], objArr[4], objArr[9], objArr[3], objArr[1], objArr[7], objArr[8], objArr[2]);
        this.mDirtyFlags = -1;
        ConstraintLayout constraintLayout = objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag((Object) null);
        this.textName.setTag((Object) null);
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
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(BR.deviceDetailViewModel);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        DeviceDetailsViewModel deviceDetailsViewModel = this.mDeviceDetailViewModel;
        int i = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        String str = null;
        if (i != 0) {
            Device device = deviceDetailsViewModel != null ? deviceDetailsViewModel.getDevice() : null;
            if (device != null) {
                str = device.getName();
            }
        }
        if (i != 0) {
            TextViewBindingAdapter.setText(this.textName, str);
        }
    }
}
