package com.blueair.devicedetails.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blueair.devicedetails.R;
import com.github.gzuliyujiang.wheelview.widget.WheelView;
import com.google.android.material.button.MaterialButton;

public class DialogfragmentDeviceTimerPickerV2BindingImpl extends DialogfragmentDeviceTimerPickerV2Binding {
   private static final ViewDataBinding.IncludedLayouts sIncludes;
   private static final SparseIntArray sViewsWithIds;
   private long mDirtyFlags;

   static {
      SparseIntArray var0 = new SparseIntArray();
      sViewsWithIds = var0;
      var0.put(R.id.v_top, 1);
      var0.put(R.id.title, 2);
      var0.put(R.id.iv_scaleMaskLeft, 3);
      var0.put(R.id.iv_scaleMaskRight, 4);
      var0.put(R.id.btn_close, 5);
      var0.put(R.id.wheel_hour, 6);
      var0.put(R.id.tv_colon, 7);
      var0.put(R.id.wheel_minute, 8);
      var0.put(R.id.tv_hours, 9);
      var0.put(R.id.tv_mins, 10);
      var0.put(R.id.btn_done, 11);
   }

   public DialogfragmentDeviceTimerPickerV2BindingImpl(DataBindingComponent var1, View var2) {
      this(var1, var2, mapBindings(var1, var2, 12, sIncludes, sViewsWithIds));
   }

   private DialogfragmentDeviceTimerPickerV2BindingImpl(DataBindingComponent var1, View var2, Object[] var3) {
      super(var1, var2, 0, (AppCompatImageButton)var3[5], (MaterialButton)var3[11], (ConstraintLayout)var3[0], (AppCompatImageView)var3[3], (AppCompatImageView)var3[4], (TextView)var3[2], (AppCompatTextView)var3[7], (AppCompatTextView)var3[9], (AppCompatTextView)var3[10], (View)var3[1], (WheelView)var3[6], (WheelView)var3[8]);
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
