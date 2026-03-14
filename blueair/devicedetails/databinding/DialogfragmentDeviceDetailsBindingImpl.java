package com.blueair.devicedetails.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blueair.devicedetails.BR;
import com.blueair.devicedetails.R;
import com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel;

public class DialogfragmentDeviceDetailsBindingImpl extends DialogfragmentDeviceDetailsBinding {
   private static final ViewDataBinding.IncludedLayouts sIncludes;
   private static final SparseIntArray sViewsWithIds;
   private long mDirtyFlags;

   static {
      SparseIntArray var0 = new SparseIntArray();
      sViewsWithIds = var0;
      var0.put(R.id.title_bar, 1);
      var0.put(R.id.close_btn, 2);
      var0.put(R.id.device_icon, 3);
      var0.put(R.id.device_name, 4);
      var0.put(R.id.location, 5);
      var0.put(R.id.scrollable, 6);
      var0.put(R.id.content_container, 7);
      var0.put(R.id.banners_container, 8);
      var0.put(R.id.graph_container, 9);
      var0.put(R.id.devices_attributes_container, 10);
      var0.put(R.id.device_schedules_container, 11);
      var0.put(R.id.welcome_home_container, 12);
      var0.put(R.id.device_settings_container, 13);
   }

   public DialogfragmentDeviceDetailsBindingImpl(DataBindingComponent var1, View var2) {
      this(var1, var2, mapBindings(var1, var2, 14, sIncludes, sViewsWithIds));
   }

   private DialogfragmentDeviceDetailsBindingImpl(DataBindingComponent var1, View var2, Object[] var3) {
      super(var1, var2, 0, (FrameLayout)var3[8], (ImageButton)var3[2], (LinearLayout)var3[7], (AppCompatImageView)var3[3], (TextView)var3[4], (FrameLayout)var3[11], (FrameLayout)var3[13], (FrameLayout)var3[10], (FrameLayout)var3[9], (TextView)var3[5], (LinearLayout)var3[0], (NestedScrollView)var3[6], (ConstraintLayout)var3[1], (FrameLayout)var3[12]);
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

   public void setDeviceDetailViewModel(DeviceDetailsViewModel var1) {
      this.mDeviceDetailViewModel = var1;
   }

   public boolean setVariable(int var1, Object var2) {
      if (BR.deviceDetailViewModel == var1) {
         this.setDeviceDetailViewModel((DeviceDetailsViewModel)var2);
         return true;
      } else {
         return false;
      }
   }
}
