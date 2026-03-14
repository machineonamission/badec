package com.blueair.android.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.android.R;
import com.blueair.android.viewmodel.IndoorViewModel;
import com.dd.ShadowLayout;
import com.google.android.material.button.MaterialButton;

public class FragmentIndoorBindingImpl extends FragmentIndoorBinding {
   private static final ViewDataBinding.IncludedLayouts sIncludes;
   private static final SparseIntArray sViewsWithIds;
   private long mDirtyFlags;

   static {
      SparseIntArray var0 = new SparseIntArray();
      sViewsWithIds = var0;
      var0.put(R.id.sl_alarm, 1);
      var0.put(R.id.iv_alarm, 2);
      var0.put(R.id.tv_alarmLabel, 3);
      var0.put(R.id.tv_alarmValue, 4);
      var0.put(R.id.listDevices, 5);
      var0.put(R.id.iv_addFooter, 6);
      var0.put(R.id.emptyLayout, 7);
      var0.put(R.id.textEmptyTitle, 8);
      var0.put(R.id.btn_addProduct, 9);
   }

   public FragmentIndoorBindingImpl(DataBindingComponent var1, View var2) {
      this(var1, var2, mapBindings(var1, var2, 10, sIncludes, sViewsWithIds));
   }

   private FragmentIndoorBindingImpl(DataBindingComponent var1, View var2, Object[] var3) {
      super(var1, var2, 0, (MaterialButton)var3[9], (ConstraintLayout)var3[7], (AppCompatImageView)var3[6], (ImageView)var3[2], (ConstraintLayout)var3[0], (RecyclerView)var3[5], (ShadowLayout)var3[1], (AppCompatTextView)var3[8], (TextView)var3[3], (TextView)var3[4]);
      this.mDirtyFlags = -1L;
      this.layoutMain.setTag((Object)null);
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

   public void setIndoorViewModel(IndoorViewModel var1) {
      this.mIndoorViewModel = var1;
   }

   public boolean setVariable(int var1, Object var2) {
      if (8 == var1) {
         this.setIndoorViewModel((IndoorViewModel)var2);
         return true;
      } else {
         return false;
      }
   }
}
