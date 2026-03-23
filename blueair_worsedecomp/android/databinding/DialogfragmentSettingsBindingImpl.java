package com.blueair.android.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.MutableLiveData;
import com.blueair.android.R;
import com.blueair.android.viewmodel.HomeViewModel;

public class DialogfragmentSettingsBindingImpl extends DialogfragmentSettingsBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.title_bar_container, 3);
        sparseIntArray.put(R.id.title, 4);
        sparseIntArray.put(R.id.close_btn, 5);
        sparseIntArray.put(R.id.item_notification, 6);
        sparseIntArray.put(R.id.tv_notification, 7);
        sparseIntArray.put(R.id.notification_arrow, 8);
        sparseIntArray.put(R.id.notification_separator, 9);
        sparseIntArray.put(R.id.item_temp_setting, 10);
        sparseIntArray.put(R.id.tv_temp_title, 11);
        sparseIntArray.put(R.id.temp_arrow, 12);
        sparseIntArray.put(R.id.temp_separator, 13);
        sparseIntArray.put(R.id.item_license, 14);
        sparseIntArray.put(R.id.tv_license, 15);
        sparseIntArray.put(R.id.license_arrow, 16);
    }

    public DialogfragmentSettingsBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 17, sIncludes, sViewsWithIds));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private DialogfragmentSettingsBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, objArr[5], objArr[14], objArr[6], objArr[10], objArr[16], objArr[8], objArr[9], objArr[2], objArr[0], objArr[12], objArr[13], objArr[4], objArr[3], objArr[15], objArr[7], objArr[11], objArr[1]);
        this.mDirtyFlags = -1;
        this.progressView.setTag((Object) null);
        this.rootLayout.setTag((Object) null);
        this.tvTempUnit.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 8;
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
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(7);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return onChangeHomeViewModelSettingsLoading((MutableLiveData) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return onChangeHomeViewModelIsTempCelsius((MutableLiveData) obj, i2);
    }

    private boolean onChangeHomeViewModelSettingsLoading(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeHomeViewModelIsTempCelsius(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v2, resolved type: java.lang.Boolean} */
    /* JADX WARNING: type inference failed for: r11v0 */
    /* JADX WARNING: type inference failed for: r11v1, types: [java.lang.CharSequence] */
    /* JADX WARNING: type inference failed for: r11v3 */
    /* JADX WARNING: type inference failed for: r11v9 */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
            r15 = this;
            monitor-enter(r15)
            long r0 = r15.mDirtyFlags     // Catch:{ all -> 0x009d }
            r2 = 0
            r15.mDirtyFlags = r2     // Catch:{ all -> 0x009d }
            monitor-exit(r15)     // Catch:{ all -> 0x009d }
            com.blueair.android.viewmodel.HomeViewModel r4 = r15.mHomeViewModel
            r5 = 15
            long r5 = r5 & r0
            int r5 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            r6 = 14
            r8 = 13
            r10 = 0
            r11 = 0
            if (r5 == 0) goto L_0x0087
            long r12 = r0 & r8
            int r5 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r5 == 0) goto L_0x0046
            if (r4 == 0) goto L_0x0024
            androidx.lifecycle.MutableLiveData r12 = r4.getSettingsLoading()
            goto L_0x0025
        L_0x0024:
            r12 = r11
        L_0x0025:
            r15.updateLiveDataRegistration(r10, r12)
            if (r12 == 0) goto L_0x0031
            java.lang.Object r12 = r12.getValue()
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            goto L_0x0032
        L_0x0031:
            r12 = r11
        L_0x0032:
            boolean r12 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r12)
            if (r5 == 0) goto L_0x0040
            if (r12 == 0) goto L_0x003d
            r13 = 128(0x80, double:6.32E-322)
            goto L_0x003f
        L_0x003d:
            r13 = 64
        L_0x003f:
            long r0 = r0 | r13
        L_0x0040:
            if (r12 == 0) goto L_0x0043
            goto L_0x0046
        L_0x0043:
            r5 = 8
            r10 = r5
        L_0x0046:
            long r12 = r0 & r6
            int r5 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r5 == 0) goto L_0x0087
            if (r4 == 0) goto L_0x0053
            androidx.lifecycle.MutableLiveData r4 = r4.isTempCelsius()
            goto L_0x0054
        L_0x0053:
            r4 = r11
        L_0x0054:
            r12 = 1
            r15.updateLiveDataRegistration(r12, r4)
            if (r4 == 0) goto L_0x0061
            java.lang.Object r4 = r4.getValue()
            r11 = r4
            java.lang.Boolean r11 = (java.lang.Boolean) r11
        L_0x0061:
            boolean r4 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r11)
            if (r5 == 0) goto L_0x006f
            if (r4 == 0) goto L_0x006c
            r11 = 32
            goto L_0x006e
        L_0x006c:
            r11 = 16
        L_0x006e:
            long r0 = r0 | r11
        L_0x006f:
            if (r4 == 0) goto L_0x007a
            android.widget.TextView r4 = r15.tvTempUnit
            android.content.res.Resources r4 = r4.getResources()
            int r5 = com.blueair.viewcore.R.string.temperature_celsius
            goto L_0x0082
        L_0x007a:
            android.widget.TextView r4 = r15.tvTempUnit
            android.content.res.Resources r4 = r4.getResources()
            int r5 = com.blueair.viewcore.R.string.temperature_fahrenheit
        L_0x0082:
            java.lang.String r4 = r4.getString(r5)
            r11 = r4
        L_0x0087:
            long r4 = r0 & r8
            int r4 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x0092
            com.blueair.viewcore.view.ProgressBlockerView r4 = r15.progressView
            r4.setVisibility(r10)
        L_0x0092:
            long r0 = r0 & r6
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto L_0x009c
            android.widget.TextView r0 = r15.tvTempUnit
            androidx.databinding.adapters.TextViewBindingAdapter.setText(r0, r11)
        L_0x009c:
            return
        L_0x009d:
            r0 = move-exception
            monitor-exit(r15)     // Catch:{ all -> 0x009d }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.android.databinding.DialogfragmentSettingsBindingImpl.executeBindings():void");
    }
}
