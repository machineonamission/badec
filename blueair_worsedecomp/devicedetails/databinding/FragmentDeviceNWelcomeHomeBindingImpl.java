package com.blueair.devicedetails.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.Converters;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.lifecycle.MutableLiveData;
import com.blueair.devicedetails.BR;
import com.blueair.devicedetails.R;
import com.blueair.devicedetails.viewmodel.DeviceWelcomeHomeViewModel;

public class FragmentDeviceNWelcomeHomeBindingImpl extends FragmentDeviceNWelcomeHomeBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final FrameLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.title, 7);
        sparseIntArray.put(R.id.im_location, 8);
    }

    public FragmentDeviceNWelcomeHomeBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 9, sIncludes, sViewsWithIds));
    }

    private FragmentDeviceNWelcomeHomeBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, objArr[1], objArr[3], objArr[4], objArr[6], objArr[8], objArr[5], objArr[2], objArr[7]);
        this.mDirtyFlags = -1;
        this.addBtn.setTag((Object) null);
        this.addressContainer.setTag((Object) null);
        this.addressText.setTag((Object) null);
        this.arrow.setTag((Object) null);
        FrameLayout frameLayout = objArr[0];
        this.mboundView0 = frameLayout;
        frameLayout.setTag((Object) null);
        this.radiusText.setTag((Object) null);
        this.switchBtn.setTag((Object) null);
        setRootTag(view);
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
        if (BR.vm != i) {
            return false;
        }
        setVm((DeviceWelcomeHomeViewModel) obj);
        return true;
    }

    public void setVm(DeviceWelcomeHomeViewModel deviceWelcomeHomeViewModel) {
        this.mVm = deviceWelcomeHomeViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(BR.vm);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return onChangeVmWelcomeHomeExist((MutableLiveData) obj, i2);
        }
        if (i == 1) {
            return onChangeVmWelcomeHomeEnabled((MutableLiveData) obj, i2);
        }
        if (i != 2) {
            return false;
        }
        return onChangeVmAddress((MutableLiveData) obj, i2);
    }

    private boolean onChangeVmWelcomeHomeExist(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeVmWelcomeHomeEnabled(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeVmAddress(MutableLiveData<String> mutableLiveData, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        long j;
        long j2;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        TextView textView;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        DeviceWelcomeHomeViewModel deviceWelcomeHomeViewModel = this.mVm;
        String str = null;
        int i7 = 0;
        if ((31 & j) != 0) {
            int i8 = ((j & 25) > 0 ? 1 : ((j & 25) == 0 ? 0 : -1));
            if (i8 != 0) {
                MutableLiveData<Boolean> welcomeHomeExist = deviceWelcomeHomeViewModel != null ? deviceWelcomeHomeViewModel.getWelcomeHomeExist() : null;
                updateLiveDataRegistration(0, welcomeHomeExist);
                boolean safeUnbox = ViewDataBinding.safeUnbox(welcomeHomeExist != null ? welcomeHomeExist.getValue() : null);
                if (i8 != 0) {
                    j |= safeUnbox ? 5120 : 2560;
                }
                i = 8;
                i5 = safeUnbox ? 8 : 0;
                if (safeUnbox) {
                    i = 0;
                }
            } else {
                i = 0;
                i5 = 0;
            }
            int i9 = ((j & 26) > 0 ? 1 : ((j & 26) == 0 ? 0 : -1));
            if (i9 != 0) {
                MutableLiveData<Boolean> welcomeHomeEnabled = deviceWelcomeHomeViewModel != null ? deviceWelcomeHomeViewModel.getWelcomeHomeEnabled() : null;
                j2 = 0;
                updateLiveDataRegistration(1, welcomeHomeEnabled);
                boolean safeUnbox2 = ViewDataBinding.safeUnbox(welcomeHomeEnabled != null ? welcomeHomeEnabled.getValue() : null);
                if (i9 != 0) {
                    j |= safeUnbox2 ? 16704 : 8352;
                }
                int colorFromResource = getColorFromResource(this.arrow, safeUnbox2 ? com.blueair.viewcore.R.color.colorPrimary : com.blueair.viewcore.R.color.greyblue);
                int colorFromResource2 = getColorFromResource(this.addressText, safeUnbox2 ? com.blueair.viewcore.R.color.colorPrimary : com.blueair.viewcore.R.color.greyblue);
                if (safeUnbox2) {
                    textView = this.radiusText;
                    i6 = com.blueair.viewcore.R.color.colorPrimary;
                } else {
                    textView = this.radiusText;
                    i6 = com.blueair.viewcore.R.color.greyblue;
                }
                int i10 = colorFromResource;
                i2 = getColorFromResource(textView, i6);
                i3 = colorFromResource2;
                i7 = i10;
            } else {
                j2 = 0;
                i3 = 0;
                i2 = 0;
            }
            if ((j & 28) != j2) {
                MutableLiveData<String> address = deviceWelcomeHomeViewModel != null ? deviceWelcomeHomeViewModel.getAddress() : null;
                updateLiveDataRegistration(2, address);
                if (address != null) {
                    str = address.getValue();
                }
            }
            i4 = i7;
            i7 = i5;
        } else {
            j2 = 0;
            i4 = 0;
            i3 = 0;
            i2 = 0;
            i = 0;
        }
        if ((25 & j) != j2) {
            this.addBtn.setVisibility(i7);
            this.addressContainer.setVisibility(i);
            this.switchBtn.setVisibility(i);
        }
        if ((28 & j) != j2) {
            TextViewBindingAdapter.setText(this.addressText, str);
        }
        if ((j & 26) != j2) {
            this.addressText.setTextColor(i3);
            this.radiusText.setTextColor(i2);
            if (getBuildSdkInt() >= 21) {
                this.arrow.setBackgroundTintList(Converters.convertColorToColorStateList(i4));
            }
        }
    }
}
