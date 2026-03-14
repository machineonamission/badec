package com.blueair.adddevice.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blueair.adddevice.R;
import com.google.android.material.button.MaterialButton;

public class FragmentClassicTroubleshootingBindingImpl extends FragmentClassicTroubleshootingBinding {
   private static final ViewDataBinding.IncludedLayouts sIncludes;
   private static final SparseIntArray sViewsWithIds;
   private long mDirtyFlags;

   static {
      SparseIntArray var0 = new SparseIntArray();
      sViewsWithIds = var0;
      var0.put(R.id.imgWifiBlinking, 1);
      var0.put(R.id.imgWifiFading, 2);
      var0.put(R.id.imgWifiFadingFast, 3);
      var0.put(R.id.imgWifiSolid, 4);
      var0.put(R.id.radioBtnWifiFading, 5);
      var0.put(R.id.radioBtnWifiBlinking, 6);
      var0.put(R.id.radioBtnWifiFadingFast, 7);
      var0.put(R.id.radioBtnWifiSolid, 8);
      var0.put(R.id.txtTitle, 9);
      var0.put(R.id.txtError, 10);
      var0.put(R.id.txtHint, 11);
      var0.put(R.id.btnNext, 12);
   }

   public FragmentClassicTroubleshootingBindingImpl(DataBindingComponent var1, View var2) {
      this(var1, var2, mapBindings(var1, var2, 13, sIncludes, sViewsWithIds));
   }

   private FragmentClassicTroubleshootingBindingImpl(DataBindingComponent var1, View var2, Object[] var3) {
      super(var1, var2, 0, (MaterialButton)var3[12], (ImageView)var3[1], (ImageView)var3[2], (ImageView)var3[3], (ImageView)var3[4], (RadioButton)var3[6], (RadioButton)var3[5], (RadioButton)var3[7], (RadioButton)var3[8], (ScrollView)var3[0], (TextView)var3[10], (TextView)var3[11], (TextView)var3[9]);
      this.mDirtyFlags = -1L;
      this.scrollable.setTag((Object)null);
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
