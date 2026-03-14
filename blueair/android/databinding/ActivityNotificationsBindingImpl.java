package com.blueair.android.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.android.R;
import com.blueair.android.viewmodel.NotificationsViewModel;

public class ActivityNotificationsBindingImpl extends ActivityNotificationsBinding {
   private static final ViewDataBinding.IncludedLayouts sIncludes;
   private static final SparseIntArray sViewsWithIds;
   private long mDirtyFlags;
   private final ConstraintLayout mboundView0;

   static {
      SparseIntArray var0 = new SparseIntArray();
      sViewsWithIds = var0;
      var0.put(R.id.btnBack, 2);
      var0.put(R.id.tv_title, 3);
      var0.put(R.id.tv_labelNew, 4);
      var0.put(R.id.tv_dismissAll, 5);
      var0.put(R.id.rv_list, 6);
   }

   public ActivityNotificationsBindingImpl(DataBindingComponent var1, View var2) {
      this(var1, var2, mapBindings(var1, var2, 7, sIncludes, sViewsWithIds));
   }

   private ActivityNotificationsBindingImpl(DataBindingComponent var1, View var2, Object[] var3) {
      super(var1, var2, 1, (AppCompatImageButton)var3[2], (RecyclerView)var3[6], (AppCompatTextView)var3[5], (AppCompatTextView)var3[1], (AppCompatTextView)var3[4], (AppCompatTextView)var3[3]);
      this.mDirtyFlags = -1L;
      ConstraintLayout var4 = (ConstraintLayout)var3[0];
      this.mboundView0 = var4;
      var4.setTag((Object)null);
      this.tvIndoorDeviceNum.setTag((Object)null);
      this.setRootTag(var2);
      this.invalidateAll();
   }

   private boolean onChangeViewModelNotificationsNum(MutableLiveData param1, int param2) {
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
      return var1 != 0 ? false : this.onChangeViewModelNotificationsNum((MutableLiveData)var2, var3);
   }

   public boolean setVariable(int var1, Object var2) {
      if (10 == var1) {
         this.setViewModel((NotificationsViewModel)var2);
         return true;
      } else {
         return false;
      }
   }

   public void setViewModel(NotificationsViewModel param1) {
      // $FF: Couldn't be decompiled
   }
}
