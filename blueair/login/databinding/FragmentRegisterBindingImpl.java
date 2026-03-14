package com.blueair.login.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
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
import com.blueair.viewcore.view.ProgressBlockerView;
import com.blueair.viewcore.view.SimpleTextInputLayout;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.textfield.TextInputEditText;

public class FragmentRegisterBindingImpl extends FragmentRegisterBinding implements OnClickListener.Listener {
   private static final ViewDataBinding.IncludedLayouts sIncludes;
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
      SparseIntArray var0 = new SparseIntArray();
      sViewsWithIds = var0;
      var0.put(R.id.toolbar, 23);
      var0.put(R.id.btnBack, 24);
      var0.put(R.id.btnClose, 25);
      var0.put(R.id.txt_getStarted, 26);
      var0.put(R.id.scrollableRoot, 27);
      var0.put(R.id.txtPasswordRequirement, 28);
      var0.put(R.id.tv_tip, 29);
      var0.put(R.id.txtLoginTitle, 30);
      var0.put(R.id.btnLogin, 31);
   }

   public FragmentRegisterBindingImpl(DataBindingComponent var1, View var2) {
      this(var1, var2, mapBindings(var1, var2, 32, sIncludes, sViewsWithIds));
   }

   private FragmentRegisterBindingImpl(DataBindingComponent var1, View var2, Object[] var3) {
      super(var1, var2, 17, (AppCompatImageButton)var3[24], (AppCompatImageButton)var3[25], (AppCompatButton)var3[31], (MaterialButton)var3[21], (MaterialCheckBox)var3[20], (MaterialCheckBox)var3[16], (MaterialCheckBox)var3[19], (MaterialCheckBox)var3[18], (TextInputEditText)var3[14], (TextInputEditText)var3[8], (TextInputEditText)var3[2], (TextInputEditText)var3[5], (ProgressBlockerView)var3[22], (TextInputEditText)var3[11], (TextView)var3[17], (ScrollView)var3[27], (ConstraintLayout)var3[23], (AppCompatTextView)var3[29], (SimpleTextInputLayout)var3[13], (AppCompatTextView)var3[15], (SimpleTextInputLayout)var3[7], (AppCompatTextView)var3[9], (SimpleTextInputLayout)var3[1], (AppCompatTextView)var3[3], (AppCompatTextView)var3[26], (SimpleTextInputLayout)var3[4], (AppCompatTextView)var3[6], (AppCompatTextView)var3[30], (SimpleTextInputLayout)var3[10], (AppCompatTextView)var3[12], (AppCompatTextView)var3[28]);
      this.cbConsentandroidCheckedAttrChanged = new InverseBindingListener(this) {
         final FragmentRegisterBindingImpl this$0;

         {
            this.this$0 = var1;
         }

         public void onChange() {
            boolean var1 = this.this$0.cbConsent.isChecked();
            RegisterViewModel var2 = this.this$0.mViewModel;
            if (var2 != null) {
               MutableLiveData var3 = var2.getConfirmConsentDate();
               if (var3 != null) {
                  var3.setValue(var1);
               }
            }

         }
      };
      this.cbPrivacyandroidCheckedAttrChanged = new InverseBindingListener(this) {
         final FragmentRegisterBindingImpl this$0;

         {
            this.this$0 = var1;
         }

         public void onChange() {
            boolean var1 = this.this$0.cbPrivacy.isChecked();
            RegisterViewModel var2 = this.this$0.mViewModel;
            if (var2 != null) {
               MutableLiveData var3 = var2.getConfirmPrivacy();
               if (var3 != null) {
                  var3.setValue(var1);
               }
            }

         }
      };
      this.cbSubscribeandroidCheckedAttrChanged = new InverseBindingListener(this) {
         final FragmentRegisterBindingImpl this$0;

         {
            this.this$0 = var1;
         }

         public void onChange() {
            boolean var1 = this.this$0.cbSubscribe.isChecked();
            RegisterViewModel var2 = this.this$0.mViewModel;
            if (var2 != null) {
               MutableLiveData var3 = var2.getConfirmSubscribe();
               if (var3 != null) {
                  var3.setValue(var1);
               }
            }

         }
      };
      this.cbYearsandroidCheckedAttrChanged = new InverseBindingListener(this) {
         final FragmentRegisterBindingImpl this$0;

         {
            this.this$0 = var1;
         }

         public void onChange() {
            boolean var1 = this.this$0.cbYears.isChecked();
            RegisterViewModel var2 = this.this$0.mViewModel;
            if (var2 != null) {
               MutableLiveData var3 = var2.getConfirmYear();
               if (var3 != null) {
                  var3.setValue(var1);
               }
            }

         }
      };
      this.confirmPasswordandroidTextAttrChanged = new InverseBindingListener(this) {
         final FragmentRegisterBindingImpl this$0;

         {
            this.this$0 = var1;
         }

         public void onChange() {
            String var1 = TextViewBindingAdapter.getTextString(this.this$0.confirmPassword);
            RegisterViewModel var2 = this.this$0.mViewModel;
            if (var2 != null) {
               MutableLiveData var3 = var2.getConfirmPassword();
               if (var3 != null) {
                  var3.setValue(var1);
               }
            }

         }
      };
      this.emailandroidTextAttrChanged = new InverseBindingListener(this) {
         final FragmentRegisterBindingImpl this$0;

         {
            this.this$0 = var1;
         }

         public void onChange() {
            String var1 = TextViewBindingAdapter.getTextString(this.this$0.email);
            RegisterViewModel var2 = this.this$0.mViewModel;
            if (var2 != null) {
               MutableLiveData var3 = var2.getEmail();
               if (var3 != null) {
                  var3.setValue(var1);
               }
            }

         }
      };
      this.firstNameandroidTextAttrChanged = new InverseBindingListener(this) {
         final FragmentRegisterBindingImpl this$0;

         {
            this.this$0 = var1;
         }

         public void onChange() {
            String var1 = TextViewBindingAdapter.getTextString(this.this$0.firstName);
            RegisterViewModel var2 = this.this$0.mViewModel;
            if (var2 != null) {
               MutableLiveData var3 = var2.getFirstName();
               if (var3 != null) {
                  var3.setValue(var1);
               }
            }

         }
      };
      this.lastNameandroidTextAttrChanged = new InverseBindingListener(this) {
         final FragmentRegisterBindingImpl this$0;

         {
            this.this$0 = var1;
         }

         public void onChange() {
            String var1 = TextViewBindingAdapter.getTextString(this.this$0.lastName);
            RegisterViewModel var2 = this.this$0.mViewModel;
            if (var2 != null) {
               MutableLiveData var3 = var2.getLastName();
               if (var3 != null) {
                  var3.setValue(var1);
               }
            }

         }
      };
      this.passwordandroidTextAttrChanged = new InverseBindingListener(this) {
         final FragmentRegisterBindingImpl this$0;

         {
            this.this$0 = var1;
         }

         public void onChange() {
            String var1 = TextViewBindingAdapter.getTextString(this.this$0.password);
            RegisterViewModel var2 = this.this$0.mViewModel;
            if (var2 != null) {
               MutableLiveData var3 = var2.getPassword();
               if (var3 != null) {
                  var3.setValue(var1);
               }
            }

         }
      };
      this.mDirtyFlags = -1L;
      this.btnRegister.setTag((Object)null);
      this.cbConsent.setTag((Object)null);
      this.cbPrivacy.setTag((Object)null);
      this.cbSubscribe.setTag((Object)null);
      this.cbYears.setTag((Object)null);
      this.confirmPassword.setTag((Object)null);
      this.email.setTag((Object)null);
      this.firstName.setTag((Object)null);
      this.lastName.setTag((Object)null);
      this.loading.setTag((Object)null);
      FrameLayout var4 = (FrameLayout)var3[0];
      this.mboundView0 = var4;
      var4.setTag((Object)null);
      this.password.setTag((Object)null);
      this.privacyText.setTag((Object)null);
      this.txtConfirmPassword.setTag((Object)null);
      this.txtConfirmPasswordError.setTag((Object)null);
      this.txtEmail.setTag((Object)null);
      this.txtEmailError.setTag((Object)null);
      this.txtFirstName.setTag("FirstName");
      this.txtFirstNameError.setTag((Object)null);
      this.txtLastName.setTag("LastName");
      this.txtLastNameError.setTag((Object)null);
      this.txtPassword.setTag((Object)null);
      this.txtPasswordError.setTag((Object)null);
      this.setRootTag(var2);
      this.mCallback3 = new OnClickListener(this, 1);
      this.invalidateAll();
   }

   private boolean onChangeViewModelConfirmConsentDate(MutableLiveData param1, int param2) {
      // $FF: Couldn't be decompiled
   }

   private boolean onChangeViewModelConfirmPassword(MutableLiveData param1, int param2) {
      // $FF: Couldn't be decompiled
   }

   private boolean onChangeViewModelConfirmPasswordValid(LiveData param1, int param2) {
      // $FF: Couldn't be decompiled
   }

   private boolean onChangeViewModelConfirmPrivacy(MutableLiveData param1, int param2) {
      // $FF: Couldn't be decompiled
   }

   private boolean onChangeViewModelConfirmSubscribe(MutableLiveData param1, int param2) {
      // $FF: Couldn't be decompiled
   }

   private boolean onChangeViewModelConfirmYear(MutableLiveData param1, int param2) {
      // $FF: Couldn't be decompiled
   }

   private boolean onChangeViewModelEmail(MutableLiveData param1, int param2) {
      // $FF: Couldn't be decompiled
   }

   private boolean onChangeViewModelEmailError(LiveData param1, int param2) {
      // $FF: Couldn't be decompiled
   }

   private boolean onChangeViewModelFirstName(MutableLiveData param1, int param2) {
      // $FF: Couldn't be decompiled
   }

   private boolean onChangeViewModelFirstNameValid(LiveData param1, int param2) {
      // $FF: Couldn't be decompiled
   }

   private boolean onChangeViewModelLastName(MutableLiveData param1, int param2) {
      // $FF: Couldn't be decompiled
   }

   private boolean onChangeViewModelLastNameValid(LiveData param1, int param2) {
      // $FF: Couldn't be decompiled
   }

   private boolean onChangeViewModelLoading(LiveData param1, int param2) {
      // $FF: Couldn't be decompiled
   }

   private boolean onChangeViewModelPassword(MutableLiveData param1, int param2) {
      // $FF: Couldn't be decompiled
   }

   private boolean onChangeViewModelPasswordError(LiveData param1, int param2) {
      // $FF: Couldn't be decompiled
   }

   private boolean onChangeViewModelPrivacyConfirmed(LiveData param1, int param2) {
      // $FF: Couldn't be decompiled
   }

   private boolean onChangeViewModelYearConfirmed(LiveData param1, int param2) {
      // $FF: Couldn't be decompiled
   }

   public final void _internalCallbackOnClick(int var1, View var2) {
      RegisterViewModel var3 = this.mViewModel;
      if (var3 != null) {
         var3.register();
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
            return this.onChangeViewModelConfirmPasswordValid((LiveData)var2, var3);
         case 1:
            return this.onChangeViewModelEmailError((LiveData)var2, var3);
         case 2:
            return this.onChangeViewModelEmail((MutableLiveData)var2, var3);
         case 3:
            return this.onChangeViewModelConfirmPrivacy((MutableLiveData)var2, var3);
         case 4:
            return this.onChangeViewModelYearConfirmed((LiveData)var2, var3);
         case 5:
            return this.onChangeViewModelLoading((LiveData)var2, var3);
         case 6:
            return this.onChangeViewModelLastName((MutableLiveData)var2, var3);
         case 7:
            return this.onChangeViewModelFirstName((MutableLiveData)var2, var3);
         case 8:
            return this.onChangeViewModelPasswordError((LiveData)var2, var3);
         case 9:
            return this.onChangeViewModelPrivacyConfirmed((LiveData)var2, var3);
         case 10:
            return this.onChangeViewModelConfirmSubscribe((MutableLiveData)var2, var3);
         case 11:
            return this.onChangeViewModelConfirmConsentDate((MutableLiveData)var2, var3);
         case 12:
            return this.onChangeViewModelPassword((MutableLiveData)var2, var3);
         case 13:
            return this.onChangeViewModelConfirmYear((MutableLiveData)var2, var3);
         case 14:
            return this.onChangeViewModelConfirmPassword((MutableLiveData)var2, var3);
         case 15:
            return this.onChangeViewModelLastNameValid((LiveData)var2, var3);
         case 16:
            return this.onChangeViewModelFirstNameValid((LiveData)var2, var3);
         default:
            return false;
      }
   }

   public boolean setVariable(int var1, Object var2) {
      if (BR.viewModel == var1) {
         this.setViewModel((RegisterViewModel)var2);
         return true;
      } else {
         return false;
      }
   }

   public void setViewModel(RegisterViewModel param1) {
      // $FF: Couldn't be decompiled
   }
}
