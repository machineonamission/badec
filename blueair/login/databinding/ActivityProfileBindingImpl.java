package com.blueair.login.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatTextView;
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
import com.blueair.viewcore.view.ProgressBlockerView;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class ActivityProfileBindingImpl extends ActivityProfileBinding implements OnClickListener.Listener {
   private static final ViewDataBinding.IncludedLayouts sIncludes;
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
      SparseIntArray var0 = new SparseIntArray();
      sViewsWithIds = var0;
      var0.put(R.id.toolbar, 16);
      var0.put(R.id.btnClose, 17);
      var0.put(R.id.scrollableRoot, 18);
      var0.put(R.id.txtAccountTitle, 19);
      var0.put(R.id.txtAddressTitle, 20);
      var0.put(R.id.btnManageMyAccount, 21);
      var0.put(R.id.txtEmail, 22);
      var0.put(R.id.txtPhoneNumber, 23);
      var0.put(R.id.txtAddress, 24);
      var0.put(R.id.txtZipCode, 25);
      var0.put(R.id.txtArea, 26);
      var0.put(R.id.txtCity, 27);
      var0.put(R.id.txtCountry, 28);
   }

   public ActivityProfileBindingImpl(DataBindingComponent var1, View var2) {
      this(var1, var2, mapBindings(var1, var2, 29, sIncludes, sViewsWithIds));
   }

   private ActivityProfileBindingImpl(DataBindingComponent var1, View var2, Object[] var3) {
      super(var1, var2, 14, (TextInputEditText)var3[8], (TextInputEditText)var3[10], (AppCompatImageButton)var3[17], (MaterialButton)var3[21], (MaterialButton)var3[1], (MaterialCheckBox)var3[14], (MaterialCheckBox)var3[13], (TextInputEditText)var3[11], (TextInputEditText)var3[12], (TextInputEditText)var3[2], (TextInputEditText)var3[4], (TextInputEditText)var3[6], (ProgressBlockerView)var3[15], (TextInputEditText)var3[7], (ScrollView)var3[18], (MaterialToolbar)var3[16], (AppCompatTextView)var3[19], (TextInputLayout)var3[24], (AppCompatTextView)var3[20], (TextInputLayout)var3[26], (TextInputLayout)var3[27], (TextInputLayout)var3[28], (TextInputLayout)var3[22], (TextInputLayout)var3[3], (TextInputLayout)var3[5], (TextInputLayout)var3[23], (TextInputLayout)var3[25], (TextInputEditText)var3[9]);
      this.addressandroidTextAttrChanged = new InverseBindingListener(this) {
         final ActivityProfileBindingImpl this$0;

         {
            this.this$0 = var1;
         }

         public void onChange() {
            String var1 = TextViewBindingAdapter.getTextString(this.this$0.address);
            ProfileViewModel var2 = this.this$0.mViewModel;
            if (var2 != null) {
               MutableLiveData var3 = var2.getAddress();
               if (var3 != null) {
                  var3.setValue(var1);
               }
            }

         }
      };
      this.areaandroidTextAttrChanged = new InverseBindingListener(this) {
         final ActivityProfileBindingImpl this$0;

         {
            this.this$0 = var1;
         }

         public void onChange() {
            String var1 = TextViewBindingAdapter.getTextString(this.this$0.area);
            ProfileViewModel var2 = this.this$0.mViewModel;
            if (var2 != null) {
               MutableLiveData var3 = var2.getArea();
               if (var3 != null) {
                  var3.setValue(var1);
               }
            }

         }
      };
      this.cbDataConsentandroidCheckedAttrChanged = new InverseBindingListener(this) {
         final ActivityProfileBindingImpl this$0;

         {
            this.this$0 = var1;
         }

         public void onChange() {
            boolean var1 = this.this$0.cbDataConsent.isChecked();
            ProfileViewModel var2 = this.this$0.mViewModel;
            if (var2 != null) {
               MutableLiveData var3 = var2.getConsentData();
               if (var3 != null) {
                  var3.setValue(var1);
               }
            }

         }
      };
      this.cbSubscribeandroidCheckedAttrChanged = new InverseBindingListener(this) {
         final ActivityProfileBindingImpl this$0;

         {
            this.this$0 = var1;
         }

         public void onChange() {
            boolean var1 = this.this$0.cbSubscribe.isChecked();
            ProfileViewModel var2 = this.this$0.mViewModel;
            if (var2 != null) {
               MutableLiveData var3 = var2.getSubscribe();
               if (var3 != null) {
                  var3.setValue(var1);
               }
            }

         }
      };
      this.cityandroidTextAttrChanged = new InverseBindingListener(this) {
         final ActivityProfileBindingImpl this$0;

         {
            this.this$0 = var1;
         }

         public void onChange() {
            String var1 = TextViewBindingAdapter.getTextString(this.this$0.city);
            ProfileViewModel var2 = this.this$0.mViewModel;
            if (var2 != null) {
               MutableLiveData var3 = var2.getCity();
               if (var3 != null) {
                  var3.setValue(var1);
               }
            }

         }
      };
      this.countryandroidTextAttrChanged = new InverseBindingListener(this) {
         final ActivityProfileBindingImpl this$0;

         {
            this.this$0 = var1;
         }

         public void onChange() {
            String var1 = TextViewBindingAdapter.getTextString(this.this$0.country);
            ProfileViewModel var2 = this.this$0.mViewModel;
            if (var2 != null) {
               MutableLiveData var3 = var2.getCountry();
               if (var3 != null) {
                  var3.setValue(var1);
               }
            }

         }
      };
      this.firstNameandroidTextAttrChanged = new InverseBindingListener(this) {
         final ActivityProfileBindingImpl this$0;

         {
            this.this$0 = var1;
         }

         public void onChange() {
            String var1 = TextViewBindingAdapter.getTextString(this.this$0.firstName);
            ProfileViewModel var2 = this.this$0.mViewModel;
            if (var2 != null) {
               MutableLiveData var3 = var2.getFirstName();
               if (var3 != null) {
                  var3.setValue(var1);
               }
            }

         }
      };
      this.lastNameandroidTextAttrChanged = new InverseBindingListener(this) {
         final ActivityProfileBindingImpl this$0;

         {
            this.this$0 = var1;
         }

         public void onChange() {
            String var1 = TextViewBindingAdapter.getTextString(this.this$0.lastName);
            ProfileViewModel var2 = this.this$0.mViewModel;
            if (var2 != null) {
               MutableLiveData var3 = var2.getLastName();
               if (var3 != null) {
                  var3.setValue(var1);
               }
            }

         }
      };
      this.phoneNumberandroidTextAttrChanged = new InverseBindingListener(this) {
         final ActivityProfileBindingImpl this$0;

         {
            this.this$0 = var1;
         }

         public void onChange() {
            String var1 = TextViewBindingAdapter.getTextString(this.this$0.phoneNumber);
            ProfileViewModel var2 = this.this$0.mViewModel;
            if (var2 != null) {
               MutableLiveData var3 = var2.getPhoneNumber();
               if (var3 != null) {
                  var3.setValue(var1);
               }
            }

         }
      };
      this.zipCodeandroidTextAttrChanged = new InverseBindingListener(this) {
         final ActivityProfileBindingImpl this$0;

         {
            this.this$0 = var1;
         }

         public void onChange() {
            String var1 = TextViewBindingAdapter.getTextString(this.this$0.zipCode);
            ProfileViewModel var2 = this.this$0.mViewModel;
            if (var2 != null) {
               MutableLiveData var3 = var2.getZipCode();
               if (var3 != null) {
                  var3.setValue(var1);
               }
            }

         }
      };
      this.mDirtyFlags = -1L;
      this.address.setTag((Object)null);
      this.area.setTag((Object)null);
      this.btnSave.setTag((Object)null);
      this.cbDataConsent.setTag((Object)null);
      this.cbSubscribe.setTag((Object)null);
      this.city.setTag((Object)null);
      this.country.setTag((Object)null);
      this.email.setTag((Object)null);
      this.firstName.setTag((Object)null);
      this.lastName.setTag((Object)null);
      this.loading.setTag((Object)null);
      FrameLayout var4 = (FrameLayout)var3[0];
      this.mboundView0 = var4;
      var4.setTag((Object)null);
      this.phoneNumber.setTag((Object)null);
      this.txtFirstName.setTag((Object)null);
      this.txtLastName.setTag((Object)null);
      this.zipCode.setTag((Object)null);
      this.setRootTag(var2);
      this.mCallback2 = new OnClickListener(this, 1);
      this.invalidateAll();
   }

   private boolean onChangeViewModelAddress(MutableLiveData param1, int param2) {
      // $FF: Couldn't be decompiled
   }

   private boolean onChangeViewModelArea(MutableLiveData param1, int param2) {
      // $FF: Couldn't be decompiled
   }

   private boolean onChangeViewModelCity(MutableLiveData param1, int param2) {
      // $FF: Couldn't be decompiled
   }

   private boolean onChangeViewModelConsentData(MutableLiveData param1, int param2) {
      // $FF: Couldn't be decompiled
   }

   private boolean onChangeViewModelCountry(MutableLiveData param1, int param2) {
      // $FF: Couldn't be decompiled
   }

   private boolean onChangeViewModelEmail(MutableLiveData param1, int param2) {
      // $FF: Couldn't be decompiled
   }

   private boolean onChangeViewModelFirstName(MutableLiveData param1, int param2) {
      // $FF: Couldn't be decompiled
   }

   private boolean onChangeViewModelFirstNameValid(MutableLiveData param1, int param2) {
      // $FF: Couldn't be decompiled
   }

   private boolean onChangeViewModelLastName(MutableLiveData param1, int param2) {
      // $FF: Couldn't be decompiled
   }

   private boolean onChangeViewModelLastNameValid(MutableLiveData param1, int param2) {
      // $FF: Couldn't be decompiled
   }

   private boolean onChangeViewModelLoading(LiveData param1, int param2) {
      // $FF: Couldn't be decompiled
   }

   private boolean onChangeViewModelPhoneNumber(MutableLiveData param1, int param2) {
      // $FF: Couldn't be decompiled
   }

   private boolean onChangeViewModelSubscribe(MutableLiveData param1, int param2) {
      // $FF: Couldn't be decompiled
   }

   private boolean onChangeViewModelZipCode(MutableLiveData param1, int param2) {
      // $FF: Couldn't be decompiled
   }

   public final void _internalCallbackOnClick(int var1, View var2) {
      ProfileViewModel var3 = this.mViewModel;
      if (var3 != null) {
         var3.updateProfile();
      }

   }

   protected void executeBindings() {
      // $FF: Couldn't be decompiled
   }

   public boolean hasPendingBindings() {
      synchronized(this){}

      Throwable var10000;
      label123: {
         try {
            if (this.mDirtyFlags != 0L) {
               return true;
            }
         } catch (Throwable var13) {
            var10000 = var13;
            boolean var10001 = false;
            break label123;
         }

         label117:
         try {
            return false;
         } catch (Throwable var12) {
            var10000 = var12;
            boolean var14 = false;
            break label117;
         }
      }

      while(true) {
         Throwable var1 = var10000;

         try {
            throw var1;
         } catch (Throwable var11) {
            var10000 = var11;
            boolean var15 = false;
            continue;
         }
      }
   }

   public void invalidateAll() {
      // $FF: Couldn't be decompiled
   }

   protected boolean onFieldChange(int var1, Object var2, int var3) {
      switch (var1) {
         case 0:
            return this.onChangeViewModelPhoneNumber((MutableLiveData)var2, var3);
         case 1:
            return this.onChangeViewModelEmail((MutableLiveData)var2, var3);
         case 2:
            return this.onChangeViewModelAddress((MutableLiveData)var2, var3);
         case 3:
            return this.onChangeViewModelArea((MutableLiveData)var2, var3);
         case 4:
            return this.onChangeViewModelLoading((LiveData)var2, var3);
         case 5:
            return this.onChangeViewModelZipCode((MutableLiveData)var2, var3);
         case 6:
            return this.onChangeViewModelLastName((MutableLiveData)var2, var3);
         case 7:
            return this.onChangeViewModelFirstName((MutableLiveData)var2, var3);
         case 8:
            return this.onChangeViewModelCountry((MutableLiveData)var2, var3);
         case 9:
            return this.onChangeViewModelLastNameValid((MutableLiveData)var2, var3);
         case 10:
            return this.onChangeViewModelFirstNameValid((MutableLiveData)var2, var3);
         case 11:
            return this.onChangeViewModelConsentData((MutableLiveData)var2, var3);
         case 12:
            return this.onChangeViewModelCity((MutableLiveData)var2, var3);
         case 13:
            return this.onChangeViewModelSubscribe((MutableLiveData)var2, var3);
         default:
            return false;
      }
   }

   public boolean setVariable(int var1, Object var2) {
      if (BR.viewModel == var1) {
         this.setViewModel((ProfileViewModel)var2);
         return true;
      } else {
         return false;
      }
   }

   public void setViewModel(ProfileViewModel param1) {
      // $FF: Couldn't be decompiled
   }
}
