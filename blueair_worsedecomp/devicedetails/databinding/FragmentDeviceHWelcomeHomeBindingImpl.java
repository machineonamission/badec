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

public class FragmentDeviceHWelcomeHomeBindingImpl extends FragmentDeviceHWelcomeHomeBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.welcome_home_title, 8);
    }

    public FragmentDeviceHWelcomeHomeBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 9, sIncludes, sViewsWithIds));
    }

    private FragmentDeviceHWelcomeHomeBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 4, objArr[2], objArr[5], objArr[4], objArr[3], objArr[6], objArr[7], objArr[1], objArr[8]);
        this.mDirtyFlags = -1;
        this.btnAddHome.setTag((Object) null);
        this.homeAddress.setTag((Object) null);
        this.imLocation.setTag((Object) null);
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
    /* JADX WARNING: Removed duplicated region for block: B:18:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00f4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
            r25 = this;
            r1 = r25
            monitor-enter(r25)
            long r2 = r1.mDirtyFlags     // Catch:{ all -> 0x016f }
            r4 = 0
            r1.mDirtyFlags = r4     // Catch:{ all -> 0x016f }
            monitor-exit(r25)     // Catch:{ all -> 0x016f }
            com.blueair.devicedetails.viewmodel.DeviceWelcomeHomeViewModel r0 = r1.mVm
            r6 = 63
            long r6 = r6 & r2
            int r6 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            r11 = 49
            r13 = 50
            r15 = 0
            r16 = r4
            r4 = 0
            if (r6 == 0) goto L_0x010f
            long r5 = r2 & r11
            int r5 = (r5 > r16 ? 1 : (r5 == r16 ? 0 : -1))
            if (r5 == 0) goto L_0x0035
            if (r0 == 0) goto L_0x0028
            androidx.lifecycle.MutableLiveData r5 = r0.getRadius()
            goto L_0x0029
        L_0x0028:
            r5 = r15
        L_0x0029:
            r1.updateLiveDataRegistration(r4, r5)
            if (r5 == 0) goto L_0x0035
            java.lang.Object r5 = r5.getValue()
            java.lang.String r5 = (java.lang.String) r5
            goto L_0x0036
        L_0x0035:
            r5 = r15
        L_0x0036:
            long r18 = r2 & r13
            int r6 = (r18 > r16 ? 1 : (r18 == r16 ? 0 : -1))
            if (r6 == 0) goto L_0x006f
            if (r0 == 0) goto L_0x0045
            androidx.lifecycle.MutableLiveData r18 = r0.getWelcomeHomeExist()
            r4 = r18
            goto L_0x0046
        L_0x0045:
            r4 = r15
        L_0x0046:
            r19 = 52
            r7 = 1
            r1.updateLiveDataRegistration(r7, r4)
            if (r4 == 0) goto L_0x0055
            java.lang.Object r4 = r4.getValue()
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            goto L_0x0056
        L_0x0055:
            r4 = r15
        L_0x0056:
            boolean r4 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r4)
            if (r6 == 0) goto L_0x0064
            if (r4 == 0) goto L_0x0061
            r6 = 2560(0xa00, double:1.265E-320)
            goto L_0x0063
        L_0x0061:
            r6 = 1280(0x500, double:6.324E-321)
        L_0x0063:
            long r2 = r2 | r6
        L_0x0064:
            r6 = 8
            if (r4 == 0) goto L_0x006a
            r7 = r6
            goto L_0x006b
        L_0x006a:
            r7 = 0
        L_0x006b:
            if (r4 == 0) goto L_0x0073
            r6 = 0
            goto L_0x0073
        L_0x006f:
            r19 = 52
            r6 = 0
            r7 = 0
        L_0x0073:
            long r21 = r2 & r19
            int r4 = (r21 > r16 ? 1 : (r21 == r16 ? 0 : -1))
            if (r4 == 0) goto L_0x00e5
            if (r0 == 0) goto L_0x0080
            androidx.lifecycle.MutableLiveData r8 = r0.getWelcomeHomeEnabled()
            goto L_0x0081
        L_0x0080:
            r8 = r15
        L_0x0081:
            r21 = 56
            r9 = 2
            r1.updateLiveDataRegistration(r9, r8)
            if (r8 == 0) goto L_0x0090
            java.lang.Object r8 = r8.getValue()
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            goto L_0x0091
        L_0x0090:
            r8 = r15
        L_0x0091:
            boolean r8 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r8)
            if (r4 == 0) goto L_0x00a1
            if (r8 == 0) goto L_0x009d
            r9 = 172160(0x2a080, double:8.50583E-319)
            goto L_0x00a0
        L_0x009d:
            r9 = 86080(0x15040, double:4.2529E-319)
        L_0x00a0:
            long r2 = r2 | r9
        L_0x00a1:
            android.widget.TextView r4 = r1.radiusValue
            if (r8 == 0) goto L_0x00a8
            int r9 = com.blueair.viewcore.R.color.blue_severity
            goto L_0x00aa
        L_0x00a8:
            int r9 = com.blueair.viewcore.R.color.light_gray
        L_0x00aa:
            int r4 = getColorFromResource(r4, r9)
            android.widget.ImageView r9 = r1.imLocation
            if (r8 == 0) goto L_0x00b5
            int r10 = com.blueair.viewcore.R.color.blue_severity
            goto L_0x00b7
        L_0x00b5:
            int r10 = com.blueair.viewcore.R.color.light_gray
        L_0x00b7:
            int r9 = getColorFromResource(r9, r10)
            if (r8 == 0) goto L_0x00c4
            android.widget.TextView r10 = r1.homeAddress
            r23 = r11
            int r11 = com.blueair.viewcore.R.color.blue_severity
            goto L_0x00ca
        L_0x00c4:
            r23 = r11
            android.widget.TextView r10 = r1.homeAddress
            int r11 = com.blueair.viewcore.R.color.light_gray
        L_0x00ca:
            int r10 = getColorFromResource(r10, r11)
            if (r8 == 0) goto L_0x00d5
            android.widget.TextView r8 = r1.radius
            int r11 = com.blueair.viewcore.R.color.greyblue
            goto L_0x00d9
        L_0x00d5:
            android.widget.TextView r8 = r1.radius
            int r11 = com.blueair.viewcore.R.color.light_gray
        L_0x00d9:
            int r8 = getColorFromResource(r8, r11)
            r18 = r9
            r9 = r4
            r4 = r18
            r18 = r10
            goto L_0x00ee
        L_0x00e5:
            r23 = r11
            r21 = 56
            r4 = 0
            r8 = 0
            r9 = 0
            r18 = 0
        L_0x00ee:
            long r10 = r2 & r21
            int r10 = (r10 > r16 ? 1 : (r10 == r16 ? 0 : -1))
            if (r10 == 0) goto L_0x0109
            if (r0 == 0) goto L_0x00fb
            androidx.lifecycle.MutableLiveData r0 = r0.getAddress()
            goto L_0x00fc
        L_0x00fb:
            r0 = r15
        L_0x00fc:
            r10 = 3
            r1.updateLiveDataRegistration(r10, r0)
            if (r0 == 0) goto L_0x0109
            java.lang.Object r0 = r0.getValue()
            r15 = r0
            java.lang.String r15 = (java.lang.String) r15
        L_0x0109:
            r0 = r18
            r18 = r4
            r4 = r7
            goto L_0x011d
        L_0x010f:
            r23 = r11
            r19 = 52
            r21 = 56
            r5 = r15
            r0 = 0
            r4 = 0
            r6 = 0
            r8 = 0
            r9 = 0
            r18 = 0
        L_0x011d:
            long r10 = r2 & r13
            int r7 = (r10 > r16 ? 1 : (r10 == r16 ? 0 : -1))
            if (r7 == 0) goto L_0x0132
            com.google.android.material.button.MaterialButton r7 = r1.btnAddHome
            r7.setVisibility(r4)
            androidx.constraintlayout.widget.ConstraintLayout r4 = r1.layoutAddress
            r4.setVisibility(r6)
            com.blueair.viewcore.view.SwitchCompat r4 = r1.welcomeHomeSwitch
            r4.setVisibility(r6)
        L_0x0132:
            long r6 = r2 & r21
            int r4 = (r6 > r16 ? 1 : (r6 == r16 ? 0 : -1))
            if (r4 == 0) goto L_0x013d
            android.widget.TextView r4 = r1.homeAddress
            androidx.databinding.adapters.TextViewBindingAdapter.setText(r4, r15)
        L_0x013d:
            long r6 = r2 & r19
            int r4 = (r6 > r16 ? 1 : (r6 == r16 ? 0 : -1))
            if (r4 == 0) goto L_0x0163
            android.widget.TextView r4 = r1.homeAddress
            r4.setTextColor(r0)
            android.widget.TextView r0 = r1.radius
            r0.setTextColor(r8)
            android.widget.TextView r0 = r1.radiusValue
            r0.setTextColor(r9)
            int r0 = getBuildSdkInt()
            r4 = 21
            if (r0 < r4) goto L_0x0163
            android.widget.ImageView r0 = r1.imLocation
            android.content.res.ColorStateList r4 = androidx.databinding.adapters.Converters.convertColorToColorStateList(r18)
            r0.setImageTintList(r4)
        L_0x0163:
            long r2 = r2 & r23
            int r0 = (r2 > r16 ? 1 : (r2 == r16 ? 0 : -1))
            if (r0 == 0) goto L_0x016e
            android.widget.TextView r0 = r1.radiusValue
            androidx.databinding.adapters.TextViewBindingAdapter.setText(r0, r5)
        L_0x016e:
            return
        L_0x016f:
            r0 = move-exception
            monitor-exit(r25)     // Catch:{ all -> 0x016f }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.databinding.FragmentDeviceHWelcomeHomeBindingImpl.executeBindings():void");
    }
}
