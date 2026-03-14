package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.constraintlayout.widget.Guideline;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.devicedetails.R;
import com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public abstract class DialogfragmentDeviceCreateEditScheduleBinding extends ViewDataBinding {
   public final Barrier bottomTimeBarrier;
   public final MaterialButton buttonDeleteSchedule;
   public final TextView buttonEndTime;
   public final TextInputLayout buttonEndTimeLayout;
   public final TextView buttonStartTime;
   public final TextInputLayout buttonStartTimeLayout;
   public final MaterialButton cancelBtn;
   public final TextView dashedLine;
   public final TextInputEditText editTextLabel;
   public final Guideline endGuideline;
   public final TextView endTime;
   public final Group groupAfterSchedule;
   public final Group groupCustomSchedule;
   public final Group groupLabelText;
   public final TextInputLayout layoutEditTextLabel;
   @Bindable
   protected DeviceCreateEditScheduleViewModel mDeviceCreateEditScheduleViewModel;
   public final ProgressBlockerView progressView;
   public final RadioButton radioButtonCustom;
   public final RadioButton radioButtonPrevious;
   public final RadioGroup radioGroupCustomScheduleSettings;
   public final RecyclerView recyclerViewCustomSchedule;
   public final RecyclerView recyclerViewDayPicker;
   public final RecyclerView recyclerViewEndSchedule;
   public final RecyclerView recyclerViewStartSchedule;
   public final ConstraintLayout repeatContainer;
   public final ConstraintLayout rootLayout;
   public final MaterialButton saveBtn;
   public final NestedScrollView scrollable;
   public final Guideline startGuideline;
   public final TextView startTime;
   public final TextView textViewSelectedDays;
   public final TextView textviewAfterSchedule;
   public final TextView textviewCustomSchedule;
   public final TextView textviewCustomScheduleDescription;
   public final TextView textviewLabel;
   public final TextView textviewRepeat;
   public final TextView title;
   public final Toolbar toolbar;
   public final Barrier topTimeBarrier;
   public final View viewAfterSeparator;

   protected DialogfragmentDeviceCreateEditScheduleBinding(Object var1, View var2, int var3, Barrier var4, MaterialButton var5, TextView var6, TextInputLayout var7, TextView var8, TextInputLayout var9, MaterialButton var10, TextView var11, TextInputEditText var12, Guideline var13, TextView var14, Group var15, Group var16, Group var17, TextInputLayout var18, ProgressBlockerView var19, RadioButton var20, RadioButton var21, RadioGroup var22, RecyclerView var23, RecyclerView var24, RecyclerView var25, RecyclerView var26, ConstraintLayout var27, ConstraintLayout var28, MaterialButton var29, NestedScrollView var30, Guideline var31, TextView var32, TextView var33, TextView var34, TextView var35, TextView var36, TextView var37, TextView var38, TextView var39, Toolbar var40, Barrier var41, View var42) {
      super(var1, var2, var3);
      this.bottomTimeBarrier = var4;
      this.buttonDeleteSchedule = var5;
      this.buttonEndTime = var6;
      this.buttonEndTimeLayout = var7;
      this.buttonStartTime = var8;
      this.buttonStartTimeLayout = var9;
      this.cancelBtn = var10;
      this.dashedLine = var11;
      this.editTextLabel = var12;
      this.endGuideline = var13;
      this.endTime = var14;
      this.groupAfterSchedule = var15;
      this.groupCustomSchedule = var16;
      this.groupLabelText = var17;
      this.layoutEditTextLabel = var18;
      this.progressView = var19;
      this.radioButtonCustom = var20;
      this.radioButtonPrevious = var21;
      this.radioGroupCustomScheduleSettings = var22;
      this.recyclerViewCustomSchedule = var23;
      this.recyclerViewDayPicker = var24;
      this.recyclerViewEndSchedule = var25;
      this.recyclerViewStartSchedule = var26;
      this.repeatContainer = var27;
      this.rootLayout = var28;
      this.saveBtn = var29;
      this.scrollable = var30;
      this.startGuideline = var31;
      this.startTime = var32;
      this.textViewSelectedDays = var33;
      this.textviewAfterSchedule = var34;
      this.textviewCustomSchedule = var35;
      this.textviewCustomScheduleDescription = var36;
      this.textviewLabel = var37;
      this.textviewRepeat = var38;
      this.title = var39;
      this.toolbar = var40;
      this.topTimeBarrier = var41;
      this.viewAfterSeparator = var42;
   }

   public static DialogfragmentDeviceCreateEditScheduleBinding bind(View var0) {
      return bind(var0, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static DialogfragmentDeviceCreateEditScheduleBinding bind(View var0, Object var1) {
      return (DialogfragmentDeviceCreateEditScheduleBinding)bind(var1, var0, R.layout.dialogfragment_device_create_edit_schedule);
   }

   public static DialogfragmentDeviceCreateEditScheduleBinding inflate(LayoutInflater var0) {
      return inflate(var0, DataBindingUtil.getDefaultComponent());
   }

   public static DialogfragmentDeviceCreateEditScheduleBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      return inflate(var0, var1, var2, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static DialogfragmentDeviceCreateEditScheduleBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2, Object var3) {
      return (DialogfragmentDeviceCreateEditScheduleBinding)ViewDataBinding.inflateInternal(var0, R.layout.dialogfragment_device_create_edit_schedule, var1, var2, var3);
   }

   @Deprecated
   public static DialogfragmentDeviceCreateEditScheduleBinding inflate(LayoutInflater var0, Object var1) {
      return (DialogfragmentDeviceCreateEditScheduleBinding)ViewDataBinding.inflateInternal(var0, R.layout.dialogfragment_device_create_edit_schedule, (ViewGroup)null, false, var1);
   }

   public DeviceCreateEditScheduleViewModel getDeviceCreateEditScheduleViewModel() {
      return this.mDeviceCreateEditScheduleViewModel;
   }

   public abstract void setDeviceCreateEditScheduleViewModel(DeviceCreateEditScheduleViewModel var1);
}
