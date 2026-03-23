package com.blueair.adddevice.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import com.blueair.adddevice.BR;
import com.blueair.adddevice.R;
import com.blueair.adddevice.viewmodel.AddDeviceViewModel;

public class ActivityAddDeviceBindingImpl extends ActivityAddDeviceBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(5);
        sIncludes = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"viewcore_appbar"}, new int[]{1}, new int[]{R.layout.viewcore_appbar});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.bottomButtonsBarrier, 2);
        sparseIntArray.put(R.id.content_fragment, 3);
        sparseIntArray.put(R.id.help_button, 4);
    }

    public ActivityAddDeviceBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 5, sIncludes, sViewsWithIds));
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private ActivityAddDeviceBindingImpl(androidx.databinding.DataBindingComponent r10, android.view.View r11, java.lang.Object[] r12) {
        /*
            r9 = this;
            r0 = 2
            r0 = r12[r0]
            r5 = r0
            androidx.constraintlayout.widget.Barrier r5 = (androidx.constraintlayout.widget.Barrier) r5
            r0 = 3
            r0 = r12[r0]
            r6 = r0
            android.widget.FrameLayout r6 = (android.widget.FrameLayout) r6
            r0 = 4
            r0 = r12[r0]
            r7 = r0
            androidx.appcompat.widget.AppCompatTextView r7 = (androidx.appcompat.widget.AppCompatTextView) r7
            r0 = 1
            r0 = r12[r0]
            r8 = r0
            com.blueair.adddevice.databinding.ViewcoreAppbarBinding r8 = (com.blueair.adddevice.databinding.ViewcoreAppbarBinding) r8
            r4 = 1
            r1 = r9
            r2 = r10
            r3 = r11
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
            r10 = -1
            r1.mDirtyFlags = r10
            r10 = 0
            r10 = r12[r10]
            androidx.constraintlayout.widget.ConstraintLayout r10 = (androidx.constraintlayout.widget.ConstraintLayout) r10
            r1.mboundView0 = r10
            r11 = 0
            r10.setTag(r11)
            com.blueair.adddevice.databinding.ViewcoreAppbarBinding r10 = r1.viewcoreAppbar
            r9.setContainedBinding(r10)
            r9.setRootTag((android.view.View) r3)
            r9.invalidateAll()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.adddevice.databinding.ActivityAddDeviceBindingImpl.<init>(androidx.databinding.DataBindingComponent, android.view.View, java.lang.Object[]):void");
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 4;
        }
        this.viewcoreAppbar.invalidateAll();
        requestRebind();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        if (r4.viewcoreAppbar.hasPendingBindings() == false) goto L_0x0016;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean hasPendingBindings() {
        /*
            r4 = this;
            monitor-enter(r4)
            long r0 = r4.mDirtyFlags     // Catch:{ all -> 0x0018 }
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            r1 = 1
            if (r0 == 0) goto L_0x000c
            monitor-exit(r4)     // Catch:{ all -> 0x0018 }
            return r1
        L_0x000c:
            monitor-exit(r4)     // Catch:{ all -> 0x0018 }
            com.blueair.adddevice.databinding.ViewcoreAppbarBinding r0 = r4.viewcoreAppbar
            boolean r0 = r0.hasPendingBindings()
            if (r0 == 0) goto L_0x0016
            return r1
        L_0x0016:
            r0 = 0
            return r0
        L_0x0018:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0018 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.adddevice.databinding.ActivityAddDeviceBindingImpl.hasPendingBindings():boolean");
    }

    public boolean setVariable(int i, Object obj) {
        if (BR.addDeviceViewModel != i) {
            return false;
        }
        setAddDeviceViewModel((AddDeviceViewModel) obj);
        return true;
    }

    public void setAddDeviceViewModel(AddDeviceViewModel addDeviceViewModel) {
        this.mAddDeviceViewModel = addDeviceViewModel;
    }

    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.viewcoreAppbar.setLifecycleOwner(lifecycleOwner);
    }

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return onChangeViewcoreAppbar((ViewcoreAppbarBinding) obj, i2);
    }

    private boolean onChangeViewcoreAppbar(ViewcoreAppbarBinding viewcoreAppbarBinding, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0;
        }
        executeBindingsOn(this.viewcoreAppbar);
    }
}
