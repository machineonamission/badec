package com.blueair.android.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blueair.android.R;

public class DialogAqiIndexInfoBindingImpl extends DialogAqiIndexInfoBinding {
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
        sparseIntArray.put(R.id.close_button, 1);
        sparseIntArray.put(R.id.content_container, 2);
        sparseIntArray.put(R.id.introduction_index, 3);
        sparseIntArray.put(R.id.index_level_excellent_label, 4);
        sparseIntArray.put(R.id.index_level_excellent_content, 5);
        sparseIntArray.put(R.id.index_level_good_label, 6);
        sparseIntArray.put(R.id.index_level_good_content, 7);
        sparseIntArray.put(R.id.index_level_moderate_label, 8);
        sparseIntArray.put(R.id.index_level_moderate_content, 9);
        sparseIntArray.put(R.id.index_level_polluted_label, 10);
        sparseIntArray.put(R.id.index_level_polluted_content, 11);
        sparseIntArray.put(R.id.index_level_vpolluted_label, 12);
        sparseIntArray.put(R.id.index_level_vpolluted_content, 13);
        sparseIntArray.put(R.id.sub_title_particles, 14);
        sparseIntArray.put(R.id.dot_pm25, 15);
        sparseIntArray.put(R.id.introduction_pm25, 16);
        sparseIntArray.put(R.id.dot_pm10, 17);
        sparseIntArray.put(R.id.introduction_pm10, 18);
        sparseIntArray.put(R.id.sub_title_gases, 19);
        sparseIntArray.put(R.id.dot_co, 20);
        sparseIntArray.put(R.id.introduction_co, 21);
        sparseIntArray.put(R.id.dot_so2, 22);
        sparseIntArray.put(R.id.introduction_so2, 23);
    }

    public DialogAqiIndexInfoBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 24, sIncludes, sViewsWithIds));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private DialogAqiIndexInfoBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[1], objArr[2], objArr[20], objArr[17], objArr[15], objArr[22], objArr[5], objArr[4], objArr[7], objArr[6], objArr[9], objArr[8], objArr[11], objArr[10], objArr[13], objArr[12], objArr[21], objArr[3], objArr[18], objArr[16], objArr[23], objArr[19], objArr[14]);
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
