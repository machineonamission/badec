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

    public abstract void setDeviceCreateEditScheduleViewModel(DeviceCreateEditScheduleViewModel deviceCreateEditScheduleViewModel);

    protected DialogfragmentDeviceCreateEditScheduleBinding(Object obj, View view, int i, Barrier barrier, MaterialButton materialButton, TextView textView, TextInputLayout textInputLayout, TextView textView2, TextInputLayout textInputLayout2, MaterialButton materialButton2, TextView textView3, TextInputEditText textInputEditText, Guideline guideline, TextView textView4, Group group, Group group2, Group group3, TextInputLayout textInputLayout3, ProgressBlockerView progressBlockerView, RadioButton radioButton, RadioButton radioButton2, RadioGroup radioGroup, RecyclerView recyclerView, RecyclerView recyclerView2, RecyclerView recyclerView3, RecyclerView recyclerView4, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, MaterialButton materialButton3, NestedScrollView nestedScrollView, Guideline guideline2, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, Toolbar toolbar2, Barrier barrier2, View view2) {
        super(obj, view, i);
        this.bottomTimeBarrier = barrier;
        this.buttonDeleteSchedule = materialButton;
        this.buttonEndTime = textView;
        this.buttonEndTimeLayout = textInputLayout;
        this.buttonStartTime = textView2;
        this.buttonStartTimeLayout = textInputLayout2;
        this.cancelBtn = materialButton2;
        this.dashedLine = textView3;
        this.editTextLabel = textInputEditText;
        this.endGuideline = guideline;
        this.endTime = textView4;
        this.groupAfterSchedule = group;
        this.groupCustomSchedule = group2;
        this.groupLabelText = group3;
        this.layoutEditTextLabel = textInputLayout3;
        this.progressView = progressBlockerView;
        this.radioButtonCustom = radioButton;
        this.radioButtonPrevious = radioButton2;
        this.radioGroupCustomScheduleSettings = radioGroup;
        this.recyclerViewCustomSchedule = recyclerView;
        this.recyclerViewDayPicker = recyclerView2;
        this.recyclerViewEndSchedule = recyclerView3;
        this.recyclerViewStartSchedule = recyclerView4;
        this.repeatContainer = constraintLayout;
        this.rootLayout = constraintLayout2;
        this.saveBtn = materialButton3;
        this.scrollable = nestedScrollView;
        this.startGuideline = guideline2;
        this.startTime = textView5;
        this.textViewSelectedDays = textView6;
        this.textviewAfterSchedule = textView7;
        this.textviewCustomSchedule = textView8;
        this.textviewCustomScheduleDescription = textView9;
        this.textviewLabel = textView10;
        this.textviewRepeat = textView11;
        this.title = textView12;
        this.toolbar = toolbar2;
        this.topTimeBarrier = barrier2;
        this.viewAfterSeparator = view2;
    }

    public DeviceCreateEditScheduleViewModel getDeviceCreateEditScheduleViewModel() {
        return this.mDeviceCreateEditScheduleViewModel;
    }

    public static DialogfragmentDeviceCreateEditScheduleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogfragmentDeviceCreateEditScheduleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogfragmentDeviceCreateEditScheduleBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialogfragment_device_create_edit_schedule, viewGroup, z, obj);
    }

    public static DialogfragmentDeviceCreateEditScheduleBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogfragmentDeviceCreateEditScheduleBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogfragmentDeviceCreateEditScheduleBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialogfragment_device_create_edit_schedule, (ViewGroup) null, false, obj);
    }

    public static DialogfragmentDeviceCreateEditScheduleBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogfragmentDeviceCreateEditScheduleBinding bind(View view, Object obj) {
        return (DialogfragmentDeviceCreateEditScheduleBinding) bind(obj, view, R.layout.dialogfragment_device_create_edit_schedule);
    }
}
