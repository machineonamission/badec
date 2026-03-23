package com.blueair.android.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blueair.android.R;
import com.blueair.android.viewmodel.HomeViewModel;

public class FragmentPoliciesBindingImpl extends FragmentPoliciesBinding {
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
        sparseIntArray.put(R.id.privacy_policy_clickview, 1);
        sparseIntArray.put(R.id.privacy_left_guideline, 2);
        sparseIntArray.put(R.id.privacy_right_guideline, 3);
        sparseIntArray.put(R.id.privacy_policy_title, 4);
        sparseIntArray.put(R.id.privacy_policy_arrow, 5);
        sparseIntArray.put(R.id.privacy_separator, 6);
        sparseIntArray.put(R.id.icp_no, 7);
    }

    public FragmentPoliciesBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 8, sIncludes, sViewsWithIds));
    }

    private FragmentPoliciesBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[7], objArr[2], objArr[5], objArr[1], objArr[4], objArr[3], objArr[6], objArr[0]);
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
        if (7 != i) {
            return false;
        }
        setHomeViewModel((HomeViewModel) obj);
        return true;
    }

    public void setHomeViewModel(HomeViewModel homeViewModel) {
        this.mHomeViewModel = homeViewModel;
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0;
        }
    }
}
