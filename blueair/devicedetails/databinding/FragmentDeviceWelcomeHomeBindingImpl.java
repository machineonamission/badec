package com.blueair.devicedetails.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.MutableLiveData;
import com.blueair.devicedetails.BR;
import com.blueair.devicedetails.R;
import com.blueair.devicedetails.viewmodel.DeviceWelcomeHomeViewModel;
import com.blueair.viewcore.view.SwitchCompat;
import com.google.android.material.button.MaterialButton;

public class FragmentDeviceWelcomeHomeBindingImpl extends FragmentDeviceWelcomeHomeBinding {
   private static final ViewDataBinding.IncludedLayouts sIncludes;
   private static final SparseIntArray sViewsWithIds;
   private long mDirtyFlags;
   private final LinearLayout mboundView0;

   static {
      SparseIntArray var0 = new SparseIntArray();
      sViewsWithIds = var0;
      var0.put(R.id.welcome_home_title, 7);
      var0.put(R.id.im_location, 8);
   }

   public FragmentDeviceWelcomeHomeBindingImpl(DataBindingComponent var1, View var2) {
      this(var1, var2, mapBindings(var1, var2, 9, sIncludes, sViewsWithIds));
   }

   private FragmentDeviceWelcomeHomeBindingImpl(DataBindingComponent var1, View var2, Object[] var3) {
      super(var1, var2, 4, (MaterialButton)var3[2], (TextView)var3[4], (ImageView)var3[8], (ConstraintLayout)var3[3], (TextView)var3[5], (TextView)var3[6], (SwitchCompat)var3[1], (TextView)var3[7]);
      this.mDirtyFlags = -1L;
      this.btnAddHome.setTag((Object)null);
      this.homeAddress.setTag((Object)null);
      this.layoutAddress.setTag((Object)null);
      LinearLayout var4 = (LinearLayout)var3[0];
      this.mboundView0 = var4;
      var4.setTag((Object)null);
      this.radius.setTag((Object)null);
      this.radiusValue.setTag((Object)null);
      this.welcomeHomeSwitch.setTag((Object)null);
      this.setRootTag(var2);
      this.invalidateAll();
   }

   private boolean onChangeVmAddress(MutableLiveData param1, int param2) {
      // $FF: Couldn't be decompiled
   }

   private boolean onChangeVmRadius(MutableLiveData param1, int param2) {
      // $FF: Couldn't be decompiled
   }

   private boolean onChangeVmWelcomeHomeEnabled(MutableLiveData param1, int param2) {
      // $FF: Couldn't be decompiled
   }

   private boolean onChangeVmWelcomeHomeExist(MutableLiveData param1, int param2) {
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
               return var1 != 3 ? false : this.onChangeVmAddress((MutableLiveData)var2, var3);
            } else {
               return this.onChangeVmWelcomeHomeEnabled((MutableLiveData)var2, var3);
            }
         } else {
            return this.onChangeVmWelcomeHomeExist((MutableLiveData)var2, var3);
         }
      } else {
         return this.onChangeVmRadius((MutableLiveData)var2, var3);
      }
   }

   public boolean setVariable(int var1, Object var2) {
      if (BR.vm == var1) {
         this.setVm((DeviceWelcomeHomeViewModel)var2);
         return true;
      } else {
         return false;
      }
   }

   public void setVm(DeviceWelcomeHomeViewModel param1) {
      // $FF: Couldn't be decompiled
   }
}
