package com.blueair.android.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blueair.android.R;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.google.android.material.button.MaterialButton;

public class ActivityGoogleAppFlipBindingImpl extends ActivityGoogleAppFlipBinding {
   private static final ViewDataBinding.IncludedLayouts sIncludes;
   private static final SparseIntArray sViewsWithIds;
   private long mDirtyFlags;
   private final FrameLayout mboundView0;

   static {
      SparseIntArray var0 = new SparseIntArray();
      sViewsWithIds = var0;
      var0.put(R.id.imgLogo, 1);
      var0.put(R.id.title, 2);
      var0.put(R.id.signed_in_as, 3);
      var0.put(R.id.data_usage_content, 4);
      var0.put(R.id.review_policy, 5);
      var0.put(R.id.unlink_hint, 6);
      var0.put(R.id.btn_agree, 7);
      var0.put(R.id.btn_cancel, 8);
      var0.put(R.id.loading, 9);
   }

   public ActivityGoogleAppFlipBindingImpl(DataBindingComponent var1, View var2) {
      this(var1, var2, mapBindings(var1, var2, 10, sIncludes, sViewsWithIds));
   }

   private ActivityGoogleAppFlipBindingImpl(DataBindingComponent var1, View var2, Object[] var3) {
      super(var1, var2, 0, (MaterialButton)var3[7], (MaterialButton)var3[8], (ScrollView)var3[4], (AppCompatImageView)var3[1], (ProgressBlockerView)var3[9], (TextView)var3[5], (TextView)var3[3], (TextView)var3[2], (TextView)var3[6]);
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
