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
import com.blueair.login.ForgotPasswordViewModel;
import com.blueair.login.R;
import com.blueair.login.generated.callback.OnClickListener;

public class FragmentForgotPasswordBindingImpl extends FragmentForgotPasswordBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private InverseBindingListener emailandroidTextAttrChanged;
    private final View.OnClickListener mCallback1;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.toolbar, 3);
        sparseIntArray.put(R.id.btnClose, 4);
        sparseIntArray.put(R.id.btnBack, 5);
        sparseIntArray.put(R.id.txt_title, 6);
        sparseIntArray.put(R.id.txtEmail, 7);
        sparseIntArray.put(R.id.txt_emailError, 8);
    }

    public FragmentForgotPasswordBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 9, sIncludes, sViewsWithIds));
    }

    private FragmentForgotPasswordBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, objArr[5], objArr[4], objArr[1], objArr[2], objArr[3], objArr[7], objArr[8], objArr[6]);
        this.emailandroidTextAttrChanged = new InverseBindingListener() {
            public void onChange() {
                MutableLiveData<String> email;
                String textString = TextViewBindingAdapter.getTextString(FragmentForgotPasswordBindingImpl.this.email);
                ForgotPasswordViewModel forgotPasswordViewModel = FragmentForgotPasswordBindingImpl.this.mViewModel;
                if (forgotPasswordViewModel != null && (email = forgotPasswordViewModel.getEmail()) != null) {
                    email.setValue(textString);
                }
            }
        };
        this.mDirtyFlags = -1;
        this.btnForgotPassword.setTag((Object) null);
        this.email.setTag((Object) null);
        ConstraintLayout constraintLayout = objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag((Object) null);
        setRootTag(view);
        this.mCallback1 = new OnClickListener(this, 1);
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
        if (BR.viewModel != i) {
            return false;
        }
        setViewModel((ForgotPasswordViewModel) obj);
        return true;
    }

    public void setViewModel(ForgotPasswordViewModel forgotPasswordViewModel) {
        this.mViewModel = forgotPasswordViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(BR.viewModel);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return onChangeViewModelEmail((MutableLiveData) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return onChangeViewModelEmailValid((LiveData) obj, i2);
    }

    private boolean onChangeViewModelEmail(MutableLiveData<String> mutableLiveData, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeViewModelEmailValid(LiveData<Boolean> liveData, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0038  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
            r14 = this;
            monitor-enter(r14)
            long r0 = r14.mDirtyFlags     // Catch:{ all -> 0x0087 }
            r2 = 0
            r14.mDirtyFlags = r2     // Catch:{ all -> 0x0087 }
            monitor-exit(r14)     // Catch:{ all -> 0x0087 }
            com.blueair.login.ForgotPasswordViewModel r4 = r14.mViewModel
            r5 = 15
            long r5 = r5 & r0
            int r5 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            r6 = 14
            r8 = 13
            r10 = 0
            r11 = 0
            if (r5 == 0) goto L_0x0053
            long r12 = r0 & r8
            int r5 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r5 == 0) goto L_0x0031
            if (r4 == 0) goto L_0x0024
            androidx.lifecycle.MutableLiveData r5 = r4.getEmail()
            goto L_0x0025
        L_0x0024:
            r5 = r11
        L_0x0025:
            r14.updateLiveDataRegistration(r10, r5)
            if (r5 == 0) goto L_0x0031
            java.lang.Object r5 = r5.getValue()
            java.lang.String r5 = (java.lang.String) r5
            goto L_0x0032
        L_0x0031:
            r5 = r11
        L_0x0032:
            long r12 = r0 & r6
            int r12 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r12 == 0) goto L_0x0054
            if (r4 == 0) goto L_0x003f
            androidx.lifecycle.LiveData r4 = r4.getEmailValid()
            goto L_0x0040
        L_0x003f:
            r4 = r11
        L_0x0040:
            r10 = 1
            r14.updateLiveDataRegistration(r10, r4)
            if (r4 == 0) goto L_0x004d
            java.lang.Object r4 = r4.getValue()
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            goto L_0x004e
        L_0x004d:
            r4 = r11
        L_0x004e:
            boolean r10 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r4)
            goto L_0x0054
        L_0x0053:
            r5 = r11
        L_0x0054:
            r12 = 8
            long r12 = r12 & r0
            int r4 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x0072
            com.google.android.material.button.MaterialButton r4 = r14.btnForgotPassword
            android.view.View$OnClickListener r12 = r14.mCallback1
            r4.setOnClickListener(r12)
            com.google.android.material.textfield.TextInputEditText r4 = r14.email
            r12 = r11
            androidx.databinding.adapters.TextViewBindingAdapter$BeforeTextChanged r12 = (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged) r12
            r12 = r11
            androidx.databinding.adapters.TextViewBindingAdapter$OnTextChanged r12 = (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged) r12
            r12 = r11
            androidx.databinding.adapters.TextViewBindingAdapter$AfterTextChanged r12 = (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged) r12
            androidx.databinding.InverseBindingListener r12 = r14.emailandroidTextAttrChanged
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(r4, r11, r11, r11, r12)
        L_0x0072:
            long r6 = r6 & r0
            int r4 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x007c
            com.google.android.material.button.MaterialButton r4 = r14.btnForgotPassword
            r4.setEnabled(r10)
        L_0x007c:
            long r0 = r0 & r8
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto L_0x0086
            com.google.android.material.textfield.TextInputEditText r0 = r14.email
            androidx.databinding.adapters.TextViewBindingAdapter.setText(r0, r5)
        L_0x0086:
            return
        L_0x0087:
            r0 = move-exception
            monitor-exit(r14)     // Catch:{ all -> 0x0087 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.login.databinding.FragmentForgotPasswordBindingImpl.executeBindings():void");
    }

    public final void _internalCallbackOnClick(int i, View view) {
        ForgotPasswordViewModel forgotPasswordViewModel = this.mViewModel;
        if (forgotPasswordViewModel != null) {
            forgotPasswordViewModel.forgotPassword();
        }
    }
}
