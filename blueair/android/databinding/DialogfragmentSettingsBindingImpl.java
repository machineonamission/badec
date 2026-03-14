package com.blueair.android.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.MutableLiveData;
import com.blueair.android.R;
import com.blueair.android.viewmodel.HomeViewModel;
import com.blueair.viewcore.view.ProgressBlockerView;

public class DialogfragmentSettingsBindingImpl extends DialogfragmentSettingsBinding {
   private static final ViewDataBinding.IncludedLayouts sIncludes;
   private static final SparseIntArray sViewsWithIds;
   private long mDirtyFlags;

   static {
      SparseIntArray var0 = new SparseIntArray();
      sViewsWithIds = var0;
      var0.put(R.id.title_bar_container, 3);
      var0.put(R.id.title, 4);
      var0.put(R.id.close_btn, 5);
      var0.put(R.id.item_notification, 6);
      var0.put(R.id.tv_notification, 7);
      var0.put(R.id.notification_arrow, 8);
      var0.put(R.id.notification_separator, 9);
      var0.put(R.id.item_temp_setting, 10);
      var0.put(R.id.tv_temp_title, 11);
      var0.put(R.id.temp_arrow, 12);
      var0.put(R.id.temp_separator, 13);
      var0.put(R.id.item_license, 14);
      var0.put(R.id.tv_license, 15);
      var0.put(R.id.license_arrow, 16);
   }

   public DialogfragmentSettingsBindingImpl(DataBindingComponent var1, View var2) {
      this(var1, var2, mapBindings(var1, var2, 17, sIncludes, sViewsWithIds));
   }

   private DialogfragmentSettingsBindingImpl(DataBindingComponent var1, View var2, Object[] var3) {
      super(var1, var2, 2, (ImageButton)var3[5], (LinearLayout)var3[14], (LinearLayout)var3[6], (LinearLayout)var3[10], (AppCompatImageView)var3[16], (AppCompatImageView)var3[8], (View)var3[9], (ProgressBlockerView)var3[2], (ConstraintLayout)var3[0], (AppCompatImageView)var3[12], (View)var3[13], (TextView)var3[4], (ConstraintLayout)var3[3], (TextView)var3[15], (TextView)var3[7], (TextView)var3[11], (TextView)var3[1]);
      this.mDirtyFlags = -1L;
      this.progressView.setTag((Object)null);
      this.rootLayout.setTag((Object)null);
      this.tvTempUnit.setTag((Object)null);
      this.setRootTag(var2);
      this.invalidateAll();
   }

   private boolean onChangeHomeViewModelIsTempCelsius(MutableLiveData param1, int param2) {
      // $FF: Couldn't be decompiled
   }

   private boolean onChangeHomeViewModelSettingsLoading(MutableLiveData param1, int param2) {
      // $FF: Couldn't be decompiled
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
      if (var1 != 0) {
         return var1 != 1 ? false : this.onChangeHomeViewModelIsTempCelsius((MutableLiveData)var2, var3);
      } else {
         return this.onChangeHomeViewModelSettingsLoading((MutableLiveData)var2, var3);
      }
   }

   public void setHomeViewModel(HomeViewModel param1) {
      // $FF: Couldn't be decompiled
   }

   public boolean setVariable(int var1, Object var2) {
      if (7 == var1) {
         this.setHomeViewModel((HomeViewModel)var2);
         return true;
      } else {
         return false;
      }
   }
}
