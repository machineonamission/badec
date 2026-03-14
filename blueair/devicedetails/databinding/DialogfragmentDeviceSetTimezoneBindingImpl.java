package com.blueair.devicedetails.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.devicedetails.R;
import com.blueair.viewcore.view.ProgressBlockerView;

public class DialogfragmentDeviceSetTimezoneBindingImpl extends DialogfragmentDeviceSetTimezoneBinding {
   private static final ViewDataBinding.IncludedLayouts sIncludes;
   private static final SparseIntArray sViewsWithIds;
   private long mDirtyFlags;
   private final LinearLayout mboundView0;

   static {
      SparseIntArray var0 = new SparseIntArray();
      sViewsWithIds = var0;
      var0.put(R.id.screen_title, 1);
      var0.put(R.id.close_button, 2);
      var0.put(R.id.save_button, 3);
      var0.put(R.id.content_container, 4);
      var0.put(R.id.separator_1, 5);
      var0.put(R.id.search_bar, 6);
      var0.put(R.id.search_clear_btn, 7);
      var0.put(R.id.current_timezone_label, 8);
      var0.put(R.id.local_timezone_label, 9);
      var0.put(R.id.separator_2, 10);
      var0.put(R.id.timezone_list, 11);
      var0.put(R.id.no_results_view, 12);
      var0.put(R.id.progressView, 13);
   }

   public DialogfragmentDeviceSetTimezoneBindingImpl(DataBindingComponent var1, View var2) {
      this(var1, var2, mapBindings(var1, var2, 14, sIncludes, sViewsWithIds));
   }

   private DialogfragmentDeviceSetTimezoneBindingImpl(DataBindingComponent var1, View var2, Object[] var3) {
      super(var1, var2, 0, (Button)var3[2], (ConstraintLayout)var3[4], (TextView)var3[8], (TextView)var3[9], (TextView)var3[12], (ProgressBlockerView)var3[13], (Button)var3[3], (TextView)var3[1], (EditText)var3[6], (ImageButton)var3[7], (View)var3[5], (View)var3[10], (RecyclerView)var3[11]);
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
