package com.blueair.devicedetails.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.MutableLiveData;
import com.blueair.devicedetails.BR;
import com.blueair.devicedetails.R;
import com.blueair.devicedetails.viewmodel.CreateUpdateWelcomeHomeViewModel;

public class ActivityWelcomeHomeConfigBindingImpl extends ActivityWelcomeHomeConfigBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.map_container, 12);
        sparseIntArray.put(R.id.statusBar, 13);
        sparseIntArray.put(R.id.btnBack, 14);
        sparseIntArray.put(R.id.btnClose, 15);
        sparseIntArray.put(R.id.gps_btn, 16);
        sparseIntArray.put(R.id.cv_home, 17);
        sparseIntArray.put(R.id.cl_home, 18);
        sparseIntArray.put(R.id.tv_welcomeHome, 19);
        sparseIntArray.put(R.id.iv_welcomeHome, 20);
        sparseIntArray.put(R.id.tv_howArrive, 21);
        sparseIntArray.put(R.id.im_info, 22);
        sparseIntArray.put(R.id.tv_arriveDesp, 23);
        sparseIntArray.put(R.id.ll_transport, 24);
        sparseIntArray.put(R.id.progressView, 25);
    }

    public ActivityWelcomeHomeConfigBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 26, sIncludes, sViewsWithIds));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private ActivityWelcomeHomeConfigBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 8, objArr[14], objArr[15], objArr[11], objArr[10], objArr[18], objArr[17], objArr[16], objArr[5], objArr[22], objArr[20], objArr[24], objArr[12], objArr[25], objArr[0], objArr[13], objArr[1], objArr[23], objArr[7], objArr[6], objArr[4], objArr[9], objArr[21], objArr[3], objArr[2], objArr[8], objArr[19]);
        this.mDirtyFlags = -1;
        this.btnDeleteHome.setTag((Object) null);
        this.btnSave.setTag((Object) null);
        this.groupLocationInfo.setTag((Object) null);
        this.rootLayout.setTag((Object) null);
        this.tvAddress.setTag((Object) null);
        this.tvBicycle.setTag((Object) null);
        this.tvCar.setTag((Object) null);
        this.tvCity.setTag((Object) null);
        this.tvCommute.setTag((Object) null);
        this.tvName.setTag((Object) null);
        this.tvSearchOnMap.setTag((Object) null);
        this.tvWalk.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 512;
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
        if (BR.vm != i) {
            return false;
        }
        setVm((CreateUpdateWelcomeHomeViewModel) obj);
        return true;
    }

    public void setVm(CreateUpdateWelcomeHomeViewModel createUpdateWelcomeHomeViewModel) {
        this.mVm = createUpdateWelcomeHomeViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 256;
        }
        notifyPropertyChanged(BR.vm);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return onChangeVmGotAddress((MutableLiveData) obj, i2);
            case 1:
                return onChangeVmShortAddress((MutableLiveData) obj, i2);
            case 2:
                return onChangeVmWelcomeHomeExist((MutableLiveData) obj, i2);
            case 3:
                return onChangeVmWalk((MutableLiveData) obj, i2);
            case 4:
                return onChangeVmCar((MutableLiveData) obj, i2);
            case 5:
                return onChangeVmBicycle((MutableLiveData) obj, i2);
            case 6:
                return onChangeVmCity((MutableLiveData) obj, i2);
            case 7:
                return onChangeVmCommute((MutableLiveData) obj, i2);
            default:
                return false;
        }
    }

    private boolean onChangeVmGotAddress(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeVmShortAddress(MutableLiveData<String> mutableLiveData, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeVmWelcomeHomeExist(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeVmWalk(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeVmCar(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    private boolean onChangeVmBicycle(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        return true;
    }

    private boolean onChangeVmCity(MutableLiveData<String> mutableLiveData, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        return true;
    }

    private boolean onChangeVmCommute(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 128;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00c0, code lost:
        if (r8 != false) goto L_0x00c6;
     */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0154  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x0170  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x010b  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x012f  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0138  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
            r36 = this;
            r1 = r36
            monitor-enter(r36)
            long r2 = r1.mDirtyFlags     // Catch:{ all -> 0x01f3 }
            r4 = 0
            r1.mDirtyFlags = r4     // Catch:{ all -> 0x01f3 }
            monitor-exit(r36)     // Catch:{ all -> 0x01f3 }
            com.blueair.devicedetails.viewmodel.CreateUpdateWelcomeHomeViewModel r0 = r1.mVm
            r6 = 1023(0x3ff, double:5.054E-321)
            long r6 = r6 & r2
            int r6 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            r11 = 784(0x310, double:3.873E-321)
            r13 = 776(0x308, double:3.834E-321)
            r15 = 800(0x320, double:3.953E-321)
            r17 = 770(0x302, double:3.804E-321)
            r19 = 769(0x301, double:3.8E-321)
            r21 = 772(0x304, double:3.814E-321)
            r23 = r4
            r4 = 0
            if (r6 == 0) goto L_0x0176
            long r25 = r2 & r19
            int r6 = (r25 > r23 ? 1 : (r25 == r23 ? 0 : -1))
            r25 = 8
            if (r6 == 0) goto L_0x005f
            if (r0 == 0) goto L_0x0033
            androidx.lifecycle.MutableLiveData r26 = r0.getGotAddress()
            r5 = r26
            goto L_0x0034
        L_0x0033:
            r5 = 0
        L_0x0034:
            r1.updateLiveDataRegistration(r4, r5)
            if (r5 == 0) goto L_0x0040
            java.lang.Object r5 = r5.getValue()
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            goto L_0x0041
        L_0x0040:
            r5 = 0
        L_0x0041:
            boolean r5 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r5)
            if (r6 == 0) goto L_0x0052
            if (r5 == 0) goto L_0x004d
            r27 = 163840(0x28000, double:8.09477E-319)
            goto L_0x0050
        L_0x004d:
            r27 = 81920(0x14000, double:4.0474E-319)
        L_0x0050:
            long r2 = r2 | r27
        L_0x0052:
            if (r5 == 0) goto L_0x0057
            r6 = r25
            goto L_0x0058
        L_0x0057:
            r6 = r4
        L_0x0058:
            if (r5 == 0) goto L_0x005c
            r5 = r4
            goto L_0x0061
        L_0x005c:
            r5 = r25
            goto L_0x0061
        L_0x005f:
            r5 = r4
            r6 = r5
        L_0x0061:
            long r27 = r2 & r17
            int r27 = (r27 > r23 ? 1 : (r27 == r23 ? 0 : -1))
            if (r27 == 0) goto L_0x0080
            if (r0 == 0) goto L_0x0070
            androidx.lifecycle.MutableLiveData r27 = r0.getShortAddress()
            r4 = r27
            goto L_0x0071
        L_0x0070:
            r4 = 0
        L_0x0071:
            r28 = 896(0x380, double:4.427E-321)
            r7 = 1
            r1.updateLiveDataRegistration(r7, r4)
            if (r4 == 0) goto L_0x0082
            java.lang.Object r4 = r4.getValue()
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x0083
        L_0x0080:
            r28 = 896(0x380, double:4.427E-321)
        L_0x0082:
            r4 = 0
        L_0x0083:
            long r7 = r2 & r21
            int r7 = (r7 > r23 ? 1 : (r7 == r23 ? 0 : -1))
            if (r7 == 0) goto L_0x00c3
            if (r0 == 0) goto L_0x0090
            androidx.lifecycle.MutableLiveData r8 = r0.getWelcomeHomeExist()
            goto L_0x0091
        L_0x0090:
            r8 = 0
        L_0x0091:
            r30 = 832(0x340, double:4.11E-321)
            r9 = 2
            r1.updateLiveDataRegistration(r9, r8)
            if (r8 == 0) goto L_0x00a0
            java.lang.Object r8 = r8.getValue()
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            goto L_0x00a1
        L_0x00a0:
            r8 = 0
        L_0x00a1:
            boolean r8 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r8)
            if (r7 == 0) goto L_0x00af
            if (r8 == 0) goto L_0x00ac
            r9 = 10240(0x2800, double:5.059E-320)
            goto L_0x00ae
        L_0x00ac:
            r9 = 5120(0x1400, double:2.5296E-320)
        L_0x00ae:
            long r2 = r2 | r9
        L_0x00af:
            com.google.android.material.button.MaterialButton r7 = r1.btnSave
            android.content.res.Resources r7 = r7.getResources()
            if (r8 == 0) goto L_0x00ba
            int r9 = com.blueair.viewcore.R.string.action_save_changes
            goto L_0x00bc
        L_0x00ba:
            int r9 = com.blueair.viewcore.R.string.action_confirm_details
        L_0x00bc:
            java.lang.String r7 = r7.getString(r9)
            if (r8 == 0) goto L_0x00c8
            goto L_0x00c6
        L_0x00c3:
            r30 = 832(0x340, double:4.11E-321)
            r7 = 0
        L_0x00c6:
            r25 = 0
        L_0x00c8:
            long r8 = r2 & r13
            int r8 = (r8 > r23 ? 1 : (r8 == r23 ? 0 : -1))
            if (r8 == 0) goto L_0x00e9
            if (r0 == 0) goto L_0x00d5
            androidx.lifecycle.MutableLiveData r8 = r0.getWalk()
            goto L_0x00d6
        L_0x00d5:
            r8 = 0
        L_0x00d6:
            r9 = 3
            r1.updateLiveDataRegistration(r9, r8)
            if (r8 == 0) goto L_0x00e3
            java.lang.Object r8 = r8.getValue()
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            goto L_0x00e4
        L_0x00e3:
            r8 = 0
        L_0x00e4:
            boolean r8 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r8)
            goto L_0x00ea
        L_0x00e9:
            r8 = 0
        L_0x00ea:
            long r9 = r2 & r11
            int r9 = (r9 > r23 ? 1 : (r9 == r23 ? 0 : -1))
            if (r9 == 0) goto L_0x010b
            if (r0 == 0) goto L_0x00f7
            androidx.lifecycle.MutableLiveData r9 = r0.getCar()
            goto L_0x00f8
        L_0x00f7:
            r9 = 0
        L_0x00f8:
            r10 = 4
            r1.updateLiveDataRegistration(r10, r9)
            if (r9 == 0) goto L_0x0105
            java.lang.Object r9 = r9.getValue()
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            goto L_0x0106
        L_0x0105:
            r9 = 0
        L_0x0106:
            boolean r9 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r9)
            goto L_0x010c
        L_0x010b:
            r9 = 0
        L_0x010c:
            long r32 = r2 & r15
            int r10 = (r32 > r23 ? 1 : (r32 == r23 ? 0 : -1))
            if (r10 == 0) goto L_0x012f
            if (r0 == 0) goto L_0x0119
            androidx.lifecycle.MutableLiveData r10 = r0.getBicycle()
            goto L_0x011a
        L_0x0119:
            r10 = 0
        L_0x011a:
            r32 = r11
            r11 = 5
            r1.updateLiveDataRegistration(r11, r10)
            if (r10 == 0) goto L_0x0129
            java.lang.Object r10 = r10.getValue()
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            goto L_0x012a
        L_0x0129:
            r10 = 0
        L_0x012a:
            boolean r10 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r10)
            goto L_0x0132
        L_0x012f:
            r32 = r11
            r10 = 0
        L_0x0132:
            long r11 = r2 & r30
            int r11 = (r11 > r23 ? 1 : (r11 == r23 ? 0 : -1))
            if (r11 == 0) goto L_0x014d
            if (r0 == 0) goto L_0x013f
            androidx.lifecycle.MutableLiveData r11 = r0.getCity()
            goto L_0x0140
        L_0x013f:
            r11 = 0
        L_0x0140:
            r12 = 6
            r1.updateLiveDataRegistration(r12, r11)
            if (r11 == 0) goto L_0x014d
            java.lang.Object r11 = r11.getValue()
            java.lang.String r11 = (java.lang.String) r11
            goto L_0x014e
        L_0x014d:
            r11 = 0
        L_0x014e:
            long r34 = r2 & r28
            int r12 = (r34 > r23 ? 1 : (r34 == r23 ? 0 : -1))
            if (r12 == 0) goto L_0x0170
            if (r0 == 0) goto L_0x015b
            androidx.lifecycle.MutableLiveData r0 = r0.getCommute()
            goto L_0x015c
        L_0x015b:
            r0 = 0
        L_0x015c:
            r12 = 7
            r1.updateLiveDataRegistration(r12, r0)
            if (r0 == 0) goto L_0x0169
            java.lang.Object r0 = r0.getValue()
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            goto L_0x016a
        L_0x0169:
            r0 = 0
        L_0x016a:
            boolean r0 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r0)
            r12 = r11
            goto L_0x0172
        L_0x0170:
            r12 = r11
            r0 = 0
        L_0x0172:
            r11 = r4
            r4 = r25
            goto L_0x0186
        L_0x0176:
            r32 = r11
            r28 = 896(0x380, double:4.427E-321)
            r30 = 832(0x340, double:4.11E-321)
            r0 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
        L_0x0186:
            long r21 = r2 & r21
            int r21 = (r21 > r23 ? 1 : (r21 == r23 ? 0 : -1))
            if (r21 == 0) goto L_0x0199
            r21 = r13
            com.google.android.material.button.MaterialButton r13 = r1.btnDeleteHome
            r13.setVisibility(r4)
            com.google.android.material.button.MaterialButton r4 = r1.btnSave
            androidx.databinding.adapters.TextViewBindingAdapter.setText(r4, r7)
            goto L_0x019b
        L_0x0199:
            r21 = r13
        L_0x019b:
            long r13 = r2 & r19
            int r4 = (r13 > r23 ? 1 : (r13 == r23 ? 0 : -1))
            if (r4 == 0) goto L_0x01ab
            androidx.constraintlayout.widget.Group r4 = r1.groupLocationInfo
            r4.setVisibility(r5)
            androidx.appcompat.widget.AppCompatTextView r4 = r1.tvSearchOnMap
            r4.setVisibility(r6)
        L_0x01ab:
            long r4 = r2 & r17
            int r4 = (r4 > r23 ? 1 : (r4 == r23 ? 0 : -1))
            if (r4 == 0) goto L_0x01bb
            androidx.appcompat.widget.AppCompatTextView r4 = r1.tvAddress
            androidx.databinding.adapters.TextViewBindingAdapter.setText(r4, r11)
            androidx.appcompat.widget.AppCompatTextView r4 = r1.tvName
            androidx.databinding.adapters.TextViewBindingAdapter.setText(r4, r11)
        L_0x01bb:
            long r4 = r2 & r15
            int r4 = (r4 > r23 ? 1 : (r4 == r23 ? 0 : -1))
            if (r4 == 0) goto L_0x01c6
            androidx.appcompat.widget.AppCompatCheckBox r4 = r1.tvBicycle
            androidx.databinding.adapters.CompoundButtonBindingAdapter.setChecked(r4, r10)
        L_0x01c6:
            long r4 = r2 & r32
            int r4 = (r4 > r23 ? 1 : (r4 == r23 ? 0 : -1))
            if (r4 == 0) goto L_0x01d1
            androidx.appcompat.widget.AppCompatCheckBox r4 = r1.tvCar
            androidx.databinding.adapters.CompoundButtonBindingAdapter.setChecked(r4, r9)
        L_0x01d1:
            long r4 = r2 & r30
            int r4 = (r4 > r23 ? 1 : (r4 == r23 ? 0 : -1))
            if (r4 == 0) goto L_0x01dc
            androidx.appcompat.widget.AppCompatTextView r4 = r1.tvCity
            androidx.databinding.adapters.TextViewBindingAdapter.setText(r4, r12)
        L_0x01dc:
            long r4 = r2 & r28
            int r4 = (r4 > r23 ? 1 : (r4 == r23 ? 0 : -1))
            if (r4 == 0) goto L_0x01e7
            androidx.appcompat.widget.AppCompatCheckBox r4 = r1.tvCommute
            androidx.databinding.adapters.CompoundButtonBindingAdapter.setChecked(r4, r0)
        L_0x01e7:
            long r2 = r2 & r21
            int r0 = (r2 > r23 ? 1 : (r2 == r23 ? 0 : -1))
            if (r0 == 0) goto L_0x01f2
            androidx.appcompat.widget.AppCompatCheckBox r0 = r1.tvWalk
            androidx.databinding.adapters.CompoundButtonBindingAdapter.setChecked(r0, r8)
        L_0x01f2:
            return
        L_0x01f3:
            r0 = move-exception
            monitor-exit(r36)     // Catch:{ all -> 0x01f3 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.databinding.ActivityWelcomeHomeConfigBindingImpl.executeBindings():void");
    }
}
