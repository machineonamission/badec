package com.blueair.devicedetails.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blueair.devicedetails.R;

public class DialogfragmentDeviceNFilterBindingImpl extends DialogfragmentDeviceNFilterBinding {
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
        sparseIntArray.put(R.id.title, 2);
        sparseIntArray.put(R.id.close_btn, 3);
        sparseIntArray.put(R.id.scroll_view, 4);
        sparseIntArray.put(R.id.start_guideline, 5);
        sparseIntArray.put(R.id.end_guideline, 6);
        sparseIntArray.put(R.id.replace_group, 7);
        sparseIntArray.put(R.id.video_thumbnail, 8);
        sparseIntArray.put(R.id.icon_play, 9);
        sparseIntArray.put(R.id.why_is_this_important, 10);
        sparseIntArray.put(R.id.video_summary, 11);
        sparseIntArray.put(R.id.available_filters, 12);
        sparseIntArray.put(R.id.filter_list, 13);
        sparseIntArray.put(R.id.filter_scroll_left, 14);
        sparseIntArray.put(R.id.filter_scroll_right, 15);
        sparseIntArray.put(R.id.btn_anti_fake, 16);
        sparseIntArray.put(R.id.btn_reset_filter, 17);
        sparseIntArray.put(R.id.buy_new_filter, 18);
        sparseIntArray.put(R.id.btn_subscribe, 19);
        sparseIntArray.put(R.id.btn_purchase, 20);
        sparseIntArray.put(R.id.discount_hint, 21);
        sparseIntArray.put(R.id.progress_view, 22);
    }

    public DialogfragmentDeviceNFilterBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 23, sIncludes, sViewsWithIds));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private DialogfragmentDeviceNFilterBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[12], objArr[16], objArr[20], objArr[17], objArr[19], objArr[18], objArr[3], objArr[1], objArr[21], objArr[6], objArr[13], objArr[14], objArr[15], objArr[9], objArr[22], objArr[7], objArr[4], objArr[5], objArr[2], objArr[11], objArr[8], objArr[10]);
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
