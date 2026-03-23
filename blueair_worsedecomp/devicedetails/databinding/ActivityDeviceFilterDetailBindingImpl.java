package com.blueair.devicedetails.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blueair.devicedetails.R;

public class ActivityDeviceFilterDetailBindingImpl extends ActivityDeviceFilterDetailBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final FrameLayout mboundView0;

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
        sparseIntArray.put(R.id.content_container, 1);
        sparseIntArray.put(R.id.btnBack, 2);
        sparseIntArray.put(R.id.title, 3);
        sparseIntArray.put(R.id.tv_subtitle, 4);
        sparseIntArray.put(R.id.close_btn, 5);
        sparseIntArray.put(R.id.scroll_view, 6);
        sparseIntArray.put(R.id.start_guideline, 7);
        sparseIntArray.put(R.id.end_guideline, 8);
        sparseIntArray.put(R.id.cv_filterLife, 9);
        sparseIntArray.put(R.id.leading_icon, 10);
        sparseIntArray.put(R.id.tv_filterLife, 11);
        sparseIntArray.put(R.id.iv_info, 12);
        sparseIntArray.put(R.id.tv_progress, 13);
        sparseIntArray.put(R.id.bg_filterInfo, 14);
        sparseIntArray.put(R.id.tv_changeFilter, 15);
        sparseIntArray.put(R.id.tv_filterInfo, 16);
        sparseIntArray.put(R.id.progress_indicator, 17);
        sparseIntArray.put(R.id.btn_buy, 18);
        sparseIntArray.put(R.id.btn_reset_filter, 19);
        sparseIntArray.put(R.id.cv_replaceFilter, 20);
        sparseIntArray.put(R.id.video_thumbnail, 21);
        sparseIntArray.put(R.id.icon_play, 22);
        sparseIntArray.put(R.id.tv_guide, 23);
        sparseIntArray.put(R.id.tv_how_replace, 24);
        sparseIntArray.put(R.id.btn_getInstructions, 25);
        sparseIntArray.put(R.id.group_userManual, 26);
        sparseIntArray.put(R.id.available_filters, 27);
        sparseIntArray.put(R.id.filter_list, 28);
        sparseIntArray.put(R.id.btn_visit, 29);
        sparseIntArray.put(R.id.progress_view, 30);
    }

    public ActivityDeviceFilterDetailBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 31, sIncludes, sViewsWithIds));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private ActivityDeviceFilterDetailBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[27], objArr[14], objArr[2], objArr[18], objArr[25], objArr[19], objArr[29], objArr[5], objArr[1], objArr[9], objArr[20], objArr[8], objArr[28], objArr[26], objArr[22], objArr[12], objArr[10], objArr[17], objArr[30], objArr[6], objArr[7], objArr[3], objArr[15], objArr[16], objArr[11], objArr[23], objArr[24], objArr[13], objArr[4], objArr[21]);
        this.mDirtyFlags = -1;
        FrameLayout frameLayout = objArr[0];
        this.mboundView0 = frameLayout;
        frameLayout.setTag((Object) null);
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
