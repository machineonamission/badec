package com.blueair.devicedetails.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blueair.devicedetails.R;

public class DialogfragmentBuyFilterV2BindingImpl extends DialogfragmentBuyFilterV2Binding {
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
        sparseIntArray.put(R.id.close_btn, 3);
        sparseIntArray.put(R.id.start_guideline, 4);
        sparseIntArray.put(R.id.end_guideline, 5);
        sparseIntArray.put(R.id.filter_list, 6);
        sparseIntArray.put(R.id.btn_subscribe, 7);
        sparseIntArray.put(R.id.btn_purchase, 8);
        sparseIntArray.put(R.id.discount_hint, 9);
        sparseIntArray.put(R.id.progress_view, 10);
    }

    public DialogfragmentBuyFilterV2BindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 11, sIncludes, sViewsWithIds));
    }

    private DialogfragmentBuyFilterV2BindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[8], objArr[7], objArr[3], objArr[0], objArr[9], objArr[5], objArr[6], objArr[10], objArr[4], objArr[2], objArr[1]);
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
