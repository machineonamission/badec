package com.blueair.devicedetails.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blueair.devicedetails.R;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.dd.ShadowLayout;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.imageview.ShapeableImageView;

public class ActivityDeviceReplaceFilterBindingImpl extends ActivityDeviceReplaceFilterBinding {
   private static final ViewDataBinding.IncludedLayouts sIncludes;
   private static final SparseIntArray sViewsWithIds;
   private long mDirtyFlags;

   static {
      SparseIntArray var0 = new SparseIntArray();
      sViewsWithIds = var0;
      var0.put(R.id.btnBack, 1);
      var0.put(R.id.title, 2);
      var0.put(R.id.tv_subtitle, 3);
      var0.put(R.id.close_btn, 4);
      var0.put(R.id.scroll_view, 5);
      var0.put(R.id.start_guideline, 6);
      var0.put(R.id.end_guideline, 7);
      var0.put(R.id.why_is_this_important, 8);
      var0.put(R.id.video_summary, 9);
      var0.put(R.id.tv_watchVideo, 10);
      var0.put(R.id.sl_replaceFilter, 11);
      var0.put(R.id.video_thumbnail, 12);
      var0.put(R.id.icon_play, 13);
      var0.put(R.id.tv_readManual, 14);
      var0.put(R.id.sl_userManual, 15);
      var0.put(R.id.iv_userManual, 16);
      var0.put(R.id.tv_userManual, 17);
      var0.put(R.id.tv_manualInfo, 18);
      var0.put(R.id.group_userManual, 19);
      var0.put(R.id.btn_reset_filter, 20);
      var0.put(R.id.progress_view, 21);
   }

   public ActivityDeviceReplaceFilterBindingImpl(DataBindingComponent var1, View var2) {
      this(var1, var2, mapBindings(var1, var2, 22, sIncludes, sViewsWithIds));
   }

   private ActivityDeviceReplaceFilterBindingImpl(DataBindingComponent var1, View var2, Object[] var3) {
      super(var1, var2, 0, (AppCompatImageButton)var3[1], (MaterialButton)var3[20], (AppCompatImageButton)var3[4], (ConstraintLayout)var3[0], (Guideline)var3[7], (Group)var3[19], (AppCompatImageButton)var3[13], (AppCompatImageView)var3[16], (ProgressBlockerView)var3[21], (ScrollView)var3[5], (ShadowLayout)var3[11], (ShadowLayout)var3[15], (Guideline)var3[6], (AppCompatTextView)var3[2], (AppCompatTextView)var3[18], (TextView)var3[14], (AppCompatTextView)var3[3], (AppCompatTextView)var3[17], (TextView)var3[10], (TextView)var3[9], (ShapeableImageView)var3[12], (TextView)var3[8]);
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
