package com.blueair.android.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blueair.android.R;
import com.shawnlin.numberpicker.NumberPicker;

public class DialogfragmentNotificationEditNumberBindingImpl extends DialogfragmentNotificationEditNumberBinding {
   private static final ViewDataBinding.IncludedLayouts sIncludes;
   private static final SparseIntArray sViewsWithIds;
   private long mDirtyFlags;
   private final LinearLayout mboundView0;

   static {
      SparseIntArray var0 = new SparseIntArray();
      sViewsWithIds = var0;
      var0.put(R.id.btn_cancel, 1);
      var0.put(R.id.btn_save, 2);
      var0.put(R.id.number_picker, 3);
   }

   public DialogfragmentNotificationEditNumberBindingImpl(DataBindingComponent var1, View var2) {
      this(var1, var2, mapBindings(var1, var2, 4, sIncludes, sViewsWithIds));
   }

   private DialogfragmentNotificationEditNumberBindingImpl(DataBindingComponent var1, View var2, Object[] var3) {
      super(var1, var2, 0, (Button)var3[1], (Button)var3[2], (NumberPicker)var3[3]);
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
