package com.blueair.login.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blueair.login.ProfileViewModel;
import com.blueair.login.R;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public abstract class ActivityProfileBinding extends ViewDataBinding {
    public final TextInputEditText address;
    public final TextInputEditText area;
    public final AppCompatImageButton btnClose;
    public final MaterialButton btnManageMyAccount;
    public final MaterialButton btnSave;
    public final MaterialCheckBox cbDataConsent;
    public final MaterialCheckBox cbSubscribe;
    public final TextInputEditText city;
    public final TextInputEditText country;
    public final TextInputEditText email;
    public final TextInputEditText firstName;
    public final TextInputEditText lastName;
    public final ProgressBlockerView loading;
    @Bindable
    protected ProfileViewModel mViewModel;
    public final TextInputEditText phoneNumber;
    public final ScrollView scrollableRoot;
    public final MaterialToolbar toolbar;
    public final AppCompatTextView txtAccountTitle;
    public final TextInputLayout txtAddress;
    public final AppCompatTextView txtAddressTitle;
    public final TextInputLayout txtArea;
    public final TextInputLayout txtCity;
    public final TextInputLayout txtCountry;
    public final TextInputLayout txtEmail;
    public final TextInputLayout txtFirstName;
    public final TextInputLayout txtLastName;
    public final TextInputLayout txtPhoneNumber;
    public final TextInputLayout txtZipCode;
    public final TextInputEditText zipCode;

    public abstract void setViewModel(ProfileViewModel profileViewModel);

    protected ActivityProfileBinding(Object obj, View view, int i, TextInputEditText textInputEditText, TextInputEditText textInputEditText2, AppCompatImageButton appCompatImageButton, MaterialButton materialButton, MaterialButton materialButton2, MaterialCheckBox materialCheckBox, MaterialCheckBox materialCheckBox2, TextInputEditText textInputEditText3, TextInputEditText textInputEditText4, TextInputEditText textInputEditText5, TextInputEditText textInputEditText6, TextInputEditText textInputEditText7, ProgressBlockerView progressBlockerView, TextInputEditText textInputEditText8, ScrollView scrollView, MaterialToolbar materialToolbar, AppCompatTextView appCompatTextView, TextInputLayout textInputLayout, AppCompatTextView appCompatTextView2, TextInputLayout textInputLayout2, TextInputLayout textInputLayout3, TextInputLayout textInputLayout4, TextInputLayout textInputLayout5, TextInputLayout textInputLayout6, TextInputLayout textInputLayout7, TextInputLayout textInputLayout8, TextInputLayout textInputLayout9, TextInputEditText textInputEditText9) {
        super(obj, view, i);
        this.address = textInputEditText;
        this.area = textInputEditText2;
        this.btnClose = appCompatImageButton;
        this.btnManageMyAccount = materialButton;
        this.btnSave = materialButton2;
        this.cbDataConsent = materialCheckBox;
        this.cbSubscribe = materialCheckBox2;
        this.city = textInputEditText3;
        this.country = textInputEditText4;
        this.email = textInputEditText5;
        this.firstName = textInputEditText6;
        this.lastName = textInputEditText7;
        this.loading = progressBlockerView;
        this.phoneNumber = textInputEditText8;
        this.scrollableRoot = scrollView;
        this.toolbar = materialToolbar;
        this.txtAccountTitle = appCompatTextView;
        this.txtAddress = textInputLayout;
        this.txtAddressTitle = appCompatTextView2;
        this.txtArea = textInputLayout2;
        this.txtCity = textInputLayout3;
        this.txtCountry = textInputLayout4;
        this.txtEmail = textInputLayout5;
        this.txtFirstName = textInputLayout6;
        this.txtLastName = textInputLayout7;
        this.txtPhoneNumber = textInputLayout8;
        this.txtZipCode = textInputLayout9;
        this.zipCode = textInputEditText9;
    }

    public ProfileViewModel getViewModel() {
        return this.mViewModel;
    }

    public static ActivityProfileBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityProfileBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityProfileBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_profile, viewGroup, z, obj);
    }

    public static ActivityProfileBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityProfileBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityProfileBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_profile, (ViewGroup) null, false, obj);
    }

    public static ActivityProfileBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityProfileBinding bind(View view, Object obj) {
        return (ActivityProfileBinding) bind(obj, view, R.layout.activity_profile);
    }
}
