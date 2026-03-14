package com.blueair.android.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blueair.android.R;

public class DialogAqiIndexInfoBindingImpl extends DialogAqiIndexInfoBinding {
   private static final ViewDataBinding.IncludedLayouts sIncludes;
   private static final SparseIntArray sViewsWithIds;
   private long mDirtyFlags;
   private final LinearLayout mboundView0;

   static {
      SparseIntArray var0 = new SparseIntArray();
      sViewsWithIds = var0;
      var0.put(R.id.close_button, 1);
      var0.put(R.id.content_container, 2);
      var0.put(R.id.introduction_index, 3);
      var0.put(R.id.index_level_excellent_label, 4);
      var0.put(R.id.index_level_excellent_content, 5);
      var0.put(R.id.index_level_good_label, 6);
      var0.put(R.id.index_level_good_content, 7);
      var0.put(R.id.index_level_moderate_label, 8);
      var0.put(R.id.index_level_moderate_content, 9);
      var0.put(R.id.index_level_polluted_label, 10);
      var0.put(R.id.index_level_polluted_content, 11);
      var0.put(R.id.index_level_vpolluted_label, 12);
      var0.put(R.id.index_level_vpolluted_content, 13);
      var0.put(R.id.sub_title_particles, 14);
      var0.put(R.id.dot_pm25, 15);
      var0.put(R.id.introduction_pm25, 16);
      var0.put(R.id.dot_pm10, 17);
      var0.put(R.id.introduction_pm10, 18);
      var0.put(R.id.sub_title_gases, 19);
      var0.put(R.id.dot_co, 20);
      var0.put(R.id.introduction_co, 21);
      var0.put(R.id.dot_so2, 22);
      var0.put(R.id.introduction_so2, 23);
   }

   public DialogAqiIndexInfoBindingImpl(DataBindingComponent var1, View var2) {
      this(var1, var2, mapBindings(var1, var2, 24, sIncludes, sViewsWithIds));
   }

   private DialogAqiIndexInfoBindingImpl(DataBindingComponent var1, View var2, Object[] var3) {
      super(var1, var2, 0, (ImageButton)var3[1], (ConstraintLayout)var3[2], (ImageView)var3[20], (ImageView)var3[17], (ImageView)var3[15], (ImageView)var3[22], (TextView)var3[5], (TextView)var3[4], (TextView)var3[7], (TextView)var3[6], (TextView)var3[9], (TextView)var3[8], (TextView)var3[11], (TextView)var3[10], (TextView)var3[13], (TextView)var3[12], (TextView)var3[21], (TextView)var3[3], (TextView)var3[18], (TextView)var3[16], (TextView)var3[23], (TextView)var3[19], (TextView)var3[14]);
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

   public boolean setVariable(int var1, Object var2) {
      return true;
   }
}
