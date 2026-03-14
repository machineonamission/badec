package com.blueair.login.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blueair.login.R;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;

public class ActivityDisableIotConfirmBindingImpl extends ActivityDisableIotConfirmBinding {
   private static final ViewDataBinding.IncludedLayouts sIncludes;
   private static final SparseIntArray sViewsWithIds;
   private long mDirtyFlags;
   private final FrameLayout mboundView0;

   static {
      SparseIntArray var0 = new SparseIntArray();
      sViewsWithIds = var0;
      var0.put(R.id.toolbar, 1);
      var0.put(R.id.btnClose, 2);
      var0.put(R.id.scrollableRoot, 3);
      var0.put(R.id.icon, 4);
      var0.put(R.id.description, 5);
      var0.put(R.id.btnDelete, 6);
      var0.put(R.id.loading, 7);
   }

   public ActivityDisableIotConfirmBindingImpl(DataBindingComponent var1, View var2) {
      this(var1, var2, mapBindings(var1, var2, 8, sIncludes, sViewsWithIds));
   }

   private ActivityDisableIotConfirmBindingImpl(DataBindingComponent var1, View var2, Object[] var3) {
      super(var1, var2, 0, (AppCompatImageButton)var3[2], (MaterialButton)var3[6], (TextView)var3[5], (ImageView)var3[4], (ProgressBlockerView)var3[7], (ScrollView)var3[3], (MaterialToolbar)var3[1]);
      this.mDirtyFlags = -1L;
      FrameLayout var4 = (FrameLayout)var3[0];
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
