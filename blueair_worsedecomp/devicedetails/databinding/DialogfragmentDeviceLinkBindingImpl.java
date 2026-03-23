package com.blueair.devicedetails.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blueair.devicedetails.BR;
import com.blueair.devicedetails.R;
import com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel;

public class DialogfragmentDeviceLinkBindingImpl extends DialogfragmentDeviceLinkBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.root_layout, 1);
        sparseIntArray.put(R.id.top_guideline, 2);
        sparseIntArray.put(R.id.bottom_guideline, 3);
        sparseIntArray.put(R.id.start_guideline, 4);
        sparseIntArray.put(R.id.end_guideline, 5);
        sparseIntArray.put(R.id.title_icon_root, 6);
        sparseIntArray.put(R.id.link_icon, 7);
        sparseIntArray.put(R.id.link_plus_icon, 8);
        sparseIntArray.put(R.id.title, 9);
        sparseIntArray.put(R.id.subtitle, 10);
        sparseIntArray.put(R.id.close_btn, 11);
        sparseIntArray.put(R.id.choose_product_textview, 12);
        sparseIntArray.put(R.id.product_list, 13);
        sparseIntArray.put(R.id.connect_button, 14);
    }

    public DialogfragmentDeviceLinkBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 15, sIncludes, sViewsWithIds));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private DialogfragmentDeviceLinkBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[3], objArr[12], objArr[11], objArr[14], objArr[5], objArr[7], objArr[8], objArr[13], objArr[1], objArr[4], objArr[10], objArr[9], objArr[6], objArr[2]);
        this.mDirtyFlags = -1;
        LinearLayout linearLayout = objArr[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag((Object) null);
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
        if (BR.deviceDetailsViewModel != i) {
            return false;
        }
        setDeviceDetailsViewModel((DeviceDetailsViewModel) obj);
        return true;
    }

    public void setDeviceDetailsViewModel(DeviceDetailsViewModel deviceDetailsViewModel) {
        this.mDeviceDetailsViewModel = deviceDetailsViewModel;
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0;
        }
    }
}
