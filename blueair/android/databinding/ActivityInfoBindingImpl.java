package com.blueair.android.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blueair.android.R;
import com.blueair.android.viewmodel.HomeViewModel;
import com.google.android.material.appbar.AppBarLayout;

public class ActivityInfoBindingImpl extends ActivityInfoBinding {
   private static final ViewDataBinding.IncludedLayouts sIncludes;
   private static final SparseIntArray sViewsWithIds;
   private long mDirtyFlags;
   private final CoordinatorLayout mboundView0;

   static {
      SparseIntArray var0 = new SparseIntArray();
      sViewsWithIds = var0;
      var0.put(R.id.appbar, 1);
      var0.put(R.id.toolbar, 2);
      var0.put(R.id.info_container, 3);
      var0.put(R.id.errorText, 4);
   }

   public ActivityInfoBindingImpl(DataBindingComponent var1, View var2) {
      this(var1, var2, mapBindings(var1, var2, 5, sIncludes, sViewsWithIds));
   }

   private ActivityInfoBindingImpl(DataBindingComponent var1, View var2, Object[] var3) {
      super(var1, var2, 0, (AppBarLayout)var3[1], (TextView)var3[4], (FrameLayout)var3[3], (Toolbar)var3[2]);
      this.mDirtyFlags = -1L;
      CoordinatorLayout var4 = (CoordinatorLayout)var3[0];
      this.mboundView0 = var4;
      var4.setTag((Object)null);
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

   public void setHomeViewModel(HomeViewModel var1) {
      this.mHomeViewModel = var1;
   }

   public boolean setVariable(int var1, Object var2) {
      if (7 == var1) {
         this.setHomeViewModel((HomeViewModel)var2);
         return true;
      } else {
         return false;
      }
   }
}
