package com.blueair.android.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.android.R;
import com.blueair.viewcore.databinding.StateLoadingFailedBinding;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.blueair.viewcore.view.SwitchCompat;

public class DialogNotificationCenterBindingImpl extends DialogNotificationCenterBinding {
   private static final ViewDataBinding.IncludedLayouts sIncludes;
   private static final SparseIntArray sViewsWithIds;
   private long mDirtyFlags;
   private final LinearLayout mboundView0;

   static {
      SparseIntArray var0 = new SparseIntArray();
      sViewsWithIds = var0;
      var0.put(R.id.state_loading_failed, 2);
      var0.put(R.id.close_button, 3);
      var0.put(R.id.screen_title, 4);
      var0.put(R.id.permission_prompt_bar, 5);
      var0.put(R.id.group_type_all, 6);
      var0.put(R.id.tv_type_all, 7);
      var0.put(R.id.switch_type_all, 8);
      var0.put(R.id.rv_settings, 9);
      var0.put(R.id.group_type_product_alerts, 10);
      var0.put(R.id.tv_type_product_alerts, 11);
      var0.put(R.id.switch_type_product_alerts, 12);
      var0.put(R.id.group_type_product_alerts_limit, 13);
      var0.put(R.id.tv_type_product_alerts_limit, 14);
      var0.put(R.id.progressView, 15);
   }

   public DialogNotificationCenterBindingImpl(DataBindingComponent var1, View var2) {
      this(var1, var2, mapBindings(var1, var2, 16, sIncludes, sViewsWithIds));
   }

   private DialogNotificationCenterBindingImpl(DataBindingComponent var1, View var2, Object[] var3) {
      ImageButton var12 = (ImageButton)var3[3];
      ConstraintLayout var8 = (ConstraintLayout)var3[1];
      LinearLayout var13 = (LinearLayout)var3[6];
      LinearLayout var7 = (LinearLayout)var3[10];
      LinearLayout var11 = (LinearLayout)var3[13];
      TextView var5 = (TextView)var3[5];
      ProgressBlockerView var10 = (ProgressBlockerView)var3[15];
      RecyclerView var6 = (RecyclerView)var3[9];
      TextView var9 = (TextView)var3[4];
      Object var4 = var3[2];
      StateLoadingFailedBinding var15;
      if (var4 != null) {
         var15 = StateLoadingFailedBinding.bind((View)var4);
      } else {
         var15 = null;
      }

      super(var1, var2, 0, var12, var8, var13, var7, var11, var5, var10, var6, var9, var15, (SwitchCompat)var3[8], (SwitchCompat)var3[12], (TextView)var3[7], (TextView)var3[11], (TextView)var3[14]);
      this.mDirtyFlags = -1L;
      this.contentContainer.setTag((Object)null);
      LinearLayout var14 = (LinearLayout)var3[0];
      this.mboundView0 = var14;
      var14.setTag((Object)null);
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
