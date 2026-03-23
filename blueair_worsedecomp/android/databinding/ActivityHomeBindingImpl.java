package com.blueair.android.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.blueair.android.R;
import com.blueair.android.generated.callback.OnRefreshListener;
import com.blueair.android.viewmodel.HomeViewModel;
import com.blueair.viewcore.view.AbsorbInsetFrameLayout;

public class ActivityHomeBindingImpl extends ActivityHomeBinding implements OnRefreshListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final SwipeRefreshLayout.OnRefreshListener mCallback1;
    private long mDirtyFlags;
    private final AbsorbInsetFrameLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.drawerLayout, 4);
        sparseIntArray.put(R.id.aqi_animation_background, 5);
        sparseIntArray.put(R.id.toolbar, 6);
        sparseIntArray.put(R.id.btn_menu, 7);
        sparseIntArray.put(R.id.btn_add, 8);
        sparseIntArray.put(R.id.content_container, 9);
        sparseIntArray.put(R.id.cl_header, 10);
        sparseIntArray.put(R.id.tv_indoorLabel, 11);
        sparseIntArray.put(R.id.cs_notification, 12);
        sparseIntArray.put(R.id.outdoor_container, 13);
        sparseIntArray.put(R.id.indoor_container, 14);
        sparseIntArray.put(R.id.nv_drawer, 15);
        sparseIntArray.put(R.id.cl_drawer, 16);
        sparseIntArray.put(R.id.statusBar_drawer, 17);
        sparseIntArray.put(R.id.drawer_close_view, 18);
        sparseIntArray.put(R.id.tv_menu, 19);
        sparseIntArray.put(R.id.ll_drawerHeader, 20);
        sparseIntArray.put(R.id.iv_leading, 21);
        sparseIntArray.put(R.id.tv_name, 22);
        sparseIntArray.put(R.id.rv_drawer, 23);
        sparseIntArray.put(R.id.drawer_signin, 24);
        sparseIntArray.put(R.id.build, 25);
    }

    public ActivityHomeBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 26, sIncludes, sViewsWithIds));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private ActivityHomeBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, objArr[5], objArr[8], objArr[7], objArr[25], objArr[16], objArr[10], objArr[9], objArr[12], objArr[18], objArr[4], objArr[24], objArr[14], objArr[21], objArr[20], objArr[15], objArr[13], objArr[23], objArr[17], objArr[1], objArr[6], objArr[3], objArr[2], objArr[11], objArr[19], objArr[22]);
        this.mDirtyFlags = -1;
        AbsorbInsetFrameLayout absorbInsetFrameLayout = objArr[0];
        this.mboundView0 = absorbInsetFrameLayout;
        absorbInsetFrameLayout.setTag((Object) null);
        this.swipeRefresh.setTag((Object) null);
        this.tvIndoorAirState.setTag((Object) null);
        this.tvIndoorDeviceNum.setTag((Object) null);
        setRootTag(view);
        this.mCallback1 = new OnRefreshListener(this, 1);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 16;
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
        if (7 != i) {
            return false;
        }
        setHomeViewModel((HomeViewModel) obj);
        return true;
    }

    public void setHomeViewModel(HomeViewModel homeViewModel) {
        this.mHomeViewModel = homeViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(7);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return onChangeHomeViewModelDeviceNum((MutableLiveData) obj, i2);
        }
        if (i == 1) {
            return onChangeHomeViewModelLvAirStateStringRes((MutableLiveData) obj, i2);
        }
        if (i != 2) {
            return false;
        }
        return onChangeHomeViewModelIsLoading((MediatorLiveData) obj, i2);
    }

    private boolean onChangeHomeViewModelDeviceNum(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeHomeViewModelLvAirStateStringRes(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeHomeViewModelIsLoading(MediatorLiveData<Boolean> mediatorLiveData, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v3, resolved type: java.lang.Boolean} */
    /* JADX WARNING: type inference failed for: r14v0 */
    /* JADX WARNING: type inference failed for: r14v1, types: [java.lang.CharSequence] */
    /* JADX WARNING: type inference failed for: r14v2 */
    /* JADX WARNING: type inference failed for: r14v6 */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
            r22 = this;
            r1 = r22
            monitor-enter(r22)
            long r2 = r1.mDirtyFlags     // Catch:{ all -> 0x00df }
            r4 = 0
            r1.mDirtyFlags = r4     // Catch:{ all -> 0x00df }
            monitor-exit(r22)     // Catch:{ all -> 0x00df }
            com.blueair.android.viewmodel.HomeViewModel r0 = r1.mHomeViewModel
            r6 = 31
            long r6 = r6 & r2
            int r6 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            r7 = 26
            r9 = 28
            r11 = 25
            r13 = 0
            r14 = 0
            if (r6 == 0) goto L_0x00a8
            long r15 = r2 & r11
            int r6 = (r15 > r4 ? 1 : (r15 == r4 ? 0 : -1))
            r15 = 1
            if (r6 == 0) goto L_0x0062
            if (r0 == 0) goto L_0x002f
            androidx.lifecycle.MutableLiveData r16 = r0.getDeviceNum()
            r20 = r4
            r4 = r16
            r16 = r20
            goto L_0x0032
        L_0x002f:
            r16 = r4
            r4 = r14
        L_0x0032:
            r1.updateLiveDataRegistration(r13, r4)
            if (r4 == 0) goto L_0x003e
            java.lang.Object r4 = r4.getValue()
            java.lang.Integer r4 = (java.lang.Integer) r4
            goto L_0x003f
        L_0x003e:
            r4 = r14
        L_0x003f:
            int r5 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Integer) r4)
            if (r4 == 0) goto L_0x004a
            java.lang.String r4 = r4.toString()
            goto L_0x004b
        L_0x004a:
            r4 = r14
        L_0x004b:
            if (r5 <= 0) goto L_0x004f
            r5 = r15
            goto L_0x0050
        L_0x004f:
            r5 = r13
        L_0x0050:
            if (r6 == 0) goto L_0x005b
            if (r5 == 0) goto L_0x0057
            r18 = 64
            goto L_0x0059
        L_0x0057:
            r18 = 32
        L_0x0059:
            long r2 = r2 | r18
        L_0x005b:
            if (r5 == 0) goto L_0x005f
            r5 = r13
            goto L_0x0066
        L_0x005f:
            r5 = 8
            goto L_0x0066
        L_0x0062:
            r16 = r4
            r5 = r13
            r4 = r14
        L_0x0066:
            long r18 = r2 & r7
            int r6 = (r18 > r16 ? 1 : (r18 == r16 ? 0 : -1))
            if (r6 == 0) goto L_0x0086
            if (r0 == 0) goto L_0x0073
            androidx.lifecycle.MutableLiveData r6 = r0.getLvAirStateStringRes()
            goto L_0x0074
        L_0x0073:
            r6 = r14
        L_0x0074:
            r1.updateLiveDataRegistration(r15, r6)
            if (r6 == 0) goto L_0x0080
            java.lang.Object r6 = r6.getValue()
            java.lang.Integer r6 = (java.lang.Integer) r6
            goto L_0x0081
        L_0x0080:
            r6 = r14
        L_0x0081:
            int r6 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Integer) r6)
            goto L_0x0087
        L_0x0086:
            r6 = r13
        L_0x0087:
            long r18 = r2 & r9
            int r15 = (r18 > r16 ? 1 : (r18 == r16 ? 0 : -1))
            if (r15 == 0) goto L_0x00a6
            if (r0 == 0) goto L_0x0094
            androidx.lifecycle.MediatorLiveData r0 = r0.isLoading()
            goto L_0x0095
        L_0x0094:
            r0 = r14
        L_0x0095:
            r13 = 2
            r1.updateLiveDataRegistration(r13, r0)
            if (r0 == 0) goto L_0x00a2
            java.lang.Object r0 = r0.getValue()
            r14 = r0
            java.lang.Boolean r14 = (java.lang.Boolean) r14
        L_0x00a2:
            boolean r13 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r14)
        L_0x00a6:
            r14 = r4
            goto L_0x00ac
        L_0x00a8:
            r16 = r4
            r5 = r13
            r6 = r5
        L_0x00ac:
            r18 = 16
            long r18 = r2 & r18
            int r0 = (r18 > r16 ? 1 : (r18 == r16 ? 0 : -1))
            if (r0 == 0) goto L_0x00bb
            androidx.swiperefreshlayout.widget.SwipeRefreshLayout r0 = r1.swipeRefresh
            androidx.swiperefreshlayout.widget.SwipeRefreshLayout$OnRefreshListener r4 = r1.mCallback1
            r0.setOnRefreshListener(r4)
        L_0x00bb:
            long r9 = r9 & r2
            int r0 = (r9 > r16 ? 1 : (r9 == r16 ? 0 : -1))
            if (r0 == 0) goto L_0x00c5
            androidx.swiperefreshlayout.widget.SwipeRefreshLayout r0 = r1.swipeRefresh
            r0.setRefreshing(r13)
        L_0x00c5:
            long r7 = r7 & r2
            int r0 = (r7 > r16 ? 1 : (r7 == r16 ? 0 : -1))
            if (r0 == 0) goto L_0x00cf
            android.widget.TextView r0 = r1.tvIndoorAirState
            r0.setText(r6)
        L_0x00cf:
            long r2 = r2 & r11
            int r0 = (r2 > r16 ? 1 : (r2 == r16 ? 0 : -1))
            if (r0 == 0) goto L_0x00de
            androidx.appcompat.widget.AppCompatTextView r0 = r1.tvIndoorDeviceNum
            androidx.databinding.adapters.TextViewBindingAdapter.setText(r0, r14)
            androidx.appcompat.widget.AppCompatTextView r0 = r1.tvIndoorDeviceNum
            r0.setVisibility(r5)
        L_0x00de:
            return
        L_0x00df:
            r0 = move-exception
            monitor-exit(r22)     // Catch:{ all -> 0x00df }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.android.databinding.ActivityHomeBindingImpl.executeBindings():void");
    }

    public final void _internalCallbackOnRefresh(int i) {
        HomeViewModel homeViewModel = this.mHomeViewModel;
        if (homeViewModel != null) {
            homeViewModel.onSwipeToRefresh();
        }
    }
}
