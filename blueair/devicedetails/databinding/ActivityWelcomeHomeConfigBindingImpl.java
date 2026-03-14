package com.blueair.devicedetails.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.MutableLiveData;
import com.blueair.devicedetails.BR;
import com.blueair.devicedetails.R;
import com.blueair.devicedetails.viewmodel.CreateUpdateWelcomeHomeViewModel;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.blueair.viewcore.view.SimpleStatusBar;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;

public class ActivityWelcomeHomeConfigBindingImpl extends ActivityWelcomeHomeConfigBinding {
   private static final ViewDataBinding.IncludedLayouts sIncludes;
   private static final SparseIntArray sViewsWithIds;
   private long mDirtyFlags;

   static {
      SparseIntArray var0 = new SparseIntArray();
      sViewsWithIds = var0;
      var0.put(R.id.map_container, 12);
      var0.put(R.id.statusBar, 13);
      var0.put(R.id.btnBack, 14);
      var0.put(R.id.btnClose, 15);
      var0.put(R.id.gps_btn, 16);
      var0.put(R.id.cv_home, 17);
      var0.put(R.id.cl_home, 18);
      var0.put(R.id.tv_welcomeHome, 19);
      var0.put(R.id.iv_welcomeHome, 20);
      var0.put(R.id.tv_howArrive, 21);
      var0.put(R.id.im_info, 22);
      var0.put(R.id.tv_arriveDesp, 23);
      var0.put(R.id.ll_transport, 24);
      var0.put(R.id.progressView, 25);
   }

   public ActivityWelcomeHomeConfigBindingImpl(DataBindingComponent var1, View var2) {
      this(var1, var2, mapBindings(var1, var2, 26, sIncludes, sViewsWithIds));
   }

   private ActivityWelcomeHomeConfigBindingImpl(DataBindingComponent var1, View var2, Object[] var3) {
      super(var1, var2, 8, (AppCompatImageButton)var3[14], (AppCompatImageButton)var3[15], (MaterialButton)var3[11], (MaterialButton)var3[10], (ConstraintLayout)var3[18], (MaterialCardView)var3[17], (AppCompatImageButton)var3[16], (Group)var3[5], (AppCompatImageView)var3[22], (AppCompatImageView)var3[20], (LinearLayout)var3[24], (FrameLayout)var3[12], (ProgressBlockerView)var3[25], (ConstraintLayout)var3[0], (SimpleStatusBar)var3[13], (AppCompatTextView)var3[1], (AppCompatTextView)var3[23], (AppCompatCheckBox)var3[7], (AppCompatCheckBox)var3[6], (AppCompatTextView)var3[4], (AppCompatCheckBox)var3[9], (AppCompatTextView)var3[21], (AppCompatTextView)var3[3], (AppCompatTextView)var3[2], (AppCompatCheckBox)var3[8], (TextView)var3[19]);
      this.mDirtyFlags = -1L;
      this.btnDeleteHome.setTag((Object)null);
      this.btnSave.setTag((Object)null);
      this.groupLocationInfo.setTag((Object)null);
      this.rootLayout.setTag((Object)null);
      this.tvAddress.setTag((Object)null);
      this.tvBicycle.setTag((Object)null);
      this.tvCar.setTag((Object)null);
      this.tvCity.setTag((Object)null);
      this.tvCommute.setTag((Object)null);
      this.tvName.setTag((Object)null);
      this.tvSearchOnMap.setTag((Object)null);
      this.tvWalk.setTag((Object)null);
      this.setRootTag(var2);
      this.invalidateAll();
   }

   private boolean onChangeVmBicycle(MutableLiveData param1, int param2) {
      // $FF: Couldn't be decompiled
   }

   private boolean onChangeVmCar(MutableLiveData param1, int param2) {
      // $FF: Couldn't be decompiled
   }

   private boolean onChangeVmCity(MutableLiveData param1, int param2) {
      // $FF: Couldn't be decompiled
   }

   private boolean onChangeVmCommute(MutableLiveData param1, int param2) {
      // $FF: Couldn't be decompiled
   }

   private boolean onChangeVmGotAddress(MutableLiveData param1, int param2) {
      // $FF: Couldn't be decompiled
   }

   private boolean onChangeVmShortAddress(MutableLiveData param1, int param2) {
      // $FF: Couldn't be decompiled
   }

   private boolean onChangeVmWalk(MutableLiveData param1, int param2) {
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
      switch (var1) {
         case 0:
            return this.onChangeVmGotAddress((MutableLiveData)var2, var3);
         case 1:
            return this.onChangeVmShortAddress((MutableLiveData)var2, var3);
         case 2:
            return this.onChangeVmWelcomeHomeExist((MutableLiveData)var2, var3);
         case 3:
            return this.onChangeVmWalk((MutableLiveData)var2, var3);
         case 4:
            return this.onChangeVmCar((MutableLiveData)var2, var3);
         case 5:
            return this.onChangeVmBicycle((MutableLiveData)var2, var3);
         case 6:
            return this.onChangeVmCity((MutableLiveData)var2, var3);
         case 7:
            return this.onChangeVmCommute((MutableLiveData)var2, var3);
         default:
            return false;
      }
   }

   public boolean setVariable(int var1, Object var2) {
      if (BR.vm == var1) {
         this.setVm((CreateUpdateWelcomeHomeViewModel)var2);
         return true;
      } else {
         return false;
      }
   }

   public void setVm(CreateUpdateWelcomeHomeViewModel param1) {
      // $FF: Couldn't be decompiled
   }
}
