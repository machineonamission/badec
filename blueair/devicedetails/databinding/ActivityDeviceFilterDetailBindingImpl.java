package com.blueair.devicedetails.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.devicedetails.R;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.dd.ShadowLayout;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.progressindicator.LinearProgressIndicator;

public class ActivityDeviceFilterDetailBindingImpl extends ActivityDeviceFilterDetailBinding {
   private static final ViewDataBinding.IncludedLayouts sIncludes;
   private static final SparseIntArray sViewsWithIds;
   private long mDirtyFlags;
   private final FrameLayout mboundView0;

   static {
      SparseIntArray var0 = new SparseIntArray();
      sViewsWithIds = var0;
      var0.put(R.id.content_container, 1);
      var0.put(R.id.btnBack, 2);
      var0.put(R.id.title, 3);
      var0.put(R.id.tv_subtitle, 4);
      var0.put(R.id.close_btn, 5);
      var0.put(R.id.scroll_view, 6);
      var0.put(R.id.start_guideline, 7);
      var0.put(R.id.end_guideline, 8);
      var0.put(R.id.cv_filterLife, 9);
      var0.put(R.id.leading_icon, 10);
      var0.put(R.id.tv_filterLife, 11);
      var0.put(R.id.iv_info, 12);
      var0.put(R.id.tv_progress, 13);
      var0.put(R.id.bg_filterInfo, 14);
      var0.put(R.id.tv_changeFilter, 15);
      var0.put(R.id.tv_filterInfo, 16);
      var0.put(R.id.progress_indicator, 17);
      var0.put(R.id.btn_buy, 18);
      var0.put(R.id.btn_reset_filter, 19);
      var0.put(R.id.cv_replaceFilter, 20);
      var0.put(R.id.video_thumbnail, 21);
      var0.put(R.id.icon_play, 22);
      var0.put(R.id.tv_guide, 23);
      var0.put(R.id.tv_how_replace, 24);
      var0.put(R.id.btn_getInstructions, 25);
      var0.put(R.id.group_userManual, 26);
      var0.put(R.id.available_filters, 27);
      var0.put(R.id.filter_list, 28);
      var0.put(R.id.btn_visit, 29);
      var0.put(R.id.progress_view, 30);
   }

   public ActivityDeviceFilterDetailBindingImpl(DataBindingComponent var1, View var2) {
      this(var1, var2, mapBindings(var1, var2, 31, sIncludes, sViewsWithIds));
   }

   private ActivityDeviceFilterDetailBindingImpl(DataBindingComponent var1, View var2, Object[] var3) {
      super(var1, var2, 0, (TextView)var3[27], (View)var3[14], (AppCompatImageButton)var3[2], (MaterialButton)var3[18], (MaterialButton)var3[25], (MaterialButton)var3[19], (MaterialButton)var3[29], (AppCompatImageButton)var3[5], (ConstraintLayout)var3[1], (ShadowLayout)var3[9], (ShadowLayout)var3[20], (Guideline)var3[8], (RecyclerView)var3[28], (Group)var3[26], (ImageView)var3[22], (ImageView)var3[12], (ImageView)var3[10], (LinearProgressIndicator)var3[17], (ProgressBlockerView)var3[30], (ScrollView)var3[6], (Guideline)var3[7], (AppCompatTextView)var3[3], (AppCompatTextView)var3[15], (AppCompatTextView)var3[16], (AppCompatTextView)var3[11], (AppCompatTextView)var3[23], (AppCompatTextView)var3[24], (TextView)var3[13], (AppCompatTextView)var3[4], (ShapeableImageView)var3[21]);
      this.mDirtyFlags = -1L;
      FrameLayout var4 = (FrameLayout)var3[0];
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
