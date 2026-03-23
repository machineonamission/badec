package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blueair.devicedetails.R;
import com.github.gzuliyujiang.wheelview.widget.WheelView;
import com.google.android.material.button.MaterialButton;

public abstract class DialogfragmentDeviceHTimerPickerBinding extends ViewDataBinding {
    public final ConstraintLayout contentContainer;
    public final LinearLayout contentContainerButton;
    public final WheelView timerPicker;
    public final MaterialButton timerPickerCancel;
    public final MaterialButton timerPickerDone;
    public final TextView title;

    protected DialogfragmentDeviceHTimerPickerBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, LinearLayout linearLayout, WheelView wheelView, MaterialButton materialButton, MaterialButton materialButton2, TextView textView) {
        super(obj, view, i);
        this.contentContainer = constraintLayout;
        this.contentContainerButton = linearLayout;
        this.timerPicker = wheelView;
        this.timerPickerCancel = materialButton;
        this.timerPickerDone = materialButton2;
        this.title = textView;
    }

    public static DialogfragmentDeviceHTimerPickerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogfragmentDeviceHTimerPickerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogfragmentDeviceHTimerPickerBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialogfragment_device_h_timer_picker, viewGroup, z, obj);
    }

    public static DialogfragmentDeviceHTimerPickerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogfragmentDeviceHTimerPickerBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogfragmentDeviceHTimerPickerBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialogfragment_device_h_timer_picker, (ViewGroup) null, false, obj);
    }

    public static DialogfragmentDeviceHTimerPickerBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogfragmentDeviceHTimerPickerBinding bind(View view, Object obj) {
        return (DialogfragmentDeviceHTimerPickerBinding) bind(obj, view, R.layout.dialogfragment_device_h_timer_picker);
    }
}
