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

   protected ActivityProfileBinding(Object var1, View var2, int var3, TextInputEditText var4, TextInputEditText var5, AppCompatImageButton var6, MaterialButton var7, MaterialButton var8, MaterialCheckBox var9, MaterialCheckBox var10, TextInputEditText var11, TextInputEditText var12, TextInputEditText var13, TextInputEditText var14, TextInputEditText var15, ProgressBlockerView var16, TextInputEditText var17, ScrollView var18, MaterialToolbar var19, AppCompatTextView var20, TextInputLayout var21, AppCompatTextView var22, TextInputLayout var23, TextInputLayout var24, TextInputLayout var25, TextInputLayout var26, TextInputLayout var27, TextInputLayout var28, TextInputLayout var29, TextInputLayout var30, TextInputEditText var31) {
      super(var1, var2, var3);
      this.address = var4;
      this.area = var5;
      this.btnClose = var6;
      this.btnManageMyAccount = var7;
      this.btnSave = var8;
      this.cbDataConsent = var9;
      this.cbSubscribe = var10;
      this.city = var11;
      this.country = var12;
      this.email = var13;
      this.firstName = var14;
      this.lastName = var15;
      this.loading = var16;
      this.phoneNumber = var17;
      this.scrollableRoot = var18;
      this.toolbar = var19;
      this.txtAccountTitle = var20;
      this.txtAddress = var21;
      this.txtAddressTitle = var22;
      this.txtArea = var23;
      this.txtCity = var24;
      this.txtCountry = var25;
      this.txtEmail = var26;
      this.txtFirstName = var27;
      this.txtLastName = var28;
      this.txtPhoneNumber = var29;
      this.txtZipCode = var30;
      this.zipCode = var31;
   }

   public static ActivityProfileBinding bind(View var0) {
      return bind(var0, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static ActivityProfileBinding bind(View var0, Object var1) {
      return (ActivityProfileBinding)bind(var1, var0, R.layout.activity_profile);
   }

   public static ActivityProfileBinding inflate(LayoutInflater var0) {
      return inflate(var0, DataBindingUtil.getDefaultComponent());
   }

   public static ActivityProfileBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      return inflate(var0, var1, var2, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static ActivityProfileBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2, Object var3) {
      return (ActivityProfileBinding)ViewDataBinding.inflateInternal(var0, R.layout.activity_profile, var1, var2, var3);
   }

   @Deprecated
   public static ActivityProfileBinding inflate(LayoutInflater var0, Object var1) {
      return (ActivityProfileBinding)ViewDataBinding.inflateInternal(var0, R.layout.activity_profile, (ViewGroup)null, false, var1);
   }

   public ProfileViewModel getViewModel() {
      return this.mViewModel;
   }

   public abstract void setViewModel(ProfileViewModel var1);
}
