package com.blueair.adddevice.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blueair.adddevice.BR;
import com.blueair.adddevice.R;
import com.blueair.adddevice.viewmodel.AddDeviceViewModel;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class FragmentWifiPasswordBindingImpl extends FragmentWifiPasswordBinding {
   private static final ViewDataBinding.IncludedLayouts sIncludes;
   private static final SparseIntArray sViewsWithIds;
   private long mDirtyFlags;

   static {
      SparseIntArray var0 = new SparseIntArray();
      sViewsWithIds = var0;
      var0.put(R.id.tv_title, 1);
      var0.put(R.id.tv_subtitle, 2);
      var0.put(R.id.ssidEditTextLayout, 3);
      var0.put(R.id.ssidEditText, 4);
      var0.put(R.id.input_password, 5);
      var0.put(R.id.passwordEditText, 6);
      var0.put(R.id.tv_error, 7);
      var0.put(R.id.buttonNext, 8);
      var0.put(R.id.log_view, 9);
      var0.put(R.id.progressView, 10);
   }

   public FragmentWifiPasswordBindingImpl(DataBindingComponent var1, View var2) {
      this(var1, var2, mapBindings(var1, var2, 11, sIncludes, sViewsWithIds));
   }

   private FragmentWifiPasswordBindingImpl(DataBindingComponent var1, View var2, Object[] var3) {
      super(var1, var2, 0, (MaterialButton)var3[8], (TextInputLayout)var3[5], (TextView)var3[9], (TextInputEditText)var3[6], (ProgressBlockerView)var3[10], (ConstraintLayout)var3[0], (TextInputEditText)var3[4], (TextInputLayout)var3[3], (AppCompatTextView)var3[7], (AppCompatTextView)var3[2], (AppCompatTextView)var3[1]);
      this.mDirtyFlags = -1L;
      this.rootLayout.setTag((Object)null);
      this.setRootTag(var2);
      this.invalidateAll();
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
      return false;
   }

   public void setAddDeviceViewModel(AddDeviceViewModel var1) {
      this.mAddDeviceViewModel = var1;
   }

   public boolean setVariable(int var1, Object var2) {
      if (BR.addDeviceViewModel == var1) {
         this.setAddDeviceViewModel((AddDeviceViewModel)var2);
         return true;
      } else {
         return false;
      }
   }
}
