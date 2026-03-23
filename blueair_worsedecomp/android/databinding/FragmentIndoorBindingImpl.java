package com.blueair.android.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blueair.android.R;
import com.blueair.android.viewmodel.IndoorViewModel;

public class FragmentIndoorBindingImpl extends FragmentIndoorBinding {
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
        sparseIntArray.put(R.id.sl_alarm, 1);
        sparseIntArray.put(R.id.iv_alarm, 2);
        sparseIntArray.put(R.id.tv_alarmLabel, 3);
        sparseIntArray.put(R.id.tv_alarmValue, 4);
        sparseIntArray.put(R.id.listDevices, 5);
        sparseIntArray.put(R.id.iv_addFooter, 6);
        sparseIntArray.put(R.id.emptyLayout, 7);
        sparseIntArray.put(R.id.textEmptyTitle, 8);
        sparseIntArray.put(R.id.btn_addProduct, 9);
    }

    public FragmentIndoorBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 10, sIncludes, sViewsWithIds));
    }

    private FragmentIndoorBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[9], objArr[7], objArr[6], objArr[2], objArr[0], objArr[5], objArr[1], objArr[8], objArr[3], objArr[4]);
        this.mDirtyFlags = -1;
        this.layoutMain.setTag((Object) null);
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
        if (8 != i) {
            return false;
        }
        setIndoorViewModel((IndoorViewModel) obj);
        return true;
    }

    public void setIndoorViewModel(IndoorViewModel indoorViewModel) {
        this.mIndoorViewModel = indoorViewModel;
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0;
        }
    }
}
