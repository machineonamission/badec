package com.blueair.adddevice.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blueair.adddevice.R;
import com.blueair.adddevice.viewmodel.AddDeviceViewModel;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public abstract class FragmentWifiPasswordBinding extends ViewDataBinding {
    public final MaterialButton buttonNext;
    public final TextInputLayout inputPassword;
    public final TextView logView;
    @Bindable
    protected AddDeviceViewModel mAddDeviceViewModel;
    public final TextInputEditText passwordEditText;
    public final ProgressBlockerView progressView;
    public final ConstraintLayout rootLayout;
    public final TextInputEditText ssidEditText;
    public final TextInputLayout ssidEditTextLayout;
    public final AppCompatTextView tvError;
    public final AppCompatTextView tvSubtitle;
    public final AppCompatTextView tvTitle;

    public abstract void setAddDeviceViewModel(AddDeviceViewModel addDeviceViewModel);

    protected FragmentWifiPasswordBinding(Object obj, View view, int i, MaterialButton materialButton, TextInputLayout textInputLayout, TextView textView, TextInputEditText textInputEditText, ProgressBlockerView progressBlockerView, ConstraintLayout constraintLayout, TextInputEditText textInputEditText2, TextInputLayout textInputLayout2, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3) {
        super(obj, view, i);
        this.buttonNext = materialButton;
        this.inputPassword = textInputLayout;
        this.logView = textView;
        this.passwordEditText = textInputEditText;
        this.progressView = progressBlockerView;
        this.rootLayout = constraintLayout;
        this.ssidEditText = textInputEditText2;
        this.ssidEditTextLayout = textInputLayout2;
        this.tvError = appCompatTextView;
        this.tvSubtitle = appCompatTextView2;
        this.tvTitle = appCompatTextView3;
    }

    public AddDeviceViewModel getAddDeviceViewModel() {
        return this.mAddDeviceViewModel;
    }

    public static FragmentWifiPasswordBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentWifiPasswordBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentWifiPasswordBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_wifi_password, viewGroup, z, obj);
    }

    public static FragmentWifiPasswordBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentWifiPasswordBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentWifiPasswordBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_wifi_password, (ViewGroup) null, false, obj);
    }

    public static FragmentWifiPasswordBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentWifiPasswordBinding bind(View view, Object obj) {
        return (FragmentWifiPasswordBinding) bind(obj, view, R.layout.fragment_wifi_password);
    }
}
