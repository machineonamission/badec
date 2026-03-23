package com.blueair.login.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.blueair.login.BR;
import com.blueair.login.R;
import com.blueair.login.SignInViewModel;

public class FragmentSignInBindingImpl extends FragmentSignInBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private InverseBindingListener cbPrivacyandroidCheckedAttrChanged;
    private InverseBindingListener emailandroidTextAttrChanged;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;
    private InverseBindingListener passwordandroidTextAttrChanged;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.txt_welcomeBack, 7);
        sparseIntArray.put(R.id.txtEmail, 8);
        sparseIntArray.put(R.id.txtPassword, 9);
        sparseIntArray.put(R.id.btnForgotPassword, 10);
        sparseIntArray.put(R.id.privacy_text, 11);
        sparseIntArray.put(R.id.group_privacy, 12);
        sparseIntArray.put(R.id.txtRegisterTitle, 13);
        sparseIntArray.put(R.id.btnRegister, 14);
        sparseIntArray.put(R.id.toolbar, 15);
        sparseIntArray.put(R.id.iv_back, 16);
        sparseIntArray.put(R.id.iv_close, 17);
    }

    public FragmentSignInBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 18, sIncludes, sViewsWithIds));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private FragmentSignInBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 5, objArr[10], objArr[6], objArr[14], objArr[5], objArr[1], objArr[12], objArr[16], objArr[17], objArr[3], objArr[11], objArr[15], objArr[8], objArr[2], objArr[9], objArr[4], objArr[13], objArr[7]);
        this.cbPrivacyandroidCheckedAttrChanged = new InverseBindingListener() {
            public void onChange() {
                MutableLiveData<Boolean> confirmPrivacy;
                boolean isChecked = FragmentSignInBindingImpl.this.cbPrivacy.isChecked();
                SignInViewModel signInViewModel = FragmentSignInBindingImpl.this.mViewModel;
                if (signInViewModel != null && (confirmPrivacy = signInViewModel.getConfirmPrivacy()) != null) {
                    confirmPrivacy.setValue(Boolean.valueOf(isChecked));
                }
            }
        };
        this.emailandroidTextAttrChanged = new InverseBindingListener() {
            public void onChange() {
                MutableLiveData<String> email;
                String textString = TextViewBindingAdapter.getTextString(FragmentSignInBindingImpl.this.email);
                SignInViewModel signInViewModel = FragmentSignInBindingImpl.this.mViewModel;
                if (signInViewModel != null && (email = signInViewModel.getEmail()) != null) {
                    email.setValue(textString);
                }
            }
        };
        this.passwordandroidTextAttrChanged = new InverseBindingListener() {
            public void onChange() {
                MutableLiveData<String> password;
                String textString = TextViewBindingAdapter.getTextString(FragmentSignInBindingImpl.this.password);
                SignInViewModel signInViewModel = FragmentSignInBindingImpl.this.mViewModel;
                if (signInViewModel != null && (password = signInViewModel.getPassword()) != null) {
                    password.setValue(textString);
                }
            }
        };
        this.mDirtyFlags = -1;
        this.btnLogin.setTag((Object) null);
        this.cbPrivacy.setTag((Object) null);
        this.email.setTag((Object) null);
        ConstraintLayout constraintLayout = objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag((Object) null);
        this.password.setTag((Object) null);
        this.txtEmailError.setTag((Object) null);
        this.txtPasswordError.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 64;
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
        if (BR.viewModel != i) {
            return false;
        }
        setViewModel((SignInViewModel) obj);
        return true;
    }

    public void setViewModel(SignInViewModel signInViewModel) {
        this.mViewModel = signInViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        notifyPropertyChanged(BR.viewModel);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return onChangeViewModelPasswordValid((LiveData) obj, i2);
        }
        if (i == 1) {
            return onChangeViewModelEmail((MutableLiveData) obj, i2);
        }
        if (i == 2) {
            return onChangeViewModelConfirmPrivacy((MutableLiveData) obj, i2);
        }
        if (i == 3) {
            return onChangeViewModelPassword((MutableLiveData) obj, i2);
        }
        if (i != 4) {
            return false;
        }
        return onChangeViewModelEmailValid((LiveData) obj, i2);
    }

    private boolean onChangeViewModelPasswordValid(LiveData<Boolean> liveData, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeViewModelEmail(MutableLiveData<String> mutableLiveData, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeViewModelConfirmPrivacy(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeViewModelPassword(MutableLiveData<String> mutableLiveData, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeViewModelEmailValid(LiveData<Boolean> liveData, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x015c  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x016c  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x0173  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0192  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x019c  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x019f  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x01aa  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x01b6  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x01de  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x01e9  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x01f4  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x01fe  */
    /* JADX WARNING: Removed duplicated region for block: B:152:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0119  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
            r39 = this;
            r1 = r39
            monitor-enter(r39)
            long r2 = r1.mDirtyFlags     // Catch:{ all -> 0x0204 }
            r4 = 0
            r1.mDirtyFlags = r4     // Catch:{ all -> 0x0204 }
            monitor-exit(r39)     // Catch:{ all -> 0x0204 }
            com.blueair.login.SignInViewModel r0 = r1.mViewModel
            r6 = 127(0x7f, double:6.27E-322)
            long r6 = r6 & r2
            int r6 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            r9 = 2
            r10 = 104(0x68, double:5.14E-322)
            r12 = 100
            r14 = 3
            r15 = 97
            r17 = 4096(0x1000, double:2.0237E-320)
            r19 = r4
            r4 = 1
            r21 = 110(0x6e, double:5.43E-322)
            r5 = 0
            r23 = 112(0x70, double:5.53E-322)
            r7 = 0
            if (r6 == 0) goto L_0x011d
            long r25 = r2 & r15
            int r6 = (r25 > r19 ? 1 : (r25 == r19 ? 0 : -1))
            if (r6 == 0) goto L_0x0057
            if (r0 == 0) goto L_0x0035
            androidx.lifecycle.LiveData r25 = r0.getPasswordValid()
            r8 = r25
            goto L_0x0036
        L_0x0035:
            r8 = r5
        L_0x0036:
            r1.updateLiveDataRegistration(r7, r8)
            if (r8 == 0) goto L_0x0042
            java.lang.Object r8 = r8.getValue()
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            goto L_0x0043
        L_0x0042:
            r8 = r5
        L_0x0043:
            boolean r8 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r8)
            if (r6 == 0) goto L_0x0052
            if (r8 == 0) goto L_0x004e
            r26 = 1024(0x400, double:5.06E-321)
            goto L_0x0050
        L_0x004e:
            r26 = 512(0x200, double:2.53E-321)
        L_0x0050:
            long r2 = r2 | r26
        L_0x0052:
            if (r8 == 0) goto L_0x0057
            r6 = 8
            goto L_0x0058
        L_0x0057:
            r6 = r7
        L_0x0058:
            long r26 = r2 & r21
            int r8 = (r26 > r19 ? 1 : (r26 == r19 ? 0 : -1))
            if (r8 == 0) goto L_0x0091
            if (r0 == 0) goto L_0x0067
            androidx.lifecycle.MutableLiveData r26 = r0.getEmail()
            r7 = r26
            goto L_0x0068
        L_0x0067:
            r7 = r5
        L_0x0068:
            r1.updateLiveDataRegistration(r4, r7)
            if (r7 == 0) goto L_0x0074
            java.lang.Object r7 = r7.getValue()
            java.lang.String r7 = (java.lang.String) r7
            goto L_0x0075
        L_0x0074:
            r7 = r5
        L_0x0075:
            if (r7 == 0) goto L_0x007c
            int r27 = r7.length()
            goto L_0x007e
        L_0x007c:
            r27 = 0
        L_0x007e:
            if (r27 <= 0) goto L_0x0083
            r27 = r4
            goto L_0x0085
        L_0x0083:
            r27 = 0
        L_0x0085:
            if (r8 == 0) goto L_0x0094
            if (r27 == 0) goto L_0x008c
            long r2 = r2 | r17
            goto L_0x0094
        L_0x008c:
            r28 = 2048(0x800, double:1.0118E-320)
            long r2 = r2 | r28
            goto L_0x0094
        L_0x0091:
            r7 = r5
            r27 = 0
        L_0x0094:
            long r28 = r2 & r12
            int r8 = (r28 > r19 ? 1 : (r28 == r19 ? 0 : -1))
            if (r8 == 0) goto L_0x00b5
            if (r0 == 0) goto L_0x00a1
            androidx.lifecycle.MutableLiveData r8 = r0.getConfirmPrivacy()
            goto L_0x00a2
        L_0x00a1:
            r8 = r5
        L_0x00a2:
            r1.updateLiveDataRegistration(r9, r8)
            if (r8 == 0) goto L_0x00ae
            java.lang.Object r28 = r8.getValue()
            java.lang.Boolean r28 = (java.lang.Boolean) r28
            goto L_0x00b0
        L_0x00ae:
            r28 = r5
        L_0x00b0:
            boolean r29 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r28)
            goto L_0x00ba
        L_0x00b5:
            r8 = r5
            r28 = r8
            r29 = 0
        L_0x00ba:
            long r30 = r2 & r10
            int r30 = (r30 > r19 ? 1 : (r30 == r19 ? 0 : -1))
            if (r30 == 0) goto L_0x00d9
            if (r0 == 0) goto L_0x00c9
            androidx.lifecycle.MutableLiveData r30 = r0.getPassword()
            r4 = r30
            goto L_0x00ca
        L_0x00c9:
            r4 = r5
        L_0x00ca:
            r1.updateLiveDataRegistration(r14, r4)
            if (r4 == 0) goto L_0x00d6
            java.lang.Object r31 = r4.getValue()
            java.lang.String r31 = (java.lang.String) r31
            goto L_0x00dc
        L_0x00d6:
            r31 = r5
            goto L_0x00dc
        L_0x00d9:
            r4 = r5
            r31 = r4
        L_0x00dc:
            long r32 = r2 & r23
            int r32 = (r32 > r19 ? 1 : (r32 == r19 ? 0 : -1))
            if (r32 == 0) goto L_0x0119
            if (r0 == 0) goto L_0x00ef
            androidx.lifecycle.LiveData r33 = r0.getEmailValid()
            r37 = r10
            r10 = r33
            r33 = r37
            goto L_0x00f2
        L_0x00ef:
            r33 = r10
            r10 = r5
        L_0x00f2:
            r11 = 4
            r1.updateLiveDataRegistration(r11, r10)
            if (r10 == 0) goto L_0x00ff
            java.lang.Object r10 = r10.getValue()
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            goto L_0x0100
        L_0x00ff:
            r10 = r5
        L_0x0100:
            boolean r10 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r10)
            if (r32 == 0) goto L_0x010f
            if (r10 == 0) goto L_0x010b
            r35 = 16384(0x4000, double:8.0948E-320)
            goto L_0x010d
        L_0x010b:
            r35 = 8192(0x2000, double:4.0474E-320)
        L_0x010d:
            long r2 = r2 | r35
        L_0x010f:
            if (r10 == 0) goto L_0x0114
            r25 = 8
            goto L_0x0116
        L_0x0114:
            r25 = 0
        L_0x0116:
            r10 = r25
            goto L_0x012c
        L_0x0119:
            r33 = r10
            r10 = 0
            goto L_0x012c
        L_0x011d:
            r33 = r10
            r4 = r5
            r7 = r4
            r8 = r7
            r28 = r8
            r31 = r28
            r6 = 0
            r10 = 0
            r27 = 0
            r29 = 0
        L_0x012c:
            long r17 = r2 & r17
            int r11 = (r17 > r19 ? 1 : (r17 == r19 ? 0 : -1))
            if (r11 == 0) goto L_0x0151
            if (r0 == 0) goto L_0x0138
            androidx.lifecycle.MutableLiveData r4 = r0.getPassword()
        L_0x0138:
            r1.updateLiveDataRegistration(r14, r4)
            if (r4 == 0) goto L_0x0145
            java.lang.Object r4 = r4.getValue()
            r31 = r4
            java.lang.String r31 = (java.lang.String) r31
        L_0x0145:
            if (r31 == 0) goto L_0x014c
            int r4 = r31.length()
            goto L_0x014d
        L_0x014c:
            r4 = 0
        L_0x014d:
            if (r4 <= 0) goto L_0x0151
            r4 = 1
            goto L_0x0152
        L_0x0151:
            r4 = 0
        L_0x0152:
            r11 = r31
            long r17 = r2 & r21
            int r14 = (r17 > r19 ? 1 : (r17 == r19 ? 0 : -1))
            r17 = 256(0x100, double:1.265E-321)
            if (r14 == 0) goto L_0x016c
            if (r27 == 0) goto L_0x015f
            goto L_0x0160
        L_0x015f:
            r4 = 0
        L_0x0160:
            if (r14 == 0) goto L_0x016d
            if (r4 == 0) goto L_0x0167
            long r2 = r2 | r17
            goto L_0x016d
        L_0x0167:
            r30 = 128(0x80, double:6.32E-322)
            long r2 = r2 | r30
            goto L_0x016d
        L_0x016c:
            r4 = 0
        L_0x016d:
            long r17 = r2 & r17
            int r14 = (r17 > r19 ? 1 : (r17 == r19 ? 0 : -1))
            if (r14 == 0) goto L_0x018a
            if (r0 == 0) goto L_0x0179
            androidx.lifecycle.MutableLiveData r8 = r0.getConfirmPrivacy()
        L_0x0179:
            r1.updateLiveDataRegistration(r9, r8)
            if (r8 == 0) goto L_0x0186
            java.lang.Object r0 = r8.getValue()
            r28 = r0
            java.lang.Boolean r28 = (java.lang.Boolean) r28
        L_0x0186:
            boolean r29 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r28)
        L_0x018a:
            r0 = r29
            long r8 = r2 & r21
            int r8 = (r8 > r19 ? 1 : (r8 == r19 ? 0 : -1))
            if (r8 == 0) goto L_0x019c
            if (r4 == 0) goto L_0x0197
            r26 = r0
            goto L_0x0199
        L_0x0197:
            r26 = 0
        L_0x0199:
            r4 = r26
            goto L_0x019d
        L_0x019c:
            r4 = 0
        L_0x019d:
            if (r8 == 0) goto L_0x01a4
            androidx.appcompat.widget.AppCompatTextView r8 = r1.btnLogin
            r8.setEnabled(r4)
        L_0x01a4:
            long r8 = r2 & r12
            int r4 = (r8 > r19 ? 1 : (r8 == r19 ? 0 : -1))
            if (r4 == 0) goto L_0x01af
            com.google.android.material.checkbox.MaterialCheckBox r4 = r1.cbPrivacy
            androidx.databinding.adapters.CompoundButtonBindingAdapter.setChecked(r4, r0)
        L_0x01af:
            r8 = 64
            long r8 = r8 & r2
            int r0 = (r8 > r19 ? 1 : (r8 == r19 ? 0 : -1))
            if (r0 == 0) goto L_0x01d7
            com.google.android.material.checkbox.MaterialCheckBox r0 = r1.cbPrivacy
            r4 = r5
            android.widget.CompoundButton$OnCheckedChangeListener r4 = (android.widget.CompoundButton.OnCheckedChangeListener) r4
            androidx.databinding.InverseBindingListener r4 = r1.cbPrivacyandroidCheckedAttrChanged
            androidx.databinding.adapters.CompoundButtonBindingAdapter.setListeners(r0, r5, r4)
            com.google.android.material.textfield.TextInputEditText r0 = r1.email
            r4 = r5
            androidx.databinding.adapters.TextViewBindingAdapter$BeforeTextChanged r4 = (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged) r4
            r4 = r5
            androidx.databinding.adapters.TextViewBindingAdapter$OnTextChanged r4 = (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged) r4
            r4 = r5
            androidx.databinding.adapters.TextViewBindingAdapter$AfterTextChanged r4 = (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged) r4
            androidx.databinding.InverseBindingListener r4 = r1.emailandroidTextAttrChanged
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(r0, r5, r5, r5, r4)
            com.google.android.material.textfield.TextInputEditText r0 = r1.password
            androidx.databinding.InverseBindingListener r4 = r1.passwordandroidTextAttrChanged
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(r0, r5, r5, r5, r4)
        L_0x01d7:
            r4 = 98
            long r4 = r4 & r2
            int r0 = (r4 > r19 ? 1 : (r4 == r19 ? 0 : -1))
            if (r0 == 0) goto L_0x01e3
            com.google.android.material.textfield.TextInputEditText r0 = r1.email
            androidx.databinding.adapters.TextViewBindingAdapter.setText(r0, r7)
        L_0x01e3:
            long r4 = r2 & r33
            int r0 = (r4 > r19 ? 1 : (r4 == r19 ? 0 : -1))
            if (r0 == 0) goto L_0x01ee
            com.google.android.material.textfield.TextInputEditText r0 = r1.password
            androidx.databinding.adapters.TextViewBindingAdapter.setText(r0, r11)
        L_0x01ee:
            long r4 = r2 & r23
            int r0 = (r4 > r19 ? 1 : (r4 == r19 ? 0 : -1))
            if (r0 == 0) goto L_0x01f9
            androidx.appcompat.widget.AppCompatTextView r0 = r1.txtEmailError
            r0.setVisibility(r10)
        L_0x01f9:
            long r2 = r2 & r15
            int r0 = (r2 > r19 ? 1 : (r2 == r19 ? 0 : -1))
            if (r0 == 0) goto L_0x0203
            androidx.appcompat.widget.AppCompatTextView r0 = r1.txtPasswordError
            r0.setVisibility(r6)
        L_0x0203:
            return
        L_0x0204:
            r0 = move-exception
            monitor-exit(r39)     // Catch:{ all -> 0x0204 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.login.databinding.FragmentSignInBindingImpl.executeBindings():void");
    }
}
