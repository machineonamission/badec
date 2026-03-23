package com.blueair.devicedetails.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blueair.devicedetails.R;

public class DialogfragmentDeviceSetTimezoneBindingImpl extends DialogfragmentDeviceSetTimezoneBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;

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
        sparseIntArray.put(R.id.screen_title, 1);
        sparseIntArray.put(R.id.close_button, 2);
        sparseIntArray.put(R.id.save_button, 3);
        sparseIntArray.put(R.id.content_container, 4);
        sparseIntArray.put(R.id.separator_1, 5);
        sparseIntArray.put(R.id.search_bar, 6);
        sparseIntArray.put(R.id.search_clear_btn, 7);
        sparseIntArray.put(R.id.current_timezone_label, 8);
        sparseIntArray.put(R.id.local_timezone_label, 9);
        sparseIntArray.put(R.id.separator_2, 10);
        sparseIntArray.put(R.id.timezone_list, 11);
        sparseIntArray.put(R.id.no_results_view, 12);
        sparseIntArray.put(R.id.progressView, 13);
    }

    public DialogfragmentDeviceSetTimezoneBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 14, sIncludes, sViewsWithIds));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private DialogfragmentDeviceSetTimezoneBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[2], objArr[4], objArr[8], objArr[9], objArr[12], objArr[13], objArr[3], objArr[1], objArr[6], objArr[7], objArr[5], objArr[10], objArr[11]);
        this.mDirtyFlags = -1;
        LinearLayout linearLayout = objArr[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag((Object) null);
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
