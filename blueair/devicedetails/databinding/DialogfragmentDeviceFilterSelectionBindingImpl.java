package com.blueair.devicedetails.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.blueair.devicedetails.BR;
import com.blueair.devicedetails.R;
import com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.google.android.material.button.MaterialButton;
import ru.tinkoff.scrollingpagerindicator.ScrollingPagerIndicator;

public class DialogfragmentDeviceFilterSelectionBindingImpl extends DialogfragmentDeviceFilterSelectionBinding {
   private static final ViewDataBinding.IncludedLayouts sIncludes;
   private static final SparseIntArray sViewsWithIds;
   private long mDirtyFlags;

   static {
      SparseIntArray var0 = new SparseIntArray();
      sViewsWithIds = var0;
      var0.put(R.id.toolbar, 1);
      var0.put(R.id.title, 2);
      var0.put(R.id.pager_root_layout, 3);
      var0.put(R.id.filter_pager, 4);
      var0.put(R.id.dots_indicator, 5);
      var0.put(R.id.btnLeft, 6);
      var0.put(R.id.btnRight, 7);
      var0.put(R.id.button_save, 8);
      var0.put(R.id.progressView, 9);
   }

   public DialogfragmentDeviceFilterSelectionBindingImpl(DataBindingComponent var1, View var2) {
      this(var1, var2, mapBindings(var1, var2, 10, sIncludes, sViewsWithIds));
   }

   private DialogfragmentDeviceFilterSelectionBindingImpl(DataBindingComponent var1, View var2, Object[] var3) {
      super(var1, var2, 0, (ImageButton)var3[6], (ImageButton)var3[7], (MaterialButton)var3[8], (ScrollingPagerIndicator)var3[5], (ViewPager2)var3[4], (ConstraintLayout)var3[3], (ProgressBlockerView)var3[9], (CoordinatorLayout)var3[0], (TextView)var3[2], (Toolbar)var3[1]);
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
