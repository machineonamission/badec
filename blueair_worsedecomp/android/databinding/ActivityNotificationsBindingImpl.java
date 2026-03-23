package com.blueair.android.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.lifecycle.MutableLiveData;
import com.blueair.android.R;
import com.blueair.android.viewmodel.NotificationsViewModel;

public class ActivityNotificationsBindingImpl extends ActivityNotificationsBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.btnBack, 2);
        sparseIntArray.put(R.id.tv_title, 3);
        sparseIntArray.put(R.id.tv_labelNew, 4);
        sparseIntArray.put(R.id.tv_dismissAll, 5);
        sparseIntArray.put(R.id.rv_list, 6);
    }

    public ActivityNotificationsBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 7, sIncludes, sViewsWithIds));
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private ActivityNotificationsBindingImpl(androidx.databinding.DataBindingComponent r12, android.view.View r13, java.lang.Object[] r14) {
        /*
            r11 = this;
            r0 = 2
            r0 = r14[r0]
            r5 = r0
            androidx.appcompat.widget.AppCompatImageButton r5 = (androidx.appcompat.widget.AppCompatImageButton) r5
            r0 = 6
            r0 = r14[r0]
            r6 = r0
            androidx.recyclerview.widget.RecyclerView r6 = (androidx.recyclerview.widget.RecyclerView) r6
            r0 = 5
            r0 = r14[r0]
            r7 = r0
            androidx.appcompat.widget.AppCompatTextView r7 = (androidx.appcompat.widget.AppCompatTextView) r7
            r0 = 1
            r0 = r14[r0]
            r8 = r0
            androidx.appcompat.widget.AppCompatTextView r8 = (androidx.appcompat.widget.AppCompatTextView) r8
            r0 = 4
            r0 = r14[r0]
            r9 = r0
            androidx.appcompat.widget.AppCompatTextView r9 = (androidx.appcompat.widget.AppCompatTextView) r9
            r0 = 3
            r0 = r14[r0]
            r10 = r0
            androidx.appcompat.widget.AppCompatTextView r10 = (androidx.appcompat.widget.AppCompatTextView) r10
            r4 = 1
            r1 = r11
            r2 = r12
            r3 = r13
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r12 = -1
            r1.mDirtyFlags = r12
            r12 = 0
            r12 = r14[r12]
            androidx.constraintlayout.widget.ConstraintLayout r12 = (androidx.constraintlayout.widget.ConstraintLayout) r12
            r1.mboundView0 = r12
            r13 = 0
            r12.setTag(r13)
            androidx.appcompat.widget.AppCompatTextView r12 = r1.tvIndoorDeviceNum
            r12.setTag(r13)
            r11.setRootTag((android.view.View) r3)
            r11.invalidateAll()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.android.databinding.ActivityNotificationsBindingImpl.<init>(androidx.databinding.DataBindingComponent, android.view.View, java.lang.Object[]):void");
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 4;
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
        if (10 != i) {
            return false;
        }
        setViewModel((NotificationsViewModel) obj);
        return true;
    }

    public void setViewModel(NotificationsViewModel notificationsViewModel) {
        this.mViewModel = notificationsViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return onChangeViewModelNotificationsNum((MutableLiveData) obj, i2);
    }

    private boolean onChangeViewModelNotificationsNum(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        NotificationsViewModel notificationsViewModel = this.mViewModel;
        int i = ((j & 7) > 0 ? 1 : ((j & 7) == 0 ? 0 : -1));
        String str = null;
        int i2 = 0;
        if (i != 0) {
            MutableLiveData<Integer> notificationsNum = notificationsViewModel != null ? notificationsViewModel.getNotificationsNum() : null;
            updateLiveDataRegistration(0, notificationsNum);
            Integer value = notificationsNum != null ? notificationsNum.getValue() : null;
            int safeUnbox = ViewDataBinding.safeUnbox(value);
            if (value != null) {
                str = value.toString();
            }
            boolean z = safeUnbox > 0;
            if (i != 0) {
                j |= z ? 16 : 8;
            }
            if (!z) {
                i2 = 8;
            }
        }
        if ((j & 7) != 0) {
            TextViewBindingAdapter.setText(this.tvIndoorDeviceNum, str);
            this.tvIndoorDeviceNum.setVisibility(i2);
        }
    }
}
