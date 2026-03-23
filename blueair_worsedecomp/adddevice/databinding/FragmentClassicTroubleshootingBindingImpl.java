package com.blueair.adddevice.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blueair.adddevice.R;

public class FragmentClassicTroubleshootingBindingImpl extends FragmentClassicTroubleshootingBinding {
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
        sparseIntArray.put(R.id.imgWifiBlinking, 1);
        sparseIntArray.put(R.id.imgWifiFading, 2);
        sparseIntArray.put(R.id.imgWifiFadingFast, 3);
        sparseIntArray.put(R.id.imgWifiSolid, 4);
        sparseIntArray.put(R.id.radioBtnWifiFading, 5);
        sparseIntArray.put(R.id.radioBtnWifiBlinking, 6);
        sparseIntArray.put(R.id.radioBtnWifiFadingFast, 7);
        sparseIntArray.put(R.id.radioBtnWifiSolid, 8);
        sparseIntArray.put(R.id.txtTitle, 9);
        sparseIntArray.put(R.id.txtError, 10);
        sparseIntArray.put(R.id.txtHint, 11);
        sparseIntArray.put(R.id.btnNext, 12);
    }

    public FragmentClassicTroubleshootingBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 13, sIncludes, sViewsWithIds));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private FragmentClassicTroubleshootingBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[12], objArr[1], objArr[2], objArr[3], objArr[4], objArr[6], objArr[5], objArr[7], objArr[8], objArr[0], objArr[10], objArr[11], objArr[9]);
        this.mDirtyFlags = -1;
        this.scrollable.setTag((Object) null);
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
