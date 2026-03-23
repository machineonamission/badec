package com.blueair.android.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blueair.android.R;
import com.blueair.android.viewmodel.OutdoorViewModel;

public class FragmentOutdoorBindingImpl extends FragmentOutdoorBinding {
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
        sparseIntArray.put(R.id.outdoor_title, 1);
        sparseIntArray.put(R.id.rv_location, 2);
        sparseIntArray.put(R.id.page_dots, 3);
    }

    public FragmentOutdoorBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 4, sIncludes, sViewsWithIds));
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private FragmentOutdoorBindingImpl(androidx.databinding.DataBindingComponent r9, android.view.View r10, java.lang.Object[] r11) {
        /*
            r8 = this;
            r0 = 1
            r0 = r11[r0]
            r5 = r0
            android.widget.TextView r5 = (android.widget.TextView) r5
            r0 = 3
            r0 = r11[r0]
            r6 = r0
            com.blueair.android.util.SimpleScrollingPagerIndicator r6 = (com.blueair.android.util.SimpleScrollingPagerIndicator) r6
            r0 = 2
            r0 = r11[r0]
            r7 = r0
            androidx.recyclerview.widget.RecyclerView r7 = (androidx.recyclerview.widget.RecyclerView) r7
            r4 = 0
            r1 = r8
            r2 = r9
            r3 = r10
            r1.<init>(r2, r3, r4, r5, r6, r7)
            r9 = -1
            r1.mDirtyFlags = r9
            r9 = 0
            r9 = r11[r9]
            androidx.constraintlayout.widget.ConstraintLayout r9 = (androidx.constraintlayout.widget.ConstraintLayout) r9
            r1.mboundView0 = r9
            r10 = 0
            r9.setTag(r10)
            r8.setRootTag((android.view.View) r3)
            r8.invalidateAll()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.android.databinding.FragmentOutdoorBindingImpl.<init>(androidx.databinding.DataBindingComponent, android.view.View, java.lang.Object[]):void");
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
        if (9 != i) {
            return false;
        }
        setOutdoorViewModel((OutdoorViewModel) obj);
        return true;
    }

    public void setOutdoorViewModel(OutdoorViewModel outdoorViewModel) {
        this.mOutdoorViewModel = outdoorViewModel;
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0;
        }
    }
}
