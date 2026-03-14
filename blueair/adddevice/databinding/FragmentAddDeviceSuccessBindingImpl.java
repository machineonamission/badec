package com.blueair.adddevice.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blueair.adddevice.BR;
import com.blueair.adddevice.R;
import com.blueair.adddevice.viewmodel.AddDeviceViewModel;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.google.android.material.button.MaterialButton;

public class FragmentAddDeviceSuccessBindingImpl extends FragmentAddDeviceSuccessBinding {
   private static final ViewDataBinding.IncludedLayouts sIncludes;
   private static final SparseIntArray sViewsWithIds;
   private long mDirtyFlags;

   static {
      SparseIntArray var0 = new SparseIntArray();
      sViewsWithIds = var0;
      var0.put(R.id.progressView, 1);
      var0.put(R.id.guideline_center, 2);
      var0.put(R.id.iv_device, 3);
      var0.put(R.id.iv_indicator, 4);
      var0.put(R.id.tv_status, 5);
      var0.put(R.id.tv_content, 6);
      var0.put(R.id.button_continue, 7);
   }

   public FragmentAddDeviceSuccessBindingImpl(DataBindingComponent var1, View var2) {
      this(var1, var2, mapBindings(var1, var2, 8, sIncludes, sViewsWithIds));
   }

   private FragmentAddDeviceSuccessBindingImpl(DataBindingComponent var1, View var2, Object[] var3) {
      super(var1, var2, 0, (MaterialButton)var3[7], (Guideline)var3[2], (AppCompatImageView)var3[3], (AppCompatImageView)var3[4], (ProgressBlockerView)var3[1], (ConstraintLayout)var3[0], (TextView)var3[6], (AppCompatTextView)var3[5]);
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
