package com.blueair.devicedetails.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blueair.devicedetails.R;

public class ActivityDeviceReplaceFilterBindingImpl extends ActivityDeviceReplaceFilterBinding {
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
        sparseIntArray.put(R.id.btnBack, 1);
        sparseIntArray.put(R.id.title, 2);
        sparseIntArray.put(R.id.tv_subtitle, 3);
        sparseIntArray.put(R.id.close_btn, 4);
        sparseIntArray.put(R.id.scroll_view, 5);
        sparseIntArray.put(R.id.start_guideline, 6);
        sparseIntArray.put(R.id.end_guideline, 7);
        sparseIntArray.put(R.id.why_is_this_important, 8);
        sparseIntArray.put(R.id.video_summary, 9);
        sparseIntArray.put(R.id.tv_watchVideo, 10);
        sparseIntArray.put(R.id.sl_replaceFilter, 11);
        sparseIntArray.put(R.id.video_thumbnail, 12);
        sparseIntArray.put(R.id.icon_play, 13);
        sparseIntArray.put(R.id.tv_readManual, 14);
        sparseIntArray.put(R.id.sl_userManual, 15);
        sparseIntArray.put(R.id.iv_userManual, 16);
        sparseIntArray.put(R.id.tv_userManual, 17);
        sparseIntArray.put(R.id.tv_manualInfo, 18);
        sparseIntArray.put(R.id.group_userManual, 19);
        sparseIntArray.put(R.id.btn_reset_filter, 20);
        sparseIntArray.put(R.id.progress_view, 21);
    }

    public ActivityDeviceReplaceFilterBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 22, sIncludes, sViewsWithIds));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private ActivityDeviceReplaceFilterBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[1], objArr[20], objArr[4], objArr[0], objArr[7], objArr[19], objArr[13], objArr[16], objArr[21], objArr[5], objArr[11], objArr[15], objArr[6], objArr[2], objArr[18], objArr[14], objArr[3], objArr[17], objArr[10], objArr[9], objArr[12], objArr[8]);
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
