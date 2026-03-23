package com.blueair.devicedetails.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blueair.devicedetails.BR;
import com.blueair.devicedetails.R;
import com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel;

public class DialogfragmentDeviceCreateEditScheduleBindingImpl extends DialogfragmentDeviceCreateEditScheduleBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final CoordinatorLayout mboundView0;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.toolbar, 1);
        sparseIntArray.put(R.id.cancel_btn, 2);
        sparseIntArray.put(R.id.save_btn, 3);
        sparseIntArray.put(R.id.title, 4);
        sparseIntArray.put(R.id.scrollable, 5);
        sparseIntArray.put(R.id.rootLayout, 6);
        sparseIntArray.put(R.id.start_guideline, 7);
        sparseIntArray.put(R.id.end_guideline, 8);
        sparseIntArray.put(R.id.start_time, 9);
        sparseIntArray.put(R.id.end_time, 10);
        sparseIntArray.put(R.id.top_time_barrier, 11);
        sparseIntArray.put(R.id.button_start_time_layout, 12);
        sparseIntArray.put(R.id.button_start_time, 13);
        sparseIntArray.put(R.id.dashed_line, 14);
        sparseIntArray.put(R.id.button_end_time_layout, 15);
        sparseIntArray.put(R.id.button_end_time, 16);
        sparseIntArray.put(R.id.bottom_time_barrier, 17);
        sparseIntArray.put(R.id.progressView, 18);
        sparseIntArray.put(R.id.recycler_view_start_schedule, 19);
        sparseIntArray.put(R.id.textview_repeat, 20);
        sparseIntArray.put(R.id.repeat_container, 21);
        sparseIntArray.put(R.id.text_view_selected_days, 22);
        sparseIntArray.put(R.id.recycler_view_day_picker, 23);
        sparseIntArray.put(R.id.group_label_text, 24);
        sparseIntArray.put(R.id.textview_label, 25);
        sparseIntArray.put(R.id.layout_edit_text_label, 26);
        sparseIntArray.put(R.id.edit_text_label, 27);
        sparseIntArray.put(R.id.group_custom_schedule, 28);
        sparseIntArray.put(R.id.textview_custom_schedule, 29);
        sparseIntArray.put(R.id.radio_group_custom_schedule_settings, 30);
        sparseIntArray.put(R.id.radio_button_previous, 31);
        sparseIntArray.put(R.id.radio_button_custom, 32);
        sparseIntArray.put(R.id.textview_custom_schedule_description, 33);
        sparseIntArray.put(R.id.recycler_view_custom_schedule, 34);
        sparseIntArray.put(R.id.group_after_schedule, 35);
        sparseIntArray.put(R.id.view_after_separator, 36);
        sparseIntArray.put(R.id.textview_after_schedule, 37);
        sparseIntArray.put(R.id.recycler_view_end_schedule, 38);
        sparseIntArray.put(R.id.button_delete_schedule, 39);
    }

    public DialogfragmentDeviceCreateEditScheduleBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 40, sIncludes, sViewsWithIds));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private DialogfragmentDeviceCreateEditScheduleBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[17], objArr[39], objArr[16], objArr[15], objArr[13], objArr[12], objArr[2], objArr[14], objArr[27], objArr[8], objArr[10], objArr[35], objArr[28], objArr[24], objArr[26], objArr[18], objArr[32], objArr[31], objArr[30], objArr[34], objArr[23], objArr[38], objArr[19], objArr[21], objArr[6], objArr[3], objArr[5], objArr[7], objArr[9], objArr[22], objArr[37], objArr[29], objArr[33], objArr[25], objArr[20], objArr[4], objArr[1], objArr[11], objArr[36]);
        this.mDirtyFlags = -1;
        CoordinatorLayout coordinatorLayout = objArr[0];
        this.mboundView0 = coordinatorLayout;
        coordinatorLayout.setTag((Object) null);
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
        if (BR.deviceCreateEditScheduleViewModel != i) {
            return false;
        }
        setDeviceCreateEditScheduleViewModel((DeviceCreateEditScheduleViewModel) obj);
        return true;
    }

    public void setDeviceCreateEditScheduleViewModel(DeviceCreateEditScheduleViewModel deviceCreateEditScheduleViewModel) {
        this.mDeviceCreateEditScheduleViewModel = deviceCreateEditScheduleViewModel;
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0;
        }
    }
}
