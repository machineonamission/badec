package com.blueair.devicedetails.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blueair.devicedetails.R;

public class DialogfragmentTimePickerV2BindingImpl extends DialogfragmentTimePickerV2Binding {
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
        sparseIntArray.put(R.id.v_top, 1);
        sparseIntArray.put(R.id.title, 2);
        sparseIntArray.put(R.id.iv_scaleMaskLeft, 3);
        sparseIntArray.put(R.id.iv_scaleMaskRight, 4);
        sparseIntArray.put(R.id.btn_close, 5);
        sparseIntArray.put(R.id.wheel_hour, 6);
        sparseIntArray.put(R.id.tv_colon, 7);
        sparseIntArray.put(R.id.wheel_minute, 8);
        sparseIntArray.put(R.id.wheel_amPm, 9);
        sparseIntArray.put(R.id.tv_hours, 10);
        sparseIntArray.put(R.id.tv_mins, 11);
        sparseIntArray.put(R.id.btn_done, 12);
    }

    public DialogfragmentTimePickerV2BindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 13, sIncludes, sViewsWithIds));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private DialogfragmentTimePickerV2BindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[5], objArr[12], objArr[0], objArr[3], objArr[4], objArr[2], objArr[7], objArr[10], objArr[11], objArr[1], objArr[9], objArr[6], objArr[8]);
        this.mDirtyFlags = -1;
        this.contentContainer.setTag((Object) null);
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
