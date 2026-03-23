package com.blueair.devicedetails.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blueair.devicedetails.BR;
import com.blueair.devicedetails.R;
import com.blueair.devicedetails.viewmodel.DeviceSensorsViewModel;

public class FragmentDeviceSensorsBindingImpl extends FragmentDeviceSensorsBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.sensor_tabs, 1);
        sparseIntArray.put(R.id.device_graph, 2);
        sparseIntArray.put(R.id.device_graph_footer, 3);
        sparseIntArray.put(R.id.fan_value, 4);
        sparseIntArray.put(R.id.button_collapse, 5);
        sparseIntArray.put(R.id.fan_graph, 6);
        sparseIntArray.put(R.id.separator, 7);
    }

    public FragmentDeviceSensorsBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 8, sIncludes, sViewsWithIds));
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private FragmentDeviceSensorsBindingImpl(androidx.databinding.DataBindingComponent r13, android.view.View r14, java.lang.Object[] r15) {
        /*
            r12 = this;
            r0 = 5
            r0 = r15[r0]
            r5 = r0
            com.google.android.material.button.MaterialButton r5 = (com.google.android.material.button.MaterialButton) r5
            r0 = 2
            r0 = r15[r0]
            r6 = r0
            com.blueair.graph.view.IndoorGraphView r6 = (com.blueair.graph.view.IndoorGraphView) r6
            r0 = 3
            r0 = r15[r0]
            r7 = r0
            androidx.constraintlayout.widget.ConstraintLayout r7 = (androidx.constraintlayout.widget.ConstraintLayout) r7
            r0 = 6
            r0 = r15[r0]
            r8 = r0
            com.blueair.graph.view.FanHistoryGraphView r8 = (com.blueair.graph.view.FanHistoryGraphView) r8
            r0 = 4
            r0 = r15[r0]
            r9 = r0
            android.widget.TextView r9 = (android.widget.TextView) r9
            r0 = 1
            r0 = r15[r0]
            r10 = r0
            com.google.android.material.tabs.TabLayout r10 = (com.google.android.material.tabs.TabLayout) r10
            r0 = 7
            r0 = r15[r0]
            r11 = r0
            android.view.View r11 = (android.view.View) r11
            r4 = 0
            r1 = r12
            r2 = r13
            r3 = r14
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r13 = -1
            r1.mDirtyFlags = r13
            r13 = 0
            r13 = r15[r13]
            androidx.constraintlayout.widget.ConstraintLayout r13 = (androidx.constraintlayout.widget.ConstraintLayout) r13
            r1.mboundView0 = r13
            r14 = 0
            r13.setTag(r14)
            r12.setRootTag((android.view.View) r3)
            r12.invalidateAll()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.databinding.FragmentDeviceSensorsBindingImpl.<init>(androidx.databinding.DataBindingComponent, android.view.View, java.lang.Object[]):void");
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
        if (BR.deviceSensorViewModel != i) {
            return false;
        }
        setDeviceSensorViewModel((DeviceSensorsViewModel) obj);
        return true;
    }

    public void setDeviceSensorViewModel(DeviceSensorsViewModel deviceSensorsViewModel) {
        this.mDeviceSensorViewModel = deviceSensorsViewModel;
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0;
        }
    }
}
