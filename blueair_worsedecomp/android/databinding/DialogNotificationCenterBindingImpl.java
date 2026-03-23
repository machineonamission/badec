package com.blueair.android.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blueair.android.R;

public class DialogNotificationCenterBindingImpl extends DialogNotificationCenterBinding {
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
        sparseIntArray.put(R.id.state_loading_failed, 2);
        sparseIntArray.put(R.id.close_button, 3);
        sparseIntArray.put(R.id.screen_title, 4);
        sparseIntArray.put(R.id.permission_prompt_bar, 5);
        sparseIntArray.put(R.id.group_type_all, 6);
        sparseIntArray.put(R.id.tv_type_all, 7);
        sparseIntArray.put(R.id.switch_type_all, 8);
        sparseIntArray.put(R.id.rv_settings, 9);
        sparseIntArray.put(R.id.group_type_product_alerts, 10);
        sparseIntArray.put(R.id.tv_type_product_alerts, 11);
        sparseIntArray.put(R.id.switch_type_product_alerts, 12);
        sparseIntArray.put(R.id.group_type_product_alerts_limit, 13);
        sparseIntArray.put(R.id.tv_type_product_alerts_limit, 14);
        sparseIntArray.put(R.id.progressView, 15);
    }

    public DialogNotificationCenterBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 16, sIncludes, sViewsWithIds));
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private DialogNotificationCenterBindingImpl(androidx.databinding.DataBindingComponent r20, android.view.View r21, java.lang.Object[] r22) {
        /*
            r19 = this;
            r0 = 3
            r0 = r22[r0]
            r4 = r0
            android.widget.ImageButton r4 = (android.widget.ImageButton) r4
            r0 = 1
            r0 = r22[r0]
            r5 = r0
            androidx.constraintlayout.widget.ConstraintLayout r5 = (androidx.constraintlayout.widget.ConstraintLayout) r5
            r0 = 6
            r0 = r22[r0]
            r6 = r0
            android.widget.LinearLayout r6 = (android.widget.LinearLayout) r6
            r0 = 10
            r0 = r22[r0]
            r7 = r0
            android.widget.LinearLayout r7 = (android.widget.LinearLayout) r7
            r0 = 13
            r0 = r22[r0]
            r8 = r0
            android.widget.LinearLayout r8 = (android.widget.LinearLayout) r8
            r0 = 5
            r0 = r22[r0]
            r9 = r0
            android.widget.TextView r9 = (android.widget.TextView) r9
            r0 = 15
            r0 = r22[r0]
            r10 = r0
            com.blueair.viewcore.view.ProgressBlockerView r10 = (com.blueair.viewcore.view.ProgressBlockerView) r10
            r0 = 9
            r0 = r22[r0]
            r11 = r0
            androidx.recyclerview.widget.RecyclerView r11 = (androidx.recyclerview.widget.RecyclerView) r11
            r0 = 4
            r0 = r22[r0]
            r12 = r0
            android.widget.TextView r12 = (android.widget.TextView) r12
            r0 = 2
            r0 = r22[r0]
            r1 = 0
            if (r0 == 0) goto L_0x0048
            android.view.View r0 = (android.view.View) r0
            com.blueair.viewcore.databinding.StateLoadingFailedBinding r0 = com.blueair.viewcore.databinding.StateLoadingFailedBinding.bind(r0)
            r13 = r0
            goto L_0x0049
        L_0x0048:
            r13 = r1
        L_0x0049:
            r0 = 8
            r0 = r22[r0]
            r14 = r0
            com.blueair.viewcore.view.SwitchCompat r14 = (com.blueair.viewcore.view.SwitchCompat) r14
            r0 = 12
            r0 = r22[r0]
            r15 = r0
            com.blueair.viewcore.view.SwitchCompat r15 = (com.blueair.viewcore.view.SwitchCompat) r15
            r0 = 7
            r0 = r22[r0]
            r16 = r0
            android.widget.TextView r16 = (android.widget.TextView) r16
            r0 = 11
            r0 = r22[r0]
            r17 = r0
            android.widget.TextView r17 = (android.widget.TextView) r17
            r0 = 14
            r0 = r22[r0]
            r18 = r0
            android.widget.TextView r18 = (android.widget.TextView) r18
            r3 = 0
            r0 = r19
            r1 = r20
            r2 = r21
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            r1 = -1
            r0.mDirtyFlags = r1
            androidx.constraintlayout.widget.ConstraintLayout r1 = r0.contentContainer
            r2 = 0
            r1.setTag(r2)
            r1 = 0
            r1 = r22[r1]
            android.widget.LinearLayout r1 = (android.widget.LinearLayout) r1
            r0.mboundView0 = r1
            r1.setTag(r2)
            r2 = r21
            r0.setRootTag((android.view.View) r2)
            r0.invalidateAll()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.android.databinding.DialogNotificationCenterBindingImpl.<init>(androidx.databinding.DataBindingComponent, android.view.View, java.lang.Object[]):void");
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
