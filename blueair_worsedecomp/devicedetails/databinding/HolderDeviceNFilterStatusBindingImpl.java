package com.blueair.devicedetails.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blueair.devicedetails.R;

public class HolderDeviceNFilterStatusBindingImpl extends HolderDeviceNFilterStatusBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

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
        sparseIntArray.put(R.id.progressText, 2);
        sparseIntArray.put(R.id.progress_bar, 3);
        sparseIntArray.put(R.id.hintText, 4);
        sparseIntArray.put(R.id.expiredText, 5);
        sparseIntArray.put(R.id.desc_text_barrier, 6);
        sparseIntArray.put(R.id.how_to_replace, 7);
        sparseIntArray.put(R.id.buy_new, 8);
    }

    public HolderDeviceNFilterStatusBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 9, sIncludes, sViewsWithIds));
    }

    private HolderDeviceNFilterStatusBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[8], objArr[6], objArr[5], objArr[4], objArr[0], objArr[7], objArr[3], objArr[2], objArr[1]);
        this.mDirtyFlags = -1;
        this.holderDeviceNFilterStatus.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
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
