package com.blueair.devicedetails.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.devicedetails.R;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.google.android.material.button.MaterialButton;

public class DialogfragmentDeviceNFilterBindingImpl extends DialogfragmentDeviceNFilterBinding {
   private static final ViewDataBinding.IncludedLayouts sIncludes;
   private static final SparseIntArray sViewsWithIds;
   private long mDirtyFlags;
   private final FrameLayout mboundView0;

   static {
      SparseIntArray var0 = new SparseIntArray();
      sViewsWithIds = var0;
      var0.put(R.id.content_container, 1);
      var0.put(R.id.title, 2);
      var0.put(R.id.close_btn, 3);
      var0.put(R.id.scroll_view, 4);
      var0.put(R.id.start_guideline, 5);
      var0.put(R.id.end_guideline, 6);
      var0.put(R.id.replace_group, 7);
      var0.put(R.id.video_thumbnail, 8);
      var0.put(R.id.icon_play, 9);
      var0.put(R.id.why_is_this_important, 10);
      var0.put(R.id.video_summary, 11);
      var0.put(R.id.available_filters, 12);
      var0.put(R.id.filter_list, 13);
      var0.put(R.id.filter_scroll_left, 14);
      var0.put(R.id.filter_scroll_right, 15);
      var0.put(R.id.btn_anti_fake, 16);
      var0.put(R.id.btn_reset_filter, 17);
      var0.put(R.id.buy_new_filter, 18);
      var0.put(R.id.btn_subscribe, 19);
      var0.put(R.id.btn_purchase, 20);
      var0.put(R.id.discount_hint, 21);
      var0.put(R.id.progress_view, 22);
   }

   public DialogfragmentDeviceNFilterBindingImpl(DataBindingComponent var1, View var2) {
      this(var1, var2, mapBindings(var1, var2, 23, sIncludes, sViewsWithIds));
   }

   private DialogfragmentDeviceNFilterBindingImpl(DataBindingComponent var1, View var2, Object[] var3) {
      super(var1, var2, 0, (TextView)var3[12], (MaterialButton)var3[16], (MaterialButton)var3[20], (MaterialButton)var3[17], (MaterialButton)var3[19], (TextView)var3[18], (ImageButton)var3[3], (ConstraintLayout)var3[1], (TextView)var3[21], (Guideline)var3[6], (RecyclerView)var3[13], (ImageView)var3[14], (ImageView)var3[15], (AppCompatImageButton)var3[9], (ProgressBlockerView)var3[22], (Group)var3[7], (ScrollView)var3[4], (Guideline)var3[5], (TextView)var3[2], (TextView)var3[11], (AppCompatImageView)var3[8], (TextView)var3[10]);
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
