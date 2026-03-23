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
import com.blueair.devicedetails.view.CustomWheelView;
import com.google.android.material.button.MaterialButton;

public abstract class DialogfragmentTimePickerV2Binding extends ViewDataBinding {
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
    public final CustomWheelView wheelAmPm;
    public final CustomWheelView wheelHour;
    public final CustomWheelView wheelMinute;

    protected DialogfragmentTimePickerV2Binding(Object obj, View view, int i, AppCompatImageButton appCompatImageButton, MaterialButton materialButton, ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, TextView textView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, View view2, CustomWheelView customWheelView, CustomWheelView customWheelView2, CustomWheelView customWheelView3) {
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
        this.wheelAmPm = customWheelView;
        this.wheelHour = customWheelView2;
        this.wheelMinute = customWheelView3;
    }

    public static DialogfragmentTimePickerV2Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogfragmentTimePickerV2Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogfragmentTimePickerV2Binding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialogfragment_time_picker_v2, viewGroup, z, obj);
    }

    public static DialogfragmentTimePickerV2Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogfragmentTimePickerV2Binding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogfragmentTimePickerV2Binding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialogfragment_time_picker_v2, (ViewGroup) null, false, obj);
    }

    public static DialogfragmentTimePickerV2Binding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogfragmentTimePickerV2Binding bind(View view, Object obj) {
        return (DialogfragmentTimePickerV2Binding) bind(obj, view, R.layout.dialogfragment_time_picker_v2);
    }
}
