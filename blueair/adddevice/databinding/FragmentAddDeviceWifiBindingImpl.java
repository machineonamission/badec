package com.blueair.adddevice.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.blueair.adddevice.BR;
import com.blueair.adddevice.R;
import com.blueair.adddevice.viewmodel.AddDeviceViewModel;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.google.android.material.button.MaterialButton;

public class FragmentAddDeviceWifiBindingImpl extends FragmentAddDeviceWifiBinding {
   private static final ViewDataBinding.IncludedLayouts sIncludes;
   private static final SparseIntArray sViewsWithIds;
   private long mDirtyFlags;

   static {
      SparseIntArray var0 = new SparseIntArray();
      sViewsWithIds = var0;
      var0.put(R.id.rootLayout, 1);
      var0.put(R.id.tv_title, 2);
      var0.put(R.id.tv_subtitle, 3);
      var0.put(R.id.btn_refresh, 4);
      var0.put(R.id.recyclerViewSsid, 5);
      var0.put(R.id.progressView, 6);
   }

   public FragmentAddDeviceWifiBindingImpl(DataBindingComponent var1, View var2) {
      this(var1, var2, mapBindings(var1, var2, 7, sIncludes, sViewsWithIds));
   }

   private FragmentAddDeviceWifiBindingImpl(DataBindingComponent var1, View var2, Object[] var3) {
      super(var1, var2, 0, (MaterialButton)var3[4], (ProgressBlockerView)var3[6], (RecyclerView)var3[5], (ConstraintLayout)var3[1], (SwipeRefreshLayout)var3[0], (AppCompatTextView)var3[3], (AppCompatTextView)var3[2]);
      this.mDirtyFlags = -1L;
      this.swipeToRefresh.setTag((Object)null);
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
