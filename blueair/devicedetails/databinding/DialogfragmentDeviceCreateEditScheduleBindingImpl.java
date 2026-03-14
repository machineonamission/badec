package com.blueair.devicedetails.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.constraintlayout.widget.Guideline;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.devicedetails.BR;
import com.blueair.devicedetails.R;
import com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class DialogfragmentDeviceCreateEditScheduleBindingImpl extends DialogfragmentDeviceCreateEditScheduleBinding {
   private static final ViewDataBinding.IncludedLayouts sIncludes;
   private static final SparseIntArray sViewsWithIds;
   private long mDirtyFlags;
   private final CoordinatorLayout mboundView0;

   static {
      SparseIntArray var0 = new SparseIntArray();
      sViewsWithIds = var0;
      var0.put(R.id.toolbar, 1);
      var0.put(R.id.cancel_btn, 2);
      var0.put(R.id.save_btn, 3);
      var0.put(R.id.title, 4);
      var0.put(R.id.scrollable, 5);
      var0.put(R.id.rootLayout, 6);
      var0.put(R.id.start_guideline, 7);
      var0.put(R.id.end_guideline, 8);
      var0.put(R.id.start_time, 9);
      var0.put(R.id.end_time, 10);
      var0.put(R.id.top_time_barrier, 11);
      var0.put(R.id.button_start_time_layout, 12);
      var0.put(R.id.button_start_time, 13);
      var0.put(R.id.dashed_line, 14);
      var0.put(R.id.button_end_time_layout, 15);
      var0.put(R.id.button_end_time, 16);
      var0.put(R.id.bottom_time_barrier, 17);
      var0.put(R.id.progressView, 18);
      var0.put(R.id.recycler_view_start_schedule, 19);
      var0.put(R.id.textview_repeat, 20);
      var0.put(R.id.repeat_container, 21);
      var0.put(R.id.text_view_selected_days, 22);
      var0.put(R.id.recycler_view_day_picker, 23);
      var0.put(R.id.group_label_text, 24);
      var0.put(R.id.textview_label, 25);
      var0.put(R.id.layout_edit_text_label, 26);
      var0.put(R.id.edit_text_label, 27);
      var0.put(R.id.group_custom_schedule, 28);
      var0.put(R.id.textview_custom_schedule, 29);
      var0.put(R.id.radio_group_custom_schedule_settings, 30);
      var0.put(R.id.radio_button_previous, 31);
      var0.put(R.id.radio_button_custom, 32);
      var0.put(R.id.textview_custom_schedule_description, 33);
      var0.put(R.id.recycler_view_custom_schedule, 34);
      var0.put(R.id.group_after_schedule, 35);
      var0.put(R.id.view_after_separator, 36);
      var0.put(R.id.textview_after_schedule, 37);
      var0.put(R.id.recycler_view_end_schedule, 38);
      var0.put(R.id.button_delete_schedule, 39);
   }

   public DialogfragmentDeviceCreateEditScheduleBindingImpl(DataBindingComponent var1, View var2) {
      this(var1, var2, mapBindings(var1, var2, 40, sIncludes, sViewsWithIds));
   }

   private DialogfragmentDeviceCreateEditScheduleBindingImpl(DataBindingComponent var1, View var2, Object[] var3) {
      super(var1, var2, 0, (Barrier)var3[17], (MaterialButton)var3[39], (TextView)var3[16], (TextInputLayout)var3[15], (TextView)var3[13], (TextInputLayout)var3[12], (MaterialButton)var3[2], (TextView)var3[14], (TextInputEditText)var3[27], (Guideline)var3[8], (TextView)var3[10], (Group)var3[35], (Group)var3[28], (Group)var3[24], (TextInputLayout)var3[26], (ProgressBlockerView)var3[18], (RadioButton)var3[32], (RadioButton)var3[31], (RadioGroup)var3[30], (RecyclerView)var3[34], (RecyclerView)var3[23], (RecyclerView)var3[38], (RecyclerView)var3[19], (ConstraintLayout)var3[21], (ConstraintLayout)var3[6], (MaterialButton)var3[3], (NestedScrollView)var3[5], (Guideline)var3[7], (TextView)var3[9], (TextView)var3[22], (TextView)var3[37], (TextView)var3[29], (TextView)var3[33], (TextView)var3[25], (TextView)var3[20], (TextView)var3[4], (Toolbar)var3[1], (Barrier)var3[11], (View)var3[36]);
      this.mDirtyFlags = -1L;
      CoordinatorLayout var4 = (CoordinatorLayout)var3[0];
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

   public void setDeviceCreateEditScheduleViewModel(DeviceCreateEditScheduleViewModel var1) {
      this.mDeviceCreateEditScheduleViewModel = var1;
   }

   public boolean setVariable(int var1, Object var2) {
      if (BR.deviceCreateEditScheduleViewModel == var1) {
         this.setDeviceCreateEditScheduleViewModel((DeviceCreateEditScheduleViewModel)var2);
         return true;
      } else {
         return false;
      }
   }
}
