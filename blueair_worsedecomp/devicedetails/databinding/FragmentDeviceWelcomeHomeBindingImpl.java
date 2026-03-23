package com.blueair.devicedetails.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.MutableLiveData;
import com.blueair.devicedetails.BR;
import com.blueair.devicedetails.R;
import com.blueair.devicedetails.viewmodel.DeviceWelcomeHomeViewModel;

public class FragmentDeviceWelcomeHomeBindingImpl extends FragmentDeviceWelcomeHomeBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.welcome_home_title, 7);
        sparseIntArray.put(R.id.im_location, 8);
    }

    public FragmentDeviceWelcomeHomeBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 9, sIncludes, sViewsWithIds));
    }

    private FragmentDeviceWelcomeHomeBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 4, objArr[2], objArr[4], objArr[8], objArr[3], objArr[5], objArr[6], objArr[1], objArr[7]);
        this.mDirtyFlags = -1;
        this.btnAddHome.setTag((Object) null);
        this.homeAddress.setTag((Object) null);
        this.layoutAddress.setTag((Object) null);
        LinearLayout linearLayout = objArr[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag((Object) null);
        this.radius.setTag((Object) null);
        this.radiusValue.setTag((Object) null);
        this.welcomeHomeSwitch.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 32;
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
        setVm((DeviceWelcomeHomeViewModel) obj);
        return true;
    }

    public void setVm(DeviceWelcomeHomeViewModel deviceWelcomeHomeViewModel) {
        this.mVm = deviceWelcomeHomeViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        notifyPropertyChanged(BR.vm);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return onChangeVmRadius((MutableLiveData) obj, i2);
        }
        if (i == 1) {
            return onChangeVmWelcomeHomeExist((MutableLiveData) obj, i2);
        }
        if (i == 2) {
            return onChangeVmWelcomeHomeEnabled((MutableLiveData) obj, i2);
        }
        if (i != 3) {
            return false;
        }
        return onChangeVmAddress((MutableLiveData) obj, i2);
    }

    private boolean onChangeVmRadius(MutableLiveData<String> mutableLiveData, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeVmWelcomeHomeExist(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeVmWelcomeHomeEnabled(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeVmAddress(MutableLiveData<String> mutableLiveData, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00e7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
            r26 = this;
            r1 = r26
            monitor-enter(r26)
            long r2 = r1.mDirtyFlags     // Catch:{ all -> 0x014e }
            r4 = 0
            r1.mDirtyFlags = r4     // Catch:{ all -> 0x014e }
            monitor-exit(r26)     // Catch:{ all -> 0x014e }
            com.blueair.devicedetails.viewmodel.DeviceWelcomeHomeViewModel r0 = r1.mVm
            r6 = 63
            long r6 = r6 & r2
            int r6 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            r7 = 52
            r9 = 56
            r11 = 49
            r13 = 50
            r15 = 0
            r16 = 0
            if (r6 == 0) goto L_0x0105
            long r17 = r2 & r11
            int r6 = (r17 > r4 ? 1 : (r17 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x0039
            if (r0 == 0) goto L_0x002b
            androidx.lifecycle.MutableLiveData r6 = r0.getRadius()
            goto L_0x002d
        L_0x002b:
            r6 = r16
        L_0x002d:
            r1.updateLiveDataRegistration(r15, r6)
            if (r6 == 0) goto L_0x0039
            java.lang.Object r6 = r6.getValue()
            java.lang.String r6 = (java.lang.String) r6
            goto L_0x003b
        L_0x0039:
            r6 = r16
        L_0x003b:
            long r17 = r2 & r13
            int r17 = (r17 > r4 ? 1 : (r17 == r4 ? 0 : -1))
            if (r17 == 0) goto L_0x007d
            if (r0 == 0) goto L_0x004e
            androidx.lifecycle.MutableLiveData r18 = r0.getWelcomeHomeExist()
            r24 = r4
            r4 = r18
            r18 = r24
            goto L_0x0052
        L_0x004e:
            r18 = r4
            r4 = r16
        L_0x0052:
            r5 = 1
            r1.updateLiveDataRegistration(r5, r4)
            if (r4 == 0) goto L_0x005f
            java.lang.Object r4 = r4.getValue()
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            goto L_0x0061
        L_0x005f:
            r4 = r16
        L_0x0061:
            boolean r4 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r4)
            if (r17 == 0) goto L_0x0070
            if (r4 == 0) goto L_0x006c
            r20 = 2560(0xa00, double:1.265E-320)
            goto L_0x006e
        L_0x006c:
            r20 = 1280(0x500, double:6.324E-321)
        L_0x006e:
            long r2 = r2 | r20
        L_0x0070:
            r5 = 8
            if (r4 == 0) goto L_0x0077
            r17 = r5
            goto L_0x0079
        L_0x0077:
            r17 = r15
        L_0x0079:
            if (r4 == 0) goto L_0x0082
            r5 = r15
            goto L_0x0082
        L_0x007d:
            r18 = r4
            r5 = r15
            r17 = r5
        L_0x0082:
            long r20 = r2 & r7
            int r4 = (r20 > r18 ? 1 : (r20 == r18 ? 0 : -1))
            if (r4 == 0) goto L_0x00dd
            if (r0 == 0) goto L_0x008f
            androidx.lifecycle.MutableLiveData r15 = r0.getWelcomeHomeEnabled()
            goto L_0x0091
        L_0x008f:
            r15 = r16
        L_0x0091:
            r20 = r7
            r7 = 2
            r1.updateLiveDataRegistration(r7, r15)
            if (r15 == 0) goto L_0x00a0
            java.lang.Object r7 = r15.getValue()
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            goto L_0x00a2
        L_0x00a0:
            r7 = r16
        L_0x00a2:
            boolean r7 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r7)
            if (r4 == 0) goto L_0x00b2
            if (r7 == 0) goto L_0x00ae
            r22 = 41088(0xa080, double:2.03E-319)
            goto L_0x00b0
        L_0x00ae:
            r22 = 20544(0x5040, double:1.015E-319)
        L_0x00b0:
            long r2 = r2 | r22
        L_0x00b2:
            android.widget.TextView r4 = r1.radiusValue
            if (r7 == 0) goto L_0x00b9
            int r8 = com.blueair.viewcore.R.color.blue_severity
            goto L_0x00bb
        L_0x00b9:
            int r8 = com.blueair.viewcore.R.color.light_gray
        L_0x00bb:
            int r4 = getColorFromResource(r4, r8)
            android.widget.TextView r8 = r1.homeAddress
            if (r7 == 0) goto L_0x00c6
            int r15 = com.blueair.viewcore.R.color.blue_severity
            goto L_0x00c8
        L_0x00c6:
            int r15 = com.blueair.viewcore.R.color.light_gray
        L_0x00c8:
            int r8 = getColorFromResource(r8, r15)
            if (r7 == 0) goto L_0x00d3
            android.widget.TextView r7 = r1.radius
            int r15 = com.blueair.viewcore.R.color.greyblue
            goto L_0x00d7
        L_0x00d3:
            android.widget.TextView r7 = r1.radius
            int r15 = com.blueair.viewcore.R.color.light_gray
        L_0x00d7:
            int r7 = getColorFromResource(r7, r15)
            r15 = r8
            goto L_0x00e1
        L_0x00dd:
            r20 = r7
            r4 = r15
            r7 = r4
        L_0x00e1:
            long r22 = r2 & r9
            int r8 = (r22 > r18 ? 1 : (r22 == r18 ? 0 : -1))
            if (r8 == 0) goto L_0x00fe
            if (r0 == 0) goto L_0x00ee
            androidx.lifecycle.MutableLiveData r0 = r0.getAddress()
            goto L_0x00f0
        L_0x00ee:
            r0 = r16
        L_0x00f0:
            r8 = 3
            r1.updateLiveDataRegistration(r8, r0)
            if (r0 == 0) goto L_0x00fe
            java.lang.Object r0 = r0.getValue()
            r16 = r0
            java.lang.String r16 = (java.lang.String) r16
        L_0x00fe:
            r8 = r6
            r0 = r15
            r6 = r16
            r15 = r17
            goto L_0x0110
        L_0x0105:
            r18 = r4
            r20 = r7
            r0 = r15
            r4 = r0
            r5 = r4
            r7 = r5
            r6 = r16
            r8 = r6
        L_0x0110:
            long r13 = r13 & r2
            int r13 = (r13 > r18 ? 1 : (r13 == r18 ? 0 : -1))
            if (r13 == 0) goto L_0x0124
            com.google.android.material.button.MaterialButton r13 = r1.btnAddHome
            r13.setVisibility(r15)
            androidx.constraintlayout.widget.ConstraintLayout r13 = r1.layoutAddress
            r13.setVisibility(r5)
            com.blueair.viewcore.view.SwitchCompat r13 = r1.welcomeHomeSwitch
            r13.setVisibility(r5)
        L_0x0124:
            long r9 = r9 & r2
            int r5 = (r9 > r18 ? 1 : (r9 == r18 ? 0 : -1))
            if (r5 == 0) goto L_0x012e
            android.widget.TextView r5 = r1.homeAddress
            androidx.databinding.adapters.TextViewBindingAdapter.setText(r5, r6)
        L_0x012e:
            long r5 = r2 & r20
            int r5 = (r5 > r18 ? 1 : (r5 == r18 ? 0 : -1))
            if (r5 == 0) goto L_0x0143
            android.widget.TextView r5 = r1.homeAddress
            r5.setTextColor(r0)
            android.widget.TextView r0 = r1.radius
            r0.setTextColor(r7)
            android.widget.TextView r0 = r1.radiusValue
            r0.setTextColor(r4)
        L_0x0143:
            long r2 = r2 & r11
            int r0 = (r2 > r18 ? 1 : (r2 == r18 ? 0 : -1))
            if (r0 == 0) goto L_0x014d
            android.widget.TextView r0 = r1.radiusValue
            androidx.databinding.adapters.TextViewBindingAdapter.setText(r0, r8)
        L_0x014d:
            return
        L_0x014e:
            r0 = move-exception
            monitor-exit(r26)     // Catch:{ all -> 0x014e }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.databinding.FragmentDeviceWelcomeHomeBindingImpl.executeBindings():void");
    }
}
