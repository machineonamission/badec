package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blueair.devicedetails.R;
import com.github.gzuliyujiang.wheelview.widget.WheelView;
import com.google.android.material.button.MaterialButton;

public abstract class DialogfragmentDeviceTimerPickerV2Binding extends ViewDataBinding {
    public final AppCompatImageButton btnClose;
    public final MaterialButton btnDone;
    public final ConstraintLayout contentContainer;
    public final AppCompatImageView ivScaleMaskLeft;
    public final AppCompatImageView ivScaleMaskRight;
    public final TextView title;
    public final AppCompatTextView tvColon;
    public final AppCompatTextView tvHours;
    public final AppCompatTextView tvMins;
    public final View vTop;
    public final WheelView wheelHour;
    public final WheelView wheelMinute;

    protected DialogfragmentDeviceTimerPickerV2Binding(Object obj, View view, int i, AppCompatImageButton appCompatImageButton, MaterialButton materialButton, ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, TextView textView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, View view2, WheelView wheelView, WheelView wheelView2) {
        super(obj, view, i);
        this.btnClose = appCompatImageButton;
        this.btnDone = materialButton;
        this.contentContainer = constraintLayout;
        this.ivScaleMaskLeft = appCompatImageView;
        this.ivScaleMaskRight = appCompatImageView2;
        this.title = textView;
        this.tvColon = appCompatTextView;
        this.tvHours = appCompatTextView2;
        this.tvMins = appCompatTextView3;
        this.vTop = view2;
        this.wheelHour = wheelView;
        this.wheelMinute = wheelView2;
    }

    public static DialogfragmentDeviceTimerPickerV2Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogfragmentDeviceTimerPickerV2Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogfragmentDeviceTimerPickerV2Binding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialogfragment_device_timer_picker_v2, viewGroup, z, obj);
    }

    public static DialogfragmentDeviceTimerPickerV2Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogfragmentDeviceTimerPickerV2Binding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogfragmentDeviceTimerPickerV2Binding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialogfragment_device_timer_picker_v2, (ViewGroup) null, false, obj);
    }

    public static DialogfragmentDeviceTimerPickerV2Binding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogfragmentDeviceTimerPickerV2Binding bind(View view, Object obj) {
        return (DialogfragmentDeviceTimerPickerV2Binding) bind(obj, view, R.layout.dialogfragment_device_timer_picker_v2);
    }
}
