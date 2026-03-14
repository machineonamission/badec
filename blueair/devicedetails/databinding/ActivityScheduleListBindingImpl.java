package com.blueair.devicedetails.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.devicedetails.R;
import com.google.android.material.button.MaterialButton;

public class ActivityScheduleListBindingImpl extends ActivityScheduleListBinding {
   private static final ViewDataBinding.IncludedLayouts sIncludes;
   private static final SparseIntArray sViewsWithIds;
   private long mDirtyFlags;
   private final ConstraintLayout mboundView0;

   static {
      SparseIntArray var0 = new SparseIntArray();
      sViewsWithIds = var0;
      var0.put(R.id.btnBack, 1);
      var0.put(R.id.tv_title, 2);
      var0.put(R.id.tv_subtitle, 3);
      var0.put(R.id.btnMore, 4);
      var0.put(R.id.rv_list, 5);
      var0.put(R.id.bottom_bar, 6);
      var0.put(R.id.separator, 7);
      var0.put(R.id.btn_create, 8);
   }

   public ActivityScheduleListBindingImpl(DataBindingComponent var1, View var2) {
      this(var1, var2, mapBindings(var1, var2, 9, sIncludes, sViewsWithIds));
   }

   private ActivityScheduleListBindingImpl(DataBindingComponent var1, View var2, Object[] var3) {
      super(var1, var2, 0, (LinearLayout)var3[6], (AppCompatImageButton)var3[1], (MaterialButton)var3[8], (AppCompatImageButton)var3[4], (RecyclerView)var3[5], (View)var3[7], (AppCompatTextView)var3[3], (AppCompatTextView)var3[2]);
      this.mDirtyFlags = -1L;
      ConstraintLayout var4 = (ConstraintLayout)var3[0];
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
