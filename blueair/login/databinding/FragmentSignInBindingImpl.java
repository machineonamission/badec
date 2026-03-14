package com.blueair.login.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.blueair.login.BR;
import com.blueair.login.R;
import com.blueair.login.SignInViewModel;
import com.blueair.viewcore.view.SimpleTextInputLayout;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.textfield.TextInputEditText;

public class FragmentSignInBindingImpl extends FragmentSignInBinding {
   private static final ViewDataBinding.IncludedLayouts sIncludes;
   private static final SparseIntArray sViewsWithIds;
   private InverseBindingListener cbPrivacyandroidCheckedAttrChanged;
   private InverseBindingListener emailandroidTextAttrChanged;
   private long mDirtyFlags;
   private final ConstraintLayout mboundView0;
   private InverseBindingListener passwordandroidTextAttrChanged;

   static {
      SparseIntArray var0 = new SparseIntArray();
      sViewsWithIds = var0;
      var0.put(R.id.txt_welcomeBack, 7);
      var0.put(R.id.txtEmail, 8);
      var0.put(R.id.txtPassword, 9);
      var0.put(R.id.btnForgotPassword, 10);
      var0.put(R.id.privacy_text, 11);
      var0.put(R.id.group_privacy, 12);
      var0.put(R.id.txtRegisterTitle, 13);
      var0.put(R.id.btnRegister, 14);
      var0.put(R.id.toolbar, 15);
      var0.put(R.id.iv_back, 16);
      var0.put(R.id.iv_close, 17);
   }

   public FragmentSignInBindingImpl(DataBindingComponent var1, View var2) {
      this(var1, var2, mapBindings(var1, var2, 18, sIncludes, sViewsWithIds));
   }

   private FragmentSignInBindingImpl(DataBindingComponent var1, View var2, Object[] var3) {
      super(var1, var2, 5, (AppCompatButton)var3[10], (AppCompatTextView)var3[6], (AppCompatButton)var3[14], (MaterialCheckBox)var3[5], (TextInputEditText)var3[1], (Group)var3[12], (AppCompatImageView)var3[16], (AppCompatImageView)var3[17], (TextInputEditText)var3[3], (TextView)var3[11], (ConstraintLayout)var3[15], (SimpleTextInputLayout)var3[8], (AppCompatTextView)var3[2], (SimpleTextInputLayout)var3[9], (AppCompatTextView)var3[4], (AppCompatTextView)var3[13], (AppCompatTextView)var3[7]);
      this.cbPrivacyandroidCheckedAttrChanged = new InverseBindingListener(this) {
         final FragmentSignInBindingImpl this$0;

         {
            this.this$0 = var1;
         }

         public void onChange() {
            boolean var1 = this.this$0.cbPrivacy.isChecked();
            SignInViewModel var2 = this.this$0.mViewModel;
            if (var2 != null) {
               MutableLiveData var3 = var2.getConfirmPrivacy();
               if (var3 != null) {
                  var3.setValue(var1);
               }
            }

         }
      };
      this.emailandroidTextAttrChanged = new InverseBindingListener(this) {
         final FragmentSignInBindingImpl this$0;

         {
            this.this$0 = var1;
         }

         public void onChange() {
            String var1 = TextViewBindingAdapter.getTextString(this.this$0.email);
            SignInViewModel var2 = this.this$0.mViewModel;
            if (var2 != null) {
               MutableLiveData var3 = var2.getEmail();
               if (var3 != null) {
                  var3.setValue(var1);
               }
            }

         }
      };
      this.passwordandroidTextAttrChanged = new InverseBindingListener(this) {
         final FragmentSignInBindingImpl this$0;

         {
            this.this$0 = var1;
         }

         public void onChange() {
            String var1 = TextViewBindingAdapter.getTextString(this.this$0.password);
            SignInViewModel var2 = this.this$0.mViewModel;
            if (var2 != null) {
               MutableLiveData var3 = var2.getPassword();
               if (var3 != null) {
                  var3.setValue(var1);
               }
            }

         }
      };
      this.mDirtyFlags = -1L;
      this.btnLogin.setTag((Object)null);
      this.cbPrivacy.setTag((Object)null);
      this.email.setTag((Object)null);
      ConstraintLayout var4 = (ConstraintLayout)var3[0];
      this.mboundView0 = var4;
      var4.setTag((Object)null);
      this.password.setTag((Object)null);
      this.txtEmailError.setTag((Object)null);
      this.txtPasswordError.setTag((Object)null);
      this.setRootTag(var2);
      this.invalidateAll();
   }

   private boolean onChangeViewModelConfirmPrivacy(MutableLiveData param1, int param2) {
      // $FF: Couldn't be decompiled
   }

   private boolean onChangeViewModelEmail(MutableLiveData param1, int param2) {
      // $FF: Couldn't be decompiled
   }

   private boolean onChangeViewModelEmailValid(LiveData param1, int param2) {
      // $FF: Couldn't be decompiled
   }

   private boolean onChangeViewModelPassword(MutableLiveData param1, int param2) {
      // $FF: Couldn't be decompiled
   }

   private boolean onChangeViewModelPasswordValid(LiveData param1, int param2) {
      // $FF: Couldn't be decompiled
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
      if (var1 != 0) {
         if (var1 != 1) {
            if (var1 != 2) {
               if (var1 != 3) {
                  return var1 != 4 ? false : this.onChangeViewModelEmailValid((LiveData)var2, var3);
               } else {
                  return this.onChangeViewModelPassword((MutableLiveData)var2, var3);
               }
            } else {
               return this.onChangeViewModelConfirmPrivacy((MutableLiveData)var2, var3);
            }
         } else {
            return this.onChangeViewModelEmail((MutableLiveData)var2, var3);
         }
      } else {
         return this.onChangeViewModelPasswordValid((LiveData)var2, var3);
      }
   }

   public boolean setVariable(int var1, Object var2) {
      if (BR.viewModel == var1) {
         this.setViewModel((SignInViewModel)var2);
         return true;
      } else {
         return false;
      }
   }

   public void setViewModel(SignInViewModel param1) {
      // $FF: Couldn't be decompiled
   }
}
