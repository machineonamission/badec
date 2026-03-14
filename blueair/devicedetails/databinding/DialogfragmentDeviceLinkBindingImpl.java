package com.blueair.devicedetails.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.devicedetails.BR;
import com.blueair.devicedetails.R;
import com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel;
import com.google.android.material.button.MaterialButton;

public class DialogfragmentDeviceLinkBindingImpl extends DialogfragmentDeviceLinkBinding {
   private static final ViewDataBinding.IncludedLayouts sIncludes;
   private static final SparseIntArray sViewsWithIds;
   private long mDirtyFlags;
   private final LinearLayout mboundView0;

   static {
      SparseIntArray var0 = new SparseIntArray();
      sViewsWithIds = var0;
      var0.put(R.id.root_layout, 1);
      var0.put(R.id.top_guideline, 2);
      var0.put(R.id.bottom_guideline, 3);
      var0.put(R.id.start_guideline, 4);
      var0.put(R.id.end_guideline, 5);
      var0.put(R.id.title_icon_root, 6);
      var0.put(R.id.link_icon, 7);
      var0.put(R.id.link_plus_icon, 8);
      var0.put(R.id.title, 9);
      var0.put(R.id.subtitle, 10);
      var0.put(R.id.close_btn, 11);
      var0.put(R.id.choose_product_textview, 12);
      var0.put(R.id.product_list, 13);
      var0.put(R.id.connect_button, 14);
   }

   public DialogfragmentDeviceLinkBindingImpl(DataBindingComponent var1, View var2) {
      this(var1, var2, mapBindings(var1, var2, 15, sIncludes, sViewsWithIds));
   }

   private DialogfragmentDeviceLinkBindingImpl(DataBindingComponent var1, View var2, Object[] var3) {
      super(var1, var2, 0, (Guideline)var3[3], (TextView)var3[12], (AppCompatImageView)var3[11], (MaterialButton)var3[14], (Guideline)var3[5], (AppCompatImageView)var3[7], (AppCompatImageView)var3[8], (RecyclerView)var3[13], (ConstraintLayout)var3[1], (Guideline)var3[4], (TextView)var3[10], (TextView)var3[9], (ConstraintLayout)var3[6], (Guideline)var3[2]);
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

   public void setDeviceDetailsViewModel(DeviceDetailsViewModel var1) {
      this.mDeviceDetailsViewModel = var1;
   }

   public boolean setVariable(int var1, Object var2) {
      if (BR.deviceDetailsViewModel == var1) {
         this.setDeviceDetailsViewModel((DeviceDetailsViewModel)var2);
         return true;
      } else {
         return false;
      }
   }
}
