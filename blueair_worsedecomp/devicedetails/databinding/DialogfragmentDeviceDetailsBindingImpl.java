package com.blueair.devicedetails.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blueair.devicedetails.BR;
import com.blueair.devicedetails.R;
import com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel;

public class DialogfragmentDeviceDetailsBindingImpl extends DialogfragmentDeviceDetailsBinding {
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
        sparseIntArray.put(R.id.title_bar, 1);
        sparseIntArray.put(R.id.close_btn, 2);
        sparseIntArray.put(R.id.device_icon, 3);
        sparseIntArray.put(R.id.device_name, 4);
        sparseIntArray.put(R.id.location, 5);
        sparseIntArray.put(R.id.scrollable, 6);
        sparseIntArray.put(R.id.content_container, 7);
        sparseIntArray.put(R.id.banners_container, 8);
        sparseIntArray.put(R.id.graph_container, 9);
        sparseIntArray.put(R.id.devices_attributes_container, 10);
        sparseIntArray.put(R.id.device_schedules_container, 11);
        sparseIntArray.put(R.id.welcome_home_container, 12);
        sparseIntArray.put(R.id.device_settings_container, 13);
    }

    public DialogfragmentDeviceDetailsBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 14, sIncludes, sViewsWithIds));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private DialogfragmentDeviceDetailsBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[8], objArr[2], objArr[7], objArr[3], objArr[4], objArr[11], objArr[13], objArr[10], objArr[9], objArr[5], objArr[0], objArr[6], objArr[1], objArr[12]);
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
