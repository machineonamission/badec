package com.blueair.login.databinding;

import android.util.SparseIntArray;
import android.view.View;
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
import com.blueair.login.ForgotPasswordViewModel;
import com.blueair.login.R;
import com.blueair.login.generated.callback.OnClickListener;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class FragmentForgotPasswordBindingImpl extends FragmentForgotPasswordBinding implements OnClickListener.Listener {
   private static final ViewDataBinding.IncludedLayouts sIncludes;
   private static final SparseIntArray sViewsWithIds;
   private InverseBindingListener emailandroidTextAttrChanged;
   private final View.OnClickListener mCallback1;
   private long mDirtyFlags;
   private final ConstraintLayout mboundView0;

   static {
      SparseIntArray var0 = new SparseIntArray();
      sViewsWithIds = var0;
      var0.put(R.id.toolbar, 3);
      var0.put(R.id.btnClose, 4);
      var0.put(R.id.btnBack, 5);
      var0.put(R.id.txt_title, 6);
      var0.put(R.id.txtEmail, 7);
      var0.put(R.id.txt_emailError, 8);
   }

   public FragmentForgotPasswordBindingImpl(DataBindingComponent var1, View var2) {
      this(var1, var2, mapBindings(var1, var2, 9, sIncludes, sViewsWithIds));
   }

   private FragmentForgotPasswordBindingImpl(DataBindingComponent var1, View var2, Object[] var3) {
      super(var1, var2, 2, (AppCompatImageButton)var3[5], (AppCompatImageButton)var3[4], (MaterialButton)var3[1], (TextInputEditText)var3[2], (MaterialToolbar)var3[3], (TextInputLayout)var3[7], (AppCompatTextView)var3[8], (AppCompatTextView)var3[6]);
      this.emailandroidTextAttrChanged = new InverseBindingListener(this) {
         final FragmentForgotPasswordBindingImpl this$0;

         {
            this.this$0 = var1;
         }

         public void onChange() {
            String var1 = TextViewBindingAdapter.getTextString(this.this$0.email);
            ForgotPasswordViewModel var2 = this.this$0.mViewModel;
            if (var2 != null) {
               MutableLiveData var3 = var2.getEmail();
               if (var3 != null) {
                  var3.setValue(var1);
               }
            }

         }
      };
      this.mDirtyFlags = -1L;
      this.btnForgotPassword.setTag((Object)null);
      this.email.setTag((Object)null);
      ConstraintLayout var4 = (ConstraintLayout)var3[0];
      this.mboundView0 = var4;
      var4.setTag((Object)null);
      this.setRootTag(var2);
      this.mCallback1 = new OnClickListener(this, 1);
      this.invalidateAll();
   }

   private boolean onChangeViewModelEmail(MutableLiveData param1, int param2) {
      // $FF: Couldn't be decompiled
   }

   private boolean onChangeViewModelEmailValid(LiveData param1, int param2) {
      // $FF: Couldn't be decompiled
   }

   public final void _internalCallbackOnClick(int var1, View var2) {
      ForgotPasswordViewModel var3 = this.mViewModel;
      if (var3 != null) {
         var3.forgotPassword();
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
      if (var1 != 0) {
         return var1 != 1 ? false : this.onChangeViewModelEmailValid((LiveData)var2, var3);
      } else {
         return this.onChangeViewModelEmail((MutableLiveData)var2, var3);
      }
   }

   public boolean setVariable(int var1, Object var2) {
      if (BR.viewModel == var1) {
         this.setViewModel((ForgotPasswordViewModel)var2);
         return true;
      } else {
         return false;
      }
   }

   public void setViewModel(ForgotPasswordViewModel param1) {
      // $FF: Couldn't be decompiled
   }
}
