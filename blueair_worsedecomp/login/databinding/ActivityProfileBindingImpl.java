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
import com.blueair.login.ProfileViewModel;
import com.blueair.login.R;
import com.blueair.login.generated.callback.OnClickListener;

public class ActivityProfileBindingImpl extends ActivityProfileBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private InverseBindingListener addressandroidTextAttrChanged;
    private InverseBindingListener areaandroidTextAttrChanged;
    private InverseBindingListener cbDataConsentandroidCheckedAttrChanged;
    private InverseBindingListener cbSubscribeandroidCheckedAttrChanged;
    private InverseBindingListener cityandroidTextAttrChanged;
    private InverseBindingListener countryandroidTextAttrChanged;
    private InverseBindingListener firstNameandroidTextAttrChanged;
    private InverseBindingListener lastNameandroidTextAttrChanged;
    private final View.OnClickListener mCallback2;
    private long mDirtyFlags;
    private final FrameLayout mboundView0;
    private InverseBindingListener phoneNumberandroidTextAttrChanged;
    private InverseBindingListener zipCodeandroidTextAttrChanged;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.toolbar, 16);
        sparseIntArray.put(R.id.btnClose, 17);
        sparseIntArray.put(R.id.scrollableRoot, 18);
        sparseIntArray.put(R.id.txtAccountTitle, 19);
        sparseIntArray.put(R.id.txtAddressTitle, 20);
        sparseIntArray.put(R.id.btnManageMyAccount, 21);
        sparseIntArray.put(R.id.txtEmail, 22);
        sparseIntArray.put(R.id.txtPhoneNumber, 23);
        sparseIntArray.put(R.id.txtAddress, 24);
        sparseIntArray.put(R.id.txtZipCode, 25);
        sparseIntArray.put(R.id.txtArea, 26);
        sparseIntArray.put(R.id.txtCity, 27);
        sparseIntArray.put(R.id.txtCountry, 28);
    }

    public ActivityProfileBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 29, sIncludes, sViewsWithIds));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private ActivityProfileBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 14, objArr[8], objArr[10], objArr[17], objArr[21], objArr[1], objArr[14], objArr[13], objArr[11], objArr[12], objArr[2], objArr[4], objArr[6], objArr[15], objArr[7], objArr[18], objArr[16], objArr[19], objArr[24], objArr[20], objArr[26], objArr[27], objArr[28], objArr[22], objArr[3], objArr[5], objArr[23], objArr[25], objArr[9]);
        this.addressandroidTextAttrChanged = new InverseBindingListener() {
            public void onChange() {
                MutableLiveData<String> address;
                String textString = TextViewBindingAdapter.getTextString(ActivityProfileBindingImpl.this.address);
                ProfileViewModel profileViewModel = ActivityProfileBindingImpl.this.mViewModel;
                if (profileViewModel != null && (address = profileViewModel.getAddress()) != null) {
                    address.setValue(textString);
                }
            }
        };
        this.areaandroidTextAttrChanged = new InverseBindingListener() {
            public void onChange() {
                MutableLiveData<String> area;
                String textString = TextViewBindingAdapter.getTextString(ActivityProfileBindingImpl.this.area);
                ProfileViewModel profileViewModel = ActivityProfileBindingImpl.this.mViewModel;
                if (profileViewModel != null && (area = profileViewModel.getArea()) != null) {
                    area.setValue(textString);
                }
            }
        };
        this.cbDataConsentandroidCheckedAttrChanged = new InverseBindingListener() {
            public void onChange() {
                MutableLiveData<Boolean> consentData;
                boolean isChecked = ActivityProfileBindingImpl.this.cbDataConsent.isChecked();
                ProfileViewModel profileViewModel = ActivityProfileBindingImpl.this.mViewModel;
                if (profileViewModel != null && (consentData = profileViewModel.getConsentData()) != null) {
                    consentData.setValue(Boolean.valueOf(isChecked));
                }
            }
        };
        this.cbSubscribeandroidCheckedAttrChanged = new InverseBindingListener() {
            public void onChange() {
                MutableLiveData<Boolean> subscribe;
                boolean isChecked = ActivityProfileBindingImpl.this.cbSubscribe.isChecked();
                ProfileViewModel profileViewModel = ActivityProfileBindingImpl.this.mViewModel;
                if (profileViewModel != null && (subscribe = profileViewModel.getSubscribe()) != null) {
                    subscribe.setValue(Boolean.valueOf(isChecked));
                }
            }
        };
        this.cityandroidTextAttrChanged = new InverseBindingListener() {
            public void onChange() {
                MutableLiveData<String> city;
                String textString = TextViewBindingAdapter.getTextString(ActivityProfileBindingImpl.this.city);
                ProfileViewModel profileViewModel = ActivityProfileBindingImpl.this.mViewModel;
                if (profileViewModel != null && (city = profileViewModel.getCity()) != null) {
                    city.setValue(textString);
                }
            }
        };
        this.countryandroidTextAttrChanged = new InverseBindingListener() {
            public void onChange() {
                MutableLiveData<String> country;
                String textString = TextViewBindingAdapter.getTextString(ActivityProfileBindingImpl.this.country);
                ProfileViewModel profileViewModel = ActivityProfileBindingImpl.this.mViewModel;
                if (profileViewModel != null && (country = profileViewModel.getCountry()) != null) {
                    country.setValue(textString);
                }
            }
        };
        this.firstNameandroidTextAttrChanged = new InverseBindingListener() {
            public void onChange() {
                MutableLiveData<String> firstName;
                String textString = TextViewBindingAdapter.getTextString(ActivityProfileBindingImpl.this.firstName);
                ProfileViewModel profileViewModel = ActivityProfileBindingImpl.this.mViewModel;
                if (profileViewModel != null && (firstName = profileViewModel.getFirstName()) != null) {
                    firstName.setValue(textString);
                }
            }
        };
        this.lastNameandroidTextAttrChanged = new InverseBindingListener() {
            public void onChange() {
                MutableLiveData<String> lastName;
                String textString = TextViewBindingAdapter.getTextString(ActivityProfileBindingImpl.this.lastName);
                ProfileViewModel profileViewModel = ActivityProfileBindingImpl.this.mViewModel;
                if (profileViewModel != null && (lastName = profileViewModel.getLastName()) != null) {
                    lastName.setValue(textString);
                }
            }
        };
        this.phoneNumberandroidTextAttrChanged = new InverseBindingListener() {
            public void onChange() {
                MutableLiveData<String> phoneNumber;
                String textString = TextViewBindingAdapter.getTextString(ActivityProfileBindingImpl.this.phoneNumber);
                ProfileViewModel profileViewModel = ActivityProfileBindingImpl.this.mViewModel;
                if (profileViewModel != null && (phoneNumber = profileViewModel.getPhoneNumber()) != null) {
                    phoneNumber.setValue(textString);
                }
            }
        };
        this.zipCodeandroidTextAttrChanged = new InverseBindingListener() {
            public void onChange() {
                MutableLiveData<String> zipCode;
                String textString = TextViewBindingAdapter.getTextString(ActivityProfileBindingImpl.this.zipCode);
                ProfileViewModel profileViewModel = ActivityProfileBindingImpl.this.mViewModel;
                if (profileViewModel != null && (zipCode = profileViewModel.getZipCode()) != null) {
                    zipCode.setValue(textString);
                }
            }
        };
        this.mDirtyFlags = -1;
        this.address.setTag((Object) null);
        this.area.setTag((Object) null);
        this.btnSave.setTag((Object) null);
        this.cbDataConsent.setTag((Object) null);
        this.cbSubscribe.setTag((Object) null);
        this.city.setTag((Object) null);
        this.country.setTag((Object) null);
        this.email.setTag((Object) null);
        this.firstName.setTag((Object) null);
        this.lastName.setTag((Object) null);
        this.loading.setTag((Object) null);
        FrameLayout frameLayout = objArr[0];
        this.mboundView0 = frameLayout;
        frameLayout.setTag((Object) null);
        this.phoneNumber.setTag((Object) null);
        this.txtFirstName.setTag((Object) null);
        this.txtLastName.setTag((Object) null);
        this.zipCode.setTag((Object) null);
        setRootTag(view);
        this.mCallback2 = new OnClickListener(this, 1);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
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
        setViewModel((ProfileViewModel) obj);
        return true;
    }

    public void setViewModel(ProfileViewModel profileViewModel) {
        this.mViewModel = profileViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 16384;
        }
        notifyPropertyChanged(BR.viewModel);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return onChangeViewModelPhoneNumber((MutableLiveData) obj, i2);
            case 1:
                return onChangeViewModelEmail((MutableLiveData) obj, i2);
            case 2:
                return onChangeViewModelAddress((MutableLiveData) obj, i2);
            case 3:
                return onChangeViewModelArea((MutableLiveData) obj, i2);
            case 4:
                return onChangeViewModelLoading((LiveData) obj, i2);
            case 5:
                return onChangeViewModelZipCode((MutableLiveData) obj, i2);
            case 6:
                return onChangeViewModelLastName((MutableLiveData) obj, i2);
            case 7:
                return onChangeViewModelFirstName((MutableLiveData) obj, i2);
            case 8:
                return onChangeViewModelCountry((MutableLiveData) obj, i2);
            case 9:
                return onChangeViewModelLastNameValid((MutableLiveData) obj, i2);
            case 10:
                return onChangeViewModelFirstNameValid((MutableLiveData) obj, i2);
            case 11:
                return onChangeViewModelConsentData((MutableLiveData) obj, i2);
            case 12:
                return onChangeViewModelCity((MutableLiveData) obj, i2);
            case 13:
                return onChangeViewModelSubscribe((MutableLiveData) obj, i2);
            default:
                return false;
        }
    }

    private boolean onChangeViewModelPhoneNumber(MutableLiveData<String> mutableLiveData, int i) {
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

    private boolean onChangeViewModelAddress(MutableLiveData<String> mutableLiveData, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeViewModelArea(MutableLiveData<String> mutableLiveData, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeViewModelLoading(LiveData<Boolean> liveData, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    private boolean onChangeViewModelZipCode(MutableLiveData<String> mutableLiveData, int i) {
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

    private boolean onChangeViewModelCountry(MutableLiveData<String> mutableLiveData, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 256;
        }
        return true;
    }

    private boolean onChangeViewModelLastNameValid(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 512;
        }
        return true;
    }

    private boolean onChangeViewModelFirstNameValid(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1024;
        }
        return true;
    }

    private boolean onChangeViewModelConsentData(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2048;
        }
        return true;
    }

    private boolean onChangeViewModelCity(MutableLiveData<String> mutableLiveData, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4096;
        }
        return true;
    }

    private boolean onChangeViewModelSubscribe(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
        }
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v26, resolved type: java.lang.Boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v29, resolved type: java.lang.Boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v11, resolved type: java.lang.Boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v13, resolved type: java.lang.Boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v38, resolved type: java.lang.Boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v43, resolved type: java.lang.Boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v3, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v4, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v5, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v46, resolved type: java.lang.Boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v21, resolved type: androidx.lifecycle.MutableLiveData<java.lang.Boolean>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v22, resolved type: androidx.lifecycle.MutableLiveData<java.lang.String>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v29, resolved type: java.lang.Boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v30, resolved type: androidx.lifecycle.MutableLiveData<java.lang.Boolean>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v47, resolved type: java.lang.Boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v23, resolved type: androidx.lifecycle.MutableLiveData<java.lang.Boolean>} */
    /* JADX WARNING: type inference failed for: r13v2, types: [androidx.databinding.adapters.TextViewBindingAdapter$BeforeTextChanged, androidx.databinding.adapters.TextViewBindingAdapter$OnTextChanged, android.widget.CompoundButton$OnCheckedChangeListener, androidx.databinding.adapters.TextViewBindingAdapter$AfterTextChanged] */
    /* JADX WARNING: type inference failed for: r15v7, types: [androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData] */
    /* JADX WARNING: type inference failed for: r15v9 */
    /* JADX WARNING: type inference failed for: r15v11, types: [androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData] */
    /* JADX WARNING: type inference failed for: r15v12 */
    /* JADX WARNING: type inference failed for: r14v10, types: [androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData] */
    /* JADX WARNING: type inference failed for: r14v16 */
    /* JADX WARNING: type inference failed for: r15v15, types: [androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData] */
    /* JADX WARNING: type inference failed for: r15v16 */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x016b  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x01ad  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x01b9  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x01f4  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x01fe  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x021c  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x0223  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x023c  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x0246  */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x026d  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00ee  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0114  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x012b  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0134  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0150  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
            r56 = this;
            r1 = r56
            monitor-enter(r56)
            long r2 = r1.mDirtyFlags     // Catch:{ all -> 0x03b5 }
            r4 = 0
            r1.mDirtyFlags = r4     // Catch:{ all -> 0x03b5 }
            monitor-exit(r56)     // Catch:{ all -> 0x03b5 }
            com.blueair.login.ProfileViewModel r0 = r1.mViewModel
            r6 = 65535(0xffff, double:3.23786E-319)
            long r6 = r6 & r2
            int r6 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            r13 = 49216(0xc040, double:2.4316E-319)
            r15 = 49408(0xc100, double:2.4411E-319)
            r17 = 49184(0xc020, double:2.43E-319)
            r19 = 53248(0xd000, double:2.6308E-319)
            r21 = 49168(0xc010, double:2.4292E-319)
            r23 = 57344(0xe000, double:2.83317E-319)
            r25 = 51200(0xc800, double:2.5296E-319)
            r27 = 49160(0xc008, double:2.42883E-319)
            r29 = 49154(0xc002, double:2.42853E-319)
            r31 = 49153(0xc001, double:2.4285E-319)
            r33 = 49156(0xc004, double:2.42863E-319)
            r35 = r4
            r4 = 0
            if (r6 == 0) goto L_0x028c
            long r37 = r2 & r31
            int r6 = (r37 > r35 ? 1 : (r37 == r35 ? 0 : -1))
            if (r6 == 0) goto L_0x0052
            if (r0 == 0) goto L_0x0045
            androidx.lifecycle.MutableLiveData r6 = r0.getPhoneNumber()
            goto L_0x0046
        L_0x0045:
            r6 = 0
        L_0x0046:
            r1.updateLiveDataRegistration(r4, r6)
            if (r6 == 0) goto L_0x0052
            java.lang.Object r6 = r6.getValue()
            java.lang.String r6 = (java.lang.String) r6
            goto L_0x0053
        L_0x0052:
            r6 = 0
        L_0x0053:
            long r37 = r2 & r29
            int r37 = (r37 > r35 ? 1 : (r37 == r35 ? 0 : -1))
            if (r37 == 0) goto L_0x0073
            if (r0 == 0) goto L_0x0062
            androidx.lifecycle.MutableLiveData r37 = r0.getEmail()
            r4 = r37
            goto L_0x0063
        L_0x0062:
            r4 = 0
        L_0x0063:
            r38 = 50176(0xc400, double:2.479E-319)
            r7 = 1
            r1.updateLiveDataRegistration(r7, r4)
            if (r4 == 0) goto L_0x0076
            java.lang.Object r4 = r4.getValue()
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x0077
        L_0x0073:
            r38 = 50176(0xc400, double:2.479E-319)
        L_0x0076:
            r4 = 0
        L_0x0077:
            long r7 = r2 & r33
            int r7 = (r7 > r35 ? 1 : (r7 == r35 ? 0 : -1))
            if (r7 == 0) goto L_0x0092
            if (r0 == 0) goto L_0x0084
            androidx.lifecycle.MutableLiveData r7 = r0.getAddress()
            goto L_0x0085
        L_0x0084:
            r7 = 0
        L_0x0085:
            r8 = 2
            r1.updateLiveDataRegistration(r8, r7)
            if (r7 == 0) goto L_0x0092
            java.lang.Object r7 = r7.getValue()
            java.lang.String r7 = (java.lang.String) r7
            goto L_0x0093
        L_0x0092:
            r7 = 0
        L_0x0093:
            long r40 = r2 & r27
            int r8 = (r40 > r35 ? 1 : (r40 == r35 ? 0 : -1))
            if (r8 == 0) goto L_0x00b1
            if (r0 == 0) goto L_0x00a0
            androidx.lifecycle.MutableLiveData r8 = r0.getArea()
            goto L_0x00a1
        L_0x00a0:
            r8 = 0
        L_0x00a1:
            r40 = 49664(0xc200, double:2.45373E-319)
            r9 = 3
            r1.updateLiveDataRegistration(r9, r8)
            if (r8 == 0) goto L_0x00b4
            java.lang.Object r8 = r8.getValue()
            java.lang.String r8 = (java.lang.String) r8
            goto L_0x00b5
        L_0x00b1:
            r40 = 49664(0xc200, double:2.45373E-319)
        L_0x00b4:
            r8 = 0
        L_0x00b5:
            long r9 = r2 & r21
            int r9 = (r9 > r35 ? 1 : (r9 == r35 ? 0 : -1))
            r10 = 8
            if (r9 == 0) goto L_0x00ee
            if (r0 == 0) goto L_0x00c6
            androidx.lifecycle.LiveData r42 = r0.getLoading()
            r11 = r42
            goto L_0x00c7
        L_0x00c6:
            r11 = 0
        L_0x00c7:
            r42 = 49280(0xc080, double:2.43476E-319)
            r12 = 4
            r1.updateLiveDataRegistration(r12, r11)
            if (r11 == 0) goto L_0x00d7
            java.lang.Object r11 = r11.getValue()
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            goto L_0x00d8
        L_0x00d7:
            r11 = 0
        L_0x00d8:
            boolean r11 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r11)
            if (r9 == 0) goto L_0x00e9
            if (r11 == 0) goto L_0x00e4
            r44 = 524288(0x80000, double:2.590327E-318)
            goto L_0x00e7
        L_0x00e4:
            r44 = 262144(0x40000, double:1.295163E-318)
        L_0x00e7:
            long r2 = r2 | r44
        L_0x00e9:
            if (r11 == 0) goto L_0x00ec
            goto L_0x00f1
        L_0x00ec:
            r9 = r10
            goto L_0x00f2
        L_0x00ee:
            r42 = 49280(0xc080, double:2.43476E-319)
        L_0x00f1:
            r9 = 0
        L_0x00f2:
            long r11 = r2 & r17
            int r11 = (r11 > r35 ? 1 : (r11 == r35 ? 0 : -1))
            if (r11 == 0) goto L_0x010d
            if (r0 == 0) goto L_0x00ff
            androidx.lifecycle.MutableLiveData r11 = r0.getZipCode()
            goto L_0x0100
        L_0x00ff:
            r11 = 0
        L_0x0100:
            r12 = 5
            r1.updateLiveDataRegistration(r12, r11)
            if (r11 == 0) goto L_0x010d
            java.lang.Object r11 = r11.getValue()
            java.lang.String r11 = (java.lang.String) r11
            goto L_0x010e
        L_0x010d:
            r11 = 0
        L_0x010e:
            long r44 = r2 & r13
            int r12 = (r44 > r35 ? 1 : (r44 == r35 ? 0 : -1))
            if (r12 == 0) goto L_0x012b
            if (r0 == 0) goto L_0x011b
            androidx.lifecycle.MutableLiveData r12 = r0.getLastName()
            goto L_0x011c
        L_0x011b:
            r12 = 0
        L_0x011c:
            r44 = r13
            r13 = 6
            r1.updateLiveDataRegistration(r13, r12)
            if (r12 == 0) goto L_0x012d
            java.lang.Object r12 = r12.getValue()
            java.lang.String r12 = (java.lang.String) r12
            goto L_0x012e
        L_0x012b:
            r44 = r13
        L_0x012d:
            r12 = 0
        L_0x012e:
            long r13 = r2 & r42
            int r13 = (r13 > r35 ? 1 : (r13 == r35 ? 0 : -1))
            if (r13 == 0) goto L_0x0149
            if (r0 == 0) goto L_0x013b
            androidx.lifecycle.MutableLiveData r13 = r0.getFirstName()
            goto L_0x013c
        L_0x013b:
            r13 = 0
        L_0x013c:
            r14 = 7
            r1.updateLiveDataRegistration(r14, r13)
            if (r13 == 0) goto L_0x0149
            java.lang.Object r13 = r13.getValue()
            java.lang.String r13 = (java.lang.String) r13
            goto L_0x014a
        L_0x0149:
            r13 = 0
        L_0x014a:
            long r46 = r2 & r15
            int r14 = (r46 > r35 ? 1 : (r46 == r35 ? 0 : -1))
            if (r14 == 0) goto L_0x0164
            if (r0 == 0) goto L_0x0157
            androidx.lifecycle.MutableLiveData r14 = r0.getCountry()
            goto L_0x0158
        L_0x0157:
            r14 = 0
        L_0x0158:
            r1.updateLiveDataRegistration(r10, r14)
            if (r14 == 0) goto L_0x0164
            java.lang.Object r10 = r14.getValue()
            java.lang.String r10 = (java.lang.String) r10
            goto L_0x0165
        L_0x0164:
            r10 = 0
        L_0x0165:
            long r46 = r2 & r40
            int r14 = (r46 > r35 ? 1 : (r46 == r35 ? 0 : -1))
            if (r14 == 0) goto L_0x01ad
            if (r0 == 0) goto L_0x0178
            androidx.lifecycle.MutableLiveData r46 = r0.getLastNameValid()
            r52 = r15
            r15 = r46
            r46 = r52
            goto L_0x017b
        L_0x0178:
            r46 = r15
            r15 = 0
        L_0x017b:
            r16 = 0
            r5 = 9
            r1.updateLiveDataRegistration(r5, r15)
            if (r15 == 0) goto L_0x018b
            java.lang.Object r5 = r15.getValue()
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            goto L_0x018d
        L_0x018b:
            r5 = r16
        L_0x018d:
            boolean r5 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r5)
            if (r14 == 0) goto L_0x019d
            if (r5 == 0) goto L_0x0199
            r14 = 131072(0x20000, double:6.47582E-319)
            goto L_0x019c
        L_0x0199:
            r14 = 65536(0x10000, double:3.2379E-319)
        L_0x019c:
            long r2 = r2 | r14
        L_0x019d:
            if (r5 == 0) goto L_0x01a0
            goto L_0x01b1
        L_0x01a0:
            com.google.android.material.textfield.TextInputLayout r5 = r1.txtLastName
            android.content.res.Resources r5 = r5.getResources()
            int r14 = com.blueair.viewcore.R.string.enter_last_name
            java.lang.String r5 = r5.getString(r14)
            goto L_0x01b3
        L_0x01ad:
            r46 = r15
            r16 = 0
        L_0x01b1:
            r5 = r16
        L_0x01b3:
            long r14 = r2 & r38
            int r14 = (r14 > r35 ? 1 : (r14 == r35 ? 0 : -1))
            if (r14 == 0) goto L_0x01f4
            if (r0 == 0) goto L_0x01c0
            androidx.lifecycle.MutableLiveData r15 = r0.getFirstNameValid()
            goto L_0x01c2
        L_0x01c0:
            r15 = r16
        L_0x01c2:
            r48 = r0
            r0 = 10
            r1.updateLiveDataRegistration(r0, r15)
            if (r15 == 0) goto L_0x01d2
            java.lang.Object r0 = r15.getValue()
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            goto L_0x01d4
        L_0x01d2:
            r0 = r16
        L_0x01d4:
            boolean r0 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r0)
            if (r14 == 0) goto L_0x01e4
            if (r0 == 0) goto L_0x01e0
            r14 = 2097152(0x200000, double:1.0361308E-317)
            goto L_0x01e3
        L_0x01e0:
            r14 = 1048576(0x100000, double:5.180654E-318)
        L_0x01e3:
            long r2 = r2 | r14
        L_0x01e4:
            if (r0 == 0) goto L_0x01e7
            goto L_0x01f6
        L_0x01e7:
            com.google.android.material.textfield.TextInputLayout r0 = r1.txtFirstName
            android.content.res.Resources r0 = r0.getResources()
            int r14 = com.blueair.viewcore.R.string.enter_first_name
            java.lang.String r0 = r0.getString(r14)
            goto L_0x01f8
        L_0x01f4:
            r48 = r0
        L_0x01f6:
            r0 = r16
        L_0x01f8:
            long r14 = r2 & r25
            int r14 = (r14 > r35 ? 1 : (r14 == r35 ? 0 : -1))
            if (r14 == 0) goto L_0x021c
            if (r48 == 0) goto L_0x0205
            androidx.lifecycle.MutableLiveData r14 = r48.getConsentData()
            goto L_0x0207
        L_0x0205:
            r14 = r16
        L_0x0207:
            r15 = 11
            r1.updateLiveDataRegistration(r15, r14)
            if (r14 == 0) goto L_0x0215
            java.lang.Object r14 = r14.getValue()
            java.lang.Boolean r14 = (java.lang.Boolean) r14
            goto L_0x0217
        L_0x0215:
            r14 = r16
        L_0x0217:
            boolean r14 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r14)
            goto L_0x021d
        L_0x021c:
            r14 = 0
        L_0x021d:
            long r49 = r2 & r19
            int r15 = (r49 > r35 ? 1 : (r49 == r35 ? 0 : -1))
            if (r15 == 0) goto L_0x023c
            if (r48 == 0) goto L_0x022a
            androidx.lifecycle.MutableLiveData r15 = r48.getCity()
            goto L_0x022c
        L_0x022a:
            r15 = r16
        L_0x022c:
            r49 = r0
            r0 = 12
            r1.updateLiveDataRegistration(r0, r15)
            if (r15 == 0) goto L_0x023e
            java.lang.Object r0 = r15.getValue()
            java.lang.String r0 = (java.lang.String) r0
            goto L_0x0240
        L_0x023c:
            r49 = r0
        L_0x023e:
            r0 = r16
        L_0x0240:
            long r50 = r2 & r23
            int r15 = (r50 > r35 ? 1 : (r50 == r35 ? 0 : -1))
            if (r15 == 0) goto L_0x026d
            if (r48 == 0) goto L_0x024d
            androidx.lifecycle.MutableLiveData r15 = r48.getSubscribe()
            goto L_0x024f
        L_0x024d:
            r15 = r16
        L_0x024f:
            r48 = r0
            r0 = 13
            r1.updateLiveDataRegistration(r0, r15)
            if (r15 == 0) goto L_0x025f
            java.lang.Object r0 = r15.getValue()
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            goto L_0x0261
        L_0x025f:
            r0 = r16
        L_0x0261:
            boolean r0 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r0)
            r15 = r12
            r12 = r10
            r10 = r7
            r7 = r5
            r5 = r0
            r0 = r48
            goto L_0x0274
        L_0x026d:
            r48 = r0
            r15 = r12
            r12 = r10
            r10 = r7
            r7 = r5
            r5 = 0
        L_0x0274:
            r52 = r6
            r6 = r4
            r53 = r8
            r8 = r52
            r52 = r11
            r11 = r53
            r53 = r13
            r13 = r52
            r54 = r2
            r3 = r53
            r2 = r49
            r48 = r54
            goto L_0x02ac
        L_0x028c:
            r44 = r13
            r46 = r15
            r16 = 0
            r38 = 50176(0xc400, double:2.479E-319)
            r40 = 49664(0xc200, double:2.45373E-319)
            r42 = 49280(0xc080, double:2.43476E-319)
            r48 = r2
            r0 = r16
            r2 = r0
            r3 = r2
            r6 = r3
            r7 = r6
            r8 = r7
            r10 = r8
            r11 = r10
            r12 = r11
            r13 = r12
            r15 = r13
            r5 = 0
            r9 = 0
            r14 = 0
        L_0x02ac:
            long r33 = r48 & r33
            int r4 = (r33 > r35 ? 1 : (r33 == r35 ? 0 : -1))
            if (r4 == 0) goto L_0x02b7
            com.google.android.material.textfield.TextInputEditText r4 = r1.address
            androidx.databinding.adapters.TextViewBindingAdapter.setText(r4, r10)
        L_0x02b7:
            r33 = 32768(0x8000, double:1.61895E-319)
            long r33 = r48 & r33
            int r4 = (r33 > r35 ? 1 : (r33 == r35 ? 0 : -1))
            if (r4 == 0) goto L_0x0321
            com.google.android.material.textfield.TextInputEditText r4 = r1.address
            r10 = r16
            androidx.databinding.adapters.TextViewBindingAdapter$BeforeTextChanged r10 = (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged) r10
            r10 = r16
            androidx.databinding.adapters.TextViewBindingAdapter$OnTextChanged r10 = (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged) r10
            r10 = r16
            androidx.databinding.adapters.TextViewBindingAdapter$AfterTextChanged r10 = (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged) r10
            androidx.databinding.InverseBindingListener r10 = r1.addressandroidTextAttrChanged
            r33 = r13
            r13 = r16
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(r4, r13, r13, r13, r10)
            com.google.android.material.textfield.TextInputEditText r4 = r1.area
            androidx.databinding.InverseBindingListener r10 = r1.areaandroidTextAttrChanged
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(r4, r13, r13, r13, r10)
            com.google.android.material.button.MaterialButton r4 = r1.btnSave
            android.view.View$OnClickListener r10 = r1.mCallback2
            r4.setOnClickListener(r10)
            com.google.android.material.checkbox.MaterialCheckBox r4 = r1.cbDataConsent
            r10 = r13
            android.widget.CompoundButton$OnCheckedChangeListener r10 = (android.widget.CompoundButton.OnCheckedChangeListener) r10
            androidx.databinding.InverseBindingListener r10 = r1.cbDataConsentandroidCheckedAttrChanged
            androidx.databinding.adapters.CompoundButtonBindingAdapter.setListeners(r4, r13, r10)
            com.google.android.material.checkbox.MaterialCheckBox r4 = r1.cbSubscribe
            androidx.databinding.InverseBindingListener r10 = r1.cbSubscribeandroidCheckedAttrChanged
            androidx.databinding.adapters.CompoundButtonBindingAdapter.setListeners(r4, r13, r10)
            com.google.android.material.textfield.TextInputEditText r4 = r1.city
            androidx.databinding.InverseBindingListener r10 = r1.cityandroidTextAttrChanged
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(r4, r13, r13, r13, r10)
            com.google.android.material.textfield.TextInputEditText r4 = r1.country
            androidx.databinding.InverseBindingListener r10 = r1.countryandroidTextAttrChanged
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(r4, r13, r13, r13, r10)
            com.google.android.material.textfield.TextInputEditText r4 = r1.firstName
            androidx.databinding.InverseBindingListener r10 = r1.firstNameandroidTextAttrChanged
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(r4, r13, r13, r13, r10)
            com.google.android.material.textfield.TextInputEditText r4 = r1.lastName
            androidx.databinding.InverseBindingListener r10 = r1.lastNameandroidTextAttrChanged
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(r4, r13, r13, r13, r10)
            com.google.android.material.textfield.TextInputEditText r4 = r1.phoneNumber
            androidx.databinding.InverseBindingListener r10 = r1.phoneNumberandroidTextAttrChanged
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(r4, r13, r13, r13, r10)
            com.google.android.material.textfield.TextInputEditText r4 = r1.zipCode
            androidx.databinding.InverseBindingListener r10 = r1.zipCodeandroidTextAttrChanged
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(r4, r13, r13, r13, r10)
            goto L_0x0323
        L_0x0321:
            r33 = r13
        L_0x0323:
            long r27 = r48 & r27
            int r4 = (r27 > r35 ? 1 : (r27 == r35 ? 0 : -1))
            if (r4 == 0) goto L_0x032e
            com.google.android.material.textfield.TextInputEditText r4 = r1.area
            androidx.databinding.adapters.TextViewBindingAdapter.setText(r4, r11)
        L_0x032e:
            long r10 = r48 & r25
            int r4 = (r10 > r35 ? 1 : (r10 == r35 ? 0 : -1))
            if (r4 == 0) goto L_0x0339
            com.google.android.material.checkbox.MaterialCheckBox r4 = r1.cbDataConsent
            androidx.databinding.adapters.CompoundButtonBindingAdapter.setChecked(r4, r14)
        L_0x0339:
            long r10 = r48 & r23
            int r4 = (r10 > r35 ? 1 : (r10 == r35 ? 0 : -1))
            if (r4 == 0) goto L_0x0344
            com.google.android.material.checkbox.MaterialCheckBox r4 = r1.cbSubscribe
            androidx.databinding.adapters.CompoundButtonBindingAdapter.setChecked(r4, r5)
        L_0x0344:
            long r4 = r48 & r19
            int r4 = (r4 > r35 ? 1 : (r4 == r35 ? 0 : -1))
            if (r4 == 0) goto L_0x034f
            com.google.android.material.textfield.TextInputEditText r4 = r1.city
            androidx.databinding.adapters.TextViewBindingAdapter.setText(r4, r0)
        L_0x034f:
            long r4 = r48 & r46
            int r0 = (r4 > r35 ? 1 : (r4 == r35 ? 0 : -1))
            if (r0 == 0) goto L_0x035a
            com.google.android.material.textfield.TextInputEditText r0 = r1.country
            androidx.databinding.adapters.TextViewBindingAdapter.setText(r0, r12)
        L_0x035a:
            long r4 = r48 & r29
            int r0 = (r4 > r35 ? 1 : (r4 == r35 ? 0 : -1))
            if (r0 == 0) goto L_0x0365
            com.google.android.material.textfield.TextInputEditText r0 = r1.email
            androidx.databinding.adapters.TextViewBindingAdapter.setText(r0, r6)
        L_0x0365:
            long r4 = r48 & r42
            int r0 = (r4 > r35 ? 1 : (r4 == r35 ? 0 : -1))
            if (r0 == 0) goto L_0x0370
            com.google.android.material.textfield.TextInputEditText r0 = r1.firstName
            androidx.databinding.adapters.TextViewBindingAdapter.setText(r0, r3)
        L_0x0370:
            long r3 = r48 & r44
            int r0 = (r3 > r35 ? 1 : (r3 == r35 ? 0 : -1))
            if (r0 == 0) goto L_0x037b
            com.google.android.material.textfield.TextInputEditText r0 = r1.lastName
            androidx.databinding.adapters.TextViewBindingAdapter.setText(r0, r15)
        L_0x037b:
            long r3 = r48 & r21
            int r0 = (r3 > r35 ? 1 : (r3 == r35 ? 0 : -1))
            if (r0 == 0) goto L_0x0386
            com.blueair.viewcore.view.ProgressBlockerView r0 = r1.loading
            r0.setVisibility(r9)
        L_0x0386:
            long r3 = r48 & r31
            int r0 = (r3 > r35 ? 1 : (r3 == r35 ? 0 : -1))
            if (r0 == 0) goto L_0x0391
            com.google.android.material.textfield.TextInputEditText r0 = r1.phoneNumber
            androidx.databinding.adapters.TextViewBindingAdapter.setText(r0, r8)
        L_0x0391:
            long r3 = r48 & r38
            int r0 = (r3 > r35 ? 1 : (r3 == r35 ? 0 : -1))
            if (r0 == 0) goto L_0x039c
            com.google.android.material.textfield.TextInputLayout r0 = r1.txtFirstName
            com.blueair.login.BindingAdapterKt.errorText(r0, r2)
        L_0x039c:
            long r2 = r48 & r40
            int r0 = (r2 > r35 ? 1 : (r2 == r35 ? 0 : -1))
            if (r0 == 0) goto L_0x03a7
            com.google.android.material.textfield.TextInputLayout r0 = r1.txtLastName
            com.blueair.login.BindingAdapterKt.errorText(r0, r7)
        L_0x03a7:
            long r2 = r48 & r17
            int r0 = (r2 > r35 ? 1 : (r2 == r35 ? 0 : -1))
            if (r0 == 0) goto L_0x03b4
            com.google.android.material.textfield.TextInputEditText r0 = r1.zipCode
            r11 = r33
            androidx.databinding.adapters.TextViewBindingAdapter.setText(r0, r11)
        L_0x03b4:
            return
        L_0x03b5:
            r0 = move-exception
            monitor-exit(r56)     // Catch:{ all -> 0x03b5 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.login.databinding.ActivityProfileBindingImpl.executeBindings():void");
    }

    public final void _internalCallbackOnClick(int i, View view) {
        ProfileViewModel profileViewModel = this.mViewModel;
        if (profileViewModel != null) {
            profileViewModel.updateProfile();
        }
    }
}
