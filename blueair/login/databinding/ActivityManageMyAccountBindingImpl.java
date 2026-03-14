package com.blueair.login.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blueair.login.R;
import com.google.android.material.appbar.MaterialToolbar;

public class ActivityManageMyAccountBindingImpl extends ActivityManageMyAccountBinding {
   private static final ViewDataBinding.IncludedLayouts sIncludes;
   private static final SparseIntArray sViewsWithIds;
   private long mDirtyFlags;
   private final LinearLayout mboundView0;

   static {
      SparseIntArray var0 = new SparseIntArray();
      sViewsWithIds = var0;
      var0.put(R.id.toolbar, 1);
      var0.put(R.id.scrollableRoot, 2);
      var0.put(R.id.delete_account_cell, 3);
      var0.put(R.id.delete_account_title, 4);
      var0.put(R.id.delete_account_summary, 5);
      var0.put(R.id.delete_account_chevron, 6);
   }

   public ActivityManageMyAccountBindingImpl(DataBindingComponent var1, View var2) {
      this(var1, var2, mapBindings(var1, var2, 7, sIncludes, sViewsWithIds));
   }

   private ActivityManageMyAccountBindingImpl(DataBindingComponent var1, View var2, Object[] var3) {
      super(var1, var2, 0, (ConstraintLayout)var3[3], (ImageView)var3[6], (TextView)var3[5], (TextView)var3[4], (ScrollView)var3[2], (MaterialToolbar)var3[1]);
      this.mDirtyFlags = -1L;
      LinearLayout var4 = (LinearLayout)var3[0];
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

   public boolean setVariable(int var1, Object var2) {
      return true;
   }
}
