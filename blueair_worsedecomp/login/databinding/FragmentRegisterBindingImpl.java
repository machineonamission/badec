package com.blueair.login.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.blueair.login.BR;
import com.blueair.login.R;
import com.blueair.login.RegisterViewModel;
import com.blueair.login.generated.callback.OnClickListener;

public class FragmentRegisterBindingImpl extends FragmentRegisterBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private InverseBindingListener cbConsentandroidCheckedAttrChanged;
    private InverseBindingListener cbPrivacyandroidCheckedAttrChanged;
    private InverseBindingListener cbSubscribeandroidCheckedAttrChanged;
    private InverseBindingListener cbYearsandroidCheckedAttrChanged;
    private InverseBindingListener confirmPasswordandroidTextAttrChanged;
    private InverseBindingListener emailandroidTextAttrChanged;
    private InverseBindingListener firstNameandroidTextAttrChanged;
    private InverseBindingListener lastNameandroidTextAttrChanged;
    private final View.OnClickListener mCallback3;
    private long mDirtyFlags;
    private final FrameLayout mboundView0;
    private InverseBindingListener passwordandroidTextAttrChanged;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.toolbar, 23);
        sparseIntArray.put(R.id.btnBack, 24);
        sparseIntArray.put(R.id.btnClose, 25);
        sparseIntArray.put(R.id.txt_getStarted, 26);
        sparseIntArray.put(R.id.scrollableRoot, 27);
        sparseIntArray.put(R.id.txtPasswordRequirement, 28);
        sparseIntArray.put(R.id.tv_tip, 29);
        sparseIntArray.put(R.id.txtLoginTitle, 30);
        sparseIntArray.put(R.id.btnLogin, 31);
    }

    public FragmentRegisterBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 32, sIncludes, sViewsWithIds));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private FragmentRegisterBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 17, objArr[24], objArr[25], objArr[31], objArr[21], objArr[20], objArr[16], objArr[19], objArr[18], objArr[14], objArr[8], objArr[2], objArr[5], objArr[22], objArr[11], objArr[17], objArr[27], objArr[23], objArr[29], objArr[13], objArr[15], objArr[7], objArr[9], objArr[1], objArr[3], objArr[26], objArr[4], objArr[6], objArr[30], objArr[10], objArr[12], objArr[28]);
        this.cbConsentandroidCheckedAttrChanged = new InverseBindingListener() {
            public void onChange() {
                MutableLiveData<Boolean> confirmConsentDate;
                boolean isChecked = FragmentRegisterBindingImpl.this.cbConsent.isChecked();
                RegisterViewModel registerViewModel = FragmentRegisterBindingImpl.this.mViewModel;
                if (registerViewModel != null && (confirmConsentDate = registerViewModel.getConfirmConsentDate()) != null) {
                    confirmConsentDate.setValue(Boolean.valueOf(isChecked));
                }
            }
        };
        this.cbPrivacyandroidCheckedAttrChanged = new InverseBindingListener() {
            public void onChange() {
                MutableLiveData<Boolean> confirmPrivacy;
                boolean isChecked = FragmentRegisterBindingImpl.this.cbPrivacy.isChecked();
                RegisterViewModel registerViewModel = FragmentRegisterBindingImpl.this.mViewModel;
                if (registerViewModel != null && (confirmPrivacy = registerViewModel.getConfirmPrivacy()) != null) {
                    confirmPrivacy.setValue(Boolean.valueOf(isChecked));
                }
            }
        };
        this.cbSubscribeandroidCheckedAttrChanged = new InverseBindingListener() {
            public void onChange() {
                MutableLiveData<Boolean> confirmSubscribe;
                boolean isChecked = FragmentRegisterBindingImpl.this.cbSubscribe.isChecked();
                RegisterViewModel registerViewModel = FragmentRegisterBindingImpl.this.mViewModel;
                if (registerViewModel != null && (confirmSubscribe = registerViewModel.getConfirmSubscribe()) != null) {
                    confirmSubscribe.setValue(Boolean.valueOf(isChecked));
                }
            }
        };
        this.cbYearsandroidCheckedAttrChanged = new InverseBindingListener() {
            public void onChange() {
                MutableLiveData<Boolean> confirmYear;
                boolean isChecked = FragmentRegisterBindingImpl.this.cbYears.isChecked();
                RegisterViewModel registerViewModel = FragmentRegisterBindingImpl.this.mViewModel;
                if (registerViewModel != null && (confirmYear = registerViewModel.getConfirmYear()) != null) {
                    confirmYear.setValue(Boolean.valueOf(isChecked));
                }
            }
        };
        this.confirmPasswordandroidTextAttrChanged = new InverseBindingListener() {
            public void onChange() {
                MutableLiveData<String> confirmPassword;
                String textString = TextViewBindingAdapter.getTextString(FragmentRegisterBindingImpl.this.confirmPassword);
                RegisterViewModel registerViewModel = FragmentRegisterBindingImpl.this.mViewModel;
                if (registerViewModel != null && (confirmPassword = registerViewModel.getConfirmPassword()) != null) {
                    confirmPassword.setValue(textString);
                }
            }
        };
        this.emailandroidTextAttrChanged = new InverseBindingListener() {
            public void onChange() {
                MutableLiveData<String> email;
                String textString = TextViewBindingAdapter.getTextString(FragmentRegisterBindingImpl.this.email);
                RegisterViewModel registerViewModel = FragmentRegisterBindingImpl.this.mViewModel;
                if (registerViewModel != null && (email = registerViewModel.getEmail()) != null) {
                    email.setValue(textString);
                }
            }
        };
        this.firstNameandroidTextAttrChanged = new InverseBindingListener() {
            public void onChange() {
                MutableLiveData<String> firstName;
                String textString = TextViewBindingAdapter.getTextString(FragmentRegisterBindingImpl.this.firstName);
                RegisterViewModel registerViewModel = FragmentRegisterBindingImpl.this.mViewModel;
                if (registerViewModel != null && (firstName = registerViewModel.getFirstName()) != null) {
                    firstName.setValue(textString);
                }
            }
        };
        this.lastNameandroidTextAttrChanged = new InverseBindingListener() {
            public void onChange() {
                MutableLiveData<String> lastName;
                String textString = TextViewBindingAdapter.getTextString(FragmentRegisterBindingImpl.this.lastName);
                RegisterViewModel registerViewModel = FragmentRegisterBindingImpl.this.mViewModel;
                if (registerViewModel != null && (lastName = registerViewModel.getLastName()) != null) {
                    lastName.setValue(textString);
                }
            }
        };
        this.passwordandroidTextAttrChanged = new InverseBindingListener() {
            public void onChange() {
                MutableLiveData<String> password;
                String textString = TextViewBindingAdapter.getTextString(FragmentRegisterBindingImpl.this.password);
                RegisterViewModel registerViewModel = FragmentRegisterBindingImpl.this.mViewModel;
                if (registerViewModel != null && (password = registerViewModel.getPassword()) != null) {
                    password.setValue(textString);
                }
            }
        };
        this.mDirtyFlags = -1;
        this.btnRegister.setTag((Object) null);
        this.cbConsent.setTag((Object) null);
        this.cbPrivacy.setTag((Object) null);
        this.cbSubscribe.setTag((Object) null);
        this.cbYears.setTag((Object) null);
        this.confirmPassword.setTag((Object) null);
        this.email.setTag((Object) null);
        this.firstName.setTag((Object) null);
        this.lastName.setTag((Object) null);
        this.loading.setTag((Object) null);
        FrameLayout frameLayout = objArr[0];
        this.mboundView0 = frameLayout;
        frameLayout.setTag((Object) null);
        this.password.setTag((Object) null);
        this.privacyText.setTag((Object) null);
        this.txtConfirmPassword.setTag((Object) null);
        this.txtConfirmPasswordError.setTag((Object) null);
        this.txtEmail.setTag((Object) null);
        this.txtEmailError.setTag((Object) null);
        this.txtFirstName.setTag("FirstName");
        this.txtFirstNameError.setTag((Object) null);
        this.txtLastName.setTag("LastName");
        this.txtLastNameError.setTag((Object) null);
        this.txtPassword.setTag((Object) null);
        this.txtPasswordError.setTag((Object) null);
        setRootTag(view);
        this.mCallback3 = new OnClickListener(this, 1);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
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
        setViewModel((RegisterViewModel) obj);
        return true;
    }

    public void setViewModel(RegisterViewModel registerViewModel) {
        this.mViewModel = registerViewModel;
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
        }
        notifyPropertyChanged(BR.viewModel);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return onChangeViewModelConfirmPasswordValid((LiveData) obj, i2);
            case 1:
                return onChangeViewModelEmailError((LiveData) obj, i2);
            case 2:
                return onChangeViewModelEmail((MutableLiveData) obj, i2);
            case 3:
                return onChangeViewModelConfirmPrivacy((MutableLiveData) obj, i2);
            case 4:
                return onChangeViewModelYearConfirmed((LiveData) obj, i2);
            case 5:
                return onChangeViewModelLoading((LiveData) obj, i2);
            case 6:
                return onChangeViewModelLastName((MutableLiveData) obj, i2);
            case 7:
                return onChangeViewModelFirstName((MutableLiveData) obj, i2);
            case 8:
                return onChangeViewModelPasswordError((LiveData) obj, i2);
            case 9:
                return onChangeViewModelPrivacyConfirmed((LiveData) obj, i2);
            case 10:
                return onChangeViewModelConfirmSubscribe((MutableLiveData) obj, i2);
            case 11:
                return onChangeViewModelConfirmConsentDate((MutableLiveData) obj, i2);
            case 12:
                return onChangeViewModelPassword((MutableLiveData) obj, i2);
            case 13:
                return onChangeViewModelConfirmYear((MutableLiveData) obj, i2);
            case 14:
                return onChangeViewModelConfirmPassword((MutableLiveData) obj, i2);
            case 15:
                return onChangeViewModelLastNameValid((LiveData) obj, i2);
            case 16:
                return onChangeViewModelFirstNameValid((LiveData) obj, i2);
            default:
                return false;
        }
    }

    private boolean onChangeViewModelConfirmPasswordValid(LiveData<Boolean> liveData, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeViewModelEmailError(LiveData<String> liveData, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeViewModelEmail(MutableLiveData<String> mutableLiveData, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeViewModelConfirmPrivacy(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeViewModelYearConfirmed(LiveData<Boolean> liveData, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    private boolean onChangeViewModelLoading(LiveData<Boolean> liveData, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        return true;
    }

    private boolean onChangeViewModelLastName(MutableLiveData<String> mutableLiveData, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        return true;
    }

    private boolean onChangeViewModelFirstName(MutableLiveData<String> mutableLiveData, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 128;
        }
        return true;
    }

    private boolean onChangeViewModelPasswordError(LiveData<String> liveData, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 256;
        }
        return true;
    }

    private boolean onChangeViewModelPrivacyConfirmed(LiveData<Boolean> liveData, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 512;
        }
        return true;
    }

    private boolean onChangeViewModelConfirmSubscribe(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1024;
        }
        return true;
    }

    private boolean onChangeViewModelConfirmConsentDate(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2048;
        }
        return true;
    }

    private boolean onChangeViewModelPassword(MutableLiveData<String> mutableLiveData, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4096;
        }
        return true;
    }

    private boolean onChangeViewModelConfirmYear(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
        }
        return true;
    }

    private boolean onChangeViewModelConfirmPassword(MutableLiveData<String> mutableLiveData, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16384;
        }
        return true;
    }

    private boolean onChangeViewModelLastNameValid(LiveData<Boolean> liveData, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
        }
        return true;
    }

    private boolean onChangeViewModelFirstNameValid(LiveData<Boolean> liveData, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
        }
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v5, resolved type: java.lang.Object} */
    /* JADX WARNING: type inference failed for: r16v0 */
    /* JADX WARNING: type inference failed for: r6v11, types: [androidx.databinding.adapters.TextViewBindingAdapter$BeforeTextChanged, androidx.databinding.adapters.TextViewBindingAdapter$OnTextChanged, android.widget.CompoundButton$OnCheckedChangeListener, androidx.databinding.adapters.TextViewBindingAdapter$AfterTextChanged] */
    /* JADX WARNING: type inference failed for: r16v1 */
    /* JADX WARNING: type inference failed for: r16v2 */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x018a  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x0196  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x01b4  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x01d2  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x0212  */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x0222  */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x0256  */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x0261  */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x0289  */
    /* JADX WARNING: Removed duplicated region for block: B:183:0x0294  */
    /* JADX WARNING: Removed duplicated region for block: B:191:0x02b4  */
    /* JADX WARNING: Removed duplicated region for block: B:194:0x02bd  */
    /* JADX WARNING: Removed duplicated region for block: B:200:0x02d6  */
    /* JADX WARNING: Removed duplicated region for block: B:204:0x02e0  */
    /* JADX WARNING: Removed duplicated region for block: B:216:0x0316  */
    /* JADX WARNING: Removed duplicated region for block: B:219:0x031f  */
    /* JADX WARNING: Removed duplicated region for block: B:225:0x0338  */
    /* JADX WARNING: Removed duplicated region for block: B:229:0x0345  */
    /* JADX WARNING: Removed duplicated region for block: B:247:0x038e  */
    /* JADX WARNING: Removed duplicated region for block: B:250:0x039b  */
    /* JADX WARNING: Removed duplicated region for block: B:268:0x0411  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x010e  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0118  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0146  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0151  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
            r76 = this;
            r1 = r76
            monitor-enter(r76)
            long r2 = r1.mDirtyFlags     // Catch:{ all -> 0x06e0 }
            r4 = 0
            r1.mDirtyFlags = r4     // Catch:{ all -> 0x06e0 }
            monitor-exit(r76)     // Catch:{ all -> 0x06e0 }
            com.blueair.login.RegisterViewModel r0 = r1.mViewModel
            r6 = 524287(0x7ffff, double:2.59032E-318)
            long r6 = r6 & r2
            int r6 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            r17 = 393280(0x60040, double:1.94306E-318)
            r19 = 395264(0x60800, double:1.952864E-318)
            r21 = 393248(0x60020, double:1.942903E-318)
            r23 = 393224(0x60008, double:1.942785E-318)
            r25 = 401416(0x62008, double:1.98326E-318)
            r27 = 393220(0x60004, double:1.942765E-318)
            r29 = r4
            r4 = 3
            r31 = 393218(0x60002, double:1.942755E-318)
            r33 = 393217(0x60001, double:1.94275E-318)
            r35 = 274877906944(0x4000000000, double:1.358077306218E-312)
            r37 = 393728(0x60200, double:1.945275E-318)
            r39 = 393232(0x60010, double:1.942824E-318)
            r5 = 1
            r41 = 397312(0x61000, double:1.96298E-318)
            r7 = 0
            if (r6 == 0) goto L_0x0445
            long r43 = r2 & r33
            int r6 = (r43 > r29 ? 1 : (r43 == r29 ? 0 : -1))
            r43 = 409600(0x64000, double:2.023693E-318)
            if (r6 == 0) goto L_0x0083
            if (r0 == 0) goto L_0x004f
            androidx.lifecycle.LiveData r10 = r0.getConfirmPasswordValid()
            goto L_0x0050
        L_0x004f:
            r10 = 0
        L_0x0050:
            r1.updateLiveDataRegistration(r7, r10)
            if (r10 == 0) goto L_0x005c
            java.lang.Object r10 = r10.getValue()
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            goto L_0x005d
        L_0x005c:
            r10 = 0
        L_0x005d:
            boolean r10 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r10)
            if (r6 == 0) goto L_0x0072
            if (r10 == 0) goto L_0x006b
            r45 = 1099511627776(0x10000000000, double:5.43230922487E-312)
            goto L_0x0070
        L_0x006b:
            r45 = 549755813888(0x8000000000, double:2.716154612436E-312)
        L_0x0070:
            long r2 = r2 | r45
        L_0x0072:
            r6 = r10 ^ 1
            if (r10 == 0) goto L_0x0079
            r10 = 8
            goto L_0x007a
        L_0x0079:
            r10 = r7
        L_0x007a:
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)
            boolean r6 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r6)
            goto L_0x0085
        L_0x0083:
            r6 = r7
            r10 = r6
        L_0x0085:
            long r45 = r2 & r31
            int r45 = (r45 > r29 ? 1 : (r45 == r29 ? 0 : -1))
            if (r45 == 0) goto L_0x00c5
            if (r0 == 0) goto L_0x0094
            androidx.lifecycle.LiveData r46 = r0.getEmailError()
            r7 = r46
            goto L_0x0095
        L_0x0094:
            r7 = 0
        L_0x0095:
            r1.updateLiveDataRegistration(r5, r7)
            if (r7 == 0) goto L_0x00a1
            java.lang.Object r7 = r7.getValue()
            java.lang.String r7 = (java.lang.String) r7
            goto L_0x00a2
        L_0x00a1:
            r7 = 0
        L_0x00a2:
            if (r7 == 0) goto L_0x00a7
            r47 = r5
            goto L_0x00a9
        L_0x00a7:
            r47 = 0
        L_0x00a9:
            if (r7 != 0) goto L_0x00ae
            r48 = r5
            goto L_0x00b0
        L_0x00ae:
            r48 = 0
        L_0x00b0:
            if (r45 == 0) goto L_0x00bd
            if (r48 == 0) goto L_0x00b8
            r49 = 1048576(0x100000, double:5.180654E-318)
            goto L_0x00bb
        L_0x00b8:
            r49 = 524288(0x80000, double:2.590327E-318)
        L_0x00bb:
            long r2 = r2 | r49
        L_0x00bd:
            if (r48 == 0) goto L_0x00c2
            r45 = 8
            goto L_0x00ca
        L_0x00c2:
            r45 = 0
            goto L_0x00ca
        L_0x00c5:
            r7 = 0
            r45 = 0
            r47 = 0
        L_0x00ca:
            long r48 = r2 & r27
            int r48 = (r48 > r29 ? 1 : (r48 == r29 ? 0 : -1))
            if (r48 == 0) goto L_0x00ea
            if (r0 == 0) goto L_0x00d9
            androidx.lifecycle.MutableLiveData r48 = r0.getEmail()
            r5 = r48
            goto L_0x00da
        L_0x00d9:
            r5 = 0
        L_0x00da:
            r49 = 394240(0x60400, double:1.947804E-318)
            r11 = 2
            r1.updateLiveDataRegistration(r11, r5)
            if (r5 == 0) goto L_0x00ed
            java.lang.Object r5 = r5.getValue()
            java.lang.String r5 = (java.lang.String) r5
            goto L_0x00ee
        L_0x00ea:
            r49 = 394240(0x60400, double:1.947804E-318)
        L_0x00ed:
            r5 = 0
        L_0x00ee:
            long r11 = r2 & r23
            int r11 = (r11 > r29 ? 1 : (r11 == r29 ? 0 : -1))
            if (r11 == 0) goto L_0x010e
            if (r0 == 0) goto L_0x00fb
            androidx.lifecycle.MutableLiveData r11 = r0.getConfirmPrivacy()
            goto L_0x00fc
        L_0x00fb:
            r11 = 0
        L_0x00fc:
            r1.updateLiveDataRegistration(r4, r11)
            if (r11 == 0) goto L_0x0108
            java.lang.Object r12 = r11.getValue()
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            goto L_0x0109
        L_0x0108:
            r12 = 0
        L_0x0109:
            boolean r51 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r12)
            goto L_0x0112
        L_0x010e:
            r11 = 0
            r12 = 0
            r51 = 0
        L_0x0112:
            long r52 = r2 & r39
            int r52 = (r52 > r29 ? 1 : (r52 == r29 ? 0 : -1))
            if (r52 == 0) goto L_0x0146
            if (r0 == 0) goto L_0x0121
            androidx.lifecycle.LiveData r53 = r0.getYearConfirmed()
            r13 = r53
            goto L_0x0122
        L_0x0121:
            r13 = 0
        L_0x0122:
            r53 = 393472(0x60100, double:1.94401E-318)
            r14 = 4
            r1.updateLiveDataRegistration(r14, r13)
            if (r13 == 0) goto L_0x0132
            java.lang.Object r13 = r13.getValue()
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            goto L_0x0133
        L_0x0132:
            r13 = 0
        L_0x0133:
            if (r13 != 0) goto L_0x0137
            r14 = 1
            goto L_0x0138
        L_0x0137:
            r14 = 0
        L_0x0138:
            if (r52 == 0) goto L_0x014b
            if (r14 == 0) goto L_0x0140
            r55 = 67108864(0x4000000, double:3.31561842E-316)
            goto L_0x0143
        L_0x0140:
            r55 = 33554432(0x2000000, double:1.6578092E-316)
        L_0x0143:
            long r2 = r2 | r55
            goto L_0x014b
        L_0x0146:
            r53 = 393472(0x60100, double:1.94401E-318)
            r13 = 0
            r14 = 0
        L_0x014b:
            long r55 = r2 & r21
            int r52 = (r55 > r29 ? 1 : (r55 == r29 ? 0 : -1))
            if (r52 == 0) goto L_0x018a
            if (r0 == 0) goto L_0x015a
            androidx.lifecycle.LiveData r55 = r0.getLoading()
            r15 = r55
            goto L_0x015b
        L_0x015a:
            r15 = 0
        L_0x015b:
            r16 = 0
            r55 = 393344(0x60080, double:1.94338E-318)
            r8 = 5
            r1.updateLiveDataRegistration(r8, r15)
            if (r15 == 0) goto L_0x016d
            java.lang.Object r8 = r15.getValue()
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            goto L_0x016f
        L_0x016d:
            r8 = r16
        L_0x016f:
            boolean r8 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r8)
            if (r52 == 0) goto L_0x0184
            if (r8 == 0) goto L_0x017d
            r57 = 68719476736(0x1000000000, double:3.39519326554E-313)
            goto L_0x0182
        L_0x017d:
            r57 = 34359738368(0x800000000, double:1.69759663277E-313)
        L_0x0182:
            long r2 = r2 | r57
        L_0x0184:
            if (r8 == 0) goto L_0x0187
            goto L_0x018f
        L_0x0187:
            r8 = 8
            goto L_0x0190
        L_0x018a:
            r16 = 0
            r55 = 393344(0x60080, double:1.94338E-318)
        L_0x018f:
            r8 = 0
        L_0x0190:
            long r57 = r2 & r17
            int r15 = (r57 > r29 ? 1 : (r57 == r29 ? 0 : -1))
            if (r15 == 0) goto L_0x01ac
            if (r0 == 0) goto L_0x019d
            androidx.lifecycle.MutableLiveData r15 = r0.getLastName()
            goto L_0x019f
        L_0x019d:
            r15 = r16
        L_0x019f:
            r4 = 6
            r1.updateLiveDataRegistration(r4, r15)
            if (r15 == 0) goto L_0x01ac
            java.lang.Object r4 = r15.getValue()
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x01ae
        L_0x01ac:
            r4 = r16
        L_0x01ae:
            long r57 = r2 & r55
            int r15 = (r57 > r29 ? 1 : (r57 == r29 ? 0 : -1))
            if (r15 == 0) goto L_0x01ca
            if (r0 == 0) goto L_0x01bb
            androidx.lifecycle.MutableLiveData r15 = r0.getFirstName()
            goto L_0x01bd
        L_0x01bb:
            r15 = r16
        L_0x01bd:
            r9 = 7
            r1.updateLiveDataRegistration(r9, r15)
            if (r15 == 0) goto L_0x01ca
            java.lang.Object r9 = r15.getValue()
            java.lang.String r9 = (java.lang.String) r9
            goto L_0x01cc
        L_0x01ca:
            r9 = r16
        L_0x01cc:
            long r58 = r2 & r53
            int r15 = (r58 > r29 ? 1 : (r58 == r29 ? 0 : -1))
            if (r15 == 0) goto L_0x0212
            if (r0 == 0) goto L_0x01df
            androidx.lifecycle.LiveData r58 = r0.getPasswordError()
            r59 = r58
            r58 = r0
            r0 = r59
            goto L_0x01e3
        L_0x01df:
            r58 = r0
            r0 = r16
        L_0x01e3:
            r59 = r2
            r2 = 8
            r1.updateLiveDataRegistration(r2, r0)
            if (r0 == 0) goto L_0x01f3
            java.lang.Object r0 = r0.getValue()
            java.lang.String r0 = (java.lang.String) r0
            goto L_0x01f5
        L_0x01f3:
            r0 = r16
        L_0x01f5:
            if (r0 == 0) goto L_0x01f9
            r3 = 1
            goto L_0x01fa
        L_0x01f9:
            r3 = 0
        L_0x01fa:
            if (r0 != 0) goto L_0x01ff
            r57 = 1
            goto L_0x0201
        L_0x01ff:
            r57 = 0
        L_0x0201:
            if (r15 == 0) goto L_0x020e
            if (r57 == 0) goto L_0x0209
            r61 = 1073741824(0x40000000, double:5.304989477E-315)
            goto L_0x020c
        L_0x0209:
            r61 = 536870912(0x20000000, double:2.652494739E-315)
        L_0x020c:
            long r59 = r59 | r61
        L_0x020e:
            if (r57 == 0) goto L_0x021b
            r15 = r2
            goto L_0x021c
        L_0x0212:
            r58 = r0
            r59 = r2
            r2 = 8
            r0 = r16
            r3 = 0
        L_0x021b:
            r15 = 0
        L_0x021c:
            long r61 = r59 & r37
            int r57 = (r61 > r29 ? 1 : (r61 == r29 ? 0 : -1))
            if (r57 == 0) goto L_0x0256
            if (r58 == 0) goto L_0x022b
            androidx.lifecycle.LiveData r61 = r58.getPrivacyConfirmed()
            r2 = r61
            goto L_0x022d
        L_0x022b:
            r2 = r16
        L_0x022d:
            r62 = r0
            r0 = 9
            r1.updateLiveDataRegistration(r0, r2)
            if (r2 == 0) goto L_0x023d
            java.lang.Object r0 = r2.getValue()
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            goto L_0x023f
        L_0x023d:
            r0 = r16
        L_0x023f:
            if (r0 != 0) goto L_0x0243
            r2 = 1
            goto L_0x0244
        L_0x0243:
            r2 = 0
        L_0x0244:
            if (r57 == 0) goto L_0x025b
            if (r2 == 0) goto L_0x024e
            r63 = 4398046511104(0x40000000000, double:2.1729236899484E-311)
            goto L_0x0253
        L_0x024e:
            r63 = 2199023255552(0x20000000000, double:1.0864618449742E-311)
        L_0x0253:
            long r59 = r59 | r63
            goto L_0x025b
        L_0x0256:
            r62 = r0
            r0 = r16
            r2 = 0
        L_0x025b:
            long r63 = r59 & r49
            int r57 = (r63 > r29 ? 1 : (r63 == r29 ? 0 : -1))
            if (r57 == 0) goto L_0x0289
            if (r58 == 0) goto L_0x026e
            androidx.lifecycle.MutableLiveData r57 = r58.getConfirmSubscribe()
            r63 = r57
            r57 = r0
            r0 = r63
            goto L_0x0272
        L_0x026e:
            r57 = r0
            r0 = r16
        L_0x0272:
            r63 = r2
            r2 = 10
            r1.updateLiveDataRegistration(r2, r0)
            if (r0 == 0) goto L_0x0282
            java.lang.Object r0 = r0.getValue()
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            goto L_0x0284
        L_0x0282:
            r0 = r16
        L_0x0284:
            boolean r0 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r0)
            goto L_0x028e
        L_0x0289:
            r57 = r0
            r63 = r2
            r0 = 0
        L_0x028e:
            long r64 = r59 & r19
            int r2 = (r64 > r29 ? 1 : (r64 == r29 ? 0 : -1))
            if (r2 == 0) goto L_0x02b4
            if (r58 == 0) goto L_0x029b
            androidx.lifecycle.MutableLiveData r2 = r58.getConfirmConsentDate()
            goto L_0x029d
        L_0x029b:
            r2 = r16
        L_0x029d:
            r64 = r0
            r0 = 11
            r1.updateLiveDataRegistration(r0, r2)
            if (r2 == 0) goto L_0x02ad
            java.lang.Object r0 = r2.getValue()
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            goto L_0x02af
        L_0x02ad:
            r0 = r16
        L_0x02af:
            boolean r0 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r0)
            goto L_0x02b7
        L_0x02b4:
            r64 = r0
            r0 = 0
        L_0x02b7:
            long r65 = r59 & r41
            int r2 = (r65 > r29 ? 1 : (r65 == r29 ? 0 : -1))
            if (r2 == 0) goto L_0x02d6
            if (r58 == 0) goto L_0x02c4
            androidx.lifecycle.MutableLiveData r2 = r58.getPassword()
            goto L_0x02c6
        L_0x02c4:
            r2 = r16
        L_0x02c6:
            r65 = r0
            r0 = 12
            r1.updateLiveDataRegistration(r0, r2)
            if (r2 == 0) goto L_0x02d8
            java.lang.Object r0 = r2.getValue()
            java.lang.String r0 = (java.lang.String) r0
            goto L_0x02da
        L_0x02d6:
            r65 = r0
        L_0x02d8:
            r0 = r16
        L_0x02da:
            long r66 = r59 & r25
            int r2 = (r66 > r29 ? 1 : (r66 == r29 ? 0 : -1))
            if (r2 == 0) goto L_0x0316
            if (r58 == 0) goto L_0x02ed
            androidx.lifecycle.MutableLiveData r66 = r58.getConfirmYear()
            r67 = r66
            r66 = r0
            r0 = r67
            goto L_0x02f1
        L_0x02ed:
            r66 = r0
            r0 = r16
        L_0x02f1:
            r67 = r2
            r2 = 13
            r1.updateLiveDataRegistration(r2, r0)
            if (r0 == 0) goto L_0x0301
            java.lang.Object r0 = r0.getValue()
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            goto L_0x0303
        L_0x0301:
            r0 = r16
        L_0x0303:
            boolean r0 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r0)
            if (r67 == 0) goto L_0x0319
            if (r0 == 0) goto L_0x030e
            long r59 = r59 | r35
            goto L_0x0319
        L_0x030e:
            r67 = 137438953472(0x2000000000, double:6.7903865311E-313)
            long r59 = r59 | r67
            goto L_0x0319
        L_0x0316:
            r66 = r0
            r0 = 0
        L_0x0319:
            long r67 = r59 & r43
            int r2 = (r67 > r29 ? 1 : (r67 == r29 ? 0 : -1))
            if (r2 == 0) goto L_0x0338
            if (r58 == 0) goto L_0x0326
            androidx.lifecycle.MutableLiveData r2 = r58.getConfirmPassword()
            goto L_0x0328
        L_0x0326:
            r2 = r16
        L_0x0328:
            r67 = r0
            r0 = 14
            r1.updateLiveDataRegistration(r0, r2)
            if (r2 == 0) goto L_0x033a
            java.lang.Object r0 = r2.getValue()
            java.lang.String r0 = (java.lang.String) r0
            goto L_0x033c
        L_0x0338:
            r67 = r0
        L_0x033a:
            r0 = r16
        L_0x033c:
            r68 = 425984(0x68000, double:2.10464E-318)
            long r68 = r59 & r68
            int r2 = (r68 > r29 ? 1 : (r68 == r29 ? 0 : -1))
            if (r2 == 0) goto L_0x038e
            if (r58 == 0) goto L_0x0352
            androidx.lifecycle.LiveData r68 = r58.getLastNameValid()
            r69 = r68
            r68 = r0
            r0 = r69
            goto L_0x0356
        L_0x0352:
            r68 = r0
            r0 = r16
        L_0x0356:
            r69 = r2
            r2 = 15
            r1.updateLiveDataRegistration(r2, r0)
            if (r0 == 0) goto L_0x0366
            java.lang.Object r0 = r0.getValue()
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            goto L_0x0368
        L_0x0366:
            r0 = r16
        L_0x0368:
            boolean r0 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r0)
            if (r69 == 0) goto L_0x037d
            if (r0 == 0) goto L_0x0376
            r69 = 4294967296(0x100000000, double:2.121995791E-314)
            goto L_0x037b
        L_0x0376:
            r69 = 2147483648(0x80000000, double:1.0609978955E-314)
        L_0x037b:
            long r59 = r59 | r69
        L_0x037d:
            r2 = r0 ^ 1
            if (r0 == 0) goto L_0x0384
            r0 = 8
            goto L_0x0385
        L_0x0384:
            r0 = 0
        L_0x0385:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            boolean r2 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r2)
            goto L_0x0392
        L_0x038e:
            r68 = r0
            r0 = 0
            r2 = 0
        L_0x0392:
            r69 = 458752(0x70000, double:2.266536E-318)
            long r69 = r59 & r69
            int r69 = (r69 > r29 ? 1 : (r69 == r29 ? 0 : -1))
            if (r69 == 0) goto L_0x0411
            if (r58 == 0) goto L_0x03a8
            androidx.lifecycle.LiveData r70 = r58.getFirstNameValid()
            r71 = r70
            r70 = r0
            r0 = r71
            goto L_0x03ac
        L_0x03a8:
            r70 = r0
            r0 = r16
        L_0x03ac:
            r71 = r2
            r2 = 16
            r1.updateLiveDataRegistration(r2, r0)
            if (r0 == 0) goto L_0x03bc
            java.lang.Object r0 = r0.getValue()
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            goto L_0x03be
        L_0x03bc:
            r0 = r16
        L_0x03be:
            boolean r0 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r0)
            if (r69 == 0) goto L_0x03d3
            if (r0 == 0) goto L_0x03cc
            r72 = 17179869184(0x400000000, double:8.4879831639E-314)
            goto L_0x03d1
        L_0x03cc:
            r72 = 8589934592(0x200000000, double:4.243991582E-314)
        L_0x03d1:
            long r59 = r59 | r72
        L_0x03d3:
            r2 = r0 ^ 1
            if (r0 == 0) goto L_0x03da
            r61 = 8
            goto L_0x03dc
        L_0x03da:
            r61 = 0
        L_0x03dc:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r2)
            boolean r0 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r0)
            r2 = r51
            r51 = r3
            r3 = r67
            r67 = r2
            r74 = r15
            r75 = r61
            r2 = r65
            r65 = r70
            r15 = r7
            r61 = r12
            r7 = r0
            r12 = r4
            r0 = r8
            r8 = r45
            r45 = r57
            r4 = r64
            r57 = r11
            r64 = r14
            r14 = r6
            r11 = r10
            r10 = r47
            r47 = r62
            r6 = r66
            r66 = r71
            r62 = r13
            goto L_0x0441
        L_0x0411:
            r70 = r0
            r71 = r2
            r0 = r51
            r51 = r3
            r3 = r67
            r67 = r0
            r0 = r8
            r61 = r12
            r74 = r15
            r8 = r45
            r45 = r57
            r2 = r65
            r65 = r70
            r75 = 0
            r12 = r4
            r15 = r7
            r57 = r11
            r4 = r64
            r7 = 0
            r11 = r10
            r64 = r14
            r10 = r47
            r47 = r62
            r14 = r6
            r62 = r13
            r6 = r66
            r66 = r71
        L_0x0441:
            r13 = r5
            r5 = r68
            goto L_0x0481
        L_0x0445:
            r58 = r0
            r16 = 0
            r43 = 409600(0x64000, double:2.023693E-318)
            r49 = 394240(0x60400, double:1.947804E-318)
            r53 = 393472(0x60100, double:1.94401E-318)
            r55 = 393344(0x60080, double:1.94338E-318)
            r59 = r2
            r5 = r16
            r6 = r5
            r9 = r6
            r12 = r9
            r13 = r12
            r15 = r13
            r45 = r15
            r47 = r45
            r57 = r47
            r61 = r57
            r62 = r61
            r0 = 0
            r2 = 0
            r3 = 0
            r4 = 0
            r7 = 0
            r8 = 0
            r10 = 0
            r11 = 0
            r14 = 0
            r51 = 0
            r63 = 0
            r64 = 0
            r65 = 0
            r66 = 0
            r67 = 0
            r74 = 0
            r75 = 0
        L_0x0481:
            long r35 = r59 & r35
            int r35 = (r35 > r29 ? 1 : (r35 == r29 ? 0 : -1))
            if (r35 == 0) goto L_0x04a6
            if (r58 == 0) goto L_0x048d
            androidx.lifecycle.MutableLiveData r57 = r58.getConfirmPrivacy()
        L_0x048d:
            r35 = r7
            r36 = r8
            r7 = r57
            r8 = 3
            r1.updateLiveDataRegistration(r8, r7)
            if (r7 == 0) goto L_0x04a1
            java.lang.Object r7 = r7.getValue()
            r61 = r7
            java.lang.Boolean r61 = (java.lang.Boolean) r61
        L_0x04a1:
            boolean r67 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r61)
            goto L_0x04aa
        L_0x04a6:
            r35 = r7
            r36 = r8
        L_0x04aa:
            r7 = r67
            long r57 = r59 & r39
            int r8 = (r57 > r29 ? 1 : (r57 == r29 ? 0 : -1))
            if (r8 == 0) goto L_0x04dc
            if (r64 == 0) goto L_0x04b7
            r52 = 1
            goto L_0x04bb
        L_0x04b7:
            boolean r52 = r62.booleanValue()
        L_0x04bb:
            if (r8 == 0) goto L_0x04c8
            if (r52 == 0) goto L_0x04c3
            r57 = 268435456(0x10000000, double:1.32624737E-315)
            goto L_0x04c6
        L_0x04c3:
            r57 = 134217728(0x8000000, double:6.63123685E-316)
        L_0x04c6:
            long r59 = r59 | r57
        L_0x04c8:
            if (r52 == 0) goto L_0x04d1
            com.google.android.material.checkbox.MaterialCheckBox r8 = r1.cbYears
            r52 = r15
            int r15 = com.blueair.viewcore.R.color.surface_dark_65
            goto L_0x04d7
        L_0x04d1:
            r52 = r15
            com.google.android.material.checkbox.MaterialCheckBox r8 = r1.cbYears
            int r15 = com.blueair.viewcore.R.color.error_red
        L_0x04d7:
            int r8 = getColorFromResource(r8, r15)
            goto L_0x04df
        L_0x04dc:
            r52 = r15
            r8 = 0
        L_0x04df:
            long r57 = r59 & r37
            int r15 = (r57 > r29 ? 1 : (r57 == r29 ? 0 : -1))
            if (r15 == 0) goto L_0x052f
            if (r63 == 0) goto L_0x04ea
            r48 = 1
            goto L_0x04f0
        L_0x04ea:
            boolean r45 = r45.booleanValue()
            r48 = r45
        L_0x04f0:
            if (r15 == 0) goto L_0x04fd
            if (r48 == 0) goto L_0x04f8
            r57 = 20971520(0x1400000, double:1.03613076E-316)
            goto L_0x04fb
        L_0x04f8:
            r57 = 10485760(0xa00000, double:5.180654E-317)
        L_0x04fb:
            long r59 = r59 | r57
        L_0x04fd:
            if (r48 == 0) goto L_0x050a
            com.google.android.material.checkbox.MaterialCheckBox r15 = r1.cbPrivacy
            r45 = r10
            int r10 = com.blueair.viewcore.R.color.surface_dark_65
            int r10 = getColorFromResource(r15, r10)
            goto L_0x0514
        L_0x050a:
            r45 = r10
            com.google.android.material.checkbox.MaterialCheckBox r10 = r1.cbPrivacy
            int r15 = com.blueair.viewcore.R.color.error_red
            int r10 = getColorFromResource(r10, r15)
        L_0x0514:
            if (r48 == 0) goto L_0x0521
            android.widget.TextView r15 = r1.privacyText
            r48 = r10
            int r10 = com.blueair.viewcore.R.color.surface_dark_65
            int r10 = getColorFromResource(r15, r10)
            goto L_0x052b
        L_0x0521:
            r48 = r10
            android.widget.TextView r10 = r1.privacyText
            int r15 = com.blueair.viewcore.R.color.error_red
            int r10 = getColorFromResource(r10, r15)
        L_0x052b:
            r15 = r10
            r10 = r48
            goto L_0x0533
        L_0x052f:
            r45 = r10
            r10 = 0
            r15 = 0
        L_0x0533:
            long r25 = r59 & r25
            int r25 = (r25 > r29 ? 1 : (r25 == r29 ? 0 : -1))
            if (r25 == 0) goto L_0x0545
            if (r3 == 0) goto L_0x053e
            r46 = r7
            goto L_0x0540
        L_0x053e:
            r46 = 0
        L_0x0540:
            r26 = r11
            r11 = r46
            goto L_0x0548
        L_0x0545:
            r26 = r11
            r11 = 0
        L_0x0548:
            if (r25 == 0) goto L_0x0552
            r25 = r14
            com.google.android.material.button.MaterialButton r14 = r1.btnRegister
            r14.setEnabled(r11)
            goto L_0x0554
        L_0x0552:
            r25 = r14
        L_0x0554:
            r57 = 262144(0x40000, double:1.295163E-318)
            long r57 = r59 & r57
            int r11 = (r57 > r29 ? 1 : (r57 == r29 ? 0 : -1))
            if (r11 == 0) goto L_0x05d7
            com.google.android.material.button.MaterialButton r11 = r1.btnRegister
            android.view.View$OnClickListener r14 = r1.mCallback3
            r11.setOnClickListener(r14)
            com.google.android.material.checkbox.MaterialCheckBox r11 = r1.cbConsent
            r14 = r16
            android.widget.CompoundButton$OnCheckedChangeListener r14 = (android.widget.CompoundButton.OnCheckedChangeListener) r14
            androidx.databinding.InverseBindingListener r14 = r1.cbConsentandroidCheckedAttrChanged
            r46 = r6
            r6 = r16
            androidx.databinding.adapters.CompoundButtonBindingAdapter.setListeners(r11, r6, r14)
            com.google.android.material.checkbox.MaterialCheckBox r11 = r1.cbPrivacy
            androidx.databinding.InverseBindingListener r14 = r1.cbPrivacyandroidCheckedAttrChanged
            androidx.databinding.adapters.CompoundButtonBindingAdapter.setListeners(r11, r6, r14)
            com.google.android.material.checkbox.MaterialCheckBox r11 = r1.cbSubscribe
            androidx.databinding.InverseBindingListener r14 = r1.cbSubscribeandroidCheckedAttrChanged
            androidx.databinding.adapters.CompoundButtonBindingAdapter.setListeners(r11, r6, r14)
            com.google.android.material.checkbox.MaterialCheckBox r11 = r1.cbYears
            androidx.databinding.InverseBindingListener r14 = r1.cbYearsandroidCheckedAttrChanged
            androidx.databinding.adapters.CompoundButtonBindingAdapter.setListeners(r11, r6, r14)
            com.google.android.material.textfield.TextInputEditText r11 = r1.confirmPassword
            r14 = r6
            androidx.databinding.adapters.TextViewBindingAdapter$BeforeTextChanged r14 = (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged) r14
            r14 = r6
            androidx.databinding.adapters.TextViewBindingAdapter$OnTextChanged r14 = (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged) r14
            r14 = r6
            androidx.databinding.adapters.TextViewBindingAdapter$AfterTextChanged r14 = (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged) r14
            androidx.databinding.InverseBindingListener r14 = r1.confirmPasswordandroidTextAttrChanged
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(r11, r6, r6, r6, r14)
            com.google.android.material.textfield.TextInputEditText r11 = r1.email
            androidx.databinding.InverseBindingListener r14 = r1.emailandroidTextAttrChanged
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(r11, r6, r6, r6, r14)
            com.google.android.material.textfield.TextInputEditText r11 = r1.firstName
            androidx.databinding.InverseBindingListener r14 = r1.firstNameandroidTextAttrChanged
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(r11, r6, r6, r6, r14)
            com.google.android.material.textfield.TextInputEditText r11 = r1.lastName
            androidx.databinding.InverseBindingListener r14 = r1.lastNameandroidTextAttrChanged
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(r11, r6, r6, r6, r14)
            com.google.android.material.textfield.TextInputEditText r11 = r1.password
            androidx.databinding.InverseBindingListener r14 = r1.passwordandroidTextAttrChanged
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(r11, r6, r6, r6, r14)
            androidx.appcompat.widget.AppCompatTextView r6 = r1.txtFirstNameError
            androidx.appcompat.widget.AppCompatTextView r11 = r1.txtFirstNameError
            android.content.res.Resources r11 = r11.getResources()
            int r14 = com.blueair.viewcore.R.string.enter_first_name
            java.lang.String r11 = r11.getString(r14)
            androidx.databinding.adapters.TextViewBindingAdapter.setText(r6, r11)
            androidx.appcompat.widget.AppCompatTextView r6 = r1.txtLastNameError
            androidx.appcompat.widget.AppCompatTextView r11 = r1.txtLastNameError
            android.content.res.Resources r11 = r11.getResources()
            int r14 = com.blueair.viewcore.R.string.enter_last_name
            java.lang.String r11 = r11.getString(r14)
            androidx.databinding.adapters.TextViewBindingAdapter.setText(r6, r11)
            goto L_0x05d9
        L_0x05d7:
            r46 = r6
        L_0x05d9:
            long r19 = r59 & r19
            int r6 = (r19 > r29 ? 1 : (r19 == r29 ? 0 : -1))
            if (r6 == 0) goto L_0x05e4
            com.google.android.material.checkbox.MaterialCheckBox r6 = r1.cbConsent
            androidx.databinding.adapters.CompoundButtonBindingAdapter.setChecked(r6, r2)
        L_0x05e4:
            long r19 = r59 & r23
            int r2 = (r19 > r29 ? 1 : (r19 == r29 ? 0 : -1))
            if (r2 == 0) goto L_0x05ef
            com.google.android.material.checkbox.MaterialCheckBox r2 = r1.cbPrivacy
            androidx.databinding.adapters.CompoundButtonBindingAdapter.setChecked(r2, r7)
        L_0x05ef:
            long r6 = r59 & r37
            int r2 = (r6 > r29 ? 1 : (r6 == r29 ? 0 : -1))
            if (r2 == 0) goto L_0x05ff
            com.google.android.material.checkbox.MaterialCheckBox r2 = r1.cbPrivacy
            r2.setTextColor(r10)
            android.widget.TextView r2 = r1.privacyText
            r2.setTextColor(r15)
        L_0x05ff:
            long r6 = r59 & r49
            int r2 = (r6 > r29 ? 1 : (r6 == r29 ? 0 : -1))
            if (r2 == 0) goto L_0x060a
            com.google.android.material.checkbox.MaterialCheckBox r2 = r1.cbSubscribe
            androidx.databinding.adapters.CompoundButtonBindingAdapter.setChecked(r2, r4)
        L_0x060a:
            r6 = 401408(0x62000, double:1.98322E-318)
            long r6 = r59 & r6
            int r2 = (r6 > r29 ? 1 : (r6 == r29 ? 0 : -1))
            if (r2 == 0) goto L_0x0618
            com.google.android.material.checkbox.MaterialCheckBox r2 = r1.cbYears
            androidx.databinding.adapters.CompoundButtonBindingAdapter.setChecked(r2, r3)
        L_0x0618:
            long r2 = r59 & r39
            int r2 = (r2 > r29 ? 1 : (r2 == r29 ? 0 : -1))
            if (r2 == 0) goto L_0x0623
            com.google.android.material.checkbox.MaterialCheckBox r2 = r1.cbYears
            r2.setTextColor(r8)
        L_0x0623:
            long r2 = r59 & r43
            int r2 = (r2 > r29 ? 1 : (r2 == r29 ? 0 : -1))
            if (r2 == 0) goto L_0x062e
            com.google.android.material.textfield.TextInputEditText r2 = r1.confirmPassword
            androidx.databinding.adapters.TextViewBindingAdapter.setText(r2, r5)
        L_0x062e:
            long r2 = r59 & r27
            int r2 = (r2 > r29 ? 1 : (r2 == r29 ? 0 : -1))
            if (r2 == 0) goto L_0x0639
            com.google.android.material.textfield.TextInputEditText r2 = r1.email
            androidx.databinding.adapters.TextViewBindingAdapter.setText(r2, r13)
        L_0x0639:
            long r2 = r59 & r55
            int r2 = (r2 > r29 ? 1 : (r2 == r29 ? 0 : -1))
            if (r2 == 0) goto L_0x0644
            com.google.android.material.textfield.TextInputEditText r2 = r1.firstName
            androidx.databinding.adapters.TextViewBindingAdapter.setText(r2, r9)
        L_0x0644:
            long r2 = r59 & r17
            int r2 = (r2 > r29 ? 1 : (r2 == r29 ? 0 : -1))
            if (r2 == 0) goto L_0x064f
            com.google.android.material.textfield.TextInputEditText r2 = r1.lastName
            androidx.databinding.adapters.TextViewBindingAdapter.setText(r2, r12)
        L_0x064f:
            long r2 = r59 & r21
            int r2 = (r2 > r29 ? 1 : (r2 == r29 ? 0 : -1))
            if (r2 == 0) goto L_0x065a
            com.blueair.viewcore.view.ProgressBlockerView r2 = r1.loading
            r2.setVisibility(r0)
        L_0x065a:
            long r2 = r59 & r41
            int r0 = (r2 > r29 ? 1 : (r2 == r29 ? 0 : -1))
            if (r0 == 0) goto L_0x0667
            com.google.android.material.textfield.TextInputEditText r0 = r1.password
            r2 = r46
            androidx.databinding.adapters.TextViewBindingAdapter.setText(r0, r2)
        L_0x0667:
            long r2 = r59 & r33
            int r0 = (r2 > r29 ? 1 : (r2 == r29 ? 0 : -1))
            if (r0 == 0) goto L_0x067b
            com.blueair.viewcore.view.SimpleTextInputLayout r0 = r1.txtConfirmPassword
            r6 = r25
            com.blueair.viewcore.ViewUtilsKt.bindSelected(r0, r6)
            androidx.appcompat.widget.AppCompatTextView r0 = r1.txtConfirmPasswordError
            r10 = r26
            r0.setVisibility(r10)
        L_0x067b:
            long r2 = r59 & r31
            int r0 = (r2 > r29 ? 1 : (r2 == r29 ? 0 : -1))
            if (r0 == 0) goto L_0x0696
            com.blueair.viewcore.view.SimpleTextInputLayout r0 = r1.txtEmail
            r2 = r45
            com.blueair.viewcore.ViewUtilsKt.bindSelected(r0, r2)
            androidx.appcompat.widget.AppCompatTextView r0 = r1.txtEmailError
            r7 = r52
            androidx.databinding.adapters.TextViewBindingAdapter.setText(r0, r7)
            androidx.appcompat.widget.AppCompatTextView r0 = r1.txtEmailError
            r2 = r36
            r0.setVisibility(r2)
        L_0x0696:
            r2 = 458752(0x70000, double:2.266536E-318)
            long r2 = r59 & r2
            int r0 = (r2 > r29 ? 1 : (r2 == r29 ? 0 : -1))
            if (r0 == 0) goto L_0x06ad
            com.blueair.viewcore.view.SimpleTextInputLayout r0 = r1.txtFirstName
            r2 = r35
            com.blueair.viewcore.ViewUtilsKt.bindSelected(r0, r2)
            androidx.appcompat.widget.AppCompatTextView r0 = r1.txtFirstNameError
            r2 = r75
            r0.setVisibility(r2)
        L_0x06ad:
            r2 = 425984(0x68000, double:2.10464E-318)
            long r2 = r59 & r2
            int r0 = (r2 > r29 ? 1 : (r2 == r29 ? 0 : -1))
            if (r0 == 0) goto L_0x06c4
            com.blueair.viewcore.view.SimpleTextInputLayout r0 = r1.txtLastName
            r2 = r66
            com.blueair.viewcore.ViewUtilsKt.bindSelected(r0, r2)
            androidx.appcompat.widget.AppCompatTextView r0 = r1.txtLastNameError
            r2 = r65
            r0.setVisibility(r2)
        L_0x06c4:
            long r2 = r59 & r53
            int r0 = (r2 > r29 ? 1 : (r2 == r29 ? 0 : -1))
            if (r0 == 0) goto L_0x06df
            com.blueair.viewcore.view.SimpleTextInputLayout r0 = r1.txtPassword
            r3 = r51
            com.blueair.viewcore.ViewUtilsKt.bindSelected(r0, r3)
            androidx.appcompat.widget.AppCompatTextView r0 = r1.txtPasswordError
            r2 = r47
            androidx.databinding.adapters.TextViewBindingAdapter.setText(r0, r2)
            androidx.appcompat.widget.AppCompatTextView r0 = r1.txtPasswordError
            r15 = r74
            r0.setVisibility(r15)
        L_0x06df:
            return
        L_0x06e0:
            r0 = move-exception
            monitor-exit(r76)     // Catch:{ all -> 0x06e0 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.login.databinding.FragmentRegisterBindingImpl.executeBindings():void");
    }

    public final void _internalCallbackOnClick(int i, View view) {
        RegisterViewModel registerViewModel = this.mViewModel;
        if (registerViewModel != null) {
            registerViewModel.register();
        }
    }
}
