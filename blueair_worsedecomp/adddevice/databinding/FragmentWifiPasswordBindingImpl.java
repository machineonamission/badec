package com.blueair.adddevice.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blueair.adddevice.BR;
import com.blueair.adddevice.R;
import com.blueair.adddevice.viewmodel.AddDeviceViewModel;

public class FragmentWifiPasswordBindingImpl extends FragmentWifiPasswordBinding {
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
        sparseIntArray.put(R.id.tv_title, 1);
        sparseIntArray.put(R.id.tv_subtitle, 2);
        sparseIntArray.put(R.id.ssidEditTextLayout, 3);
        sparseIntArray.put(R.id.ssidEditText, 4);
        sparseIntArray.put(R.id.input_password, 5);
        sparseIntArray.put(R.id.passwordEditText, 6);
        sparseIntArray.put(R.id.tv_error, 7);
        sparseIntArray.put(R.id.buttonNext, 8);
        sparseIntArray.put(R.id.log_view, 9);
        sparseIntArray.put(R.id.progressView, 10);
    }

    public FragmentWifiPasswordBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 11, sIncludes, sViewsWithIds));
    }

    private FragmentWifiPasswordBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[8], objArr[5], objArr[9], objArr[6], objArr[10], objArr[0], objArr[4], objArr[3], objArr[7], objArr[2], objArr[1]);
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
