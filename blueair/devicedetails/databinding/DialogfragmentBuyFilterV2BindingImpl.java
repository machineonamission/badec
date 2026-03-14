package com.blueair.devicedetails.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.devicedetails.R;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.google.android.material.button.MaterialButton;

public class DialogfragmentBuyFilterV2BindingImpl extends DialogfragmentBuyFilterV2Binding {
   private static final ViewDataBinding.IncludedLayouts sIncludes;
   private static final SparseIntArray sViewsWithIds;
   private long mDirtyFlags;

   static {
      SparseIntArray var0 = new SparseIntArray();
      sViewsWithIds = var0;
      var0.put(R.id.v_top, 1);
      var0.put(R.id.title, 2);
      var0.put(R.id.close_btn, 3);
      var0.put(R.id.start_guideline, 4);
      var0.put(R.id.end_guideline, 5);
      var0.put(R.id.filter_list, 6);
      var0.put(R.id.btn_subscribe, 7);
      var0.put(R.id.btn_purchase, 8);
      var0.put(R.id.discount_hint, 9);
      var0.put(R.id.progress_view, 10);
   }

   public DialogfragmentBuyFilterV2BindingImpl(DataBindingComponent var1, View var2) {
      this(var1, var2, mapBindings(var1, var2, 11, sIncludes, sViewsWithIds));
   }

   private DialogfragmentBuyFilterV2BindingImpl(DataBindingComponent var1, View var2, Object[] var3) {
      super(var1, var2, 0, (MaterialButton)var3[8], (MaterialButton)var3[7], (AppCompatImageButton)var3[3], (ConstraintLayout)var3[0], (TextView)var3[9], (Guideline)var3[5], (RecyclerView)var3[6], (ProgressBlockerView)var3[10], (Guideline)var3[4], (AppCompatTextView)var3[2], (View)var3[1]);
      this.mDirtyFlags = -1L;
      this.contentContainer.setTag((Object)null);
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
