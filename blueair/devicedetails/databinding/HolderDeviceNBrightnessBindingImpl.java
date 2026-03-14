package com.blueair.devicedetails.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blueair.devicedetails.R;
import com.blueair.viewcore.view.AccessibleSeekBar;

public class HolderDeviceNBrightnessBindingImpl extends HolderDeviceNBrightnessBinding {
   private static final ViewDataBinding.IncludedLayouts sIncludes;
   private static final SparseIntArray sViewsWithIds;
   private long mDirtyFlags;
   private final FrameLayout mboundView0;

   static {
      SparseIntArray var0 = new SparseIntArray();
      sViewsWithIds = var0;
      var0.put(R.id.content_container, 1);
      var0.put(R.id.title, 2);
      var0.put(R.id.progressText, 3);
      var0.put(R.id.seekbar, 4);
   }

   public HolderDeviceNBrightnessBindingImpl(DataBindingComponent var1, View var2) {
      this(var1, var2, mapBindings(var1, var2, 5, sIncludes, sViewsWithIds));
   }

   private HolderDeviceNBrightnessBindingImpl(DataBindingComponent var1, View var2, Object[] var3) {
      super(var1, var2, 0, (ConstraintLayout)var3[1], (TextView)var3[3], (AccessibleSeekBar)var3[4], (TextView)var3[2]);
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
