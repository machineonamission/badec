package com.blueair.devicedetails.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blueair.devicedetails.R;

public class DialogfragmentDeviceHTimerPickerBindingImpl extends DialogfragmentDeviceHTimerPickerBinding {
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
        sparseIntArray.put(R.id.timer_picker, 3);
        sparseIntArray.put(R.id.content_container_button, 4);
        sparseIntArray.put(R.id.timer_picker_cancel, 5);
        sparseIntArray.put(R.id.timer_picker_done, 6);
    }

    public DialogfragmentDeviceHTimerPickerBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 7, sIncludes, sViewsWithIds));
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private DialogfragmentDeviceHTimerPickerBindingImpl(androidx.databinding.DataBindingComponent r12, android.view.View r13, java.lang.Object[] r14) {
        /*
            r11 = this;
            r0 = 1
            r0 = r14[r0]
            r5 = r0
            androidx.constraintlayout.widget.ConstraintLayout r5 = (androidx.constraintlayout.widget.ConstraintLayout) r5
            r0 = 4
            r0 = r14[r0]
            r6 = r0
            android.widget.LinearLayout r6 = (android.widget.LinearLayout) r6
            r0 = 3
            r0 = r14[r0]
            r7 = r0
            com.github.gzuliyujiang.wheelview.widget.WheelView r7 = (com.github.gzuliyujiang.wheelview.widget.WheelView) r7
            r0 = 5
            r0 = r14[r0]
            r8 = r0
            com.google.android.material.button.MaterialButton r8 = (com.google.android.material.button.MaterialButton) r8
            r0 = 6
            r0 = r14[r0]
            r9 = r0
            com.google.android.material.button.MaterialButton r9 = (com.google.android.material.button.MaterialButton) r9
            r0 = 2
            r0 = r14[r0]
            r10 = r0
            android.widget.TextView r10 = (android.widget.TextView) r10
            r4 = 0
            r1 = r11
            r2 = r12
            r3 = r13
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r12 = -1
            r1.mDirtyFlags = r12
            r12 = 0
            r12 = r14[r12]
            android.widget.FrameLayout r12 = (android.widget.FrameLayout) r12
            r1.mboundView0 = r12
            r13 = 0
            r12.setTag(r13)
            r11.setRootTag((android.view.View) r3)
            r11.invalidateAll()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.databinding.DialogfragmentDeviceHTimerPickerBindingImpl.<init>(androidx.databinding.DataBindingComponent, android.view.View, java.lang.Object[]):void");
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
