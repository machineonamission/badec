package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.devicedetails.R;
import com.google.android.material.button.MaterialButton;

public abstract class DialogfragmentDeviceAlarmSoundPickerBinding extends ViewDataBinding {
    public final LinearLayout bottomBar;
    public final AppCompatImageButton btnClose;
    public final MaterialButton btnDone;
    public final ConstraintLayout contentContainer;
    public final RecyclerView rvList;
    public final View separator;
    public final TextView title;
    public final View vTop;

    protected DialogfragmentDeviceAlarmSoundPickerBinding(Object obj, View view, int i, LinearLayout linearLayout, AppCompatImageButton appCompatImageButton, MaterialButton materialButton, ConstraintLayout constraintLayout, RecyclerView recyclerView, View view2, TextView textView, View view3) {
        super(obj, view, i);
        this.bottomBar = linearLayout;
        this.btnClose = appCompatImageButton;
        this.btnDone = materialButton;
        this.contentContainer = constraintLayout;
        this.rvList = recyclerView;
        this.separator = view2;
        this.title = textView;
        this.vTop = view3;
    }

    public static DialogfragmentDeviceAlarmSoundPickerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogfragmentDeviceAlarmSoundPickerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogfragmentDeviceAlarmSoundPickerBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialogfragment_device_alarm_sound_picker, viewGroup, z, obj);
    }

    public static DialogfragmentDeviceAlarmSoundPickerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogfragmentDeviceAlarmSoundPickerBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogfragmentDeviceAlarmSoundPickerBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialogfragment_device_alarm_sound_picker, (ViewGroup) null, false, obj);
    }

    public static DialogfragmentDeviceAlarmSoundPickerBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogfragmentDeviceAlarmSoundPickerBinding bind(View view, Object obj) {
        return (DialogfragmentDeviceAlarmSoundPickerBinding) bind(obj, view, R.layout.dialogfragment_device_alarm_sound_picker);
    }
}
