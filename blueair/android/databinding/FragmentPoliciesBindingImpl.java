package com.blueair.android.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blueair.android.R;
import com.blueair.android.viewmodel.HomeViewModel;

public class FragmentPoliciesBindingImpl extends FragmentPoliciesBinding {
   private static final ViewDataBinding.IncludedLayouts sIncludes;
   private static final SparseIntArray sViewsWithIds;
   private long mDirtyFlags;

   static {
      SparseIntArray var0 = new SparseIntArray();
      sViewsWithIds = var0;
      var0.put(R.id.privacy_policy_clickview, 1);
      var0.put(R.id.privacy_left_guideline, 2);
      var0.put(R.id.privacy_right_guideline, 3);
      var0.put(R.id.privacy_policy_title, 4);
      var0.put(R.id.privacy_policy_arrow, 5);
      var0.put(R.id.privacy_separator, 6);
      var0.put(R.id.icp_no, 7);
   }

   public FragmentPoliciesBindingImpl(DataBindingComponent var1, View var2) {
      this(var1, var2, mapBindings(var1, var2, 8, sIncludes, sViewsWithIds));
   }

   private FragmentPoliciesBindingImpl(DataBindingComponent var1, View var2, Object[] var3) {
      super(var1, var2, 0, (TextView)var3[7], (Guideline)var3[2], (AppCompatImageView)var3[5], (ConstraintLayout)var3[1], (TextView)var3[4], (Guideline)var3[3], (View)var3[6], (ConstraintLayout)var3[0]);
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
